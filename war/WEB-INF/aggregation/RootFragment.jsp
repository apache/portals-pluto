<%@ page session="true" buffer="none" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="org.apache.pluto.portalImpl.util.Parameters" %>
<%@ page import="org.apache.pluto.portalImpl.core.PortalURL" %>
<%@ page import="org.apache.pluto.portalImpl.core.PortalEnvironment" %>
<%@ page import="org.apache.pluto.portalImpl.aggregation.Fragment" %>
<%@ page import="org.apache.pluto.portalImpl.aggregation.navigation.AbstractNavigationFragment" %>
<jsp:useBean id="fragment" class="org.apache.pluto.portalImpl.aggregation.Fragment" scope="request" />
<html>
<%@ include file="./Head.jsp" %>
<body marginwidth="0" marginheight="0">
<%@ include file="./Banner.jsp" %>
<table border="0" cellpadding="0" cellspacing="2" width="100%">
  <tr>
    <td width="30%" valign="top">
<%
        Iterator childIterator = fragment.getChildFragments().iterator();

        while (childIterator.hasNext()) {
            Fragment subfragment = (Fragment)childIterator.next();

            if (subfragment instanceof AbstractNavigationFragment)
            {
                subfragment.service(request, response);
                break;
            }

        }
%>
    </td>
    <td valign="top">
<%
        childIterator = fragment.getChildFragments().iterator();

        while (childIterator.hasNext()) {
            Fragment subfragment = (Fragment)childIterator.next();

            if (!(subfragment instanceof AbstractNavigationFragment))
            {
                subfragment.service(request, response);
            }

        }
%>
    </td>
  </tr>
</table>
</body>
</html>