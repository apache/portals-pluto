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
package org.apache.pluto.internal.impl;


import javax.portlet.Event;
import javax.portlet.EventRequest;
import javax.portlet.PortletPreferences;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLStreamReader;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.Constants;
import org.apache.pluto.PortletContainer;
import org.apache.pluto.descriptors.portlet.EventDefinitionDD;
import org.apache.pluto.internal.InternalEventRequest;
import org.apache.pluto.internal.InternalPortletWindow;
import org.apache.pluto.spi.EventProvider;

/**
 * <code>javax.portlet.EventRequest</code> implementation.
 * This class also implements InternalEventRequest.
 *
 * @author <a href="mailto:chrisra@cs.uni-jena.de">Christian Raschka</a>
 */
public class EventRequestImpl extends PortletRequestImpl 
		implements EventRequest, InternalEventRequest {

	/** Logger. */
    private static final Log LOG = LogFactory.getLog(ActionRequestImpl.class);
	
	//	 Private Member Variables ------------------------------------------------	
    
	/** FIXME: The portlet preferences. 
	 * @see (ActionRequestImpl) 
	 */
	private PortletPreferences portletPreferences = null;
	
	private Event event; 
	
	//	 Constructor -------------------------------------------------------------
    
    public EventRequestImpl(PortletContainer container,
                             InternalPortletWindow internalPortletWindow,
                             HttpServletRequest servletRequest, Event event) {
        super(container, internalPortletWindow, servletRequest);
        this.event = event;
        if (LOG.isDebugEnabled()) {
        	LOG.debug("Created Event request for: " + internalPortletWindow);
        }
   
    }
    
    //  EventRequest impl -------------------------------------------------------
    
    public Event getEvent(){
        EventProvider provider = 
        	(EventProvider) this.getRequest().getAttribute(Constants.PROVIDER);

        Object value = event.getValue();
        if (value instanceof XMLStreamReader) {
        	XMLStreamReader xml = (XMLStreamReader) event.getValue();
        	EventDefinitionDD eventDefinitionDD = provider.getEventDefinition(event.getQName());
        	try {
        		// now test if object is jaxb

        		ClassLoader loader = Thread.currentThread().getContextClassLoader();
        		Class clazz = loader.loadClass(eventDefinitionDD.getJavaClass());

        		JAXBContext jc = JAXBContext.newInstance(clazz);
        		Unmarshaller unmarshaller  = jc.createUnmarshaller();

        		unmarshaller.setEventHandler(new javax.xml.bind.helpers.DefaultValidationEventHandler());

        		JAXBElement result = unmarshaller.unmarshal(xml,clazz);

        		return new EventImpl(event.getQName(),result.getValue());
        	} catch (JAXBException e) {
        		// TODO Auto-generated catch block
        		e.printStackTrace();
        	} catch (ClassNotFoundException e) {
        		// TODO Auto-generated catch block
        		e.printStackTrace();
        	}
        }
        return event;
    }
    
    //  PortletRequestImpl impl -------------------------------------------------
    
	/**
    * FIXME: (see ActionRequestImpl)
    */
    public PortletPreferences getPreferences() {
    	// TODO: Are there any changes to do in PortletPreferences?
       if (portletPreferences == null) {
           portletPreferences = new PortletPreferencesImpl(
           		getPortletContainer(),
           		getInternalPortletWindow(),
           		this,
           		Constants.METHOD_EVENT);
       }
       return portletPreferences;
   }

	public String getLifecyclePhase() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("This method needs to be implemented.");
	}

	public Cookie[] getCookieProperties() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("This method needs to be implemented.");
	}

}
