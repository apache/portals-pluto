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
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Event;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.Constants;
import org.apache.pluto.EventContainer;
import org.apache.pluto.OptionalContainerServices;
import org.apache.pluto.PortletContainer;
import org.apache.pluto.PortletContainerException;
import org.apache.pluto.PortletEntity;
import org.apache.pluto.PortletWindow;
import org.apache.pluto.RequiredContainerServices;
import org.apache.pluto.spi.ContainerInvocationService;
import org.apache.pluto.spi.FilterManager;
import org.apache.pluto.spi.optional.PortletActionResponseContext;
import org.apache.pluto.spi.optional.PortletEnvironmentService;
import org.apache.pluto.spi.optional.PortletEventResponseContext;
import org.apache.pluto.spi.optional.PortletInvokerService;
import org.apache.pluto.spi.optional.PortletRenderResponseContext;
import org.apache.pluto.spi.optional.PortletRequestContext;
import org.apache.pluto.spi.optional.PortletRequestContextService;
import org.apache.pluto.spi.optional.PortletResourceRequestContext;
import org.apache.pluto.spi.optional.PortletResourceResponseContext;
import org.apache.pluto.util.StringManager;


/**
 * Default Pluto Container implementation.
 *
 * @version 1.0
 * @since Sep 18, 2004
 */
