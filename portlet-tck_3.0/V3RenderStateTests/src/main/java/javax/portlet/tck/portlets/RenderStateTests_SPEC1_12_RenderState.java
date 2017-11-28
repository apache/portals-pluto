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

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.MutableRenderParameters;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.RenderParameters;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.RenderURL;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceServingPortlet;
import javax.portlet.ResourceURL;
import javax.portlet.WindowState;
import javax.portlet.annotations.PortletApplication;
import javax.portlet.annotations.PortletConfiguration;
import javax.portlet.annotations.PortletQName;
import javax.portlet.annotations.PublicRenderParameterDefinition;
import javax.portlet.tck.beans.TestLink;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.util.ModuleTestCaseDetails;

import static javax.portlet.ResourceURL.FULL;
import static javax.portlet.tck.util.ModuleTestCaseDetails.*;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case
 * names are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the
 * additionalTCs.xml file into the complete list of test case names for
 * execution by the driver.
 *
 */

@PortletApplication(publicParams = {
      @PublicRenderParameterDefinition(identifier = "tr0_public", qname = @PortletQName(localPart = "tr0_public", namespaceURI = "")) })
@PortletConfiguration(portletName = "RenderStateTests_SPEC1_12_RenderState", publicParams = {
      "tr0_public" })
public class RenderStateTests_SPEC1_12_RenderState implements Portlet, ResourceServingPortlet {

   @Override
   public void init(PortletConfig config) throws PortletException {
   }

   @Override
   public void destroy() {
   }

   @Override
   public void processAction(ActionRequest portletReq,
         ActionResponse portletResp) throws PortletException, IOException {
   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp)
         throws PortletException, IOException {

      PrintWriter writer = portletResp.getWriter();
      ModuleTestCaseDetails tcd = new ModuleTestCaseDetails();

      /*
       * TestCase: V3RenderStateTests_SPEC1_12_RenderState_general
       */
      /*
       * Details:
       * "RenderState interface provides read-only access to the render state."
       */
      {
         TestResult result = tcd.getTestResultFailed(
               V3RENDERSTATETESTS_SPEC1_12_RENDERSTATE_GENERAL);
         result.setTcSuccess(true);
         result.appendTcDetail(
               "There are no setter methods in RenderState interface.");
         result.writeTo(writer);
      }

      /*
       * TestCase: V3RenderStateTests_SPEC1_12_RenderState_getRenderParameters
       */
      /*
       * Details: "Returns an RenderParameters object representing the private
       * and public render parameters."
       */
      RenderParameters renderParams = portletReq.getRenderParameters();
      if (!renderParams.isEmpty() && renderParams.isPublic("tr0_public")
            && renderParams.getValue("tr0_public") != null
            && renderParams.getValue("tr0_public").equals("true")
            && renderParams.getValue("tr0_private") != null
            && renderParams.getValue("tr0_private").equals("true")) {
         TestResult result = tcd.getTestResultFailed(
               V3RENDERSTATETESTS_SPEC1_12_RENDERSTATE_GETRENDERPARAMETERS);
         result.setTcSuccess(true);
         result.writeTo(writer);
      } else {
         RenderURL renderURL = portletResp.createRenderURL();
         MutableRenderParameters mutableRenderParams = renderURL
               .getRenderParameters();
         mutableRenderParams.setValue("tr0_private", "true");
         mutableRenderParams.setValue("tr0_public", "true");
         TestLink tb = new TestLink(
               V3RENDERSTATETESTS_SPEC1_12_RENDERSTATE_GETRENDERPARAMETERS,
               renderURL);
         tb.writeTo(writer);
      }

      /*
       * TestCase: V3RenderStateTests_SPEC1_12_RenderState_getRenderParameters2
       */
      /*
       * Details:
       * "The RenderParameters object return by this method is immutable."
       */
      {
         TestResult result = tcd.getTestResultFailed(
               V3RENDERSTATETESTS_SPEC1_12_RENDERSTATE_GETRENDERPARAMETERS2);
         result.setTcSuccess(true);
         result.appendTcDetail(
               "There are no setters in RenderParameters object returned by RenderState.getRenderParameters() method");
         result.writeTo(writer);
      }

      /* TestCase: V3RenderStateTests_SPEC1_12_RenderState_getPortletMode */
      /* Details: "Returns the current portlet mode of the portlet." */
      {
         TestResult result = tcd.getTestResultFailed(
               V3RENDERSTATETESTS_SPEC1_12_RENDERSTATE_GETPORTLETMODE);
         if (portletReq.getPortletMode().equals(PortletMode.VIEW)) {
            result.setTcSuccess(true);
            result.appendTcDetail("Current portlet mode is VIEW");
         } else {
            result.appendTcDetail("Current portlet mode is not VIEW but "
                  + portletReq.getPortletMode().toString());
         }
         result.writeTo(writer);
      }

      /* TestCase: V3RenderStateTests_SPEC1_12_RenderState_getWindowState */
      /* Details: "Returns the current window state of the portlet." */
      {
         TestResult result = tcd.getTestResultFailed(
               V3RENDERSTATETESTS_SPEC1_12_RENDERSTATE_GETWINDOWSTATE);
         if (portletReq.getWindowState().equals(WindowState.NORMAL)) {
            result.setTcSuccess(true);
            result.appendTcDetail("Current window state is NORMAL");
         } else {
            result.appendTcDetail("Current portlet mode is not NORMAL but "
                  + portletReq.getWindowState().toString());
         }
         result.writeTo(writer);
      }

      writer.write(
            "<div id=\"RenderStateTests_SPEC1_12_RenderState\">no resource output.</div>\n");
      ResourceURL resurl = portletResp.createResourceURL();
      resurl.setCacheability(FULL);
      writer.write("<script>\n");
      writer.write("(function () {\n");
      writer.write("   var xhr = new XMLHttpRequest();\n");
      writer.write("   xhr.onreadystatechange=function() {\n");
      writer.write("      if (xhr.readyState==4 && xhr.status==200) {\n");
      writer.write(
            "         document.getElementById(\"RenderStateTests_SPEC1_12_RenderState\").innerHTML=xhr.responseText;\n");
      writer.write("      }\n");
      writer.write("   };\n");
      writer.write(
            "   xhr.open(\"GET\",\"" + resurl.toString() + "\",true);\n");
      writer.write("   xhr.send();\n");
      writer.write("})();\n");
      writer.write("</script>\n");

   }

