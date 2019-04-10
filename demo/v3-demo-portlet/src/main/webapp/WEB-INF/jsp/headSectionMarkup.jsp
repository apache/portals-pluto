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

<!-- This jsp generates markup for the document head section -->

<%
headerResponse.addProperty("JspHeader", "Set in included JSP.");
 %>
   
<meta name="description" content="Portlet Hub Demo Portlet">
<style>
<!--
.markupSection {                 /* special chars & < */
   padding: 5px;
   background-color: #DDFFDD;
   border: thin solid #22EE88;
}
-->
</style>
   
<script type="text/javascript">
//<![CDATA[
(function () {
   'use strict';
   var cdiv = '<portlet:namespace/>cookieDiv',

bootstrap = function () {
   var cookies = document.cookie.split(';'), ii, markup;
   markup = '<p>Current Cookies:</p>';
   for (ii = 0; ii < cookies.length; ii++) {
      /* make sure parser eats & character */
      markup += cookies[ii] + '<br/>';
   }
   document.getElementById(cdiv).innerHTML=markup;
};
   
// execute when document has been loaded 
window.addEventListener('load', bootstrap, false);
}());
//]]>
</script>

<p>Hi</p>
