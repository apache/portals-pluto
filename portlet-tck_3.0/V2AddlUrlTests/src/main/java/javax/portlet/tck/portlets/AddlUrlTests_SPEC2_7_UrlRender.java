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
public class AddlUrlTests_SPEC2_7_UrlRender implements Portlet {
   private static final String LOG_CLASS = 
         AddlUrlTests_SPEC2_7_UrlRender.class.getName();
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

      /* TestCase: SPEC2_7_UrlRender_renderURL0                               */
      /* Details: "When a render URL is triggered, the processAction method   */
      /* must not be invoked"                                                 */
      TestResult tr0 = tcd.getTestResultFailed(SPEC2_7_URLRENDER_RENDERURL0);
      /* TODO: implement test */

      /* TestCase: SPEC2_7_UrlRender_renderURL1                               */
      /* Details: "When a render URL is triggered, the render method must     */
      /* be invoked"                                                          */
      TestResult tr1 = tcd.getTestResultFailed(SPEC2_7_URLRENDER_RENDERURL1);
      /* TODO: implement test */

      /* TestCase: SPEC2_7_UrlRender_renderURL2                               */
      /* Details: "When render parameters are set on a render URL, those      */
      /* parameters must become render parameters of the request resulting    */
      /* from triggering the renderURL"                                       */
      TestResult tr2 = tcd.getTestResultFailed(SPEC2_7_URLRENDER_RENDERURL2);
      /* TODO: implement test */

      /* TestCase: SPEC2_7_UrlRender_renderURL3                               */
      /* Details: "When render parameters are set on a render URL, those      */
      /* parameters must become render parameters of the request resulting    */
      /* from triggering the renderURL"                                       */
      TestResult tr3 = tcd.getTestResultFailed(SPEC2_7_URLRENDER_RENDERURL3);
      /* TODO: implement test */

      /* TestCase: SPEC2_7_UrlRender_renderURL4                               */
      /* Details: "Private render parameters can be set on the render URL     */
      /* through the setParameter(String, String) method"                     */
      TestResult tr4 = tcd.getTestResultFailed(SPEC2_7_URLRENDER_RENDERURL4);
      /* TODO: implement test */

      /* TestCase: SPEC2_7_UrlRender_renderURL5                               */
      /* Details: "Private render parameters can be set on the render URL     */
      /* through the setParameter(String, String[]) method"                   */
      TestResult tr5 = tcd.getTestResultFailed(SPEC2_7_URLRENDER_RENDERURL5);
      /* TODO: implement test */

      /* TestCase: SPEC2_7_UrlRender_renderURL6                               */
      /* Details: "Private render parameters can be set on the render URL     */
      /* through the setParameterMap(Map<String, String[]>) method"           */
      TestResult tr6 = tcd.getTestResultFailed(SPEC2_7_URLRENDER_RENDERURL6);
      /* TODO: implement test */

      /* TestCase: SPEC2_7_UrlRender_renderURL7                               */
      /* Details: "Public render parameters can be set on the render URL      */
      /* through the setParameter(String, String) method"                     */
      TestResult tr7 = tcd.getTestResultFailed(SPEC2_7_URLRENDER_RENDERURL7);
      /* TODO: implement test */

      /* TestCase: SPEC2_7_UrlRender_renderURL8                               */
      /* Details: "Public render parameters can be set on the render URL      */
      /* through the setParameter(String, String[]) method"                   */
      TestResult tr8 = tcd.getTestResultFailed(SPEC2_7_URLRENDER_RENDERURL8);
      /* TODO: implement test */

      /* TestCase: SPEC2_7_UrlRender_renderURL9                               */
      /* Details: "Public render parameters can be set on the render URL      */
      /* through the setParameterMap(Map<String, String[]>) method"           */
      TestResult tr9 = tcd.getTestResultFailed(SPEC2_7_URLRENDER_RENDERURL9);
      /* TODO: implement test */

      /* TestCase: SPEC2_7_UrlRender_renderURL10                              */
      /* Details: "If a parameter with an existing name is set through one    */
      /* of the setParameter methods, the existing value is repalced with     */
      /* the new value"                                                       */
      TestResult tr10 = tcd.getTestResultFailed(SPEC2_7_URLRENDER_RENDERURL10);
      /* TODO: implement test */

      /* TestCase: SPEC2_7_UrlRender_renderURL11                              */
      /* Details: "When a render URL is created, render parameters from the   */
      /* current request are not automatically copied to the new render       */
      /* URL"                                                                 */
      TestResult tr11 = tcd.getTestResultFailed(SPEC2_7_URLRENDER_RENDERURL11);
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

