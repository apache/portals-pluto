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

import static javax.portlet.tck.beans.JSR286DispatcherTestCaseDetails.V2DISPATCHERTESTS4_SPEC2_19_INCLUDESERVLETRESOURCE_INVOKE3;
import static javax.portlet.tck.beans.JSR286DispatcherTestCaseDetails.V2DISPATCHERTESTS4_SPEC2_19_INCLUDESERVLETRESOURCE_INVOKE8;
import static javax.portlet.tck.constants.Constants.MULTIPLE_INCLUDE_ATTR;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.MimeResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.tck.beans.JSR286DispatcherTestCaseDetails;
import javax.portlet.tck.beans.TestResult;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet for JSR 362 request dispatcher testing. Used by portlet: DispatcherTests4_SPEC2_19_IncludeServletResource
 * 
 * @author nick
 * 
 */
public class DispatcherTests4_SPEC2_19_IncludeServletResource_servlet extends HttpServlet {

   /**
    * 
    */
   private static final long serialVersionUID = 1L;

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      processTCKReq(req, resp);
   }

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      processTCKReq(req, resp);
   }

   // The tck uses only get & post requests
   protected void processTCKReq(HttpServletRequest request, HttpServletResponse response) throws ServletException,
         IOException {

      PortletRequest portletReq = (PortletRequest) request.getAttribute("javax.portlet.request");
      PortletResponse portletResp = (PortletResponse) request.getAttribute("javax.portlet.response");
      request.getAttribute("javax.portlet.config");
      Thread.currentThread().getId();
      portletReq.getAttribute(THREADID_ATTR);

      PrintWriter writer = ((MimeResponse) portletResp).getWriter();

      JSR286DispatcherTestCaseDetails tcd = new JSR286DispatcherTestCaseDetails();

      // Create result objects for the tests

      /* TestCase: V2DispatcherTests4_SPEC2_19_IncludeServletResource_invoke3 */
      /* Details: "Parameters to the include method for a target servlet */
      /* can be wrapped request and response classes from the portlet */
      /* lifecyle method initiating the include" */
      TestResult tr0 = tcd.getTestResultFailed(V2DISPATCHERTESTS4_SPEC2_19_INCLUDESERVLETRESOURCE_INVOKE3);
      try {
         // If this gets executed, include worked.
         tr0.setTcSuccess(true);
      } catch (Exception e) {
         tr0.appendTcDetail(e.toString());
      }
      tr0.writeTo(writer);

      /* TestCase: V2DispatcherTests4_SPEC2_19_IncludeServletResource_invoke8 */
      /* Details: "The portlet can include multiple servlets during the */
      /* same lifecycle method" */
      TestResult tr1 = tcd.getTestResultFailed(V2DISPATCHERTESTS4_SPEC2_19_INCLUDESERVLETRESOURCE_INVOKE8);
      try {
         // Check the attribute to make sure the include servlet was really included
         String val = (String) request.getAttribute(MULTIPLE_INCLUDE_ATTR);
         tr1.setTcSuccess(val != null);
      } catch (Exception e) {
         tr1.appendTcDetail(e.toString());
      }
      tr1.writeTo(writer);

   }
}
