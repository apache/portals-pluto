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

import java.io.*;
import java.util.*;
import java.util.logging.*;
import static java.util.logging.Logger.*;
import javax.xml.namespace.QName;
import javax.portlet.*;
import javax.portlet.filter.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.portlet.tck.beans.*;
import javax.portlet.tck.constants.*;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.*;
import static javax.portlet.tck.constants.Constants.*;
import static javax.portlet.PortletSession.*;
import static javax.portlet.ResourceURL.*;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined
 * in the /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate
 * the test case names defined in the additionalTCs.xml file into the complete list of test case
 * names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will
 * initiate the events, but not process them. The processing is done in the companion portlet
 * AddlResponseTests_SPEC2_12_Resource_event
 *
 */
public class AddlResponseTests_SPEC2_12_Resource implements Portlet, ResourceServingPortlet {
  private static final String LOG_CLASS = AddlResponseTests_SPEC2_12_Resource.class.getName();
  private final Logger LOGGER = Logger.getLogger(LOG_CLASS);

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
    LOGGER.entering(LOG_CLASS, "main portlet processAction entry");

    JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();

    portletResp.setRenderParameters(portletReq.getParameterMap());
    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

    StringWriter writer = new StringWriter();
    /* TestCase: V2AddlResponseTests_SPEC2_12_Resource_cookie13 */
    /* Details: "Cookies set during the Resource phase should be */
    /* available to the portlet during a subsequent Action phase" */
    Cookie[] cookies = portletReq.getCookies();

    StringBuilder txt = new StringBuilder(128);
    txt.append("<p>Debug info:");
    txt.append("<br>");
    txt.append("# Cookies: ").append(cookies.length).append("<br>");
    TestResult tr0 = tcd.getTestResultFailed(V2ADDLRESPONSETESTS_SPEC2_12_RESOURCE_COOKIE13);
    for (Cookie c : cookies) {
      txt.append("Name: ").append(c.getName());
      txt.append(", Value: ").append(c.getValue()).append("<br>");
      if (c.getName().equals("resource_tr0_cookie") && c.getValue().equals("true")) {
        txt.append("<br>").append("Found my cookie!").append("<br>");
        c.setMaxAge(0);
        c.setValue("");
        tr0.setTcSuccess(true);
      }
    }
    tr0.writeTo(writer);
    txt.append("</p>");
    writer.append(txt.toString());

