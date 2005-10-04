<%--
Copyright 2004 The Apache Software Foundation
Licensed  under the  Apache License,  Version 2.0  (the "License");
you may not use  this file  except in  compliance with the License.
You may obtain a copy of the License at

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

<%
    pageContext.setAttribute("passed", "Passed");
    pageContext.setAttribute("failed", "Failed");
    pageContext.setAttribute("warning", "Warning");
%>

<portlet:defineObjects/>

<TABLE style="font-size: -1">
<c:choose>
<c:when test="${results.failed}">
<TR><TH colspan="2" style="background-color:red;color:white">FAILED</TH></TR>
</c:when>
<c:when test="${results.inQuestion}">
<TR><TH colspan="2" style="background-color:yellow">WARNING</TH></TR>
</c:when>
<c:otherwise>
<TR><TH colspan="2" style="background-color:green;color:white">PASSED</FONT></c:otherwise>
</c:choose>

<TR><TH></TH>
    <TH><c:out value="${results.name}"/></TH>
<c:forEach var="result" varStatus="status" items="${results.collection}">
<TR><TD valign="top">
    <c:choose>
    <c:when test="${result.returnCode==passed}">
    <IMG src="<%=renderResponse.encodeURL(renderRequest.getContextPath() + "/images/yes.gif")%>" border="0">
    </c:when>
    <c:when test="${result.returnCode==failed}">
    <IMG src="<%=renderResponse.encodeURL(renderRequest.getContextPath() + "/images/no.gif")%>" border="0">
    </c:when>
    <c:otherwise>
    <IMG src="<%=renderResponse.encodeURL(renderRequest.getContextPath() + "/images/question.gif")%>" border="0">
    </c:otherwise>
    </c:choose>
    </TD>
    <TD style="font-size:12px;" nowrap="true"><c:out value="${result.name}"/></TD></TR>
    <c:choose>
    <c:when test="${result.returnCode==passed}">
    <TR><TD></TD><TD style="font-size:10px;"><c:out value="${result.desc}"/></TD></TR>
    </c:when>
    <c:otherwise>
    <TR><TD></TD><TD style="font-size:10px;"><c:out value="${result.results}"/></TD></TR>
    </c:otherwise>
    </c:choose>
</c:forEach>
</TABLE>