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

import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSPRP_ACTION1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSPRP_ACTION2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSPRP_SETRENDERSTATE1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSPRP_SETRENDERSTATE2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSPRP_SETRENDERSTATE3;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETHUBTESTS_SPEC_23_JSPRP_SETRENDERSTATE4;

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

@PortletConfiguration(portletName = "PortletHubTests_SPEC_23_JSPRP_TX",
                      publicParams = "prptestcase"
                     )
public class PortletHubTests_SPEC_23_JSPRP_TX implements Portlet {
   
   private PortletConfig portletConfig = null;

   @Override
   public void init(PortletConfig config) throws PortletException {
      this.portletConfig = config;
   }

   @Override
   public void destroy() {
   }

   @Override
   @ActionMethod(portletName = "PortletHubTests_SPEC_23_JSPRP_TX", publishingEvents = {
         @PortletQName(namespaceURI="http://www.apache.org/", localPart="prpevent")
   })
   public void processAction(ActionRequest portletReq, ActionResponse portletResp) throws PortletException, IOException {
      
      ActionParameters ap = portletReq.getActionParameters();
      String testcase = ap.getValue("testcase");
      
      if (testcase != null && (testcase.equals(V3PORTLETHUBTESTS_SPEC_23_JSPRP_ACTION1) ||
            testcase.equals(V3PORTLETHUBTESTS_SPEC_23_JSPRP_ACTION2))) {
         
         QName qname = new QName("http://www.apache.org/", "prpevent");
         portletResp.setEvent(qname, testcase);

      }
   }
   
   
   @EventMethod(portletName = "PortletHubTests_SPEC_23_JSPRP_TX", processingEvents = {
         @PortletQName(namespaceURI="http://www.apache.org/", localPart="prpevent")
   })
   public void doEvent(EventRequest eventReq, EventResponse eventResp) {

      MutableRenderParameters mrp = eventResp.getRenderParameters();
      String testcase = (String) eventReq.getEvent().getValue();

      if (testcase == null || testcase.isEmpty()) {
         
         mrp.setValue("status", "Failed. No test case parameter present.");
         
      } else if (testcase.equals(V3PORTLETHUBTESTS_SPEC_23_JSPRP_ACTION1) ||
            testcase.equals(V3PORTLETHUBTESTS_SPEC_23_JSPRP_ACTION2)) {
         
         mrp.setValue("status", "OK");
         mrp.setValue("prptestcase", testcase);
      }

   }


   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp) throws PortletException, IOException {

      PrintWriter writer = portletResp.getWriter();
      ModuleTestCaseDetails tcd = new ModuleTestCaseDetails();

      /* TestCase: V3PortletHubTests_SPEC_23_JSPRP_setRenderState1                  */
      /* Details: "The portlet hub setRenderState function informs the initiating   */
      /* portlet when a public render parameter is set"                             */
      {
         TestButtonAsync button = new TestButtonAsync(V3PORTLETHUBTESTS_SPEC_23_JSPRP_SETRENDERSTATE1);
         button.writeTo(writer);
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSPRP_SETRENDERSTATE1);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSPRP_setRenderState2                  */
      /* Details: "The portlet hub setRenderState function informs other affected   */
      /* portlets when a public render parameter is set"                            */
      {
         TestButtonAsync button = new TestButtonAsync(V3PORTLETHUBTESTS_SPEC_23_JSPRP_SETRENDERSTATE2);
         button.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSPRP_setRenderState3                  */
      /* Details: "The portlet hub setRenderState function allows a public render   */
      /* parameter to be deleted"                                                   */
      {
         TestButtonAsync button = new TestButtonAsync(V3PORTLETHUBTESTS_SPEC_23_JSPRP_SETRENDERSTATE3);
         button.writeTo(writer);
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSPRP_SETRENDERSTATE3);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSPRP_setRenderState4                  */
      /* Details: "The portlet hub setRenderState function informs other affected   */
      /* portlets when public render parameter is deleted"                          */
      {
         TestButtonAsync button = new TestButtonAsync(V3PORTLETHUBTESTS_SPEC_23_JSPRP_SETRENDERSTATE4);
         button.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSPRP_Action1                          */
      /* Details: "The portlet hub action function can cause a public render        */
      /* parameter to be set for the initiating portlet that is target of an event" */
      {
         TestButtonAsync button = new TestButtonAsync(V3PORTLETHUBTESTS_SPEC_23_JSPRP_ACTION1);
         button.writeTo(writer);
         TestResultAsync result = tcd.getTestResultAsyncFailed(V3PORTLETHUBTESTS_SPEC_23_JSPRP_ACTION1);
         result.writeTo(writer);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSPRP_Action2                          */
      /* Details: "The portlet hub action function can cause a public render        */
      /* parameter to be set for a portlet that is target of an event"              */
      {
         TestButtonAsync button = new TestButtonAsync(V3PORTLETHUBTESTS_SPEC_23_JSPRP_ACTION2);
         button.writeTo(writer);
      }

      writer.write("<script>");
      writer.write("   var tck = tck || {};");
      writer.write("   tck.PortletHubTests_SPEC_23_JSPRP_TX = {};");
      writer.write("   tck.PortletHubTests_SPEC_23_JSPRP_TX.pid = '" + portletResp.getNamespace() + "';");
      writer.write("</script>");

      writer.write("<form  id='PortletHubTests_SPEC_23_JSPRP_TX-dummyForm' onsubmit='return false;' enctype='application/x-www-form-urlencoded'>");
      writer.write("</form>");

      StringBuilder txt = new StringBuilder(128);
      txt.append("<script type='text/javascript' src='");
      txt.append(portletConfig.getPortletContext().getContextPath());
      txt.append("/javascript/PortletHubTests_SPEC_23_JSPRP_TX.js'></script>\n");

      writer.write(txt.toString());


   }

}
