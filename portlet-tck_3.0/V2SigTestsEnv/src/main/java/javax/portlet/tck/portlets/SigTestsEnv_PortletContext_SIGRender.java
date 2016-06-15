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
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.tck.beans.ClassChecker;
import javax.portlet.tck.beans.JSR286SignatureTestCaseDetails;
import javax.portlet.tck.beans.TestResult;

import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETATTRIBUTE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETATTRIBUTENAMES;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETATTRIBUTENAMESRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETATTRIBUTERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETCONTAINERRUNTIMEOPTIONS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETCONTAINERRUNTIMEOPTIONSRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETINITPARAMETER;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETINITPARAMETERNAMES;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETINITPARAMETERNAMESRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETINITPARAMETERRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETMAJORVERSION;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETMAJORVERSIONRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETMIMETYPE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETMIMETYPERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETMINORVERSION;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETMINORVERSIONRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETNAMEDDISPATCHER;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETNAMEDDISPATCHERRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETPORTLETCONTEXTNAME;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETPORTLETCONTEXTNAMERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETREALPATH;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETREALPATHRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETREQUESTDISPATCHER;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETREQUESTDISPATCHERRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETRESOURCE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETRESOURCEASSTREAM;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETRESOURCEASSTREAMRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETRESOURCEPATHS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETRESOURCEPATHSRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETRESOURCERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETSERVERINFO;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETSERVERINFORETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASLOG;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASLOGA;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASLOGRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASLOGRETURNSA;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASREMOVEATTRIBUTE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASREMOVEATTRIBUTERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASSETATTRIBUTE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASSETATTRIBUTERETURNS;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined
 * in the /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate
 * the test case names defined in the additionalTCs.xml file into the complete list of test case
 * names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will
 * initiate the events, but not process them. The processing is done in the companion portlet
 * SigTestsEnv_PortletContext_SIGRender_event
 *
 */
public class SigTestsEnv_PortletContext_SIGRender implements Portlet {

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

    ClassChecker cc = new ClassChecker(portletConfig.getPortletContext().getClass());

