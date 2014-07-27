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
public class V2FilterTests_ActionFilter implements Portlet {
   private static final String LOG_CLASS = 
         V2FilterTests_ActionFilter.class.getName();
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
      ClassChecker cc = new ClassChecker(ActionFilter.class);

      // Create result objects for the tests

      /* TestCase: ActionFilter_canBeConfigured1 */
      /* Details: "An ActionFilter can be configured in the portlet descriptor" */
      TestResult tr0 = tcd.getTestResultFailed(ACTIONFILTER_CANBECONFIGURED1);
      /* TODO: implement test */

      /* TestCase: ActionFilter_canBeConfigured2 */
      /* Details: "Multiple ActionFilter classes can be configured in the portlet descriptor" */
      TestResult tr1 = tcd.getTestResultFailed(ACTIONFILTER_CANBECONFIGURED2);
      /* TODO: implement test */

      /* TestCase: ActionFilter_doFilterIsCalled */
      /* Details: "The doFilter(ActionRequest, ActionResponse, FilterChain) method is called before the processAction method for the portlet" */
      TestResult tr2 = tcd.getTestResultFailed(ACTIONFILTER_DOFILTERISCALLED);
      /* TODO: implement test */

      /* TestCase: ActionFilter_doFilterProcessAction1 */
      /* Details: "After the method has sucessfully completed and invokes the next filter, the processActionMethod is called" */
      TestResult tr3 = tcd.getTestResultFailed(ACTIONFILTER_DOFILTERPROCESSACTION1);
      /* TODO: implement test */

      /* TestCase: ActionFilter_doFilterProcessAction2 */
      /* Details: "After the method has sucessfully completed and invokes the next filter, the next filter in the chain is called if multiple filters are defined" */
      TestResult tr4 = tcd.getTestResultFailed(ACTIONFILTER_DOFILTERPROCESSACTION2);
      /* TODO: implement test */

      /* TestCase: ActionFilter_doFilterBlock */
      /* Details: "If the method does not invoke the next filter, processAction is not called" */
      TestResult tr5 = tcd.getTestResultFailed(ACTIONFILTER_DOFILTERBLOCK);
      /* TODO: implement test */

      /* TestCase: ActionFilter_doFilterException1 */
      /* Details: "If the method throws an UnavailableException, processAction is not called" */
      TestResult tr6 = tcd.getTestResultFailed(ACTIONFILTER_DOFILTEREXCEPTION1);
      /* TODO: implement test */

      /* TestCase: ActionFilter_doFilterException2 */
      /* Details: "If the method throws an UnavailableException, no further filter is called" */
      TestResult tr7 = tcd.getTestResultFailed(ACTIONFILTER_DOFILTEREXCEPTION2);
      /* TODO: implement test */

      /* TestCase: ActionFilter_doFilterExamine */
      /* Details: "After the next filter has been successfully invoked, the ActionResponse may be examined" */
      TestResult tr8 = tcd.getTestResultFailed(ACTIONFILTER_DOFILTEREXAMINE);
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


   }

}

