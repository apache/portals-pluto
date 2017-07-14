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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_5_EVENTHANDLING_EXCEPTION4;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_5_EVENTHANDLING_EXCEPTION5;

import static javax.portlet.tck.constants.Constants.THREADID_ATTR;
import static javax.portlet.tck.constants.Constants.RESULT_ATTR_PREFIX;
import static javax.portlet.PortletSession.APPLICATION_SCOPE;

/**
 * This is the event processing portlet for the test cases. This portlet processes events, but does
 * not publish them. Events are published in the main portlet for the test cases.
 * 
 * @author ahmed
 */
public class AddlPortletTests_SPEC2_5_EventHandling_event implements Portlet, EventPortlet {

  private final Logger LOGGER = LoggerFactory.getLogger(AddlPortletTests_SPEC2_5_EventHandling_event.class);

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

    Event event = portletReq.getEvent();
    String qName = event.getName();
    if (qName.equals("AddlPortletTests_SPEC2_5_EventHandling_exception4")) {
      /* TestCase: V2AddlPortletTests_SPEC2_5_EventHandling_exception4 */
      /* Details: "If the portlet throws an PortletException in */
      /* processEvent, all operations on the EventResponse, including set */
      /* events, must be ignored" */
      portletResp.setRenderParameter("tr0", "true");
      portletReq.getPortletSession().setAttribute(
          RESULT_ATTR_PREFIX + "AddlPortletTests_SPEC2_5_EventHandling_portletException", "true",
          APPLICATION_SCOPE);
      throw new PortletException(
          "PortletException from V2AddlPortletTests_SPEC2_5_EventHandling_exception4");
    } else if (qName.equals("AddlPortletTests_SPEC2_5_EventHandling_exception5")) {
      /* TestCase: V2AddlPortletTests_SPEC2_5_EventHandling_exception5 */
      /* Details: "If the portlet throws a RuntimeException in */
      /* processEvent, all operations on the EventResponse, including set */
      /* events, must be ignored" */
      portletResp.setRenderParameter("tr1", "true");
      portletReq.getPortletSession().setAttribute(
          RESULT_ATTR_PREFIX + "AddlPortletTests_SPEC2_5_EventHandling_runtimeException", "true",
          APPLICATION_SCOPE);
      throw new RuntimeException(
          "RuntimeException from V2AddlPortletTests_SPEC2_5_EventHandling_exception5");
    }

  }

  @Override
  public void render(RenderRequest portletReq, RenderResponse portletResp)
      throws PortletException, IOException {
    
    JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();
    portletResp.setContentType("text/html");
    PrintWriter writer = portletResp.getWriter();
    writer.write("<h3>Event Companion Portlet </h3>\n");
    writer.write("<p>AddlPortletTests_SPEC2_5_EventHandling_event</p>\n");


    /* TestCase: V2AddlPortletTests_SPEC2_5_EventHandling_exception4 */
    /* Details: "If the portlet throws an PortletException in */
    /* processEvent, all operations on the EventResponse, including set */
    /* events, must be ignored" */
    TestResult tr0 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_5_EVENTHANDLING_EXCEPTION4);
    String dataInEventResponse_tr0 = (String) portletReq.getPortletSession().getAttribute(
        RESULT_ATTR_PREFIX + "AddlPortletTests_SPEC2_5_EventHandling_portletException",
        APPLICATION_SCOPE);
    if (dataInEventResponse_tr0 != null && dataInEventResponse_tr0.equals("true")
        && portletReq.getParameter("tr0") == null) {
      tr0.setTcSuccess(true);
    } else {
      tr0.appendTcDetail("Failed because data is set in EventResponse: " + dataInEventResponse_tr0);
    }
    String msg = tr0.toString();

    /* TestCase: V2AddlPortletTests_SPEC2_5_EventHandling_exception5 */
    /* Details: "If the portlet throws a RuntimeException in */
    /* processEvent, all operations on the EventResponse, including set */
    /* events, must be ignored" */
    TestResult tr1 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_5_EVENTHANDLING_EXCEPTION5);
    String dataInEventResponse_tr1 = (String) portletReq.getPortletSession().getAttribute(
        RESULT_ATTR_PREFIX + "AddlPortletTests_SPEC2_5_EventHandling_runtimeException",
        APPLICATION_SCOPE);
    if (dataInEventResponse_tr1 != null && dataInEventResponse_tr1.equals("true")
        && portletReq.getParameter("tr1") == null) {
      tr1.setTcSuccess(true);
    } else {
      tr1.appendTcDetail("Failed because data is set in EventResponse: " + dataInEventResponse_tr1);
    }
    msg = msg + tr1.toString();

    writer.write("<p>" + msg + "</p>\n");

  }

}
