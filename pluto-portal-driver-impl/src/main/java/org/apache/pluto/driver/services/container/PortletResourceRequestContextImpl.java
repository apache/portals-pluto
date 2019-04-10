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
package org.apache.pluto.driver.services.container;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.enterprise.inject.spi.BeanManager;
import javax.portlet.PortletConfig;
import javax.portlet.PortletRequest;
import javax.portlet.ResourceParameters;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.AsyncContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.pluto.container.PortletAsyncManager;
import org.apache.pluto.container.PortletContainer;
import org.apache.pluto.container.PortletInvokerService;
import org.apache.pluto.container.PortletResourceRequestContext;
import org.apache.pluto.container.PortletWindow;
import org.apache.pluto.container.impl.HttpServletPortletRequestWrapper;
import org.apache.pluto.container.impl.HttpServletPortletResponseWrapper;
import org.apache.pluto.container.impl.ResourceParametersImpl;
import org.apache.pluto.container.impl.ServletPortletSessionProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @version $Id$
 * 
 */
public class PortletResourceRequestContextImpl extends PortletRequestContextImpl implements
      PortletResourceRequestContext {

   /** Logger. */
   private static final Logger  LOG     = LoggerFactory.getLogger(PortletResourceRequestContextImpl.class);
   @SuppressWarnings("unused")
   private static final boolean isDebug = LOG.isDebugEnabled();
   private static final boolean isTrace = LOG.isTraceEnabled();

   private ResourceResponse         response;
   private PortletAsyncContextImpl  actx;
   private BeanManager              beanmgr;

   public PortletResourceRequestContextImpl(PortletContainer container, HttpServletRequest containerRequest,
         HttpServletResponse containerResponse, PortletWindow window) {
      // if pageState != null, we're dealing with a Partial Action request, so
      // the servlet parameters are not to be used. Otherwise, resource params could be
      // passed as servlet parameters.
      super(container, containerRequest, containerResponse, window, true, PortletRequest.RESOURCE_PHASE);
   }
   
   @Override
   public PortletAsyncManager getPortletAsyncContext() {
      return actx;
   }

   @Override
   public String getCacheability() {
      return getPortalURL().getCacheability();
   }

   @Override
   public Map<String, String[]> getPrivateRenderParameterMap() {
      return paramFactory.getResourceRenderParameterMap(window.getId().getStringId());
   }

   @Override
   public String getResourceID() {
      return getPortalURL().getResourceID();
   }

   @Override
   public ResourceParameters getResourceParameters() {
      return new ResourceParametersImpl(urlProvider, windowId);
   }

   /**
    * @return the response
    */
   @Override
   public ResourceResponse getResponse() {
      return response;
   }

   /**
    * @param response
    *           the response to set
    */
   @Override
   public void setResponse(ResourceResponse response) {
      this.response = response;
   }

   /**
    * @return the beanmgr
    */
   @Override
   public BeanManager getBeanManager() {
      return beanmgr;
   }

   /**
    * @param beanmgr the beanmgr to set
    */
   @Override
   public void setBeanManager(BeanManager beanmgr) {
      this.beanmgr = beanmgr;
   }

   @Override
   public AsyncContext startAsync(ResourceRequest request) throws IllegalStateException {
      return startAsync(request, response, true);
   }

   @Override
   public AsyncContext startAsync(ResourceRequest resreq, ResourceResponse resresp, boolean origReqResp) throws IllegalStateException {
      if (!isAsyncSupported()) {
         throw new IllegalStateException("This portlet does not support asynchronous mode.");
      }

      if (actx != null && actx.isComplete()) {
         return null;
      }


      HttpServletRequest hreq = getServletRequest();
      HttpServletResponse hresp = getServletResponse();
      PortletConfig cfg = getPortletConfig();

      if (isTrace) {
         List<String> attrNames = Collections.list(hreq.getAttributeNames());
         StringBuilder txt = new StringBuilder(128);
         txt.append("Start async before:");
         txt.append("\nAttribute names: ").append(attrNames);
         txt.append("\nasync_request_uri:      ").append((String) hreq.getAttribute("javax.servlet.async.request_uri"));
         txt.append("\nasync_context_path:      ").append(
               (String) hreq.getAttribute("javax.servlet.async.context_path"));
         txt.append("\nasync_servlet_path:      ").append(
               (String) hreq.getAttribute("javax.servlet.async.servlet_path"));
         txt.append("\nasync_path_info:      ").append((String) hreq.getAttribute("javax.servlet.async.path_info"));
         txt.append("\nasync_query_string:      ").append(
               (String) hreq.getAttribute("javax.servlet.async.query_string"));
         txt.append("\nforward_request_uri:      ").append(
               (String) hreq.getAttribute("javax.servlet.forward.request_uri"));
         txt.append("\nforward_context_path:      ").append(
               (String) hreq.getAttribute("javax.servlet.forward.context_path"));
         txt.append("\nforward_servlet_path:      ").append(
               (String) hreq.getAttribute("javax.servlet.forward.servlet_path"));
         txt.append("\nforward_path_info:      ").append((String) hreq.getAttribute("javax.servlet.forward.path_info"));
         txt.append("\nforward_query_string:      ").append(
               (String) hreq.getAttribute("javax.servlet.forward.query_string"));
         txt.append("\ninclude_request_uri:      ").append(
               (String) hreq.getAttribute("javax.servlet.include.request_uri"));
         txt.append("\ninclude_context_path:      ").append(
               (String) hreq.getAttribute("javax.servlet.include.context_path"));
         txt.append("\ninclude_servlet_path:      ").append(
               (String) hreq.getAttribute("javax.servlet.include.servlet_path"));
         txt.append("\ninclude_path_info:      ").append((String) hreq.getAttribute("javax.servlet.include.path_info"));
         txt.append("\ninclude_query_string:      ").append(
               (String) hreq.getAttribute("javax.servlet.include.query_string"));
         txt.append("\nmethod_request_uri:      ").append(hreq.getRequestURI());
         txt.append("\nmethod_context_path:      ").append(hreq.getContextPath());
         txt.append("\nmethod_servlet_path:      ").append(hreq.getServletPath());
         txt.append("\nmethod_path_info:      ").append(hreq.getPathInfo());
         txt.append("\nmethod_query_string:      ").append(hreq.getQueryString());
         LOG.debug(txt.toString());
      }

      // Set portlet-scoped attributes directly on resource request

      resreq.setAttribute(PortletInvokerService.PORTLET_CONFIG, cfg);
      resreq.setAttribute(PortletInvokerService.PORTLET_REQUEST, resreq);
      resreq.setAttribute(PortletInvokerService.PORTLET_RESPONSE, resresp);

      // Wrap http request & response if not already wrapped.

      HttpServletRequest wreq = getAsyncServletRequest();
      if (wreq == null) {
         wreq = new HttpServletPortletRequestWrapper(hreq, getSession(), resreq);
         ((HttpServletPortletRequestWrapper) wreq).startAsyncProcessing();
      } 
      
      
      HttpServletResponse wresp = new HttpServletPortletResponseWrapper(hresp, resreq, resresp, false);

      // Start async, create portlet async context first time only.

      if (actx != null) {
         actx.setWrapped(hreq.startAsync(wreq, wresp));
      } else {
         actx = new PortletAsyncContextImpl(hreq.startAsync(wreq, wresp), this, resreq, resresp, origReqResp);
      }

      if (isTrace) {
         List<String> attrNames = Collections.list(hreq.getAttributeNames());
         StringBuilder txt = new StringBuilder(128);
         txt.append("Start async after (wreq):");
         txt.append("\nAttribute names: ").append(attrNames);
         txt.append("\nasync_request_uri:      ").append((String) wreq.getAttribute("javax.servlet.async.request_uri"));
         txt.append("\nasync_context_path:      ").append(
               (String) wreq.getAttribute("javax.servlet.async.context_path"));
         txt.append("\nasync_servlet_path:      ").append(
               (String) wreq.getAttribute("javax.servlet.async.servlet_path"));
         txt.append("\nasync_path_info:      ").append((String) wreq.getAttribute("javax.servlet.async.path_info"));
         txt.append("\nasync_query_string:      ").append(
               (String) wreq.getAttribute("javax.servlet.async.query_string"));
         txt.append("\nforward_request_uri:      ").append(
               (String) wreq.getAttribute("javax.servlet.forward.request_uri"));
         txt.append("\nforward_context_path:      ").append(
               (String) wreq.getAttribute("javax.servlet.forward.context_path"));
         txt.append("\nforward_servlet_path:      ").append(
               (String) wreq.getAttribute("javax.servlet.forward.servlet_path"));
         txt.append("\nforward_path_info:      ").append((String) wreq.getAttribute("javax.servlet.forward.path_info"));
         txt.append("\nforward_query_string:      ").append(
               (String) wreq.getAttribute("javax.servlet.forward.query_string"));
         txt.append("\ninclude_request_uri:      ").append(
               (String) wreq.getAttribute("javax.servlet.include.request_uri"));
         txt.append("\ninclude_context_path:      ").append(
               (String) wreq.getAttribute("javax.servlet.include.context_path"));
         txt.append("\ninclude_servlet_path:      ").append(
               (String) wreq.getAttribute("javax.servlet.include.servlet_path"));
         txt.append("\ninclude_path_info:      ").append((String) wreq.getAttribute("javax.servlet.include.path_info"));
         txt.append("\ninclude_query_string:      ").append(
               (String) wreq.getAttribute("javax.servlet.include.query_string"));
         txt.append("\nmethod_request_uri:      ").append(wreq.getRequestURI());
         txt.append("\nmethod_context_path:      ").append(wreq.getContextPath());
         txt.append("\nmethod_servlet_path:      ").append(wreq.getServletPath());
         txt.append("\nmethod_path_info:      ").append(wreq.getPathInfo());
         txt.append("\nmethod_query_string:      ").append(wreq.getQueryString());
         LOG.debug(txt.toString());
      }

      return actx;
   }

   // For wrapper use
   @Override
   public AsyncContext startAsync() {
      if (!isAsyncSupported()) {
         throw new IllegalStateException("This portlet does not support asynchronous mode.");
      }
      if (actx != null && actx.isComplete()) {
         return null;
      }
      AsyncContext ac = getServletRequest().startAsync();
      if (actx == null) {
         // this should not happen, the wrapper is created during the resource request
         LOG.error("====>>> Wrapper invocation invalid before resource async started.");
      } else {
         actx.setWrapped(ac);
      }
      return actx;
   }

   // for wrapper use
   @Override
   public AsyncContext startAsync(ServletRequest request, ServletResponse response) {
      if (!isAsyncSupported()) {
         throw new IllegalStateException("This portlet does not support asynchronous mode.");
      }
      if (actx != null && actx.isComplete()) {
         return null;
      }
      AsyncContext ac = getServletRequest().startAsync(request, response);
      if (actx == null) {
         // this should not happen, the wrapper is created during the resource request
         LOG.error("====>>> Wrapper invocation invalid before resource async started.");
      } else {
         actx.setWrapped(ac);
      }
      return actx;
   }

   @Override
   public boolean isAsyncStarted() {
      return getServletRequest().isAsyncStarted();
   }

   @Override
   public boolean isAsyncSupported() {
      return getPortletWindow().getPortletDefinition().isAsyncSupported();
   }

   @Override
   public AsyncContext getAsyncContext() {
      if (!isAsyncSupported()) {
         throw new IllegalStateException("This portlet does not support asynchronous mode.");
      }
      if (actx != null) {
         if (actx.isComplete()) {
            return null;
         }
         return actx;
      }
      return getServletRequest().getAsyncContext();
   }

   // For use within the wrapper.
   // PLT.10.4.3. Proxied session is created and passed if
   // javax.portlet.servletDefaultSessionScope == PORTLET_SCOPE
   @Override
   public HttpSession getSession() {
      HttpSession sess = null;

      PortletConfig portletConfig = getPortletConfig();
      Map<String, String[]> containerRuntimeOptions = portletConfig.getContainerRuntimeOptions();
      String[] values = containerRuntimeOptions.get("javax.portlet.servletDefaultSessionScope");

      if ((values != null) && (values.length > 0) && "PORTLET_SCOPE".equals(values[0])) {
         String portletWindowId = getPortletWindow().getId().getStringId();
         sess = ServletPortletSessionProxy.createProxy(getServletRequest(), portletWindowId);
      }

      return sess;
   }
   
   /**
    * called with the argument set to false when the request body is no longer being executed.
    * In this case, set the PortletAsyncContext to no longer active, which means that
    * no more listeners can be added, etc.
    */
   @Override
   public void setExecutingRequestBody(boolean executingRequestBody) {
      if (actx != null && !executingRequestBody) {
         actx.setContextInactive();
      }
      super.setExecutingRequestBody(executingRequestBody);
   }

}
