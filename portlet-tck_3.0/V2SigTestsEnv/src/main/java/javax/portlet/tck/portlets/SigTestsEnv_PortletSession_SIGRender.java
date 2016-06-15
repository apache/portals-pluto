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

import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_FIELDAPPLICATION_SCOPE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_FIELDPORTLET_SCOPE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETATTRIBUTE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETATTRIBUTEA;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETATTRIBUTEMAP;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETATTRIBUTEMAPA;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETATTRIBUTEMAPRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETATTRIBUTEMAPRETURNSA;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETATTRIBUTENAMES;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETATTRIBUTENAMESA;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETATTRIBUTENAMESRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETATTRIBUTENAMESRETURNSA;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETATTRIBUTERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETATTRIBUTERETURNSA;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETCREATIONTIME;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETCREATIONTIMERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETID;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETIDRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETLASTACCESSEDTIME;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETLASTACCESSEDTIMERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETMAXINACTIVEINTERVAL;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETMAXINACTIVEINTERVALRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETPORTLETCONTEXT;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETPORTLETCONTEXTRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASINVALIDATE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASINVALIDATERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASISNEW;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASISNEWRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASREMOVEATTRIBUTE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASREMOVEATTRIBUTEA;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASREMOVEATTRIBUTERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASREMOVEATTRIBUTERETURNSA;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASSETATTRIBUTE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASSETATTRIBUTEA;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASSETATTRIBUTERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASSETATTRIBUTERETURNSA;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASSETMAXINACTIVEINTERVAL;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASSETMAXINACTIVEINTERVALRETURNS;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined
 * in the /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate
 * the test case names defined in the additionalTCs.xml file into the complete list of test case
 * names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will
 * initiate the events, but not process them. The processing is done in the companion portlet
 * SigTestsEnv_PortletSession_SIGRender_event
 *
 */
public class SigTestsEnv_PortletSession_SIGRender implements Portlet {

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

    ClassChecker cc = new ClassChecker(portletReq.getPortletSession().getClass());

