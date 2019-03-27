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

package javax.portlet.tck.portlets.cdi;

import static javax.portlet.PortletSession.PORTLET_SCOPE;
import static javax.portlet.ResourceURL.PAGE;
import static javax.portlet.tck.portlets.Utils.ACTIONPHASE;
import static javax.portlet.tck.portlets.Utils.CONTEXTPATHARTIFACTKEY;
import static javax.portlet.tck.portlets.Utils.EVENTPHASE;
import static javax.portlet.tck.portlets.Utils.HEADERPHASE;
import static javax.portlet.tck.portlets.Utils.NAMESPACEARTIFACTKEY;
import static javax.portlet.tck.portlets.Utils.PORTLETCONFIGARTIFACTKEY;
import static javax.portlet.tck.portlets.Utils.PORTLETCONTEXTARTIFACTKEY;
import static javax.portlet.tck.portlets.Utils.PORTLETMODEARTIFACTKEY;
import static javax.portlet.tck.portlets.Utils.PORTLETNAMEARTIFACTKEY;
import static javax.portlet.tck.portlets.Utils.PORTLETPREFERENCESARTIFACTKEY;
import static javax.portlet.tck.portlets.Utils.PORTLETSESSIONARTIFACTKEY;
import static javax.portlet.tck.portlets.Utils.RENDERPHASE;
import static javax.portlet.tck.portlets.Utils.WINDOWIDARTIFACTKEY;
import static javax.portlet.tck.portlets.Utils.WINDOWSTATEARTIFACTKEY;
import static javax.portlet.tck.portlets.Utils.COOKIESARTIFACTKEY;
import static javax.portlet.tck.portlets.Utils.LOCALESARTIFACTKEY;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_CONTEXTPATH;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_COOKIES;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_LOCALES;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_NAMESPACE;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_PORTLETCONFIG;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_PORTLETCONTEXT;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_PORTLETMODE;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_PORTLETNAME;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_PORTLETPREFERENCES;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_PORTLETSESSION;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_WINDOWID;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_WINDOWSTATE;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.ActionURL;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.HeaderRequest;
import javax.portlet.HeaderResponse;
import javax.portlet.MutableRenderParameters;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletSession;
import javax.portlet.RenderParameters;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceURL;
import javax.portlet.WindowState;
import javax.portlet.annotations.ActionMethod;
import javax.portlet.annotations.EventDefinition;
import javax.portlet.annotations.EventMethod;
import javax.portlet.annotations.HeaderMethod;
import javax.portlet.annotations.PortletApplication;
import javax.portlet.annotations.PortletConfiguration;
import javax.portlet.annotations.PortletQName;
import javax.portlet.annotations.RenderMethod;
import javax.portlet.annotations.ServeResourceMethod;
import javax.portlet.tck.beans.TestButton;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.portlets.ArtifactValidationResult;
import javax.portlet.tck.portlets.PortletRequestScopedArtifacts;
import javax.portlet.tck.portlets.Utils;
import javax.portlet.tck.util.ModuleTestCaseDetails;
import javax.servlet.http.Cookie;
import javax.xml.namespace.QName;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import static javax.portlet.PortletSession.PORTLET_SCOPE;
import static javax.portlet.ResourceURL.PAGE;
import static javax.portlet.tck.portlets.Utils.ACTIONPHASE;
import static javax.portlet.tck.portlets.Utils.CONTEXTPATHARTIFACTKEY;
import static javax.portlet.tck.portlets.Utils.COOKIESARTIFACTKEY;
import static javax.portlet.tck.portlets.Utils.EVENTPHASE;
import static javax.portlet.tck.portlets.Utils.HEADERPHASE;
import static javax.portlet.tck.portlets.Utils.LOCALESARTIFACTKEY;
import static javax.portlet.tck.portlets.Utils.NAMESPACEARTIFACTKEY;
import static javax.portlet.tck.portlets.Utils.PORTLETCONFIGARTIFACTKEY;
import static javax.portlet.tck.portlets.Utils.PORTLETCONTEXTARTIFACTKEY;
import static javax.portlet.tck.portlets.Utils.PORTLETMODEARTIFACTKEY;
import static javax.portlet.tck.portlets.Utils.PORTLETNAMEARTIFACTKEY;
import static javax.portlet.tck.portlets.Utils.PORTLETPREFERENCESARTIFACTKEY;
import static javax.portlet.tck.portlets.Utils.PORTLETSESSIONARTIFACTKEY;
import static javax.portlet.tck.portlets.Utils.RENDERPHASE;
import static javax.portlet.tck.portlets.Utils.WINDOWIDARTIFACTKEY;
import static javax.portlet.tck.portlets.Utils.WINDOWSTATEARTIFACTKEY;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_CONTEXTPATH;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_COOKIES;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_LOCALES;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_NAMESPACE;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_PORTLETCONFIG;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_PORTLETCONTEXT;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_PORTLETMODE;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_PORTLETNAME;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_PORTLETPREFERENCES;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_PORTLETSESSION;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_WINDOWID;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_WINDOWSTATE;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the 
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 *
 */

