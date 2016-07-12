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
import java.util.Enumeration;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.filter.FilterChain;
import javax.portlet.filter.FilterConfig;
import javax.portlet.filter.RenderFilter;
import javax.portlet.tck.beans.JSR286ApiTestCaseDetails;
import javax.portlet.tck.beans.TestResult;

import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2FILTERTESTS_FILTERCONFIG_APIRENDERFILTER_GETINITPARAMETERNAMES1;

/**
 * Filter for JSR 362 request dispatcher testing. Used by portlet:
 * FilterTests_FilterConfig_ApiRenderFilter
 *
 * @author ahmed
 *
 */
public class FilterTests_FilterConfig_ApiRenderFilter_filter2 implements RenderFilter {

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

    // now do the tests and write output

    JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

    // Create result objects for the tests

    /* TestCase: V2FilterTests_FilterConfig_ApiRenderFilter_getInitParameterNames1 */
    /* Details: "Method getInitParameterNames(): Returns empty */
    /* Enumeration if no parameters defined" */
    TestResult tr4 =
        tcd.getTestResultFailed(V2FILTERTESTS_FILTERCONFIG_APIRENDERFILTER_GETINITPARAMETERNAMES1);
    Enumeration<String> initParams = filterConfig.getInitParameterNames();
    if (!initParams.hasMoreElements()) {
      tr4.setTcSuccess(true);
    } else {
      tr4.appendTcDetail("Failed because found init paramerters.");
    }
    tr4.writeTo(writer);

    chain.doFilter(portletReq, portletResp);
  }
}
