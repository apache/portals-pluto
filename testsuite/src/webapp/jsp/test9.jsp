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
<%@ taglib uri='/WEB-INF/tld/portlet.tld' prefix='portlet'%>
<%@ page import="javax.portlet.*"%>
<%@ page import="java.util.*"%>
<portlet:defineObjects/>
<%
String baseNS = renderResponse.getNamespace();
PortletSession ps = renderRequest.getPortletSession();
%>
<I>This portlet is testing "actionURL"/"renderURL" tags ... Step 9</I>
<P>
<I>1) define tag "actionURL" and display it's string value ...</I>
<P>
<portlet:actionURL windowState="Maximized" portletMode="Edit" secure="False" var="toto">
	<portlet:param name="myParam" value="testParam"/>
</portlet:actionURL>

<i><%=toto%>
<P>
<I>2) define tag "renderURL" and display it's string value ...</I>
<P>
<portlet:renderURL windowState="Maximized" portletMode="Edit" secure="False" var="_url">
	<portlet:param name="jspName" value="test1.jsp"/>
</portlet:renderURL>
<i><%=_url%>
<P>
<I>Tests passed ...</I>
<P>

<portlet:renderURL windowState="Normal" portletMode="View" secure="<%=renderRequest.isSecure()?"True":"False"%>" var="url">
	<portlet:param name="jspName" value="test1.jsp"/>
</portlet:renderURL>

<FORM METHOD="POST" ACTION="<%=url%>">
<INPUT value="Next >>" TYPE="submit">
</FORM>

<b><portlet:namespace/>test@pluto.org</b>