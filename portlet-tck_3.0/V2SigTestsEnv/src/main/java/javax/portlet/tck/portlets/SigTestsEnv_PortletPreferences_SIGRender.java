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
import javax.portlet.ReadOnlyException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ValidatorException;
import javax.portlet.tck.beans.ClassChecker;
import javax.portlet.tck.beans.JSR286SignatureTestCaseDetails;
import javax.portlet.tck.beans.TestResult;

import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASGETMAP;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASGETMAPRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASGETNAMES;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASGETNAMESRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASGETVALUE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASGETVALUERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASGETVALUES;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASGETVALUESRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASISREADONLY;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASISREADONLYRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASRESET;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASRESETRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASSETVALUE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASSETVALUERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASSETVALUES;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASSETVALUESRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASSTORE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASSTORERETURNS;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined
 * in the /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate
 * the test case names defined in the additionalTCs.xml file into the complete list of test case
 * names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will
 * initiate the events, but not process them. The processing is done in the companion portlet
 * SigTestsEnv_PortletPreferences_SIGRender_event
 *
 */
public class SigTestsEnv_PortletPreferences_SIGRender implements Portlet {

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

    ClassChecker cc = new ClassChecker(portletReq.getPreferences().getClass());

