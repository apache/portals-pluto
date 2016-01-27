<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0"  prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<portlet:defineObjects />

<H3>${renderRequest.getAttribute("title")}</H3>
<P>This is just a basic portlet that displays its parameters.</P>

<!-- Display a button that causes some parameters to be set -->
<FORM METHOD="POST" ACTION="<portlet:actionURL/>">
	<INPUT NAME='action' VALUE='setParms' TYPE="hidden">
    <INPUT VALUE="Set Parameters" CLASS="portlet-form-button" TYPE="submit">
</FORM>
<FORM METHOD="POST" ACTION="<portlet:actionURL/>">
   <INPUT NAME='action' VALUE='invalidateSession' TYPE="hidden">
    <INPUT VALUE="Invalidate Session" CLASS="portlet-form-button" TYPE="submit">
</FORM>

<!-- Display the parameters for the portlet -->
<P>Parameters:</P>
<UL>
<c:forEach var="name" items="${renderRequest.getParameterNames()}">
   <c:forEach var="value" items="${renderRequest.getParameterValues(name)}">
      <LI>
         Name: ${name}, Val: ${value}
      </LI>
   </c:forEach>
</c:forEach>
</UL>

