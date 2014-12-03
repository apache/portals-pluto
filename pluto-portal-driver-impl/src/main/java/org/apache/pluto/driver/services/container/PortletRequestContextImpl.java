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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static java.util.logging.Level.*;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.portlet.PortletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.pluto.container.PortletContainer;
import org.apache.pluto.container.PortletRequestContext;
import org.apache.pluto.container.PortletWindow;
import org.apache.pluto.driver.core.PortalRequestContext;
import org.apache.pluto.driver.url.PortalURL;
import org.apache.pluto.driver.url.PortalURLParameter;

/**
 * @version $Id$
 *
 */
public class PortletRequestContextImpl implements PortletRequestContext {
   private static final String LOG_CLASS = PortletRequestContextImpl.class
                                               .getName();
   private final Logger        LOGGER    = Logger.getLogger(LOG_CLASS);

   private PortletContainer    container;
   private HttpServletRequest  containerRequest;
   private HttpServletResponse containerResponse;
   private HttpServletRequest  servletRequest;
   private HttpServletResponse servletResponse;
   private PortletWindow       window;
   private PortalURL           url;
   private PortletConfig       portletConfig;
   private ServletContext      servletContext;
   private Cookie              cookies[];
   private boolean             useRequestParameters;

   public PortletRequestContextImpl(PortletContainer container,
         HttpServletRequest containerRequest,
         HttpServletResponse containerResponse, PortletWindow window,
         boolean useRequestParameters) {
      this.container = container;
      this.containerRequest = containerRequest;
      this.containerResponse = containerResponse;
      this.window = window;
      this.useRequestParameters = useRequestParameters;
      this.url = PortalRequestContext.getContext(containerRequest)
            .createPortalURL();
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

   protected Map<String, String[]> getPrivateRenderParameterMap() {
      return Collections.emptyMap();
   }

   protected PortalURL getPortalURL() {
      return url;
   }

   protected boolean isPublicRenderParameter(String name) {
      List<String> publicRenderParameterNames = window.getPortletDefinition()
            .getSupportedPublicRenderParameters();
      return publicRenderParameterNames.isEmpty() ? false
            : publicRenderParameterNames.contains(name);
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

   @SuppressWarnings("unchecked")
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

   @SuppressWarnings("unchecked")
   public Map<String, String[]> getPrivateParameterMap() {
      HashMap<String, String[]> parameters = new HashMap<String, String[]>();
      if (useRequestParameters) {
         parameters.putAll(servletRequest.getParameterMap());
         parameters.putAll(decodeMultipartForm());
      }
      for (Map.Entry<String, String[]> entry : getPrivateRenderParameterMap()
            .entrySet()) {
         String[] values = parameters.get(entry.getKey());
         if (values == null) {
            parameters.put(entry.getKey(), entry.getValue());
         } else {
            String[] copy = new String[values.length + entry.getValue().length];
            System.arraycopy(values, 0, copy, 0, values.length);
            System.arraycopy(entry.getValue(), 0, copy, values.length,
                  entry.getValue().length);
            parameters.put(entry.getKey(), copy);
         }
      }
      String windowId = window.getId().getStringId();
      for (PortalURLParameter parm : url.getParameters()) {
         if (windowId.equals(parm.getWindowId())) {
            String[] values = parameters.get(parm.getName());
            if (values == null) {
               parameters.put(parm.getName(), parm.getValues());
            } else {
               String[] copy = new String[values.length
                     + parm.getValues().length];
               System.arraycopy(values, 0, copy, 0, values.length);
               System.arraycopy(parm.getValues(), 0, copy, values.length,
                     parm.getValues().length);
               parameters.put(parm.getName(), copy);
            }
         }
      }
      if (LOGGER.isLoggable(Level.FINE)) {
         StringBuffer sb = new StringBuffer();
         sb.append("Dump private Parameter Map:");
         for (String k : parameters.keySet()) {
            sb.append("\nName: " + k + ", Values: ");
            String sep = "";
            for (String v : parameters.get(k)) {
               sb.append(sep + v);
               sep = ", ";
            }
         }
         LOGGER.fine(sb.toString());
      }
      return parameters;
   }

   /**
    * Looks for multipart form data on an action or serveResource request, and decodes
    * it into a parameter map if found. (doesn't handle file upload or anything like that) 
    * 
    * NOTE!! : At the current time, this method really only outputs debug info, as it
    * seems that the servlet container automatically interprets multipart form data
    * in the same manner that it interprets URL encoded form data.
    * 
    * @return A Map containing parameter values extracted from a multipart form
    */
   private Map<String, String[]> decodeMultipartForm() {
      Map<String, String[]> parms = new HashMap<String, String[]>();
      Map<String, String[]> servletMap = servletRequest.getParameterMap();
      String ct = servletRequest.getContentType();

      if (LOGGER.isLoggable(Level.FINE)) {
         LOGGER.fine("Looking for multipart form data. Content Type = " + ct);
      }

      if ((ct != null) && ct.contains("multipart/form-data")) {
         try {
            Collection<Part> parts = servletRequest.getParts();

            if (LOGGER.isLoggable(Level.FINE)) {
               LOGGER.fine("There are " + parts.size() + " parts to process.");
            }
            
            StringBuilder sb = new StringBuilder();
            for (Part p : parts) {
               if (LOGGER.isLoggable(Level.FINE)) {
                  sb.append("\nPart name: " + p.getName());
                  sb.append(", size: " + p.getSize());
                  sb.append(", type: " + p.getContentType());
                  sb.append(", in servletMap=" + servletMap.containsKey(p.getName()));
                  Collection<String> hn = p.getHeaderNames();
                  if (hn != null) {
                     for (String h : hn) {
                        sb.append(", hdr==" + h + "==");
                     }
                  } else {
                     sb.append(", hdrNames=" + hn);
                  }
                  sb.append(", cdHdr==" + p.getHeader("content-disposition") + "==");
               }
            }
            if (LOGGER.isLoggable(Level.FINE)) {
               LOGGER.fine(sb.toString());
            }

         } catch (Exception e) {
            LOGGER.logp(FINE, LOG_CLASS, "decodeMultipartForm",
                  "Error reading form data", e);
         }
      }

      return parms;
   }

   @SuppressWarnings("unchecked")
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
      HashMap<String, String[]> parameters = new HashMap<String, String[]>();
      for (Map.Entry<String, String[]> entry : url.getPublicParameters()
            .entrySet()) {
         if (isPublicRenderParameter(entry.getKey())) {
            parameters.put(entry.getKey(), entry.getValue());
         }
      }
      return parameters;
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
