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
<%@ page import="static org.apache.portals.pluto.demo.v3.TagLibPortlet.*" %>
<%@ page import="static org.apache.portals.pluto.demo.v3.ParamUtil.*" %>

<portlet:defineObjects />

<h3>Tag Library Portlet</h3>
<p>
This portlet exercises new v3 JSP tag library features.</p>
<div class='parmbox'>
<FORM  ACTION='<portlet:actionURL/>' id='<portlet:namespace/>-setParams' method='POST' enctype='application/x-www-form-urlencoded'>
   <table style='width:100%;'><tr><td align='left'>

   Phase:
   </td><td>
   <input type='radio' name='<%=PHASE%>' value='<%=PHASE_REN%>' ${phase == "render" ? "checked" : "" } > <%=PHASE_REN%>
   </td><td>
   <input type='radio' name='<%=PHASE%>' value='<%=PHASE_HDR%>' ${phase == "header" ? "checked" : "" } > <%=PHASE_HDR%>
   </td><td>
   <input type='radio' name='<%=PHASE%>' value='<%=PHASE_RES%>' ${phase == "resource" ? "checked" : "" } > <%=PHASE_RES%>
   </td><td>
   <input type='radio' name='<%=PHASE%>' value='<%=PHASE_ACT%>' ${phase == "action" ? "checked" : "" } > <%=PHASE_ACT%>
   </td><td>
   <input type='radio' name='<%=PHASE%>' value='<%=PHASE_EVT%>' ${phase == "event" ? "checked" : "" } > <%=PHASE_EVT%>
   
   </tr><tr><td align='left'>
   Test type:
   </td><td colspan="2">
   <input type='radio' name='<%=TEST%>' value='<%=TEST_OBJ%>' ${test == "obj" ? "checked" : "" } > Test page objects
   </td><td colspan="2">
   <input type='radio' name='<%=TEST%>' value='<%=TEST_BEAN%>' ${test == "bean" ? "checked" : "" } > Test named beans
   
   </td></tr></table>
</FORM>
<button form='<portlet:namespace/>-setParams' VALUE='submit' TYPE='submit'>Execute</button><br><br>
</div>

