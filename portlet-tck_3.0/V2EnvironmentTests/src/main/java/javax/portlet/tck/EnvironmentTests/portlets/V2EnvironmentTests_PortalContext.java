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
public class V2EnvironmentTests_PortalContext implements Portlet {
   private static final String LOG_CLASS = 
         V2EnvironmentTests_PortalContext.class.getName();
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
      ClassChecker cc = new ClassChecker(renderRequest.getPortalContext().getClass());

      // Create result objects for the tests

      /* TestCase: PortalContext_fieldMARKUP_HEAD_ELEMENT_SUPPORT */
      /* Details: "Has String field MARKUP_HEAD_ELEMENT_SUPPORT with value of \"javax.portlet.markup.head.element.support\" " */
      TestResult tr0 = tcd.getTestResultFailed(PORTALCONTEXT_FIELDMARKUP_HEAD_ELEMENT_SUPPORT);
      {
         tr0.setTcSuccess(cc.hasField("MARKUP_HEAD_ELEMENT_SUPPORT", "javax.portlet.markup.head.element.support"));
      }

      /* TestCase: PortalContext_getProperty1 */
      /* Details: "Returns a String containing the value for the specified property " */
      TestResult tr1 = tcd.getTestResultFailed(PORTALCONTEXT_GETPROPERTY1);
      /* TODO: implement test */

      /* TestCase: PortalContext_getProperty2 */
      /* Details: "Returns null if there is no property defined for the specified name" */
      TestResult tr2 = tcd.getTestResultFailed(PORTALCONTEXT_GETPROPERTY2);
      /* TODO: implement test */

      /* TestCase: PortalContext_getProperty3 */
      /* Details: "Throws IllegalArgumentException if the specified name is null " */
      TestResult tr3 = tcd.getTestResultFailed(PORTALCONTEXT_GETPROPERTY3);
      /* TODO: implement test */

      /* TestCase: PortalContext_getPropertyNames1 */
      /* Details: "Returns an java.util.Enumeration<java.lang.String> containing all portal property names" */
      TestResult tr4 = tcd.getTestResultFailed(PORTALCONTEXT_GETPROPERTYNAMES1);
      /* TODO: implement test */

      /* TestCase: PortalContext_getPropertyNames2 */
      /* Details: "Returns an empty Enumeration if there are no portal property names defined" */
      TestResult tr5 = tcd.getTestResultFailed(PORTALCONTEXT_GETPROPERTYNAMES2);
      /* TODO: implement test */

      /* TestCase: PortalContext_getSupportedPortletModes1 */
      /* Details: "Returns an java.util.Enumeration<PortletMode> containing all supported portlet modes" */
      TestResult tr6 = tcd.getTestResultFailed(PORTALCONTEXT_GETSUPPORTEDPORTLETMODES1);
      /* TODO: implement test */

      /* TestCase: PortalContext_getSupportedPortletModes2 */
      /* Details: "The Enumeration returned must contain the view mode" */
      TestResult tr7 = tcd.getTestResultFailed(PORTALCONTEXT_GETSUPPORTEDPORTLETMODES2);
      /* TODO: implement test */

      /* TestCase: PortalContext_getSupportedPortletModes3 */
      /* Details: "The Enumeration returned must contain the edit mode" */
      TestResult tr8 = tcd.getTestResultFailed(PORTALCONTEXT_GETSUPPORTEDPORTLETMODES3);
      /* TODO: implement test */

      /* TestCase: PortalContext_getSupportedPortletModes4 */
      /* Details: "The Enumeration returned must contain the help mode" */
      TestResult tr9 = tcd.getTestResultFailed(PORTALCONTEXT_GETSUPPORTEDPORTLETMODES4);
      /* TODO: implement test */

      /* TestCase: PortalContext_getSupportedWindowStates1 */
      /* Details: "Returns an java.util.Enumeration<WindowState> containing all supported window states" */
      TestResult tr10 = tcd.getTestResultFailed(PORTALCONTEXT_GETSUPPORTEDWINDOWSTATES1);
      /* TODO: implement test */

      /* TestCase: PortalContext_getSupportedWindowStates2 */
      /* Details: "The Enumeration returned must contain the maximized state" */
      TestResult tr11 = tcd.getTestResultFailed(PORTALCONTEXT_GETSUPPORTEDWINDOWSTATES2);
      /* TODO: implement test */

      /* TestCase: PortalContext_getSupportedWindowStates3 */
      /* Details: "The Enumeration returned must contain the minimized state" */
      TestResult tr12 = tcd.getTestResultFailed(PORTALCONTEXT_GETSUPPORTEDWINDOWSTATES3);
      /* TODO: implement test */

      /* TestCase: PortalContext_getSupportedWindowStates4 */
      /* Details: "The Enumeration returned must contain the normal state" */
      TestResult tr13 = tcd.getTestResultFailed(PORTALCONTEXT_GETSUPPORTEDWINDOWSTATES4);
      /* TODO: implement test */

      /* TestCase: PortalContext_getPortalInfo1 */
      /* Details: "Returns a String containing information about the portal" */
      TestResult tr14 = tcd.getTestResultFailed(PORTALCONTEXT_GETPORTALINFO1);
      /* TODO: implement test */

      /* TestCase: PortalContext_getPortalInfo2 */
      /* Details: "The returned string is of the form \"([^ ]+)/([^ ]+) *(.*)\", where $1 is the portal name, $2 is the version, and $3 is optional additional information" */
      TestResult tr15 = tcd.getTestResultFailed(PORTALCONTEXT_GETPORTALINFO2);
      /* TODO: implement test */

      /* TestCase: PortalContext_getPortalInfo3 */
      /* Details: "The returned string contains the portal name" */
      TestResult tr16 = tcd.getTestResultFailed(PORTALCONTEXT_GETPORTALINFO3);
      /* TODO: implement test */

      /* TestCase: PortalContext_getPortalInfo4 */
      /* Details: "The returned string contains the portal version" */
      TestResult tr17 = tcd.getTestResultFailed(PORTALCONTEXT_GETPORTALINFO4);
      /* TODO: implement test */

      /* TestCase: PortalContext_getPortalInfo5 */
      /* Details: "The returned string may not be null" */
      TestResult tr18 = tcd.getTestResultFailed(PORTALCONTEXT_GETPORTALINFO5);
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


   }

}

