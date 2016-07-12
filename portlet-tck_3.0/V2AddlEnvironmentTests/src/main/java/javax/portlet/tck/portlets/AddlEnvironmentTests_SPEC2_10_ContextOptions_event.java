/*
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license
 * agreements. See the NOTICE file distributed with this work for additional information regarding
 * copyright ownership. The ASF licenses this file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License. You may obtain a
 * copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package javax.portlet.tck.portlets;

import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES9;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.EventPortlet;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceServingPortlet;
import javax.portlet.tck.beans.TestButton;
import javax.portlet.tck.constants.Constants;
import javax.xml.namespace.QName;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined in the
 * /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate the test case names
 * defined in the additionalTCs.xml file into the complete list of test case names for execution by the driver.
 * 
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will initiate the
 * events, but not process them. The processing is done in the companion portlet
 * AddlEnvironmentTests_SPEC2_10_ContextOptions_event
 * 
 */
public class AddlEnvironmentTests_SPEC2_10_ContextOptions_event implements Portlet, ResourceServingPortlet, EventPortlet {

   @Override
   public void init(PortletConfig config) throws PortletException {
   }

   @Override
   public void destroy() {
   }

   @Override
   public void processEvent(EventRequest portletReq, EventResponse portletResp) throws PortletException, IOException {
   }

   @SuppressWarnings("deprecation")
   @Override
   public void processAction(ActionRequest portletReq, ActionResponse portletResp) throws PortletException, IOException {

      String tc = portletReq.getParameter(Constants.BUTTON_PARAM_NAME);
      portletResp.setRenderParameter(Constants.BUTTON_PARAM_NAME, tc);
      if (tc != null) {
         if (tc.equals(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES9)) {
            QName qn = new QName(Constants.TCKNAMESPACE, "AddlEnvironmentTests_SPEC2_10_ContextOptions");
            portletResp.setEvent(qn, V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES9);
         }
      }
   }

   @Override
   public void serveResource(ResourceRequest portletReq, ResourceResponse portletResp) throws PortletException, IOException {
   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp) throws PortletException, IOException {
      PrintWriter writer = portletResp.getWriter();
      writer.write("<h3>Event Companion Portlet </h3>\n");
      writer.write("<p>AddlEnvironmentTests_SPEC2_10_ContextOptions_event</p>\n");

      PortletURL aurl = portletResp.createActionURL();
      TestButton tb = new TestButton(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES9, aurl);
      tb.writeTo(writer);

   }

}
