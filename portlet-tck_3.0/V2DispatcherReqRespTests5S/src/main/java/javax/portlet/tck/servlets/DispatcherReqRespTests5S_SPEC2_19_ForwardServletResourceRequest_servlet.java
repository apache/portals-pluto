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
 * Used by portlet: DispatcherReqRespTests5S_SPEC2_19_ForwardServletResourceRequest
 *
 * @author nick
 *
 */
public class DispatcherReqRespTests5S_SPEC2_19_ForwardServletResourceRequest_servlet extends HttpServlet {
   private static final String LOG_CLASS = 
         DispatcherReqRespTests5S_SPEC2_19_ForwardServletResourceRequest_servlet.class.getName();
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

      /* TestCase: V2DispatcherReqRespTests5S_SPEC2_19_ForwardServletResourceRequest_getInputStream */
      /* Details: "In a target servlet of a forward in the Resource phase,    */
      /* the method HttpServletRequest.getInputStream must provide the same   */
      /* functionality as ResourceRequest.getPortletInputStream"              */
      TestResult tr0 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETINPUTSTREAM);
      /* TODO: implement test */
      tr0.appendTcDetail("Not implemented.");
      tr0.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests5S_SPEC2_19_ForwardServletResourceRequest_setCharacterEncoding */
      /* Details: "In a target servlet of a forward in the Resource phase,    */
      /* the method HttpServletRequest.setCharacterEncoding must provide      */
      /* the same functionality as ResourceRequest.setCharacterEncoding"      */
      TestResult tr1 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_SETCHARACTERENCODING);
      /* TODO: implement test */
      tr1.appendTcDetail("Not implemented.");
      tr1.writeTo(writer);


   }
}
