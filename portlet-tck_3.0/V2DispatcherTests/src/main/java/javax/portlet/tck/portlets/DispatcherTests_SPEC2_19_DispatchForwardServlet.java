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
import static java.util.logging.Logger.*;

import javax.portlet.*;
import javax.portlet.filter.*;
import javax.portlet.tck.beans.ClassChecker;
import javax.portlet.tck.beans.TestCaseDetails;
import javax.portlet.tck.beans.JSR286DispatcherTestCaseDetails;
import static javax.portlet.tck.beans.JSR286DispatcherTestCaseDetails.*;
import javax.portlet.tck.beans.TestResult;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the 
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 */
public class DispatcherTests_SPEC2_19_DispatchForwardServlet implements Portlet {
   private static final String LOG_CLASS = 
         DispatcherTests_SPEC2_19_DispatchForwardServlet.class.getName();
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
      JSR286DispatcherTestCaseDetails tcd = new JSR286DispatcherTestCaseDetails();

      // Create result objects for the tests

      /* TestCase: SPEC2_19_DispatchForwardServlet_invoke1                    */
      /* Details: "The PortletRequestDispatcher include method can include    */
      /* a target servlet "                                                   */
      TestResult tr0 = tcd.getTestResultFailed(SPEC2_19_DISPATCHFORWARDSERVLET_INVOKE1);
      /* TODO: implement test */
      tr0.writeTo(writer);

      /* TestCase: SPEC2_19_DispatchForwardServlet_invoke2                    */
      /* Details: "Parameters to the include method for a target servlet      */
      /* can be the request and response classes from the portlet lifecyle    */
      /* method initiating the include"                                       */
      TestResult tr1 = tcd.getTestResultFailed(SPEC2_19_DISPATCHFORWARDSERVLET_INVOKE2);
      /* TODO: implement test */
      tr1.writeTo(writer);

      /* TestCase: SPEC2_19_DispatchForwardServlet_invoke3                    */
      /* Details: "Parameters to the include method for a target servlet      */
      /* can be wrapped request and response classes from the portlet         */
      /* lifecyle method initiating the include"                              */
      TestResult tr2 = tcd.getTestResultFailed(SPEC2_19_DISPATCHFORWARDSERVLET_INVOKE3);
      /* TODO: implement test */
      tr2.writeTo(writer);

      /* TestCase: SPEC2_19_DispatchForwardServlet_invoke4                    */
      /* Details: "The portlet container must invoke the target servlet in    */
      /* the same thread as the PortletRequestDispatcher include              */
      /* invocation"                                                          */
      TestResult tr3 = tcd.getTestResultFailed(SPEC2_19_DISPATCHFORWARDSERVLET_INVOKE4);
      /* TODO: implement test */
      tr3.writeTo(writer);

      /* TestCase: SPEC2_19_DispatchForwardServlet_invoke5                    */
      /* Details: "If output data exists in the response buffer that has      */
      /* not been committed, the content must be cleared before the target    */
      /* servlet’s service method is called"                                  */
      TestResult tr4 = tcd.getTestResultFailed(SPEC2_19_DISPATCHFORWARDSERVLET_INVOKE5);
      /* TODO: implement test */
      tr4.writeTo(writer);

      /* TestCase: SPEC2_19_DispatchForwardServlet_invoke6                    */
      /* Details: "If the forward method is called after the response has     */
      /* been committed, an IllegalStateException exception is thrown"        */
      TestResult tr5 = tcd.getTestResultFailed(SPEC2_19_DISPATCHFORWARDSERVLET_INVOKE6);
      /* TODO: implement test */
      tr5.writeTo(writer);

      /* TestCase: SPEC2_19_DispatchForwardServlet_invoke7                    */
      /* Details: "Cookies set by the portlet before the forward call         */
      /* remain valid"                                                        */
      TestResult tr6 = tcd.getTestResultFailed(SPEC2_19_DISPATCHFORWARDSERVLET_INVOKE7);
      /* TODO: implement test */
      tr6.writeTo(writer);

      /* TestCase: SPEC2_19_DispatchForwardServlet_invoke8                    */
      /* Details: "A window state set by the portlet before the forward       */
      /* call remains valid"                                                  */
      TestResult tr7 = tcd.getTestResultFailed(SPEC2_19_DISPATCHFORWARDSERVLET_INVOKE8);
      /* TODO: implement test */
      tr7.writeTo(writer);

      /* TestCase: SPEC2_19_DispatchForwardServlet_invoke9                    */
      /* Details: "A portlet mode set by the portlet before the forward       */
      /* call remains valid"                                                  */
      TestResult tr8 = tcd.getTestResultFailed(SPEC2_19_DISPATCHFORWARDSERVLET_INVOKE9);
      /* TODO: implement test */
      tr8.writeTo(writer);

      /* TestCase: SPEC2_19_DispatchForwardServlet_invoke10                   */
      /* Details: "Properties set by the portlet before the forward call      */
      /* remain valid"                                                        */
      TestResult tr9 = tcd.getTestResultFailed(SPEC2_19_DISPATCHFORWARDSERVLET_INVOKE10);
      /* TODO: implement test */
      tr9.writeTo(writer);

      /* TestCase: SPEC2_19_DispatchForwardServlet_invoke11                   */
      /* Details: "Render parameters set by the portlet before the forward    */
      /* call remain valid"                                                   */
      TestResult tr10 = tcd.getTestResultFailed(SPEC2_19_DISPATCHFORWARDSERVLET_INVOKE11);
      /* TODO: implement test */
      tr10.writeTo(writer);

      /* TestCase: SPEC2_19_DispatchForwardServlet_invoke12                   */
      /* Details: "A portlet title set by the portlet before the forward      */
      /* call remains valid"                                                  */
      TestResult tr11 = tcd.getTestResultFailed(SPEC2_19_DISPATCHFORWARDSERVLET_INVOKE12);
      /* TODO: implement test */
      tr11.writeTo(writer);

      /* TestCase: SPEC2_19_DispatchForwardServlet_invoke13                   */
      /* Details: "The path elements of the request object exposed to the     */
      /* target servlet must reflect the path used to obtain the              */
      /* RequestDispatcher"                                                   */
      TestResult tr12 = tcd.getTestResultFailed(SPEC2_19_DISPATCHFORWARDSERVLET_INVOKE13);
      /* TODO: implement test */
      tr12.writeTo(writer);

      /* TestCase: SPEC2_19_DispatchForwardServlet_invoke14                   */
      /* Details: "Before the forward method of the RequestDispatcher         */
      /* interface returns, the response content must be sent and             */
      /* committed, and closed by the portlet container"                      */
      TestResult tr13 = tcd.getTestResultFailed(SPEC2_19_DISPATCHFORWARDSERVLET_INVOKE14);
      /* TODO: implement test */
      tr13.writeTo(writer);


   }

}

