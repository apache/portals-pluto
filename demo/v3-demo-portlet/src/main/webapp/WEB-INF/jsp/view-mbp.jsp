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

<portlet:defineObjects />

<%
   StringBuffer style = new StringBuffer(256);
   style.append("border-style:solid; border-width:3px;");
   style.append(" padding:4px; overflow:auto;");
   style.append(" border-color:#000088; min-height:70px;");
   style.append(" background:#E0E0E0;");
%>

<div style='clear:both;'>
<div style='float:left;'><h3>Message Box Portlet</h3></div>
<div style='float:right;'>
<form   onsubmit='return false;' enctype='application/x-www-form-urlencoded'><input id='<portlet:namespace/>-clear' type='submit' name='action' value='clear' /></form>
</div>
</div><div style='clear:both;'><hr/>
<p>Messages that arrive via events from other portlets are displayed in this box.</p>
<div id='<portlet:namespace/>-responseDiv' style="<%=style.toString()%>"></div>
</div>
   
<script>
(function () {
   'use strict';
   var pid = '<portlet:namespace/>',
       resdiv = '<portlet:namespace/>-responseDiv',
       clrButton = '<portlet:namespace/>-clear',
   
       state,
       resparms,
       cacheability,
       hub,
   
   // Handler for onStateChange event
   update = function (type, s) {
      console.log("MBP: state updated. Event type = " + type);
      state = s;
      
      hub.createResourceUrl(resparms, cacheability).then(function (url) {
         var xhr = new XMLHttpRequest();
         console.log("MBP: got url: " + url);
         xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {
               document.getElementById(resdiv).innerHTML=xhr.responseText;
            }
         };
         xhr.open("GET",url,true);
         xhr.send();
      });
   };
   
   // Handler for "clear" button. execute an action which clears the stored messages
   document.getElementById(clrButton).onclick = function () {
      console.log("MBP: clear button clicked. ");
      hub.action();
   };
   
   // Register portlet with Portlet Hub; add onStateChange listener 
   portlet.register(pid).then(function (pi) {
      console.log("MBP: Message Box portlet registered: " + pid);
      hub = pi;
      resparms = hub.newParameters();
      cacheability = hub.constants.PAGE;
      hub.addEventListener("portlet.onStateChange", update);
   });
   
}());
</script>
