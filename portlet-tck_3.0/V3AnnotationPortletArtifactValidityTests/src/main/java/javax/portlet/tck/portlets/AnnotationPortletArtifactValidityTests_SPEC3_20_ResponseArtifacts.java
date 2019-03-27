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

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.ActionURL;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.HeaderRequest;
import javax.portlet.HeaderResponse;
import javax.portlet.MimeResponse;
import javax.portlet.MutableRenderParameters;
import javax.portlet.PortletException;
import javax.portlet.PortletResponse;
import javax.portlet.PortletSession;
import javax.portlet.RenderParameters;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceURL;
import javax.portlet.StateAwareResponse;
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

import static javax.portlet.tck.util.ModuleTestCaseDetails.V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_RESPONSEARTIFACTS_PORTLETRESPONSE;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_RESPONSEARTIFACTS_ACTIONRESPONSE;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_RESPONSEARTIFACTS_HEADERRESPONSE;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_RESPONSEARTIFACTS_RENDERRESPONSE;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_RESPONSEARTIFACTS_EVENTRESPONSE;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_RESPONSEARTIFACTS_RESOURCERESPONSE;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_RESPONSEARTIFACTS_STATEAWAREREPONSE;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_RESPONSEARTIFACTS_MIMERESPONSE;
import static javax.portlet.PortletSession.PORTLET_SCOPE;
import static javax.portlet.ResourceURL.PAGE;
import static javax.portlet.tck.portlets.Utils.ACTIONPHASE;
import static javax.portlet.tck.portlets.Utils.EVENTPHASE;
import static javax.portlet.tck.portlets.Utils.HEADERPHASE;
import static javax.portlet.tck.portlets.Utils.RENDERPHASE;
import static javax.portlet.tck.portlets.Utils.PORTLETRESPONSEARTIFACTKEY;
import static javax.portlet.tck.portlets.Utils.ACTIONRESPONSEARTIFACTKEY;
import static javax.portlet.tck.portlets.Utils.HEADERRESPONSEARTIFACTKEY;
import static javax.portlet.tck.portlets.Utils.RENDERRESPONSEARTIFACTKEY;
import static javax.portlet.tck.portlets.Utils.EVENTRESPONSEARTIFACTKEY;
import static javax.portlet.tck.portlets.Utils.RESOURCERESPONSEARTIFACTKEY;
import static javax.portlet.tck.portlets.Utils.MIMERESPONSEARTIFACTKEY;
import static javax.portlet.tck.portlets.Utils.STATEAWARERESPONSEARTIFACTKEY;;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the 
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 *
 */

@RequestScoped
public class AnnotationPortletArtifactValidityTests_SPEC3_20_ResponseArtifacts {
   
   private Utils                   utils = new Utils();

   @Inject
   private PortletRequestScopedArtifacts portletRequestScopedArtifacts;
   
   @Inject
   private PortletSession          portletSession;

   // Test artifacts
   @Inject
   private PortletResponse portletResponse;
   
   @Inject
   private ActionResponse actionResponse;
   
   @Inject
   private HeaderResponse headerResponse;
   
   @Inject
   private RenderResponse renderResponse;
   
   @Inject
   private EventResponse eventResponse;
   
   @Inject
   private ResourceResponse resourceResponse;
   
   @Inject
   private MimeResponse mimeResponse;
   
   @Inject
   private StateAwareResponse stateAwareResponse;

