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
import javax.portlet.EventPortlet;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceServingPortlet;
import javax.portlet.tck.beans.ClassChecker;
import javax.portlet.tck.beans.JSR286SignatureTestCaseDetails;
import javax.portlet.tck.beans.TestResult;

import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_CONSTRUCTOR;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASDESTROY;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASDESTROYRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASDODISPATCH;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASDODISPATCHRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASDOEDIT;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASDOEDITRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASDOHEADERS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASDOHEADERSRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASDOHELP;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASDOHELPRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASDOVIEW;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASDOVIEWRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETCONTAINERRUNTIMEOPTIONS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETCONTAINERRUNTIMEOPTIONSRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETDEFAULTNAMESPACE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETDEFAULTNAMESPACERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETINITPARAMETER;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETINITPARAMETERNAMES;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETINITPARAMETERNAMESRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETINITPARAMETERRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETNEXTPOSSIBLEPORTLETMODES;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETNEXTPOSSIBLEPORTLETMODESRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETPORTLETCONFIG;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETPORTLETCONFIGRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETPORTLETCONTEXT;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETPORTLETCONTEXTRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETPORTLETNAME;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETPORTLETNAMERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETPROCESSINGEVENTQNAMES;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETPROCESSINGEVENTQNAMESRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETPUBLICRENDERPARAMETERNAMES;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETPUBLICRENDERPARAMETERNAMESRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETPUBLISHINGEVENTQNAMES;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETPUBLISHINGEVENTQNAMESRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETRESOURCEBUNDLE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETRESOURCEBUNDLERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETSUPPORTEDLOCALES;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETSUPPORTEDLOCALESRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETTITLE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETTITLERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASINIT;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASINITA;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASINITRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASINITRETURNSA;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASPROCESSACTION;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASPROCESSACTIONRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASPROCESSEVENT;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASPROCESSEVENTRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASRENDER;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASRENDERRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASSERVERESOURCE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASSERVERESOURCERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_IMPLEMENTSEVENTPORTLET;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_IMPLEMENTSPORTLET;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_IMPLEMENTSPORTLETCONFIG;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_IMPLEMENTSRESOURCESERVINGPORTLET;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined
 * in the /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate
 * the test case names defined in the additionalTCs.xml file into the complete list of test case
 * names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will
 * initiate the events, but not process them. The processing is done in the companion portlet
 * SigTestsEnv_GenericPortlet_SIGRender_event
 *
 */
public class SigTestsEnv_GenericPortlet_SIGRender implements Portlet {

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

    ClassChecker cc = new ClassChecker(GenericPortlet.class);

    /* TestCase: V2SigTestsEnv_GenericPortlet_SIGRender_constructor */
    /* Details: "GenericPortlet provides constructor GenericPortlet() " */
    TestResult tr0 = tcd.getTestResultFailed(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_CONSTRUCTOR);
    try {
      Class<?>[] parms = null;
      tr0.setTcSuccess(cc.hasConstructor(parms));
    } catch (Exception e) {
      tr0.appendTcDetail(e.toString());
    }
    tr0.writeTo(writer);

    /* TestCase: V2SigTestsEnv_GenericPortlet_SIGRender_hasDestroy */
    /* Details: "GenericPortlet has a destroy()  method " */
    TestResult tr1 = tcd.getTestResultFailed(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASDESTROY);
    try {
      String name = "destroy";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr1.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr1.appendTcDetail(e.toString());
    }
    tr1.writeTo(writer);

    /* TestCase: V2SigTestsEnv_GenericPortlet_SIGRender_hasDestroyReturns */
    /* Details: "GenericPortlet method destroy() returns void " */
    TestResult tr2 =
        tcd.getTestResultFailed(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASDESTROYRETURNS);
    try {
      String name = "destroy";
      Class<?> retType = void.class;
      Class<?>[] parms = null;
      tr2.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr2.appendTcDetail(e.toString());
    }
    tr2.writeTo(writer);

