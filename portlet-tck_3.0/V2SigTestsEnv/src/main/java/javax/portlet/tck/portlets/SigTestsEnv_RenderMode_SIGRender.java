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
import javax.portlet.tck.beans.ClassChecker;
import javax.portlet.tck.beans.JSR286SignatureTestCaseDetails;
import javax.portlet.tck.beans.TestResult;

import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_RENDERMODE_SIGRENDER_HASNAME;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_RENDERMODE_SIGRENDER_HASNAMERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_RENDERMODE_SIGRENDER_ISANNOTATION;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined
 * in the /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate
 * the test case names defined in the additionalTCs.xml file into the complete list of test case
 * names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will
 * initiate the events, but not process them. The processing is done in the companion portlet
 * SigTestsEnv_RenderMode_SIGRender_event
 *
 */
public class SigTestsEnv_RenderMode_SIGRender implements Portlet {

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

    JSR286SignatureTestCaseDetails tcd = new JSR286SignatureTestCaseDetails();

    // Create result objects for the tests

    ClassChecker cc = new ClassChecker(javax.portlet.RenderMode.class);

    /* TestCase: V2SigTestsEnv_RenderMode_SIGRender_hasName */
    /* Details: "RenderMode has a name()  method " */
    TestResult tr0 = tcd.getTestResultFailed(V2SIGTESTSENV_RENDERMODE_SIGRENDER_HASNAME);
    try {
      String name = "name";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr0.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr0.appendTcDetail(e.toString());
    }
    tr0.writeTo(writer);

    /* TestCase: V2SigTestsEnv_RenderMode_SIGRender_hasNameReturns */
    /* Details: "RenderMode method name() returns String " */
    TestResult tr1 = tcd.getTestResultFailed(V2SIGTESTSENV_RENDERMODE_SIGRENDER_HASNAMERETURNS);
    try {
      String name = "name";
      Class<?> retType = String.class;
      Class<?>[] parms = null;
      tr1.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr1.appendTcDetail(e.toString());
    }
    tr1.writeTo(writer);

    /* TestCase: V2SigTestsEnv_RenderMode_SIGRender_isAnnotation */
    /* Details: "RenderMode is an Annotation " */
    TestResult tr2 = tcd.getTestResultFailed(V2SIGTESTSENV_RENDERMODE_SIGRENDER_ISANNOTATION);
    try {
      tr2.setTcSuccess(cc.isAnnotation());
    } catch (Exception e) {
      tr2.appendTcDetail(e.toString());
    }
    tr2.writeTo(writer);

  }

}
