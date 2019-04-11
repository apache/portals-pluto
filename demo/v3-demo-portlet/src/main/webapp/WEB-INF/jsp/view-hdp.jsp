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
<%@ taglib uri="http://xmlns.jcp.org/portlet_3_0"  prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="static org.apache.portals.pluto.demo.v3.Constants.*" %>

<portlet:defineObjects />

<div class='headerPortlet'>
<h3>V3 Header Portlet</h3><hr/>
<p>
Portlet to demo the V3 header request functionality. The portlet uses a CSS class that sets a border and
background color. The corresponding style sheet is set through the PortletResponse#addProperty(String, Element)
method. 
</p>
<p>
Character encoding: <%=renderResponse.getCharacterEncoding() %>, 
Content type: <%=renderResponse.getContentType() %>
</p>
<p>
The following section shows cookie information inserted by JavaScript code that was added to the 
output stream during the header phase processing.
</p>
<div  class='markupSection' id='<portlet:namespace/>cookieDiv'></div>
<h5>Portlet Response Properties (read from HeaderResponse):</h5>
<ul>
<c:forEach items="<%=portletSession.getAttribute(ATTRIB_PROPS) %>" var="prop">
   <li><c:out value="${prop}"></c:out></li>
</c:forEach>
</ul>
</div>
