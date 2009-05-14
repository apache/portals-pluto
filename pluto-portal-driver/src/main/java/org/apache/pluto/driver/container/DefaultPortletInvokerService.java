/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.pluto.driver.container;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.pluto.container.FilterManager;
import org.apache.pluto.container.PortletContainerException;
import org.apache.pluto.container.PortletInvokerService;
import org.apache.pluto.container.PortletRequestContext;
import org.apache.pluto.container.PortletWindow;
import org.apache.pluto.container.driver.PortletContextService;
import org.apache.pluto.container.driver.PortletServlet;
import org.apache.pluto.container.util.StringManager;

/**
 * Used internally to invoke/dispatch requests from the container to
 * the portlet application.
 *
 */
public class DefaultPortletInvokerService implements PortletInvokerService {

    /**
     * Logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(DefaultPortletInvokerService.class);

    /**
     * Exception Messages.
     */
    private static final StringManager EXCEPTIONS = StringManager.getManager(
            DefaultPortletInvokerService.class.getPackage().getName());

    // Private Member Variables ------------------------------------------------

    /** URI prefix of the portlet invoker servlet.
     *  TODO: this is Pluto Portal Driver specific!
     * */
    private static final String PREFIX = "/PlutoInvoker/";

    private PortletContextService portletContextService;

    // Constructor -------------------------------------------------------------

    /**
     * Default Constructor.  Create a new invoker which
     * is initialized for the given <code>PortletWindow</code>.
     */
    public DefaultPortletInvokerService(PortletContextService portletContextService) {
        this.portletContextService = portletContextService;
    }

    // Public Methods ----------------------------------------------------------

