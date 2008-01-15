/*
 * Copyright 2006 The Apache Software Foundation.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.pluto.driver.services.container;

import java.io.Serializable;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.portlet.Event;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import javax.xml.stream.FactoryConfigurationError;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.Constants;
import org.apache.pluto.EventContainer;
import org.apache.pluto.PortletContainer;
import org.apache.pluto.PortletContainerException;
import org.apache.pluto.PortletWindow;
import org.apache.pluto.core.PortletContainerImpl;
import org.apache.pluto.descriptors.portlet.EventDefinitionDD;
import org.apache.pluto.descriptors.portlet.PortletAppDD;
import org.apache.pluto.descriptors.portlet.PortletDD;
import org.apache.pluto.driver.AttributeKeys;
import org.apache.pluto.driver.config.DriverConfiguration;
import org.apache.pluto.driver.core.PortalRequestContext;
import org.apache.pluto.driver.core.PortletWindowImpl;
import org.apache.pluto.driver.services.portal.PageConfig;
import org.apache.pluto.driver.services.portal.PortletWindowConfig;
import org.apache.pluto.driver.url.PortalURL;
import org.apache.pluto.driver.url.impl.PortalURLParserImpl;
import org.apache.pluto.internal.InternalPortletWindow;
import org.apache.pluto.internal.impl.EventImpl;
import org.apache.pluto.internal.impl.InternalPortletWindowImpl;
import org.apache.pluto.spi.EventProvider;
import org.apache.pluto.spi.optional.PortletRegistryService;

public class EventProviderImpl implements org.apache.pluto.spi.EventProvider,
		Cloneable {

	private static final int DEFAULT_MAPSIZE = 10;

	/** Logger. */
	private static final Log LOG = LogFactory.getLog(EventProviderImpl.class);

	private static final long WAITING_CYCLE = 100;

	private HttpServletRequest request;

	private HttpServletResponse response;

	private PortletContainer container;

	private PortletWindow portletWindow;

	ThreadGroup threadGroup = new ThreadGroup("FireEventThreads");

	private EventList savedEvents = new EventList();

	private Map<String, PortletWindowThread> portletWindowThreads = new HashMap<String, PortletWindowThread>();

	/** PortletRegistryService used to obtain PortletApplicationConfig objects */
	private PortletRegistryService portletRegistry;

	/**
	 * factory method gets the EventProvider out of the Request, or sets a new
	 * one
	 * 
	 * @param request
	 *            The {@link HttpServletRequest} of the EventProvider
	 * @param response
	 *            The {@link HttpServletResponse} of the EventProvider
	 * @return The corresponding EventProvierImpl instance
	 */
	public static EventProviderImpl getEventProviderImpl(
			HttpServletRequest request, PortletWindow portletWindow) {
		EventProviderImpl eventProvider = (EventProviderImpl) request
				.getAttribute(Constants.PROVIDER);
		if (eventProvider == null) {
			eventProvider = new EventProviderImpl();
			eventProvider.request = request;
			PortalRequestContext context = PortalRequestContext
					.getContext(request);
			eventProvider.response = context.getResponse();
			ServletContext servletContext = context.getServletContext();
			eventProvider.container = (PortletContainer) servletContext
					.getAttribute(AttributeKeys.PORTLET_CONTAINER);
			request.setAttribute(Constants.PROVIDER, eventProvider);
		}
		try {
			eventProvider = (EventProviderImpl) eventProvider.clone();
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException(e);
		}
		eventProvider.portletWindow = portletWindow;
		return eventProvider;
	}

	/**
	 * factory method, for accessing the static elements without a request /
	 * 
	 * @return The EventProvider for accessing the static elements
	 */
	public static EventProvider getEventProviderImpl() {
		return new EventProviderImpl();
	}

	/**
	 * c'tor
	 */
	private EventProviderImpl() {

	}

	/**
	 * Register an event, which should be fired within that request
	 * 
	 * @param qname
	 * @param value
	 * @throws {@link IllegalArgumentException}
	 */
	public void registerToFireEvent(QName qname, Serializable value)
			throws IllegalArgumentException {
		if (isDeclaredAsPublishingEvent(qname)) {

			if (value != null && !isValueInstanceOfDefinedClass(qname, value))
				throw new IllegalArgumentException(
						"Payload has not the right class");

			try {

				if (value == null) {
					savedEvents.addEvent(new EventImpl(qname, value));
				} else if (!(value instanceof Serializable)) {
					throw new IllegalArgumentException(
							"Object payload must implement Serializable");
				} else {

					Class clazz = value.getClass();

					JAXBContext jc = JAXBContext.newInstance(clazz);

					Marshaller marshaller = jc.createMarshaller();

					Writer out = new StringWriter();

					JAXBElement<Serializable> element = new JAXBElement<Serializable>(
							qname, clazz, value);
					marshaller.marshal(element, out);
					// marshaller.marshal(value, out);

					if (out != null) {
						savedEvents.addEvent(new EventImpl(qname,
								(Serializable) out.toString()));
					} else {
						savedEvents.addEvent(new EventImpl(qname, value));
					}
				}
			} catch (JAXBException e) {
				// maybe there is no valid jaxb binding
				// wsrp:eventHandlingFailed
				LOG.error("Event handling failed", e);
			} catch (FactoryConfigurationError e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Fire all saved events Note, that the order isn't important
	 * 
	 * @see PLT14.3.2
	 * @param eventContainer
	 *            The {@link PortletContainerImpl} to fire the events
	 */
	public void fireEvents(EventContainer eventContainer) {
		ServletContext servletContext = eventContainer.getServletContext();
		DriverConfiguration driverConfig = (DriverConfiguration) servletContext
				.getAttribute(AttributeKeys.DRIVER_CONFIG);

		PortalURL portalURL = PortalURLParserImpl.getParser().parse(request);

		while (savedEvents.hasMoreEvents()
				&& savedEvents.getSize() < Constants.MAX_EVENTS_SIZE) {

			Event eActual = getArbitraryEvent();

			this.savedEvents.setProcessed(eActual);

			List<String> portletNames = getAllPortletsRegisteredForEvent(
					eActual, driverConfig);

			Collection<PortletWindowConfig> portlets = getAllPortlets(driverConfig);

			// iterate all portlets in the portal
			for (PortletWindowConfig config : portlets) {
				PortletWindow window = new PortletWindowImpl(config, portalURL);
				if (portletNames != null) {
					for (String portlet : portletNames) {
						if (portlet.equals(config.getId())) {

							// the thread now is a new one, with possible
							// waiting,
							// for the old to exit
							

							PortletWindowThread portletWindowThread = getPortletWindowThread(
									eventContainer, config, window);

							// is this event
							portletWindowThread.addEvent(eActual);

							portletWindowThread.start();
						}
					}
				}
			}
			waitForEventExecution();
			try {
				Thread.sleep(WAITING_CYCLE);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		waitForEventExecution();
	}

	private List<String> getAllPortletsRegisteredForEvent(Event event,
			DriverConfiguration driverConfig) {
		Set<String> resultSet = new HashSet<String>();
		List<String> resultList = new ArrayList<String>();
		QName eventName = event.getQName();
		Collection<PortletWindowConfig> portlets = getAllPortlets(driverConfig);

		for (PortletWindowConfig portlet : portlets) {
			String contextPath = portlet.getContextPath();
			PortletAppDD portletAppDD = null;
			try {
				portletAppDD = container
						.getPortletApplicationDescriptor(contextPath);
				List<PortletDD> portletDDs = portletAppDD.getPortlets();
				List<QName> aliases = getAllAliases(eventName, portletAppDD);
				for (PortletDD portletDD : portletDDs) {
					List<QName> processingEvents = portletDD
							.getProcessingEvents();
					if ((processingEvents != null)
							&& processingEvents.contains(eventName)) {
						if (portletDD.getPortletName().equals(
								portlet.getPortletName())) {
							resultSet.add(portlet.getId());
						}
					} else {

						if (processingEvents != null) {
							for (QName name : processingEvents) {
								// add also grouped portlets, that ends with "."
								if (name.toString().endsWith(".")
										&& eventName.toString().startsWith(
												name.toString())
										&& portletDD.getPortletName().equals(
												portlet.getPortletName())) {
									resultSet.add(portlet.getId());
								}
								// also look for alias names:
								if (aliases != null) {
									for (QName alias : aliases) {
										if (alias.toString().equals(
												name.toString())
												&& portletDD
														.getPortletName()
														.equals(
																portlet
																		.getPortletName())) {
											resultSet.add(portlet.getId());
										}
									}
								}
								// also look for default namespaced events
								if (name.getNamespaceURI() == null
										|| name.getNamespaceURI().equals("")) {
									String defaultNamespace = portletAppDD
											.getDefaultNamespace();
									QName qname = new QName(defaultNamespace,
											name.getLocalPart());
									if (eventName.toString().equals(
											qname.toString())
											&& portletDD
													.getPortletName()
													.equals(
															portlet
																	.getPortletName())) {
										resultSet.add(portlet.getId());
									}
								}
							}
						}
					}
				}
			} catch (PortletContainerException e) {
				e.printStackTrace();
			}
		}

		// make list
		for (String name : resultSet) {
			resultList.add(name);
		}
		return resultList;
	}

	private List<QName> getAllAliases(QName eventName, PortletAppDD portletAppDD) {
		if (portletAppDD.getEvents() != null) {
			
			for (EventDefinitionDD def : portletAppDD.getEvents()){
				if (def.getQName() != null){
					if (def.getQName().equals(eventName))
						return def.getAlias();
				}
				else{
					QName tmp = new QName(portletAppDD.getDefaultNamespace(),def.getName());
					if (tmp.equals(eventName))
						return def.getAlias();
				}
			}
		}
		return null;
	}

	/**
	 * gets the right PortletWindowThread or makes a new one, if theres none
	 * 
	 * @param eventContainer
	 * @param config
	 * @param window
	 * @return
	 */
	private PortletWindowThread getPortletWindowThread(
			EventContainer eventContainer, PortletWindowConfig config,
			PortletWindow window) {
		ServletContext servletContext = eventContainer.getServletContext();
		if (portletRegistry == null) {
			portletRegistry = ((PortletContainer) servletContext
					.getAttribute(AttributeKeys.PORTLET_CONTAINER))
					.getOptionalContainerServices().getPortletRegistryService();
		}
		if (portletRegistry != null){
			String windowID = window.getId().getStringId();
			PortletWindowThread portletWindowThread = portletWindowThreads
					.get(windowID);
			if (portletWindowThread == null) {
				portletWindowThread = new PortletWindowThread(threadGroup, config
						.getId(), this, window, eventContainer,portletRegistry);
				portletWindowThreads.put(windowID, portletWindowThread);
			} else {
				// a thread could be started twice, so we make a new one,
				// after the old thread stopped
				// try {
				try {
					portletWindowThread.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				portletWindowThreads.remove(portletWindowThread);
				portletWindowThread = new PortletWindowThread(threadGroup, config
						.getId(), this, window, eventContainer,portletRegistry);
				portletWindowThreads.put(windowID, portletWindowThread);
			}
			return portletWindowThread;
		}
		else 
			return null;
	}

	/**
	 * Wait for event execution.
	 */
	private void waitForEventExecution() {
		long counter = 0;
		while (threadGroup.activeCount() > 0) {
			try {
				counter = +WAITING_CYCLE;
				if (counter > 500) {
					threadGroup.stop();
				}
				Thread.sleep(WAITING_CYCLE);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * gets an arbitrary event, which is not processed yet.
	 * 
	 * @return the arbitrary event
	 */
	private Event getArbitraryEvent() {
		Event eActual = null;
		for (Event event : this.savedEvents.getEvents()) {
			if (this.savedEvents.isNotProcessed(event)) {
				eActual = event;
			}
		}
		return eActual;
	}

	/**
	 * 
	 */
	private Collection<PortletWindowConfig> getAllPortlets(
			DriverConfiguration driverConfig) {
		Collection<PortletWindowConfig> portlets = new ArrayList<PortletWindowConfig>();
		ServletContext servletContext = PortalRequestContext
			.getContext(request).getServletContext();
//		if (portletRegistry == null) {
//			portletRegistry = ((PortletContainer) servletContext
//					.getAttribute(AttributeKeys.PORTLET_CONTAINER))
//					.getOptionalContainerServices().getPortletRegistryService();
//		}
//		if (portletRegistry != null){
			Collection pages = driverConfig.getPages();
			if (pages != null){
				Iterator iPages = pages.iterator();
				while(iPages.hasNext()){
					PageConfig pageConfig = (PageConfig) iPages.next();
					Collection portletIDs = pageConfig.getPortletIds();
					if (portletIDs != null){
						Iterator iPortletIDs = portletIDs.iterator();
						while(iPortletIDs.hasNext()){
							portlets.add(PortletWindowConfig.fromId(iPortletIDs.next().toString()));
						}
					}
				}
			}
			
//			PortletWindowConfig.fromId(((PageConfig)driverConfig.getPages().iterator().next()).getPortletIds().iterator().next().toString());
//			Iterator i = portletRegistry.getRegisteredPortletApplications();
//			while(i.hasNext()){
//				portlets.addAll(((PortletAppDD)portletRegistry.getRegisteredPortletApplications().next()).getPortlets());
//			}
//		}

		// Collection<PortletApplicationConfig> apps =
		// driverConfig.getPortletApplications();
		
		// for (PortletApplicationConfig app : apps) {
		// portlets.addAll(app.getPortlets());
		// }
		return portlets;
	}

	/**
	 * @return the request
	 */
	public HttpServletRequest getRequest() {
		return request;
	}

	/**
	 * @return the response
	 */
	public HttpServletResponse getResponse() {
		return response;
	}

	/**
	 * Gets the saved events.
	 * 
	 * @return the saved events
	 */
	public EventList getSavedEvents() {
		return savedEvents;
	}

	private boolean isDeclaredAsPublishingEvent(QName qname) {
		ServletContext servletContext = PortalRequestContext
				.getContext(request).getServletContext();
		InternalPortletWindow internalPortletWindow = new InternalPortletWindowImpl(
				servletContext, this.portletWindow);
		String applicationId = PortletWindowConfig
				.parseContextPath(internalPortletWindow.getId().getStringId());
		String portletName = PortletWindowConfig
				.parsePortletName(internalPortletWindow.getId().getStringId());
		if (portletRegistry == null) {
			portletRegistry = ((PortletContainer) servletContext
					.getAttribute(AttributeKeys.PORTLET_CONTAINER))
					.getOptionalContainerServices().getPortletRegistryService();
		}
		List<QName> events = null;
		try {
			events = portletRegistry.getPortletDescriptor(applicationId,
					portletName).getPublishingEvents();
		} catch (PortletContainerException e1) {
			e1.printStackTrace();
		}
		if (events != null) {
			String contextPath = portletWindow.getContextPath();
			try {
				PortletAppDD portletAppDD = container
						.getPortletApplicationDescriptor(contextPath);
				String defaultNamespace = portletAppDD.getDefaultNamespace();
				if (defaultNamespace == null) {
					defaultNamespace = XMLConstants.NULL_NS_URI;
				}
				for (QName name : events) {
					String namespaceURI = name.getNamespaceURI();
					if (XMLConstants.NULL_NS_URI.equals(namespaceURI)) {
						name = new QName(defaultNamespace, name.getLocalPart());
					}
					if (qname.equals(name)) {
						return true;
					}
				}
			} catch (PortletContainerException e) {
				LOG.error(qname, e);
			}
		}
		return false;
	}

	private boolean isValueInstanceOfDefinedClass(QName qname,
			Serializable value) {
		PortletAppDD portletAppDD = null;
		try {
			portletAppDD = container
					.getPortletApplicationDescriptor(portletWindow
							.getContextPath());
			if (portletAppDD.getEvents() != null) {
				
				
				for (EventDefinitionDD def : portletAppDD.getEvents()){
					if (def.getQName() != null){
						if (def.getQName().equals(qname))
							return value.getClass().getName().equals(
									def.getJavaClass());
					}
					else{
						QName tmp = new QName(portletAppDD.getDefaultNamespace(),def.getName());
						if (tmp.equals(qname))
							return value.getClass().getName().equals(
									def.getJavaClass());
					}
				}
			}
		} catch (PortletContainerException e) {
			LOG.error(qname, e);
		}
		// event not declared
		return true;
	}

}
