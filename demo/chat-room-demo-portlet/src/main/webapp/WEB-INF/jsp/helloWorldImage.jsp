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

<div class='infobox' id='<portlet:namespace/>-image'></div>

<script>
(function () {
   'use strict';
   var pid = '<portlet:namespace/>',
       resdiv = '<portlet:namespace/>-image',
       oldname=null, hub,
   
   // Handler for onStateChange event
   update = function (type, state) {
      var newname = null;
      
      newname = state.getValue('name');
      
      if (newname && (newname !== oldname)) {
      
         // Use the portlet hub to create a resource URL corresponding the the
         // current page state. The arguments in this case specify no additional
         // resource parameters, does not specify the cacheability option (which
         // implies cacheability=PAGE), and sets the resource ID to 'getImage'.
         
         hub.createResourceUrl(null, null, 'getImage').then(function (url) {
            var xhr = new XMLHttpRequest();
            xhr.onreadystatechange = function () {
               if (xhr.readyState === 4 && xhr.status === 200) {
                  if (xhr.responseText.length >= 0) {
                     document.getElementById(resdiv).innerHTML = xhr.responseText;
                  }
               }
            };
            xhr.open("GET",url,true);
            xhr.send();
         });
      }

      oldname = newname;
   }; 
   
   // Register portlet with Portlet Hub; add onStateChange listener.
   // The portlet hub register() method takes the portlet ID (aka portlet namespace) as
   // a parameter and returns a promise, which it then fulfills with a PortletInit object
   // that provides access to portlet hub functions valid for the registered portelt ID
   // only (see documentation).
    
   portlet.register(pid).then(function (pi) {
      console.log("IMG:  registered: " + pid);
      hub = pi;
      
      // A portlet client must add an 'onStateChange' listener so that the portlet
      // hub can notify the portlet client of its initial state. The portlet hub will
      // also call the listener function whenever the portlet state changes.
      
      hub.addEventListener("portlet.onStateChange", update);
   });
   
}());
</script>


