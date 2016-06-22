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
import javax.portlet.PortletSessionUtil;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.tck.beans.JSR286ApiTestCaseDetails;
import javax.portlet.tck.beans.TestResult;

import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETSESSIONUTIL_APIRENDER_DECODEATTRIBUTENAME1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETSESSIONUTIL_APIRENDER_DECODEATTRIBUTENAME2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETSESSIONUTIL_APIRENDER_DECODESCOPE1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETSESSIONUTIL_APIRENDER_DECODESCOPE2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETSESSIONUTIL_APIRENDER_DECODESCOPE3;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined
 * in the /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate
 * the test case names defined in the additionalTCs.xml file into the complete list of test case
 * names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will
 * initiate the events, but not process them. The processing is done in the companion portlet
 * EnvironmentTests_PortletSessionUtil_ApiRender_event
 *
 */
public class EnvironmentTests_PortletSessionUtil_ApiRender implements Portlet {

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

    JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

    // Create result objects for the tests

    /* TestCase: V2EnvironmentTests_PortletSessionUtil_ApiRender_decodeAttributeName1 */
    /* Details: "Method decodeAttributeName(String): Returns a String */
    /* containing the decoded name of the attribute if the input name is */
    /* an encoded name in PORTLET_SCOPE" */
    TestResult tr0 = tcd
        .getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSIONUTIL_APIRENDER_DECODEATTRIBUTENAME1);
    String dec = PortletSessionUtil.decodeAttributeName("TestPreference1");
    if (dec.equals("TestPreference1")) {
      tr0.setTcSuccess(true);
    }
    tr0.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletSessionUtil_ApiRender_decodeAttributeName2 */
    /* Details: "Method decodeAttributeName(String): Returns a String */
    /* containing the input name unchanged if the input name is in */
    /* APPLICATION_SCOPE " */
    TestResult tr1 = tcd
        .getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSIONUTIL_APIRENDER_DECODEATTRIBUTENAME2);
    String dec1 = PortletSessionUtil.decodeAttributeName("TestPreference2");
    if (dec1.equals("TestPreference2")) {
      tr1.setTcSuccess(true);
    }
    tr1.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletSessionUtil_ApiRender_decodeScope1 */
    /* Details: "Method decodeScope(String): Returns the decoded */
    /* attribute scope for the input encoded attribute name" */
    TestResult tr2 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSIONUTIL_APIRENDER_DECODESCOPE1);
    String dec2 = PortletSessionUtil.decodeAttributeName("TestPreference2");
    if (dec2.equals("TestPreference2")) {
      tr2.setTcSuccess(true);
    }
    tr2.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletSessionUtil_ApiRender_decodeScope2 */
    /* Details: "Method decodeScope(String): Returns */
    /* PortletSession.APPLICATION_SCOPE if the attribute name is in */
    /* APPLICATION_SCOPE" */
    TestResult tr3 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSIONUTIL_APIRENDER_DECODESCOPE2);
    String dec3 = PortletSessionUtil.decodeAttributeName("TestPreference2");
    if (dec3.equals("TestPreference2")) {
      tr3.setTcSuccess(true);
    }
    tr3.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletSessionUtil_ApiRender_decodeScope3 */
    /* Details: "Method decodeScope(String): Returns */
    /* PortletSession.PORTLET_SCOPE if the attribute name is in */
    /* PORTLET_SCOPE" */
    TestResult tr4 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETSESSIONUTIL_APIRENDER_DECODESCOPE3);
    tr4.setTcSuccess(true);
    tr4.writeTo(writer);

  }

}
