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
package org.apache.pluto.container.driver;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.EventPortlet;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceServingPortlet;
import javax.portlet.UnavailableException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.pluto.container.FilterManager;
import org.apache.pluto.container.PortletInvokerService;
import org.apache.pluto.container.PortletRequestContext;
import org.apache.pluto.container.PortletResponseContext;
import org.apache.pluto.container.PortletWindow;
import org.apache.pluto.container.om.portlet.PortletDefinition;

/**
 * Portlet Invocation Servlet. This servlet recieves cross context requests from
 * the the container and services the portlet request for the specified method.
 *
 * @version 1.1
 * @since 09/22/2004
 */
public class PortletServlet extends HttpServlet implements PortletServletLifecycleCallback
{
    private static final long serialVersionUID = -5096339022539360365L;
    private static final String CLASSLOADER_CONTEXT_KEY = PortletServlet.class.getName() + ".WEBAPP_CLASSLOADER";
    private static final Object REGISTRATION_MUTEX = new Object(){};

    /**
     * Used to support portlets that don't handle event or resource requests
     */
    static class NullPortlet implements EventPortlet, ResourceServingPortlet, Portlet
    {
        public void processEvent(EventRequest arg0, EventResponse arg1)
        throws PortletException, IOException
        {
        }

        public void serveResource(ResourceRequest arg0, ResourceResponse arg1)
        throws PortletException, IOException
        {
        }

        public void destroy()
        {
        }

        public void init(PortletConfig arg0) throws PortletException
        {
        }

        public void processAction(ActionRequest arg0, ActionResponse arg1)
        throws PortletException, IOException
        {
        }

        public void render(RenderRequest arg0, RenderResponse arg1)
        throws PortletException, IOException
        {
        }
    }

    // Private Member Variables ------------------------------------------------
    /**
     * The portlet name as defined in the portlet app descriptor.
     */
    private String portletName;

    /**
     * The portlet instance wrapped by this servlet.
     */
    private volatile Portlet portlet;
    /**
     * The Event Portlet instance (the same object as portlet) wrapped by this servlet.
     */
    private volatile EventPortlet eventPortlet;
    /** 
     * The Resource Portlet instance (the same object as portlet) wrapped by this servlet.
     */
    private volatile ResourceServingPortlet resourceServingPortlet;

    /**
     * The internal portlet context instance.
     */
    private volatile DriverPortletContext portletAppContext;
    /**
     * The internal portlet config instance.
     */
    private volatile DriverPortletConfig portletContext;
    /**
     * Reference to the portal provided services API 
     */
    private volatile PortalDriverContainerServices portalDriverServices;

    private volatile boolean started = false;

    // HttpServlet Impl --------------------------------------------------------

    public String getServletInfo()
    {
        return "Pluto PortletServlet [" + portletName + "]";
    }

    /**
     * Initialize the portlet invocation servlet.
     *
     * @throws ServletException
     *             if an error occurs while loading portlet.
     */
    public void init(final ServletConfig config) throws ServletException
    {
        started = false;
        
        // Call the super initialization method.
        super.init(config);

        // Retrieve portlet name as defined as an initialization parameter.
        portletName = getInitParameter("portlet-name");
        
        //Grab a reference to the portlet's classloader and store it in the servlet context
        final ClassLoader paClassLoader = Thread.currentThread().getContextClassLoader();
        final ServletContext servletContext = config.getServletContext();
        servletContext.setAttribute(CLASSLOADER_CONTEXT_KEY, paClassLoader);
        
        PlutoServicesRegistry.register(portletName, config, paClassLoader, this);
    }
    
    public void registered(PortalDriverContainerServices portalDriverServices, DriverPortletContext portletContext, DriverPortletConfig portletConfig) {
        //sync is to make sure that modification of the portlet/portal references is atomic
        synchronized (REGISTRATION_MUTEX) {
            //Get references to pluto services and portlet configuration data
            this.portalDriverServices = portalDriverServices;
            this.portletAppContext = portletContext;
            this.portletContext = portletConfig;
    
            final PortletDefinition portletDD = portletConfig.getPortletDefinition();
            this.portlet = loadPortlet(portletDD.getPortletClass());
            if (this.portlet != null) {
                try {
                    portlet.init(portletConfig);
                    
                    //Init event and resource portlet references
                    initializeEventPortlet();
                    initializeResourceServingPortlet();
                }
                catch (PortletException e) {
                    final ServletContext servletContext = this.getServletContext();
                    servletContext.log("Failed to initialize portlet '" + this.portletName + "' in web application " + this.getServletContext().getServletContextName(), e);
                    
                    //failed to init portlet class, do cleanup
                    unregistered();
                }
            }
            else {
                //failed to load portlet class, do cleanup
                unregistered();
            }
    
            //Mark the portlet as started
            this.started = true;
        }
    }
    
