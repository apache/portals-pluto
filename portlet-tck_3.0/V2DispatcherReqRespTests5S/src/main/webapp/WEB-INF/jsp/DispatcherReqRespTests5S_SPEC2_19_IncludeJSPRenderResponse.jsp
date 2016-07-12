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

      /* TestCase: V2DispatcherReqRespTests5S_SPEC2_19_IncludeJSPRenderResponse_getOutputStream */
      /* Details: "In a target jsp of a include in the Render phase, the      */
      /* method HttpServletResponse.getOutputStream must provide the same     */
      /* functionality as RenderResponse.getPortletOutputStream"              */
      TestResult tr0 = tcd.getTestResultSucceeded(V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDEJSPRENDERRESPONSE_GETOUTPUTSTREAM);
      tr0.appendTcDetail("Can't be implemented.");
      tr0.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests5S_SPEC2_19_IncludeJSPRenderResponse_sendError */
      /* Details: "In a target jsp of a include in the Render phase, the      */
      /* method HttpServletResponse.sendError does not perform any            */
      /* operation"                                                           */
      TestResult tr1 = tcd.getTestResultSucceeded(V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDEJSPRENDERRESPONSE_SENDERROR);
      tr1.appendTcDetail("Can't be implemented.");
      tr1.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests5S_SPEC2_19_IncludeJSPRenderResponse_sendRedirect */
      /* Details: "In a target jsp of a include in the Render phase, the      */
      /* method HttpServletResponse.sendRedirect does not perform any         */
      /* operation"                                                           */
      TestResult tr2 = tcd.getTestResultSucceeded(V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDEJSPRENDERRESPONSE_SENDREDIRECT);
      tr2.appendTcDetail("Can't be implemented.");
      tr2.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests5S_SPEC2_19_IncludeJSPRenderResponse_setCharacterEncoding */
      /* Details: "In a target jsp of a include in the Render phase, the      */
      /* method HttpServletResponse.setCharacterEncoding does not perform     */
      /* any operation"                                                       */
      TestResult tr3 = tcd.getTestResultSucceeded(V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDEJSPRENDERRESPONSE_SETCHARACTERENCODING);
      tr3.appendTcDetail("Can't be implemented.");
      tr3.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests5S_SPEC2_19_IncludeJSPRenderResponse_setContentLength */
      /* Details: "In a target jsp of a include in the Render phase, the      */
      /* method HttpServletResponse.setContentLength does not perform any     */
      /* operation"                                                           */
      TestResult tr4 = tcd.getTestResultSucceeded(V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDEJSPRENDERRESPONSE_SETCONTENTLENGTH);
      tr4.appendTcDetail("Can't be implemented.");
      tr4.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests5S_SPEC2_19_IncludeJSPRenderResponse_setContentType */
      /* Details: "In a target jsp of a include in the Render phase, the      */
      /* method HttpServletResponse.setContentType does not perform any       */
      /* operation"                                                           */
      TestResult tr5 = tcd.getTestResultSucceeded(V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDEJSPRENDERRESPONSE_SETCONTENTTYPE);
      tr5.appendTcDetail("Can't be implemented.");
      tr5.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests5S_SPEC2_19_IncludeJSPRenderResponse_setLocale */
      /* Details: "In a target jsp of a include in the Render phase, the      */
      /* method HttpServletResponse.setLocale does not perform any            */
      /* operation"                                                           */
      TestResult tr6 = tcd.getTestResultSucceeded(V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDEJSPRENDERRESPONSE_SETLOCALE);
      tr6.appendTcDetail("Can't be implemented.");
      tr6.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests5S_SPEC2_19_IncludeJSPRenderResponse_setStatus */
      /* Details: "In a target jsp of a include in the Render phase, the      */
      /* method HttpServletResponse.setStatus does not perform any            */
      /* operation"                                                           */
      TestResult tr7 = tcd.getTestResultSucceeded(V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDEJSPRENDERRESPONSE_SETSTATUS);
      tr7.appendTcDetail("Can't be implemented.");
      tr7.writeTo(writer);

%>
