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
public class V2EnvironmentTests_PortletPreferences implements Portlet {
   private static final String LOG_CLASS = 
         V2EnvironmentTests_PortletPreferences.class.getName();
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

      /* TestCase: PortletPreferences_isReadOnly1 */
      /* Details: "Returns true if the preference specified by the key is defined to be read-only in the deployment descriptor" */
      TestResult tr0 = tcd.getTestResultFailed(PORTLETPREFERENCES_ISREADONLY1);
      /* TODO: implement test */

      /* TestCase: PortletPreferences_isReadOnly2 */
      /* Details: "Returns false if the preference specified by the key is not defined to be read-only in the deployment descriptor" */
      TestResult tr1 = tcd.getTestResultFailed(PORTLETPREFERENCES_ISREADONLY2);
      /* TODO: implement test */

      /* TestCase: PortletPreferences_isReadOnly3 */
      /* Details: "Returns false if the preference specified by the key is undefined" */
      TestResult tr2 = tcd.getTestResultFailed(PORTLETPREFERENCES_ISREADONLY3);
      /* TODO: implement test */

      /* TestCase: PortletPreferences_isReadOnly4 */
      /* Details: "Throws IllegalArgumentException if the key is null" */
      TestResult tr3 = tcd.getTestResultFailed(PORTLETPREFERENCES_ISREADONLY4);
      /* TODO: implement test */

      /* TestCase: PortletPreferences_getValue1 */
      /* Details: "Returns the first String value for the specified key" */
      TestResult tr4 = tcd.getTestResultFailed(PORTLETPREFERENCES_GETVALUE1);
      /* TODO: implement test */

      /* TestCase: PortletPreferences_getValue2 */
      /* Details: "Returns the specified default value if there is no value for the specified key " */
      TestResult tr5 = tcd.getTestResultFailed(PORTLETPREFERENCES_GETVALUE2);
      /* TODO: implement test */

      /* TestCase: PortletPreferences_getValue3 */
      /* Details: "Returns the specified default value if the existing value for the specified key is null " */
      TestResult tr6 = tcd.getTestResultFailed(PORTLETPREFERENCES_GETVALUE3);
      /* TODO: implement test */

      /* TestCase: PortletPreferences_getValue4 */
      /* Details: "Throws IllegalArgumentException if the key is null" */
      TestResult tr7 = tcd.getTestResultFailed(PORTLETPREFERENCES_GETVALUE4);
      /* TODO: implement test */

      /* TestCase: PortletPreferences_getValues1 */
      /* Details: "Returns the values String[] for the specified key" */
      TestResult tr8 = tcd.getTestResultFailed(PORTLETPREFERENCES_GETVALUES1);
      /* TODO: implement test */

      /* TestCase: PortletPreferences_getValues2 */
      /* Details: "Returns the specified default String[] if there is no Values for the specified key " */
      TestResult tr9 = tcd.getTestResultFailed(PORTLETPREFERENCES_GETVALUES2);
      /* TODO: implement test */

      /* TestCase: PortletPreferences_getValues3 */
      /* Details: "Returns the specified default String[] if the existing String[] for the specified key is null " */
      TestResult tr10 = tcd.getTestResultFailed(PORTLETPREFERENCES_GETVALUES3);
      /* TODO: implement test */

      /* TestCase: PortletPreferences_getValues4 */
      /* Details: "Throws IllegalArgumentException if the key is null" */
      TestResult tr11 = tcd.getTestResultFailed(PORTLETPREFERENCES_GETVALUES4);
      /* TODO: implement test */

      /* TestCase: PortletPreferences_setValue1 */
      /* Details: "Sets the specified value for the specified key" */
      TestResult tr12 = tcd.getTestResultFailed(PORTLETPREFERENCES_SETVALUE1);
      /* TODO: implement test */

      /* TestCase: PortletPreferences_setValue2 */
      /* Details: "Any existing String or String[] value for the specified key is replaced" */
      TestResult tr13 = tcd.getTestResultFailed(PORTLETPREFERENCES_SETVALUE2);
      /* TODO: implement test */

      /* TestCase: PortletPreferences_setValue3 */
      /* Details: "The value may be set to null" */
      TestResult tr14 = tcd.getTestResultFailed(PORTLETPREFERENCES_SETVALUE3);
      /* TODO: implement test */

      /* TestCase: PortletPreferences_setValue4 */
      /* Details: "Throws ReadOnlyException if the preference cannot be modified for this request" */
      TestResult tr15 = tcd.getTestResultFailed(PORTLETPREFERENCES_SETVALUE4);
      /* TODO: implement test */

      /* TestCase: PortletPreferences_setValue5 */
      /* Details: "Throws IllegalArgumentException if the key is null" */
      TestResult tr16 = tcd.getTestResultFailed(PORTLETPREFERENCES_SETVALUE5);
      /* TODO: implement test */

      /* TestCase: PortletPreferences_setValues1 */
      /* Details: "Sets the specified value array for the specified key" */
      TestResult tr17 = tcd.getTestResultFailed(PORTLETPREFERENCES_SETVALUES1);
      /* TODO: implement test */

      /* TestCase: PortletPreferences_setValues2 */
      /* Details: "Any existing String or String[] Values for the specified key is replaced" */
      TestResult tr18 = tcd.getTestResultFailed(PORTLETPREFERENCES_SETVALUES2);
      /* TODO: implement test */

