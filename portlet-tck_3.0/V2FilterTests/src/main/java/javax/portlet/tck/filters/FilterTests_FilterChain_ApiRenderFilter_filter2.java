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

import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2FILTERTESTS_FILTERCHAIN_APIRENDERFILTER_INVOKERENDERFILTER;

/**
 * Filter for JSR 362 request dispatcher testing. Used by portlet:
 * FilterTests_FilterChain_ApiRenderFilter
 *
 * @author ahmed
 *
 */
public class FilterTests_FilterChain_ApiRenderFilter_filter2 implements RenderFilter {

  public static boolean tr1_success = false;

  @SuppressWarnings("unused")
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

    // first execute the chain



    // now do the tests and write output

    JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

    // Create result objects for the tests

    /* TestCase: V2FilterTests_FilterChain_ApiRenderFilter_invokeRenderFilter */
    /* Details: "Invoking doFilter(RenderRequest, RenderResponse): causes */
    /* next filter to be invoked" */
    TestResult tr0 =
        tcd.getTestResultFailed(V2FILTERTESTS_FILTERCHAIN_APIRENDERFILTER_INVOKERENDERFILTER);
    if (FilterTests_FilterChain_ApiRenderFilter_filter.tr0_success) {
      tr0.setTcSuccess(true);
    }
    tr0.writeTo(writer);

    /* TestCase: V2FilterTests_FilterChain_ApiRenderFilter_invokeRenderFilter2 */
    /* Details: "Invoking doFilter(RenderRequest, RenderResponse): causes */
    /* portlet Render method to be invoked" */
    FilterTests_FilterChain_ApiRenderFilter_filter2.tr1_success = true;

    chain.doFilter(portletReq, portletResp);
  }
}
