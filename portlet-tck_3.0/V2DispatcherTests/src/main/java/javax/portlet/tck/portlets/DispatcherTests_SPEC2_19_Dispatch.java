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
public class DispatcherTests_SPEC2_19_Dispatch implements Portlet {
   private static final String LOG_CLASS = 
         DispatcherTests_SPEC2_19_Dispatch.class.getName();
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

      /* TestCase: SPEC2_19_Dispatch_getDispatcher1                           */
      /* Details: "The PortletContext getRequestDispatcher method returns a   */
      /* PortletRequestDispatcher for a path within the portlet               */
      /* application"                                                         */
      TestResult tr0 = tcd.getTestResultFailed(SPEC2_19_DISPATCH_GETDISPATCHER1);
      /* TODO: implement test */
      tr0.writeTo(writer);

      /* TestCase: SPEC2_19_Dispatch_getDispatcher2                           */
      /* Details: "If the path provided to getRequestDispatcher method        */
      /* contains query strings, parameters specified in the query strings    */
      /* must be passed to the included servlet"                              */
      TestResult tr1 = tcd.getTestResultFailed(SPEC2_19_DISPATCH_GETDISPATCHER2);
      /* TODO: implement test */
      tr1.writeTo(writer);

      /* TestCase: SPEC2_19_Dispatch_getDispatcher3                           */
      /* Details: "If the path provided to getRequestDispatcher method        */
      /* contains query strings, parameters specified in the query strings    */
      /* must be passed to the forwarded servlet"                             */
      TestResult tr2 = tcd.getTestResultFailed(SPEC2_19_DISPATCH_GETDISPATCHER3);
      /* TODO: implement test */
      tr2.writeTo(writer);

      /* TestCase: SPEC2_19_Dispatch_getDispatcher4                           */
      /* Details: "Parameters specified in the query strings must be          */
      /* aggregated with the portlet render parameters"                       */
      TestResult tr3 = tcd.getTestResultFailed(SPEC2_19_DISPATCH_GETDISPATCHER4);
      /* TODO: implement test */
      tr3.writeTo(writer);

      /* TestCase: SPEC2_19_Dispatch_getDispatcher5                           */
      /* Details: "If query string parameters have the same names as render   */
      /* parameter names, the query string parameters appear in the           */
      /* parameter values array before the render parameter values"           */
      TestResult tr4 = tcd.getTestResultFailed(SPEC2_19_DISPATCH_GETDISPATCHER5);
      /* TODO: implement test */
      tr4.writeTo(writer);

      /* TestCase: SPEC2_19_Dispatch_getDispatcher6                           */
      /* Details: "The parameters associated with a request dispatcher are    */
      /* scoped only for the duration of the include or forward call"         */
      TestResult tr5 = tcd.getTestResultFailed(SPEC2_19_DISPATCH_GETDISPATCHER6);
      /* TODO: implement test */
      tr5.writeTo(writer);

      /* TestCase: SPEC2_19_Dispatch_getDispatcher7                           */
      /* Details: "If the path provided to getRequestDispatcher method does   */
      /* not start with \"/\", the method returns null"                       */
      TestResult tr6 = tcd.getTestResultFailed(SPEC2_19_DISPATCH_GETDISPATCHER7);
      /* TODO: implement test */
      tr6.writeTo(writer);

      /* TestCase: SPEC2_19_Dispatch_getDispatcher8                           */
      /* Details: "If the path provided to getRequestDispatcher method ends   */
      /* with \"/\", the method returns null"                                 */
      TestResult tr7 = tcd.getTestResultFailed(SPEC2_19_DISPATCH_GETDISPATCHER8);
      /* TODO: implement test */
      tr7.writeTo(writer);

      /* TestCase: SPEC2_19_Dispatch_getDispatcher9                           */
      /* Details: "If the path provided to getRequestDispatcher method does   */
      /* not specify a valid path, the method returns null"                   */
      TestResult tr8 = tcd.getTestResultFailed(SPEC2_19_DISPATCH_GETDISPATCHER9);
      /* TODO: implement test */
      tr8.writeTo(writer);

      /* TestCase: SPEC2_19_Dispatch_getDispatcher10                          */
      /* Details: "The PortletContext getNamedDispatcher method returns a     */
      /* PortletRequestDispatcher for a servlet within the portlet            */
      /* application"                                                         */
      TestResult tr9 = tcd.getTestResultFailed(SPEC2_19_DISPATCH_GETDISPATCHER10);
      /* TODO: implement test */
      tr9.writeTo(writer);

      /* TestCase: SPEC2_19_Dispatch_getDispatcher11                          */
      /* Details: "If the name provided to getNamedDispatcher method is not   */
      /* valid, the method returns null"                                      */
      TestResult tr10 = tcd.getTestResultFailed(SPEC2_19_DISPATCH_GETDISPATCHER11);
      /* TODO: implement test */
      tr10.writeTo(writer);


   }

}

