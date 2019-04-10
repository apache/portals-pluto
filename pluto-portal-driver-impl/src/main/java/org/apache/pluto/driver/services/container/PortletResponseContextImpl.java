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

import static javax.portlet.PortletRequest.ACTION_SCOPE_ID;
import static javax.portlet.PortletRequest.HEADER_PHASE;
import static javax.portlet.PortletRequest.RENDER_PHASE;
import static javax.portlet.PortletRequest.RESOURCE_PHASE;
import static org.apache.pluto.driver.url.PortalURLParameter.PARAM_TYPE_RENDER;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.portlet.MimeResponse;
import javax.portlet.PortletConfig;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.pluto.container.HeaderData;
import org.apache.pluto.container.PortletContainer;
import org.apache.pluto.container.PortletRequestContext;
import org.apache.pluto.container.PortletResponseContext;
import org.apache.pluto.container.PortletStateAwareResponseContext;
import org.apache.pluto.container.PortletURLProvider;
import org.apache.pluto.container.PortletURLProvider.TYPE;
import org.apache.pluto.container.PortletWindow;
import org.apache.pluto.container.ResourceURLProvider;
import org.apache.pluto.driver.core.PortalRequestContext;
import org.apache.pluto.driver.url.PortalURL;
import org.apache.pluto.driver.url.PortalURLParameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;

/**
 * @version $Id$
 * 
 */
public abstract class PortletResponseContextImpl implements PortletResponseContext {

   /** Logger. */
   private static final Logger      LOG               = LoggerFactory.getLogger(PortletResponseContextImpl.class);

   private PortletContainer         container;
   private HttpServletRequest       containerRequest;
   private HttpServletResponse      containerResponse;
   private PortletConfig            portletConfig;
   private HttpServletRequest       servletRequest;
   private HttpServletResponse      servletResponse;
   private PortletWindow            window;
   private PortalURL                portalURL;
   private boolean                  closed;
   private boolean                  released;

   // needed for processing of properties based on request type
   private String                   lifecycle;
   private boolean                  isSetPropsAllowed = false;

   private static final Set<String> disallowedHeaders = new HashSet<String>(Arrays.asList(new String[] {
         "ACCEPT-PATCH", "ACCEPT-RANGES", "AGE", "ALLOW", "CACHE-CONTROL", "CONNECTION", "CONTENT-DISPOSITION",
         "CONTENT-ENCODING", "CONTENT-LANGUAGE", "CONTENT-LENGTH", "CONTENT-LOCATION", "CONTENT-MD5", "CONTENT-RANGE",
         "CONTENT-TYPE", "DATE", "ETAG", "EXPIRES", "LAST-MODIFIED", "LINK", "LOCATION", "P3P", "PRAGMA",
         "PROXY-AUTHENTICATE", "PUBLIC-KEY-PINS", "REFRESH", "RETRY-AFTER", "SERVER", "SET-COOKIE", "STATUS",
         "STRICT-TRANSPORT-SECURITY", "TRAILER", "TRANSFER-ENCODING", "UPGRADE", "VARY", "VIA", "WWW-AUTHENTICATE",
         "X-FRAME-OPTIONS"                           }));

   private final static String VALID_HEADER_CHARS = "^[a-zA-Z0-9!#$%&'*+-.^_`|~]+$";
   
   // holder for the header data
   protected final HeaderData headerData = new HeaderData();
   
   private final PortletRequestContext requestContext;

   public PortletResponseContextImpl(PortletContainer container, HttpServletRequest containerRequest,
         HttpServletResponse containerResponse, PortletWindow window, PortletRequestContext requestContext) {
      this.container = container;
      this.containerRequest = containerRequest;
      this.containerResponse = containerResponse;
      this.window = window;
      this.portalURL = PortalRequestContext.getContext(containerRequest).createPortalURL();
      this.requestContext = requestContext;
   }

   /**
    * @return the requestContext
    */
   public PortletRequestContext getRequestContext() {
      return requestContext;
   }

