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
public class AddlPortletTests_SPEC2_5_GenericPortlet implements Portlet {
   private static final String LOG_CLASS = 
         AddlPortletTests_SPEC2_5_GenericPortlet.class.getName();
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

      /* TestCase: SPEC2_5_GenericPortlet_actionDispatching2                  */
      /* Details: "If the ActionRequest.ACTION_NAME parameter is not set on   */
      /* the action URL, the GenericPortlet processAction method will throw   */
      /* a PortletException"                                                  */
      TestResult tr0 = tcd.getTestResultFailed(SPEC2_5_GENERICPORTLET_ACTIONDISPATCHING2);
      /* TODO: implement test */

      /* TestCase: SPEC2_5_GenericPortlet_eventDispatching1                   */
      /* Details: "The GenericPortlet processEvent method will dispatch the   */
      /* request to a subclass method annotated with the tag                  */
      /* @ProcessEvent(qname=<eventname>), where <eventname> must be in the   */
      /* format provided by Qname.toString()"                                 */
      TestResult tr1 = tcd.getTestResultFailed(SPEC2_5_GENERICPORTLET_EVENTDISPATCHING1);
      /* TODO: implement test */

      /* TestCase: SPEC2_5_GenericPortlet_eventDispatching2                   */
      /* Details: "The GenericPortlet processEvent method will dispatch the   */
      /* request to a subclass method annotated with the tag                  */
      /* @ProcessEvent(name=<event_name_local_part>)"                         */
      TestResult tr2 = tcd.getTestResultFailed(SPEC2_5_GENERICPORTLET_EVENTDISPATCHING2);
      /* TODO: implement test */

      /* TestCase: SPEC2_5_GenericPortlet_renderDispatching8                  */
      /* Details: "getTitle - If a ResourceBundle containing the title        */
      /* string is defined in the deployment descriptor, that title string    */
      /* will be used"                                                        */
      TestResult tr3 = tcd.getTestResultFailed(SPEC2_5_GENERICPORTLET_RENDERDISPATCHING8);
      /* TODO: implement test */

      /* TestCase: SPEC2_5_GenericPortlet_renderDispatching9                  */
      /* Details: "getTitle - If a ResourceBundle containing the title        */
      /* string is not defined in the deployment descriptor, the title        */
      /* defined in the portlet descriptor <title> element is used"           */
      TestResult tr4 = tcd.getTestResultFailed(SPEC2_5_GENERICPORTLET_RENDERDISPATCHING9);
      /* TODO: implement test */



      // Write the results to the output stream

      tr0.writeTo(writer);
      tr1.writeTo(writer);
      tr2.writeTo(writer);
      tr3.writeTo(writer);
      tr4.writeTo(writer);


   }

}

