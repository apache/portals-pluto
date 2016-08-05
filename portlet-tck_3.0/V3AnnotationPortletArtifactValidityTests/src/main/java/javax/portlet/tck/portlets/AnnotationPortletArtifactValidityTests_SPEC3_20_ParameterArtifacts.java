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
import javax.inject.Inject;
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
 * This portlet implements several test cases for the JSR 362 TCK. The test case
 * names are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the
 * additionalTCs.xml file into the complete list of test case names for
 * execution by the driver.
 *
 */

@PortletApplication(
      events = @EventDefinition(
            qname = @PortletQName(
                  localPart = "AnnotationPortletArtifactValidityTests_SPEC3_20_ParameterArtifacts", 
                  namespaceURI = "http://www.apache.org/portals/pluto/portlet-tck_3.0"), 
            payloadType = java.lang.String.class))
public class AnnotationPortletArtifactValidityTests_SPEC3_20_ParameterArtifacts {

   public static final String      ACTIONPARAMETERARTIFACTKEY        = "_actionParametersArtifact_";
   public static final String      MUTABLEACTIONPARAMETERARTIFACTKEY = "_mutableActionParametersArtifact_";
   public static final String      RENDERPARAMETERARTIFACTKEY        = "_renderParametersArtifact_";
   public static final String      RESOURCEPARAMETERARTIFACTKEY      = "_resourceParametersArtifact_";
   public static final String      ACTIONPHASE                       = "action";
   public static final String      RENDERPHASE                       = "render";
   public static final String      HEADERPHASE                       = "header";
   public static final String      EVENTPHASE                        = "event";
   // public static final String RESOURCEPHASE = "resource";

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
   private PortletSession portletSession;
   
   @HeaderMethod(portletNames = {
         "AnnotationPortletArtifactValidityTests_SPEC3_20_ParameterArtifacts" })
   public void renderHeaders(HeaderRequest portletReq,
         HeaderResponse portletResp) {
      
      System.out.println("HeaderMethod");
      boolean actonParamArtifactValidator = false;
      try{
         if (actionParameters == null) {
            actonParamArtifactValidator = true;
         } else {
            actonParamArtifactValidator = false;
         }
      } catch (RuntimeException e){
         actonParamArtifactValidator = true;
         e.printStackTrace();
      }
      portletSession.setAttribute(
            portletName + ACTIONPARAMETERARTIFACTKEY + HEADERPHASE,
            actonParamArtifactValidator, PORTLET_SCOPE);
      
      boolean renderParamArtifactValidator = false;
      try{
         if (renderParameters == null) {
            renderParamArtifactValidator = true;
         } else {
            renderParamArtifactValidator = false;
         }
      } catch (RuntimeException e){
         renderParamArtifactValidator = true;
         e.printStackTrace();
      }
      portletSession.setAttribute(
            portletName + RENDERPARAMETERARTIFACTKEY + HEADERPHASE,
            renderParamArtifactValidator, PORTLET_SCOPE);
   }

