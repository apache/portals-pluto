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

import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_EVENTRESPONSEWRAPPER_APIEVENT_SETEVENTA;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_EVENTRESPONSEWRAPPER_APIEVENT_SETEVENTB;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_EVENTRESPONSEWRAPPER_APIEVENT_SETPORTLETMODE;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_EVENTRESPONSEWRAPPER_APIEVENT_SETRENDERPARAMETERA;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_EVENTRESPONSEWRAPPER_APIEVENT_SETRENDERPARAMETERB;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_EVENTRESPONSEWRAPPER_APIEVENT_SETRENDERPARAMETERSA;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_EVENTRESPONSEWRAPPER_APIEVENT_SETRENDERPARAMETERSB;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_EVENTRESPONSEWRAPPER_APIEVENT_SETWINDOWSTATE;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_EVENTRESPONSEWRAPPER_APIEVENT_GETRESPONSE;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_EVENTRESPONSEWRAPPER_APIEVENT_SETRESPONSE;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_EVENTRESPONSEWRAPPER_APIEVENT_GETPORTLETMODE;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_EVENTRESPONSEWRAPPER_APIEVENT_GETRENDERPARAMETERMAP1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_EVENTRESPONSEWRAPPER_APIEVENT_GETWINDOWSTATE;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_EVENTRESPONSEWRAPPER_APIEVENT_REMOVEPUBLICRENDERPARAMETER;
import static javax.portlet.PortletSession.APPLICATION_SCOPE;
import static javax.portlet.tck.constants.Constants.RESULT_ATTR_PREFIX;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;

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
import javax.portlet.PortletMode;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;
import javax.portlet.filter.EventResponseWrapper;
import javax.portlet.tck.beans.EventResponseWrapperChecker;
import javax.portlet.tck.beans.JSR286ApiTestCaseDetails;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.constants.Constants;

/**
 * This is the event processing portlet for the test cases. This portlet
 * processes events, but does not publish them. Events are published in the main
 * portlet for the test cases.
 */
