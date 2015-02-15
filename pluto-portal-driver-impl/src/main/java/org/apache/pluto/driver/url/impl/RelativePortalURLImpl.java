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

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletMode;
import javax.portlet.WindowState;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

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
import org.apache.pluto.driver.url.PortletParameterFactory;

/**
 * The portal URL.
 * 
 * @since 1.0
 */
public class RelativePortalURLImpl implements PortalURL {

   private static final Logger   LOG      = LoggerFactory.getLogger(RelativePortalURLImpl.class);
   private static final boolean  isDebug  = LOG.isDebugEnabled();
   private static final boolean  isTrace  = LOG.isTraceEnabled();

   private String                      urlBase;
   private String                      servletPath;
   private String                      renderPath;
   private String                      cacheLevel;
   private String                      resourceID;

   private int                         cloneId        = 0;
   private static int                  cloneCtr       = 0;

   // provides the defined public render parameters and their relationships to
   // one another for the current page
   private PublicRenderParameterMapper prpMapper          = null;

   private HashSet<String>             portletIds         = new HashSet<String>();
   private HashMap<String, String>     versionMap         = new HashMap<String, String>();
   private HashMap<String, Boolean>    v3Map              = new HashMap<String, Boolean>();

   /**
    * PortalURLParser used to construct the string representation of this portal
    * url.
    */
   private PortalURLParser             urlParser;

   // The servlet request for delyed parsing of the servlet parameters
   HttpServletRequest                  servletRequest;
   // marks whether the servlet request parameters have been processed.
   boolean                             reqParamsProcessed = false;

   /** The window states: key is the window ID, value is WindowState. */
   private Map<String, WindowState>    windowStates       = new HashMap<String, WindowState>();

   private Map<String, PortletMode>    portletModes       = new HashMap<String, PortletMode>();

   /** Parameters of the portlet windows. */
   private HashSet<PortalURLParameter> parameters         = new HashSet<PortalURLParameter>();

   // Target window & type of URL
   URLType                             type               = URLType.Portal;                             // initially
   String                              targetWindow       = null;

   
   /**
    * Constructs a PortalURLImpl instance using customized port.
    * 
    * @param urlBase
    *           the absolute (protocol://domain:port) request url base
    * @param contextPath
    *           the servlet context path.
    * @param servletName
    *           the servlet name.
    * @param urlParser
    *           the {@link PortalURLParser} used to construct a string
    *           representation of the url.
    */
   public RelativePortalURLImpl(String urlBase, String contextPath,
         String servletName, PortalURLParser urlParser, HttpServletRequest req) {
      this.urlBase = urlBase;
      StringBuffer buffer = new StringBuffer();
      buffer.append(contextPath);
      buffer.append(servletName);
      servletPath = buffer.toString();
      this.urlParser = urlParser;
      this.servletRequest = req;
      this.cloneId = (++cloneCtr) + 10000;
      if (isDebug) {
         LOG.debug("Constructed URL, clone ID: " + cloneId);
      }
   }

   /**
    * Internal private constructor used by method <code>clone()</code>.
    * 
    * @see #clone()
    */
   private RelativePortalURLImpl() {
      // Do nothing.
   }

   // reading of the servlet request parameters is delayed until the first time
   // the parameters are read in order to allow a portlet to potentially set
   // the character encoding during processAction or serveResource.