@PortletConfiguration(
   portletName = "AnnotationPortletArtifactValidityTests_SPEC3_20_PortletArtifacts",
   supportedLocales = {"en_US", "de"}
)
public class AnnotationPortletArtifactValidityTests_SPEC3_20_PortletArtifacts implements Portlet {
   
   private Utils utils = new Utils();

   private PortletConfig initPortletConfig = null;
   
   // Test artifacts
   
   @Inject
   private PortletConfig portletConfig;
   
   @Inject
   private PortletContext portletContext;
   
   @Inject
   private PortletMode portletMode;
   
   @Inject
   private WindowState windowState;
   
   @Inject
   private PortletPreferences portletPreferences;
   
   @Inject
   private List<Cookie> cookies;
   
   @Inject
   private PortletSession          portletSession;
   
   @Inject
   private List<Locale> locales;
   
   @Inject
   private PortletRequestScopedArtifacts portletRequestScopedArtifacts;
   
   @HeaderMethod(
      portletNames = { "AnnotationPortletArtifactValidityTests_SPEC3_20_PortletArtifacts" }
   )
   public void renderHeaders(HeaderRequest portletReq,
           HeaderResponse portletResp) {
      
      try {
         setAttribute(PORTLETCONFIGARTIFACTKEY, HEADERPHASE,
               utils.checkEqualConfigs(portletConfig, initPortletConfig));
      } catch (RuntimeException e) {
         setAttribute(PORTLETCONFIGARTIFACTKEY, HEADERPHASE, false);
      }

      try {
         setAttribute(PORTLETCONTEXTARTIFACTKEY, HEADERPHASE,
               utils.checkEqualContexts(portletContext, portletReq.getPortletContext()));
      } catch (RuntimeException e) {
         setAttribute(PORTLETCONTEXTARTIFACTKEY, HEADERPHASE, false);
      }

      try {
         setAttribute(PORTLETMODEARTIFACTKEY, HEADERPHASE,
               portletMode.toString().equals(portletReq.getPortletMode().toString()));
      } catch (RuntimeException e) {
         setAttribute(PORTLETMODEARTIFACTKEY, HEADERPHASE, false);
      }

      try {
         setAttribute(WINDOWSTATEARTIFACTKEY, HEADERPHASE,
               windowState.toString().equals(portletReq.getWindowState().toString()));
      } catch (RuntimeException e) {
         setAttribute(WINDOWSTATEARTIFACTKEY, HEADERPHASE, false);
      }
      
      try {
         setAttribute(PORTLETPREFERENCESARTIFACTKEY, HEADERPHASE,
               utils.checkEqualPreferences(portletPreferences, portletReq.getPreferences()));
      } catch (RuntimeException e) {
         setAttribute(PORTLETPREFERENCESARTIFACTKEY, HEADERPHASE, false);
      }
      
      try {
         setAttribute(PORTLETSESSIONARTIFACTKEY, HEADERPHASE,
               utils.checkEqualSessions(portletSession, portletReq.getPortletSession()));
      } catch (RuntimeException e) {
         setAttribute(PORTLETSESSIONARTIFACTKEY, HEADERPHASE, false);
      }
      
      try {
         setAttribute(NAMESPACEARTIFACTKEY, HEADERPHASE,
               portletResp.getNamespace().equals(portletRequestScopedArtifacts.getNamespace()));
      } catch (RuntimeException e) {
         setAttribute(NAMESPACEARTIFACTKEY, HEADERPHASE, false);
      }
      
      try {
         setAttribute(CONTEXTPATHARTIFACTKEY, HEADERPHASE,
               portletContext.getContextPath().equals(portletRequestScopedArtifacts.getContextPath()));
      } catch (RuntimeException e) {
         setAttribute(CONTEXTPATHARTIFACTKEY, HEADERPHASE, false);
      }
      
      try {
         setAttribute(WINDOWIDARTIFACTKEY, HEADERPHASE,
               portletReq.getWindowID().equals(portletRequestScopedArtifacts.getWindowId()));
      } catch (RuntimeException e) {
         setAttribute(WINDOWIDARTIFACTKEY, HEADERPHASE, false);
      }
      
      try {
         setAttribute(PORTLETNAMEARTIFACTKEY, HEADERPHASE,
               portletConfig.getPortletName().equals(portletRequestScopedArtifacts.getPortletName()));
      } catch (RuntimeException e) {
         setAttribute(PORTLETNAMEARTIFACTKEY, HEADERPHASE, false);
      }
      
      try {
         setAttribute(COOKIESARTIFACTKEY, HEADERPHASE,
               utils.checkEqualCollection(cookies, Arrays.asList(portletReq.getCookies())));
      } catch (RuntimeException e) {
         setAttribute(COOKIESARTIFACTKEY, HEADERPHASE, false);
      }
      
      try {
         setAttribute(LOCALESARTIFACTKEY, HEADERPHASE,
               utils.checkEqualCollection(locales, Collections.list(portletReq.getLocales())));
      } catch (RuntimeException e) {
         setAttribute(LOCALESARTIFACTKEY, HEADERPHASE, false);
      }
      
      /*
       * TODO: Uncomment, implement, and copy paste after fixing
      
      try {
         setAttribute(LOCALEARTIFACTKEY, HEADERPHASE,
               utils.isValid(locale));
      } catch (RuntimeException e) {
         setAttribute(LOCALEARTIFACTKEY, HEADERPHASE, false);
      }
      
      */
      
   }

