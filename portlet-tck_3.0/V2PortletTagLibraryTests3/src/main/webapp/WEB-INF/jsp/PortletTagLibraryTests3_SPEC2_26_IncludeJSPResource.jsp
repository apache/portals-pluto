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

<%-- 
  - Author(s): ahmed
  --%>
<%@ page session="false" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0"  prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="java.io.StringWriter" %>
<%@ page import="javax.portlet.PortletRequest" %>
<%@ page import="javax.portlet.PortletResponse" %>
<%@ page import="javax.portlet.PortletConfig" %>
<%@ page import="javax.portlet.PortletURL" %>
<%@ page import="javax.portlet.tck.beans.JSR286SpecTestCaseDetails" %>
<%@ page import="javax.portlet.tck.beans.TestResult" %>
<%@ page import="javax.portlet.tck.beans.TestSetupLink" %>

<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_DEFINEOBJECTSRESOURCE1" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_DEFINEOBJECTSRESOURCE2" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_DEFINEOBJECTSRESOURCE3" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_DEFINEOBJECTSRESOURCE4" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_DEFINEOBJECTSRESOURCE5" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_DEFINEOBJECTSRESOURCE6" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_DEFINEOBJECTSRESOURCE7" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_DEFINEOBJECTSRESOURCE8" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_DEFINEOBJECTSRESOURCE9" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_DEFINEOBJECTSRESOURCE10" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_DEFINEOBJECTSRESOURCE11" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_DEFINEOBJECTSRESOURCE12" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_DEFINEOBJECTSRESOURCE13" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL1" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL2" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL3" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL4" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL5" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL6" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL7" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL8" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL9" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL10" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL11" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL12" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL13" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL14" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL15" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL17" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL18" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL19" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL20" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL21" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL23" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL27" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL28" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL1" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL2" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL3" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL4" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL5" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL6" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL7" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL8" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL9" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL10" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL11" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL12" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL13" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL14" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL15" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL17" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL18" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL19" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL20" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL21" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL23" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL1" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL4" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL6" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL7" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL8" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL9" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL11" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMACTION1" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMACTION2" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMACTION3" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMACTION4" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMACTION5" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMACTION6" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMRENDER1" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMRENDER2" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMRENDER3" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMRENDER4" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMRENDER5" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMRENDER6" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMRESOURCE4" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYACTION1" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYACTION2" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYACTION3" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYACTION4" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYACTION5" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYACTION6" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYRENDER1" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYRENDER2" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYRENDER3" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYRENDER4" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYRENDER5" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYRENDER6" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYRESOURCE1" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYRESOURCE2" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYRESOURCE3" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYRESOURCE4" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYRESOURCE5" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYRESOURCE6" %>
<%@ page import="static javax.portlet.tck.constants.Constants.THREADID_ATTR" %>

<portlet:defineObjects/>

<script type="text/javascript" id="getResourceCall">
  function getResource(testCase, URL) {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange=function() {
      if (xhr.readyState==4 && xhr.status==200) {
        document.getElementById(testCase).innerHTML = xhr.responseText;
      }
    };
    xhr.open("GET",URL,true);
    xhr.send();
  }
