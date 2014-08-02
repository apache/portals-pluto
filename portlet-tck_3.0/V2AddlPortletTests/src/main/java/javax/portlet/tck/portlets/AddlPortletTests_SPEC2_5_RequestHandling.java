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
public class AddlPortletTests_SPEC2_5_RequestHandling implements Portlet {
   private static final String LOG_CLASS = 
         AddlPortletTests_SPEC2_5_RequestHandling.class.getName();
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

      /* TestCase: SPEC2_5_RequestHandling_action2                            */
      /* Details: "During action processing, the portlet container waits      */
      /* for the processAction method to complete before processing any       */
      /* events that were set"                                                */
      TestResult tr0 = tcd.getTestResultFailed(SPEC2_5_REQUESTHANDLING_ACTION2);
      /* TODO: implement test */

      /* TestCase: SPEC2_5_RequestHandling_action5                            */
      /* Details: "If the portlet issues a redirect during action             */
      /* processing, the portlet container allows the processAction method    */
      /* to complete"                                                         */
      TestResult tr1 = tcd.getTestResultFailed(SPEC2_5_REQUESTHANDLING_ACTION5);
      /* TODO: implement test */

      /* TestCase: SPEC2_5_RequestHandling_action6                            */
      /* Details: "If the portlet issues a redirect during action             */
      /* processing, the portlet container must send the redirect back to     */
      /* the user agent and finalize the request processing."                 */
      TestResult tr2 = tcd.getTestResultFailed(SPEC2_5_REQUESTHANDLING_ACTION6);
      /* TODO: implement test */

      /* TestCase: SPEC2_5_RequestHandling_action7                            */
      /* Details: "If the portlet issues a redirect during action             */
      /* processing, events that were set are not processed"                  */
      TestResult tr3 = tcd.getTestResultFailed(SPEC2_5_REQUESTHANDLING_ACTION7);
      /* TODO: implement test */

      /* TestCase: SPEC2_5_RequestHandling_render1                            */
      /* Details: "If the client request is triggered by a render URL, the    */
      /* portlet container must invoke the render method for all portlets     */
      /* on the page that do not have valid cache entries"                    */
      TestResult tr4 = tcd.getTestResultFailed(SPEC2_5_REQUESTHANDLING_RENDER1);
      /* TODO: implement test */

      /* TestCase: SPEC2_5_RequestHandling_render3                            */
      /* Details: "If the client request is triggered by a render URL, the    */
      /* portlet container must not invoke the processAction method for any   */
      /* portlet on the page"                                                 */
      TestResult tr5 = tcd.getTestResultFailed(SPEC2_5_REQUESTHANDLING_RENDER3);
      /* TODO: implement test */

      /* TestCase: SPEC2_5_RequestHandling_resource1                          */
      /* Details: "If the client request is triggered by a resource URL,      */
      /* the portlet container must invoke the serveResource method for the   */
      /* target portlet if its content does not have a valid cache entry"     */
      TestResult tr6 = tcd.getTestResultFailed(SPEC2_5_REQUESTHANDLING_RESOURCE1);
      /* TODO: implement test */

      /* TestCase: SPEC2_5_RequestHandling_resource3                          */
      /* Details: "If the client request is triggered by a resource URL,      */
      /* the portlet container must not invoke the processAction method for   */
      /* any portlet on the page"                                             */
      TestResult tr7 = tcd.getTestResultFailed(SPEC2_5_REQUESTHANDLING_RESOURCE3);
      /* TODO: implement test */

      /* TestCase: SPEC2_5_RequestHandling_exception1                         */
      /* Details: "If the portlet throws an PortletException in               */
      /* processAction, all operations on the ActionResponse, including set   */
      /* events, must be ignored"                                             */
      TestResult tr8 = tcd.getTestResultFailed(SPEC2_5_REQUESTHANDLING_EXCEPTION1);
      /* TODO: implement test */

      /* TestCase: SPEC2_5_RequestHandling_exception2                         */
      /* Details: "If the portlet throws a RuntimeException in                */
      /* processAction, all operations on the ActionResponse, including set   */
      /* events, must be ignored"                                             */
      TestResult tr9 = tcd.getTestResultFailed(SPEC2_5_REQUESTHANDLING_EXCEPTION2);
      /* TODO: implement test */

      /* TestCase: SPEC2_5_RequestHandling_exception4                         */
      /* Details: "If the portlet throws an PortletException in               */
      /* processEvent, all operations on the EventResponse, including set     */
      /* events, must be ignored"                                             */
      TestResult tr10 = tcd.getTestResultFailed(SPEC2_5_REQUESTHANDLING_EXCEPTION4);
      /* TODO: implement test */

      /* TestCase: SPEC2_5_RequestHandling_exception5                         */
      /* Details: "If the portlet throws a RuntimeException in                */
      /* processEvent, all operations on the EventResponse, including set     */
      /* events, must be ignored"                                             */
      TestResult tr11 = tcd.getTestResultFailed(SPEC2_5_REQUESTHANDLING_EXCEPTION5);
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


   }

}

