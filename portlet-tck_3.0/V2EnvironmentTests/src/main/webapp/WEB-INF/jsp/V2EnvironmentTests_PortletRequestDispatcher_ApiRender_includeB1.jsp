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

<%@ page import="static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_INCLUDEB1" %>
<%@ page import="static javax.portlet.tck.constants.Constants.THREADID_ATTR" %>

<portlet:defineObjects/>

<%

    PortletRequest portletReq = (PortletRequest) request.getAttribute("javax.portlet.request");
    PortletResponse portletResp = (PortletResponse) request.getAttribute("javax.portlet.response");
    long svtTid = Thread.currentThread().getId();
    long reqTid = (Long) portletReq.getAttribute(THREADID_ATTR);

    StringWriter writer = new StringWriter();

    JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

    /* TestCase: V2EnvironmentTests_PortletRequestDispatcher_ApiRender_includeB1 */
    /* Details: "Method include(RenderRequest, RenderResponse): Includes */
    /* the content of a JSP page in the response" */
    TestResult tr4 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_INCLUDEB1);
    tr4.setTcSuccess(true);
    tr4.writeTo(writer);
    
%>
<%=writer.toString()%>