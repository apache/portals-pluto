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
<%@ page import="static org.apache.portals.pluto.demo.hub.Constants.*" %>

<portlet:defineObjects />

<h3>Parameter Tester</h3><hr/>
<p>Enter parameter name and value and click 'send'.
To enter multiple values, separate values with a ',' character.
Entering 'null' as a value will cause the corresponding value in the values array to be set to null.
Entering 'null' by itself will cause the parameter to be set to null (removed).
Entering 'empty' by itself will set the parameter to an empty array.
Leaving the value field empty will set the parameter to an array containing a single empty string.
<p/>
<p><hr/></p>
<FORM id='<portlet:namespace/>-setParams' METHOD='POST' onsubmit='return false;' enctype='application/x-www-form-urlencoded' accept-charset='UTF-8'>
   <table><tr><td align='left'>
      Parameter Name:
   </td><td colspan=2>
   <input name='<portlet:namespace/>-pName' type='text' value='' size='50' maxlength='100'>
   </td></tr><tr><td>
      Parameter Values:
   </td><td colspan=2>
   <input name='<portlet:namespace/>-pVal' type='text' value='' size='50' maxlength='100'>
   </td></tr><tr><td>
   <INPUT VALUE='send' CLASS='portlet-form-button' TYPE='submit'>
   </td></tr></table>
</FORM>

<p><hr/></p>
<div id='<portlet:namespace/>-putResourceHere'></div>


<script>
(function () {
   'use strict';
    
   var pid = '<portlet:namespace/>',
       pnid = '<portlet:namespace/>-pName',
       pvid = '<portlet:namespace/>-pVal',
       msgdiv = '<portlet:namespace/>-putResourceHere',
       formid = '<portlet:namespace/>-setParams',
       currState,
       hub,

       
   // Handler for onStateChange event
   update = function (type, state) {
      currState = state;
      
      hub.createResourceUrl().then(function (url) {
         var xhr = new XMLHttpRequest();
         console.log("PTP: got url: " + url);
         xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {
               document.getElementById(msgdiv).innerHTML=xhr.responseText;
            }
         };
         xhr.open("GET",url,true);
         xhr.send();
      });
   };
   

   // Register portlet with Portlet Hub. Add listener for onStateChange event.
   portlet.register(pid).then(function (pi) {
      console.log("PTP Parameter Test Portlet: registered: " + pid);
      hub = pi;
      currState = hub.newState();
      hub.addEventListener("portlet.onStateChange", update);
   });
   

   // Handler for 'send' button click. Update parameters
   document.getElementById(formid).addEventListener('submit', function (event) {
      var pName = this[pnid].value,
          pValue = this[pvid].value, 
          nstate, vals, ii;
      
      console.log("PTP: updating parameters. PN=" + pName + ", PV=" + pValue);
      
      nstate = currState.clone();
      if (pValue === 'null') {
         nstate.remove(pName);
      } else {
         if (pValue === 'empty') {
            nstate.parameters[pName] = [];
         } else {
            vals = pValue.split(",");
            for (ii = 0; ii < vals.length; ii++) {
               if (vals[ii] === 'null') {
                  vals[ii] = null;
               }
            }
            nstate.setValues(pName, vals);
         }
      }
      
      hub.setRenderState(nstate);
      
      event.preventDefault();
   });
      
}());
</script>
