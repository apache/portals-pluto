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
import javax.portlet.ActionURL;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderParameters;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.annotations.ActionMethod;
import javax.portlet.annotations.PortletQName;
import javax.portlet.tck.beans.TestButton;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.util.ModuleTestCaseDetails;
import javax.xml.namespace.QName;

import static javax.portlet.tck.util.ModuleTestCaseDetails.V3ANNOTATIONPORTLETAPPCONFIGOVERRIDETESTS_SPEC1_28_PUBLICRENDERPARAMETERS2_DECLARINGPRP3;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the 
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 *
 */

public class AnnotationPortletAppConfigOverrideTests_SPEC1_28_PublicRenderParameters2 implements Portlet {

   @Override
   public void init(PortletConfig config) throws PortletException {}

   @Override
   public void destroy() {}

   @ActionMethod(
      portletName = "AnnotationPortletAppConfigOverrideTests_SPEC1_28_PublicRenderParameters2", 
      publishingEvents = {
            @PortletQName(
            localPart = "AnnotationPortletAppConfigOverrideTests_SPEC1_28_PublicRenderParameters2", 
            namespaceURI = "http://www.apache.org/portals/pluto/portlet-tck_3.0"
         )
      }
   )
   public void processAction(ActionRequest portletReq, ActionResponse portletResp) throws PortletException, IOException {
      QName eventQNamea = new QName(
            "http://www.apache.org/portals/pluto/portlet-tck_3.0",
            "AnnotationPortletAppConfigOverrideTests_SPEC1_28_PublicRenderParameters2");
      portletResp.setEvent(eventQNamea, "Hi!");
   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp) throws PortletException, IOException {

      PrintWriter writer = portletResp.getWriter();
      ModuleTestCaseDetails tcd = new ModuleTestCaseDetails();
      
      RenderParameters renderParams = portletReq.getRenderParameters();

      /* TestCase: V3AnnotationPortletAppConfigOverrideTests_SPEC1_28_PublicRenderParameters2_declaringPRP3 */
      /* Details: "A public render parameters declared using @PortletApplication    */
      /* annotation in one portlet and deployment descriptor portlet.xml in another */
      /* portlet can be shared with each other."                                    */
      if(renderParams.isPublic("tr2_public") 
            && renderParams.getValue("tr2_public")!=null 
            && renderParams.getValue("tr2_public").equals("true")){
         TestResult result = tcd.getTestResultFailed(V3ANNOTATIONPORTLETAPPCONFIGOVERRIDETESTS_SPEC1_28_PUBLICRENDERPARAMETERS2_DECLARINGPRP3);
         result.setTcSuccess(true);
         result.writeTo(writer);
      } else {
         ActionURL aurl = portletResp.createActionURL();
         TestButton tb = new TestButton(
               V3ANNOTATIONPORTLETAPPCONFIGOVERRIDETESTS_SPEC1_28_PUBLICRENDERPARAMETERS2_DECLARINGPRP3,
               aurl);
         tb.writeTo(writer);
      }

   }

}
