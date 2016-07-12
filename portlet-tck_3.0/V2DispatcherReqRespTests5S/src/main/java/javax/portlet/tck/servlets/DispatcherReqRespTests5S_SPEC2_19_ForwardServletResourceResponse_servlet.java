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

import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDSERVLETRESOURCERESPONSE_GETOUTPUTSTREAM;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDSERVLETRESOURCERESPONSE_SENDERROR;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDSERVLETRESOURCERESPONSE_SENDREDIRECT;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDSERVLETRESOURCERESPONSE_SETCHARACTERENCODING;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDSERVLETRESOURCERESPONSE_SETCONTENTLENGTH;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDSERVLETRESOURCERESPONSE_SETCONTENTTYPE;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDSERVLETRESOURCERESPONSE_SETLOCALE;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.MimeResponse;
import javax.portlet.PortletResponse;
import javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails;
import javax.portlet.tck.beans.TestResult;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet for JSR 362 request dispatcher testing.
 * Used by portlet: DispatcherReqRespTests5S_SPEC2_19_ForwardServletResourceResponse
 *
 * @author nick
 *
 */
public class DispatcherReqRespTests5S_SPEC2_19_ForwardServletResourceResponse_servlet extends HttpServlet {
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

      PortletResponse portletResp = (PortletResponse) request.getAttribute("javax.portlet.response");

      PrintWriter writer = ((MimeResponse)portletResp).getWriter();

      JSR286DispatcherReqRespTestCaseDetails tcd = new JSR286DispatcherReqRespTestCaseDetails();

      // Create result objects for the tests

      /* TestCase: V2DispatcherReqRespTests5S_SPEC2_19_ForwardServletResourceResponse_getOutputStream */
      /* Details: "In a target servlet of a forward in the Resource phase,    */
      /* the method HttpServletResponse.getOutputStream must provide the      */
      /* same functionality as ResourceResponse.getPortletOutputStream"       */
      TestResult tr0 = tcd.getTestResultSucceeded(V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDSERVLETRESOURCERESPONSE_GETOUTPUTSTREAM);
      tr0.appendTcDetail("Can't be implemented.");
      tr0.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests5S_SPEC2_19_ForwardServletResourceResponse_sendError */
      /* Details: "In a target servlet of a forward in the Resource phase,    */
      /* the method HttpServletResponse.sendError does not perform any        */
      /* operation"                                                           */
      TestResult tr1 = tcd.getTestResultSucceeded(V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDSERVLETRESOURCERESPONSE_SENDERROR);
      tr1.appendTcDetail("Can't be implemented.");
      tr1.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests5S_SPEC2_19_ForwardServletResourceResponse_sendRedirect */
      /* Details: "In a target servlet of a forward in the Resource phase,    */
      /* the method HttpServletResponse.sendRedirect does not perform any     */
      /* operation"                                                           */
      TestResult tr2 = tcd.getTestResultSucceeded(V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDSERVLETRESOURCERESPONSE_SENDREDIRECT);
      tr2.appendTcDetail("Can't be implemented.");
      tr2.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests5S_SPEC2_19_ForwardServletResourceResponse_setCharacterEncoding */
      /* Details: "In a target servlet of a forward in the Resource phase,    */
      /* the method HttpServletResponse.setCharacterEncoding must provide     */
      /* the same functionality as ResourceResponse.setCharacterEncoding"     */
      TestResult tr3 = tcd.getTestResultSucceeded(V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDSERVLETRESOURCERESPONSE_SETCHARACTERENCODING);
      tr3.appendTcDetail("Can't be implemented.");
      tr3.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests5S_SPEC2_19_ForwardServletResourceResponse_setContentLength */
      /* Details: "In a target servlet of a forward in the Resource phase,    */
      /* the method HttpServletResponse.setContentLength must provide the     */
      /* same functionality as ResourceResponse.setContentLength"             */
      TestResult tr4 = tcd.getTestResultSucceeded(V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDSERVLETRESOURCERESPONSE_SETCONTENTLENGTH);
      tr4.appendTcDetail("Can't be implemented.");
      tr4.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests5S_SPEC2_19_ForwardServletResourceResponse_setContentType */
      /* Details: "In a target servlet of a forward in the Resource phase,    */
      /* the method HttpServletResponse.setContentType must provide the       */
      /* same functionality as ResourceResponse.setContentType"               */
      TestResult tr5 = tcd.getTestResultSucceeded(V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDSERVLETRESOURCERESPONSE_SETCONTENTTYPE);
      tr5.appendTcDetail("Can't be implemented.");
      tr5.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests5S_SPEC2_19_ForwardServletResourceResponse_setLocale */
      /* Details: "In a target servlet of a forward in the Resource phase,    */
      /* the method HttpServletResponse.setLocale must provide the same       */
      /* functionality as ResourceResponse.setLocale"                         */
      TestResult tr6 = tcd.getTestResultSucceeded(V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDSERVLETRESOURCERESPONSE_SETLOCALE);
      tr6.appendTcDetail("Can't be implemented.");
      tr6.writeTo(writer);


   }
}
