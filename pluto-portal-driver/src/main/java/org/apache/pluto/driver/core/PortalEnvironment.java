/*
 * Copyright 2003,2004 The Apache Software Foundation.
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
/* 

 */

package org.apache.pluto.driver.core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The portal environment of the incoming servlet request and response.
 * 
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>
 * @author <a href="mailto:zheng@apache.org">ZHENG Zhong</a>
 */
public class PortalEnvironment {
	
	/** The attribute key of the portal environment instance. */
    public final static String REQUEST_PORTALENV =
    	PortalEnvironment.class.getName();
    
    /** The incoming servlet request. */
    private HttpServletRequest request = null;
    
    /** The incoming servlet response. */
    private HttpServletResponse response = null;
    
    /** The requested portal URL. */
    private PortalURL requestedPortalURL = null;
    
    
    // Constructor -------------------------------------------------------------
    
    /**
     * Create a PortalEnvironment instance.
     * @param request  the incoming servlet request.
     * @param response  the incoming servlet response.
     */
    public PortalEnvironment(HttpServletRequest request,
                             HttpServletResponse response) {
        this.request = request;
        this.response = response;
        // Parse servlet request and construct portal URL.
        this.requestedPortalURL = PortalUrlFactory.getFactory()
        		.createPortalUrl(request);
        // Set Environment in servlet request scope for later use.
        request.setAttribute(REQUEST_PORTALENV, this);
    }

    /**
     * Returns the portal environment from the servlet request. The portal
     * envirionment instance is saved in the request scope.
     * @param request  the servlet request.
     * @return the portal environment.
     */
    public static PortalEnvironment getPortalEnvironment(
    		HttpServletRequest request) {
        return (PortalEnvironment) request.getAttribute(REQUEST_PORTALENV);
    }
    
    /**
     * Returns the servlet request.
     * @return the servlet request.
     */
    public HttpServletRequest getRequest() {
        return request;
    }
    
    /**
     * Returns the servlet response.
     * @return the servlet response.
     */
    public HttpServletResponse getResponse() {
        return response;
    }
    
    /**
     * Returns the requested portal URL.
     * @return the requested portal URL.
     */
    public PortalURL getRequestedPortalURL() {
        return requestedPortalURL;
    }
}
