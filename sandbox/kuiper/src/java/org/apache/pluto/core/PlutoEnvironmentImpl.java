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

package org.apache.pluto.core;

import org.apache.pluto.PlutoEnvironment;

import javax.portlet.PortalContext;
import javax.portlet.PortletMode;
import javax.portlet.WindowState;
import javax.servlet.ServletContext;
import java.util.HashMap;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Set;
import java.util.HashSet;

/**
 * @author <A href="mailto:david.dewolf@vivare.com">David H. DeWolf</A>
 * @version 1.0
 * @since Mar 9, 2004 at 9:26:15 AM
 */
public class PlutoEnvironmentImpl implements PlutoEnvironment {
    
    private String containerName;

    private PortalContext portalContext;
    private ServletContext servletContext;

    private Properties props = null;
    
    private HashMap states = new HashMap();
    private HashMap modes  = new HashMap();
    private Set contentTypes = new HashSet();

    public PlutoEnvironmentImpl(String containerName,
                                PortalContext context,
                                ServletContext servletContext) {
        this(containerName, context, servletContext, new Properties());
    }
    
    public PlutoEnvironmentImpl(String containerName,
                                PortalContext context,
                                ServletContext servletContext,
                                Properties portalProperties) {
        this.containerName = containerName;
        this.portalContext = context;
        this.servletContext = servletContext;

        Enumeration enum = context.getSupportedPortletModes();
        while(enum.hasMoreElements()) {
            PortletMode mode = (PortletMode)enum.nextElement();
            modes.put(mode.toString(), mode);
        }

        enum = context.getSupportedWindowStates();
        while(enum.hasMoreElements()) {
            WindowState state = (WindowState)enum.nextElement();
            states.put(state.toString(), state);
        }

        contentTypes.add("text/html");
        contentTypes.add("text/plain");
        contentTypes.add("text/xml");

        props = portalProperties;
    }


    public String getContainerName() {
        return containerName;
    }

    public PortalContext getPortalContext() {
        return  portalContext;
    }

    public ServletContext getServletContext() {
        return servletContext;
    }

    public boolean isWindowStateAllowed(WindowState state) {
       return
           WindowState.NORMAL.equals(state)
        || WindowState.MAXIMIZED.equals(state)
        || WindowState.MINIMIZED.equals(state)
        || states.values().contains(state);
    }

    public boolean isPortletModeAllowed(PortletMode mode) {
        return
            PortletMode.VIEW.equals(mode)
         || PortletMode.EDIT.equals(mode)
         || PortletMode.HELP.equals(mode)
         || modes.values().contains(mode);
    }

    public WindowState getWindowState(String state) {
        if(WindowState.NORMAL.toString().equals(state)) {
            return WindowState.NORMAL;
        }
        else if(WindowState.MAXIMIZED.toString().equals(state)) {
            return WindowState.MAXIMIZED;
        }
        else if(WindowState.MINIMIZED.toString().equals(state)) {
            return WindowState.MINIMIZED;
        }
        return (WindowState)states.get(state);
    }

    public Set getSupportedContentTypes() {
        return contentTypes;
    }

    public Properties getPortalProperties() {
        return props;
    }
}