    /* TestCase: V2SigTestsEnv_GenericPortlet_SIGRender_hasDoDispatch */
    /* Details: "GenericPortlet has a doDispatch(RenderRequest, */
    /* RenderResponse) throws PortletException, java.io.IOException */
    /* method " */
    TestResult tr3 = tcd.getTestResultFailed(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASDODISPATCH);
    try {
      String name = "doDispatch";
      Class<?>[] exceptions = {PortletException.class, java.io.IOException.class};
      Class<?>[] parms = {RenderRequest.class, RenderResponse.class};
      tr3.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr3.appendTcDetail(e.toString());
    }
    tr3.writeTo(writer);

    /* TestCase: V2SigTestsEnv_GenericPortlet_SIGRender_hasDoDispatchReturns */
    /* Details: "GenericPortlet method doDispatch(RenderRequest, */
    /* RenderResponse) returns void " */
    TestResult tr4 =
        tcd.getTestResultFailed(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASDODISPATCHRETURNS);
    try {
      String name = "doDispatch";
      Class<?> retType = void.class;
      Class<?>[] parms = {RenderRequest.class, RenderResponse.class};
      tr4.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr4.appendTcDetail(e.toString());
    }
    tr4.writeTo(writer);

    /* TestCase: V2SigTestsEnv_GenericPortlet_SIGRender_hasDoEdit */
    /* Details: "GenericPortlet has a doEdit(RenderRequest, */
    /* RenderResponse) throws PortletException, java.io.IOException */
    /* method " */
    TestResult tr5 = tcd.getTestResultFailed(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASDOEDIT);
    try {
      String name = "doEdit";
      Class<?>[] exceptions = {PortletException.class, java.io.IOException.class};
      Class<?>[] parms = {RenderRequest.class, RenderResponse.class};
      tr5.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr5.appendTcDetail(e.toString());
    }
    tr5.writeTo(writer);

    /* TestCase: V2SigTestsEnv_GenericPortlet_SIGRender_hasDoEditReturns */
    /* Details: "GenericPortlet method doEdit(RenderRequest, */
    /* RenderResponse) returns void " */
    TestResult tr6 =
        tcd.getTestResultFailed(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASDOEDITRETURNS);
    try {
      String name = "doEdit";
      Class<?> retType = void.class;
      Class<?>[] parms = {RenderRequest.class, RenderResponse.class};
      tr6.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr6.appendTcDetail(e.toString());
    }
    tr6.writeTo(writer);

    /* TestCase: V2SigTestsEnv_GenericPortlet_SIGRender_hasDoHeaders */
    /* Details: "GenericPortlet has a doHeaders(RenderRequest, */
    /* RenderResponse) method " */
    TestResult tr7 = tcd.getTestResultFailed(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASDOHEADERS);
    try {
      String name = "doHeaders";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {RenderRequest.class, RenderResponse.class};
      tr7.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr7.appendTcDetail(e.toString());
    }
    tr7.writeTo(writer);

    /* TestCase: V2SigTestsEnv_GenericPortlet_SIGRender_hasDoHeadersReturns */
    /* Details: "GenericPortlet method doHeaders(RenderRequest, */
    /* RenderResponse) returns void " */
    TestResult tr8 =
        tcd.getTestResultFailed(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASDOHEADERSRETURNS);
    try {
      String name = "doHeaders";
      Class<?> retType = void.class;
      Class<?>[] parms = {RenderRequest.class, RenderResponse.class};
      tr8.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr8.appendTcDetail(e.toString());
    }
    tr8.writeTo(writer);

    /* TestCase: V2SigTestsEnv_GenericPortlet_SIGRender_hasDoHelp */
    /* Details: "GenericPortlet has a doHelp(RenderRequest, */
    /* RenderResponse) throws PortletException, java.io.IOException */
    /* method " */
    TestResult tr9 = tcd.getTestResultFailed(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASDOHELP);
    try {
      String name = "doHelp";
      Class<?>[] exceptions = {PortletException.class, java.io.IOException.class};
      Class<?>[] parms = {RenderRequest.class, RenderResponse.class};
      tr9.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr9.appendTcDetail(e.toString());
    }
    tr9.writeTo(writer);

