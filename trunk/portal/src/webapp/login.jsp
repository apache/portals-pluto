
<html>
<%@ include file="./WEB-INF/aggregation/Head.jsp" %>
<body marginwidth="0" marginheight="0">
<%@ include file="./WEB-INF/aggregation/Banner.jsp" %>
<table>
<tr><td valign="top" width="150">
<span class="nav" style="width:150px">
<a href="/pluto/portal">Pluto Portal Home</a></span>
</td></tr>
</table>
	<div style="width:600px;margin-left:20%;align-text:center">
	<%
	if (request.getParameter("error") != null) {
	%>
		<p style="color:red;text-align:center">
		Login failure!. Please try again.
		</p>
	<% } %>
		<p style="font-weight:bold;text-align:center">
		This is Pluto's login page, which is used in the Test portlet's Security
		Mapping Test to show that programmatic security as defined in the JSR-168
		specification (PLT. 20) functions correctly in the Pluto portal.<br/>
		If you are using an out of the box configuration, you may be able
        to use tomcat/tomcat to login.
		</p>
	<table width="200" border="0">
	 <form method="POST" action="j_security_check">

	  <tr><td style="text-align:right">Login name: </td><td><input type="text" name="j_username"></td></tr>
	  <tr><td style="text-align:right">Login password: </td><td><input type="password" name="j_password"></td></tr>
	  <tr><td colspan="2" style="text-align:center"><input type="submit" value="Login"></td></tr>
	</form>
	</table>
	</div>

</body>
</html>