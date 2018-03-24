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
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceServingPortlet;
import javax.portlet.ResourceURL;
import javax.portlet.tck.beans.CompareUtils;
import javax.portlet.tck.beans.JSR286ApiTestCaseDetails;
import javax.portlet.tck.beans.ResourceLink;
import javax.portlet.tck.beans.TestLink;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.beans.TestSetupLink;

import static javax.portlet.tck.constants.Constants.THREADID_ATTR;
import static javax.portlet.tck.constants.Constants.PARM_NAME;
import static javax.portlet.tck.constants.Constants.PARM_VALUE;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERA1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERA5;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERA6;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERA7;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERB1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERB5;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERB6;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERB7;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERS1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERS5;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERS6;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERS7;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERS8;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_BASEURL_APIRENDERRESURL_SETSECURE2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_BASEURL_APIRENDERRESURL_TOSTRING;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_BASEURL_APIRENDERRESURL_WRITEA1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_BASEURL_APIRENDERRESURL_WRITEB1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERA8;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERB8;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERS9;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERS10;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERS12;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_BASEURL_APIRENDERRESURL_GETPARAMETERMAP1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_BASEURL_APIRENDERRESURL_GETPARAMETERMAP4;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_BASEURL_APIRENDERRESURL_GETPARAMETERMAP5;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_BASEURL_APIRENDERRESURL_GETPARAMETERMAP6;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_BASEURL_APIRENDERRESURL_ADDPROPERTY1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_BASEURL_APIRENDERRESURL_ADDPROPERTY3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_BASEURL_APIRENDERRESURL_SETPROPERTY1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_BASEURL_APIRENDERRESURL_SETPROPERTY3;

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
 * URLTests_BaseURL_ApiRenderResurl_event
 *
 */
