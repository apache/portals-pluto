<%@ page session="false" buffer="none" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="org.apache.pluto.portalImpl.util.Parameters" %>
<%@ page import="org.apache.pluto.portalImpl.core.PortalURL" %>
<%@ page import="org.apache.pluto.portalImpl.core.PortalEnvironment" %>
<%@ page import="org.apache.pluto.portalImpl.aggregation.Fragment" %>
<%@ page import="org.apache.pluto.portalImpl.aggregation.navigation.Navigation" %>
<%@ page import="org.apache.pluto.portalImpl.aggregation.PageFragment" %>
<jsp:useBean id="fragment" type="org.apache.pluto.portalImpl.aggregation.Fragment" scope="request" />
<%
    PortalURL url = PortalEnvironment.getPortalEnvironment(request).getRequestedPortalURL();
    if (url.isPartOfGlobalNavigation(fragment.getId()))
    {
%>
<I><%=fragment.getNavigation().getTitle()%></I><br>
<%
        Iterator childIterator = fragment.getChildFragments().iterator();
        while (childIterator.hasNext())
        {
            Fragment subfragment = (Fragment)childIterator.next();

            subfragment.service(request, response); 

        }
%>
<%
    }
%>
