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

package javax.portlet.tck.URLTests.portlets;

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
public class V2URLTests_PortletURL implements Portlet {
   private static final String LOG_CLASS = 
         V2URLTests_PortletURL.class.getName();
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
      ClassChecker cc = new ClassChecker(renderResponse.createRenderURL().getClass());

      // Create result objects for the tests

      /* TestCase: PortletURL_implementsBaseURL2 */
      /* Details: "All tests described for the BaseURL execute correctly with the PortletURL" */
      TestResult tr0 = tcd.getTestResultFailed(PORTLETURL_IMPLEMENTSBASEURL2);
      /* TODO: implement test */

      /* TestCase: PortletURL_setWindowState1 */
      /* Details: "Sets the WindowState to be used when the URL is activated" */
      TestResult tr1 = tcd.getTestResultFailed(PORTLETURL_SETWINDOWSTATE1);
      /* TODO: implement test */

      /* TestCase: PortletURL_setWindowState2 */
      /* Details: "Throws WindowStateException if the portal does not support the specified Window State" */
      TestResult tr2 = tcd.getTestResultFailed(PORTLETURL_SETWINDOWSTATE2);
      /* TODO: implement test */

      /* TestCase: PortletURL_setWindowState3 */
      /* Details: "Throws WindowStateException if the specified WindowState is not declared in the deployment descriptor" */
      TestResult tr3 = tcd.getTestResultFailed(PORTLETURL_SETWINDOWSTATE3);
      /* TODO: implement test */

      /* TestCase: PortletURL_setWindowState4 */
      /* Details: "Throws WindowStateException if the user is not allowed to switch to the specified WindowState" */
      TestResult tr4 = tcd.getTestResultFailed(PORTLETURL_SETWINDOWSTATE4);
      /* TODO: implement test */

      /* TestCase: PortletURL_setPortletMode1 */
      /* Details: "Sets the PortletMode to be used when the URL is activated" */
      TestResult tr5 = tcd.getTestResultFailed(PORTLETURL_SETPORTLETMODE1);
      /* TODO: implement test */

      /* TestCase: PortletURL_setPortletMode2 */
      /* Details: "Throws PortletModeException if the portal does not support the specified Window State" */
      TestResult tr6 = tcd.getTestResultFailed(PORTLETURL_SETPORTLETMODE2);
      /* TODO: implement test */

      /* TestCase: PortletURL_setPortletMode3 */
      /* Details: "Throws PortletModeException if the specified PortletMode is not declared in the deployment descriptor" */
      TestResult tr7 = tcd.getTestResultFailed(PORTLETURL_SETPORTLETMODE3);
      /* TODO: implement test */

      /* TestCase: PortletURL_setPortletMode4 */
      /* Details: "Throws PortletModeException if the user is not allowed to switch to the specified PortletMode" */
      TestResult tr8 = tcd.getTestResultFailed(PORTLETURL_SETPORTLETMODE4);
      /* TODO: implement test */

      /* TestCase: PortletURL_getPortletMode1 */
      /* Details: "Returns the PortletMode object set on the URL" */
      TestResult tr9 = tcd.getTestResultFailed(PORTLETURL_GETPORTLETMODE1);
      /* TODO: implement test */

      /* TestCase: PortletURL_getPortletMode2 */
      /* Details: "Returns null if the PortletMode has not been set" */
      TestResult tr10 = tcd.getTestResultFailed(PORTLETURL_GETPORTLETMODE2);
      /* TODO: implement test */

      /* TestCase: PortletURL_getWindowState1 */
      /* Details: "Returns the WindowState object set on the URL" */
      TestResult tr11 = tcd.getTestResultFailed(PORTLETURL_GETWINDOWSTATE1);
      /* TODO: implement test */

      /* TestCase: PortletURL_getWindowState2 */
      /* Details: "Returns null if the Window State has not been set" */
      TestResult tr12 = tcd.getTestResultFailed(PORTLETURL_GETWINDOWSTATE2);
      /* TODO: implement test */

      /* TestCase: PortletURL_removePublicRenderParameter1 */
      /* Details: "Removes the specified public render parameter" */
      TestResult tr13 = tcd.getTestResultFailed(PORTLETURL_REMOVEPUBLICRENDERPARAMETER1);
      /* TODO: implement test */

      /* TestCase: PortletURL_removePublicRenderParameter2 */
      /* Details: "Throws IllegalArgumentException if the name is null" */
      TestResult tr14 = tcd.getTestResultFailed(PORTLETURL_REMOVEPUBLICRENDERPARAMETER2);
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
      tr13.writeTo(writer);
      tr14.writeTo(writer);


   }

}

