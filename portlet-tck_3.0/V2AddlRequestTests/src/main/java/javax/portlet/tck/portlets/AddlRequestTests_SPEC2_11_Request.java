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

package javax.portlet.tck.portlets;

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
public class AddlRequestTests_SPEC2_11_Request implements Portlet {
   private static final String LOG_CLASS = 
         AddlRequestTests_SPEC2_11_Request.class.getName();
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

      // Create result objects for the tests

      /* TestCase: SPEC2_11_Request_attributes1                               */
      /* Details: "The portlet can access a map with user information         */
      /* attributes via the request attribute PortletRequest.USER_INFO"       */
      TestResult tr0 = tcd.getTestResultFailed(SPEC2_11_REQUEST_ATTRIBUTES1);
      /* TODO: implement test */

      /* TestCase: SPEC2_11_Request_attributes2                               */
      /* Details: "The PortletRequest.CCPP_PROFILE request attribute must     */
      /* return a javax.ccpp.Profile based on the current portlet request"    */
      TestResult tr1 = tcd.getTestResultFailed(SPEC2_11_REQUEST_ATTRIBUTES2);
      /* TODO: implement test */

      /* TestCase: SPEC2_11_Request_attributes3                               */
      /* Details: "If the portlet container runtime option                    */
      /* javax.portlet.renderHeaders is set to TRUE, the RENDER_PART          */
      /* attribute will be set when the render method is called"              */
      TestResult tr2 = tcd.getTestResultFailed(SPEC2_11_REQUEST_ATTRIBUTES3);
      /* TODO: implement test */

      /* TestCase: SPEC2_11_Request_attributes4                               */
      /* Details: "If the portlet container runtime option                    */
      /* javax.portlet.renderHeaders is set to TRUE, render method will be    */
      /* called first with the RENDER_PART attribute set to                   */
      /* \"RENDER_HEADERS\""                                                  */
      TestResult tr3 = tcd.getTestResultFailed(SPEC2_11_REQUEST_ATTRIBUTES4);
      /* TODO: implement test */

      /* TestCase: SPEC2_11_Request_attributes5                               */
      /* Details: "If the portlet container runtime option                    */
      /* javax.portlet.renderHeaders is set to TRUE, render method will be    */
      /* called a second time with the RENDER_PART attribute set to           */
      /* \"RENDER_MARKUP\""                                                   */
      TestResult tr4 = tcd.getTestResultFailed(SPEC2_11_REQUEST_ATTRIBUTES5);
      /* TODO: implement test */

      /* TestCase: SPEC2_11_Request_attributes6                               */
      /* Details: "During action processing, the LIFECYCLE_PHASE              */
      /* (\"javax.portlet.lifecycle_phase\") attribute will contain the       */
      /* string \"ACTION_PHASE\""                                             */
      TestResult tr5 = tcd.getTestResultFailed(SPEC2_11_REQUEST_ATTRIBUTES6);
      /* TODO: implement test */

      /* TestCase: SPEC2_11_Request_attributes7                               */
      /* Details: "During event processing, the LIFECYCLE_PHASE               */
      /* (\"javax.portlet.lifecycle_phase\") attribute will contain the       */
      /* string \"EVENT_PHASE\""                                              */
      TestResult tr6 = tcd.getTestResultFailed(SPEC2_11_REQUEST_ATTRIBUTES7);
      /* TODO: implement test */

      /* TestCase: SPEC2_11_Request_attributes8                               */
      /* Details: "During render processing, the LIFECYCLE_PHASE              */
      /* (\"javax.portlet.lifecycle_phase\") attribute will contain the       */
      /* string \"RENDER_PHASE\""                                             */
      TestResult tr7 = tcd.getTestResultFailed(SPEC2_11_REQUEST_ATTRIBUTES8);
      /* TODO: implement test */

      /* TestCase: SPEC2_11_Request_attributes9                               */
      /* Details: "During resource processing, the LIFECYCLE_PHASE            */
      /* (\"javax.portlet.lifecycle_phase\") attribute will contain the       */
      /* string \"RESOURCE_PHASE\""                                           */
      TestResult tr8 = tcd.getTestResultFailed(SPEC2_11_REQUEST_ATTRIBUTES9);
      /* TODO: implement test */

      /* TestCase: SPEC2_11_Request_contentType1                              */
      /* Details: "The getResponseContentType method returns a String         */
      /* representing the default content type the portlet container          */
      /* assumes for the output"                                              */
      TestResult tr9 = tcd.getTestResultFailed(SPEC2_11_REQUEST_CONTENTTYPE1);
      /* TODO: implement test */