   protected void handleServletRequestParams() {
      if (!reqParamsProcessed && servletRequest != null && targetWindow != null
            && type != URLType.Portal) {
         reqParamsProcessed = true;

         try {
            servletRequest.setCharacterEncoding("UTF-8"); // in case it hasn't
                                                          // already been set
         } catch (Exception e) {
         }

         Map<String, String[]> parms = servletRequest.getParameterMap();
         if (!parms.isEmpty()) {

            // choose the parameter type. Query or POST parameters always target
            // the
            // target window, never the general page.

            String ptype = PortalURLParameter.PARAM_TYPE_RENDER;
            if (type == URLType.Action || type == URLType.AjaxAction
                  || type == URLType.PartialAction) {
               ptype = PortalURLParameter.PARAM_TYPE_ACTION;
            } else if (type == URLType.Resource) {
               ptype = PortalURLParameter.PARAM_TYPE_RESOURCE;
            }

            // The semantics is a query or POST parameter overwrites a
            // parameter of the same windowId, type and name encoded in the URL.

            for (String parm : parms.keySet()) {

               // If it's a render request & target window is set, the parameter
               // might be public
               if (type == URLType.Render && targetWindow != null) {
                  int index = prpMapper.getIndex(targetWindow, parm);
                  if (index >= 0) {
                     prpMapper.setValues(index, parms.get(parm));
                     if (isDebug) {
                        StringBuilder txt = new StringBuilder("Added public parameter: ");
                        txt.append(parm).append(", Values: ")
                           .append(Arrays.toString(parms.get(parm)));
                        txt.append(", Clone ID: " + cloneId);
                        LOG.debug(txt.toString());
                     }
                     continue;
                  }
               }

               // handle private parameter

               PortalURLParameter pup = new PortalURLParameter(targetWindow,
                     parm, parms.get(parm), ptype);
               if (parameters.contains(pup)) {
                  parameters.remove(pup); // remove the old values
               }
               parameters.add(pup); // add the new values
               if (isDebug) {
                  StringBuilder txt = new StringBuilder("Added private parameter: ");
                  txt.append(parm).append(", Values: ").append(Arrays.toString(parms.get(parm)));
                  txt.append(", Type: ").append(ptype);
                  txt.append(", Clone ID: " + cloneId);
                  LOG.debug(txt.toString());
               }
            }
         }
      }
   }

   // Public Methods ----------------------------------------------------------

   public void setRenderPath(String renderPath) {
      this.renderPath = renderPath;
   }

   public String getRenderPath() {
      return renderPath;
   }

