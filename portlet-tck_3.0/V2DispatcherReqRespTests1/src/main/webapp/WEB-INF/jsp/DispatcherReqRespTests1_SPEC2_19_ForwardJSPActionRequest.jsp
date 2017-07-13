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

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getAttribute */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getAttribute must provide the same         */
      /* functionality as ActionRequest.getAttribute"                         */
      TestResult tr0 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETATTRIBUTE);
      try {
         String hval = (String)request.getAttribute(ATTR_PREFIX + "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getAttribute");
         String pval = (String)portletReq.getAttribute(ATTR_PREFIX + "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getAttribute");
         CompareUtils.stringsEqual("HttpServletRequest", hval, "ActionRequest", pval, tr0);
      } catch(Exception e) {tr0.appendTcDetail(e.toString());}
      tr0.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getAttributeNames */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getAttributeNames must provide the same    */
      /* functionality as ActionRequest.getAttributeNames"                    */
      TestResult tr1 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETATTRIBUTENAMES);
      try {
         Enumeration<String> he = request.getAttributeNames();
         Enumeration<String> pe = portletReq.getAttributeNames();
         CompareUtils.enumsEqual("HttpServletRequest attribute names", he, "ActionRequest attribute names", pe,tr1);
      } catch(Exception e) {tr1.appendTcDetail(e.toString());}
      tr1.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getAuthType */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getAuthType must provide the same          */
      /* functionality as ActionRequest.getAuthType"                          */
      TestResult tr2 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETAUTHTYPE);
      try {
         String hval = request.getAuthType();
         String pval = ((ActionRequest)portletReq).getAuthType();
         CompareUtils.stringsEqual("HttpServletRequest", hval, "ActionRequest", pval, tr2);
      } catch(Exception e) {tr2.appendTcDetail(e.toString());}
      tr2.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getCharacterEncoding */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getCharacterEncoding must provide the      */
      /* same functionality as ActionRequest.getCharacterEncoding"            */
      TestResult tr3 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETCHARACTERENCODING);
      try {
         String hval = request.getCharacterEncoding();
         String pval = ((ActionRequest)portletReq).getCharacterEncoding();
         CompareUtils.stringsEqual("HttpServletRequest", hval, "ActionRequest", pval, tr3);
      } catch(Exception e) {tr3.appendTcDetail(e.toString());}
      tr3.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getContentLength */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getContentLength must provide the same     */
      /* functionality as ActionRequest.getContentLength"                     */
      TestResult tr4 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETCONTENTLENGTH);
      try {
         int hval = request.getContentLength();
         int pval = ((ActionRequest)portletReq).getContentLength();
         String str = "Value " + hval + " from " + "HttpServletRequest" + " does not equal value " + pval + " + ActionRequest";
         if (hval != pval) {
            tr4.appendTcDetail(str);
         }
         tr4.setTcSuccess(hval == pval);
      } catch(Exception e) {tr4.appendTcDetail(e.toString());}
      tr4.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getContentType */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getContentType must provide the same       */
      /* functionality as ActionRequest.getContentType"                       */
      TestResult tr5 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETCONTENTTYPE);
      try {
         String hval = request.getContentType();
         String pval = ((ActionRequest)portletReq).getContentType();
         CompareUtils.stringsEqual("HttpServletRequest", hval, "ActionRequest", pval, tr5);
      } catch(Exception e) {tr5.appendTcDetail(e.toString());}
      tr5.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getContextPath */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getContextPath must provide the same       */
      /* functionality as ActionRequest.getContextPath"                       */
      TestResult tr6 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETCONTEXTPATH);
      try {
         String hval = request.getContextPath();
         String pval = ((ActionRequest)portletReq).getContextPath();
         CompareUtils.stringsEqual("HttpServletRequest", hval, "ActionRequest", pval, tr6);
      } catch(Exception e) {tr6.appendTcDetail(e.toString());}
      tr6.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getCookies */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getCookies must provide the same           */
      /* functionality as ActionRequest.getCookies"                           */
      TestResult tr7 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETCOOKIES);
      try {
         Cookie[] hvals = request.getCookies();
         Cookie[] pvals = ((ActionRequest)portletReq).getCookies();
         HashSet<Cookie> hsc = new HashSet<Cookie>(Arrays.asList(hvals));
         HashSet<Cookie> psc = new HashSet<Cookie>(Arrays.asList(pvals));
         CompareUtils.setsEqual("cookies from HttpServletRequest", hsc, "cookies from from ActionRequest", psc, tr7);
      } catch(Exception e) {tr7.appendTcDetail(e.toString());}
      tr7.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getDateHeader */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getDateHeader must return a value          */
      /* corresponding to that returned by ActionRequest.getProperty for      */
      /* the corresponding header name"                                       */
      TestResult tr8 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETDATEHEADER);
      try {
         long hval = request.getDateHeader(DATE_HEADER);
         String pstr = portletReq.getProperty(DATE_HEADER);
         long pval = (pstr == null) ? -1 : Long.parseLong(pstr);
         boolean ok = (hval == pval);
         if (!ok) {
            String str = DATE_HEADER + " from HttpServletRequest: " + hval + ", did not equal " + pval + " from ActionRequest";
            tr8.appendTcDetail(str);
         }
         tr8.setTcSuccess(ok);
      } catch(Exception e) {tr8.appendTcDetail(e.toString());}
      tr8.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getHeader */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getHeader must return a value              */
      /* corresponding to that returned by ActionRequest.getProperty for      */
      /* the corresponding header name"                                       */
      TestResult tr9 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETHEADER);
      try {
         String hval = request.getHeader(ACCEPT_HEADER);
         String pval = portletReq.getProperty(ACCEPT_HEADER);
         CompareUtils.stringsEqual("HttpServletRequest", hval, "ActionRequest", pval, tr9);
      } catch(Exception e) {tr9.appendTcDetail(e.toString());}
      tr9.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getHeaderNames */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* Enumeration returned by HttpServletRequest.getHeaderNames must be    */
      /* contained in the Enumeration returned by                             */
      /* ActionRequest.getPropertyNames"                                      */
      TestResult tr10 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETHEADERNAMES);
      try {
         // he must be contained in pe 
         Enumeration<String> he = request.getHeaderNames();
         Enumeration<String> pe = portletReq.getPropertyNames();
         HashSet<String> hs = new HashSet<String>();
         while (he.hasMoreElements()) {
            hs.add(he.nextElement());
         }
         HashSet<String> ps = new HashSet<String>();
         while (pe.hasMoreElements()) {
            ps.add(pe.nextElement());
         }
         boolean ok = ps.containsAll(hs);
         if (!ok) {
            hs.removeAll(ps);
            String str = "The following headers from HttpServletRequest are not contained in ActionRequest: ";
            for (String h : hs) {;
               str += "\"" + h + "\", ";
            };
            tr10.appendTcDetail(str);
         }
         tr10.setTcSuccess(ok);
      } catch(Exception e) {tr10.appendTcDetail(e.toString());}
      tr10.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getHeaders */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getHeaders must return a value             */
      /* corresponding to that returned by ActionRequest.getProperties for    */
      /* the corresponding header name"                                       */
      TestResult tr11 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETHEADERS);
      try {
         Enumeration<String> he = request.getHeaders(ACCEPT_LANG_HEADER);
         Enumeration<String> pe = portletReq.getProperties(ACCEPT_LANG_HEADER);
         CompareUtils.enumsEqual("HttpServletRequest parameter names", he, "ActionRequest parameter names", pe,tr11);
      } catch(Exception e) {tr11.appendTcDetail(e.toString());}
      tr11.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getIntHeader */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getIntHeader must return a value           */
      /* corresponding to that returned by ActionRequest.getProperty for      */
      /* the corresponding header name"                                       */
      TestResult tr12 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETINTHEADER);
      try {
         int hval = request.getIntHeader(CONTENT_LENGTH_HEADER);
         String pstr = portletReq.getProperty(CONTENT_LENGTH_HEADER);
         int pval = (pstr == null) ? -1 : Integer.parseInt(pstr);
         boolean ok = (hval == pval);
         if (!ok) {
            String str = CONTENT_LENGTH_HEADER + " from HttpServletRequest: " + hval + ", did not equal " + pval + " from ActionRequest";
            tr12.appendTcDetail(str);
         }
         tr12.setTcSuccess(ok);
      } catch(Exception e) {tr12.appendTcDetail(e.toString());}
      tr12.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getLocalAddr */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getLocalAddr must return null"             */
      TestResult tr13 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETLOCALADDR);
      try {
         String isval = request.getLocalAddr();
         CompareUtils.stringsEqual(isval, null, tr13);
      } catch(Exception e) {tr13.appendTcDetail(e.toString());}
      tr13.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getLocalName */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getLocalName must return null"             */
      TestResult tr14 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETLOCALNAME);
      try {
         String isval = request.getLocalName();
         CompareUtils.stringsEqual(isval, null, tr14);
      } catch(Exception e) {tr14.appendTcDetail(e.toString());}
      tr14.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getLocalPort */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getLocalPort must return 0"                */
      TestResult tr15 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETLOCALPORT);
      try {
         int isval = request.getLocalPort();
         if (isval != 0) tr15.appendTcDetail("Returned value was: " + isval);
         tr15.setTcSuccess(isval == 0);
      } catch(Exception e) {tr15.appendTcDetail(e.toString());}
      tr15.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getLocale */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getLocale must provide the same            */
      /* functionality as ActionRequest.getLocale"                            */
      TestResult tr16 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETLOCALE);
      try {
         Locale hl = request.getLocale();
         Locale pl = portletReq.getLocale();
         String hval = hl.getDisplayName();
         String pval = pl.getDisplayName();
         CompareUtils.stringsEqual("HttpServletRequest", hval, "ActionRequest", pval, tr16);
      } catch(Exception e) {tr16.appendTcDetail(e.toString());}
      tr16.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getLocales */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getLocales must provide the same           */
      /* functionality as ActionRequest.getLocales"                           */
      TestResult tr17 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETLOCALES);
      try {
         Enumeration<Locale> he = request.getLocales();
         Enumeration<Locale> pe = portletReq.getLocales();
         CompareUtils.enumsEqual("HttpServletRequest locales", he, "ActionRequest locales", pe,tr17);
      } catch(Exception e) {tr17.appendTcDetail(e.toString());}
      tr17.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getMethod */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getMethod must provide the same            */
      /* functionality as ActionRequest.getMethod"                            */
      TestResult tr18 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETMETHOD);
      try {
         String hval = request.getMethod();
         String pval = ((ActionRequest)portletReq).getMethod();
         CompareUtils.stringsEqual("HttpServletRequest", hval, "ActionRequest", pval, tr18);
      } catch(Exception e) {tr18.appendTcDetail(e.toString());}
      tr18.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getParameter */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getParameter must provide the same         */
      /* functionality as ActionRequest.getParameter"                         */
      TestResult tr19 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETPARAMETER);
      try {
         // TestSetupLink
         String val = portletReq.getParameter(PARM_NAME);
         if (val != null) {
            String hval = request.getParameter(PARM_NAME);
            String pval = portletReq.getParameter(PARM_NAME);
            CompareUtils.stringsEqual("HttpServletRequest", hval, "ActionRequest", pval, tr19);
            tr19.writeTo(writer);
         }
      } catch(Exception e) {tr19.appendTcDetail(e.toString());}

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getParameterMap */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getParameterMap must provide the same      */
      /* functionality as ActionRequest.getParameterMap"                      */
      TestResult tr20 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETPARAMETERMAP);
      try {
         // TestSetupLink
         String val = portletReq.getParameter(PARM_NAME);
         if (val != null) {
            Map<String, String[]> hmap = request.getParameterMap();
            Map<String, String[]> pmap = portletReq.getParameterMap();
            CompareUtils.mapsEqual("map from HttpServletRequest", hmap, "map from ActionRequest", pmap, tr20);
            tr20.writeTo(writer);
         }
      } catch(Exception e) {tr20.appendTcDetail(e.toString());}

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getParameterNames */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getParameterNames must provide the same    */
      /* functionality as ActionRequest.getParameterNames"                    */
      TestResult tr21 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETPARAMETERNAMES);
      try {
         // TestSetupLink
         String val = portletReq.getParameter(PARM_NAME);
         if (val != null) {
            Enumeration<String> he = request.getParameterNames();
            Enumeration<String> pe = portletReq.getParameterNames();
            CompareUtils.enumsEqual("HttpServletRequest parameter names", he, "ActionRequest parameter names", pe,tr21);
            tr21.writeTo(writer);
         }
      } catch(Exception e) {tr21.appendTcDetail(e.toString());}

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getParameterValues */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getParameterValues must provide the same   */
      /* functionality as ActionRequest.getParameterValues"                   */
      TestResult tr22 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETPARAMETERVALUES);
      try {
         // TestSetupLink
         String val = portletReq.getParameter(PARM_NAME);
         if (val != null) {
            String[] hvals = request.getParameterValues(PARM_NAME);
            String[] pvals = portletReq.getParameterValues(PARM_NAME);
            String hval = ((hvals==null) ? "null" : hvals[0]);
            String pval = ((pvals==null) ? "null" : pvals[0]);
            CompareUtils.stringsEqual("HttpServletRequest", hval, "ActionRequest", pval, tr22);
            tr22.writeTo(writer);
         }
      } catch(Exception e) {tr22.appendTcDetail(e.toString());}

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getPathInfo */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getPathInfo must a value corresponding     */
      /* to the path used to obtain the PortletRequestDispatcher"             */
      TestResult tr23 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETPATHINFO);
      try {
         String hval = request.getPathInfo();
         String pval = null;
         CompareUtils.stringsEqual("HttpServletRequest", hval, " defined: ", pval, tr23);
      } catch(Exception e) {tr23.appendTcDetail(e.toString());}
      tr23.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getPathTranslated */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getPathTranslated must a value             */
      /* corresponding to the path used to obtain the                         */
      /* PortletRequestDispatcher"                                            */
      TestResult tr24 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETPATHTRANSLATED);
      try {
         String hval = request.getPathTranslated();
         String pval = null;
         CompareUtils.stringsEqual("HttpServletRequest", hval, " defined: ", pval, tr24);
      } catch(Exception e) {tr24.appendTcDetail(e.toString());}
      tr24.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getProtocol */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getProtocol must return \"HTTP/1.1\""      */
      TestResult tr25 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETPROTOCOL);
      try {
         String isval = request.getProtocol();
         CompareUtils.stringsEqual(isval, "HTTP/1.1", tr25);
      } catch(Exception e) {tr25.appendTcDetail(e.toString());}
      tr25.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getQueryString */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getQueryString must a value                */
      /* corresponding to the query string information used to obtain the     */
      /* PortletRequestDispatcher"                                            */
      TestResult tr26 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETQUERYSTRING);
      try {
         String hval = request.getQueryString();
         String pval = QUERY_STRING;
         CompareUtils.stringsEqual("HttpServletRequest", hval, " defined: ", pval, tr26);
      } catch(Exception e) {tr26.appendTcDetail(e.toString());}
      tr26.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getRealPath */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getRealPath must return null"              */
      TestResult tr27 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETREALPATH);
      try {
         String isval = request.getRealPath("/WEB-INF/portlet.xml");
         CompareUtils.stringsEqual(isval, null, tr27);
      } catch(Exception e) {tr27.appendTcDetail(e.toString());}
      tr27.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getRemoteAddr */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getRemoteAddr must return null"            */
      TestResult tr28 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETREMOTEADDR);
      try {
         String isval = request.getRemoteAddr();
         CompareUtils.stringsEqual(isval, null, tr28);
      } catch(Exception e) {tr28.appendTcDetail(e.toString());}
      tr28.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getRemoteHost */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getRemoteHost must return null"            */
      TestResult tr29 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETREMOTEHOST);
      try {
         String isval = request.getRemoteHost();
         CompareUtils.stringsEqual(isval, null, tr29);
      } catch(Exception e) {tr29.appendTcDetail(e.toString());}
      tr29.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getRemotePort */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getRemotePort must return 0"               */
      TestResult tr30 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETREMOTEPORT);
      try {
         int isval = request.getRemotePort();
         if (isval != 0) tr30.appendTcDetail("Returned value was: " + isval);
         tr30.setTcSuccess(isval == 0);
      } catch(Exception e) {tr30.appendTcDetail(e.toString());}
      tr30.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getRemoteUser */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getRemoteUser must provide the same        */
      /* functionality as ActionRequest.getRemoteUser"                        */
      TestResult tr31 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETREMOTEUSER);
      try {
         String hval = request.getRemoteUser();
         String pval = ((ActionRequest)portletReq).getRemoteUser();
         CompareUtils.stringsEqual("HttpServletRequest", hval, "ActionRequest", pval, tr31);
      } catch(Exception e) {tr31.appendTcDetail(e.toString());}
      tr31.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getRequestDispatcher */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getRequestDispatcher must provide          */
      /* functionality as defined in the servlet specification"               */
      TestResult tr32 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETREQUESTDISPATCHER);
      try {
         String sname = JSP_PREFIX + "DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest" + JSP_SUFFIX;
         RequestDispatcher hval = request.getRequestDispatcher(sname);
         if (hval == null) {
            tr32.appendTcDetail("Could not obtain request dispatcher for " + sname);
         }
         tr32.setTcSuccess(hval != null);
      } catch(Exception e) {tr32.appendTcDetail(e.toString());}
      tr32.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getRequestURI */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getRequestURI must a value corresponding   */
      /* to the path and query string information used to obtain the          */
      /* PortletRequestDispatcher"                                            */
      TestResult tr33 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETREQUESTURI);
      try {
         String sname = JSP_PREFIX + "DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest" + JSP_SUFFIX;
         String hval = request.getRequestURI();
         if (!hval.contains(sname)) {
            tr33.appendTcDetail("Request URI " + hval + " does not contain " + sname);
         }
         tr33.setTcSuccess(hval.contains(sname));
      } catch(Exception e) {tr33.appendTcDetail(e.toString());}
      tr33.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getRequestURL */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getRequestURL must return null"            */
      TestResult tr34 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETREQUESTURL);
      try {
         StringBuffer isval = request.getRequestURL();
         if (isval != null) tr34.appendTcDetail("Request URL is " + isval.toString());
         tr34.setTcSuccess(isval == null);
      } catch(Exception e) {tr34.appendTcDetail(e.toString());}
      tr34.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getRequestedSessionId */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getRequestedSessionId must provide the     */
      /* same functionality as ActionRequest.getRequestedSessionId"           */
      TestResult tr35 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETREQUESTEDSESSIONID);
      try {
         String hval = request.getRequestedSessionId();
         String pval = ((ActionRequest)portletReq).getRequestedSessionId();
         CompareUtils.stringsEqual("HttpServletRequest", hval, "ActionRequest", pval, tr35);
      } catch(Exception e) {tr35.appendTcDetail(e.toString());}
      tr35.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getScheme */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getScheme must provide the same            */
      /* functionality as ActionRequest.getScheme"                            */
      TestResult tr36 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETSCHEME);
      try {
         String hval = request.getScheme();
         String pval = ((ActionRequest)portletReq).getScheme();
         CompareUtils.stringsEqual("HttpServletRequest", hval, "ActionRequest", pval, tr36);
      } catch(Exception e) {tr36.appendTcDetail(e.toString());}
      tr36.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getServerName */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getServerName must provide the same        */
      /* functionality as ActionRequest.getServerName"                        */
      TestResult tr37 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETSERVERNAME);
      try {
         String hval = request.getServerName();
         String pval = ((ActionRequest)portletReq).getServerName();
         CompareUtils.stringsEqual("HttpServletRequest", hval, "ActionRequest", pval, tr37);
      } catch(Exception e) {tr37.appendTcDetail(e.toString());}
      tr37.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getServerPort */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getServerPort must provide the same        */
      /* functionality as ActionRequest.getServerPort"                        */
      TestResult tr38 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETSERVERPORT);
      try {
         int hval = request.getServerPort();
         int pval = ((ActionRequest)portletReq).getServerPort();
         String str = "Value " + hval + " from " + "HttpServletRequest" + " does not equal value " + pval + " + ActionRequest";
         if (hval != pval) {
            tr38.appendTcDetail(str);
         }
         tr38.setTcSuccess(hval == pval);
      } catch(Exception e) {tr38.appendTcDetail(e.toString());}
      tr38.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getServletPath */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getServletPath must a value                */
      /* corresponding to the path used to obtain the                         */
      /* PortletRequestDispatcher"                                            */
      TestResult tr39 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETSERVLETPATH);
      try {
         String sname = JSP_PREFIX + "DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest" + JSP_SUFFIX;
         String hval = request.getServletPath();
         String pval = sname;
         CompareUtils.stringsEqual("HttpServletRequest", hval, " defined: ", pval, tr39);
      } catch(Exception e) {tr39.appendTcDetail(e.toString());}
      tr39.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getSession */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getSession must provide the same           */
      /* functionality as                                                     */
      /* ActionRequest.getPortletSession(APPLICATION_SCOPE)"                  */
      TestResult tr40 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETSESSION);
      try {
         HttpSession hval = request.getSession();
         if (hval == null) {
            tr40.appendTcDetail("Could not get session from HttpServletRequest");
         }
         tr40.setTcSuccess(hval != null);
      } catch(Exception e) {tr40.appendTcDetail(e.toString());}
      tr40.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getUserPrincipal */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getUserPrincipal must provide the same     */
      /* functionality as ActionRequest.getUserPrincipal"                     */
      TestResult tr41 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETUSERPRINCIPAL);
      try {
         java.security.Principal hpal = request.getUserPrincipal();
         java.security.Principal ppal = ((ActionRequest)portletReq).getUserPrincipal();
         String str = "Value " + hpal.toString() + " from " + "HttpServletRequest" + " does not equal value " + ppal.toString() + " + ActionRequest";
         if (!hpal.equals(ppal)) {
            tr41.appendTcDetail(str);
         }
         tr41.setTcSuccess(hpal.equals(ppal));
      } catch(Exception e) {tr41.appendTcDetail(e.toString());}
      tr41.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_isRequestedSessionIdValid */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.isRequestedSessionIdValid must provide     */
      /* the same functionality as ActionRequest.isRequestedSessionIdValid"   */
      TestResult tr42 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_ISREQUESTEDSESSIONIDVALID);
      try {
         boolean hval = request.isRequestedSessionIdValid();
         boolean pval = ((ActionRequest)portletReq).isRequestedSessionIdValid();
         String str = "Value " + hval + " from " + "HttpServletRequest" + " does not equal value " + pval + " + ActionRequest";
         if (hval != pval) {
            tr42.appendTcDetail(str);
         }
         tr42.setTcSuccess(hval == pval);
      } catch(Exception e) {tr42.appendTcDetail(e.toString());}
      tr42.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_isSecure */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.isSecure must provide the same             */
      /* functionality as ActionRequest.isSecure"                             */
      TestResult tr43 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_ISSECURE);
      try {
         boolean hval = request.isSecure();
         boolean pval = ((ActionRequest)portletReq).isSecure();
         String str = "Value " + hval + " from " + "HttpServletRequest" + " does not equal value " + pval + " + ActionRequest";
         if (hval != pval) {
            tr43.appendTcDetail(str);
         }
         tr43.setTcSuccess(hval == pval);
      } catch(Exception e) {tr43.appendTcDetail(e.toString());}
      tr43.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_isUserInRole */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.isUserInRole must provide the same         */
      /* functionality as ActionRequest.isUserInRole"                         */
      TestResult tr44 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_ISUSERINROLE);
      try {
         boolean hval = request.isUserInRole(ROLE_NAME);
         boolean pval = ((ActionRequest)portletReq).isUserInRole(ROLE_NAME);
         String str = "Value " + hval + " from " + "HttpServletRequest" + " does not equal value " + pval + " + ActionRequest";
         if (hval != pval) {
            tr44.appendTcDetail(str);
         }
         tr44.setTcSuccess(hval == pval);
      } catch(Exception e) {tr44.appendTcDetail(e.toString());}
      tr44.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_removeAttribute */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.removeAttribute must provide the same      */
      /* functionality as ActionRequest.removeAttribute"                      */
      TestResult tr45 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_REMOVEATTRIBUTE);
      try {
         String hname = ATTR_PREFIX + "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_removeAttribute1";
         String pname = ATTR_PREFIX + "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_removeAttribute2";
         request.setAttribute(hname, "Value");
         portletReq.setAttribute(pname, "Value");
         request.removeAttribute(hname);
         portletReq.removeAttribute(pname);
         String hval = (String)request.getAttribute(hname);
         String pval = (String)portletReq.getAttribute(pname);
         boolean ok = (hval == null) && (pval == null);
         String str = "";
         if (!ok) {;
            if (hval != null) str += "Attribute could not be removed through HttpServletRequest." ;
            if (pval != null) str += "Attribute could not be removed through ActionRequest." ;
            tr45.appendTcDetail(str);
         };
         tr45.setTcSuccess(ok);
      } catch(Exception e) {tr45.appendTcDetail(e.toString());}
      tr45.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_setAttribute */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.setAttribute must provide the same         */
      /* functionality as ActionRequest.setAttribute"                         */
      TestResult tr46 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_SETATTRIBUTE);
      try {
         String hname = ATTR_PREFIX + "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_setAttribute1";
         String pname = ATTR_PREFIX + "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_setAttribute2";
         request.setAttribute(hname, "Value");
         portletReq.setAttribute(pname, "Value");
         String hval = (String)request.getAttribute(hname);
         String pval = (String)portletReq.getAttribute(pname);
         request.removeAttribute(hname);
         portletReq.removeAttribute(pname);
         boolean ok = (hval.equals("Value") && pval.equals("Value")) ;
         String str = "";
         if (!ok) {;
            if (!hval.equals("Value")) str += "Attribute could not be set/read through HttpServletRequest." ;
            if (!pval.equals("Value")) str += "Attribute could not be set/read through ActionRequest." ;
            tr46.appendTcDetail(str);
         };
         tr46.setTcSuccess(ok);
      } catch(Exception e) {tr46.appendTcDetail(e.toString());}
      tr46.writeTo(writer);

      request.getSession().setAttribute(
                   Constants.RESULT_ATTR_PREFIX + "DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest",
                   writer.toString());
%>
