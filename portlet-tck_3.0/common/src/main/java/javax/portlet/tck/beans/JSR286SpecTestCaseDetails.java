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

package javax.portlet.tck.beans;

import java.util.HashMap;
import java.util.Map;

/**
 * Defines constants for the test case names and test case details for the JSR 286 API compatibility tests.
 * 
 * Note that the backing map is static and not threadsafe. Operations that change the map such as put, remove, etc.,
 * should not be used in portlets.
 * 
 * @author nick
 */
public class JSR286SpecTestCaseDetails extends TestCaseDetails {

   public final static String               V2ADDLPORTLETTESTS_SPEC2_2_COMPATIBILITY_DEPLOYJSR168_1                        = "V2AddlPortletTests_SPEC2_2_Compatibility_deployJSR168_1";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_2_COMPATIBILITY_DEPLOYJSR168_2                        = "V2AddlPortletTests_SPEC2_2_Compatibility_deployJSR168_2";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_5_INITIALIZATION_INITIALIZATION6                      = "V2AddlPortletTests_SPEC2_5_Initialization_initialization6";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_5_ACTIONHANDLING_ACTION5                              = "V2AddlPortletTests_SPEC2_5_ActionHandling_action5";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_5_ACTIONHANDLING_ACTION6                              = "V2AddlPortletTests_SPEC2_5_ActionHandling_action6";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_5_ACTIONHANDLING_ACTION7                              = "V2AddlPortletTests_SPEC2_5_ActionHandling_action7";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_5_ACTIONHANDLING_EXCEPTION1                           = "V2AddlPortletTests_SPEC2_5_ActionHandling_exception1";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_5_ACTIONHANDLING_EXCEPTION2                           = "V2AddlPortletTests_SPEC2_5_ActionHandling_exception2";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_5_RENDERHANDLING_RENDER1                              = "V2AddlPortletTests_SPEC2_5_RenderHandling_render1";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_5_RESOURCEHANDLING_RESOURCE1                          = "V2AddlPortletTests_SPEC2_5_ResourceHandling_resource1";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_5_EVENTHANDLING_EXCEPTION4                            = "V2AddlPortletTests_SPEC2_5_EventHandling_exception4";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_5_EVENTHANDLING_EXCEPTION5                            = "V2AddlPortletTests_SPEC2_5_EventHandling_exception5";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_5_RENDERGENERICPORTLET_ACTIONDISPATCHING2             = "V2AddlPortletTests_SPEC2_5_RenderGenericPortlet_actionDispatching2";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_5_RENDERGENERICPORTLET_EVENTDISPATCHING1              = "V2AddlPortletTests_SPEC2_5_RenderGenericPortlet_eventDispatching1";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_5_RENDERGENERICPORTLET_EVENTDISPATCHING2              = "V2AddlPortletTests_SPEC2_5_RenderGenericPortlet_eventDispatching2";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_5_RENDERGENERICPORTLET_RENDERDISPATCHING8             = "V2AddlPortletTests_SPEC2_5_RenderGenericPortlet_renderDispatching8";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_5_RENDERGENERICPORTLET_RENDERDISPATCHING9             = "V2AddlPortletTests_SPEC2_5_RenderGenericPortlet_renderDispatching9";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG_GETRESOURCEBUNDLE1                     = "V2AddlPortletTests_SPEC2_6_RenderConfig_getResourceBundle1";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG_GETRESOURCEBUNDLE2                     = "V2AddlPortletTests_SPEC2_6_RenderConfig_getResourceBundle2";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG_GETRESOURCEBUNDLE3                     = "V2AddlPortletTests_SPEC2_6_RenderConfig_getResourceBundle3";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG_GETRESOURCEBUNDLE4                     = "V2AddlPortletTests_SPEC2_6_RenderConfig_getResourceBundle4";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG_GETPUBLISHINGEVENTQNAMES3              = "V2AddlPortletTests_SPEC2_6_RenderConfig_getPublishingEventQnames3";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG_GETPUBLISHINGEVENTQNAMES4              = "V2AddlPortletTests_SPEC2_6_RenderConfig_getPublishingEventQnames4";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG_GETPROCESSINGEVENTQNAMES3              = "V2AddlPortletTests_SPEC2_6_RenderConfig_getProcessingEventQnames3";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG_GETPROCESSINGEVENTQNAMES4              = "V2AddlPortletTests_SPEC2_6_RenderConfig_getProcessingEventQnames4";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG_GETCONTAINERRUNTIMEOPTIONS6            = "V2AddlPortletTests_SPEC2_6_RenderConfig_getContainerRuntimeOptions6";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG_GETCONTAINERRUNTIMEOPTIONS7            = "V2AddlPortletTests_SPEC2_6_RenderConfig_getContainerRuntimeOptions7";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG_GETCONTAINERRUNTIMEOPTIONS8            = "V2AddlPortletTests_SPEC2_6_RenderConfig_getContainerRuntimeOptions8";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG_GETCONTAINERRUNTIMEOPTIONS9            = "V2AddlPortletTests_SPEC2_6_RenderConfig_getContainerRuntimeOptions9";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG_GETDEFAULTNAMESPACE2                   = "V2AddlPortletTests_SPEC2_6_RenderConfig_getDefaultNamespace2";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG_GETCONTAINERRUNTIMEOPTIONS4            = "V2AddlPortletTests_SPEC2_6_RenderConfig_getContainerRuntimeOptions4";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG2_GETRESOURCEBUNDLE8                    = "V2AddlPortletTests_SPEC2_6_RenderConfig2_getResourceBundle8";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG2_GETRESOURCEBUNDLE9                    = "V2AddlPortletTests_SPEC2_6_RenderConfig2_getResourceBundle9";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG2_GETRESOURCEBUNDLE10                   = "V2AddlPortletTests_SPEC2_6_RenderConfig2_getResourceBundle10";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG3_GETRESOURCEBUNDLE5                    = "V2AddlPortletTests_SPEC2_6_RenderConfig3_getResourceBundle5";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG3_GETRESOURCEBUNDLE6                    = "V2AddlPortletTests_SPEC2_6_RenderConfig3_getResourceBundle6";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG3_GETRESOURCEBUNDLE7                    = "V2AddlPortletTests_SPEC2_6_RenderConfig3_getResourceBundle7";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_8_PORTLETMODES_DECLARINGPORTLETMODES1                 = "V2AddlPortletTests_SPEC2_8_PortletModes_declaringPortletModes1";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_8_PORTLETMODES_DECLARINGPORTLETMODES2                 = "V2AddlPortletTests_SPEC2_8_PortletModes_declaringPortletModes2";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_8_PORTLETMODES_DECLARINGPORTLETMODES3                 = "V2AddlPortletTests_SPEC2_8_PortletModes_declaringPortletModes3";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_8_PORTLETMODES_DECLARINGPORTLETMODES4                 = "V2AddlPortletTests_SPEC2_8_PortletModes_declaringPortletModes4";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_8_PORTLETMODES_DECLARINGPORTLETMODES5                 = "V2AddlPortletTests_SPEC2_8_PortletModes_declaringPortletModes5";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_8_PORTLETMODES_DECLARINGPORTLETMODES6                 = "V2AddlPortletTests_SPEC2_8_PortletModes_declaringPortletModes6";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_8_PORTLETMODES_DECLARINGPORTLETMODES7                 = "V2AddlPortletTests_SPEC2_8_PortletModes_declaringPortletModes7";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_8_PORTLETMODES_DECLARINGPORTLETMODES8                 = "V2AddlPortletTests_SPEC2_8_PortletModes_declaringPortletModes8";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_8_PORTLETMODES_DECLARINGPORTLETMODES9                 = "V2AddlPortletTests_SPEC2_8_PortletModes_declaringPortletModes9";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_9_WINDOWSTATES_DECLARINGWINDOWSTATES1                 = "V2AddlPortletTests_SPEC2_9_WindowStates_declaringWindowStates1";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_9_WINDOWSTATES_DECLARINGWINDOWSTATES2                 = "V2AddlPortletTests_SPEC2_9_WindowStates_declaringWindowStates2";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_9_WINDOWSTATES_DECLARINGWINDOWSTATES3                 = "V2AddlPortletTests_SPEC2_9_WindowStates_declaringWindowStates3";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_9_WINDOWSTATES_DECLARINGWINDOWSTATES4                 = "V2AddlPortletTests_SPEC2_9_WindowStates_declaringWindowStates4";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_9_WINDOWSTATES_DECLARINGWINDOWSTATES5                 = "V2AddlPortletTests_SPEC2_9_WindowStates_declaringWindowStates5";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_9_WINDOWSTATES_DECLARINGWINDOWSTATES6                 = "V2AddlPortletTests_SPEC2_9_WindowStates_declaringWindowStates6";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_9_WINDOWSTATES_DECLARINGWINDOWSTATES7                 = "V2AddlPortletTests_SPEC2_9_WindowStates_declaringWindowStates7";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVING_RESOURCEURLS2                      = "V2AddlPortletTests_SPEC2_13_ResourceServing_resourceURLs2";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVING_RESOURCEURLS4                      = "V2AddlPortletTests_SPEC2_13_ResourceServing_resourceURLs4";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVING_RESOURCEURLS5                      = "V2AddlPortletTests_SPEC2_13_ResourceServing_resourceURLs5";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVING_RESOURCEURLS6                      = "V2AddlPortletTests_SPEC2_13_ResourceServing_resourceURLs6";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVING_RESOURCEURLS7                      = "V2AddlPortletTests_SPEC2_13_ResourceServing_resourceURLs7";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVING_RESOURCEURLS8                      = "V2AddlPortletTests_SPEC2_13_ResourceServing_resourceURLs8";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVING_RESOURCEURLS9                      = "V2AddlPortletTests_SPEC2_13_ResourceServing_resourceURLs9";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHING1                      = "V2AddlPortletTests_SPEC2_13_ResourceServingCache_caching1";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHING2                      = "V2AddlPortletTests_SPEC2_13_ResourceServingCache_caching2";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHING3                      = "V2AddlPortletTests_SPEC2_13_ResourceServingCache_caching3";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGFULL1                  = "V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingFULL1";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGFULL2                  = "V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingFULL2";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGFULL3                  = "V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingFULL3";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGFULL4                  = "V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingFULL4";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGFULL5                  = "V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingFULL5";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGFULL6                  = "V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingFULL6";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGFULL7                  = "V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingFULL7";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGFULL8                  = "V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingFULL8";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGFULL9                  = "V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingFULL9";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPORTLET1               = "V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPORTLET1";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPORTLET2               = "V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPORTLET2";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPORTLET3               = "V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPORTLET3";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPORTLET4               = "V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPORTLET4";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPORTLET5               = "V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPORTLET5";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPORTLET6               = "V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPORTLET6";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPORTLET7               = "V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPORTLET7";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPORTLET8               = "V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPORTLET8";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPORTLET9               = "V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPORTLET9";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPAGE1                  = "V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPAGE1";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPAGE2                  = "V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPAGE2";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPAGE3                  = "V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPAGE3";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPAGE4                  = "V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPAGE4";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPAGE5                  = "V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPAGE5";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPAGE6                  = "V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPAGE6";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPAGE7                  = "V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPAGE7";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPAGE8                  = "V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPAGE8";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPAGE9                  = "V2AddlPortletTests_SPEC2_13_ResourceServingCache_cachingPAGE9";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_15_EVENT_EVENT1                                       = "V2AddlPortletTests_SPEC2_15_Event_event1";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_15_RENDEREVENTHANDLING_EVENT2                         = "V2AddlPortletTests_SPEC2_15_RenderEventHandling_event2";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_15_RENDEREVENTHANDLING_EVENT3                         = "V2AddlPortletTests_SPEC2_15_RenderEventHandling_event3";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_15_RENDEREVENTHANDLING_EVENT4                         = "V2AddlPortletTests_SPEC2_15_RenderEventHandling_event4";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENT5                          = "V2AddlPortletTests_SPEC2_15_EventEventHandling_event5";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENT6                          = "V2AddlPortletTests_SPEC2_15_EventEventHandling_event6";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENT7                          = "V2AddlPortletTests_SPEC2_15_EventEventHandling_event7";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENT8                          = "V2AddlPortletTests_SPEC2_15_EventEventHandling_event8";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENT9                          = "V2AddlPortletTests_SPEC2_15_EventEventHandling_event9";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENT10                         = "V2AddlPortletTests_SPEC2_15_EventEventHandling_event10";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENT11                         = "V2AddlPortletTests_SPEC2_15_EventEventHandling_event11";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENT15                         = "V2AddlPortletTests_SPEC2_15_EventEventHandling_event15";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENT16                         = "V2AddlPortletTests_SPEC2_15_EventEventHandling_event16";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENTPROCESSEVENT1              = "V2AddlPortletTests_SPEC2_15_EventEventHandling_eventProcessEvent1";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENTPROCESSEVENT2              = "V2AddlPortletTests_SPEC2_15_EventEventHandling_eventProcessEvent2";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENTPROCESSEVENT3              = "V2AddlPortletTests_SPEC2_15_EventEventHandling_eventProcessEvent3";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENTPROCESSEVENT4              = "V2AddlPortletTests_SPEC2_15_EventEventHandling_eventProcessEvent4";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENTPROCESSEVENT5              = "V2AddlPortletTests_SPEC2_15_EventEventHandling_eventProcessEvent5";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENTPROCESSEVENT6              = "V2AddlPortletTests_SPEC2_15_EventEventHandling_eventProcessEvent6";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENTPROCESSEVENT7              = "V2AddlPortletTests_SPEC2_15_EventEventHandling_eventProcessEvent7";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENTPROCESSEVENT8              = "V2AddlPortletTests_SPEC2_15_EventEventHandling_eventProcessEvent8";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENTPROCESSEVENT9              = "V2AddlPortletTests_SPEC2_15_EventEventHandling_eventProcessEvent9";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_15_ACTIONEVENTHANDLING_EVENTPROCESSACTION1            = "V2AddlPortletTests_SPEC2_15_ActionEventHandling_eventProcessAction1";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_15_ACTIONEVENTHANDLING_EVENTPROCESSACTION2            = "V2AddlPortletTests_SPEC2_15_ActionEventHandling_eventProcessAction2";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_15_ACTIONEVENTHANDLING_EVENTPROCESSACTION3            = "V2AddlPortletTests_SPEC2_15_ActionEventHandling_eventProcessAction3";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_15_ACTIONEVENTHANDLING_EVENTPROCESSACTION4            = "V2AddlPortletTests_SPEC2_15_ActionEventHandling_eventProcessAction4";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_15_ACTIONEVENTHANDLING_EVENTPROCESSACTION5            = "V2AddlPortletTests_SPEC2_15_ActionEventHandling_eventProcessAction5";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_15_ACTIONEVENTHANDLING_EVENTPROCESSACTION6            = "V2AddlPortletTests_SPEC2_15_ActionEventHandling_eventProcessAction6";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_15_ACTIONEVENTHANDLING_EVENTPROCESSACTION7            = "V2AddlPortletTests_SPEC2_15_ActionEventHandling_eventProcessAction7";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_15_ACTIONEVENTHANDLING_EVENTPROCESSACTION8            = "V2AddlPortletTests_SPEC2_15_ActionEventHandling_eventProcessAction8";
   public final static String               V2ADDLPORTLETTESTS_SPEC2_15_ACTIONEVENTHANDLING_EVENTPROCESSACTION9            = "V2AddlPortletTests_SPEC2_15_ActionEventHandling_eventProcessAction9";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXT_PORTLETCONTEXTSERVLETCONTEXT1          = "V2AddlEnvironmentTests_SPEC2_10_Context_portletContextServletContext1";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXT_PORTLETCONTEXTSERVLETCONTEXT2          = "V2AddlEnvironmentTests_SPEC2_10_Context_portletContextServletContext2";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXT_PORTLETCONTEXTSERVLETCONTEXT3          = "V2AddlEnvironmentTests_SPEC2_10_Context_portletContextServletContext3";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXT_PORTLETCONTEXTSERVLETCONTEXT4          = "V2AddlEnvironmentTests_SPEC2_10_Context_portletContextServletContext4";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXT_GETATTRIBUTE                           = "V2AddlEnvironmentTests_SPEC2_10_Context_getAttribute";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXT_GETATTRIBUTENAMES                      = "V2AddlEnvironmentTests_SPEC2_10_Context_getAttributeNames";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXT_GETINITPARAMETER                       = "V2AddlEnvironmentTests_SPEC2_10_Context_getInitParameter";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXT_GETINITPARAMETERNAMES                  = "V2AddlEnvironmentTests_SPEC2_10_Context_getInitParameterNames";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXT_GETMIMETYPE                            = "V2AddlEnvironmentTests_SPEC2_10_Context_getMimeType";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXT_GETREALPATH                            = "V2AddlEnvironmentTests_SPEC2_10_Context_getRealPath";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXT_GETRESOURCE                            = "V2AddlEnvironmentTests_SPEC2_10_Context_getResource";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXT_GETRESOURCEPATHS                       = "V2AddlEnvironmentTests_SPEC2_10_Context_getResourcePaths";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXT_GETRESOURCEASSTREAM                    = "V2AddlEnvironmentTests_SPEC2_10_Context_getResourceAsStream";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXT_LOG                                    = "V2AddlEnvironmentTests_SPEC2_10_Context_log";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXT_REMOVEATTRIBUTE                        = "V2AddlEnvironmentTests_SPEC2_10_Context_removeAttribute";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXT_SETATTRIBUTE                           = "V2AddlEnvironmentTests_SPEC2_10_Context_setAttribute";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_CONTAINERRUNTIMEOPTIONS1        = "V2AddlEnvironmentTests_SPEC2_10_ContextOptions_containerRuntimeOptions1";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES1  = "V2AddlEnvironmentTests_SPEC2_10_ContextOptions_actionScopedRequestAttributes1";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES2  = "V2AddlEnvironmentTests_SPEC2_10_ContextOptions_actionScopedRequestAttributes2";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES3  = "V2AddlEnvironmentTests_SPEC2_10_ContextOptions_actionScopedRequestAttributes3";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES4  = "V2AddlEnvironmentTests_SPEC2_10_ContextOptions_actionScopedRequestAttributes4";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES5  = "V2AddlEnvironmentTests_SPEC2_10_ContextOptions_actionScopedRequestAttributes5";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES5A  = "V2AddlEnvironmentTests_SPEC2_10_ContextOptions_actionScopedRequestAttributes5a";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES6  = "V2AddlEnvironmentTests_SPEC2_10_ContextOptions_actionScopedRequestAttributes6";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES7  = "V2AddlEnvironmentTests_SPEC2_10_ContextOptions_actionScopedRequestAttributes7";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES8  = "V2AddlEnvironmentTests_SPEC2_10_ContextOptions_actionScopedRequestAttributes8";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES9  = "V2AddlEnvironmentTests_SPEC2_10_ContextOptions_actionScopedRequestAttributes9";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES0  = "V2AddlEnvironmentTests_SPEC2_10_ContextOptions_actionScopedRequestAttributes0";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES11 = "V2AddlEnvironmentTests_SPEC2_10_ContextOptions_actionScopedRequestAttributes11";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES12 = "V2AddlEnvironmentTests_SPEC2_10_ContextOptions_actionScopedRequestAttributes12";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES13 = "V2AddlEnvironmentTests_SPEC2_10_ContextOptions_actionScopedRequestAttributes13";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_17_ACTIONPREFERENCES_SETVALUES4                   = "V2AddlEnvironmentTests_SPEC2_17_ActionPreferences_setValues4";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_17_ACTIONPREFERENCES_RESET1                       = "V2AddlEnvironmentTests_SPEC2_17_ActionPreferences_reset1";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_17_ACTIONPREFERENCES_STORE1                       = "V2AddlEnvironmentTests_SPEC2_17_ActionPreferences_store1";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_17_ACTIONPREFERENCES_STORE4                       = "V2AddlEnvironmentTests_SPEC2_17_ActionPreferences_store4";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_17_ACTIONPREFERENCES_DEPLOYMENT3                  = "V2AddlEnvironmentTests_SPEC2_17_ActionPreferences_deployment3";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_17_ACTIONPREFERENCES_DEPLOYMENT4                  = "V2AddlEnvironmentTests_SPEC2_17_ActionPreferences_deployment4";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_17_ACTIONPREFERENCES_DEPLOYMENT7                  = "V2AddlEnvironmentTests_SPEC2_17_ActionPreferences_deployment7";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_17_ACTIONPREFERENCES_DEPLOYMENT10                 = "V2AddlEnvironmentTests_SPEC2_17_ActionPreferences_deployment10";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_17_EVENTPREFERENCES_SETVALUES4                    = "V2AddlEnvironmentTests_SPEC2_17_EventPreferences_setValues4";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_17_EVENTPREFERENCES_RESET1                        = "V2AddlEnvironmentTests_SPEC2_17_EventPreferences_reset1";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_17_EVENTPREFERENCES_STORE1                        = "V2AddlEnvironmentTests_SPEC2_17_EventPreferences_store1";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_17_EVENTPREFERENCES_STORE4                        = "V2AddlEnvironmentTests_SPEC2_17_EventPreferences_store4";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_17_EVENTPREFERENCES_DEPLOYMENT3                   = "V2AddlEnvironmentTests_SPEC2_17_EventPreferences_deployment3";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_17_EVENTPREFERENCES_DEPLOYMENT4                   = "V2AddlEnvironmentTests_SPEC2_17_EventPreferences_deployment4";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_17_EVENTPREFERENCES_DEPLOYMENT7                   = "V2AddlEnvironmentTests_SPEC2_17_EventPreferences_deployment7";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_17_EVENTPREFERENCES_DEPLOYMENT10                  = "V2AddlEnvironmentTests_SPEC2_17_EventPreferences_deployment10";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_17_RESOURCEPREFERENCES_SETVALUES4                 = "V2AddlEnvironmentTests_SPEC2_17_ResourcePreferences_setValues4";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_17_RESOURCEPREFERENCES_RESET1                     = "V2AddlEnvironmentTests_SPEC2_17_ResourcePreferences_reset1";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_17_RESOURCEPREFERENCES_STORE1                     = "V2AddlEnvironmentTests_SPEC2_17_ResourcePreferences_store1";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_17_RESOURCEPREFERENCES_STORE4                     = "V2AddlEnvironmentTests_SPEC2_17_ResourcePreferences_store4";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_17_RESOURCEPREFERENCES_DEPLOYMENT3                = "V2AddlEnvironmentTests_SPEC2_17_ResourcePreferences_deployment3";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_17_RESOURCEPREFERENCES_DEPLOYMENT4                = "V2AddlEnvironmentTests_SPEC2_17_ResourcePreferences_deployment4";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_17_RESOURCEPREFERENCES_DEPLOYMENT7                = "V2AddlEnvironmentTests_SPEC2_17_ResourcePreferences_deployment7";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_17_RESOURCEPREFERENCES_DEPLOYMENT10               = "V2AddlEnvironmentTests_SPEC2_17_ResourcePreferences_deployment10";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_17_RENDERPREFERENCES_DEPLOYMENT1                  = "V2AddlEnvironmentTests_SPEC2_17_RenderPreferences_deployment1";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_17_RENDERPREFERENCES_DEPLOYMENT2                  = "V2AddlEnvironmentTests_SPEC2_17_RenderPreferences_deployment2";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_SCOPE1                                = "V2AddlEnvironmentTests_SPEC2_18_Sessions_scope1";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_SCOPE2                                = "V2AddlEnvironmentTests_SPEC2_18_Sessions_scope2";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_SCOPE3                                = "V2AddlEnvironmentTests_SPEC2_18_Sessions_scope3";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_SCOPE4                                = "V2AddlEnvironmentTests_SPEC2_18_Sessions_scope4";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_SCOPE5                                = "V2AddlEnvironmentTests_SPEC2_18_Sessions_scope5";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_SETATTRIBUTE1                         = "V2AddlEnvironmentTests_SPEC2_18_Sessions_setAttribute1";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_SETATTRIBUTE2                         = "V2AddlEnvironmentTests_SPEC2_18_Sessions_setAttribute2";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_SETATTRIBUTE3                         = "V2AddlEnvironmentTests_SPEC2_18_Sessions_setAttribute3";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_GETATTRIBUTE1                         = "V2AddlEnvironmentTests_SPEC2_18_Sessions_getAttribute1";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_GETATTRIBUTE2                         = "V2AddlEnvironmentTests_SPEC2_18_Sessions_getAttribute2";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_GETATTRIBUTE3                         = "V2AddlEnvironmentTests_SPEC2_18_Sessions_getAttribute3";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_REMOVEATTRIBUTE1                      = "V2AddlEnvironmentTests_SPEC2_18_Sessions_removeAttribute1";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_REMOVEATTRIBUTE2                      = "V2AddlEnvironmentTests_SPEC2_18_Sessions_removeAttribute2";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_REMOVEATTRIBUTE3                      = "V2AddlEnvironmentTests_SPEC2_18_Sessions_removeAttribute3";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_GETATTRIBUTENAMES1                    = "V2AddlEnvironmentTests_SPEC2_18_Sessions_getAttributeNames1";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_GETATTRIBUTENAMES2                    = "V2AddlEnvironmentTests_SPEC2_18_Sessions_getAttributeNames2";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_GETATTRIBUTENAMES3                    = "V2AddlEnvironmentTests_SPEC2_18_Sessions_getAttributeNames3";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_DECODEATTRIBUTENAME1                  = "V2AddlEnvironmentTests_SPEC2_18_Sessions_decodeAttributeName1";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_DECODEATTRIBUTENAME2                  = "V2AddlEnvironmentTests_SPEC2_18_Sessions_decodeAttributeName2";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_HTTPSESSION1                          = "V2AddlEnvironmentTests_SPEC2_18_Sessions_httpSession1";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_HTTPSESSION2                          = "V2AddlEnvironmentTests_SPEC2_18_Sessions_httpSession2";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_HTTPSESSION3                          = "V2AddlEnvironmentTests_SPEC2_18_Sessions_httpSession3";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_HTTPSESSION4                          = "V2AddlEnvironmentTests_SPEC2_18_Sessions_httpSession4";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_HTTPSESSION5                          = "V2AddlEnvironmentTests_SPEC2_18_Sessions_httpSession5";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_HTTPSESSION6                          = "V2AddlEnvironmentTests_SPEC2_18_Sessions_httpSession6";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_HTTPSESSION7                          = "V2AddlEnvironmentTests_SPEC2_18_Sessions_httpSession7";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_HTTPSESSION8                          = "V2AddlEnvironmentTests_SPEC2_18_Sessions_httpSession8";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_HTTPSESSION9                          = "V2AddlEnvironmentTests_SPEC2_18_Sessions_httpSession9";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_HTTPSESSION11                         = "V2AddlEnvironmentTests_SPEC2_18_Sessions_httpSession11";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_GETCREATIONTIME                       = "V2AddlEnvironmentTests_SPEC2_18_Sessions_getCreationTime";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_GETID                                 = "V2AddlEnvironmentTests_SPEC2_18_Sessions_getId";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_GETLASTACCESSTIME                     = "V2AddlEnvironmentTests_SPEC2_18_Sessions_getLastAccessTime";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_GETMAXINCTIVEINTERVAL                 = "V2AddlEnvironmentTests_SPEC2_18_Sessions_getMaxInctiveInterval";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_INVALIDATE                            = "V2AddlEnvironmentTests_SPEC2_18_Sessions_invalidate";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_ISNEW                                 = "V2AddlEnvironmentTests_SPEC2_18_Sessions_isNew";
   public final static String               V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_SETMAXINACTIVEINTERVAL                = "V2AddlEnvironmentTests_SPEC2_18_Sessions_setMaxInactiveInterval";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_ACTION_PARAMETERS1                                 = "V2AddlRequestTests_SPEC2_11_Action_parameters1";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_ACTION_PARAMETERS2                                 = "V2AddlRequestTests_SPEC2_11_Action_parameters2";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_ACTION_PARAMETERS6                                 = "V2AddlRequestTests_SPEC2_11_Action_parameters6";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_ACTION_PARAMETERS8                                 = "V2AddlRequestTests_SPEC2_11_Action_parameters8";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_ACTION_PARAMETERS9                                 = "V2AddlRequestTests_SPEC2_11_Action_parameters9";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_ACTION_PUBLICRENDERPARAMETERS15                    = "V2AddlRequestTests_SPEC2_11_Action_publicRenderParameters15";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_ACTION_PUBLICRENDERPARAMETERS16                    = "V2AddlRequestTests_SPEC2_11_Action_publicRenderParameters16";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_ACTION_PUBLICRENDERPARAMETERS4                     = "V2AddlRequestTests_SPEC2_11_Action_publicRenderParameters4";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_ACTION_PUBLICRENDERPARAMETERS11                    = "V2AddlRequestTests_SPEC2_11_Action_publicRenderParameters11";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_EVENT_PARAMETERS1                                  = "V2AddlRequestTests_SPEC2_11_Event_parameters1";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_EVENT_PARAMETERS2                                  = "V2AddlRequestTests_SPEC2_11_Event_parameters2";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_EVENT_PARAMETERS6                                  = "V2AddlRequestTests_SPEC2_11_Event_parameters6";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_EVENT_PARAMETERS12                                 = "V2AddlRequestTests_SPEC2_11_Event_parameters12";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_EVENT_PUBLICRENDERPARAMETERS15                     = "V2AddlRequestTests_SPEC2_11_Event_publicRenderParameters15";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_EVENT_PUBLICRENDERPARAMETERS16                     = "V2AddlRequestTests_SPEC2_11_Event_publicRenderParameters16";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_EVENT_PUBLICRENDERPARAMETERS5                      = "V2AddlRequestTests_SPEC2_11_Event_publicRenderParameters5";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PARAMETERS10                                = "V2AddlRequestTests_SPEC2_11_Render_parameters10";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PARAMETERS11                                = "V2AddlRequestTests_SPEC2_11_Render_parameters11";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PARAMETERS13                                = "V2AddlRequestTests_SPEC2_11_Render_parameters13";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PARAMETERS15                                = "V2AddlRequestTests_SPEC2_11_Render_parameters15";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PARAMETERS1                                 = "V2AddlRequestTests_SPEC2_11_Render_parameters1";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PARAMETERS2                                 = "V2AddlRequestTests_SPEC2_11_Render_parameters2";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PARAMETERS6                                 = "V2AddlRequestTests_SPEC2_11_Render_parameters6";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PUBLICRENDERPARAMETERS15                    = "V2AddlRequestTests_SPEC2_11_Render_publicRenderParameters15";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PUBLICRENDERPARAMETERS16                    = "V2AddlRequestTests_SPEC2_11_Render_publicRenderParameters16";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PUBLICRENDERPARAMETERS1                     = "V2AddlRequestTests_SPEC2_11_Render_publicRenderParameters1";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PUBLICRENDERPARAMETERS2                     = "V2AddlRequestTests_SPEC2_11_Render_publicRenderParameters2";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PUBLICRENDERPARAMETERS6                     = "V2AddlRequestTests_SPEC2_11_Render_publicRenderParameters6";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PUBLICRENDERPARAMETERS13                    = "V2AddlRequestTests_SPEC2_11_Render_publicRenderParameters13";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PUBLICRENDERPARAMETERS13A                   = "V2AddlRequestTests_SPEC2_11_Render_publicRenderParameters13a";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_RESOURCE_PARAMETERS1                               = "V2AddlRequestTests_SPEC2_11_Resource_parameters1";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_RESOURCE_PARAMETERS2                               = "V2AddlRequestTests_SPEC2_11_Resource_parameters2";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_RESOURCE_PARAMETERS6                               = "V2AddlRequestTests_SPEC2_11_Resource_parameters6";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_RESOURCE_PARAMETERS17                              = "V2AddlRequestTests_SPEC2_11_Resource_parameters17";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_RESOURCE_PUBLICRENDERPARAMETERS15                  = "V2AddlRequestTests_SPEC2_11_Resource_publicRenderParameters15";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_RESOURCE_PUBLICRENDERPARAMETERS16                  = "V2AddlRequestTests_SPEC2_11_Resource_publicRenderParameters16";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_RESOURCE_PUBLICRENDERPARAMETERS7                   = "V2AddlRequestTests_SPEC2_11_Resource_publicRenderParameters7";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_RESOURCE_PUBLICRENDERPARAMETERS12                  = "V2AddlRequestTests_SPEC2_11_Resource_publicRenderParameters12";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_RENDERPRP_PUBLICRENDERPARAMETERS8                  = "V2AddlRequestTests_SPEC2_11_RenderPRP_publicRenderParameters8";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_RENDERPRP_PUBLICRENDERPARAMETERS9                  = "V2AddlRequestTests_SPEC2_11_RenderPRP_publicRenderParameters9";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_RENDERPRP_PUBLICRENDERPARAMETERS10                 = "V2AddlRequestTests_SPEC2_11_RenderPRP_publicRenderParameters10";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_RENDERATTR_ATTRIBUTES1                             = "V2AddlRequestTests_SPEC2_11_RenderAttr_attributes1";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_RENDERATTR_ATTRIBUTES2                             = "V2AddlRequestTests_SPEC2_11_RenderAttr_attributes2";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_RENDERATTR_ATTRIBUTES3                             = "V2AddlRequestTests_SPEC2_11_RenderAttr_attributes3";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_RENDERATTR_ATTRIBUTES4                             = "V2AddlRequestTests_SPEC2_11_RenderAttr_attributes4";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_RENDERATTR_ATTRIBUTES5                             = "V2AddlRequestTests_SPEC2_11_RenderAttr_attributes5";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_RENDERATTR_ATTRIBUTES8                             = "V2AddlRequestTests_SPEC2_11_RenderAttr_attributes8";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_ACTIONATTR_ATTRIBUTES1                             = "V2AddlRequestTests_SPEC2_11_ActionAttr_attributes1";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_ACTIONATTR_ATTRIBUTES2                             = "V2AddlRequestTests_SPEC2_11_ActionAttr_attributes2";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_ACTIONATTR_ATTRIBUTES6                             = "V2AddlRequestTests_SPEC2_11_ActionAttr_attributes6";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_EVENTATTR_ATTRIBUTES1                              = "V2AddlRequestTests_SPEC2_11_EventAttr_attributes1";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_EVENTATTR_ATTRIBUTES2                              = "V2AddlRequestTests_SPEC2_11_EventAttr_attributes2";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_EVENTATTR_ATTRIBUTES7                              = "V2AddlRequestTests_SPEC2_11_EventAttr_attributes7";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_RESOURCEATTR_ATTRIBUTES1                           = "V2AddlRequestTests_SPEC2_11_ResourceAttr_attributes1";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_RESOURCEATTR_ATTRIBUTES2                           = "V2AddlRequestTests_SPEC2_11_ResourceAttr_attributes2";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_RESOURCEATTR_ATTRIBUTES9                           = "V2AddlRequestTests_SPEC2_11_ResourceAttr_attributes9";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_ACTIONREQ_CONTENTTYPE1                             = "V2AddlRequestTests_SPEC2_11_ActionReq_contentType1";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_ACTIONREQ_CONTENTTYPE2                             = "V2AddlRequestTests_SPEC2_11_ActionReq_contentType2";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_ACTIONREQ_CONTENTTYPE3                             = "V2AddlRequestTests_SPEC2_11_ActionReq_contentType3";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_ACTIONREQ_WINDOWID4                                = "V2AddlRequestTests_SPEC2_11_ActionReq_windowId4";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_ACTIONREQ_CONTENTTYPE6                             = "V2AddlRequestTests_SPEC2_11_ActionReq_contentType6";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_EVENTREQ_CONTENTTYPE1                              = "V2AddlRequestTests_SPEC2_11_EventReq_contentType1";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_EVENTREQ_CONTENTTYPE2                              = "V2AddlRequestTests_SPEC2_11_EventReq_contentType2";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_EVENTREQ_CONTENTTYPE3                              = "V2AddlRequestTests_SPEC2_11_EventReq_contentType3";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_EVENTREQ_WINDOWID4                                 = "V2AddlRequestTests_SPEC2_11_EventReq_windowId4";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_EVENTREQ_CONTENTTYPE8                              = "V2AddlRequestTests_SPEC2_11_EventReq_contentType8";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_RENDERREQ_CONTENTTYPE1                             = "V2AddlRequestTests_SPEC2_11_RenderReq_contentType1";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_RENDERREQ_CONTENTTYPE2                             = "V2AddlRequestTests_SPEC2_11_RenderReq_contentType2";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_RENDERREQ_CONTENTTYPE3                             = "V2AddlRequestTests_SPEC2_11_RenderReq_contentType3";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_RENDERREQ_WINDOWID4                                = "V2AddlRequestTests_SPEC2_11_RenderReq_windowId4";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_RENDERREQ_CONTENTTYPE10                            = "V2AddlRequestTests_SPEC2_11_RenderReq_contentType10";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_RENDERREQ_CONTENTTYPE13                            = "V2AddlRequestTests_SPEC2_11_RenderReq_contentType13";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_RESOURCEREQ_CONTENTTYPE1                           = "V2AddlRequestTests_SPEC2_11_ResourceReq_contentType1";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_RESOURCEREQ_CONTENTTYPE2                           = "V2AddlRequestTests_SPEC2_11_ResourceReq_contentType2";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_RESOURCEREQ_CONTENTTYPE3                           = "V2AddlRequestTests_SPEC2_11_ResourceReq_contentType3";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_RESOURCEREQ_WINDOWID4                              = "V2AddlRequestTests_SPEC2_11_ResourceReq_windowId4";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_RESOURCEREQ_CONTENTTYPE12                          = "V2AddlRequestTests_SPEC2_11_ResourceReq_contentType12";
   public final static String               V2ADDLREQUESTTESTS_SPEC2_11_RESOURCEREQ_CONTENTTYPE13                          = "V2AddlRequestTests_SPEC2_11_ResourceReq_contentType13";
   public final static String               V2ADDLRESPONSETESTS_SPEC2_12_ACTION_COOKIE1                                    = "V2AddlResponseTests_SPEC2_12_Action_cookie1";
   public final static String               V2ADDLRESPONSETESTS_SPEC2_12_ACTION_COOKIE2                                    = "V2AddlResponseTests_SPEC2_12_Action_cookie2";
   public final static String               V2ADDLRESPONSETESTS_SPEC2_12_ACTION_COOKIE3                                    = "V2AddlResponseTests_SPEC2_12_Action_cookie3";
   public final static String               V2ADDLRESPONSETESTS_SPEC2_12_ACTION_COOKIE4                                    = "V2AddlResponseTests_SPEC2_12_Action_cookie4";
   public final static String               V2ADDLRESPONSETESTS_SPEC2_12_ACTION_REDIRECT1                                  = "V2AddlResponseTests_SPEC2_12_Action_redirect1";
   public final static String               V2ADDLRESPONSETESTS_SPEC2_12_ACTION_REDIRECT12                                 = "V2AddlResponseTests_SPEC2_12_Action_redirect12";
   public final static String               V2ADDLRESPONSETESTS_SPEC2_12_ACTION_REDIRECT14                                 = "V2AddlResponseTests_SPEC2_12_Action_redirect14";
   public final static String               V2ADDLRESPONSETESTS_SPEC2_12_EVENT_COOKIE5                                     = "V2AddlResponseTests_SPEC2_12_Event_cookie5";
   public final static String               V2ADDLRESPONSETESTS_SPEC2_12_EVENT_COOKIE6                                     = "V2AddlResponseTests_SPEC2_12_Event_cookie6";
   public final static String               V2ADDLRESPONSETESTS_SPEC2_12_EVENT_COOKIE7                                     = "V2AddlResponseTests_SPEC2_12_Event_cookie7";
   public final static String               V2ADDLRESPONSETESTS_SPEC2_12_RENDER_COOKIE8                                    = "V2AddlResponseTests_SPEC2_12_Render_cookie8";
   public final static String               V2ADDLRESPONSETESTS_SPEC2_12_RENDER_COOKIE9                                    = "V2AddlResponseTests_SPEC2_12_Render_cookie9";
   public final static String               V2ADDLRESPONSETESTS_SPEC2_12_RENDER_COOKIE10                                   = "V2AddlResponseTests_SPEC2_12_Render_cookie10";
   public final static String               V2ADDLRESPONSETESTS_SPEC2_12_RENDER_COOKIE11                                   = "V2AddlResponseTests_SPEC2_12_Render_cookie11";
   public final static String               V2ADDLRESPONSETESTS_SPEC2_12_RENDER_COOKIE12                                   = "V2AddlResponseTests_SPEC2_12_Render_cookie12";
   public final static String               V2ADDLRESPONSETESTS_SPEC2_12_RENDER_CONTENTTYPE5                               = "V2AddlResponseTests_SPEC2_12_Render_contentType5";
   public final static String               V2ADDLRESPONSETESTS_SPEC2_12_RENDER_CHARACTERENCODING4                         = "V2AddlResponseTests_SPEC2_12_Render_characterEncoding4";
   public final static String               V2ADDLRESPONSETESTS_SPEC2_12_RESOURCE_COOKIE13                                 = "V2AddlResponseTests_SPEC2_12_Resource_cookie13";
   public final static String               V2ADDLRESPONSETESTS_SPEC2_12_RESOURCE_COOKIE14                                 = "V2AddlResponseTests_SPEC2_12_Resource_cookie14";
   public final static String               V2ADDLRESPONSETESTS_SPEC2_12_RESOURCE_COOKIE15                                 = "V2AddlResponseTests_SPEC2_12_Resource_cookie15";
   public final static String               V2ADDLRESPONSETESTS_SPEC2_12_RESOURCE_COOKIE17                                 = "V2AddlResponseTests_SPEC2_12_Resource_cookie17";
   public final static String               V2ADDLRESPONSETESTS_SPEC2_12_RESOURCE_CONTENTTYPE5                             = "V2AddlResponseTests_SPEC2_12_Resource_contentType5";
   public final static String               V2ADDLRESPONSETESTS_SPEC2_12_RESOURCE_CHARACTERENCODING2                       = "V2AddlResponseTests_SPEC2_12_Resource_characterEncoding2";
   public final static String               V2ADDLRESPONSETESTS_SPEC2_12_RESOURCE_CHARACTERENCODING3                       = "V2AddlResponseTests_SPEC2_12_Resource_characterEncoding3";
   public final static String               V2ADDLRESPONSETESTS_SPEC2_12_RESOURCE_CHARACTERENCODING4                       = "V2AddlResponseTests_SPEC2_12_Resource_characterEncoding4";
   public final static String               V2ADDLFILTERTESTS_SPEC2_20_ACTION_FILTER1                                      = "V2AddlFilterTests_SPEC2_20_Action_filter1";
   public final static String               V2ADDLFILTERTESTS_SPEC2_20_ACTION_FILTER6                                      = "V2AddlFilterTests_SPEC2_20_Action_filter6";
   public final static String               V2ADDLFILTERTESTS_SPEC2_20_ACTION_FILTER7                                      = "V2AddlFilterTests_SPEC2_20_Action_filter7";
   public final static String               V2ADDLFILTERTESTS_SPEC2_20_ACTION_FILTER8                                      = "V2AddlFilterTests_SPEC2_20_Action_filter8";
   public final static String               V2ADDLFILTERTESTS_SPEC2_20_ACTION_FILTER9                                      = "V2AddlFilterTests_SPEC2_20_Action_filter9";
   public final static String               V2ADDLFILTERTESTS_SPEC2_20_ACTION_FILTER10                                     = "V2AddlFilterTests_SPEC2_20_Action_filter10";
   public final static String               V2ADDLFILTERTESTS_SPEC2_20_ACTION_FILTER11                                     = "V2AddlFilterTests_SPEC2_20_Action_filter11";
   public final static String               V2ADDLFILTERTESTS_SPEC2_20_ACTION_FILTER12                                     = "V2AddlFilterTests_SPEC2_20_Action_filter12";
   public final static String               V2ADDLFILTERTESTS_SPEC2_20_ACTION_FILTER13                                     = "V2AddlFilterTests_SPEC2_20_Action_filter13";
   public final static String               V2ADDLFILTERTESTS_SPEC2_20_ACTION_FILTER14                                     = "V2AddlFilterTests_SPEC2_20_Action_filter14";
   public final static String               V2ADDLFILTERTESTS_SPEC2_20_ACTION_FILTER15                                     = "V2AddlFilterTests_SPEC2_20_Action_filter15";
   public final static String               V2ADDLFILTERTESTS_SPEC2_20_ACTION_FILTERWRAPPER1                               = "V2AddlFilterTests_SPEC2_20_Action_filterWrapper1";
   public final static String               V2ADDLFILTERTESTS_SPEC2_20_ACTION_FILTERWRAPPER2                               = "V2AddlFilterTests_SPEC2_20_Action_filterWrapper2";
   public final static String               V2ADDLFILTERTESTS_SPEC2_20_ACTION_FILTER2                                      = "V2AddlFilterTests_SPEC2_20_Action_filter2";
   public final static String               V2ADDLFILTERTESTS_SPEC2_20_RENDER_FILTER1                                      = "V2AddlFilterTests_SPEC2_20_Render_filter1";
   public final static String               V2ADDLFILTERTESTS_SPEC2_20_RENDER_FILTER6                                      = "V2AddlFilterTests_SPEC2_20_Render_filter6";
   public final static String               V2ADDLFILTERTESTS_SPEC2_20_RENDER_FILTER7                                      = "V2AddlFilterTests_SPEC2_20_Render_filter7";
   public final static String               V2ADDLFILTERTESTS_SPEC2_20_RENDER_FILTER8                                      = "V2AddlFilterTests_SPEC2_20_Render_filter8";
   public final static String               V2ADDLFILTERTESTS_SPEC2_20_RENDER_FILTER9                                      = "V2AddlFilterTests_SPEC2_20_Render_filter9";
   public final static String               V2ADDLFILTERTESTS_SPEC2_20_RENDER_FILTER10                                     = "V2AddlFilterTests_SPEC2_20_Render_filter10";
   public final static String               V2ADDLFILTERTESTS_SPEC2_20_RENDER_FILTER11                                     = "V2AddlFilterTests_SPEC2_20_Render_filter11";
   public final static String               V2ADDLFILTERTESTS_SPEC2_20_RENDER_FILTER12                                     = "V2AddlFilterTests_SPEC2_20_Render_filter12";
   public final static String               V2ADDLFILTERTESTS_SPEC2_20_RENDER_FILTER13                                     = "V2AddlFilterTests_SPEC2_20_Render_filter13";
   public final static String               V2ADDLFILTERTESTS_SPEC2_20_RENDER_FILTER14                                     = "V2AddlFilterTests_SPEC2_20_Render_filter14";
   public final static String               V2ADDLFILTERTESTS_SPEC2_20_RENDER_FILTER15                                     = "V2AddlFilterTests_SPEC2_20_Render_filter15";
   public final static String               V2ADDLFILTERTESTS_SPEC2_20_RENDER_FILTERWRAPPER5                               = "V2AddlFilterTests_SPEC2_20_Render_filterWrapper5";
   public final static String               V2ADDLFILTERTESTS_SPEC2_20_RENDER_FILTERWRAPPER6                               = "V2AddlFilterTests_SPEC2_20_Render_filterWrapper6";
   public final static String               V2ADDLFILTERTESTS_SPEC2_20_RENDER_FILTER3                                      = "V2AddlFilterTests_SPEC2_20_Render_filter3";
   public final static String               V2ADDLFILTERTESTS_SPEC2_20_EVENT_FILTER1                                       = "V2AddlFilterTests_SPEC2_20_Event_filter1";
   public final static String               V2ADDLFILTERTESTS_SPEC2_20_EVENT_FILTER6                                       = "V2AddlFilterTests_SPEC2_20_Event_filter6";
   public final static String               V2ADDLFILTERTESTS_SPEC2_20_EVENT_FILTER7                                       = "V2AddlFilterTests_SPEC2_20_Event_filter7";
   public final static String               V2ADDLFILTERTESTS_SPEC2_20_EVENT_FILTER8                                       = "V2AddlFilterTests_SPEC2_20_Event_filter8";
   public final static String               V2ADDLFILTERTESTS_SPEC2_20_EVENT_FILTER9                                       = "V2AddlFilterTests_SPEC2_20_Event_filter9";
   public final static String               V2ADDLFILTERTESTS_SPEC2_20_EVENT_FILTER10                                      = "V2AddlFilterTests_SPEC2_20_Event_filter10";
   public final static String               V2ADDLFILTERTESTS_SPEC2_20_EVENT_FILTER11                                      = "V2AddlFilterTests_SPEC2_20_Event_filter11";
   public final static String               V2ADDLFILTERTESTS_SPEC2_20_EVENT_FILTER12                                      = "V2AddlFilterTests_SPEC2_20_Event_filter12";
   public final static String               V2ADDLFILTERTESTS_SPEC2_20_EVENT_FILTER13                                      = "V2AddlFilterTests_SPEC2_20_Event_filter13";
   public final static String               V2ADDLFILTERTESTS_SPEC2_20_EVENT_FILTER14                                      = "V2AddlFilterTests_SPEC2_20_Event_filter14";
   public final static String               V2ADDLFILTERTESTS_SPEC2_20_EVENT_FILTER15                                      = "V2AddlFilterTests_SPEC2_20_Event_filter15";
   public final static String               V2ADDLFILTERTESTS_SPEC2_20_EVENT_FILTERWRAPPER3                                = "V2AddlFilterTests_SPEC2_20_Event_filterWrapper3";
   public final static String               V2ADDLFILTERTESTS_SPEC2_20_EVENT_FILTERWRAPPER4                                = "V2AddlFilterTests_SPEC2_20_Event_filterWrapper4";
   public final static String               V2ADDLFILTERTESTS_SPEC2_20_EVENT_FILTER4                                       = "V2AddlFilterTests_SPEC2_20_Event_filter4";
   public final static String               V2ADDLFILTERTESTS_SPEC2_20_RESOURCE_FILTER1                                    = "V2AddlFilterTests_SPEC2_20_Resource_filter1";
   public final static String               V2ADDLFILTERTESTS_SPEC2_20_RESOURCE_FILTER6                                    = "V2AddlFilterTests_SPEC2_20_Resource_filter6";
   public final static String               V2ADDLFILTERTESTS_SPEC2_20_RESOURCE_FILTER7                                    = "V2AddlFilterTests_SPEC2_20_Resource_filter7";
   public final static String               V2ADDLFILTERTESTS_SPEC2_20_RESOURCE_FILTER8                                    = "V2AddlFilterTests_SPEC2_20_Resource_filter8";
   public final static String               V2ADDLFILTERTESTS_SPEC2_20_RESOURCE_FILTER9                                    = "V2AddlFilterTests_SPEC2_20_Resource_filter9";
   public final static String               V2ADDLFILTERTESTS_SPEC2_20_RESOURCE_FILTER10                                   = "V2AddlFilterTests_SPEC2_20_Resource_filter10";
   public final static String               V2ADDLFILTERTESTS_SPEC2_20_RESOURCE_FILTER11                                   = "V2AddlFilterTests_SPEC2_20_Resource_filter11";
   public final static String               V2ADDLFILTERTESTS_SPEC2_20_RESOURCE_FILTER12                                   = "V2AddlFilterTests_SPEC2_20_Resource_filter12";
   public final static String               V2ADDLFILTERTESTS_SPEC2_20_RESOURCE_FILTER13                                   = "V2AddlFilterTests_SPEC2_20_Resource_filter13";
   public final static String               V2ADDLFILTERTESTS_SPEC2_20_RESOURCE_FILTER14                                   = "V2AddlFilterTests_SPEC2_20_Resource_filter14";
   public final static String               V2ADDLFILTERTESTS_SPEC2_20_RESOURCE_FILTER15                                   = "V2AddlFilterTests_SPEC2_20_Resource_filter15";
   public final static String               V2ADDLFILTERTESTS_SPEC2_20_RESOURCE_FILTER5                                    = "V2AddlFilterTests_SPEC2_20_Resource_filter5";
   public final static String               V2ADDLFILTERTESTS_SPEC2_20_RESOURCE_FILTERWRAPPER7                             = "V2AddlFilterTests_SPEC2_20_Resource_filterWrapper7";
   public final static String               V2ADDLFILTERTESTS_SPEC2_20_RESOURCE_FILTERWRAPPER8                             = "V2AddlFilterTests_SPEC2_20_Resource_filterWrapper8";
   public final static String               V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPGENERAL_DEFINEOBJECTS3             = "V2PortletTagLibraryTests_SPEC2_26_IncludeJSPGeneral_defineObjects3";
   public final static String               V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPGENERAL_DEFINEOBJECTS1             = "V2PortletTagLibraryTests_SPEC2_26_IncludeJSPGeneral_defineObjects1";
   public final static String               V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPGENERAL_DEFINEOBJECTS2             = "V2PortletTagLibraryTests_SPEC2_26_IncludeJSPGeneral_defineObjects2";
   public final static String               V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPGENERAL_DEFINEOBJECTS4             = "V2PortletTagLibraryTests_SPEC2_26_IncludeJSPGeneral_defineObjects4";
   public final static String               V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPGENERAL_NAMESPACE                  = "V2PortletTagLibraryTests_SPEC2_26_IncludeJSPGeneral_namespace";
   public final static String               V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPGENERAL_ESCAPEXML1                 = "V2PortletTagLibraryTests_SPEC2_26_IncludeJSPGeneral_escapeXML1";
   public final static String               V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPGENERAL_ESCAPEXML2                 = "V2PortletTagLibraryTests_SPEC2_26_IncludeJSPGeneral_escapeXML2";
   public final static String               V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPACTION_DEFINEOBJECTS1              = "V2PortletTagLibraryTests_SPEC2_26_IncludeJSPAction_defineObjects1";
   public final static String               V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPACTION_DEFINEOBJECTS2              = "V2PortletTagLibraryTests_SPEC2_26_IncludeJSPAction_defineObjects2";
   public final static String               V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPACTION_DEFINEOBJECTS3              = "V2PortletTagLibraryTests_SPEC2_26_IncludeJSPAction_defineObjects3";
   public final static String               V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPACTION_DEFINEOBJECTS4              = "V2PortletTagLibraryTests_SPEC2_26_IncludeJSPAction_defineObjects4";
   public final static String               V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPACTION_DEFINEOBJECTS5              = "V2PortletTagLibraryTests_SPEC2_26_IncludeJSPAction_defineObjects5";
   public final static String               V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPACTION_DEFINEOBJECTS6              = "V2PortletTagLibraryTests_SPEC2_26_IncludeJSPAction_defineObjects6";
   public final static String               V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPACTION_DEFINEOBJECTS7              = "V2PortletTagLibraryTests_SPEC2_26_IncludeJSPAction_defineObjects7";
   public final static String               V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPACTION_DEFINEOBJECTS8              = "V2PortletTagLibraryTests_SPEC2_26_IncludeJSPAction_defineObjects8";
   public final static String               V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPACTION_DEFINEOBJECTS9              = "V2PortletTagLibraryTests_SPEC2_26_IncludeJSPAction_defineObjects9";
   public final static String               V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPACTION_DEFINEOBJECTS10             = "V2PortletTagLibraryTests_SPEC2_26_IncludeJSPAction_defineObjects10";
   public final static String               V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPACTION_DEFINEOBJECTS11             = "V2PortletTagLibraryTests_SPEC2_26_IncludeJSPAction_defineObjects11";
   public final static String               V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPACTION_DEFINEOBJECTS12             = "V2PortletTagLibraryTests_SPEC2_26_IncludeJSPAction_defineObjects12";
   public final static String               V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPACTION_DEFINEOBJECTS13             = "V2PortletTagLibraryTests_SPEC2_26_IncludeJSPAction_defineObjects13";
   public final static String               V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS1               = "V2PortletTagLibraryTests_SPEC2_26_IncludeJSPEvent_defineObjects1";
   public final static String               V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS2               = "V2PortletTagLibraryTests_SPEC2_26_IncludeJSPEvent_defineObjects2";
   public final static String               V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS3               = "V2PortletTagLibraryTests_SPEC2_26_IncludeJSPEvent_defineObjects3";
   public final static String               V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS4               = "V2PortletTagLibraryTests_SPEC2_26_IncludeJSPEvent_defineObjects4";
   public final static String               V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS5               = "V2PortletTagLibraryTests_SPEC2_26_IncludeJSPEvent_defineObjects5";
   public final static String               V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS6               = "V2PortletTagLibraryTests_SPEC2_26_IncludeJSPEvent_defineObjects6";
   public final static String               V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS7               = "V2PortletTagLibraryTests_SPEC2_26_IncludeJSPEvent_defineObjects7";
   public final static String               V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS8               = "V2PortletTagLibraryTests_SPEC2_26_IncludeJSPEvent_defineObjects8";
   public final static String               V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS9               = "V2PortletTagLibraryTests_SPEC2_26_IncludeJSPEvent_defineObjects9";
   public final static String               V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS10              = "V2PortletTagLibraryTests_SPEC2_26_IncludeJSPEvent_defineObjects10";
   public final static String               V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS11              = "V2PortletTagLibraryTests_SPEC2_26_IncludeJSPEvent_defineObjects11";
   public final static String               V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS12              = "V2PortletTagLibraryTests_SPEC2_26_IncludeJSPEvent_defineObjects12";
   public final static String               V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS13              = "V2PortletTagLibraryTests_SPEC2_26_IncludeJSPEvent_defineObjects13";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_DEFINEOBJECTSRENDER1       = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_defineObjectsRender1";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_DEFINEOBJECTSRENDER2       = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_defineObjectsRender2";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_DEFINEOBJECTSRENDER3       = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_defineObjectsRender3";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_DEFINEOBJECTSRENDER4       = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_defineObjectsRender4";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_DEFINEOBJECTSRENDER5       = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_defineObjectsRender5";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_DEFINEOBJECTSRENDER6       = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_defineObjectsRender6";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_DEFINEOBJECTSRENDER7       = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_defineObjectsRender7";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_DEFINEOBJECTSRENDER8       = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_defineObjectsRender8";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_DEFINEOBJECTSRENDER9       = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_defineObjectsRender9";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_DEFINEOBJECTSRENDER10      = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_defineObjectsRender10";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_DEFINEOBJECTSRENDER11      = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_defineObjectsRender11";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_DEFINEOBJECTSRENDER12      = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_defineObjectsRender12";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_DEFINEOBJECTSRENDER13      = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_defineObjectsRender13";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL1                 = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_actionURL1";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL2                 = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_actionURL2";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL3                 = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_actionURL3";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL4                 = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_actionURL4";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL5                 = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_actionURL5";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL6                 = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_actionURL6";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL7                 = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_actionURL7";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL8                 = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_actionURL8";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL9                 = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_actionURL9";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL10                = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_actionURL10";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL11                = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_actionURL11";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL12                = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_actionURL12";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL13                = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_actionURL13";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL14                = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_actionURL14";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL15                = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_actionURL15";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL17                = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_actionURL17";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL18                = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_actionURL18";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL19                = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_actionURL19";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL20                = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_actionURL20";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL21                = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_actionURL21";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL22                = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_actionURL22";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL23                = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_actionURL23";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL25                = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_actionURL25";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL26                = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_actionURL26";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL27                = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_actionURL27";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL28                = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_actionURL28";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL29                = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_actionURL29";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL30                = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_actionURL30";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL1                 = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_renderURL1";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL2                 = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_renderURL2";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL3                 = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_renderURL3";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL4                 = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_renderURL4";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL5                 = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_renderURL5";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL6                 = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_renderURL6";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL7                 = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_renderURL7";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL8                 = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_renderURL8";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL9                 = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_renderURL9";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL10                = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_renderURL10";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL11                = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_renderURL11";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL12                = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_renderURL12";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL13                = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_renderURL13";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL14                = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_renderURL14";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL15                = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_renderURL15";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL17                = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_renderURL17";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL18                = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_renderURL18";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL19                = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_renderURL19";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL20                = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_renderURL20";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL21                = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_renderURL21";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL22                = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_renderURL22";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL23                = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_renderURL23";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL25                = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_renderURL25";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL26                = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_renderURL26";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL1               = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_resourceURL1";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL2               = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_resourceURL2";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL3               = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_resourceURL3";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL4               = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_resourceURL4";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL5               = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_resourceURL5";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL6               = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_resourceURL6";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL7               = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_resourceURL7";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL8               = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_resourceURL8";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL9               = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_resourceURL9";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL11              = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_resourceURL11";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL12              = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_resourceURL12";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL13              = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_resourceURL13";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL14              = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_resourceURL14";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL15              = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_resourceURL15";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL16              = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_resourceURL16";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL17              = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_resourceURL17";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL19              = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_resourceURL19";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL20              = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_resourceURL20";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL21              = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_resourceURL21";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL22              = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_resourceURL22";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL23              = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_resourceURL23";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL24              = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_resourceURL24";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL25              = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_resourceURL25";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL26              = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_resourceURL26";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL27              = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_resourceURL27";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PARAMACTION1               = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_paramAction1";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PARAMACTION2               = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_paramAction2";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PARAMACTION3               = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_paramAction3";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PARAMACTION4               = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_paramAction4";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PARAMACTION5               = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_paramAction5";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PARAMACTION6               = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_paramAction6";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PARAMRENDER1               = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_paramRender1";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PARAMRENDER2               = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_paramRender2";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PARAMRENDER3               = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_paramRender3";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PARAMRENDER4               = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_paramRender4";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PARAMRENDER5               = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_paramRender5";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PARAMRENDER6               = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_paramRender6";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PARAMRESOURCE1             = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_paramResource1";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PARAMRESOURCE2             = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_paramResource2";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PARAMRESOURCE3             = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_paramResource3";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PARAMRESOURCE4             = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_paramResource4";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PARAMRESOURCE5             = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_paramResource5";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PARAMRESOURCE6             = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_paramResource6";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PROPERTYACTION1            = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_propertyAction1";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PROPERTYACTION2            = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_propertyAction2";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PROPERTYACTION3            = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_propertyAction3";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PROPERTYACTION4            = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_propertyAction4";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PROPERTYACTION5            = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_propertyAction5";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PROPERTYACTION6            = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_propertyAction6";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PROPERTYRENDER1            = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_propertyRender1";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PROPERTYRENDER2            = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_propertyRender2";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PROPERTYRENDER3            = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_propertyRender3";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PROPERTYRENDER4            = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_propertyRender4";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PROPERTYRENDER5            = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_propertyRender5";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PROPERTYRENDER6            = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_propertyRender6";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PROPERTYRESOURCE1          = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_propertyResource1";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PROPERTYRESOURCE2          = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_propertyResource2";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PROPERTYRESOURCE3          = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_propertyResource3";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PROPERTYRESOURCE4          = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_propertyResource4";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PROPERTYRESOURCE5          = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_propertyResource5";
   public final static String               V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PROPERTYRESOURCE6          = "V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_propertyResource6";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_DEFINEOBJECTSRESOURCE1   = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_defineObjectsResource1";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_DEFINEOBJECTSRESOURCE2   = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_defineObjectsResource2";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_DEFINEOBJECTSRESOURCE3   = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_defineObjectsResource3";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_DEFINEOBJECTSRESOURCE4   = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_defineObjectsResource4";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_DEFINEOBJECTSRESOURCE5   = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_defineObjectsResource5";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_DEFINEOBJECTSRESOURCE6   = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_defineObjectsResource6";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_DEFINEOBJECTSRESOURCE7   = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_defineObjectsResource7";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_DEFINEOBJECTSRESOURCE8   = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_defineObjectsResource8";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_DEFINEOBJECTSRESOURCE9   = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_defineObjectsResource9";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_DEFINEOBJECTSRESOURCE10  = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_defineObjectsResource10";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_DEFINEOBJECTSRESOURCE11  = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_defineObjectsResource11";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_DEFINEOBJECTSRESOURCE12  = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_defineObjectsResource12";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_DEFINEOBJECTSRESOURCE13  = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_defineObjectsResource13";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL1               = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL1";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL2               = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL2";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL3               = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL3";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL4               = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL4";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL5               = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL5";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL6               = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL6";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL7               = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL7";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL8               = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL8";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL9               = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL9";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL10              = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL10";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL11              = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL11";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL12              = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL12";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL13              = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL13";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL14              = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL14";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL15              = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL15";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL17              = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL17";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL18              = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL18";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL19              = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL19";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL20              = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL20";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL21              = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL21";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL22              = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL22";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL23              = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL23";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL25              = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL25";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL26              = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL26";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL27              = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL27";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL28              = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL28";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL29              = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL29";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL30              = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_actionURL30";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL1               = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL1";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL2               = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL2";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL3               = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL3";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL4               = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL4";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL5               = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL5";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL6               = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL6";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL7               = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL7";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL8               = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL8";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL9               = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL9";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL10              = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL10";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL11              = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL11";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL12              = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL12";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL13              = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL13";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL14              = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL14";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL15              = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL15";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL17              = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL17";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL18              = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL18";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL19              = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL19";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL20              = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL20";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL21              = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL21";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL22              = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL22";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL23              = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL23";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL25              = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL25";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL26              = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_renderURL26";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL1             = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL1";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL2             = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL2";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL3             = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL3";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL4             = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL4";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL5             = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL5";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL6             = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL6";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL7             = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL7";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL8             = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL8";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL9             = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL9";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL11            = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL11";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL12            = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL12";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL13            = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL13";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL14            = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL14";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL15            = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL15";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL16            = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL16";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL17            = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL17";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL19            = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL19";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL20            = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL20";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL21            = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL21";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL22            = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL22";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL23            = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL23";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL24            = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL24";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL25            = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL25";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL26            = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL26";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL27            = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_resourceURL27";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMACTION1             = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramAction1";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMACTION2             = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramAction2";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMACTION3             = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramAction3";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMACTION4             = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramAction4";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMACTION5             = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramAction5";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMACTION6             = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramAction6";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMRENDER1             = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramRender1";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMRENDER2             = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramRender2";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMRENDER3             = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramRender3";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMRENDER4             = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramRender4";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMRENDER5             = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramRender5";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMRENDER6             = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramRender6";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMRESOURCE1           = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramResource1";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMRESOURCE2           = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramResource2";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMRESOURCE3           = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramResource3";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMRESOURCE4           = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramResource4";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMRESOURCE5           = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramResource5";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMRESOURCE6           = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_paramResource6";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYACTION1          = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_propertyAction1";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYACTION2          = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_propertyAction2";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYACTION3          = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_propertyAction3";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYACTION4          = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_propertyAction4";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYACTION5          = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_propertyAction5";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYACTION6          = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_propertyAction6";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYRENDER1          = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_propertyRender1";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYRENDER2          = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_propertyRender2";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYRENDER3          = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_propertyRender3";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYRENDER4          = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_propertyRender4";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYRENDER5          = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_propertyRender5";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYRENDER6          = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_propertyRender6";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYRESOURCE1        = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_propertyResource1";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYRESOURCE2        = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_propertyResource2";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYRESOURCE3        = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_propertyResource3";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYRESOURCE4        = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_propertyResource4";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYRESOURCE5        = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_propertyResource5";
   public final static String               V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYRESOURCE6        = "V2PortletTagLibraryTests3_SPEC2_26_IncludeJSPResource_propertyResource6";

