/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
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
import javax.xml.namespace.QName;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.container.EventCoordinationService;
import org.apache.pluto.container.PortletContainer;
import org.apache.pluto.container.PortletContainerException;
import org.apache.pluto.container.PortletWindow;
import org.apache.pluto.container.driver.PlutoServices;
import org.apache.pluto.container.driver.PortletContextService;
import org.apache.pluto.container.driver.PortletRegistryService;
import org.apache.pluto.container.om.portlet.EventDefinition;
import org.apache.pluto.container.om.portlet.EventDefinitionReference;
import org.apache.pluto.container.om.portlet.PortletApplicationDefinition;
import org.apache.pluto.container.om.portlet.PortletDefinition;
import org.apache.pluto.driver.AttributeKeys;
import org.apache.pluto.driver.config.DriverConfiguration;
import org.apache.pluto.driver.core.PortalRequestContext;
import org.apache.pluto.driver.core.PortletWindowImpl;
import org.apache.pluto.driver.services.portal.PageConfig;
import org.apache.pluto.driver.services.portal.PortletWindowConfig;
import org.apache.pluto.driver.url.PortalURL;
import org.apache.pluto.driver.url.impl.PortalURLParserImpl;

public class EventCoordinationServiceImpl implements EventCoordinationService
{
	/** Logger. */
	private static final Log LOG = LogFactory.getLog(EventCoordinationServiceImpl.class);

	private static final long WAITING_CYCLE = 100;

	/** PortletRegistryService used to obtain PortletApplicationConfig objects */
	private PortletRegistryService portletRegistry;

	/** PortletContextService used to obtain PortletContext objects */
    private PortletContextService portletContextService;
    
    public void processEvents(PortletContainer container, PortletWindow portletWindow, HttpServletRequest request,
                              HttpServletResponse response, List<Event> events)
    {
        if (portletRegistry == null)
        {
            portletRegistry = PlutoServices.getServices().getPortletRegistryService();
        }
        if (portletContextService == null)
        {
            portletContextService = PlutoServices.getServices().getPortletContextService();
        }
        
        ServletContext containerServletContext = PortalRequestContext.getContext(request).getServletContext();
		DriverConfiguration driverConfig = (DriverConfiguration) containerServletContext
				.getAttribute(AttributeKeys.DRIVER_CONFIG);

		PortalURL portalURL = PortalURLParserImpl.getParser().parse(request);

	    Map<String, PortletWindowThread> portletWindowThreads = new HashMap<String, PortletWindowThread>();

	    ThreadGroup threadGroup = new ThreadGroup("FireEventThreads");

		for (Event event : events)
		{
			List<String> portletNames = getAllPortletsRegisteredForEvent(
					event, driverConfig, containerServletContext);

			Collection<PortletWindowConfig> portlets = getAllPortlets(driverConfig);

			// iterate all portlets in the portal
			for (PortletWindowConfig config : portlets) {
				PortletWindow window = new PortletWindowImpl(container, config, portalURL);
				if (portletNames != null) {
					for (String portlet : portletNames) {
						if (portlet.equals(config.getId())) {

							// the thread now is a new one, with possible
							// waiting,
							// for the old to exit
							

							PortletWindowThread portletWindowThread = getPortletWindowThread(portletWindowThreads,
									threadGroup, container, config, window, request, response, containerServletContext);

							// is this event
							portletWindowThread.addEvent(event);

							portletWindowThread.start();
						}
					}
				}
			}
			waitForEventExecution(threadGroup);
			try {
				Thread.sleep(WAITING_CYCLE);
			} catch (InterruptedException e) {
				LOG.warn(e);
			}
		}
		waitForEventExecution(threadGroup);
	}

