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
import javax.portlet.tck.beans.*;
import static javax.portlet.tck.beans.JSR286DispatcherTestCaseDetails.*;
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
 * portlet DispatcherTests_SPEC2_19_IncludeServletEvent_event
 *
 */
public class DispatcherTests_SPEC2_19_IncludeServletEvent implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         DispatcherTests_SPEC2_19_IncludeServletEvent.class.getName();
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
      portletReq.setAttribute("void", tid);

      StringWriter writer = new StringWriter();

      QName eventQName = new QName(TCKNAMESPACE,
             "DispatcherTests_SPEC2_19_IncludeServletEvent");
      portletResp.setEvent(eventQName, "Hi!");
   }

   @Override
   public void serveResource(ResourceRequest portletReq, ResourceResponse portletResp)
         throws PortletException, IOException {
      LOGGER.entering(LOG_CLASS, "main portlet serveResource entry");

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute("void", tid);

      PrintWriter writer = portletResp.getWriter();

   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp)
         throws PortletException, IOException {
      LOGGER.entering(LOG_CLASS, "main portlet render entry");

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute("void", tid);

      PrintWriter writer = portletResp.getWriter();

      /* TestCase: SPEC2_19_IncludeServletEvent_attributes1                   */
      /* Details: "If the request dispatcher is obtained through the          */
      /* getRequestDispatcher method, the request attribute                   */
      /* javax.servlet.include.request_uri will be set, and equals the        */
      /* value from HTTPServletRequest.getRequestURI for the first servlet    */
      /* in the include chain"                                                */
      {
         PortletURL aurl = portletResp.createActionURL();
         TestButton tb = new TestButton("SPEC2_19_IncludeServletEvent_attributes1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: SPEC2_19_IncludeServletEvent_attributes2                   */
      /* Details: "If the request dispatcher is obtained through the          */
      /* getRequestDispatcher method, the request attribute                   */
      /* javax.servlet.include.context_path will be set, and equals the       */
      /* value from HTTPServletRequest.getContestPath for the first servlet   */
      /* in the include chain"                                                */
      {
         PortletURL aurl = portletResp.createActionURL();
         TestButton tb = new TestButton("SPEC2_19_IncludeServletEvent_attributes2", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: SPEC2_19_IncludeServletEvent_attributes3                   */
      /* Details: "If the request dispatcher is obtained through the          */
      /* getRequestDispatcher method, the request attribute                   */
      /* javax.servlet.include.servlet_path will be set, and equals the       */
      /* value from HTTPServletRequest.getServletPath for the first servlet   */
      /* in the include chain"                                                */
      {
         PortletURL aurl = portletResp.createActionURL();
         TestButton tb = new TestButton("SPEC2_19_IncludeServletEvent_attributes3", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: SPEC2_19_IncludeServletEvent_attributes4                   */
      /* Details: "If the request dispatcher is obtained through the          */
      /* getRequestDispatcher method, the request attribute                   */
      /* javax.servlet.include.path_info will be set, and equals the value    */
      /* from HTTPServletRequest.getPathInfo for the first servlet in the     */
      /* include chain"                                                       */
      {
         PortletURL aurl = portletResp.createActionURL();
         TestButton tb = new TestButton("SPEC2_19_IncludeServletEvent_attributes4", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: SPEC2_19_IncludeServletEvent_attributes5                   */
      /* Details: "If the request dispatcher is obtained through the          */
      /* getRequestDispatcher method, the request attribute                   */
      /* javax.servlet.include.query_string will be set, and equals the       */
      /* value from HTTPServletRequest.getQueryString for the first servlet   */
      /* in the include chain"                                                */
      {
         PortletURL aurl = portletResp.createActionURL();
         TestButton tb = new TestButton("SPEC2_19_IncludeServletEvent_attributes5", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: SPEC2_19_IncludeServletEvent_attributes6                   */
      /* Details: "The request attribute javax.portlet.config must be set     */
      /* to the javax.portlet.PortletConfig object"                           */
      {
         PortletURL aurl = portletResp.createActionURL();
         TestButton tb = new TestButton("SPEC2_19_IncludeServletEvent_attributes6", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: SPEC2_19_IncludeServletEvent_attributes7                   */
      /* Details: "For includes from the processEvent method, The request     */
      /* attribute javax.portlet.request must be set to the                   */
      /* javax.portlet.EventRequest object"                                   */
      {
         PortletURL aurl = portletResp.createActionURL();
         TestButton tb = new TestButton("SPEC2_19_IncludeServletEvent_attributes7", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: SPEC2_19_IncludeServletEvent_attributes8                   */
      /* Details: "For includes from the processEvent method, The request     */
      /* attribute javax.portlet.response must be set to the                  */
      /* javax.portlet.EventResponse object"                                  */
      {
         PortletURL aurl = portletResp.createActionURL();
         TestButton tb = new TestButton("SPEC2_19_IncludeServletEvent_attributes8", aurl);
         tb.writeTo(writer);
      }

   }

}
