<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0"  prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<portlet:defineObjects />

<c:if test="${imgSrc != null}">
   <img src="${imgSrc}" style='border:1px solid blue;' >
</c:if>