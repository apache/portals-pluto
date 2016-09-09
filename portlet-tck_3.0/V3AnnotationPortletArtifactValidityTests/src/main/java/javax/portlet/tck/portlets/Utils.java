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

import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.portlet.MimeResponse;
import javax.portlet.MutableRenderParameters;
import javax.portlet.PortletConfig;
import javax.portlet.PortletContext;
import javax.portlet.PortletMode;
import javax.portlet.PortletParameters;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletSession;
import javax.portlet.RenderParameters;
import javax.portlet.StateAwareResponse;
import javax.portlet.WindowState;

/**
 * Utils hold all common constants and test functions specific to
 * V2AnnotationPortletArtifactValidityTests module
 */

public class Utils {

   public static final String ACTIONPARAMETERSARTIFACTKEY        = "_actionParamsArtifact_";
   public static final String MUTABLERENDERPARAMETERSARTIFACTKEY = "_mutableRenderParamsArtifact_";
   public static final String RENDERPARAMETERSARTIFACTKEY        = "_renderParamsArtifact_";
   public static final String RESOURCEPARAMETERSARTIFACTKEY      = "_resourceParamsArtifact_";
   public static final String PORTLETREQUESTARTIFACTKEY          = "_portletRequestArtifact_";
   public static final String ACTIONREQUESTARTIFACTKEY           = "_actionRequestArtifact_";
   public static final String HEADERREQUESTARTIFACTKEY           = "_headerRequestArtifact_";
   public static final String RENDERREQUESTARTIFACTKEY           = "_renderRequestArtifact_";
   public static final String EVENTREQUESTARTIFACTKEY            = "_eventRequestArtifact_";
   public static final String RESOURCEREQUESTARTIFACTKEY         = "_resourceRequestArtifact_";
   public static final String CLIENTDATAREQUESTARTIFACTKEY       = "_clientDataRequestArtifact_";
   public static final String PORTLETRESPONSEARTIFACTKEY         = "_portletResponseArtifact_";
   public static final String ACTIONRESPONSEARTIFACTKEY          = "_actionResponseArtifact_";
   public static final String HEADERRESPONSEARTIFACTKEY          = "_headerResponseArtifact_";
   public static final String RENDERRESPONSEARTIFACTKEY          = "_renderResponseArtifact_";
   public static final String EVENTRESPONSEARTIFACTKEY           = "_eventResponseArtifact_";
   public static final String RESOURCERESPONSEARTIFACTKEY        = "_resourceResponseArtifact_";
   public static final String MIMERESPONSEARTIFACTKEY            = "_mimeResponseArtifact_";
   public static final String STATEAWARERESPONSEARTIFACTKEY      = "_stateAwareportletResponseArtifact_";
   public static final String PORTLETCONFIGARTIFACTKEY           = "_portletConfigArtifact_";
   public static final String PORTLETCONTEXTARTIFACTKEY          = "_portletContextArtifact_";
   public static final String PORTLETMODEARTIFACTKEY             = "_portletModeArtifact_";
   public static final String WINDOWSTATEARTIFACTKEY             = "_windowStateArtifact_";
   public static final String PORTLETPREFERENCESARTIFACTKEY      = "_portletPreferencesArtifact_";
   public static final String COOKIESARTIFACTKEY                 = "_cookiesArtifact_";
   public static final String PORTLETSESSIONARTIFACTKEY          = "_portletSessionArtifact_";
   public static final String LOCALEARTIFACTKEY                  = "_localeArtifact_";
   public static final String LOCALESARTIFACTKEY                 = "_localesArtifact_";
   public static final String NAMESPACEARTIFACTKEY               = "_namespaceArtifact_";
   public static final String CONTEXTPATHARTIFACTKEY             = "_contextPathArtifact_";
   public static final String WINDOWIDARTIFACTKEY                = "_windowIdArtifact_";
   public static final String PORTLETNAMEARTIFACTKEY             = "_portletNameArtifact_";
   public static final String ACTIONPHASE                        = "action";
   public static final String RENDERPHASE                        = "render";
   public static final String HEADERPHASE                        = "header";
   public static final String EVENTPHASE                         = "event";

