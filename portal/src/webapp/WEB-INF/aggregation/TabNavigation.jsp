<%@ page session="false" buffer="none" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="org.apache.pluto.portalImpl.util.Parameters" %>
<%@ page import="org.apache.pluto.portalImpl.core.PortalURL" %>
<%@ page import="org.apache.pluto.portalImpl.core.PortalEnvironment" %>
<%@ page import="org.apache.pluto.portalImpl.aggregation.Fragment" %>
<%@ page import="org.apache.pluto.portalImpl.aggregation.navigation.Navigation" %>
<%@ page import="org.apache.pluto.portalImpl.aggregation.navigation.NavigationTreeBean" %>
<jsp:useBean id="fragment" class="org.apache.pluto.portalImpl.aggregation.navigation.TabNavigation" scope="request" />
<table border="0" cellspacing="0" cellpadding="0" width="100%">
<%
    PortalURL url = PortalEnvironment.getPortalEnvironment(request).getRequestedPortalURL();
    NavigationTreeBean[] tree = fragment.getNavigationView(url);
    for (int i=0; i<tree.length; i++) {
            %><TR><%
            Navigation nav = tree[i].navigation;
            boolean partOfNav = tree[i].partOfGlobalNav;
            if (partOfNav) {
                %><td bgcolor="#0000B4" nowrap><%
            } else {
                %><td bgcolor="#AAAAFF" nowrap><%
            }
            for (int k=0; k<tree[i].depth; k++) {
                %>&nbsp;&nbsp;&nbsp;<%
            }
            %>&nbsp;<a href="<%=new PortalURL(request, nav.getLinkedFragment()).toString()%>"><%
            if (partOfNav) {
                %><font color="#FFFFFF"><B><%
            } else {
                %><font color="#000000"><%
            }
            %><%=nav.getTitle()%><%
            if (partOfNav) {
                %></font></B><%
            }else {
                %></font><%
            }
            %></A>&nbsp;</TD><%
            %><TR><%
    }

%>
</table>

