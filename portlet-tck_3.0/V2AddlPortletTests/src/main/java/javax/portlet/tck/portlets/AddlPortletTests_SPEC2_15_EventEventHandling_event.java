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
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.tck.beans.JSR286SpecTestCaseDetails;
import javax.portlet.tck.beans.TestResult;
import javax.xml.namespace.QName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENT9;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENTPROCESSEVENT3;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENTPROCESSEVENT5;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENTPROCESSEVENT6;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENT5;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENT6;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENT7;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENT8;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENT10;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENT11;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENTPROCESSEVENT2;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENT15;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENT16;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;
import static javax.portlet.tck.constants.Constants.RESULT_ATTR_PREFIX;
import static javax.portlet.tck.constants.Constants.TCKNAMESPACE;
import static javax.portlet.PortletSession.APPLICATION_SCOPE;
import static javax.xml.XMLConstants.NULL_NS_URI;

/**
 * This is the event processing portlet for the test cases. This portlet processes events, but does
 * not publish them. Events are published in the main portlet for the test cases.
 * 
 * @author ahmed
 */
public class AddlPortletTests_SPEC2_15_EventEventHandling_event implements Portlet, EventPortlet {

  private final Logger LOGGER = LoggerFactory.getLogger(AddlPortletTests_SPEC2_15_EventEventHandling_event.class);

  public static boolean tr8 = false;

  @Override
  public void init(PortletConfig config) throws PortletException {}

  @Override
  public void destroy() {}

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

    JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();
    Event event = portletReq.getEvent();
    String qName = event.getName();
    if (LOGGER.isTraceEnabled()) {
      LOGGER.trace("Event name is {}", event.getQName().getNamespaceURI());
    }
    if (qName.equals("AddlPortletTests_SPEC2_15_EventEventHandling_empty")) {
      /* TestCase: V2AddlPortletTests_SPEC2_15_EventEventHandling_event9 */
      /* Details: "If the Event object does not have a value set when the */
      /* event is published, the Event object available in the processEvent */
      /* method must not have a value" */
      TestResult tr4 =
          tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENT9);
      if (event.getValue() == null) {
        tr4.setTcSuccess(true);
      } else {
        tr4.appendTcDetail("Failed because event value is not null");
      }
      tr4.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_15_EventEventHandling_eventProcessEvent3 */
      /* Details: "The portlet can publish an event with only the local */
      /* part of the Qname via the setEvent method in the processAction */
      /* method" */
      TestResult tr11 = tcd
          .getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENTPROCESSEVENT3);
      // This event is sent using the localpart of the QName. So, if control reaches here then test
      // is passed
      tr11.setTcSuccess(true);
      tr11.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_15_EventEventHandling_eventProcessEvent5 */
      /* Details: "If an event is published with only the local part of the */
      /* Qname and no default namespace is defined in the deployment */
      /* descriptor, the value javax.xml.XMLConstants.NULL_NS_URI must be */
      /* used as the Qname namespace" */
      TestResult tr13 = tcd
          .getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENTPROCESSEVENT5);
      if (event.getQName().getNamespaceURI().equals(NULL_NS_URI)) {
        tr13.setTcSuccess(true);
      } else {
        tr13.appendTcDetail("Failure because Qname namespace is not equal to \"" + NULL_NS_URI
            + "\" but \"" + event.getQName().getNamespaceURI() + "\"");
      }
      tr13.writeTo(writer);
    } else if (qName.equals("AddlPortletTests_SPEC2_15_EventEventHandling_serializableData")) {
      /* TestCase: V2AddlPortletTests_SPEC2_15_EventEventHandling_eventProcessEvent6 */
      /* Details: "If an object is serializeable and has a valid JAXB */
      /* binding or is a Java primitive type, it can be used as an event */
      /* value" */
      TestResult tr14 = tcd
          .getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENTPROCESSEVENT6);
      V2AddlPortletTests_SPEC2_15_EventEventHandling_eventData eventData =
          (V2AddlPortletTests_SPEC2_15_EventEventHandling_eventData) event.getValue();
      if (eventData.getTr14().equals("true")) {
        tr14.setTcSuccess(true);
      } else {
        tr14.appendTcDetail("Failed because Event data tr14 is not true.");
      }
      tr14.writeTo(writer);
    } else if (qName.equals("AddlPortletTests_SPEC2_15_EventEventHandling_exceptionEvent")) {
      /* TestCase: V2AddlPortletTests_SPEC2_15_EventEventHandling_event15 */
      /* Details: "If a portlet throws an exception in the processEvent */
      /* method, all operations on the EventResponse must be ignored" */
      portletResp.setRenderParameter("tr7", "true");
      portletReq.getPortletSession().setAttribute(
          RESULT_ATTR_PREFIX + "AddlPortletTests_SPEC2_15_EventEventHandling_exception", "true",
          APPLICATION_SCOPE);
      throw new PortletException(
          "Exception from V2AddlPortletTests_SPEC2_15_EventEventHandling_event15");
    } else if (qName.equals("AddlPortletTests_SPEC2_15_EventEventHandling")) {
      // Create result objects for the tests

      /* TestCase: V2AddlPortletTests_SPEC2_15_EventEventHandling_event5 */
      /* Details: "The portlet can use the EventRequest.getEvent method to */
      /* obtain an Event object encapsulating the event name and value" */
      TestResult tr0 =
          tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENT5);
      if (event != null) {
        tr0.setTcSuccess(true);
      }
      tr0.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_15_EventEventHandling_event6 */
      /* Details: "The Event object must always have the name field set" */
      TestResult tr1 =
          tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENT6);
      if (event.getName() != null) {
        tr1.setTcSuccess(true);
      } else {
        tr1.appendTcDetail("Failed because event name is null.");
      }
      tr1.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_15_EventEventHandling_event7 */
      /* Details: "If the Event object has a value set when the event is */
      /* published, the value must be based on the value defined in the */
      /* deployment descriptor" */
      TestResult tr2 =
          tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENT7);
      if (event.getValue() instanceof java.lang.String) {
        tr2.setTcSuccess(true);
      } else {
        tr2.appendTcDetail(
            "Failed because value's Class is not \"java.lang.String\" as defined in deployment descriptor");
      }
      tr2.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_15_EventEventHandling_event8 */
      /* Details: "If the Event object has a value set when the event is */
      /* published, the value must be available from the Event object in */
      /* the processEvent method" */
      TestResult tr3 =
          tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENT8);
      if (event.getValue().equals("Hi!")) {
        tr3.setTcSuccess(true);
      } else {
        tr3.appendTcDetail("Value of event is not \"Hi!\" but: " + event.getValue());
      }
      tr3.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_15_EventEventHandling_event10 */
      /* Details: "The Event Qname object representing the name can be */
      /* retrieved through the Event getQname method" */
      TestResult tr5 =
          tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENT10);
      QName eventQName = new QName(TCKNAMESPACE, "AddlPortletTests_SPEC2_15_EventEventHandling");
      if (event.getQName().equals(eventQName)) {
        tr5.setTcSuccess(true);
      } else {
        tr5.appendTcDetail("Failed because event QName is not equal to " + eventQName.toString());
      }
      tr5.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_15_EventEventHandling_event11 */
      /* Details: "The local part of the Event Qname object representing */
      /* the name can be retrieved through the Event getName method" */
      TestResult tr6 =
          tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENT11);
      if (event.getName().equals("AddlPortletTests_SPEC2_15_EventEventHandling")) {
        tr6.setTcSuccess(true);
      } else {
        tr6.appendTcDetail(
            "Failed because local part of Event Qname is not \"AddlPortletTests_SPEC2_15_EventEventHandling\" but "
                + event.getName());
      }
      tr6.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_15_EventEventHandling_eventProcessEvent1 */
      /* Details: "The portlet can publish an event via the setEvent method */
      /* in the processEvent method" */
      QName eventQName_eventEvent =
          new QName(TCKNAMESPACE, "AddlPortletTests_SPEC2_15_EventEventHandling_eventEvent");
      portletResp.setEvent(eventQName_eventEvent, "Hi!");

      /* TestCase: V2AddlPortletTests_SPEC2_15_EventEventHandling_eventProcessEvent2 */
      /* Details: "The portlet can publish an event with its full Qname via */
      /* the setEvent method in the processAction method" */
      TestResult tr10 = tcd
          .getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENTPROCESSEVENT2);
      // This event is sent via full Qname. So, if control reaches here then event is published
      tr10.setTcSuccess(true);
      tr10.writeTo(writer);

    }
    String msg = (String) portletReq.getPortletSession().getAttribute(
        RESULT_ATTR_PREFIX + "AddlPortletTests_SPEC2_15_EventEventHandling_event",
        APPLICATION_SCOPE);
    msg = msg + writer.toString();
    portletReq.getPortletSession().setAttribute(
        RESULT_ATTR_PREFIX + "AddlPortletTests_SPEC2_15_EventEventHandling_event", msg,
        APPLICATION_SCOPE);
  }

  @Override
  public void render(RenderRequest portletReq, RenderResponse portletResp)
      throws PortletException, IOException {

    JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();

    portletResp.setContentType("text/html");
    PrintWriter writer = portletResp.getWriter();
    writer.write("<h3>Event Companion Portlet </h3>\n");
    writer.write("<p>AddlPortletTests_SPEC2_15_EventEventHandling_event</p>\n");

    String msg = (String) portletReq.getPortletSession().getAttribute(
        RESULT_ATTR_PREFIX + "AddlPortletTests_SPEC2_15_EventEventHandling_event",
        APPLICATION_SCOPE)
        + (String) portletReq.getPortletSession().getAttribute(
            RESULT_ATTR_PREFIX + "AddlPortletTests_SPEC2_15_EventEventHandling", APPLICATION_SCOPE);
    msg = (msg.equals("nullnull")) ? "Not ready. click test case link." : msg;

    portletReq.getPortletSession().setAttribute(
        RESULT_ATTR_PREFIX + "AddlPortletTests_SPEC2_15_EventEventHandling_event", null,
        APPLICATION_SCOPE);
    portletReq.getPortletSession().setAttribute(
        RESULT_ATTR_PREFIX + "AddlPortletTests_SPEC2_15_EventEventHandling", null,
        APPLICATION_SCOPE);

    /* TestCase: V2AddlPortletTests_SPEC2_15_EventEventHandling_event15 */
    /* Details: "If a portlet throws an exception in the processEvent */
    /* method, all operations on the EventResponse must be ignored" */
    TestResult tr7 =
        tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENT15);
    String dataInEventResponse = (String) portletReq.getPortletSession().getAttribute(
        RESULT_ATTR_PREFIX + "AddlPortletTests_SPEC2_15_EventEventHandling_exception",
        APPLICATION_SCOPE);
    if (dataInEventResponse != null && dataInEventResponse.equals("true")
        && portletReq.getParameter("tr7") == null) {
      tr7.setTcSuccess(true);
    } else {
      tr7.appendTcDetail("Failed because data is set in EventResponse: " + dataInEventResponse);
    }
    msg = msg + tr7.toString();

    /* TestCase: V2AddlPortletTests_SPEC2_15_EventEventHandling_event16 */
    /* Details: "If a portlet throws a permanent UnavailableException */
    /* during event processing, the portlet container must remove the */
    /* portlet from service immediately, call the portlet's destroy */
    /* method, and release the portlet object" */
    TestResult tr8 =
        tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENT16);
    if (AddlPortletTests_SPEC2_15_EventEventHandling_event.tr8) {
      tr8.setTcSuccess(true);
    } else {
      tr8.appendTcDetail(
          "Failed because AddlPortletTests_SPEC2_15_EventEventHandling_unavailableException not destroyed");
    }
    msg = msg + tr8.toString();

    writer.write("<p>" + msg + "</p>\n");
  }

}