   @Override
   public PortletConfig getPortletConfig() {
      return portletConfig;
   }

   public String getLifecycle() {
      return lifecycle;
   }

   public void setLifecycle(String lifecycle) {
      this.lifecycle = lifecycle;
   }

   public boolean isSetPropsAllowed() {
      return isSetPropsAllowed;
   }

   public void setPropsAllowed(boolean isSetPropsAllowed) {
      this.isSetPropsAllowed = isSetPropsAllowed;
   }
   
   /**
    * Returns <code>true</code> if markup written to the portlet output stream should 
    * land in the document head section.
    *  
    * @return  <code>true</code> if the header buffer is active
    */
   public boolean isHeaderBufferActive() {
      return isSetPropsAllowed && !lifecycle.equals(RESOURCE_PHASE);
   }


   /**
    * returns the header data provided by the portlet during header phase execution.
    */
   @Override
   public HeaderData getHeaderData() {
      return headerData;
   }

   protected PortalURL getPortalURL() {
      return portalURL;
   }

   protected boolean isClosed() {
      return closed;
   }

   protected boolean isReleased() {
      return released;
   }

   public void init(PortletConfig portletConfig, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
      this.portletConfig = portletConfig;
      this.servletRequest = servletRequest;
      this.servletResponse = servletResponse;
   }

   public void addProperty(Cookie cookie) {
      if (!isClosed() && isSetPropsAllowed) {
         if (lifecycle.matches(RESOURCE_PHASE)) {
            // apply headers directly to response
            containerResponse.addCookie(cookie);
         } else {
            headerData.addCookie(cookie);
         }
      }
   }

   /**
    * saves elements for adding to the head section markup if header request or render request
    */
   public void addProperty(String key, Element element) {
      if (!key.equals(MimeResponse.MARKUP_HEAD_ELEMENT)) {
         StringBuilder txt = new StringBuilder(128);
         txt.append("Ignoring attempt to add document head element with key: ").append(key);
         txt.append(" rather than the required: ").append(MimeResponse.MARKUP_HEAD_ELEMENT);
         LOG.warn(txt.toString());
      } else {
         if (!isClosed() && isSetPropsAllowed && element != null) {
            if (lifecycle.equals(RENDER_PHASE) || lifecycle.equals(HEADER_PHASE)) {
               headerData.addHeaderTag(element);
            }
         }
      }
   }

   public void addProperty(String key, String value) {
      if (value == null) {
         StringBuilder txt = new StringBuilder(128);
         txt.append("Ignoring attempt to add property with null value. Key: ").append(key);
         LOG.warn(txt.toString());
      } else if (!key.matches(VALID_HEADER_CHARS)) {
         StringBuilder txt = new StringBuilder(128);
         txt.append("Ignoring attempt to add key containing disallowed characters. Key: ").append(key);
         txt.append(", value: ").append(value);
        LOG.warn(txt.toString());
      } else {
         // header names are case insensitive. allow setting all headers 
         // during the resource phase.
         if (!lifecycle.matches(RESOURCE_PHASE) && disallowedHeaders.contains(key.toUpperCase())) {
            StringBuilder txt = new StringBuilder(128);
            txt.append("Ignoring disallowed HTTP header: ").append(key);
            txt.append(" with value: ").append(value);
            LOG.warn(txt.toString());
         } else {
            if (!isClosed() && isSetPropsAllowed) {
               if (lifecycle.matches(RESOURCE_PHASE)) {
                  // apply headers directly to response
                  containerResponse.addHeader(key, value);
               } else {
                  headerData.addHttpHeader(key, value);
               }
            }
         }
      }
   }

