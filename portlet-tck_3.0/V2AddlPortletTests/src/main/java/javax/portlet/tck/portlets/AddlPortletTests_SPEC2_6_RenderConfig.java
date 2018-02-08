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
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ResourceBundle;

import javax.portlet.*;
import javax.portlet.tck.beans.JSR286SpecTestCaseDetails;
import javax.portlet.tck.beans.TestResult;
import javax.xml.namespace.QName;

import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG_GETRESOURCEBUNDLE1;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG_GETRESOURCEBUNDLE2;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG_GETRESOURCEBUNDLE3;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG_GETRESOURCEBUNDLE4;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG_GETPUBLISHINGEVENTQNAMES4;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG_GETPROCESSINGEVENTQNAMES4;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG_GETCONTAINERRUNTIMEOPTIONS6;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG_GETCONTAINERRUNTIMEOPTIONS7;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG_GETCONTAINERRUNTIMEOPTIONS8;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG_GETCONTAINERRUNTIMEOPTIONS9;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG_GETDEFAULTNAMESPACE2;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;
import static javax.xml.XMLConstants.NULL_NS_URI;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined
 * in the /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate
 * the test case names defined in the additionalTCs.xml file into the complete list of test case
 * names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will
 * initiate the events, but not process them. The processing is done in the companion portlet
 * AddlPortletTests_SPEC2_6_RenderConfig_event
 * 
 * @author ahmed
 */
public class AddlPortletTests_SPEC2_6_RenderConfig implements Portlet {

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

    JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();

    Locale locale = portletReq.getLocale();
    ResourceBundle res = portletConfig.getResourceBundle(locale);
    Map<String, String[]> runtimeOptions = portletConfig.getContainerRuntimeOptions();

    // Create result objects for the tests

