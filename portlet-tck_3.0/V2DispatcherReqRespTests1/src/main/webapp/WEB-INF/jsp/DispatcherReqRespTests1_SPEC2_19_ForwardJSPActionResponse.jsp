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

<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0"  prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.io.*,java.util.*,org.slf4j.*" %>
<%@ page import="static org.slf4j.Logger.*" %>
<%@ page import="javax.portlet.*,javax.portlet.filter.*" %>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ page import="javax.portlet.tck.beans.*,javax.portlet.tck.constants.*" %>
<%@ page import="static javax.portlet.tck.constants.Constants.*" %>
<%@ page import="static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.*" %>
<%

      PortletRequest portletReq = (PortletRequest) request.getAttribute("javax.portlet.request");
      PortletResponse portletResp = (PortletResponse) request.getAttribute("javax.portlet.response");
      PortletConfig portletConfig = (PortletConfig) request.getAttribute("javax.portlet.config");
      long svtTid = Thread.currentThread().getId();
      long reqTid = (Long) portletReq.getAttribute(THREADID_ATTR);

      StringWriter writer = new StringWriter();

      JSR286DispatcherReqRespTestCaseDetails tcd = new JSR286DispatcherReqRespTestCaseDetails();

      // Create result objects for the tests

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionResponse_containsHeader */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletResponse.containsHeader must return false"         */
      TestResult tr0 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONRESPONSE_CONTAINSHEADER);
      try {
         boolean ok = response.containsHeader("Accept");
         tr0.setTcSuccess(ok == false);
      } catch(Exception e) {tr0.appendTcDetail(e.toString());}
      tr0.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionResponse_encodeRedirectURL1 */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletResponse.encodeRedirectURL must return null"       */
      TestResult tr1 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONRESPONSE_ENCODEREDIRECTURL1);
      try {
         String isval = response.encodeRedirectURL("http://www.cnn.com/");
         CompareUtils.stringsEqual(isval, null, tr1);
      } catch(Exception e) {tr1.appendTcDetail(e.toString());}
      tr1.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionResponse_encodeRedirectUrl */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletResponse.encodeRedirectUrl must return null"       */
      TestResult tr2 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONRESPONSE_ENCODEREDIRECTURL);
      try {
         String isval = response.encodeRedirectUrl("http://www.cnn.com/");
         CompareUtils.stringsEqual(isval, null, tr2);
      } catch(Exception e) {tr2.appendTcDetail(e.toString());}
      tr2.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionResponse_encodeURL1 */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletResponse.encodeURL must provide the same           */
      /* functionality as ActionResponse.encodeURL"                           */
      TestResult tr3 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONRESPONSE_ENCODEURL1);
      try {
         String turl = "http://www.apache.org/";
         String hval = (String)response.encodeURL(turl);
         String pval = (String)portletResp.encodeURL(turl);
         CompareUtils.stringsEqual("HttpServletResponse", hval, "ActionResponse", pval, tr3);
      } catch(Exception e) {tr3.appendTcDetail(e.toString());}
      tr3.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionResponse_encodeUrl */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletResponse.encodeUrl must provide the same           */
      /* functionality as ActionResponse.encodeURL"                           */
      TestResult tr4 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONRESPONSE_ENCODEURL);
      try {
         String turl = "http://www.apache.org/";
         String hval = (String)response.encodeUrl(turl);
         String pval = (String)portletResp.encodeURL(turl);
         CompareUtils.stringsEqual("HttpServletResponse", hval, "ActionResponse", pval, tr4);
      } catch(Exception e) {tr4.appendTcDetail(e.toString());}
      tr4.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionResponse_getBufferSize */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletResponse.getBufferSize must return 0"              */
      TestResult tr5 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONRESPONSE_GETBUFFERSIZE);
      try {
         int isval = response.getBufferSize();
         if (isval != 0) tr5.appendTcDetail("Returned value was: " + isval);
         tr5.setTcSuccess(isval == 0);
      } catch(Exception e) {tr5.appendTcDetail(e.toString());}
      tr5.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionResponse_getCharacterEncoding */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletResponse.getCharacterEncoding must return null"    */
      TestResult tr6 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONRESPONSE_GETCHARACTERENCODING);
      try {
         String isval = response.getCharacterEncoding();
         CompareUtils.stringsEqual(isval, null, tr6);
      } catch(Exception e) {tr6.appendTcDetail(e.toString());}
      tr6.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionResponse_getContentType */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletResponse.getContentType must return null"          */
      TestResult tr7 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONRESPONSE_GETCONTENTTYPE);
      try {
         String isval = response.getContentType();
         CompareUtils.stringsEqual(isval, null, tr7);
      } catch(Exception e) {tr7.appendTcDetail(e.toString());}
      tr7.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionResponse_getLocale */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletResponse.getLocale must return null"               */
      TestResult tr8 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONRESPONSE_GETLOCALE);
      try {
         Locale loc = response.getLocale();
         if (loc != null) tr8.appendTcDetail("Locale is " + loc);
         tr8.setTcSuccess(loc == null);
      } catch(Exception e) {tr8.appendTcDetail(e.toString());}
      tr8.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionResponse_isCommitted */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletResponse.isCommitted must return false"            */
      TestResult tr9 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONRESPONSE_ISCOMMITTED);
      try {
         boolean ok = response.isCommitted();
         tr9.setTcSuccess(ok == false);
      } catch(Exception e) {tr9.appendTcDetail(e.toString());}
      tr9.writeTo(writer);

      request.getSession().setAttribute(
                   Constants.RESULT_ATTR_PREFIX + "DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionResponse",
                   writer.toString());
%>
