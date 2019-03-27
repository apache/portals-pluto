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

import javax.inject.Inject;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.ActionURL;
import javax.portlet.ClientDataRequest;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.HeaderRequest;
import javax.portlet.HeaderResponse;
import javax.portlet.MutableRenderParameters;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.portlet.RenderParameters;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceURL;
import javax.portlet.annotations.ActionMethod;
import javax.portlet.annotations.EventMethod;
import javax.portlet.annotations.HeaderMethod;
import javax.portlet.annotations.PortletQName;
import javax.portlet.annotations.RenderMethod;
import javax.portlet.annotations.ServeResourceMethod;
import javax.portlet.tck.beans.TestButton;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.util.ModuleTestCaseDetails;
import javax.xml.namespace.QName;

import static javax.portlet.tck.util.ModuleTestCaseDetails.V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_REQUESTARTIFACTS_PORTLETREQUEST;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_REQUESTARTIFACTS_ACTIONREQUEST;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_REQUESTARTIFACTS_HEADERREQUEST;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_REQUESTARTIFACTS_RENDERREQUEST;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_REQUESTARTIFACTS_EVENTREQUEST;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_REQUESTARTIFACTS_RESOURCEREQUEST;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_REQUESTARTIFACTS_CLIENTDATAREQUEST;
import static javax.portlet.PortletSession.PORTLET_SCOPE;
import static javax.portlet.ResourceURL.PAGE;
import static javax.portlet.tck.portlets.Utils.ACTIONPHASE;
import static javax.portlet.tck.portlets.Utils.EVENTPHASE;
import static javax.portlet.tck.portlets.Utils.HEADERPHASE;
import static javax.portlet.tck.portlets.Utils.RENDERPHASE;
import static javax.portlet.tck.portlets.Utils.PORTLETREQUESTARTIFACTKEY;
import static javax.portlet.tck.portlets.Utils.ACTIONREQUESTARTIFACTKEY;
import static javax.portlet.tck.portlets.Utils.HEADERREQUESTARTIFACTKEY;
import static javax.portlet.tck.portlets.Utils.RENDERREQUESTARTIFACTKEY;
import static javax.portlet.tck.portlets.Utils.EVENTREQUESTARTIFACTKEY;
import static javax.portlet.tck.portlets.Utils.RESOURCEREQUESTARTIFACTKEY;
import static javax.portlet.tck.portlets.Utils.CLIENTDATAREQUESTARTIFACTKEY;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the 
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 *
 */

public class AnnotationPortletArtifactValidityTests_SPEC3_20_RequestArtifacts {
   
   private Utils                   utils = new Utils();

   @Inject
   private PortletRequestScopedArtifacts portletRequestScopedArtifacts;

   @Inject
   private PortletSession          portletSession;

   // Test artifacts
   @Inject
   private PortletRequest portletRequest;
   
   @Inject
   private ActionRequest actionRequest;

   @Inject
   private HeaderRequest headerRequest;
   
   @Inject
   private RenderRequest renderRequest;
   
   @Inject
   private EventRequest eventRequest;
   
   @Inject
   private ResourceRequest resourceRequest;
   
   @Inject
   private ClientDataRequest clientDataRequest;
   
