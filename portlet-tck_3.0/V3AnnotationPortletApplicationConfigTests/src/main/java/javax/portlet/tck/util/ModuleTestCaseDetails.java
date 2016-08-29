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

   public final static String V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_PORTLETMODES_DECLARINGPORTLETMODES3 = "V3AnnotationPortletApplicationConfigTests_SPEC1_28_PortletModes_declaringPortletModes3";
   public final static String V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_PORTLETMODES_DECLARINGPORTLETMODES4 = "V3AnnotationPortletApplicationConfigTests_SPEC1_28_PortletModes_declaringPortletModes4";
   public final static String V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_PORTLETMODES_DECLARINGPORTLETMODES5 = "V3AnnotationPortletApplicationConfigTests_SPEC1_28_PortletModes_declaringPortletModes5";
   public final static String V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_PORTLETMODES_DECLARINGPORTLETMODES6 = "V3AnnotationPortletApplicationConfigTests_SPEC1_28_PortletModes_declaringPortletModes6";
   public final static String V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_WINDOWSTATES_DECLARINGWINDOWSTATES1 = "V3AnnotationPortletApplicationConfigTests_SPEC1_28_WindowStates_declaringWindowStates1";
   public final static String V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_WINDOWSTATES_DECLARINGWINDOWSTATES2 = "V3AnnotationPortletApplicationConfigTests_SPEC1_28_WindowStates_declaringWindowStates2";
   public final static String V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_WINDOWSTATES_DECLARINGWINDOWSTATES3 = "V3AnnotationPortletApplicationConfigTests_SPEC1_28_WindowStates_declaringWindowStates3";
   public final static String V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_WINDOWSTATES_DECLARINGWINDOWSTATES4 = "V3AnnotationPortletApplicationConfigTests_SPEC1_28_WindowStates_declaringWindowStates4";
   public final static String V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_EVENTCONFIGURATION_DECLARINGEVENTS1 = "V3AnnotationPortletApplicationConfigTests_SPEC1_28_EventConfiguration_declaringEvents1";
   public final static String V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_EVENTCONFIGURATION_DECLARINGEVENTS2 = "V3AnnotationPortletApplicationConfigTests_SPEC1_28_EventConfiguration_declaringEvents2";
   public final static String V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_PUBLICRENDERPARAMETERS_DECLARINGPRP1 = "V3AnnotationPortletApplicationConfigTests_SPEC1_28_PublicRenderParameters_declaringPRP1";
   public final static String V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_PORTLETCONTAINERRUNTIMEOPTIONS_DECLARINGPCRO1 = "V3AnnotationPortletApplicationConfigTests_SPEC1_28_PortletContainerRuntimeOptions_declaringPCRO1";

   
   private final static Map<String, String> tcd = new HashMap<String, String>();
   static {
      
      tcd.put(V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_PORTLETMODES_DECLARINGPORTLETMODES3, "A custom portlet mode may be declared in the @PortletApplication annotation.");
      tcd.put(V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_PORTLETMODES_DECLARINGPORTLETMODES4, "A custom portlet mode with portalManaged=false may be declared in the @PortletApplication annotation.");
      tcd.put(V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_PORTLETMODES_DECLARINGPORTLETMODES5, "The PortletRequest.isPortletModeAllowed method must return FALSE for a custom portlet mode with portalManaged=true that is not supported by the portlet container");
      tcd.put(V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_PORTLETMODES_DECLARINGPORTLETMODES6, "A custom portlet mode can have a localized decoration name in the resource bundle with the name of javax.portlet.app.custom-portlet-mode.&lt;name&gt;.decoration-name");
      tcd.put(V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_WINDOWSTATES_DECLARINGWINDOWSTATES1, "Support for the NORMAL window state does not need to be declared in the @PortletApplication annotation.");
      tcd.put(V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_WINDOWSTATES_DECLARINGWINDOWSTATES2, "Support for the MINIMIZED window state does not need to be declared in the @PortletApplication annotation.");
      tcd.put(V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_WINDOWSTATES_DECLARINGWINDOWSTATES3, "Support for the MAXIMIZED window state does not need to be declared in the @PortletApplication annotation.");
      tcd.put(V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_WINDOWSTATES_DECLARINGWINDOWSTATES4, "The PortletRequest.isWindowStateAllowed method must return FALSE for a custom window state that is not supported by the portlet container.");
      tcd.put(V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_EVENTCONFIGURATION_DECLARINGEVENTS1, "An event with Qname may be declared in the @PortletApplication annotation using @EventDefinition annotation.");
      tcd.put(V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_EVENTCONFIGURATION_DECLARINGEVENTS2, "An event with name may be declared in the @PortletApplication annotation using @EventDefinition annotation and leaving namespaceURI empty.");
      tcd.put(V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_PUBLICRENDERPARAMETERS_DECLARINGPRP1, "A public render parameters may be declared in the @PortletApplication annotation using @PublicRenderParameterDefinition annotation.");
      tcd.put(V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_PORTLETCONTAINERRUNTIMEOPTIONS_DECLARINGPCRO1, "Portlet container runtime options may be declared in the @PortletApplication annotation using @RuntimeOption annotation.");

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