    /**
     * Invoke the portlet with an action request.
     *
     * @param context request context used for the invocation
     * @param request  action request used for the invocation.
     * @param response action response used for the invocation.
     * @see PortletServlet
     * @see javax.portlet.Portlet#processAction(javax.portlet.ActionRequest,javax.portlet.ActionResponse)
     */
    public void action(PortletRequestContext context, ActionRequest request, ActionResponse response, FilterManager filterManager)
    throws IOException, PortletException, PortletContainerException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Performing Action Invocation");
        }
        invoke(context, request, response, filterManager, PortletInvokerService.METHOD_ACTION);
    }

    /**
     * Invoke the portlet with a render request.
     *
     * @param request  action request used for the invocation.
     * @param response action response used for the invocation.
     * @see PortletServlet
     * @see javax.portlet.Portlet#render(javax.portlet.RenderRequest,javax.portlet.RenderResponse)
     */
    public void render(PortletRequestContext context, RenderRequest request, RenderResponse response, FilterManager filterManager)
    throws IOException, PortletException, PortletContainerException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Performing Render Invocation");
        }
        invoke(context, request, response, filterManager, PortletInvokerService.METHOD_RENDER);
    }

    /**
     * Invoke the portlet with a render request.
     *
     * @param request  action request used for the invocation.
     * @param response action response used for the invocation.
     * @see PortletServlet
     * @see javax.portlet.Portlet#render(javax.portlet.RenderRequest,javax.portlet.RenderResponse)
     */
    public void event(PortletRequestContext context, EventRequest request, EventResponse response, FilterManager filterManager)
    throws IOException, PortletException, PortletContainerException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Performing Render Invocation");
        }
        invoke(context, request, response, filterManager, PortletInvokerService.METHOD_EVENT);
    }

    /**
     * Invoke the portlet with a resource request.
     *
     * @param request  resource request used for the invocation.
     * @param response resource response used for the invocation.
     * @see PortletServlet
     * @see javax.portlet.Portlet#resource(javax.portlet.ResourceRequest,javax.portlet.ResourceResponse)
     */
    public void serveResource(PortletRequestContext context, ResourceRequest request, ResourceResponse response, FilterManager filterManager)
    throws IOException, PortletException, PortletContainerException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Performing Resource Invocation");
        }
        invoke(context, request, response, filterManager, PortletInvokerService.METHOD_RESOURCE);
    }

    /**
     * Invoke the portlet with a load request.
     *
     * @param request  action request used for the invocation.
     * @param response action response used for the invocation.
     * @see PortletServlet
     */
    public void load(PortletRequestContext context, PortletRequest request, PortletResponse response)
    throws IOException, PortletException, PortletContainerException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Performing Load Invocation.");
        }
        invoke(context, request, response, PortletInvokerService.METHOD_LOAD);
    }

    public void admin(PortletRequestContext context, PortletRequest request, PortletResponse response)
    throws IOException, PortletException, PortletContainerException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Performing Admin Invocation.");
        }

        invoke(context, request, response, PortletInvokerService.METHOD_ADMIN);
    }

    // Private Invoke Method ---------------------------------------------------

    private final void invoke(PortletRequestContext context,
            PortletRequest request,
            PortletResponse response,
            Integer methodID)
    throws PortletException, IOException, PortletContainerException {

        invoke(context, request, response, null, methodID);
    }

    /**
     * Perform the invocation.
     *
     * @param request       portlet request
     * @param response      portlet response
     * @param portletWindow internal portlet window
     * @param methodID      method identifier
     * @throws PortletException if a portlet exception occurs.
     * @throws IOException      if an error occurs writing to the response.
     */
    protected final void invoke(PortletRequestContext context,
            PortletRequest request,
            PortletResponse response,
            FilterManager filterManager,
            Integer methodID)
    throws PortletException, IOException, PortletContainerException {

        PortletWindow portletWindow = context.getPortletWindow();
        String appName = portletWindow.getPortletDefinition().getApplication().getName();
        ServletContext servletContext = portletContextService.getPortletContext(appName).getServletContext();

        String uri =  PREFIX + portletWindow.getPortletDefinition().getPortletName();
        if (LOG.isDebugEnabled()) {
            LOG.debug("Dispatching to portlet servlet at: " + uri);
        }

        RequestDispatcher dispatcher = servletContext.getRequestDispatcher(uri);

        if (dispatcher != null) {

            HttpServletRequest containerRequest = context.getContainerRequest();
            HttpServletResponse containerResponse = context.getContainerResponse();

            try {

                containerRequest.setAttribute(PortletInvokerService.METHOD_ID, methodID);
                containerRequest.setAttribute(PortletInvokerService.PORTLET_REQUEST, request);
                containerRequest.setAttribute(PortletInvokerService.PORTLET_RESPONSE, response);
                containerRequest.setAttribute(PortletInvokerService.FILTER_MANAGER, filterManager);

                if (methodID.equals(PortletInvokerService.METHOD_RESOURCE))
                {
                    dispatcher.forward(containerRequest, containerResponse);
                }
                else
                {
                    dispatcher.include(containerRequest, containerResponse);
                }


            } catch (javax.servlet.UnavailableException ex) {
                int seconds = ex.isPermanent() ? -1 : ex.getUnavailableSeconds();
                String message = EXCEPTIONS.getString(
                        "error.portlet.invoker.unavailable",
                        uri, new String[]{String.valueOf(seconds)}
                );
                if (LOG.isErrorEnabled()) {
                    LOG.error(message, ex);
                }
                throw new javax.portlet.UnavailableException(
                        message, seconds);

            } catch (javax.servlet.ServletException ex) {
                String message = EXCEPTIONS.getString("error.portlet.invoker");
                if (LOG.isErrorEnabled()) {
                    LOG.error(message);
                }

                if (ex.getRootCause() != null &&
                        ex.getRootCause() instanceof PortletException) {
                    throw (PortletException) ex.getRootCause();
                } else if (ex.getRootCause() != null) {
                    throw new PortletException(ex.getRootCause());
                } else {
                    throw new PortletException(ex);
                }

            } finally {
                containerRequest.removeAttribute(PortletInvokerService.METHOD_ID);
                containerRequest.removeAttribute(PortletInvokerService.PORTLET_REQUEST);
                containerRequest.removeAttribute(PortletInvokerService.PORTLET_RESPONSE);
                containerRequest.removeAttribute(PortletInvokerService.FILTER_MANAGER);
            }
        } else {
            String msg = EXCEPTIONS.getString(
                    "error.portlet.invoker.dispatcher",
                    new String[]{servletContext.getServletContextName(), uri}
            );
            if (LOG.isErrorEnabled()) {
                LOG.error(msg);
            }
            throw new PortletException(msg);
        }
    }

}
