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

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderResponse_containsHeader */
      /* Details: "In a target jsp of a forward in the Render phase, the      */
      /* method HttpServletResponse.containsHeader must return false"         */
      TestResult tr0 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERRESPONSE_CONTAINSHEADER);
      try {
         boolean ok = response.containsHeader("Accept");
         tr0.setTcSuccess(ok == false);
      } catch(Exception e) {tr0.appendTcDetail(e.toString());}
      tr0.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderResponse_encodeRedirectURL1 */
      /* Details: "In a target jsp of a forward in the Render phase, the      */
      /* method HttpServletResponse.encodeRedirectURL must return null"       */
      TestResult tr1 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERRESPONSE_ENCODEREDIRECTURL1);
      try {
         String isval = response.encodeRedirectURL("http://www.cnn.com/");
         CompareUtils.stringsEqual(isval, null, tr1);
      } catch(Exception e) {tr1.appendTcDetail(e.toString());}
      tr1.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderResponse_encodeRedirectUrl */
      /* Details: "In a target jsp of a forward in the Render phase, the      */
      /* method HttpServletResponse.encodeRedirectUrl must return null"       */
      TestResult tr2 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERRESPONSE_ENCODEREDIRECTURL);
      try {
         String isval = response.encodeRedirectUrl("http://www.cnn.com/");
         CompareUtils.stringsEqual(isval, null, tr2);
      } catch(Exception e) {tr2.appendTcDetail(e.toString());}
      tr2.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderResponse_encodeURL1 */
      /* Details: "In a target jsp of a forward in the Render phase, the      */
      /* method HttpServletResponse.encodeURL must provide the same           */
      /* functionality as RenderResponse.encodeURL"                           */
      TestResult tr3 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERRESPONSE_ENCODEURL1);
      /* TODO: implement test */
      tr3.appendTcDetail("Not implemented.");
      tr3.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderResponse_encodeUrl */
      /* Details: "In a target jsp of a forward in the Render phase, the      */
      /* method HttpServletResponse.encodeUrl must provide the same           */
      /* functionality as RenderResponse.encodeURL"                           */
      TestResult tr4 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERRESPONSE_ENCODEURL);
      /* TODO: implement test */
      tr4.appendTcDetail("Not implemented.");
      tr4.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderResponse_flushBuffer */
      /* Details: "In a target jsp of a forward in the Render phase, the      */
      /* method HttpServletResponse.flushBuffer must provide the same         */
      /* functionality as RenderResponse.flushBuffer"                         */
      TestResult tr5 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERRESPONSE_FLUSHBUFFER);
      /* TODO: implement test */
      tr5.appendTcDetail("Not implemented.");
      tr5.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderResponse_getBufferSize */
      /* Details: "In a target jsp of a forward in the Render phase, the      */
      /* method HttpServletResponse.getBufferSize must provide the same       */
      /* functionality as RenderResponse.getBufferSize"                       */
      TestResult tr6 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERRESPONSE_GETBUFFERSIZE);
      /* TODO: implement test */
      tr6.appendTcDetail("Not implemented.");
      tr6.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderResponse_getCharacterEncoding */
      /* Details: "In a target jsp of a forward in the Render phase, the      */
      /* method HttpServletResponse.getCharacterEncoding must provide the     */
      /* same functionality as RenderResponse.getCharacterEncoding"           */
      TestResult tr7 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERRESPONSE_GETCHARACTERENCODING);
      /* TODO: implement test */
      tr7.appendTcDetail("Not implemented.");
      tr7.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderResponse_getContentType */
      /* Details: "In a target jsp of a forward in the Render phase, the      */
      /* method HttpServletResponse.getContentType must provide the same      */
      /* functionality as RenderResponse.getContentType"                      */
      TestResult tr8 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERRESPONSE_GETCONTENTTYPE);
      /* TODO: implement test */
      tr8.appendTcDetail("Not implemented.");
      tr8.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderResponse_getLocale */
      /* Details: "In a target jsp of a forward in the Render phase, the      */
      /* method HttpServletResponse.getLocale must provide the same           */
      /* functionality as RenderResponse.getLocale"                           */
      TestResult tr9 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERRESPONSE_GETLOCALE);
      try {
         Locale hl = response.getLocale();
         Locale pl = ((MimeResponse)portletResp).getLocale();
         CompareUtils.stringsEqual(hl.getDisplayName(), pl.getDisplayName(), tr9);
      } catch(Exception e) {tr9.appendTcDetail(e.toString());}
      tr9.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderResponse_getOutputStream */
      /* Details: "In a target jsp of a forward in the Render phase, the      */
      /* method HttpServletResponse.getOutputStream must provide the same     */
      /* functionality as RenderResponse.getPortletOutputStream"              */
      TestResult tr10 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERRESPONSE_GETOUTPUTSTREAM);
      /* TODO: implement test */
      tr10.appendTcDetail("Not implemented.");
      tr10.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderResponse_getWriter */
      /* Details: "In a target jsp of a forward in the Render phase, the      */
      /* method HttpServletResponse.getWriter must provide the same           */
      /* functionality as RenderResponse.getWriter"                           */
      TestResult tr11 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERRESPONSE_GETWRITER);
      /* TODO: implement test */
      tr11.appendTcDetail("Not implemented.");
      tr11.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderResponse_isCommitted */
      /* Details: "In a target jsp of a forward in the Render phase, the      */
      /* method HttpServletResponse.isCommitted must provide the same         */
      /* functionality as RenderResponse.isCommitted"                         */
      TestResult tr12 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERRESPONSE_ISCOMMITTED);
      /* TODO: implement test */
      tr12.appendTcDetail("Not implemented.");
      tr12.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderResponse_reset */
      /* Details: "In a target jsp of a forward in the Render phase, the      */
      /* method HttpServletResponse.reset must provide the same               */
      /* functionality as RenderResponse.reset"                               */
      TestResult tr13 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERRESPONSE_RESET);
      /* TODO: implement test */
      tr13.appendTcDetail("Not implemented.");
      tr13.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderResponse_resetBuffer */
      /* Details: "In a target jsp of a forward in the Render phase, the      */
      /* method HttpServletResponse.resetBuffer must provide the same         */
      /* functionality as RenderResponse.resetBuffer"                         */
      TestResult tr14 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERRESPONSE_RESETBUFFER);
      /* TODO: implement test */
      tr14.appendTcDetail("Not implemented.");
      tr14.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderResponse_sendError */
      /* Details: "In a target jsp of a forward in the Render phase, the      */
      /* method HttpServletResponse.sendError does not perform any            */
      /* operation"                                                           */
      TestResult tr15 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERRESPONSE_SENDERROR);
      /* TODO: implement test */
      tr15.appendTcDetail("Not implemented.");
      tr15.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderResponse_sendRedirect */
      /* Details: "In a target jsp of a forward in the Render phase, the      */
      /* method HttpServletResponse.sendRedirect does not perform any         */
      /* operation"                                                           */
      TestResult tr16 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERRESPONSE_SENDREDIRECT);
      /* TODO: implement test */
      tr16.appendTcDetail("Not implemented.");
      tr16.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderResponse_setBufferSize */
      /* Details: "In a target jsp of a forward in the Render phase, the      */
      /* method HttpServletResponse.setBufferSize must provide the same       */
      /* functionality as RenderResponse.setBufferSize"                       */
      TestResult tr17 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERRESPONSE_SETBUFFERSIZE);
      /* TODO: implement test */
      tr17.appendTcDetail("Not implemented.");
      tr17.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderResponse_setCharacterEncoding */
      /* Details: "In a target jsp of a forward in the Render phase, the      */
      /* method HttpServletResponse.setCharacterEncoding does not perform     */
      /* any operation"                                                       */
      TestResult tr18 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERRESPONSE_SETCHARACTERENCODING);
      /* TODO: implement test */
      tr18.appendTcDetail("Not implemented.");
      tr18.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderResponse_setContentLength */
      /* Details: "In a target jsp of a forward in the Render phase, the      */
      /* method HttpServletResponse.setContentLength does not perform any     */
      /* operation"                                                           */
      TestResult tr19 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERRESPONSE_SETCONTENTLENGTH);
      /* TODO: implement test */
      tr19.appendTcDetail("Not implemented.");
      tr19.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderResponse_setContentType */
      /* Details: "In a target jsp of a forward in the Render phase, the      */
      /* method HttpServletResponse.setContentType must provide the same      */
      /* functionality as RenderResponse.setContentType"                      */
      TestResult tr20 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERRESPONSE_SETCONTENTTYPE);
      /* TODO: implement test */
      tr20.appendTcDetail("Not implemented.");
      tr20.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderResponse_setLocale */
      /* Details: "In a target jsp of a forward in the Render phase, the      */
      /* method HttpServletResponse.setLocale does not perform any            */
      /* operation"                                                           */
      TestResult tr21 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERRESPONSE_SETLOCALE);
      /* TODO: implement test */
      tr21.appendTcDetail("Not implemented.");
      tr21.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderResponse_setStatus */
      /* Details: "In a target jsp of a forward in the Render phase, the      */
      /* method HttpServletResponse.setStatus does not perform any            */
      /* operation"                                                           */
      TestResult tr22 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERRESPONSE_SETSTATUS);
      /* TODO: implement test */
      tr22.appendTcDetail("Not implemented.");
      tr22.writeTo(writer);

%>
