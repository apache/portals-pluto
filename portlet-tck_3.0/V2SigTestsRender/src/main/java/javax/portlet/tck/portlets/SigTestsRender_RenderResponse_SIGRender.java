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
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.tck.beans.ClassChecker;
import javax.portlet.tck.beans.JSR286SignatureTestCaseDetails;
import javax.portlet.tck.beans.TestResult;

import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_RENDERRESPONSE_SIGRENDER_HASSETCONTENTTYPE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_RENDERRESPONSE_SIGRENDER_HASSETCONTENTTYPERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_RENDERRESPONSE_SIGRENDER_HASSETNEXTPOSSIBLEPORTLETMODES;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_RENDERRESPONSE_SIGRENDER_HASSETNEXTPOSSIBLEPORTLETMODESRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_RENDERRESPONSE_SIGRENDER_HASSETTITLE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_RENDERRESPONSE_SIGRENDER_HASSETTITLERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSRENDER_RENDERRESPONSE_SIGRENDER_IMPLEMENTSMIMERESPONSE;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined
 * in the /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate
 * the test case names defined in the additionalTCs.xml file into the complete list of test case
 * names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will
 * initiate the events, but not process them. The processing is done in the companion portlet
 * SigTestsRender_RenderResponse_SIGRender_event
 *
 */
public class SigTestsRender_RenderResponse_SIGRender implements Portlet {

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

    /* TestCase: V2SigTestsRender_RenderResponse_SIGRender_hasSetContentType */
    /* Details: "RenderResponse has a setContentType(String)  method " */
    TestResult tr0 =
        tcd.getTestResultFailed(V2SIGTESTSRENDER_RENDERRESPONSE_SIGRENDER_HASSETCONTENTTYPE);
    try {
      String name = "setContentType";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {String.class};
      tr0.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr0.appendTcDetail(e.toString());
    }
    tr0.writeTo(writer);

    /* TestCase: V2SigTestsRender_RenderResponse_SIGRender_hasSetContentTypeReturns */
    /* Details: "RenderResponse method setContentType(String) returns */
    /* void " */
    TestResult tr1 =
        tcd.getTestResultFailed(V2SIGTESTSRENDER_RENDERRESPONSE_SIGRENDER_HASSETCONTENTTYPERETURNS);
    try {
      String name = "setContentType";
      Class<?> retType = void.class;
      Class<?>[] parms = {String.class};
      tr1.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr1.appendTcDetail(e.toString());
    }
    tr1.writeTo(writer);

    /* TestCase: V2SigTestsRender_RenderResponse_SIGRender_hasSetNextPossiblePortletModes */
    /* Details: "RenderResponse has a */
    /* setNextPossiblePortletModes(java.util.Collection) method " */
    TestResult tr2 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_RENDERRESPONSE_SIGRENDER_HASSETNEXTPOSSIBLEPORTLETMODES);
    try {
      String name = "setNextPossiblePortletModes";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {java.util.Collection.class};
      tr2.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr2.appendTcDetail(e.toString());
    }
    tr2.writeTo(writer);

    /* TestCase: V2SigTestsRender_RenderResponse_SIGRender_hasSetNextPossiblePortletModesReturns */
    /* Details: "RenderResponse method */
    /* setNextPossiblePortletModes(java.util.Collection) returns void " */
    TestResult tr3 = tcd.getTestResultFailed(
        V2SIGTESTSRENDER_RENDERRESPONSE_SIGRENDER_HASSETNEXTPOSSIBLEPORTLETMODESRETURNS);
    try {
      String name = "setNextPossiblePortletModes";
      Class<?> retType = void.class;
      Class<?>[] parms = {java.util.Collection.class};
      tr3.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr3.appendTcDetail(e.toString());
    }
    tr3.writeTo(writer);

    /* TestCase: V2SigTestsRender_RenderResponse_SIGRender_hasSetTitle */
    /* Details: "RenderResponse has a setTitle(String)  method " */
    TestResult tr4 = tcd.getTestResultFailed(V2SIGTESTSRENDER_RENDERRESPONSE_SIGRENDER_HASSETTITLE);
    try {
      String name = "setTitle";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {String.class};
      tr4.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr4.appendTcDetail(e.toString());
    }
    tr4.writeTo(writer);

    /* TestCase: V2SigTestsRender_RenderResponse_SIGRender_hasSetTitleReturns */
    /* Details: "RenderResponse method setTitle(String) returns void " */
    TestResult tr5 =
        tcd.getTestResultFailed(V2SIGTESTSRENDER_RENDERRESPONSE_SIGRENDER_HASSETTITLERETURNS);
    try {
      String name = "setTitle";
      Class<?> retType = void.class;
      Class<?>[] parms = {String.class};
      tr5.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr5.appendTcDetail(e.toString());
    }
    tr5.writeTo(writer);

    /* TestCase: V2SigTestsRender_RenderResponse_SIGRender_implementsMimeResponse */
    /* Details: "RenderResponse implements MimeResponse " */
    TestResult tr6 =
        tcd.getTestResultFailed(V2SIGTESTSRENDER_RENDERRESPONSE_SIGRENDER_IMPLEMENTSMIMERESPONSE);
    try {
      tr6.setTcSuccess(cc.implementsInterface(MimeResponse.class));
    } catch (Exception e) {
      tr6.appendTcDetail(e.toString());
    }
    tr6.writeTo(writer);

  }

}
