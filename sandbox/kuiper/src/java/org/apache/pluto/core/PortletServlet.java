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

import org.apache.pluto.PlutoConstants;
import org.apache.pluto.PlutoException;
import org.apache.pluto.PlutoEnvironment;
import org.apache.pluto.PortletWindow;
import org.apache.pluto.services.Logger;
import org.apache.pluto.services.LoggerService;
import org.apache.pluto.services.PortletURLService;
import org.apache.pluto.impl.PortletContextImpl;
import org.apache.pluto.impl.ActionRequestImpl;
import org.apache.pluto.impl.ActionResponseImpl;
import org.apache.pluto.impl.RenderRequestImpl;
import org.apache.pluto.impl.RenderResponseImpl;
import org.apache.pluto.binding.PortletDD;
import org.apache.pluto.binding.XMLBinding;
import org.apache.pluto.binding.PortletAppDD;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.ServletException;
import javax.portlet.*;
import java.io.IOException;

/**
 *
 * @author <A href="mailto:ddewolf@apache.org">David H. DeWolf</A>
 * @version 1.0
 * @since Mar 9, 2004 at 2:52:59 PM
 */
public class PortletServlet extends HttpServlet {

    private boolean isInitialized;

    private PortletContext portletContext;
    private Logger logger;

    public void init() {
        // NO Initalization may be performed here.
        // We MUST have access to the container - which
        // we retrieve through the request.  B/C of this,
        // we utilize a lazy configuration strategy
        // FOR EACH container.
        //
        // I'm not sure if this is correct. . .BUT assuming
        // that multiple containers may be used with a single
        // portlet app deployment, this will allow the portlet
        // to have a single instance per container.
    }

    private synchronized void initInternal(PortletRegistry registry,
                                           LoggerService service)
    throws PlutoException, PortletException, IOException {
        if(isInitialized) {
            return;
        }

        logger = service.getLogger(PortletServlet.class);
        if(logger.isDebugEnabled()) {
            logger.debug("Initializing PortletServlet");
        }

        portletContext = new PortletContextImpl(
                             getServletConfig().getServletContext(),
                             service
                         );

        /** We should probaly only parse the
         *  xml file once and put it in the context.
         */
        XMLBinding binding = XMLBinding.getXMLBinding(XMLBinding.READ_ONLY);
        PortletAppDD deploymentDescriptor =
            binding.getPortletAppDD(
                getServletContext().getResourceAsStream("/WEB-INF/portlet.xml")
            );

        PortletDD[] dds = deploymentDescriptor.getPortlets();

        for(int i=0;i<dds.length;i++) {
            if(logger.isDebugEnabled()) {
                logger.debug("Initializing portlet: "+dds[i].getPortletName());
            }
            registry.register(dds[i], portletContext);
        }
        this.isInitialized = true;
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
    throws ServletException, IOException {
        try {
            doPortlet(request,response);
        }
        catch(PortletException pe) {
            logger.error("Error during dispatch: "+pe.getMessage(),
                         pe);
            throw new ServletException(pe);
        }
        catch(PlutoException pe) {
            logger.error("Error during dispatch: "+pe.getMessage(),
                         pe);
            throw new ServletException(pe);
        }
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        try {
            doPortlet(request,response);
        }
        catch(PortletException pe) {
            logger.error("Error during dispatch: "+pe.getMessage(),
                         pe);
            throw new ServletException(pe);
        }
        catch(PlutoException pe) {
            logger.error("Error during dispatch: "+pe.getMessage(),
                         pe);
            throw new ServletException(pe);
        }
    }

    private void doPortlet(HttpServletRequest request,
                           HttpServletResponse response)
    throws ServletException, IOException, PortletException, PlutoException {

        PortletRegistry registry = (PortletRegistry)
            request.getAttribute(PlutoConstants.PORTLET_REGISTRY);

        LoggerService loggerService = (LoggerService)
            request.getAttribute(PlutoConstants.LOGGER_SERVICE);

        if(!isInitialized) {
            initInternal(registry, loggerService);
        }

        PortletURLService portletURLService = (PortletURLService)
            request.getAttribute(PlutoConstants.PORTLET_URL_SERVICE);

        PortletWindow window = (PortletWindow)
            request.getAttribute(PlutoConstants.PORTLET_WINDOW);

        PlutoEnvironment plutoEnvironment = (PlutoEnvironment)
            request.getAttribute(PlutoConstants.PLUTO_ENVIRONMENT);

        String method = (String)
            request.getAttribute(PlutoConstants.REQUEST_METHOD);

        String shortId = window.getPortletId();
        shortId = shortId.substring(shortId.lastIndexOf(".")+1);
        RegisteredPortlet rp = registry.getPortlet(shortId);

        if(rp==null && logger.isErrorEnabled()) {
            logger.error("No Portlet registered as: "+shortId+" found.");
        }

        Portlet portlet = rp.getPortlet();
        PortletConfig config = rp.getConfig();

        if(logger.isDebugEnabled()) {
            logger.debug("Invoking portlet: "+portlet
                         +" with request method: "+method);
        }

        if(PlutoConstants.ACTION_REQUEST.equals(method)) {
            ActionRequest requ =
                new ActionRequestImpl(
                    plutoEnvironment,
                    portletContext,
                    window,
                    request
                );

            ActionResponse resp = new ActionResponseImpl(window, response);

            if(logger.isInfoEnabled()) {
                logger.info("Invoking portlet action: "
                            +config.getPortletName());
            }
            portlet.processAction(requ,resp);
        }
        else if(PlutoConstants.RENDER_REQUEST.equals(method)) {
            RenderRequest requ =
                new RenderRequestImpl(plutoEnvironment, portletContext,
                                      window, request);

            RenderResponse resp =
                new RenderResponseImpl(window, request,
                                       response,
                                       portletURLService);

            request.setAttribute(
                PlutoConstants.PORTLET_REQUEST,
                requ
            );

            request.setAttribute(
                PlutoConstants.PORTLET_RESPONSE,
                resp
            );

            request.setAttribute(
                PlutoConstants.PORTLET_CONFIG,
                config
            );

            if(logger.isInfoEnabled()) {
                logger.info("Rendering portlet: "
                            +config.getPortletName());
            }
            portlet.render(requ,resp);
        }
        else if(PlutoConstants.LOAD_REQUEST.equals(method)) {
            // do nothing.
            // load just ensure taht we
            // can get here - right?
        }
        else {
            throw new ServletException("Invalid Request Method: "
                                       +method);
        }
    }
}
