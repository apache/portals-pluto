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

import java.io.*;
import java.util.*;
import java.util.logging.*;
import static java.util.logging.Logger.*;
import javax.xml.namespace.QName;
import javax.portlet.*;
import javax.portlet.annotations.*;
import javax.portlet.filter.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.portlet.tck.beans.*;
import javax.portlet.tck.constants.*;
import javax.portlet.tck.util.ModuleTestCaseDetails;
import static javax.portlet.tck.util.ModuleTestCaseDetails.*;
import static javax.portlet.tck.constants.Constants.*;
import static javax.portlet.PortletSession.*;
import static javax.portlet.ResourceURL.*;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the 
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 *
 */

@PortletConfiguration(portletName = "AnnotationPortletConfigTests_SPEC2_28_PortletContainerRuntimeOptions")
public class AnnotationPortletConfigTests_SPEC2_28_PortletContainerRuntimeOptions implements Portlet {
   
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

      /* TestCase: V3AnnotationPortletConfigTests_SPEC2_28_PortletContainerRuntimeOptions_declaringPCRO1 */
      /* Details: "Portlet container runtime options may be declared in the         */
      /* @PortletConfiguration annotation using @RuntimeOption annotation."         */
      {
         TestResult result = tcd.getTestResultFailed(V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_PORTLETCONTAINERRUNTIMEOPTIONS_DECLARINGPCRO1);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3AnnotationPortletConfigTests_SPEC2_28_PortletContainerRuntimeOptions_declaringPCRO2 */
      /* Details: "Portlet container runtime options declared using                 */
      /* @PortletAnnotation are overridden by runtime options decalred using        */
      /* @PortletConfiguration annotation."                                         */
      {
         TestResult result = tcd.getTestResultFailed(V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_PORTLETCONTAINERRUNTIMEOPTIONS_DECLARINGPCRO2);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

   }

}
