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
 * Used by portlet: DispatcherReqRespTests2_SPEC2_19_ForwardServletActionResponse
 *
 * @author nick
 *
 */
public class DispatcherReqRespTests2_SPEC2_19_ForwardServletActionResponse_servlet extends HttpServlet {
   private static final String LOG_CLASS = 
         DispatcherReqRespTests2_SPEC2_19_ForwardServletActionResponse_servlet.class.getName();
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

      StringWriter writer = new StringWriter();

      JSR286DispatcherReqRespTestCaseDetails tcd = new JSR286DispatcherReqRespTestCaseDetails();

      // Create result objects for the tests

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionResponse_addDateHeader */
      /* Details: "In a target servlet of a forward in the Action phase,      */
      /* the method HttpServletResponse.addDateHeader does not perform any    */
      /* operation"                                                           */
      TestResult tr0 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONRESPONSE_ADDDATEHEADER);
      /* TODO: implement test */
      tr0.appendTcDetail("Not implemented.");
      tr0.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionResponse_addHeader */
      /* Details: "In a target servlet of a forward in the Action phase,      */
      /* the method HttpServletResponse.addHeader does not perform any        */
      /* operation"                                                           */
      TestResult tr1 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONRESPONSE_ADDHEADER);
      /* TODO: implement test */
      tr1.appendTcDetail("Not implemented.");
      tr1.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionResponse_addIntHeader */
      /* Details: "In a target servlet of a forward in the Action phase,      */
      /* the method HttpServletResponse.addIntHeader does not perform any     */
      /* operation"                                                           */
      TestResult tr2 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONRESPONSE_ADDINTHEADER);
      /* TODO: implement test */
      tr2.appendTcDetail("Not implemented.");
      tr2.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionResponse_containsHeader */
      /* Details: "In a target servlet of a forward in the Action phase,      */
      /* the method HttpServletResponse.containsHeader must return false"     */
      TestResult tr3 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONRESPONSE_CONTAINSHEADER);
      try {
         boolean ok = response.containsHeader("Accept");
         tr3.setTcSuccess(ok == false);
      } catch(Exception e) {tr3.appendTcDetail(e.toString());}
      tr3.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionResponse_encodeRedirectURL1 */
      /* Details: "In a target servlet of a forward in the Action phase,      */
      /* the method HttpServletResponse.encodeRedirectURL must return null"   */
      TestResult tr4 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONRESPONSE_ENCODEREDIRECTURL1);
      try {
         String isval = response.encodeRedirectURL("http://www.cnn.com/");
         CompareUtils.stringsEqual(isval, null, tr4);
      } catch(Exception e) {tr4.appendTcDetail(e.toString());}
      tr4.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionResponse_encodeRedirectUrl */
      /* Details: "In a target servlet of a forward in the Action phase,      */
      /* the method HttpServletResponse.encodeRedirectUrl must return null"   */
      TestResult tr5 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONRESPONSE_ENCODEREDIRECTURL);
      try {
         String isval = response.encodeRedirectUrl("http://www.cnn.com/");
         CompareUtils.stringsEqual(isval, null, tr5);
      } catch(Exception e) {tr5.appendTcDetail(e.toString());}
      tr5.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionResponse_encodeURL1 */
      /* Details: "In a target servlet of a forward in the Action phase,      */
      /* the method HttpServletResponse.encodeURL must provide the same       */
      /* functionality as ActionResponse.encodeURL"                           */
      TestResult tr6 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONRESPONSE_ENCODEURL1);
      /* TODO: implement test */
      tr6.appendTcDetail("Not implemented.");
      tr6.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionResponse_encodeUrl */
      /* Details: "In a target servlet of a forward in the Action phase,      */
      /* the method HttpServletResponse.encodeUrl must provide the same       */
      /* functionality as ActionResponse.encodeURL"                           */
      TestResult tr7 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONRESPONSE_ENCODEURL);
      /* TODO: implement test */
      tr7.appendTcDetail("Not implemented.");
      tr7.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionResponse_flushBuffer */
      /* Details: "In a target servlet of a forward in the Action phase,      */
      /* the method HttpServletResponse.flushBuffer does not perform any      */
      /* operation"                                                           */
      TestResult tr8 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONRESPONSE_FLUSHBUFFER);
      /* TODO: implement test */
      tr8.appendTcDetail("Not implemented.");
      tr8.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionResponse_getBufferSize */
      /* Details: "In a target servlet of a forward in the Action phase,      */
      /* the method HttpServletResponse.getBufferSize must return 0"          */
      TestResult tr9 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONRESPONSE_GETBUFFERSIZE);
      try {
         int isval = response.getBufferSize();
         if (isval != 0) tr9.appendTcDetail("Returned value was: " + isval);
         tr9.setTcSuccess(isval == 0);
      } catch(Exception e) {tr9.appendTcDetail(e.toString());}
      tr9.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionResponse_getCharacterEncoding */
      /* Details: "In a target servlet of a forward in the Action phase,      */
      /* the method HttpServletResponse.getCharacterEncoding must return      */
      /* null"                                                                */
      TestResult tr10 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONRESPONSE_GETCHARACTERENCODING);
      try {
         String isval = response.getCharacterEncoding();
         CompareUtils.stringsEqual(isval, null, tr10);
      } catch(Exception e) {tr10.appendTcDetail(e.toString());}
      tr10.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionResponse_getContentType */
      /* Details: "In a target servlet of a forward in the Action phase,      */
      /* the method HttpServletResponse.getContentType must return null"      */
      TestResult tr11 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONRESPONSE_GETCONTENTTYPE);
      try {
         String isval = response.getContentType();
         CompareUtils.stringsEqual(isval, null, tr11);
      } catch(Exception e) {tr11.appendTcDetail(e.toString());}
      tr11.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionResponse_getLocale */
      /* Details: "In a target servlet of a forward in the Action phase,      */
      /* the method HttpServletResponse.getLocale must return null"           */
      TestResult tr12 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONRESPONSE_GETLOCALE);
      try {
         Locale loc = request.getLocale();
         if (loc != null) tr12.appendTcDetail("Locale is " + loc);
         tr12.setTcSuccess(loc == null);
      } catch(Exception e) {tr12.appendTcDetail(e.toString());}
      tr12.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionResponse_getOutputStream */
      /* Details: "In a target servlet of a forward in the Action phase,      */
      /* the method HttpServletResponse.getOutputStream must return an        */
      /* output stream that ignores all input"                                */
      TestResult tr13 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONRESPONSE_GETOUTPUTSTREAM);
      /* TODO: implement test */
      tr13.appendTcDetail("Not implemented.");
      tr13.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionResponse_getWriter */
      /* Details: "In a target servlet of a forward in the Action phase,      */
      /* the method HttpServletResponse.getWriter must return a writer that   */
      /* ignores all input"                                                   */
      TestResult tr14 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONRESPONSE_GETWRITER);
      /* TODO: implement test */
      tr14.appendTcDetail("Not implemented.");
      tr14.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionResponse_isCommitted */
      /* Details: "In a target servlet of a forward in the Action phase,      */
      /* the method HttpServletResponse.isCommitted must return false"        */
      TestResult tr15 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONRESPONSE_ISCOMMITTED);
      try {
         boolean ok = response.isCommitted();
         tr15.setTcSuccess(ok == false);
      } catch(Exception e) {tr15.appendTcDetail(e.toString());}
      tr15.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionResponse_reset */
      /* Details: "In a target servlet of a forward in the Action phase,      */
      /* the method HttpServletResponse.reset does not perform any            */
      /* operation"                                                           */
      TestResult tr16 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONRESPONSE_RESET);
      /* TODO: implement test */
      tr16.appendTcDetail("Not implemented.");
      tr16.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionResponse_resetBuffer */
      /* Details: "In a target servlet of a forward in the Action phase,      */
      /* the method HttpServletResponse.resetBuffer does not perform any      */
      /* operation"                                                           */
      TestResult tr17 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONRESPONSE_RESETBUFFER);
      /* TODO: implement test */
      tr17.appendTcDetail("Not implemented.");
      tr17.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionResponse_sendError */
      /* Details: "In a target servlet of a forward in the Action phase,      */
      /* the method HttpServletResponse.sendError does not perform any        */
      /* operation"                                                           */
      TestResult tr18 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONRESPONSE_SENDERROR);
      /* TODO: implement test */
      tr18.appendTcDetail("Not implemented.");
      tr18.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionResponse_sendRedirect */
      /* Details: "In a target servlet of a forward in the Action phase,      */
      /* the method HttpServletResponse.sendRedirect must provide the same    */
      /* functionality as ActionResponse.sendRedirect"                        */
      TestResult tr19 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONRESPONSE_SENDREDIRECT);
      /* TODO: implement test */
      tr19.appendTcDetail("Not implemented.");
      tr19.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionResponse_setBufferSize */
      /* Details: "In a target servlet of a forward in the Action phase,      */
      /* the method HttpServletResponse.setBufferSize does not perform any    */
      /* operation"                                                           */
      TestResult tr20 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONRESPONSE_SETBUFFERSIZE);
      /* TODO: implement test */
      tr20.appendTcDetail("Not implemented.");
      tr20.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionResponse_setCharacterEncoding */
      /* Details: "In a target servlet of a forward in the Action phase,      */
      /* the method HttpServletResponse.setCharacterEncoding does not         */
      /* perform any operation"                                               */
      TestResult tr21 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONRESPONSE_SETCHARACTERENCODING);
      /* TODO: implement test */
      tr21.appendTcDetail("Not implemented.");
      tr21.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionResponse_setContentLength */
      /* Details: "In a target servlet of a forward in the Action phase,      */
      /* the method HttpServletResponse.setContentLength does not perform     */
      /* any operation"                                                       */
      TestResult tr22 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONRESPONSE_SETCONTENTLENGTH);
      /* TODO: implement test */
      tr22.appendTcDetail("Not implemented.");
      tr22.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionResponse_setContentType */
      /* Details: "In a target servlet of a forward in the Action phase,      */
      /* the method HttpServletResponse.setContentType does not perform any   */
      /* operation"                                                           */
      TestResult tr23 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONRESPONSE_SETCONTENTTYPE);
      /* TODO: implement test */
      tr23.appendTcDetail("Not implemented.");
      tr23.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionResponse_setDateHeader */
      /* Details: "In a target servlet of a forward in the Action phase,      */
      /* the method HttpServletResponse.setDateHeader does not perform any    */
      /* operation"                                                           */
      TestResult tr24 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONRESPONSE_SETDATEHEADER);
      /* TODO: implement test */
      tr24.appendTcDetail("Not implemented.");
      tr24.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionResponse_setHeader */
      /* Details: "In a target servlet of a forward in the Action phase,      */
      /* the method HttpServletResponse.setHeader does not perform any        */
      /* operation"                                                           */
      TestResult tr25 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONRESPONSE_SETHEADER);
      /* TODO: implement test */
      tr25.appendTcDetail("Not implemented.");
      tr25.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionResponse_setIntHeader */
      /* Details: "In a target servlet of a forward in the Action phase,      */
      /* the method HttpServletResponse.setIntHeader does not perform any     */
      /* operation"                                                           */
      TestResult tr26 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONRESPONSE_SETINTHEADER);
      /* TODO: implement test */
      tr26.appendTcDetail("Not implemented.");
      tr26.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionResponse_setLocale */
      /* Details: "In a target servlet of a forward in the Action phase,      */
      /* the method HttpServletResponse.setLocale does not perform any        */
      /* operation"                                                           */
      TestResult tr27 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONRESPONSE_SETLOCALE);
      /* TODO: implement test */
      tr27.appendTcDetail("Not implemented.");
      tr27.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionResponse_setStatus */
      /* Details: "In a target servlet of a forward in the Action phase,      */
      /* the method HttpServletResponse.setStatus does not perform any        */
      /* operation"                                                           */
      TestResult tr28 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONRESPONSE_SETSTATUS);
      /* TODO: implement test */
      tr28.appendTcDetail("Not implemented.");
      tr28.writeTo(writer);

      request.getSession().setAttribute(
                   Constants.RESULT_ATTR_PREFIX + "DispatcherReqRespTests2_SPEC2_19_ForwardServletActionResponse",
                   writer.toString());

   }
}
