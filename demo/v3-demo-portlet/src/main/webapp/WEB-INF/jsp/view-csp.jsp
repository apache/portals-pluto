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
<%@ page import="static org.apache.portals.pluto.demo.v3.Constants.*" %>

<portlet:defineObjects />

<h3>Color Selector &amp; Message Sender</h3><hr/>
      
<%      
   String clr = renderRequest.getParameter(PARAM_COLOR);
   clr = (clr == null) ? "#FFFFFF" : clr;
   
   String[] vals = renderRequest.getParameterValues(PARAM_FG_COLOR);
   String r = "";
   String g = "";
   String b = "";
   if (vals != null) {
      for (String v : vals) {
         if (v.equals(PARAM_FG_RED)) r = "checked";
         if (v.equals(PARAM_FG_GREEN)) g = "checked";
         if (v.equals(PARAM_FG_BLUE)) b = "checked";
      }
      }
%>

<form onsubmit='return false;' enctype='application/x-www-form-urlencoded'>
  <table><tr>
     <td align='left'>Enter background color (public param):</td>
     <td>
        <input id='<portlet:namespace/>-color' name='<%=PARAM_COLOR%>' type='text' value='<%=clr%>' size='10' maxlength='10'>
     </td>
     <td><div id='<portlet:namespace/>-putMsgHere'></div></td>
  </tr></table>
</form>
<hr/>
<FORM id='<portlet:namespace/>-setParams' method='POST' enctype='application/x-www-form-urlencoded'>
   <table><tr><td align='left'>
   Select active foreground colors:
   </td><td>
   <input id='<portlet:namespace/>-red' name='<%=PARAM_FG_COLOR%>' value='<%=PARAM_FG_RED%>' type='checkbox' <%=r%>>
   Red
   </td><td>
   <input id='<portlet:namespace/>-green'  name='<%=PARAM_FG_COLOR%>' value='<%=PARAM_FG_GREEN%>' type='checkbox' <%=g%>>
   Green
   </td><td>
   <input id='<portlet:namespace/>-blue'  name='<%=PARAM_FG_COLOR%>' value='<%=PARAM_FG_BLUE%>' type='checkbox' <%=b%>>
   Blue

   </td></tr><tr><td>
   Enter message:
   </td><td colspan=3>
   <input id='<portlet:namespace/>-msg' name='<%=PARAM_MSG_INPUT%>' type='text' value='' size='50' maxlength='50'>
   </td><td>

   </td></tr><tr><td>
   Form submission:
   </td><td>
   <input id='<portlet:namespace/>sType-url' type='radio' name='<%=PARAM_SUBTYPE%>' value='<%=PARAM_SUBTYPE_URL%>' checked>URL
   </td><td>
   <input id='<portlet:namespace/>sType-form' type='radio' name='<%=PARAM_SUBTYPE%>' value='<%=PARAM_SUBTYPE_FORM%>'>Form
   </td><td>
   <INPUT id ='<portlet:namespace/>-send' VALUE='send' TYPE='submit'>
   </td></tr></table>
</FORM>
<p><hr/></p>

<script>
(function () {
   'use strict';
    
   var pid = '<portlet:namespace/>',
       colorEntry = '<portlet:namespace/>-color',
       msgdiv = '<portlet:namespace/>-putMsgHere',
       rid = '<portlet:namespace/>-red',
       gid = '<portlet:namespace/>-green',
       bid = '<portlet:namespace/>-blue',
       mid = '<portlet:namespace/>-msg',
       formid = '<portlet:namespace/>-setParams',
       sidurl = '<portlet:namespace/>sType-url',
       sidform = '<portlet:namespace/>sType-form',
       currState,
       hub,

       
   // Handler for onStateChange event
   update = function (type, state) {
      var oldColor = currState.p.getValue('<%=PARAM_COLOR%>'),
      
          // use getValue with default value that is used if the parameter is not set
          newColor = state.p.getValue('<%=PARAM_COLOR%>', '#FFFFFF'),
          subtype = state.p.getValue('<%=PARAM_SUBTYPE%>', '<%=PARAM_SUBTYPE_URL%>'),
          msg = state.p.getValue('<%=PARAM_MSG_INPUT%>', ''),
          
          fgcolor = state.p.getValues('<%=PARAM_FG_COLOR%>'),
          clr = {red: false, green: false, blue: false}, ii;
      
      console.log("CSP: state updated. Type=" + type + ", color=" + newColor);
      
      if (newColor !== oldColor) {
         document.getElementById(msgdiv).innerHTML = '';
         document.getElementById(colorEntry).value = newColor;
      }
      
      // make sure controls are set according to parameters
      
      if (subtype === '<%=PARAM_SUBTYPE_URL%>') {
         document.getElementById(sidurl).checked = true;
      } else {
         document.getElementById(sidform).checked = true;
      }
       
      if (fgcolor) {
         for (ii = 0; ii < fgcolor.length; ii++) {
            clr[fgcolor[ii]] = true;
         }
      } 
      document.getElementById(rid).checked = clr.red;
      document.getElementById(gid).checked = clr.green;
      document.getElementById(bid).checked = clr.blue;

      document.getElementById(mid).value = msg;

      currState = state;
   };
   

   // Register portlet with Portlet Hub. Add listener for onStateChange event.
   portlet.register(pid).then(function (pi) {
      console.log("CSP Color Selection Portlet: registered: " + pid);
      hub = pi;
      currState = hub.newState();
      hub.addEventListener("portlet.onStateChange", update);
   });
   

   // Handle change in background color entry field
   document.getElementById(colorEntry).onchange = function () {
      var newColor = this.value, newState;
      console.log("CSP: entry field updated. color=" + newColor);
      if ((newColor === undefined) || (newColor === null) || !newColor.match(/^#(?:[A-Fa-f0-9]{3}){1,2}$/)) {
         document.getElementById(msgdiv).innerHTML = 'Bad color. Enter #xxxxxx or #xxx.';
      } else {
         newState = currState.clone();
         newState.p.setValue('color', newColor);
         hub.setRenderState(newState);
      }
   };
   

   // Handler for 'send' button click. Perform Ajax action.
   document.getElementById(formid).addEventListener('submit', function (event) {
      var parms, clrs = [], fel, submitForm = document.getElementById(sidform).checked;
      
      console.log("CSP: sending message. submitForm=" + submitForm);
      
      // decide how form is to be sent -
      if (submitForm) {
         fel = this;
         hub.action(fel);
      } else  {
         parms = hub.newParameters();
         parms.setValue('action', 'send');
         if (document.getElementById(rid).checked) {
            clrs.push("<%=PARAM_FG_RED%>");
         } 
         if (document.getElementById(gid).checked) {
            clrs.push("<%=PARAM_FG_GREEN%>");
         } 
         if (document.getElementById(bid).checked) {
            clrs.push("<%=PARAM_FG_BLUE%>");
         } 
         if (clrs.length > 0) {
            parms.setValue('<%=PARAM_FG_COLOR%>', clrs);
         }
         parms.setValue('<%=PARAM_MSG_INPUT%>', document.getElementById(mid).value);
         hub.action(parms);
      }
      event.preventDefault();
   });
      
}());
</script>