   @HeaderMethod(
      portletNames = { "AnnotationPortletArtifactValidityTests_SPEC3_20_ResponseArtifacts" }
   )
   public void renderHeaders(HeaderRequest portletReq,
           HeaderResponse portletResp) {
      
      try {
         setAttribute(PORTLETRESPONSEARTIFACTKEY, HEADERPHASE,
               utils.checkEqualResponses(portletResponse, portletResp));
      } catch (RuntimeException e) {
         setAttribute(PORTLETRESPONSEARTIFACTKEY, HEADERPHASE, false);
      }
      
      try {
         setAttribute(ACTIONRESPONSEARTIFACTKEY, HEADERPHASE,
               utils.isValid(actionResponse.getNamespace()));
      } catch (RuntimeException e) {
         setAttribute(ACTIONRESPONSEARTIFACTKEY, HEADERPHASE, false);
      }
      
      try {
         setAttribute(RENDERRESPONSEARTIFACTKEY, HEADERPHASE,
               utils.isValid(renderResponse.getNamespace()));
      } catch (RuntimeException e) {
         setAttribute(RENDERRESPONSEARTIFACTKEY, HEADERPHASE, false);
      }
      
      try {
         setAttribute(EVENTRESPONSEARTIFACTKEY, HEADERPHASE,
               utils.isValid(eventResponse.getNamespace()));
      } catch (RuntimeException e) {
         setAttribute(EVENTRESPONSEARTIFACTKEY, HEADERPHASE, false);
      }
      
      try {
         setAttribute(HEADERRESPONSEARTIFACTKEY, HEADERPHASE,
               utils.checkEqualMimeResponse(headerResponse, portletResp));
      } catch (RuntimeException e) {
         setAttribute(HEADERRESPONSEARTIFACTKEY, HEADERPHASE, false);
      }
      
      try {
         setAttribute(RESOURCERESPONSEARTIFACTKEY, HEADERPHASE,
               utils.isValid(resourceResponse.getNamespace()));
      } catch (RuntimeException e) {
         setAttribute(RESOURCERESPONSEARTIFACTKEY, HEADERPHASE, false);
      }
      
      try {
         setAttribute(MIMERESPONSEARTIFACTKEY, HEADERPHASE,
               utils.checkEqualMimeResponse(mimeResponse, portletResp));
      } catch (RuntimeException e) {
         setAttribute(MIMERESPONSEARTIFACTKEY, HEADERPHASE, false);
      }
      
      try {
         setAttribute(STATEAWARERESPONSEARTIFACTKEY, HEADERPHASE,
               utils.isValid(stateAwareResponse.getNamespace()));
      } catch (RuntimeException e) {
         setAttribute(STATEAWARERESPONSEARTIFACTKEY, HEADERPHASE, false);
      }
      
   }
   
   @ActionMethod(
      portletName = "AnnotationPortletArtifactValidityTests_SPEC3_20_ResponseArtifacts", 
      publishingEvents = @PortletQName(
         localPart = "AnnotationPortletArtifactValidityTests_SPEC3_20_ResponseArtifacts", 
         namespaceURI = "http://www.apache.org/portals/pluto/portlet-tck_3.0"
      )
   )
   public void processAction(ActionRequest portletReq,
        ActionResponse portletResp) throws PortletException, IOException {
      
      try {
         setAttribute(PORTLETRESPONSEARTIFACTKEY, ACTIONPHASE,
               utils.checkEqualResponses(portletResponse, portletResp));
      } catch (RuntimeException e) {
         setAttribute(PORTLETRESPONSEARTIFACTKEY, ACTIONPHASE, false);
      }
      
      try {
         setAttribute(ACTIONRESPONSEARTIFACTKEY, ACTIONPHASE,
               utils.checkEqualStateAwareResponse(actionResponse, portletResp));
      } catch (RuntimeException e) {
         setAttribute(ACTIONRESPONSEARTIFACTKEY, ACTIONPHASE, false);
      }
      
      try {
         setAttribute(RENDERRESPONSEARTIFACTKEY, ACTIONPHASE,
               utils.isValid(renderResponse.getNamespace()));
      } catch (RuntimeException e) {
         setAttribute(RENDERRESPONSEARTIFACTKEY, ACTIONPHASE, false);
      }
      
      try {
         setAttribute(EVENTRESPONSEARTIFACTKEY, ACTIONPHASE,
               utils.isValid(eventResponse.getNamespace()));
      } catch (RuntimeException e) {
         setAttribute(EVENTRESPONSEARTIFACTKEY, ACTIONPHASE, false);
      }
      
      try {
         setAttribute(HEADERRESPONSEARTIFACTKEY, ACTIONPHASE,
               utils.isValid(headerResponse.getNamespace()));
      } catch (RuntimeException e) {
         setAttribute(HEADERRESPONSEARTIFACTKEY, ACTIONPHASE, false);
      }
      
      try {
         setAttribute(RESOURCERESPONSEARTIFACTKEY, ACTIONPHASE,
               utils.isValid(resourceResponse.getNamespace()));
      } catch (RuntimeException e) {
         setAttribute(RESOURCERESPONSEARTIFACTKEY, ACTIONPHASE, false);
      }
      
      try {
         setAttribute(MIMERESPONSEARTIFACTKEY, ACTIONPHASE,
               utils.isValid(mimeResponse.getNamespace()));
      } catch (RuntimeException e) {
         setAttribute(MIMERESPONSEARTIFACTKEY, ACTIONPHASE, false);
      }
      
      try {
         setAttribute(STATEAWARERESPONSEARTIFACTKEY, ACTIONPHASE,
               utils.checkEqualStateAwareResponse(stateAwareResponse, portletResp));
      } catch (RuntimeException e) {
         setAttribute(STATEAWARERESPONSEARTIFACTKEY, ACTIONPHASE, false);
      }
      
      QName eventQName = new QName(
            "http://www.apache.org/portals/pluto/portlet-tck_3.0",
            "AnnotationPortletArtifactValidityTests_SPEC3_20_ResponseArtifacts");
      portletResp.setEvent(eventQName, "Hi!");
      
   }

