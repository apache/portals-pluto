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

<h3>Tag Library URL Tags Portlet</h3>
<p>
This exercises the portlet tag library URL tags. Click on a link or button.</p>
<div class='parmbox'>
   <table style='width:100%;'>
   <colgroup>
      <col style="width:50%">
      <col style="width:50%">
   </colgroup>   
   <tr>
   
   <td>
   <a href='<portlet:renderURL></portlet:renderURL>'>No parameters</a>
   </td>
   
   <td>
   <a href='<portlet:renderURL copyCurrentRenderParameters="true"></portlet:renderURL>'>
      Copy parameters</a>
   </td>
   
   </tr><tr>
   
   <td>
   <a href='<portlet:renderURL>
      <portlet:param name="p1" value="v1"/></portlet:renderURL>'>
      Add parameter p1=v1</a>
   </td>
   
   <td>
   <a href='<portlet:renderURL copyCurrentRenderParameters="true">
      <portlet:param name="p2" value="v2"/></portlet:renderURL>'>
      Copy parameters &amp; add p2=v2</a>
   </td>
   
   </tr><tr>
   <td colspan="2">For control of resource method:</td>
   </tr><tr>
   
   <td>
   <a href='<portlet:renderURL>
      <portlet:param name="addrp" value="true"/></portlet:renderURL>'>
      add resource parameter pr3=vr3</a>
   </td>
   
   <td>
   <a href='<portlet:renderURL copyCurrentRenderParameters="true">
      <portlet:param name="addrp" value="true"/></portlet:renderURL>'>
      Copy &amp; add res param pr3=vr3</a>
   </td>
   
   </tr><tr>
   <td colspan="2">Action URLs, no copy:</td>
   </tr><tr>
   
   <td>
   <portlet:actionURL var="aurl">
   </portlet:actionURL>
   <form action="${aurl}" method="post" enctype="application/x-www-form-urlencoded">
   <button VALUE='submit' TYPE='submit'>Action, no parameters</button>
   </form>
   </td>
   
   <td>
   <portlet:actionURL var="aurl1">
      <portlet:param name="pa4" value="va4"/>
   </portlet:actionURL>
   <form action="${aurl1}" method="post" enctype="application/x-www-form-urlencoded">
   <button VALUE='submit' TYPE='submit'>action pa4=va4</button>
   </form>
   </td>
   
   </tr><tr>
   
   <td>
   <portlet:actionURL var="aurl2">
      <portlet:param name="pr5" value="vr5" type="render"/>
   </portlet:actionURL>
   <form action="${aurl2}" method="post" enctype="application/x-www-form-urlencoded">
   <button VALUE='submit' TYPE='submit'>render param pr5=vr5</button>
   </form>
   </td>
   
   <td>
   <portlet:actionURL var="aurl3">
      <portlet:param name="pr6" value="vr6" type="render"/>
      <portlet:param name="pa7" value="va7"/>
   </portlet:actionURL>
   <form action="${aurl3}" method="post" enctype="application/x-www-form-urlencoded">
   <button VALUE='submit' TYPE='submit'>action pa7=va7 &amp; render pr6=vr6</button>
   </form>
   </td>
   
   </tr><tr>
   <td colspan="2">Actions URLs, copy render parameters:</td>
   </tr><tr>
   
   <td>
   <portlet:actionURL var="aurl4" copyCurrentRenderParameters="true">
      <portlet:param name="pa4" value="va4"/>
   </portlet:actionURL>
   <form action="${aurl4}" method="post" enctype="application/x-www-form-urlencoded">
   <button VALUE='submit' TYPE='submit'>action pa4=va4</button>
   </form>
   </td>
   
   <td>
   <portlet:actionURL var="aurl5" copyCurrentRenderParameters="true">
      <portlet:param name="pr6" value="vr6" type="render"/>
      <portlet:param name="pa7" value="va7"/>
   </portlet:actionURL>
   <form action="${aurl5}" method="post" enctype="application/x-www-form-urlencoded">
   <button VALUE='submit' TYPE='submit'>action pa7=va7 &amp; render pr6=vr6</button>
   </form>
   </td>
   
   </tr>
   </table>
</div>

<!-- Show the render parameters during render request -->

<div class='bluebox'>
   <h4>Render Method:</h4>
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
</div>

<c:set var="actparms" value="${portletSession.getAttribute('actparms')}"/>
<% portletSession.removeAttribute("actparms"); %>

<c:if test="${not empty actparms}">
<div class='redbox'>
   <h4>From Action Method:</h4>
   <h5>Action Parameters, #: ${actparms.size()}</h5>

   <table style='width:100%;'>
   <colgroup>
      <col style="width:50%">
      <col style="width:50%">
   </colgroup>   

   <c:forEach items="${actparms.getNames()}" var="key">
   <tr>
   <td>${key}</td>
   <td>${Arrays.toString(actparms.getValues(key))}</td>
   </tr>
   </c:forEach>
   </table>

</div>
</c:if>

<div class='infobox' id='<portlet:namespace/>-putResourceHere'></div>

<portlet:resourceURL var="url">
   <c:set var="addrp" value="${renderParams.getValue('addrp')}"/>
   <c:if test="${not empty addrp}">
      <portlet:param name="pr3" value="vr3"/>
   </c:if>
</portlet:resourceURL>

<script>
(function () {
   var xhr = new XMLHttpRequest();
   xhr.onreadystatechange=function() {
      if (xhr.readyState==4 && xhr.status==200) {
         document.getElementById('<portlet:namespace/>-putResourceHere').innerHTML=xhr.responseText;
      }
   };
   xhr.open('GET', '${url}', true);
   xhr.send();
})();
</script>


