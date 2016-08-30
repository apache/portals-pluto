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

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.annotations.PortletConfiguration;
import javax.portlet.annotations.LocaleString;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.util.ModuleTestCaseDetails;

import static javax.portlet.tck.util.ModuleTestCaseDetails.V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_PORTLETIDENTIFICATION_DECLARINGPORTLETNAME;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_PORTLETIDENTIFICATION_DECLARINGPORTLETDESCRIPTION;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_PORTLETIDENTIFICATION_DECLARINGPORTLETDISPLAYNAME;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_PORTLETIDENTIFICATION_DECLARINGPORTLETTITLE;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_PORTLETIDENTIFICATION_DECLARINGPORTLETSHORTTITLE;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_PORTLETIDENTIFICATION_DECLARINGPORTLETKEYWORDS;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the 
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 *
 */

@PortletConfiguration(
   portletName = "AnnotationPortletConfigTests_SPEC2_28_PortletIdentification",
   description = @LocaleString(value = "Test portlet description"),
   displayName = @LocaleString(value = "Test portlet display name"),
   title = @LocaleString(value = "test portlet title"),
   shortTitle = @LocaleString(value = "test portlet short title"),
   keywords = @LocaleString(value = "test, portlet, keywords")
)
public class AnnotationPortletConfigTests_SPEC2_28_PortletIdentification implements Portlet {
   
   private PortletConfig portletConfig = null;

   @Override
   public void init(PortletConfig config) throws PortletException {
      this.portletConfig = config;
   }

   @Override
   public void destroy() {
   }

   @Override
   public void processAction(ActionRequest portletReq, ActionResponse portletResp) throws PortletException, IOException {
   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp) throws PortletException, IOException {

      PrintWriter writer = portletResp.getWriter();
      ModuleTestCaseDetails tcd = new ModuleTestCaseDetails();

      /* TestCase: V3AnnotationPortletConfigTests_SPEC2_28_PortletIdentification_declaringPortletName */
      /* Details: "Portlet name may be set using \"portletName\" attribute of       */
      /* @PortletConfiguration annotation. "                                        */
      {
         TestResult result = tcd.getTestResultFailed(V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_PORTLETIDENTIFICATION_DECLARINGPORTLETNAME);
         if(portletConfig.getPortletName().equals("AnnotationPortletConfigTests_SPEC2_28_PortletIdentification")){
            result.setTcSuccess(true);
         } else {
            result.appendTcDetail("Failed because portlet name is not AnnotationPortletConfigTests_SPEC2_28_PortletIdentification but "+portletConfig.getPortletName());
         }
         result.writeTo(writer);
      }

      /* TestCase: V3AnnotationPortletConfigTests_SPEC2_28_PortletIdentification_declaringPortletDescription */
      /* Details: "Portlet description may be set using \"description\" attribute   */
      /* of @PortletConfiguration annotation."                                      */
      {
         TestResult result = tcd.getTestResultSucceeded(V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_PORTLETIDENTIFICATION_DECLARINGPORTLETDESCRIPTION);
         result.appendTcDetail("Cannot be tested");
         result.writeTo(writer);
      }

      /* TestCase: V3AnnotationPortletConfigTests_SPEC2_28_PortletIdentification_declaringPortletDisplayName */
      /* Details: "Portlet display name may be set using \"displayName\" attribute  */
      /* of @PortletConfiguration annotation."                                      */
      {
         TestResult result = tcd.getTestResultSucceeded(V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_PORTLETIDENTIFICATION_DECLARINGPORTLETDISPLAYNAME);
         result.appendTcDetail("Cannot be tested");
         result.writeTo(writer);
      }

      /* TestCase: V3AnnotationPortletConfigTests_SPEC2_28_PortletIdentification_declaringPortletTitle */
      /* Details: "Portlet title may be set using \"title\" attribute of            */
      /* @PortletConfiguration annotation."                                         */
      {
         TestResult result = tcd.getTestResultSucceeded(V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_PORTLETIDENTIFICATION_DECLARINGPORTLETTITLE);
         result.appendTcDetail("Cannot be tested");
         result.writeTo(writer);
      }

      /* TestCase: V3AnnotationPortletConfigTests_SPEC2_28_PortletIdentification_declaringPortletShortTitle */
      /* Details: "Portlet short title may be set using \"shortTitle\" attribute of */
      /* @PortletConfiguration annotation."                                         */
      {
         TestResult result = tcd.getTestResultSucceeded(V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_PORTLETIDENTIFICATION_DECLARINGPORTLETSHORTTITLE);
         result.appendTcDetail("Cannot be tested");
         result.writeTo(writer);
      }

      /* TestCase: V3AnnotationPortletConfigTests_SPEC2_28_PortletIdentification_declaringPortletKeywords */
      /* Details: "Portlet keywords may be set using \"keywords\" attribute of      */
      /* @PortletConfiguration annotation."                                         */
      {
         TestResult result = tcd.getTestResultSucceeded(V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_PORTLETIDENTIFICATION_DECLARINGPORTLETKEYWORDS);
         result.appendTcDetail("Cannot be tested");
         result.writeTo(writer);
      }

   }

}
