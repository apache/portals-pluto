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
%>
<FORM METHOD="POST" ACTION="<%=url.toString()%>">
<INPUT value="Next >>" TYPE="submit">
</FORM>
</FONT>

