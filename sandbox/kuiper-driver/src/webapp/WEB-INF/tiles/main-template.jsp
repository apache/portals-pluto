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

<%@ taglib uri="/tags/struts-html"  prefix="html"   %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%--
  The MAIN Template defines the primary look and feel
  of the site.  It depends upon the following tiles:
    0. tile-head (Defines HTML <HEAD> Element Content)
    1. tile-header
    2. tile-navigation
    3. tile-layout
--%>

<html:html>
<HEAD>
	<TITLE>Kuiper Driver Portal &lt; <tiles:getAsString name="page-title" ignore="true"/></TITLE>
	<LINK rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/style.css">
</HEAD>
<BODY bgcolor="#FFFFFF">
<TABLE class="container">
<TR><TD colspan="2" width="100%"><tiles:insert name="tile-header"/></TD></TR>
<TR><TD width="140" colspan="1" height="2" valign="top" align="left">
		<tiles:insert name="tile-navigation"/></TD>
	<TD width="460" class="content" rowspan="2" valign="top" align="left">
		<tiles:insert name="tile-layout">
			<tiles:put name="tile-subnavigation"><tiles:getAsString name="tile-subnavigation"/></tiles:put>
			<tiles:put name="page-title"><tiles:getAsString name="page-title"/></tiles:put>
			<tiles:put name="page-content"><tiles:getAsString name="page-content"/></tiles:put>
		</tiles:insert>
		</TD></TR>
<TR><TD width=140 height="28" valign="bottom" align="left">
<TR><TD colspan="2" align="right">
	<tiles:insert name="tile-footer"/>
	</TD></TR>
</TABLE>
</BODY>
</html:html>
