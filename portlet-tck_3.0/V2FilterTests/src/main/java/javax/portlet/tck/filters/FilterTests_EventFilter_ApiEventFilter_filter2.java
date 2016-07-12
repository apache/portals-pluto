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


package javax.portlet.tck.filters;

import java.io.IOException;
import java.io.StringWriter;

import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.filter.EventFilter;
import javax.portlet.filter.FilterChain;
import javax.portlet.filter.FilterConfig;
import javax.portlet.tck.beans.JSR286ApiTestCaseDetails;
import javax.portlet.tck.beans.TestResult;

import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2FILTERTESTS_EVENTFILTER_APIEVENTFILTER_CANBECONFIGURED2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2FILTERTESTS_EVENTFILTER_APIEVENTFILTER_DOFILTERPROCESSEVENT2;
import static javax.portlet.tck.constants.Constants.RESULT_ATTR_PREFIX;
import static javax.portlet.PortletSession.APPLICATION_SCOPE;

/**
 * Filter for JSR 362 request dispatcher testing. Used by portlet:
 * FilterTests_EventFilter_ApiEventFilter
 *
 * @author ahmed
 *
 */
public class FilterTests_EventFilter_ApiEventFilter_filter2 implements EventFilter {
  public static boolean tr2_success = false;
  public static boolean tr3_success = false;


  @Override
  public void init(FilterConfig filterConfig) throws PortletException {}

  @Override
  public void destroy() {}

  @Override
  public void doFilter(EventRequest portletReq, EventResponse portletResp, FilterChain chain)
      throws IOException, PortletException {

    StringWriter writer = new StringWriter();

    JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();


    /* TestCase: V2FilterTests_EventFilter_ApiEventFilter_canBeConfigured2 */
    /* Details: "Multiple EventFilter classes can be configured in the */
    /* portlet descriptor" */
    TestResult tr1 =
        tcd.getTestResultFailed(V2FILTERTESTS_EVENTFILTER_APIEVENTFILTER_CANBECONFIGURED2);
    tr1.setTcSuccess(true);
    tr1.writeTo(writer);

    /* TestCase: V2FilterTests_EventFilter_ApiEventFilter_doFilterIsCalled */
    /* Details: "The doFilter(EventRequest, EventResponse, FilterChain): */
    /* method is called before the processEvent method for the portlet" */
    tr2_success = true;

    /* TestCase: V2FilterTests_EventFilter_ApiEventFilter_doFilterProcessEvent1 */
    /* Details: "After the doFilter(EventRequest, EventResponse, */
    /* FilterChain): method has sucessfully completed and invokes the */
    /* next filter, the processEventMethod is called" */
    tr3_success = true;

    /* TestCase: V2FilterTests_EventFilter_ApiEventFilter_doFilterProcessEvent2 */
    /* Details: "After the doFilter(EventRequest, EventResponse, */
    /* FilterChain): method has sucessfully completed and invokes the */
    /* next filter, the next filter in the chain is called if multiple */
    /* filters are defined" */
    TestResult tr4 =
        tcd.getTestResultFailed(V2FILTERTESTS_EVENTFILTER_APIEVENTFILTER_DOFILTERPROCESSEVENT2);
    if (FilterTests_EventFilter_ApiEventFilter_filter.tr4_success) {
      tr4.setTcSuccess(true);
    }
    tr4.writeTo(writer);

    PortletSession ps = portletReq.getPortletSession();
    String msg =
        (String) ps.getAttribute(RESULT_ATTR_PREFIX + "FilterTests_EventFilter_ApiEventFilter",
            APPLICATION_SCOPE);
    portletReq.getPortletSession().setAttribute(
        RESULT_ATTR_PREFIX + "FilterTests_EventFilter_ApiEventFilter", msg + writer.toString(),
        APPLICATION_SCOPE);

    chain.doFilter(portletReq, portletResp);

  }
}
