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
package org.apache.pluto.driver.url.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletMode;
import javax.portlet.WindowState;
import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.pluto.driver.AttributeKeys;
import org.apache.pluto.driver.config.DriverConfiguration;
import org.apache.pluto.driver.services.portal.PageConfig;
import org.apache.pluto.driver.services.portal.PublicRenderParameterMapper;
import org.apache.pluto.driver.url.PortalURL;
import org.apache.pluto.driver.url.PortalURLParameter;
import org.apache.pluto.driver.url.PortalURLPublicParameter;
import org.apache.pluto.driver.url.PortalURLParser;

/**
 * The portal URL.
 * @since 1.0
 */
public class RelativePortalURLImpl implements PortalURL {

   private static final Logger LOG = LoggerFactory.getLogger(RelativePortalURLImpl.class);

   private String urlBase;
   private String servletPath;
   private String renderPath;
   private String actionWindow;
   private String ajaxActionWindow;
   private String partialActionWindow;
   private String resourceWindow;
   private String cacheLevel;
   private String resourceID;

   private Map<String, String[]> privateRenderParameters = new HashMap<String, String[]>();

   // provides the defined public render parameters and their relationships to one another for the current page 
   private PublicRenderParameterMapper prpMapper = null;
   
   private Collection<String> portletIds = new ArrayList<String>();

   /**
    * PortalURLParser used to construct the string
    * representation of this portal url.
    */
   private PortalURLParser urlParser;

   /** The window states: key is the window ID, value is WindowState. */
   private Map<String, WindowState> windowStates = new HashMap<String, WindowState>();

   private Map<String, PortletMode> portletModes = new HashMap<String, PortletMode>();

   /** Parameters of the portlet windows. */
   private Map<String, PortalURLParameter> parameters = new HashMap<String, PortalURLParameter>();

   /**
    * Constructs a PortalURLImpl instance using customized port.
    * @param urlBase      the absolute (protocol://domain:port) request url base
    * @param contextPath  the servlet context path.
    * @param servletName  the servlet name.
    * @param urlParser    the {@link PortalURLParser} used to construct a string representation of the url.
    */
   public RelativePortalURLImpl(String urlBase, String contextPath, String servletName, PortalURLParser urlParser) {
      this.urlBase = urlBase;
      StringBuffer buffer = new StringBuffer();
      buffer.append(contextPath);
      buffer.append(servletName);
      servletPath = buffer.toString();
      this.urlParser = urlParser;
   }

   /**
    * Internal private constructor used by method <code>clone()</code>.
    * @see #clone()
    */
   private RelativePortalURLImpl() {
      // Do nothing.
   }

   // Public Methods ----------------------------------------------------------

   public void setRenderPath(String renderPath) {
      this.renderPath = renderPath;
   }

   public String getRenderPath() {
      return renderPath;
   }

   public void addParameter(PortalURLParameter param) {
      parameters.put(param.getWindowId() + param.getName(), param);
   }

   public Collection<PortalURLParameter> getParameters() {
      return parameters.values();
   }

   public void setActionWindow(String actionWindow) {
      this.actionWindow = actionWindow;
   }

   public String getActionWindow() {
      return actionWindow;
   }

   public void setAjaxActionWindow(String window) {
      this.ajaxActionWindow = window;
   }

   public String getAjaxActionWindow() {
      return ajaxActionWindow;
   }

   public void setPartialActionWindow(String window) {
      this.partialActionWindow = window;
   }

   public String getPartialActionWindow() {
      return partialActionWindow;
   }

   public Map<String, PortletMode> getPortletModes() {
      return Collections.unmodifiableMap(portletModes);
   }

   public PortletMode getPortletMode(String windowId) {
      PortletMode mode = portletModes.get(windowId);
      if (mode == null) {
         mode = PortletMode.VIEW;
      }
      return mode;
   }

