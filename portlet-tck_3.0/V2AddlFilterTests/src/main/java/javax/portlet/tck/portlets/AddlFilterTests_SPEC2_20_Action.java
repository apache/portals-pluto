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
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.*;
import static javax.portlet.tck.constants.Constants.*;
import static javax.portlet.PortletSession.*;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined
 * in the /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate
 * the test case names defined in the additionalTCs.xml file into the complete list of test case
 * names for execution by the driver.
 * @author ahmed
 */
public class AddlFilterTests_SPEC2_20_Action implements Portlet {
  private static final String LOG_CLASS = AddlFilterTests_SPEC2_20_Action.class.getName();
  private final Logger LOGGER = Logger.getLogger(LOG_CLASS);

  private PortletConfig portletConfig = null;

  @Override
  public void init(PortletConfig config) throws PortletException {
    this.portletConfig = config;
    this.portletConfig.getPortletContext().setAttribute("PortletNameAction",
        "AddlFilterTests_SPEC2_20_Action");
  }

  @Override
  public void destroy() {}

  @Override
  public void processAction(ActionRequest portletReq, ActionResponse portletResp)
      throws PortletException, IOException {
    LOGGER.entering(LOG_CLASS, "main portlet processAction entry");

    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);
  }

  @Override
  public void render(RenderRequest portletReq, RenderResponse portletResp)
      throws PortletException, IOException {
    LOGGER.entering(LOG_CLASS, "main portlet render entry");

    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

    PrintWriter writer = portletResp.getWriter();
    JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();

    PortletSession ps = portletReq.getPortletSession();
    String msg = (String) ps.getAttribute(RESULT_ATTR_PREFIX + "AddlFilterTests_SPEC2_20_Action",
        APPLICATION_SCOPE);
    if (msg != null) {
      writer.write("<p>" + msg + "</p><br/>\n");
      ps.removeAttribute(RESULT_ATTR_PREFIX + "AddlFilterTests_SPEC2_20_Action", APPLICATION_SCOPE);
    }

    /* TestCase: V2AddlFilterTests_SPEC2_20_Action_filter10 */
    /* Details: "For multiple filter declarations for a single filter */
    /* class, the filter instance must receive all initialization */
    /* parameters defined in the filter declaration" */
    TestResult tr5 = tcd.getTestResultFailed(V2ADDLFILTERTESTS_SPEC2_20_ACTION_FILTER10);
    if (AddlFilterTests_SPEC2_20_ActionFilter_TestVariables.actionTr5a_success
        && AddlFilterTests_SPEC2_20_ActionFilter_TestVariables.actionTr5b_success) {
      tr5.setTcSuccess(true);
    }
    tr5.writeTo(writer);

    /* TestCase: V2AddlFilterTests_SPEC2_20_Action_filter11 */
    /* Details: "For multiple filter declarations for a single filter */
    /* class, the filter instance must receive only initialization */
    /* parameters defined in the filter declaration" */
    TestResult tr6 = tcd.getTestResultFailed(V2ADDLFILTERTESTS_SPEC2_20_ACTION_FILTER11);
    if (AddlFilterTests_SPEC2_20_ActionFilter_TestVariables.actionTr6a_success
        && AddlFilterTests_SPEC2_20_ActionFilter_TestVariables.actionTr6b_success) {
      tr6.setTcSuccess(true);
    }
    tr6.writeTo(writer);

    /* TestCase: V2AddlFilterTests_SPEC2_20_Action_filter12 */
    /* Details: "A filter class can appear in multiple filter */
    /* declarations" */
    TestResult tr7 = tcd.getTestResultFailed(V2ADDLFILTERTESTS_SPEC2_20_ACTION_FILTER12);
    if (AddlFilterTests_SPEC2_20_ActionFilter_TestVariables.actionTr7a_success
        && AddlFilterTests_SPEC2_20_ActionFilter_TestVariables.actionTr7b_success) {
      tr7.setTcSuccess(true);
    }
    tr7.writeTo(writer);

    /* TestCase: V2AddlFilterTests_SPEC2_20_Action_filter14 */
    /* Details: "Filters can be associated with groups of portlets using */
    /* the '*' character as a wildcard at the end of a string to indicate */
    /* that the filter must be applied to any portlet whose name starts */
    /* with the characters before the \"*\" character" */
    TestResult tr9 = tcd.getTestResultFailed(V2ADDLFILTERTESTS_SPEC2_20_ACTION_FILTER14);
    if (AddlFilterTests_SPEC2_20_ActionFilter_TestVariables.actionTr9_success) {
      tr9.setTcSuccess(true);
    }
    tr9.writeTo(writer);

    /* TestCase: V2AddlFilterTests_SPEC2_20_Action_filter15 */
    /* Details: "The order the container uses in building the chain of */
    /* filters to be applied for a particular request is the order in */
    /* which the &lt;portlet-name&gt; matching filter mappings appear in */
    /* the deployment descriptor" */
    TestResult tr10 = tcd.getTestResultFailed(V2ADDLFILTERTESTS_SPEC2_20_ACTION_FILTER15);
    if (AddlFilterTests_SPEC2_20_ActionFilter_TestVariables.actionTr10a_success
        && AddlFilterTests_SPEC2_20_ActionFilter_TestVariables.actionTr10b_success) {
      tr10.setTcSuccess(true);
    }
    tr10.writeTo(writer);


    /* TestCase: V2AddlFilterTests_SPEC2_20_Action_filter1 */
    /* Details: "A filter declaration can be configured in the deployment */
    /* descriptor" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton("V2AddlFilterTests_SPEC2_20_Action_filter1", aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2AddlFilterTests_SPEC2_20_Action_filter6 */
    /* Details: "A filter declaration can contain multiple */
    /* &lt;lifecycle&gt; tags for a single filter class" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton("V2AddlFilterTests_SPEC2_20_Action_filter6", aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2AddlFilterTests_SPEC2_20_Action_filter7 */
    /* Details: "The filter declaration can contain initialization */
    /* parameters which can be read by the filter through the */
    /* FilterConfig object" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton("V2AddlFilterTests_SPEC2_20_Action_filter7", aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2AddlFilterTests_SPEC2_20_Action_filter8 */
    /* Details: "For each filter declaration, the filter instance must */
    /* receive all initialization parameters defined in the filter */
    /* declaration" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton("V2AddlFilterTests_SPEC2_20_Action_filter8", aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2AddlFilterTests_SPEC2_20_Action_filter9 */
    /* Details: "For each filter declaration, the filter instance must */
    /* receive only initialization parameters defined in the filter */
    /* declaration" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton("V2AddlFilterTests_SPEC2_20_Action_filter9", aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2AddlFilterTests_SPEC2_20_Action_filter10 */
    /* Details: "For multiple filter declarations for a single filter */
    /* class, the filter instance must receive all initialization */
    /* parameters defined in the filter declaration" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton("V2AddlFilterTests_SPEC2_20_Action_filter10", aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2AddlFilterTests_SPEC2_20_Action_filter11 */
    /* Details: "For multiple filter declarations for a single filter */
    /* class, the filter instance must receive only initialization */
    /* parameters defined in the filter declaration" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton("V2AddlFilterTests_SPEC2_20_Action_filter11", aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2AddlFilterTests_SPEC2_20_Action_filter12 */
    /* Details: "A filter class can appear in multiple filter */
    /* declarations" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton("V2AddlFilterTests_SPEC2_20_Action_filter12", aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2AddlFilterTests_SPEC2_20_Action_filter13 */
    /* Details: "A filter declaration can be mapped to a portlet through */
    /* the deployment descriptor &lt;filter-mapping&gt; element" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton("V2AddlFilterTests_SPEC2_20_Action_filter13", aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2AddlFilterTests_SPEC2_20_Action_filter14 */
    /* Details: "Filters can be associated with groups of portlets using */
    /* the '*' character as a wildcard at the end of a string to indicate */
    /* that the filter must be applied to any portlet whose name starts */
    /* with the characters before the \"*\" character" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton("V2AddlFilterTests_SPEC2_20_Action_filter14", aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2AddlFilterTests_SPEC2_20_Action_filter15 */
    /* Details: "The order the container uses in building the chain of */
    /* filters to be applied for a particular request is the order in */
    /* which the &lt;portlet-name&gt; matching filter mappings appear in */
    /* the deployment descriptor" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton("V2AddlFilterTests_SPEC2_20_Action_filter15", aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2AddlFilterTests_SPEC2_20_Action_filterWrapper1 */
    /* Details: "An ACTION_PHASE filter can wrap the ActionRequest object */
    /* with a custom wrapper" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      aurl.setParameter("tr11", "true");
      TestButton tb = new TestButton("V2AddlFilterTests_SPEC2_20_Action_filterWrapper1", aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2AddlFilterTests_SPEC2_20_Action_filterWrapper2 */
    /* Details: "An ACTION_PHASE filter can wrap the ActionResponse */
    /* object with a custom wrapper" */
    if (portletReq.getParameter("tr12") != null && portletReq.getParameter("tr12").equals("true")) {
      TestResult tr12 = tcd.getTestResultFailed(V2ADDLFILTERTESTS_SPEC2_20_ACTION_FILTERWRAPPER2);
      tr12.setTcSuccess(true);
      tr12.writeTo(writer);
    } else {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton("V2AddlFilterTests_SPEC2_20_Action_filterWrapper2", aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2AddlFilterTests_SPEC2_20_Action_filter2 */
    /* Details: "If the filter declaration specifies the */
    /* &lt;lifecycle&gt; tag value ACTION_PHASE, the */
    /* ActionFilter.doFilter method is called" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton("V2AddlFilterTests_SPEC2_20_Action_filter2", aurl);
      tb.writeTo(writer);
    }

  }

}
