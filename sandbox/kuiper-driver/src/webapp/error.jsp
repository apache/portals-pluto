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

<%@ taglib uri="/tags/struts-tiles" prefix="tiles"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>

<tiles:insert definition="main" flush="true">
    <tiles:put name="page-title">
        <bean:message key="title.error"/>
    </tiles:put>
    <tiles:put name="page-layout" value="two-column-layout"/>
    <tiles:put name="page-content" value="/WEB-INF/fragments/error.jsp"/>
</tiles:insert>
