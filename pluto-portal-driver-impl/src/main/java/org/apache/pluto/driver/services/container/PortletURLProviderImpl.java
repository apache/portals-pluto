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
import java.util.HashSet;
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

/**
 *
 */
public class PortletURLProviderImpl implements PortletURLProvider {
   private static final Logger   LOGGER     = LoggerFactory.getLogger(PortletURLProviderImpl.class);
   private static final boolean  isDebug    = LOGGER.isDebugEnabled();
   private static final boolean  isTrace    = LOGGER.isTraceEnabled();
   
   private final static HashMap<PortalURL.URLType, String> urlTypeMap  = 
         new HashMap<PortalURL.URLType, String>();
   static {
      urlTypeMap.put(URLType.Action, PortalURLParameter.PARAM_TYPE_ACTION);
      urlTypeMap.put(URLType.Render, PortalURLParameter.PARAM_TYPE_RENDER);
      urlTypeMap.put(URLType.Resource, PortalURLParameter.PARAM_TYPE_RESOURCE);
   }

   private final PortalURL                     url;

   private final TYPE                          type;
   private final String                        window;
   private Map<String, List<String>>           properties;

   private final Set<PortalURLPublicParameter> prpSet     = new HashSet<PortalURLPublicParameter>();

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

   public void addPublicRenderParameter(String windowId, String name, String[] values) {
      PublicRenderParameterMapper prpMapper = url.getPublicRenderParameterMapper();
      if (isDebug) {
         StringBuilder txt = new StringBuilder("Add PRP. Window: ");
         txt.append(windowId).append(", name: ").append(name)
               .append(", values = ").append(Arrays.toString(values));
         LOGGER.debug(txt.toString());
      }
      int index = prpMapper.getIndex(windowId, name);
      if (index >= 0) {
         prpMapper.setValues(index, values);
      } else {
         StringBuilder txt = new StringBuilder(
               "Public render parameter for window: ");
         txt.append(windowId).append(", name: ").append(name)
               .append(" not found in mapper");
         LOGGER.warn(txt.toString());
      }
   }

   public void removePublicRenderParameter(String windowId, String name) {
      PublicRenderParameterMapper prpMapper = url.getPublicRenderParameterMapper();
      if (isDebug) {
         StringBuilder txt = new StringBuilder("Remove PRP. Window: ");
         txt.append(windowId).append(", name: ").append(name);
         LOGGER.debug(txt.toString());
      }
      int index = prpMapper.getIndex(windowId, name);
      if (index >= 0) {
         prpMapper.setRemoved(index, true);
      } else {
         StringBuilder txt = new StringBuilder("Public render parameter for window: ");
         txt.append(windowId).append(", name: ").append(name)
            .append(" not found in mapper");
         LOGGER.warn(txt.toString());
      }
   }

   public boolean isPublicRenderParameter(String windowId, String name) {
      PublicRenderParameterMapper prpMapper = url.getPublicRenderParameterMapper();
      if (isDebug) {
         StringBuilder txt = new StringBuilder(
               "isPublicRenderParameter Window: ");
         txt.append(windowId).append(", name: ").append(name);
         LOGGER.debug(txt.toString());
      }
      int index = prpMapper.getIndex(windowId, name);
      return (index >= 0);
   }

   /**
    * Clear public render parameters except those marked for removal
    */
   public void clearPublicRenderParameters() {
      for (PortalURLPublicParameter prp : prpSet) {
         if (!prp.isRemoved()) {
            prpSet.remove(prp);
         }
      }
   }

   // This method is for V2 compatibility. It always returns the private 
   // parameter names for the active URL type - Render parameters for a render URL,
   // Action parameters for an action URL, and resouce parameters for a Resource URL.
   public Set<String> getPrivateParameterNames(String windowId) {
      HashSet<String> names = new HashSet<String>();
      String type = urlTypeMap.get(url.getType());
      
      for (PortalURLParameter p : url.getParameters()) {
         if (p.getWindowId().equals(windowId) && p.getType().equals(type)) {
            names.add(p.getName());
         }
      }

      if (isDebug) {
         StringBuilder txt = new StringBuilder();
         txt.append("Window ID: ").append(windowId);
         txt.append(", URL / Parameter type: ").append(type);
         txt.append(", names: ").append(names.toString());
         LOGGER.debug(txt.toString());
      }

      return names;
   }

   // This method is for V2 compatibility. It always returns the private 
   // parameter values for the active URL type - Render parameters for a render URL,
   // Action parameters for an action URL, and resouce parameters for a Resource URL.
   public String[] getParameterValues(String windowId, String name) {
      PublicRenderParameterMapper prpMapper = url.getPublicRenderParameterMapper();
      String type = urlTypeMap.get(url.getType());
      String[] vals = null;
      
      if (isDebug) {
         StringBuilder txt = new StringBuilder("Setting ");
         txt.append("name: ").append(name);
         txt.append(", URL / Parameter type: ").append(type);
         txt.append(", window ID: ").append(windowId);
         LOGGER.debug(txt.toString());
      }
      
      if (isPublicRenderParameter(windowId, name)) {
         int index = prpMapper.getIndex(windowId, name);
         if (index >= 0) {
            vals = prpMapper.getValues(index).clone();
         } else {
            LOGGER.debug("Public render parameter name not found in index.");
         }
      } else {
         for (PortalURLParameter p : url.getParameters()) {
            if (p.getWindowId().equals(windowId)
               && p.getName().equals(name) && p.getType().equals(type)) {
               vals = p.getValues().clone();
            }
         }
      }
      
      return vals;
   }

   /**
    * Sets a parameter. This method sets a parameter
    * of type corresponding to the URL type - Action parameter for an Action URL, etc.
    * V2 compatibility method.
    */
   public void setParameter(String windowId, String name, String[] values) {
      String type = urlTypeMap.get(url.getType());
      
      if (isDebug) {
         StringBuilder txt = new StringBuilder("Setting ");
         txt.append("name: ").append(name);
         txt.append(", values: ").append(Arrays.toString(values));
         txt.append(", type: ").append(type);
         txt.append(", window ID: ").append(windowId);
         LOGGER.debug(txt.toString());
      }
      
      if (url.getType() == URLType.Render && isPublicRenderParameter(windowId, name)) {
         addPublicRenderParameter(windowId, name, values);
      } else {
         if (urlTypeMap.containsKey(url.getType())) {
            PortalURLParameter pup = new PortalURLParameter(windowId, name, values, type);
            url.setParameter(pup);
         } else {
            LOGGER.warn("Unsupported URL / Parameter type: " + url.getType());
         }
      }
   }

   /**
    * Remove parameter. If the parameter is a public render parameter, 
    * an <code>IllegalArgumentException</code> is thrown. This method removes a parameter
    * of type corresponding to the URL type - Action parameter for an Action URL, etc. 
    * (V3 Spec errata)
    */
   public void removeParameter(String windowId, String name) {
      String type = urlTypeMap.get(url.getType());
      if (isDebug) {
         StringBuilder txt = new StringBuilder("Removing ");
         txt.append("name: ").append(name);
         txt.append(", type: ").append(type);
         txt.append(", window ID: ").append(windowId);
         LOGGER.debug(txt.toString());
      }
      if (isPublicRenderParameter(windowId, name)) {
         throw new IllegalArgumentException("Cannot set a public render parameter to null. Parameter name: " + name);
      } else {
         PortalURLParameter pup = new PortalURLParameter(windowId, name, null, type);
         url.removeParameter(pup);
      }
   }
}
