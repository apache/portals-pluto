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

package javax.portlet.tck.WrapperTests.portlets;

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
public class V2WrapperTests_SIG_ResourceRequestWrapper implements Portlet {
   private static final String LOG_CLASS = 
         V2WrapperTests_SIG_ResourceRequestWrapper.class.getName();
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
      ClassChecker cc = new ClassChecker(ResourceRequestWrapper.class);

      // Create result objects for the tests

      /* TestCase: ResourceRequestWrapper_SIG_extendsPortletRequestWrapper */
      /* Details: "Extends PortletRequestWrapper " */
      TestResult tr0 = tcd.getTestResultFailed(RESOURCEREQUESTWRAPPER_SIG_EXTENDSPORTLETREQUESTWRAPPER);
      {
         tr0.setTcSuccess(cc.hasSuperclass(PortletRequestWrapper.class));
      }

      /* TestCase: ResourceRequestWrapper_SIG_implementsResourceRequest */
      /* Details: "Implements ResourceRequest " */
      TestResult tr1 = tcd.getTestResultFailed(RESOURCEREQUESTWRAPPER_SIG_IMPLEMENTSRESOURCEREQUEST);
      {
         tr1.setTcSuccess(cc.implementsInterface(ResourceRequest.class));
      }

      /* TestCase: ResourceRequestWrapper_SIG_constructor */
      /* Details: "Provides constructor ResourceRequestWrapper(ResourceRequest) " */
      TestResult tr2 = tcd.getTestResultFailed(RESOURCEREQUESTWRAPPER_SIG_CONSTRUCTOR);
      {
         Class<?>[] parms = {ResourceRequest.class};
         tr2.setTcSuccess(cc.hasConstructor(parms));
      }

