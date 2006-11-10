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
package org.apache.pluto.internal.impl;


import java.util.List;

import javax.portlet.Event;
import javax.portlet.EventRequest;
import javax.portlet.PortletPreferences;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.Constants;
import org.apache.pluto.PortletContainer;
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
	
	private HttpServletRequest request = null; 
	
	//	 Constructor -------------------------------------------------------------
    
    public EventRequestImpl(PortletContainer container,
                             InternalPortletWindow internalPortletWindow,
                             HttpServletRequest servletRequest) {
        super(container, internalPortletWindow, servletRequest);
        this.request = servletRequest;
        if (LOG.isDebugEnabled()) {
        	LOG.debug("Created Event request for: " + internalPortletWindow);
        }
   
    }
    
    //  EventRequest impl -------------------------------------------------------
    
    public Event getEvent(){
        EventProvider provider = 
        	(EventProvider) request.getAttribute(Constants.PROVIDER);
        String eventName = (String) this.getAttribute(Constants.EVENT_NAME);
        List<Event> events = provider.getAllSavedEvents();
        for (Event event : events) {
        	if (eventName.contains(event.getName())){
				return event;
			}
		}
        
        // should not be
        throw new UnsupportedOperationException();
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

}