    protected Portlet loadPortlet(String portletClass) {
        final ServletContext servletContext = this.getServletContext();
        final ClassLoader paClassLoader = (ClassLoader)servletContext.getAttribute(CLASSLOADER_CONTEXT_KEY);
        final Class<?> clazz;
        try {
            clazz = paClassLoader.loadClass(portletClass);
        }
        catch (ClassNotFoundException e) {
            servletContext.log("Failed to load portlet-class '" + portletClass + "' for " + getPortletNameForLogging(), e);
            return null;
        }
        
        try {
            return (Portlet) clazz.newInstance();
        }
        catch (InstantiationException e) {
            servletContext.log("Failed to instantiate portlet-class '" + portletClass + "' for " + getPortletNameForLogging(), e);
            return null;
        }
        catch (IllegalAccessException e) {
            servletContext.log("Failed to instantiate portlet-class '" + portletClass + "' for " + getPortletNameForLogging(), e);
            return null;
        }
    }

    public void destroy()
    {
        this.started = false;
        
        final ServletConfig servletConfig = this.getServletConfig();
        PlutoServicesRegistry.unregister(servletConfig, this.portletAppContext, this.portletContext, this);
    }
    
    public void unregistered() {
        //sync is to make sure that modification of the portlet/portal references is atomic
        synchronized (REGISTRATION_MUTEX) {
            this.started = false;
            
            try {
                portlet.destroy();
            }
            catch (Throwable th) {
                // Don't care for Exception
                this.getServletContext().log("Error destroying " + getPortletNameForLogging(), th);
            }
            
            this.portalDriverServices = null;
            this.portletAppContext = null;
            this.portletContext = null;
            this.portlet = null;
            this.resourceServingPortlet = null;
            this.eventPortlet = null;
            
            super.destroy();
        }
    }
    
