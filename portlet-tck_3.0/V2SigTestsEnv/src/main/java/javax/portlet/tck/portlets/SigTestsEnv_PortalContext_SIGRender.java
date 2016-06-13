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
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.tck.beans.ClassChecker;
import javax.portlet.tck.beans.JSR286SignatureTestCaseDetails;
import javax.portlet.tck.beans.TestResult;

import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTALCONTEXT_SIGRENDER_FIELDMARKUP_HEAD_ELEMENT_SUPPORT;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTALCONTEXT_SIGRENDER_HASGETPORTALINFO;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTALCONTEXT_SIGRENDER_HASGETPORTALINFORETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTALCONTEXT_SIGRENDER_HASGETPROPERTY;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTALCONTEXT_SIGRENDER_HASGETPROPERTYNAMES;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTALCONTEXT_SIGRENDER_HASGETPROPERTYNAMESRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTALCONTEXT_SIGRENDER_HASGETPROPERTYRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTALCONTEXT_SIGRENDER_HASGETSUPPORTEDPORTLETMODES;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTALCONTEXT_SIGRENDER_HASGETSUPPORTEDPORTLETMODESRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTALCONTEXT_SIGRENDER_HASGETSUPPORTEDWINDOWSTATES;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTALCONTEXT_SIGRENDER_HASGETSUPPORTEDWINDOWSTATESRETURNS;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined
 * in the /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate
 * the test case names defined in the additionalTCs.xml file into the complete list of test case
 * names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will
 * initiate the events, but not process them. The processing is done in the companion portlet
 * SigTestsEnv_PortalContext_SIGRender_event
 *
 */
public class SigTestsEnv_PortalContext_SIGRender implements Portlet {

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

    ClassChecker cc = new ClassChecker(portletReq.getPortalContext().getClass());

    /* TestCase: V2SigTestsEnv_PortalContext_SIGRender_fieldMARKUP_HEAD_ELEMENT_SUPPORT */
    /* Details: "PortalContext has String field */
    /* MARKUP_HEAD_ELEMENT_SUPPORT " */
    TestResult tr0 = tcd.getTestResultFailed(
        V2SIGTESTSENV_PORTALCONTEXT_SIGRENDER_FIELDMARKUP_HEAD_ELEMENT_SUPPORT);
    try {
      tr0.setTcSuccess(cc.hasField("MARKUP_HEAD_ELEMENT_SUPPORT"));
    } catch (Exception e) {
      tr0.appendTcDetail(e.toString());
    }
    tr0.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortalContext_SIGRender_hasGetPortalInfo */
    /* Details: "PortalContext has a getPortalInfo()  method " */
    TestResult tr1 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTALCONTEXT_SIGRENDER_HASGETPORTALINFO);
    try {
      String name = "getPortalInfo";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr1.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr1.appendTcDetail(e.toString());
    }
    tr1.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortalContext_SIGRender_hasGetPortalInfoReturns */
    /* Details: "PortalContext method getPortalInfo() returns String " */
    TestResult tr2 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTALCONTEXT_SIGRENDER_HASGETPORTALINFORETURNS);
    try {
      String name = "getPortalInfo";
      Class<?> retType = String.class;
      Class<?>[] parms = null;
      tr2.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr2.appendTcDetail(e.toString());
    }
    tr2.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortalContext_SIGRender_hasGetProperty */
    /* Details: "PortalContext has a getProperty(String)  method " */
    TestResult tr3 = tcd.getTestResultFailed(V2SIGTESTSENV_PORTALCONTEXT_SIGRENDER_HASGETPROPERTY);
    try {
      String name = "getProperty";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {String.class};
      tr3.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr3.appendTcDetail(e.toString());
    }
    tr3.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortalContext_SIGRender_hasGetPropertyNames */
    /* Details: "PortalContext has a getPropertyNames()  method " */
    TestResult tr4 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTALCONTEXT_SIGRENDER_HASGETPROPERTYNAMES);
    try {
      String name = "getPropertyNames";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr4.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr4.appendTcDetail(e.toString());
    }
    tr4.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortalContext_SIGRender_hasGetPropertyNamesReturns */
    /* Details: "PortalContext method getPropertyNames() returns */
    /* java.util.Enumeration " */
    TestResult tr5 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTALCONTEXT_SIGRENDER_HASGETPROPERTYNAMESRETURNS);
    try {
      String name = "getPropertyNames";
      Class<?> retType = java.util.Enumeration.class;
      Class<?>[] parms = null;
      tr5.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr5.appendTcDetail(e.toString());
    }
    tr5.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortalContext_SIGRender_hasGetPropertyReturns */
    /* Details: "PortalContext method getProperty(String) returns String */
    /* " */
    TestResult tr6 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTALCONTEXT_SIGRENDER_HASGETPROPERTYRETURNS);
    try {
      String name = "getProperty";
      Class<?> retType = String.class;
      Class<?>[] parms = {String.class};
      tr6.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr6.appendTcDetail(e.toString());
    }
    tr6.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortalContext_SIGRender_hasGetSupportedPortletModes */
    /* Details: "PortalContext has a getSupportedPortletModes()  method " */
    TestResult tr7 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTALCONTEXT_SIGRENDER_HASGETSUPPORTEDPORTLETMODES);
    try {
      String name = "getSupportedPortletModes";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr7.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr7.appendTcDetail(e.toString());
    }
    tr7.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortalContext_SIGRender_hasGetSupportedPortletModesReturns */
    /* Details: "PortalContext method getSupportedPortletModes() returns */
    /* java.util.Enumeration " */
    TestResult tr8 = tcd.getTestResultFailed(
        V2SIGTESTSENV_PORTALCONTEXT_SIGRENDER_HASGETSUPPORTEDPORTLETMODESRETURNS);
    try {
      String name = "getSupportedPortletModes";
      Class<?> retType = java.util.Enumeration.class;
      Class<?>[] parms = null;
      tr8.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr8.appendTcDetail(e.toString());
    }
    tr8.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortalContext_SIGRender_hasGetSupportedWindowStates */
    /* Details: "PortalContext has a getSupportedWindowStates()  method " */
    TestResult tr9 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTALCONTEXT_SIGRENDER_HASGETSUPPORTEDWINDOWSTATES);
    try {
      String name = "getSupportedWindowStates";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr9.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr9.appendTcDetail(e.toString());
    }
    tr9.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortalContext_SIGRender_hasGetSupportedWindowStatesReturns */
    /* Details: "PortalContext method getSupportedWindowStates() returns */
    /* java.util.Enumeration " */
    TestResult tr10 = tcd.getTestResultFailed(
        V2SIGTESTSENV_PORTALCONTEXT_SIGRENDER_HASGETSUPPORTEDWINDOWSTATESRETURNS);
    try {
      String name = "getSupportedWindowStates";
      Class<?> retType = java.util.Enumeration.class;
      Class<?>[] parms = null;
      tr10.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr10.appendTcDetail(e.toString());
    }
    tr10.writeTo(writer);

  }

}
