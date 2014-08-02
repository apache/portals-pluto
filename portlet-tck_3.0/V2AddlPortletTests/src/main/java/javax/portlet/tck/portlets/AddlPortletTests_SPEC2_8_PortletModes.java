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
import javax.portlet.tck.beans.JSR286SpecTestCaseDetails;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.*;
import javax.portlet.tck.beans.TestResult;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the 
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 */
public class AddlPortletTests_SPEC2_8_PortletModes implements Portlet {
   private static final String LOG_CLASS = 
         AddlPortletTests_SPEC2_8_PortletModes.class.getName();
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
      JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();

      // Create result objects for the tests

      /* TestCase: SPEC2_8_PortletModes_declaringPortletModes1                */
      /* Details: "Support for the VIEW mode does not need to be declared     */
      /* in the deployment descriptor"                                        */
      TestResult tr0 = tcd.getTestResultFailed(SPEC2_8_PORTLETMODES_DECLARINGPORTLETMODES1);
      /* TODO: implement test */

      /* TestCase: SPEC2_8_PortletModes_declaringPortletModes2                */
      /* Details: "Support for the HELP mode must be declared in the          */
      /* deployment descriptor"                                               */
      TestResult tr1 = tcd.getTestResultFailed(SPEC2_8_PORTLETMODES_DECLARINGPORTLETMODES2);
      /* TODO: implement test */

      /* TestCase: SPEC2_8_PortletModes_declaringPortletModes3                */
      /* Details: "A custom portlet mode may be declared in the deployment    */
      /* descriptor"                                                          */
      TestResult tr2 = tcd.getTestResultFailed(SPEC2_8_PORTLETMODES_DECLARINGPORTLETMODES3);
      /* TODO: implement test */

      /* TestCase: SPEC2_8_PortletModes_declaringPortletModes4                */
      /* Details: "A custom portlet mode with                                 */
      /* <portal-managed>false</portal-managed> may be declared in the        */
      /* deployment descriptor"                                               */
      TestResult tr3 = tcd.getTestResultFailed(SPEC2_8_PORTLETMODES_DECLARINGPORTLETMODES4);
      /* TODO: implement test */

      /* TestCase: SPEC2_8_PortletModes_declaringPortletModes5                */
      /* Details: "The PortletRequest.isPortletModeAllowed method must        */
      /* return FALSE for a custom portlet mode with                          */
      /* <portal-managed>true</portal-managed> that is not supported by the   */
      /* portlet container"                                                   */
      TestResult tr4 = tcd.getTestResultFailed(SPEC2_8_PORTLETMODES_DECLARINGPORTLETMODES5);
      /* TODO: implement test */

      /* TestCase: SPEC2_8_PortletModes_declaringPortletModes6                */
      /* Details: "The portlet container must ignore all custom portlet       */
      /* modes in the deployment descriptor with                              */
      /* <portal-managed>true</portal-managed> that is not supported by the   */
      /* portlet container"                                                   */
      TestResult tr5 = tcd.getTestResultFailed(SPEC2_8_PORTLETMODES_DECLARINGPORTLETMODES6);
      /* TODO: implement test */

      /* TestCase: SPEC2_8_PortletModes_declaringPortletModes7                */
      /* Details: "A custom portlet mode with                                 */
      /* <portal-managed>false</portal-managed> corresponds to the VIEW       */
      /* mode from the portal point of view"                                  */
      TestResult tr6 = tcd.getTestResultFailed(SPEC2_8_PORTLETMODES_DECLARINGPORTLETMODES7);
      /* TODO: implement test */

      /* TestCase: SPEC2_8_PortletModes_declaringPortletModes8                */
      /* Details: "A custom portlet mode can have a localized decoration      */
      /* name in the resource bundle with the name of                         */
      /* javax.portlet.app.custom-portlet-mode.<name>.decoration-name"        */
      TestResult tr7 = tcd.getTestResultFailed(SPEC2_8_PORTLETMODES_DECLARINGPORTLETMODES8);
      /* TODO: implement test */

      /* TestCase: SPEC2_8_PortletModes_declaringPortletModes9                */
      /* Details: "The portlet must not be invoked in a mode that has not     */
      /* been declared to be supported for a given markup type"               */
      TestResult tr8 = tcd.getTestResultFailed(SPEC2_8_PORTLETMODES_DECLARINGPORTLETMODES9);
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

