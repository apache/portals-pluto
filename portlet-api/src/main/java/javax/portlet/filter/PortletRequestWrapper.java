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

/*
 * This source code implements specifications defined by the Java
 * Community Process. In order to remain compliant with the specification
 * DO NOT add / change / or delete method signatures!
 */

package javax.portlet.filter;

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
 * <span class="changed_modified_3_0">The</span> 
 * <code>PortletRequestWrapper</code> provides a convenient 
 * implementation of the <code>PortletRequest</code> interface 
 * and is extended by other request wrappers.
 * This class implements the Wrapper or Decorator pattern. 
 * Methods default to calling through to the wrapped request object.
 *
 * @since 2.0
 * @see PortletRequest
 */
public class PortletRequestWrapper extends RenderStateWrapper implements PortletRequest {


   /**
    * Creates an <code>PortletRequest</code> adaptor 
    * wrapping the given request object.
    * 
    * @param request  the portlet request to wrap
    * @throws java.lang.IllegalArgumentException if the request is <code>null</code>
    */
   public PortletRequestWrapper(PortletRequest request) {
      super(request);
   }

   /**
    * Return the wrapped request object.
    * 
    * @return the wrapped request
    */
   public PortletRequest getRequest() {
      return (PortletRequest) super.getWrapped();
   }