   @RenderMethod(
      portletNames = { "AnnotationPortletArtifactValidityTests_SPEC3_20_ResponseArtifacts" }
   )
   public void render(RenderRequest portletReq, RenderResponse portletResp)
           throws PortletException, IOException {

      PrintWriter writer = portletResp.getWriter();
      
      try {
         setAttribute(PORTLETRESPONSEARTIFACTKEY, RENDERPHASE,
               utils.checkEqualResponses(portletResponse, portletResp));
      } catch (RuntimeException e) {
         setAttribute(PORTLETRESPONSEARTIFACTKEY, RENDERPHASE, false);
      }
      
      try {
         setAttribute(ACTIONRESPONSEARTIFACTKEY, RENDERPHASE,
               utils.isValid(actionResponse.getNamespace()));
      } catch (RuntimeException e) {
         setAttribute(ACTIONRESPONSEARTIFACTKEY, RENDERPHASE, false);
      }
      
      try {
         setAttribute(RENDERRESPONSEARTIFACTKEY, RENDERPHASE,
               utils.checkEqualMimeResponse(renderResponse, portletResp));
      } catch (RuntimeException e) {
         setAttribute(RENDERRESPONSEARTIFACTKEY, RENDERPHASE, false);
      }
      
      try {
         setAttribute(EVENTRESPONSEARTIFACTKEY, RENDERPHASE,
               utils.isValid(eventResponse.getNamespace()));
      } catch (RuntimeException e) {
         setAttribute(EVENTRESPONSEARTIFACTKEY, RENDERPHASE, false);
      }
      
      try {
         setAttribute(HEADERRESPONSEARTIFACTKEY, RENDERPHASE,
               utils.isValid(headerResponse.getNamespace()));
      } catch (RuntimeException e) {
         setAttribute(HEADERRESPONSEARTIFACTKEY, RENDERPHASE, false);
      }
      
      try {
         setAttribute(RESOURCERESPONSEARTIFACTKEY, RENDERPHASE,
               utils.isValid(resourceResponse.getNamespace()));
      } catch (RuntimeException e) {
         setAttribute(RESOURCERESPONSEARTIFACTKEY, RENDERPHASE, false);
      }
      
      try {
         setAttribute(MIMERESPONSEARTIFACTKEY, RENDERPHASE,
               utils.checkEqualMimeResponse(mimeResponse, portletResp));
      } catch (RuntimeException e) {
         setAttribute(MIMERESPONSEARTIFACTKEY, RENDERPHASE, false);
      }
      
      try {
         setAttribute(STATEAWARERESPONSEARTIFACTKEY, RENDERPHASE,
               utils.isValid(stateAwareResponse.getNamespace()));
      } catch (RuntimeException e) {
         setAttribute(STATEAWARERESPONSEARTIFACTKEY, RENDERPHASE, false);
      }
      
      writer.write(
            "<div id=\"AnnotationPortletArtifactValidityTests_SPEC3_20_ResponseArtifacts\">no resource output.</div>\n");
      ResourceURL resurl = portletResp.createResourceURL();
      resurl.setCacheability(PAGE);
      writer.write("<script>\n");
      writer.write("(function () {\n");
      writer.write("   var xhr = new XMLHttpRequest();\n");
      writer.write("   xhr.onreadystatechange=function() {\n");
      writer.write("      if (xhr.readyState==4 && xhr.status==200) {\n");
      writer.write(
            "         document.getElementById(\"AnnotationPortletArtifactValidityTests_SPEC3_20_ResponseArtifacts\").innerHTML=xhr.responseText;\n");
      writer.write("      }\n");
      writer.write("   };\n");
      writer.write(
            "   xhr.open(\"GET\",\"" + resurl.toString() + "\",true);\n");
      writer.write("   xhr.send();\n");
      writer.write("})();\n");
      writer.write("</script>\n");

   }
   
