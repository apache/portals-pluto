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
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessEvent;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.tck.beans.JSR286SpecTestCaseDetails;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.constants.Constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static javax.portlet.PortletSession.APPLICATION_SCOPE;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_5_RENDERGENERICPORTLET_EVENTDISPATCHING1;
import static javax.portlet.tck.constants.Constants.RESULT_ATTR_PREFIX;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined
 * in the /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate
 * the test case names defined in the additionalTCs.xml file into the complete list of test case
 * names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will
 * initiate the events, but not process them. The processing is done in the companion portlet
 * AddlPortletTests_SPEC2_5_RenderGenericPortlet_event
 * @author ahmed
 */
public class AddlPortletTests_SPEC2_5_RenderGenericPortlet_event extends GenericPortlet {

  private final Logger LOGGER = LoggerFactory.getLogger(AddlPortletTests_SPEC2_5_RenderGenericPortlet_event.class);

  @Override
  public void processAction(ActionRequest portletReq, ActionResponse portletResp)
      throws PortletException, IOException {
    LOGGER.trace("event companion processAction - ERROR!!");
  }

  @ProcessEvent(qname = "AddlPortletTests_SPEC2_5_RenderGenericPortlet")
  public void processEvent(EventRequest portletReq, EventResponse portletResp)
      throws PortletException, IOException {
    JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();

    /* TestCase: V2AddlPortletTests_SPEC2_5_RenderGenericPortlet_eventDispatching1 */
    /* Details: "The GenericPortlet processEvent method will dispatch the */
    /* request to a subclass method annotated with the tag */
    /* @ProcessEvent(qname=&lt;eventname&gt;), where &lt;eventname&gt; */
    /* must be in the format provided by Qname.toString()" */

    Event event = portletReq.getEvent();
    String qName = event.getName();
    TestResult tr1 =
        tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_5_RENDERGENERICPORTLET_EVENTDISPATCHING1);
    if (qName.toString().equals("AddlPortletTests_SPEC2_5_RenderGenericPortlet")) {
      tr1.setTcSuccess(true);
    } else {
      tr1.appendTcDetail(
          "Failed because QName is not AddlPortletTests_SPEC2_5_RenderGenericPortlet");
    }
    portletReq.getPortletSession().setAttribute(
        Constants.RESULT_ATTR_PREFIX + "AddlPortletTests_SPEC2_5_RenderGenericPortlet_event_a",
        tr1.toString(), APPLICATION_SCOPE);
  }

  @Override
  public void render(RenderRequest portletReq, RenderResponse portletResp)
      throws PortletException, IOException {

    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

    portletResp.setContentType("text/html");
    PrintWriter writer = portletResp.getWriter();
    writer.write("<h3>Event Companion Portlet </h3>\n");
    writer.write("<p>AddlPortletTests_SPEC2_5_RenderGenericPortlet_event</p>\n");

    String msg = (String) portletReq.getPortletSession().getAttribute(
        RESULT_ATTR_PREFIX + "AddlPortletTests_SPEC2_5_RenderGenericPortlet",
        APPLICATION_SCOPE)
        + (String) portletReq.getPortletSession().getAttribute(
            RESULT_ATTR_PREFIX + "AddlPortletTests_SPEC2_5_RenderGenericPortlet_event_a",
            APPLICATION_SCOPE)
        + (String) portletReq.getPortletSession().getAttribute(
            RESULT_ATTR_PREFIX + "AddlPortletTests_SPEC2_5_RenderGenericPortlet_event_b",
            APPLICATION_SCOPE);
    msg = (msg.equals("nullnullnull")) ? "Not ready. click test case link." : msg;
    writer.write("<p>" + msg + "</p>\n");
  }

}