    /* TestCase: V2SigTestsEnv_GenericPortlet_SIGRender_hasDoHelpReturns */
    /* Details: "GenericPortlet method doHelp(RenderRequest, */
    /* RenderResponse) returns void " */
    TestResult tr10 =
        tcd.getTestResultFailed(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASDOHELPRETURNS);
    try {
      String name = "doHelp";
      Class<?> retType = void.class;
      Class<?>[] parms = {RenderRequest.class, RenderResponse.class};
      tr10.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr10.appendTcDetail(e.toString());
    }
    tr10.writeTo(writer);

    /* TestCase: V2SigTestsEnv_GenericPortlet_SIGRender_hasDoView */
    /* Details: "GenericPortlet has a doView(RenderRequest, */
    /* RenderResponse) throws PortletException, java.io.IOException */
    /* method " */
    TestResult tr11 = tcd.getTestResultFailed(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASDOVIEW);
    try {
      String name = "doView";
      Class<?>[] exceptions = {PortletException.class, java.io.IOException.class};
      Class<?>[] parms = {RenderRequest.class, RenderResponse.class};
      tr11.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr11.appendTcDetail(e.toString());
    }
    tr11.writeTo(writer);

    /* TestCase: V2SigTestsEnv_GenericPortlet_SIGRender_hasDoViewReturns */
    /* Details: "GenericPortlet method doView(RenderRequest, */
    /* RenderResponse) returns void " */
    TestResult tr12 =
        tcd.getTestResultFailed(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASDOVIEWRETURNS);
    try {
      String name = "doView";
      Class<?> retType = void.class;
      Class<?>[] parms = {RenderRequest.class, RenderResponse.class};
      tr12.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr12.appendTcDetail(e.toString());
    }
    tr12.writeTo(writer);

    /* TestCase: V2SigTestsEnv_GenericPortlet_SIGRender_hasGetContainerRuntimeOptions */
    /* Details: "GenericPortlet has a getContainerRuntimeOptions() */
    /* method " */
    TestResult tr13 = tcd
        .getTestResultFailed(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETCONTAINERRUNTIMEOPTIONS);
    try {
      String name = "getContainerRuntimeOptions";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr13.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr13.appendTcDetail(e.toString());
    }
    tr13.writeTo(writer);

    /* TestCase: V2SigTestsEnv_GenericPortlet_SIGRender_hasGetContainerRuntimeOptionsReturns */
    /* Details: "GenericPortlet method getContainerRuntimeOptions() */
    /* returns java.util.Map " */
    TestResult tr14 = tcd.getTestResultFailed(
        V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETCONTAINERRUNTIMEOPTIONSRETURNS);
    try {
      String name = "getContainerRuntimeOptions";
      Class<?> retType = java.util.Map.class;
      Class<?>[] parms = null;
      tr14.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr14.appendTcDetail(e.toString());
    }
    tr14.writeTo(writer);

    /* TestCase: V2SigTestsEnv_GenericPortlet_SIGRender_hasGetDefaultNamespace */
    /* Details: "GenericPortlet has a getDefaultNamespace()  method " */
    TestResult tr15 =
        tcd.getTestResultFailed(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETDEFAULTNAMESPACE);
    try {
      String name = "getDefaultNamespace";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr15.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr15.appendTcDetail(e.toString());
    }
    tr15.writeTo(writer);

    /* TestCase: V2SigTestsEnv_GenericPortlet_SIGRender_hasGetDefaultNamespaceReturns */
    /* Details: "GenericPortlet method getDefaultNamespace() returns */
    /* String " */
    TestResult tr16 = tcd
        .getTestResultFailed(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETDEFAULTNAMESPACERETURNS);
    try {
      String name = "getDefaultNamespace";
      Class<?> retType = String.class;
      Class<?>[] parms = null;
      tr16.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr16.appendTcDetail(e.toString());
    }
    tr16.writeTo(writer);

    /* TestCase: V2SigTestsEnv_GenericPortlet_SIGRender_hasGetInitParameter */
    /* Details: "GenericPortlet has a getInitParameter(String)  method " */
    TestResult tr17 =
        tcd.getTestResultFailed(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETINITPARAMETER);
    try {
      String name = "getInitParameter";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {String.class};
      tr17.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr17.appendTcDetail(e.toString());
    }
    tr17.writeTo(writer);

