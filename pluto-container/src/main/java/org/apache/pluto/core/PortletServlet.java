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
import java.util.Iterator;

import javax.portlet.EventPortlet;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ResourceServingPortlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.pluto.Constants;
import org.apache.pluto.PortletContainerException;
import org.apache.pluto.descriptors.portlet.PortletAppDD;
import org.apache.pluto.descriptors.portlet.PortletDD;
import org.apache.pluto.internal.InternalPortletConfig;
import org.apache.pluto.internal.InternalPortletContext;
import org.apache.pluto.internal.InternalPortletRequest;
import org.apache.pluto.internal.InternalPortletResponse;
import org.apache.pluto.internal.impl.ActionRequestImpl;
import org.apache.pluto.internal.impl.ActionResponseImpl;
import org.apache.pluto.internal.impl.EventRequestImpl;
import org.apache.pluto.internal.impl.EventResponseImpl;
import org.apache.pluto.internal.impl.PortletConfigImpl;
import org.apache.pluto.internal.impl.RenderRequestImpl;
import org.apache.pluto.internal.impl.RenderResponseImpl;
import org.apache.pluto.internal.impl.ResourceRequestImpl;
import org.apache.pluto.internal.impl.ResourceResponseImpl;
import org.apache.pluto.spi.FilterManager;

/**
 * Portlet Invocation Servlet. This servlet recieves cross context requests from
 * the the container and services the portlet request for the specified method.
 * 
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>
 * @author <a href="mailto:zheng@apache.org">ZHENG Zhong</a>
 * @version 1.1
 * @since 09/22/2004
 */
public class PortletServlet extends HttpServlet {
	
	// Private Member Variables ------------------------------------------------
	
	/** The portlet name as defined in the portlet app descriptor. */
    private String portletName = null;
    
    /** The portlet instance wrapped by this servlet. */
    private Portlet portlet = null;
    
    /** The Event Portlet instance (the same object as portlet) wrapped by this servlet. */
    private EventPortlet eventPortlet = null;
    
    /** The resource serving portlet instance wrapped by this servlet. */
    private ResourceServingPortlet resourceServingPortlet = null;
    
    /** The internal portlet context instance. */
    private InternalPortletContext portletContext = null;
    
    /** The internal portlet config instance. */
    private InternalPortletConfig portletConfig = null;
    
    
    // HttpServlet Impl --------------------------------------------------------
    
    public String getServletInfo() {
        return "Pluto PortletServlet [" + portletName + "]";
    }
    
