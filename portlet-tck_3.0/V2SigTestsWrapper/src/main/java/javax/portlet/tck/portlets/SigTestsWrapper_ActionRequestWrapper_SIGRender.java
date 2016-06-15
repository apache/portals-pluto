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
import javax.portlet.filter.ActionRequestWrapper;
import javax.portlet.tck.beans.ClassChecker;
import javax.portlet.tck.beans.JSR286SignatureTestCaseDetails;
import javax.portlet.tck.beans.TestResult;

import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_CONSTRUCTOR;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASGETCHARACTERENCODING;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASGETCHARACTERENCODINGRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASGETCONTENTLENGTH;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASGETCONTENTLENGTHRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASGETCONTENTTYPE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASGETCONTENTTYPERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASGETMETHOD;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASGETMETHODRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASGETPORTLETINPUTSTREAM;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASGETPORTLETINPUTSTREAMRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASGETREADER;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASGETREADERRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASGETREQUEST;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASGETREQUESTA;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASGETREQUESTRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASGETREQUESTRETURNSA;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASSETCHARACTERENCODING;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASSETCHARACTERENCODINGRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASSETREQUEST;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASSETREQUESTRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_IMPLEMENTSACTIONREQUEST;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined
 * in the /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate
 * the test case names defined in the additionalTCs.xml file into the complete list of test case
 * names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will
 * initiate the events, but not process them. The processing is done in the companion portlet
 * SigTestsWrapper_ActionRequestWrapper_SIGRender_event
 *
 */
public class SigTestsWrapper_ActionRequestWrapper_SIGRender implements Portlet {

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

    ClassChecker cc = new ClassChecker(ActionRequestWrapper.class);

