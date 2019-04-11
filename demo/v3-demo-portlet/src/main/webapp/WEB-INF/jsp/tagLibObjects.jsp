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

<portlet:defineObjects />

<div class='infobox'>
   <h4>Objects for phase: <%=portletRequest.getAttribute(LIFECYCLE_PHASE)%></h4>
   
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
   <%out.print(renderRequest != null); %>
   </td>
   </tr><tr>

   <td align='left'>
   <%=ii++ %>
   </td><td align='left'>
   resourceRequest
   </td><td align='left'>
   <%out.print(resourceRequest != null); %>
   </td>
   </tr><tr>

   <td align='left'>
   <%=ii++ %>
   </td><td align='left'>
   actionRequest
   </td><td align='left'>
   <%out.print(actionRequest != null); %>
   </td>
   </tr><tr>

   <td align='left'>
   <%=ii++ %>
   </td><td align='left'>
   eventRequest
   </td><td align='left'>
   <%out.print(eventRequest != null); %>
   </td>
   </tr><tr>

   <td align='left'>
   <%=ii++ %>
   </td><td align='left'>
   renderResponse
   </td><td align='left'>
   <%out.print(renderResponse != null); %>
   </td>
   </tr><tr>

   <td align='left'>
   <%=ii++ %>
   </td><td align='left'>
   resourceResponse
   </td><td align='left'>
   <%out.print(resourceResponse != null); %>
   </td>
   </tr><tr>

   <td align='left'>
   <%=ii++ %>
   </td><td align='left'>
   actionResponse
   </td><td align='left'>
   <%out.print(actionResponse != null); %>
   </td>
   </tr><tr>

   <td align='left'>
   <%=ii++ %>
   </td><td align='left'>
   eventResponse
   </td><td align='left'>
   <%out.print(eventResponse != null); %>
   </td>
   </tr><tr>

   <td align='left'>
   <%=ii++ %>
   </td><td align='left'>
   portletConfig
   </td><td align='left'>
   <%out.print(portletConfig != null); %>
   </td>
   </tr><tr>

   <td align='left'>
   <%=ii++ %>
   </td><td align='left'>
   portletSession
   </td><td align='left'>
   <%out.print(portletSession != null); %>
   </td>
   </tr><tr>

   <td align='left'>
   <%=ii++ %>
   </td><td align='left'>
   portletSessionScope
   </td><td align='left'>
   <%out.print(portletSessionScope != null); %>
   </td>
   </tr><tr>

   <td align='left'>
   <%=ii++ %>
   </td><td align='left'>
   portletPreferences
   </td><td align='left'>
   <%out.print(portletPreferences != null); %>
   </td>
   </tr><tr>

   <td align='left'>
   <%=ii++ %>
   </td><td align='left'>
   portletPreferencesValues
   </td><td align='left'>
   <%out.print(portletPreferencesValues != null); %>
   </td>
   </tr><tr>

   <td align='left'>
   <%=ii++ %>
   </td><td align='left'>
   portletRequest
   </td><td align='left'>
   <%out.print(portletRequest != null); %>
   </td>
   </tr><tr>

   <td align='left'>
   <%=ii++ %>
   </td><td align='left'>
   portletResponse
   </td><td align='left'>
   <%out.print(portletResponse != null); %>
   </td>
   </tr><tr>

   <td align='left'>
   <%=ii++ %>
   </td><td align='left'>
   headerRequest
   </td><td align='left'>
   <%out.print(headerRequest != null); %>
   </td>
   </tr><tr>

   <td align='left'>
   <%=ii++ %>
   </td><td align='left'>
   headerResponse
   </td><td align='left'>
   <%out.print(headerResponse != null); %>
   </td>
   </tr><tr>

   <td align='left'>
   <%=ii++ %>
   </td><td align='left'>
   clientDataRequest
   </td><td align='left'>
   <%out.print(clientDataRequest != null); %>
   </td>
   </tr><tr>

   <td align='left'>
   <%=ii++ %>
   </td><td align='left'>
   mimeResponse
   </td><td align='left'>
   <%out.print(mimeResponse != null); %>
   </td>
   </tr><tr>

   <td align='left'>
   <%=ii++ %>
   </td><td align='left'>
   stateAwareResponse
   </td><td align='left'>
   <%out.print(stateAwareResponse != null); %>
   </td>
   </tr><tr>

   <td align='left'>
   <%=ii++ %>
   </td><td align='left'>
   renderParams
   </td><td align='left'>
   <%out.print(renderParams != null); %>
   </td>
   </tr><tr>

   <td align='left'>
   <%=ii++ %>
   </td><td align='left'>
   mutableRenderParams
   </td><td align='left'>
   <%out.print(mutableRenderParams != null); %>
   </td>
   </tr><tr>

   <td align='left'>
   <%=ii++ %>
   </td><td align='left'>
   resourceParams
   </td><td align='left'>
   <%out.print(resourceParams != null); %>
   </td>
   </tr><tr>

   <td align='left'>
   <%=ii++ %>
   </td><td align='left'>
   actionParams
   </td><td align='left'>
   <%out.print(actionParams != null); %>
   </td>
   </tr><tr>

   <td align='left'>
   <%=ii++ %>
   </td><td align='left'>
   portletContext
   </td><td align='left'>
   <%out.print(portletContext != null); %>
   </td>
   </tr><tr>

   <td align='left'>
   <%=ii++ %>
   </td><td align='left'>
   portletMode
   </td><td align='left'>
   <%out.print(portletMode != null); %>
   </td>
   </tr><tr>

   <td align='left'>
   <%=ii++ %>
   </td><td align='left'>
   windowState
   </td><td align='left'>
   <%out.print(windowState != null); %>
   </td>
   </tr><tr>

   <td align='left'>
   <%=ii++ %>
   </td><td align='left'>
   cookies
   </td><td align='left'>
   <%out.print(cookies != null); %>
   </td>
   </tr><tr>

   <td align='left'>
   <%=ii++ %>
   </td><td align='left'>
   locale
   </td><td align='left'>
   <%out.print(locale != null); %>
   </td>
   </tr><tr>

   <td align='left'>
   <%=ii++ %>
   </td><td align='left'>
   locales
   </td><td align='left'>
   <%out.print(locales != null); %>
   </td>
   </tr><tr>

   <td align='left'>
   <%=ii++ %>
   </td><td align='left'>
   namespace
   </td><td align='left'>
   <%out.print(namespace != null); %>
   </td>
   </tr><tr>

   <td align='left'>
   <%=ii++ %>
   </td><td align='left'>
   contextPath
   </td><td align='left'>
   <%out.print(contextPath != null); %>
   </td>
   </tr><tr>

   <td align='left'>
   <%=ii++ %>
   </td><td align='left'>
   windowId
   </td><td align='left'>
   <%out.print(windowId != null); %>
   </td>
   </tr><tr>

   <td align='left'>
   <%=ii++ %>
   </td><td align='left'>
   portletName
   </td><td align='left'>
   <%out.print(portletName != null); %>
   </td>
   </tr><tr>

   <!-- the objects -->
   
   </tr></table>
</div>