      /* TestCase: ResourceRequestWrapper_SIG_hasGetPortletInputStream */
      /* Details: "Has a getPortletInputStream() throws java.io.IOException method " */
      TestResult tr3 = tcd.getTestResultFailed(RESOURCEREQUESTWRAPPER_SIG_HASGETPORTLETINPUTSTREAM);
      {
         String name = "getPortletInputStream";
         Class<?>[] exceptions = {java.io.IOException.class};
         Class<?>[] parms = null;
         tr3.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: ResourceRequestWrapper_SIG_hasGetPortletInputStreamReturns */
      /* Details: "Method getPortletInputStream() returns java.io.InputStream " */
      TestResult tr4 = tcd.getTestResultFailed(RESOURCEREQUESTWRAPPER_SIG_HASGETPORTLETINPUTSTREAMRETURNS);
      {
         String name = "getPortletInputStream";
         Class<?> retType = java.io.InputStream.class;
         Class<?>[] parms = null;
         tr4.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: ResourceRequestWrapper_SIG_hasGetReader */
      /* Details: "Has a getReader() throws java.io.UnsupportedEncodingException, java.io.IOException method " */
      TestResult tr5 = tcd.getTestResultFailed(RESOURCEREQUESTWRAPPER_SIG_HASGETREADER);
      {
         String name = "getReader";
         Class<?>[] exceptions = {java.io.UnsupportedEncodingException.class, java.io.IOException.class};
         Class<?>[] parms = null;
         tr5.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: ResourceRequestWrapper_SIG_hasGetReaderReturns */
      /* Details: "Method getReader() returns java.io.BufferedReader " */
      TestResult tr6 = tcd.getTestResultFailed(RESOURCEREQUESTWRAPPER_SIG_HASGETREADERRETURNS);
      {
         String name = "getReader";
         Class<?> retType = java.io.BufferedReader.class;
         Class<?>[] parms = null;
         tr6.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: ResourceRequestWrapper_SIG_hasSetCharacterEncoding */
      /* Details: "Has a setCharacterEncoding(String) throws java.io.UnsupportedEncodingException method " */
      TestResult tr7 = tcd.getTestResultFailed(RESOURCEREQUESTWRAPPER_SIG_HASSETCHARACTERENCODING);
      {
         String name = "setCharacterEncoding";
         Class<?>[] exceptions = {java.io.UnsupportedEncodingException.class};
         Class<?>[] parms = {String.class};
         tr7.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: ResourceRequestWrapper_SIG_hasSetCharacterEncodingReturns */
      /* Details: "Method setCharacterEncoding(String) returns void " */
      TestResult tr8 = tcd.getTestResultFailed(RESOURCEREQUESTWRAPPER_SIG_HASSETCHARACTERENCODINGRETURNS);
      {
         String name = "setCharacterEncoding";
         Class<?> retType = void.class;
         Class<?>[] parms = {String.class};
         tr8.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: ResourceRequestWrapper_SIG_hasGetRequest */
      /* Details: "Has a getRequest()  method " */
      TestResult tr9 = tcd.getTestResultFailed(RESOURCEREQUESTWRAPPER_SIG_HASGETREQUEST);
      {
         String name = "getRequest";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr9.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: ResourceRequestWrapper_SIG_hasGetRequestReturns */
      /* Details: "Method getRequest() returns ResourceRequest " */
      TestResult tr10 = tcd.getTestResultFailed(RESOURCEREQUESTWRAPPER_SIG_HASGETREQUESTRETURNS);
      {
         String name = "getRequest";
         Class<?> retType = ResourceRequest.class;
         Class<?>[] parms = null;
         tr10.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: ResourceRequestWrapper_SIG_hasSetRequest */
      /* Details: "Has a setRequest(ResourceRequest)  method " */
      TestResult tr11 = tcd.getTestResultFailed(RESOURCEREQUESTWRAPPER_SIG_HASSETREQUEST);
      {
         String name = "setRequest";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {ResourceRequest.class};
         tr11.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: ResourceRequestWrapper_SIG_hasSetRequestReturns */
      /* Details: "Method setRequest(ResourceRequest) returns void " */
      TestResult tr12 = tcd.getTestResultFailed(RESOURCEREQUESTWRAPPER_SIG_HASSETREQUESTRETURNS);
      {
         String name = "setRequest";
         Class<?> retType = void.class;
         Class<?>[] parms = {ResourceRequest.class};
         tr12.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: ResourceRequestWrapper_SIG_hasGetCharacterEncoding */
      /* Details: "Has a getCharacterEncoding()  method " */
      TestResult tr13 = tcd.getTestResultFailed(RESOURCEREQUESTWRAPPER_SIG_HASGETCHARACTERENCODING);
      {
         String name = "getCharacterEncoding";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr13.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: ResourceRequestWrapper_SIG_hasGetCharacterEncodingReturns */
      /* Details: "Method getCharacterEncoding() returns String " */
      TestResult tr14 = tcd.getTestResultFailed(RESOURCEREQUESTWRAPPER_SIG_HASGETCHARACTERENCODINGRETURNS);
      {
         String name = "getCharacterEncoding";
         Class<?> retType = String.class;
         Class<?>[] parms = null;
         tr14.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: ResourceRequestWrapper_SIG_hasGetContentLength */
      /* Details: "Has a getContentLength()  method " */
      TestResult tr15 = tcd.getTestResultFailed(RESOURCEREQUESTWRAPPER_SIG_HASGETCONTENTLENGTH);
      {
         String name = "getContentLength";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr15.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: ResourceRequestWrapper_SIG_hasGetContentLengthReturns */
      /* Details: "Method getContentLength() returns int " */
      TestResult tr16 = tcd.getTestResultFailed(RESOURCEREQUESTWRAPPER_SIG_HASGETCONTENTLENGTHRETURNS);
      {
         String name = "getContentLength";
         Class<?> retType = int.class;
         Class<?>[] parms = null;
         tr16.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: ResourceRequestWrapper_SIG_hasGetContentType */
      /* Details: "Has a getContentType()  method " */
      TestResult tr17 = tcd.getTestResultFailed(RESOURCEREQUESTWRAPPER_SIG_HASGETCONTENTTYPE);
      {
         String name = "getContentType";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr17.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: ResourceRequestWrapper_SIG_hasGetContentTypeReturns */
      /* Details: "Method getContentType() returns String " */
      TestResult tr18 = tcd.getTestResultFailed(RESOURCEREQUESTWRAPPER_SIG_HASGETCONTENTTYPERETURNS);
      {
         String name = "getContentType";
         Class<?> retType = String.class;
         Class<?>[] parms = null;
         tr18.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: ResourceRequestWrapper_SIG_hasGetETag */
      /* Details: "Has a getETag()  method " */
      TestResult tr19 = tcd.getTestResultFailed(RESOURCEREQUESTWRAPPER_SIG_HASGETETAG);
      {
         String name = "getETag";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr19.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: ResourceRequestWrapper_SIG_hasGetETagReturns */
      /* Details: "Method getETag() returns String " */
      TestResult tr20 = tcd.getTestResultFailed(RESOURCEREQUESTWRAPPER_SIG_HASGETETAGRETURNS);
      {
         String name = "getETag";
         Class<?> retType = String.class;
         Class<?>[] parms = null;
         tr20.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: ResourceRequestWrapper_SIG_hasGetMethod */
      /* Details: "Has a getMethod()  method " */
      TestResult tr21 = tcd.getTestResultFailed(RESOURCEREQUESTWRAPPER_SIG_HASGETMETHOD);
      {
         String name = "getMethod";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr21.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: ResourceRequestWrapper_SIG_hasGetMethodReturns */
      /* Details: "Method getMethod() returns String " */
      TestResult tr22 = tcd.getTestResultFailed(RESOURCEREQUESTWRAPPER_SIG_HASGETMETHODRETURNS);
      {
         String name = "getMethod";
         Class<?> retType = String.class;
         Class<?>[] parms = null;
         tr22.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: ResourceRequestWrapper_SIG_hasGetResourceID */
      /* Details: "Has a getResourceID()  method " */
      TestResult tr23 = tcd.getTestResultFailed(RESOURCEREQUESTWRAPPER_SIG_HASGETRESOURCEID);
      {
         String name = "getResourceID";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr23.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: ResourceRequestWrapper_SIG_hasGetResourceIDReturns */
      /* Details: "Method getResourceID() returns String " */
      TestResult tr24 = tcd.getTestResultFailed(RESOURCEREQUESTWRAPPER_SIG_HASGETRESOURCEIDRETURNS);
      {
         String name = "getResourceID";
         Class<?> retType = String.class;
         Class<?>[] parms = null;
         tr24.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: ResourceRequestWrapper_SIG_hasGetPrivateRenderParameterMap */
      /* Details: "Has a getPrivateRenderParameterMap()  method " */
      TestResult tr25 = tcd.getTestResultFailed(RESOURCEREQUESTWRAPPER_SIG_HASGETPRIVATERENDERPARAMETERMAP);
      {
         String name = "getPrivateRenderParameterMap";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr25.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: ResourceRequestWrapper_SIG_hasGetPrivateRenderParameterMapReturns */
      /* Details: "Method getPrivateRenderParameterMap() returns java.util.Map " */
      TestResult tr26 = tcd.getTestResultFailed(RESOURCEREQUESTWRAPPER_SIG_HASGETPRIVATERENDERPARAMETERMAPRETURNS);
      {
         String name = "getPrivateRenderParameterMap";
         Class<?> retType = java.util.Map.class;
         Class<?>[] parms = null;
         tr26.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: ResourceRequestWrapper_SIG_hasGetCacheability */
      /* Details: "Has a getCacheability()  method " */
      TestResult tr27 = tcd.getTestResultFailed(RESOURCEREQUESTWRAPPER_SIG_HASGETCACHEABILITY);
      {
         String name = "getCacheability";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr27.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: ResourceRequestWrapper_SIG_hasGetCacheabilityReturns */
      /* Details: "Method getCacheability() returns String " */
      TestResult tr28 = tcd.getTestResultFailed(RESOURCEREQUESTWRAPPER_SIG_HASGETCACHEABILITYRETURNS);
      {
         String name = "getCacheability";
         Class<?> retType = String.class;
         Class<?>[] parms = null;
         tr28.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: ResourceRequestWrapper_SIG_hasGetRequestA */
      /* Details: "Has a getRequest()  method " */
      TestResult tr29 = tcd.getTestResultFailed(RESOURCEREQUESTWRAPPER_SIG_HASGETREQUESTA);
      {
         String name = "getRequest";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr29.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: ResourceRequestWrapper_SIG_hasGetRequestReturnsA */
      /* Details: "Method getRequest() returns PortletRequest " */
      TestResult tr30 = tcd.getTestResultFailed(RESOURCEREQUESTWRAPPER_SIG_HASGETREQUESTRETURNSA);
      {
         String name = "getRequest";
         Class<?> retType = PortletRequest.class;
         Class<?>[] parms = null;
         tr30.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
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
      tr15.writeTo(writer);
      tr16.writeTo(writer);
      tr17.writeTo(writer);
      tr18.writeTo(writer);
      tr19.writeTo(writer);
      tr20.writeTo(writer);
      tr21.writeTo(writer);
      tr22.writeTo(writer);
      tr23.writeTo(writer);
      tr24.writeTo(writer);
      tr25.writeTo(writer);
      tr26.writeTo(writer);
      tr27.writeTo(writer);
      tr28.writeTo(writer);
      tr29.writeTo(writer);
      tr30.writeTo(writer);


   }

}

