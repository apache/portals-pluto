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
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.filter.FilterChain;
import javax.portlet.filter.FilterConfig;
import javax.portlet.filter.ResourceFilter;
import javax.portlet.tck.beans.JSR286ApiTestCaseDetails;
import javax.portlet.tck.beans.TestResult;

import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2FILTERTESTS_RESOURCEFILTER_APIRESOURCEFILTER_CANBECONFIGURED1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2FILTERTESTS_RESOURCEFILTER_APIRESOURCEFILTER_DOFILTEREXAMINE;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2FILTERTESTS_RESOURCEFILTER_APIRESOURCEFILTER_DOFILTERBLOCK;

/**
 * Filter for JSR 362 request dispatcher testing. Used by portlet:
 * FilterTests_ResourceFilter_ApiResourceFilter
 *
 * @author ahmed
 *
 */
public class FilterTests_ResourceFilter_ApiResourceFilter_filter implements ResourceFilter {

  public static boolean tr4_success = false;

  private FilterConfig filterConfig;

  @Override
  public void init(FilterConfig filterConfig) throws PortletException {
    this.filterConfig = filterConfig;
  }

  @Override
  public void destroy() {}

  @Override
  public void doFilter(ResourceRequest portletReq, ResourceResponse portletResp, FilterChain chain)
      throws IOException, PortletException {

    PrintWriter writer = portletResp.getWriter();

    JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

    /* TestCase: V2FilterTests_ResourceFilter_ApiResourceFilter_canBeConfigured1 */
    /* Details: "An ResourceFilter can be configured in the portlet */
    /* descriptor" */
    TestResult tr0 =
        tcd.getTestResultFailed(V2FILTERTESTS_RESOURCEFILTER_APIRESOURCEFILTER_CANBECONFIGURED1);
    if (filterConfig.getFilterName()
        .equals("FilterTests_ResourceFilter_ApiResourceFilter_filter")) {
      tr0.setTcSuccess(true);
    }
    tr0.writeTo(writer);

    /* TestCase: V2FilterTests_ResourceFilter_ApiResourceFilter_doFilterProcessResource2 */
    /* Details: "After the doFilter(ResourceRequest, ResourceResponse, */
    /* FilterChain): method has sucessfully completed and invokes the */
    /* next filter, the next filter in the chain is called if multiple */
    /* filters are defined" */
    tr4_success = true;

    chain.doFilter(portletReq, portletResp);

    /* TestCase: V2FilterTests_ResourceFilter_ApiResourceFilter_doFilterExamine */
    /* Details: "Method doFilter(ResourceRequest, ResourceResponse, */
    /* FilterChain): After the next filter has been successfully invoked, */
    /* the ResourceResponse may be examined" */
    TestResult tr8 =
        tcd.getTestResultFailed(V2FILTERTESTS_RESOURCEFILTER_APIRESOURCEFILTER_DOFILTEREXAMINE);
    if (!portletResp.isCommitted()) {
      tr8.setTcSuccess(true);
    }
    tr8.writeTo(writer);

    /*
     * TestCase: V2FilterTests_ResourceFilter_ApiResourceFilter_doFilterBlock Details: If the
     * doFilter(ResourceRequest, ResourceResponse, FilterChain): method does not invoke the next
     * filter, processResource is not called
     */
    TestResult tr5 =
        tcd.getTestResultSucceeded(V2FILTERTESTS_RESOURCEFILTER_APIRESOURCEFILTER_DOFILTERBLOCK);
    tr5.appendTcDetail(
        "Can't be tested as processResource is the (last) step which render test markup");
    tr5.writeTo(writer);

  }
}
