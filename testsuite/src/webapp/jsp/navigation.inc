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



