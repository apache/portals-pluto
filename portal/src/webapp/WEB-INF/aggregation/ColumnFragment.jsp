<%@ page session="false" buffer="none" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="org.apache.pluto.portalImpl.util.Parameters" %>
<%@ page import="org.apache.pluto.portalImpl.aggregation.Fragment" %>
<jsp:useBean id="fragment" type="org.apache.pluto.portalImpl.aggregation.Fragment" scope="request" />
<%
        Iterator iterator = fragment.getChildFragments().iterator();

        while (iterator.hasNext())
        {
            Fragment subfragment = (Fragment)iterator.next();
%>
<TD>
<%
            subfragment.service(request, response);
%>
</TD>
<%
        }
%>