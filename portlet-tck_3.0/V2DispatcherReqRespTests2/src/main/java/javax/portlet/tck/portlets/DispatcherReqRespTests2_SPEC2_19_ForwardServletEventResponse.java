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
 * portlet DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse_event
 *
 */
public class DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse.class.getName();
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

      QName eventQName = new QName(TCKNAMESPACE,
             "DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse");
      portletResp.setEvent(eventQName, "Hi!");
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

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse_addDateHeader */
      /* Details: "In a target servlet of a forward in the Event phase, the   */
      /* method HttpServletResponse.addDateHeader does not perform any        */
      /* operation"                                                           */
      {
         PortletURL aurl = portletResp.createActionURL();
         TestButton tb = new TestButton("V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse_addDateHeader", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse_addHeader */
      /* Details: "In a target servlet of a forward in the Event phase, the   */
      /* method HttpServletResponse.addHeader does not perform any            */
      /* operation"                                                           */
      {
         PortletURL aurl = portletResp.createActionURL();
         TestButton tb = new TestButton("V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse_addHeader", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse_addIntHeader */
      /* Details: "In a target servlet of a forward in the Event phase, the   */
      /* method HttpServletResponse.addIntHeader does not perform any         */
      /* operation"                                                           */
      {
         PortletURL aurl = portletResp.createActionURL();
         TestButton tb = new TestButton("V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse_addIntHeader", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse_containsHeader */
      /* Details: "In a target servlet of a forward in the Event phase, the   */
      /* method HttpServletResponse.containsHeader must return false"         */
      {
         PortletURL aurl = portletResp.createActionURL();
         TestButton tb = new TestButton("V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse_containsHeader", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse_encodeRedirectURL1 */
      /* Details: "In a target servlet of a forward in the Event phase, the   */
      /* method HttpServletResponse.encodeRedirectURL must return null"       */
      {
         PortletURL aurl = portletResp.createActionURL();
         TestButton tb = new TestButton("V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse_encodeRedirectURL1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse_encodeRedirectUrl */
      /* Details: "In a target servlet of a forward in the Event phase, the   */
      /* method HttpServletResponse.encodeRedirectUrl must return null"       */
      {
         PortletURL aurl = portletResp.createActionURL();
         TestButton tb = new TestButton("V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse_encodeRedirectUrl", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse_encodeURL1 */
      /* Details: "In a target servlet of a forward in the Event phase, the   */
      /* method HttpServletResponse.encodeURL must provide the same           */
      /* functionality as EventResponse.encodeURL"                            */
      {
         PortletURL aurl = portletResp.createActionURL();
         TestButton tb = new TestButton("V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse_encodeURL1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse_encodeUrl */
      /* Details: "In a target servlet of a forward in the Event phase, the   */
      /* method HttpServletResponse.encodeUrl must provide the same           */
      /* functionality as EventResponse.encodeURL"                            */
      {
         PortletURL aurl = portletResp.createActionURL();
         TestButton tb = new TestButton("V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse_encodeUrl", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse_flushBuffer */
      /* Details: "In a target servlet of a forward in the Event phase, the   */
      /* method HttpServletResponse.flushBuffer does not perform any          */
      /* operation"                                                           */
      {
         PortletURL aurl = portletResp.createActionURL();
         TestButton tb = new TestButton("V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse_flushBuffer", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse_getBufferSize */
      /* Details: "In a target servlet of a forward in the Event phase, the   */
      /* method HttpServletResponse.getBufferSize must return 0"              */
      {
         PortletURL aurl = portletResp.createActionURL();
         TestButton tb = new TestButton("V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse_getBufferSize", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse_getCharacterEncoding */
      /* Details: "In a target servlet of a forward in the Event phase, the   */
      /* method HttpServletResponse.getCharacterEncoding must return null"    */
      {
         PortletURL aurl = portletResp.createActionURL();
         TestButton tb = new TestButton("V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse_getCharacterEncoding", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse_getContentType */
      /* Details: "In a target servlet of a forward in the Event phase, the   */
      /* method HttpServletResponse.getContentType must return null"          */
      {
         PortletURL aurl = portletResp.createActionURL();
         TestButton tb = new TestButton("V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse_getContentType", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse_getLocale */
      /* Details: "In a target servlet of a forward in the Event phase, the   */
      /* method HttpServletResponse.getLocale must return null"               */
      {
         PortletURL aurl = portletResp.createActionURL();
         TestButton tb = new TestButton("V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse_getLocale", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse_getOutputStream */
      /* Details: "In a target servlet of a forward in the Event phase, the   */
      /* method HttpServletResponse.getOutputStream must return an output     */
      /* stream that ignores all input"                                       */
      {
         PortletURL aurl = portletResp.createActionURL();
         TestButton tb = new TestButton("V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse_getOutputStream", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse_getWriter */
      /* Details: "In a target servlet of a forward in the Event phase, the   */
      /* method HttpServletResponse.getWriter must return a writer that       */
      /* ignores all input"                                                   */
      {
         PortletURL aurl = portletResp.createActionURL();
         TestButton tb = new TestButton("V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse_getWriter", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse_isCommitted */
      /* Details: "In a target servlet of a forward in the Event phase, the   */
      /* method HttpServletResponse.isCommitted must return false"            */
      {
         PortletURL aurl = portletResp.createActionURL();
         TestButton tb = new TestButton("V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse_isCommitted", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse_reset */
      /* Details: "In a target servlet of a forward in the Event phase, the   */
      /* method HttpServletResponse.reset does not perform any operation"     */
      {
         PortletURL aurl = portletResp.createActionURL();
         TestButton tb = new TestButton("V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse_reset", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse_resetBuffer */
      /* Details: "In a target servlet of a forward in the Event phase, the   */
      /* method HttpServletResponse.resetBuffer does not perform any          */
      /* operation"                                                           */
      {
         PortletURL aurl = portletResp.createActionURL();
         TestButton tb = new TestButton("V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse_resetBuffer", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse_sendError */
      /* Details: "In a target servlet of a forward in the Event phase, the   */
      /* method HttpServletResponse.sendError does not perform any            */
      /* operation"                                                           */
      {
         PortletURL aurl = portletResp.createActionURL();
         TestButton tb = new TestButton("V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse_sendError", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse_sendRedirect */
      /* Details: "In a target servlet of a forward in the Event phase, the   */
      /* method HttpServletResponse.sendRedirect does not perform any         */
      /* operation"                                                           */
      {
         PortletURL aurl = portletResp.createActionURL();
         TestButton tb = new TestButton("V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse_sendRedirect", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse_setBufferSize */
      /* Details: "In a target servlet of a forward in the Event phase, the   */
      /* method HttpServletResponse.setBufferSize does not perform any        */
      /* operation"                                                           */
      {
         PortletURL aurl = portletResp.createActionURL();
         TestButton tb = new TestButton("V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse_setBufferSize", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse_setCharacterEncoding */
      /* Details: "In a target servlet of a forward in the Event phase, the   */
      /* method HttpServletResponse.setCharacterEncoding does not perform     */
      /* any operation"                                                       */
      {
         PortletURL aurl = portletResp.createActionURL();
         TestButton tb = new TestButton("V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse_setCharacterEncoding", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse_setContentLength */
      /* Details: "In a target servlet of a forward in the Event phase, the   */
      /* method HttpServletResponse.setContentLength does not perform any     */
      /* operation"                                                           */
      {
         PortletURL aurl = portletResp.createActionURL();
         TestButton tb = new TestButton("V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse_setContentLength", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse_setContentType */
      /* Details: "In a target servlet of a forward in the Event phase, the   */
      /* method HttpServletResponse.setContentType does not perform any       */
      /* operation"                                                           */
      {
         PortletURL aurl = portletResp.createActionURL();
         TestButton tb = new TestButton("V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse_setContentType", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse_setDateHeader */
      /* Details: "In a target servlet of a forward in the Event phase, the   */
      /* method HttpServletResponse.setDateHeader does not perform any        */
      /* operation"                                                           */
      {
         PortletURL aurl = portletResp.createActionURL();
         TestButton tb = new TestButton("V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse_setDateHeader", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse_setHeader */
      /* Details: "In a target servlet of a forward in the Event phase, the   */
      /* method HttpServletResponse.setHeader does not perform any            */
      /* operation"                                                           */
      {
         PortletURL aurl = portletResp.createActionURL();
         TestButton tb = new TestButton("V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse_setHeader", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse_setIntHeader */
      /* Details: "In a target servlet of a forward in the Event phase, the   */
      /* method HttpServletResponse.setIntHeader does not perform any         */
      /* operation"                                                           */
      {
         PortletURL aurl = portletResp.createActionURL();
         TestButton tb = new TestButton("V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse_setIntHeader", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse_setLocale */
      /* Details: "In a target servlet of a forward in the Event phase, the   */
      /* method HttpServletResponse.setLocale does not perform any            */
      /* operation"                                                           */
      {
         PortletURL aurl = portletResp.createActionURL();
         TestButton tb = new TestButton("V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse_setLocale", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse_setStatus */
      /* Details: "In a target servlet of a forward in the Event phase, the   */
      /* method HttpServletResponse.setStatus does not perform any            */
      /* operation"                                                           */
      {
         PortletURL aurl = portletResp.createActionURL();
         TestButton tb = new TestButton("V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse_setStatus", aurl);
         tb.writeTo(writer);
      }

   }

}