   public void serveResource(ResourceRequest portletReq,
         ResourceResponse portletResp) throws PortletException, IOException {

      PrintWriter writer = portletResp.getWriter();
      ModuleTestCaseDetails tcd = new ModuleTestCaseDetails();

      /* TestCase: V3RenderStateTests_SPEC1_12_RenderState_getPortletMode2 */
      /*
       * Details: "If the portlet mode is not available, PortletMode.UNDEFINED
       * is returned. The portlet mode would not be available in a resource
       * request invoked with a resource URL having FULL cacheability."
       */
      {
         TestResult result = tcd.getTestResultFailed(
               V3RENDERSTATETESTS_SPEC1_12_RENDERSTATE_GETPORTLETMODE2);
         if (portletReq.getPortletMode().equals(PortletMode.UNDEFINED)) {
            result.setTcSuccess(true);
         } else {
            result.appendTcDetail(
                  "Failed because portlet mode is not UNDEFINED but "
                        + portletReq.getPortletMode());
         }
         result.writeTo(writer);
      }

      /* TestCase: V3RenderStateTests_SPEC1_12_RenderState_getWindowState2 */
      /*
       * Details: "If the window state is not available, WindowState.UNDEFINED
       * is returned. The window state would not be available in a resource
       * request invoked with a resource URL having FULL cacheability."
       */
      {
         TestResult result = tcd.getTestResultFailed(
               V3RENDERSTATETESTS_SPEC1_12_RENDERSTATE_GETWINDOWSTATE2);
// BUG!! >>         if (portletReq.getPortletMode().equals(WindowState.UNDEFINED)) {
         if (portletReq.getWindowState().equals(WindowState.UNDEFINED)) {
            result.setTcSuccess(true);
         } else {
            result.appendTcDetail(
                  "Failed because window state is not UNDEFINED but "
                        + portletReq.getWindowState());
         }
         result.writeTo(writer);
      }

   }

}
