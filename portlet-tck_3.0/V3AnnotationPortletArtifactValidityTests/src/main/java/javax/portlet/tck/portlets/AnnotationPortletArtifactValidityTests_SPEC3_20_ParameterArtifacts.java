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
import javax.portlet.ActionParameters;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.ActionURL;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.HeaderRequest;
import javax.portlet.HeaderResponse;
import javax.portlet.MutableRenderParameters;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderParameters;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceParameters;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceURL;
import javax.portlet.annotations.ActionMethod;
import javax.portlet.annotations.EventDefinition;
import javax.portlet.annotations.EventMethod;
import javax.portlet.annotations.HeaderMethod;
import javax.portlet.annotations.PortletApplication;
import javax.portlet.annotations.PortletName;
import javax.portlet.annotations.PortletQName;
import javax.portlet.annotations.RenderMethod;
import javax.portlet.annotations.ServeResourceMethod;
import javax.portlet.tck.beans.TestButton;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.util.ModuleTestCaseDetails;
import javax.xml.namespace.QName;

import static javax.portlet.tck.util.ModuleTestCaseDetails.V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PARAMETERARTIFACTS_ACTIONPARAMETERS;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PARAMETERARTIFACTS_MUTABLERENDERPARAMETERS;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PARAMETERARTIFACTS_RENDERPARAMETERS;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PARAMETERARTIFACTS_RESOURCEPARAMETERS;
import static javax.portlet.PortletSession.PORTLET_SCOPE;
import static javax.portlet.ResourceURL.PAGE;
import static javax.portlet.tck.portlets.Utils.ACTIONPHASE;
import static javax.portlet.tck.portlets.Utils.EVENTPHASE;
import static javax.portlet.tck.portlets.Utils.HEADERPHASE;
import static javax.portlet.tck.portlets.Utils.RENDERPHASE;
import static javax.portlet.tck.portlets.Utils.ACTIONPARAMETERSARTIFACTKEY;
import static javax.portlet.tck.portlets.Utils.MUTABLERENDERPARAMETERSARTIFACTKEY;
import static javax.portlet.tck.portlets.Utils.RENDERPARAMETERSARTIFACTKEY;
import static javax.portlet.tck.portlets.Utils.RESOURCEPARAMETERSARTIFACTKEY;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case
 * names are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the
 * additionalTCs.xml file into the complete list of test case names for
 * execution by the driver.
 *
 */

@PortletApplication(events = @EventDefinition(qname = @PortletQName(localPart = "AnnotationPortletArtifactValidityTests_SPEC3_20_ParameterArtifacts", namespaceURI = "http://www.apache.org/portals/pluto/portlet-tck_3.0"), payloadType = java.lang.String.class))
public class AnnotationPortletArtifactValidityTests_SPEC3_20_ParameterArtifacts {

   private Utils                   utils = new Utils();

   @Inject
   @PortletName
   private String                  portletName;

   @Inject
   private RenderParameters        renderParameters;

   @Inject
   private MutableRenderParameters mutableRenderParameters;

   @Inject
   private ActionParameters        actionParameters;

   @Inject
   private ResourceParameters      resourceParameters;

   @Inject
   private PortletSession          portletSession;

