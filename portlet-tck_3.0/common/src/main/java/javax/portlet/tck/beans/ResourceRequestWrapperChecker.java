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
package javax.portlet.tck.beans;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortalContext;
import javax.portlet.PortletAsyncContext;
import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.portlet.RenderParameters;
import javax.portlet.ResourceParameters;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.WindowState;
import javax.servlet.DispatcherType;
import javax.servlet.http.Cookie;
import javax.servlet.http.Part;

/**
 * This class tests a wrapper class by simulating the class to be wrapped.The test code verifies that the arguments
 * passed to the wrapping method are correctly passed to the wrapped class. Simulated return data is passed back to the
 * caller.
 * 
 * @author nick
 */

public class ResourceRequestWrapperChecker extends WrapperChecker implements ResourceRequest {

   private PortletRequest     req;
   private PortletSession     sess;
   private PortletPreferences prefs;
   private PortalContext      pcntxt;
   private Principal          ppal;

   public ResourceRequestWrapperChecker(PortletRequest portletReq) {
      req = portletReq;
      sess = req.getPortletSession();
      prefs = req.getPreferences();
      pcntxt = req.getPortalContext();
      ppal = req.getUserPrincipal();
   }

   @Override
   public InputStream getPortletInputStream() throws IOException {
      String meth = "getPortletInputStream";
      Object[] args = {};
      byte[] bytes = "Hi there!".getBytes();
      ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
      InputStream ret = bais;
      retVal = ret;
      checkArgs(meth, args);
      return ret;
   }

   @Override
   public void setCharacterEncoding(String enc) throws UnsupportedEncodingException {
      String meth = "setCharacterEncoding";
      Object[] args = { enc };
      checkArgs(meth, args);
      return;

   }

   @Override
   public BufferedReader getReader() throws UnsupportedEncodingException, IOException {
      String meth = "getReader";
      Object[] args = {};
      StringReader rdr = new StringReader("Hi there!");
      BufferedReader br = new BufferedReader(rdr);
      BufferedReader ret = br;
      retVal = ret;
      checkArgs(meth, args);
      return ret;
   }

   @Override
   public String getCharacterEncoding() {
      String meth = "getCharacterEncoding";
      Object[] args = {};
      String ret = "value";
      retVal = ret;
      checkArgs(meth, args);
      return ret;
   }

   @Override
   public String getContentType() {
      String meth = "getContentType";
      Object[] args = {};
      String ret = "value";
      retVal = ret;
      checkArgs(meth, args);
      return ret;
   }

   @Override
   public int getContentLength() {
      String meth = "getContentLength";
      Object[] args = {};
      int ret = 42;
      retVal = ret;
      checkArgs(meth, args);
      return ret;
   }

   @Override
   public String getMethod() {
      String meth = "getMethod";
      Object[] args = {};
      String ret = "value";
      retVal = ret;
      checkArgs(meth, args);
      return ret;
   }

   @Override
   public boolean isWindowStateAllowed(WindowState state) {
      String meth = "isWindowStateAllowed";
      Object[] args = { state };
      boolean ret = true;
      retVal = ret;
      checkArgs(meth, args);
      return ret;
   }

   @Override
   public boolean isPortletModeAllowed(PortletMode mode) {
      String meth = "isPortletModeAllowed";
      Object[] args = { mode };
      boolean ret = true;
      retVal = ret;
      checkArgs(meth, args);
      return ret;
   }

   @Override
   public PortletMode getPortletMode() {
      String meth = "getPortletMode";
      Object[] args = {};
      PortletMode ret = PortletMode.EDIT;
      retVal = ret;
      checkArgs(meth, args);
      return ret;
   }

   @Override
   public WindowState getWindowState() {
      String meth = "getWindowState";
      Object[] args = {};
      WindowState ret = WindowState.NORMAL;
      retVal = ret;
      checkArgs(meth, args);
      return ret;
   }

   @Override
   public PortletPreferences getPreferences() {
      String meth = "getPreferences";
      Object[] args = {};
      PortletPreferences ret = prefs;
      retVal = ret;
      checkArgs(meth, args);
      return ret;
   }

   @Override
   public PortletSession getPortletSession() {
      String meth = "getPortletSession";
      Object[] args = {};
      PortletSession ret = sess;
      retVal = ret;
      checkArgs(meth, args);
      return ret;
   }

   @Override
   public PortletSession getPortletSession(boolean create) {
      String meth = "getPortletSession";
      Object[] args = { create };
      PortletSession ret = sess;
      retVal = ret;
      checkArgs(meth, args);
      return ret;
   }

   @Override
   public String getProperty(String name) {
      String meth = "getProperty";
      Object[] args = { name };
      String ret = "value";
      retVal = ret;
      checkArgs(meth, args);
      return ret;
   }

