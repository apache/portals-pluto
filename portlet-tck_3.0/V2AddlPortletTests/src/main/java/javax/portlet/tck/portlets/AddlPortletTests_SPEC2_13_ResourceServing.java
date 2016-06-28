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
import java.util.Map;
import java.util.Map.Entry;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceServingPortlet;
import javax.portlet.ResourceURL;
import javax.portlet.tck.beans.JSR286SpecTestCaseDetails;
import javax.portlet.tck.beans.TestLink;
import javax.portlet.tck.beans.TestResult;

import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVING_RESOURCEURLS2;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVING_RESOURCEURLS4;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVING_RESOURCEURLS5;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVING_RESOURCEURLS6;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVING_RESOURCEURLS7;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVING_RESOURCEURLS8;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVING_RESOURCEURLS9;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined
 * in the /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate
 * the test case names defined in the additionalTCs.xml file into the complete list of test case
 * names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will
 * initiate the events, but not process them. The processing is done in the companion portlet
 * AddlPortletTests_SPEC2_13_ResourceServing_event
 * @author ahmed
 */
public class AddlPortletTests_SPEC2_13_ResourceServing implements Portlet, ResourceServingPortlet {

  private boolean tr0_action = false;

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
    tr0_action = true;
  }

  @Override
  public void serveResource(ResourceRequest portletReq, ResourceResponse portletResp)
      throws PortletException, IOException {
    JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();
    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

    PrintWriter writer = portletResp.getWriter();

    String action = portletReq.getParameter("action");

    if (action != null) {
      if (action.equals("V2AddlPortletTests_SPEC2_13_ResourceServing_resourceURLs2")) {
        /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServing_resourceURLs2 */
        /* Details: "When a resource URL is invoked, the portlet container */
        /* must not call the processAction method" */
        TestResult tr0 =
            tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVING_RESOURCEURLS2);
        if (!tr0_action) {
          tr0.setTcSuccess(true);
        } else {
          tr0.appendTcDetail("Failed because processAction method called by resourceURL");
        }
        tr0.writeTo(writer);
      } else if (action.equals("V2AddlPortletTests_SPEC2_13_ResourceServing_resourceURLs4")) {
        /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServing_resourceURLs4 */
        /* Details: "After a resource URL has been created, the portlet mode */
        /* set on the resource URL cannot be changed" */
        TestResult tr1 =
            tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVING_RESOURCEURLS4);
        tr1.setTcSuccess(true);
        tr1.appendTcDetail("No method to change portlet mode in ResourceResponse. Current mode is "
            + portletReq.getPortletMode());
        tr1.writeTo(writer);
      } else if (action.equals("V2AddlPortletTests_SPEC2_13_ResourceServing_resourceURLs5")) {
        /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServing_resourceURLs5 */
        /* Details: "After a resource URL has been created, the window state */
        /* set on the resource URL cannot be changed" */
        TestResult tr2 =
            tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVING_RESOURCEURLS5);
        tr2.setTcSuccess(true);
        tr2.appendTcDetail("No method to change window state in ResourceResponse. Current state is "
            + portletReq.getWindowState());
        tr2.writeTo(writer);
      } else if (action.equals("V2AddlPortletTests_SPEC2_13_ResourceServing_resourceURLs6")) {
        /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServing_resourceURLs6 */
        /* Details: "After a resource URL has been created, the render */
        /* parameters set on the resource URL cannot be changed" */
        TestResult tr3 =
            tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVING_RESOURCEURLS6);
        if (portletReq.getParameter("tr3") != null
            && portletReq.getParameter("tr3").equals("true")) {
          tr3.setTcSuccess(true);
          tr3.appendTcDetail("No method to modify render parameter in ResourceResponse");
        } else {
          tr3.appendTcDetail("Failed - did not recieve render parameter tr3");
        }
        tr3.writeTo(writer);
      } else if (action.equals("V2AddlPortletTests_SPEC2_13_ResourceServing_resourceURLs7")) {
        /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServing_resourceURLs7 */
        /* Details: "After a resource URL has been created, a parameter set */
        /* on the resource URL is a resource parameter, not a render */
        /* parameter" */
        TestResult tr4 =
            tcd.getTestResultSucceeded(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVING_RESOURCEURLS7);
        if (portletReq.getParameter("tr4_resource") != null
            && portletReq.getParameter("tr4_resource").equals("true")) {
          Map<String, String[]> map = portletReq.getPrivateRenderParameterMap();
          for (Entry<String, String[]> entry : map.entrySet()) {
            String[] values = entry.getValue();
            for (String e : values) {
              if (entry.getKey().equals("tr4_resource") && e.equals("true")) {
                tr4.setTcSuccess(false);
                tr4.appendTcDetail("\"tr4\" is present as render parameter in ResourceRequest");
              }
            }
          }
        } else {
          tr4.appendTcDetail(
              "\"tr4_resource\" parameter is not present as resource parameter in ResourceRequest");
        }
        tr4.writeTo(writer);
      } else if (action.equals("V2AddlPortletTests_SPEC2_13_ResourceServing_resourceURLs8")) {
        /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServing_resourceURLs8 */
        /* Details: "After a resource URL has been created, a parameter set */
        /* on the URL with the same name as an existing render parameter */
        /* results in a multivalued parameter containing both the resource */
        /* parameter values and the render parameter values" */
        TestResult tr5 =
            tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVING_RESOURCEURLS8);
        if (portletReq.getParameterValues("tr5") != null
            && portletReq.getParameterValues("tr5").length == 2) {
          tr5.setTcSuccess(true);
        } else {
          tr5.appendTcDetail(
              "Failed because both resource parameter and the render parameter is not present");
        }
        tr5.writeTo(writer);
      } else if (action.equals("V2AddlPortletTests_SPEC2_13_ResourceServing_resourceURLs9")) {
        /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServing_resourceURLs9 */
        /* Details: "In the resulting multivalued parameter after a resource */
        /* parameter is added with the same name as a render parameter, the */
        /* the render parameter values must be the last entries in the */
        /* parameter value array" */
        TestResult tr6 =
            tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVING_RESOURCEURLS9);
        String tr6_value[] = portletReq.getParameterValues("tr6");
        if (tr6_value != null && tr6_value.length == 2 && tr6_value[0].equals("false")
            && tr6_value[1].equals("true")) {
          tr6.setTcSuccess(true);
        } else {
          tr6.appendTcDetail("Failed because render parameter value is not last.");
        }
        tr6.writeTo(writer);
      }
    }
  }

  @Override
  public void render(RenderRequest portletReq, RenderResponse portletResp)
      throws PortletException, IOException {

    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

    PrintWriter writer = portletResp.getWriter();

    writer.write("<script type=\"text/javascript\" id=\"getResourceCall\">");
    writer.write("  function getResource(testCase, URL) {");
    writer.write("    var xhr = new XMLHttpRequest();");
    writer.write("    xhr.onreadystatechange=function() {");
    writer.write("      if (xhr.readyState==4 && xhr.status==200) {");
    writer.write("        document.getElementById(testCase).innerHTML = xhr.responseText;");
    writer.write("      }");
    writer.write("    };");
    writer.write("    xhr.open(\"POST\",URL,true);");
    writer.write("    xhr.send();");
    writer.write("  }");
    writer.write("</script>");

    /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServing_resourceURLs2 */
    /* Details: "When a resource URL is invoked, the portlet container */
    /* must not call the processAction method" */
    {
      ResourceURL resurlTr0 = portletResp.createResourceURL();
      resurlTr0.setParameter("action", "V2AddlPortletTests_SPEC2_13_ResourceServing_resourceURLs2");
      writer.write("<DIV id=\"tr0_ResourceServing\"></DIV>");
      writer.write("<script type=\"text/javascript\">");
      writer.write("getResource('tr0_ResourceServing','" + resurlTr0.toString() + "');");
      writer.write("</script>");
    }

    /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServing_resourceURLs4 */
    /* Details: "After a resource URL has been created, the portlet mode */
    /* set on the resource URL cannot be changed" */
    {
      ResourceURL resurlTr1 = portletResp.createResourceURL();
      resurlTr1.setParameter("action", "V2AddlPortletTests_SPEC2_13_ResourceServing_resourceURLs4");
      writer.write("<DIV id=\"tr1_ResourceServing\"></DIV>");
      writer.write("<script type=\"text/javascript\">");
      writer.write("getResource('tr1_ResourceServing','" + resurlTr1.toString() + "');");
      writer.write("</script>");
    }

    /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServing_resourceURLs5 */
    /* Details: "After a resource URL has been created, the window state */
    /* set on the resource URL cannot be changed" */
    {
      ResourceURL resurlTr2 = portletResp.createResourceURL();
      resurlTr2.setParameter("action", "V2AddlPortletTests_SPEC2_13_ResourceServing_resourceURLs5");
      writer.write("<DIV id=\"tr2_ResourceServing\"></DIV>");
      writer.write("<script type=\"text/javascript\">");
      writer.write("getResource('tr2_ResourceServing','" + resurlTr2.toString() + "');");
      writer.write("</script>");
    }

    /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServing_resourceURLs6 */
    /* Details: "After a resource URL has been created, the render */
    /* parameters set on the resource URL cannot be changed" */
    {
      if (portletReq.getParameter("tr3") == null) {
        PortletURL purl = portletResp.createRenderURL();
        purl.setParameter("tr3", "true");
        TestLink tl =
            new TestLink(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVING_RESOURCEURLS6, purl);
        tl.writeTo(writer);
      } else {
        ResourceURL resurlTr3 = portletResp.createResourceURL();
        resurlTr3.setParameter("action",
            "V2AddlPortletTests_SPEC2_13_ResourceServing_resourceURLs6");
        writer.write("<DIV id=\"tr3_ResourceServing\"></DIV>");
        writer.write("<script type=\"text/javascript\">");
        writer.write("getResource('tr3_ResourceServing','" + resurlTr3.toString() + "');");
        writer.write("</script>");
      }
    }

    /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServing_resourceURLs7 */
    /* Details: "After a resource URL has been created, a parameter set */
    /* on the resource URL is a resource parameter, not a render */
    /* parameter" */
    {
      if (portletReq.getParameter("tr4") == null) {
        PortletURL purl = portletResp.createRenderURL();
        purl.setParameter("tr4", "true");
        TestLink tl =
            new TestLink(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVING_RESOURCEURLS7, purl);
        tl.writeTo(writer);
      } else {
        ResourceURL resurlTr4 = portletResp.createResourceURL();
        resurlTr4.setParameter("tr4_resource", "true");
        resurlTr4.setParameter("action",
            "V2AddlPortletTests_SPEC2_13_ResourceServing_resourceURLs7");
        writer.write("<DIV id=\"tr4_ResourceServing\"></DIV>");
        writer.write("<script type=\"text/javascript\">");
        writer.write("getResource('tr4_ResourceServing','" + resurlTr4.toString() + "');");
        writer.write("</script>");
      }
    }

    /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServing_resourceURLs8 */
    /* Details: "After a resource URL has been created, a parameter set */
    /* on the URL with the same name as an existing render parameter */
    /* results in a multivalued parameter containing both the resource */
    /* parameter values and the render parameter values" */
    {
      if (portletReq.getParameter("tr5") == null) {
        PortletURL purl = portletResp.createRenderURL();
        purl.setParameter("tr5", "true");
        TestLink tl =
            new TestLink(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVING_RESOURCEURLS8, purl);
        tl.writeTo(writer);
      } else {
        ResourceURL resurlTr5 = portletResp.createResourceURL();
        resurlTr5.setParameter("tr5", "false");
        resurlTr5.setParameter("action",
            "V2AddlPortletTests_SPEC2_13_ResourceServing_resourceURLs8");
        writer.write("<DIV id=\"tr5_ResourceServing\"></DIV>");
        writer.write("<script type=\"text/javascript\">");
        writer.write("getResource('tr5_ResourceServing','" + resurlTr5.toString() + "');");
        writer.write("</script>");
      }
    }

    /* TestCase: V2AddlPortletTests_SPEC2_13_ResourceServing_resourceURLs9 */
    /* Details: "In the resulting multivalued parameter after a resource */
    /* parameter is added with the same name as a render parameter, the */
    /* the render parameter values must be the last entries in the */
    /* parameter value array" */
    {
      if (portletReq.getParameter("tr6") == null) {
        PortletURL purl = portletResp.createRenderURL();
        purl.setParameter("tr6", "true");
        TestLink tl =
            new TestLink(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVING_RESOURCEURLS9, purl);
        tl.writeTo(writer);
      } else {
        ResourceURL resurlTr6 = portletResp.createResourceURL();
        resurlTr6.setParameter("tr6", "false");
        resurlTr6.setParameter("action",
            "V2AddlPortletTests_SPEC2_13_ResourceServing_resourceURLs9");
        writer.write("<DIV id=\"tr6_ResourceServing\"></DIV>");
        writer.write("<script type=\"text/javascript\">");
        writer.write("getResource('tr6_ResourceServing','" + resurlTr6.toString() + "');");
        writer.write("</script>");
      }
    }
  }

}
