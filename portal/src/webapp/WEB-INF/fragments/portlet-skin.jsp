<%@ taglib uri="http://portals.apache.org/pluto" prefix="pluto" %>

<pluto:portlet portletId="${portlet}">
<TABLE class="portlet" border="1">
<TR class="banner"><TD><pluto:title/></TD>
    <TD><A href="<pluto:window windowState="minimized">">min</pluto:window></TD>
    <TD><A href="<pluto:window windowState="maximized">">max</pluto:window></TD>
    <TD><A href="<pluto:window windowState="normal">">nor</pluto:window></TD>
    <TD><A href="<pluto:window portletMode="help">">help</pluto:window></TD>
    <TD><A href="<pluto:window portletMode="edit">">edit</pluto:window></TD>
    <TD><A href="<pluto:window portletMode="view">">view</pluto:window></TD></TR>
<TR><TD colspan="7">
    <pluto:render/>
    </TD></TR>
</TABLE>
</pluto:portlet>

