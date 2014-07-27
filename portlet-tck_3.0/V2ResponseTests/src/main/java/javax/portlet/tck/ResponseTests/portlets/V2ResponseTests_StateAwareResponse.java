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

package javax.portlet.tck.ResponseTests.portlets;

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
public class V2ResponseTests_StateAwareResponse implements Portlet {
   private static final String LOG_CLASS = 
         V2ResponseTests_StateAwareResponse.class.getName();
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

      /* TestCase: StateAwareResponse_implementsPortletResponse2 */
      /* Details: "All tests described for the PortletResponse execute correctly with the StateAwareResponse" */
      TestResult tr0 = tcd.getTestResultFailed(STATEAWARERESPONSE_IMPLEMENTSPORTLETRESPONSE2);
      /* TODO: implement test */

      /* TestCase: StateAwareResponse_setWindowState1 */
      /* Details: "Sets the WindowState to the specified value" */
      TestResult tr1 = tcd.getTestResultFailed(STATEAWARERESPONSE_SETWINDOWSTATE1);
      /* TODO: implement test */

      /* TestCase: StateAwareResponse_setWindowState2 */
      /* Details: "Throws WindowStateException if the portlet cannot switch to the specified WindowState" */
      TestResult tr2 = tcd.getTestResultFailed(STATEAWARERESPONSE_SETWINDOWSTATE2);
      /* TODO: implement test */

      /* TestCase: StateAwareResponse_setWindowState3 */
      /* Details: "Throws IllegalStateException if the method is invoked after the sendRedirect method has been called" */
      TestResult tr3 = tcd.getTestResultFailed(STATEAWARERESPONSE_SETWINDOWSTATE3);
      /* TODO: implement test */

      /* TestCase: StateAwareResponse_setPortletMode1 */
      /* Details: "Sets the PortletMode to the specified value" */
      TestResult tr4 = tcd.getTestResultFailed(STATEAWARERESPONSE_SETPORTLETMODE1);
      /* TODO: implement test */

      /* TestCase: StateAwareResponse_setPortletMode2 */
      /* Details: "Throws PortletModeException if the portlet cannot switch to the specified PortletMode" */
      TestResult tr5 = tcd.getTestResultFailed(STATEAWARERESPONSE_SETPORTLETMODE2);
      /* TODO: implement test */

      /* TestCase: StateAwareResponse_setPortletMode3 */
      /* Details: "Throws IllegalStateException if the method is invoked after the sendRedirect method has been called" */
      TestResult tr6 = tcd.getTestResultFailed(STATEAWARERESPONSE_SETPORTLETMODE3);
      /* TODO: implement test */

      /* TestCase: StateAwareResponse_setRenderParameters1 */
      /* Details: "Sets the render parameter map to the specified value" */
      TestResult tr7 = tcd.getTestResultFailed(STATEAWARERESPONSE_SETRENDERPARAMETERS1);
      /* TODO: implement test */

      /* TestCase: StateAwareResponse_setRenderParameters2 */
      /* Details: "Public render parameters can be set through the map" */
      TestResult tr8 = tcd.getTestResultFailed(STATEAWARERESPONSE_SETRENDERPARAMETERS2);
      /* TODO: implement test */

      /* TestCase: StateAwareResponse_setRenderParameters3 */
      /* Details: "Private render parameters can be set through the map" */
      TestResult tr9 = tcd.getTestResultFailed(STATEAWARERESPONSE_SETRENDERPARAMETERS3);
      /* TODO: implement test */

      /* TestCase: StateAwareResponse_setRenderParameters4 */
      /* Details: "Previously existing private render parameters not contained in the specified input map are removed" */
      TestResult tr10 = tcd.getTestResultFailed(STATEAWARERESPONSE_SETRENDERPARAMETERS4);
      /* TODO: implement test */

      /* TestCase: StateAwareResponse_setRenderParameters5 */
      /* Details: "Previously existing public render parameters not contained in the specified input map remain unchanged" */
      TestResult tr11 = tcd.getTestResultFailed(STATEAWARERESPONSE_SETRENDERPARAMETERS5);
      /* TODO: implement test */

