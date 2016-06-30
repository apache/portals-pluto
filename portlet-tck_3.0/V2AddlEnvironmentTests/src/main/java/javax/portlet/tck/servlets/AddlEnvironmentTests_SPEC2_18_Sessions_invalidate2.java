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

import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_HTTPSESSION5;
import static javax.portlet.tck.constants.Constants.BUTTON_PARAM_NAME;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.MimeResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletSession;
import javax.portlet.PortletURL;
import javax.portlet.tck.beans.JSR286SpecTestCaseDetails;
import javax.portlet.tck.beans.TestLink;
import javax.portlet.tck.beans.TestResult;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet for JSR 362 request dispatcher testing. Used by portlet:
 * AddlEnvironmentTests_SPEC2_18_Sessions
 *
 * @author ahmed
 *
 */
@SuppressWarnings("deprecation")
public class AddlEnvironmentTests_SPEC2_18_Sessions_invalidate2 extends HttpServlet {
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
    

    PrintWriter writer = ((MimeResponse) portletResp).getWriter();

    JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();

    /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_httpSession5 */
    /* Details: "If the PortletSession object is invalidated by a */
    /* portlet, the portlet container must invalidate the associated */
    /* HttpSession object" */
    {
       String tcid = portletReq.getParameter(BUTTON_PARAM_NAME);
       if (tcid == null || !tcid.equals(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_HTTPSESSION5)) {
          
          // generate test link 
          
          PortletURL rurl = ((MimeResponse)portletResp).createRenderURL();
          rurl.setParameter(BUTTON_PARAM_NAME, V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_HTTPSESSION5);
          TestLink tl = new TestLink(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_HTTPSESSION5, rurl);
          tl.writeTo(writer);
       } else {
          
          // perform test
          
          TestResult result = tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_HTTPSESSION5);
          portletSession.invalidate();
          if (!request.isRequestedSessionIdValid()) {
            result.setTcSuccess(true);
          } else {
            result.appendTcDetail("Failed because session is not invalidated.");
          }
          result.writeTo(writer);
       }
    }
    
  }
}
