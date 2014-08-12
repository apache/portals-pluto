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
import static javax.portlet.tck.beans.JSR286DispatcherTestCaseDetails.*;

/**
 * Servlet for JSR 362 request dispatcher testing.
 * Used by portlet: DispatcherTests_SPEC2_19_IncludeServletResource
 *
 * @author nick
 *
 */
public class DispatcherTests_SPEC2_19_IncludeServletResource_servlet extends HttpServlet {
   private static final String LOG_CLASS = 
         DispatcherTests_SPEC2_19_IncludeServletResource_servlet.class.getName();
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
      long reqTid = (Long) portletReq.getAttribute("void");

      PrintWriter writer = ((MimeResponse)portletResp).getWriter();

      JSR286DispatcherTestCaseDetails tcd = new JSR286DispatcherTestCaseDetails();

      // Create result objects for the tests

      /* TestCase: SPEC2_19_IncludeServletResource_dispatch1                  */
      /* Details: "If the path provided to getRequestDispatcher method        */
      /* contains query strings, parameters specified in the query strings    */
      /* must be passed to the target servlet during an include"              */
      TestResult tr0 = tcd.getTestResultFailed(SPEC2_19_INCLUDESERVLETRESOURCE_DISPATCH1);
      try {
         String qparm1 = portletReq.getParameter("qparm1");
         String qparm2 = portletReq.getParameter("qparm2");
         boolean ok = ((qparm1 != null) && (qparm2 != null));
         if (ok) ok = (qparm1.equals("qvalue1") && qparm2.equals("qvalue2"));
         if (!ok) tr0.appendTcDetail("qparm1=" + qparm1 + ", qparm2=" + qparm2);
         tr0.setTcSuccess(ok);
      } catch(Exception e) {tr0.appendTcDetail(e.toString());}
      tr0.writeTo(writer);

      /* TestCase: SPEC2_19_IncludeServletResource_dispatch2                  */
      /* Details: "Parameters specified in the query strings must be          */
      /* aggregated with the portlet render parameters"                       */
      TestResult tr1 = tcd.getTestResultFailed(SPEC2_19_INCLUDESERVLETRESOURCE_DISPATCH2);
      try {
         String[] qparm2 = portletReq.getParameterValues("qparm2");
         boolean ok = ((qparm2 != null) && (qparm2.length > 1));
         String str = "qparm2 " + ((qparm2==null)?("is null"):("length="+qparm2.length));
         if (!ok) tr1.appendTcDetail(str);
         tr1.setTcSuccess(ok);
      } catch(Exception e) {tr1.appendTcDetail(e.toString());}
      tr1.writeTo(writer);

      /* TestCase: SPEC2_19_IncludeServletResource_dispatch3                  */
      /* Details: "If query string parameters have the same names as render   */
      /* parameter names, the query string parameters appear in the           */
      /* parameter values array before the render parameter values"           */
      TestResult tr2 = tcd.getTestResultFailed(SPEC2_19_INCLUDESERVLETRESOURCE_DISPATCH3);
      try {
         String qparm1 = portletReq.getParameter("qparm1");
         String qparm2 = portletReq.getParameter("qparm2");
         boolean ok = ((qparm1 != null) && (qparm2 != null));
         if (ok) ok = (qparm1.equals("qvalue1") && qparm2.equals("qvalue2"));
         if (!ok) tr2.appendTcDetail("qparm1=" + qparm1 + ", qparm2=" + qparm2);
         tr2.setTcSuccess(ok);
      } catch(Exception e) {tr2.appendTcDetail(e.toString());}
      tr2.writeTo(writer);

      /* TestCase: SPEC2_19_IncludeServletResource_dispatch4                  */
      /* Details: "The parameters associated with a request dispatcher are    */
      /* scoped only for the duration of the include or forward call"         */
      TestResult tr3 = tcd.getTestResultFailed(SPEC2_19_INCLUDESERVLETRESOURCE_DISPATCH4);
      /* TODO: implement test */
      tr3.appendTcDetail("Not implemented.");
      tr3.writeTo(writer);

