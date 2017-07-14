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
import javax.portlet.EventPortlet;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.tck.beans.JSR286ApiTestCaseDetails;
import javax.portlet.tck.beans.TestResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2FILTERTESTS_EVENTFILTER_APIEVENTFILTER_DOFILTERBLOCK;

/**
 * This is the event processing portlet for the test cases. This portlet processes events, but does
 * not publish them. Events are published in the main portlet for the test cases.
 * 
 * @author ahmed
 */
public class FilterTests_EventFilter_ApiEventFilter_event2 implements Portlet, EventPortlet {

  private final Logger LOGGER = LoggerFactory.getLogger(FilterTests_EventFilter_ApiEventFilter_event2.class);

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
    portletResp.setRenderParameter("tr5", "false");

  }

  @Override
  public void render(RenderRequest portletReq, RenderResponse portletResp)
      throws PortletException, IOException {

    JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

    portletResp.setContentType("text/html");
    PrintWriter writer = portletResp.getWriter();

    /* TestCase: V2FilterTests_EventFilter_ApiEventFilter_doFilterBlock */
    /* Details: "If the doFilter(EventRequest, EventResponse, */
    /* FilterChain): method does not invoke the next filter, processEvent */
    /* is not called" */
    if (portletReq.getParameter("tr5_success") != null
        && portletReq.getParameter("tr5_success").equals("true")) {
      TestResult tr5 =
          tcd.getTestResultFailed(V2FILTERTESTS_EVENTFILTER_APIEVENTFILTER_DOFILTERBLOCK);
      if (portletReq.getParameter("tr5") == null) {
        tr5.setTcSuccess(true);
      } else {
        tr5.appendTcDetail(
            "Failed because processEvent was executed which set the tr5 parameter value to "
                + portletReq.getParameter("tr5"));
      }
      tr5.writeTo(writer);
    }
  }

}
