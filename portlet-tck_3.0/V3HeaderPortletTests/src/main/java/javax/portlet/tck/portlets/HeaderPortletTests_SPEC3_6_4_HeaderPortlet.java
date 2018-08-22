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
import java.util.Map;

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
import javax.portlet.annotations.RuntimeOption;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.util.ModuleTestCaseDetails;

import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC3_6_4_HEADERPORTLET_RENDERHEADERS;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC3_6_4_HEADERPORTLET_RENDERHEADERS2;
import static javax.portlet.tck.constants.Constants.RESULT_ATTR_PREFIX;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case
 * names are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the
 * additionalTCs.xml file into the complete list of test case names for
 * execution by the driver.
 *
 */

@PortletConfiguration(portletName = "HeaderPortletTests_SPEC3_6_4_HeaderPortlet",
   runtimeOptions = {@RuntimeOption(name = "javax.portlet.renderHeaders", values = { "true" })}
)
public class HeaderPortletTests_SPEC3_6_4_HeaderPortlet
      implements Portlet, HeaderPortlet {
   
   private boolean       tr0_success   = false;
   private PortletConfig portletConfig = null;

   @Override
   public void init(PortletConfig config) throws PortletException {
      this.portletConfig = config;
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
      ModuleTestCaseDetails tcd = new ModuleTestCaseDetails();

      /* TestCase: V3HeaderPortletTests_SPEC3_6_4_HeaderPortlet_renderHeaders */
      /*
       * Details: "renderHeaders() method is called before render() method if
       * the portlet implements HeaderPortlet interface."
       */
      {
         TestResult result = tcd.getTestResultFailed(
               V3HEADERPORTLETTESTS_SPEC3_6_4_HEADERPORTLET_RENDERHEADERS);
         result.setTcSuccess(tr0_success);
         result.writeTo(writer);
         tr0_success = false;
      }

      String msg = (String) renderRequest.getAttribute(
            RESULT_ATTR_PREFIX + "HeaderPortletTests_SPEC3_6_4_HeaderPortlet");
      writer.write("<p>" + msg + "</p>\n");
      renderRequest.removeAttribute(
            RESULT_ATTR_PREFIX + "HeaderPortletTests_SPEC3_6_4_HeaderPortlet");

   }

   @Override
   public void renderHeaders(HeaderRequest headerRequest,
         HeaderResponse headerResponse) throws PortletException, IOException {

      StringWriter writer = new StringWriter();

      ModuleTestCaseDetails tcd = new ModuleTestCaseDetails();

      tr0_success = true;

      /*
       * TestCase: V3HeaderPortletTests_SPEC3_6_4_HeaderPortlet_renderHeaders2
       */
      /*
       * Details: "The container runtime option javax.portlet.renderHeaders is
       * disregarded for version 3.0 or later."
       */
      {
         TestResult result = tcd.getTestResultFailed(
               V3HEADERPORTLETTESTS_SPEC3_6_4_HEADERPORTLET_RENDERHEADERS2);
         Map<String, String[]> runtimeOptions = portletConfig
               .getContainerRuntimeOptions();
         String[] renderHeaders = runtimeOptions
               .get("javax.portlet.renderHeaders");
         if (renderHeaders == null || renderHeaders.length == 0) {
            result.setTcSuccess(true);
         } else {
            result.appendTcDetail(
                  "Failed because javax.portlet.renderHeaders is found equal to "
                        + renderHeaders[0]);
         }
         result.writeTo(writer);
      }

      headerRequest.setAttribute(
            RESULT_ATTR_PREFIX + "HeaderPortletTests_SPEC3_6_4_HeaderPortlet",
            writer.toString());
   }

}
