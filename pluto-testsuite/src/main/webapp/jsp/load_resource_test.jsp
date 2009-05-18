<%--
Licensed to the Apache Software Foundation (ASF) under one or more
contributor license agreements.  See the NOTICE file distributed with
this work for additional information regarding copyright ownership.
The ASF licenses this file to You under the Apache License, Version 2.0
(the "License"); you may not use this file except in compliance with
the License.  You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed  under the  License is distributed on an "AS IS" BASIS,
WITHOUT  WARRANTIES OR CONDITIONS  OF ANY KIND, either  express  or
implied.

See the License for the specific language governing permissions and
limitations under the License.
--%>
<%@taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<portlet:defineObjects />
<TABLE style="font-size: -1">
<TR><TH colspan="2" style="background-color:blue;color:white;">MANUAL TEST</TH></TR>
<TR><TH></TH>
    <TH><c:out value="${test.config.name}" /></TH></TR>
<TR><TD colspan="2">
		Output from this test will be loaded in a separate window using the
		generated ResourceURL.  If the window does not open automatically,
		<a id="<portlet:namespace />windowlink"
				href="<portlet:resourceURL>
						<portlet:param name='testId' value='<%= ((Integer) renderRequest.getAttribute("testId")).toString() %>' /><portlet:param name='nocache' value='<%= Long.toString(System.currentTimeMillis()) %>' />
					</portlet:resourceURL>" target="_blank">
			Click here to open the new window.
		</a>
	</TD>
</TR>
</TABLE>	
	<script type="text/javascript">
	<!--
	(function() {
		var $ = function(something) {
			return document.getElementById(something);
		}
		var link = $('<portlet:namespace />windowlink'); 
		var resourceURL = link.href;
		link.onclick = function() {
			window.open(resourceURL, '_blank', 'scrollbars=yes,resizable=yes,width=400,height=300');
			return false;
		}
		link.onclick();
<%--	
	 Originally, I was going to use Ajax to load the resource URL, but I found that
	 window.open is a little cleaner; keeping this around just in case though
	
		
		
		var getXHR = function() {
			try { return new XMLHttpRequest(); } catch (e) {}
			try{ return new ActiveXObject("MSXML3.XMLHTTP") }catch(e){}
	        try{ return new ActiveXObject("MSXML2.XMLHTTP.3.0") }catch(e){}
	        try{ return new ActiveXObject("Msxml2.XMLHTTP") }catch(e){}
	        try{ return new ActiveXObject("Microsoft.XMLHTTP") }catch(e){}
	        throw new Error("Could not find an XMLHttpRequest alternative.") 
		}
	
		var xhr = getXHR();
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200) {
				$('<portlet:namespace />contentArea').innerHTML = xhr.responseText;
			} else if (xhr.readyState == 4) {
				var win = window.open('', '_blank', 'scrollbars=yes,resizable=yes,width=400,height=300');
				win.document.write(xhr.responseText);
				win.document.close();
			}
		};
		
		xhr.open("get", resourceURL, true);
		xhr.send();
	--%>
	})(); 
	//-->
	</script>

<%@ include file="navigation.inc" %>	