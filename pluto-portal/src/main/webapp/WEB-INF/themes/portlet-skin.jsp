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
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://portals.apache.org/pluto" prefix="pluto" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Use pluto portlet tag to render the portlet -->
<pluto:portlet portletId="${portlet}">

  <!-- Assemble the rendering result -->
  <div class="portlet">
    <table class="header" width="100%">
    	<tr>
    	<td class="header" align="left">
	      <!-- Portlet Title -->
	      <h2 class="title"><pluto:title/></h2>
	</td>
        <td class="header" align="right">
	      <!-- Portlet Mode Controls -->
	      <pluto:modeDropDown />
	
	      <!-- Window State Controls -->
	      <pluto:windowStateAnchor windowState="minimized" icon='<%= request.getContextPath() + "/images/controls/min.png"%>' />
	      <pluto:windowStateAnchor windowState="maximized" icon='<%= request.getContextPath() + "/images/controls/max.png"%>' />
	      <pluto:windowStateAnchor windowState="normal" icon='<%= request.getContextPath() + "/images/controls/norm.png"%>' />
    	</td>
    	</tr>
    </table>
    <div class="body">
      <pluto:render/>
    </div>
  </div>

</pluto:portlet>