      /* TestCase: SPEC2_11_Request_contentType2                              */
      /* Details: "The getResponseContentTypes method returns an              */
      /* Enumeration of String elements representing the acceptable content   */
      /* types for the output in order of preference"                         */
      TestResult tr10 = tcd.getTestResultFailed(SPEC2_11_REQUEST_CONTENTTYPE2);
      /* TODO: implement test */

      /* TestCase: SPEC2_11_Request_contentType3                              */
      /* Details: "The first element of the Enumeration returned by the       */
      /* getResponseContentTypes method must equal the value returned by      */
      /* the getResponseContentType method"                                   */
      TestResult tr11 = tcd.getTestResultFailed(SPEC2_11_REQUEST_CONTENTTYPE3);
      /* TODO: implement test */

      /* TestCase: SPEC2_11_Request_contentType4                              */
      /* Details: "If a portlet defines support for all content types using   */
      /* a wildcard and the portlet container supports all content types,     */
      /* the getResponseContentType may return the wildcard"                  */
      TestResult tr12 = tcd.getTestResultFailed(SPEC2_11_REQUEST_CONTENTTYPE4);
      /* TODO: implement test */

      /* TestCase: SPEC2_11_Request_contentType5                              */
      /* Details: "If a portlet defines support for all content types using   */
      /* a wildcard and the portlet container supports all content types,     */
      /* the getResponseContentType may return the preferred content type"    */
      TestResult tr13 = tcd.getTestResultFailed(SPEC2_11_REQUEST_CONTENTTYPE5);
      /* TODO: implement test */

      /* TestCase: SPEC2_11_Request_contentType6                              */
      /* Details: "Within the processAction method, the content type must     */
      /* include only the MIME type, not the character set"                   */
      TestResult tr14 = tcd.getTestResultFailed(SPEC2_11_REQUEST_CONTENTTYPE6);
      /* TODO: implement test */

      /* TestCase: SPEC2_11_Request_contentType7                              */
      /* Details: "Within the processAction method, the                       */
      /* getResponseContentTypes method must return only the content types    */
      /* supported by the current portlet mode"                               */
      TestResult tr15 = tcd.getTestResultFailed(SPEC2_11_REQUEST_CONTENTTYPE7);
      /* TODO: implement test */

      /* TestCase: SPEC2_11_Request_contentType8                              */
      /* Details: "Within the processEvent method, the content type must      */
      /* include only the MIME type, not the character set"                   */
      TestResult tr16 = tcd.getTestResultFailed(SPEC2_11_REQUEST_CONTENTTYPE8);
      /* TODO: implement test */

      /* TestCase: SPEC2_11_Request_contentType9                              */
      /* Details: "Within the processEvent method, the                        */
      /* getResponseContentTypes method must return only the content types    */
      /* supported by the current portlet mode"                               */
      TestResult tr17 = tcd.getTestResultFailed(SPEC2_11_REQUEST_CONTENTTYPE9);
      /* TODO: implement test */

      /* TestCase: SPEC2_11_Request_contentType10                             */
      /* Details: "Within the render method, the content type must include    */
      /* only the MIME type, not the character set"                           */
      TestResult tr18 = tcd.getTestResultFailed(SPEC2_11_REQUEST_CONTENTTYPE10);
      /* TODO: implement test */

      /* TestCase: SPEC2_11_Request_contentType11                             */
      /* Details: "Within the render method, the getResponseContentTypes      */
      /* method must return only the content types supported by the current   */
      /* portlet mode"                                                        */
      TestResult tr19 = tcd.getTestResultFailed(SPEC2_11_REQUEST_CONTENTTYPE11);
      /* TODO: implement test */

      /* TestCase: SPEC2_11_Request_contentType12                             */
      /* Details: "Within the serveResource method, the content type should   */
      /* be based on the HTTP Accept header provided by the client"           */
      TestResult tr20 = tcd.getTestResultFailed(SPEC2_11_REQUEST_CONTENTTYPE12);
      /* TODO: implement test */

      /* TestCase: SPEC2_11_Request_contentType13                             */
      /* Details: "The character set of the response can be retrieved via     */
      /* the RenderResponse.getCharacterEncoding method"                      */
      TestResult tr21 = tcd.getTestResultFailed(SPEC2_11_REQUEST_CONTENTTYPE13);
      /* TODO: implement test */

      /* TestCase: SPEC2_11_Request_windowId4                                 */
      /* Details: "The string returned by getWindowID method must be the      */
      /* same ID used for scoping portlet-scope session attributes"           */
      TestResult tr22 = tcd.getTestResultFailed(SPEC2_11_REQUEST_WINDOWID4);
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


   }

}

