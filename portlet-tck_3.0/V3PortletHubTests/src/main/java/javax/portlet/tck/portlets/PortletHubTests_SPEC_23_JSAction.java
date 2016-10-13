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

import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSACTION_ACTION1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSACTION_ACTION2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSACTION_ACTION3;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSACTION_ACTION4;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSACTION_ACTION5;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSACTION_ACTION6;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSACTION_ACTION7;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.ActionParameters;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.MutableRenderParameters;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.annotations.ActionMethod;
import javax.portlet.annotations.EventMethod;
import javax.portlet.annotations.PortletConfiguration;
import javax.portlet.annotations.PortletQName;
import javax.portlet.tck.beans.TestButtonAsync;
import javax.portlet.tck.beans.TestResultAsync;
import javax.portlet.tck.util.ModuleTestCaseDetails;
import javax.xml.namespace.QName;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the 
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 *
 */

@PortletConfiguration(portletName = "PortletHubTests_SPEC_23_JSAction")
public class PortletHubTests_SPEC_23_JSAction implements Portlet {
   
   private PortletConfig portletConfig = null;

   @Override
   public void init(PortletConfig config) throws PortletException {
      this.portletConfig = config;
   }

   @Override
   public void destroy() {
   }

   @Override
   @ActionMethod(portletName = "PortletHubTests_SPEC_23_JSAction", publishingEvents = {
         @PortletQName(namespaceURI="http://www.apache.org/", localPart="event")
   })
   public void processAction(ActionRequest portletReq, ActionResponse portletResp) throws PortletException, IOException {
      
      MutableRenderParameters mrp = portletResp.getRenderParameters();
      String testcase = mrp.getValue("testcase");
      ActionParameters ap = portletReq.getActionParameters();
      
      if (testcase == null || testcase.isEmpty()) {
         mrp.setValue("status", "Failed. No test case parameter present.");
      } else if (testcase.equals(V3PORTLETHUBTESTS_SPEC_23_JSACTION_ACTION1)) {
         mrp.setValue("status", "OK");
      } else if (testcase.equals(V3PORTLETHUBTESTS_SPEC_23_JSACTION_ACTION2)) {
         String param = ap.getValue("param1");
         String status = "OK";
         if (param == null || !param.equals("val1")) {
            status = "Failed. Action parameter had incorrect value: " + param;
         }
         mrp.setValue("status", status);
      } else if (testcase.equals(V3PORTLETHUBTESTS_SPEC_23_JSACTION_ACTION3)) {
         String formParam = ap.getValue("formParam");
         String status = "OK";
         if (formParam == null || !formParam.equals(V3PORTLETHUBTESTS_SPEC_23_JSACTION_ACTION3)) {
            status = "Failed. Form parameter had incorrect value: " + formParam;
         }
         mrp.setValue("status", status);
      } else if (testcase.equals(V3PORTLETHUBTESTS_SPEC_23_JSACTION_ACTION4)) {
         String param = ap.getValue("param1");
         String formParam = ap.getValue("formParam");
         String status = "OK";
         if (formParam == null || !formParam.equals(V3PORTLETHUBTESTS_SPEC_23_JSACTION_ACTION4)) {
            status = "Failed. Form parameter had incorrect value: " + formParam;
         } else if (param == null || !param.equals("val1")) {
            status = "Failed. Action parameter had incorrect value: " + param;
         }
         mrp.setValue("status", status);
      } else if (testcase.equals(V3PORTLETHUBTESTS_SPEC_23_JSACTION_ACTION5)) {
         mrp.setValue("status", "OK");
      } else if (testcase.equals(V3PORTLETHUBTESTS_SPEC_23_JSACTION_ACTION6)) {
         QName qname = new QName("http://www.apache.org/", "event");
         portletResp.setEvent(qname, "hi");;
      } else if (testcase.equals(V3PORTLETHUBTESTS_SPEC_23_JSACTION_ACTION7)) {
         mrp.setValue("status", "OK");
      }
      
   }
   
   
   @EventMethod(portletName = "PortletHubTests_SPEC_23_JSAction", processingEvents = {
         @PortletQName(namespaceURI="http://www.apache.org/", localPart="event")
   })
   public void doEvent(EventRequest eventReq, EventResponse eventResp) {

      MutableRenderParameters mrp = eventResp.getRenderParameters();
      String testcase = mrp.getValue("testcase");

      if (testcase == null || testcase.isEmpty()) {
         mrp.setValue("status", "Failed. No test case parameter present.");
      } else if (testcase.equals(V3PORTLETHUBTESTS_SPEC_23_JSACTION_ACTION6)) {
         mrp.setValue("status", "OK");
      } else {
         mrp.setValue("status", "Failed. Unknown test case: " + testcase);
      }

   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp) throws PortletException, IOException {

      PrintWriter writer = portletResp.getWriter();
      ModuleTestCaseDetails tcd = new ModuleTestCaseDetails();

      /* TestCase: V3PortletHubTests_SPEC_23_JSAction_Action1                       */
      /* Details: "The portlet hub action function can be called with no arguments" */
      {
         TestButtonAsync button = new TestButtonAsync(V3PORTLETHUBTESTS_SPEC_23_JSACTION_ACTION1);
         button.writeTo(writer);
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSACTION_ACTION1);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSAction_Action2                       */
      /* Details: "The portlet hub action function can be called with an action     */
      /* parameters argument"                                                       */
      {
         TestButtonAsync button = new TestButtonAsync(V3PORTLETHUBTESTS_SPEC_23_JSACTION_ACTION2);
         button.writeTo(writer);
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSACTION_ACTION2);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSAction_Action3                       */
      /* Details: "The portlet hub action function can be called with a form        */
      /* element argument"                                                          */
      {
         TestButtonAsync button = new TestButtonAsync(V3PORTLETHUBTESTS_SPEC_23_JSACTION_ACTION3);
         button.writeTo(writer);
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSACTION_ACTION3);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSAction_Action4                       */
      /* Details: "The portlet hub action function can be called with both action   */
      /* parameters and form element arguments"                                     */
      {
         TestButtonAsync button = new TestButtonAsync(V3PORTLETHUBTESTS_SPEC_23_JSACTION_ACTION4);
         button.writeTo(writer);
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSACTION_ACTION4);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSAction_Action5                       */
      /* Details: "The portlet hub action function can cause a private render       */
      /* parameter to be set for the initiating portlet"                            */
      {
         TestButtonAsync button = new TestButtonAsync(V3PORTLETHUBTESTS_SPEC_23_JSACTION_ACTION5);
         button.writeTo(writer);
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSACTION_ACTION5);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSAction_Action6                       */
      /* Details: "The portlet hub action function can cause a private render       */
      /* parameter to be set for a portlet that is target of an event"              */
      {
         TestButtonAsync button = new TestButtonAsync(V3PORTLETHUBTESTS_SPEC_23_JSACTION_ACTION6);
         button.writeTo(writer);
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSACTION_ACTION6);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSAction_Action7                       */
      /* Details: "The portlet hub action function fulfills the promise when the    */
      /* action is complete"                                                        */
      {
         TestButtonAsync button = new TestButtonAsync(V3PORTLETHUBTESTS_SPEC_23_JSACTION_ACTION7);
         button.writeTo(writer);
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSACTION_ACTION7);
         result.writeTo(writer);
      }

      writer.write("<script>");
      writer.write("   var tck = tck || {};");
      writer.write("   tck.PortletHubTests_SPEC_23_JSAction = {};");
      writer.write("   tck.PortletHubTests_SPEC_23_JSAction.pid = '" + portletResp.getNamespace() + "';");
      writer.write("</script>");

      writer.write("<form  id='PortletHubTests_SPEC_23_JSAction-dummyForm' onsubmit='return false;' enctype='application/x-www-form-urlencoded'>");
      writer.write("</form>");

      StringBuilder txt = new StringBuilder(128);
      txt.append("<script type='text/javascript' src='");
      txt.append(portletConfig.getPortletContext().getContextPath());
      txt.append("/javascript/PortletHubTests_SPEC_23_JSAction.js'></script>\n");

      writer.write(txt.toString());


   }

}
