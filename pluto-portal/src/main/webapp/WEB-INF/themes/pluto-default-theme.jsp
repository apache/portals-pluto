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
                PortalRequestContext prc = PortalRequestContext.getContext(request);
                PortalURL pu = prc.getRequestedPortalURL(); 
                Collection<PortalURLParameter> pups = pu.getParameters();
                // on the URL at least, prps are not differentiated by portlet ID
                Map<String, String[]> prps = pu.getPublicParameters();
                StringBuffer prpnames = new StringBuffer();
                String c0 = "";
                for (String prp : prps.keySet()) {
                   prpnames.append(c0 + "'" + prp + "'");
                   c0 = ", ";
                }
             %>
             <c:forEach var="pid" items="${currentPage.portletIds}">
                <%
                   StringBuffer ns = new StringBuffer("Pluto_");
                   String pid = (String)pageContext.getAttribute("pid");
                   for (int ii=0; ii < pid.length(); ii++) {
                      if (Character.isJavaIdentifierPart(pid.charAt(ii))) {
                         ns.append(pid.charAt(ii));
                      } else {
                         ns.append("_");
                      }
                   }
                   ns.append("_");
                   
                   String pm = pu.getPortletMode(pid).toString();
                   String ws = pu.getWindowState(pid).toString();
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
                         // this is a hack, but just add all public parms for all portlets on page
                         for (String prp : prps.keySet()) {
                            out.write(c1 + "   '" + prp + "' : [");
                            String c2 = "";
                            for (String val : (String[])prps.get(prp)) {
                               out.write(c2 + " '" + val + "'");
                               c2 = ",";
                            }
                            out.write("]");
                            c1 = ",\n                      ";
                            
                         }
                      %>
                      }, 
                      'portletMode' : '<%=pm%>', 
                      'windowState' : '<%=ws%>'
                   },
                   // 'pubParms' : [<%=prpnames.toString()%>],
                   'pubParms' : ['imgName', 'color'],
                   'allowedPM' : ['view'],
                   'allowedWS' : ['normal'],
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
          StringBuffer ub = new StringBuffer();
          //ub.append(request.getScheme()).append("://").append(request.getServerName());
          //ub.append(request.getServerPort());
          ub.append(pu.getServletPath().startsWith("/")?"":"/")
            .append(pu.getServletPath())
            .append(pu.getRenderPath());
          String urlBase = response.encodeURL(ub.toString());
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


