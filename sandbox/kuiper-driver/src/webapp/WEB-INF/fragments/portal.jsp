<!-- 
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
-->

<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%-- This portlet page supports the layout of the actual
     portlets on the page.  Currently (and probably 
     forever since we're just a portalDriver and not a full
     portal implementation), only one layout is supported -
     a two column layout which renders each odd indexed
     portlet in column one and each even indexed portlet in
     column two.
     
     |-------------|
     ||----||      |
     ||----||      |
     |      |      |
     |-------------|
--%>
<%-- First Define our outside container --%>
<c:choose>
<c:when test="${currentPage.maximizedState}">

<TABLE>
<c:set var="portlet" value="${currentPage.maximizedPortletWindow}"/>
<TR><TD><tiles:insert name="portlet-skin">
          <tiles:put name="portlet" beanName="portlet"/>
        </tiles:insert></TD></TR>
</c:when>
<c:otherwise>
<TABLE>
<TR><TD valign="top"><!-- COLUMN #1 -->
    <c:forEach var="portlet" varStatus="status" items="${currentPage.portlets}">
    <c:if test="${status.index%2==0}">
    <tiles:insert name="portlet-skin">
      <tiles:put name="portlet" beanName="portlet"/>
    </tiles:insert>
    </c:if>
    </c:forEach></TD>

    <TD valign="top"><!-- COLUMN #2 -->
    <c:forEach var="portlet" varStatus="status" items="${currentPage.portlets}">
    <c:if test="${status.index%2!=0}">
    <tiles:insert name="portlet-skin">
      <tiles:put name="portlet" beanName="portlet"/>
    </tiles:insert>
    </c:if>
    </c:forEach></TD></TR>
</TABLE>
</c:otherwise>
</c:choose>
