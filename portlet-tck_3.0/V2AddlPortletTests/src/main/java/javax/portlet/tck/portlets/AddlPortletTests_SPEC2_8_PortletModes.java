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
import java.util.Locale;
import java.util.ResourceBundle;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.PortletURL;
import javax.portlet.RenderMode;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.tck.beans.JSR286SpecTestCaseDetails;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.beans.TestSetupLink;

import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_8_PORTLETMODES_DECLARINGPORTLETMODES1;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_8_PORTLETMODES_DECLARINGPORTLETMODES2;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_8_PORTLETMODES_DECLARINGPORTLETMODES3;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_8_PORTLETMODES_DECLARINGPORTLETMODES4;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_8_PORTLETMODES_DECLARINGPORTLETMODES5;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_8_PORTLETMODES_DECLARINGPORTLETMODES6;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_8_PORTLETMODES_DECLARINGPORTLETMODES8;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_8_PORTLETMODES_DECLARINGPORTLETMODES9;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_8_PORTLETMODES_DECLARINGPORTLETMODES7;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined
 * in the /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate
 * the test case names defined in the additionalTCs.xml file into the complete list of test case
 * names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will
 * initiate the events, but not process them. The processing is done in the companion portlet
 * AddlPortletTests_SPEC2_8_PortletModes_event
 * 
 * @author ahmed
 */
public class AddlPortletTests_SPEC2_8_PortletModes extends GenericPortlet {

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

    JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();

    // Create result objects for the tests

