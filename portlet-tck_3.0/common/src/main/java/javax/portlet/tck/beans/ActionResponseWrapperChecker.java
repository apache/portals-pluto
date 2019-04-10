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

import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.portlet.ActionResponse;
import javax.portlet.MimeResponse.Copy;
import javax.portlet.MutableRenderParameters;
import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.PortletResponse;
import javax.portlet.RenderURL;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;
import javax.servlet.http.Cookie;
import javax.xml.namespace.QName;

import org.w3c.dom.DOMException;
import org.w3c.dom.Element;

/**
 * This class tests a wrapper class by simulating the class to be wrapped.The test code verifies that the arguments
 * passed to the wrapping method are correctly passed to the wrapped class. Simulated return data is passed back to the
 * caller.
 * 
 * @author nick
 */

public class ActionResponseWrapperChecker extends WrapperChecker implements ActionResponse {

   PortletResponse resp;
   Element         element;

   public ActionResponseWrapperChecker(PortletResponse portletResp) {
      resp = portletResp;
      element = resp.createElement("p");
   }

   @Override
   public void setWindowState(WindowState windowState) throws WindowStateException {
      String meth = "setWindowState";
      Object[] args = { windowState };
      checkArgs(meth, args);
      return;

   }

   @Override
   public void setRenderParameters(Map<String, String[]> parameters) {
      String meth = "setRenderParameters";
      Object[] args = { parameters };
      checkArgs(meth, args);
      return;

   }

   @Override
   public void setRenderParameter(String key, String... values) {
      String meth = "setRenderParameter";
      Object[] args = { key, values };
      checkArgs(meth, args);
      return;

   }

   @Override
   public Map<String, String[]> getRenderParameterMap() {
      String meth = "getRenderParameterMap";
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
   public void removePublicRenderParameter(String name) {
      String meth = "removePublicRenderParameter";
      Object[] args = { name };
      checkArgs(meth, args);
      return;

   }

   @Override
   public void setEvent(QName arg0, Serializable arg1) {
      String meth = "setEvent";
      Object[] args = { arg0, arg1 };
      checkArgs(meth, args);
      return;

   }

   @Override
   public void setPortletMode(PortletMode portletMode) throws PortletModeException {
      String meth = "setPortletMode";
      Object[] args = { portletMode };
      checkArgs(meth, args);
      return;

   }

   @Override
   public void setRenderParameter(String key, String value) {
      String meth = "setRenderParameter";
      Object[] args = { key, value };
      checkArgs(meth, args);
      return;

   }

   @Override
   public void setEvent(String name, Serializable value) {
      String meth = "setEvent";
      Object[] args = { name, value };
      checkArgs(meth, args);
      return;

   }

   @Override
   public void addProperty(String key, String value) {
      String meth = "addProperty";
      Object[] args = { key, value };
      checkArgs(meth, args);
      return;

   }

   @Override
   public void setProperty(String key, String value) {
      String meth = "setProperty";
      Object[] args = { key, value };
      checkArgs(meth, args);
      return;

   }

   @Override
   public String encodeURL(String path) {
      String meth = "encodeURL";
      Object[] args = { path };
      String ret = "value";
      retVal = ret;
      checkArgs(meth, args);
      return ret;
   }

   @Override
   public String getNamespace() {
      String meth = "getNamespace";
      Object[] args = {};
      String ret = "value";
      retVal = ret;
      checkArgs(meth, args);
      return ret;
   }

   @Override
   public void addProperty(Cookie cookie) {
      String meth = "addProperty";
      Object[] args = { cookie };
      checkArgs(meth, args);
      return;

   }

   @Override
   public void addProperty(String key, Element element) {
      String meth = "addProperty";
      Object[] args = { key, element };
      checkArgs(meth, args);
      return;

   }

   @Override
   public Element createElement(String tagName) throws DOMException {
      String meth = "createElement";
      Object[] args = { tagName };
      Element ret = element;
      retVal = ret;
      checkArgs(meth, args);
      return ret;
   }

   @Override
   public void sendRedirect(String location) throws IOException {
      String meth = "sendRedirect";
      Object[] args = { location };
      checkArgs(meth, args);
      return;

   }

   @Override
   public void sendRedirect(String location, String renderUrlParamName) throws IOException {
      String meth = "sendRedirect";
      Object[] args = { location, renderUrlParamName };
      checkArgs(meth, args);
      return;

   }

   @Override
   public String getProperty(String arg0) {
      return null;
   }

   @Override
   public Collection<String> getPropertyNames() {
      return null;
   }

   @Override
   public Collection<String> getPropertyValues(String arg0) {
      return null;
   }

   @Override
   public MutableRenderParameters getRenderParameters() {
      return null;
   }

   @Override
   public RenderURL createRedirectURL(Copy arg0) throws IllegalStateException {
      return null;
   }

}
