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
import javax.portlet.tck.beans.ClassChecker;
import javax.portlet.tck.beans.JSR286SignatureTestCaseDetails;
import javax.portlet.tck.beans.TestResult;

import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_FIELDCACHE_SCOPE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_FIELDETAG;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_FIELDEXPIRATION_CACHE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_FIELDMARKUP_HEAD_ELEMENT;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_FIELDNAMESPACED_RESPONSE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_FIELDPRIVATE_SCOPE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_FIELDPUBLIC_SCOPE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_FIELDUSE_CACHED_CONTENT;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASCREATEACTIONURL;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASCREATEACTIONURLRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASCREATERENDERURL;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASCREATERENDERURLRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASCREATERESOURCEURL;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASCREATERESOURCEURLRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASFLUSHBUFFER;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASFLUSHBUFFERRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASGETBUFFERSIZE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASGETBUFFERSIZERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASGETCACHECONTROL;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASGETCACHECONTROLRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASGETCHARACTERENCODING;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASGETCHARACTERENCODINGRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASGETCONTENTTYPE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASGETCONTENTTYPERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASGETLOCALE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASGETLOCALERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASGETPORTLETOUTPUTSTREAM;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASGETPORTLETOUTPUTSTREAMRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASGETWRITER;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASGETWRITERRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASISCOMMITTED;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASISCOMMITTEDRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASRESET;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASRESETBUFFER;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASRESETBUFFERRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASRESETRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASSETBUFFERSIZE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASSETBUFFERSIZERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASSETCONTENTTYPE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASSETCONTENTTYPERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_IMPLEMENTSPORTLETRESPONSE;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined
 * in the /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate
 * the test case names defined in the additionalTCs.xml file into the complete list of test case
 * names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will
 * initiate the events, but not process them. The processing is done in the companion portlet
 * SigTestsRender_MimeResponse_SIGRender_event
 *
 */
public class SigTestsRender_MimeResponse_SIGRender implements Portlet {

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

    ClassChecker cc = new ClassChecker(portletResp.getClass());

    /* TestCase: V2SigTestsRender_MimeResponse_SIGRender_fieldCACHE_SCOPE */
    /* Details: "RenderResponse has String field CACHE_SCOPE " */
    TestResult tr0 =
        tcd.getTestResultFailed(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_FIELDCACHE_SCOPE);
    try {
      tr0.setTcSuccess(cc.hasField("CACHE_SCOPE"));
    } catch (Exception e) {
      tr0.appendTcDetail(e.toString());
    }
    tr0.writeTo(writer);

    /* TestCase: V2SigTestsRender_MimeResponse_SIGRender_fieldETAG */
    /* Details: "RenderResponse has String field ETAG " */
    TestResult tr1 = tcd.getTestResultFailed(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_FIELDETAG);
    try {
      tr1.setTcSuccess(cc.hasField("ETAG"));
    } catch (Exception e) {
      tr1.appendTcDetail(e.toString());
    }
    tr1.writeTo(writer);

    /* TestCase: V2SigTestsRender_MimeResponse_SIGRender_fieldEXPIRATION_CACHE */
    /* Details: "RenderResponse has String field EXPIRATION_CACHE " */
    TestResult tr2 =
        tcd.getTestResultFailed(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_FIELDEXPIRATION_CACHE);
    try {
      tr2.setTcSuccess(cc.hasField("EXPIRATION_CACHE"));
    } catch (Exception e) {
      tr2.appendTcDetail(e.toString());
    }
    tr2.writeTo(writer);

    /* TestCase: V2SigTestsRender_MimeResponse_SIGRender_fieldMARKUP_HEAD_ELEMENT */
    /* Details: "RenderResponse has String field MARKUP_HEAD_ELEMENT " */
    TestResult tr3 =
        tcd.getTestResultFailed(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_FIELDMARKUP_HEAD_ELEMENT);
    try {
      tr3.setTcSuccess(cc.hasField("MARKUP_HEAD_ELEMENT"));
    } catch (Exception e) {
      tr3.appendTcDetail(e.toString());
    }
    tr3.writeTo(writer);

