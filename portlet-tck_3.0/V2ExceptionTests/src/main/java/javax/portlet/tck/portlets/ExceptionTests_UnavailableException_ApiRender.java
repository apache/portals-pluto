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
import javax.portlet.UnavailableException;
import javax.portlet.tck.beans.JSR286ApiTestCaseDetails;
import javax.portlet.tck.beans.TestResult;

import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2EXCEPTIONTESTS_UNAVAILABLEEXCEPTION_APIRENDER_ISPERMANENT1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2EXCEPTIONTESTS_UNAVAILABLEEXCEPTION_APIRENDER_ISPERMANENT2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2EXCEPTIONTESTS_UNAVAILABLEEXCEPTION_APIRENDER_ISPERMANENT3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2EXCEPTIONTESTS_UNAVAILABLEEXCEPTION_APIRENDER_GETUNAVAILABLESECONDS1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2EXCEPTIONTESTS_UNAVAILABLEEXCEPTION_APIRENDER_GETUNAVAILABLESECONDS2;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined
 * in the /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate
 * the test case names defined in the additionalTCs.xml file into the complete list of test case
 * names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will
 * initiate the events, but not process them. The processing is done in the companion portlet
 * ExceptionTests_UnavailableException_ApiRender_event
 *
 */
public class ExceptionTests_UnavailableException_ApiRender implements Portlet {

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

    UnavailableException uae = new UnavailableException("Testing unavailable Exception", 10);

    /* TestCase: V2ExceptionTests_UnavailableException_ApiRender_isPermanent1 */
    /* Details: "Method isPermanent(): Returns a boolean" */
    TestResult tr0 =
        tcd.getTestResultFailed(V2EXCEPTIONTESTS_UNAVAILABLEEXCEPTION_APIRENDER_ISPERMANENT1);
    boolean bpt = uae.isPermanent();
    if (bpt == false) {
      tr0.setTcSuccess(true);
    }
    tr0.writeTo(writer);

    /* TestCase: V2ExceptionTests_UnavailableException_ApiRender_isPermanent2 */
    /* Details: "Method isPermanent(): Returns true if the portlet is */
    /* permanently unavailable " */
    TestResult tr1 =
        tcd.getTestResultFailed(V2EXCEPTIONTESTS_UNAVAILABLEEXCEPTION_APIRENDER_ISPERMANENT2);
    tr1.setTcSuccess(true);
    tr1.appendTcDetail("This Method could not be tested if the portlet is available");
    tr1.writeTo(writer);

    /* TestCase: V2ExceptionTests_UnavailableException_ApiRender_isPermanent3 */
    /* Details: "Method isPermanent(): Returns false if the portlet is */
    /* temporarily unavailable " */
    TestResult tr2 =
        tcd.getTestResultFailed(V2EXCEPTIONTESTS_UNAVAILABLEEXCEPTION_APIRENDER_ISPERMANENT3);
    boolean bpf = uae.isPermanent();
    if (bpf == false) {
      tr2.setTcSuccess(true);
    }
    tr2.writeTo(writer);

    /* TestCase: V2ExceptionTests_UnavailableException_ApiRender_getUnavailableSeconds1 */
    /* Details: "Method getUnavailableSeconds(): Returns an integer " */
    TestResult tr3 = tcd.getTestResultFailed(
        V2EXCEPTIONTESTS_UNAVAILABLEEXCEPTION_APIRENDER_GETUNAVAILABLESECONDS1);
    int getsec = uae.getUnavailableSeconds();
    if (getsec == 10) {
      tr3.setTcSuccess(true);
    }
    tr3.writeTo(writer);

    /* TestCase: V2ExceptionTests_UnavailableException_ApiRender_getUnavailableSeconds2 */
    /* Details: "Method getUnavailableSeconds(): Returns a number &lt;= 0 */
    /* if the portlet is permanently unavailable" */
    TestResult tr4 = tcd.getTestResultFailed(
        V2EXCEPTIONTESTS_UNAVAILABLEEXCEPTION_APIRENDER_GETUNAVAILABLESECONDS2);
    tr4.setTcSuccess(true);
    tr4.appendTcDetail(
        "This Method could not be tested for this Test Portlets which cannot be unavailable permanently");
    tr4.writeTo(writer);

  }

}
