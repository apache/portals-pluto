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
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Map.Entry" %>
<%@ page import="java.util.Set" %>
<%@ page import="javax.portlet.PortletPreferences" %>
<%@ page import="javax.portlet.RenderResponse" %>
<%@ page import="javax.portlet.PortletURL" %>
<%@ page import="javax.portlet.PortletMode" %>
<%@ page import="org.apache.pluto.portlet.admin.bean.PageTO" %>
<%@ page import="org.apache.pluto.portlet.admin.PlutoAdminConstants" %>
<%@ taglib uri='http://java.sun.com/portlet' prefix='portlet'%>
<%@ taglib uri="/WEB-INF/pluto-admin.tld" prefix="pluto-admin" %>


<portlet:defineObjects/>
	<%
		PageTO ppage = (PageTO)renderRequest.getPortletSession().getAttribute(PlutoAdminConstants.PAGE_ATTR);
		Map pmap = (Map)renderRequest.getPortletSession().getAttribute(PlutoAdminConstants.PORTLET_MAP_ATTR);
		int rows = 0;
		int cols = 0;
		if (ppage != null) {
			rows = ppage.getRows();
			cols = ppage.getCols();
		}
	%>
<p class="portlet-section-header">Define page layout for <%= ppage.getTitle() %> portlet application</p>

<!--  'Post' method is required for portlet action -->
<form action="<portlet:actionURL/>" method="post">
	<input type="hidden" name="action" value="savepagelayout"/>
	
<table border="2">
<!-- column titles in top row -->
<tr>
<%
		for (int j = 0; j <= cols ; j++) {
%>
<% if (j == 0) { %>
	<th>
	</th>
<%  } else { %>
	<td>
	<b>Column <%= j %></b>
	</td>
<%  } %>
<%  }//end of loop %>
</tr>
<!-- end of top row -->

<%
		//rows and cols are indexed starting at 1
    for (int i = 0; i < rows ; i++) {		
%>
<tr>
<%
		for (int j = 0; j < cols ; j++) {
%>

<!-- First column is always row title -->
<% if (j == 0) { %>
	<td>
	<b>Row <%= Integer.toString(i + 1) %></b>
	</td>
<%  } %>	
<td class="portlet-section-body">Portlet:
<pluto-admin:portletselect row="<%= i + 1 %>" column="<%= j + 1 %>" portletMap="<%= pmap %>" />
</td>

<% 	} //end of cols loop %>
</tr> <%-- end of col --%>
<% } //end of rows loop %>
</table>
<br/>
<input type="submit" value="Submit">
</form>
<pluto-admin:portlet-message/>
<p class="portlet-font">
<a href='<portlet:actionURL><portlet:param name="action" value="showhome"/></portlet:actionURL>'>Deploy War home</a> 
</p>