   public void setProperty(String key, String value) {
      if (value == null) {
         StringBuilder txt = new StringBuilder(128);
         txt.append("Ignoring attempt to add property with null value. Key: ").append(key);
         LOG.warn(txt.toString());
      } else if (!key.matches(VALID_HEADER_CHARS)) {
         StringBuilder txt = new StringBuilder(128);
         txt.append("Ignoring attempt to add key containing disallowed characters. Key: ").append(key);
         txt.append(", value: ").append(value);
         LOG.warn(txt.toString());
      } else {
         // header names are case insensitive. allow setting all headers 
         // during the resource phase.
         if (!lifecycle.matches(RESOURCE_PHASE) && disallowedHeaders.contains(key.toUpperCase())) {
            StringBuilder txt = new StringBuilder(128);
            txt.append("Ignoring disallowed HTTP header: ").append(key);
            txt.append(" with value: ").append(value);
            LOG.warn(txt.toString());
         } else {
            if (!isClosed() && isSetPropsAllowed) {
               if (lifecycle.matches(RESOURCE_PHASE)) {
                  // apply headers directly to response
                  containerResponse.addHeader(key, value);
               } else {
                  headerData.setHttpHeader(key, value);
               }
            }
         }
      }
   }

   public Element createElement(String tagName) throws DOMException {
      return headerData.createElement(tagName);
   }

   @Override
   public String getProperty(String key) {
      String val = null;
      if (!isClosed() && isSetPropsAllowed) {
         List<String> vals = headerData.getHttpHeaders().get(key);
         if (!vals.isEmpty()) {
            val = vals.get(0);
         }
      }
      return val;
   }

   @Override
   public Collection<String> getPropertyValues(String key) {
      List<String> vals = new ArrayList<String>();
      if (!isClosed() && isSetPropsAllowed) {
         vals.addAll(headerData.getHttpHeaders().get(key));
      }
      return vals;
   }

   @Override
   public Collection<String> getPropertyNames() {
      List<String> names = new ArrayList<String>();
      if (!isClosed() && isSetPropsAllowed) {
         names.addAll(headerData.getHttpHeaders().keySet());
      }
      return names;
   }
   
   /**
    * to be called after request has been successfully processed and before 
    * response has been committed.
    */
   @Override
   public void processHttpHeaders() {
      
      // add the cookies to the response
      for (Cookie c : headerData.getCookies()) {
         containerResponse.addCookie(c);
      }

      // Add the HTTP headers to the response
      Map<String, List<String>> headers = headerData.getHttpHeaders();
      for (String name : headers.keySet()) {
         for (String val : headers.get(name)) {
            containerResponse.addHeader(name, val);
         }
      }

   }

   public void close() {
      closed = true;
   }

   public PortletContainer getContainer() {
      return container;
   }

   public PortletWindow getPortletWindow() {
      return window;
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

   public void release() {
      closed = true;
      released = true;
      container = null;
      servletRequest = null;
      servletResponse = null;
      window = null;
   }

   public ResourceURLProvider getResourceURLProvider() {
      return isReleased() ? null : new ResourceURLProviderImpl(servletRequest, window);
   }

   public PortletURLProvider getPortletURLProvider(TYPE type) {
      return isClosed() ? null : 
         new PortletURLProviderImpl(getPortalURL(), type, getPortletWindow(), getRequestContext());
   }
   
   /**
    * Used when action scoped request attribute processing is active in order
    * to set the scope ID render parameter on the response and generated URLs
    * 
    * @param values     The values array to set. If null, the parameter is removed.
    */
   @Override
   public void setActionScopedId(String windowId, String[] values) {
      if (this instanceof PortletStateAwareResponseContext) {
         ((PortletStateAwareResponseContext)this).getRenderParameters(windowId).setValues(ACTION_SCOPE_ID, values);
      }
      else {
         PortalURLParameter pup = new PortalURLParameter(windowId, ACTION_SCOPE_ID, values, PARAM_TYPE_RENDER);
         if (values == null) {
            this.getPortalURL().removeParameter(pup);
         } else {
            pup.setPersistent(true);
            this.getPortalURL().setParameter(pup);
         }
      }
   }
}
