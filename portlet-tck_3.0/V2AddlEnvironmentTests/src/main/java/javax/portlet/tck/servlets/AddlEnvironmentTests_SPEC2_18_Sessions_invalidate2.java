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

import java.io.*;
import java.util.logging.*;
import javax.portlet.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.portlet.tck.beans.*;
import javax.portlet.tck.constants.*;

import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_HTTPSESSION5;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_SETMAXINACTIVEINTERVAL;

/**
 * Servlet for JSR 362 request dispatcher testing. Used by portlet:
 * AddlEnvironmentTests_SPEC2_18_Sessions
 *
 * @author ahmed
 *
 */
public class AddlEnvironmentTests_SPEC2_18_Sessions_invalidate2 extends HttpServlet {
  /**
   * 
   */
  private static final long serialVersionUID = 2L;
  private static final String LOG_CLASS =
      AddlEnvironmentTests_SPEC2_18_Sessions_invalidate2.class.getName();
  private final Logger LOGGER = Logger.getLogger(LOG_CLASS);

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
    LOGGER.entering(LOG_CLASS, "servlet entry");

    PortletRequest portletReq = (PortletRequest) request.getAttribute("javax.portlet.request");
    PortletResponse portletResp = (PortletResponse) request.getAttribute("javax.portlet.response");
    PortletSession portletSession = portletReq.getPortletSession();
    HttpSession httpSession = request.getSession(false);

    PrintWriter writer = ((MimeResponse) portletResp).getWriter();

    JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();

    /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_httpSession5 */
    /* Details: "If the PortletSession object is invalidated by a */
    /* portlet, the portlet container must invalidate the associated */
    /* HttpSession object" */
    TestResult tr23 =
        tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_HTTPSESSION5);
    if(httpSession.isNew()){
      tr23.setTcSuccess(true);
    } else {
      tr23.appendTcDetail("Failed because session is not invalidated.");
    }
    tr23.writeTo(writer);
    
  }
}
