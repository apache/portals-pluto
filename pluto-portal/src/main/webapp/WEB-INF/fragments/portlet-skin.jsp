<%@ taglib uri="http://portals.apache.org/pluto" prefix="pluto" %>

<pluto:portlet portletId="${portlet}">
<div class="portlet" id='<c:out value="${portlet}"/>'>
  <div class="header">
     <a href="<pluto:window portletMode="help"/>"><span class="help"></span></a>
     <a href="<pluto:window portletMode="edit"/>"><span class="edit"></span></a>
     <a href="<pluto:window portletMode="view"/>"><span class="view"></span></a>

     <a href="<pluto:window windowState="minimized"/>"><span class="max"></span></a>
     <a href="<pluto:window windowState="maximized"/>"><span class="min"></span></a>
     <a href="<pluto:window windowState="normal"/>"><span class="nor"></span></a>
     <span class="title"><pluto:title/></span>
  </div>
  <p>
      <pluto:render/>
  </p>
</div>
</pluto:portlet>