    protected String getPortletNameForLogging() {
        return "portlet '" + this.portletName + "' in web application " + this.getServletContext().getServletContextName();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        dispatch(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        dispatch(request, response);
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        dispatch(request, response);
    }

    // Private Methods ---------------------------------------------------------

    /**
     * Dispatch the request to the appropriate portlet methods. This method
     * assumes that the following attributes are set in the servlet request
     * scope:
     * <ul>
     * <li>METHOD_ID: indicating which method to dispatch.</li>
     * <li>PORTLET_REQUEST: the internal portlet request.</li>
     * <li>PORTLET_RESPONSE: the internal portlet response.</li>
     * </ul>
     *
     * @param request
     *            the servlet request.
     * @param response
     *            the servlet response.
     * @throws ServletException
     * @throws IOException
     */
    private void dispatch(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
            {
        if (!started) {
            throw new javax.servlet.UnavailableException(getPortletNameForLogging() + " has not been initialized", 5);
        }
        if (portlet == null) {
            throw new javax.servlet.UnavailableException(getPortletNameForLogging() + " is unavailable, there was a problem during initialization check the container logs for more details");
        }

        // Retrieve attributes from the servlet request.
        PortletInvokerService.Method method = (PortletInvokerService.Method) request.getAttribute(PortletInvokerService.METHOD_ID);

        final PortletRequest portletRequest = (PortletRequest)request.getAttribute(PortletInvokerService.PORTLET_REQUEST);

        final PortletResponse portletResponse = (PortletResponse)request.getAttribute(PortletInvokerService.PORTLET_RESPONSE);

        final PortletRequestContext requestContext = (PortletRequestContext)portletRequest.getAttribute(PortletInvokerService.REQUEST_CONTEXT);
        final PortletResponseContext responseContext = (PortletResponseContext)portletRequest.getAttribute(PortletInvokerService.RESPONSE_CONTEXT);

        final FilterManager filterManager = (FilterManager)request.getAttribute(PortletInvokerService.FILTER_MANAGER);

        request.removeAttribute(PortletInvokerService.METHOD_ID);
        request.removeAttribute(PortletInvokerService.PORTLET_REQUEST);
        request.removeAttribute(PortletInvokerService.PORTLET_RESPONSE);
        request.removeAttribute(PortletInvokerService.FILTER_MANAGER);

        requestContext.init(portletContext, getServletContext(), request, response);
        responseContext.init(request, response);

        PortletWindow window = requestContext.getPortletWindow();

        PortletInvocationEvent event = new PortletInvocationEvent(portletRequest, window, method);

        notify(event, true, null);

        // FilterManager filtermanager = (FilterManager) request.getAttribute(
        // "filter-manager");

        try
        {
            switch (method) {
                // The requested method is RENDER: call Portlet.render(..)
                case RENDER: {
                    RenderRequest renderRequest = (RenderRequest) portletRequest;
                    RenderResponse renderResponse = (RenderResponse) portletResponse;
                    filterManager.processFilter(renderRequest, renderResponse, portlet, portletAppContext);
                    break;
                }
                // The requested method is RESOURCE: call
                // ResourceServingPortlet.serveResource(..)
                case RESOURCE: {
                    ResourceRequest resourceRequest = (ResourceRequest) portletRequest;
                    ResourceResponse resourceResponse = (ResourceResponse) portletResponse;
                    filterManager.processFilter(resourceRequest, resourceResponse,
                            resourceServingPortlet, portletAppContext);                    
                    break;
                }
                // The requested method is ACTION: call Portlet.processAction(..)
                case ACTION: {
                    ActionRequest actionRequest = (ActionRequest) portletRequest;
                    ActionResponse actionResponse = (ActionResponse) portletResponse;
                    filterManager.processFilter(actionRequest, actionResponse,
                            portlet, portletAppContext);
                    break;
                }
                // The request methode is Event: call Portlet.processEvent(..)
                case EVENT: {
                    EventRequest eventRequest = (EventRequest) portletRequest;
                    EventResponse eventResponse = (EventResponse) portletResponse;
                    filterManager.processFilter(eventRequest, eventResponse,
                            eventPortlet, portletAppContext);
                    break;
                }
                // The requested method is ADMIN: call handlers.
                case ADMIN: {
                    PortalAdministrationService pas = this.portalDriverServices.getPortalAdministrationService();

                    for (AdministrativeRequestListener l : pas.getAdministrativeRequestListeners())
                    {
                        l.administer(portletRequest, portletResponse);
                    }
                    break;
                }
                // The requested method is LOAD: do nothing.
                case LOAD: {
                    // Nothing to do
                }
            }

            notify(event, false, null);

        }
        catch (UnavailableException e)
        {
            if (e.isPermanent()) {
                this.destroy();
                this.getServletContext().log(getPortletNameForLogging() + " threw a permanent UnavailableException, taking the portlet out of service", e);
                final javax.servlet.UnavailableException se = new javax.servlet.UnavailableException(e.getMessage());
                se.initCause(e); //make sure we don't lose the original stack trace
                throw se;
            }
            
            //not permanent, mark the portlet unavailable for the specified time period
            
            //Note when the unavailable time ends
            final javax.servlet.UnavailableException se = new javax.servlet.UnavailableException(e.getMessage(), e.getUnavailableSeconds());
            se.initCause(e); //make sure we don't lose the original stack trace
            throw se;

        }
        catch (PortletException ex)
        {
            notify(event, false, ex);
            throw new ServletException(getPortletNameForLogging() + " threw an exception when processing a " + method + " request", ex);

        }
    }

    protected void notify(PortletInvocationEvent event, boolean pre, Throwable e)
    {
        PortalAdministrationService pas = this.portalDriverServices.getPortalAdministrationService();

        for (PortletInvocationListener listener : pas.getPortletInvocationListeners())
        {
            if (pre)
            {
                listener.onBegin(event);
            }
            else if (e == null)
            {
                listener.onEnd(event);
            }
            else
            {
                listener.onError(event, e);
            }
        }
    }

    private void initializeEventPortlet()
    {
        if (portlet instanceof EventPortlet)
        {
            eventPortlet = (EventPortlet) portlet;
        }
        else if (portlet != null)
        {
            eventPortlet = new NullPortlet();
        }
        else
        {
            eventPortlet = null;
        }
    }

    private void initializeResourceServingPortlet()
    {
        if (portlet instanceof ResourceServingPortlet)
        {
            resourceServingPortlet = (ResourceServingPortlet) portlet;
        }
        else if (portlet != null)
        {
            resourceServingPortlet = new NullPortlet();
        }
        else 
        {
            resourceServingPortlet = null;
        }
    }
}
