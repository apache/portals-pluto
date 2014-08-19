<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0"  prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.io.*,java.util.*,java.util.logging.*" %>
<%@ page import="static java.util.logging.Logger.*" %>
<%@ page import="javax.portlet.*,javax.portlet.filter.*" %>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ page import="javax.portlet.tck.beans.*,javax.portlet.tck.constants.*" %>
<%@ page import="static javax.portlet.tck.constants.Constants.*" %>
<%@ page import="static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.*" %>
<%

      PortletRequest portletReq = (PortletRequest) request.getAttribute("javax.portlet.request");
      PortletResponse portletResp = (PortletResponse) request.getAttribute("javax.portlet.response");
      PortletConfig portletConfig = (PortletConfig) request.getAttribute("javax.portlet.config");
      long svtTid = Thread.currentThread().getId();
      long reqTid = (Long) portletReq.getAttribute(THREADID_ATTR);

      PrintWriter writer = ((MimeResponse)portletResp).getWriter();

      JSR286DispatcherReqRespTestCaseDetails tcd = new JSR286DispatcherReqRespTestCaseDetails();

      // Create result objects for the tests

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderResponse_addCookie */
      /* Details: "In a target jsp of a include in the Render phase, the      */
      /* method HttpServletResponse.addCookie does not perform any            */
      /* operation"                                                           */
      TestResult tr0 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERRESPONSE_ADDCOOKIE);
      /* TODO: implement test */
      tr0.appendTcDetail("Not implemented.");
      tr0.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderResponse_addDateHeader */
      /* Details: "In a target jsp of a include in the Render phase, the      */
      /* method HttpServletResponse.addDateHeader does not perform any        */
      /* operation"                                                           */
      TestResult tr1 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERRESPONSE_ADDDATEHEADER);
      /* TODO: implement test */
      tr1.appendTcDetail("Not implemented.");
      tr1.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderResponse_addHeader */
      /* Details: "In a target jsp of a include in the Render phase, the      */
      /* method HttpServletResponse.addHeader does not perform any            */
      /* operation"                                                           */
      TestResult tr2 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERRESPONSE_ADDHEADER);
      /* TODO: implement test */
      tr2.appendTcDetail("Not implemented.");
      tr2.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderResponse_addIntHeader */
      /* Details: "In a target jsp of a include in the Render phase, the      */
      /* method HttpServletResponse.addIntHeader does not perform any         */
      /* operation"                                                           */
      TestResult tr3 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERRESPONSE_ADDINTHEADER);
      /* TODO: implement test */
      tr3.appendTcDetail("Not implemented.");
      tr3.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderResponse_containsHeader */
      /* Details: "In a target jsp of a include in the Render phase, the      */
      /* method HttpServletResponse.containsHeader must return false"         */
      TestResult tr4 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERRESPONSE_CONTAINSHEADER);
      try {
         boolean ok = response.containsHeader("Accept");
         tr4.setTcSuccess(ok == false);
      } catch(Exception e) {tr4.appendTcDetail(e.toString());}
      tr4.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderResponse_encodeRedirectURL1 */
      /* Details: "In a target jsp of a include in the Render phase, the      */
      /* method HttpServletResponse.encodeRedirectURL must return null"       */
      TestResult tr5 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERRESPONSE_ENCODEREDIRECTURL1);
      try {
         String isval = response.encodeRedirectURL("http://www.cnn.com/");
         CompareUtils.stringsEqual(isval, null, tr5);
      } catch(Exception e) {tr5.appendTcDetail(e.toString());}
      tr5.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderResponse_encodeRedirectUrl */
      /* Details: "In a target jsp of a include in the Render phase, the      */
      /* method HttpServletResponse.encodeRedirectUrl must return null"       */
      TestResult tr6 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERRESPONSE_ENCODEREDIRECTURL);
      try {
         String isval = response.encodeRedirectUrl("http://www.cnn.com/");
         CompareUtils.stringsEqual(isval, null, tr6);
      } catch(Exception e) {tr6.appendTcDetail(e.toString());}
      tr6.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderResponse_encodeURL1 */
      /* Details: "In a target jsp of a include in the Render phase, the      */
      /* method HttpServletResponse.encodeURL must provide the same           */
      /* functionality as RenderResponse.encodeURL"                           */
      TestResult tr7 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERRESPONSE_ENCODEURL1);
      /* TODO: implement test */
      tr7.appendTcDetail("Not implemented.");
      tr7.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderResponse_encodeUrl */
      /* Details: "In a target jsp of a include in the Render phase, the      */
      /* method HttpServletResponse.encodeUrl must provide the same           */
      /* functionality as RenderResponse.encodeURL"                           */
      TestResult tr8 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERRESPONSE_ENCODEURL);
      /* TODO: implement test */
      tr8.appendTcDetail("Not implemented.");
      tr8.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderResponse_flushBuffer */
      /* Details: "In a target jsp of a include in the Render phase, the      */
      /* method HttpServletResponse.flushBuffer must provide the same         */
      /* functionality as RenderResponse.flushBuffer"                         */
      TestResult tr9 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERRESPONSE_FLUSHBUFFER);
      /* TODO: implement test */
      tr9.appendTcDetail("Not implemented.");
      tr9.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderResponse_getBufferSize */
      /* Details: "In a target jsp of a include in the Render phase, the      */
      /* method HttpServletResponse.getBufferSize must provide the same       */
      /* functionality as RenderResponse.getBufferSize"                       */
      TestResult tr10 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERRESPONSE_GETBUFFERSIZE);
      try {
         int hval = response.getBufferSize();
         int pval = ((MimeResponse)portletResp).getBufferSize();
         String str = "Value " + hval + " from " + "HttpServletResponse" + " does not equal value " + pval + " + RenderResponse";
         if (hval != pval) {
            tr10.appendTcDetail(str);
         }
         tr10.setTcSuccess(hval == pval);
      } catch(Exception e) {tr10.appendTcDetail(e.toString());}
      tr10.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderResponse_getCharacterEncoding */
      /* Details: "In a target jsp of a include in the Render phase, the      */
      /* method HttpServletResponse.getCharacterEncoding must provide the     */
      /* same functionality as RenderResponse.getCharacterEncoding"           */
      TestResult tr11 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERRESPONSE_GETCHARACTERENCODING);
      try {
         String hval = response.getCharacterEncoding();
         String pval = ((MimeResponse)portletResp).getCharacterEncoding();
         CompareUtils.stringsEqual("HttpServletResponse", hval, "RenderResponse", pval, tr11);
      } catch(Exception e) {tr11.appendTcDetail(e.toString());}
      tr11.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderResponse_getContentType */
      /* Details: "In a target jsp of a include in the Render phase, the      */
      /* method HttpServletResponse.getContentType must provide the same      */
      /* functionality as RenderResponse.getContentType"                      */
      TestResult tr12 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERRESPONSE_GETCONTENTTYPE);
      try {
         String hval = response.getContentType();
         String pval = ((MimeResponse)portletResp).getContentType();
         CompareUtils.stringsEqual("HttpServletResponse", hval, "RenderResponse", pval, tr12);
      } catch(Exception e) {tr12.appendTcDetail(e.toString());}
      tr12.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderResponse_getLocale */
      /* Details: "In a target jsp of a include in the Render phase, the      */
      /* method HttpServletResponse.getLocale must provide the same           */
      /* functionality as RenderResponse.getLocale"                           */
      TestResult tr13 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERRESPONSE_GETLOCALE);
      try {
         Locale hl = response.getLocale();
         Locale pl = ((MimeResponse)portletResp).getLocale();
         String hval = hl.getDisplayName();
         String pval = pl.getDisplayName();
         CompareUtils.stringsEqual("HttpServletResponse", hval, "RenderResponse", pval, tr13);
      } catch(Exception e) {tr13.appendTcDetail(e.toString());}
      tr13.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderResponse_getOutputStream */
      /* Details: "In a target jsp of a include in the Render phase, the      */
      /* method HttpServletResponse.getOutputStream must provide the same     */
      /* functionality as RenderResponse.getPortletOutputStream"              */
      TestResult tr14 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERRESPONSE_GETOUTPUTSTREAM);
      /* TODO: implement test */
      tr14.appendTcDetail("Not implemented.");
      tr14.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderResponse_isCommitted */
      /* Details: "In a target jsp of a include in the Render phase, the      */
      /* method HttpServletResponse.isCommitted must provide the same         */
      /* functionality as RenderResponse.isCommitted"                         */
      TestResult tr15 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERRESPONSE_ISCOMMITTED);
      try {
         boolean hval = response.isCommitted();
         boolean pval = ((MimeResponse)portletResp).isCommitted();
         String str = "Value " + hval + " from " + "HttpServletResponse" + " does not equal value " + pval + " + RenderResponse";
         if (hval != pval) {
            tr15.appendTcDetail(str);
         }
         tr15.setTcSuccess(hval == pval);
      } catch(Exception e) {tr15.appendTcDetail(e.toString());}
      tr15.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderResponse_reset */
      /* Details: "In a target jsp of a include in the Render phase, the      */
      /* method HttpServletResponse.reset must provide the same               */
      /* functionality as RenderResponse.reset"                               */
      TestResult tr16 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERRESPONSE_RESET);
      /* TODO: implement test */
      tr16.appendTcDetail("Not implemented.");
      tr16.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderResponse_resetBuffer */
      /* Details: "In a target jsp of a include in the Render phase, the      */
      /* method HttpServletResponse.resetBuffer must provide the same         */
      /* functionality as RenderResponse.resetBuffer"                         */
      TestResult tr17 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERRESPONSE_RESETBUFFER);
      /* TODO: implement test */
      tr17.appendTcDetail("Not implemented.");
      tr17.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderResponse_sendError */
      /* Details: "In a target jsp of a include in the Render phase, the      */
      /* method HttpServletResponse.sendError does not perform any            */
      /* operation"                                                           */
      TestResult tr18 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERRESPONSE_SENDERROR);
      /* TODO: implement test */
      tr18.appendTcDetail("Not implemented.");
      tr18.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderResponse_sendRedirect */
      /* Details: "In a target jsp of a include in the Render phase, the      */
      /* method HttpServletResponse.sendRedirect does not perform any         */
      /* operation"                                                           */
      TestResult tr19 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERRESPONSE_SENDREDIRECT);
      /* TODO: implement test */
      tr19.appendTcDetail("Not implemented.");
      tr19.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderResponse_setBufferSize */
      /* Details: "In a target jsp of a include in the Render phase, the      */
      /* method HttpServletResponse.setBufferSize must provide the same       */
      /* functionality as RenderResponse.setBufferSize"                       */
      TestResult tr20 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERRESPONSE_SETBUFFERSIZE);
      /* TODO: implement test */
      tr20.appendTcDetail("Not implemented.");
      tr20.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderResponse_setCharacterEncoding */
      /* Details: "In a target jsp of a include in the Render phase, the      */
      /* method HttpServletResponse.setCharacterEncoding does not perform     */
      /* any operation"                                                       */
      TestResult tr21 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERRESPONSE_SETCHARACTERENCODING);
      /* TODO: implement test */
      tr21.appendTcDetail("Not implemented.");
      tr21.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderResponse_setContentLength */
      /* Details: "In a target jsp of a include in the Render phase, the      */
      /* method HttpServletResponse.setContentLength does not perform any     */
      /* operation"                                                           */
      TestResult tr22 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERRESPONSE_SETCONTENTLENGTH);
      /* TODO: implement test */
      tr22.appendTcDetail("Not implemented.");
      tr22.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderResponse_setContentType */
      /* Details: "In a target jsp of a include in the Render phase, the      */
      /* method HttpServletResponse.setContentType does not perform any       */
      /* operation"                                                           */
      TestResult tr23 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERRESPONSE_SETCONTENTTYPE);
      /* TODO: implement test */
      tr23.appendTcDetail("Not implemented.");
      tr23.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderResponse_setDateHeader */
      /* Details: "In a target jsp of a include in the Render phase, the      */
      /* method HttpServletResponse.setDateHeader does not perform any        */
      /* operation"                                                           */
      TestResult tr24 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERRESPONSE_SETDATEHEADER);
      /* TODO: implement test */
      tr24.appendTcDetail("Not implemented.");
      tr24.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderResponse_setHeader */
      /* Details: "In a target jsp of a include in the Render phase, the      */
      /* method HttpServletResponse.setHeader does not perform any            */
      /* operation"                                                           */
      TestResult tr25 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERRESPONSE_SETHEADER);
      /* TODO: implement test */
      tr25.appendTcDetail("Not implemented.");
      tr25.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderResponse_setIntHeader */
      /* Details: "In a target jsp of a include in the Render phase, the      */
      /* method HttpServletResponse.setIntHeader does not perform any         */
      /* operation"                                                           */
      TestResult tr26 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERRESPONSE_SETINTHEADER);
      /* TODO: implement test */
      tr26.appendTcDetail("Not implemented.");
      tr26.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderResponse_setLocale */
      /* Details: "In a target jsp of a include in the Render phase, the      */
      /* method HttpServletResponse.setLocale does not perform any            */
      /* operation"                                                           */
      TestResult tr27 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERRESPONSE_SETLOCALE);
      /* TODO: implement test */
      tr27.appendTcDetail("Not implemented.");
      tr27.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderResponse_setStatus */
      /* Details: "In a target jsp of a include in the Render phase, the      */
      /* method HttpServletResponse.setStatus does not perform any            */
      /* operation"                                                           */
      TestResult tr28 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERRESPONSE_SETSTATUS);
      /* TODO: implement test */
      tr28.appendTcDetail("Not implemented.");
      tr28.writeTo(writer);

%>