   @ActionMethod(portletName = "AnnotationPortletArtifactValidityTests_SPEC3_20_ParameterArtifacts", 
         publishingEvents = @PortletQName(
               localPart = "AnnotationPortletArtifactValidityTests_SPEC3_20_ParameterArtifacts", 
               namespaceURI = "http://www.apache.org/portals/pluto/portlet-tck_3.0"))
   public void processAction(ActionRequest portletReq,
         ActionResponse portletResp) throws PortletException, IOException {
      
      System.out.println("ActionMethod");
      ActionParameters actionParams = portletReq.getActionParameters();
      boolean actonParamArtifactValidator = false;
      try{
         /* 
          * TODO: Create a new check
          * Injected actionParameters should not be null and 
          * should be equal to ActionRequest.getActionParameters()
          */
         if (actionParameters!=null) {
            actonParamArtifactValidator = true;
         } else {
            actonParamArtifactValidator = false;
         }
      } catch (RuntimeException e){
         e.printStackTrace();
         actonParamArtifactValidator = false;
      }
      portletSession.setAttribute(
            portletName + ACTIONPARAMETERARTIFACTKEY + ACTIONPHASE,
            actonParamArtifactValidator, PORTLET_SCOPE);
      
      boolean renderParamArtifactValidator = false;
      try{
         if (renderParameters == null) {
            renderParamArtifactValidator = true;
         } else {
            renderParamArtifactValidator = false;
         }
      } catch (RuntimeException e){
         renderParamArtifactValidator = true;
         e.printStackTrace();
      }
      portletSession.setAttribute(
            portletName + RENDERPARAMETERARTIFACTKEY + ACTIONPHASE,
            renderParamArtifactValidator, PORTLET_SCOPE);
      
      // TODO: Remove following temp code
      /* Code to perform job of event method - Starts here. */
      
      /* Event method is not getting called for some reason
       * till that time we set the attributes/parameters here
       * instead of event method. When event method works remove
       * the following code.
       */
      portletSession.setAttribute(
            portletName + ACTIONPARAMETERARTIFACTKEY + EVENTPHASE,
            actonParamArtifactValidator, PORTLET_SCOPE);
      
      MutableRenderParameters renderParams = portletResp.getRenderParameters();
      renderParams.setValue("tr0", "true");
      
      portletSession.setAttribute(
            portletName + RENDERPARAMETERARTIFACTKEY + EVENTPHASE,
            actonParamArtifactValidator, PORTLET_SCOPE);
      
      renderParams.setValue("tr2", "true");
      /* Code to perform job of event method - Ends Here. */
      
      QName eventQName = new QName("http://www.apache.org/portals/pluto/portlet-tck_3.0", 
            "AnnotationPortletArtifactValidityTests_SPEC3_20_ParameterArtifacts");
      portletResp.setEvent(eventQName, "Hi!");

   }

   @RenderMethod(portletNames = {
         "AnnotationPortletArtifactValidityTests_SPEC3_20_ParameterArtifacts" })
   public void render(RenderRequest portletReq, RenderResponse portletResp)
         throws PortletException, IOException {
      
      System.out.println("RenderMethod");
      PrintWriter writer = portletResp.getWriter();
      
      boolean actonParamArtifactValidator = false;
      try{
         if (actionParameters == null) {
            actonParamArtifactValidator = true;
         } else {
            actonParamArtifactValidator = false;
         }
      } catch (RuntimeException e){
         actonParamArtifactValidator = true;
         e.printStackTrace();
      }
      portletSession.setAttribute(
            portletName + ACTIONPARAMETERARTIFACTKEY + RENDERPHASE,
            actonParamArtifactValidator, PORTLET_SCOPE);
      
      boolean renderParamArtifactValidator = false;
      try{
         /* 
          * TODO: Create a new check
          * Injected renderParameters should not be null and 
          * should be equal to RenderRequest.getRenderParameters()
          */
         if (renderParameters!=null) {
            renderParamArtifactValidator = true;
         } else {
            renderParamArtifactValidator = false;
         }
      } catch (RuntimeException e){
         e.printStackTrace();
         renderParamArtifactValidator = false;
      }
      portletSession.setAttribute(
            portletName + RENDERPARAMETERARTIFACTKEY + RENDERPHASE,
            renderParamArtifactValidator, PORTLET_SCOPE);
      
      
      writer
      .write("<div id=\"AnnotationPortletArtifactValidityTests_SPEC3_20_ParameterArtifacts\">no resource output.</div>\n");
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
      writer.write("   xhr.open(\"GET\",\"" + resurl.toString() + "\",true);\n");
      writer.write("   xhr.send();\n");
      writer.write("})();\n");
      writer.write("</script>\n");

   }

