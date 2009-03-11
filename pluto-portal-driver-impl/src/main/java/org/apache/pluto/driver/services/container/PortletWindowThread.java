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

import java.io.IOException;
import java.io.Serializable;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.Event;
import javax.portlet.PortletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.container.EventContainer;
import org.apache.pluto.container.PortletContainerException;
import org.apache.pluto.container.PortletWindow;
import org.apache.pluto.container.driver.PortletContextService;
import org.apache.pluto.container.om.portlet.EventDefinition;
import org.apache.pluto.container.om.portlet.PortletApplicationDefinition;
import org.apache.pluto.driver.core.PortalServletRequest;

public class PortletWindowThread extends Thread {
	
	/** Logger. */
    private static final Log LOG = LogFactory.getLog(PortletWindowThread.class);
    
	private EventProviderImpl eventProvider;
	
	private PortletWindow portletWindow;
	
	private EventContainer eventContainer;
	
	/** PortletRegistryService used to obtain PortletApplicationConfig objects */
	private PortletContextService portletContextService;
	
	private List<Event> events = new ArrayList<Event>();

	public PortletWindowThread(ThreadGroup group, String name,
			EventProviderImpl eventProvider, PortletWindow window, EventContainer eventContainer, PortletContextService portletContextService) {
		super(group, name);
		this.eventProvider = eventProvider;
		this.portletWindow = window;
		this.eventContainer = eventContainer;
		this.portletContextService = portletContextService;
	}

	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		super.run();
		while (events.size() > 0) {
			HttpServletRequest req = new PortalServletRequest(eventProvider.getRequest(), this.portletWindow);
			HttpServletResponse res = eventProvider.getResponse();
			try {
//				synchronized (this) {
					Event event = events.remove(0);
			        Object value = event.getValue();
			        
			        XMLStreamReader xml = null;
					try {
						if (value instanceof String) {
							String in = (String) value; 
							xml = XMLInputFactory.newInstance().createXMLStreamReader(new StringReader(in));
						}			
					}  
					catch (XMLStreamException e1) {
						throw new IllegalStateException(e1);
					} catch (FactoryConfigurationError e1) {
						throw new IllegalStateException(e1);
					}
			        
			        if (xml != null) {
			        	//XMLStreamReader xml = (XMLStreamReader) event.getValue();
			        	
			        		//provider.getEventDefinition(event.getQName());
			        	try {
			        		// now test if object is jaxb
			        		EventDefinition eventDefinitionDD = getEventDefintion(event.getQName()); 
			        		
			        		ClassLoader loader = portletContextService.getClassLoader(portletWindow.getPortletEntity().getPortletDefinition().getApplication().getName());
			        		Class<? extends Serializable> clazz = loader.loadClass(eventDefinitionDD.getValueType()).asSubclass(Serializable.class);

			        		JAXBContext jc = JAXBContext.newInstance(clazz);
			        		Unmarshaller unmarshaller  = jc.createUnmarshaller();

//			        		unmarshaller.setEventHandler(new javax.xml.bind.helpers.DefaultValidationEventHandler());

			        		JAXBElement result = unmarshaller.unmarshal(xml,clazz);

			        		event =  new EventImpl(event.getQName(),(Serializable) result.getValue());
			        	} catch (JAXBException e) {
			        		throw new IllegalStateException(e);
			        	} catch (ClassCastException e) {
			        		throw new IllegalStateException(e);
			        	} catch (ClassNotFoundException e) {
			        		throw new IllegalStateException(e);
			        	} catch (PortletContainerException e) {
			        		throw new IllegalStateException(e);
						}
			        }					
					eventContainer.fireEvent(req, res, portletWindow, event);	
//				}
			} catch (PortletException e) {
				LOG.warn(e);
			} catch (IOException e) {
				LOG.warn(e);
			} catch (PortletContainerException e) {
				LOG.warn(e);
			}	
		}
	}

	public void addEvent(Event event) {
		this.events.add(event);	
	}

	private EventDefinition getEventDefintion(QName name) throws PortletContainerException {
		PortletApplicationDefinition appDD = portletWindow.getPortletEntity().getPortletDefinition().getApplication();
		for (EventDefinition def : appDD.getEventDefinitions()){
			if (def.getQName() != null){
				if (def.getQName().equals(name))
					return def;
			}
			else{
				QName tmp = new QName(appDD.getDefaultNamespace(),def.getName());
				if (tmp.equals(name))
					return def;
			}
		}
		throw new IllegalStateException();
	}

}
