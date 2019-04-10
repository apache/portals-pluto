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
<%@ page isELIgnored ="false" %> 
<%@ taglib uri="http://xmlns.jcp.org/portlet_3_0"  prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html><head>
<meta charset="UTF-8">
<title>Multipart Portlet</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/infobox.css">
</head>
<body>

<portlet:defineObjects />

<h3>Multipart Portlet</h3>
<p>
This portlet is used to exercise multipart form support.
It allows a file to be selected and displays its contents.
</p>

<div class='parmbox'>
<FORM ACTION='<portlet:actionURL/>' method='POST' enctype='multipart/form-data'>
   <table style='width:100%;'><tr><td align='left'>

   Select color:
   </td><td>
   <input name='color' type='color' value='${color}'>
   </td><td>
   </td></tr><tr><td>
   
   Select file:
   </td><td>
   <input name='file' type='file'>

   </td></tr><tr><td>
   <INPUT VALUE='submit' TYPE='submit'>

   </td></tr></table>
</FORM>
</div>

<hr>
<div class='infobox' style='background-color: ${color};'>
<h5>Info:</h5>
<c:forEach items="${lines}" var='line'>
   ${line}<br>
</c:forEach>
</div>

<hr>
<div class='orangebox'>
<h5>File contents:</h5>

<c:forEach items="${flist}" var='line'>
   ${line}<br>
</c:forEach>

<c:if test="${img != null}">
<p>
   <img alt="temp image" height="${h}" width="${w}" src='<portlet:resourceURL/>'>
</p>
</c:if>
</div>
