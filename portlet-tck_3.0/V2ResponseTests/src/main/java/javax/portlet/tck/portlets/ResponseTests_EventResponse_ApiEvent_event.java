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

import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_EVENTRESPONSE_APIEVENT_SETRENDERPARAMETERS1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2RESPONSETESTS_EVENTRESPONSE_APIEVENT_SETRENDERPARAMETERS2;
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
import javax.portlet.tck.beans.JSR286ApiTestCaseDetails;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.constants.Constants;

/**
 * This is the event processing portlet for the test cases. This portlet
 * processes events, but does not publish them. Events are published in the main
 * portlet for the test cases.
 */
public class ResponseTests_EventResponse_ApiEvent_event
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

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      StringWriter writer = new StringWriter();

      JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

      // Create result objects for the tests

      /*
       * TestCase: V2ResponseTests_EventResponse_ApiEvent_setRenderParameters1
       */
      /* Details: "Method setRenderParameters(EventRequest): Copies all */
      /* render parameters set on the EventRequest to the EventResponse" */
      TestResult tr0 = tcd.getTestResultFailed(
            V2RESPONSETESTS_EVENTRESPONSE_APIEVENT_SETRENDERPARAMETERS1);
      try {
         try {
            portletResp.setRenderParameters(portletReq);
            tr0.setTcSuccess(true);
         } catch (IllegalArgumentException iae) {
            tr0.appendTcDetail(iae.toString());
         } catch (Exception e) {
            tr0.appendTcDetail(e.toString());
         }
      } catch (Exception e) {
         tr0.appendTcDetail(e.toString());
      }
      tr0.writeTo(writer);

      /*
       * TestCase: V2ResponseTests_EventResponse_ApiEvent_setRenderParameters2
       */
      /* Details: "Method setRenderParameters(EventRequest): Throws */
      /* IllegalArgumentException if the input EventRequest parameter is */
      /* null" */
      TestResult tr1 = tcd.getTestResultFailed(
            V2RESPONSETESTS_EVENTRESPONSE_APIEVENT_SETRENDERPARAMETERS2);
      try {
         try {
            portletResp.setRenderParameters((EventRequest) null);
            tr1.appendTcDetail("Method did not throw an exception.");
         } catch (IllegalArgumentException iae) {
            tr1.setTcSuccess(true);
         } catch (Exception e) {
            tr1.appendTcDetail(e.toString());
         }
      } catch (Exception e) {
         tr1.appendTcDetail(e.toString());
      }
      tr1.writeTo(writer);

      portletReq.getPortletSession().setAttribute(
            Constants.RESULT_ATTR_PREFIX
                  + "ResponseTests_EventResponse_ApiEvent",
            writer.toString(), APPLICATION_SCOPE);

   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp)
         throws PortletException, IOException {

      portletResp.setContentType("text/html");
      PrintWriter writer = portletResp.getWriter();
      writer.write("<h3>Event Companion Portlet </h3>\n");
      writer.write("<p>ResponseTests_EventResponse_ApiEvent_event</p>\n");

      String msg = (String) portletReq.getPortletSession().getAttribute(
            RESULT_ATTR_PREFIX + "ResponseTests_EventResponse_ApiEvent",
            APPLICATION_SCOPE);
      msg = (msg == null) ? "Not ready. click test case link." : msg;
      writer.write("<p>" + msg + "</p>\n");

   }

}
