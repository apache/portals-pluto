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
<%@ page session="false" %>
<%@ taglib uri='/WEB-INF/tld/portlet.tld' prefix='portlet'%>
<%@ page import="javax.portlet.*"%>
<%@ page import="java.util.*"%>
<portlet:defineObjects/>
<%
    String baseNS = renderResponse.getNamespace();
%>

<I>This portlet is testing basic functions...</I>
<P>
<FONT SIZE="-1">
<B>Testing PortletPreferences (2)...</B><BR>
<BR>
Testing permanence of values:<BR>
<%
    boolean allOk = false;
    PortletPreferences preferences = renderRequest.getPreferences();

    if (preferences.getValue("TEST_PERMANENCE", "Default").equals("permanent"))
        allOk = true;

    if (allOk) { out.print("<b>passed</b>."); }
    else { out.print("<b><font color=red>failed</font></b>."); }
%>
<BR>
<BR>
Testing value after reset AND store:<BR>
<%
    allOk = true;

    if (!preferences.getValue("TEST_RESET_KEY", "Default").equals("Default"))
        allOk = false;

    if (allOk) { out.print("<b>passed</b>."); }
    else { out.print("<b><font color=red>failed</font></b>."); }
%>
<BR>
<BR>
Testing automatic reset() after every render():<BR>
<%
    allOk = true;

    if (preferences.getValue("TEST_RESET_2", "Default").equals("success"))
        allOk = false;

    if (allOk) { out.print("<b>passed</b>."); }
    else { out.print("<b><font color=red>failed</font></b>."); }
%>
<BR>
<BR>
Testing null values:<BR>
<%
    allOk = true;

    if (preferences.getValue("TEST_NULL_VALUE", "Default") != null )
        allOk = false;
    if (preferences.getValue("TEST_NULL_VALUES", "Default") != null )
        allOk = false;
    if (preferences.getValues("TEST_NULL_VALUES", new String[]{"Default"}) != null )
        allOk = false;

    if (allOk) { out.print("<b>passed</b>."); }
    else { out.print("<b><font color=red>failed</font></b>."); }
%>
<BR><BR>
<BR><BR>
<B>Testing PreferencesValidator</B><BR>
<BR>
Setting unvalid preference value.<BR>
<%
    String result = preferences.getValue("VALIDATION_TEST_KEY", "No test results available.");
    out.print("<BR><B>" + result + "</B><BR>");
%>
<BR>
<%
PortletURL url = renderResponse.createActionURL();
url.setParameter("checkPreferences","TidyUp");
url.setParameter("jspNameTransfer","test9.jsp");
url.setSecure(renderRequest.isSecure());
%>
<FORM METHOD="POST" ACTION="<%=url.toString()%>">
<INPUT value="Next >>" TYPE="submit">
</FORM>
</FONT>

