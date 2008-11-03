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

<%@ page import="java.util.Map"%>
<%@ page import="org.apache.pluto.testsuite.TestConfig"%>

<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<portlet:defineObjects/>

<% if (request instanceof javax.portlet.RenderRequest) {%>
<center>
  <table>
    <tr>
      <td align="center" nowrap="true">
        
        <%-- Run Previous Test ============================================ --%>
        <portlet:actionURL secure='<%= request.isSecure() ? "True" : "False" %>' var="url">
          <portlet:param name="nextTestId" value='<%= request.getParameter("testId") %>'/>
          <c:forEach var="param" items="${prevTest.actionParameters}">
            <%
                TestConfig.Parameter parameter = (TestConfig.Parameter) pageContext.findAttribute("param");
                String paramName = parameter.getName();
                String paramValue = parameter.getValue();
            %>
            <portlet:param name="<%= paramName %>" value="<%= paramValue %>"/>
          </c:forEach>
        </portlet:actionURL>
        <a href="<%= url %>">
          <img src='<%= response.encodeURL(request.getContextPath() + "/images/previous.png") %>' border="0">
        </a>
        
        <%-- Return to Introduction ======================================= --%>
        <portlet:actionURL secure='<%= request.isSecure() ? "True" : "False" %>' var="url">
          <portlet:param name="testId" value="<%= null %>"/>
        </portlet:actionURL>
        <a href="<%= url %>">
          <img src='<%= response.encodeURL(request.getContextPath() + "/images/return_index.png") %>' border="0">
        </a>
        
        <%-- Run Next Test ================================================ --%>
        <portlet:actionURL secure='<%= request.isSecure() ? "True" : "False" %>' var="url">
          <portlet:param name="previousTestId" value='<%= request.getParameter("testId") %>'/>
          <c:forEach var="param" items="${nextTest.actionParameters}">
            <%
                TestConfig.Parameter parameter = (TestConfig.Parameter) pageContext.findAttribute("param");
                String paramName = parameter.getName();
                String paramValue = parameter.getValue();
            %>
            <portlet:param name="<%= paramName %>" value="<%= paramValue %>"/>
          </c:forEach>
        </portlet:actionURL>
        <a href="<%= url %>">
          <img src='<%= response.encodeURL(request.getContextPath() + "/images/next.png") %>' border="0">
        </a>
        
      </td>
    </tr>
  </table>
</center>

<% } %>

