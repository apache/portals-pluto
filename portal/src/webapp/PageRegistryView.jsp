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
<%@ page session="false" %>
<%@ page language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="javax.portlet.RenderRequest" %>
<%@ page import="javax.portlet.PortletPreferences" %>
<%@ page import="javax.portlet.RenderResponse" %>
<%@ page import="javax.portlet.PortletURL" %>
<%@ page import="org.apache.pluto.portlet.admin.bean.PageTO" %>
<%@ page import="org.apache.pluto.portlet.admin.PlutoAdminConstants" %>
<%@ taglib uri='http://java.sun.com/portlet' prefix='portlet'%>
<%@ taglib uri="/WEB-INF/pluto-admin.tld" prefix="pluto-admin" %>

<portlet:defineObjects/>

<portlet:defineObjects/>
<p class="portlet-section-header">Page Registry</p>
<pluto-admin:portlet-message/>

<table border="2">
<tr>
<th>
Page
</th>
<th>
No of rows
</th>
<th>
No of columns
</th>
<th>

</th>
</tr>
<%
	Iterator iter = (Iterator)renderRequest.getAttribute(PlutoAdminConstants.PAGE_LIST_ATTR);
	while(iter.hasNext()) {	
		PageTO ppage = (PageTO)iter.next();
%>
<!-- Page fragment start -->
<tr>
<td class="portlet-section-body">
	<%= ppage.getTitle() %>
</td>
<td class="portlet-section-body">
	<%= ppage.getRows() %>
</td>
<td class="portlet-section-body">
	<%= ppage.getCols() %>
</td>
<!-- TEMP REMOVE EDIT
<td class="portlet-section-body">
<a href="<portlet:actionURL><portlet:param name="action" value="showpage"/><portlet:param name="pageName" value="<%= ppage.getName() %>"/></portlet:actionURL>" >Edit</a>
</td>
-->
</tr>
<%
	}
%>
<!-- Page fragment end -->

<!-- TEMP REMOVE ADD
<tr>
<td colspan="4" class="portlet-section-body">
<form action="<portlet:actionURL/>">
	<input class="portlet-form-button" type="submit" name="submit" value="Add Page">
</form>
</td>
</tr>
-->

</table>