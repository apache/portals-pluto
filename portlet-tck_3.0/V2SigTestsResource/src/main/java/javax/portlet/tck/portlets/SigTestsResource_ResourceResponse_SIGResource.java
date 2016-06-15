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
import javax.portlet.MimeResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
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

import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_RESOURCERESPONSE_SIGRESOURCE_FIELDHTTP_STATUS_CODE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_RESOURCERESPONSE_SIGRESOURCE_HASCREATEACTIONURL;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_RESOURCERESPONSE_SIGRESOURCE_HASCREATEACTIONURLRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_RESOURCERESPONSE_SIGRESOURCE_HASCREATERENDERURL;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_RESOURCERESPONSE_SIGRESOURCE_HASCREATERENDERURLRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_RESOURCERESPONSE_SIGRESOURCE_HASCREATERESOURCEURL;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_RESOURCERESPONSE_SIGRESOURCE_HASCREATERESOURCEURLRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_RESOURCERESPONSE_SIGRESOURCE_HASSETCHARACTERENCODING;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_RESOURCERESPONSE_SIGRESOURCE_HASSETCHARACTERENCODINGRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_RESOURCERESPONSE_SIGRESOURCE_HASSETCONTENTLENGTH;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_RESOURCERESPONSE_SIGRESOURCE_HASSETCONTENTLENGTHRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_RESOURCERESPONSE_SIGRESOURCE_HASSETLOCALE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_RESOURCERESPONSE_SIGRESOURCE_HASSETLOCALERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_RESOURCERESPONSE_SIGRESOURCE_IMPLEMENTSMIMERESPONSE;
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
 * SigTestsResource_ResourceResponse_SIGResource_event
 *
 */
