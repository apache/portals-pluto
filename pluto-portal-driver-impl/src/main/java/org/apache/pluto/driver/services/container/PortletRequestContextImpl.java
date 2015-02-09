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
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.pluto.container.PortletContainer;
import org.apache.pluto.container.PortletRequestContext;
import org.apache.pluto.container.PortletWindow;
import org.apache.pluto.driver.core.PortalRequestContext;
import org.apache.pluto.driver.url.PortalURL;
import org.apache.pluto.driver.url.PortletParameterFactory;

/**
 * @version $Id$
 *
 */
public class PortletRequestContextImpl implements PortletRequestContext {

   private PortletContainer    container;
   private HttpServletRequest  containerRequest;
   private HttpServletResponse containerResponse;
   private HttpServletRequest  servletRequest;
   private HttpServletResponse servletResponse;
   private PortalURL           url;
   private PortletConfig       portletConfig;
   private ServletContext      servletContext;
   private Cookie              cookies[];

   protected PortletWindow       window;
   protected PortletParameterFactory paramFactory;

   public PortletRequestContextImpl(PortletContainer container,
         HttpServletRequest containerRequest,
         HttpServletResponse containerResponse, PortletWindow window,
         boolean useRequestParameters) {
      this.container = container;
      this.containerRequest = containerRequest;
      this.containerResponse = containerResponse;
      this.window = window;
      this.url = PortalRequestContext.getContext(containerRequest)
            .createPortalURL();
      this.paramFactory = url.getPortletParameterFactory();
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

   public Object getAttribute(String name) {
      Object value = servletRequest.getAttribute(encodeAttributeName(name));
      return value != null ? value : servletRequest.getAttribute(name);
   }

   public Object getAttribute(String name, ServletRequest servletRequest) {
      return servletRequest.getAttribute(name);
   }

   public Enumeration<String> getAttributeNames() {
      ArrayList<String> names = new ArrayList<String>();
      for (Enumeration<String> e = servletRequest.getAttributeNames(); e
            .hasMoreElements();) {
         names.add(decodeAttributeName(e.nextElement()));
      }
      return Collections.enumeration(names);
   }

   public void setAttribute(String name, Object value) {
      if (value == null) {
         servletRequest.removeAttribute(encodeAttributeName(name));
      } else {
         servletRequest.setAttribute(encodeAttributeName(name), value);
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

   public Map<String, String[]> getPrivateParameterMap() {
      return paramFactory.getPrivateParameterMap(window.getId().getStringId());
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
}
