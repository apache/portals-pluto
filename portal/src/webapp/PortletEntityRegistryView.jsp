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
<%@ page import="javax.portlet.PortletSession" %>
<%@ page import="java.util.Collection" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="org.apache.pluto.portalImpl.om.entity.impl.PortletApplicationEntityImpl" %>
<%@ page import="org.apache.pluto.portalImpl.om.entity.impl.PortletEntityImpl" %>
<%@ page import="org.apache.pluto.portlet.admin.PlutoAdminConstants" %>
<%@ taglib uri='http://java.sun.com/portlet' prefix='portlet'%>
<%@ taglib uri='http://portals.apache.org/pluto/admin' prefix='pluto-admin'%>

<portlet:defineObjects/>
<%! Iterator list = null; %>
<%
	list = (Iterator)renderRequest.getAttribute(PlutoAdminConstants.PER_LIST_ATTR); 
%>
<p class="portlet-section-header">Portlet Entity Registry</p>
<table border="2">
<tr>
<th>
App ID
</th>
<th>
App Name.Portlet Name (Definition ID)
</th>
<th>

</th>
</tr>
<!-- Portlet start -->
<% while (list.hasNext()) {
	PortletApplicationEntityImpl app = (PortletApplicationEntityImpl)list.next();
%>
<tr>
<td class="portlet-section-body">
<%= app.getCastorId() %>
</td>
<td class="portlet-section-body">
<%
	Collection plets = app.getCastorPortlets();
	Iterator iter2 = plets.iterator();
	while (iter2.hasNext()) {
		PortletEntityImpl plet = (PortletEntityImpl)iter2.next();
%>
		<%-- Display definition ID --%>
		<%= plet.getDefinitionId() %><br/>	
<%
	}	
%>
	
</td>
<!-- TEMP REMOVE EDIT
<td class="portlet-section-body">
<a href="<portlet:actionURL>
<portlet:param name="page" value="showportlet"/>
<portlet:param name="appid" value="<%= app.getCastorId() %>"/>
</portlet:actionURL>" >Edit</a>
</td>
 -->

</tr>
<% 
	}//end of while
%>
<!-- Portlet end -->

<!-- TEMP REMOVE ADD
<tr>
<td colspan="3" class="portlet-section-body">
<form action="<portlet:actionURL/>">
	<input type="hidden" name="page" value="addportlet"/>
	<input class="portlet-form-button" type="submit" name="submit" value="Add Portlet">
</form>
</td>
</tr>
-->

</table>