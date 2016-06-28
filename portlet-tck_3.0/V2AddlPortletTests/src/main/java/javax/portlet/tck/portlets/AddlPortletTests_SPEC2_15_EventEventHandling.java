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
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.tck.beans.JSR286SpecTestCaseDetails;
import javax.portlet.tck.beans.TestButton;
import javax.portlet.tck.beans.TestResult;
import javax.xml.namespace.QName;

import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENT5;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENT6;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENT7;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENT8;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENT9;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENT10;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENT11;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENT15;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENT16;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENTPROCESSEVENT1;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENTPROCESSEVENT2;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENTPROCESSEVENT3;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENTPROCESSEVENT5;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENTPROCESSEVENT6;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENTPROCESSEVENT9;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;
import static javax.portlet.tck.constants.Constants.TCKNAMESPACE;
import static javax.portlet.tck.constants.Constants.RESULT_ATTR_PREFIX;
import static javax.portlet.PortletSession.APPLICATION_SCOPE;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined
 * in the /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate
 * the test case names defined in the additionalTCs.xml file into the complete list of test case
 * names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will
 * initiate the events, but not process them. The processing is done in the companion portlet
 * AddlPortletTests_SPEC2_15_EventEventHandling_event
 * 
 * @author ahmed
 */
public class AddlPortletTests_SPEC2_15_EventEventHandling implements Portlet, EventPortlet {

  @Override
  public void init(PortletConfig config) throws PortletException {}

  @Override
  public void destroy() {}