      /* TestCase: PortletPreferences_setValues3 */
      /* Details: "The value array may be set to null" */
      TestResult tr19 = tcd.getTestResultFailed(PORTLETPREFERENCES_SETVALUES3);
      /* TODO: implement test */

      /* TestCase: PortletPreferences_setValues4 */
      /* Details: "The value array may contain null members" */
      TestResult tr20 = tcd.getTestResultFailed(PORTLETPREFERENCES_SETVALUES4);
      /* TODO: implement test */

      /* TestCase: PortletPreferences_setValues5 */
      /* Details: "Throws ReadOnlyException if the preference cannot be modified for this request" */
      TestResult tr21 = tcd.getTestResultFailed(PORTLETPREFERENCES_SETVALUES5);
      /* TODO: implement test */

      /* TestCase: PortletPreferences_setValues6 */
      /* Details: "Throws IllegalArgumentException if the key is null" */
      TestResult tr22 = tcd.getTestResultFailed(PORTLETPREFERENCES_SETVALUES6);
      /* TODO: implement test */

      /* TestCase: PortletPreferences_getNames1 */
      /* Details: "Returns an java.util.Enumeration<java.lang.String> containing the available preference keys" */
      TestResult tr23 = tcd.getTestResultFailed(PORTLETPREFERENCES_GETNAMES1);
      /* TODO: implement test */

      /* TestCase: PortletPreferences_getNames2 */
      /* Details: "Returns an empty Enumeration if no preference keys are available" */
      TestResult tr24 = tcd.getTestResultFailed(PORTLETPREFERENCES_GETNAMES2);
      /* TODO: implement test */

      /* TestCase: PortletPreferences_getMap1 */
      /* Details: "Returns an java.util.Map<java.lang.String> containing the available preferences" */
      TestResult tr25 = tcd.getTestResultFailed(PORTLETPREFERENCES_GETMAP1);
      /* TODO: implement test */

      /* TestCase: PortletPreferences_getMap2 */
      /* Details: "Returns an empty Map if no preferences are available" */
      TestResult tr26 = tcd.getTestResultFailed(PORTLETPREFERENCES_GETMAP2);
      /* TODO: implement test */

      /* TestCase: PortletPreferences_reset1 */
      /* Details: "Removes the value associated with the specified key" */
      TestResult tr27 = tcd.getTestResultFailed(PORTLETPREFERENCES_RESET1);
      /* TODO: implement test */

      /* TestCase: PortletPreferences_reset2 */
      /* Details: "Throws ReadOnlyException if the preference cannot be modified for this request" */
      TestResult tr28 = tcd.getTestResultFailed(PORTLETPREFERENCES_RESET2);
      /* TODO: implement test */

      /* TestCase: PortletPreferences_reset3 */
      /* Details: "Throws IllegalArgumentException if the key is null" */
      TestResult tr29 = tcd.getTestResultFailed(PORTLETPREFERENCES_RESET3);
      /* TODO: implement test */

      /* TestCase: PortletPreferences_store1 */
      /* Details: "Commits changes made to the preferences to the persistent store " */
      TestResult tr30 = tcd.getTestResultFailed(PORTLETPREFERENCES_STORE1);
      /* TODO: implement test */

      /* TestCase: PortletPreferences_store2 */
      /* Details: "If the store() method is not called, changes made are discarded" */
      TestResult tr31 = tcd.getTestResultFailed(PORTLETPREFERENCES_STORE2);
      /* TODO: implement test */

      /* TestCase: PortletPreferences_store3 */
      /* Details: "If a validator is defined, it is called before the actual store is performed" */
      TestResult tr32 = tcd.getTestResultFailed(PORTLETPREFERENCES_STORE3);
      /* TODO: implement test */

      /* TestCase: PortletPreferences_store4 */
      /* Details: "If validation fails, the store is not performed" */
      TestResult tr33 = tcd.getTestResultFailed(PORTLETPREFERENCES_STORE4);
      /* TODO: implement test */

      /* TestCase: PortletPreferences_store5 */
      /* Details: "Throws IllegalStateException if store() is called in the render method  " */
      TestResult tr34 = tcd.getTestResultFailed(PORTLETPREFERENCES_STORE5);
      /* TODO: implement test */

      /* TestCase: PortletPreferences_store6 */
      /* Details: "Throws ValidatorException if the validation performed by the associated validator fails " */
      TestResult tr35 = tcd.getTestResultFailed(PORTLETPREFERENCES_STORE6);
      /* TODO: implement test */

      /* TestCase: PortletPreferences_store7 */
      /* Details: "Throws IOException if an IO error occurs " */
      TestResult tr36 = tcd.getTestResultFailed(PORTLETPREFERENCES_STORE7);
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
      tr20.writeTo(writer);
      tr21.writeTo(writer);
      tr22.writeTo(writer);
      tr23.writeTo(writer);
      tr24.writeTo(writer);
      tr25.writeTo(writer);
      tr26.writeTo(writer);
      tr27.writeTo(writer);
      tr28.writeTo(writer);
      tr29.writeTo(writer);
      tr30.writeTo(writer);
      tr31.writeTo(writer);
      tr32.writeTo(writer);
      tr33.writeTo(writer);
      tr34.writeTo(writer);
      tr35.writeTo(writer);
      tr36.writeTo(writer);


   }

}

