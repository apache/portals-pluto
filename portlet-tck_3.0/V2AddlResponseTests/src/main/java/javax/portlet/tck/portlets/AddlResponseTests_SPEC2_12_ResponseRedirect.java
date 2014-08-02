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
public class AddlResponseTests_SPEC2_12_ResponseRedirect implements Portlet {
   private static final String LOG_CLASS = 
         AddlResponseTests_SPEC2_12_ResponseRedirect.class.getName();
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

      // Create result objects for the tests

      /* TestCase: SPEC2_12_ResponseRedirect_redirect1                        */
      /* Details: "If a relative path is supplied to the sendRedirect         */
      /* method, an IllegalArgumentException must be thrown"                  */
      TestResult tr0 = tcd.getTestResultFailed(SPEC2_12_RESPONSEREDIRECT_REDIRECT1);
      /* TODO: implement test */

      /* TestCase: SPEC2_12_ResponseRedirect_redirect12                       */
      /* Details: "If a new private render parameter value is set on the      */
      /* ActionResponse before the redirect, the new private render           */
      /* parameter value must be set on the attached render URL"              */
      TestResult tr1 = tcd.getTestResultFailed(SPEC2_12_RESPONSEREDIRECT_REDIRECT12);
      /* TODO: implement test */

      /* TestCase: SPEC2_12_ResponseRedirect_redirect14                       */
      /* Details: "If a new public render parameter value is set on the       */
      /* ActionResponse before the redirect, the new public render            */
      /* parameter value must be set on the attached render URL"              */
      TestResult tr2 = tcd.getTestResultFailed(SPEC2_12_RESPONSEREDIRECT_REDIRECT14);
      /* TODO: implement test */



      // Write the results to the output stream

      tr0.writeTo(writer);
      tr1.writeTo(writer);
      tr2.writeTo(writer);


   }

}

