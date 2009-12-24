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
package org.apache.pluto.container.impl;

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

import org.apache.pluto.container.ContainerServices;
import org.apache.pluto.container.FilterManager;
import org.apache.pluto.container.PortletActionResponseContext;
import org.apache.pluto.container.PortletContainer;
import org.apache.pluto.container.PortletContainerException;
import org.apache.pluto.container.PortletEnvironmentService;
import org.apache.pluto.container.PortletEventResponseContext;
import org.apache.pluto.container.PortletInvokerService;
import org.apache.pluto.container.PortletRenderResponseContext;
import org.apache.pluto.container.PortletRequestContext;
import org.apache.pluto.container.PortletRequestContextService;
import org.apache.pluto.container.PortletResourceRequestContext;
import org.apache.pluto.container.PortletResourceResponseContext;
import org.apache.pluto.container.PortletWindow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Default Pluto Container implementation.
 *
 * @version 1.0
 * @since Sep 18, 2004
 */
public class PortletContainerImpl implements PortletContainer
{

    /** Internal logger. */
    private static final Logger LOG = LoggerFactory.getLogger(PortletContainerImpl.class);


    // Private Member Variables ------------------------------------------------

    /** The portlet container name. */
    private final String name;

    /** The container services associated with this container. */
    private final ContainerServices containerServices;

    /** Flag indicating whether or not we've been initialized. */
    private boolean initialized = false;


    // Constructor -------------------------------------------------------------

    /** Default Constructor.  Create a container implementation
     *  whith the given name and given services.
     *
     * @param name  the name of the container.
     * @param requiredServices  the required container services implementation.
     */
    public PortletContainerImpl(String name,
            ContainerServices requiredServices) {
        this.name = name;
        this.containerServices = requiredServices;
    }


    // PortletContainer Impl ---------------------------------------------------

    /**
     * Initialize the container for use within the given configuration scope.
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
                + portletWindow.getPortletDefinition().getPortletName());

        PortletRequestContextService rcService = getContainerServices().getPortletRequestContextService();
        PortletEnvironmentService envService = getContainerServices().getPortletEnvironmentService();
        PortletInvokerService invoker = getContainerServices().getPortletInvokerService();

        PortletRequestContext requestContext = rcService.getPortletRenderRequestContext(this, request, response, portletWindow);
        PortletRenderResponseContext responseContext = rcService.getPortletRenderResponseContext(this, request, response, portletWindow);
        RenderRequest portletRequest = envService.createRenderRequest(requestContext, responseContext);
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

        debugWithName("Portlet render done for: " + portletWindow.getPortletDefinition().getPortletName());
    }

    /**
     * Indicates that a portlet resource Serving occured in the current request and calls
     * the processServeResource method of this portlet.
     * @param portletWindow the portlet Window
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
                + portletWindow.getPortletDefinition().getPortletName());

        PortletRequestContextService rcService = getContainerServices().getPortletRequestContextService();
        PortletEnvironmentService envService = getContainerServices().getPortletEnvironmentService();
        PortletInvokerService invoker = getContainerServices().getPortletInvokerService();

        PortletResourceRequestContext requestContext = rcService.getPortletResourceRequestContext(this, request, response, portletWindow);
        PortletResourceResponseContext responseContext = rcService.getPortletResourceResponseContext(this, request, response, portletWindow);
        ResourceRequest portletRequest = envService.createResourceRequest(requestContext, responseContext);
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

        debugWithName("Portlet resource done for: " + portletWindow.getPortletDefinition().getPortletName());
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
                + portletWindow.getPortletDefinition().getPortletName());

        PortletRequestContextService rcService = getContainerServices().getPortletRequestContextService();
        PortletEnvironmentService envService = getContainerServices().getPortletEnvironmentService();
        PortletInvokerService invoker = getContainerServices().getPortletInvokerService();

        PortletRequestContext requestContext = rcService.getPortletActionRequestContext(this, request, response, portletWindow);
        PortletActionResponseContext responseContext = rcService.getPortletActionResponseContext(this, request, response, portletWindow);
        ActionRequest portletRequest = envService.createActionRequest(requestContext, responseContext);
        ActionResponse portletResponse = envService.createActionResponse(responseContext);

        FilterManager filterManager = filterInitialisation(portletWindow,PortletRequest.ACTION_PHASE);

        String location = null;

        try
        {
            invoker.action(requestContext, portletRequest, portletResponse, filterManager);

            debugWithName("Portlet action processed for: "
                    + portletWindow.getPortletDefinition().getPortletName());

            // Mark portlet interaction is completed: backend implementation can flush response state now
            responseContext.close();

            if (!responseContext.isRedirect())
            {
                List<Event> events = responseContext.getEvents();
                if (!events.isEmpty())
                {
                    getContainerServices().getEventCoordinationService().processEvents(this, portletWindow, request, response, events);
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

        debugWithName("Portlet action done for: " + portletWindow.getPortletDefinition().getPortletName());
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
                + portletWindow.getPortletDefinition().getPortletName());

        PortletRequestContextService rcService = getContainerServices().getPortletRequestContextService();
        PortletEnvironmentService envService = getContainerServices().getPortletEnvironmentService();
        PortletInvokerService invoker = getContainerServices().getPortletInvokerService();

        PortletRequestContext requestContext = rcService.getPortletRenderRequestContext(this, request, response, portletWindow);
        PortletRenderResponseContext responseContext = rcService.getPortletRenderResponseContext(this, request, response, portletWindow);
        RenderRequest portletRequest = envService.createRenderRequest(requestContext, responseContext);
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

        debugWithName("Portlet load done for: " + portletWindow.getPortletDefinition().getPortletName());
    }


    public void doAdmin(PortletWindow portletWindow,
            HttpServletRequest request,
            HttpServletResponse response)
    throws PortletException, IOException, PortletContainerException
    {
        ensureInitialized();

        debugWithName("Admin request received for portlet: "
                +portletWindow.getPortletDefinition().getPortletName());

        PortletRequestContextService rcService = getContainerServices().getPortletRequestContextService();
        PortletEnvironmentService envService = getContainerServices().getPortletEnvironmentService();
        PortletInvokerService invoker = getContainerServices().getPortletInvokerService();

        PortletRequestContext requestContext = rcService.getPortletRenderRequestContext(this, request, response, portletWindow);
        PortletRenderResponseContext responseContext = rcService.getPortletRenderResponseContext(this, request, response, portletWindow);
        RenderRequest portletRequest = envService.createRenderRequest(requestContext, responseContext);
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

        debugWithName("Portlet admin request done for: " + portletWindow.getPortletDefinition().getPortletName());
    }


    /**
     * @see org.apache.pluto.container.PortletContainer#getName()
     */
    public String getName() {
        return name;
    }

