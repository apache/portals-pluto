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
import javax.portlet.MutableRenderParameters;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.RenderParameters;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.RenderURL;
import javax.portlet.WindowState;
import javax.portlet.annotations.PortletApplication;
import javax.portlet.annotations.PortletConfiguration;
import javax.portlet.annotations.PortletQName;
import javax.portlet.annotations.PublicRenderParameterDefinition;
import javax.portlet.tck.beans.TestLink;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.util.ModuleTestCaseDetails;

import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_RENDERSTATE_APIHEADER_GETRENDERPARAMETERS;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_RENDERSTATE_APIHEADER_GETPORTLETMODE;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_RENDERSTATE_APIHEADER_GETWINDOWSTATE;
import static javax.portlet.tck.constants.Constants.RESULT_ATTR_PREFIX;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the 
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 *
 */
@PortletApplication(publicParams = {
      @PublicRenderParameterDefinition(identifier = "tr3_public", qname = @PortletQName(localPart = "tr3_public", namespaceURI = "")) })
@PortletConfiguration(portletName = "HeaderPortletTests_SPEC14_RenderState_ApiHeader", publicParams = {
"tr3_public" })
public class HeaderPortletTests_SPEC14_RenderState_ApiHeader implements Portlet, HeaderPortlet {

   @Override
   public void init(PortletConfig config) throws PortletException {
   }

   @Override
   public void destroy() {
   }

   @Override
   public void processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException, IOException {
   }

   @Override
   public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException, IOException {
     
      PrintWriter writer = renderResponse.getWriter();
      String msg = (String) renderRequest.getAttribute(
            RESULT_ATTR_PREFIX + "HeaderPortletTests_SPEC14_RenderState_ApiHeader");
      writer.write("<p>" + msg + "</p>\n");
      renderRequest.removeAttribute(
            RESULT_ATTR_PREFIX + "HeaderPortletTests_SPEC14_RenderState_ApiHeader");

   }

   @Override
   public void renderHeaders(HeaderRequest headerRequest, HeaderResponse headerResponse)
         throws PortletException, IOException {
      StringWriter writer = new StringWriter();
      
      ModuleTestCaseDetails tcd = new ModuleTestCaseDetails();

      /* TestCase: V3HeaderPortletTests_SPEC14_RenderState_ApiHeader_getPortletMode */
      /* Details: "Method getPortletMode(): Returns current PortletMode "           */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_RENDERSTATE_APIHEADER_GETPORTLETMODE);
         if(headerRequest.getPortletMode().equals(PortletMode.VIEW)){
            result.setTcSuccess(true);
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_RenderState_ApiHeader_getWindowState */
      /* Details: "Method getWindowState(): Returns current WindowState"            */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_RENDERSTATE_APIHEADER_GETWINDOWSTATE);
         if(headerRequest.getWindowState().equals(WindowState.NORMAL)){
            result.setTcSuccess(true);
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_RenderState_ApiHeader_getRenderParameters */
      /* Details: "Method getRenderParameters(): Returns an immutable               */
      /* RenderParameters object representing the private and public render         */
      /* parameters"                                                                */
      RenderParameters renderParams = headerRequest.getRenderParameters();
      if (!renderParams.isEmpty() && renderParams.isPublic("tr3_public")
            && renderParams.getValue("tr3_public") != null
            && renderParams.getValue("tr3_public").equals("true")
            && renderParams.getValue("tr3_private") != null
            && renderParams.getValue("tr3_private").equals("true")) {
         TestResult result = tcd.getTestResultFailed(
               V3HEADERPORTLETTESTS_SPEC14_RENDERSTATE_APIHEADER_GETRENDERPARAMETERS);
         result.setTcSuccess(true);
         result.writeTo(writer);
      } else {
         RenderURL renderURL = headerResponse.createRenderURL();
         MutableRenderParameters mutableRenderParams = renderURL
               .getRenderParameters();
         mutableRenderParams.setValue("tr3_private", "true");
         mutableRenderParams.setValue("tr3_public", "true");
         TestLink tb = new TestLink(
               V3HEADERPORTLETTESTS_SPEC14_RENDERSTATE_APIHEADER_GETRENDERPARAMETERS,
               renderURL);
         tb.writeTo(writer);
      }
      
      headerRequest.setAttribute(
            RESULT_ATTR_PREFIX + "HeaderPortletTests_SPEC14_RenderState_ApiHeader",
            writer.toString());
            
   }

}
