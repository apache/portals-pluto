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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionParameters;
import javax.portlet.PortletConfig;
import javax.portlet.RenderParameters;
import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.pluto.container.PortletContainer;
import org.apache.pluto.container.PortletRequestContext;
import org.apache.pluto.container.PortletURLProvider;
import org.apache.pluto.container.PortletWindow;
import org.apache.pluto.container.impl.ActionParametersImpl;
import org.apache.pluto.container.impl.MutableActionParametersImpl;
import org.apache.pluto.container.impl.MutableRenderParametersImpl;
import org.apache.pluto.container.impl.MutableResourceParametersImpl;
import org.apache.pluto.container.impl.PortletURLImpl;
import org.apache.pluto.container.impl.RenderParametersImpl;
import org.apache.pluto.container.impl.ResourceParametersImpl;
import org.apache.pluto.driver.core.PortalRequestContext;
import org.apache.pluto.driver.url.PortalURL;
import org.apache.pluto.driver.url.PortletParameterFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @version $Id$
 *
 */
public class PortletRequestContextImpl implements PortletRequestContext {
   private static final Logger LOG = LoggerFactory.getLogger(PortletRequestContextImpl.class);
   private static final boolean isTrace = LOG.isTraceEnabled();
   

   private PortletContainer    container;
   
   // The original request and response arriving at the portal
   private HttpServletRequest  containerRequest;
   private HttpServletResponse containerResponse;
   
   // Wrapped servlet request set for the duration of a request dispatcher or async dispatch
   private HttpServletRequest  dispatchedServletRequest;
   
   // original wrapped servlet request arriving at the portlet servlet during an
   // async dispatch
   private HttpServletRequest  asyncServletRequest;
   
   // Request and response objects arriving at the portlet servlet
   // (for the first time, in the case of an async dispatch)
   private HttpServletRequest  servletRequest;
   private HttpServletResponse servletResponse;
   
   private PortalURL           url;
   private PortletConfig       portletConfig;
   private ServletContext      servletContext;
   private Cookie              cookies[];
   private String              renderHeaders = null; 
   private boolean             executingRequestBody = false;
   private Map<String, List<String>> queryParams = null;
   private String              phase = null;

   
   // make sure these classes are loaded first by the container classloader
   // so that the logs from these classes land in the Pluto log file.
   static {
      PortletURLProviderImpl.load();
      PortletURLImpl.load();
      RenderParametersImpl.load();
      ActionParametersImpl.load();
      ResourceParametersImpl.load();
      MutableRenderParametersImpl.load();
      MutableActionParametersImpl.load();
      MutableResourceParametersImpl.load();
   }

   protected PortletWindow             window;
   protected String                    windowId;
   protected PortletURLProvider        urlProvider;
   protected PortletParameterFactory   paramFactory;

   public PortletRequestContextImpl(PortletContainer container,
         HttpServletRequest containerRequest,
         HttpServletResponse containerResponse, PortletWindow window,
         boolean useRequestParameters) {
      this.container = container;
      this.containerRequest = containerRequest;
      this.containerResponse = containerResponse;
      this.window = window;
      this.windowId = window.getId().getStringId();
      this.url = PortalRequestContext.getContext(containerRequest).createPortalURL();
      this.urlProvider = new PortletURLProviderImpl(url, window, this);
      this.paramFactory = url.getPortletParameterFactory(this);
   }

   @Override
   public String getRenderHeaders() {
      return renderHeaders;
   }

   @Override
   public void setRenderHeaders(String renderHeaders) {
      this.renderHeaders = renderHeaders;
   }

   protected boolean isReservedAttributeName(String name) {
      return name.startsWith("javax.servlet.");
   }

   protected String encodeAttributeName(String name) {
      if (isReservedAttributeName(name)) {
         return name;
      }
      return container.getContainerServices().getNamespaceMapper()
            .encode(window.getId(), name);
   }

   protected String decodeAttributeName(String name) {
      if (isReservedAttributeName(name)) {
         return name;
      }
      String result = container.getContainerServices().getNamespaceMapper()
            .decode(window.getId(), name);
      return result != null ? result : name;
   }

   protected PortalURL getPortalURL() {
      return url;
   }

   public void init(PortletConfig portletConfig, ServletContext servletContext,
         HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
      this.portletConfig = portletConfig;
      this.servletContext = servletContext;
      this.servletRequest = servletRequest;
      this.servletResponse = servletResponse;
   }
   
   /**
    * Called when a request dispatcher or async dispatch begins 
    */
   @Override
   public void startDispatch(HttpServletRequest wrappedServletRequest, 
         Map<String, List<String>> queryParams, String phase) {
      this.dispatchedServletRequest = wrappedServletRequest;
      this.queryParams = queryParams;
      this.phase = phase;
      if (LOG.isTraceEnabled()) {
         StringBuilder txt = new StringBuilder();
         txt.append("Added query parameters.");
         txt.append(" Phase: ").append(phase);
         txt.append(", names: ").append(queryParams.keySet());
         LOG.debug(txt.toString());
      }
   }
   
