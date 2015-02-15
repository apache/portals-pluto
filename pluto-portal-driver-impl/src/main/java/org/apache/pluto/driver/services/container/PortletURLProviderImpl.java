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
import java.io.Writer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.portlet.PortletMode;
import javax.portlet.PortletSecurityException;
import javax.portlet.ResourceURL;
import javax.portlet.WindowState;

import org.apache.pluto.container.PortletURLProvider;
import org.apache.pluto.container.PortletWindow;
import org.apache.pluto.driver.services.portal.PublicRenderParameterMapper;
import org.apache.pluto.driver.url.PortalURL;
import org.apache.pluto.driver.url.PortalURL.URLType;
import org.apache.pluto.driver.url.PortalURLParameter;
import org.apache.pluto.driver.url.PortalURLPublicParameter;
import org.apache.pluto.driver.url.PortletParameterFactory;

/**
 *
 */
public class PortletURLProviderImpl implements PortletURLProvider {
   private static final Logger   LOGGER     = LoggerFactory.getLogger(PortletURLProviderImpl.class);
   private static final boolean  isDebug    = LOGGER.isDebugEnabled();
   private static final boolean  isTrace    = LOGGER.isTraceEnabled();

   private final PortalURL                     url;
   private final PortletParameterFactory     paramFactory;

   private final TYPE                          type;
   private final String                        window;
   private Map<String, List<String>>           properties;

   // Hack: called to force class loading in Container thread
   protected static final void load() {
      if (isDebug) {
         LOGGER.debug("Loaded.");
      }
   };
   
   public PortletURLProviderImpl(PortalURL url, TYPE type,
         PortletWindow portletWindow) {
      this.url = url.clone();
      this.type = type;
      this.window = portletWindow.getId().getStringId();
      this.paramFactory = url.getPortletParameterFactory();

      if (isDebug) {
         StringBuilder txt = new StringBuilder("Constructing PortalURLProviderImpl. ");
         txt.append("type=").append(type);
         txt.append(", URL type=").append(url.getType());
         txt.append(", target=").append(window);
         txt.append(", URL target=").append(url.getTargetWindow());
         LOGGER.debug(txt.toString());
      }

      if (isDebug) {
         StringBuilder txt = new StringBuilder("Before clearing parameters for window: ");
         txt.append(window);
         for (PortalURLParameter p : this.url.getParameters()) {
            if (p.getWindowId().equals(window)) {
               txt.append("\nName: ").append(p.getName());
               txt.append(", Type: ").append(p.getType());
               txt.append(", Values: ").append(Arrays.toString(p.getValues()));
            }
         }
         txt.append("\nActive Public Render Parameters:");
         PublicRenderParameterMapper mapper = this.url.getPublicRenderParameterMapper();
         List<PortalURLPublicParameter> pups = mapper.getPRPsForWindow(window, false);
         for (PortalURLPublicParameter p : pups) {
            txt.append("\nName: ").append(p.getName());
            txt.append(", Type: ").append(p.getType());
            txt.append(", isRemoved: ").append(p.isRemoved());
            txt.append(", Values: ").append(Arrays.toString(p.getValues()));
         }
         LOGGER.debug(txt.toString());
      }

      this.url.setTargetWindow(window);
      switch (type) {
      case ACTION:
         this.url.setType(URLType.Action);
         break;
      case RESOURCE:
         this.url.setType(URLType.Resource);
         this.url.clearResourceParameters(window);
         this.url.setCacheability(ResourceURL.PAGE);
         break;
      default:
         this.url.setType(URLType.Render);
         this.url.clearParameters(window);
      }

      if (isTrace) {
         StringBuilder txt = new StringBuilder("Constructed PortalURLProviderImpl, set type. ");
         txt.append("new URL type=").append(this.url.getType());
         LOGGER.debug(txt.toString());
      }

   }

