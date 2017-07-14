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

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Event;
import javax.portlet.EventPortlet;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.tck.beans.ClassChecker;
import javax.portlet.tck.beans.JSR286SignatureTestCaseDetails;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.constants.Constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_EVENTREQUEST_SIGEVENT_HASGETEVENT;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_EVENTREQUEST_SIGEVENT_HASGETEVENTRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_EVENTREQUEST_SIGEVENT_HASGETMETHOD;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_EVENTREQUEST_SIGEVENT_HASGETMETHODRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_EVENTREQUEST_SIGEVENT_IMPLEMENTSPORTLETREQUEST;
import static javax.portlet.PortletSession.APPLICATION_SCOPE;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;
import static javax.portlet.tck.constants.Constants.RESULT_ATTR_PREFIX;

/**
 * This is the event processing portlet for the test cases. This portlet processes events, 
 * but does not publish them. Events are published in the main portlet for the test cases. 
 */
public class SigTestsEvent_EventRequest_SIGEvent_event implements Portlet, EventPortlet {

   private final Logger LOGGER = LoggerFactory.getLogger(SigTestsEvent_EventRequest_SIGEvent_event.class);

   @Override
   public void init(PortletConfig config) throws PortletException {
   }

   @Override
   public void destroy() {
   }

   @Override
   public void processAction(ActionRequest portletReq, ActionResponse portletResp)
         throws PortletException, IOException {
      LOGGER.trace("event companion processAction - ERROR!!");
   }

   @Override
   public void processEvent(EventRequest portletReq, EventResponse portletResp)
         throws PortletException, IOException {


      portletResp.setRenderParameters(portletReq);

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      StringWriter writer = new StringWriter();

      JSR286SignatureTestCaseDetails tcd = new JSR286SignatureTestCaseDetails();

      // Create result objects for the tests

      ClassChecker cc = new ClassChecker(portletReq.getClass());

      /* TestCase: V2SigTestsEvent_EventRequest_SIGEvent_hasGetEvent          */
      /* Details: "EventRequest has a getEvent()  method "                    */
      TestResult tr0 = tcd.getTestResultFailed(V2SIGTESTSEVENT_EVENTREQUEST_SIGEVENT_HASGETEVENT);
      try {
         String name = "getEvent";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr0.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      } catch(Exception e) {tr0.appendTcDetail(e.toString());}
      tr0.writeTo(writer);

      /* TestCase: V2SigTestsEvent_EventRequest_SIGEvent_hasGetEventReturns   */
      /* Details: "EventRequest method getEvent() returns Event "             */
      TestResult tr1 = tcd.getTestResultFailed(V2SIGTESTSEVENT_EVENTREQUEST_SIGEVENT_HASGETEVENTRETURNS);
      try {
         String name = "getEvent";
         Class<?> retType = Event.class;
         Class<?>[] parms = null;
         tr1.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      } catch(Exception e) {tr1.appendTcDetail(e.toString());}
      tr1.writeTo(writer);

      /* TestCase: V2SigTestsEvent_EventRequest_SIGEvent_hasGetMethod         */
      /* Details: "EventRequest has a getMethod()  method "                   */
      TestResult tr2 = tcd.getTestResultFailed(V2SIGTESTSEVENT_EVENTREQUEST_SIGEVENT_HASGETMETHOD);
      try {
         String name = "getMethod";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr2.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      } catch(Exception e) {tr2.appendTcDetail(e.toString());}
      tr2.writeTo(writer);

      /* TestCase: V2SigTestsEvent_EventRequest_SIGEvent_hasGetMethodReturns  */
      /* Details: "EventRequest method getMethod() returns String "           */
      TestResult tr3 = tcd.getTestResultFailed(V2SIGTESTSEVENT_EVENTREQUEST_SIGEVENT_HASGETMETHODRETURNS);
      try {
         String name = "getMethod";
         Class<?> retType = String.class;
         Class<?>[] parms = null;
         tr3.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      } catch(Exception e) {tr3.appendTcDetail(e.toString());}
      tr3.writeTo(writer);

      /* TestCase: V2SigTestsEvent_EventRequest_SIGEvent_implementsPortletRequest */
      /* Details: "EventRequest implements PortletRequest "                   */
      TestResult tr4 = tcd.getTestResultFailed(V2SIGTESTSEVENT_EVENTREQUEST_SIGEVENT_IMPLEMENTSPORTLETREQUEST);
      try {
         tr4.setTcSuccess(cc.implementsInterface(PortletRequest.class));
      } catch(Exception e) {tr4.appendTcDetail(e.toString());}
      tr4.writeTo(writer);

      portletReq.getPortletSession().setAttribute(
                   Constants.RESULT_ATTR_PREFIX + "SigTestsEvent_EventRequest_SIGEvent",
                   writer.toString(), APPLICATION_SCOPE);

   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp)
         throws PortletException, IOException {

      portletResp.setContentType("text/html");
      PrintWriter writer = portletResp.getWriter();
      writer.write("<h3>Event Companion Portlet </h3>\n");
      writer.write("<p>SigTestsEvent_EventRequest_SIGEvent_event</p>\n");

      String msg = (String) portletReq.getPortletSession()
            .getAttribute(RESULT_ATTR_PREFIX + "SigTestsEvent_EventRequest_SIGEvent", APPLICATION_SCOPE);
      msg = (msg==null) ? "Not ready. click test case link." : msg;
      writer.write("<p>" + msg + "</p>\n");

   }

}
