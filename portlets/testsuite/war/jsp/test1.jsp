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
<B>Testing renderRequest...</B><BR>
getAttribute(), setAttribute() and removeAttribute()...
<%
    boolean allOk = true;
    String attribute = (String)renderRequest.getAttribute("testName");
    if (attribute==null)
         { out.print("#1 passed..."); }
    else { out.print("#1 failed..."); allOk = false; }
    renderRequest.setAttribute("testName", "testValue");
    attribute = (String)renderRequest.getAttribute("testName");
    if (attribute.equals("testValue"))
         { out.print("#2 passed..."); }
    else { out.print("#2 failed..."); allOk = false; }
    renderRequest.removeAttribute("testName");
    attribute = (String)renderRequest.getAttribute("testName");
    if (attribute==null)
         { out.print("#3 passed..."); }
    else { out.print("#3 failed..."); allOk = false; }
    if (allOk) { out.print("<b>all passed</b>."); }
    else { out.print("<b><font color=red>failed</font></b>."); }
%>
<BR>
getAttributeNames()...
<%
    allOk = true;
    renderRequest.setAttribute("testName", "testValue");
    renderRequest.setAttribute("testName2", "testValue2");
    try
    {
        int nr = 1;
        Enumeration attributes = renderRequest.getAttributeNames();
        while (attributes.hasMoreElements())
        {
            String name = (String)attributes.nextElement();
            attribute = (String)renderRequest.getAttribute(name);
            if (attribute!=null)
                 { out.print("#"+nr+" passed..."); }
            else { out.print("#"+nr+" failed..."); allOk = false; }
            nr++;
        }
    }
    catch (Exception e)
    {
        e.printStackTrace(System.err);
        out.print("<font color=red>"+e.toString()+"</font>...");
        allOk = false;
    }
    if (allOk) { out.print("<b>all passed</b>."); }
    else { out.print("<b><font color=red>failed</font></b>."); }
%>
<BR>
<BR>
<B>Testing PortletContext...</B>TBD<BR>
<BR>
<BR>
<B>Testing PortletSession...</B><BR>
getAttribute(PORTLET_SCOPE), setAttribute(PORTLET_SCOPE) and removeAttribute(PORTLET_SCOPE)...
<%
	PortletSession portletSession = renderRequest.getPortletSession();
    allOk = true;
    attribute = (String)portletSession.getAttribute("testName", PortletSession.PORTLET_SCOPE);
    if (attribute==null)
         { out.print("#1 passed..."); }
    else { out.print("#1 failed..."); allOk = false; }
    portletSession.setAttribute("testName", "testValue", PortletSession.PORTLET_SCOPE);
    attribute = (String)portletSession.getAttribute("testName", PortletSession.PORTLET_SCOPE);
    if (attribute.equals("testValue"))
         { out.print("#2 passed..."); }
    else { out.print("#2 failed..."); allOk = false; }
    portletSession.removeAttribute("testName", PortletSession.PORTLET_SCOPE);
    attribute = (String)portletSession.getAttribute("testName", PortletSession.PORTLET_SCOPE);
    if (attribute==null)
         { out.print("#3 passed..."); }
    else { out.print("#3 failed..."); allOk = false; }
    if (allOk) { out.print("<b>all passed</b>."); }
    else { out.print("<b><font color=red>failed</font></b>."); }
%>
<BR>
getAttributeNames()...
<%
    allOk = true;
    portletSession.setAttribute("testName1", "testValue1", PortletSession.PORTLET_SCOPE);
    portletSession.setAttribute("testName2", "testValue2", PortletSession.PORTLET_SCOPE);
    try
    {
        int nr = 1;
        Enumeration attributes = portletSession.getAttributeNames(PortletSession.PORTLET_SCOPE);
        while (attributes.hasMoreElements())
        {
            String name = (String)attributes.nextElement();
            attribute = (String)portletSession.getAttribute(name, PortletSession.PORTLET_SCOPE);
            if (attribute!=null)
                 { out.print("#"+nr+" passed..."); }
            else { out.print("#"+nr+" failed..."); allOk = false; }
            nr++;
        }
    }
    catch (Exception e)
    {
        e.printStackTrace(System.err);
        out.print("<font color=red>"+e.toString()+"</font>...");
        allOk = false;
    }
    if (allOk) { out.print("<b>all passed</b>."); }
    else { out.print("<b><font color=red>failed</font></b>."); }
%>
<BR><BR>
getAttribute(APPLICATION_SCOPE)...<B><%=portletSession.getAttribute("globalTestName", PortletSession.APPLICATION_SCOPE)%></B><BR>
setAttribute('globalTestValue', APPLICATION_SCOPE)...done<%portletSession.setAttribute("globalTestName", "globalTestValue", PortletSession.APPLICATION_SCOPE);%><BR>
<I>please check in your second portlet whether you get the value 'globalTestValue'. Otherwise an error occured.</I><BR>
<BR>
<%
PortletURL url = renderResponse.createRenderURL();
url.setParameter("jspName","test2.jsp");
%>
<FORM METHOD="POST" ACTION="<%=url.toString()%>">
    <INPUT value="Next >>" TYPE="submit">
    <INPUT TYPE="hidden" NAME="testName" VALUE="testValue">
    <INPUT TYPE="hidden" NAME="testName2" VALUE="testValue1">
    <INPUT TYPE="hidden" NAME="testName2" VALUE="testValue2">
</FORM>
</FONT>
<!--
<TABLE cellSpacing="0" cellPadding="0" border="0" width="100%">
  <TR>
    <TD>
      <FORM name="<%=baseNS%>Temperatur">
        <table width="100%" border="0" cellspacing="2" cellpadding="0">
          <tr>
            <td>Celsius:</td>
            <td>Fahrenheit:</td>
          </tr>
          <tr>
            <td>
              <input maxlength="7" size="7" name="C">
              <input onClick=<%=baseNS%>nachC() type="button" value="<<" name="button"></td>
            <td>
              <input onClick=<%=baseNS%>nachF() type="button" value=">>" name="button2">
              <input maxlength="7" size="7" name="F">
            </td>
          </tr>
        </table>
      </FORM>
    </TD>
  </TR>
  <TR>
    <TD>
      <FORM name=<%=baseNS%>Temperatur2>
        <table width="100%" border="0" cellspacing="2" cellpadding="0">
          <tr>
            <td>Celsius:</td>
            <td>Kelvin:</td>
          </tr>
          <tr>
            <td>
              <input maxlength="7" size="7" name="C">
              <input onClick=<%=baseNS%>nachC2() type="button" value="<<" name="button3"></td>
            <td>
              <input onClick=<%=baseNS%>nachK() type="button" value=">>" name="button4">
              <input maxlength="7" size="7" name="K">
            </td>
          </tr>
        </table>
      </FORM>
    </TD>
  </TR>
</TABLE>
-->
