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

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;
import javax.portlet.tck.beans.JSR286SpecTestCaseDetails;
import javax.portlet.tck.beans.TestResult;

import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_9_WINDOWSTATES_DECLARINGWINDOWSTATES1;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_9_WINDOWSTATES_DECLARINGWINDOWSTATES2;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_9_WINDOWSTATES_DECLARINGWINDOWSTATES3;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_9_WINDOWSTATES_DECLARINGWINDOWSTATES5;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_9_WINDOWSTATES_DECLARINGWINDOWSTATES6;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_9_WINDOWSTATES_DECLARINGWINDOWSTATES7;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined
 * in the /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate
 * the test case names defined in the additionalTCs.xml file into the complete list of test case
 * names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will
 * initiate the events, but not process them. The processing is done in the companion portlet
 * AddlPortletTests_SPEC2_9_WindowStates_event
 * 
 * @author ahmed
 */
public class AddlPortletTests_SPEC2_9_WindowStates implements Portlet {

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


  }

  @Override
  public void render(RenderRequest portletReq, RenderResponse portletResp)
      throws PortletException, IOException {

    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

    PrintWriter writer = portletResp.getWriter();

    JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();

    // Create result objects for the tests

    /* TestCase: V2AddlPortletTests_SPEC2_9_WindowStates_declaringWindowStates1 */
    /* Details: "Support for the NORMAL window state does not need to be */
    /* declared in the deployment descriptor" */
    TestResult tr0 =
        tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_9_WINDOWSTATES_DECLARINGWINDOWSTATES1);
    try {
      tr0.setTcSuccess(portletReq.isWindowStateAllowed(WindowState.NORMAL));
    } catch (Exception e) {
      tr0.appendTcDetail(e.toString());
    }
    tr0.writeTo(writer);

    /* TestCase: V2AddlPortletTests_SPEC2_9_WindowStates_declaringWindowStates2 */
    /* Details: "Support for the MINIMIZED window state does not need to */
    /* be declared in the deployment descriptor" */
    TestResult tr1 =
        tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_9_WINDOWSTATES_DECLARINGWINDOWSTATES2);
    if (portletReq.isWindowStateAllowed(WindowState.MINIMIZED)) {
      tr1.setTcSuccess(true);
    } else {
      tr1.appendTcDetail("Failed because window state MINIMIZED is not allowed");
    }
    tr1.writeTo(writer);

    /* TestCase: V2AddlPortletTests_SPEC2_9_WindowStates_declaringWindowStates3 */
    /* Details: "Support for the MAXIMIZED window state does not need to */
    /* be declared in the deployment descriptor" */
    TestResult tr2 =
        tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_9_WINDOWSTATES_DECLARINGWINDOWSTATES3);
    if (portletReq.isWindowStateAllowed(WindowState.MAXIMIZED)) {
      tr2.setTcSuccess(true);
    } else {
      tr2.appendTcDetail("Failed because window state MAXIMIZED is not allowed");
    }
    tr2.writeTo(writer);

    /* TestCase: V2AddlPortletTests_SPEC2_9_WindowStates_declaringWindowStates5 */
    /* Details: "The PortletRequest.isWindowStateAllowed method must */
    /* return FALSE for a custom window state that is not supported by */
    /* the portlet container" */
    TestResult tr4 =
        tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_9_WINDOWSTATES_DECLARINGWINDOWSTATES5);
    if (!portletReq.isWindowStateAllowed(new WindowState("custom_window"))) {
      tr4.setTcSuccess(true);
    } else {
      tr4.appendTcDetail("Failed because window state custom_window is allowed");
    }
    tr4.writeTo(writer);

    /* TestCase: V2AddlPortletTests_SPEC2_9_WindowStates_declaringWindowStates6 */
    /* Details: "The portlet container must ignore all custom window */
    /* states in the deployment descriptor that are not supported by the */
    /* portal" */
    TestResult tr5 =
        tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_9_WINDOWSTATES_DECLARINGWINDOWSTATES6);
    if (!portletReq.isWindowStateAllowed(new WindowState("custom_window"))) {
      tr5.setTcSuccess(true);
    } else {
      tr5.appendTcDetail("Failed because window state custom_window is allowed");
    }
    tr5.writeTo(writer);

    /* TestCase: V2AddlPortletTests_SPEC2_9_WindowStates_declaringWindowStates7 */
    /* Details: "The portlet must not be invoked in a window state other */
    /* than NORMAL, MINIMIZED, or MAXIMIZED that has not been declared to */
    /* be supported for a given markup type" */
    TestResult tr6 =
        tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_9_WINDOWSTATES_DECLARINGWINDOWSTATES7);
    try {
      PortletURL rurl = portletResp.createRenderURL();
      rurl.setWindowState(new WindowState("custom_window2"));
      tr6.appendTcDetail(
          "Failed because window state custom_window2 is set but has not been declared to be supported for this portlet.");
    } catch (WindowStateException e) {
      tr6.appendTcDetail(e.toString());
      tr6.setTcSuccess(true);
    }
    tr6.writeTo(writer);

  }

}