    portletReq.getPortletSession().setAttribute(
        Constants.RESULT_ATTR_PREFIX + "AddlResponseTests_SPEC2_12_Resource", writer.toString(),
        APPLICATION_SCOPE);
  }

  @Override
  public void serveResource(ResourceRequest portletReq, ResourceResponse portletResp)
      throws PortletException, IOException {
    LOGGER.entering(LOG_CLASS, "main portlet serveResource entry");
    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

    StringWriter writer = new StringWriter();

    JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();

    // Create result objects for the tests

    /* TestCase: V2AddlResponseTests_SPEC2_12_Resource_cookie13 */
    /* Details: "Cookies set during the Resource phase should be */
    /* available to the portlet during a subsequent Action phase" */
    {
      Cookie c = new Cookie("resource_tr0_cookie", "true");
      c.setMaxAge(100);
      c.setPath("/pluto/portal/V2AddlResponseTests");
      portletResp.addProperty(c);
    }

    /* TestCase: V2AddlResponseTests_SPEC2_12_Resource_cookie14 */
    /* Details: "Cookies set during the Resource phase should be */
    /* available to the portlet during a subsequent Resource phase" */
    {
      Cookie[] cookies = portletReq.getCookies();

      StringBuilder txt = new StringBuilder(128);
      txt.append("<p>Debug info:");
      txt.append("<br>");
      txt.append("# Cookies: ").append(cookies.length).append("<br>");
      TestResult tr1 = tcd.getTestResultFailed(V2ADDLRESPONSETESTS_SPEC2_12_RESOURCE_COOKIE14);
      for (Cookie c : cookies) {
        txt.append("Name: ").append(c.getName());
        txt.append(", Value: ").append(c.getValue()).append("<br>");
        if (c.getName().equals("resource_tr1_cookie") && c.getValue().equals("true")) {
          txt.append("<br>").append("Found my cookie!").append("<br>");
          c.setMaxAge(0);
          c.setValue("");
          tr1.setTcSuccess(true);
        } else {
          Cookie c1 = new Cookie("resource_tr1_cookie", "true");
          c1.setMaxAge(100);
          c1.setPath("/pluto/portal/V2AddlResponseTests");
          portletResp.addProperty(c1);
        }
      }
      tr1.writeTo(writer);
      txt.append("</p>");
      writer.append(txt.toString());
    }

    /* TestCase: V2AddlResponseTests_SPEC2_12_Resource_cookie15 */
    /* Details: "Cookies set during the Resource phase should be */
    /* available to the portlet during a subsequent Render phase" */
    {
      Cookie c = new Cookie("resource_tr2_cookie", "true");
      c.setMaxAge(100);
      c.setPath("/pluto/portal/V2AddlResponseTests");
      portletResp.addProperty(c);
    }

    /* TestCase: V2AddlResponseTests_SPEC2_12_Resource_cookie16 */
    /* Details: "Cookies set during the Resource phase should be */
    /* available to the portlet during a subsequent request triggered by */
    /* a URL" */
    {
      Cookie[] cookies = portletReq.getCookies();

      StringBuilder txt = new StringBuilder(128);
      txt.append("<p>Debug info:");
      txt.append("<br>");
      txt.append("# Cookies: ").append(cookies.length).append("<br>");
      TestResult tr3 = tcd.getTestResultFailed(V2ADDLRESPONSETESTS_SPEC2_12_RESOURCE_COOKIE16);
      for (Cookie c : cookies) {
        txt.append("Name: ").append(c.getName());
        txt.append(", Value: ").append(c.getValue()).append("<br>");
        if (c.getName().equals("resource_tr3_cookie") && c.getValue().equals("true")) {
          txt.append("<br>").append("Found my cookie!").append("<br>");
          c.setMaxAge(0);
          c.setValue("");
          tr3.setTcSuccess(true);
        } else {
          Cookie c1 = new Cookie("resource_tr3_cookie", "true");
          c1.setMaxAge(100);
          c1.setPath("/pluto/portal/V2AddlResponseTests");
          portletResp.addProperty(c1);
        }
      }
      tr3.writeTo(writer);
      txt.append("</p>");
      writer.append(txt.toString());
    }

    /* TestCase: V2AddlResponseTests_SPEC2_12_Resource_contentType5 */
    /* Details: "If the setContentType method is not called before the */
    /* getWriter or getPortletOutputStream method is used, the portlet */
    /* container uses the content type returned by */
    /* getResponseContentType" */
    TestResult tr5 = tcd.getTestResultFailed(V2ADDLRESPONSETESTS_SPEC2_12_RESOURCE_CONTENTTYPE5);
    if (portletReq.getResponseContentType() != null) {
      tr5.setTcSuccess(true);
      tr5.appendTcDetail("Content type is: " + portletReq.getResponseContentType());
    }
    tr5.writeTo(writer);

    /* TestCase: V2AddlResponseTests_SPEC2_12_Resource_characterEncoding4 */
    /* Details: "If the portlet does not set the character encoding, the */
    /* portlet container uses UTF-8 as the default character encoding" */
    TestResult tr8 =
        tcd.getTestResultFailed(V2ADDLRESPONSETESTS_SPEC2_12_RESOURCE_CHARACTERENCODING4);
    if (portletResp.getCharacterEncoding().equals("UTF-8")) {
      tr8.setTcSuccess(true);
    } else {
      tr8.appendTcDetail(
          "Failed because default character encoding is " + portletResp.getCharacterEncoding());
    }
    tr8.writeTo(writer);

    /* TestCase: V2AddlResponseTests_SPEC2_12_Resource_characterEncoding2 */
    /* Details: "The character encoding can be set via the setLocale */
    /* method and a locale-encoding-mapping-list mapping in the web.xml */
    /* deployment descriptor" */
    Locale loc = new Locale("en");
    portletResp.setLocale(loc);
    TestResult tr6 =
        tcd.getTestResultFailed(V2ADDLRESPONSETESTS_SPEC2_12_RESOURCE_CHARACTERENCODING2);
    if (portletResp.getCharacterEncoding().equals("iso-8859-16")) {
      tr6.setTcSuccess(true);
    } else {
      tr6.appendTcDetail("Failed because character encoding is not \"iso-8859-16\" but "
          + portletResp.getCharacterEncoding());
    }
    tr6.writeTo(writer);

    /* TestCase: V2AddlResponseTests_SPEC2_12_Resource_characterEncoding3 */
    /* Details: "The character encoding can be set via the setContentType */
    /* method if the given content type string provides a value for the */
    /* charset attribute" */
    TestResult tr7 =
        tcd.getTestResultFailed(V2ADDLRESPONSETESTS_SPEC2_12_RESOURCE_CHARACTERENCODING3);
    portletResp.setContentType("text/html;charset=utf-16");
    if (portletResp.getCharacterEncoding().equals("utf-16")) {
      tr7.setTcSuccess(true);
    } else {
      tr7.appendTcDetail("Failed because character encoding is not \"utf-16\" but "
          + portletResp.getCharacterEncoding());
    }
    tr7.writeTo(writer);

    PrintWriter printWriter = portletResp.getWriter();
    printWriter.write(writer.toString());

    /* TestCase: V2AddlResponseTests_SPEC2_12_Resource_cookie17 */
    /* Details: "Cookies set during the Resource phase after the response */
    /* has been committed are ignored" */
    {
      Cookie[] cookies = portletReq.getCookies();

      StringBuilder txt = new StringBuilder(128);
      txt.append("<p>Debug info:");
      txt.append("<br>");
      txt.append("# Cookies: ").append(cookies.length).append("<br>");
      TestResult tr4 = tcd.getTestResultSucceeded(V2ADDLRESPONSETESTS_SPEC2_12_RESOURCE_COOKIE17);
      for (Cookie c : cookies) {
        txt.append("Name: ").append(c.getName());
        txt.append(", Value: ").append(c.getValue()).append("<br>");
        if (c.getName().equals("resource_tr4_cookie") && c.getValue().equals("true")) {
          txt.append("<br>").append("Still got the cookie!").append("<br>");
          c.setMaxAge(0);
          c.setValue("");
          tr4.setTcSuccess(false);
        } else {
          Cookie c1 = new Cookie("resource_tr4_cookie", "true");
          c1.setMaxAge(100);
          c1.setPath("/pluto/portal/V2AddlResponseTests");
          portletResp.addProperty(c1);
        }
      }
      tr4.writeTo(printWriter);
      txt.append("</p>");
      printWriter.append(txt.toString());
    }


  }

  @Override
  public void render(RenderRequest portletReq, RenderResponse portletResp)
      throws PortletException, IOException {
    LOGGER.entering(LOG_CLASS, "main portlet render entry");

    JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();

    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

    PrintWriter writer = portletResp.getWriter();

    PortletSession ps = portletReq.getPortletSession();
    String msg =
        (String) ps.getAttribute(RESULT_ATTR_PREFIX + "AddlResponseTests_SPEC2_12_Resource",
            APPLICATION_SCOPE);
    if (msg != null && !msg.equals("nullnull") && !msg.equals("null")) {
      writer.write("<p>" + msg + "</p><br/>\n");
      ps.removeAttribute(RESULT_ATTR_PREFIX + "AddlResponseTests_SPEC2_12_Resource",
          APPLICATION_SCOPE);
    }

    writer.write("<div id=\"AddlResponseTests_SPEC2_12_Resource\">no resource output.</div>\n");
    ResourceURL resurl = portletResp.createResourceURL();
    resurl.setCacheability(PAGE);
    writer.write("<script>\n");
    writer.write("(function () {\n");
    writer.write("   var xhr = new XMLHttpRequest();\n");
    writer.write("   xhr.onreadystatechange=function() {\n");
    writer.write("      if (xhr.readyState==4 && xhr.status==200) {\n");
    writer.write(
        "         document.getElementById(\"AddlResponseTests_SPEC2_12_Resource\").innerHTML=xhr.responseText;\n");
    writer.write("      }\n");
    writer.write("   };\n");
    writer.write("   xhr.open(\"GET\",\"" + resurl.toString() + "\",true);\n");
    writer.write("   xhr.send();\n");
    writer.write("})();\n");
    writer.write("</script>\n");

    /* TestCase: V2AddlResponseTests_SPEC2_12_Resource_cookie13 */
    /* Details: "Cookies set during the Resource phase should be */
    /* available to the portlet during a subsequent Action phase" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton("V2AddlResponseTests_SPEC2_12_Resource_cookie13", aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2AddlResponseTests_SPEC2_12_Resource_cookie14 */
    /* Details: "Cookies set during the Resource phase should be */
    /* available to the portlet during a subsequent Resource phase" */
    {
      PortletURL rurl = portletResp.createRenderURL();
      rurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton("V2AddlResponseTests_SPEC2_12_Resource_cookie14", rurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2AddlResponseTests_SPEC2_12_Resource_cookie15 */
    /* Details: "Cookies set during the Resource phase should be */
    /* available to the portlet during a subsequent Resource phase" */
    if (portletReq.getParameter("tr2") != null && portletReq.getParameter("tr2").equals("true")) {
      Cookie[] cookies = portletReq.getCookies();
      StringBuilder txt = new StringBuilder(128);
      txt.append("<p>Debug info:");
      txt.append("<br>");
      txt.append("# Cookies: ").append(cookies.length).append("<br>");
      TestResult tr2 = tcd.getTestResultFailed(V2ADDLRESPONSETESTS_SPEC2_12_RESOURCE_COOKIE15);
      for (Cookie c : cookies) {
        txt.append("Name: ").append(c.getName());
        txt.append(", Value: ").append(c.getValue()).append("<br>");
        if (c.getName().equals("resource_tr2_cookie") && c.getValue().equals("true")) {
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
      PortletURL rurl = portletResp.createRenderURL();
      rurl.setParameters(portletReq.getPrivateParameterMap());
      rurl.setParameter("tr2", "true");
      TestButton tb = new TestButton("V2AddlResponseTests_SPEC2_12_Resource_cookie15", rurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2AddlResponseTests_SPEC2_12_Resource_cookie16 */
    /* Details: "Cookies set during the Resource phase should be */
    /* available to the portlet during a subsequent Resource phase" */
    {
      PortletURL rurl = portletResp.createRenderURL();
      rurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton("V2AddlResponseTests_SPEC2_12_Resource_cookie16", rurl);
      tb.writeTo(writer);
    }
  }

}
