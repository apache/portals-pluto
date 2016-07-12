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

import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2FILTERTESTS_RESOURCEFILTER_APIRESOURCEFILTER_CANBECONFIGURED2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2FILTERTESTS_RESOURCEFILTER_APIRESOURCEFILTER_DOFILTERPROCESSRESOURCE2;

/**
 * Filter for JSR 362 request dispatcher testing. Used by portlet:
 * FilterTests_ResourceFilter_ApiResourceFilter
 *
 * @author ahmed
 *
 */
public class FilterTests_ResourceFilter_ApiResourceFilter_filter2 implements ResourceFilter {

  public static boolean tr2_success = false;
  public static boolean tr3_success = false;


  @Override
  public void init(FilterConfig filterConfig) throws PortletException {}

  @Override
  public void destroy() {}

  @Override
  public void doFilter(ResourceRequest portletReq, ResourceResponse portletResp, FilterChain chain)
      throws IOException, PortletException {

    PrintWriter writer = portletResp.getWriter();

    JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

    /* TestCase: V2FilterTests_ResourceFilter_ApiResourceFilter_canBeConfigured2 */
    /* Details: "Multiple ResourceFilter classes can be configured in the */
    /* portlet descriptor" */
    TestResult tr1 =
        tcd.getTestResultFailed(V2FILTERTESTS_RESOURCEFILTER_APIRESOURCEFILTER_CANBECONFIGURED2);
    tr1.setTcSuccess(true);
    tr1.writeTo(writer);

    /* TestCase: V2FilterTests_ResourceFilter_ApiResourceFilter_doFilterIsCalled */
    /* Details: "The doFilter(ResourceRequest, ResourceResponse, */
    /* FilterChain): method is called before the processResource method */
    /* for the portlet" */
    tr2_success = true;

    /* TestCase: V2FilterTests_ResourceFilter_ApiResourceFilter_doFilterProcessResource1 */
    /* Details: "After the doFilter(ResourceRequest, ResourceResponse, */
    /* FilterChain): method has sucessfully completed and invokes the */
    /* next filter, the processResourceMethod is called" */
    tr3_success = true;

    /* TestCase: V2FilterTests_ResourceFilter_ApiResourceFilter_doFilterProcessResource2 */
    /* Details: "After the doFilter(ResourceRequest, ResourceResponse, */
    /* FilterChain): method has sucessfully completed and invokes the */
    /* next filter, the next filter in the chain is called if multiple */
    /* filters are defined" */
    TestResult tr4 = tcd.getTestResultFailed(
        V2FILTERTESTS_RESOURCEFILTER_APIRESOURCEFILTER_DOFILTERPROCESSRESOURCE2);
    if (FilterTests_ResourceFilter_ApiResourceFilter_filter.tr4_success) {
      tr4.setTcSuccess(true);
    }
    tr4.writeTo(writer);

    chain.doFilter(portletReq, portletResp);

  }
}
