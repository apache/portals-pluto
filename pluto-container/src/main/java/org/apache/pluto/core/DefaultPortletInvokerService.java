/*
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
package org.apache.pluto.core;

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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.Constants;
import org.apache.pluto.internal.InternalPortletWindow;
import org.apache.pluto.internal.impl.PortletRequestImpl;
import org.apache.pluto.internal.impl.PortletResponseImpl;
import org.apache.pluto.spi.FilterManager;
import org.apache.pluto.spi.optional.PortletInvokerService;
import org.apache.pluto.util.StringManager;

/**
 * Used internally to invoke/dispatch requests from the container to
 * the portlet application.
 *
 */
public class DefaultPortletInvokerService implements PortletInvokerService {

    /**
     * Logger.
     */
    private static final Log LOG = LogFactory.getLog(DefaultPortletInvokerService.class);

    /**
     * Exception Messages.
     */
    private static final StringManager EXCEPTIONS = StringManager.getManager(
        DefaultPortletInvokerService.class.getPackage().getName());

    // Private Member Variables ------------------------------------------------

    // Constructor -------------------------------------------------------------

    /**
     * Default Constructor.  Create a new invoker which
     * is initialized for the given <code>InternalPortletWindow</code>.
     */
    public DefaultPortletInvokerService() {
    }

    // Public Methods ----------------------------------------------------------

    /**
     * Invoke the portlet with an action request.
     *
     * @param request  action request used for the invocation.
     * @param response action response used for the invocation.
     * @see PortletServlet
     * @see javax.portlet.Portlet#processAction(javax.portlet.ActionRequest,javax.portlet.ActionResponse)
     */
    public void action(ActionRequest request, ActionResponse response, InternalPortletWindow window, FilterManager filterManager)
        throws IOException, PortletException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Performing Action Invocation");
        }
        invoke(request, response, window, filterManager, Constants.METHOD_ACTION);
    }

    /**
     * Invoke the portlet with a render request.
     *
     * @param request  action request used for the invocation.
     * @param response action response used for the invocation.
     * @see PortletServlet
     * @see javax.portlet.Portlet#render(javax.portlet.RenderRequest,javax.portlet.RenderResponse)
     */
    public void render(RenderRequest request, RenderResponse response, InternalPortletWindow window, FilterManager filterManager)
        throws IOException, PortletException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Performing Render Invocation");
        }
        invoke(request, response, window, filterManager, Constants.METHOD_RENDER);
    }
    
    /**
     * Invoke the portlet with a render request.
     *
     * @param request  action request used for the invocation.
     * @param response action response used for the invocation.
     * @see PortletServlet
     * @see javax.portlet.Portlet#render(javax.portlet.RenderRequest,javax.portlet.RenderResponse)
     */
    public void event(EventRequest request, EventResponse response, InternalPortletWindow window, FilterManager filterManager)
        throws IOException, PortletException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Performing Render Invocation");
        }
        invoke((PortletRequest)request, (PortletResponse)response, window, filterManager, Constants.METHOD_EVENT);
    }
    
    /**
     * Invoke the portlet with a resource request.
     *
     * @param request  resource request used for the invocation.
     * @param response resource response used for the invocation.
     * @see PortletServlet
     * @see javax.portlet.Portlet#resource(javax.portlet.ResourceRequest,javax.portlet.ResourceResponse)
     */
    public void serveResource(ResourceRequest request, ResourceResponse response, InternalPortletWindow window, FilterManager filterManager)
        throws IOException, PortletException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Performing Resource Invocation");
        }
        invoke(request, response, window, filterManager, Constants.METHOD_RESOURCE);
    }

    /**
     * Invoke the portlet with a load request.
     *
     * @param request  action request used for the invocation.
     * @param response action response used for the invocation.
     * @see PortletServlet
     */
    public void load(PortletRequest request, PortletResponse response, InternalPortletWindow window)
        throws IOException, PortletException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Performing Load Invocation.");
        }
        invoke(request, response, window, Constants.METHOD_NOOP);
    }

    public void admin(PortletRequest request, PortletResponse response, InternalPortletWindow window)
        throws IOException, PortletException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Performing Admin Invocation.");
        }

        invoke(request, response, window, Constants.METHOD_ADMIN);
    }

    // Private Invoke Method ---------------------------------------------------

    private final void invoke(PortletRequest request,
                                PortletResponse response,
                                InternalPortletWindow portletWindow,
                                Integer methodID)
    	throws PortletException, IOException{
    	
    	invoke(request, response, portletWindow, null, methodID);
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
    protected final void invoke(PortletRequest request,
                                PortletResponse response,
                                InternalPortletWindow portletWindow,
                                FilterManager filterManager,
                                Integer methodID)
        throws PortletException, IOException {

        String uri = portletWindow.getPortletEntity().getControllerServletUri();
        if (LOG.isDebugEnabled()) {
            LOG.debug("Dispatching to portlet servlet at: " + uri);
        }

        ServletContext servletContext = portletWindow.getServletContext();
        RequestDispatcher dispatcher = servletContext.getRequestDispatcher(uri);

        if (dispatcher != null) {
            try {
                // Tomcat does not like to properly include wrapped requests
                // and responses. Thus we "unwrap" and then include.
                HttpServletRequest servletRequest =
                    ((PortletRequestImpl) request).getHttpServletRequest();
                HttpServletResponse servletResponse =
                    ((PortletResponseImpl) response).getHttpServletResponse();

                servletRequest.setAttribute(Constants.METHOD_ID, methodID);
                servletRequest.setAttribute(Constants.PORTLET_REQUEST, request);
                servletRequest.setAttribute(Constants.PORTLET_RESPONSE, response);
                servletRequest.setAttribute(Constants.FILTER_MANAGER, filterManager);

                dispatcher.include(servletRequest, servletResponse);

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
                request.removeAttribute(Constants.METHOD_ID);
                request.removeAttribute(Constants.PORTLET_REQUEST);
                request.removeAttribute(Constants.PORTLET_RESPONSE);
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