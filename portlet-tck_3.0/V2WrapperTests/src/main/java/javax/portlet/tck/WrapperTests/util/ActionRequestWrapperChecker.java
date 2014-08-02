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


package javax.portlet.tck.WrapperTests.util;

import static java.util.logging.Level.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Logger;

import javax.portlet.ActionRequest;
import javax.portlet.PortalContext;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletSession;
import javax.portlet.WindowState;
import javax.servlet.http.Cookie;

/**
 * @author Scott
 *
 */
public class ActionRequestWrapperChecker extends WrapperChecker implements
      ActionRequest {
   private static final String LOG_CLASS = ActionRequestWrapperChecker.class
                                               .getName();
   private final Logger        LOGGER    = Logger.getLogger(LOG_CLASS);

   /* (non-Javadoc)
    * @see javax.portlet.ClientDataRequest#getCharacterEncoding()
    */
   @Override
   public String getCharacterEncoding() {
      LOGGER.entering(LOG_CLASS, "getCharacterEncoding");

      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.ClientDataRequest#getContentLength()
    */
   @Override
   public int getContentLength() {
      LOGGER.entering(LOG_CLASS, "getContentLength");

      return 0;
   }

   /* (non-Javadoc)
    * @see javax.portlet.ClientDataRequest#getContentType()
    */
   @Override
   public String getContentType() {
      LOGGER.entering(LOG_CLASS, "getContentType");

      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.ClientDataRequest#getMethod()
    */
   @Override
   public String getMethod() {
      LOGGER.entering(LOG_CLASS, "getMethod");

      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.ClientDataRequest#getPortletInputStream()
    */
   @Override
   public InputStream getPortletInputStream() throws IOException {
      LOGGER.entering(LOG_CLASS, "getPortletInputStream");

      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.ClientDataRequest#getReader()
    */
   @Override
   public BufferedReader getReader() throws UnsupportedEncodingException,
         IOException {
      LOGGER.entering(LOG_CLASS, "getReader");

      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.ClientDataRequest#setCharacterEncoding(java.lang.String)
    */
   @Override
   public void setCharacterEncoding(String arg0)
         throws UnsupportedEncodingException {
      LOGGER.entering(LOG_CLASS, "setCharacterEncoding");

   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getAttribute(java.lang.String)
    */
   @Override
   public Object getAttribute(String arg0) {
      LOGGER.entering(LOG_CLASS, "getAttribute");

      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getAttributeNames()
    */
   @Override
   public Enumeration<String> getAttributeNames() {
      LOGGER.entering(LOG_CLASS, "getAttributeNames");

      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getAuthType()
    */
   @Override
   public String getAuthType() {
      LOGGER.entering(LOG_CLASS, "getAuthType");

      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getContextPath()
    */
   @Override
   public String getContextPath() {
      LOGGER.entering(LOG_CLASS, "getContextPath");

      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getCookies()
    */
   @Override
   public Cookie[] getCookies() {
      LOGGER.entering(LOG_CLASS, "getCookies");

      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getLocale()
    */
   @Override
   public Locale getLocale() {
      LOGGER.entering(LOG_CLASS, "getLocale");

      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getLocales()
    */
   @Override
   public Enumeration<Locale> getLocales() {
      LOGGER.entering(LOG_CLASS, "getLocales");

      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getParameter(java.lang.String)
    */
   @Override
   public String getParameter(String arg0) {
      LOGGER.entering(LOG_CLASS, "getParameter");

      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getParameterMap()
    */
   @Override
   public Map<String, String[]> getParameterMap() {
      LOGGER.entering(LOG_CLASS, "getParameterMap");

      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getParameterNames()
    */
   @Override
   public Enumeration<String> getParameterNames() {
      LOGGER.entering(LOG_CLASS, "getParameterNames");

      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getParameterValues(java.lang.String)
    */
   @Override
   public String[] getParameterValues(String arg0) {
      LOGGER.entering(LOG_CLASS, "getParameterValues");

      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getPortalContext()
    */
   @Override
   public PortalContext getPortalContext() {
      LOGGER.entering(LOG_CLASS, "getPortalContext");

      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getPortletMode()
    */
   @Override
   public PortletMode getPortletMode() {
      LOGGER.entering(LOG_CLASS, "getPortletMode");

      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getPortletSession()
    */
   @Override
   public PortletSession getPortletSession() {
      LOGGER.entering(LOG_CLASS, "getPortletSession");

      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getPortletSession(boolean)
    */
   @Override
   public PortletSession getPortletSession(boolean arg0) {
      LOGGER.entering(LOG_CLASS, "getPortletSession");

      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getPreferences()
    */
   @Override
   public PortletPreferences getPreferences() {
      LOGGER.entering(LOG_CLASS, "getPreferences");

      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getPrivateParameterMap()
    */
   @Override
   public Map<String, String[]> getPrivateParameterMap() {
      LOGGER.entering(LOG_CLASS, "getPrivateParameterMap");

      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getProperties(java.lang.String)
    */
   @Override
   public Enumeration<String> getProperties(String arg0) {
      LOGGER.entering(LOG_CLASS, "getProperties");

      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getProperty(java.lang.String)
    */
   @Override
   public String getProperty(String arg0) {
      LOGGER.entering(LOG_CLASS, "getProperty");

      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getPropertyNames()
    */
   @Override
   public Enumeration<String> getPropertyNames() {
      LOGGER.entering(LOG_CLASS, "getPropertyNames");

      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getPublicParameterMap()
    */
   @Override
   public Map<String, String[]> getPublicParameterMap() {
      LOGGER.entering(LOG_CLASS, "getPublicParameterMap");

      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getRemoteUser()
    */
   @Override
   public String getRemoteUser() {
      LOGGER.entering(LOG_CLASS, "getRemoteUser");

      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getRequestedSessionId()
    */
   @Override
   public String getRequestedSessionId() {
      LOGGER.entering(LOG_CLASS, "getRequestedSessionId");

      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getResponseContentType()
    */
   @Override
   public String getResponseContentType() {
      LOGGER.entering(LOG_CLASS, "getResponseContentType");

      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getResponseContentTypes()
    */
   @Override
   public Enumeration<String> getResponseContentTypes() {
      LOGGER.entering(LOG_CLASS, "getResponseContentTypes");

      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getScheme()
    */
   @Override
   public String getScheme() {
      LOGGER.entering(LOG_CLASS, "getScheme");

      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getServerName()
    */
   @Override
   public String getServerName() {
      LOGGER.entering(LOG_CLASS, "getServerName");

      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getServerPort()
    */
   @Override
   public int getServerPort() {
      LOGGER.entering(LOG_CLASS, "getServerPort");

      return 0;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getUserPrincipal()
    */
   @Override
   public Principal getUserPrincipal() {
      LOGGER.entering(LOG_CLASS, "getUserPrincipal");

      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getWindowID()
    */
   @Override
   public String getWindowID() {
      LOGGER.entering(LOG_CLASS, "getWindowID");

      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#getWindowState()
    */
   @Override
   public WindowState getWindowState() {
      LOGGER.entering(LOG_CLASS, "getWindowState");

      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#isPortletModeAllowed(javax.portlet.PortletMode)
    */
   @Override
   public boolean isPortletModeAllowed(PortletMode arg0) {
      LOGGER.entering(LOG_CLASS, "isPortletModeAllowed");

      return false;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#isRequestedSessionIdValid()
    */
   @Override
   public boolean isRequestedSessionIdValid() {
      LOGGER.entering(LOG_CLASS, "isRequestedSessionIdValid");

      return false;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#isSecure()
    */
   @Override
   public boolean isSecure() {
      LOGGER.entering(LOG_CLASS, "isSecure");

      return false;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#isUserInRole(java.lang.String)
    */
   @Override
   public boolean isUserInRole(String arg0) {
      LOGGER.entering(LOG_CLASS, "isUserInRole");

      return false;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#isWindowStateAllowed(javax.portlet.WindowState)
    */
   @Override
   public boolean isWindowStateAllowed(WindowState arg0) {
      LOGGER.entering(LOG_CLASS, "isWindowStateAllowed");

      return false;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#removeAttribute(java.lang.String)
    */
   @Override
   public void removeAttribute(String arg0) {
      LOGGER.entering(LOG_CLASS, "removeAttribute");

   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletRequest#setAttribute(java.lang.String, java.lang.Object)
    */
   @Override
   public void setAttribute(String arg0, Object arg1) {
      LOGGER.entering(LOG_CLASS, "setAttribute");

   }

}
