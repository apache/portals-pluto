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
public class V2ResponseTests_SIG_ResourceResponse implements Portlet {
   private static final String LOG_CLASS = 
         V2ResponseTests_SIG_ResourceResponse.class.getName();
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
      ClassChecker cc = new ClassChecker(ResourceResponseWrapper.class);

      // Create result objects for the tests

      /* TestCase: ResourceResponse_SIG_implementsMimeResponse */
      /* Details: "Implements MimeResponse " */
      TestResult tr0 = tcd.getTestResultFailed(RESOURCERESPONSE_SIG_IMPLEMENTSMIMERESPONSE);
      {
         tr0.setTcSuccess(cc.implementsInterface(MimeResponse.class));
      }

      /* TestCase: ResourceResponse_SIG_fieldHTTP_STATUS_CODE */
      /* Details: "Has String field HTTP_STATUS_CODE " */
      TestResult tr1 = tcd.getTestResultFailed(RESOURCERESPONSE_SIG_FIELDHTTP_STATUS_CODE);
      {
         tr1.setTcSuccess(cc.hasField("HTTP_STATUS_CODE"));
      }

      /* TestCase: ResourceResponse_SIG_hasSetLocale */
      /* Details: "Has a setLocale(java.util.Locale)  method " */
      TestResult tr2 = tcd.getTestResultFailed(RESOURCERESPONSE_SIG_HASSETLOCALE);
      {
         String name = "setLocale";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {java.util.Locale.class};
         tr2.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: ResourceResponse_SIG_hasSetLocaleReturns */
      /* Details: "Method setLocale(java.util.Locale) returns void " */
      TestResult tr3 = tcd.getTestResultFailed(RESOURCERESPONSE_SIG_HASSETLOCALERETURNS);
      {
         String name = "setLocale";
         Class<?> retType = void.class;
         Class<?>[] parms = {java.util.Locale.class};
         tr3.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: ResourceResponse_SIG_hasSetCharacterEncoding */
      /* Details: "Has a setCharacterEncoding(String)  method " */
      TestResult tr4 = tcd.getTestResultFailed(RESOURCERESPONSE_SIG_HASSETCHARACTERENCODING);
      {
         String name = "setCharacterEncoding";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class};
         tr4.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: ResourceResponse_SIG_hasSetCharacterEncodingReturns */
      /* Details: "Method setCharacterEncoding(String) returns void " */
      TestResult tr5 = tcd.getTestResultFailed(RESOURCERESPONSE_SIG_HASSETCHARACTERENCODINGRETURNS);
      {
         String name = "setCharacterEncoding";
         Class<?> retType = void.class;
         Class<?>[] parms = {String.class};
         tr5.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: ResourceResponse_SIG_hasSetContentLength */
      /* Details: "Has a setContentLength(int)  method " */
      TestResult tr6 = tcd.getTestResultFailed(RESOURCERESPONSE_SIG_HASSETCONTENTLENGTH);
      {
         String name = "setContentLength";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {int.class};
         tr6.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: ResourceResponse_SIG_hasSetContentLengthReturns */
      /* Details: "Method setContentLength(int) returns void " */
      TestResult tr7 = tcd.getTestResultFailed(RESOURCERESPONSE_SIG_HASSETCONTENTLENGTHRETURNS);
      {
         String name = "setContentLength";
         Class<?> retType = void.class;
         Class<?>[] parms = {int.class};
         tr7.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: ResourceResponse_SIG_hasCreateRenderURL */
      /* Details: "Has a createRenderURL() throws IllegalStateException method " */
      TestResult tr8 = tcd.getTestResultFailed(RESOURCERESPONSE_SIG_HASCREATERENDERURL);
      {
         String name = "createRenderURL";
         Class<?>[] exceptions = {IllegalStateException.class};
         Class<?>[] parms = null;
         tr8.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: ResourceResponse_SIG_hasCreateRenderURLReturns */
      /* Details: "Method createRenderURL() returns PortletURL " */
      TestResult tr9 = tcd.getTestResultFailed(RESOURCERESPONSE_SIG_HASCREATERENDERURLRETURNS);
      {
         String name = "createRenderURL";
         Class<?> retType = PortletURL.class;
         Class<?>[] parms = null;
         tr9.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: ResourceResponse_SIG_hasCreateActionURL */
      /* Details: "Has a createActionURL() throws IllegalStateException method " */
      TestResult tr10 = tcd.getTestResultFailed(RESOURCERESPONSE_SIG_HASCREATEACTIONURL);
      {
         String name = "createActionURL";
         Class<?>[] exceptions = {IllegalStateException.class};
         Class<?>[] parms = null;
         tr10.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: ResourceResponse_SIG_hasCreateActionURLReturns */
      /* Details: "Method createActionURL() returns PortletURL " */
      TestResult tr11 = tcd.getTestResultFailed(RESOURCERESPONSE_SIG_HASCREATEACTIONURLRETURNS);
      {
         String name = "createActionURL";
         Class<?> retType = PortletURL.class;
         Class<?>[] parms = null;
         tr11.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: ResourceResponse_SIG_hasCreateResourceURL */
      /* Details: "Has a createResourceURL() throws IllegalStateException method " */
      TestResult tr12 = tcd.getTestResultFailed(RESOURCERESPONSE_SIG_HASCREATERESOURCEURL);
      {
         String name = "createResourceURL";
         Class<?>[] exceptions = {IllegalStateException.class};
         Class<?>[] parms = null;
         tr12.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: ResourceResponse_SIG_hasCreateResourceURLReturns */
      /* Details: "Method createResourceURL() returns ResourceURL " */
      TestResult tr13 = tcd.getTestResultFailed(RESOURCERESPONSE_SIG_HASCREATERESOURCEURLRETURNS);
      {
         String name = "createResourceURL";
         Class<?> retType = ResourceURL.class;
         Class<?>[] parms = null;
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

