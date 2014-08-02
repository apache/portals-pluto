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
public class AddlPortletTests_SPEC2_13_ResourceServing implements Portlet {
   private static final String LOG_CLASS = 
         AddlPortletTests_SPEC2_13_ResourceServing.class.getName();
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

      /* TestCase: SPEC2_13_ResourceServing_properties3                       */
      /* Details: "The setProperty method can set HTTP header values to be    */
      /* transported back to the client"                                      */
      TestResult tr0 = tcd.getTestResultFailed(SPEC2_13_RESOURCESERVING_PROPERTIES3);
      /* TODO: implement test */

      /* TestCase: SPEC2_13_ResourceServing_properties4                       */
      /* Details: "If the setProperty method is called after the response     */
      /* has been committed, the property will not be transported back to     */
      /* the client"                                                          */
      TestResult tr1 = tcd.getTestResultFailed(SPEC2_13_RESOURCESERVING_PROPERTIES4);
      /* TODO: implement test */

      /* TestCase: SPEC2_13_ResourceServing_properties7                       */
      /* Details: "The addProperty method can add HTTP header values to be    */
      /* transported back to the client"                                      */
      TestResult tr2 = tcd.getTestResultFailed(SPEC2_13_RESOURCESERVING_PROPERTIES7);
      /* TODO: implement test */

      /* TestCase: SPEC2_13_ResourceServing_properties8                       */
      /* Details: "If the addProperty method is called after the response     */
      /* has been committed, the property will not be transported back to     */
      /* the client"                                                          */
      TestResult tr3 = tcd.getTestResultFailed(SPEC2_13_RESOURCESERVING_PROPERTIES8);
      /* TODO: implement test */

      /* TestCase: SPEC2_13_ResourceServing_resourceURLs2                     */
      /* Details: "When a resource URL is invoked, the portlet container      */
      /* must not call the processAction method"                              */
      TestResult tr4 = tcd.getTestResultFailed(SPEC2_13_RESOURCESERVING_RESOURCEURLS2);
      /* TODO: implement test */

      /* TestCase: SPEC2_13_ResourceServing_resourceURLs3                     */
      /* Details: "When a resource URL is invoked, the portlet container      */
      /* must not call the processEvent method"                               */
      TestResult tr5 = tcd.getTestResultFailed(SPEC2_13_RESOURCESERVING_RESOURCEURLS3);
      /* TODO: implement test */

      /* TestCase: SPEC2_13_ResourceServing_resourceURLs4                     */
      /* Details: "After a resource URL has been created, the portlet mode    */
      /* set on the resource URL cannot be changed"                           */
      TestResult tr6 = tcd.getTestResultFailed(SPEC2_13_RESOURCESERVING_RESOURCEURLS4);
      /* TODO: implement test */

      /* TestCase: SPEC2_13_ResourceServing_resourceURLs5                     */
      /* Details: "After a resource URL has been created, the window state    */
      /* set on the resource URL cannot be changed"                           */
      TestResult tr7 = tcd.getTestResultFailed(SPEC2_13_RESOURCESERVING_RESOURCEURLS5);
      /* TODO: implement test */

      /* TestCase: SPEC2_13_ResourceServing_resourceURLs6                     */
      /* Details: "After a resource URL has been created, the render          */
      /* parameters set on the resource URL cannot be changed"                */
      TestResult tr8 = tcd.getTestResultFailed(SPEC2_13_RESOURCESERVING_RESOURCEURLS6);
      /* TODO: implement test */

      /* TestCase: SPEC2_13_ResourceServing_resourceURLs7                     */
      /* Details: "After a resource URL has been created, a parameter set     */
      /* on the resource URL is a resource parameter, not a render            */
      /* parameter"                                                           */
      TestResult tr9 = tcd.getTestResultFailed(SPEC2_13_RESOURCESERVING_RESOURCEURLS7);
      /* TODO: implement test */

      /* TestCase: SPEC2_13_ResourceServing_resourceURLs8                     */
      /* Details: "After a resource URL has been created, a parameter set     */
      /* on the URL with the same name as an exsisting render parameter       */
      /* results in a multivalued parameter containing both the resource      */
      /* pramaeter values and the render parameter values"                    */
      TestResult tr10 = tcd.getTestResultFailed(SPEC2_13_RESOURCESERVING_RESOURCEURLS8);
      /* TODO: implement test */

      /* TestCase: SPEC2_13_ResourceServing_resourceURLs9                     */
      /* Details: "In the resulting multivalued parameter after a resource    */
      /* parameter is added with the same name as a render parameter, the     */
      /* the render parameter values must be the last entries in the          */
      /* parameter value array"                                               */
      TestResult tr11 = tcd.getTestResultFailed(SPEC2_13_RESOURCESERVING_RESOURCEURLS9);
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

