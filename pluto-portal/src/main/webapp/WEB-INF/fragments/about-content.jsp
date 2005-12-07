<%@ page import="org.apache.pluto.driver.config.DriverConfiguration" %>
<%@ page import="org.apache.pluto.driver.AttributeKeys" %>

<TABLE>
<TR><TH>About the Pluto Portal Driver</TH></TR>
<%
	DriverConfiguration dconfig = (DriverConfiguration) config.getServletContext()
            .getAttribute(AttributeKeys.DRIVER_CONFIG);
%>

<td>
Portal Name: <%= dconfig.getPortalName() %> <br>
Portal Version: <%= dconfig.getPortalVersion() %> <br>
Servlet Container: <%= config.getServletContext().getServerInfo() %> <br>
</td>

<TR><TD> </TD></TR>
</TABLE>