   @Override
   public Enumeration<String> getProperties(String name) {
      String meth = "getProperties";
      Object[] args = { name };
      String[] strs = { "val1", "val2" };
      Enumeration<String> ret = Collections.enumeration(Arrays.asList(strs));
      retVal = ret;
      checkArgs(meth, args);
      return ret;
   }

   @Override
   public Enumeration<String> getPropertyNames() {
      String meth = "getPropertyNames";
      Object[] args = {};
      String[] strs = { "val1", "val2" };
      Enumeration<String> ret = Collections.enumeration(Arrays.asList(strs));
      retVal = ret;
      checkArgs(meth, args);
      return ret;
   }

   @Override
   public PortalContext getPortalContext() {
      String meth = "getPortalContext";
      Object[] args = {};
      PortalContext ret = pcntxt;
      retVal = ret;
      checkArgs(meth, args);
      return ret;
   }

   @Override
   public String getAuthType() {
      String meth = "getAuthType";
      Object[] args = {};
      String ret = "value";
      retVal = ret;
      checkArgs(meth, args);
      return ret;
   }

   @Override
   public String getContextPath() {
      String meth = "getContextPath";
      Object[] args = {};
      String ret = "value";
      retVal = ret;
      checkArgs(meth, args);
      return ret;
   }

   @Override
   public String getRemoteUser() {
      String meth = "getRemoteUser";
      Object[] args = {};
      String ret = "value";
      retVal = ret;
      checkArgs(meth, args);
      return ret;
   }

   @Override
   public Principal getUserPrincipal() {
      String meth = "getUserPrincipal";
      Object[] args = {};
      Principal ret = ppal;
      retVal = ret;
      checkArgs(meth, args);
      return ret;
   }

   @Override
   public boolean isUserInRole(String role) {
      String meth = "isUserInRole";
      Object[] args = { role };
      boolean ret = true;
      retVal = ret;
      checkArgs(meth, args);
      return ret;
   }

   @Override
   public Object getAttribute(String name) {
      String meth = "getAttribute";
      Object[] args = { name };
      Object ret = "object";
      retVal = ret;
      checkArgs(meth, args);
      return ret;
   }

   @Override
   public Enumeration<String> getAttributeNames() {
      String meth = "getAttributeNames";
      Object[] args = {};
      String[] strs = { "val1", "val2" };
      Enumeration<String> ret = Collections.enumeration(Arrays.asList(strs));
      retVal = ret;
      checkArgs(meth, args);
      return ret;
   }

   @Override
   public String getParameter(String name) {
      String meth = "getParameter";
      Object[] args = { name };
      String ret = "value";
      retVal = ret;
      checkArgs(meth, args);
      return ret;
   }

   @Override
   public Enumeration<String> getParameterNames() {
      String meth = "getParameterNames";
      Object[] args = {};
      String[] strs = { "val1", "val2" };
      Enumeration<String> ret = Collections.enumeration(Arrays.asList(strs));
      retVal = ret;
      checkArgs(meth, args);
      return ret;
   }

   @Override
   public String[] getParameterValues(String name) {
      String meth = "getParameterValues";
      Object[] args = { name };
      String[] ret = { "val1", "val2" };
      retVal = ret;
      checkArgs(meth, args);
      return ret;
   }

   @Override
   public Map<String, String[]> getParameterMap() {
      String meth = "getParameterMap";
      Object[] args = {};
      Map<String, String[]> parms = new HashMap<String, String[]>();
      parms.put("parm1", new String[] { "val1", "val2" });
      parms.put("parm2", new String[] { "val1", "val2" });
      Map<String, String[]> ret = parms;
      retVal = ret;
      checkArgs(meth, args);
      return ret;
   }

   @Override
   public boolean isSecure() {
      String meth = "isSecure";
      Object[] args = {};
      boolean ret = true;
      retVal = ret;
      checkArgs(meth, args);
      return ret;
   }

   @Override
   public void setAttribute(String name, Object o) {
      String meth = "setAttribute";
      Object[] args = { name, o };
      checkArgs(meth, args);
      return;

   }

   @Override
   public void removeAttribute(String name) {
      String meth = "removeAttribute";
      Object[] args = { name };
      checkArgs(meth, args);
      return;

   }

   @Override
   public String getRequestedSessionId() {
      String meth = "getRequestedSessionId";
      Object[] args = {};
      String ret = "value";
      retVal = ret;
      checkArgs(meth, args);
      return ret;
   }

   @Override
   public boolean isRequestedSessionIdValid() {
      String meth = "isRequestedSessionIdValid";
      Object[] args = {};
      boolean ret = true;
      retVal = ret;
      checkArgs(meth, args);
      return ret;
   }

   @Override
   public String getResponseContentType() {
      String meth = "getResponseContentType";
      Object[] args = {};
      String ret = "value";
      retVal = ret;
      checkArgs(meth, args);
      return ret;
   }

