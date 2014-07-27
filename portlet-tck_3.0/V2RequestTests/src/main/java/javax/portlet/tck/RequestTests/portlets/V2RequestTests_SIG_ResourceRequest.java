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
public class V2RequestTests_SIG_ResourceRequest implements Portlet {
   private static final String LOG_CLASS = 
         V2RequestTests_SIG_ResourceRequest.class.getName();
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

      /* TestCase: ResourceRequest_SIG_implementsClientDataRequest */
      /* Details: "Implements ClientDataRequest " */
      TestResult tr0 = tcd.getTestResultFailed(RESOURCEREQUEST_SIG_IMPLEMENTSCLIENTDATAREQUEST);
      {
         tr0.setTcSuccess(cc.implementsInterface(ClientDataRequest.class));
      }

      /* TestCase: ResourceRequest_SIG_fieldETAG */
      /* Details: "Has String field ETAG " */
      TestResult tr1 = tcd.getTestResultFailed(RESOURCEREQUEST_SIG_FIELDETAG);
      {
         tr1.setTcSuccess(cc.hasField("ETAG"));
      }

      /* TestCase: ResourceRequest_SIG_hasGetETag */
      /* Details: "Has a getETag()  method " */
      TestResult tr2 = tcd.getTestResultFailed(RESOURCEREQUEST_SIG_HASGETETAG);
      {
         String name = "getETag";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr2.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: ResourceRequest_SIG_hasGetETagReturns */
      /* Details: "Method getETag() returns String " */
      TestResult tr3 = tcd.getTestResultFailed(RESOURCEREQUEST_SIG_HASGETETAGRETURNS);
      {
         String name = "getETag";
         Class<?> retType = String.class;
         Class<?>[] parms = null;
         tr3.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: ResourceRequest_SIG_hasGetResourceID */
      /* Details: "Has a getResourceID()  method " */
      TestResult tr4 = tcd.getTestResultFailed(RESOURCEREQUEST_SIG_HASGETRESOURCEID);
      {
         String name = "getResourceID";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr4.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: ResourceRequest_SIG_hasGetResourceIDReturns */
      /* Details: "Method getResourceID() returns String " */
      TestResult tr5 = tcd.getTestResultFailed(RESOURCEREQUEST_SIG_HASGETRESOURCEIDRETURNS);
      {
         String name = "getResourceID";
         Class<?> retType = String.class;
         Class<?>[] parms = null;
         tr5.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: ResourceRequest_SIG_hasGetPrivateRenderParameterMap */
      /* Details: "Has a getPrivateRenderParameterMap()  method " */
      TestResult tr6 = tcd.getTestResultFailed(RESOURCEREQUEST_SIG_HASGETPRIVATERENDERPARAMETERMAP);
      {
         String name = "getPrivateRenderParameterMap";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr6.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: ResourceRequest_SIG_hasGetPrivateRenderParameterMapReturns */
      /* Details: "Method getPrivateRenderParameterMap() returns java.util.Map " */
      TestResult tr7 = tcd.getTestResultFailed(RESOURCEREQUEST_SIG_HASGETPRIVATERENDERPARAMETERMAPRETURNS);
      {
         String name = "getPrivateRenderParameterMap";
         Class<?> retType = java.util.Map.class;
         Class<?>[] parms = null;
         tr7.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: ResourceRequest_SIG_hasGetResponseContentType */
      /* Details: "Has a getResponseContentType()  method " */
      TestResult tr8 = tcd.getTestResultFailed(RESOURCEREQUEST_SIG_HASGETRESPONSECONTENTTYPE);
      {
         String name = "getResponseContentType";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr8.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: ResourceRequest_SIG_hasGetResponseContentTypeReturns */
      /* Details: "Method getResponseContentType() returns String " */
      TestResult tr9 = tcd.getTestResultFailed(RESOURCEREQUEST_SIG_HASGETRESPONSECONTENTTYPERETURNS);
      {
         String name = "getResponseContentType";
         Class<?> retType = String.class;
         Class<?>[] parms = null;
         tr9.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: ResourceRequest_SIG_hasGetResponseContentTypes */
      /* Details: "Has a getResponseContentTypes()  method " */
      TestResult tr10 = tcd.getTestResultFailed(RESOURCEREQUEST_SIG_HASGETRESPONSECONTENTTYPES);
      {
         String name = "getResponseContentTypes";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr10.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: ResourceRequest_SIG_hasGetResponseContentTypesReturns */
      /* Details: "Method getResponseContentTypes() returns java.util.Enumeration " */
      TestResult tr11 = tcd.getTestResultFailed(RESOURCEREQUEST_SIG_HASGETRESPONSECONTENTTYPESRETURNS);
      {
         String name = "getResponseContentTypes";
         Class<?> retType = java.util.Enumeration.class;
         Class<?>[] parms = null;
         tr11.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: ResourceRequest_SIG_hasGetCacheability */
      /* Details: "Has a getCacheability()  method " */
      TestResult tr12 = tcd.getTestResultFailed(RESOURCEREQUEST_SIG_HASGETCACHEABILITY);
      {
         String name = "getCacheability";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr12.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: ResourceRequest_SIG_hasGetCacheabilityReturns */
      /* Details: "Method getCacheability() returns String " */
      TestResult tr13 = tcd.getTestResultFailed(RESOURCEREQUEST_SIG_HASGETCACHEABILITYRETURNS);
      {
         String name = "getCacheability";
         Class<?> retType = String.class;
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

