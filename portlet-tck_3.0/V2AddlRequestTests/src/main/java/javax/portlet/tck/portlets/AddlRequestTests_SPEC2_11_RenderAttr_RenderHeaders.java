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
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.tck.beans.JSR286SpecTestCaseDetails;
import javax.portlet.tck.beans.TestResult;

import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLREQUESTTESTS_SPEC2_11_RENDERATTR_ATTRIBUTES3;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLREQUESTTESTS_SPEC2_11_RENDERATTR_ATTRIBUTES4;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLREQUESTTESTS_SPEC2_11_RENDERATTR_ATTRIBUTES5;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined
 * in the /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate
 * the test case names defined in the additionalTCs.xml file into the complete list of test case
 * names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will
 * initiate the events, but not process them. The processing is done in the companion portlet
 * AddlRequestTests_SPEC2_11_RenderAttr_event
 * 
 * @author ahmed
 */
public class AddlRequestTests_SPEC2_11_RenderAttr_RenderHeaders implements Portlet {

  private static final String NON_STREAMING_BUFFERED_PORTAL_DETECTED =
      "<em>NON-STREAMING (BUFFERED) PORTAL DETECTED</em>";

  private Boolean successTr3 = false;

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
    Object renderPartAttribute = portletReq.getAttribute(PortletRequest.RENDER_PART);
    boolean streamingPortal = (renderPartAttribute != null);

    /* TestCase: V2AddlRequestTests_SPEC2_11_RenderAttr_attributes3 */
    /* Details: "If the portlet container runtime option */
    /* javax.portlet.renderHeaders is set to TRUE, the RENDER_PART */
    /* attribute will be set when the render method is called" */
    TestResult tr2 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_RENDERATTR_ATTRIBUTES3);
    if (!streamingPortal || "RENDER_MARKUP".equals(renderPartAttribute)) {
      tr2.setTcSuccess(true);
      if (!streamingPortal) {
        tr2.setTcDetail(NON_STREAMING_BUFFERED_PORTAL_DETECTED);
      }
      tr2.writeTo(writer);
    }

    /* TestCase: V2AddlRequestTests_SPEC2_11_RenderAttr_attributes4 */
    /* Details: "If the portlet container runtime option */
    /* javax.portlet.renderHeaders is set to TRUE, render method will be */
    /* called first with the RENDER_PART attribute set to */
    /* \"RENDER_HEADERS\"" */
    TestResult tr3 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_RENDERATTR_ATTRIBUTES4);
    if (streamingPortal) {
      if ("RENDER_HEADERS".equals(renderPartAttribute)) {
        successTr3 = true;
      }
      else if ("RENDER_MARKUP".equals(renderPartAttribute)) {
        tr3.setTcSuccess(successTr3);
        tr3.writeTo(writer);
      }
    }
    else {
      tr3.setTcSuccess(true);
      tr3.setTcDetail(NON_STREAMING_BUFFERED_PORTAL_DETECTED);
      tr3.writeTo(writer);
    }

    /* TestCase: V2AddlRequestTests_SPEC2_11_RenderAttr_attributes5 */
    /* Details: "If the portlet container runtime option */
    /* javax.portlet.renderHeaders is set to TRUE, render method will be */
    /* called a second time with the RENDER_PART attribute set to */
    /* \"RENDER_MARKUP\"" */
    TestResult tr4 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_RENDERATTR_ATTRIBUTES5);
    if (!streamingPortal || "RENDER_MARKUP".equals(renderPartAttribute)) {
      tr4.setTcSuccess(true);
      if (!streamingPortal) {
        tr4.setTcDetail(NON_STREAMING_BUFFERED_PORTAL_DETECTED);
      }
      tr4.writeTo(writer);
    }

  }
}
