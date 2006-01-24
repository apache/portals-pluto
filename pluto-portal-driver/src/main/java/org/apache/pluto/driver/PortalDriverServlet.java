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
import org.apache.pluto.driver.services.portal.PageConfig;
import org.apache.pluto.driver.services.portal.PortletWindowConfig;

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
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>
 * @author <a href="mailto:zheng@apache.org">ZHENG Zhong</a>
 * @version 1.0
 * @since Sep 22, 2004
 */
public class PortalDriverServlet extends HttpServlet {

    /** Internal Logger. */
    private static final Log LOG = LogFactory.getLog(PortalDriverServlet.class);

    /** The portlet container to which we will forward all portlet requests. */
    protected PortletContainer container = null;
    
    
    // HttpServlet Impl --------------------------------------------------------
    
    public String getServletInfo() {
        return "Pluto Portal Driver Servlet";
    }
    
    /**
     * Initialize the Portal Driver. This method retrieves the portlet container
     * instance from the servlet context scope.
     * @see PortletContainer
     */
    public void init() {
        ServletContext servletContext = getServletContext();
        container = (PortletContainer) servletContext.getAttribute(
        		AttributeKeys.PORTLET_CONTAINER);
    }
    

    /**
     * Handle all requests. All POST requests are passed to this method.
     * @param request  the incoming HttpServletRequest.
     * @param response  the incoming HttpServletResponse.
     * @throws ServletException  if an internal error occurs.
     * @throws IOException  if an error occurs writing to the response.
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        PortalEnvironment portalEnvironment = new PortalEnvironment(
        		request, response);
        PortalURL currentURL = portalEnvironment.getRequestedPortalURL();
        String actionWindowId = currentURL.getActionWindow();
        PortletWindowConfig actionWindowConfig = getDriverConfiguration()
        		.getPortletWindowConfig(actionWindowId);

        // Action window config will only exist if there is an action request.
        if (actionWindowConfig != null) {
            PortletWindowImpl portletWindow = new PortletWindowImpl(
            		actionWindowConfig, currentURL);
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
        }
        
        // Otherwise, handle the render request.
        else {
            PageConfig pageConfig = getPageConfig(currentURL);
            request.setAttribute(AttributeKeys.CURRENT_PAGE, pageConfig);
            String uri = pageConfig.getUri();
            RequestDispatcher dispatcher = request.getRequestDispatcher(uri);
            dispatcher.forward(request, response);
        }
    }

    /**
     * Pass all POST requests to {@link #doGet(HttpServletRequest, HttpServletResponse)}.
     * @param request  the incoming servlet request.
     * @param response  the incoming servlet response.
     * @throws ServletException if an exception occurs.
     * @throws IOException if an exception occurs writing to the response.
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doGet(request, response);
    }
    
    
    // Private Methods ---------------------------------------------------------
    
    private PageConfig getPageConfig(PortalURL currentURL) {
        String currentPage = currentURL.getRenderPath();
        if (LOG.isDebugEnabled()) {
            LOG.debug("Rendering Portal: Requested Page: " + currentPage);
        }
        return getDriverConfiguration().getPageConfig(currentPage);
    }
    
    /**
     * Returns the portal driver configuration object.
     * @return the portal driver configuration object.
     */
    private DriverConfiguration getDriverConfiguration() {
        return (DriverConfiguration) getServletContext().getAttribute(
        		AttributeKeys.DRIVER_CONFIG);
    }

    
    
}

