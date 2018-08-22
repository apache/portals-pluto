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
import java.io.StringWriter;
import java.util.Enumeration;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.HeaderPortlet;
import javax.portlet.HeaderRequest;
import javax.portlet.HeaderResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.annotations.PortletConfiguration;
import javax.portlet.annotations.Supports;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.util.ModuleTestCaseDetails;

import org.apache.commons.lang3.StringUtils;

import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_HEADERREQ_CONTENTTYPE1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_HEADERREQ_CONTENTTYPE2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_HEADERREQ_CONTENTTYPE3;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_HEADERREQ_CONTENTTYPE4;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_HEADERREQ_CONTENTTYPE5;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_HEADERREQ_CONTENTTYPE10;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_HEADERREQ_CONTENTTYPE11;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_HEADERREQ_CONTENTTYPE13;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_HEADERREQ_WINDOWID1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_HEADERREQ_WINDOWID4;
import static javax.portlet.tck.constants.Constants.RESULT_ATTR_PREFIX;
import static javax.portlet.PortletSession.APPLICATION_SCOPE;
import static javax.portlet.PortletSession.PORTLET_SCOPE;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case
 * names are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the
 * additionalTCs.xml file into the complete list of test case names for
 * execution by the driver.
 *
 */

@PortletConfiguration(portletName = "HeaderPortletTests_SPEC14_HeaderReq", supports = {
      @Supports(mimeType = "text/html") })
