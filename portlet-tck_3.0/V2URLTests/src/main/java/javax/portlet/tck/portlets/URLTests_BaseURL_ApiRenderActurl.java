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
import java.util.HashMap;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletSecurityException;
import javax.portlet.PortletSession;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.tck.beans.CompareUtils;
import javax.portlet.tck.beans.JSR286ApiTestCaseDetails;
import javax.portlet.tck.beans.TestButton;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.beans.TestSetupLink;

import static javax.portlet.tck.constants.Constants.THREADID_ATTR;
import static javax.portlet.tck.constants.Constants.RESULT_ATTR_PREFIX;
import static javax.portlet.tck.constants.Constants.BUTTON_PARAM_NAME;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERA1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERA4;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERA6;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERA7;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERB1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERB4;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERB6;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERB7;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERS1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERS4;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERS6;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERS7;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERS8;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_BASEURL_APIRENDERACTURL_SETSECURE2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_BASEURL_APIRENDERACTURL_TOSTRING;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_BASEURL_APIRENDERACTURL_WRITEA1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_BASEURL_APIRENDERACTURL_WRITEB1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERA8;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERB8;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERS9;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERS10;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERS12;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_BASEURL_APIRENDERACTURL_GETPARAMETERMAP1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_BASEURL_APIRENDERACTURL_GETPARAMETERMAP3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_BASEURL_APIRENDERACTURL_GETPARAMETERMAP6;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_BASEURL_APIRENDERACTURL_ADDPROPERTY1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_BASEURL_APIRENDERACTURL_ADDPROPERTY3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_BASEURL_APIRENDERACTURL_SETPROPERTY1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_BASEURL_APIRENDERACTURL_SETPROPERTY3;


/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case
 * names are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the
 * additionalTCs.xml file into the complete list of test case names for
 * execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for
 * events, this portlet will initiate the events, but not process them. The
 * processing is done in the companion portlet
 * URLTests_BaseURL_ApiRenderActurl_event
 *
 */
public class URLTests_BaseURL_ApiRenderActurl implements Portlet {

   @Override
   public void init(PortletConfig config) throws PortletException {
   }

   @Override
   public void destroy() {
   }

