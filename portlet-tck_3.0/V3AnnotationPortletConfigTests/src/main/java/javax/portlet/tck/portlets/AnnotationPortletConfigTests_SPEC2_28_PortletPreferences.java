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
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.annotations.PortletConfiguration;
import javax.portlet.annotations.Preference;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.util.ModuleTestCaseDetails;

import static javax.portlet.tck.util.ModuleTestCaseDetails.V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_PORTLETPREFERENCES_DECLARINGPORTLETPREFERENCES1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_PORTLETPREFERENCES_DECLARINGPORTLETPREFERENCES2;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the 
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 *
 */

@PortletConfiguration(
   portletName = "AnnotationPortletConfigTests_SPEC2_28_PortletPreferences",
   prefs = {
      @Preference(name = "pref1", values = { "true" }),
      @Preference(name = "pref2", values = { "true" }, isReadOnly = true)
   }
)
public class AnnotationPortletConfigTests_SPEC2_28_PortletPreferences implements Portlet {

   @Override
   public void init(PortletConfig config) throws PortletException {}

   @Override
   public void destroy() {}

   @Override
   public void processAction(ActionRequest portletReq, ActionResponse portletResp) throws PortletException, IOException {}

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp) throws PortletException, IOException {

      PrintWriter writer = portletResp.getWriter();
      ModuleTestCaseDetails tcd = new ModuleTestCaseDetails();
      
      PortletPreferences prefs = portletReq.getPreferences();

      /* TestCase: V3AnnotationPortletConfigTests_SPEC2_28_PortletPreferences_declaringPortletPreferences1 */
      /* Details: "Portlet preferences can be declared using @Preference annotation */
      /* in @PortletConfiguration annotation."                                      */
      {
         TestResult result = tcd.getTestResultFailed(V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_PORTLETPREFERENCES_DECLARINGPORTLETPREFERENCES1);
         if(prefs.getValue("pref1", "false").equals("true")){
            result.setTcSuccess(true);
         } else {
            result.appendTcDetail("Failed because pref1 is not defined."); 
         }
         result.writeTo(writer);
      }

      /* TestCase: V3AnnotationPortletConfigTests_SPEC2_28_PortletPreferences_declaringPortletPreferences2 */
      /* Details: "Preference value can be set to read only by specifying           */
      /* \"isReadOnly\" attribute of @PortletAnnotation to be true."                */
      {
         TestResult result = tcd.getTestResultFailed(V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_PORTLETPREFERENCES_DECLARINGPORTLETPREFERENCES2);
         if(prefs.isReadOnly("pref2")){
            result.setTcSuccess(true);
         } else {
            result.appendTcDetail("Failed because pref2 is not read only."); 
         }
         result.writeTo(writer);
      }

   }

}