    /* TestCase: V2SigTestsEnv_PortletContext_SIGRender_hasGetAttribute */
    /* Details: "PortletContext has a getAttribute(String)  method " */
    TestResult tr0 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETATTRIBUTE);
    try {
      String name = "getAttribute";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {String.class};
      tr0.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr0.appendTcDetail(e.toString());
    }
    tr0.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletContext_SIGRender_hasGetAttributeNames */
    /* Details: "PortletContext has a getAttributeNames()  method " */
    TestResult tr1 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETATTRIBUTENAMES);
    try {
      String name = "getAttributeNames";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr1.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr1.appendTcDetail(e.toString());
    }
    tr1.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletContext_SIGRender_hasGetAttributeNamesReturns */
    /* Details: "PortletContext method getAttributeNames() returns */
    /* java.util.Enumeration " */
    TestResult tr2 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETATTRIBUTENAMESRETURNS);
    try {
      String name = "getAttributeNames";
      Class<?> retType = java.util.Enumeration.class;
      Class<?>[] parms = null;
      tr2.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr2.appendTcDetail(e.toString());
    }
    tr2.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletContext_SIGRender_hasGetAttributeReturns */
    /* Details: "PortletContext method getAttribute(String) returns */
    /* Object " */
    TestResult tr3 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETATTRIBUTERETURNS);
    try {
      String name = "getAttribute";
      Class<?> retType = Object.class;
      Class<?>[] parms = {String.class};
      tr3.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr3.appendTcDetail(e.toString());
    }
    tr3.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletContext_SIGRender_hasGetContainerRuntimeOptions */
    /* Details: "PortletContext has a getContainerRuntimeOptions() */
    /* method " */
    TestResult tr4 = tcd
        .getTestResultFailed(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETCONTAINERRUNTIMEOPTIONS);
    try {
      String name = "getContainerRuntimeOptions";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr4.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr4.appendTcDetail(e.toString());
    }
    tr4.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletContext_SIGRender_hasGetContainerRuntimeOptionsReturns */
    /* Details: "PortletContext method getContainerRuntimeOptions() */
    /* returns java.util.Enumeration " */
    TestResult tr5 = tcd.getTestResultFailed(
        V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETCONTAINERRUNTIMEOPTIONSRETURNS);
    try {
      String name = "getContainerRuntimeOptions";
      Class<?> retType = java.util.Enumeration.class;
      Class<?>[] parms = null;
      tr5.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr5.appendTcDetail(e.toString());
    }
    tr5.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletContext_SIGRender_hasGetInitParameter */
    /* Details: "PortletContext has a getInitParameter(String)  method " */
    TestResult tr6 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETINITPARAMETER);
    try {
      String name = "getInitParameter";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {String.class};
      tr6.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr6.appendTcDetail(e.toString());
    }
    tr6.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletContext_SIGRender_hasGetInitParameterNames */
    /* Details: "PortletContext has a getInitParameterNames()  method " */
    TestResult tr7 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETINITPARAMETERNAMES);
    try {
      String name = "getInitParameterNames";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr7.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr7.appendTcDetail(e.toString());
    }
    tr7.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletContext_SIGRender_hasGetInitParameterNamesReturns */
    /* Details: "PortletContext method getInitParameterNames() returns */
    /* java.util.Enumeration " */
    TestResult tr8 = tcd.getTestResultFailed(
        V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETINITPARAMETERNAMESRETURNS);
    try {
      String name = "getInitParameterNames";
      Class<?> retType = java.util.Enumeration.class;
      Class<?>[] parms = null;
      tr8.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr8.appendTcDetail(e.toString());
    }
    tr8.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletContext_SIGRender_hasGetInitParameterReturns */
    /* Details: "PortletContext method getInitParameter(String) returns */
    /* String " */
    TestResult tr9 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETINITPARAMETERRETURNS);
    try {
      String name = "getInitParameter";
      Class<?> retType = String.class;
      Class<?>[] parms = {String.class};
      tr9.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr9.appendTcDetail(e.toString());
    }
    tr9.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletContext_SIGRender_hasGetMajorVersion */
    /* Details: "PortletContext has a getMajorVersion()  method " */
    TestResult tr10 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETMAJORVERSION);
    try {
      String name = "getMajorVersion";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr10.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr10.appendTcDetail(e.toString());
    }
    tr10.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletContext_SIGRender_hasGetMajorVersionReturns */
    /* Details: "PortletContext method getMajorVersion() returns int " */
    TestResult tr11 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETMAJORVERSIONRETURNS);
    try {
      String name = "getMajorVersion";
      Class<?> retType = int.class;
      Class<?>[] parms = null;
      tr11.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr11.appendTcDetail(e.toString());
    }
    tr11.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletContext_SIGRender_hasGetMimeType */
    /* Details: "PortletContext has a getMimeType(String)  method " */
    TestResult tr12 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETMIMETYPE);
    try {
      String name = "getMimeType";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {String.class};
      tr12.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr12.appendTcDetail(e.toString());
    }
    tr12.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletContext_SIGRender_hasGetMimeTypeReturns */
    /* Details: "PortletContext method getMimeType(String) returns String */
    /* " */
    TestResult tr13 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETMIMETYPERETURNS);
    try {
      String name = "getMimeType";
      Class<?> retType = String.class;
      Class<?>[] parms = {String.class};
      tr13.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr13.appendTcDetail(e.toString());
    }
    tr13.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletContext_SIGRender_hasGetMinorVersion */
    /* Details: "PortletContext has a getMinorVersion()  method " */
    TestResult tr14 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETMINORVERSION);
    try {
      String name = "getMinorVersion";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr14.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr14.appendTcDetail(e.toString());
    }
    tr14.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletContext_SIGRender_hasGetMinorVersionReturns */
    /* Details: "PortletContext method getMinorVersion() returns int " */
    TestResult tr15 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETMINORVERSIONRETURNS);
    try {
      String name = "getMinorVersion";
      Class<?> retType = int.class;
      Class<?>[] parms = null;
      tr15.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr15.appendTcDetail(e.toString());
    }
    tr15.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletContext_SIGRender_hasGetNamedDispatcher */
    /* Details: "PortletContext has a getNamedDispatcher(String) method */
    /* " */
    TestResult tr16 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETNAMEDDISPATCHER);
    try {
      String name = "getNamedDispatcher";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {String.class};
      tr16.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr16.appendTcDetail(e.toString());
    }
    tr16.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletContext_SIGRender_hasGetNamedDispatcherReturns */
    /* Details: "PortletContext method getNamedDispatcher(String) returns */
    /* PortletRequestDispatcher " */
    TestResult tr17 = tcd
        .getTestResultFailed(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETNAMEDDISPATCHERRETURNS);
    try {
      String name = "getNamedDispatcher";
      Class<?> retType = PortletRequestDispatcher.class;
      Class<?>[] parms = {String.class};
      tr17.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr17.appendTcDetail(e.toString());
    }
    tr17.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletContext_SIGRender_hasGetPortletContextName */
    /* Details: "PortletContext has a getPortletContextName()  method " */
    TestResult tr18 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETPORTLETCONTEXTNAME);
    try {
      String name = "getPortletContextName";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr18.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr18.appendTcDetail(e.toString());
    }
    tr18.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletContext_SIGRender_hasGetPortletContextNameReturns */
    /* Details: "PortletContext method getPortletContextName() returns */
    /* String " */
    TestResult tr19 = tcd.getTestResultFailed(
        V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETPORTLETCONTEXTNAMERETURNS);
    try {
      String name = "getPortletContextName";
      Class<?> retType = String.class;
      Class<?>[] parms = null;
      tr19.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr19.appendTcDetail(e.toString());
    }
    tr19.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletContext_SIGRender_hasGetRealPath */
    /* Details: "PortletContext has a getRealPath(String)  method " */
    TestResult tr20 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETREALPATH);
    try {
      String name = "getRealPath";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {String.class};
      tr20.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr20.appendTcDetail(e.toString());
    }
    tr20.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletContext_SIGRender_hasGetRealPathReturns */
    /* Details: "PortletContext method getRealPath(String) returns String */
    /* " */
    TestResult tr21 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETREALPATHRETURNS);
    try {
      String name = "getRealPath";
      Class<?> retType = String.class;
      Class<?>[] parms = {String.class};
      tr21.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr21.appendTcDetail(e.toString());
    }
    tr21.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletContext_SIGRender_hasGetRequestDispatcher */
    /* Details: "PortletContext has a getRequestDispatcher(String) */
    /* method " */
    TestResult tr22 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETREQUESTDISPATCHER);
    try {
      String name = "getRequestDispatcher";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {String.class};
      tr22.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr22.appendTcDetail(e.toString());
    }
    tr22.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletContext_SIGRender_hasGetRequestDispatcherReturns */
    /* Details: "PortletContext method getRequestDispatcher(String) */
    /* returns PortletRequestDispatcher " */
    TestResult tr23 = tcd
        .getTestResultFailed(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETREQUESTDISPATCHERRETURNS);
    try {
      String name = "getRequestDispatcher";
      Class<?> retType = PortletRequestDispatcher.class;
      Class<?>[] parms = {String.class};
      tr23.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr23.appendTcDetail(e.toString());
    }
    tr23.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletContext_SIGRender_hasGetResource */
    /* Details: "PortletContext has a getResource(String) throws */
    /* java.net.MalformedURLException method " */
    TestResult tr24 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETRESOURCE);
    try {
      String name = "getResource";
      Class<?>[] exceptions = {java.net.MalformedURLException.class};
      Class<?>[] parms = {String.class};
      tr24.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr24.appendTcDetail(e.toString());
    }
    tr24.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletContext_SIGRender_hasGetResourceAsStream */
    /* Details: "PortletContext has a getResourceAsStream(String) method */
    /* " */
    TestResult tr25 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETRESOURCEASSTREAM);
    try {
      String name = "getResourceAsStream";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {String.class};
      tr25.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr25.appendTcDetail(e.toString());
    }
    tr25.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletContext_SIGRender_hasGetResourceAsStreamReturns */
    /* Details: "PortletContext method getResourceAsStream(String) */
    /* returns java.io.InputStream " */
    TestResult tr26 = tcd
        .getTestResultFailed(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETRESOURCEASSTREAMRETURNS);
    try {
      String name = "getResourceAsStream";
      Class<?> retType = java.io.InputStream.class;
      Class<?>[] parms = {String.class};
      tr26.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr26.appendTcDetail(e.toString());
    }
    tr26.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletContext_SIGRender_hasGetResourcePaths */
    /* Details: "PortletContext has a getResourcePaths(String)  method " */
    TestResult tr27 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETRESOURCEPATHS);
    try {
      String name = "getResourcePaths";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {String.class};
      tr27.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr27.appendTcDetail(e.toString());
    }
    tr27.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletContext_SIGRender_hasGetResourcePathsReturns */
    /* Details: "PortletContext method getResourcePaths(String) returns */
    /* java.util.Set " */
    TestResult tr28 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETRESOURCEPATHSRETURNS);
    try {
      String name = "getResourcePaths";
      Class<?> retType = java.util.Set.class;
      Class<?>[] parms = {String.class};
      tr28.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr28.appendTcDetail(e.toString());
    }
    tr28.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletContext_SIGRender_hasGetResourceReturns */
    /* Details: "PortletContext method getResource(String) returns */
    /* java.net.URL " */
    TestResult tr29 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETRESOURCERETURNS);
    try {
      String name = "getResource";
      Class<?> retType = java.net.URL.class;
      Class<?>[] parms = {String.class};
      tr29.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr29.appendTcDetail(e.toString());
    }
    tr29.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletContext_SIGRender_hasGetServerInfo */
    /* Details: "PortletContext has a getServerInfo()  method " */
    TestResult tr30 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETSERVERINFO);
    try {
      String name = "getServerInfo";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr30.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr30.appendTcDetail(e.toString());
    }
    tr30.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletContext_SIGRender_hasGetServerInfoReturns */
    /* Details: "PortletContext method getServerInfo() returns String " */
    TestResult tr31 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETSERVERINFORETURNS);
    try {
      String name = "getServerInfo";
      Class<?> retType = String.class;
      Class<?>[] parms = null;
      tr31.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr31.appendTcDetail(e.toString());
    }
    tr31.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletContext_SIGRender_hasLog */
    /* Details: "PortletContext has a log(String)  method " */
    TestResult tr32 = tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASLOG);
    try {
      String name = "log";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {String.class};
      tr32.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr32.appendTcDetail(e.toString());
    }
    tr32.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletContext_SIGRender_hasLogA */
    /* Details: "PortletContext has a log(String, Throwable)  method " */
    TestResult tr33 = tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASLOGA);
    try {
      String name = "log";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {String.class, Throwable.class};
      tr33.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr33.appendTcDetail(e.toString());
    }
    tr33.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletContext_SIGRender_hasLogReturns */
    /* Details: "PortletContext method log(String) returns void " */
    TestResult tr34 = tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASLOGRETURNS);
    try {
      String name = "log";
      Class<?> retType = void.class;
      Class<?>[] parms = {String.class};
      tr34.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr34.appendTcDetail(e.toString());
    }
    tr34.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletContext_SIGRender_hasLogReturnsA */
    /* Details: "PortletContext method log(String, Throwable) returns */
    /* void " */
    TestResult tr35 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASLOGRETURNSA);
    try {
      String name = "log";
      Class<?> retType = void.class;
      Class<?>[] parms = {String.class, Throwable.class};
      tr35.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr35.appendTcDetail(e.toString());
    }
    tr35.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletContext_SIGRender_hasRemoveAttribute */
    /* Details: "PortletContext has a removeAttribute(String)  method " */
    TestResult tr36 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASREMOVEATTRIBUTE);
    try {
      String name = "removeAttribute";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {String.class};
      tr36.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr36.appendTcDetail(e.toString());
    }
    tr36.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletContext_SIGRender_hasRemoveAttributeReturns */
    /* Details: "PortletContext method removeAttribute(String) returns */
    /* void " */
    TestResult tr37 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASREMOVEATTRIBUTERETURNS);
    try {
      String name = "removeAttribute";
      Class<?> retType = void.class;
      Class<?>[] parms = {String.class};
      tr37.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr37.appendTcDetail(e.toString());
    }
    tr37.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletContext_SIGRender_hasSetAttribute */
    /* Details: "PortletContext has a setAttribute(String, Object) */
    /* method " */
    TestResult tr38 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASSETATTRIBUTE);
    try {
      String name = "setAttribute";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {String.class, Object.class};
      tr38.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr38.appendTcDetail(e.toString());
    }
    tr38.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletContext_SIGRender_hasSetAttributeReturns */
    /* Details: "PortletContext method setAttribute(String, Object) */
    /* returns void " */
    TestResult tr39 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASSETATTRIBUTERETURNS);
    try {
      String name = "setAttribute";
      Class<?> retType = void.class;
      Class<?>[] parms = {String.class, Object.class};
      tr39.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr39.appendTcDetail(e.toString());
    }
    tr39.writeTo(writer);

  }

}