      /* TestCase: SPEC2_19_IncludeServletResource_invoke1                    */
      /* Details: "The PortletRequestDispatcher include method can target a   */
      /* servlet "                                                            */
      TestResult tr4 = tcd.getTestResultFailed(SPEC2_19_INCLUDESERVLETRESOURCE_INVOKE1);
      try {
         // If this gets executed, include worked.
         tr4.setTcSuccess(true);
      } catch(Exception e) {tr4.appendTcDetail(e.toString());}
      tr4.writeTo(writer);

      /* TestCase: SPEC2_19_IncludeServletResource_invoke2                    */
      /* Details: "Parameters to the include method for a target servlet      */
      /* can be the request and response classes from the portlet lifecyle    */
      /* method initiating the include"                                       */
      TestResult tr5 = tcd.getTestResultFailed(SPEC2_19_INCLUDESERVLETRESOURCE_INVOKE2);
      try {
         // If this gets executed, include worked.
         tr5.setTcSuccess(true);
      } catch(Exception e) {tr5.appendTcDetail(e.toString());}
      tr5.writeTo(writer);

      /* TestCase: SPEC2_19_IncludeServletResource_invoke3                    */
      /* Details: "Parameters to the include method for a target servlet      */
      /* can be wrapped request and response classes from the portlet         */
      /* lifecyle method initiating the include"                              */
      TestResult tr6 = tcd.getTestResultFailed(SPEC2_19_INCLUDESERVLETRESOURCE_INVOKE3);
      /* TODO: implement test */
      tr6.appendTcDetail("Not implemented.");
      tr6.writeTo(writer);

      /* TestCase: SPEC2_19_IncludeServletResource_invoke4                    */
      /* Details: "The portlet container must invoke the target servlet in    */
      /* the same thread as the PortletRequestDispatcher include              */
      /* invocation"                                                          */
      TestResult tr7 = tcd.getTestResultFailed(SPEC2_19_INCLUDESERVLETRESOURCE_INVOKE4);
      try {
         tr7.setTcSuccess(reqTid == svtTid);
      } catch(Exception e) {tr7.appendTcDetail(e.toString());}
      tr7.writeTo(writer);

      /* TestCase: SPEC2_19_IncludeServletResource_invoke5                    */
      /* Details: "Cookies set by the portlet before the include call         */
      /* remain valid"                                                        */
      TestResult tr8 = tcd.getTestResultFailed(SPEC2_19_INCLUDESERVLETRESOURCE_INVOKE5);
      try {
         Cookie[] cs = portletReq.getCookies();
         boolean ok = false;
         for (Cookie c : cs) {
            if (c.getName().equals(COOKIE_PREFIX + "DispatcherTests_SPEC2_19_IncludeServletResource")) {
               ok = true;
               c.setMaxAge(0);  // cookie only lives for this request
            }
         }
         tr8.setTcSuccess(ok);
      } catch(Exception e) {tr8.appendTcDetail(e.toString());}
      tr8.writeTo(writer);

      /* TestCase: SPEC2_19_IncludeServletResource_invoke6                    */
      /* Details: "Properties set by the portlet before the include call      */
      /* remain valid"                                                        */
      TestResult tr9 = tcd.getTestResultFailed(SPEC2_19_INCLUDESERVLETRESOURCE_INVOKE6);
      try {
         String prop = portletReq.getProperty(PROP_PREFIX + "DispatcherTests_SPEC2_19_IncludeServletResource");
         tr9.setTcSuccess(prop != null);
      } catch(Exception e) {tr9.appendTcDetail(e.toString());}
      tr9.writeTo(writer);

