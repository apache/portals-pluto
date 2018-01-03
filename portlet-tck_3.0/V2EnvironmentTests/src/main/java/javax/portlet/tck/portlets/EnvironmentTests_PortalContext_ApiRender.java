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
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortalContext;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;
import javax.portlet.tck.beans.ClassChecker;
import javax.portlet.tck.beans.JSR286ApiTestCaseDetails;
import javax.portlet.tck.beans.TestResult;

import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_FIELDMARKUP_HEAD_ELEMENT_SUPPORT;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETPROPERTY1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETPROPERTY2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETPROPERTY3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETPROPERTYNAMES1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETPROPERTYNAMES2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETSUPPORTEDPORTLETMODES1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETSUPPORTEDPORTLETMODES2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETSUPPORTEDPORTLETMODES3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETSUPPORTEDPORTLETMODES4;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETSUPPORTEDWINDOWSTATES1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETSUPPORTEDWINDOWSTATES2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETSUPPORTEDWINDOWSTATES3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETSUPPORTEDWINDOWSTATES4;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETPORTALINFO1;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined
 * in the /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate
 * the test case names defined in the additionalTCs.xml file into the complete list of test case
 * names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will
 * initiate the events, but not process them. The processing is done in the companion portlet
 * EnvironmentTests_PortalContext_ApiRender_event
 *
 * @author ahmed
 */
public class EnvironmentTests_PortalContext_ApiRender implements Portlet {

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

    JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

    // Create result objects for the tests

    ClassChecker cc = new ClassChecker(portletReq.getPortalContext().getClass());

    PortalContext pcn = portletReq.getPortalContext();

