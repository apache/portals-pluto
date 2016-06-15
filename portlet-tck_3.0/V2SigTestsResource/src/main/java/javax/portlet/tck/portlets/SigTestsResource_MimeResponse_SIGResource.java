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
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceServingPortlet;
import javax.portlet.ResourceURL;
import javax.portlet.tck.beans.ClassChecker;
import javax.portlet.tck.beans.JSR286SignatureTestCaseDetails;
import javax.portlet.tck.beans.TestResult;

import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_FIELDCACHE_SCOPE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_FIELDETAG;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_FIELDEXPIRATION_CACHE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_FIELDMARKUP_HEAD_ELEMENT;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_FIELDNAMESPACED_RESPONSE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_FIELDPRIVATE_SCOPE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_FIELDPUBLIC_SCOPE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_FIELDUSE_CACHED_CONTENT;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASCREATEACTIONURL;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASCREATEACTIONURLRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASCREATERENDERURL;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASCREATERENDERURLRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASCREATERESOURCEURL;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASCREATERESOURCEURLRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASFLUSHBUFFER;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASFLUSHBUFFERRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASGETBUFFERSIZE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASGETBUFFERSIZERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASGETCACHECONTROL;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASGETCACHECONTROLRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASGETCHARACTERENCODING;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASGETCHARACTERENCODINGRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASGETCONTENTTYPE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASGETCONTENTTYPERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASGETLOCALE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASGETLOCALERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASGETPORTLETOUTPUTSTREAM;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASGETPORTLETOUTPUTSTREAMRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASGETWRITER;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASGETWRITERRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASISCOMMITTED;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASISCOMMITTEDRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASRESET;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASRESETBUFFER;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASRESETBUFFERRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASRESETRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASSETBUFFERSIZE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASSETBUFFERSIZERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASSETCONTENTTYPE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASSETCONTENTTYPERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_IMPLEMENTSPORTLETRESPONSE;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;
import static javax.portlet.ResourceURL.PAGE;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined
 * in the /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate
 * the test case names defined in the additionalTCs.xml file into the complete list of test case
 * names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will
 * initiate the events, but not process them. The processing is done in the companion portlet
 * SigTestsResource_MimeResponse_SIGResource_event
 *
 */
public class SigTestsResource_MimeResponse_SIGResource implements Portlet, ResourceServingPortlet {

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
  public void serveResource(ResourceRequest portletReq, ResourceResponse portletResp)
      throws PortletException, IOException {

    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

    PrintWriter writer = portletResp.getWriter();

    JSR286SignatureTestCaseDetails tcd = new JSR286SignatureTestCaseDetails();

    // Create result objects for the tests

    ClassChecker cc = new ClassChecker(portletResp.getClass());

    /* TestCase: V2SigTestsResource_MimeResponse_SIGResource_fieldCACHE_SCOPE */
    /* Details: "ResourceResponse has String field CACHE_SCOPE " */
    TestResult tr0 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_FIELDCACHE_SCOPE);
    try {
      tr0.setTcSuccess(cc.hasField("CACHE_SCOPE"));
    } catch (Exception e) {
      tr0.appendTcDetail(e.toString());
    }
    tr0.writeTo(writer);

    /* TestCase: V2SigTestsResource_MimeResponse_SIGResource_fieldETAG */
    /* Details: "ResourceResponse has String field ETAG " */
    TestResult tr1 = tcd.getTestResultFailed(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_FIELDETAG);
    try {
      tr1.setTcSuccess(cc.hasField("ETAG"));
    } catch (Exception e) {
      tr1.appendTcDetail(e.toString());
    }
    tr1.writeTo(writer);