   @HeaderMethod(
      portletNames = { "AnnotationPortletArtifactValidityTests_SPEC3_20_RequestArtifacts" }
   )
   public void renderHeaders(HeaderRequest portletReq,
           HeaderResponse portletResp) {
      
      try {
         setAttribute(PORTLETREQUESTARTIFACTKEY, HEADERPHASE,
               utils.checkEqualRequests(portletRequest, portletReq));
      } catch (RuntimeException e) {
         setAttribute(PORTLETREQUESTARTIFACTKEY, HEADERPHASE, false);
      }
      
      try {
         setAttribute(ACTIONREQUESTARTIFACTKEY, HEADERPHASE,
               utils.isValid(actionRequest.getContextPath()));
      } catch (RuntimeException e) {
         setAttribute(ACTIONREQUESTARTIFACTKEY, HEADERPHASE, false);
      }
      
      try {
         setAttribute(RENDERREQUESTARTIFACTKEY, HEADERPHASE,
               utils.isValid(renderRequest.getContextPath()));
      } catch (RuntimeException e) {
         setAttribute(RENDERREQUESTARTIFACTKEY, HEADERPHASE, false);
      }
      
      try {
         setAttribute(EVENTREQUESTARTIFACTKEY, HEADERPHASE,
               utils.isValid(eventRequest.getContextPath()));
      } catch (RuntimeException e) {
         setAttribute(EVENTREQUESTARTIFACTKEY, HEADERPHASE, false);
      }
      
      try {
         setAttribute(HEADERREQUESTARTIFACTKEY, HEADERPHASE,
               utils.checkEqualRequests(headerRequest, portletReq));
      } catch (RuntimeException e) {
         setAttribute(HEADERREQUESTARTIFACTKEY, HEADERPHASE, false);
      }
      
      try {
         setAttribute(RESOURCEREQUESTARTIFACTKEY, HEADERPHASE,
               utils.isValid(resourceRequest.getContextPath()));
      } catch (RuntimeException e) {
         setAttribute(RESOURCEREQUESTARTIFACTKEY, HEADERPHASE, false);
      }
      
      try {
         setAttribute(CLIENTDATAREQUESTARTIFACTKEY, HEADERPHASE,
               utils.isValid(clientDataRequest.getContextPath()));
      } catch (RuntimeException e) {
         setAttribute(CLIENTDATAREQUESTARTIFACTKEY, HEADERPHASE, false);
      }
      
   }
   
   @ActionMethod(
      portletName = "AnnotationPortletArtifactValidityTests_SPEC3_20_RequestArtifacts", 
      publishingEvents = @PortletQName(
         localPart = "AnnotationPortletArtifactValidityTests_SPEC3_20_RequestArtifacts", 
         namespaceURI = "http://www.apache.org/portals/pluto/portlet-tck_3.0"
      )
   )
   public void processAction(ActionRequest portletReq,
         ActionResponse portletResp) throws PortletException, IOException {
           
      try {
         setAttribute(PORTLETREQUESTARTIFACTKEY, ACTIONPHASE,
               utils.checkEqualRequests(portletRequest, portletReq));
      } catch (RuntimeException e) {
         setAttribute(PORTLETREQUESTARTIFACTKEY, ACTIONPHASE, false);
      }
      
      try {
         setAttribute(ACTIONREQUESTARTIFACTKEY, ACTIONPHASE,
               utils.checkEqualRequests(actionRequest, portletReq));
      } catch (RuntimeException e) {
         setAttribute(ACTIONREQUESTARTIFACTKEY, ACTIONPHASE, false);
      }
      
      try {
         setAttribute(RENDERREQUESTARTIFACTKEY, ACTIONPHASE,
               utils.isValid(renderRequest.getContextPath()));
      } catch (RuntimeException e) {
         setAttribute(RENDERREQUESTARTIFACTKEY, ACTIONPHASE, false);
      }
      
      try {
         setAttribute(EVENTREQUESTARTIFACTKEY, ACTIONPHASE,
               utils.isValid(eventRequest.getContextPath()));
      } catch (RuntimeException e) {
         setAttribute(EVENTREQUESTARTIFACTKEY, ACTIONPHASE, false);
      }
      
      try {
         setAttribute(HEADERREQUESTARTIFACTKEY, ACTIONPHASE,
               utils.isValid(headerRequest.getContextPath()));
      } catch (RuntimeException e) {
         setAttribute(HEADERREQUESTARTIFACTKEY, ACTIONPHASE, false);
      }
      
      try {
         setAttribute(RESOURCEREQUESTARTIFACTKEY, ACTIONPHASE,
               utils.isValid(resourceRequest.getContextPath()));
      } catch (RuntimeException e) {
         setAttribute(RESOURCEREQUESTARTIFACTKEY, ACTIONPHASE, false);
      }
      
      try {
         setAttribute(CLIENTDATAREQUESTARTIFACTKEY, ACTIONPHASE,
               utils.checkEqualRequests(clientDataRequest, portletReq));
      } catch (RuntimeException e) {
         setAttribute(CLIENTDATAREQUESTARTIFACTKEY, ACTIONPHASE, false);
      }
      
      QName eventQName = new QName(
            "http://www.apache.org/portals/pluto/portlet-tck_3.0",
            "AnnotationPortletArtifactValidityTests_SPEC3_20_RequestArtifacts");
      portletResp.setEvent(eventQName, "Hi!");
      
   }
   