   public void setPortletMode(String windowId, PortletMode portletMode) {
      portletModes.put(windowId, portletMode);
   }

   public Map<String, WindowState> getWindowStates() {
      return Collections.unmodifiableMap(windowStates);
   }

   /**
    * Returns the window state of the specified window.
    * @param windowId  the window ID.
    * @return the window state. Default to NORMAL.
    */
   public WindowState getWindowState(String windowId) {
      WindowState state = windowStates.get(windowId);
      if (state == null) {
         state = WindowState.NORMAL;
      }
      return state;
   }

   /**
    * Sets the window state of the specified window.
    * @param windowId  the window ID.
    * @param windowState  the window state.
    */
   public void setWindowState(String windowId, WindowState windowState) {
      this.windowStates.put(windowId, windowState);
   }

   /**
    * Clear parameters of the specified window.
    * @param windowId  the window ID.
    */
   public void clearParameters(String windowId) {
      for (Iterator<Map.Entry<String, PortalURLParameter>> it = parameters.entrySet().iterator(); it.hasNext(); ) {
         Map.Entry<String, PortalURLParameter> entry = it.next();
         PortalURLParameter param = entry.getValue();
         if (param.getWindowId()!=null){
            if (param.getWindowId().equals(windowId)) {
               it.remove();
            }
         }
      }
   }

   public void setCacheability(String cacheLevel)
   {
      this.cacheLevel = cacheLevel;
   }

   public String getCacheability()
   {
      return cacheLevel;
   }

   public void setResourceID(String resourceID)
   {
      this.resourceID = resourceID;
   }

   public String getResourceID()
   {
      return resourceID;
   }

   /**
    * Converts to a string representing the portal URL.
    * @deprecated use toURL(boolean absolute) instead
    * @return a string representing the portal URL.
    * @see PortalURLParserImpl#toString(org.apache.pluto.driver.url.PortalURL)
    */
   public String toString() {
      return toURL(false);
   }

   /**
    * Converts to a string representing the portal URL.
    * @return a string representing the portal URL.
    * @see PortalURLParserImpl#toString(org.apache.pluto.driver.url.PortalURL)
    */
   public String toURL(boolean absolute)
   {
      String result = urlParser.toString(this);
      if (absolute)
      {
         return urlBase + result;
      }
      return result;
   }

   /**
    * Returns the server URI (protocol, name, port).
    * @return the server URI portion of the portal URL.
    * @deprecated
    */
   @Deprecated
   public String getServerURI() {
      return null;
   }

   /**
    * Returns the servlet path (context path + servlet name).
    * @return the servlet path.
    */
   public String getServletPath() {
      return servletPath;
   }

   /**
    * Clone a copy of itself.
    * @return a copy of itself.
    */
   public synchronized PortalURL clone() {
      RelativePortalURLImpl portalURL = new RelativePortalURLImpl();
      portalURL.servletPath = this.servletPath;
      portalURL.parameters = new HashMap<String, PortalURLParameter>(parameters);
      portalURL.privateRenderParameters = new HashMap<String, String[]>(privateRenderParameters);
      portalURL.portletModes = new HashMap<String, PortletMode>(portletModes);
      portalURL.windowStates = new HashMap<String, WindowState>(windowStates);
      portalURL.cacheLevel = cacheLevel;
      portalURL.resourceID = resourceID;
      portalURL.renderPath = renderPath;
      portalURL.actionWindow = actionWindow;
      portalURL.urlParser = urlParser;
      portalURL.resourceWindow = resourceWindow;
      portalURL.prpMapper = (prpMapper == null) ? null : prpMapper.clone();
      portalURL.portletIds = portletIds;
      return portalURL;
   }
   //JSR-286 methods

   public void addPublicParameterCurrent(String name, String[] values){
      for (int ii = 0; ii < prpMapper.getNumberOfGroups(); ii++) {
         List<PortalURLPublicParameter> prps = prpMapper.getPublicParameterGroup(ii);
         if (prps.get(0).getName().equals(name)) {
            prpMapper.setValues(ii, values);
         }
      }
   }