      /* TestCase: StateAwareResponse_setRenderParameters6 */
      /* Details: "Parameters that are set are available in subsequent render requests" */
      TestResult tr12 = tcd.getTestResultFailed(STATEAWARERESPONSE_SETRENDERPARAMETERS6);
      /* TODO: implement test */

      /* TestCase: StateAwareResponse_setRenderParameters7 */
      /* Details: "Throws IllegalArgumentException if the input map is null" */
      TestResult tr13 = tcd.getTestResultFailed(STATEAWARERESPONSE_SETRENDERPARAMETERS7);
      /* TODO: implement test */

      /* TestCase: StateAwareResponse_setRenderParameters8 */
      /* Details: "Throws IllegalArgumentException if any key in the map is null" */
      TestResult tr14 = tcd.getTestResultFailed(STATEAWARERESPONSE_SETRENDERPARAMETERS8);
      /* TODO: implement test */

      /* TestCase: StateAwareResponse_setRenderParameters9 */
      /* Details: "Throws IllegalArgumentException if any key in the map is the empty string (\"\") " */
      TestResult tr15 = tcd.getTestResultFailed(STATEAWARERESPONSE_SETRENDERPARAMETERS9);
      /* TODO: implement test */

      /* TestCase: StateAwareResponse_setRenderParameters10 */
      /* Details: "Throws IllegalArgumentException if the values array for any key is null " */
      TestResult tr16 = tcd.getTestResultFailed(STATEAWARERESPONSE_SETRENDERPARAMETERS10);
      /* TODO: implement test */

      /* TestCase: StateAwareResponse_setRenderParameters11 */
      /* Details: "Throws IllegalArgumentException if any element in any values array is null " */
      TestResult tr17 = tcd.getTestResultFailed(STATEAWARERESPONSE_SETRENDERPARAMETERS11);
      /* TODO: implement test */

      /* TestCase: StateAwareResponse_setRenderParameters12 */
      /* Details: "Throws IllegalStateException if the method is invoked after the sendRedirect method has been called" */
      TestResult tr18 = tcd.getTestResultFailed(STATEAWARERESPONSE_SETRENDERPARAMETERS12);
      /* TODO: implement test */

      /* TestCase: StateAwareResponse_setRenderParameterA1 */
      /* Details: "Sets the parameter value for the specified name" */
      TestResult tr19 = tcd.getTestResultFailed(STATEAWARERESPONSE_SETRENDERPARAMETERA1);
      /* TODO: implement test */

      /* TestCase: StateAwareResponse_setRenderParameterA2 */
      /* Details: "A private parameter can be set" */
      TestResult tr20 = tcd.getTestResultFailed(STATEAWARERESPONSE_SETRENDERPARAMETERA2);
      /* TODO: implement test */

      /* TestCase: StateAwareResponse_setRenderParameterA3 */
      /* Details: "A public parameter can be set" */
      TestResult tr21 = tcd.getTestResultFailed(STATEAWARERESPONSE_SETRENDERPARAMETERA3);
      /* TODO: implement test */

      /* TestCase: StateAwareResponse_setRenderParameterA4 */
      /* Details: "All previously existing values for the specified name are removed" */
      TestResult tr22 = tcd.getTestResultFailed(STATEAWARERESPONSE_SETRENDERPARAMETERA4);
      /* TODO: implement test */

      /* TestCase: StateAwareResponse_setRenderParameterA5 */
      /* Details: "If the value is null, all values for the specified name are removed" */
      TestResult tr23 = tcd.getTestResultFailed(STATEAWARERESPONSE_SETRENDERPARAMETERA5);
      /* TODO: implement test */

      /* TestCase: StateAwareResponse_setRenderParameterA6 */
      /* Details: "Parameters that are set are available in subsequent render requests" */
      TestResult tr24 = tcd.getTestResultFailed(STATEAWARERESPONSE_SETRENDERPARAMETERA6);
      /* TODO: implement test */

      /* TestCase: StateAwareResponse_setRenderParameterA7 */
      /* Details: "Throws IllegalArgumentException if the name is null" */
      TestResult tr25 = tcd.getTestResultFailed(STATEAWARERESPONSE_SETRENDERPARAMETERA7);
      /* TODO: implement test */

