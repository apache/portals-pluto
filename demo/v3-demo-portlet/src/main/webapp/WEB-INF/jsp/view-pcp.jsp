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
<%@ page import="static org.apache.portals.pluto.demo.v3.Constants.*" %>
<%@ page session="false" %>
<%@ taglib uri="http://xmlns.jcp.org/portlet_3_0"  prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<portlet:defineObjects />

<%
   StringBuffer style = new StringBuffer(256);
   style.append("border-style:solid; border-width:3px;");
   style.append(" padding:4px; overflow:auto;");
   style.append(" border-color:#008800; min-height:30px;");
   style.append(" background:#E0E0E0;");
%>

<h3><%=portletConfig.getPortletName()%></h3>
<hr/>
<p>This portlet displays information from the new V3.0 PortletConfig APIs
getPortletModes(String), getWindowStates(String), and getPublicRenderParameterDefinitions()</p>
<h5>Current Portlet Mode: <%=renderRequest.getPortletMode().toString() %></h5>
<h5>Portlet Modes:</h5>
<ul>
<c:forEach items="<%=renderRequest.getAttribute(ATTRIB_PMS) %>" var="pm">
   <li><c:out value="${pm}"></c:out></li>
</c:forEach>
</ul>
<h5>Window States:</h5>
<ul>
<c:forEach items="<%=renderRequest.getAttribute(ATTRIB_WS) %>" var="ws">
   <li><c:out value="${ws}"></c:out></li>
</c:forEach>
</ul>
<h5>Public Render Parameters:</h5>
<ul>
<c:forEach items="<%=renderRequest.getAttribute(ATTRIB_PRPS) %>" var="prp">
   <li><c:out value="${prp}"></c:out></li>
</c:forEach>
</ul>
<h5>Portlet Context Info:</h5>
<ul>
<c:forEach items="<%=renderRequest.getAttribute(ATTRIB_CTX) %>" var="ctx">
   <li><c:out value="${ctx}"></c:out></li>
</c:forEach>
</ul>
