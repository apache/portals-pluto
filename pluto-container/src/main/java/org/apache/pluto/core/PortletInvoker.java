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

import java.io.IOException;

import javax.portlet.PortletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.core.impl.ActionRequestImpl;
import org.apache.pluto.core.impl.ActionResponseImpl;
import org.apache.pluto.core.impl.PortletRequestImpl;
import org.apache.pluto.core.impl.PortletResponseImpl;
import org.apache.pluto.core.impl.RenderRequestImpl;
import org.apache.pluto.core.impl.RenderResponseImpl;
import org.apache.pluto.util.StringManager;

/**
 * Used internally to invoke/dispatch requests from the container to
 * the portlet application.
 *
 * @version $Id$
 *
 */
class PortletInvoker {

    /** Internal Logger.  */
    private static final Log LOG = LogFactory.getLog(PortletInvoker.class);

    /** Exception Messages. */
    private static final StringManager EXCEPTIONS =
        StringManager.getManager(PortletInvoker.class.getPackage().getName());

    /**
     * Portlet Window for which we are invoking
     * the portlet.
     */
    private InternalPortletWindow window;

    /**
     * Default Constructor.  Create a new invoker which
     * is initialized for the given <code>InternalPortletWindow</code>.
     *
     * @param window portlet window.
     */
    public PortletInvoker(InternalPortletWindow window) {
        this.window = window;
    }

    /**
     * Invoke the portlet with an action request.
     *
     * @param request action request used for the invocation.
     * @param response action response used for the invocation.
     * @throws PortletException if a error occurs within the portlet.
     * @throws IOException if an IO error occurs writing the response.
     *
     * @see PortletServlet
     * @see javax.portlet.Portlet#processAction(javax.portlet.ActionRequest, javax.portlet.ActionResponse)
     */
    public void action(ActionRequestImpl request, ActionResponseImpl response)
        throws PortletException, IOException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Performing Action Invocation");
        }
        invoke(request, response, org.apache.pluto.Constants.METHOD_ACTION);
    }

    /**
     * Invoke the portlet with a render request.
     *
     * @param request action request used for the invocation.
     * @param response action response used for the invocation.
     * @throws PortletException if a error occurs within the portlet.
     * @throws IOException if an IO error occurs writing the response.
     *
     * @see PortletServlet
     * @see javax.portlet.Portlet#render(javax.portlet.RenderRequest, javax.portlet.RenderResponse)
     */
    public void render(RenderRequestImpl request, RenderResponseImpl response)
        throws PortletException, IOException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Performing Render Invocation");
        }
        invoke(request, response, org.apache.pluto.Constants.METHOD_RENDER);
    }

    /**
     * Invoke the portlet with a load request.
     *
     * @param request action request used for the invocation.
     * @param response action response used for the invocation.
     * @throws PortletException if a error occurs within the portlet.
     *
     * @see PortletServlet
     */
    public void load(PortletRequestImpl request, PortletResponseImpl response)
        throws PortletException, IOException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Performing Load Invocation");
        }
        invoke(request, response, org.apache.pluto.Constants.METHOD_NOOP);
    }

    /**
     * Perform the invocation.
     *
     * @param request portlet request
     * @param response portlet response
     * @param methodID method identifier
     * @throws PortletException if a portlet exception occurs.
     * @throws IOException if an error occurs writing to the response.
     */
    private void invoke(PortletRequestImpl request,
                        PortletResponseImpl response,
                        Integer methodID)
        throws PortletException, IOException {

        String uri = window.getPortletEntity().getControllerServletUri();
        ServletContext servletContext = window.getServletContext();
        RequestDispatcher dispatcher = servletContext.getRequestDispatcher(uri);

        if (dispatcher != null) {
            try {
                // Tomcat does not like to properly include wrapped requests
                // and responses. Thus we "unwrap" and then include.
                HttpServletRequest req = request.getHttpServletRequest();
                HttpServletResponse res = response.getHttpServletResponse();

                req.setAttribute(org.apache.pluto.Constants.METHOD_ID,
                                     methodID);
                req.setAttribute(
                    org.apache.pluto.Constants.PORTLET_REQUEST, request);

                req.setAttribute(
                    org.apache.pluto.Constants.PORTLET_RESPONSE, response);

                dispatcher.include(req, res);

            } catch (javax.servlet.UnavailableException e) {
                int seconds = e.isPermanent()?-1:e.getUnavailableSeconds();
                String message =  EXCEPTIONS.getString(
                    "error.portlet.unavailable",
                    new String[] {String.valueOf(seconds)}
                );
                if(LOG.isErrorEnabled()) {
                    LOG.error(message, e);
                }
                throw new javax.portlet.UnavailableException(
                        message, seconds
                );
            } catch (javax.servlet.ServletException e) {
                String message = EXCEPTIONS.getString("error.portlet.invoke");
                if(LOG.isErrorEnabled()) {
                    LOG.error(message);
                }

                if (e.getRootCause() != null &&
                    e.getRootCause() instanceof PortletException) {
                        throw (PortletException) e.getRootCause();
                }
                else if(e.getRootCause() != null) {
                    throw new PortletException(e.getRootCause());
                }
                else {
                    throw new PortletException(e);
                }
            } finally {
                request.removeAttribute(org.apache.pluto.Constants.METHOD_ID);
                request.removeAttribute(org.apache.pluto.Constants.PORTLET_REQUEST);
                request.removeAttribute(org.apache.pluto.Constants.PORTLET_RESPONSE);
            }
        } else {
            String msg = EXCEPTIONS.getString(
                "error.portlet.invoker.dispatcher",
                new String[] {servletContext.getServletContextName(), uri}
            );
            if(LOG.isErrorEnabled()) {
                LOG.error(msg);
            }
            throw new PortletException(msg);
        }
    }

}
