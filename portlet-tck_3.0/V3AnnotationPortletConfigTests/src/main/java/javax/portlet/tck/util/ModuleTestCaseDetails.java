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

   public final static String V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_DEFAULTNAMESPACEURI_DECLARINGDEFAULTNAMESPACEURI1 = "V3AnnotationPortletApplicationConfigTests_SPEC1_28_DefaultNamespaceURI_declaringDefaultNamespaceURI1";
   public final static String V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_PORTLETCONTAINERRUNTIMEOPTIONS_DECLARINGPCRO1 = "V3AnnotationPortletConfigTests_SPEC2_28_PortletContainerRuntimeOptions_declaringPCRO1";
   public final static String V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_PORTLETINITPARAMETERS_DECLARINGINITPARAMS1 = "V3AnnotationPortletConfigTests_SPEC2_28_PortletInitParameters_declaringInitParams1";
   public final static String V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_PORTLETINITPARAMETERS_DECLARINGINITPARAMS3 = "V3AnnotationPortletConfigTests_SPEC2_28_PortletInitParameters_declaringInitParams3";
   public final static String V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_PORTLETINITPARAMETERS_DECLARINGINITPARAMS4 = "V3AnnotationPortletConfigTests_SPEC2_28_PortletInitParameters_declaringInitParams4";
   public final static String V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_PORTLETIDENTIFICATION_DECLARINGPORTLETNAME = "V3AnnotationPortletConfigTests_SPEC2_28_PortletIdentification_declaringPortletName";
   public final static String V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_PORTLETIDENTIFICATION_DECLARINGPORTLETDESCRIPTION = "V3AnnotationPortletConfigTests_SPEC2_28_PortletIdentification_declaringPortletDescription";
   public final static String V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_PORTLETIDENTIFICATION_DECLARINGPORTLETDISPLAYNAME = "V3AnnotationPortletConfigTests_SPEC2_28_PortletIdentification_declaringPortletDisplayName";
   public final static String V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_PORTLETIDENTIFICATION_DECLARINGPORTLETTITLE = "V3AnnotationPortletConfigTests_SPEC2_28_PortletIdentification_declaringPortletTitle";
   public final static String V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_PORTLETIDENTIFICATION_DECLARINGPORTLETSHORTTITLE = "V3AnnotationPortletConfigTests_SPEC2_28_PortletIdentification_declaringPortletShortTitle";
   public final static String V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_PORTLETIDENTIFICATION_DECLARINGPORTLETKEYWORDS = "V3AnnotationPortletConfigTests_SPEC2_28_PortletIdentification_declaringPortletKeywords";
   public final static String V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_RESOURCEBUNDLE_DECLARINGRESOURCEBUNDLE1 = "V3AnnotationPortletConfigTests_SPEC2_28_ResourceBundle_declaringResourceBundle1";
   public final static String V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_RESOURCEBUNDLE_DECLARINGRESOURCEBUNDLE2 = "V3AnnotationPortletConfigTests_SPEC2_28_ResourceBundle_declaringResourceBundle2";
   public final static String V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_CACHESETTINGS_DECLARINGCACHE1 = "V3AnnotationPortletConfigTests_SPEC2_28_CacheSettings_declaringCache1";
   public final static String V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_CACHESETTINGS_DECLARINGCACHE2 = "V3AnnotationPortletConfigTests_SPEC2_28_CacheSettings_declaringCache2";
   public final static String V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_SECURITYROLE_DECLARINGSECURITYROLE1 = "V3AnnotationPortletConfigTests_SPEC2_28_SecurityRole_declaringSecurityRole1";
   public final static String V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_PORTLETDEPENDENCY_DECLARINGDEPENDENCY1 = "V3AnnotationPortletConfigTests_SPEC2_28_PortletDependency_declaringDependency1";
   public final static String V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_EVENTDECLARATION_EVENTEVENTDECLARATION1 = "V3AnnotationPortletConfigTests_SPEC2_28_EventDeclaration_eventEventDeclaration1";
   public final static String V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_SUPPORTEDLOCALES_DECLARINGSUPPORTEDLOCALES1 = "V3AnnotationPortletConfigTests_SPEC2_28_SupportedLocales_declaringSupportedLocales1";
   public final static String V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_PORTLETPREFERENCES_DECLARINGPORTLETPREFERENCES1 = "V3AnnotationPortletConfigTests_SPEC2_28_PortletPreferences_declaringPortletPreferences1";
   public final static String V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_PORTLETPREFERENCES_DECLARINGPORTLETPREFERENCES2 = "V3AnnotationPortletConfigTests_SPEC2_28_PortletPreferences_declaringPortletPreferences2";
   public final static String V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_ASYNCHRONOUSSUPPORT_DECLARINGASYNCSUPPORT1 = "V3AnnotationPortletConfigTests_SPEC2_28_AsynchronousSupport_declaringAsyncSupport1";

   
   private final static Map<String, String> tcd = new HashMap<String, String>();
   static {

      tcd.put(V3ANNOTATIONPORTLETAPPLICATIONCONFIGTESTS_SPEC1_28_DEFAULTNAMESPACEURI_DECLARINGDEFAULTNAMESPACEURI1, "DefaultNamespaceURI may be declared in the @PortletApplication annotation.");
      tcd.put(V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_PORTLETCONTAINERRUNTIMEOPTIONS_DECLARINGPCRO1, "Portlet container runtime options may be declared in the @PortletConfiguration annotation using @RuntimeOption annotation.");
      tcd.put(V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_PORTLETINITPARAMETERS_DECLARINGINITPARAMS1, "Portlet initialization parameters may be declared in the @PortletConfiguration annotation using @InitParameter annotation.");
      tcd.put(V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_PORTLETINITPARAMETERS_DECLARINGINITPARAMS3, "An initialization parameter with empty value can be declared in @InitParameter annotation.");
      tcd.put(V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_PORTLETINITPARAMETERS_DECLARINGINITPARAMS4, "An initialization parameter with empty name can be declared in @InitParameter annotation.");
      tcd.put(V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_PORTLETIDENTIFICATION_DECLARINGPORTLETNAME, "Portlet name may be set using \"portletName\" attribute of @PortletConfiguration annotation. ");
      tcd.put(V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_PORTLETIDENTIFICATION_DECLARINGPORTLETDESCRIPTION, "Portlet description may be set using \"description\" attribute of @PortletConfiguration annotation.");
      tcd.put(V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_PORTLETIDENTIFICATION_DECLARINGPORTLETDISPLAYNAME, "Portlet display name may be set using \"displayName\" attribute of @PortletConfiguration annotation.");
      tcd.put(V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_PORTLETIDENTIFICATION_DECLARINGPORTLETTITLE, "Portlet title may be set using \"title\" attribute of @PortletConfiguration annotation.");
      tcd.put(V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_PORTLETIDENTIFICATION_DECLARINGPORTLETSHORTTITLE, "Portlet short title may be set using \"shortTitle\" attribute of @PortletConfiguration annotation.");
      tcd.put(V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_PORTLETIDENTIFICATION_DECLARINGPORTLETKEYWORDS, "Portlet keywords may be set using \"keywords\" attribute of @PortletConfiguration annotation.");
      tcd.put(V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_RESOURCEBUNDLE_DECLARINGRESOURCEBUNDLE1, "The resource bundle defined in the @PortletConfiguration annotation - resourceBundle attribute, can be obtained through the PortletConfig object.");
      tcd.put(V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_RESOURCEBUNDLE_DECLARINGRESOURCEBUNDLE2, "The resource bundle overrides the identification information set in @PortletConfiguration annotation.");
      tcd.put(V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_CACHESETTINGS_DECLARINGCACHE1, "The cache expiration time can be set through \"cacheExpirationTime\" attribute of @PortletConfiguration annotation.");
      tcd.put(V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_CACHESETTINGS_DECLARINGCACHE2, "The cache scope can be set through \"cacheScopePublic\" attribute of @PortletConfiguration annotation.");
      tcd.put(V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_SECURITYROLE_DECLARINGSECURITYROLE1, "Security roles options may be declared in the @PortletConfiguration annotation using @SecurityRoleRef annotation.");
      tcd.put(V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_PORTLETDEPENDENCY_DECLARINGDEPENDENCY1, "Portlet dependency may be declared using @Dependency annotation in @PortletConfiguration annotation.");
      tcd.put(V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_EVENTDECLARATION_EVENTEVENTDECLARATION1, "An event can be fired from another event method configured with @EventMethod annotation - publishingEvents attribute.");
      tcd.put(V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_SUPPORTEDLOCALES_DECLARINGSUPPORTEDLOCALES1, "Support for locales can be defined using \"supportedLocales\" attribute of @PortletConfiguration annotation.");
      tcd.put(V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_PORTLETPREFERENCES_DECLARINGPORTLETPREFERENCES1, "Portlet preferences can be declared using @Preference annotation in @PortletConfiguration annotation.");
      tcd.put(V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_PORTLETPREFERENCES_DECLARINGPORTLETPREFERENCES2, "Preference value can be set to read only by specifying \"isReadOnly\" attribute of @PortletAnnotation to be true.");
      tcd.put(V3ANNOTATIONPORTLETCONFIGTESTS_SPEC2_28_ASYNCHRONOUSSUPPORT_DECLARINGASYNCSUPPORT1, "Support for asynchronous resource request can be configured using \"asyncSupported\" attribute of @PortletConfiguration annotation.");

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
