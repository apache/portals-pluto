/*  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */


package javax.portlet.tck.servlets;

import java.io.*;
import java.util.*;
import java.util.logging.*;
import static java.util.logging.Logger.*;
import javax.portlet.*;
import javax.portlet.filter.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.portlet.tck.beans.*;
import javax.portlet.tck.constants.*;
import static javax.portlet.tck.constants.Constants.*;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.*;

/**
 * Servlet for JSR 362 request dispatcher testing.
 * Used by portlet: DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest
 *
 * @author nick
 *
 */
public class DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_servlet extends HttpServlet {
   private static final String LOG_CLASS = 
         DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_servlet.class.getName();
   private final Logger LOGGER = Logger.getLogger(LOG_CLASS);

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp)
         throws ServletException, IOException {
      processTCKReq(req, resp);
   }

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp)
         throws ServletException, IOException {
      processTCKReq(req, resp);
   }

   // The tck uses only get & post requests
   protected void processTCKReq(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      LOGGER.entering(LOG_CLASS, "servlet entry");

      PortletRequest portletReq = (PortletRequest) request.getAttribute("javax.portlet.request");
      PortletResponse portletResp = (PortletResponse) request.getAttribute("javax.portlet.response");
      PortletConfig portletConfig = (PortletConfig) request.getAttribute("javax.portlet.config");
      long svtTid = Thread.currentThread().getId();
      long reqTid = (Long) portletReq.getAttribute(THREADID_ATTR);

      StringWriter writer = new StringWriter();

      JSR286DispatcherReqRespTestCaseDetails tcd = new JSR286DispatcherReqRespTestCaseDetails();

      // Create result objects for the tests

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getAttribute */
      /* Details: "In a target servlet of a include in the Event phase, the   */
      /* method HttpServletRequest.getAttribute must provide the same         */
      /* functionality as EventRequest.getAttribute"                          */
      TestResult tr0 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETATTRIBUTE);
      try {
         String ha = (String)request.getAttribute(ATTR_PREFIX + "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getAttribute");
         String pa = (String)portletReq.getAttribute(ATTR_PREFIX + "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getAttribute");
         CompareUtils.stringsEqual(ha, pa, tr0);
      } catch(Exception e) {tr0.appendTcDetail(e.toString());}
      tr0.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getAttributeNames */
      /* Details: "In a target servlet of a include in the Event phase, the   */
      /* method HttpServletRequest.getAttributeNames must provide the same    */
      /* functionality as EventRequest.getAttributeNames"                     */
      TestResult tr1 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETATTRIBUTENAMES);
      try {
         Enumeration<String> he = request.getAttributeNames();
         Enumeration<String> pe = portletReq.getAttributeNames();
         CompareUtils.enumsEqual("HttpServletRequest attribute names", he, "EventRequest attribute names", pe,tr1);
      } catch(Exception e) {tr1.appendTcDetail(e.toString());}
      tr1.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getAuthType */
      /* Details: "In a target servlet of a include in the Event phase, the   */
      /* method HttpServletRequest.getAuthType must provide the same          */
      /* functionality as EventRequest.getAuthType"                           */
      TestResult tr2 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETAUTHTYPE);
      /* TODO: implement test */
      tr2.appendTcDetail("Not implemented.");
      tr2.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getCharacterEncoding */
      /* Details: "In a target servlet of a include in the Event phase, the   */
      /* method HttpServletRequest.getCharacterEncoding must return null"     */
      TestResult tr3 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETCHARACTERENCODING);
      try {
         String isval = request.getCharacterEncoding();
         CompareUtils.stringsEqual(isval, null, tr3);
      } catch(Exception e) {tr3.appendTcDetail(e.toString());}
      tr3.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getContentLength */
      /* Details: "In a target servlet of a include in the Event phase, the   */
      /* method HttpServletRequest.getContentLength must return 0"            */
      TestResult tr4 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETCONTENTLENGTH);
      try {
         int isval = request.getContentLength();
         if (isval != 0) tr4.appendTcDetail("Returned value was: " + isval);
         tr4.setTcSuccess(isval == 0);
      } catch(Exception e) {tr4.appendTcDetail(e.toString());}
      tr4.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getContentType */
      /* Details: "In a target servlet of a include in the Event phase, the   */
      /* method HttpServletRequest.getContentType must return null"           */
      TestResult tr5 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETCONTENTTYPE);
      try {
         String isval = request.getContentType();
         CompareUtils.stringsEqual(isval, null, tr5);
      } catch(Exception e) {tr5.appendTcDetail(e.toString());}
      tr5.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getContextPath */
      /* Details: "In a target servlet of a include in the Event phase, the   */
      /* method HttpServletRequest.getContextPath must provide the same       */
      /* functionality as EventRequest.getContextPath"                        */
      TestResult tr6 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETCONTEXTPATH);
      /* TODO: implement test */
      tr6.appendTcDetail("Not implemented.");
      tr6.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getCookies */
      /* Details: "In a target servlet of a include in the Event phase, the   */
      /* method HttpServletRequest.getCookies must provide the same           */
      /* functionality as EventRequest.getCookies"                            */
      TestResult tr7 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETCOOKIES);
      /* TODO: implement test */
      tr7.appendTcDetail("Not implemented.");
      tr7.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getDateHeader */
      /* Details: "In a target servlet of a include in the Event phase, the   */
      /* method HttpServletRequest.getDateHeader must return a value          */
      /* corresponding to that returned by EventRequest.getProperty for the   */
      /* corresponding header name"                                           */
      TestResult tr8 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETDATEHEADER);
      /* TODO: implement test */
      tr8.appendTcDetail("Not implemented.");
      tr8.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getHeader */
      /* Details: "In a target servlet of a include in the Event phase, the   */
      /* method HttpServletRequest.getHeader must return a value              */
      /* corresponding to that returned by EventRequest.getProperty for the   */
      /* corresponding header name"                                           */
      TestResult tr9 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETHEADER);
      /* TODO: implement test */
      tr9.appendTcDetail("Not implemented.");
      tr9.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getHeaderNames */
      /* Details: "In a target servlet of a include in the Event phase, the   */
      /* Enumeration returned by HttpServletRequest.getHeaderNames must be    */
      /* contained in the Enumeration returned by                             */
      /* EventRequest.getPropertyNames"                                       */
      TestResult tr10 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETHEADERNAMES);
      /* TODO: implement test */
      tr10.appendTcDetail("Not implemented.");
      tr10.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getHeaders */
      /* Details: "In a target servlet of a include in the Event phase, the   */
      /* method HttpServletRequest.getHeaders must return a value             */
      /* corresponding to that returned by EventRequest.getProperty for the   */
      /* corresponding header name"                                           */
      TestResult tr11 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETHEADERS);
      /* TODO: implement test */
      tr11.appendTcDetail("Not implemented.");
      tr11.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getInputStream */
      /* Details: "In a target servlet of a include in the Event phase, the   */
      /* method HttpServletRequest.getInputStream must return null"           */
      TestResult tr12 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETINPUTSTREAM);
      try {
         ServletInputStream isval = request.getInputStream();
         tr12.setTcSuccess(isval == null);
      } catch(Exception e) {tr12.appendTcDetail(e.toString());}
      tr12.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getIntHeader */
      /* Details: "In a target servlet of a include in the Event phase, the   */
      /* method HttpServletRequest.getIntHeader must return a value           */
      /* corresponding to that returned by EventRequest.getProperty for the   */
      /* corresponding header name"                                           */
      TestResult tr13 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETINTHEADER);
      /* TODO: implement test */
      tr13.appendTcDetail("Not implemented.");
      tr13.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getLocalAddr */
      /* Details: "In a target servlet of a include in the Event phase, the   */
      /* method HttpServletRequest.getLocalAddr must return null"             */
      TestResult tr14 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETLOCALADDR);
      try {
         String isval = request.getLocalAddr();
         CompareUtils.stringsEqual(isval, null, tr14);
      } catch(Exception e) {tr14.appendTcDetail(e.toString());}
      tr14.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getLocalName */
      /* Details: "In a target servlet of a include in the Event phase, the   */
      /* method HttpServletRequest.getLocalName must return null"             */
      TestResult tr15 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETLOCALNAME);
      try {
         String isval = request.getLocalName();
         CompareUtils.stringsEqual(isval, null, tr15);
      } catch(Exception e) {tr15.appendTcDetail(e.toString());}
      tr15.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getLocalPort */
      /* Details: "In a target servlet of a include in the Event phase, the   */
      /* method HttpServletRequest.getLocalPort must return 0"                */
      TestResult tr16 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETLOCALPORT);
      try {
         int isval = request.getLocalPort();
         if (isval != 0) tr16.appendTcDetail("Returned value was: " + isval);
         tr16.setTcSuccess(isval == 0);
      } catch(Exception e) {tr16.appendTcDetail(e.toString());}
      tr16.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getLocale */
      /* Details: "In a target servlet of a include in the Event phase, the   */
      /* method HttpServletRequest.getLocale must provide the same            */
      /* functionality as EventRequest.getLocale"                             */
      TestResult tr17 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETLOCALE);
      try {
         Locale hl = request.getLocale();
         Locale pl = portletReq.getLocale();
         CompareUtils.stringsEqual(hl.getDisplayName(), pl.getDisplayName(), tr17);
      } catch(Exception e) {tr17.appendTcDetail(e.toString());}
      tr17.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getLocales */
      /* Details: "In a target servlet of a include in the Event phase, the   */
      /* method HttpServletRequest.getLocales must provide the same           */
      /* functionality as EventRequest.getLocales"                            */
      TestResult tr18 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETLOCALES);
      try {
         Enumeration<Locale> he = request.getLocales();
         Enumeration<Locale> pe = portletReq.getLocales();
         CompareUtils.enumsEqual("HttpServletRequest locales", he, "EventRequest locales", pe,tr18);
      } catch(Exception e) {tr18.appendTcDetail(e.toString());}
      tr18.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getMethod */
      /* Details: "In a target servlet of a include in the Event phase, the   */
      /* method HttpServletRequest.getMethod must provide the same            */
      /* functionality as EventRequest.getMethod"                             */
      TestResult tr19 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETMETHOD);
      /* TODO: implement test */
      tr19.appendTcDetail("Not implemented.");
      tr19.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getParameter */
      /* Details: "In a target servlet of a include in the Event phase, the   */
      /* method HttpServletRequest.getParameter must provide the same         */
      /* functionality as EventRequest.getParameter"                          */
      TestResult tr20 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETPARAMETER);
      try {
         // TestSetupLink
         String val = portletReq.getParameter(PARM_PREFIX + "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getParameter");
         if (val != null) {
            String hval = request.getParameter(PARM_PREFIX + "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getParameter");
            String pval = portletReq.getParameter(PARM_PREFIX + "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getParameter");
            CompareUtils.stringsEqual(hval, pval, tr20);
            tr20.writeTo(writer);
         }
      } catch(Exception e) {tr20.appendTcDetail(e.toString());}

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getParameterMap */
      /* Details: "In a target servlet of a include in the Event phase, the   */
      /* method HttpServletRequest.getParameterMap must provide the same      */
      /* functionality as EventRequest.getParameterMap"                       */
      TestResult tr21 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETPARAMETERMAP);
      try {
         // TestSetupLink
         String val = portletReq.getParameter(PARM_PREFIX + "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getParameterMap");
         if (val != null) {
            Map<String, String[]> hmap = request.getParameterMap();
            Map<String, String[]> pmap = portletReq.getParameterMap();
            CompareUtils.mapsEqual("map from HttpServletRequest", hmap, "map from EventRequest", pmap, tr21);
            tr21.writeTo(writer);
         }
      } catch(Exception e) {tr21.appendTcDetail(e.toString());}

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getParameterNames */
      /* Details: "In a target servlet of a include in the Event phase, the   */
      /* method HttpServletRequest.getParameterNames must provide the same    */
      /* functionality as EventRequest.getParameterNames"                     */
      TestResult tr22 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETPARAMETERNAMES);
      try {
         // TestSetupLink
         String val = portletReq.getParameter(PARM_PREFIX + "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getParameterNames");
         if (val != null) {
            Enumeration<String> he = request.getParameterNames();
            Enumeration<String> pe = portletReq.getParameterNames();
            CompareUtils.enumsEqual("HttpServletRequest parameter names", he, "EventRequest parameter names", pe,tr22);
            tr22.writeTo(writer);
         }
      } catch(Exception e) {tr22.appendTcDetail(e.toString());}

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getParameterValues */
      /* Details: "In a target servlet of a include in the Event phase, the   */
      /* method HttpServletRequest.getParameterValues must provide the same   */
      /* functionality as EventRequest.getParameterValues"                    */
      TestResult tr23 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETPARAMETERVALUES);
      try {
         // TestSetupLink
         String val = portletReq.getParameter(PARM_PREFIX + "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getParameterValues");
         if (val != null) {
            String[] hvals = request.getParameterValues(PARM_PREFIX + "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getParameterValues");
            String[] pvals = portletReq.getParameterValues(PARM_PREFIX + "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getParameterValues");
            CompareUtils.stringsEqual(hvals[0], pvals[0], tr23);
            tr23.writeTo(writer);
         }
      } catch(Exception e) {tr23.appendTcDetail(e.toString());}

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getPathInfo */
      /* Details: "In a target servlet of a include in the Event phase, the   */
      /* method HttpServletRequest.getPathInfo must a value corresponding     */
      /* to the path used to obtain the PortletRequestDispatcher"             */
      TestResult tr24 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETPATHINFO);
      /* TODO: implement test */
      tr24.appendTcDetail("Not implemented.");
      tr24.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getPathTranslated */
      /* Details: "In a target servlet of a include in the Event phase, the   */
      /* method HttpServletRequest.getPathTranslated must a value             */
      /* corresponding to the path used to obtain the                         */
      /* PortletRequestDispatcher"                                            */
      TestResult tr25 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETPATHTRANSLATED);
      /* TODO: implement test */
      tr25.appendTcDetail("Not implemented.");
      tr25.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getProtocol */
      /* Details: "In a target servlet of a include in the Event phase, the   */
      /* method HttpServletRequest.getProtocol must return \"HTTP/1.1\""      */
      TestResult tr26 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETPROTOCOL);
      try {
         String isval = request.getProtocol();
         CompareUtils.stringsEqual(isval, "HTTP/1.1", tr26);
      } catch(Exception e) {tr26.appendTcDetail(e.toString());}
      tr26.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getQueryString */
      /* Details: "In a target servlet of a include in the Event phase, the   */
      /* method HttpServletRequest.getQueryString must a value                */
      /* corresponding to the query string information used to obtain the     */
      /* PortletRequestDispatcher"                                            */
      TestResult tr27 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETQUERYSTRING);
      /* TODO: implement test */
      tr27.appendTcDetail("Not implemented.");
      tr27.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getReader */
      /* Details: "In a target servlet of a include in the Event phase, the   */
      /* method HttpServletRequest.getReader must return null"                */
      TestResult tr28 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETREADER);
      try {
         BufferedReader isval = request.getReader();
         tr28.setTcSuccess(isval == null);
      } catch(Exception e) {tr28.appendTcDetail(e.toString());}
      tr28.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getRealPath */
      /* Details: "In a target servlet of a include in the Event phase, the   */
      /* method HttpServletRequest.getRealPath must return null"              */
      TestResult tr29 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETREALPATH);
      try {
         String isval = request.getRealPath("/WEB-INF/portlet.xml");
         CompareUtils.stringsEqual(isval, null, tr29);
      } catch(Exception e) {tr29.appendTcDetail(e.toString());}
      tr29.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getRemoteAddr */
      /* Details: "In a target servlet of a include in the Event phase, the   */
      /* method HttpServletRequest.getRemoteAddr must return null"            */
      TestResult tr30 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETREMOTEADDR);
      try {
         String isval = request.getRemoteAddr();
         CompareUtils.stringsEqual(isval, null, tr30);
      } catch(Exception e) {tr30.appendTcDetail(e.toString());}
      tr30.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getRemoteHost */
      /* Details: "In a target servlet of a include in the Event phase, the   */
      /* method HttpServletRequest.getRemoteHost must return null"            */
      TestResult tr31 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETREMOTEHOST);
      try {
         String isval = request.getRemoteHost();
         CompareUtils.stringsEqual(isval, null, tr31);
      } catch(Exception e) {tr31.appendTcDetail(e.toString());}
      tr31.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getRemotePort */
      /* Details: "In a target servlet of a include in the Event phase, the   */
      /* method HttpServletRequest.getRemotePort must return 0"               */
      TestResult tr32 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETREMOTEPORT);
      try {
         int isval = request.getRemotePort();
         if (isval != 0) tr32.appendTcDetail("Returned value was: " + isval);
         tr32.setTcSuccess(isval == 0);
      } catch(Exception e) {tr32.appendTcDetail(e.toString());}
      tr32.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getRemoteUser */
      /* Details: "In a target servlet of a include in the Event phase, the   */
      /* method HttpServletRequest.getRemoteUser must provide the same        */
      /* functionality as EventRequest.getRemoteUser"                         */
      TestResult tr33 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETREMOTEUSER);
      /* TODO: implement test */
      tr33.appendTcDetail("Not implemented.");
      tr33.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getRequestDispatcher */
      /* Details: "In a target servlet of a include in the Event phase, the   */
      /* method HttpServletRequest.getRequestDispatcher must provide          */
      /* functionality as defined in the servlet specification"               */
      TestResult tr34 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETREQUESTDISPATCHER);
      /* TODO: implement test */
      tr34.appendTcDetail("Not implemented.");
      tr34.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getRequestURI */
      /* Details: "In a target servlet of a include in the Event phase, the   */
      /* method HttpServletRequest.getRequestURI must a value corresponding   */
      /* to the path and query string information used to obtain the          */
      /* PortletRequestDispatcher"                                            */
      TestResult tr35 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETREQUESTURI);
      /* TODO: implement test */
      tr35.appendTcDetail("Not implemented.");
      tr35.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getRequestURL */
      /* Details: "In a target servlet of a include in the Event phase, the   */
      /* method HttpServletRequest.getRequestURL must return null"            */
      TestResult tr36 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETREQUESTURL);
      try {
         StringBuffer isval = request.getRequestURL();
         if (isval != null) tr36.appendTcDetail("Request URL is " + isval.toString());
         tr36.setTcSuccess(isval == null);
      } catch(Exception e) {tr36.appendTcDetail(e.toString());}
      tr36.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getRequestedSessionId */
      /* Details: "In a target servlet of a include in the Event phase, the   */
      /* method HttpServletRequest.getRequestedSessionId must provide the     */
      /* same functionality as EventRequest.getRequestedSessionId"            */
      TestResult tr37 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETREQUESTEDSESSIONID);
      /* TODO: implement test */
      tr37.appendTcDetail("Not implemented.");
      tr37.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getScheme */
      /* Details: "In a target servlet of a include in the Event phase, the   */
      /* method HttpServletRequest.getScheme must provide the same            */
      /* functionality as EventRequest.getScheme"                             */
      TestResult tr38 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETSCHEME);
      /* TODO: implement test */
      tr38.appendTcDetail("Not implemented.");
      tr38.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getServerName */
      /* Details: "In a target servlet of a include in the Event phase, the   */
      /* method HttpServletRequest.getServerName must provide the same        */
      /* functionality as EventRequest.getServerName"                         */
      TestResult tr39 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETSERVERNAME);
      /* TODO: implement test */
      tr39.appendTcDetail("Not implemented.");
      tr39.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getServerPort */
      /* Details: "In a target servlet of a include in the Event phase, the   */
      /* method HttpServletRequest.getServerPort must provide the same        */
      /* functionality as EventRequest.getServerPort"                         */
      TestResult tr40 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETSERVERPORT);
      /* TODO: implement test */
      tr40.appendTcDetail("Not implemented.");
      tr40.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getServletPath */
      /* Details: "In a target servlet of a include in the Event phase, the   */
      /* method HttpServletRequest.getServletPath must a value                */
      /* corresponding to the path used to obtain the                         */
      /* PortletRequestDispatcher"                                            */
      TestResult tr41 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETSERVLETPATH);
      /* TODO: implement test */
      tr41.appendTcDetail("Not implemented.");
      tr41.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getSession */
      /* Details: "In a target servlet of a include in the Event phase, the   */
      /* method HttpServletRequest.getSession must provide the same           */
      /* functionality as                                                     */
      /* EventRequest.getPortletSession(APPLICATION_SCOPE)"                   */
      TestResult tr42 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETSESSION);
      /* TODO: implement test */
      tr42.appendTcDetail("Not implemented.");
      tr42.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getUserPrincipal */
      /* Details: "In a target servlet of a include in the Event phase, the   */
      /* method HttpServletRequest.getUserPrincipal must provide the same     */
      /* functionality as EventRequest.getUserPrincipal"                      */
      TestResult tr43 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETUSERPRINCIPAL);
      /* TODO: implement test */
      tr43.appendTcDetail("Not implemented.");
      tr43.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_isRequestedSessionIdFromCookie */
      /* Details: "In a target servlet of a include in the Event phase, the   */
      /* method HttpServletRequest.isRequestedSessionIdFromCookie must        */
      /* provide functionality as defined in the servlet specification"       */
      TestResult tr44 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_ISREQUESTEDSESSIONIDFROMCOOKIE);
      /* TODO: implement test */
      tr44.appendTcDetail("Not implemented.");
      tr44.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_isRequestedSessionIdFromURL1 */
      /* Details: "In a target servlet of a include in the Event phase, the   */
      /* method HttpServletRequest.isRequestedSessionIdFromURL must provide   */
      /* functionality as defined in the servlet specification"               */
      TestResult tr45 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_ISREQUESTEDSESSIONIDFROMURL1);
      /* TODO: implement test */
      tr45.appendTcDetail("Not implemented.");
      tr45.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_isRequestedSessionIdFromUrl */
      /* Details: "In a target servlet of a include in the Event phase, the   */
      /* method HttpServletRequest.isRequestedSessionIdFromUrl must provide   */
      /* functionality as defined in the servlet specification"               */
      TestResult tr46 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_ISREQUESTEDSESSIONIDFROMURL);
      /* TODO: implement test */
      tr46.appendTcDetail("Not implemented.");
      tr46.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_isRequestedSessionIdValid */
      /* Details: "In a target servlet of a include in the Event phase, the   */
      /* method HttpServletRequest.isRequestedSessionIdValid must provide     */
      /* the same functionality as EventRequest.isRequestedSessionIdValid"    */
      TestResult tr47 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_ISREQUESTEDSESSIONIDVALID);
      /* TODO: implement test */
      tr47.appendTcDetail("Not implemented.");
      tr47.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_isSecure */
      /* Details: "In a target servlet of a include in the Event phase, the   */
      /* method HttpServletRequest.isSecure must provide the same             */
      /* functionality as EventRequest.isSecure"                              */
      TestResult tr48 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_ISSECURE);
      /* TODO: implement test */
      tr48.appendTcDetail("Not implemented.");
      tr48.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_isUserInRole */
      /* Details: "In a target servlet of a include in the Event phase, the   */
      /* method HttpServletRequest.isUserInRole must provide the same         */
      /* functionality as EventRequest.isUserInRole"                          */
      TestResult tr49 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_ISUSERINROLE);
      /* TODO: implement test */
      tr49.appendTcDetail("Not implemented.");
      tr49.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_removeAttribute */
      /* Details: "In a target servlet of a include in the Event phase, the   */
      /* method HttpServletRequest.removeAttribute must provide the same      */
      /* functionality as EventRequest.removeAttribute"                       */
      TestResult tr50 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_REMOVEATTRIBUTE);
      /* TODO: implement test */
      tr50.appendTcDetail("Not implemented.");
      tr50.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_setAttribute */
      /* Details: "In a target servlet of a include in the Event phase, the   */
      /* method HttpServletRequest.setAttribute must provide the same         */
      /* functionality as EventRequest.setAttribute"                          */
      TestResult tr51 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_SETATTRIBUTE);
      /* TODO: implement test */
      tr51.appendTcDetail("Not implemented.");
      tr51.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_setCharacterEncoding */
      /* Details: "In a target servlet of a include in the Event phase, the   */
      /* method HttpServletRequest.setCharacterEncoding does not perform      */
      /* any operation"                                                       */
      TestResult tr52 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_SETCHARACTERENCODING);
      /* TODO: implement test */
      tr52.appendTcDetail("Not implemented.");
      tr52.writeTo(writer);

      request.getSession().setAttribute(
                   Constants.RESULT_ATTR_PREFIX + "DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest",
                   writer.toString());

   }
}
