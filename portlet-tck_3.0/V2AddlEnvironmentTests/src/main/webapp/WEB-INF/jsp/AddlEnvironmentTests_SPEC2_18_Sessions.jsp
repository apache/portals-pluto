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
<%@ page import="java.io.*,java.util.*,org.slf4j.*" %>
<%@ page import="static org.slf4j.Logger.*" %>
<%@ page import="javax.portlet.*,javax.portlet.filter.*" %>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ page import="javax.portlet.tck.beans.*,javax.portlet.tck.constants.*" %>
<%@ page import="static javax.portlet.tck.constants.Constants.*" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.*" %>
<portlet:defineObjects/>
<%
      PortletRequest portletReq = (PortletRequest) request.getAttribute("javax.portlet.request");
      RenderResponse portletResp = (RenderResponse) request.getAttribute("javax.portlet.response");
      long svtTid = Thread.currentThread().getId();
      long reqTid = (Long) portletReq.getAttribute(THREADID_ATTR);
      
      JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();
      PrintWriter writer = portletResp.getWriter();
      
      HttpSession httpSession = request.getSession();
      
      /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_httpSession2 */
      /* Details: "Data stored in the HttpSession by a JSP in the same web */
      /* application is accessible to portlets through the PortletSession */
      /* in APPLICATION_SCOPE" */
      httpSession.setAttribute(Constants.RESULT_ATTR_PREFIX + "AddlEnvironmentTests_SPEC2_18_Sessions_tr20", "true");
      
      /* TestCase: V2AddlEnvironmentTests_SPEC2_18_Sessions_httpSession3 */
      /* Details: "Data stored by portlets in the PortletSession is */
      /* accessible to servlets and JSPs through the HttpSession" */
      TestResult tr21 =
        tcd.getTestResultFailed(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_HTTPSESSION3);
      String tr21_success = (String) httpSession.getAttribute(
        Constants.RESULT_ATTR_PREFIX + "AddlEnvironmentTests_SPEC2_18_Sessions_tr21");
      if (tr21_success != null && tr21_success.equals("true")) {
        tr21.setTcSuccess(true);
      } else {
        tr21.appendTcDetail("Failed becuase there is no attribute with key \""
          + Constants.RESULT_ATTR_PREFIX + "AddlEnvironmentTests_SPEC2_18_Sessions_tr21\"");
      }
      tr21.writeTo(writer);
%>
