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
import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.PortletResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;
import javax.portlet.filter.ActionResponseWrapper;
import javax.portlet.tck.beans.ClassChecker;
import javax.portlet.tck.beans.JSR286SignatureTestCaseDetails;
import javax.portlet.tck.beans.TestResult;

import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_CONSTRUCTOR;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASGETPORTLETMODE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASGETPORTLETMODERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASGETRENDERPARAMETERMAP;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASGETRENDERPARAMETERMAPRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASGETRESPONSE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASGETRESPONSEA;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASGETRESPONSERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASGETRESPONSERETURNSA;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASGETWINDOWSTATE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASGETWINDOWSTATERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASREMOVEPUBLICRENDERPARAMETER;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASREMOVEPUBLICRENDERPARAMETERRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSENDREDIRECT;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSENDREDIRECTA;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSENDREDIRECTRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSENDREDIRECTRETURNSA;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSETEVENT;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSETEVENTA;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSETEVENTRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSETEVENTRETURNSA;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSETPORTLETMODE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSETPORTLETMODERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSETRENDERPARAMETER;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSETRENDERPARAMETERA;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSETRENDERPARAMETERRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSETRENDERPARAMETERRETURNSA;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSETRENDERPARAMETERS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSETRENDERPARAMETERSRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSETRESPONSE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSETRESPONSERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSETWINDOWSTATE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSETWINDOWSTATERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_IMPLEMENTSACTIONRESPONSE;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined
 * in the /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate
 * the test case names defined in the additionalTCs.xml file into the complete list of test case
 * names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will
 * initiate the events, but not process them. The processing is done in the companion portlet
 * SigTestsWrapper_ActionResponseWrapper_SIGRender_event
 *
 */
public class SigTestsWrapper_ActionResponseWrapper_SIGRender implements Portlet {

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

    ClassChecker cc = new ClassChecker(ActionResponseWrapper.class);

