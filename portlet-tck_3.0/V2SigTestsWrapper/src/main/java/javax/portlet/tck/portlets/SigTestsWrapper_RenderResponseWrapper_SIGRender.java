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
import javax.portlet.CacheControl;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletResponse;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceURL;
import javax.portlet.filter.RenderResponseWrapper;
import javax.portlet.tck.beans.ClassChecker;
import javax.portlet.tck.beans.JSR286SignatureTestCaseDetails;
import javax.portlet.tck.beans.TestResult;

import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_CONSTRUCTOR;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASCREATEACTIONURL;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASCREATEACTIONURLRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASCREATERENDERURL;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASCREATERENDERURLRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASCREATERESOURCEURL;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASCREATERESOURCEURLRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASFLUSHBUFFER;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASFLUSHBUFFERRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETBUFFERSIZE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETBUFFERSIZERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETCACHECONTROL;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETCACHECONTROLRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETCHARACTERENCODING;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETCHARACTERENCODINGRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETCONTENTTYPE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETCONTENTTYPERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETLOCALE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETLOCALERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETPORTLETOUTPUTSTREAM;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETPORTLETOUTPUTSTREAMRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETRESPONSE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETRESPONSEA;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETRESPONSERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETRESPONSERETURNSA;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETWRITER;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETWRITERRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASISCOMMITTED;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASISCOMMITTEDRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASRESET;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASRESETBUFFER;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASRESETBUFFERRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASRESETRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASSETBUFFERSIZE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASSETBUFFERSIZERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASSETCONTENTTYPE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASSETCONTENTTYPERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASSETNEXTPOSSIBLEPORTLETMODES;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASSETNEXTPOSSIBLEPORTLETMODESRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASSETRESPONSE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASSETRESPONSERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASSETTITLE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASSETTITLERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_IMPLEMENTSRENDERRESPONSE;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined
 * in the /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate
 * the test case names defined in the additionalTCs.xml file into the complete list of test case
 * names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will
 * initiate the events, but not process them. The processing is done in the companion portlet
 * SigTestsWrapper_RenderResponseWrapper_SIGRender_event
 *
 */
public class SigTestsWrapper_RenderResponseWrapper_SIGRender implements Portlet {

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

    ClassChecker cc = new ClassChecker(RenderResponseWrapper.class);

