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
import javax.portlet.Event;
import javax.portlet.EventRequest;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.filter.EventRequestWrapper;
import javax.portlet.tck.beans.ClassChecker;
import javax.portlet.tck.beans.JSR286SignatureTestCaseDetails;
import javax.portlet.tck.beans.TestResult;

import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_EVENTREQUESTWRAPPER_SIGRENDER_CONSTRUCTOR;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_EVENTREQUESTWRAPPER_SIGRENDER_HASGETEVENT;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_EVENTREQUESTWRAPPER_SIGRENDER_HASGETEVENTRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_EVENTREQUESTWRAPPER_SIGRENDER_HASGETMETHOD;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_EVENTREQUESTWRAPPER_SIGRENDER_HASGETMETHODRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_EVENTREQUESTWRAPPER_SIGRENDER_HASGETREQUEST;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_EVENTREQUESTWRAPPER_SIGRENDER_HASGETREQUESTA;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_EVENTREQUESTWRAPPER_SIGRENDER_HASGETREQUESTRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_EVENTREQUESTWRAPPER_SIGRENDER_HASGETREQUESTRETURNSA;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_EVENTREQUESTWRAPPER_SIGRENDER_HASSETREQUEST;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_EVENTREQUESTWRAPPER_SIGRENDER_HASSETREQUESTRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_EVENTREQUESTWRAPPER_SIGRENDER_IMPLEMENTSEVENTREQUEST;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined
 * in the /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate
 * the test case names defined in the additionalTCs.xml file into the complete list of test case
 * names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will
 * initiate the events, but not process them. The processing is done in the companion portlet
 * SigTestsWrapper_EventRequestWrapper_SIGRender_event
 *
 */
public class SigTestsWrapper_EventRequestWrapper_SIGRender implements Portlet {

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

    ClassChecker cc = new ClassChecker(EventRequestWrapper.class);

