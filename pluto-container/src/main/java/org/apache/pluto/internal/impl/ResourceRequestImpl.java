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

import java.io.IOException;
import java.io.InputStream;

import javax.portlet.PortletPreferences;
import javax.portlet.ResourceRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.Constants;
import org.apache.pluto.PortletContainer;
import org.apache.pluto.internal.InternalActionRequest;
import org.apache.pluto.internal.InternalPortletWindow;

public class ResourceRequestImpl extends PortletRequestImpl
implements ResourceRequest, InternalActionRequest {

	/** Logger. */
    private static final Log LOG = LogFactory.getLog(ResourceRequestImpl.class);
    
    
    // Private Member Variables ------------------------------------------------
    
    /** FIXME: The portlet preferences. */
    private PortletPreferences portletPreferences = null;
    
    
    // Constructor -------------------------------------------------------------
    
    public ResourceRequestImpl(PortletContainer container,
                             InternalPortletWindow internalPortletWindow,
                             HttpServletRequest servletRequest) {
        super(container, internalPortletWindow, servletRequest);
        if (LOG.isDebugEnabled()) {
        	LOG.debug("Created action request for: " + internalPortletWindow);
        }
    }

    // ResourceRequest impl ------------------------------------------------------
    
    /* (non-Javadoc)
     * FIXME: should we set the bodyAccessed flag?
     * @see org.apache.pluto.core.InternalActionResponse#getPortletInputStream()
     */
    public InputStream getPortletInputStream() throws IOException {
        HttpServletRequest servletRequest = (HttpServletRequest) getRequest();
        if (servletRequest.getMethod().equals("POST")) {
            String contentType = servletRequest.getContentType();
            if (contentType == null ||
                contentType.equals("application/x-www-form-urlencoded")) {
                throw new IllegalStateException(
                		"User request HTTP POST data is of type "
                		+ "application/x-www-form-urlencoded. "
                		+ "This data has been already processed "
                		+ "by the portal/portlet-container and is available "
                		+ "as request parameters.");
            }
        }
        return servletRequest.getInputStream();
    }

    // PortletRequestImpl impl -------------------------------------------------
    
    /**
     * FIXME: 
     */
    public PortletPreferences getPreferences() {
        if (portletPreferences == null) {
            portletPreferences = new PortletPreferencesImpl(
            		getPortletContainer(),
            		getInternalPortletWindow(),
            		this,
            		Constants.METHOD_ACTION);
        }
        return portletPreferences;
    }

	public String getETag() {
		// TODO Auto-generated method stub
//		return null;
		throw new UnsupportedOperationException("This method needs to be implemented");
	}

	public String getLifecyclePhase() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("This method needs to be implemented.");
	}

	public String getResourceID() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("This method needs to be implemented.");
	}

	public Cookie[] getCookieProperties() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("This method needs to be implemented.");
	}
	
}
