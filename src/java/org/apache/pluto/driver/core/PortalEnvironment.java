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

import org.apache.pluto.driver.config.DriverConfiguration;

public class PortalEnvironment {

    public final static String REQUEST_PORTALENV = "org.apache.pluto.driver.core.PortalEnvironment";

    private HttpServletRequest request;
    private HttpServletResponse response;
    private DriverConfiguration driverConfig;


    private PortalURL requestedPortalURL;

    public PortalEnvironment(HttpServletRequest request,
                             HttpServletResponse response) {
        this.request = request;
        this.response = response;
        init();


    }

    private void init() {

        requestedPortalURL =
        PortalUrlFactory.getFactory().createPortalUrl(request);


        // set Environment in Request for later use
        this.request.setAttribute(REQUEST_PORTALENV, this);
    }


    public static PortalEnvironment getPortalEnvironment(
        HttpServletRequest request) {
        return (PortalEnvironment) request.getAttribute(REQUEST_PORTALENV);
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

/*
    public List getNavigationalInformation()
    {
        return navigationalInformation;
    }
*/    
    public PortalURL getRequestedPortalURL() {
        return requestedPortalURL;
    }
}
