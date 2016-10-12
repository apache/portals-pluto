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

import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSPA_STARTPARTIALACTION1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSPA_STARTPARTIALACTION2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSPA_STARTPARTIALACTION3;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSPA_STARTPARTIALACTION4;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSPA_STARTPARTIALACTION5;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSPA_STARTPARTIALACTION6;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSPA_STARTPARTIALACTION7;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.portlet.ActionParameters;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.MutableRenderParameters;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceServingPortlet;
import javax.portlet.annotations.PortletConfiguration;
import javax.portlet.tck.beans.TestButtonAsync;
import javax.portlet.tck.beans.TestResultAsync;
import javax.portlet.tck.util.ModuleTestCaseDetails;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the 
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 *
 */

@PortletConfiguration(portletName = "PortletHubTests_SPEC_23_JSPA")
public class PortletHubTests_SPEC_23_JSPA implements Portlet, ResourceServingPortlet {
   
   private PortletConfig portletConfig = null;

   @Override
   public void init(PortletConfig config) throws PortletException {
      this.portletConfig = config;
   }

   @Override
   public void destroy() {
   }

   @Override
   public void processAction(ActionRequest portletReq, ActionResponse portletResp) throws PortletException, IOException {
      
      MutableRenderParameters mrp = portletResp.getRenderParameters();
      String testcase = mrp.getValue("testcase");
      ActionParameters ap = portletReq.getActionParameters();
      String status = "OK";
     
      if (testcase == null || testcase.isEmpty()) {
         mrp.setValue("status", "Failed. No test case parameter present.");

      /* TestCase: V3PortletHubTests_SPEC_23_JSPA_startPartialAction1               */
      /* Details: "The portlet hub startPartialAction function can be called with   */
      /* no arguments"                                                              */
      } else if (testcase.equals(V3PORTLETHUBTESTS_SPEC_23_JSPA_STARTPARTIALACTION1)) {
         if (!ap.isEmpty()) {
            status = "Failed. Action parameters are set: " + Arrays.asList(ap.getNames()).toString();
         }

      /* TestCase: V3PortletHubTests_SPEC_23_JSPA_startPartialAction2               */
      /* Details: "The portlet hub startPartialAction function can be called with   */
      /* an action parameters argument"                                             */
      } else if (testcase.equals(V3PORTLETHUBTESTS_SPEC_23_JSPA_STARTPARTIALACTION2)) {
         String param = ap.getValue("param1");
         if (param == null || !param.equals("val1")) {
            status = "Failed. Action parameter had incorrect value: " + param;
         }

      /* TestCase: V3PortletHubTests_SPEC_23_JSPA_startPartialAction3               */
      /* Details: "The portlet hub startPartialAction function returns a            */
      /* PartialActionInit object"                                                  */
      } else if (testcase.equals(V3PORTLETHUBTESTS_SPEC_23_JSPA_STARTPARTIALACTION3)) {

      /* TestCase: V3PortletHubTests_SPEC_23_JSPA_startPartialAction4               */
      /* Details: "The PartialActionInit object has a url property of type string"  */
      } else if (testcase.equals(V3PORTLETHUBTESTS_SPEC_23_JSPA_STARTPARTIALACTION4)) {

      /* TestCase: V3PortletHubTests_SPEC_23_JSPA_startPartialAction5               */
      /* Details: "The PartialActionInit object has a setPageState property of type */
      /* function"                                                                  */
      } else if (testcase.equals(V3PORTLETHUBTESTS_SPEC_23_JSPA_STARTPARTIALACTION5)) {

      /* TestCase: V3PortletHubTests_SPEC_23_JSPA_startPartialAction6               */
      /* Details: "The PartialActionInit object url property used in an XHR causes  */
      /* a token to be returned that completes the partial action when passed to    */
      /* the setPageState function"                                                 */
      } else if (testcase.equals(V3PORTLETHUBTESTS_SPEC_23_JSPA_STARTPARTIALACTION6)) {

      /* TestCase: V3PortletHubTests_SPEC_23_JSPA_startPartialAction7               */
      /* Details: "The onStateChange event resulting from a partial action contains */
      /* render data produced by the portlet resource method"                       */
      } else if (testcase.equals(V3PORTLETHUBTESTS_SPEC_23_JSPA_STARTPARTIALACTION7)) {
         
      } else {
         status = "Failed. unknown test case: " + testcase;
      }
      
      mrp.setValue("status", status);

   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp) throws PortletException, IOException {

      PrintWriter writer = portletResp.getWriter();
      ModuleTestCaseDetails tcd = new ModuleTestCaseDetails();

      /* TestCase: V3PortletHubTests_SPEC_23_JSPA_startPartialAction1               */
      /* Details: "The portlet hub startPartialAction function can be called with   */
      /* no arguments"                                                              */
      {
         TestButtonAsync button = new TestButtonAsync(V3PORTLETHUBTESTS_SPEC_23_JSPA_STARTPARTIALACTION1);
         button.writeTo(writer);
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSPA_STARTPARTIALACTION1);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSPA_startPartialAction2               */
      /* Details: "The portlet hub startPartialAction function can be called with   */
      /* an action parameters argument"                                             */
      {
         TestButtonAsync button = new TestButtonAsync(V3PORTLETHUBTESTS_SPEC_23_JSPA_STARTPARTIALACTION2);
         button.writeTo(writer);
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSPA_STARTPARTIALACTION2);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSPA_startPartialAction3               */
      /* Details: "The portlet hub startPartialAction function returns a            */
      /* PartialActionInit object"                                                  */
      {
         TestButtonAsync button = new TestButtonAsync(V3PORTLETHUBTESTS_SPEC_23_JSPA_STARTPARTIALACTION3);
         button.writeTo(writer);
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSPA_STARTPARTIALACTION3);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSPA_startPartialAction4               */
      /* Details: "The PartialActionInit object has a url property of type string"  */
      {
         TestButtonAsync button = new TestButtonAsync(V3PORTLETHUBTESTS_SPEC_23_JSPA_STARTPARTIALACTION4);
         button.writeTo(writer);
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSPA_STARTPARTIALACTION4);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSPA_startPartialAction5               */
      /* Details: "The PartialActionInit object has a setPageState property of type */
      /* function"                                                                  */
      {
         TestButtonAsync button = new TestButtonAsync(V3PORTLETHUBTESTS_SPEC_23_JSPA_STARTPARTIALACTION5);
         button.writeTo(writer);
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSPA_STARTPARTIALACTION5);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSPA_startPartialAction6               */
      /* Details: "The PartialActionInit object url property used in an XHR causes  */
      /* a token to be returned that completes the partial action when passed to    */
      /* the setPageState function"                                                 */
      {
         TestButtonAsync button = new TestButtonAsync(V3PORTLETHUBTESTS_SPEC_23_JSPA_STARTPARTIALACTION6);
         button.writeTo(writer);
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSPA_STARTPARTIALACTION6);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSPA_startPartialAction7               */
      /* Details: "The onStateChange event resulting from a partial action contains */
      /* render data produced by the portlet resource method"                       */
      {
         TestButtonAsync button = new TestButtonAsync(V3PORTLETHUBTESTS_SPEC_23_JSPA_STARTPARTIALACTION7);
         button.writeTo(writer);
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSPA_STARTPARTIALACTION7);
         result.writeTo(writer);
      }

      writer.write("<script>");
      writer.write("   var tck = tck || {};");
      writer.write("   tck.PortletHubTests_SPEC_23_JSPA = {};");
      writer.write("   tck.PortletHubTests_SPEC_23_JSPA.pid = '" + portletResp.getNamespace() + "';");
      writer.write("</script>");

      writer.write("<form  id='PortletHubTests_SPEC_23_JSPA-dummyForm' onsubmit='return false;' enctype='application/x-www-form-urlencoded'>");
      writer.write("</form>");

      StringBuilder txt = new StringBuilder(128);
      txt.append("<script type='text/javascript' src='");
      txt.append(portletConfig.getPortletContext().getContextPath());
      txt.append("/javascript/PortletHubTests_SPEC_23_JSPA.js'></script>\n");

      writer.write(txt.toString());


   }

   @Override
   public void serveResource(ResourceRequest request, ResourceResponse response) throws PortletException, IOException {
      
      String testcase = request.getRenderParameters().getValue("testcase");
      response.setCharacterEncoding("UTF-8");
      response.setContentType("text/plain");
      response.getWriter().write("OK " + testcase);

   }

}