    /* TestCase: V2SigTestsRender_MimeResponse_SIGRender_fieldNAMESPACED_RESPONSE */
    /* Details: "RenderResponse has String field NAMESPACED_RESPONSE " */
    TestResult tr4 =
        tcd.getTestResultFailed(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_FIELDNAMESPACED_RESPONSE);
    try {
      tr4.setTcSuccess(cc.hasField("NAMESPACED_RESPONSE"));
    } catch (Exception e) {
      tr4.appendTcDetail(e.toString());
    }
    tr4.writeTo(writer);

    /* TestCase: V2SigTestsRender_MimeResponse_SIGRender_fieldPRIVATE_SCOPE */
    /* Details: "RenderResponse has String field PRIVATE_SCOPE " */
    TestResult tr5 =
        tcd.getTestResultFailed(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_FIELDPRIVATE_SCOPE);
    try {
      tr5.setTcSuccess(cc.hasField("PRIVATE_SCOPE"));
    } catch (Exception e) {
      tr5.appendTcDetail(e.toString());
    }
    tr5.writeTo(writer);

    /* TestCase: V2SigTestsRender_MimeResponse_SIGRender_fieldPUBLIC_SCOPE */
    /* Details: "RenderResponse has String field PUBLIC_SCOPE " */
    TestResult tr6 =
        tcd.getTestResultFailed(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_FIELDPUBLIC_SCOPE);
    try {
      tr6.setTcSuccess(cc.hasField("PUBLIC_SCOPE"));
    } catch (Exception e) {
      tr6.appendTcDetail(e.toString());
    }
    tr6.writeTo(writer);

    /* TestCase: V2SigTestsRender_MimeResponse_SIGRender_fieldUSE_CACHED_CONTENT */
    /* Details: "RenderResponse has String field USE_CACHED_CONTENT " */
    TestResult tr7 =
        tcd.getTestResultFailed(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_FIELDUSE_CACHED_CONTENT);
    try {
      tr7.setTcSuccess(cc.hasField("USE_CACHED_CONTENT"));
    } catch (Exception e) {
      tr7.appendTcDetail(e.toString());
    }
    tr7.writeTo(writer);

    /* TestCase: V2SigTestsRender_MimeResponse_SIGRender_hasCreateActionURL */
    /* Details: "RenderResponse has a createActionURL()  method " */
    TestResult tr8 =
        tcd.getTestResultFailed(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASCREATEACTIONURL);
    try {
      String name = "createActionURL";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr8.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr8.appendTcDetail(e.toString());
    }
    tr8.writeTo(writer);

    /* TestCase: V2SigTestsRender_MimeResponse_SIGRender_hasCreateActionURLReturns */
    /* Details: "RenderResponse method createActionURL() returns */
    /* PortletURL " */
    TestResult tr9 =
        tcd.getTestResultFailed(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASCREATEACTIONURLRETURNS);
    try {
      String name = "createActionURL";
      Class<?> retType = PortletURL.class;
      Class<?>[] parms = null;
      tr9.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr9.appendTcDetail(e.toString());
    }
    tr9.writeTo(writer);

    /* TestCase: V2SigTestsRender_MimeResponse_SIGRender_hasCreateRenderURL */
    /* Details: "RenderResponse has a createRenderURL()  method " */
    TestResult tr10 =
        tcd.getTestResultFailed(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASCREATERENDERURL);
    try {
      String name = "createRenderURL";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr10.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr10.appendTcDetail(e.toString());
    }
    tr10.writeTo(writer);

    /* TestCase: V2SigTestsRender_MimeResponse_SIGRender_hasCreateRenderURLReturns */
    /* Details: "RenderResponse method createRenderURL() returns */
    /* PortletURL " */
    TestResult tr11 =
        tcd.getTestResultFailed(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASCREATERENDERURLRETURNS);
    try {
      String name = "createRenderURL";
      Class<?> retType = PortletURL.class;
      Class<?>[] parms = null;
      tr11.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr11.appendTcDetail(e.toString());
    }
    tr11.writeTo(writer);

    /* TestCase: V2SigTestsRender_MimeResponse_SIGRender_hasCreateResourceURL */
    /* Details: "RenderResponse has a createResourceURL()  method " */
    TestResult tr12 =
        tcd.getTestResultFailed(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASCREATERESOURCEURL);
    try {
      String name = "createResourceURL";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr12.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr12.appendTcDetail(e.toString());
    }
    tr12.writeTo(writer);

