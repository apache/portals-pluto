<%@ page session="false" %>
<%@ taglib uri='/WEB-INF/tld/portlet.tld' prefix='portlet'%>
<%@ page import="javax.portlet.*"%>
<%@ page import="java.util.*"%>
<portlet:defineObjects/>
<%
    String baseNS = renderResponse.getNamespace();
%>

<I>This portlet is testing basic functions...</I>
<P>
<FONT SIZE="-1">
Status:<BR>
Current Portlet Mode: <B><%=renderRequest.getPortletMode()%></B><BR>
Current Window State: <B><%=renderRequest.getWindowState()%></B><BR>
<P>
<B>Testing renderResponse...</B><BR>
encodeURL()...<BR>
<IMG SRC="<%=renderResponse.encodeURL(renderRequest.getContextPath() + "/images/haring1.gif")%>">
<BR><BR>
<B>PortletURL...</B><BR>
<%
PortletURL url = renderResponse.createRenderURL();
url.setPortletMode(PortletMode.VIEW);
url.setParameter("jspName","test3.jsp");
%>
click <A HREF="<%=url.toString()%>">here</A> to change into VIEW mode.<BR>
<%
url = renderResponse.createRenderURL();
url.setPortletMode(PortletMode.EDIT);
url.setParameter("jspName","test3.jsp");
%>
click <A HREF="<%=url.toString()%>">here</A> to change into EDIT mode.<BR>
<%
url = renderResponse.createRenderURL();
url.setPortletMode(PortletMode.HELP);
url.setParameter("jspName","test3.jsp");
%>
click <A HREF="<%=url.toString()%>">here</A> to change into HELP mode.<BR>
<%
url = renderResponse.createRenderURL();
url.setWindowState(WindowState.NORMAL);
url.setParameter("jspName","test3.jsp");
%>
click <A HREF="<%=url.toString()%>">here</A> to change into NORMAL window state.<BR>
<%
url = renderResponse.createRenderURL();
url.setWindowState(WindowState.MINIMIZED);
url.setParameter("jspName","test3.jsp");
%>
click <A HREF="<%=url.toString()%>">here</A> to change into MINIMIZED window state.<BR>
<%
url = renderResponse.createRenderURL();
url.setWindowState(WindowState.MAXIMIZED);
url.setParameter("jspName","test3.jsp");
%>
click <A HREF="<%=url.toString()%>">here</A> to change into MAXIMIZED window state.<BR>
<%
url = renderResponse.createRenderURL();
url.setParameter("jspName","test4.jsp");
%>
<FORM METHOD="POST" ACTION="<%=url.toString()%>">
<INPUT value="Next >>" TYPE="submit">
</FORM>
</FONT>

