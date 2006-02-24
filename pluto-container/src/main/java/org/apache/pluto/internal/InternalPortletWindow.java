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

package org.apache.pluto.internal;

import javax.portlet.PortletMode;
import javax.portlet.WindowState;
import javax.servlet.ServletContext;

import org.apache.pluto.PortletWindow;
import org.apache.pluto.PortletContainerRuntimeException;
import org.apache.pluto.util.StringManager;
import org.apache.pluto.om.ObjectID;


/**
 * The internal portlet window represents a single window of a portlet instance
 * as it can be shown only once on a single page. There is a one-to-one relation
 * between portlet windows and portlet entities. Adding the same portlet e.g.
 * twice on a page results in two different windows.
 * 
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>
 * @author <a href="mailto:zheng@apache.org">ZHENG Zhong</a>
 */
public class InternalPortletWindow implements PortletWindow {

    private static final StringManager EXCEPTIONS =
            StringManager.getManager(InternalPortletWindow.class.getPackage().getName());
    
    
    // Private Member Variables ------------------------------------------------
    
    /** The underlying portlet window instance. */
    private PortletWindow portletWindow = null;
    
    /** The servlet context of the portlet. */
    private ServletContext servletContext = null;
    
    /** The portlet entity associated with the portlet window. */
    private PortletEntity entity;
    
    
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
    public InternalPortletWindow(ServletContext context,
                                 PortletWindow portletWindow) {
        this.servletContext = context.getContext(
        		portletWindow.getContextPath());
        if (servletContext == null) {
            throw new PortletContainerRuntimeException(
                EXCEPTIONS.getString(
                    "error.config.context.null",
                    portletWindow.getPortletName(),
                    portletWindow.getContextPath()
                )
            );
        }
        this.portletWindow = portletWindow;
    }

    /**
     * Standard Getter.
     * @return the context path.
     */
    public String getContextPath() {
        return portletWindow.getContextPath();
    }

    /**
     * Standard getter.
     * @return the portlet name as defined in the deployment descriptor.
     */
    public String getPortletName() {
        return portletWindow.getPortletName();
    }

    /**
     * Standard getter.
     * @return the window state.
     */
    public WindowState getWindowState() {
        return portletWindow.getWindowState();
    }

    /**
     * Standard getter.
     * @return the portlet mode the portlet mode
     */
    public PortletMode getPortletMode() {
        return portletWindow.getPortletMode();
    }


    /**
     * Returns the identifier of this portlet instance window as object id. The
     * return value cannot be NULL.
     * @return the object identifier
     */
    public ObjectID getId() {
        return portletWindow.getId();
    }

    /**
     * The Context from which this window can be serviced.
     * @return the associated servlet context.
     */
    public ServletContext getServletContext() {
        return servletContext;
    }

    /**
     * Returns the portlet entity. The return value cannot be NULL.
     * @return the portlet entity
     */
    public PortletEntity getPortletEntity() {
        if (entity == null) {
            entity = new PortletEntity(servletContext, this);
        }
        return entity;
    }

}
