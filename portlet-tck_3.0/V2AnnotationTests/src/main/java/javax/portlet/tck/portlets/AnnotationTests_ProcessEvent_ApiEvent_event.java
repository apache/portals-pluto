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
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ANNOTATIONTESTS_PROCESSEVENT_APIEVENT_NAME;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ANNOTATIONTESTS_PROCESSEVENT_APIEVENT_QNAME;
import static javax.portlet.tck.constants.Constants.RESULT_ATTR_PREFIX;
import static javax.portlet.tck.constants.Constants.TCKNAMESPACE;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessEvent;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.tck.beans.JSR286ApiTestCaseDetails;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.constants.Constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This is the event processing portlet for the test cases. This portlet processes events, but does
 * not publish them. Events are published in the main portlet for the test cases.
 */
public class AnnotationTests_ProcessEvent_ApiEvent_event extends GenericPortlet {

  private final Logger LOGGER = LoggerFactory.getLogger(AnnotationTests_ProcessEvent_ApiEvent_event.class);

  @Override
  public void processAction(ActionRequest portletReq, ActionResponse portletResp)
      throws PortletException, IOException {
    LOGGER.trace("event companion processAction - ERROR!!");
  }

  @Override
  public void serveResource(ResourceRequest portletReq, ResourceResponse portletResp)
      throws PortletException, IOException {
    LOGGER.trace("event companion serveResource - ERROR!!");
  }


  @Override
  public void processEvent(EventRequest request, EventResponse response)
      throws PortletException, IOException {

    if (LOGGER.isTraceEnabled()) {
      StringBuilder txt = new StringBuilder(128);
      txt.append("Event arrived.");
      txt.append(" Name: ").append(request.getEvent().getName());
      txt.append(", QName: ").append(request.getEvent().getQName());
      LOGGER.trace(txt.toString());
    }

    super.processEvent(request, response);
  }


  @ProcessEvent(qname = "{" + TCKNAMESPACE + "}AnnotationTests_ProcessEvent_ApiEvent")
  public void handleEvnt(EventRequest req, EventResponse resp)
      throws PortletException, IOException {

    StringWriter writer = new StringWriter();

    JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

    /* TestCase: V2AnnotationTests_ProcessEvent_ApiEvent_qname */
    /* Details: "Method qname(): On an event request, the method is */
    /* executed if the Event qname matches the qname field" */
    TestResult tr0 = tcd.getTestResultFailed(V2ANNOTATIONTESTS_PROCESSEVENT_APIEVENT_QNAME);
    tr0.setTcSuccess(true);
    tr0.writeTo(writer);
    req.getPortletSession().setAttribute(
        Constants.RESULT_ATTR_PREFIX + "AnnotationTests_ProcessEvent_ApiEvent", writer.toString(),
        APPLICATION_SCOPE);

    LOGGER.trace("Resulting String: {}", writer);
  }

  @ProcessEvent(name = "AnnotationTests_ProcessEvent_ApiEvent2")
  public void nameEvnt(EventRequest req, EventResponse resp) throws PortletException, IOException {
    StringWriter writer = new StringWriter();

    JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();
    /* TestCase: V2AnnotationTests_ProcessEvent_ApiEvent_name */
    /* Details: "Method name(): On an event request, the method is */
    /* executed if the Event name matches the name field" */
    TestResult tr1 = tcd.getTestResultFailed(V2ANNOTATIONTESTS_PROCESSEVENT_APIEVENT_NAME);
    tr1.setTcSuccess(true);
    tr1.writeTo(writer);
    req.getPortletSession().setAttribute(
        Constants.RESULT_ATTR_PREFIX + "AnnotationTests_ProcessEvent_ApiEvent", writer.toString(),
        APPLICATION_SCOPE);

  }

  @Override
  public void render(RenderRequest portletReq, RenderResponse portletResp)
      throws PortletException, IOException {

    portletResp.setContentType("text/html");
    PrintWriter writer = portletResp.getWriter();
    writer.write("<h3>Event Companion Portlet </h3>\n");
    writer.write("<p>AnnotationTests_ProcessEvent_ApiEvent_event</p>\n");

    String msg = (String) portletReq.getPortletSession().getAttribute(
        RESULT_ATTR_PREFIX + "AnnotationTests_ProcessEvent_ApiEvent", APPLICATION_SCOPE);
    msg = (msg == null) ? "Not ready. click test case link." : msg;
    writer.write("<p>" + msg + "</p>\n");

  }

}
