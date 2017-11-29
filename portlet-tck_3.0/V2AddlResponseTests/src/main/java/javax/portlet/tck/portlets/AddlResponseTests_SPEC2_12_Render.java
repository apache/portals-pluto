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
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLRESPONSETESTS_SPEC2_12_RENDER_CHARACTERENCODING4;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLRESPONSETESTS_SPEC2_12_RENDER_CONTENTTYPE5;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLRESPONSETESTS_SPEC2_12_RENDER_COOKIE10;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLRESPONSETESTS_SPEC2_12_RENDER_COOKIE11;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLRESPONSETESTS_SPEC2_12_RENDER_COOKIE12;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLRESPONSETESTS_SPEC2_12_RENDER_COOKIE8;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLRESPONSETESTS_SPEC2_12_RENDER_COOKIE9;
import static javax.portlet.tck.constants.Constants.RESULT_ATTR_PREFIX;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceURL;
import javax.portlet.tck.beans.JSR286SpecTestCaseDetails;
import javax.portlet.tck.beans.TestButton;
import javax.portlet.tck.beans.TestResult;
import javax.servlet.http.Cookie;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined
 * in the /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate
 * the test case names defined in the additionalTCs.xml file into the complete list of test case
 * names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will
 * initiate the events, but not process them. The processing is done in the companion portlet
 * AddlResponseTests_SPEC2_12_Render_event
 *
 */
public class AddlResponseTests_SPEC2_12_Render extends GenericPortlet {

  private static final String NON_STREAMING_BUFFERED_PORTAL_DETECTED =
    "<em>NON-STREAMING (BUFFERED) PORTAL DETECTED</em>";

  @Override
  public void processAction(ActionRequest portletReq, ActionResponse portletResp)
      throws PortletException, IOException {

    JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();

    String streamingPortalParam = portletReq.getParameter("streamingPortal");
    boolean streamingPortal = "true".equalsIgnoreCase(streamingPortalParam);

    if (streamingPortal) {
      portletResp.setRenderParameters(portletReq.getParameterMap());
    }

    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

    StringWriter writer = new StringWriter();

    /* TestCase: V2AddlResponseTests_SPEC2_12_Render_cookie9 */
    /* Details: "Cookies set during the Render phase should be available */
    /* to the portlet during a subsequent Action phase" */
    if (streamingPortal) {
      Cookie[] cookies = portletReq.getCookies();

      StringBuilder txt = new StringBuilder(128);
      txt.append("<p>Debug info:");
      txt.append("<br>");
      txt.append("# Cookies: ").append(cookies.length).append("<br>");
      TestResult tr1 =
          tcd.getTestResultFailed(V2ADDLRESPONSETESTS_SPEC2_12_RENDER_COOKIE9);
      for (Cookie c : cookies) {
        txt.append("Name: ").append(c.getName());
        txt.append(", Value: ").append(c.getValue()).append("<br>");
        if (c.getName().equals("render_tr1_cookie") &&
            c.getValue().equals("true")) {
          txt.append("<br>").append("Found my cookie!").append("<br>");
          c.setMaxAge(0);
          c.setValue("");
          tr1.setTcSuccess(true);
        }
      }
      tr1.writeTo(writer);
      txt.append("</p>");
      writer.append(txt.toString());
    }
    else {
      TestResult tr1 =
          tcd.getTestResultFailed(V2ADDLRESPONSETESTS_SPEC2_12_RENDER_COOKIE9);
      tr1.setTcSuccess(true);
      tr1.setTcDetail(NON_STREAMING_BUFFERED_PORTAL_DETECTED);
      tr1.writeTo(writer);
    }

    portletReq.getPortletSession().setAttribute(
        RESULT_ATTR_PREFIX + "AddlResponseTests_SPEC2_12_Render", writer.toString(),
        APPLICATION_SCOPE);

    portletResp.setRenderParameter("streamingPortal", Boolean.toString(streamingPortal));
  }

