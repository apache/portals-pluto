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
public class AddlEnvironmentTests_SPEC2_17_Preferences implements Portlet {
   private static final String LOG_CLASS = 
         AddlEnvironmentTests_SPEC2_17_Preferences.class.getName();
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

      /* TestCase: SPEC2_17_Preferences_values6                               */
      /* Details: "Changing the Map returned by getMap does not change the    */
      /* underlying preferences"                                              */
      TestResult tr0 = tcd.getTestResultFailed(SPEC2_17_PREFERENCES_VALUES6);
      /* TODO: implement test */

      /* TestCase: SPEC2_17_Preferences_values7                               */
      /* Details: "When the lifecycle method render is invoked, the           */
      /* PortletPreferences object must reflect the current state of the      */
      /* persistent store"                                                    */
      TestResult tr1 = tcd.getTestResultFailed(SPEC2_17_PREFERENCES_VALUES7);
      /* TODO: implement test */

      /* TestCase: SPEC2_17_Preferences_values8                               */
      /* Details: "When the lifecycle method processAction is invoked, the    */
      /* PortletPreferences object must reflect the current state of the      */
      /* persistent store"                                                    */
      TestResult tr2 = tcd.getTestResultFailed(SPEC2_17_PREFERENCES_VALUES8);
      /* TODO: implement test */

      /* TestCase: SPEC2_17_Preferences_values9                               */
      /* Details: "When the lifecycle method processEvent is invoked, the     */
      /* PortletPreferences object must reflect the current state of the      */
      /* persistent store"                                                    */
      TestResult tr3 = tcd.getTestResultFailed(SPEC2_17_PREFERENCES_VALUES9);
      /* TODO: implement test */

      /* TestCase: SPEC2_17_Preferences_values10                              */
      /* Details: "When the lifecycle method serveResource is invoked, the    */
      /* PortletPreferences object must reflect the current state of the      */
      /* persistent store"                                                    */
      TestResult tr4 = tcd.getTestResultFailed(SPEC2_17_PREFERENCES_VALUES10);
      /* TODO: implement test */

      /* TestCase: SPEC2_17_Preferences_setValues4                            */
      /* Details: "The setValues method allows the value array to be set to   */
      /* null"                                                                */
      TestResult tr5 = tcd.getTestResultFailed(SPEC2_17_PREFERENCES_SETVALUES4);
      /* TODO: implement test */

      /* TestCase: SPEC2_17_Preferences_reset1                                */
      /* Details: "The reset method sets the value of the specified           */
      /* preference to its default value. The actual default value itself     */
      /* is implementation-specific and cannot be tested."                    */
      TestResult tr6 = tcd.getTestResultFailed(SPEC2_17_PREFERENCES_RESET1);
      /* TODO: implement test */

      /* TestCase: SPEC2_17_Preferences_reset2                                */
      /* Details: "The reset method deletes the preference if there is no     */
      /* default value"                                                       */
      TestResult tr7 = tcd.getTestResultFailed(SPEC2_17_PREFERENCES_RESET2);
      /* TODO: implement test */

      /* TestCase: SPEC2_17_Preferences_store1                                */
      /* Details: "The store method persists preference changes previously    */
      /* made during the processAction method"                                */
      TestResult tr8 = tcd.getTestResultFailed(SPEC2_17_PREFERENCES_STORE1);
      /* TODO: implement test */

      /* TestCase: SPEC2_17_Preferences_store2                                */
      /* Details: "The store method persists preference changes previously    */
      /* made during the processEvent method"                                 */
      TestResult tr9 = tcd.getTestResultFailed(SPEC2_17_PREFERENCES_STORE2);
      /* TODO: implement test */

      /* TestCase: SPEC2_17_Preferences_store3                                */
      /* Details: "The store method persists preference changes previously    */
      /* made during the serveResource method"                                */
      TestResult tr10 = tcd.getTestResultFailed(SPEC2_17_PREFERENCES_STORE3);
      /* TODO: implement test */

      /* TestCase: SPEC2_17_Preferences_store4                                */
      /* Details: "If preference changes are made during the processAction    */
      /* method, but the method completes without store being called, the     */
      /* preference changes are discarded"                                    */
      TestResult tr11 = tcd.getTestResultFailed(SPEC2_17_PREFERENCES_STORE4);
      /* TODO: implement test */

      /* TestCase: SPEC2_17_Preferences_store5                                */
      /* Details: "If preference changes are made during the processEvent     */
      /* method, but the method completes without store being called, the     */
      /* preference changes are discarded"                                    */
      TestResult tr12 = tcd.getTestResultFailed(SPEC2_17_PREFERENCES_STORE5);
      /* TODO: implement test */

