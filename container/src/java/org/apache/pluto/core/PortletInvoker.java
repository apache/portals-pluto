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

import java.io.IOException;

import javax.portlet.PortletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.core.impl.ActionRequestImpl;
import org.apache.pluto.core.impl.ActionResponseImpl;
import org.apache.pluto.core.impl.PortletRequestImpl;
import org.apache.pluto.core.impl.PortletResponseImpl;
import org.apache.pluto.core.impl.RenderRequestImpl;
import org.apache.pluto.core.impl.RenderResponseImpl;

class PortletInvoker {
    private static final Log LOG = LogFactory.getLog(PortletInvoker.class);

    private InternalPortletWindow window;


    /**
     * Default Constructor.
     * @param window
     */
    public PortletInvoker(InternalPortletWindow window) {
        this.window = window;
    }

    public void action(ActionRequestImpl request, ActionResponseImpl response)
        throws PortletException, IOException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Performing Action Invocation");
        }
        invoke(request, response, org.apache.pluto.Constants.METHOD_ACTION);
    }

    public void render(RenderRequestImpl request, RenderResponseImpl response)
        throws PortletException, IOException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Performing Action Invocation");
        }
        invoke(request, response, org.apache.pluto.Constants.METHOD_RENDER);
    }

    public void load(PortletRequestImpl request, PortletResponseImpl response)
        throws PortletException {
        try {
            invoke(request, response, org.apache.pluto.Constants.METHOD_NOOP);
        } catch (IOException e) {
            if (LOG.isErrorEnabled()) {
                LOG.error(
                    "PortletInvoker.load() - Error while dispatching portlet.",
                    e);
            }
            throw new PortletException(e);
        }
    }

    private void invoke(PortletRequestImpl request,
                        PortletResponseImpl response,
                        Integer methodID)
        throws PortletException, IOException {


        String uri = window.getPortletEntity().getControllerServletUri();
        ServletContext servletContext = window.getServletContext();
        RequestDispatcher dispatcher = servletContext.getRequestDispatcher(uri);

        if (dispatcher != null) {
            try {
                request.setAttribute(org.apache.pluto.Constants.METHOD_ID,
                                     methodID);
                request.setAttribute(
                    org.apache.pluto.Constants.PORTLET_REQUEST, request);
                request.setAttribute(
                    org.apache.pluto.Constants.PORTLET_RESPONSE, response);
                dispatcher.include(request, response);
            } catch (javax.servlet.UnavailableException e) {
                LOG.error(
                    "PortletInvoker.invoke() - Error while dispatching portlet.",
                    e);
                if (e.isPermanent()) {
                    throw new javax.portlet.UnavailableException(
                        e.getMessage());
                } else {
                    throw new javax.portlet.UnavailableException(
                        e.getMessage(), e.getUnavailableSeconds());
                }
            } catch (javax.servlet.ServletException e) {
                if (e.getRootCause() != null) {
                    LOG.error(
                        "PortletInvoker.render() - Error while dispatching portlet.",
                        e.getRootCause());
                    if (e.getRootCause() instanceof PortletException) {
                        throw (PortletException) e.getRootCause();
                    } else {
                        throw new PortletException(e.getRootCause());
                    }
                } else {
                    LOG.error(
                        "PortletInvoker.invoke() - Error while dispatching portlet.",
                        e);
                    throw new PortletException(e);
                }
            } finally {
                request.removeAttribute(org.apache.pluto.Constants.METHOD_ID);
                request.removeAttribute(
                    org.apache.pluto.Constants.PORTLET_REQUEST);
                request.removeAttribute(
                    org.apache.pluto.Constants.PORTLET_RESPONSE);
            }
        } else {
            LOG.error(
                "PortletInvoker.action() - Unable to find RequestDispatcher.");
        }
    }

}
