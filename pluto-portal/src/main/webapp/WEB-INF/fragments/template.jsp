<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<!--
  Portal page template JSP used by the Pluto Portal Driver.
  This JSP requires that the following attributes are set:
   * driverConfig: org.apache.pluto.driver.config.DriverConfiguration
   * 
   * TODO:
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
      
      <!-- Content block: we include another page to display portlets -->
      <div id="content">
        <jsp:include page='<%= (String) pageContext.findAttribute("include") %>'/>
      </div>
      
      <!-- Footer block: copyright -->
      <div id="footer">
        &copy; 2003-2005 Apache Software Foundation
      </div>
      
    </div>
    
  </body>
  
</html>


