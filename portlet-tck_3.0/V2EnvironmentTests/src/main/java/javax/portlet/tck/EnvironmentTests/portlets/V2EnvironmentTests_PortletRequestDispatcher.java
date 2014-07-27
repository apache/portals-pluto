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

package javax.portlet.tck.EnvironmentTests.portlets;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.Enumeration;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.portlet.*;
import javax.portlet.filter.*;
import javax.portlet.tck.beans.ClassChecker;
import javax.portlet.tck.beans.TestCaseDetails;
import javax.portlet.tck.beans.JSR286ApiTestCaseDetails;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.*;
import javax.portlet.tck.beans.TestResult;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the 
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 */
public class V2EnvironmentTests_PortletRequestDispatcher implements Portlet {
   private static final String LOG_CLASS = 
         V2EnvironmentTests_PortletRequestDispatcher.class.getName();
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
      JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();
      ClassChecker cc = new ClassChecker(portletConfig.getPortletContext().getRequestDispatcher("/generated-resources/xml/module/tck-V2EnvironmentTests-tests.xml").getClass());

      // Create result objects for the tests

      /* TestCase: PortletRequestDispatcher_includeA1 */
      /* Details: "Includes the content of a JSP page in the response" */
      TestResult tr0 = tcd.getTestResultFailed(PORTLETREQUESTDISPATCHER_INCLUDEA1);
      /* TODO: implement test */

      /* TestCase: PortletRequestDispatcher_includeA2 */
      /* Details: "Includes the content of a HTML Page in the response" */
      TestResult tr1 = tcd.getTestResultFailed(PORTLETREQUESTDISPATCHER_INCLUDEA2);
      /* TODO: implement test */

      /* TestCase: PortletRequestDispatcher_includeA3 */
      /* Details: "The included servlet cannot change the status code. The attempt is ignored" */
      TestResult tr2 = tcd.getTestResultFailed(PORTLETREQUESTDISPATCHER_INCLUDEA3);
      /* TODO: implement test */

      /* TestCase: PortletRequestDispatcher_includeA4 */
      /* Details: "The included servlet cannot set the headers. The Attempt is ignored" */
      TestResult tr3 = tcd.getTestResultFailed(PORTLETREQUESTDISPATCHER_INCLUDEA4);
      /* TODO: implement test */

      /* TestCase: PortletRequestDispatcher_includeB1 */
      /* Details: "Includes the content of a JSP page in the response" */
      TestResult tr4 = tcd.getTestResultFailed(PORTLETREQUESTDISPATCHER_INCLUDEB1);
      /* TODO: implement test */

      /* TestCase: PortletRequestDispatcher_includeB2 */
      /* Details: "Includes the content of a HTML Page in the response" */
      TestResult tr5 = tcd.getTestResultFailed(PORTLETREQUESTDISPATCHER_INCLUDEB2);
      /* TODO: implement test */

      /* TestCase: PortletRequestDispatcher_includeB3 */
      /* Details: "The included servlet cannot change the status code. The attempt is ignored" */
      TestResult tr6 = tcd.getTestResultFailed(PORTLETREQUESTDISPATCHER_INCLUDEB3);
      /* TODO: implement test */

      /* TestCase: PortletRequestDispatcher_includeB4 */
      /* Details: "The included servlet cannot set the headers. The attempt is ignored" */
      TestResult tr7 = tcd.getTestResultFailed(PORTLETREQUESTDISPATCHER_INCLUDEB4);
      /* TODO: implement test */

      /* TestCase: PortletRequestDispatcher_forward1 */
      /* Details: "Can forward to a JSP page to create the response" */
      TestResult tr8 = tcd.getTestResultFailed(PORTLETREQUESTDISPATCHER_FORWARD1);
      /* TODO: implement test */

      /* TestCase: PortletRequestDispatcher_forward2 */
      /* Details: "Can forward to a HTML Page to create the response" */
      TestResult tr9 = tcd.getTestResultFailed(PORTLETREQUESTDISPATCHER_FORWARD2);
      /* TODO: implement test */

      /* TestCase: PortletRequestDispatcher_forward3 */
      /* Details: "Throws IllegalStateException if the response was already committed" */
      TestResult tr10 = tcd.getTestResultFailed(PORTLETREQUESTDISPATCHER_FORWARD3);
      /* TODO: implement test */

      /* TestCase: PortletRequestDispatcher_forward4 */
      /* Details: "Throws PortletException if the forwarded servlet throws any excpetion other than IOException or a runtime exception " */
      TestResult tr11 = tcd.getTestResultFailed(PORTLETREQUESTDISPATCHER_FORWARD4);
      /* TODO: implement test */

      /* TestCase: PortletRequestDispatcher_forward5 */
      /* Details: "Throws IOException if the forwarded servlet an IOException" */
      TestResult tr12 = tcd.getTestResultFailed(PORTLETREQUESTDISPATCHER_FORWARD5);
      /* TODO: implement test */



      // Write the results to the output stream

      tr0.writeTo(writer);
      tr1.writeTo(writer);
      tr2.writeTo(writer);
      tr3.writeTo(writer);
      tr4.writeTo(writer);
      tr5.writeTo(writer);
      tr6.writeTo(writer);
      tr7.writeTo(writer);
      tr8.writeTo(writer);
      tr9.writeTo(writer);
      tr10.writeTo(writer);
      tr11.writeTo(writer);
      tr12.writeTo(writer);


   }

}

