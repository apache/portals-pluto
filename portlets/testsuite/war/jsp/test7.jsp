<%@ page session="true" %>
<%@ taglib uri='/WEB-INF/tld/portlet.tld' prefix='portlet'%>
<%@ page import="javax.portlet.*"%>
<%@ page import="java.util.*"%>
<portlet:defineObjects/>
<%
    String baseNS = renderResponse.getNamespace();
%>
<I>This portlet is testing basic functions...</I>
<P><FONT SIZE="-1">
<B>TestPortlet ok?</B>
<P>

<%
PortletURL url = renderResponse.createRenderURL();
url.setParameter("jspName","test1.jsp");
%>
<FORM METHOD="POST" ACTION="<%=url.toString()%>">
<INPUT value="Next >>" TYPE="submit">
</FORM>
</FONT>
