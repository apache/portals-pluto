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
import javax.portlet.ClientDataRequest;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceServingPortlet;
import javax.portlet.ResourceURL;
import javax.portlet.tck.beans.ClassChecker;
import javax.portlet.tck.beans.JSR286SignatureTestCaseDetails;
import javax.portlet.tck.beans.TestResult;

import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_RESOURCEREQUEST_SIGRESOURCE_FIELDETAG;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_RESOURCEREQUEST_SIGRESOURCE_HASGETCACHEABILITY;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_RESOURCEREQUEST_SIGRESOURCE_HASGETCACHEABILITYRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_RESOURCEREQUEST_SIGRESOURCE_HASGETETAG;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_RESOURCEREQUEST_SIGRESOURCE_HASGETETAGRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_RESOURCEREQUEST_SIGRESOURCE_HASGETPRIVATERENDERPARAMETERMAP;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_RESOURCEREQUEST_SIGRESOURCE_HASGETPRIVATERENDERPARAMETERMAPRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_RESOURCEREQUEST_SIGRESOURCE_HASGETRESOURCEID;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_RESOURCEREQUEST_SIGRESOURCE_HASGETRESOURCEIDRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_RESOURCEREQUEST_SIGRESOURCE_HASGETRESPONSECONTENTTYPE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_RESOURCEREQUEST_SIGRESOURCE_HASGETRESPONSECONTENTTYPERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_RESOURCEREQUEST_SIGRESOURCE_HASGETRESPONSECONTENTTYPES;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_RESOURCEREQUEST_SIGRESOURCE_HASGETRESPONSECONTENTTYPESRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRESOURCE_RESOURCEREQUEST_SIGRESOURCE_IMPLEMENTSCLIENTDATAREQUEST;
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
 * SigTestsResource_ResourceRequest_SIGResource_event
 *
 */
