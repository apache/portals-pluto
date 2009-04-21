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
package org.apache.pluto.driver;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.pluto.container.PortletContainer;
import org.apache.pluto.container.PortletContainerException;
import org.apache.pluto.driver.core.PortalRequestContext;
import org.apache.pluto.driver.core.PortletWindowImpl;
import org.apache.pluto.driver.services.portal.PageConfig;
import org.apache.pluto.driver.services.portal.PortletWindowConfig;
import org.apache.pluto.driver.url.PortalURL;

/**
 * The controller servlet used to drive the Portal Driver. All requests mapped
 * to this servlet will be processed as Portal Requests.
 *
 * @version 1.0
 * @since Sep 22, 2004
 */
public class PortalDriverServlet extends HttpServlet {

    /** Internal Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(PortalDriverServlet.class);    
    
    /** The Portal Driver sServlet Context */
    private ServletContext servletContext = null;
    
    public static final String DEFAULT_PAGE_URI =
    		"/WEB-INF/themes/pluto-default-theme.jsp";
    
    /** The portlet container to which we will forward all portlet requests. */
    protected PortletContainer container = null;

    /** Character encoding and content type of the response */
    private String contentType = "";

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
        servletContext = getServletContext();
        container = (PortletContainer) servletContext.getAttribute(
        		AttributeKeys.PORTLET_CONTAINER);        
        String charset = getServletConfig().getInitParameter("charset");
        if (charset != null && charset.length() > 0) {
            contentType = "text/html; charset=" + charset;
        }

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
        if (LOG.isDebugEnabled()) {
        	LOG.debug("Start of PortalDriverServlet.doGet() to process portlet request . . .");
        }

        if ( contentType != "" ) {
            response.setContentType( contentType );
        }

        PortalRequestContext portalRequestContext =
            new PortalRequestContext(getServletContext(), request, response);

        PortalURL portalURL = null;
        
        try {
        	portalURL = portalRequestContext.getRequestedPortalURL();
        } catch(Exception ex) {
        	String msg = "Cannot handle request for portal URL. Problem: "  + ex.getMessage();
        	LOG.error(msg, ex);
        	throw new ServletException(msg, ex);
        }
        String actionWindowId = portalURL.getActionWindow();
        String resourceWindowId = portalURL.getResourceWindow();
        
        PortletWindowConfig actionWindowConfig = null;
        PortletWindowConfig resourceWindowConfig = null;
        
		if (resourceWindowId != null){
			resourceWindowConfig = PortletWindowConfig.fromId(resourceWindowId);
		} else if(actionWindowId != null){
			 actionWindowConfig = PortletWindowConfig.fromId(actionWindowId);
		}

        // Action window config will only exist if there is an action request.
        if (actionWindowConfig != null) {
            PortletWindowImpl portletWindow = new PortletWindowImpl(container,
            		actionWindowConfig, portalURL);
            if (LOG.isDebugEnabled()) {
                LOG.debug("Processing action request for window: "
                		+ portletWindow.getId().getStringId());
            }
            try {
                container.doAction(portletWindow, request, response);
            } catch (PortletContainerException ex) {
            	LOG.error(ex.getMessage(), ex);
                throw new ServletException(ex);
            } catch (PortletException ex) {
            	LOG.error(ex.getMessage(), ex);
                throw new ServletException(ex);
            }
            if (LOG.isDebugEnabled()) {
            	LOG.debug("Action request processed.\n\n");
            }
        }
        //Resource request
        else if (resourceWindowConfig != null) {
            PortletWindowImpl portletWindow = new PortletWindowImpl(container,
                               resourceWindowConfig, portalURL);
            if (LOG.isDebugEnabled()) {
                LOG.debug("Processing resource Serving request for window: "
                               + portletWindow.getId().getStringId());
            }
            try {
                container.doServeResource(portletWindow, request, response);
            } catch (PortletContainerException ex) {
            	LOG.error(ex.getMessage(), ex);
                throw new ServletException(ex);
            } catch (PortletException ex) {
            	LOG.error(ex.getMessage(), ex);
                throw new ServletException(ex);
            }
            if (LOG.isDebugEnabled()) {
               LOG.debug("Resource serving request processed.\n\n");
            }
        }
        // Otherwise (actionWindowConfig == null), handle the render request.
        else {
        	if (LOG.isDebugEnabled()) {
        		LOG.debug("Processing render request.");
        	}
            PageConfig pageConfig = portalURL.getPageConfig(servletContext);
            if (pageConfig == null)
            {
            	String renderPath = (portalURL == null ? "" : portalURL.getRenderPath());
                String msg = "PageConfig for render path [" + renderPath + "] could not be found.";
                LOG.error(msg);
                throw new ServletException(msg);
            }
            
            request.setAttribute(AttributeKeys.CURRENT_PAGE, pageConfig);
            String uri = (pageConfig.getUri() != null)
            		? pageConfig.getUri() : DEFAULT_PAGE_URI;
            if (LOG.isDebugEnabled()) {
            	LOG.debug("Dispatching to: " + uri);
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher(uri);
            dispatcher.forward(request, response);
            if (LOG.isDebugEnabled()) {
            	LOG.debug("Render request processed.\n\n");
            }
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
}

