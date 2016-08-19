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

   public final static String V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_PORTLETMODES1_DECLARINGPORTLETMODES1 = "V3AnnotationPortletApplicationConfigTests_SPEC1_28_PortletModes1_declaringPortletModes1";
   public final static String V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_PORTLETMODES1_DECLARINGPORTLETMODES2 = "V3AnnotationPortletApplicationConfigTests_SPEC1_28_PortletModes1_declaringPortletModes2";
   public final static String V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_PORTLETMODES1_DECLARINGPORTLETMODES3 = "V3AnnotationPortletApplicationConfigTests_SPEC1_28_PortletModes1_declaringPortletModes3";
   public final static String V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_PORTLETMODES1_DECLARINGPORTLETMODES4 = "V3AnnotationPortletApplicationConfigTests_SPEC1_28_PortletModes1_declaringPortletModes4";
   public final static String V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_PORTLETMODES1_DECLARINGPORTLETMODES5 = "V3AnnotationPortletApplicationConfigTests_SPEC1_28_PortletModes1_declaringPortletModes5";
   public final static String V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_PORTLETMODES1_DECLARINGPORTLETMODES6 = "V3AnnotationPortletApplicationConfigTests_SPEC1_28_PortletModes1_declaringPortletModes6";
   public final static String V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_PORTLETMODES2_DECLARINGPORTLETMODES7 = "V3AnnotationPortletApplicationConfigTests_SPEC1_28_PortletModes2_declaringPortletModes7";
   public final static String V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_PORTLETMODES2_DECLARINGPORTLETMODES8 = "V3AnnotationPortletApplicationConfigTests_SPEC1_28_PortletModes2_declaringPortletModes8";
   public final static String V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_WINDOWSTATES1_DECLARINGWINDOWSTATES1 = "V3AnnotationPortletApplicationConfigTests_SPEC1_28_WindowStates1_declaringWindowStates1";
   public final static String V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_WINDOWSTATES1_DECLARINGWINDOWSTATES2 = "V3AnnotationPortletApplicationConfigTests_SPEC1_28_WindowStates1_declaringWindowStates2";
   public final static String V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_WINDOWSTATES1_DECLARINGWINDOWSTATES3 = "V3AnnotationPortletApplicationConfigTests_SPEC1_28_WindowStates1_declaringWindowStates3";
   public final static String V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_WINDOWSTATES1_DECLARINGWINDOWSTATES4 = "V3AnnotationPortletApplicationConfigTests_SPEC1_28_WindowStates1_declaringWindowStates4";
   public final static String V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_WINDOWSTATES2_DECLARINGWINDOWSTATES5 = "V3AnnotationPortletApplicationConfigTests_SPEC1_28_WindowStates2_declaringWindowStates5";
   public final static String V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_WINDOWSTATES2_DECLARINGWINDOWSTATES6 = "V3AnnotationPortletApplicationConfigTests_SPEC1_28_WindowStates2_declaringWindowStates6";
   public final static String V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_USERATTRIBUTES1_DECLARINGUSERATTRIBUTES1 = "V3AnnotationPortletApplicationConfigTests_SPEC1_28_UserAttributes1_declaringUserAttributes1";
   public final static String V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_USERATTRIBUTES2_DECLARINGUSERATTRIBUTES2 = "V3AnnotationPortletApplicationConfigTests_SPEC1_28_UserAttributes2_declaringUserAttributes2";
   public final static String V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_USERATTRIBUTES2_DECLARINGUSERATTRIBUTES3 = "V3AnnotationPortletApplicationConfigTests_SPEC1_28_UserAttributes2_declaringUserAttributes3";
   public final static String V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_RESOURCEBUNDLE1_DECLARINGRESOURCEBUNDLE1 = "V3AnnotationPortletApplicationConfigTests_SPEC1_28_ResourceBundle1_declaringResourceBundle1";
   public final static String V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_RESOURCEBUNDLE2_DECLARINGRESOURCEBUNDLE2 = "V3AnnotationPortletApplicationConfigTests_SPEC1_28_ResourceBundle2_declaringResourceBundle2";
   public final static String V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_RESOURCEBUNDLE2_DECLARINGRESOURCEBUNDLE3 = "V3AnnotationPortletApplicationConfigTests_SPEC1_28_ResourceBundle2_declaringResourceBundle3";
   public final static String V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_DEFAULTNAMESPACEURI1_DECLARINGDEFAULTNAMESPACEURI1 = "V3AnnotationPortletApplicationConfigTests_SPEC1_28_DefaultNamespaceURI1_declaringDefaultNamespaceURI1";
   public final static String V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_DEFAULTNAMESPACEURI2_DECLARINGDEFAULTNAMESPACEURI2 = "V3AnnotationPortletApplicationConfigTests_SPEC1_28_DefaultNamespaceURI2_declaringDefaultNamespaceURI2";
   public final static String V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_EVENTCONFIGURATION1_DECLARINGEVENTS1 = "V3AnnotationPortletApplicationConfigTests_SPEC1_28_EventConfiguration1_declaringEvents1";
   public final static String V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_EVENTCONFIGURATION1_DECLARINGEVENTS2 = "V3AnnotationPortletApplicationConfigTests_SPEC1_28_EventConfiguration1_declaringEvents2";
   public final static String V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_EVENTCONFIGURATION2_DECLARINGEVENTS3 = "V3AnnotationPortletApplicationConfigTests_SPEC1_28_EventConfiguration2_declaringEvents3";
   public final static String V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_EVENTCONFIGURATION3_DECLARINGEVENTS4 = "V3AnnotationPortletApplicationConfigTests_SPEC1_28_EventConfiguration3_declaringEvents4";
   public final static String V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_PUBLICRENDERPARAMETERS1_DECLARINGPRP1 = "V3AnnotationPortletApplicationConfigTests_SPEC1_28_PublicRenderParameters1_declaringPRP1";
   public final static String V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_PUBLICRENDERPARAMETERS2_DECLARINGPRP2 = "V3AnnotationPortletApplicationConfigTests_SPEC1_28_PublicRenderParameters2_declaringPRP2";
   public final static String V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_PUBLICRENDERPARAMETERS3_DECLARINGPRP3 = "V3AnnotationPortletApplicationConfigTests_SPEC1_28_PublicRenderParameters3_declaringPRP3";
   public final static String V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_PUBLICRENDERPARAMETERS4_DECLARINGPRP4 = "V3AnnotationPortletApplicationConfigTests_SPEC1_28_PublicRenderParameters4_declaringPRP4";
   public final static String V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_PORTLETCONTAINERRUNTIMEOPTIONS1_DECLARINGPCRO1 = "V3AnnotationPortletApplicationConfigTests_SPEC1_28_PortletContainerRuntimeOptions1_declaringPCRO1";
   public final static String V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_PORTLETCONTAINERRUNTIMEOPTIONS2_DECLARINGPCRO2 = "V3AnnotationPortletApplicationConfigTests_SPEC1_28_PortletContainerRuntimeOptions2_declaringPCRO2";
   public final static String V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_PORTLETCONTAINERRUNTIMEOPTIONS2_DECLARINGPCRO3 = "V3AnnotationPortletApplicationConfigTests_SPEC1_28_PortletContainerRuntimeOptions2_declaringPCRO3";

   
   private final static Map<String, String> tcd = new HashMap<String, String>();
   static {

      tcd.put(V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_PORTLETMODES1_DECLARINGPORTLETMODES1, "Support for the VIEW mode does not need to be declared in the @PortletApplication annotation.");
      tcd.put(V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_PORTLETMODES1_DECLARINGPORTLETMODES2, "Support for the HELP mode must be declared in the @PortletApplication annotation.");
      tcd.put(V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_PORTLETMODES1_DECLARINGPORTLETMODES3, "A custom portlet mode may be declared in the @PortletApplication annotation.");
      tcd.put(V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_PORTLETMODES1_DECLARINGPORTLETMODES4, "A custom portlet mode with portalManaged=true may be declared in the @PortletApplication annotation.");
      tcd.put(V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_PORTLETMODES1_DECLARINGPORTLETMODES5, "The PortletRequest.isPortletModeAllowed method must return FALSE for a custom portlet mode with portalManaged=true that is not supported by the portlet container");
      tcd.put(V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_PORTLETMODES1_DECLARINGPORTLETMODES6, "A custom portlet mode can have a localized decoration name in the resource bundle with the name of javax.portlet.app.custom-portlet-mode.&lt;name&gt;.decoration-name");
      tcd.put(V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_PORTLETMODES2_DECLARINGPORTLETMODES7, "A custom portlet mode declared in the @PortletApplication annotation could be overridden by deployment descriptor portlet.xml");
      tcd.put(V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_PORTLETMODES2_DECLARINGPORTLETMODES8, "The portlet container merges the portlet modes declared in the @PortletApplication annotation and deployment descriptor portlet.xml");
      tcd.put(V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_WINDOWSTATES1_DECLARINGWINDOWSTATES1, "Support for the NORMAL window state does not need to be declared in the @PortletApplication annotation.");
      tcd.put(V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_WINDOWSTATES1_DECLARINGWINDOWSTATES2, "Support for the MINIMIZED window state does not need to be declared in the @PortletApplication annotation.");
      tcd.put(V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_WINDOWSTATES1_DECLARINGWINDOWSTATES3, "Support for the MAXIMIZED window state does not need to be declared in the @PortletApplication annotation.");
      tcd.put(V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_WINDOWSTATES1_DECLARINGWINDOWSTATES4, "The PortletRequest.isWindowStateAllowed method must return FALSE for a custom window state that is not supported by the portlet container.");
      tcd.put(V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_WINDOWSTATES2_DECLARINGWINDOWSTATES5, "A custom window state declared in the @PortletApplication annotation could be overridden by deployment descriptor portlet.xml");
      tcd.put(V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_WINDOWSTATES2_DECLARINGWINDOWSTATES6, "The portlet container merges the window states declared in the @PortletApplication annotation and deployment descriptor portlet.xml");
      tcd.put(V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_USERATTRIBUTES1_DECLARINGUSERATTRIBUTES1, "A user attribute may be declared in the @PortletApplication annotation.");
      tcd.put(V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_USERATTRIBUTES2_DECLARINGUSERATTRIBUTES2, "A user attribute declared in the @PortletApplication annotation could be overridden by deployment descriptor portlet.xml");
      tcd.put(V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_USERATTRIBUTES2_DECLARINGUSERATTRIBUTES3, "The portlet container merges the user attributes declared in the @PortletApplication annotation and deployment descriptor portlet.xml");
      tcd.put(V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_RESOURCEBUNDLE1_DECLARINGRESOURCEBUNDLE1, "The resource bundle defined in the @PortletApplication annotation resourceBundle element can be obtained through the PortletConfig object");
      tcd.put(V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_RESOURCEBUNDLE2_DECLARINGRESOURCEBUNDLE2, "The resource bundle defined in the @PortletApplication annotation could be overridden by deployment descriptor portlet.xml");
      tcd.put(V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_RESOURCEBUNDLE2_DECLARINGRESOURCEBUNDLE3, "The portlet container merges the resource bundles declared in the @PortletApplication annotation and deployment descriptor portlet.xml");
      tcd.put(V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_DEFAULTNAMESPACEURI1_DECLARINGDEFAULTNAMESPACEURI1, "DefaultNamespaceURI may be declared in the @PortletApplication annotation.");
      tcd.put(V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_DEFAULTNAMESPACEURI2_DECLARINGDEFAULTNAMESPACEURI2, "DefaultNamespaceURI defined in the @PortletApplication annotation could be overridden by deployment descriptor portlet.xml");
      tcd.put(V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_EVENTCONFIGURATION1_DECLARINGEVENTS1, "An event with Qname may be declared in the @PortletApplication annotation using @EventDefinition annotation.");
      tcd.put(V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_EVENTCONFIGURATION1_DECLARINGEVENTS2, "An event with name may be declared in the @PortletApplication annotation using @EventDefinition and leaving namespaceURI empty annotation.");
      tcd.put(V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_EVENTCONFIGURATION2_DECLARINGEVENTS3, "An event with cannot be declared two times - once in @PortletApplication then again in deployment descriptor portlet.xml");
      tcd.put(V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_EVENTCONFIGURATION3_DECLARINGEVENTS4, "The portlet container merges the events declared in the @PortletApplication annotation and deployment descriptor portlet.xml");
      tcd.put(V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_PUBLICRENDERPARAMETERS1_DECLARINGPRP1, "A public render parameters may be declared in the @PortletApplication annotation using @PublicRenderParameterDefinition annotation.");
      tcd.put(V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_PUBLICRENDERPARAMETERS2_DECLARINGPRP2, "A public render parameters cannot be declared two times - once in @PortletApplication then again in deployment descriptor portlet.xml");
      tcd.put(V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_PUBLICRENDERPARAMETERS3_DECLARINGPRP3, "A public render parameters declared using @PortletApplication annotation in one portlet and deployment descriptor portlet.xml in another portlet can be shared with each other.");
      tcd.put(V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_PUBLICRENDERPARAMETERS4_DECLARINGPRP4, "The portlet container merges the public render parameters declared in the @PortletApplication annotation and deployment descriptor portlet.xml");
      tcd.put(V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_PORTLETCONTAINERRUNTIMEOPTIONS1_DECLARINGPCRO1, "Portlet container runtime options may be declared in the @PortletApplication annotation using @RuntimeOption annotation.");
      tcd.put(V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_PORTLETCONTAINERRUNTIMEOPTIONS2_DECLARINGPCRO2, "A portlet container runtime option declared in the @PortletApplication annotation could be overridden by deployment descriptor portlet.xml");
      tcd.put(V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_PORTLETCONTAINERRUNTIMEOPTIONS2_DECLARINGPCRO3, "The portlet container merges the portlet container runtime options declared in the @PortletApplication annotation and deployment descriptor portlet.xml");

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
