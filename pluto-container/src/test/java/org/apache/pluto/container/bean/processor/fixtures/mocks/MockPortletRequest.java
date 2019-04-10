/*  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */


package org.apache.pluto.container.bean.processor.fixtures.mocks;

import java.security.Principal;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortalContext;
import javax.portlet.PortletContext;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.portlet.RenderParameters;
import javax.portlet.WindowState;
import javax.servlet.http.Cookie;

/**
 * @author Scott
 *
 */
public class MockPortletRequest implements PortletRequest {
   
   private PortletSession ps = new MockPortletSession();
   private PortletMode mode;

   /**
    * @return the mode
    */
   public PortletMode getMode() {
      return mode;
   }

   /**
    * @param mode the mode to set
    */
   public void setMode(PortletMode mode) {
      this.mode = mode;
   }

   /* (non-Javadoc)
    * @see javax.portlet.RenderState#getPortletMode()
    */
   @Override
   public PortletMode getPortletMode() {
      return mode;
   }

   /* (non-Javadoc)
    * @see javax.portlet.RenderState#getRenderParameters()
    */
   @Override
   public RenderParameters getRenderParameters() {
      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.RenderState#getWindowState()
    */
   @Override
   public WindowState getWindowState() {
      return WindowState.NORMAL;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getAttribute(java.lang.String)
    */
   @Override
   public Object getAttribute(String arg0) {
      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getAttributeNames()
    */
   @Override
   public Enumeration<String> getAttributeNames() {
      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getAuthType()
    */
   @Override
   public String getAuthType() {
      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getContextPath()
    */
   @Override
   public String getContextPath() {
      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getCookies()
    */
   @Override
   public Cookie[] getCookies() {
      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getLocale()
    */
   @Override
   public Locale getLocale() {
      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getLocales()
    */
   @Override
   public Enumeration<Locale> getLocales() {
      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getParameter(java.lang.String)
    */
   @Override
   public String getParameter(String arg0) {
      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getParameterMap()
    */
   @Override
   public Map<String, String[]> getParameterMap() {
      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getParameterNames()
    */
   @Override
   public Enumeration<String> getParameterNames() {
      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getParameterValues(java.lang.String)
    */
   @Override
   public String[] getParameterValues(String arg0) {
      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getPortalContext()
    */
   @Override
   public PortalContext getPortalContext() {
      return null;
   }

   @Override
   public PortletContext getPortletContext() {
      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getPortletSession()
    */
   @Override
   public PortletSession getPortletSession() {
      return ps;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getPortletSession(boolean)
    */
   @Override
   public PortletSession getPortletSession(boolean arg0) {
      return ps;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getPreferences()
    */
   @Override
   public PortletPreferences getPreferences() {
      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getPrivateParameterMap()
    */
   @Override
   public Map<String, String[]> getPrivateParameterMap() {
      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getProperties(java.lang.String)
    */
   @Override
   public Enumeration<String> getProperties(String arg0) {
      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getProperty(java.lang.String)
    */
   @Override
   public String getProperty(String arg0) {
      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getPropertyNames()
    */
   @Override
   public Enumeration<String> getPropertyNames() {
      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getPublicParameterMap()
    */
   @Override
   public Map<String, String[]> getPublicParameterMap() {
      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getRemoteUser()
    */
   @Override
   public String getRemoteUser() {
      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getRequestedSessionId()
    */
   @Override
   public String getRequestedSessionId() {
      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getResponseContentType()
    */
   @Override
   public String getResponseContentType() {
      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getResponseContentTypes()
    */
   @Override
   public Enumeration<String> getResponseContentTypes() {
      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getScheme()
    */
   @Override
   public String getScheme() {
      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getServerName()
    */
   @Override
   public String getServerName() {
      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getServerPort()
    */
   @Override
   public int getServerPort() {
      return 0;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getUserPrincipal()
    */
   @Override
   public Principal getUserPrincipal() {
      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getWindowID()
    */
   @Override
   public String getWindowID() {
      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#isPortletModeAllowed(javax.portlet.PortletMode)
    */
   @Override
   public boolean isPortletModeAllowed(PortletMode arg0) {
      return false;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#isRequestedSessionIdValid()
    */
   @Override
   public boolean isRequestedSessionIdValid() {
      return false;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#isSecure()
    */
   @Override
   public boolean isSecure() {
      return false;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#isUserInRole(java.lang.String)
    */
   @Override
   public boolean isUserInRole(String arg0) {
      return false;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#isWindowStateAllowed(javax.portlet.WindowState)
    */
   @Override
   public boolean isWindowStateAllowed(WindowState arg0) {
      return false;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#removeAttribute(java.lang.String)
    */
   @Override
   public void removeAttribute(String arg0) {
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#setAttribute(java.lang.String, java.lang.Object)
    */
   @Override
   public void setAttribute(String arg0, Object arg1) {
   }

   @Override
   public String getUserAgent() {
      return null;
   }

}
