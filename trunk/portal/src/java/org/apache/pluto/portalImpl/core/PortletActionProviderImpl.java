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

package org.apache.pluto.portalImpl.core;

import javax.portlet.PortletMode;
import javax.portlet.WindowState;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;

import org.apache.pluto.om.window.PortletWindow;
import org.apache.pluto.services.information.PortletActionProvider;

public class PortletActionProviderImpl implements PortletActionProvider {


    private HttpServletRequest request;
    private PortletWindow portletWindow;

    public PortletActionProviderImpl(HttpServletRequest request,
                                     ServletConfig config,
                                     PortletWindow portletWindow)
    {
        this.request = request;
        this.portletWindow = portletWindow;
    }

    // PortletActionProvider implementation.

    /* (non-Javadoc)
     * @see org.apache.pluto.services.information.PortletActionProvider#changePortletMode(PortletWindow, PortletMode)
     */
    public void changePortletMode(PortletMode mode) 
    {
        PortalEnvironment env = PortalEnvironment.getPortalEnvironment(request);

        PortalURL url = env.getRequestedPortalURL();
        PortalControlParameter controlURL = new PortalControlParameter(url);
        if (!(controlURL.getMode(portletWindow).equals(mode)) && mode != null) {
            controlURL.setMode(portletWindow, mode);
            env.changeRequestedPortalURL(url, controlURL);
        }
    }

    /* (non-Javadoc)
     * @see org.apache.pluto.services.information.PortletActionProvider#changePortletWindowState(PortletWindow, WindowState)
     */
    public void changePortletWindowState(WindowState state) 
    {
        PortalEnvironment env = (PortalEnvironment) request.getAttribute(PortalEnvironment.REQUEST_PORTALENV);

        PortalURL url = env.getRequestedPortalURL();
        PortalControlParameter controlURL = new PortalControlParameter(url);

        if (!(controlURL.getState(portletWindow).equals(state)) && state != null) {
            controlURL.setState(portletWindow, state);
            env.changeRequestedPortalURL(url, controlURL);
        }
    }

}
