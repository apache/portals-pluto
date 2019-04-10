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
package org.apache.pluto.container.impl;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.portlet.Event;
import javax.portlet.MutableRenderParameters;
import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.StateAwareResponse;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;
import javax.xml.namespace.QName;

import org.apache.pluto.container.PortletStateAwareResponseContext;
import org.apache.pluto.container.PortletWindow;
import org.apache.pluto.container.util.ArgumentUtility;

/**
 * Implementation of JSR-286 <code>StateAwareResponse</code>.
 * 
 * @since 2.0
 */
public abstract class StateAwareResponseImpl extends PortletResponseImpl
      implements StateAwareResponse {
   private final Logger  LOGGER  = LoggerFactory.getLogger(StateAwareResponseImpl.class);
   @SuppressWarnings("unused")
   private final boolean isDebug = LOGGER.isDebugEnabled();

   protected PortletStateAwareResponseContext responseContext;
   private final String                     windowId;

   public StateAwareResponseImpl(PortletStateAwareResponseContext responseContext) {
      super(responseContext);
      this.responseContext = responseContext;
      this.windowId = responseContext.getPortletWindow().getId().getStringId();
   }

   protected abstract void checkSetStateChanged();

   protected boolean isWindowStateAllowed(WindowState state) {
      Enumeration<WindowState> supportedStates = getPortalContext()
            .getSupportedWindowStates();
      while (supportedStates.hasMoreElements()) {
         if (supportedStates.nextElement().equals(state)) {
            return true;
         }
      }
      return false;
   }

   public PortletMode getPortletMode() {
      return responseContext.getPortletMode();
   }

   public Map<String, String[]> getRenderParameterMap() {
      Map<String, String[]> parameters = new HashMap<String, String[]>();
      Set<String> names = responseContext.getPrivateParameterNames(windowId);
      for (String name : names) {
         String[] vals = responseContext.getParameterValues(windowId, name);
         parameters.put(name, vals);
      }
      return parameters;
   }

   public WindowState getWindowState() {
      return responseContext.getWindowState();
   }

   public void removePublicRenderParameter(String name) {
      ArgumentUtility.validateNotEmpty("name", name);
      checkSetStateChanged();
      responseContext.removePublicRenderParameter(windowId, name);
   }

   public void setEvent(QName qname, Serializable value) {
      ArgumentUtility.validateNotNull("qname", qname);
      
      if (LOGGER.isTraceEnabled()) {
         StringBuilder txt = new StringBuilder(128);
         txt.append("QName: ").append(qname.toString());
         txt.append(", value class: ").append((value == null) ? "null": value.getClass().getCanonicalName());
         LOGGER.debug(txt.toString());
      }

      Event event = responseContext.getEventProvider()
            .createEvent(qname, value);
      if (event != null) {
         responseContext.getEvents().add(event);
      }
   }

   public void setEvent(String name, Serializable value) {
      PortletWindow window = getPortletWindow();
      String defaultNamespace;
      defaultNamespace = window.getPortletDefinition().getApplication()
            .getDefaultNamespace();
      QName qname = new QName(defaultNamespace, name);
      setEvent(qname, value);
   }

   public void setPortletMode(PortletMode portletMode)
         throws PortletModeException {
      ArgumentUtility.validateNotNull("portletMode", portletMode);
      if (isPortletModeAllowed(portletMode)) {
         checkSetStateChanged();
         responseContext.setPortletMode(portletMode);
      } else {
         throw new PortletModeException("Can't set this PortletMode",
               portletMode);
      }
   }

   public void setWindowState(WindowState windowState)
         throws WindowStateException {
      ArgumentUtility.validateNotNull("windowState", windowState);
      if (isWindowStateAllowed(windowState)) {
         checkSetStateChanged();
         responseContext.setWindowState(windowState);
      } else {
         throw new WindowStateException("Can't set this WindowState",
               windowState);
      }
   }

   public void setRenderParameters(java.util.Map<String, String[]> parameters) {
      ArgumentUtility.validateNotNull("parameters", parameters);

      // validate map first
      for (String key : parameters.keySet()) {
         String[] vals = parameters.get(key);
         if (key == null || vals == null) {
            throw new IllegalArgumentException("parameters map contains a null key or values array");
         }
      }
      
      // Throws exception if state change no longer allowed (for example, after a forward)
      checkSetStateChanged();

      // Remove the parameters that are gone
      Set<String> currNames = responseContext.getPrivateParameterNames(windowId);
      currNames.removeAll(parameters.keySet());
      for (String name : currNames) {
         responseContext.removeParameter(windowId, name);
      }
      
      // Now set the new values
      for (String key : parameters.keySet()) {
         responseContext.setParameter(windowId, key, parameters.get(key));
      }
   }

   public void setRenderParameter(String key, String value) {
      ArgumentUtility.validateNotEmpty("key", key);
      checkSetStateChanged();
      if (value == null) {
         responseContext.removeParameter(windowId, key);
      } else {
         String[] values = new String[] { value };
         responseContext.setParameter(windowId, key, values);
      }
   }

   public void setRenderParameter(String key, String... values) {
      ArgumentUtility.validateNotEmpty("key", key);
      checkSetStateChanged();
      if (values == null) {
         responseContext.removeParameter(windowId, key);
      } else {
         responseContext.setParameter(windowId, key, values.clone());
      }
   }

   public MutableRenderParameters getRenderParameters() {
      checkSetStateChanged();
      return responseContext.getRenderParameters(windowId);
   }
}
