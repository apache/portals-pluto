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
<B>Testing PortletRequest...</B><BR>
getParameter(), getParameterValues() and getParameterMap()...
<%
    boolean allOk = true;
    String parameter = (String)renderRequest.getParameter("testName");
    if (parameter!=null)
         { out.print("#1 passed..."); }
    else { out.print("#1 failed..."); allOk = false; }

    String[] parameters = renderRequest.getParameterValues("testName2");
    if ((parameters==null) || (parameters.length!=2))
         { out.print("#2 failed..."); allOk = false; }
    else if ((parameters[0].equals("testValue1")) && (parameters[1].equals("testValue2")))
         { out.print("#2 passed..."); }
    else { out.print("#2 failed..."); allOk = false; }

    boolean partialTestCase = true;
    Map parameterMap = renderRequest.getParameterMap();
    String[] parameter1 = (String[])parameterMap.get("testName");
    if ((parameter1==null) || (parameter1.length!=1) || (!parameter1[0].equals("testValue")))
        partialTestCase = false;
    String[] parameters2 = (String[])parameterMap.get("testName2");
    if ((parameters2==null) || (parameters2.length!=2)) partialTestCase = false;
    else {
        if (!parameters2[0].equals("testValue1")) partialTestCase = false;
        if (!parameters2[1].equals("testValue2")) partialTestCase = false;
    }
    if (partialTestCase)
         { out.print("#3 passed..."); }
    else { out.print("#3 failed..."); allOk = false; }

    if (allOk) { out.print("<b>all passed</b>."); }
    else { out.print("<b><font color=red>failed</font></b>."); }
%>
<BR>
getParameterNames()...
<%
    allOk = true;
    int nr = 1;
    Enumeration parametersEnum = renderRequest.getParameterNames();
    while (parametersEnum.hasMoreElements())
    {
        String name = (String)parametersEnum.nextElement();
        String param = (String)renderRequest.getParameter(name);
        if (param!=null)
             { out.print("#"+nr+" passed..."); }
        else { out.print("#"+nr+" failed..."); allOk = false; }
        nr++;
    }
    if (allOk) { out.print("<b>all passed</b>."); }
    else { out.print("<b><font color=red>failed</font></b>."); }
%>
<BR>
<BR>
<B>Testing PortletSession...</B><BR>
trying to get attributes(PRIVATE_SCOPE) from last request...
<%
    PortletSession portletSession = renderRequest.getPortletSession();
    allOk = true;
    String attribute = (String)portletSession.getAttribute("testName1", PortletSession.PORTLET_SCOPE);
    if ("testValue1".equals(attribute))
         { out.print("#1 passed..."); }
    else { out.print("#1 failed..."); allOk = false; }
    attribute = (String)portletSession.getAttribute("testName2", PortletSession.PORTLET_SCOPE);
    if ("testValue2".equals(attribute))
         { out.print("#2 passed..."); }
    else { out.print("#2 failed..."); allOk = false; }
    if (allOk) { out.print("<b>all passed</b>."); }
    else { out.print("<b><font color=red>failed</font></b>."); }
%>
<BR>
<BR>
<B>Testing Portal Context...</B><BR>
trying to verify the PortalContext<BR>
<%
    PortalContext portalContext = renderRequest.getPortalContext();
    allOk = true;
    String info = portalContext.getPortalInfo();
    out.print("PortalInfo = "+info);
%>
<BR>
<%
    if ("Pluto/1.0".equals(info))
         { out.print("PortalInfo test passed..."); }
    else { out.print("PortalInfo failed..."); allOk = false; }
%>
<BR>
<BR>
supported Portlet Modes by the Portal:<BR>
<%
    Enumeration modes = portalContext.getSupportedPortletModes();
    if ( modes == null)
    	{ allOk = false; }
    else
	    { while (modes.hasMoreElements())
	  		out.print("mode = "+modes.nextElement()+";  "); }
%>
<BR>
<BR>
supported Window States by the Portal:<BR>
<%
    Enumeration states = portalContext.getSupportedWindowStates();
    if ( states == null)
    	{ allOk = false; }
    else
    	{ while (states.hasMoreElements())
	  		out.print("states = "+states.nextElement()+";  "); }
%>
<BR>
<%
    if (allOk) { out.print("<b>   ...all passed</b>."); }
    else { out.print("<b><font color=red>   failed</font></b>."); }
%>
<BR>
<%
PortletURL url = renderResponse.createRenderURL();
url.setParameter("jspName","test3.jsp");
%>
<FORM METHOD="POST" ACTION="<%=url.toString()%>">
<INPUT value="Next >>" TYPE="submit">
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
