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
import javax.portlet.filter.RenderRequestWrapper;
import javax.portlet.tck.beans.ClassChecker;
import javax.portlet.tck.beans.JSR286SignatureTestCaseDetails;
import javax.portlet.tck.beans.TestResult;

import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RENDERREQUESTWRAPPER_SIGRENDER_CONSTRUCTOR;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RENDERREQUESTWRAPPER_SIGRENDER_HASGETETAG;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RENDERREQUESTWRAPPER_SIGRENDER_HASGETETAGRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RENDERREQUESTWRAPPER_SIGRENDER_HASGETREQUEST;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RENDERREQUESTWRAPPER_SIGRENDER_HASGETREQUESTA;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RENDERREQUESTWRAPPER_SIGRENDER_HASGETREQUESTRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RENDERREQUESTWRAPPER_SIGRENDER_HASGETREQUESTRETURNSA;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RENDERREQUESTWRAPPER_SIGRENDER_HASSETREQUEST;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RENDERREQUESTWRAPPER_SIGRENDER_HASSETREQUESTRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RENDERREQUESTWRAPPER_SIGRENDER_IMPLEMENTSRENDERREQUEST;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined
 * in the /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate
 * the test case names defined in the additionalTCs.xml file into the complete list of test case
 * names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will
 * initiate the events, but not process them. The processing is done in the companion portlet
 * SigTestsWrapper_RenderRequestWrapper_SIGRender_event
 *
 */
public class SigTestsWrapper_RenderRequestWrapper_SIGRender implements Portlet {

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

    ClassChecker cc = new ClassChecker(RenderRequestWrapper.class);

    /* TestCase: V2SigTestsWrapper_RenderRequestWrapper_SIGRender_constructor */
    /* Details: "RenderRequestWrapper provides constructor */
    /* RenderRequestWrapper(RenderRequest) " */
    TestResult tr0 =
        tcd.getTestResultFailed(V2SIGTESTSWRAPPER_RENDERREQUESTWRAPPER_SIGRENDER_CONSTRUCTOR);
    try {
      Class<?>[] parms = {RenderRequest.class};
      tr0.setTcSuccess(cc.hasConstructor(parms));
    } catch (Exception e) {
      tr0.appendTcDetail(e.toString());
    }
    tr0.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_RenderRequestWrapper_SIGRender_hasGetETag */
    /* Details: "RenderRequestWrapper has a getETag()  method " */
    TestResult tr2 =
        tcd.getTestResultFailed(V2SIGTESTSWRAPPER_RENDERREQUESTWRAPPER_SIGRENDER_HASGETETAG);
    try {
      String name = "getETag";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr2.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr2.appendTcDetail(e.toString());
    }
    tr2.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_RenderRequestWrapper_SIGRender_hasGetETagReturns */
    /* Details: "RenderRequestWrapper method getETag() returns String " */
    TestResult tr3 =
        tcd.getTestResultFailed(V2SIGTESTSWRAPPER_RENDERREQUESTWRAPPER_SIGRENDER_HASGETETAGRETURNS);
    try {
      String name = "getETag";
      Class<?> retType = String.class;
      Class<?>[] parms = null;
      tr3.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr3.appendTcDetail(e.toString());
    }
    tr3.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_RenderRequestWrapper_SIGRender_hasGetRequest */
    /* Details: "RenderRequestWrapper has a getRequest()  method " */
    TestResult tr4 =
        tcd.getTestResultFailed(V2SIGTESTSWRAPPER_RENDERREQUESTWRAPPER_SIGRENDER_HASGETREQUEST);
    try {
      String name = "getRequest";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr4.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr4.appendTcDetail(e.toString());
    }
    tr4.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_RenderRequestWrapper_SIGRender_hasGetRequestA */
    /* Details: "RenderRequestWrapper has a getRequest()  method " */
    TestResult tr5 =
        tcd.getTestResultFailed(V2SIGTESTSWRAPPER_RENDERREQUESTWRAPPER_SIGRENDER_HASGETREQUESTA);
    try {
      String name = "getRequest";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr5.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr5.appendTcDetail(e.toString());
    }
    tr5.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_RenderRequestWrapper_SIGRender_hasGetRequestReturns */
    /* Details: "RenderRequestWrapper method getRequest() returns */
    /* RenderRequest " */
    TestResult tr6 = tcd
        .getTestResultFailed(V2SIGTESTSWRAPPER_RENDERREQUESTWRAPPER_SIGRENDER_HASGETREQUESTRETURNS);
    try {
      String name = "getRequest";
      Class<?> retType = RenderRequest.class;
      Class<?>[] parms = null;
      tr6.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr6.appendTcDetail(e.toString());
    }
    tr6.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_RenderRequestWrapper_SIGRender_hasGetRequestReturnsA */
    /* Details: "RenderRequestWrapper method getRequest() returns */
    /* PortletRequest " */
    TestResult tr7 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_RENDERREQUESTWRAPPER_SIGRENDER_HASGETREQUESTRETURNSA);
    try {
      String name = "getRequest";
      Class<?> retType = PortletRequest.class;
      Class<?>[] parms = null;
      tr7.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr7.appendTcDetail(e.toString());
    }
    tr7.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_RenderRequestWrapper_SIGRender_hasSetRequest */
    /* Details: "RenderRequestWrapper has a setRequest(RenderRequest) */
    /* method " */
    TestResult tr8 =
        tcd.getTestResultFailed(V2SIGTESTSWRAPPER_RENDERREQUESTWRAPPER_SIGRENDER_HASSETREQUEST);
    try {
      String name = "setRequest";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {RenderRequest.class};
      tr8.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr8.appendTcDetail(e.toString());
    }
    tr8.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_RenderRequestWrapper_SIGRender_hasSetRequestReturns */
    /* Details: "RenderRequestWrapper method setRequest(RenderRequest) */
    /* returns void " */
    TestResult tr9 = tcd
        .getTestResultFailed(V2SIGTESTSWRAPPER_RENDERREQUESTWRAPPER_SIGRENDER_HASSETREQUESTRETURNS);
    try {
      String name = "setRequest";
      Class<?> retType = void.class;
      Class<?>[] parms = {RenderRequest.class};
      tr9.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr9.appendTcDetail(e.toString());
    }
    tr9.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_RenderRequestWrapper_SIGRender_implementsRenderRequest */
    /* Details: "RenderRequestWrapper implements RenderRequest " */
    TestResult tr10 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_RENDERREQUESTWRAPPER_SIGRENDER_IMPLEMENTSRENDERREQUEST);
    try {
      tr10.setTcSuccess(cc.implementsInterface(RenderRequest.class));
    } catch (Exception e) {
      tr10.appendTcDetail(e.toString());
    }
    tr10.writeTo(writer);

  }

}