public class PortletContainerImpl implements PortletContainer,
	EventContainer {

    /** Internal logger. */
    private static final Log LOG = LogFactory.getLog(PortletContainerImpl.class);
    
    
    // Private Member Variables ------------------------------------------------
    
    private static final StringManager EXCEPTIONS = StringManager.getManager(
    		    		PortletContainerImpl.class.getPackage().getName());
    
    /** The portlet container name. */
    private final String name;
    
    /** The required container services associated with this container. */
    private final RequiredContainerServices requiredContainerServices;
    
    /** The optional container services associated with this container. */
    private final OptionalContainerServices optionalContainerServices;
    
    
    /** Flag indicating whether or not we've been initialized. */
    private boolean initialized = false;
    
    
    // Constructor -------------------------------------------------------------
    
    /** Default Constructor.  Create a container implementation
     *  whith the given name and given services.
     *
     * @param name  the name of the container.
     * @param requiredServices  the required container services implementation.
     * @param optionalServices  the optional container services implementation.
     */
    public PortletContainerImpl(String name,
                                RequiredContainerServices requiredServices,
                                OptionalContainerServices optionalServices) {
        this.name = name;
        this.requiredContainerServices = requiredServices;
        this.optionalContainerServices = optionalServices;
    }
    
    
    // PortletContainer Impl ---------------------------------------------------
    
    /**
     * Initialize the container for use within the given configuration scope.
     * @param servletContext  the servlet context of the portal webapp.
     */
    public void init()
    throws PortletContainerException {
        this.initialized = true;
        infoWithName("Container initialized successfully.");
    }

    /**
     * Determine whether this container has been initialized or not.
     * @return true if the container has been initialized.
     */
    public boolean isInitialized() {
        return initialized;
    }

    /**
     * Destroy this container.
     */
    public void destroy() {
        this.initialized = false;
        infoWithName("Container destroyed.");
    }


    /**
     * Renders the portlet associated with the specified portlet window.
     * @param portletWindow  the portlet window.
     * @param request  the servlet request.
     * @param response  the servlet response.
     * @throws IllegalStateException  if the container is not initialized.
     * @throws PortletException
     * @throws IOException
     * @throws PortletContainerException
     * 
     * @see javax.portlet.Portlet#render(RenderRequest, RenderResponse)
     */
    public void doRender(PortletWindow portletWindow,
                         HttpServletRequest request,
                         HttpServletResponse response)
    throws PortletException, IOException, PortletContainerException
    {
    	ensureInitialized();
    	
        debugWithName("Render request received for portlet: "
        		+ portletWindow.getPortletEntity().getPortletDefinition().getPortletName());
        
        try
        {
            getInvocationService().setInvocation(this, portletWindow, Method.RENDER);
            
            PortletRequestContextService rcService = getOptionalContainerServices().getPortletRequestContextService();
            PortletEnvironmentService envService = getOptionalContainerServices().getPortletEnvironmentService();
            PortletInvokerService invoker = optionalContainerServices.getPortletInvokerService();

            PortletRequestContext requestContext = rcService.getPortletRenderRequestContext(this, request, response, portletWindow);
            PortletRenderResponseContext responseContext = rcService.getPortletRenderResponseContext(this, request, response, portletWindow);
            RenderRequest portletRequest = envService.createRenderRequest(requestContext, responseContext.getCacheControl());
            RenderResponse portletResponse = envService.createRenderResponse(responseContext);

            FilterManager filterManager = filterInitialisation(portletWindow,PortletRequest.RENDER_PHASE);
            
            try
            {
                invoker.render(requestContext, portletRequest, portletResponse, filterManager);
                // Mark portlet interaction is completed: backend implementation can flush response state now
                responseContext.close();
            }
            finally
            {
                responseContext.release();
            }
        } 
        finally
        {
            getInvocationService().clearInvocation();
        }
        
        debugWithName("Portlet render done for: " + portletWindow.getPortletEntity().getPortletDefinition().getPortletName());
    }

    /**
     * Indicates that a portlet resource Serving occured in the current request and calls
     * the processServeResource method of this portlet.
     * @param PortletWindow the portlet Window
     * @param request               the servlet request
     * @param response              the servlet response
     * @throws PortletException          if one portlet has trouble fulfilling
     *                                   the request
     * @throws PortletContainerException if the portlet container implementation
     *                                   has trouble fulfilling the request
     */
    public void doServeResource(PortletWindow portletWindow,
    							HttpServletRequest request,
    							HttpServletResponse response)
    throws PortletException, IOException, PortletContainerException
    {		
    	ensureInitialized();
    	
        debugWithName("Resource request received for portlet: "
        		+ portletWindow.getPortletEntity().getPortletDefinition().getPortletName());
        
        try
        {
            getInvocationService().setInvocation(this, portletWindow, Method.RESOURCE);

            PortletRequestContextService rcService = getOptionalContainerServices().getPortletRequestContextService();
            PortletEnvironmentService envService = getOptionalContainerServices().getPortletEnvironmentService();
            PortletInvokerService invoker = optionalContainerServices.getPortletInvokerService();

            PortletResourceRequestContext requestContext = rcService.getPortletResourceRequestContext(this, request, response, portletWindow);
            PortletResourceResponseContext responseContext = rcService.getPortletResourceResponseContext(this, request, response, portletWindow);
            ResourceRequest portletRequest = envService.createResourceRequest(requestContext, responseContext.getCacheControl());
            ResourceResponse portletResponse = envService.createResourceResponse(responseContext, requestContext.getCacheability());

            FilterManager filterManager = filterInitialisation(portletWindow,PortletRequest.RESOURCE_PHASE);
            
            try
            {
                invoker.serveResource(requestContext, portletRequest, portletResponse, filterManager);
                // Mark portlet interaction is completed: backend implementation can flush response state now
                responseContext.close();
            }
            finally
            {
                responseContext.release();
            }
        } 
        finally
        {
            getInvocationService().clearInvocation();
        }
        
        debugWithName("Portlet resource done for: " + portletWindow.getPortletEntity().getPortletDefinition().getPortletName());
	}
    
    /**
     * Process action for the portlet associated with the given portlet window.
     * @param portletWindow  the portlet window.
     * @param request  the servlet request.
     * @param response  the servlet response.
     * @throws PortletException
     * @throws IOException
     * @throws PortletContainerException
     * 
     * @see javax.portlet.Portlet#processAction(ActionRequest, ActionResponse)
     */
    public void doAction(PortletWindow portletWindow,
                         HttpServletRequest request,
                         HttpServletResponse response)
    throws PortletException, IOException, PortletContainerException
    {
    	ensureInitialized();
    	
        debugWithName("Action request received for portlet: "
    			+ portletWindow.getPortletEntity().getPortletDefinition().getPortletName());
    	
        try 
        {
            getInvocationService().setInvocation(this, portletWindow, Method.ACTION);

            PortletRequestContextService rcService = getOptionalContainerServices().getPortletRequestContextService();
            PortletEnvironmentService envService = getOptionalContainerServices().getPortletEnvironmentService();
            PortletInvokerService invoker = optionalContainerServices.getPortletInvokerService();

            PortletRequestContext requestContext = rcService.getPortletActionRequestContext(this, request, response, portletWindow);
            PortletActionResponseContext responseContext = rcService.getPortletActionResponseContext(this, request, response, portletWindow);
            ActionRequest portletRequest = envService.createActionRequest(requestContext);
            ActionResponse portletResponse = envService.createActionResponse(responseContext);

            FilterManager filterManager = filterInitialisation(portletWindow,PortletRequest.ACTION_PHASE);

            String location = null;
            
            try
            {
                invoker.action(requestContext, portletRequest, portletResponse, filterManager);
                
                debugWithName("Portlet action processed for: "
                              + portletWindow.getPortletEntity().getPortletDefinition().getPortletName());
                
                // Mark portlet interaction is completed: backend implementation can flush response state now
                responseContext.close();
                
                if (!responseContext.isRedirect())
                {
                    List<Event> events = responseContext.getEvents();
                    if (!events.isEmpty())
                    {
                        try
                        {
                            requiredContainerServices.getEventCoordinationService().processEvents(portletWindow, events);
                        }
                        finally
                        {
                            // restore/recreate current ContainerInvocation as processEvents can have overridden and then cleared it
                            // TODO: investigate if nested invocations like these shouldn't be handled differently?
                            getInvocationService().setInvocation(this, portletWindow, Method.ACTION);
                        }
                    }
                }

                // After processing action and possible event handling, retrieve the target response URL to be redirected to
                // This can either be a renderURL or an external URL (optionally containing a future renderURL as query parameter
                location = response.encodeRedirectURL(responseContext.getResponseURL());
            }
            finally
            {
                responseContext.release();
            }
            redirect(request, response, location);
        }
        finally
        {
            getInvocationService().clearInvocation();
        }

        debugWithName("Portlet action done for: " + portletWindow.getPortletEntity().getPortletDefinition().getPortletName());
    }

    protected void redirect(HttpServletRequest request, HttpServletResponse response, String location) throws IOException
    {
        // Here we intentionally use the original response
        // instead of the wrapped internal response.        
        response.sendRedirect(location);
        debugWithName("Redirect URL sent.");        
    }
    
    /**
     * Loads the portlet associated with the specified portlet window.
     * @param portletWindow  the portlet window.
     * @param request  the servlet request.
     * @param response  the servlet response.
     * @throws PortletException
     * @throws IOException
     * @throws PortletContainerException
     */
    public void doLoad(PortletWindow portletWindow,
                       HttpServletRequest request,
                       HttpServletResponse response)
    	throws PortletException, IOException, PortletContainerException
    {
    	ensureInitialized();
    	
        debugWithName("Load request received for portlet: "
        		+ portletWindow.getPortletEntity().getPortletDefinition().getPortletName());
        
        try
        {
            getInvocationService().setInvocation(this, portletWindow, Method.LOAD);

            PortletRequestContextService rcService = getOptionalContainerServices().getPortletRequestContextService();
            PortletEnvironmentService envService = getOptionalContainerServices().getPortletEnvironmentService();
            PortletInvokerService invoker = optionalContainerServices.getPortletInvokerService();

            PortletRequestContext requestContext = rcService.getPortletRenderRequestContext(this, request, response, portletWindow);
            PortletRenderResponseContext responseContext = rcService.getPortletRenderResponseContext(this, request, response, portletWindow);
            RenderRequest portletRequest = envService.createRenderRequest(requestContext, responseContext.getCacheControl());
            RenderResponse portletResponse = envService.createRenderResponse(responseContext);

            try
            {
                invoker.load(requestContext, portletRequest, portletResponse);
                // Mark portlet interaction is completed: backend implementation can flush response state now
                responseContext.close();
            }
            finally
            {
                responseContext.release();
            }
        }
        finally
        {
            getInvocationService().clearInvocation();
        }

        debugWithName("Portlet load done for: " + portletWindow.getPortletEntity().getPortletDefinition().getPortletName());
    }
    

    public void doAdmin(PortletWindow portletWindow,
                        HttpServletRequest request,
                        HttpServletResponse response)
    throws PortletException, IOException, PortletContainerException
    {
        ensureInitialized();

        debugWithName("Admin request received for portlet: "
            +portletWindow.getPortletEntity().getPortletDefinition().getPortletName());

        try
        {
            getInvocationService().setInvocation(this, portletWindow, Method.EVENT);
            
            PortletRequestContextService rcService = getOptionalContainerServices().getPortletRequestContextService();
            PortletEnvironmentService envService = getOptionalContainerServices().getPortletEnvironmentService();
            PortletInvokerService invoker = optionalContainerServices.getPortletInvokerService();

            PortletRequestContext requestContext = rcService.getPortletRenderRequestContext(this, request, response, portletWindow);
            PortletRenderResponseContext responseContext = rcService.getPortletRenderResponseContext(this, request, response, portletWindow);
            RenderRequest portletRequest = envService.createRenderRequest(requestContext, responseContext.getCacheControl());
            RenderResponse portletResponse = envService.createRenderResponse(responseContext);

            try
            {
                invoker.admin(requestContext, portletRequest, portletResponse);
                // Mark portlet interaction is completed: backend implementation can flush response state now
                responseContext.close();
            }
            finally
            {
                responseContext.release();
            }
        } 
        finally
        {
            getInvocationService().clearInvocation();
        }

        debugWithName("Portlet admin request done for: " + portletWindow.getPortletEntity().getPortletDefinition().getPortletName());
    }


    public String getName() {
        return name;
    }

    public RequiredContainerServices getRequiredContainerServices() {
        return requiredContainerServices;
    }

    /**
     * Retrieve the optional container services used by the container.
     * If no implementation was provided during construction, the default
     * instance will be returned.
     *
     * @return services used by the container.
     */
    public OptionalContainerServices getOptionalContainerServices() {
        return optionalContainerServices;
    }
    
    /**
     * Fire Event for the portlet associated with the given portlet window and eventName
     * @param portletWindow  the portlet window.
     * @param request  the servlet request.
     * @param response  the servlet response.
     * @param eventName the event name
     * @throws PortletException
     * @throws IOException
     * @throws PortletContainerException
     * 
     * @see {@link javax.portlet.EventPortlet#processEvent(javax.portlet.EventRequest, javax.portlet.EventResponse)
     */
    public void fireEvent(HttpServletRequest request, HttpServletResponse response,
    		PortletWindow portletWindow, Event event) 
    		throws PortletException, IOException, PortletContainerException
    {
    	ensureInitialized();

    	debugWithName("Event: "+event.getName()+" received for portlet: "
    			+ portletWindow.getPortletEntity().getPortletDefinition().getPortletName());

        try
        {
            getInvocationService().setInvocation(this, portletWindow, Method.EVENT);
            
            PortletRequestContextService rcService = getOptionalContainerServices().getPortletRequestContextService();
            PortletEnvironmentService envService = getOptionalContainerServices().getPortletEnvironmentService();
            PortletInvokerService invoker = optionalContainerServices.getPortletInvokerService();

            PortletRequestContext requestContext = rcService.getPortletEventRequestContext(this, request, response, portletWindow);
            PortletEventResponseContext responseContext = rcService.getPortletEventResponseContext(this, request, response, portletWindow);
            EventRequest portletRequest = envService.createEventRequest(requestContext, event);
            EventResponse portletResponse = envService.createEventResponse(responseContext);

            FilterManager filterManager = filterInitialisation(portletWindow,PortletRequest.EVENT_PHASE);

            List<Event> events = null;
            try
            {
                invoker.event(requestContext, portletRequest, portletResponse, filterManager);
                
                debugWithName("Portlet event processed for: "
                              + portletWindow.getPortletEntity().getPortletDefinition().getPortletName());
                
                // Mark portlet interaction is completed: backend implementation can flush response state now
                responseContext.close();
                events = responseContext.getEvents();
            }
            finally
            {
                responseContext.release();
            }

            if (events != null && !events.isEmpty())
            {
                try
                {
                    requiredContainerServices.getEventCoordinationService().processEvents(portletWindow, events);
                }
                finally
                {
                    // restore/recreate current ContainerInvocation as processEvents can have overridden and then cleared it
                    // TODO: investigate if nested invocations like these shouldn't be handled differently?
                    getInvocationService().setInvocation(this, portletWindow, Method.EVENT);
                }
            }
        }
        finally
        {
            getInvocationService().clearInvocation();
        }

        debugWithName("Portlet event: "+ event.getName() +" fired for: " + portletWindow.getPortletEntity().getPortletDefinition().getPortletName());
    }
    
    private ContainerInvocationService getInvocationService()
    {
        return requiredContainerServices.getContainerInvocationService();
    }
    
    // Private Methods ---------------------------------------------------------
    
    /**
     * Ensures that the portlet container is initialized.
     * @throws IllegalStateException  if the container is not initialized.
     */
    private void ensureInitialized() throws IllegalStateException {
    	if (!isInitialized()) {
    		throw new IllegalStateException(
    				"Portlet container [" + name + "] is not initialized.");
    	}
    }
    
    /**
     * Prints a message at DEBUG level with the container name prefix.
     * @param message  log message.
     */
    private void debugWithName(String message) {
    	if (LOG.isDebugEnabled()) {
    		LOG.debug("Portlet Container [" + name + "]: " + message);
    	}
    }
    
    /**
     * Prints a message at INFO level with the container name prefix.
     * @param message  log message.
     */
    private void infoWithName(String message) {
    	if (LOG.isInfoEnabled()) {
    		LOG.info("Portlet Container [" + name + "]: " + message);
    	}
    }
    
    /**
     * Prints a message at ERROR level with the container name prefix.
     * @param message  log message.
     */
    private void errorWithName(String message) {
        if (LOG.isErrorEnabled()) {
            LOG.info("Portlet Container [" + name + "]: " + message);
        }
    }

	/**
	 * Checks if render parameter are already cleared,
	 * bye storing/reading an ID in the request
	 * 
	 * @param request the portlet request
	 * 
	 * @return true, if already cleared
	 */
	protected boolean isAlreadyCleared(PortletRequest request) 
	{
		String cleared = (String) request.getAttribute(Constants.RENDER_ALREADY_CLEARED);
		if (cleared == null || cleared.equals("false")) {
			request.setAttribute(Constants.RENDER_ALREADY_CLEARED,"true");
			return false;
		}
		return true;
	}    
	
	/**
	 * The method initialise the FilterManager for later use in the PortletServlet
	 * @param PortletWindow the PortletWindow
	 * @param lifeCycle like ACTION_PHASE, RENDER_PHASE,...
	 * @return FilterManager
	 * @throws PortletContainerException
	 */
	private FilterManager filterInitialisation(PortletWindow portletWindow,String lifeCycle) throws PortletContainerException{
	    PortletEntity pe = portletWindow.getPortletEntity();
        return requiredContainerServices.getPortalCallbackService().getFilterManager(pe.getPortletDefinition().getApplication(),pe.getPortletDefinition().getPortletName(),lifeCycle);
    }
}

