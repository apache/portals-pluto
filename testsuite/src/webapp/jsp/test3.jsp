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
url.setSecure(renderRequest.isSecure());
%>
<FORM METHOD="POST" ACTION="<%=url.toString()%>">
<INPUT value="Next >>" TYPE="submit">
</FORM>
</FONT>

