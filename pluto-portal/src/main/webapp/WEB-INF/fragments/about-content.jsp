<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<TABLE>
<TR><TH>About the Pluto Portal Driver</TH></TR>

<td>
Portal Name: <c:out value="${driverConfig.portalName}"/> <br>
Portal Version: <c:out value="${driverConfig.portalVersion}"/> <br>
Servlet Container: <%= config.getServletContext().getServerInfo() %> <br>
</td>

<TR><TD> </TD></TR>
</TABLE>