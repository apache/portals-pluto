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

package javax.portlet.tck.ResponseTests.portlets;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.Enumeration;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.portlet.*;
import javax.portlet.filter.*;
import javax.portlet.tck.beans.ClassChecker;
import javax.portlet.tck.beans.TestCaseDetails;
import javax.portlet.tck.beans.JSR286ApiTestCaseDetails;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.*;
import javax.portlet.tck.beans.TestResult;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the 
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 */
public class V2ResponseTests_SIG_PortletResponse implements Portlet {
   private static final String LOG_CLASS = 
         V2ResponseTests_SIG_PortletResponse.class.getName();
   private final Logger LOGGER = Logger.getLogger(LOG_CLASS);
   
   private PortletConfig portletConfig = null;

   @Override
   public void init(PortletConfig config) throws PortletException {
      this.portletConfig = config;
   }

   @Override
   public void destroy() {
   }

   @Override
   public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
         throws PortletException, IOException {
   }

   @Override
   public void render(RenderRequest renderRequest, RenderResponse renderResponse)
         throws PortletException, IOException {
      
      if (LOGGER.isLoggable(Level.FINE)) {
         LOGGER.logp(Level.FINE, LOG_CLASS, "render", "Entry");
      }

      PrintWriter writer = renderResponse.getWriter();
      JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();
      ClassChecker cc = new ClassChecker(renderResponse.getClass());

      // Create result objects for the tests

      /* TestCase: PortletResponse_SIG_hasAddProperty */
      /* Details: "Has a addProperty(String, String)  method " */
      TestResult tr0 = tcd.getTestResultFailed(PORTLETRESPONSE_SIG_HASADDPROPERTY);
      {
         String name = "addProperty";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class, String.class};
         tr0.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletResponse_SIG_hasAddPropertyReturns */
      /* Details: "Method addProperty(String, String) returns void " */
      TestResult tr1 = tcd.getTestResultFailed(PORTLETRESPONSE_SIG_HASADDPROPERTYRETURNS);
      {
         String name = "addProperty";
         Class<?> retType = void.class;
         Class<?>[] parms = {String.class, String.class};
         tr1.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletResponse_SIG_hasSetProperty */
      /* Details: "Has a setProperty(String, String)  method " */
      TestResult tr2 = tcd.getTestResultFailed(PORTLETRESPONSE_SIG_HASSETPROPERTY);
      {
         String name = "setProperty";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class, String.class};
         tr2.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletResponse_SIG_hasSetPropertyReturns */
      /* Details: "Method setProperty(String, String) returns void " */
      TestResult tr3 = tcd.getTestResultFailed(PORTLETRESPONSE_SIG_HASSETPROPERTYRETURNS);
      {
         String name = "setProperty";
         Class<?> retType = void.class;
         Class<?>[] parms = {String.class, String.class};
         tr3.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletResponse_SIG_hasEncodeURL */
      /* Details: "Has a encodeURL(String)  method " */
      TestResult tr4 = tcd.getTestResultFailed(PORTLETRESPONSE_SIG_HASENCODEURL);
      {
         String name = "encodeURL";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class};
         tr4.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletResponse_SIG_hasEncodeURLReturns */
      /* Details: "Method encodeURL(String) returns String " */
      TestResult tr5 = tcd.getTestResultFailed(PORTLETRESPONSE_SIG_HASENCODEURLRETURNS);
      {
         String name = "encodeURL";
         Class<?> retType = String.class;
         Class<?>[] parms = {String.class};
         tr5.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletResponse_SIG_hasGetNamespace */
      /* Details: "Has a getNamespace()  method " */
      TestResult tr6 = tcd.getTestResultFailed(PORTLETRESPONSE_SIG_HASGETNAMESPACE);
      {
         String name = "getNamespace";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr6.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletResponse_SIG_hasGetNamespaceReturns */
      /* Details: "Method getNamespace() returns String " */
      TestResult tr7 = tcd.getTestResultFailed(PORTLETRESPONSE_SIG_HASGETNAMESPACERETURNS);
      {
         String name = "getNamespace";
         Class<?> retType = String.class;
         Class<?>[] parms = null;
         tr7.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletResponse_SIG_hasAddPropertyA */
      /* Details: "Has a addProperty(javax.servlet.http.Cookie)  method " */
      TestResult tr8 = tcd.getTestResultFailed(PORTLETRESPONSE_SIG_HASADDPROPERTYA);
      {
         String name = "addProperty";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {javax.servlet.http.Cookie.class};
         tr8.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletResponse_SIG_hasAddPropertyReturnsA */
      /* Details: "Method addProperty(javax.servlet.http.Cookie) returns void " */
      TestResult tr9 = tcd.getTestResultFailed(PORTLETRESPONSE_SIG_HASADDPROPERTYRETURNSA);
      {
         String name = "addProperty";
         Class<?> retType = void.class;
         Class<?>[] parms = {javax.servlet.http.Cookie.class};
         tr9.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletResponse_SIG_hasAddPropertyB */
      /* Details: "Has a addProperty(String, org.w3c.dom.Element)  method " */
      TestResult tr10 = tcd.getTestResultFailed(PORTLETRESPONSE_SIG_HASADDPROPERTYB);
      {
         String name = "addProperty";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class, org.w3c.dom.Element.class};
         tr10.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletResponse_SIG_hasAddPropertyReturnsB */
      /* Details: "Method addProperty(String, org.w3c.dom.Element) returns void " */
      TestResult tr11 = tcd.getTestResultFailed(PORTLETRESPONSE_SIG_HASADDPROPERTYRETURNSB);
      {
         String name = "addProperty";
         Class<?> retType = void.class;
         Class<?>[] parms = {String.class, org.w3c.dom.Element.class};
         tr11.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletResponse_SIG_hasCreateElement */
      /* Details: "Has a createElement(String) throws org.w3c.dom.DOMException method " */
      TestResult tr12 = tcd.getTestResultFailed(PORTLETRESPONSE_SIG_HASCREATEELEMENT);
      {
         String name = "createElement";
         Class<?>[] exceptions = {org.w3c.dom.DOMException.class};
         Class<?>[] parms = {String.class};
         tr12.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletResponse_SIG_hasCreateElementReturns */
      /* Details: "Method createElement(String) returns org.w3c.dom.Element " */
      TestResult tr13 = tcd.getTestResultFailed(PORTLETRESPONSE_SIG_HASCREATEELEMENTRETURNS);
      {
         String name = "createElement";
         Class<?> retType = org.w3c.dom.Element.class;
         Class<?>[] parms = {String.class};
         tr13.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }



      // Write the results to the output stream

      tr0.writeTo(writer);
      tr1.writeTo(writer);
      tr2.writeTo(writer);
      tr3.writeTo(writer);
      tr4.writeTo(writer);
      tr5.writeTo(writer);
      tr6.writeTo(writer);
      tr7.writeTo(writer);
      tr8.writeTo(writer);
      tr9.writeTo(writer);
      tr10.writeTo(writer);
      tr11.writeTo(writer);
      tr12.writeTo(writer);
      tr13.writeTo(writer);


   }

}