public class WrapperTests_EventResponseWrapper_ApiEvent_event
      implements Portlet, EventPortlet {

   @Override
   public void init(PortletConfig config) throws PortletException {
   }

   @Override
   public void destroy() {
   }

   @Override
   public void processAction(ActionRequest portletReq,
         ActionResponse portletResp) throws PortletException, IOException {
   }

   @Override
   public void processEvent(EventRequest portletReq, EventResponse portletResp)
         throws PortletException, IOException {

      portletResp.setRenderParameters(portletReq);

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      StringWriter writer = new StringWriter();

      EventResponseWrapperChecker wc = new EventResponseWrapperChecker(
            portletResp);
      EventResponseWrapper wpr = new EventResponseWrapper(portletResp);
      wpr.setResponse(wc);
      JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

      // Create result objects for the tests

      /* TestCase: V2WrapperTests_EventResponseWrapper_ApiEvent_setEventA */
      /* Details: "Method setEvent(javax.xml.namespace.QName, */
      /* java.io.Serializable): Calls wrapped method" */
      TestResult tr0 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_EVENTRESPONSEWRAPPER_APIEVENT_SETEVENTA);
      try {
         javax.xml.namespace.QName parm1 = new javax.xml.namespace.QName("bob");
         String parm2 = "val2";
         Object[] args = { parm1, parm2 };
         wc.prepare(tr0, "setEvent", args);
         wpr.setEvent(parm1, parm2);
      } catch (Exception e) {
         tr0.appendTcDetail(e.toString());
      }
      tr0.writeTo(writer);

      /* TestCase: V2WrapperTests_EventResponseWrapper_ApiEvent_setEventB */
      /* Details: "Method setEvent(String, java.io.Serializable): Calls */
      /* wrapped method" */
      TestResult tr1 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_EVENTRESPONSEWRAPPER_APIEVENT_SETEVENTB);
      try {
         String parm1 = "val1";
         String parm2 = "val2";
         Object[] args = { parm1, parm2 };
         wc.prepare(tr1, "setEvent", args);
         wpr.setEvent(parm1, parm2);
      } catch (Exception e) {
         tr1.appendTcDetail(e.toString());
      }
      tr1.writeTo(writer);

      /*
       * TestCase: V2WrapperTests_EventResponseWrapper_ApiEvent_setPortletMode
       */
      /* Details: "Method setPortletMode(PortletMode): Calls wrapped */
      /* method" */
      TestResult tr2 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_EVENTRESPONSEWRAPPER_APIEVENT_SETPORTLETMODE);
      try {
         PortletMode parm1 = PortletMode.EDIT;
         Object[] args = { parm1 };
         wc.prepare(tr2, "setPortletMode", args);
         wpr.setPortletMode(parm1);
      } catch (Exception e) {
         tr2.appendTcDetail(e.toString());
      }
      tr2.writeTo(writer);

      /*
       * TestCase:
       * V2WrapperTests_EventResponseWrapper_ApiEvent_setRenderParameterA
       */
      /* Details: "Method setRenderParameter(String, String): Calls wrapped */
      /* method" */
      TestResult tr3 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_EVENTRESPONSEWRAPPER_APIEVENT_SETRENDERPARAMETERA);
      try {
         String parm1 = "val1";
         String parm2 = "val2";
         Object[] args = { parm1, parm2 };
         wc.prepare(tr3, "setRenderParameter", args);
         wpr.setRenderParameter(parm1, parm2);
      } catch (Exception e) {
         tr3.appendTcDetail(e.toString());
      }
      tr3.writeTo(writer);

      /*
       * TestCase:
       * V2WrapperTests_EventResponseWrapper_ApiEvent_setRenderParameterB
       */
      /* Details: "Method setRenderParameter(String, String[]): Calls */
      /* wrapped method" */
      TestResult tr4 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_EVENTRESPONSEWRAPPER_APIEVENT_SETRENDERPARAMETERB);
      try {
         String parm1 = "val1";
         String[] parm2 = { "val1", "val2" };
         Object[] args = { parm1, parm2 };
         wc.prepare(tr4, "setRenderParameter", args);
         wpr.setRenderParameter(parm1, parm2);
      } catch (Exception e) {
         tr4.appendTcDetail(e.toString());
      }
      tr4.writeTo(writer);

      /*
       * TestCase:
       * V2WrapperTests_EventResponseWrapper_ApiEvent_setRenderParametersA
       */
      /* Details: "Method setRenderParameters(EventRequest): Calls wrapped */
      /* method" */
      TestResult tr5 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_EVENTRESPONSEWRAPPER_APIEVENT_SETRENDERPARAMETERSA);
      try {
         EventRequest parm1 = portletReq;
         Object[] args = { parm1 };
         wc.prepare(tr5, "setRenderParameters", args);
         wpr.setRenderParameters(parm1);
      } catch (Exception e) {
         tr5.appendTcDetail(e.toString());
      }
      tr5.writeTo(writer);

      /*
       * TestCase:
       * V2WrapperTests_EventResponseWrapper_ApiEvent_setRenderParametersB
       */
      /* Details: "Method setRenderParameters(EventRequest): Calls wrapped */
      /* method" */
      TestResult tr6 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_EVENTRESPONSEWRAPPER_APIEVENT_SETRENDERPARAMETERSB);
      try {
         EventRequest parm1 = portletReq;
         Object[] args = { parm1 };
         wc.prepare(tr6, "setRenderParameters", args);
         wpr.setRenderParameters(parm1);
      } catch (Exception e) {
         tr6.appendTcDetail(e.toString());
      }
      tr6.writeTo(writer);

      /*
       * TestCase: V2WrapperTests_EventResponseWrapper_ApiEvent_setWindowState
       */
      /* Details: "Method setWindowState(WindowState): Calls wrapped */
      /* method" */
      TestResult tr7 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_EVENTRESPONSEWRAPPER_APIEVENT_SETWINDOWSTATE);
      try {
         WindowState parm1 = WindowState.NORMAL;
         Object[] args = { parm1 };
         wc.prepare(tr7, "setWindowState", args);
         wpr.setWindowState(parm1);
      } catch (Exception e) {
         tr7.appendTcDetail(e.toString());
      }
      tr7.writeTo(writer);

      /* TestCase: V2WrapperTests_EventResponseWrapper_ApiEvent_getResponse */
      /* Details: "Method getResponse(): Returns wrapped EventResponse */
      /* object" */
      TestResult tr8 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_EVENTRESPONSEWRAPPER_APIEVENT_GETRESPONSE);
      try {
         // The retrieved request / response object should be the wrapper
         // checker instance
         EventResponse r = wpr.getResponse();
         tr8.setTcSuccess(r == wc);
      } catch (Exception e) {
         tr8.appendTcDetail(e.toString());
      }
      tr8.writeTo(writer);

      /* TestCase: V2WrapperTests_EventResponseWrapper_ApiEvent_setResponse */
      /* Details: "Method setResponse(EventResponse): Allows wrapped */
      /* EventResponse object to be set" */
      TestResult tr9 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_EVENTRESPONSEWRAPPER_APIEVENT_SETRESPONSE);
      try {
         // tested by method set up
         tr9.setTcSuccess(true);
      } catch (Exception e) {
         tr9.appendTcDetail(e.toString());
      }
      tr9.writeTo(writer);

      /*
       * TestCase: V2WrapperTests_EventResponseWrapper_ApiEvent_getPortletMode
       */
      /* Details: "Method getPortletMode(): Calls wrapped method" */
      TestResult tr10 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_EVENTRESPONSEWRAPPER_APIEVENT_GETPORTLETMODE);
      try {
         Object[] args = {};
         wc.prepare(tr10, "getPortletMode", args);
         wc.checkRetval(wpr.getPortletMode());
      } catch (Exception e) {
         tr10.appendTcDetail(e.toString());
      }
      tr10.writeTo(writer);

      /*
       * TestCase:
       * V2WrapperTests_EventResponseWrapper_ApiEvent_getRenderParameterMap1
       */
      /* Details: "Method getRenderParameterMap(): Calls wrapped method" */
      TestResult tr11 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_EVENTRESPONSEWRAPPER_APIEVENT_GETRENDERPARAMETERMAP1);
      try {
         Object[] args = {};
         wc.prepare(tr11, "getRenderParameterMap", args);
         wc.checkRetval(wpr.getRenderParameterMap());
      } catch (Exception e) {
         tr11.appendTcDetail(e.toString());
      }
      tr11.writeTo(writer);

      /*
       * TestCase: V2WrapperTests_EventResponseWrapper_ApiEvent_getWindowState
       */
      /* Details: "Method getWindowState(): Calls wrapped method" */
      TestResult tr12 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_EVENTRESPONSEWRAPPER_APIEVENT_GETWINDOWSTATE);
      try {
         Object[] args = {};
         wc.prepare(tr12, "getWindowState", args);
         wc.checkRetval(wpr.getWindowState());
      } catch (Exception e) {
         tr12.appendTcDetail(e.toString());
      }
      tr12.writeTo(writer);

      /*
       * TestCase:
       * V2WrapperTests_EventResponseWrapper_ApiEvent_removePublicRenderParameter
       */
      /* Details: "Method removePublicRenderParameter(String): Calls */
      /* wrapped method" */
      TestResult tr13 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_EVENTRESPONSEWRAPPER_APIEVENT_REMOVEPUBLICRENDERPARAMETER);
      try {
         String parm1 = "val1";
         Object[] args = { parm1 };
         wc.prepare(tr13, "removePublicRenderParameter", args);
         wpr.removePublicRenderParameter(parm1);
      } catch (Exception e) {
         tr13.appendTcDetail(e.toString());
      }
      tr13.writeTo(writer);

      portletReq.getPortletSession().setAttribute(
            Constants.RESULT_ATTR_PREFIX
                  + "WrapperTests_EventResponseWrapper_ApiEvent",
            writer.toString(), APPLICATION_SCOPE);

   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp)
         throws PortletException, IOException {

      portletResp.setContentType("text/html");
      PrintWriter writer = portletResp.getWriter();
      writer.write("<h3>Event Companion Portlet </h3>\n");
      writer.write("<p>WrapperTests_EventResponseWrapper_ApiEvent_event</p>\n");

      String msg = (String) portletReq.getPortletSession().getAttribute(
            RESULT_ATTR_PREFIX + "WrapperTests_EventResponseWrapper_ApiEvent",
            APPLICATION_SCOPE);
      msg = (msg == null) ? "Not ready. click test case link." : msg;
      writer.write("<p>" + msg + "</p>\n");

   }

}
