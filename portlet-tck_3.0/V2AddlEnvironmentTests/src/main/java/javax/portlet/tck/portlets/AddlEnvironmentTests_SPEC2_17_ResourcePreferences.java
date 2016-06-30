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

import static javax.portlet.PortletSession.APPLICATION_SCOPE;
import static javax.portlet.ResourceURL.PAGE;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_17_RESOURCEPREFERENCES_DEPLOYMENT10;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_17_RESOURCEPREFERENCES_DEPLOYMENT3;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_17_RESOURCEPREFERENCES_DEPLOYMENT4;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_17_RESOURCEPREFERENCES_DEPLOYMENT7;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_17_RESOURCEPREFERENCES_RESET1;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_17_RESOURCEPREFERENCES_SETVALUES4;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_17_RESOURCEPREFERENCES_STORE1;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_17_RESOURCEPREFERENCES_STORE4;
import static javax.portlet.tck.constants.Constants.RESULT_ATTR_PREFIX;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletURL;
import javax.portlet.ReadOnlyException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceServingPortlet;
import javax.portlet.ResourceURL;
import javax.portlet.tck.beans.JSR286SpecTestCaseDetails;
import javax.portlet.tck.beans.TestLink;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.constants.Constants;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined
 * in the /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate
 * the test case names defined in the additionalTCs.xml file into the complete list of test case
 * names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will
 * initiate the events, but not process them. The processing is done in the companion portlet
 * AddlEnvironmentTests_SPEC2_17_ResourcePreferences_event
 *
 */
