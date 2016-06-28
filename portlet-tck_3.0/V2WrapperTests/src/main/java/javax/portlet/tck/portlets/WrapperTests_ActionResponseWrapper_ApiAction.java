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

import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_ACTIONRESPONSEWRAPPER_APIACTION_SENDREDIRECTA;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_ACTIONRESPONSEWRAPPER_APIACTION_SENDREDIRECTB;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_ACTIONRESPONSEWRAPPER_APIACTION_SETEVENTA;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_ACTIONRESPONSEWRAPPER_APIACTION_SETEVENTB;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_ACTIONRESPONSEWRAPPER_APIACTION_SETPORTLETMODE;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_ACTIONRESPONSEWRAPPER_APIACTION_SETRENDERPARAMETERA;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_ACTIONRESPONSEWRAPPER_APIACTION_SETRENDERPARAMETERB;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_ACTIONRESPONSEWRAPPER_APIACTION_SETRENDERPARAMETERS;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_ACTIONRESPONSEWRAPPER_APIACTION_SETWINDOWSTATE;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_ACTIONRESPONSEWRAPPER_APIACTION_GETRESPONSE;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_ACTIONRESPONSEWRAPPER_APIACTION_SETRESPONSE;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_ACTIONRESPONSEWRAPPER_APIACTION_GETPORTLETMODE;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_ACTIONRESPONSEWRAPPER_APIACTION_GETRENDERPARAMETERMAP1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_ACTIONRESPONSEWRAPPER_APIACTION_GETWINDOWSTATE;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_ACTIONRESPONSEWRAPPER_APIACTION_REMOVEPUBLICRENDERPARAMETER;
import static javax.portlet.PortletSession.APPLICATION_SCOPE;
import static javax.portlet.tck.constants.Constants.RESULT_ATTR_PREFIX;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;

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
import javax.portlet.PortletMode;
import javax.portlet.PortletSession;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;
import javax.portlet.filter.ActionResponseWrapper;
import javax.portlet.tck.beans.ActionResponseWrapperChecker;
import javax.portlet.tck.beans.JSR286ApiTestCaseDetails;
import javax.portlet.tck.beans.TestButton;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.constants.Constants;

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
 * WrapperTests_ActionResponseWrapper_ApiAction_event
 *
 */
public class WrapperTests_ActionResponseWrapper_ApiAction implements Portlet {

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

      StringWriter writer = new StringWriter();

      ActionResponseWrapperChecker wc = new ActionResponseWrapperChecker(
            portletResp);
      ActionResponseWrapper wpr = new ActionResponseWrapper(portletResp);
      wpr.setResponse(wc);
      JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

      // Create result objects for the tests

