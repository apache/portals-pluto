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
import java.io.StringWriter;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.filter.ActionFilter;
import javax.portlet.filter.ActionRequestWrapper;
import javax.portlet.filter.ActionResponseWrapper;
import javax.portlet.filter.EventFilter;
import javax.portlet.filter.EventRequestWrapper;
import javax.portlet.filter.EventResponseWrapper;
import javax.portlet.filter.FilterChain;
import javax.portlet.filter.FilterConfig;
import javax.portlet.filter.RenderFilter;
import javax.portlet.filter.RenderRequestWrapper;
import javax.portlet.filter.RenderResponseWrapper;
import javax.portlet.filter.ResourceFilter;
import javax.portlet.filter.ResourceRequestWrapper;
import javax.portlet.filter.ResourceResponseWrapper;
import javax.portlet.tck.beans.JSR286SpecTestCaseDetails;
import javax.portlet.tck.beans.TestResult;

import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLFILTERTESTS_SPEC2_20_ACTION_FILTER1;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLFILTERTESTS_SPEC2_20_ACTION_FILTER6;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLFILTERTESTS_SPEC2_20_ACTION_FILTER7;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLFILTERTESTS_SPEC2_20_ACTION_FILTER8;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLFILTERTESTS_SPEC2_20_ACTION_FILTER9;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLFILTERTESTS_SPEC2_20_ACTION_FILTER13;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLFILTERTESTS_SPEC2_20_ACTION_FILTERWRAPPER1;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLFILTERTESTS_SPEC2_20_ACTION_FILTER2;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLFILTERTESTS_SPEC2_20_EVENT_FILTER4;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLFILTERTESTS_SPEC2_20_EVENT_FILTERWRAPPER3;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLFILTERTESTS_SPEC2_20_RENDER_FILTERWRAPPER6;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLFILTERTESTS_SPEC2_20_RENDER_FILTERWRAPPER5;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLFILTERTESTS_SPEC2_20_RENDER_FILTER3;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLFILTERTESTS_SPEC2_20_RESOURCE_FILTERWRAPPER7;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLFILTERTESTS_SPEC2_20_RESOURCE_FILTERWRAPPER8;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLFILTERTESTS_SPEC2_20_RESOURCE_FILTER5;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;
import static javax.portlet.tck.constants.Constants.RESULT_ATTR_PREFIX;
import static javax.portlet.PortletSession.APPLICATION_SCOPE;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined
 * in the /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate
 * the test case names defined in the additionalTCs.xml file into the complete list of test case
 * names for execution by the driver.
 * 
 * @author ahmed
 */
