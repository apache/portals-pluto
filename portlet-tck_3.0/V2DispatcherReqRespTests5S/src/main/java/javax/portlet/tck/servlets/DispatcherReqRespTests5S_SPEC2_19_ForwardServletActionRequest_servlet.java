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

import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETINPUTSTREAM;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDSERVLETACTIONREQUEST_SETCHARACTERENCODING;

import java.io.IOException;
import java.io.StringWriter;

import javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.constants.Constants;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet for JSR 362 request dispatcher testing.
 * Used by portlet: DispatcherReqRespTests5S_SPEC2_19_ForwardServletActionRequest
 *
 * @author nick
 *
 */
public class DispatcherReqRespTests5S_SPEC2_19_ForwardServletActionRequest_servlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

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

      StringWriter writer = new StringWriter();

      JSR286DispatcherReqRespTestCaseDetails tcd = new JSR286DispatcherReqRespTestCaseDetails();

      // Create result objects for the tests

      /* TestCase: V2DispatcherReqRespTests5S_SPEC2_19_ForwardServletActionRequest_getInputStream */
      /* Details: "In a target servlet of a forward in the Action phase,      */
      /* the method HttpServletRequest.getInputStream must provide the same   */
      /* functionality as ActionRequest.getPortletInputStream"                */
      TestResult tr0 = tcd.getTestResultSucceeded(V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETINPUTSTREAM);
      tr0.appendTcDetail("Can't be implemented.");
      tr0.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests5S_SPEC2_19_ForwardServletActionRequest_setCharacterEncoding */
      /* Details: "In a target servlet of a forward in the Action phase,      */
      /* the method HttpServletRequest.setCharacterEncoding must provide      */
      /* the same functionality as ActionRequest.setCharacterEncoding"        */
      TestResult tr1 = tcd.getTestResultSucceeded(V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDSERVLETACTIONREQUEST_SETCHARACTERENCODING);
      tr1.appendTcDetail("Can't be implemented.");
      tr1.writeTo(writer);

      request.getSession().setAttribute(
                   Constants.RESULT_ATTR_PREFIX + "DispatcherReqRespTests5S_SPEC2_19_ForwardServletActionRequest",
                   writer.toString());

   }
}
