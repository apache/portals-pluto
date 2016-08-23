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

   public final static String V3ANNOTATIONPORTLETAPPCONFIGOVERRIDETESTS_SPEC1_28_PORTLETMODES_DECLARINGPORTLETMODES7 = "V3AnnotationPortletAppConfigOverrideTests_SPEC1_28_PortletModes_declaringPortletModes7";
   public final static String V3ANNOTATIONPORTLETAPPCONFIGOVERRIDETESTS_SPEC1_28_PORTLETMODES_DECLARINGPORTLETMODES8 = "V3AnnotationPortletAppConfigOverrideTests_SPEC1_28_PortletModes_declaringPortletModes8";
   public final static String V3ANNOTATIONPORTLETAPPCONFIGOVERRIDETESTS_SPEC1_28_WINDOWSTATES_DECLARINGWINDOWSTATES5 = "V3AnnotationPortletAppConfigOverrideTests_SPEC1_28_WindowStates_declaringWindowStates5";
   public final static String V3ANNOTATIONPORTLETAPPCONFIGOVERRIDETESTS_SPEC1_28_WINDOWSTATES_DECLARINGWINDOWSTATES6 = "V3AnnotationPortletAppConfigOverrideTests_SPEC1_28_WindowStates_declaringWindowStates6";
   public final static String V3ANNOTATIONPORTLETAPPCONFIGOVERRIDETESTS_SPEC1_28_DEFAULTNAMESPACEURI_DECLARINGDEFAULTNAMESPACEURI2 = "V3AnnotationPortletAppConfigOverrideTests_SPEC1_28_DefaultNamespaceURI_declaringDefaultNamespaceURI2";
   public final static String V3ANNOTATIONPORTLETAPPCONFIGOVERRIDETESTS_SPEC1_28_EVENTCONFIGURATION1_DECLARINGEVENTS3 = "V3AnnotationPortletAppConfigOverrideTests_SPEC1_28_EventConfiguration1_declaringEvents3";
   public final static String V3ANNOTATIONPORTLETAPPCONFIGOVERRIDETESTS_SPEC1_28_EVENTCONFIGURATION2_DECLARINGEVENTS4 = "V3AnnotationPortletAppConfigOverrideTests_SPEC1_28_EventConfiguration2_declaringEvents4";
   public final static String V3ANNOTATIONPORTLETAPPCONFIGOVERRIDETESTS_SPEC1_28_PUBLICRENDERPARAMETERS1_DECLARINGPRP2 = "V3AnnotationPortletAppConfigOverrideTests_SPEC1_28_PublicRenderParameters1_declaringPRP2";
   public final static String V3ANNOTATIONPORTLETAPPCONFIGOVERRIDETESTS_SPEC1_28_PUBLICRENDERPARAMETERS2_DECLARINGPRP3 = "V3AnnotationPortletAppConfigOverrideTests_SPEC1_28_PublicRenderParameters2_declaringPRP3";
   public final static String V3ANNOTATIONPORTLETAPPCONFIGOVERRIDETESTS_SPEC1_28_PUBLICRENDERPARAMETERS3_DECLARINGPRP4 = "V3AnnotationPortletAppConfigOverrideTests_SPEC1_28_PublicRenderParameters3_declaringPRP4";
   public final static String V3ANNOTATIONPORTLETAPPCONFIGOVERRIDETESTS_SPEC1_28_PORTLETCONTAINERRUNTIMEOPTIONS_DECLARINGPCRO2 = "V3AnnotationPortletAppConfigOverrideTests_SPEC1_28_PortletContainerRuntimeOptions_declaringPCRO2";
   public final static String V3ANNOTATIONPORTLETAPPCONFIGOVERRIDETESTS_SPEC1_28_PORTLETCONTAINERRUNTIMEOPTIONS_DECLARINGPCRO3 = "V3AnnotationPortletAppConfigOverrideTests_SPEC1_28_PortletContainerRuntimeOptions_declaringPCRO3";

   
   private final static Map<String, String> tcd = new HashMap<String, String>();
   static {

      tcd.put(V3ANNOTATIONPORTLETAPPCONFIGOVERRIDETESTS_SPEC1_28_PORTLETMODES_DECLARINGPORTLETMODES7, "A custom portlet mode declared in the @PortletApplication annotation could be overridden by deployment descriptor portlet.xml");
      tcd.put(V3ANNOTATIONPORTLETAPPCONFIGOVERRIDETESTS_SPEC1_28_PORTLETMODES_DECLARINGPORTLETMODES8, "The portlet container merges the portlet modes declared in the @PortletApplication annotation and deployment descriptor portlet.xml");
      tcd.put(V3ANNOTATIONPORTLETAPPCONFIGOVERRIDETESTS_SPEC1_28_WINDOWSTATES_DECLARINGWINDOWSTATES5, "A custom window state declared in the @PortletApplication annotation could be overridden by deployment descriptor portlet.xml");
      tcd.put(V3ANNOTATIONPORTLETAPPCONFIGOVERRIDETESTS_SPEC1_28_WINDOWSTATES_DECLARINGWINDOWSTATES6, "The portlet container merges the window states declared in the @PortletApplication annotation and deployment descriptor portlet.xml");
      tcd.put(V3ANNOTATIONPORTLETAPPCONFIGOVERRIDETESTS_SPEC1_28_DEFAULTNAMESPACEURI_DECLARINGDEFAULTNAMESPACEURI2, "DefaultNamespaceURI defined in the @PortletApplication annotation could be overridden by deployment descriptor portlet.xml");
      tcd.put(V3ANNOTATIONPORTLETAPPCONFIGOVERRIDETESTS_SPEC1_28_EVENTCONFIGURATION1_DECLARINGEVENTS3, "Same event declared in @PortletApplication and deployment descriptor portlet.xml is overridden by deployment descriptor");
      tcd.put(V3ANNOTATIONPORTLETAPPCONFIGOVERRIDETESTS_SPEC1_28_EVENTCONFIGURATION2_DECLARINGEVENTS4, "The portlet container merges the events declared in the @PortletApplication annotation and deployment descriptor portlet.xml");
      tcd.put(V3ANNOTATIONPORTLETAPPCONFIGOVERRIDETESTS_SPEC1_28_PUBLICRENDERPARAMETERS1_DECLARINGPRP2, "A public render parameters can be declared two times - once in @PortletApplication then again in deployment descriptor portlet.xml");
      tcd.put(V3ANNOTATIONPORTLETAPPCONFIGOVERRIDETESTS_SPEC1_28_PUBLICRENDERPARAMETERS2_DECLARINGPRP3, "A public render parameters declared using @PortletApplication annotation in one portlet and deployment descriptor portlet.xml in another portlet can be shared with each other.");
      tcd.put(V3ANNOTATIONPORTLETAPPCONFIGOVERRIDETESTS_SPEC1_28_PUBLICRENDERPARAMETERS3_DECLARINGPRP4, "The portlet container merges the public render parameters declared in the @PortletApplication annotation and deployment descriptor portlet.xml");
      tcd.put(V3ANNOTATIONPORTLETAPPCONFIGOVERRIDETESTS_SPEC1_28_PORTLETCONTAINERRUNTIMEOPTIONS_DECLARINGPCRO2, "A portlet container runtime option declared in the @PortletApplication annotation could be overridden by deployment descriptor portlet.xml");
      tcd.put(V3ANNOTATIONPORTLETAPPCONFIGOVERRIDETESTS_SPEC1_28_PORTLETCONTAINERRUNTIMEOPTIONS_DECLARINGPCRO3, "The portlet container merges the portlet container runtime options declared in the @PortletApplication annotation and deployment descriptor portlet.xml");

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