   @ActionMethod(
      portletName = "AnnotationPortletArtifactValidityTests_SPEC3_20_PortletArtifacts", 
      publishingEvents = @PortletQName(
         localPart = "AnnotationPortletArtifactValidityTests_SPEC3_20_PortletArtifacts", 
         namespaceURI = "http://www.apache.org/portals/pluto/portlet-tck_3.0"
      )
   )
   public void processAction(ActionRequest portletReq,
         ActionResponse portletResp) throws PortletException, IOException {
      
      try {
         setAttribute(PORTLETCONFIGARTIFACTKEY, ACTIONPHASE,
               utils.checkEqualConfigs(portletConfig, initPortletConfig));
      } catch (RuntimeException e) {
         setAttribute(PORTLETCONFIGARTIFACTKEY, ACTIONPHASE, false);
      }

      try {
         setAttribute(PORTLETCONTEXTARTIFACTKEY, ACTIONPHASE,
               utils.checkEqualContexts(portletContext, portletReq.getPortletContext()));
      } catch (RuntimeException e) {
         setAttribute(PORTLETCONTEXTARTIFACTKEY, ACTIONPHASE, false);
      }

      try {
         setAttribute(PORTLETMODEARTIFACTKEY, ACTIONPHASE,
               portletMode.toString().equals(portletReq.getPortletMode().toString()));
      } catch (RuntimeException e) {
         setAttribute(PORTLETMODEARTIFACTKEY, ACTIONPHASE, false);
      }

      try {
         setAttribute(WINDOWSTATEARTIFACTKEY, ACTIONPHASE,
               windowState.toString().equals(portletReq.getWindowState().toString()));
      } catch (RuntimeException e) {
         setAttribute(WINDOWSTATEARTIFACTKEY, ACTIONPHASE, false);
      }
      
      try {
         setAttribute(PORTLETPREFERENCESARTIFACTKEY, ACTIONPHASE,
               utils.checkEqualPreferences(portletPreferences, portletReq.getPreferences()));
      } catch (RuntimeException e) {
         setAttribute(PORTLETPREFERENCESARTIFACTKEY, ACTIONPHASE, false);
      }
      
      try {
         setAttribute(PORTLETSESSIONARTIFACTKEY, ACTIONPHASE,
               utils.checkEqualSessions(portletSession, portletReq.getPortletSession()));
      } catch (RuntimeException e) {
         setAttribute(PORTLETSESSIONARTIFACTKEY, ACTIONPHASE, false);
      }
      
      try {
         setAttribute(NAMESPACEARTIFACTKEY, ACTIONPHASE,
               portletResp.getNamespace().equals(portletRequestScopedArtifacts.getNamespace()));
      } catch (RuntimeException e) {
         setAttribute(NAMESPACEARTIFACTKEY, ACTIONPHASE, false);
      }
      
      try {
         setAttribute(CONTEXTPATHARTIFACTKEY, ACTIONPHASE,
               portletContext.getContextPath().equals(portletRequestScopedArtifacts.getContextPath()));
      } catch (RuntimeException e) {
         setAttribute(CONTEXTPATHARTIFACTKEY, ACTIONPHASE, false);
      }
      
      try {
         setAttribute(WINDOWIDARTIFACTKEY, ACTIONPHASE,
               portletReq.getWindowID().equals(portletRequestScopedArtifacts.getWindowId()));
      } catch (RuntimeException e) {
         setAttribute(WINDOWIDARTIFACTKEY, ACTIONPHASE, false);
      }
      
      try {
         setAttribute(PORTLETNAMEARTIFACTKEY, ACTIONPHASE,
               portletConfig.getPortletName().equals(portletRequestScopedArtifacts.getPortletName()));
      } catch (RuntimeException e) {
         setAttribute(PORTLETNAMEARTIFACTKEY, ACTIONPHASE, false);
      }
      
      try {
         setAttribute(COOKIESARTIFACTKEY, ACTIONPHASE,
               utils.checkEqualCollection(cookies, Arrays.asList(portletReq.getCookies())));
      } catch (RuntimeException e) {
         setAttribute(COOKIESARTIFACTKEY, ACTIONPHASE, false);
      }
      
      try {
         setAttribute(LOCALESARTIFACTKEY, ACTIONPHASE,
               utils.checkEqualCollection(locales, Collections.list(portletReq.getLocales())));
      } catch (RuntimeException e) {
         setAttribute(LOCALESARTIFACTKEY, ACTIONPHASE, false);
      }
      
      QName eventQName = new QName(
            "http://www.apache.org/portals/pluto/portlet-tck_3.0",
            "AnnotationPortletArtifactValidityTests_SPEC3_20_PortletArtifacts");
      portletResp.setEvent(eventQName, "Hi!");
      
   }

