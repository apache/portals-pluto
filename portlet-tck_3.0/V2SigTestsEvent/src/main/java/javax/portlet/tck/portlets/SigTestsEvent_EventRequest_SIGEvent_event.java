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

import java.io.*;
import java.util.*;
import java.util.logging.*;
import static java.util.logging.Logger.*;
import javax.xml.namespace.QName;
import javax.portlet.*;
import javax.portlet.filter.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.portlet.tck.beans.*;
import javax.portlet.tck.constants.*;
import static javax.portlet.tck.constants.Constants.*;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.*;
import static javax.portlet.PortletSession.*;

/**
 * This is the event processing portlet for the test cases. This portlet processes events, 
 * but does not publish them. Events are published in the main portlet for the test cases. 
 */
public class SigTestsEvent_EventRequest_SIGEvent_event implements Portlet, EventPortlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         SigTestsEvent_EventRequest_SIGEvent_event.class.getName();
   private final Logger LOGGER = Logger.getLogger(LOG_CLASS);
   
   private PortletConfig portletConfig = null;

   @Override
   public void init(PortletConfig config) throws PortletException {
      this.portletConfig = config;
   }

   @Override
   public void destroy() {
   }

   @Override
   public void processAction(ActionRequest portletReq, ActionResponse portletResp)
         throws PortletException, IOException {
      LOGGER.entering(LOG_CLASS, "event companion processAction - ERROR!!");
   }

   @Override
   public void serveResource(ResourceRequest portletReq, ResourceResponse portletResp)
         throws PortletException, IOException {
      LOGGER.entering(LOG_CLASS, "event companion serveResource - ERROR!!");
   }

   @Override
   public void processEvent(EventRequest portletReq, EventResponse portletResp)
         throws PortletException, IOException {
      LOGGER.entering(LOG_CLASS, "event companion processEvent");


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
      
      LOGGER.entering(LOG_CLASS, "event companion render");

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
