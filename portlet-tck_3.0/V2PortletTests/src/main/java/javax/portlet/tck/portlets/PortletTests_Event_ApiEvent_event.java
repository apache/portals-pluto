/*
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license
 * agreements. See the NOTICE file distributed with this work for additional information regarding
 * copyright ownership. The ASF licenses this file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License. You may obtain a
 * copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package javax.portlet.tck.portlets;

import static javax.portlet.PortletSession.APPLICATION_SCOPE;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2PORTLETTESTS_EVENT_APIEVENT_GETNAME1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2PORTLETTESTS_EVENT_APIEVENT_GETNAME2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2PORTLETTESTS_EVENT_APIEVENT_GETQNAME1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2PORTLETTESTS_EVENT_APIEVENT_GETQNAME2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2PORTLETTESTS_EVENT_APIEVENT_GETVALUE1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2PORTLETTESTS_EVENT_APIEVENT_GETVALUE2;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENTPROCESSEVENT4;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG_GETPROCESSINGEVENTQNAMES3;
import static javax.portlet.tck.constants.Constants.RESULT_ATTR_PREFIX;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.util.Enumeration;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Event;
import javax.portlet.EventPortlet;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.tck.beans.JSR286ApiTestCaseDetails;
import javax.portlet.tck.beans.JSR286SpecTestCaseDetails;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.constants.Constants;
import javax.xml.namespace.QName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This is the event processing portlet for the test cases. This portlet
 * processes events, but does not publish them. Events are published in the main
 * portlet for the test cases.
 */
