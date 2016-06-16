<%-- 
  - Author(s): ahmed
  --%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0"  prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.io.*,java.util.*,java.util.logging.*" %>
<%@ page import="static java.util.logging.Logger.*" %>
<%@ page import="javax.portlet.*,javax.portlet.filter.*" %>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ page import="javax.portlet.tck.beans.*,javax.portlet.tck.constants.*" %>
<%@ page import="static javax.portlet.tck.constants.Constants.*" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.*" %>
<portlet:defineObjects/>
<!-- p style="display:none;"  -->
<p><portlet:resourceURL cacheability="FULL"/>/></p>
<p><portlet:resourceURL cacheability="PORTLET"/>/></p>
<p><portlet:resourceURL cacheability="PAGE"/>/></p>

<c:catch var ="exp">
   <p><portlet:resourceURL cacheability="BAD!"/></p>
</c:catch>
<c:if test = "${exp != null}">
   <p style='color:blue;'>Exception:<br>${exp}</p>
</c:if>

<p><portlet:actionURL secure="false"/></p>
<p><portlet:actionURL secure="true"/></p>

<c:catch var ="exp">
   <p><portlet:actionURL secure="invalid"/></p>
</c:catch>
<c:if test = "${exp != null}">
   <p style='color:blue;'>Exception:<br>${exp}</p>
</c:if>

<p><portlet:actionURL escapeXml="false"/></p>
<p><portlet:actionURL escapeXml="true"/></p>

<c:catch var ="exp">
   <p><portlet:actionURL escapeXml="invalid"/></p>
</c:catch>
<c:if test = "${exp != null}">
   <p style='color:blue;'>Exception:<br>${exp}</p>
</c:if>

<p><portlet:actionURL copyCurrentRenderParameters="false"/></p>
<p><portlet:actionURL copyCurrentRenderParameters="true"/></p>

<c:catch var ="exp">
   <p><portlet:actionURL copyCurrentRenderParameters="invalid"/></p>
</c:catch>
<c:if test = "${exp != null}">
   <p style='color:blue;'>Exception:<br>${exp}</p>
</c:if>



