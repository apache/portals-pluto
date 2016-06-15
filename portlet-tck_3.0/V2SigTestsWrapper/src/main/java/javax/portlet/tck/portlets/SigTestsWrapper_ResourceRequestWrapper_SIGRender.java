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
import javax.portlet.ResourceRequest;
import javax.portlet.filter.ResourceRequestWrapper;
import javax.portlet.tck.beans.ClassChecker;
import javax.portlet.tck.beans.JSR286SignatureTestCaseDetails;
import javax.portlet.tck.beans.TestResult;

import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_CONSTRUCTOR;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETCACHEABILITY;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETCACHEABILITYRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETCHARACTERENCODING;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETCHARACTERENCODINGRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETCONTENTLENGTH;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETCONTENTLENGTHRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETCONTENTTYPE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETCONTENTTYPERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETETAG;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETETAGRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETMETHOD;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETMETHODRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETPORTLETINPUTSTREAM;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETPORTLETINPUTSTREAMRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETPRIVATERENDERPARAMETERMAP;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETPRIVATERENDERPARAMETERMAPRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETREADER;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETREADERRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETREQUEST;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETREQUESTA;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETREQUESTRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETREQUESTRETURNSA;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETRESOURCEID;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETRESOURCEIDRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASSETCHARACTERENCODING;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASSETCHARACTERENCODINGRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASSETREQUEST;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASSETREQUESTRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_IMPLEMENTSRESOURCEREQUEST;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined
 * in the /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate
 * the test case names defined in the additionalTCs.xml file into the complete list of test case
 * names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will
 * initiate the events, but not process them. The processing is done in the companion portlet
 * SigTestsWrapper_ResourceRequestWrapper_SIGRender_event
 *
 */
public class SigTestsWrapper_ResourceRequestWrapper_SIGRender implements Portlet {

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

    ClassChecker cc = new ClassChecker(ResourceRequestWrapper.class);

