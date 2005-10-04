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

import java.util.HashSet;
import java.util.Iterator;

import javax.portlet.PortletMode;
import javax.portlet.WindowState;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;

import org.apache.pluto.om.window.PortletWindow;
import org.apache.pluto.portalImpl.services.config.Config;
import org.apache.pluto.services.information.DynamicInformationProvider;
import org.apache.pluto.services.information.PortletActionProvider;
import org.apache.pluto.services.information.PortletURLProvider;
import org.apache.pluto.services.information.ResourceURLProvider;


public class DynamicInformationProviderImpl implements DynamicInformationProvider {

    private final static int NumberOfKnownMimetypes = 15;

    private ServletConfig config;

    private PortalEnvironment env;

    HttpServletRequest request;

    public DynamicInformationProviderImpl(HttpServletRequest request,
                                          ServletConfig config)
    {
        this.request = request;
        this.config = config;

        env        = PortalEnvironment.getPortalEnvironment(request);
    }

    // DynamicInformationProviderImpl implementation.
    
    public PortletMode getPortletMode(PortletWindow portletWindow)
    {
        return env.getPortalControlParameter().getMode(portletWindow);
    }

    public PortletURLProvider getPortletURLProvider(PortletWindow portletWindow)
    {
        return new PortletURLProviderImpl(this, portletWindow);
    }

    public ResourceURLProvider getResourceURLProvider(PortletWindow portletWindow)
    {
        return new ResourceURLProviderImpl(this, portletWindow);
    }

    public PortletActionProvider getPortletActionProvider(PortletWindow portletWindow)
    {
        return new PortletActionProviderImpl(request, config, portletWindow);
    }

    public PortletMode getPreviousPortletMode(PortletWindow portletWindow)
    {
        return env.getPortalControlParameter().getPrevMode(portletWindow);
    }

    public WindowState getPreviousWindowState(PortletWindow portletWindow)
    {
        return env.getPortalControlParameter().getPrevState(portletWindow);
    }

    public String getResponseContentType()
    {
        return "text/html";
    }

    public Iterator getResponseContentTypes()
    {
        HashSet responseMimeTypes = new HashSet(NumberOfKnownMimetypes);
        responseMimeTypes.add("text/html");

        return responseMimeTypes.iterator();
    }

    public WindowState getWindowState(PortletWindow portletWindow)
    {
        return env.getPortalControlParameter().getState(portletWindow);
    }

    public boolean isPortletModeAllowed(PortletMode mode)
    {
        //checks whether PortletMode is supported as example
        String[] supportedModes = Config.getParameters().getStrings("supported.portletmode");
        for (int i = 0; i < supportedModes.length; i++) {
            if (supportedModes[i].equalsIgnoreCase(mode.toString())) {
                return true;
            }
        }
        return false;
    }

    public boolean isWindowStateAllowed(WindowState state)
    {
        //checks whether WindowState is supported as example
        String[] supportedStates = Config.getParameters().getStrings("supported.windowstate");
        for (int i = 0; i < supportedStates.length; i++) {
            if (supportedStates[i].equalsIgnoreCase(state.toString())) {
                return true;
            }
        }
        return false;
    }

}
