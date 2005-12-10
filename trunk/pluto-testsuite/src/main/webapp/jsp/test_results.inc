<%--
Copyright 2004 The Apache Software Foundation
Licensed  under the  Apache License,  Version 2.0  (the "License");
you may not use  this file  except in  compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed  under the  License is distributed on an "AS IS" BASIS,
WITHOUT  WARRANTIES OR CONDITIONS  OF ANY KIND, either  express  or
implied.

See the License for the specific language governing permissions and
limitations under the License.
--%>


<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet" %>

<%
    pageContext.setAttribute("passed", "Passed");
    pageContext.setAttribute("failed", "Failed");
    pageContext.setAttribute("warning", "Warning");
%>

<portlet:defineObjects/>

<table style="font-size: -1">
  <c:choose>
    <c:when test="${results == null}">
      <tr>
        <th colspan="2" style="background-color: red; color: white">RESULT NOT FOUND</th>
      </tr>
    </c:when>
    <c:when test="${results.failed}">
      <tr>
        <th colspan="2" style="background-color: red; color: white">FAILED</th>
      </tr>
    </c:when>
    <c:when test="${results.inQuestion}">
      <tr>
        <th colspan="2" style="background-color: yellow">WARNING</th>
      </tr>
    </c:when>
    <c:otherwise>
      <tr>
        <th colspan="2" style="background-color: green; color: white">PASSED</th>
      </tr>
    </c:otherwise>
  </c:choose>
  
  <tr>
    <th />
    <th><c:out value="${results.name}"/></th>
  </tr>
  
  <c:forEach var="result" varStatus="status" items="${results.collection}">
    <tr>
      
      <!-- Result Icon ===================================================== -->
      <td valign="top">
        <c:choose>
          <c:when test="${result.returnCode == passed}">
            <img src="<%= renderResponse.encodeURL(renderRequest.getContextPath() + "/images/yes.gif") %>"
                 border="0" />
          </c:when>
          <c:when test="${result.returnCode == failed}">
            <img src="<%= renderResponse.encodeURL(renderRequest.getContextPath() + "/images/no.gif") %>"
                 border="0" />
          </c:when>
          <c:otherwise>
            <img src="<%= renderResponse.encodeURL(renderRequest.getContextPath() + "/images/question.gif") %>"
                 border="0" />
          </c:otherwise>
        </c:choose>
      </td>
      
      <td style="font-size:12px;" nowrap="true">
        <c:out value="${result.name}"/>
      </td>
    </tr>
    
    <c:choose>
      <c:when test="${result.returnCode == passed}">
        <tr>
          <td />
          <td style="font-size:10px;">
            <c:out value="${result.desc}"/>
          </td>
        </tr>
      </c:when>
      <c:otherwise>
        <tr>
          <td />
          <td style="font-size:10px;">
            <c:out value="${result.results}"/>
          </td>
        </tr>
      </c:otherwise>
    </c:choose>
  </c:forEach>
  
</table>

