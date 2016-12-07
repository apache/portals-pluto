<%--
Licensed to the Apache Software Foundation (ASF) under one or more
contributor license agreements.  See the NOTICE file distributed with
this work for additional information regarding copyright ownership.
The ASF licenses this file to You under the Apache License, Version 2.0
(the "License"); you may not use this file except in compliance with
the License.  You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed  under the  License is distributed on an "AS IS" BASIS,
WITHOUT  WARRANTIES OR CONDITIONS  OF ANY KIND, either  express  or
implied.

See the License for the specific language governing permissions and
limitations under the License.
--%>

<%--
Licensed to the Apache Software Foundation (ASF) under one or more
contributor license agreements.  See the NOTICE file distributed with
this work for additional information regarding copyright ownership.
The ASF licenses this file to You under the Apache License, Version 2.0
(the "License"); you may not use this file except in compliance with
the License.  You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed  under the  License is distributed on an "AS IS" BASIS,
WITHOUT  WARRANTIES OR CONDITIONS  OF ANY KIND, either  express  or
implied.

See the License for the specific language governing permissions and
limitations under the License.
--%>
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

<%@ page import="static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_INCLUDEA1" %>
<%@ page import="static javax.portlet.tck.constants.Constants.THREADID_ATTR" %>

<portlet:defineObjects/>

<%

    PortletRequest portletReq = (PortletRequest) request.getAttribute("javax.portlet.request");
    PortletResponse portletResp = (PortletResponse) request.getAttribute("javax.portlet.response");
    long svtTid = Thread.currentThread().getId();
    long reqTid = (Long) portletReq.getAttribute(THREADID_ATTR);

    StringWriter writer = new StringWriter();

    JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

    /* TestCase: V2EnvironmentTests_PortletRequestDispatcher_ApiRender_includeA1 */
    /* Details: "Method include(PortletRequest, PortletResponse): */
    /* Includes the content of a JSP page in the response" */
    TestResult tr0 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_INCLUDEA1);
    tr0.setTcSuccess(true);
    tr0.writeTo(writer);
    
%>
<%=writer.toString()%>