    /* TestCase: V2SigTestsRender_MimeResponse_SIGRender_hasCreateResourceURLReturns */
    /* Details: "RenderResponse method createResourceURL() returns */
    /* ResourceURL " */
    TestResult tr13 = tcd
        .getTestResultFailed(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASCREATERESOURCEURLRETURNS);
    try {
      String name = "createResourceURL";
      Class<?> retType = ResourceURL.class;
      Class<?>[] parms = null;
      tr13.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr13.appendTcDetail(e.toString());
    }
    tr13.writeTo(writer);

    /* TestCase: V2SigTestsRender_MimeResponse_SIGRender_hasFlushBuffer */
    /* Details: "RenderResponse has a flushBuffer() throws */
    /* java.io.IOException method " */
    TestResult tr14 =
        tcd.getTestResultFailed(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASFLUSHBUFFER);
    try {
      String name = "flushBuffer";
      Class<?>[] exceptions = {java.io.IOException.class};
      Class<?>[] parms = null;
      tr14.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr14.appendTcDetail(e.toString());
    }
    tr14.writeTo(writer);

    /* TestCase: V2SigTestsRender_MimeResponse_SIGRender_hasFlushBufferReturns */
    /* Details: "RenderResponse method flushBuffer() returns void " */
    TestResult tr15 =
        tcd.getTestResultFailed(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASFLUSHBUFFERRETURNS);
    try {
      String name = "flushBuffer";
      Class<?> retType = void.class;
      Class<?>[] parms = null;
      tr15.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr15.appendTcDetail(e.toString());
    }
    tr15.writeTo(writer);

    /* TestCase: V2SigTestsRender_MimeResponse_SIGRender_hasGetBufferSize */
    /* Details: "RenderResponse has a getBufferSize()  method " */
    TestResult tr16 =
        tcd.getTestResultFailed(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASGETBUFFERSIZE);
    try {
      String name = "getBufferSize";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr16.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr16.appendTcDetail(e.toString());
    }
    tr16.writeTo(writer);

    /* TestCase: V2SigTestsRender_MimeResponse_SIGRender_hasGetBufferSizeReturns */
    /* Details: "RenderResponse method getBufferSize() returns int " */
    TestResult tr17 =
        tcd.getTestResultFailed(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASGETBUFFERSIZERETURNS);
    try {
      String name = "getBufferSize";
      Class<?> retType = int.class;
      Class<?>[] parms = null;
      tr17.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr17.appendTcDetail(e.toString());
    }
    tr17.writeTo(writer);

    /* TestCase: V2SigTestsRender_MimeResponse_SIGRender_hasGetCacheControl */
    /* Details: "RenderResponse has a getCacheControl()  method " */
    TestResult tr18 =
        tcd.getTestResultFailed(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASGETCACHECONTROL);
    try {
      String name = "getCacheControl";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr18.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr18.appendTcDetail(e.toString());
    }
    tr18.writeTo(writer);

    /* TestCase: V2SigTestsRender_MimeResponse_SIGRender_hasGetCacheControlReturns */
    /* Details: "RenderResponse method getCacheControl() returns */
    /* CacheControl " */
    TestResult tr19 =
        tcd.getTestResultFailed(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASGETCACHECONTROLRETURNS);
    try {
      String name = "getCacheControl";
      Class<?> retType = CacheControl.class;
      Class<?>[] parms = null;
      tr19.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr19.appendTcDetail(e.toString());
    }
    tr19.writeTo(writer);

    /* TestCase: V2SigTestsRender_MimeResponse_SIGRender_hasGetCharacterEncoding */
    /* Details: "RenderResponse has a getCharacterEncoding()  method " */
    TestResult tr20 =
        tcd.getTestResultFailed(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASGETCHARACTERENCODING);
    try {
      String name = "getCharacterEncoding";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr20.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr20.appendTcDetail(e.toString());
    }
    tr20.writeTo(writer);

