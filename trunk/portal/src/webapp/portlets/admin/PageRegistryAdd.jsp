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
<%@ page import="java.util.Map" %>
<%@ page import="javax.portlet.RenderRequest" %>
<%@ page import="javax.portlet.PortletPreferences" %>
<%@ page import="javax.portlet.RenderResponse" %>
<%@ page import="javax.portlet.PortletURL" %>
<%@ page import="javax.portlet.PortletMode" %>
<%@ page import="org.apache.pluto.portlet.admin.bean.PageTO" %>
<%@ page import="org.apache.pluto.portlet.admin.bean.PortletTO" %>
<%@ page import="org.apache.pluto.portlet.admin.PlutoAdminConstants" %>
<%@ taglib uri='http://java.sun.com/portlet' prefix='portlet'%>
<%@ taglib uri="http://portals.apache.org/pluto/admin" prefix="pluto-admin" %>


<portlet:defineObjects/>
<%
	PageTO ppage = (PageTO)renderRequest.getPortletSession().getAttribute(PlutoAdminConstants.PAGE_ATTR);
	Map pmap = (Map)renderRequest.getPortletSession().getAttribute(PlutoAdminConstants.PORTLET_MAP_ATTR);
	int pcount = 1;
	if (pmap != null) {
		pcount = pmap.size();
		if (pcount == 0) {
			pcount = 1;
		}
	}
%>

<script language="JavaScript">
	function <portlet:namespace/>checkCount(field){
		if (<portlet:namespace/>validateRequired(field)) {
			var pcount = <%= pcount %>;
			var cols = document.pinfoform.numcols.value;
			var rows = document.pinfoform.numrows.value;
			if (cols * rows != pcount) {
				alert("Too many or too few rows and/or columns for the " + pcount + " portlets in this application.");
			}
		}
	}
	
	function <portlet:namespace/>validateRequired(field) {
		if (field.value == ""){
			alert("This field is required!");
			return false;
		} else {
			return true;
		}
	}
</script>
<p class="portlet-section-header">Enter layout information for <%= ppage.getName() %> portlet app</p>

<!--  'Post' method is required for portlet action -->
<form action="<portlet:actionURL/>" method="post" name="pinfoform">
	<input type="hidden" name="action" value="showpagelayout"/>
<table>
<tr>
<td>
<b>Title:</b>
</td>
<td>
<input type="text" name="title" size="20" value="<%= ppage.getTitle() %>">
</td>
</tr>
<tr>
<td>
<b>Description:</b>
</td>
<td>
<input type="text" name="description" size="30" value="<%= ppage.getDescription() %>">
</td>
</tr>
<tr>
<td colspan="2">
<p class="portlet-section-subheader">Layout for the <%= pcount %> portlet<%= pcount > 1 ? "s" : "" %>
 in this application:</p>
</td>
</tr>
<tr>
<td>
<b>Number of columns:</b>
</td>
<td>
<input type="text" name="numcols" size="4" value="<%= ppage == null ? "" : Integer.toString(ppage.getCols()) %>" onBlur="<portlet:namespace/>validateRequired(this);">
</td>
</tr>
<tr>
<td>
<b>Number of rows:</b>
</td>
<td>
<input type="text" name="numrows" size="4" value="<%= ppage == null ? "" : Integer.toString(ppage.getRows()) %>" onBlur="<portlet:namespace/>checkCount(this);">
</td>
</tr>
<tr>
<td>
<input type="submit" value="Submit">
</td>
</tr>
</table>
</form>
<pluto-admin:portlet-message/>
<p class="portlet-font">
<a href='<portlet:actionURL><portlet:param name="action" value="showhome"/></portlet:actionURL>'>Deploy War home</a> 
</p>