  @Override
  public void processAction(ActionRequest portletReq, ActionResponse portletResp)
      throws PortletException, IOException {

    portletResp.setRenderParameters(portletReq.getParameterMap());
    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

    QName eventQName = new QName(TCKNAMESPACE, "AddlPortletTests_SPEC2_15_EventEventHandling");
    portletResp.setEvent(eventQName, "Hi!");

    V2AddlPortletTests_SPEC2_15_EventEventHandling_eventData eventData =
        new V2AddlPortletTests_SPEC2_15_EventEventHandling_eventData();
    eventData.setTr14("true");
    QName eventQName_serializableData =
        new QName(TCKNAMESPACE, "AddlPortletTests_SPEC2_15_EventEventHandling_serializableData");
    portletResp.setEvent(eventQName_serializableData, eventData);

    portletResp.setEvent("AddlPortletTests_SPEC2_15_EventEventHandling_empty", null);

    QName eventQName_exceptionEvent =
        new QName(TCKNAMESPACE, "AddlPortletTests_SPEC2_15_EventEventHandling_exceptionEvent");
    portletResp.setEvent(eventQName_exceptionEvent, "Hi!");

    if (!AddlPortletTests_SPEC2_15_EventEventHandling_event.tr8) {
      QName eventQName_unavailableExceptionEvent = new QName(TCKNAMESPACE,
          "AddlPortletTests_SPEC2_15_EventEventHandling_unavailableExceptionEvent");
      portletResp.setEvent(eventQName_unavailableExceptionEvent, "Hi!");
    }

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

    if (qName.equals("AddlPortletTests_SPEC2_15_EventEventHandling")) {
      /* TestCase: V2AddlPortletTests_SPEC2_15_EventEventHandling_eventProcessEvent9 */
      /* Details: "The portlet can publish multiple events via the setEvent */
      /* method in the processEvent method" */
      TestResult tr17 = tcd
          .getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENTPROCESSEVENT9);
      tr17.setTcSuccess(true);
      tr17.writeTo(writer);
    } else if (qName.equals("AddlPortletTests_SPEC2_15_EventEventHandling_eventEvent")) {
      /* TestCase: V2AddlPortletTests_SPEC2_15_EventEventHandling_eventProcessEvent1 */
      /* Details: "The portlet can publish an event via the setEvent method */
      /* in the processEvent method" */
      TestResult tr9 = tcd
          .getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENTPROCESSEVENT1);
      tr9.setTcSuccess(true);
      tr9.writeTo(writer);
    }

    String msg = (String) portletReq.getPortletSession().getAttribute(
        RESULT_ATTR_PREFIX + "AddlPortletTests_SPEC2_15_EventEventHandling", APPLICATION_SCOPE);
    msg = msg + writer.toString();
    portletReq.getPortletSession().setAttribute(
        RESULT_ATTR_PREFIX + "AddlPortletTests_SPEC2_15_EventEventHandling", msg,
        APPLICATION_SCOPE);
  }

  @Override
  public void render(RenderRequest portletReq, RenderResponse portletResp)
      throws PortletException, IOException {

    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

    PrintWriter writer = portletResp.getWriter();

    /* TestCase: V2AddlPortletTests_SPEC2_15_EventEventHandling_event5 */
    /* Details: "The portlet can use the EventRequest.getEvent method to */
    /* obtain an Event object encapsulating the event name and value" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENT5, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2AddlPortletTests_SPEC2_15_EventEventHandling_event6 */
    /* Details: "The Event object must always have the name field set" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENT6, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2AddlPortletTests_SPEC2_15_EventEventHandling_event7 */
    /* Details: "If the Event object has a value set when the event is */
    /* published, the value must be based on the value defined in the */
    /* deployment descriptor" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENT7, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2AddlPortletTests_SPEC2_15_EventEventHandling_event8 */
    /* Details: "If the Event object has a value set when the event is */
    /* published, the value must be available from the Event object in */
    /* the processEvent method" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENT8, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2AddlPortletTests_SPEC2_15_EventEventHandling_event9 */
    /* Details: "If the Event object does not have a value set when the */
    /* event is published, the Event object available in the processEvent */
    /* method must not have a value" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENT9, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2AddlPortletTests_SPEC2_15_EventEventHandling_event10 */
    /* Details: "The Event Qname object representing the name can be */
    /* retrieved through the Event getQname method" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENT10, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2AddlPortletTests_SPEC2_15_EventEventHandling_event11 */
    /* Details: "The local part of the Event Qname object representing */
    /* the name can be retrieved through the Event getName method" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENT11, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2AddlPortletTests_SPEC2_15_EventEventHandling_event15 */
    /* Details: "If a portlet throws an exception in the processEvent */
    /* method, all operations on the EventResponse must be ignored" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENT15, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2AddlPortletTests_SPEC2_15_EventEventHandling_event16 */
    /* Details: "If a portlet throws a permanent UnavailableException */
    /* during event processing, the portlet container must remove the */
    /* portlet from service immediately, call the portlet's destroy */
    /* method, and release the portlet object" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENT16, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2AddlPortletTests_SPEC2_15_EventEventHandling_eventProcessEvent1 */
    /* Details: "The portlet can publish an event via the setEvent method */
    /* in the processEvent method" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENTPROCESSEVENT1, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2AddlPortletTests_SPEC2_15_EventEventHandling_eventProcessEvent2 */
    /* Details: "The portlet can publish an event with its full Qname via */
    /* the setEvent method in the processAction method" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENTPROCESSEVENT2, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2AddlPortletTests_SPEC2_15_EventEventHandling_eventProcessEvent3 */
    /* Details: "The portlet can publish an event with only the local */
    /* part of the Qname via the setEvent method in the processAction */
    /* method" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENTPROCESSEVENT3, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2AddlPortletTests_SPEC2_15_EventEventHandling_eventProcessEvent5 */
    /* Details: "If an event is published with only the local part of the */
    /* Qname and no default namespace is defined in the deployment */
    /* descriptor, the value javax.xml.XMLConstants.NULL_NS_URI must be */
    /* used as the Qname namespace" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENTPROCESSEVENT5, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2AddlPortletTests_SPEC2_15_EventEventHandling_eventProcessEvent6 */
    /* Details: "If an object is serializeable and has a valid JAXB */
    /* binding or is a Java primitive type, it can be used as an event */
    /* value" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENTPROCESSEVENT6, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2AddlPortletTests_SPEC2_15_EventEventHandling_eventProcessEvent9 */
    /* Details: "The portlet can publish multiple events via the setEvent */
    /* method in the processEvent method" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENTPROCESSEVENT9, aurl);
      tb.writeTo(writer);
    }

  }

}
