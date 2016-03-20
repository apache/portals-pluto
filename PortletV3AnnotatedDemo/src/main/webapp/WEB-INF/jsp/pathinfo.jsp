<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0"  prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="org.apache.portals.samples.*" %>
<%@ page import="java.util.*" %>

<!--   portlet:defineObjects /  -->

<p>Message from included JSP.</p>
<%
ArrayList<String> pathInfo = (ArrayList<String>) request.getAttribute("pathInfo");
if (pathInfo != null) {
   for (String item : pathInfo) {
      out.append(item);
   }
}

PathDisplay pd = new PathDisplay(request, "JSP");
out.append(pd.toMarkup());
 %>
<hr>
