<%@ page import="java.util.Map"%>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<TABLE class="leftnav">
<!-- Main Pages -->

<TR><TD width="5%"></TD>
    <TD width="*"></TD></TR>

<c:forEach var="page" items="${pages}">
<TR><TD width="5%">-</TD>
    <TD width="*">
      <html:link forward="portal" paramId="pageId" paramName="page" paramProperty="value.pageId">
        <c:out value="${page.value.displayName}"/>
      </html:link></TD></TR>
</c:forEach>

<!-- Management Pages -->
<%-- It'd be cool to have a deployment page here someday.
     It'd allow us to deploy additional portlets through a
     web form so that new users could simply upload the war
     and not have to worry about the underlying impl. . .
<TR><TD colspan="2">&nbsp;</TD></TR>
<TR><TH width="5%">+</TH>
    <TH width="*">Management</TH></TR>
<TR><TD width="5%">-</TD>
    <TD width="*">Add Portlets</TD></TR>
--%>

<!-- Help / About -->
<TR><TD colspan="2">&nbsp;</TD></TR>
<TR><TH width="5%">+</TH>
    <TH width="*">About Kuiper</TH></TR>
<TR><TD width="5%">-</TD>
    <TD width="*">About Kuiper</TD></TR>
<TR><TD width="5%">-</TD>
    <TD width="*">Help</TD></TR>
</TABLE>