   public Map<String, String[]> getPublicParameters() {
      Map<String,String[]> tmp = new HashMap<String, String[]>();
      if (prpMapper != null) {
         for (int ind : prpMapper.getActiveIndexes()) {
            String name = prpMapper.getPublicParameterGroup(ind).get(0).getName();
            String[] vals = prpMapper.getValues(ind);
            tmp.put(name, vals);
         }
      }
      return tmp;
   }

   public Map<String, String[]> getPrivateRenderParameters()
   {
      return privateRenderParameters;
   }


   public PageConfig getPageConfig(ServletContext servletContext) {
      String requestedPageId = getRenderPath();
      if (LOG.isDebugEnabled()) {
         LOG.debug("Requested Page: " + requestedPageId);
      }
      
      DriverConfiguration dc =  ((DriverConfiguration) servletContext.getAttribute(AttributeKeys.DRIVER_CONFIG));
      PageConfig paco = dc.getPageConfig(requestedPageId);
      if (prpMapper == null && requestedPageId == null && paco != null) {
         // Make sure we get a prp mapper for the default page
         prpMapper = dc.getPublicRenderParameterService().getPRPMapper(paco.getName());
      }
      return paco;
   }

   public String getResourceWindow() {
      return resourceWindow;
   }

   public void setResourceWindow(String resourceWindow) {
      this.resourceWindow = resourceWindow;
   }

   public synchronized void merge(PortalURL url, String windowId)
   {
      actionWindow = url.getActionWindow();
      resourceWindow = url.getResourceWindow();
      setPortletMode(windowId, url.getPortletMode(windowId));
      setWindowState(windowId, url.getWindowState(windowId));
      setCacheability(url.getCacheability());
      setResourceID(url.getResourceID());
      clearParameters(windowId);
      for (PortalURLParameter param : url.getParameters())
      {
         if (windowId.equals(param.getWindowId()))
         {
            addParameter(new PortalURLParameter(param.getWindowId(), param.getName(), param.getValues()));
         }
      }
      PublicRenderParameterMapper prpm = url.getPublicRenderParameterMapper();
      List<Integer> activePrps = prpm.getActiveIndexes();
      for (int ii = 0; ii < prpm.getNumberOfGroups(); ii++) {
         if (activePrps.contains(ii)) {
            prpMapper.setValues(ii, prpm.getValues(ii));
         } else {
            prpMapper.setRemoved(ii, true);
         }
      }
   }

   public void addPublicRenderParameter(PortalURLPublicParameter pup) {
      int ind = prpMapper.getIndex(pup);
      if (ind >= 0) {
         if (pup.isRemoved()) {
            prpMapper.setRemoved(ind, true);
         } else {
            prpMapper.setValues(ind, pup.getValues());
         }
      } else {
         StringBuilder txt = new StringBuilder("Public render parameter is not contained in mapper.");
         txt.append(" window ID: " + pup.getWindowId());
         txt.append(", Name: " + pup.getName());
         txt.append(", QName: " + pup.getQName());
         txt.append(", Values: " + Arrays.toString(pup.getValues()));
         LOG.warn(txt.toString());
      }
   }

   public void setPublicRenderParameterMapper(PublicRenderParameterMapper prpm) {
      prpMapper = prpm;
   }

   public PublicRenderParameterMapper getPublicRenderParameterMapper() {
      return prpMapper;
   }

   public void setPortletIds(Collection<String> portletIds) {
      this.portletIds.addAll(portletIds);
      if (LOG.isDebugEnabled()) {
         LOG.debug("Stored " + this.portletIds.size() + " IDs: " + Arrays.toString(this.portletIds.toArray()));
      }
   }

   public Collection<String> getPortletIds() {
      return this.portletIds;
   }
}