    /* TestCase: V2SigTestsWrapper_EventRequestWrapper_SIGRender_constructor */
    /* Details: "EventRequestWrapper provides constructor */
    /* EventRequestWrapper(EventRequest) " */
    TestResult tr0 =
        tcd.getTestResultFailed(V2SIGTESTSWRAPPER_EVENTREQUESTWRAPPER_SIGRENDER_CONSTRUCTOR);
    try {
      Class<?>[] parms = {EventRequest.class};
      tr0.setTcSuccess(cc.hasConstructor(parms));
    } catch (Exception e) {
      tr0.appendTcDetail(e.toString());
    }
    tr0.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_EventRequestWrapper_SIGRender_hasGetEvent */
    /* Details: "EventRequestWrapper has a getEvent()  method " */
    TestResult tr2 =
        tcd.getTestResultFailed(V2SIGTESTSWRAPPER_EVENTREQUESTWRAPPER_SIGRENDER_HASGETEVENT);
    try {
      String name = "getEvent";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr2.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr2.appendTcDetail(e.toString());
    }
    tr2.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_EventRequestWrapper_SIGRender_hasGetEventReturns */
    /* Details: "EventRequestWrapper method getEvent() returns Event " */
    TestResult tr3 =
        tcd.getTestResultFailed(V2SIGTESTSWRAPPER_EVENTREQUESTWRAPPER_SIGRENDER_HASGETEVENTRETURNS);
    try {
      String name = "getEvent";
      Class<?> retType = Event.class;
      Class<?>[] parms = null;
      tr3.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr3.appendTcDetail(e.toString());
    }
    tr3.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_EventRequestWrapper_SIGRender_hasGetMethod */
    /* Details: "EventRequestWrapper has a getMethod()  method " */
    TestResult tr4 =
        tcd.getTestResultFailed(V2SIGTESTSWRAPPER_EVENTREQUESTWRAPPER_SIGRENDER_HASGETMETHOD);
    try {
      String name = "getMethod";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr4.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr4.appendTcDetail(e.toString());
    }
    tr4.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_EventRequestWrapper_SIGRender_hasGetMethodReturns */
    /* Details: "EventRequestWrapper method getMethod() returns String " */
    TestResult tr5 = tcd
        .getTestResultFailed(V2SIGTESTSWRAPPER_EVENTREQUESTWRAPPER_SIGRENDER_HASGETMETHODRETURNS);
    try {
      String name = "getMethod";
      Class<?> retType = String.class;
      Class<?>[] parms = null;
      tr5.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr5.appendTcDetail(e.toString());
    }
    tr5.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_EventRequestWrapper_SIGRender_hasGetRequest */
    /* Details: "EventRequestWrapper has a getRequest()  method " */
    TestResult tr6 =
        tcd.getTestResultFailed(V2SIGTESTSWRAPPER_EVENTREQUESTWRAPPER_SIGRENDER_HASGETREQUEST);
    try {
      String name = "getRequest";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr6.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr6.appendTcDetail(e.toString());
    }
    tr6.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_EventRequestWrapper_SIGRender_hasGetRequestA */
    /* Details: "EventRequestWrapper has a getRequest()  method " */
    TestResult tr7 =
        tcd.getTestResultFailed(V2SIGTESTSWRAPPER_EVENTREQUESTWRAPPER_SIGRENDER_HASGETREQUESTA);
    try {
      String name = "getRequest";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr7.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr7.appendTcDetail(e.toString());
    }
    tr7.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_EventRequestWrapper_SIGRender_hasGetRequestReturns */
    /* Details: "EventRequestWrapper method getRequest() returns */
    /* EventRequest " */
    TestResult tr8 = tcd
        .getTestResultFailed(V2SIGTESTSWRAPPER_EVENTREQUESTWRAPPER_SIGRENDER_HASGETREQUESTRETURNS);
    try {
      String name = "getRequest";
      Class<?> retType = EventRequest.class;
      Class<?>[] parms = null;
      tr8.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr8.appendTcDetail(e.toString());
    }
    tr8.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_EventRequestWrapper_SIGRender_hasGetRequestReturnsA */
    /* Details: "EventRequestWrapper method getRequest() returns */
    /* PortletRequest " */
    TestResult tr9 = tcd
        .getTestResultFailed(V2SIGTESTSWRAPPER_EVENTREQUESTWRAPPER_SIGRENDER_HASGETREQUESTRETURNSA);
    try {
      String name = "getRequest";
      Class<?> retType = PortletRequest.class;
      Class<?>[] parms = null;
      tr9.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr9.appendTcDetail(e.toString());
    }
    tr9.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_EventRequestWrapper_SIGRender_hasSetRequest */
    /* Details: "EventRequestWrapper has a setRequest(EventRequest) */
    /* method " */
    TestResult tr10 =
        tcd.getTestResultFailed(V2SIGTESTSWRAPPER_EVENTREQUESTWRAPPER_SIGRENDER_HASSETREQUEST);
    try {
      String name = "setRequest";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {EventRequest.class};
      tr10.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr10.appendTcDetail(e.toString());
    }
    tr10.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_EventRequestWrapper_SIGRender_hasSetRequestReturns */
    /* Details: "EventRequestWrapper method setRequest(EventRequest) */
    /* returns void " */
    TestResult tr11 = tcd
        .getTestResultFailed(V2SIGTESTSWRAPPER_EVENTREQUESTWRAPPER_SIGRENDER_HASSETREQUESTRETURNS);
    try {
      String name = "setRequest";
      Class<?> retType = void.class;
      Class<?>[] parms = {EventRequest.class};
      tr11.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr11.appendTcDetail(e.toString());
    }
    tr11.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_EventRequestWrapper_SIGRender_implementsEventRequest */
    /* Details: "EventRequestWrapper implements EventRequest " */
    TestResult tr12 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_EVENTREQUESTWRAPPER_SIGRENDER_IMPLEMENTSEVENTREQUEST);
    try {
      tr12.setTcSuccess(cc.implementsInterface(EventRequest.class));
    } catch (Exception e) {
      tr12.appendTcDetail(e.toString());
    }
    tr12.writeTo(writer);

  }

}
