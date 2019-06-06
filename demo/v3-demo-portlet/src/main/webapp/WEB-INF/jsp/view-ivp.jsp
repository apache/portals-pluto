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

<div style='clear:both;'>
<div style='float:left;'><h3>Image Viewer</h3></div>
<div id=<portlet:namespace/>-counter style='float:right; font-size:250%; color:#0B0;'>1</div>
</div><div style='clear:both;'><hr/>
      
<FORM id='<portlet:namespace/>-setParams'  onsubmit='return false;' enctype='application/x-www-form-urlencoded'>
   <table><tr><td align='left'>
   Cacheability setting:
   </td><td>
   <input id='<portlet:namespace/>-page' type='radio' name='cacheability' value='PAGE'>Page
   <input id='<portlet:namespace/>-portlet' type='radio' name='cacheability' value='PORTLET'>Portlet
   <input id='<portlet:namespace/>-full' type='radio' name='cacheability' value='FULL'>Full
   </td></tr><tr><td>
   Set border (resource parameter)
   </td><td>
   <input id='<portlet:namespace/>-border' type='checkbox' name='border' value='border'>
   </td></tr></table>
</FORM><hr/>

<div id='<portlet:namespace/>-putResourceHere'></div>
      
<script>
(function () {
   'use strict';
   
   var pid = '<portlet:namespace/>',
       resdiv = '<portlet:namespace/>-putResourceHere',
       border = '<portlet:namespace/>-border',
       ca_page = '<portlet:namespace/>-page',
       ca_portlet = '<portlet:namespace/>-portlet',
       ca_full = '<portlet:namespace/>-full',

       cntrId = '<portlet:namespace/>-counter', 
       cntr = 1,
       
       resparms = {},
       cacheability,
       currState,
       hub,
   
   // Update function called by the Portlet Hub when an onStatechange event occurs. 
   update = function (type, state) {
      var bo = state.getValue('bo'),
          ca = state.getValue('ca', hub.constants.PAGE);
      
      currState = state;
      
      console.log("IVP: state updated. event type=" + type);
      
      // set cacheability & border color according to parameters. Set controls
      // according to parameers to enable back button support.
      
      resparms = hub.newParameters();
      if (bo) {
         resparms['border'] = [bo];
         document.getElementById(border).checked = true;
      } else {
         document.getElementById(border).checked = false;
      }
      
      cacheability = ca;
      switch (ca) {
      case hub.constants.PAGE:
         document.getElementById(ca_page).checked = true;
         break;
      case hub.constants.PORTLET:
         document.getElementById(ca_portlet).checked = true;
         break;
      case hub.constants.FULL:
         document.getElementById(ca_full).checked = true;
         break;
      }
      
      
      hub.createResourceUrl(resparms, cacheability).then(function (url) {
         var brdr = (resparms.border === undefined) ? undefined : resparms.border[0],
             xhr = new XMLHttpRequest();
         console.log("IVP: got url: " + url + ", res parm border=" + brdr);
         xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {
               document.getElementById(resdiv).innerHTML=xhr.responseText;
            }
         };
         xhr.open("GET",url,true);
         xhr.send();
      });
   },
   
   // Handler for cacheability radio buttons
   handleCA = function () {
      var c = hub.constants[this.value], nstate;
      console.log("IVP: cacheability button clicked: " + this.value + ", corresponding to constant value " + c);
      if (cacheability !== c) {
         cacheability = c;
         nstate = currState.clone();
         nstate.setValue('ca', c);
         hub.setRenderState(nstate);
      }
   };
   
   document.getElementById(ca_page).checked = true;
   document.getElementById(ca_page).onclick = handleCA;
   document.getElementById(ca_portlet).onclick = handleCA;
   document.getElementById(ca_full).onclick = handleCA;
   
   // Handler for 'border' checkbox 
   document.getElementById(border).checked = false;
   document.getElementById(border).onclick = function () {
      var nstate = currState.clone();
      console.log("IVP: border checked: " + this.checked);
      if (this.checked) {
         nstate.setValue('bo', '#00F');;
      } else {
         nstate.remove('bo');
      }
      hub.setRenderState(nstate);
   };
   
   // Register this portlet with the Portlet Hub and add event listener for 
   // the onStateChange event
   portlet.register(pid).then(function (pi) {
      console.log("IVP: registered: " + pid);
      hub = pi;
      cacheability = hub.constants.PAGE;
      hub.addEventListener("portlet.onStateChange", update);
   });
   
   // Simple counter for demonstrating that page hasn't been refreshed.
   window.setInterval(function () {
      document.getElementById(cntrId).innerHTML = ++cntr;
   }, 1000);
   
}());
</script>

<p><hr/></p></div>