      /*
       * TestCase: V2WrapperTests_ActionResponseWrapper_ApiAction_sendRedirectA
       */
      /* Details: "Method sendRedirect(String): Calls wrapped method" */
      TestResult tr0 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_ACTIONRESPONSEWRAPPER_APIACTION_SENDREDIRECTA);
      try {
         String parm1 = "val1";
         Object[] args = { parm1 };
         wc.prepare(tr0, "sendRedirect", args);
         wpr.sendRedirect(parm1);
      } catch (Exception e) {
         tr0.appendTcDetail(e.toString());
      }
      tr0.writeTo(writer);

      /*
       * TestCase: V2WrapperTests_ActionResponseWrapper_ApiAction_sendRedirectB
       */
      /* Details: "Method sendRedirect(String, String): Calls wrapped */
      /* method" */
      TestResult tr1 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_ACTIONRESPONSEWRAPPER_APIACTION_SENDREDIRECTB);
      try {
         String parm1 = "val1";
         String parm2 = "val2";
         Object[] args = { parm1, parm2 };
         wc.prepare(tr1, "sendRedirect", args);
         wpr.sendRedirect(parm1, parm2);
      } catch (Exception e) {
         tr1.appendTcDetail(e.toString());
      }
      tr1.writeTo(writer);

      /* TestCase: V2WrapperTests_ActionResponseWrapper_ApiAction_setEventA */
      /* Details: "Method setEvent(javax.xml.namespace.QName, */
      /* java.io.Serializable): Calls wrapped method" */
      TestResult tr2 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_ACTIONRESPONSEWRAPPER_APIACTION_SETEVENTA);
      try {
         javax.xml.namespace.QName parm1 = new javax.xml.namespace.QName("bob");
         String parm2 = "val2";
         Object[] args = { parm1, parm2 };
         wc.prepare(tr2, "setEvent", args);
         wpr.setEvent(parm1, parm2);
      } catch (Exception e) {
         tr2.appendTcDetail(e.toString());
      }
      tr2.writeTo(writer);

      /* TestCase: V2WrapperTests_ActionResponseWrapper_ApiAction_setEventB */
      /* Details: "Method setEvent(String, java.io.Serializable): Calls */
      /* wrapped method" */
      TestResult tr3 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_ACTIONRESPONSEWRAPPER_APIACTION_SETEVENTB);
      try {
         String parm1 = "val1";
         String parm2 = "val2";
         Object[] args = { parm1, parm2 };
         wc.prepare(tr3, "setEvent", args);
         wpr.setEvent(parm1, parm2);
      } catch (Exception e) {
         tr3.appendTcDetail(e.toString());
      }
      tr3.writeTo(writer);

      /*
       * TestCase: V2WrapperTests_ActionResponseWrapper_ApiAction_setPortletMode
       */
      /* Details: "Method setPortletMode(PortletMode): Calls wrapped */
      /* method" */
      TestResult tr4 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_ACTIONRESPONSEWRAPPER_APIACTION_SETPORTLETMODE);
      try {
         PortletMode parm1 = PortletMode.EDIT;
         Object[] args = { parm1 };
         wc.prepare(tr4, "setPortletMode", args);
         wpr.setPortletMode(parm1);
      } catch (Exception e) {
         tr4.appendTcDetail(e.toString());
      }
      tr4.writeTo(writer);

      /*
       * TestCase:
       * V2WrapperTests_ActionResponseWrapper_ApiAction_setRenderParameterA
       */
      /* Details: "Method setRenderParameter(String, String): Calls wrapped */
      /* method" */
      TestResult tr5 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_ACTIONRESPONSEWRAPPER_APIACTION_SETRENDERPARAMETERA);
      try {
         String parm1 = "val1";
         String parm2 = "val2";
         Object[] args = { parm1, parm2 };
         wc.prepare(tr5, "setRenderParameter", args);
         wpr.setRenderParameter(parm1, parm2);
      } catch (Exception e) {
         tr5.appendTcDetail(e.toString());
      }
      tr5.writeTo(writer);

      /*
       * TestCase:
       * V2WrapperTests_ActionResponseWrapper_ApiAction_setRenderParameterB
       */
      /* Details: "Method setRenderParameter(String, String[]): Calls */
      /* wrapped method" */
      TestResult tr6 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_ACTIONRESPONSEWRAPPER_APIACTION_SETRENDERPARAMETERB);
      try {
         String parm1 = "val1";
         String[] parm2 = { "val1", "val2" };
         Object[] args = { parm1, parm2 };
         wc.prepare(tr6, "setRenderParameter", args);
         wpr.setRenderParameter(parm1, parm2);
      } catch (Exception e) {
         tr6.appendTcDetail(e.toString());
      }
      tr6.writeTo(writer);

      /*
       * TestCase:
       * V2WrapperTests_ActionResponseWrapper_ApiAction_setRenderParameters
       */
      /* Details: "Method setRenderParameters(java.util.Map): Calls wrapped */
      /* method" */
      TestResult tr7 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_ACTIONRESPONSEWRAPPER_APIACTION_SETRENDERPARAMETERS);
      try {
         Map<String, String[]> parm1 = new HashMap<String, String[]>();
         parm1.put("iparm1", new String[] { "val3", "val4" });
         parm1.put("iparm2", new String[] { "val5", "val6" });
         Object[] args = { parm1 };
         wc.prepare(tr7, "setRenderParameters", args);
         wpr.setRenderParameters(parm1);
      } catch (Exception e) {
         tr7.appendTcDetail(e.toString());
      }
      tr7.writeTo(writer);

      /*
       * TestCase: V2WrapperTests_ActionResponseWrapper_ApiAction_setWindowState
       */
      /* Details: "Method setWindowState(WindowState): Calls wrapped */
      /* method" */
      TestResult tr8 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_ACTIONRESPONSEWRAPPER_APIACTION_SETWINDOWSTATE);
      try {
         WindowState parm1 = WindowState.NORMAL;
         Object[] args = { parm1 };
         wc.prepare(tr8, "setWindowState", args);
         wpr.setWindowState(parm1);
      } catch (Exception e) {
         tr8.appendTcDetail(e.toString());
      }
      tr8.writeTo(writer);

      /* TestCase: V2WrapperTests_ActionResponseWrapper_ApiAction_getResponse */
      /* Details: "Method getResponse(): Returns wrapped ActionResponse */
      /* object" */
      TestResult tr9 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_ACTIONRESPONSEWRAPPER_APIACTION_GETRESPONSE);
      try {
         // The retrieved request / response object should be the wrapper
         // checker instance
         ActionResponse r = wpr.getResponse();
         tr9.setTcSuccess(r == wc);
      } catch (Exception e) {
         tr9.appendTcDetail(e.toString());
      }
      tr9.writeTo(writer);

      /* TestCase: V2WrapperTests_ActionResponseWrapper_ApiAction_setResponse */
      /* Details: "Method setResponse(ActionResponse): Allows wrapped */
      /* ActionResponse object to be set" */
      TestResult tr10 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_ACTIONRESPONSEWRAPPER_APIACTION_SETRESPONSE);
      try {
         // tested by method set up
         tr10.setTcSuccess(true);
      } catch (Exception e) {
         tr10.appendTcDetail(e.toString());
      }
      tr10.writeTo(writer);

      /*
       * TestCase: V2WrapperTests_ActionResponseWrapper_ApiAction_getPortletMode
       */
      /* Details: "Method getPortletMode(): Calls wrapped method" */
      TestResult tr11 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_ACTIONRESPONSEWRAPPER_APIACTION_GETPORTLETMODE);
      try {
         Object[] args = {};
         wc.prepare(tr11, "getPortletMode", args);
         wc.checkRetval(wpr.getPortletMode());
      } catch (Exception e) {
         tr11.appendTcDetail(e.toString());
      }
      tr11.writeTo(writer);

      /*
       * TestCase:
       * V2WrapperTests_ActionResponseWrapper_ApiAction_getRenderParameterMap1
       */
      /* Details: "Method getRenderParameterMap(): Calls wrapped method" */
      TestResult tr12 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_ACTIONRESPONSEWRAPPER_APIACTION_GETRENDERPARAMETERMAP1);
      try {
         Object[] args = {};
         wc.prepare(tr12, "getRenderParameterMap", args);
         wc.checkRetval(wpr.getRenderParameterMap());
      } catch (Exception e) {
         tr12.appendTcDetail(e.toString());
      }
      tr12.writeTo(writer);

      /*
       * TestCase: V2WrapperTests_ActionResponseWrapper_ApiAction_getWindowState
       */
      /* Details: "Method getWindowState(): Calls wrapped method" */
      TestResult tr13 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_ACTIONRESPONSEWRAPPER_APIACTION_GETWINDOWSTATE);
      try {
         Object[] args = {};
         wc.prepare(tr13, "getWindowState", args);
         wc.checkRetval(wpr.getWindowState());
      } catch (Exception e) {
         tr13.appendTcDetail(e.toString());
      }
      tr13.writeTo(writer);

      /*
       * TestCase:
       * V2WrapperTests_ActionResponseWrapper_ApiAction_removePublicRenderParameter
       */
      /* Details: "Method removePublicRenderParameter(String): Calls */
      /* wrapped method" */
      TestResult tr14 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_ACTIONRESPONSEWRAPPER_APIACTION_REMOVEPUBLICRENDERPARAMETER);
      try {
         String parm1 = "val1";
         Object[] args = { parm1 };
         wc.prepare(tr14, "removePublicRenderParameter", args);
         wpr.removePublicRenderParameter(parm1);
      } catch (Exception e) {
         tr14.appendTcDetail(e.toString());
      }
      tr14.writeTo(writer);

      portletReq.getPortletSession().setAttribute(
            Constants.RESULT_ATTR_PREFIX
                  + "WrapperTests_ActionResponseWrapper_ApiAction",
            writer.toString(), APPLICATION_SCOPE);
   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp)
         throws PortletException, IOException {

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

      PortletSession ps = portletReq.getPortletSession();
      String msg = (String) ps.getAttribute(
            RESULT_ATTR_PREFIX + "WrapperTests_ActionResponseWrapper_ApiAction",
            APPLICATION_SCOPE);
      if (msg != null) {
         writer.write("<p>" + msg + "</p><br/>\n");
         ps.removeAttribute(
               RESULT_ATTR_PREFIX
                     + "WrapperTests_ActionResponseWrapper_ApiAction",
               APPLICATION_SCOPE);
      }

      /*
       * TestCase: V2WrapperTests_ActionResponseWrapper_ApiAction_sendRedirectA
       */
      /* Details: "Method sendRedirect(String): Calls wrapped method" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(
               "V2WrapperTests_ActionResponseWrapper_ApiAction_sendRedirectA",
               aurl);
         tb.writeTo(writer);
      }

      /*
       * TestCase: V2WrapperTests_ActionResponseWrapper_ApiAction_sendRedirectB
       */
      /* Details: "Method sendRedirect(String, String): Calls wrapped */
      /* method" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(
               "V2WrapperTests_ActionResponseWrapper_ApiAction_sendRedirectB",
               aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2WrapperTests_ActionResponseWrapper_ApiAction_setEventA */
      /* Details: "Method setEvent(javax.xml.namespace.QName, */
      /* java.io.Serializable): Calls wrapped method" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(
               "V2WrapperTests_ActionResponseWrapper_ApiAction_setEventA",
               aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2WrapperTests_ActionResponseWrapper_ApiAction_setEventB */
      /* Details: "Method setEvent(String, java.io.Serializable): Calls */
      /* wrapped method" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(
               "V2WrapperTests_ActionResponseWrapper_ApiAction_setEventB",
               aurl);
         tb.writeTo(writer);
      }

      /*
       * TestCase: V2WrapperTests_ActionResponseWrapper_ApiAction_setPortletMode
       */
      /* Details: "Method setPortletMode(PortletMode): Calls wrapped */
      /* method" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(
               "V2WrapperTests_ActionResponseWrapper_ApiAction_setPortletMode",
               aurl);
         tb.writeTo(writer);
      }

      /*
       * TestCase:
       * V2WrapperTests_ActionResponseWrapper_ApiAction_setRenderParameterA
       */
      /* Details: "Method setRenderParameter(String, String): Calls wrapped */
      /* method" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(
               "V2WrapperTests_ActionResponseWrapper_ApiAction_setRenderParameterA",
               aurl);
         tb.writeTo(writer);
      }

      /*
       * TestCase:
       * V2WrapperTests_ActionResponseWrapper_ApiAction_setRenderParameterB
       */
      /* Details: "Method setRenderParameter(String, String[]): Calls */
      /* wrapped method" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(
               "V2WrapperTests_ActionResponseWrapper_ApiAction_setRenderParameterB",
               aurl);
         tb.writeTo(writer);
      }

      /*
       * TestCase:
       * V2WrapperTests_ActionResponseWrapper_ApiAction_setRenderParameters
       */
      /* Details: "Method setRenderParameters(java.util.Map): Calls wrapped */
      /* method" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(
               "V2WrapperTests_ActionResponseWrapper_ApiAction_setRenderParameters",
               aurl);
         tb.writeTo(writer);
      }

      /*
       * TestCase: V2WrapperTests_ActionResponseWrapper_ApiAction_setWindowState
       */
      /* Details: "Method setWindowState(WindowState): Calls wrapped */
      /* method" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(
               "V2WrapperTests_ActionResponseWrapper_ApiAction_setWindowState",
               aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2WrapperTests_ActionResponseWrapper_ApiAction_getResponse */
      /* Details: "Method getResponse(): Returns wrapped ActionResponse */
      /* object" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(
               "V2WrapperTests_ActionResponseWrapper_ApiAction_getResponse",
               aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2WrapperTests_ActionResponseWrapper_ApiAction_setResponse */
      /* Details: "Method setResponse(ActionResponse): Allows wrapped */
      /* ActionResponse object to be set" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(
               "V2WrapperTests_ActionResponseWrapper_ApiAction_setResponse",
               aurl);
         tb.writeTo(writer);
      }

      /*
       * TestCase: V2WrapperTests_ActionResponseWrapper_ApiAction_getPortletMode
       */
      /* Details: "Method getPortletMode(): Calls wrapped method" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(
               "V2WrapperTests_ActionResponseWrapper_ApiAction_getPortletMode",
               aurl);
         tb.writeTo(writer);
      }

      /*
       * TestCase:
       * V2WrapperTests_ActionResponseWrapper_ApiAction_getRenderParameterMap1
       */
      /* Details: "Method getRenderParameterMap(): Calls wrapped method" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(
               "V2WrapperTests_ActionResponseWrapper_ApiAction_getRenderParameterMap1",
               aurl);
         tb.writeTo(writer);
      }

      /*
       * TestCase: V2WrapperTests_ActionResponseWrapper_ApiAction_getWindowState
       */
      /* Details: "Method getWindowState(): Calls wrapped method" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(
               "V2WrapperTests_ActionResponseWrapper_ApiAction_getWindowState",
               aurl);
         tb.writeTo(writer);
      }

      /*
       * TestCase:
       * V2WrapperTests_ActionResponseWrapper_ApiAction_removePublicRenderParameter
       */
      /* Details: "Method removePublicRenderParameter(String): Calls */
      /* wrapped method" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(
               "V2WrapperTests_ActionResponseWrapper_ApiAction_removePublicRenderParameter",
               aurl);
         tb.writeTo(writer);
      }

   }

}