public class URLTests_BaseURL_ApiRenderResurl
      implements Portlet, ResourceServingPortlet {

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

   }

   @Override
   public void serveResource(ResourceRequest portletReq,
         ResourceResponse portletResp) throws PortletException, IOException {

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

      // evaluate results for test case
      // V2URLTests_BaseURL_ApiRenderResurl_setParameterA1
      {
         JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();
         TestResult tr0 = tcd.getTestResultFailed(
               V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERA1);
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't set (test case error)
         if (tcval != null && tcval
               .equals("V2URLTests_BaseURL_ApiRenderResurl_setParameterA1")) {
            String aval = portletReq.getParameter("parm1");
            String eval = "val1";
            CompareUtils.stringsEqual("Request", aval, " expected: ", eval,
                  tr0);
            tr0.writeTo(writer);
         }
      }

      // evaluate results for test case
      // V2URLTests_BaseURL_ApiRenderResurl_setParameterA5
      {
         JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();
         TestResult tr1 = tcd.getTestResultFailed(
               V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERA5);
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't set (test case error)
         if (tcval != null && tcval
               .equals("V2URLTests_BaseURL_ApiRenderResurl_setParameterA5")) {
            String aval = portletReq.getParameter("parm1");
            String eval = "val1";
            CompareUtils.stringsEqual("Request", aval, " expected: ", eval,
                  tr1);
            tr1.writeTo(writer);
         }
      }

      // evaluate results for test case
      // V2URLTests_BaseURL_ApiRenderResurl_setParameterA6
      {
         JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();
         TestResult tr2 = tcd.getTestResultFailed(
               V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERA6);
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't set (test case error)
         if (tcval != null && tcval
               .equals("V2URLTests_BaseURL_ApiRenderResurl_setParameterA6")) {
            String aval = portletReq.getParameter("parm1");
            String eval = "newVal";
            CompareUtils.stringsEqual("Request", aval, " expected: ", eval,
                  tr2);
            tr2.writeTo(writer);
         }
      }

      // evaluate results for test case
      // V2URLTests_BaseURL_ApiRenderResurl_setParameterA7
      {
         JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();
         TestResult tr3 = tcd.getTestResultFailed(
             V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERA7);
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't set (test case error)
         if (tcval != null && tcval
             .equals("V2URLTests_BaseURL_ApiRenderResurl_setParameterA7")) {
            String aval = portletReq.getParameter("parm1");
            String eval = null;
            CompareUtils.stringsEqual("Request", aval, " expected: ", eval,
                tr3);
            tr3.writeTo(writer);
         }
      }

      // evaluate results for test case
      // V2URLTests_BaseURL_ApiRenderResurl_setParameterB1
      {
         JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();
         TestResult tr5 = tcd.getTestResultFailed(
               V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERB1);
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't set (test case error)
         if (tcval != null && tcval
               .equals("V2URLTests_BaseURL_ApiRenderResurl_setParameterB1")) {
            String[] aval = portletReq.getParameterValues("parm1");
            String[] eval = new String[] { "val1", "val2" };
            CompareUtils.arraysEqual("Request", aval, " expected: ", eval, tr5);
            tr5.writeTo(writer);
         }
      }

      // evaluate results for test case
      // V2URLTests_BaseURL_ApiRenderResurl_setParameterB5
      {
         JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();
         TestResult tr6 = tcd.getTestResultFailed(
               V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERB5);
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't set (test case error)
         if (tcval != null && tcval
               .equals("V2URLTests_BaseURL_ApiRenderResurl_setParameterB5")) {
            String[] aval = portletReq.getParameterValues("parm1");
            String[] eval = new String[] { "val1", "val2" };
            CompareUtils.arraysEqual("Request", aval, " expected: ", eval, tr6);
            tr6.writeTo(writer);
         }
      }

      // evaluate results for test case
      // V2URLTests_BaseURL_ApiRenderResurl_setParameterB6
      {
         JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();
         TestResult tr7 = tcd.getTestResultFailed(
               V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERB6);
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't set (test case error)
         if (tcval != null && tcval
               .equals("V2URLTests_BaseURL_ApiRenderResurl_setParameterB6")) {
            String[] aval = portletReq.getParameterValues("parm1");
            String[] eval = new String[] { "newVal" };
            CompareUtils.arraysEqual("Request", aval, " expected: ", eval, tr7);
            tr7.writeTo(writer);
         }
      }

      // evaluate results for test case
      // V2URLTests_BaseURL_ApiRenderResurl_setParameters1
      {
         JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();
         TestResult tr10 = tcd.getTestResultFailed(
               V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERS1);
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't set (test case error)
         if (tcval != null && tcval
               .equals("V2URLTests_BaseURL_ApiRenderResurl_setParameters1")) {
            Map<String, String[]> aval = portletReq.getParameterMap();
            Map<String, String[]> eval = new HashMap<String, String[]>();
            eval.put("tc", new String[] {
                  "V2URLTests_BaseURL_ApiRenderResurl_setParameters1" });
            eval.put("parm1", new String[] { "val1", "val2" });
            CompareUtils.mapsEqual("Request", aval, " expected: ", eval, tr10);
            tr10.writeTo(writer);
         }
      }

      // evaluate results for test case
      // V2URLTests_BaseURL_ApiRenderResurl_setParameters5
      {
         JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();
         TestResult tr11 = tcd.getTestResultFailed(
               V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERS5);
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't set (test case error)
         if (tcval != null && tcval
               .equals("V2URLTests_BaseURL_ApiRenderResurl_setParameters5")) {
            Map<String, String[]> aval = portletReq.getParameterMap();
            Map<String, String[]> eval = new HashMap<String, String[]>();
            eval.put("tc", new String[] {
                  "V2URLTests_BaseURL_ApiRenderResurl_setParameters5" });
            eval.put("parm1", new String[] { "val1", "val2" });
            CompareUtils.mapsEqual("Request", aval, " expected: ", eval, tr11);
            tr11.writeTo(writer);
         }
      }

      // evaluate results for test case
      // V2URLTests_BaseURL_ApiRenderResurl_setParameters6
      {
         JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();
         TestResult tr12 = tcd.getTestResultFailed(
               V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERS6);
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't set (test case error)
         if (tcval != null && tcval
               .equals("V2URLTests_BaseURL_ApiRenderResurl_setParameters6")) {
            Map<String, String[]> aval = portletReq.getParameterMap();
            Map<String, String[]> eval = new HashMap<String, String[]>();
            eval.put("tc", new String[] {
                  "V2URLTests_BaseURL_ApiRenderResurl_setParameters6" });
            eval.put("parm1", new String[] { "val1", "val2" });
            CompareUtils.mapsEqual("Request", aval, " expected: ", eval, tr12);
            tr12.writeTo(writer);
         }
      }

      // evaluate results for test case
      // V2URLTests_BaseURL_ApiRenderResurl_setParameters7
      {
         JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();
         TestResult tr13 = tcd.getTestResultFailed(
               V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERS7);
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't set (test case error)
         if (tcval != null && tcval
               .equals("V2URLTests_BaseURL_ApiRenderResurl_setParameters7")) {
            Map<String, String[]> aval = portletReq.getParameterMap();
            Map<String, String[]> eval = new HashMap<String, String[]>();
            eval.put("tc", new String[] {
                  "V2URLTests_BaseURL_ApiRenderResurl_setParameters7" });
            eval.put("parm1", new String[] { "val1", "val2" });
            eval.put("tckPRP1", new String[] {
                  "V2URLTests_BaseURL_ApiRenderResurl_setParameters7" });
            CompareUtils.mapsEqual("Request", aval, " expected: ", eval, tr13);
            tr13.writeTo(writer);
         }
      }

      // evaluate results for test case
      // V2URLTests_BaseURL_ApiRenderResurl_setParameters8
      {
         JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();
         TestResult tr14 = tcd.getTestResultFailed(
               V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERS8);
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't set (test case error)
         if (tcval != null && tcval
               .equals("V2URLTests_BaseURL_ApiRenderResurl_setParameters8")) {
            Map<String, String[]> aval = portletReq.getParameterMap();
            Map<String, String[]> eval = new HashMap<String, String[]>();
            eval.put("tc", new String[] {
                  "V2URLTests_BaseURL_ApiRenderResurl_setParameters8" });
            eval.put("parm1", new String[] { "val1", "val2" });
            CompareUtils.mapsEqual("Request", aval, " expected: ", eval, tr14);
            tr14.writeTo(writer);
         }
      }

      // evaluate results for test case
      // V2URLTests_BaseURL_ApiRenderResurl_setSecure2
      {
         JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();
         TestResult tr18 = tcd.getTestResultFailed(
               V2URLTESTS_BASEURL_APIRENDERRESURL_SETSECURE2);
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't set (test case error)
         if (tcval != null && tcval
               .equals("V2URLTests_BaseURL_ApiRenderResurl_setSecure2")) {
            String val = portletReq.getParameter("setSecure");
            boolean ok = (val != null);
            if (ok) {
               tr18.appendTcDetail("setSecure is not supported.");
            }
            ok = ok || portletReq.isSecure();
            tr18.setTcSuccess(ok);
            tr18.writeTo(writer);
         }
      }

      // evaluate results for test case
      // V2URLTests_BaseURL_ApiRenderResurl_toString
      {
         JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();
         TestResult tr19 = tcd.getTestResultFailed(
               V2URLTESTS_BASEURL_APIRENDERRESURL_TOSTRING);
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't set (test case error)
         if (tcval != null
               && tcval.equals("V2URLTests_BaseURL_ApiRenderResurl_toString")) {
            // If execution makes it to here, the test was successful
            tr19.setTcSuccess(true);
            tr19.writeTo(writer);
         }
      }

      // evaluate results for test case
      // V2URLTests_BaseURL_ApiRenderResurl_writeA1
      {
         JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();
         TestResult tr24 = tcd
               .getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERRESURL_WRITEA1);
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't set (test case error)
         if (tcval != null
               && tcval.equals("V2URLTests_BaseURL_ApiRenderResurl_writeA1")) {
            // If execution makes it to here, the test was successful
            tr24.setTcSuccess(true);
            tr24.writeTo(writer);
         }
      }

      // evaluate results for test case
      // V2URLTests_BaseURL_ApiRenderResurl_writeB1
      {
         JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();
         TestResult tr25 = tcd
               .getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERRESURL_WRITEB1);
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't set (test case error)
         if (tcval != null
               && tcval.equals("V2URLTests_BaseURL_ApiRenderResurl_writeB1")) {
            // If execution makes it to here, the test was successful
            tr25.setTcSuccess(true);
            tr25.writeTo(writer);
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

      /* TestCase: V2URLTests_BaseURL_ApiRenderResurl_setParameterA1 */
      /* Details: "Method setParameter(String, String): Sets the parameter */
      /* value for the specified name" */
      TestResult tr0 = tcd.getTestResultFailed(
            V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERA1);
      try {
         ResourceURL turl = portletResp.createResourceURL();
         turl.setParameter("tc",
               "V2URLTests_BaseURL_ApiRenderResurl_setParameterA1");
         turl.setParameter("parm1", "val1");

         // add the resource results fetcher to the output stream
         ResourceLink rl = new ResourceLink(
               "V2URLTests_BaseURL_ApiRenderResurl_setParameterA1", turl);
         rl.writeResourceFetcher(writer);
      } catch (Exception e) {
         tr0.appendTcDetail(e);
         tr0.writeTo(writer);
      }

      /* TestCase: V2URLTests_BaseURL_ApiRenderResurl_setParameterA5 */
      /* Details: "Method setParameter(String, String): A resource */
      /* parameter can be set" */
      TestResult tr1 = tcd.getTestResultFailed(
            V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERA5);
      try {
         ResourceURL turl = portletResp.createResourceURL();
         turl.setParameter("tc",
               "V2URLTests_BaseURL_ApiRenderResurl_setParameterA5");
         turl.setParameter("parm1", "val1");

         // add the resource results fetcher to the output stream
         ResourceLink rl = new ResourceLink(
               "V2URLTests_BaseURL_ApiRenderResurl_setParameterA5", turl);
         rl.writeResourceFetcher(writer);
      } catch (Exception e) {
         tr1.appendTcDetail(e);
         tr1.writeTo(writer);
      }

      /* TestCase: V2URLTests_BaseURL_ApiRenderResurl_setParameterA6 */
      /* Details: "Method setParameter(String, String): All previously */
      /* existing values for the specified key are removed" */
      TestResult tr2 = tcd.getTestResultFailed(
            V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERA6);
      try {
         ResourceURL turl = portletResp.createResourceURL();
         turl.setParameter("tc",
               "V2URLTests_BaseURL_ApiRenderResurl_setParameterA6");
         turl.setParameter("parm1", "oldVal");
         turl.setParameter("parm1", "newVal");

         // add the resource results fetcher to the output stream
         ResourceLink rl = new ResourceLink(
               "V2URLTests_BaseURL_ApiRenderResurl_setParameterA6", turl);
         rl.writeResourceFetcher(writer);
      } catch (Exception e) {
         tr2.appendTcDetail(e);
         tr2.writeTo(writer);
      }

      /* TestCase: V2URLTests_BaseURL_ApiRenderResurl_setParameterA7 */
      /* Details: "Method setParameter(String, String): If the value is */
      /* null, all values for the specified key are removed" */
      TestResult tr3 = tcd.getTestResultFailed(
          V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERA7);
      try {
         ResourceURL turl = portletResp.createResourceURL();
         turl.setParameter("tc",
             "V2URLTests_BaseURL_ApiRenderResurl_setParameterA7");
         turl.setParameter("parm1", "val1");
         turl.setParameter("parm1", (String) null);

         // add the resource results fetcher to the output stream
         ResourceLink rl = new ResourceLink(
             "V2URLTests_BaseURL_ApiRenderResurl_setParameterA7", turl);
         rl.writeResourceFetcher(writer);
      } catch (Exception e) {
         tr3.appendTcDetail(e);
         tr3.writeTo(writer);
      }

      /* TestCase: V2URLTests_BaseURL_ApiRenderResurl_setParameterA8 */
      /* Details: "Method setParameter(String, String): Throws */
      /* IllegalArgumentException if the name is null" */
      TestResult tr4 = tcd.getTestResultFailed(
            V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERA8);
      try {
         try {
            ResourceURL turl = portletResp.createResourceURL();
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

      /* TestCase: V2URLTests_BaseURL_ApiRenderResurl_setParameterB1 */
      /* Details: "Method setParameter(String, String[]): Sets the */
      /* parameter value array for the specified name" */
      TestResult tr5 = tcd.getTestResultFailed(
            V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERB1);
      try {
         ResourceURL turl = portletResp.createResourceURL();
         turl.setParameter("tc",
               "V2URLTests_BaseURL_ApiRenderResurl_setParameterB1");
         turl.setParameter("parm1", new String[] { "val1", "val2" });

         // add the resource results fetcher to the output stream
         ResourceLink rl = new ResourceLink(
               "V2URLTests_BaseURL_ApiRenderResurl_setParameterB1", turl);
         rl.writeResourceFetcher(writer);
      } catch (Exception e) {
         tr5.appendTcDetail(e);
         tr5.writeTo(writer);
      }

      /* TestCase: V2URLTests_BaseURL_ApiRenderResurl_setParameterB5 */
      /* Details: "Method setParameter(String, String[]): A resource */
      /* parameter can be set" */
      TestResult tr6 = tcd.getTestResultFailed(
            V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERB5);
      try {
         ResourceURL turl = portletResp.createResourceURL();
         turl.setParameter("tc",
               "V2URLTests_BaseURL_ApiRenderResurl_setParameterB5");
         turl.setParameter("parm1", new String[] { "val1", "val2" });

         // add the resource results fetcher to the output stream
         ResourceLink rl = new ResourceLink(
               "V2URLTests_BaseURL_ApiRenderResurl_setParameterB5", turl);
         rl.writeResourceFetcher(writer);
      } catch (Exception e) {
         tr6.appendTcDetail(e);
         tr6.writeTo(writer);
      }

      /* TestCase: V2URLTests_BaseURL_ApiRenderResurl_setParameterB6 */
      /* Details: "Method setParameter(String, String[]): All previously */
      /* existing values for the specified key are removed" */
      TestResult tr7 = tcd.getTestResultFailed(
            V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERB6);
      try {
         ResourceURL turl = portletResp.createResourceURL();
         turl.setParameter("tc",
               "V2URLTests_BaseURL_ApiRenderResurl_setParameterB6");
         turl.setParameter("parm1", new String[] { "val1", "val2", "val3" });
         turl.setParameter("parm1", new String[] { "newVal" });

         // add the resource results fetcher to the output stream
         ResourceLink rl = new ResourceLink(
               "V2URLTests_BaseURL_ApiRenderResurl_setParameterB6", turl);
         rl.writeResourceFetcher(writer);
      } catch (Exception e) {
         tr7.appendTcDetail(e);
         tr7.writeTo(writer);
      }

      /* TestCase: V2URLTests_BaseURL_ApiRenderResurl_setParameterB7 */
      /* Details: "Method setParameter(String, String[]): Throws */
      /* IllegalArgumentException if the value is null" */
      TestResult tr8 = tcd.getTestResultFailed(
          V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERB7);
      try {
         try {
            ResourceURL turl = portletResp.createResourceURL();
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

      /* TestCase: V2URLTests_BaseURL_ApiRenderResurl_setParameterB8 */
      /* Details: "Method setParameter(String, String[]): Throws */
      /* IllegalArgumentException if the name is null" */
      TestResult tr9 = tcd.getTestResultFailed(
            V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERB8);
      try {
         try {
            ResourceURL turl = portletResp.createResourceURL();
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

      /* TestCase: V2URLTests_BaseURL_ApiRenderResurl_setParameters1 */
      /* Details: "Method setParameters(java.util.Map): Sets the parameter */
      /* map to the specified value" */
      TestResult tr10 = tcd.getTestResultFailed(
            V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERS1);
      try {
         ResourceURL turl = portletResp.createResourceURL();
         Map<String, String[]> parms = new HashMap<String, String[]>();
         parms.put("tc", new String[] {
               "V2URLTests_BaseURL_ApiRenderResurl_setParameters1" });
         parms.put("parm1", new String[] { "val1", "val2" });
         turl.setParameters(parms);

         // Use setup link to set public render parameter to known value
         PortletURL rurl = portletResp.createRenderURL();
         rurl.removePublicRenderParameter("tckPRP1");
         TestSetupLink tsl = new TestSetupLink(
               "V2URLTests_BaseURL_ApiRenderResurl_setParameters1", rurl);
         tsl.writeTo(writer);

         // add the resource results fetcher to the output stream
         ResourceLink rl = new ResourceLink(
               "V2URLTests_BaseURL_ApiRenderResurl_setParameters1", turl);
         rl.writeResourceFetcher(writer);
      } catch (Exception e) {
         tr10.appendTcDetail(e);
         tr10.writeTo(writer);
      }

      /* TestCase: V2URLTests_BaseURL_ApiRenderResurl_setParameters5 */
      /* Details: "Method setParameters(java.util.Map): Resource parameters */
      /* can be set through the map" */
      TestResult tr11 = tcd.getTestResultFailed(
            V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERS5);
      try {
         ResourceURL turl = portletResp.createResourceURL();
         Map<String, String[]> parms = new HashMap<String, String[]>();
         parms.put("tc", new String[] {
               "V2URLTests_BaseURL_ApiRenderResurl_setParameters5" });
         parms.put("parm1", new String[] { "val1", "val2" });
         turl.setParameters(parms);

         // Use setup link to set public render parameter to known value
         PortletURL rurl = portletResp.createRenderURL();
         rurl.removePublicRenderParameter("tckPRP1");
         TestSetupLink tsl = new TestSetupLink(
               "V2URLTests_BaseURL_ApiRenderResurl_setParameters5", rurl);
         tsl.writeTo(writer);

         // add the resource results fetcher to the output stream
         ResourceLink rl = new ResourceLink(
               "V2URLTests_BaseURL_ApiRenderResurl_setParameters5", turl);
         rl.writeResourceFetcher(writer);
      } catch (Exception e) {
         tr11.appendTcDetail(e);
         tr11.writeTo(writer);
      }

      /* TestCase: V2URLTests_BaseURL_ApiRenderResurl_setParameters6 */
      /* Details: "Method setParameters(java.util.Map): Previously existing */
      /* private parameters not contained in the specified input map are */
      /* removed" */
      TestResult tr12 = tcd.getTestResultFailed(
            V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERS6);
      try {
         ResourceURL turl = portletResp.createResourceURL();
         Map<String, String[]> parms = new HashMap<String, String[]>();
         parms.put("tc", new String[] {
               "V2URLTests_BaseURL_ApiRenderResurl_setParameters6" });
         turl.setParameter("oldParm", "oldVal");
         parms.put("parm1", new String[] { "val1", "val2" });
         turl.setParameters(parms);

         // Use setup link to set public render parameter to known value
         PortletURL rurl = portletResp.createRenderURL();
         rurl.removePublicRenderParameter("tckPRP1");
         TestSetupLink tsl = new TestSetupLink(
               "V2URLTests_BaseURL_ApiRenderResurl_setParameters6", rurl);
         tsl.writeTo(writer);

         // add the resource results fetcher to the output stream
         ResourceLink rl = new ResourceLink(
               "V2URLTests_BaseURL_ApiRenderResurl_setParameters6", turl);
         rl.writeResourceFetcher(writer);
      } catch (Exception e) {
         tr12.appendTcDetail(e);
         tr12.writeTo(writer);
      }

      /* TestCase: V2URLTests_BaseURL_ApiRenderResurl_setParameters7 */
      /* Details: "Method setParameters(java.util.Map): Previously existing */
      /* public parameters not contained in the specified input map remain */
      /* unchanged" */
      TestResult tr13 = tcd.getTestResultFailed(
            V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERS7);
      try {
         ResourceURL turl = portletResp.createResourceURL();
         Map<String, String[]> parms = new HashMap<String, String[]>();
         parms.put("tc", new String[] {
               "V2URLTests_BaseURL_ApiRenderResurl_setParameters7" });
         parms.put("parm1", new String[] { "val1", "val2" });
         turl.setParameters(parms);

         // Use setup link to set public render parameter to known value
         PortletURL rurl = portletResp.createRenderURL();
         rurl.setParameter("tckPRP1",
               "V2URLTests_BaseURL_ApiRenderResurl_setParameters7");
         TestSetupLink tsl = new TestSetupLink(
               "V2URLTests_BaseURL_ApiRenderResurl_setParameters7", rurl);
         tsl.writeTo(writer);

         // add the resource results fetcher to the output stream
         ResourceLink rl = new ResourceLink(
               "V2URLTests_BaseURL_ApiRenderResurl_setParameters7", turl);
         rl.writeResourceFetcher(writer);
      } catch (Exception e) {
         tr13.appendTcDetail(e);
         tr13.writeTo(writer);
      }

      /* TestCase: V2URLTests_BaseURL_ApiRenderResurl_setParameters8 */
      /* Details: "Method setParameters(java.util.Map): Parameters that are */
      /* set are available in requests initiated through the URL" */
      TestResult tr14 = tcd.getTestResultFailed(
            V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERS8);
      try {
         ResourceURL turl = portletResp.createResourceURL();
         Map<String, String[]> parms = new HashMap<String, String[]>();
         parms.put("tc", new String[] {
               "V2URLTests_BaseURL_ApiRenderResurl_setParameters8" });
         parms.put("parm1", new String[] { "val1", "val2" });
         turl.setParameters(parms);

         // Use setup link to set public render parameter to known value
         PortletURL rurl = portletResp.createRenderURL();
         rurl.removePublicRenderParameter("tckPRP1");
         TestSetupLink tsl = new TestSetupLink(
               "V2URLTests_BaseURL_ApiRenderResurl_setParameters8", rurl);
         tsl.writeTo(writer);

         // add the resource results fetcher to the output stream
         ResourceLink rl = new ResourceLink(
               "V2URLTests_BaseURL_ApiRenderResurl_setParameters8", turl);
         rl.writeResourceFetcher(writer);
      } catch (Exception e) {
         tr14.appendTcDetail(e);
         tr14.writeTo(writer);
      }

      /* TestCase: V2URLTests_BaseURL_ApiRenderResurl_setParameters9 */
      /* Details: "Method setParameters(java.util.Map): Throws */
      /* IllegalArgumentException if the input map is null" */
      TestResult tr15 = tcd.getTestResultFailed(
            V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERS9);
      try {
         try {
            ResourceURL turl = portletResp.createResourceURL();
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

      /* TestCase: V2URLTests_BaseURL_ApiRenderResurl_setParameters10 */
      /* Details: "Method setParameters(java.util.Map): Throws */
      /* IllegalArgumentException if any key in the map is null" */
      TestResult tr16 = tcd.getTestResultFailed(
            V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERS10);
      try {
         try {
            ResourceURL turl = portletResp.createResourceURL();
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

      /* TestCase: V2URLTests_BaseURL_ApiRenderResurl_setParameters12 */
      /* Details: "Method setParameters(java.util.Map): Throws */
      /* IllegalArgumentException if the values array for any key is null " */
      TestResult tr17 = tcd.getTestResultFailed(
            V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERS12);
      try {
         try {
            ResourceURL turl = portletResp.createResourceURL();
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

      /* TestCase: V2URLTests_BaseURL_ApiRenderResurl_setSecure2 */
      /* Details: "Method setSecure(boolean): If the input parameter is */
      /* true, the resulting URL uses a secure connection (HTTPS)" */
      TestResult tr18 = tcd
            .getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERRESURL_SETSECURE2);
      try {
         ResourceURL turl = portletResp.createResourceURL();
         turl.setParameter("tc",
               "V2URLTests_BaseURL_ApiRenderResurl_setSecure2");
         try {
            turl.setSecure(true);
         } catch (PortletSecurityException e) {
            // handle as successful completion, since runtime does not support
            // setting
            turl.setParameter("setSecure", "not supported");
         }

         // add the resource results fetcher to the output stream
         ResourceLink rl = new ResourceLink(
               "V2URLTests_BaseURL_ApiRenderResurl_setSecure2", turl);
         rl.writeResourceFetcher(writer);
      } catch (Exception e) {
         tr18.appendTcDetail(e);
         tr18.writeTo(writer);
      }

      /* TestCase: V2URLTests_BaseURL_ApiRenderResurl_toString */
      /* Details: "Method toString(): Returns a String containing the */
      /* portlet URL representation to be included in the markup" */
      TestResult tr19 = tcd
            .getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERRESURL_TOSTRING);
      try {
         ResourceURL turl = portletResp.createResourceURL();
         turl.setParameter("tc", "V2URLTests_BaseURL_ApiRenderResurl_toString");
         String urlstr = turl.toString();

         // add the resource results fetcher to the output stream
         ResourceLink rl = new ResourceLink(
               "V2URLTests_BaseURL_ApiRenderResurl_toString", urlstr);
         rl.writeResourceFetcher(writer);
      } catch (Exception e) {
         tr19.appendTcDetail(e);
         tr19.writeTo(writer);
      }

      /* TestCase: V2URLTests_BaseURL_ApiRenderResurl_getParameterMap1 */
      /* Details: "Method getParameterMap(): Returns an */
      /* java.util.Map&lt;java.lang.String,java.lang.String[]&gt; object */
      /* for the parameter names and values if parameters are available" */
      TestResult tr20 = tcd.getTestResultFailed(
            V2URLTESTS_BASEURL_APIRENDERRESURL_GETPARAMETERMAP1);
      try {
         ResourceURL turl = portletResp.createResourceURL();
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

      /* TestCase: V2URLTests_BaseURL_ApiRenderResurl_getParameterMap4 */
      /* Details: "Method getParameterMap(): The returned map contains all */
      /* resource parameters for the request" */
      TestResult tr21 = tcd.getTestResultFailed(
            V2URLTESTS_BASEURL_APIRENDERRESURL_GETPARAMETERMAP4);
      try {
         ResourceURL turl = portletResp.createResourceURL();
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

      /* TestCase: V2URLTests_BaseURL_ApiRenderResurl_getParameterMap5 */
      /* Details: "Method getParameterMap(): The returned map does not */
      /* contain any render parameters for the request" */
      TestResult tr22 = tcd.getTestResultFailed(
            V2URLTESTS_BASEURL_APIRENDERRESURL_GETPARAMETERMAP5);
      try {
         // set render parameter for test. The driver will click the link before
         // collecting results.
         PortletURL rurl = portletResp.createRenderURL();
         rurl.setParameter(PARM_NAME, PARM_VALUE);
         TestLink tl = new TestLink(
               "V2URLTests_BaseURL_ApiRenderResurl_getParameterMap5", rurl);
         tl.writeTo(writer);

         // Test result only valid after link has been clicked.
         ResourceURL turl = portletResp.createResourceURL();
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

      /* TestCase: V2URLTests_BaseURL_ApiRenderResurl_getParameterMap6 */
      /* Details: "Method getParameterMap(): Returns an empty map if no */
      /* parameters exist" */
      TestResult tr23 = tcd.getTestResultFailed(
            V2URLTESTS_BASEURL_APIRENDERRESURL_GETPARAMETERMAP6);
      try {
         ResourceURL turl = portletResp.createResourceURL();
         Map<String, String[]> parms = turl.getParameterMap();
         if (parms == null) {
            tr23.appendTcDetail("Returned map is null.");
         } else {
            tr23.setTcSuccess(parms.isEmpty());
         }
      } catch (Exception e) {
         tr23.appendTcDetail(e);
      }
      tr23.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderResurl_writeA1 */
      /* Details: "Method write(Writer out): Writes the URL to the output */
      /* stream through the provided Writer" */
      TestResult tr24 = tcd
            .getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERRESURL_WRITEA1);
      try {
         ResourceURL turl = portletResp.createResourceURL();
         turl.setParameter("tc", "V2URLTests_BaseURL_ApiRenderResurl_writeA1");
         StringWriter tsw = new StringWriter();
         turl.write(tsw);
         String urlstr = tsw.toString();

         // add the resource results fetcher to the output stream
         ResourceLink rl = new ResourceLink(
               "V2URLTests_BaseURL_ApiRenderResurl_writeA1", urlstr);
         rl.writeResourceFetcher(writer);
      } catch (Exception e) {
         tr24.appendTcDetail(e);
         tr24.writeTo(writer);
      }

      /* TestCase: V2URLTests_BaseURL_ApiRenderResurl_writeB1 */
      /* Details: "Method write(Writer out, boolean escapeXML): Writes the */
      /* URL to the output stream through the provided Writer" */
      TestResult tr25 = tcd
            .getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERRESURL_WRITEB1);
      try {
         ResourceURL turl = portletResp.createResourceURL();
         turl.setParameter("tc", "V2URLTests_BaseURL_ApiRenderResurl_writeB1");
         StringWriter tsw = new StringWriter();
         turl.write(tsw, true);
         String urlstr = tsw.toString();

         // add the resource results fetcher to the output stream
         ResourceLink rl = new ResourceLink(
               "V2URLTests_BaseURL_ApiRenderResurl_writeB1", urlstr);
         rl.writeResourceFetcher(writer);
      } catch (Exception e) {
         tr25.appendTcDetail(e);
         tr25.writeTo(writer);
      }

      /* TestCase: V2URLTests_BaseURL_ApiRenderResurl_addProperty1 */
      /* Details: "Method addProperty(String, String): A property can be */
      /* added" */
      TestResult tr26 = tcd.getTestResultFailed(
            V2URLTESTS_BASEURL_APIRENDERRESURL_ADDPROPERTY1);
      try {
         // Test if method can be called. Not possible to check resulting
         // property values.
         ResourceURL turl = portletResp.createResourceURL();
         turl.addProperty("prop1", "val1");
         tr26.setTcSuccess(true);
      } catch (Exception e) {
         tr26.appendTcDetail(e);
      }
      tr26.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderResurl_addProperty3 */
      /* Details: "Method addProperty(String, String): Throws */
      /* IllegalArgumentException if the specified key is null" */
      TestResult tr27 = tcd.getTestResultFailed(
            V2URLTESTS_BASEURL_APIRENDERRESURL_ADDPROPERTY3);
      try {
         try {
            ResourceURL turl = portletResp.createResourceURL();
            turl.addProperty(null, "value");
            tr27.appendTcDetail("Method did not throw an exception.");
         } catch (IllegalArgumentException iae) {
            tr27.setTcSuccess(true);
         } catch (Exception e) {
            tr27.appendTcDetail(e);
         }
      } catch (Exception e) {
         tr27.appendTcDetail(e);
      }
      tr27.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderResurl_setProperty1 */
      /* Details: "Method setProperty(String, String): Sets a property */
      /* value for the specified key" */
      TestResult tr28 = tcd.getTestResultFailed(
            V2URLTESTS_BASEURL_APIRENDERRESURL_SETPROPERTY1);
      try {
         // Test if method can be called. Not possible to check resulting
         // property values.
         ResourceURL turl = portletResp.createResourceURL();
         turl.setProperty("prop1", "val1");
         tr28.setTcSuccess(true);
      } catch (Exception e) {
         tr28.appendTcDetail(e);
      }
      tr28.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderResurl_setProperty3 */
      /* Details: "Method setProperty(String, String): Throws */
      /* IllegalArgumentException if the specified key is null" */
      TestResult tr29 = tcd.getTestResultFailed(
            V2URLTESTS_BASEURL_APIRENDERRESURL_SETPROPERTY3);
      try {
         try {
            ResourceURL turl = portletResp.createResourceURL();
            turl.setProperty(null, "value");
            tr29.appendTcDetail("Method did not throw an exception.");
         } catch (IllegalArgumentException iae) {
            tr29.setTcSuccess(true);
         } catch (Exception e) {
            tr29.appendTcDetail(e);
         }
      } catch (Exception e) {
         tr29.appendTcDetail(e);
      }
      tr29.writeTo(writer);

   }

}
