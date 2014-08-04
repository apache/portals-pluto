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

import java.io.IOException;
import java.io.PrintWriter;

import java.util.Enumeration;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.util.logging.Logger.*;

import javax.portlet.*;
import javax.portlet.filter.*;
import javax.portlet.tck.beans.ClassChecker;
import javax.portlet.tck.beans.TestCaseDetails;
import javax.portlet.tck.beans.JSR286DispatcherTestCaseDetails;
import static javax.portlet.tck.beans.JSR286DispatcherTestCaseDetails.*;
import javax.portlet.tck.beans.TestResult;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the 
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 */
public class DispatcherTests_SPEC2_19_DispatchForwardServletEvent implements Portlet {
   private static final String LOG_CLASS = 
         DispatcherTests_SPEC2_19_DispatchForwardServletEvent.class.getName();
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
   public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
         throws PortletException, IOException {
   }

   @Override
   public void render(RenderRequest renderRequest, RenderResponse renderResponse)
         throws PortletException, IOException {
      
      if (LOGGER.isLoggable(Level.FINE)) {
         LOGGER.logp(Level.FINE, LOG_CLASS, "render", "Entry");
      }

      PrintWriter writer = renderResponse.getWriter();
      JSR286DispatcherTestCaseDetails tcd = new JSR286DispatcherTestCaseDetails();

      // Create result objects for the tests

      /* TestCase: SPEC2_19_DispatchForwardServletEvent_attributes1           */
      /* Details: "If the request dispatcher is obtained through the          */
      /* getRequestDispatcher method, the request attribute                   */
      /* javax.servlet.forward.request_uri will be set, and equals the        */
      /* value from HTTPServletRequest.getRequestURI for the first servlet    */
      /* in the forward chain"                                                */
      TestResult tr0 = tcd.getTestResultFailed(SPEC2_19_DISPATCHFORWARDSERVLETEVENT_ATTRIBUTES1);
      /* TODO: implement test */
      tr0.writeTo(writer);

      /* TestCase: SPEC2_19_DispatchForwardServletEvent_attributes2           */
      /* Details: "If the request dispatcher is obtained through the          */
      /* getRequestDispatcher method, the request attribute                   */
      /* javax.servlet.forward.context_path will be set, and equals the       */
      /* value from HTTPServletRequest.getContestPath for the first servlet   */
      /* in the forward chain"                                                */
      TestResult tr1 = tcd.getTestResultFailed(SPEC2_19_DISPATCHFORWARDSERVLETEVENT_ATTRIBUTES2);
      /* TODO: implement test */
      tr1.writeTo(writer);

      /* TestCase: SPEC2_19_DispatchForwardServletEvent_attributes3           */
      /* Details: "If the request dispatcher is obtained through the          */
      /* getRequestDispatcher method, the request attribute                   */
      /* javax.servlet.forward.servlet_path will be set, and equals the       */
      /* value from HTTPServletRequest.getSerletPath for the first servlet    */
      /* in the forward chain"                                                */
      TestResult tr2 = tcd.getTestResultFailed(SPEC2_19_DISPATCHFORWARDSERVLETEVENT_ATTRIBUTES3);
      /* TODO: implement test */
      tr2.writeTo(writer);

      /* TestCase: SPEC2_19_DispatchForwardServletEvent_attributes4           */
      /* Details: "If the request dispatcher is obtained through the          */
      /* getRequestDispatcher method, the request attribute                   */
      /* javax.servlet.forward.path_info will be set, and equals the value    */
      /* from HTTPServletRequest.getPathInfo for the first servlet in the     */
      /* forward chain"                                                       */
      TestResult tr3 = tcd.getTestResultFailed(SPEC2_19_DISPATCHFORWARDSERVLETEVENT_ATTRIBUTES4);
      /* TODO: implement test */
      tr3.writeTo(writer);

      /* TestCase: SPEC2_19_DispatchForwardServletEvent_attributes5           */
      /* Details: "If the request dispatcher is obtained through the          */
      /* getRequestDispatcher method, the request attribute                   */
      /* javax.servlet.forward.query_string will be set, and equals the       */
      /* value from HTTPServletRequest.getQueryString for the first servlet   */
      /* in the forward chain"                                                */
      TestResult tr4 = tcd.getTestResultFailed(SPEC2_19_DISPATCHFORWARDSERVLETEVENT_ATTRIBUTES5);
      /* TODO: implement test */
      tr4.writeTo(writer);

      /* TestCase: SPEC2_19_DispatchForwardServletEvent_attributes6           */
      /* Details: "The request attribute javax.portlet.config must be set     */
      /* to the javax.portlet.PortletConfig object"                           */
      TestResult tr5 = tcd.getTestResultFailed(SPEC2_19_DISPATCHFORWARDSERVLETEVENT_ATTRIBUTES6);
      /* TODO: implement test */
      tr5.writeTo(writer);

      /* TestCase: SPEC2_19_DispatchForwardServletEvent_attributes7           */
      /* Details: "For forwards from the processEvent method, The request     */
      /* attribute javax.portlet.request must be set to the                   */
      /* javax.portlet.EventRequest object"                                   */
      TestResult tr6 = tcd.getTestResultFailed(SPEC2_19_DISPATCHFORWARDSERVLETEVENT_ATTRIBUTES7);
      /* TODO: implement test */
      tr6.writeTo(writer);

      /* TestCase: SPEC2_19_DispatchForwardServletEvent_attributes8           */
      /* Details: "For forwards from the processEvent method, The request     */
      /* attribute javax.portlet.response must be set to the                  */
      /* javax.portlet.EventResponse object"                                  */
      TestResult tr7 = tcd.getTestResultFailed(SPEC2_19_DISPATCHFORWARDSERVLETEVENT_ATTRIBUTES8);
      /* TODO: implement test */
      tr7.writeTo(writer);


   }

}