    /**
     * Initialize the portlet invocation servlet.
     * @throws ServletException  if an error occurs while loading portlet.
     */
    public void init() throws ServletException {
    	
    	// Call the super initialization method.
    	super.init();
    	
    	// Retrieve portlet name as defined as an initialization parameter.
        portletName = getInitParameter("portlet-name");
        
        // Retrieve the associated internal portlet context.
        ServletContext servletContext = getServletContext();
        try {
            portletContext = PortletContextManager.getManager()
            		.getPortletContext(servletContext, portletName);
        } catch (PortletContainerException ex) {
            throw new ServletException(ex);
        }
        
        // Retrieve the portletDD and create portlet config.
        PortletDD portletDD = null;
        PortletAppDD portletAppDD =
        		portletContext.getPortletApplicationDefinition();
        for (Iterator it = portletAppDD.getPortlets().iterator();
        		it.hasNext(); ) {
        	PortletDD currentDD = (PortletDD) it.next();
        	if (currentDD.getPortletName().equals(portletName)) {
        		portletDD = currentDD;
        		break;
        	}
        }
        if (portletDD == null) {
            throw new ServletException("Unable to resolve portlet '"
            		+ portletName + "'");
        }
        portletConfig = new PortletConfigImpl(getServletConfig(),
                                              portletContext,
                                              portletDD);
        
        // Create and initialize the portlet wrapped in the servlet.
        try {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            Class clazz = loader.loadClass((portletDD.getPortletClass()));
            portlet = (Portlet) clazz.newInstance();
            portlet.init(portletConfig);
            initializeEventPortlet();
            initializeResourceServingPortlet();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            throw new ServletException(ex);
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
            throw new ServletException(ex);
        } catch (InstantiationException ex) {
            ex.printStackTrace();
            throw new ServletException(ex);
        } catch (PortletException ex) {
            ex.printStackTrace();
            throw new ServletException(ex);
        }
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
    throws ServletException, IOException {
        dispatch(request, response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
    throws ServletException, IOException {
        dispatch(request, response);
    }

    protected void doPut(HttpServletRequest request,
                         HttpServletResponse response)
    throws ServletException, IOException {
        dispatch(request, response);
    }

    public void destroy() {
        if (portlet != null) {
            portlet.destroy();
        }
        super.destroy();
    }
    
    
    // Private Methods ---------------------------------------------------------
    
    /**
     * Dispatch the request to the appropriate portlet methods. This method
     * assumes that the following attributes are set in the servlet request
     * scope:
     * <ul>
     *   <li>METHOD_ID: indicating which method to dispatch.</li>
     *   <li>PORTLET_REQUEST: the internal portlet request.</li>
     *   <li>PORTLET_RESPONSE: the internal portlet response.</li>
     * </ul>
     * 
     * @param request  the servlet request.
     * @param response  the servlet response.
     * @throws ServletException
     * @throws IOException
     */
    private void dispatch(HttpServletRequest request,
                          HttpServletResponse response)
    throws ServletException, IOException {
        InternalPortletRequest portletRequest = null;
        InternalPortletResponse portletResponse = null;
        try {
        	
        	// Save portlet config into servlet request.
            request.setAttribute(Constants.PORTLET_CONFIG, portletConfig);
            
            // Retrieve attributes from the servlet request.
            Integer methodId = (Integer) request.getAttribute(
            		Constants.METHOD_ID);
            portletRequest = (InternalPortletRequest) request.getAttribute(
            		Constants.PORTLET_REQUEST);
            portletResponse = (InternalPortletResponse) request.getAttribute(
            		Constants.PORTLET_RESPONSE);
            portletRequest.init(portletContext, request);
            
            //Init the classloader for the filter and get the Service for processing the filters.
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            FilterManager filtermanager = (FilterManager) request.getAttribute(
            		"filter-manager");
            
            // The requested method is RENDER: call Portlet.render(..)
            if (methodId == Constants.METHOD_RENDER) {
                RenderRequestImpl renderRequest =
                		(RenderRequestImpl) portletRequest;
                RenderResponseImpl renderResponse =
                    	(RenderResponseImpl) portletResponse;
                filtermanager.processFilter(renderRequest, renderResponse, loader, portletName, portletContext,"RENDER_PHASE");
                portlet.render(renderRequest, renderResponse);
            }

            //The requested method is RESOURCE: call ResourceServingPortlet.serveResource(..)
            else if (methodId == Constants.METHOD_RESOURCE) {
            	ResourceRequestImpl resourceRequest =
                    	(ResourceRequestImpl) portletRequest;
            	ResourceResponseImpl resourceResponse =
                    	(ResourceResponseImpl) portletResponse;
            	resourceServingPortlet.serveResource(resourceRequest, resourceResponse);
            }
            
            // The requested method is ACTION: call Portlet.processAction(..)
            else if (methodId == Constants.METHOD_ACTION) {
                ActionRequestImpl actionRequest =
                    	(ActionRequestImpl) portletRequest;
                ActionResponseImpl actionResponse =
                    	(ActionResponseImpl) portletResponse;
                portlet.processAction(actionRequest, actionResponse);
            }
            
            //The request methode is Event: call Portlet.processEvent(..)
            else if (methodId == Constants.METHOD_EVENT){
            	EventRequestImpl eventRequest =
                	(EventRequestImpl) portletRequest;
            	EventResponseImpl eventResponse =
                	(EventResponseImpl) portletResponse;
            	eventPortlet.processEvent(eventRequest, eventResponse);
            }
            
            // The requested method is NOOP: do nothing.
            else if (methodId == Constants.METHOD_NOOP) {
                // Do nothing.
            }

        } catch (javax.portlet.UnavailableException ex) {
            ex.printStackTrace();
            /*
            if (e.isPermanent()) {
                throw new UnavailableException(e.getMessage());
            } else {
                throw new UnavailableException(e.getMessage(), e.getUnavailableSeconds());
            }*/

            // Portlet.destroy() isn't called by Tomcat, so we have to fix it.
            try {
                portlet.destroy();
            } catch (Throwable th) {
                // Don't care for Exception
            }
            
            // TODO: Handle everything as permanently for now.
            throw new javax.servlet.UnavailableException(ex.getMessage());
            
        } catch (PortletException ex) {
            ex.printStackTrace();
            throw new ServletException(ex);
            
        } finally {
            request.removeAttribute(Constants.PORTLET_CONFIG);
            if (portletRequest != null) {
            	portletRequest.release();
            }
        }
    }
    private void initializeEventPortlet() {
       if (portlet instanceof EventPortlet) {
               eventPortlet = (EventPortlet) portlet;
       }
       else{
    	   eventPortlet = new NullPortlet();
       }
    }
    
    private void initializeResourceServingPortlet() {
       if (portlet instanceof ResourceServingPortlet) {
               resourceServingPortlet = (ResourceServingPortlet) portlet;
       }
       else{
    	   resourceServingPortlet = new NullPortlet();
       }
    }
}
