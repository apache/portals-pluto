<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<html>
<head>
  <title>Pluto Portal</title>
    <style type="text/css" title="currentStyle" media="screen">
        @import "<c:out value="${pageContext.request.contextPath}"/>//pluto.css";
	</style>
    <script type="text/javascript" src="<c:out value="${pageContext.request.contextPath}"/>/pluto.js"></script>
</head>

<body>
 <div id="portal">
  <div id="header">
    Header
  </div>

<div id="navigation">
  <ul>
  <c:forEach var="page" items="${driverConfig.pages}">
  <c:choose>
  <c:when test="${page == currentPage}">
      <li class="selected"><a href="<c:out value="${pageContext.request.contextPath}"/>/portal/<c:out value="${page.name}"/>"><c:out value="${page.name}"/></a>
          <ul>
              <li>Subpage One</li>
              <li>Another Page</li>
              <li>Three Strikes</li>
          </ul>
      </li>
  </c:when>

  <c:otherwise>
      <li><a href="<c:out value="${pageContext.request.contextPath}"/>/portal/<c:out value="${page.name}"/>"><c:out value="${page.name}"/></a>
          <ul>
              <li>One, Two, Three</li>
              <li>Six, Five, Four</li>
          </ul>
      </li>
  </c:otherwise>
  </c:choose>
  </c:forEach>
  </ul>
  </div>

  <!-- The main content block -->
  <div id="content">
      <jsp:include page='<%=(String)pageContext.findAttribute("include")%>'/>
  </div>

  <div id="footer">
    Footer
  </div>
 </div>
</body>
</html>