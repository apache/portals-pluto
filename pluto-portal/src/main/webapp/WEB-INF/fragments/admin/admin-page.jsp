<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<div id="portletgroupone">
  <div class="portlet">
    <div class="header">
      <span class="title">Portlet Applications</span>
    </div>

    <ul>
    <c:forEach items="${driverConfig.portletApplications}" var="app">
      <li><c:out value="${app.contextPath}"/>
      <ul>
      <c:forEach items="${app.portlets}" var="portlet">
        <c:out value="${portlet.portletName}"/>
      </c:forEach>
      </ul>
      </li>
    </c:forEach>
    </ul>
  </div>
</div>

<div id="portletgrouptwo">
  <div class="portlet">
    <div class="header">
        <span class="title">Portal Pages</span>
    </div>
    <ul>
      <c:forEach items="${driverConfig.pages}" var="page">
        <li><c:out value="${page.name}"/> <small>(<c:out value="${page.uri}"/>)</small></li>
      </c:forEach>
    </ul>
  </div>
</div>