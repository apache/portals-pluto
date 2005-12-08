<%@ taglib uri="http://portals.apache.org/pluto" prefix="pluto" %>

<pluto:portlet portletId="${portlet}">
<div class="portlet" id='<c:out value="${portlet}"/>'>
  <div class="header">
     <a href="<pluto:window portletMode="help"/>"><img src="<%= request.getContextPath() %>/images/controls/help.png" title="Help" alt="Help" class="help"/></a>
     <a href="<pluto:window portletMode="edit"/>"><img src="<%= request.getContextPath() %>/images/controls/edit.png" title="Edit" alt="Edit" class="edit"/></a>
     <a href="<pluto:window portletMode="view"/>"><img src="<%= request.getContextPath() %>/images/controls/view.png" title="View" alt="View" class="view"/></a>

     <a href="<pluto:window windowState="minimized"/>"><img src="<%= request.getContextPath() %>/images/controls/min.png" title="Minimize" alt="Minimize" class="min"/></a>
     <a href="<pluto:window windowState="maximized"/>"><img src="<%= request.getContextPath() %>/images/controls/max.png" title="Maximize" alt="Maximize" class="max"/></a>
     <a href="<pluto:window windowState="normal"/>"><img src="<%= request.getContextPath() %>/images/controls/norm.png" title="Normal" alt="Normal" class="norm"/></a>
     <span class="title"><pluto:title/></span>
  </div>
  <p>
      <pluto:render/>
  </p>
</div>
</pluto:portlet>

