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

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.pluto.PortletContainerException;
import org.apache.pluto.Constants;
import org.apache.pluto.binding.PortletAppDD;
import org.apache.pluto.binding.PortletDD;
import org.apache.pluto.core.impl.ActionRequestImpl;
import org.apache.pluto.core.impl.ActionResponseImpl;
import org.apache.pluto.core.impl.PortletConfigImpl;
import org.apache.pluto.core.impl.RenderRequestImpl;
import org.apache.pluto.core.impl.RenderResponseImpl;

/**
 * Portlet Invocation Servlet. This servlet recieves cross context requests from
 * the the container and services the portlet request for the specified method.
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>
 * @version 1.1
 * @since 09/22/2004
 */
public class PortletServlet extends HttpServlet {

    private String portletName;

    private Portlet portlet;
    private InternalPortletContext portletContext;
    private InternalPortletConfig portletConfig;

    public String getServletInfo() {
        return "Pluto PortletServlet [" + portletName + "]";
    }

    public void init() throws ServletException {

        portletName = getInitParameter("portlet-name");

        ServletContext context = getServletContext();

        try {
            portletContext =
            PortletContextManager.getManager().getContext(context);
        } catch (PortletContainerException pce) {
            throw new ServletException(pce);
        }

        PortletAppDD appDD = portletContext.getPortletApplicationDefinition();
        PortletDD[] dds = appDD.getPortlets();

        PortletDD dd = null;
        for (int i = 0; i < dds.length; i++) {
            if (dds[i].getPortletName().equals(portletName)) {
                dd = dds[i];
                break;
            }
        }

        if (dd == null) {
            throw new ServletException(
                "Unable to resolve portlet '" + portletName + "'");
        }

        portletConfig = new PortletConfigImpl(getServletConfig(),
                                              portletContext, dd);

        try {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            Class pClass = loader.loadClass((dd.getPortletClass()));
            portlet = (Portlet) pClass.newInstance();
            portlet.init(portletConfig);
        } catch (ClassNotFoundException cne) {
            cne.printStackTrace();
            throw new ServletException(cne);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new ServletException(e);
        } catch (InstantiationException e) {
            e.printStackTrace();
            throw new ServletException(e);
        } catch (PortletException pe) {
            pe.printStackTrace();
            throw new ServletException(pe);
        }
    }

    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
        throws ServletException, IOException {
        dispatch(req, resp);
    }

    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
        throws ServletException, IOException {
        dispatch(req, resp);
    }

    protected void doPut(HttpServletRequest req,
                         HttpServletResponse resp)
        throws ServletException, IOException {
        dispatch(req, resp);
    }

    public void destroy() {
        if (portlet != null) {
            portlet.destroy();
        }
        super.destroy();
    }

    private void dispatch(HttpServletRequest request,
                          HttpServletResponse response)
        throws ServletException, IOException {
        try {
            request.setAttribute(org.apache.pluto.Constants.PORTLET_CONFIG,
                                 portletConfig);

            Integer method_id =
                (Integer) request.getAttribute(
                    org.apache.pluto.Constants.METHOD_ID);

            InternalPortletRequest pRequest = (InternalPortletRequest)
                request.getAttribute(Constants.PORTLET_REQUEST);

            InternalPortletResponse pResponse = (InternalPortletResponse)
                request.getAttribute(Constants.PORTLET_RESPONSE);

            pRequest.setPortletContext(portletContext);


            if (method_id == org.apache.pluto.Constants.METHOD_RENDER) {
                RenderRequestImpl renderRequest =
                    (RenderRequestImpl) pRequest;

                RenderResponseImpl renderResponse =
                    (RenderResponseImpl) pResponse;

                //renderRequest.lateInit(request);
                //renderResponse.lateInit(request, response);

                portlet.render(renderRequest, renderResponse);
            } else if (method_id == org.apache.pluto.Constants.METHOD_ACTION) {
                ActionRequestImpl actionRequest =
                    (ActionRequestImpl) pRequest;

                ActionResponseImpl actionResponse =
                    (ActionResponseImpl) pResponse;

                //actionRequest.lateInit(request);
                //actionResponse.lateInit(request, response);

                portlet.processAction(actionRequest, actionResponse);
            } else if (method_id == org.apache.pluto.Constants.METHOD_NOOP) {
                //nothing to do
            }

        } catch (javax.portlet.UnavailableException e) {
            e.printStackTrace();
            /*
            if (e.isPermanent()) {
                throw new UnavailableException(e.getMessage());
            } else {
                throw new UnavailableException(e.getMessage(), e.getUnavailableSeconds());
            }*/

            // destroy isn't called by Tomcat, so we have to fix it
            try {
                portlet.destroy();
            } catch (Throwable t) {
                // don't care for Exception
            }

            // handle everything as permanently for now
            throw new javax.servlet.UnavailableException(e.getMessage());
        } catch (PortletException e) {
            e.printStackTrace();
            throw new ServletException(e);
        } finally {
            request.removeAttribute(org.apache.pluto.Constants.PORTLET_CONFIG);
        }
    }
}
