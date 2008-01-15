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


import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.portlet.Event;
import javax.portlet.EventRequest;
import javax.portlet.PortletPreferences;
import javax.servlet.ServletInputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.Constants;
import org.apache.pluto.PortletContainer;
import org.apache.pluto.internal.InternalEventRequest;
import org.apache.pluto.internal.InternalPortletWindow;

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
        return event;
    }
    
    //  PortletRequestImpl impl -------------------------------------------------
    
	
    public PortletPreferences getPreferences() {
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
		return EVENT_PHASE;
	}

	public Cookie[] getCookieProperties() {
		return container.getRequiredContainerServices().getPortalCallbackService().getRequestPropertyCookie(super.getHttpServletRequest(), super.getInternalPortletWindow());
	}
	
	
    
    //////////////////////////////////////////////////////////////////
	//for forward and include
	//////////////////////////////////////////////////////////////////
	
	public String getCharacterEncoding() {
        return (super.isIncluded() || super.isForwarded()) ? null : super.getCharacterEncoding();
    }
	
	public int getContentLength() {
        return (super.isIncluded() || super.isForwarded()) ? 0 : super.getContentLength();
    }
	
	public String getContentType() {
        return (super.isIncluded() || super.isForwarded()) ? null : super.getContentType();
    }
	
	public ServletInputStream getInputStream() throws IOException {
        return (super.isIncluded() || super.isForwarded()) ? null : super.getInputStream();
    }
	
	public BufferedReader getReader()
    throws UnsupportedEncodingException, IOException {
        return (super.isIncluded() || super.isForwarded()) ? null : super.getReader();
    }
	
	public void setCharacterEncoding(String encoding)
    throws UnsupportedEncodingException {
        if (!super.isIncluded() && !super.isForwarded()) {
        	super.setCharacterEncoding(encoding);
        }
    }
}
