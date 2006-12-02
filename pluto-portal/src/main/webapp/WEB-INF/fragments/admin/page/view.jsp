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
    <!-- TODO: Should be namespaced! -->
    <form name="adminForm" action="#">

    <script type="text/javascript">
        var portlets = new Array();
        <c:forEach items="${portletContainer.optionalContainerServices.portletRegistryService.registeredPortletApplications}" var="app">
            var i = 0;
            portlets['<c:out value="${app.applicationId}"/>'] = new Array();
            portlets['<c:out value="${app.applicationId}"/>'][i++] = 'Select. . .';
          <c:forEach items="${app.portletApplicationDefinition.portlets}" var="portlet">
            portlets['<c:out value="${app.applicationId}"/>'][i++] = '<c:out value="${portlet.portletName}"/>';
          </c:forEach>
        </c:forEach>

        function doSwitch(select) {
            var portletsSelectBox = document.forms['adminForm'].elements['portlets'];
            if (select.value == '-') {
                document.forms['adminForm'].elements['portlets'].disabled = true;
            } else {
                portletsSelectBox.disabled = false;
                var pList = portlets[select.value];
                for (i = 0; i < pList.length; i++) {
                    portletsSelectBox.options[i] = new Option(pList[i], pList[i]);
                }
            }
            doSwitchButton(portletsSelectBox);
        }

        function doSwitchButton(select) {
            document.forms['adminForm'].elements['submitButton'].disabled = (select.value == 'Select. . .' || select.disabled);
        }
    </script>

        <select name="applications" onChange="doSwitch(this)">
            <option value='-'>Select. . .</option>
            <c:forEach items="${portletContainer.optionalContainerServices.portletRegistryService.registeredPortletApplications}" var="app">
        <option value="<c:out value="${app.applicationId}"/>"><c:out value="${app.applicationName}"/></option>
    </c:forEach>
    </select>

    <select name="portlets" disabled="true" onChange='doSwitchButton(this)'>

    </select>

    <button onClick="alert('Sorry, this feature has not yet been implemented'); return false;" name="submitButton" disabled="true">
        Add Portlet
    </button>
    </form>
  </p>
</div>