      /* TestCase: SPEC2_19_IncludeServletResource_invoke7                    */
      /* Details: "The path elements of the request object exposed to the     */
      /* target servlet must reflect the path used to obtain the              */
      /* RequestDispatcher"                                                   */
      TestResult tr10 = tcd.getTestResultFailed(SPEC2_19_INCLUDESERVLETRESOURCE_INVOKE7);
      try {
         String ctxpath= request.getContextPath();
         tr10.setTcSuccess(ctxpath.equals("/DispatcherTests_SPEC2_19_IncludeServletResource_servlet"));
      } catch(Exception e) {tr10.appendTcDetail(e.toString());}
      tr10.writeTo(writer);

      /* TestCase: SPEC2_19_IncludeServletResource_invoke8                    */
      /* Details: "The portlet can include multiple servlets during the       */
      /* same lifecycle method"                                               */
      TestResult tr11 = tcd.getTestResultFailed(SPEC2_19_INCLUDESERVLETRESOURCE_INVOKE8);
      /* TODO: implement test */
      tr11.appendTcDetail("Not implemented.");
      tr11.writeTo(writer);

      /* TestCase: SPEC2_19_IncludeServletResource_invoke9                    */
      /* Details: "The included servlet must be handled as an HTTP GET        */
      /* request"                                                             */
      TestResult tr12 = tcd.getTestResultFailed(SPEC2_19_INCLUDESERVLETRESOURCE_INVOKE9);
      try {
         String meth = request.getMethod();
         tr12.setTcSuccess(meth.equals("GET"));
      } catch(Exception e) {tr12.appendTcDetail(e.toString());}
      tr12.writeTo(writer);

      /* TestCase: SPEC2_19_IncludeServletResource_attributes1                */
      /* Details: "If the request dispatcher is obtained through the          */
      /* getRequestDispatcher method, the request attribute                   */
      /* javax.servlet.include.request_uri will be set, and equals the        */
      /* value from HTTPServletRequest.getRequestURI for the first servlet    */
      /* in the include chain"                                                */
      TestResult tr13 = tcd.getTestResultFailed(SPEC2_19_INCLUDESERVLETRESOURCE_ATTRIBUTES1);
      try {
         String name = "javax.servlet.include.req.uri";
         String attrVal = (String) portletReq.getAttribute(name);
         String currVal =  request.getRequestURI();
         CompareUtils.stringsEqual(attrVal, currVal, tr13);
      } catch(Exception e) {tr13.appendTcDetail(e.toString());}
      tr13.writeTo(writer);

      /* TestCase: SPEC2_19_IncludeServletResource_attributes2                */
      /* Details: "If the request dispatcher is obtained through the          */
      /* getRequestDispatcher method, the request attribute                   */
      /* javax.servlet.include.context_path will be set, and equals the       */
      /* value from HTTPServletRequest.getContestPath for the first servlet   */
      /* in the include chain"                                                */
      TestResult tr14 = tcd.getTestResultFailed(SPEC2_19_INCLUDESERVLETRESOURCE_ATTRIBUTES2);
      try {
         String name = "javax.servlet.include.context_path";
         String attrVal = (String) portletReq.getAttribute(name);
         String currVal =  request.getContextPath();
         CompareUtils.stringsEqual(attrVal, currVal, tr14);
      } catch(Exception e) {tr14.appendTcDetail(e.toString());}
      tr14.writeTo(writer);

      /* TestCase: SPEC2_19_IncludeServletResource_attributes3                */
      /* Details: "If the request dispatcher is obtained through the          */
      /* getRequestDispatcher method, the request attribute                   */
      /* javax.servlet.include.servlet_path will be set, and equals the       */
      /* value from HTTPServletRequest.getServletPath for the first servlet   */
      /* in the include chain"                                                */
      TestResult tr15 = tcd.getTestResultFailed(SPEC2_19_INCLUDESERVLETRESOURCE_ATTRIBUTES3);
      try {
         String name = "javax.servlet.include.servlet_path";
         String attrVal = (String) portletReq.getAttribute(name);
         String currVal =  request.getServletPath();
         CompareUtils.stringsEqual(attrVal, currVal, tr15);
      } catch(Exception e) {tr15.appendTcDetail(e.toString());}
      tr15.writeTo(writer);

