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

import javax.inject.Inject;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.BaseURL;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.annotations.RenderMethod;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.util.ModuleTestCaseDetails;

import java.io.IOException;
import java.io.PrintWriter;

import static javax.portlet.tck.constants.Constants.THREADID_ATTR;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3URLTESTS_BASEURL_APPEND;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3URLTESTS_BASEURL_APPEND2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3URLTESTS_BASEURL_APPEND3;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3URLTESTS_BASEURL_APPEND4;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case
 * names are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the
 * additionalTCs.xml file into the complete list of test case names for
 * execution by the driver.
 * 
 * This is the main portlet for the test cases. If the test cases call for
 * events, this portlet will initiate the events, but not process them. The
 * processing is done in the companion portlet PortletContextTests_Context_event
 * 
 */

public class URLTests_BaseURL {

   @Inject
   PortletConfig portletConfig;

   public void processAction(ActionRequest portletReq,
         ActionResponse portletResp) throws PortletException, IOException {
   }

   public void serveResource(ResourceRequest portletReq,
         ResourceResponse portletResp) throws PortletException, IOException {
   }

   @RenderMethod(portletNames = "BaseURLTests")
   public void render(RenderRequest portletReq, RenderResponse portletResp)
         throws PortletException, IOException {

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

      ModuleTestCaseDetails tcd = new ModuleTestCaseDetails();

      /* TestCase: V3URLTests_BaseURL_append */
      /*
       * Details: "BaseURL.append(Appendable out) method appends the portlet URL
       * to the appendable object."
       */
      {
         TestResult tr0 = tcd.getTestResultFailed(V3URLTESTS_BASEURL_APPEND);
         BaseURL baseURL = portletResp.createRenderURL();
         StringBuilder sb = new StringBuilder();
         baseURL.append(sb);
         String resultingString = sb.toString();
         if (resultingString != null && !resultingString.equals("")) {
            tr0.setTcSuccess(true);
            tr0.appendTcDetail(
                  "<br>Successfully appended BaseURL object to StringBuilder. <br>Resulting StringBuilder object is: "
                        + resultingString);
         } else {
            tr0.appendTcDetail(
                  "<br>Failed because couldn't append BaseURL to StringBuilder object. <br>Resulting StringBuilder object is: "
                        + resultingString);
         }
         tr0.writeTo(writer);
      }

      /* TestCase: V3URLTests_BaseURL_append2 */
      /*
       * Details:
       * "BaseURL.append(Appendable out) - The appended URL is always XML escaped."
       */
      {
         TestResult tr1 = tcd.getTestResultFailed(V3URLTESTS_BASEURL_APPEND2);
         BaseURL baseURL = portletResp.createRenderURL();
         baseURL.setParameter("tr1", ">'\"");
         StringBuilder sb = new StringBuilder();
         baseURL.append(sb);
         String resultingString = sb.toString();
         if (resultingString != null && !resultingString.equals("")
               && !resultingString.contains(">")
               && !resultingString.contains("'")
               && !resultingString.contains("\"")) {
            tr1.setTcSuccess(true);
            tr1.appendTcDetail(
                  "<br>Successfully appended XMLescaped BaseURL object to StringBuilder. <br>Resulting StringBuilder object is: "
                        + resultingString);
         } else {
            tr1.appendTcDetail(
                  "<br>Failed because couldn't append XMLescaped BaseURL to StringBuilder object. <br>Resulting StringBuilder object is: "
                        + resultingString);
         }
         tr1.writeTo(writer);
      }

      /* TestCase: V3URLTests_BaseURL_append3 */
      /*
       * Details: "BaseURL.append(Appendable out, boolean escapeXML) - If the
       * parameter escapeXML is set to true, the URL will be escaped to be valid
       * XML characters. The manner in which escaping is performed is
       * implementation specific."
       */
      {
         TestResult tr2 = tcd.getTestResultFailed(V3URLTESTS_BASEURL_APPEND3);
         BaseURL baseURL = portletResp.createRenderURL();
         baseURL.setParameter("tr2", ">'\"");
         StringBuilder sb = new StringBuilder();
         baseURL.append(sb, true);
         String resultingString = sb.toString();
         if (resultingString != null && !resultingString.equals("")
               && !resultingString.contains(">")
               && !resultingString.contains("'")
               && !resultingString.contains("\"")) {
            tr2.setTcSuccess(true);
            tr2.appendTcDetail(
                  "<br>Successfully appended XMLescaped BaseURL object to StringBuilder. <br>Resulting StringBuilder object is: "
                        + resultingString);
         } else {
            tr2.appendTcDetail(
                  "<br>Failed because couldn't append XMLescaped BaseURL to StringBuilder object. <br>Resulting StringBuilder object is: "
                        + resultingString);
         }
         tr2.writeTo(writer);
      }

      /* TestCase: V3URLTests_BaseURL_append4 */
      /*
       * Details: "BaseURL.append(Appendable out, boolean escapeXML) - If
       * escapeXML is set to false, escaping the URL is left to the
       * implementation."
       */
      {
         TestResult tr3 = tcd.getTestResultFailed(V3URLTESTS_BASEURL_APPEND4);
         tr3.setTcSuccess(true);
         tr3.appendTcDetail("Can't be tested as escaping is left to implementation.");
         tr3.writeTo(writer);
      }

   }

}
