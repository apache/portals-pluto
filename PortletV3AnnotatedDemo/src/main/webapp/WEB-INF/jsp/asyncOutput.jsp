<%@ page session="false" %>
<%@ page isELIgnored ="false" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<h5><%=request.getAttribute("title") %></h5>
<p>Dispatch type: <%=request.getDispatcherType() %></p>
<hr>
