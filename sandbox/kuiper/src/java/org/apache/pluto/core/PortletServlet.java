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
import org.apache.pluto.PortletWindow;
import org.apache.pluto.services.Logger;
import org.apache.pluto.services.LoggerService;
import org.apache.pluto.services.OptionalServiceFactory;
import org.apache.pluto.impl.PortletContextImpl;
import org.apache.pluto.binding.PortletDD;
import org.apache.pluto.binding.XMLBinding;
import org.apache.pluto.binding.PortletAppDD;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.ServletException;
import javax.portlet.*;
import java.io.IOException;
import java.util.Map;

/** <P>Servlet used by the PlutoContainer to interact with and
 *  invoke a portlet application.  The PortletServlet is a thin
 *  wrapper around the Portlets.  It is the responsibility of this
 *  servlet to provide the container with the resources necessary
 *  for Portlet instantiation and rendering (including it's
 *  context classloader).</P>
 *
 *  <P>The PortletServlet obtains container information from
 *  through request attributes.  </P>
 *
 *  <P>NOTE: In the future we need to support an "Optional"
 *  factory of some sort which this servlet may use to
 *  create it's PortletRequest, PortletResponse, PortletContext
 *  and other critical components.</P>
 *
 * @author <A href="mailto:ddewolf@apache.org">David H. DeWolf</A>
 * @version 1.0
 * @since Mar 9, 2004 at 2:52:59 PM
 */
public class PortletServlet extends HttpServlet {

    /** Indicates whether this servlet has been
     *  initialized.  This flag is required since
     *  full initialization may not take place until
     *  a request is made.
     */
    private boolean isInitialized;

    /** The {@link PortletContext} within which
     *  we reside.
     */
    private PortletContext portletContext;

    /** Logging facility. */
    private Logger logger;

    /** Initialize the Servlet.  This initialization
     *  may not fully initialize the container since we
     *  are dependent upon several container components.
     */
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

    /** Initialize the servlet.  This initialization occurs
     *  during the initial invocation which comes from the
     *  container.
     *
     *  <P>NOTE: do we need to support the fact that two
     *  containers MAY use us?  If we do, some refactoring
     *  is needed.</P>
     *
     * @param registry used to manage portlet instances.
     * @param service logger service
     * @throws PlutoException
     * @throws PortletException
     * @throws IOException
     */
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

    /** Process the get request providing all expected request
     *  attributes are present.
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
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

    /** Process the post request providing all
     *  expected request attributes are present.
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
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

    /** Process the PortletInvocation. */
    private void doPortlet(HttpServletRequest request,
                           HttpServletResponse response)
    throws ServletException, IOException, PortletException, PlutoException {

        OptionalServiceFactory factory = (OptionalServiceFactory)
            request.getAttribute(PlutoConstants.SERVICE_FACTORY);

        PortletRegistry registry = (PortletRegistry)
            request.getAttribute(PlutoConstants.PORTLET_REGISTRY);

        LoggerService loggerService = factory.getLoggerService();

        if(registry==null || loggerService==null) {
            throw new ServletException("Invalid Invocation.  This servlet"
                                      +" should only be invoked by a valid"
                                      +" Pluto container.");
        }

        if(!isInitialized) {
            initInternal(registry, loggerService);
        }

        PortletWindow window = (PortletWindow)
            request.getAttribute(PlutoConstants.PORTLET_WINDOW);

        String method = (String)
            request.getAttribute(PlutoConstants.REQUEST_METHOD);

        /* The old way, but why lock portals into defining the
           id as we do?

        String shortId = window.getPortletId();
        shortId = shortId.substring(shortId.lastIndexOf(".")+1);

        */
        String shortId = window.getPortletName();
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
                factory.getRequestFactoryService()
                    .createActionRequest(request, response,
                                         portletContext, window
                    );

            Map renderParameters = new java.util.HashMap();
            ActionResponse resp =
                factory.getResponseFactoryService()
                    .createActionResponse(request, response,
                                          portletContext, window,
                                          renderParameters
                    );

            // Do we need to set attributes here too? or just render?
            if(logger.isInfoEnabled()) {
                logger.info("Invoking portlet action: "
                            +config.getPortletName());
            }
            portlet.processAction(requ,resp);

            request.setAttribute(
                PlutoConstants.RENDER_PARAMETERS,
                renderParameters
            );
        }

        else if(PlutoConstants.RENDER_REQUEST.equals(method)) {
            Map renderParameters = (Map)
                request.getAttribute(PlutoConstants.RENDER_PARAMETERS);
            // null is ok - it means action wasn't done

            RenderRequest requ =
                factory.getRequestFactoryService()
                    .createRenderRequest(request, response,
                                         portletContext, window,
                                         renderParameters
                    );

            RenderResponse resp =
                factory.getResponseFactoryService()
                    .createRenderResponse(request, response,
                                          portletContext, window

                    );

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
            // load just ensures that we
            // can get here - right?
        }
        else {
            throw new ServletException("Invalid Request Method: "
                                       +method);
        }
    }
}
