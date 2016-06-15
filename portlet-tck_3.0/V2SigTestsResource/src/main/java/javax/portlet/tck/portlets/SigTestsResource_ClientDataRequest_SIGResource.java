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
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceServingPortlet;
import javax.portlet.ResourceURL;
import javax.portlet.tck.beans.ClassChecker;
import javax.portlet.tck.beans.JSR286SignatureTestCaseDetails;
import javax.portlet.tck.beans.TestResult;

import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_CLIENTDATAREQUEST_SIGRESOURCE_HASGETCHARACTERENCODING;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_CLIENTDATAREQUEST_SIGRESOURCE_HASGETCHARACTERENCODINGRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_CLIENTDATAREQUEST_SIGRESOURCE_HASGETCONTENTLENGTH;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_CLIENTDATAREQUEST_SIGRESOURCE_HASGETCONTENTLENGTHRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_CLIENTDATAREQUEST_SIGRESOURCE_HASGETCONTENTTYPE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_CLIENTDATAREQUEST_SIGRESOURCE_HASGETCONTENTTYPERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_CLIENTDATAREQUEST_SIGRESOURCE_HASGETMETHOD;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_CLIENTDATAREQUEST_SIGRESOURCE_HASGETMETHODRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_CLIENTDATAREQUEST_SIGRESOURCE_HASGETPORTLETINPUTSTREAM;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_CLIENTDATAREQUEST_SIGRESOURCE_HASGETPORTLETINPUTSTREAMRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_CLIENTDATAREQUEST_SIGRESOURCE_HASGETREADER;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_CLIENTDATAREQUEST_SIGRESOURCE_HASGETREADERRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_CLIENTDATAREQUEST_SIGRESOURCE_HASSETCHARACTERENCODING;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_CLIENTDATAREQUEST_SIGRESOURCE_HASSETCHARACTERENCODINGRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_CLIENTDATAREQUEST_SIGRESOURCE_IMPLEMENTSPORTLETREQUEST;
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
 * SigTestsResource_ClientDataRequest_SIGResource_event
 *
 */