   @ServeResourceMethod(
      portletNames = { "AnnotationPortletArtifactValidityTests_SPEC3_20_ResponseArtifacts" }
   )
   public void serveResource(ResourceRequest portletReq,
           ResourceResponse portletResp) throws PortletException, IOException {
      
      PrintWriter writer = portletResp.getWriter();
      ModuleTestCaseDetails tcd = new ModuleTestCaseDetails();
      RenderParameters renderParameters = portletReq.getRenderParameters();
      
      /* TestCase: V3AnnotationPortletArtifactValidityTests_SPEC3_20_ResponseArtifacts_portletResponse */
      /* Details: "PortletResponse artifact is valid during all phases."            */
      if (renderParameters.getValue("tr0") != null
            && renderParameters.getValue("tr0").equals("true")) {
         TestResult result = tcd.getTestResultFailed(
               V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_RESPONSEARTIFACTS_PORTLETRESPONSE);
         ArtifactValidationResult validationResult = getValidationTestResult(
               PORTLETRESPONSEARTIFACTKEY);
         try {
            validationResult.setArtifactValidInResourcePhase(
                  utils.checkEqualResponses(portletResponse, portletResp));
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
               V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_RESPONSEARTIFACTS_PORTLETRESPONSE,
               aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V3AnnotationPortletArtifactValidityTests_SPEC3_20_ResponseArtifacts_actionResponse */
      /* Details: "ActionResponse artifact is only valid during action phase."      */
      if (renderParameters.getValue("tr1") != null
            && renderParameters.getValue("tr1").equals("true")) {
         TestResult result = tcd.getTestResultFailed(
               V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_RESPONSEARTIFACTS_ACTIONRESPONSE);
         ArtifactValidationResult validationResult = getValidationTestResult(
               ACTIONRESPONSEARTIFACTKEY);
         try {
            validationResult.setArtifactValidInResourcePhase(
                  utils.isValid(actionResponse.getNamespace()));
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
               V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_RESPONSEARTIFACTS_ACTIONRESPONSE,
               aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V3AnnotationPortletArtifactValidityTests_SPEC3_20_ResponseArtifacts_headerResponse */
      /* Details: "HeaderResponse artifact is only valid during header phase."      */
      if (renderParameters.getValue("tr4") != null
            && renderParameters.getValue("tr4").equals("true")) {
         TestResult result = tcd.getTestResultFailed(
               V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_RESPONSEARTIFACTS_HEADERRESPONSE);
         ArtifactValidationResult validationResult = getValidationTestResult(
               HEADERRESPONSEARTIFACTKEY);
         try {
            validationResult.setArtifactValidInResourcePhase(
                  utils.isValid(headerResponse.getNamespace()));
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
               V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_RESPONSEARTIFACTS_HEADERRESPONSE,
               aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V3AnnotationPortletArtifactValidityTests_SPEC3_20_ResponseArtifacts_renderResponse */
      /* Details: "RenderResponse artifact is only valid during render phase."      */
      if (renderParameters.getValue("tr2") != null
            && renderParameters.getValue("tr2").equals("true")) {
         TestResult result = tcd.getTestResultFailed(
               V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_RESPONSEARTIFACTS_RENDERRESPONSE);
         ArtifactValidationResult validationResult = getValidationTestResult(
               RENDERRESPONSEARTIFACTKEY);
         try {
            validationResult.setArtifactValidInResourcePhase(
                  utils.isValid(renderResponse.getNamespace()));
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
               V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_RESPONSEARTIFACTS_RENDERRESPONSE,
               aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V3AnnotationPortletArtifactValidityTests_SPEC3_20_ResponseArtifacts_eventResponse */
      /* Details: "EventResponse artifact is only valid during event phase."        */
      if (renderParameters.getValue("tr3") != null
            && renderParameters.getValue("tr3").equals("true")) {
         TestResult result = tcd.getTestResultFailed(
               V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_RESPONSEARTIFACTS_EVENTRESPONSE);
         ArtifactValidationResult validationResult = getValidationTestResult(
               EVENTRESPONSEARTIFACTKEY);
         try {
            validationResult.setArtifactValidInResourcePhase(
                  utils.isValid(eventResponse.getNamespace()));
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
               V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_RESPONSEARTIFACTS_EVENTRESPONSE,
               aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V3AnnotationPortletArtifactValidityTests_SPEC3_20_ResponseArtifacts_resourceResponse */
      /* Details: "ResourceResponse artifact is only valid during resource phase."  */
      if (renderParameters.getValue("tr5") != null
            && renderParameters.getValue("tr5").equals("true")) {
         TestResult result = tcd.getTestResultFailed(
               V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_RESPONSEARTIFACTS_RESOURCERESPONSE);
         ArtifactValidationResult validationResult = getValidationTestResult(
               RESOURCERESPONSEARTIFACTKEY);
         try {
            validationResult.setArtifactValidInResourcePhase(
                  utils.checkEqualMimeResponse(resourceResponse, portletResp));
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
               V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_RESPONSEARTIFACTS_RESOURCERESPONSE,
               aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V3AnnotationPortletArtifactValidityTests_SPEC3_20_ResponseArtifacts_stateAwareReponse */
      /* Details: "StateAwareResponse artifact is only valid during action and      */
      /* event phase."                                                              */
      if (renderParameters.getValue("tr7") != null
            && renderParameters.getValue("tr7").equals("true")) {
         TestResult result = tcd.getTestResultFailed(
               V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_RESPONSEARTIFACTS_STATEAWAREREPONSE);
         ArtifactValidationResult validationResult = getValidationTestResult(
               STATEAWARERESPONSEARTIFACTKEY);
         try {
            validationResult.setArtifactValidInResourcePhase(
                  utils.isValid(stateAwareResponse.getNamespace()));
         } catch (RuntimeException e) {
            validationResult.setArtifactValidInResourcePhase(false);
         }
         if (validationResult.isArtifactValidInActionPhase()
               && validationResult.isArtifactValidInEventPhase()
               && !validationResult.isArtifactValidInHeaderPhase()
               && !validationResult.isArtifactValidInRenderPhase()
               && !validationResult.isArtifactValidInResourcePhase()) {
            result.setTcSuccess(true);
         }
         result.appendTcDetail(utils.createTestDebug(validationResult));
         result.writeTo(writer);
      } else {
         ActionURL aurl = portletResp.createActionURL();
         TestButton tb = new TestButton(
               V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_RESPONSEARTIFACTS_STATEAWAREREPONSE,
               aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V3AnnotationPortletArtifactValidityTests_SPEC3_20_ResponseArtifacts_mimeResponse */
      /* Details: "MimeResponse artifact is only valid during header, render and    */
      /* resource phase."                                                           */
      if (renderParameters.getValue("tr6") != null
            && renderParameters.getValue("tr6").equals("true")) {
         TestResult result = tcd.getTestResultFailed(
               V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_RESPONSEARTIFACTS_MIMERESPONSE);
         ArtifactValidationResult validationResult = getValidationTestResult(
               MIMERESPONSEARTIFACTKEY);
         try {
            validationResult.setArtifactValidInResourcePhase(
                  utils.checkEqualMimeResponse(mimeResponse, portletResp));
         } catch (RuntimeException e) {
            validationResult.setArtifactValidInResourcePhase(false);
         }
         if (!validationResult.isArtifactValidInActionPhase()
               && !validationResult.isArtifactValidInEventPhase()
               && validationResult.isArtifactValidInHeaderPhase()
               && validationResult.isArtifactValidInRenderPhase()
               && validationResult.isArtifactValidInResourcePhase()) {
            result.setTcSuccess(true);
         }
         result.appendTcDetail(utils.createTestDebug(validationResult));
         result.writeTo(writer);
      } else {
         ActionURL aurl = portletResp.createActionURL();
         TestButton tb = new TestButton(
               V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_RESPONSEARTIFACTS_MIMERESPONSE,
               aurl);
         tb.writeTo(writer);
      }
      
   }
   
   @EventMethod(
      portletName = "AnnotationPortletArtifactValidityTests_SPEC3_20_ResponseArtifacts", 
      processingEvents = @PortletQName(
         localPart = "AnnotationPortletArtifactValidityTests_SPEC3_20_ResponseArtifacts", 
         namespaceURI = "http://www.apache.org/portals/pluto/portlet-tck_3.0"
      )
   )
   public void processEvent(EventRequest portletReq, EventResponse portletResp)
           throws PortletException, IOException {
      
      MutableRenderParameters renderParameters = portletResp.getRenderParameters();
      
      try {
         setAttribute(PORTLETRESPONSEARTIFACTKEY, EVENTPHASE,
               utils.checkEqualResponses(portletResponse, portletResp));
      } catch (RuntimeException e) {
         setAttribute(PORTLETRESPONSEARTIFACTKEY, EVENTPHASE, false);
      }
      renderParameters.setValue("tr0", "true");
      
      try {
         setAttribute(ACTIONRESPONSEARTIFACTKEY, EVENTPHASE,
               utils.isValid(actionResponse.getNamespace()));
      } catch (RuntimeException e) {
         setAttribute(ACTIONRESPONSEARTIFACTKEY, EVENTPHASE, false);
      }
      renderParameters.setValue("tr1", "true");
      
      try {
         setAttribute(RENDERRESPONSEARTIFACTKEY, EVENTPHASE,
               utils.isValid(renderResponse.getNamespace()));
      } catch (RuntimeException e) {
         setAttribute(RENDERRESPONSEARTIFACTKEY, EVENTPHASE, false);
      }
      renderParameters.setValue("tr2", "true");
      
      try {
         setAttribute(EVENTRESPONSEARTIFACTKEY, EVENTPHASE,
               utils.checkEqualStateAwareResponse(eventResponse, portletResp));
      } catch (RuntimeException e) {
         setAttribute(EVENTRESPONSEARTIFACTKEY, EVENTPHASE, false);
      }
      renderParameters.setValue("tr3", "true");
      
      try {
         setAttribute(HEADERRESPONSEARTIFACTKEY, EVENTPHASE,
               utils.isValid(headerResponse.getNamespace()));
      } catch (RuntimeException e) {
         setAttribute(HEADERRESPONSEARTIFACTKEY, EVENTPHASE, false);
      }
      renderParameters.setValue("tr4", "true");
      
      try {
         setAttribute(RESOURCERESPONSEARTIFACTKEY, EVENTPHASE,
               utils.isValid(resourceResponse.getNamespace()));
      } catch (RuntimeException e) {
         setAttribute(RESOURCERESPONSEARTIFACTKEY, EVENTPHASE, false);
      }
      renderParameters.setValue("tr5", "true");
      
      try {
         setAttribute(MIMERESPONSEARTIFACTKEY, EVENTPHASE,
               utils.isValid(mimeResponse.getNamespace()));
      } catch (RuntimeException e) {
         setAttribute(MIMERESPONSEARTIFACTKEY, EVENTPHASE, false);
      }
      renderParameters.setValue("tr6", "true");
      
      try {
         setAttribute(STATEAWARERESPONSEARTIFACTKEY, EVENTPHASE,
               utils.checkEqualStateAwareResponse(stateAwareResponse, portletResp));
      } catch (RuntimeException e) {
         setAttribute(STATEAWARERESPONSEARTIFACTKEY, EVENTPHASE, false);
      }
      renderParameters.setValue("tr7", "true");
      
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
