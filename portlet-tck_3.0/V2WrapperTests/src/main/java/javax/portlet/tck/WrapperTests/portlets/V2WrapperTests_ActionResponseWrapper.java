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

package javax.portlet.tck.WrapperTests.portlets;

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
public class V2WrapperTests_ActionResponseWrapper implements Portlet {
   private static final String LOG_CLASS = 
         V2WrapperTests_ActionResponseWrapper.class.getName();
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
      ClassChecker cc = new ClassChecker(ActionResponseWrapper.class);

      // Create result objects for the tests

      /* TestCase: ActionResponseWrapper_sendRedirectA */
      /* Details: "Calls wrapped method" */
      TestResult tr0 = tcd.getTestResultFailed(ACTIONRESPONSEWRAPPER_SENDREDIRECTA);
      /* TODO: implement test */

      /* TestCase: ActionResponseWrapper_sendRedirectB */
      /* Details: "Calls wrapped method" */
      TestResult tr1 = tcd.getTestResultFailed(ACTIONRESPONSEWRAPPER_SENDREDIRECTB);
      /* TODO: implement test */

      /* TestCase: ActionResponseWrapper_setEventA */
      /* Details: "Calls wrapped method" */
      TestResult tr2 = tcd.getTestResultFailed(ACTIONRESPONSEWRAPPER_SETEVENTA);
      /* TODO: implement test */

      /* TestCase: ActionResponseWrapper_setEventB */
      /* Details: "Calls wrapped method" */
      TestResult tr3 = tcd.getTestResultFailed(ACTIONRESPONSEWRAPPER_SETEVENTB);
      /* TODO: implement test */

      /* TestCase: ActionResponseWrapper_setPortletMode */
      /* Details: "Calls wrapped method" */
      TestResult tr4 = tcd.getTestResultFailed(ACTIONRESPONSEWRAPPER_SETPORTLETMODE);
      /* TODO: implement test */

      /* TestCase: ActionResponseWrapper_setRenderParameterA */
      /* Details: "Calls wrapped method" */
      TestResult tr5 = tcd.getTestResultFailed(ACTIONRESPONSEWRAPPER_SETRENDERPARAMETERA);
      /* TODO: implement test */

      /* TestCase: ActionResponseWrapper_setRenderParameterB */
      /* Details: "Calls wrapped method" */
      TestResult tr6 = tcd.getTestResultFailed(ACTIONRESPONSEWRAPPER_SETRENDERPARAMETERB);
      /* TODO: implement test */

      /* TestCase: ActionResponseWrapper_setRenderParameters */
      /* Details: "Calls wrapped method" */
      TestResult tr7 = tcd.getTestResultFailed(ACTIONRESPONSEWRAPPER_SETRENDERPARAMETERS);
      /* TODO: implement test */

      /* TestCase: ActionResponseWrapper_setWindowState */
      /* Details: "Calls wrapped method" */
      TestResult tr8 = tcd.getTestResultFailed(ACTIONRESPONSEWRAPPER_SETWINDOWSTATE);
      /* TODO: implement test */

      /* TestCase: ActionResponseWrapper_getResponse */
      /* Details: "Returns wrapped ActionResponse object" */
      TestResult tr9 = tcd.getTestResultFailed(ACTIONRESPONSEWRAPPER_GETRESPONSE);
      /* TODO: implement test */

      /* TestCase: ActionResponseWrapper_setResponse */
      /* Details: "Allows wrapped ActionResponse object to be set" */
      TestResult tr10 = tcd.getTestResultFailed(ACTIONRESPONSEWRAPPER_SETRESPONSE);
      /* TODO: implement test */

      /* TestCase: ActionResponseWrapper_getPortletMode */
      /* Details: "Calls wrapped method" */
      TestResult tr11 = tcd.getTestResultFailed(ACTIONRESPONSEWRAPPER_GETPORTLETMODE);
      /* TODO: implement test */

      /* TestCase: ActionResponseWrapper_getRenderParameterMap1 */
      /* Details: "Calls wrapped method" */
      TestResult tr12 = tcd.getTestResultFailed(ACTIONRESPONSEWRAPPER_GETRENDERPARAMETERMAP1);
      /* TODO: implement test */

      /* TestCase: ActionResponseWrapper_getRenderParameterMap2 */
      /* Details: "Returns java.util.Map<java.lang.String,java.lang.String[]> object" */
      TestResult tr13 = tcd.getTestResultFailed(ACTIONRESPONSEWRAPPER_GETRENDERPARAMETERMAP2);
      /* TODO: implement test */

      /* TestCase: ActionResponseWrapper_getWindowState */
      /* Details: "Calls wrapped method" */
      TestResult tr14 = tcd.getTestResultFailed(ACTIONRESPONSEWRAPPER_GETWINDOWSTATE);
      /* TODO: implement test */

      /* TestCase: ActionResponseWrapper_removePublicRenderParameter */
      /* Details: "Calls wrapped method" */
      TestResult tr15 = tcd.getTestResultFailed(ACTIONRESPONSEWRAPPER_REMOVEPUBLICRENDERPARAMETER);
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


   }

}

