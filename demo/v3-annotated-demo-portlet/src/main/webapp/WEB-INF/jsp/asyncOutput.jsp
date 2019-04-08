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
<%@ page isELIgnored ="false" %> 
<%@ taglib uri="http://xmlns.jcp.org/portlet_3_0"  prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<portlet:defineObjects />

<h5><%=request.getAttribute("title") %> for portlet: 
<c:catch var ="exp">
   <!-- try to get portlet name using named bean from portlet artifact producer. -->
   <!-- Works in the case of PortletRequestDispatcher include / forward. -->
   ${portletConfig.getPortletName()} (using named bean)
</c:catch>
<c:if test = "${exp != null}">
   <!-- Contextual context not available during async dispatch -->
   <%=portletConfig.getPortletName() %> (using JSP expression)
</c:if>
</h5>
<p>Dispatch type: <%=resourceRequest.getDispatcherType() %>
<c:catch var ="exp">
   <span style='margin-left: 2em;'>Request #: ${reqnum.getRandomNumber()}</span>
</c:catch>
</p>
<p>Query string parameter qp1: <%=resourceRequest.getResourceParameters().getValue("qp1") %>
<hr>
