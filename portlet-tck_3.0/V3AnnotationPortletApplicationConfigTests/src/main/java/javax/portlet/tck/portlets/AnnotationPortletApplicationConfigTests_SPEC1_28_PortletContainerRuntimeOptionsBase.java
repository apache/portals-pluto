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
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.util.ModuleTestCaseDetails;

import static javax.portlet.tck.util.ModuleTestCaseDetails.V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_PORTLETCONTAINERRUNTIMEOPTIONS_DECLARINGPCRO1;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the 
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 *
 */

public abstract class AnnotationPortletApplicationConfigTests_SPEC1_28_PortletContainerRuntimeOptionsBase {

   private PortletConfig portletConfig = null;
   
   public void init(PortletConfig config) throws PortletException {
      this.portletConfig = config;
   }

   public void destroy() {}

   public void processAction(ActionRequest portletReq, ActionResponse portletResp) throws PortletException, IOException {}

   public void render(RenderRequest portletReq, RenderResponse portletResp) throws PortletException, IOException {

      PrintWriter writer = portletResp.getWriter();
      ModuleTestCaseDetails tcd = new ModuleTestCaseDetails();

      /* TestCase: V3AnnotationPortletApplicationConfigTests_SPEC1_28_PortletContainerRuntimeOptions_declaringPCRO1 */
      /* Details: "Portlet container runtime options may be declared in the         */
      /* @PortletApplication annotation using @RuntimeOption annotation."           */
      {
         TestResult result = tcd.getTestResultFailed(V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_PORTLETCONTAINERRUNTIMEOPTIONS_DECLARINGPCRO1);
         Map<String, String[]> runtimeOptions = portletConfig.getContainerRuntimeOptions();
         if (isRuntimeOptionsCorrect(runtimeOptions)) {
            result.setTcSuccess(true);
         }
         result.writeTo(writer);
      }

   }

   public abstract boolean isRuntimeOptionsCorrect(Map<String, String[]> runtimeOptions);
}