  @Override
  public void serveResource(ResourceRequest portletReq, ResourceResponse portletResp)
      throws PortletException, IOException {

    JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();

    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

    PrintWriter writer = portletResp.getWriter();
    String streamingPortalParam = portletReq.getParameter("streamingPortal");
    boolean streamingPortal = "true".equalsIgnoreCase(streamingPortalParam);

    /* TestCase: V2AddlResponseTests_SPEC2_12_Render_cookie8 */
    /* Details: "Cookies set during the Render phase should be available */
    /* to the portlet during the Resource phase" */
    if (streamingPortal) {
      Cookie[] cookies = portletReq.getCookies();

      StringBuilder txt = new StringBuilder(128);
      txt.append("<p>Debug info:");
      txt.append("<br>");
      txt.append("# Cookies: ").append(cookies.length).append("<br>");
      TestResult tr1 =
          tcd.getTestResultFailed(V2ADDLRESPONSETESTS_SPEC2_12_RENDER_COOKIE8);
      for (Cookie c : cookies) {
        txt.append("Name: ").append(c.getName());
        txt.append(", Value: ").append(c.getValue()).append("<br>");
        if (c.getName().equals("render_tr0_cookie") &&
            c.getValue().equals("true")) {
          txt.append("<br>").append("Found my cookie!").append("<br>");
          c.setMaxAge(0);
          c.setValue("");
          tr1.setTcSuccess(true);
        }
      }
      tr1.writeTo(writer);
      txt.append("</p>");
      writer.append(txt.toString());
    }
    else {
      TestResult tr1 =
          tcd.getTestResultFailed(V2ADDLRESPONSETESTS_SPEC2_12_RENDER_COOKIE8);
      tr1.setTcSuccess(true);
      tr1.setTcDetail(NON_STREAMING_BUFFERED_PORTAL_DETECTED);
      tr1.writeTo(writer);
    }
  }