    /* TestCase: V2AddlPortletTests_SPEC2_8_PortletModes_declaringPortletModes1 */
    /* Details: "Support for the VIEW mode does not need to be declared */
    /* in the deployment descriptor" */
    TestResult tr0 =
        tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_8_PORTLETMODES_DECLARINGPORTLETMODES1);
    if (portletReq.isPortletModeAllowed(PortletMode.VIEW)) {
      tr0.setTcSuccess(true);
    } else {
      tr0.appendTcDetail("Failed because VIEW portlet mode is not allowed.");
    }
    tr0.writeTo(writer);

    /* TestCase: V2AddlPortletTests_SPEC2_8_PortletModes_declaringPortletModes2 */
    /* Details: "Support for the HELP mode must be declared in the */
    /* deployment descriptor" */
    TestResult tr1 =
        tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_8_PORTLETMODES_DECLARINGPORTLETMODES2);
    if (portletReq.isPortletModeAllowed(PortletMode.HELP)) {
      tr1.setTcSuccess(true);
    } else {
      tr1.appendTcDetail("Failed because HELP portlet mode is not allowed.");
    }
    tr1.writeTo(writer);

    /* TestCase: V2AddlPortletTests_SPEC2_8_PortletModes_declaringPortletModes3 */
    /* Details: "A custom portlet mode may be declared in the deployment */
    /* descriptor" */
    TestResult tr2 =
        tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_8_PORTLETMODES_DECLARINGPORTLETMODES3);
    if (portletReq.isPortletModeAllowed(new PortletMode("custom1"))) {
      tr2.setTcSuccess(true);
    } else {
      tr2.appendTcDetail("Failed because CUSTOM1 portlet mode is not allowed.");
    }
    tr2.writeTo(writer);

    /* TestCase: V2AddlPortletTests_SPEC2_8_PortletModes_declaringPortletModes4 */
    /* Details: "A custom portlet mode with */
    /* &lt;portal-managed&gt;false&lt;/portal-managed&gt; may be declared */
    /* in the deployment descriptor" */
    TestResult tr3 =
        tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_8_PORTLETMODES_DECLARINGPORTLETMODES4);
    if (portletReq.isPortletModeAllowed(new PortletMode("custom1"))) {
      tr3.setTcSuccess(true);
    } else {
      tr3.appendTcDetail("Failed because CUSTOM1 portlet mode is not allowed.");
    }
    tr3.writeTo(writer);

    /* TestCase: V2AddlPortletTests_SPEC2_8_PortletModes_declaringPortletModes5 */
    /* Details: "The PortletRequest.isPortletModeAllowed method must */
    /* return FALSE for a custom portlet mode with */
    /* &lt;portal-managed&gt;true&lt;/portal-managed&gt; that is not */
    /* supported by the portlet container" */
    TestResult tr4 =
        tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_8_PORTLETMODES_DECLARINGPORTLETMODES5);
    if (!portletReq.isPortletModeAllowed(new PortletMode("custom2"))) {
      tr4.setTcSuccess(true);
    } else {
      tr4.appendTcDetail("Failed because CUSTOM2 portlet mode is allowed.");
    }
    tr4.writeTo(writer);

    /* TestCase: V2AddlPortletTests_SPEC2_8_PortletModes_declaringPortletModes6 */
    /* Details: "The portlet container must ignore all custom portlet */
    /* modes in the deployment descriptor with */
    /* &lt;portal-managed&gt;true&lt;/portal-managed&gt; that is not */
    /* supported by the portlet container" */
    TestResult tr5 =
        tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_8_PORTLETMODES_DECLARINGPORTLETMODES6);
    if (!portletReq.isPortletModeAllowed(new PortletMode("custom2"))) {
      tr5.setTcSuccess(true);
    } else {
      tr5.appendTcDetail("Failed because CUSTOM2 portlet mode is allowed.");
    }
    tr5.writeTo(writer);

    /* TestCase: V2AddlPortletTests_SPEC2_8_PortletModes_declaringPortletModes8 */
    /* Details: "A custom portlet mode can have a localized decoration */
    /* name in the resource bundle with the name of */
    /* javax.portlet.app.custom-portlet-mode.&lt;name&gt;.decoration-name" */
    TestResult tr7 =
        tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_8_PORTLETMODES_DECLARINGPORTLETMODES8);
    Locale locale = portletReq.getLocale();
    ResourceBundle res = getResourceBundle(locale);
    if (res.getString("javax.portlet.app.custom-portlet-mode.custom1.decoration-name")
        .equals("decoration")) {
      tr7.setTcSuccess(true);
    } else {
      tr7.appendTcDetail("Failed because custom1 decoration name is"
          + res.getString("javax.portlet.app.custom-portlet-mode.custom1.decoration-name"));
    }
    tr7.writeTo(writer);

    /* TestCase: V2AddlPortletTests_SPEC2_8_PortletModes_declaringPortletModes9 */
    /* Details: "The portlet must not be invoked in a mode that has not */
    /* been declared to be supported for a given markup type" */
    TestResult tr8 =
        tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_8_PORTLETMODES_DECLARINGPORTLETMODES9);
    try {
      PortletURL rurl = portletResp.createRenderURL();
      rurl.setPortletMode(new PortletMode("custom3"));
      tr8.setTcDetail(
          "Failed because portlet mode custom3 is set which has not been declared to be supported by this portlet.");
    } catch (PortletModeException e) {
      tr8.appendTcDetail(e.toString());
      tr8.setTcSuccess(true);
    }
    tr8.writeTo(writer);

    /* TestCase: V2AddlPortletTests_SPEC2_8_PortletModes_declaringPortletModes7 */
    /* Details: "A custom portlet mode with */
    /* &lt;portal-managed&gt;false&lt;/portal-managed&gt; corresponds to */
    /* the VIEW mode from the portal point of view" */
    if (portletReq.getParameter("tr6") == null) {
      PortletURL rurl = portletResp.createRenderURL();
      rurl.setPortletMode(new PortletMode("custom1"));
      rurl.setParameter("tr6", "true");
      TestSetupLink tl =
          new TestSetupLink(V2ADDLPORTLETTESTS_SPEC2_8_PORTLETMODES_DECLARINGPORTLETMODES7, rurl);
      tl.writeTo(writer);
    } else {
      super.render(portletReq, portletResp);
    }
  }

  @RenderMode(name = "custom1")
  public void doView(RenderRequest portletReq, RenderResponse portletResp)
      throws PortletException, IOException {

    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

    PrintWriter writer = portletResp.getWriter();

    JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();

    /* TestCase: V2AddlPortletTests_SPEC2_8_PortletModes_declaringPortletModes7 */
    /* Details: "A custom portlet mode with */
    /* &lt;portal-managed&gt;false&lt;/portal-managed&gt; corresponds to */
    /* the VIEW mode from the portal point of view" */
    if (portletReq.getParameter("tr6") != null && portletReq.getParameter("tr6").equals("true")) {
      TestResult tr6 =
          tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_8_PORTLETMODES_DECLARINGPORTLETMODES7);
      if (portletReq.getPortletMode().equals(new PortletMode("custom1"))) {
        tr6.setTcSuccess(true);
      } else {
        tr6.appendTcDetail("Failed because portlet mode is not VIEW but "
            + portletReq.getPortletMode().toString());
      }
      tr6.writeTo(writer);
    }
  }

}
