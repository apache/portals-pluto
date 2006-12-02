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

<div>
  <h2>Portal Pages</h2>
  <p>
    <select name="page">
    <c:forEach items="${driverConfig.pages}" var="page">
      <option value="<c:out value="${page.name}"/>"><c:out value="${page.name}"/> (<c:out value="${page.uri}"/>)</option>
    </c:forEach>
    </select>
  </p>
  </div>

<div>
  <h2>Portlet Applications</h2>
  <p>
    <select name="apps" onChange="alert('Once Implemented, you will be able to add this portlet to this page.');">
    <c:forEach items="${portletContainer.optionalContainerServices.portletRegistryService.registeredPortletApplications}" var="app">
        <optgroup label="<c:out value="${app.applicationId}"/>">
            <c:forEach items="${app.portletApplicationDefinition.portlets}" var="portlet">
                <option value="<c:out value="${portlet.portletName}"/>"><c:out value="${portlet.portletName}"/></option>
            </c:forEach>
        </optgroup>
    </c:forEach>
    </select>
  </p>
</div>


