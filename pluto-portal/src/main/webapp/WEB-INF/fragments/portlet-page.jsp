<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://portals.apache.org/pluto" prefix="pluto" %>

<div id="portletgroupone">
  <c:forEach var="portlet" varStatus="status" items="${currentPage.portletIds}" step="2">
    <c:set var="portlet" value="${portlet}" scope="request"/>
    <jsp:include page="portlet-skin.jsp"/>
  </c:forEach>
</div>

<div id="portletgrouptwo">
    <c:forEach var="portlet" varStatus="status" items="${currentPage.portletIds}" begin="1">
        <c:set var="portlet" value="${portlet}" scope="request"/>
        <jsp:include page="portlet-skin.jsp"/>
    </c:forEach>
</div>