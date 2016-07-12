<%-- 
  - Author(s): ahmed
  --%>
<%@ page session="false" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0"  prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="java.io.StringWriter" %>
<%@ page import="javax.portlet.PortletRequest" %>
<%@ page import="javax.portlet.PortletResponse" %>
<%@ page import="javax.portlet.tck.beans.JSR286ApiTestCaseDetails" %>
<%@ page import="javax.portlet.tck.beans.TestResult" %>
<%@ page import="javax.portlet.tck.constants.Constants" %>

<%@ page import="static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_FORWARD1" %>
<%@ page import="static javax.portlet.tck.constants.Constants.THREADID_ATTR" %>

<portlet:defineObjects/>

<%

    PortletRequest portletReq = (PortletRequest) request.getAttribute("javax.portlet.request");
    PortletResponse portletResp = (PortletResponse) request.getAttribute("javax.portlet.response");
    long svtTid = Thread.currentThread().getId();
    long reqTid = (Long) portletReq.getAttribute(THREADID_ATTR);

    StringWriter writer = new StringWriter();

    JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

    /* TestCase: V2EnvironmentTests_PortletRequestDispatcher_ApiRender_forward1 */
    /* Details: "Method forward(PortletRequest, PortletResponse): Can */
    /* forward to a JSP page to create the response" */
    TestResult tr8 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_FORWARD1);
    tr8.setTcSuccess(true);
    tr8.writeTo(writer);
%>
<%=writer.toString()%>