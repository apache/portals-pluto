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

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.HeaderPortlet;
import javax.portlet.HeaderRequest;
import javax.portlet.HeaderResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.annotations.PortletConfiguration;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.util.ModuleTestCaseDetails;

import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_HEADERATTR_ATTRIBUTES1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_HEADERATTR_ATTRIBUTES2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_HEADERATTR_ATTRIBUTES3;
import static javax.portlet.tck.constants.Constants.RESULT_ATTR_PREFIX;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case
 * names are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the
 * additionalTCs.xml file into the complete list of test case names for
 * execution by the driver.
 *
 */

@PortletConfiguration(portletName = "HeaderPortletTests_SPEC14_HeaderAttr")
public class HeaderPortletTests_SPEC14_HeaderAttr
      implements HeaderPortlet, Portlet {

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
            RESULT_ATTR_PREFIX + "HeaderPortletTests_SPEC14_HeaderAttr");
      writer.write("<p>" + msg + "</p>\n");
      renderRequest.removeAttribute(
            RESULT_ATTR_PREFIX + "HeaderPortletTests_SPEC14_HeaderAttr");
   }

   @Override
   public void renderHeaders(HeaderRequest headerRequest,
         HeaderResponse PortletResp) throws PortletException, IOException {

      StringWriter writer = new StringWriter();

      ModuleTestCaseDetails tcd = new ModuleTestCaseDetails();

      /* TestCase: V3HeaderPortletTests_SPEC14_HeaderAttr_attributes1 */
      /*
       * Details: "The portlet can access a map with user information attributes
       * via the request attribute PortletRequest.USER_INFO"
       */
      {
         TestResult result = tcd.getTestResultFailed(
               V3HEADERPORTLETTESTS_SPEC14_HEADERATTR_ATTRIBUTES1);
         if (headerRequest.getAttribute(PortletRequest.USER_INFO) != null) {
            result.setTcSuccess(true);
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_HeaderAttr_attributes2 */
      /*
       * Details: "The PortletRequest.CCPP_PROFILE request attribute must return
       * a javax.ccpp.Profile based on the current portlet request"
       */
      {
         TestResult result = tcd.getTestResultFailed(
               V3HEADERPORTLETTESTS_SPEC14_HEADERATTR_ATTRIBUTES2);
         if (headerRequest.getAttribute(PortletRequest.CCPP_PROFILE) != null) {
            result.setTcSuccess(true);
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_HeaderAttr_attributes3 */
      /*
       * Details: "During header processing, the LIFECYCLE_PHASE
       * (\"javax.portlet.lifecycle_phase\") attribute will contain the string
       * \"HEADER_PHASE\""
       */
      {
         TestResult result = tcd.getTestResultFailed(
               V3HEADERPORTLETTESTS_SPEC14_HEADERATTR_ATTRIBUTES3);
         if (headerRequest.getAttribute(PortletRequest.LIFECYCLE_PHASE) != null
               && headerRequest.getAttribute(PortletRequest.LIFECYCLE_PHASE)
                     .equals("HEADER_PHASE")) {
            result.setTcSuccess(true);
         }
         result.writeTo(writer);
      }

      headerRequest.setAttribute(
            RESULT_ATTR_PREFIX + "HeaderPortletTests_SPEC14_HeaderAttr",
            writer.toString());
   }

}
