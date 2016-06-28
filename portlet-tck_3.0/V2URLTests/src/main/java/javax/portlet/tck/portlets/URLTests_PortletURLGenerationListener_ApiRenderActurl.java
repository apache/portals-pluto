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

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.tck.beans.JSR286ApiTestCaseDetails;
import javax.portlet.tck.beans.TestButton;
import javax.portlet.tck.beans.TestResult;

import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERACTURL_CONFIGURATION;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERACTURL_PORTLETURLGENERATIONLISTENER6;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERACTURL_FILTERACTIONURL1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERACTURL_FILTERACTIONURL2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERACTURL_FILTERACTIONURL3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERACTURL_FILTERACTIONURL4;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERACTURL_FILTERACTIONURL5;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import static javax.portlet.tck.constants.Constants.RESULT_ATTR_PREFIX;

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
 * URLTests_PortletURLGenerationListener_ApiRenderActurl_event
 *
 */
public class URLTests_PortletURLGenerationListener_ApiRenderActurl
      implements Portlet {

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
      // V2URLTests_PortletURLGenerationListener_ApiRenderActurl_configuration
      {
         JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();
         TestResult tr0 = tcd.getTestResultFailed(
               V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERACTURL_CONFIGURATION);
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't defined (test case error)
         if (tcval != null && tcval.equals(
               "V2URLTests_PortletURLGenerationListener_ApiRenderActurl_configuration")) {
            // Verify that the listener set the parameter as expected
            String val = portletReq.getParameter("PUGL");
            boolean ok = (val != null) && val.equals("Action");
            if (!ok) {
               tr0.appendTcDetail(
                     "Parameter not set by listener. Expected: Action, actual: "
                           + val);
            }
            tr0.setTcSuccess(ok);
            PortletSession ps = portletReq.getPortletSession();
            ps.setAttribute(
                  RESULT_ATTR_PREFIX
                        + "V2URLTests_PortletURLGenerationListener_ApiRenderActurl_configuration",
                  tr0);
         }
      }

      // evaluate results for test case
      // V2URLTests_PortletURLGenerationListener_ApiRenderActurl_portletURLGenerationListener6
      {
         JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();
         TestResult tr1 = tcd.getTestResultFailed(
               V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERACTURL_PORTLETURLGENERATIONLISTENER6);
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't defined (test case error)
         if (tcval != null && tcval.equals(
               "V2URLTests_PortletURLGenerationListener_ApiRenderActurl_portletURLGenerationListener6")) {
            // Verify that the listener set the parameter as expected
            String val = portletReq.getParameter("PUGL2");
            boolean ok = (val != null) && val.equals("Action");
            if (!ok) {
               tr1.appendTcDetail(
                     "Parameter not set by listener. Expected: Action, actual: "
                           + val);
            }
            tr1.setTcSuccess(ok);
            PortletSession ps = portletReq.getPortletSession();
            ps.setAttribute(
                  RESULT_ATTR_PREFIX
                        + "V2URLTests_PortletURLGenerationListener_ApiRenderActurl_portletURLGenerationListener6",
                  tr1);
         }
      }

      // evaluate results for test case
      // V2URLTests_PortletURLGenerationListener_ApiRenderActurl_filterActionURL1
      {
         JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();
         TestResult tr2 = tcd.getTestResultFailed(
               V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERACTURL_FILTERACTIONURL1);
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't defined (test case error)
         if (tcval != null && tcval.equals(
               "V2URLTests_PortletURLGenerationListener_ApiRenderActurl_filterActionURL1")) {
            // Verify that the listener set the parameter as expected
            String val = portletReq.getParameter("PUGL");
            boolean ok = (val != null) && val.equals("Action");
            if (!ok) {
               tr2.appendTcDetail(
                     "Parameter not set by listener. Expected: Action, actual: "
                           + val);
            }
            tr2.setTcSuccess(ok);
            PortletSession ps = portletReq.getPortletSession();
            ps.setAttribute(
                  RESULT_ATTR_PREFIX
                        + "V2URLTests_PortletURLGenerationListener_ApiRenderActurl_filterActionURL1",
                  tr2);
         }
      }

      // evaluate results for test case
      // V2URLTests_PortletURLGenerationListener_ApiRenderActurl_filterActionURL2
      {
         JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();
         TestResult tr3 = tcd.getTestResultFailed(
               V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERACTURL_FILTERACTIONURL2);
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't defined (test case error)
         if (tcval != null && tcval.equals(
               "V2URLTests_PortletURLGenerationListener_ApiRenderActurl_filterActionURL2")) {
            // Verify that the listener set the parameter as expected
            String val = portletReq.getParameter("PUGL");
            boolean ok = (val != null) && val.equals("Action");
            if (!ok) {
               tr3.appendTcDetail(
                     "Parameter not set by listener. Expected: Action, actual: "
                           + val);
            }
            tr3.setTcSuccess(ok);
            PortletSession ps = portletReq.getPortletSession();
            ps.setAttribute(
                  RESULT_ATTR_PREFIX
                        + "V2URLTests_PortletURLGenerationListener_ApiRenderActurl_filterActionURL2",
                  tr3);
         }
      }

      // evaluate results for test case
      // V2URLTests_PortletURLGenerationListener_ApiRenderActurl_filterActionURL3
      {
         JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();
         TestResult tr4 = tcd.getTestResultFailed(
               V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERACTURL_FILTERACTIONURL3);
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't defined (test case error)
         if (tcval != null && tcval.equals(
               "V2URLTests_PortletURLGenerationListener_ApiRenderActurl_filterActionURL3")) {
            // Verify that the listener set the parameter as expected
            String val = portletReq.getParameter("PUGL");
            boolean ok = (val != null) && val.equals("Action");
            if (!ok) {
               tr4.appendTcDetail(
                     "Parameter not set by listener. Expected: Action, actual: "
                           + val);
            }
            tr4.setTcSuccess(ok);
            PortletSession ps = portletReq.getPortletSession();
            ps.setAttribute(
                  RESULT_ATTR_PREFIX
                        + "V2URLTests_PortletURLGenerationListener_ApiRenderActurl_filterActionURL3",
                  tr4);
         }
      }

      // evaluate results for test case
      // V2URLTests_PortletURLGenerationListener_ApiRenderActurl_filterActionURL4
      {
         JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();
         TestResult tr5 = tcd.getTestResultFailed(
               V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERACTURL_FILTERACTIONURL4);
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't defined (test case error)
         if (tcval != null && tcval.equals(
               "V2URLTests_PortletURLGenerationListener_ApiRenderActurl_filterActionURL4")) {
            // Verify that the listener set the parameter as expected
            String val = portletReq.getParameter("PUGL");
            boolean ok = (val != null) && val.equals("Action");
            if (!ok) {
               tr5.appendTcDetail(
                     "Parameter not set by listener. Expected: Action, actual: "
                           + val);
            }
            tr5.setTcSuccess(ok);
            PortletSession ps = portletReq.getPortletSession();
            ps.setAttribute(
                  RESULT_ATTR_PREFIX
                        + "V2URLTests_PortletURLGenerationListener_ApiRenderActurl_filterActionURL4",
                  tr5);
         }
      }

      // evaluate results for test case
      // V2URLTests_PortletURLGenerationListener_ApiRenderActurl_filterActionURL5
      {
         JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();
         TestResult tr6 = tcd.getTestResultFailed(
               V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERACTURL_FILTERACTIONURL5);
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't defined (test case error)
         if (tcval != null && tcval.equals(
               "V2URLTests_PortletURLGenerationListener_ApiRenderActurl_filterActionURL5")) {
            // Verify that the listener set the parameter as expected
            String val = portletReq.getParameter("PUGL");
            boolean ok = (val != null) && val.equals("Action");
            if (!ok) {
               tr6.appendTcDetail(
                     "Parameter not set by listener. Expected: Action, actual: "
                           + val);
            }
            tr6.setTcSuccess(ok);
            PortletSession ps = portletReq.getPortletSession();
            ps.setAttribute(
                  RESULT_ATTR_PREFIX
                        + "V2URLTests_PortletURLGenerationListener_ApiRenderActurl_filterActionURL5",
                  tr6);
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

      /*
       * TestCase:
       * V2URLTests_PortletURLGenerationListener_ApiRenderActurl_configuration
       */
      /* Details: "A PortletURLGenerationListener can be configured in the */
      /* portlet deployment descriptor" */
      TestResult tr0 = tcd.getTestResultFailed(
            V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERACTURL_CONFIGURATION);
      try {
         PortletURL turl = portletResp.createActionURL();
         turl.setParameter("tc",
               "V2URLTests_PortletURLGenerationListener_ApiRenderActurl_configuration");
         String urlstr = turl.toString();

         // add the execution button for an action request
         TestButton tb = new TestButton(
               V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERACTURL_CONFIGURATION,
               urlstr);
         tb.writeTo(writer);

         // display evaluated results
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't set (test case error)
         if (tcval != null && tcval.equals(
               "V2URLTests_PortletURLGenerationListener_ApiRenderActurl_configuration")) {
            PortletSession ps = portletReq.getPortletSession();
            TestResult tmp = (TestResult) ps.getAttribute(RESULT_ATTR_PREFIX
                  + "V2URLTests_PortletURLGenerationListener_ApiRenderActurl_configuration");
            if (tmp != null) {
               tr0 = tmp;
               ps.removeAttribute(RESULT_ATTR_PREFIX
                     + "V2URLTests_PortletURLGenerationListener_ApiRenderActurl_configuration");
            }
         }
      } catch (Exception e) {
         tr0.appendTcDetail(e);
      }
      tr0.writeTo(writer);

      /*
       * TestCase:
       * V2URLTests_PortletURLGenerationListener_ApiRenderActurl_portletURLGenerationListener6
       */
      /* Details: "If more than one listener is registered the portlet */
      /* container must chain the listeners in the order of how they appear */
      /* in the deployment descriptor" */
      TestResult tr1 = tcd.getTestResultFailed(
            V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERACTURL_PORTLETURLGENERATIONLISTENER6);
      try {
         PortletURL turl = portletResp.createActionURL();
         turl.setParameter("tc",
               "V2URLTests_PortletURLGenerationListener_ApiRenderActurl_portletURLGenerationListener6");
         String urlstr = turl.toString();

         // add the execution button for an action request
         TestButton tb = new TestButton(
               V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERACTURL_PORTLETURLGENERATIONLISTENER6,
               urlstr);
         tb.writeTo(writer);

         // display evaluated results
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't set (test case error)
         if (tcval != null && tcval.equals(
               "V2URLTests_PortletURLGenerationListener_ApiRenderActurl_portletURLGenerationListener6")) {
            PortletSession ps = portletReq.getPortletSession();
            TestResult tmp = (TestResult) ps.getAttribute(RESULT_ATTR_PREFIX
                  + "V2URLTests_PortletURLGenerationListener_ApiRenderActurl_portletURLGenerationListener6");
            if (tmp != null) {
               tr1 = tmp;
               ps.removeAttribute(RESULT_ATTR_PREFIX
                     + "V2URLTests_PortletURLGenerationListener_ApiRenderActurl_portletURLGenerationListener6");
            }
         }
      } catch (Exception e) {
         tr1.appendTcDetail(e);
      }
      tr1.writeTo(writer);

      /*
       * TestCase:
       * V2URLTests_PortletURLGenerationListener_ApiRenderActurl_filterActionURL1
       */
      /* Details: "Method filterActionURL(PortletURL): The */
      /* filterActionURL(PortletURL): method is called before the */
      /* toString() method is executed" */
      TestResult tr2 = tcd.getTestResultFailed(
            V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERACTURL_FILTERACTIONURL1);
      try {
         PortletURL turl = portletResp.createActionURL();
         turl.setParameter("tc",
               "V2URLTests_PortletURLGenerationListener_ApiRenderActurl_filterActionURL1");
         String urlstr = turl.toString();

         // add the execution button for an action request
         TestButton tb = new TestButton(
               V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERACTURL_FILTERACTIONURL1,
               urlstr);
         tb.writeTo(writer);

         // display evaluated results
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't set (test case error)
         if (tcval != null && tcval.equals(
               "V2URLTests_PortletURLGenerationListener_ApiRenderActurl_filterActionURL1")) {
            PortletSession ps = portletReq.getPortletSession();
            TestResult tmp = (TestResult) ps.getAttribute(RESULT_ATTR_PREFIX
                  + "V2URLTests_PortletURLGenerationListener_ApiRenderActurl_filterActionURL1");
            if (tmp != null) {
               tr2 = tmp;
               ps.removeAttribute(RESULT_ATTR_PREFIX
                     + "V2URLTests_PortletURLGenerationListener_ApiRenderActurl_filterActionURL1");
            }
         }
      } catch (Exception e) {
         tr2.appendTcDetail(e);
      }
      tr2.writeTo(writer);

      /*
       * TestCase:
       * V2URLTests_PortletURLGenerationListener_ApiRenderActurl_filterActionURL2
       */
      /* Details: "Method filterActionURL(PortletURL): The */
      /* filterActionURL(PortletURL): method is called before the */
      /* write(Writer out) method is executed" */
      TestResult tr3 = tcd.getTestResultFailed(
            V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERACTURL_FILTERACTIONURL2);
      try {
         PortletURL turl = portletResp.createActionURL();
         turl.setParameter("tc",
               "V2URLTests_PortletURLGenerationListener_ApiRenderActurl_filterActionURL2");
         StringWriter tsw = new StringWriter();
         turl.write(tsw);
         String urlstr = tsw.toString();

         // add the execution button for an action request
         TestButton tb = new TestButton(
               V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERACTURL_FILTERACTIONURL2,
               urlstr);
         tb.writeTo(writer);

         // display evaluated results
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't set (test case error)
         if (tcval != null && tcval.equals(
               "V2URLTests_PortletURLGenerationListener_ApiRenderActurl_filterActionURL2")) {
            PortletSession ps = portletReq.getPortletSession();
            TestResult tmp = (TestResult) ps.getAttribute(RESULT_ATTR_PREFIX
                  + "V2URLTests_PortletURLGenerationListener_ApiRenderActurl_filterActionURL2");
            if (tmp != null) {
               tr3 = tmp;
               ps.removeAttribute(RESULT_ATTR_PREFIX
                     + "V2URLTests_PortletURLGenerationListener_ApiRenderActurl_filterActionURL2");
            }
         }
      } catch (Exception e) {
         tr3.appendTcDetail(e);
      }
      tr3.writeTo(writer);

      /*
       * TestCase:
       * V2URLTests_PortletURLGenerationListener_ApiRenderActurl_filterActionURL3
       */
      /* Details: "Method filterActionURL(PortletURL): The */
      /* filterActionURL(PortletURL): method is called before the */
      /* write(Writer out, boolean escapeXML) method is executed" */
      TestResult tr4 = tcd.getTestResultFailed(
            V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERACTURL_FILTERACTIONURL3);
      try {
         PortletURL turl = portletResp.createActionURL();
         turl.setParameter("tc",
               "V2URLTests_PortletURLGenerationListener_ApiRenderActurl_filterActionURL3");
         StringWriter tsw = new StringWriter();
         turl.write(tsw, true);
         String urlstr = tsw.toString();

         // add the execution button for an action request
         TestButton tb = new TestButton(
               V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERACTURL_FILTERACTIONURL3,
               urlstr);
         tb.writeTo(writer);

         // display evaluated results
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't set (test case error)
         if (tcval != null && tcval.equals(
               "V2URLTests_PortletURLGenerationListener_ApiRenderActurl_filterActionURL3")) {
            PortletSession ps = portletReq.getPortletSession();
            TestResult tmp = (TestResult) ps.getAttribute(RESULT_ATTR_PREFIX
                  + "V2URLTests_PortletURLGenerationListener_ApiRenderActurl_filterActionURL3");
            if (tmp != null) {
               tr4 = tmp;
               ps.removeAttribute(RESULT_ATTR_PREFIX
                     + "V2URLTests_PortletURLGenerationListener_ApiRenderActurl_filterActionURL3");
            }
         }
      } catch (Exception e) {
         tr4.appendTcDetail(e);
      }
      tr4.writeTo(writer);

      /*
       * TestCase:
       * V2URLTests_PortletURLGenerationListener_ApiRenderActurl_filterActionURL4
       */
      /* Details: "Method filterActionURL(PortletURL): The filterActionURL */
      /* method is passed the PortletURL object representing the action */
      /* URL" */
      TestResult tr5 = tcd.getTestResultFailed(
            V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERACTURL_FILTERACTIONURL4);
      try {
         PortletURL turl = portletResp.createActionURL();
         turl.setParameter("tc",
               "V2URLTests_PortletURLGenerationListener_ApiRenderActurl_filterActionURL4");
         String urlstr = turl.toString();

         // add the execution button for an action request
         TestButton tb = new TestButton(
               V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERACTURL_FILTERACTIONURL4,
               urlstr);
         tb.writeTo(writer);

         // display evaluated results
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't set (test case error)
         if (tcval != null && tcval.equals(
               "V2URLTests_PortletURLGenerationListener_ApiRenderActurl_filterActionURL4")) {
            PortletSession ps = portletReq.getPortletSession();
            TestResult tmp = (TestResult) ps.getAttribute(RESULT_ATTR_PREFIX
                  + "V2URLTests_PortletURLGenerationListener_ApiRenderActurl_filterActionURL4");
            if (tmp != null) {
               tr5 = tmp;
               ps.removeAttribute(RESULT_ATTR_PREFIX
                     + "V2URLTests_PortletURLGenerationListener_ApiRenderActurl_filterActionURL4");
            }
         }
      } catch (Exception e) {
         tr5.appendTcDetail(e);
      }
      tr5.writeTo(writer);

      /*
       * TestCase:
       * V2URLTests_PortletURLGenerationListener_ApiRenderActurl_filterActionURL5
       */
      /* Details: "Method filterActionURL(PortletURL): The input URL object */
      /* can be modified by setting a parameter and the modified URL object */
      /* is processed by the PortletURL toString or write method" */
      TestResult tr6 = tcd.getTestResultFailed(
            V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERACTURL_FILTERACTIONURL5);
      try {
         PortletURL turl = portletResp.createActionURL();
         turl.setParameter("tc",
               "V2URLTests_PortletURLGenerationListener_ApiRenderActurl_filterActionURL5");
         String urlstr = turl.toString();

         // add the execution button for an action request
         TestButton tb = new TestButton(
               V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERACTURL_FILTERACTIONURL5,
               urlstr);
         tb.writeTo(writer);

         // display evaluated results
         String tcval = portletReq.getParameter("tc");
         // let exception be thrown if tc parm isn't set (test case error)
         if (tcval != null && tcval.equals(
               "V2URLTests_PortletURLGenerationListener_ApiRenderActurl_filterActionURL5")) {
            PortletSession ps = portletReq.getPortletSession();
            TestResult tmp = (TestResult) ps.getAttribute(RESULT_ATTR_PREFIX
                  + "V2URLTests_PortletURLGenerationListener_ApiRenderActurl_filterActionURL5");
            if (tmp != null) {
               tr6 = tmp;
               ps.removeAttribute(RESULT_ATTR_PREFIX
                     + "V2URLTests_PortletURLGenerationListener_ApiRenderActurl_filterActionURL5");
            }
         }
      } catch (Exception e) {
         tr6.appendTcDetail(e);
      }
      tr6.writeTo(writer);

   }

}
