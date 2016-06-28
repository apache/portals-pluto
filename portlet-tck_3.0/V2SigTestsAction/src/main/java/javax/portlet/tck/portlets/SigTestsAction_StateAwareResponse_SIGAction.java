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
import java.io.StringWriter;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.PortletResponse;
import javax.portlet.PortletSession;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;
import javax.portlet.tck.beans.ClassChecker;
import javax.portlet.tck.beans.JSR286SignatureTestCaseDetails;
import javax.portlet.tck.beans.TestButton;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.constants.Constants;

import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASGETPORTLETMODE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASGETPORTLETMODERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASGETRENDERPARAMETERMAP;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASGETRENDERPARAMETERMAPRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASGETWINDOWSTATE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASGETWINDOWSTATERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASREMOVEPUBLICRENDERPARAMETER;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASREMOVEPUBLICRENDERPARAMETERRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASSETEVENT;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASSETEVENTA;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASSETEVENTRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASSETEVENTRETURNSA;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASSETPORTLETMODE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASSETPORTLETMODERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASSETRENDERPARAMETER;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASSETRENDERPARAMETERA;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASSETRENDERPARAMETERRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASSETRENDERPARAMETERRETURNSA;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASSETRENDERPARAMETERS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASSETRENDERPARAMETERSRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASSETWINDOWSTATE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASSETWINDOWSTATERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_IMPLEMENTSPORTLETRESPONSE;
import static javax.portlet.PortletSession.APPLICATION_SCOPE;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;
import static javax.portlet.tck.constants.Constants.RESULT_ATTR_PREFIX;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined
 * in the /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate
 * the test case names defined in the additionalTCs.xml file into the complete list of test case
 * names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will
 * initiate the events, but not process them. The processing is done in the companion portlet
 * SigTestsAction_StateAwareResponse_SIGAction_event
 *
 */
public class SigTestsAction_StateAwareResponse_SIGAction implements Portlet {

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

    StringWriter writer = new StringWriter();

    JSR286SignatureTestCaseDetails tcd = new JSR286SignatureTestCaseDetails();

    // Create result objects for the tests

    ClassChecker cc = new ClassChecker(portletResp.getClass());

    /* TestCase: V2SigTestsAction_StateAwareResponse_SIGAction_hasGetPortletMode */
    /* Details: "ActionResponse has a getPortletMode()  method " */
    TestResult tr0 =
        tcd.getTestResultFailed(V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASGETPORTLETMODE);
    try {
      String name = "getPortletMode";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr0.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr0.appendTcDetail(e.toString());
    }
    tr0.writeTo(writer);

    /* TestCase: V2SigTestsAction_StateAwareResponse_SIGAction_hasGetPortletModeReturns */
    /* Details: "ActionResponse method getPortletMode() returns */
    /* PortletMode " */
    TestResult tr1 = tcd.getTestResultFailed(
        V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASGETPORTLETMODERETURNS);
    try {
      String name = "getPortletMode";
      Class<?> retType = PortletMode.class;
      Class<?>[] parms = null;
      tr1.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr1.appendTcDetail(e.toString());
    }
    tr1.writeTo(writer);

    /* TestCase: V2SigTestsAction_StateAwareResponse_SIGAction_hasGetRenderParameterMap */
    /* Details: "ActionResponse has a getRenderParameterMap()  method " */
    TestResult tr2 = tcd.getTestResultFailed(
        V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASGETRENDERPARAMETERMAP);
    try {
      String name = "getRenderParameterMap";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr2.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr2.appendTcDetail(e.toString());
    }
    tr2.writeTo(writer);

    /* TestCase: V2SigTestsAction_StateAwareResponse_SIGAction_hasGetRenderParameterMapReturns */
    /* Details: "ActionResponse method getRenderParameterMap() returns */
    /* java.util.Map " */
    TestResult tr3 = tcd.getTestResultFailed(
        V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASGETRENDERPARAMETERMAPRETURNS);
    try {
      String name = "getRenderParameterMap";
      Class<?> retType = java.util.Map.class;
      Class<?>[] parms = null;
      tr3.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr3.appendTcDetail(e.toString());
    }
    tr3.writeTo(writer);

