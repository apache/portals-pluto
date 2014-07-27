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
public class V2EnvironmentTests_SIG_PortletPreferences implements Portlet {
   private static final String LOG_CLASS = 
         V2EnvironmentTests_SIG_PortletPreferences.class.getName();
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
      ClassChecker cc = new ClassChecker(renderRequest.getPreferences().getClass());

      // Create result objects for the tests

      /* TestCase: PortletPreferences_SIG_hasIsReadOnly */
      /* Details: "Has a isReadOnly(String)  method " */
      TestResult tr0 = tcd.getTestResultFailed(PORTLETPREFERENCES_SIG_HASISREADONLY);
      {
         String name = "isReadOnly";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class};
         tr0.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletPreferences_SIG_hasIsReadOnlyReturns */
      /* Details: "Method isReadOnly(String) returns boolean " */
      TestResult tr1 = tcd.getTestResultFailed(PORTLETPREFERENCES_SIG_HASISREADONLYRETURNS);
      {
         String name = "isReadOnly";
         Class<?> retType = boolean.class;
         Class<?>[] parms = {String.class};
         tr1.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletPreferences_SIG_hasGetValue */
      /* Details: "Has a getValue(String, String)  method " */
      TestResult tr2 = tcd.getTestResultFailed(PORTLETPREFERENCES_SIG_HASGETVALUE);
      {
         String name = "getValue";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class, String.class};
         tr2.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletPreferences_SIG_hasGetValueReturns */
      /* Details: "Method getValue(String, String) returns String " */
      TestResult tr3 = tcd.getTestResultFailed(PORTLETPREFERENCES_SIG_HASGETVALUERETURNS);
      {
         String name = "getValue";
         Class<?> retType = String.class;
         Class<?>[] parms = {String.class, String.class};
         tr3.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletPreferences_SIG_hasGetValues */
      /* Details: "Has a getValues(String, String[])  method " */
      TestResult tr4 = tcd.getTestResultFailed(PORTLETPREFERENCES_SIG_HASGETVALUES);
      {
         String name = "getValues";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class, String[].class};
         tr4.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletPreferences_SIG_hasGetValuesReturns */
      /* Details: "Method getValues(String, String[]) returns String[] " */
      TestResult tr5 = tcd.getTestResultFailed(PORTLETPREFERENCES_SIG_HASGETVALUESRETURNS);
      {
         String name = "getValues";
         Class<?> retType = String[].class;
         Class<?>[] parms = {String.class, String[].class};
         tr5.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletPreferences_SIG_hasSetValue */
      /* Details: "Has a setValue(String, String) throws ReadOnlyException method " */
      TestResult tr6 = tcd.getTestResultFailed(PORTLETPREFERENCES_SIG_HASSETVALUE);
      {
         String name = "setValue";
         Class<?>[] exceptions = {ReadOnlyException.class};
         Class<?>[] parms = {String.class, String.class};
         tr6.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletPreferences_SIG_hasSetValueReturns */
      /* Details: "Method setValue(String, String) returns void " */
      TestResult tr7 = tcd.getTestResultFailed(PORTLETPREFERENCES_SIG_HASSETVALUERETURNS);
      {
         String name = "setValue";
         Class<?> retType = void.class;
         Class<?>[] parms = {String.class, String.class};
         tr7.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletPreferences_SIG_hasSetValues */
      /* Details: "Has a setValues(String, String[]) throws ReadOnlyException method " */
      TestResult tr8 = tcd.getTestResultFailed(PORTLETPREFERENCES_SIG_HASSETVALUES);
      {
         String name = "setValues";
         Class<?>[] exceptions = {ReadOnlyException.class};
         Class<?>[] parms = {String.class, String[].class};
         tr8.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletPreferences_SIG_hasSetValuesReturns */
      /* Details: "Method setValues(String, String[]) returns void " */
      TestResult tr9 = tcd.getTestResultFailed(PORTLETPREFERENCES_SIG_HASSETVALUESRETURNS);
      {
         String name = "setValues";
         Class<?> retType = void.class;
         Class<?>[] parms = {String.class, String[].class};
         tr9.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletPreferences_SIG_hasGetNames */
      /* Details: "Has a getNames()  method " */
      TestResult tr10 = tcd.getTestResultFailed(PORTLETPREFERENCES_SIG_HASGETNAMES);
      {
         String name = "getNames";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr10.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletPreferences_SIG_hasGetNamesReturns */
      /* Details: "Method getNames() returns java.util.Enumeration " */
      TestResult tr11 = tcd.getTestResultFailed(PORTLETPREFERENCES_SIG_HASGETNAMESRETURNS);
      {
         String name = "getNames";
         Class<?> retType = java.util.Enumeration.class;
         Class<?>[] parms = null;
         tr11.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletPreferences_SIG_hasGetMap */
      /* Details: "Has a getMap()  method " */
      TestResult tr12 = tcd.getTestResultFailed(PORTLETPREFERENCES_SIG_HASGETMAP);
      {
         String name = "getMap";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr12.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletPreferences_SIG_hasGetMapReturns */
      /* Details: "Method getMap() returns java.util.Map " */
      TestResult tr13 = tcd.getTestResultFailed(PORTLETPREFERENCES_SIG_HASGETMAPRETURNS);
      {
         String name = "getMap";
         Class<?> retType = java.util.Map.class;
         Class<?>[] parms = null;
         tr13.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletPreferences_SIG_hasReset */
      /* Details: "Has a reset(String) throws ReadOnlyException method " */
      TestResult tr14 = tcd.getTestResultFailed(PORTLETPREFERENCES_SIG_HASRESET);
      {
         String name = "reset";
         Class<?>[] exceptions = {ReadOnlyException.class};
         Class<?>[] parms = {String.class};
         tr14.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletPreferences_SIG_hasResetReturns */
      /* Details: "Method reset(String) returns void " */
      TestResult tr15 = tcd.getTestResultFailed(PORTLETPREFERENCES_SIG_HASRESETRETURNS);
      {
         String name = "reset";
         Class<?> retType = void.class;
         Class<?>[] parms = {String.class};
         tr15.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletPreferences_SIG_hasStore */
      /* Details: "Has a store() throws java.io.IOException, ValidatorException method " */
      TestResult tr16 = tcd.getTestResultFailed(PORTLETPREFERENCES_SIG_HASSTORE);
      {
         String name = "store";
         Class<?>[] exceptions = {java.io.IOException.class, ValidatorException.class};
         Class<?>[] parms = null;
         tr16.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletPreferences_SIG_hasStoreReturns */
      /* Details: "Method store() returns void " */
      TestResult tr17 = tcd.getTestResultFailed(PORTLETPREFERENCES_SIG_HASSTORERETURNS);
      {
         String name = "store";
         Class<?> retType = void.class;
         Class<?>[] parms = null;
         tr17.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
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
      tr11.writeTo(writer);
      tr12.writeTo(writer);
      tr13.writeTo(writer);
      tr14.writeTo(writer);
      tr15.writeTo(writer);
      tr16.writeTo(writer);
      tr17.writeTo(writer);


   }

}

