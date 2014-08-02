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
public class AddlEnvironmentTests_SPEC2_10_Context implements Portlet {
   private static final String LOG_CLASS = 
         AddlEnvironmentTests_SPEC2_10_Context.class.getName();
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

      /* TestCase: SPEC2_10_Context_portletContextServletContext1             */
      /* Details: "The initialization parameters accessible through the       */
      /* PortletContext must be the same that are accessible through the      */
      /* ServletContext of the portlet application"                           */
      TestResult tr0 = tcd.getTestResultFailed(SPEC2_10_CONTEXT_PORTLETCONTEXTSERVLETCONTEXT1);
      /* TODO: implement test */

      /* TestCase: SPEC2_10_Context_portletContextServletContext2             */
      /* Details: "The context initialization parameters are set in the       */
      /* web.xml file"                                                        */
      TestResult tr1 = tcd.getTestResultFailed(SPEC2_10_CONTEXT_PORTLETCONTEXTSERVLETCONTEXT2);
      /* TODO: implement test */

      /* TestCase: SPEC2_10_Context_portletContextServletContext3             */
      /* Details: "The PortletContext must offer access to the same set of    */
      /* resources the ServletContext exposes"                                */
      TestResult tr2 = tcd.getTestResultFailed(SPEC2_10_CONTEXT_PORTLETCONTEXTSERVLETCONTEXT3);
      /* TODO: implement test */

      /* TestCase: SPEC2_10_Context_portletContextServletContext4             */
      /* Details: "The temporary working directory must be accessible as a    */
      /* context attribute through the PortletContext using the attribute     */
      /* name \"javax.servlet.context.tempdir\""                              */
      TestResult tr3 = tcd.getTestResultFailed(SPEC2_10_CONTEXT_PORTLETCONTEXTSERVLETCONTEXT4);
      /* TODO: implement test */

      /* TestCase: SPEC2_10_Context_portletContextServletContext7             */
      /* Details: "The PortletContext getAttribute method provides the same   */
      /* functionality as the ServletContext getAttribute method"             */
      TestResult tr4 = tcd.getTestResultFailed(SPEC2_10_CONTEXT_PORTLETCONTEXTSERVLETCONTEXT7);
      /* TODO: implement test */

      /* TestCase: SPEC2_10_Context_portletContextServletContext8             */
      /* Details: "The PortletContext getAttributeNames method provides the   */
      /* same functionality as the ServletContext getAttributeNames method"   */
      TestResult tr5 = tcd.getTestResultFailed(SPEC2_10_CONTEXT_PORTLETCONTEXTSERVLETCONTEXT8);
      /* TODO: implement test */

      /* TestCase: SPEC2_10_Context_portletContextServletContext9             */
      /* Details: "The PortletContext getInitParameter method provides the    */
      /* same functionality as the ServletContext getInitParameter method"    */
      TestResult tr6 = tcd.getTestResultFailed(SPEC2_10_CONTEXT_PORTLETCONTEXTSERVLETCONTEXT9);
      /* TODO: implement test */

      /* TestCase: SPEC2_10_Context_portletContextServletContext10            */
      /* Details: "The PortletContext getInitParameterNames method provides   */
      /* the same functionality as the ServletContext getInitParameterNames   */
      /* method"                                                              */
      TestResult tr7 = tcd.getTestResultFailed(SPEC2_10_CONTEXT_PORTLETCONTEXTSERVLETCONTEXT10);
      /* TODO: implement test */

      /* TestCase: SPEC2_10_Context_portletContextServletContext11            */
      /* Details: "The PortletContext getMimeType method provides the same    */
      /* functionality as the ServletContext getMimeType method"              */
      TestResult tr8 = tcd.getTestResultFailed(SPEC2_10_CONTEXT_PORTLETCONTEXTSERVLETCONTEXT11);
      /* TODO: implement test */

      /* TestCase: SPEC2_10_Context_portletContextServletContext12            */
      /* Details: "The PortletContext getRealPath method provides the same    */
      /* functionality as the ServletContext getRealPath method"              */
      TestResult tr9 = tcd.getTestResultFailed(SPEC2_10_CONTEXT_PORTLETCONTEXTSERVLETCONTEXT12);
      /* TODO: implement test */

      /* TestCase: SPEC2_10_Context_portletContextServletContext13            */
      /* Details: "The PortletContext getResource method provides the same    */
      /* functionality as the ServletContext getResource method"              */
      TestResult tr10 = tcd.getTestResultFailed(SPEC2_10_CONTEXT_PORTLETCONTEXTSERVLETCONTEXT13);
      /* TODO: implement test */

      /* TestCase: SPEC2_10_Context_portletContextServletContext14            */
      /* Details: "The PortletContext getResourcePaths method provides the    */
      /* same functionality as the ServletContext getResourcePaths method"    */
      TestResult tr11 = tcd.getTestResultFailed(SPEC2_10_CONTEXT_PORTLETCONTEXTSERVLETCONTEXT14);
      /* TODO: implement test */

      /* TestCase: SPEC2_10_Context_portletContextServletContext15            */
      /* Details: "The PortletContext getResourceAsStream method provides     */
      /* the same functionality as the ServletContext getResourceAsStream     */
      /* method"                                                              */
      TestResult tr12 = tcd.getTestResultFailed(SPEC2_10_CONTEXT_PORTLETCONTEXTSERVLETCONTEXT15);
      /* TODO: implement test */

      /* TestCase: SPEC2_10_Context_portletContextServletContext16            */
      /* Details: "The PortletContext log method provides the same            */
      /* functionality as the ServletContext log method"                      */
      TestResult tr13 = tcd.getTestResultFailed(SPEC2_10_CONTEXT_PORTLETCONTEXTSERVLETCONTEXT16);
      /* TODO: implement test */

      /* TestCase: SPEC2_10_Context_portletContextServletContext17            */
      /* Details: "The PortletContext removeAttribute method provides the     */
      /* same functionality as the ServletContext removeAttribute method"     */
      TestResult tr14 = tcd.getTestResultFailed(SPEC2_10_CONTEXT_PORTLETCONTEXTSERVLETCONTEXT17);
      /* TODO: implement test */

      /* TestCase: SPEC2_10_Context_portletContextServletContext18            */
      /* Details: "The PortletContext setAttribute method provides the same   */
      /* functionality as the ServletContext setAttribute method"             */
      TestResult tr15 = tcd.getTestResultFailed(SPEC2_10_CONTEXT_PORTLETCONTEXTSERVLETCONTEXT18);
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

