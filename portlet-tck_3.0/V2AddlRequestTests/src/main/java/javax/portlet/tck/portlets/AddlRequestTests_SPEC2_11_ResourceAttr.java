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
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceServingPortlet;
import javax.portlet.ResourceURL;
import javax.portlet.tck.beans.JSR286SpecTestCaseDetails;
import javax.portlet.tck.beans.TestResult;

import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLREQUESTTESTS_SPEC2_11_RESOURCEATTR_ATTRIBUTES1;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLREQUESTTESTS_SPEC2_11_RESOURCEATTR_ATTRIBUTES2;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLREQUESTTESTS_SPEC2_11_RESOURCEATTR_ATTRIBUTES9;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;
import static javax.portlet.ResourceURL.PAGE;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined
 * in the /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate
 * the test case names defined in the additionalTCs.xml file into the complete list of test case
 * names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will
 * initiate the events, but not process them. The processing is done in the companion portlet
 * AddlRequestTests_SPEC2_11_ResourceAttr_event
 * 
 * @author ahmed
 */
public class AddlRequestTests_SPEC2_11_ResourceAttr implements Portlet, ResourceServingPortlet {

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
  public void serveResource(ResourceRequest portletReq, ResourceResponse portletResp)
      throws PortletException, IOException {

    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

    PrintWriter writer = portletResp.getWriter();

    JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();

    // Create result objects for the tests

    /* TestCase: V2AddlRequestTests_SPEC2_11_ResourceAttr_attributes1 */
    /* Details: "The portlet can access a map with user information */
    /* attributes via the request attribute PortletRequest.USER_INFO" */
    TestResult tr0 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_RESOURCEATTR_ATTRIBUTES1);
    if (portletReq.getAttribute(PortletRequest.USER_INFO) != null) {
      tr0.setTcSuccess(true);
    }
    tr0.writeTo(writer);

    /* TestCase: V2AddlRequestTests_SPEC2_11_ResourceAttr_attributes2 */
    /* Details: "The PortletRequest.CCPP_PROFILE request attribute must */
    /* return a javax.ccpp.Profile based on the current portlet request" */
    TestResult tr1 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_RESOURCEATTR_ATTRIBUTES2);
    if (portletReq.getAttribute(PortletRequest.CCPP_PROFILE) != null) {
      tr1.setTcSuccess(true);
    }
    tr1.writeTo(writer);

    /* TestCase: V2AddlRequestTests_SPEC2_11_ResourceAttr_attributes9 */
    /* Details: "During resource processing, the LIFECYCLE_PHASE */
    /* (\"javax.portlet.lifecycle_phase\") attribute will contain the */
    /* string \"RESOURCE_PHASE\"" */
    TestResult tr2 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_RESOURCEATTR_ATTRIBUTES9);
    if (portletReq.getAttribute(PortletRequest.LIFECYCLE_PHASE).equals("RESOURCE_PHASE")) {
      tr2.setTcSuccess(true);
    }
    tr2.writeTo(writer);

  }

  @Override
  public void render(RenderRequest portletReq, RenderResponse portletResp)
      throws PortletException, IOException {

    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

    PrintWriter writer = portletResp.getWriter();

    writer.write("<div id=\"AddlRequestTests_SPEC2_11_ResourceAttr\">no resource output.</div>\n");
    ResourceURL resurl = portletResp.createResourceURL();
    resurl.setCacheability(PAGE);
    writer.write("<script>\n");
    writer.write("(function () {\n");
    writer.write("   var xhr = new XMLHttpRequest();\n");
    writer.write("   xhr.onreadystatechange=function() {\n");
    writer.write("      if (xhr.readyState==4 && xhr.status==200) {\n");
    writer.write(
        "         document.getElementById(\"AddlRequestTests_SPEC2_11_ResourceAttr\").innerHTML=xhr.responseText;\n");
    writer.write("      }\n");
    writer.write("   };\n");
    writer.write("   xhr.open(\"GET\",\"" + resurl.toString() + "\",true);\n");
    writer.write("   xhr.send();\n");
    writer.write("})();\n");
    writer.write("</script>\n");
  }

}
