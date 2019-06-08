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

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@page import="org.apache.pluto.driver.core.PortalRequestContext"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://portals.apache.org/pluto" prefix="pluto" %>
<%@ page import="java.util.*,javax.portlet.*,org.apache.pluto.driver.url.*" %>
<%@ page import="org.apache.pluto.driver.config.*,org.apache.pluto.driver.*" %>
<%@ page import="org.apache.pluto.driver.util.*" %>
<%@ page import="org.apache.pluto.container.*,javax.servlet.jsp.*" %>
<% pageContext.setAttribute("now", new java.util.Date()); %>

<!--
Portal page template for default theme used by the Pluto Portal Driver.
This template divides all portlets into two groups (div blocks): the first
group (the left column) displays portlets with odd IDs, while the second group
(the right column) displays portlets with even IDs.
-->

<html>

<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Pluto Portal</title>
    <script type="text/javascript">
       /**
        * Initialization code for portlet hub
        */
       <%
          PageState ps = new PageState(request);
       %>
       var portlet = portlet || {};
       portlet.impl = portlet.impl || {};
       portlet.impl.getInitData = function () {
          var str = '<%=ps.toEncodedJSONString()%>';
          str = str.replace(/%3C/g, "<");
          return JSON.parse(str);
       }
	   portlet.impl.getUrlBase = function () {
		   return '<%=response.encodeURL(ps.getUrlBase())%>';
	   }
	   portlet.impl.getCsrfParameterName = function () {
		   return '<%=ps.getCsrfParameterName()%>';
	   }
       portlet.impl.getCsrfParameterValue = function () {
          return '<%=ps.getCsrfParameterValue()%>';
       }
    </script>

    <c:if test="${empty dynamicResources}">
      <!-- dynamic resources not available, adding static references -->
      <script type="text/javascript" src="<c:out value="${pageContext.request.contextPath}"/>/javascript/pluto.js"></script>
      <script type="text/javascript" src="<c:out value="${pageContext.request.contextPath}"/>/javascript/portletHubImpl.js"></script>
      <script type="text/javascript" src="<c:out value="${pageContext.request.contextPath}"/>/javascript/portlet.js"></script>
      <style type="text/css" title="currentStyle" media="screen">
          @import "<c:out value="${pageContext.request.contextPath}"/>/css/pluto.css";
          @import "<c:out value="${pageContext.request.contextPath}"/>/css/portlet-spec-1.0.css";
          @import "<c:out value="${pageContext.request.contextPath}"/>/css/portlet-spec-2.0.css";
      </style>
    </c:if>
    <c:if test="${not empty dynamicResources}">
      <!-- Adding dynamic resources -->
      ${dynamicResources}
    </c:if>
  
    <!-- Now include the head section markup provided by the portlet header processing methods -->
    ${headMarkup}
</head>

<body>

<div id="portal">

    <!-- Header block: the Apache Pluto banner image and description -->
    <div id="header">
        <h1>Apache Pluto</h1>

        <p>An Apache Portals Project</p>
    </div>

    <!-- Logout link -->
    <div id="logout">
        <a href="<c:url value='/Logout'/>">Logout</a>
    </div>

    <!-- Navigation block: links to portal pages -->
    <jsp:include page="navigation.jsp"/>

    <!-- Content block: portlets are divided into two columns/groups -->
    <div id="content">
        <pluto:isMaximized var="isMax"/>

        <!-- Left column -->
        <c:choose>
            <c:when test="${isMax}">
                    <c:forEach var="portlet" varStatus="status"
                               items="${currentPage.portletIds}">
                        <c:set var="portlet" value="${portlet}" scope="request"/>
                        <jsp:include page="portlet-skin.jsp"/>
                    </c:forEach>
             </c:when>

            <c:otherwise>
                <div id="portlets-left-column">
                    <c:forEach var="portlet" varStatus="status"
                               items="${currentPage.portletIds}" step="2">
                        <c:set var="portlet" value="${portlet}" scope="request"/>
                        <jsp:include page="portlet-skin.jsp"/>
                    </c:forEach>
                </div>

                <!-- Right column -->
                <div id="portlets-right-column">
                    <c:forEach var="portlet" varStatus="status"
                               items="${currentPage.portletIds}" begin="1" step="2">
                        <c:set var="portlet" value="${portlet}" scope="request"/>
                        <jsp:include page="portlet-skin.jsp"/>
                    </c:forEach>
                </div>

            </c:otherwise>
        </c:choose>

    </div>

    <!-- Footer block: copyright -->
    <div id="footer">
       &copy; 2003-<fmt:formatDate value="${now}" pattern="yyyy"/> Apache Software Foundation
    </div>

</div>

</body>

</html>