   @HeaderMethod(portletNames = {
         "AnnotationPortletArtifactValidityTests_SPEC3_20_ParameterArtifacts" })
   public void renderHeaders(HeaderRequest portletReq,
         HeaderResponse portletResp) {

      try {
         setAttribute(ACTIONPARAMETERSARTIFACTKEY, HEADERPHASE,
               utils.isValid(actionParameters));
      } catch (RuntimeException e) {
         setAttribute(ACTIONPARAMETERSARTIFACTKEY, HEADERPHASE, false);
      }

      try {
         setAttribute(RENDERPARAMETERSARTIFACTKEY, HEADERPHASE,
               utils.isValid(renderParameters));
      } catch (RuntimeException e) {
         setAttribute(RENDERPARAMETERSARTIFACTKEY, HEADERPHASE, false);
      }

      try {
         setAttribute(MUTABLERENDERPARAMETERSARTIFACTKEY, HEADERPHASE,
               utils.isValid(mutableRenderParameters));
      } catch (RuntimeException e) {
         setAttribute(MUTABLERENDERPARAMETERSARTIFACTKEY, HEADERPHASE, false);
      }

      try {
         setAttribute(RESOURCEPARAMETERSARTIFACTKEY, HEADERPHASE,
               utils.isValid(resourceParameters));
      } catch (RuntimeException e) {
         setAttribute(RESOURCEPARAMETERSARTIFACTKEY, HEADERPHASE, false);
      }

   }

   @ActionMethod(portletName = "AnnotationPortletArtifactValidityTests_SPEC3_20_ParameterArtifacts", publishingEvents = @PortletQName(localPart = "AnnotationPortletArtifactValidityTests_SPEC3_20_ParameterArtifacts", namespaceURI = "http://www.apache.org/portals/pluto/portlet-tck_3.0"))
   public void processAction(ActionRequest portletReq,
         ActionResponse portletResp) throws PortletException, IOException {

      ActionParameters actionParams = portletReq.getActionParameters();
      try {
         setAttribute(ACTIONPARAMETERSARTIFACTKEY, ACTIONPHASE,
               utils.checkEqualParameters(actionParameters, actionParams));
      } catch (RuntimeException e) {
         setAttribute(ACTIONPARAMETERSARTIFACTKEY, ACTIONPHASE, false);
      }

      try {
         setAttribute(RENDERPARAMETERSARTIFACTKEY, ACTIONPHASE,
               utils.isValid(renderParameters));
      } catch (RuntimeException e) {
         setAttribute(RENDERPARAMETERSARTIFACTKEY, ACTIONPHASE, false);
      }

      MutableRenderParameters renderParams = portletResp.getRenderParameters();
      try {
         setAttribute(MUTABLERENDERPARAMETERSARTIFACTKEY, ACTIONPHASE, utils
               .checkEqualParameters(mutableRenderParameters, renderParams));
      } catch (RuntimeException e) {
         setAttribute(MUTABLERENDERPARAMETERSARTIFACTKEY, ACTIONPHASE, false);
      }

      try {
         setAttribute(RESOURCEPARAMETERSARTIFACTKEY, ACTIONPHASE,
               utils.isValid(resourceParameters));
      } catch (RuntimeException e) {
         setAttribute(RESOURCEPARAMETERSARTIFACTKEY, ACTIONPHASE, false);
      }

      QName eventQName = new QName(
            "http://www.apache.org/portals/pluto/portlet-tck_3.0",
            "AnnotationPortletArtifactValidityTests_SPEC3_20_ParameterArtifacts");
      portletResp.setEvent(eventQName, "Hi!");

   }