   @RenderMethod(
      portletNames = { "AnnotationPortletArtifactValidityTests_SPEC3_20_PortletArtifacts" }
   )
   public void render(RenderRequest portletReq, RenderResponse portletResp)
          throws PortletException, IOException {

      PrintWriter writer = portletResp.getWriter();
      
      try {
         setAttribute(PORTLETCONFIGARTIFACTKEY, RENDERPHASE,
               utils.checkEqualConfigs(portletConfig, initPortletConfig));
      } catch (RuntimeException e) {
         setAttribute(PORTLETCONFIGARTIFACTKEY, RENDERPHASE, false);
      }

      try {
         setAttribute(PORTLETCONTEXTARTIFACTKEY, RENDERPHASE,
               utils.checkEqualContexts(portletContext, portletReq.getPortletContext()));
      } catch (RuntimeException e) {
         setAttribute(PORTLETCONTEXTARTIFACTKEY, RENDERPHASE, false);
      }

      try {
         setAttribute(PORTLETMODEARTIFACTKEY, RENDERPHASE,
               portletMode.toString().equals(portletReq.getPortletMode().toString()));
      } catch (RuntimeException e) {
         setAttribute(PORTLETMODEARTIFACTKEY, RENDERPHASE, false);
      }

      try {
         setAttribute(WINDOWSTATEARTIFACTKEY, RENDERPHASE,
               windowState.toString().equals(portletReq.getWindowState().toString()));
      } catch (RuntimeException e) {
         setAttribute(WINDOWSTATEARTIFACTKEY, RENDERPHASE, false);
      }
      
      try {
         setAttribute(PORTLETPREFERENCESARTIFACTKEY, RENDERPHASE,
               utils.checkEqualPreferences(portletPreferences, portletReq.getPreferences()));
      } catch (RuntimeException e) {
         setAttribute(PORTLETPREFERENCESARTIFACTKEY, RENDERPHASE, false);
      }
      
      try {
         setAttribute(PORTLETSESSIONARTIFACTKEY, RENDERPHASE,
               utils.checkEqualSessions(portletSession, portletReq.getPortletSession()));
      } catch (RuntimeException e) {
         setAttribute(PORTLETSESSIONARTIFACTKEY, RENDERPHASE, false);
      }
      
      try {
         setAttribute(NAMESPACEARTIFACTKEY, RENDERPHASE,
               portletResp.getNamespace().equals(portletRequestScopedArtifacts.getNamespace()));
      } catch (RuntimeException e) {
         setAttribute(NAMESPACEARTIFACTKEY, RENDERPHASE, false);
      }
      
      try {
         setAttribute(CONTEXTPATHARTIFACTKEY, RENDERPHASE,
               portletContext.getContextPath().equals(portletRequestScopedArtifacts.getContextPath()));
      } catch (RuntimeException e) {
         setAttribute(CONTEXTPATHARTIFACTKEY, RENDERPHASE, false);
      }
      
      try {
         setAttribute(WINDOWIDARTIFACTKEY, RENDERPHASE,
               portletReq.getWindowID().equals(portletRequestScopedArtifacts.getWindowId()));
      } catch (RuntimeException e) {
         setAttribute(WINDOWIDARTIFACTKEY, RENDERPHASE, false);
      }
      
      try {
         setAttribute(PORTLETNAMEARTIFACTKEY, RENDERPHASE,
               portletConfig.getPortletName().equals(portletRequestScopedArtifacts.getPortletName()));
      } catch (RuntimeException e) {
         setAttribute(PORTLETNAMEARTIFACTKEY, RENDERPHASE, false);
      }
      
      try {
         setAttribute(COOKIESARTIFACTKEY, RENDERPHASE,
               utils.checkEqualCollection(cookies, Arrays.asList(portletReq.getCookies())));
      } catch (RuntimeException e) {
         setAttribute(COOKIESARTIFACTKEY, RENDERPHASE, false);
      }
      
      try {
         setAttribute(LOCALESARTIFACTKEY, RENDERPHASE,
               utils.checkEqualCollection(locales, Collections.list(portletReq.getLocales())));
      } catch (RuntimeException e) {
         setAttribute(LOCALESARTIFACTKEY, RENDERPHASE, false);
      }
      
      writer.write(
            "<div id=\"AnnotationPortletArtifactValidityTests_SPEC3_20_PortletArtifacts\">no resource output.</div>\n");
      ResourceURL resurl = portletResp.createResourceURL();
      resurl.setCacheability(PAGE);
      writer.write("<script>\n");
      writer.write("(function () {\n");
      writer.write("   var xhr = new XMLHttpRequest();\n");
      writer.write("   xhr.onreadystatechange=function() {\n");
      writer.write("      if (xhr.readyState==4 && xhr.status==200) {\n");
      writer.write(
            "         document.getElementById(\"AnnotationPortletArtifactValidityTests_SPEC3_20_PortletArtifacts\").innerHTML=xhr.responseText;\n");
      writer.write("      }\n");
      writer.write("   };\n");
      writer.write(
            "   xhr.open(\"GET\",\"" + resurl.toString() + "\",true);\n");
      writer.write("   xhr.send();\n");
      writer.write("})();\n");
      writer.write("</script>\n");

   }
   