   public boolean isValid(Object injectedPortletArtifact) {
      if (injectedPortletArtifact == null) {
         return false;
      } else {
         return true;
      }
   }

   public boolean checkEqualParameters(
         PortletParameters injectedPortletArtifact,
         PortletParameters requestParameters) {
      String injectedValue;
      String requestValue;
      if (injectedPortletArtifact == null) {
         return false;
      }
      if (injectedPortletArtifact.equals(requestParameters)) {
         return true;
      }
      if (injectedPortletArtifact.size() == requestParameters.size()) {
         Set<? extends String> parameters = injectedPortletArtifact.getNames();
         for (String paramName : parameters) {
            injectedValue = injectedPortletArtifact.getValue(paramName);
            requestValue = requestParameters.getValue(paramName);
            if (!injectedValue.equals(requestValue)) {
               return false;
            }
         }
      } else {
         return false;
      }
      return true;
   }
   
   public boolean checkEqualConfigs(PortletConfig injectedPortletConfig, PortletConfig initPortletConfig){
      if(injectedPortletConfig.equals(initPortletConfig)){
         return true;
      }
      if(checkEqualEnumeration(injectedPortletConfig.getInitParameterNames(), initPortletConfig.getInitParameterNames())
            && checkEqualEnumeration(injectedPortletConfig.getPublicRenderParameterNames(),initPortletConfig.getPublicRenderParameterNames())
            && checkEqualEnumeration(injectedPortletConfig.getProcessingEventQNames(),initPortletConfig.getProcessingEventQNames())
            && checkEqualEnumeration(injectedPortletConfig.getPublishingEventQNames(),initPortletConfig.getPublishingEventQNames())
            && checkEqualEnumeration(injectedPortletConfig.getSupportedLocales(),initPortletConfig.getSupportedLocales())
            && injectedPortletConfig.getDefaultNamespace().equals(initPortletConfig.getDefaultNamespace())
            && injectedPortletConfig.getPortletName().equals(initPortletConfig.getPortletName())
            && checkEqualContexts(injectedPortletConfig.getPortletContext(), initPortletConfig.getPortletContext())){
         return true;
      } else {
         return false;
      }
   }
   
   public boolean checkEqualContexts(PortletContext injectedPortletContext, PortletContext requestContext){
      if(injectedPortletContext.equals(requestContext)){
         return true;
      }
      if(checkEqualEnumeration(injectedPortletContext.getInitParameterNames(), requestContext.getInitParameterNames())
            && checkEqualEnumeration(injectedPortletContext.getContainerRuntimeOptions(), requestContext.getContainerRuntimeOptions())
            && injectedPortletContext.getContextPath().equals(requestContext.getContextPath())
            && injectedPortletContext.getServerInfo().equals(requestContext.getServerInfo())
            && injectedPortletContext.getEffectiveMajorVersion()==requestContext.getEffectiveMajorVersion()
            && injectedPortletContext.getEffectiveMinorVersion()==requestContext.getEffectiveMinorVersion()
            && injectedPortletContext.getMajorVersion()==requestContext.getMajorVersion()
            && injectedPortletContext.getMinorVersion()==requestContext.getMinorVersion()){
         return true;
      } else {
         return false;
      }
   }
   
   public boolean checkEqualSessions(PortletSession injectedPortletSession, PortletSession requestSession){
      if(injectedPortletSession.equals(requestSession)){
         return true;
      }
      if(checkEqualEnumeration(injectedPortletSession.getAttributeNames(), requestSession.getAttributeNames())
            && injectedPortletSession.getCreationTime()==requestSession.getCreationTime()
            && injectedPortletSession.getLastAccessedTime()==requestSession.getLastAccessedTime()
            && injectedPortletSession.getMaxInactiveInterval()==requestSession.getMaxInactiveInterval()
            && injectedPortletSession.getId()==requestSession.getId()
            && injectedPortletSession.getAttributeMap().equals(requestSession.getAttributeMap())){
         return true;
      } else {
         return false;
      }
   }
   
