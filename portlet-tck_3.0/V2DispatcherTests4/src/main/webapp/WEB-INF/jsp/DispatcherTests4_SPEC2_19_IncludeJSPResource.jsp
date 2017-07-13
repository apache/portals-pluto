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
<%@ page import="static javax.portlet.tck.beans.JSR286DispatcherTestCaseDetails.*" %>

<%

      PortletRequest portletReq = (PortletRequest) request.getAttribute("javax.portlet.request");
      PortletResponse portletResp = (PortletResponse) request.getAttribute("javax.portlet.response");
      PortletConfig portletConfig = (PortletConfig) request.getAttribute("javax.portlet.config");
      long svtTid = Thread.currentThread().getId();
      long reqTid = (Long) portletReq.getAttribute(THREADID_ATTR);

      PrintWriter writer = ((MimeResponse)portletResp).getWriter();

      JSR286DispatcherTestCaseDetails tcd = new JSR286DispatcherTestCaseDetails();

      // Create result objects for the tests

      /* TestCase: V2DispatcherTests4_SPEC2_19_IncludeJSPResource_invoke3     */
      /* Details: "Parameters to the include method for a target servlet      */
      /* can be wrapped request and response classes from the portlet         */
      /* lifecyle method initiating the include"                              */
      TestResult tr0 = tcd.getTestResultFailed(V2DISPATCHERTESTS4_SPEC2_19_INCLUDEJSPRESOURCE_INVOKE3);
      try {
         // If this gets executed, include worked.
         tr0.setTcSuccess(true);
      } catch(Exception e) {tr0.appendTcDetail(e.toString());}
      tr0.writeTo(writer);

      /* TestCase: V2DispatcherTests4_SPEC2_19_IncludeJSPResource_invoke8     */
      /* Details: "The portlet can include multiple servlets during the       */
      /* same lifecycle method"                                               */
      TestResult tr1 = tcd.getTestResultFailed(V2DISPATCHERTESTS4_SPEC2_19_INCLUDEJSPRESOURCE_INVOKE8);
      try {
         // Check the attribute to make sure the include servlet was really included
         String val = (String) request.getAttribute(MULTIPLE_INCLUDE_ATTR);
         tr1.setTcSuccess(val != null);
      } catch(Exception e) {tr1.appendTcDetail(e.toString());}
      tr1.writeTo(writer);

%>