    /* TestCase: V2SigTestsEnv_GenericPortlet_SIGRender_hasGetInitParameterNames */
    /* Details: "GenericPortlet has a getInitParameterNames()  method " */
    TestResult tr18 =
        tcd.getTestResultFailed(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETINITPARAMETERNAMES);
    try {
      String name = "getInitParameterNames";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr18.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr18.appendTcDetail(e.toString());
    }
    tr18.writeTo(writer);

    /* TestCase: V2SigTestsEnv_GenericPortlet_SIGRender_hasGetInitParameterNamesReturns */
    /* Details: "GenericPortlet method getInitParameterNames() returns */
    /* java.util.Enumeration " */
    TestResult tr19 = tcd.getTestResultFailed(
        V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETINITPARAMETERNAMESRETURNS);
    try {
      String name = "getInitParameterNames";
      Class<?> retType = java.util.Enumeration.class;
      Class<?>[] parms = null;
      tr19.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr19.appendTcDetail(e.toString());
    }
    tr19.writeTo(writer);

    /* TestCase: V2SigTestsEnv_GenericPortlet_SIGRender_hasGetInitParameterReturns */
    /* Details: "GenericPortlet method getInitParameter(String) returns */
    /* String " */
    TestResult tr20 =
        tcd.getTestResultFailed(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETINITPARAMETERRETURNS);
    try {
      String name = "getInitParameter";
      Class<?> retType = String.class;
      Class<?>[] parms = {String.class};
      tr20.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr20.appendTcDetail(e.toString());
    }
    tr20.writeTo(writer);

    /* TestCase: V2SigTestsEnv_GenericPortlet_SIGRender_hasGetNextPossiblePortletModes */
    /* Details: "GenericPortlet has a */
    /* getNextPossiblePortletModes(RenderRequest) method " */
    TestResult tr21 = tcd
        .getTestResultFailed(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETNEXTPOSSIBLEPORTLETMODES);
    try {
      String name = "getNextPossiblePortletModes";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {RenderRequest.class};
      tr21.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr21.appendTcDetail(e.toString());
    }
    tr21.writeTo(writer);

    /* TestCase: V2SigTestsEnv_GenericPortlet_SIGRender_hasGetNextPossiblePortletModesReturns */
    /* Details: "GenericPortlet method */
    /* getNextPossiblePortletModes(RenderRequest) returns */
    /* java.util.Collection " */
    TestResult tr22 = tcd.getTestResultFailed(
        V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETNEXTPOSSIBLEPORTLETMODESRETURNS);
    try {
      String name = "getNextPossiblePortletModes";
      Class<?> retType = java.util.Collection.class;
      Class<?>[] parms = {RenderRequest.class};
      tr22.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr22.appendTcDetail(e.toString());
    }
    tr22.writeTo(writer);

    /* TestCase: V2SigTestsEnv_GenericPortlet_SIGRender_hasGetPortletConfig */
    /* Details: "GenericPortlet has a getPortletConfig()  method " */
    TestResult tr23 =
        tcd.getTestResultFailed(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETPORTLETCONFIG);
    try {
      String name = "getPortletConfig";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr23.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr23.appendTcDetail(e.toString());
    }
    tr23.writeTo(writer);

    /* TestCase: V2SigTestsEnv_GenericPortlet_SIGRender_hasGetPortletConfigReturns */
    /* Details: "GenericPortlet method getPortletConfig() returns */
    /* PortletConfig " */
    TestResult tr24 =
        tcd.getTestResultFailed(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETPORTLETCONFIGRETURNS);
    try {
      String name = "getPortletConfig";
      Class<?> retType = PortletConfig.class;
      Class<?>[] parms = null;
      tr24.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr24.appendTcDetail(e.toString());
    }
    tr24.writeTo(writer);

    /* TestCase: V2SigTestsEnv_GenericPortlet_SIGRender_hasGetPortletContext */
    /* Details: "GenericPortlet has a getPortletContext()  method " */
    TestResult tr25 =
        tcd.getTestResultFailed(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETPORTLETCONTEXT);
    try {
      String name = "getPortletContext";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr25.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr25.appendTcDetail(e.toString());
    }
    tr25.writeTo(writer);

