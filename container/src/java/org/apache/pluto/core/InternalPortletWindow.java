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

package org.apache.pluto.core;

import javax.portlet.PortletMode;
import javax.portlet.WindowState;
import javax.servlet.ServletContext;

import org.apache.pluto.PortletWindow;
import org.apache.pluto.om.ObjectID;


/**
 * <P> The <CODE>InternalPortletWindow</CODE> interface represents a single
 * window of a portlet instance as it can be shown only once on a single page.
 * There is a one-to-one relation between portlet windows and portlet entities.
 * Adding the same portlet e.g. twice on a page results in two different
 * windows. </P> <P> This interface defines the model as known from the MVC
 * pattern. Its purpose is to provide read access to the data stored in the
 * model. </P>
 */
public class InternalPortletWindow implements PortletWindow {

    private PortletWindow window;
    private ServletContext context;

    private ObjectID id;
    private PortletEntity entity;

    /**
     * @param ctx    the ServletContext from which this window is being
     *               invoked.
     * @param window the underlying window instance.
     */
    public InternalPortletWindow(ServletContext ctx, PortletWindow window) {
        this.context = ctx.getContext(window.getContextPath());
        this.window = window;
    }

    /**
     * Standard Getter.
     * @return the context path.
     */
    public String getContextPath() {
        return window.getContextPath();
    }

    /**
     * Standard getter.
     * @return the portlet name as defined in the deployment descriptor.
     */
    public String getPortletName() {
        return window.getPortletName();
    }

    /**
     * Standard getter.
     * @return the window state.
     */
    public WindowState getWindowState() {
        return window.getWindowState();
    }

    /**
     * Standard getter.
     * @return the portlet mode the portlet mode
     */
    public PortletMode getPortletMode() {
        return window.getPortletMode();
    }


    /**
     * Returns the identifier of this portlet instance window as object id. The
     * return value cannot be NULL.
     * @return the object identifier
     */
    public ObjectID getId() {
        return window.getId();
    }

    /**
     * The Context from which this window can be serviced.
     * @return the associated servlet context.
     */
    public ServletContext getServletContext() {
        return context;
    }

    /**
     * Returns the portlet entity. The return value cannot be NULL.
     * @return the portlet entity
     */
    public PortletEntity getPortletEntity() {
        if (entity == null) {
            entity = new PortletEntity(context, this);
        }
        return entity;
    }

}
