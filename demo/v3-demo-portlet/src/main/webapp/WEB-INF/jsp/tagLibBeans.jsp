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
<%@page import="javax.portlet.RenderParameters"%>
<%@ page session="false" %>
<%@ taglib uri="http://xmlns.jcp.org/portlet_3_0"  prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="static org.apache.portals.pluto.demo.v3.TagLibPortlet.*" %>
<%@ page import="static javax.portlet.PortletRequest.*" %>


<div class='infobox'>
   <h4>EL beans for phase: ${phaseTitle}</h4>
   
   <table style='width:100%;'>
   <colgroup>
      <col style="width:10%">
      <col style="width:45%">
      <col style="width:45%">
   </colgroup>   
   <tr>
   
   <%int ii=1; %>
   <th align='left'>
   #
   </th><th align='left'>
   Page Object
   </th><th align='left'>
   Is present
   </th>
   </tr><tr>

   <!-- the objects -->
   
   <td align='left'>
   <%=ii++ %>
   </td><td align='left'>
   renderRequest
   </td><td align='left'>
   <c:catch var="excp">${not empty renderRequest.toString()}</c:catch>
   <c:if test="${not empty excp}">undefined</c:if>
   </td>
   </tr><tr>

   <td align='left'>
   <%=ii++ %>
   </td><td align='left'>
   resourceRequest
   </td><td align='left'>
   <c:catch var="excp">${not empty resourceRequest.toString()}</c:catch>
   <c:if test="${not empty excp}">undefined</c:if>
   </td>
   </tr><tr>

   <td align='left'>
   <%=ii++ %>
   </td><td align='left'>
   actionRequest
   </td><td align='left'>
   <c:catch var="excp">${not empty actionRequest.toString()}</c:catch>
   <c:if test="${not empty excp}">undefined</c:if>
   </td>
   </tr><tr>

   <td align='left'>
   <%=ii++ %>
   </td><td align='left'>
   eventRequest
   </td><td align='left'>
   <c:catch var="excp">${not empty eventRequest.toString()}</c:catch>
   <c:if test="${not empty excp}">undefined</c:if>
   </td>
   </tr><tr>

   <td align='left'>
   <%=ii++ %>
   </td><td align='left'>
   renderResponse
   </td><td align='left'>
   <c:catch var="excp">${not empty renderResponse.toString()}</c:catch>
   <c:if test="${not empty excp}">undefined</c:if>
   </td>
   </tr><tr>

   <td align='left'>
   <%=ii++ %>
   </td><td align='left'>
   resourceResponse
   </td><td align='left'>
   <c:catch var="excp">${not empty resourceResponse.toString()}</c:catch>
   <c:if test="${not empty excp}">undefined</c:if>
   </td>
   </tr><tr>

   <td align='left'>
   <%=ii++ %>
   </td><td align='left'>
   actionResponse
   </td><td align='left'>
   <c:catch var="excp">${not empty actionResponse.toString()}</c:catch>
   <c:if test="${not empty excp}">undefined</c:if>
   </td>
   </tr><tr>

   <td align='left'>
   <%=ii++ %>
   </td><td align='left'>
   eventResponse
   </td><td align='left'>
   <c:catch var="excp">${not empty eventResponse.toString()}</c:catch>
   <c:if test="${not empty excp}">undefined</c:if>
   </td>
   </tr><tr>

   <td align='left'>
   <%=ii++ %>
   </td><td align='left'>
   portletConfig
   </td><td align='left'>
   <c:catch var="excp">${not empty portletConfig.toString()}</c:catch>
   <c:if test="${not empty excp}">undefined</c:if>
   </td>
   </tr><tr>

   <td align='left'>
   <%=ii++ %>
   </td><td align='left'>
   portletSession
   </td><td align='left'>
   <c:catch var="excp">${not empty portletSession.toString()}</c:catch>
   <c:if test="${not empty excp}">undefined</c:if>
   </td>
   </tr><tr>

   <td align='left'>
   <%=ii++ %>
   </td><td align='left'>
   portletSessionScope
   </td><td align='left'>
   <c:catch var="excp">${not empty portletSessionScope.toString()}</c:catch>
   <c:if test="${not empty excp}">undefined</c:if>
   </td>
   </tr><tr>

   <td align='left'>
   <%=ii++ %>
   </td><td align='left'>
   portletPreferences
   </td><td align='left'>
   <c:catch var="excp">${not empty portletPreferences.toString()}</c:catch>
   <c:if test="${not empty excp}">undefined</c:if>
   </td>
   </tr><tr>

   <td align='left'>
   <%=ii++ %>
   </td><td align='left'>
   portletPreferencesValues
   </td><td align='left'>
   <c:catch var="excp">${not empty portletPreferencesValues.toString()}</c:catch>
   <c:if test="${not empty excp}">undefined</c:if>
   </td>
   </tr><tr>

   <td align='left'>
   <%=ii++ %>
   </td><td align='left'>
   portletRequest
   </td><td align='left'>
   <c:catch var="excp">${not empty portletRequest.toString()}</c:catch>
   <c:if test="${not empty excp}">undefined</c:if>
   </td>
   </tr><tr>

   <td align='left'>
   <%=ii++ %>
   </td><td align='left'>
   portletResponse
   </td><td align='left'>
   <c:catch var="excp">${not empty portletResponse.toString()}</c:catch>
   <c:if test="${not empty excp}">undefined</c:if>
   </td>
   </tr><tr>

   <td align='left'>
   <%=ii++ %>
   </td><td align='left'>
   headerRequest
   </td><td align='left'>
   <c:catch var="excp">${not empty headerRequest.toString()}</c:catch>
   <c:if test="${not empty excp}">undefined</c:if>
   </td>
   </tr><tr>

   <td align='left'>
   <%=ii++ %>
   </td><td align='left'>
   headerResponse
   </td><td align='left'>
   <c:catch var="excp">${not empty headerResponse.toString()}</c:catch>
   <c:if test="${not empty excp}">undefined</c:if>
   </td>
   </tr><tr>

   <td align='left'>
   <%=ii++ %>
   </td><td align='left'>
   clientDataRequest
   </td><td align='left'>
   <c:catch var="excp">${not empty clientDataRequest.toString()}</c:catch>
   <c:if test="${not empty excp}">undefined</c:if>
   </td>
   </tr><tr>

   <td align='left'>
   <%=ii++ %>
   </td><td align='left'>
   mimeResponse
   </td><td align='left'>
   <c:catch var="excp">${not empty mimeResponse.toString()}</c:catch>
   <c:if test="${not empty excp}">undefined</c:if>
   </td>
   </tr><tr>

   <td align='left'>
   <%=ii++ %>
   </td><td align='left'>
   stateAwareResponse
   </td><td align='left'>
   <c:catch var="excp">${not empty stateAwareResponse.toString()}</c:catch>
   <c:if test="${not empty excp}">undefined</c:if>
   </td>
   </tr><tr>

   <td align='left'>
   <%=ii++ %>
   </td><td align='left'>
   renderParams
   </td><td align='left'>
   <c:catch var="excp">${not empty renderParams.toString()}</c:catch>
   <c:if test="${not empty excp}">undefined</c:if>
   </td>
   </tr><tr>

   <td align='left'>
   <%=ii++ %>
   </td><td align='left'>
   mutableRenderParams
   </td><td align='left'>
   <c:catch var="excp">${not empty mutableRenderParams.toString()}</c:catch>
   <c:if test="${not empty excp}">undefined</c:if>
   </td>
   </tr><tr>

   <td align='left'>
   <%=ii++ %>
   </td><td align='left'>
   resourceParams
   </td><td align='left'>
   <c:catch var="excp">${not empty resourceParams.toString()}</c:catch>
   <c:if test="${not empty excp}">undefined</c:if>
   </td>
   </tr><tr>

   <td align='left'>
   <%=ii++ %>
   </td><td align='left'>
   actionParams
   </td><td align='left'>
   <c:catch var="excp">${not empty actionParams.toString()}</c:catch>
   <c:if test="${not empty excp}">undefined</c:if>
   </td>
   </tr><tr>

   <td align='left'>
   <%=ii++ %>
   </td><td align='left'>
   portletContext
   </td><td align='left'>
   <c:catch var="excp">${not empty portletContext.toString()}</c:catch>
   <c:if test="${not empty excp}">undefined</c:if>
   </td>
   </tr><tr>

   <td align='left'>
   <%=ii++ %>
   </td><td align='left'>
   portletMode
   </td><td align='left'>
   <c:catch var="excp">${not empty portletMode.toString()}</c:catch>
   <c:if test="${not empty excp}">undefined</c:if>
   </td>
   </tr><tr>

   <td align='left'>
   <%=ii++ %>
   </td><td align='left'>
   windowState
   </td><td align='left'>
   <c:catch var="excp">${not empty windowState.toString()}</c:catch>
   <c:if test="${not empty excp}">undefined</c:if>
   </td>
   </tr><tr>

   <td align='left'>
   <%=ii++ %>
   </td><td align='left'>
   cookies
   </td><td align='left'>
   <c:catch var="excp">${not empty cookies.toString()}</c:catch>
   <c:if test="${not empty excp}">undefined</c:if>
   </td>
   </tr><tr>

   <td align='left'>
   <%=ii++ %>
   </td><td align='left'>
   locale
   </td><td align='left'>
   <c:catch var="excp">${not empty locale.toString()}</c:catch>
   <c:if test="${not empty excp}">undefined</c:if>
   </td>
   </tr><tr>

   <td align='left'>
   <%=ii++ %>
   </td><td align='left'>
   locales
   </td><td align='left'>
   <c:catch var="excp">${not empty locales.toString()}</c:catch>
   <c:if test="${not empty excp}">undefined</c:if>
   </td>
   </tr><tr>

   <td align='left'>
   <%=ii++ %>
   </td><td align='left'>
   namespace
   </td><td align='left'>
   <c:catch var="excp">${not empty namespace.toString()}</c:catch>
   <c:if test="${not empty excp}">undefined</c:if>
   </td>
   </tr><tr>

   <td align='left'>
   <%=ii++ %>
   </td><td align='left'>
   contextPath
   </td><td align='left'>
   <c:catch var="excp">${not empty contextPath.toString()}</c:catch>
   <c:if test="${not empty excp}">undefined</c:if>
   </td>
   </tr><tr>

   <td align='left'>
   <%=ii++ %>
   </td><td align='left'>
   windowId
   </td><td align='left'>
   <c:catch var="excp">${not empty windowId.toString()}</c:catch>
   <c:if test="${not empty excp}">undefined</c:if>
   </td>
   </tr><tr>

   <td align='left'>
   <%=ii++ %>
   </td><td align='left'>
   portletName
   </td><td align='left'>
   <c:catch var="excp">${not empty portletName.toString()}</c:catch>
   <c:if test="${not empty excp}">undefined</c:if>
   </td>
   </tr><tr>

   <!-- the objects -->
   
   </tr></table>
</div>

