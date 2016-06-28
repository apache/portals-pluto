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

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.tck.beans.JSR286ApiTestCaseDetails;
import javax.portlet.tck.beans.TestButton;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.constants.Constants;
import javax.portlet.tck.filters.FilterTests_ActionFilter_ApiActionFilter_filter2;

import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2FILTERTESTS_ACTIONFILTER_APIACTIONFILTER_CANBECONFIGURED1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2FILTERTESTS_ACTIONFILTER_APIACTIONFILTER_CANBECONFIGURED2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2FILTERTESTS_ACTIONFILTER_APIACTIONFILTER_DOFILTERISCALLED;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2FILTERTESTS_ACTIONFILTER_APIACTIONFILTER_DOFILTERPROCESSACTION1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2FILTERTESTS_ACTIONFILTER_APIACTIONFILTER_DOFILTERPROCESSACTION2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2FILTERTESTS_ACTIONFILTER_APIACTIONFILTER_DOFILTEREXAMINE;
import static javax.portlet.tck.constants.Constants.RESULT_ATTR_PREFIX;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;
import static javax.portlet.PortletSession.APPLICATION_SCOPE;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined
 * in the /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate
 * the test case names defined in the additionalTCs.xml file into the complete list of test case
 * names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will
 * initiate the events, but not process them. The processing is done in the companion portlet
 * FilterTests_ActionFilter_ApiActionFilter_event
 *
 */
public class FilterTests_ActionFilter_ApiActionFilter implements Portlet {

  @Override
  public void init(PortletConfig config) throws PortletException {}

  @Override
  public void destroy() {}

  @Override
  public void processAction(ActionRequest portletReq, ActionResponse portletResp)
      throws PortletException, IOException {

    JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

    portletResp.setRenderParameters(portletReq.getParameterMap());
    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

    StringWriter writer = new StringWriter();

    /* TestCase: V2FilterTests_ActionFilter_ApiActionFilter_doFilterIsCalled */
    /* Details: "The doFilter(ActionRequest, ActionResponse, */
    /* FilterChain): method is called before the processAction method for */
    /* the portlet" */
    TestResult tr2 =
        tcd.getTestResultFailed(V2FILTERTESTS_ACTIONFILTER_APIACTIONFILTER_DOFILTERISCALLED);
    if (FilterTests_ActionFilter_ApiActionFilter_filter2.tr2_success) {
      tr2.setTcSuccess(true);
    }
    tr2.writeTo(writer);

    /* TestCase: V2FilterTests_ActionFilter_ApiActionFilter_doFilterProcessAction1 */
    /* Details: "After the doFilter(ActionRequest, ActionResponse, */
    /* FilterChain): method has successfully completed and invokes the */
    /* next filter, the processActionMethod is called" */
    TestResult tr3 =
        tcd.getTestResultFailed(V2FILTERTESTS_ACTIONFILTER_APIACTIONFILTER_DOFILTERPROCESSACTION1);
    if (FilterTests_ActionFilter_ApiActionFilter_filter2.tr3_success) {
      tr3.setTcSuccess(true);
    }
    tr3.writeTo(writer);

    PortletSession ps = portletReq.getPortletSession();
    String msg =
        (String) ps.getAttribute(RESULT_ATTR_PREFIX + "FilterTests_ActionFilter_ApiActionFilter",
            APPLICATION_SCOPE);
    portletReq.getPortletSession().setAttribute(
        Constants.RESULT_ATTR_PREFIX + "FilterTests_ActionFilter_ApiActionFilter",
        msg + writer.toString(), APPLICATION_SCOPE);

  }

  @Override
  public void render(RenderRequest portletReq, RenderResponse portletResp)
      throws PortletException, IOException {

    JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

    PrintWriter writer = portletResp.getWriter();

    PortletSession ps = portletReq.getPortletSession();
    String msg =
        (String) ps.getAttribute(RESULT_ATTR_PREFIX + "FilterTests_ActionFilter_ApiActionFilter",
            APPLICATION_SCOPE);
    if (msg != null) {
      writer.write("<p>" + msg + "</p><br/>\n");
      ps.removeAttribute(RESULT_ATTR_PREFIX + "FilterTests_ActionFilter_ApiActionFilter",
          APPLICATION_SCOPE);
    }

    /* TestCase: V2FilterTests_ActionFilter_ApiActionFilter_canBeConfigured1 */
    /* Details: "An ActionFilter can be configured in the portlet */
    /* descriptor" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2FILTERTESTS_ACTIONFILTER_APIACTIONFILTER_CANBECONFIGURED1, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2FilterTests_ActionFilter_ApiActionFilter_canBeConfigured2 */
    /* Details: "Multiple ActionFilter classes can be configured in the */
    /* portlet descriptor" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2FILTERTESTS_ACTIONFILTER_APIACTIONFILTER_CANBECONFIGURED2, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2FilterTests_ActionFilter_ApiActionFilter_doFilterIsCalled */
    /* Details: "The doFilter(ActionRequest, ActionResponse, */
    /* FilterChain): method is called before the processAction method for */
    /* the portlet" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2FILTERTESTS_ACTIONFILTER_APIACTIONFILTER_DOFILTERISCALLED, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2FilterTests_ActionFilter_ApiActionFilter_doFilterProcessAction1 */
    /* Details: "After the doFilter(ActionRequest, ActionResponse, */
    /* FilterChain): method has sucessfully completed and invokes the */
    /* next filter, the processActionMethod is called" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2FILTERTESTS_ACTIONFILTER_APIACTIONFILTER_DOFILTERPROCESSACTION1, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2FilterTests_ActionFilter_ApiActionFilter_doFilterProcessAction2 */
    /* Details: "After the doFilter(ActionRequest, ActionResponse, */
    /* FilterChain): method has sucessfully completed and invokes the */
    /* next filter, the next filter in the chain is called if multiple */
    /* filters are defined" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2FILTERTESTS_ACTIONFILTER_APIACTIONFILTER_DOFILTERPROCESSACTION2, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2FilterTests_ActionFilter_ApiActionFilter_doFilterExamine */
    /* Details: "Method doFilter(ActionRequest, ActionResponse, */
    /* FilterChain): After the next filter has been successfully invoked, */
    /* the ActionResponse may be examined" */
    if (portletReq.getParameter("tr8") != null && portletReq.getParameter("tr8").equals("true")) {
      TestResult tr8 =
          tcd.getTestResultFailed(V2FILTERTESTS_ACTIONFILTER_APIACTIONFILTER_DOFILTEREXAMINE);
      tr8.setTcSuccess(true);
      tr8.writeTo(writer);
    } else {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2FILTERTESTS_ACTIONFILTER_APIACTIONFILTER_DOFILTEREXAMINE, aurl);
      tb.writeTo(writer);
    }

  }

}
