/*
 * Copyright 2004 The Apache Software Foundation.
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

import java.io.IOException;
import java.util.Map;

import javax.portlet.PortletException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.PortletContainer;
import org.apache.pluto.PortletContainerException;
import org.apache.pluto.PortletWindow;
import org.apache.pluto.core.impl.ActionRequestImpl;
import org.apache.pluto.core.impl.ActionResponseImpl;
import org.apache.pluto.core.impl.RenderRequestImpl;
import org.apache.pluto.core.impl.RenderResponseImpl;
import org.apache.pluto.services.PortletContainerServices;
import org.apache.pluto.services.PortletURLProvider;

/**
 * Default Pluto Container implementation.
 *
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version 1.0
 * @since Sep 18, 2004
 */
public class PortletContainerImpl implements PortletContainer {

    /** Internal logger. */
    private static final Log LOG =
        LogFactory.getLog(PortletContainerImpl.class);


    /** The portlet container name. */
    private String name;

    /** The PortletContainerServices associated with this container. */
    private PortletContainerServices containerServices;

    /** The ServletContext associated with this container. */
    private ServletContext context;

    /** Flag indicating whether or not we've been initialized. */
    private boolean initialized;

    /** Default Constructor.  Create a container implementation
     *  whith the given name and given services.
     *
     * @param name the name of the container.
     * @param services the container services implementation.
     */
    public PortletContainerImpl(String name,
                                PortletContainerServices services) {
        this.name = name;
        this.containerServices = services;
    }

    /**
     * Initialize the container for use within the given configuration scope.
     * @param context
     */
    public void init(ServletContext context) {
        this.context = context;
        initialized = true;
        if (LOG.isInfoEnabled()) {
            LOG.debug("Portlet Container [" + name +
                      "] successfully initialized.");
        }
    }

    /**
     * Determine whether this container has been initialized or not.
     * @return true if the container has been initialized.
     */
    public boolean isInitialized() {
        return initialized;
    }

    /**
     * Destroy this container.
     */
    public void destroy() {
        this.context = null;
        initialized = false;
    }


    /**
     * Render the portlet associated with the specified window.
     * @param pWindow
     * @param request
     * @param response
     * @throws PortletException
     * @throws IOException
     * @throws PortletContainerException
     */
    public void doRender(PortletWindow pWindow,
                         HttpServletRequest request,
                         HttpServletResponse response)
        throws PortletException, IOException, PortletContainerException {

        InternalPortletWindow window = new InternalPortletWindow(context,
                                                                 pWindow);


        if (LOG.isDebugEnabled()) {
            LOG.debug("Portlet Container [" + name +
                      "]: Render request recieved.");
        }

        RenderRequestImpl req =
            new RenderRequestImpl(this, window, request);

        RenderResponseImpl res =
            new RenderResponseImpl(this, window, request, response);

        PortletInvoker invoker = new PortletInvoker(window);

        if (LOG.isDebugEnabled()) {
            LOG.debug("Portlet Container [" + name + "]: Invoker Created.");
        }

        invoker.render(req, res);

        if (LOG.isDebugEnabled()) {
            LOG.debug("Portlet Container [" + name + "]: Portlet rendered.");
        }
    }

    /**
     * Process the action for the portlet associated with the given action.
     * @param pWindow
     * @param request
     * @param response
     * @throws PortletException
     * @throws IOException
     * @throws PortletContainerException
     */
    public void doAction(PortletWindow pWindow,
                         HttpServletRequest request,
                         HttpServletResponse response)
        throws PortletException, IOException, PortletContainerException {

        InternalPortletWindow window =
            new InternalPortletWindow(context, pWindow);

        if (LOG.isDebugEnabled()) {
            LOG.debug("Portlet Container [" + name + "] Action request recieved");
        }

        ActionRequestImpl req =
            new ActionRequestImpl(this, window, request);

        ActionResponseImpl res =
            new ActionResponseImpl(this, window, request, response);

        PortletInvoker invoker = new PortletInvoker(window);

        if (LOG.isDebugEnabled()) {
            LOG.debug("Portlet Container [" + name + "]: Invoker Created.");
        }
        invoker.action(req, res);

        if (LOG.isDebugEnabled()) {
            LOG.debug(
                "Portlet Container [" + name + "]: Portlet Action performed.");
        }

        String location = res.getRedirectLocation();

        if (location == null) {
            if (LOG.isDebugEnabled()) {
                LOG.debug(
                    "Portlet Container [" + name +
                    "]:  No redirect location specified.");
            }

            PortletURLProvider redirectURL =
                containerServices.getDynamicInformationProvider(request)
                .getPortletURLProvider(window);

            if (res.getChangedPortletMode() != null) {
                redirectURL.setPortletMode(res.getChangedPortletMode());
            }

            if (res.getChangedWindowState() != null) {
                redirectURL.setWindowState(res.getChangedWindowState());
            }

            Map renderParameters = res.getRenderParameters();
            redirectURL.clearParameters();
            redirectURL.setParameters(renderParameters);
            redirectURL.setAction(false);

            if (req.isSecure()) {
                redirectURL.setSecure();
            }
            location = res.encodeRedirectURL(redirectURL.toString());
        }

        // Here we intentionally use the original response
        // instead of the wrapped internal response.
        response.sendRedirect(location);
        if (LOG.isDebugEnabled()) {
            LOG.debug("Portlet Container [" + name + "]: Redirect sent.");
        }

    }

    /**
     * Load the portlet associated with the specified window.
     * @param pWindow
     * @param request
     * @param response
     * @throws PortletException
     * @throws PortletContainerException
     */
    public void doLoad(PortletWindow pWindow,
                       HttpServletRequest request,
                       HttpServletResponse response)
        throws PortletException, PortletContainerException {

        InternalPortletWindow window = new InternalPortletWindow(context,
                                                                 pWindow);

        if (LOG.isDebugEnabled()) {
            LOG.debug("Portlet Container [" + name + "]: Load request recieved.");
        }

        RenderRequestImpl req =
            new RenderRequestImpl(this, window, request);

        RenderResponseImpl res =
            new RenderResponseImpl(this, window, request, response);

        PortletInvoker invoker = new PortletInvoker(window);

        if (LOG.isDebugEnabled()) {
            LOG.debug("Portlet Container [" + name + "]: Invoker Created.");
        }

        invoker.load(req, res);

        if (LOG.isDebugEnabled()) {
            LOG.debug("Portlet Container [" + name + "]: Portlet loaded.");
        }

    }

    public String getName() {
        return name;
    }

    public PortletContainerServices getContainerServices() {
        return containerServices;
    }
}

