<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<!--
  This JSP is included by the Pluto Portal page template to display portlets.
  It divides all portlets into two groups (div blocks): the first group displays
  portlets with odd IDs, while the second group displays portlets with even IDs.
  This JSP requires that the following attributes are set:
   * currentPage: 
  -->

<div id="portlets-left-column">
  <c:forEach var="portlet" varStatus="status"
             items="${currentPage.portletIds}" step="2">
    <c:set var="portlet" value="${portlet}" scope="request"/>
    <jsp:include page="portlet-skin.jsp"/>
  </c:forEach>
</div>

<div id="portlets-right-column">
  <c:forEach var="portlet" varStatus="status"
             items="${currentPage.portletIds}" begin="1" step="2">
    <c:set var="portlet" value="${portlet}" scope="request"/>
    <jsp:include page="portlet-skin.jsp"/>
  </c:forEach>
</div>