    /* TestCase: V2AddlPortletTests_SPEC2_6_RenderConfig_getResourceBundle1 */
    /* Details: "The resource bundle defined in the deployment descriptor */
    /* &lt;resource-bundle&gt; element can be obtained through the */
    /* PortletConfig object" */
    TestResult tr0 =
        tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG_GETRESOURCEBUNDLE1);
    if (res != null) {
      tr0.setTcSuccess(true);
    } else {
      tr0.appendTcDetail("Failed because ResourceBundle is null");
    }
    tr0.writeTo(writer);

    /* TestCase: V2AddlPortletTests_SPEC2_6_RenderConfig_getResourceBundle2 */
    /* Details: "If the resource bundle contains a */
    /* \"javax.portlet.title\" property, the value defined in the bundle */
    /* is returned by the corresponding getString method call" */
    TestResult tr1 =
        tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG_GETRESOURCEBUNDLE2);
    if (res.getString("javax.portlet.title").equals("AddlPortletTests_SPEC2_6_RenderConfig")) {
      tr1.setTcSuccess(true);
    } else {
      tr1.appendTcDetail("Failed because title is " + res.getString("javax.portlet.title"));
    }
    tr1.writeTo(writer);

    /* TestCase: V2AddlPortletTests_SPEC2_6_RenderConfig_getResourceBundle3 */
    /* Details: "If the resource bundle contains a */
    /* \"javax.portlet.short-title\" property, the value defined in the */
    /* bundle is returned by the corresponding getString method call" */
    TestResult tr2 =
        tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG_GETRESOURCEBUNDLE3);
    if (res.getString("javax.portlet.short-title")
        .equals("AddlPortletTests_SPEC2_6_RenderConfig_a")) {
      tr2.setTcSuccess(true);
    } else {
      tr2.appendTcDetail(
          "Failed because short-title is " + res.getString("javax.portlet.short-title"));
    }
    tr2.writeTo(writer);

    /* TestCase: V2AddlPortletTests_SPEC2_6_RenderConfig_getResourceBundle4 */
    /* Details: "If the resource bundle contains a */
    /* \"javax.portlet.keywords\" property, the value defined in the */
    /* bundle is returned by the corresponding getString method call" */
    TestResult tr3 =
        tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG_GETRESOURCEBUNDLE4);
    if (res.getString("javax.portlet.keywords").equals("AddlPortletTests_SPEC2_6_RenderConfig_b")) {
      tr3.setTcSuccess(true);
    } else {
      tr3.appendTcDetail("Failed because keyword is " + res.getString("javax.portlet.keywords"));
    }
    tr3.writeTo(writer);

    /* TestCase: V2AddlPortletTests_SPEC2_6_RenderConfig_getPublishingEventQnames4 */
    /* Details: "getPublishingEventQnames - If the event was defined */
    /* using the &lt;name&gt; element rather than the &lt;qname&gt; */
    /* element and there is no default namespace defined, the value */
    /* XMLConstants.NULL_NS_URI must be added as the event namespace" */
    TestResult tr5 =
        tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG_GETPUBLISHINGEVENTQNAMES4);
    Enumeration<QName> publishingEvents = portletConfig.getPublishingEventQNames();
    while (publishingEvents.hasMoreElements()) {
      QName qName = publishingEvents.nextElement();
      if (qName.getNamespaceURI().equals(NULL_NS_URI)) {
        tr5.setTcSuccess(true);
        break;
      } else {
        tr5.appendTcDetail("Failure because Qname namespace is not equal to \"" + NULL_NS_URI
            + "\" but \"" + qName.getNamespaceURI() + "\"");
      }
    }
    tr5.writeTo(writer);

    /* TestCase: V2AddlPortletTests_SPEC2_6_RenderConfig_getProcessingEventQnames4 */
    /* Details: "getProcessingEventQnames - If the event was defined */
    /* using the &lt;name&gt; element rather than the &lt;qname&gt; */
    /* element and there is no default namespace defined, the value */
    /* XMLConstants.NULL_NS_URI must be added as the event namespace" */
    TestResult tr7 =
        tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG_GETPROCESSINGEVENTQNAMES4);
    Enumeration<QName> processingEvents = portletConfig.getProcessingEventQNames();
    while (processingEvents.hasMoreElements()) {
      QName qName = processingEvents.nextElement();
      if (qName.getNamespaceURI().equals(NULL_NS_URI)) {
        tr7.setTcSuccess(true);
        break;
      } else {
        tr7.appendTcDetail("Failure because Qname namespace is not equal to \"" + NULL_NS_URI
            + "\" but \"" + qName.getNamespaceURI() + "\"");
      }
    }
    tr7.writeTo(writer);

    /*
     * different containers expect different options
     */
    PortletContext portletContext = portletConfig.getPortletContext();
    String expectedOption = portletContext.getInitParameter("javax.portlet.portletConfig.getContainerRuntimeOptions.EXPECTED_OPTION");
    String expectedValue = portletContext.getInitParameter("javax.portlet.portletConfig.getContainerRuntimeOptions.EXPECTED_VALUE");

    /* TestCase: V2AddlPortletTests_SPEC2_6_RenderConfig_getContainerRuntimeOptions6 */
    /* Details: "The returned Map contains values defined in the */
    /* deployment descriptor &lt;container-runtime-option&gt; elements at */
    /* the portlet application level" */
    TestResult tr8 = tcd
        .getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG_GETCONTAINERRUNTIMEOPTIONS6);
    for (Entry<String, String[]> entry : runtimeOptions.entrySet()) {
      String[] values = entry.getValue();
      for (String e : values) {
        if (entry.getKey().equals(expectedOption)
            && e.equals(expectedValue)) {
          tr8.setTcSuccess(true);
        }
      }
    }
    tr8.writeTo(writer);

    /* TestCase: V2AddlPortletTests_SPEC2_6_RenderConfig_getContainerRuntimeOptions7 */
    /* Details: "The returned Map contains values defined in the */
    /* deployment descriptor &lt;container-runtime-option&gt; elements at */
    /* the portlet level" */
    TestResult tr9 = tcd
        .getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG_GETCONTAINERRUNTIMEOPTIONS7);
    for (Entry<String, String[]> entry : runtimeOptions.entrySet()) {
      String[] values = entry.getValue();
      for (String e : values) {
        if (entry.getKey().equals(expectedOption) && e.equals(expectedValue)) {
          tr9.setTcSuccess(true);
        }
      }
    }
    tr9.writeTo(writer);

    /* TestCase: V2AddlPortletTests_SPEC2_6_RenderConfig_getContainerRuntimeOptions8 */
    /* Details: "If the deployment descriptor contains */
    /* &lt;container-runtime-option&gt; elements defined at both the */
    /* portlet and the portlet application levels, the returned Map */
    /* contains a merger of all values" */
    TestResult tr10 = tcd
        .getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG_GETCONTAINERRUNTIMEOPTIONS8);
    boolean tr10a = false;
    for (Entry<String, String[]> entry : runtimeOptions.entrySet()) {
      String[] values = entry.getValue();
      for (String e : values) {
        if (entry.getKey().equals(expectedOption) && e.equals(expectedValue)) {
          tr10a = true;
        }
      }
    }
    if (tr10a) {
      for (Entry<String, String[]> entry : runtimeOptions.entrySet()) {
        String[] values = entry.getValue();
        for (String e : values) {
          if (entry.getKey().equals(expectedOption)
              && e.equals(expectedValue)) {
            tr10.setTcSuccess(true);
          }
        }
      }
    } else {
      tr10.appendTcDetail("Failed because runtime option " + expectedOption + "is not found");
    }
    tr10.writeTo(writer);

    /* TestCase: V2AddlPortletTests_SPEC2_6_RenderConfig_getContainerRuntimeOptions9 */
    /* Details: "If the deployment descriptor contains */
    /* &lt;container-runtime-option&gt; elements of the same name defined */
    /* at both the portlet and the portlet application levels, the */
    /* returned Map contains a the value defined at the portlet level" */
    TestResult tr11 = tcd
        .getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG_GETCONTAINERRUNTIMEOPTIONS9);
    for (Entry<String, String[]> entry : runtimeOptions.entrySet()) {
      String[] values = entry.getValue();
      for (String e : values) {
        if (entry.getKey().equals(expectedOption) && e.equals(expectedValue)) {
          tr11.setTcSuccess(true);
        }
      }
    }
    tr11.writeTo(writer);

    /* TestCase: V2AddlPortletTests_SPEC2_6_RenderConfig_getDefaultNamespace2 */
    /* Details: "Method getDefaultNamespace(): Returns */
    /* XMLConstants.NULL_NS_URI if no default namespace is defined in the */
    /* deployment descriptor " */
    TestResult tr12 =
        tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG_GETDEFAULTNAMESPACE2);
    if (portletConfig.getDefaultNamespace().equals(NULL_NS_URI)) {
      tr12.setTcSuccess(true);
    } else {
      tr12.appendTcDetail("Failure because Qname namespace is not equal to \"" + NULL_NS_URI
          + "\" but \"" + portletConfig.getDefaultNamespace() + "\"");
    }
    tr12.writeTo(writer);
  }

}
