<!-- 
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
-->

<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<%-- c:if test="${pageContext.errorData!=null}"
<% if(pageContext.getErrorData()!=null) { %>
   // getErrorData throws NullPointerException in Tomcat 5.0.x
<P>
<TABLE>
<TR><TH colspan="2">Error Data</TH></TR>
<TR><TD>Status Code</TD>
    <TD><c:out value="${pageContext.errorData.statusCode}"/></TD></TR>
<TR><TD>Servlet Name</TD>
    <TD><c:out value="${pageContext.errorData.servletName}"/></TD></TR>
<TR><TD>Request URI</TD>
    <TD><c:out value="${pageContext.errorData.requestURI}"/></TD></TR>
<TR><TD>Request URI</TD>
    <TD><c:out value="${pageContext.errorData.throwable.message}"/></TD></TR>
</TABLE>
<P>
<% } %>
<%-- /c:if --%>

<c:if test="${pageContext.exception!=null}">
<p>
<TABLE>
<TR><TH colspan="2">Exception</TH></TR>
<TR><TD>Exception Class</TD>
    <TD><c:out value="${pageContext.exception.class}"/></TD></TR>
<TR><TD>Exception Message</TD>
    <TD><c:out value="${pageContext.exception.message}"/></TD></TR>
</TABLE>
</p>
</c:if>

<!-- SESSION ATTRS -->
<TABLE>
<TR><TH colspan="2">Session Attributes</TH></TR>
<TR><TH>Keys</TH>
    <TH>Values</TH></TR>
<c:forEach var="attr" items="${pageContext.session.attributeNames}">
<TR><TD><bean:write name="attr"/></TD>
    <TD><%= session.getAttribute((String) pageContext.findAttribute("attr"))%></TD></TR>
</c:forEach>
</TABLE>
</P>

<P>
<!-- Request ATTRS -->
<TABLE>
<TR><TH colspan="2">Request Attributes</TH></TR>
<TR><TH>Keys</TH>
<TH>Values</TH></TR>
<c:forEach var="attr" items="${pageContext.request.attributeNames}">
<TR><TD><bean:write name="attr"/></TD>
<TD><%= session.getAttribute((String) pageContext.findAttribute("attr"))%></TD></TR>
</c:forEach>
</TABLE>
</P>


<P>
<!-- Page ATTRS -->
<%--
<TABLE>
<TR><TH colspan="2">Page Attributes</TH></TR>
<TR><TH>Keys</TH>
<TH>Values</TH></TR>
<c:forEach var="attr" items="${pageContext.attributeNames}">
<TR><TD><bean:write name="attr"/></TD>
<TD><%= session.getAttribute((String) pageContext.findAttribute("attr"))%></TD></TR>
</c:forEach>
</TABLE>
--%>
</P>