   @RenderMethod(
      portletNames = { "AnnotationPortletArtifactValidityTests_SPEC3_20_RequestArtifacts" }
   )
   public void render(RenderRequest portletReq, RenderResponse portletResp)
           throws PortletException, IOException {

      PrintWriter writer = portletResp.getWriter();

      try {
         setAttribute(PORTLETREQUESTARTIFACTKEY, RENDERPHASE,
               utils.checkEqualRequests(portletRequest, portletReq));
      } catch (RuntimeException e) {
         setAttribute(PORTLETREQUESTARTIFACTKEY, RENDERPHASE, false);
      }
      
      try {
         setAttribute(ACTIONREQUESTARTIFACTKEY, RENDERPHASE,
               utils.isValid(actionRequest.getContextPath()));
      } catch (RuntimeException e) {
         setAttribute(ACTIONREQUESTARTIFACTKEY, RENDERPHASE, false);
      }
      
      try {
         setAttribute(RENDERREQUESTARTIFACTKEY, RENDERPHASE,
               utils.checkEqualRequests(renderRequest, portletReq));
      } catch (RuntimeException e) {
         setAttribute(RENDERREQUESTARTIFACTKEY, RENDERPHASE, false);
      }
      
      try {
         setAttribute(EVENTREQUESTARTIFACTKEY, RENDERPHASE,
               utils.isValid(eventRequest.getContextPath()));
      } catch (RuntimeException e) {
         setAttribute(EVENTREQUESTARTIFACTKEY, RENDERPHASE, false);
      }
      
      try {
         setAttribute(HEADERREQUESTARTIFACTKEY, RENDERPHASE,
               utils.isValid(headerRequest.getContextPath()));
      } catch (RuntimeException e) {
         setAttribute(HEADERREQUESTARTIFACTKEY, RENDERPHASE, false);
      }
      
      try {
         setAttribute(RESOURCEREQUESTARTIFACTKEY, RENDERPHASE,
               utils.isValid(resourceRequest.getContextPath()));
      } catch (RuntimeException e) {
         setAttribute(RESOURCEREQUESTARTIFACTKEY, RENDERPHASE, false);
      }
      
      try {
         setAttribute(CLIENTDATAREQUESTARTIFACTKEY, RENDERPHASE,
               utils.isValid(clientDataRequest.getContextPath()));
      } catch (RuntimeException e) {
         setAttribute(CLIENTDATAREQUESTARTIFACTKEY, RENDERPHASE, false);
      }
      
      writer.write(
            "<div id=\"AnnotationPortletArtifactValidityTests_SPEC3_20_RequestArtifacts\">no resource output.</div>\n");
      ResourceURL resurl = portletResp.createResourceURL();
      resurl.setCacheability(PAGE);
      writer.write("<script>\n");
      writer.write("(function () {\n");
      writer.write("   var xhr = new XMLHttpRequest();\n");
      writer.write("   xhr.onreadystatechange=function() {\n");
      writer.write("      if (xhr.readyState==4 && xhr.status==200) {\n");
      writer.write(
            "         document.getElementById(\"AnnotationPortletArtifactValidityTests_SPEC3_20_RequestArtifacts\").innerHTML=xhr.responseText;\n");
      writer.write("      }\n");
      writer.write("   };\n");
      writer.write(
            "   xhr.open(\"GET\",\"" + resurl.toString() + "\",true);\n");
      writer.write("   xhr.send();\n");
      writer.write("})();\n");
      writer.write("</script>\n");

   }
   
