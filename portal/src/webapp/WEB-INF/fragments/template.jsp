<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<HTML>
<HEAD>
<TITLE>Pluto Portal Driver</TITLE>
<link rel="stylesheet" href="<c:out value="${pageContext.request.contextPath}"/>/pluto_style.css" type="text/css"></link>
</HEAD>

<BODY>

<TABLE>
<TR><TD><IMG src="<c:out value="${pageContext.request.contextPath}"/>/images/pluto.png"/></TD>
    <TD style="align:right">Pluto Portal Driver</TD></TR>
<TR><TD class="banner-highlight" colspan="2"></TD></TR>
<TR><TD colspan="2"> &nbsp; </TD></TR>
</TABLE>

<TABLE>
<TR class="tab">
    <c:forEach var="page" items="${driverConfig.renderConfig.pages}">
    <c:choose>
    <c:when test="${page == currentPage}">
    <TD nowrap="true" class="tab-selected">
    </c:when>
    <c:otherwise>
    <TD nowrap="true">
    </c:otherwise>
    </c:choose>
        <A href="<c:out value="${pageContext.request.contextPath}"/>/portal/<c:out value="${page.name}"/>"><c:out value="${page.name}"/></A></TD>
    <TD style="background-color:white"> &nbsp; </TD>
    <c:set var="span" value="${span + 1}"/>
    </c:forEach>
    <TD style="background-color:white;width:100%;"> &nbsp; </TD></TR>
    <TR><TD colspan="<c:out value="${span * 2}"/>"> &nbsp; </TD></TR>
</TABLE>

<TR><TD>
    <%-- This could be dynamic.  At this point there's no need --%>
    <jsp:include page='<%=(String)pageContext.findAttribute("include")%>'/>
    </TD></TR>
</TABLE>
</BODY>
</HTML>