    /**
     * @see org.apache.pluto.container.PortletContainer#getContainerServices()
     */
    public ContainerServices getContainerServices() {
        return containerServices;
    }

    /**
     * Fire Event for the portlet associated with the given portlet window and eventName
     * @param portletWindow  the portlet window.
     * @param request  the servlet request.
     * @param response  the servlet response.
     * @param event the event
     * @throws PortletException
     * @throws IOException
     * @throws PortletContainerException
     * 
     * @see javax.portlet.EventPortlet#processEvent(javax.portlet.EventRequest, javax.portlet.EventResponse)
     */
    public void doEvent(PortletWindow portletWindow,
            HttpServletRequest request,
            HttpServletResponse response,
            Event event)
    throws PortletException, IOException, PortletContainerException
    {
        ensureInitialized();

        debugWithName("Event: "+event.getName()+" received for portlet: "
                + portletWindow.getPortletDefinition().getPortletName());

        PortletRequestContextService rcService = getContainerServices().getPortletRequestContextService();
        PortletEnvironmentService envService = getContainerServices().getPortletEnvironmentService();
        PortletInvokerService invoker = getContainerServices().getPortletInvokerService();

        PortletRequestContext requestContext = rcService.getPortletEventRequestContext(this, request, response, portletWindow);
        PortletEventResponseContext responseContext = rcService.getPortletEventResponseContext(this, request, response, portletWindow);
        EventRequest portletRequest = envService.createEventRequest(requestContext, responseContext, event);
        EventResponse portletResponse = envService.createEventResponse(responseContext);

        FilterManager filterManager = filterInitialisation(portletWindow,PortletRequest.EVENT_PHASE);

        List<Event> events = null;
        try
        {
            invoker.event(requestContext, portletRequest, portletResponse, filterManager);

            debugWithName("Portlet event processed for: "
                    + portletWindow.getPortletDefinition().getPortletName());

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
            getContainerServices().getEventCoordinationService().processEvents(this, portletWindow, request, response, events);
        }

        debugWithName("Portlet event: "+ event.getName() +" fired for: " + portletWindow.getPortletDefinition().getPortletName());
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
     * The method initialise the FilterManager for later use in the PortletServlet
     * @param portletWindow the PortletWindow
     * @param lifeCycle like ACTION_PHASE, RENDER_PHASE,...
     * @return FilterManager
     * @throws PortletContainerException
     */
    private FilterManager filterInitialisation(PortletWindow portletWindow, String lifeCycle) throws PortletContainerException{
        return getContainerServices().getFilterManagerService().getFilterManager(portletWindow, lifeCycle);
    }
}

