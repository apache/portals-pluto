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
   style.append(" border-color:#008800; min-height:30px;");
   style.append(" background:#E0E0E0;");
%>

<h3>Partial Action Portlet</h3>
<hr/>
<p>This portlet exercises the Partial Action execution path.</p>
<form onsubmit='return false;' enctype='application/x-www-form-urlencoded'><input id='<portlet:namespace/>-doPA' type='submit' name='action' value='Do Partial Action' /></form>
<div id='<portlet:namespace/>-responseDiv' style="<%=style.toString()%>"></div>
   
<script>
(function () {
   'use strict';
   var pid = '<portlet:namespace/>',
       resdiv = '<portlet:namespace/>-responseDiv',
       paButton = '<portlet:namespace/>-doPA',
   
       state,
       hub,
   
   // Handler for onStateChange event
   update = function (type, s, renderData) {
      var nc = s.getValue('color', '#E0E0E0');
      console.log("PAP: state updated. Event type = " + type);
      
      // change background color for message box
      if (state.getValue('color') !== nc) {
         document.getElementById(resdiv).style.background = nc;
      }
      state = s;
      if ((renderData !== undefined) && (renderData !== null)) {
         document.getElementById(resdiv).innerHTML = renderData.content;
      }
   };
   
   // Handler for "partial action" button. Perform partial action sequence.
   document.getElementById(paButton).onclick = function () {
      var xhr = new XMLHttpRequest(), vals, pagestate = null, markup, actparms, actvals; 
      console.log("PAP: Partial action button clicked.");
      
      // Add the render parameter counter as action parameter
      actparms = hub.newParameters();
      actvals = state.getValues('numActions');       
      if (actvals) {
         actparms['numActions'] = actvals;
      }
      
      hub.startPartialAction(actparms).then(function (pai) {
         
         console.log("PAP: got partial action init object. URL: " + pai.url);
         
         xhr.onreadystatechange = function () {
            if (xhr.readyState === 4) {
               if (xhr.status !== 200) {
                  console.log("XHR error: " + xhr.status);
               }
               // Make sure setPageState is called even in error case in order to unblock the P.H.
               pai.setPageState(xhr.responseText);
            }
         };
         xhr.open("POST",pai.url,true);
         xhr.send();
         
      });
   };
   
   // Register portlet with Portlet Hub; add onStateChange listener 
   portlet.register(pid).then(function (pi) {
      console.log("PAP: registered: " + pid);
      hub = pi;
      state = hub.newState();
      hub.addEventListener("portlet.onStateChange", update);
   });
   
}());
</script>
