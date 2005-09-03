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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.portlet.PortletMode;
import javax.portlet.WindowState;
import java.util.*;

public class PortalURL implements Cloneable {

    private static final Log LOG = LogFactory.getLog(PortalURL.class);

    /**
     * The baseURL consists of the URI up to the servlet path.  The dynamic
     * portion of the PortalURL is the pathInfo;
     */
    private StringBuffer server;
    private StringBuffer servletPath;
    private String renderPath;
    private String actionWindow;

    private Map windowStates;
    private Map portletModes;
    private Map parameters;

    public PortalURL(String protocol, String server) {
        this.server = new StringBuffer();
        this.server.append(protocol).append(server);
        this.parameters = new java.util.HashMap();
        this.windowStates = new java.util.HashMap();
        this.portletModes = new java.util.HashMap();
    }

    private PortalURL() {

    }

    public PortalURL(String protocol, String server, int port) {
        this(protocol, server);
        this.server.append(":").append(port);
    }

    public PortalURL(String protocol, String server, String contextPath,
                     String servletPath) {
        this(protocol, server);
        setControllerPath(contextPath, servletPath);
    }

    public PortalURL(String protocol, String server, int port,
                     String contextPath, String servletPath) {
        this(protocol, server, port);
        setControllerPath(contextPath, servletPath);
    }

    public void setControllerPath(String context, String servletPath) {
        this.servletPath = new StringBuffer();
        this.servletPath = this.servletPath.append(context).append(servletPath);
    }

    // BasePortalURL
    public void setRenderPath(String renderPath) {
        this.renderPath = renderPath;
    }

    public String getRenderPath() {
        return renderPath;
    }

    public void addParameter(PortalUrlParameter param) {
        parameters.put(param.getWindowId() + param.getName(), param);
    }

    public Collection getParameters() {
        return parameters.values();
    }

    public void setActionWindow(String window) {
        this.actionWindow = window;
    }

    public String getActionWindow() {
        return actionWindow;
    }

    public Map getPortletModes() {
        return Collections.unmodifiableMap(portletModes);
    }

    public PortletMode getPortletMode(String windowId) {
        PortletMode mode = (PortletMode) portletModes.get(windowId);
        if (mode == null) {
            mode = PortletMode.VIEW;
        }
        return mode;
    }

    public void setPortletMode(String windowId, PortletMode portletMode) {
        this.portletModes.put(windowId, portletMode);
    }

    public Map getWindowStates() {
        return Collections.unmodifiableMap(windowStates);
    }

    public WindowState getWindowState(String windowId) {
        WindowState state = (WindowState) windowStates.get(windowId);
        if (state == null) {
            state = WindowState.NORMAL;
        }
        return state;
    }

    public void setWindowState(String windowId, WindowState windowState) {
        this.windowStates.put(windowId, windowState);
    }

    public void clearParameters(String window) {
        Iterator it = parameters.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (((PortalUrlParameter) entry.getValue()).getWindowId().equals(
                window)) {
                it.remove();
            }
        }
    }

    public String toString() {
        return PortalUrlParser.getParser().toString(this);
    }


    /**
     * Retrieve the server uri, (protocol, name, port).
     * @return the server uri portion of the url.
     */
    public String getServerUri() {
        return server.toString();
    }

    public String getControllerPath() {
        return servletPath.toString();
    }

    public Object clone() {
        PortalURL url = new PortalURL();
        url.portletModes = new HashMap(portletModes);
        url.windowStates = new HashMap(windowStates);
        url.parameters = new HashMap(parameters);
        url.server = new StringBuffer(server.toString());
        url.servletPath = new StringBuffer(servletPath.toString());
        url.renderPath = renderPath;
        url.actionWindow = actionWindow;
        return url;
    }
}
