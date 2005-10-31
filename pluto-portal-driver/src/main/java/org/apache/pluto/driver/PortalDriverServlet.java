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
package org.apache.pluto.driver;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.PortletContainer;
import org.apache.pluto.PortletContainerException;
import org.apache.pluto.driver.config.DriverConfiguration;
import org.apache.pluto.driver.core.PortalEnvironment;
import org.apache.pluto.driver.core.PortalURL;
import org.apache.pluto.driver.core.PortletWindowImpl;
import org.apache.pluto.driver.services.impl.resource.PageConfig;
import org.apache.pluto.driver.services.impl.resource.PortletWindowConfig;

import javax.portlet.PortletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The controller servlet used to drive the Portal Driver. All requests mapped
 * to this servlet will be processed as Portal Requests.
 * 
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version 1.0
 * @since Sep 22, 2004
 */
public class PortalDriverServlet extends HttpServlet {

    /** Internal Logger. */
    private static final Log LOG = LogFactory.getLog(PortalDriverServlet.class);

    /** The portlet container to which we will forward all portlet requests. */
    protected PortletContainer container = null;

    /** The driver configuration defining our configuraiton. */
    protected DriverConfiguration driverConfig = null;

    /**
     * Initialize the Portal Driver. Initialization completes the following
     * tasks:
     * <ul>
     *   <li>Retrieve and cache the <code>PortletContainer</code>.</li>
     *   <li>Retrieve and cache the <code>DriverConfigurationImpl</code>.</li>
     * </ul>
     * @see PortletContainer
     * @see DriverConfigurationImpl
     */
    public void init() {
        ServletContext servletContext = getServletContext();
        container = (PortletContainer) servletContext.getAttribute(
        		AttributeKeys.PORTLET_CONTAINER);
        driverConfig = (DriverConfiguration) servletContext.getAttribute(
        		AttributeKeys.DRIVER_CONFIG);
    }

    /**
     * Handle all requests.
     * @param request  the incoming HttpServletRequest.
     * @param response  the incoming HttpServletResponse.
     * @throws ServletException  if an internal error occurs.
     * @throws IOException  if an error occurs writing to the response.
     */
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
    throws ServletException, IOException {

        PortalEnvironment environment = new PortalEnvironment(
        		request, response);
        PortalURL currentURL = environment.getRequestedPortalURL();
        String actionWindowId = currentURL.getActionWindow();
        PortletWindowConfig windowConfig = driverConfig.getPortletWindowConfig(
        		actionWindowId);

        // Window will only exist if there's an action.
        if (windowConfig != null) {
            PortletWindowImpl portletWindow = new PortletWindowImpl(
            		windowConfig, currentURL);
            if (LOG.isDebugEnabled()) {
                LOG.debug("Processing action request for window: "
                		+ portletWindow.getId());
            }
            try {
                container.doAction(portletWindow, request, response);
            } catch (PortletContainerException ex) {
                throw new ServletException(ex);
            } catch (PortletException ex) {
                throw new ServletException(ex);
            }
        } else {
            PageConfig pageConfig = getPageConfig(currentURL);
            request.setAttribute(AttributeKeys.CURRENT_PAGE, pageConfig);
            String uri = pageConfig.getUri();
            RequestDispatcher dispatcher = request.getRequestDispatcher(uri);
            dispatcher.forward(request, response);
        }
    }

    protected PageConfig getPageConfig(PortalURL currentURL) {
        String currentPage = currentURL.getRenderPath();
        if (LOG.isDebugEnabled()) {
            LOG.debug("Rendering Portal: Requested Page: " + currentPage);
        }
        return driverConfig.getPageConfig(currentPage);
    }


    /**
     * Pass all requests to {@link #doPost(HttpServletRequest, HttpServletResponse)}.
     * @param request  the incoming servlet request.
     * @param response  the incoming servlet response.
     * @throws ServletException if an exception occurs.
     * @throws IOException if an exception occurs writing to the response.
     */
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
    throws ServletException, IOException {
        doGet(request, response);
    }
    
}

