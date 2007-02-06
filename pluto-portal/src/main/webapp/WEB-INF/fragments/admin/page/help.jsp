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
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet" %>

<div class="portlet-section-header">Page Adminstrator Portlet Help</div>

<p class="portlet-font">
The Page Administrator Portlet works with portal pages and portlet applications defined in pluto-portal-driver-config.xml. 
Portlets must be deployed to the app server (Tomcat in the binary distribution). Deployment can be done via Maven, Ant 
or the app server's deployment console (use the 'Upload and deploy portlet war' link on the bottom of the page). 
</p>

<div class="portlet-section-subheader">Configuring a Portlet Application</div>
<p class="portlet-font">
The portlet application needs to be registered in pluto-portal-driver-config.xml with a 
proper portlet-app record like this:
<pre>
&lt;portlet-app&gt;
    &lt;context-path&gt;/HelloWorldPortlet&lt;/context-path&gt;
    &lt;portlets&gt;
      &lt;portlet name="HelloWorldPortlet"/&gt;
    &lt;/portlets&gt;
&lt;/portlet-app&gt;
</pre>  
</p>

<div class="portlet-section-subheader">Configuring a Portal Page</div>
<p class="portlet-font">
The portal needs to be defined in pluto-portal-driver-config.xml as a page child element of render-config:
<pre>
&lt;page name="Hello World Page" uri="/WEB-INF/themes/pluto-default-theme.jsp"&gt;
&lt;/page&gt;
</pre>
</p>

<div class="portlet-section-subheader">Adding Portlets to a Portal Pages</div>
<p class="portlet-font">
Adding portlets to a portal page involves first selecting a portal page using the Portal Pages drop-down and then
selecting a portlet application using the Portlet Applications drop-down. When this is done, click the Add Portlet 
button.
</p>

<div class="portlet-section-subheader">Removing Portal Pages</div>
<p class="portlet-font">
Removing portlets from a portal page involves selecting a portal page using the Portal Pages drop-down and then
clicking on the Remove Page button.
</p>


<div class="portlet-section-subheader">Manually Updating the Configuration File</div>
<p class="portlet-font">
The Page Administrator Portlet does not persist any portlet additions or portal page removals to 
the pluto-portal-driver-config.xml file. This must be done manually in the config file. Removal of portlets
from pages must also be done manually in pluto-portal-driver-config.xml.
</p>

<p class="portlet-font">
To manually add a portlet to a page in pluto-portal-driver-config.xml, a portlet child element must be added to the 
page element. This element should look like this:
<pre>
&lt;portlet context="/HelloWorldPortlet" name="HelloWorldPortlet"/&gt;
</pre>
</p>
<p class="portlet-font">
 The value of the context-path element within the portlet-app record must correspond to the value of the context 
 attribute in the portlet element. In addition, the value of the name attribute in the portlet child element of 
 portlet-app must correspond to the value of the name attribute of the portlet child element of page. 
</p>

<%-- Properties for link to app server deployer and help mode file --%>
<fmt:bundle basename="AdminPortlet">
	<fmt:message key="appserver.deployer.help.page" var="deployerHelp"/>
	<fmt:message key="appserver.deployer.help.page" var="deployerHelp"/>
</fmt:bundle> 
<portlet:renderURL portletMode="help" var="deployerhelpURL">
	<portlet-el:param name="helpPage" value="${deployerHelp}"/>
</portlet:renderURL>

<p class="portlet-font">
<a href='<c:out value="${deployerhelpURL}"/>'>Upload and Deployment in App Server Help</a>
</p>

<p class="portlet-font">
<a href='<portlet:renderURL portletMode="view"/>'>Page Administrator Portlet</a> 
</p>
