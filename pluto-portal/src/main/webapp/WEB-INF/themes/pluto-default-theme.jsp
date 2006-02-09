<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<!--
  Portal page template for default theme used by the Pluto Portal Driver.
  This template divides all portlets into two groups (div blocks): the first
  group (the left column) displays portlets with odd IDs, while the second group
  (the right column) displays portlets with even IDs.
  -->

<html>
  
  <head>
    <title>Pluto Portal</title>
    <style type="text/css" title="currentStyle" media="screen">
      @import "<c:out value="${pageContext.request.contextPath}"/>/pluto.css";
    </style>
    <script type="text/javascript"
            src="<c:out value="${pageContext.request.contextPath}"/>/pluto.js">
    </script>
  </head>

  <body>
  
    <div id="portal">
      
      <!-- Header block: the Apache Pluto banner image and description -->
      <div id="header">
        <h1>Apache Pluto</h1>
        <p>An Apache Portals Project</p>
      </div>
      
      <!-- Navigation block: links to portal pages -->
      <div id="navigation">
        <h2>Navigation:</h2>
        <ul>
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
      
      <!-- Content block: portlets are divided into two columns/groups -->
      <div id="content">
        
        <!-- Left column -->
        <div id="portlets-left-column">
          <c:forEach var="portlet" varStatus="status"
                     items="${currentPage.portletIds}" step="2">
            <c:set var="portlet" value="${portlet}" scope="request"/>
            <jsp:include page="portlet-skin.jsp"/>
          </c:forEach>
        </div>
        
        <!-- Right column -->
        <div id="portlets-right-column">
          <c:forEach var="portlet" varStatus="status"
                     items="${currentPage.portletIds}" begin="1" step="2">
            <c:set var="portlet" value="${portlet}" scope="request"/>
            <jsp:include page="portlet-skin.jsp"/>
          </c:forEach>
        </div>
        
      </div>
      
      <!-- Footer block: copyright -->
      <div id="footer">
        &copy; 2003-2005 Apache Software Foundation
      </div>
      
    </div>
    
  </body>
  
</html>


