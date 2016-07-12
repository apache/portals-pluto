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
import javax.portlet.PortletResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.filter.PortletResponseWrapper;
import javax.portlet.tck.beans.ClassChecker;
import javax.portlet.tck.beans.JSR286SignatureTestCaseDetails;
import javax.portlet.tck.beans.TestResult;

import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_CONSTRUCTOR;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASADDPROPERTY;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASADDPROPERTYA;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASADDPROPERTYB;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASADDPROPERTYRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASADDPROPERTYRETURNSA;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASADDPROPERTYRETURNSB;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASCREATEELEMENT;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASCREATEELEMENTRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASENCODEURL;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASENCODEURLRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASGETNAMESPACE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASGETNAMESPACERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASGETRESPONSE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASGETRESPONSERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASSETPROPERTY;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASSETPROPERTYRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASSETRESPONSE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASSETRESPONSERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_IMPLEMENTSPORTLETRESPONSE;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined
 * in the /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate
 * the test case names defined in the additionalTCs.xml file into the complete list of test case
 * names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will
 * initiate the events, but not process them. The processing is done in the companion portlet
 * SigTestsWrapper_PortletResponseWrapper_SIGRender_event
 *
 */
public class SigTestsWrapper_PortletResponseWrapper_SIGRender implements Portlet {

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

    ClassChecker cc = new ClassChecker(PortletResponseWrapper.class);

