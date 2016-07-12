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
import java.io.PrintWriter;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.filter.FilterChain;
import javax.portlet.filter.FilterConfig;
import javax.portlet.filter.RenderFilter;
import javax.portlet.tck.beans.JSR286ApiTestCaseDetails;
import javax.portlet.tck.beans.TestResult;

import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2FILTERTESTS_RENDERFILTER_APIRENDERFILTER_CANBECONFIGURED1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2FILTERTESTS_RENDERFILTER_APIRENDERFILTER_DOFILTEREXAMINE;

/**
 * Filter for JSR 362 request dispatcher testing. Used by portlet:
 * FilterTests_RenderFilter_ApiRenderFilter
 *
 * @author ahmed
 *
 */
public class FilterTests_RenderFilter_ApiRenderFilter_filter implements RenderFilter {
  public static boolean tr4_success = false;

  private FilterConfig filterConfig;

  @Override
  public void init(FilterConfig filterConfig) throws PortletException {
    this.filterConfig = filterConfig;
  }

  @Override
  public void destroy() {}

  @Override
  public void doFilter(RenderRequest portletReq, RenderResponse portletResp, FilterChain chain)
      throws IOException, PortletException {

    PrintWriter writer = portletResp.getWriter();

    JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

    /* TestCase: V2FilterTests_RenderFilter_ApiRenderFilter_canBeConfigured1 */
    /* Details: "An RenderFilter can be configured in the portlet */
    /* descriptor" */
    TestResult tr0 =
        tcd.getTestResultFailed(V2FILTERTESTS_RENDERFILTER_APIRENDERFILTER_CANBECONFIGURED1);
    if (filterConfig.getFilterName().equals("FilterTests_RenderFilter_ApiRenderFilter_filter")) {
      tr0.setTcSuccess(true);
    }
    tr0.writeTo(writer);

    /* TestCase: V2FilterTests_RenderFilter_ApiRenderFilter_doFilterProcessRender2 */
    /* Details: "After the doFilter(RenderRequest, RenderResponse, */
    /* FilterChain): method has sucessfully completed and invokes the */
    /* next filter, the next filter in the chain is called if multiple */
    /* filters are defined" */
    tr4_success = true;

    chain.doFilter(portletReq, portletResp);

    /* TestCase: V2FilterTests_RenderFilter_ApiRenderFilter_doFilterExamine */
    /* Details: "Method doFilter(RenderRequest, RenderResponse, */
    /* FilterChain): After the next filter has been successfully invoked, */
    /* the RenderResponse may be examined" */
    TestResult tr8 =
        tcd.getTestResultFailed(V2FILTERTESTS_RENDERFILTER_APIRENDERFILTER_DOFILTEREXAMINE);
    if (!portletResp.isCommitted()) {
      tr8.setTcSuccess(true);
    }
    tr8.writeTo(writer);

    /* TestCase: V2FilterTests_RenderFilter_ApiRenderFilter_doFilterBlock */
    /*
     * Details: "If the doFilter(RenderRequest, RenderResponse, FilterChain): method does not invoke
     * the next filter, processRender is not called"
     */
    TestResult tr5 =
        tcd.getTestResultSucceeded("V2FilterTests_RenderFilter_ApiRenderFilter_doFilterBlock");
    tr5.appendTcDetail(
        "Not possible to test as render() is the last method in chain which is also responsible for test markup");
    tr5.writeTo(writer);

  }
}
