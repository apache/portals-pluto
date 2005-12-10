<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<TABLE>
<TR><TH>About the Pluto Portal Driver</TH></TR>

<td>
<p>
Portal Name: <c:out value="${driverConfig.portalName}"/> <br/>
Portal Version: <c:out value="${driverConfig.portalVersion}"/> <br/>
Servlet Container: <%= config.getServletContext().getServerInfo() %> <br/>
Pluto Home Page: <a href="http://portals.apache.org/pluto/" target="_blank">http://portals.apache.org/pluto/</a><br/>
</p>
<p>
<i>Please use the <a href="http://issues.apache.org/jira/secure/BrowseProject.jspa?id=10560" target="_blank">
Jira issue tracking site</a> to record any problems you are having with the Pluto portal server.</i><br/>
</p>
</td>

<TR><TD> </TD></TR>
</TABLE>