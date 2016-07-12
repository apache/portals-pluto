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
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.tck.beans.JSR286SpecTestCaseDetails;
import javax.portlet.tck.beans.TestResult;

import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_2_COMPATIBILITY_DEPLOYJSR168_1;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_2_COMPATIBILITY_DEPLOYJSR168_2;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined
 * in the /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate
 * the test case names defined in the additionalTCs.xml file into the complete list of test case
 * names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will
 * initiate the events, but not process them. The processing is done in the companion portlet
 * AddlPortletTests_SPEC2_2_Compatibility_event
 * 
 * @author ahmed
 */
public class AddlPortletTests_SPEC2_2_Compatibility implements Portlet {

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

    /* TestCase: V2AddlPortletTests_SPEC2_2_Compatibility_deployJSR168_1 */
    /* Details: "A portlet with the JSR 168 deployment descriptor can be */
    /* deployed" */
    TestResult tr0 =
        tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_2_COMPATIBILITY_DEPLOYJSR168_1);
    // The deployment descriptor of this portlet is of JSR168 format. If the execution reaches here
    // then test is successful.
    tr0.setTcSuccess(true);
    tr0.writeTo(writer);

    /* TestCase: V2AddlPortletTests_SPEC2_2_Compatibility_deployJSR168_2 */
    /* Details: "A portlet implementing only the JSR 168 API can be */
    /* deployed" */
    TestResult tr1 =
        tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_2_COMPATIBILITY_DEPLOYJSR168_2);
    // The code of this class is compatible with JSR 168 API. If this executes then test is
    // successful.
    tr1.setTcSuccess(true);
    tr1.writeTo(writer);

  }

}
