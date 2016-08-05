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

@PortletConfiguration(portletName = "AnnotationPortletArtifactValidityTests_SPEC3_20_PortletArtifacts")
public class AnnotationPortletArtifactValidityTests_SPEC3_20_PortletArtifacts implements Portlet {
   
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

      /* TestCase: V3AnnotationPortletArtifactValidityTests_SPEC3_20_PortletArtifacts_portletConfig */
      /* Details: "PortletConfig artifact is valid during all phases."              */
      {
         TestResult result = tcd.getTestResultFailed(V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_PORTLETCONFIG);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3AnnotationPortletArtifactValidityTests_SPEC3_20_PortletArtifacts_portletContext */
      /* Details: "PortletContext artifact is valid during all phases."             */
      {
         TestResult result = tcd.getTestResultFailed(V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_PORTLETCONTEXT);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3AnnotationPortletArtifactValidityTests_SPEC3_20_PortletArtifacts_portletMode */
      /* Details: "PortletMode artifact is valid during all phases."                */
      {
         TestResult result = tcd.getTestResultFailed(V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_PORTLETMODE);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3AnnotationPortletArtifactValidityTests_SPEC3_20_PortletArtifacts_windowState */
      /* Details: "WindowState artifact is valid during all phases."                */
      {
         TestResult result = tcd.getTestResultFailed(V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_WINDOWSTATE);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3AnnotationPortletArtifactValidityTests_SPEC3_20_PortletArtifacts_portletPreferences */
      /* Details: "PortletPreferences artifact is valid during all phases."         */
      {
         TestResult result = tcd.getTestResultFailed(V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_PORTLETPREFERENCES);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3AnnotationPortletArtifactValidityTests_SPEC3_20_PortletArtifacts_cookies */
      /* Details: "Cookies artifact is valid during all phases."                    */
      {
         TestResult result = tcd.getTestResultFailed(V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_COOKIES);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3AnnotationPortletArtifactValidityTests_SPEC3_20_PortletArtifacts_portletSession */
      /* Details: "PortletSession artifact is valid during all phases."             */
      {
         TestResult result = tcd.getTestResultFailed(V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_PORTLETSESSION);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3AnnotationPortletArtifactValidityTests_SPEC3_20_PortletArtifacts_locale */
      /* Details: "Locale artifact is only valid during render and resource phase." */
      {
         TestResult result = tcd.getTestResultFailed(V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_LOCALE);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3AnnotationPortletArtifactValidityTests_SPEC3_20_PortletArtifacts_locales */
      /* Details: "Locales artifact is valid during all phases."                    */
      {
         TestResult result = tcd.getTestResultFailed(V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_LOCALES);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3AnnotationPortletArtifactValidityTests_SPEC3_20_PortletArtifacts_namespace */
      /* Details: "Namespace artifact is valid during all phases."                  */
      {
         TestResult result = tcd.getTestResultFailed(V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_NAMESPACE);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3AnnotationPortletArtifactValidityTests_SPEC3_20_PortletArtifacts_contextPath */
      /* Details: "ContextPath artifact is valid during all phases."                */
      {
         TestResult result = tcd.getTestResultFailed(V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_CONTEXTPATH);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3AnnotationPortletArtifactValidityTests_SPEC3_20_PortletArtifacts_windowID */
      /* Details: "WindowID artifact is valid during all phases."                   */
      {
         TestResult result = tcd.getTestResultFailed(V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_WINDOWID);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

      /* TestCase: V3AnnotationPortletArtifactValidityTests_SPEC3_20_PortletArtifacts_portletName */
      /* Details: "PortletName artifact is valid during all phases."                */
      {
         TestResult result = tcd.getTestResultFailed(V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_PORTLETNAME);
         /* TODO: implement test */
         result.appendTcDetail("Not implemented.");
         result.writeTo(writer);
      }

   }

}