    /* TestCase: V2SigTestsEnv_PortletSession_SIGRender_fieldAPPLICATION_SCOPE */
    /* Details: "PortletSession has int field APPLICATION_SCOPE " */
    TestResult tr0 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_FIELDAPPLICATION_SCOPE);
    try {
      tr0.setTcSuccess(cc.hasField("APPLICATION_SCOPE"));
    } catch (Exception e) {
      tr0.appendTcDetail(e.toString());
    }
    tr0.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletSession_SIGRender_fieldPORTLET_SCOPE */
    /* Details: "PortletSession has int field PORTLET_SCOPE " */
    TestResult tr1 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_FIELDPORTLET_SCOPE);
    try {
      tr1.setTcSuccess(cc.hasField("PORTLET_SCOPE"));
    } catch (Exception e) {
      tr1.appendTcDetail(e.toString());
    }
    tr1.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletSession_SIGRender_hasGetAttribute */
    /* Details: "PortletSession has a getAttribute(String)  method " */
    TestResult tr2 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETATTRIBUTE);
    try {
      String name = "getAttribute";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {String.class};
      tr2.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr2.appendTcDetail(e.toString());
    }
    tr2.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletSession_SIGRender_hasGetAttributeA */
    /* Details: "PortletSession has a getAttribute(String, int)  method " */
    TestResult tr3 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETATTRIBUTEA);
    try {
      String name = "getAttribute";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {String.class, int.class};
      tr3.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr3.appendTcDetail(e.toString());
    }
    tr3.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletSession_SIGRender_hasGetAttributeMap */
    /* Details: "PortletSession has a getAttributeMap()  method " */
    TestResult tr4 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETATTRIBUTEMAP);
    try {
      String name = "getAttributeMap";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr4.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr4.appendTcDetail(e.toString());
    }
    tr4.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletSession_SIGRender_hasGetAttributeMapA */
    /* Details: "PortletSession has a getAttributeMap(int)  method " */
    TestResult tr5 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETATTRIBUTEMAPA);
    try {
      String name = "getAttributeMap";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {int.class};
      tr5.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr5.appendTcDetail(e.toString());
    }
    tr5.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletSession_SIGRender_hasGetAttributeMapReturns */
    /* Details: "PortletSession method getAttributeMap() returns */
    /* java.util.Map " */
    TestResult tr6 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETATTRIBUTEMAPRETURNS);
    try {
      String name = "getAttributeMap";
      Class<?> retType = java.util.Map.class;
      Class<?>[] parms = null;
      tr6.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr6.appendTcDetail(e.toString());
    }
    tr6.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletSession_SIGRender_hasGetAttributeMapReturnsA */
    /* Details: "PortletSession method getAttributeMap(int) returns */
    /* java.util.Map " */
    TestResult tr7 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETATTRIBUTEMAPRETURNSA);
    try {
      String name = "getAttributeMap";
      Class<?> retType = java.util.Map.class;
      Class<?>[] parms = {int.class};
      tr7.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr7.appendTcDetail(e.toString());
    }
    tr7.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletSession_SIGRender_hasGetAttributeNames */
    /* Details: "PortletSession has a getAttributeNames()  method " */
    TestResult tr8 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETATTRIBUTENAMES);
    try {
      String name = "getAttributeNames";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr8.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr8.appendTcDetail(e.toString());
    }
    tr8.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletSession_SIGRender_hasGetAttributeNamesA */
    /* Details: "PortletSession has a getAttributeNames(int)  method " */
    TestResult tr9 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETATTRIBUTENAMESA);
    try {
      String name = "getAttributeNames";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {int.class};
      tr9.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr9.appendTcDetail(e.toString());
    }
    tr9.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletSession_SIGRender_hasGetAttributeNamesReturns */
    /* Details: "PortletSession method getAttributeNames() returns */
    /* java.util.Enumeration " */
    TestResult tr10 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETATTRIBUTENAMESRETURNS);
    try {
      String name = "getAttributeNames";
      Class<?> retType = java.util.Enumeration.class;
      Class<?>[] parms = null;
      tr10.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr10.appendTcDetail(e.toString());
    }
    tr10.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletSession_SIGRender_hasGetAttributeNamesReturnsA */
    /* Details: "PortletSession method getAttributeNames(int) returns */
    /* java.util.Enumeration " */
    TestResult tr11 = tcd
        .getTestResultFailed(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETATTRIBUTENAMESRETURNSA);
    try {
      String name = "getAttributeNames";
      Class<?> retType = java.util.Enumeration.class;
      Class<?>[] parms = {int.class};
      tr11.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr11.appendTcDetail(e.toString());
    }
    tr11.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletSession_SIGRender_hasGetAttributeReturns */
    /* Details: "PortletSession method getAttribute(String) returns */
    /* Object " */
    TestResult tr12 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETATTRIBUTERETURNS);
    try {
      String name = "getAttribute";
      Class<?> retType = Object.class;
      Class<?>[] parms = {String.class};
      tr12.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr12.appendTcDetail(e.toString());
    }
    tr12.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletSession_SIGRender_hasGetAttributeReturnsA */
    /* Details: "PortletSession method getAttribute(String, int) returns */
    /* Object " */
    TestResult tr13 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETATTRIBUTERETURNSA);
    try {
      String name = "getAttribute";
      Class<?> retType = Object.class;
      Class<?>[] parms = {String.class, int.class};
      tr13.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr13.appendTcDetail(e.toString());
    }
    tr13.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletSession_SIGRender_hasGetCreationTime */
    /* Details: "PortletSession has a getCreationTime()  method " */
    TestResult tr14 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETCREATIONTIME);
    try {
      String name = "getCreationTime";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr14.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr14.appendTcDetail(e.toString());
    }
    tr14.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletSession_SIGRender_hasGetCreationTimeReturns */
    /* Details: "PortletSession method getCreationTime() returns long " */
    TestResult tr15 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETCREATIONTIMERETURNS);
    try {
      String name = "getCreationTime";
      Class<?> retType = long.class;
      Class<?>[] parms = null;
      tr15.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr15.appendTcDetail(e.toString());
    }
    tr15.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletSession_SIGRender_hasGetId */
    /* Details: "PortletSession has a getId()  method " */
    TestResult tr16 = tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETID);
    try {
      String name = "getId";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr16.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr16.appendTcDetail(e.toString());
    }
    tr16.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletSession_SIGRender_hasGetIdReturns */
    /* Details: "PortletSession method getId() returns String " */
    TestResult tr17 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETIDRETURNS);
    try {
      String name = "getId";
      Class<?> retType = String.class;
      Class<?>[] parms = null;
      tr17.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr17.appendTcDetail(e.toString());
    }
    tr17.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletSession_SIGRender_hasGetLastAccessedTime */
    /* Details: "PortletSession has a getLastAccessedTime()  method " */
    TestResult tr18 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETLASTACCESSEDTIME);
    try {
      String name = "getLastAccessedTime";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr18.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr18.appendTcDetail(e.toString());
    }
    tr18.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletSession_SIGRender_hasGetLastAccessedTimeReturns */
    /* Details: "PortletSession method getLastAccessedTime() returns long */
    /* " */
    TestResult tr19 = tcd
        .getTestResultFailed(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETLASTACCESSEDTIMERETURNS);
    try {
      String name = "getLastAccessedTime";
      Class<?> retType = long.class;
      Class<?>[] parms = null;
      tr19.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr19.appendTcDetail(e.toString());
    }
    tr19.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletSession_SIGRender_hasGetMaxInactiveInterval */
    /* Details: "PortletSession has a getMaxInactiveInterval()  method " */
    TestResult tr20 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETMAXINACTIVEINTERVAL);
    try {
      String name = "getMaxInactiveInterval";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr20.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr20.appendTcDetail(e.toString());
    }
    tr20.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletSession_SIGRender_hasGetMaxInactiveIntervalReturns */
    /* Details: "PortletSession method getMaxInactiveInterval() returns */
    /* int " */
    TestResult tr21 = tcd.getTestResultFailed(
        V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETMAXINACTIVEINTERVALRETURNS);
    try {
      String name = "getMaxInactiveInterval";
      Class<?> retType = int.class;
      Class<?>[] parms = null;
      tr21.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr21.appendTcDetail(e.toString());
    }
    tr21.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletSession_SIGRender_hasGetPortletContext */
    /* Details: "PortletSession has a getPortletContext()  method " */
    TestResult tr22 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETPORTLETCONTEXT);
    try {
      String name = "getPortletContext";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr22.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr22.appendTcDetail(e.toString());
    }
    tr22.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletSession_SIGRender_hasGetPortletContextReturns */
    /* Details: "PortletSession method getPortletContext() returns */
    /* PortletContext " */
    TestResult tr23 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETPORTLETCONTEXTRETURNS);
    try {
      String name = "getPortletContext";
      Class<?> retType = PortletContext.class;
      Class<?>[] parms = null;
      tr23.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr23.appendTcDetail(e.toString());
    }
    tr23.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletSession_SIGRender_hasInvalidate */
    /* Details: "PortletSession has a invalidate()  method " */
    TestResult tr24 = tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASINVALIDATE);
    try {
      String name = "invalidate";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr24.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr24.appendTcDetail(e.toString());
    }
    tr24.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletSession_SIGRender_hasInvalidateReturns */
    /* Details: "PortletSession method invalidate() returns void " */
    TestResult tr25 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASINVALIDATERETURNS);
    try {
      String name = "invalidate";
      Class<?> retType = void.class;
      Class<?>[] parms = null;
      tr25.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr25.appendTcDetail(e.toString());
    }
    tr25.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletSession_SIGRender_hasIsNew */
    /* Details: "PortletSession has a isNew()  method " */
    TestResult tr26 = tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASISNEW);
    try {
      String name = "isNew";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr26.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr26.appendTcDetail(e.toString());
    }
    tr26.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletSession_SIGRender_hasIsNewReturns */
    /* Details: "PortletSession method isNew() returns boolean " */
    TestResult tr27 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASISNEWRETURNS);
    try {
      String name = "isNew";
      Class<?> retType = boolean.class;
      Class<?>[] parms = null;
      tr27.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr27.appendTcDetail(e.toString());
    }
    tr27.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletSession_SIGRender_hasRemoveAttribute */
    /* Details: "PortletSession has a removeAttribute(String)  method " */
    TestResult tr28 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASREMOVEATTRIBUTE);
    try {
      String name = "removeAttribute";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {String.class};
      tr28.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr28.appendTcDetail(e.toString());
    }
    tr28.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletSession_SIGRender_hasRemoveAttributeA */
    /* Details: "PortletSession has a removeAttribute(String, int) */
    /* method " */
    TestResult tr29 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASREMOVEATTRIBUTEA);
    try {
      String name = "removeAttribute";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {String.class, int.class};
      tr29.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr29.appendTcDetail(e.toString());
    }
    tr29.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletSession_SIGRender_hasRemoveAttributeReturns */
    /* Details: "PortletSession method removeAttribute(String) returns */
    /* void " */
    TestResult tr30 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASREMOVEATTRIBUTERETURNS);
    try {
      String name = "removeAttribute";
      Class<?> retType = void.class;
      Class<?>[] parms = {String.class};
      tr30.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr30.appendTcDetail(e.toString());
    }
    tr30.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletSession_SIGRender_hasRemoveAttributeReturnsA */
    /* Details: "PortletSession method removeAttribute(String, int) */
    /* returns void " */
    TestResult tr31 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASREMOVEATTRIBUTERETURNSA);
    try {
      String name = "removeAttribute";
      Class<?> retType = void.class;
      Class<?>[] parms = {String.class, int.class};
      tr31.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr31.appendTcDetail(e.toString());
    }
    tr31.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletSession_SIGRender_hasSetAttribute */
    /* Details: "PortletSession has a setAttribute(String, Object) */
    /* method " */
    TestResult tr32 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASSETATTRIBUTE);
    try {
      String name = "setAttribute";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {String.class, Object.class};
      tr32.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr32.appendTcDetail(e.toString());
    }
    tr32.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletSession_SIGRender_hasSetAttributeA */
    /* Details: "PortletSession has a setAttribute(String, Object, int) */
    /* method " */
    TestResult tr33 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASSETATTRIBUTEA);
    try {
      String name = "setAttribute";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {String.class, Object.class, int.class};
      tr33.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr33.appendTcDetail(e.toString());
    }
    tr33.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletSession_SIGRender_hasSetAttributeReturns */
    /* Details: "PortletSession method setAttribute(String, Object) */
    /* returns void " */
    TestResult tr34 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASSETATTRIBUTERETURNS);
    try {
      String name = "setAttribute";
      Class<?> retType = void.class;
      Class<?>[] parms = {String.class, Object.class};
      tr34.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr34.appendTcDetail(e.toString());
    }
    tr34.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletSession_SIGRender_hasSetAttributeReturnsA */
    /* Details: "PortletSession method setAttribute(String, Object, int) */
    /* returns void " */
    TestResult tr35 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASSETATTRIBUTERETURNSA);
    try {
      String name = "setAttribute";
      Class<?> retType = void.class;
      Class<?>[] parms = {String.class, Object.class, int.class};
      tr35.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr35.appendTcDetail(e.toString());
    }
    tr35.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletSession_SIGRender_hasSetMaxInactiveInterval */
    /* Details: "PortletSession has a setMaxInactiveInterval(int) method */
    /* " */
    TestResult tr36 =
        tcd.getTestResultFailed(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASSETMAXINACTIVEINTERVAL);
    try {
      String name = "setMaxInactiveInterval";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {int.class};
      tr36.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr36.appendTcDetail(e.toString());
    }
    tr36.writeTo(writer);

    /* TestCase: V2SigTestsEnv_PortletSession_SIGRender_hasSetMaxInactiveIntervalReturns */
    /* Details: "PortletSession method setMaxInactiveInterval(int) */
    /* returns void " */
    TestResult tr37 = tcd.getTestResultFailed(
        V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASSETMAXINACTIVEINTERVALRETURNS);
    try {
      String name = "setMaxInactiveInterval";
      Class<?> retType = void.class;
      Class<?>[] parms = {int.class};
      tr37.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr37.appendTcDetail(e.toString());
    }
    tr37.writeTo(writer);

  }

}
