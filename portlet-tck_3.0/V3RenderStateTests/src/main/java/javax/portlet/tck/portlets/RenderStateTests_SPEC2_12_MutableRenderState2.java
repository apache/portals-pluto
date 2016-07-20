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
import javax.portlet.ActionURL;
import javax.portlet.MutableActionParameters;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.annotations.PortletConfiguration;
import javax.portlet.tck.beans.TestButton;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.constants.Constants;
import javax.portlet.tck.util.ModuleTestCaseDetails;

import static javax.portlet.tck.util.ModuleTestCaseDetails.*;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case
 * names are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the
 * additionalTCs.xml file into the complete list of test case names for
 * execution by the driver.
 *
 */

@PortletConfiguration(portletName = "RenderStateTests_SPEC2_12_MutableRenderState2")
public class RenderStateTests_SPEC2_12_MutableRenderState2 implements Portlet {

   @Override
   public void init(PortletConfig config) throws PortletException {
   }

   @Override
   public void destroy() {
   }

   @Override
   public void processAction(ActionRequest portletReq,
         ActionResponse portletResp) throws PortletException, IOException {
      
      ModuleTestCaseDetails tcd = new ModuleTestCaseDetails();
      StringWriter writer = new StringWriter();
      
      /*
       * TestCase:
       * V3RenderStateTests_SPEC2_12_MutableRenderState_getRenderParameters3
       */
      /*
       * Details:
       * "If no render parameters are available, the object will be empty."
       */
      TestResult result = tcd.getTestResultFailed(
            V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_GETRENDERPARAMETERS3);
      if(portletResp.getRenderParameters().isEmpty()){
         result.setTcSuccess(true);
      }
      result.writeTo(writer);
      
      PortletSession ps = portletReq.getPortletSession();
      ps.setAttribute(Constants.RESULT_ATTR_PREFIX + "RenderStateTests_SPEC2_12_MutableRenderState2", writer.toString());
      
   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp)
         throws PortletException, IOException {

      portletResp.setContentType("text/html");
      PrintWriter writer = portletResp.getWriter();

      PortletSession ps = portletReq.getPortletSession();
      String msg = (String) ps.getAttribute(Constants.RESULT_ATTR_PREFIX + "RenderStateTests_SPEC2_12_MutableRenderState2");
      ps.removeAttribute(Constants.RESULT_ATTR_PREFIX + "RenderStateTests_SPEC2_12_MutableRenderState2");

      if (msg != null && msg.length() > 0) {
         writer.write("<p>" + msg + "</p>\n");
      }
      
      /*
       * TestCase:
       * V3RenderStateTests_SPEC2_12_MutableRenderState_getRenderParameters3
       */
      /*
       * Details:
       * "If no render parameters are available, the object will be empty."
       */
      {
         ActionURL actionURL = portletResp.createActionURL();
         MutableActionParameters mutableActionParams = actionURL
               .getActionParameters();
         mutableActionParams.clear();
         TestButton tb = new TestButton(
               V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_GETRENDERPARAMETERS3,
               actionURL);
         tb.writeTo(writer);
      }

   }

}