   /**
    * Called when a request dispatcher or async dispatch ends 
    */
   @Override
   public void endDispatch() {
      this.dispatchedServletRequest = null;
      this.phase = null;
      this.queryParams = null;
      if (LOG.isTraceEnabled()) {
         LOG.debug("deleted query parameters.");
      }
   }
   
   /**
    * @return the asyncServletRequest
    */
   @Override
   public HttpServletRequest getAsyncServletRequest() {
      return asyncServletRequest;
   }

   /**
    * @param asyncServletRequest the asyncServletRequest to set
    */
   @Override
   public void setAsyncServletRequest(HttpServletRequest asyncServletRequest) {
      this.asyncServletRequest = asyncServletRequest;
   }

   /*
    * Gets the query string parameters set for request dispatch processing
    */
   @Override
   public Map<String, List<String>> getQueryParams(){
      return queryParams;
   }
   
   /*
    * Gets the processing phase set for request dispatch processing
    */
   @Override
   public String getPhase() {
      return phase;
   }
   
   /*
    * Use the wrapped request during dispatch
    */
   private HttpServletRequest getHttpReq() {
      return (dispatchedServletRequest != null) ? dispatchedServletRequest : servletRequest;
   }

   @Override
   public Object getAttribute(String name) {
      Object value = getHttpReq().getAttribute(encodeAttributeName(name));
      return value != null ? value : getHttpReq().getAttribute(name);
   }

   public Object getAttribute(String name, ServletRequest servletRequest) {
      return getHttpReq().getAttribute(name);
   }

   public Enumeration<String> getAttributeNames() {
      ArrayList<String> names = new ArrayList<String>();
      for (Enumeration<String> e = getHttpReq().getAttributeNames(); e
            .hasMoreElements();) {
         names.add(decodeAttributeName(e.nextElement()));
      }
      return Collections.enumeration(names);
   }

   public void setAttribute(String name, Object value) {
      if (value == null) {
         getHttpReq().removeAttribute(encodeAttributeName(name));
      } else {
         getHttpReq().setAttribute(encodeAttributeName(name), value);
      }
   }

   public PortletContainer getContainer() {
      return container;
   }

   public Cookie[] getCookies() {
      if (cookies == null) {
         cookies = servletRequest.getCookies();
         if (cookies == null) {
            cookies = new Cookie[0];
         }
      }
      return cookies.length > 0 ? cookies.clone() : null;
   }

   public PortletConfig getPortletConfig() {
      return portletConfig;
   }

   public ServletContext getServletContext() {
      return servletContext;
   }

   public PortletWindow getPortletWindow() {
      return window;
   }

   public Locale getPreferredLocale() {
      return servletRequest.getLocale();
   }

   public Map<String, String[]> getProperties() {
      HashMap<String, String[]> properties = new HashMap<String, String[]>();
      for (Enumeration<String> names = servletRequest.getHeaderNames(); names
            .hasMoreElements();) {
         String name = names.nextElement();
         ArrayList<String> values = new ArrayList<String>();
         for (Enumeration<String> headers = servletRequest.getHeaders(name); headers
               .hasMoreElements();) {
            values.add(headers.nextElement());
         }
         int size = values.size();
         if (size > 0) {
            properties.put(name, values.toArray(new String[size]));
         }
      }
      return properties;
   }

   @Override
   public Map<String, String[]> getParameterMap() {
      return paramFactory.getParameterMap(window.getId().getStringId());
   }

   @Override
   public Map<String, String[]> getPrivateParameterMap() {
      return paramFactory.getPrivateParameterMap(window.getId().getStringId());
   }

   public Map<String, String[]> getPublicParameterMap() {
      return paramFactory.getPublicParameterMap(window.getId().getStringId());
   }

   public HttpServletRequest getContainerRequest() {
      return containerRequest;
   }

   public HttpServletResponse getContainerResponse() {
      return containerResponse;
   }

   public HttpServletRequest getServletRequest() {
      return servletRequest;
   }

   public HttpServletResponse getServletResponse() {
      return servletResponse;
   }

   public RenderParameters getRenderParameters() {
      return new RenderParametersImpl(urlProvider, windowId);
   }

   public ActionParameters getActionParameters() {
      return new ActionParametersImpl(urlProvider, windowId);
   }

   /**
    * Make it look like request type while the portlet request body is executing.
    */
   @Override
   public DispatcherType getDispatcherType() {
      DispatcherType type = getServletRequest().getDispatcherType();
      if (isTrace) {
         StringBuilder txt = new StringBuilder();
         txt.append("Dispatcher type: ").append(type);
         txt.append(", executing request body: ").append(executingRequestBody);
         LOG.trace(txt.toString());
      }
      if (executingRequestBody && (type != DispatcherType.ASYNC)) {
         type = DispatcherType.REQUEST;
      }
      return type;
   }

   /**
    * @return the executingRequestBody
    */
   @Override
   public boolean isExecutingRequestBody() {
      return executingRequestBody;
   }

   /**
    * @param executingRequestBody the executingRequestBody to set
    */
   @Override
   public void setExecutingRequestBody(boolean executingRequestBody) {
      this.executingRequestBody = executingRequestBody;
   }

}