    /* TestCase: V2SigTestsAction_StateAwareResponse_SIGAction_hasGetWindowState */
    /* Details: "ActionResponse has a getWindowState()  method " */
    TestResult tr4 =
        tcd.getTestResultFailed(V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASGETWINDOWSTATE);
    try {
      String name = "getWindowState";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr4.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr4.appendTcDetail(e.toString());
    }
    tr4.writeTo(writer);

    /* TestCase: V2SigTestsAction_StateAwareResponse_SIGAction_hasGetWindowStateReturns */
    /* Details: "ActionResponse method getWindowState() returns */
    /* WindowState " */
    TestResult tr5 = tcd.getTestResultFailed(
        V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASGETWINDOWSTATERETURNS);
    try {
      String name = "getWindowState";
      Class<?> retType = WindowState.class;
      Class<?>[] parms = null;
      tr5.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr5.appendTcDetail(e.toString());
    }
    tr5.writeTo(writer);

    /* TestCase: V2SigTestsAction_StateAwareResponse_SIGAction_hasRemovePublicRenderParameter */
    /* Details: "ActionResponse has a removePublicRenderParameter(String) */
    /* method " */
    TestResult tr6 = tcd.getTestResultFailed(
        V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASREMOVEPUBLICRENDERPARAMETER);
    try {
      String name = "removePublicRenderParameter";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {String.class};
      tr6.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr6.appendTcDetail(e.toString());
    }
    tr6.writeTo(writer);

    /*
     * TestCase: V2SigTestsAction_StateAwareResponse_SIGAction_hasRemovePublicRenderParameterReturns
     */
    /* Details: "ActionResponse method */
    /* removePublicRenderParameter(String) returns void " */
    TestResult tr7 = tcd.getTestResultFailed(
        V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASREMOVEPUBLICRENDERPARAMETERRETURNS);
    try {
      String name = "removePublicRenderParameter";
      Class<?> retType = void.class;
      Class<?>[] parms = {String.class};
      tr7.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr7.appendTcDetail(e.toString());
    }
    tr7.writeTo(writer);

    /* TestCase: V2SigTestsAction_StateAwareResponse_SIGAction_hasSetEvent */
    /* Details: "ActionResponse has a setEvent(javax.xml.namespace.QName, */
    /* java.io.Serializable) method " */
    TestResult tr8 =
        tcd.getTestResultFailed(V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASSETEVENT);
    try {
      String name = "setEvent";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {javax.xml.namespace.QName.class, java.io.Serializable.class};
      tr8.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr8.appendTcDetail(e.toString());
    }
    tr8.writeTo(writer);

    /* TestCase: V2SigTestsAction_StateAwareResponse_SIGAction_hasSetEventA */
    /* Details: "ActionResponse has a setEvent(String, */
    /* java.io.Serializable) method " */
    TestResult tr9 =
        tcd.getTestResultFailed(V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASSETEVENTA);
    try {
      String name = "setEvent";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {String.class, java.io.Serializable.class};
      tr9.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr9.appendTcDetail(e.toString());
    }
    tr9.writeTo(writer);

    /* TestCase: V2SigTestsAction_StateAwareResponse_SIGAction_hasSetEventReturns */
    /* Details: "ActionResponse method */
    /* setEvent(javax.xml.namespace.QName, java.io.Serializable) returns */
    /* void " */
    TestResult tr10 =
        tcd.getTestResultFailed(V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASSETEVENTRETURNS);
    try {
      String name = "setEvent";
      Class<?> retType = void.class;
      Class<?>[] parms = {javax.xml.namespace.QName.class, java.io.Serializable.class};
      tr10.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr10.appendTcDetail(e.toString());
    }
    tr10.writeTo(writer);

    /* TestCase: V2SigTestsAction_StateAwareResponse_SIGAction_hasSetEventReturnsA */
    /* Details: "ActionResponse method setEvent(String, */
    /* java.io.Serializable) returns void " */
    TestResult tr11 =
        tcd.getTestResultFailed(V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASSETEVENTRETURNSA);
    try {
      String name = "setEvent";
      Class<?> retType = void.class;
      Class<?>[] parms = {String.class, java.io.Serializable.class};
      tr11.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr11.appendTcDetail(e.toString());
    }
    tr11.writeTo(writer);

