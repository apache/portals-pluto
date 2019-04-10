/*  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

package javax.portlet.tck.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;

import javax.portlet.tck.beans.JSR286SpecTestCaseDetails;
import javax.portlet.tck.beans.TestLink;
import javax.portlet.tck.beans.TestResult;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLRESPONSETESTS_SPEC2_12_ACTION_REDIRECT12;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLRESPONSETESTS_SPEC2_12_ACTION_REDIRECT14;
import static javax.portlet.tck.constants.Constants.BUTTON_PARAM_NAME;
import static javax.portlet.tck.constants.Constants.SETUP_ID;
import static javax.portlet.tck.constants.Constants.TCKPAGE;

/**
 * Servlet to bounce a redirect back to the test page.
 * 
 * @author Scott Nicklous
 */
public class AddlResponseTests_SPEC_12_Action_servlet extends HttpServlet {
   private static final long serialVersionUID = 2L;

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      processTCKReq(req, resp);
   }

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      processTCKReq(req, resp);
   }

   // The tck uses only get & post requests
   protected void processTCKReq(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      // Setup for output
      response.setContentType("text/html");
      PrintWriter writer = response.getWriter();
      writer.write("<!DOCTYPE HTML><html><head></head><body>");
      JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();
      String tc = request.getParameter(BUTTON_PARAM_NAME);

      writer.write("<h1>Hi!</h1>");
      
      writer.write("<p>Parameters:");
      @SuppressWarnings("unchecked")
      Map<String, String[]> params = request.getParameterMap();
      for (String name : params.keySet()) {
         writer.append("<br>Name: ").append(name);
         String[] vals = params.get(name);
         writer.append(", values: ").append((vals == null) ? "null" : Arrays.toString(vals));
      }
      writer.write("</p>");

      /* TestCase: V2AddlResponseTests_SPEC2_12_Action_redirect12 */
      /* Details: "If a new private render parameter value is set on the */
      /* ActionResponse before the redirect, the new private render */
      /* parameter value must be set on the attached render URL" */
      if (tc != null && tc.equals(V2ADDLRESPONSETESTS_SPEC2_12_ACTION_REDIRECT12 + SETUP_ID)) {
         String tckpage = request.getParameter(TCKPAGE);
         if (tckpage != null) {
            TestLink link = new TestLink(V2ADDLRESPONSETESTS_SPEC2_12_ACTION_REDIRECT12, tckpage);
            link.writeTo(writer);
         } else {
            TestResult result = tcd.getTestResultFailed(V2ADDLRESPONSETESTS_SPEC2_12_ACTION_REDIRECT12);
            result.appendTcDetail("Link to TCK page could not be obtained.");
            result.writeTo(writer);
         }
      }
      
      /* TestCase: V2AddlResponseTests_SPEC2_12_Action_redirect14 */
      /* Details: "If a new public render parameter value is set on the */
      /* ActionResponse before the redirect, the new public render */
      /* parameter value must be set on the attached render URL" */
      if (tc != null && tc.equals(V2ADDLRESPONSETESTS_SPEC2_12_ACTION_REDIRECT14 + SETUP_ID)) {
         String tckpage = request.getParameter(TCKPAGE);
         if (tckpage != null) {
            TestLink link = new TestLink(V2ADDLRESPONSETESTS_SPEC2_12_ACTION_REDIRECT14, tckpage);
            link.writeTo(writer);
         } else {
            TestResult result = tcd.getTestResultFailed(V2ADDLRESPONSETESTS_SPEC2_12_ACTION_REDIRECT14);
            result.appendTcDetail("Link to TCK page could not be obtained.");
            result.writeTo(writer);
         }
      }

      writer.write("</body></html>");

   }
}
