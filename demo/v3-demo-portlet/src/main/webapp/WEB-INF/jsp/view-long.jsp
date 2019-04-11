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


<h3>Long portlet for testing the fragment identifier</h3>
<p>V3 portlet that allows setting the fragment identifier.</p>
<p>Use the form below to enter the fragment identifier text and line number.</p>
<%
   ActionURL aurl = renderResponse.createActionURL();
%>
<FORM METHOD='POST' ACTION='<%=aurl.toString() %>' enctype='application/x-www-form-urlencoded' accept-charset='UTF-8'>
   <table><tr><td align='left'>
      Fragment ID:
   </td><td>
   <input name='<%=PARAM_FRAG%>' type='text' value='' size='30' maxlength='100'>
   </td><td>
      Line:
   </td><td>
   <input name='<%=PARAM_LINE%>' type='text' value='' size='10' maxlength='10'>
   </td></tr><tr><td>
   <INPUT ID='<portlet:namespace />-send' VALUE='send' TYPE='submit'>
   </td></tr></table>
</FORM>
<%
   ArrayList<String> lines = (ArrayList<String>)renderRequest.getAttribute(ATTRIB_LONGLINES);
   String frag = renderRequest.getRenderParameters().getValue(PARAM_FRAG);
   String ln = renderRequest.getRenderParameters().getValue(PARAM_LINE);
   int lineNum = -1;
   if (frag != null && ln != null && frag.length() > 0 && ln.matches("\\d+")) {
      lineNum = Integer.parseInt(ln);
      if (lineNum > lines.size()) {
         lineNum = lines.size();
      }
      RenderURL rurl = renderResponse.createRenderURL(ALL);
      rurl.setFragmentIdentifier(frag);
      out.print("<p><a href='");
      out.print(rurl.toString());
      out.println("'>Jump to line " + lineNum + "</a></p>");
   }
   String colStyle = "align='left' style='min-width: 25px; padding:0 10px 0 10px;'";
   String markStyle = "align='left' style='color:#00D; min-width: 25px; padding:0 10px 0 10px;'";
%>
<p><hr/></p>
<table><tr>
<%
   int i = 0;
   for (String line : lines) {
      String s1 = colStyle;
      String s2 = colStyle;
      if (++i == lineNum) {
         s1 = "id='" + frag + "' " + markStyle;
         s2 = markStyle;
      }
      StringBuilder txt = new StringBuilder();
      txt.append("<td ").append(s1).append(">").append(i).append("</td>");
      txt.append("<td ").append(s2).append(">").append(line).append("</td>");
      txt.append("</tr><tr>");
      out.println(txt.toString());
   }
%>
</tr></table>
<p><hr/></p>
