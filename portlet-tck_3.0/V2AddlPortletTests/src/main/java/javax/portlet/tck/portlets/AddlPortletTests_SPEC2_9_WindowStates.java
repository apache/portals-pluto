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
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.*;
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
 * portlet AddlPortletTests_SPEC2_9_WindowStates_event
 *
 */
public class AddlPortletTests_SPEC2_9_WindowStates implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         AddlPortletTests_SPEC2_9_WindowStates.class.getName();
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

      portletResp.setRenderParameters(portletReq.getParameterMap());
      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      StringWriter writer = new StringWriter();

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

      JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();

      // Create result objects for the tests

      /* TestCase: V2AddlPortletTests_SPEC2_9_WindowStates_declaringWindowStates1 */
      /* Details: "Support for the NORMAL window state does not need to be    */
      /* declared in the deployment descriptor"                               */
      TestResult tr0 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_9_WINDOWSTATES_DECLARINGWINDOWSTATES1);
      /* TODO: implement test */
      tr0.appendTcDetail("Not implemented.");
      tr0.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_9_WindowStates_declaringWindowStates2 */
      /* Details: "Support for the MINIMIZED window state does not need to    */
      /* be declared in the deployment descriptor"                            */
      TestResult tr1 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_9_WINDOWSTATES_DECLARINGWINDOWSTATES2);
      /* TODO: implement test */
      tr1.appendTcDetail("Not implemented.");
      tr1.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_9_WindowStates_declaringWindowStates3 */
      /* Details: "Support for the MAXIMIZED window state does not need to    */
      /* be declared in the deployment descriptor"                            */
      TestResult tr2 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_9_WINDOWSTATES_DECLARINGWINDOWSTATES3);
      /* TODO: implement test */
      tr2.appendTcDetail("Not implemented.");
      tr2.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_9_WindowStates_declaringWindowStates4 */
      /* Details: "A custom window state may be declared in the deployment    */
      /* descriptor"                                                          */
      TestResult tr3 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_9_WINDOWSTATES_DECLARINGWINDOWSTATES4);
      /* TODO: implement test */
      tr3.appendTcDetail("Not implemented.");
      tr3.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_9_WindowStates_declaringWindowStates5 */
      /* Details: "The PortletRequest.isWindowStateAllowed method must        */
      /* return FALSE for a custom window state that is not supported by      */
      /* the portlet container"                                               */
      TestResult tr4 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_9_WINDOWSTATES_DECLARINGWINDOWSTATES5);
      /* TODO: implement test */
      tr4.appendTcDetail("Not implemented.");
      tr4.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_9_WindowStates_declaringWindowStates6 */
      /* Details: "The portlet container must ignore all custom window        */
      /* states in the deployment descriptor that are not supported by the    */
      /* portal"                                                              */
      TestResult tr5 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_9_WINDOWSTATES_DECLARINGWINDOWSTATES6);
      /* TODO: implement test */
      tr5.appendTcDetail("Not implemented.");
      tr5.writeTo(writer);

      /* TestCase: V2AddlPortletTests_SPEC2_9_WindowStates_declaringWindowStates7 */
      /* Details: "The portlet must not be invoked in a window state other    */
      /* than NORMAL, MINIMIZED, or MAXIMIZED that has not been declared to   */
      /* be supported for a given markup type"                                */
      TestResult tr6 = tcd.getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_9_WINDOWSTATES_DECLARINGWINDOWSTATES7);
      /* TODO: implement test */
      tr6.appendTcDetail("Not implemented.");
      tr6.writeTo(writer);

   }

}
