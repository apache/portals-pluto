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
import java.util.Timer;
import java.util.TimerTask;

import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.HeaderRequest;
import javax.portlet.HeaderResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.StateAwareResponse;
import javax.portlet.UnavailableException;
import javax.servlet.DispatcherType;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestWrapper;
import javax.servlet.ServletResponse;
import javax.servlet.ServletResponseWrapper;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.pluto.container.FilterManager;
import org.apache.pluto.container.PortletAsyncManager;
import org.apache.pluto.container.PortletContainerException;
import org.apache.pluto.container.PortletInvokerService;
import org.apache.pluto.container.PortletRequestContext;
import org.apache.pluto.container.PortletResourceRequestContext;
import org.apache.pluto.container.PortletResponseContext;
import org.apache.pluto.container.PortletWindow;
import org.apache.pluto.container.bean.processor.AnnotatedConfigBean;
import org.apache.pluto.container.bean.processor.PortletArtifactProducer;
import org.apache.pluto.container.bean.processor.PortletInvoker;
import org.apache.pluto.container.bean.processor.PortletRequestScopedBeanHolder;
import org.apache.pluto.container.bean.processor.PortletSessionBeanHolder;
import org.apache.pluto.container.bean.processor.PortletStateScopedBeanHolder;
import org.apache.pluto.container.impl.HttpServletPortletRequestWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Portlet Invocation Servlet. This servlet receives cross context requests from the the container and services the
 * portlet request for the specified method.
 * 
 * @version 1.1
 * @since 09/22/2004
 */
public class PortletServlet3 extends HttpServlet {
   private static final long  serialVersionUID = -5096339022539360365L;
   
   /** Logger. */
   private static final Logger LOG = LoggerFactory.getLogger(PortletServlet3.class);

   /**
    * Portlet name constant, needed by portlet container initializer
    */
   public static final String PORTLET_NAME     = "portlet-name";

   // Private Member Variables ------------------------------------------------
   
   @Inject private AnnotatedConfigBean acb;
   @Inject private BeanManager beanmgr;

   /**
    * The portlet name as defined in the portlet app descriptor.
    */
   private String                 portletName;

   /**
    * The portlet instance wrapped by this servlet.
    */
   private PortletInvoker invoker = null;

   /**
    * The internal portlet context instance.
    */
   private DriverPortletContext   portletContext;

   /**
    * The internal portlet config instance.
    */
   private DriverPortletConfig    portletConfig;

   private PortletContextService  contextService;

   private boolean                started = false;
   Timer                          startTimer;

   // HttpServlet Impl --------------------------------------------------------

   public String getServletInfo() {
      return "Pluto PortletServlet3 [" + portletName + "]";
   }

   /**
    * Initialize the portlet invocation servlet.
    * 
    * @throws ServletException
    *            if an error occurs while loading portlet.
    */
   public void init(ServletConfig config) throws ServletException {

      // Call the super initialization method.
      super.init(config);

      // Retrieve portlet name as defined as an initialization parameter.
      portletName = getInitParameter(PORTLET_NAME);
      
      // Get the config bean and create the invoker
      try {
         if (acb == null || acb.getMethodStore() == null) {
            LOG.error("Could not obtain configuration bean for portlet " + portletName + ". Exiting.");
            return;
         } else {
            invoker = new PortletInvoker(acb, portletName);
            LOG.debug("Created the portlet invoker for portlet: " + portletName);
         }
      } catch(Exception e) {
         LOG.error("Exception obtaining configuration bean for portlet " + portletName + ". Exiting. Exception: " + e.toString());
         return;
      }

      started = false;

      startTimer = new Timer(true);
      final ServletContext servletContext = getServletContext();
      final ClassLoader paClassLoader = Thread.currentThread().getContextClassLoader();
      startTimer.schedule(new TimerTask() {
         public void run() {
            synchronized (servletContext) {
               if (startTimer != null) {
                  if (attemptRegistration(servletContext, paClassLoader)) {
                     startTimer.cancel();
                     startTimer = null;
                  }
               }
            }
         }
      }, 1, 10000);
   }

