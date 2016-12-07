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
<%@ page import="javax.portlet.tck.beans.JSR286SpecTestCaseDetails" %>
<%@ page import="javax.portlet.tck.beans.TestResult" %>

<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL30" %>
<%@ page import="static javax.portlet.tck.constants.Constants.THREADID_ATTR" %>

<portlet:defineObjects/>

<%

      PortletRequest portletReq = (PortletRequest) request.getAttribute("javax.portlet.request");
      PortletResponse portletResp = (PortletResponse) request.getAttribute("javax.portlet.response");
      long svtTid = Thread.currentThread().getId();
      long reqTid = (Long) portletReq.getAttribute(THREADID_ATTR);

      StringWriter writer = new StringWriter();

      JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL30 */
      /* Details: "If this tag is used in markup provided by a                */
      /* serveResource call that was directly or indirectly triggered via a   */
      /* resource URL of type PORTLET, a JspException with the                */
      /* IllegalStateException that caused this error is thrown"              */
      TestResult tr40 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL30); 
      %>
      <c:catch var ="exceptionTr40">
         <portlet:actionURL/>
      </c:catch>
      <c:if test = "${exceptionTr40 != null}">
         <%
         tr40.setTcSuccess(true);
         String exceptionTr40 = ""; 
         exceptionTr40 = exceptionTr40 + pageContext.getAttribute("exceptionTr40");
         tr40.appendTcDetail(exceptionTr40);
         %>
      </c:if>
      <c:if test = "${exceptionTr40 == null}">
         <%
         tr40.appendTcDetail("Test case failed as no Exception is raised while defining action tag.");
         %>
      </c:if>
      <%
      tr40.writeTo(writer);

%>

<%=writer.toString() %>