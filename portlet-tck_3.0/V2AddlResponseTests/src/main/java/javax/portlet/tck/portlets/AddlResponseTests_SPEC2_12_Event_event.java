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
import java.io.StringWriter;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.EventPortlet;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
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
import javax.servlet.http.Cookie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLRESPONSETESTS_SPEC2_12_EVENT_COOKIE5;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLRESPONSETESTS_SPEC2_12_EVENT_COOKIE6;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLRESPONSETESTS_SPEC2_12_EVENT_COOKIE7;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;
import static javax.portlet.tck.constants.Constants.RESULT_ATTR_PREFIX;
import static javax.portlet.PortletSession.APPLICATION_SCOPE;
import static javax.portlet.ResourceURL.PAGE;

/**
 * This is the event processing portlet for the test cases. This portlet processes events, but does
 * not publish them. Events are published in the main portlet for the test cases.
 */
public class AddlResponseTests_SPEC2_12_Event_event
    implements Portlet, EventPortlet, ResourceServingPortlet {

  private final Logger LOGGER = LoggerFactory.getLogger(AddlResponseTests_SPEC2_12_Event_event.class);

  @Override
  public void init(PortletConfig config) throws PortletException {}

  @Override
  public void destroy() {}

  @Override
  public void processAction(ActionRequest portletReq, ActionResponse portletResp)
      throws PortletException, IOException {
    LOGGER.trace("event companion processAction - ERROR!!");
  }

  @Override
  public void serveResource(ResourceRequest portletReq, ResourceResponse portletResp)
      throws PortletException, IOException {
    JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();
    PrintWriter writer = portletResp.getWriter();
    /* TestCase: V2AddlResponseTests_SPEC2_12_Event_cookie6 */
    /* Details: "Cookies set during the Event phase should be available */
    /* to the portlet during the Resource phase" */
    if (portletReq.getParameter("tr1") != null && portletReq.getParameter("tr1").equals("true")) {
      Cookie[] cookies = portletReq.getCookies();

      StringBuilder txt = new StringBuilder(128);
      txt.append("<p>Debug info:");
      txt.append("<br>");
      txt.append("# Cookies: ").append(cookies.length).append("<br>");
      TestResult tr1 = tcd.getTestResultFailed(V2ADDLRESPONSETESTS_SPEC2_12_EVENT_COOKIE6);
      for (Cookie c : cookies) {
        txt.append("Name: ").append(c.getName());
        txt.append(", Value: ").append(c.getValue()).append("<br>");
        if (c.getName().equals("event_tr1_cookie") && c.getValue().equals("true")) {
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
  }

  @Override
  public void processEvent(EventRequest portletReq, EventResponse portletResp)
      throws PortletException, IOException {

    portletResp.setRenderParameters(portletReq);

    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

    StringWriter writer = new StringWriter();

    JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();

    // Create result objects for the tests

    /* TestCase: V2AddlResponseTests_SPEC2_12_Event_cookie5 */
    /* Details: "Cookies set during the Event phase should be available */
    /* to the portlet during the Render phase" */
    {
      Cookie c = new Cookie("event_tr0_cookie", "true");
      c.setMaxAge(100);
      c.setPath("/");
      portletResp.addProperty(c);
      portletResp.setRenderParameter("tr0", "true");
    }

    /* TestCase: V2AddlResponseTests_SPEC2_12_Event_cookie6 */
    /* Details: "Cookies set during the Event phase should be available */
    /* to the portlet during the Resource phase" */
    {
      Cookie c = new Cookie("event_tr1_cookie", "true");
      c.setMaxAge(100);
      c.setPath("/");
      portletResp.addProperty(c);
      portletResp.setRenderParameter("tr1", "true");
    }

    /* TestCase: V2AddlResponseTests_SPEC2_12_Event_cookie7 */
    /* Details: "Cookies set during the Event phase should be available */
    /* to the portlet during a subsequent request triggered by a URL" */
    if (portletReq.getParameter("tr2") != null && portletReq.getParameter("tr2").equals("true")) {
      Cookie[] cookies = portletReq.getCookies();

      StringBuilder txt = new StringBuilder(128);
      txt.append("<p>Debug info:");
      txt.append("<br>");

      txt.append("# Cookies: ").append(cookies.length).append("<br>");
      TestResult tr2 = tcd.getTestResultFailed(V2ADDLRESPONSETESTS_SPEC2_12_EVENT_COOKIE7);
      for (Cookie c : cookies) {
        txt.append("Name: ").append(c.getName());
        txt.append(", Value: ").append(c.getValue()).append("<br>");
        if (c.getName().equals("event_tr2_cookie") && c.getValue().equals("true")) {
          txt.append("<br>").append("Found my cookie!").append("<br>");
          c.setMaxAge(0);
          c.setValue("");
          tr2.setTcSuccess(true);
        }
      }
      tr2.writeTo(writer);
      txt.append("</p>");
      writer.append(txt.toString());
    } else {
      Cookie c = new Cookie("event_tr2_cookie", "true");
      c.setMaxAge(100);
      c.setPath("/");
      portletResp.addProperty(c);
      portletResp.setRenderParameter("tr2", "true");
    }

    portletReq.getPortletSession().setAttribute(
        RESULT_ATTR_PREFIX + "AddlResponseTests_SPEC2_12_Event", writer.toString(),
        APPLICATION_SCOPE);

  }

  @Override
  public void render(RenderRequest portletReq, RenderResponse portletResp)
      throws PortletException, IOException {

    JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();

    portletResp.setContentType("text/html");
    PrintWriter writer = portletResp.getWriter();
    writer.write("<h3>Event Companion Portlet </h3>\n");
    writer.write("<p>AddlResponseTests_SPEC2_12_Event_event</p>\n");

    String msg = (String) portletReq.getPortletSession()
        .getAttribute(RESULT_ATTR_PREFIX + "AddlResponseTests_SPEC2_12_Event", APPLICATION_SCOPE);
    msg = (msg == null) ? "Not ready. click test case link." : msg;
    writer.write("<p>" + msg + "</p>\n");

    if (portletReq.getParameter("tr0") != null && portletReq.getParameter("tr0").equals("true")) {
      Cookie[] cookies = portletReq.getCookies();

      StringBuilder txt = new StringBuilder(128);
      txt.append("<p>Debug info:");
      txt.append("<br>");

      txt.append("# Cookies: ").append(cookies.length).append("<br>");
      TestResult tr0 = tcd.getTestResultFailed(V2ADDLRESPONSETESTS_SPEC2_12_EVENT_COOKIE5);
      for (Cookie c : cookies) {
        txt.append("Name: ").append(c.getName());
        txt.append(", Value: ").append(c.getValue()).append("<br>");
        if (c.getName().equals("event_tr0_cookie") && c.getValue().equals("true")) {
          txt.append("<br>").append("Found my cookie!").append("<br>");
          c.setMaxAge(0);
          c.setValue("");
          tr0.setTcSuccess(true);
        }
      }
      tr0.writeTo(writer);
      txt.append("</p>");
      writer.append(txt.toString());
    }

    if (portletReq.getParameter("tr1") != null && portletReq.getParameter("tr1").equals("true")) {
      writer.write("<div id=\"AddlResponseTests_SPEC2_11_Event\">no resource output.</div>\n");
      ResourceURL resurl = portletResp.createResourceURL();
      resurl.setCacheability(PAGE);
      writer.write("<script>\n");
      writer.write("(function () {\n");
      writer.write("   var xhr = new XMLHttpRequest();\n");
      writer.write("   xhr.onreadystatechange=function() {\n");
      writer.write("      if (xhr.readyState==4 && xhr.status==200) {\n");
      writer.write(
          "         document.getElementById(\"AddlResponseTests_SPEC2_11_Event\").innerHTML=xhr.responseText;\n");
      writer.write("      }\n");
      writer.write("   };\n");
      writer.write("   xhr.open(\"GET\",\"" + resurl.toString() + "\",true);\n");
      writer.write("   xhr.send();\n");
      writer.write("})();\n");
      writer.write("</script>\n");
    }

  }

}
