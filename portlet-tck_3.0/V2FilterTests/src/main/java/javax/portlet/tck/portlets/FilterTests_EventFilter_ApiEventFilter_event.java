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
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.tck.beans.JSR286ApiTestCaseDetails;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.constants.Constants;
import javax.portlet.tck.filters.FilterTests_EventFilter_ApiEventFilter_filter2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2FILTERTESTS_EVENTFILTER_APIEVENTFILTER_DOFILTERISCALLED;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2FILTERTESTS_EVENTFILTER_APIEVENTFILTER_DOFILTERPROCESSEVENT1;
import static javax.portlet.tck.constants.Constants.RESULT_ATTR_PREFIX;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;
import static javax.portlet.PortletSession.APPLICATION_SCOPE;


/**
 * This is the event processing portlet for the test cases. This portlet processes events, but does
 * not publish them. Events are published in the main portlet for the test cases.
 */
public class FilterTests_EventFilter_ApiEventFilter_event implements Portlet, EventPortlet {

  private final Logger LOGGER = LoggerFactory.getLogger(FilterTests_EventFilter_ApiEventFilter_event.class);

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

    JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

    portletResp.setRenderParameters(portletReq);

    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

    StringWriter writer = new StringWriter();

    /* TestCase: V2FilterTests_EventFilter_ApiEventFilter_doFilterIsCalled */
    /* Details: "The doFilter(EventRequest, EventResponse, FilterChain): */
    /* method is called before the processEvent method for the portlet" */
    TestResult tr2 =
        tcd.getTestResultFailed(V2FILTERTESTS_EVENTFILTER_APIEVENTFILTER_DOFILTERISCALLED);
    if (FilterTests_EventFilter_ApiEventFilter_filter2.tr2_success) {
      tr2.setTcSuccess(true);
    }
    tr2.writeTo(writer);

    /* TestCase: V2FilterTests_EventFilter_ApiEventFilter_doFilterProcessEvent1 */
    /* Details: "After the doFilter(EventRequest, EventResponse, */
    /* FilterChain): method has sucessfully completed and invokes the */
    /* next filter, the processEventMethod is called" */
    TestResult tr3 =
        tcd.getTestResultFailed(V2FILTERTESTS_EVENTFILTER_APIEVENTFILTER_DOFILTERPROCESSEVENT1);
    if (FilterTests_EventFilter_ApiEventFilter_filter2.tr3_success) {
      tr3.setTcSuccess(true);
    }
    tr3.writeTo(writer);

    PortletSession ps = portletReq.getPortletSession();
    String msg =
        (String) ps.getAttribute(RESULT_ATTR_PREFIX + "FilterTests_EventFilter_ApiEventFilter",
            APPLICATION_SCOPE);
    portletReq.getPortletSession().setAttribute(
        Constants.RESULT_ATTR_PREFIX + "FilterTests_EventFilter_ApiEventFilter",
        msg + writer.toString(), APPLICATION_SCOPE);

  }

  @Override
  public void render(RenderRequest portletReq, RenderResponse portletResp)
      throws PortletException, IOException {

    JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

    portletResp.setContentType("text/html");
    PrintWriter writer = portletResp.getWriter();
    writer.write("<h3>Event Companion Portlet </h3>\n");
    writer.write("<p>FilterTests_EventFilter_ApiEventFilter_event</p>\n");

    String msg = (String) portletReq.getPortletSession().getAttribute(
        RESULT_ATTR_PREFIX + "FilterTests_EventFilter_ApiEventFilter", APPLICATION_SCOPE);
    msg = (msg == null) ? "Not ready. click test case link." : msg;
    writer.write("<p>" + msg + "</p>\n");

    if (portletReq.getParameter("tr8") != null && portletReq.getParameter("tr8").equals("true")) {
      TestResult tr8 =
          tcd.getTestResultFailed("V2FilterTests_EventFilter_ApiEventFilter_doFilterExamine");
      tr8.setTcSuccess(true);
      tr8.writeTo(writer);
    }

  }

}
