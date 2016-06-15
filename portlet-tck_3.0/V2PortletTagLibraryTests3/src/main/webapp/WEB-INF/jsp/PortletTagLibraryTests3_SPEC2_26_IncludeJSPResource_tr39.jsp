<%-- 
  - Author(s): ahmed
  --%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0"  prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.io.*,java.util.*,java.util.logging.*" %>
<%@ page import="static java.util.logging.Logger.*" %>
<%@ page import="javax.portlet.*,javax.portlet.filter.*" %>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ page import="javax.portlet.tck.beans.*,javax.portlet.tck.constants.*" %>
<%@ page import="static javax.portlet.tck.constants.Constants.*" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.*" %>
<portlet:defineObjects/>
<%

      PortletRequest portletReq = (PortletRequest) request.getAttribute("javax.portlet.request");
      PortletResponse portletResp = (PortletResponse) request.getAttribute("javax.portlet.response");
      long svtTid = Thread.currentThread().getId();
      long reqTid = (Long) portletReq.getAttribute(THREADID_ATTR);

      StringWriter writer = new StringWriter();

      JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL29 */
      /* Details: "If this tag is used in markup provided by a                */
      /* serveResource call that was directly or indirectly triggered via a   */
      /* resource URL of type FULL, a JspException with the                   */
      /* IllegalStateException that caused this error is thrown"              */
      TestResult tr39 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL29); 
      %>
      <c:catch var ="exceptionTr39">
         <portlet:actionURL/>
      </c:catch>
      <c:if test = "${exceptionTr39 != null}">
         <%
         tr39.setTcSuccess(true);
         String exceptionTr39 = ""; 
         exceptionTr39 = exceptionTr39 + pageContext.getAttribute("exceptionTr39");
         tr39.appendTcDetail(exceptionTr39);
         %>
      </c:if>
      <c:if test = "${exceptionTr39 == null}">
         <%
         tr39.appendTcDetail("Test case failed as no Exception is raised while defining action tag.");
         %>
      </c:if>
      <%
      tr39.writeTo(writer);

%>

<%=writer.toString() %>