    /* TestCase: V2SigTestsWrapper_PortletResponseWrapper_SIGRender_constructor */
    /* Details: "PortletResponseWrapper provides constructor */
    /* PortletResponseWrapper(PortletResponse) " */
    TestResult tr0 =
        tcd.getTestResultFailed(V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_CONSTRUCTOR);
    try {
      Class<?>[] parms = {PortletResponse.class};
      tr0.setTcSuccess(cc.hasConstructor(parms));
    } catch (Exception e) {
      tr0.appendTcDetail(e.toString());
    }
    tr0.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_PortletResponseWrapper_SIGRender_hasAddProperty */
    /* Details: "PortletResponseWrapper has a addProperty(String, String) */
    /* method " */
    TestResult tr1 =
        tcd.getTestResultFailed(V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASADDPROPERTY);
    try {
      String name = "addProperty";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {String.class, String.class};
      tr1.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr1.appendTcDetail(e.toString());
    }
    tr1.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_PortletResponseWrapper_SIGRender_hasAddPropertyA */
    /* Details: "PortletResponseWrapper has a addProperty(String, */
    /* org.w3c.dom.Element) method " */
    TestResult tr2 =
        tcd.getTestResultFailed(V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASADDPROPERTYA);
    try {
      String name = "addProperty";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {String.class, org.w3c.dom.Element.class};
      tr2.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr2.appendTcDetail(e.toString());
    }
    tr2.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_PortletResponseWrapper_SIGRender_hasAddPropertyB */
    /* Details: "PortletResponseWrapper has a */
    /* addProperty(javax.servlet.http.Cookie) method " */
    TestResult tr3 =
        tcd.getTestResultFailed(V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASADDPROPERTYB);
    try {
      String name = "addProperty";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {javax.servlet.http.Cookie.class};
      tr3.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr3.appendTcDetail(e.toString());
    }
    tr3.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_PortletResponseWrapper_SIGRender_hasAddPropertyReturns */
    /* Details: "PortletResponseWrapper method addProperty(String, */
    /* String) returns void " */
    TestResult tr4 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASADDPROPERTYRETURNS);
    try {
      String name = "addProperty";
      Class<?> retType = void.class;
      Class<?>[] parms = {String.class, String.class};
      tr4.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr4.appendTcDetail(e.toString());
    }
    tr4.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_PortletResponseWrapper_SIGRender_hasAddPropertyReturnsA */
    /* Details: "PortletResponseWrapper method addProperty(String, */
    /* org.w3c.dom.Element) returns void " */
    TestResult tr5 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASADDPROPERTYRETURNSA);
    try {
      String name = "addProperty";
      Class<?> retType = void.class;
      Class<?>[] parms = {String.class, org.w3c.dom.Element.class};
      tr5.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr5.appendTcDetail(e.toString());
    }
    tr5.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_PortletResponseWrapper_SIGRender_hasAddPropertyReturnsB */
    /* Details: "PortletResponseWrapper method */
    /* addProperty(javax.servlet.http.Cookie) returns void " */
    TestResult tr6 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASADDPROPERTYRETURNSB);
    try {
      String name = "addProperty";
      Class<?> retType = void.class;
      Class<?>[] parms = {javax.servlet.http.Cookie.class};
      tr6.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr6.appendTcDetail(e.toString());
    }
    tr6.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_PortletResponseWrapper_SIGRender_hasCreateElement */
    /* Details: "PortletResponseWrapper has a createElement(String) */
    /* method " */
    TestResult tr7 = tcd
        .getTestResultFailed(V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASCREATEELEMENT);
    try {
      String name = "createElement";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {String.class};
      tr7.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr7.appendTcDetail(e.toString());
    }
    tr7.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_PortletResponseWrapper_SIGRender_hasCreateElementReturns */
    /* Details: "PortletResponseWrapper method createElement(String) */
    /* returns org.w3c.dom.Element " */
    TestResult tr8 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASCREATEELEMENTRETURNS);
    try {
      String name = "createElement";
      Class<?> retType = org.w3c.dom.Element.class;
      Class<?>[] parms = {String.class};
      tr8.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr8.appendTcDetail(e.toString());
    }
    tr8.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_PortletResponseWrapper_SIGRender_hasEncodeURL */
    /* Details: "PortletResponseWrapper has a encodeURL(String)  method " */
    TestResult tr9 =
        tcd.getTestResultFailed(V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASENCODEURL);
    try {
      String name = "encodeURL";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {String.class};
      tr9.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr9.appendTcDetail(e.toString());
    }
    tr9.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_PortletResponseWrapper_SIGRender_hasEncodeURLReturns */
    /* Details: "PortletResponseWrapper method encodeURL(String) returns */
    /* String " */
    TestResult tr10 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASENCODEURLRETURNS);
    try {
      String name = "encodeURL";
      Class<?> retType = String.class;
      Class<?>[] parms = {String.class};
      tr10.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr10.appendTcDetail(e.toString());
    }
    tr10.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_PortletResponseWrapper_SIGRender_hasGetNamespace */
    /* Details: "PortletResponseWrapper has a getNamespace()  method " */
    TestResult tr11 =
        tcd.getTestResultFailed(V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASGETNAMESPACE);
    try {
      String name = "getNamespace";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr11.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr11.appendTcDetail(e.toString());
    }
    tr11.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_PortletResponseWrapper_SIGRender_hasGetNamespaceReturns */
    /* Details: "PortletResponseWrapper method getNamespace() returns */
    /* String " */
    TestResult tr12 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASGETNAMESPACERETURNS);
    try {
      String name = "getNamespace";
      Class<?> retType = String.class;
      Class<?>[] parms = null;
      tr12.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr12.appendTcDetail(e.toString());
    }
    tr12.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_PortletResponseWrapper_SIGRender_hasGetResponse */
    /* Details: "PortletResponseWrapper has a getResponse()  method " */
    TestResult tr13 =
        tcd.getTestResultFailed(V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASGETRESPONSE);
    try {
      String name = "getResponse";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr13.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr13.appendTcDetail(e.toString());
    }
    tr13.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_PortletResponseWrapper_SIGRender_hasGetResponseReturns */
    /* Details: "PortletResponseWrapper method getResponse() returns */
    /* PortletResponse " */
    TestResult tr14 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASGETRESPONSERETURNS);
    try {
      String name = "getResponse";
      Class<?> retType = PortletResponse.class;
      Class<?>[] parms = null;
      tr14.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr14.appendTcDetail(e.toString());
    }
    tr14.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_PortletResponseWrapper_SIGRender_hasSetProperty */
    /* Details: "PortletResponseWrapper has a setProperty(String, String) */
    /* method " */
    TestResult tr15 =
        tcd.getTestResultFailed(V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASSETPROPERTY);
    try {
      String name = "setProperty";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {String.class, String.class};
      tr15.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr15.appendTcDetail(e.toString());
    }
    tr15.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_PortletResponseWrapper_SIGRender_hasSetPropertyReturns */
    /* Details: "PortletResponseWrapper method setProperty(String, */
    /* String) returns void " */
    TestResult tr16 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASSETPROPERTYRETURNS);
    try {
      String name = "setProperty";
      Class<?> retType = void.class;
      Class<?>[] parms = {String.class, String.class};
      tr16.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr16.appendTcDetail(e.toString());
    }
    tr16.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_PortletResponseWrapper_SIGRender_hasSetResponse */
    /* Details: "PortletResponseWrapper has a */
    /* setResponse(PortletResponse) method " */
    TestResult tr17 =
        tcd.getTestResultFailed(V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASSETRESPONSE);
    try {
      String name = "setResponse";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {PortletResponse.class};
      tr17.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr17.appendTcDetail(e.toString());
    }
    tr17.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_PortletResponseWrapper_SIGRender_hasSetResponseReturns */
    /* Details: "PortletResponseWrapper method */
    /* setResponse(PortletResponse) returns void " */
    TestResult tr18 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASSETRESPONSERETURNS);
    try {
      String name = "setResponse";
      Class<?> retType = void.class;
      Class<?>[] parms = {PortletResponse.class};
      tr18.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr18.appendTcDetail(e.toString());
    }
    tr18.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_PortletResponseWrapper_SIGRender_implementsPortletResponse */
    /* Details: "PortletResponseWrapper implements PortletResponse " */
    TestResult tr19 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_IMPLEMENTSPORTLETRESPONSE);
    try {
      tr19.setTcSuccess(cc.implementsInterface(PortletResponse.class));
    } catch (Exception e) {
      tr19.appendTcDetail(e.toString());
    }
    tr19.writeTo(writer);

  }

}
