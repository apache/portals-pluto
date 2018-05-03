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
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.annotations.PortletConfiguration;
import javax.portlet.annotations.SecurityRoleRef;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.util.ModuleTestCaseDetails;

import static javax.portlet.tck.util.ModuleTestCaseDetails.V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_SECURITYROLE_DECLARINGSECURITYROLE1;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the 
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 *
 */

public abstract class AnnotationPortletConfigTests_SPEC2_28_SecurityRoleBase {

   public void init(PortletConfig config) throws PortletException {}

   public void destroy() {}

   public void processAction(ActionRequest portletReq, ActionResponse portletResp) throws PortletException, IOException {}

   public abstract String getRoleName();

   public void render(RenderRequest portletReq, RenderResponse portletResp) throws PortletException, IOException {

      PrintWriter writer = portletResp.getWriter();
      ModuleTestCaseDetails tcd = new ModuleTestCaseDetails();

      /* TestCase: V3AnnotationPortletConfigTests_SPEC2_28_SecurityRole_declaringSecurityRole1 */
      /* Details: "Security roles options may be declared in the                    */
      /* @PortletConfiguration annotation using @SecurityRoleRef annotation."       */
      {
         TestResult result = tcd.getTestResultFailed(V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_SECURITYROLE_DECLARINGSECURITYROLE1);
         if(portletReq.isUserInRole(getRoleName())){
            result.setTcSuccess(true);
            result.appendTcDetail("User is in \"" + getRoleName() + "\" role.");
         } else {
            result.appendTcDetail("Failed because user is not configured to be in \"" + getRoleName() + "\" role.");
         }
         result.writeTo(writer);
      }

   }

}