    /* TestCase: V2SigTestsWrapper_ActionResponseWrapper_SIGRender_constructor */
    /* Details: "ActionResponseWrapper provides constructor */
    /* ActionResponseWrapper(ActionResponse) " */
    TestResult tr0 =
        tcd.getTestResultFailed(V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_CONSTRUCTOR);
    try {
      Class<?>[] parms = {ActionResponse.class};
      tr0.setTcSuccess(cc.hasConstructor(parms));
    } catch (Exception e) {
      tr0.appendTcDetail(e.toString());
    }
    tr0.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ActionResponseWrapper_SIGRender_hasGetPortletMode */
    /* Details: "ActionResponseWrapper has a getPortletMode()  method " */
    TestResult tr2 = tcd
        .getTestResultFailed(V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASGETPORTLETMODE);
    try {
      String name = "getPortletMode";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr2.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr2.appendTcDetail(e.toString());
    }
    tr2.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ActionResponseWrapper_SIGRender_hasGetPortletModeReturns */
    /* Details: "ActionResponseWrapper method getPortletMode() returns */
    /* PortletMode " */
    TestResult tr3 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASGETPORTLETMODERETURNS);
    try {
      String name = "getPortletMode";
      Class<?> retType = PortletMode.class;
      Class<?>[] parms = null;
      tr3.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr3.appendTcDetail(e.toString());
    }
    tr3.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ActionResponseWrapper_SIGRender_hasGetRenderParameterMap */
    /* Details: "ActionResponseWrapper has a getRenderParameterMap() */
    /* method " */
    TestResult tr4 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASGETRENDERPARAMETERMAP);
    try {
      String name = "getRenderParameterMap";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr4.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr4.appendTcDetail(e.toString());
    }
    tr4.writeTo(writer);

    /*
     * TestCase: V2SigTestsWrapper_ActionResponseWrapper_SIGRender_hasGetRenderParameterMapReturns
     */
    /* Details: "ActionResponseWrapper method getRenderParameterMap() */
    /* returns java.util.Map " */
    TestResult tr5 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASGETRENDERPARAMETERMAPRETURNS);
    try {
      String name = "getRenderParameterMap";
      Class<?> retType = java.util.Map.class;
      Class<?>[] parms = null;
      tr5.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr5.appendTcDetail(e.toString());
    }
    tr5.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ActionResponseWrapper_SIGRender_hasGetResponse */
    /* Details: "ActionResponseWrapper has a getResponse()  method " */
    TestResult tr6 =
        tcd.getTestResultFailed(V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASGETRESPONSE);
    try {
      String name = "getResponse";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr6.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr6.appendTcDetail(e.toString());
    }
    tr6.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ActionResponseWrapper_SIGRender_hasGetResponseA */
    /* Details: "ActionResponseWrapper has a getResponse()  method " */
    TestResult tr7 =
        tcd.getTestResultFailed(V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASGETRESPONSEA);
    try {
      String name = "getResponse";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr7.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr7.appendTcDetail(e.toString());
    }
    tr7.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ActionResponseWrapper_SIGRender_hasGetResponseReturns */
    /* Details: "ActionResponseWrapper method getResponse() returns */
    /* ActionResponse " */
    TestResult tr8 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASGETRESPONSERETURNS);
    try {
      String name = "getResponse";
      Class<?> retType = ActionResponse.class;
      Class<?>[] parms = null;
      tr8.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr8.appendTcDetail(e.toString());
    }
    tr8.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ActionResponseWrapper_SIGRender_hasGetResponseReturnsA */
    /* Details: "ActionResponseWrapper method getResponse() returns */
    /* PortletResponse " */
    TestResult tr9 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASGETRESPONSERETURNSA);
    try {
      String name = "getResponse";
      Class<?> retType = PortletResponse.class;
      Class<?>[] parms = null;
      tr9.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr9.appendTcDetail(e.toString());
    }
    tr9.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ActionResponseWrapper_SIGRender_hasGetWindowState */
    /* Details: "ActionResponseWrapper has a getWindowState()  method " */
    TestResult tr10 = tcd
        .getTestResultFailed(V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASGETWINDOWSTATE);
    try {
      String name = "getWindowState";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr10.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr10.appendTcDetail(e.toString());
    }
    tr10.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ActionResponseWrapper_SIGRender_hasGetWindowStateReturns */
    /* Details: "ActionResponseWrapper method getWindowState() returns */
    /* WindowState " */
    TestResult tr11 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASGETWINDOWSTATERETURNS);
    try {
      String name = "getWindowState";
      Class<?> retType = WindowState.class;
      Class<?>[] parms = null;
      tr11.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr11.appendTcDetail(e.toString());
    }
    tr11.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ActionResponseWrapper_SIGRender_hasRemovePublicRenderParameter */
    /* Details: "ActionResponseWrapper has a */
    /* removePublicRenderParameter(String) method " */
    TestResult tr12 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASREMOVEPUBLICRENDERPARAMETER);
    try {
      String name = "removePublicRenderParameter";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {String.class};
      tr12.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr12.appendTcDetail(e.toString());
    }
    tr12.writeTo(writer);

    /*
     * TestCase:
     * V2SigTestsWrapper_ActionResponseWrapper_SIGRender_hasRemovePublicRenderParameterReturns
     */
    /* Details: "ActionResponseWrapper method */
    /* removePublicRenderParameter(String) returns void " */
    TestResult tr13 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASREMOVEPUBLICRENDERPARAMETERRETURNS);
    try {
      String name = "removePublicRenderParameter";
      Class<?> retType = void.class;
      Class<?>[] parms = {String.class};
      tr13.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr13.appendTcDetail(e.toString());
    }
    tr13.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ActionResponseWrapper_SIGRender_hasSendRedirect */
    /* Details: "ActionResponseWrapper has a sendRedirect(String) throws */
    /* java.io.IOException method " */
    TestResult tr14 =
        tcd.getTestResultFailed(V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSENDREDIRECT);
    try {
      String name = "sendRedirect";
      Class<?>[] exceptions = {java.io.IOException.class};
      Class<?>[] parms = {String.class};
      tr14.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr14.appendTcDetail(e.toString());
    }
    tr14.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ActionResponseWrapper_SIGRender_hasSendRedirectA */
    /* Details: "ActionResponseWrapper has a sendRedirect(String, String) */
    /* throws java.io.IOException method " */
    TestResult tr15 =
        tcd.getTestResultFailed(V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSENDREDIRECTA);
    try {
      String name = "sendRedirect";
      Class<?>[] exceptions = {java.io.IOException.class};
      Class<?>[] parms = {String.class, String.class};
      tr15.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr15.appendTcDetail(e.toString());
    }
    tr15.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ActionResponseWrapper_SIGRender_hasSendRedirectReturns */
    /* Details: "ActionResponseWrapper method sendRedirect(String) */
    /* returns void " */
    TestResult tr16 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSENDREDIRECTRETURNS);
    try {
      String name = "sendRedirect";
      Class<?> retType = void.class;
      Class<?>[] parms = {String.class};
      tr16.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr16.appendTcDetail(e.toString());
    }
    tr16.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ActionResponseWrapper_SIGRender_hasSendRedirectReturnsA */
    /* Details: "ActionResponseWrapper method sendRedirect(String, */
    /* String) returns void " */
    TestResult tr17 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSENDREDIRECTRETURNSA);
    try {
      String name = "sendRedirect";
      Class<?> retType = void.class;
      Class<?>[] parms = {String.class, String.class};
      tr17.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr17.appendTcDetail(e.toString());
    }
    tr17.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ActionResponseWrapper_SIGRender_hasSetEvent */
    /* Details: "ActionResponseWrapper has a */
    /* setEvent(javax.xml.namespace.QName, java.io.Serializable) method */
    /* " */
    TestResult tr18 =
        tcd.getTestResultFailed(V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSETEVENT);
    try {
      String name = "setEvent";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {javax.xml.namespace.QName.class, java.io.Serializable.class};
      tr18.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr18.appendTcDetail(e.toString());
    }
    tr18.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ActionResponseWrapper_SIGRender_hasSetEventA */
    /* Details: "ActionResponseWrapper has a setEvent(String, */
    /* java.io.Serializable) method " */
    TestResult tr19 =
        tcd.getTestResultFailed(V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSETEVENTA);
    try {
      String name = "setEvent";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {String.class, java.io.Serializable.class};
      tr19.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr19.appendTcDetail(e.toString());
    }
    tr19.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ActionResponseWrapper_SIGRender_hasSetEventReturns */
    /* Details: "ActionResponseWrapper method */
    /* setEvent(javax.xml.namespace.QName, java.io.Serializable) returns */
    /* void " */
    TestResult tr20 = tcd
        .getTestResultFailed(V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSETEVENTRETURNS);
    try {
      String name = "setEvent";
      Class<?> retType = void.class;
      Class<?>[] parms = {javax.xml.namespace.QName.class, java.io.Serializable.class};
      tr20.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr20.appendTcDetail(e.toString());
    }
    tr20.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ActionResponseWrapper_SIGRender_hasSetEventReturnsA */
    /* Details: "ActionResponseWrapper method setEvent(String, */
    /* java.io.Serializable) returns void " */
    TestResult tr21 = tcd
        .getTestResultFailed(V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSETEVENTRETURNSA);
    try {
      String name = "setEvent";
      Class<?> retType = void.class;
      Class<?>[] parms = {String.class, java.io.Serializable.class};
      tr21.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr21.appendTcDetail(e.toString());
    }
    tr21.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ActionResponseWrapper_SIGRender_hasSetPortletMode */
    /* Details: "ActionResponseWrapper has a setPortletMode(PortletMode) */
    /* throws PortletModeException method " */
    TestResult tr22 = tcd
        .getTestResultFailed(V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSETPORTLETMODE);
    try {
      String name = "setPortletMode";
      Class<?>[] exceptions = {PortletModeException.class};
      Class<?>[] parms = {PortletMode.class};
      tr22.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr22.appendTcDetail(e.toString());
    }
    tr22.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ActionResponseWrapper_SIGRender_hasSetPortletModeReturns */
    /* Details: "ActionResponseWrapper method setPortletMode(PortletMode) */
    /* returns void " */
    TestResult tr23 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSETPORTLETMODERETURNS);
    try {
      String name = "setPortletMode";
      Class<?> retType = void.class;
      Class<?>[] parms = {PortletMode.class};
      tr23.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr23.appendTcDetail(e.toString());
    }
    tr23.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ActionResponseWrapper_SIGRender_hasSetRenderParameter */
    /* Details: "ActionResponseWrapper has a setRenderParameter(String, */
    /* String) method " */
    TestResult tr24 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSETRENDERPARAMETER);
    try {
      String name = "setRenderParameter";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {String.class, String.class};
      tr24.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr24.appendTcDetail(e.toString());
    }
    tr24.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ActionResponseWrapper_SIGRender_hasSetRenderParameterA */
    /* Details: "ActionResponseWrapper has a setRenderParameter(String, */
    /* String[]) method " */
    TestResult tr25 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSETRENDERPARAMETERA);
    try {
      String name = "setRenderParameter";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {String.class, String[].class};
      tr25.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr25.appendTcDetail(e.toString());
    }
    tr25.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ActionResponseWrapper_SIGRender_hasSetRenderParameterReturns */
    /* Details: "ActionResponseWrapper method setRenderParameter(String, */
    /* String) returns void " */
    TestResult tr26 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSETRENDERPARAMETERRETURNS);
    try {
      String name = "setRenderParameter";
      Class<?> retType = void.class;
      Class<?>[] parms = {String.class, String.class};
      tr26.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr26.appendTcDetail(e.toString());
    }
    tr26.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ActionResponseWrapper_SIGRender_hasSetRenderParameterReturnsA */
    /* Details: "ActionResponseWrapper method setRenderParameter(String, */
    /* String[]) returns void " */
    TestResult tr27 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSETRENDERPARAMETERRETURNSA);
    try {
      String name = "setRenderParameter";
      Class<?> retType = void.class;
      Class<?>[] parms = {String.class, String[].class};
      tr27.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr27.appendTcDetail(e.toString());
    }
    tr27.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ActionResponseWrapper_SIGRender_hasSetRenderParameters */
    /* Details: "ActionResponseWrapper has a */
    /* setRenderParameters(java.util.Map) method " */
    TestResult tr28 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSETRENDERPARAMETERS);
    try {
      String name = "setRenderParameters";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {java.util.Map.class};
      tr28.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr28.appendTcDetail(e.toString());
    }
    tr28.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ActionResponseWrapper_SIGRender_hasSetRenderParametersReturns */
    /* Details: "ActionResponseWrapper method */
    /* setRenderParameters(java.util.Map) returns void " */
    TestResult tr29 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSETRENDERPARAMETERSRETURNS);
    try {
      String name = "setRenderParameters";
      Class<?> retType = void.class;
      Class<?>[] parms = {java.util.Map.class};
      tr29.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr29.appendTcDetail(e.toString());
    }
    tr29.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ActionResponseWrapper_SIGRender_hasSetResponse */
    /* Details: "ActionResponseWrapper has a setResponse(ActionResponse) */
    /* method " */
    TestResult tr30 =
        tcd.getTestResultFailed(V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSETRESPONSE);
    try {
      String name = "setResponse";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {ActionResponse.class};
      tr30.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr30.appendTcDetail(e.toString());
    }
    tr30.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ActionResponseWrapper_SIGRender_hasSetResponseReturns */
    /* Details: "ActionResponseWrapper method setResponse(ActionResponse) */
    /* returns void " */
    TestResult tr31 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSETRESPONSERETURNS);
    try {
      String name = "setResponse";
      Class<?> retType = void.class;
      Class<?>[] parms = {ActionResponse.class};
      tr31.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr31.appendTcDetail(e.toString());
    }
    tr31.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ActionResponseWrapper_SIGRender_hasSetWindowState */
    /* Details: "ActionResponseWrapper has a setWindowState(WindowState) */
    /* throws WindowStateException method " */
    TestResult tr32 = tcd
        .getTestResultFailed(V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSETWINDOWSTATE);
    try {
      String name = "setWindowState";
      Class<?>[] exceptions = {WindowStateException.class};
      Class<?>[] parms = {WindowState.class};
      tr32.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr32.appendTcDetail(e.toString());
    }
    tr32.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ActionResponseWrapper_SIGRender_hasSetWindowStateReturns */
    /* Details: "ActionResponseWrapper method setWindowState(WindowState) */
    /* returns void " */
    TestResult tr33 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSETWINDOWSTATERETURNS);
    try {
      String name = "setWindowState";
      Class<?> retType = void.class;
      Class<?>[] parms = {WindowState.class};
      tr33.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr33.appendTcDetail(e.toString());
    }
    tr33.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ActionResponseWrapper_SIGRender_implementsActionResponse */
    /* Details: "ActionResponseWrapper implements ActionResponse " */
    TestResult tr34 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_IMPLEMENTSACTIONRESPONSE);
    try {
      tr34.setTcSuccess(cc.implementsInterface(ActionResponse.class));
    } catch (Exception e) {
      tr34.appendTcDetail(e.toString());
    }
    tr34.writeTo(writer);

  }

}
