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
import javax.portlet.tck.beans.JSR286SpecTestCaseDetails;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.beans.TestSetupLink;

import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PARAMETERS11;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined
 * in the /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate
 * the test case names defined in the additionalTCs.xml file into the complete list of test case
 * names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will
 * initiate the events, but not process them. The processing is done in the companion portlet
 * AddlRequestTests_SPEC2_11_Render_event
 * 
 * @author ahmed
 */
public class AddlRequestTests_SPEC2_11_Render_parameter11 implements Portlet {

  @Override
  public void init(PortletConfig config) throws PortletException {}

  @Override
  public void destroy() {}

  @Override
  public void processAction(ActionRequest portletReq, ActionResponse portletResp)
      throws PortletException, IOException {
    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

  }

  @Override
  public void render(RenderRequest portletReq, RenderResponse portletResp)
      throws PortletException, IOException {

    JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();

    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

    PrintWriter writer = portletResp.getWriter();

    /* TestCase: V2AddlRequestTests_SPEC2_11_Render_parameters11 */
    /* Details: "If a portlet receives a render request that is the */
    /* result of a client request targeted to another portlet in the */
    /* portal page, the parameters should be the same parameters as of */
    /* the previous render request from this client" */
    if (portletReq.getParameter("tr1") == null) {
      PortletURL rurl = portletResp.createRenderURL();
      rurl.setParameters(portletReq.getPrivateParameterMap());
      rurl.setParameter("tr1", "true");
      TestSetupLink tb = new TestSetupLink(V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PARAMETERS11, rurl);
      tb.writeTo(writer);
    } else {
      TestResult tr1 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PARAMETERS11);
      if (portletReq.getParameter("tr1_ready") != null
          && portletReq.getParameter("tr1_ready").equals("true")) {
        /* TestCase: V2AddlRequestTests_SPEC2_11_Render_parameters11 */
        /* Details: "If a portlet receives a render request that is the */
        /* result of a client request targeted to another portlet in the */
        /* portal page, the parameters should be the same parameters as of */
        /* the previous render request from this client" */
        if (portletReq.getParameter("tr1") != null
            && portletReq.getParameter("tr1").equals("true")) {
          tr1.setTcSuccess(true);
        } else {
          tr1.appendTcDetail(
              "Test case failed as render parameter of this client didn't remain same after recieving render request from another portlet");
        }
      } else {
        tr1.appendTcDetail(
            "Test case failed as public parameter tr1_ready is not set by V2AddlRequestTests_SPEC2_11_Render portlet");
      }
      tr1.writeTo(writer);
    }
  }
}