   @RenderMethod(portletNames = {
         "AnnotationPortletArtifactValidityTests_SPEC3_20_ParameterArtifacts" })
   public void render(RenderRequest portletReq, RenderResponse portletResp)
         throws PortletException, IOException {

      PrintWriter writer = portletResp.getWriter();

      try {
         setAttribute(ACTIONPARAMETERSARTIFACTKEY, RENDERPHASE,
               utils.isValid(actionParameters));
      } catch (RuntimeException e) {
         setAttribute(ACTIONPARAMETERSARTIFACTKEY, RENDERPHASE, false);
      }

      RenderParameters renderParams = portletReq.getRenderParameters();
      try {
         setAttribute(RENDERPARAMETERSARTIFACTKEY, RENDERPHASE,
               utils.checkEqualParameters(renderParameters, renderParams));
      } catch (RuntimeException e) {
         setAttribute(RENDERPARAMETERSARTIFACTKEY, RENDERPHASE, false);
      }

      try {
         setAttribute(MUTABLERENDERPARAMETERSARTIFACTKEY, RENDERPHASE,
               utils.isValid(mutableRenderParameters));
      } catch (RuntimeException e) {
         setAttribute(MUTABLERENDERPARAMETERSARTIFACTKEY, RENDERPHASE, false);
      }

      try {
         setAttribute(RESOURCEPARAMETERSARTIFACTKEY, RENDERPHASE,
               utils.isValid(resourceParameters));
      } catch (RuntimeException e) {
         setAttribute(RESOURCEPARAMETERSARTIFACTKEY, RENDERPHASE, false);
      }

      writer.write(
            "<div id=\"AnnotationPortletArtifactValidityTests_SPEC3_20_ParameterArtifacts\">no resource output.</div>\n");
      ResourceURL resurl = portletResp.createResourceURL();
      resurl.setCacheability(PAGE);
      writer.write("<script>\n");
      writer.write("(function () {\n");
      writer.write("   var xhr = new XMLHttpRequest();\n");
      writer.write("   xhr.onreadystatechange=function() {\n");
      writer.write("      if (xhr.readyState==4 && xhr.status==200) {\n");
      writer.write(
            "         document.getElementById(\"AnnotationPortletArtifactValidityTests_SPEC3_20_ParameterArtifacts\").innerHTML=xhr.responseText;\n");
      writer.write("      }\n");
      writer.write("   };\n");
      writer.write(
            "   xhr.open(\"GET\",\"" + resurl.toString() + "\",true);\n");
      writer.write("   xhr.send();\n");
      writer.write("})();\n");
      writer.write("</script>\n");

   }

   @ServeResourceMethod(portletNames = {
         "AnnotationPortletArtifactValidityTests_SPEC3_20_ParameterArtifacts" })
   public void serveResource(ResourceRequest portletReq,
         ResourceResponse portletResp) throws PortletException, IOException {

      PrintWriter writer = portletResp.getWriter();
      ModuleTestCaseDetails tcd = new ModuleTestCaseDetails();
      RenderParameters renderParams = portletReq.getRenderParameters();

      /*
       * TestCase:
       * V3AnnotationPortletArtifactValidityTests_SPEC3_20_ParameterArtifacts_actionParameters
       * Details: "ActionParameters artifact is only valid during action phase."
       */
      if (renderParams.getValue("tr0") != null
            && renderParams.getValue("tr0").equals("true")) {
         TestResult result = tcd.getTestResultFailed(
               V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PARAMETERARTIFACTS_ACTIONPARAMETERS);
         ArtifactValidationResult validationResult = getValidationTestResult(
               ACTIONPARAMETERSARTIFACTKEY);
         try {
            validationResult.setArtifactValidInResourcePhase(
                  utils.isValid(actionParameters));
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
               V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PARAMETERARTIFACTS_ACTIONPARAMETERS,
               aurl);
         tb.writeTo(writer);
      }

      /*
       * TestCase:
       * V3AnnotationPortletArtifactValidityTests_SPEC3_20_ParameterArtifacts_mutableRenderParameters
       * Details: "MutableRenderParameters artifact is only valid during action
       * and event phase."
       */
      if (renderParams.getValue("tr1") != null
            && renderParams.getValue("tr1").equals("true")) {
         TestResult result = tcd.getTestResultFailed(
               V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PARAMETERARTIFACTS_MUTABLERENDERPARAMETERS);
         ArtifactValidationResult validationResult = getValidationTestResult(
               RENDERPARAMETERSARTIFACTKEY);
         try {
            validationResult.setArtifactValidInResourcePhase(
                  utils.isValid(mutableRenderParameters));
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
               V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PARAMETERARTIFACTS_MUTABLERENDERPARAMETERS,
               aurl);
         tb.writeTo(writer);
      }

      /*
       * TestCase:
       * V3AnnotationPortletArtifactValidityTests_SPEC3_20_ParameterArtifacts_renderParameters
       * Details: "RenderParameters artifact is only valid during render phase."
       */
      if (renderParams.getValue("tr2") != null
            && renderParams.getValue("tr2").equals("true")) {
         TestResult result = tcd.getTestResultFailed(
               V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PARAMETERARTIFACTS_RENDERPARAMETERS);
         ArtifactValidationResult validationResult = getValidationTestResult(
               RENDERPARAMETERSARTIFACTKEY);
         try {
            validationResult.setArtifactValidInResourcePhase(
                  utils.isValid(renderParameters));
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
               V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PARAMETERARTIFACTS_RENDERPARAMETERS,
               aurl);
         tb.writeTo(writer);
      }

      /*
       * TestCase:
       * V3AnnotationPortletArtifactValidityTests_SPEC3_20_ParameterArtifacts_resourceParameters
       * Details: "ResourceParameters artifact is only valid during resource
       * phase."
       */
      if (renderParams.getValue("tr3") != null
            && renderParams.getValue("tr3").equals("true")) {
         TestResult result = tcd.getTestResultFailed(
               V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PARAMETERARTIFACTS_RESOURCEPARAMETERS);
         ArtifactValidationResult validationResult = getValidationTestResult(
               ACTIONPARAMETERSARTIFACTKEY);
         ResourceParameters resourceParams = portletReq.getResourceParameters();
         try {
            validationResult.setArtifactValidInResourcePhase(utils
                  .checkEqualParameters(resourceParameters, resourceParams));
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
               V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PARAMETERARTIFACTS_RESOURCEPARAMETERS,
               aurl);
         tb.writeTo(writer);
      }

   }