    /* TestCase: V2SigTestsAction_StateAwareResponse_SIGAction_hasSetPortletMode */
    /* Details: "ActionResponse has a setPortletMode(PortletMode) throws */
    /* PortletModeException method " */
    TestResult tr12 =
        tcd.getTestResultFailed(V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASSETPORTLETMODE);
    try {
      String name = "setPortletMode";
      Class<?>[] exceptions = {PortletModeException.class};
      Class<?>[] parms = {PortletMode.class};
      tr12.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr12.appendTcDetail(e.toString());
    }
    tr12.writeTo(writer);

    /* TestCase: V2SigTestsAction_StateAwareResponse_SIGAction_hasSetPortletModeReturns */
    /* Details: "ActionResponse method setPortletMode(PortletMode) */
    /* returns void " */
    TestResult tr13 = tcd.getTestResultFailed(
        V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASSETPORTLETMODERETURNS);
    try {
      String name = "setPortletMode";
      Class<?> retType = void.class;
      Class<?>[] parms = {PortletMode.class};
      tr13.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr13.appendTcDetail(e.toString());
    }
    tr13.writeTo(writer);

    /* TestCase: V2SigTestsAction_StateAwareResponse_SIGAction_hasSetRenderParameter */
    /* Details: "ActionResponse has a setRenderParameter(String, String) */
    /* method " */
    TestResult tr14 = tcd
        .getTestResultFailed(V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASSETRENDERPARAMETER);
    try {
      String name = "setRenderParameter";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {String.class, String.class};
      tr14.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr14.appendTcDetail(e.toString());
    }
    tr14.writeTo(writer);

    /* TestCase: V2SigTestsAction_StateAwareResponse_SIGAction_hasSetRenderParameterA */
    /* Details: "ActionResponse has a setRenderParameter(String, */
    /* String[]) method " */
    TestResult tr15 = tcd
        .getTestResultFailed(V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASSETRENDERPARAMETERA);
    try {
      String name = "setRenderParameter";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {String.class, String[].class};
      tr15.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr15.appendTcDetail(e.toString());
    }
    tr15.writeTo(writer);

    /* TestCase: V2SigTestsAction_StateAwareResponse_SIGAction_hasSetRenderParameterReturns */
    /* Details: "ActionResponse method setRenderParameter(String, String) */
    /* returns void " */
    TestResult tr16 = tcd.getTestResultFailed(
        V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASSETRENDERPARAMETERRETURNS);
    try {
      String name = "setRenderParameter";
      Class<?> retType = void.class;
      Class<?>[] parms = {String.class, String.class};
      tr16.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr16.appendTcDetail(e.toString());
    }
    tr16.writeTo(writer);

    /* TestCase: V2SigTestsAction_StateAwareResponse_SIGAction_hasSetRenderParameterReturnsA */
    /* Details: "ActionResponse method setRenderParameter(String, */
    /* String[]) returns void " */
    TestResult tr17 = tcd.getTestResultFailed(
        V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASSETRENDERPARAMETERRETURNSA);
    try {
      String name = "setRenderParameter";
      Class<?> retType = void.class;
      Class<?>[] parms = {String.class, String[].class};
      tr17.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr17.appendTcDetail(e.toString());
    }
    tr17.writeTo(writer);

    /* TestCase: V2SigTestsAction_StateAwareResponse_SIGAction_hasSetRenderParameters */
    /* Details: "ActionResponse has a setRenderParameters(java.util.Map) */
    /* method " */
    TestResult tr18 = tcd
        .getTestResultFailed(V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASSETRENDERPARAMETERS);
    try {
      String name = "setRenderParameters";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {java.util.Map.class};
      tr18.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr18.appendTcDetail(e.toString());
    }
    tr18.writeTo(writer);

    /* TestCase: V2SigTestsAction_StateAwareResponse_SIGAction_hasSetRenderParametersReturns */
    /* Details: "ActionResponse method setRenderParameters(java.util.Map) */
    /* returns void " */
    TestResult tr19 = tcd.getTestResultFailed(
        V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASSETRENDERPARAMETERSRETURNS);
    try {
      String name = "setRenderParameters";
      Class<?> retType = void.class;
      Class<?>[] parms = {java.util.Map.class};
      tr19.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr19.appendTcDetail(e.toString());
    }
    tr19.writeTo(writer);

