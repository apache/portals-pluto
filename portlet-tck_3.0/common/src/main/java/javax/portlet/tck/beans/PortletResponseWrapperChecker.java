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

import java.util.Collection;

import javax.portlet.PortletResponse;
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

public class PortletResponseWrapperChecker extends WrapperChecker implements PortletResponse {

   PortletResponse resp;
   Element         element;

   public PortletResponseWrapperChecker(PortletResponse portletResp) {
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

}