   @EventMethod(portletName = "AnnotationPortletArtifactValidityTests_SPEC3_20_ParameterArtifacts", processingEvents = @PortletQName(localPart = "AnnotationPortletArtifactValidityTests_SPEC3_20_ParameterArtifacts", namespaceURI = "http://www.apache.org/portals/pluto/portlet-tck_3.0"))
   public void processEvent(EventRequest portletReq, EventResponse portletResp)
         throws PortletException, IOException {

      MutableRenderParameters renderParams = portletResp.getRenderParameters();

      try {
         setAttribute(ACTIONPARAMETERSARTIFACTKEY, EVENTPHASE,
               utils.isValid(actionParameters));
      } catch (RuntimeException e) {
         setAttribute(ACTIONPARAMETERSARTIFACTKEY, EVENTPHASE, false);
      }
      renderParams.setValue("tr0", "true");

      try {
         setAttribute(MUTABLERENDERPARAMETERSARTIFACTKEY, EVENTPHASE, utils
               .checkEqualParameters(mutableRenderParameters, renderParams));
      } catch (RuntimeException e) {
         setAttribute(MUTABLERENDERPARAMETERSARTIFACTKEY, EVENTPHASE, false);
      }
      renderParams.setValue("tr1", "true");

      try {
         setAttribute(RENDERPARAMETERSARTIFACTKEY, EVENTPHASE,
               utils.isValid(renderParameters));
      } catch (RuntimeException e) {
         setAttribute(RENDERPARAMETERSARTIFACTKEY, EVENTPHASE, false);
      }
      renderParams.setValue("tr2", "true");

      try {
         setAttribute(RESOURCEPARAMETERSARTIFACTKEY, EVENTPHASE,
               utils.isValid(resourceParameters));
      } catch (RuntimeException e) {
         setAttribute(RESOURCEPARAMETERSARTIFACTKEY, EVENTPHASE, false);
      }
      renderParams.setValue("tr3", "true");

   }

   public void setAttribute(String artifactKey, String phase,
         boolean validity) {

      portletSession.setAttribute(portletName + artifactKey + phase, validity,
            PORTLET_SCOPE);

   }

   private ArtifactValidationResult getValidationTestResult(
         String artifactKey) {
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