    /* TestCase: V2SigTestsAction_StateAwareResponse_SIGAction_hasSetWindowState */
    /* Details: "ActionResponse has a setWindowState(WindowState) throws */
    /* WindowStateException method " */
    TestResult tr20 =
        tcd.getTestResultFailed(V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASSETWINDOWSTATE);
    try {
      String name = "setWindowState";
      Class<?>[] exceptions = {WindowStateException.class};
      Class<?>[] parms = {WindowState.class};
      tr20.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr20.appendTcDetail(e.toString());
    }
    tr20.writeTo(writer);

    /* TestCase: V2SigTestsAction_StateAwareResponse_SIGAction_hasSetWindowStateReturns */
    /* Details: "ActionResponse method setWindowState(WindowState) */
    /* returns void " */
    TestResult tr21 = tcd.getTestResultFailed(
        V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASSETWINDOWSTATERETURNS);
    try {
      String name = "setWindowState";
      Class<?> retType = void.class;
      Class<?>[] parms = {WindowState.class};
      tr21.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr21.appendTcDetail(e.toString());
    }
    tr21.writeTo(writer);

    /* TestCase: V2SigTestsAction_StateAwareResponse_SIGAction_implementsPortletResponse */
    /* Details: "ActionResponse implements PortletResponse " */
    TestResult tr22 = tcd.getTestResultFailed(
        V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_IMPLEMENTSPORTLETRESPONSE);
    try {
      tr22.setTcSuccess(cc.implementsInterface(PortletResponse.class));
    } catch (Exception e) {
      tr22.appendTcDetail(e.toString());
    }
    tr22.writeTo(writer);

