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
<%@ page import="javax.portlet.tck.beans.JSR286SpecTestCaseDetails" %>
<%@ page import="javax.portlet.tck.beans.TestResult" %>
<%@ page import="javax.portlet.tck.constants.Constants" %>

<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS1" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS2" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS3" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS4" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS5" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS6" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS7" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS8" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS9" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS10" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS11" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS12" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS13" %>
<%@ page import="static javax.portlet.tck.constants.Constants.THREADID_ATTR" %>

<portlet:defineObjects/>

<%

      PortletRequest portletReq = (PortletRequest) request.getAttribute("javax.portlet.request");
      PortletResponse portletResp = (PortletResponse) request.getAttribute("javax.portlet.response");
      long svtTid = Thread.currentThread().getId();
      long reqTid = (Long) portletReq.getAttribute(THREADID_ATTR);

      StringWriter writer = new StringWriter();

      JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();

      // Create result objects for the tests

      /* TestCase: V2PortletTagLibraryTests_SPEC2_26_IncludeJSPEvent_defineObjects1 */
      /* Details: "When included in the Event phase, the defineObjects tag    */
      /* defines the variable RenderRequest renderRequest to be null or       */
      /* undefined"                                                           */
      TestResult tr0 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS1);
      if(renderRequest==null){
        tr0.setTcSuccess(true);
      }
      tr0.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests_SPEC2_26_IncludeJSPEvent_defineObjects2 */
      /* Details: "When included in the Event phase, the defineObjects tag    */
      /* defines the variable ResourceRequest resourceRequest to be null or   */
      /* undefined"                                                           */
      TestResult tr1 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS2);
      if(resourceRequest==null){
        tr1.setTcSuccess(true);
      }
      tr1.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests_SPEC2_26_IncludeJSPEvent_defineObjects3 */
      /* Details: "When included in the Event phase, the defineObjects tag    */
      /* defines the variable ActionRequest actionRequest to be null or       */
      /* undefined"                                                           */
      TestResult tr2 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS3);
      if(actionRequest==null){
        tr2.setTcSuccess(true);
      }
      tr2.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests_SPEC2_26_IncludeJSPEvent_defineObjects4 */
      /* Details: "When included in the Event phase, the defineObjects tag    */
      /* defines the variable EventRequest eventRequest to the                */
      /* corresponding object"                                                */
      TestResult tr3 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS4);
      if(eventRequest!=null && eventRequest.equals(portletReq)){
        tr3.setTcSuccess(true);
      }
      tr3.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests_SPEC2_26_IncludeJSPEvent_defineObjects5 */
      /* Details: "When included in the Event phase, the defineObjects tag    */
      /* defines the variable RenderResponse renderResponse to be null or     */
      /* undefined"                                                           */
      TestResult tr4 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS5);
      if(renderResponse==null){
        tr4.setTcSuccess(true);
      }
      tr4.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests_SPEC2_26_IncludeJSPEvent_defineObjects6 */
      /* Details: "When included in the Event phase, the defineObjects tag    */
      /* defines the variable ResourceResponse resourceResponse to be null    */
      /* or undefined"                                                        */
      TestResult tr5 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS6);
      if(resourceResponse==null){
        tr5.setTcSuccess(true);
      }
      tr5.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests_SPEC2_26_IncludeJSPEvent_defineObjects7 */
      /* Details: "When included in the Event phase, the defineObjects tag    */
      /* defines the variable ActionResponse actionResponse to be null or     */
      /* undefined"                                                           */
      TestResult tr6 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS7);
      if(actionResponse==null){
        tr6.setTcSuccess(true);
      }
      tr6.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests_SPEC2_26_IncludeJSPEvent_defineObjects8 */
      /* Details: "When included in the Event phase, the defineObjects tag    */
      /* defines the variable EventResponse eventResponse to the              */
      /* corresponding object"                                                */
      TestResult tr7 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS8);
      if(eventResponse!=null && eventResponse.equals(portletResp)){
        tr7.setTcSuccess(true);
      }
      tr7.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests_SPEC2_26_IncludeJSPEvent_defineObjects9 */
      /* Details: "When included in the Event phase, the defineObjects tag    */
      /* defines the variable PortletConfig portletConfig"                    */
      TestResult tr8 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS9);
      if(portletConfig!=null && portletConfig.equals((PortletConfig) request.getAttribute("javax.portlet.config"))){
        tr8.setTcSuccess(true);
      }
      tr8.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests_SPEC2_26_IncludeJSPEvent_defineObjects10 */
      /* Details: "When included in the Event phase, the defineObjects tag    */
      /* defines the variable PortletSession portletSession, providing        */
      /* access to the portletSession, does not create a new session, only    */
      /* returns an existing session or null if no session exists."           */
      TestResult tr9 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS10);
      if(portletSession != null){
        tr9.setTcSuccess(true);
      }
      tr9.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests_SPEC2_26_IncludeJSPEvent_defineObjects11 */
      /* Details: "When included in the Event phase, the defineObjects tag    */
      /* defines the variable Map&lt;String, Object&gt;                       */
      /* portletSessionScope, providing access to the portletSession          */
      /* attributes as a Map equivalent to the                                */
      /* PortletSession.getAttributeMap() call, does not create a new         */
      /* session, only returns an existing session. If no session             */
      /* attributes exist this method returns an empty Map."                  */
      TestResult tr10 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS11);
      if(portletSessionScope.isEmpty() || portletSessionScope.equals(portletReq.getPortletSession().getAttributeMap())){
        tr10.setTcSuccess(true);
      }
      tr10.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests_SPEC2_26_IncludeJSPEvent_defineObjects12 */
      /* Details: "When included in the Event phase, the defineObjects tag    */
      /* defines the variable PortletPreferences portletPreferences,          */
      /* providing access to the portlet preferences."                        */
      TestResult tr11 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS12);
      if(portletPreferences.equals(portletReq.getPreferences())){
        tr11.setTcSuccess(true);
      }
      tr11.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests_SPEC2_26_IncludeJSPEvent_defineObjects13 */
      /* Details: "When included in the Event phase, the defineObjects tag    */
      /* defines the variable Map&lt;String, String[]&gt;                     */
      /* portletPreferencesValues, providing access to the portlet            */
      /* preferences as a Map, equivalent to the                              */
      /* PortletPreferences.getMap() call. If no portlet preferences exist,   */
      /* the Map is empty."                                                   */
      TestResult tr12 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS13);
      if(portletPreferencesValues.isEmpty() || portletPreferencesValues.equals(portletReq.getPreferences().getMap())){
        tr12.setTcSuccess(true);
      }
      tr12.writeTo(writer);

      request.getSession().setAttribute(
                   Constants.RESULT_ATTR_PREFIX + "PortletTagLibraryTests_SPEC2_26_IncludeJSPEvent",
                   writer.toString());
%>
