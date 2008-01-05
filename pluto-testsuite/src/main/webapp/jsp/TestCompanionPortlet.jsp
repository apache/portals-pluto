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

<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet"%>

<portlet:defineObjects/>

<div class="portlet-section-body">
<p>
  This portlet is a companion portlet to the 286 Test Portlet.
  It is designed to test interportlet coordination features of version 2.0 of the
  Java Portlet API (JSR-286) which include public render parameters and eventing.  
</p>
<%-- FIXME: This code does not work.
    <table border="1">    
        <thead>
            <tr>
	                <th colspan="2">Public Render Parameters</th>
            </tr>
            <tr>
                <th>Name</th>
                <th>Value(s)</th>
            </tr>
        </thead>
        <tbody>
            <c:choose>
                <c:when test="${empty renderRequest.publicParameterMap}">
                    <tr>
                        <td>No public render parameters set.</td>
                    </tr>
                </c:when>
                <c:otherwise>
                    <c:forEach items="${renderRequest.publicParameterMap}" var="param">
                        <tr>
                            <td><c:out value="${param.key}" /></td>
                            <td>
                                <c:forEach items="${param.value}" var="val">
                                    <div><c:out value="${val}" /></div>
                                </c:forEach>
                            </td>
                        </tr>                    
                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </tbody>
    </table>
 --%>
<c:if test="${not empty eventInfo}">
	<p>
		<h4>Information from last event:</h4>
		<p><c:out value="${eventInfo}" /></p>
	</p>
</c:if>
</div>