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
<B>Testing PortletPreferences...</B><BR>
<BR>
All preference keys known to this entity:<BR>
<%
    PortletPreferences preferences = renderRequest.getPreferences();
    Enumeration names = preferences.getNames();
    out.print("<ul>");	
    while (names.hasMoreElements())
    {
        String name = (String)names.nextElement();
	out.print("<li>");
	out.print(name);
	out.print("<ul>");
	String[] values = preferences.getValues(name, new String[]{"no Values"});
	if (values == null)
    {
        out.print("<li>");
        out.print("null");
        out.print("</li>");
    }
	else
    {
        for(int i=0; i < values.length; i++) {
                 out.print("<li>");
                 out.print(values[i]);
                 out.print("</li>");
        }
    }
        out.print("</ul></li>");
    }
    out.print("</ul>");
	
	
%><BR><BR>
getValue(), setValue(), try to set value null:<BR>
<%
    boolean allOk = true;
    String attribute = preferences.getValue("TEST_KEY_1","noValue");
    if (attribute=="noValue")
         { out.print("#1 passed..."); } 
    else { out.print("#1 failed..."); allOk = false; }

    preferences.setValue("TEST_KEY_1", "testValue");

    attribute = preferences.getValue("TEST_KEY_1","noValue");
    if (attribute.equals("testValue"))
         { out.print("#2 passed..."); } 
    else { out.print("#2 failed..."); allOk = false; }
    preferences.setValue("TEST_KEY_1", null);
    attribute = preferences.getValue("TEST_KEY_1","noValue");
    if (attribute==null)
         { out.print("#3 passed..."); } 
    else { out.print("#3 failed..."); allOk = false; }

    if (allOk) { out.print("<b>all passed</b>."); }
    else { out.print("<b><font color=red>failed</font></b>."); }
%>
<BR>
<BR>
getValues(), getValue() returns the first value,<BR>
setValues(), try to set values with null:<BR>
<%
    allOk = true;
    String defValues[] = {"no weekday","no weekend"};
    String attributes[] = preferences.getValues("TEST_KEY_2",defValues);
    if (attributes.equals(defValues))
         { out.print("#1 passed..."); } 
    else { out.print("#1 failed..."); allOk = false; }

    String days[] = {"monday","tuesday","wednesday","thursday","friday","saturday","sunday"};
    preferences.setValues("TEST_KEY_2", days);
    attribute = preferences.getValue("TEST_KEY_2","noValue");
    if (attribute.equals(days[0]))
         { out.print("#2 passed..."); } 
    else { out.print("#2 failed..."); allOk = false; }
%>
<BR>
<%
    attributes = preferences.getValues("TEST_KEY_2",defValues);
	boolean ok = true;
    for (int i=0;i<attributes.length;i++)
    {
		if (!attributes[i].equals(days[i]))
             ok = false;
    }
    if (ok)
         { out.print("#3 passed..."); } 
    else { out.print("#3 failed..."); allOk = false; }

    preferences.setValues("TEST_KEY_2", new String[]{null});
    attribute = preferences.getValue("TEST_KEY_2","noValue");
    if (attribute==null)
         { out.print("#4 passed..."); } 
    else { out.print("#4 failed..."); allOk = false; }

    if (allOk) { out.print("<b>all passed</b>."); }
    else { out.print("<b><font color=red>failed</font></b>."); }
%>
<BR>
<BR>
Testing getMap():<BR>
<%
    allOk = true;
    Map map = preferences.getMap();
    
    names = preferences.getNames();
    while (names.hasMoreElements())
    {
        String name = (String)names.nextElement();
        String[] values = preferences.getValues(name, new String[]{"no Values"});
        if (!map.containsKey(name))
                allOk = false;
        else if (values == null)
        {
            if ((String[])map.get(name) != null)
                     allOk = false;
        }
        else
        {
            String[] mapValues = (String[])map.get(name);

            if ( mapValues == null)
                allOk = false;
            else
            {
                for (int i=0; i<values.length; i++)
                {
                    if (values[i] == null)
                    {
						if (mapValues[i] != null)
							allOk = false;
                    }						
                    else
                    {
                        if (mapValues[i] == null)
							allOk = false;
                        else if (!mapValues[i].equals(values[i]))
                            allOk = false;
                    }
                }
            }
        }
    }


    
    if (allOk) { out.print("<b>passed</b>."); }
    else { out.print("<b><font color=red>failed</font></b>."); }
%>
<BR>
<BR>
Testing reset():<BR>
<%
    allOk = true;
    preferences.setValue("TEST_KEY_3", "Hello");
    if (!preferences.getValue("TEST_KEY_3", "Default").equals("Hello"))
        allOk = false;

    preferences.reset("TEST_KEY_3");

    if (!preferences.getValue("TEST_KEY_3", "Default").equals("Default"))
        allOk = false;

    if (allOk) { out.print("<b>passed</b>."); }
    else { out.print("<b><font color=red>failed</font></b>."); }
%>
<BR>
<BR>
Testing store() (only allowed with Portlet Actions)...<BR>
<%
PortletURL url1 = renderResponse.createActionURL();
url1.setParameter("checkPreferences","storeAndReset");
url1.setParameter("jspNameTransfer","test6.jsp");
%>
<FORM METHOD="POST" ACTION="<%=url1.toString()%>">
<INPUT value="Next >>" TYPE="submit">
</FORM>
<BR>
<BR>
<%
PortletURL url = renderResponse.createRenderURL();
url.setParameter("jspName","test7.jsp");
%>
<FORM METHOD="POST" ACTION="<%=url.toString()%>">
<INPUT value="Skip Next -->>" TYPE="submit">
</FORM>
</FONT>

