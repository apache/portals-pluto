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

<portlet:renderURL windowState="Normal" portletMode="View" secure="False" var="url">
	<portlet:param name="jspName" value="test1.jsp"/>
</portlet:renderURL>


<FORM METHOD="POST" ACTION="<%=url%>">
<INPUT value="Next >>" TYPE="submit">
</FORM>

<b><portlet:namespace/>test@pluto.org</b>