   protected boolean attemptRegistration(ServletContext context, ClassLoader paClassLoader) {
      if (PlutoServices.getServices() != null) {
         contextService = PlutoServices.getServices().getPortletContextService();
         try {
            ServletConfig sConfig = getServletConfig();
            if (sConfig == null) {
               String msg = "Problem obtaining servlet configuration(getServletConfig() returns null).";
               context.log(msg);
               return true;
            }

            String applicationName = contextService.register(sConfig);
            started = true;
            portletContext = contextService.getPortletContext(applicationName);
            portletConfig = contextService.getPortletConfig(applicationName, portletName);

         } catch (PortletContainerException ex) {
            context.log(ex.getMessage(), ex);
            return true;
         }

         // initialize the portlet wrapped in the servlet.
         try {
            invoker.init(portletConfig);
            return true;
         } catch (Exception ex) {
            context.log(ex.getMessage(), ex);
            // take out of service
            invoker = null;
            portletConfig = null;
            return true;
         }
      }
      return false;
   }

   public void destroy() {
      synchronized (getServletContext()) {
         if (startTimer != null) {
            startTimer.cancel();
            startTimer = null;
         } else if (started && portletContext != null) {
            started = false;
            contextService.unregister(portletContext);
            if (invoker != null) {
               try {
                  invoker.destroy();
               } catch (Exception e) {
                  // ignore
               }
               invoker = null;
            }
         }
         super.destroy();
      }
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      dispatch(request, response);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      dispatch(request, response);
   }

   protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      dispatch(request, response);
   }

   // Private Methods ---------------------------------------------------------

   /**
    * Dispatch the request to the appropriate portlet methods. This method assumes that the following attributes are set
    * in the servlet request scope:
    * <ul>
    * <li>METHOD_ID: indicating which method to dispatch.</li>
    * <li>PORTLET_REQUEST: the internal portlet request.</li>
    * <li>PORTLET_RESPONSE: the internal portlet response.</li>
    * </ul>
    * 
    * @param request
    *           the servlet request.
    * @param response
    *           the servlet response.
    * @throws ServletException
    * @throws IOException
    */
   private void dispatch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      if (LOG.isDebugEnabled()) {
         StringBuilder txt = new StringBuilder();
         txt.append("Processing request.");
         txt.append(" Dispatcher type: ").append(request.getDispatcherType());
         txt.append(", request URI: ").append(request.getRequestURI());
         LOG.debug(txt.toString());
      }
      if (invoker == null) {
         throw new javax.servlet.UnavailableException("Portlet " + portletName + " unavailable");
      }

      // Retrieve attributes from the servlet request.
      Integer methodId = (Integer) request.getAttribute(PortletInvokerService.METHOD_ID);

      final PortletRequest portletRequest = (PortletRequest) request
            .getAttribute(PortletInvokerService.PORTLET_REQUEST);

      final PortletResponse portletResponse = (PortletResponse) request
            .getAttribute(PortletInvokerService.PORTLET_RESPONSE);

      final PortletRequestContext requestContext = (PortletRequestContext) portletRequest
            .getAttribute(PortletInvokerService.REQUEST_CONTEXT);
      final PortletResponseContext responseContext = (PortletResponseContext) portletRequest
            .getAttribute(PortletInvokerService.RESPONSE_CONTEXT);

      final FilterManager filterManager = 
            (FilterManager) request.getAttribute(PortletInvokerService.FILTER_MANAGER);
      filterManager.setBeanManager(beanmgr);

      if (LOG.isTraceEnabled()) {
         StringBuilder txt = new StringBuilder(128);
         txt.append("\nRequest wrapper stack: ");
         ServletRequest wreq = request;
         ServletRequest tstreq = requestContext.getServletRequest();
         int n = 1;
         while (wreq instanceof ServletRequestWrapper) {
            txt.append("\nLevel ").append(n++).append(": ").append(wreq.getClass().getCanonicalName());
            txt.append(", dispatch type: ").append(wreq.getDispatcherType());
            txt.append(", equal to req context req: ").append(wreq == tstreq);
            wreq = ((ServletRequestWrapper) wreq).getRequest();
         }
         txt.append("\nLevel ").append(n++).append(": ").append(wreq.getClass().getCanonicalName());
         txt.append(", dispatch type: ").append(wreq.getDispatcherType());
         txt.append(", equal to req context req: ").append(wreq == tstreq);

         txt.append("\n\nResponse wrapper stack: ");
         ServletResponse wresp = response;
         ServletResponse tstresp = requestContext.getServletResponse();
         n = 1;
         while (wresp instanceof ServletResponseWrapper) {
            txt.append("\nLevel ").append(n++).append(": ").append(wresp.getClass().getCanonicalName());
            txt.append(", equal to req context resp: ").append(wresp == tstresp);
            wresp = ((ServletResponseWrapper) wresp).getResponse();
         }
         txt.append("\nLevel ").append(n++).append(": ").append(wresp.getClass().getCanonicalName());
         txt.append(", equal to req context resp: ").append(wresp == tstresp);
         LOG.debug(txt.toString());
      }
      
      if (request.getDispatcherType() == DispatcherType.ASYNC) {
         
         // have to reinitialize the request context with the request under our wrapper.
         
         ServletRequest wreq = request;
         while ((wreq instanceof ServletRequestWrapper) &&
               !(wreq instanceof HttpServletPortletRequestWrapper) ) {
            wreq = ((ServletRequestWrapper) wreq).getRequest();
         }
         
         if (wreq instanceof HttpServletPortletRequestWrapper) {
            
            HttpServletRequest hreq = (HttpServletRequest) ((HttpServletPortletRequestWrapper) wreq).getRequest();
            HttpServletResponse hresp = requestContext.getServletResponse();
            
            LOG.debug("Extracted wrapped request. Dispatch type: " + hreq.getDispatcherType());

            requestContext.init(portletConfig, getServletContext(), hreq, hresp);
            requestContext.setAsyncServletRequest(request);       // store original request
            responseContext.init(hreq, hresp);
            
         } else {
            LOG.debug("Couldn't find the portlet async wrapper.");
         }

         // enable contextual support for async
         ((PortletResourceRequestContext)requestContext).getPortletAsyncContext().registerContext(false);
         
      } else {
         
         // Not an async dispatch
         
         requestContext.init(portletConfig, getServletContext(), request, response);
         requestContext.setExecutingRequestBody(true);
         responseContext.init(request, response);

         // enable contextual support
         beforeInvoke(portletRequest, portletResponse, portletConfig);
      
      }

      PortletWindow window = requestContext.getPortletWindow();

      PortletInvocationEvent event = new PortletInvocationEvent(portletRequest, window, methodId.intValue());
      notify(event, true, null);
      
      try {
         
         // The requested method is RENDER: call Portlet.render(..)
         if (methodId == PortletInvokerService.METHOD_RENDER) {
            RenderRequest renderRequest = (RenderRequest) portletRequest;
            String rh = requestContext.getRenderHeaders();
            if (rh != null) {
               renderRequest.setAttribute(PortletRequest.RENDER_PART, rh);
            }
            RenderResponse renderResponse = (RenderResponse) portletResponse;
            filterManager.processFilter(renderRequest, renderResponse, invoker, portletContext);
         }

         // The requested method is HEADER: call
         // HeaderPortlet.renderHeaders(..)
         else if (methodId == PortletInvokerService.METHOD_HEADER) {
            HeaderRequest headerRequest = (HeaderRequest) portletRequest;
            HeaderResponse headerResponse = (HeaderResponse) portletResponse;
            filterManager.processFilter(headerRequest, headerResponse, invoker, portletContext);
         }

         // The requested method is RESOURCE: call
         // ResourceServingPortlet.serveResource(..)
         else if (methodId == PortletInvokerService.METHOD_RESOURCE) {
            ResourceRequest resourceRequest = (ResourceRequest) portletRequest;

            // if pageState != null, we're dealing with a Partial Action request, so
            // store the page state string as a request attribute
            PortletResourceRequestContext rc = (PortletResourceRequestContext) requestContext;
            String ps = rc.getPageState();
            if (ps != null) {
               resourceRequest.setAttribute(ResourceRequest.PAGE_STATE, ps);
            }
            
            rc.setBeanManager(beanmgr);

            ResourceResponse resourceResponse = (ResourceResponse) portletResponse;
            filterManager.processFilter(resourceRequest, resourceResponse, invoker, portletContext);
         }

         // The requested method is ACTION: call Portlet.processAction(..)
         else if (methodId == PortletInvokerService.METHOD_ACTION) {
            ActionRequest actionRequest = (ActionRequest) portletRequest;
            ActionResponse actionResponse = (ActionResponse) portletResponse;
            filterManager.processFilter(actionRequest, actionResponse, invoker, portletContext);
         }

         // The request methode is Event: call Portlet.processEvent(..)
         else if (methodId == PortletInvokerService.METHOD_EVENT) {
            EventRequest eventRequest = (EventRequest) portletRequest;
            EventResponse eventResponse = (EventResponse) portletResponse;
            filterManager.processFilter(eventRequest, eventResponse, invoker, portletContext);
         }
         // The requested method is ADMIN: call handlers.
         else if (methodId == PortletInvokerService.METHOD_ADMIN) {
            PortalAdministrationService pas = PlutoServices.getServices().getPortalAdministrationService();

            for (AdministrativeRequestListener l : pas.getAdministrativeRequestListeners()) {
               l.administer(portletRequest, portletResponse);
            }
         }

         // The requested method is LOAD: do nothing.
         else if (methodId == PortletInvokerService.METHOD_LOAD) {
            // Do nothing.
         }

         notify(event, false, null);

      } catch (UnavailableException ex) {
         //
         // if (e.isPermanent()) { throw new
         // UnavailableException(e.getMessage()); } else { throw new
         // UnavailableException(e.getMessage(), e.getUnavailableSeconds());
         // }
         //

         // Portlet.destroy() isn't called by Tomcat, so we have to fix it.
         try {
            invoker.destroy();
         } catch (Throwable th) {
            // Don't care for Exception
            this.getServletContext().log("Error during portlet destroy.", th);
         }
         // take portlet out of service
         invoker = null;

         throw new javax.servlet.UnavailableException(ex.getMessage());

      } catch (PortletException ex) {
         notify(event, false, ex);
         throw new ServletException(ex);

      } finally {
         
         requestContext.setExecutingRequestBody(false);
         
         // If an async request is running or has been dispatched, resources
         // will be released by the PortletAsyncListener. Otherwise release here.
         
         if (!request.isAsyncStarted() && (request.getDispatcherType() != DispatcherType.ASYNC)) {

            LOG.debug("Async not being processed, releasing resources. executing req body: " + requestContext.isExecutingRequestBody());

            request.removeAttribute(PortletInvokerService.METHOD_ID);
            request.removeAttribute(PortletInvokerService.PORTLET_REQUEST);
            request.removeAttribute(PortletInvokerService.PORTLET_RESPONSE);
            request.removeAttribute(PortletInvokerService.FILTER_MANAGER);

            afterInvoke(portletResponse);

         } else {
            LOG.debug("Async started, not releasing resources. executing req body: " + requestContext.isExecutingRequestBody());

            if (requestContext instanceof PortletResourceRequestContext) {
               PortletResourceRequestContext resctx = (PortletResourceRequestContext)requestContext;
               PortletAsyncManager pac = resctx.getPortletAsyncContext();
               if (pac != null) {
                  pac.deregisterContext(false);
                  pac.launchRunner();
               } else {
                  LOG.warn("Couldn't get portlet async context.");
               }
            } else {
               LOG.warn("Wrong kind of request context: " + requestContext.getClass().getCanonicalName());
            }

         }
      }
   }

   protected void notify(PortletInvocationEvent event, boolean pre, Throwable e) {
      PortalAdministrationService pas = PlutoServices.getServices().getPortalAdministrationService();

      for (PortletInvocationListener listener : pas.getPortletInvocationListeners()) {
         if (pre) {
            listener.onBegin(event);
         } else if (e == null) {
            listener.onEnd(event);
         } else {
            listener.onError(event, e);
         }
      }
   }


   /**
    * To be called before bean method invocation begins
    */
   private void beforeInvoke(PortletRequest req, PortletResponse resp, PortletConfig config) {

      // Set the portlet session bean holder for the thread & session
      PortletRequestScopedBeanHolder.setBeanHolder();

      // Set the portlet session bean holder for the thread & session
      PortletSessionBeanHolder.setBeanHolder(req, acb.getSessionScopedConfig());

      // Set the render state scoped bean holder
      PortletStateScopedBeanHolder.setBeanHolder(req, acb.getStateScopedConfig());

      // Set up the artifact producer with request, response, and portlet config
      PortletArtifactProducer.setPrecursors(req, resp, config);
      
      LOG.debug("CDI context is now set up.");
   }

   /**
    * must be called after all method invocations have taken place, even if an
    * exception occurs.
    */
   private void afterInvoke(PortletResponse resp) {

      // Remove the portlet session bean holder for the thread
      PortletRequestScopedBeanHolder.removeBeanHolder();

      // Remove the portlet session bean holder for the thread
      PortletSessionBeanHolder.removeBeanHolder();

      // Remove the render state bean holder. pass response if we're
      // dealing with a StateAwareResponse. The response is used for state
      // storage.

      StateAwareResponse sar = null;
      if (resp instanceof StateAwareResponse) {
         sar = (StateAwareResponse) resp;
      }
      PortletStateScopedBeanHolder.removeBeanHolder(sar);

      // remove the portlet artifact producer
      PortletArtifactProducer.remove();

      LOG.debug("CDI context is now deactivated.");
   }
}