public class SigTestsResource_ResourceResponse_SIGResource
    implements Portlet, ResourceServingPortlet {

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

    /* TestCase: V2SigTestsResource_ResourceResponse_SIGResource_fieldHTTP_STATUS_CODE */
    /* Details: "ResourceResponse has String field HTTP_STATUS_CODE " */
    TestResult tr0 = tcd
        .getTestResultFailed(V2SIGTESTSRESOURCE_RESOURCERESPONSE_SIGRESOURCE_FIELDHTTP_STATUS_CODE);
    try {
      tr0.setTcSuccess(cc.hasField("HTTP_STATUS_CODE"));
    } catch (Exception e) {
      tr0.appendTcDetail(e.toString());
    }
    tr0.writeTo(writer);

    /* TestCase: V2SigTestsResource_ResourceResponse_SIGResource_hasCreateActionURL */
    /* Details: "ResourceResponse has a createActionURL() throws */
    /* IllegalStateException method " */
    TestResult tr1 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_RESOURCERESPONSE_SIGRESOURCE_HASCREATEACTIONURL);
    try {
      String name = "createActionURL";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr1.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr1.appendTcDetail(e.toString());
    }
    tr1.writeTo(writer);

    /* TestCase: V2SigTestsResource_ResourceResponse_SIGResource_hasCreateActionURLReturns */
    /* Details: "ResourceResponse method createActionURL() returns */
    /* PortletURL " */
    TestResult tr2 = tcd.getTestResultFailed(
        V2SIGTESTSRESOURCE_RESOURCERESPONSE_SIGRESOURCE_HASCREATEACTIONURLRETURNS);
    try {
      String name = "createActionURL";
      Class<?> retType = PortletURL.class;
      Class<?>[] parms = null;
      tr2.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr2.appendTcDetail(e.toString());
    }
    tr2.writeTo(writer);

    /* TestCase: V2SigTestsResource_ResourceResponse_SIGResource_hasCreateRenderURL */
    /* Details: "ResourceResponse has a createRenderURL() throws */
    /* IllegalStateException method " */
    TestResult tr3 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_RESOURCERESPONSE_SIGRESOURCE_HASCREATERENDERURL);
    try {
      String name = "createRenderURL";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr3.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr3.appendTcDetail(e.toString());
    }
    tr3.writeTo(writer);

    /* TestCase: V2SigTestsResource_ResourceResponse_SIGResource_hasCreateRenderURLReturns */
    /* Details: "ResourceResponse method createRenderURL() returns */
    /* PortletURL " */
    TestResult tr4 = tcd.getTestResultFailed(
        V2SIGTESTSRESOURCE_RESOURCERESPONSE_SIGRESOURCE_HASCREATERENDERURLRETURNS);
    try {
      String name = "createRenderURL";
      Class<?> retType = PortletURL.class;
      Class<?>[] parms = null;
      tr4.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr4.appendTcDetail(e.toString());
    }
    tr4.writeTo(writer);

    /* TestCase: V2SigTestsResource_ResourceResponse_SIGResource_hasCreateResourceURL */
    /* Details: "ResourceResponse has a createResourceURL() throws */
    /* IllegalStateException method " */
    TestResult tr5 = tcd
        .getTestResultFailed(V2SIGTESTSRESOURCE_RESOURCERESPONSE_SIGRESOURCE_HASCREATERESOURCEURL);
    try {
      String name = "createResourceURL";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr5.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr5.appendTcDetail(e.toString());
    }
    tr5.writeTo(writer);

    /* TestCase: V2SigTestsResource_ResourceResponse_SIGResource_hasCreateResourceURLReturns */
    /* Details: "ResourceResponse method createResourceURL() returns */
    /* ResourceURL " */
    TestResult tr6 = tcd.getTestResultFailed(
        V2SIGTESTSRESOURCE_RESOURCERESPONSE_SIGRESOURCE_HASCREATERESOURCEURLRETURNS);
    try {
      String name = "createResourceURL";
      Class<?> retType = ResourceURL.class;
      Class<?>[] parms = null;
      tr6.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr6.appendTcDetail(e.toString());
    }
    tr6.writeTo(writer);

    /* TestCase: V2SigTestsResource_ResourceResponse_SIGResource_hasSetCharacterEncoding */
    /* Details: "ResourceResponse has a setCharacterEncoding(String) */
    /* method " */
    TestResult tr7 = tcd.getTestResultFailed(
        V2SIGTESTSRESOURCE_RESOURCERESPONSE_SIGRESOURCE_HASSETCHARACTERENCODING);
    try {
      String name = "setCharacterEncoding";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {String.class};
      tr7.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr7.appendTcDetail(e.toString());
    }
    tr7.writeTo(writer);

    /* TestCase: V2SigTestsResource_ResourceResponse_SIGResource_hasSetCharacterEncodingReturns */
    /* Details: "ResourceResponse method setCharacterEncoding(String) */
    /* returns void " */
    TestResult tr8 = tcd.getTestResultFailed(
        V2SIGTESTSRESOURCE_RESOURCERESPONSE_SIGRESOURCE_HASSETCHARACTERENCODINGRETURNS);
    try {
      String name = "setCharacterEncoding";
      Class<?> retType = void.class;
      Class<?>[] parms = {String.class};
      tr8.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr8.appendTcDetail(e.toString());
    }
    tr8.writeTo(writer);

    /* TestCase: V2SigTestsResource_ResourceResponse_SIGResource_hasSetContentLength */
    /* Details: "ResourceResponse has a setContentLength(int)  method " */
    TestResult tr9 = tcd
        .getTestResultFailed(V2SIGTESTSRESOURCE_RESOURCERESPONSE_SIGRESOURCE_HASSETCONTENTLENGTH);
    try {
      String name = "setContentLength";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {int.class};
      tr9.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr9.appendTcDetail(e.toString());
    }
    tr9.writeTo(writer);

    /* TestCase: V2SigTestsResource_ResourceResponse_SIGResource_hasSetContentLengthReturns */
    /* Details: "ResourceResponse method setContentLength(int) returns */
    /* void " */
    TestResult tr10 = tcd.getTestResultFailed(
        V2SIGTESTSRESOURCE_RESOURCERESPONSE_SIGRESOURCE_HASSETCONTENTLENGTHRETURNS);
    try {
      String name = "setContentLength";
      Class<?> retType = void.class;
      Class<?>[] parms = {int.class};
      tr10.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr10.appendTcDetail(e.toString());
    }
    tr10.writeTo(writer);

    /* TestCase: V2SigTestsResource_ResourceResponse_SIGResource_hasSetLocale */
    /* Details: "ResourceResponse has a setLocale(java.util.Locale) */
    /* method " */
    TestResult tr11 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_RESOURCERESPONSE_SIGRESOURCE_HASSETLOCALE);
    try {
      String name = "setLocale";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {java.util.Locale.class};
      tr11.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr11.appendTcDetail(e.toString());
    }
    tr11.writeTo(writer);

    /* TestCase: V2SigTestsResource_ResourceResponse_SIGResource_hasSetLocaleReturns */
    /* Details: "ResourceResponse method setLocale(java.util.Locale) */
    /* returns void " */
    TestResult tr12 = tcd
        .getTestResultFailed(V2SIGTESTSRESOURCE_RESOURCERESPONSE_SIGRESOURCE_HASSETLOCALERETURNS);
    try {
      String name = "setLocale";
      Class<?> retType = void.class;
      Class<?>[] parms = {java.util.Locale.class};
      tr12.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr12.appendTcDetail(e.toString());
    }
    tr12.writeTo(writer);

    /* TestCase: V2SigTestsResource_ResourceResponse_SIGResource_implementsMimeResponse */
    /* Details: "ResourceResponse implements MimeResponse " */
    TestResult tr13 = tcd.getTestResultFailed(
        V2SIGTESTSRESOURCE_RESOURCERESPONSE_SIGRESOURCE_IMPLEMENTSMIMERESPONSE);
    try {
      tr13.setTcSuccess(cc.implementsInterface(MimeResponse.class));
    } catch (Exception e) {
      tr13.appendTcDetail(e.toString());
    }
    tr13.writeTo(writer);

  }

  @Override
  public void render(RenderRequest portletReq, RenderResponse portletResp)
      throws PortletException, IOException {

    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

    PrintWriter writer = portletResp.getWriter();

    writer.write(
        "<div id=\"SigTestsResource_ResourceResponse_SIGResource\">no resource output.</div>\n");
    ResourceURL resurl = portletResp.createResourceURL();
    resurl.setCacheability(PAGE);
    writer.write("<script>\n");
    writer.write("(function () {\n");
    writer.write("   var xhr = new XMLHttpRequest();\n");
    writer.write("   xhr.onreadystatechange=function() {\n");
    writer.write("      if (xhr.readyState==4 && xhr.status==200) {\n");
    writer.write(
        "         document.getElementById(\"SigTestsResource_ResourceResponse_SIGResource\").innerHTML=xhr.responseText;\n");
    writer.write("      }\n");
    writer.write("   };\n");
    writer.write("   xhr.open(\"GET\",\"" + resurl.toString() + "\",true);\n");
    writer.write("   xhr.send();\n");
    writer.write("})();\n");
    writer.write("</script>\n");
  }

}
