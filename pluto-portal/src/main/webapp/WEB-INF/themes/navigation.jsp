<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://portals.apache.org/pluto" prefix="pluto" %>

<div id="navigation">
    <h2>Navigation:</h2>
    <ul>
        <li>
        <a href='<c:out value="${pageContext.request.contextPath}"/>/about.jsp'>About Pluto</a>
        </li>
        <c:forEach var="page" items="${driverConfig.pages}">
            <c:choose>
                <c:when test="${page == currentPage}">
                    <li class="selected">
                        <a href='<c:out value="${pageContext.request.contextPath}"/>/portal/<c:out value="${page.name}"/>'>
                            <c:out value="${page.name}"/>
                        </a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li>
                        <a href='<c:out value="${pageContext.request.contextPath}"/>/portal/<c:out value="${page.name}"/>'>
                            <c:out value="${page.name}"/>
                        </a>
                    </li>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </ul>
</div>
