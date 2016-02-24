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
public class PortletRequestWrapper extends PortletStateWrapper implements PortletRequest {


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

   /**
    * The default behavior of this method is to call 
    * <code>getAttribute(String name)</code> on the wrapped request object.
    */
   public Object getAttribute(String name) {
      return ((PortletRequest)wrapped).getAttribute(name);
   }

   /**
    * The default behavior of this method is to call 
    * <code>getAttributeNames()</code> on the wrapped request object.
    */
   public Enumeration<String> getAttributeNames() {
      return ((PortletRequest)wrapped).getAttributeNames();
   }

   /**
    * The default behavior of this method is to call 
    * <code>getAuthType()</code> on the wrapped request object.
    */
   public String getAuthType() {
      return ((PortletRequest)wrapped).getAuthType();
   }

   /**
    * The default behavior of this method is to call 
    * <code>getContextPath()</code> on the wrapped request object.
    */
   public String getContextPath() {
      return ((PortletRequest)wrapped).getContextPath();
   }

   /**
    * The default behavior of this method is to call 
    * <code>getLocale()</code> on the wrapped request object.
    */
   public Locale getLocale() {
      return ((PortletRequest)wrapped).getLocale();
   }

   /**
    * The default behavior of this method is to call 
    * <code>getLocales()</code> on the wrapped request object.
    */
   public Enumeration<Locale> getLocales() {
      return ((PortletRequest)wrapped).getLocales();
   }

   /**
    * <div class="changed_modified_3_0"> 
    * The default behavior of this method is to call 
    * <code>getRenderParameters()</code> on the wrapped request object.
    * </div>
    */
   public RenderParameters getRenderParameters() {
      return ((PortletRequest)wrapped).getRenderParameters();
   }

   /**
    * The default behavior of this method is to call 
    * <code>getParameter(String name)</code> on the wrapped request object.
    */
   @Deprecated
   public String getParameter(String name) {
      return ((PortletRequest)wrapped).getParameter(name);
   }

   /**
    * The default behavior of this method is to call 
    * <code>getParameterMap()</code> on the wrapped request object.
    */
   @Deprecated
   public Map<String, String[]> getParameterMap() {
      return ((PortletRequest)wrapped).getParameterMap();
   }

   /**
    * The default behavior of this method is to call 
    * <code>getParameterNames()</code> on the wrapped request object.
    */
   @Deprecated
   public Enumeration<String> getParameterNames() {
      return ((PortletRequest)wrapped).getParameterNames();
   }

   /**
    * The default behavior of this method is to call 
    * <code>getParameterValues(name)</code> on the wrapped request object.
    */
   @Deprecated
   public String[] getParameterValues(String name) {
      return ((PortletRequest)wrapped).getParameterValues(name);
   }

   /**
    * The default behavior of this method is to call 
    * <code>getPortalContext()</code> on the wrapped request object.
    */
   public PortalContext getPortalContext() {
      return ((PortletRequest)wrapped).getPortalContext();
   }

   /**
    * The default behavior of this method is to call 
    * <code>getPortletMode()</code> on the wrapped request object.
    */
   public PortletMode getPortletMode() {
      return ((PortletRequest)wrapped).getPortletMode();
   }

   /**
    * The default behavior of this method is to call 
    * <code>getPortletSession()</code> on the wrapped request object.
    */
   public PortletSession getPortletSession() {
      return ((PortletRequest)wrapped).getPortletSession();
   }

   /**
    * The default behavior of this method is to call 
    * <code>getPortletSession(create)</code> on the wrapped request object.
    */
   public PortletSession getPortletSession(boolean create) {
      return ((PortletRequest)wrapped).getPortletSession(create);
   }

   /**
    * The default behavior of this method is to call 
    * <code>getPreferences()</code> on the wrapped request object.
    */
   public PortletPreferences getPreferences() {
      return ((PortletRequest)wrapped).getPreferences();
   }

   /**
    * The default behavior of this method is to call 
    * <code>getProperteis(name)</code> on the wrapped request object.
    */
   public Enumeration<String> getProperties(String name) {
      return ((PortletRequest)wrapped).getProperties(name);
   }

   /**
    * The default behavior of this method is to call 
    * <code>getProperty(name)</code> on the wrapped request object.
    */
   public String getProperty(String name) {
      return ((PortletRequest)wrapped).getProperty(name);
   }

   /**
    * The default behavior of this method is to call 
    * <code>getPropertyNames()</code> on the wrapped request object.
    */
   public Enumeration<String> getPropertyNames() {
      return ((PortletRequest)wrapped).getPropertyNames();
   }