public class HeaderPortletTests_SPEC14_HeaderReq
      implements Portlet, HeaderPortlet {

   @Override
   public void init(PortletConfig config) throws PortletException {
   }

   @Override
   public void destroy() {
   }

   @Override
   public void processAction(ActionRequest actionRequest,
         ActionResponse actionResponse) throws PortletException, IOException {
   }

   @Override
   public void render(RenderRequest renderRequest, RenderResponse renderResponse)
         throws PortletException, IOException {

      PrintWriter writer = renderResponse.getWriter();
      String msg = (String) renderRequest.getAttribute(
            RESULT_ATTR_PREFIX + "HeaderPortletTests_SPEC14_HeaderReq");
      writer.write("<p>" + msg + "</p>\n");
      renderRequest.removeAttribute(
            RESULT_ATTR_PREFIX + "HeaderPortletTests_SPEC14_HeaderReq");

   }

   @Override
   public void renderHeaders(HeaderRequest headerRequest,
         HeaderResponse headerResponse) throws PortletException, IOException {

      StringWriter writer = new StringWriter();

      ModuleTestCaseDetails tcd = new ModuleTestCaseDetails();

      /* TestCase: V3HeaderPortletTests_SPEC14_HeaderReq_contentType1 */
      /*
       * Details: "The getResponseContentType method returns a String
       * representing the default content type the portlet container assumes for
       * the output"
       */
      {
         TestResult result = tcd.getTestResultFailed(
               V3HEADERPORTLETTESTS_SPEC14_HEADERREQ_CONTENTTYPE1);
         if (headerRequest.getResponseContentType() != null
               && !headerRequest.getResponseContentType().isEmpty())
            result.setTcSuccess(true);
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_HeaderReq_contentType2 */
      /*
       * Details: "The getResponseContentTypes method returns an Enumeration of
       * String elements representing the acceptable content types for the
       * output
       */
      /* in order of preference" */
      {
         TestResult result = tcd.getTestResultFailed(
               V3HEADERPORTLETTESTS_SPEC14_HEADERREQ_CONTENTTYPE2);
         Enumeration<String> contentTypesTr1 = headerRequest
               .getResponseContentTypes();
         if (contentTypesTr1 != null && contentTypesTr1.hasMoreElements()
               && !contentTypesTr1.nextElement().isEmpty())
            result.setTcSuccess(true);
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_HeaderReq_contentType3 */
      /* Details: "The first element of the Enumeration returned by the */
      /* getResponseContentTypes method must equal the value returned by the */
      /* getResponseContentType method" */
      {
         TestResult result = tcd.getTestResultFailed(
               V3HEADERPORTLETTESTS_SPEC14_HEADERREQ_CONTENTTYPE3);
         if (headerRequest.getResponseContentTypes().nextElement()
               .equals(headerRequest.getResponseContentType()))
            result.setTcSuccess(true);
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_HeaderReq_contentType4 */
      /* Details: "If a portlet defines support for all content types using a */
      /* wildcard and the portlet container supports all content types, the */
      /* getResponseContentType may return the wildcard" */
      {
         TestResult result = tcd.getTestResultFailed(
               V3HEADERPORTLETTESTS_SPEC14_HEADERREQ_CONTENTTYPE4);
         result.appendTcDetail("Cannot really test this. ");
         if (headerRequest.getResponseContentType().equals("text/html")) {
            result.setTcSuccess(true);
         } else {
            result.appendTcDetail(
                  "Content type is " + headerRequest.getResponseContentType());
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_HeaderReq_contentType5 */
      /* Details: "If a portlet defines support for all content types using a */
      /* wildcard and the portlet container supports all content types, the */
      /* getResponseContentType may return the preferred content type" */
      {
         TestResult result = tcd.getTestResultFailed(
               V3HEADERPORTLETTESTS_SPEC14_HEADERREQ_CONTENTTYPE5);
         if (headerRequest.getResponseContentType().equals("text/html")) {
            result.setTcSuccess(true);
         } else {
            result.appendTcDetail(
                  "Content type is " + headerRequest.getResponseContentType());
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_HeaderReq_windowId1 */
      /*
       * Details: "The getWindowID method returns a String representing the
       * current window ID"
       */
      {
         TestResult result = tcd.getTestResultFailed(
               V3HEADERPORTLETTESTS_SPEC14_HEADERREQ_WINDOWID1);
         String windowId = headerRequest.getWindowID();
         if (windowId != null) {
            result.setTcSuccess(true);
            result.appendTcDetail("Window ID is " + windowId);
         } else {
            result.appendTcDetail("Failed because windowID is null");
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_HeaderReq_windowId4 */
      /*
       * Details: "The string returned by getWindowID method must be the same ID
       * used for scoping portlet-scope session attributes"
       */
      {
         TestResult result = tcd.getTestResultFailed(
               V3HEADERPORTLETTESTS_SPEC14_HEADERREQ_WINDOWID4);
         headerRequest.getPortletSession().setAttribute("tr5",
               headerRequest.getWindowID(), PORTLET_SCOPE);
         String tr5SessionAttribute = (String) headerRequest.getPortletSession()
               .getAttribute(
                     "javax.portlet.p." + headerRequest.getWindowID() + "?tr5",
                     APPLICATION_SCOPE);
         if (tr5SessionAttribute != null
               && tr5SessionAttribute.equals(headerRequest.getWindowID())) {
            result.setTcSuccess(true);
         } else {
            result.appendTcDetail("Couldn't find javax.portlet.p."
                  + headerRequest.getWindowID() + ".tr5 attribute");
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_HeaderReq_contentType10 */
      /*
       * Details: "Within the header method, the content type must include only
       * the MIME type, not the character set"
       */
      {
         TestResult result = tcd.getTestResultFailed(
               V3HEADERPORTLETTESTS_SPEC14_HEADERREQ_CONTENTTYPE10);
         if (!StringUtils.containsIgnoreCase(
               headerRequest.getResponseContentType(),
               headerResponse.getCharacterEncoding()))
            result.setTcSuccess(true);
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_HeaderReq_contentType11 */
      /*
       * Details: "Within the header method, the getResponseContentTypes method
       * must return only the content types supported by the current portlet
       * mode"
       */
      {
         TestResult result = tcd.getTestResultFailed(
               V3HEADERPORTLETTESTS_SPEC14_HEADERREQ_CONTENTTYPE11);
         Enumeration<String> contentTypesTr7 = headerRequest
               .getResponseContentTypes();
         if (contentTypesTr7.nextElement().equals("text/html")
               && !contentTypesTr7.hasMoreElements())
            result.setTcSuccess(true);
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_HeaderReq_contentType13 */
      /* Details: "The character set of the response can be retrieved via the */
      /* HeaderResponse.getCharacterEncoding method" */
      {
         TestResult result = tcd.getTestResultFailed(
               V3HEADERPORTLETTESTS_SPEC14_HEADERREQ_CONTENTTYPE13);
         if (headerResponse.getCharacterEncoding() != null) {
            result.setTcSuccess(true);
         } else {
            result.appendTcDetail("Character Encoding is null");
         }
         result.writeTo(writer);
      }

      headerRequest.setAttribute(
            RESULT_ATTR_PREFIX + "HeaderPortletTests_SPEC14_HeaderReq",
            writer.toString());
   }

}
