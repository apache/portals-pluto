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
public class V2FilterTests_SIG_FilterConfig implements Portlet {
   private static final String LOG_CLASS = 
         V2FilterTests_SIG_FilterConfig.class.getName();
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
      ClassChecker cc = new ClassChecker(FilterConfig.class);

      // Create result objects for the tests

      /* TestCase: FilterConfig_SIG_hasGetFilterName */
      /* Details: "Has a getFilterName()  method " */
      TestResult tr0 = tcd.getTestResultFailed(FILTERCONFIG_SIG_HASGETFILTERNAME);
      {
         String name = "getFilterName";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr0.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: FilterConfig_SIG_hasGetFilterNameReturns */
      /* Details: "Method getFilterName() returns String " */
      TestResult tr1 = tcd.getTestResultFailed(FILTERCONFIG_SIG_HASGETFILTERNAMERETURNS);
      {
         String name = "getFilterName";
         Class<?> retType = String.class;
         Class<?>[] parms = null;
         tr1.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: FilterConfig_SIG_hasGetPortletContext */
      /* Details: "Has a getPortletContext()  method " */
      TestResult tr2 = tcd.getTestResultFailed(FILTERCONFIG_SIG_HASGETPORTLETCONTEXT);
      {
         String name = "getPortletContext";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr2.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: FilterConfig_SIG_hasGetPortletContextReturns */
      /* Details: "Method getPortletContext() returns PortletContext " */
      TestResult tr3 = tcd.getTestResultFailed(FILTERCONFIG_SIG_HASGETPORTLETCONTEXTRETURNS);
      {
         String name = "getPortletContext";
         Class<?> retType = PortletContext.class;
         Class<?>[] parms = null;
         tr3.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: FilterConfig_SIG_hasGetInitParameter */
      /* Details: "Has a getInitParameter(String)  method " */
      TestResult tr4 = tcd.getTestResultFailed(FILTERCONFIG_SIG_HASGETINITPARAMETER);
      {
         String name = "getInitParameter";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class};
         tr4.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: FilterConfig_SIG_hasGetInitParameterReturns */
      /* Details: "Method getInitParameter(String) returns String " */
      TestResult tr5 = tcd.getTestResultFailed(FILTERCONFIG_SIG_HASGETINITPARAMETERRETURNS);
      {
         String name = "getInitParameter";
         Class<?> retType = String.class;
         Class<?>[] parms = {String.class};
         tr5.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: FilterConfig_SIG_hasGetInitParameterNames */
      /* Details: "Has a getInitParameterNames()  method " */
      TestResult tr6 = tcd.getTestResultFailed(FILTERCONFIG_SIG_HASGETINITPARAMETERNAMES);
      {
         String name = "getInitParameterNames";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr6.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: FilterConfig_SIG_hasGetInitParameterNamesReturns */
      /* Details: "Method getInitParameterNames() returns java.util.Enumeration " */
      TestResult tr7 = tcd.getTestResultFailed(FILTERCONFIG_SIG_HASGETINITPARAMETERNAMESRETURNS);
      {
         String name = "getInitParameterNames";
         Class<?> retType = java.util.Enumeration.class;
         Class<?>[] parms = null;
         tr7.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
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


   }

}

