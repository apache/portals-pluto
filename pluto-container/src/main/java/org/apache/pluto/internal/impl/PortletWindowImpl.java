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
package org.apache.pluto.internal.impl;

import javax.portlet.PortletMode;
import javax.portlet.WindowState;
import javax.servlet.ServletContext;

import org.apache.pluto.PortletWindow;
import org.apache.pluto.PortletContainerRuntimeException;
import org.apache.pluto.PortletWindowID;
import org.apache.pluto.util.StringManager;
import org.apache.pluto.internal.InternalPortletWindow;
import org.apache.pluto.internal.PortletEntity;

/**
 * Implementation of <code>InternalPortletWindow</code> interface.
 * 
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>
 * @author <a href="mailto:zheng@apache.org">ZHENG Zhong</a>
 */
public class PortletWindowImpl implements InternalPortletWindow {

    private static final StringManager EXCEPTIONS = StringManager.getManager(
    		PortletWindowImpl.class.getPackage().getName());
    
    
    // Private Member Variables ------------------------------------------------
    
    /** The underlying portlet window instance. */
    private PortletWindow portletWindow = null;
    
    /** The servlet context of the portlet. */
    private ServletContext servletContext = null;
    
    /** The portlet entity associated with the portlet window. */
    private PortletEntity entity = null;
    
    
    // Constructor -------------------------------------------------------------
    
    /**
     * Constructs an internal portlet window that wraps a portlet window.
     * An internal portlet window instance is created everytime when the portlet
     * container's <code>doRender()</code> or <code>doAction()</code> method is
     * invoked.
     * 
     * @param context  the servlet context from which this window is
     *        being invoked.
     * @param portletWindow  the underlying portlet window instance.
     */
    public PortletWindowImpl(ServletContext context,
                             PortletWindow portletWindow) {
        this.servletContext = context.getContext(
        		portletWindow.getContextPath());
        if (servletContext == null) {
            throw new PortletContainerRuntimeException(EXCEPTIONS.getString(
            		"error.config.context.null",
                    portletWindow.getPortletName(),
                    portletWindow.getContextPath()));
        }
        this.portletWindow = portletWindow;
    }
    
    
    // PortletWindow Impl ------------------------------------------------------
    
    public String getContextPath() {
        return portletWindow.getContextPath();
    }

    public String getPortletName() {
        return portletWindow.getPortletName();
    }

    public WindowState getWindowState() {
        return portletWindow.getWindowState();
    }

    public PortletMode getPortletMode() {
        return portletWindow.getPortletMode();
    }
    
    public PortletWindowID getId() {
        return portletWindow.getId();
    }
    
    
    // InternalPortletWindow Impl ----------------------------------------------
    
    public ServletContext getServletContext() {
        return servletContext;
    }

    public PortletEntity getPortletEntity() {
        if (entity == null) {
            entity = new PortletEntityImpl(servletContext, this);
        }
        return entity;
    }

    public PortletWindow getOriginalPortletWindow() {
        return portletWindow;
    }
}
