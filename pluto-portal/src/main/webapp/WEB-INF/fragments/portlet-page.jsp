<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://portals.apache.org/pluto" prefix="pluto" %>
<TABLE>
<c:forEach var="portlet" varStatus="status" items="${currentPage.portletIds}">
<c:if test="${status.index % 2 == 0}">
<TR>
</c:if>
<TD valign="top"><c:set var="portlet" value="${portlet}" scope="request"/><jsp:include page="portlet-skin.jsp"/></TD>
<c:if test="${status.index % 2 != 0}">
</TR>
</c:if>
</c:forEach>
</TABLE>
