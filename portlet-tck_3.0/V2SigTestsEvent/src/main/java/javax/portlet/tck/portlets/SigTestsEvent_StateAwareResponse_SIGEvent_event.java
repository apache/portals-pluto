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
import javax.portlet.EventPortlet;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
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
import javax.portlet.tck.beans.ClassChecker;
import javax.portlet.tck.beans.JSR286SignatureTestCaseDetails;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.constants.Constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASGETPORTLETMODE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASGETPORTLETMODERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASGETRENDERPARAMETERMAP;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASGETRENDERPARAMETERMAPRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASGETWINDOWSTATE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASGETWINDOWSTATERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASREMOVEPUBLICRENDERPARAMETER;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASREMOVEPUBLICRENDERPARAMETERRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASSETEVENT;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASSETEVENTA;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASSETEVENTRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASSETEVENTRETURNSA;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASSETPORTLETMODE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASSETPORTLETMODERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASSETRENDERPARAMETER;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASSETRENDERPARAMETERA;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASSETRENDERPARAMETERRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASSETRENDERPARAMETERRETURNSA;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASSETRENDERPARAMETERS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASSETRENDERPARAMETERSRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASSETWINDOWSTATE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASSETWINDOWSTATERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_IMPLEMENTSPORTLETRESPONSE;
import static javax.portlet.PortletSession.APPLICATION_SCOPE;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;
import static javax.portlet.tck.constants.Constants.RESULT_ATTR_PREFIX;

/**
 * This is the event processing portlet for the test cases. This portlet processes events, but does
 * not publish them. Events are published in the main portlet for the test cases.
 */
public class SigTestsEvent_StateAwareResponse_SIGEvent_event implements Portlet, EventPortlet {

  private final Logger LOGGER = LoggerFactory.getLogger(SigTestsEvent_StateAwareResponse_SIGEvent_event.class);

  @Override
  public void init(PortletConfig config) throws PortletException {}

  @Override
  public void destroy() {}

  @Override
  public void processAction(ActionRequest portletReq, ActionResponse portletResp)
      throws PortletException, IOException {
    LOGGER.trace("event companion processAction - ERROR!!");
  }

