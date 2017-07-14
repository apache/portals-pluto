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
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.beans.TestSetupLink;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLREQUESTTESTS_SPEC2_11_EVENT_PARAMETERS12;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;
import static javax.portlet.tck.constants.Constants.RESULT_ATTR_PREFIX;
import static javax.portlet.PortletSession.APPLICATION_SCOPE;

/**
 * This is the event processing portlet for the test cases. This portlet processes events, but does
 * not publish them. Events are published in the main portlet for the test cases.
 * 
 * @author ahmed
 */
public class AddlRequestTests_SPEC2_11_Event_event implements Portlet, EventPortlet {

  private final Logger LOGGER = LoggerFactory.getLogger(AddlRequestTests_SPEC2_11_Event_event.class);

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

    // Create result objects for the tests

    /* TestCase: V2AddlRequestTests_SPEC2_11_Event_parameters12 */
    /* Details: "If a portlet receives an event that is the result of a */
    /* client request targeted to another portlet in the portal page, the */
    /* parameters should be the same parameters as of the previous render */
    /* request from this client" */
    TestResult tr3 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_EVENT_PARAMETERS12);
    if (portletReq.getParameter("tr3") != null && portletReq.getParameter("tr3").equals("true")) {
      tr3.setTcSuccess(true);
    }
    tr3.writeTo(writer);

    portletReq.getPortletSession().setAttribute(
        RESULT_ATTR_PREFIX + "AddlRequestTests_SPEC2_11_Event_event", writer.toString(),
        APPLICATION_SCOPE);

  }

  @Override
  public void render(RenderRequest portletReq, RenderResponse portletResp)
      throws PortletException, IOException {

    portletResp.setContentType("text/html");
    PrintWriter writer = portletResp.getWriter();
    writer.write("<h3>Event Companion Portlet </h3>\n");
    writer.write("<p>AddlRequestTests_SPEC2_11_Event_event</p>\n");

    /* TestCase: V2AddlRequestTests_SPEC2_11_Event_parameters12 */
    /* Details: "If a portlet receives an event that is the result of a */
    /* client request targeted to another portlet in the portal page, the */
    /* parameters should be the same parameters as of the previous render */
    /* request from this client" */
    if (portletReq.getParameter("tr3") == null) {
      PortletURL rurl = portletResp.createRenderURL();
      rurl.setParameters(portletReq.getPrivateParameterMap());
      rurl.setParameter("tr3", "true");
      TestSetupLink tb = new TestSetupLink(V2ADDLREQUESTTESTS_SPEC2_11_EVENT_PARAMETERS12, rurl);
      tb.writeTo(writer);
    }

    String msg = (String) portletReq.getPortletSession()
        .getAttribute(RESULT_ATTR_PREFIX + "AddlRequestTests_SPEC2_11_Event", APPLICATION_SCOPE)
        + (String) portletReq.getPortletSession().getAttribute(
            RESULT_ATTR_PREFIX + "AddlRequestTests_SPEC2_11_Event_event", APPLICATION_SCOPE);
    msg = (msg.equals("nullnull")) ? "Not ready. click test case link." : msg;
    writer.write("<p>" + msg + "</p>\n");

  }

}
