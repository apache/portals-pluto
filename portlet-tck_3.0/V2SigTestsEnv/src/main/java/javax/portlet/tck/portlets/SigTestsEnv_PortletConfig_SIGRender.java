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
import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.tck.beans.ClassChecker;
import javax.portlet.tck.beans.JSR286SignatureTestCaseDetails;
import javax.portlet.tck.beans.TestResult;

import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETCONTAINERRUNTIMEOPTIONS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETCONTAINERRUNTIMEOPTIONSRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETDEFAULTNAMESPACE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETDEFAULTNAMESPACERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETINITPARAMETER;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETINITPARAMETERNAMES;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETINITPARAMETERNAMESRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETINITPARAMETERRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETPORTLETCONTEXT;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETPORTLETCONTEXTRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETPORTLETNAME;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETPORTLETNAMERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETPROCESSINGEVENTQNAMES;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETPROCESSINGEVENTQNAMESRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETPUBLICRENDERPARAMETERNAMES;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETPUBLICRENDERPARAMETERNAMESRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETPUBLISHINGEVENTQNAMES;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETPUBLISHINGEVENTQNAMESRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETRESOURCEBUNDLE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETRESOURCEBUNDLERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETSUPPORTEDLOCALES;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETSUPPORTEDLOCALESRETURNS;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined
 * in the /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate
 * the test case names defined in the additionalTCs.xml file into the complete list of test case
 * names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will
 * initiate the events, but not process them. The processing is done in the companion portlet
 * SigTestsEnv_PortletConfig_SIGRender_event
 *
 */
public class SigTestsEnv_PortletConfig_SIGRender implements Portlet {

  private PortletConfig portletConfig = null;

  @Override
  public void init(PortletConfig config) throws PortletException {
    this.portletConfig = config;
  }

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

    ClassChecker cc = new ClassChecker(portletConfig.getClass());

