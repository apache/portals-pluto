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
<%@ page import="static org.apache.portals.pluto.demo.v3.DependencyPortlet.*" %>

<portlet:defineObjects />

<h3>Dependency Portlet</h3>
<div class='parmbox'>
<FORM  ACTION='<portlet:actionURL/>' id='<portlet:namespace/>-setParams' method='POST' enctype='application/x-www-form-urlencoded'>
   <table style='width:100%;'><tr><td align='left'>

   jQuery version:
   </td><td>
   <input type='radio' name='<%=PARAM_VER%>' value='<%=PARAM_VER_1%>' ${version == "1.12.3" ? "checked" : "" } > default
   </td><td>
   <input type='radio' name='<%=PARAM_VER%>' value='<%=PARAM_VER_2%>' ${version == "2.2.3" ? "checked" : "" } > <%=PARAM_VER_2%>
   </td><td>
   <input type='radio' name='<%=PARAM_VER%>' value='<%=PARAM_VER_3%>' ${version == "2.1.1" ? "checked" : "" } > <%=PARAM_VER_3%>

   </td></tr><tr><td colspan="2">
   </td></tr></table>
</FORM>
<button form='<portlet:namespace/>-setParams' VALUE='submit' TYPE='submit'>render with selected version</button><br><br>
<button id='<portlet:namespace/>button'>Click to see jQuery magic</button><br>
</div>
<div class = 'bluebox'>
<h3>Tests for Bad Dependency Strings:</h3>
   <c:forEach items="${xmap}" var="entry">
      <p>
      String: ${entry.key }<br>
      Exception: ${entry.value }
      </p>   
   </c:forEach>
</div>
<div class='infobox fadebox' id='<portlet:namespace/>fadeBox'>
<p id='<portlet:namespace/>fadeText'></p>
</div>

<script>
$(document).ready(function(){
    $("#<portlet:namespace/>button").click(function(){
        var txt = "jQuery version: " + $().jquery;
        $("#<portlet:namespace/>fadeText").text(txt);
        $("#<portlet:namespace/>fadeBox").fadeIn(3000);
    });
});
</script>
