<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<div>
  <h2>Portlet Applications</h2>
  <p>
    <ul>
      <c:forEach items="${driverConfig.portletApplications}" var="app">
        <li>
          <c:out value="${app.contextPath}"/>
          <ul>
            <c:forEach items="${app.portlets}" var="portlet">
              <c:out value="${portlet.portletName}"/>
            </c:forEach>
          </ul>
        </li>
      </c:forEach>
    </ul>
  </p>
</div>

<div>
  <h2>Portal Pages</h2>
  <p>
    <ul>
      <c:forEach items="${driverConfig.pages}" var="page">
        <li>
          <c:out value="${page.name}"/><br/>
          &nbsp;&nbsp;<small><c:out value="${page.uri}"/></small>
        </li>
      </c:forEach>
    </ul>
  </p>
</div>