    /* TestCase: V2SigTestsWrapper_ActionRequestWrapper_SIGRender_constructor */
    /* Details: "ActionRequestWrapper provides constructor */
    /* ActionRequestWrapper(ActionRequest) " */
    TestResult tr0 =
        tcd.getTestResultFailed(V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_CONSTRUCTOR);
    try {
      Class<?>[] parms = {ActionRequest.class};
      tr0.setTcSuccess(cc.hasConstructor(parms));
    } catch (Exception e) {
      tr0.appendTcDetail(e.toString());
    }
    tr0.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ActionRequestWrapper_SIGRender_hasGetCharacterEncoding */
    /* Details: "ActionRequestWrapper has a getCharacterEncoding() */
    /* method " */
    TestResult tr2 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASGETCHARACTERENCODING);
    try {
      String name = "getCharacterEncoding";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr2.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr2.appendTcDetail(e.toString());
    }
    tr2.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ActionRequestWrapper_SIGRender_hasGetCharacterEncodingReturns */
    /* Details: "ActionRequestWrapper method getCharacterEncoding() */
    /* returns String " */
    TestResult tr3 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASGETCHARACTERENCODINGRETURNS);
    try {
      String name = "getCharacterEncoding";
      Class<?> retType = String.class;
      Class<?>[] parms = null;
      tr3.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr3.appendTcDetail(e.toString());
    }
    tr3.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ActionRequestWrapper_SIGRender_hasGetContentLength */
    /* Details: "ActionRequestWrapper has a getContentLength()  method " */
    TestResult tr4 = tcd
        .getTestResultFailed(V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASGETCONTENTLENGTH);
    try {
      String name = "getContentLength";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr4.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr4.appendTcDetail(e.toString());
    }
    tr4.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ActionRequestWrapper_SIGRender_hasGetContentLengthReturns */
    /* Details: "ActionRequestWrapper method getContentLength() returns */
    /* int " */
    TestResult tr5 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASGETCONTENTLENGTHRETURNS);
    try {
      String name = "getContentLength";
      Class<?> retType = int.class;
      Class<?>[] parms = null;
      tr5.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr5.appendTcDetail(e.toString());
    }
    tr5.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ActionRequestWrapper_SIGRender_hasGetContentType */
    /* Details: "ActionRequestWrapper has a getContentType()  method " */
    TestResult tr6 =
        tcd.getTestResultFailed(V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASGETCONTENTTYPE);
    try {
      String name = "getContentType";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr6.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr6.appendTcDetail(e.toString());
    }
    tr6.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ActionRequestWrapper_SIGRender_hasGetContentTypeReturns */
    /* Details: "ActionRequestWrapper method getContentType() returns */
    /* String " */
    TestResult tr7 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASGETCONTENTTYPERETURNS);
    try {
      String name = "getContentType";
      Class<?> retType = String.class;
      Class<?>[] parms = null;
      tr7.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr7.appendTcDetail(e.toString());
    }
    tr7.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ActionRequestWrapper_SIGRender_hasGetMethod */
    /* Details: "ActionRequestWrapper has a getMethod()  method " */
    TestResult tr8 =
        tcd.getTestResultFailed(V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASGETMETHOD);
    try {
      String name = "getMethod";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr8.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr8.appendTcDetail(e.toString());
    }
    tr8.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ActionRequestWrapper_SIGRender_hasGetMethodReturns */
    /* Details: "ActionRequestWrapper method getMethod() returns String " */
    TestResult tr9 = tcd
        .getTestResultFailed(V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASGETMETHODRETURNS);
    try {
      String name = "getMethod";
      Class<?> retType = String.class;
      Class<?>[] parms = null;
      tr9.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr9.appendTcDetail(e.toString());
    }
    tr9.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ActionRequestWrapper_SIGRender_hasGetPortletInputStream */
    /* Details: "ActionRequestWrapper has a getPortletInputStream() */
    /* throws java.io.IOException method " */
    TestResult tr10 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASGETPORTLETINPUTSTREAM);
    try {
      String name = "getPortletInputStream";
      Class<?>[] exceptions = {java.io.IOException.class};
      Class<?>[] parms = null;
      tr10.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr10.appendTcDetail(e.toString());
    }
    tr10.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ActionRequestWrapper_SIGRender_hasGetPortletInputStreamReturns */
    /* Details: "ActionRequestWrapper method getPortletInputStream() */
    /* returns java.io.InputStream " */
    TestResult tr11 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASGETPORTLETINPUTSTREAMRETURNS);
    try {
      String name = "getPortletInputStream";
      Class<?> retType = java.io.InputStream.class;
      Class<?>[] parms = null;
      tr11.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr11.appendTcDetail(e.toString());
    }
    tr11.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ActionRequestWrapper_SIGRender_hasGetReader */
    /* Details: "ActionRequestWrapper has a getReader() throws */
    /* java.io.UnsupportedEncodingException, java.io.IOException method " */
    TestResult tr12 =
        tcd.getTestResultFailed(V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASGETREADER);
    try {
      String name = "getReader";
      Class<?>[] exceptions =
          {java.io.UnsupportedEncodingException.class, java.io.IOException.class};
      Class<?>[] parms = null;
      tr12.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr12.appendTcDetail(e.toString());
    }
    tr12.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ActionRequestWrapper_SIGRender_hasGetReaderReturns */
    /* Details: "ActionRequestWrapper method getReader() returns */
    /* java.io.BufferedReader " */
    TestResult tr13 = tcd
        .getTestResultFailed(V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASGETREADERRETURNS);
    try {
      String name = "getReader";
      Class<?> retType = java.io.BufferedReader.class;
      Class<?>[] parms = null;
      tr13.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr13.appendTcDetail(e.toString());
    }
    tr13.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ActionRequestWrapper_SIGRender_hasGetRequest */
    /* Details: "ActionRequestWrapper has a getRequest()  method " */
    TestResult tr14 =
        tcd.getTestResultFailed(V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASGETREQUEST);
    try {
      String name = "getRequest";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr14.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr14.appendTcDetail(e.toString());
    }
    tr14.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ActionRequestWrapper_SIGRender_hasGetRequestA */
    /* Details: "ActionRequestWrapper has a getRequest()  method " */
    TestResult tr15 =
        tcd.getTestResultFailed(V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASGETREQUESTA);
    try {
      String name = "getRequest";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr15.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr15.appendTcDetail(e.toString());
    }
    tr15.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ActionRequestWrapper_SIGRender_hasGetRequestReturns */
    /* Details: "ActionRequestWrapper method getRequest() returns */
    /* ActionRequest " */
    TestResult tr16 = tcd
        .getTestResultFailed(V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASGETREQUESTRETURNS);
    try {
      String name = "getRequest";
      Class<?> retType = ActionRequest.class;
      Class<?>[] parms = null;
      tr16.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr16.appendTcDetail(e.toString());
    }
    tr16.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ActionRequestWrapper_SIGRender_hasGetRequestReturnsA */
    /* Details: "ActionRequestWrapper method getRequest() returns */
    /* PortletRequest " */
    TestResult tr17 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASGETREQUESTRETURNSA);
    try {
      String name = "getRequest";
      Class<?> retType = PortletRequest.class;
      Class<?>[] parms = null;
      tr17.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr17.appendTcDetail(e.toString());
    }
    tr17.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ActionRequestWrapper_SIGRender_hasSetCharacterEncoding */
    /* Details: "ActionRequestWrapper has a setCharacterEncoding(String) */
    /* throws java.io.UnsupportedEncodingException method " */
    TestResult tr18 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASSETCHARACTERENCODING);
    try {
      String name = "setCharacterEncoding";
      Class<?>[] exceptions = {java.io.UnsupportedEncodingException.class};
      Class<?>[] parms = {String.class};
      tr18.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr18.appendTcDetail(e.toString());
    }
    tr18.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ActionRequestWrapper_SIGRender_hasSetCharacterEncodingReturns */
    /* Details: "ActionRequestWrapper method setCharacterEncoding(String) */
    /* returns void " */
    TestResult tr19 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASSETCHARACTERENCODINGRETURNS);
    try {
      String name = "setCharacterEncoding";
      Class<?> retType = void.class;
      Class<?>[] parms = {String.class};
      tr19.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr19.appendTcDetail(e.toString());
    }
    tr19.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ActionRequestWrapper_SIGRender_hasSetRequest */
    /* Details: "ActionRequestWrapper has a setRequest(ActionRequest) */
    /* method " */
    TestResult tr20 =
        tcd.getTestResultFailed(V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASSETREQUEST);
    try {
      String name = "setRequest";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {ActionRequest.class};
      tr20.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr20.appendTcDetail(e.toString());
    }
    tr20.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ActionRequestWrapper_SIGRender_hasSetRequestReturns */
    /* Details: "ActionRequestWrapper method setRequest(ActionRequest) */
    /* returns void " */
    TestResult tr21 = tcd
        .getTestResultFailed(V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASSETREQUESTRETURNS);
    try {
      String name = "setRequest";
      Class<?> retType = void.class;
      Class<?>[] parms = {ActionRequest.class};
      tr21.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr21.appendTcDetail(e.toString());
    }
    tr21.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ActionRequestWrapper_SIGRender_implementsActionRequest */
    /* Details: "ActionRequestWrapper implements ActionRequest " */
    TestResult tr22 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_IMPLEMENTSACTIONREQUEST);
    try {
      tr22.setTcSuccess(cc.implementsInterface(ActionRequest.class));
    } catch (Exception e) {
      tr22.appendTcDetail(e.toString());
    }
    tr22.writeTo(writer);

  }

}
