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
public class V2WrapperTests_EventResponseWrapper implements Portlet {
   private static final String LOG_CLASS = 
         V2WrapperTests_EventResponseWrapper.class.getName();
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
      ClassChecker cc = new ClassChecker(EventResponseWrapper.class);

      // Create result objects for the tests

      /* TestCase: EventResponseWrapper_setEventA */
      /* Details: "Calls wrapped method" */
      TestResult tr0 = tcd.getTestResultFailed(EVENTRESPONSEWRAPPER_SETEVENTA);
      /* TODO: implement test */

      /* TestCase: EventResponseWrapper_setEventB */
      /* Details: "Calls wrapped method" */
      TestResult tr1 = tcd.getTestResultFailed(EVENTRESPONSEWRAPPER_SETEVENTB);
      /* TODO: implement test */

      /* TestCase: EventResponseWrapper_setPortletMode */
      /* Details: "Calls wrapped method" */
      TestResult tr2 = tcd.getTestResultFailed(EVENTRESPONSEWRAPPER_SETPORTLETMODE);
      /* TODO: implement test */

      /* TestCase: EventResponseWrapper_setRenderParameterA */
      /* Details: "Calls wrapped method" */
      TestResult tr3 = tcd.getTestResultFailed(EVENTRESPONSEWRAPPER_SETRENDERPARAMETERA);
      /* TODO: implement test */

      /* TestCase: EventResponseWrapper_setRenderParameterB */
      /* Details: "Calls wrapped method" */
      TestResult tr4 = tcd.getTestResultFailed(EVENTRESPONSEWRAPPER_SETRENDERPARAMETERB);
      /* TODO: implement test */

      /* TestCase: EventResponseWrapper_setRenderParametersA */
      /* Details: "Calls wrapped method" */
      TestResult tr5 = tcd.getTestResultFailed(EVENTRESPONSEWRAPPER_SETRENDERPARAMETERSA);
      /* TODO: implement test */

      /* TestCase: EventResponseWrapper_setRenderParametersB */
      /* Details: "Calls wrapped method" */
      TestResult tr6 = tcd.getTestResultFailed(EVENTRESPONSEWRAPPER_SETRENDERPARAMETERSB);
      /* TODO: implement test */

      /* TestCase: EventResponseWrapper_setWindowState */
      /* Details: "Calls wrapped method" */
      TestResult tr7 = tcd.getTestResultFailed(EVENTRESPONSEWRAPPER_SETWINDOWSTATE);
      /* TODO: implement test */

      /* TestCase: EventResponseWrapper_getResponse */
      /* Details: "Returns wrapped EventResponse obect" */
      TestResult tr8 = tcd.getTestResultFailed(EVENTRESPONSEWRAPPER_GETRESPONSE);
      /* TODO: implement test */

      /* TestCase: EventResponseWrapper_setResponse */
      /* Details: "Allows wrapped EventResponse object to be set" */
      TestResult tr9 = tcd.getTestResultFailed(EVENTRESPONSEWRAPPER_SETRESPONSE);
      /* TODO: implement test */

      /* TestCase: EventResponseWrapper_getPortletMode */
      /* Details: "Calls wrapped method" */
      TestResult tr10 = tcd.getTestResultFailed(EVENTRESPONSEWRAPPER_GETPORTLETMODE);
      /* TODO: implement test */

      /* TestCase: EventResponseWrapper_getRenderParameterMap1 */
      /* Details: "Calls wrapped method" */
      TestResult tr11 = tcd.getTestResultFailed(EVENTRESPONSEWRAPPER_GETRENDERPARAMETERMAP1);
      /* TODO: implement test */

      /* TestCase: EventResponseWrapper_getRenderParameterMap2 */
      /* Details: "Returns java.util.Map<java.lang.String,java.lang.String[]> object" */
      TestResult tr12 = tcd.getTestResultFailed(EVENTRESPONSEWRAPPER_GETRENDERPARAMETERMAP2);
      /* TODO: implement test */

      /* TestCase: EventResponseWrapper_getWindowState */
      /* Details: "Calls wrapped method" */
      TestResult tr13 = tcd.getTestResultFailed(EVENTRESPONSEWRAPPER_GETWINDOWSTATE);
      /* TODO: implement test */

      /* TestCase: EventResponseWrapper_removePublicRenderParameter */
      /* Details: "Calls wrapped method" */
      TestResult tr14 = tcd.getTestResultFailed(EVENTRESPONSEWRAPPER_REMOVEPUBLICRENDERPARAMETER);
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


   }

}

