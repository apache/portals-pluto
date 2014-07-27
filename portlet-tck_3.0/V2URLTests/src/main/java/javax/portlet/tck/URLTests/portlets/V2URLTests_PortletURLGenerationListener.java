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
public class V2URLTests_PortletURLGenerationListener implements Portlet {
   private static final String LOG_CLASS = 
         V2URLTests_PortletURLGenerationListener.class.getName();
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
      ClassChecker cc = new ClassChecker(PortletURLGenerationListener.class);

      // Create result objects for the tests

      /* TestCase: PortletURLGenerationListener_configuration */
      /* Details: "A PortletURLGenerationListener can be configured in the portlet deployment descriptor" */
      TestResult tr0 = tcd.getTestResultFailed(PORTLETURLGENERATIONLISTENER_CONFIGURATION);
      /* TODO: implement test */

      /* TestCase: PortletURLGenerationListener_filterActionURL1 */
      /* Details: "The filterActionURL(PortletURL) method is called before the toString or write methods are executed on an action URL" */
      TestResult tr1 = tcd.getTestResultFailed(PORTLETURLGENERATIONLISTENER_FILTERACTIONURL1);
      /* TODO: implement test */

      /* TestCase: PortletURLGenerationListener_filterActionURL2 */
      /* Details: "The filterActionURL method is passed the PortletURL object representing the action URL" */
      TestResult tr2 = tcd.getTestResultFailed(PORTLETURLGENERATIONLISTENER_FILTERACTIONURL2);
      /* TODO: implement test */

      /* TestCase: PortletURLGenerationListener_filterActionURL3 */
      /* Details: "The input action URL object can be modified by setting a parameter and the modified URL object is processed by the PortletURL toString or write method" */
      TestResult tr3 = tcd.getTestResultFailed(PORTLETURLGENERATIONLISTENER_FILTERACTIONURL3);
      /* TODO: implement test */

      /* TestCase: PortletURLGenerationListener_filterActionURL4 */
      /* Details: "The input action URL object can be modified by setting a property and the modified URL object is processed by the PortletURL toString or write method" */
      TestResult tr4 = tcd.getTestResultFailed(PORTLETURLGENERATIONLISTENER_FILTERACTIONURL4);
      /* TODO: implement test */

      /* TestCase: PortletURLGenerationListener_filterRenderURL5 */
      /* Details: "The filterRenderURL(PortletURL) method is called before the toString or write methods are executed on an action URL" */
      TestResult tr5 = tcd.getTestResultFailed(PORTLETURLGENERATIONLISTENER_FILTERRENDERURL5);
      /* TODO: implement test */

      /* TestCase: PortletURLGenerationListener_filterRenderURL6 */
      /* Details: "The filterRenderURL method is passed the PortletURL object representing the action URL" */
      TestResult tr6 = tcd.getTestResultFailed(PORTLETURLGENERATIONLISTENER_FILTERRENDERURL6);
      /* TODO: implement test */

      /* TestCase: PortletURLGenerationListener_filterRenderURL7 */
      /* Details: "The input action URL object can be modified by setting a parameter and the modified URL object is processed by the PortletURL toString or write method" */
      TestResult tr7 = tcd.getTestResultFailed(PORTLETURLGENERATIONLISTENER_FILTERRENDERURL7);
      /* TODO: implement test */

      /* TestCase: PortletURLGenerationListener_filterRenderURL8 */
      /* Details: "The input action URL object can be modified by setting a property and the modified URL object is processed by the PortletURL toString or write method" */
      TestResult tr8 = tcd.getTestResultFailed(PORTLETURLGENERATIONLISTENER_FILTERRENDERURL8);
      /* TODO: implement test */

      /* TestCase: PortletURLGenerationListener_filterResourceURL1 */
      /* Details: "The filterResourceURL(PortletURL) method is called before the toString or write methods are executed on an action URL" */
      TestResult tr9 = tcd.getTestResultFailed(PORTLETURLGENERATIONLISTENER_FILTERRESOURCEURL1);
      /* TODO: implement test */

      /* TestCase: PortletURLGenerationListener_filterResourceURL2 */
      /* Details: "The filterResourceURL method is passed the PortletURL object representing the action URL" */
      TestResult tr10 = tcd.getTestResultFailed(PORTLETURLGENERATIONLISTENER_FILTERRESOURCEURL2);
      /* TODO: implement test */

      /* TestCase: PortletURLGenerationListener_filterResourceURL3 */
      /* Details: "The input action URL object can be modified by setting a parameter and the modified URL object is processed by the PortletURL toString or write method" */
      TestResult tr11 = tcd.getTestResultFailed(PORTLETURLGENERATIONLISTENER_FILTERRESOURCEURL3);
      /* TODO: implement test */

      /* TestCase: PortletURLGenerationListener_filterResourceURL4 */
      /* Details: "The input action URL object can be modified by setting a property and the modified URL object is processed by the PortletURL toString or write method" */
      TestResult tr12 = tcd.getTestResultFailed(PORTLETURLGENERATIONLISTENER_FILTERRESOURCEURL4);
      /* TODO: implement test */

      /* TestCase: PortletURLGenerationListener_filterResourceURL5 */
      /* Details: "The input action URL object can be modified by setting the resource ID and the modified URL object is processed by the PortletURL toString or write method" */
      TestResult tr13 = tcd.getTestResultFailed(PORTLETURLGENERATIONLISTENER_FILTERRESOURCEURL5);
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


   }

}

