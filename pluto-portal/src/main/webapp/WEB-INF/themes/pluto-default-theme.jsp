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
<%@page import="org.apache.pluto.driver.core.PortalRequestContext"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
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
    <title>Pluto Portal</title>
    <style type="text/css" title="currentStyle" media="screen">
        @import "<c:out value="${pageContext.request.contextPath}"/>/pluto.css";
        @import "<c:out value="${pageContext.request.contextPath}"/>/portlet-spec-1.0.css";
        @import "<c:out value="${pageContext.request.contextPath}"/>/portlet-spec-2.0.css";
    </style>
    <script type="text/javascript">
       /**
        * Initialization code for portlet hub
        */
       var portlet = portlet || {};
       portlet.impl = portlet.impl || {};
       portlet.impl.getInitData = function () {
          return {       
             <%
                PageState ps = new PageState(request);
                Collection<String> poids = ps.getPortletIds();
             
                Collection<PortalURLParameter> pups = ps.getParameters();
                Map<String, String[]> pubparms = ps.getPublicParameters();
             %>
             <c:forEach var="pid" items="${currentPage.portletIds}">
                <%
                   String pid = (String)pageContext.getAttribute("pid");
                   
                   String ns = ps.getNameSpace(pid);

                   String prpstring = ps.getPRPNamesAsString(pid);
                   Set<String> prpnames = ps.getPRPNames(pid);
                   
                   String pmstring = ps.getPortletModesAsString(pid);
                   
                   String wsstring = ps.getWindowStatesAsString(pid);
                   
                   String pm = ps.getPortletMode(pid);
                   String ws = ps.getWindowState(pid);
                %>
                '<%=ns%>' : {
                   'state' : {
                      'parameters' : {
                      <%
                         String c1 = "";
                         for (PortalURLParameter pup : pups){
                            if (pup.getWindowId().equals(pid)){
                               out.write(c1 + "   '" + pup.getName() + "' : [");
                               String c2 = "";
                               for (String val : pup.getValues()) {
                                  out.write(c2 + " '" + val + "'");
                                  c2 = ", ";
                               }
                               out.write("]");
                               c1 = ",\n                      ";
                            }
                         }
                         
                         // Add the public render parameter values for this portlet
                         
                         for (String prp : pubparms.keySet()) {
                            if (prpnames.contains(prp)) {
                               out.write(c1 + "   '" + prp + "' : [");
                               String c2 = "";
                               for (String val : (String[])pubparms.get(prp)) {
                                  out.write(c2 + " '" + val + "'");
                                  c2 = ",";
                               }
                               out.write("]");
                               c1 = ",\n                      ";
                            }
                         }
                      %>
                      }, 
                      'portletMode' : '<%=pm%>', 
                      'windowState' : '<%=ws%>'
                   },
                   'pubParms' : [<%=prpstring%>],
                   'allowedPM' : [<%=pmstring%>],
                   'allowedWS' : [<%=wsstring%>],
                   'renderData' : {
                      'renderData' : null,
                      'mimeType' : "text/plain"
                   },
                   'urlpid' : '<%=pid%>'
                },
             </c:forEach>
          }
       }
       <%
          String urlBase = response.encodeURL(ps.getUrlBase());
       %>
       portlet.impl.getUrlBase = function () {
          return '<%=urlBase%>';
       }
    </script>
    <script type="text/javascript" src="<c:out value="${pageContext.request.contextPath}"/>/pluto.js"></script>
    <script type="text/javascript" src="<c:out value="${pageContext.request.contextPath}"/>/portletHubImpl.js"></script>
    <script type="text/javascript" src="<c:out value="${pageContext.request.contextPath}"/>/portlet.js"></script>
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


