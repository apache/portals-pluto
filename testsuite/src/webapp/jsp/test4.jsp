<%@ page session="false" %>
<%@ taglib uri='/WEB-INF/tld/portlet.tld' prefix='portlet'%>
<%@ page import="javax.portlet.*"%>
<%@ page import="java.util.*"%>
<portlet:defineObjects/>
<%
String baseNS = renderResponse.getNamespace();
PortletSession ps = renderRequest.getPortletSession();
%>

<I>This portlet is testing basic functions...</I>
<P>
<FONT SIZE="-1">
<B>Testing Portlet Actions...</B><BR>
<%
PortletURL url = renderResponse.createActionURL();
url.setParameter("checkAction","action1");
%>
click <A HREF="<%=url.toString()%>">here</A> to invoke the first portlet action.<BR>
<%
if ("action1".equals(ps.getAttribute("checkAction", PortletSession.PORTLET_SCOPE)))
{
    out.print("Result: ");
    out.print("<b>passed</b>");
}
%>
<P>
<B>Testing RenderParameters with Portlet Actions...</B><BR>
<%
PortletURL url1 = renderResponse.createActionURL();
url1.setParameter("checkActionRender","step1");
url1.setParameter("jspNameTransfer","test4.jsp");
%>
click <A HREF="<%=url1.toString()%>">here</A> for step 1.<BR>
<%
if ("step2".equals(renderRequest.getParameter("checkActionRender2")))
{
    PortletURL url2 = renderResponse.createRenderURL();
    url2.setParameter("checkActionRender2","step2");
    url2.setParameter("checkActionRender3","step3");
    url2.setParameter("jspName","test4.jsp");
%>
click <A HREF="<%=url2.toString()%>">here</A> for step 2.<BR>
<%
}
if (("step3".equals(renderRequest.getParameter("checkActionRender3"))) &&
    ("step2".equals(renderRequest.getParameter("checkActionRender2"))))
{
    out.print("Result: ");
    out.print("<b>passed</b>");
}
%>

<%
url = renderResponse.createRenderURL();
url.setParameter("jspName","test5.jsp");
%>
<FORM METHOD="POST" ACTION="<%=url.toString()%>">
<INPUT value="Next >>" TYPE="submit">
</FORM>
</FONT>

