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
import java.util.Timer;
import java.util.TimerTask;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.EventPortlet;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceServingPortlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.pluto.Constants;
import org.apache.pluto.ContainerInvocation;
import org.apache.pluto.PortletContainerException;
import org.apache.pluto.PortletWindow;
import org.apache.pluto.internal.InternalPortletConfig;
import org.apache.pluto.internal.InternalPortletContext;
import org.apache.pluto.internal.InternalPortletRequest;
import org.apache.pluto.internal.InternalPortletResponse;
import org.apache.pluto.om.portlet.PortletDefinition;
import org.apache.pluto.services.PlutoServices;
import org.apache.pluto.spi.ContainerInvocationService;
import org.apache.pluto.spi.FilterManager;
import org.apache.pluto.spi.optional.AdministrativeRequestListener;
import org.apache.pluto.spi.optional.PortalAdministrationService;
import org.apache.pluto.spi.optional.PortletContextService;
import org.apache.pluto.spi.optional.PortletInvocationEvent;
import org.apache.pluto.spi.optional.PortletInvocationListener;

/**
 * Portlet Invocation Servlet. This servlet recieves cross context requests from
 * the the container and services the portlet request for the specified method.
 * 
 * @version 1.1
 * @since 09/22/2004
 */
public class PortletServlet extends HttpServlet
{

    // Private Member Variables ------------------------------------------------
    /**
     * The portlet name as defined in the portlet app descriptor.
     */
    private String portletName;

    /**
     * The portlet instance wrapped by this servlet.
     */
    private Portlet portlet;

    /**
     * The internal portlet context instance.
     */
    private InternalPortletContext portletContext;

    /**
     * The internal portlet config instance.
     */
    private InternalPortletConfig portletConfig;

    /**
     * The Event Portlet instance (the same object as portlet) wrapped by this
     * servlet.
     */
    private EventPortlet eventPortlet = null;

    /** The resource serving portlet instance wrapped by this servlet. */
    private ResourceServingPortlet resourceServingPortlet = null;

    private PortletContextService contextService;

    private ContainerInvocationService containerInvocationService;

    private boolean started = false;
    private Timer   startTimer = null;
    
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
    public void init(ServletConfig config) throws ServletException
    {

        // Call the super initialization method.
        super.init(config);

        // Retrieve portlet name as defined as an initialization parameter.
        portletName = getInitParameter("portlet-name");

        started = false;

        startTimer = new Timer(true);
        final ServletContext servletContext = getServletContext();
        final ClassLoader paClassLoader = Thread.currentThread().getContextClassLoader();
        startTimer.schedule(new TimerTask()
        {
            public void run()
            {
                synchronized(servletContext)
                {
                    if (startTimer != null)
                    {
                        if (attemptRegistration(servletContext, paClassLoader ))
                        {
                            startTimer.cancel();
                            startTimer = null;
                        }
                    }
                }
            }
        }, 1, 10000);
    }
    
    protected boolean attemptRegistration(ServletContext context, ClassLoader paClassLoader)
    {
        if (PlutoServices.getServices() != null) 
        {
            contextService = PlutoServices.getServices().getPortletContextService();
            containerInvocationService = PlutoServices.getServices().getContainerInvocationService();
            try
            {
                ServletConfig sConfig = getServletConfig();
                if (sConfig == null)
                {
                    String msg = "Problem obtaining servlet configuration(getServletConfig() returns null).";
                    context.log(msg);
                    return true;
                }

                String applicationName = contextService.register(sConfig);
                started = true;
                portletContext = (InternalPortletContext) contextService.getPortletContext(applicationName);
                portletConfig = (InternalPortletConfig) contextService.getPortletConfig(applicationName, portletName);

            }
            catch (PortletContainerException ex)
            {
                context.log(ex.getMessage(),ex);
                return true;
            }

            PortletDefinition portletDD = portletConfig.getPortletDefinition();

//          Create and initialize the portlet wrapped in the servlet.
            try
            {
                Class clazz = paClassLoader.loadClass((portletDD.getPortletClass()));
                portlet = (Portlet) clazz.newInstance();
                portlet.init(portletConfig);
                initializeEventPortlet();
                initializeResourceServingPortlet();
                return true;
            }
            catch (Exception ex)
            {
                context.log(ex.getMessage(),ex);
                return true;
            }
        }
        return false;
    }