    /* TestCase: V2SigTestsWrapper_ResourceRequestWrapper_SIGRender_constructor */
    /* Details: "ResourceRequestWrapper provides constructor */
    /* ResourceRequestWrapper(ResourceRequest) " */
    TestResult tr0 =
        tcd.getTestResultFailed(V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_CONSTRUCTOR);
    try {
      Class<?>[] parms = {ResourceRequest.class};
      tr0.setTcSuccess(cc.hasConstructor(parms));
    } catch (Exception e) {
      tr0.appendTcDetail(e.toString());
    }
    tr0.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ResourceRequestWrapper_SIGRender_hasGetCacheability */
    /* Details: "ResourceRequestWrapper has a getCacheability()  method " */
    TestResult tr2 = tcd
        .getTestResultFailed(V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETCACHEABILITY);
    try {
      String name = "getCacheability";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr2.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr2.appendTcDetail(e.toString());
    }
    tr2.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ResourceRequestWrapper_SIGRender_hasGetCacheabilityReturns */
    /* Details: "ResourceRequestWrapper method getCacheability() returns */
    /* String " */
    TestResult tr3 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETCACHEABILITYRETURNS);
    try {
      String name = "getCacheability";
      Class<?> retType = String.class;
      Class<?>[] parms = null;
      tr3.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr3.appendTcDetail(e.toString());
    }
    tr3.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ResourceRequestWrapper_SIGRender_hasGetCharacterEncoding */
    /* Details: "ResourceRequestWrapper has a getCharacterEncoding() */
    /* method " */
    TestResult tr4 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETCHARACTERENCODING);
    try {
      String name = "getCharacterEncoding";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr4.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr4.appendTcDetail(e.toString());
    }
    tr4.writeTo(writer);

    /*
     * TestCase: V2SigTestsWrapper_ResourceRequestWrapper_SIGRender_hasGetCharacterEncodingReturns
     */
    /* Details: "ResourceRequestWrapper method getCharacterEncoding() */
    /* returns String " */
    TestResult tr5 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETCHARACTERENCODINGRETURNS);
    try {
      String name = "getCharacterEncoding";
      Class<?> retType = String.class;
      Class<?>[] parms = null;
      tr5.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr5.appendTcDetail(e.toString());
    }
    tr5.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ResourceRequestWrapper_SIGRender_hasGetContentLength */
    /* Details: "ResourceRequestWrapper has a getContentLength() method */
    /* " */
    TestResult tr6 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETCONTENTLENGTH);
    try {
      String name = "getContentLength";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr6.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr6.appendTcDetail(e.toString());
    }
    tr6.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ResourceRequestWrapper_SIGRender_hasGetContentLengthReturns */
    /* Details: "ResourceRequestWrapper method getContentLength() returns */
    /* int " */
    TestResult tr7 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETCONTENTLENGTHRETURNS);
    try {
      String name = "getContentLength";
      Class<?> retType = int.class;
      Class<?>[] parms = null;
      tr7.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr7.appendTcDetail(e.toString());
    }
    tr7.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ResourceRequestWrapper_SIGRender_hasGetContentType */
    /* Details: "ResourceRequestWrapper has a getContentType()  method " */
    TestResult tr8 = tcd
        .getTestResultFailed(V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETCONTENTTYPE);
    try {
      String name = "getContentType";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr8.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr8.appendTcDetail(e.toString());
    }
    tr8.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ResourceRequestWrapper_SIGRender_hasGetContentTypeReturns */
    /* Details: "ResourceRequestWrapper method getContentType() returns */
    /* String " */
    TestResult tr9 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETCONTENTTYPERETURNS);
    try {
      String name = "getContentType";
      Class<?> retType = String.class;
      Class<?>[] parms = null;
      tr9.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr9.appendTcDetail(e.toString());
    }
    tr9.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ResourceRequestWrapper_SIGRender_hasGetETag */
    /* Details: "ResourceRequestWrapper has a getETag()  method " */
    TestResult tr10 =
        tcd.getTestResultFailed(V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETETAG);
    try {
      String name = "getETag";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr10.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr10.appendTcDetail(e.toString());
    }
    tr10.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ResourceRequestWrapper_SIGRender_hasGetETagReturns */
    /* Details: "ResourceRequestWrapper method getETag() returns String " */
    TestResult tr11 = tcd
        .getTestResultFailed(V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETETAGRETURNS);
    try {
      String name = "getETag";
      Class<?> retType = String.class;
      Class<?>[] parms = null;
      tr11.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr11.appendTcDetail(e.toString());
    }
    tr11.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ResourceRequestWrapper_SIGRender_hasGetMethod */
    /* Details: "ResourceRequestWrapper has a getMethod()  method " */
    TestResult tr12 =
        tcd.getTestResultFailed(V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETMETHOD);
    try {
      String name = "getMethod";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr12.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr12.appendTcDetail(e.toString());
    }
    tr12.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ResourceRequestWrapper_SIGRender_hasGetMethodReturns */
    /* Details: "ResourceRequestWrapper method getMethod() returns String */
    /* " */
    TestResult tr13 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETMETHODRETURNS);
    try {
      String name = "getMethod";
      Class<?> retType = String.class;
      Class<?>[] parms = null;
      tr13.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr13.appendTcDetail(e.toString());
    }
    tr13.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ResourceRequestWrapper_SIGRender_hasGetPortletInputStream */
    /* Details: "ResourceRequestWrapper has a getPortletInputStream() */
    /* throws java.io.IOException method " */
    TestResult tr14 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETPORTLETINPUTSTREAM);
    try {
      String name = "getPortletInputStream";
      Class<?>[] exceptions = {java.io.IOException.class};
      Class<?>[] parms = null;
      tr14.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr14.appendTcDetail(e.toString());
    }
    tr14.writeTo(writer);

    /*
     * TestCase: V2SigTestsWrapper_ResourceRequestWrapper_SIGRender_hasGetPortletInputStreamReturns
     */
    /* Details: "ResourceRequestWrapper method getPortletInputStream() */
    /* returns java.io.InputStream " */
    TestResult tr15 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETPORTLETINPUTSTREAMRETURNS);
    try {
      String name = "getPortletInputStream";
      Class<?> retType = java.io.InputStream.class;
      Class<?>[] parms = null;
      tr15.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr15.appendTcDetail(e.toString());
    }
    tr15.writeTo(writer);

    /*
     * TestCase: V2SigTestsWrapper_ResourceRequestWrapper_SIGRender_hasGetPrivateRenderParameterMap
     */
    /* Details: "ResourceRequestWrapper has a */
    /* getPrivateRenderParameterMap() method " */
    TestResult tr16 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETPRIVATERENDERPARAMETERMAP);
    try {
      String name = "getPrivateRenderParameterMap";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr16.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr16.appendTcDetail(e.toString());
    }
    tr16.writeTo(writer);

    /*
     * TestCase:
     * V2SigTestsWrapper_ResourceRequestWrapper_SIGRender_hasGetPrivateRenderParameterMapReturns
     */
    /* Details: "ResourceRequestWrapper method */
    /* getPrivateRenderParameterMap() returns java.util.Map " */
    TestResult tr17 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETPRIVATERENDERPARAMETERMAPRETURNS);
    try {
      String name = "getPrivateRenderParameterMap";
      Class<?> retType = java.util.Map.class;
      Class<?>[] parms = null;
      tr17.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr17.appendTcDetail(e.toString());
    }
    tr17.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ResourceRequestWrapper_SIGRender_hasGetReader */
    /* Details: "ResourceRequestWrapper has a getReader() throws */
    /* java.io.UnsupportedEncodingException, java.io.IOException method " */
    TestResult tr18 =
        tcd.getTestResultFailed(V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETREADER);
    try {
      String name = "getReader";
      Class<?>[] exceptions =
          {java.io.UnsupportedEncodingException.class, java.io.IOException.class};
      Class<?>[] parms = null;
      tr18.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr18.appendTcDetail(e.toString());
    }
    tr18.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ResourceRequestWrapper_SIGRender_hasGetReaderReturns */
    /* Details: "ResourceRequestWrapper method getReader() returns */
    /* java.io.BufferedReader " */
    TestResult tr19 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETREADERRETURNS);
    try {
      String name = "getReader";
      Class<?> retType = java.io.BufferedReader.class;
      Class<?>[] parms = null;
      tr19.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr19.appendTcDetail(e.toString());
    }
    tr19.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ResourceRequestWrapper_SIGRender_hasGetRequest */
    /* Details: "ResourceRequestWrapper has a getRequest()  method " */
    TestResult tr20 =
        tcd.getTestResultFailed(V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETREQUEST);
    try {
      String name = "getRequest";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr20.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr20.appendTcDetail(e.toString());
    }
    tr20.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ResourceRequestWrapper_SIGRender_hasGetRequestA */
    /* Details: "ResourceRequestWrapper has a getRequest()  method " */
    TestResult tr21 =
        tcd.getTestResultFailed(V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETREQUESTA);
    try {
      String name = "getRequest";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr21.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr21.appendTcDetail(e.toString());
    }
    tr21.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ResourceRequestWrapper_SIGRender_hasGetRequestReturns */
    /* Details: "ResourceRequestWrapper method getRequest() returns */
    /* ResourceRequest " */
    TestResult tr22 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETREQUESTRETURNS);
    try {
      String name = "getRequest";
      Class<?> retType = ResourceRequest.class;
      Class<?>[] parms = null;
      tr22.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr22.appendTcDetail(e.toString());
    }
    tr22.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ResourceRequestWrapper_SIGRender_hasGetRequestReturnsA */
    /* Details: "ResourceRequestWrapper method getRequest() returns */
    /* PortletRequest " */
    TestResult tr23 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETREQUESTRETURNSA);
    try {
      String name = "getRequest";
      Class<?> retType = PortletRequest.class;
      Class<?>[] parms = null;
      tr23.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr23.appendTcDetail(e.toString());
    }
    tr23.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ResourceRequestWrapper_SIGRender_hasGetResourceID */
    /* Details: "ResourceRequestWrapper has a getResourceID()  method " */
    TestResult tr24 = tcd
        .getTestResultFailed(V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETRESOURCEID);
    try {
      String name = "getResourceID";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr24.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr24.appendTcDetail(e.toString());
    }
    tr24.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ResourceRequestWrapper_SIGRender_hasGetResourceIDReturns */
    /* Details: "ResourceRequestWrapper method getResourceID() returns */
    /* String " */
    TestResult tr25 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETRESOURCEIDRETURNS);
    try {
      String name = "getResourceID";
      Class<?> retType = String.class;
      Class<?>[] parms = null;
      tr25.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr25.appendTcDetail(e.toString());
    }
    tr25.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ResourceRequestWrapper_SIGRender_hasSetCharacterEncoding */
    /* Details: "ResourceRequestWrapper has a */
    /* setCharacterEncoding(String) throws */
    /* java.io.UnsupportedEncodingException method " */
    TestResult tr26 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASSETCHARACTERENCODING);
    try {
      String name = "setCharacterEncoding";
      Class<?>[] exceptions = {java.io.UnsupportedEncodingException.class};
      Class<?>[] parms = {String.class};
      tr26.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr26.appendTcDetail(e.toString());
    }
    tr26.writeTo(writer);

    /*
     * TestCase: V2SigTestsWrapper_ResourceRequestWrapper_SIGRender_hasSetCharacterEncodingReturns
     */
    /* Details: "ResourceRequestWrapper method */
    /* setCharacterEncoding(String) returns void " */
    TestResult tr27 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASSETCHARACTERENCODINGRETURNS);
    try {
      String name = "setCharacterEncoding";
      Class<?> retType = void.class;
      Class<?>[] parms = {String.class};
      tr27.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr27.appendTcDetail(e.toString());
    }
    tr27.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ResourceRequestWrapper_SIGRender_hasSetRequest */
    /* Details: "ResourceRequestWrapper has a setRequest(ResourceRequest) */
    /* method " */
    TestResult tr28 =
        tcd.getTestResultFailed(V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASSETREQUEST);
    try {
      String name = "setRequest";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {ResourceRequest.class};
      tr28.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr28.appendTcDetail(e.toString());
    }
    tr28.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ResourceRequestWrapper_SIGRender_hasSetRequestReturns */
    /* Details: "ResourceRequestWrapper method */
    /* setRequest(ResourceRequest) returns void " */
    TestResult tr29 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASSETREQUESTRETURNS);
    try {
      String name = "setRequest";
      Class<?> retType = void.class;
      Class<?>[] parms = {ResourceRequest.class};
      tr29.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr29.appendTcDetail(e.toString());
    }
    tr29.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_ResourceRequestWrapper_SIGRender_implementsResourceRequest */
    /* Details: "ResourceRequestWrapper implements ResourceRequest " */
    TestResult tr30 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_IMPLEMENTSRESOURCEREQUEST);
    try {
      tr30.setTcSuccess(cc.implementsInterface(ResourceRequest.class));
    } catch (Exception e) {
      tr30.appendTcDetail(e.toString());
    }
    tr30.writeTo(writer);

  }

}
