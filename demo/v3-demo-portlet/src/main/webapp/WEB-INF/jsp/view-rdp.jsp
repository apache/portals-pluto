<%--
Licensed to the Apache Software Foundation (ASF) under one or more
contributor license agreements.  See the NOTICE file distributed with
this work for additional information regarding copyright ownership.
The ASF licenses this file to You under the Apache License, Version 2.0
(the "License"); you may not use this file except in compliance with
the License.  You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed  under the  License is distributed on an "AS IS" BASIS,
WITHOUT  WARRANTIES OR CONDITIONS  OF ANY KIND, either  express  or
implied.

See the License for the specific language governing permissions and
limitations under the License.
--%>
<%@ page session="false" %>
<%@ taglib uri="http://xmlns.jcp.org/portlet_3_0"  prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="static org.apache.portals.pluto.demo.v3.Constants.*" %>

<portlet:defineObjects />

<% 
   String clr = renderRequest.getRenderParameters().getValue(PARAM_COLOR);
   if (clr == null) {
      clr = "#FFF";
   }
%>

<div style='background-color:<%=clr %>; padding:8px;'>
<h3>V3 Redirect Portlet</h3><hr/>
<p>
Portlet to demo the V3 action response redirect functionality. You can enter a redirect that the
processAction method will redirect to along with a color value. If a redirect URL is entered, the portlet
will redirect to that URL.
</p><p> 
If no URL is entered, the portlet will obtain a redirect URL, which is 
basically a render URL to itself, and redirect to that URL to refresh the page. If a color 
value is entered, it will be set as a render parameter on the redirect URL.
The color will be set as background color for the portlet, so you can see the effect of the
redirect.
</p>
<!-- Note that the action URL is provided to the JSP by the render method as a workaround, 
     since the tag lib is still at JSR 286 level. -->
<form method='POST'  enctype='application/x-www-form-urlencoded' action="<%=renderRequest.getAttribute(ATTRIB_ACTURL) %>">
  <table><tr>
     <td align='left'>Enter background color :</td>
     <td>
        <input id='<portlet:namespace/>-color' name='<%=PARAM_COLOR%>' type='text' value='' size='10' maxlength='10'>
     </td>
     <td>
     <div id='<portlet:namespace/>-putMsgHere'></div>
   </td></tr><tr><td>
   Enter URL:
   </td><td colspan=3>
   <input id='<portlet:namespace/>-msg' name='<%=PARAM_URL_INPUT%>' type='text' value=''>
   </td></tr><tr><td>
   <INPUT id ='<portlet:namespace/>-send' VALUE='redirect' TYPE='submit'>
   </td></tr></table>
</FORM>
</div>
