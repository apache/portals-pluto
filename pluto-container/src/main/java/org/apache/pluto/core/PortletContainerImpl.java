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
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Event;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSecurityException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
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
import org.apache.pluto.internal.InternalActionRequest;
import org.apache.pluto.internal.InternalActionResponse;
import org.apache.pluto.internal.InternalPortletContext;
import org.apache.pluto.internal.InternalPortletRequest;
import org.apache.pluto.internal.InternalPortletResponse;
import org.apache.pluto.internal.InternalRenderRequest;
import org.apache.pluto.internal.InternalRenderResponse;
import org.apache.pluto.internal.InternalResourceRequest;
import org.apache.pluto.internal.InternalResourceResponse;
import org.apache.pluto.internal.impl.EventRequestImpl;
import org.apache.pluto.internal.impl.EventResponseImpl;
import org.apache.pluto.internal.impl.PortletRequestImpl;
import org.apache.pluto.internal.impl.PortletResponseImpl;
import org.apache.pluto.internal.impl.StateAwareResponseImpl;
import org.apache.pluto.spi.ContainerInvocationService;
import org.apache.pluto.spi.EventProvider;
import org.apache.pluto.spi.FilterManager;
import org.apache.pluto.spi.PortletURLProvider;
import org.apache.pluto.spi.optional.PortletInvokerService;
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
    throws PortletException, IOException, PortletContainerException {
    	
    	ensureInitialized();
    	
        debugWithName("Render request received for portlet: "
        		+ portletWindow.getPortletEntity().getPortletDefinition().getPortletName());
        
        InternalRenderRequest renderRequest = getOptionalContainerServices().getPortletEnvironmentService()
            .createRenderRequest(this, request, response, portletWindow);

        InternalRenderResponse renderResponse = getOptionalContainerServices().getPortletEnvironmentService()
            .createRenderResponse(this, request, response, portletWindow);

        String appName = portletWindow.getPortletEntity().getPortletDefinition().getApplication().getName();
        InternalPortletContext portletContext = optionalContainerServices.getPortletRegistryService().getPortletContext(appName);
        
        PortletInvokerService invoker = optionalContainerServices.getPortletInvokerService();

        try {
            getInvocationService().setInvocation(this, portletWindow);
            //Filter initialisation
            FilterManager filterManager = filterInitialisation(portletWindow,PortletRequest.RENDER_PHASE);
            invoker.render(portletContext.getServletContext(), renderRequest, renderResponse, portletWindow, filterManager);
        } finally {
            getInvocationService().clearInvocation();
        }
        
        debugWithName("Portlet rendered for: "
        		+ portletWindow.getPortletEntity().getPortletDefinition().getPortletName());
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
    throws PortletException, IOException, PortletContainerException {
		
    	ensureInitialized();
    	
        debugWithName("Resource request received for portlet: "
        		+ portletWindow.getPortletEntity().getPortletDefinition().getPortletName());
        
        InternalResourceRequest resourceRequest = getOptionalContainerServices().getPortletEnvironmentService()
            .createResourceRequest(this, request, response, portletWindow);

        InternalResourceResponse resourceResponse = getOptionalContainerServices().getPortletEnvironmentService()
            .createResourceResponse(this, request, response, portletWindow);

        String appName = portletWindow.getPortletEntity().getPortletDefinition().getApplication().getName();
        InternalPortletContext portletContext = optionalContainerServices.getPortletRegistryService().getPortletContext(appName);
        
        PortletInvokerService invoker = optionalContainerServices.getPortletInvokerService();

        try {
            getInvocationService().setInvocation(this, portletWindow);
            FilterManager filterManager = filterInitialisation(portletWindow,PortletRequest.RESOURCE_PHASE);
            invoker.serveResource(portletContext.getServletContext(), resourceRequest, resourceResponse, portletWindow, filterManager);
        } finally {
            getInvocationService().clearInvocation();
        }
        
        debugWithName("Portlet resource for: "
        		+ portletWindow.getPortletEntity().getPortletDefinition().getPortletName());
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
    throws PortletException, IOException, PortletContainerException {
    	
    	ensureInitialized();
    	
        debugWithName("Action request received for portlet: "
    			+ portletWindow.getPortletEntity().getPortletDefinition().getPortletName());
    	
        InternalActionRequest actionRequest = getOptionalContainerServices().getPortletEnvironmentService()
            .createActionRequest(this, request, response, portletWindow);

        InternalActionResponse actionResponse = getOptionalContainerServices().getPortletEnvironmentService()
            .createActionResponse(this, request, response, portletWindow);

        String appName = portletWindow.getPortletEntity().getPortletDefinition().getApplication().getName();
        InternalPortletContext portletContext = optionalContainerServices.getPortletRegistryService().getPortletContext(appName);

        PortletInvokerService invoker = optionalContainerServices.getPortletInvokerService();

        try {
            getInvocationService().setInvocation(this, portletWindow);
            FilterManager filterManager = filterInitialisation(portletWindow,PortletRequest.ACTION_PHASE);
            invoker.action(portletContext.getServletContext(), actionRequest, actionResponse, portletWindow, filterManager);
        }
        finally {
            getInvocationService().clearInvocation();
        }

        debugWithName("Portlet action processed for: "
        		+ portletWindow.getPortletEntity().getPortletDefinition().getPortletName());
        
        PortletURLProvider portletURLProvider = requiredContainerServices.getPortalCallbackService().getPortletURLProvider(request, portletWindow);
        
        portletURLProvider.savePortalURL(request);
        saveChangedParameters(request, (PortletRequest)actionRequest, (StateAwareResponseImpl)actionResponse, portletURLProvider);
        
        EventProvider provider = this.getRequiredContainerServices().getPortalCallbackService().
			getEventProvider(request,portletWindow);
        provider.fireEvents(this);
        
        
        // After processing action, send a redirect URL for rendering.
        String location = actionResponse.getRedirectLocation();

        if (location == null) {
        	
        	// Create portlet URL provider to encode redirect URL.
        	debugWithName("No redirect location specified.");
            PortletURLProvider redirectURL = requiredContainerServices
            		.getPortalCallbackService()
            		.getPortletURLProvider(request, portletWindow);
            
            saveChangedParameters(request, (PortletRequest)actionRequest, (StateAwareResponseImpl)actionResponse, redirectURL);
            
            // Encode the redirect URL to a string.
            location = actionResponse.encodeRedirectURL(redirectURL.toString());
        }

        redirect(request, response, location);
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
    	throws PortletException, IOException, PortletContainerException {
    	
    	ensureInitialized();
    	
        debugWithName("Load request received for portlet: "
        		+ portletWindow.getPortletEntity().getPortletDefinition().getPortletName());
        

        InternalRenderRequest renderRequest =
            getOptionalContainerServices().getPortletEnvironmentService()
                .createRenderRequest(this, request, response, portletWindow);

        InternalRenderResponse renderResponse =
            getOptionalContainerServices().getPortletEnvironmentService()
                .createRenderResponse(this, request, response, portletWindow);

        String appName = portletWindow.getPortletEntity().getPortletDefinition().getApplication().getName();
        InternalPortletContext portletContext = optionalContainerServices.getPortletRegistryService().getPortletContext(appName);

        PortletInvokerService invoker = optionalContainerServices.getPortletInvokerService();

        try {
            getInvocationService().setInvocation(this, portletWindow);
            invoker.load(portletContext.getServletContext(), renderRequest, renderResponse, portletWindow);
        } finally {
            getInvocationService().clearInvocation();
        }

        debugWithName("Portlet loaded for: " + portletWindow.getPortletEntity().getPortletDefinition().getPortletName());
    }
    

    public void doAdmin(PortletWindow portletWindow,
                        HttpServletRequest servletRequest,
                        HttpServletResponse servletResponse)
    throws PortletException, IOException, PortletContainerException {
        ensureInitialized();

        debugWithName("Admin request received for portlet: "
            +portletWindow.getPortletEntity().getPortletDefinition().getPortletName());

        InternalPortletRequest internalRequest =
            new AdminRequest(this, portletWindow, servletRequest) { };

        InternalPortletResponse internalResponse =
            new AdminResponse(this, portletWindow, servletRequest, servletResponse);

        String appName = portletWindow.getPortletEntity().getPortletDefinition().getApplication().getName();
        InternalPortletContext portletContext = optionalContainerServices.getPortletRegistryService().getPortletContext(appName);
        
        PortletInvokerService invoker = optionalContainerServices.getPortletInvokerService();

        try {
            getInvocationService().setInvocation(this, portletWindow);
            invoker.admin(portletContext.getServletContext(), internalRequest, internalResponse, portletWindow);
        } finally {
            getInvocationService().clearInvocation();
        }

        debugWithName("Admin request complete.");
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
    		PortletWindow window, Event event) 
    		throws PortletException, IOException, PortletContainerException {

    	ensureInitialized();

    	debugWithName("Event request received for portlet: "
    			+ window.getPortletEntity().getPortletDefinition().getPortletName());

    	EventRequestImpl eventRequest = new EventRequestImpl(
    			this, window, request, event);
    	EventResponseImpl eventResponse = new EventResponseImpl(
    			this, window, request, response);

    	
        String appName = window.getPortletEntity().getPortletDefinition().getApplication().getName();
        InternalPortletContext portletContext = optionalContainerServices.getPortletRegistryService().getPortletContext(appName);

    	PortletInvokerService invoker = optionalContainerServices.getPortletInvokerService();

        try {
            getInvocationService().setInvocation(this, window);
            FilterManager filterManager = filterInitialisation(window,PortletRequest.EVENT_PHASE);
            invoker.event(portletContext.getServletContext(), eventRequest, eventResponse, window, filterManager);
        }
        finally {
            getInvocationService().clearInvocation();
        }

    	debugWithName("Portlet event processed for: "
    			+ window.getPortletEntity().getPortletDefinition().getPortletName());

    	// After processing event, change the redirect URL for rendering.
    	String location = eventResponse.getRedirectLocation();

    	if (location == null) {

    		// Create portlet URL provider to encode redirect URL.
    		debugWithName("No redirect location specified.");
    		PortletURLProvider redirectURL = requiredContainerServices
    		.getPortalCallbackService()
    		.getPortletURLProvider(request, window);

    		saveChangedParameters(request, eventRequest, eventResponse, redirectURL);

    		// save redirectURL in request
    		redirectURL.savePortalURL(request);
    	}
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
	 * @param request
	 * @param response
	 * @param redirectURL
	 */
	protected void saveChangedParameters(HttpServletRequest servletRequest, PortletRequest request, StateAwareResponseImpl response, PortletURLProvider redirectURL) 
	{
		// Encode portlet mode if it is changed.
		if (response.getChangedPortletMode() != null) {
			redirectURL.setPortletMode(
					response.getChangedPortletMode());
		}

		// Encode window state if it is changed.
		if (response.getChangedWindowState() != null) {
			redirectURL.setWindowState(
					response.getChangedWindowState());
		}

		// Encode render parameters retrieved from action response.
		Map renderParameters = response.getRenderParameters();
		
		// clear render parameter only once per request
		// (there could be more than one (eventing))
		if (!isAlreadyCleared(request))
			redirectURL.clearParameters();
		
		redirectURL.setParameters(renderParameters);
		redirectURL.setPublicRenderParameters(response.getPublicRenderParameter());

		// Encode redirect URL as a render URL.
		redirectURL.setAction(false);

		// Set secure of the redirect URL if necessary.
		if (redirectURL.isSecureSupported()) {
			try {
				redirectURL.setSecure();
			} catch (PortletSecurityException e) {
				LOG.error("Problem calling PortletURLProvider.setSecure()", e);
				throw new IllegalStateException("Security cannot be set on the redirect URL (" + e.toString() + ").");
			}
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
	
	class AdminRequest extends PortletRequestImpl {

        public AdminRequest(PortletContainer container,
                            PortletWindow portletWindow,
                            HttpServletRequest servletRequest) {
            super(container, portletWindow, servletRequest);
        }

        public PortletPreferences getPreferences() {
            throw new IllegalStateException("Can not access preferences during admin request.");
        }
    }

    class AdminResponse extends PortletResponseImpl {

        public AdminResponse(PortletContainer container,
                             PortletWindow portletWindow,
                             HttpServletRequest servletRequest,
                             HttpServletResponse servletResponse) {
            super(container, portletWindow, servletRequest, servletResponse);
        }
    }
}

