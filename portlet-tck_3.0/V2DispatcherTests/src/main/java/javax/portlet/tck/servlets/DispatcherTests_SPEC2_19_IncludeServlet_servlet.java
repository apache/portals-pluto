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

import java.io.*;
import java.util.*;
import java.util.logging.*;
import static java.util.logging.Logger.*;
import javax.portlet.*;
import javax.portlet.filter.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.portlet.tck.beans.*;
import javax.portlet.tck.constants.Constants;
import static javax.portlet.tck.constants.Constants.*;
import static javax.portlet.tck.beans.JSR286DispatcherTestCaseDetails.*;

/**
 * Servlet for JSR 362 request dispatcher testing.
 * Used by portlet: DispatcherTests_SPEC2_19_IncludeServlet
 *
 * @author nick
 *
 */
public class DispatcherTests_SPEC2_19_IncludeServlet_servlet extends HttpServlet {
   private static final String LOG_CLASS = 
         DispatcherTests_SPEC2_19_IncludeServlet_servlet.class.getName();
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
      PortletConfig portletConfig = (PortletConfig) request.getAttribute("javax.portlet.config");

      PrintWriter writer = ((MimeResponse)portletResp).getWriter();

      JSR286DispatcherTestCaseDetails tcd = new JSR286DispatcherTestCaseDetails();

      // Create result objects for the tests

      /* TestCase: SPEC2_19_IncludeServlet_invoke1                            */
      /* Details: "The PortletRequestDispatcher include method can include    */
      /* a target servlet "                                                   */
      TestResult tr0 = tcd.getTestResultFailed(SPEC2_19_INCLUDESERVLET_INVOKE1);
      /* TODO: implement test */
      tr0.writeTo(writer);

      /* TestCase: SPEC2_19_IncludeServlet_invoke2                            */
      /* Details: "Parameters to the include method for a target servlet      */
      /* can be the request and response classes from the portlet lifecyle    */
      /* method initiating the include"                                       */
      TestResult tr1 = tcd.getTestResultFailed(SPEC2_19_INCLUDESERVLET_INVOKE2);
      /* TODO: implement test */
      tr1.writeTo(writer);

      /* TestCase: SPEC2_19_IncludeServlet_invoke3                            */
      /* Details: "Parameters to the include method for a target servlet      */
      /* can be wrapped request and response classes from the portlet         */
      /* lifecyle method initiating the include"                              */
      TestResult tr2 = tcd.getTestResultFailed(SPEC2_19_INCLUDESERVLET_INVOKE3);
      /* TODO: implement test */
      tr2.writeTo(writer);

      /* TestCase: SPEC2_19_IncludeServlet_invoke4                            */
      /* Details: "The portlet container must invoke the target servlet in    */
      /* the same thread as the PortletRequestDispatcher include              */
      /* invocation"                                                          */
      TestResult tr3 = tcd.getTestResultFailed(SPEC2_19_INCLUDESERVLET_INVOKE4);
      /* TODO: implement test */
      tr3.writeTo(writer);

      /* TestCase: SPEC2_19_IncludeServlet_invoke5                            */
      /* Details: "The portlet can include multiple servlets during the       */
      /* same lifecycle method"                                               */
      TestResult tr4 = tcd.getTestResultFailed(SPEC2_19_INCLUDESERVLET_INVOKE5);
      /* TODO: implement test */
      tr4.writeTo(writer);

      /* TestCase: SPEC2_19_IncludeServlet_invoke6                            */
      /* Details: "The included servlet must be handled as an HTTP GET        */
      /* request"                                                             */
      TestResult tr5 = tcd.getTestResultFailed(SPEC2_19_INCLUDESERVLET_INVOKE6);
      /* TODO: implement test */
      tr5.writeTo(writer);

      /* TestCase: SPEC2_19_IncludeServlet_invoke7                            */
      /* Details: "The path elements of the request object exposed to the     */
      /* target servlet must reflect the path used to obtain the              */
      /* RequestDispatcher"                                                   */
      TestResult tr6 = tcd.getTestResultFailed(SPEC2_19_INCLUDESERVLET_INVOKE7);
      /* TODO: implement test */
      tr6.writeTo(writer);


   }
}
