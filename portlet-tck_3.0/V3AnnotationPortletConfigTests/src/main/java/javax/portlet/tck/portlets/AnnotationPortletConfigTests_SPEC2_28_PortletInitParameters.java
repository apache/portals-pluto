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
import javax.portlet.annotations.InitParameter;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.util.ModuleTestCaseDetails;

import static javax.portlet.tck.util.ModuleTestCaseDetails.V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_PORTLETINITPARAMETERS_DECLARINGINITPARAMS1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_PORTLETINITPARAMETERS_DECLARINGINITPARAMS3;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_PORTLETINITPARAMETERS_DECLARINGINITPARAMS4;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the 
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 *
 */

@PortletConfiguration(
   portletName = "AnnotationPortletConfigTests_SPEC2_28_PortletInitParameters",
   initParams = {
      @InitParameter(name = "test1", value = "true"),
      @InitParameter(name = "test2", value = ""),
      @InitParameter(name = "", value = "true"),
   }
)
public class AnnotationPortletConfigTests_SPEC2_28_PortletInitParameters implements Portlet {
   
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

      /* TestCase: V3AnnotationPortletConfigTests_SPEC2_28_PortletInitParameters_declaringInitParams1 */
      /* Details: "Portlet initialization parameters may be declared in the         */
      /* @PortletConfiguration annotation using @InitParameter annotation."         */
      {
         TestResult result = tcd.getTestResultFailed(V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_PORTLETINITPARAMETERS_DECLARINGINITPARAMS1);
         if(portletConfig.getInitParameter("test1")!=null
               && portletConfig.getInitParameter("test1").equals("true")){
           result.setTcSuccess(true);
         }
         result.writeTo(writer);
      }

      /* TestCase: V3AnnotationPortletConfigTests_SPEC2_28_PortletInitParameters_declaringInitParams3 */
      /* Details: "An initialization parameter with empty value can be 
       * declared in @InitParameter annotation."          */
      {
         TestResult result = tcd.getTestResultFailed(V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_PORTLETINITPARAMETERS_DECLARINGINITPARAMS3);
         if(portletConfig.getInitParameter("test2")!=null
               && portletConfig.getInitParameter("test2").equals("")){
            result.setTcSuccess(true);
         } else {
            result.appendTcDetail("Failed because test2 init parameter does not exist.");
         }
         result.writeTo(writer);
      }

      /* TestCase: V3AnnotationPortletConfigTests_SPEC2_28_PortletInitParameters_declaringInitParams4 */
      /* Details: "An initialization parameter with empty name
       * can be declared in @InitParameter annotation."          */
      {
         TestResult result = tcd.getTestResultFailed(V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_PORTLETINITPARAMETERS_DECLARINGINITPARAMS4);

         if(portletConfig.getInitParameter("")!=null
               && portletConfig.getInitParameter("").equals("true")){
            result.setTcSuccess(true);
         } else {
            result.appendTcDetail("Failed because init parameter with empty name doesn't exist");  
         }
         result.writeTo(writer);
      }

   }

}
