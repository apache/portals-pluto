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

import java.io.*;
import java.util.logging.*;
import javax.portlet.*;
import javax.portlet.tck.beans.*;
import javax.portlet.tck.filters.FilterTests_RenderFilter_ApiRenderFilter_filter2;

import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.*;
import static javax.portlet.tck.constants.Constants.*;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined
 * in the /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate
 * the test case names defined in the additionalTCs.xml file into the complete list of test case
 * names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will
 * initiate the events, but not process them. The processing is done in the companion portlet
 * FilterTests_RenderFilter_ApiRenderFilter_event
 *
 */
public class FilterTests_RenderFilter_ApiRenderFilter implements Portlet, ResourceServingPortlet {
  private static final String LOG_CLASS = FilterTests_RenderFilter_ApiRenderFilter.class.getName();
  private final Logger LOGGER = Logger.getLogger(LOG_CLASS);

  @Override
  public void init(PortletConfig config) throws PortletException {}

  @Override
  public void destroy() {}

  @Override
  public void processAction(ActionRequest portletReq, ActionResponse portletResp)
      throws PortletException, IOException {
    LOGGER.entering(LOG_CLASS, "main portlet processAction entry");

    portletResp.setRenderParameters(portletReq.getParameterMap());
    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);
  }

  @Override
  public void serveResource(ResourceRequest portletReq, ResourceResponse portletResp)
      throws PortletException, IOException {
    LOGGER.entering(LOG_CLASS, "main portlet serveResource entry");

    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);
  }

  @Override
  public void render(RenderRequest portletReq, RenderResponse portletResp)
      throws PortletException, IOException {
    LOGGER.entering(LOG_CLASS, "main portlet render entry");

    JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

    PrintWriter writer = portletResp.getWriter();
    /* TestCase: V2FilterTests_RenderFilter_ApiRenderFilter_doFilterIsCalled */
    /* Details: "The doFilter(RenderRequest, RenderResponse, */
    /* FilterChain): method is called before the processRender method for */
    /* the portlet" */
    TestResult tr2 =
        tcd.getTestResultFailed(V2FILTERTESTS_RENDERFILTER_APIRENDERFILTER_DOFILTERISCALLED);
    if (FilterTests_RenderFilter_ApiRenderFilter_filter2.tr2_success) {
      tr2.setTcSuccess(true);
    }
    tr2.writeTo(writer);

    /* TestCase: V2FilterTests_RenderFilter_ApiRenderFilter_doFilterProcessRender1 */
    /* Details: "After the doFilter(RenderRequest, RenderResponse, */
    /* FilterChain): method has sucessfully completed and invokes the */
    /* next filter, the processRenderMethod is called" */
    TestResult tr3 =
        tcd.getTestResultFailed(V2FILTERTESTS_RENDERFILTER_APIRENDERFILTER_DOFILTERPROCESSRENDER1);
    if (FilterTests_RenderFilter_ApiRenderFilter_filter2.tr3_success) {
      tr3.setTcSuccess(true);
    }
    tr3.writeTo(writer);

  }

}
