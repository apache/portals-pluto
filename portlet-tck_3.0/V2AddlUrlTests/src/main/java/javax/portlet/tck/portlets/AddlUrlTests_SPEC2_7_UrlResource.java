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
public class AddlUrlTests_SPEC2_7_UrlResource implements Portlet {
   private static final String LOG_CLASS = 
         AddlUrlTests_SPEC2_7_UrlResource.class.getName();
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

      /* TestCase: SPEC2_7_UrlResource_resourceURL1                           */
      /* Details: "When a resource URL is triggered, the serveResource        */
      /* method must be invoked"                                              */
      TestResult tr0 = tcd.getTestResultFailed(SPEC2_7_URLRESOURCE_RESOURCEURL1);
      /* TODO: implement test */

      /* TestCase: SPEC2_7_UrlResource_resourceURL2                           */
      /* Details: "When resource parameters are set on a resource URL,        */
      /* those parameters must become resource parameters of the request      */
      /* resulting from triggering the resourceURL"                           */
      TestResult tr1 = tcd.getTestResultFailed(SPEC2_7_URLRESOURCE_RESOURCEURL2);
      /* TODO: implement test */

      /* TestCase: SPEC2_7_UrlResource_resourceURL3                           */
      /* Details: "When resource parameters are set on a resource URL,        */
      /* those parameters must become resource parameters of the request      */
      /* resulting from triggering the resourceURL"                           */
      TestResult tr2 = tcd.getTestResultFailed(SPEC2_7_URLRESOURCE_RESOURCEURL3);
      /* TODO: implement test */

      /* TestCase: SPEC2_7_UrlResource_resourceURL4                           */
      /* Details: "Resource parameters can be set on the resource URL         */
      /* through the setParameter(String, String) method"                     */
      TestResult tr3 = tcd.getTestResultFailed(SPEC2_7_URLRESOURCE_RESOURCEURL4);
      /* TODO: implement test */

      /* TestCase: SPEC2_7_UrlResource_resourceURL5                           */
      /* Details: "Resource parameters can be set on the resource URL         */
      /* through the setParameter(String, String[]) method"                   */
      TestResult tr4 = tcd.getTestResultFailed(SPEC2_7_URLRESOURCE_RESOURCEURL5);
      /* TODO: implement test */

      /* TestCase: SPEC2_7_UrlResource_resourceURL6                           */
      /* Details: "Resource parameters can be set on the resource URL         */
      /* through the setParameterMap(Map<String, String[]>) method"           */
      TestResult tr5 = tcd.getTestResultFailed(SPEC2_7_URLRESOURCE_RESOURCEURL6);
      /* TODO: implement test */

      /* TestCase: SPEC2_7_UrlResource_resourceURL7                           */
      /* Details: "If a parameter with an existing name is set through one    */
      /* of the setParameter methods, the existing value is replaced with     */
      /* the new value"                                                       */
      TestResult tr6 = tcd.getTestResultFailed(SPEC2_7_URLRESOURCE_RESOURCEURL7);
      /* TODO: implement test */

      /* TestCase: SPEC2_7_UrlResource_resourceURL8                           */
      /* Details: "When a resource URL is created, render parameters from     */
      /* the current request are automatically copied to the new resource     */
      /* URL"                                                                 */
      TestResult tr7 = tcd.getTestResultFailed(SPEC2_7_URLRESOURCE_RESOURCEURL8);
      /* TODO: implement test */

      /* TestCase: SPEC2_7_UrlResource_resourceURL9                           */
      /* Details: "When a resource URL is created, the automatically copied   */
      /* render parameters are hidden to the ResourceURL getParameter         */
      /* method"                                                              */
      TestResult tr8 = tcd.getTestResultFailed(SPEC2_7_URLRESOURCE_RESOURCEURL9);
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


   }

}