      /* TestCase: SPEC2_19_IncludeServletResource_attributes4                */
      /* Details: "If the request dispatcher is obtained through the          */
      /* getRequestDispatcher method, the request attribute                   */
      /* javax.servlet.include.path_info will be set, and equals the value    */
      /* from HTTPServletRequest.getPathInfo for the first servlet in the     */
      /* include chain"                                                       */
      TestResult tr16 = tcd.getTestResultFailed(SPEC2_19_INCLUDESERVLETRESOURCE_ATTRIBUTES4);
      try {
         String name = "javax.servlet.include.path_info";
         String attrVal = (String) portletReq.getAttribute(name);
         String currVal =  request.getPathInfo();
         CompareUtils.stringsEqual(attrVal, currVal, tr16);
      } catch(Exception e) {tr16.appendTcDetail(e.toString());}
      tr16.writeTo(writer);

      /* TestCase: SPEC2_19_IncludeServletResource_attributes5                */
      /* Details: "If the request dispatcher is obtained through the          */
      /* getRequestDispatcher method, the request attribute                   */
      /* javax.servlet.include.query_string will be set, and equals the       */
      /* value from HTTPServletRequest.getQueryString for the first servlet   */
      /* in the include chain"                                                */
      TestResult tr17 = tcd.getTestResultFailed(SPEC2_19_INCLUDESERVLETRESOURCE_ATTRIBUTES5);
      try {
         String name = "javax.servlet.include.query_string";
         String attrVal = (String) portletReq.getAttribute(name);
         String currVal =  request.getQueryString();
         CompareUtils.stringsEqual(attrVal, currVal, tr17);
      } catch(Exception e) {tr17.appendTcDetail(e.toString());}
      tr17.writeTo(writer);

      /* TestCase: SPEC2_19_IncludeServletResource_attributes6                */
      /* Details: "The request attribute javax.portlet.config must be set     */
      /* to the javax.portlet.PortletConfig object"                           */
      TestResult tr18 = tcd.getTestResultFailed(SPEC2_19_INCLUDESERVLETRESOURCE_ATTRIBUTES6);
      try {
         ClassChecker cc = new ClassChecker(portletConfig.getClass());
         boolean ok = cc.implementsInterface(PortletConfig.class);
         tr18.setTcSuccess(ok);
      } catch(Exception e) {tr18.appendTcDetail(e.toString());}
      tr18.writeTo(writer);

      /* TestCase: SPEC2_19_IncludeServletResource_attributes7                */
      /* Details: "For includes from the serveResource method, The request    */
      /* attribute javax.portlet.request must be set to the                   */
      /* javax.portlet.ResourceRequest object"                                */
      TestResult tr19 = tcd.getTestResultFailed(SPEC2_19_INCLUDESERVLETRESOURCE_ATTRIBUTES7);
      try {
         ClassChecker cc = new ClassChecker(portletReq.getClass());
         boolean ok = cc.implementsInterface(ResourceRequest.class);
         tr19.setTcSuccess(ok);
      } catch(Exception e) {tr19.appendTcDetail(e.toString());}
      tr19.writeTo(writer);

      /* TestCase: SPEC2_19_IncludeServletResource_attributes8                */
      /* Details: "For includes from the serveResource method, The request    */
      /* attribute javax.portlet.response must be set to the                  */
      /* javax.portlet.ResourceResponse object"                               */
      TestResult tr20 = tcd.getTestResultFailed(SPEC2_19_INCLUDESERVLETRESOURCE_ATTRIBUTES8);
      try {
         ClassChecker cc = new ClassChecker(portletResp.getClass());
         boolean ok = cc.implementsInterface(ResourceResponse.class);
         tr20.setTcSuccess(ok);
      } catch(Exception e) {tr20.appendTcDetail(e.toString());}
      tr20.writeTo(writer);


   }
}
