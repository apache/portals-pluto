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

<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0"  prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.io.*,java.util.*,org.slf4j.*" %>
<%@ page import="static org.slf4j.Logger.*" %>
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

      StringWriter writer = new StringWriter();

      JSR286DispatcherReqRespTestCaseDetails tcd = new JSR286DispatcherReqRespTestCaseDetails();

      // Create result objects for the tests

      /* TestCase: V2DispatcherReqRespTests5S_SPEC2_19_ForwardJSPActionRequest_getInputStream */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getInputStream must provide the same       */
      /* functionality as ActionRequest.getPortletInputStream"                */
      TestResult tr0 = tcd.getTestResultSucceeded(V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDJSPACTIONREQUEST_GETINPUTSTREAM);
      tr0.appendTcDetail("Can't be implemented.");
      tr0.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests5S_SPEC2_19_ForwardJSPActionRequest_setCharacterEncoding */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.setCharacterEncoding must provide the      */
      /* same functionality as ActionRequest.setCharacterEncoding"            */
      TestResult tr1 = tcd.getTestResultSucceeded(V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDJSPACTIONREQUEST_SETCHARACTERENCODING);
      tr1.appendTcDetail("Can't be implemented.");
      tr1.writeTo(writer);

      request.getSession().setAttribute(
                   Constants.RESULT_ATTR_PREFIX + "DispatcherReqRespTests5S_SPEC2_19_ForwardJSPActionRequest",
                   writer.toString());
%>