    /* TestCase: V2SigTestsEnv_GenericPortlet_SIGRender_hasGetPortletContextReturns */
    /* Details: "GenericPortlet method getPortletContext() returns */
    /* PortletContext " */
    TestResult tr26 =
        tcd.getTestResultFailed(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETPORTLETCONTEXTRETURNS);
    try {
      String name = "getPortletContext";
      Class<?> retType = PortletContext.class;
      Class<?>[] parms = null;
      tr26.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr26.appendTcDetail(e.toString());
    }
    tr26.writeTo(writer);

    /* TestCase: V2SigTestsEnv_GenericPortlet_SIGRender_hasGetPortletName */
    /* Details: "GenericPortlet has a getPortletName()  method " */
    TestResult tr27 =
        tcd.getTestResultFailed(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETPORTLETNAME);
    try {
      String name = "getPortletName";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr27.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr27.appendTcDetail(e.toString());
    }
    tr27.writeTo(writer);

    /* TestCase: V2SigTestsEnv_GenericPortlet_SIGRender_hasGetPortletNameReturns */
    /* Details: "GenericPortlet method getPortletName() returns String " */
    TestResult tr28 =
        tcd.getTestResultFailed(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETPORTLETNAMERETURNS);
    try {
      String name = "getPortletName";
      Class<?> retType = String.class;
      Class<?>[] parms = null;
      tr28.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr28.appendTcDetail(e.toString());
    }
    tr28.writeTo(writer);

    /* TestCase: V2SigTestsEnv_GenericPortlet_SIGRender_hasGetProcessingEventQNames */
    /* Details: "GenericPortlet has a getProcessingEventQNames() method */
    /* " */
    TestResult tr29 =
        tcd.getTestResultFailed(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETPROCESSINGEVENTQNAMES);
    try {
      String name = "getProcessingEventQNames";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr29.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr29.appendTcDetail(e.toString());
    }
    tr29.writeTo(writer);

    /* TestCase: V2SigTestsEnv_GenericPortlet_SIGRender_hasGetProcessingEventQNamesReturns */
    /* Details: "GenericPortlet method getProcessingEventQNames() returns */
    /* java.util.Enumeration " */
    TestResult tr30 = tcd.getTestResultFailed(
        V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETPROCESSINGEVENTQNAMESRETURNS);
    try {
      String name = "getProcessingEventQNames";
      Class<?> retType = java.util.Enumeration.class;
      Class<?>[] parms = null;
      tr30.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr30.appendTcDetail(e.toString());
    }
    tr30.writeTo(writer);

    /* TestCase: V2SigTestsEnv_GenericPortlet_SIGRender_hasGetPublicRenderParameterNames */
    /* Details: "GenericPortlet has a getPublicRenderParameterNames() */
    /* method " */
    TestResult tr31 = tcd.getTestResultFailed(
        V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETPUBLICRENDERPARAMETERNAMES);
    try {
      String name = "getPublicRenderParameterNames";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr31.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr31.appendTcDetail(e.toString());
    }
    tr31.writeTo(writer);

    /* TestCase: V2SigTestsEnv_GenericPortlet_SIGRender_hasGetPublicRenderParameterNamesReturns */
    /* Details: "GenericPortlet method getPublicRenderParameterNames() */
    /* returns java.util.Enumeration " */
    TestResult tr32 = tcd.getTestResultFailed(
        V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETPUBLICRENDERPARAMETERNAMESRETURNS);
    try {
      String name = "getPublicRenderParameterNames";
      Class<?> retType = java.util.Enumeration.class;
      Class<?>[] parms = null;
      tr32.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr32.appendTcDetail(e.toString());
    }
    tr32.writeTo(writer);

    /* TestCase: V2SigTestsEnv_GenericPortlet_SIGRender_hasGetPublishingEventQNames */
    /* Details: "GenericPortlet has a getPublishingEventQNames() method */
    /* " */
    TestResult tr33 =
        tcd.getTestResultFailed(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETPUBLISHINGEVENTQNAMES);
    try {
      String name = "getPublishingEventQNames";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr33.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr33.appendTcDetail(e.toString());
    }
    tr33.writeTo(writer);