	private List<String> getAllPortletsRegisteredForEvent(Event event,
			DriverConfiguration driverConfig, ServletContext containerServletContext) {
		Set<String> resultSet = new HashSet<String>();
		List<String> resultList = new ArrayList<String>();
		QName eventName = event.getQName();
		Collection<PortletWindowConfig> portlets = getAllPortlets(driverConfig);

		for (PortletWindowConfig portlet : portlets) {
			String contextPath = portlet.getContextPath();
            String applicationName = contextPath;
            if (applicationName.length() >0 )
            {
                applicationName = applicationName.substring(1);
            }
			PortletApplicationDefinition portletAppDD = null;
			try {
				portletAppDD = portletRegistry.getPortletApplication(applicationName);
				List<? extends PortletDefinition> portletDDs = portletAppDD.getPortlets();
				List<QName> aliases = getAllAliases(eventName, portletAppDD);
				for (PortletDefinition portletDD : portletDDs) {
					List<? extends EventDefinitionReference> processingEvents = portletDD.getSupportedProcessingEvents();
					if (isEventSupported(processingEvents, eventName, portletAppDD.getDefaultNamespace())) {
                        if (portletDD.getPortletName().equals(portlet.getPortletName())) {
                                                          resultSet.add(portlet.getId());
                        }
					} else {

						if (processingEvents != null) {
							for (EventDefinitionReference ref : processingEvents) {
							    QName name = ref.getQualifiedName(portletAppDD.getDefaultNamespace());
							    if (name == null)
							    {
							        continue;
							    }
								// add also grouped portlets, that ends with "."
								if (name.toString().endsWith(".")
										&& eventName.toString().startsWith(name.toString())
										&& portletDD.getPortletName().equals(portlet.getPortletName())) {
									resultSet.add(portlet.getId());
								}
								// also look for alias names:
								if (aliases != null) {
									for (QName alias : aliases) {
										if (alias.toString().equals(name.toString())
												&& portletDD.getPortletName().equals(portlet.getPortletName())) {
											resultSet.add(portlet.getId());
										}
									}
								}
								// also look for default namespaced events
								if (name.getNamespaceURI() == null || name.getNamespaceURI().equals("")) {
									String defaultNamespace = portletAppDD.getDefaultNamespace();
									QName qname = new QName(defaultNamespace, name.getLocalPart());
									if (eventName.toString().equals(qname.toString())
											&& portletDD.getPortletName().equals(portlet.getPortletName())) {
										resultSet.add(portlet.getId());
									}
								}
							}
						}
					}
				}
			} catch (PortletContainerException e) {
				LOG.warn(e);
			}
		}

		// make list
		for (String name : resultSet) {
			resultList.add(name);
		}
		return resultList;
	}
	
	private boolean isEventSupported(List<? extends EventDefinitionReference> supportedEvents, QName eventName, String defaultNamespace)
	{
	    if (supportedEvents != null)
	    {
	        for (EventDefinitionReference ref : supportedEvents)
	        {
	            QName refQName = ref.getQualifiedName(defaultNamespace);
	            if (refQName != null && refQName.equals(eventName))
	            {
	                return true;
	            }
	        }
	    }
	    return false;
	}

	private List<QName> getAllAliases(QName eventName, PortletApplicationDefinition portletAppDD) {
		if (portletAppDD.getEventDefinitions() != null) {
			
			for (EventDefinition def : portletAppDD.getEventDefinitions()){
			    QName defQName = def.getQualifiedName(portletAppDD.getDefaultNamespace());
				if (defQName != null && defQName.equals(eventName)){
						return def.getAliases();
				}
			}
		}
		return null;
	}

	/**
	 * gets the right PortletWindowThread or makes a new one, if theres none
	 * 
	 */
	private PortletWindowThread getPortletWindowThread(Map<String, PortletWindowThread> portletWindowThreads, ThreadGroup threadGroup,
			PortletContainer container, PortletWindowConfig config,
			PortletWindow window, HttpServletRequest req, HttpServletResponse res, ServletContext containerServletContext)
	{
        String windowID = window.getId().getStringId();
        PortletWindowThread portletWindowThread = portletWindowThreads
                .get(windowID);
        if (portletWindowThread == null) {
            portletWindowThread = new PortletWindowThread(threadGroup, config.getId(),
                                                          container, window, 
                                                          req, res, portletContextService);
            portletWindowThreads.put(windowID, portletWindowThread);
        } else {
            // a thread could be started twice, so we make a new one,
            // after the old thread stopped
            // try {
            try {
                portletWindowThread.join();
            } catch (InterruptedException e) {
                LOG.warn(e);
            }
            portletWindowThreads.remove(portletWindowThread);
            portletWindowThread = new PortletWindowThread(threadGroup, config.getId(),
                                                          container, window, 
                                                          req, res, portletContextService);
            portletWindowThreads.put(windowID, portletWindowThread);
        }
        return portletWindowThread;
	}

	/**
	 * Wait for event execution.
	 */
	private void waitForEventExecution(ThreadGroup threadGroup) {
		long counter = 0;
		while (threadGroup.activeCount() > 0) {
			try {
				counter = +WAITING_CYCLE;
				if (counter > 500) {
					threadGroup.stop();
				}
				Thread.sleep(WAITING_CYCLE);
			} catch (InterruptedException e) {
				LOG.warn(e);
			}
		}
	}

	/**
	 * 
	 */
	private Collection<PortletWindowConfig> getAllPortlets(DriverConfiguration driverConfig)
	{
		Collection<PortletWindowConfig> portlets = new ArrayList<PortletWindowConfig>();
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
		return portlets;
	}
}
