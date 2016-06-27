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
import javax.portlet.filter.EventFilter;
import javax.portlet.filter.FilterChain;
import javax.portlet.filter.FilterConfig;
import javax.portlet.tck.beans.JSR286ApiTestCaseDetails;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.constants.Constants;

import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2FILTERTESTS_PORTLETFILTER_APIEVENTFILTER_INITEVENT1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2FILTERTESTS_PORTLETFILTER_APIEVENTFILTER_INITEVENT2;
import static javax.portlet.PortletSession.APPLICATION_SCOPE;

/**
 * Filter for JSR 362 request dispatcher testing. Used by portlet:
 * FilterTests_PortletFilter_ApiEventFilter
 *
 * @author nick
 *
 */
public class FilterTests_PortletFilter_ApiEventFilter_filter implements EventFilter {

  private FilterConfig filterConfig = null;
  private boolean initCalled = false;

  @Override
  public void init(FilterConfig filterConfig) throws PortletException {
    this.filterConfig = filterConfig;
    initCalled = true;
  }

  @Override
  public void destroy() {}

  @Override
  public void doFilter(EventRequest portletReq, EventResponse portletResp, FilterChain chain)
      throws IOException, PortletException {

    StringWriter writer = new StringWriter();

    JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

    /* TestCase: V2FilterTests_PortletFilter_ApiEventFilter_initEvent1 */
    /* Details: "The init(FilterConfig): method is called when an */
    /* EventFilter is configured" */
    TestResult tr0 = tcd.getTestResultFailed(V2FILTERTESTS_PORTLETFILTER_APIEVENTFILTER_INITEVENT1);
    if (initCalled == true) {
      tr0.setTcSuccess(true);
    }
    tr0.writeTo(writer);

    /* TestCase: V2FilterTests_PortletFilter_ApiEventFilter_initEvent2 */
    /* Details: "The init(FilterConfig): method for an EventFilter is */
    /* passed a FilterConfig object" */
    TestResult tr1 = tcd.getTestResultFailed(V2FILTERTESTS_PORTLETFILTER_APIEVENTFILTER_INITEVENT2);
    if (this.filterConfig != null) {
      tr1.setTcSuccess(true);
    }
    tr1.writeTo(writer);

    portletReq.getPortletSession().setAttribute(
        Constants.RESULT_ATTR_PREFIX + "FilterTests_PortletFilter_ApiEventFilter",
        writer.toString(), APPLICATION_SCOPE);

    chain.doFilter(portletReq, portletResp);

  }
}
