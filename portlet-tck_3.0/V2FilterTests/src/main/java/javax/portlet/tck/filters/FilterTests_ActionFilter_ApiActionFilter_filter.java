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

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.filter.ActionFilter;
import javax.portlet.filter.FilterChain;
import javax.portlet.filter.FilterConfig;
import javax.portlet.tck.beans.JSR286ApiTestCaseDetails;
import javax.portlet.tck.beans.TestResult;

import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2FILTERTESTS_ACTIONFILTER_APIACTIONFILTER_CANBECONFIGURED1;
import static javax.portlet.tck.constants.Constants.RESULT_ATTR_PREFIX;
import static javax.portlet.PortletSession.APPLICATION_SCOPE;

/**
 * Filter for JSR 362 request dispatcher testing. Used by portlet:
 * FilterTests_ActionFilter_ApiActionFilter
 *
 * @author ahmed
 *
 */
public class FilterTests_ActionFilter_ApiActionFilter_filter implements ActionFilter {
  public static boolean tr4_success = false;

  private FilterConfig filterConfig;

  @Override
  public void init(FilterConfig filterConfig) throws PortletException {
    this.filterConfig = filterConfig;
  }

  @Override
  public void destroy() {}

  @Override
  public void doFilter(ActionRequest portletReq, ActionResponse portletResp, FilterChain chain)
      throws IOException, PortletException {

    StringWriter writer = new StringWriter();

    // now do the tests and write output

    JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

    // Create result objects for the tests

    /* TestCase: V2FilterTests_ActionFilter_ApiActionFilter_canBeConfigured1 */
    /* Details: "An ActionFilter can be configured in the portlet */
    /* descriptor" */
    TestResult tr0 =
        tcd.getTestResultFailed(V2FILTERTESTS_ACTIONFILTER_APIACTIONFILTER_CANBECONFIGURED1);
    String action1 = filterConfig.getFilterName();
    if (action1.equals("FilterTests_ActionFilter_ApiActionFilter_filter")) {
      tr0.setTcSuccess(true);
    }
    tr0.writeTo(writer);

    /* TestCase: V2FilterTests_ActionFilter_ApiActionFilter_doFilterProcessAction2 */
    /* Details: "After the doFilter(ActionRequest, ActionResponse, */
    /* FilterChain): method has sucessfully completed and invokes the */
    /* next filter, the next filter in the chain is called if multiple */
    /* filters are defined" */
    tr4_success = true;

    portletReq.getPortletSession().setAttribute(
        RESULT_ATTR_PREFIX + "FilterTests_ActionFilter_ApiActionFilter",
        writer.toString(), APPLICATION_SCOPE);

    chain.doFilter(portletReq, portletResp);

    /* TestCase: V2FilterTests_ActionFilter_ApiActionFilter_doFilterExamine */
    /* Details: "Method doFilter(ActionRequest, ActionResponse, */
    /* FilterChain): After the next filter has been successfully invoked, */
    /* the ActionResponse may be examined" */
    portletResp.setRenderParameter("tr8", "true");
  }
}
