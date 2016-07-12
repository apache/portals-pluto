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

import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_17_EVENTPREFERENCES_SETVALUES4;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_17_EVENTPREFERENCES_RESET1;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_17_EVENTPREFERENCES_DEPLOYMENT3;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_17_EVENTPREFERENCES_DEPLOYMENT4;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_17_EVENTPREFERENCES_DEPLOYMENT7;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_17_EVENTPREFERENCES_DEPLOYMENT10;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_17_EVENTPREFERENCES_STORE1;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_17_EVENTPREFERENCES_STORE4;
import static javax.portlet.tck.constants.Constants.BUTTON_PARAM_NAME;
import static javax.portlet.tck.constants.Constants.TCKNAMESPACE;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
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
import javax.xml.namespace.QName;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined in the
 * /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate the test case names
 * defined in the additionalTCs.xml file into the complete list of test case names for execution by the driver.
 * 
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will initiate the
 * events, but not process them. The processing is done in the companion portlet
 * AddlEnvironmentTests_SPEC2_17_EventPreferences_event
 * 
 */
@SuppressWarnings("deprecation")
public class AddlEnvironmentTests_SPEC2_17_EventPreferences implements Portlet, ResourceServingPortlet {

   @Override
   public void init(PortletConfig config) throws PortletException {
   }

   @Override
   public void destroy() {
   }

   @Override
   public void processAction(ActionRequest portletReq, ActionResponse portletResp) throws PortletException, IOException {

      portletResp.setRenderParameters(portletReq.getParameterMap());
      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      String tc = portletReq.getParameter(BUTTON_PARAM_NAME);

      QName eventQName = new QName(TCKNAMESPACE, "AddlEnvironmentTests_SPEC2_17_EventPreferences");
      portletResp.setEvent(eventQName, tc);
   }

   @Override
   public void serveResource(ResourceRequest portletReq, ResourceResponse portletResp) throws PortletException, IOException {

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp) throws PortletException, IOException {

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

      /* TestCase: V2AddlEnvironmentTests_SPEC2_17_EventPreferences_setValues4 */
      /* Details: "The setValues method allows the value array to be set to */
      /* null" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2ADDLENVIRONMENTTESTS_SPEC2_17_EVENTPREFERENCES_SETVALUES4, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlEnvironmentTests_SPEC2_17_EventPreferences_reset1 */
      /* Details: "The reset method sets the value of the specified */
      /* preference to its default value. The actual default value itself */
      /* is implementation-specific and cannot be tested." */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2ADDLENVIRONMENTTESTS_SPEC2_17_EVENTPREFERENCES_RESET1, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlEnvironmentTests_SPEC2_17_EventPreferences_store1 */
      /* Details: "The store method persists preference changes previously */
      /* made during the processEvent method" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2ADDLENVIRONMENTTESTS_SPEC2_17_EVENTPREFERENCES_STORE1, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlEnvironmentTests_SPEC2_17_EventPreferences_store4 */
      /* Details: "If preference changes are made during the processEvent */
      /* method, but the method completes without store being called, the */
      /* preference changes are discarded" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2ADDLENVIRONMENTTESTS_SPEC2_17_EVENTPREFERENCES_STORE4, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlEnvironmentTests_SPEC2_17_EventPreferences_deployment3 */
      /* Details: "A preference attribute definition may indicate if the */
      /* attribute is read only" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2ADDLENVIRONMENTTESTS_SPEC2_17_EVENTPREFERENCES_DEPLOYMENT3, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlEnvironmentTests_SPEC2_17_EventPreferences_deployment4 */
      /* Details: "If a preference attribute definition does not contain */
      /* the read-only setting, it will be modifiable in the processAction */
      /* method" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2ADDLENVIRONMENTTESTS_SPEC2_17_EVENTPREFERENCES_DEPLOYMENT4, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlEnvironmentTests_SPEC2_17_EventPreferences_deployment7 */
      /* Details: "If a preference attribute definition contains the */
      /* read-only setting, it will not be modifiable in the processAction */
      /* method" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2ADDLENVIRONMENTTESTS_SPEC2_17_EVENTPREFERENCES_DEPLOYMENT7, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2AddlEnvironmentTests_SPEC2_17_EventPreferences_deployment10 */
      /* Details: "A preference attribute not defined in the deployment */
      /* descriptor may be added programmatically in the processAction */
      /* method" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2ADDLENVIRONMENTTESTS_SPEC2_17_EVENTPREFERENCES_DEPLOYMENT10, aurl);
         tb.writeTo(writer);
      }

   }

}