    portletReq.getPortletSession().setAttribute(
        Constants.RESULT_ATTR_PREFIX + "SigTestsAction_StateAwareResponse_SIGAction",
        writer.toString(), APPLICATION_SCOPE);
  }

  @Override
  public void render(RenderRequest portletReq, RenderResponse portletResp)
      throws PortletException, IOException {

    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

    PrintWriter writer = portletResp.getWriter();

    PortletSession ps = portletReq.getPortletSession();
    String msg =
        (String) ps.getAttribute(RESULT_ATTR_PREFIX + "SigTestsAction_StateAwareResponse_SIGAction",
            APPLICATION_SCOPE);
    if (msg != null) {
      writer.write("<p>" + msg + "</p><br/>\n");
      ps.removeAttribute(RESULT_ATTR_PREFIX + "SigTestsAction_StateAwareResponse_SIGAction",
          APPLICATION_SCOPE);
    }

    /* TestCase: V2SigTestsAction_StateAwareResponse_SIGAction_hasGetPortletMode */
    /* Details: "ActionResponse has a getPortletMode()  method " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASGETPORTLETMODE, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsAction_StateAwareResponse_SIGAction_hasGetPortletModeReturns */
    /* Details: "ActionResponse method getPortletMode() returns */
    /* PortletMode " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(
          "V2SigTestsAction_StateAwareResponse_SIGAction_hasGetPortletModeReturns", aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsAction_StateAwareResponse_SIGAction_hasGetRenderParameterMap */
    /* Details: "ActionResponse has a getRenderParameterMap()  method " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(
          "V2SigTestsAction_StateAwareResponse_SIGAction_hasGetRenderParameterMap", aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsAction_StateAwareResponse_SIGAction_hasGetRenderParameterMapReturns */
    /* Details: "ActionResponse method getRenderParameterMap() returns */
    /* java.util.Map " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(
          "V2SigTestsAction_StateAwareResponse_SIGAction_hasGetRenderParameterMapReturns", aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsAction_StateAwareResponse_SIGAction_hasGetWindowState */
    /* Details: "ActionResponse has a getWindowState()  method " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASGETWINDOWSTATE, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsAction_StateAwareResponse_SIGAction_hasGetWindowStateReturns */
    /* Details: "ActionResponse method getWindowState() returns */
    /* WindowState " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(
          "V2SigTestsAction_StateAwareResponse_SIGAction_hasGetWindowStateReturns", aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsAction_StateAwareResponse_SIGAction_hasRemovePublicRenderParameter */
    /* Details: "ActionResponse has a removePublicRenderParameter(String) */
    /* method " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(
          "V2SigTestsAction_StateAwareResponse_SIGAction_hasRemovePublicRenderParameter", aurl);
      tb.writeTo(writer);
    }

    /*
     * TestCase: V2SigTestsAction_StateAwareResponse_SIGAction_hasRemovePublicRenderParameterReturns
     */
    /* Details: "ActionResponse method */
    /* removePublicRenderParameter(String) returns void " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(
          "V2SigTestsAction_StateAwareResponse_SIGAction_hasRemovePublicRenderParameterReturns",
          aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsAction_StateAwareResponse_SIGAction_hasSetEvent */
    /* Details: "ActionResponse has a setEvent(javax.xml.namespace.QName, */
    /* java.io.Serializable) method " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASSETEVENT, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsAction_StateAwareResponse_SIGAction_hasSetEventA */
    /* Details: "ActionResponse has a setEvent(String, */
    /* java.io.Serializable) method " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASSETEVENTA, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsAction_StateAwareResponse_SIGAction_hasSetEventReturns */
    /* Details: "ActionResponse method */
    /* setEvent(javax.xml.namespace.QName, java.io.Serializable) returns */
    /* void " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASSETEVENTRETURNS, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsAction_StateAwareResponse_SIGAction_hasSetEventReturnsA */
    /* Details: "ActionResponse method setEvent(String, */
    /* java.io.Serializable) returns void " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASSETEVENTRETURNSA, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsAction_StateAwareResponse_SIGAction_hasSetPortletMode */
    /* Details: "ActionResponse has a setPortletMode(PortletMode) throws */
    /* PortletModeException method " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASSETPORTLETMODE, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsAction_StateAwareResponse_SIGAction_hasSetPortletModeReturns */
    /* Details: "ActionResponse method setPortletMode(PortletMode) */
    /* returns void " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(
          "V2SigTestsAction_StateAwareResponse_SIGAction_hasSetPortletModeReturns", aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsAction_StateAwareResponse_SIGAction_hasSetRenderParameter */
    /* Details: "ActionResponse has a setRenderParameter(String, String) */
    /* method " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(
          "V2SigTestsAction_StateAwareResponse_SIGAction_hasSetRenderParameter", aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsAction_StateAwareResponse_SIGAction_hasSetRenderParameterA */
    /* Details: "ActionResponse has a setRenderParameter(String, */
    /* String[]) method " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(
          "V2SigTestsAction_StateAwareResponse_SIGAction_hasSetRenderParameterA", aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsAction_StateAwareResponse_SIGAction_hasSetRenderParameterReturns */
    /* Details: "ActionResponse method setRenderParameter(String, String) */
    /* returns void " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(
          "V2SigTestsAction_StateAwareResponse_SIGAction_hasSetRenderParameterReturns", aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsAction_StateAwareResponse_SIGAction_hasSetRenderParameterReturnsA */
    /* Details: "ActionResponse method setRenderParameter(String, */
    /* String[]) returns void " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(
          "V2SigTestsAction_StateAwareResponse_SIGAction_hasSetRenderParameterReturnsA", aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsAction_StateAwareResponse_SIGAction_hasSetRenderParameters */
    /* Details: "ActionResponse has a setRenderParameters(java.util.Map) */
    /* method " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(
          "V2SigTestsAction_StateAwareResponse_SIGAction_hasSetRenderParameters", aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsAction_StateAwareResponse_SIGAction_hasSetRenderParametersReturns */
    /* Details: "ActionResponse method setRenderParameters(java.util.Map) */
    /* returns void " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(
          "V2SigTestsAction_StateAwareResponse_SIGAction_hasSetRenderParametersReturns", aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsAction_StateAwareResponse_SIGAction_hasSetWindowState */
    /* Details: "ActionResponse has a setWindowState(WindowState) throws */
    /* WindowStateException method " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASSETWINDOWSTATE, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsAction_StateAwareResponse_SIGAction_hasSetWindowStateReturns */
    /* Details: "ActionResponse method setWindowState(WindowState) */
    /* returns void " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(
          "V2SigTestsAction_StateAwareResponse_SIGAction_hasSetWindowStateReturns", aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsAction_StateAwareResponse_SIGAction_implementsPortletResponse */
    /* Details: "ActionResponse implements PortletResponse " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(
          "V2SigTestsAction_StateAwareResponse_SIGAction_implementsPortletResponse", aurl);
      tb.writeTo(writer);
    }

  }

}
