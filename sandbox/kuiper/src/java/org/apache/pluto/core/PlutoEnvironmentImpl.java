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

/** Default environment implementation.
 *  Uses simple getters and setters and only
 *  the default modes. If this implementation is
 *  chosed the Portal must only construct the
 *  object with the appropiate parameters.
 *
 * @author <A href="mailto:ddewolf@apache.org">David H. DeWolf</A>
 * @version 1.0
 * @since Mar 9, 2004 at 9:26:15 AM
 */
public class PlutoEnvironmentImpl implements PlutoEnvironment {

    /** The Containers unique identifier. */
    private String containerName;

    /** The PortalContext of the encapsulating Portal.*/
    private PortalContext portalContext;

    /** The ServletContext of the encapsulating Portal. */
    private ServletContext servletContext;

    /** Portal Property cache. */
    private Properties props = null;

    /** WindowState cache. */
    private HashMap states = new HashMap();

    /** PortletMode cache. */
    private HashMap modes  = new HashMap();

    /** ContentType cache. */
    private Set contentTypes = new HashSet();

    /** Default Constructor. */
    public PlutoEnvironmentImpl(String containerName,
                                PortalContext context,
                                ServletContext servletContext) {
        this(containerName, context, servletContext, new Properties());
    }

    /** Constructor used to pass custom properties
     *  to the container through this environment.
     * @param containerName
     * @param context
     * @param servletContext
     * @param portalProperties
     */
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


    /** Retrieve the container's unique name.
     *
     * @return
     */
    public String getContainerName() {
        return containerName;
    }

    /** Retrieve the PortalContext within which
     *  the container resides.
     * @return
     */
    public PortalContext getPortalContext() {
        return  portalContext;
    }

    /** Retrieve the context within which
     *  the Portal/PortalContainer resides.
     * @return
     */
    public ServletContext getServletContext() {
        return servletContext;
    }

    /** Determine whether the given state is allowed.
     *
     * @param state
     * @return
     */
    public boolean isWindowStateAllowed(WindowState state) {
       return
           WindowState.NORMAL.equals(state)
        || WindowState.MAXIMIZED.equals(state)
        || WindowState.MINIMIZED.equals(state)
        || states.values().contains(state);
    }

    /** Determine if the given mode is allowed.
     *
     * @param mode
     * @return
     */
    public boolean isPortletModeAllowed(PortletMode mode) {
        return
            PortletMode.VIEW.equals(mode)
         || PortletMode.EDIT.equals(mode)
         || PortletMode.HELP.equals(mode)
         || modes.values().contains(mode);
    }

    /** Retrieve the window state for the given
     *  identifier.
     *
     * @param state
     * @return
     */
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

    /** Retrieve the supported content types.
     *
     * @return
     */
    public Set getSupportedContentTypes() {
        return contentTypes;
    }

    /** Retrieve any portal environment properties
     *  which should be passed along to the portlets
     *
     */
    public Properties getPortalProperties() {
        return props;
    }
}
