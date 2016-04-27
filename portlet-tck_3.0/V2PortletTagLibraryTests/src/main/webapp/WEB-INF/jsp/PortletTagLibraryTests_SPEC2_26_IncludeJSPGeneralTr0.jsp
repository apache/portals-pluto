<%-- 
  - Author(s): ahmed
  --%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/portlet"  prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<portlet:defineObjects/>
<!-- Expected Portlet Exception because portlet:resourceURL tag is not defined for version 1 -->
<portlet:resourceURL var="V2_URL" escapeXml="true">
</portlet:resourceURL>
<%=V2_URL%>