  @Override
  public void render(RenderRequest renderRequest, RenderResponse renderResponse)
      throws PortletException, IOException {

    long tid = Thread.currentThread().getId();
    renderRequest.setAttribute(THREADID_ATTR, tid);

    JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();

    StringWriter writer = new StringWriter();

    Object renderPartAttribute = renderRequest.getAttribute(PortletRequest.RENDER_PART);
    boolean streamingPortal = (renderPartAttribute != null);

    if (!streamingPortal || "RENDER_MARKUP".equals(renderPartAttribute)) {
      PortletSession ps = renderRequest.getPortletSession();
      String msg =
          (String) ps.getAttribute(RESULT_ATTR_PREFIX + "AddlResponseTests_SPEC2_12_Render",
              APPLICATION_SCOPE);
      if (msg != null && !msg.equals("nullnull") && !msg.equals("null")) {
        writer.write("<p>" + msg + "</p><br/>\n");
        ps.removeAttribute(RESULT_ATTR_PREFIX + "AddlResponseTests_SPEC2_12_Render",
            APPLICATION_SCOPE);
      }
    }
    // Create result objects for the tests

    /* TestCase: V2AddlResponseTests_SPEC2_12_Render_cookie8 */
    /* Details: "Cookies set during the Render phase should be available */
    /* to the portlet during the Resource phase" */
    if ("RENDER_HEADERS".equals(renderPartAttribute)) {
      Cookie c = new Cookie("render_tr0_cookie", "true");
      c.setMaxAge(100);
      c.setPath("/");
      renderResponse.addProperty(c);
    } else {
      writer.write("<div id=\"AddlResponseTests_SPEC2_11_Render\">no resource output.</div>\n");
      ResourceURL resurl = renderResponse.createResourceURL();
      resurl.setParameter("streamingPortal", Boolean.toString(streamingPortal));
      resurl.setCacheability(PAGE);
      writer.write("<script>\n");
      writer.write("(function () {\n");
      writer.write("   var xhr = new XMLHttpRequest();\n");
      writer.write("   xhr.onreadystatechange=function() {\n");
      writer.write("      if (xhr.readyState==4 && xhr.status==200) {\n");
      writer.write(
          "         document.getElementById(\"AddlResponseTests_SPEC2_11_Render\").innerHTML=xhr.responseText;\n");
      writer.write("      }\n");
      writer.write("   };\n");
      writer.write("   xhr.open(\"GET\",\"" + resurl.toString() + "\",true);\n");
      writer.write("   xhr.send();\n");
      writer.write("})();\n");
      writer.write("</script>\n");
    }

    /* TestCase: V2AddlResponseTests_SPEC2_12_Render_cookie9 */
    /* Details: "Cookies set during the Render phase should be available */
    /* to the portlet during a subsequent Action phase" */
    if ("RENDER_HEADERS".equals(renderPartAttribute)) {
      Cookie c = new Cookie("render_tr1_cookie", "true");
      c.setMaxAge(100);
      c.setPath("/");
      renderResponse.addProperty(c);
    } else {
      PortletURL aurl = renderResponse.createActionURL();
      aurl.setParameters(renderRequest.getPrivateParameterMap());
      aurl.setParameter("streamingPortal", Boolean.toString(streamingPortal));
      TestButton tb = new TestButton(V2ADDLRESPONSETESTS_SPEC2_12_RENDER_COOKIE9, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2AddlResponseTests_SPEC2_12_Render_cookie10 */
    /* Details: "Cookies set during the Render phase should be available */
    /* to the portlet during a subsequent Render phase" */
    if (streamingPortal) {
      if ("RENDER_MARKUP".equals(renderPartAttribute)
          && renderRequest.getParameter("tr2") != null
          && renderRequest.getParameter("tr2").equals("true")) {
        Cookie[] cookies = renderRequest.getCookies();

        StringBuilder txt = new StringBuilder(128);
        txt.append("<p>Debug info:");
        txt.append("<br>");
        txt.append("# Cookies: ").append(cookies.length).append("<br>");
        TestResult tr2 = tcd.getTestResultFailed(
            V2ADDLRESPONSETESTS_SPEC2_12_RENDER_COOKIE10);
        for (Cookie c : cookies) {
          txt.append("Name: ").append(c.getName());
          txt.append(", Value: ").append(c.getValue()).append("<br>");
          if (c.getName().equals("render_tr2_cookie") &&
              c.getValue().equals("true")) {
            txt.append("<br>").append("Found my cookie!").append("<br>");
            c.setMaxAge(0);
            c.setValue("");
            tr2.setTcSuccess(true);
          }
        }
        tr2.writeTo(writer);
        txt.append("</p>");
        writer.append(txt.toString());
      }
      else {
        if ("RENDER_HEADERS".equals(renderPartAttribute)) {
          Cookie c = new Cookie("render_tr2_cookie", "true");
          c.setMaxAge(100);
          c.setPath("/");
          renderResponse.addProperty(c);
        }
        else {
          PortletURL rurl = renderResponse.createRenderURL();
          rurl.setParameters(renderRequest.getPrivateParameterMap());
          rurl.setParameter("tr2", "true");
          rurl.setParameter("streamingPortal", Boolean.toString(streamingPortal));
          TestButton tb =
              new TestButton(
                  V2ADDLRESPONSETESTS_SPEC2_12_RENDER_COOKIE10,
                  rurl);
          tb.writeTo(writer);
        }
      }
    } else {
      TestResult tr2 = tcd.getTestResultFailed(
          V2ADDLRESPONSETESTS_SPEC2_12_RENDER_COOKIE10);
      tr2.setTcSuccess(true);
      tr2.setTcDetail(NON_STREAMING_BUFFERED_PORTAL_DETECTED);
      tr2.writeTo(writer);
    }

    /* TestCase: V2AddlResponseTests_SPEC2_12_Render_cookie11 */
    /* Details: "Cookies set during the Render phase should be available */
    /* to the portlet during a subsequent request triggered by a URL" */
    if (streamingPortal) {
      if ("RENDER_MARKUP".equals(renderPartAttribute)
          && renderRequest.getParameter("tr3") != null
          && renderRequest.getParameter("tr3").equals("true")) {
        Cookie[] cookies = renderRequest.getCookies();

        StringBuilder txt = new StringBuilder(128);
        txt.append("<p>Debug info:");
        txt.append("<br>");
        txt.append("# Cookies: ").append(cookies.length).append("<br>");
        TestResult tr2 = tcd.getTestResultFailed(
            V2ADDLRESPONSETESTS_SPEC2_12_RENDER_COOKIE11);
        for (Cookie c : cookies) {
          txt.append("Name: ").append(c.getName());
          txt.append(", Value: ").append(c.getValue()).append("<br>");
          if (c.getName().equals("render_tr3_cookie") &&
              c.getValue().equals("true")) {
            txt.append("<br>").append("Found my cookie!").append("<br>");
            c.setMaxAge(0);
            c.setValue("");
            tr2.setTcSuccess(true);
          }
        }
        tr2.writeTo(writer);
        txt.append("</p>");
        writer.append(txt.toString());
      }
      else {
        if ("RENDER_HEADERS".equals(renderPartAttribute)) {
          Cookie c = new Cookie("render_tr3_cookie", "true");
          c.setMaxAge(100);
          c.setPath("/");
          renderResponse.addProperty(c);
        }
        else {
          PortletURL rurl = renderResponse.createRenderURL();
          rurl.setParameters(renderRequest.getPrivateParameterMap());
          rurl.setParameter("tr3", "true");
          rurl.setParameter("streamingPortal", Boolean.toString(streamingPortal));
          TestButton tb =
              new TestButton(V2ADDLRESPONSETESTS_SPEC2_12_RENDER_COOKIE11,
                  rurl);
          tb.writeTo(writer);
        }
      }
    }
    else {
      TestResult tr2 = tcd.getTestResultFailed(
          V2ADDLRESPONSETESTS_SPEC2_12_RENDER_COOKIE11);
      tr2.setTcSuccess(true);
      tr2.setTcDetail(NON_STREAMING_BUFFERED_PORTAL_DETECTED);
      tr2.writeTo(writer);
    }

    /* TestCase: V2AddlResponseTests_SPEC2_12_Render_contentType5 */
    /* Details: "If the setContentType method is not called before the */
    /* getWriter or getPortletOutputStream method is used, the portlet */
    /* container uses the content type returned by */
    /* getResponseContentType" */
    TestResult tr5 = tcd.getTestResultFailed(V2ADDLRESPONSETESTS_SPEC2_12_RENDER_CONTENTTYPE5);
    if (renderRequest.getResponseContentType() != null) {
      tr5.setTcSuccess(true);
      tr5.appendTcDetail("Content type is: " + renderRequest.getResponseContentType());
      if (!streamingPortal) {
        tr5.appendTcDetail(NON_STREAMING_BUFFERED_PORTAL_DETECTED);
      }
    }
    tr5.writeTo(writer);

    /* TestCase: V2AddlResponseTests_SPEC2_12_Render_characterEncoding4 */
    /* Details: "If the portlet does not set the character encoding, the */
    /* portlet container uses UTF-8 as the default character encoding" */
    TestResult tr8 =
        tcd.getTestResultFailed(V2ADDLRESPONSETESTS_SPEC2_12_RENDER_CHARACTERENCODING4);
    if (renderResponse.getCharacterEncoding().equals("UTF-8")) {
      tr8.setTcSuccess(true);
      if (!streamingPortal) {
        tr8.appendTcDetail(NON_STREAMING_BUFFERED_PORTAL_DETECTED);
      }
    } else {
      tr8.appendTcDetail(
          "Failed because default character encoding is " + renderResponse.getCharacterEncoding());
    }
    tr8.writeTo(writer);

    PrintWriter printWriter = renderResponse.getWriter();
    if (!streamingPortal || "RENDER_MARKUP".equals(renderPartAttribute)) {
      printWriter.write(writer.toString());
    }

    /* TestCase: V2AddlResponseTests_SPEC2_12_Render_cookie12 */
    /* Details: "Cookies set during the Render phase after the response */
    /* has been committed are ignored" */
    String streamingPortalRenderURLParam = renderRequest.getParameter("streamingPortal");
    String testName = renderRequest.getParameter("inputval");
    if (("V2AddlResponseTests_SPEC2_12_Render_cookie12".equals(testName) && "false".equals(streamingPortalRenderURLParam)) ||
        ("RENDER_MARKUP".equals(renderPartAttribute) && renderRequest.getParameter("tr4") != null && renderRequest.getParameter("tr4").equals("true"))) {

      if (streamingPortal) {
        Cookie[] cookies = renderRequest.getCookies();

        StringBuilder txt = new StringBuilder(128);
        txt.append("<p>Debug info:");
        txt.append("<br>");
        txt.append("# Cookies: ").append(cookies.length).append("<br>");
        TestResult tr2 = tcd.getTestResultSucceeded(
            V2ADDLRESPONSETESTS_SPEC2_12_RENDER_COOKIE12);
        for (Cookie c : cookies) {
          txt.append("Name: ").append(c.getName());
          txt.append(", Value: ").append(c.getValue()).append("<br>");
          if (c.getName().equals("tr4_cookie") && c.getValue().equals("true")) {
            txt.append("<br>").append(
                "Failed because still got the cookie!").append("<br>");
            c.setMaxAge(0);
            c.setValue("");
            tr2.setTcSuccess(false);
          }
        }
        tr2.writeTo(printWriter);
        txt.append("</p>");
        printWriter.append(txt.toString());
      }
      else {
        TestResult tr2 = tcd.getTestResultSucceeded(
            V2ADDLRESPONSETESTS_SPEC2_12_RENDER_COOKIE12);
        tr2.setTcSuccess(true);
        tr2.appendTcDetail(NON_STREAMING_BUFFERED_PORTAL_DETECTED);
        tr2.writeTo(printWriter);
      }
    } else {
      if (!streamingPortal || "RENDER_MARKUP".equals(renderPartAttribute)) {
        Cookie c = new Cookie("tr4_cookie", "true");
        c.setMaxAge(100);
        c.setPath("/");
        renderResponse.addProperty(c);
        PortletURL rurl = renderResponse.createRenderURL();
        rurl.setParameters(renderRequest.getPrivateParameterMap());
        rurl.setParameter("tr4", "true");
        rurl.setParameter("streamingPortal", Boolean.toString(streamingPortal));
        TestButton tb = new TestButton(V2ADDLRESPONSETESTS_SPEC2_12_RENDER_COOKIE12, rurl);
        tb.writeTo(printWriter);
      }
    }

  }

}