    /* TestCase: V2SigTestsRender_MimeResponse_SIGRender_hasGetCharacterEncodingReturns */
    /* Details: "RenderResponse method getCharacterEncoding() returns */
    /* String " */
    TestResult tr21 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASGETCHARACTERENCODINGRETURNS);
    try {
      String name = "getCharacterEncoding";
      Class<?> retType = String.class;
      Class<?>[] parms = null;
      tr21.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr21.appendTcDetail(e.toString());
    }
    tr21.writeTo(writer);

    /* TestCase: V2SigTestsRender_MimeResponse_SIGRender_hasGetContentType */
    /* Details: "RenderResponse has a getContentType()  method " */
    TestResult tr22 =
        tcd.getTestResultFailed(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASGETCONTENTTYPE);
    try {
      String name = "getContentType";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr22.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr22.appendTcDetail(e.toString());
    }
    tr22.writeTo(writer);

    /* TestCase: V2SigTestsRender_MimeResponse_SIGRender_hasGetContentTypeReturns */
    /* Details: "RenderResponse method getContentType() returns String " */
    TestResult tr23 =
        tcd.getTestResultFailed(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASGETCONTENTTYPERETURNS);
    try {
      String name = "getContentType";
      Class<?> retType = String.class;
      Class<?>[] parms = null;
      tr23.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr23.appendTcDetail(e.toString());
    }
    tr23.writeTo(writer);

    /* TestCase: V2SigTestsRender_MimeResponse_SIGRender_hasGetLocale */
    /* Details: "RenderResponse has a getLocale()  method " */
    TestResult tr24 = tcd.getTestResultFailed(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASGETLOCALE);
    try {
      String name = "getLocale";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr24.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr24.appendTcDetail(e.toString());
    }
    tr24.writeTo(writer);

    /* TestCase: V2SigTestsRender_MimeResponse_SIGRender_hasGetLocaleReturns */
    /* Details: "RenderResponse method getLocale() returns */
    /* java.util.Locale " */
    TestResult tr25 =
        tcd.getTestResultFailed(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASGETLOCALERETURNS);
    try {
      String name = "getLocale";
      Class<?> retType = java.util.Locale.class;
      Class<?>[] parms = null;
      tr25.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr25.appendTcDetail(e.toString());
    }
    tr25.writeTo(writer);

    /* TestCase: V2SigTestsRender_MimeResponse_SIGRender_hasGetPortletOutputStream */
    /* Details: "RenderResponse has a getPortletOutputStream() throws */
    /* java.io.IOException, IllegalStateException method " */
    TestResult tr26 =
        tcd.getTestResultFailed(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASGETPORTLETOUTPUTSTREAM);
    try {
      String name = "getPortletOutputStream";
      Class<?>[] exceptions = {java.io.IOException.class, IllegalStateException.class};
      Class<?>[] parms = null;
      tr26.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr26.appendTcDetail(e.toString());
    }
    tr26.writeTo(writer);

    /* TestCase: V2SigTestsRender_MimeResponse_SIGRender_hasGetPortletOutputStreamReturns */
    /* Details: "RenderResponse method getPortletOutputStream() returns */
    /* java.io.OutputStream " */
    TestResult tr27 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASGETPORTLETOUTPUTSTREAMRETURNS);
    try {
      String name = "getPortletOutputStream";
      Class<?> retType = java.io.OutputStream.class;
      Class<?>[] parms = null;
      tr27.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr27.appendTcDetail(e.toString());
    }
    tr27.writeTo(writer);

    /* TestCase: V2SigTestsRender_MimeResponse_SIGRender_hasGetWriter */
    /* Details: "RenderResponse has a getWriter() throws */
    /* java.io.IOException, IllegalStateException method " */
    TestResult tr28 = tcd.getTestResultFailed(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASGETWRITER);
    try {
      String name = "getWriter";
      Class<?>[] exceptions = {java.io.IOException.class, IllegalStateException.class};
      Class<?>[] parms = null;
      tr28.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr28.appendTcDetail(e.toString());
    }
    tr28.writeTo(writer);

    /* TestCase: V2SigTestsRender_MimeResponse_SIGRender_hasGetWriterReturns */
    /* Details: "RenderResponse method getWriter() returns */
    /* java.io.PrintWriter " */
    TestResult tr29 =
        tcd.getTestResultFailed(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASGETWRITERRETURNS);
    try {
      String name = "getWriter";
      Class<?> retType = java.io.PrintWriter.class;
      Class<?>[] parms = null;
      tr29.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr29.appendTcDetail(e.toString());
    }
    tr29.writeTo(writer);

    /* TestCase: V2SigTestsRender_MimeResponse_SIGRender_hasIsCommitted */
    /* Details: "RenderResponse has a isCommitted()  method " */
    TestResult tr30 =
        tcd.getTestResultFailed(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASISCOMMITTED);
    try {
      String name = "isCommitted";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr30.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr30.appendTcDetail(e.toString());
    }
    tr30.writeTo(writer);

    /* TestCase: V2SigTestsRender_MimeResponse_SIGRender_hasIsCommittedReturns */
    /* Details: "RenderResponse method isCommitted() returns boolean " */
    TestResult tr31 =
        tcd.getTestResultFailed(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASISCOMMITTEDRETURNS);
    try {
      String name = "isCommitted";
      Class<?> retType = boolean.class;
      Class<?>[] parms = null;
      tr31.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr31.appendTcDetail(e.toString());
    }
    tr31.writeTo(writer);

    /* TestCase: V2SigTestsRender_MimeResponse_SIGRender_hasReset */
    /* Details: "RenderResponse has a reset()  method " */
    TestResult tr32 = tcd.getTestResultFailed(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASRESET);
    try {
      String name = "reset";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr32.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr32.appendTcDetail(e.toString());
    }
    tr32.writeTo(writer);

    /* TestCase: V2SigTestsRender_MimeResponse_SIGRender_hasResetBuffer */
    /* Details: "RenderResponse has a resetBuffer()  method " */
    TestResult tr33 =
        tcd.getTestResultFailed(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASRESETBUFFER);
    try {
      String name = "resetBuffer";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr33.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr33.appendTcDetail(e.toString());
    }
    tr33.writeTo(writer);

    /* TestCase: V2SigTestsRender_MimeResponse_SIGRender_hasResetBufferReturns */
    /* Details: "RenderResponse method resetBuffer() returns void " */
    TestResult tr34 =
        tcd.getTestResultFailed(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASRESETBUFFERRETURNS);
    try {
      String name = "resetBuffer";
      Class<?> retType = void.class;
      Class<?>[] parms = null;
      tr34.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr34.appendTcDetail(e.toString());
    }
    tr34.writeTo(writer);

    /* TestCase: V2SigTestsRender_MimeResponse_SIGRender_hasResetReturns */
    /* Details: "RenderResponse method reset() returns void " */
    TestResult tr35 =
        tcd.getTestResultFailed(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASRESETRETURNS);
    try {
      String name = "reset";
      Class<?> retType = void.class;
      Class<?>[] parms = null;
      tr35.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr35.appendTcDetail(e.toString());
    }
    tr35.writeTo(writer);

    /* TestCase: V2SigTestsRender_MimeResponse_SIGRender_hasSetBufferSize */
    /* Details: "RenderResponse has a setBufferSize(int)  method " */
    TestResult tr36 =
        tcd.getTestResultFailed(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASSETBUFFERSIZE);
    try {
      String name = "setBufferSize";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {int.class};
      tr36.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr36.appendTcDetail(e.toString());
    }
    tr36.writeTo(writer);

    /* TestCase: V2SigTestsRender_MimeResponse_SIGRender_hasSetBufferSizeReturns */
    /* Details: "RenderResponse method setBufferSize(int) returns void " */
    TestResult tr37 =
        tcd.getTestResultFailed(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASSETBUFFERSIZERETURNS);
    try {
      String name = "setBufferSize";
      Class<?> retType = void.class;
      Class<?>[] parms = {int.class};
      tr37.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr37.appendTcDetail(e.toString());
    }
    tr37.writeTo(writer);

    /* TestCase: V2SigTestsRender_MimeResponse_SIGRender_hasSetContentType */
    /* Details: "RenderResponse has a setContentType(String)  method " */
    TestResult tr38 =
        tcd.getTestResultFailed(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASSETCONTENTTYPE);
    try {
      String name = "setContentType";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {String.class};
      tr38.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr38.appendTcDetail(e.toString());
    }
    tr38.writeTo(writer);

    /* TestCase: V2SigTestsRender_MimeResponse_SIGRender_hasSetContentTypeReturns */
    /* Details: "RenderResponse method setContentType(String) returns */
    /* void " */
    TestResult tr39 =
        tcd.getTestResultFailed(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASSETCONTENTTYPERETURNS);
    try {
      String name = "setContentType";
      Class<?> retType = void.class;
      Class<?>[] parms = {String.class};
      tr39.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr39.appendTcDetail(e.toString());
    }
    tr39.writeTo(writer);

    /* TestCase: V2SigTestsRender_MimeResponse_SIGRender_implementsPortletResponse */
    /* Details: "RenderResponse implements PortletResponse " */
    TestResult tr40 =
        tcd.getTestResultFailed(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_IMPLEMENTSPORTLETRESPONSE);
    try {
      tr40.setTcSuccess(cc.implementsInterface(PortletResponse.class));
    } catch (Exception e) {
      tr40.appendTcDetail(e.toString());
    }
    tr40.writeTo(writer);

  }

}