    public void destroy()
    {
        synchronized(getServletContext())
        {
            if ( startTimer != null )
            {
              startTimer.cancel();
              startTimer = null;
            }
            else if ( started && portletContext != null)
            {
              started = false;
              contextService.unregister(portletContext);
              if (portlet != null)
              {
                  portlet.destroy();
              }
            }
            super.destroy();
        }
    }

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {
        dispatch(request, response);
    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {
        dispatch(request, response);
    }

    protected void doPut(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {
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
        InternalPortletRequest portletRequest = null;
        InternalPortletResponse portletResponse = null;
        // Save portlet config into servlet request.

        request.setAttribute(Constants.PORTLET_CONFIG, portletConfig);

        // Retrieve attributes from the servlet request.
        Integer methodId = (Integer) request.getAttribute(Constants.METHOD_ID);

        portletRequest = (InternalPortletRequest) request
                .getAttribute(Constants.PORTLET_REQUEST);

        portletResponse = (InternalPortletResponse) request
                .getAttribute(Constants.PORTLET_RESPONSE);

        FilterManager filterManager = (FilterManager) request
                .getAttribute(Constants.FILTER_MANAGER);

        portletRequest.init(portletContext, request);

        PortletWindow window = containerInvocationService.getInvocation()
                .getPortletWindow();

        PortletInvocationEvent event = new PortletInvocationEvent(
                portletRequest, window, methodId.intValue());

        notify(event, true, null);

        // Init the classloader for the filter and get the Service for
        // processing the filters.
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        // FilterManager filtermanager = (FilterManager) request.getAttribute(
        // "filter-manager");

        try
        {

            // The requested method is RENDER: call Portlet.render(..)
            if (methodId == Constants.METHOD_RENDER)
            {
                RenderRequest renderRequest = (RenderRequest) portletRequest;
                RenderResponse renderResponse = (RenderResponse) portletResponse;
                filterManager.processFilter(renderRequest, renderResponse,
                        loader, portlet, portletContext);
            }

            // The requested method is RESOURCE: call
            // ResourceServingPortlet.serveResource(..)
            else if (methodId == Constants.METHOD_RESOURCE)
            {
                ResourceRequest resourceRequest = (ResourceRequest) portletRequest;
                ResourceResponse resourceResponse = (ResourceResponse) portletResponse;
                filterManager.processFilter(resourceRequest, resourceResponse,
                        loader, resourceServingPortlet, portletContext);
            }

            // The requested method is ACTION: call Portlet.processAction(..)
            else if (methodId == Constants.METHOD_ACTION)
            {
                ActionRequest actionRequest = (ActionRequest) portletRequest;
                ActionResponse actionResponse = (ActionResponse) portletResponse;
                filterManager.processFilter(actionRequest, actionResponse,
                        loader, portlet, portletContext);
            }

            // The request methode is Event: call Portlet.processEvent(..)
            else if (methodId == Constants.METHOD_EVENT)
            {
                EventRequest eventRequest = (EventRequest) portletRequest;
                EventResponse eventResponse = (EventResponse) portletResponse;
                filterManager.processFilter(eventRequest, eventResponse,
                        loader, eventPortlet, portletContext);
            }
            // The requested method is ADMIN: call handlers.
            else if (methodId == Constants.METHOD_ADMIN)
            {

                ContainerInvocation inv = containerInvocationService
                        .getInvocation();
                PortalAdministrationService pas = inv.getPortletContainer()
                        .getOptionalContainerServices()
                        .getPortalAdministrationService();

                Iterator it = pas.getAdministrativeRequestListeners()
                        .iterator();
                while (it.hasNext())
                {
                    AdministrativeRequestListener l = (AdministrativeRequestListener) it
                            .next();
                    l.administer(portletRequest, portletResponse);
                }
            }

            // The requested method is NOOP: do nothing.
            else if (methodId == Constants.METHOD_NOOP)
            {
                // Do nothing.
            }

            notify(event, false, null);

        }
        catch (javax.portlet.UnavailableException ex)
        {
            System.err.println(ex.getMessage());
            /*
             * if (e.isPermanent()) { throw new
             * UnavailableException(e.getMessage()); } else { throw new
             * UnavailableException(e.getMessage(), e.getUnavailableSeconds());
             * }
             */

            // Portlet.destroy() isn't called by Tomcat, so we have to fix it.
            try
            {
                portlet.destroy();
            }
            catch (Throwable th)
            {
                System.err.println(ex.getMessage());
                // Don't care for Exception
            }

            // TODO: Handle everything as permanently for now.
            throw new javax.servlet.UnavailableException(ex.getMessage());

        }
        catch (PortletException ex)
        {
            notify(event, false, ex);
            System.err.println(ex.getMessage());
            throw new ServletException(ex);

        }
        finally
        {
            request.removeAttribute(Constants.PORTLET_CONFIG);
            if (portletRequest != null)
            {
                portletRequest.release();
            }
        }
    }

    protected void notify(PortletInvocationEvent event, boolean pre, Throwable e)
    {
        ContainerInvocation inv = containerInvocationService.getInvocation();
        PortalAdministrationService pas = inv.getPortletContainer()
                .getOptionalContainerServices()
                .getPortalAdministrationService();

        Iterator i = pas.getPortletInvocationListeners().iterator();
        while (i.hasNext())
        {
            PortletInvocationListener listener = (PortletInvocationListener) i
                    .next();
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
        else
        {
            eventPortlet = new NullPortlet();
        }
    }

    private void initializeResourceServingPortlet()
    {
        if (portlet instanceof ResourceServingPortlet)
        {
            resourceServingPortlet = (ResourceServingPortlet) portlet;
        }
        else
        {
            resourceServingPortlet = new NullPortlet();
        }
    }
}
