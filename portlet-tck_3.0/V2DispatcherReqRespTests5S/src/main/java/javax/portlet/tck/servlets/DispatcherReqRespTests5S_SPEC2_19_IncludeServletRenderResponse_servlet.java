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
import javax.portlet.tck.constants.*;
import static javax.portlet.tck.constants.Constants.*;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.*;

/**
 * Servlet for JSR 362 request dispatcher testing.
 * Used by portlet: DispatcherReqRespTests5S_SPEC2_19_IncludeServletRenderResponse
 *
 * @author nick
 *
 */
public class DispatcherReqRespTests5S_SPEC2_19_IncludeServletRenderResponse_servlet extends HttpServlet {
   private static final String LOG_CLASS = 
         DispatcherReqRespTests5S_SPEC2_19_IncludeServletRenderResponse_servlet.class.getName();
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
      long svtTid = Thread.currentThread().getId();
      long reqTid = (Long) portletReq.getAttribute(THREADID_ATTR);

      PrintWriter writer = ((MimeResponse)portletResp).getWriter();

      JSR286DispatcherReqRespTestCaseDetails tcd = new JSR286DispatcherReqRespTestCaseDetails();

      // Create result objects for the tests

      /* TestCase: V2DispatcherReqRespTests5S_SPEC2_19_IncludeServletRenderResponse_getOutputStream */
      /* Details: "In a target servlet of a include in the Render phase,      */
      /* the method HttpServletResponse.getOutputStream must provide the      */
      /* same functionality as RenderResponse.getPortletOutputStream"         */
      TestResult tr0 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDESERVLETRENDERRESPONSE_GETOUTPUTSTREAM);
      /* TODO: implement test */
      tr0.appendTcDetail("Not implemented.");
      tr0.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests5S_SPEC2_19_IncludeServletRenderResponse_sendError */
      /* Details: "In a target servlet of a include in the Render phase,      */
      /* the method HttpServletResponse.sendError does not perform any        */
      /* operation"                                                           */
      TestResult tr1 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDESERVLETRENDERRESPONSE_SENDERROR);
      /* TODO: implement test */
      tr1.appendTcDetail("Not implemented.");
      tr1.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests5S_SPEC2_19_IncludeServletRenderResponse_sendRedirect */
      /* Details: "In a target servlet of a include in the Render phase,      */
      /* the method HttpServletResponse.sendRedirect does not perform any     */
      /* operation"                                                           */
      TestResult tr2 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDESERVLETRENDERRESPONSE_SENDREDIRECT);
      /* TODO: implement test */
      tr2.appendTcDetail("Not implemented.");
      tr2.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests5S_SPEC2_19_IncludeServletRenderResponse_setCharacterEncoding */
      /* Details: "In a target servlet of a include in the Render phase,      */
      /* the method HttpServletResponse.setCharacterEncoding does not         */
      /* perform any operation"                                               */
      TestResult tr3 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDESERVLETRENDERRESPONSE_SETCHARACTERENCODING);
      /* TODO: implement test */
      tr3.appendTcDetail("Not implemented.");
      tr3.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests5S_SPEC2_19_IncludeServletRenderResponse_setContentLength */
      /* Details: "In a target servlet of a include in the Render phase,      */
      /* the method HttpServletResponse.setContentLength does not perform     */
      /* any operation"                                                       */
      TestResult tr4 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDESERVLETRENDERRESPONSE_SETCONTENTLENGTH);
      /* TODO: implement test */
      tr4.appendTcDetail("Not implemented.");
      tr4.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests5S_SPEC2_19_IncludeServletRenderResponse_setContentType */
      /* Details: "In a target servlet of a include in the Render phase,      */
      /* the method HttpServletResponse.setContentType does not perform any   */
      /* operation"                                                           */
      TestResult tr5 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDESERVLETRENDERRESPONSE_SETCONTENTTYPE);
      /* TODO: implement test */
      tr5.appendTcDetail("Not implemented.");
      tr5.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests5S_SPEC2_19_IncludeServletRenderResponse_setLocale */
      /* Details: "In a target servlet of a include in the Render phase,      */
      /* the method HttpServletResponse.setLocale does not perform any        */
      /* operation"                                                           */
      TestResult tr6 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDESERVLETRENDERRESPONSE_SETLOCALE);
      /* TODO: implement test */
      tr6.appendTcDetail("Not implemented.");
      tr6.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests5S_SPEC2_19_IncludeServletRenderResponse_setStatus */
      /* Details: "In a target servlet of a include in the Render phase,      */
      /* the method HttpServletResponse.setStatus does not perform any        */
      /* operation"                                                           */
      TestResult tr7 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDESERVLETRENDERRESPONSE_SETSTATUS);
      /* TODO: implement test */
      tr7.appendTcDetail("Not implemented.");
      tr7.writeTo(writer);


   }
}
