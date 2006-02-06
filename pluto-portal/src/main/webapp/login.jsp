<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<html>
  
  <head>
    <title>Pluto Portal</title>
    <style type="text/css" title="currentStyle" media="screen">
      @import "<c:out value="${pageContext.request.contextPath}"/>/pluto.css";
    </style>
  </head>

  <body>
    <div id="portal" style="width: 500px;">
      
      <div id="header">
        <h1><span>Apache Pluto</span></h1>
        <h2><span>A Apache Portals Project</span></h2>
      </div>
      
      <div id="content">
        <c:if test='${param.error == "1"}'>
          <p style="color:red;text-align:center">
            Invalid credentials. Please try again
          </p>
        </c:if>
        <form method="POST" action="j_security_check">
          <fieldset>
            <legend>Login to Pluto</legend>
            <div>
              <label for="j_username">User Name</label>
              <input type="text" name="j_username" id="j_username"/>
            </div>
            <div>
              <label for="j_password">Password</label>
              <input type="password" name="j_password" id="j_password"/>
            </div>
            <div>
              <label for="j_login"></label>
              <input type="submit" value="Login" name="login" id="j_login"/>
            </div>
          </fieldset>
        </form>
      </div>
      
      <div id="footer">
        &copy; 2003-2005 Apache Software Foundation
      </div>
      
    </div>
  
  </body>
  
</html>


