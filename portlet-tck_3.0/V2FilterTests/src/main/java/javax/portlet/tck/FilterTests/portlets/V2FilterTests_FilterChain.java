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

package javax.portlet.tck.FilterTests.portlets;

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
public class V2FilterTests_FilterChain implements Portlet {
   private static final String LOG_CLASS = 
         V2FilterTests_FilterChain.class.getName();
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
      ClassChecker cc = new ClassChecker(FilterChain.class);

      // Create result objects for the tests

      /* TestCase: FilterChain_invokeActionFilter */
      /* Details: "Invoking doFilter(ActionRequest, ActionResponse) causes next filter to be invoked" */
      TestResult tr0 = tcd.getTestResultFailed(FILTERCHAIN_INVOKEACTIONFILTER);
      /* TODO: implement test */

      /* TestCase: FilterChain_invokeActionFilter2 */
      /* Details: "Invoking doFilter(ActionRequest, ActionResponse) causes portlet action method to be invoked" */
      TestResult tr1 = tcd.getTestResultFailed(FILTERCHAIN_INVOKEACTIONFILTER2);
      /* TODO: implement test */

      /* TestCase: FilterChain_invokeActionException */
      /* Details: "Invoking doFilter(ActionRequest, ActionResponse) throws PortletException" */
      TestResult tr2 = tcd.getTestResultFailed(FILTERCHAIN_INVOKEACTIONEXCEPTION);
      /* TODO: implement test */

      /* TestCase: FilterChain_invokeActionException2 */
      /* Details: "Invoking doFilter(ActionRequest, ActionResponse) throws IOException" */
      TestResult tr3 = tcd.getTestResultFailed(FILTERCHAIN_INVOKEACTIONEXCEPTION2);
      /* TODO: implement test */

      /* TestCase: FilterChain_invokeEventFilter */
      /* Details: "Invoking doFilter(EventRequest, EventResponse) causes next filter to be invoked" */
      TestResult tr4 = tcd.getTestResultFailed(FILTERCHAIN_INVOKEEVENTFILTER);
      /* TODO: implement test */

      /* TestCase: FilterChain_invokeEventFilter2 */
      /* Details: "Invoking doFilter(EventRequest, EventResponse) causes portlet Event method to be invoked" */
      TestResult tr5 = tcd.getTestResultFailed(FILTERCHAIN_INVOKEEVENTFILTER2);
      /* TODO: implement test */

      /* TestCase: FilterChain_invokeEventException */
      /* Details: "Invoking doFilter(EventRequest, EventResponse) throws PortletException" */
      TestResult tr6 = tcd.getTestResultFailed(FILTERCHAIN_INVOKEEVENTEXCEPTION);
      /* TODO: implement test */

      /* TestCase: FilterChain_invokeEventException2 */
      /* Details: "Invoking doFilter(EventRequest, EventResponse) throws IOException" */
      TestResult tr7 = tcd.getTestResultFailed(FILTERCHAIN_INVOKEEVENTEXCEPTION2);
      /* TODO: implement test */

      /* TestCase: FilterChain_invokeRenderFilter */
      /* Details: "Invoking doFilter(RenderRequest, RenderResponse) causes next filter to be invoked" */
      TestResult tr8 = tcd.getTestResultFailed(FILTERCHAIN_INVOKERENDERFILTER);
      /* TODO: implement test */

      /* TestCase: FilterChain_invokeRenderFilter2 */
      /* Details: "Invoking doFilter(RenderRequest, RenderResponse) causes portlet Render method to be invoked" */
      TestResult tr9 = tcd.getTestResultFailed(FILTERCHAIN_INVOKERENDERFILTER2);
      /* TODO: implement test */

      /* TestCase: FilterChain_invokeRenderException */
      /* Details: "Invoking doFilter(RenderRequest, RenderResponse) throws PortletException" */
      TestResult tr10 = tcd.getTestResultFailed(FILTERCHAIN_INVOKERENDEREXCEPTION);
      /* TODO: implement test */

      /* TestCase: FilterChain_invokeRenderException2 */
      /* Details: "Invoking doFilter(RenderRequest, RenderResponse) throws IOException" */
      TestResult tr11 = tcd.getTestResultFailed(FILTERCHAIN_INVOKERENDEREXCEPTION2);
      /* TODO: implement test */

      /* TestCase: FilterChain_invokeResourceFilter */
      /* Details: "Invoking doFilter(ResourceRequest, ResourceResponse) causes next filter to be invoked" */
      TestResult tr12 = tcd.getTestResultFailed(FILTERCHAIN_INVOKERESOURCEFILTER);
      /* TODO: implement test */

      /* TestCase: FilterChain_invokeResourceFilter2 */
      /* Details: "Invoking doFilter(ResourceRequest, ResourceResponse) causes portlet Resource method to be invoked" */
      TestResult tr13 = tcd.getTestResultFailed(FILTERCHAIN_INVOKERESOURCEFILTER2);
      /* TODO: implement test */

      /* TestCase: FilterChain_invokeResourceException */
      /* Details: "Invoking doFilter(ResourceRequest, ResourceResponse) throws PortletException" */
      TestResult tr14 = tcd.getTestResultFailed(FILTERCHAIN_INVOKERESOURCEEXCEPTION);
      /* TODO: implement test */

      /* TestCase: FilterChain_invokeResourceException2 */
      /* Details: "Invoking doFilter(ResourceRequest, ResourceResponse) throws IOException" */
      TestResult tr15 = tcd.getTestResultFailed(FILTERCHAIN_INVOKERESOURCEEXCEPTION2);
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
      tr15.writeTo(writer);


   }

}