public class SigTestsResource_ResourceRequest_SIGResource
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

    /* TestCase: V2SigTestsResource_ResourceRequest_SIGResource_fieldETAG */
    /* Details: "ResourceRequest has String field ETAG " */
    TestResult tr0 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_RESOURCEREQUEST_SIGRESOURCE_FIELDETAG);
    try {
      tr0.setTcSuccess(cc.hasField("ETAG"));
    } catch (Exception e) {
      tr0.appendTcDetail(e.toString());
    }
    tr0.writeTo(writer);

    /* TestCase: V2SigTestsResource_ResourceRequest_SIGResource_hasGetCacheability */
    /* Details: "ResourceRequest has a getCacheability()  method " */
    TestResult tr1 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_RESOURCEREQUEST_SIGRESOURCE_HASGETCACHEABILITY);
    try {
      String name = "getCacheability";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr1.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr1.appendTcDetail(e.toString());
    }
    tr1.writeTo(writer);

    /* TestCase: V2SigTestsResource_ResourceRequest_SIGResource_hasGetCacheabilityReturns */
    /* Details: "ResourceRequest method getCacheability() returns String */
    /* " */
    TestResult tr2 = tcd.getTestResultFailed(
        V2SIGTESTSRESOURCE_RESOURCEREQUEST_SIGRESOURCE_HASGETCACHEABILITYRETURNS);
    try {
      String name = "getCacheability";
      Class<?> retType = String.class;
      Class<?>[] parms = null;
      tr2.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr2.appendTcDetail(e.toString());
    }
    tr2.writeTo(writer);

    /* TestCase: V2SigTestsResource_ResourceRequest_SIGResource_hasGetETag */
    /* Details: "ResourceRequest has a getETag()  method " */
    TestResult tr3 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_RESOURCEREQUEST_SIGRESOURCE_HASGETETAG);
    try {
      String name = "getETag";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr3.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr3.appendTcDetail(e.toString());
    }
    tr3.writeTo(writer);

    /* TestCase: V2SigTestsResource_ResourceRequest_SIGResource_hasGetETagReturns */
    /* Details: "ResourceRequest method getETag() returns String " */
    TestResult tr4 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_RESOURCEREQUEST_SIGRESOURCE_HASGETETAGRETURNS);
    try {
      String name = "getETag";
      Class<?> retType = String.class;
      Class<?>[] parms = null;
      tr4.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr4.appendTcDetail(e.toString());
    }
    tr4.writeTo(writer);

    /* TestCase: V2SigTestsResource_ResourceRequest_SIGResource_hasGetPrivateRenderParameterMap */
    /* Details: "ResourceRequest has a getPrivateRenderParameterMap() */
    /* method " */
    TestResult tr5 = tcd.getTestResultFailed(
        V2SIGTESTSRESOURCE_RESOURCEREQUEST_SIGRESOURCE_HASGETPRIVATERENDERPARAMETERMAP);
    try {
      String name = "getPrivateRenderParameterMap";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr5.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr5.appendTcDetail(e.toString());
    }
    tr5.writeTo(writer);

    /*
     * TestCase:
     * V2SigTestsResource_ResourceRequest_SIGResource_hasGetPrivateRenderParameterMapReturns
     */
    /* Details: "ResourceRequest method getPrivateRenderParameterMap() */
    /* returns java.util.Map " */
    TestResult tr6 = tcd.getTestResultFailed(
        V2SIGTESTSRESOURCE_RESOURCEREQUEST_SIGRESOURCE_HASGETPRIVATERENDERPARAMETERMAPRETURNS);
    try {
      String name = "getPrivateRenderParameterMap";
      Class<?> retType = java.util.Map.class;
      Class<?>[] parms = null;
      tr6.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr6.appendTcDetail(e.toString());
    }
    tr6.writeTo(writer);

    /* TestCase: V2SigTestsResource_ResourceRequest_SIGResource_hasGetResourceID */
    /* Details: "ResourceRequest has a getResourceID()  method " */
    TestResult tr7 =
        tcd.getTestResultFailed(V2SIGTESTSRESOURCE_RESOURCEREQUEST_SIGRESOURCE_HASGETRESOURCEID);
    try {
      String name = "getResourceID";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr7.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr7.appendTcDetail(e.toString());
    }
    tr7.writeTo(writer);

    /* TestCase: V2SigTestsResource_ResourceRequest_SIGResource_hasGetResourceIDReturns */
    /* Details: "ResourceRequest method getResourceID() returns String " */
    TestResult tr8 = tcd.getTestResultFailed(
        V2SIGTESTSRESOURCE_RESOURCEREQUEST_SIGRESOURCE_HASGETRESOURCEIDRETURNS);
    try {
      String name = "getResourceID";
      Class<?> retType = String.class;
      Class<?>[] parms = null;
      tr8.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr8.appendTcDetail(e.toString());
    }
    tr8.writeTo(writer);

    /* TestCase: V2SigTestsResource_ResourceRequest_SIGResource_hasGetResponseContentType */
    /* Details: "ResourceRequest has a getResponseContentType()  method " */
    TestResult tr9 = tcd.getTestResultFailed(
        V2SIGTESTSRESOURCE_RESOURCEREQUEST_SIGRESOURCE_HASGETRESPONSECONTENTTYPE);
    try {
      String name = "getResponseContentType";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr9.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr9.appendTcDetail(e.toString());
    }
    tr9.writeTo(writer);

    /* TestCase: V2SigTestsResource_ResourceRequest_SIGResource_hasGetResponseContentTypeReturns */
    /* Details: "ResourceRequest method getResponseContentType() returns */
    /* String " */
    TestResult tr10 = tcd.getTestResultFailed(
        V2SIGTESTSRESOURCE_RESOURCEREQUEST_SIGRESOURCE_HASGETRESPONSECONTENTTYPERETURNS);
    try {
      String name = "getResponseContentType";
      Class<?> retType = String.class;
      Class<?>[] parms = null;
      tr10.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr10.appendTcDetail(e.toString());
    }
    tr10.writeTo(writer);

    /* TestCase: V2SigTestsResource_ResourceRequest_SIGResource_hasGetResponseContentTypes */
    /* Details: "ResourceRequest has a getResponseContentTypes() method */
    /* " */
    TestResult tr11 = tcd.getTestResultFailed(
        V2SIGTESTSRESOURCE_RESOURCEREQUEST_SIGRESOURCE_HASGETRESPONSECONTENTTYPES);
    try {
      String name = "getResponseContentTypes";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr11.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr11.appendTcDetail(e.toString());
    }
    tr11.writeTo(writer);

    /* TestCase: V2SigTestsResource_ResourceRequest_SIGResource_hasGetResponseContentTypesReturns */
    /* Details: "ResourceRequest method getResponseContentTypes() returns */
    /* java.util.Enumeration " */
    TestResult tr12 = tcd.getTestResultFailed(
        V2SIGTESTSRESOURCE_RESOURCEREQUEST_SIGRESOURCE_HASGETRESPONSECONTENTTYPESRETURNS);
    try {
      String name = "getResponseContentTypes";
      Class<?> retType = java.util.Enumeration.class;
      Class<?>[] parms = null;
      tr12.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr12.appendTcDetail(e.toString());
    }
    tr12.writeTo(writer);

    /* TestCase: V2SigTestsResource_ResourceRequest_SIGResource_implementsClientDataRequest */
    /* Details: "ResourceRequest implements ClientDataRequest " */
    TestResult tr13 = tcd.getTestResultFailed(
        V2SIGTESTSRESOURCE_RESOURCEREQUEST_SIGRESOURCE_IMPLEMENTSCLIENTDATAREQUEST);
    try {
      tr13.setTcSuccess(cc.implementsInterface(ClientDataRequest.class));
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
        "<div id=\"SigTestsResource_ResourceRequest_SIGResource\">no resource output.</div>\n");
    ResourceURL resurl = portletResp.createResourceURL();
    resurl.setCacheability(PAGE);
    writer.write("<script>\n");
    writer.write("(function () {\n");
    writer.write("   var xhr = new XMLHttpRequest();\n");
    writer.write("   xhr.onreadystatechange=function() {\n");
    writer.write("      if (xhr.readyState==4 && xhr.status==200) {\n");
    writer.write(
        "         document.getElementById(\"SigTestsResource_ResourceRequest_SIGResource\").innerHTML=xhr.responseText;\n");
    writer.write("      }\n");
    writer.write("   };\n");
    writer.write("   xhr.open(\"GET\",\"" + resurl.toString() + "\",true);\n");
    writer.write("   xhr.send();\n");
    writer.write("})();\n");
    writer.write("</script>\n");
  }

}
