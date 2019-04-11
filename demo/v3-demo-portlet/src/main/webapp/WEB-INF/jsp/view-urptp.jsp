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

<%
   String setType = renderRequest.getRenderParameters().getValue(PARAM_SETTYPE);
   setType = (setType == null) ? PARAM_SETTYPE_VARRAY : setType;
   
   String remType = renderRequest.getRenderParameters().getValue(PARAM_REMTYPE);
   remType = (remType == null) ? PARAM_REMTYPE_SET : remType;

   String aurlCopy = renderRequest.getRenderParameters().getValue(PARAM_AURLCOPY);
   aurlCopy = (aurlCopy == null) ? PARAM_AURLCOPY_ALL : aurlCopy;
   Copy pco = NONE;
   String acText = "Copy no parameters";
   if (aurlCopy.equals(PARAM_AURLCOPY_ALL)) {
      pco = ALL;
      acText = "Copy render parameters";
   } else if (aurlCopy.equals(PARAM_AURLCOPY_PUBLIC)) {
      pco = PUBLIC;
      acText = "Copy public parameters";
   }
   ActionURL aurl = renderResponse.createActionURL(pco);
   
   StringBuffer prpStr = new StringBuffer("Public render parameter names: ");
   String sep = "";
   for (String n : Collections.list(portletConfig.getPublicRenderParameterNames())) {
      prpStr.append(sep).append(n);
      sep = ", ";
   }
%>

<h3>Render URL Parameter clone & set Tester</h3>
<p>V3 portlet to verify render parameter handling on render URLs through the set(), clone(), 
clear(), and add() methods.</p>
<p><hr/></p>
<p>Render URLs:</p>
   <table><tr>
   <%
      Map<String, String> rurls = (Map<String, String>)renderRequest.getAttribute(ATTRIB_RENURLS);
      int ctr = 0;
      for (String name : rurls.keySet()) {
         StringBuilder txt = new StringBuilder("<td align='left' style='padding: 0 5px 0 5px;'>");
         txt.append("<a href='").append(rurls.get(name)).append("'>").append(name).append("</a>");
         txt.append("</td>");
         out.println(txt.toString());
         if ((++ctr)%3 == 0) {
            out.println("</tr><tr>");
         }
      }        
   %>
   </tr></table>
<p><hr/></p>
<p>Use the form below to enter additional render parameters.</p>
<p>Enter parameter name and value and click 'send'.
To enter multiple values, separate values with a ',' character.
Entering 'null' as a value will cause the corresponding value in the values array to be set to null.
Entering 'empty' by itself will set the parameter to an empty array.
Leaving the value field empty will set the parameter to an array containing a single empty string.
<p/>
<p><%=prpStr.toString() %></p>
<FORM id='<portlet:namespace/>-setParams' METHOD='POST' ACTION='<%=aurl.toString() %>' enctype='application/x-www-form-urlencoded' accept-charset='UTF-8'>
   <table><tr><td align='left'>
   
   To set, use:
   </td><td>

   <input type='radio' name='<%=PARAM_SETTYPE%>' value='<%=PARAM_SETTYPE_VAL%>'
          <%=(setType.equals(PARAM_SETTYPE_VAL) ? "checked" : "")%> >Single value

   </td><td>
   <input type='radio' name='<%=PARAM_SETTYPE%>' value='<%=PARAM_SETTYPE_VARRAY%>'
          <%=(setType.equals(PARAM_SETTYPE_VARRAY) ? "checked" : "")%> >Value array

   </td></tr><tr><td>
   Remove:
   </td><td colspan=2>

   <input type='checkbox' name='<%=PARAM_REMTYPE%>' value='<%=PARAM_REMTYPE_REM%>'
          <%=(remType.equals(PARAM_REMTYPE_REM) ? "checked" : "")%> >remove parameter
   </td></tr><tr><td>

      Parameter Name:
   </td><td colspan=3>
   <input name='<%=PARAM_NAME%>' type='text' value='' size='50' maxlength='100'>
   </td></tr><tr><td>
      Parameter Values:
   </td><td colspan=3>
   <input name='<%=PARAM_VALUES%>' type='text' value='' size='50' maxlength='100'>
   </td></tr><tr><td>
   <INPUT VALUE='send' CLASS='portlet-form-button' TYPE='submit'>
   </td></tr></table>
</FORM>

<p><hr/></p>
<%=renderRequest.getAttribute(ATTRIB_PARAMS) %>
<p><hr/></p>