      /* TestCase: StateAwareResponse_setRenderParameterA8 */
      /* Details: "Throws IllegalStateException if the method is invoked after the sendRedirect method has been called" */
      TestResult tr26 = tcd.getTestResultFailed(STATEAWARERESPONSE_SETRENDERPARAMETERA8);
      /* TODO: implement test */

      /* TestCase: StateAwareResponse_setRenderParameterB1 */
      /* Details: "Sets the parameter values for the specified name." */
      TestResult tr27 = tcd.getTestResultFailed(STATEAWARERESPONSE_SETRENDERPARAMETERB1);
      /* TODO: implement test */

      /* TestCase: StateAwareResponse_setRenderParameterB2 */
      /* Details: "All existing values are removed" */
      TestResult tr28 = tcd.getTestResultFailed(STATEAWARERESPONSE_SETRENDERPARAMETERB2);
      /* TODO: implement test */

      /* TestCase: StateAwareResponse_setRenderParameterB3 */
      /* Details: "Parameters that are set are available in subsequent render requests" */
      TestResult tr29 = tcd.getTestResultFailed(STATEAWARERESPONSE_SETRENDERPARAMETERB3);
      /* TODO: implement test */

      /* TestCase: StateAwareResponse_setRenderParameterB4 */
      /* Details: "Throws IllegalArgumentException if the name is null" */
      TestResult tr30 = tcd.getTestResultFailed(STATEAWARERESPONSE_SETRENDERPARAMETERB4);
      /* TODO: implement test */

      /* TestCase: StateAwareResponse_setRenderParameterB5 */
      /* Details: "Throws IllegalArgumentException if the values array is null" */
      TestResult tr31 = tcd.getTestResultFailed(STATEAWARERESPONSE_SETRENDERPARAMETERB5);
      /* TODO: implement test */

      /* TestCase: StateAwareResponse_setRenderParameterB6 */
      /* Details: "Throws IllegalStateException if the method is invoked after the sendRedirect method has been called" */
      TestResult tr32 = tcd.getTestResultFailed(STATEAWARERESPONSE_SETRENDERPARAMETERB6);
      /* TODO: implement test */

      /* TestCase: StateAwareResponse_setEventA1 */
      /* Details: "Publishes an event with the specified name and payload" */
      TestResult tr33 = tcd.getTestResultFailed(STATEAWARERESPONSE_SETEVENTA1);
      /* TODO: implement test */

      /* TestCase: StateAwareResponse_setEventA2 */
      /* Details: "Throws IllegalArgumentException if the name is null" */
      TestResult tr34 = tcd.getTestResultFailed(STATEAWARERESPONSE_SETEVENTA2);
      /* TODO: implement test */

      /* TestCase: StateAwareResponse_setEventA3 */
      /* Details: "Throws IllegalArgumentException if the value is not serializable" */
      TestResult tr35 = tcd.getTestResultFailed(STATEAWARERESPONSE_SETEVENTA3);
      /* TODO: implement test */

      /* TestCase: StateAwareResponse_setEventA4 */
      /* Details: "Throws IllegalArgumentException if the value does not have a valid JAXB binding" */
      TestResult tr36 = tcd.getTestResultFailed(STATEAWARERESPONSE_SETEVENTA4);
      /* TODO: implement test */

      /* TestCase: StateAwareResponse_setEventA5 */
      /* Details: "Throws IllegalArgumentException if the value object type is not as specified in the deployment descriptor" */
      TestResult tr37 = tcd.getTestResultFailed(STATEAWARERESPONSE_SETEVENTA5);
      /* TODO: implement test */

      /* TestCase: StateAwareResponse_setEventB1 */
      /* Details: "Publishes an event with the specified name and payload" */
      TestResult tr38 = tcd.getTestResultFailed(STATEAWARERESPONSE_SETEVENTB1);
      /* TODO: implement test */

      /* TestCase: StateAwareResponse_setEventB2 */
      /* Details: "Throws IllegalArgumentException if the name is null" */
      TestResult tr39 = tcd.getTestResultFailed(STATEAWARERESPONSE_SETEVENTB2);
      /* TODO: implement test */

      /* TestCase: StateAwareResponse_setEventB3 */
      /* Details: "Throws IllegalArgumentException if the value is not serializable" */
      TestResult tr40 = tcd.getTestResultFailed(STATEAWARERESPONSE_SETEVENTB3);
      /* TODO: implement test */

