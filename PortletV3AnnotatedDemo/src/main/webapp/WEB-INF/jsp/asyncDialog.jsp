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
<%@ page import="static org.apache.portals.samples.AsyncDialogBean.*" %>

<portlet:defineObjects />

<h3>Async Portlet: asyncDialog.jsp</h3>
<script type="text/javascript">
   function show_hide(id) {
      var elem = document.getElementById(id);
      if(elem.style.display == 'block') {
         elem.style.display = 'none';
      }
      else {
         elem.style.display = 'block';
      }
   }
</script>
<a href="#" onclick="show_hide('help');">Show/Hide Help</a>
<div id="help" style="display: none;">
<p>When this JSP is initially rendered, it automatically triggers a GET XmlHttpRequest to a ResourceURL which causes the following sequence:
   <ul>
      <li>AsyncPortlet.getResource(...) is invoked
         <ol>
            <li>ResourceRequest.startPortletAsyncContext() is called to get a new PortletAsyncContext</li>
            <li>Pass the @DependentScoped AsyncRunnable (injected into AsyncPortlet by CDI), to portletAsyncContext.startAsync(asyncRunnable)</li>
            <li>This has the effect of starting a new thread and calling the AsyncRunnable.run() method</li>
            <li>The ResourceResponse is left open by the portlet container and processing is given over to the AsyncRunnable thread</li>
            <li>The AsyncRunnable thread sleeps for 1 second, then wakes up</li>
            <li>The AsyncRunnable thread recognizes that the "recursive" (auto dispatch) feature is enabled and as a result calls PortletAsyncContext.dispatch() in order to have the AsyncPortlet.getResource(...) method get called again, which in turn writes some text to the response</li>
            <li>The AsyncRunnable thread finishes execution</li>
         </ol></li>
   </ul>
   <ul>
      <li>Clicking on the Execute button will cause a full HTTP postback of the page, but when the page re-renders after the POST-REDIRECT-GET, then the page triggers a subsequent GET XmlHttpRequest to a ResourceURL</li>
      <li>Note that if the "recursive" checkbox is <strong>not</strong> checked, then clicking Execute will cause the AsyncRunnable thread to write to the respose, rather than dispatching back to the AsyncPortlet.getResource(...) method to write to the response</li>
   </ul>
</p>
<p>The <strong>AsyncFilter</strong> is always present within the FilterChain but will only output information to the response if the "show filter" checkbox is checked</p>
<p>The <strong>AsyncListener</strong> is always added to the PortletAsyncContext but will only output information to the response if the "show listener" checkbox is checked</p>
</div>
<div class='parmbox'>
<FORM  ACTION='<portlet:actionURL/>' id='<portlet:namespace/>-setParams' method='POST' enctype='application/x-www-form-urlencoded'>
   <table style='width:100%;'><tr><td align='left'>

   Delay:
   </td><td>
   <input id='<portlet:namespace/>-delay' name='<%=PARAM_DELAY%>' type='text' value='${adb.getDelay() }' size='5' maxlength='5'>
   </td><td>
   Repetitions:
   </td><td>
   <input id='<portlet:namespace/>-reps' name='<%=PARAM_REPS%>' type='text' value='${adb.getReps() }' size='5' maxlength='5'>
   </td><td>
   <input name='<%=PARAM_AUTO%>' value='<%=PARAM_AUTO%>' type='checkbox' ${adb.isAutoDispatch() ? "checked" : "" } > recursive

   </td></tr><tr><td>
   Handle timeout:
   </td><td>
   <input type='radio' name='<%=PARAM_TO%>' value='<%=PARAM_TO_NOP%>' ${adb.getHandleTimeout() == "NOP" ? "checked" : "" } > ignore
   </td><td>
   <input type='radio' name='<%=PARAM_TO%>' value='<%=PARAM_TO_CPL%>' ${adb.getHandleTimeout() == "CPL" ? "checked" : "" } > complete
   </td><td>
   <input type='radio' name='<%=PARAM_TO%>' value='<%=PARAM_TO_DIS%>' ${adb.getHandleTimeout() == "DIS" ? "checked" : "" } > dispatch

   </td></tr><tr><td>
   Output type:
   </td><td>
   <input type='radio' name='<%=PARAM_TYPE%>' value='<%=PARAM_TYPE_TXT%>' ${adb.getType() == "TEXT" ? "checked" : "" } > text
   </td><td>
   <input type='radio' name='<%=PARAM_TYPE%>' value='<%=PARAM_TYPE_INC%>' ${adb.getType() == "INC" ? "checked" : "" } > include
   </td><td>
   <input type='radio' name='<%=PARAM_TYPE%>' value='<%=PARAM_TYPE_FWD%>' ${adb.getType() == "FWD" ? "checked" : "" } > forward
   </td><td>
   <input type='radio' name='<%=PARAM_TYPE%>' value='<%=PARAM_TYPE_DIS%>' ${adb.getType() == "DISPATCH" ? "checked" : "" } > dispatch

   </td></tr><tr><td>
   <INPUT id ='<portlet:namespace/>-send' VALUE='execute' TYPE='submit'>
   </td><td>
   <input name='<%=PARAM_FILTER%>' value='<%=PARAM_FILTER%>' type='checkbox' ${adb.isShowFilter() ? "checked" : "" } > show filter
   </td><td>
   <input name='<%=PARAM_LISTENER%>' value='<%=PARAM_LISTENER%>' type='checkbox' ${adb.isShowListener() ? "checked" : "" } > show listener
   </td></tr></table>
</FORM>
<p>
Request #: ${reqnum.getRandomNumber()}
<span style='margin-left: 2em;'>${adb.getMsg()}</span>
</p>
</div>
<div class='infobox' id='<portlet:namespace/>putResourceHere'></div>


<script>
(function () {
   var xhr = new XMLHttpRequest();
   xhr.onreadystatechange=function() {
      if (xhr.readyState==4 && xhr.status==200) {
         document.getElementById('<portlet:namespace/>putResourceHere').innerHTML=xhr.responseText;
      }
   };
   xhr.open('GET', '<portlet:resourceURL/>', true);
   xhr.send();
})();
</script>
