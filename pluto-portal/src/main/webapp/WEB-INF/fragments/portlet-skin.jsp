<%@ taglib uri="http://portals.apache.org/pluto" prefix="pluto" %>

<!-- Use pluto portlet tag to render the portlet -->
<pluto:portlet portletId="${portlet}">

  <!-- Assemble the rendering result -->
  <div class="portlet" id='<c:out value="${portlet}"/>'>
    <div class="header">
      <!-- Portlet Mode Controls -->
      <a href="<pluto:url portletMode="help"/>"><span class="help"></span></a>
      <a href="<pluto:url portletMode="edit"/>"><span class="edit"></span></a>
      <a href="<pluto:url portletMode="view"/>"><span class="view"></span></a>
      <!-- Window State Controls -->
      <a href="<pluto:url windowState="minimized"/>"><span class="min"></span></a>
      <a href="<pluto:url windowState="maximized"/>"><span class="max"></span></a>
      <a href="<pluto:url windowState="normal"/>"><span class="norm"></span></a>
      <!-- Portlet Title -->
      <h2 class="title"><pluto:title/></h2>
    </div>
    <div class="body">
      <pluto:render/>
    </div>
  </div>

</pluto:portlet>