    /* TestCase: V2SigTestsResource_MimeResponse_SIGResource_fieldEXPIRATION_CACHE */
    /* Details: "ResourceResponse has String field EXPIRATION_CACHE " */
    TestResult tr2 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_FIELDEXPIRATION_CACHE);
    try {
      tr2.setTcSuccess(cc.hasField("EXPIRATION_CACHE"));
    } catch (Exception e) {
      tr2.appendTcDetail(e.toString());
    }
    tr2.writeTo(writer);

    /* TestCase: V2SigTestsResource_MimeResponse_SIGResource_fieldMARKUP_HEAD_ELEMENT */
    /* Details: "ResourceResponse has String field MARKUP_HEAD_ELEMENT " */
    TestResult tr3 = tcd
        .getTestResultFailed(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_FIELDMARKUP_HEAD_ELEMENT);
    try {
      tr3.setTcSuccess(cc.hasField("MARKUP_HEAD_ELEMENT"));
    } catch (Exception e) {
      tr3.appendTcDetail(e.toString());
    }
    tr3.writeTo(writer);

    /* TestCase: V2SigTestsResource_MimeResponse_SIGResource_fieldNAMESPACED_RESPONSE */
    /* Details: "ResourceResponse has String field NAMESPACED_RESPONSE " */
    TestResult tr4 = tcd
        .getTestResultFailed(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_FIELDNAMESPACED_RESPONSE);
    try {
      tr4.setTcSuccess(cc.hasField("NAMESPACED_RESPONSE"));
    } catch (Exception e) {
      tr4.appendTcDetail(e.toString());
    }
    tr4.writeTo(writer);

    /* TestCase: V2SigTestsResource_MimeResponse_SIGResource_fieldPRIVATE_SCOPE */
    /* Details: "ResourceResponse has String field PRIVATE_SCOPE " */
    TestResult tr5 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_FIELDPRIVATE_SCOPE);
    try {
      tr5.setTcSuccess(cc.hasField("PRIVATE_SCOPE"));
    } catch (Exception e) {
      tr5.appendTcDetail(e.toString());
    }
    tr5.writeTo(writer);

    /* TestCase: V2SigTestsResource_MimeResponse_SIGResource_fieldPUBLIC_SCOPE */
    /* Details: "ResourceResponse has String field PUBLIC_SCOPE " */
    TestResult tr6 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_FIELDPUBLIC_SCOPE);
    try {
      tr6.setTcSuccess(cc.hasField("PUBLIC_SCOPE"));
    } catch (Exception e) {
      tr6.appendTcDetail(e.toString());
    }
    tr6.writeTo(writer);

    /* TestCase: V2SigTestsResource_MimeResponse_SIGResource_fieldUSE_CACHED_CONTENT */
    /* Details: "ResourceResponse has String field USE_CACHED_CONTENT " */
    TestResult tr7 = tcd
        .getTestResultFailed(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_FIELDUSE_CACHED_CONTENT);
    try {
      tr7.setTcSuccess(cc.hasField("USE_CACHED_CONTENT"));
    } catch (Exception e) {
      tr7.appendTcDetail(e.toString());
    }
    tr7.writeTo(writer);

    /* TestCase: V2SigTestsResource_MimeResponse_SIGResource_hasCreateActionURL */
    /* Details: "ResourceResponse has a createActionURL()  method " */
    TestResult tr8 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASCREATEACTIONURL);
    try {
      String name = "createActionURL";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr8.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr8.appendTcDetail(e.toString());
    }
    tr8.writeTo(writer);

    /* TestCase: V2SigTestsResource_MimeResponse_SIGResource_hasCreateActionURLReturns */
    /* Details: "ResourceResponse method createActionURL() returns */
    /* PortletURL " */
    TestResult tr9 = tcd
        .getTestResultFailed(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASCREATEACTIONURLRETURNS);
    try {
      String name = "createActionURL";
      Class<?> retType = PortletURL.class;
      Class<?>[] parms = null;
      tr9.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr9.appendTcDetail(e.toString());
    }
    tr9.writeTo(writer);

    /* TestCase: V2SigTestsResource_MimeResponse_SIGResource_hasCreateRenderURL */
    /* Details: "ResourceResponse has a createRenderURL()  method " */
    TestResult tr10 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASCREATERENDERURL);
    try {
      String name = "createRenderURL";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr10.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr10.appendTcDetail(e.toString());
    }
    tr10.writeTo(writer);

    /* TestCase: V2SigTestsResource_MimeResponse_SIGResource_hasCreateRenderURLReturns */
    /* Details: "ResourceResponse method createRenderURL() returns */
    /* PortletURL " */
    TestResult tr11 = tcd
        .getTestResultFailed(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASCREATERENDERURLRETURNS);
    try {
      String name = "createRenderURL";
      Class<?> retType = PortletURL.class;
      Class<?>[] parms = null;
      tr11.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr11.appendTcDetail(e.toString());
    }
    tr11.writeTo(writer);

    /* TestCase: V2SigTestsResource_MimeResponse_SIGResource_hasCreateResourceURL */
    /* Details: "ResourceResponse has a createResourceURL()  method " */
    TestResult tr12 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASCREATERESOURCEURL);
    try {
      String name = "createResourceURL";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr12.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr12.appendTcDetail(e.toString());
    }
    tr12.writeTo(writer);

    /* TestCase: V2SigTestsResource_MimeResponse_SIGResource_hasCreateResourceURLReturns */
    /* Details: "ResourceResponse method createResourceURL() returns */
    /* ResourceURL " */
    TestResult tr13 = tcd.getTestResultFailed(
        V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASCREATERESOURCEURLRETURNS);
    try {
      String name = "createResourceURL";
      Class<?> retType = ResourceURL.class;
      Class<?>[] parms = null;
      tr13.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr13.appendTcDetail(e.toString());
    }
    tr13.writeTo(writer);

    /* TestCase: V2SigTestsResource_MimeResponse_SIGResource_hasFlushBuffer */
    /* Details: "ResourceResponse has a flushBuffer() throws */
    /* java.io.IOException method " */
    TestResult tr14 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASFLUSHBUFFER);
    try {
      String name = "flushBuffer";
      Class<?>[] exceptions = {java.io.IOException.class};
      Class<?>[] parms = null;
      tr14.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr14.appendTcDetail(e.toString());
    }
    tr14.writeTo(writer);

    /* TestCase: V2SigTestsResource_MimeResponse_SIGResource_hasFlushBufferReturns */
    /* Details: "ResourceResponse method flushBuffer() returns void " */
    TestResult tr15 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASFLUSHBUFFERRETURNS);
    try {
      String name = "flushBuffer";
      Class<?> retType = void.class;
      Class<?>[] parms = null;
      tr15.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr15.appendTcDetail(e.toString());
    }
    tr15.writeTo(writer);

    /* TestCase: V2SigTestsResource_MimeResponse_SIGResource_hasGetBufferSize */
    /* Details: "ResourceResponse has a getBufferSize()  method " */
    TestResult tr16 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASGETBUFFERSIZE);
    try {
      String name = "getBufferSize";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr16.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr16.appendTcDetail(e.toString());
    }
    tr16.writeTo(writer);

    /* TestCase: V2SigTestsResource_MimeResponse_SIGResource_hasGetBufferSizeReturns */
    /* Details: "ResourceResponse method getBufferSize() returns int " */
    TestResult tr17 = tcd
        .getTestResultFailed(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASGETBUFFERSIZERETURNS);
    try {
      String name = "getBufferSize";
      Class<?> retType = int.class;
      Class<?>[] parms = null;
      tr17.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr17.appendTcDetail(e.toString());
    }
    tr17.writeTo(writer);

    /* TestCase: V2SigTestsResource_MimeResponse_SIGResource_hasGetCacheControl */
    /* Details: "ResourceResponse has a getCacheControl()  method " */
    TestResult tr18 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASGETCACHECONTROL);
    try {
      String name = "getCacheControl";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr18.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr18.appendTcDetail(e.toString());
    }
    tr18.writeTo(writer);

    /* TestCase: V2SigTestsResource_MimeResponse_SIGResource_hasGetCacheControlReturns */
    /* Details: "ResourceResponse method getCacheControl() returns */
    /* CacheControl " */
    TestResult tr19 = tcd
        .getTestResultFailed(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASGETCACHECONTROLRETURNS);
    try {
      String name = "getCacheControl";
      Class<?> retType = CacheControl.class;
      Class<?>[] parms = null;
      tr19.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr19.appendTcDetail(e.toString());
    }
    tr19.writeTo(writer);

    /* TestCase: V2SigTestsResource_MimeResponse_SIGResource_hasGetCharacterEncoding */
    /* Details: "ResourceResponse has a getCharacterEncoding()  method " */
    TestResult tr20 = tcd
        .getTestResultFailed(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASGETCHARACTERENCODING);
    try {
      String name = "getCharacterEncoding";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr20.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr20.appendTcDetail(e.toString());
    }
    tr20.writeTo(writer);

    /* TestCase: V2SigTestsResource_MimeResponse_SIGResource_hasGetCharacterEncodingReturns */
    /* Details: "ResourceResponse method getCharacterEncoding() returns */
    /* String " */
    TestResult tr21 = tcd.getTestResultFailed(
        V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASGETCHARACTERENCODINGRETURNS);
    try {
      String name = "getCharacterEncoding";
      Class<?> retType = String.class;
      Class<?>[] parms = null;
      tr21.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr21.appendTcDetail(e.toString());
    }
    tr21.writeTo(writer);

    /* TestCase: V2SigTestsResource_MimeResponse_SIGResource_hasGetContentType */
    /* Details: "ResourceResponse has a getContentType()  method " */
    TestResult tr22 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASGETCONTENTTYPE);
    try {
      String name = "getContentType";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr22.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr22.appendTcDetail(e.toString());
    }
    tr22.writeTo(writer);

    /* TestCase: V2SigTestsResource_MimeResponse_SIGResource_hasGetContentTypeReturns */
    /* Details: "ResourceResponse method getContentType() returns String */
    /* " */
    TestResult tr23 = tcd
        .getTestResultFailed(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASGETCONTENTTYPERETURNS);
    try {
      String name = "getContentType";
      Class<?> retType = String.class;
      Class<?>[] parms = null;
      tr23.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr23.appendTcDetail(e.toString());
    }
    tr23.writeTo(writer);

    /* TestCase: V2SigTestsResource_MimeResponse_SIGResource_hasGetLocale */
    /* Details: "ResourceResponse has a getLocale()  method " */
    TestResult tr24 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASGETLOCALE);
    try {
      String name = "getLocale";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr24.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr24.appendTcDetail(e.toString());
    }
    tr24.writeTo(writer);

    /* TestCase: V2SigTestsResource_MimeResponse_SIGResource_hasGetLocaleReturns */
    /* Details: "ResourceResponse method getLocale() returns */
    /* java.util.Locale " */
    TestResult tr25 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASGETLOCALERETURNS);
    try {
      String name = "getLocale";
      Class<?> retType = java.util.Locale.class;
      Class<?>[] parms = null;
      tr25.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr25.appendTcDetail(e.toString());
    }
    tr25.writeTo(writer);

    /* TestCase: V2SigTestsResource_MimeResponse_SIGResource_hasGetPortletOutputStream */
    /* Details: "ResourceResponse has a getPortletOutputStream() throws */
    /* java.io.IOException, IllegalStateException method " */
    TestResult tr26 = tcd
        .getTestResultFailed(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASGETPORTLETOUTPUTSTREAM);
    try {
      String name = "getPortletOutputStream";
      Class<?>[] exceptions = {java.io.IOException.class, IllegalStateException.class};
      Class<?>[] parms = null;
      tr26.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr26.appendTcDetail(e.toString());
    }
    tr26.writeTo(writer);

    /* TestCase: V2SigTestsResource_MimeResponse_SIGResource_hasGetPortletOutputStreamReturns */
    /* Details: "ResourceResponse method getPortletOutputStream() returns */
    /* java.io.OutputStream " */
    TestResult tr27 = tcd.getTestResultFailed(
        V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASGETPORTLETOUTPUTSTREAMRETURNS);
    try {
      String name = "getPortletOutputStream";
      Class<?> retType = java.io.OutputStream.class;
      Class<?>[] parms = null;
      tr27.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr27.appendTcDetail(e.toString());
    }
    tr27.writeTo(writer);

    /* TestCase: V2SigTestsResource_MimeResponse_SIGResource_hasGetWriter */
    /* Details: "ResourceResponse has a getWriter() throws */
    /* java.io.IOException, IllegalStateException method " */
    TestResult tr28 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASGETWRITER);
    try {
      String name = "getWriter";
      Class<?>[] exceptions = {java.io.IOException.class, IllegalStateException.class};
      Class<?>[] parms = null;
      tr28.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr28.appendTcDetail(e.toString());
    }
    tr28.writeTo(writer);

    /* TestCase: V2SigTestsResource_MimeResponse_SIGResource_hasGetWriterReturns */
    /* Details: "ResourceResponse method getWriter() returns */
    /* java.io.PrintWriter " */
    TestResult tr29 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASGETWRITERRETURNS);
    try {
      String name = "getWriter";
      Class<?> retType = java.io.PrintWriter.class;
      Class<?>[] parms = null;
      tr29.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr29.appendTcDetail(e.toString());
    }
    tr29.writeTo(writer);

    /* TestCase: V2SigTestsResource_MimeResponse_SIGResource_hasIsCommitted */
    /* Details: "ResourceResponse has a isCommitted()  method " */
    TestResult tr30 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASISCOMMITTED);
    try {
      String name = "isCommitted";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr30.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr30.appendTcDetail(e.toString());
    }
    tr30.writeTo(writer);

    /* TestCase: V2SigTestsResource_MimeResponse_SIGResource_hasIsCommittedReturns */
    /* Details: "ResourceResponse method isCommitted() returns boolean " */
    TestResult tr31 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASISCOMMITTEDRETURNS);
    try {
      String name = "isCommitted";
      Class<?> retType = boolean.class;
      Class<?>[] parms = null;
      tr31.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr31.appendTcDetail(e.toString());
    }
    tr31.writeTo(writer);

    /* TestCase: V2SigTestsResource_MimeResponse_SIGResource_hasReset */
    /* Details: "ResourceResponse has a reset()  method " */
    TestResult tr32 = tcd.getTestResultFailed(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASRESET);
    try {
      String name = "reset";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr32.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr32.appendTcDetail(e.toString());
    }
    tr32.writeTo(writer);

    /* TestCase: V2SigTestsResource_MimeResponse_SIGResource_hasResetBuffer */
    /* Details: "ResourceResponse has a resetBuffer()  method " */
    TestResult tr33 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASRESETBUFFER);
    try {
      String name = "resetBuffer";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr33.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr33.appendTcDetail(e.toString());
    }
    tr33.writeTo(writer);

    /* TestCase: V2SigTestsResource_MimeResponse_SIGResource_hasResetBufferReturns */
    /* Details: "ResourceResponse method resetBuffer() returns void " */
    TestResult tr34 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASRESETBUFFERRETURNS);
    try {
      String name = "resetBuffer";
      Class<?> retType = void.class;
      Class<?>[] parms = null;
      tr34.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr34.appendTcDetail(e.toString());
    }
    tr34.writeTo(writer);

    /* TestCase: V2SigTestsResource_MimeResponse_SIGResource_hasResetReturns */
    /* Details: "ResourceResponse method reset() returns void " */
    TestResult tr35 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASRESETRETURNS);
    try {
      String name = "reset";
      Class<?> retType = void.class;
      Class<?>[] parms = null;
      tr35.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr35.appendTcDetail(e.toString());
    }
    tr35.writeTo(writer);

    /* TestCase: V2SigTestsResource_MimeResponse_SIGResource_hasSetBufferSize */
    /* Details: "ResourceResponse has a setBufferSize(int)  method " */
    TestResult tr36 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASSETBUFFERSIZE);
    try {
      String name = "setBufferSize";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {int.class};
      tr36.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr36.appendTcDetail(e.toString());
    }
    tr36.writeTo(writer);

    /* TestCase: V2SigTestsResource_MimeResponse_SIGResource_hasSetBufferSizeReturns */
    /* Details: "ResourceResponse method setBufferSize(int) returns void */
    /* " */
    TestResult tr37 = tcd
        .getTestResultFailed(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASSETBUFFERSIZERETURNS);
    try {
      String name = "setBufferSize";
      Class<?> retType = void.class;
      Class<?>[] parms = {int.class};
      tr37.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr37.appendTcDetail(e.toString());
    }
    tr37.writeTo(writer);

    /* TestCase: V2SigTestsResource_MimeResponse_SIGResource_hasSetContentType */
    /* Details: "ResourceResponse has a setContentType(String)  method " */
    TestResult tr38 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASSETCONTENTTYPE);
    try {
      String name = "setContentType";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {String.class};
      tr38.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr38.appendTcDetail(e.toString());
    }
    tr38.writeTo(writer);

    /* TestCase: V2SigTestsResource_MimeResponse_SIGResource_hasSetContentTypeReturns */
    /* Details: "ResourceResponse method setContentType(String) returns */
    /* void " */
    TestResult tr39 = tcd
        .getTestResultFailed(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASSETCONTENTTYPERETURNS);
    try {
      String name = "setContentType";
      Class<?> retType = void.class;
      Class<?>[] parms = {String.class};
      tr39.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr39.appendTcDetail(e.toString());
    }
    tr39.writeTo(writer);

    /* TestCase: V2SigTestsResource_MimeResponse_SIGResource_implementsPortletResponse */
    /* Details: "ResourceResponse implements PortletResponse " */
    TestResult tr40 = tcd
        .getTestResultFailed(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_IMPLEMENTSPORTLETRESPONSE);
    try {
      tr40.setTcSuccess(cc.implementsInterface(PortletResponse.class));
    } catch (Exception e) {
      tr40.appendTcDetail(e.toString());
    }
    tr40.writeTo(writer);

  }

  @Override
  public void render(RenderRequest portletReq, RenderResponse portletResp)
      throws PortletException, IOException {

    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

    PrintWriter writer = portletResp.getWriter();

    writer
        .write("<div id=\"SigTestsResource_MimeResponse_SIGResource\">no resource output.</div>\n");
    ResourceURL resurl = portletResp.createResourceURL();
    resurl.setCacheability(PAGE);
    writer.write("<script>\n");
    writer.write("(function () {\n");
    writer.write("   var xhr = new XMLHttpRequest();\n");
    writer.write("   xhr.onreadystatechange=function() {\n");
    writer.write("      if (xhr.readyState==4 && xhr.status==200) {\n");
    writer.write(
        "         document.getElementById(\"SigTestsResource_MimeResponse_SIGResource\").innerHTML=xhr.responseText;\n");
    writer.write("      }\n");
    writer.write("   };\n");
    writer.write("   xhr.open(\"GET\",\"" + resurl.toString() + "\",true);\n");
    writer.write("   xhr.send();\n");
    writer.write("})();\n");
    writer.write("</script>\n");
  }

}
