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
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.annotations.PortletConfiguration;
import javax.portlet.annotations.RenderMethod;
import javax.portlet.annotations.Supports;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.util.ModuleTestCaseDetails;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import static javax.portlet.tck.constants.Constants.THREADID_ATTR;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETCONFIGTESTS_CONFIG_GETPORTLETMODES;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined in the
 * /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate the test case names
 * defined in the additionalTCs.xml file into the complete list of test case names for execution by the driver.
 * 
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will initiate the
 * events, but not process them. The processing is done in the companion portlet
 * PortletContextTests_Context_event
 * 
 */
@PortletConfiguration(portletName = "PortletConfigTests_Config",
        supports = {
         @Supports(mimeType = "text/html", portletModes = {"view" , "help", "edit"}),
         @Supports(mimeType = "text/xml", portletModes = {"view", "help"})
        }
   )
public class PortletConfigTests_Config {


   @Inject
   PortletConfig portletConfig;

   public void processAction(ActionRequest portletReq, ActionResponse portletResp) throws PortletException, IOException {
   }

   public void serveResource(ResourceRequest portletReq, ResourceResponse portletResp) throws PortletException, IOException {
   }

   @RenderMethod(portletNames = "PortletConfigTests_Config")
   public void render(RenderRequest portletReq, RenderResponse portletResp) throws PortletException, IOException {

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

      ModuleTestCaseDetails tcd = new ModuleTestCaseDetails();

      /* TestCase: PortletConfigTests_Config_getPortletModes */
      /* Details: "The PortletConfig.getPortletModes method returns the */
      /* supported portlet modes for the given mime type." */
      {
         TestResult result = tcd.getTestResultSucceeded(V3PORTLETCONFIGTESTS_CONFIG_GETPORTLETMODES);
         Enumeration<PortletMode> portletModes = portletConfig.getPortletModes("text/html");
         if (portletModes == null) {
            result.setTcSuccess(false);
            result.appendTcDetail("Portlet Mode list was null.");
         }
         List<PortletMode> modes = Collections.list(portletModes);
         StringBuilder sb = new StringBuilder();
         for (PortletMode mode : modes)
         {
            sb.append(mode);
            sb.append(",");
         }
         result.appendTcDetail(sb.toString());
         if (modes.size() != 3) {
            result.setTcSuccess(false);
            result.appendTcDetail("Portlet Mode list was not correct size: " + modes.size());
         }
         if (!modes.contains(PortletMode.EDIT) || !modes.contains(PortletMode.VIEW) || !modes.contains(PortletMode.HELP)) {
            result.setTcSuccess(false);
            result.appendTcDetail("Portlet Mode list did not contain expected modes");
         }
         result.writeTo(writer);
      }

   }

}
