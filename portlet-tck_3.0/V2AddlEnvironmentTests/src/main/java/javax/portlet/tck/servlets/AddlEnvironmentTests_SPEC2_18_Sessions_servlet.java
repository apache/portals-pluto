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


package javax.portlet.tck.servlets;

import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_GETCREATIONTIME;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_GETID;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_GETLASTACCESSTIME;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_GETMAXINCTIVEINTERVAL;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_HTTPSESSION7;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_HTTPSESSION8;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_HTTPSESSION9;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_ISNEW;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_SETMAXINACTIVEINTERVAL;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.MimeResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletSession;
import javax.portlet.tck.beans.JSR286SpecTestCaseDetails;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.constants.Constants;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet for JSR 362 request dispatcher testing. Used by portlet:
 * AddlEnvironmentTests_SPEC2_18_Sessions
 *
 * @author ahmed
 *
 */
public class AddlEnvironmentTests_SPEC2_18_Sessions_servlet extends HttpServlet {
  private static final long serialVersionUID = 2L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    processTCKReq(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    processTCKReq(req, resp);
  }

  // The tck uses only get & post requests
  protected void processTCKReq(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    PortletRequest portletReq = (PortletRequest) request.getAttribute("javax.portlet.request");
    PortletResponse portletResp = (PortletResponse) request.getAttribute("javax.portlet.response");
    PortletSession portletSession = portletReq.getPortletSession();
    HttpSession httpSession = request.getSession();

    PrintWriter writer = ((MimeResponse) portletResp).getWriter();

    JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();

    /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_httpSession8 */
    /* Details: "The portlet session follows the timeout behavior of the */
    /* servlet session" */
    TestResult tr26 =
        tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_HTTPSESSION8);
    if (portletSession.getMaxInactiveInterval() == httpSession.getMaxInactiveInterval()) {
      tr26.setTcSuccess(true);
    } else {
      tr26.appendTcDetail(
          "Failed because timeout of portlet session and http session is different.");
    }
    tr26.writeTo(writer);

    /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_httpSession9 */
    /* Details: "The portlet session follows the last accessed times */
    /* behavior of the servlet session" */
    TestResult tr27 =
        tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_HTTPSESSION9);
    if (portletSession.getLastAccessedTime() == httpSession.getLastAccessedTime()) {
      tr27.setTcSuccess(true);
    } else {
      tr27.appendTcDetail(
          "Failed because last acces time of portlet session and http session is different.");
    }
    tr27.writeTo(writer);

    /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_getCreationTime */
    /* Details: "The PortletSession.getCreationTime method provides the */
    /* same functionality as the corresponding */
    /* HttpSession.getCreationTime method" */
    TestResult tr29 =
        tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_GETCREATIONTIME);
    if (portletSession.getCreationTime() == httpSession.getCreationTime()) {
      tr29.setTcSuccess(true);
    } else {
      tr29.appendTcDetail(
          "Failed because creation time of portlet session and http session is different.");
    }
    tr29.writeTo(writer);

    /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_getId */
    /* Details: "The PortletSession.getId method provides the same */
    /* functionality as the corresponding HttpSession.getId method" */
    TestResult tr30 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_GETID);
    if (portletSession.getId().equals(httpSession.getId())) {
      tr30.setTcSuccess(true);
    } else {
      tr30.appendTcDetail("Failed because id of portlet session and http session is different.");
    }
    tr30.writeTo(writer);

    /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_getLastAccessTime */
    /* Details: "The PortletSession.getLastAccessTime method provides the */
    /* same functionality as the corresponding */
    /* HttpSession.getLastAccessTime method" */
    TestResult tr31 =
        tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_GETLASTACCESSTIME);
    if (portletSession.getLastAccessedTime() == httpSession.getLastAccessedTime()) {
      tr31.setTcSuccess(true);
    } else {
      tr31.appendTcDetail(
          "Failed because last acces time of portlet session and http session is different.");
    }
    tr31.writeTo(writer);

    /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_getMaxInctiveInterval */
    /* Details: "The PortletSession.getMaxInctiveInterval method provides */
    /* the same functionality as the corresponding */
    /* HttpSession.getMaxInctiveInterval method" */
    TestResult tr32 =
        tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_GETMAXINCTIVEINTERVAL);
    if (portletSession.getMaxInactiveInterval() == httpSession.getMaxInactiveInterval()) {
      tr32.setTcSuccess(true);
    } else {
      tr32.appendTcDetail(
          "Failed because Max inactive time of portlet session and http session is different.");
    }
    tr32.writeTo(writer);

    /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_isNew */
    /* Details: "The PortletSession.isNew method provides the same */
    /* functionality as the corresponding HttpSession.isNew method" */
    TestResult tr34 = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_ISNEW);
    if (httpSession.isNew() == portletSession.isNew()) {
      tr34.setTcSuccess(true);
    } else {
      tr34.appendTcDetail(
          "Failed because isNew() of portlet session and http session returned different booleans.");
    }
    tr34.writeTo(writer);

    /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_setMaxInactiveInterval */
    /* Details: "The PortletSession.setMaxInactiveInterval method */
    /* provides the same functionality as the corresponding */
    /* HttpSession.setMaxInactiveInterval method" */
    TestResult tr35 =
        tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_SETMAXINACTIVEINTERVAL);
    portletSession.setMaxInactiveInterval(10);
    if (portletSession.getMaxInactiveInterval() == httpSession.getMaxInactiveInterval()) {
      tr35.setTcSuccess(true);
    } else {
      tr35.appendTcDetail("Failed because getMaxInactiveInterval() of PortletSession returned "
          + portletSession.getMaxInactiveInterval() + " while " + "HttpSession returned "
          + httpSession.getMaxInactiveInterval());
    }
    tr35.writeTo(writer);

    /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_httpSession1 */
    /* Details: "Data stored in the HttpSession by a servlet in the same */
    /* web application is accessible to portlets through the */
    /* PortletSession in APPLICATION_SCOPE" */
    httpSession.setAttribute(
        Constants.RESULT_ATTR_PREFIX + "AddlEnvironmentTests_SPEC2_18_Sessions_tr19", "true");

    /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_httpSession6 */
    /* Details: "The attribute names retrieved from the HttpSession must */
    /* be the same as those retrieve from the PortletSession if */
    /* APPLICATION_SCOPE scope is used" */
    httpSession.setAttribute(
        Constants.RESULT_ATTR_PREFIX + "AddlEnvironmentTests_SPEC2_18_Sessions_tr24", "true");

    /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_httpSession7 */
    /* Details: "The attribute names retrieved from the HttpSession must */
    /* have the speficied prefixing if PORTLET_SCOPE scope is used" */
    TestResult tr25 =
        tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_HTTPSESSION7);
    String tr25_success =
        (String) httpSession.getAttribute("javax.portlet.p." + portletReq.getWindowID() + "?"
            + Constants.RESULT_ATTR_PREFIX + "AddlEnvironmentTests_SPEC2_18_Sessions_tr25");
    if (tr25_success != null && tr25_success.equals("true")) {
      tr25.setTcSuccess(true);
    } else {
      tr25.appendTcDetail("Failed becuase there is no attribute with key \""
          + Constants.RESULT_ATTR_PREFIX + "AddlEnvironmentTests_SPEC2_18_Sessions_tr25\"");
    }
    tr25.writeTo(writer);

  }
}
