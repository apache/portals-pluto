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

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Locale;

import javax.portlet.ActionURL;
import javax.portlet.CacheControl;
import javax.portlet.MimeResponse;
import javax.portlet.PortletResponse;
import javax.portlet.PortletURL;
import javax.portlet.RenderURL;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceURL;
import javax.servlet.http.Cookie;

import org.w3c.dom.DOMException;
import org.w3c.dom.Element;

/**
 * This class tests a wrapper class by simulating the class to be wrapped.The test code verifies that the arguments
 * passed to the wrapping method are correctly passed to the wrapped class. Simulated return data is passed back to the
 * caller.
 * 
 * @author nick
 */

public class ResourceResponseWrapperChecker extends WrapperChecker implements ResourceResponse {

   PortletResponse resp;
   Element         element;

   public ResourceResponseWrapperChecker(PortletResponse portletResp) {
      resp = portletResp;
      element = resp.createElement("p");
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
   public String getContentType() {
      String meth = "getContentType";
      Object[] args = {};
      String ret = "value";
      retVal = ret;
      checkArgs(meth, args);
      return ret;
   }

   @Override
   public void setContentType(String type) {
      String meth = "setContentType";
      Object[] args = { type };
      checkArgs(meth, args);
      return;

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
   public PrintWriter getWriter() throws IOException {
      String meth = "getWriter";
      Object[] args = {};
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      PrintWriter pw = new PrintWriter(baos);
      PrintWriter ret = pw;
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
   public void setBufferSize(int size) {
      String meth = "setBufferSize";
      Object[] args = { size };
      checkArgs(meth, args);
      return;

   }

   @Override
   public int getBufferSize() {
      String meth = "getBufferSize";
      Object[] args = {};
      int ret = 42;
      retVal = ret;
      checkArgs(meth, args);
      return ret;
   }

   @Override
   public void flushBuffer() throws IOException {
      String meth = "flushBuffer";
      Object[] args = {};
      checkArgs(meth, args);
      return;

   }

   @Override
   public void resetBuffer() {
      String meth = "resetBuffer";
      Object[] args = {};
      checkArgs(meth, args);
      return;

   }

   @Override
   public boolean isCommitted() {
      String meth = "isCommitted";
      Object[] args = {};
      boolean ret = true;
      retVal = ret;
      checkArgs(meth, args);
      return ret;
   }

   @Override
   public void reset() {
      String meth = "reset";
      Object[] args = {};
      checkArgs(meth, args);
      return;

   }

   @Override
   public OutputStream getPortletOutputStream() throws IOException {
      String meth = "getPortletOutputStream";
      Object[] args = {};
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      OutputStream ret = baos;
      retVal = ret;
      checkArgs(meth, args);
      return ret;
   }

   @Override
   public CacheControl getCacheControl() {
      String meth = "getCacheControl";
      Object[] args = {};
      CacheControl ret = ((MimeResponse) resp).getCacheControl();
      retVal = ret;
      checkArgs(meth, args);
      return ret;
   }

   @Override
   public void setLocale(Locale loc) {
      String meth = "setLocale";
      Object[] args = { loc };
      checkArgs(meth, args);
      return;

   }

   @Override
   public void setCharacterEncoding(String charset) {
      String meth = "setCharacterEncoding";
      Object[] args = { charset };
      checkArgs(meth, args);
      return;

   }

   @Override
   public void setContentLength(int len) {
      String meth = "setContentLength";
      Object[] args = { len };
      checkArgs(meth, args);
      return;

   }

   @SuppressWarnings("unchecked")
   @Override
   public PortletURL createRenderURL() {
      String meth = "createRenderURL";
      Object[] args = {};
      PortletURL ret = ((MimeResponse) resp).createRenderURL();
      retVal = ret;
      checkArgs(meth, args);
      return ret;
   }

   @SuppressWarnings("unchecked")
   @Override
   public PortletURL createActionURL() {
      String meth = "createActionURL";
      Object[] args = {};
      PortletURL ret = ((MimeResponse) resp).createActionURL();
      retVal = ret;
      checkArgs(meth, args);
      return ret;
   }

   @Override
   public ResourceURL createResourceURL() {
      String meth = "createResourceURL";
      Object[] args = {};
      ResourceURL ret = ((MimeResponse) resp).createResourceURL();
      retVal = ret;
      checkArgs(meth, args);
      return ret;
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
   public ActionURL createActionURL(Copy arg0) {
      return null;
   }

   @Override
   public RenderURL createRenderURL(Copy arg0) {
      return null;
   }

   @Override
   public int getStatus() {
      return 0;
   }

   @Override
   public void setContentLengthLong(long arg0) {
   }

   @Override
   public void setStatus(int arg0) {
   }

}
