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

package org.apache.pluto.driver.impl;

import org.apache.pluto.PortletWindow;

import javax.portlet.PortletMode;
import javax.portlet.WindowState;
import javax.portlet.PortletPreferences;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/** Reference to a specific portlet instance and it's state.
 *
 * NOTE:
 * <li>PortletID is the full id of the portlet <portlet-context>/<portlet-id></li>
 * <li>ContextID is the first portion of the portlet id</li>
 * <li>shortId is the second portion</li>
 *
 * @author <A href="mailto:ddewolf@apache.org">David H. DeWolf</A>
 * @version 1.0
 * @since Mar 7, 2004 at 9:21:54 AM
 */
public class PortletWindowImpl
implements PortletWindow, Cloneable, Serializable {

    //These two attrs make up the portletId
    private String portletName;
    private String contextPath;

    // for now we'll save strings so that it's inherintly
    // serializable.
    private String mode;
    private String state;

    private PortletPreferences preferences;

    public PortletWindowImpl() {
        this.mode = PortletMode.VIEW.toString();
        this.state= WindowState.NORMAL.toString();
    }

    public PortletWindowImpl(String contextPath, String portletName) {
        this();
        this.contextPath = contextPath;
        this.portletName = portletName;
    }

    public PortletWindowImpl(String portletId) {
        this();
        setPortletId(portletId);
    }

    public String getPortletId() {
        return contextPath + "." + portletName;
    }

    public void setPortletId(String portletId) {
        int index = portletId.indexOf('.');
        if(index<0) {
            throw new IllegalArgumentException("portlet id must contain a "
                                              +"context path and a portlet id");
        }
        contextPath = portletId.substring(0, index);
        portletName = portletId.substring(index+1);
    }

    public String getContextPath() {
        return contextPath;
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }

    public String getPortletName() {
        return portletName;
    }

    public void setPortletName(String portletName) {
        this.portletName = portletName;
    }

    public PortletMode getPortletMode() {
        return new PortletMode(mode);
    }

    public void setPortletMode(PortletMode mode) {
        if(!mode.toString().equals(this.mode)) {
            this.mode = mode.toString();
            Iterator it = listeners.iterator();
            PortletWindowEvent event = new PortletWindowEvent(this);
            while(it.hasNext()) {
                ((PortletWindowListener)it.next()).portletModeChanged(event);
            }
        }
    }

    public WindowState getWindowState() {
        return new WindowState(state);
    }

    public void setWindowState(WindowState state) {
        if(!state.toString().equals(this.state)) {
            this.state = state.toString();
            Iterator it = listeners.iterator();
            PortletWindowEvent event = new PortletWindowEvent(this);
            while(it.hasNext()) {
                ((PortletWindowListener)it.next()).windowStateChanged(event);
            }
        }
    }

// The portletId is made up of <context-path>.<portlet-name>
    public PortletPreferences getPortletPreferences() {
        return preferences;
    }

    public void setPortletPreferences(PortletPreferences portletPrefs) {
        this.preferences = portletPrefs;
    }

    //
    private ArrayList listeners = new ArrayList();
    public void addPortletWindowListener(PortletWindowListener listener) {
        listeners.add(listener);
    }

    public void removePortletWindowListener(PortletWindowListener listener) {
        listeners.add(listener);
    }

    public Object clone() {
        PortletWindowImpl impl = new PortletWindowImpl();
        impl.setContextPath(this.getContextPath());
        impl.setPortletName(this.getPortletName());
        impl.setPortletMode(this.getPortletMode());
        impl.setWindowState(this.getWindowState());
        impl.setPortletPreferences(this.getPortletPreferences());
        return impl;
    }
}
