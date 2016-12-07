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

<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPGENERAL_DEFINEOBJECTS1" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPGENERAL_NAMESPACE" %>
<%@ page import="static javax.portlet.tck.constants.Constants.THREADID_ATTR" %>

<portlet:defineObjects/>

<%
      PortletRequest portletReq = (PortletRequest) request.getAttribute("javax.portlet.request");
      PortletResponse portletResp = (PortletResponse) request.getAttribute("javax.portlet.response");
      long svtTid = Thread.currentThread().getId();
      long reqTid = (Long) portletReq.getAttribute(THREADID_ATTR);

      StringWriter writer = new StringWriter();

      JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();

      // Create result objects for the tests

      /* TestCase: V2PortletTagLibraryTests_SPEC2_26_IncludeJSPGeneral_defineObjects1 */
      /* Details: "The portlet-container must provide an implementation of    */
      /* the Tag Lib"                                                         */
      TestResult tr1 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPGENERAL_DEFINEOBJECTS1);
      if(!portletConfig.equals(null)){
        tr1.setTcSuccess(true);
      }
      tr1.writeTo(writer);

      
      // For TestCase: V2PortletTagLibraryTests_SPEC2_26_IncludeJSPGeneral_defineObjects2
      // portlet:resourceURL tag is only defined for V2
      %>
      <portlet:resourceURL var="V2_URL" escapeXml="true">
      <portlet:param name="onlyForV2" value="V2_Variable" />
      </portlet:resourceURL>
      <P style="display:none;"><%=V2_URL%></P>
      <%

      /* TestCase: V2PortletTagLibraryTests_SPEC2_26_IncludeJSPGeneral_namespace */
      /* Details: "The namespace tag produces a unique string value for the   */
      /* current portlet equal to the value returned by the                   */
      /* PortletResponse.getNamespace method"                                 */
      TestResult tr4 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPGENERAL_NAMESPACE);
      if(renderRequest.getParameter("namespace")!=null){
        if(portletResp.getNamespace().equals(renderRequest.getParameter("namespace"))){
          tr4.setTcSuccess(true);
          tr4.writeTo(writer);
        }
      } else {
      %>
      <DIV CLASS="portletTCKTestcase" name="V2PortletTagLibraryTests_SPEC2_26_IncludeJSPGeneral_namespace">
        <h4>V2PortletTagLibraryTests_SPEC2_26_IncludeJSPGeneral_namespace button (POST):</h4>
        <FORM METHOD="POST" ACTION="<portlet:actionURL/>">
          <INPUT NAME='namespace' VALUE='<portlet:namespace/>' TYPE="hidden">
          <INPUT VALUE="V2PortletTagLibraryTests_SPEC2_26_IncludeJSPGeneral_namespace" ID="V2PortletTagLibraryTests_SPEC2_26_IncludeJSPGeneral_namespace-clickme" TYPE="submit">
        </FORM>
      </DIV>
      <% }

%>
<%=writer.toString()%>