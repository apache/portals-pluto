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

<portlet:defineObjects/>

<CENTER>
<TABLE>
<TR><TD align="center" nowrap="true">
<portlet:actionURL secure="<%=renderRequest.isSecure()?"True":"False"%>" var="url">
	<portlet:param name="nextTestId" value="<%=renderRequest.getParameter("testId") %>"/>
</portlet:actionURL>

<A href="<%=url%>"><IMG SRC="<%=renderResponse.encodeURL(renderRequest.getContextPath() + "/images/previous.png")%>" border="0"></A>

<portlet:actionURL secure="<%=renderRequest.isSecure()?"True":"False"%>" var="url">
	<portlet:param name="testId" value="xx_introduction"/>
</portlet:actionURL>

<A href="<%=url%>"><IMG SRC="<%=renderResponse.encodeURL(renderRequest.getContextPath() + "/images/return_index.png")%>" border="0"></A>

<portlet:actionURL secure="<%=renderRequest.isSecure()?"True":"False"%>" var="url">
	<portlet:param name="previousTestId" value="<%=renderRequest.getParameter("testId")%>"/>
</portlet:actionURL>

<A href="<%=url%>"><IMG SRC="<%=renderResponse.encodeURL(renderRequest.getContextPath() + "/images/next.png")%>" border="0"></A>
</TD></TR>
</TABLE>
</CENTER>



