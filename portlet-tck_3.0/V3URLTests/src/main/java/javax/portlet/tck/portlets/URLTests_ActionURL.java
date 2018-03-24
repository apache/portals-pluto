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
import javax.portlet.ActionURL;
import javax.portlet.MutableActionParameters;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.annotations.ActionMethod;
import javax.portlet.annotations.RenderMethod;
import javax.portlet.tck.beans.CompareUtils;
import javax.portlet.tck.beans.TestButton;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.util.ModuleTestCaseDetails;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import static javax.portlet.tck.constants.Constants.RESULT_ATTR_PREFIX;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3URLTESTS_ACTIONURL_GETACTIONPARAMETERS;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3URLTESTS_ACTIONURL_GETACTIONPARAMETERS2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3URLTESTS_ACTIONURL_GETACTIONPARAMETERS3;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3URLTESTS_ACTIONURL_SETPARAMETERB7;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case
 * names are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the
 * additionalTCs.xml file into the complete list of test case names for
 * execution by the driver.
 * 
 * This is the main portlet for the test cases. If the test cases call for
 * events, this portlet will initiate the events, but not process them. The
 * processing is done in the companion portlet PortletContextTests_Context_event
 * 
 */

public class URLTests_ActionURL {

   @Inject
   PortletConfig portletConfig;

   @ActionMethod(portletName = "ActionURLTests")
   public void processAction(ActionRequest portletReq,
         ActionResponse portletResp) throws PortletException, IOException {

      // evaluate results for test case
      // V3URLTests_ActionURL_setParameterB7
      {
         ModuleTestCaseDetails tcd = new ModuleTestCaseDetails();
         TestResult tr8 = tcd.getTestResultFailed(
             V3URLTESTS_ACTIONURL_SETPARAMETERB7);
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't defined (test case error)
         if (tcval != null && tcval != null && tcval
             .equals("V3URLTests_ActionURL_setParameterB7")) {
            String[] aval = portletReq.getParameterValues("parm1");
            String[] eval = null;
            CompareUtils.arraysEqual("Request", aval, " expected: ", eval, tr8);
            PortletSession ps = portletReq.getPortletSession();
            ps.setAttribute(
                RESULT_ATTR_PREFIX
                + "V3URLTests_ActionURL_setParameterB7",
                tr8);
            portletResp.setRenderParameter("tc", tcval);
         }
      }
   }

   public void serveResource(ResourceRequest portletReq,
         ResourceResponse portletResp) throws PortletException, IOException {
   }

   @RenderMethod(portletNames = "ActionURLTests")
   public void render(RenderRequest portletReq, RenderResponse portletResp)
         throws PortletException, IOException {

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

      ModuleTestCaseDetails tcd = new ModuleTestCaseDetails();
      ActionURL actionURL = portletResp.createActionURL();
      MutableActionParameters mutableActionParams = actionURL
            .getActionParameters();

      /* TestCase: V3URLTests_ActionURL_getActionParameters */
      /*
       * Details: "Initially the returned object is empty."
       */
      {
         TestResult tr0 = tcd
               .getTestResultFailed(V3URLTESTS_ACTIONURL_GETACTIONPARAMETERS);
         if (mutableActionParams != null && mutableActionParams.isEmpty()) {
            tr0.setTcSuccess(true);
         } else {
            tr0.appendTcDetail("Failed because " + mutableActionParams.size()
                  + " action parameters exist");
         }
         tr0.writeTo(writer);
      }

      /* TestCase: V3URLTests_ActionURL_getActionParameters2 */
      /*
       * Details: "Modifying the parameter values encapsulated by the returned
       * object directly modifies the action parameters applied to the URL."
       */
      {
         TestResult tr1 = tcd
               .getTestResultFailed(V3URLTESTS_ACTIONURL_GETACTIONPARAMETERS2);
         mutableActionParams.setValue("tr1", "true");
         Map<String, String[]> actionParameterMap = actionURL.getParameterMap();
         if (actionParameterMap.containsKey("tr1")
               && actionParameterMap.get("tr1")[0].equals("true")) {
            tr1.setTcSuccess(true);
         } else {
            tr1.appendTcDetail(
                  "Failed because action parameter tr1 set on the returned object is not present in ActionURL");
         }
         tr1.writeTo(writer);
      }

      /* TestCase: V3URLTests_ActionURL_getActionParameters3 */
      /*
       * Details: "Gets the action parameter values set for this URL."
       */
      {
         TestResult tr2 = tcd
               .getTestResultFailed(V3URLTESTS_ACTIONURL_GETACTIONPARAMETERS3);
         mutableActionParams.setValue("tr2", "true");
         MutableActionParameters mutableActionParams_tr2 = actionURL
               .getActionParameters();
         if (!mutableActionParams_tr2.isEmpty()
               && mutableActionParams_tr2.getNames().contains("tr2")
               && mutableActionParams_tr2.getValue("tr2").equals("true")) {
            tr2.setTcSuccess(true);
         } else {
            tr2.appendTcDetail(
                  "Failed because action parameter tr2 set in actionURL cannot be found.");
         }
         tr2.writeTo(writer);
      }

      /* TestCase: V3URLTests_ActionURL_setParameterB7 */
      /* Details: "Method setParameter(String, String[]): If the value is */
      /* null, all values for the specified key are removed" */
      TestResult tr8 = tcd.getTestResultFailed(
          V3URLTESTS_ACTIONURL_SETPARAMETERB7);
      try {
         PortletURL turl = portletResp.createActionURL();
         turl.setParameter("tc",
             "V3URLTests_ActionURL_setParameterB7");
         turl.setParameter("parm1", new String[] { "val1", "val2", "val3" });
         turl.setParameter("parm1", (String[]) null);

         // add the execution button for an action request
         TestButton tb = new TestButton(
             "V3URLTests_ActionURL_setParameterB7", turl);
         tb.writeTo(writer);

         // display evaluated results
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't set (test case error)
         if (tcval != null && tcval != null && tcval
             .equals("V3URLTests_ActionURL_setParameterB7")) {
            PortletSession ps = portletReq.getPortletSession();
            TestResult tmp = (TestResult) ps.getAttribute(RESULT_ATTR_PREFIX
                                                          + "V3URLTests_ActionURL_setParameterB7");
            if (tmp != null) {
               tr8 = tmp;
               ps.removeAttribute(RESULT_ATTR_PREFIX
                                  + "V3URLTests_ActionURL_setParameterB7");
            }
         }
      } catch (Exception e) {
         tr8.appendTcDetail(e);
      }
      tr8.writeTo(writer);

   }

}
