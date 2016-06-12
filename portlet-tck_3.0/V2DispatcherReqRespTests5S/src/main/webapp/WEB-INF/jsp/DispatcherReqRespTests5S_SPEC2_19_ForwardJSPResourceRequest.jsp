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

      /* TestCase: V2DispatcherReqRespTests5S_SPEC2_19_ForwardJSPResourceRequest_getInputStream */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletRequest.getInputStream must provide the same       */
      /* functionality as ResourceRequest.getPortletInputStream"              */
      TestResult tr0 = tcd.getTestResultSucceeded(V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETINPUTSTREAM);
      tr0.appendTcDetail("Can't be implemented.");
      tr0.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests5S_SPEC2_19_ForwardJSPResourceRequest_setCharacterEncoding */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletRequest.setCharacterEncoding must provide the      */
      /* same functionality as ResourceRequest.setCharacterEncoding"          */
      TestResult tr1 = tcd.getTestResultSucceeded(V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDJSPRESOURCEREQUEST_SETCHARACTERENCODING);
      tr1.appendTcDetail("Can't be implemented.");
      tr1.writeTo(writer);

%>
