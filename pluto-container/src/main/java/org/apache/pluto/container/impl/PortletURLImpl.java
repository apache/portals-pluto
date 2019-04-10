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

import java.util.Enumeration;

import javax.enterprise.inject.spi.Bean;
import javax.portlet.MimeResponse.Copy;
import javax.portlet.MutableRenderParameters;
import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;
import javax.portlet.annotations.PortletSerializable;
import javax.portlet.annotations.RenderStateScoped;

import org.apache.pluto.container.PortletResponseContext;
import org.apache.pluto.container.PortletURLProvider;
import org.apache.pluto.container.bean.processor.PortletStateScopedBeanHolder;
import org.apache.pluto.container.om.portlet.CustomPortletMode;
import org.apache.pluto.container.om.portlet.PortletDefinition;
import org.apache.pluto.container.om.portlet.Supports;
import org.apache.pluto.container.util.ArgumentUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Refactoring to implement class hierarchy among various URL types
 * 
 * @since 2.0
 */
public abstract class PortletURLImpl extends BaseURLImpl implements PortletURL {
   private static final Logger    LOGGER  = LoggerFactory.getLogger(PortletURLImpl.class);
   private static final boolean   isDebug = LOGGER.isDebugEnabled();

   // Called to force class loading in Container thread
   public static final void load() {
      if (isDebug) {
         LOGGER.debug("Loaded.");
      }
   };

   // Constructors
   // ------------------------------------------------------------

   public PortletURLImpl(PortletResponseContext responseContext,
         PortletURLProvider portletURLProvider, Copy copy) {
      super(responseContext, portletURLProvider, copy);
   }

   // Private methods
   // ------------------------------------------------------------

   private boolean isPortletModeAllowed(PortletMode mode) {
      if (PortletMode.VIEW.equals(mode)) {
         return true;
      }

      String modeName = mode.toString();

      PortletDefinition dd = responseContext.getPortletWindow()
            .getPortletDefinition();

      for (Supports sup : dd.getSupports()) {
         for (String m : sup.getPortletModes()) {
            if (m.equalsIgnoreCase(modeName)) {
               // check if a portlet managed mode which is always allowed.
               CustomPortletMode cpm = dd.getApplication()
                     .getCustomPortletMode(modeName);
               if (cpm != null && !cpm.isPortalManaged()) {
                  return true;
               }
               Enumeration<PortletMode> supportedModes = portalContext
                     .getSupportedPortletModes();
               while (supportedModes.hasMoreElements()) {
                  if (supportedModes.nextElement().equals(mode)) {
                     return true;
                  }
               }
               return false;
            }
         }
      }
      return false;
   }

   private boolean isWindowStateAllowed(WindowState state) {
      Enumeration<WindowState> supportedStates = portalContext
            .getSupportedWindowStates();
      while (supportedStates.hasMoreElements()) {
         if (supportedStates.nextElement().equals(state)) {
            return true;
         }
      }
      return false;
   }

   // PortletURL impl
   // ------------------------------------------------------------

   public void setPortletMode(PortletMode portletMode)
         throws PortletModeException {
      ArgumentUtility.validateNotNull("portletMode", portletMode);
      if (isPortletModeAllowed(portletMode)) {
         urlProvider.setPortletMode(portletMode);
      } else {
         throw new PortletModeException("Can't set this PortletMode",
               portletMode);
      }
   }

   public void setWindowState(WindowState windowState)
         throws WindowStateException {
      ArgumentUtility.validateNotNull("windowState", windowState);
      if (isWindowStateAllowed(windowState)) {
         urlProvider.setWindowState(windowState);
      } else {
         throw new WindowStateException("Can't set this WindowState",
               windowState);
      }
   }

   public void removePublicRenderParameter(String name) {
      ArgumentUtility.validateNotEmpty("name", name);
      urlProvider.removePublicRenderParameter(windowId, name);
   }

   @Override
   public MutableRenderParameters getRenderParameters() {
      return new MutableRenderParametersImpl(urlProvider, windowId);
   }
   
   @SuppressWarnings("unused")
   @Override
   public void setBeanParameter(PortletSerializable portletSerializable) {
      if (portletSerializable == null) {
         StringBuilder txt = new StringBuilder(128);
         txt.append("Required parameter is null.");
         txt.append(", portletSerializable: ").append(portletSerializable);
         LOGGER.info(txt.toString());
         throw new IllegalArgumentException(txt.toString());
      }

      PortletStateScopedBeanHolder portletStateScopedBeanHolder =
          PortletStateScopedBeanHolder.getBeanHolder();
      Class<? extends PortletSerializable> beanClass = portletSerializable.getClass();
      String name;

      if (portletStateScopedBeanHolder == null) {
         RenderStateScoped renderStateScoped = beanClass.getAnnotation(RenderStateScoped.class);
         if (renderStateScoped == null) {
            StringBuilder txt = new StringBuilder(128);
            txt.append("Given portletSerializable is not @RenderStateScoped.");
            txt.append(", portletSerializable: ").append(portletSerializable);
            LOGGER.info(txt.toString());
            throw new IllegalArgumentException(txt.toString());
         }

         name = renderStateScoped.paramName();

         if ((name == null) || (name.trim().length() == 0)) {
            StringBuilder txt = new StringBuilder(128);
            txt.append("@RenderStateScoped portletSerializable does not have a paramName.");
            txt.append(", portletSerializable: ").append(portletSerializable);
            LOGGER.info(txt.toString());
            throw new IllegalArgumentException(txt.toString());
         }
      }
      else {
         beanClass = portletSerializable.getClass();
         name = portletStateScopedBeanHolder.getParameterName(beanClass);
      }

      if (name == null) {
         StringBuilder txt = new StringBuilder(128);
         txt.append("Given portletSerializable is not @RenderStateScoped.");
         txt.append(", portletSerializable: ").append(portletSerializable);
         LOGGER.info(txt.toString());
         throw new IllegalArgumentException(txt.toString());
      }
      
      getRenderParameters().setValues(name, portletSerializable.serialize());
      
   }

}