</script>
<%

      PortletRequest portletReq = (PortletRequest) request.getAttribute("javax.portlet.request");
      PortletResponse portletResp = (PortletResponse) request.getAttribute("javax.portlet.response");
      long svtTid = Thread.currentThread().getId();
      long reqTid = (Long) portletReq.getAttribute(THREADID_ATTR);

      StringWriter writer = new StringWriter();

      JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();

      // Create result objects for the tests

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_defineObjectsResource1 */
      /* Details: "When included in the Resource phase, the defineObjects     */
      /* tag defines the variable RenderRequest renderRequest to be null or   */
      /* undefined"                                                           */
      TestResult tr0 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_DEFINEOBJECTSRESOURCE1);
      try{
        if(renderRequest.equals(null)){
          tr0.setTcSuccess(true);
        }
      }catch(NullPointerException e){
        tr0.appendTcDetail(e.getMessage());
        tr0.setTcSuccess(true);
      }
      tr0.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_defineObjectsResource2 */
      /* Details: "When included in the Resource phase, the defineObjects     */
      /* tag defines the variable ResourceRequest resourceRequest to the      */
      /* corresponding object"                                                */
      TestResult tr1 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_DEFINEOBJECTSRESOURCE2);
      if(resourceRequest.equals(portletReq)){
        tr1.setTcSuccess(true);
      }
      tr1.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_defineObjectsResource3 */
      /* Details: "When included in the Resource phase, the defineObjects     */
      /* tag defines the variable ActionRequest actionRequest to be null or   */
      /* undefined"                                                           */
      TestResult tr2 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_DEFINEOBJECTSRESOURCE3);
      try{
        if(actionRequest.equals(null)){
          tr2.setTcSuccess(true);
        }
      }catch(NullPointerException e){
        tr2.appendTcDetail(e.getMessage());
        tr2.setTcSuccess(true);
      }
      tr2.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_defineObjectsResource4 */
      /* Details: "When included in the Resource phase, the defineObjects     */
      /* tag defines the variable EventRequest eventRequest to be null or     */
      /* undefined"                                                           */
      TestResult tr3 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_DEFINEOBJECTSRESOURCE4);
      try{
        if(eventRequest.equals(null)){
          tr3.setTcSuccess(true);
        }
      }catch(NullPointerException e){
        tr3.appendTcDetail(e.getMessage());
        tr3.setTcSuccess(true);
      }
      tr3.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_defineObjectsResource5 */
      /* Details: "When included in the Resource phase, the defineObjects     */
      /* tag defines the variable RenderResponse renderResponse to be null    */
      /* or undefined"                                                        */
      TestResult tr4 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_DEFINEOBJECTSRESOURCE5);
      try{
        if(renderResponse.equals(null)){
          tr4.setTcSuccess(true);
        }
      }catch(NullPointerException e){
        tr4.appendTcDetail(e.getMessage());
        tr4.setTcSuccess(true);
      }
      tr4.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_defineObjectsResource6 */
      /* Details: "When included in the Resource phase, the defineObjects     */
      /* tag defines the variable ResourceResponse resourceResponse to the    */
      /* corresponding object"                                                */
      TestResult tr5 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_DEFINEOBJECTSRESOURCE6);
      if(resourceResponse.equals(portletResp)){
        tr5.setTcSuccess(true);
      }
      tr5.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_defineObjectsResource7 */
      /* Details: "When included in the Resource phase, the defineObjects     */
      /* tag defines the variable ActionResponse actionResponse to be null    */
      /* or undefined"                                                        */
      TestResult tr6 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_DEFINEOBJECTSRESOURCE7);
      try{
        if(actionResponse.equals(null)){
          tr6.setTcSuccess(true);
        }
      }catch(NullPointerException e){
        tr6.appendTcDetail(e.getMessage());
        tr6.setTcSuccess(true);
      }
      tr6.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_defineObjectsResource8 */
      /* Details: "When included in the Resource phase, the defineObjects     */
      /* tag defines the variable EventResponse eventResponse to be null or   */
      /* undefined"                                                           */
      TestResult tr7 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_DEFINEOBJECTSRESOURCE8);
      try{
        if(eventResponse.equals(null)){
          tr7.setTcSuccess(true);
        }
      }catch(NullPointerException e){
        tr7.appendTcDetail(e.getMessage());
        tr7.setTcSuccess(true);
      }
      tr7.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_defineObjectsResource9 */
      /* Details: "When included in the Resource phase, the defineObjects     */
      /* tag defines the variable PortletConfig portletConfig"                */
      TestResult tr8 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_DEFINEOBJECTSRESOURCE9);
      if(portletConfig!=null && portletConfig.equals((PortletConfig) request.getAttribute("javax.portlet.config"))){
        tr8.setTcSuccess(true);
      }
      tr8.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_defineObjectsResource10 */
      /* Details: "When included in the Resource phase, the defineObjects     */
      /* tag defines the variable PortletSession portletSession, providing    */
      /* access to the portletSession, does not create a new session, only    */
      /* returns an existing session or null if no session exists."           */
      TestResult tr9 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_DEFINEOBJECTSRESOURCE10);
      if(portletSession != null){
        tr9.setTcSuccess(true);
      }
      tr9.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_defineObjectsResource11 */
      /* Details: "When included in the Resource phase, the defineObjects     */
      /* tag defines the variable Map&lt;String, Object&gt;                   */
      /* portletSessionScope, providing access to the portletSession          */
      /* attributes as a Map equivalent to the                                */
      /* PortletSession.getAttributeMap() call, does not create a new         */
      /* session, only returns an existing session. If no session             */
      /* attributes exist this method returns an empty Map."                  */
      TestResult tr10 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_DEFINEOBJECTSRESOURCE11);
      if(portletSessionScope.isEmpty() || portletSessionScope.equals(portletReq.getPortletSession().getAttributeMap())){
        tr10.setTcSuccess(true);
      }
      tr10.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_defineObjectsResource12 */
      /* Details: "When included in the Resource phase, the defineObjects     */
      /* tag defines the variable PortletPreferences portletPreferences,      */
      /* providing access to the portlet preferences."                        */
      TestResult tr11 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_DEFINEOBJECTSRESOURCE12);
      if(portletPreferences.equals(portletReq.getPreferences())){
        tr11.setTcSuccess(true);
      }
      tr11.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_defineObjectsResource13 */
      /* Details: "When included in the Resource phase, the defineObjects     */
      /* tag defines the variable Map&lt;String, String[]&gt;                 */
      /* portletPreferencesValues, providing access to the portlet            */
      /* preferences as a Map, equivalent to the                              */
      /* PortletPreferences.getMap() call. If no portlet preferences exist,   */
      /* the Map is empty."                                                   */
      TestResult tr12 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_DEFINEOBJECTSRESOURCE13);
      if(portletPreferencesValues.isEmpty() || portletPreferencesValues.equals(portletReq.getPreferences().getMap())){
        tr12.setTcSuccess(true);
      }
      tr12.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL1 */
      /* Details: "The portlet actionURL tag creates a URL that must point    */
      /* to the current portlet and must trigger an action request with the   */
      /* supplied parameters"                                                 */
      TestResult tr13 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL1);
      if(resourceRequest.getParameter("tr13")!=null && "true".equals(resourceRequest.getParameter("tr13"))){
        tr13.setTcSuccess(true);
        tr13.writeTo(writer);
      } else {
      %>
      <DIV CLASS="portletTCKTestcase" name="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL1">
        <h4>V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPResource_actionURL1 button (POST):</h4>
        <FORM METHOD="POST" ACTION="<portlet:actionURL/>">
          <INPUT NAME='action' VALUE='V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL1' TYPE="hidden">
          <INPUT VALUE="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL1" ID="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL1-clickme" TYPE="submit">
        </FORM>
      </DIV>
      <% }

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL2 */
      /* Details: "Parameters may be added to the URL by including the        */
      /* param tag between the actionURL start and end tags"                  */
      TestResult tr14 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL2);
      if(resourceRequest.getParameter("tr14")!=null && "true".equals(resourceRequest.getParameter("tr14"))){
        tr14.setTcSuccess(true);
        tr14.writeTo(writer);
      } else {
      %>
      <DIV CLASS="portletTCKTestcase" name="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL2">
        <h4>V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL2 button (POST):</h4>
        <FORM METHOD="POST" ACTION='<portlet:actionURL><portlet:param name="tr14_value" value="true"/></portlet:actionURL>'>
          <INPUT NAME='action' VALUE='V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL2' TYPE="hidden">
          <INPUT VALUE="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL2" ID="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL2-clickme" TYPE="submit">
        </FORM>
      </DIV>
      <% }
      
      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL3 */
      /* Details: "The optional actionURL \"windowState\" attribute can       */
      /* specify the desired window state after the URL is triggered"         */
      TestResult tr15 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL3);
      if(resourceRequest.getParameter("tr15")!=null && "true".equals(resourceRequest.getParameter("tr15"))){
        tr15.setTcSuccess(true);
        tr15.writeTo(writer);
      } else {
      %>
      <DIV CLASS="portletTCKTestcase" name="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL3">
        <h4>V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL3 button (POST):</h4>
        <FORM METHOD="POST" ACTION='<portlet:actionURL windowState="minimized"/>'>
        <INPUT NAME='action' VALUE='V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL3' TYPE="hidden">
          <INPUT VALUE="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL3" ID="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL3-clickme" TYPE="submit">
        </FORM>
      </DIV>
      <% }
      
      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL4 */
      /* Details: "If the \"windowState\" attribute specifies an invalid */
      /* value, a JspException with the PortletException that caused this */
      /* error as root cause is thrown" */
      TestResult tr16 =
          tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL4);
      %>
      <c:catch var ="exceptionTr16">
         <portlet:actionURL windowState="invalid"/>
      </c:catch>
      <c:if test = "${exceptionTr16 != null}">
         <%
         tr16.setTcSuccess(true);
         String exceptionTr16 = ""; 
         exceptionTr16 = exceptionTr16 + pageContext.getAttribute("exceptionTr16");
         tr16.appendTcDetail(exceptionTr16);
         %>
      </c:if>
      <c:if test = "${exceptionTr16 == null}">
         <%
         tr16.appendTcDetail("Test case failed as no Exception is raised while defining windowState parameter as invalid.");
         %>
      </c:if>
      <%
      tr16.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL5 */
      /* Details: "The \"windowState\" attribute is not case sensitive"       */
      TestResult tr17 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL5);
      if(resourceRequest.getParameter("tr17")!=null && "true".equals(resourceRequest.getParameter("tr17"))){
        tr17.setTcSuccess(true);
        tr17.writeTo(writer);
      } else {
      %>
      <DIV CLASS="portletTCKTestcase" name="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL5">
        <h4>V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL5 button (POST):</h4>
        <FORM METHOD="POST" ACTION='<portlet:actionURL windowState="MiNiMiZeD"/>'>
        <INPUT NAME='action' VALUE='V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL5' TYPE="hidden">
          <INPUT VALUE="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL5" ID="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL5-clickme" TYPE="submit">
        </FORM>
      </DIV>
      <% }

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL6 */
      /* Details: "The \"windowState\" attribute is not specified, the        */
      /* current window state is retained when the URL is triggered"          */
      TestResult tr18 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL6);
      if(resourceRequest.getParameter("tr18")!=null && "true".equals(resourceRequest.getParameter("tr18"))){
        tr18.setTcSuccess(true);
        tr18.writeTo(writer);
      } else {
      %>
      <DIV CLASS="portletTCKTestcase" name="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL6">
        <h4>V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL6 button (POST):</h4>
        <FORM METHOD="POST" ACTION='<portlet:actionURL/>'>
        <INPUT NAME='action' VALUE='V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL6' TYPE="hidden">
        <INPUT NAME='windowStateTr18' VALUE='<%=portletReq.getWindowState().toString()%>' TYPE="hidden">
        <INPUT VALUE="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL6" ID="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL6-clickme" TYPE="submit">
        </FORM>
      </DIV>
      <% }

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL7 */
      /* Details: "The optional actionURL \"portletMode\" attribute can       */
      /* specify the desired portlet mode after the URL is triggered"         */
      TestResult tr19 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL7);
      if(resourceRequest.getParameter("tr19")!=null && "true".equals(resourceRequest.getParameter("tr19"))){
        tr19.setTcSuccess(true);
        tr19.writeTo(writer);
      } else {
      %>
      <DIV CLASS="portletTCKTestcase" name="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL7">
        <h4>V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL7 button (POST):</h4>
        <FORM METHOD="POST" ACTION='<portlet:actionURL portletMode="view"/>'>
        <INPUT NAME='action' VALUE='V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL7' TYPE="hidden">
        <INPUT VALUE="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL7" ID="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL7-clickme" TYPE="submit">
        </FORM>
      </DIV>
      <% }
      
      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL8 */
      /* Details: "If the \"portletMode\" attribute specifies an invalid */
      /* value, a JspException with the PortletException that caused this */
      /* error as root cause is thrown" */
      TestResult tr20 =
          tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL8);
      %>
      <c:catch var ="exceptionTr20">
         <portlet:actionURL portletMode="invalid"/>
      </c:catch>
      <c:if test = "${exceptionTr20 != null}">
         <%
         tr20.setTcSuccess(true);
         String exceptionTr20 = ""; 
         exceptionTr20 = exceptionTr20 + pageContext.getAttribute("exceptionTr20");
         tr20.appendTcDetail(exceptionTr20);
         %>
      </c:if>
      <c:if test = "${exceptionTr20 == null}">
         <%
         tr20.appendTcDetail("Test case failed as no Exception is raised while defining portletMode parameter as invalid.");
         %>
      </c:if>
      <%
      tr20.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL9 */
      /* Details: "The \"portletMode\" attribute is not case sensitive"       */
      TestResult tr21 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL9);
      if(resourceRequest.getParameter("tr21")!=null && "true".equals(resourceRequest.getParameter("tr21"))){
        tr21.setTcSuccess(true);
        tr21.writeTo(writer);
      } else {
      %>
      <DIV CLASS="portletTCKTestcase" name="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL9">
        <h4>V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL9 button (POST):</h4>
        <FORM METHOD="POST" ACTION='<portlet:actionURL portletMode="ViEw"/>'>
        <INPUT NAME='action' VALUE='V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL9' TYPE="hidden">
        <INPUT VALUE="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL9" ID="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL9-clickme" TYPE="submit">
        </FORM>
      </DIV>
      <% }

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL10 */
      /* Details: "The \"portletMode\" attribute is not specified, the        */
      /* current portlet mode is retained when the URL is triggered"          */
      TestResult tr22 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL10);
      if(resourceRequest.getParameter("tr22")!=null && "true".equals(resourceRequest.getParameter("tr22"))){
        tr22.setTcSuccess(true);
        tr22.writeTo(writer);
      } else {
      %>
      <DIV CLASS="portletTCKTestcase" name="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL10">
        <h4>V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL10 button (POST):</h4>
        <FORM METHOD="POST" ACTION='<portlet:actionURL/>'>
        <INPUT NAME='action' VALUE='V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL10' TYPE="hidden">
        <INPUT NAME='portletModeTr22' VALUE='<%=portletReq.getPortletMode().toString()%>' TYPE="hidden">
        <INPUT VALUE="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL10" ID="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL10-clickme" TYPE="submit">
        </FORM>
      </DIV>
      <% }

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL11 */
      /* Details: "The optional actionURL \"var\" attribute can specify a     */
      /* scoped variable for exporting the action URL"                        */
      TestResult tr23 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL11);
      if(resourceRequest.getParameter("tr23")!=null && "true".equals(resourceRequest.getParameter("tr23"))){
        tr23.setTcSuccess(true);
        tr23.writeTo(writer);
      } else {
      %>
      <portlet:actionURL var="actionURLTr23"/>
      <DIV CLASS="portletTCKTestcase" name="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL11">
        <h4>V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL11 button (POST):</h4>
        <FORM METHOD="POST" ACTION='${actionURLTr23}'>
        <INPUT NAME='action' VALUE='V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL11' TYPE="hidden">
        <INPUT VALUE="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL11" ID="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL11-clickme" TYPE="submit">
        </FORM>
      </DIV>
      <% }

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL12 */
      /* Details: "If the actionURL var attribute is specified, the URL   */
      /* is not written to the JspWriter"                                     */
      TestResult tr24 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL12);
      if(resourceRequest.getParameter("tr24")!=null && "true".equals(resourceRequest.getParameter("tr24"))){
        tr24.setTcSuccess(true);
        tr24.writeTo(writer);
      } else {
      %>
      <DIV CLASS="portletTCKTestcase" name="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL12">
        <h4>V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL12 button (POST):</h4>
        <FORM METHOD="POST" ACTION='<portlet:actionURL/>'>
        <INPUT NAME='action' VALUE='V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL12' TYPE="hidden">
        <INPUT NAME='actionURLTr24' VALUE='<portlet:actionURL var="actionURLTr24"/>' TYPE="hidden">
        <INPUT VALUE="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL12" ID="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL12-clickme" TYPE="submit">
        </FORM>
      </DIV>
      <% }

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL13 */
      /* Details: "If the actionURL \"var\" attribute is not specified, the   */
      /* URL is written to the JspWriter"                                     */
      TestResult tr25 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL13);
      if(resourceRequest.getParameter("tr25")!=null && "true".equals(resourceRequest.getParameter("tr25"))){
        tr25.setTcSuccess(true);
        tr25.writeTo(writer);
      } else {
      %>
      <DIV CLASS="portletTCKTestcase" name="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL13">
        <h4>V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL13 button (POST):</h4>
        <FORM METHOD="POST" ACTION='<portlet:actionURL/>'>
        <INPUT NAME='action' VALUE='V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL13' TYPE="hidden">
        <INPUT NAME='actionURLTr25' VALUE='<portlet:actionURL/>' TYPE="hidden">
        <INPUT VALUE="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL13" ID="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL13-clickme" TYPE="submit">
        </FORM>
      </DIV>
      <% }

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL14 */
      /* Details: "If the optional actionURL \"secure\" attribute is set to   */
      /* true, the resulting URL should require a secure connection"          */
      TestResult tr26 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL14);
      tr26.setTcSuccess(true);
      tr26.appendTcDetail("Cannot be tested as it is ignored by portlet container.");
      tr26.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL15 */
      /* Details: "If the optional actionURL \"secure\" attribute is set to   */
      /* false, the resulting URL does not need to require a secure           */
      /* connection"                                                          */
      TestResult tr27 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL15);
      tr27.setTcSuccess(true);
      tr27.appendTcDetail("Cannot be tested as it is ignored by portlet container.");
      tr27.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL17 */
      /* Details: "The \"secure\" attribute is not specified, the security    */
      /* setting is retained"                                                 */
      TestResult tr28 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL17);
      tr28.setTcSuccess(true);
      tr28.appendTcDetail("Cannot be tested as it is ignored by portlet container.");
      tr28.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL18 */
      /* Details: "If the optional actionURL                                  */
      /* \"copyCurrentRenderParameters\" attribute is set to true, the        */
      /* current private render parameters are attached to the URL"           */
      TestResult tr29 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL18);
      if(resourceRequest.getParameter("renderParamTr29")==null && resourceRequest.getParameter("tr29")==null){
        PortletURL renderURLTr29 = resourceResponse.createRenderURL();
        renderURLTr29.setParameter("renderParamTr29", "true");
        TestSetupLink tr29SetupLink = new TestSetupLink(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL18, renderURLTr29);
        tr29SetupLink.writeTo(writer);
      } else if(resourceRequest.getParameter("tr29")!=null && "true".equals(resourceRequest.getParameter("tr29"))){
        tr29.setTcSuccess(true);
        tr29.writeTo(writer);
      } else {
      %>
      <DIV CLASS='portletTCKTestcase' name='V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL18'>
        <h4>V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL18 button (POST):</h4>
        <FORM METHOD='POST' ACTION='<portlet:actionURL copyCurrentRenderParameters="true"/>'>
        <INPUT NAME='action' VALUE='V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL18' TYPE='hidden'>
        <INPUT VALUE='V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL18' ID='V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL18-clickme' TYPE='submit'>
        </FORM>
      </DIV>
      <% }
      
      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL19 */
      /* Details: "If the optional actionURL                                  */
      /* \"copyCurrentRenderParameters\" attribute is set to true,            */
      /* additional parameters specified with the &lt;portlet:param&gt;       */
      /* element are merged with the render parameters"                       */
      TestResult tr30 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL19);
      if(resourceRequest.getParameter("renderParamTr30")==null && resourceRequest.getParameter("tr30")==null){
        PortletURL renderURLTr30 = resourceResponse.createRenderURL();
        renderURLTr30.setParameter("renderParamTr30", "true");
        TestSetupLink tr30SetupLink = new TestSetupLink(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL19, renderURLTr30);
        tr30SetupLink.writeTo(writer);
      } else if(resourceRequest.getParameter("tr30")!=null && "true".equals(resourceRequest.getParameter("tr30"))){
        tr30.setTcSuccess(true);
        tr30.writeTo(writer);
      } else {
      %>
      <DIV CLASS='portletTCKTestcase' name='V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL19'>
        <h4>V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL19 button (POST):</h4>
        <FORM METHOD='POST' ACTION='<portlet:actionURL copyCurrentRenderParameters="true"><portlet:param name="actionURLTr30" value="true"/></portlet:actionURL>'>
        <INPUT NAME='action' VALUE='V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL19' TYPE='hidden'>
        <INPUT VALUE='V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL19' ID='V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL19-clickme' TYPE='submit'>
        </FORM>
      </DIV>
      <% }

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL20 */
      /* Details: "If the optional actionURL                                  */
      /* \"copyCurrentRenderParameters\" attribute is set to true,            */
      /* additional parameters specified with the &lt;portlet:param&gt;       */
      /* element appear in the values array before the render parameter       */
      /* values if there is a name conflict"                                  */
      TestResult tr31 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL20);
      if(resourceRequest.getParameter("renderParamTr31")==null && resourceRequest.getParameter("tr31")==null){
        PortletURL renderURLTr31 = resourceResponse.createRenderURL();
        renderURLTr31.setParameter("renderParamTr31", "true");
        TestSetupLink tr31SetupLink = new TestSetupLink(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL20, renderURLTr31);
        tr31SetupLink.writeTo(writer);
      } else if(resourceRequest.getParameter("tr31")!=null && "true".equals(resourceRequest.getParameter("tr31"))){
        tr31.setTcSuccess(true);
        tr31.writeTo(writer);
      } else {
      %>
      <DIV CLASS='portletTCKTestcase' name='V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL20'>
        <h4>V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL20 button (POST):</h4>
        <FORM METHOD='POST' ACTION='<portlet:actionURL copyCurrentRenderParameters="true"><portlet:param name="renderParamTr31" value="false"/></portlet:actionURL>'>
        <INPUT NAME='action' VALUE='V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL20' TYPE='hidden'>
        <INPUT VALUE='V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL20' ID='V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL20-clickme' TYPE='submit'>
        </FORM>
      </DIV>
      <% }

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL21 */
      /* Details: "If the optional actionURL                                  */
      /* \"copyCurrentRenderParameters\" attribute is set to false, the       */
      /* current render parameters are not attached to the URL"               */
      TestResult tr32 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL21);
      if(resourceRequest.getParameter("renderParamTr32")==null && resourceRequest.getParameter("tr32")==null){
        PortletURL renderURLTr32 = resourceResponse.createRenderURL();
        renderURLTr32.setParameter("renderParamTr32", "true");
        TestSetupLink tr32SetupLink = new TestSetupLink(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL21, renderURLTr32);
        tr32SetupLink.writeTo(writer);
      } else if(resourceRequest.getParameter("tr32")!=null && "true".equals(resourceRequest.getParameter("tr32"))){
        tr32.setTcSuccess(true);
        tr32.writeTo(writer);
      } else {
      %>
      <DIV CLASS='portletTCKTestcase' name='V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL21'>
        <h4>V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL21 button (POST):</h4>
        <FORM METHOD='POST' ACTION='<portlet:actionURL copyCurrentRenderParameters="false"></portlet:actionURL>'>
        <INPUT NAME='action' VALUE='V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL21' TYPE='hidden'>
        <INPUT VALUE='V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL21' ID='V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL21-clickme' TYPE='submit'>
        </FORM>
      </DIV>
      <% }

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL23 */
      /* Details: "The \"copyCurrentRenderParameters\" attribute is not       */
      /* specified, the security setting is retained"                         */
      TestResult tr34 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL23);
      tr34.setTcSuccess(true);
      tr34.appendTcDetail("Cannot be tested as it is ignored by portlet container.");
      tr34.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL27 */
      /* Details: "If the optional actionURL \"name\" attribute is set, the   */
      /* provided name string is used by GenericPortlet to dispatch the       */
      /* request to the coresponding annotated method"                        */
      TestResult tr37 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL27);
      if(resourceRequest.getParameter("tr37")!=null && "true".equals(resourceRequest.getParameter("tr37"))){
        tr37.setTcSuccess(true);
        tr37.writeTo(writer);
      } else if (resourceRequest.getParameter("tr37_error")!=null) {
        tr37.appendTcDetail(resourceRequest.getParameter("tr37_error"));
        tr37.writeTo(writer);
      } else {
      %>
      <DIV CLASS='portletTCKTestcase' name='V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL27'>
        <h4>V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL27 button (POST):</h4>
        <FORM METHOD='POST' ACTION='<portlet:actionURL name="actionNameTr27"/>'>
        <INPUT NAME='action' VALUE='V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL27' TYPE='hidden'>
        <INPUT VALUE='V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL27' ID='V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL27-clickme' TYPE='submit'>
        </FORM>
      </DIV>
      <% }

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL28 */
      /* Details: "Setting the \"name\" attribute will add a parameter to     */
      /* the action URL with the name of \"javax.portlet.action\""            */
      TestResult tr38 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL28);
      if(resourceRequest.getParameter("tr38")!=null && "true".equals(resourceRequest.getParameter("tr38"))){
        tr38.setTcSuccess(true);
        tr38.writeTo(writer);
      } else {
      %>
      <DIV CLASS='portletTCKTestcase' name='V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL28'>
        <h4>V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL28 button (POST):</h4>
        <FORM METHOD='POST' ACTION='<portlet:actionURL name="actionNameTr28"/>'>
        <INPUT NAME='action' VALUE='V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL28' TYPE='hidden'>
        <INPUT VALUE='V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL28' ID='V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL28-clickme' TYPE='submit'>
        </FORM>
      </DIV>
      <% }

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL1 */
      /* Details: "The portlet renderURL tag creates a URL that must point    */
      /* to the current portlet and must trigger an render request with the   */
      /* supplied parameters"                                                 */
      TestResult tr41 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL1);
      if(resourceRequest.getParameter("tr41")!=null && "true".equals(resourceRequest.getParameter("tr41"))){
        tr41.setTcSuccess(true);
        tr41.writeTo(writer);
      } else {
      %>
      <DIV CLASS="portletTCKTestcase" name="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL1">
        <h4>V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL1 button (POST):</h4>
        <FORM METHOD="POST" ACTION="<portlet:renderURL><portlet:param name="action" value="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL1"/></portlet:renderURL>">
          <INPUT VALUE="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL1" ID="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL1-clickme" TYPE="submit">
        </FORM>
      </DIV>
      <% }

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL2 */
      /* Details: "Parameters may be added to the URL by including the        */
      /* param tag between the renderURL start and end tags"                  */
      TestResult tr42 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL2);
      if(resourceRequest.getParameter("tr42")!=null && "true".equals(resourceRequest.getParameter("tr42"))){
        tr42.setTcSuccess(true);
        tr42.writeTo(writer);
      } else {
      %>
      <DIV CLASS="portletTCKTestcase" name="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL2">
        <h4>V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL2 button (POST):</h4>
        <FORM METHOD="POST" ACTION="<portlet:renderURL><portlet:param name="action" value="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL2"/></portlet:renderURL>">
          <INPUT VALUE="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL2" ID="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL2-clickme" TYPE="submit">
        </FORM>
      </DIV>
      <% }

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL3 */
      /* Details: "The optional renderURL \"windowState\" attribute can       */
      /* specify the desired window state after the URL is triggered"         */
      TestResult tr43 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL3);
      if(resourceRequest.getParameter("tr43")!=null && "true".equals(resourceRequest.getParameter("tr43"))){
        tr43.setTcSuccess(true);
        tr43.writeTo(writer);
      } else {
      %>
      <DIV CLASS="portletTCKTestcase" name="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL3">
        <h4>V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL3 button (POST):</h4>
        <FORM METHOD="POST" ACTION="<portlet:renderURL windowState="minimized"><portlet:param name="action" value="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL3"/></portlet:renderURL>">
          <INPUT VALUE="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL3" ID="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL3-clickme" TYPE="submit">
        </FORM>
      </DIV>
      <% }
      
      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL4 */
      /* Details: "If the \"windowState\" attribute specifies an invalid */
      /* value, a JspException with the PortletException that caused this */
      /* error as root cause is thrown" */
      TestResult tr44 =
          tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL4);
      %>
      <c:catch var ="exceptionTr44">
         <portlet:renderURL windowState="invalid"/>
      </c:catch>
      <c:if test = "${exceptionTr44 != null}">
         <%
         tr44.setTcSuccess(true);
         String exceptionTr44 = ""; 
         exceptionTr44 = exceptionTr44 + pageContext.getAttribute("exceptionTr44");
         tr44.appendTcDetail(exceptionTr44);
         %>
      </c:if>
      <c:if test = "${exceptionTr44 == null}">
         <%
         tr44.appendTcDetail("Test case failed as no Exception is raised while defining windowState parameter as invalid.");
         %>
      </c:if>
      <%
      tr44.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL5 */
      /* Details: "The \"windowState\" attribute is not case sensitive"       */
      TestResult tr45 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL5);
      if(resourceRequest.getParameter("tr45")!=null && "true".equals(resourceRequest.getParameter("tr45"))){
        tr45.setTcSuccess(true);
        tr45.writeTo(writer);
      } else {
      %>
      <DIV CLASS="portletTCKTestcase" name="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL5">
        <h4>V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL5 button (POST):</h4>
        <FORM METHOD="POST" ACTION="<portlet:renderURL windowState="mInImIzEd"><portlet:param name="action" value="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL5"/></portlet:renderURL>">
          <INPUT VALUE="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL5" ID="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL5-clickme" TYPE="submit">
        </FORM>
      </DIV>
      <% }

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL6 */
      /* Details: "The \"windowState\" attribute is not specified, the        */
      /* current window state is retained when the URL is triggered"          */
      TestResult tr46 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL6);
      if(resourceRequest.getParameter("tr46")!=null && "true".equals(resourceRequest.getParameter("tr46"))){
        tr46.setTcSuccess(true);
        tr46.writeTo(writer);
      } else {
      %>
      <DIV CLASS="portletTCKTestcase" name="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL6">
        <h4>V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL6 button (POST):</h4>
        <FORM METHOD="POST" ACTION='<portlet:renderURL>
                <portlet:param name="action" value="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL6"/>
                <portlet:param name="windowStateTr46" value="<%=portletReq.getWindowState().toString()%>"/>
              </portlet:renderURL>'>
          <INPUT VALUE="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL6" ID="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL6-clickme" TYPE="submit">
        </FORM>
      </DIV>
      <% }

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL7 */
      /* Details: "The optional renderURL \"portletMode\" attribute can       */
      /* specify the desired portlet mode after the URL is triggered"         */
      TestResult tr47 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL7);
      if(resourceRequest.getParameter("tr47")!=null && "true".equals(resourceRequest.getParameter("tr47"))){
        tr47.setTcSuccess(true);
        tr47.writeTo(writer);
      } else {
      %>
      <DIV CLASS="portletTCKTestcase" name="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL7">
        <h4>V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL7 button (POST):</h4>
        <FORM METHOD="POST" ACTION="<portlet:renderURL portletMode="view"><portlet:param name="action" value="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL7"/></portlet:renderURL>">
          <INPUT VALUE="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL7" ID="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL7-clickme" TYPE="submit">
        </FORM>
      </DIV>
      <% }
      
      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL8 */
      /* Details: "If the \"portletMode\" attribute specifies an invalid */
      /* value, a JspException with the PortletException that caused this */
      /* error as root cause is thrown" */
      TestResult tr48 =
          tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL8);
      %>
      <c:catch var ="exceptionTr48">
         <portlet:renderURL portletMode="invalid"/>
      </c:catch>
      <c:if test = "${exceptionTr48 != null}">
         <%
         tr48.setTcSuccess(true);
         String exceptionTr48 = ""; 
         exceptionTr48 = exceptionTr48 + pageContext.getAttribute("exceptionTr48");
         tr48.appendTcDetail(exceptionTr48);
         %>
      </c:if>
      <c:if test = "${exceptionTr48 == null}">
         <%
         tr48.appendTcDetail("Test case failed as no Exception is raised while defining portletMode parameter as invalid.");
         %>
      </c:if>
      <%
      tr48.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL9 */
      /* Details: "The \"portletMode\" attribute is not case sensitive"       */
      TestResult tr49 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL9);
      if(resourceRequest.getParameter("tr49")!=null && "true".equals(resourceRequest.getParameter("tr49"))){
        tr49.setTcSuccess(true);
        tr49.writeTo(writer);
      } else {
      %>
      <DIV CLASS="portletTCKTestcase" name="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL9">
        <h4>V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL9 button (POST):</h4>
        <FORM METHOD="POST" ACTION="<portlet:renderURL portletMode="ViEw"><portlet:param name="action" value="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL9"/></portlet:renderURL>">
          <INPUT VALUE="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL9" ID="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL9-clickme" TYPE="submit">
        </FORM>
      </DIV>
      <% }

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL10 */
      /* Details: "The \"portletMode\" attribute is not specified, the        */
      /* current portlet mode is retained when the URL is triggered"          */
      TestResult tr50 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL10);
      if(resourceRequest.getParameter("tr50")!=null && "true".equals(resourceRequest.getParameter("tr50"))){
        tr50.setTcSuccess(true);
        tr50.writeTo(writer);
      } else {
      %>
      <DIV CLASS="portletTCKTestcase" name="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL10">
        <h4>V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL10 button (POST):</h4>
        <FORM METHOD="POST" ACTION='<portlet:renderURL>
                <portlet:param name="action" value="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL10"/>
                <portlet:param name="portletModeTr50" value="<%=portletReq.getPortletMode().toString()%>"/>
              </portlet:renderURL>'>
          <INPUT VALUE="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL10" ID="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL10-clickme" TYPE="submit">
        </FORM>
      </DIV>
      <% }

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL11 */
      /* Details: "The optional renderURL \"var\" attribute can specify a     */
      /* scoped variable for exporting the action URL"                        */
      TestResult tr51 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL11);
      if(resourceRequest.getParameter("tr51")!=null && "true".equals(resourceRequest.getParameter("tr51"))){
        tr51.setTcSuccess(true);
        tr51.writeTo(writer);
      } else {
      %>
      <portlet:renderURL var="renderURLTr51"><portlet:param name="action" value="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL11"/></portlet:renderURL>
      <DIV CLASS="portletTCKTestcase" name="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL11">
        <h4>V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL11 button (POST):</h4>
        <FORM METHOD="POST" ACTION="${renderURLTr51}">
          <INPUT VALUE="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL11" ID="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL11-clickme" TYPE="submit">
        </FORM>
      </DIV>
      <% }

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL12 */
      /* Details: "If the renderURL \"var\" attribute is specified, the URL   */
      /* is not written to the JspWriter"                                     */
      TestResult tr52 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL12);
      if(resourceRequest.getParameter("tr52")!=null && "true".equals(resourceRequest.getParameter("tr52"))){
        tr52.setTcSuccess(true);
        tr52.writeTo(writer);
      } else {
      %>
      <DIV CLASS="portletTCKTestcase" name="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL12">
        <h4>V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL12 button (POST):</h4>
        <FORM METHOD="POST" ACTION='<portlet:actionURL/>'>
        <INPUT NAME='action' VALUE='V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL12' TYPE="hidden">
        <INPUT NAME='renderURLTr52' VALUE='<portlet:renderURL var="renderURLTr52"/>' TYPE="hidden">
        <INPUT VALUE="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL12" ID="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL12-clickme" TYPE="submit">
        </FORM>
      </DIV>
      <% }

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL13 */
      /* Details: "If the renderURL \"var\" attribute is not specified, the   */
      /* URL is written to the JspWriter"                                     */
      TestResult tr53 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL13);
      if(resourceRequest.getParameter("tr53")!=null && "true".equals(resourceRequest.getParameter("tr53"))){
        tr53.setTcSuccess(true);
        tr53.writeTo(writer);
      } else {
      %>
      <DIV CLASS="portletTCKTestcase" name="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL13">
        <h4>V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL13 button (POST):</h4>
        <FORM METHOD="POST" ACTION='<portlet:actionURL/>'>
        <INPUT NAME='action' VALUE='V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL13' TYPE="hidden">
        <INPUT NAME='renderURLTr53' VALUE='<portlet:renderURL/>' TYPE="hidden">
        <INPUT VALUE="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL13" ID="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL13-clickme" TYPE="submit">
        </FORM>
      </DIV>
      <% }

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL14 */
      /* Details: "If the optional renderURL \"secure\" attribute is set to   */
      /* true, the resulting URL should require a secure connection"          */
      TestResult tr54 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL14);
      tr54.setTcSuccess(true);
      tr54.appendTcDetail("Cannot be tested as it is ignored by portlet container.");
      tr54.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL15 */
      /* Details: "If the optional renderURL \"secure\" attribute is set to   */
      /* false, the resulting URL does not need to require a secure           */
      /* connection"                                                          */
      TestResult tr55 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL15);
      tr55.setTcSuccess(true);
      tr55.appendTcDetail("Cannot be tested as it is ignored by portlet container.");
      tr55.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL17 */
      /* Details: "The \"secure\" attribute is not specified, the security    */
      /* setting is retained"                                                 */
      TestResult tr56 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL17);
      tr56.setTcSuccess(true);
      tr56.appendTcDetail("Cannot be tested as it is ignored by portlet container.");
      tr56.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL18 */
      /* Details: "If the optional renderURL                                  */
      /* \"copyCurrentRenderParameters\" attribute is set to true, the        */
      /* current private render parameters are attached to the URL"           */
      TestResult tr57 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL18);
      if(resourceRequest.getParameter("renderParamTr57")==null && resourceRequest.getParameter("tr57")==null){
        PortletURL renderURLTr57 = resourceResponse.createRenderURL();
        renderURLTr57.setParameter("renderParamTr57", "true");
        TestSetupLink tr57SetupLink = new TestSetupLink(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL18, renderURLTr57);
        tr57SetupLink.writeTo(writer);
      } else if(resourceRequest.getParameter("tr57")!=null && "true".equals(resourceRequest.getParameter("tr57"))){
        tr57.setTcSuccess(true);
        tr57.writeTo(writer);
      } else {
      %>
      <DIV CLASS='portletTCKTestcase' name='V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL18'>
        <h4>V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL18 button (POST):</h4>
        <FORM METHOD='POST' ACTION='<portlet:renderURL copyCurrentRenderParameters="true"><portlet:param name="action" value="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL18"/></portlet:renderURL>'>
        <INPUT VALUE='V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL18' ID='V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL18-clickme' TYPE='submit'>
        </FORM>
      </DIV>
      <% }

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL19 */
      /* Details: "If the optional renderURL                                  */
      /* \"copyCurrentRenderParameters\" attribute is set to true,            */
      /* additional parameters specified with the &lt;portlet:param&gt;       */
      /* element are merged with the render parameters"                       */
      TestResult tr58 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL19);
      if(resourceRequest.getParameter("renderParamTr58")==null && resourceRequest.getParameter("tr58")==null){
        PortletURL renderURLTr58 = resourceResponse.createRenderURL();
        renderURLTr58.setParameter("renderParamTr58", "true");
        TestSetupLink tr58SetupLink = new TestSetupLink(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL19, renderURLTr58);
        tr58SetupLink.writeTo(writer);
      } else if(resourceRequest.getParameter("tr58")!=null && "true".equals(resourceRequest.getParameter("tr58"))){
        tr58.setTcSuccess(true);
        tr58.writeTo(writer);
      } else {
      %>
      <DIV CLASS='portletTCKTestcase' name='V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL19'>
        <h4>V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL19 button (POST):</h4>
        <FORM METHOD='POST' ACTION='
           <portlet:renderURL copyCurrentRenderParameters="true">
              <portlet:param name="action" value="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL19"/>
              <portlet:param name="renderURLTr58" value="true"/>
           </portlet:renderURL>'>
        <INPUT VALUE='V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL19' ID='V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL19-clickme' TYPE='submit'>
        </FORM>
      </DIV>
      <% }

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL20 */
      /* Details: "If the optional renderURL                                  */
      /* \"copyCurrentRenderParameters\" attribute is set to true,            */
      /* additional parameters specified with the &lt;portlet:param&gt;       */
      /* element appear in the values array before the render parameter       */
      /* values if there is a name conflict"                                  */
      TestResult tr59 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL20);
      if(resourceRequest.getParameter("renderParamTr59")==null && resourceRequest.getParameter("tr59")==null){
        PortletURL renderURLTr59 = resourceResponse.createRenderURL();
        renderURLTr59.setParameter("renderParamTr59", "true");
        TestSetupLink tr59SetupLink = new TestSetupLink(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL20, renderURLTr59);
        tr59SetupLink.writeTo(writer);
      } else if(resourceRequest.getParameter("tr59")!=null && "true".equals(resourceRequest.getParameter("tr59"))){
        tr59.setTcSuccess(true);
        tr59.writeTo(writer);
      } else {
      %>
      <DIV CLASS='portletTCKTestcase' name='V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL20'>
        <h4>V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL20 button (POST):</h4>
        <FORM METHOD='POST' ACTION='
           <portlet:renderURL copyCurrentRenderParameters="true">
              <portlet:param name="action" value="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL20"/>
              <portlet:param name="renderParamTr59" value="false"/>
           </portlet:renderURL>'>
        <INPUT VALUE='V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL20' ID='V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL20-clickme' TYPE='submit'>
        </FORM>
      </DIV>
      <% }

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL21 */
      /* Details: "If the optional renderURL                                  */
      /* \"copyCurrentRenderParameters\" attribute is set to false, the       */
      /* current render parameters are not attached to the URL"               */
      TestResult tr60 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL21);
      if(resourceRequest.getParameter("renderParamTr60")==null && resourceRequest.getParameter("tr60")==null){
        PortletURL renderURLTr60 = resourceResponse.createRenderURL();
        renderURLTr60.setParameter("renderParamTr60", "true");
        TestSetupLink tr60SetupLink = new TestSetupLink(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL21, renderURLTr60);
        tr60SetupLink.writeTo(writer);
      } else if(resourceRequest.getParameter("tr60")!=null && "true".equals(resourceRequest.getParameter("tr60"))){
        tr60.setTcSuccess(true);
        tr60.writeTo(writer);
      } else {
      %>
      <DIV CLASS='portletTCKTestcase' name='V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL21'>
        <h4>V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL21 button (POST):</h4>
        <FORM METHOD='POST' ACTION='
           <portlet:renderURL copyCurrentRenderParameters="false">
              <portlet:param name="action" value="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL21"/>
           </portlet:renderURL>'>
        <INPUT VALUE='V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL21' ID='V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL21-clickme' TYPE='submit'>
        </FORM>
      </DIV>
      <% }

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL23 */
      /* Details: "The \"copyCurrentRenderParameters\" attribute is not       */
      /* specified, the security setting is retained"                         */
      TestResult tr62 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL23);
      tr62.setTcSuccess(true);
      tr62.appendTcDetail("Cannot be tested as it is ignored by portlet container.");
      tr62.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL1 */
      /* Details: "The portlet resourceURL tag creates a URL that must        */
      /* point to the current portlet and must trigger an resource request    */
      /* with the supplied parameters"                                        */
      TestResult tr65 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL1);
      %>
      <DIV id="tr65"></DIV>
      <script type="text/javascript" id="scriptTr65">
        getResource('tr65','<portlet:resourceURL><portlet:param name="action" value="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL1"/></portlet:resourceURL>');
      </script>
      <%
      
      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL2 */
      /* Details: "The resourceURL must preserve the current portlet mode,    */
      /* window state and render parameters"                                  */  
      %>
      <DIV id="tr66"></DIV>
      <portlet:resourceURL var="resourceURLTr66">
        <portlet:param name="action" value="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL2"/>
        <portlet:param name="windowStateTr66" value="<%=portletReq.getWindowState().toString()%>"/>
        <portlet:param name="portletModeTr66" value="<%=portletReq.getPortletMode().toString()%>"/>
      </portlet:resourceURL>
      <script type="text/javascript" id="scriptTr66">
        getResource('tr66','${resourceURLTr66}');
      </script>
      
      <%
      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL3 */
      /* Details: "Resource parameters may be added to the URL by including   */
      /* the param tag between the resourceURL start and end tags"            */
      %>
      <DIV id="tr67"></DIV>
      <script type="text/javascript" id="scriptTr67">
        getResource('tr67', '<portlet:resourceURL><portlet:param name="action" value="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL3"/></portlet:resourceURL>');
      </script>
      
      <%
      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL4 */
      /* Details: "The resource parameters specified with the                 */
      /* &lt;portlet:param&gt; element appear in the values array before      */
      /* the render parameter values if there is a name conflict"             */
      if(resourceRequest.getParameter("renderParamTr68")==null){
        PortletURL renderURLTr68 = resourceResponse.createRenderURL();
        renderURLTr68.setParameter("renderParamTr68", "true");
        TestSetupLink tr68SetupLink = new TestSetupLink(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL4, renderURLTr68);
        tr68SetupLink.writeTo(writer);
        %>
        <script type="text/javascript" id="scriptTr68"></script>
        <%
      } else {
      %>
      <DIV id="tr68"></DIV>
      <script type="text/javascript" id="scriptTr68">
        getResource('tr68','<portlet:resourceURL><portlet:param name="action" value="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL4"/><portlet:param name="renderParamTr68" value="false"/></portlet:resourceURL>');
      </script>
      <% }

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL5 */
      /* Details: "The optional resourceURL \"var\" attribute can specify a   */
      /* scoped variable for exporting the action URL"                        */
      %>
      <DIV id="tr69"></DIV>
      <portlet:resourceURL var="resourceURLTr69">
        <portlet:param name="action" value="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL5"/>
      </portlet:resourceURL>
      <script type="text/javascript" id="scriptTr69">
        getResource('tr69','${resourceURLTr69}');
      </script>
      
      <%
      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL6 */
      /* Details: "If the resourceURL \"var\" attribute is specified, the     */
      /* URL is not written to the JspWriter"                                 */
      TestResult tr70 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL6);
      if(resourceRequest.getParameter("tr70")!=null && "true".equals(resourceRequest.getParameter("tr70"))){
        tr70.setTcSuccess(true);
        tr70.writeTo(writer);
      } else {
      %>
      <DIV CLASS="portletTCKTestcase" name="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL6">
        <h4>V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL6 button (POST):</h4>
        <FORM METHOD="POST" ACTION='<portlet:actionURL/>'>
        <INPUT NAME='action' VALUE='V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL6' TYPE="hidden">
        <INPUT NAME='resourceURLTr70' VALUE='<portlet:resourceURL var="resourceURLTr70"/>' TYPE="hidden">
        <INPUT VALUE="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL6" ID="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL6-clickme" TYPE="submit">
        </FORM>
      </DIV>
      <% }

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL7 */
      /* Details: "If the resourceURL \"var\" attribute is not specified,     */
      /* the URL is written to the JspWriter"                                 */
      TestResult tr71 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL7);
      if(resourceRequest.getParameter("tr71")!=null && "true".equals(resourceRequest.getParameter("tr71"))){
        tr71.setTcSuccess(true);
        tr71.writeTo(writer);
      } else {
      %>
      <DIV CLASS="portletTCKTestcase" name="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL7">
        <h4>V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL7 button (POST):</h4>
        <FORM METHOD="POST" ACTION='<portlet:actionURL/>'>
        <INPUT NAME='action' VALUE='V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL7' TYPE="hidden">
        <INPUT NAME='resourceURLTr71' VALUE='<portlet:resourceURL/>' TYPE="hidden">
        <INPUT VALUE="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL7" ID="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL7-clickme" TYPE="submit">
        </FORM>
      </DIV>
      <% }

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL8 */
      /* Details: "If the optional resourceURL \"secure\" attribute is set    */
      /* to true, the resulting URL should require a secure connection"       */
      TestResult tr72 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL8);
      tr72.setTcSuccess(true);
      tr72.appendTcDetail("Cannot be tested as it is ignored by portlet container.");
      tr72.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL9 */
      /* Details: "If the optional resourceURL \"secure\" attribute is set    */
      /* to false, the resulting URL does not need to require a secure        */
      /* connection"                                                          */
      TestResult tr73 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL9);
      tr73.setTcSuccess(true);
      tr73.appendTcDetail("Cannot be tested as it is ignored by portlet container.");
      tr73.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL11 */
      /* Details: "The \"secure\" attribute is not specified, the security    */
      /* setting is retained"                                                 */
      TestResult tr74 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL11);
      tr74.setTcSuccess(true);
      tr74.appendTcDetail("Cannot be tested as it is ignored by portlet container.");
      tr74.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL22 */
      /* Details: "Setting the \"id\" attribute will add an ID to the resourceURL which can
      /*  be retrieved by \"getResourceID()\" method of ResourceRequest" */
      %>
      <DIV id="tr84"></DIV>
      <script type="text/javascript" id="scriptTr84">
        getResource('tr84','<portlet:resourceURL id="resourceURLTr84"><portlet:param name="action" value="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL22"></portlet:param></portlet:resourceURL>');
      </script>
      <%
      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL23 */
      /* Details: "If the optional resourceURL \"cacheability\" attribute     */
      /* is set, the cacheability is set accordingly"                         */
      %>
      <DIV id="tr85"></DIV>
      <script type="text/javascript" id="scriptTr85">
        getResource('tr85','<portlet:resourceURL cacheability="PORTLET"><portlet:param name="action" value="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL23"></portlet:param></portlet:resourceURL>');
      </script>
      <%

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL24 */
      /* Details: "If the optional resourceURL \"cacheability\" attribute     */
      /* is not set, the current cacheability setting is retained"            */
      %>
      <DIV id="tr86"></DIV>
      <script type="text/javascript" id="scriptTr86">
        getResource('tr86','<portlet:resourceURL><portlet:param name="action" value="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL24"></portlet:param></portlet:resourceURL>');
      </script>
      <%

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL25 */
      /* Details: "If the cacheability is set to PAGE in a Resource phase     */
      /* include with cacheability = FULL, a JspException with the            */
      /* IllegalStateException that caused this error is thrown"              */
      %>
      <DIV id="tr87"></DIV>
      <script type="text/javascript" id="scriptTr87">
        getResource('tr87','<portlet:resourceURL cacheability="FULL"><portlet:param name="action" value="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL25"></portlet:param></portlet:resourceURL>');
      </script>
      <%

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL26 */
      /* Details: "If the cacheability is set to PORTLET in a Resource        */
      /* phase include with cacheability = FULL, a JspException with the      */
      /* IllegalStateException that caused this error is thrown"              */
      %>
      <DIV id="tr88"></DIV>
      <script type="text/javascript" id="scriptTr88">
        getResource('tr88','<portlet:resourceURL cacheability="FULL"><portlet:param name="action" value="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL26"></portlet:param></portlet:resourceURL>');
      </script>
      <%

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL27 */
      /* Details: "If the cacheability is set to PAGE in a Resource phase     */
      /* include with cacheability = PORTLET, a JspException with the         */
      /* IllegalStateException that caused this error is thrown"              */
      %>
      <DIV id="tr89"></DIV>
      <script type="text/javascript" id="scriptTr89">
        getResource('tr89','<portlet:resourceURL cacheability="PORTLET"><portlet:param name="action" value="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL27"></portlet:param></portlet:resourceURL>');
      </script>
      <%

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramAction1 */
      /* Details: "The param tag can be used within the actionURL tag to      */
      /* add a parameter"                                                     */
      TestResult tr90 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMACTION1);
      if(resourceRequest.getParameter("tr90")!=null && "true".equals(resourceRequest.getParameter("tr90"))){
        tr90.setTcSuccess(true);
        tr90.writeTo(writer);
      } else {
      %>
      <DIV CLASS="portletTCKTestcase" name="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramAction1">
        <h4>V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramAction1 button (POST):</h4>
        <FORM METHOD="POST" ACTION='<portlet:actionURL><portlet:param name="tr90_value" value="true"/></portlet:actionURL>'>
          <INPUT NAME='action' VALUE='V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramAction1' TYPE="hidden">
          <INPUT VALUE="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramAction1" ID="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramAction1-clickme" TYPE="submit">
        </FORM>
      </DIV>
      <% }

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramAction2 */
      /* Details: "The param tag required attribute \"name\" defines the      */
      /* parameter name"                                                      */
      TestResult tr91 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMACTION2);
      if(resourceRequest.getParameter("tr91")!=null && "true".equals(resourceRequest.getParameter("tr91"))){
        tr91.setTcSuccess(true);
        tr91.writeTo(writer);
      } else {
      %>
      <DIV CLASS="portletTCKTestcase" name="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramAction2">
        <h4>V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramAction2 button (POST):</h4>
        <FORM METHOD="POST" ACTION='<portlet:actionURL><portlet:param name="tr91_value" value="true"/></portlet:actionURL>'>
          <INPUT NAME='action' VALUE='V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramAction2' TYPE="hidden">
          <INPUT VALUE="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramAction2" ID="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramAction2-clickme" TYPE="submit">
        </FORM>
      </DIV>
      <% }

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramAction3 */
      /* Details: "If more than one tags appear in the actionURL tag, the     */
      /* values must be stored as a multivalued array in order of             */
      /* appearance within the actionURL tag"                                 */
      TestResult tr92 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMACTION3);
      if(resourceRequest.getParameter("tr92")!=null && "true".equals(resourceRequest.getParameter("tr92"))){
        tr92.setTcSuccess(true);
        tr92.writeTo(writer);
      } else {
      %>
      <DIV CLASS="portletTCKTestcase" name="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramAction3">
        <h4>V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramAction3 button (POST):</h4>
        <FORM METHOD="POST" ACTION='<portlet:actionURL><portlet:param name="tr92_value" value="true"/><portlet:param name="tr92_value" value="false"/></portlet:actionURL>'>
          <INPUT NAME='action' VALUE='V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramAction3' TYPE="hidden">
          <INPUT VALUE="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramAction3" ID="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramAction3-clickme" TYPE="submit">
        </FORM>
      </DIV>
      
      <% }

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramAction4 */
      /* Details: "If the \"name\" attribute is null or empty, no action is   */
      /* performed"                                                           */
      TestResult tr93 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMACTION4);
      %>
      <c:catch var ="exceptionTr93">
         <portlet:actionURL><portlet:param name="" value="true"/></portlet:actionURL>
      </c:catch>
      <c:if test = "${exceptionTr93 != null}">
         <%
         tr93.setTcSuccess(true);
         String exceptionTr93 = ""; 
         exceptionTr93 = exceptionTr93 + pageContext.getAttribute("exceptionTr93");
         tr93.appendTcDetail(exceptionTr93);
         %>
      </c:if>
      <c:if test = "${exceptionTr93 == null}">
         <%
         tr93.appendTcDetail("Test case failed as no Exception is raised while defining action parameter with empty name.");
         %>
      </c:if>
      <%
      tr93.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramAction5 */
      /* Details: "The param tag required attribute \"value\" defines the     */
      /* parameter value"                                                     */
      TestResult tr94 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMACTION5);
      if(resourceRequest.getParameter("tr94")!=null && "true".equals(resourceRequest.getParameter("tr94"))){
        tr94.setTcSuccess(true);
        tr94.writeTo(writer);
      } else {
      %>
      <DIV CLASS="portletTCKTestcase" name="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramAction5">
        <h4>V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramAction5 button (POST):</h4>
        <FORM METHOD="POST" ACTION='<portlet:actionURL><portlet:param name="tr94_value" value="true"/></portlet:actionURL>'>
          <INPUT NAME='action' VALUE='V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramAction5' TYPE="hidden">
          <INPUT VALUE="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramAction5" ID="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramAction5-clickme" TYPE="submit">
        </FORM>
      </DIV>
      <% }

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramAction6 */
      /* Details: "If the \"value\" attribute is null or empty, the           */
      /* parameter is removed"                                                */
      TestResult tr95 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMACTION6);
      if(resourceRequest.getParameter("tr95")!=null && "true".equals(resourceRequest.getParameter("tr95"))){
        tr95.setTcSuccess(true);
        tr95.writeTo(writer);
      } else {
      %>
      <DIV CLASS="portletTCKTestcase" name="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramAction6">
        <h4>V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramAction6 button (POST):</h4>
        <FORM METHOD="POST" ACTION='<portlet:actionURL><portlet:param name="tr95_value" value=""/></portlet:actionURL>'>
          <INPUT NAME='action' VALUE='V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramAction6' TYPE="hidden">
          <INPUT VALUE="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramAction6" ID="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramAction6-clickme" TYPE="submit">
        </FORM>
      </DIV>
      <% }

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramRender1 */
      /* Details: "The param tag can be used within the renderURL tag to      */
      /* add a parameter"                                                     */
      TestResult tr96 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMRENDER1);
      if(resourceRequest.getParameter("tr96")!=null && "true".equals(resourceRequest.getParameter("tr96"))){
        tr96.setTcSuccess(true);
        tr96.writeTo(writer);
      } else {
      %>
      <DIV CLASS="portletTCKTestcase" name="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramRender1">
        <h4>V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramRender1 button (POST):</h4>
        <FORM METHOD="POST" ACTION='<portlet:renderURL><portlet:param name="tr96_value" value="true"/><portlet:param name="action" value="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramRender1"/></portlet:renderURL>'>
          <INPUT VALUE="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramRender1" ID="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramRender1-clickme" TYPE="submit">
        </FORM>
      </DIV>
      <% }

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramRender2 */
      /* Details: "The param tag required attribute \"name\" defines the      */
      /* parameter name"                                                      */
      TestResult tr97 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMRENDER2);
      if(resourceRequest.getParameter("tr97")!=null && "true".equals(resourceRequest.getParameter("tr97"))){
        tr97.setTcSuccess(true);
        tr97.writeTo(writer);
      } else {
      %>
      <DIV CLASS="portletTCKTestcase" name="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramRender2">
        <h4>V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramRender2 button (POST):</h4>
        <FORM METHOD="POST" ACTION='<portlet:renderURL><portlet:param name="tr97_value" value="true"/><portlet:param name="action" value="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramRender2"/></portlet:renderURL>'>
          <INPUT VALUE="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramRender2" ID="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramRender2-clickme" TYPE="submit">
        </FORM>
      </DIV>
      <% }

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramRender3 */
      /* Details: "If more than one tags appear in the renderURL tag, the     */
      /* values must be stored as a multivalued array in order of             */
      /* appearance within the renderURL tag"                                 */
      TestResult tr98 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMRENDER3);
      if(resourceRequest.getParameter("tr98")!=null && "true".equals(resourceRequest.getParameter("tr98"))){
        tr98.setTcSuccess(true);
        tr98.writeTo(writer);
      } else {
      %>
      <DIV CLASS="portletTCKTestcase" name="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramRender3">
        <h4>V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramRender3 button (POST):</h4>
        <FORM METHOD="POST" ACTION='<portlet:renderURL><portlet:param name="tr98_value" value="true"/><portlet:param name="tr98_value" value="false"/><portlet:param name="action" value="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramRender3"/></portlet:renderURL>'>
          <INPUT VALUE="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramRender3" ID="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramRender3-clickme" TYPE="submit">
        </FORM>
      </DIV>
      <% }

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramRender4 */
      /* Details: "If the \"name\" attribute is null or empty, no action is   */
      /* performed"                                                           */
      TestResult tr99 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMRENDER4);
      %>
      <c:catch var ="exceptionTr99">
         <portlet:renderURL><portlet:param name="" value="true"/></portlet:renderURL>
      </c:catch>
      <c:if test = "${exceptionTr99 != null}">
         <%
         tr99.setTcSuccess(true);
         String exceptionTr99 = ""; 
         exceptionTr99 = exceptionTr99 + pageContext.getAttribute("exceptionTr99");
         tr99.appendTcDetail(exceptionTr99);
         %>
      </c:if>
      <c:if test = "${exceptionTr99 == null}">
         <%
         tr99.appendTcDetail("Test case failed as no Exception is raised while defining render parameter with empty name.");
         %>
      </c:if>
      <%
      tr99.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramRender5 */
      /* Details: "The param tag required attribute \"value\" defines the     */
      /* parameter value"                                                     */
      TestResult tr100 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMRENDER5);
      if(resourceRequest.getParameter("tr100")!=null && "true".equals(resourceRequest.getParameter("tr100"))){
        tr100.setTcSuccess(true);
        tr100.writeTo(writer);
      } else {
      %>
      <DIV CLASS="portletTCKTestcase" name="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramRender5">
        <h4>V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramRender5 button (POST):</h4>
        <FORM METHOD="POST" ACTION='<portlet:renderURL><portlet:param name="tr100_value" value="true"/><portlet:param name="action" value="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramRender5"/></portlet:renderURL>'>
          <INPUT VALUE="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramRender5" ID="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramRender5-clickme" TYPE="submit">
        </FORM>
      </DIV>
      <% }

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramRender6 */
      /* Details: "If the \"value\" attribute is null or empty, the           */
      /* parameter is removed"                                                */
      TestResult tr101 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMRENDER6);
      if(resourceRequest.getParameter("tr101")!=null && "true".equals(resourceRequest.getParameter("tr101"))){
        tr101.setTcSuccess(true);
        tr101.writeTo(writer);
      } else {
      %>
      <DIV CLASS="portletTCKTestcase" name="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramRender6">
        <h4>V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramRender6 button (POST):</h4>
        <FORM METHOD="POST" ACTION='<portlet:renderURL><portlet:param name="tr101_value" value=""/><portlet:param name="action" value="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramRender6"/></portlet:renderURL>'>
          <INPUT VALUE="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramRender6" ID="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramRender6-clickme" TYPE="submit">
        </FORM>
      </DIV>
      <% }

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramResource1 */
      /* Details: "The param tag can be used within the resourceURL tag to    */
      /* add a parameter"                                                     */
      %>
      <DIV id="tr102"></DIV>
      <script type="text/javascript" id="scriptTr102">
        getResource('tr102', '<portlet:resourceURL><portlet:param name="tr102_value" value="true"/><portlet:param name="action" value="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramResource1"/></portlet:resourceURL>');
      </script>
      
      <%
      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramResource2 */
      /* Details: "The param tag required attribute \"name\" defines the      */
      /* parameter name"                                                      */
      %>
      <DIV id="tr103"></DIV>
      <script type="text/javascript" id="scriptTr103">
        getResource('tr103', '<portlet:resourceURL><portlet:param name="tr103_value" value="true"/><portlet:param name="action" value="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramResource2"/></portlet:resourceURL>');
      </script>
      
      <%
      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramResource3 */
      /* Details: "If more than one tags appear in the resourceURL tag, the   */
      /* values must be stored as a multivalued array in order of             */
      /* appearance within the resourceURL tag"                               */
      %>
      <DIV id="tr104"></DIV>
      <script type="text/javascript" id="scriptTr104">
        getResource('tr104', '<portlet:resourceURL><portlet:param name="tr104_value" value="true"/><portlet:param name="tr104_value" value="false"/><portlet:param name="action" value="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramResource3"/></portlet:resourceURL>');
      </script>
      
      <%
      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramResource4 */
      /* Details: "If the \"name\" attribute is null or empty, no action is   */
      /* performed"                                                           */
      TestResult tr105 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMRESOURCE4);
      %>
      <c:catch var ="exceptionTr105">
         <portlet:resourceURL><portlet:param name="" value="true"/></portlet:resourceURL>
      </c:catch>
      <c:if test = "${exceptionTr105 != null}">
         <%
         tr105.setTcSuccess(true);
         String exceptionTr105 = ""; 
         exceptionTr105 = exceptionTr105 + pageContext.getAttribute("exceptionTr105");
         tr105.appendTcDetail(exceptionTr105);
         %>
      </c:if>
      <c:if test = "${exceptionTr105 == null}">
         <%
         tr105.appendTcDetail("Test case failed as no Exception is raised while defining resource parameter with empty name.");
         %>
      </c:if>
      <%
      tr105.writeTo(writer);
      
      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramResource5 */
      /* Details: "The param tag required attribute \"value\" defines the     */
      /* parameter value"                                                     */
      %>
      <DIV id="tr106"></DIV>
      <script type="text/javascript" id="scriptTr106">
        getResource('tr106', '<portlet:resourceURL><portlet:param name="tr106_value" value="true"/><portlet:param name="action" value="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramResource5"/></portlet:resourceURL>');
      </script>
      
      <%
      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramResource6 */
      /* Details: "If the \"value\" attribute is null or empty, no action     */
      /* is performed"                                                        */
      %>
      <DIV id="tr107"></DIV>
      <script type="text/javascript" id="scriptTr107">
        getResource('tr107', '<portlet:resourceURL><portlet:param name="tr107_value" value=""/><portlet:param name="action" value="V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramResource6"/></portlet:resourceURL>');
      </script>
      
      <%
      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_propertyAction1 */
      /* Details: "The property tag can be used within the actionURL tag to   */
      /* add a property"                                                      */
      TestResult tr108 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYACTION1);
      tr108.setTcSuccess(true);
      tr108.appendTcDetail("Cannot test property tag as Headers are getting ignored by portlet container");
      tr108.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_propertyAction2 */
      /* Details: "The property tag required attribute \"name\" defines the   */
      /* property name"                                                       */
      TestResult tr109 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYACTION2);
      tr109.setTcSuccess(true);
      tr109.appendTcDetail("Cannot test property tag as Headers are getting ignored by portlet container");
      tr109.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_propertyAction3 */
      /* Details: "If more than one tags appear in the actionURL tag, the     */
      /* values must be stored as a multivalued array in order of             */
      /* appearance within the actionURL tag"                                 */
      TestResult tr110 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYACTION3);
      tr110.setTcSuccess(true);
      tr110.appendTcDetail("Cannot test property tag as Headers are getting ignored by portlet container");
      tr110.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_propertyAction4 */
      /* Details: "If the \"name\" attribute is null or empty, no action is   */
      /* performed"                                                           */
      TestResult tr111 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYACTION4);
      tr111.setTcSuccess(true);
      tr111.appendTcDetail("Cannot test property tag as Headers are getting ignored by portlet container");
      tr111.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_propertyAction5 */
      /* Details: "The property tag required attribute \"value\" defines      */
      /* the property value"                                                  */
      TestResult tr112 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYACTION5);
      tr112.setTcSuccess(true);
      tr112.appendTcDetail("Cannot test property tag as Headers are getting ignored by portlet container");
      tr112.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_propertyAction6 */
      /* Details: "If the \"value\" attribute is null or empty,  the          */
      /* property value is set to null"                                       */
      TestResult tr113 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYACTION6);
      tr113.setTcSuccess(true);
      tr113.appendTcDetail("Cannot test property tag as Headers are getting ignored by portlet container");
      tr113.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_propertyRender1 */
      /* Details: "The property tag can be used within the renderURL tag to   */
      /* add a property"                                                      */
      TestResult tr114 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYRENDER1);
      tr114.setTcSuccess(true);
      tr114.appendTcDetail("Cannot test property tag as Headers are getting ignored by portlet container");
      tr114.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_propertyRender2 */
      /* Details: "The property tag required attribute \"name\" defines the   */
      /* property name"                                                       */
      TestResult tr115 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYRENDER2);
      tr115.setTcSuccess(true);
      tr115.appendTcDetail("Cannot test property tag as Headers are getting ignored by portlet container");
      tr115.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_propertyRender3 */
      /* Details: "If more than one tags appear in the renderURL tag, the     */
      /* values must be stored as a multivalued array in order of             */
      /* appearance within the renderURL tag"                                 */
      TestResult tr116 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYRENDER3);
      tr116.setTcSuccess(true);
      tr116.appendTcDetail("Cannot test property tag as Headers are getting ignored by portlet container");
      tr116.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_propertyRender4 */
      /* Details: "If the \"name\" attribute is null or empty, no action is   */
      /* performed"                                                           */
      TestResult tr117 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYRENDER4);
      tr117.setTcSuccess(true);
      tr117.appendTcDetail("Cannot test property tag as Headers are getting ignored by portlet container");
      tr117.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_propertyRender5 */
      /* Details: "The property tag required attribute \"value\" defines      */
      /* the property value"                                                  */
      TestResult tr118 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYRENDER5);
      tr118.setTcSuccess(true);
      tr118.appendTcDetail("Cannot test property tag as Headers are getting ignored by portlet container");
      tr118.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_propertyRender6 */
      /* Details: "If the \"value\" attribute is null or empty,  the          */
      /* property value is set to null"                                       */
      TestResult tr119 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYRENDER6);
      tr119.setTcSuccess(true);
      tr119.appendTcDetail("Cannot test property tag as Headers are getting ignored by portlet container");
      tr119.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_propertyResource1 */
      /* Details: "The property tag can be used within the resourceURL tag    */
      /* to add a property"                                                   */
      TestResult tr120 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYRESOURCE1);
      tr120.setTcSuccess(true);
      tr120.appendTcDetail("Cannot test property tag as Headers are getting ignored by portlet container");
      tr120.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_propertyResource2 */
      /* Details: "The property tag required attribute \"name\" defines the   */
      /* property name"                                                       */
      TestResult tr121 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYRESOURCE2);
      tr121.setTcSuccess(true);
      tr121.appendTcDetail("Cannot test property tag as Headers are getting ignored by portlet container");
      tr121.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_propertyResource3 */
      /* Details: "If more than one tags appear in the resourceURL tag, the   */
      /* values must be stored as a multivalued array in order of             */
      /* appearance within the resourceURL tag"                               */
      TestResult tr122 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYRESOURCE3);
      tr122.setTcSuccess(true);
      tr122.appendTcDetail("Cannot test property tag as Headers are getting ignored by portlet container");
      tr122.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_propertyResource4 */
      /* Details: "If the \"name\" attribute is null or empty, no action is   */
      /* performed"                                                           */
      TestResult tr123 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYRESOURCE4);
      tr123.setTcSuccess(true);
      tr123.appendTcDetail("Cannot test property tag as Headers are getting ignored by portlet container");
      tr123.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_propertyResource5 */
      /* Details: "The property tag required attribute \"value\" defines      */
      /* the property value"                                                  */
      TestResult tr124 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYRESOURCE5);
      tr124.setTcSuccess(true);
      tr124.appendTcDetail("Cannot test property tag as Headers are getting ignored by portlet container");
      tr124.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_propertyResource6 */
      /* Details: "If the \"value\" attribute is null or empty, the           */
      /* property value is set to null"                                       */
      TestResult tr125 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYRESOURCE6);
      tr125.setTcSuccess(true);
      tr125.appendTcDetail("Cannot test property tag as Headers are getting ignored by portlet container");
      tr125.writeTo(writer);

%>

<%=writer.toString() %>