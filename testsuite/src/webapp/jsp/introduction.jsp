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
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet"%>

<portlet:defineObjects/>

<TABLE>
<TR><TD>
    <P>
    This portlet is a portlet specification compatibility test portlet.
    It provides several tests of verying complexities which will assist
    in evaluating compliance with the portlet specification. It was originally
    developed for testing Apache Pluto, however, it does not utilize any
    proprietary APIs and should work with all compliant portlet containers.
    </P>

    <P>Please select one of the following tests:
    <TABLE>
    <c:forEach var="test" items="${tests}" varStatus="status">
    <TR><TD><c:out value="${test.name}"/></TD>
        <portlet:actionURL secure="<%=renderRequest.isSecure()?"True":"False"%>" var="url">
    	<portlet:param name="testId" value='<%=((javax.servlet.jsp.jstl.core.LoopTagStatus)pageContext.getAttribute("status")).getIndex()+""%>'/>
        </portlet:actionURL>
        <TD><A href="<c:out value="${url}"/>">Test</A></TD>
    </c:forEach>
    </TABLE>

    </P>
    </TD></TR>
</TABLE>