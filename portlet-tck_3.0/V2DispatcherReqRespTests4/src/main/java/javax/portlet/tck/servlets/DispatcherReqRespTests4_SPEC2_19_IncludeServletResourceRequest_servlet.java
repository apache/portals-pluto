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
 * Used by portlet: DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest
 *
 * @author nick
 *
 */
public class DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_servlet extends HttpServlet {
   private static final String LOG_CLASS = 
         DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_servlet.class.getName();
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

      PrintWriter writer = ((MimeResponse)portletResp).getWriter();

      JSR286DispatcherReqRespTestCaseDetails tcd = new JSR286DispatcherReqRespTestCaseDetails();

      // Create result objects for the tests

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getAttribute */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletRequest.getAttribute must provide the same     */
      /* functionality as ResourceRequest.getAttribute"                       */
      TestResult tr0 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETATTRIBUTE);
      try {
         String ha = (String)request.getAttribute(ATTR_PREFIX + "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getAttribute");
         String pa = (String)portletReq.getAttribute(ATTR_PREFIX + "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getAttribute");
         CompareUtils.stringsEqual(ha, pa, tr0);
      } catch(Exception e) {tr0.appendTcDetail(e.toString());}
      tr0.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getAttributeNames */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletRequest.getAttributeNames must provide the     */
      /* same functionality as ResourceRequest.getAttributeNames"             */
      TestResult tr1 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETATTRIBUTENAMES);
      try {
         Enumeration<String> he = request.getAttributeNames();
         Enumeration<String> pe = portletReq.getAttributeNames();
         CompareUtils.enumsEqual("HttpServletRequest attribute names", he, "ResourceRequest attribute names", pe,tr1);
      } catch(Exception e) {tr1.appendTcDetail(e.toString());}
      tr1.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getAuthType */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletRequest.getAuthType must provide the same      */
      /* functionality as ResourceRequest.getAuthType"                        */
      TestResult tr2 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETAUTHTYPE);
      /* TODO: implement test */
      tr2.appendTcDetail("Not implemented.");
      tr2.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getCharacterEncoding */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletRequest.getCharacterEncoding must provide      */
      /* the same functionality as ResourceRequest.getCharacterEncoding"      */
      TestResult tr3 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETCHARACTERENCODING);
      /* TODO: implement test */
      tr3.appendTcDetail("Not implemented.");
      tr3.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getContentLength */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletRequest.getContentLength must provide the      */
      /* same functionality as ResourceRequest.getContentLength"              */
      TestResult tr4 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETCONTENTLENGTH);
      /* TODO: implement test */
      tr4.appendTcDetail("Not implemented.");
      tr4.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getContentType */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletRequest.getContentType must provide the same   */
      /* functionality as ResourceRequest.getContentType"                     */
      TestResult tr5 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETCONTENTTYPE);
      /* TODO: implement test */
      tr5.appendTcDetail("Not implemented.");
      tr5.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getContextPath */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletRequest.getContextPath must provide the same   */
      /* functionality as ResourceRequest.getContextPath"                     */
      TestResult tr6 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETCONTEXTPATH);
      /* TODO: implement test */
      tr6.appendTcDetail("Not implemented.");
      tr6.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getCookies */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletRequest.getCookies must provide the same       */
      /* functionality as ResourceRequest.getCookies"                         */
      TestResult tr7 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETCOOKIES);
      /* TODO: implement test */
      tr7.appendTcDetail("Not implemented.");
      tr7.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getDateHeader */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletRequest.getDateHeader must return a value      */
      /* corresponding to that returned by ResourceRequest.getProperty for    */
      /* the corresponding header name"                                       */
      TestResult tr8 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETDATEHEADER);
      /* TODO: implement test */
      tr8.appendTcDetail("Not implemented.");
      tr8.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getHeader */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletRequest.getHeader must return a value          */
      /* corresponding to that returned by ResourceRequest.getProperty for    */
      /* the corresponding header name"                                       */
      TestResult tr9 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETHEADER);
      /* TODO: implement test */
      tr9.appendTcDetail("Not implemented.");
      tr9.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getHeaderNames */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the Enumeration returned by HttpServletRequest.getHeaderNames must   */
      /* be contained in the Enumeration returned by                          */
      /* ResourceRequest.getPropertyNames"                                    */
      TestResult tr10 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETHEADERNAMES);
      /* TODO: implement test */
      tr10.appendTcDetail("Not implemented.");
      tr10.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getHeaders */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletRequest.getHeaders must return a value         */
      /* corresponding to that returned by ResourceRequest.getProperty for    */
      /* the corresponding header name"                                       */
      TestResult tr11 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETHEADERS);
      /* TODO: implement test */
      tr11.appendTcDetail("Not implemented.");
      tr11.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getInputStream */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletRequest.getInputStream must provide the same   */
      /* functionality as ResourceRequest.getPortletInputStream"              */
      TestResult tr12 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETINPUTSTREAM);
      /* TODO: implement test */
      tr12.appendTcDetail("Not implemented.");
      tr12.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getIntHeader */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletRequest.getIntHeader must return a value       */
      /* corresponding to that returned by ResourceRequest.getProperty for    */
      /* the corresponding header name"                                       */
      TestResult tr13 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETINTHEADER);
      /* TODO: implement test */
      tr13.appendTcDetail("Not implemented.");
      tr13.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getLocalAddr */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletRequest.getLocalAddr must return null"         */
      TestResult tr14 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETLOCALADDR);
      try {
         String isval = request.getLocalAddr();
         CompareUtils.stringsEqual(isval, null, tr14);
      } catch(Exception e) {tr14.appendTcDetail(e.toString());}
      tr14.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getLocalName */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletRequest.getLocalName must return null"         */
      TestResult tr15 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETLOCALNAME);
      try {
         String isval = request.getLocalName();
         CompareUtils.stringsEqual(isval, null, tr15);
      } catch(Exception e) {tr15.appendTcDetail(e.toString());}
      tr15.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getLocalPort */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletRequest.getLocalPort must return 0"            */
      TestResult tr16 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETLOCALPORT);
      try {
         int isval = request.getLocalPort();
         if (isval != 0) tr16.appendTcDetail("Returned value was: " + isval);
         tr16.setTcSuccess(isval == 0);
      } catch(Exception e) {tr16.appendTcDetail(e.toString());}
      tr16.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getLocale */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletRequest.getLocale must provide the same        */
      /* functionality as ResourceRequest.getLocale"                          */
      TestResult tr17 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETLOCALE);
      try {
         Locale hl = request.getLocale();
         Locale pl = portletReq.getLocale();
         CompareUtils.stringsEqual(hl.getDisplayName(), pl.getDisplayName(), tr17);
      } catch(Exception e) {tr17.appendTcDetail(e.toString());}
      tr17.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getLocales */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletRequest.getLocales must provide the same       */
      /* functionality as ResourceRequest.getLocales"                         */
      TestResult tr18 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETLOCALES);
      try {
         Enumeration<Locale> he = request.getLocales();
         Enumeration<Locale> pe = portletReq.getLocales();
         CompareUtils.enumsEqual("HttpServletRequest locales", he, "ResourceRequest locales", pe,tr18);
      } catch(Exception e) {tr18.appendTcDetail(e.toString());}
      tr18.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getMethod */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletRequest.getMethod must provide the same        */
      /* functionality as ResourceRequest.getMethod"                          */
      TestResult tr19 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETMETHOD);
      /* TODO: implement test */
      tr19.appendTcDetail("Not implemented.");
      tr19.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getParameter */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletRequest.getParameter must provide the same     */
      /* functionality as ResourceRequest.getParameter"                       */
      TestResult tr20 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETPARAMETER);
      try {
         // TestSetupLink
         String val = portletReq.getParameter(PARM_PREFIX + "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getParameter");
         if (val != null) {
            String hval = request.getParameter(PARM_PREFIX + "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getParameter");
            String pval = portletReq.getParameter(PARM_PREFIX + "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getParameter");
            CompareUtils.stringsEqual(hval, pval, tr20);
            tr20.writeTo(writer);
         }
      } catch(Exception e) {tr20.appendTcDetail(e.toString());}

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getParameterMap */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletRequest.getParameterMap must provide the       */
      /* same functionality as ResourceRequest.getParameterMap"               */
      TestResult tr21 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETPARAMETERMAP);
      try {
         // TestSetupLink
         String val = portletReq.getParameter(PARM_PREFIX + "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getParameterMap");
         if (val != null) {
            Map<String, String[]> hmap = request.getParameterMap();
            Map<String, String[]> pmap = portletReq.getParameterMap();
            CompareUtils.mapsEqual("map from HttpServletRequest", hmap, "map from ResourceRequest", pmap, tr21);
            tr21.writeTo(writer);
         }
      } catch(Exception e) {tr21.appendTcDetail(e.toString());}

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getParameterNames */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletRequest.getParameterNames must provide the     */
      /* same functionality as ResourceRequest.getParameterNames"             */
      TestResult tr22 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETPARAMETERNAMES);
      try {
         // TestSetupLink
         String val = portletReq.getParameter(PARM_PREFIX + "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getParameterNames");
         if (val != null) {
            Enumeration<String> he = request.getParameterNames();
            Enumeration<String> pe = portletReq.getParameterNames();
            CompareUtils.enumsEqual("HttpServletRequest parameter names", he, "ResourceRequest parameter names", pe,tr22);
            tr22.writeTo(writer);
         }
      } catch(Exception e) {tr22.appendTcDetail(e.toString());}

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getParameterValues */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletRequest.getParameterValues must provide the    */
      /* same functionality as ResourceRequest.getParameterValues"            */
      TestResult tr23 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETPARAMETERVALUES);
      try {
         // TestSetupLink
         String val = portletReq.getParameter(PARM_PREFIX + "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getParameterValues");
         if (val != null) {
            String[] hvals = request.getParameterValues(PARM_PREFIX + "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getParameterValues");
            String[] pvals = portletReq.getParameterValues(PARM_PREFIX + "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getParameterValues");
            CompareUtils.stringsEqual(hvals[0], pvals[0], tr23);
            tr23.writeTo(writer);
         }
      } catch(Exception e) {tr23.appendTcDetail(e.toString());}

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getPathInfo */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletRequest.getPathInfo must a value               */
      /* corresponding to the path used to obtain the                         */
      /* PortletRequestDispatcher"                                            */
      TestResult tr24 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETPATHINFO);
      /* TODO: implement test */
      tr24.appendTcDetail("Not implemented.");
      tr24.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getPathTranslated */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletRequest.getPathTranslated must a value         */
      /* corresponding to the path used to obtain the                         */
      /* PortletRequestDispatcher"                                            */
      TestResult tr25 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETPATHTRANSLATED);
      /* TODO: implement test */
      tr25.appendTcDetail("Not implemented.");
      tr25.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getProtocol */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletRequest.getProtocol must return                */
      /* \"HTTP/1.1\""                                                        */
      TestResult tr26 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETPROTOCOL);
      try {
         String isval = request.getProtocol();
         CompareUtils.stringsEqual(isval, "HTTP/1.1", tr26);
      } catch(Exception e) {tr26.appendTcDetail(e.toString());}
      tr26.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getQueryString */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletRequest.getQueryString must a value            */
      /* corresponding to the query string information used to obtain the     */
      /* PortletRequestDispatcher"                                            */
      TestResult tr27 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETQUERYSTRING);
      /* TODO: implement test */
      tr27.appendTcDetail("Not implemented.");
      tr27.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getReader */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletRequest.getReader must provide the same        */
      /* functionality as ResourceRequest.getReader"                          */
      TestResult tr28 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETREADER);
      /* TODO: implement test */
      tr28.appendTcDetail("Not implemented.");
      tr28.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getRealPath */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletRequest.getRealPath must return null"          */
      TestResult tr29 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETREALPATH);
      try {
         String isval = request.getRealPath("/WEB-INF/portlet.xml");
         CompareUtils.stringsEqual(isval, null, tr29);
      } catch(Exception e) {tr29.appendTcDetail(e.toString());}
      tr29.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getRemoteAddr */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletRequest.getRemoteAddr must return null"        */
      TestResult tr30 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETREMOTEADDR);
      try {
         String isval = request.getRemoteAddr();
         CompareUtils.stringsEqual(isval, null, tr30);
      } catch(Exception e) {tr30.appendTcDetail(e.toString());}
      tr30.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getRemoteHost */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletRequest.getRemoteHost must return null"        */
      TestResult tr31 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETREMOTEHOST);
      try {
         String isval = request.getRemoteHost();
         CompareUtils.stringsEqual(isval, null, tr31);
      } catch(Exception e) {tr31.appendTcDetail(e.toString());}
      tr31.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getRemotePort */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletRequest.getRemotePort must return 0"           */
      TestResult tr32 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETREMOTEPORT);
      try {
         int isval = request.getRemotePort();
         if (isval != 0) tr32.appendTcDetail("Returned value was: " + isval);
         tr32.setTcSuccess(isval == 0);
      } catch(Exception e) {tr32.appendTcDetail(e.toString());}
      tr32.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getRemoteUser */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletRequest.getRemoteUser must provide the same    */
      /* functionality as ResourceRequest.getRemoteUser"                      */
      TestResult tr33 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETREMOTEUSER);
      /* TODO: implement test */
      tr33.appendTcDetail("Not implemented.");
      tr33.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getRequestDispatcher */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletRequest.getRequestDispatcher must provide      */
      /* functionality as defined in the servlet specification"               */
      TestResult tr34 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETREQUESTDISPATCHER);
      /* TODO: implement test */
      tr34.appendTcDetail("Not implemented.");
      tr34.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getRequestURI */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletRequest.getRequestURI must a value             */
      /* corresponding to the path and query string information used to       */
      /* obtain the PortletRequestDispatcher"                                 */
      TestResult tr35 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETREQUESTURI);
      /* TODO: implement test */
      tr35.appendTcDetail("Not implemented.");
      tr35.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getRequestURL */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletRequest.getRequestURL must return null"        */
      TestResult tr36 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETREQUESTURL);
      try {
         StringBuffer isval = request.getRequestURL();
         if (isval != null) tr36.appendTcDetail("Request URL is " + isval.toString());
         tr36.setTcSuccess(isval == null);
      } catch(Exception e) {tr36.appendTcDetail(e.toString());}
      tr36.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getRequestedSessionId */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletRequest.getRequestedSessionId must provide     */
      /* the same functionality as ResourceRequest.getRequestedSessionId"     */
      TestResult tr37 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETREQUESTEDSESSIONID);
      /* TODO: implement test */
      tr37.appendTcDetail("Not implemented.");
      tr37.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getScheme */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletRequest.getScheme must provide the same        */
      /* functionality as ResourceRequest.getScheme"                          */
      TestResult tr38 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETSCHEME);
      /* TODO: implement test */
      tr38.appendTcDetail("Not implemented.");
      tr38.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getServerName */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletRequest.getServerName must provide the same    */
      /* functionality as ResourceRequest.getServerName"                      */
      TestResult tr39 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETSERVERNAME);
      /* TODO: implement test */
      tr39.appendTcDetail("Not implemented.");
      tr39.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getServerPort */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletRequest.getServerPort must provide the same    */
      /* functionality as ResourceRequest.getServerPort"                      */
      TestResult tr40 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETSERVERPORT);
      /* TODO: implement test */
      tr40.appendTcDetail("Not implemented.");
      tr40.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getServletPath */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletRequest.getServletPath must a value            */
      /* corresponding to the path used to obtain the                         */
      /* PortletRequestDispatcher"                                            */
      TestResult tr41 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETSERVLETPATH);
      /* TODO: implement test */
      tr41.appendTcDetail("Not implemented.");
      tr41.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getSession */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletRequest.getSession must provide the same       */
      /* functionality as                                                     */
      /* ResourceRequest.getPortletSession(APPLICATION_SCOPE)"                */
      TestResult tr42 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETSESSION);
      /* TODO: implement test */
      tr42.appendTcDetail("Not implemented.");
      tr42.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getUserPrincipal */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletRequest.getUserPrincipal must provide the      */
      /* same functionality as ResourceRequest.getUserPrincipal"              */
      TestResult tr43 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETUSERPRINCIPAL);
      /* TODO: implement test */
      tr43.appendTcDetail("Not implemented.");
      tr43.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_isRequestedSessionIdFromCookie */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletRequest.isRequestedSessionIdFromCookie must    */
      /* provide functionality as defined in the servlet specification"       */
      TestResult tr44 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_ISREQUESTEDSESSIONIDFROMCOOKIE);
      /* TODO: implement test */
      tr44.appendTcDetail("Not implemented.");
      tr44.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_isRequestedSessionIdFromURL1 */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletRequest.isRequestedSessionIdFromURL must       */
      /* provide functionality as defined in the servlet specification"       */
      TestResult tr45 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_ISREQUESTEDSESSIONIDFROMURL1);
      /* TODO: implement test */
      tr45.appendTcDetail("Not implemented.");
      tr45.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_isRequestedSessionIdFromUrl */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletRequest.isRequestedSessionIdFromUrl must       */
      /* provide functionality as defined in the servlet specification"       */
      TestResult tr46 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_ISREQUESTEDSESSIONIDFROMURL);
      /* TODO: implement test */
      tr46.appendTcDetail("Not implemented.");
      tr46.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_isRequestedSessionIdValid */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletRequest.isRequestedSessionIdValid must         */
      /* provide the same functionality as                                    */
      /* ResourceRequest.isRequestedSessionIdValid"                           */
      TestResult tr47 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_ISREQUESTEDSESSIONIDVALID);
      /* TODO: implement test */
      tr47.appendTcDetail("Not implemented.");
      tr47.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_isSecure */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletRequest.isSecure must provide the same         */
      /* functionality as ResourceRequest.isSecure"                           */
      TestResult tr48 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_ISSECURE);
      /* TODO: implement test */
      tr48.appendTcDetail("Not implemented.");
      tr48.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_isUserInRole */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletRequest.isUserInRole must provide the same     */
      /* functionality as ResourceRequest.isUserInRole"                       */
      TestResult tr49 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_ISUSERINROLE);
      /* TODO: implement test */
      tr49.appendTcDetail("Not implemented.");
      tr49.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_removeAttribute */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletRequest.removeAttribute must provide the       */
      /* same functionality as ResourceRequest.removeAttribute"               */
      TestResult tr50 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_REMOVEATTRIBUTE);
      /* TODO: implement test */
      tr50.appendTcDetail("Not implemented.");
      tr50.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_setAttribute */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletRequest.setAttribute must provide the same     */
      /* functionality as ResourceRequest.setAttribute"                       */
      TestResult tr51 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_SETATTRIBUTE);
      /* TODO: implement test */
      tr51.appendTcDetail("Not implemented.");
      tr51.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_setCharacterEncoding */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletRequest.setCharacterEncoding must provide      */
      /* the same functionality as ResourceRequest.setCharacterEncoding"      */
      TestResult tr52 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_SETCHARACTERENCODING);
      /* TODO: implement test */
      tr52.appendTcDetail("Not implemented.");
      tr52.writeTo(writer);


   }
}