   @ServeResourceMethod(
      portletNames = { "AnnotationPortletArtifactValidityTests_SPEC3_20_RequestArtifacts" }
   )
   public void serveResource(ResourceRequest portletReq,
           ResourceResponse portletResp) throws PortletException, IOException {
      
      PrintWriter writer = portletResp.getWriter();
      ModuleTestCaseDetails tcd = new ModuleTestCaseDetails();
      RenderParameters renderParameters = portletReq.getRenderParameters();
      
      /* TestCase: V3AnnotationPortletArtifactValidityTests_SPEC3_20_RequestArtifacts_portletRequest */
      /* Details: "PortletRequest artifact is valid during all phases."             */
      if (renderParameters.getValue("tr0") != null
            && renderParameters.getValue("tr0").equals("true")) {
         TestResult result = tcd.getTestResultFailed(
               V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_REQUESTARTIFACTS_PORTLETREQUEST);
         ArtifactValidationResult validationResult = getValidationTestResult(
               PORTLETREQUESTARTIFACTKEY);
         try {
            validationResult.setArtifactValidInResourcePhase(
                  utils.checkEqualRequests(portletRequest, portletReq));
         } catch (RuntimeException e) {
            validationResult.setArtifactValidInResourcePhase(false);
         }
         result.setTcSuccess(
               validationResult.isArtifactValidInAllPhase());
         result.appendTcDetail(utils.createTestDebug(validationResult));
         result.writeTo(writer);
      } else {
         ActionURL aurl = portletResp.createActionURL();
         TestButton tb = new TestButton(
               V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_REQUESTARTIFACTS_PORTLETREQUEST,
               aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V3AnnotationPortletArtifactValidityTests_SPEC3_20_RequestArtifacts_actionRequest */
      /* Details: "ActionRequest artifact is only valid during action phase."       */
      if (renderParameters.getValue("tr1") != null
            && renderParameters.getValue("tr1").equals("true")) {
         TestResult result = tcd.getTestResultFailed(
               V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_REQUESTARTIFACTS_ACTIONREQUEST);
         ArtifactValidationResult validationResult = getValidationTestResult(
               ACTIONREQUESTARTIFACTKEY);
         try {
            validationResult.setArtifactValidInResourcePhase(
                  utils.isValid(actionRequest.getContextPath()));
         } catch (RuntimeException e) {
            validationResult.setArtifactValidInResourcePhase(false);
         }
         result.setTcSuccess(
               validationResult.isArtifactValidInOnlyActionPhase());
         result.appendTcDetail(utils.createTestDebug(validationResult));
         result.writeTo(writer);
      } else {
         ActionURL aurl = portletResp.createActionURL();
         TestButton tb = new TestButton(
               V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_REQUESTARTIFACTS_ACTIONREQUEST,
               aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V3AnnotationPortletArtifactValidityTests_SPEC3_20_RequestArtifacts_headerRequest */
      /* Details: "HeaderRequest artifact is only valid during header phase."       */
      if (renderParameters.getValue("tr4") != null
            && renderParameters.getValue("tr4").equals("true")) {
         TestResult result = tcd.getTestResultFailed(
               V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_REQUESTARTIFACTS_HEADERREQUEST);
         ArtifactValidationResult validationResult = getValidationTestResult(
               HEADERREQUESTARTIFACTKEY);
         try {
            validationResult.setArtifactValidInResourcePhase(
                  utils.isValid(headerRequest.getContextPath()));
         } catch (RuntimeException e) {
            validationResult.setArtifactValidInResourcePhase(false);
         }
         result.setTcSuccess(
               validationResult.isArtifactValidInOnlyHeaderPhase());
         result.appendTcDetail(utils.createTestDebug(validationResult));
         result.writeTo(writer);
      } else {
         ActionURL aurl = portletResp.createActionURL();
         TestButton tb = new TestButton(
               V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_REQUESTARTIFACTS_HEADERREQUEST,
               aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V3AnnotationPortletArtifactValidityTests_SPEC3_20_RequestArtifacts_renderRequest */
      /* Details: "RenderRequest artifact is only valid during render phase."       */
      if (renderParameters.getValue("tr2") != null
            && renderParameters.getValue("tr2").equals("true")) {
         TestResult result = tcd.getTestResultFailed(
               V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_REQUESTARTIFACTS_RENDERREQUEST);
         ArtifactValidationResult validationResult = getValidationTestResult(
               RENDERREQUESTARTIFACTKEY);
         try {
            validationResult.setArtifactValidInResourcePhase(
                  utils.isValid(renderRequest.getContextPath()));
         } catch (RuntimeException e) {
            validationResult.setArtifactValidInResourcePhase(false);
         }
         result.setTcSuccess(
               validationResult.isArtifactValidInOnlyRenderPhase());
         result.appendTcDetail(utils.createTestDebug(validationResult));
         result.writeTo(writer);
      } else {
         ActionURL aurl = portletResp.createActionURL();
         TestButton tb = new TestButton(
               V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_REQUESTARTIFACTS_RENDERREQUEST,
               aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V3AnnotationPortletArtifactValidityTests_SPEC3_20_RequestArtifacts_eventRequest */
      /* Details: "EventRequest artifact is only valid during event phase."         */
      if (renderParameters.getValue("tr3") != null
            && renderParameters.getValue("tr3").equals("true")) {
         TestResult result = tcd.getTestResultFailed(
               V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_REQUESTARTIFACTS_EVENTREQUEST);
         ArtifactValidationResult validationResult = getValidationTestResult(
               EVENTREQUESTARTIFACTKEY);
         try {
            validationResult.setArtifactValidInResourcePhase(
                  utils.isValid(eventRequest.getContextPath()));
         } catch (RuntimeException e) {
            validationResult.setArtifactValidInResourcePhase(false);
         }
         result.setTcSuccess(
               validationResult.isArtifactValidInOnlyEventPhase());
         result.appendTcDetail(utils.createTestDebug(validationResult));
         result.writeTo(writer);
      } else {
         ActionURL aurl = portletResp.createActionURL();
         TestButton tb = new TestButton(
               V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_REQUESTARTIFACTS_EVENTREQUEST,
               aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V3AnnotationPortletArtifactValidityTests_SPEC3_20_RequestArtifacts_resourceRequest */
      /* Details: "ResourceRequest artifact is only valid during resource phase."   */
      if (renderParameters.getValue("tr5") != null
            && renderParameters.getValue("tr5").equals("true")) {
         TestResult result = tcd.getTestResultFailed(
               V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_REQUESTARTIFACTS_RESOURCEREQUEST);
         ArtifactValidationResult validationResult = getValidationTestResult(
               RESOURCEREQUESTARTIFACTKEY);
         try {
            validationResult.setArtifactValidInResourcePhase(
                  utils.checkEqualRequests(resourceRequest, portletReq));
         } catch (RuntimeException e) {
            validationResult.setArtifactValidInResourcePhase(false);
         }
         result.setTcSuccess(
               validationResult.isArtifactValidInOnlyResourcePhase());
         result.appendTcDetail(utils.createTestDebug(validationResult));
         result.writeTo(writer);
      } else {
         ActionURL aurl = portletResp.createActionURL();
         TestButton tb = new TestButton(
               V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_REQUESTARTIFACTS_RESOURCEREQUEST,
               aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V3AnnotationPortletArtifactValidityTests_SPEC3_20_RequestArtifacts_clientDataRequest */
      /* Details: "ClientDataRequest artifact is only valid during action and       */
      /* resource phase."                                                           */
      if (renderParameters.getValue("tr6") != null
            && renderParameters.getValue("tr6").equals("true")) {
         TestResult result = tcd.getTestResultFailed(
               V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_REQUESTARTIFACTS_CLIENTDATAREQUEST);
         ArtifactValidationResult validationResult = getValidationTestResult(
               CLIENTDATAREQUESTARTIFACTKEY);
         try {
            validationResult.setArtifactValidInResourcePhase(
                  utils.checkEqualRequests(clientDataRequest, portletReq));
         } catch (RuntimeException e) {
            validationResult.setArtifactValidInResourcePhase(false);
         }
         if (validationResult.isArtifactValidInActionPhase()
               && !validationResult.isArtifactValidInEventPhase()
               && !validationResult.isArtifactValidInHeaderPhase()
               && !validationResult.isArtifactValidInRenderPhase()
               && validationResult.isArtifactValidInResourcePhase()) {
            result.setTcSuccess(true);
         }
         result.appendTcDetail(utils.createTestDebug(validationResult));
         result.writeTo(writer);
      } else {
         ActionURL aurl = portletResp.createActionURL();
         TestButton tb = new TestButton(
               V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_REQUESTARTIFACTS_CLIENTDATAREQUEST,
               aurl);
         tb.writeTo(writer);
      }
      
   }
   
   @EventMethod(
      portletName = "AnnotationPortletArtifactValidityTests_SPEC3_20_RequestArtifacts", 
      processingEvents = @PortletQName(
         localPart = "AnnotationPortletArtifactValidityTests_SPEC3_20_RequestArtifacts", 
         namespaceURI = "http://www.apache.org/portals/pluto/portlet-tck_3.0"
      )
   )
   public void processEvent(EventRequest portletReq, EventResponse portletResp)
            throws PortletException, IOException {
      
      MutableRenderParameters renderParameters = portletResp.getRenderParameters();
      
      try {
         setAttribute(PORTLETREQUESTARTIFACTKEY, EVENTPHASE,
               utils.checkEqualRequests(portletRequest, portletReq));
      } catch (RuntimeException e) {
         setAttribute(PORTLETREQUESTARTIFACTKEY, EVENTPHASE, false);
      }
      renderParameters.setValue("tr0", "true");
      
      try {
         setAttribute(ACTIONREQUESTARTIFACTKEY, EVENTPHASE,
               utils.isValid(actionRequest.getContextPath()));
      } catch (RuntimeException e) {
         setAttribute(ACTIONREQUESTARTIFACTKEY, EVENTPHASE, false);
      }
      renderParameters.setValue("tr1", "true");
      
      try {
         setAttribute(RENDERREQUESTARTIFACTKEY, EVENTPHASE,
               utils.isValid(renderRequest.getContextPath()));
      } catch (RuntimeException e) {
         setAttribute(RENDERREQUESTARTIFACTKEY, EVENTPHASE, false);
      }
      renderParameters.setValue("tr2", "true");
      
      try {
         setAttribute(EVENTREQUESTARTIFACTKEY, EVENTPHASE,
               utils.checkEqualRequests(eventRequest, portletReq));
      } catch (RuntimeException e) {
         setAttribute(EVENTREQUESTARTIFACTKEY, EVENTPHASE, false);
      }
      renderParameters.setValue("tr3", "true");
      
      try {
         setAttribute(HEADERREQUESTARTIFACTKEY, EVENTPHASE,
               utils.isValid(headerRequest.getContextPath()));
      } catch (RuntimeException e) {
         setAttribute(HEADERREQUESTARTIFACTKEY, EVENTPHASE, false);
      }
      renderParameters.setValue("tr4", "true");
      
      try {
         setAttribute(RESOURCEREQUESTARTIFACTKEY, EVENTPHASE,
               utils.isValid(resourceRequest.getContextPath()));
      } catch (RuntimeException e) {
         setAttribute(RESOURCEREQUESTARTIFACTKEY, EVENTPHASE, false);
      }
      renderParameters.setValue("tr5", "true");
      
      try {
         setAttribute(CLIENTDATAREQUESTARTIFACTKEY, EVENTPHASE,
               utils.isValid(clientDataRequest.getContextPath()));
      } catch (RuntimeException e) {
         setAttribute(CLIENTDATAREQUESTARTIFACTKEY, EVENTPHASE, false);
      }
      renderParameters.setValue("tr6", "true");
      
   }
   
   public void setAttribute(String artifactKey, String phase,
         boolean validity) {

      String portletName = portletRequestScopedArtifacts.getPortletName();
      portletSession.setAttribute(portletName + artifactKey + phase, validity,
            PORTLET_SCOPE);

   }

   private ArtifactValidationResult getValidationTestResult(
         String artifactKey) {
      String portletName = portletRequestScopedArtifacts.getPortletName();
      boolean artifactInActionPhase = (boolean) portletSession.getAttribute(
            portletName + artifactKey + ACTIONPHASE, PORTLET_SCOPE);
      boolean artifactInRenderPhase = (boolean) portletSession.getAttribute(
            portletName + artifactKey + RENDERPHASE, PORTLET_SCOPE);
      boolean artifactInHeaderPhase = (boolean) portletSession.getAttribute(
            portletName + artifactKey + HEADERPHASE, PORTLET_SCOPE);
      boolean artifactInEventPhase = (boolean) portletSession.getAttribute(
            portletName + artifactKey + EVENTPHASE, PORTLET_SCOPE);
      return new ArtifactValidationResult(artifactInHeaderPhase,
            artifactInRenderPhase, artifactInActionPhase, artifactInEventPhase);
   }

}
