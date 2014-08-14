<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0"  prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.io.*,java.util.*,java.util.logging.*" %>
<%@ page import="static java.util.logging.Logger.*" %>
<%@ page import="javax.portlet.*,javax.portlet.filter.*" %>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ page import="javax.portlet.tck.beans.*,javax.portlet.tck.constants.*" %>
<%@ page import="static javax.portlet.tck.constants.Constants.*" %>
<%@ page import="static javax.portlet.tck.beans.JSR286DispatcherTestCaseDetails.*" %>
<%

      PortletRequest portletReq = (PortletRequest) request.getAttribute("javax.portlet.request");
      PortletResponse portletResp = (PortletResponse) request.getAttribute("javax.portlet.response");
      PortletConfig portletConfig = (PortletConfig) request.getAttribute("javax.portlet.config");
      long svtTid = Thread.currentThread().getId();
      long reqTid = (Long) portletReq.getAttribute("void");

      PrintWriter writer = ((MimeResponse)portletResp).getWriter();

      JSR286DispatcherTestCaseDetails tcd = new JSR286DispatcherTestCaseDetails();

      // Create result objects for the tests

      /* TestCase: V2DispatcherTests3S_SPEC2_19_ForwardJSPResource_dispatch4  */
      /* Details: "The parameters associated with a request dispatcher are    */
      /* scoped only for the duration of the include or forward call"         */
      TestResult tr0 = tcd.getTestResultFailed(V2DISPATCHERTESTS3S_SPEC2_19_FORWARDJSPRESOURCE_DISPATCH4);
      /* TODO: implement test */
      tr0.appendTcDetail("Not implemented.");
      tr0.writeTo(writer);

      /* TestCase: V2DispatcherTests3S_SPEC2_19_ForwardJSPResource_invoke3    */
      /* Details: "Parameters to the forward method for a target servlet      */
      /* can be wrapped request and response classes from the portlet         */
      /* lifecyle method initiating the include"                              */
      TestResult tr1 = tcd.getTestResultFailed(V2DISPATCHERTESTS3S_SPEC2_19_FORWARDJSPRESOURCE_INVOKE3);
      /* TODO: implement test */
      tr1.appendTcDetail("Not implemented.");
      tr1.writeTo(writer);

%>
