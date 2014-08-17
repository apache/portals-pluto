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

      StringWriter writer = new StringWriter();

      JSR286DispatcherReqRespTestCaseDetails tcd = new JSR286DispatcherReqRespTestCaseDetails();

      // Create result objects for the tests

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventResponse_addDateHeader */
      /* Details: "In a target jsp of a forward in the Event phase, the       */
      /* method HttpServletResponse.addDateHeader does not perform any        */
      /* operation"                                                           */
      TestResult tr0 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTRESPONSE_ADDDATEHEADER);
      /* TODO: implement test */
      tr0.appendTcDetail("Not implemented.");
      tr0.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventResponse_addHeader */
      /* Details: "In a target jsp of a forward in the Event phase, the       */
      /* method HttpServletResponse.addHeader does not perform any            */
      /* operation"                                                           */
      TestResult tr1 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTRESPONSE_ADDHEADER);
      /* TODO: implement test */
      tr1.appendTcDetail("Not implemented.");
      tr1.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventResponse_addIntHeader */
      /* Details: "In a target jsp of a forward in the Event phase, the       */
      /* method HttpServletResponse.addIntHeader does not perform any         */
      /* operation"                                                           */
      TestResult tr2 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTRESPONSE_ADDINTHEADER);
      /* TODO: implement test */
      tr2.appendTcDetail("Not implemented.");
      tr2.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventResponse_containsHeader */
      /* Details: "In a target jsp of a forward in the Event phase, the       */
      /* method HttpServletResponse.containsHeader must return false"         */
      TestResult tr3 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTRESPONSE_CONTAINSHEADER);
      try {
         boolean ok = response.containsHeader("Accept");
         tr3.setTcSuccess(ok == false);
      } catch(Exception e) {tr3.appendTcDetail(e.toString());}
      tr3.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventResponse_encodeRedirectURL1 */
      /* Details: "In a target jsp of a forward in the Event phase, the       */
      /* method HttpServletResponse.encodeRedirectURL must return null"       */
      TestResult tr4 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTRESPONSE_ENCODEREDIRECTURL1);
      try {
         String isval = response.encodeRedirectURL("http://www.cnn.com/");
         CompareUtils.stringsEqual(isval, null, tr4);
      } catch(Exception e) {tr4.appendTcDetail(e.toString());}
      tr4.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventResponse_encodeRedirectUrl */
      /* Details: "In a target jsp of a forward in the Event phase, the       */
      /* method HttpServletResponse.encodeRedirectUrl must return null"       */
      TestResult tr5 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTRESPONSE_ENCODEREDIRECTURL);
      try {
         String isval = response.encodeRedirectUrl("http://www.cnn.com/");
         CompareUtils.stringsEqual(isval, null, tr5);
      } catch(Exception e) {tr5.appendTcDetail(e.toString());}
      tr5.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventResponse_encodeURL1 */
      /* Details: "In a target jsp of a forward in the Event phase, the       */
      /* method HttpServletResponse.encodeURL must provide the same           */
      /* functionality as EventResponse.encodeURL"                            */
      TestResult tr6 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTRESPONSE_ENCODEURL1);
      /* TODO: implement test */
      tr6.appendTcDetail("Not implemented.");
      tr6.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventResponse_encodeUrl */
      /* Details: "In a target jsp of a forward in the Event phase, the       */
      /* method HttpServletResponse.encodeUrl must provide the same           */
      /* functionality as EventResponse.encodeURL"                            */
      TestResult tr7 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTRESPONSE_ENCODEURL);
      /* TODO: implement test */
      tr7.appendTcDetail("Not implemented.");
      tr7.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventResponse_flushBuffer */
      /* Details: "In a target jsp of a forward in the Event phase, the       */
      /* method HttpServletResponse.flushBuffer does not perform any          */
      /* operation"                                                           */
      TestResult tr8 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTRESPONSE_FLUSHBUFFER);
      /* TODO: implement test */
      tr8.appendTcDetail("Not implemented.");
      tr8.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventResponse_getBufferSize */
      /* Details: "In a target jsp of a forward in the Event phase, the       */
      /* method HttpServletResponse.getBufferSize must return 0"              */
      TestResult tr9 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTRESPONSE_GETBUFFERSIZE);
      try {
         int isval = response.getBufferSize();
         if (isval != 0) tr9.appendTcDetail("Returned value was: " + isval);
         tr9.setTcSuccess(isval == 0);
      } catch(Exception e) {tr9.appendTcDetail(e.toString());}
      tr9.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventResponse_getCharacterEncoding */
      /* Details: "In a target jsp of a forward in the Event phase, the       */
      /* method HttpServletResponse.getCharacterEncoding must return null"    */
      TestResult tr10 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTRESPONSE_GETCHARACTERENCODING);
      try {
         String isval = response.getCharacterEncoding();
         CompareUtils.stringsEqual(isval, null, tr10);
      } catch(Exception e) {tr10.appendTcDetail(e.toString());}
      tr10.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventResponse_getContentType */
      /* Details: "In a target jsp of a forward in the Event phase, the       */
      /* method HttpServletResponse.getContentType must return null"          */
      TestResult tr11 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTRESPONSE_GETCONTENTTYPE);
      try {
         String isval = response.getContentType();
         CompareUtils.stringsEqual(isval, null, tr11);
      } catch(Exception e) {tr11.appendTcDetail(e.toString());}
      tr11.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventResponse_getLocale */
      /* Details: "In a target jsp of a forward in the Event phase, the       */
      /* method HttpServletResponse.getLocale must return null"               */
      TestResult tr12 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTRESPONSE_GETLOCALE);
      try {
         Locale loc = request.getLocale();
         if (loc != null) tr12.appendTcDetail("Locale is " + loc);
         tr12.setTcSuccess(loc == null);
      } catch(Exception e) {tr12.appendTcDetail(e.toString());}
      tr12.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventResponse_getOutputStream */
      /* Details: "In a target jsp of a forward in the Event phase, the       */
      /* method HttpServletResponse.getOutputStream must return an output     */
      /* stream that ignores all input"                                       */
      TestResult tr13 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTRESPONSE_GETOUTPUTSTREAM);
      /* TODO: implement test */
      tr13.appendTcDetail("Not implemented.");
      tr13.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventResponse_getWriter */
      /* Details: "In a target jsp of a forward in the Event phase, the       */
      /* method HttpServletResponse.getWriter must return a writer that       */
      /* ignores all input"                                                   */
      TestResult tr14 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTRESPONSE_GETWRITER);
      /* TODO: implement test */
      tr14.appendTcDetail("Not implemented.");
      tr14.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventResponse_isCommitted */
      /* Details: "In a target jsp of a forward in the Event phase, the       */
      /* method HttpServletResponse.isCommitted must return false"            */
      TestResult tr15 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTRESPONSE_ISCOMMITTED);
      try {
         boolean ok = response.isCommitted();
         tr15.setTcSuccess(ok == false);
      } catch(Exception e) {tr15.appendTcDetail(e.toString());}
      tr15.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventResponse_reset */
      /* Details: "In a target jsp of a forward in the Event phase, the       */
      /* method HttpServletResponse.reset does not perform any operation"     */
      TestResult tr16 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTRESPONSE_RESET);
      /* TODO: implement test */
      tr16.appendTcDetail("Not implemented.");
      tr16.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventResponse_resetBuffer */
      /* Details: "In a target jsp of a forward in the Event phase, the       */
      /* method HttpServletResponse.resetBuffer does not perform any          */
      /* operation"                                                           */
      TestResult tr17 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTRESPONSE_RESETBUFFER);
      /* TODO: implement test */
      tr17.appendTcDetail("Not implemented.");
      tr17.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventResponse_sendError */
      /* Details: "In a target jsp of a forward in the Event phase, the       */
      /* method HttpServletResponse.sendError does not perform any            */
      /* operation"                                                           */
      TestResult tr18 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTRESPONSE_SENDERROR);
      /* TODO: implement test */
      tr18.appendTcDetail("Not implemented.");
      tr18.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventResponse_sendRedirect */
      /* Details: "In a target jsp of a forward in the Event phase, the       */
      /* method HttpServletResponse.sendRedirect does not perform any         */
      /* operation"                                                           */
      TestResult tr19 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTRESPONSE_SENDREDIRECT);
      /* TODO: implement test */
      tr19.appendTcDetail("Not implemented.");
      tr19.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventResponse_setBufferSize */
      /* Details: "In a target jsp of a forward in the Event phase, the       */
      /* method HttpServletResponse.setBufferSize does not perform any        */
      /* operation"                                                           */
      TestResult tr20 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTRESPONSE_SETBUFFERSIZE);
      /* TODO: implement test */
      tr20.appendTcDetail("Not implemented.");
      tr20.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventResponse_setCharacterEncoding */
      /* Details: "In a target jsp of a forward in the Event phase, the       */
      /* method HttpServletResponse.setCharacterEncoding does not perform     */
      /* any operation"                                                       */
      TestResult tr21 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTRESPONSE_SETCHARACTERENCODING);
      /* TODO: implement test */
      tr21.appendTcDetail("Not implemented.");
      tr21.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventResponse_setContentLength */
      /* Details: "In a target jsp of a forward in the Event phase, the       */
      /* method HttpServletResponse.setContentLength does not perform any     */
      /* operation"                                                           */
      TestResult tr22 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTRESPONSE_SETCONTENTLENGTH);
      /* TODO: implement test */
      tr22.appendTcDetail("Not implemented.");
      tr22.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventResponse_setContentType */
      /* Details: "In a target jsp of a forward in the Event phase, the       */
      /* method HttpServletResponse.setContentType does not perform any       */
      /* operation"                                                           */
      TestResult tr23 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTRESPONSE_SETCONTENTTYPE);
      /* TODO: implement test */
      tr23.appendTcDetail("Not implemented.");
      tr23.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventResponse_setDateHeader */
      /* Details: "In a target jsp of a forward in the Event phase, the       */
      /* method HttpServletResponse.setDateHeader does not perform any        */
      /* operation"                                                           */
      TestResult tr24 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTRESPONSE_SETDATEHEADER);
      /* TODO: implement test */
      tr24.appendTcDetail("Not implemented.");
      tr24.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventResponse_setHeader */
      /* Details: "In a target jsp of a forward in the Event phase, the       */
      /* method HttpServletResponse.setHeader does not perform any            */
      /* operation"                                                           */
      TestResult tr25 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTRESPONSE_SETHEADER);
      /* TODO: implement test */
      tr25.appendTcDetail("Not implemented.");
      tr25.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventResponse_setIntHeader */
      /* Details: "In a target jsp of a forward in the Event phase, the       */
      /* method HttpServletResponse.setIntHeader does not perform any         */
      /* operation"                                                           */
      TestResult tr26 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTRESPONSE_SETINTHEADER);
      /* TODO: implement test */
      tr26.appendTcDetail("Not implemented.");
      tr26.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventResponse_setLocale */
      /* Details: "In a target jsp of a forward in the Event phase, the       */
      /* method HttpServletResponse.setLocale does not perform any            */
      /* operation"                                                           */
      TestResult tr27 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTRESPONSE_SETLOCALE);
      /* TODO: implement test */
      tr27.appendTcDetail("Not implemented.");
      tr27.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventResponse_setStatus */
      /* Details: "In a target jsp of a forward in the Event phase, the       */
      /* method HttpServletResponse.setStatus does not perform any            */
      /* operation"                                                           */
      TestResult tr28 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTRESPONSE_SETSTATUS);
      /* TODO: implement test */
      tr28.appendTcDetail("Not implemented.");
      tr28.writeTo(writer);

      request.getSession().setAttribute(
                   Constants.RESULT_ATTR_PREFIX + "DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventResponse",
                   writer.toString());
%>