public class AddlFilterTests_SPEC2_20_Filter
    implements ActionFilter, EventFilter, ResourceFilter, RenderFilter {

  FilterConfig config;

  public void init(FilterConfig config) throws PortletException {
    this.config = config;

    String filterName = config.getFilterName();

    /* TestCase: V2AddlFilterTests_SPEC2_20_Action_filter12 */
    /* Details: "A filter class can appear in multiple filter */
    /* declarations" */
    if (filterName.equals("AddlFilterTests_SPEC2_20_Filter1")) {
      AddlFilterTests_SPEC2_20_ActionFilter_TestVariables.actionTr7a_success = true;
    }
    if (filterName.equals("AddlFilterTests_SPEC2_20_Filter2")) {
      AddlFilterTests_SPEC2_20_ActionFilter_TestVariables.actionTr7b_success = true;
    }

    /* TestCase: V2AddlFilterTests_SPEC2_20_Action_filter14 */
    /* Details: "Filters can be associated with groups of portlets using */
    /* the '*' character as a wildcard at the end of a string to indicate */
    /* that the filter must be applied to any portlet whose name starts */
    /* with the characters before the \"*\" character" */
    if (filterName.equals("AddlFilterTests_SPEC2_20_Filter3")) {
      AddlFilterTests_SPEC2_20_ActionFilter_TestVariables.actionTr9_success = true;
    }
  }

  public void doFilter(ActionRequest portletReq, ActionResponse portletResp, FilterChain chain)
      throws IOException, PortletException {

    portletResp.setRenderParameters(portletReq.getParameterMap());
    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

    StringWriter writer = new StringWriter();

    JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();
    String portletNameAction =
        (String) config.getPortletContext().getAttribute("PortletNameAction");
    String portletNameRender =
        (String) config.getPortletContext().getAttribute("PortletNameRender");
    String portletNameResource =
        (String) config.getPortletContext().getAttribute("PortletNameResource");
    String filterName = config.getFilterName();

    /* TestCase: V2AddlFilterTests_SPEC2_20_Action_filter1 */
    /* Details: "A filter declaration can be configured in the deployment */
    /* descriptor" */
    TestResult tr0 = tcd.getTestResultFailed(V2ADDLFILTERTESTS_SPEC2_20_ACTION_FILTER1);
    if (portletNameAction != null && portletNameAction.equals("AddlFilterTests_SPEC2_20_Action")
        && filterName.equals("AddlFilterTests_SPEC2_20_Filter1")) {
      tr0.setTcSuccess(true);
    } else {
      tr0.appendTcDetail("Filter is not configured for V2AddlFilterTests_SPEC2_20_Action portlet");
    }
    tr0.writeTo(writer);

    /* TestCase: V2AddlFilterTests_SPEC2_20_Action_filter6 */
    /* Details: "A filter declaration can contain multiple */
    /* &lt;lifecycle&gt; tags for a single filter class" */
    TestResult tr1 = tcd.getTestResultFailed(V2ADDLFILTERTESTS_SPEC2_20_ACTION_FILTER6);
    if (portletNameAction != null && portletNameAction.equals("AddlFilterTests_SPEC2_20_Action")
        && filterName.equals("AddlFilterTests_SPEC2_20_Filter1")) {
      tr1.setTcSuccess(true);
    } else {
      tr1.appendTcDetail("Filter is not configured for V2AddlFilterTests_SPEC2_20_Action portlet");
    }
    tr1.writeTo(writer);

    /* TestCase: V2AddlFilterTests_SPEC2_20_Action_filter7 */
    /* Details: "The filter declaration can contain initialization */
    /* parameters which can be read by the filter through the */
    /* FilterConfig object" */
    TestResult tr2 = tcd.getTestResultFailed(V2ADDLFILTERTESTS_SPEC2_20_ACTION_FILTER7);
    if (portletNameAction != null && portletNameAction.equals("AddlFilterTests_SPEC2_20_Action")
        && filterName.equals("AddlFilterTests_SPEC2_20_Filter1")) {
      if (config.getInitParameter("tr2") != null && config.getInitParameter("tr2").equals("true")) {
        tr2.setTcSuccess(true);
      } else {
        tr2.appendTcDetail("Init parameter tr2 is not found or is not equal to \"true\"");
      }
    } else {
      tr2.appendTcDetail("Filter is not configured for V2AddlFilterTests_SPEC2_20_Action portlet");
    }
    tr2.writeTo(writer);

    /* TestCase: V2AddlFilterTests_SPEC2_20_Action_filter8 */
    /* Details: "For each filter declaration, the filter instance must */
    /* receive all initialization parameters defined in the filter */
    /* declaration" */
    TestResult tr3 = tcd.getTestResultFailed(V2ADDLFILTERTESTS_SPEC2_20_ACTION_FILTER8);
    if (portletNameAction != null && portletNameAction.equals("AddlFilterTests_SPEC2_20_Action")
        && filterName.equals("AddlFilterTests_SPEC2_20_Filter1")) {
      List<String> initParams = Collections.list(config.getInitParameterNames());
      if (initParams.contains("tr2") && initParams.contains("tr3")) {
        tr3.setTcSuccess(true);
      } else {
        tr3.appendTcDetail("Initialization parameters tr2 and tr3 are missing");
      }
    } else {
      tr3.appendTcDetail("Filter is not configured for V2AddlFilterTests_SPEC2_20_Action portlet");
    }
    tr3.writeTo(writer);

    /* TestCase: V2AddlFilterTests_SPEC2_20_Action_filter9 */
    /* Details: "For each filter declaration, the filter instance must */
    /* receive only initialization parameters defined in the filter */
    /* declaration" */
    TestResult tr4 = tcd.getTestResultFailed(V2ADDLFILTERTESTS_SPEC2_20_ACTION_FILTER9);
    if (portletNameAction != null && portletNameAction.equals("AddlFilterTests_SPEC2_20_Action")
        && filterName.equals("AddlFilterTests_SPEC2_20_Filter1")) {
      List<String> initParams = Collections.list(config.getInitParameterNames());
      if (initParams.contains("tr2") && initParams.contains("tr3")) {
        tr4.setTcSuccess(true);
      } else {
        tr4.appendTcDetail("Initialization parameters tr2 and tr3 are missing");
      }
    } else {
      tr4.appendTcDetail("Filter is not configured for V2AddlFilterTests_SPEC2_20_Action portlet");
    }
    tr4.writeTo(writer);

    /* TestCase: V2AddlFilterTests_SPEC2_20_Action_filter10 */
    /* Details: "For multiple filter declarations for a single filter */
    /* class, the filter instance must receive all initialization */
    /* parameters defined in the filter declaration" */

    /* TestCase: V2AddlFilterTests_SPEC2_20_Action_filter11 */
    /* Details: "For multiple filter declarations for a single filter */
    /* class, the filter instance must receive only initialization */
    /* parameters defined in the filter declaration" */
    if (portletNameAction != null && portletNameAction.equals("AddlFilterTests_SPEC2_20_Action")
        && filterName.equals("AddlFilterTests_SPEC2_20_Filter1")) {
      List<String> initParams = Collections.list(config.getInitParameterNames());
      if (initParams.contains("tr2") && initParams.contains("tr3")) {
        AddlFilterTests_SPEC2_20_ActionFilter_TestVariables.actionTr5a_success = true;
        AddlFilterTests_SPEC2_20_ActionFilter_TestVariables.actionTr6a_success = true;
      } else {
        AddlFilterTests_SPEC2_20_ActionFilter_TestVariables.actionTr5a_success = false;
        AddlFilterTests_SPEC2_20_ActionFilter_TestVariables.actionTr6a_success = false;
      }
    }

    /* TestCase: V2AddlFilterTests_SPEC2_20_Action_filter13 */
    /* Details: "A filter declaration can be mapped to a portlet through */
    /* the deployment descriptor &lt;filter-mapping&gt; element" */
    TestResult tr8 = tcd.getTestResultFailed(V2ADDLFILTERTESTS_SPEC2_20_ACTION_FILTER13);
    if (portletNameAction != null && portletNameAction.equals("AddlFilterTests_SPEC2_20_Action")
        && filterName.equals("AddlFilterTests_SPEC2_20_Filter1")) {
      tr8.setTcSuccess(true);
    } else {
      tr8.appendTcDetail("Filter is not configured for V2AddlFilterTests_SPEC2_20_Action portlet");
    }
    tr8.writeTo(writer);

    /* TestCase: V2AddlFilterTests_SPEC2_20_Action_filter15 */
    /* Details: "The order the container uses in building the chain of */
    /* filters to be applied for a particular request is the order in */
    /* which the &lt;portlet-name&gt; matching filter mappings appear in */
    /* the deployment descriptor" */
    if (portletNameAction != null && portletNameAction.equals("AddlFilterTests_SPEC2_20_Action")
        && filterName.equals("AddlFilterTests_SPEC2_20_Filter1")) {
      AddlFilterTests_SPEC2_20_ActionFilter_TestVariables.actionTr10a_success = true;
    }

    /* TestCase: V2AddlFilterTests_SPEC2_20_Action_filterWrapper1 */
    /* Details: "An ACTION_PHASE filter can wrap the ActionRequest object */
    /* with a custom wrapper" */
    TestResult tr11 = tcd.getTestResultFailed(V2ADDLFILTERTESTS_SPEC2_20_ACTION_FILTERWRAPPER1);
    ActionRequestWrapper actionReq = new ActionRequestWrapper(portletReq);
    if (actionReq.getParameter("tr11") != null && actionReq.getParameter("tr11").equals("true")) {
      tr11.setTcSuccess(true);
    } else {
      tr11.appendTcDetail("Action Parameter tr11 is not found in the wrapper");
    }
    tr11.writeTo(writer);

    /* TestCase: V2AddlFilterTests_SPEC2_20_Action_filterWrapper2 */
    /* Details: "An ACTION_PHASE filter can wrap the ActionResponse */
    /* object with a custom wrapper" */
    ActionResponseWrapper actionResp = new ActionResponseWrapper(portletResp);
    actionResp.setRenderParameter("tr12", "true");

    /* TestCase: V2AddlFilterTests_SPEC2_20_Action_filter2 */
    /* Details: "If the filter declaration specifies the */
    /* &lt;lifecycle&gt; tag value ACTION_PHASE, the */
    /* ActionFilter.doFilter method is called" */
    TestResult tr13 = tcd.getTestResultFailed(V2ADDLFILTERTESTS_SPEC2_20_ACTION_FILTER2);
    tr13.setTcSuccess(true);
    tr13.writeTo(writer);

    portletReq.getPortletSession().setAttribute(
        RESULT_ATTR_PREFIX + "AddlFilterTests_SPEC2_20_Action", writer.toString(),
        APPLICATION_SCOPE);

    chain.doFilter(portletReq, portletResp);
  }

  public void destroy() {
    // free resources
  }

  @Override
  public void doFilter(EventRequest portletReq, EventResponse portletResp, FilterChain chain)
      throws IOException, PortletException {

    StringWriter writer = new StringWriter();

    JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();
    /* TestCase: V2AddlFilterTests_SPEC2_20_Event_filter4 */
    /* Details: "If the filter declaration specifies the */
    /* &lt;lifecycle&gt; tag value EVENT_PHASE, the EventFilter.doFilter */
    /* method is called" */
    TestResult tr13 = tcd.getTestResultFailed(V2ADDLFILTERTESTS_SPEC2_20_EVENT_FILTER4);
    tr13.setTcSuccess(true);
    tr13.writeTo(writer);

    /* TestCase: V2AddlFilterTests_SPEC2_20_Event_filterWrapper3 */
    /* Details: "An EVENT_PHASE filter can wrap the EventRequest object */
    /* with a custom wrapper" */
    TestResult tr11 = tcd.getTestResultFailed(V2ADDLFILTERTESTS_SPEC2_20_EVENT_FILTERWRAPPER3);
    EventRequestWrapper eventReq = new EventRequestWrapper(portletReq);
    if (eventReq.getParameter("tr11_event") != null
        && eventReq.getParameter("tr11_event").equals("true")) {
      tr11.setTcSuccess(true);
    } else {
      tr11.appendTcDetail("Event Parameter tr11_event is not found in the wrapper");
    }
    tr11.writeTo(writer);

    /* TestCase: V2AddlFilterTests_SPEC2_20_Event_filterWrapper4 */
    /* Details: "An EVENT_PHASE filter can wrap the EventResponse object */
    /* with a custom wrapper" */
    EventResponseWrapper eventResp = new EventResponseWrapper(portletResp);
    eventResp.setRenderParameter("tr12", "true");

    portletReq.getPortletSession().setAttribute(
        RESULT_ATTR_PREFIX + "AddlFilterTests_SPEC2_20_Event", writer.toString(),
        APPLICATION_SCOPE);
    chain.doFilter(portletReq, portletResp);
  }

  @Override
  public void doFilter(RenderRequest portletReq, RenderResponse portletResp, FilterChain chain)
      throws IOException, PortletException {
    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);
    JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();

    /* TestCase: V2AddlFilterTests_SPEC2_20_Render_filterWrapper6 */
    /* Details: "An RENDER_PHASE filter can wrap the RenderResponse */
    /* object with a custom wrapper" */
    RenderResponseWrapper renderResp = new RenderResponseWrapper(portletResp);
    PrintWriter writer = renderResp.getWriter();
    TestResult tr12 = tcd.getTestResultFailed(V2ADDLFILTERTESTS_SPEC2_20_RENDER_FILTERWRAPPER6);
    tr12.setTcSuccess(true);
    tr12.writeTo(writer);

    // Create result objects for the tests

    /* TestCase: V2AddlFilterTests_SPEC2_20_Render_filterWrapper5 */
    /* Details: "An RENDER_PHASE filter can wrap the RenderRequest object */
    /* with a custom wrapper" */
    TestResult tr11 = tcd.getTestResultFailed(V2ADDLFILTERTESTS_SPEC2_20_RENDER_FILTERWRAPPER5);
    RenderRequestWrapper renderReq = new RenderRequestWrapper(portletReq);
    if (renderReq.getParameter("tr11") != null && renderReq.getParameter("tr11").equals("true")) {
      tr11.setTcSuccess(true);
    } else {
      tr11.appendTcDetail("Render Parameter tr11 is not found in the wrapper");
    }
    tr11.writeTo(writer);

    /* TestCase: V2AddlFilterTests_SPEC2_20_Render_filter3 */
    /* Details: "If the filter declaration specifies the */
    /* &lt;lifecycle&gt; tag value RENDER_PHASE, the */
    /* RenderFilter.doFilter method is called" */
    TestResult tr13 = tcd.getTestResultFailed(V2ADDLFILTERTESTS_SPEC2_20_RENDER_FILTER3);
    tr13.setTcSuccess(true);
    tr13.writeTo(writer);

    chain.doFilter(portletReq, portletResp);
  }

  @Override
  public void doFilter(ResourceRequest portletReq, ResourceResponse portletResp, FilterChain chain)
      throws IOException, PortletException {

    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

    ResourceResponseWrapper resourceResp = new ResourceResponseWrapper(portletResp);
    PrintWriter writer = resourceResp.getWriter();

    JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();

    // Create result objects for the tests

    /* TestCase: V2AddlFilterTests_SPEC2_20_Resource_filterWrapper7 */
    /* Details: "An RESOURCE_PHASE filter can wrap the ResourceRequest */
    /* object with a custom wrapper" */
    TestResult tr12 = tcd.getTestResultFailed(V2ADDLFILTERTESTS_SPEC2_20_RESOURCE_FILTERWRAPPER7);

    ResourceRequestWrapper resourceReq = new ResourceRequestWrapper(portletReq);
    if (resourceReq.getParameter("tr12") != null
        && resourceReq.getParameter("tr12").equals("true")) {
      tr12.setTcSuccess(true);
    } else {
      tr12.appendTcDetail("Render Parameter tr12 is not found in the wrapper");
    }
    tr12.writeTo(writer);

    /* TestCase: V2AddlFilterTests_SPEC2_20_Resource_filterWrapper8 */
    /* Details: "An RESOURCE_PHASE filter can wrap the ResourceResponse */
    /* object with a custom wrapper" */
    TestResult tr13 = tcd.getTestResultFailed(V2ADDLFILTERTESTS_SPEC2_20_RESOURCE_FILTERWRAPPER8);
    tr13.setTcSuccess(true);
    tr13.writeTo(writer);


    /* TestCase: V2AddlFilterTests_SPEC2_20_Resource_filter5 */
    /* Details: "If the filter declaration specifies the */
    /* &lt;lifecycle&gt; tag value RESOURCE_PHASE, the */
    /* ResourceFilter.doFilter method is called" */
    TestResult tr11 = tcd.getTestResultFailed(V2ADDLFILTERTESTS_SPEC2_20_RESOURCE_FILTER5);
    tr11.setTcSuccess(true);
    tr11.writeTo(writer);

    chain.doFilter(portletReq, portletResp);
  }
}