    /* TestCase: V2SigTestsEnv_GenericPortlet_SIGRender_hasGetPublishingEventQNamesReturns */
    /* Details: "GenericPortlet method getPublishingEventQNames() returns */
    /* java.util.Enumeration " */
    TestResult tr34 = tcd.getTestResultFailed(
        V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETPUBLISHINGEVENTQNAMESRETURNS);
    try {
      String name = "getPublishingEventQNames";
      Class<?> retType = java.util.Enumeration.class;
      Class<?>[] parms = null;
      tr34.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr34.appendTcDetail(e.toString());
    }
    tr34.writeTo(writer);

    /* TestCase: V2SigTestsEnv_GenericPortlet_SIGRender_hasGetResourceBundle */
    /* Details: "GenericPortlet has a getResourceBundle(java.util.Locale) */
    /* method " */
    TestResult tr35 =
        tcd.getTestResultFailed(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETRESOURCEBUNDLE);
    try {
      String name = "getResourceBundle";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {java.util.Locale.class};
      tr35.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr35.appendTcDetail(e.toString());
    }
    tr35.writeTo(writer);

    /* TestCase: V2SigTestsEnv_GenericPortlet_SIGRender_hasGetResourceBundleReturns */
    /* Details: "GenericPortlet method */
    /* getResourceBundle(java.util.Locale) returns */
    /* java.util.ResourceBundle " */
    TestResult tr36 =
        tcd.getTestResultFailed(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETRESOURCEBUNDLERETURNS);
    try {
      String name = "getResourceBundle";
      Class<?> retType = java.util.ResourceBundle.class;
      Class<?>[] parms = {java.util.Locale.class};
      tr36.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr36.appendTcDetail(e.toString());
    }
    tr36.writeTo(writer);

    /* TestCase: V2SigTestsEnv_GenericPortlet_SIGRender_hasGetSupportedLocales */
    /* Details: "GenericPortlet has a getSupportedLocales()  method " */
    TestResult tr37 =
        tcd.getTestResultFailed(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETSUPPORTEDLOCALES);
    try {
      String name = "getSupportedLocales";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr37.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr37.appendTcDetail(e.toString());
    }
    tr37.writeTo(writer);

    /* TestCase: V2SigTestsEnv_GenericPortlet_SIGRender_hasGetSupportedLocalesReturns */
    /* Details: "GenericPortlet method getSupportedLocales() returns */
    /* java.util.Enumeration " */
    TestResult tr38 = tcd
        .getTestResultFailed(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETSUPPORTEDLOCALESRETURNS);
    try {
      String name = "getSupportedLocales";
      Class<?> retType = java.util.Enumeration.class;
      Class<?>[] parms = null;
      tr38.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr38.appendTcDetail(e.toString());
    }
    tr38.writeTo(writer);

    /* TestCase: V2SigTestsEnv_GenericPortlet_SIGRender_hasGetTitle */
    /* Details: "GenericPortlet has a getTitle(RenderRequest)  method " */
    TestResult tr39 = tcd.getTestResultFailed(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETTITLE);
    try {
      String name = "getTitle";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {RenderRequest.class};
      tr39.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr39.appendTcDetail(e.toString());
    }
    tr39.writeTo(writer);

    /* TestCase: V2SigTestsEnv_GenericPortlet_SIGRender_hasGetTitleReturns */
    /* Details: "GenericPortlet method getTitle(RenderRequest) returns */
    /* String " */
    TestResult tr40 =
        tcd.getTestResultFailed(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETTITLERETURNS);
    try {
      String name = "getTitle";
      Class<?> retType = String.class;
      Class<?>[] parms = {RenderRequest.class};
      tr40.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr40.appendTcDetail(e.toString());
    }
    tr40.writeTo(writer);

    /* TestCase: V2SigTestsEnv_GenericPortlet_SIGRender_hasInit */
    /* Details: "GenericPortlet has a init(PortletConfig) throws */
    /* PortletException method " */
    TestResult tr41 = tcd.getTestResultFailed(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASINIT);
    try {
      String name = "init";
      Class<?>[] exceptions = {PortletException.class};
      Class<?>[] parms = {PortletConfig.class};
      tr41.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr41.appendTcDetail(e.toString());
    }
    tr41.writeTo(writer);

