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
public class AddlUrlTests_SPEC2_7_Url implements Portlet {
   private static final String LOG_CLASS = 
         AddlUrlTests_SPEC2_7_Url.class.getName();
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

      /* TestCase: SPEC2_7_Url_portletMode1                                   */
      /* Details: "The portlet may not set a portlet mode that is not         */
      /* defined as supported in the deployment descriptor on a portlet       */
      /* URL"                                                                 */
      TestResult tr0 = tcd.getTestResultFailed(SPEC2_7_URL_PORTLETMODE1);
      /* TODO: implement test */

      /* TestCase: SPEC2_7_Url_portletMode2                                   */
      /* Details: "The portlet may not set a portlet mode on a portlet URL    */
      /* that it is not allowed to use"                                       */
      TestResult tr1 = tcd.getTestResultFailed(SPEC2_7_URL_PORTLETMODE2);
      /* TODO: implement test */

      /* TestCase: SPEC2_7_Url_portletMode4                                   */
      /* Details: "If the portlet mode is not set, the URL must have the      */
      /* portlet mode set for the current request as default"                 */
      TestResult tr2 = tcd.getTestResultFailed(SPEC2_7_URL_PORTLETMODE4);
      /* TODO: implement test */

      /* TestCase: SPEC2_7_Url_windowState1                                   */
      /* Details: "The portlet may not set a window state that is not         */
      /* defined as supported in the deployment descriptor on a portlet       */
      /* URL"                                                                 */
      TestResult tr3 = tcd.getTestResultFailed(SPEC2_7_URL_WINDOWSTATE1);
      /* TODO: implement test */

      /* TestCase: SPEC2_7_Url_windowState2                                   */
      /* Details: "The portlet may not set a window state on a portlet URL    */
      /* that it is not allowed to use"                                       */
      TestResult tr4 = tcd.getTestResultFailed(SPEC2_7_URL_WINDOWSTATE2);
      /* TODO: implement test */

      /* TestCase: SPEC2_7_Url_windowState4                                   */
      /* Details: "If the window state is not set, the URL must have the      */
      /* window state set for the current request as default"                 */
      TestResult tr5 = tcd.getTestResultFailed(SPEC2_7_URL_WINDOWSTATE4);
      /* TODO: implement test */

      /* TestCase: SPEC2_7_Url_setSecure1                                     */
      /* Details: "If setSecure is called with the parameter set to TRUE,     */
      /* the transport for the request triggered by the URL must be secure"   */
      TestResult tr6 = tcd.getTestResultFailed(SPEC2_7_URL_SETSECURE1);
      /* TODO: implement test */

      /* TestCase: SPEC2_7_Url_setSecure3                                     */
      /* Details: "If setSecure is not called, the transport for the          */
      /* request triggered by the URL should be at the same security level    */
      /* as the current request"                                              */
      TestResult tr7 = tcd.getTestResultFailed(SPEC2_7_URL_SETSECURE3);
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


   }

}

