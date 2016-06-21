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
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ValidatorException;
import javax.portlet.tck.beans.JSR286ApiTestCaseDetails;
import javax.portlet.tck.beans.TestResult;

import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2EXCEPTIONTESTS_VALIDATOREXCEPTION_APIRENDER_CONSTRUCTOR2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2EXCEPTIONTESTS_VALIDATOREXCEPTION_APIRENDER_CONSTRUCTOR4;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2EXCEPTIONTESTS_VALIDATOREXCEPTION_APIRENDER_CONSTRUCTOR6;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2EXCEPTIONTESTS_VALIDATOREXCEPTION_APIRENDER_GETFAILEDKEYS1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2EXCEPTIONTESTS_VALIDATOREXCEPTION_APIRENDER_GETFAILEDKEYS2;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;


/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined
 * in the /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate
 * the test case names defined in the additionalTCs.xml file into the complete list of test case
 * names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will
 * initiate the events, but not process them. The processing is done in the companion portlet
 * ExceptionTests_ValidatorException_ApiRender_event
 *
 */
public class ExceptionTests_ValidatorException_ApiRender implements Portlet {

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

    /* TestCase: V2ExceptionTests_ValidatorException_ApiRender_constructor2 */
    /* Details: "For ValidatorException(java.lang.String, */
    /* java.util.Collection&lt;java.lang.String&gt;), the failedKeys */
    /* parameter may be null" */
    TestResult tr0 =
        tcd.getTestResultFailed(V2EXCEPTIONTESTS_VALIDATOREXCEPTION_APIRENDER_CONSTRUCTOR2);
    ValidatorException ve = new ValidatorException("TestException", null);
    if (ve.getMessage().equals("TestException")) {
      tr0.setTcSuccess(true);
    }
    tr0.writeTo(writer);

    /* TestCase: V2ExceptionTests_ValidatorException_ApiRender_constructor4 */
    /* Details: "For ValidatorException(java.lang.String, */
    /* java.lang.Throwable, */
    /* java.util.Collection&lt;java.lang.String&gt;), the failedKeys */
    /* parameter may be null" */
    TestResult tr1 =
        tcd.getTestResultFailed(V2EXCEPTIONTESTS_VALIDATOREXCEPTION_APIRENDER_CONSTRUCTOR4);
    Throwable tw = new Throwable("TestThrow");
    ValidatorException ve1 = new ValidatorException("TestException1", tw, null);
    if (ve1.getMessage().equals("TestException1")) {
      tr1.setTcSuccess(true);
    }
    tr1.writeTo(writer);

    /* TestCase: V2ExceptionTests_ValidatorException_ApiRender_constructor6 */
    /* Details: "For ValidatorException(java.lang.Throwable, */
    /* java.util.Collection&lt;java.lang.String&gt;), the failedKeys */
    /* parameter may be null" */
    TestResult tr2 =
        tcd.getTestResultFailed(V2EXCEPTIONTESTS_VALIDATOREXCEPTION_APIRENDER_CONSTRUCTOR6);
    Throwable tw1 = new Throwable("TestThrow1");
    ValidatorException ve2 = new ValidatorException(tw1, null);
    if (ve2.getMessage().contains("TestThrow1")) {
      tr2.setTcSuccess(true);
    }
    tr2.writeTo(writer);

    /* TestCase: V2ExceptionTests_ValidatorException_ApiRender_getFailedKeys1 */
    /* Details: "Method getFailedKeys(): Returns a */
    /* java.util.Enumeration&lt;java.lang.String&gt; object containing */
    /* the preference keys that failed validation" */
    TestResult tr3 =
        tcd.getTestResultFailed(V2EXCEPTIONTESTS_VALIDATOREXCEPTION_APIRENDER_GETFAILEDKEYS1);
    tr3.setTcSuccess(true);
    tr3.appendTcDetail("There are no Preference Keys that Failed Validation in this Test Portlet.");
    tr3.writeTo(writer);

    /* TestCase: V2ExceptionTests_ValidatorException_ApiRender_getFailedKeys2 */
    /* Details: "Method getFailedKeys(): Returns an empty enmueration if */
    /* no failed keys are available" */
    TestResult tr4 =
        tcd.getTestResultFailed(V2EXCEPTIONTESTS_VALIDATOREXCEPTION_APIRENDER_GETFAILEDKEYS2);
    Enumeration<?> eu = ve1.getFailedKeys();
    List<?> li = Collections.list(eu);
    if (li.isEmpty()) {
      tr4.setTcSuccess(true);
    }
    tr4.writeTo(writer);
  }

}
