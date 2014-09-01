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

      /* TestCase: V2DispatcherReqRespTests5S_SPEC2_19_IncludeJSPResourceResponse_getOutputStream */
      /* Details: "In a target jsp of a include in the Resource phase, the    */
      /* method HttpServletResponse.getOutputStream must provide the same     */
      /* functionality as ResourceResponse.getPortletOutputStream"            */
      TestResult tr0 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDEJSPRESOURCERESPONSE_GETOUTPUTSTREAM);
      /* TODO: implement test */
      tr0.appendTcDetail("Not implemented.");
      tr0.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests5S_SPEC2_19_IncludeJSPResourceResponse_sendError */
      /* Details: "In a target jsp of a include in the Resource phase, the    */
      /* method HttpServletResponse.sendError does not perform any            */
      /* operation"                                                           */
      TestResult tr1 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDEJSPRESOURCERESPONSE_SENDERROR);
      /* TODO: implement test */
      tr1.appendTcDetail("Not implemented.");
      tr1.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests5S_SPEC2_19_IncludeJSPResourceResponse_sendRedirect */
      /* Details: "In a target jsp of a include in the Resource phase, the    */
      /* method HttpServletResponse.sendRedirect does not perform any         */
      /* operation"                                                           */
      TestResult tr2 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDEJSPRESOURCERESPONSE_SENDREDIRECT);
      /* TODO: implement test */
      tr2.appendTcDetail("Not implemented.");
      tr2.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests5S_SPEC2_19_IncludeJSPResourceResponse_setCharacterEncoding */
      /* Details: "In a target jsp of a include in the Resource phase, the    */
      /* method HttpServletResponse.setCharacterEncoding does not perform     */
      /* any operation"                                                       */
      TestResult tr3 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDEJSPRESOURCERESPONSE_SETCHARACTERENCODING);
      /* TODO: implement test */
      tr3.appendTcDetail("Not implemented.");
      tr3.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests5S_SPEC2_19_IncludeJSPResourceResponse_setContentLength */
      /* Details: "In a target jsp of a include in the Resource phase, the    */
      /* method HttpServletResponse.setContentLength does not perform any     */
      /* operation"                                                           */
      TestResult tr4 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDEJSPRESOURCERESPONSE_SETCONTENTLENGTH);
      /* TODO: implement test */
      tr4.appendTcDetail("Not implemented.");
      tr4.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests5S_SPEC2_19_IncludeJSPResourceResponse_setContentType */
      /* Details: "In a target jsp of a include in the Resource phase, the    */
      /* method HttpServletResponse.setContentType does not perform any       */
      /* operation"                                                           */
      TestResult tr5 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDEJSPRESOURCERESPONSE_SETCONTENTTYPE);
      /* TODO: implement test */
      tr5.appendTcDetail("Not implemented.");
      tr5.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests5S_SPEC2_19_IncludeJSPResourceResponse_setLocale */
      /* Details: "In a target jsp of a include in the Resource phase, the    */
      /* method HttpServletResponse.setLocale does not perform any            */
      /* operation"                                                           */
      TestResult tr6 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDEJSPRESOURCERESPONSE_SETLOCALE);
      /* TODO: implement test */
      tr6.appendTcDetail("Not implemented.");
      tr6.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests5S_SPEC2_19_IncludeJSPResourceResponse_setStatus */
      /* Details: "In a target jsp of a include in the Resource phase, the    */
      /* method HttpServletResponse.setStatus does not perform any            */
      /* operation"                                                           */
      TestResult tr7 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDEJSPRESOURCERESPONSE_SETSTATUS);
      /* TODO: implement test */
      tr7.appendTcDetail("Not implemented.");
      tr7.writeTo(writer);

%>
