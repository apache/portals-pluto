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

<%@ page import="org.apache.pluto.driver.impl.services.PortletURLImpl,
                 org.apache.pluto.driver.impl.services.PortletURLRenderImpl,
                 org.apache.pluto.PortletWindow,
                 org.apache.pluto.driver.AttributeKeys,
                 javax.portlet.WindowState,
                 javax.portlet.PortletMode"%>
<%@ taglib uri="/tags/pluto-driver" prefix="kuiper" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>

<tiles:importAttribute
    name="portlet"
    scope="page"/>

<%
   // We should make driver tags for these, but for now,
   // since we're just the driver, let's take a shortcut.
    PortletWindow window = (PortletWindow)
        pageContext.findAttribute("portlet");

    PortletURLImpl min = new PortletURLRenderImpl(window, request);
    min.setWindowState(WindowState.MINIMIZED);

    PortletURLImpl max = new PortletURLRenderImpl(window, request);
    max.setWindowState(WindowState.MAXIMIZED);

    PortletURLImpl nor = new PortletURLRenderImpl(window, request);
    nor.setWindowState(WindowState.NORMAL);

    PortletURLImpl vw = new PortletURLRenderImpl(window, request);
    vw.setPortletMode(PortletMode.VIEW);

    PortletURLImpl ed = new PortletURLRenderImpl(window, request);
    ed.setPortletMode(PortletMode.EDIT);

    PortletURLImpl hp = new PortletURLRenderImpl(window, request);
    hp.setPortletMode(PortletMode.HELP);

%>
<tiles:importAttribute name="portlet"/>
<TABLE class="portlet-skin" border="2">
<TR><TH>Title Here (Eventually)</TH>
    <TD align="right">
        <html:link href="<%=min.toString()%>">MIN</html:link>|
        <html:link href="<%=max.toString()%>">MAX</html:link>|
        <html:link href="<%=nor.toString()%>">NOR</html:link>|
        <html:link href="<%=vw.toString()%>">VIEW</html:link>|
        <html:link href="<%=ed.toString()%>">EDIT</html:link>|
        <html:link href="<%=hp.toString()%>">HELP</html:link>|
        </TD></TR>
<TR><TD class="portlet-content" colspan="2">
    <kuiper:render name="portlet"/>
    </TD></TR>
</TABLE>