   public PortalURL apply() {

      if (isDebug) {
         StringBuilder txt = new StringBuilder("apply URL values: ");
         txt.append("type=").append(type);
         txt.append(", URL type=").append(url.getType());
         txt.append(", target=").append(url.getTargetWindow());
         LOGGER.debug(txt.toString());
      }
      
      if (isDebug) {
         StringBuilder txt = new StringBuilder("URL Parameters for window: ");
         txt.append(window);
         for (PortalURLParameter p : url.getParameters()) {
            if (p.getWindowId().equals(window)) {
               txt.append("\nName: ").append(p.getName());
               txt.append(", Type: ").append(p.getType());
               txt.append(", Values: ").append(Arrays.toString(p.getValues()));
            }
         }
         txt.append("\nActive Public Render Parameters:");
         PublicRenderParameterMapper mapper = this.url.getPublicRenderParameterMapper();
         List<PortalURLPublicParameter> pups = mapper.getPRPsForWindow(window, false);
         for (PortalURLPublicParameter p : pups) {
            txt.append("\nName: ").append(p.getName());
            txt.append(", Type: ").append(p.getType());
            txt.append(", isRemoved: ").append(p.isRemoved());
            txt.append(", Values: ").append(Arrays.toString(p.getValues()));
         }
         LOGGER.debug(txt.toString());
      }
      return url;
   }

   public TYPE getType() {
      return type;
   }

   public void setPortletMode(PortletMode mode) {
      url.setPortletMode(window, mode);
   }

   public PortletMode getPortletMode() {
      return url.getPortletMode(window);
   }

   public void setWindowState(WindowState state) {
      url.setWindowState(window, state);
   }

   public WindowState getWindowState() {
      return url.getWindowState(window);
   }

   public void setSecure(boolean secure) throws PortletSecurityException {
      // ignore: not supported
   }

   public boolean isSecure() {
      return false;
   }

   public String getCacheability() {
      return url.getCacheability();
   }

   public void setCacheability(String cacheLevel) {
      url.setCacheability(cacheLevel);
   }

   public String getResourceID() {
      return url.getResourceID();
   }

   public void setResourceID(String resourceID) {
      url.setCacheability(resourceID);
   }

   public String toURL() {
      return toURL(false);
   }

   public String toURL(boolean absolute) {
      return apply().toURL(absolute);
   }

   public void write(Writer out, boolean escapeXML) throws IOException {
      String result = apply().toURL(false);
      if (escapeXML) {
         result = result.replaceAll("&", "&amp;");
         result = result.replaceAll("<", "&lt;");
         result = result.replaceAll(">", "&gt;");
         result = result.replaceAll("\'", "&#039;");
         result = result.replaceAll("\"", "&#034;");
      }
      out.write(result);
   }

   public Map<String, List<String>> getProperties() {
      if (properties == null) {
         properties = new HashMap<String, List<String>>();
      }
      return properties;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.PortletURLProvider#addPublicRenderParameter(java.lang.String, java.lang.String, java.lang.String[])
    */
   public void addPublicRenderParameter(String windowId, String name, String[] values) {
      paramFactory.addPublicRenderParameter(windowId, name, values);
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.PortletURLProvider#removePublicRenderParameter(java.lang.String, java.lang.String)
    */
   public void removePublicRenderParameter(String windowId, String name) {
      paramFactory.removePublicRenderParameter(windowId, name);
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.PortletURLProvider#isPublicRenderParameter(java.lang.String, java.lang.String)
    */
   public boolean isPublicRenderParameter(String windowId, String name) {
      return paramFactory.isPublicRenderParameter(windowId, name);
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.PortletURLProvider#getPrivateParameterNames(java.lang.String)
    */
   public Set<String> getPrivateParameterNames(String windowId) {
      return paramFactory.getPrivateParameterNames(windowId);
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.PortletURLProvider#getParameterValues(java.lang.String, java.lang.String)
    */
   public String[] getParameterValues(String windowId, String name) {
      return paramFactory.getParameterValues(windowId, name);
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.PortletURLProvider#setParameter(java.lang.String, java.lang.String, java.lang.String[])
    */
   public void setParameter(String windowId, String name, String[] values) {
      paramFactory.setParameter(windowId, name, values);
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.PortletURLProvider#removeParameter(java.lang.String, java.lang.String)
    */
   public void removeParameter(String windowId, String name) {
      paramFactory.removeParameter(windowId, name);
   }

}