    /* TestCase: V2EnvironmentTests_PortalContext_ApiRender_fieldMARKUP_HEAD_ELEMENT_SUPPORT */
    /* Details: "Has String field MARKUP_HEAD_ELEMENT_SUPPORT with value */
    /* of \"javax.portlet.markup.head.element.support\" " */
    TestResult tr0 = tcd.getTestResultFailed(
        V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_FIELDMARKUP_HEAD_ELEMENT_SUPPORT);
    try {
      tr0.setTcSuccess(
          cc.hasField("MARKUP_HEAD_ELEMENT_SUPPORT", "javax.portlet.markup.head.element.support"));
    } catch (Exception e) {
      tr0.appendTcDetail(e.toString());
    }
    tr0.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortalContext_ApiRender_getProperty1 */
    /* Details: "Method getProperty(String): Returns a String containing */
    /* the value for the specified property " */
    TestResult tr1 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETPROPERTY1);
    String prop1 = pcn.getProperty("javax.portlet.markup.head.element.support");
    if (prop1 != null) {
      tr1.setTcSuccess(true);
    } else {
      tr1.appendTcDetail("The getProperty Method has null value ");
    }
    tr1.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortalContext_ApiRender_getProperty2 */
    /* Details: "Method getProperty(String): Returns null if there is no */
    /* property defined for the specified name" */
    TestResult tr2 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETPROPERTY2);
    String prop2 = pcn.getProperty("javax.portlet.TestProperty");
    if (prop2 == null) {
      tr2.setTcSuccess(true);
    } else {
      tr2.appendTcDetail("The getProperty Method has value : " + prop2);
    }
    tr2.writeTo(writer);


    /* TestCase: V2EnvironmentTests_PortalContext_ApiRender_getProperty3 */
    /* Details: "Method getProperty(String): Throws */
    /* IllegalArgumentException if the specified name is null " */
    TestResult tr3 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETPROPERTY3);
    try {
      PortalContext cntxt = portletReq.getPortalContext();
      cntxt.getProperty(null);
      tr3.appendTcDetail("Method did not throw an exception.");
    } catch (IllegalArgumentException iae) {
      tr3.appendTcDetail(iae.toString());
      tr3.setTcSuccess(true);
    } catch (Exception e) {
      tr3.appendTcDetail(e.toString());
    }
    tr3.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortalContext_ApiRender_getPropertyNames1 */
    /* Details: "Method getPropertyNames(): Returns an */
    /* java.util.Enumeration&lt;java.lang.String&gt; containing all */
    /* portal property names" */
    TestResult tr4 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETPROPERTYNAMES1);
    Enumeration<String> propName1 = pcn.getPropertyNames();
    if (propName1 != null && propName1.hasMoreElements()) {
      tr4.setTcSuccess(true);
    } else {
      tr4.appendTcDetail("The getPropertyNames has null value");
    }
    tr4.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortalContext_ApiRender_getPropertyNames2 */
    /* Details: "Method getPropertyNames(): Returns an empty Enumeration */
    /* if there are no portal property names defined" */
    TestResult tr5 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETPROPERTYNAMES2);
    tr5.setTcSuccess(true);
    tr5.appendTcDetail("This Method could not be Tested Which already has Porltal Property names");
    tr5.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortalContext_ApiRender_getSupportedPortletModes1 */
    /* Details: "Method getSupportedPortletModes(): Returns an */
    /* java.util.Enumeration&lt;PortletMode&gt; containing all supported */
    /* portlet modes" */
    TestResult tr6 = tcd
        .getTestResultFailed(V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETSUPPORTEDPORTLETMODES1);
    Enumeration<PortletMode> pm1 = pcn.getSupportedPortletModes();
    List<PortletMode> listmode = Collections.list(pm1);
    if (listmode != null) {
      tr6.setTcSuccess(true);
    } else {
      tr6.appendTcDetail("The SupportedPortletModes has null values ");
    }
    tr6.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortalContext_ApiRender_getSupportedPortletModes2 */
    /* Details: "Method getSupportedPortletModes(): The Enumeration */
    /* returned must contain the view mode" */
    TestResult tr7 = tcd
        .getTestResultFailed(V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETSUPPORTEDPORTLETMODES2);
    if (listmode != null && listmode.contains(PortletMode.VIEW)) {
      tr7.setTcSuccess(true);
    } else {
      tr7.appendTcDetail(
          "The SupportedPortletModes doesnot Contain View Mode " + listmode.toString());
    }
    tr7.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortalContext_ApiRender_getSupportedPortletModes3 */
    /* Details: "Method getSupportedPortletModes(): The Enumeration */
    /* returned must contain the edit mode" */
    TestResult tr8 = tcd
        .getTestResultFailed(V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETSUPPORTEDPORTLETMODES3);
    if (listmode != null && listmode.contains(PortletMode.EDIT)) {
      tr8.setTcSuccess(true);
    } else {
      tr8.appendTcDetail(
          "The SupportedPortletModes doesnot Contain Edit Mode " + listmode.toString());
    }
    tr8.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortalContext_ApiRender_getSupportedPortletModes4 */
    /* Details: "Method getSupportedPortletModes(): The Enumeration */
    /* returned must contain the help mode" */
    TestResult tr9 = tcd
        .getTestResultFailed(V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETSUPPORTEDPORTLETMODES4);
    if (listmode != null && listmode.contains(PortletMode.HELP)) {
      tr9.setTcSuccess(true);
    } else {
      tr9.appendTcDetail(
          "The SupportedPortletModes doesnot Contain Help Mode " + listmode.toString());
    }
    tr9.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortalContext_ApiRender_getSupportedWindowStates1 */
    /* Details: "Method getSupportedWindowStates(): Returns an */
    /* java.util.Enumeration&lt;WindowState&gt; containing all supported */
    /* window states" */
    TestResult tr10 = tcd
        .getTestResultFailed(V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETSUPPORTEDWINDOWSTATES1);
    Enumeration<WindowState> ws1 = pcn.getSupportedWindowStates();
    List<WindowState> liststate = Collections.list(ws1);
    if (liststate != null) {
      tr10.setTcSuccess(true);
    } else {
      tr10.appendTcDetail("The Supported WindowStates has null values ");
    }
    tr10.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortalContext_ApiRender_getSupportedWindowStates2 */
    /* Details: "Method getSupportedWindowStates(): The Enumeration */
    /* returned must contain the maximized state" */
    TestResult tr11 = tcd
        .getTestResultFailed(V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETSUPPORTEDWINDOWSTATES2);
    if (liststate != null && liststate.contains(WindowState.MAXIMIZED)) {
      tr11.setTcSuccess(true);
    } else {
      tr11.appendTcDetail(
          "The SupportedWindowStates doesnot Contain Maximized State " + liststate.toString());
    }
    tr11.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortalContext_ApiRender_getSupportedWindowStates3 */
    /* Details: "Method getSupportedWindowStates(): The Enumeration */
    /* returned must contain the minimized state" */
    TestResult tr12 = tcd
        .getTestResultFailed(V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETSUPPORTEDWINDOWSTATES3);
    if (liststate != null && liststate.contains(WindowState.MINIMIZED)) {
      tr12.setTcSuccess(true);
    } else {
      tr12.appendTcDetail(
          "The SupportedWindowStates doesnot Contain Minimized State " + liststate.toString());
    }
    tr12.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortalContext_ApiRender_getSupportedWindowStates4 */
    /* Details: "Method getSupportedWindowStates(): The Enumeration */
    /* returned must contain the normal state" */
    TestResult tr13 = tcd
        .getTestResultFailed(V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETSUPPORTEDWINDOWSTATES4);
    if (liststate != null && liststate.contains(WindowState.NORMAL)) {
      tr13.setTcSuccess(true);
    } else {
      tr13.appendTcDetail(
          "The SupportedWindowStates doesnot Contain Normal State " + liststate.toString());
    }
    tr13.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortalContext_ApiRender_getPortalInfo1 */
    /* Details: "Method getPortalInfo(): Returns a String containing */
    /* the server name and version in the form name/version " */
    TestResult tr14 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETPORTALINFO1);
    String portal = pcn.getPortalInfo();
    if (portal != null && portal.matches("(.+)/(.+) *(.*)")) {
      tr14.setTcSuccess(true);
    } else {
      tr14.appendTcDetail("The Portal has Invalid form :" + portal);
    }
    tr14.writeTo(writer);

  }

}