   /**
    * Sets the request object being wrapped.
    * 
    * @param request the request to set
    * @throws java.lang.IllegalArgumentException   if the request is null.
    */
   public void setRequest(PortletRequest request) {
      super.setWrapped(request);
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getAttribute(java.lang.String)
    */
   @Override
   public Object getAttribute(String name) {
      return ((PortletRequest)wrapped).getAttribute(name);
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getAttributeNames()
    */
   @Override
   public Enumeration<String> getAttributeNames() {
      return ((PortletRequest)wrapped).getAttributeNames();
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getAuthType()
    */
   @Override
   public String getAuthType() {
      return ((PortletRequest)wrapped).getAuthType();
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getContextPath()
    */
   @Override
   public String getContextPath() {
      return ((PortletRequest)wrapped).getContextPath();
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getLocale()
    */
   @Override
   public Locale getLocale() {
      return ((PortletRequest)wrapped).getLocale();
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getLocales()
    */
   @Override
   public Enumeration<Locale> getLocales() {
      return ((PortletRequest)wrapped).getLocales();
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getRenderParameters()
    */
   @Override
   public RenderParameters getRenderParameters() {
      return ((PortletRequest)wrapped).getRenderParameters();
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getParameter(java.lang.String)
    */
   @Deprecated
   @Override
   public String getParameter(String name) {
      return ((PortletRequest)wrapped).getParameter(name);
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getParameterMap()
    */
   @Deprecated
   @Override
   public Map<String, String[]> getParameterMap() {
      return ((PortletRequest)wrapped).getParameterMap();
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getParameterNames()
    */
   @Deprecated
   @Override
   public Enumeration<String> getParameterNames() {
      return ((PortletRequest)wrapped).getParameterNames();
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getParameterValues(java.lang.String)
    */
   @Deprecated
   @Override
   public String[] getParameterValues(String name) {
      return ((PortletRequest)wrapped).getParameterValues(name);
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getPortalContext()
    */
   @Override
   public PortalContext getPortalContext() {
      return ((PortletRequest)wrapped).getPortalContext();
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getPortletContext()
    */
   @Override
   public PortletContext getPortletContext() {
      return ((PortletRequest)wrapped).getPortletContext();
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getPortletMode()
    */
   @Override
   public PortletMode getPortletMode() {
      return ((PortletRequest)wrapped).getPortletMode();
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getPortletSession()
    */
   @Override
   public PortletSession getPortletSession() {
      return ((PortletRequest)wrapped).getPortletSession();
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getPortletSession(boolean)
    */
   @Override
   public PortletSession getPortletSession(boolean create) {
      return ((PortletRequest)wrapped).getPortletSession(create);
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getPreferences()
    */
   @Override
   public PortletPreferences getPreferences() {
      return ((PortletRequest)wrapped).getPreferences();
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getProperties(java.lang.String)
    */
   @Override
   public Enumeration<String> getProperties(String name) {
      return ((PortletRequest)wrapped).getProperties(name);
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getProperty(java.lang.String)
    */
   @Override
   public String getProperty(String name) {
      return ((PortletRequest)wrapped).getProperty(name);
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getPropertyNames()
    */
   @Override
   public Enumeration<String> getPropertyNames() {
      return ((PortletRequest)wrapped).getPropertyNames();
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getRemoteUser()
    */
   @Override
   public String getRemoteUser() {
      return ((PortletRequest)wrapped).getRemoteUser();
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getRequestedSessionId()
    */
   @Override
   public String getRequestedSessionId() {
      return ((PortletRequest)wrapped).getRequestedSessionId();
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getResponseContentType()
    */
   @Override
   public String getResponseContentType() {
      return ((PortletRequest)wrapped).getResponseContentType();
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getResponseContentTypes()
    */
   @Override
   public Enumeration<String> getResponseContentTypes() {
      return ((PortletRequest)wrapped).getResponseContentTypes();
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getScheme()
    */
   @Override
   public String getScheme() {
      return ((PortletRequest)wrapped).getScheme();
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getServerName()
    */
   @Override
   public String getServerName() {
      return ((PortletRequest)wrapped).getServerName();
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getServerPort()
    */
   @Override
   public int getServerPort() {
      return ((PortletRequest)wrapped).getServerPort();
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getUserPrincipal()
    */
   @Override
   public Principal getUserPrincipal() {
      return ((PortletRequest)wrapped).getUserPrincipal();
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getWindowID()
    */
   @Override
   public String getWindowID() {
      return ((PortletRequest)wrapped).getWindowID();
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getWindowState()
    */
   @Override
   public WindowState getWindowState() {
      return ((PortletRequest)wrapped).getWindowState();
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#isPortletModeAllowed(javax.portlet.PortletMode)
    */
   @Override
   public boolean isPortletModeAllowed(PortletMode mode) {
      return ((PortletRequest)wrapped).isPortletModeAllowed(mode);
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#isRequestedSessionIdValid()
    */
   @Override
   public boolean isRequestedSessionIdValid() {
      return ((PortletRequest)wrapped).isRequestedSessionIdValid();
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#isSecure()
    */
   @Override
   public boolean isSecure() {
      return ((PortletRequest)wrapped).isSecure();
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#isUserInRole(java.lang.String)
    */
   @Override
   public boolean isUserInRole(String role) {
      return ((PortletRequest)wrapped).isUserInRole(role);
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#isWindowStateAllowed(javax.portlet.WindowState)
    */
   @Override
   public boolean isWindowStateAllowed(WindowState state) {
      return ((PortletRequest)wrapped).isWindowStateAllowed(state);
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#removeAttribute(java.lang.String)
    */
   @Override
   public void removeAttribute(String name) {
      ((PortletRequest)wrapped).removeAttribute(name);
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#setAttribute(java.lang.String, java.lang.Object)
    */
   @Override
   public void setAttribute(String name, Object o) {
      ((PortletRequest)wrapped).setAttribute(name, o);
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getCookies()
    */
   @Override
   public Cookie[] getCookies() {
      return ((PortletRequest)wrapped).getCookies();
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getPrivateParameterMap()
    */
   @Deprecated 
   @Override
   public Map<String, String[]> getPrivateParameterMap() {
      return ((PortletRequest)wrapped).getPrivateParameterMap();
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getPublicParameterMap()
    */
   @Deprecated
   @Override
   public Map<String, String[]> getPublicParameterMap() {
      return ((PortletRequest)wrapped).getPublicParameterMap();
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getUserAgent()
    */
   @Override
   public String getUserAgent() {
      return ((PortletRequest)wrapped).getUserAgent();
   }

}
