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
 * Used by portlet: DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderResponse
 *
 * @author nick
 *
 */
public class DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderResponse_servlet extends HttpServlet {
   private static final String LOG_CLASS = 
         DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderResponse_servlet.class.getName();
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

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderResponse_containsHeader */
      /* Details: "In a target servlet of a forward in the Render phase,      */
      /* the method HttpServletResponse.containsHeader must return false"     */
      TestResult tr0 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERRESPONSE_CONTAINSHEADER);
      try {
         boolean ok = response.containsHeader("Accept");
         tr0.setTcSuccess(ok == false);
      } catch(Exception e) {tr0.appendTcDetail(e.toString());}
      tr0.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderResponse_encodeRedirectURL1 */
      /* Details: "In a target servlet of a forward in the Render phase,      */
      /* the method HttpServletResponse.encodeRedirectURL must return null"   */
      TestResult tr1 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERRESPONSE_ENCODEREDIRECTURL1);
      try {
         String isval = response.encodeRedirectURL("http://www.cnn.com/");
         CompareUtils.stringsEqual(isval, null, tr1);
      } catch(Exception e) {tr1.appendTcDetail(e.toString());}
      tr1.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderResponse_encodeRedirectUrl */
      /* Details: "In a target servlet of a forward in the Render phase,      */
      /* the method HttpServletResponse.encodeRedirectUrl must return null"   */
      TestResult tr2 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERRESPONSE_ENCODEREDIRECTURL);
      try {
         String isval = response.encodeRedirectUrl("http://www.cnn.com/");
         CompareUtils.stringsEqual(isval, null, tr2);
      } catch(Exception e) {tr2.appendTcDetail(e.toString());}
      tr2.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderResponse_encodeURL1 */
      /* Details: "In a target servlet of a forward in the Render phase,      */
      /* the method HttpServletResponse.encodeURL must provide the same       */
      /* functionality as RenderResponse.encodeURL"                           */
      TestResult tr3 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERRESPONSE_ENCODEURL1);
      /* TODO: implement test */
      tr3.appendTcDetail("Not implemented.");
      tr3.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderResponse_encodeUrl */
      /* Details: "In a target servlet of a forward in the Render phase,      */
      /* the method HttpServletResponse.encodeUrl must provide the same       */
      /* functionality as RenderResponse.encodeURL"                           */
      TestResult tr4 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERRESPONSE_ENCODEURL);
      /* TODO: implement test */
      tr4.appendTcDetail("Not implemented.");
      tr4.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderResponse_flushBuffer */
      /* Details: "In a target servlet of a forward in the Render phase,      */
      /* the method HttpServletResponse.flushBuffer must provide the same     */
      /* functionality as RenderResponse.flushBuffer"                         */
      TestResult tr5 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERRESPONSE_FLUSHBUFFER);
      /* TODO: implement test */
      tr5.appendTcDetail("Not implemented.");
      tr5.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderResponse_getBufferSize */
      /* Details: "In a target servlet of a forward in the Render phase,      */
      /* the method HttpServletResponse.getBufferSize must provide the same   */
      /* functionality as RenderResponse.getBufferSize"                       */
      TestResult tr6 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERRESPONSE_GETBUFFERSIZE);
      try {
         int hval = response.getBufferSize();
         int pval = ((MimeResponse)portletResp).getBufferSize();
         String str = "Value " + hval + " from " + "HttpServletResponse" + " does not equal value " + pval + " + RenderResponse";
         if (hval != pval) {
            tr6.appendTcDetail(str);
         }
         tr6.setTcSuccess(hval == pval);
      } catch(Exception e) {tr6.appendTcDetail(e.toString());}
      tr6.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderResponse_getCharacterEncoding */
      /* Details: "In a target servlet of a forward in the Render phase,      */
      /* the method HttpServletResponse.getCharacterEncoding must provide     */
      /* the same functionality as RenderResponse.getCharacterEncoding"       */
      TestResult tr7 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERRESPONSE_GETCHARACTERENCODING);
      try {
         String hval = response.getCharacterEncoding();
         String pval = ((MimeResponse)portletResp).getCharacterEncoding();
         CompareUtils.stringsEqual("HttpServletResponse", hval, "RenderResponse", pval, tr7);
      } catch(Exception e) {tr7.appendTcDetail(e.toString());}
      tr7.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderResponse_getContentType */
      /* Details: "In a target servlet of a forward in the Render phase,      */
      /* the method HttpServletResponse.getContentType must provide the       */
      /* same functionality as RenderResponse.getContentType"                 */
      TestResult tr8 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERRESPONSE_GETCONTENTTYPE);
      try {
         String hval = response.getContentType();
         String pval = ((MimeResponse)portletResp).getContentType();
         CompareUtils.stringsEqual("HttpServletResponse", hval, "RenderResponse", pval, tr8);
      } catch(Exception e) {tr8.appendTcDetail(e.toString());}
      tr8.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderResponse_getLocale */
      /* Details: "In a target servlet of a forward in the Render phase,      */
      /* the method HttpServletResponse.getLocale must provide the same       */
      /* functionality as RenderResponse.getLocale"                           */
      TestResult tr9 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERRESPONSE_GETLOCALE);
      try {
         Locale hl = response.getLocale();
         Locale pl = ((MimeResponse)portletResp).getLocale();
         String hval = hl.getDisplayName();
         String pval = pl.getDisplayName();
         CompareUtils.stringsEqual("HttpServletResponse", hval, "RenderResponse", pval, tr9);
      } catch(Exception e) {tr9.appendTcDetail(e.toString());}
      tr9.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderResponse_getOutputStream */
      /* Details: "In a target servlet of a forward in the Render phase,      */
      /* the method HttpServletResponse.getOutputStream must provide the      */
      /* same functionality as RenderResponse.getPortletOutputStream"         */
      TestResult tr10 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERRESPONSE_GETOUTPUTSTREAM);
      /* TODO: implement test */
      tr10.appendTcDetail("Not implemented.");
      tr10.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderResponse_isCommitted */
      /* Details: "In a target servlet of a forward in the Render phase,      */
      /* the method HttpServletResponse.isCommitted must provide the same     */
      /* functionality as RenderResponse.isCommitted"                         */
      TestResult tr11 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERRESPONSE_ISCOMMITTED);
      try {
         boolean hval = response.isCommitted();
         boolean pval = ((MimeResponse)portletResp).isCommitted();
         String str = "Value " + hval + " from " + "HttpServletResponse" + " does not equal value " + pval + " + RenderResponse";
         if (hval != pval) {
            tr11.appendTcDetail(str);
         }
         tr11.setTcSuccess(hval == pval);
      } catch(Exception e) {tr11.appendTcDetail(e.toString());}
      tr11.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderResponse_reset */
      /* Details: "In a target servlet of a forward in the Render phase,      */
      /* the method HttpServletResponse.reset must provide the same           */
      /* functionality as RenderResponse.reset"                               */
      TestResult tr12 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERRESPONSE_RESET);
      /* TODO: implement test */
      tr12.appendTcDetail("Not implemented.");
      tr12.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderResponse_resetBuffer */
      /* Details: "In a target servlet of a forward in the Render phase,      */
      /* the method HttpServletResponse.resetBuffer must provide the same     */
      /* functionality as RenderResponse.resetBuffer"                         */
      TestResult tr13 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERRESPONSE_RESETBUFFER);
      /* TODO: implement test */
      tr13.appendTcDetail("Not implemented.");
      tr13.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderResponse_sendError */
      /* Details: "In a target servlet of a forward in the Render phase,      */
      /* the method HttpServletResponse.sendError does not perform any        */
      /* operation"                                                           */
      TestResult tr14 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERRESPONSE_SENDERROR);
      /* TODO: implement test */
      tr14.appendTcDetail("Not implemented.");
      tr14.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderResponse_sendRedirect */
      /* Details: "In a target servlet of a forward in the Render phase,      */
      /* the method HttpServletResponse.sendRedirect does not perform any     */
      /* operation"                                                           */
      TestResult tr15 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERRESPONSE_SENDREDIRECT);
      /* TODO: implement test */
      tr15.appendTcDetail("Not implemented.");
      tr15.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderResponse_setBufferSize */
      /* Details: "In a target servlet of a forward in the Render phase,      */
      /* the method HttpServletResponse.setBufferSize must provide the same   */
      /* functionality as RenderResponse.setBufferSize"                       */
      TestResult tr16 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERRESPONSE_SETBUFFERSIZE);
      /* TODO: implement test */
      tr16.appendTcDetail("Not implemented.");
      tr16.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderResponse_setCharacterEncoding */
      /* Details: "In a target servlet of a forward in the Render phase,      */
      /* the method HttpServletResponse.setCharacterEncoding does not         */
      /* perform any operation"                                               */
      TestResult tr17 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERRESPONSE_SETCHARACTERENCODING);
      /* TODO: implement test */
      tr17.appendTcDetail("Not implemented.");
      tr17.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderResponse_setContentLength */
      /* Details: "In a target servlet of a forward in the Render phase,      */
      /* the method HttpServletResponse.setContentLength does not perform     */
      /* any operation"                                                       */
      TestResult tr18 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERRESPONSE_SETCONTENTLENGTH);
      /* TODO: implement test */
      tr18.appendTcDetail("Not implemented.");
      tr18.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderResponse_setContentType */
      /* Details: "In a target servlet of a forward in the Render phase,      */
      /* the method HttpServletResponse.setContentType must provide the       */
      /* same functionality as RenderResponse.setContentType"                 */
      TestResult tr19 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERRESPONSE_SETCONTENTTYPE);
      /* TODO: implement test */
      tr19.appendTcDetail("Not implemented.");
      tr19.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderResponse_setLocale */
      /* Details: "In a target servlet of a forward in the Render phase,      */
      /* the method HttpServletResponse.setLocale does not perform any        */
      /* operation"                                                           */
      TestResult tr20 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERRESPONSE_SETLOCALE);
      /* TODO: implement test */
      tr20.appendTcDetail("Not implemented.");
      tr20.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderResponse_setStatus */
      /* Details: "In a target servlet of a forward in the Render phase,      */
      /* the method HttpServletResponse.setStatus does not perform any        */
      /* operation"                                                           */
      TestResult tr21 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERRESPONSE_SETSTATUS);
      /* TODO: implement test */
      tr21.appendTcDetail("Not implemented.");
      tr21.writeTo(writer);


   }
}