   @Override
   public void processAction(ActionRequest portletReq,
         ActionResponse portletResp) throws PortletException, IOException {

      portletResp.setRenderParameters(portletReq.getParameterMap());
      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      // evaluate results for test case
      // V2URLTests_BaseURL_ApiRenderActurl_setParameterA1
      {
         JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();
         TestResult tr0 = tcd.getTestResultFailed(
               V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERA1);
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't defined (test case error)
         if (tcval != null && tcval != null && tcval
               .equals("V2URLTests_BaseURL_ApiRenderActurl_setParameterA1")) {
            String aval = portletReq.getParameter("parm1");
            String eval = "val1";
            CompareUtils.stringsEqual("Request", aval, " expected: ", eval,
                  tr0);
            PortletSession ps = portletReq.getPortletSession();
            ps.setAttribute(
                  RESULT_ATTR_PREFIX
                        + "V2URLTests_BaseURL_ApiRenderActurl_setParameterA1",
                  tr0);
         }
      }

      // evaluate results for test case
      // V2URLTests_BaseURL_ApiRenderActurl_setParameterA4
      {
         JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();
         TestResult tr1 = tcd.getTestResultFailed(
               V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERA4);
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't defined (test case error)
         if (tcval != null && tcval != null && tcval
               .equals("V2URLTests_BaseURL_ApiRenderActurl_setParameterA4")) {
            String aval = portletReq.getParameter("parm1");
            String eval = "val1";
            CompareUtils.stringsEqual("Request", aval, " expected: ", eval,
                  tr1);
            PortletSession ps = portletReq.getPortletSession();
            ps.setAttribute(
                  RESULT_ATTR_PREFIX
                        + "V2URLTests_BaseURL_ApiRenderActurl_setParameterA4",
                  tr1);
         }
      }

      // evaluate results for test case
      // V2URLTests_BaseURL_ApiRenderActurl_setParameterA6
      {
         JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();
         TestResult tr2 = tcd.getTestResultFailed(
               V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERA6);
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't defined (test case error)
         if (tcval != null && tcval != null && tcval
               .equals("V2URLTests_BaseURL_ApiRenderActurl_setParameterA6")) {
            String aval = portletReq.getParameter("parm1");
            String eval = "newVal";
            CompareUtils.stringsEqual("Request", aval, " expected: ", eval,
                  tr2);
            PortletSession ps = portletReq.getPortletSession();
            ps.setAttribute(
                  RESULT_ATTR_PREFIX
                        + "V2URLTests_BaseURL_ApiRenderActurl_setParameterA6",
                  tr2);
         }
      }

      // evaluate results for test case
      // V2URLTests_BaseURL_ApiRenderActurl_setParameterA7
      {
         JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();
         TestResult tr3 = tcd.getTestResultFailed(
             V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERA7);
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't defined (test case error)
         if (tcval != null && tcval != null && tcval
             .equals("V2URLTests_BaseURL_ApiRenderActurl_setParameterA7")) {
            String aval = portletReq.getParameter("parm1");
            String eval = null;
            CompareUtils.stringsEqual("Request", aval, " expected: ", eval,
                tr3);
            PortletSession ps = portletReq.getPortletSession();
            ps.setAttribute(
                RESULT_ATTR_PREFIX
                    + "V2URLTests_BaseURL_ApiRenderActurl_setParameterA7",
                tr3);
         }
      }

      // evaluate results for test case
      // V2URLTests_BaseURL_ApiRenderActurl_setParameterB1
      {
         JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();
         TestResult tr5 = tcd.getTestResultFailed(
               V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERB1);
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't defined (test case error)
         if (tcval != null && tcval != null && tcval
               .equals("V2URLTests_BaseURL_ApiRenderActurl_setParameterB1")) {
            String[] aval = portletReq.getParameterValues("parm1");
            String[] eval = new String[] { "val1", "val2" };
            CompareUtils.arraysEqual("Request", aval, " expected: ", eval, tr5);
            PortletSession ps = portletReq.getPortletSession();
            ps.setAttribute(
                  RESULT_ATTR_PREFIX
                        + "V2URLTests_BaseURL_ApiRenderActurl_setParameterB1",
                  tr5);
         }
      }

      // evaluate results for test case
      // V2URLTests_BaseURL_ApiRenderActurl_setParameterB4
      {
         JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();
         TestResult tr6 = tcd.getTestResultFailed(
               V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERB4);
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't defined (test case error)
         if (tcval != null && tcval != null && tcval
               .equals("V2URLTests_BaseURL_ApiRenderActurl_setParameterB4")) {
            String[] aval = portletReq.getParameterValues("parm1");
            String[] eval = new String[] { "val1", "val2" };
            CompareUtils.arraysEqual("Request", aval, " expected: ", eval, tr6);
            PortletSession ps = portletReq.getPortletSession();
            ps.setAttribute(
                  RESULT_ATTR_PREFIX
                        + "V2URLTests_BaseURL_ApiRenderActurl_setParameterB4",
                  tr6);
         }
      }

      // evaluate results for test case
      // V2URLTests_BaseURL_ApiRenderActurl_setParameterB6
      {
         JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();
         TestResult tr7 = tcd.getTestResultFailed(
               V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERB6);
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't defined (test case error)
         if (tcval != null && tcval != null && tcval
               .equals("V2URLTests_BaseURL_ApiRenderActurl_setParameterB6")) {
            String[] aval = portletReq.getParameterValues("parm1");
            String[] eval = new String[] { "newVal" };
            CompareUtils.arraysEqual("Request", aval, " expected: ", eval, tr7);
            PortletSession ps = portletReq.getPortletSession();
            ps.setAttribute(
                  RESULT_ATTR_PREFIX
                        + "V2URLTests_BaseURL_ApiRenderActurl_setParameterB6",
                  tr7);
         }
      }

      // evaluate results for test case
      // V2URLTests_BaseURL_ApiRenderActurl_setParameters1
      {
         JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();
         TestResult tr10 = tcd.getTestResultFailed(
               V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERS1);
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't defined (test case error)
         if (tcval != null && tcval != null && tcval
               .equals("V2URLTests_BaseURL_ApiRenderActurl_setParameters1")) {
            Map<String, String[]> aval = portletReq.getParameterMap();
            Map<String, String[]> eval = new HashMap<String, String[]>();
            eval.put("tc", new String[] {
                  "V2URLTests_BaseURL_ApiRenderActurl_setParameters1" });
            eval.put("parm1", new String[] { "val1", "val2" });
            eval.put(BUTTON_PARAM_NAME, new String[] {
                  V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERS1 });
            CompareUtils.mapsEqual("Request", aval, " expected: ", eval, tr10);
            PortletSession ps = portletReq.getPortletSession();
            ps.setAttribute(
                  RESULT_ATTR_PREFIX
                        + "V2URLTests_BaseURL_ApiRenderActurl_setParameters1",
                  tr10);
         }
      }

      // evaluate results for test case
      // V2URLTests_BaseURL_ApiRenderActurl_setParameters4
      {
         JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();
         TestResult tr11 = tcd.getTestResultFailed(
               V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERS4);
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't defined (test case error)
         if (tcval != null && tcval != null && tcval
               .equals("V2URLTests_BaseURL_ApiRenderActurl_setParameters4")) {
            Map<String, String[]> aval = portletReq.getParameterMap();
            Map<String, String[]> eval = new HashMap<String, String[]>();
            eval.put("tc", new String[] {
                  "V2URLTests_BaseURL_ApiRenderActurl_setParameters4" });
            eval.put("parm1", new String[] { "val1", "val2" });
            eval.put(BUTTON_PARAM_NAME, new String[] {
                  V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERS4 });
            CompareUtils.mapsEqual("Request", aval, " expected: ", eval, tr11);
            PortletSession ps = portletReq.getPortletSession();
            ps.setAttribute(
                  RESULT_ATTR_PREFIX
                        + "V2URLTests_BaseURL_ApiRenderActurl_setParameters4",
                  tr11);
         }
      }

      // evaluate results for test case
      // V2URLTests_BaseURL_ApiRenderActurl_setParameters6
      {
         JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();
         TestResult tr12 = tcd.getTestResultFailed(
               V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERS6);
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't defined (test case error)
         if (tcval != null && tcval != null && tcval
               .equals("V2URLTests_BaseURL_ApiRenderActurl_setParameters6")) {
            Map<String, String[]> aval = portletReq.getParameterMap();
            Map<String, String[]> eval = new HashMap<String, String[]>();
            eval.put("tc", new String[] {
                  "V2URLTests_BaseURL_ApiRenderActurl_setParameters6" });
            eval.put("parm1", new String[] { "val1", "val2" });
            eval.put(BUTTON_PARAM_NAME, new String[] {
                  V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERS6 });
            CompareUtils.mapsEqual("Request", aval, " expected: ", eval, tr12);
            PortletSession ps = portletReq.getPortletSession();
            ps.setAttribute(
                  RESULT_ATTR_PREFIX
                        + "V2URLTests_BaseURL_ApiRenderActurl_setParameters6",
                  tr12);
         }
      }

      // evaluate results for test case
      // V2URLTests_BaseURL_ApiRenderActurl_setParameters7
      {
         JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();
         TestResult tr13 = tcd.getTestResultFailed(
               V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERS7);
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't defined (test case error)
         if (tcval != null && tcval != null && tcval
               .equals("V2URLTests_BaseURL_ApiRenderActurl_setParameters7")) {
            Map<String, String[]> aval = portletReq.getParameterMap();
            Map<String, String[]> eval = new HashMap<String, String[]>();
            eval.put("tc", new String[] {
                  "V2URLTests_BaseURL_ApiRenderActurl_setParameters7" });
            eval.put("parm1", new String[] { "val1", "val2" });
            eval.put("tckPRP1", new String[] {
                  "V2URLTests_BaseURL_ApiRenderActurl_setParameters7" });
            eval.put(BUTTON_PARAM_NAME, new String[] {
                  V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERS7 });
            CompareUtils.mapsEqual("Request", aval, " expected: ", eval, tr13);
            PortletSession ps = portletReq.getPortletSession();
            ps.setAttribute(
                  RESULT_ATTR_PREFIX
                        + "V2URLTests_BaseURL_ApiRenderActurl_setParameters7",
                  tr13);
         }
      }

      // evaluate results for test case
      // V2URLTests_BaseURL_ApiRenderActurl_setParameters8
      {
         JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();
         TestResult tr14 = tcd.getTestResultFailed(
               V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERS8);
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't defined (test case error)
         if (tcval != null && tcval != null && tcval
               .equals("V2URLTests_BaseURL_ApiRenderActurl_setParameters8")) {
            Map<String, String[]> aval = portletReq.getParameterMap();
            Map<String, String[]> eval = new HashMap<String, String[]>();
            eval.put("tc", new String[] {
                  "V2URLTests_BaseURL_ApiRenderActurl_setParameters8" });
            eval.put("parm1", new String[] { "val1", "val2" });
            eval.put(BUTTON_PARAM_NAME, new String[] {
                  V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERS8 });
            CompareUtils.mapsEqual("Request", aval, " expected: ", eval, tr14);
            PortletSession ps = portletReq.getPortletSession();
            ps.setAttribute(
                  RESULT_ATTR_PREFIX
                        + "V2URLTests_BaseURL_ApiRenderActurl_setParameters8",
                  tr14);
         }
      }

      // evaluate results for test case
      // V2URLTests_BaseURL_ApiRenderActurl_setSecure2
      {
         JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();
         TestResult tr18 = tcd.getTestResultFailed(
               V2URLTESTS_BASEURL_APIRENDERACTURL_SETSECURE2);
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't defined (test case error)
         if (tcval != null && tcval != null && tcval
               .equals("V2URLTests_BaseURL_ApiRenderActurl_setSecure2")) {
            String val = portletReq.getParameter("setSecure");
            boolean ok = (val != null);
            if (ok) {
               tr18.appendTcDetail("setSecure is not supported.");
            }
            ok = ok || portletReq.isSecure();
            tr18.setTcSuccess(ok);
            PortletSession ps = portletReq.getPortletSession();
            ps.setAttribute(
                  RESULT_ATTR_PREFIX
                        + "V2URLTests_BaseURL_ApiRenderActurl_setSecure2",
                  tr18);
         }
      }

      // evaluate results for test case
      // V2URLTests_BaseURL_ApiRenderActurl_toString
      {
         JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();
         TestResult tr19 = tcd.getTestResultFailed(
               V2URLTESTS_BASEURL_APIRENDERACTURL_TOSTRING);
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't defined (test case error)
         if (tcval != null && tcval != null
               && tcval.equals("V2URLTests_BaseURL_ApiRenderActurl_toString")) {
            // If execution makes it to here, the test was successful
            tr19.setTcSuccess(true);
            PortletSession ps = portletReq.getPortletSession();
            ps.setAttribute(RESULT_ATTR_PREFIX
                  + "V2URLTests_BaseURL_ApiRenderActurl_toString", tr19);
         }
      }

      // evaluate results for test case
      // V2URLTests_BaseURL_ApiRenderActurl_writeA1
      {
         JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();
         TestResult tr23 = tcd
               .getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERACTURL_WRITEA1);
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't defined (test case error)
         if (tcval != null && tcval != null
               && tcval.equals("V2URLTests_BaseURL_ApiRenderActurl_writeA1")) {
            // If execution makes it to here, the test was successful
            tr23.setTcSuccess(true);
            PortletSession ps = portletReq.getPortletSession();
            ps.setAttribute(RESULT_ATTR_PREFIX
                  + "V2URLTests_BaseURL_ApiRenderActurl_writeA1", tr23);
         }
      }