   @Override
   public Enumeration<String> getResponseContentTypes() {
      String meth = "getResponseContentTypes";
      Object[] args = {};
      String[] strs = { "val1", "val2" };
      Enumeration<String> ret = Collections.enumeration(Arrays.asList(strs));
      retVal = ret;
      checkArgs(meth, args);
      return ret;
   }

   @Override
   public Locale getLocale() {
      String meth = "getLocale";
      Object[] args = {};
      Locale ret = new Locale("en");
      retVal = ret;
      checkArgs(meth, args);
      return ret;
   }

   @Override
   public Enumeration<Locale> getLocales() {
      String meth = "getLocales";
      Object[] args = {};
      Locale[] la = { new Locale("en"), new Locale("de") };
      Enumeration<Locale> ret = Collections.enumeration(Arrays.asList(la));
      retVal = ret;
      checkArgs(meth, args);
      return ret;
   }

   @Override
   public String getScheme() {
      String meth = "getScheme";
      Object[] args = {};
      String ret = "value";
      retVal = ret;
      checkArgs(meth, args);
      return ret;
   }

   @Override
   public String getServerName() {
      String meth = "getServerName";
      Object[] args = {};
      String ret = "value";
      retVal = ret;
      checkArgs(meth, args);
      return ret;
   }

   @Override
   public int getServerPort() {
      String meth = "getServerPort";
      Object[] args = {};
      int ret = 42;
      retVal = ret;
      checkArgs(meth, args);
      return ret;
   }

   @Override
   public String getWindowID() {
      String meth = "getWindowID";
      Object[] args = {};
      String ret = "value";
      retVal = ret;
      checkArgs(meth, args);
      return ret;
   }

   @Override
   public Cookie[] getCookies() {
      String meth = "getCookies";
      Object[] args = {};
      Cookie[] ret = { new Cookie("name", "Bob"), new Cookie("name", "Alice") };
      retVal = ret;
      checkArgs(meth, args);
      return ret;
   }

   @Override
   public Map<String, String[]> getPrivateParameterMap() {
      String meth = "getPrivateParameterMap";
      Object[] args = {};
      Map<String, String[]> parms = new HashMap<String, String[]>();
      parms.put("parm1", new String[] { "val1", "val2" });
      parms.put("parm2", new String[] { "val1", "val2" });
      Map<String, String[]> ret = parms;
      retVal = ret;
      checkArgs(meth, args);
      return ret;
   }

   @Override
   public Map<String, String[]> getPublicParameterMap() {
      String meth = "getPublicParameterMap";
      Object[] args = {};
      Map<String, String[]> parms = new HashMap<String, String[]>();
      parms.put("parm1", new String[] { "val1", "val2" });
      parms.put("parm2", new String[] { "val1", "val2" });
      Map<String, String[]> ret = parms;
      retVal = ret;
      checkArgs(meth, args);
      return ret;
   }

   @Override
   public String getETag() {
      String meth = "getETag";
      Object[] args = {};
      String ret = "value";
      retVal = ret;
      checkArgs(meth, args);
      return ret;
   }

   @Override
   public String getResourceID() {
      String meth = "getResourceID";
      Object[] args = {};
      String ret = "value";
      retVal = ret;
      checkArgs(meth, args);
      return ret;
   }

   @Override
   public Map<String, String[]> getPrivateRenderParameterMap() {
      String meth = "getPrivateRenderParameterMap";
      Object[] args = {};
      Map<String, String[]> parms = new HashMap<String, String[]>();
      parms.put("parm1", new String[] { "val1", "val2" });
      parms.put("parm2", new String[] { "val1", "val2" });
      Map<String, String[]> ret = parms;
      retVal = ret;
      checkArgs(meth, args);
      return ret;
   }

   @Override
   public String getCacheability() {
      String meth = "getCacheability";
      Object[] args = {};
      String ret = "value";
      retVal = ret;
      checkArgs(meth, args);
      return ret;
   }

   @Override
   public long getContentLengthLong() {
      return 0;
   }

   @Override
   public Part getPart(String arg0) throws IOException, PortletException {
      return null;
   }

   @Override
   public Collection<Part> getParts() throws IOException, PortletException {
      return null;
   }

   @Override
   public PortletContext getPortletContext() {
      return null;
   }

   @Override
   public String getUserAgent() {
      return null;
   }

   @Override
   public RenderParameters getRenderParameters() {
      return null;
   }

   @Override
   public DispatcherType getDispatcherType() {
      return null;
   }

   @Override
   public PortletAsyncContext getPortletAsyncContext() {
      return null;
   }

   @Override
   public ResourceParameters getResourceParameters() {
      return null;
   }

   @Override
   public boolean isAsyncStarted() {
      return false;
   }

   @Override
   public boolean isAsyncSupported() {
      return false;
   }

   @Override
   public PortletAsyncContext startPortletAsync() throws IllegalStateException {
      return null;
   }

   @Override
   public PortletAsyncContext startPortletAsync(ResourceRequest arg0, ResourceResponse arg1) throws IllegalStateException {
      return null;
   }

}