      /* TestCase: SPEC2_17_Preferences_store6                                */
      /* Details: "If preference changes are made during the serveResource    */
      /* method, but the method completes without store being called, the     */
      /* preference changes are discarded"                                    */
      TestResult tr13 = tcd.getTestResultFailed(SPEC2_17_PREFERENCES_STORE6);
      /* TODO: implement test */

      /* TestCase: SPEC2_17_Preferences_deployment1                           */
      /* Details: "The portlet definition may define the preference           */
      /* attributes a portlet uses"                                           */
      TestResult tr14 = tcd.getTestResultFailed(SPEC2_17_PREFERENCES_DEPLOYMENT1);
      /* TODO: implement test */

      /* TestCase: SPEC2_17_Preferences_deployment2                           */
      /* Details: "A preference attribute definition may include initial      */
      /* default values"                                                      */
      TestResult tr15 = tcd.getTestResultFailed(SPEC2_17_PREFERENCES_DEPLOYMENT2);
      /* TODO: implement test */

      /* TestCase: SPEC2_17_Preferences_deployment3                           */
      /* Details: "A preference attribute definition may indicate if the      */
      /* attribute is read only"                                              */
      TestResult tr16 = tcd.getTestResultFailed(SPEC2_17_PREFERENCES_DEPLOYMENT3);
      /* TODO: implement test */

      /* TestCase: SPEC2_17_Preferences_deployment4                           */
      /* Details: "If a preference attribute definition does not contain      */
      /* the read-only setting, it will be modifiable in the processAction    */
      /* method"                                                              */
      TestResult tr17 = tcd.getTestResultFailed(SPEC2_17_PREFERENCES_DEPLOYMENT4);
      /* TODO: implement test */

      /* TestCase: SPEC2_17_Preferences_deployment5                           */
      /* Details: "If a preference attribute definition does not contain      */
      /* the read-only setting, it will be modifiable in the processEvent     */
      /* method"                                                              */
      TestResult tr18 = tcd.getTestResultFailed(SPEC2_17_PREFERENCES_DEPLOYMENT5);
      /* TODO: implement test */

      /* TestCase: SPEC2_17_Preferences_deployment6                           */
      /* Details: "If a preference attribute definition does not contain      */
      /* the read-only setting, it will be modifiable in the serveResource    */
      /* method"                                                              */
      TestResult tr19 = tcd.getTestResultFailed(SPEC2_17_PREFERENCES_DEPLOYMENT6);
      /* TODO: implement test */

      /* TestCase: SPEC2_17_Preferences_deployment7                           */
      /* Details: "If a preference attribute definition contains the          */
      /* read-only setting, it will not be modifiable in the processAction    */
      /* method"                                                              */
      TestResult tr20 = tcd.getTestResultFailed(SPEC2_17_PREFERENCES_DEPLOYMENT7);
      /* TODO: implement test */

      /* TestCase: SPEC2_17_Preferences_deployment8                           */
      /* Details: "If a preference attribute definition contains the          */
      /* read-only setting, it will not be modifiable in the processEvent     */
      /* method"                                                              */
      TestResult tr21 = tcd.getTestResultFailed(SPEC2_17_PREFERENCES_DEPLOYMENT8);
      /* TODO: implement test */

      /* TestCase: SPEC2_17_Preferences_deployment9                           */
      /* Details: "If a preference attribute definition contains the          */
      /* read-only setting, it will not be modifiable in the serveResource    */
      /* method"                                                              */
      TestResult tr22 = tcd.getTestResultFailed(SPEC2_17_PREFERENCES_DEPLOYMENT9);
      /* TODO: implement test */

      /* TestCase: SPEC2_17_Preferences_deployment10                          */
      /* Details: "A preference attribute not defined in the deployment       */
      /* descriptor may be added programmatically in the processAction        */
      /* method"                                                              */
      TestResult tr23 = tcd.getTestResultFailed(SPEC2_17_PREFERENCES_DEPLOYMENT10);
      /* TODO: implement test */

      /* TestCase: SPEC2_17_Preferences_deployment11                          */
      /* Details: "A preference attribute not defined in the deployment       */
      /* descriptor may be added programmatically in the processEvent         */
      /* method"                                                              */
      TestResult tr24 = tcd.getTestResultFailed(SPEC2_17_PREFERENCES_DEPLOYMENT11);
      /* TODO: implement test */

      /* TestCase: SPEC2_17_Preferences_deployment12                          */
      /* Details: "A preference attribute not defined in the deployment       */
      /* descriptor may be added programmatically in the serveResource        */
      /* method"                                                              */
      TestResult tr25 = tcd.getTestResultFailed(SPEC2_17_PREFERENCES_DEPLOYMENT12);
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


   }

}

