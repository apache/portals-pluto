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
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.tck.beans.JSR286SpecTestCaseDetails;
import javax.portlet.tck.beans.TestButton;
import javax.portlet.tck.beans.TestResult;

import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLREQUESTTESTS_SPEC2_11_ACTIONATTR_ATTRIBUTES1;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLREQUESTTESTS_SPEC2_11_ACTIONATTR_ATTRIBUTES2;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLREQUESTTESTS_SPEC2_11_ACTIONATTR_ATTRIBUTES6;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;
import static javax.portlet.tck.constants.Constants.RESULT_ATTR_PREFIX;
import static javax.portlet.PortletSession.APPLICATION_SCOPE;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined
 * in the /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate
 * the test case names defined in the additionalTCs.xml file into the complete list of test case
 * names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will
 * initiate the events, but not process them. The processing is done in the companion portlet
 * AddlRequestTests_SPEC2_11_ActionAttr_event
 * 
 * @author ahmed
 */
public class AddlRequestTests_SPEC2_11_ActionAttr implements Portlet {

  @Override
  public void init(PortletConfig config) throws PortletException {}

  @Override
  public void destroy() {}

  @Override
  public void processAction(ActionRequest portletReq, ActionResponse portletResp)
      throws PortletException, IOException {

    portletResp.setRenderParameters(portletReq.getParameterMap());
    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

    StringWriter writer = new StringWriter();

    JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();

    // Create result objects for the tests

    /* TestCase: V2AddlRequestTests_SPEC2_11_ActionAttr_attributes1 */
    /* Details: "The portlet can access a map with user information */
    /* attributes via the request attribute PortletRequest.USER_INFO" */
    TestResult tr0 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_ACTIONATTR_ATTRIBUTES1);
    if (portletReq.getAttribute(PortletRequest.USER_INFO) != null) {
      tr0.setTcSuccess(true);
    }
    tr0.writeTo(writer);

    /* TestCase: V2AddlRequestTests_SPEC2_11_ActionAttr_attributes2 */
    /* Details: "The PortletRequest.CCPP_PROFILE request attribute must */
    /* return a javax.ccpp.Profile based on the current portlet request" */
    TestResult tr1 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_ACTIONATTR_ATTRIBUTES2);
    if (portletReq.getAttribute(PortletRequest.CCPP_PROFILE) != null) {
      tr1.setTcSuccess(true);
    }
    tr1.writeTo(writer);

    /* TestCase: V2AddlRequestTests_SPEC2_11_ActionAttr_attributes6 */
    /* Details: "During action processing, the LIFECYCLE_PHASE */
    /* (\"javax.portlet.lifecycle_phase\") attribute will contain the */
    /* string \"ACTION_PHASE\"" */
    TestResult tr2 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_ACTIONATTR_ATTRIBUTES6);
    if (portletReq.getAttribute(PortletRequest.LIFECYCLE_PHASE).equals("ACTION_PHASE")) {
      tr2.setTcSuccess(true);
    }
    tr2.writeTo(writer);

    portletReq.getPortletSession().setAttribute(
        RESULT_ATTR_PREFIX + "AddlRequestTests_SPEC2_11_ActionAttr", writer.toString(),
        APPLICATION_SCOPE);
  }

  @Override
  public void render(RenderRequest portletReq, RenderResponse portletResp)
      throws PortletException, IOException {

    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

    PrintWriter writer = portletResp.getWriter();

    PortletSession ps = portletReq.getPortletSession();
    String msg =
        (String) ps.getAttribute(RESULT_ATTR_PREFIX + "AddlRequestTests_SPEC2_11_ActionAttr",
            APPLICATION_SCOPE);
    if (msg != null) {
      writer.write("<p>" + msg + "</p><br/>\n");
      ps.removeAttribute(RESULT_ATTR_PREFIX + "AddlRequestTests_SPEC2_11_ActionAttr",
          APPLICATION_SCOPE);
    }

    /* TestCase: V2AddlRequestTests_SPEC2_11_ActionAttr_attributes1 */
    /* Details: "The portlet can access a map with user information */
    /* attributes via the request attribute PortletRequest.USER_INFO" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(V2ADDLREQUESTTESTS_SPEC2_11_ACTIONATTR_ATTRIBUTES1, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2AddlRequestTests_SPEC2_11_ActionAttr_attributes2 */
    /* Details: "The PortletRequest.CCPP_PROFILE request attribute must */
    /* return a javax.ccpp.Profile based on the current portlet request" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(V2ADDLREQUESTTESTS_SPEC2_11_ACTIONATTR_ATTRIBUTES2, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2AddlRequestTests_SPEC2_11_ActionAttr_attributes6 */
    /* Details: "During action processing, the LIFECYCLE_PHASE */
    /* (\"javax.portlet.lifecycle_phase\") attribute will contain the */
    /* string \"ACTION_PHASE\"" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(V2ADDLREQUESTTESTS_SPEC2_11_ACTIONATTR_ATTRIBUTES6, aurl);
      tb.writeTo(writer);
    }

  }

}
