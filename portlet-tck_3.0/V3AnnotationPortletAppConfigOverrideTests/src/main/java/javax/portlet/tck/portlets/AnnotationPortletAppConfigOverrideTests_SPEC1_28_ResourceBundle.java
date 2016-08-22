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
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.annotations.PortletConfiguration;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.util.ModuleTestCaseDetails;

import static javax.portlet.tck.util.ModuleTestCaseDetails.V3ANNOTATIONPORTLETAPPCONFIGOVERRIDETESTS_SPEC1_28_RESOURCEBUNDLE_DECLARINGRESOURCEBUNDLE2;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the 
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 *
 */

@PortletConfiguration(
   resourceBundle = "javax.portlet.tck.portlets.resource-bundle1",
   portletName = "AnnotationPortletAppConfigOverrideTests_SPEC1_28_ResourceBundle",
   supportedLocales = {"en_US"}
)
public class AnnotationPortletAppConfigOverrideTests_SPEC1_28_ResourceBundle implements Portlet {
   
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

      /* TestCase: V3AnnotationPortletAppConfigOverrideTests_SPEC1_28_ResourceBundle_declaringResourceBundle2 */
      /* Details: "The resource bundle defined in the @PortletApplication           */
      /* annotation could be overridden by deployment descriptor portlet.xml"       */
      {
         TestResult result = tcd.getTestResultFailed(V3ANNOTATIONPORTLETAPPCONFIGOVERRIDETESTS_SPEC1_28_RESOURCEBUNDLE_DECLARINGRESOURCEBUNDLE2);
         try{
            Locale locale = portletReq.getLocale();
            ResourceBundle res = portletConfig.getResourceBundle(locale);
            if (res.containsKey("javax.portlet.title")
                  && res.getString("javax.portlet.title")
                .equals("AnnotationPortletAppConfigOverrideTests_SPEC1_28_ResourceBundle2")) {
               result.setTcSuccess(true);
            } else {
               result.appendTcDetail("Failed because javax.portlet.title is not found");
            }
         } catch (Exception e){
            result.appendTcDetail(e.toString());
         }
         result.writeTo(writer);
      }
   }

}
