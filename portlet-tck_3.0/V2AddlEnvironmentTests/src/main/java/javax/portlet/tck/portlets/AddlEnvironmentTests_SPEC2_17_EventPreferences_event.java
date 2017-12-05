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

import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_17_EVENTPREFERENCES_DEPLOYMENT10;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_17_EVENTPREFERENCES_DEPLOYMENT3;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_17_EVENTPREFERENCES_DEPLOYMENT4;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_17_EVENTPREFERENCES_DEPLOYMENT7;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_17_EVENTPREFERENCES_RESET1;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_17_EVENTPREFERENCES_SETVALUES4;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_17_EVENTPREFERENCES_STORE1;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_17_EVENTPREFERENCES_STORE4;
import static javax.portlet.tck.constants.Constants.BUTTON_PARAM_NAME;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.EventPortlet;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletSession;
import javax.portlet.ReadOnlyException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceServingPortlet;
import javax.portlet.tck.beans.JSR286SpecTestCaseDetails;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.constants.Constants;

/**
 * This is the event processing portlet for the test cases. This portlet processes events, but does not publish them.
 * Events are published in the main portlet for the test cases.
 */
@SuppressWarnings("deprecation")
public class AddlEnvironmentTests_SPEC2_17_EventPreferences_event implements Portlet, EventPortlet, ResourceServingPortlet {

   @Override
   public void init(PortletConfig config) throws PortletException {
   }

   @Override
   public void destroy() {
   }

   @Override
   public void processAction(ActionRequest portletReq, ActionResponse portletResp) throws PortletException, IOException {
   }

   @Override
   public void serveResource(ResourceRequest portletReq, ResourceResponse portletResp) throws PortletException, IOException {
   }

   @Override
   public void processEvent(EventRequest portletReq, EventResponse portletResp) throws PortletException, IOException {

      portletResp.setRenderParameters(portletReq);
      StringWriter writer = new StringWriter();
      JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();
      PortletPreferences portletPrefs = portletReq.getPreferences();
      String tc = (String) portletReq.getEvent().getValue();
      portletResp.setRenderParameter(BUTTON_PARAM_NAME, tc);

      // Create result objects for the tests

      /* TestCase: V2AddlEnvironmentTests_SPEC2_17_EventPreferences_store1 */
      /* Details: "The store method persists preference changes previously */
      /* made during the processEvent method" */
      {
         if (tc.equals(V2ADDLENVIRONMENTTESTS_SPEC2_17_EVENTPREFERENCES_STORE1)) {
            portletPrefs.setValue(V2ADDLENVIRONMENTTESTS_SPEC2_17_EVENTPREFERENCES_STORE1, "true");
            try {
               portletPrefs.store();
            } catch (Throwable t) {
               TestResult result = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_17_EVENTPREFERENCES_STORE1);
               result.appendTcDetail("Exception storing value.");
               result.appendTcDetail(t);
               portletReq.getPortletSession().setAttribute(V2ADDLENVIRONMENTTESTS_SPEC2_17_EVENTPREFERENCES_STORE1, result);
            }
         }
      }

      /* TestCase: V2AddlEnvironmentTests_SPEC2_17_EventPreferences_store4 */
      /* Details: "If preference changes are made during the processEvent */
      /* method, but the method completes without store being called, the */
      /* preference changes are discarded" */
      {
         if (tc.equals(V2ADDLENVIRONMENTTESTS_SPEC2_17_EVENTPREFERENCES_STORE4)) {
            portletPrefs.setValue(V2ADDLENVIRONMENTTESTS_SPEC2_17_EVENTPREFERENCES_STORE4, "true");
         }
      }