  @Override
  public void processEvent(EventRequest portletReq, EventResponse portletResp)
      throws PortletException, IOException {


    portletResp.setRenderParameters(portletReq);

    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

    StringWriter writer = new StringWriter();

    JSR286SignatureTestCaseDetails tcd = new JSR286SignatureTestCaseDetails();

    // Create result objects for the tests

    ClassChecker cc = new ClassChecker(portletResp.getClass());

    /* TestCase: V2SigTestsEvent_StateAwareResponse_SIGEvent_hasGetPortletMode */
    /* Details: "EventResponse has a getPortletMode()  method " */
    TestResult tr0 =
        tcd.getTestResultFailed(V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASGETPORTLETMODE);
    try {
      String name = "getPortletMode";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr0.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr0.appendTcDetail(e.toString());
    }
    tr0.writeTo(writer);

    /* TestCase: V2SigTestsEvent_StateAwareResponse_SIGEvent_hasGetPortletModeReturns */
    /* Details: "EventResponse method getPortletMode() returns */
    /* PortletMode " */
    TestResult tr1 = tcd
        .getTestResultFailed(V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASGETPORTLETMODERETURNS);
    try {
      String name = "getPortletMode";
      Class<?> retType = PortletMode.class;
      Class<?>[] parms = null;
      tr1.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr1.appendTcDetail(e.toString());
    }
    tr1.writeTo(writer);

    /* TestCase: V2SigTestsEvent_StateAwareResponse_SIGEvent_hasGetRenderParameterMap */
    /* Details: "EventResponse has a getRenderParameterMap()  method " */
    TestResult tr2 = tcd
        .getTestResultFailed(V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASGETRENDERPARAMETERMAP);
    try {
      String name = "getRenderParameterMap";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr2.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr2.appendTcDetail(e.toString());
    }
    tr2.writeTo(writer);

    /* TestCase: V2SigTestsEvent_StateAwareResponse_SIGEvent_hasGetRenderParameterMapReturns */
    /* Details: "EventResponse method getRenderParameterMap() returns */
    /* java.util.Map " */
    TestResult tr3 = tcd.getTestResultFailed(
        V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASGETRENDERPARAMETERMAPRETURNS);
    try {
      String name = "getRenderParameterMap";
      Class<?> retType = java.util.Map.class;
      Class<?>[] parms = null;
      tr3.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr3.appendTcDetail(e.toString());
    }
    tr3.writeTo(writer);

    /* TestCase: V2SigTestsEvent_StateAwareResponse_SIGEvent_hasGetWindowState */
    /* Details: "EventResponse has a getWindowState()  method " */
    TestResult tr4 =
        tcd.getTestResultFailed(V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASGETWINDOWSTATE);
    try {
      String name = "getWindowState";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr4.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr4.appendTcDetail(e.toString());
    }
    tr4.writeTo(writer);

    /* TestCase: V2SigTestsEvent_StateAwareResponse_SIGEvent_hasGetWindowStateReturns */
    /* Details: "EventResponse method getWindowState() returns */
    /* WindowState " */
    TestResult tr5 = tcd
        .getTestResultFailed(V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASGETWINDOWSTATERETURNS);
    try {
      String name = "getWindowState";
      Class<?> retType = WindowState.class;
      Class<?>[] parms = null;
      tr5.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr5.appendTcDetail(e.toString());
    }
    tr5.writeTo(writer);

    /* TestCase: V2SigTestsEvent_StateAwareResponse_SIGEvent_hasRemovePublicRenderParameter */
    /* Details: "EventResponse has a removePublicRenderParameter(String) */
    /* method " */
    TestResult tr6 = tcd.getTestResultFailed(
        V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASREMOVEPUBLICRENDERPARAMETER);
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
     * TestCase: V2SigTestsEvent_StateAwareResponse_SIGEvent_hasRemovePublicRenderParameterReturns
     */
    /* Details: "EventResponse method removePublicRenderParameter(String) */
    /* returns void " */
    TestResult tr7 = tcd.getTestResultFailed(
        V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASREMOVEPUBLICRENDERPARAMETERRETURNS);
    try {
      String name = "removePublicRenderParameter";
      Class<?> retType = void.class;
      Class<?>[] parms = {String.class};
      tr7.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr7.appendTcDetail(e.toString());
    }
    tr7.writeTo(writer);

    /* TestCase: V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetEvent */
    /* Details: "EventResponse has a setEvent(javax.xml.namespace.QName, */
    /* java.io.Serializable) method " */
    TestResult tr8 =
        tcd.getTestResultFailed(V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASSETEVENT);
    try {
      String name = "setEvent";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {javax.xml.namespace.QName.class, java.io.Serializable.class};
      tr8.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr8.appendTcDetail(e.toString());
    }
    tr8.writeTo(writer);

    /* TestCase: V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetEventA */
    /* Details: "EventResponse has a setEvent(String, */
    /* java.io.Serializable) method " */
    TestResult tr9 =
        tcd.getTestResultFailed(V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASSETEVENTA);
    try {
      String name = "setEvent";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {String.class, java.io.Serializable.class};
      tr9.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr9.appendTcDetail(e.toString());
    }
    tr9.writeTo(writer);

    /* TestCase: V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetEventReturns */
    /* Details: "EventResponse method setEvent(javax.xml.namespace.QName, */
    /* java.io.Serializable) returns void " */
    TestResult tr10 =
        tcd.getTestResultFailed(V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASSETEVENTRETURNS);
    try {
      String name = "setEvent";
      Class<?> retType = void.class;
      Class<?>[] parms = {javax.xml.namespace.QName.class, java.io.Serializable.class};
      tr10.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr10.appendTcDetail(e.toString());
    }
    tr10.writeTo(writer);

    /* TestCase: V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetEventReturnsA */
    /* Details: "EventResponse method setEvent(String, */
    /* java.io.Serializable) returns void " */
    TestResult tr11 =
        tcd.getTestResultFailed(V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASSETEVENTRETURNSA);
    try {
      String name = "setEvent";
      Class<?> retType = void.class;
      Class<?>[] parms = {String.class, java.io.Serializable.class};
      tr11.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr11.appendTcDetail(e.toString());
    }
    tr11.writeTo(writer);

    /* TestCase: V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetPortletMode */
    /* Details: "EventResponse has a setPortletMode(PortletMode) throws */
    /* PortletModeException method " */
    TestResult tr12 =
        tcd.getTestResultFailed(V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASSETPORTLETMODE);
    try {
      String name = "setPortletMode";
      Class<?>[] exceptions = {PortletModeException.class};
      Class<?>[] parms = {PortletMode.class};
      tr12.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr12.appendTcDetail(e.toString());
    }
    tr12.writeTo(writer);

    /* TestCase: V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetPortletModeReturns */
    /* Details: "EventResponse method setPortletMode(PortletMode) returns */
    /* void " */
    TestResult tr13 = tcd
        .getTestResultFailed(V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASSETPORTLETMODERETURNS);
    try {
      String name = "setPortletMode";
      Class<?> retType = void.class;
      Class<?>[] parms = {PortletMode.class};
      tr13.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr13.appendTcDetail(e.toString());
    }
    tr13.writeTo(writer);

    /* TestCase: V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetRenderParameter */
    /* Details: "EventResponse has a setRenderParameter(String, String) */
    /* method " */
    TestResult tr14 =
        tcd.getTestResultFailed(V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASSETRENDERPARAMETER);
    try {
      String name = "setRenderParameter";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {String.class, String.class};
      tr14.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr14.appendTcDetail(e.toString());
    }
    tr14.writeTo(writer);

    /* TestCase: V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetRenderParameterA */
    /* Details: "EventResponse has a setRenderParameter(String, String[]) */
    /* method " */
    TestResult tr15 =
        tcd.getTestResultFailed(V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASSETRENDERPARAMETERA);
    try {
      String name = "setRenderParameter";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {String.class, String[].class};
      tr15.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr15.appendTcDetail(e.toString());
    }
    tr15.writeTo(writer);

    /* TestCase: V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetRenderParameterReturns */
    /* Details: "EventResponse method setRenderParameter(String, String) */
    /* returns void " */
    TestResult tr16 = tcd.getTestResultFailed(
        V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASSETRENDERPARAMETERRETURNS);
    try {
      String name = "setRenderParameter";
      Class<?> retType = void.class;
      Class<?>[] parms = {String.class, String.class};
      tr16.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr16.appendTcDetail(e.toString());
    }
    tr16.writeTo(writer);

    /* TestCase: V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetRenderParameterReturnsA */
    /* Details: "EventResponse method setRenderParameter(String, */
    /* String[]) returns void " */
    TestResult tr17 = tcd.getTestResultFailed(
        V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASSETRENDERPARAMETERRETURNSA);
    try {
      String name = "setRenderParameter";
      Class<?> retType = void.class;
      Class<?>[] parms = {String.class, String[].class};
      tr17.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr17.appendTcDetail(e.toString());
    }
    tr17.writeTo(writer);

    /* TestCase: V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetRenderParameters */
    /* Details: "EventResponse has a setRenderParameters(java.util.Map) */
    /* method " */
    TestResult tr18 =
        tcd.getTestResultFailed(V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASSETRENDERPARAMETERS);
    try {
      String name = "setRenderParameters";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {java.util.Map.class};
      tr18.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr18.appendTcDetail(e.toString());
    }
    tr18.writeTo(writer);

    /* TestCase: V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetRenderParametersReturns */
    /* Details: "EventResponse method setRenderParameters(java.util.Map) */
    /* returns void " */
    TestResult tr19 = tcd.getTestResultFailed(
        V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASSETRENDERPARAMETERSRETURNS);
    try {
      String name = "setRenderParameters";
      Class<?> retType = void.class;
      Class<?>[] parms = {java.util.Map.class};
      tr19.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr19.appendTcDetail(e.toString());
    }
    tr19.writeTo(writer);

    /* TestCase: V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetWindowState */
    /* Details: "EventResponse has a setWindowState(WindowState) throws */
    /* WindowStateException method " */
    TestResult tr20 =
        tcd.getTestResultFailed(V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASSETWINDOWSTATE);
    try {
      String name = "setWindowState";
      Class<?>[] exceptions = {WindowStateException.class};
      Class<?>[] parms = {WindowState.class};
      tr20.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr20.appendTcDetail(e.toString());
    }
    tr20.writeTo(writer);

    /* TestCase: V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetWindowStateReturns */
    /* Details: "EventResponse method setWindowState(WindowState) returns */
    /* void " */
    TestResult tr21 = tcd
        .getTestResultFailed(V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASSETWINDOWSTATERETURNS);
    try {
      String name = "setWindowState";
      Class<?> retType = void.class;
      Class<?>[] parms = {WindowState.class};
      tr21.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr21.appendTcDetail(e.toString());
    }
    tr21.writeTo(writer);

    /* TestCase: V2SigTestsEvent_StateAwareResponse_SIGEvent_implementsPortletResponse */
    /* Details: "EventResponse implements PortletResponse " */
    TestResult tr22 = tcd
        .getTestResultFailed(V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_IMPLEMENTSPORTLETRESPONSE);
    try {
      tr22.setTcSuccess(cc.implementsInterface(PortletResponse.class));
    } catch (Exception e) {
      tr22.appendTcDetail(e.toString());
    }
    tr22.writeTo(writer);

    portletReq.getPortletSession().setAttribute(
        Constants.RESULT_ATTR_PREFIX + "SigTestsEvent_StateAwareResponse_SIGEvent",
        writer.toString(), APPLICATION_SCOPE);

  }

  @Override
  public void render(RenderRequest portletReq, RenderResponse portletResp)
      throws PortletException, IOException {

    portletResp.setContentType("text/html");
    PrintWriter writer = portletResp.getWriter();
    writer.write("<h3>Event Companion Portlet </h3>\n");
    writer.write("<p>SigTestsEvent_StateAwareResponse_SIGEvent_event</p>\n");

    String msg = (String) portletReq.getPortletSession().getAttribute(
        RESULT_ATTR_PREFIX + "SigTestsEvent_StateAwareResponse_SIGEvent", APPLICATION_SCOPE);
    msg = (msg == null) ? "Not ready. click test case link." : msg;
    writer.write("<p>" + msg + "</p>\n");

  }

}