    /* TestCase: V2SigTestsEnv_GenericPortlet_SIGRender_hasInitA */
    /* Details: "GenericPortlet has a init() throws PortletException */
    /* method " */
    TestResult tr42 = tcd.getTestResultFailed(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASINITA);
    try {
      String name = "init";
      Class<?>[] exceptions = {PortletException.class};
      Class<?>[] parms = null;
      tr42.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr42.appendTcDetail(e.toString());
    }
    tr42.writeTo(writer);

    /* TestCase: V2SigTestsEnv_GenericPortlet_SIGRender_hasInitReturns */
    /* Details: "GenericPortlet method init(PortletConfig) returns void " */
    TestResult tr43 =
        tcd.getTestResultFailed(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASINITRETURNS);
    try {
      String name = "init";
      Class<?> retType = void.class;
      Class<?>[] parms = {PortletConfig.class};
      tr43.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr43.appendTcDetail(e.toString());
    }
    tr43.writeTo(writer);

    /* TestCase: V2SigTestsEnv_GenericPortlet_SIGRender_hasInitReturnsA */
    /* Details: "GenericPortlet method init() returns void " */
    TestResult tr44 =
        tcd.getTestResultFailed(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASINITRETURNSA);
    try {
      String name = "init";
      Class<?> retType = void.class;
      Class<?>[] parms = null;
      tr44.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr44.appendTcDetail(e.toString());
    }
    tr44.writeTo(writer);

    /* TestCase: V2SigTestsEnv_GenericPortlet_SIGRender_hasProcessAction */
    /* Details: "GenericPortlet has a processAction(ActionRequest, */
    /* ActionResponse) throws PortletException, java.io.IOException */
    /* method " */
    TestResult tr45 =
        tcd.getTestResultFailed(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASPROCESSACTION);
    try {
      String name = "processAction";
      Class<?>[] exceptions = {PortletException.class, java.io.IOException.class};
      Class<?>[] parms = {ActionRequest.class, ActionResponse.class};
      tr45.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr45.appendTcDetail(e.toString());
    }
    tr45.writeTo(writer);

    /* TestCase: V2SigTestsEnv_GenericPortlet_SIGRender_hasProcessActionReturns */
    /* Details: "GenericPortlet method processAction(ActionRequest, */
    /* ActionResponse) returns void " */
    TestResult tr46 =
        tcd.getTestResultFailed(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASPROCESSACTIONRETURNS);
    try {
      String name = "processAction";
      Class<?> retType = void.class;
      Class<?>[] parms = {ActionRequest.class, ActionResponse.class};
      tr46.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr46.appendTcDetail(e.toString());
    }
    tr46.writeTo(writer);

    /* TestCase: V2SigTestsEnv_GenericPortlet_SIGRender_hasProcessEvent */
    /* Details: "GenericPortlet has a processEvent(EventRequest, */
    /* EventResponse) throws PortletException, java.io.IOException method */
    /* " */
    TestResult tr47 =
        tcd.getTestResultFailed(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASPROCESSEVENT);
    try {
      String name = "processEvent";
      Class<?>[] exceptions = {PortletException.class, java.io.IOException.class};
      Class<?>[] parms = {EventRequest.class, EventResponse.class};
      tr47.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr47.appendTcDetail(e.toString());
    }
    tr47.writeTo(writer);

    /* TestCase: V2SigTestsEnv_GenericPortlet_SIGRender_hasProcessEventReturns */
    /* Details: "GenericPortlet method processEvent(EventRequest, */
    /* EventResponse) returns void " */
    TestResult tr48 =
        tcd.getTestResultFailed(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASPROCESSEVENTRETURNS);
    try {
      String name = "processEvent";
      Class<?> retType = void.class;
      Class<?>[] parms = {EventRequest.class, EventResponse.class};
      tr48.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr48.appendTcDetail(e.toString());
    }
    tr48.writeTo(writer);

