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
<jsp:useBean id="portletInfo" type="org.apache.pluto.portalImpl.aggregation.PortletFragment.PortletInfo" scope="request" />
<table border='1' cellpadding='1' cellspacing='1' width='100%' height='90%'>
	<tr>
		<td bgcolor='#DDDDDD'>
			<table border='0' cellpadding='0' cellspacing='0' width='100%' height='10px'>
				<tr>
					<td>
						<I><b><%= portletInfo.getTitle() %></b></I>
					</td>
					<td align='right'>
						<font size='-3'>
							<%
				            java.util.List modeList = portletInfo.getAvailablePortletModes();
				            java.util.Collections.sort(modeList);
				            for (java.util.Iterator iter = modeList.iterator(); iter.hasNext();) {
								org.apache.pluto.portalImpl.aggregation.PortletFragment.PortletModeInfo modeInfo = (org.apache.pluto.portalImpl.aggregation.PortletFragment.PortletModeInfo) iter.next();
								if (!modeInfo.isCurrent()) {
									%>
									<a href="<%=modeInfo.getUrl() %>">
									<%
								}

								out.print(modeInfo.getName());

								if (!modeInfo.isCurrent()) {
									%>
									</a>&nbsp;
									<%
								}
							}
							%>
							<%
							java.util.List windowStateList = portletInfo.getAvailablePortletWindowStates();
							java.util.Collections.sort(windowStateList);

							if (modeList.size() > 0 && windowStateList.size() > 0) {
							%>
								&nbsp;|&nbsp;
							<%
							}
							for (java.util.Iterator iter = windowStateList.iterator(); iter.hasNext();) {
								org.apache.pluto.portalImpl.aggregation.PortletFragment.PortletWindowStateInfo stateInfo = (org.apache.pluto.portalImpl.aggregation.PortletFragment.PortletWindowStateInfo) iter.next();
								if (!stateInfo.isCurrent()) {
									%>
									<a href="<%=stateInfo.getUrl()%>">
									<%
								}
								out.println(stateInfo.getLabel());
								if (!stateInfo.isCurrent()) {
									%>
									</a>&nbsp;
									<%
								}
							}
							%>
						</font>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td>


