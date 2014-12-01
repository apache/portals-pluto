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
<%@ taglib uri="http://java.sun.com/portlet_2_0"  prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<portlet:defineObjects />


<h3>Image Selector</h3><hr/>
<FORM id='<portlet:namespace/>-setParams' onsubmit='return false;'>
   <table><tr><td align='left'>
   Selection type (private param):
   </td><td>
   <input id='<portlet:namespace/>-radio' type='radio' name='selType' value='radio'>Radio Button
   <input id='<portlet:namespace/>-dropdown' type='radio' name='selType' value='dropdown'>Drop Down
   </td></tr><tr><td>
   Select Image (public param):
   </td><td>

   <div id='<portlet:namespace/>-putResourceHere'></div>

   </td></tr></table>
</FORM>
<p><hr/></p>

<script>
(function () {
   'use strict';
   
   var pid = '<portlet:namespace/>',
       fid = '<portlet:namespace/>-setParams',
       resdiv = '<portlet:namespace/>-putResourceHere',
       st_radio = '<portlet:namespace/>-radio',
       st_dropdown = '<portlet:namespace/>-dropdown',
       selBox = '<portlet:namespace/>-selBox',
   
       currState,
       portletInit,
   
   // Set image name PRP if radio button clicked - 
   handleImgRadio = function () {
      console.log("ISP: image selected (radio): " + this.value);
      
      if (currState.parameters.imgName !== this.value) {
         var newState = currState.clone();
         newState.parameters.imgName = [this.value];
         portletInit.setPortletState(newState);
      }
   },
   
   // Set image name PRP if image selected in selection box - 
   handleImgDropdown = function () {
      console.log("ISP: image selected (dropdown): " + this.value);
      
      if (currState.parameters.imgName !== this.value) {
         var newState = currState.clone();
         newState.parameters.imgName = [this.value];
         portletInit.setPortletState(newState);
      }
   },
   
   // Handler for onStateChange event
   update = function (type, state) {
      var oldST = ((currState === undefined) || (currState.parameters.selType === undefined)) ? undefined : currState.parameters.selType[0],
          newST = (state.parameters.selType === undefined) ? undefined : state.parameters.selType[0],
          newImg = (state.parameters.imgName === undefined) ? undefined : state.parameters.imgName[0];
          
      console.log("ISP: state updated. type=" + type + ", selType=" + newST + ", imgName=" + newImg);
      
      if ((currState === undefined) || (oldST !== newST)) {
         portletInit.createResourceUrl({}).then(function (url) {
            console.log("ISP: got url: " + url);
            var xhr = new XMLHttpRequest();
            xhr.onreadystatechange=function() {
               if (xhr.readyState === 4 && xhr.status === 200) {
                  document.getElementById(resdiv).innerHTML = xhr.responseText;

                  // default is radio buttons
                  var ii, f = document.getElementById(fid);
                  if ((newST === undefined) || (newST === 'radio')) {
                     for (ii=0; ii < f.imgName.length; ii++) {
                        console.log("ISP: adding selection handler for: " + f.imgName[ii].value);
                        f.imgName[ii].onclick = handleImgRadio;
                        if (f.imgName[ii].value === newImg) {
                           console.log("ISP: image clicked: " + newImg);
                           f.imgName[ii].clicked = true;
                        }
                     }
                  } else if (newST === 'dropdown') {
                     console.log("ISP: adding selection handler to dropdown list element: " + selBox);
                     document.getElementById(selBox).onchange = handleImgDropdown;
                     for (ii=0; ii < f.imgName.length; ii++) {
                        if (f.imgName[ii].value === newImg) {
                           console.log("ISP: image selected: " + newImg);
                           f.imgName[ii].selected = true;
                        }
                     }
                  }

               }
            };
            xhr.open("GET",url,true);
            xhr.send();
         });
      }

      if (newST === 'dropdown') {
         document.getElementById(st_dropdown).checked = true;
      } else {
         document.getElementById(st_radio).checked = true;
      }

      currState=state;
   },
   
   // set private parameter selType to store the selection display type
   handleST = function () {
      console.log("ISP: select display type clicked: " + this.value);
      if (currState.parameters.selType !==  this.value) {
         var newState = currState.clone();
         newState.parameters.selType = [this.value];
         portletInit.setPortletState(newState);
      }
   };
   
   document.getElementById(st_radio).onclick = handleST;
   document.getElementById(st_dropdown).onclick = handleST;
   
   
   // Register with Portlet Hub, add listener for onStateChange event
   portlet.register(pid).then(function (pi) {
      console.log("ISP Image Selection Portlet: registered: " + pid);
      portletInit = pi;
      portletInit.addEventListener("portlet.onStateChange", update);
   });
   
   
}());
</script>
