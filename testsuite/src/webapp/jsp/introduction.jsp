<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet"%>

<portlet:defineObjects/>

<TABLE>
<TR><TD>
    <P>
    This portlet is a portlet specification compatibility test portlet.
    It provides several tests of verying complexities which will assist
    in evaluating compliance with the portlet specification. It was originally
    developed for testing Apache Pluto, however, it does not utilize any
    proprietary APIs and should work with all compliant portlet containers.
    </P>

    <P>Please select one of the following tests:
    <TABLE>
    <c:forEach var="test" items="${tests}">
    <TR><TD><%=pageContext.getAttribute("test").toString()%></TD>
        <portlet:actionURL secure="<%=renderRequest.isSecure()?"True":"False"%>" var="url">
    	<portlet:param name="testId" value='<%=pageContext.getAttribute("test").toString()%>'/>
        </portlet:actionURL>
        <TD><A href="<c:out value="${url}"/>">Test</A></TD>
    </c:forEach>
    </TABLE>

    </P>
    </TD></TR>
</TABLE>