      // evaluate results for test case
      // V2URLTests_BaseURL_ApiRenderActurl_writeB1
      {
         JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();
         TestResult tr24 = tcd
               .getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERACTURL_WRITEB1);
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't defined (test case error)
         if (tcval != null && tcval != null
               && tcval.equals("V2URLTests_BaseURL_ApiRenderActurl_writeB1")) {
            // If execution makes it to here, the test was successful
            tr24.setTcSuccess(true);
            PortletSession ps = portletReq.getPortletSession();
            ps.setAttribute(RESULT_ATTR_PREFIX
                  + "V2URLTests_BaseURL_ApiRenderActurl_writeB1", tr24);
         }
      }

   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp)
         throws PortletException, IOException {

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

      JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

      // Create result objects for the tests

      /* TestCase: V2URLTests_BaseURL_ApiRenderActurl_setParameterA1 */
      /* Details: "Method setParameter(String, String): Sets the parameter */
      /* value for the specified name" */
      TestResult tr0 = tcd.getTestResultFailed(
            V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERA1);
      try {
         PortletURL turl = portletResp.createActionURL();
         turl.setParameter("tc",
               "V2URLTests_BaseURL_ApiRenderActurl_setParameterA1");
         turl.setParameter("parm1", "val1");

         // add the execution button for an action request
         TestButton tb = new TestButton(
               "V2URLTests_BaseURL_ApiRenderActurl_setParameterA1", turl);
         tb.writeTo(writer);

         // display evaluated results
         String tcval = portletReq.getParameter("tc");

         // let exception be thrown if tc parm isn't set (test case error)
         if (tcval != null && tcval != null && tcval
               .equals("V2URLTests_BaseURL_ApiRenderActurl_setParameterA1")) {
            PortletSession ps = portletReq.getPortletSession();
            TestResult tmp = (TestResult) ps.getAttribute(RESULT_ATTR_PREFIX
                  + "V2URLTests_BaseURL_ApiRenderActurl_setParameterA1");
            if (tmp != null) {
               tr0 = tmp;
               ps.removeAttribute(RESULT_ATTR_PREFIX
                     + "V2URLTests_BaseURL_ApiRenderActurl_setParameterA1");
            }
         }
      } catch (Exception e) {
         tr0.appendTcDetail(e);
      }
      tr0.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderActurl_setParameterA4 */
      /* Details: "Method setParameter(String, String): An action parameter */
      /* can be set" */
      TestResult tr1 = tcd.getTestResultFailed(
            V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERA4);
      try {
         PortletURL turl = portletResp.createActionURL();
         turl.setParameter("tc",
               "V2URLTests_BaseURL_ApiRenderActurl_setParameterA4");
         turl.setParameter("parm1", "val1");

         // add the execution button for an action request
         TestButton tb = new TestButton(
               "V2URLTests_BaseURL_ApiRenderActurl_setParameterA4", turl);
         tb.writeTo(writer);

         // display evaluated results
         String tcval = portletReq.getParameter("tc");

         // let exception be thrown if tc parm isn't set (test case error)
         if (tcval != null && tcval != null && tcval
               .equals("V2URLTests_BaseURL_ApiRenderActurl_setParameterA4")) {
            PortletSession ps = portletReq.getPortletSession();
            TestResult tmp = (TestResult) ps.getAttribute(RESULT_ATTR_PREFIX
                  + "V2URLTests_BaseURL_ApiRenderActurl_setParameterA4");
            if (tmp != null) {
               tr1 = tmp;
               ps.removeAttribute(RESULT_ATTR_PREFIX
                     + "V2URLTests_BaseURL_ApiRenderActurl_setParameterA4");
            }
         }
      } catch (Exception e) {
         tr1.appendTcDetail(e);
      }
      tr1.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderActurl_setParameterA6 */
      /* Details: "Method setParameter(String, String): All previously */
      /* existing values for the specified key are removed" */
      TestResult tr2 = tcd.getTestResultFailed(
            V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERA6);
      try {
         PortletURL turl = portletResp.createActionURL();
         turl.setParameter("tc",
               "V2URLTests_BaseURL_ApiRenderActurl_setParameterA6");
         turl.setParameter("parm1", "oldVal");
         turl.setParameter("parm1", "newVal");

         // add the execution button for an action request
         TestButton tb = new TestButton(
               "V2URLTests_BaseURL_ApiRenderActurl_setParameterA6", turl);
         tb.writeTo(writer);

         // display evaluated results
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't set (test case error)
         if (tcval != null && tcval != null && tcval
               .equals("V2URLTests_BaseURL_ApiRenderActurl_setParameterA6")) {
            PortletSession ps = portletReq.getPortletSession();
            TestResult tmp = (TestResult) ps.getAttribute(RESULT_ATTR_PREFIX
                  + "V2URLTests_BaseURL_ApiRenderActurl_setParameterA6");
            if (tmp != null) {
               tr2 = tmp;
               ps.removeAttribute(RESULT_ATTR_PREFIX
                     + "V2URLTests_BaseURL_ApiRenderActurl_setParameterA6");
            }
         }
      } catch (Exception e) {
         tr2.appendTcDetail(e);
      }
      tr2.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderActurl_setParameterA7 */
      /* Details: "Method setParameter(String, String): If the value is */
      /* null, all values for the specified key are removed" */
      TestResult tr3 = tcd.getTestResultFailed(
          V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERA7);
      try {
         PortletURL turl = portletResp.createActionURL();
         turl.setParameter("tc",
             "V2URLTests_BaseURL_ApiRenderActurl_setParameterA7");
         turl.setParameter("parm1", "val1");
         turl.setParameter("parm1", (String) null);

         // add the execution button for an action request
         TestButton tb = new TestButton(
             "V2URLTests_BaseURL_ApiRenderActurl_setParameterA7", turl);
         tb.writeTo(writer);

         // display evaluated results
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't set (test case error)
         if (tcval != null && tcval != null && tcval
             .equals("V2URLTests_BaseURL_ApiRenderActurl_setParameterA7")) {
            PortletSession ps = portletReq.getPortletSession();
            TestResult tmp = (TestResult) ps.getAttribute(RESULT_ATTR_PREFIX
                + "V2URLTests_BaseURL_ApiRenderActurl_setParameterA7");
            if (tmp != null) {
               tr3 = tmp;
               ps.removeAttribute(RESULT_ATTR_PREFIX
                   + "V2URLTests_BaseURL_ApiRenderActurl_setParameterA7");
            }
         }
      } catch (Exception e) {
         tr3.appendTcDetail(e);
      }
      tr3.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderActurl_setParameterA8 */
      /* Details: "Method setParameter(String, String): Throws */
      /* IllegalArgumentException if the name is null" */
      TestResult tr4 = tcd.getTestResultFailed(
            V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERA8);
      try {
         try {
            PortletURL turl = portletResp.createActionURL();
            turl.setParameter(null, "value");
            tr4.appendTcDetail("Method did not throw an exception.");
         } catch (IllegalArgumentException iae) {
            tr4.setTcSuccess(true);
         } catch (Exception e) {
            tr4.appendTcDetail(e);
         }
      } catch (Exception e) {
         tr4.appendTcDetail(e);
      }
      tr4.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderActurl_setParameterB1 */
      /* Details: "Method setParameter(String, String[]): Sets the */
      /* parameter value array for the specified name" */
      TestResult tr5 = tcd.getTestResultFailed(
            V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERB1);
      try {
         PortletURL turl = portletResp.createActionURL();
         turl.setParameter("tc",
               "V2URLTests_BaseURL_ApiRenderActurl_setParameterB1");
         turl.setParameter("parm1", new String[] { "val1", "val2" });

         // add the execution button for an action request
         TestButton tb = new TestButton(
               "V2URLTests_BaseURL_ApiRenderActurl_setParameterB1", turl);
         tb.writeTo(writer);

         // display evaluated results
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't set (test case error)
         if (tcval != null && tcval != null && tcval
               .equals("V2URLTests_BaseURL_ApiRenderActurl_setParameterB1")) {
            PortletSession ps = portletReq.getPortletSession();
            TestResult tmp = (TestResult) ps.getAttribute(RESULT_ATTR_PREFIX
                  + "V2URLTests_BaseURL_ApiRenderActurl_setParameterB1");
            if (tmp != null) {
               tr5 = tmp;
               ps.removeAttribute(RESULT_ATTR_PREFIX
                     + "V2URLTests_BaseURL_ApiRenderActurl_setParameterB1");
            }
         }
      } catch (Exception e) {
         tr5.appendTcDetail(e);
      }
      tr5.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderActurl_setParameterB4 */
      /* Details: "Method setParameter(String, String[]): An action */
      /* parameter can be set" */
      TestResult tr6 = tcd.getTestResultFailed(
            V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERB4);
      try {
         PortletURL turl = portletResp.createActionURL();
         turl.setParameter("tc",
               "V2URLTests_BaseURL_ApiRenderActurl_setParameterB4");
         turl.setParameter("parm1", new String[] { "val1", "val2" });

         // add the execution button for an action request
         TestButton tb = new TestButton(
               "V2URLTests_BaseURL_ApiRenderActurl_setParameterB4", turl);
         tb.writeTo(writer);

         // display evaluated results
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't set (test case error)
         if (tcval != null && tcval != null && tcval
               .equals("V2URLTests_BaseURL_ApiRenderActurl_setParameterB4")) {
            PortletSession ps = portletReq.getPortletSession();
            TestResult tmp = (TestResult) ps.getAttribute(RESULT_ATTR_PREFIX
                  + "V2URLTests_BaseURL_ApiRenderActurl_setParameterB4");
            if (tmp != null) {
               tr6 = tmp;
               ps.removeAttribute(RESULT_ATTR_PREFIX
                     + "V2URLTests_BaseURL_ApiRenderActurl_setParameterB4");
            }
         }
      } catch (Exception e) {
         tr6.appendTcDetail(e);
      }
      tr6.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderActurl_setParameterB6 */
      /* Details: "Method setParameter(String, String[]): All previously */
      /* existing values for the specified key are removed" */
      TestResult tr7 = tcd.getTestResultFailed(
            V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERB6);
      try {
         PortletURL turl = portletResp.createActionURL();
         turl.setParameter("tc",
               "V2URLTests_BaseURL_ApiRenderActurl_setParameterB6");
         turl.setParameter("parm1", new String[] { "val1", "val2", "val3" });
         turl.setParameter("parm1", new String[] { "newVal" });

         // add the execution button for an action request
         TestButton tb = new TestButton(
               "V2URLTests_BaseURL_ApiRenderActurl_setParameterB6", turl);
         tb.writeTo(writer);

         // display evaluated results
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't set (test case error)
         if (tcval != null && tcval != null && tcval
               .equals("V2URLTests_BaseURL_ApiRenderActurl_setParameterB6")) {
            PortletSession ps = portletReq.getPortletSession();
            TestResult tmp = (TestResult) ps.getAttribute(RESULT_ATTR_PREFIX
                  + "V2URLTests_BaseURL_ApiRenderActurl_setParameterB6");
            if (tmp != null) {
               tr7 = tmp;
               ps.removeAttribute(RESULT_ATTR_PREFIX
                     + "V2URLTests_BaseURL_ApiRenderActurl_setParameterB6");
            }
         }
      } catch (Exception e) {
         tr7.appendTcDetail(e);
      }
      tr7.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderActurl_setParameterB7 */
      /* Details: "Method setParameter(String, String[]): Throws */
      /* IllegalArgumentException if the value is null" */
      TestResult tr8 = tcd.getTestResultFailed(
          V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERB7);
      try {
         try {
            PortletURL turl = portletResp.createActionURL();
            turl.setParameter("parm1", (String[]) null);
            tr8.appendTcDetail("Method did not throw an exception.");
         } catch (IllegalArgumentException iae) {
            tr8.setTcSuccess(true);
         } catch (Exception e) {
            tr8.appendTcDetail(e);
         }
      } catch (Exception e) {
         tr8.appendTcDetail(e);
      }
      tr8.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderActurl_setParameterB8 */
      /* Details: "Method setParameter(String, String[]): Throws */
      /* IllegalArgumentException if the name is null" */
      TestResult tr9 = tcd.getTestResultFailed(
            V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERB8);
      try {
         try {
            PortletURL turl = portletResp.createActionURL();
            turl.setParameter(null, new String[] { "val1-1", "val1-2" });
            tr9.appendTcDetail("Method did not throw an exception.");
         } catch (IllegalArgumentException iae) {
            tr9.setTcSuccess(true);
         } catch (Exception e) {
            tr9.appendTcDetail(e);
         }
      } catch (Exception e) {
         tr9.appendTcDetail(e);
      }
      tr9.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderActurl_setParameters1 */
      /* Details: "Method setParameters(java.util.Map): Sets the parameter */
      /* map to the specified value" */
      TestResult tr10 = tcd.getTestResultFailed(
            V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERS1);
      try {
         PortletURL turl = portletResp.createActionURL();
         Map<String, String[]> parms = new HashMap<String, String[]>();
         parms.put("tc", new String[] {
               "V2URLTests_BaseURL_ApiRenderActurl_setParameters1" });
         parms.put("parm1", new String[] { "val1", "val2" });
         turl.setParameters(parms);

         // Use setup link to set public render parameter to known value
         PortletURL rurl = portletResp.createRenderURL();
         rurl.removePublicRenderParameter("tckPRP1");
         TestSetupLink tsl = new TestSetupLink(
               "V2URLTests_BaseURL_ApiRenderActurl_setParameters1", rurl);
         tsl.writeTo(writer);

         // add the execution button for an action request
         TestButton tb = new TestButton(
               "V2URLTests_BaseURL_ApiRenderActurl_setParameters1", turl);
         tb.writeTo(writer);

         // display evaluated results
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't set (test case error)
         if (tcval != null && tcval != null && tcval
               .equals("V2URLTests_BaseURL_ApiRenderActurl_setParameters1")) {
            PortletSession ps = portletReq.getPortletSession();
            TestResult tmp = (TestResult) ps.getAttribute(RESULT_ATTR_PREFIX
                  + "V2URLTests_BaseURL_ApiRenderActurl_setParameters1");
            if (tmp != null) {
               tr10 = tmp;
               ps.removeAttribute(RESULT_ATTR_PREFIX
                     + "V2URLTests_BaseURL_ApiRenderActurl_setParameters1");
            }
         }
      } catch (Exception e) {
         tr10.appendTcDetail(e);
      }
      tr10.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderActurl_setParameters4 */
      /* Details: "Method setParameters(java.util.Map): Action parameters */
      /* can be set through the map" */
      TestResult tr11 = tcd.getTestResultFailed(
            V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERS4);
      try {
         PortletURL turl = portletResp.createActionURL();
         Map<String, String[]> parms = new HashMap<String, String[]>();
         parms.put("tc", new String[] {
               "V2URLTests_BaseURL_ApiRenderActurl_setParameters4" });
         parms.put("parm1", new String[] { "val1", "val2" });
         turl.setParameters(parms);

         // Use setup link to set public render parameter to known value
         PortletURL rurl = portletResp.createRenderURL();
         rurl.removePublicRenderParameter("tckPRP1");
         TestSetupLink tsl = new TestSetupLink(
               "V2URLTests_BaseURL_ApiRenderActurl_setParameters4", rurl);
         tsl.writeTo(writer);

         // add the execution button for an action request
         TestButton tb = new TestButton(
               "V2URLTests_BaseURL_ApiRenderActurl_setParameters4", turl);
         tb.writeTo(writer);

         // display evaluated results
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't set (test case error)
         if (tcval != null && tcval != null && tcval
               .equals("V2URLTests_BaseURL_ApiRenderActurl_setParameters4")) {
            PortletSession ps = portletReq.getPortletSession();
            TestResult tmp = (TestResult) ps.getAttribute(RESULT_ATTR_PREFIX
                  + "V2URLTests_BaseURL_ApiRenderActurl_setParameters4");
            if (tmp != null) {
               tr11 = tmp;
               ps.removeAttribute(RESULT_ATTR_PREFIX
                     + "V2URLTests_BaseURL_ApiRenderActurl_setParameters4");
            }
         }
      } catch (Exception e) {
         tr11.appendTcDetail(e);
      }
      tr11.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderActurl_setParameters6 */
      /* Details: "Method setParameters(java.util.Map): Previously existing */
      /* private parameters not contained in the specified input map are */
      /* removed" */
      TestResult tr12 = tcd.getTestResultFailed(
            V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERS6);
      try {
         PortletURL turl = portletResp.createActionURL();
         Map<String, String[]> parms = new HashMap<String, String[]>();
         parms.put("tc", new String[] {
               "V2URLTests_BaseURL_ApiRenderActurl_setParameters6" });
         turl.setParameter("oldParm", "oldVal");
         parms.put("parm1", new String[] { "val1", "val2" });
         turl.setParameters(parms);

         // Use setup link to set public render parameter to known value
         PortletURL rurl = portletResp.createRenderURL();
         rurl.removePublicRenderParameter("tckPRP1");
         TestSetupLink tsl = new TestSetupLink(
               "V2URLTests_BaseURL_ApiRenderActurl_setParameters6", rurl);
         tsl.writeTo(writer);

         // add the execution button for an action request
         TestButton tb = new TestButton(
               "V2URLTests_BaseURL_ApiRenderActurl_setParameters6", turl);
         tb.writeTo(writer);

         // display evaluated results
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't set (test case error)
         if (tcval != null && tcval != null && tcval
               .equals("V2URLTests_BaseURL_ApiRenderActurl_setParameters6")) {
            PortletSession ps = portletReq.getPortletSession();
            TestResult tmp = (TestResult) ps.getAttribute(RESULT_ATTR_PREFIX
                  + "V2URLTests_BaseURL_ApiRenderActurl_setParameters6");
            if (tmp != null) {
               tr12 = tmp;
               ps.removeAttribute(RESULT_ATTR_PREFIX
                     + "V2URLTests_BaseURL_ApiRenderActurl_setParameters6");
            }
         }
      } catch (Exception e) {
         tr12.appendTcDetail(e);
      }
      tr12.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderActurl_setParameters7 */
      /* Details: "Method setParameters(java.util.Map): Previously existing */
      /* public parameters not contained in the specified input map remain */
      /* unchanged" */
      TestResult tr13 = tcd.getTestResultFailed(
            V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERS7);
      try {
         PortletURL turl = portletResp.createActionURL();
         Map<String, String[]> parms = new HashMap<String, String[]>();
         parms.put("tc", new String[] {
               "V2URLTests_BaseURL_ApiRenderActurl_setParameters7" });
         parms.put("parm1", new String[] { "val1", "val2" });
         turl.setParameters(parms);

         // Use setup link to set public render parameter to known value
         PortletURL rurl = portletResp.createRenderURL();
         rurl.setParameter("tckPRP1",
               "V2URLTests_BaseURL_ApiRenderActurl_setParameters7");
         TestSetupLink tsl = new TestSetupLink(
               "V2URLTests_BaseURL_ApiRenderActurl_setParameters7", rurl);
         tsl.writeTo(writer);

         // add the execution button for an action request
         TestButton tb = new TestButton(
               "V2URLTests_BaseURL_ApiRenderActurl_setParameters7", turl);
         tb.writeTo(writer);

         // display evaluated results
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't set (test case error)
         if (tcval != null && tcval != null && tcval
               .equals("V2URLTests_BaseURL_ApiRenderActurl_setParameters7")) {
            PortletSession ps = portletReq.getPortletSession();
            TestResult tmp = (TestResult) ps.getAttribute(RESULT_ATTR_PREFIX
                  + "V2URLTests_BaseURL_ApiRenderActurl_setParameters7");
            if (tmp != null) {
               tr13 = tmp;
               ps.removeAttribute(RESULT_ATTR_PREFIX
                     + "V2URLTests_BaseURL_ApiRenderActurl_setParameters7");
            }
         }
      } catch (Exception e) {
         tr13.appendTcDetail(e);
      }
      tr13.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderActurl_setParameters8 */
      /* Details: "Method setParameters(java.util.Map): Parameters that are */
      /* set are available in requests initiated through the URL" */
      TestResult tr14 = tcd.getTestResultFailed(
            V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERS8);
      try {
         PortletURL turl = portletResp.createActionURL();
         Map<String, String[]> parms = new HashMap<String, String[]>();
         parms.put("tc", new String[] {
               "V2URLTests_BaseURL_ApiRenderActurl_setParameters8" });
         parms.put("parm1", new String[] { "val1", "val2" });
         turl.setParameters(parms);

         // Use setup link to set public render parameter to known value
         PortletURL rurl = portletResp.createRenderURL();
         rurl.removePublicRenderParameter("tckPRP1");
         TestSetupLink tsl = new TestSetupLink(
               "V2URLTests_BaseURL_ApiRenderActurl_setParameters8", rurl);
         tsl.writeTo(writer);

         // add the execution button for an action request
         TestButton tb = new TestButton(
               "V2URLTests_BaseURL_ApiRenderActurl_setParameters8", turl);
         tb.writeTo(writer);

         // display evaluated results
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't set (test case error)
         if (tcval != null && tcval != null && tcval
               .equals("V2URLTests_BaseURL_ApiRenderActurl_setParameters8")) {
            PortletSession ps = portletReq.getPortletSession();
            TestResult tmp = (TestResult) ps.getAttribute(RESULT_ATTR_PREFIX
                  + "V2URLTests_BaseURL_ApiRenderActurl_setParameters8");
            if (tmp != null) {
               tr14 = tmp;
               ps.removeAttribute(RESULT_ATTR_PREFIX
                     + "V2URLTests_BaseURL_ApiRenderActurl_setParameters8");
            }
         }
      } catch (Exception e) {
         tr14.appendTcDetail(e);
      }
      tr14.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderActurl_setParameters9 */
      /* Details: "Method setParameters(java.util.Map): Throws */
      /* IllegalArgumentException if the input map is null" */
      TestResult tr15 = tcd.getTestResultFailed(
            V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERS9);
      try {
         try {
            PortletURL turl = portletResp.createActionURL();
            turl.setParameters((Map<String, String[]>) null);
            tr15.appendTcDetail("Method did not throw an exception.");
         } catch (IllegalArgumentException iae) {
            tr15.setTcSuccess(true);
         } catch (Exception e) {
            tr15.appendTcDetail(e);
         }
      } catch (Exception e) {
         tr15.appendTcDetail(e);
      }
      tr15.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderActurl_setParameters10 */
      /* Details: "Method setParameters(java.util.Map): Throws */
      /* IllegalArgumentException if any key in the map is null" */
      TestResult tr16 = tcd.getTestResultFailed(
            V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERS10);
      try {
         try {
            PortletURL turl = portletResp.createActionURL();
            Map<String, String[]> parms = new HashMap<String, String[]>();
            parms.put("parm1", new String[] { "val1-1", "val1-2" });
            parms.put(null, new String[] { "val2-1", "val2-2" });
            turl.setParameters(parms);
            tr16.appendTcDetail("Method did not throw an exception.");
         } catch (IllegalArgumentException iae) {
            tr16.setTcSuccess(true);
         } catch (Exception e) {
            tr16.appendTcDetail(e);
         }
      } catch (Exception e) {
         tr16.appendTcDetail(e);
      }
      tr16.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderActurl_setParameters12 */
      /* Details: "Method setParameters(java.util.Map): Throws */
      /* IllegalArgumentException if the values array for any key is null " */
      TestResult tr17 = tcd.getTestResultFailed(
            V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERS12);
      try {
         try {
            PortletURL turl = portletResp.createActionURL();
            Map<String, String[]> parms = new HashMap<String, String[]>();
            parms.put("parm1", new String[] { "val1-1", "val1-2" });
            parms.put("parm2", null);
            turl.setParameters(parms);
            tr17.appendTcDetail("Method did not throw an exception.");
         } catch (IllegalArgumentException iae) {
            tr17.setTcSuccess(true);
         } catch (Exception e) {
            tr17.appendTcDetail(e);
         }
      } catch (Exception e) {
         tr17.appendTcDetail(e);
      }
      tr17.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderActurl_setSecure2 */
      /* Details: "Method setSecure(boolean): If the input parameter is */
      /* true, the resulting URL uses a secure connection (HTTPS)" */
      TestResult tr18 = tcd
            .getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERACTURL_SETSECURE2);
      try {
         PortletURL turl = portletResp.createActionURL();
         turl.setParameter("tc",
               "V2URLTests_BaseURL_ApiRenderActurl_setSecure2");
         try {
            turl.setSecure(true);
         } catch (PortletSecurityException e) {
            // handle as successful completion, since runtime does not support
            // setting
            turl.setParameter("setSecure", "not supported");
         }

         // add the execution button for an action request
         TestButton tb = new TestButton(
               "V2URLTests_BaseURL_ApiRenderActurl_setSecure2", turl);
         tb.writeTo(writer);

         // display evaluated results
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't set (test case error)
         if (tcval != null && tcval != null && tcval
               .equals("V2URLTests_BaseURL_ApiRenderActurl_setSecure2")) {
            PortletSession ps = portletReq.getPortletSession();
            TestResult tmp = (TestResult) ps.getAttribute(RESULT_ATTR_PREFIX
                  + "V2URLTests_BaseURL_ApiRenderActurl_setSecure2");
            if (tmp != null) {
               tr18 = tmp;
               ps.removeAttribute(RESULT_ATTR_PREFIX
                     + "V2URLTests_BaseURL_ApiRenderActurl_setSecure2");
            }
         }
      } catch (Exception e) {
         tr18.appendTcDetail(e);
      }
      tr18.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderActurl_toString */
      /* Details: "Method toString(): Returns a String containing the */
      /* portlet URL representation to be included in the markup" */
      TestResult tr19 = tcd
            .getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERACTURL_TOSTRING);
      try {
         PortletURL turl = portletResp.createActionURL();
         turl.setParameter("tc", "V2URLTests_BaseURL_ApiRenderActurl_toString");
         String urlstr = turl.toString();

         // add the execution button for an action request
         TestButton tb = new TestButton(
               "V2URLTests_BaseURL_ApiRenderActurl_toString", urlstr);
         tb.writeTo(writer);

         // display evaluated results
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't set (test case error)
         if (tcval != null && tcval != null
               && tcval.equals("V2URLTests_BaseURL_ApiRenderActurl_toString")) {
            PortletSession ps = portletReq.getPortletSession();
            TestResult tmp = (TestResult) ps.getAttribute(RESULT_ATTR_PREFIX
                  + "V2URLTests_BaseURL_ApiRenderActurl_toString");
            if (tmp != null) {
               tr19 = tmp;
               ps.removeAttribute(RESULT_ATTR_PREFIX
                     + "V2URLTests_BaseURL_ApiRenderActurl_toString");
            }
         }
      } catch (Exception e) {
         tr19.appendTcDetail(e);
      }
      tr19.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderActurl_getParameterMap1 */
      /* Details: "Method getParameterMap(): Returns an */
      /* java.util.Map&lt;java.lang.String,java.lang.String[]&gt; object */
      /* for the parameter names and values if parameters are available" */
      TestResult tr20 = tcd.getTestResultFailed(
            V2URLTESTS_BASEURL_APIRENDERACTURL_GETPARAMETERMAP1);
      try {
         PortletURL turl = portletResp.createActionURL();
         Map<String, String[]> parms = turl.getParameterMap();
         if (parms == null) {
            tr20.appendTcDetail("Returned map is null.");
         } else {
            tr20.setTcSuccess(true);
         }
      } catch (Exception e) {
         tr20.appendTcDetail(e);
      }
      tr20.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderActurl_getParameterMap3 */
      /* Details: "Method getParameterMap(): For an action URL, the */
      /* returned map contains all action parameters for the request" */
      TestResult tr21 = tcd.getTestResultFailed(
            V2URLTESTS_BASEURL_APIRENDERACTURL_GETPARAMETERMAP3);
      try {
         PortletURL turl = portletResp.createActionURL();
         Map<String, String[]> testparms = new HashMap<String, String[]>();
         turl.setParameter("parm1", "val1");
         testparms.put("parm1", new String[] { "val1" });
         turl.setParameter("tckPRP1", "PRPval1");
         testparms.put("tckPRP1", new String[] { "PRPval1" });
         Map<String, String[]> parms = turl.getParameterMap();
         CompareUtils.mapsEqual("Test parameters", testparms,
               "Parameters from URL", parms, tr21);
      } catch (Exception e) {
         tr21.appendTcDetail(e);
      }
      tr21.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderActurl_getParameterMap6 */
      /* Details: "Method getParameterMap(): Returns an empty map if no */
      /* parameters exist" */
      TestResult tr22 = tcd.getTestResultFailed(
            V2URLTESTS_BASEURL_APIRENDERACTURL_GETPARAMETERMAP6);
      try {
         PortletURL turl = portletResp.createActionURL();
         Map<String, String[]> parms = turl.getParameterMap();
         if (parms == null) {
            tr22.appendTcDetail("Returned map is null.");
         } else {
            tr22.setTcSuccess(parms.isEmpty());
         }
      } catch (Exception e) {
         tr22.appendTcDetail(e);
      }
      tr22.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderActurl_writeA1 */
      /* Details: "Method write(Writer out): Writes the URL to the output */
      /* stream through the provided Writer" */
      TestResult tr23 = tcd
            .getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERACTURL_WRITEA1);
      try {
         PortletURL turl = portletResp.createActionURL();
         turl.setParameter("tc", "V2URLTests_BaseURL_ApiRenderActurl_writeA1");
         StringWriter tsw = new StringWriter();
         turl.write(tsw);
         String urlstr = tsw.toString();

         // add the execution button for an action request
         TestButton tb = new TestButton(
               "V2URLTests_BaseURL_ApiRenderActurl_writeA1", urlstr);
         tb.writeTo(writer);

         // display evaluated results
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't set (test case error)
         if (tcval != null && tcval != null
               && tcval.equals("V2URLTests_BaseURL_ApiRenderActurl_writeA1")) {
            PortletSession ps = portletReq.getPortletSession();
            TestResult tmp = (TestResult) ps.getAttribute(RESULT_ATTR_PREFIX
                  + "V2URLTests_BaseURL_ApiRenderActurl_writeA1");
            if (tmp != null) {
               tr23 = tmp;
               ps.removeAttribute(RESULT_ATTR_PREFIX
                     + "V2URLTests_BaseURL_ApiRenderActurl_writeA1");
            }
         }
      } catch (Exception e) {
         tr23.appendTcDetail(e);
      }
      tr23.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderActurl_writeB1 */
      /* Details: "Method write(Writer out, boolean escapeXML): Writes the */
      /* URL to the output stream through the provided Writer" */
      TestResult tr24 = tcd
            .getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERACTURL_WRITEB1);
      try {
         PortletURL turl = portletResp.createActionURL();
         turl.setParameter("tc", "V2URLTests_BaseURL_ApiRenderActurl_writeB1");
         StringWriter tsw = new StringWriter();
         turl.write(tsw, true);
         String urlstr = tsw.toString();

         // add the execution button for an action request
         TestButton tb = new TestButton(
               "V2URLTests_BaseURL_ApiRenderActurl_writeB1", urlstr);
         tb.writeTo(writer);

         // display evaluated results
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't set (test case error)
         if (tcval != null && tcval != null
               && tcval.equals("V2URLTests_BaseURL_ApiRenderActurl_writeB1")) {
            PortletSession ps = portletReq.getPortletSession();
            TestResult tmp = (TestResult) ps.getAttribute(RESULT_ATTR_PREFIX
                  + "V2URLTests_BaseURL_ApiRenderActurl_writeB1");
            if (tmp != null) {
               tr24 = tmp;
               ps.removeAttribute(RESULT_ATTR_PREFIX
                     + "V2URLTests_BaseURL_ApiRenderActurl_writeB1");
            }
         }
      } catch (Exception e) {
         tr24.appendTcDetail(e);
      }
      tr24.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderActurl_addProperty1 */
      /* Details: "Method addProperty(String, String): A property can be */
      /* added" */
      TestResult tr25 = tcd.getTestResultFailed(
            V2URLTESTS_BASEURL_APIRENDERACTURL_ADDPROPERTY1);
      try {
         // Test if method can be called. Not possible to check resulting
         // property values.
         PortletURL turl = portletResp.createActionURL();
         turl.addProperty("prop1", "val1");
         tr25.setTcSuccess(true);
      } catch (Exception e) {
         tr25.appendTcDetail(e);
      }
      tr25.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderActurl_addProperty3 */
      /* Details: "Method addProperty(String, String): Throws */
      /* IllegalArgumentException if the specified key is null" */
      TestResult tr26 = tcd.getTestResultFailed(
            V2URLTESTS_BASEURL_APIRENDERACTURL_ADDPROPERTY3);
      try {
         try {
            PortletURL turl = portletResp.createActionURL();
            turl.addProperty(null, "value");
            tr26.appendTcDetail("Method did not throw an exception.");
         } catch (IllegalArgumentException iae) {
            tr26.setTcSuccess(true);
         } catch (Exception e) {
            tr26.appendTcDetail(e);
         }
      } catch (Exception e) {
         tr26.appendTcDetail(e);
      }
      tr26.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderActurl_setProperty1 */
      /* Details: "Method setProperty(String, String): Sets a property */
      /* value for the specified key" */
      TestResult tr27 = tcd.getTestResultFailed(
            V2URLTESTS_BASEURL_APIRENDERACTURL_SETPROPERTY1);
      try {
         // Test if method can be called. Not possible to check resulting
         // property values.
         PortletURL turl = portletResp.createActionURL();
         turl.setProperty("prop1", "val1");
         tr27.setTcSuccess(true);
      } catch (Exception e) {
         tr27.appendTcDetail(e);
      }
      tr27.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderActurl_setProperty3 */
      /* Details: "Method setProperty(String, String): Throws */
      /* IllegalArgumentException if the specified key is null" */
      TestResult tr28 = tcd.getTestResultFailed(
            V2URLTESTS_BASEURL_APIRENDERACTURL_SETPROPERTY3);
      try {
         try {
            PortletURL turl = portletResp.createActionURL();
            turl.setProperty(null, "value");
            tr28.appendTcDetail("Method did not throw an exception.");
         } catch (IllegalArgumentException iae) {
            tr28.setTcSuccess(true);
         } catch (Exception e) {
            tr28.appendTcDetail(e);
         }
      } catch (Exception e) {
         tr28.appendTcDetail(e);
      }
      tr28.writeTo(writer);

   }

}
