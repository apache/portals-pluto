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
public class V2FilterTests_PortletFilter implements Portlet {
   private static final String LOG_CLASS = 
         V2FilterTests_PortletFilter.class.getName();
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
      ClassChecker cc = new ClassChecker(PortletFilter.class);

      // Create result objects for the tests

      /* TestCase: PortletFilter_initAction1 */
      /* Details: "The init(FilterConfig) method is called when an ActionFilter is configured" */
      TestResult tr0 = tcd.getTestResultFailed(PORTLETFILTER_INITACTION1);
      /* TODO: implement test */

      /* TestCase: PortletFilter_initAction2 */
      /* Details: "The init(FilterConfig) method for an ActionFilter is passed a FilterConfig object" */
      TestResult tr1 = tcd.getTestResultFailed(PORTLETFILTER_INITACTION2);
      /* TODO: implement test */

      /* TestCase: PortletFilter_initAction3 */
      /* Details: "If the init(FilterConfig) method for an ActionFilter throws a PortletException, the filter is not placed in service" */
      TestResult tr2 = tcd.getTestResultFailed(PORTLETFILTER_INITACTION3);
      /* TODO: implement test */

      /* TestCase: PortletFilter_destroyAction1 */
      /* Details: "The destroy() method is called when an ActionFilter is taken out of service" */
      TestResult tr3 = tcd.getTestResultFailed(PORTLETFILTER_DESTROYACTION1);
      /* TODO: implement test */

      /* TestCase: PortletFilter_destroyAction2 */
      /* Details: "After the destroy() method for an ActionFilter is called, no other filter method is called" */
      TestResult tr4 = tcd.getTestResultFailed(PORTLETFILTER_DESTROYACTION2);
      /* TODO: implement test */

      /* TestCase: PortletFilter_initEvent1 */
      /* Details: "The init(FilterConfig) method is called when an EventFilter is configured" */
      TestResult tr5 = tcd.getTestResultFailed(PORTLETFILTER_INITEVENT1);
      /* TODO: implement test */

      /* TestCase: PortletFilter_initEvent2 */
      /* Details: "The init(FilterConfig) method for an EventFilter is passed a FilterConfig object" */
      TestResult tr6 = tcd.getTestResultFailed(PORTLETFILTER_INITEVENT2);
      /* TODO: implement test */

      /* TestCase: PortletFilter_initEvent3 */
      /* Details: "If the init(FilterConfig) method for an EventFilter throws a PortletException, the filter is not placed in service" */
      TestResult tr7 = tcd.getTestResultFailed(PORTLETFILTER_INITEVENT3);
      /* TODO: implement test */

      /* TestCase: PortletFilter_destroyEvent1 */
      /* Details: "The destroy() method is called when an EventFilter is taken out of service" */
      TestResult tr8 = tcd.getTestResultFailed(PORTLETFILTER_DESTROYEVENT1);
      /* TODO: implement test */

      /* TestCase: PortletFilter_destroyEvent2 */
      /* Details: "After the destroy() method for an EventFilter is called, no other filter method is called" */
      TestResult tr9 = tcd.getTestResultFailed(PORTLETFILTER_DESTROYEVENT2);
      /* TODO: implement test */

      /* TestCase: PortletFilter_initRender1 */
      /* Details: "The init(FilterConfig) method is called when an RenderFilter is configured" */
      TestResult tr10 = tcd.getTestResultFailed(PORTLETFILTER_INITRENDER1);
      /* TODO: implement test */

      /* TestCase: PortletFilter_initRender2 */
      /* Details: "The init(FilterConfig) method for an RenderFilter is passed a FilterConfig object" */
      TestResult tr11 = tcd.getTestResultFailed(PORTLETFILTER_INITRENDER2);
      /* TODO: implement test */

      /* TestCase: PortletFilter_initRender3 */
      /* Details: "If the init(FilterConfig) method for an RenderFilter throws a PortletException, the filter is not placed in service" */
      TestResult tr12 = tcd.getTestResultFailed(PORTLETFILTER_INITRENDER3);
      /* TODO: implement test */

      /* TestCase: PortletFilter_destroyRender1 */
      /* Details: "The destroy() method is called when an RenderFilter is taken out of service" */
      TestResult tr13 = tcd.getTestResultFailed(PORTLETFILTER_DESTROYRENDER1);
      /* TODO: implement test */

      /* TestCase: PortletFilter_destroyRender2 */
      /* Details: "After the destroy() method for an RenderFilter is called, no other filter method is called" */
      TestResult tr14 = tcd.getTestResultFailed(PORTLETFILTER_DESTROYRENDER2);
      /* TODO: implement test */

      /* TestCase: PortletFilter_initResource1 */
      /* Details: "The init(FilterConfig) method is called when an ResourceFilter is configured" */
      TestResult tr15 = tcd.getTestResultFailed(PORTLETFILTER_INITRESOURCE1);
      /* TODO: implement test */

      /* TestCase: PortletFilter_initResource2 */
      /* Details: "The init(FilterConfig) method for an ResourceFilter is passed a FilterConfig object" */
      TestResult tr16 = tcd.getTestResultFailed(PORTLETFILTER_INITRESOURCE2);
      /* TODO: implement test */

      /* TestCase: PortletFilter_initResource3 */
      /* Details: "If the init(FilterConfig) method for an ResourceFilter throws a PortletException, the filter is not placed in service" */
      TestResult tr17 = tcd.getTestResultFailed(PORTLETFILTER_INITRESOURCE3);
      /* TODO: implement test */

      /* TestCase: PortletFilter_destroyResource1 */
      /* Details: "The destroy() method is called when an ResourceFilter is taken out of service" */
      TestResult tr18 = tcd.getTestResultFailed(PORTLETFILTER_DESTROYRESOURCE1);
      /* TODO: implement test */

      /* TestCase: PortletFilter_destroyResource2 */
      /* Details: "After the destroy() method for an ResourceFilter is called, no other filter method is called" */
      TestResult tr19 = tcd.getTestResultFailed(PORTLETFILTER_DESTROYRESOURCE2);
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
      tr16.writeTo(writer);
      tr17.writeTo(writer);
      tr18.writeTo(writer);
      tr19.writeTo(writer);


   }

}