   @ServeResourceMethod(
      portletNames = { "AnnotationPortletArtifactValidityTests_SPEC3_20_PortletArtifacts" }
   )
   public void serveResource(ResourceRequest portletReq,
           ResourceResponse portletResp) throws PortletException, IOException {
      
      PrintWriter writer = portletResp.getWriter();
      ModuleTestCaseDetails tcd = new ModuleTestCaseDetails();
      RenderParameters renderParameters = portletReq.getRenderParameters();
      
      /* TestCase: V3AnnotationPortletArtifactValidityTests_SPEC3_20_PortletArtifacts_portletConfig */
      /* Details: "PortletConfig artifact is valid during all phases."              */
      if (renderParameters.getValue("tr0") != null
            && renderParameters.getValue("tr0").equals("true")) {
         TestResult result = tcd.getTestResultFailed(
               V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_PORTLETCONFIG);
         ArtifactValidationResult validationResult = getValidationTestResult(
               PORTLETCONFIGARTIFACTKEY);
         try {
            validationResult.setArtifactValidInResourcePhase(
                  utils.checkEqualConfigs(portletConfig, initPortletConfig));
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
               V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_PORTLETCONFIG,
               aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V3AnnotationPortletArtifactValidityTests_SPEC3_20_PortletArtifacts_portletContext */
      /* Details: "PortletContext artifact is valid during all phases."             */
      if (renderParameters.getValue("tr1") != null
            && renderParameters.getValue("tr1").equals("true")) {
         TestResult result = tcd.getTestResultFailed(
               V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_PORTLETCONTEXT);
         ArtifactValidationResult validationResult = getValidationTestResult(
               PORTLETCONTEXTARTIFACTKEY);
         try {
            validationResult.setArtifactValidInResourcePhase(
                  utils.checkEqualContexts(portletContext, portletReq.getPortletContext()));
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
               V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_PORTLETCONTEXT,
               aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V3AnnotationPortletArtifactValidityTests_SPEC3_20_PortletArtifacts_portletMode */
      /* Details: "PortletMode artifact is valid during all phases."                */
      if (renderParameters.getValue("tr2") != null
            && renderParameters.getValue("tr2").equals("true")) {
         TestResult result = tcd.getTestResultFailed(
               V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_PORTLETMODE);
         ArtifactValidationResult validationResult = getValidationTestResult(
               PORTLETMODEARTIFACTKEY);
         try {
            validationResult.setArtifactValidInResourcePhase(
                  portletMode.toString().equals(portletReq.getPortletMode().toString()));
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
               V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_PORTLETMODE,
               aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V3AnnotationPortletArtifactValidityTests_SPEC3_20_PortletArtifacts_windowState */
      /* Details: "WindowState artifact is valid during all phases."                */
      if (renderParameters.getValue("tr3") != null
            && renderParameters.getValue("tr3").equals("true")) {
         TestResult result = tcd.getTestResultFailed(
               V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_WINDOWSTATE);
         ArtifactValidationResult validationResult = getValidationTestResult(
               WINDOWSTATEARTIFACTKEY);
         try {
            validationResult.setArtifactValidInResourcePhase(
                  windowState.toString().equals(portletReq.getWindowState().toString()));
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
               V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_WINDOWSTATE,
               aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V3AnnotationPortletArtifactValidityTests_SPEC3_20_PortletArtifacts_portletPreferences */
      /* Details: "PortletPreferences artifact is valid during all phases."         */
      if (renderParameters.getValue("tr4") != null
            && renderParameters.getValue("tr4").equals("true")) {
         TestResult result = tcd.getTestResultFailed(
               V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_PORTLETPREFERENCES);
         ArtifactValidationResult validationResult = getValidationTestResult(
               PORTLETPREFERENCESARTIFACTKEY);
         try {
            validationResult.setArtifactValidInResourcePhase(
                  utils.checkEqualPreferences(portletPreferences, portletReq.getPreferences()));
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
               V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_PORTLETPREFERENCES,
               aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V3AnnotationPortletArtifactValidityTests_SPEC3_20_PortletArtifacts_portletSession */
      /* Details: "PortletSession artifact is valid during all phases."             */
      if (renderParameters.getValue("tr5") != null
            && renderParameters.getValue("tr5").equals("true")) {
         TestResult result = tcd.getTestResultFailed(
               V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_PORTLETSESSION);
         ArtifactValidationResult validationResult = getValidationTestResult(
               PORTLETSESSIONARTIFACTKEY);
         try {
            validationResult.setArtifactValidInResourcePhase(
                  utils.checkEqualSessions(portletSession, portletReq.getPortletSession()));
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
               V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_PORTLETSESSION,
               aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V3AnnotationPortletArtifactValidityTests_SPEC3_20_PortletArtifacts_namespace */
      /* Details: "Namespace artifact is valid during all phases."                  */
      if (renderParameters.getValue("tr6") != null
            && renderParameters.getValue("tr6").equals("true")) {
         TestResult result = tcd.getTestResultFailed(
               V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_NAMESPACE);
         ArtifactValidationResult validationResult = getValidationTestResult(
               NAMESPACEARTIFACTKEY);
         try {
            validationResult.setArtifactValidInResourcePhase(
                  portletResp.getNamespace().equals(portletRequestScopedArtifacts.getNamespace()));
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
               V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_NAMESPACE,
               aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V3AnnotationPortletArtifactValidityTests_SPEC3_20_PortletArtifacts_contextPath */
      /* Details: "ContextPath artifact is valid during all phases."                */
      if (renderParameters.getValue("tr7") != null
            && renderParameters.getValue("tr7").equals("true")) {
         TestResult result = tcd.getTestResultFailed(
               V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_CONTEXTPATH);
         ArtifactValidationResult validationResult = getValidationTestResult(
               CONTEXTPATHARTIFACTKEY);
         try {
            validationResult.setArtifactValidInResourcePhase(
                  portletContext.getContextPath().equals(portletRequestScopedArtifacts.getContextPath()));
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
               V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_CONTEXTPATH,
               aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V3AnnotationPortletArtifactValidityTests_SPEC3_20_PortletArtifacts_windowID */
      /* Details: "WindowID artifact is valid during all phases."                   */
      if (renderParameters.getValue("tr8") != null
            && renderParameters.getValue("tr8").equals("true")) {
         TestResult result = tcd.getTestResultFailed(
               V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_WINDOWID);
         ArtifactValidationResult validationResult = getValidationTestResult(
               WINDOWIDARTIFACTKEY);
         try {
            validationResult.setArtifactValidInResourcePhase(
                  portletReq.getWindowID().equals(portletRequestScopedArtifacts.getWindowId()));
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
               V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_WINDOWID,
               aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V3AnnotationPortletArtifactValidityTests_SPEC3_20_PortletArtifacts_portletName */
      /* Details: "PortletName artifact is valid during all phases."                */
      if (renderParameters.getValue("tr9") != null
            && renderParameters.getValue("tr9").equals("true")) {
         TestResult result = tcd.getTestResultFailed(
               V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_PORTLETNAME);
         ArtifactValidationResult validationResult = getValidationTestResult(
               PORTLETNAMEARTIFACTKEY);
         try {
            validationResult.setArtifactValidInResourcePhase(
                  portletConfig.getPortletName().equals(portletRequestScopedArtifacts.getPortletName()));
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
               V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_PORTLETNAME,
               aurl);
         tb.writeTo(writer);
      }
      
      /* TestCase: V3AnnotationPortletArtifactValidityTests_SPEC3_20_PortletArtifacts_cookies */
      /* Details: "Cookies artifact is valid during all phases."                    */
      if (renderParameters.getValue("tr10") != null
            && renderParameters.getValue("tr10").equals("true")) {
         TestResult result = tcd.getTestResultFailed(
               V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_COOKIES);
         ArtifactValidationResult validationResult = getValidationTestResult(
               COOKIESARTIFACTKEY);
         try {
            validationResult.setArtifactValidInResourcePhase(
                  utils.checkEqualCollection(cookies, Arrays.asList(portletReq.getCookies())));
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
               V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_COOKIES,
               aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V3AnnotationPortletArtifactValidityTests_SPEC3_20_PortletArtifacts_locales */
      /* Details: "Locales artifact is valid during all phases."                    */
      if (renderParameters.getValue("tr12") != null
            && renderParameters.getValue("tr12").equals("true")) {
         TestResult result = tcd.getTestResultFailed(
               V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_LOCALES);
         ArtifactValidationResult validationResult = getValidationTestResult(
               LOCALESARTIFACTKEY);
         try {
            validationResult.setArtifactValidInResourcePhase(
                  utils.checkEqualCollection(locales, Collections.list(portletReq.getLocales())));
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
               V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_LOCALES,
               aurl);
         tb.writeTo(writer);
      }
      
   }
   
   @EventMethod(
      portletName = "AnnotationPortletArtifactValidityTests_SPEC3_20_PortletArtifacts", 
      processingEvents = @PortletQName(
         localPart = "AnnotationPortletArtifactValidityTests_SPEC3_20_PortletArtifacts", 
         namespaceURI = "http://www.apache.org/portals/pluto/portlet-tck_3.0"
      )
   )
   public void processEvent(EventRequest portletReq, EventResponse portletResp)
               throws PortletException, IOException {
      
      MutableRenderParameters mutableRenderParameters = portletResp.getRenderParameters();
      
      try {
         setAttribute(PORTLETCONFIGARTIFACTKEY, EVENTPHASE,
               utils.checkEqualConfigs(portletConfig, initPortletConfig));
      } catch (RuntimeException e) {
         setAttribute(PORTLETCONFIGARTIFACTKEY, EVENTPHASE, false);
      }
      mutableRenderParameters.setValue("tr0", "true");

      try {
         setAttribute(PORTLETCONTEXTARTIFACTKEY, EVENTPHASE,
               utils.checkEqualContexts(portletContext, portletReq.getPortletContext()));
      } catch (RuntimeException e) {
         setAttribute(PORTLETCONTEXTARTIFACTKEY, EVENTPHASE, false);
      }
      mutableRenderParameters.setValue("tr1", "true");

      try {
         setAttribute(PORTLETMODEARTIFACTKEY, EVENTPHASE,
               portletMode.toString().equals(portletReq.getPortletMode().toString()));
      } catch (RuntimeException e) {
         setAttribute(PORTLETMODEARTIFACTKEY, EVENTPHASE, false);
      }
      mutableRenderParameters.setValue("tr2", "true");

      try {
         setAttribute(WINDOWSTATEARTIFACTKEY, EVENTPHASE,
               windowState.toString().equals(portletReq.getWindowState().toString()));
      } catch (RuntimeException e) {
         setAttribute(WINDOWSTATEARTIFACTKEY, EVENTPHASE, false);
      }
      mutableRenderParameters.setValue("tr3", "true");
      
      try {
         setAttribute(PORTLETPREFERENCESARTIFACTKEY, EVENTPHASE,
               utils.checkEqualPreferences(portletPreferences, portletReq.getPreferences()));
      } catch (RuntimeException e) {
         setAttribute(PORTLETPREFERENCESARTIFACTKEY, EVENTPHASE, false);
      }
      mutableRenderParameters.setValue("tr4", "true");
      
      try {
         setAttribute(PORTLETSESSIONARTIFACTKEY, EVENTPHASE,
               utils.checkEqualSessions(portletSession, portletReq.getPortletSession()));
      } catch (RuntimeException e) {
         setAttribute(PORTLETSESSIONARTIFACTKEY, EVENTPHASE, false);
      }
      mutableRenderParameters.setValue("tr5", "true");
      
      try {
         setAttribute(NAMESPACEARTIFACTKEY, EVENTPHASE,
               portletResp.getNamespace().equals(portletRequestScopedArtifacts.getNamespace()));
      } catch (RuntimeException e) {
         setAttribute(NAMESPACEARTIFACTKEY, EVENTPHASE, false);
      }
      mutableRenderParameters.setValue("tr6", "true");
      
      try {
         setAttribute(CONTEXTPATHARTIFACTKEY, EVENTPHASE,
               portletContext.getContextPath().equals(portletRequestScopedArtifacts.getContextPath()));
      } catch (RuntimeException e) {
         setAttribute(CONTEXTPATHARTIFACTKEY, EVENTPHASE, false);
      }
      mutableRenderParameters.setValue("tr7", "true");
      
      try {
         setAttribute(WINDOWIDARTIFACTKEY, EVENTPHASE,
               portletReq.getWindowID().equals(portletRequestScopedArtifacts.getWindowId()));
      } catch (RuntimeException e) {
         setAttribute(WINDOWIDARTIFACTKEY, EVENTPHASE, false);
      }
      mutableRenderParameters.setValue("tr8", "true");
      
      try {
         setAttribute(PORTLETNAMEARTIFACTKEY, EVENTPHASE,
               portletConfig.getPortletName().equals(portletRequestScopedArtifacts.getPortletName()));
      } catch (RuntimeException e) {
         setAttribute(PORTLETNAMEARTIFACTKEY, EVENTPHASE, false);
      }
      mutableRenderParameters.setValue("tr9", "true");
      
      try {
         setAttribute(COOKIESARTIFACTKEY, EVENTPHASE,
               utils.checkEqualCollection(cookies, Arrays.asList(portletReq.getCookies())));
      } catch (RuntimeException e) {
         setAttribute(COOKIESARTIFACTKEY, EVENTPHASE, false);
      }
      mutableRenderParameters.setValue("tr10", "true");
      
      try {
         setAttribute(LOCALESARTIFACTKEY, EVENTPHASE,
               utils.checkEqualCollection(locales, Collections.list(portletReq.getLocales())));
      } catch (RuntimeException e) {
         setAttribute(LOCALESARTIFACTKEY, EVENTPHASE, false);
      }
      mutableRenderParameters.setValue("tr12", "true");
  
   }
   
   public void setAttribute(String artifactKey, String phase,
         boolean validity) {

      portletSession.setAttribute(portletRequestScopedArtifacts.getPortletName() + artifactKey + phase, validity,
            PORTLET_SCOPE);

   }

   private ArtifactValidationResult getValidationTestResult(
         String artifactKey) {
      boolean artifactInActionPhase = (boolean) portletSession.getAttribute(
            portletRequestScopedArtifacts.getPortletName() + artifactKey + ACTIONPHASE, PORTLET_SCOPE);
      boolean artifactInRenderPhase = (boolean) portletSession.getAttribute(
            portletRequestScopedArtifacts.getPortletName() + artifactKey + RENDERPHASE, PORTLET_SCOPE);
      boolean artifactInHeaderPhase = (boolean) portletSession.getAttribute(
            portletRequestScopedArtifacts.getPortletName() + artifactKey + HEADERPHASE, PORTLET_SCOPE);
      boolean artifactInEventPhase = (boolean) portletSession.getAttribute(
            portletRequestScopedArtifacts.getPortletName() + artifactKey + EVENTPHASE, PORTLET_SCOPE);
      return new ArtifactValidationResult(artifactInHeaderPhase,
            artifactInRenderPhase, artifactInActionPhase, artifactInEventPhase);
   }
   
   @Override
   public void init(PortletConfig config) throws PortletException {
      initPortletConfig = config;
   }

   @Override
   public void destroy() {
      
   }
   
}
