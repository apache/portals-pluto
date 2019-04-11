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
<%@ page import="java.util.*" %>
<%@ page import="static org.apache.portals.pluto.demo.v3.TagLibPortlet.*" %>

<portlet:defineObjects />

<h4>Resource method:</h4>
<h5>Render Parameters:</h5>

<table style='width:100%;'>
<colgroup>
   <col style="width:50%">
   <col style="width:50%">
</colgroup>   

<c:forEach items="${renderParams.getNames()}" var="key">
<tr>
<td>${key}</td>
<td>${Arrays.toString(renderParams.getValues(key))}</td>
</tr>
</c:forEach>
</table>


<h5>Resource Parameters:</h5>

<table style='width:100%;'>
<colgroup>
   <col style="width:50%">
   <col style="width:50%">
</colgroup>   

<c:forEach items="${resourceParams.getNames()}" var="key">
<tr>
<td>${key}</td>
<td>${Arrays.toString(resourceParams.getValues(key))}</td>
</tr>
</c:forEach>
</table>
