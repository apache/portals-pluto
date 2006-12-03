<%--
Copyright 2004 The Apache Software Foundation
Licensed  under the  Apache License,  Version 2.0  (the "License");
you may not use  this file  except in  compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed  under the  License is distributed on an "AS IS" BASIS,
WITHOUT  WARRANTIES OR CONDITIONS  OF ANY KIND, either  express  or
implied.

See the License for the specific language governing permissions and
limitations under the License.
--%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri='http://java.sun.com/portlet' prefix='portlet'%>
<%@ taglib uri='http://portals.apache.org/pluto' prefix='pluto'%>
<%@page import="org.apache.pluto.driver.portlets.AdminDeploymentPortlet"%>

<portlet:defineObjects/>

<fmt:bundle basename="AdminDeploymentPortlet">
	<fmt:message key="admin-deploy.view.title" var="title"/>
	<fmt:message key="admin-deploy.view.subtitle" var="subtitle"/>
</fmt:bundle> 

<div class="portlet-section-header"><c:out value="${title}"/></div>
<div class="portlet-section-subheader"><c:out value="${subtitle}"/></div>

<portlet:actionURL var="uploadaction">
	<portlet:param name="command" value="uploadfile"/>
</portlet:actionURL>
<form action="<c:out value='${uploadaction}'/>" enctype="multipart/form-data" method="post">
	<div><input type="file" name="<%= AdminDeploymentPortlet.UPLOAD_PATH_PARAM %>"/></div>
	<div><input type="submit" value="Submit"/></div>
</form>

<pluto:message/>

