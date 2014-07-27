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
public class V2RequestTests_ResourceRequest implements Portlet {
   private static final String LOG_CLASS = 
         V2RequestTests_ResourceRequest.class.getName();
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

      /* TestCase: ResourceRequest_implementsClientDataRequest3 */
      /* Details: "All tests described for the ClientDataRequest execute correctly with the ResourceRequest" */
      TestResult tr0 = tcd.getTestResultFailed(RESOURCEREQUEST_IMPLEMENTSCLIENTDATAREQUEST3);
      /* TODO: implement test */

      /* TestCase: ResourceRequest_implementsClientDataRequest4 */
      /* Details: "All tests described for the PortletRequest execute correctly with the ResourceRequest" */
      TestResult tr1 = tcd.getTestResultFailed(RESOURCEREQUEST_IMPLEMENTSCLIENTDATAREQUEST4);
      /* TODO: implement test */

      /* TestCase: ResourceRequest_fieldETAG */
      /* Details: "Has String field ETAG with value of \"portlet.ETag\" " */
      TestResult tr2 = tcd.getTestResultFailed(RESOURCEREQUEST_FIELDETAG);
      {
         tr2.setTcSuccess(cc.hasField("ETAG", "portlet.ETag"));
      }

      /* TestCase: ResourceRequest_getETag2 */
      /* Details: "Returns null if there is no cached response" */
      TestResult tr3 = tcd.getTestResultFailed(RESOURCEREQUEST_GETETAG2);
      /* TODO: implement test */

      /* TestCase: ResourceRequest_getResourceID1 */
      /* Details: "Returns a String containing the resource ID set on the resource URL" */
      TestResult tr4 = tcd.getTestResultFailed(RESOURCEREQUEST_GETRESOURCEID1);
      /* TODO: implement test */

      /* TestCase: ResourceRequest_getResourceID2 */
      /* Details: "Returns null if no resource ID was set on the URL" */
      TestResult tr5 = tcd.getTestResultFailed(RESOURCEREQUEST_GETRESOURCEID2);
      /* TODO: implement test */

      /* TestCase: ResourceRequest_getPrivateRenderParameterMap1 */
      /* Details: "Returns a java.util.Map<java.lang.String,java.lang.String[]> object containing the private render parameters for the request" */
      TestResult tr6 = tcd.getTestResultFailed(RESOURCEREQUEST_GETPRIVATERENDERPARAMETERMAP1);
      /* TODO: implement test */

      /* TestCase: ResourceRequest_getPrivateRenderParameterMap2 */
      /* Details: "The returned map does not contain the resource parameters set on the URL" */
      TestResult tr7 = tcd.getTestResultFailed(RESOURCEREQUEST_GETPRIVATERENDERPARAMETERMAP2);
      /* TODO: implement test */

      /* TestCase: ResourceRequest_getPrivateRenderParameterMap3 */
      /* Details: "The returned map is immutable" */
      TestResult tr8 = tcd.getTestResultFailed(RESOURCEREQUEST_GETPRIVATERENDERPARAMETERMAP3);
      /* TODO: implement test */

      /* TestCase: ResourceRequest_getPrivateRenderParameterMap4 */
      /* Details: "Returns an empty map if there are no private render parameters" */
      TestResult tr9 = tcd.getTestResultFailed(RESOURCEREQUEST_GETPRIVATERENDERPARAMETERMAP4);
      /* TODO: implement test */

      /* TestCase: ResourceRequest_getResponseContentType */
      /* Details: "Returns a String containing the preferred content type for the resonse" */
      TestResult tr10 = tcd.getTestResultFailed(RESOURCEREQUEST_GETRESPONSECONTENTTYPE);
      /* TODO: implement test */

      /* TestCase: ResourceRequest_getResponseContentTypes */
      /* Details: "Returns an java.util.Enumeration<java.lang.String> object containing the content types that will be accepted for the response" */
      TestResult tr11 = tcd.getTestResultFailed(RESOURCEREQUEST_GETRESPONSECONTENTTYPES);
      /* TODO: implement test */

      /* TestCase: ResourceRequest_getCacheability */
      /* Details: "Returns a String containing the cache level of the resource request" */
      TestResult tr12 = tcd.getTestResultFailed(RESOURCEREQUEST_GETCACHEABILITY);
      /* TODO: implement test */



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


   }

}

