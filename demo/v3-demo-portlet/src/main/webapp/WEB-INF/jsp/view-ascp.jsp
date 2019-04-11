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
<%@ page import="java.io.*,java.util.*,javax.portlet.*" %>
<%@ page import="javax.portlet.MimeResponse.Copy" %>
<%@ page import="static javax.portlet.MimeResponse.Copy.*" %>
<%@ page import="static org.apache.portals.pluto.demo.v3.Constants.*" %>

<portlet:defineObjects />


<h3>Status Code Test Portlet</h3>
<p>V3 portlet that displays a resource URL link that causes a status code to be set.</p>
<p>Use the form below to enter the HTTP status code.</p>
<%
   ActionURL aurl = renderResponse.createActionURL();
   String colStyle = "align='left' style='min-width: 25px; padding:0 10px 0 10px;'";
%>
<FORM METHOD='POST' ACTION='<%=aurl.toString() %>' enctype='application/x-www-form-urlencoded' accept-charset='UTF-8'>
   <table><tr><td <%=colStyle %>>
      Status code:
   </td><td <%=colStyle %>>
   <input name='<%=PARAM_STATUSCODE%>' type='text' value='' size='10' maxlength='10'>
   </td><td <%=colStyle %>>
   <INPUT ID='<portlet:namespace />-send' VALUE='send' TYPE='submit'>
   </td></tr></table>
</FORM>
<p><hr/></p>
<%
   String scStr = renderRequest.getRenderParameters().getValue(PARAM_STATUSCODE);
   int sc = -1;
   if (scStr != null && scStr.matches("\\d+")) {
      sc = Integer.parseInt(scStr);
      ResourceURL resurl = renderResponse.createResourceURL();
      out.print("<p><a href='");
      out.print(resurl.toString());
      out.println("'>Resource URL, status code = " + sc + "</a></p>");
   }
%>
<p><hr/></p>
