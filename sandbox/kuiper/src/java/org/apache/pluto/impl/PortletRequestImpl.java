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

package org.apache.pluto.impl;

import org.apache.pluto.PortletWindow;
import org.apache.pluto.PortletWindow;
import org.apache.pluto.PlutoEnvironment;

import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletRequest;
import javax.portlet.PortletRequest;
import javax.portlet.WindowState;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletSession;
import javax.portlet.PortalContext;
import javax.portlet.PortletContext;
import java.util.Enumeration;
import java.util.Vector;
import java.util.Properties;
import java.util.HashMap;
import java.util.Arrays;

/**
 * <B>TODO</B>: Document
 * 
 * @author <A href="mailto:david.dewolf@vivare.com">David H. DeWolf</A>
 * @version 1.0
 * @since Mar 4, 2004 at 9:50:14 PM
 */
public abstract class PortletRequestImpl extends HttpServletRequestWrapper 
    implements PortletRequest {

    private PlutoEnvironment environment;
    private PortletWindow window;

    private PortletContext context;
    private PortalContext portalContext;

    private HashMap props = null;

    public PortletRequestImpl(PlutoEnvironment environment,
                              PortletContext context,
                              PortletWindow window,
                              HttpServletRequest request) {
        super(request);
        this.environment = environment;
        this.window = window;
        this.context = context;
        this.portalContext = environment.getPortalContext();

        props = new java.util.HashMap(environment.getPortalProperties());

        Enumeration enum = request.getHeaderNames();
        while(enum.hasMoreElements()) {
            String key = enum.nextElement().toString();
            props.put(key, request.getHeaders(key));
        }
    }

    public String getContextPath() {
        // It looks as though tomcat doesn't update
        // this when the dispatch cross context happens
        // is this correct? for now, the work around is to
        // use the context associated with the window.
        //return super.getContextPath();
        return "/"+window.getContextPath();
    }

    public String getParameter(String key) {
        return super.getParameter(window.getPortletId()+"."+key);
    }

    public String[] getParameterValues(String key) {
        return super.getParameterValues(window.getPortletId()+"."+key);
    }

    public Enumeration getParameterNames() {
        Vector v = new Vector();
        Enumeration enum = super.getParameterNames();
        while(enum.hasMoreElements()) {
            String str = enum.nextElement().toString();
            if(str.startsWith(window.getPortletId())) {
                v.add(str);
            }
        }
        return v.elements();
    }

    public boolean isWindowStateAllowed(WindowState windowState) {
        return environment.isWindowStateAllowed(windowState);
    }

    public boolean isPortletModeAllowed(PortletMode portletMode) {
        return environment.isPortletModeAllowed(portletMode);
    }

    public PortletMode getPortletMode() {
        return window.getPortletMode();
    }

    public WindowState getWindowState() {
        return window.getWindowState();
    }

    public PortletPreferences getPreferences() {
        return window.getPortletPreferences();
    }

    public PortletSession getPortletSession() {
        return getPortletSession(false);
    }

    public PortletSession getPortletSession(boolean create) {
        return new PortletSessionImpl(
                context,
                window.getPortletId(),
                super.getSession(create));
    }

    public String getProperty(String key) {
        Object val = props.get(key);
        if(val instanceof String[]) {
            if(((String[])val).length>0) {
                return ((String[])val)[0];
            }
        }
        return val.toString();
    }

    public Enumeration getProperties(String key) {
        Object val = props.get(key);
        if(val instanceof String[]) {
            return new Vector(Arrays.asList((String[])val)).elements();
        }
        else {
            return new Vector(Arrays.asList(
                new String[] {val.toString()})
            ).elements();
        }
    }

    public Enumeration getPropertyNames() {
        return new Vector(props.keySet()).elements();
    }

    public PortalContext getPortalContext() {
        return portalContext;
    }

    public String getResponseContentType() {
        return super.getContentType();
    }

    public Enumeration getResponseContentTypes() {
        //todo these should be filtered to only include those the portlet specifies
        return new Vector(environment.getSupportedContentTypes()).elements();
    }
}