public class SigTestsResource_ClientDataRequest_SIGResource
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

    ClassChecker cc = new ClassChecker(portletReq.getClass());

    /* TestCase: V2SigTestsResource_ClientDataRequest_SIGResource_hasGetCharacterEncoding */
    /* Details: "ResourceRequest has a getCharacterEncoding()  method " */
    TestResult tr0 = tcd.getTestResultFailed(
        V2SIGTESTSRESOURCE_CLIENTDATAREQUEST_SIGRESOURCE_HASGETCHARACTERENCODING);
    try {
      String name = "getCharacterEncoding";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr0.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr0.appendTcDetail(e.toString());
    }
    tr0.writeTo(writer);

    /* TestCase: V2SigTestsResource_ClientDataRequest_SIGResource_hasGetCharacterEncodingReturns */
    /* Details: "ResourceRequest method getCharacterEncoding() returns */
    /* String " */
    TestResult tr1 = tcd.getTestResultFailed(
        V2SIGTESTSRESOURCE_CLIENTDATAREQUEST_SIGRESOURCE_HASGETCHARACTERENCODINGRETURNS);
    try {
      String name = "getCharacterEncoding";
      Class<?> retType = String.class;
      Class<?>[] parms = null;
      tr1.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr1.appendTcDetail(e.toString());
    }
    tr1.writeTo(writer);

    /* TestCase: V2SigTestsResource_ClientDataRequest_SIGResource_hasGetContentLength */
    /* Details: "ResourceRequest has a getContentLength()  method " */
    TestResult tr2 = tcd
        .getTestResultFailed(V2SIGTESTSRESOURCE_CLIENTDATAREQUEST_SIGRESOURCE_HASGETCONTENTLENGTH);
    try {
      String name = "getContentLength";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr2.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr2.appendTcDetail(e.toString());
    }
    tr2.writeTo(writer);

    /* TestCase: V2SigTestsResource_ClientDataRequest_SIGResource_hasGetContentLengthReturns */
    /* Details: "ResourceRequest method getContentLength() returns int " */
    TestResult tr3 = tcd.getTestResultFailed(
        V2SIGTESTSRESOURCE_CLIENTDATAREQUEST_SIGRESOURCE_HASGETCONTENTLENGTHRETURNS);
    try {
      String name = "getContentLength";
      Class<?> retType = int.class;
      Class<?>[] parms = null;
      tr3.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr3.appendTcDetail(e.toString());
    }
    tr3.writeTo(writer);

    /* TestCase: V2SigTestsResource_ClientDataRequest_SIGResource_hasGetContentType */
    /* Details: "ResourceRequest has a getContentType()  method " */
    TestResult tr4 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_CLIENTDATAREQUEST_SIGRESOURCE_HASGETCONTENTTYPE);
    try {
      String name = "getContentType";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr4.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr4.appendTcDetail(e.toString());
    }
    tr4.writeTo(writer);

    /* TestCase: V2SigTestsResource_ClientDataRequest_SIGResource_hasGetContentTypeReturns */
    /* Details: "ResourceRequest method getContentType() returns String " */
    TestResult tr5 = tcd.getTestResultFailed(
        V2SIGTESTSRESOURCE_CLIENTDATAREQUEST_SIGRESOURCE_HASGETCONTENTTYPERETURNS);
    try {
      String name = "getContentType";
      Class<?> retType = String.class;
      Class<?>[] parms = null;
      tr5.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr5.appendTcDetail(e.toString());
    }
    tr5.writeTo(writer);

    /* TestCase: V2SigTestsResource_ClientDataRequest_SIGResource_hasGetMethod */
    /* Details: "ResourceRequest has a getMethod()  method " */
    TestResult tr6 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_CLIENTDATAREQUEST_SIGRESOURCE_HASGETMETHOD);
    try {
      String name = "getMethod";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr6.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr6.appendTcDetail(e.toString());
    }
    tr6.writeTo(writer);

    /* TestCase: V2SigTestsResource_ClientDataRequest_SIGResource_hasGetMethodReturns */
    /* Details: "ResourceRequest method getMethod() returns String " */
    TestResult tr7 = tcd
        .getTestResultFailed(V2SIGTESTSRESOURCE_CLIENTDATAREQUEST_SIGRESOURCE_HASGETMETHODRETURNS);
    try {
      String name = "getMethod";
      Class<?> retType = String.class;
      Class<?>[] parms = null;
      tr7.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr7.appendTcDetail(e.toString());
    }
    tr7.writeTo(writer);

    /* TestCase: V2SigTestsResource_ClientDataRequest_SIGResource_hasGetPortletInputStream */
    /* Details: "ResourceRequest has a getPortletInputStream() throws */
    /* java.io.IOException method " */
    TestResult tr8 = tcd.getTestResultFailed(
        V2SIGTESTSRESOURCE_CLIENTDATAREQUEST_SIGRESOURCE_HASGETPORTLETINPUTSTREAM);
    try {
      String name = "getPortletInputStream";
      Class<?>[] exceptions = {java.io.IOException.class};
      Class<?>[] parms = null;
      tr8.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr8.appendTcDetail(e.toString());
    }
    tr8.writeTo(writer);

    /* TestCase: V2SigTestsResource_ClientDataRequest_SIGResource_hasGetPortletInputStreamReturns */
    /* Details: "ResourceRequest method getPortletInputStream() returns */
    /* java.io.InputStream " */
    TestResult tr9 = tcd.getTestResultFailed(
        V2SIGTESTSRESOURCE_CLIENTDATAREQUEST_SIGRESOURCE_HASGETPORTLETINPUTSTREAMRETURNS);
    try {
      String name = "getPortletInputStream";
      Class<?> retType = java.io.InputStream.class;
      Class<?>[] parms = null;
      tr9.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr9.appendTcDetail(e.toString());
    }
    tr9.writeTo(writer);

    /* TestCase: V2SigTestsResource_ClientDataRequest_SIGResource_hasGetReader */
    /* Details: "ResourceRequest has a getReader() throws */
    /* java.io.UnsupportedEncodingException, java.io.IOException method " */
    TestResult tr10 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_CLIENTDATAREQUEST_SIGRESOURCE_HASGETREADER);
    try {
      String name = "getReader";
      Class<?>[] exceptions =
          {java.io.UnsupportedEncodingException.class, java.io.IOException.class};
      Class<?>[] parms = null;
      tr10.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr10.appendTcDetail(e.toString());
    }
    tr10.writeTo(writer);

    /* TestCase: V2SigTestsResource_ClientDataRequest_SIGResource_hasGetReaderReturns */
    /* Details: "ResourceRequest method getReader() returns */
    /* java.io.BufferedReader " */
    TestResult tr11 = tcd
        .getTestResultFailed(V2SIGTESTSRESOURCE_CLIENTDATAREQUEST_SIGRESOURCE_HASGETREADERRETURNS);
    try {
      String name = "getReader";
      Class<?> retType = java.io.BufferedReader.class;
      Class<?>[] parms = null;
      tr11.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr11.appendTcDetail(e.toString());
    }
    tr11.writeTo(writer);

    /* TestCase: V2SigTestsResource_ClientDataRequest_SIGResource_hasSetCharacterEncoding */
    /* Details: "ResourceRequest has a setCharacterEncoding(String) */
    /* throws java.io.UnsupportedEncodingException method " */
    TestResult tr12 = tcd.getTestResultFailed(
        V2SIGTESTSRESOURCE_CLIENTDATAREQUEST_SIGRESOURCE_HASSETCHARACTERENCODING);
    try {
      String name = "setCharacterEncoding";
      Class<?>[] exceptions = {java.io.UnsupportedEncodingException.class};
      Class<?>[] parms = {String.class};
      tr12.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr12.appendTcDetail(e.toString());
    }
    tr12.writeTo(writer);

    /* TestCase: V2SigTestsResource_ClientDataRequest_SIGResource_hasSetCharacterEncodingReturns */
    /* Details: "ResourceRequest method setCharacterEncoding(String) */
    /* returns void " */
    TestResult tr13 = tcd.getTestResultFailed(
        V2SIGTESTSRESOURCE_CLIENTDATAREQUEST_SIGRESOURCE_HASSETCHARACTERENCODINGRETURNS);
    try {
      String name = "setCharacterEncoding";
      Class<?> retType = void.class;
      Class<?>[] parms = {String.class};
      tr13.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr13.appendTcDetail(e.toString());
    }
    tr13.writeTo(writer);

    /* TestCase: V2SigTestsResource_ClientDataRequest_SIGResource_implementsPortletRequest */
    /* Details: "ResourceRequest implements PortletRequest " */
    TestResult tr14 = tcd.getTestResultFailed(
        V2SIGTESTSRESOURCE_CLIENTDATAREQUEST_SIGRESOURCE_IMPLEMENTSPORTLETREQUEST);
    try {
      tr14.setTcSuccess(cc.implementsInterface(PortletRequest.class));
    } catch (Exception e) {
      tr14.appendTcDetail(e.toString());
    }
    tr14.writeTo(writer);

  }

  @Override
  public void render(RenderRequest portletReq, RenderResponse portletResp)
      throws PortletException, IOException {

    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

    PrintWriter writer = portletResp.getWriter();

    writer.write(
        "<div id=\"SigTestsResource_ClientDataRequest_SIGResource\">no resource output.</div>\n");
    ResourceURL resurl = portletResp.createResourceURL();
    resurl.setCacheability(PAGE);
    writer.write("<script>\n");
    writer.write("(function () {\n");
    writer.write("   var xhr = new XMLHttpRequest();\n");
    writer.write("   xhr.onreadystatechange=function() {\n");
    writer.write("      if (xhr.readyState==4 && xhr.status==200) {\n");
    writer.write(
        "         document.getElementById(\"SigTestsResource_ClientDataRequest_SIGResource\").innerHTML=xhr.responseText;\n");
    writer.write("      }\n");
    writer.write("   };\n");
    writer.write("   xhr.open(\"GET\",\"" + resurl.toString() + "\",true);\n");
    writer.write("   xhr.send();\n");
    writer.write("})();\n");
    writer.write("</script>\n");
  }

}
