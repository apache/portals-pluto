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

import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_EVENTREQUESTWRAPPER_APIEVENT_GETREQUEST;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_EVENTREQUESTWRAPPER_APIEVENT_SETREQUEST;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_EVENTREQUESTWRAPPER_APIEVENT_GETEVENT1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_EVENTREQUESTWRAPPER_APIEVENT_GETMETHOD;
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
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.filter.EventRequestWrapper;
import javax.portlet.tck.beans.EventRequestWrapperChecker;
import javax.portlet.tck.beans.JSR286ApiTestCaseDetails;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.constants.Constants;

/**
 * This is the event processing portlet for the test cases. This portlet
 * processes events, but does not publish them. Events are published in the main
 * portlet for the test cases.
 */
public class WrapperTests_EventRequestWrapper_ApiEvent_event
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

      EventRequestWrapperChecker wc = new EventRequestWrapperChecker(
            portletReq);
      EventRequestWrapper wpr = new EventRequestWrapper(portletReq);
      wpr.setRequest(wc);
      JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

      // Create result objects for the tests

      /* TestCase: V2WrapperTests_EventRequestWrapper_ApiEvent_getRequest */
      /* Details: "Method getRequest(): Returns wrapped EventRequest */
      /* object" */
      TestResult tr0 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_EVENTREQUESTWRAPPER_APIEVENT_GETREQUEST);
      try {
         // The retrieved request / response object should be the wrapper
         // checker instance
         EventRequest r = wpr.getRequest();
         tr0.setTcSuccess(r == wc);
      } catch (Exception e) {
         tr0.appendTcDetail(e.toString());
      }
      tr0.writeTo(writer);

      /* TestCase: V2WrapperTests_EventRequestWrapper_ApiEvent_setRequest */
      /* Details: "Method setRequest(EventRequest): Allows wrapped */
      /* EventRequest object to be set" */
      TestResult tr1 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_EVENTREQUESTWRAPPER_APIEVENT_SETREQUEST);
      try {
         // tested by method set up
         tr1.setTcSuccess(true);
      } catch (Exception e) {
         tr1.appendTcDetail(e.toString());
      }
      tr1.writeTo(writer);

      /* TestCase: V2WrapperTests_EventRequestWrapper_ApiEvent_getEvent1 */
      /* Details: "Method getEvent(): Calls wrapped method" */
      TestResult tr2 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_EVENTREQUESTWRAPPER_APIEVENT_GETEVENT1);
      try {
         Object[] args = {};
         wc.prepare(tr2, "getEvent", args);
         wc.checkRetval(wpr.getEvent());
      } catch (Exception e) {
         tr2.appendTcDetail(e.toString());
      }
      tr2.writeTo(writer);

      /* TestCase: V2WrapperTests_EventRequestWrapper_ApiEvent_getMethod */
      /* Details: "Method getMethod(): Calls wrapped method" */
      TestResult tr3 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_EVENTREQUESTWRAPPER_APIEVENT_GETMETHOD);
      try {
         Object[] args = {};
         wc.prepare(tr3, "getMethod", args);
         wc.checkRetval(wpr.getMethod());
      } catch (Exception e) {
         tr3.appendTcDetail(e.toString());
      }
      tr3.writeTo(writer);

      portletReq.getPortletSession().setAttribute(
            Constants.RESULT_ATTR_PREFIX
                  + "WrapperTests_EventRequestWrapper_ApiEvent",
            writer.toString(), APPLICATION_SCOPE);

   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp)
         throws PortletException, IOException {

      portletResp.setContentType("text/html");
      PrintWriter writer = portletResp.getWriter();
      writer.write("<h3>Event Companion Portlet </h3>\n");
      writer.write("<p>WrapperTests_EventRequestWrapper_ApiEvent_event</p>\n");

      String msg = (String) portletReq.getPortletSession().getAttribute(
            RESULT_ATTR_PREFIX + "WrapperTests_EventRequestWrapper_ApiEvent",
            APPLICATION_SCOPE);
      msg = (msg == null) ? "Not ready. click test case link." : msg;
      writer.write("<p>" + msg + "</p>\n");

   }

}