      if (!tc.equals(V2ADDLENVIRONMENTTESTS_SPEC2_17_EVENTPREFERENCES_STORE4) && !tc.equals(V2ADDLENVIRONMENTTESTS_SPEC2_17_EVENTPREFERENCES_STORE4)) {

         /* TestCase: V2AddlEnvironmentTests_SPEC2_17_EventPreferences_setValues4 */
         /* Details: "The setValues method allows the value array to be set to */
         /* null" */
         TestResult tr0 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_17_EVENTPREFERENCES_SETVALUES4);
         try {
            portletPrefs.setValues("tr0", (String[])null);
            tr0.setTcSuccess(true);
         } catch (Exception e) {
            tr0.appendTcDetail(e.toString());
         }
         tr0.writeTo(writer);

         /* TestCase: V2AddlEnvironmentTests_SPEC2_17_EventPreferences_reset1 */
         /* Details: "The reset method sets the value of the specified */
         /* preference to its default value. The actual default value itself */
         /* is implementation-specific and cannot be tested." */
         TestResult tr1 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_17_EVENTPREFERENCES_RESET1);
         portletPrefs.setValue("tr1", "false");
         portletPrefs.reset("tr1");
         if (portletPrefs.getValue("tr1", null).equals("true")) {
            tr1.setTcSuccess(true);
         } else {
            tr1.appendTcDetail("Failed because tr1 value is not true but " + portletPrefs.getValue("tr1", null));
         }
         tr1.writeTo(writer);

         /* TestCase: V2AddlEnvironmentTests_SPEC2_17_EventPreferences_store1 */
         /* Details: "The store method persists preference changes previously */
         /* made during the processAction method" */
         portletResp.setRenderParameter("tr2", "true");
         portletPrefs.setValue("tr2", "true");
         portletPrefs.store();

         /* TestCase: V2AddlEnvironmentTests_SPEC2_17_EventPreferences_store4 */
         /* Details: "If preference changes are made during the processAction */
         /* method, but the method completes without store being called, the */
         /* preference changes are discarded" */
         portletResp.setRenderParameter("tr3", "true");
         portletPrefs.setValue("tr3", "true");

         /* TestCase: V2AddlEnvironmentTests_SPEC2_17_EventPreferences_deployment3 */
         /* Details: "A preference attribute definition may indicate if the */
         /* attribute is read only" */
         TestResult tr4 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_17_EVENTPREFERENCES_DEPLOYMENT3);
         if (portletPrefs.isReadOnly("tr4")) {
            tr4.setTcSuccess(true);
         } else {
            tr4.appendTcDetail("Failed because tr4 is not read-only");
         }
         tr4.writeTo(writer);

         /* TestCase: V2AddlEnvironmentTests_SPEC2_17_EventPreferences_deployment4 */
         /* Details: "If a preference attribute definition does not contain */
         /* the read-only setting, it will be modifiable in the processAction */
         /* method" */
         TestResult tr5 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_17_EVENTPREFERENCES_DEPLOYMENT4);
         try {
            portletPrefs.setValue("tr5", "true");
            if (portletPrefs.getValue("tr5", null).equals("true")) {
               tr5.setTcSuccess(true);
            } else {
               tr5.appendTcDetail("Failed because tr5 is not true but " + portletPrefs.getValue("tr5", null));
            }
         } catch (Exception e) {
            tr5.appendTcDetail(e.toString());
         }
         tr5.writeTo(writer);

         /* TestCase: V2AddlEnvironmentTests_SPEC2_17_EventPreferences_deployment7 */
         /* Details: "If a preference attribute definition contains the */
         /* read-only setting, it will not be modifiable in the processAction */
         /* method" */
         TestResult tr6 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_17_EVENTPREFERENCES_DEPLOYMENT7);
         try {
            portletPrefs.setValue("tr6", "true");
         } catch (ReadOnlyException e) {
            tr6.setTcSuccess(true);
            tr6.appendTcDetail(e.toString());
         }
         tr6.writeTo(writer);

         /* TestCase: V2AddlEnvironmentTests_SPEC2_17_EventPreferences_deployment10 */
         /* Details: "A preference attribute not defined in the deployment */
         /* descriptor may be added programmatically in the processAction */
         /* method" */
         TestResult tr7 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_17_EVENTPREFERENCES_DEPLOYMENT10);
         try {
            portletPrefs.setValue("tr7", "true");
            tr7.setTcSuccess(true);
         } catch (ReadOnlyException e) {
            tr7.appendTcDetail(e.toString());
         }
         tr7.writeTo(writer);

         PortletSession ps = portletReq.getPortletSession();
         ps.setAttribute(Constants.RESULT_ATTR_PREFIX + "AddlEnvironmentTests_SPEC2_17_EventPreferences", writer.toString());

      }
   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp) throws PortletException, IOException {

      portletResp.setContentType("text/html");
      PrintWriter writer = portletResp.getWriter();
      writer.write("<h3>Event Companion Portlet </h3>\n");
      writer.write("<p>AddlEnvironmentTests_SPEC2_17_EventPreferences_event</p>\n");

      String tc = portletReq.getParameter(BUTTON_PARAM_NAME);
      JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();
      PortletPreferences portletPrefs = portletReq.getPreferences();

      PortletSession ps = portletReq.getPortletSession();
      String msg = (String) ps.getAttribute(Constants.RESULT_ATTR_PREFIX + "AddlEnvironmentTests_SPEC2_17_EventPreferences");
      ps.removeAttribute(Constants.RESULT_ATTR_PREFIX + "AddlEnvironmentTests_SPEC2_17_EventPreferences");

      if (tc == null && msg == null) {
         msg = "Not ready. click test case link.";
      }
      if (msg != null && msg.length() > 0) {
         writer.write("<p>" + msg + "</p>\n");
      }

      /* TestCase: V2AddlEnvironmentTests_SPEC2_17_EventPreferences_store1 */
      /* Details: "The store method persists preference changes previously */
      /* made during the processEvent method" */
      {
         if (tc != null && tc.equals(V2ADDLENVIRONMENTTESTS_SPEC2_17_EVENTPREFERENCES_STORE1)) {
            TestResult result = (TestResult) ps.getAttribute(V2ADDLENVIRONMENTTESTS_SPEC2_17_EVENTPREFERENCES_STORE1);
            if (result == null) {
               result = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_17_EVENTPREFERENCES_STORE1);
               String val = portletPrefs.getValue(V2ADDLENVIRONMENTTESTS_SPEC2_17_EVENTPREFERENCES_STORE1, null);
               if (val != null && val.equals("true")) {
                  result.setTcSuccess(true);
               } else {
                  StringBuilder txt = new StringBuilder(128);
                  txt.append("Preference could not be retrieved. ");
                  txt.append("name: ").append(V2ADDLENVIRONMENTTESTS_SPEC2_17_EVENTPREFERENCES_STORE1);
                  txt.append(", value: ").append(val);
                  result.appendTcDetail(txt.toString());
               }

            }
            result.writeTo(writer);
         }
      }

      /* TestCase: V2AddlEnvironmentTests_SPEC2_17_EventPreferences_Store4 */
      /* Details: "The store method persists preference changes previously */
      /* made during the processEvent method" */
      {
         if (tc != null && tc.equals(V2ADDLENVIRONMENTTESTS_SPEC2_17_EVENTPREFERENCES_STORE4)) {
            TestResult result = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_17_EVENTPREFERENCES_STORE4);
            String val = portletPrefs.getValue(V2ADDLENVIRONMENTTESTS_SPEC2_17_EVENTPREFERENCES_STORE4, null);
            if (val == null) {
               result.setTcSuccess(true);
            } else {
               StringBuilder txt = new StringBuilder(128);
               txt.append("Preference could be retrieved. ");
               txt.append("name: ").append(V2ADDLENVIRONMENTTESTS_SPEC2_17_EVENTPREFERENCES_STORE4);
               txt.append(", value: ").append(val);
               result.appendTcDetail(txt.toString());
            }
            result.writeTo(writer);
         }
      }

   }

}
