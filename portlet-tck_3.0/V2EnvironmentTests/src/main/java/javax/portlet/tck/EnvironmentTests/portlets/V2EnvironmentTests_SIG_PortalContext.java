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
public class V2EnvironmentTests_SIG_PortalContext implements Portlet {
   private static final String LOG_CLASS = 
         V2EnvironmentTests_SIG_PortalContext.class.getName();
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

      /* TestCase: PortalContext_SIG_fieldMARKUP_HEAD_ELEMENT_SUPPORT */
      /* Details: "Has String field MARKUP_HEAD_ELEMENT_SUPPORT " */
      TestResult tr0 = tcd.getTestResultFailed(PORTALCONTEXT_SIG_FIELDMARKUP_HEAD_ELEMENT_SUPPORT);
      {
         tr0.setTcSuccess(cc.hasField("MARKUP_HEAD_ELEMENT_SUPPORT"));
      }

      /* TestCase: PortalContext_SIG_hasGetProperty */
      /* Details: "Has a getProperty(String)  method " */
      TestResult tr1 = tcd.getTestResultFailed(PORTALCONTEXT_SIG_HASGETPROPERTY);
      {
         String name = "getProperty";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class};
         tr1.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortalContext_SIG_hasGetPropertyReturns */
      /* Details: "Method getProperty(String) returns String " */
      TestResult tr2 = tcd.getTestResultFailed(PORTALCONTEXT_SIG_HASGETPROPERTYRETURNS);
      {
         String name = "getProperty";
         Class<?> retType = String.class;
         Class<?>[] parms = {String.class};
         tr2.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortalContext_SIG_hasGetPropertyNames */
      /* Details: "Has a getPropertyNames()  method " */
      TestResult tr3 = tcd.getTestResultFailed(PORTALCONTEXT_SIG_HASGETPROPERTYNAMES);
      {
         String name = "getPropertyNames";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr3.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortalContext_SIG_hasGetPropertyNamesReturns */
      /* Details: "Method getPropertyNames() returns java.util.Enumeration " */
      TestResult tr4 = tcd.getTestResultFailed(PORTALCONTEXT_SIG_HASGETPROPERTYNAMESRETURNS);
      {
         String name = "getPropertyNames";
         Class<?> retType = java.util.Enumeration.class;
         Class<?>[] parms = null;
         tr4.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortalContext_SIG_hasGetSupportedPortletModes */
      /* Details: "Has a getSupportedPortletModes()  method " */
      TestResult tr5 = tcd.getTestResultFailed(PORTALCONTEXT_SIG_HASGETSUPPORTEDPORTLETMODES);
      {
         String name = "getSupportedPortletModes";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr5.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortalContext_SIG_hasGetSupportedPortletModesReturns */
      /* Details: "Method getSupportedPortletModes() returns java.util.Enumeration " */
      TestResult tr6 = tcd.getTestResultFailed(PORTALCONTEXT_SIG_HASGETSUPPORTEDPORTLETMODESRETURNS);
      {
         String name = "getSupportedPortletModes";
         Class<?> retType = java.util.Enumeration.class;
         Class<?>[] parms = null;
         tr6.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortalContext_SIG_hasGetSupportedWindowStates */
      /* Details: "Has a getSupportedWindowStates()  method " */
      TestResult tr7 = tcd.getTestResultFailed(PORTALCONTEXT_SIG_HASGETSUPPORTEDWINDOWSTATES);
      {
         String name = "getSupportedWindowStates";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr7.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortalContext_SIG_hasGetSupportedWindowStatesReturns */
      /* Details: "Method getSupportedWindowStates() returns java.util.Enumeration " */
      TestResult tr8 = tcd.getTestResultFailed(PORTALCONTEXT_SIG_HASGETSUPPORTEDWINDOWSTATESRETURNS);
      {
         String name = "getSupportedWindowStates";
         Class<?> retType = java.util.Enumeration.class;
         Class<?>[] parms = null;
         tr8.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortalContext_SIG_hasGetPortalInfo */
      /* Details: "Has a getPortalInfo()  method " */
      TestResult tr9 = tcd.getTestResultFailed(PORTALCONTEXT_SIG_HASGETPORTALINFO);
      {
         String name = "getPortalInfo";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr9.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortalContext_SIG_hasGetPortalInfoReturns */
      /* Details: "Method getPortalInfo() returns String " */
      TestResult tr10 = tcd.getTestResultFailed(PORTALCONTEXT_SIG_HASGETPORTALINFORETURNS);
      {
         String name = "getPortalInfo";
         Class<?> retType = String.class;
         Class<?>[] parms = null;
         tr10.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }



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


   }

}