public class PortletTests_Event_ApiEvent_event
      implements Portlet, EventPortlet {

   private final Logger  LOGGER        = LoggerFactory.getLogger(PortletTests_Event_ApiEvent_event.class);
   private PortletConfig portletConfig = null;

   @Override
   public void init(PortletConfig config) throws PortletException {
      this.portletConfig = config;
   }

   @Override
   public void destroy() {
   }

   @Override
   public void processAction(ActionRequest portletReq,
         ActionResponse portletResp) throws PortletException, IOException {
      LOGGER.trace("event companion processAction - ERROR!!");
   }

   @Override
   public void processEvent(EventRequest portletReq, EventResponse portletResp)
         throws PortletException, IOException {

      portletResp.setRenderParameters(portletReq);

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      StringWriter writer = new StringWriter();

      JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();
      JSR286SpecTestCaseDetails tcd_spec = new JSR286SpecTestCaseDetails();

      // Create result objects for the tests

      Event evt = portletReq.getEvent();
      String eventName = evt.getName();
      if (eventName.equals("PortletTests_Event_ApiEvent_localPart")) {
         /*
          * TestCase:
          * V2AddlPortletTests_SPEC2_15_EventEventHandling_eventProcessEvent4
          */
         /*
          * Details: "If an event is published with only the local part of the
          */
         /* Qname, the namespace must be the default namespace defined in the */
         /* deployment descriptor" */
         TestResult tr12 = tcd_spec.getTestResultFailed(
               V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENTPROCESSEVENT4);
         if (evt.getQName().getNamespaceURI()
               .equals("https://www.apache.org")) {
            tr12.setTcSuccess(true);
         } else {
            tr12.appendTcDetail(
                  "Failed because default namespace is not \"https://www.apache.org\"");
         }
         tr12.writeTo(writer);
      } else if (eventName.equals("PortletTests_Event_ApiEvent")) {
         /* TestCase: V2PortletTests_Event_ApiEvent_getQName1 */
         /*
          * Details: "Method getQName(): Returns the javax.xml.namespace.QName
          */
         /* object for the Event" */
         TestResult tr0 = tcd
               .getTestResultSucceeded(V2PORTLETTESTS_EVENT_APIEVENT_GETQNAME1);
         QName qn = evt.getQName();
         QName xmlqn = new QName(
               "http://www.apache.org/portals/pluto/portlet-tck_3.0",
               "PortletTests_Event_ApiEvent");
         if (qn == null) {
            tr0.appendTcDetail("QName is null.");
         } else if (!qn.equals(xmlqn)) {
            StringBuilder txt = new StringBuilder(128);
            txt.append("QName is not expected value.");
            txt.append(" Expected: ").append(xmlqn);
            txt.append(" Actual: ").append(qn);
            tr0.appendTcDetail(txt.toString());
         }
         tr0.writeTo(writer);

         /* TestCase: V2PortletTests_Event_ApiEvent_getQName2 */
         /* Details: "Method getQName(): Returned value may not be null" */
         TestResult tr1 = tcd
               .getTestResultSucceeded(V2PORTLETTESTS_EVENT_APIEVENT_GETQNAME2);
         QName qn1 = evt.getQName();
         StringBuilder txt1 = new StringBuilder(128);
         txt1.append(qn1);
         if (qn1 == null) {
            tr1.appendTcDetail("QName is null.");
            tr1.appendTcDetail(txt1.toString());
         }
         tr1.writeTo(writer);

         /* TestCase: V2PortletTests_Event_ApiEvent_getName1 */
         /* Details: "Method getName(): Returns a String containing the event */
         /* local name" */
         TestResult tr2 = tcd
               .getTestResultSucceeded(V2PORTLETTESTS_EVENT_APIEVENT_GETNAME1);
         String qn2 = evt.getName();
         String evtname = "PortletTests_Event_ApiEvent";
         if (qn2 == null) {
            tr2.appendTcDetail("Local Part of Event name is Null.");
         } else if (!qn2.equals(evtname)) {
            StringBuilder txt2 = new StringBuilder(128);
            txt2.append("EventName is not expected value.");
            txt2.append(" Expected: ").append(evtname);
            txt2.append(" Actual: ").append(qn2);
            tr2.appendTcDetail(txt2.toString());
         }
         tr2.writeTo(writer);

         /* TestCase: V2PortletTests_Event_ApiEvent_getName2 */
         /* Details: "Method getName(): Returned value may not be null" */
         TestResult tr3 = tcd
               .getTestResultSucceeded(V2PORTLETTESTS_EVENT_APIEVENT_GETNAME2);
         if (qn2 == null) {
            tr3.appendTcDetail("Event name is Null.");
         }
         tr3.writeTo(writer);

         /* TestCase: V2PortletTests_Event_ApiEvent_getValue1 */
         /* Details: "Method getValue(String, String): Returns a */
         /* java.io.Serializable object representing the event payload" */
         TestResult tr4 = tcd
               .getTestResultFailed(V2PORTLETTESTS_EVENT_APIEVENT_GETVALUE1);
         try {
            Object val = evt.getValue();
            if (val == null) {
               tr4.appendTcDetail("EventPayload is null");
            }
            if ((val instanceof String)) {
               String txt4 = (String) val;
               if (txt4.equals("Hi")) {
                  tr4.setTcSuccess(true);
               } else {
                  tr4.appendTcDetail(
                        "The EventPayloadvalue did not match actual value :"
                              + txt4);
               }
            }
         } catch (Exception e) {
            tr4.appendTcDetail(e.toString());
         }
         tr4.writeTo(writer);

      } else if (eventName.equals("PortletTests_Event_ApiEvent2")) {

         /* TestCase: V2PortletTests_Event_ApiEvent_getValue2 */
         /* Details: "Method getValue(String, String): Returned value is null */
         /* if the event has no payload" */
         TestResult tr5 = tcd
               .getTestResultFailed(V2PORTLETTESTS_EVENT_APIEVENT_GETVALUE2);
         Serializable val1 = evt.getValue();
         if (val1 == null) {
            tr5.setTcSuccess(true);
         } else {
            tr5.appendTcDetail("EventPayload has a value:" + val1.toString());
         }
         tr5.writeTo(writer);
      }

      String msg = (String) portletReq.getPortletSession().getAttribute(
            RESULT_ATTR_PREFIX + "PortletTests_Event_ApiEvent",
            APPLICATION_SCOPE);
      msg = msg + writer.toString();
      portletReq.getPortletSession().setAttribute(
            Constants.RESULT_ATTR_PREFIX + "PortletTests_Event_ApiEvent", msg,
            APPLICATION_SCOPE);
   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp)
         throws PortletException, IOException {

      JSR286SpecTestCaseDetails tcd_spec = new JSR286SpecTestCaseDetails();
      portletResp.setContentType("text/html");
      PrintWriter writer = portletResp.getWriter();
      writer.write("<h3>Event Companion Portlet </h3>\n");
      writer.write("<p>PortletTests_Event_ApiEvent_event</p>\n");

      String msg = (String) portletReq.getPortletSession().getAttribute(
            RESULT_ATTR_PREFIX + "PortletTests_Event_ApiEvent",
            APPLICATION_SCOPE);
      portletReq.getPortletSession().removeAttribute(
            RESULT_ATTR_PREFIX + "PortletTests_Event_ApiEvent",
            APPLICATION_SCOPE);
      msg = (msg == null) ? "Not ready. click test case link." : msg;
      writer.write("<p>" + msg + "</p>\n");

      /*
       * TestCase:
       * V2AddlPortletTests_SPEC2_6_RenderConfig_getProcessingEventQnames3
       */
      /* Details: "getProcessingEventQnames - If the event was defined */
      /* using the &lt;name&gt; element rather than the &lt;qname&gt; */
      /* element, default namespace defined with the */
      /* &lt;default-namespace&gt; element must be added as the event */
      /* namespace" */
      TestResult tr6 = tcd_spec.getTestResultFailed(
            V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG_GETPROCESSINGEVENTQNAMES3);
      Enumeration<QName> processingEvents = portletConfig
            .getProcessingEventQNames();
      while (processingEvents.hasMoreElements()) {
         QName qName = processingEvents.nextElement();
         if (qName.getNamespaceURI().equals("https://www.apache.org")) {
            tr6.setTcSuccess(true);
            break;
         }
      }
      tr6.writeTo(writer);

   }

}
