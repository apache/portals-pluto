<%@ page session="false" %>
<%@ page isELIgnored ="false" %> 
<%@ taglib uri="http://xmlns.jcp.org/portlet_3_0"  prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<portlet:defineObjects />

<h5><%=request.getAttribute("title") %> for portlet: 
<c:catch var ="exp">
   <!-- try to get portlet name using named bean from portlet artifact producer. -->
   <!-- Works in the case of PortletRequestDispatcher include / forward. -->
   ${portletConfig.getPortletName()} (using named bean)
</c:catch>
<c:if test = "${exp != null}">
   <!-- Contextual context not available during async dispatch -->
   <%=portletConfig.getPortletName() %> (using JSP expression)
</c:if>
</h5>
<p>Dispatch type: <%=resourceRequest.getDispatcherType() %>
<c:catch var ="exp">
   <span style='margin-left: 2em;'>Request #: ${reqnum.getRandomNumber()}</span>
</c:catch>
</p>
<hr>
