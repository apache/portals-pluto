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
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.MutableRenderParameters;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderParameters;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.annotations.ActionMethod;
import javax.portlet.annotations.EventDefinition;
import javax.portlet.annotations.EventMethod;
import javax.portlet.annotations.PortletApplication;
import javax.portlet.annotations.PortletConfiguration;
import javax.portlet.annotations.PortletQName;
import javax.portlet.tck.beans.TestButton;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.util.ModuleTestCaseDetails;
import javax.xml.namespace.QName;

import static javax.portlet.tck.util.ModuleTestCaseDetails.V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_EVENTDECLARATION_EVENTEVENTDECLARATION1;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the 
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 *
 */
@PortletApplication(
   defaultNamespaceURI = "http://www.apache.org/portals/pluto/portlet-tck_3.0",
   events = {
      @EventDefinition(
         qname = @PortletQName(
         localPart = "AnnotationPortletConfigTests_SPEC2_28_EventDeclaration_a", 
         namespaceURI = "http://www.apache.org/portals/pluto/portlet-tck_3.0"), 
      payloadType = java.lang.String.class
      ), @EventDefinition(
         qname = @PortletQName(
         localPart = "AnnotationPortletConfigTests_SPEC2_28_EventDeclaration_b", 
         namespaceURI = "http://www.apache.org/portals/pluto/portlet-tck_3.0"), 
      payloadType = java.lang.String.class
      )
   }
)
@PortletConfiguration(portletName = "AnnotationPortletConfigTests_SPEC2_28_EventDeclaration")
public class AnnotationPortletConfigTests_SPEC2_28_EventDeclaration implements Portlet {

   @Override
   public void init(PortletConfig config) throws PortletException {}

   @Override
   public void destroy() {}

   @ActionMethod(
      portletName = "AnnotationPortletConfigTests_SPEC2_28_EventDeclaration", 
      publishingEvents = {
         @PortletQName(
            localPart = "AnnotationPortletConfigTests_SPEC2_28_EventDeclaration_a", 
            namespaceURI = "http://www.apache.org/portals/pluto/portlet-tck_3.0"
         )
      }
   )
   public void processAction(ActionRequest portletReq, ActionResponse portletResp) throws PortletException, IOException {
      QName eventQName = new QName(
            "http://www.apache.org/portals/pluto/portlet-tck_3.0",
            "AnnotationPortletConfigTests_SPEC2_28_EventDeclaration_a");
      portletResp.setEvent(eventQName, "Hi!");
   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp) throws PortletException, IOException {

      PrintWriter writer = portletResp.getWriter();
      ModuleTestCaseDetails tcd = new ModuleTestCaseDetails();

      RenderParameters renderParams = portletReq.getRenderParameters();
      
      /* TestCase: V3AnnotationPortletConfigTests_SPEC2_28_EventDeclaration_eventEventDeclaration1 */
      /* Details: "An event can be fired from another event method configured with  */
      /* @EventMethod annotation - publishingEvents attribute."                     */
      if(renderParams.getValue("tr0")!=null && renderParams.getValue("tr0").equals("true")){
         TestResult result = tcd.getTestResultFailed(V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_EVENTDECLARATION_EVENTEVENTDECLARATION1);
         result.setTcSuccess(true);
         result.writeTo(writer);
      } else {
         ActionURL aurl = portletResp.createActionURL();
         TestButton tb = new TestButton(
               V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_EVENTDECLARATION_EVENTEVENTDECLARATION1,
               aurl);
         tb.writeTo(writer);
      }

   }
   
   @EventMethod(
      portletName = "AnnotationPortletConfigTests_SPEC2_28_EventDeclaration", 
      processingEvents = @PortletQName(
         localPart = "AnnotationPortletConfigTests_SPEC2_28_EventDeclaration_a", 
         namespaceURI = "http://www.apache.org/portals/pluto/portlet-tck_3.0"
      ),
      publishingEvents = {
         @PortletQName(
            localPart = "AnnotationPortletConfigTests_SPEC2_28_EventDeclaration_b", 
            namespaceURI = "http://www.apache.org/portals/pluto/portlet-tck_3.0"
         )
      }
   )
   public void processEvent_a(EventRequest portletReq, EventResponse portletResp)
            throws PortletException, IOException {
      
      QName eventQName = new QName(
            "http://www.apache.org/portals/pluto/portlet-tck_3.0",
            "AnnotationPortletConfigTests_SPEC2_28_EventDeclaration_b");
      portletResp.setEvent(eventQName, "Hi!");
   }
   
   @EventMethod(
      portletName = "AnnotationPortletConfigTests_SPEC2_28_EventDeclaration", 
      processingEvents = @PortletQName(
         localPart = "AnnotationPortletConfigTests_SPEC2_28_EventDeclaration_b", 
         namespaceURI = "http://www.apache.org/portals/pluto/portlet-tck_3.0"
      )
   )
   public void processEvent_b(EventRequest portletReq, EventResponse portletResp)
            throws PortletException, IOException {
       
      MutableRenderParameters mutableRenderParameters = portletResp.getRenderParameters();
      mutableRenderParameters.setValue("tr0", "true");
   }

}
