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
<%@page import="org.apache.pluto.driver.services.portal.admin.PlutoAdminPortlet"%>
<%@page import="java.util.ResourceBundle"%>

<portlet:defineObjects/>

<fmt:bundle basename="FileUploadPortlet">
	<fmt:message key="fileupload.edit.title" var="title"/>
	<fmt:message key="fileupload.edit.subtitle" var="subtitle"/>
</fmt:bundle> 

<h2><c:out value="${title}"/></h2>
<h4><c:out value="${subtitle}"/></h4>

<c:set value="${portlet_msg.cssClass}" var="css"/>
<div class="<c:out value='${css}'/>">
	<c:out value="${portlet_msg}"/>	
</div>

<portlet:actionURL var="configaction">
	<portlet:param name="command" value="config"/>
</portlet:actionURL>
<form action="<c:out value='${configaction}'/>" enctype="application/x-www-form-urlencoded" method="post">
	<div><label>Max File Size:</label> <input type="text" name="<%= FileUploadPortlet.MAX_FILE_UPLOAD_SIZE_PARAM %>" value="<c:out value='${maxfileuploadsize}'/>" /></div>
	<div><label>Upload directory:</label><input type="text" name="<%= FileUploadPortlet.UPLOAD_PATH_PARAM %>" value="<c:out value='${uploadpath}'/>" /></div>
	<div><label></label><input type="submit" value="Submit"/></div>
</form>
