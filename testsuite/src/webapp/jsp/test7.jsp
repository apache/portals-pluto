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
<%@ page session="true" %>
<%@ taglib uri='/WEB-INF/tld/portlet.tld' prefix='portlet'%>
<%@ page import="javax.portlet.*"%>
<%@ page import="java.util.*"%>
<portlet:defineObjects/>
<%
    String baseNS = renderResponse.getNamespace();
%>
<I>This portlet is testing basic functions...</I>
<P><FONT SIZE="-1">
<B>TestPortlet ok?</B>
<P>

<%
PortletURL url = renderResponse.createRenderURL();
url.setParameter("jspName","test1.jsp");
%>
<FORM METHOD="POST" ACTION="<%=url.toString()%>">
<INPUT value="Next >>" TYPE="submit">
</FORM>
</FONT>
