<%--
Copyright 2004,2005 The Apache Software Foundation
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
<%@ page language="java" %>
<%@ page import="javax.portlet.RenderRequest" %>
<%@ page import="javax.portlet.PortletPreferences" %>
<%@ page import="javax.portlet.RenderResponse" %>
<%@ page import="javax.portlet.PortletURL" %>
<%@ page session="false" %>
<%@ taglib uri='http://java.sun.com/portlet' prefix='portlet'%>
<%@ taglib uri="http://portals.apache.org/pluto/admin" prefix="pluto-admin" %>

<portlet:defineObjects/>

<p class="portlet-section-header">Deploy War</p>
<!--  'Post' method is required for portlet action -->
<form action="<portlet:actionURL/>"
	enctype="multipart/form-data" method="post">
<table>
<tr>
<td class="portlet-section-body">
<span class="portlet-section-subheader">Please select a war file to deploy:</span>
</td>
</tr>
<tr>
<td class="portlet-section-body">
	Upload File: <input type="file" name="fileupload">
</td>
</tr>
<tr>
<td class="portlet-section-body">
	<input class="portlet-form-button" type="submit" value="Submit">
</td>
</tr>
</table>
</form>
<pluto-admin:portlet-message/>