    /* TestCase: V2SigTestsEnv_PortletPreferences_SIGRender_hasGetMap */
    /* Details: "PortletPreferences has a getMap()  method " */
    TestResult tr0 = tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASGETMAP);
    try {
      String name = "getMap";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr0.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr0.appendTcDetail(e.toString());
    }
    tr0.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletPreferences_SIGRender_hasGetMapReturns */
    /* Details: "PortletPreferences method getMap() returns java.util.Map */
    /* " */
    TestResult tr1 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASGETMAPRETURNS);
    try {
      String name = "getMap";
      Class<?> retType = java.util.Map.class;
      Class<?>[] parms = null;
      tr1.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr1.appendTcDetail(e.toString());
    }
    tr1.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletPreferences_SIGRender_hasGetNames */
    /* Details: "PortletPreferences has a getNames()  method " */
    TestResult tr2 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASGETNAMES);
    try {
      String name = "getNames";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr2.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr2.appendTcDetail(e.toString());
    }
    tr2.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletPreferences_SIGRender_hasGetNamesReturns */
    /* Details: "PortletPreferences method getNames() returns */
    /* java.util.Enumeration " */
    TestResult tr3 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASGETNAMESRETURNS);
    try {
      String name = "getNames";
      Class<?> retType = java.util.Enumeration.class;
      Class<?>[] parms = null;
      tr3.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr3.appendTcDetail(e.toString());
    }
    tr3.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletPreferences_SIGRender_hasGetValue */
    /* Details: "PortletPreferences has a getValue(String, String) */
    /* method " */
    TestResult tr4 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASGETVALUE);
    try {
      String name = "getValue";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {String.class, String.class};
      tr4.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr4.appendTcDetail(e.toString());
    }
    tr4.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletPreferences_SIGRender_hasGetValueReturns */
    /* Details: "PortletPreferences method getValue(String, String) */
    /* returns String " */
    TestResult tr5 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASGETVALUERETURNS);
    try {
      String name = "getValue";
      Class<?> retType = String.class;
      Class<?>[] parms = {String.class, String.class};
      tr5.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr5.appendTcDetail(e.toString());
    }
    tr5.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletPreferences_SIGRender_hasGetValues */
    /* Details: "PortletPreferences has a getValues(String, String[]) */
    /* method " */
    TestResult tr6 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASGETVALUES);
    try {
      String name = "getValues";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {String.class, String[].class};
      tr6.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr6.appendTcDetail(e.toString());
    }
    tr6.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletPreferences_SIGRender_hasGetValuesReturns */
    /* Details: "PortletPreferences method getValues(String, String[]) */
    /* returns String[] " */
    TestResult tr7 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASGETVALUESRETURNS);
    try {
      String name = "getValues";
      Class<?> retType = String[].class;
      Class<?>[] parms = {String.class, String[].class};
      tr7.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr7.appendTcDetail(e.toString());
    }
    tr7.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletPreferences_SIGRender_hasIsReadOnly */
    /* Details: "PortletPreferences has a isReadOnly(String)  method " */
    TestResult tr8 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASISREADONLY);
    try {
      String name = "isReadOnly";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {String.class};
      tr8.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr8.appendTcDetail(e.toString());
    }
    tr8.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletPreferences_SIGRender_hasIsReadOnlyReturns */
    /* Details: "PortletPreferences method isReadOnly(String) returns */
    /* boolean " */
    TestResult tr9 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASISREADONLYRETURNS);
    try {
      String name = "isReadOnly";
      Class<?> retType = boolean.class;
      Class<?>[] parms = {String.class};
      tr9.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr9.appendTcDetail(e.toString());
    }
    tr9.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletPreferences_SIGRender_hasReset */
    /* Details: "PortletPreferences has a reset(String) throws */
    /* ReadOnlyException method " */
    TestResult tr10 = tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASRESET);
    try {
      String name = "reset";
      Class<?>[] exceptions = {ReadOnlyException.class};
      Class<?>[] parms = {String.class};
      tr10.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr10.appendTcDetail(e.toString());
    }
    tr10.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletPreferences_SIGRender_hasResetReturns */
    /* Details: "PortletPreferences method reset(String) returns void " */
    TestResult tr11 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASRESETRETURNS);
    try {
      String name = "reset";
      Class<?> retType = void.class;
      Class<?>[] parms = {String.class};
      tr11.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr11.appendTcDetail(e.toString());
    }
    tr11.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletPreferences_SIGRender_hasSetValue */
    /* Details: "PortletPreferences has a setValue(String, String) throws */
    /* ReadOnlyException method " */
    TestResult tr12 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASSETVALUE);
    try {
      String name = "setValue";
      Class<?>[] exceptions = {ReadOnlyException.class};
      Class<?>[] parms = {String.class, String.class};
      tr12.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr12.appendTcDetail(e.toString());
    }
    tr12.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletPreferences_SIGRender_hasSetValueReturns */
    /* Details: "PortletPreferences method setValue(String, String) */
    /* returns void " */
    TestResult tr13 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASSETVALUERETURNS);
    try {
      String name = "setValue";
      Class<?> retType = void.class;
      Class<?>[] parms = {String.class, String.class};
      tr13.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr13.appendTcDetail(e.toString());
    }
    tr13.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletPreferences_SIGRender_hasSetValues */
    /* Details: "PortletPreferences has a setValues(String, String[]) */
    /* throws ReadOnlyException method " */
    TestResult tr14 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASSETVALUES);
    try {
      String name = "setValues";
      Class<?>[] exceptions = {ReadOnlyException.class};
      Class<?>[] parms = {String.class, String[].class};
      tr14.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr14.appendTcDetail(e.toString());
    }
    tr14.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletPreferences_SIGRender_hasSetValuesReturns */
    /* Details: "PortletPreferences method setValues(String, String[]) */
    /* returns void " */
    TestResult tr15 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASSETVALUESRETURNS);
    try {
      String name = "setValues";
      Class<?> retType = void.class;
      Class<?>[] parms = {String.class, String[].class};
      tr15.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr15.appendTcDetail(e.toString());
    }
    tr15.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletPreferences_SIGRender_hasStore */
    /* Details: "PortletPreferences has a store() throws */
    /* java.io.IOException, ValidatorException method " */
    TestResult tr16 = tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASSTORE);
    try {
      String name = "store";
      Class<?>[] exceptions = {java.io.IOException.class, ValidatorException.class};
      Class<?>[] parms = null;
      tr16.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr16.appendTcDetail(e.toString());
    }
    tr16.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletPreferences_SIGRender_hasStoreReturns */
    /* Details: "PortletPreferences method store() returns void " */
    TestResult tr17 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASSTORERETURNS);
    try {
      String name = "store";
      Class<?> retType = void.class;
      Class<?>[] parms = null;
      tr17.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr17.appendTcDetail(e.toString());
    }
    tr17.writeTo(writer);

  }

}
