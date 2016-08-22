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
import java.util.Locale;
import java.util.ResourceBundle;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.annotations.PortletConfiguration;
import javax.portlet.annotations.Supports;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.util.ModuleTestCaseDetails;

import static javax.portlet.tck.util.ModuleTestCaseDetails.V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_PORTLETMODES_DECLARINGPORTLETMODES3;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_PORTLETMODES_DECLARINGPORTLETMODES4;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_PORTLETMODES_DECLARINGPORTLETMODES5;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_PORTLETMODES_DECLARINGPORTLETMODES6;


/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the 
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 *
 */

@PortletConfiguration(
   resourceBundle = "javax.portlet.tck.portlets.portlet-mode-resource",
   portletName = "AnnotationPortletApplicationConfigTests_SPEC1_28_PortletModes",
   supports={
      @Supports(portletModes={"view", "custom1", "custom2"})   
   }, 
   supportedLocales = {"en_US"}
)
public class AnnotationPortletApplicationConfigTests_SPEC1_28_PortletModes implements Portlet {

   PortletConfig portletConfig = null;
   
   @Override
   public void init(PortletConfig config) throws PortletException {
      this.portletConfig = config;
   }

   @Override
   public void destroy() {}

   @Override
   public void processAction(ActionRequest portletReq, ActionResponse portletResp) throws PortletException, IOException {}

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp) throws PortletException, IOException {

      PrintWriter writer = portletResp.getWriter();
      ModuleTestCaseDetails tcd = new ModuleTestCaseDetails();

      /* TestCase: V3AnnotationPortletApplicationConfigTests_SPEC1_28_PortletModes_declaringPortletModes3 */
      /* Details: "A custom portlet mode may be declared in the @PortletApplication */
      /* annotation."                                                               */
      {
         TestResult result = tcd.getTestResultFailed(V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_PORTLETMODES_DECLARINGPORTLETMODES3);
         if(portletReq.isPortletModeAllowed(new PortletMode("custom1"))){
            result.setTcSuccess(true);
         } else {
            result.appendTcDetail("Failed because custom1 portlet mode is not allowed");
         }
         result.writeTo(writer);
      }

      /* TestCase: V3AnnotationPortletApplicationConfigTests_SPEC1_28_PortletModes_declaringPortletModes4 */
      /* Details: "A custom portlet mode with portalManaged=false may be declared in */
      /* the @PortletApplication annotation."                                       */
      {
         TestResult result = tcd.getTestResultFailed(V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_PORTLETMODES_DECLARINGPORTLETMODES4);
         if(portletReq.isPortletModeAllowed(new PortletMode("custom1"))){
            result.setTcSuccess(true);
         } else {
            result.appendTcDetail("Failed because custom1 portlet mode is not allowed");
         }
         result.writeTo(writer);
      }

      /* TestCase: V3AnnotationPortletApplicationConfigTests_SPEC1_28_PortletModes_declaringPortletModes5 */
      /* Details: "The PortletRequest.isPortletModeAllowed method must return FALSE */
      /* for a custom portlet mode with portalManaged=true that is not supported by */
      /* the portlet container"                                                     */
      {
         TestResult result = tcd.getTestResultFailed(V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_PORTLETMODES_DECLARINGPORTLETMODES5);
         if(!portletReq.isPortletModeAllowed(new PortletMode("custom2"))){
            result.setTcSuccess(true);
         } else {
            result.appendTcDetail("Failed because custom2 portlet mode is allowed");
         }
         result.writeTo(writer);
      }

      /* TestCase: V3AnnotationPortletApplicationConfigTests_SPEC1_28_PortletModes_declaringPortletModes6 */
      /* Details: "A custom portlet mode can have a localized decoration name in    */
      /* the resource bundle with the name of                                       */
      /* javax.portlet.app.custom-portlet-mode.&lt;name&gt;.decoration-name"        */
      {
         TestResult result = tcd.getTestResultFailed(V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_PORTLETMODES_DECLARINGPORTLETMODES6);
         Locale locale = portletReq.getLocale();
         ResourceBundle res = portletConfig.getResourceBundle(locale);
         if (res.containsKey("javax.portlet.app.custom-portlet-mode.custom1.decoration-name")
               && res.getString("javax.portlet.app.custom-portlet-mode.custom1.decoration-name")
             .equals("decoration")) {
            result.setTcSuccess(true);
         } else {
            result.appendTcDetail("Failed because javax.portlet.app.custom-portlet-mode.custom1.decoration-name is not found");
         }
         result.writeTo(writer);
      }

   }

}