@SuppressWarnings("deprecation")
public class AddlEnvironmentTests_SPEC2_17_ResourcePreferences
    implements Portlet, ResourceServingPortlet {

  @Override
  public void init(PortletConfig config) throws PortletException {
  }

  @Override
  public void destroy() {}

  @Override
  public void processAction(ActionRequest portletReq, ActionResponse portletResp)
      throws PortletException, IOException {

    JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();
    PortletPreferences portletPrefs = portletReq.getPreferences();

    portletResp.setRenderParameters(portletReq.getParameterMap());
    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

    StringWriter writer = new StringWriter();

    /* TestCase: V2AddlEnvironmentTests_SPEC2_17_ResourcePreferences_store1 */
    /* Details: "The store method persists preference changes previously */
    /* made during the processAction method" */
    TestResult tr2 =
        tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_17_RESOURCEPREFERENCES_STORE1);
    if (portletPrefs.getValue("tr2", null).equals("true")) {
      tr2.setTcSuccess(true);
    } else {
      tr2.appendTcDetail(
          "Failed because tr2 value is not true but " + portletPrefs.getValue("tr2", null));
    }
    tr2.writeTo(writer);

    /* TestCase: V2AddlEnvironmentTests_SPEC2_17_ResourcePreferences_store4 */
    /* Details: "If preference changes are made during the processAction */
    /* method, but the method completes without store being called, the */
    /* preference changes are discarded" */
    TestResult tr3 =
        tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_17_RESOURCEPREFERENCES_STORE4);
    if (portletPrefs.getValue("tr3", null).equals("false")) {
      tr3.setTcSuccess(true);
    } else {
      tr3.appendTcDetail(
          "Failed because tr3 value is not true but " + portletPrefs.getValue("tr3", null));
    }
    tr3.writeTo(writer);

    portletReq.getPortletSession().setAttribute(
        Constants.RESULT_ATTR_PREFIX + "AddlEnvironmentTests_SPEC2_17_ResourcePreferences",
        writer.toString(), APPLICATION_SCOPE);
  }

  @Override
  public void serveResource(ResourceRequest portletReq, ResourceResponse portletResp)
      throws PortletException, IOException {

    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

    PrintWriter writer = portletResp.getWriter();

    JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();

    PortletPreferences portletPrefs = portletReq.getPreferences();

    // Create result objects for the tests

    /* TestCase: V2AddlEnvironmentTests_SPEC2_17_ResourcePreferences_setValues4 */
    /* Details: "The setValues method allows the value array to be set to */
    /* null" */
    TestResult tr0 =
        tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_17_RESOURCEPREFERENCES_SETVALUES4);
    try {
      portletPrefs.setValues("tr0", (String[])null);
      tr0.setTcSuccess(true);
    } catch (Exception e) {
      tr0.appendTcDetail(e.toString());
    }
    tr0.writeTo(writer);

    /* TestCase: V2AddlEnvironmentTests_SPEC2_17_ResourcePreferences_reset1 */
    /* Details: "The reset method sets the value of the specified */
    /* preference to its default value. The actual default value itself */
    /* is implementation-specific and cannot be tested." */
    TestResult tr1 =
        tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_17_RESOURCEPREFERENCES_RESET1);
    portletPrefs.setValue("tr1", "false");
    portletPrefs.reset("tr1");
    if (portletPrefs.getValue("tr1", null).equals("true")) {
      tr1.setTcSuccess(true);
    } else {
      tr1.appendTcDetail(
          "Failed because tr1 value is not true but " + portletPrefs.getValue("tr1", null));
    }
    tr1.writeTo(writer);

    /* TestCase: V2AddlEnvironmentTests_SPEC2_17_ResourcePreferences_store1 */
    /* Details: "The store method persists preference changes previously */
    /* made during the processAction method" */
    {
      portletPrefs.setValue("tr2", "true");
      portletPrefs.store();
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestLink tb =
          new TestLink(V2ADDLENVIRONMENTTESTS_SPEC2_17_RESOURCEPREFERENCES_STORE1, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2AddlEnvironmentTests_SPEC2_17_ResourcePreferences_store4 */
    /* Details: "If preference changes are made during the processAction */
    /* method, but the method completes without store being called, the */
    /* preference changes are discarded" */
    {
      portletPrefs.setValue("tr3", "true");
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestLink tb =
          new TestLink(V2ADDLENVIRONMENTTESTS_SPEC2_17_RESOURCEPREFERENCES_STORE4, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2AddlEnvironmentTests_SPEC2_17_ResourcePreferences_deployment3 */
    /* Details: "A preference attribute definition may indicate if the */
    /* attribute is read only" */
    TestResult tr4 =
        tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_17_RESOURCEPREFERENCES_DEPLOYMENT3);
    if (portletPrefs.isReadOnly("tr4")) {
      tr4.setTcSuccess(true);
    } else {
      tr4.appendTcDetail("Failed because tr4 is not read-only");
    }
    tr4.writeTo(writer);

    /* TestCase: V2AddlEnvironmentTests_SPEC2_17_ResourcePreferences_deployment4 */
    /* Details: "If a preference attribute definition does not contain */
    /* the read-only setting, it will be modifiable in the processAction */
    /* method" */
    TestResult tr5 =
        tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_17_RESOURCEPREFERENCES_DEPLOYMENT4);
    try {
      portletPrefs.setValue("tr5", "true");
      if (portletPrefs.getValue("tr5", null).equals("true")) {
        tr5.setTcSuccess(true);
      } else {
        tr5.appendTcDetail(
            "Failed because tr5 is not true but " + portletPrefs.getValue("tr5", null));
      }
    } catch (Exception e) {
      tr5.appendTcDetail(e.toString());
    }
    tr5.writeTo(writer);

    /* TestCase: V2AddlEnvironmentTests_SPEC2_17_ResourcePreferences_deployment7 */
    /* Details: "If a preference attribute definition contains the */
    /* read-only setting, it will not be modifiable in the processAction */
    /* method" */
    TestResult tr6 =
        tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_17_RESOURCEPREFERENCES_DEPLOYMENT7);
    try {
      portletPrefs.setValue("tr6", "true");
    } catch (ReadOnlyException e) {
      tr6.setTcSuccess(true);
      tr6.appendTcDetail(e.toString());
    }
    tr6.writeTo(writer);

    /* TestCase: V2AddlEnvironmentTests_SPEC2_17_ResourcePreferences_deployment10 */
    /* Details: "A preference attribute not defined in the deployment */
    /* descriptor may be added programmatically in the processAction */
    /* method" */
    TestResult tr7 =
        tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_17_RESOURCEPREFERENCES_DEPLOYMENT10);
    try {
      portletPrefs.setValue("tr7", "true");
      tr7.setTcSuccess(true);
    } catch (ReadOnlyException e) {
      tr7.appendTcDetail(e.toString());
    }
    tr7.writeTo(writer);

    String msg = (String) portletReq.getPortletSession().getAttribute(
        RESULT_ATTR_PREFIX + "AddlEnvironmentTests_SPEC2_17_ResourcePreferences",
        APPLICATION_SCOPE);
    if (msg != null) {
      writer.write(msg);
    }
  }

  @Override
  public void render(RenderRequest portletReq, RenderResponse portletResp)
      throws PortletException, IOException {

    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

    PrintWriter writer = portletResp.getWriter();

    writer.write(
        "<div id=\"AddlEnvironmentTests_SPEC2_17_ResourcePreferences\">no resource output.</div>\n");
    ResourceURL resurl = portletResp.createResourceURL();
    resurl.setCacheability(PAGE);
    writer.write("<script>\n");
    writer.write("(function () {\n");
    writer.write("   var xhr = new XMLHttpRequest();\n");
    writer.write("   xhr.onreadystatechange=function() {\n");
    writer.write("      if (xhr.readyState==4 && xhr.status==200) {\n");
    writer.write(
        "         document.getElementById(\"AddlEnvironmentTests_SPEC2_17_ResourcePreferences\").innerHTML=xhr.responseText;\n");
    writer.write("      }\n");
    writer.write("   };\n");
    writer.write("   xhr.open(\"GET\",\"" + resurl.toString() + "\",true);\n");
    writer.write("   xhr.send();\n");
    writer.write("})();\n");
    writer.write("</script>\n");
  }

}