   public boolean checkEqualPreferences(PortletPreferences injectedPortletPreferences, PortletPreferences requestPreferences){
      if (injectedPortletPreferences.equals(requestPreferences)) {
         return true;
      }
      if(checkEqualEnumeration(injectedPortletPreferences.getNames(), requestPreferences.getNames())
            && injectedPortletPreferences.getMap().equals(requestPreferences.getMap())){
         return true;
      } else {
         return false;
      }
   }

   private boolean checkEqualEnumeration(
         Enumeration<?> injectedArtifactEnumeration,
         Enumeration<?> portletEnumeration) {
      if (injectedArtifactEnumeration.equals(portletEnumeration)) {
         return true;
      }
      List<?> injectedEnumerationList = Collections
            .list(injectedArtifactEnumeration);
      List<?> portletEnumerationList = Collections.list(portletEnumeration);
      return checkEqualCollection(injectedEnumerationList,
            portletEnumerationList);
   }

   private boolean checkEqualAttributes(PortletRequest injectedPortletArtifact,
         PortletRequest portletRequest) {
      Enumeration<String> injectedRequestAttributes = injectedPortletArtifact
            .getAttributeNames();
      Enumeration<String> portletRequestAttributes = portletRequest
            .getAttributeNames();
      if (checkEqualEnumeration(injectedRequestAttributes,
            portletRequestAttributes)) {
         List<String> injectedEnumerationList = Collections
               .list(injectedRequestAttributes);
         List<String> portletEnumerationList = Collections
               .list(portletRequestAttributes);
         for (String attributeName : injectedEnumerationList) {
            if (!injectedPortletArtifact.getAttribute(attributeName)
                  .equals(portletRequest.getAttribute(attributeName))) {
               return false;
            }
         }
         for (String attributeName : portletEnumerationList) {
            if (!injectedPortletArtifact.getAttribute(attributeName)
                  .equals(portletRequest.getAttribute(attributeName))) {
               return false;
            }
         }
         return true;
      } else {
         return false;
      }
   }

   public boolean checkEqualRequests(PortletRequest injectedPortletArtifact,
         PortletRequest portletRequest) {

      if (injectedPortletArtifact.equals(portletRequest)) {
         return true;
      }
      RenderParameters injectedRequestRenderParams = injectedPortletArtifact
            .getRenderParameters();
      RenderParameters portletRequestRenderParams = portletRequest
            .getRenderParameters();
      Enumeration<String> injectedRequestProperties = injectedPortletArtifact
            .getPropertyNames();
      Enumeration<String> portletRequestProperties = portletRequest
            .getPropertyNames();
      Enumeration<String> injectedRequestContentTypes = injectedPortletArtifact
            .getResponseContentTypes();
      Enumeration<String> portletRequestContentTypes = portletRequest
            .getResponseContentTypes();
      Enumeration<Locale> injectedRequestLocales = injectedPortletArtifact
            .getLocales();
      Enumeration<Locale> portletRequestLocales = portletRequest.getLocales();
      if (checkEqualParameters(injectedRequestRenderParams,
            portletRequestRenderParams)
            && checkEqualAttributes(injectedPortletArtifact, portletRequest)
            && checkEqualEnumeration(injectedRequestProperties,
                  portletRequestProperties)
            && checkEqualEnumeration(injectedRequestContentTypes,
                  portletRequestContentTypes)
            && checkEqualEnumeration(injectedRequestLocales,
                  portletRequestLocales)) {
         return true;
      } else {
         return false;
      }
   }

   public boolean checkEqualStateAwareResponse(
         StateAwareResponse injectedPortletArtifact,
         StateAwareResponse stateAwareResponse) {
      if (injectedPortletArtifact.equals(stateAwareResponse)) {
         return true;
      }
      PortletMode injectedPortletMode = injectedPortletArtifact
            .getPortletMode();
      PortletMode portletPortletMode = stateAwareResponse.getPortletMode();
      WindowState injectedWindowState = injectedPortletArtifact
            .getWindowState();
      WindowState portletWindowState = stateAwareResponse.getWindowState();
      MutableRenderParameters injectedMutableRenderParams = injectedPortletArtifact
            .getRenderParameters();
      MutableRenderParameters portletMutableRenderParams = stateAwareResponse
            .getRenderParameters();
      if (checkEqualResponses(injectedPortletArtifact, stateAwareResponse)
            && injectedPortletMode.equals(portletPortletMode)
            && injectedWindowState.equals(portletWindowState)
            && checkEqualParameters(injectedMutableRenderParams,
                  portletMutableRenderParams)) {
         return true;
      } else {
         return false;
      }
   }