    /* TestCase: V2SigTestsEnv_PortletConfig_SIGRender_hasGetContainerRuntimeOptions */
    /* Details: "PortletConfig has a getContainerRuntimeOptions() method */
    /* " */
    TestResult tr0 = tcd
        .getTestResultFailed(V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETCONTAINERRUNTIMEOPTIONS);
    try {
      String name = "getContainerRuntimeOptions";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr0.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr0.appendTcDetail(e.toString());
    }
    tr0.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletConfig_SIGRender_hasGetContainerRuntimeOptionsReturns */
    /* Details: "PortletConfig method getContainerRuntimeOptions() */
    /* returns java.util.Map " */
    TestResult tr1 = tcd.getTestResultFailed(
        V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETCONTAINERRUNTIMEOPTIONSRETURNS);
    try {
      String name = "getContainerRuntimeOptions";
      Class<?> retType = java.util.Map.class;
      Class<?>[] parms = null;
      tr1.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr1.appendTcDetail(e.toString());
    }
    tr1.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletConfig_SIGRender_hasGetDefaultNamespace */
    /* Details: "PortletConfig has a getDefaultNamespace()  method " */
    TestResult tr2 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETDEFAULTNAMESPACE);
    try {
      String name = "getDefaultNamespace";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr2.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr2.appendTcDetail(e.toString());
    }
    tr2.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletConfig_SIGRender_hasGetDefaultNamespaceReturns */
    /* Details: "PortletConfig method getDefaultNamespace() returns */
    /* String " */
    TestResult tr3 = tcd
        .getTestResultFailed(V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETDEFAULTNAMESPACERETURNS);
    try {
      String name = "getDefaultNamespace";
      Class<?> retType = String.class;
      Class<?>[] parms = null;
      tr3.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr3.appendTcDetail(e.toString());
    }
    tr3.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletConfig_SIGRender_hasGetInitParameter */
    /* Details: "PortletConfig has a getInitParameter(String)  method " */
    TestResult tr4 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETINITPARAMETER);
    try {
      String name = "getInitParameter";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {String.class};
      tr4.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr4.appendTcDetail(e.toString());
    }
    tr4.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletConfig_SIGRender_hasGetInitParameterNames */
    /* Details: "PortletConfig has a getInitParameterNames()  method " */
    TestResult tr5 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETINITPARAMETERNAMES);
    try {
      String name = "getInitParameterNames";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr5.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr5.appendTcDetail(e.toString());
    }
    tr5.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletConfig_SIGRender_hasGetInitParameterNamesReturns */
    /* Details: "PortletConfig method getInitParameterNames() returns */
    /* java.util.Enumeration " */
    TestResult tr6 = tcd
        .getTestResultFailed(V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETINITPARAMETERNAMESRETURNS);
    try {
      String name = "getInitParameterNames";
      Class<?> retType = java.util.Enumeration.class;
      Class<?>[] parms = null;
      tr6.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr6.appendTcDetail(e.toString());
    }
    tr6.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletConfig_SIGRender_hasGetInitParameterReturns */
    /* Details: "PortletConfig method getInitParameter(String) returns */
    /* String " */
    TestResult tr7 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETINITPARAMETERRETURNS);
    try {
      String name = "getInitParameter";
      Class<?> retType = String.class;
      Class<?>[] parms = {String.class};
      tr7.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr7.appendTcDetail(e.toString());
    }
    tr7.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletConfig_SIGRender_hasGetPortletContext */
    /* Details: "PortletConfig has a getPortletContext()  method " */
    TestResult tr8 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETPORTLETCONTEXT);
    try {
      String name = "getPortletContext";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr8.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr8.appendTcDetail(e.toString());
    }
    tr8.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletConfig_SIGRender_hasGetPortletContextReturns */
    /* Details: "PortletConfig method getPortletContext() returns */
    /* PortletContext " */
    TestResult tr9 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETPORTLETCONTEXTRETURNS);
    try {
      String name = "getPortletContext";
      Class<?> retType = PortletContext.class;
      Class<?>[] parms = null;
      tr9.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr9.appendTcDetail(e.toString());
    }
    tr9.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletConfig_SIGRender_hasGetPortletName */
    /* Details: "PortletConfig has a getPortletName()  method " */
    TestResult tr10 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETPORTLETNAME);
    try {
      String name = "getPortletName";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr10.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr10.appendTcDetail(e.toString());
    }
    tr10.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletConfig_SIGRender_hasGetPortletNameReturns */
    /* Details: "PortletConfig method getPortletName() returns String " */
    TestResult tr11 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETPORTLETNAMERETURNS);
    try {
      String name = "getPortletName";
      Class<?> retType = String.class;
      Class<?>[] parms = null;
      tr11.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr11.appendTcDetail(e.toString());
    }
    tr11.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletConfig_SIGRender_hasGetProcessingEventQNames */
    /* Details: "PortletConfig has a getProcessingEventQNames()  method " */
    TestResult tr12 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETPROCESSINGEVENTQNAMES);
    try {
      String name = "getProcessingEventQNames";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr12.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr12.appendTcDetail(e.toString());
    }
    tr12.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletConfig_SIGRender_hasGetProcessingEventQNamesReturns */
    /* Details: "PortletConfig method getProcessingEventQNames() returns */
    /* java.util.Enumeration " */
    TestResult tr13 = tcd.getTestResultFailed(
        V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETPROCESSINGEVENTQNAMESRETURNS);
    try {
      String name = "getProcessingEventQNames";
      Class<?> retType = java.util.Enumeration.class;
      Class<?>[] parms = null;
      tr13.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr13.appendTcDetail(e.toString());
    }
    tr13.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletConfig_SIGRender_hasGetPublicRenderParameterNames */
    /* Details: "PortletConfig has a getPublicRenderParameterNames() */
    /* method " */
    TestResult tr14 = tcd.getTestResultFailed(
        V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETPUBLICRENDERPARAMETERNAMES);
    try {
      String name = "getPublicRenderParameterNames";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr14.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr14.appendTcDetail(e.toString());
    }
    tr14.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletConfig_SIGRender_hasGetPublicRenderParameterNamesReturns */
    /* Details: "PortletConfig method getPublicRenderParameterNames() */
    /* returns java.util.Enumeration " */
    TestResult tr15 = tcd.getTestResultFailed(
        V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETPUBLICRENDERPARAMETERNAMESRETURNS);
    try {
      String name = "getPublicRenderParameterNames";
      Class<?> retType = java.util.Enumeration.class;
      Class<?>[] parms = null;
      tr15.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr15.appendTcDetail(e.toString());
    }
    tr15.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletConfig_SIGRender_hasGetPublishingEventQNames */
    /* Details: "PortletConfig has a getPublishingEventQNames()  method " */
    TestResult tr16 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETPUBLISHINGEVENTQNAMES);
    try {
      String name = "getPublishingEventQNames";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr16.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr16.appendTcDetail(e.toString());
    }
    tr16.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletConfig_SIGRender_hasGetPublishingEventQNamesReturns */
    /* Details: "PortletConfig method getPublishingEventQNames() returns */
    /* java.util.Enumeration " */
    TestResult tr17 = tcd.getTestResultFailed(
        V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETPUBLISHINGEVENTQNAMESRETURNS);
    try {
      String name = "getPublishingEventQNames";
      Class<?> retType = java.util.Enumeration.class;
      Class<?>[] parms = null;
      tr17.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr17.appendTcDetail(e.toString());
    }
    tr17.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletConfig_SIGRender_hasGetResourceBundle */
    /* Details: "PortletConfig has a getResourceBundle(java.util.Locale) */
    /* method " */
    TestResult tr18 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETRESOURCEBUNDLE);
    try {
      String name = "getResourceBundle";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {java.util.Locale.class};
      tr18.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr18.appendTcDetail(e.toString());
    }
    tr18.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletConfig_SIGRender_hasGetResourceBundleReturns */
    /* Details: "PortletConfig method getResourceBundle(java.util.Locale) */
    /* returns java.util.ResourceBundle " */
    TestResult tr19 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETRESOURCEBUNDLERETURNS);
    try {
      String name = "getResourceBundle";
      Class<?> retType = java.util.ResourceBundle.class;
      Class<?>[] parms = {java.util.Locale.class};
      tr19.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr19.appendTcDetail(e.toString());
    }
    tr19.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletConfig_SIGRender_hasGetSupportedLocales */
    /* Details: "PortletConfig has a getSupportedLocales()  method " */
    TestResult tr20 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETSUPPORTEDLOCALES);
    try {
      String name = "getSupportedLocales";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr20.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr20.appendTcDetail(e.toString());
    }
    tr20.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletConfig_SIGRender_hasGetSupportedLocalesReturns */
    /* Details: "PortletConfig method getSupportedLocales() returns */
    /* java.util.Enumeration " */
    TestResult tr21 = tcd
        .getTestResultFailed(V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETSUPPORTEDLOCALESRETURNS);
    try {
      String name = "getSupportedLocales";
      Class<?> retType = java.util.Enumeration.class;
      Class<?>[] parms = null;
      tr21.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr21.appendTcDetail(e.toString());
    }
    tr21.writeTo(writer);

  }

}
