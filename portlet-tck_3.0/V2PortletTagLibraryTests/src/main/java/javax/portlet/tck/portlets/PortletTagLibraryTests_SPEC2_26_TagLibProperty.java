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
public class PortletTagLibraryTests_SPEC2_26_TagLibProperty implements Portlet {
   private static final String LOG_CLASS = 
         PortletTagLibraryTests_SPEC2_26_TagLibProperty.class.getName();
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

      /* TestCase: SPEC2_26_TagLibProperty_propertyAction1                    */
      /* Details: "The property tag can be used within the actionURL tag to   */
      /* add a property"                                                      */
      TestResult tr0 = tcd.getTestResultFailed(SPEC2_26_TAGLIBPROPERTY_PROPERTYACTION1);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibProperty_propertyAction2                    */
      /* Details: "The property tag required attribute \"name\" defines the   */
      /* property name"                                                       */
      TestResult tr1 = tcd.getTestResultFailed(SPEC2_26_TAGLIBPROPERTY_PROPERTYACTION2);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibProperty_propertyAction3                    */
      /* Details: "If more than one tags appear in the actionURL tag, the     */
      /* values must be stored as a multivalued array in order of             */
      /* appearance within the actionURL tag"                                 */
      TestResult tr2 = tcd.getTestResultFailed(SPEC2_26_TAGLIBPROPERTY_PROPERTYACTION3);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibProperty_propertyAction4                    */
      /* Details: "If the \"name\" attribute is null or empty, no action is   */
      /* performed"                                                           */
      TestResult tr3 = tcd.getTestResultFailed(SPEC2_26_TAGLIBPROPERTY_PROPERTYACTION4);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibProperty_propertyAction5                    */
      /* Details: "The property tag required attribute \"value\" defines      */
      /* the property value"                                                  */
      TestResult tr4 = tcd.getTestResultFailed(SPEC2_26_TAGLIBPROPERTY_PROPERTYACTION5);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibProperty_propertyAction6                    */
      /* Details: "If the \"value\" attribute is null or empty,  the          */
      /* property value is set to null"                                       */
      TestResult tr5 = tcd.getTestResultFailed(SPEC2_26_TAGLIBPROPERTY_PROPERTYACTION6);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibProperty_propertyRender1                    */
      /* Details: "The property tag can be used within the renderURL tag to   */
      /* add a property"                                                      */
      TestResult tr6 = tcd.getTestResultFailed(SPEC2_26_TAGLIBPROPERTY_PROPERTYRENDER1);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibProperty_propertyRender2                    */
      /* Details: "The property tag required attribute \"name\" defines the   */
      /* property name"                                                       */
      TestResult tr7 = tcd.getTestResultFailed(SPEC2_26_TAGLIBPROPERTY_PROPERTYRENDER2);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibProperty_propertyRender3                    */
      /* Details: "If more than one tags appear in the renderURL tag, the     */
      /* values must be stored as a multivalued array in order of             */
      /* appearance within the renderURL tag"                                 */
      TestResult tr8 = tcd.getTestResultFailed(SPEC2_26_TAGLIBPROPERTY_PROPERTYRENDER3);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibProperty_propertyRender4                    */
      /* Details: "If the \"name\" attribute is null or empty, no action is   */
      /* performed"                                                           */
      TestResult tr9 = tcd.getTestResultFailed(SPEC2_26_TAGLIBPROPERTY_PROPERTYRENDER4);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibProperty_propertyRender5                    */
      /* Details: "The property tag required attribute \"value\" defines      */
      /* the property value"                                                  */
      TestResult tr10 = tcd.getTestResultFailed(SPEC2_26_TAGLIBPROPERTY_PROPERTYRENDER5);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibProperty_propertyRender6                    */
      /* Details: "If the \"value\" attribute is null or empty,  the          */
      /* property value is set to null"                                       */
      TestResult tr11 = tcd.getTestResultFailed(SPEC2_26_TAGLIBPROPERTY_PROPERTYRENDER6);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibProperty_propertyResource1                  */
      /* Details: "The property tag can be used within the resourceURL tag    */
      /* to add a property"                                                   */
      TestResult tr12 = tcd.getTestResultFailed(SPEC2_26_TAGLIBPROPERTY_PROPERTYRESOURCE1);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibProperty_propertyResource2                  */
      /* Details: "The property tag required attribute \"name\" defines the   */
      /* property name"                                                       */
      TestResult tr13 = tcd.getTestResultFailed(SPEC2_26_TAGLIBPROPERTY_PROPERTYRESOURCE2);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibProperty_propertyResource3                  */
      /* Details: "If more than one tags appear in the resourceURL tag, the   */
      /* values must be stored as a multivalued array in order of             */
      /* appearance within the resourceURL tag"                               */
      TestResult tr14 = tcd.getTestResultFailed(SPEC2_26_TAGLIBPROPERTY_PROPERTYRESOURCE3);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibProperty_propertyResource4                  */
      /* Details: "If the \"name\" attribute is null or empty, no action is   */
      /* performed"                                                           */
      TestResult tr15 = tcd.getTestResultFailed(SPEC2_26_TAGLIBPROPERTY_PROPERTYRESOURCE4);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibProperty_propertyResource5                  */
      /* Details: "The property tag required attribute \"value\" defines      */
      /* the property value"                                                  */
      TestResult tr16 = tcd.getTestResultFailed(SPEC2_26_TAGLIBPROPERTY_PROPERTYRESOURCE5);
      /* TODO: implement test */

      /* TestCase: SPEC2_26_TagLibProperty_propertyResource6                  */
      /* Details: "If the \"value\" attribute is null or empty, the           */
      /* property value is set to null"                                       */
      TestResult tr17 = tcd.getTestResultFailed(SPEC2_26_TAGLIBPROPERTY_PROPERTYRESOURCE6);
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


   }

}

