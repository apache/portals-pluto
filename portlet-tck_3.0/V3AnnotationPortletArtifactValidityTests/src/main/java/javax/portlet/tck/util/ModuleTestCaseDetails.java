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

package javax.portlet.tck.util;

import java.util.HashMap;
import java.util.Map;
import javax.portlet.tck.beans.TestCaseDetails;

/**
 * Defines constants for the test case names and test case details 
 * for the JSR 362 TCK.
 * 
 * Note that the backing map is static and not threadsafe. Operations
 * that change the map such as put, remove, etc., should not be used
 * in portlets.
 * 
 * @author nick
 */
public class ModuleTestCaseDetails extends TestCaseDetails {

   public final static String V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_REQUESTARTIFACTS_PORTLETREQUEST = "V3AnnotationPortletArtifactValidityTests_SPEC3_20_RequestArtifacts_portletRequest";
   public final static String V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_REQUESTARTIFACTS_ACTIONREQUEST = "V3AnnotationPortletArtifactValidityTests_SPEC3_20_RequestArtifacts_actionRequest";
   public final static String V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_REQUESTARTIFACTS_HEADERREQUEST = "V3AnnotationPortletArtifactValidityTests_SPEC3_20_RequestArtifacts_headerRequest";
   public final static String V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_REQUESTARTIFACTS_RENDERREQUEST = "V3AnnotationPortletArtifactValidityTests_SPEC3_20_RequestArtifacts_renderRequest";
   public final static String V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_REQUESTARTIFACTS_EVENTREQUEST = "V3AnnotationPortletArtifactValidityTests_SPEC3_20_RequestArtifacts_eventRequest";
   public final static String V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_REQUESTARTIFACTS_RESOURCEREQUEST = "V3AnnotationPortletArtifactValidityTests_SPEC3_20_RequestArtifacts_resourceRequest";
   public final static String V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_REQUESTARTIFACTS_CLIENTDATAREQUEST = "V3AnnotationPortletArtifactValidityTests_SPEC3_20_RequestArtifacts_clientDataRequest";
   public final static String V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_RESPONSEARTIFACTS_PORTLETRESPONSE = "V3AnnotationPortletArtifactValidityTests_SPEC3_20_ResponseArtifacts_portletResponse";
   public final static String V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_RESPONSEARTIFACTS_ACTIONRESPONSE = "V3AnnotationPortletArtifactValidityTests_SPEC3_20_ResponseArtifacts_actionResponse";
   public final static String V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_RESPONSEARTIFACTS_HEADERRESPONSE = "V3AnnotationPortletArtifactValidityTests_SPEC3_20_ResponseArtifacts_headerResponse";
   public final static String V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_RESPONSEARTIFACTS_RENDERRESPONSE = "V3AnnotationPortletArtifactValidityTests_SPEC3_20_ResponseArtifacts_renderResponse";
   public final static String V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_RESPONSEARTIFACTS_EVENTRESPONSE = "V3AnnotationPortletArtifactValidityTests_SPEC3_20_ResponseArtifacts_eventResponse";
   public final static String V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_RESPONSEARTIFACTS_RESOURCERESPONSE = "V3AnnotationPortletArtifactValidityTests_SPEC3_20_ResponseArtifacts_resourceResponse";
   public final static String V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_RESPONSEARTIFACTS_STATEAWAREREPONSE = "V3AnnotationPortletArtifactValidityTests_SPEC3_20_ResponseArtifacts_stateAwareReponse";
   public final static String V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_RESPONSEARTIFACTS_MIMERESPONSE = "V3AnnotationPortletArtifactValidityTests_SPEC3_20_ResponseArtifacts_mimeResponse";
   public final static String V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PARAMETERARTIFACTS_RENDERPARAMETERS = "V3AnnotationPortletArtifactValidityTests_SPEC3_20_ParameterArtifacts_renderParameters";
   public final static String V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PARAMETERARTIFACTS_MUTABLERENDERPARAMETERS = "V3AnnotationPortletArtifactValidityTests_SPEC3_20_ParameterArtifacts_mutableRenderParameters";
   public final static String V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PARAMETERARTIFACTS_ACTIONPARAMETERS = "V3AnnotationPortletArtifactValidityTests_SPEC3_20_ParameterArtifacts_actionParameters";
   public final static String V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PARAMETERARTIFACTS_RESOURCEPARAMETERS = "V3AnnotationPortletArtifactValidityTests_SPEC3_20_ParameterArtifacts_resourceParameters";
   public final static String V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_PORTLETCONFIG = "V3AnnotationPortletArtifactValidityTests_SPEC3_20_PortletArtifacts_portletConfig";
   public final static String V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_PORTLETCONTEXT = "V3AnnotationPortletArtifactValidityTests_SPEC3_20_PortletArtifacts_portletContext";
   public final static String V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_PORTLETMODE = "V3AnnotationPortletArtifactValidityTests_SPEC3_20_PortletArtifacts_portletMode";
   public final static String V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_WINDOWSTATE = "V3AnnotationPortletArtifactValidityTests_SPEC3_20_PortletArtifacts_windowState";
   public final static String V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_PORTLETPREFERENCES = "V3AnnotationPortletArtifactValidityTests_SPEC3_20_PortletArtifacts_portletPreferences";
   public final static String V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_COOKIES = "V3AnnotationPortletArtifactValidityTests_SPEC3_20_PortletArtifacts_cookies";
   public final static String V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_PORTLETSESSION = "V3AnnotationPortletArtifactValidityTests_SPEC3_20_PortletArtifacts_portletSession";
   public final static String V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_LOCALES = "V3AnnotationPortletArtifactValidityTests_SPEC3_20_PortletArtifacts_locales";
   public final static String V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_NAMESPACE = "V3AnnotationPortletArtifactValidityTests_SPEC3_20_PortletArtifacts_namespace";
   public final static String V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_CONTEXTPATH = "V3AnnotationPortletArtifactValidityTests_SPEC3_20_PortletArtifacts_contextPath";
   public final static String V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_WINDOWID = "V3AnnotationPortletArtifactValidityTests_SPEC3_20_PortletArtifacts_windowID";
   public final static String V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_PORTLETNAME = "V3AnnotationPortletArtifactValidityTests_SPEC3_20_PortletArtifacts_portletName";

   
   private final static Map<String, String> tcd = new HashMap<String, String>();
   static {

      tcd.put(V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_REQUESTARTIFACTS_PORTLETREQUEST, "PortletRequest artifact is valid during all phases.");
      tcd.put(V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_REQUESTARTIFACTS_ACTIONREQUEST, "ActionRequest artifact is only valid during action phase.");
      tcd.put(V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_REQUESTARTIFACTS_HEADERREQUEST, "HeaderRequest artifact is only valid during header phase.");
      tcd.put(V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_REQUESTARTIFACTS_RENDERREQUEST, "RenderRequest artifact is only valid during render phase.");
      tcd.put(V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_REQUESTARTIFACTS_EVENTREQUEST, "EventRequest artifact is only valid during event phase.");
      tcd.put(V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_REQUESTARTIFACTS_RESOURCEREQUEST, "ResourceRequest artifact is only valid during resource phase.");
      tcd.put(V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_REQUESTARTIFACTS_CLIENTDATAREQUEST, "ClientDataRequest artifact is only valid during action and resource phase.");
      tcd.put(V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_RESPONSEARTIFACTS_PORTLETRESPONSE, "PortletResponse artifact is valid during all phases.");
      tcd.put(V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_RESPONSEARTIFACTS_ACTIONRESPONSE, "ActionResponse artifact is only valid during action phase.");
      tcd.put(V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_RESPONSEARTIFACTS_HEADERRESPONSE, "HeaderResponse artifact is only valid during header phase.");
      tcd.put(V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_RESPONSEARTIFACTS_RENDERRESPONSE, "RenderResponse artifact is only valid during render phase.");
      tcd.put(V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_RESPONSEARTIFACTS_EVENTRESPONSE, "EventResponse artifact is only valid during event phase.");
      tcd.put(V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_RESPONSEARTIFACTS_RESOURCERESPONSE, "ResourceResponse artifact is only valid during resource phase.");
      tcd.put(V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_RESPONSEARTIFACTS_STATEAWAREREPONSE, "StateAwareResponse artifact is only valid during action and event phase.");
      tcd.put(V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_RESPONSEARTIFACTS_MIMERESPONSE, "MimeResponse artifact is only valid during header, render and resource phase.");
      tcd.put(V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PARAMETERARTIFACTS_RENDERPARAMETERS, "RenderParameters artifact is only valid during render phase.");
      tcd.put(V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PARAMETERARTIFACTS_MUTABLERENDERPARAMETERS, "MutableRenderParameters artifact is only valid during action and event phase.");
      tcd.put(V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PARAMETERARTIFACTS_ACTIONPARAMETERS, "ActionParameters artifact is only valid during action phase.");
      tcd.put(V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PARAMETERARTIFACTS_RESOURCEPARAMETERS, "ResourceParameters artifact is only valid during resource phase.");
      tcd.put(V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_PORTLETCONFIG, "PortletConfig artifact is valid during all phases.");
      tcd.put(V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_PORTLETCONTEXT, "PortletContext artifact is valid during all phases.");
      tcd.put(V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_PORTLETMODE, "PortletMode artifact is valid during all phases.");
      tcd.put(V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_WINDOWSTATE, "WindowState artifact is valid during all phases.");
      tcd.put(V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_PORTLETPREFERENCES, "PortletPreferences artifact is valid during all phases.");
      tcd.put(V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_COOKIES, "Cookies artifact is valid during all phases.");
      tcd.put(V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_PORTLETSESSION, "PortletSession artifact is valid during all phases.");
      tcd.put(V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_LOCALES, "Locales artifact is valid during all phases.");
      tcd.put(V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_NAMESPACE, "Namespace artifact is valid during all phases.");
      tcd.put(V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_CONTEXTPATH, "ContextPath artifact is valid during all phases.");
      tcd.put(V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_WINDOWID, "WindowID artifact is valid during all phases.");
      tcd.put(V3ANNOTATIONPORTLETARTIFACTVALIDITYTESTS_SPEC3_20_PORTLETARTIFACTS_PORTLETNAME, "PortletName artifact is valid during all phases.");

   }

   /**
    * Constructor.
    * 
    * Passes the static test case names - details map to the superclass
    * 
    * Note that the backing map is static and not threadsafe. Operations
    * that change the map such as put, remove, etc., should not be used
    * in portlets.
    */
   public ModuleTestCaseDetails() {
     super(tcd); 
   }

}
