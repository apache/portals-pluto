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

package javax.portlet.tck.portlets;

import java.io.*;
import java.util.*;
import java.util.logging.*;
import static java.util.logging.Logger.*;
import javax.xml.namespace.QName;
import javax.portlet.*;
import javax.portlet.filter.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.portlet.tck.beans.*;
import javax.portlet.tck.constants.*;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.*;
import static javax.portlet.tck.constants.Constants.*;
import static javax.portlet.PortletSession.*;
import static javax.portlet.ResourceURL.*;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the 
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet
 * will initiate the events, but not process them. The processing is done in the companion 
 * portlet DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_event
 *
 */
public class DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest.class.getName();
   private final Logger LOGGER = Logger.getLogger(LOG_CLASS);
   
   private PortletConfig portletConfig = null;

   @Override
   public void init(PortletConfig config) throws PortletException {
      this.portletConfig = config;
   }

   @Override
   public void destroy() {
   }

   @Override
   public void processAction(ActionRequest portletReq, ActionResponse portletResp)
         throws PortletException, IOException {
      LOGGER.entering(LOG_CLASS, "main portlet processAction entry");

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      StringWriter writer = new StringWriter();

      // Set parameter for: DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest
      portletResp.setRenderParameter(PARM_PREFIX + "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getParameter", "Value");

      // Set parameter for: DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest
      portletResp.setRenderParameter(PARM_PREFIX + "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getParameterMap", "Value");

      // Set parameter for: DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest
      portletResp.setRenderParameter(PARM_PREFIX + "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getParameterNames", "Value");

      // Set parameter for: DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest
      portletResp.setRenderParameter(PARM_PREFIX + "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getParameterValues", "Value");

      // Prereq for: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getAttribute
      portletReq.setAttribute(ATTR_PREFIX +"V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getAttribute", "Value1");

      // Prereq for: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getAttributeNames
      portletReq.setAttribute(ATTR_PREFIX + "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getAttributeNames", "Value1");

      PortletRequestDispatcher rd = portletConfig.getPortletContext()
            .getRequestDispatcher("/WEB-INF/jsp/DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest.jsp?qparm1=qvalue1&qparm2=qvalue2");
      rd.forward(portletReq, portletResp);
   }

   @Override
   public void serveResource(ResourceRequest portletReq, ResourceResponse portletResp)
         throws PortletException, IOException {
      LOGGER.entering(LOG_CLASS, "main portlet serveResource entry");

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp)
         throws PortletException, IOException {
      LOGGER.entering(LOG_CLASS, "main portlet render entry");

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

      PortletSession ps = portletReq.getPortletSession();
      String msg = (String) ps.getAttribute(RESULT_ATTR_PREFIX + "DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest", APPLICATION_SCOPE);
      if (msg != null) {
         writer.write("<p>" + msg + "</p>\n");
         ps.removeAttribute(RESULT_ATTR_PREFIX + "DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest", APPLICATION_SCOPE);
      } else {

         /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getAttribute */
         /* Details: "In a target jsp of a forward in the Action phase, the      */
         /* method HttpServletRequest.getAttribute must provide the same         */
         /* functionality as ActionRequest.getAttribute"                         */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getAttribute", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getAttributeNames */
         /* Details: "In a target jsp of a forward in the Action phase, the      */
         /* method HttpServletRequest.getAttributeNames must provide the same    */
         /* functionality as ActionRequest.getAttributeNames"                    */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getAttributeNames", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getAuthType */
         /* Details: "In a target jsp of a forward in the Action phase, the      */
         /* method HttpServletRequest.getAuthType must provide the same          */
         /* functionality as ActionRequest.getAuthType"                          */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getAuthType", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getCharacterEncoding */
         /* Details: "In a target jsp of a forward in the Action phase, the      */
         /* method HttpServletRequest.getCharacterEncoding must provide the      */
         /* same functionality as ActionRequest.getCharacterEncoding"            */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getCharacterEncoding", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getContentLength */
         /* Details: "In a target jsp of a forward in the Action phase, the      */
         /* method HttpServletRequest.getContentLength must provide the same     */
         /* functionality as ActionRequest.getContentLength"                     */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getContentLength", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getContentType */
         /* Details: "In a target jsp of a forward in the Action phase, the      */
         /* method HttpServletRequest.getContentType must provide the same       */
         /* functionality as ActionRequest.getContentType"                       */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getContentType", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getContextPath */
         /* Details: "In a target jsp of a forward in the Action phase, the      */
         /* method HttpServletRequest.getContextPath must provide the same       */
         /* functionality as ActionRequest.getContextPath"                       */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getContextPath", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getCookies */
         /* Details: "In a target jsp of a forward in the Action phase, the      */
         /* method HttpServletRequest.getCookies must provide the same           */
         /* functionality as ActionRequest.getCookies"                           */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getCookies", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getDateHeader */
         /* Details: "In a target jsp of a forward in the Action phase, the      */
         /* method HttpServletRequest.getDateHeader must return a value          */
         /* corresponding to that returned by ActionRequest.getProperty for      */
         /* the corresponding header name"                                       */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getDateHeader", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getHeader */
         /* Details: "In a target jsp of a forward in the Action phase, the      */
         /* method HttpServletRequest.getHeader must return a value              */
         /* corresponding to that returned by ActionRequest.getProperty for      */
         /* the corresponding header name"                                       */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getHeader", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getHeaderNames */
         /* Details: "In a target jsp of a forward in the Action phase, the      */
         /* Enumeration returned by HttpServletRequest.getHeaderNames must be    */
         /* contained in the Enumeration returned by                             */
         /* ActionRequest.getPropertyNames"                                      */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getHeaderNames", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getHeaders */
         /* Details: "In a target jsp of a forward in the Action phase, the      */
         /* method HttpServletRequest.getHeaders must return a value             */
         /* corresponding to that returned by ActionRequest.getProperty for      */
         /* the corresponding header name"                                       */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getHeaders", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getInputStream */
         /* Details: "In a target jsp of a forward in the Action phase, the      */
         /* method HttpServletRequest.getInputStream must provide the same       */
         /* functionality as ActionRequest.getPortletInputStream"                */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getInputStream", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getIntHeader */
         /* Details: "In a target jsp of a forward in the Action phase, the      */
         /* method HttpServletRequest.getIntHeader must return a value           */
         /* corresponding to that returned by ActionRequest.getProperty for      */
         /* the corresponding header name"                                       */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getIntHeader", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getLocalAddr */
         /* Details: "In a target jsp of a forward in the Action phase, the      */
         /* method HttpServletRequest.getLocalAddr must return null"             */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getLocalAddr", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getLocalName */
         /* Details: "In a target jsp of a forward in the Action phase, the      */
         /* method HttpServletRequest.getLocalName must return null"             */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getLocalName", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getLocalPort */
         /* Details: "In a target jsp of a forward in the Action phase, the      */
         /* method HttpServletRequest.getLocalPort must return 0"                */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getLocalPort", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getLocale */
         /* Details: "In a target jsp of a forward in the Action phase, the      */
         /* method HttpServletRequest.getLocale must provide the same            */
         /* functionality as ActionRequest.getLocale"                            */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getLocale", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getLocales */
         /* Details: "In a target jsp of a forward in the Action phase, the      */
         /* method HttpServletRequest.getLocales must provide the same           */
         /* functionality as ActionRequest.getLocales"                           */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getLocales", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getMethod */
         /* Details: "In a target jsp of a forward in the Action phase, the      */
         /* method HttpServletRequest.getMethod must provide the same            */
         /* functionality as ActionRequest.getMethod"                            */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getMethod", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getParameter */
         /* Details: "In a target jsp of a forward in the Action phase, the      */
         /* method HttpServletRequest.getParameter must provide the same         */
         /* functionality as ActionRequest.getParameter"                         */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getParameter", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getParameterMap */
         /* Details: "In a target jsp of a forward in the Action phase, the      */
         /* method HttpServletRequest.getParameterMap must provide the same      */
         /* functionality as ActionRequest.getParameterMap"                      */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getParameterMap", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getParameterNames */
         /* Details: "In a target jsp of a forward in the Action phase, the      */
         /* method HttpServletRequest.getParameterNames must provide the same    */
         /* functionality as ActionRequest.getParameterNames"                    */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getParameterNames", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getParameterValues */
         /* Details: "In a target jsp of a forward in the Action phase, the      */
         /* method HttpServletRequest.getParameterValues must provide the same   */
         /* functionality as ActionRequest.getParameterValues"                   */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getParameterValues", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getPathInfo */
         /* Details: "In a target jsp of a forward in the Action phase, the      */
         /* method HttpServletRequest.getPathInfo must a value corresponding     */
         /* to the path used to obtain the PortletRequestDispatcher"             */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getPathInfo", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getPathTranslated */
         /* Details: "In a target jsp of a forward in the Action phase, the      */
         /* method HttpServletRequest.getPathTranslated must a value             */
         /* corresponding to the path used to obtain the                         */
         /* PortletRequestDispatcher"                                            */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getPathTranslated", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getProtocol */
         /* Details: "In a target jsp of a forward in the Action phase, the      */
         /* method HttpServletRequest.getProtocol must return \"HTTP/1.1\""      */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getProtocol", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getQueryString */
         /* Details: "In a target jsp of a forward in the Action phase, the      */
         /* method HttpServletRequest.getQueryString must a value                */
         /* corresponding to the query string information used to obtain the     */
         /* PortletRequestDispatcher"                                            */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getQueryString", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getReader */
         /* Details: "In a target jsp of a forward in the Action phase, the      */
         /* method HttpServletRequest.getReader must provide the same            */
         /* functionality as ActionRequest.getReader"                            */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getReader", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getRealPath */
         /* Details: "In a target jsp of a forward in the Action phase, the      */
         /* method HttpServletRequest.getRealPath must return null"              */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getRealPath", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getRemoteAddr */
         /* Details: "In a target jsp of a forward in the Action phase, the      */
         /* method HttpServletRequest.getRemoteAddr must return null"            */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getRemoteAddr", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getRemoteHost */
         /* Details: "In a target jsp of a forward in the Action phase, the      */
         /* method HttpServletRequest.getRemoteHost must return null"            */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getRemoteHost", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getRemotePort */
         /* Details: "In a target jsp of a forward in the Action phase, the      */
         /* method HttpServletRequest.getRemotePort must return 0"               */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getRemotePort", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getRemoteUser */
         /* Details: "In a target jsp of a forward in the Action phase, the      */
         /* method HttpServletRequest.getRemoteUser must provide the same        */
         /* functionality as ActionRequest.getRemoteUser"                        */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getRemoteUser", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getRequestDispatcher */
         /* Details: "In a target jsp of a forward in the Action phase, the      */
         /* method HttpServletRequest.getRequestDispatcher must provide          */
         /* functionality as defined in the servlet specification"               */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getRequestDispatcher", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getRequestURI */
         /* Details: "In a target jsp of a forward in the Action phase, the      */
         /* method HttpServletRequest.getRequestURI must a value corresponding   */
         /* to the path and query string information used to obtain the          */
         /* PortletRequestDispatcher"                                            */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getRequestURI", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getRequestURL */
         /* Details: "In a target jsp of a forward in the Action phase, the      */
         /* method HttpServletRequest.getRequestURL must return null"            */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getRequestURL", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getRequestedSessionId */
         /* Details: "In a target jsp of a forward in the Action phase, the      */
         /* method HttpServletRequest.getRequestedSessionId must provide the     */
         /* same functionality as ActionRequest.getRequestedSessionId"           */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getRequestedSessionId", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getScheme */
         /* Details: "In a target jsp of a forward in the Action phase, the      */
         /* method HttpServletRequest.getScheme must provide the same            */
         /* functionality as ActionRequest.getScheme"                            */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getScheme", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getServerName */
         /* Details: "In a target jsp of a forward in the Action phase, the      */
         /* method HttpServletRequest.getServerName must provide the same        */
         /* functionality as ActionRequest.getServerName"                        */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getServerName", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getServerPort */
         /* Details: "In a target jsp of a forward in the Action phase, the      */
         /* method HttpServletRequest.getServerPort must provide the same        */
         /* functionality as ActionRequest.getServerPort"                        */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getServerPort", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getServletPath */
         /* Details: "In a target jsp of a forward in the Action phase, the      */
         /* method HttpServletRequest.getServletPath must a value                */
         /* corresponding to the path used to obtain the                         */
         /* PortletRequestDispatcher"                                            */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getServletPath", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getSession */
         /* Details: "In a target jsp of a forward in the Action phase, the      */
         /* method HttpServletRequest.getSession must provide the same           */
         /* functionality as                                                     */
         /* ActionRequest.getPortletSession(APPLICATION_SCOPE)"                  */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getSession", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getUserPrincipal */
         /* Details: "In a target jsp of a forward in the Action phase, the      */
         /* method HttpServletRequest.getUserPrincipal must provide the same     */
         /* functionality as ActionRequest.getUserPrincipal"                     */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getUserPrincipal", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_isRequestedSessionIdFromCookie */
         /* Details: "In a target jsp of a forward in the Action phase, the      */
         /* method HttpServletRequest.isRequestedSessionIdFromCookie must        */
         /* provide functionality as defined in the servlet specification"       */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_isRequestedSessionIdFromCookie", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_isRequestedSessionIdFromURL1 */
         /* Details: "In a target jsp of a forward in the Action phase, the      */
         /* method HttpServletRequest.isRequestedSessionIdFromURL must provide   */
         /* functionality as defined in the servlet specification"               */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_isRequestedSessionIdFromURL1", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_isRequestedSessionIdFromUrl */
         /* Details: "In a target jsp of a forward in the Action phase, the      */
         /* method HttpServletRequest.isRequestedSessionIdFromUrl must provide   */
         /* functionality as defined in the servlet specification"               */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_isRequestedSessionIdFromUrl", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_isRequestedSessionIdValid */
         /* Details: "In a target jsp of a forward in the Action phase, the      */
         /* method HttpServletRequest.isRequestedSessionIdValid must provide     */
         /* the same functionality as ActionRequest.isRequestedSessionIdValid"   */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_isRequestedSessionIdValid", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_isSecure */
         /* Details: "In a target jsp of a forward in the Action phase, the      */
         /* method HttpServletRequest.isSecure must provide the same             */
         /* functionality as ActionRequest.isSecure"                             */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_isSecure", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_isUserInRole */
         /* Details: "In a target jsp of a forward in the Action phase, the      */
         /* method HttpServletRequest.isUserInRole must provide the same         */
         /* functionality as ActionRequest.isUserInRole"                         */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_isUserInRole", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_removeAttribute */
         /* Details: "In a target jsp of a forward in the Action phase, the      */
         /* method HttpServletRequest.removeAttribute must provide the same      */
         /* functionality as ActionRequest.removeAttribute"                      */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_removeAttribute", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_setAttribute */
         /* Details: "In a target jsp of a forward in the Action phase, the      */
         /* method HttpServletRequest.setAttribute must provide the same         */
         /* functionality as ActionRequest.setAttribute"                         */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_setAttribute", aurl);
            tb.writeTo(writer);
         }

         /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_setCharacterEncoding */
         /* Details: "In a target jsp of a forward in the Action phase, the      */
         /* method HttpServletRequest.setCharacterEncoding must provide the      */
         /* same functionality as ActionRequest.setCharacterEncoding"            */
         {
            PortletURL aurl = portletResp.createActionURL();
            TestButton tb = new TestButton("V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_setCharacterEncoding", aurl);
            tb.writeTo(writer);
         }

      }
   }

}
