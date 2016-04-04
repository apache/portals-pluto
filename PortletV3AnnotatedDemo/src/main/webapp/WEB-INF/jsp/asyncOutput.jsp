<%@ page session="false" %>
<%@ page isELIgnored ="false" %> 
<%@ taglib uri="http://xmlns.jcp.org/portlet_3_0"  prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<portlet:defineObjects />

<h5><%=request.getAttribute("title") %> for portlet: <%=portletConfig.getPortletName() %></h5>
<p>Dispatch type: <%=request.getDispatcherType() %>
<c:catch var ="catchException">
   <span style='margin-left: 2em;'>Request #: ${reqnum.getRandomNumber()}</span>
</c:catch>
</p>
<hr>