   private final static Map<String, String> tcd                                                                            = new HashMap<String, String>();
   static {

      tcd.put(V2ADDLPORTLETTESTS_SPEC2_2_COMPATIBILITY_DEPLOYJSR168_1,
            "A portlet with the JSR 168 deployment descriptor can be deployed");
      tcd.put(V2ADDLPORTLETTESTS_SPEC2_2_COMPATIBILITY_DEPLOYJSR168_2,
            "A portlet implementing only the JSR 168 API can be deployed");
      tcd.put(V2ADDLPORTLETTESTS_SPEC2_5_INITIALIZATION_INITIALIZATION6,
            "A RuntimeException thrown during initialization must be handled as a PortletException");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_5_ACTIONHANDLING_ACTION5,
            "If the portlet issues a redirect during action processing, the portlet container allows the processAction method to complete");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_5_ACTIONHANDLING_ACTION6,
            "If the portlet issues a redirect during action processing, the portlet container must send the redirect back to the user agent and finalize the request processing.");
      tcd.put(V2ADDLPORTLETTESTS_SPEC2_5_ACTIONHANDLING_ACTION7,
            "If the portlet issues a redirect during action processing, events that were set are not processed");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_5_ACTIONHANDLING_EXCEPTION1,
            "If the portlet throws an PortletException in processAction, all operations on the ActionResponse, including set events, must be ignored");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_5_ACTIONHANDLING_EXCEPTION2,
            "If the portlet throws a RuntimeException in processAction, all operations on the ActionResponse, including set events, must be ignored");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_5_RENDERHANDLING_RENDER1,
            "If the client request is triggered by a render URL, the portlet container must invoke the render method for all portlets on the page that do not have valid cache entries");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_5_RESOURCEHANDLING_RESOURCE1,
            "If the client request is triggered by a resource URL, the portlet container must invoke the serveResource method for the target portlet if its content does not have a valid cache entry");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_5_EVENTHANDLING_EXCEPTION4,
            "If the portlet throws an PortletException in processEvent, all operations on the EventResponse, including set events, must be ignored");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_5_EVENTHANDLING_EXCEPTION5,
            "If the portlet throws a RuntimeException in processEvent, all operations on the EventResponse, including set events, must be ignored");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_5_RENDERGENERICPORTLET_ACTIONDISPATCHING2,
            "If the ActionRequest.ACTION_NAME parameter is not set on the action URL, the GenericPortlet processAction method will throw a PortletException");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_5_RENDERGENERICPORTLET_EVENTDISPATCHING1,
            "The GenericPortlet processEvent method will dispatch the request to a subclass method annotated with the tag @ProcessEvent(qname=&lt;eventname&gt;), where &lt;eventname&gt; must be in the format provided by Qname.toString()");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_5_RENDERGENERICPORTLET_EVENTDISPATCHING2,
            "The GenericPortlet processEvent method will dispatch the request to a subclass method annotated with the tag @ProcessEvent(name=&lt;event_name_local_part&gt;)");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_5_RENDERGENERICPORTLET_RENDERDISPATCHING8,
            "getTitle - If a ResourceBundle containing the title string is defined in the deployment descriptor, that title string will be used");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_5_RENDERGENERICPORTLET_RENDERDISPATCHING9,
            "getTitle - If a ResourceBundle containing the title string is not defined in the deployment descriptor, the title defined in the portlet descriptor &lt;title&gt; element is used");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG_GETRESOURCEBUNDLE1,
            "The resource bundle defined in the deployment descriptor &lt;resource-bundle&gt; element can be obtained through the PortletConfig object");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG_GETRESOURCEBUNDLE2,
            "If the resource bundle contains a \"javax.portlet.title\" property, the value defined in the bundle is returned by the corresponding getString method call");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG_GETRESOURCEBUNDLE3,
            "If the resource bundle contains a \"javax.portlet.short-title\" property, the value defined in the bundle is returned by the corresponding getString method call");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG_GETRESOURCEBUNDLE4,
            "If the resource bundle contains a \"javax.portlet.keywords\" property, the value defined in the bundle is returned by the corresponding getString method call");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG_GETPUBLISHINGEVENTQNAMES3,
            "getPublishingEventQnames - If the event was defined using the &lt;name&gt; element rather than the &lt;qname&gt; element, default namespace defined with the &lt;default-namespace&gt; element must be added as the event namespace");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG_GETPUBLISHINGEVENTQNAMES4,
            "getPublishingEventQnames - If the event was defined using the &lt;name&gt; element rather than the &lt;qname&gt; element and there is no default namespace defined, the value XMLConstants.NULL_NS_URI must be added as the event namespace");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG_GETPROCESSINGEVENTQNAMES3,
            "getProcessingEventQnames - If the event was defined using the &lt;name&gt; element rather than the &lt;qname&gt; element, default namespace defined with the &lt;default-namespace&gt; element must be added as the event namespace");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG_GETPROCESSINGEVENTQNAMES4,
            "getProcessingEventQnames - If the event was defined using the &lt;name&gt; element rather than the &lt;qname&gt; element and there is no default namespace defined, the value XMLConstants.NULL_NS_URI must be added as the event namespace");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG_GETCONTAINERRUNTIMEOPTIONS6,
            "The returned Map contains values defined in the deployment descriptor &lt;container-runtime-option&gt; elements at the portlet application level");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG_GETCONTAINERRUNTIMEOPTIONS7,
            "The returned Map contains values defined in the deployment descriptor &lt;container-runtime-option&gt; elements at the portlet level");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG_GETCONTAINERRUNTIMEOPTIONS8,
            "If the deployment descriptor contains &lt;container-runtime-option&gt; elements defined at both the portlet and the portlet application levels, the returned Map contains a merger of all values");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG_GETCONTAINERRUNTIMEOPTIONS9,
            "If the deployment descriptor contains &lt;container-runtime-option&gt; elements of the same name defined at both the portlet and the portlet application levels, the returned Map contains a the value defined at the portlet level");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG_GETDEFAULTNAMESPACE2,
            "Method getDefaultNamespace(): Returns XMLConstants.NULL_NS_URI if no default namespace is defined in the deployment descriptor");
      tcd.put(V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG_GETCONTAINERRUNTIMEOPTIONS4,
            "Method getContainerRuntimeOptions(): Returns an empty map if no container runtime options have been defined");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG2_GETRESOURCEBUNDLE8,
            "If no resource bundle is defined, the value defined in the deployment descriptor &lt;title&gt; element is returned by the corresponding getString method call");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG2_GETRESOURCEBUNDLE9,
            "If no resource bundle is defined, the value defined in the deployment descriptor &lt;short-title&gt; element is returned by the corresponding getString method call");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG2_GETRESOURCEBUNDLE10,
            "If no resource bundle is defined, the value defined in the deployment descriptor &lt;keywords&gt; element is returned by the corresponding getString method call");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG3_GETRESOURCEBUNDLE5,
            "If the resource bundle does not contain a \"javax.portlet.title\" property, the value defined in the deployment descriptor &lt;title&gt; element is returned by the corresponding getString method call");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG3_GETRESOURCEBUNDLE6,
            "If the resource bundle does not contain a \"javax.portlet.short-title\" property, the value defined in the deployment descriptor &lt;short-title&gt; element is returned by the corresponding getString method call");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG3_GETRESOURCEBUNDLE7,
            "If the resource bundle does not contain a \"javax.portlet.keywords\" property, the value defined in the deployment descriptor &lt;keywords&gt; element is returned by the corresponding getString method call");
      tcd.put(V2ADDLPORTLETTESTS_SPEC2_8_PORTLETMODES_DECLARINGPORTLETMODES1,
            "Support for the VIEW mode does not need to be declared in the deployment descriptor");
      tcd.put(V2ADDLPORTLETTESTS_SPEC2_8_PORTLETMODES_DECLARINGPORTLETMODES2,
            "Support for the HELP mode must be declared in the deployment descriptor");
      tcd.put(V2ADDLPORTLETTESTS_SPEC2_8_PORTLETMODES_DECLARINGPORTLETMODES3,
            "A custom portlet mode may be declared in the deployment descriptor");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_8_PORTLETMODES_DECLARINGPORTLETMODES4,
            "A custom portlet mode with &lt;portal-managed&gt;false&lt;/portal-managed&gt; may be declared in the deployment descriptor");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_8_PORTLETMODES_DECLARINGPORTLETMODES5,
            "The PortletRequest.isPortletModeAllowed method must return FALSE for a custom portlet mode with &lt;portal-managed&gt;true&lt;/portal-managed&gt; that is not supported by the portlet container");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_8_PORTLETMODES_DECLARINGPORTLETMODES6,
            "The portlet container must ignore all custom portlet modes in the deployment descriptor with &lt;portal-managed&gt;true&lt;/portal-managed&gt; that is not supported by the portlet container");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_8_PORTLETMODES_DECLARINGPORTLETMODES7,
            "A custom portlet mode with &lt;portal-managed&gt;false&lt;/portal-managed&gt; corresponds to the VIEW mode from the portal point of view");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_8_PORTLETMODES_DECLARINGPORTLETMODES8,
            "A custom portlet mode can have a localized decoration name in the resource bundle with the name of javax.portlet.app.custom-portlet-mode.&lt;name&gt;.decoration-name");
      tcd.put(V2ADDLPORTLETTESTS_SPEC2_8_PORTLETMODES_DECLARINGPORTLETMODES9,
            "The portlet must not be invoked in a mode that has not been declared to be supported for a given markup type");
      tcd.put(V2ADDLPORTLETTESTS_SPEC2_9_WINDOWSTATES_DECLARINGWINDOWSTATES1,
            "Support for the NORMAL window state does not need to be declared in the deployment descriptor");
      tcd.put(V2ADDLPORTLETTESTS_SPEC2_9_WINDOWSTATES_DECLARINGWINDOWSTATES2,
            "Support for the MINIMIZED window state does not need to be declared in the deployment descriptor");
      tcd.put(V2ADDLPORTLETTESTS_SPEC2_9_WINDOWSTATES_DECLARINGWINDOWSTATES3,
            "Support for the MAXIMIZED window state does not need to be declared in the deployment descriptor");
      tcd.put(V2ADDLPORTLETTESTS_SPEC2_9_WINDOWSTATES_DECLARINGWINDOWSTATES4,
            "A custom window state may be declared in the deployment descriptor");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_9_WINDOWSTATES_DECLARINGWINDOWSTATES5,
            "The PortletRequest.isWindowStateAllowed method must return FALSE for a custom window state that is not supported by the portlet container");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_9_WINDOWSTATES_DECLARINGWINDOWSTATES6,
            "The portlet container must ignore all custom window states in the deployment descriptor that are not supported by the portal");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_9_WINDOWSTATES_DECLARINGWINDOWSTATES7,
            "The portlet must not be invoked in a window state other than NORMAL, MINIMIZED, or MAXIMIZED that has not been declared to be supported for a given markup type");
      tcd.put(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVING_RESOURCEURLS2,
            "When a resource URL is invoked, the portlet container must not call the processAction method");
      tcd.put(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVING_RESOURCEURLS4,
            "After a resource URL has been created, the portlet mode set on the resource URL cannot be changed");
      tcd.put(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVING_RESOURCEURLS5,
            "After a resource URL has been created, the window state set on the resource URL cannot be changed");
      tcd.put(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVING_RESOURCEURLS6,
            "After a resource URL has been created, the render parameters set on the resource URL cannot be changed");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVING_RESOURCEURLS7,
            "After a resource URL has been created, a parameter set on the resource URL is a resource parameter, not a render parameter");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVING_RESOURCEURLS8,
            "After a resource URL has been created, a parameter set on the URL with the same name as an exsisting render parameter results in a multivalued parameter containing both the resource pramaeter values and the render parameter values");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVING_RESOURCEURLS9,
            "In the resulting multivalued parameter after a resource parameter is added with the same name as a render parameter, the the render parameter values must be the last entries in the parameter value array");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHING1,
            "If portlet URLs are included in the markup, portals / portlet containers must create correct portlet URLs for all text-based markup types.");
      tcd.put(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHING2,
            "The portlet can use the setCacheability method to set the cache level for the ResourceURL");
      tcd.put(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHING3,
            "If the cache level is not set, a generated resource URL has the cacheability of the request in which it was created");
      tcd.put(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGFULL1,
            "If the cache level is set to FULL, the resource URL does not contain the current render parameters");
      tcd.put(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGFULL2,
            "If the cache level is set to FULL, the resource URL does not contain the current portlet mode");
      tcd.put(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGFULL3,
            "If the cache level is set to FULL, the resource URL does not contain the current window state");
      tcd.put(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGFULL4,
            "If the cache level is set to FULL, the resource URL does not contain the current page state");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGFULL5,
            "In a resource request resulting from triggering a resource URL with cacheability set to FULL, a resource URL with cacheability set to FULL may be generated");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGFULL6,
            "In a resource request resulting from triggering a resource URL with cacheability set to FULL, setting cacheability on a resource URL to PORTLET results in an an IllegalStateException");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGFULL7,
            "In a resource request resulting from triggering a resource URL with cacheability set to FULL, setting cacheability on a resource URL to PAGE results in an an IllegalStateException");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGFULL8,
            "In a resource request resulting from triggering a resource URL with cacheability set to FULL, an attempt to create a render URL results in an an IllegalStateException");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGFULL9,
            "In a resource request resulting from triggering a resource URL with cacheability set to FULL, an attempt to create an action URL results in an an IllegalStateException");
      tcd.put(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPORTLET1,
            "If the cache level is set to PORTLET, the resource URL contains the current render parameters");
      tcd.put(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPORTLET2,
            "If the cache level is set to PORTLET, the resource URL contains the current portlet mode");
      tcd.put(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPORTLET3,
            "If the cache level is set to PORTLET, the resource URL contains the current window state");
      tcd.put(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPORTLET4,
            "If the cache level is set to PORTLET, the resource URL does not contain the current page state");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPORTLET5,
            "In a resource request resulting from triggering a resource URL with cacheability set to PORTLET, a resource URL with cacheability set to FULL may be generated");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPORTLET6,
            "In a resource request resulting from triggering a resource URL with cacheability set to PORTLET, a resource URL with cacheability set to PORTLET may be generated");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPORTLET7,
            "In a resource request resulting from triggering a resource URL with cacheability set to PORTLET, setting cacheability on a resource URL to PAGE results in an an IllegalStateException");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPORTLET8,
            "In a resource request resulting from triggering a resource URL with cacheability set to PORTLET, an attempt to create a render URL results in an an IllegalStateException");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPORTLET9,
            "In a resource request resulting from triggering a resource URL with cacheability set to PORTLET, an attempt to create an action URL results in an an IllegalStateException");
      tcd.put(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPAGE1,
            "If the cache level is set to PAGE, the resource URL contains the current render parameters");
      tcd.put(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPAGE2,
            "If the cache level is set to PAGE, the resource URL contains the current PAGE mode");
      tcd.put(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPAGE3,
            "If the cache level is set to PAGE, the resource URL contains the current window state");
      tcd.put(V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPAGE4,
            "If the cache level is set to PAGE, the resource URL contains the current page state");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPAGE5,
            "In a resource request resulting from triggering a resource URL with cacheability set to PAGE, a resource URL with cacheability set to FULL may be generated");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPAGE6,
            "In a resource request resulting from triggering a resource URL with cacheability set to PAGE, a resource URL with cacheability set to PORTLET may be generated");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPAGE7,
            "In a resource request resulting from triggering a resource URL with cacheability set to PAGE, a resource URL with cacheability set to PAGE may be generated");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPAGE8,
            "In a resource request resulting from triggering a resource URL with cacheability set to PAGE, a render URL may be generated");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_13_RESOURCESERVINGCACHE_CACHINGPAGE9,
            "In a resource request resulting from triggering a resource URL with cacheability set to PAGE, an action URL may be generated");
      tcd.put(V2ADDLPORTLETTESTS_SPEC2_15_EVENT_EVENT1, "Event names are defined in the deployment descriptor");
      tcd.put(V2ADDLPORTLETTESTS_SPEC2_15_RENDEREVENTHANDLING_EVENT2,
            "Event value types are defined in the deployment descriptor");
      tcd.put(V2ADDLPORTLETTESTS_SPEC2_15_RENDEREVENTHANDLING_EVENT3,
            "The supported publishing events for the portlet are defined in the deployment descriptor");
      tcd.put(V2ADDLPORTLETTESTS_SPEC2_15_RENDEREVENTHANDLING_EVENT4,
            "The supported processing events for the portlet are defined in the deployment descriptor");
      tcd.put(V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENT5,
            "The portlet can use the EventRequest.getEvent method to obtain an Event object encapsulating the event name and value");
      tcd.put(V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENT6,
            "The Event object must always have the name field set");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENT7,
            "If the Event object has a value set when the event is published, the value must be based on the value defined in the deployment descriptor");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENT8,
            "If the Event object has a value set when the event is published, the value must be available from the Event object in the processEvent method");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENT9,
            "If the Event object does not have a value set when the event is published, the Event object available in the processEvent method must not have a value");
      tcd.put(V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENT10,
            "The Event Qname object representing the name can be retrieved through the Event getQname method");
      tcd.put(V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENT11,
            "The local part of the Event Qname object representing the name can be retrieved through the Event getName method");
      tcd.put(V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENT15,
            "If a portlet throws an exception in the processEvent method, all operations on the EventResponse must be ignored");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENT16,
            "If a portlet throws a permanent UnavailableException during event processing, the portlet container must remove the portlet from service immediately, call the portlet's destroy method, and release the portlet object");
      tcd.put(V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENTPROCESSEVENT1,
            "The portlet can publish an event via the setEvent method in the processEvent method");
      tcd.put(V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENTPROCESSEVENT2,
            "The portlet can publish an event with its full Qname via the setEvent method in the processAction method");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENTPROCESSEVENT3,
            "The portlet can publish an event with only the local part of the Qname via the setEvent method in the processAction method");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENTPROCESSEVENT4,
            "If an event is published with only the local part of the Qname, the namespace must be the default namespace defined in the deployment descriptor");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENTPROCESSEVENT5,
            "If an event is published with only the local part of the Qname and no default namespace is defined in the deployment descriptor, the value javax.xml.XMLConstants.NULL_NS_URI must be used as the Qname namespace");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENTPROCESSEVENT6,
            "If an object is serializeable and has a valid JAXB binding or is a Java primitive type, it can be used as an event value");
      tcd.put(V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENTPROCESSEVENT7,
            "If a value is not serializeable, the setEvent method must throw an IllegalArgumentException");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENTPROCESSEVENT8,
            "If a value does not have a valid JAXB binding and is not a Java primitve type, the setEvent method must throw an IllegalArgumentException");
      tcd.put(V2ADDLPORTLETTESTS_SPEC2_15_EVENTEVENTHANDLING_EVENTPROCESSEVENT9,
            "The portlet can publish multiple events via the setEvent method in the processEvent method");
      tcd.put(V2ADDLPORTLETTESTS_SPEC2_15_ACTIONEVENTHANDLING_EVENTPROCESSACTION1,
            "The portlet can publish an event via the setEvent method in the processAction method");
      tcd.put(V2ADDLPORTLETTESTS_SPEC2_15_ACTIONEVENTHANDLING_EVENTPROCESSACTION2,
            "The portlet can publish an event with its full Qname via the setEvent method in the processAction method");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_15_ACTIONEVENTHANDLING_EVENTPROCESSACTION3,
            "The portlet can publish an event with only the local part of the Qname via the setEvent method in the processAction method");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_15_ACTIONEVENTHANDLING_EVENTPROCESSACTION4,
            "If an event is published with only the local part of the Qname, the namespace must be the default namespace defined in the deployment descriptor");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_15_ACTIONEVENTHANDLING_EVENTPROCESSACTION5,
            "If an event is published with only the local part of the Qname and no default namespace is defined in the deployment descriptor, the value javax.xml.XMLConstants.NULL_NS_URI must be used as the Qname namespace");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_15_ACTIONEVENTHANDLING_EVENTPROCESSACTION6,
            "If an object is serializeable and has a valid JAXB binding or is a Java primitive type, it can be used as an event value");
      tcd.put(V2ADDLPORTLETTESTS_SPEC2_15_ACTIONEVENTHANDLING_EVENTPROCESSACTION7,
            "If a value is not serializeable, the setEvent method must throw an IllegalArgumentException");
      tcd.put(
            V2ADDLPORTLETTESTS_SPEC2_15_ACTIONEVENTHANDLING_EVENTPROCESSACTION8,
            "If a value does not have a valid JAXB binding and is not a Java primitve type, the setEvent method must throw an IllegalArgumentException");
      tcd.put(V2ADDLPORTLETTESTS_SPEC2_15_ACTIONEVENTHANDLING_EVENTPROCESSACTION9,
            "The portlet can publish multiple events via the setEvent method in the processAction method");
      tcd.put(
            V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXT_PORTLETCONTEXTSERVLETCONTEXT1,
            "The initialization parameters accessible through the PortletContext must be the same that are accessible through the ServletContext of the portlet application");
      tcd.put(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXT_PORTLETCONTEXTSERVLETCONTEXT2,
            "The context initialization parameters are set in the web.xml file");
      tcd.put(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXT_PORTLETCONTEXTSERVLETCONTEXT3,
            "The PortletContext must offer access to the same set of resources the ServletContext exposes");
      tcd.put(
            V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXT_PORTLETCONTEXTSERVLETCONTEXT4,
            "The temporary working directory must be accessible as a context attribute through the PortletContext using the attribute name \"javax.servlet.context.tempdir\"");
      tcd.put(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXT_GETATTRIBUTE,
            "The PortletContext.getAttribute method provides the same functionality as the ServletContext.getAttribute method");
      tcd.put(
            V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXT_GETATTRIBUTENAMES,
            "The PortletContext.getAttributeNames method provides the same functionality as the ServletContext.getAttributeNames method");
      tcd.put(
            V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXT_GETINITPARAMETER,
            "The PortletContext.getInitParameter method provides the same functionality as the ServletContext.getInitParameter method");
      tcd.put(
            V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXT_GETINITPARAMETERNAMES,
            "The PortletContext.getInitParameterNames method provides the same functionality as the ServletContext.getInitParameterNames method");
      tcd.put(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXT_GETMIMETYPE,
            "The PortletContext.getMimeType method provides the same functionality as the ServletContext.getMimeType method");
      tcd.put(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXT_GETREALPATH,
            "The PortletContext.getRealPath method provides the same functionality as the ServletContext.getRealPath method");
      tcd.put(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXT_GETRESOURCE,
            "The PortletContext.getResource method provides the same functionality as the ServletContext.getResource method");
      tcd.put(
            V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXT_GETRESOURCEPATHS,
            "The PortletContext.getResourcePaths method provides the same functionality as the ServletContext.getResourcePaths method");
      tcd.put(
            V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXT_GETRESOURCEASSTREAM,
            "The PortletContext.getResourceAsStream method provides the same functionality as the ServletContext.getResourceAsStream method");
      tcd.put(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXT_LOG,
            "The PortletContext.log method provides the same functionality as the ServletContext.log method");
      tcd.put(
            V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXT_REMOVEATTRIBUTE,
            "The PortletContext.removeAttribute method provides the same functionality as the ServletContext.removeAttribute method");
      tcd.put(V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXT_SETATTRIBUTE,
            "The PortletContext.setAttribute method provides the same functionality as the ServletContext.setAttribute method");
      tcd.put(
            V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_CONTAINERRUNTIMEOPTIONS1,
            "The getContainerRuntimeOptions method returns an enumeration of type String containing the keys of all container runtime options that the current portlet container supports.");
      tcd.put(
            V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES1,
            "The container runtime option \"javax.portlet.actionScopedRequestAttributes\" must be supported by the portlet container");
      tcd.put(
            V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES2,
            "If the actionScopedRequestAttributes option is set to TRUE, request attributes that are set in an action persist until a new action occurs");
      tcd.put(
            V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES3,
            "If the option is set to TRUE and an attribute is set during an action request, the portlet container sets a render parameter with the name PortletRequest.ACTION_SCOPE_ID (\"javax.portlet.as\")");
      tcd.put(
            V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES4,
            "If the option is set to TRUE and an attribute is set during an action request, the attribute can be accessed in an event request that was initiated by the same action request");
      tcd.put(
            V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES5,
            "If the option is set to TRUE and an attribute is set during an action request, the attribute can be accessed in a subsequent render request");
      tcd.put(
            V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES5A,
            "If the option is set to TRUE and an attribute is set during an action request, the attribute can be accessed in a subsequent resource request");
      tcd.put(
            V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES6,
            "If the option is set to TRUE, a request attribute set during an event request is persisted in the same manner as an attribute set during action processing");
      tcd.put(
            V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES7,
            "If the option is set to TRUE, receiving an action starts a new action scope with a new scope ID, all previous attributes are no longer accessible, new attributes can be stored");
      tcd.put(
            V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES8,
            "If the option is set to TRUE, receiving a render without an existing scope ID starts a new action scope with a new scope ID, all previous attributes are no longer accessible, new attributes can be stored");
      tcd.put(
            V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES9,
            "If the option is set to TRUE, receiving an event without an existing scope ID starts a new action scope with a new scope ID, all previous attributes are no longer accessible, new attributes can be stored");
      tcd.put(
            V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES0,
            "If the option is set to TRUE, receiving an event with an existing scope ID after the first render for this scope had occurred starts a new action scope with a new scope ID, all previous attributes are no longer accessible, new attributes can be stored");
      tcd.put(
            V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES11,
            "The render parameter PortletRequest.ACTION_SCOPE_ID (\"javax.portlet.as\") can be removed from a render URL");
      tcd.put(
            V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES12,
            "The render parameter PortletRequest.ACTION_SCOPE_ID (\"javax.portlet.as\") can be removed from a resource URL");
      tcd.put(
            V2ADDLENVIRONMENTTESTS_SPEC2_10_CONTEXTOPTIONS_ACTIONSCOPEDREQUESTATTRIBUTES13,
            "The actionScopedRequestAttributes option can be set to TRUE");
      tcd.put(V2ADDLENVIRONMENTTESTS_SPEC2_17_ACTIONPREFERENCES_SETVALUES4,
            "The setValues method allows the value array to be set to  null");
      tcd.put(
            V2ADDLENVIRONMENTTESTS_SPEC2_17_ACTIONPREFERENCES_RESET1,
            "The reset method sets the value of the specified preference to its default value. The actual default value itself is implementation-specific and cannot be tested.");
      tcd.put(V2ADDLENVIRONMENTTESTS_SPEC2_17_ACTIONPREFERENCES_STORE1,
            "The store method persists preference changes previously made during the processAction method");
      tcd.put(
            V2ADDLENVIRONMENTTESTS_SPEC2_17_ACTIONPREFERENCES_STORE4,
            "If preference changes are made during the processAction method, but the method completes without store being called, the preference changes are discarded");
      tcd.put(V2ADDLENVIRONMENTTESTS_SPEC2_17_ACTIONPREFERENCES_DEPLOYMENT3,
            "A preference attribute definition may indicate if the attribute is read only");
      tcd.put(
            V2ADDLENVIRONMENTTESTS_SPEC2_17_ACTIONPREFERENCES_DEPLOYMENT4,
            "If a preference attribute definition does not contain the read-only setting, it will be modifiable in the processAction method");
      tcd.put(
            V2ADDLENVIRONMENTTESTS_SPEC2_17_ACTIONPREFERENCES_DEPLOYMENT7,
            "If a preference attribute definition contains the read-only setting, it will not be modifiable in the processAction method");
      tcd.put(
            V2ADDLENVIRONMENTTESTS_SPEC2_17_ACTIONPREFERENCES_DEPLOYMENT10,
            "A preference attribute not defined in the deployment descriptor may be added programmatically in the processAction method");
      tcd.put(V2ADDLENVIRONMENTTESTS_SPEC2_17_EVENTPREFERENCES_SETVALUES4,
            "The setValues method allows the value array to be set to  null");
      tcd.put(
            V2ADDLENVIRONMENTTESTS_SPEC2_17_EVENTPREFERENCES_RESET1,
            "The reset method sets the value of the specified preference to its default value. The actual default value itself is implementation-specific and cannot be tested.");
      tcd.put(V2ADDLENVIRONMENTTESTS_SPEC2_17_EVENTPREFERENCES_STORE1,
            "The store method persists preference changes previously made during the processEvent method");
      tcd.put(
            V2ADDLENVIRONMENTTESTS_SPEC2_17_EVENTPREFERENCES_STORE4,
            "If preference changes are made during the processEvent method, but the method completes without store being called, the preference changes are discarded");
      tcd.put(V2ADDLENVIRONMENTTESTS_SPEC2_17_EVENTPREFERENCES_DEPLOYMENT3,
            "A preference attribute definition may indicate if the attribute is read only");
      tcd.put(
            V2ADDLENVIRONMENTTESTS_SPEC2_17_EVENTPREFERENCES_DEPLOYMENT4,
            "If a preference attribute definition does not contain the read-only setting, it will be modifiable in the processAction method");
      tcd.put(
            V2ADDLENVIRONMENTTESTS_SPEC2_17_EVENTPREFERENCES_DEPLOYMENT7,
            "If a preference attribute definition contains the read-only setting, it will not be modifiable in the processAction method");
      tcd.put(
            V2ADDLENVIRONMENTTESTS_SPEC2_17_EVENTPREFERENCES_DEPLOYMENT10,
            "A preference attribute not defined in the deployment descriptor may be added programmatically in the processAction method");
      tcd.put(V2ADDLENVIRONMENTTESTS_SPEC2_17_RESOURCEPREFERENCES_SETVALUES4,
            "The setValues method allows the value array to be set to  null");
      tcd.put(
            V2ADDLENVIRONMENTTESTS_SPEC2_17_RESOURCEPREFERENCES_RESET1,
            "The reset method sets the value of the specified preference to its default value. The actual default value itself is implementation-specific and cannot be tested.");
      tcd.put(V2ADDLENVIRONMENTTESTS_SPEC2_17_RESOURCEPREFERENCES_STORE1,
            "The store method persists preference changes previously made during the processAction method");
      tcd.put(
            V2ADDLENVIRONMENTTESTS_SPEC2_17_RESOURCEPREFERENCES_STORE4,
            "If preference changes are made during the processAction method, but the method completes without store being called, the preference changes are discarded");
      tcd.put(V2ADDLENVIRONMENTTESTS_SPEC2_17_RESOURCEPREFERENCES_DEPLOYMENT3,
            "A preference attribute definition may indicate if the attribute is read only");
      tcd.put(
            V2ADDLENVIRONMENTTESTS_SPEC2_17_RESOURCEPREFERENCES_DEPLOYMENT4,
            "If a preference attribute definition does not contain the read-only setting, it will be modifiable in the processAction method");
      tcd.put(
            V2ADDLENVIRONMENTTESTS_SPEC2_17_RESOURCEPREFERENCES_DEPLOYMENT7,
            "If a preference attribute definition contains the read-only setting, it will not be modifiable in the processAction method");
      tcd.put(
            V2ADDLENVIRONMENTTESTS_SPEC2_17_RESOURCEPREFERENCES_DEPLOYMENT10,
            "A preference attribute not defined in the deployment descriptor may be added programmatically in the processAction method");
      tcd.put(V2ADDLENVIRONMENTTESTS_SPEC2_17_RENDERPREFERENCES_DEPLOYMENT1,
            "The portlet definition may define the preference attributes a portlet uses");
      tcd.put(V2ADDLENVIRONMENTTESTS_SPEC2_17_RENDERPREFERENCES_DEPLOYMENT2,
            "A preference attribute definition may include initial default values");
      tcd.put(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_SCOPE1,
            "PortletSession objects must be scoped at the portlet application context level");
      tcd.put(
            V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_SCOPE2,
            "The portlet container must not share the PortletSession object or the attributes stored in it among different portlet applications or among different user sessions");
      tcd.put(
            V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_SCOPE3,
            "Any object stored in the session using the APPLICATION_SCOPE is available to any portlet that belongs to the same portlet application and that handles a request in the same session");
      tcd.put(
            V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_SCOPE4,
            "Any Object stored in the session using the PORTLET_SCOPE must be available to the portlet during requests for the same portlet window that stored the object");
      tcd.put(
            V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_SCOPE5,
            "The PORTLET_SCOPE object must be stored in the APPLICATION_SCOPE with the attribute name 'javax.portlet.p.&lt;ID&gt;?&lt;ATTRIBUTE_NAME&gt;', where &lt;ID&gt; must be equal to the ID returned by the PortletRequest.getWindowID()");
      tcd.put(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_SETATTRIBUTE1,
            "The setAttribute method can bind an object to the session in PORTLET_SCOPE");
      tcd.put(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_SETATTRIBUTE2,
            "The setAttribute method that does not take a scope parameter binds an object to the session in PORTLET_SCOPE");
      tcd.put(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_SETATTRIBUTE3,
            "The setAttribute method can bind an object to the session in APPLICATION_SCOPE");
      tcd.put(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_GETATTRIBUTE1,
            "The getAttribute method is used to retrieve attributes stored in the session in PORTLET_SCOPE");
      tcd.put(
            V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_GETATTRIBUTE2,
            "The getAttribute method that does not take a scope parameter retrieves attributes stored in the session in PORTLET_SCOPE");
      tcd.put(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_GETATTRIBUTE3,
            "The getAttribute method is used to retrieve attributes stored in the session in APPLICATION_SCOPE");
      tcd.put(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_REMOVEATTRIBUTE1,
            "The removeAttribute method is used to remove attributes stored in the session in PORTLET_SCOPE");
      tcd.put(
            V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_REMOVEATTRIBUTE2,
            "The removeAttribute method that does not take a scope parameter remove attributes stored in the session in PORTLET_SCOPE");
      tcd.put(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_REMOVEATTRIBUTE3,
            "The removeAttribute method is used to remove attributes stored in the session in APPLICATION_SCOPE");
      tcd.put(
            V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_GETATTRIBUTENAMES1,
            "The getAttributeNames method can retrieve an Enumeration&lt;String&gt; of all attribute names stored in the session in PORTLET_SCOPE");
      tcd.put(
            V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_GETATTRIBUTENAMES2,
            "The getAttributeNames method that does not take a scope parameter retrieves an Enumeration&lt;String&gt; of all attribute names stored in the session in PORTLET_SCOPE");
      tcd.put(
            V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_GETATTRIBUTENAMES3,
            "The getAttributeNames method can retrieve an Enumeration&lt;String&gt; of all attribute names stored in the session in APPLICATION_SCOPE");
      tcd.put(
            V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_DECODEATTRIBUTENAME1,
            "The PortletSessionUtil.decodeAttributeName method returns the attribute name without the prefix for an attribute name retrieved from the HttpSession");
      tcd.put(
            V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_DECODEATTRIBUTENAME2,
            "The PortletSessionUtil.decodeAttributeName method returns the attribute name without the prefix for an attribute name retrieved from the PortletSession in APPLICATION_SCOPE");
      tcd.put(
            V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_HTTPSESSION1,
            "Data stored in the HttpSession by a servlet in the same web application is accessible to portlets through the PortletSession in APPLICATION_SCOPE");
      tcd.put(
            V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_HTTPSESSION2,
            "Data stored in the HttpSession by a JSP in the same web application is accessible to portlets through the PortletSession in APPLICATION_SCOPE");
      tcd.put(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_HTTPSESSION3,
            "Data stored by portlets in the PortletSession is accessible to servlets and JSPs through the HttpSession");
      tcd.put(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_HTTPSESSION4,
            "If the HttpSession object is invalidated, the PortletSession object must also be invalidated by the portlet container");
      tcd.put(
            V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_HTTPSESSION5,
            "If the PortletSession object is invalidated by a portlet, the portlet container must invalidate the associated HttpSession object");
      tcd.put(
            V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_HTTPSESSION6,
            "The attribute names retrieved from the HttpSession must be the same as those retrieve from the PortletSession if APPLICATION_SCOPE scope is used");
      tcd.put(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_HTTPSESSION7,
            "The attribute names retrieved from the HttpSession must have the speficied prefixing if PORTLET_SCOPE scope is used");
      tcd.put(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_HTTPSESSION8,
            "The portlet session follows the timeout behavior of the servlet session");
      tcd.put(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_HTTPSESSION9,
            "The portlet session follows the last accessed times behavior of the servlet session");
      tcd.put(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_HTTPSESSION11,
            "The portlet session follows the same semantic considerations as the servlet session");
      tcd.put(
            V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_GETCREATIONTIME,
            "The PortletSession.getCreationTime method provides the same functionality as the corresponding HttpSession.getCreationTime method");
      tcd.put(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_GETID,
            "The PortletSession.getId method provides the same functionality as the corresponding HttpSession.getId method");
      tcd.put(
            V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_GETLASTACCESSTIME,
            "The PortletSession.getLastAccessTime method provides the same functionality as the corresponding HttpSession.getLastAccessTime method");
      tcd.put(
            V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_GETMAXINCTIVEINTERVAL,
            "The PortletSession.getMaxInctiveInterval method provides the same functionality as the corresponding HttpSession.getMaxInctiveInterval method");
      tcd.put(
            V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_INVALIDATE,
            "The PortletSession.invalidate method provides the same functionality as the corresponding HttpSession.invalidate method");
      tcd.put(V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_ISNEW,
            "The PortletSession.isNew method provides the same functionality as the corresponding HttpSession.isNew method");
      tcd.put(
            V2ADDLENVIRONMENTTESTS_SPEC2_18_SESSIONS_SETMAXINACTIVEINTERVAL,
            "The PortletSession.setMaxInactiveInterval method provides the same functionality as the corresponding HttpSession.setMaxInactiveInterval method");
      tcd.put(
            V2ADDLREQUESTTESTS_SPEC2_11_ACTION_PARAMETERS1,
            "If a portlet receives a request from a client request targeted to the portlet itself, the parameters must be the string parameters encoded in the URL (added when creating the PortletURL) and the string parameters sent by the client to the portlet as part of the client request");
      tcd.put(V2ADDLREQUESTTESTS_SPEC2_11_ACTION_PARAMETERS2,
            "The parameters the request object returns must be \"x-www-form-urlencoded\" decoded");
      tcd.put(V2ADDLREQUESTTESTS_SPEC2_11_ACTION_PARAMETERS6,
            "The getParameterMap method must return an unmodifiable Map object");
      tcd.put(
            V2ADDLREQUESTTESTS_SPEC2_11_ACTION_PARAMETERS8,
            "If the portlet is performing an HTML Form submission via HTTP method POST the post form data will be populated to the portlet request parameter set if the content type is application/x-www-form-urlencoded");
      tcd.put(
            V2ADDLREQUESTTESTS_SPEC2_11_ACTION_PARAMETERS9,
            "If the portlet is performing an HTML Form submission via the HTTP method GET the form data set is appended to the portlet URL used for the form submission and are therefore accessible as request parameters for the portlet");
      tcd.put(V2ADDLREQUESTTESTS_SPEC2_11_ACTION_PUBLICRENDERPARAMETERS15,
            "A map of private parameters can be obtained through the getPrivateParameterMap method");
      tcd.put(V2ADDLREQUESTTESTS_SPEC2_11_ACTION_PUBLICRENDERPARAMETERS16,
            "A map of public parameters can be obtained through the getPublicParameterMap method");
      tcd.put(V2ADDLREQUESTTESTS_SPEC2_11_ACTION_PUBLICRENDERPARAMETERS4,
            "Public render parameters are available in the processAction method");
      tcd.put(
            V2ADDLREQUESTTESTS_SPEC2_11_ACTION_PUBLICRENDERPARAMETERS11,
            "If the portlet sets an action parameter with the same name as a public render parameter, this results in a multi-valued parameter. The public render parameter values must be the last entries in the parameter value array");
      tcd.put(
            V2ADDLREQUESTTESTS_SPEC2_11_EVENT_PARAMETERS1,
            "If a portlet receives a request from a client request targeted to the portlet itself, the parameters must be the string parameters encoded in the URL (added when creating the PortletURL) and the string parameters sent by the client to the portlet as part of the client request");
      tcd.put(V2ADDLREQUESTTESTS_SPEC2_11_EVENT_PARAMETERS2,
            "The parameters the request object returns must be \"x-www-form-urlencoded\" decoded");
      tcd.put(V2ADDLREQUESTTESTS_SPEC2_11_EVENT_PARAMETERS6,
            "The getParameterMap method must return an unmodifiable Map object");
      tcd.put(
            V2ADDLREQUESTTESTS_SPEC2_11_EVENT_PARAMETERS12,
            "If a portlet receives an event that is the result of a client request targeted to another portlet in the portal page, the parameters should be the same parameters as of the previous render request from this client");
      tcd.put(V2ADDLREQUESTTESTS_SPEC2_11_EVENT_PUBLICRENDERPARAMETERS15,
            "A map of private parameters can be obtained through the getPrivateParameterMap method");
      tcd.put(V2ADDLREQUESTTESTS_SPEC2_11_EVENT_PUBLICRENDERPARAMETERS16,
            "A map of public parameters can be obtained through the getPublicParameterMap method");
      tcd.put(V2ADDLREQUESTTESTS_SPEC2_11_EVENT_PUBLICRENDERPARAMETERS5,
            "Public render parameters are available in the processEvent method");
      tcd.put(
            V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PARAMETERS10,
            "The portlet-container must not propagate parameters received in an action or event request to subsequent render requests of the portlet");
      tcd.put(
            V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PARAMETERS11,
            "If a portlet receives a render request that is the result of a client request targeted to another portlet in the portal page, the parameters should be the same parameters as of the previous render request from this client");
      tcd.put(
            V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PARAMETERS13,
            "If a portlet receives a render request that is the result of invoking a render URL targeting this portlet the render parameters received with the render request must be the parameters set on the render URL");
      tcd.put(V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PARAMETERS15,
            "Render parameters get automatically cleared if the portlet receives a processAction or processEvent call");
      tcd.put(
            V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PARAMETERS1,
            "If a portlet receives a request from a client request targeted to the portlet itself, the parameters must be the string parameters encoded in the URL (added when creating the PortletURL) and the string parameters sent by the client to the portlet as part of the client request");
      tcd.put(V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PARAMETERS2,
            "The parameters the request object returns must be \"x-www-form-urlencoded\" decoded");
      tcd.put(V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PARAMETERS6,
            "The getParameterMap method must return an unmodifiable Map object");
      tcd.put(V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PUBLICRENDERPARAMETERS15,
            "A map of private parameters can be obtained through the getPrivateParameterMap method");
      tcd.put(V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PUBLICRENDERPARAMETERS16,
            "A map of public parameters can be obtained through the getPublicParameterMap method");
      tcd.put(V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PUBLICRENDERPARAMETERS1,
            "Public render parameters can be declared in the deployment descriptor using the public-render-parameter element");
      tcd.put(
            V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PUBLICRENDERPARAMETERS2,
            "The portlet can specify the public render parameters it would like to share via the supported-public-render-parameter element in the deployment descriptor");
      tcd.put(V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PUBLICRENDERPARAMETERS6,
            "Public render parameters are available in the render method");
      tcd.put(V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PUBLICRENDERPARAMETERS13,
            "A public render parameter can be deleted using the removePublicRenderParameter method on the StateAwareResponse");
      tcd.put(V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PUBLICRENDERPARAMETERS13A,
            "A public render parameter can be deleted using the removePublicRenderParameter method on the PortletURL");
      tcd.put(
            V2ADDLREQUESTTESTS_SPEC2_11_RESOURCE_PARAMETERS1,
            "If a portlet receives a request from a client request targeted to the portlet itself, the parameters must be the string parameters encoded in the URL (added when creating the PortletURL) and the string parameters sent by the client to the portlet as part of the client request");
      tcd.put(V2ADDLREQUESTTESTS_SPEC2_11_RESOURCE_PARAMETERS2,
            "The parameters the request object returns must be \"x-www-form-urlencoded\" decoded");
      tcd.put(V2ADDLREQUESTTESTS_SPEC2_11_RESOURCE_PARAMETERS6,
            "The getParameterMap method must return an unmodifiable Map object");
      tcd.put(
            V2ADDLREQUESTTESTS_SPEC2_11_RESOURCE_PARAMETERS17,
            "If the cacheability level of the resource URL is PORTLET or PAGE, the portlet must also receive the render parameters present in the request in which the URL was created");
      tcd.put(V2ADDLREQUESTTESTS_SPEC2_11_RESOURCE_PUBLICRENDERPARAMETERS15,
            "A map of private parameters can be obtained through the getPrivateParameterMap method");
      tcd.put(V2ADDLREQUESTTESTS_SPEC2_11_RESOURCE_PUBLICRENDERPARAMETERS16,
            "A map of public parameters can be obtained through the getPublicParameterMap method");
      tcd.put(V2ADDLREQUESTTESTS_SPEC2_11_RESOURCE_PUBLICRENDERPARAMETERS7,
            "Public render parameters are available in the serveResource method");
      tcd.put(
            V2ADDLREQUESTTESTS_SPEC2_11_RESOURCE_PUBLICRENDERPARAMETERS12,
            "If the portlet sets a resource parameter with the same name as a public render parameter, this results in a multi-valued parameter. The public render parameter values must be the last entries in the parameter value array");
      tcd.put(
            V2ADDLREQUESTTESTS_SPEC2_11_RENDERPRP_PUBLICRENDERPARAMETERS8,
            "The portlet container must only send those public render parameters to a portlet which the portlet has defined support for using supported-public-render-parameter element in the portlet.xml");
      tcd.put(
            V2ADDLREQUESTTESTS_SPEC2_11_RENDERPRP_PUBLICRENDERPARAMETERS9,
            "The portlet container must only share those render parameters of a portlet which the portlet has declared as supported public render parameters using supported-public-render-parameter element in the portlet.xml");
      tcd.put(
            V2ADDLREQUESTTESTS_SPEC2_11_RENDERPRP_PUBLICRENDERPARAMETERS10,
            "If the portlet was the target of a render URL on which a specific public render parameter is set, the portlet must receive at least this render parameter");
      tcd.put(V2ADDLREQUESTTESTS_SPEC2_11_RENDERATTR_ATTRIBUTES1,
            "The portlet can access a map with user information attributes via the request attribute PortletRequest.USER_INFO");
      tcd.put(
            V2ADDLREQUESTTESTS_SPEC2_11_RENDERATTR_ATTRIBUTES2,
            "The PortletRequest.CCPP_PROFILE request attribute must return a javax.ccpp.Profile based on the current portlet request");
      tcd.put(
            V2ADDLREQUESTTESTS_SPEC2_11_RENDERATTR_ATTRIBUTES3,
            "If the portlet container runtime option javax.portlet.renderHeaders is set to TRUE, the RENDER_PART attribute will be set when the render method is called");
      tcd.put(
            V2ADDLREQUESTTESTS_SPEC2_11_RENDERATTR_ATTRIBUTES4,
            "If the portlet container runtime option javax.portlet.renderHeaders is set to TRUE, render method will be called first with the RENDER_PART attribute set to \"RENDER_HEADERS\"");
      tcd.put(
            V2ADDLREQUESTTESTS_SPEC2_11_RENDERATTR_ATTRIBUTES5,
            "If the portlet container runtime option javax.portlet.renderHeaders is set to TRUE, render method will be called a second time with the RENDER_PART attribute set to \"RENDER_MARKUP\"");
      tcd.put(
            V2ADDLREQUESTTESTS_SPEC2_11_RENDERATTR_ATTRIBUTES8,
            "During render processing, the LIFECYCLE_PHASE (\"javax.portlet.lifecycle_phase\") attribute will contain the string \"RENDER_PHASE\"");
      tcd.put(V2ADDLREQUESTTESTS_SPEC2_11_ACTIONATTR_ATTRIBUTES1,
            "The portlet can access a map with user information attributes via the request attribute PortletRequest.USER_INFO");
      tcd.put(
            V2ADDLREQUESTTESTS_SPEC2_11_ACTIONATTR_ATTRIBUTES2,
            "The PortletRequest.CCPP_PROFILE request attribute must return a javax.ccpp.Profile based on the current portlet request");
      tcd.put(
            V2ADDLREQUESTTESTS_SPEC2_11_ACTIONATTR_ATTRIBUTES6,
            "During action processing, the LIFECYCLE_PHASE (\"javax.portlet.lifecycle_phase\") attribute will contain the string \"ACTION_PHASE\"");
      tcd.put(V2ADDLREQUESTTESTS_SPEC2_11_EVENTATTR_ATTRIBUTES1,
            "The portlet can access a map with user information attributes via the request attribute PortletRequest.USER_INFO");
      tcd.put(
            V2ADDLREQUESTTESTS_SPEC2_11_EVENTATTR_ATTRIBUTES2,
            "The PortletRequest.CCPP_PROFILE request attribute must return a javax.ccpp.Profile based on the current portlet request");
      tcd.put(
            V2ADDLREQUESTTESTS_SPEC2_11_EVENTATTR_ATTRIBUTES7,
            "During event processing, the LIFECYCLE_PHASE (\"javax.portlet.lifecycle_phase\") attribute will contain the string \"EVENT_PHASE\"");
      tcd.put(V2ADDLREQUESTTESTS_SPEC2_11_RESOURCEATTR_ATTRIBUTES1,
            "The portlet can access a map with user information attributes via the request attribute PortletRequest.USER_INFO");
      tcd.put(
            V2ADDLREQUESTTESTS_SPEC2_11_RESOURCEATTR_ATTRIBUTES2,
            "The PortletRequest.CCPP_PROFILE request attribute must return a javax.ccpp.Profile based on the current portlet request");
      tcd.put(
            V2ADDLREQUESTTESTS_SPEC2_11_RESOURCEATTR_ATTRIBUTES9,
            "During resource processing, the LIFECYCLE_PHASE (\"javax.portlet.lifecycle_phase\") attribute will contain the string \"RESOURCE_PHASE\"");
      tcd.put(
            V2ADDLREQUESTTESTS_SPEC2_11_ACTIONREQ_CONTENTTYPE1,
            "The getResponseContentType method returns a String representing the default content type the portlet container assumes for the output");
      tcd.put(
            V2ADDLREQUESTTESTS_SPEC2_11_ACTIONREQ_CONTENTTYPE2,
            "The getResponseContentTypes method returns an Enumeration of String elements representing the acceptable content types for the output in order of preference");
      tcd.put(
            V2ADDLREQUESTTESTS_SPEC2_11_ACTIONREQ_CONTENTTYPE3,
            "The first element of the Enumeration returned by the getResponseContentTypes method must equal the value returned by the getResponseContentType method");
      tcd.put(V2ADDLREQUESTTESTS_SPEC2_11_ACTIONREQ_WINDOWID4,
            "The string returned by getWindowID method must be the same ID used for scoping portlet-scope session attributes");
      tcd.put(V2ADDLREQUESTTESTS_SPEC2_11_ACTIONREQ_CONTENTTYPE6,
            "Within the processAction method, the content type must include only the MIME type, not the character set");
      tcd.put(
            V2ADDLREQUESTTESTS_SPEC2_11_EVENTREQ_CONTENTTYPE1,
            "The getResponseContentType method returns a String representing the default content type the portlet container assumes for the output");
      tcd.put(
            V2ADDLREQUESTTESTS_SPEC2_11_EVENTREQ_CONTENTTYPE2,
            "The getResponseContentTypes method returns an Enumeration of String elements representing the acceptable content types for the output in order of preference");
      tcd.put(
            V2ADDLREQUESTTESTS_SPEC2_11_EVENTREQ_CONTENTTYPE3,
            "The first element of the Enumeration returned by the getResponseContentTypes method must equal the value returned by the getResponseContentType method");
      tcd.put(V2ADDLREQUESTTESTS_SPEC2_11_EVENTREQ_WINDOWID4,
            "The string returned by getWindowID method must be the same ID used for scoping portlet-scope session attributes");
      tcd.put(V2ADDLREQUESTTESTS_SPEC2_11_EVENTREQ_CONTENTTYPE8,
            "Within the processEvent method, the content type must include only the MIME type, not the character set");
      tcd.put(
            V2ADDLREQUESTTESTS_SPEC2_11_RENDERREQ_CONTENTTYPE1,
            "The getResponseContentType method returns a String representing the default content type the portlet container assumes for the output");
      tcd.put(
            V2ADDLREQUESTTESTS_SPEC2_11_RENDERREQ_CONTENTTYPE2,
            "The getResponseContentTypes method returns an Enumeration of String elements representing the acceptable content types for the output in order of preference");
      tcd.put(
            V2ADDLREQUESTTESTS_SPEC2_11_RENDERREQ_CONTENTTYPE3,
            "The first element of the Enumeration returned by the getResponseContentTypes method must equal the value returned by the getResponseContentType method");
      tcd.put(V2ADDLREQUESTTESTS_SPEC2_11_RENDERREQ_WINDOWID4,
            "The string returned by getWindowID method must be the same ID used for scoping portlet-scope session attributes");
      tcd.put(V2ADDLREQUESTTESTS_SPEC2_11_RENDERREQ_CONTENTTYPE10,
            "Within the render method, the content type must include only the MIME type, not the character set");
      tcd.put(V2ADDLREQUESTTESTS_SPEC2_11_RENDERREQ_CONTENTTYPE13,
            "The character set of the response can be retrieved via the RenderResponse.getCharacterEncoding method");
      tcd.put(
            V2ADDLREQUESTTESTS_SPEC2_11_RESOURCEREQ_CONTENTTYPE1,
            "The getResponseContentType method returns a String representing the default content type the portlet container assumes for the output");
      tcd.put(
            V2ADDLREQUESTTESTS_SPEC2_11_RESOURCEREQ_CONTENTTYPE2,
            "The getResponseContentTypes method returns an Enumeration of String elements representing the acceptable content types for the output in order of preference");
      tcd.put(
            V2ADDLREQUESTTESTS_SPEC2_11_RESOURCEREQ_CONTENTTYPE3,
            "The first element of the Enumeration returned by the getResponseContentTypes method must equal the value returned by the getResponseContentType method");
      tcd.put(V2ADDLREQUESTTESTS_SPEC2_11_RESOURCEREQ_WINDOWID4,
            "The string returned by getWindowID method must be the same ID used for scoping portlet-scope session attributes");
      tcd.put(V2ADDLREQUESTTESTS_SPEC2_11_RESOURCEREQ_CONTENTTYPE12,
            "Within the serveResource method, the content type should be based on the HTTP Accept header provided by the client");
      tcd.put(V2ADDLREQUESTTESTS_SPEC2_11_RESOURCEREQ_CONTENTTYPE13,
            "The character set of the response can be retrieved via the RenderResponse.getCharacterEncoding method");
      tcd.put(V2ADDLRESPONSETESTS_SPEC2_12_ACTION_COOKIE1,
            "Cookies set during the Action phase should be available to the portlet during the Render phase");
      tcd.put(V2ADDLRESPONSETESTS_SPEC2_12_ACTION_COOKIE2,
            "Cookies set during the Action phase should be available to the portlet during the Resource phase");
      tcd.put(V2ADDLRESPONSETESTS_SPEC2_12_ACTION_COOKIE3,
            "Cookies set during the Action phase should be available to the portlet during the Event phase");
      tcd.put(V2ADDLRESPONSETESTS_SPEC2_12_ACTION_COOKIE4,
            "Cookies set during the Action phase should be available to the portlet during a subsequent request triggered by a URL");
      tcd.put(V2ADDLRESPONSETESTS_SPEC2_12_ACTION_REDIRECT1,
            "If a relative path is supplied to the sendRedirect method, an IllegalArgumentException must be thrown");
      tcd.put(
            V2ADDLRESPONSETESTS_SPEC2_12_ACTION_REDIRECT12,
            "If a new private render parameter value is set on the ActionResponse before the redirect, the new private render parameter value must be set on the attached render URL");
      tcd.put(
            V2ADDLRESPONSETESTS_SPEC2_12_ACTION_REDIRECT14,
            "If a new public render parameter value is set on the ActionResponse before the redirect, the new public render parameter value must be set on the attached render URL");
      tcd.put(V2ADDLRESPONSETESTS_SPEC2_12_EVENT_COOKIE5,
            "Cookies set during the Event phase should be available to the portlet during the Render phase");
      tcd.put(V2ADDLRESPONSETESTS_SPEC2_12_EVENT_COOKIE6,
            "Cookies set during the Event phase should be available to the portlet during the Resource phase");
      tcd.put(V2ADDLRESPONSETESTS_SPEC2_12_EVENT_COOKIE7,
            "Cookies set during the Event phase should be available to the portlet during a subsequent request triggered by a URL");
      tcd.put(V2ADDLRESPONSETESTS_SPEC2_12_RENDER_COOKIE8,
            "Cookies set during the Render phase should be available to the portlet during the Resource phase");
      tcd.put(V2ADDLRESPONSETESTS_SPEC2_12_RENDER_COOKIE9,
            "Cookies set during the Render phase should be available to the portlet during a subsequent Action phase");
      tcd.put(V2ADDLRESPONSETESTS_SPEC2_12_RENDER_COOKIE10,
            "Cookies set during the Render phase should be available to the portlet during a subsequent Render phase");
      tcd.put(V2ADDLRESPONSETESTS_SPEC2_12_RENDER_COOKIE11,
            "Cookies set during the Render phase should be available to the portlet during a subsequent request triggered by a URL");
      tcd.put(V2ADDLRESPONSETESTS_SPEC2_12_RENDER_COOKIE12,
            "Cookies set during the Render phase after the response has been committed are ignored");
      tcd.put(
            V2ADDLRESPONSETESTS_SPEC2_12_RENDER_CONTENTTYPE5,
            "If the setContentType method is not called before the getWriter or getPortletOutputStream method is used, the portlet container uses the content type returned by getResponseContentType");
      tcd.put(
            V2ADDLRESPONSETESTS_SPEC2_12_RENDER_CHARACTERENCODING4,
            "If the portlet does not set the character encoding, the portlet container uses UTF-8 as the default character encoding");
      tcd.put(V2ADDLRESPONSETESTS_SPEC2_12_RESOURCE_COOKIE13,
            "Cookies set during the Resource phase should be available to the portlet during a subsequent Action phase");
      tcd.put(V2ADDLRESPONSETESTS_SPEC2_12_RESOURCE_COOKIE14,
            "Cookies set during the Resource phase should be available to the portlet during a subsequent Resource phase");
      tcd.put(V2ADDLRESPONSETESTS_SPEC2_12_RESOURCE_COOKIE15,
            "Cookies set during the Resource phase should be available to the portlet during a subsequent Render phase");
      tcd.put(V2ADDLRESPONSETESTS_SPEC2_12_RESOURCE_COOKIE17,
            "Cookies set during the Resource phase after the response has been committed are ignored");
      tcd.put(
            V2ADDLRESPONSETESTS_SPEC2_12_RESOURCE_CONTENTTYPE5,
            "If the setContentType method is not called before the getWriter or getPortletOutputStream method is used, the portlet container uses the content type returned by getResponseContentType");
      tcd.put(
            V2ADDLRESPONSETESTS_SPEC2_12_RESOURCE_CHARACTERENCODING2,
            "The character encoding can be set via the setLocale method and a locale-encoding-mapping-list mapping in the web.xml deployment descriptor");
      tcd.put(
            V2ADDLRESPONSETESTS_SPEC2_12_RESOURCE_CHARACTERENCODING3,
            "The character encoding can be set via the setContentType method if the given content type string provides a value for the charset attribute");
      tcd.put(
            V2ADDLRESPONSETESTS_SPEC2_12_RESOURCE_CHARACTERENCODING4,
            "If the portlet does not set the character encoding, the portlet container uses UTF-8 as the default character encoding");
      tcd.put(V2ADDLFILTERTESTS_SPEC2_20_ACTION_FILTER1,
            "A filter declaration can be configured in the deployment descriptor");
      tcd.put(V2ADDLFILTERTESTS_SPEC2_20_ACTION_FILTER6,
            "A filter declaration can contain multiple &lt;lifecycle&gt; tags for a single filter class");
      tcd.put(
            V2ADDLFILTERTESTS_SPEC2_20_ACTION_FILTER7,
            "The filter declaration can contain initialization parameters which can be read by the filter through the FilterConfig object");
      tcd.put(
            V2ADDLFILTERTESTS_SPEC2_20_ACTION_FILTER8,
            "For each filter declaration, the filter instance must receive all initialization parameters defined in the filter declaration");
      tcd.put(
            V2ADDLFILTERTESTS_SPEC2_20_ACTION_FILTER9,
            "For each filter declaration, the filter instance must receive only initialization parameters defined in the filter declaration");
      tcd.put(
            V2ADDLFILTERTESTS_SPEC2_20_ACTION_FILTER10,
            "For multiple filter declarations for a single filter class, the filter instance must receive all initialization parameters defined in the filter declaration");
      tcd.put(
            V2ADDLFILTERTESTS_SPEC2_20_ACTION_FILTER11,
            "For multiple filter declarations for a single filter class, the filter instance must receive only initialization parameters defined in the filter declaration");
      tcd.put(V2ADDLFILTERTESTS_SPEC2_20_ACTION_FILTER12, "A filter class can appear in multiple filter declarations");
      tcd.put(V2ADDLFILTERTESTS_SPEC2_20_ACTION_FILTER13,
            "A filter declaration can be mapped to a portlet through the deployment descriptor &lt;filter-mapping&gt; element");
      tcd.put(
            V2ADDLFILTERTESTS_SPEC2_20_ACTION_FILTER14,
            "Filters can be associated with groups of portlets using the '*' character as a wildcard at the end of a string to indicate that the filter must be applied to any portlet whose name starts with the characters before the \"*\" character");
      tcd.put(
            V2ADDLFILTERTESTS_SPEC2_20_ACTION_FILTER15,
            "The order the container uses in building the chain of filters to be applied for a particular request is the order in which the &lt;portlet-name&gt; matching filter mappings appear in the deployment descriptor");
      tcd.put(V2ADDLFILTERTESTS_SPEC2_20_ACTION_FILTERWRAPPER1,
            "An ACTION_PHASE filter can wrap the ActionRequest object with a custom wrapper");
      tcd.put(V2ADDLFILTERTESTS_SPEC2_20_ACTION_FILTERWRAPPER2,
            "An ACTION_PHASE filter can wrap the ActionResponse object with a custom wrapper");
      tcd.put(
            V2ADDLFILTERTESTS_SPEC2_20_ACTION_FILTER2,
            "If the filter declaration specifies the &lt;lifecycle&gt; tag value ACTION_PHASE, the ActionFilter.doFilter method is called");
      tcd.put(V2ADDLFILTERTESTS_SPEC2_20_RENDER_FILTER1,
            "A filter declaration can be configured in the deployment descriptor");
      tcd.put(V2ADDLFILTERTESTS_SPEC2_20_RENDER_FILTER6,
            "A filter declaration can contain multiple &lt;lifecycle&gt; tags for a single filter class");
      tcd.put(
            V2ADDLFILTERTESTS_SPEC2_20_RENDER_FILTER7,
            "The filter declaration can contain initialization parameters which can be read by the filter through the FilterConfig object");
      tcd.put(
            V2ADDLFILTERTESTS_SPEC2_20_RENDER_FILTER8,
            "For each filter declaration, the filter instance must receive all initialization parameters defined in the filter declaration");
      tcd.put(
            V2ADDLFILTERTESTS_SPEC2_20_RENDER_FILTER9,
            "For each filter declaration, the filter instance must receive only initialization parameters defined in the filter declaration");
      tcd.put(
            V2ADDLFILTERTESTS_SPEC2_20_RENDER_FILTER10,
            "For multiple filter declarations for a single filter class, the filter instance must receive all initialization parameters defined in the filter declaration");
      tcd.put(
            V2ADDLFILTERTESTS_SPEC2_20_RENDER_FILTER11,
            "For multiple filter declarations for a single filter class, the filter instance must receive only initialization parameters defined in the filter declaration");
      tcd.put(V2ADDLFILTERTESTS_SPEC2_20_RENDER_FILTER12, "A filter class can appear in multiple filter declarations");
      tcd.put(V2ADDLFILTERTESTS_SPEC2_20_RENDER_FILTER13,
            "A filter declaration can be mapped to a portlet through the deployment descriptor &lt;filter-mapping&gt; element");
      tcd.put(
            V2ADDLFILTERTESTS_SPEC2_20_RENDER_FILTER14,
            "Filters can be associated with groups of portlets using the '*' character as a wildcard at the end of a string to indicate that the filter must be applied to any portlet whose name starts with the characters before the \"*\" character");
      tcd.put(
            V2ADDLFILTERTESTS_SPEC2_20_RENDER_FILTER15,
            "The order the container uses in building the chain of filters to be applied for a particular request is the order in which the &lt;portlet-name&gt; matching filter mappings appear in the deployment descriptor");
      tcd.put(V2ADDLFILTERTESTS_SPEC2_20_RENDER_FILTERWRAPPER5,
            "An RENDER_PHASE filter can wrap the RenderRequest object with a custom wrapper");
      tcd.put(V2ADDLFILTERTESTS_SPEC2_20_RENDER_FILTERWRAPPER6,
            "An RENDER_PHASE filter can wrap the RenderResponse object with a custom wrapper");
      tcd.put(
            V2ADDLFILTERTESTS_SPEC2_20_RENDER_FILTER3,
            "If the filter declaration specifies the &lt;lifecycle&gt; tag value RENDER_PHASE, the RenderFilter.doFilter method is called");
      tcd.put(V2ADDLFILTERTESTS_SPEC2_20_EVENT_FILTER1,
            "A filter declaration can be configured in the deployment descriptor");
      tcd.put(V2ADDLFILTERTESTS_SPEC2_20_EVENT_FILTER6,
            "A filter declaration can contain multiple &lt;lifecycle&gt; tags for a single filter class");
      tcd.put(
            V2ADDLFILTERTESTS_SPEC2_20_EVENT_FILTER7,
            "The filter declaration can contain initialization parameters which can be read by the filter through the FilterConfig object");
      tcd.put(
            V2ADDLFILTERTESTS_SPEC2_20_EVENT_FILTER8,
            "For each filter declaration, the filter instance must receive all initialization parameters defined in the filter declaration");
      tcd.put(
            V2ADDLFILTERTESTS_SPEC2_20_EVENT_FILTER9,
            "For each filter declaration, the filter instance must receive only initialization parameters defined in the filter declaration");
      tcd.put(
            V2ADDLFILTERTESTS_SPEC2_20_EVENT_FILTER10,
            "For multiple filter declarations for a single filter class, the filter instance must receive all initialization parameters defined in the filter declaration");
      tcd.put(
            V2ADDLFILTERTESTS_SPEC2_20_EVENT_FILTER11,
            "For multiple filter declarations for a single filter class, the filter instance must receive only initialization parameters defined in the filter declaration");
      tcd.put(V2ADDLFILTERTESTS_SPEC2_20_EVENT_FILTER12, "A filter class can appear in multiple filter declarations");
      tcd.put(V2ADDLFILTERTESTS_SPEC2_20_EVENT_FILTER13,
            "A filter declaration can be mapped to a portlet through the deployment descriptor &lt;filter-mapping&gt; element");
      tcd.put(
            V2ADDLFILTERTESTS_SPEC2_20_EVENT_FILTER14,
            "Filters can be associated with groups of portlets using the '*' character as a wildcard at the end of a string to indicate that the filter must be applied to any portlet whose name starts with the characters before the \"*\" character");
      tcd.put(
            V2ADDLFILTERTESTS_SPEC2_20_EVENT_FILTER15,
            "The order the container uses in building the chain of filters to be applied for a particular request is the order in which the &lt;portlet-name&gt; matching filter mappings appear in the deployment descriptor");
      tcd.put(V2ADDLFILTERTESTS_SPEC2_20_EVENT_FILTERWRAPPER3,
            "An EVENT_PHASE filter can wrap the EventRequest object with a custom wrapper");
      tcd.put(V2ADDLFILTERTESTS_SPEC2_20_EVENT_FILTERWRAPPER4,
            "An EVENT_PHASE filter can wrap the EventResponse object with a custom wrapper");
      tcd.put(
            V2ADDLFILTERTESTS_SPEC2_20_EVENT_FILTER4,
            "If the filter declaration specifies the &lt;lifecycle&gt; tag value EVENT_PHASE, the EventFilter.doFilter method is called");
      tcd.put(V2ADDLFILTERTESTS_SPEC2_20_RESOURCE_FILTER1,
            "A filter declaration can be configured in the deployment descriptor");
      tcd.put(V2ADDLFILTERTESTS_SPEC2_20_RESOURCE_FILTER6,
            "A filter declaration can contain multiple &lt;lifecycle&gt; tags for a single filter class");
      tcd.put(
            V2ADDLFILTERTESTS_SPEC2_20_RESOURCE_FILTER7,
            "The filter declaration can contain initialization parameters which can be read by the filter through the FilterConfig object");
      tcd.put(
            V2ADDLFILTERTESTS_SPEC2_20_RESOURCE_FILTER8,
            "For each filter declaration, the filter instance must receive all initialization parameters defined in the filter declaration");
      tcd.put(
            V2ADDLFILTERTESTS_SPEC2_20_RESOURCE_FILTER9,
            "For each filter declaration, the filter instance must receive only initialization parameters defined in the filter declaration");
      tcd.put(
            V2ADDLFILTERTESTS_SPEC2_20_RESOURCE_FILTER10,
            "For multiple filter declarations for a single filter class, the filter instance must receive all initialization parameters defined in the filter declaration");
      tcd.put(
            V2ADDLFILTERTESTS_SPEC2_20_RESOURCE_FILTER11,
            "For multiple filter declarations for a single filter class, the filter instance must receive only initialization parameters defined in the filter declaration");
      tcd.put(V2ADDLFILTERTESTS_SPEC2_20_RESOURCE_FILTER12, "A filter class can appear in multiple filter declarations");
      tcd.put(V2ADDLFILTERTESTS_SPEC2_20_RESOURCE_FILTER13,
            "A filter declaration can be mapped to a portlet through the deployment descriptor &lt;filter-mapping&gt; element");
      tcd.put(
            V2ADDLFILTERTESTS_SPEC2_20_RESOURCE_FILTER14,
            "Filters can be associated with groups of portlets using the '*' character as a wildcard at the end of a string to indicate that the filter must be applied to any portlet whose name starts with the characters before the \"*\" character");
      tcd.put(
            V2ADDLFILTERTESTS_SPEC2_20_RESOURCE_FILTER15,
            "The order the container uses in building the chain of filters to be applied for a particular request is the order in which the &lt;portlet-name&gt; matching filter mappings appear in the deployment descriptor");
      tcd.put(
            V2ADDLFILTERTESTS_SPEC2_20_RESOURCE_FILTER5,
            "If the filter declaration specifies the &lt;lifecycle&gt; tag value RESOURCE_PHASE, the ResourceFilter.doFilter method is called");
      tcd.put(V2ADDLFILTERTESTS_SPEC2_20_RESOURCE_FILTERWRAPPER7,
            "An RESOURCE_PHASE filter can wrap the ResourceRequest object with a custom wrapper");
      tcd.put(V2ADDLFILTERTESTS_SPEC2_20_RESOURCE_FILTERWRAPPER8,
            "An RESOURCE_PHASE filter can wrap the ResourceResponse object with a custom wrapper");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPGENERAL_DEFINEOBJECTS3,
            "The version 1.0 tag library may be referenced using &lt;%@ taglib uri=\"http://java.sun.com/portlet\" prefix=\"portlet\" %&gt;");
      tcd.put(V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPGENERAL_DEFINEOBJECTS1,
            "The portlet-container must provide an implementation of the Tag Lib");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPGENERAL_DEFINEOBJECTS2,
            "In order to obtain version 2 support, the tag library must be specified as &lt;%@ taglib uri=\"http://java.sun.com/portlet_2_0\" prefix=\"portlet\" %&gt;");
      tcd.put(V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPGENERAL_DEFINEOBJECTS4,
            "The defineObjects tag must not define any attribute and it must not contain any body content");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPGENERAL_NAMESPACE,
            "The namespace tag produces a unique string value for the current portlet equal to the value returned by the PortletResponse.getNamespace method");
      tcd.put(V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPGENERAL_ESCAPEXML1,
            "The container runtime option \"javax.portlet.escapeXml\" can be used to set the default escapeXML setting to true");
      tcd.put(V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPGENERAL_ESCAPEXML2,
            "The container runtime option \"javax.portlet.escapeXml\" can be used to set the default escapeXML setting to false");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPACTION_DEFINEOBJECTS1,
            "When included in the Action phase, the defineObjects tag defines the variable RenderRequest renderRequest to be null or undefined");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPACTION_DEFINEOBJECTS2,
            "When included in the Action phase, the defineObjects tag defines the variable ResourceRequest resourceRequest to be null or undefined");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPACTION_DEFINEOBJECTS3,
            "When included in the Action phase, the defineObjects tag defines the variable ActionRequest actionRequest to the corresponding object");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPACTION_DEFINEOBJECTS4,
            "When included in the Action phase, the defineObjects tag defines the variable EventRequest eventRequest to be null or undefined");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPACTION_DEFINEOBJECTS5,
            "When included in the Action phase, the defineObjects tag defines the variable RenderResponse renderResponse to be null or undefined");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPACTION_DEFINEOBJECTS6,
            "When included in the Action phase, the defineObjects tag defines the variable ResourceResponse resourceResponse to be null or undefined");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPACTION_DEFINEOBJECTS7,
            "When included in the Action phase, the defineObjects tag defines the variable ActionResponse actionResponse to the corresponding object");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPACTION_DEFINEOBJECTS8,
            "When included in the Action phase, the defineObjects tag defines the variable EventResponse eventResponse to be null or undefined");
      tcd.put(V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPACTION_DEFINEOBJECTS9,
            "When included in the Action phase, the defineObjects tag defines the variable PortletConfig portletConfig");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPACTION_DEFINEOBJECTS10,
            "When included in the Action phase, the defineObjects tag defines the variable PortletSession portletSession, providing access to the portletSession, does not create a new session, only returns an existing session or null if no session exists.");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPACTION_DEFINEOBJECTS11,
            "When included in the Action phase, the defineObjects tag defines the variable Map&lt;String, Object&gt; portletSessionScope, providing access to the portletSession attributes as a Map equivalent to the PortletSession.getAttributeMap() call, does not create a new session, only returns an existing session. If no session attributes exist this method returns an empty Map.");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPACTION_DEFINEOBJECTS12,
            "When included in the Action phase, the defineObjects tag defines the variable PortletPreferences portletPreferences, providing access to the portlet preferences.");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPACTION_DEFINEOBJECTS13,
            "When included in the Action phase, the defineObjects tag defines the variable Map&lt;String, String[]&gt; portletPreferencesValues, providing access to the portlet preferences as a Map, equivalent to the PortletPreferences.getMap() call. If no portlet preferences exist, the Map is empty.");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS1,
            "When included in the Event phase, the defineObjects tag defines the variable RenderRequest renderRequest to be null or undefined");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS2,
            "When included in the Event phase, the defineObjects tag defines the variable ResourceRequest resourceRequest to be null or undefined");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS3,
            "When included in the Event phase, the defineObjects tag defines the variable ActionRequest actionRequest to be null or undefined");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS4,
            "When included in the Event phase, the defineObjects tag defines the variable EventRequest eventRequest to the corresponding object");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS5,
            "When included in the Event phase, the defineObjects tag defines the variable RenderResponse renderResponse to be null or undefined");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS6,
            "When included in the Event phase, the defineObjects tag defines the variable ResourceResponse resourceResponse to be null or undefined");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS7,
            "When included in the Event phase, the defineObjects tag defines the variable ActionResponse actionResponse to be null or undefined");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS8,
            "When included in the Event phase, the defineObjects tag defines the variable EventResponse eventResponse to the corresponding object");
      tcd.put(V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS9,
            "When included in the Event phase, the defineObjects tag defines the variable PortletConfig portletConfig");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS10,
            "When included in the Event phase, the defineObjects tag defines the variable PortletSession portletSession, providing access to the portletSession, does not create a new session, only returns an existing session or null if no session exists.");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS11,
            "When included in the Event phase, the defineObjects tag defines the variable Map&lt;String, Object&gt; portletSessionScope, providing access to the portletSession attributes as a Map equivalent to the PortletSession.getAttributeMap() call, does not create a new session, only returns an existing session. If no session attributes exist this method returns an empty Map.");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS12,
            "When included in the Event phase, the defineObjects tag defines the variable PortletPreferences portletPreferences, providing access to the portlet preferences.");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPEVENT_DEFINEOBJECTS13,
            "When included in the Event phase, the defineObjects tag defines the variable Map&lt;String, String[]&gt; portletPreferencesValues, providing access to the portlet preferences as a Map, equivalent to the PortletPreferences.getMap() call. If no portlet preferences exist, the Map is empty.");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_DEFINEOBJECTSRENDER1,
            "When included in the Render phase, the defineObjects tag defines the variable RenderRequest renderRequest to the corresponding object");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_DEFINEOBJECTSRENDER2,
            "When included in the Render phase, the defineObjects tag defines the variable ResourceRequest resourceRequest to be null or undefined");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_DEFINEOBJECTSRENDER3,
            "When included in the Render phase, the defineObjects tag defines the variable ActionRequest actionRequest to be null or undefined");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_DEFINEOBJECTSRENDER4,
            "When included in the Render phase, the defineObjects tag defines the variable EventRequest eventRequest to be null or undefined");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_DEFINEOBJECTSRENDER5,
            "When included in the Render phase, the defineObjects tag defines the variable RenderResponse renderResponse to the corresponding object");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_DEFINEOBJECTSRENDER6,
            "When included in the Render phase, the defineObjects tag defines the variable ResourceResponse resourceResponse to be null or undefined");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_DEFINEOBJECTSRENDER7,
            "When included in the Render phase, the defineObjects tag defines the variable ActionResponse actionResponse to be null or undefined");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_DEFINEOBJECTSRENDER8,
            "When included in the Render phase, the defineObjects tag defines the variable EventResponse eventResponse to be null or undefined");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_DEFINEOBJECTSRENDER9,
            "When included in the Render phase, the defineObjects tag defines the variable PortletConfig portletConfig");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_DEFINEOBJECTSRENDER10,
            "When included in the Render phase, the defineObjects tag defines the variable PortletSession portletSession, providing access to the portletSession, does not create a new session, only returns an existing session or null if no session exists.");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_DEFINEOBJECTSRENDER11,
            "When included in the Render phase, the defineObjects tag defines the variable Map&lt;String, Object&gt; portletSessionScope, providing access to the portletSession attributes as a Map equivalent to the PortletSession.getAttributeMap() call, does not create a new session, only returns an existing session. If no session attributes exist this method returns an empty Map.");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_DEFINEOBJECTSRENDER12,
            "When included in the Render phase, the defineObjects tag defines the variable PortletPreferences portletPreferences, providing access to the portlet preferences.");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_DEFINEOBJECTSRENDER13,
            "When included in the Render phase, the defineObjects tag defines the variable Map&lt;String, String[]&gt; portletPreferencesValues, providing access to the portlet preferences as a Map, equivalent to the PortletPreferences.getMap() call. If no portlet preferences exist, the Map is empty.");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL1,
            "The portlet actionURL tag creates a URL that must point to the current portlet and must trigger an action request with the supplied parameters");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL2,
            "Parameters may be added to the URL by including the param tag between the actionURL start and end tags");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL3,
            "The optional actionURL \"windowState\" attribute can specify the desired window state after the URL is triggered");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL4,
            "If the \"windowState\" attribute specifies an invalid value, a JspException with the PortletException that caused this error as root cause is thrown");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL5,
            "The \"windowState\" attribute is not case sensitive");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL6,
            "The \"windowState\" attribute is not specified, the current window state is retained when the URL is triggered");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL7,
            "The optional actionURL \"portletMode\" attribute can specify the desired portlet mode after the URL is triggered");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL8,
            "If the \"portletMode\" attribute specifies an invalid value, a JspException with the PortletException that caused this error as root cause is thrown");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL9,
            "The \"portletMode\" attribute is not case sensitive");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL10,
            "The \"portletMode\" attribute is not specified, the current portlet mode is retained when the URL is triggered");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL11,
            "The optional actionURL \"var\" attribute can specify a scoped variable for exporting the action URL");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL12,
            "If the actionURL \"var\" attribute is specified, the URL is not written to the JspWriter");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL13,
            "If the actionURL \"var\" attribute is not specified, the URL is written to the JspWriter");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL14,
            "If the optional actionURL \"secure\" attribute is set to true, the resulting URL should require a secure connection");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL15,
            "If the optional actionURL \"secure\" attribute is set to false, the resulting URL does not need to require a secure connection");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL17,
            "The \"secure\" attribute is not specified, the security setting is retained");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL18,
            "If the optional actionURL \"copyCurrentRenderParameters\" attribute is set to true, the current private render parameters are attached to the URL");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL19,
            "If the optional actionURL \"copyCurrentRenderParameters\" attribute is set to true, additional parameters specified with the &lt;portlet:param&gt; element are merged with the render parameters");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL20,
            "If the optional actionURL \"copyCurrentRenderParameters\" attribute is set to true, additional parameters specified with the &lt;portlet:param&gt; element appear in the values array before the render parameter values if there is a name conflict");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL21,
            "If the optional actionURL \"copyCurrentRenderParameters\" attribute is set to false, the current render parameters are not attached to the URL");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL22,
            "If the \"copyCurrentRenderParameters\" attribute specifies an invalid value, a JspException is thrown");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL23,
            "The \"copyCurrentRenderParameters\" attribute is not specified, the security setting is retained");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL25,
            "If the optional actionURL \"escapeXML\" attribute is set to false, the characters \"&lt;&gt;&'\\\"\" are not converted to their entity codes");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL26,
            "The \"escapeXML\" attribute default value is true");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL27,
            "If the optional actionURL \"name\" attribute is set, the provided name string is used by GenericPortlet to dispatch the request to the coresponding annotated method");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL28,
            "Setting the \"name\" attribute will add a parameter to the action URL with the name of \"javax.portlet.action\"");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL29,
            "If this tag is used in markup provided by a serveResource call that was directly or indirectly triggered via a resource URL of type FULL, a JspException with the IllegalStateException that caused this error is thrown");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL30,
            "If this tag is used in markup provided by a serveResource call that was directly or indirectly triggered via a resource URL of type PORTLET, a JspException with the IllegalStateException that caused this error is thrown");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL1,
            "The portlet renderURL tag creates a URL that must point to the current portlet and must trigger an render request with the supplied parameters");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL2,
            "Parameters may be added to the URL by including the param tag between the renderURL start and end tags");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL3,
            "The optional renderURL \"windowState\" attribute can specify the desired window state after the URL is triggered");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL4,
            "If the \"windowState\" attribute specifies an invalid value, a JspException with the PortletException that caused this error as root cause is thrown");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL5,
            "The \"windowState\" attribute is not case sensitive");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL6,
            "The \"windowState\" attribute is not specified, the current window state is retained when the URL is triggered");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL7,
            "The optional renderURL \"portletMode\" attribute can specify the desired portlet mode after the URL is triggered");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL8,
            "If the \"portletMode\" attribute specifies an invalid value, a JspException with the PortletException that caused this error as root cause is thrown");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL9,
            "The \"portletMode\" attribute is not case sensitive");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL10,
            "The \"portletMode\" attribute is not specified, the current portlet mode is retained when the URL is triggered");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL11,
            "The optional renderURL \"var\" attribute can specify a scoped variable for exporting the action URL");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL12,
            "If the renderURL \"var\" attribute is specified, the URL is not written to the JspWriter");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL13,
            "If the renderURL \"var\" attribute is not specified, the URL is written to the JspWriter");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL14,
            "If the optional renderURL \"secure\" attribute is set to true, the resulting URL should require a secure connection");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL15,
            "If the optional renderURL \"secure\" attribute is set to false, the resulting URL does not need to require a secure connection");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL17,
            "The \"secure\" attribute is not specified, the security setting is retained");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL18,
            "If the optional renderURL \"copyCurrentRenderParameters\" attribute is set to true, the current private render parameters are attached to the URL");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL19,
            "If the optional renderURL \"copyCurrentRenderParameters\" attribute is set to true, additional parameters specified with the &lt;portlet:param&gt; element are merged with the render parameters");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL20,
            "If the optional renderURL \"copyCurrentRenderParameters\" attribute is set to true, additional parameters specified with the &lt;portlet:param&gt; element appear in the values array before the render parameter values if there is a name conflict");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL21,
            "If the optional renderURL \"copyCurrentRenderParameters\" attribute is set to false, the current render parameters are not attached to the URL");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL22,
            "If the \"copyCurrentRenderParameters\" attribute specifies an invalid value, a JspException is thrown");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL23,
            "The \"copyCurrentRenderParameters\" attribute is not specified, the security setting is retained");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL25,
            "If the optional renderURL \"escapeXML\" attribute is set to false, the characters \"&lt;&gt;&'\\\"\" are not converted to their entity codes");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL26,
            "The \"escapeXML\" attribute default value is true");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL1,
            "The portlet resourceURL tag creates a URL that must point to the current portlet and must trigger an resource request with the supplied parameters");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL2,
            "The resourceURL must preserve the current portlet mode, window state and render parameters");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL3,
            "Resource parameters may be added to the URL by including the param tag between the resourceURL start and end tags");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL4,
            "The resource parameters specified with the &lt;portlet:param&gt; element appear in the values array before the render parameter values if there is a name conflict");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL5,
            "The optional resourceURL \"var\" attribute can specify a scoped variable for exporting the action URL");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL6,
            "If the resourceURL \"var\" attribute is specified, the URL is not written to the JspWriter");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL7,
            "If the resourceURL \"var\" attribute is not specified, the URL is written to the JspWriter");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL8,
            "If the optional resourceURL \"secure\" attribute is set to true, the resulting URL should require a secure connection");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL9,
            "If the optional resourceURL \"secure\" attribute is set to false, the resulting URL does not need to require a secure connection");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL11,
            "The \"secure\" attribute is not specified, the security setting is retained");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL12,
            "If the optional resourceURL \"copyCurrentRenderParameters\" attribute is set to true, the current private render parameters are attached to the URL");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL13,
            "If the optional resourceURL \"copyCurrentRenderParameters\" attribute is set to true, additional parameters specified with the &lt;portlet:param&gt; element are merged with the render parameters");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL14,
            "If the optional resourceURL \"copyCurrentRenderParameters\" attribute is set to true, additional parameters specified with the &lt;portlet:param&gt; element appear in the values array before the render parameter values if there is a name conflict");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL15,
            "If the optional resourceURL \"copyCurrentRenderParameters\" attribute is set to false, the current render parameters are not attached to the URL");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL16,
            "If the \"copyCurrentRenderParameters\" attribute specifies an invalid value, a JspException is thrown");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL17,
            "The \"copyCurrentRenderParameters\" attribute is not specified, the security setting is retained");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL19,
            "If the optional resourceURL \"escapeXML\" attribute is set to false, the characters \"&lt;&gt;&'\\\"\" are not converted to their entity codes");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL20,
            "The \"escapeXML\" attribute default value is true");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL21,
            "If the optional resourceURL \"id\" attribute is set, the provided id string is used by GenericPortlet to dispatch the request to the coresponding annotated method");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL22,
            "Setting the \"id\" attribute will add a parameter to the action URL with the id of \"javax.portlet.action\"");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL23,
            "If the optional resourceURL \"cacheability\" attribute is set, the cacheability is set accordingly");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL24,
            "If the optional resourceURL \"cacheability\" attribute is not set, the current cacheability setting is retained");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL25,
            "If the cacheability is set to PAGE in a Resource phase include with cacheability = FULL, a JspException with the IllegalStateException that caused this error is thrown");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL26,
            "If the cacheability is set to PORTLET in a Resource phase include with cacheability = FULL, a JspException with the IllegalStateException that caused this error is thrown");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL27,
            "If the cacheability is set to PAGE in a Resource phase include with cacheability = PORTLET, a JspException with the IllegalStateException that caused this error is thrown");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PARAMACTION1,
            "The param tag can be used within the actionURL tag to add a parameter");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PARAMACTION2,
            "The param tag required attribute \"name\" defines the parameter name");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PARAMACTION3,
            "If more than one tags appear in the actionURL tag, the values must be stored as a multivalued array in order of appearance within the actionURL tag");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PARAMACTION4,
            "If the \"name\" attribute is null or empty, no action is performed");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PARAMACTION5,
            "The param tag required attribute \"value\" defines the parameter value");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PARAMACTION6,
            "If the \"value\" attribute is null or empty, the parameter is removed");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PARAMRENDER1,
            "The param tag can be used within the renderURL tag to add a parameter");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PARAMRENDER2,
            "The param tag required attribute \"name\" defines the parameter name");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PARAMRENDER3,
            "If more than one tags appear in the renderURL tag, the values must be stored as a multivalued array in order of appearance within the renderURL tag");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PARAMRENDER4,
            "If the \"name\" attribute is null or empty, no action is performed");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PARAMRENDER5,
            "The param tag required attribute \"value\" defines the parameter value");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PARAMRENDER6,
            "If the \"value\" attribute is null or empty, the parameter is removed");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PARAMRESOURCE1,
            "The param tag can be used within the resourceURL tag to add a parameter");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PARAMRESOURCE2,
            "The param tag required attribute \"name\" defines the parameter name");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PARAMRESOURCE3,
            "If more than one tags appear in the resourceURL tag, the values must be stored as a multivalued array in order of appearance within the resourceURL tag");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PARAMRESOURCE4,
            "If the \"name\" attribute is null or empty, no action is performed");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PARAMRESOURCE5,
            "The param tag required attribute \"value\" defines the parameter value");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PARAMRESOURCE6,
            "If the \"value\" attribute is null or empty, no action is performed");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PROPERTYACTION1,
            "The property tag can be used within the actionURL tag to add a property");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PROPERTYACTION2,
            "The property tag required attribute \"name\" defines the property name");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PROPERTYACTION3,
            "If more than one tags appear in the actionURL tag, the values must be stored as a multivalued array in order of appearance within the actionURL tag");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PROPERTYACTION4,
            "If the \"name\" attribute is null or empty, no action is performed");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PROPERTYACTION5,
            "The property tag required attribute \"value\" defines the property value");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PROPERTYACTION6,
            "If the \"value\" attribute is null or empty,  the property value is set to null");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PROPERTYRENDER1,
            "The property tag can be used within the renderURL tag to add a property");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PROPERTYRENDER2,
            "The property tag required attribute \"name\" defines the property name");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PROPERTYRENDER3,
            "If more than one tags appear in the renderURL tag, the values must be stored as a multivalued array in order of appearance within the renderURL tag");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PROPERTYRENDER4,
            "If the \"name\" attribute is null or empty, no action is performed");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PROPERTYRENDER5,
            "The property tag required attribute \"value\" defines the property value");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PROPERTYRENDER6,
            "If the \"value\" attribute is null or empty,  the property value is set to null");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PROPERTYRESOURCE1,
            "The property tag can be used within the resourceURL tag to add a property");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PROPERTYRESOURCE2,
            "The property tag required attribute \"name\" defines the property name");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PROPERTYRESOURCE3,
            "If more than one tags appear in the resourceURL tag, the values must be stored as a multivalued array in order of appearance within the resourceURL tag");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PROPERTYRESOURCE4,
            "If the \"name\" attribute is null or empty, no action is performed");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PROPERTYRESOURCE5,
            "The property tag required attribute \"value\" defines the property value");
      tcd.put(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PROPERTYRESOURCE6,
            "If the \"value\" attribute is null or empty, the property value is set to null");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_DEFINEOBJECTSRESOURCE1,
            "When included in the Resource phase, the defineObjects tag defines the variable RenderRequest renderRequest to be null or undefined");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_DEFINEOBJECTSRESOURCE2,
            "When included in the Resource phase, the defineObjects tag defines the variable ResourceRequest resourceRequest to the corresponding object");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_DEFINEOBJECTSRESOURCE3,
            "When included in the Resource phase, the defineObjects tag defines the variable ActionRequest actionRequest to be null or undefined");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_DEFINEOBJECTSRESOURCE4,
            "When included in the Resource phase, the defineObjects tag defines the variable EventRequest eventRequest to be null or undefined");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_DEFINEOBJECTSRESOURCE5,
            "When included in the Resource phase, the defineObjects tag defines the variable RenderResponse renderResponse to be null or undefined");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_DEFINEOBJECTSRESOURCE6,
            "When included in the Resource phase, the defineObjects tag defines the variable ResourceResponse resourceResponse to the corresponding object");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_DEFINEOBJECTSRESOURCE7,
            "When included in the Resource phase, the defineObjects tag defines the variable ActionResponse actionResponse to be null or undefined");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_DEFINEOBJECTSRESOURCE8,
            "When included in the Resource phase, the defineObjects tag defines the variable EventResponse eventResponse to be null or undefined");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_DEFINEOBJECTSRESOURCE9,
            "When included in the Resource phase, the defineObjects tag defines the variable PortletConfig portletConfig");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_DEFINEOBJECTSRESOURCE10,
            "When included in the Resource phase, the defineObjects tag defines the variable PortletSession portletSession, providing access to the portletSession, does not create a new session, only returns an existing session or null if no session exists.");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_DEFINEOBJECTSRESOURCE11,
            "When included in the Resource phase, the defineObjects tag defines the variable Map&lt;String, Object&gt; portletSessionScope, providing access to the portletSession attributes as a Map equivalent to the PortletSession.getAttributeMap() call, does not create a new session, only returns an existing session. If no session attributes exist this method returns an empty Map.");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_DEFINEOBJECTSRESOURCE12,
            "When included in the Resource phase, the defineObjects tag defines the variable PortletPreferences portletPreferences, providing access to the portlet preferences.");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_DEFINEOBJECTSRESOURCE13,
            "When included in the Resource phase, the defineObjects tag defines the variable Map&lt;String, String[]&gt; portletPreferencesValues, providing access to the portlet preferences as a Map, equivalent to the PortletPreferences.getMap() call. If no portlet preferences exist, the Map is empty.");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL1,
            "The portlet actionURL tag creates a URL that must point to the current portlet and must trigger an action request with the supplied parameters");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL2,
            "Parameters may be added to the URL by including the param tag between the actionURL start and end tags");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL3,
            "The optional actionURL \"windowState\" attribute can specify the desired window state after the URL is triggered");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL4,
            "If the \"windowState\" attribute specifies an invalid value, a JspException with the PortletException that caused this error as root cause is thrown");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL5,
            "The \"windowState\" attribute is not case sensitive");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL6,
            "The \"windowState\" attribute is not specified, the current window state is retained when the URL is triggered");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL7,
            "The optional actionURL \"portletMode\" attribute can specify the desired portlet mode after the URL is triggered");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL8,
            "If the \"portletMode\" attribute specifies an invalid value, a JspException with the PortletException that caused this error as root cause is thrown");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL9,
            "The \"portletMode\" attribute is not case sensitive");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL10,
            "The \"portletMode\" attribute is not specified, the current portlet mode is retained when the URL is triggered");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL11,
            "The optional actionURL \"var\" attribute can specify a scoped variable for exporting the action URL");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL12,
            "If the actionURL \"var\" attribute is specified, the URL is not written to the JspWriter");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL13,
            "If the actionURL \"var\" attribute is not specified, the URL is written to the JspWriter");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL14,
            "If the optional actionURL \"secure\" attribute is set to true, the resulting URL should require a secure connection");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL15,
            "If the optional actionURL \"secure\" attribute is set to false, the resulting URL does not need to require a secure connection");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL17,
            "The \"secure\" attribute is not specified, the security setting is retained");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL18,
            "If the optional actionURL \"copyCurrentRenderParameters\" attribute is set to true, the current private render parameters are attached to the URL");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL19,
            "If the optional actionURL \"copyCurrentRenderParameters\" attribute is set to true, additional parameters specified with the &lt;portlet:param&gt; element are merged with the render parameters");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL20,
            "If the optional actionURL \"copyCurrentRenderParameters\" attribute is set to true, additional parameters specified with the &lt;portlet:param&gt; element appear in the values array before the render parameter values if there is a name conflict");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL21,
            "If the optional actionURL \"copyCurrentRenderParameters\" attribute is set to false, the current render parameters are not attached to the URL");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL22,
            "If the \"copyCurrentRenderParameters\" attribute specifies an invalid value, a JspException is thrown");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL23,
            "The \"copyCurrentRenderParameters\" attribute is not specified, the security setting is retained");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL25,
            "If the optional actionURL \"escapeXML\" attribute is set to false, the characters \"&lt;&gt;&'\\\"\" are not converted to their entity codes");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL26,
            "The \"escapeXML\" attribute default value is true");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL27,
            "If the optional actionURL \"name\" attribute is set, the provided name string is used by GenericPortlet to dispatch the request to the coresponding annotated method");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL28,
            "Setting the \"name\" attribute will add a parameter to the action URL with the name of \"javax.portlet.action\"");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL29,
            "If this tag is used in markup provided by a serveResource call that was directly or indirectly triggered via a resource URL of type FULL, a JspException with the IllegalStateException that caused this error is thrown");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_ACTIONURL30,
            "If this tag is used in markup provided by a serveResource call that was directly or indirectly triggered via a resource URL of type PORTLET, a JspException with the IllegalStateException that caused this error is thrown");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL1,
            "The portlet renderURL tag creates a URL that must point to the current portlet and must trigger an render request with the supplied parameters");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL2,
            "Parameters may be added to the URL by including the param tag between the renderURL start and end tags");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL3,
            "The optional renderURL \"windowState\" attribute can specify the desired window state after the URL is triggered");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL4,
            "If the \"windowState\" attribute specifies an invalid value, a JspException with the PortletException that caused this error as root cause is thrown");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL5,
            "The \"windowState\" attribute is not case sensitive");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL6,
            "The \"windowState\" attribute is not specified, the current window state is retained when the URL is triggered");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL7,
            "The optional renderURL \"portletMode\" attribute can specify the desired portlet mode after the URL is triggered");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL8,
            "If the \"portletMode\" attribute specifies an invalid value, a JspException with the PortletException that caused this error as root cause is thrown");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL9,
            "The \"portletMode\" attribute is not case sensitive");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL10,
            "The \"portletMode\" attribute is not specified, the current portlet mode is retained when the URL is triggered");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL11,
            "The optional renderURL \"var\" attribute can specify a scoped variable for exporting the action URL");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL12,
            "If the renderURL \"var\" attribute is specified, the URL is not written to the JspWriter");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL13,
            "If the renderURL \"var\" attribute is not specified, the URL is written to the JspWriter");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL14,
            "If the optional renderURL \"secure\" attribute is set to true, the resulting URL should require a secure connection");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL15,
            "If the optional renderURL \"secure\" attribute is set to false, the resulting URL does not need to require a secure connection");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL17,
            "The \"secure\" attribute is not specified, the security setting is retained");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL18,
            "If the optional renderURL \"copyCurrentRenderParameters\" attribute is set to true, the current private render parameters are attached to the URL");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL19,
            "If the optional renderURL \"copyCurrentRenderParameters\" attribute is set to true, additional parameters specified with the &lt;portlet:param&gt; element are merged with the render parameters");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL20,
            "If the optional renderURL \"copyCurrentRenderParameters\" attribute is set to true, additional parameters specified with the &lt;portlet:param&gt; element appear in the values array before the render parameter values if there is a name conflict");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL21,
            "If the optional renderURL \"copyCurrentRenderParameters\" attribute is set to false, the current render parameters are not attached to the URL");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL22,
            "If the \"copyCurrentRenderParameters\" attribute specifies an invalid value, a JspException is thrown");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL23,
            "The \"copyCurrentRenderParameters\" attribute is not specified, the security setting is retained");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL25,
            "If the optional renderURL \"escapeXML\" attribute is set to false, the characters \"&lt;&gt;&'\\\"\" are not converted to their entity codes");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RENDERURL26,
            "The \"escapeXML\" attribute default value is true");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL1,
            "The portlet resourceURL tag creates a URL that must point to the current portlet and must trigger an resource request with the supplied parameters");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL2,
            "The resourceURL must preserve the current portlet mode, window state and render parameters");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL3,
            "Resource parameters may be added to the URL by including the param tag between the resourceURL start and end tags");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL4,
            "The resource parameters specified with the &lt;portlet:param&gt; element appear in the values array before the render parameter values if there is a name conflict");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL5,
            "The optional resourceURL \"var\" attribute can specify a scoped variable for exporting the action URL");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL6,
            "If the resourceURL \"var\" attribute is specified, the URL is not written to the JspWriter");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL7,
            "If the resourceURL \"var\" attribute is not specified, the URL is written to the JspWriter");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL8,
            "If the optional resourceURL \"secure\" attribute is set to true, the resulting URL should require a secure connection");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL9,
            "If the optional resourceURL \"secure\" attribute is set to false, the resulting URL does not need to require a secure connection");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL11,
            "The \"secure\" attribute is not specified, the security setting is retained");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL12,
            "If the optional resourceURL \"copyCurrentRenderParameters\" attribute is set to true, the current private render parameters are attached to the URL");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL13,
            "If the optional resourceURL \"copyCurrentRenderParameters\" attribute is set to true, additional parameters specified with the &lt;portlet:param&gt; element are merged with the render parameters");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL14,
            "If the optional resourceURL \"copyCurrentRenderParameters\" attribute is set to true, additional parameters specified with the &lt;portlet:param&gt; element appear in the values array before the render parameter values if there is a name conflict");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL15,
            "If the optional resourceURL \"copyCurrentRenderParameters\" attribute is set to false, the current render parameters are not attached to the URL");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL16,
            "If the \"copyCurrentRenderParameters\" attribute specifies an invalid value, a JspException is thrown");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL17,
            "The \"copyCurrentRenderParameters\" attribute is not specified, the security setting is retained");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL19,
            "If the optional resourceURL \"escapeXML\" attribute is set to false, the characters \"&lt;&gt;&'\\\"\" are not converted to their entity codes");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL20,
            "The \"escapeXML\" attribute default value is true");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL21,
            "If the optional resourceURL \"id\" attribute is set, the provided id string is used by GenericPortlet to dispatch the request to the coresponding annotated method");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL22,
            "Setting the \"id\" attribute will add a parameter to the action URL with the id of \"javax.portlet.action\"");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL23,
            "If the optional resourceURL \"cacheability\" attribute is set, the cacheability is set accordingly");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL24,
            "If the optional resourceURL \"cacheability\" attribute is not set, the current cacheability setting is retained");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL25,
            "If the cacheability is set to PAGE in a Resource phase include with cacheability = FULL, a JspException with the IllegalStateException that caused this error is thrown");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL26,
            "If the cacheability is set to PORTLET in a Resource phase include with cacheability = FULL, a JspException with the IllegalStateException that caused this error is thrown");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_RESOURCEURL27,
            "If the cacheability is set to PAGE in a Resource phase include with cacheability = PORTLET, a JspException with the IllegalStateException that caused this error is thrown");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMACTION1,
            "The param tag can be used within the actionURL tag to add a parameter");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMACTION2,
            "The param tag required attribute \"name\" defines the parameter name");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMACTION3,
            "If more than one tags appear in the actionURL tag, the values must be stored as a multivalued array in order of appearance within the actionURL tag");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMACTION4,
            "If the \"name\" attribute is null or empty, no action is performed");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMACTION5,
            "The param tag required attribute \"value\" defines the parameter value");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMACTION6,
            "If the \"value\" attribute is null or empty, the parameter is removed");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMRENDER1,
            "The param tag can be used within the renderURL tag to add a parameter");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMRENDER2,
            "The param tag required attribute \"name\" defines the parameter name");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMRENDER3,
            "If more than one tags appear in the renderURL tag, the values must be stored as a multivalued array in order of appearance within the renderURL tag");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMRENDER4,
            "If the \"name\" attribute is null or empty, no action is performed");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMRENDER5,
            "The param tag required attribute \"value\" defines the parameter value");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMRENDER6,
            "If the \"value\" attribute is null or empty, the parameter is removed");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMRESOURCE1,
            "The param tag can be used within the resourceURL tag to add a parameter");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMRESOURCE2,
            "The param tag required attribute \"name\" defines the parameter name");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMRESOURCE3,
            "If more than one tags appear in the resourceURL tag, the values must be stored as a multivalued array in order of appearance within the resourceURL tag");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMRESOURCE4,
            "If the \"name\" attribute is null or empty, no action is performed");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMRESOURCE5,
            "The param tag required attribute \"value\" defines the parameter value");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PARAMRESOURCE6,
            "If the \"value\" attribute is null or empty, no action is performed");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYACTION1,
            "The property tag can be used within the actionURL tag to add a property");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYACTION2,
            "The property tag required attribute \"name\" defines the property name");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYACTION3,
            "If more than one tags appear in the actionURL tag, the values must be stored as a multivalued array in order of appearance within the actionURL tag");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYACTION4,
            "If the \"name\" attribute is null or empty, no action is performed");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYACTION5,
            "The property tag required attribute \"value\" defines the property value");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYACTION6,
            "If the \"value\" attribute is null or empty,  the property value is set to null");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYRENDER1,
            "The property tag can be used within the renderURL tag to add a property");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYRENDER2,
            "The property tag required attribute \"name\" defines the property name");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYRENDER3,
            "If more than one tags appear in the renderURL tag, the values must be stored as a multivalued array in order of appearance within the renderURL tag");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYRENDER4,
            "If the \"name\" attribute is null or empty, no action is performed");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYRENDER5,
            "The property tag required attribute \"value\" defines the property value");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYRENDER6,
            "If the \"value\" attribute is null or empty,  the property value is set to null");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYRESOURCE1,
            "The property tag can be used within the resourceURL tag to add a property");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYRESOURCE2,
            "The property tag required attribute \"name\" defines the property name");
      tcd.put(
            V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYRESOURCE3,
            "If more than one tags appear in the resourceURL tag, the values must be stored as a multivalued array in order of appearance within the resourceURL tag");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYRESOURCE4,
            "If the \"name\" attribute is null or empty, no action is performed");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYRESOURCE5,
            "The property tag required attribute \"value\" defines the property value");
      tcd.put(V2PORTLETTAGLIBRARYTESTS3_SPEC2_26_INCLUDEJSPRESOURCE_PROPERTYRESOURCE6,
            "If the \"value\" attribute is null or empty, the property value is set to null");

   }

   /**
    * Constructor.
    * 
    * Passes the static test case names - details map to the superclass
    * 
    * Note that the backing map is static and not threadsafe. Operations that change the map such as put, remove, etc.,
    * should not be used in portlets.
    */
   public JSR286SpecTestCaseDetails() {
      super(tcd);
   }

}