    /* TestCase: V2SigTestsEnv_GenericPortlet_SIGRender_hasRender */
    /* Details: "GenericPortlet has a render(RenderRequest, */
    /* RenderResponse) throws PortletException, java.io.IOException */
    /* method " */
    TestResult tr49 = tcd.getTestResultFailed(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASRENDER);
    try {
      String name = "render";
      Class<?>[] exceptions = {PortletException.class, java.io.IOException.class};
      Class<?>[] parms = {RenderRequest.class, RenderResponse.class};
      tr49.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr49.appendTcDetail(e.toString());
    }
    tr49.writeTo(writer);

    /* TestCase: V2SigTestsEnv_GenericPortlet_SIGRender_hasRenderReturns */
    /* Details: "GenericPortlet method render(RenderRequest, */
    /* RenderResponse) returns void " */
    TestResult tr50 =
        tcd.getTestResultFailed(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASRENDERRETURNS);
    try {
      String name = "render";
      Class<?> retType = void.class;
      Class<?>[] parms = {RenderRequest.class, RenderResponse.class};
      tr50.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr50.appendTcDetail(e.toString());
    }
    tr50.writeTo(writer);

    /* TestCase: V2SigTestsEnv_GenericPortlet_SIGRender_hasServeResource */
    /* Details: "GenericPortlet has a serveResource(ResourceRequest, */
    /* ResourceResponse) throws PortletException, java.io.IOException */
    /* method " */
    TestResult tr51 =
        tcd.getTestResultFailed(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASSERVERESOURCE);
    try {
      String name = "serveResource";
      Class<?>[] exceptions = {PortletException.class, java.io.IOException.class};
      Class<?>[] parms = {ResourceRequest.class, ResourceResponse.class};
      tr51.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr51.appendTcDetail(e.toString());
    }
    tr51.writeTo(writer);

    /* TestCase: V2SigTestsEnv_GenericPortlet_SIGRender_hasServeResourceReturns */
    /* Details: "GenericPortlet method serveResource(ResourceRequest, */
    /* ResourceResponse) returns void " */
    TestResult tr52 =
        tcd.getTestResultFailed(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASSERVERESOURCERETURNS);
    try {
      String name = "serveResource";
      Class<?> retType = void.class;
      Class<?>[] parms = {ResourceRequest.class, ResourceResponse.class};
      tr52.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr52.appendTcDetail(e.toString());
    }
    tr52.writeTo(writer);

    /* TestCase: V2SigTestsEnv_GenericPortlet_SIGRender_implementsEventPortlet */
    /* Details: "GenericPortlet implements EventPortlet " */
    TestResult tr53 =
        tcd.getTestResultFailed(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_IMPLEMENTSEVENTPORTLET);
    try {
      tr53.setTcSuccess(cc.implementsInterface(EventPortlet.class));
    } catch (Exception e) {
      tr53.appendTcDetail(e.toString());
    }
    tr53.writeTo(writer);

    /* TestCase: V2SigTestsEnv_GenericPortlet_SIGRender_implementsPortlet */
    /* Details: "GenericPortlet implements Portlet " */
    TestResult tr54 =
        tcd.getTestResultFailed(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_IMPLEMENTSPORTLET);
    try {
      tr54.setTcSuccess(cc.implementsInterface(Portlet.class));
    } catch (Exception e) {
      tr54.appendTcDetail(e.toString());
    }
    tr54.writeTo(writer);

    /* TestCase: V2SigTestsEnv_GenericPortlet_SIGRender_implementsPortletConfig */
    /* Details: "GenericPortlet implements PortletConfig " */
    TestResult tr55 =
        tcd.getTestResultFailed(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_IMPLEMENTSPORTLETCONFIG);
    try {
      tr55.setTcSuccess(cc.implementsInterface(PortletConfig.class));
    } catch (Exception e) {
      tr55.appendTcDetail(e.toString());
    }
    tr55.writeTo(writer);

    /* TestCase: V2SigTestsEnv_GenericPortlet_SIGRender_implementsResourceServingPortlet */
    /* Details: "GenericPortlet implements ResourceServingPortlet " */
    TestResult tr56 = tcd.getTestResultFailed(
        V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_IMPLEMENTSRESOURCESERVINGPORTLET);
    try {
      tr56.setTcSuccess(cc.implementsInterface(ResourceServingPortlet.class));
    } catch (Exception e) {
      tr56.appendTcDetail(e.toString());
    }
    tr56.writeTo(writer);

  }

}
