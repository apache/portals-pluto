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

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceServingPortlet;
import javax.portlet.ResourceURL;
import javax.portlet.tck.beans.JSR286SpecTestCaseDetails;
import javax.portlet.tck.beans.TestResult;

import org.apache.commons.lang3.StringUtils;

import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLREQUESTTESTS_SPEC2_11_RESOURCEREQ_CONTENTTYPE1;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLREQUESTTESTS_SPEC2_11_RESOURCEREQ_CONTENTTYPE2;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLREQUESTTESTS_SPEC2_11_RESOURCEREQ_CONTENTTYPE3;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLREQUESTTESTS_SPEC2_11_RESOURCEREQ_WINDOWID4;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLREQUESTTESTS_SPEC2_11_RESOURCEREQ_CONTENTTYPE12;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLREQUESTTESTS_SPEC2_11_RESOURCEREQ_CONTENTTYPE13;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;
import static javax.portlet.ResourceURL.PAGE;
import static javax.portlet.PortletSession.APPLICATION_SCOPE;
import static javax.portlet.PortletSession.PORTLET_SCOPE;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined
 * in the /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate
 * the test case names defined in the additionalTCs.xml file into the complete list of test case
 * names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will
 * initiate the events, but not process them. The processing is done in the companion portlet
 * AddlRequestTests_SPEC2_11_ResourceReq_event
 * 
 * @author ahmed
 */
public class AddlRequestTests_SPEC2_11_ResourceReq implements Portlet, ResourceServingPortlet {

  @Override
  public void init(PortletConfig config) throws PortletException {}

  @Override
  public void destroy() {}

  @SuppressWarnings("deprecation")
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

    /* TestCase: V2AddlRequestTests_SPEC2_11_ResourceReq_contentType1 */
    /* Details: "The getResponseContentType method returns a String */
    /* representing the default content type the portlet container */
    /* assumes for the output" */
    TestResult tr0 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_RESOURCEREQ_CONTENTTYPE1);
    if (portletReq.getResponseContentType() != null
        && !portletReq.getResponseContentType().isEmpty())
      tr0.setTcSuccess(true);
    tr0.writeTo(writer);

    /* TestCase: V2AddlRequestTests_SPEC2_11_ResourceReq_contentType2 */
    /* Details: "The getResponseContentTypes method returns an */
    /* Enumeration of String elements representing the acceptable content */
    /* types for the output in order of preference" */
    TestResult tr1 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_RESOURCEREQ_CONTENTTYPE2);
    Enumeration<String> contentTypesTr1 = portletReq.getResponseContentTypes();
    if (contentTypesTr1 != null && contentTypesTr1.hasMoreElements()
        && !contentTypesTr1.nextElement().isEmpty())
      tr1.setTcSuccess(true);
    tr1.writeTo(writer);

    /* TestCase: V2AddlRequestTests_SPEC2_11_ResourceReq_contentType3 */
    /* Details: "The first element of the Enumeration returned by the */
    /* getResponseContentTypes method must equal the value returned by */
    /* the getResponseContentType method" */
    TestResult tr2 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_RESOURCEREQ_CONTENTTYPE3);
    if (portletReq.getResponseContentTypes().nextElement()
        .equals(portletReq.getResponseContentType()))
      tr2.setTcSuccess(true);
    tr2.writeTo(writer);

    /* TestCase: V2AddlRequestTests_SPEC2_11_ResourceReq_windowId4 */
    /* Details: "The string returned by getWindowID method must be the */
    /* same ID used for scoping portlet-scope session attributes" */
    TestResult tr5 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_RESOURCEREQ_WINDOWID4);
    portletReq.getPortletSession().setAttribute("tr5", portletReq.getWindowID(), PORTLET_SCOPE);
    String tr5SessionAttribute = (String) portletReq.getPortletSession()
        .getAttribute("javax.portlet.p." + portletReq.getWindowID() + "?tr5", APPLICATION_SCOPE);
    if (tr5SessionAttribute != null && tr5SessionAttribute.equals(portletReq.getWindowID())) {
      tr5.setTcSuccess(true);
    } else {
      tr5.appendTcDetail(
          "Couldn't find javax.portlet.p." + portletReq.getWindowID() + ".tr5 attribute");
    }
    tr5.writeTo(writer);

    /* TestCase: V2AddlRequestTests_SPEC2_11_ResourceReq_contentType12 */
    /* Details: "Within the serveResource method, the content type should */
    /* be based on the HTTP Accept header provided by the client" */
    TestResult tr6 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_RESOURCEREQ_CONTENTTYPE12);
    if (!StringUtils.containsIgnoreCase(portletReq.getResponseContentType(),
        portletReq.getCharacterEncoding()))
      tr6.setTcSuccess(true);
    tr6.writeTo(writer);

    /* TestCase: V2AddlRequestTests_SPEC2_11_ResourceReq_contentType13 */
    /* Details: "The character set of the response can be retrieved via */
    /* the RenderResponse.getCharacterEncoding method" */
    TestResult tr7 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_RESOURCEREQ_CONTENTTYPE13);
    if (portletReq.getCharacterEncoding() != null) {
      tr7.setTcSuccess(true);
    } else {
      tr7.appendTcDetail("getCharacterEncoding() returned null.");
    }
    tr7.writeTo(writer);

  }

  @Override
  public void render(RenderRequest portletReq, RenderResponse portletResp)
      throws PortletException, IOException {

    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

    PrintWriter writer = portletResp.getWriter();

    writer.write("<div id=\"AddlRequestTests_SPEC2_11_ResourceReq\">no resource output.</div>\n");
    ResourceURL resurl = portletResp.createResourceURL();
    resurl.setCacheability(PAGE);
    writer.write("<script>\n");
    writer.write("(function () {\n");
    writer.write("   var xhr = new XMLHttpRequest();\n");
    writer.write("   xhr.onreadystatechange=function() {\n");
    writer.write("      if (xhr.readyState==4 && xhr.status==200) {\n");
    writer.write(
        "         document.getElementById(\"AddlRequestTests_SPEC2_11_ResourceReq\").innerHTML=xhr.responseText;\n");
    writer.write("      }\n");
    writer.write("   };\n");
    writer.write("   xhr.open(\"GET\",\"" + resurl.toString() + "\",true);\n");
    writer.write("   xhr.send();\n");
    writer.write("})();\n");
    writer.write("</script>\n");
  }

}