    /* TestCase: V2SigTestsWrapper_RenderResponseWrapper_SIGRender_constructor */
    /* Details: "RenderResponseWrapper provides constructor */
    /* RenderResponseWrapper(RenderResponse) " */
    TestResult tr0 =
        tcd.getTestResultFailed(V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_CONSTRUCTOR);
    try {
      Class<?>[] parms = {RenderResponse.class};
      tr0.setTcSuccess(cc.hasConstructor(parms));
    } catch (Exception e) {
      tr0.appendTcDetail(e.toString());
    }
    tr0.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasCreateActionURL */
    /* Details: "RenderResponseWrapper has a createActionURL() throws */
    /* IllegalStateException method " */
    TestResult tr2 = tcd
        .getTestResultFailed(V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASCREATEACTIONURL);
    try {
      String name = "createActionURL";
      Class<?>[] exceptions = {IllegalStateException.class};
      Class<?>[] parms = null;
      tr2.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr2.appendTcDetail(e.toString());
    }
    tr2.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasCreateActionURLReturns */
    /* Details: "RenderResponseWrapper method createActionURL() returns */
    /* PortletURL " */
    TestResult tr3 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASCREATEACTIONURLRETURNS);
    try {
      String name = "createActionURL";
      Class<?> retType = PortletURL.class;
      Class<?>[] parms = null;
      tr3.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr3.appendTcDetail(e.toString());
    }
    tr3.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasCreateRenderURL */
    /* Details: "RenderResponseWrapper has a createRenderURL() throws */
    /* IllegalStateException method " */
    TestResult tr4 = tcd
        .getTestResultFailed(V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASCREATERENDERURL);
    try {
      String name = "createRenderURL";
      Class<?>[] exceptions = {IllegalStateException.class};
      Class<?>[] parms = null;
      tr4.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr4.appendTcDetail(e.toString());
    }
    tr4.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasCreateRenderURLReturns */
    /* Details: "RenderResponseWrapper method createRenderURL() returns */
    /* PortletURL " */
    TestResult tr5 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASCREATERENDERURLRETURNS);
    try {
      String name = "createRenderURL";
      Class<?> retType = PortletURL.class;
      Class<?>[] parms = null;
      tr5.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr5.appendTcDetail(e.toString());
    }
    tr5.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasCreateResourceURL */
    /* Details: "RenderResponseWrapper has a createResourceURL() throws */
    /* IllegalStateException method " */
    TestResult tr6 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASCREATERESOURCEURL);
    try {
      String name = "createResourceURL";
      Class<?>[] exceptions = {IllegalStateException.class};
      Class<?>[] parms = null;
      tr6.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr6.appendTcDetail(e.toString());
    }
    tr6.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasCreateResourceURLReturns */
    /* Details: "RenderResponseWrapper method createResourceURL() returns */
    /* ResourceURL " */
    TestResult tr7 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASCREATERESOURCEURLRETURNS);
    try {
      String name = "createResourceURL";
      Class<?> retType = ResourceURL.class;
      Class<?>[] parms = null;
      tr7.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr7.appendTcDetail(e.toString());
    }
    tr7.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasFlushBuffer */
    /* Details: "RenderResponseWrapper has a flushBuffer() throws */
    /* java.io.IOException method " */
    TestResult tr8 =
        tcd.getTestResultFailed(V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASFLUSHBUFFER);
    try {
      String name = "flushBuffer";
      Class<?>[] exceptions = {java.io.IOException.class};
      Class<?>[] parms = null;
      tr8.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr8.appendTcDetail(e.toString());
    }
    tr8.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasFlushBufferReturns */
    /* Details: "RenderResponseWrapper method flushBuffer() returns void */
    /* " */
    TestResult tr9 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASFLUSHBUFFERRETURNS);
    try {
      String name = "flushBuffer";
      Class<?> retType = void.class;
      Class<?>[] parms = null;
      tr9.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr9.appendTcDetail(e.toString());
    }
    tr9.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasGetBufferSize */
    /* Details: "RenderResponseWrapper has a getBufferSize()  method " */
    TestResult tr10 =
        tcd.getTestResultFailed(V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETBUFFERSIZE);
    try {
      String name = "getBufferSize";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr10.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr10.appendTcDetail(e.toString());
    }
    tr10.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasGetBufferSizeReturns */
    /* Details: "RenderResponseWrapper method getBufferSize() returns int */
    /* " */
    TestResult tr11 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETBUFFERSIZERETURNS);
    try {
      String name = "getBufferSize";
      Class<?> retType = int.class;
      Class<?>[] parms = null;
      tr11.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr11.appendTcDetail(e.toString());
    }
    tr11.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasGetCacheControl */
    /* Details: "RenderResponseWrapper has a getCacheControl()  method " */
    TestResult tr12 = tcd
        .getTestResultFailed(V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETCACHECONTROL);
    try {
      String name = "getCacheControl";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr12.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr12.appendTcDetail(e.toString());
    }
    tr12.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasGetCacheControlReturns */
    /* Details: "RenderResponseWrapper method getCacheControl() returns */
    /* CacheControl " */
    TestResult tr13 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETCACHECONTROLRETURNS);
    try {
      String name = "getCacheControl";
      Class<?> retType = CacheControl.class;
      Class<?>[] parms = null;
      tr13.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr13.appendTcDetail(e.toString());
    }
    tr13.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasGetCharacterEncoding */
    /* Details: "RenderResponseWrapper has a getCharacterEncoding() */
    /* method " */
    TestResult tr14 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETCHARACTERENCODING);
    try {
      String name = "getCharacterEncoding";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr14.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr14.appendTcDetail(e.toString());
    }
    tr14.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasGetCharacterEncodingReturns */
    /* Details: "RenderResponseWrapper method getCharacterEncoding() */
    /* returns String " */
    TestResult tr15 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETCHARACTERENCODINGRETURNS);
    try {
      String name = "getCharacterEncoding";
      Class<?> retType = String.class;
      Class<?>[] parms = null;
      tr15.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr15.appendTcDetail(e.toString());
    }
    tr15.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasGetContentType */
    /* Details: "RenderResponseWrapper has a getContentType()  method " */
    TestResult tr16 = tcd
        .getTestResultFailed(V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETCONTENTTYPE);
    try {
      String name = "getContentType";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr16.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr16.appendTcDetail(e.toString());
    }
    tr16.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasGetContentTypeReturns */
    /* Details: "RenderResponseWrapper method getContentType() returns */
    /* String " */
    TestResult tr17 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETCONTENTTYPERETURNS);
    try {
      String name = "getContentType";
      Class<?> retType = String.class;
      Class<?>[] parms = null;
      tr17.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr17.appendTcDetail(e.toString());
    }
    tr17.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasGetLocale */
    /* Details: "RenderResponseWrapper has a getLocale()  method " */
    TestResult tr18 =
        tcd.getTestResultFailed(V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETLOCALE);
    try {
      String name = "getLocale";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr18.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr18.appendTcDetail(e.toString());
    }
    tr18.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasGetLocaleReturns */
    /* Details: "RenderResponseWrapper method getLocale() returns */
    /* java.util.Locale " */
    TestResult tr19 = tcd
        .getTestResultFailed(V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETLOCALERETURNS);
    try {
      String name = "getLocale";
      Class<?> retType = java.util.Locale.class;
      Class<?>[] parms = null;
      tr19.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr19.appendTcDetail(e.toString());
    }
    tr19.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasGetPortletOutputStream */
    /* Details: "RenderResponseWrapper has a getPortletOutputStream() */
    /* throws java.io.IOException method " */
    TestResult tr20 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETPORTLETOUTPUTSTREAM);
    try {
      String name = "getPortletOutputStream";
      Class<?>[] exceptions = {java.io.IOException.class};
      Class<?>[] parms = null;
      tr20.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr20.appendTcDetail(e.toString());
    }
    tr20.writeTo(writer);

    /*
     * TestCase: V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasGetPortletOutputStreamReturns
     */
    /* Details: "RenderResponseWrapper method getPortletOutputStream() */
    /* returns java.io.OutputStream " */
    TestResult tr21 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETPORTLETOUTPUTSTREAMRETURNS);
    try {
      String name = "getPortletOutputStream";
      Class<?> retType = java.io.OutputStream.class;
      Class<?>[] parms = null;
      tr21.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr21.appendTcDetail(e.toString());
    }
    tr21.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasGetResponse */
    /* Details: "RenderResponseWrapper has a getResponse()  method " */
    TestResult tr22 =
        tcd.getTestResultFailed(V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETRESPONSE);
    try {
      String name = "getResponse";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr22.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr22.appendTcDetail(e.toString());
    }
    tr22.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasGetResponseA */
    /* Details: "RenderResponseWrapper has a getResponse()  method " */
    TestResult tr23 =
        tcd.getTestResultFailed(V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETRESPONSEA);
    try {
      String name = "getResponse";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr23.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr23.appendTcDetail(e.toString());
    }
    tr23.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasGetResponseReturns */
    /* Details: "RenderResponseWrapper method getResponse() returns */
    /* RenderResponse " */
    TestResult tr24 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETRESPONSERETURNS);
    try {
      String name = "getResponse";
      Class<?> retType = RenderResponse.class;
      Class<?>[] parms = null;
      tr24.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr24.appendTcDetail(e.toString());
    }
    tr24.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasGetResponseReturnsA */
    /* Details: "RenderResponseWrapper method getResponse() returns */
    /* PortletResponse " */
    TestResult tr25 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETRESPONSERETURNSA);
    try {
      String name = "getResponse";
      Class<?> retType = PortletResponse.class;
      Class<?>[] parms = null;
      tr25.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr25.appendTcDetail(e.toString());
    }
    tr25.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasGetWriter */
    /* Details: "RenderResponseWrapper has a getWriter() throws */
    /* java.io.IOException method " */
    TestResult tr26 =
        tcd.getTestResultFailed(V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETWRITER);
    try {
      String name = "getWriter";
      Class<?>[] exceptions = {java.io.IOException.class};
      Class<?>[] parms = null;
      tr26.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr26.appendTcDetail(e.toString());
    }
    tr26.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasGetWriterReturns */
    /* Details: "RenderResponseWrapper method getWriter() returns */
    /* java.io.PrintWriter " */
    TestResult tr27 = tcd
        .getTestResultFailed(V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETWRITERRETURNS);
    try {
      String name = "getWriter";
      Class<?> retType = java.io.PrintWriter.class;
      Class<?>[] parms = null;
      tr27.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr27.appendTcDetail(e.toString());
    }
    tr27.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasIsCommitted */
    /* Details: "RenderResponseWrapper has a isCommitted()  method " */
    TestResult tr28 =
        tcd.getTestResultFailed(V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASISCOMMITTED);
    try {
      String name = "isCommitted";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr28.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr28.appendTcDetail(e.toString());
    }
    tr28.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasIsCommittedReturns */
    /* Details: "RenderResponseWrapper method isCommitted() returns */
    /* boolean " */
    TestResult tr29 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASISCOMMITTEDRETURNS);
    try {
      String name = "isCommitted";
      Class<?> retType = boolean.class;
      Class<?>[] parms = null;
      tr29.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr29.appendTcDetail(e.toString());
    }
    tr29.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasReset */
    /* Details: "RenderResponseWrapper has a reset()  method " */
    TestResult tr30 =
        tcd.getTestResultFailed(V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASRESET);
    try {
      String name = "reset";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr30.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr30.appendTcDetail(e.toString());
    }
    tr30.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasResetBuffer */
    /* Details: "RenderResponseWrapper has a resetBuffer()  method " */
    TestResult tr31 =
        tcd.getTestResultFailed(V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASRESETBUFFER);
    try {
      String name = "resetBuffer";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr31.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr31.appendTcDetail(e.toString());
    }
    tr31.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasResetBufferReturns */
    /* Details: "RenderResponseWrapper method resetBuffer() returns void */
    /* " */
    TestResult tr32 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASRESETBUFFERRETURNS);
    try {
      String name = "resetBuffer";
      Class<?> retType = void.class;
      Class<?>[] parms = null;
      tr32.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr32.appendTcDetail(e.toString());
    }
    tr32.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasResetReturns */
    /* Details: "RenderResponseWrapper method reset() returns void " */
    TestResult tr33 =
        tcd.getTestResultFailed(V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASRESETRETURNS);
    try {
      String name = "reset";
      Class<?> retType = void.class;
      Class<?>[] parms = null;
      tr33.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr33.appendTcDetail(e.toString());
    }
    tr33.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasSetBufferSize */
    /* Details: "RenderResponseWrapper has a setBufferSize(int)  method " */
    TestResult tr34 =
        tcd.getTestResultFailed(V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASSETBUFFERSIZE);
    try {
      String name = "setBufferSize";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {int.class};
      tr34.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr34.appendTcDetail(e.toString());
    }
    tr34.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasSetBufferSizeReturns */
    /* Details: "RenderResponseWrapper method setBufferSize(int) returns */
    /* void " */
    TestResult tr35 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASSETBUFFERSIZERETURNS);
    try {
      String name = "setBufferSize";
      Class<?> retType = void.class;
      Class<?>[] parms = {int.class};
      tr35.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr35.appendTcDetail(e.toString());
    }
    tr35.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasSetContentType */
    /* Details: "RenderResponseWrapper has a setContentType(String) */
    /* method " */
    TestResult tr36 = tcd
        .getTestResultFailed(V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASSETCONTENTTYPE);
    try {
      String name = "setContentType";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {String.class};
      tr36.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr36.appendTcDetail(e.toString());
    }
    tr36.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasSetContentTypeReturns */
    /* Details: "RenderResponseWrapper method setContentType(String) */
    /* returns void " */
    TestResult tr37 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASSETCONTENTTYPERETURNS);
    try {
      String name = "setContentType";
      Class<?> retType = void.class;
      Class<?>[] parms = {String.class};
      tr37.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr37.appendTcDetail(e.toString());
    }
    tr37.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasSetNextPossiblePortletModes */
    /* Details: "RenderResponseWrapper has a */
    /* setNextPossiblePortletModes(java.util.Collection) method " */
    TestResult tr38 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASSETNEXTPOSSIBLEPORTLETMODES);
    try {
      String name = "setNextPossiblePortletModes";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {java.util.Collection.class};
      tr38.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr38.appendTcDetail(e.toString());
    }
    tr38.writeTo(writer);

    /*
     * TestCase:
     * V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasSetNextPossiblePortletModesReturns
     */
    /* Details: "RenderResponseWrapper method */
    /* setNextPossiblePortletModes(java.util.Collection) returns void " */
    TestResult tr39 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASSETNEXTPOSSIBLEPORTLETMODESRETURNS);
    try {
      String name = "setNextPossiblePortletModes";
      Class<?> retType = void.class;
      Class<?>[] parms = {java.util.Collection.class};
      tr39.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr39.appendTcDetail(e.toString());
    }
    tr39.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasSetResponse */
    /* Details: "RenderResponseWrapper has a setResponse(RenderResponse) */
    /* method " */
    TestResult tr40 =
        tcd.getTestResultFailed(V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASSETRESPONSE);
    try {
      String name = "setResponse";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {RenderResponse.class};
      tr40.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr40.appendTcDetail(e.toString());
    }
    tr40.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasSetResponseReturns */
    /* Details: "RenderResponseWrapper method setResponse(RenderResponse) */
    /* returns void " */
    TestResult tr41 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASSETRESPONSERETURNS);
    try {
      String name = "setResponse";
      Class<?> retType = void.class;
      Class<?>[] parms = {RenderResponse.class};
      tr41.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr41.appendTcDetail(e.toString());
    }
    tr41.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasSetTitle */
    /* Details: "RenderResponseWrapper has a setTitle(String)  method " */
    TestResult tr42 =
        tcd.getTestResultFailed(V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASSETTITLE);
    try {
      String name = "setTitle";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {String.class};
      tr42.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr42.appendTcDetail(e.toString());
    }
    tr42.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasSetTitleReturns */
    /* Details: "RenderResponseWrapper method setTitle(String) returns */
    /* void " */
    TestResult tr43 = tcd
        .getTestResultFailed(V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASSETTITLERETURNS);
    try {
      String name = "setTitle";
      Class<?> retType = void.class;
      Class<?>[] parms = {String.class};
      tr43.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr43.appendTcDetail(e.toString());
    }
    tr43.writeTo(writer);

    /* TestCase: V2SigTestsWrapper_RenderResponseWrapper_SIGRender_implementsRenderResponse */
    /* Details: "RenderResponseWrapper implements RenderResponse " */
    TestResult tr44 = tcd.getTestResultFailed(
        V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_IMPLEMENTSRENDERRESPONSE);
    try {
      tr44.setTcSuccess(cc.implementsInterface(RenderResponse.class));
    } catch (Exception e) {
      tr44.appendTcDetail(e.toString());
    }
    tr44.writeTo(writer);

  }

}
