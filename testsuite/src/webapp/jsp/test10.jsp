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
<%@ page session="false" %>
<%@ taglib uri='http://java.sun.com/portlet' prefix='portlet'%>
<%@ page import="javax.portlet.*"%>
<%@ page import="java.util.*"%>
<portlet:defineObjects/>

<I>This portlet is testing security information:</I>

<p>To test security information, you must first log in. When configuring
your realm, ensure that the user is given the role 'tomcat'
for accurate testing. </p>

<%
    if(renderRequest.getRemoteUser()==null) {
%>
<p><b>You are not logged in</b></p>
<% } else { %>

<p>Remote User: <%= renderRequest.getRemoteUser() %></p>
<p>Is User in 'fake' role: <%=renderRequest.isUserInRole("fake")?"<FONT color=\"red\">YES</FONT>":"No" %></p>
<p>Is User in 'plutoTestRole' role: <%=!renderRequest.isUserInRole("plutoTestRole")?"<FONT color=\"red\">No</FONT>":"Yes" %></p>
<p>Is User in 'tomcat' role: <%=!renderRequest.isUserInRole("tomcat")?"<FONT color=\"red\">No</FONT>":"Yes" %></p>

<% } %>

<portlet:renderURL windowState="Normal" portletMode="View" secure="<%=renderRequest.isSecure()?"True":"False"%>" var="url">
	<portlet:param name="jspName" value="test1.jsp"/>
</portlet:renderURL>

<FORM METHOD="POST" ACTION="<%=url%>">
<INPUT value="Next >>" TYPE="submit">
</FORM>
