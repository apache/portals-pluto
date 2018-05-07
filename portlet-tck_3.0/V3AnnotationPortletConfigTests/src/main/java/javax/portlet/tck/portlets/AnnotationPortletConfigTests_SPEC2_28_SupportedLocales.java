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
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.annotations.PortletConfiguration;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.util.ModuleTestCaseDetails;

import static javax.portlet.tck.util.ModuleTestCaseDetails.V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_SUPPORTEDLOCALES_DECLARINGSUPPORTEDLOCALES1;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the 
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 *
 */

@PortletConfiguration(
   portletName = "AnnotationPortletConfigTests_SPEC2_28_SupportedLocales",
   supportedLocales = {"en_US", "de"}
)
public class AnnotationPortletConfigTests_SPEC2_28_SupportedLocales implements Portlet {
   
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

      /* TestCase: V3AnnotationPortletConfigTests_SPEC2_28_SupportedLocales_declaringSupportedLocales1 */
      /* Details: "Support for locales can be defined using \"supportedLocales\"    */
      /* attribute of @PortletConfiguration annotation."                            */
      {
         TestResult result = tcd.getTestResultFailed(V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_SUPPORTEDLOCALES_DECLARINGSUPPORTEDLOCALES1);
         Enumeration<Locale> supportedLocales = portletConfig.getSupportedLocales();
         List<Locale> supportedLocalesList = Collections.list(supportedLocales);
         if(supportedLocalesList.size()==2
               && supportedLocalesList.get(0).equals(Locale.US)
               && supportedLocalesList.get(1).equals(Locale.GERMAN)) {
            result.setTcSuccess(true);
         } else {
            result.appendTcDetail("Failed because more than 2 supported locales are found - "+supportedLocalesList.size()
            +" or supported locales are not de and en_US");
         }
         result.writeTo(writer);
      }

   }

}
