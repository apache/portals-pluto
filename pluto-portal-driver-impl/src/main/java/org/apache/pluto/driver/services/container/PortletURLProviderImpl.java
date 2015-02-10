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
import javax.xml.namespace.QName;

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
   private final Logger   LOGGER     = LoggerFactory.getLogger(PortletURLProviderImpl.class);
   private final boolean  isDebug    = LOGGER.isDebugEnabled();

   private final PortalURL                     url;
   private final PublicRenderParameterMapper   prpMapper;
   private final PortletParameterFactory       parmFactory;

   private final TYPE                          type;
   private final String                        window;
   private PortletMode                         portletMode;
   private WindowState                         windowState;
   private String                              cacheLevel = ResourceURL.PAGE;                            // default
   private String                              resourceID;
   private Map<String, String[]>               renderParameters;
   private Map<String, List<String>>           properties;

   private final Set<PortalURLPublicParameter> prpSet     = new HashSet<PortalURLPublicParameter>();

   public PortletURLProviderImpl(PortalURL url, TYPE type,
         PortletWindow portletWindow) {
      this.url = url.clone();
      this.type = type;
      this.window = portletWindow.getId().getStringId();

      parmFactory = url.getPortletParameterFactory();
      prpMapper = url.getPublicRenderParameterMapper();

      if (isDebug) {
         StringBuilder txt = new StringBuilder("Constructed PortalURLProviderImpl. ");
         txt.append("type=").append(type);
         txt.append(", URL type=").append(url.getType());
         txt.append(", target=").append(url.getTargetWindow());
         LOGGER.debug(txt.toString());
      }
   }
   
   public String logSomething() {
      LOGGER.debug("Here is a debug message from " + this.getClass().getCanonicalName());
      LOGGER.warn("Here is a message from " + this.getClass().getCanonicalName());
      LOGGER.error("Here is a 'debug' !string, how is that?");
      StringBuilder txt = new StringBuilder();
      txt.append("Info about logger. isDebug=").append(isDebug);
      txt.append(", Name=").append(LOGGER.getName());
      txt.append(", Root Logger Name=").append(LOGGER.ROOT_LOGGER_NAME);
      return txt.toString();
   }

   /**
    * Returns <code>true</code> if given parameter name is a public render
    * parameter
    * 
    * @param name
    */
   private boolean isPRP(String name) {
      boolean found = false;
      for (PortalURLPublicParameter prp : prpSet) {
         if (name.equals(prp.getName())) {
            found = true;
            break;
         }
      }
      return found;
   }

   public PortalURL apply() {

      url.setTargetWindow(window);
      switch (type) {
      case ACTION:
         url.setType(URLType.Action);
         break;
      case RESOURCE:
         url.setType(URLType.Resource);
         url.clearResourceParameters(window);
         url.setCacheability(ResourceURL.PAGE);
         break;
      default:
         url.setType(URLType.Render);
         url.clearParameters(window);
      }

      if (isDebug) {
         StringBuilder txt = new StringBuilder("apply URL values: ");
         txt.append("type=").append(type);
         txt.append(", URL type=").append(url.getType());
         txt.append(", target=").append(url.getTargetWindow());
         LOGGER.debug(txt.toString());
      }
      if (renderParameters != null) {
         for (Map.Entry<String, String[]> entry : renderParameters.entrySet()) {
            if (!isPRP(entry.getKey())) {
               url.addParameter(new PortalURLParameter(window, entry.getKey(),
                     entry.getValue()));
            }
         }
      }
      for (PortalURLPublicParameter prp : prpSet) {
         url.addPublicRenderParameter(prp);
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

   public Map<String, String[]> getRenderParameters() {
      if (renderParameters == null) {
         renderParameters = new HashMap<String, String[]>();
      }
      return renderParameters;
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

   /*
    * (non-Javadoc)
    * 
    * @see
    * org.apache.pluto.container.PortletURLProvider#addPublicRenderParameter
    * (javax.xml.namespace.QName, java.lang.String, java.lang.String[])
    */
   public void addPublicRenderParameter(QName qn, String identifier,
         String[] values) {
      if (isDebug) {
         StringBuilder txt = new StringBuilder("Add PRP. QName = ");
         txt.append(qn.toString()).append(", ID = ").append(identifier)
               .append(", values = ").append(Arrays.toString(values));
         LOGGER.debug(txt.toString());
      }
      PortalURLPublicParameter pupp = new PortalURLPublicParameter(window,
            identifier, qn, values);
      prpSet.add(pupp);
   }

   /*
    * (non-Javadoc)
    * 
    * @see
    * org.apache.pluto.container.PortletURLProvider#removePublicRenderParameter
    * (javax.xml.namespace.QName)
    */
   public void removePublicRenderParameter(QName qn, String identifier) {
      if (isDebug) {
         LOGGER.debug("Remove PRP. QName = " + qn.toString());
      }
      PortalURLPublicParameter pupp = new PortalURLPublicParameter(window,
            identifier, qn);
      pupp.setRemoved(true);
      prpSet.add(pupp);
   }

   public void addPublicRenderParameter(String windowId, String name,
         String[] values) {
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
      if (isDebug) {
         StringBuilder txt = new StringBuilder("Remove PRP. Window: ");
         txt.append(windowId).append(", name: ").append(name);
         LOGGER.debug(txt.toString());
      }
      int index = prpMapper.getIndex(windowId, name);
      if (index >= 0) {
         prpMapper.setRemoved(index, true);
      } else {
         StringBuilder txt = new StringBuilder(
               "Public render parameter for window: ");
         txt.append(windowId).append(", name: ").append(name)
               .append(" not found in mapper");
         LOGGER.warn(txt.toString());
      }
   }

   public boolean isPublicRenderParameter(String windowId, String name) {
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

   public Set<String> getParameterNames(String windowId) {
      // TODO Auto-generated method stub
      return null;
   }

   public String[] getParameterValues(String windowId, String name) {
      // TODO Auto-generated method stub
      return null;
   }

   public void setParameter(String windowId, String name, String[] values) {
      // TODO Auto-generated method stub

   }

   public void removeParameter(String windowId, String name) {
      // TODO Auto-generated method stub

   }
}
