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

package javax.portlet.tck.RequestTests.portlets;

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
public class V2RequestTests_SIG_ClientDataRequest implements Portlet {
   private static final String LOG_CLASS = 
         V2RequestTests_SIG_ClientDataRequest.class.getName();
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
      ClassChecker cc = new ClassChecker(ActionRequestWrapper.class);

      // Create result objects for the tests

      /* TestCase: ClientDataRequest_SIG_implementsPortletRequest */
      /* Details: "Implements PortletRequest " */
      TestResult tr0 = tcd.getTestResultFailed(CLIENTDATAREQUEST_SIG_IMPLEMENTSPORTLETREQUEST);
      {
         tr0.setTcSuccess(cc.implementsInterface(PortletRequest.class));
      }

      /* TestCase: ClientDataRequest_SIG_hasGetPortletInputStream */
      /* Details: "Has a getPortletInputStream() throws java.io.IOException method " */
      TestResult tr1 = tcd.getTestResultFailed(CLIENTDATAREQUEST_SIG_HASGETPORTLETINPUTSTREAM);
      {
         String name = "getPortletInputStream";
         Class<?>[] exceptions = {java.io.IOException.class};
         Class<?>[] parms = null;
         tr1.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: ClientDataRequest_SIG_hasGetPortletInputStreamReturns */
      /* Details: "Method getPortletInputStream() returns java.io.InputStream " */
      TestResult tr2 = tcd.getTestResultFailed(CLIENTDATAREQUEST_SIG_HASGETPORTLETINPUTSTREAMRETURNS);
      {
         String name = "getPortletInputStream";
         Class<?> retType = java.io.InputStream.class;
         Class<?>[] parms = null;
         tr2.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: ClientDataRequest_SIG_hasSetCharacterEncoding */
      /* Details: "Has a setCharacterEncoding(String) throws java.io.UnsupportedEncodingException method " */
      TestResult tr3 = tcd.getTestResultFailed(CLIENTDATAREQUEST_SIG_HASSETCHARACTERENCODING);
      {
         String name = "setCharacterEncoding";
         Class<?>[] exceptions = {java.io.UnsupportedEncodingException.class};
         Class<?>[] parms = {String.class};
         tr3.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: ClientDataRequest_SIG_hasSetCharacterEncodingReturns */
      /* Details: "Method setCharacterEncoding(String) returns void " */
      TestResult tr4 = tcd.getTestResultFailed(CLIENTDATAREQUEST_SIG_HASSETCHARACTERENCODINGRETURNS);
      {
         String name = "setCharacterEncoding";
         Class<?> retType = void.class;
         Class<?>[] parms = {String.class};
         tr4.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: ClientDataRequest_SIG_hasGetReader */
      /* Details: "Has a getReader() throws java.io.UnsupportedEncodingException, java.io.IOException method " */
      TestResult tr5 = tcd.getTestResultFailed(CLIENTDATAREQUEST_SIG_HASGETREADER);
      {
         String name = "getReader";
         Class<?>[] exceptions = {java.io.UnsupportedEncodingException.class, java.io.IOException.class};
         Class<?>[] parms = null;
         tr5.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: ClientDataRequest_SIG_hasGetReaderReturns */
      /* Details: "Method getReader() returns java.io.BufferedReader " */
      TestResult tr6 = tcd.getTestResultFailed(CLIENTDATAREQUEST_SIG_HASGETREADERRETURNS);
      {
         String name = "getReader";
         Class<?> retType = java.io.BufferedReader.class;
         Class<?>[] parms = null;
         tr6.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: ClientDataRequest_SIG_hasGetCharacterEncoding */
      /* Details: "Has a getCharacterEncoding()  method " */
      TestResult tr7 = tcd.getTestResultFailed(CLIENTDATAREQUEST_SIG_HASGETCHARACTERENCODING);
      {
         String name = "getCharacterEncoding";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr7.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: ClientDataRequest_SIG_hasGetCharacterEncodingReturns */
      /* Details: "Method getCharacterEncoding() returns String " */
      TestResult tr8 = tcd.getTestResultFailed(CLIENTDATAREQUEST_SIG_HASGETCHARACTERENCODINGRETURNS);
      {
         String name = "getCharacterEncoding";
         Class<?> retType = String.class;
         Class<?>[] parms = null;
         tr8.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: ClientDataRequest_SIG_hasGetContentType */
      /* Details: "Has a getContentType()  method " */
      TestResult tr9 = tcd.getTestResultFailed(CLIENTDATAREQUEST_SIG_HASGETCONTENTTYPE);
      {
         String name = "getContentType";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr9.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: ClientDataRequest_SIG_hasGetContentTypeReturns */
      /* Details: "Method getContentType() returns String " */
      TestResult tr10 = tcd.getTestResultFailed(CLIENTDATAREQUEST_SIG_HASGETCONTENTTYPERETURNS);
      {
         String name = "getContentType";
         Class<?> retType = String.class;
         Class<?>[] parms = null;
         tr10.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: ClientDataRequest_SIG_hasGetContentLength */
      /* Details: "Has a getContentLength()  method " */
      TestResult tr11 = tcd.getTestResultFailed(CLIENTDATAREQUEST_SIG_HASGETCONTENTLENGTH);
      {
         String name = "getContentLength";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr11.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: ClientDataRequest_SIG_hasGetContentLengthReturns */
      /* Details: "Method getContentLength() returns int " */
      TestResult tr12 = tcd.getTestResultFailed(CLIENTDATAREQUEST_SIG_HASGETCONTENTLENGTHRETURNS);
      {
         String name = "getContentLength";
         Class<?> retType = int.class;
         Class<?>[] parms = null;
         tr12.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: ClientDataRequest_SIG_hasGetMethod */
      /* Details: "Has a getMethod()  method " */
      TestResult tr13 = tcd.getTestResultFailed(CLIENTDATAREQUEST_SIG_HASGETMETHOD);
      {
         String name = "getMethod";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr13.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: ClientDataRequest_SIG_hasGetMethodReturns */
      /* Details: "Method getMethod() returns String " */
      TestResult tr14 = tcd.getTestResultFailed(CLIENTDATAREQUEST_SIG_HASGETMETHODRETURNS);
      {
         String name = "getMethod";
         Class<?> retType = String.class;
         Class<?>[] parms = null;
         tr14.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
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
      tr14.writeTo(writer);


   }

}