      /* TestCase: StateAwareResponse_setEventB4 */
      /* Details: "Throws IllegalArgumentException if the value does not have a valid JAXB binding" */
      TestResult tr41 = tcd.getTestResultFailed(STATEAWARERESPONSE_SETEVENTB4);
      /* TODO: implement test */

      /* TestCase: StateAwareResponse_setEventB5 */
      /* Details: "Throws IllegalArgumentException if the value object type is not as specified in the deployment descriptor" */
      TestResult tr42 = tcd.getTestResultFailed(STATEAWARERESPONSE_SETEVENTB5);
      /* TODO: implement test */

      /* TestCase: StateAwareResponse_getRenderParameterMap1 */
      /* Details: "Returns a map of the render parameters currently set on the response" */
      TestResult tr43 = tcd.getTestResultFailed(STATEAWARERESPONSE_GETRENDERPARAMETERMAP1);
      /* TODO: implement test */

      /* TestCase: StateAwareResponse_getRenderParameterMap2 */
      /* Details: "The returned map contains public render parameters" */
      TestResult tr44 = tcd.getTestResultFailed(STATEAWARERESPONSE_GETRENDERPARAMETERMAP2);
      /* TODO: implement test */

      /* TestCase: StateAwareResponse_getRenderParameterMap3 */
      /* Details: "The returned map contains private render parameters" */
      TestResult tr45 = tcd.getTestResultFailed(STATEAWARERESPONSE_GETRENDERPARAMETERMAP3);
      /* TODO: implement test */

      /* TestCase: StateAwareResponse_getRenderParameterMap4 */
      /* Details: "An empty map is returned if no parameters have been set " */
      TestResult tr46 = tcd.getTestResultFailed(STATEAWARERESPONSE_GETRENDERPARAMETERMAP4);
      /* TODO: implement test */

      /* TestCase: StateAwareResponse_getPortletMode1 */
      /* Details: "Returns the current PortletMode for the portlet" */
      TestResult tr47 = tcd.getTestResultFailed(STATEAWARERESPONSE_GETPORTLETMODE1);
      /* TODO: implement test */

      /* TestCase: StateAwareResponse_getPortletMode2 */
      /* Details: "Returns null if no PortletMode has been set" */
      TestResult tr48 = tcd.getTestResultFailed(STATEAWARERESPONSE_GETPORTLETMODE2);
      /* TODO: implement test */

      /* TestCase: StateAwareResponse_getWindowState1 */
      /* Details: "Returns the current WindowState for the portlet" */
      TestResult tr49 = tcd.getTestResultFailed(STATEAWARERESPONSE_GETWINDOWSTATE1);
      /* TODO: implement test */

      /* TestCase: StateAwareResponse_getWindowState2 */
      /* Details: "Returns null if no WindowState has been set" */
      TestResult tr50 = tcd.getTestResultFailed(STATEAWARERESPONSE_GETWINDOWSTATE2);
      /* TODO: implement test */

      /* TestCase: StateAwareResponse_removePublicRenderParameter1 */
      /* Details: "Removes the specified public render parameter" */
      TestResult tr51 = tcd.getTestResultFailed(STATEAWARERESPONSE_REMOVEPUBLICRENDERPARAMETER1);
      /* TODO: implement test */

      /* TestCase: StateAwareResponse_removePublicRenderParameter2 */
      /* Details: "Throws IllegalArgumentException if the name is null" */
      TestResult tr52 = tcd.getTestResultFailed(STATEAWARERESPONSE_REMOVEPUBLICRENDERPARAMETER2);
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
      tr37.writeTo(writer);
      tr38.writeTo(writer);
      tr39.writeTo(writer);
      tr40.writeTo(writer);
      tr41.writeTo(writer);
      tr42.writeTo(writer);
      tr43.writeTo(writer);
      tr44.writeTo(writer);
      tr45.writeTo(writer);
      tr46.writeTo(writer);
      tr47.writeTo(writer);
      tr48.writeTo(writer);
      tr49.writeTo(writer);
      tr50.writeTo(writer);
      tr51.writeTo(writer);
      tr52.writeTo(writer);


   }

}