   public boolean checkEqualMimeResponse(MimeResponse injectedPortletArtifact,
         MimeResponse mimeResponse) {
      if (injectedPortletArtifact.equals(mimeResponse)) {
         return true;
      }
      int injectedBufferSize = injectedPortletArtifact.getBufferSize();
      int portletBufferSize = mimeResponse.getBufferSize();
      String injectedCharacterEncoding = injectedPortletArtifact
            .getCharacterEncoding();
      String portletCharacterEncoding = mimeResponse.getCharacterEncoding();
      String injectedContentType = injectedPortletArtifact.getContentType();
      String portletContentType = mimeResponse.getContentType();      
      
      if (checkEqualResponses(injectedPortletArtifact, mimeResponse)
            
            && injectedBufferSize == portletBufferSize
            
            && ((injectedCharacterEncoding == null && portletCharacterEncoding == null) ||
                 injectedCharacterEncoding.equals(portletCharacterEncoding))
            
            && (injectedContentType == null && portletContentType == null) ||
               injectedContentType.equals(portletContentType)
            
            ) {
         return true;
      } else {
         return false;
      }
   }

   public boolean checkEqualResponses(PortletResponse injectedPortletArtifact,
         PortletResponse portletResponse) {
      if (injectedPortletArtifact.equals(portletResponse)) {
         return true;
      }
      String injectedNamespace = injectedPortletArtifact.getNamespace();
      String portletResponseNamespace = portletResponse.getNamespace();
      if (injectedNamespace.equals(portletResponseNamespace)
            && checkEqualProperties(injectedPortletArtifact, portletResponse)) {
         return true;
      } else {
         return false;
      }
   }

   public boolean checkEqualCollection(Collection<?> injectedProperties,
         Collection<?> portletResponseProperties) {
      if (injectedProperties.equals(portletResponseProperties)) {
         return true;
      }
      if (injectedProperties.containsAll(portletResponseProperties)
            && portletResponseProperties.containsAll(injectedProperties)) {
         return true;
      }
      return false;
   }

   private boolean checkEqualProperties(PortletResponse injectedPortletArtifact,
         PortletResponse portletResponse) {
      Collection<String> injectedProperties = injectedPortletArtifact
            .getPropertyNames();
      Collection<String> portletResponseProperties = portletResponse
            .getPropertyNames();
      Collection<String> injectedPropertyNames;
      Collection<String> portletPropertyNames;
      if (checkEqualCollection(injectedProperties, portletResponseProperties)) {
         for (String propertyName : injectedProperties) {
            injectedPropertyNames = injectedPortletArtifact
                  .getPropertyValues(propertyName);
            portletPropertyNames = injectedPortletArtifact
                  .getPropertyValues(propertyName);
            if (!checkEqualCollection(injectedPropertyNames,
                  portletPropertyNames)) {
               return false;
            }
         }
         return true;
      } else {
         return false;
      }
   }

   public String createTestDebug(ArtifactValidationResult validationResult) {
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
      txt.append("      <td>" + validationResult.isArtifactValidInActionPhase()
            + "</td>");
      txt.append("      <td>" + validationResult.isArtifactValidInEventPhase()
            + "</td>");
      txt.append("      <td>" + validationResult.isArtifactValidInHeaderPhase()
            + "</td>");
      txt.append("      <td>" + validationResult.isArtifactValidInRenderPhase()
            + "</td>");
      txt.append("      <td>"
            + validationResult.isArtifactValidInResourcePhase() + "</td>");
      txt.append("   </tr>");
      txt.append("</table>");
      txt.append("</p>");
      return txt.toString();
   }

}