   public Collection<PortalURLParameter> getParameters() {
      handleServletRequestParams();
      return parameters;
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
    * 
    * @param windowId
    *           the window ID.
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
    * 
    * @param windowId
    *           the window ID.
    * @param windowState
    *           the window state.
    */
   public void setWindowState(String windowId, WindowState windowState) {
      this.windowStates.put(windowId, windowState);
   }

   public void setCacheability(String cacheLevel) {
      this.cacheLevel = cacheLevel;
   }

   public String getCacheability() {
      return cacheLevel;
   }

   public void setResourceID(String resourceID) {
      this.resourceID = resourceID;
   }

   public String getResourceID() {
      return resourceID;
   }

   /**
    * Converts to a string representing the portal URL.
    * 
    * @deprecated use toURL(boolean absolute) instead
    * @return a string representing the portal URL.
    * @see PortalURLParserImpl#toString(org.apache.pluto.driver.url.PortalURL)
    */
   public String toString() {
      return toURL(false);
   }

   /**
    * Converts to a string representing the portal URL.
    * 
    * @return a string representing the portal URL.
    * @see PortalURLParserImpl#toString(org.apache.pluto.driver.url.PortalURL)
    */
   public String toURL(boolean absolute) {
      String result = urlParser.toString(this);
      if (absolute) {
         return urlBase + result;
      }
      if (isDebug) {
         StringBuilder txt = new StringBuilder();
         txt.append("Clone ID: ").append(cloneId)
            .append(", absolute: ").append(absolute)
            .append(", URL: ").append(result);
         LOG.debug(txt.toString());
      }
      return result;
   }

   /**
    * Returns the server URI (protocol, name, port).
    * 
    * @return the server URI portion of the portal URL.
    * @deprecated
    */
   @Deprecated
   public String getServerURI() {
      return null;
   }

   /**
    * Returns the servlet path (context path + servlet name).
    * 
    * @return the servlet path.
    */
   public String getServletPath() {
      return servletPath;
   }

   /**
    * Clone a copy of itself.
    * 
    * @return a copy of itself.
    */
   public synchronized PortalURL clone() {
      RelativePortalURLImpl portalURL = new RelativePortalURLImpl();

      portalURL.urlBase = this.urlBase;
      portalURL.servletPath = this.servletPath;
      portalURL.renderPath = renderPath;
      portalURL.cacheLevel = cacheLevel;
      portalURL.resourceID = resourceID;

      portalURL.prpMapper = (prpMapper == null) ? null : prpMapper.clone();
      portalURL.portletIds = new HashSet<String>(portletIds);
      portalURL.versionMap = new HashMap<String, String>(versionMap);
      portalURL.v3Map = new HashMap<String, Boolean>(v3Map);

      portalURL.urlParser = urlParser;
      portalURL.servletRequest = servletRequest;
      portalURL.reqParamsProcessed = reqParamsProcessed;

      portalURL.windowStates = new HashMap<String, WindowState>(windowStates);
      portalURL.portletModes = new HashMap<String, PortletMode>(portletModes);

      for (PortalURLParameter p : parameters) {
         portalURL.parameters.add(p.clone());
      }

      portalURL.type = type;
      portalURL.targetWindow = targetWindow;

      portalURL.cloneId = ++cloneCtr;

      if (isTrace) {
         long tid = Thread.currentThread().getId();
         StringBuilder txt = new StringBuilder();
         txt.append("Created clone ID= ").append(portalURL.cloneId);
         txt.append(" from URL with clone ID= ").append(this.cloneId);
         txt.append(". ThreadId=").append(tid);
         LOG.debug(txt.toString());
      }
      return portalURL;
   }

   public PageConfig getPageConfig(ServletContext servletContext) {
      String requestedPageId = getRenderPath();
      if (isTrace) {
         LOG.debug("Requested Page: " + requestedPageId);
      }

      DriverConfiguration dc = ((DriverConfiguration) servletContext
            .getAttribute(AttributeKeys.DRIVER_CONFIG));
      PageConfig paco = dc.getPageConfig(requestedPageId);
      if (prpMapper == null && requestedPageId == null && paco != null) {
         // Make sure we get a prp mapper for the default page
         prpMapper = dc.getPublicRenderParameterService().getPRPMapper(
               paco.getName());
      }
      return paco;
   }

   public void setPortletIds(Collection<String> portletIds) {
      this.portletIds.addAll(portletIds);
      if (isTrace) {
         LOG.debug("Stored " + this.portletIds.size() + " IDs: "
               + Arrays.toString(this.portletIds.toArray()));
      }
   }

   public Collection<String> getPortletIds() {
      return this.portletIds;
   }

   public void setVersion(String portletId, String version) {
      versionMap.put(portletId, version);
      v3Map.put(portletId, (version.equals("3.0")));
   }

   public String getVersion(String portletId) {
      return versionMap.get(portletId);
   }

   public boolean isVersion3(String portletId) {
      return v3Map.get(portletId);
   }

   /*
    * (non-Javadoc)
    * 
    * @see
    * org.apache.pluto.driver.url.PortalURL#setType(org.apache.pluto.driver.
    * url.PortalURL.URLType)
    */
   public void setType(URLType type) {
      if (isTrace) {
         long tid = Thread.currentThread().getId();
         StringBuilder txt = new StringBuilder();
         txt.append("old type= ").append(this.type);
         txt.append(", new type= ").append(type);
         txt.append(", clone ID= ").append(cloneId);
         txt.append(". ThreadId=").append(tid);
         LOG.debug(txt.toString());
      }
      this.type = type;
   }

   /*
    * (non-Javadoc)
    * 
    * @see org.apache.pluto.driver.url.PortalURL#getType()
    */
   public URLType getType() {
      if (isTrace) {
         long tid = Thread.currentThread().getId();
         StringBuilder txt = new StringBuilder();
         txt.append("type= ").append(this.type);
         txt.append(", clone ID= ").append(cloneId);
         txt.append(". ThreadId=").append(tid);
         LOG.debug(txt.toString());
      }
      return type;
   }

   /*
    * (non-Javadoc)
    * 
    * @see
    * org.apache.pluto.driver.url.PortalURL#setTargetWindow(java.lang.String)
    */
   public void setTargetWindow(String windowId) {
      targetWindow = windowId;
   }

   /*
    * (non-Javadoc)
    * 
    * @see org.apache.pluto.driver.url.PortalURL#getTargetWindow()
    */
   public String getTargetWindow() {
      return targetWindow;
   }

   /**
    * Clear parameters of the specified window.
    * 
    * @param windowId
    *           the window ID.
    */
   public void clearParameters(String windowId) {
      HashSet<PortalURLParameter> rem = new HashSet<PortalURLParameter>();
      for (PortalURLParameter p : parameters) {
         if (p.getWindowId().equals(windowId)) {
            rem.add(p);
         }
      }
      if (isTrace) {
         StringBuilder txt = new StringBuilder("Removing ");
         txt.append(rem.size()).append(" elements. Window ID: ").append(windowId);
         LOG.debug(txt.toString());
      }
      parameters.removeAll(rem);
   }

   /*
    * (non-Javadoc)
    * 
    * @see
    * org.apache.pluto.driver.url.PortalURL#clearResourceParameters(java.lang
    * .String)
    */
   public void clearResourceParameters(String window) {
      handleServletRequestParams();
      HashSet<PortalURLParameter> rem = new HashSet<PortalURLParameter>();
      for (PortalURLParameter pup : parameters) {
         if (pup.getType().equals(PortalURLParameter.PARAM_TYPE_RESOURCE)
               && pup.getWindowId().equals(window)) {
            rem.add(pup);
         }
      }
      if (isTrace) {
         StringBuilder txt = new StringBuilder("Removing ");
         txt.append(rem.size()).append(" elements. Window ID: ").append(window);
         LOG.debug(txt.toString());
      }
      parameters.removeAll(rem);
   }

   protected void addParameter(PortalURLParameter param) {
      if (isDebug) {
         StringBuilder txt = new StringBuilder(
               "Adding private parameter: ");
         txt.append(" window ID: " + param.getWindowId());
         txt.append(", Name: " + param.getName());
         String vals = (param.getValues() == null) 
               ? "null" : Arrays.toString(param.getValues());
         txt.append(", Values: " + vals);
         txt.append(", Type: " + param.getType());
         txt.append(", Clone ID: " + cloneId);
         LOG.debug(txt.toString());
      }
      
      // If present, remove old value before adding new
      if (parameters.contains(param)) {
         parameters.remove(param);
      }
      parameters.add(param);
   }

   public void setParameter(PortalURLParameter param) {
      handleServletRequestParams();
      if (isDebug) {
         StringBuilder txt = new StringBuilder(
               "Setting private parameter: ");
         txt.append(" window ID: " + param.getWindowId());
         txt.append(", Name: " + param.getName());
         String vals = (param.getValues() == null) 
               ? "null" : Arrays.toString(param.getValues());
         txt.append(", Values: " + vals);
         txt.append(", Type: " + param.getType());
         txt.append(", Clone ID: " + cloneId);
         LOG.debug(txt.toString());
      }
      
      // If present, remove old value before adding new
      if (parameters.contains(param)) {
         parameters.remove(param);
      }
      parameters.add(param);
   }

   public PortletParameterFactory getPortletParameterFactory() {
      handleServletRequestParams();
      return new PortletParameterFactory(this);
   }

   public void setPublicRenderParameterMapper(PublicRenderParameterMapper prpm) {
      prpMapper = prpm;
   }

   public PublicRenderParameterMapper getPublicRenderParameterMapper() {
      handleServletRequestParams();
      return prpMapper;
   }

   public void removeParameter(PortalURLParameter param) {
      handleServletRequestParams();
      if (isDebug) {
         StringBuilder txt = new StringBuilder(
               "Removing private render parameter: ");
         txt.append(" window ID: " + param.getWindowId());
         txt.append(", Name: " + param.getName());
         txt.append(", Values: " + Arrays.toString(param.getValues()));
         if (!parameters.contains(param)) {
            txt.append(", Not in parameter set!");
         }
         LOG.debug(txt.toString());
      }
      parameters.remove(param);
   }

   public void removePublicRenderParameter(PortalURLPublicParameter param) {
      handleServletRequestParams();
      if (isDebug) {
         StringBuilder txt = new StringBuilder(
               "Removing public render parameter: ");
         txt.append(" window ID: " + param.getWindowId());
         txt.append(", Name: " + param.getName());
         txt.append(", QName: " + param.getQName());
         txt.append(", Values: " + Arrays.toString(param.getValues()));
         LOG.debug(txt.toString());
      }
      int index = prpMapper.getIndex(param);
      if (index >= 0) {
         prpMapper.setRemoved(index, true);
      } else {
         LOG.warn("Public parameter not found in PRP mapper.");
      }
   }
}
