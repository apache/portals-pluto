<%@ page session="false" %>
<%@ taglib uri="http://xmlns.jcp.org/portlet_3_0"  prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="org.apache.portals.samples.*" %>
<%@ page import="java.util.*" %>

<portlet:defineObjects />

<div class='bluebox'>
<p>${jsptitle}</p>
<%
ArrayList<String> pathInfo = (ArrayList<String>) request.getAttribute("pathInfo");
if (pathInfo != null) {
   for (String item : pathInfo) {
      out.append(item);
   }
}

RenderLink rl = (RenderLink) request.getAttribute("renderLink");
if (rl != null) {
   out.append(rl.toString());
}

PathDisplay pd = new PathDisplay(request, "JSP (ServletRequest)");
out.append(pd.toMarkup());

pd = null;
if (resourceRequest != null) {
   pd = new PathDisplay(resourceRequest, "JSP (ResourceRequest)");
} else if (renderRequest != null) {
   pd = new PathDisplay(renderRequest, "JSP (RenderRequest)");
}
if (pd != null){
   out.append(pd.toMarkup());
}
 %>
<hr>
</div>