   @ServeResourceMethod(portletNames = {
         "AnnotationPortletArtifactValidityTests_SPEC3_20_ParameterArtifacts" })
   public void serveResource(ResourceRequest portletReq,
         ResourceResponse portletResp) throws PortletException, IOException {
      
      System.out.println("ResourceMethod");
      PrintWriter writer = portletResp.getWriter();
      ModuleTestCaseDetails tcd = new ModuleTestCaseDetails();

      /*
       * TestCase:
       * V3AnnotationPortletArtifactValidityTests_SPEC3_20_ParameterArtifacts_renderParameters
       * Details: "RenderParameters artifact is only valid during render phase."
       */
      if(portletReq.getRenderParameters().getValue("tr2")!=null && portletReq.getRenderParameters().getValue("tr2").equals("true"))
      {
         TestResult result = tcd.getTestResultFailed(
               V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PARAMETERARTIFACTS_RENDERPARAMETERS);
         boolean renderParamArtifactResource = false;
         try{
            if (renderParameters == null) {
               renderParamArtifactResource = true;
            } else {
               renderParamArtifactResource = false;
            }
         } catch (RuntimeException e){
            renderParamArtifactResource = true;
            e.printStackTrace();
         }
         boolean renderParamArtifactAction = (boolean) portletSession
               .getAttribute(
                     portletName + RENDERPARAMETERARTIFACTKEY + ACTIONPHASE,
                     PORTLET_SCOPE);
         boolean renderParamArtifactRender = (boolean) portletSession
               .getAttribute(
                     portletName + RENDERPARAMETERARTIFACTKEY + RENDERPHASE,
                     PORTLET_SCOPE);
         boolean renderParamArtifactHeader = (boolean) portletSession
               .getAttribute(
                     portletName + RENDERPARAMETERARTIFACTKEY + HEADERPHASE,
                     PORTLET_SCOPE);
         boolean renderParamArtifactEvent = (boolean) portletSession
               .getAttribute(
                     portletName + RENDERPARAMETERARTIFACTKEY + EVENTPHASE,
                     PORTLET_SCOPE);
         if (renderParamArtifactAction && renderParamArtifactRender
               && renderParamArtifactResource && renderParamArtifactHeader
               && renderParamArtifactEvent) {
            result.setTcSuccess(true);
         }
         result.appendTcDetail(createTable(renderParamArtifactAction,
               renderParamArtifactEvent, renderParamArtifactHeader,
               renderParamArtifactRender, renderParamArtifactResource));
         result.writeTo(writer);
      } else {
         ActionURL aurl = portletResp.createActionURL();
         TestButton tb = new TestButton(V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PARAMETERARTIFACTS_RENDERPARAMETERS, aurl);
         tb.writeTo(writer);
      }

      /*
       * TestCase:
       * V3AnnotationPortletArtifactValidityTests_SPEC3_20_ParameterArtifacts_mutableRenderParameters
       * Details: "MutableRenderParameters artifact is only valid during action
       * and event phase."
       */
      {
         TestResult result = tcd.getTestResultFailed(
               V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PARAMETERARTIFACTS_MUTABLERENDERPARAMETERS);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /*
       * TestCase:
       * V3AnnotationPortletArtifactValidityTests_SPEC3_20_ParameterArtifacts_actionParameters
       * Details: "ActionParameters artifact is only valid during action phase."
       */
      if(portletReq.getRenderParameters().getValue("tr0")!=null && portletReq.getRenderParameters().getValue("tr0").equals("true"))
      {
         TestResult result = tcd.getTestResultFailed(
               V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PARAMETERARTIFACTS_ACTIONPARAMETERS);
         boolean actonParamArtifactResource = false;
         try{
            if (actionParameters == null) {
               actonParamArtifactResource = true;
            } else {
               actonParamArtifactResource = false;
            }
         } catch (RuntimeException e){
            actonParamArtifactResource = true;
            e.printStackTrace();
         }
         boolean actonParamArtifactAction = (boolean) portletSession
               .getAttribute(
                     portletName + ACTIONPARAMETERARTIFACTKEY + ACTIONPHASE,
                     PORTLET_SCOPE);
         boolean actonParamArtifactRender = (boolean) portletSession
               .getAttribute(
                     portletName + ACTIONPARAMETERARTIFACTKEY + RENDERPHASE,
                     PORTLET_SCOPE);
         boolean actonParamArtifactHeader = (boolean) portletSession
               .getAttribute(
                     portletName + ACTIONPARAMETERARTIFACTKEY + HEADERPHASE,
                     PORTLET_SCOPE);
         boolean actonParamArtifactEvent = (boolean) portletSession
               .getAttribute(
                     portletName + ACTIONPARAMETERARTIFACTKEY + EVENTPHASE,
                     PORTLET_SCOPE);
         if (actonParamArtifactAction && actonParamArtifactRender
               && actonParamArtifactResource && actonParamArtifactHeader
               && actonParamArtifactEvent) {
            result.setTcSuccess(true);
         }
         result.appendTcDetail(createTable(actonParamArtifactAction,
               actonParamArtifactEvent, actonParamArtifactHeader,
               actonParamArtifactRender, actonParamArtifactResource));
         result.writeTo(writer);
      } else {
         ActionURL aurl = portletResp.createActionURL();
         TestButton tb = new TestButton(V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PARAMETERARTIFACTS_ACTIONPARAMETERS, aurl);
         tb.writeTo(writer);
      }

      /*
       * TestCase:
       * V3AnnotationPortletArtifactValidityTests_SPEC3_20_ParameterArtifacts_resourceParameters
       * Details: "ResourceParameters artifact is only valid during resource
       * phase." */
      {
         TestResult result = tcd.getTestResultFailed(
               V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PARAMETERARTIFACTS_RESOURCEPARAMETERS);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

   }

   @EventMethod(
         portletName = "AnnotationPortletArtifactValidityTests_SPEC3_20_ParameterArtifacts", 
         processingEvents = @PortletQName(
               localPart = "AnnotationPortletArtifactValidityTests_SPEC3_20_ParameterArtifacts", 
               namespaceURI = "http://www.apache.org/portals/pluto/portlet-tck_3.0"))
   public void processEvent(EventRequest portletReq, EventResponse portletResp)
         throws PortletException, IOException {

      System.out.println("EventMethod");
      boolean actonParamArtifactValidator = false;
      try{
         if (actionParameters == null) {
            actonParamArtifactValidator = true;
         } else {
            actonParamArtifactValidator = false;
         }
      } catch (RuntimeException e){
         actonParamArtifactValidator = true;
         e.printStackTrace();
      }
      portletSession.setAttribute(
            portletName + ACTIONPARAMETERARTIFACTKEY + EVENTPHASE,
            actonParamArtifactValidator, PORTLET_SCOPE);
      
      boolean renderParamArtifactValidator = false;
      try{
         if (renderParameters == null) {
            renderParamArtifactValidator = true;
         } else {
            renderParamArtifactValidator = false;
         }
      } catch (RuntimeException e){
         renderParamArtifactValidator = true;
         e.printStackTrace();
      }
      portletSession.setAttribute(
            portletName + RENDERPARAMETERARTIFACTKEY + EVENTPHASE,
            renderParamArtifactValidator, PORTLET_SCOPE);
      
      MutableRenderParameters renderParams = portletResp.getRenderParameters();
      renderParams.setValue("tr0", "true");

   }

   public String createTable(boolean actionValidator, boolean eventValidator,
         boolean headerValidator, boolean renderValidator,
         boolean resourceValidator) {
      StringBuilder txt = new StringBuilder();
      txt.append("<p>Debug Info: ");
      txt.append("<table>");
      txt.append("   <tr>");
      txt.append("      <td>Action</td>");
      txt.append("      <td>Event</td>");
      txt.append("      <td>Header</td>");
      txt.append("      <td>Render</td>");
      txt.append("      <td>Resource</td>");
      txt.append("   </tr>");
      txt.append("   <tr>");
      txt.append("      <td>" + actionValidator + "</td>");
      txt.append("      <td>" + eventValidator + "</td>");
      txt.append("      <td>" + headerValidator + "</td>");
      txt.append("      <td>" + renderValidator + "</td>");
      txt.append("      <td>" + resourceValidator + "</td>");
      txt.append("   </tr>");
      txt.append("</table>");
      txt.append("</p>");
      return txt.toString();
   }


}