   /**
    * The default behavior of this method is to call 
    * <code>getRemoteUser()</code> on the wrapped request object.
    */
   public String getRemoteUser() {
      return ((PortletRequest)wrapped).getRemoteUser();
   }

   /**
    * The default behavior of this method is to call 
    * <code>getRequestedSessionId()</code> on the wrapped request object.
    */
   public String getRequestedSessionId() {
      return ((PortletRequest)wrapped).getRequestedSessionId();
   }

   /**
    * The default behavior of this method is to call 
    * <code>getResponseContentType()</code> on the wrapped request object.
    */
   public String getResponseContentType() {
      return ((PortletRequest)wrapped).getResponseContentType();
   }

   /**
    * The default behavior of this method is to call 
    * <code>getResponseContentTypes()</code> on the wrapped request object.
    */
   public Enumeration<String> getResponseContentTypes() {
      return ((PortletRequest)wrapped).getResponseContentTypes();
   }

   /**
    * The default behavior of this method is to call 
    * <code>getScheme()</code> on the wrapped request object.
    */
   public String getScheme() {
      return ((PortletRequest)wrapped).getScheme();
   }

   /**
    * The default behavior of this method is to call 
    * <code>getServerName()</code> on the wrapped request object.
    */
   public String getServerName() {
      return ((PortletRequest)wrapped).getServerName();
   }

   /**
    * The default behavior of this method is to call 
    * <code>getServerPort()</code> on the wrapped request object.
    */
   public int getServerPort() {
      return ((PortletRequest)wrapped).getServerPort();
   }

   /**
    * The default behavior of this method is to call 
    * <code>getUserPrincipal()</code> on the wrapped request object.
    */
   public Principal getUserPrincipal() {
      return ((PortletRequest)wrapped).getUserPrincipal();
   }

   /**
    * The default behavior of this method is to call 
    * <code>getWindowId()</code> on the wrapped request object.
    */
   public String getWindowID() {
      return ((PortletRequest)wrapped).getWindowID();
   }

   /**
    * The default behavior of this method is to call 
    * <code>getWindowState()</code> on the wrapped request object.
    */
   public WindowState getWindowState() {
      return ((PortletRequest)wrapped).getWindowState();
   }

   /**
    * The default behavior of this method is to call 
    * <code>isPortletModeAllowed(mode)</code> on the wrapped request object.
    */
   public boolean isPortletModeAllowed(PortletMode mode) {
      return ((PortletRequest)wrapped).isPortletModeAllowed(mode);
   }

   /**
    * The default behavior of this method is to call 
    * <code>isRequestedSessionIdValid()</code> on the wrapped request object.
    */
   public boolean isRequestedSessionIdValid() {
      return ((PortletRequest)wrapped).isRequestedSessionIdValid();
   }

   /**
    * The default behavior of this method is to call 
    * <code>isSecure()</code> on the wrapped request object.
    */
   public boolean isSecure() {
      return ((PortletRequest)wrapped).isSecure();
   }

   /**
    * The default behavior of this method is to call 
    * <code>isUserInRole(role)</code> on the wrapped request object.
    */
   public boolean isUserInRole(String role) {
      return ((PortletRequest)wrapped).isUserInRole(role);
   }

   /**
    * The default behavior of this method is to call 
    * <code>isWindowStateAllowed(state)</code> on the wrapped request object.
    */
   public boolean isWindowStateAllowed(WindowState state) {
      return ((PortletRequest)wrapped).isWindowStateAllowed(state);
   }

   /**
    * The default behavior of this method is to call 
    * <code>removeAttribute(name)</code> on the wrapped request object.
    */
   public void removeAttribute(String name) {
      ((PortletRequest)wrapped).removeAttribute(name);
   }

   /**
    * The default behavior of this method is to call 
    * <code>setAttribute(name, o)</code> on the wrapped request object.
    */
   public void setAttribute(String name, Object o) {
      ((PortletRequest)wrapped).setAttribute(name, o);
   }

   /**
    *  The default behavior of this method is to call 
    * <code>getCookies()</code> on the wrapped request object.
    */
   public Cookie[] getCookies() {
      return ((PortletRequest)wrapped).getCookies();
   }

   /**
    *  The default behavior of this method is to call 
    * <code>getPrivateParameterMap()</code> on the wrapped request object.
    */
   @Deprecated 
   public Map<String, String[]> getPrivateParameterMap() {
      return ((PortletRequest)wrapped).getPrivateParameterMap();
   }

   /**
    *  The default behavior of this method is to call 
    * <code>getPublicParameterMap()</code> on the wrapped request object.
    */
   @Deprecated
   public Map<String, String[]> getPublicParameterMap() {
      return ((PortletRequest)wrapped).getPublicParameterMap();
   }

}
