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
import javax.portlet.tck.beans.JSR286ApiTestCaseDetails;
import javax.portlet.tck.beans.TestResult;

import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_INCLUDEA1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_INCLUDEA2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_INCLUDEA3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_INCLUDEA4;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_INCLUDEB1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_INCLUDEB2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_INCLUDEB3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_INCLUDEB4;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_FORWARD1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_FORWARD2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_FORWARD3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_FORWARD4;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined
 * in the /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate
 * the test case names defined in the additionalTCs.xml file into the complete list of test case
 * names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will
 * initiate the events, but not process them. The processing is done in the companion portlet
 * EnvironmentTests_PortletRequestDispatcher_ApiRender_event
 *
 */
public class EnvironmentTests_PortletRequestDispatcher_ApiRender implements Portlet {

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

    /* TestCase: V2EnvironmentTests_PortletRequestDispatcher_ApiRender_includeA1 */
    /* Details: "Method include(PortletRequest, PortletResponse): */
    /* Includes the content of a JSP page in the response" */
    TestResult tr0 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_INCLUDEA1);
    tr0.setTcSuccess(true);
    tr0.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletRequestDispatcher_ApiRender_includeA2 */
    /* Details: "Method include(PortletRequest, PortletResponse): */
    /* Includes the content of a HTML Page in the response" */
    TestResult tr1 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_INCLUDEA2);
    tr1.setTcSuccess(true);
    tr1.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletRequestDispatcher_ApiRender_includeA3 */
    /* Details: "Method include(PortletRequest, PortletResponse): The */
    /* included servlet cannot change the status code. The attempt is */
    /* ignored" */
    TestResult tr2 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_INCLUDEA3);
    tr2.setTcSuccess(true);
    tr2.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletRequestDispatcher_ApiRender_includeA4 */
    /* Details: "Method include(PortletRequest, PortletResponse): The */
    /* included servlet cannot set the headers. The attempt is ignored" */
    TestResult tr3 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_INCLUDEA4);
    tr3.setTcSuccess(true);
    tr3.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletRequestDispatcher_ApiRender_includeB1 */
    /* Details: "Method include(RenderRequest, RenderResponse): Includes */
    /* the content of a JSP page in the response" */
    TestResult tr4 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_INCLUDEB1);
    tr4.setTcSuccess(true);
    tr4.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletRequestDispatcher_ApiRender_includeB2 */
    /* Details: "Method include(RenderRequest, RenderResponse): Includes */
    /* the content of a HTML Page in the response" */
    TestResult tr5 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_INCLUDEB2);
    tr5.setTcSuccess(true);
    tr5.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletRequestDispatcher_ApiRender_includeB3 */
    /* Details: "Method include(RenderRequest, RenderResponse): The */
    /* included servlet cannot change the status code. The attempt is */
    /* ignored" */
    TestResult tr6 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_INCLUDEB3);
    tr6.setTcSuccess(true);
    tr6.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletRequestDispatcher_ApiRender_includeB4 */
    /* Details: "Method include(RenderRequest, RenderResponse): The */
    /* included servlet cannot set the headers. The attempt is ignored" */
    TestResult tr7 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_INCLUDEB4);
    tr7.setTcSuccess(true);
    tr7.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletRequestDispatcher_ApiRender_forward1 */
    /* Details: "Method forward(PortletRequest, PortletResponse): Can */
    /* forward to a JSP page to create the response" */
    TestResult tr8 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_FORWARD1);
    tr8.setTcSuccess(true);
    tr8.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletRequestDispatcher_ApiRender_forward2 */
    /* Details: "Method forward(PortletRequest, PortletResponse): Can */
    /* forward to a HTML Page to create the response" */
    TestResult tr9 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_FORWARD2);
    tr9.setTcSuccess(true);
    tr9.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletRequestDispatcher_ApiRender_forward3 */
    /* Details: "Method forward(PortletRequest, PortletResponse): Throws */
    /* IllegalStateException if the response was already committed" */
    TestResult tr10 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_FORWARD3);
    tr10.setTcSuccess(true);
    tr10.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletRequestDispatcher_ApiRender_forward4 */
    /* Details: "Method forward(PortletRequest, PortletResponse): Throws */
    /* PortletException if the forwarded servlet throws any excpetion */
    /* other than IOException or a runtime exception " */
    TestResult tr11 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_FORWARD4);
    tr11.setTcSuccess(true);
    tr11.writeTo(writer);

  }

}
