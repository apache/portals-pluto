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
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

import javax.portlet.ActionParameters;
import javax.portlet.PortletConfig;
import javax.portlet.PortletSession;
import javax.portlet.RenderParameters;
import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.pluto.container.ContainerServices;
import org.apache.pluto.container.PortletContainer;
import org.apache.pluto.container.PortletEnvironmentService;
import org.apache.pluto.container.PortletRequestContext;
import org.apache.pluto.container.PortletResponseContext;
import org.apache.pluto.container.PortletURLProvider;
import org.apache.pluto.container.PortletWindow;
import org.apache.pluto.container.impl.ActionParametersImpl;
import org.apache.pluto.container.impl.MutableActionParametersImpl;
import org.apache.pluto.container.impl.MutableRenderParametersImpl;
import org.apache.pluto.container.impl.MutableResourceParametersImpl;
import org.apache.pluto.container.impl.PortletRequestImpl;
import org.apache.pluto.container.impl.PortletURLImpl;
import org.apache.pluto.container.impl.RenderParametersImpl;
import org.apache.pluto.container.impl.ResourceParametersImpl;
import org.apache.pluto.container.util.StringManager;
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
   private static final Logger       LOG                  = LoggerFactory.getLogger(PortletRequestContextImpl.class);
   private static final boolean      isTrace              = LOG.isTraceEnabled();
   private static final boolean      isDebug              = LOG.isDebugEnabled();
   
   private static final StringManager EXCEPTIONS =
       StringManager.getManager(PortletRequestImpl.class.getPackage().getName());


   private PortletContainer          container;

   // The original request and response arriving at the portal
   private HttpServletRequest        containerRequest;
   private HttpServletResponse       containerResponse;

   // Wrapped servlet request set for the duration of a request dispatcher or async dispatch
   private HttpServletRequest        dispatchedServletRequest;

   // original wrapped servlet request arriving at the portlet servlet during an
   // async dispatch
   private HttpServletRequest        asyncServletRequest;

   // Request and response objects arriving at the portlet servlet
   // (for the first time, in the case of an async dispatch)
   private HttpServletRequest        servletRequest;
   private HttpServletResponse       servletResponse;

   private final String              phase;

   private PortalURL                 url;
   private PortletConfig             portletConfig;
   private ServletContext            servletContext;
   private CachedPortletSession      cachedPortletSession;
   private Cookie                    cookies[];
   private String                    renderHeaders        = null;
   private boolean                   executingRequestBody = false;
   private Map<String, List<String>> queryParams          = null;

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

   protected final PortletWindow                         window;
   protected final String                                windowId;
   protected final PortletURLProvider                    urlProvider;
   protected final PortletParameterFactory               paramFactory;
   protected final ActionScopedRequestAttributeHandler   asraHandler;

   /**
    * Constructor
    * 
    * @param container
    *           the container instance
    * @param containerRequest
    *           the original HTTP request
    * @param containerResponse
    *           the original HTTP response
    * @param window
    *           the portlet window for this request
    * @param useRequestParameters
    *           not used ... probably an error. sort out later
    * @param phase
    *           the lifecycle phase being processed
    */
   public PortletRequestContextImpl(PortletContainer container, HttpServletRequest containerRequest,
         HttpServletResponse containerResponse, PortletWindow window, boolean useRequestParameters, String phase) {
      this.container = container;
      this.containerRequest = containerRequest;
      this.containerResponse = containerResponse;
      this.window = window;
      this.windowId = window.getId().getStringId();
      this.url = PortalRequestContext.getContext(containerRequest).createPortalURL();
      this.urlProvider = new PortletURLProviderImpl(url, window, this);
      this.paramFactory = url.getPortletParameterFactory(this);
      this.phase = phase;
      this.asraHandler = new ActionScopedRequestAttributeHandler(this, paramFactory, phase);
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
      return container.getContainerServices().getNamespaceMapper().encode(window.getId(), name);
   }

   protected String decodeAttributeName(String name) {
      if (isReservedAttributeName(name)) {
         return name;
      }
      String result = container.getContainerServices().getNamespaceMapper().decode(window.getId(), name);
      return result != null ? result : name;
   }

   protected PortalURL getPortalURL() {
      return url;
   }

   @Override
   public void init(PortletConfig portletConfig, ServletContext servletContext, HttpServletRequest servletRequest,
         HttpServletResponse servletResponse, PortletResponseContext responseContext) {
      this.portletConfig = portletConfig;
      this.servletContext = servletContext;
      this.servletRequest = servletRequest;
      this.servletResponse = servletResponse;
      asraHandler.init(responseContext);                       // initialize the actionScopedRequestAttribute handler
   }

   /**
    * Called when a request dispatcher or async dispatch begins
    */
   @Override
   public void startDispatch(HttpServletRequest wrappedServletRequest, Map<String, List<String>> queryParams,
         String phase) {
      this.dispatchedServletRequest = wrappedServletRequest;
      this.queryParams = queryParams;
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
    * @param asyncServletRequest
    *           the asyncServletRequest to set
    */
   @Override
   public void setAsyncServletRequest(HttpServletRequest asyncServletRequest) {
      this.asyncServletRequest = asyncServletRequest;
   }

   /*
    * Gets the query string parameters set for request dispatch processing
    */
   @Override
   public Map<String, List<String>> getQueryParams() {
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
      Object value = null;
      
      // if action scoped handling is active, try to get from the handler.
      if (asraHandler.isActive()) {
         value = asraHandler.getAttribute(name);
      }
      
      // try to get with encoded name
      if (value == null) {
         value = getHttpReq().getAttribute(encodeAttributeName(name));
      }

      // try to get with unencoded name
      if (value == null) {
         value = getHttpReq().getAttribute(name);
      }
      
      return value;
   }

   @Override
   public Enumeration<String> getAttributeNames() {
      ArrayList<String> names = new ArrayList<String>();
      
      // action scoped attributes
      if (asraHandler.isActive()) {
         names.addAll(asraHandler.getAttributeNames());
      }
      
      // the rest of the attributes
      for (Enumeration<String> e = getHttpReq().getAttributeNames(); e.hasMoreElements();) {
         names.add(decodeAttributeName(e.nextElement()));
      }
      
      return Collections.enumeration(names);
   }

   @Override
   public void setAttribute(String name, Object value) {
      if (value == null) {
         if (asraHandler.isActive()) {
            asraHandler.removeAttribute(name);
         }
         getHttpReq().removeAttribute(encodeAttributeName(name));
      } else {
         boolean handled = false;
         if (asraHandler.isSettable()) {
            handled = asraHandler.setAttribute(name, value);
         }
         if (!handled) {
            getHttpReq().setAttribute(encodeAttributeName(name), value);
         }
      }
   }

   @Override
   public PortletContainer getContainer() {
      return container;
   }

   @Override
   public Cookie[] getCookies() {
      if (cookies == null) {
         cookies = servletRequest.getCookies();
         if (cookies == null) {
            cookies = new Cookie[0];
         }
      }
      return cookies.length > 0 ? cookies.clone() : null;
   }

   @Override
   public PortletConfig getPortletConfig() {
      return portletConfig;
   }
   
   
   /**
    * Returns the portlet session.
    * <p>
    * Note that since portlet request instance is created everytime the portlet
    * container receives an incoming request, the portlet session instance held
    * by the request instance is also re-created for each incoming request.
    * </p>
    */
   @Override
   public PortletSession getPortletSession(boolean create) {
      if (isDebug) {
         LOG.debug("Retrieving portlet session (create=" + create + ")");
      }

      if ((cachedPortletSession == null) || cachedPortletSession.isInvalidated()) {

         //
         // It is critical that we don't retrieve the portlet session until the
         // cross context dispatch has been completed. If we do then we risk
         // having a cached version which is invalid for the context within
         // which it exists.
         //
      
         if (portletConfig == null) {
            throw new IllegalStateException(EXCEPTIONS.getString("error.session.illegalState"));
         }
      
         //
         // We must make sure that if the session has been invalidated (perhaps
         // through setMaxIntervalTimeout()) and the underlying request
         // returns null that we no longer use the cached version.
         // We have to check (ourselves) if the session has exceeded its max
         // inactive interval. If so, we should invalidate the underlying
         // HttpSession and recreate a new one (if the create flag is set to
         // true) -- We just cannot depend on the implementation of
         // javax.servlet.http.HttpSession!
         //
      
         HttpSession httpSession = getServletRequest().getSession(create);
         if (httpSession != null) {
            // HttpSession is not null does NOT mean that it is valid.
            int maxInactiveInterval = httpSession.getMaxInactiveInterval();
            long lastAccesstime = httpSession.getLastAccessedTime();// lastAccesstime checks added for PLUTO-436
            if (maxInactiveInterval >= 0 && lastAccesstime > 0) { // < 0 => Never expires.
               long maxInactiveTime = httpSession.getMaxInactiveInterval() * 1000L;
               long currentInactiveTime = System.currentTimeMillis() - lastAccesstime;
               if (currentInactiveTime > maxInactiveTime) {
                  if (isDebug) {
                     LOG.debug("The underlying HttpSession is expired and " + "should be invalidated.");
                  }
                  httpSession.invalidate();
                  httpSession = getServletRequest().getSession(create);
                  // Added for PLUTO-436
                  // a cached portletSession is no longer useable.
                  // a new one will be created below.
               }
            }
         }
      
         if (httpSession == null) {
            if (isDebug) {
               LOG.debug("The underlying HttpSession is not available: " + "no session will be returned.");
            }
            return null;
         }
      
         //
         // If we reach here, we are sure that the underlying HttpSession is
         // available. If we haven't created and cached a portlet session
         // instance, we will create and cache one now.
         //
      
         final ContainerServices containerServices = container.getContainerServices();
         final PortletEnvironmentService portletEnvironmentService = containerServices.getPortletEnvironmentService();

         cachedPortletSession = new CachedPortletSessionImpl(portletEnvironmentService.createPortletSession(
             portletConfig.getPortletContext(), getPortletWindow(), httpSession));

         if (CachedPortletSessionUtil.INVALIDATED_SESSIONS.containsKey(httpSession.getId())) {

            synchronized (httpSession) {
               Enumeration<String> attributeNames = httpSession.getAttributeNames();
               if (attributeNames.hasMoreElements()) {
                  while (attributeNames.hasMoreElements()) {
                     String attributeName = attributeNames.nextElement();
                     httpSession.removeAttribute(attributeName);
                  }
                  CachedPortletSessionUtil.INVALIDATED_SESSIONS.remove(httpSession.getId());
               }
            }
         }
      }

      return cachedPortletSession;
   }

   @Override
   public ServletContext getServletContext() {
      return servletContext;
   }

   @Override
   public PortletWindow getPortletWindow() {
      return window;
   }

   @Override
   public Locale getPreferredLocale() {
      return servletRequest.getLocale();
   }

   @Override
   public Map<String, String[]> getProperties() {
      HashMap<String, String[]> properties = new HashMap<String, String[]>();
      for (Enumeration<String> names = servletRequest.getHeaderNames(); names.hasMoreElements();) {
         String name = names.nextElement();
         ArrayList<String> values = new ArrayList<String>();
         for (Enumeration<String> headers = servletRequest.getHeaders(name); headers.hasMoreElements();) {
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

   @Override
   public Map<String, String[]> getPublicParameterMap() {
      return paramFactory.getPublicParameterMap(window.getId().getStringId());
   }

   @Override
   public HttpServletRequest getContainerRequest() {
      return containerRequest;
   }

   @Override
   public HttpServletResponse getContainerResponse() {
      return containerResponse;
   }

   @Override
   public HttpServletRequest getServletRequest() {
      return servletRequest;
   }

   @Override
   public HttpServletResponse getServletResponse() {
      return servletResponse;
   }

   @Override
   public RenderParameters getRenderParameters() {
      return new RenderParametersImpl(urlProvider, windowId);
   }

   @Override
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
    * @param executingRequestBody
    *           the executingRequestBody to set
    */
   @Override
   public void setExecutingRequestBody(boolean executingRequestBody) {
      this.executingRequestBody = executingRequestBody;
   }

}
