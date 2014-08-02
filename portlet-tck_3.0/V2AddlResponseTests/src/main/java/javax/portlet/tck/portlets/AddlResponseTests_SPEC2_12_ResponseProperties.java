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
public class AddlResponseTests_SPEC2_12_ResponseProperties implements Portlet {
   private static final String LOG_CLASS = 
         AddlResponseTests_SPEC2_12_ResponseProperties.class.getName();
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

      /* TestCase: SPEC2_12_ResponseProperties_namespace2                     */
      /* Details: "The String returned by the getNamespace method must be     */
      /* unique on the portal page"                                           */
      TestResult tr0 = tcd.getTestResultFailed(SPEC2_12_RESPONSEPROPERTIES_NAMESPACE2);
      /* TODO: implement test */

      /* TestCase: SPEC2_12_ResponseProperties_namespace4                     */
      /* Details: "The String returned by the getNamespace method must be a   */
      /* valid Java identifier"                                               */
      TestResult tr1 = tcd.getTestResultFailed(SPEC2_12_RESPONSEPROPERTIES_NAMESPACE4);
      /* TODO: implement test */

      /* TestCase: SPEC2_12_ResponseProperties_cookie1                        */
      /* Details: "Cookies set during the Action phase should be available    */
      /* to the portlet during the Render phase"                              */
      TestResult tr2 = tcd.getTestResultFailed(SPEC2_12_RESPONSEPROPERTIES_COOKIE1);
      /* TODO: implement test */

      /* TestCase: SPEC2_12_ResponseProperties_cookie2                        */
      /* Details: "Cookies set during the Action phase should be available    */
      /* to the portlet during the Resource phase"                            */
      TestResult tr3 = tcd.getTestResultFailed(SPEC2_12_RESPONSEPROPERTIES_COOKIE2);
      /* TODO: implement test */

      /* TestCase: SPEC2_12_ResponseProperties_cookie3                        */
      /* Details: "Cookies set during the Action phase should be available    */
      /* to the portlet during the Event phase"                               */
      TestResult tr4 = tcd.getTestResultFailed(SPEC2_12_RESPONSEPROPERTIES_COOKIE3);
      /* TODO: implement test */

      /* TestCase: SPEC2_12_ResponseProperties_cookie4                        */
      /* Details: "Cookies set during the Action phase should be available    */
      /* to the portlet during a subsequent request triggered by a URL"       */
      TestResult tr5 = tcd.getTestResultFailed(SPEC2_12_RESPONSEPROPERTIES_COOKIE4);
      /* TODO: implement test */

      /* TestCase: SPEC2_12_ResponseProperties_cookie5                        */
      /* Details: "Cookies set during the Event phase should be available     */
      /* to the portlet during the Render phase"                              */
      TestResult tr6 = tcd.getTestResultFailed(SPEC2_12_RESPONSEPROPERTIES_COOKIE5);
      /* TODO: implement test */

      /* TestCase: SPEC2_12_ResponseProperties_cookie6                        */
      /* Details: "Cookies set during the Event phase should be available     */
      /* to the portlet during the Resource phase"                            */
      TestResult tr7 = tcd.getTestResultFailed(SPEC2_12_RESPONSEPROPERTIES_COOKIE6);
      /* TODO: implement test */

      /* TestCase: SPEC2_12_ResponseProperties_cookie7                        */
      /* Details: "Cookies set during the Event phase should be available     */
      /* to the portlet during a subsequent request triggered by a URL"       */
      TestResult tr8 = tcd.getTestResultFailed(SPEC2_12_RESPONSEPROPERTIES_COOKIE7);
      /* TODO: implement test */

      /* TestCase: SPEC2_12_ResponseProperties_cookie8                        */
      /* Details: "Cookies set during the Render phase should be available    */
      /* to the portlet during the Resource phase"                            */
      TestResult tr9 = tcd.getTestResultFailed(SPEC2_12_RESPONSEPROPERTIES_COOKIE8);
      /* TODO: implement test */

      /* TestCase: SPEC2_12_ResponseProperties_cookie9                        */
      /* Details: "Cookies set during the Render phase should be available    */
      /* to the portlet during a subsequent Action phase"                     */
      TestResult tr10 = tcd.getTestResultFailed(SPEC2_12_RESPONSEPROPERTIES_COOKIE9);
      /* TODO: implement test */

      /* TestCase: SPEC2_12_ResponseProperties_cookie10                       */
      /* Details: "Cookies set during the Render phase should be available    */
      /* to the portlet during a subsequent Render phase"                     */
      TestResult tr11 = tcd.getTestResultFailed(SPEC2_12_RESPONSEPROPERTIES_COOKIE10);
      /* TODO: implement test */

      /* TestCase: SPEC2_12_ResponseProperties_cookie11                       */
      /* Details: "Cookies set during the Render phase should be available    */
      /* to the portlet during a subsequent request triggered by a URL"       */
      TestResult tr12 = tcd.getTestResultFailed(SPEC2_12_RESPONSEPROPERTIES_COOKIE11);
      /* TODO: implement test */

      /* TestCase: SPEC2_12_ResponseProperties_cookie12                       */
      /* Details: "Cookies set during the Render phase after the response     */
      /* has been committed are ignored"                                      */
      TestResult tr13 = tcd.getTestResultFailed(SPEC2_12_RESPONSEPROPERTIES_COOKIE12);
      /* TODO: implement test */

      /* TestCase: SPEC2_12_ResponseProperties_cookie13                       */
      /* Details: "Cookies set during the Resource phase should be            */
      /* available to the portlet during a subsequent Action phase"           */
      TestResult tr14 = tcd.getTestResultFailed(SPEC2_12_RESPONSEPROPERTIES_COOKIE13);
      /* TODO: implement test */

      /* TestCase: SPEC2_12_ResponseProperties_cookie14                       */
      /* Details: "Cookies set during the Resource phase should be            */
      /* available to the portlet during a subsequent Resource phase"         */
      TestResult tr15 = tcd.getTestResultFailed(SPEC2_12_RESPONSEPROPERTIES_COOKIE14);
      /* TODO: implement test */

      /* TestCase: SPEC2_12_ResponseProperties_cookie15                       */
      /* Details: "Cookies set during the Resource phase should be            */
      /* available to the portlet during a subsequent Render phase"           */
      TestResult tr16 = tcd.getTestResultFailed(SPEC2_12_RESPONSEPROPERTIES_COOKIE15);
      /* TODO: implement test */

      /* TestCase: SPEC2_12_ResponseProperties_cookie16                       */
      /* Details: "Cookies set during the Resource phase should be            */
      /* available to the portlet during a subsequent request triggered by    */
      /* a URL"                                                               */
      TestResult tr17 = tcd.getTestResultFailed(SPEC2_12_RESPONSEPROPERTIES_COOKIE16);
      /* TODO: implement test */

      /* TestCase: SPEC2_12_ResponseProperties_cookie17                       */
      /* Details: "Cookies set during the Resource phase after the response   */
      /* has been committed are ignored"                                      */
      TestResult tr18 = tcd.getTestResultFailed(SPEC2_12_RESPONSEPROPERTIES_COOKIE17);
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

