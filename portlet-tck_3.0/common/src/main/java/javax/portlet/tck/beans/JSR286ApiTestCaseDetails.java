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
public class JSR286ApiTestCaseDetails extends TestCaseDetails {

   public final static String               V2FILTERTESTS_FILTERCHAIN_APIACTIONFILTER_INVOKEACTIONFILTER                          = "V2FilterTests_FilterChain_ApiActionFilter_invokeActionFilter";
   public final static String               V2FILTERTESTS_FILTERCHAIN_APIACTIONFILTER_INVOKEACTIONFILTER2                         = "V2FilterTests_FilterChain_ApiActionFilter_invokeActionFilter2";
   public final static String               V2FILTERTESTS_FILTERCHAIN_APIACTIONFILTER_INVOKEACTIONEXCEPTION                       = "V2FilterTests_FilterChain_ApiActionFilter_invokeActionException";
   public final static String               V2FILTERTESTS_FILTERCHAIN_APIEVENTFILTER_INVOKEEVENTFILTER                            = "V2FilterTests_FilterChain_ApiEventFilter_invokeEventFilter";
   public final static String               V2FILTERTESTS_FILTERCHAIN_APIEVENTFILTER_INVOKEEVENTFILTER2                           = "V2FilterTests_FilterChain_ApiEventFilter_invokeEventFilter2";
   public final static String               V2FILTERTESTS_FILTERCHAIN_APIEVENTFILTER_INVOKEEVENTEXCEPTION                         = "V2FilterTests_FilterChain_ApiEventFilter_invokeEventException";
   public final static String               V2FILTERTESTS_FILTERCHAIN_APIRENDERFILTER_INVOKERENDERFILTER                          = "V2FilterTests_FilterChain_ApiRenderFilter_invokeRenderFilter";
   public final static String               V2FILTERTESTS_FILTERCHAIN_APIRENDERFILTER_INVOKERENDERFILTER2                         = "V2FilterTests_FilterChain_ApiRenderFilter_invokeRenderFilter2";
   public final static String               V2FILTERTESTS_FILTERCHAIN_APIRENDERFILTER_INVOKERENDEREXCEPTION                       = "V2FilterTests_FilterChain_ApiRenderFilter_invokeRenderException";
   public final static String               V2FILTERTESTS_FILTERCHAIN_APIRESOURCEFILTER_INVOKERESOURCEFILTER                      = "V2FilterTests_FilterChain_ApiResourceFilter_invokeResourceFilter";
   public final static String               V2FILTERTESTS_FILTERCHAIN_APIRESOURCEFILTER_INVOKERESOURCEFILTER2                     = "V2FilterTests_FilterChain_ApiResourceFilter_invokeResourceFilter2";
   public final static String               V2FILTERTESTS_FILTERCHAIN_APIRESOURCEFILTER_INVOKERESOURCEEXCEPTION                   = "V2FilterTests_FilterChain_ApiResourceFilter_invokeResourceException";
   public final static String               V2FILTERTESTS_FILTERCONFIG_APIRENDERFILTER_GETFILTERNAME                              = "V2FilterTests_FilterConfig_ApiRenderFilter_getFilterName";
   public final static String               V2FILTERTESTS_FILTERCONFIG_APIRENDERFILTER_GETPORTLETCONTEXT                          = "V2FilterTests_FilterConfig_ApiRenderFilter_getPortletContext";
   public final static String               V2FILTERTESTS_FILTERCONFIG_APIRENDERFILTER_GETINITPARAMETER1                          = "V2FilterTests_FilterConfig_ApiRenderFilter_getInitParameter1";
   public final static String               V2FILTERTESTS_FILTERCONFIG_APIRENDERFILTER_GETINITPARAMETER2                          = "V2FilterTests_FilterConfig_ApiRenderFilter_getInitParameter2";
   public final static String               V2FILTERTESTS_FILTERCONFIG_APIRENDERFILTER_GETINITPARAMETERNAMES1                     = "V2FilterTests_FilterConfig_ApiRenderFilter_getInitParameterNames1";
   public final static String               V2FILTERTESTS_FILTERCONFIG_APIRENDERFILTER_GETINITPARAMETERNAMES2                     = "V2FilterTests_FilterConfig_ApiRenderFilter_getInitParameterNames2";
   public final static String               V2FILTERTESTS_PORTLETFILTER_APIACTIONFILTER_INITACTION1                               = "V2FilterTests_PortletFilter_ApiActionFilter_initAction1";
   public final static String               V2FILTERTESTS_PORTLETFILTER_APIACTIONFILTER_INITACTION2                               = "V2FilterTests_PortletFilter_ApiActionFilter_initAction2";
   public final static String               V2FILTERTESTS_PORTLETFILTER_APIACTIONFILTER_INITACTION3                               = "V2FilterTests_PortletFilter_ApiActionFilter_initAction3";
   public final static String               V2FILTERTESTS_PORTLETFILTER_APIEVENTFILTER_INITEVENT1                                 = "V2FilterTests_PortletFilter_ApiEventFilter_initEvent1";
   public final static String               V2FILTERTESTS_PORTLETFILTER_APIEVENTFILTER_INITEVENT2                                 = "V2FilterTests_PortletFilter_ApiEventFilter_initEvent2";
   public final static String               V2FILTERTESTS_PORTLETFILTER_APIEVENTFILTER_INITEVENT3                                 = "V2FilterTests_PortletFilter_ApiEventFilter_initEvent3";
   public final static String               V2FILTERTESTS_PORTLETFILTER_APIRENDERFILTER_INITRENDER1                               = "V2FilterTests_PortletFilter_ApiRenderFilter_initRender1";
   public final static String               V2FILTERTESTS_PORTLETFILTER_APIRENDERFILTER_INITRENDER2                               = "V2FilterTests_PortletFilter_ApiRenderFilter_initRender2";
   public final static String               V2FILTERTESTS_PORTLETFILTER_APIRENDERFILTER_INITRENDER3                               = "V2FilterTests_PortletFilter_ApiRenderFilter_initRender3";
   public final static String               V2FILTERTESTS_PORTLETFILTER_APIRESOURCEFILTER_INITRESOURCE1                           = "V2FilterTests_PortletFilter_ApiResourceFilter_initResource1";
   public final static String               V2FILTERTESTS_PORTLETFILTER_APIRESOURCEFILTER_INITRESOURCE2                           = "V2FilterTests_PortletFilter_ApiResourceFilter_initResource2";
   public final static String               V2FILTERTESTS_PORTLETFILTER_APIRESOURCEFILTER_INITRESOURCE3                           = "V2FilterTests_PortletFilter_ApiResourceFilter_initResource3";
   public final static String               V2FILTERTESTS_ACTIONFILTER_APIACTIONFILTER_CANBECONFIGURED1                           = "V2FilterTests_ActionFilter_ApiActionFilter_canBeConfigured1";
   public final static String               V2FILTERTESTS_ACTIONFILTER_APIACTIONFILTER_CANBECONFIGURED2                           = "V2FilterTests_ActionFilter_ApiActionFilter_canBeConfigured2";
   public final static String               V2FILTERTESTS_ACTIONFILTER_APIACTIONFILTER_DOFILTERISCALLED                           = "V2FilterTests_ActionFilter_ApiActionFilter_doFilterIsCalled";
   public final static String               V2FILTERTESTS_ACTIONFILTER_APIACTIONFILTER_DOFILTERPROCESSACTION1                     = "V2FilterTests_ActionFilter_ApiActionFilter_doFilterProcessAction1";
   public final static String               V2FILTERTESTS_ACTIONFILTER_APIACTIONFILTER_DOFILTERPROCESSACTION2                     = "V2FilterTests_ActionFilter_ApiActionFilter_doFilterProcessAction2";
   public final static String               V2FILTERTESTS_ACTIONFILTER_APIACTIONFILTER_DOFILTERBLOCK                              = "V2FilterTests_ActionFilter_ApiActionFilter_doFilterBlock";
   public final static String               V2FILTERTESTS_ACTIONFILTER_APIACTIONFILTER_DOFILTEREXCEPTION1                         = "V2FilterTests_ActionFilter_ApiActionFilter_doFilterException1";
   public final static String               V2FILTERTESTS_ACTIONFILTER_APIACTIONFILTER_DOFILTEREXCEPTION2                         = "V2FilterTests_ActionFilter_ApiActionFilter_doFilterException2";
   public final static String               V2FILTERTESTS_ACTIONFILTER_APIACTIONFILTER_DOFILTEREXAMINE                            = "V2FilterTests_ActionFilter_ApiActionFilter_doFilterExamine";
   public final static String               V2FILTERTESTS_EVENTFILTER_APIEVENTFILTER_CANBECONFIGURED1                             = "V2FilterTests_EventFilter_ApiEventFilter_canBeConfigured1";
   public final static String               V2FILTERTESTS_EVENTFILTER_APIEVENTFILTER_CANBECONFIGURED2                             = "V2FilterTests_EventFilter_ApiEventFilter_canBeConfigured2";
   public final static String               V2FILTERTESTS_EVENTFILTER_APIEVENTFILTER_DOFILTERISCALLED                             = "V2FilterTests_EventFilter_ApiEventFilter_doFilterIsCalled";
   public final static String               V2FILTERTESTS_EVENTFILTER_APIEVENTFILTER_DOFILTERPROCESSEVENT1                        = "V2FilterTests_EventFilter_ApiEventFilter_doFilterProcessEvent1";
   public final static String               V2FILTERTESTS_EVENTFILTER_APIEVENTFILTER_DOFILTERPROCESSEVENT2                        = "V2FilterTests_EventFilter_ApiEventFilter_doFilterProcessEvent2";
   public final static String               V2FILTERTESTS_EVENTFILTER_APIEVENTFILTER_DOFILTERBLOCK                                = "V2FilterTests_EventFilter_ApiEventFilter_doFilterBlock";
   public final static String               V2FILTERTESTS_EVENTFILTER_APIEVENTFILTER_DOFILTEREXCEPTION1                           = "V2FilterTests_EventFilter_ApiEventFilter_doFilterException1";
   public final static String               V2FILTERTESTS_EVENTFILTER_APIEVENTFILTER_DOFILTEREXCEPTION2                           = "V2FilterTests_EventFilter_ApiEventFilter_doFilterException2";
   public final static String               V2FILTERTESTS_EVENTFILTER_APIEVENTFILTER_DOFILTEREXAMINE                              = "V2FilterTests_EventFilter_ApiEventFilter_doFilterExamine";
   public final static String               V2FILTERTESTS_RENDERFILTER_APIRENDERFILTER_CANBECONFIGURED1                           = "V2FilterTests_RenderFilter_ApiRenderFilter_canBeConfigured1";
   public final static String               V2FILTERTESTS_RENDERFILTER_APIRENDERFILTER_CANBECONFIGURED2                           = "V2FilterTests_RenderFilter_ApiRenderFilter_canBeConfigured2";
   public final static String               V2FILTERTESTS_RENDERFILTER_APIRENDERFILTER_DOFILTERISCALLED                           = "V2FilterTests_RenderFilter_ApiRenderFilter_doFilterIsCalled";
   public final static String               V2FILTERTESTS_RENDERFILTER_APIRENDERFILTER_DOFILTERPROCESSRENDER1                     = "V2FilterTests_RenderFilter_ApiRenderFilter_doFilterProcessRender1";
   public final static String               V2FILTERTESTS_RENDERFILTER_APIRENDERFILTER_DOFILTERPROCESSRENDER2                     = "V2FilterTests_RenderFilter_ApiRenderFilter_doFilterProcessRender2";
   public final static String               V2FILTERTESTS_RENDERFILTER_APIRENDERFILTER_DOFILTERBLOCK                              = "V2FilterTests_RenderFilter_ApiRenderFilter_doFilterBlock";
   public final static String               V2FILTERTESTS_RENDERFILTER_APIRENDERFILTER_DOFILTEREXCEPTION1                         = "V2FilterTests_RenderFilter_ApiRenderFilter_doFilterException1";
   public final static String               V2FILTERTESTS_RENDERFILTER_APIRENDERFILTER_DOFILTEREXCEPTION2                         = "V2FilterTests_RenderFilter_ApiRenderFilter_doFilterException2";
   public final static String               V2FILTERTESTS_RENDERFILTER_APIRENDERFILTER_DOFILTEREXAMINE                            = "V2FilterTests_RenderFilter_ApiRenderFilter_doFilterExamine";
   public final static String               V2FILTERTESTS_RESOURCEFILTER_APIRESOURCEFILTER_CANBECONFIGURED1                       = "V2FilterTests_ResourceFilter_ApiResourceFilter_canBeConfigured1";
   public final static String               V2FILTERTESTS_RESOURCEFILTER_APIRESOURCEFILTER_CANBECONFIGURED2                       = "V2FilterTests_ResourceFilter_ApiResourceFilter_canBeConfigured2";
   public final static String               V2FILTERTESTS_RESOURCEFILTER_APIRESOURCEFILTER_DOFILTERISCALLED                       = "V2FilterTests_ResourceFilter_ApiResourceFilter_doFilterIsCalled";
   public final static String               V2FILTERTESTS_RESOURCEFILTER_APIRESOURCEFILTER_DOFILTERPROCESSRESOURCE1               = "V2FilterTests_ResourceFilter_ApiResourceFilter_doFilterProcessResource1";
   public final static String               V2FILTERTESTS_RESOURCEFILTER_APIRESOURCEFILTER_DOFILTERPROCESSRESOURCE2               = "V2FilterTests_ResourceFilter_ApiResourceFilter_doFilterProcessResource2";
   public final static String               V2FILTERTESTS_RESOURCEFILTER_APIRESOURCEFILTER_DOFILTERBLOCK                          = "V2FilterTests_ResourceFilter_ApiResourceFilter_doFilterBlock";
   public final static String               V2FILTERTESTS_RESOURCEFILTER_APIRESOURCEFILTER_DOFILTEREXCEPTION1                     = "V2FilterTests_ResourceFilter_ApiResourceFilter_doFilterException1";
   public final static String               V2FILTERTESTS_RESOURCEFILTER_APIRESOURCEFILTER_DOFILTEREXCEPTION2                     = "V2FilterTests_ResourceFilter_ApiResourceFilter_doFilterException2";
   public final static String               V2FILTERTESTS_RESOURCEFILTER_APIRESOURCEFILTER_DOFILTEREXAMINE                        = "V2FilterTests_ResourceFilter_ApiResourceFilter_doFilterExamine";
   public final static String               V2WRAPPERTESTS_ACTIONREQUESTWRAPPER_APIACTION_GETCHARACTERENCODING                    = "V2WrapperTests_ActionRequestWrapper_ApiAction_getCharacterEncoding";
   public final static String               V2WRAPPERTESTS_ACTIONREQUESTWRAPPER_APIACTION_GETCONTENTLENGTH                        = "V2WrapperTests_ActionRequestWrapper_ApiAction_getContentLength";
   public final static String               V2WRAPPERTESTS_ACTIONREQUESTWRAPPER_APIACTION_GETCONTENTTYPE                          = "V2WrapperTests_ActionRequestWrapper_ApiAction_getContentType";
   public final static String               V2WRAPPERTESTS_ACTIONREQUESTWRAPPER_APIACTION_GETPORTLETINPUTSTREAM                   = "V2WrapperTests_ActionRequestWrapper_ApiAction_getPortletInputStream";
   public final static String               V2WRAPPERTESTS_ACTIONREQUESTWRAPPER_APIACTION_GETREADER                               = "V2WrapperTests_ActionRequestWrapper_ApiAction_getReader";
   public final static String               V2WRAPPERTESTS_ACTIONREQUESTWRAPPER_APIACTION_SETCHARACTERENCODING                    = "V2WrapperTests_ActionRequestWrapper_ApiAction_setCharacterEncoding";
   public final static String               V2WRAPPERTESTS_ACTIONREQUESTWRAPPER_APIACTION_GETREQUEST                              = "V2WrapperTests_ActionRequestWrapper_ApiAction_getRequest";
   public final static String               V2WRAPPERTESTS_ACTIONREQUESTWRAPPER_APIACTION_SETREQUEST                              = "V2WrapperTests_ActionRequestWrapper_ApiAction_setRequest";
   public final static String               V2WRAPPERTESTS_ACTIONREQUESTWRAPPER_APIACTION_GETMETHOD                               = "V2WrapperTests_ActionRequestWrapper_ApiAction_getMethod";
   public final static String               V2WRAPPERTESTS_ACTIONRESPONSEWRAPPER_APIACTION_SENDREDIRECTA                          = "V2WrapperTests_ActionResponseWrapper_ApiAction_sendRedirectA";
   public final static String               V2WRAPPERTESTS_ACTIONRESPONSEWRAPPER_APIACTION_SENDREDIRECTB                          = "V2WrapperTests_ActionResponseWrapper_ApiAction_sendRedirectB";
   public final static String               V2WRAPPERTESTS_ACTIONRESPONSEWRAPPER_APIACTION_SETEVENTA                              = "V2WrapperTests_ActionResponseWrapper_ApiAction_setEventA";
   public final static String               V2WRAPPERTESTS_ACTIONRESPONSEWRAPPER_APIACTION_SETEVENTB                              = "V2WrapperTests_ActionResponseWrapper_ApiAction_setEventB";
   public final static String               V2WRAPPERTESTS_ACTIONRESPONSEWRAPPER_APIACTION_SETPORTLETMODE                         = "V2WrapperTests_ActionResponseWrapper_ApiAction_setPortletMode";
   public final static String               V2WRAPPERTESTS_ACTIONRESPONSEWRAPPER_APIACTION_SETRENDERPARAMETERA                    = "V2WrapperTests_ActionResponseWrapper_ApiAction_setRenderParameterA";
   public final static String               V2WRAPPERTESTS_ACTIONRESPONSEWRAPPER_APIACTION_SETRENDERPARAMETERB                    = "V2WrapperTests_ActionResponseWrapper_ApiAction_setRenderParameterB";
   public final static String               V2WRAPPERTESTS_ACTIONRESPONSEWRAPPER_APIACTION_SETRENDERPARAMETERS                    = "V2WrapperTests_ActionResponseWrapper_ApiAction_setRenderParameters";
   public final static String               V2WRAPPERTESTS_ACTIONRESPONSEWRAPPER_APIACTION_SETWINDOWSTATE                         = "V2WrapperTests_ActionResponseWrapper_ApiAction_setWindowState";
   public final static String               V2WRAPPERTESTS_ACTIONRESPONSEWRAPPER_APIACTION_GETRESPONSE                            = "V2WrapperTests_ActionResponseWrapper_ApiAction_getResponse";
   public final static String               V2WRAPPERTESTS_ACTIONRESPONSEWRAPPER_APIACTION_SETRESPONSE                            = "V2WrapperTests_ActionResponseWrapper_ApiAction_setResponse";
   public final static String               V2WRAPPERTESTS_ACTIONRESPONSEWRAPPER_APIACTION_GETPORTLETMODE                         = "V2WrapperTests_ActionResponseWrapper_ApiAction_getPortletMode";
   public final static String               V2WRAPPERTESTS_ACTIONRESPONSEWRAPPER_APIACTION_GETRENDERPARAMETERMAP1                 = "V2WrapperTests_ActionResponseWrapper_ApiAction_getRenderParameterMap1";
   public final static String               V2WRAPPERTESTS_ACTIONRESPONSEWRAPPER_APIACTION_GETWINDOWSTATE                         = "V2WrapperTests_ActionResponseWrapper_ApiAction_getWindowState";
   public final static String               V2WRAPPERTESTS_ACTIONRESPONSEWRAPPER_APIACTION_REMOVEPUBLICRENDERPARAMETER            = "V2WrapperTests_ActionResponseWrapper_ApiAction_removePublicRenderParameter";
   public final static String               V2WRAPPERTESTS_EVENTREQUESTWRAPPER_APIEVENT_GETREQUEST                                = "V2WrapperTests_EventRequestWrapper_ApiEvent_getRequest";
   public final static String               V2WRAPPERTESTS_EVENTREQUESTWRAPPER_APIEVENT_SETREQUEST                                = "V2WrapperTests_EventRequestWrapper_ApiEvent_setRequest";
   public final static String               V2WRAPPERTESTS_EVENTREQUESTWRAPPER_APIEVENT_GETEVENT1                                 = "V2WrapperTests_EventRequestWrapper_ApiEvent_getEvent1";
   public final static String               V2WRAPPERTESTS_EVENTREQUESTWRAPPER_APIEVENT_GETMETHOD                                 = "V2WrapperTests_EventRequestWrapper_ApiEvent_getMethod";
   public final static String               V2WRAPPERTESTS_EVENTRESPONSEWRAPPER_APIEVENT_SETEVENTA                                = "V2WrapperTests_EventResponseWrapper_ApiEvent_setEventA";
   public final static String               V2WRAPPERTESTS_EVENTRESPONSEWRAPPER_APIEVENT_SETEVENTB                                = "V2WrapperTests_EventResponseWrapper_ApiEvent_setEventB";
   public final static String               V2WRAPPERTESTS_EVENTRESPONSEWRAPPER_APIEVENT_SETPORTLETMODE                           = "V2WrapperTests_EventResponseWrapper_ApiEvent_setPortletMode";
   public final static String               V2WRAPPERTESTS_EVENTRESPONSEWRAPPER_APIEVENT_SETRENDERPARAMETERA                      = "V2WrapperTests_EventResponseWrapper_ApiEvent_setRenderParameterA";
   public final static String               V2WRAPPERTESTS_EVENTRESPONSEWRAPPER_APIEVENT_SETRENDERPARAMETERB                      = "V2WrapperTests_EventResponseWrapper_ApiEvent_setRenderParameterB";
   public final static String               V2WRAPPERTESTS_EVENTRESPONSEWRAPPER_APIEVENT_SETRENDERPARAMETERSA                     = "V2WrapperTests_EventResponseWrapper_ApiEvent_setRenderParametersA";
   public final static String               V2WRAPPERTESTS_EVENTRESPONSEWRAPPER_APIEVENT_SETRENDERPARAMETERSB                     = "V2WrapperTests_EventResponseWrapper_ApiEvent_setRenderParametersB";
   public final static String               V2WRAPPERTESTS_EVENTRESPONSEWRAPPER_APIEVENT_SETWINDOWSTATE                           = "V2WrapperTests_EventResponseWrapper_ApiEvent_setWindowState";
   public final static String               V2WRAPPERTESTS_EVENTRESPONSEWRAPPER_APIEVENT_GETRESPONSE                              = "V2WrapperTests_EventResponseWrapper_ApiEvent_getResponse";
   public final static String               V2WRAPPERTESTS_EVENTRESPONSEWRAPPER_APIEVENT_SETRESPONSE                              = "V2WrapperTests_EventResponseWrapper_ApiEvent_setResponse";
   public final static String               V2WRAPPERTESTS_EVENTRESPONSEWRAPPER_APIEVENT_GETPORTLETMODE                           = "V2WrapperTests_EventResponseWrapper_ApiEvent_getPortletMode";
   public final static String               V2WRAPPERTESTS_EVENTRESPONSEWRAPPER_APIEVENT_GETRENDERPARAMETERMAP1                   = "V2WrapperTests_EventResponseWrapper_ApiEvent_getRenderParameterMap1";
   public final static String               V2WRAPPERTESTS_EVENTRESPONSEWRAPPER_APIEVENT_GETWINDOWSTATE                           = "V2WrapperTests_EventResponseWrapper_ApiEvent_getWindowState";
   public final static String               V2WRAPPERTESTS_EVENTRESPONSEWRAPPER_APIEVENT_REMOVEPUBLICRENDERPARAMETER              = "V2WrapperTests_EventResponseWrapper_ApiEvent_removePublicRenderParameter";
   public final static String               V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETATTRIBUTE                           = "V2WrapperTests_PortletRequestWrapper_ApiRender_getAttribute";
   public final static String               V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETATTRIBUTENAMES                      = "V2WrapperTests_PortletRequestWrapper_ApiRender_getAttributeNames";
   public final static String               V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETAUTHTYPE                            = "V2WrapperTests_PortletRequestWrapper_ApiRender_getAuthType";
   public final static String               V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETCONTEXTPATH                         = "V2WrapperTests_PortletRequestWrapper_ApiRender_getContextPath";
   public final static String               V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETCOOKIES                             = "V2WrapperTests_PortletRequestWrapper_ApiRender_getCookies";
   public final static String               V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETLOCALE                              = "V2WrapperTests_PortletRequestWrapper_ApiRender_getLocale";
   public final static String               V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETLOCALES                             = "V2WrapperTests_PortletRequestWrapper_ApiRender_getLocales";
   public final static String               V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETPARAMETER                           = "V2WrapperTests_PortletRequestWrapper_ApiRender_getParameter";
   public final static String               V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETPARAMETERMAP                        = "V2WrapperTests_PortletRequestWrapper_ApiRender_getParameterMap";
   public final static String               V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETPARAMETERNAMES                      = "V2WrapperTests_PortletRequestWrapper_ApiRender_getParameterNames";
   public final static String               V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETPARAMETERVALUES                     = "V2WrapperTests_PortletRequestWrapper_ApiRender_getParameterValues";
   public final static String               V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETPORTALCONTEXT                       = "V2WrapperTests_PortletRequestWrapper_ApiRender_getPortalContext";
   public final static String               V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETPORTLETMODE                         = "V2WrapperTests_PortletRequestWrapper_ApiRender_getPortletMode";
   public final static String               V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETPORTLETSESSIONA                     = "V2WrapperTests_PortletRequestWrapper_ApiRender_getPortletSessionA";
   public final static String               V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETPORTLETSESSIONB                     = "V2WrapperTests_PortletRequestWrapper_ApiRender_getPortletSessionB";
   public final static String               V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETPREFERENCES                         = "V2WrapperTests_PortletRequestWrapper_ApiRender_getPreferences";
   public final static String               V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETPROPERTIES                          = "V2WrapperTests_PortletRequestWrapper_ApiRender_getProperties";
   public final static String               V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETPROPERTY                            = "V2WrapperTests_PortletRequestWrapper_ApiRender_getProperty";
   public final static String               V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETPROPERTYNAMES                       = "V2WrapperTests_PortletRequestWrapper_ApiRender_getPropertyNames";
   public final static String               V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETREMOTEUSER                          = "V2WrapperTests_PortletRequestWrapper_ApiRender_getRemoteUser";
   public final static String               V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETREQUESTEDSESSIONID                  = "V2WrapperTests_PortletRequestWrapper_ApiRender_getRequestedSessionId";
   public final static String               V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETRESPONSECONTENTTYPE                 = "V2WrapperTests_PortletRequestWrapper_ApiRender_getResponseContentType";
   public final static String               V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETRESPONSECONTENTTYPES                = "V2WrapperTests_PortletRequestWrapper_ApiRender_getResponseContentTypes";
   public final static String               V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETSCHEME                              = "V2WrapperTests_PortletRequestWrapper_ApiRender_getScheme";
   public final static String               V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETSERVERNAME                          = "V2WrapperTests_PortletRequestWrapper_ApiRender_getServerName";
   public final static String               V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETSERVERPORT                          = "V2WrapperTests_PortletRequestWrapper_ApiRender_getServerPort";
   public final static String               V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETUSERPRINCIPAL                       = "V2WrapperTests_PortletRequestWrapper_ApiRender_getUserPrincipal";
   public final static String               V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETWINDOWID                            = "V2WrapperTests_PortletRequestWrapper_ApiRender_getWindowID";
   public final static String               V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETWINDOWSTATE                         = "V2WrapperTests_PortletRequestWrapper_ApiRender_getWindowState";
   public final static String               V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_ISPORTLETMODEALLOWED                   = "V2WrapperTests_PortletRequestWrapper_ApiRender_isPortletModeAllowed";
   public final static String               V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_ISREQUESTEDSESSIONIDVALID              = "V2WrapperTests_PortletRequestWrapper_ApiRender_isRequestedSessionIdValid";
   public final static String               V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_ISSECURE                               = "V2WrapperTests_PortletRequestWrapper_ApiRender_isSecure";
   public final static String               V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_ISUSERINROLE                           = "V2WrapperTests_PortletRequestWrapper_ApiRender_isUserInRole";
   public final static String               V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_ISWINDOWSTATEALLOWED                   = "V2WrapperTests_PortletRequestWrapper_ApiRender_isWindowStateAllowed";
   public final static String               V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_REMOVEATTRIBUTE                        = "V2WrapperTests_PortletRequestWrapper_ApiRender_removeAttribute";
   public final static String               V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_SETATTRIBUTE                           = "V2WrapperTests_PortletRequestWrapper_ApiRender_setAttribute";
   public final static String               V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETREQUEST                             = "V2WrapperTests_PortletRequestWrapper_ApiRender_getRequest";
   public final static String               V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_SETREQUEST                             = "V2WrapperTests_PortletRequestWrapper_ApiRender_setRequest";
   public final static String               V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETPRIVATEPARAMETERMAP                 = "V2WrapperTests_PortletRequestWrapper_ApiRender_getPrivateParameterMap";
   public final static String               V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETPUBLICPARAMETERMAP                  = "V2WrapperTests_PortletRequestWrapper_ApiRender_getPublicParameterMap";
   public final static String               V2WRAPPERTESTS_PORTLETRESPONSEWRAPPER_APIRENDER_ADDPROPERTYA                          = "V2WrapperTests_PortletResponseWrapper_ApiRender_addPropertyA";
   public final static String               V2WRAPPERTESTS_PORTLETRESPONSEWRAPPER_APIRENDER_ADDPROPERTYB                          = "V2WrapperTests_PortletResponseWrapper_ApiRender_addPropertyB";
   public final static String               V2WRAPPERTESTS_PORTLETRESPONSEWRAPPER_APIRENDER_ADDPROPERTYC                          = "V2WrapperTests_PortletResponseWrapper_ApiRender_addPropertyC";
   public final static String               V2WRAPPERTESTS_PORTLETRESPONSEWRAPPER_APIRENDER_ENCODEURL                             = "V2WrapperTests_PortletResponseWrapper_ApiRender_encodeURL";
   public final static String               V2WRAPPERTESTS_PORTLETRESPONSEWRAPPER_APIRENDER_GETNAMESPACE                          = "V2WrapperTests_PortletResponseWrapper_ApiRender_getNamespace";
   public final static String               V2WRAPPERTESTS_PORTLETRESPONSEWRAPPER_APIRENDER_SETPROPERTY                           = "V2WrapperTests_PortletResponseWrapper_ApiRender_setProperty";
   public final static String               V2WRAPPERTESTS_PORTLETRESPONSEWRAPPER_APIRENDER_GETRESPONSE                           = "V2WrapperTests_PortletResponseWrapper_ApiRender_getResponse";
   public final static String               V2WRAPPERTESTS_PORTLETRESPONSEWRAPPER_APIRENDER_SETRESPONSE                           = "V2WrapperTests_PortletResponseWrapper_ApiRender_setResponse";
   public final static String               V2WRAPPERTESTS_PORTLETRESPONSEWRAPPER_APIRENDER_CREATEELEMENT                         = "V2WrapperTests_PortletResponseWrapper_ApiRender_createElement";
   public final static String               V2WRAPPERTESTS_RENDERREQUESTWRAPPER_APIRENDER_GETREQUEST                              = "V2WrapperTests_RenderRequestWrapper_ApiRender_getRequest";
   public final static String               V2WRAPPERTESTS_RENDERREQUESTWRAPPER_APIRENDER_SETREQUEST                              = "V2WrapperTests_RenderRequestWrapper_ApiRender_setRequest";
   public final static String               V2WRAPPERTESTS_RENDERREQUESTWRAPPER_APIRENDER_GETETAG                                 = "V2WrapperTests_RenderRequestWrapper_ApiRender_getETag";
   public final static String               V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_FLUSHBUFFER                            = "V2WrapperTests_RenderResponseWrapper_ApiRender_flushBuffer";
   public final static String               V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_GETBUFFERSIZE                          = "V2WrapperTests_RenderResponseWrapper_ApiRender_getBufferSize";
   public final static String               V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_GETCHARACTERENCODING                   = "V2WrapperTests_RenderResponseWrapper_ApiRender_getCharacterEncoding";
   public final static String               V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_GETCONTENTTYPE                         = "V2WrapperTests_RenderResponseWrapper_ApiRender_getContentType";
   public final static String               V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_GETLOCALE                              = "V2WrapperTests_RenderResponseWrapper_ApiRender_getLocale";
   public final static String               V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_GETPORTLETOUTPUTSTREAM                 = "V2WrapperTests_RenderResponseWrapper_ApiRender_getPortletOutputStream";
   public final static String               V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_GETWRITER                              = "V2WrapperTests_RenderResponseWrapper_ApiRender_getWriter";
   public final static String               V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_ISCOMMITTED                            = "V2WrapperTests_RenderResponseWrapper_ApiRender_isCommitted";
   public final static String               V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_RESET                                  = "V2WrapperTests_RenderResponseWrapper_ApiRender_reset";
   public final static String               V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_RESETBUFFER                            = "V2WrapperTests_RenderResponseWrapper_ApiRender_resetBuffer";
   public final static String               V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_SETBUFFERSIZE                          = "V2WrapperTests_RenderResponseWrapper_ApiRender_setBufferSize";
   public final static String               V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_SETCONTENTTYPE                         = "V2WrapperTests_RenderResponseWrapper_ApiRender_setContentType";
   public final static String               V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_SETTITLE                               = "V2WrapperTests_RenderResponseWrapper_ApiRender_setTitle";
   public final static String               V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_GETCACHECONTROL                        = "V2WrapperTests_RenderResponseWrapper_ApiRender_getCacheControl";
   public final static String               V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_SETNEXTPOSSIBLEPORTLETMODES            = "V2WrapperTests_RenderResponseWrapper_ApiRender_setNextPossiblePortletModes";
   public final static String               V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_GETRESPONSE                            = "V2WrapperTests_RenderResponseWrapper_ApiRender_getResponse";
   public final static String               V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_SETRESPONSE                            = "V2WrapperTests_RenderResponseWrapper_ApiRender_setResponse";
   public final static String               V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_CREATEACTIONURL                        = "V2WrapperTests_RenderResponseWrapper_ApiRender_createActionURL";
   public final static String               V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_CREATERENDERURL                        = "V2WrapperTests_RenderResponseWrapper_ApiRender_createRenderURL";
   public final static String               V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_CREATERESOURCEURL                      = "V2WrapperTests_RenderResponseWrapper_ApiRender_createResourceURL";
   public final static String               V2WRAPPERTESTS_RESOURCEREQUESTWRAPPER_APIRESOURCE_GETPORTLETINPUTSTREAM               = "V2WrapperTests_ResourceRequestWrapper_ApiResource_getPortletInputStream";
   public final static String               V2WRAPPERTESTS_RESOURCEREQUESTWRAPPER_APIRESOURCE_GETREADER                           = "V2WrapperTests_ResourceRequestWrapper_ApiResource_getReader";
   public final static String               V2WRAPPERTESTS_RESOURCEREQUESTWRAPPER_APIRESOURCE_SETCHARACTERENCODING                = "V2WrapperTests_ResourceRequestWrapper_ApiResource_setCharacterEncoding";
   public final static String               V2WRAPPERTESTS_RESOURCEREQUESTWRAPPER_APIRESOURCE_GETREQUEST                          = "V2WrapperTests_ResourceRequestWrapper_ApiResource_getRequest";
   public final static String               V2WRAPPERTESTS_RESOURCEREQUESTWRAPPER_APIRESOURCE_SETREQUEST                          = "V2WrapperTests_ResourceRequestWrapper_ApiResource_setRequest";
   public final static String               V2WRAPPERTESTS_RESOURCEREQUESTWRAPPER_APIRESOURCE_GETCHARACTERENCODING                = "V2WrapperTests_ResourceRequestWrapper_ApiResource_getCharacterEncoding";
   public final static String               V2WRAPPERTESTS_RESOURCEREQUESTWRAPPER_APIRESOURCE_GETCONTENTLENGTH                    = "V2WrapperTests_ResourceRequestWrapper_ApiResource_getContentLength";
   public final static String               V2WRAPPERTESTS_RESOURCEREQUESTWRAPPER_APIRESOURCE_GETCONTENTTYPE                      = "V2WrapperTests_ResourceRequestWrapper_ApiResource_getContentType";
   public final static String               V2WRAPPERTESTS_RESOURCEREQUESTWRAPPER_APIRESOURCE_GETETAG                             = "V2WrapperTests_ResourceRequestWrapper_ApiResource_getETag";
   public final static String               V2WRAPPERTESTS_RESOURCEREQUESTWRAPPER_APIRESOURCE_GETMETHOD                           = "V2WrapperTests_ResourceRequestWrapper_ApiResource_getMethod";
   public final static String               V2WRAPPERTESTS_RESOURCEREQUESTWRAPPER_APIRESOURCE_GETRESOURCEID                       = "V2WrapperTests_ResourceRequestWrapper_ApiResource_getResourceID";
   public final static String               V2WRAPPERTESTS_RESOURCEREQUESTWRAPPER_APIRESOURCE_GETPRIVATERENDERPARAMETERMAP        = "V2WrapperTests_ResourceRequestWrapper_ApiResource_getPrivateRenderParameterMap";
   public final static String               V2WRAPPERTESTS_RESOURCEREQUESTWRAPPER_APIRESOURCE_GETCACHEABILITY                     = "V2WrapperTests_ResourceRequestWrapper_ApiResource_getCacheability";
   public final static String               V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_FLUSHBUFFER                        = "V2WrapperTests_ResourceResponseWrapper_ApiResource_flushBuffer";
   public final static String               V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_GETBUFFERSIZE                      = "V2WrapperTests_ResourceResponseWrapper_ApiResource_getBufferSize";
   public final static String               V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_GETCHARACTERENCODING               = "V2WrapperTests_ResourceResponseWrapper_ApiResource_getCharacterEncoding";
   public final static String               V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_GETCONTENTTYPE                     = "V2WrapperTests_ResourceResponseWrapper_ApiResource_getContentType";
   public final static String               V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_GETLOCALE                          = "V2WrapperTests_ResourceResponseWrapper_ApiResource_getLocale";
   public final static String               V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_GETPORTLETOUTPUTSTREAM             = "V2WrapperTests_ResourceResponseWrapper_ApiResource_getPortletOutputStream";
   public final static String               V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_GETWRITER                          = "V2WrapperTests_ResourceResponseWrapper_ApiResource_getWriter";
   public final static String               V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_ISCOMMITTED                        = "V2WrapperTests_ResourceResponseWrapper_ApiResource_isCommitted";
   public final static String               V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_RESET                              = "V2WrapperTests_ResourceResponseWrapper_ApiResource_reset";
   public final static String               V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_RESETBUFFER                        = "V2WrapperTests_ResourceResponseWrapper_ApiResource_resetBuffer";
   public final static String               V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_SETBUFFERSIZE                      = "V2WrapperTests_ResourceResponseWrapper_ApiResource_setBufferSize";
   public final static String               V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_SETCONTENTTYPE                     = "V2WrapperTests_ResourceResponseWrapper_ApiResource_setContentType";
   public final static String               V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_GETCACHECONTROL                    = "V2WrapperTests_ResourceResponseWrapper_ApiResource_getCacheControl";
   public final static String               V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_SETCHARACTERENCODING               = "V2WrapperTests_ResourceResponseWrapper_ApiResource_setCharacterEncoding";
   public final static String               V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_SETLOCALE                          = "V2WrapperTests_ResourceResponseWrapper_ApiResource_setLocale";
   public final static String               V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_SETCONTENTLENGTH                   = "V2WrapperTests_ResourceResponseWrapper_ApiResource_setContentLength";
   public final static String               V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_GETRESPONSE                        = "V2WrapperTests_ResourceResponseWrapper_ApiResource_getResponse";
   public final static String               V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_SETRESPONSE                        = "V2WrapperTests_ResourceResponseWrapper_ApiResource_setResponse";
   public final static String               V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_CREATEACTIONURL                    = "V2WrapperTests_ResourceResponseWrapper_ApiResource_createActionURL";
   public final static String               V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_CREATERENDERURL                    = "V2WrapperTests_ResourceResponseWrapper_ApiResource_createRenderURL";
   public final static String               V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_CREATERESOURCEURL                  = "V2WrapperTests_ResourceResponseWrapper_ApiResource_createResourceURL";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_FIELDUSER_INFO                                = "V2RequestTests_PortletRequest_ApiRender_fieldUSER_INFO";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_FIELDCCPP_PROFILE                             = "V2RequestTests_PortletRequest_ApiRender_fieldCCPP_PROFILE";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_FIELDBASIC_AUTH                               = "V2RequestTests_PortletRequest_ApiRender_fieldBASIC_AUTH";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_FIELDFORM_AUTH                                = "V2RequestTests_PortletRequest_ApiRender_fieldFORM_AUTH";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_FIELDCLIENT_CERT_AUTH                         = "V2RequestTests_PortletRequest_ApiRender_fieldCLIENT_CERT_AUTH";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_FIELDDIGEST_AUTH                              = "V2RequestTests_PortletRequest_ApiRender_fieldDIGEST_AUTH";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_FIELDACTION_PHASE                             = "V2RequestTests_PortletRequest_ApiRender_fieldACTION_PHASE";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_FIELDEVENT_PHASE                              = "V2RequestTests_PortletRequest_ApiRender_fieldEVENT_PHASE";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_FIELDRENDER_PHASE                             = "V2RequestTests_PortletRequest_ApiRender_fieldRENDER_PHASE";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_FIELDRESOURCE_PHASE                           = "V2RequestTests_PortletRequest_ApiRender_fieldRESOURCE_PHASE";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_FIELDLIFECYCLE_PHASE                          = "V2RequestTests_PortletRequest_ApiRender_fieldLIFECYCLE_PHASE";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_FIELDRENDER_PART                              = "V2RequestTests_PortletRequest_ApiRender_fieldRENDER_PART";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_FIELDRENDER_HEADERS                           = "V2RequestTests_PortletRequest_ApiRender_fieldRENDER_HEADERS";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_FIELDRENDER_MARKUP                            = "V2RequestTests_PortletRequest_ApiRender_fieldRENDER_MARKUP";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_FIELDACTION_SCOPE_ID                          = "V2RequestTests_PortletRequest_ApiRender_fieldACTION_SCOPE_ID";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_ISWINDOWSTATEALLOWED1                         = "V2RequestTests_PortletRequest_ApiRender_isWindowStateAllowed1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_ISWINDOWSTATEALLOWED2                         = "V2RequestTests_PortletRequest_ApiRender_isWindowStateAllowed2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_ISPORTLETMODEALLOWED1                         = "V2RequestTests_PortletRequest_ApiRender_isPortletModeAllowed1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_ISPORTLETMODEALLOWED2                         = "V2RequestTests_PortletRequest_ApiRender_isPortletModeAllowed2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPORTLETMODE                                = "V2RequestTests_PortletRequest_ApiRender_getPortletMode";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETWINDOWSTATE                                = "V2RequestTests_PortletRequest_ApiRender_getWindowState";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPREFERENCES                                = "V2RequestTests_PortletRequest_ApiRender_getPreferences";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPORTLETSESSIONA1                           = "V2RequestTests_PortletRequest_ApiRender_getPortletSessionA1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPORTLETSESSIONA2                           = "V2RequestTests_PortletRequest_ApiRender_getPortletSessionA2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPORTLETSESSIONB1                           = "V2RequestTests_PortletRequest_ApiRender_getPortletSessionB1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPORTLETSESSIONB2                           = "V2RequestTests_PortletRequest_ApiRender_getPortletSessionB2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPORTLETSESSIONB3                           = "V2RequestTests_PortletRequest_ApiRender_getPortletSessionB3";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPORTLETSESSIONB4                           = "V2RequestTests_PortletRequest_ApiRender_getPortletSessionB4";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPROPERTY1                                  = "V2RequestTests_PortletRequest_ApiRender_getProperty1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPROPERTY2                                  = "V2RequestTests_PortletRequest_ApiRender_getProperty2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPROPERTY3                                  = "V2RequestTests_PortletRequest_ApiRender_getProperty3";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPROPERTIES1                                = "V2RequestTests_PortletRequest_ApiRender_getProperties1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPROPERTIES2                                = "V2RequestTests_PortletRequest_ApiRender_getProperties2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPROPERTIES3                                = "V2RequestTests_PortletRequest_ApiRender_getProperties3";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPROPERTYNAMES1                             = "V2RequestTests_PortletRequest_ApiRender_getPropertyNames1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPROPERTYNAMES2                             = "V2RequestTests_PortletRequest_ApiRender_getPropertyNames2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPORTALCONTEXT                              = "V2RequestTests_PortletRequest_ApiRender_getPortalContext";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETAUTHTYPE1                                  = "V2RequestTests_PortletRequest_ApiRender_getAuthType1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETAUTHTYPE2                                  = "V2RequestTests_PortletRequest_ApiRender_getAuthType2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETCONTEXTPATH1                               = "V2RequestTests_PortletRequest_ApiRender_getContextPath1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETCONTEXTPATH2                               = "V2RequestTests_PortletRequest_ApiRender_getContextPath2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETCONTEXTPATH3                               = "V2RequestTests_PortletRequest_ApiRender_getContextPath3";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETREMOTEUSER1                                = "V2RequestTests_PortletRequest_ApiRender_getRemoteUser1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETREMOTEUSER2                                = "V2RequestTests_PortletRequest_ApiRender_getRemoteUser2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETUSERPRINCIPAL1                             = "V2RequestTests_PortletRequest_ApiRender_getUserPrincipal1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETUSERPRINCIPAL2                             = "V2RequestTests_PortletRequest_ApiRender_getUserPrincipal2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_ISUSERINROLE1                                 = "V2RequestTests_PortletRequest_ApiRender_isUserInRole1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_ISUSERINROLE2                                 = "V2RequestTests_PortletRequest_ApiRender_isUserInRole2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_ISUSERINROLE3                                 = "V2RequestTests_PortletRequest_ApiRender_isUserInRole3";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETATTRIBUTE1                                 = "V2RequestTests_PortletRequest_ApiRender_getAttribute1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETATTRIBUTE2                                 = "V2RequestTests_PortletRequest_ApiRender_getAttribute2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETATTRIBUTE3                                 = "V2RequestTests_PortletRequest_ApiRender_getAttribute3";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETATTRIBUTENAMES1                            = "V2RequestTests_PortletRequest_ApiRender_getAttributeNames1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETATTRIBUTENAMES2                            = "V2RequestTests_PortletRequest_ApiRender_getAttributeNames2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPARAMETER1                                 = "V2RequestTests_PortletRequest_ApiRender_getParameter1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPARAMETER2                                 = "V2RequestTests_PortletRequest_ApiRender_getParameter2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPARAMETER3                                 = "V2RequestTests_PortletRequest_ApiRender_getParameter3";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPARAMETER4                                 = "V2RequestTests_PortletRequest_ApiRender_getParameter4";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPARAMETER5                                 = "V2RequestTests_PortletRequest_ApiRender_getParameter5";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPARAMETERNAMES1                            = "V2RequestTests_PortletRequest_ApiRender_getParameterNames1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPARAMETERNAMES2                            = "V2RequestTests_PortletRequest_ApiRender_getParameterNames2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPARAMETERVALUES1                           = "V2RequestTests_PortletRequest_ApiRender_getParameterValues1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPARAMETERVALUES2                           = "V2RequestTests_PortletRequest_ApiRender_getParameterValues2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPARAMETERVALUES3                           = "V2RequestTests_PortletRequest_ApiRender_getParameterValues3";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPARAMETERVALUES4                           = "V2RequestTests_PortletRequest_ApiRender_getParameterValues4";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPARAMETERMAP1                              = "V2RequestTests_PortletRequest_ApiRender_getParameterMap1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPARAMETERMAP2                              = "V2RequestTests_PortletRequest_ApiRender_getParameterMap2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPARAMETERMAP3                              = "V2RequestTests_PortletRequest_ApiRender_getParameterMap3";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_ISSECURE1                                     = "V2RequestTests_PortletRequest_ApiRender_isSecure1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_ISSECURE2                                     = "V2RequestTests_PortletRequest_ApiRender_isSecure2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_SETATTRIBUTE1                                 = "V2RequestTests_PortletRequest_ApiRender_setAttribute1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_SETATTRIBUTE2                                 = "V2RequestTests_PortletRequest_ApiRender_setAttribute2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_SETATTRIBUTE3                                 = "V2RequestTests_PortletRequest_ApiRender_setAttribute3";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_REMOVEATTRIBUTE1                              = "V2RequestTests_PortletRequest_ApiRender_removeAttribute1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_REMOVEATTRIBUTE2                              = "V2RequestTests_PortletRequest_ApiRender_removeAttribute2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETREQUESTEDSESSIONID1                        = "V2RequestTests_PortletRequest_ApiRender_getRequestedSessionId1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETREQUESTEDSESSIONID2                        = "V2RequestTests_PortletRequest_ApiRender_getRequestedSessionId2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_ISREQUESTEDSESSIONIDVALID1                    = "V2RequestTests_PortletRequest_ApiRender_isRequestedSessionIdValid1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_ISREQUESTEDSESSIONIDVALID2                    = "V2RequestTests_PortletRequest_ApiRender_isRequestedSessionIdValid2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETRESPONSECONTENTTYPE1                       = "V2RequestTests_PortletRequest_ApiRender_getResponseContentType1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETRESPONSECONTENTTYPE2                       = "V2RequestTests_PortletRequest_ApiRender_getResponseContentType2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETRESPONSECONTENTTYPES1                      = "V2RequestTests_PortletRequest_ApiRender_getResponseContentTypes1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETRESPONSECONTENTTYPES2                      = "V2RequestTests_PortletRequest_ApiRender_getResponseContentTypes2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETLOCALE                                     = "V2RequestTests_PortletRequest_ApiRender_getLocale";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETLOCALES                                    = "V2RequestTests_PortletRequest_ApiRender_getLocales";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETSCHEME                                     = "V2RequestTests_PortletRequest_ApiRender_getScheme";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETSERVERNAME                                 = "V2RequestTests_PortletRequest_ApiRender_getServerName";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETSERVERPORT                                 = "V2RequestTests_PortletRequest_ApiRender_getServerPort";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETWINDOWID                                   = "V2RequestTests_PortletRequest_ApiRender_getWindowID";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETCOOKIES1                                   = "V2RequestTests_PortletRequest_ApiRender_getCookies1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETCOOKIES2                                   = "V2RequestTests_PortletRequest_ApiRender_getCookies2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPRIVATEPARAMETERMAP1                       = "V2RequestTests_PortletRequest_ApiRender_getPrivateParameterMap1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPRIVATEPARAMETERMAP2                       = "V2RequestTests_PortletRequest_ApiRender_getPrivateParameterMap2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPRIVATEPARAMETERMAP3                       = "V2RequestTests_PortletRequest_ApiRender_getPrivateParameterMap3";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPUBLICPARAMETERMAP1                        = "V2RequestTests_PortletRequest_ApiRender_getPublicParameterMap1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPUBLICPARAMETERMAP2                        = "V2RequestTests_PortletRequest_ApiRender_getPublicParameterMap2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPUBLICPARAMETERMAP3                        = "V2RequestTests_PortletRequest_ApiRender_getPublicParameterMap3";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_EXISTS                                        = "V2RequestTests_PortletRequest_ApiRender_exists";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_FIELDUSER_INFO                                = "V2RequestTests_PortletRequest_ApiAction_fieldUSER_INFO";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_FIELDCCPP_PROFILE                             = "V2RequestTests_PortletRequest_ApiAction_fieldCCPP_PROFILE";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_FIELDBASIC_AUTH                               = "V2RequestTests_PortletRequest_ApiAction_fieldBASIC_AUTH";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_FIELDFORM_AUTH                                = "V2RequestTests_PortletRequest_ApiAction_fieldFORM_AUTH";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_FIELDCLIENT_CERT_AUTH                         = "V2RequestTests_PortletRequest_ApiAction_fieldCLIENT_CERT_AUTH";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_FIELDDIGEST_AUTH                              = "V2RequestTests_PortletRequest_ApiAction_fieldDIGEST_AUTH";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_FIELDACTION_PHASE                             = "V2RequestTests_PortletRequest_ApiAction_fieldACTION_PHASE";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_FIELDEVENT_PHASE                              = "V2RequestTests_PortletRequest_ApiAction_fieldEVENT_PHASE";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_FIELDRENDER_PHASE                             = "V2RequestTests_PortletRequest_ApiAction_fieldRENDER_PHASE";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_FIELDRESOURCE_PHASE                           = "V2RequestTests_PortletRequest_ApiAction_fieldRESOURCE_PHASE";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_FIELDLIFECYCLE_PHASE                          = "V2RequestTests_PortletRequest_ApiAction_fieldLIFECYCLE_PHASE";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_FIELDRENDER_PART                              = "V2RequestTests_PortletRequest_ApiAction_fieldRENDER_PART";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_FIELDRENDER_HEADERS                           = "V2RequestTests_PortletRequest_ApiAction_fieldRENDER_HEADERS";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_FIELDRENDER_MARKUP                            = "V2RequestTests_PortletRequest_ApiAction_fieldRENDER_MARKUP";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_FIELDACTION_SCOPE_ID                          = "V2RequestTests_PortletRequest_ApiAction_fieldACTION_SCOPE_ID";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_ISWINDOWSTATEALLOWED1                         = "V2RequestTests_PortletRequest_ApiAction_isWindowStateAllowed1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_ISWINDOWSTATEALLOWED2                         = "V2RequestTests_PortletRequest_ApiAction_isWindowStateAllowed2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_ISPORTLETMODEALLOWED1                         = "V2RequestTests_PortletRequest_ApiAction_isPortletModeAllowed1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_ISPORTLETMODEALLOWED2                         = "V2RequestTests_PortletRequest_ApiAction_isPortletModeAllowed2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPORTLETMODE                                = "V2RequestTests_PortletRequest_ApiAction_getPortletMode";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETWINDOWSTATE                                = "V2RequestTests_PortletRequest_ApiAction_getWindowState";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPREFERENCES                                = "V2RequestTests_PortletRequest_ApiAction_getPreferences";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPORTLETSESSIONA1                           = "V2RequestTests_PortletRequest_ApiAction_getPortletSessionA1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPORTLETSESSIONA2                           = "V2RequestTests_PortletRequest_ApiAction_getPortletSessionA2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPORTLETSESSIONB1                           = "V2RequestTests_PortletRequest_ApiAction_getPortletSessionB1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPORTLETSESSIONB2                           = "V2RequestTests_PortletRequest_ApiAction_getPortletSessionB2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPORTLETSESSIONB3                           = "V2RequestTests_PortletRequest_ApiAction_getPortletSessionB3";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPORTLETSESSIONB4                           = "V2RequestTests_PortletRequest_ApiAction_getPortletSessionB4";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPROPERTY1                                  = "V2RequestTests_PortletRequest_ApiAction_getProperty1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPROPERTY2                                  = "V2RequestTests_PortletRequest_ApiAction_getProperty2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPROPERTY3                                  = "V2RequestTests_PortletRequest_ApiAction_getProperty3";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPROPERTIES1                                = "V2RequestTests_PortletRequest_ApiAction_getProperties1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPROPERTIES2                                = "V2RequestTests_PortletRequest_ApiAction_getProperties2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPROPERTIES3                                = "V2RequestTests_PortletRequest_ApiAction_getProperties3";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPROPERTYNAMES1                             = "V2RequestTests_PortletRequest_ApiAction_getPropertyNames1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPROPERTYNAMES2                             = "V2RequestTests_PortletRequest_ApiAction_getPropertyNames2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPORTALCONTEXT                              = "V2RequestTests_PortletRequest_ApiAction_getPortalContext";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETAUTHTYPE1                                  = "V2RequestTests_PortletRequest_ApiAction_getAuthType1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETAUTHTYPE2                                  = "V2RequestTests_PortletRequest_ApiAction_getAuthType2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETCONTEXTPATH1                               = "V2RequestTests_PortletRequest_ApiAction_getContextPath1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETCONTEXTPATH2                               = "V2RequestTests_PortletRequest_ApiAction_getContextPath2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETCONTEXTPATH3                               = "V2RequestTests_PortletRequest_ApiAction_getContextPath3";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETREMOTEUSER1                                = "V2RequestTests_PortletRequest_ApiAction_getRemoteUser1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETREMOTEUSER2                                = "V2RequestTests_PortletRequest_ApiAction_getRemoteUser2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETUSERPRINCIPAL1                             = "V2RequestTests_PortletRequest_ApiAction_getUserPrincipal1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETUSERPRINCIPAL2                             = "V2RequestTests_PortletRequest_ApiAction_getUserPrincipal2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_ISUSERINROLE1                                 = "V2RequestTests_PortletRequest_ApiAction_isUserInRole1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_ISUSERINROLE2                                 = "V2RequestTests_PortletRequest_ApiAction_isUserInRole2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_ISUSERINROLE3                                 = "V2RequestTests_PortletRequest_ApiAction_isUserInRole3";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETATTRIBUTE1                                 = "V2RequestTests_PortletRequest_ApiAction_getAttribute1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETATTRIBUTE2                                 = "V2RequestTests_PortletRequest_ApiAction_getAttribute2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETATTRIBUTE3                                 = "V2RequestTests_PortletRequest_ApiAction_getAttribute3";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETATTRIBUTENAMES1                            = "V2RequestTests_PortletRequest_ApiAction_getAttributeNames1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETATTRIBUTENAMES2                            = "V2RequestTests_PortletRequest_ApiAction_getAttributeNames2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPARAMETER1                                 = "V2RequestTests_PortletRequest_ApiAction_getParameter1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPARAMETER2                                 = "V2RequestTests_PortletRequest_ApiAction_getParameter2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPARAMETER3                                 = "V2RequestTests_PortletRequest_ApiAction_getParameter3";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPARAMETER4                                 = "V2RequestTests_PortletRequest_ApiAction_getParameter4";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPARAMETER5                                 = "V2RequestTests_PortletRequest_ApiAction_getParameter5";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPARAMETERNAMES1                            = "V2RequestTests_PortletRequest_ApiAction_getParameterNames1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPARAMETERNAMES2                            = "V2RequestTests_PortletRequest_ApiAction_getParameterNames2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPARAMETERVALUES1                           = "V2RequestTests_PortletRequest_ApiAction_getParameterValues1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPARAMETERVALUES2                           = "V2RequestTests_PortletRequest_ApiAction_getParameterValues2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPARAMETERVALUES3                           = "V2RequestTests_PortletRequest_ApiAction_getParameterValues3";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPARAMETERVALUES4                           = "V2RequestTests_PortletRequest_ApiAction_getParameterValues4";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPARAMETERMAP1                              = "V2RequestTests_PortletRequest_ApiAction_getParameterMap1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPARAMETERMAP2                              = "V2RequestTests_PortletRequest_ApiAction_getParameterMap2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPARAMETERMAP3                              = "V2RequestTests_PortletRequest_ApiAction_getParameterMap3";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_ISSECURE1                                     = "V2RequestTests_PortletRequest_ApiAction_isSecure1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_ISSECURE2                                     = "V2RequestTests_PortletRequest_ApiAction_isSecure2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_SETATTRIBUTE1                                 = "V2RequestTests_PortletRequest_ApiAction_setAttribute1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_SETATTRIBUTE2                                 = "V2RequestTests_PortletRequest_ApiAction_setAttribute2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_SETATTRIBUTE3                                 = "V2RequestTests_PortletRequest_ApiAction_setAttribute3";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_REMOVEATTRIBUTE1                              = "V2RequestTests_PortletRequest_ApiAction_removeAttribute1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_REMOVEATTRIBUTE2                              = "V2RequestTests_PortletRequest_ApiAction_removeAttribute2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETREQUESTEDSESSIONID1                        = "V2RequestTests_PortletRequest_ApiAction_getRequestedSessionId1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETREQUESTEDSESSIONID2                        = "V2RequestTests_PortletRequest_ApiAction_getRequestedSessionId2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_ISREQUESTEDSESSIONIDVALID1                    = "V2RequestTests_PortletRequest_ApiAction_isRequestedSessionIdValid1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_ISREQUESTEDSESSIONIDVALID2                    = "V2RequestTests_PortletRequest_ApiAction_isRequestedSessionIdValid2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETRESPONSECONTENTTYPE1                       = "V2RequestTests_PortletRequest_ApiAction_getResponseContentType1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETRESPONSECONTENTTYPE2                       = "V2RequestTests_PortletRequest_ApiAction_getResponseContentType2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETRESPONSECONTENTTYPES1                      = "V2RequestTests_PortletRequest_ApiAction_getResponseContentTypes1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETRESPONSECONTENTTYPES2                      = "V2RequestTests_PortletRequest_ApiAction_getResponseContentTypes2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETLOCALE                                     = "V2RequestTests_PortletRequest_ApiAction_getLocale";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETLOCALES                                    = "V2RequestTests_PortletRequest_ApiAction_getLocales";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETSCHEME                                     = "V2RequestTests_PortletRequest_ApiAction_getScheme";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETSERVERNAME                                 = "V2RequestTests_PortletRequest_ApiAction_getServerName";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETSERVERPORT                                 = "V2RequestTests_PortletRequest_ApiAction_getServerPort";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETWINDOWID                                   = "V2RequestTests_PortletRequest_ApiAction_getWindowID";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETCOOKIES1                                   = "V2RequestTests_PortletRequest_ApiAction_getCookies1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETCOOKIES2                                   = "V2RequestTests_PortletRequest_ApiAction_getCookies2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPRIVATEPARAMETERMAP1                       = "V2RequestTests_PortletRequest_ApiAction_getPrivateParameterMap1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPRIVATEPARAMETERMAP2                       = "V2RequestTests_PortletRequest_ApiAction_getPrivateParameterMap2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPRIVATEPARAMETERMAP3                       = "V2RequestTests_PortletRequest_ApiAction_getPrivateParameterMap3";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPUBLICPARAMETERMAP1                        = "V2RequestTests_PortletRequest_ApiAction_getPublicParameterMap1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPUBLICPARAMETERMAP2                        = "V2RequestTests_PortletRequest_ApiAction_getPublicParameterMap2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPUBLICPARAMETERMAP3                        = "V2RequestTests_PortletRequest_ApiAction_getPublicParameterMap3";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIACTION_EXISTS                                        = "V2RequestTests_PortletRequest_ApiAction_exists";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_FIELDUSER_INFO                                 = "V2RequestTests_PortletRequest_ApiEvent_fieldUSER_INFO";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_FIELDCCPP_PROFILE                              = "V2RequestTests_PortletRequest_ApiEvent_fieldCCPP_PROFILE";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_FIELDBASIC_AUTH                                = "V2RequestTests_PortletRequest_ApiEvent_fieldBASIC_AUTH";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_FIELDFORM_AUTH                                 = "V2RequestTests_PortletRequest_ApiEvent_fieldFORM_AUTH";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_FIELDCLIENT_CERT_AUTH                          = "V2RequestTests_PortletRequest_ApiEvent_fieldCLIENT_CERT_AUTH";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_FIELDDIGEST_AUTH                               = "V2RequestTests_PortletRequest_ApiEvent_fieldDIGEST_AUTH";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_FIELDACTION_PHASE                              = "V2RequestTests_PortletRequest_ApiEvent_fieldACTION_PHASE";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_FIELDEVENT_PHASE                               = "V2RequestTests_PortletRequest_ApiEvent_fieldEVENT_PHASE";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_FIELDRENDER_PHASE                              = "V2RequestTests_PortletRequest_ApiEvent_fieldRENDER_PHASE";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_FIELDRESOURCE_PHASE                            = "V2RequestTests_PortletRequest_ApiEvent_fieldRESOURCE_PHASE";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_FIELDLIFECYCLE_PHASE                           = "V2RequestTests_PortletRequest_ApiEvent_fieldLIFECYCLE_PHASE";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_FIELDRENDER_PART                               = "V2RequestTests_PortletRequest_ApiEvent_fieldRENDER_PART";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_FIELDRENDER_HEADERS                            = "V2RequestTests_PortletRequest_ApiEvent_fieldRENDER_HEADERS";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_FIELDRENDER_MARKUP                             = "V2RequestTests_PortletRequest_ApiEvent_fieldRENDER_MARKUP";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_FIELDACTION_SCOPE_ID                           = "V2RequestTests_PortletRequest_ApiEvent_fieldACTION_SCOPE_ID";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_ISWINDOWSTATEALLOWED1                          = "V2RequestTests_PortletRequest_ApiEvent_isWindowStateAllowed1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_ISWINDOWSTATEALLOWED2                          = "V2RequestTests_PortletRequest_ApiEvent_isWindowStateAllowed2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_ISPORTLETMODEALLOWED1                          = "V2RequestTests_PortletRequest_ApiEvent_isPortletModeAllowed1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_ISPORTLETMODEALLOWED2                          = "V2RequestTests_PortletRequest_ApiEvent_isPortletModeAllowed2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPORTLETMODE                                 = "V2RequestTests_PortletRequest_ApiEvent_getPortletMode";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETWINDOWSTATE                                 = "V2RequestTests_PortletRequest_ApiEvent_getWindowState";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPREFERENCES                                 = "V2RequestTests_PortletRequest_ApiEvent_getPreferences";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPORTLETSESSIONA1                            = "V2RequestTests_PortletRequest_ApiEvent_getPortletSessionA1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPORTLETSESSIONA2                            = "V2RequestTests_PortletRequest_ApiEvent_getPortletSessionA2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPORTLETSESSIONB1                            = "V2RequestTests_PortletRequest_ApiEvent_getPortletSessionB1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPORTLETSESSIONB2                            = "V2RequestTests_PortletRequest_ApiEvent_getPortletSessionB2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPORTLETSESSIONB3                            = "V2RequestTests_PortletRequest_ApiEvent_getPortletSessionB3";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPORTLETSESSIONB4                            = "V2RequestTests_PortletRequest_ApiEvent_getPortletSessionB4";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPROPERTY1                                   = "V2RequestTests_PortletRequest_ApiEvent_getProperty1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPROPERTY2                                   = "V2RequestTests_PortletRequest_ApiEvent_getProperty2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPROPERTY3                                   = "V2RequestTests_PortletRequest_ApiEvent_getProperty3";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPROPERTIES1                                 = "V2RequestTests_PortletRequest_ApiEvent_getProperties1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPROPERTIES2                                 = "V2RequestTests_PortletRequest_ApiEvent_getProperties2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPROPERTIES3                                 = "V2RequestTests_PortletRequest_ApiEvent_getProperties3";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPROPERTYNAMES1                              = "V2RequestTests_PortletRequest_ApiEvent_getPropertyNames1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPROPERTYNAMES2                              = "V2RequestTests_PortletRequest_ApiEvent_getPropertyNames2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPORTALCONTEXT                               = "V2RequestTests_PortletRequest_ApiEvent_getPortalContext";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETAUTHTYPE1                                   = "V2RequestTests_PortletRequest_ApiEvent_getAuthType1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETAUTHTYPE2                                   = "V2RequestTests_PortletRequest_ApiEvent_getAuthType2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETCONTEXTPATH1                                = "V2RequestTests_PortletRequest_ApiEvent_getContextPath1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETCONTEXTPATH2                                = "V2RequestTests_PortletRequest_ApiEvent_getContextPath2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETCONTEXTPATH3                                = "V2RequestTests_PortletRequest_ApiEvent_getContextPath3";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETREMOTEUSER1                                 = "V2RequestTests_PortletRequest_ApiEvent_getRemoteUser1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETREMOTEUSER2                                 = "V2RequestTests_PortletRequest_ApiEvent_getRemoteUser2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETUSERPRINCIPAL1                              = "V2RequestTests_PortletRequest_ApiEvent_getUserPrincipal1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETUSERPRINCIPAL2                              = "V2RequestTests_PortletRequest_ApiEvent_getUserPrincipal2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_ISUSERINROLE1                                  = "V2RequestTests_PortletRequest_ApiEvent_isUserInRole1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_ISUSERINROLE2                                  = "V2RequestTests_PortletRequest_ApiEvent_isUserInRole2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_ISUSERINROLE3                                  = "V2RequestTests_PortletRequest_ApiEvent_isUserInRole3";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETATTRIBUTE1                                  = "V2RequestTests_PortletRequest_ApiEvent_getAttribute1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETATTRIBUTE2                                  = "V2RequestTests_PortletRequest_ApiEvent_getAttribute2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETATTRIBUTE3                                  = "V2RequestTests_PortletRequest_ApiEvent_getAttribute3";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETATTRIBUTENAMES1                             = "V2RequestTests_PortletRequest_ApiEvent_getAttributeNames1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETATTRIBUTENAMES2                             = "V2RequestTests_PortletRequest_ApiEvent_getAttributeNames2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPARAMETER1                                  = "V2RequestTests_PortletRequest_ApiEvent_getParameter1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPARAMETER2                                  = "V2RequestTests_PortletRequest_ApiEvent_getParameter2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPARAMETER3                                  = "V2RequestTests_PortletRequest_ApiEvent_getParameter3";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPARAMETER4                                  = "V2RequestTests_PortletRequest_ApiEvent_getParameter4";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPARAMETER5                                  = "V2RequestTests_PortletRequest_ApiEvent_getParameter5";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPARAMETERNAMES1                             = "V2RequestTests_PortletRequest_ApiEvent_getParameterNames1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPARAMETERNAMES2                             = "V2RequestTests_PortletRequest_ApiEvent_getParameterNames2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPARAMETERVALUES1                            = "V2RequestTests_PortletRequest_ApiEvent_getParameterValues1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPARAMETERVALUES2                            = "V2RequestTests_PortletRequest_ApiEvent_getParameterValues2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPARAMETERVALUES3                            = "V2RequestTests_PortletRequest_ApiEvent_getParameterValues3";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPARAMETERVALUES4                            = "V2RequestTests_PortletRequest_ApiEvent_getParameterValues4";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPARAMETERMAP1                               = "V2RequestTests_PortletRequest_ApiEvent_getParameterMap1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPARAMETERMAP2                               = "V2RequestTests_PortletRequest_ApiEvent_getParameterMap2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPARAMETERMAP3                               = "V2RequestTests_PortletRequest_ApiEvent_getParameterMap3";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_ISSECURE1                                      = "V2RequestTests_PortletRequest_ApiEvent_isSecure1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_ISSECURE2                                      = "V2RequestTests_PortletRequest_ApiEvent_isSecure2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_SETATTRIBUTE1                                  = "V2RequestTests_PortletRequest_ApiEvent_setAttribute1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_SETATTRIBUTE2                                  = "V2RequestTests_PortletRequest_ApiEvent_setAttribute2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_SETATTRIBUTE3                                  = "V2RequestTests_PortletRequest_ApiEvent_setAttribute3";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_REMOVEATTRIBUTE1                               = "V2RequestTests_PortletRequest_ApiEvent_removeAttribute1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_REMOVEATTRIBUTE2                               = "V2RequestTests_PortletRequest_ApiEvent_removeAttribute2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETREQUESTEDSESSIONID1                         = "V2RequestTests_PortletRequest_ApiEvent_getRequestedSessionId1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETREQUESTEDSESSIONID2                         = "V2RequestTests_PortletRequest_ApiEvent_getRequestedSessionId2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_ISREQUESTEDSESSIONIDVALID1                     = "V2RequestTests_PortletRequest_ApiEvent_isRequestedSessionIdValid1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_ISREQUESTEDSESSIONIDVALID2                     = "V2RequestTests_PortletRequest_ApiEvent_isRequestedSessionIdValid2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETRESPONSECONTENTTYPE1                        = "V2RequestTests_PortletRequest_ApiEvent_getResponseContentType1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETRESPONSECONTENTTYPE2                        = "V2RequestTests_PortletRequest_ApiEvent_getResponseContentType2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETRESPONSECONTENTTYPES1                       = "V2RequestTests_PortletRequest_ApiEvent_getResponseContentTypes1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETRESPONSECONTENTTYPES2                       = "V2RequestTests_PortletRequest_ApiEvent_getResponseContentTypes2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETLOCALE                                      = "V2RequestTests_PortletRequest_ApiEvent_getLocale";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETLOCALES                                     = "V2RequestTests_PortletRequest_ApiEvent_getLocales";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETSCHEME                                      = "V2RequestTests_PortletRequest_ApiEvent_getScheme";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETSERVERNAME                                  = "V2RequestTests_PortletRequest_ApiEvent_getServerName";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETSERVERPORT                                  = "V2RequestTests_PortletRequest_ApiEvent_getServerPort";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETWINDOWID                                    = "V2RequestTests_PortletRequest_ApiEvent_getWindowID";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETCOOKIES1                                    = "V2RequestTests_PortletRequest_ApiEvent_getCookies1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETCOOKIES2                                    = "V2RequestTests_PortletRequest_ApiEvent_getCookies2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPRIVATEPARAMETERMAP1                        = "V2RequestTests_PortletRequest_ApiEvent_getPrivateParameterMap1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPRIVATEPARAMETERMAP2                        = "V2RequestTests_PortletRequest_ApiEvent_getPrivateParameterMap2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPRIVATEPARAMETERMAP3                        = "V2RequestTests_PortletRequest_ApiEvent_getPrivateParameterMap3";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPUBLICPARAMETERMAP1                         = "V2RequestTests_PortletRequest_ApiEvent_getPublicParameterMap1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPUBLICPARAMETERMAP2                         = "V2RequestTests_PortletRequest_ApiEvent_getPublicParameterMap2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPUBLICPARAMETERMAP3                         = "V2RequestTests_PortletRequest_ApiEvent_getPublicParameterMap3";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_EXISTS                                         = "V2RequestTests_PortletRequest_ApiEvent_exists";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_FIELDUSER_INFO                              = "V2RequestTests_PortletRequest_ApiResource_fieldUSER_INFO";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_FIELDCCPP_PROFILE                           = "V2RequestTests_PortletRequest_ApiResource_fieldCCPP_PROFILE";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_FIELDBASIC_AUTH                             = "V2RequestTests_PortletRequest_ApiResource_fieldBASIC_AUTH";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_FIELDFORM_AUTH                              = "V2RequestTests_PortletRequest_ApiResource_fieldFORM_AUTH";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_FIELDCLIENT_CERT_AUTH                       = "V2RequestTests_PortletRequest_ApiResource_fieldCLIENT_CERT_AUTH";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_FIELDDIGEST_AUTH                            = "V2RequestTests_PortletRequest_ApiResource_fieldDIGEST_AUTH";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_FIELDACTION_PHASE                           = "V2RequestTests_PortletRequest_ApiResource_fieldACTION_PHASE";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_FIELDEVENT_PHASE                            = "V2RequestTests_PortletRequest_ApiResource_fieldEVENT_PHASE";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_FIELDRENDER_PHASE                           = "V2RequestTests_PortletRequest_ApiResource_fieldRENDER_PHASE";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_FIELDRESOURCE_PHASE                         = "V2RequestTests_PortletRequest_ApiResource_fieldRESOURCE_PHASE";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_FIELDLIFECYCLE_PHASE                        = "V2RequestTests_PortletRequest_ApiResource_fieldLIFECYCLE_PHASE";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_FIELDRENDER_PART                            = "V2RequestTests_PortletRequest_ApiResource_fieldRENDER_PART";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_FIELDRENDER_HEADERS                         = "V2RequestTests_PortletRequest_ApiResource_fieldRENDER_HEADERS";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_FIELDRENDER_MARKUP                          = "V2RequestTests_PortletRequest_ApiResource_fieldRENDER_MARKUP";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_FIELDACTION_SCOPE_ID                        = "V2RequestTests_PortletRequest_ApiResource_fieldACTION_SCOPE_ID";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_ISWINDOWSTATEALLOWED1                       = "V2RequestTests_PortletRequest_ApiResource_isWindowStateAllowed1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_ISWINDOWSTATEALLOWED2                       = "V2RequestTests_PortletRequest_ApiResource_isWindowStateAllowed2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_ISPORTLETMODEALLOWED1                       = "V2RequestTests_PortletRequest_ApiResource_isPortletModeAllowed1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_ISPORTLETMODEALLOWED2                       = "V2RequestTests_PortletRequest_ApiResource_isPortletModeAllowed2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPORTLETMODE                              = "V2RequestTests_PortletRequest_ApiResource_getPortletMode";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETWINDOWSTATE                              = "V2RequestTests_PortletRequest_ApiResource_getWindowState";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPREFERENCES                              = "V2RequestTests_PortletRequest_ApiResource_getPreferences";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPORTLETSESSIONA1                         = "V2RequestTests_PortletRequest_ApiResource_getPortletSessionA1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPORTLETSESSIONA2                         = "V2RequestTests_PortletRequest_ApiResource_getPortletSessionA2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPORTLETSESSIONB1                         = "V2RequestTests_PortletRequest_ApiResource_getPortletSessionB1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPORTLETSESSIONB2                         = "V2RequestTests_PortletRequest_ApiResource_getPortletSessionB2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPORTLETSESSIONB3                         = "V2RequestTests_PortletRequest_ApiResource_getPortletSessionB3";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPORTLETSESSIONB4                         = "V2RequestTests_PortletRequest_ApiResource_getPortletSessionB4";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPROPERTY1                                = "V2RequestTests_PortletRequest_ApiResource_getProperty1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPROPERTY2                                = "V2RequestTests_PortletRequest_ApiResource_getProperty2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPROPERTY3                                = "V2RequestTests_PortletRequest_ApiResource_getProperty3";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPROPERTIES1                              = "V2RequestTests_PortletRequest_ApiResource_getProperties1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPROPERTIES2                              = "V2RequestTests_PortletRequest_ApiResource_getProperties2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPROPERTIES3                              = "V2RequestTests_PortletRequest_ApiResource_getProperties3";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPROPERTYNAMES1                           = "V2RequestTests_PortletRequest_ApiResource_getPropertyNames1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPROPERTYNAMES2                           = "V2RequestTests_PortletRequest_ApiResource_getPropertyNames2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPORTALCONTEXT                            = "V2RequestTests_PortletRequest_ApiResource_getPortalContext";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETAUTHTYPE1                                = "V2RequestTests_PortletRequest_ApiResource_getAuthType1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETAUTHTYPE2                                = "V2RequestTests_PortletRequest_ApiResource_getAuthType2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETCONTEXTPATH1                             = "V2RequestTests_PortletRequest_ApiResource_getContextPath1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETCONTEXTPATH2                             = "V2RequestTests_PortletRequest_ApiResource_getContextPath2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETCONTEXTPATH3                             = "V2RequestTests_PortletRequest_ApiResource_getContextPath3";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETREMOTEUSER1                              = "V2RequestTests_PortletRequest_ApiResource_getRemoteUser1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETREMOTEUSER2                              = "V2RequestTests_PortletRequest_ApiResource_getRemoteUser2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETUSERPRINCIPAL1                           = "V2RequestTests_PortletRequest_ApiResource_getUserPrincipal1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETUSERPRINCIPAL2                           = "V2RequestTests_PortletRequest_ApiResource_getUserPrincipal2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_ISUSERINROLE1                               = "V2RequestTests_PortletRequest_ApiResource_isUserInRole1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_ISUSERINROLE2                               = "V2RequestTests_PortletRequest_ApiResource_isUserInRole2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_ISUSERINROLE3                               = "V2RequestTests_PortletRequest_ApiResource_isUserInRole3";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETATTRIBUTE1                               = "V2RequestTests_PortletRequest_ApiResource_getAttribute1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETATTRIBUTE2                               = "V2RequestTests_PortletRequest_ApiResource_getAttribute2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETATTRIBUTE3                               = "V2RequestTests_PortletRequest_ApiResource_getAttribute3";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETATTRIBUTENAMES1                          = "V2RequestTests_PortletRequest_ApiResource_getAttributeNames1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETATTRIBUTENAMES2                          = "V2RequestTests_PortletRequest_ApiResource_getAttributeNames2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPARAMETER1                               = "V2RequestTests_PortletRequest_ApiResource_getParameter1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPARAMETER2                               = "V2RequestTests_PortletRequest_ApiResource_getParameter2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPARAMETER3                               = "V2RequestTests_PortletRequest_ApiResource_getParameter3";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPARAMETER4                               = "V2RequestTests_PortletRequest_ApiResource_getParameter4";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPARAMETER5                               = "V2RequestTests_PortletRequest_ApiResource_getParameter5";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPARAMETERNAMES1                          = "V2RequestTests_PortletRequest_ApiResource_getParameterNames1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPARAMETERNAMES2                          = "V2RequestTests_PortletRequest_ApiResource_getParameterNames2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPARAMETERVALUES1                         = "V2RequestTests_PortletRequest_ApiResource_getParameterValues1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPARAMETERVALUES2                         = "V2RequestTests_PortletRequest_ApiResource_getParameterValues2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPARAMETERVALUES3                         = "V2RequestTests_PortletRequest_ApiResource_getParameterValues3";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPARAMETERVALUES4                         = "V2RequestTests_PortletRequest_ApiResource_getParameterValues4";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPARAMETERMAP1                            = "V2RequestTests_PortletRequest_ApiResource_getParameterMap1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPARAMETERMAP2                            = "V2RequestTests_PortletRequest_ApiResource_getParameterMap2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPARAMETERMAP3                            = "V2RequestTests_PortletRequest_ApiResource_getParameterMap3";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_ISSECURE1                                   = "V2RequestTests_PortletRequest_ApiResource_isSecure1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_ISSECURE2                                   = "V2RequestTests_PortletRequest_ApiResource_isSecure2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_SETATTRIBUTE1                               = "V2RequestTests_PortletRequest_ApiResource_setAttribute1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_SETATTRIBUTE2                               = "V2RequestTests_PortletRequest_ApiResource_setAttribute2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_SETATTRIBUTE3                               = "V2RequestTests_PortletRequest_ApiResource_setAttribute3";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_REMOVEATTRIBUTE1                            = "V2RequestTests_PortletRequest_ApiResource_removeAttribute1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_REMOVEATTRIBUTE2                            = "V2RequestTests_PortletRequest_ApiResource_removeAttribute2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETREQUESTEDSESSIONID1                      = "V2RequestTests_PortletRequest_ApiResource_getRequestedSessionId1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETREQUESTEDSESSIONID2                      = "V2RequestTests_PortletRequest_ApiResource_getRequestedSessionId2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_ISREQUESTEDSESSIONIDVALID1                  = "V2RequestTests_PortletRequest_ApiResource_isRequestedSessionIdValid1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_ISREQUESTEDSESSIONIDVALID2                  = "V2RequestTests_PortletRequest_ApiResource_isRequestedSessionIdValid2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETRESPONSECONTENTTYPE1                     = "V2RequestTests_PortletRequest_ApiResource_getResponseContentType1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETRESPONSECONTENTTYPE2                     = "V2RequestTests_PortletRequest_ApiResource_getResponseContentType2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETRESPONSECONTENTTYPES1                    = "V2RequestTests_PortletRequest_ApiResource_getResponseContentTypes1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETRESPONSECONTENTTYPES2                    = "V2RequestTests_PortletRequest_ApiResource_getResponseContentTypes2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETLOCALE                                   = "V2RequestTests_PortletRequest_ApiResource_getLocale";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETLOCALES                                  = "V2RequestTests_PortletRequest_ApiResource_getLocales";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETSCHEME                                   = "V2RequestTests_PortletRequest_ApiResource_getScheme";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETSERVERNAME                               = "V2RequestTests_PortletRequest_ApiResource_getServerName";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETSERVERPORT                               = "V2RequestTests_PortletRequest_ApiResource_getServerPort";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETWINDOWID                                 = "V2RequestTests_PortletRequest_ApiResource_getWindowID";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETCOOKIES1                                 = "V2RequestTests_PortletRequest_ApiResource_getCookies1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETCOOKIES2                                 = "V2RequestTests_PortletRequest_ApiResource_getCookies2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPRIVATEPARAMETERMAP1                     = "V2RequestTests_PortletRequest_ApiResource_getPrivateParameterMap1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPRIVATEPARAMETERMAP2                     = "V2RequestTests_PortletRequest_ApiResource_getPrivateParameterMap2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPRIVATEPARAMETERMAP3                     = "V2RequestTests_PortletRequest_ApiResource_getPrivateParameterMap3";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPUBLICPARAMETERMAP1                      = "V2RequestTests_PortletRequest_ApiResource_getPublicParameterMap1";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPUBLICPARAMETERMAP2                      = "V2RequestTests_PortletRequest_ApiResource_getPublicParameterMap2";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPUBLICPARAMETERMAP3                      = "V2RequestTests_PortletRequest_ApiResource_getPublicParameterMap3";
   public final static String               V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_EXISTS                                      = "V2RequestTests_PortletRequest_ApiResource_exists";
   public final static String               V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETPORTLETINPUTSTREAM1                     = "V2RequestTests_ClientDataRequest_ApiAction_getPortletInputStream1";
   public final static String               V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETPORTLETINPUTSTREAM2                     = "V2RequestTests_ClientDataRequest_ApiAction_getPortletInputStream2";
   public final static String               V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETPORTLETINPUTSTREAM3                     = "V2RequestTests_ClientDataRequest_ApiAction_getPortletInputStream3";
   public final static String               V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_SETCHARACTERENCODING1                      = "V2RequestTests_ClientDataRequest_ApiAction_setCharacterEncoding1";
   public final static String               V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_SETCHARACTERENCODING2                      = "V2RequestTests_ClientDataRequest_ApiAction_setCharacterEncoding2";
   public final static String               V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_SETCHARACTERENCODING3                      = "V2RequestTests_ClientDataRequest_ApiAction_setCharacterEncoding3";
   public final static String               V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_SETCHARACTERENCODING4                      = "V2RequestTests_ClientDataRequest_ApiAction_setCharacterEncoding4";
   public final static String               V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETREADER1                                 = "V2RequestTests_ClientDataRequest_ApiAction_getReader1";
   public final static String               V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETREADER2                                 = "V2RequestTests_ClientDataRequest_ApiAction_getReader2";
   public final static String               V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETREADER3                                 = "V2RequestTests_ClientDataRequest_ApiAction_getReader3";
   public final static String               V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETREADER5                                 = "V2RequestTests_ClientDataRequest_ApiAction_getReader5";
   public final static String               V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCHARACTERENCODING1                      = "V2RequestTests_ClientDataRequest_ApiAction_getCharacterEncoding1";
   public final static String               V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCHARACTERENCODING2                      = "V2RequestTests_ClientDataRequest_ApiAction_getCharacterEncoding2";
   public final static String               V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCONTENTTYPE1                            = "V2RequestTests_ClientDataRequest_ApiAction_getContentType1";
   public final static String               V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCONTENTTYPE2                            = "V2RequestTests_ClientDataRequest_ApiAction_getContentType2";
   public final static String               V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCONTENTLENGTH1                          = "V2RequestTests_ClientDataRequest_ApiAction_getContentLength1";
   public final static String               V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCONTENTLENGTH2                          = "V2RequestTests_ClientDataRequest_ApiAction_getContentLength2";
   public final static String               V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETMETHOD                                  = "V2RequestTests_ClientDataRequest_ApiAction_getMethod";
   public final static String               V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETPORTLETINPUTSTREAM1                   = "V2RequestTests_ClientDataRequest_ApiResource_getPortletInputStream1";
   public final static String               V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETPORTLETINPUTSTREAM2                   = "V2RequestTests_ClientDataRequest_ApiResource_getPortletInputStream2";
   public final static String               V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETPORTLETINPUTSTREAM3                   = "V2RequestTests_ClientDataRequest_ApiResource_getPortletInputStream3";
   public final static String               V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_SETCHARACTERENCODING1                    = "V2RequestTests_ClientDataRequest_ApiResource_setCharacterEncoding1";
   public final static String               V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_SETCHARACTERENCODING2                    = "V2RequestTests_ClientDataRequest_ApiResource_setCharacterEncoding2";
   public final static String               V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_SETCHARACTERENCODING3                    = "V2RequestTests_ClientDataRequest_ApiResource_setCharacterEncoding3";
   public final static String               V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_SETCHARACTERENCODING4                    = "V2RequestTests_ClientDataRequest_ApiResource_setCharacterEncoding4";
   public final static String               V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETREADER1                               = "V2RequestTests_ClientDataRequest_ApiResource_getReader1";
   public final static String               V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETREADER2                               = "V2RequestTests_ClientDataRequest_ApiResource_getReader2";
   public final static String               V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETREADER3                               = "V2RequestTests_ClientDataRequest_ApiResource_getReader3";
   public final static String               V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETREADER5                               = "V2RequestTests_ClientDataRequest_ApiResource_getReader5";
   public final static String               V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETCHARACTERENCODING1                    = "V2RequestTests_ClientDataRequest_ApiResource_getCharacterEncoding1";
   public final static String               V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETCHARACTERENCODING2                    = "V2RequestTests_ClientDataRequest_ApiResource_getCharacterEncoding2";
   public final static String               V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETCONTENTTYPE1                          = "V2RequestTests_ClientDataRequest_ApiResource_getContentType1";
   public final static String               V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETCONTENTTYPE2                          = "V2RequestTests_ClientDataRequest_ApiResource_getContentType2";
   public final static String               V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETCONTENTLENGTH1                        = "V2RequestTests_ClientDataRequest_ApiResource_getContentLength1";
   public final static String               V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETCONTENTLENGTH2                        = "V2RequestTests_ClientDataRequest_ApiResource_getContentLength2";
   public final static String               V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETMETHOD                                = "V2RequestTests_ClientDataRequest_ApiResource_getMethod";
   public final static String               V2REQUESTTESTS_ACTIONREQUEST_APIACTION_FIELDACTION_NAME                               = "V2RequestTests_ActionRequest_ApiAction_fieldACTION_NAME";
   public final static String               V2REQUESTTESTS_RESOURCEREQUEST_APIRESOURCE_FIELDETAG                                  = "V2RequestTests_ResourceRequest_ApiResource_fieldETAG";
   public final static String               V2REQUESTTESTS_RESOURCEREQUEST_APIRESOURCE_GETETAG2                                   = "V2RequestTests_ResourceRequest_ApiResource_getETag2";
   public final static String               V2REQUESTTESTS_RESOURCEREQUEST_APIRESOURCE_GETRESOURCEID1                             = "V2RequestTests_ResourceRequest_ApiResource_getResourceID1";
   public final static String               V2REQUESTTESTS_RESOURCEREQUEST_APIRESOURCE_GETRESOURCEID2                             = "V2RequestTests_ResourceRequest_ApiResource_getResourceID2";
   public final static String               V2REQUESTTESTS_RESOURCEREQUEST_APIRESOURCE_GETPRIVATERENDERPARAMETERMAP1              = "V2RequestTests_ResourceRequest_ApiResource_getPrivateRenderParameterMap1";
   public final static String               V2REQUESTTESTS_RESOURCEREQUEST_APIRESOURCE_GETPRIVATERENDERPARAMETERMAP2              = "V2RequestTests_ResourceRequest_ApiResource_getPrivateRenderParameterMap2";
   public final static String               V2REQUESTTESTS_RESOURCEREQUEST_APIRESOURCE_GETPRIVATERENDERPARAMETERMAP3              = "V2RequestTests_ResourceRequest_ApiResource_getPrivateRenderParameterMap3";
   public final static String               V2REQUESTTESTS_RESOURCEREQUEST_APIRESOURCE_GETPRIVATERENDERPARAMETERMAP4              = "V2RequestTests_ResourceRequest_ApiResource_getPrivateRenderParameterMap4";
   public final static String               V2REQUESTTESTS_RESOURCEREQUEST_APIRESOURCE_GETRESPONSECONTENTTYPE                     = "V2RequestTests_ResourceRequest_ApiResource_getResponseContentType";
   public final static String               V2REQUESTTESTS_RESOURCEREQUEST_APIRESOURCE_GETRESPONSECONTENTTYPES                    = "V2RequestTests_ResourceRequest_ApiResource_getResponseContentTypes";
   public final static String               V2REQUESTTESTS_RESOURCEREQUEST_APIRESOURCE_GETCACHEABILITY                            = "V2RequestTests_ResourceRequest_ApiResource_getCacheability";
   public final static String               V2REQUESTTESTS_EVENTREQUEST_APIEVENT_GETEVENT                                         = "V2RequestTests_EventRequest_ApiEvent_getEvent";
   public final static String               V2REQUESTTESTS_EVENTREQUEST_APIEVENT_GETMETHOD                                        = "V2RequestTests_EventRequest_ApiEvent_getMethod";
   public final static String               V2REQUESTTESTS_RENDERREQUEST_APIRENDER_FIELDETAG                                      = "V2RequestTests_RenderRequest_ApiRender_fieldETAG";
   public final static String               V2REQUESTTESTS_RENDERREQUEST_APIRENDER_GETETAG2                                       = "V2RequestTests_RenderRequest_ApiRender_getETag2";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIRENDER_ADDPROPERTYA1                               = "V2ResponseTests_PortletResponse_ApiRender_addPropertyA1";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIRENDER_ADDPROPERTYA2                               = "V2ResponseTests_PortletResponse_ApiRender_addPropertyA2";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIRENDER_ADDPROPERTYB1                               = "V2ResponseTests_PortletResponse_ApiRender_addPropertyB1";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIRENDER_ADDPROPERTYB3                               = "V2ResponseTests_PortletResponse_ApiRender_addPropertyB3";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIRENDER_ADDPROPERTYB4                               = "V2ResponseTests_PortletResponse_ApiRender_addPropertyB4";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIRENDER_ADDPROPERTYC1                               = "V2ResponseTests_PortletResponse_ApiRender_addPropertyC1";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIRENDER_ADDPROPERTYC2                               = "V2ResponseTests_PortletResponse_ApiRender_addPropertyC2";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIRENDER_SETPROPERTY1                                = "V2ResponseTests_PortletResponse_ApiRender_setProperty1";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIRENDER_SETPROPERTY3                                = "V2ResponseTests_PortletResponse_ApiRender_setProperty3";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIRENDER_ENCODEURL1                                  = "V2ResponseTests_PortletResponse_ApiRender_encodeURL1";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIRENDER_ENCODEURL2                                  = "V2ResponseTests_PortletResponse_ApiRender_encodeURL2";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIRENDER_GETNAMESPACE1                               = "V2ResponseTests_PortletResponse_ApiRender_getNamespace1";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIRENDER_CREATEELEMENT1                              = "V2ResponseTests_PortletResponse_ApiRender_createElement1";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIRENDER_CREATEELEMENT2                              = "V2ResponseTests_PortletResponse_ApiRender_createElement2";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIRENDER_CREATEELEMENT3                              = "V2ResponseTests_PortletResponse_ApiRender_createElement3";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIRENDER_CREATEELEMENT4                              = "V2ResponseTests_PortletResponse_ApiRender_createElement4";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIRENDER_CREATEELEMENT5                              = "V2ResponseTests_PortletResponse_ApiRender_createElement5";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIRENDER_CREATEELEMENT6                              = "V2ResponseTests_PortletResponse_ApiRender_createElement6";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_ADDPROPERTYA1                             = "V2ResponseTests_PortletResponse_ApiResource_addPropertyA1";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_ADDPROPERTYA2                             = "V2ResponseTests_PortletResponse_ApiResource_addPropertyA2";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_ADDPROPERTYB1                             = "V2ResponseTests_PortletResponse_ApiResource_addPropertyB1";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_ADDPROPERTYB2                             = "V2ResponseTests_PortletResponse_ApiResource_addPropertyB2";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_ADDPROPERTYB3                             = "V2ResponseTests_PortletResponse_ApiResource_addPropertyB3";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_ADDPROPERTYB4                             = "V2ResponseTests_PortletResponse_ApiResource_addPropertyB4";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_ADDPROPERTYC1                             = "V2ResponseTests_PortletResponse_ApiResource_addPropertyC1";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_ADDPROPERTYC2                             = "V2ResponseTests_PortletResponse_ApiResource_addPropertyC2";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_SETPROPERTY1                              = "V2ResponseTests_PortletResponse_ApiResource_setProperty1";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_SETPROPERTY2                              = "V2ResponseTests_PortletResponse_ApiResource_setProperty2";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_SETPROPERTY3                              = "V2ResponseTests_PortletResponse_ApiResource_setProperty3";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_ENCODEURL1                                = "V2ResponseTests_PortletResponse_ApiResource_encodeURL1";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_ENCODEURL2                                = "V2ResponseTests_PortletResponse_ApiResource_encodeURL2";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_GETNAMESPACE1                             = "V2ResponseTests_PortletResponse_ApiResource_getNamespace1";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_CREATEELEMENT1                            = "V2ResponseTests_PortletResponse_ApiResource_createElement1";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_CREATEELEMENT2                            = "V2ResponseTests_PortletResponse_ApiResource_createElement2";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_CREATEELEMENT3                            = "V2ResponseTests_PortletResponse_ApiResource_createElement3";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_CREATEELEMENT4                            = "V2ResponseTests_PortletResponse_ApiResource_createElement4";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_CREATEELEMENT5                            = "V2ResponseTests_PortletResponse_ApiResource_createElement5";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_CREATEELEMENT6                            = "V2ResponseTests_PortletResponse_ApiResource_createElement6";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIACTION_ADDPROPERTYA1                               = "V2ResponseTests_PortletResponse_ApiAction_addPropertyA1";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIACTION_ADDPROPERTYA2                               = "V2ResponseTests_PortletResponse_ApiAction_addPropertyA2";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIACTION_ADDPROPERTYB1                               = "V2ResponseTests_PortletResponse_ApiAction_addPropertyB1";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIACTION_ADDPROPERTYB3                               = "V2ResponseTests_PortletResponse_ApiAction_addPropertyB3";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIACTION_ADDPROPERTYB4                               = "V2ResponseTests_PortletResponse_ApiAction_addPropertyB4";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIACTION_ADDPROPERTYC1                               = "V2ResponseTests_PortletResponse_ApiAction_addPropertyC1";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIACTION_ADDPROPERTYC2                               = "V2ResponseTests_PortletResponse_ApiAction_addPropertyC2";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIACTION_SETPROPERTY1                                = "V2ResponseTests_PortletResponse_ApiAction_setProperty1";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIACTION_SETPROPERTY3                                = "V2ResponseTests_PortletResponse_ApiAction_setProperty3";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIACTION_ENCODEURL1                                  = "V2ResponseTests_PortletResponse_ApiAction_encodeURL1";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIACTION_ENCODEURL2                                  = "V2ResponseTests_PortletResponse_ApiAction_encodeURL2";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIACTION_GETNAMESPACE1                               = "V2ResponseTests_PortletResponse_ApiAction_getNamespace1";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIACTION_CREATEELEMENT1                              = "V2ResponseTests_PortletResponse_ApiAction_createElement1";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIACTION_CREATEELEMENT2                              = "V2ResponseTests_PortletResponse_ApiAction_createElement2";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIACTION_CREATEELEMENT3                              = "V2ResponseTests_PortletResponse_ApiAction_createElement3";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIACTION_CREATEELEMENT4                              = "V2ResponseTests_PortletResponse_ApiAction_createElement4";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIACTION_CREATEELEMENT5                              = "V2ResponseTests_PortletResponse_ApiAction_createElement5";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIACTION_CREATEELEMENT6                              = "V2ResponseTests_PortletResponse_ApiAction_createElement6";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_ADDPROPERTYA1                                = "V2ResponseTests_PortletResponse_ApiEvent_addPropertyA1";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_ADDPROPERTYA2                                = "V2ResponseTests_PortletResponse_ApiEvent_addPropertyA2";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_ADDPROPERTYB1                                = "V2ResponseTests_PortletResponse_ApiEvent_addPropertyB1";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_ADDPROPERTYB3                                = "V2ResponseTests_PortletResponse_ApiEvent_addPropertyB3";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_ADDPROPERTYB4                                = "V2ResponseTests_PortletResponse_ApiEvent_addPropertyB4";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_ADDPROPERTYC1                                = "V2ResponseTests_PortletResponse_ApiEvent_addPropertyC1";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_ADDPROPERTYC2                                = "V2ResponseTests_PortletResponse_ApiEvent_addPropertyC2";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_SETPROPERTY1                                 = "V2ResponseTests_PortletResponse_ApiEvent_setProperty1";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_SETPROPERTY3                                 = "V2ResponseTests_PortletResponse_ApiEvent_setProperty3";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_ENCODEURL1                                   = "V2ResponseTests_PortletResponse_ApiEvent_encodeURL1";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_ENCODEURL2                                   = "V2ResponseTests_PortletResponse_ApiEvent_encodeURL2";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_GETNAMESPACE1                                = "V2ResponseTests_PortletResponse_ApiEvent_getNamespace1";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_CREATEELEMENT1                               = "V2ResponseTests_PortletResponse_ApiEvent_createElement1";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_CREATEELEMENT2                               = "V2ResponseTests_PortletResponse_ApiEvent_createElement2";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_CREATEELEMENT3                               = "V2ResponseTests_PortletResponse_ApiEvent_createElement3";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_CREATEELEMENT4                               = "V2ResponseTests_PortletResponse_ApiEvent_createElement4";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_CREATEELEMENT5                               = "V2ResponseTests_PortletResponse_ApiEvent_createElement5";
   public final static String               V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_CREATEELEMENT6                               = "V2ResponseTests_PortletResponse_ApiEvent_createElement6";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETWINDOWSTATE1                           = "V2ResponseTests_StateAwareResponse_ApiEvent_setWindowState1";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETWINDOWSTATE2                           = "V2ResponseTests_StateAwareResponse_ApiEvent_setWindowState2";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETWINDOWSTATE3                           = "V2ResponseTests_StateAwareResponse_ApiEvent_setWindowState3";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETPORTLETMODE1                           = "V2ResponseTests_StateAwareResponse_ApiEvent_setPortletMode1";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETPORTLETMODE2                           = "V2ResponseTests_StateAwareResponse_ApiEvent_setPortletMode2";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETPORTLETMODE3                           = "V2ResponseTests_StateAwareResponse_ApiEvent_setPortletMode3";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERS1                      = "V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameters1";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERS2                      = "V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameters2";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERS3                      = "V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameters3";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERS4                      = "V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameters4";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERS5                      = "V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameters5";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERS6                      = "V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameters6";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERS7                      = "V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameters7";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERS8                      = "V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameters8";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERS10                     = "V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameters10";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERS11                     = "V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameters11";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERS12                     = "V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameters12";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERA1                      = "V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameterA1";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERA2                      = "V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameterA2";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERA3                      = "V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameterA3";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERA4                      = "V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameterA4";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERA5                      = "V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameterA5";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERA6                      = "V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameterA6";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERA7                      = "V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameterA7";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERA8                      = "V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameterA8";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERB1                      = "V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameterB1";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERB2                      = "V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameterB2";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERB3                      = "V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameterB3";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERB4                      = "V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameterB4";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERB5                      = "V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameterB5";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERB6                      = "V2ResponseTests_StateAwareResponse_ApiEvent_setRenderParameterB6";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETEVENTA1                                = "V2ResponseTests_StateAwareResponse_ApiEvent_setEventA1";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETEVENTA2                                = "V2ResponseTests_StateAwareResponse_ApiEvent_setEventA2";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETEVENTA3                                = "V2ResponseTests_StateAwareResponse_ApiEvent_setEventA3";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETEVENTA4                                = "V2ResponseTests_StateAwareResponse_ApiEvent_setEventA4";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETEVENTA5                                = "V2ResponseTests_StateAwareResponse_ApiEvent_setEventA5";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETEVENTB1                                = "V2ResponseTests_StateAwareResponse_ApiEvent_setEventB1";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETEVENTB2                                = "V2ResponseTests_StateAwareResponse_ApiEvent_setEventB2";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETEVENTB3                                = "V2ResponseTests_StateAwareResponse_ApiEvent_setEventB3";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETEVENTB4                                = "V2ResponseTests_StateAwareResponse_ApiEvent_setEventB4";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETEVENTB5                                = "V2ResponseTests_StateAwareResponse_ApiEvent_setEventB5";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_GETRENDERPARAMETERMAP1                    = "V2ResponseTests_StateAwareResponse_ApiEvent_getRenderParameterMap1";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_GETRENDERPARAMETERMAP2                    = "V2ResponseTests_StateAwareResponse_ApiEvent_getRenderParameterMap2";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_GETRENDERPARAMETERMAP3                    = "V2ResponseTests_StateAwareResponse_ApiEvent_getRenderParameterMap3";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_GETRENDERPARAMETERMAP4                    = "V2ResponseTests_StateAwareResponse_ApiEvent_getRenderParameterMap4";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_GETPORTLETMODE1                           = "V2ResponseTests_StateAwareResponse_ApiEvent_getPortletMode1";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_GETPORTLETMODE2                           = "V2ResponseTests_StateAwareResponse_ApiEvent_getPortletMode2";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_GETWINDOWSTATE1                           = "V2ResponseTests_StateAwareResponse_ApiEvent_getWindowState1";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_GETWINDOWSTATE2                           = "V2ResponseTests_StateAwareResponse_ApiEvent_getWindowState2";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_REMOVEPUBLICRENDERPARAMETER1              = "V2ResponseTests_StateAwareResponse_ApiEvent_removePublicRenderParameter1";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_REMOVEPUBLICRENDERPARAMETER2              = "V2ResponseTests_StateAwareResponse_ApiEvent_removePublicRenderParameter2";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETWINDOWSTATE1                          = "V2ResponseTests_StateAwareResponse_ApiAction_setWindowState1";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETWINDOWSTATE2                          = "V2ResponseTests_StateAwareResponse_ApiAction_setWindowState2";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETWINDOWSTATE3                          = "V2ResponseTests_StateAwareResponse_ApiAction_setWindowState3";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETPORTLETMODE1                          = "V2ResponseTests_StateAwareResponse_ApiAction_setPortletMode1";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETPORTLETMODE2                          = "V2ResponseTests_StateAwareResponse_ApiAction_setPortletMode2";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETPORTLETMODE3                          = "V2ResponseTests_StateAwareResponse_ApiAction_setPortletMode3";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETRENDERPARAMETERS1                     = "V2ResponseTests_StateAwareResponse_ApiAction_setRenderParameters1";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETRENDERPARAMETERS2                     = "V2ResponseTests_StateAwareResponse_ApiAction_setRenderParameters2";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETRENDERPARAMETERS3                     = "V2ResponseTests_StateAwareResponse_ApiAction_setRenderParameters3";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETRENDERPARAMETERS4                     = "V2ResponseTests_StateAwareResponse_ApiAction_setRenderParameters4";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETRENDERPARAMETERS5                     = "V2ResponseTests_StateAwareResponse_ApiAction_setRenderParameters5";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETRENDERPARAMETERS6                     = "V2ResponseTests_StateAwareResponse_ApiAction_setRenderParameters6";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETRENDERPARAMETERS7                     = "V2ResponseTests_StateAwareResponse_ApiAction_setRenderParameters7";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETRENDERPARAMETERS8                     = "V2ResponseTests_StateAwareResponse_ApiAction_setRenderParameters8";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETRENDERPARAMETERS10                    = "V2ResponseTests_StateAwareResponse_ApiAction_setRenderParameters10";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETRENDERPARAMETERS11                    = "V2ResponseTests_StateAwareResponse_ApiAction_setRenderParameters11";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETRENDERPARAMETERS12                    = "V2ResponseTests_StateAwareResponse_ApiAction_setRenderParameters12";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETRENDERPARAMETERA1                     = "V2ResponseTests_StateAwareResponse_ApiAction_setRenderParameterA1";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETRENDERPARAMETERA2                     = "V2ResponseTests_StateAwareResponse_ApiAction_setRenderParameterA2";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETRENDERPARAMETERA3                     = "V2ResponseTests_StateAwareResponse_ApiAction_setRenderParameterA3";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETRENDERPARAMETERA4                     = "V2ResponseTests_StateAwareResponse_ApiAction_setRenderParameterA4";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETRENDERPARAMETERA5                     = "V2ResponseTests_StateAwareResponse_ApiAction_setRenderParameterA5";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETRENDERPARAMETERA6                     = "V2ResponseTests_StateAwareResponse_ApiAction_setRenderParameterA6";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETRENDERPARAMETERA7                     = "V2ResponseTests_StateAwareResponse_ApiAction_setRenderParameterA7";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETRENDERPARAMETERA8                     = "V2ResponseTests_StateAwareResponse_ApiAction_setRenderParameterA8";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETRENDERPARAMETERB1                     = "V2ResponseTests_StateAwareResponse_ApiAction_setRenderParameterB1";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETRENDERPARAMETERB2                     = "V2ResponseTests_StateAwareResponse_ApiAction_setRenderParameterB2";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETRENDERPARAMETERB3                     = "V2ResponseTests_StateAwareResponse_ApiAction_setRenderParameterB3";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETRENDERPARAMETERB4                     = "V2ResponseTests_StateAwareResponse_ApiAction_setRenderParameterB4";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETRENDERPARAMETERB5                     = "V2ResponseTests_StateAwareResponse_ApiAction_setRenderParameterB5";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETRENDERPARAMETERB6                     = "V2ResponseTests_StateAwareResponse_ApiAction_setRenderParameterB6";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETEVENTA1                               = "V2ResponseTests_StateAwareResponse_ApiAction_setEventA1";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETEVENTA2                               = "V2ResponseTests_StateAwareResponse_ApiAction_setEventA2";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETEVENTA3                               = "V2ResponseTests_StateAwareResponse_ApiAction_setEventA3";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETEVENTA4                               = "V2ResponseTests_StateAwareResponse_ApiAction_setEventA4";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETEVENTA5                               = "V2ResponseTests_StateAwareResponse_ApiAction_setEventA5";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETEVENTB1                               = "V2ResponseTests_StateAwareResponse_ApiAction_setEventB1";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETEVENTB2                               = "V2ResponseTests_StateAwareResponse_ApiAction_setEventB2";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETEVENTB3                               = "V2ResponseTests_StateAwareResponse_ApiAction_setEventB3";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETEVENTB4                               = "V2ResponseTests_StateAwareResponse_ApiAction_setEventB4";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETEVENTB5                               = "V2ResponseTests_StateAwareResponse_ApiAction_setEventB5";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_GETRENDERPARAMETERMAP1                   = "V2ResponseTests_StateAwareResponse_ApiAction_getRenderParameterMap1";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_GETRENDERPARAMETERMAP2                   = "V2ResponseTests_StateAwareResponse_ApiAction_getRenderParameterMap2";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_GETRENDERPARAMETERMAP3                   = "V2ResponseTests_StateAwareResponse_ApiAction_getRenderParameterMap3";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_GETRENDERPARAMETERMAP4                   = "V2ResponseTests_StateAwareResponse_ApiAction_getRenderParameterMap4";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_GETPORTLETMODE1                          = "V2ResponseTests_StateAwareResponse_ApiAction_getPortletMode1";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_GETPORTLETMODE2                          = "V2ResponseTests_StateAwareResponse_ApiAction_getPortletMode2";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_GETWINDOWSTATE1                          = "V2ResponseTests_StateAwareResponse_ApiAction_getWindowState1";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_GETWINDOWSTATE2                          = "V2ResponseTests_StateAwareResponse_ApiAction_getWindowState2";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_REMOVEPUBLICRENDERPARAMETER1             = "V2ResponseTests_StateAwareResponse_ApiAction_removePublicRenderParameter1";
   public final static String               V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_REMOVEPUBLICRENDERPARAMETER2             = "V2ResponseTests_StateAwareResponse_ApiAction_removePublicRenderParameter2";
   public final static String               V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTA1                               = "V2ResponseTests_ActionResponse_ApiAction_sendRedirectA1";
   public final static String               V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTA2                               = "V2ResponseTests_ActionResponse_ApiAction_sendRedirectA2";
   public final static String               V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTA3                               = "V2ResponseTests_ActionResponse_ApiAction_sendRedirectA3";
   public final static String               V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTA4                               = "V2ResponseTests_ActionResponse_ApiAction_sendRedirectA4";
   public final static String               V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTA5                               = "V2ResponseTests_ActionResponse_ApiAction_sendRedirectA5";
   public final static String               V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTA6                               = "V2ResponseTests_ActionResponse_ApiAction_sendRedirectA6";
   public final static String               V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTA7                               = "V2ResponseTests_ActionResponse_ApiAction_sendRedirectA7";
   public final static String               V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTB1                               = "V2ResponseTests_ActionResponse_ApiAction_sendRedirectB1";
   public final static String               V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTB2                               = "V2ResponseTests_ActionResponse_ApiAction_sendRedirectB2";
   public final static String               V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTB3                               = "V2ResponseTests_ActionResponse_ApiAction_sendRedirectB3";
   public final static String               V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTB4                               = "V2ResponseTests_ActionResponse_ApiAction_sendRedirectB4";
   public final static String               V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTB5                               = "V2ResponseTests_ActionResponse_ApiAction_sendRedirectB5";
   public final static String               V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTB6                               = "V2ResponseTests_ActionResponse_ApiAction_sendRedirectB6";
   public final static String               V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTB7                               = "V2ResponseTests_ActionResponse_ApiAction_sendRedirectB7";
   public final static String               V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTB8                               = "V2ResponseTests_ActionResponse_ApiAction_sendRedirectB8";
   public final static String               V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTB9                               = "V2ResponseTests_ActionResponse_ApiAction_sendRedirectB9";
   public final static String               V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTB10                              = "V2ResponseTests_ActionResponse_ApiAction_sendRedirectB10";
   public final static String               V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTB11                              = "V2ResponseTests_ActionResponse_ApiAction_sendRedirectB11";
   public final static String               V2RESPONSETESTS_EVENTRESPONSE_APIEVENT_SETRENDERPARAMETERS1                           = "V2ResponseTests_EventResponse_ApiEvent_setRenderParameters1";
   public final static String               V2RESPONSETESTS_EVENTRESPONSE_APIEVENT_SETRENDERPARAMETERS2                           = "V2ResponseTests_EventResponse_ApiEvent_setRenderParameters2";
   public final static String               V2RESPONSETESTS_MIMERESPONSE_APIRENDER_FIELDEXPIRATION_CACHE                          = "V2ResponseTests_MimeResponse_ApiRender_fieldEXPIRATION_CACHE";
   public final static String               V2RESPONSETESTS_MIMERESPONSE_APIRENDER_FIELDCACHE_SCOPE                               = "V2ResponseTests_MimeResponse_ApiRender_fieldCACHE_SCOPE";
   public final static String               V2RESPONSETESTS_MIMERESPONSE_APIRENDER_FIELDPUBLIC_SCOPE                              = "V2ResponseTests_MimeResponse_ApiRender_fieldPUBLIC_SCOPE";
   public final static String               V2RESPONSETESTS_MIMERESPONSE_APIRENDER_FIELDPRIVATE_SCOPE                             = "V2ResponseTests_MimeResponse_ApiRender_fieldPRIVATE_SCOPE";
   public final static String               V2RESPONSETESTS_MIMERESPONSE_APIRENDER_FIELDETAG                                      = "V2ResponseTests_MimeResponse_ApiRender_fieldETAG";
   public final static String               V2RESPONSETESTS_MIMERESPONSE_APIRENDER_FIELDUSE_CACHED_CONTENT                        = "V2ResponseTests_MimeResponse_ApiRender_fieldUSE_CACHED_CONTENT";
   public final static String               V2RESPONSETESTS_MIMERESPONSE_APIRENDER_FIELDNAMESPACED_RESPONSE                       = "V2ResponseTests_MimeResponse_ApiRender_fieldNAMESPACED_RESPONSE";
   public final static String               V2RESPONSETESTS_MIMERESPONSE_APIRENDER_FIELDMARKUP_HEAD_ELEMENT                       = "V2ResponseTests_MimeResponse_ApiRender_fieldMARKUP_HEAD_ELEMENT";
   public final static String               V2RESPONSETESTS_MIMERESPONSE_APIRENDER_GETCONTENTTYPE1                                = "V2ResponseTests_MimeResponse_ApiRender_getContentType1";
   public final static String               V2RESPONSETESTS_MIMERESPONSE_APIRENDER_GETCONTENTTYPE2                                = "V2ResponseTests_MimeResponse_ApiRender_getContentType2";
   public final static String               V2RESPONSETESTS_MIMERESPONSE_APIRENDER_SETCONTENTTYPE1                                = "V2ResponseTests_MimeResponse_ApiRender_setContentType1";
   public final static String               V2RESPONSETESTS_MIMERESPONSE_APIRENDER_SETCONTENTTYPE4                                = "V2ResponseTests_MimeResponse_ApiRender_setContentType4";
   public final static String               V2RESPONSETESTS_MIMERESPONSE_APIRENDER_GETCHARACTERENCODING                           = "V2ResponseTests_MimeResponse_ApiRender_getCharacterEncoding";
   public final static String               V2RESPONSETESTS_MIMERESPONSE_APIRENDER_GETWRITER1                                     = "V2ResponseTests_MimeResponse_ApiRender_getWriter1";
   public final static String               V2RESPONSETESTS_MIMERESPONSE_APIRENDER_GETWRITER2                                     = "V2ResponseTests_MimeResponse_ApiRender_getWriter2";
   public final static String               V2RESPONSETESTS_MIMERESPONSE_APIRENDER_GETLOCALE                                      = "V2ResponseTests_MimeResponse_ApiRender_getLocale";
   public final static String               V2RESPONSETESTS_MIMERESPONSE_APIRENDER_SETBUFFERSIZE1                                 = "V2ResponseTests_MimeResponse_ApiRender_setBufferSize1";
   public final static String               V2RESPONSETESTS_MIMERESPONSE_APIRENDER_SETBUFFERSIZE2                                 = "V2ResponseTests_MimeResponse_ApiRender_setBufferSize2";
   public final static String               V2RESPONSETESTS_MIMERESPONSE_APIRENDER_GETBUFFERSIZE1                                 = "V2ResponseTests_MimeResponse_ApiRender_getBufferSize1";
   public final static String               V2RESPONSETESTS_MIMERESPONSE_APIRENDER_GETBUFFERSIZE2                                 = "V2ResponseTests_MimeResponse_ApiRender_getBufferSize2";
   public final static String               V2RESPONSETESTS_MIMERESPONSE_APIRENDER_FLUSHBUFFER1                                   = "V2ResponseTests_MimeResponse_ApiRender_flushBuffer1";
   public final static String               V2RESPONSETESTS_MIMERESPONSE_APIRENDER_RESETBUFFER1                                   = "V2ResponseTests_MimeResponse_ApiRender_resetBuffer1";
   public final static String               V2RESPONSETESTS_MIMERESPONSE_APIRENDER_RESETBUFFER2                                   = "V2ResponseTests_MimeResponse_ApiRender_resetBuffer2";
   public final static String               V2RESPONSETESTS_MIMERESPONSE_APIRENDER_ISCOMMITTED1                                   = "V2ResponseTests_MimeResponse_ApiRender_isCommitted1";
   public final static String               V2RESPONSETESTS_MIMERESPONSE_APIRENDER_ISCOMMITTED2                                   = "V2ResponseTests_MimeResponse_ApiRender_isCommitted2";
   public final static String               V2RESPONSETESTS_MIMERESPONSE_APIRENDER_RESET1                                         = "V2ResponseTests_MimeResponse_ApiRender_reset1";
   public final static String               V2RESPONSETESTS_MIMERESPONSE_APIRENDER_RESET2                                         = "V2ResponseTests_MimeResponse_ApiRender_reset2";
   public final static String               V2RESPONSETESTS_MIMERESPONSE_APIRENDER_GETPORTLETOUTPUTSTREAM1                        = "V2ResponseTests_MimeResponse_ApiRender_getPortletOutputStream1";
   public final static String               V2RESPONSETESTS_MIMERESPONSE_APIRENDER_GETPORTLETOUTPUTSTREAM2                        = "V2ResponseTests_MimeResponse_ApiRender_getPortletOutputStream2";
   public final static String               V2RESPONSETESTS_MIMERESPONSE_APIRENDER_CREATERENDERURL                                = "V2ResponseTests_MimeResponse_ApiRender_createRenderURL";
   public final static String               V2RESPONSETESTS_MIMERESPONSE_APIRENDER_CREATEACTIONURL                                = "V2ResponseTests_MimeResponse_ApiRender_createActionURL";
   public final static String               V2RESPONSETESTS_MIMERESPONSE_APIRENDER_CREATERESOURCEURL                              = "V2ResponseTests_MimeResponse_ApiRender_createResourceURL";
   public final static String               V2RESPONSETESTS_MIMERESPONSE_APIRENDER_GETCACHECONTROL                                = "V2ResponseTests_MimeResponse_ApiRender_getCacheControl";
   public final static String               V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_FIELDEXPIRATION_CACHE                        = "V2ResponseTests_MimeResponse_ApiResource_fieldEXPIRATION_CACHE";
   public final static String               V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_FIELDCACHE_SCOPE                             = "V2ResponseTests_MimeResponse_ApiResource_fieldCACHE_SCOPE";
   public final static String               V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_FIELDPUBLIC_SCOPE                            = "V2ResponseTests_MimeResponse_ApiResource_fieldPUBLIC_SCOPE";
   public final static String               V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_FIELDPRIVATE_SCOPE                           = "V2ResponseTests_MimeResponse_ApiResource_fieldPRIVATE_SCOPE";
   public final static String               V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_FIELDETAG                                    = "V2ResponseTests_MimeResponse_ApiResource_fieldETAG";
   public final static String               V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_FIELDUSE_CACHED_CONTENT                      = "V2ResponseTests_MimeResponse_ApiResource_fieldUSE_CACHED_CONTENT";
   public final static String               V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_FIELDNAMESPACED_RESPONSE                     = "V2ResponseTests_MimeResponse_ApiResource_fieldNAMESPACED_RESPONSE";
   public final static String               V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_FIELDMARKUP_HEAD_ELEMENT                     = "V2ResponseTests_MimeResponse_ApiResource_fieldMARKUP_HEAD_ELEMENT";
   public final static String               V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_GETCONTENTTYPE1                              = "V2ResponseTests_MimeResponse_ApiResource_getContentType1";
   public final static String               V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_GETCONTENTTYPE2                              = "V2ResponseTests_MimeResponse_ApiResource_getContentType2";
   public final static String               V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_SETCONTENTTYPE1                              = "V2ResponseTests_MimeResponse_ApiResource_setContentType1";
   public final static String               V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_SETCONTENTTYPE4                              = "V2ResponseTests_MimeResponse_ApiResource_setContentType4";
   public final static String               V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_GETCHARACTERENCODING                         = "V2ResponseTests_MimeResponse_ApiResource_getCharacterEncoding";
   public final static String               V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_GETWRITER1                                   = "V2ResponseTests_MimeResponse_ApiResource_getWriter1";
   public final static String               V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_GETWRITER2                                   = "V2ResponseTests_MimeResponse_ApiResource_getWriter2";
   public final static String               V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_GETLOCALE                                    = "V2ResponseTests_MimeResponse_ApiResource_getLocale";
   public final static String               V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_SETBUFFERSIZE1                               = "V2ResponseTests_MimeResponse_ApiResource_setBufferSize1";
   public final static String               V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_SETBUFFERSIZE2                               = "V2ResponseTests_MimeResponse_ApiResource_setBufferSize2";
   public final static String               V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_GETBUFFERSIZE1                               = "V2ResponseTests_MimeResponse_ApiResource_getBufferSize1";
   public final static String               V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_GETBUFFERSIZE2                               = "V2ResponseTests_MimeResponse_ApiResource_getBufferSize2";
   public final static String               V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_FLUSHBUFFER1                                 = "V2ResponseTests_MimeResponse_ApiResource_flushBuffer1";
   public final static String               V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_RESETBUFFER1                                 = "V2ResponseTests_MimeResponse_ApiResource_resetBuffer1";
   public final static String               V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_RESETBUFFER2                                 = "V2ResponseTests_MimeResponse_ApiResource_resetBuffer2";
   public final static String               V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_ISCOMMITTED1                                 = "V2ResponseTests_MimeResponse_ApiResource_isCommitted1";
   public final static String               V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_ISCOMMITTED2                                 = "V2ResponseTests_MimeResponse_ApiResource_isCommitted2";
   public final static String               V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_RESET1                                       = "V2ResponseTests_MimeResponse_ApiResource_reset1";
   public final static String               V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_RESET2                                       = "V2ResponseTests_MimeResponse_ApiResource_reset2";
   public final static String               V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_GETPORTLETOUTPUTSTREAM1                      = "V2ResponseTests_MimeResponse_ApiResource_getPortletOutputStream1";
   public final static String               V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_GETPORTLETOUTPUTSTREAM2                      = "V2ResponseTests_MimeResponse_ApiResource_getPortletOutputStream2";
   public final static String               V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_CREATERENDERURL                              = "V2ResponseTests_MimeResponse_ApiResource_createRenderURL";
   public final static String               V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_CREATEACTIONURL                              = "V2ResponseTests_MimeResponse_ApiResource_createActionURL";
   public final static String               V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_CREATERESOURCEURL                            = "V2ResponseTests_MimeResponse_ApiResource_createResourceURL";
   public final static String               V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_GETCACHECONTROL                              = "V2ResponseTests_MimeResponse_ApiResource_getCacheControl";
   public final static String               V2RESPONSETESTS_RENDERRESPONSE_APIRENDER_SETTITLE2                                    = "V2ResponseTests_RenderResponse_ApiRender_setTitle2";
   public final static String               V2RESPONSETESTS_RENDERRESPONSE_APIRENDER_SETNEXTPOSSIBLEPORTLETMODES2                 = "V2ResponseTests_RenderResponse_ApiRender_setNextPossiblePortletModes2";
   public final static String               V2RESPONSETESTS_RENDERRESPONSE_APIRENDER_SETCONTENTTYPE1                              = "V2ResponseTests_RenderResponse_ApiRender_setContentType1";
   public final static String               V2RESPONSETESTS_RENDERRESPONSE_APIRENDER_SETCONTENTTYPE2                              = "V2ResponseTests_RenderResponse_ApiRender_setContentType2";
   public final static String               V2RESPONSETESTS_RESOURCERESPONSE_APIRESOURCE_FIELDHTTP_STATUS_CODE                    = "V2ResponseTests_ResourceResponse_ApiResource_fieldHTTP_STATUS_CODE";
   public final static String               V2RESPONSETESTS_RESOURCERESPONSE_APIRESOURCE_SETLOCALE1                               = "V2ResponseTests_ResourceResponse_ApiResource_setLocale1";
   public final static String               V2RESPONSETESTS_RESOURCERESPONSE_APIRESOURCE_SETLOCALE4                               = "V2ResponseTests_ResourceResponse_ApiResource_setLocale4";
   public final static String               V2RESPONSETESTS_RESOURCERESPONSE_APIRESOURCE_SETCHARACTERENCODING1                    = "V2ResponseTests_ResourceResponse_ApiResource_setCharacterEncoding1";
   public final static String               V2RESPONSETESTS_RESOURCERESPONSE_APIRESOURCE_SETCHARACTERENCODING4                    = "V2ResponseTests_ResourceResponse_ApiResource_setCharacterEncoding4";
   public final static String               V2RESPONSETESTS_RESOURCERESPONSE_APIRESOURCE_SETCONTENTLENGTH1                        = "V2ResponseTests_ResourceResponse_ApiResource_setContentLength1";
   public final static String               V2RESPONSETESTS_RESOURCERESPONSE_APIRESOURCE_CREATERENDERURL2                         = "V2ResponseTests_ResourceResponse_ApiResource_createRenderURL2";
   public final static String               V2RESPONSETESTS_RESOURCERESPONSE_APIRESOURCE_CREATEACTIONURL2                         = "V2ResponseTests_ResourceResponse_ApiResource_createActionURL2";
   public final static String               V2RESPONSETESTS_RESOURCERESPONSE_APIRESOURCE_CREATERESOURCEURL2                       = "V2ResponseTests_ResourceResponse_ApiResource_createResourceURL2";
   public final static String               V2URLTESTS_BASEURL_APIRENDERRENURL_SETPARAMETERA1                                     = "V2URLTests_BaseURL_ApiRenderRenurl_setParameterA1";
   public final static String               V2URLTESTS_BASEURL_APIRENDERRENURL_SETPARAMETERA2                                     = "V2URLTests_BaseURL_ApiRenderRenurl_setParameterA2";
   public final static String               V2URLTESTS_BASEURL_APIRENDERRENURL_SETPARAMETERA3                                     = "V2URLTests_BaseURL_ApiRenderRenurl_setParameterA3";
   public final static String               V2URLTESTS_BASEURL_APIRENDERRENURL_SETPARAMETERA6                                     = "V2URLTests_BaseURL_ApiRenderRenurl_setParameterA6";
   public final static String               V2URLTESTS_BASEURL_APIRENDERRENURL_SETPARAMETERA7                                     = "V2URLTests_BaseURL_ApiRenderRenurl_setParameterA7";
   public final static String               V2URLTESTS_BASEURL_APIRENDERRENURL_SETPARAMETERA8                                     = "V2URLTests_BaseURL_ApiRenderRenurl_setParameterA8";
   public final static String               V2URLTESTS_BASEURL_APIRENDERRENURL_SETPARAMETERB1                                     = "V2URLTests_BaseURL_ApiRenderRenurl_setParameterB1";
   public final static String               V2URLTESTS_BASEURL_APIRENDERRENURL_SETPARAMETERB2                                     = "V2URLTests_BaseURL_ApiRenderRenurl_setParameterB2";
   public final static String               V2URLTESTS_BASEURL_APIRENDERRENURL_SETPARAMETERB3                                     = "V2URLTests_BaseURL_ApiRenderRenurl_setParameterB3";
   public final static String               V2URLTESTS_BASEURL_APIRENDERRENURL_SETPARAMETERB6                                     = "V2URLTests_BaseURL_ApiRenderRenurl_setParameterB6";
   public final static String               V2URLTESTS_BASEURL_APIRENDERRENURL_SETPARAMETERB7                                     = "V2URLTests_BaseURL_ApiRenderRenurl_setParameterB7";
   public final static String               V2URLTESTS_BASEURL_APIRENDERRENURL_SETPARAMETERB8                                     = "V2URLTests_BaseURL_ApiRenderRenurl_setParameterB8";
   public final static String               V2URLTESTS_BASEURL_APIRENDERRENURL_SETPARAMETERS1                                     = "V2URLTests_BaseURL_ApiRenderRenurl_setParameters1";
   public final static String               V2URLTESTS_BASEURL_APIRENDERRENURL_SETPARAMETERS2                                     = "V2URLTests_BaseURL_ApiRenderRenurl_setParameters2";
   public final static String               V2URLTESTS_BASEURL_APIRENDERRENURL_SETPARAMETERS3                                     = "V2URLTests_BaseURL_ApiRenderRenurl_setParameters3";
   public final static String               V2URLTESTS_BASEURL_APIRENDERRENURL_SETPARAMETERS6                                     = "V2URLTests_BaseURL_ApiRenderRenurl_setParameters6";
   public final static String               V2URLTESTS_BASEURL_APIRENDERRENURL_SETPARAMETERS7                                     = "V2URLTests_BaseURL_ApiRenderRenurl_setParameters7";
   public final static String               V2URLTESTS_BASEURL_APIRENDERRENURL_SETPARAMETERS8                                     = "V2URLTests_BaseURL_ApiRenderRenurl_setParameters8";
   public final static String               V2URLTESTS_BASEURL_APIRENDERRENURL_SETPARAMETERS9                                     = "V2URLTests_BaseURL_ApiRenderRenurl_setParameters9";
   public final static String               V2URLTESTS_BASEURL_APIRENDERRENURL_SETPARAMETERS10                                    = "V2URLTests_BaseURL_ApiRenderRenurl_setParameters10";
   public final static String               V2URLTESTS_BASEURL_APIRENDERRENURL_SETPARAMETERS12                                    = "V2URLTests_BaseURL_ApiRenderRenurl_setParameters12";
   public final static String               V2URLTESTS_BASEURL_APIRENDERRENURL_SETSECURE2                                         = "V2URLTests_BaseURL_ApiRenderRenurl_setSecure2";
   public final static String               V2URLTESTS_BASEURL_APIRENDERRENURL_TOSTRING                                           = "V2URLTests_BaseURL_ApiRenderRenurl_toString";
   public final static String               V2URLTESTS_BASEURL_APIRENDERRENURL_GETPARAMETERMAP1                                   = "V2URLTests_BaseURL_ApiRenderRenurl_getParameterMap1";
   public final static String               V2URLTESTS_BASEURL_APIRENDERRENURL_GETPARAMETERMAP2                                   = "V2URLTests_BaseURL_ApiRenderRenurl_getParameterMap2";
   public final static String               V2URLTESTS_BASEURL_APIRENDERRENURL_GETPARAMETERMAP6                                   = "V2URLTests_BaseURL_ApiRenderRenurl_getParameterMap6";
   public final static String               V2URLTESTS_BASEURL_APIRENDERRENURL_WRITEA1                                            = "V2URLTests_BaseURL_ApiRenderRenurl_writeA1";
   public final static String               V2URLTESTS_BASEURL_APIRENDERRENURL_WRITEB1                                            = "V2URLTests_BaseURL_ApiRenderRenurl_writeB1";
   public final static String               V2URLTESTS_BASEURL_APIRENDERRENURL_ADDPROPERTY1                                       = "V2URLTests_BaseURL_ApiRenderRenurl_addProperty1";
   public final static String               V2URLTESTS_BASEURL_APIRENDERRENURL_ADDPROPERTY3                                       = "V2URLTests_BaseURL_ApiRenderRenurl_addProperty3";
   public final static String               V2URLTESTS_BASEURL_APIRENDERRENURL_SETPROPERTY1                                       = "V2URLTests_BaseURL_ApiRenderRenurl_setProperty1";
   public final static String               V2URLTESTS_BASEURL_APIRENDERRENURL_SETPROPERTY3                                       = "V2URLTests_BaseURL_ApiRenderRenurl_setProperty3";
   public final static String               V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERA1                                     = "V2URLTests_BaseURL_ApiRenderActurl_setParameterA1";
   public final static String               V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERA4                                     = "V2URLTests_BaseURL_ApiRenderActurl_setParameterA4";
   public final static String               V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERA6                                     = "V2URLTests_BaseURL_ApiRenderActurl_setParameterA6";
   public final static String               V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERA7                                     = "V2URLTests_BaseURL_ApiRenderActurl_setParameterA7";
   public final static String               V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERA8                                     = "V2URLTests_BaseURL_ApiRenderActurl_setParameterA8";
   public final static String               V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERB1                                     = "V2URLTests_BaseURL_ApiRenderActurl_setParameterB1";
   public final static String               V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERB4                                     = "V2URLTests_BaseURL_ApiRenderActurl_setParameterB4";
   public final static String               V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERB6                                     = "V2URLTests_BaseURL_ApiRenderActurl_setParameterB6";
   public final static String               V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERB7                                     = "V2URLTests_BaseURL_ApiRenderActurl_setParameterB7";
   public final static String               V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERB8                                     = "V2URLTests_BaseURL_ApiRenderActurl_setParameterB8";
   public final static String               V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERS1                                     = "V2URLTests_BaseURL_ApiRenderActurl_setParameters1";
   public final static String               V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERS4                                     = "V2URLTests_BaseURL_ApiRenderActurl_setParameters4";
   public final static String               V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERS6                                     = "V2URLTests_BaseURL_ApiRenderActurl_setParameters6";
   public final static String               V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERS7                                     = "V2URLTests_BaseURL_ApiRenderActurl_setParameters7";
   public final static String               V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERS8                                     = "V2URLTests_BaseURL_ApiRenderActurl_setParameters8";
   public final static String               V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERS9                                     = "V2URLTests_BaseURL_ApiRenderActurl_setParameters9";
   public final static String               V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERS10                                    = "V2URLTests_BaseURL_ApiRenderActurl_setParameters10";
   public final static String               V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERS12                                    = "V2URLTests_BaseURL_ApiRenderActurl_setParameters12";
   public final static String               V2URLTESTS_BASEURL_APIRENDERACTURL_SETSECURE2                                         = "V2URLTests_BaseURL_ApiRenderActurl_setSecure2";
   public final static String               V2URLTESTS_BASEURL_APIRENDERACTURL_TOSTRING                                           = "V2URLTests_BaseURL_ApiRenderActurl_toString";
   public final static String               V2URLTESTS_BASEURL_APIRENDERACTURL_GETPARAMETERMAP1                                   = "V2URLTests_BaseURL_ApiRenderActurl_getParameterMap1";
   public final static String               V2URLTESTS_BASEURL_APIRENDERACTURL_GETPARAMETERMAP3                                   = "V2URLTests_BaseURL_ApiRenderActurl_getParameterMap3";
   public final static String               V2URLTESTS_BASEURL_APIRENDERACTURL_GETPARAMETERMAP6                                   = "V2URLTests_BaseURL_ApiRenderActurl_getParameterMap6";
   public final static String               V2URLTESTS_BASEURL_APIRENDERACTURL_WRITEA1                                            = "V2URLTests_BaseURL_ApiRenderActurl_writeA1";
   public final static String               V2URLTESTS_BASEURL_APIRENDERACTURL_WRITEB1                                            = "V2URLTests_BaseURL_ApiRenderActurl_writeB1";
   public final static String               V2URLTESTS_BASEURL_APIRENDERACTURL_ADDPROPERTY1                                       = "V2URLTests_BaseURL_ApiRenderActurl_addProperty1";
   public final static String               V2URLTESTS_BASEURL_APIRENDERACTURL_ADDPROPERTY3                                       = "V2URLTests_BaseURL_ApiRenderActurl_addProperty3";
   public final static String               V2URLTESTS_BASEURL_APIRENDERACTURL_SETPROPERTY1                                       = "V2URLTests_BaseURL_ApiRenderActurl_setProperty1";
   public final static String               V2URLTESTS_BASEURL_APIRENDERACTURL_SETPROPERTY3                                       = "V2URLTests_BaseURL_ApiRenderActurl_setProperty3";
   public final static String               V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERA1                                     = "V2URLTests_BaseURL_ApiRenderResurl_setParameterA1";
   public final static String               V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERA5                                     = "V2URLTests_BaseURL_ApiRenderResurl_setParameterA5";
   public final static String               V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERA6                                     = "V2URLTests_BaseURL_ApiRenderResurl_setParameterA6";
   public final static String               V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERA7                                     = "V2URLTests_BaseURL_ApiRenderResurl_setParameterA7";
   public final static String               V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERA8                                     = "V2URLTests_BaseURL_ApiRenderResurl_setParameterA8";
   public final static String               V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERB1                                     = "V2URLTests_BaseURL_ApiRenderResurl_setParameterB1";
   public final static String               V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERB5                                     = "V2URLTests_BaseURL_ApiRenderResurl_setParameterB5";
   public final static String               V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERB6                                     = "V2URLTests_BaseURL_ApiRenderResurl_setParameterB6";
   public final static String               V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERB7                                     = "V2URLTests_BaseURL_ApiRenderResurl_setParameterB7";
   public final static String               V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERB8                                     = "V2URLTests_BaseURL_ApiRenderResurl_setParameterB8";
   public final static String               V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERS1                                     = "V2URLTests_BaseURL_ApiRenderResurl_setParameters1";
   public final static String               V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERS5                                     = "V2URLTests_BaseURL_ApiRenderResurl_setParameters5";
   public final static String               V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERS6                                     = "V2URLTests_BaseURL_ApiRenderResurl_setParameters6";
   public final static String               V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERS7                                     = "V2URLTests_BaseURL_ApiRenderResurl_setParameters7";
   public final static String               V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERS8                                     = "V2URLTests_BaseURL_ApiRenderResurl_setParameters8";
   public final static String               V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERS9                                     = "V2URLTests_BaseURL_ApiRenderResurl_setParameters9";
   public final static String               V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERS10                                    = "V2URLTests_BaseURL_ApiRenderResurl_setParameters10";
   public final static String               V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERS12                                    = "V2URLTests_BaseURL_ApiRenderResurl_setParameters12";
   public final static String               V2URLTESTS_BASEURL_APIRENDERRESURL_SETSECURE2                                         = "V2URLTests_BaseURL_ApiRenderResurl_setSecure2";
   public final static String               V2URLTESTS_BASEURL_APIRENDERRESURL_TOSTRING                                           = "V2URLTests_BaseURL_ApiRenderResurl_toString";
   public final static String               V2URLTESTS_BASEURL_APIRENDERRESURL_GETPARAMETERMAP1                                   = "V2URLTests_BaseURL_ApiRenderResurl_getParameterMap1";
   public final static String               V2URLTESTS_BASEURL_APIRENDERRESURL_GETPARAMETERMAP4                                   = "V2URLTests_BaseURL_ApiRenderResurl_getParameterMap4";
   public final static String               V2URLTESTS_BASEURL_APIRENDERRESURL_GETPARAMETERMAP5                                   = "V2URLTests_BaseURL_ApiRenderResurl_getParameterMap5";
   public final static String               V2URLTESTS_BASEURL_APIRENDERRESURL_GETPARAMETERMAP6                                   = "V2URLTests_BaseURL_ApiRenderResurl_getParameterMap6";
   public final static String               V2URLTESTS_BASEURL_APIRENDERRESURL_WRITEA1                                            = "V2URLTests_BaseURL_ApiRenderResurl_writeA1";
   public final static String               V2URLTESTS_BASEURL_APIRENDERRESURL_WRITEB1                                            = "V2URLTests_BaseURL_ApiRenderResurl_writeB1";
   public final static String               V2URLTESTS_BASEURL_APIRENDERRESURL_ADDPROPERTY1                                       = "V2URLTests_BaseURL_ApiRenderResurl_addProperty1";
   public final static String               V2URLTESTS_BASEURL_APIRENDERRESURL_ADDPROPERTY3                                       = "V2URLTests_BaseURL_ApiRenderResurl_addProperty3";
   public final static String               V2URLTESTS_BASEURL_APIRENDERRESURL_SETPROPERTY1                                       = "V2URLTests_BaseURL_ApiRenderResurl_setProperty1";
   public final static String               V2URLTESTS_BASEURL_APIRENDERRESURL_SETPROPERTY3                                       = "V2URLTests_BaseURL_ApiRenderResurl_setProperty3";
   public final static String               V2URLTESTS_PORTLETURL_APIRENDERRENURL_SETWINDOWSTATE1                                 = "V2URLTests_PortletURL_ApiRenderRenurl_setWindowState1";
   public final static String               V2URLTESTS_PORTLETURL_APIRENDERRENURL_SETWINDOWSTATE2                                 = "V2URLTests_PortletURL_ApiRenderRenurl_setWindowState2";
   public final static String               V2URLTESTS_PORTLETURL_APIRENDERRENURL_SETPORTLETMODE1                                 = "V2URLTests_PortletURL_ApiRenderRenurl_setPortletMode1";
   public final static String               V2URLTESTS_PORTLETURL_APIRENDERRENURL_SETPORTLETMODE2                                 = "V2URLTests_PortletURL_ApiRenderRenurl_setPortletMode2";
   public final static String               V2URLTESTS_PORTLETURL_APIRENDERRENURL_SETPORTLETMODE3                                 = "V2URLTests_PortletURL_ApiRenderRenurl_setPortletMode3";
   public final static String               V2URLTESTS_PORTLETURL_APIRENDERRENURL_GETPORTLETMODE1                                 = "V2URLTests_PortletURL_ApiRenderRenurl_getPortletMode1";
   public final static String               V2URLTESTS_PORTLETURL_APIRENDERRENURL_GETPORTLETMODE2                                 = "V2URLTests_PortletURL_ApiRenderRenurl_getPortletMode2";
   public final static String               V2URLTESTS_PORTLETURL_APIRENDERRENURL_GETWINDOWSTATE1                                 = "V2URLTests_PortletURL_ApiRenderRenurl_getWindowState1";
   public final static String               V2URLTESTS_PORTLETURL_APIRENDERRENURL_GETWINDOWSTATE2                                 = "V2URLTests_PortletURL_ApiRenderRenurl_getWindowState2";
   public final static String               V2URLTESTS_PORTLETURL_APIRENDERRENURL_REMOVEPUBLICRENDERPARAMETER1                    = "V2URLTests_PortletURL_ApiRenderRenurl_removePublicRenderParameter1";
   public final static String               V2URLTESTS_PORTLETURL_APIRENDERRENURL_REMOVEPUBLICRENDERPARAMETER2                    = "V2URLTests_PortletURL_ApiRenderRenurl_removePublicRenderParameter2";
   public final static String               V2URLTESTS_PORTLETURL_APIRENDERACTURL_SETWINDOWSTATE1                                 = "V2URLTests_PortletURL_ApiRenderActurl_setWindowState1";
   public final static String               V2URLTESTS_PORTLETURL_APIRENDERACTURL_SETWINDOWSTATE2                                 = "V2URLTests_PortletURL_ApiRenderActurl_setWindowState2";
   public final static String               V2URLTESTS_PORTLETURL_APIRENDERACTURL_SETPORTLETMODE1                                 = "V2URLTests_PortletURL_ApiRenderActurl_setPortletMode1";
   public final static String               V2URLTESTS_PORTLETURL_APIRENDERACTURL_SETPORTLETMODE2                                 = "V2URLTests_PortletURL_ApiRenderActurl_setPortletMode2";
   public final static String               V2URLTESTS_PORTLETURL_APIRENDERACTURL_SETPORTLETMODE3                                 = "V2URLTests_PortletURL_ApiRenderActurl_setPortletMode3";
   public final static String               V2URLTESTS_PORTLETURL_APIRENDERACTURL_GETPORTLETMODE1                                 = "V2URLTests_PortletURL_ApiRenderActurl_getPortletMode1";
   public final static String               V2URLTESTS_PORTLETURL_APIRENDERACTURL_GETPORTLETMODE2                                 = "V2URLTests_PortletURL_ApiRenderActurl_getPortletMode2";
   public final static String               V2URLTESTS_PORTLETURL_APIRENDERACTURL_GETWINDOWSTATE1                                 = "V2URLTests_PortletURL_ApiRenderActurl_getWindowState1";
   public final static String               V2URLTESTS_PORTLETURL_APIRENDERACTURL_GETWINDOWSTATE2                                 = "V2URLTests_PortletURL_ApiRenderActurl_getWindowState2";
   public final static String               V2URLTESTS_PORTLETURL_APIRENDERACTURL_REMOVEPUBLICRENDERPARAMETER1                    = "V2URLTests_PortletURL_ApiRenderActurl_removePublicRenderParameter1";
   public final static String               V2URLTESTS_PORTLETURL_APIRENDERACTURL_REMOVEPUBLICRENDERPARAMETER2                    = "V2URLTests_PortletURL_ApiRenderActurl_removePublicRenderParameter2";
   public final static String               V2URLTESTS_RESOURCEURL_APIRENDERRESURL_FIELDFULL                                      = "V2URLTests_ResourceURL_ApiRenderResurl_fieldFULL";
   public final static String               V2URLTESTS_RESOURCEURL_APIRENDERRESURL_FIELDPAGE                                      = "V2URLTests_ResourceURL_ApiRenderResurl_fieldPAGE";
   public final static String               V2URLTESTS_RESOURCEURL_APIRENDERRESURL_FIELDPORTLET                                   = "V2URLTests_ResourceURL_ApiRenderResurl_fieldPORTLET";
   public final static String               V2URLTESTS_RESOURCEURL_APIRENDERRESURL_FIELDSHARED                                    = "V2URLTests_ResourceURL_ApiRenderResurl_fieldSHARED";
   public final static String               V2URLTESTS_RESOURCEURL_APIRENDERRESURL_RESOURCEURL4                                   = "V2URLTests_ResourceURL_ApiRenderResurl_resourceURL4";
   public final static String               V2URLTESTS_RESOURCEURL_APIRENDERRESURL_RESOURCEURL5                                   = "V2URLTests_ResourceURL_ApiRenderResurl_resourceURL5";
   public final static String               V2URLTESTS_RESOURCEURL_APIRENDERRESURL_RESOURCEURL6                                   = "V2URLTests_ResourceURL_ApiRenderResurl_resourceURL6";
   public final static String               V2URLTESTS_RESOURCEURL_APIRENDERRESURL_RESOURCEURL7                                   = "V2URLTests_ResourceURL_ApiRenderResurl_resourceURL7";
   public final static String               V2URLTESTS_RESOURCEURL_APIRENDERRESURL_RESOURCEURL8                                   = "V2URLTests_ResourceURL_ApiRenderResurl_resourceURL8";
   public final static String               V2URLTESTS_RESOURCEURL_APIRENDERRESURL_RESOURCEURL9                                   = "V2URLTests_ResourceURL_ApiRenderResurl_resourceURL9";
   public final static String               V2URLTESTS_RESOURCEURL_APIRENDERRESURL_SETRESOURCEID                                  = "V2URLTests_ResourceURL_ApiRenderResurl_setResourceID";
   public final static String               V2URLTESTS_RESOURCEURL_APIRENDERRESURL_GETCACHEABILITY                                = "V2URLTests_ResourceURL_ApiRenderResurl_getCacheability";
   public final static String               V2URLTESTS_RESOURCEURL_APIRENDERRESURL_SETCACHEABILITY1                               = "V2URLTests_ResourceURL_ApiRenderResurl_setCacheability1";
   public final static String               V2URLTESTS_RESOURCEURL_APIRENDERRESURL_SETCACHEABILITY2                               = "V2URLTests_ResourceURL_ApiRenderResurl_setCacheability2";
   public final static String               V2URLTESTS_RESOURCEURL_APIRENDERRESURL_SETCACHEABILITY3                               = "V2URLTests_ResourceURL_ApiRenderResurl_setCacheability3";
   public final static String               V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERACTURL_CONFIGURATION                 = "V2URLTests_PortletURLGenerationListener_ApiRenderActurl_configuration";
   public final static String               V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERACTURL_PORTLETURLGENERATIONLISTENER6 = "V2URLTests_PortletURLGenerationListener_ApiRenderActurl_portletURLGenerationListener6";
   public final static String               V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERACTURL_FILTERACTIONURL1              = "V2URLTests_PortletURLGenerationListener_ApiRenderActurl_filterActionURL1";
   public final static String               V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERACTURL_FILTERACTIONURL2              = "V2URLTests_PortletURLGenerationListener_ApiRenderActurl_filterActionURL2";
   public final static String               V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERACTURL_FILTERACTIONURL3              = "V2URLTests_PortletURLGenerationListener_ApiRenderActurl_filterActionURL3";
   public final static String               V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERACTURL_FILTERACTIONURL4              = "V2URLTests_PortletURLGenerationListener_ApiRenderActurl_filterActionURL4";
   public final static String               V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERACTURL_FILTERACTIONURL5              = "V2URLTests_PortletURLGenerationListener_ApiRenderActurl_filterActionURL5";
   public final static String               V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERRENURL_FILTERRENDERURL1              = "V2URLTests_PortletURLGenerationListener_ApiRenderRenurl_filterRenderURL1";
   public final static String               V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERRENURL_FILTERRENDERURL2              = "V2URLTests_PortletURLGenerationListener_ApiRenderRenurl_filterRenderURL2";
   public final static String               V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERRENURL_FILTERRENDERURL3              = "V2URLTests_PortletURLGenerationListener_ApiRenderRenurl_filterRenderURL3";
   public final static String               V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERRENURL_FILTERRENDERURL4              = "V2URLTests_PortletURLGenerationListener_ApiRenderRenurl_filterRenderURL4";
   public final static String               V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERRENURL_FILTERRENDERURL5              = "V2URLTests_PortletURLGenerationListener_ApiRenderRenurl_filterRenderURL5";
   public final static String               V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERRESURL_FILTERRESOURCEURL1            = "V2URLTests_PortletURLGenerationListener_ApiRenderResurl_filterResourceURL1";
   public final static String               V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERRESURL_FILTERRESOURCEURL2            = "V2URLTests_PortletURLGenerationListener_ApiRenderResurl_filterResourceURL2";
   public final static String               V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERRESURL_FILTERRESOURCEURL3            = "V2URLTests_PortletURLGenerationListener_ApiRenderResurl_filterResourceURL3";
   public final static String               V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERRESURL_FILTERRESOURCEURL4            = "V2URLTests_PortletURLGenerationListener_ApiRenderResurl_filterResourceURL4";
   public final static String               V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERRESURL_FILTERRESOURCEURL5            = "V2URLTests_PortletURLGenerationListener_ApiRenderResurl_filterResourceURL5";
   public final static String               V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERRESURL_FILTERRESOURCEURL7            = "V2URLTests_PortletURLGenerationListener_ApiRenderResurl_filterResourceURL7";
   public final static String               V2EXCEPTIONTESTS_PORTLETMODEEXCEPTION_APIRENDER_HASGETMODE2                           = "V2ExceptionTests_PortletModeException_ApiRender_hasGetMode2";
   public final static String               V2EXCEPTIONTESTS_UNAVAILABLEEXCEPTION_APIRENDER_ISPERMANENT1                          = "V2ExceptionTests_UnavailableException_ApiRender_isPermanent1";
   public final static String               V2EXCEPTIONTESTS_UNAVAILABLEEXCEPTION_APIRENDER_ISPERMANENT2                          = "V2ExceptionTests_UnavailableException_ApiRender_isPermanent2";
   public final static String               V2EXCEPTIONTESTS_UNAVAILABLEEXCEPTION_APIRENDER_ISPERMANENT3                          = "V2ExceptionTests_UnavailableException_ApiRender_isPermanent3";
   public final static String               V2EXCEPTIONTESTS_UNAVAILABLEEXCEPTION_APIRENDER_GETUNAVAILABLESECONDS1                = "V2ExceptionTests_UnavailableException_ApiRender_getUnavailableSeconds1";
   public final static String               V2EXCEPTIONTESTS_UNAVAILABLEEXCEPTION_APIRENDER_GETUNAVAILABLESECONDS2                = "V2ExceptionTests_UnavailableException_ApiRender_getUnavailableSeconds2";
   public final static String               V2EXCEPTIONTESTS_VALIDATOREXCEPTION_APIRENDER_CONSTRUCTOR2                            = "V2ExceptionTests_ValidatorException_ApiRender_constructor2";
   public final static String               V2EXCEPTIONTESTS_VALIDATOREXCEPTION_APIRENDER_CONSTRUCTOR4                            = "V2ExceptionTests_ValidatorException_ApiRender_constructor4";
   public final static String               V2EXCEPTIONTESTS_VALIDATOREXCEPTION_APIRENDER_CONSTRUCTOR6                            = "V2ExceptionTests_ValidatorException_ApiRender_constructor6";
   public final static String               V2EXCEPTIONTESTS_VALIDATOREXCEPTION_APIRENDER_GETFAILEDKEYS1                          = "V2ExceptionTests_ValidatorException_ApiRender_getFailedKeys1";
   public final static String               V2EXCEPTIONTESTS_VALIDATOREXCEPTION_APIRENDER_GETFAILEDKEYS2                          = "V2ExceptionTests_ValidatorException_ApiRender_getFailedKeys2";
   public final static String               V2EXCEPTIONTESTS_WINDOWSTATEEXCEPTION_APIRENDER_GETSTATE                              = "V2ExceptionTests_WindowStateException_ApiRender_getState";
   public final static String               V2ANNOTATIONTESTS_PROCESSACTION_APIACTION_NAME                                        = "V2AnnotationTests_ProcessAction_ApiAction_name";
   public final static String               V2ANNOTATIONTESTS_PROCESSEVENT_APIEVENT_QNAME                                         = "V2AnnotationTests_ProcessEvent_ApiEvent_qname";
   public final static String               V2ANNOTATIONTESTS_PROCESSEVENT_APIEVENT_NAME                                          = "V2AnnotationTests_ProcessEvent_ApiEvent_name";
   public final static String               V2ANNOTATIONTESTS_RENDERMODE_APIRENDER_NAME                                           = "V2AnnotationTests_RenderMode_ApiRender_name";
   public final static String               V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETPORTLETNAME                                 = "V2PortletTests_PortletConfig_ApiRender_getPortletName";
   public final static String               V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETPORTLETCONTEXT                              = "V2PortletTests_PortletConfig_ApiRender_getPortletContext";
   public final static String               V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETRESOURCEBUNDLE                              = "V2PortletTests_PortletConfig_ApiRender_getResourceBundle";
   public final static String               V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETINITPARAMETER1                              = "V2PortletTests_PortletConfig_ApiRender_getInitParameter1";
   public final static String               V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETINITPARAMETER3                              = "V2PortletTests_PortletConfig_ApiRender_getInitParameter3";
   public final static String               V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETINITPARAMETERNAMES1                         = "V2PortletTests_PortletConfig_ApiRender_getInitParameterNames1";
   public final static String               V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETPUBLICRENDERPARAMETERNAMES1                 = "V2PortletTests_PortletConfig_ApiRender_getPublicRenderParameterNames1";
   public final static String               V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETDEFAULTNAMESPACE1                           = "V2PortletTests_PortletConfig_ApiRender_getDefaultNamespace1";
   public final static String               V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETPUBLISHINGEVENTQNAMES1                      = "V2PortletTests_PortletConfig_ApiRender_getPublishingEventQNames1";
   public final static String               V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETPROCESSINGEVENTQNAMES1                      = "V2PortletTests_PortletConfig_ApiRender_getProcessingEventQNames1";
   public final static String               V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETSUPPORTEDLOCALES1                           = "V2PortletTests_PortletConfig_ApiRender_getSupportedLocales1";
   public final static String               V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETCONTAINERRUNTIMEOPTIONS1                    = "V2PortletTests_PortletConfig_ApiRender_getContainerRuntimeOptions1";
   public final static String               V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETCONTAINERRUNTIMEOPTIONS2                    = "V2PortletTests_PortletConfig_ApiRender_getContainerRuntimeOptions2";
   public final static String               V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETCONTAINERRUNTIMEOPTIONS3                    = "V2PortletTests_PortletConfig_ApiRender_getContainerRuntimeOptions3";
   public final static String               V2PORTLETTESTS_PORTLETCONFIG_APIRENDER2_GETINITPARAMETER2                             = "V2PortletTests_PortletConfig_ApiRender2_getInitParameter2";
   public final static String               V2PORTLETTESTS_PORTLETCONFIG_APIRENDER2_GETINITPARAMETERNAMES2                        = "V2PortletTests_PortletConfig_ApiRender2_getInitParameterNames2";
   public final static String               V2PORTLETTESTS_PORTLETCONFIG_APIRENDER2_GETPUBLICRENDERPARAMETERNAMES2                = "V2PortletTests_PortletConfig_ApiRender2_getPublicRenderParameterNames2";
   public final static String               V2PORTLETTESTS_PORTLETCONFIG_APIRENDER2_GETPUBLISHINGEVENTQNAMES2                     = "V2PortletTests_PortletConfig_ApiRender2_getPublishingEventQNames2";
   public final static String               V2PORTLETTESTS_PORTLETCONFIG_APIRENDER2_GETPROCESSINGEVENTQNAMES2                     = "V2PortletTests_PortletConfig_ApiRender2_getProcessingEventQNames2";
   public final static String               V2PORTLETTESTS_PORTLETCONFIG_APIRENDER2_GETSUPPORTEDLOCALES2                          = "V2PortletTests_PortletConfig_ApiRender2_getSupportedLocales2";
   public final static String               V2PORTLETTESTS_PORTLETMODE_APIRENDER_CONSTRUCTOR1                                     = "V2PortletTests_PortletMode_ApiRender_constructor1";
   public final static String               V2PORTLETTESTS_PORTLETMODE_APIRENDER_CONSTRUCTOR2                                     = "V2PortletTests_PortletMode_ApiRender_constructor2";
   public final static String               V2PORTLETTESTS_PORTLETMODE_APIRENDER_FIELDEDIT                                        = "V2PortletTests_PortletMode_ApiRender_fieldEDIT";
   public final static String               V2PORTLETTESTS_PORTLETMODE_APIRENDER_FIELDHELP                                        = "V2PortletTests_PortletMode_ApiRender_fieldHELP";
   public final static String               V2PORTLETTESTS_PORTLETMODE_APIRENDER_FIELDVIEW                                        = "V2PortletTests_PortletMode_ApiRender_fieldVIEW";
   public final static String               V2PORTLETTESTS_PORTLETMODE_APIRENDER_TOSTRING                                         = "V2PortletTests_PortletMode_ApiRender_toString";
   public final static String               V2PORTLETTESTS_PORTLETMODE_APIRENDER_HASHCODE                                         = "V2PortletTests_PortletMode_ApiRender_hashCode";
   public final static String               V2PORTLETTESTS_PORTLETMODE_APIRENDER_EQUALS                                           = "V2PortletTests_PortletMode_ApiRender_equals";
   public final static String               V2PORTLETTESTS_WINDOWSTATE_APIRENDER_CONSTRUCTOR1                                     = "V2PortletTests_WindowState_ApiRender_constructor1";
   public final static String               V2PORTLETTESTS_WINDOWSTATE_APIRENDER_CONSTRUCTOR2                                     = "V2PortletTests_WindowState_ApiRender_constructor2";
   public final static String               V2PORTLETTESTS_WINDOWSTATE_APIRENDER_FIELDMAXIMIZED                                   = "V2PortletTests_WindowState_ApiRender_fieldMAXIMIZED";
   public final static String               V2PORTLETTESTS_WINDOWSTATE_APIRENDER_FIELDMINIMIZED                                   = "V2PortletTests_WindowState_ApiRender_fieldMINIMIZED";
   public final static String               V2PORTLETTESTS_WINDOWSTATE_APIRENDER_FIELDNORMAL                                      = "V2PortletTests_WindowState_ApiRender_fieldNORMAL";
   public final static String               V2PORTLETTESTS_WINDOWSTATE_APIRENDER_TOSTRING                                         = "V2PortletTests_WindowState_ApiRender_toString";
   public final static String               V2PORTLETTESTS_WINDOWSTATE_APIRENDER_HASHCODE                                         = "V2PortletTests_WindowState_ApiRender_hashCode";
   public final static String               V2PORTLETTESTS_WINDOWSTATE_APIRENDER_EQUALS                                           = "V2PortletTests_WindowState_ApiRender_equals";
   public final static String               V2PORTLETTESTS_PORTLET_APIRENDER_INIT1                                                = "V2PortletTests_Portlet_ApiRender_init1";
   public final static String               V2PORTLETTESTS_PORTLET_APIRENDER_RENDER1                                              = "V2PortletTests_Portlet_ApiRender_render1";
   public final static String               V2PORTLETTESTS_PORTLET_APIRENDER_RENDER2                                              = "V2PortletTests_Portlet_ApiRender_render2";
   public final static String               V2PORTLETTESTS_PORTLET_APIACTION_PROCESSACTION                                        = "V2PortletTests_Portlet_ApiAction_processAction";
   public final static String               V2PORTLETTESTS_EVENT_APIEVENT_GETQNAME1                                               = "V2PortletTests_Event_ApiEvent_getQName1";
   public final static String               V2PORTLETTESTS_EVENT_APIEVENT_GETQNAME2                                               = "V2PortletTests_Event_ApiEvent_getQName2";
   public final static String               V2PORTLETTESTS_EVENT_APIEVENT_GETNAME1                                                = "V2PortletTests_Event_ApiEvent_getName1";
   public final static String               V2PORTLETTESTS_EVENT_APIEVENT_GETNAME2                                                = "V2PortletTests_Event_ApiEvent_getName2";
   public final static String               V2PORTLETTESTS_EVENT_APIEVENT_GETVALUE1                                               = "V2PortletTests_Event_ApiEvent_getValue1";
   public final static String               V2PORTLETTESTS_EVENT_APIEVENT_GETVALUE2                                               = "V2PortletTests_Event_ApiEvent_getValue2";
   public final static String               V2PORTLETTESTS_EVENTPORTLET_APIEVENT_PROCESSEVENT                                     = "V2PortletTests_EventPortlet_ApiEvent_processEvent";
   public final static String               V2PORTLETTESTS_RESOURCESERVINGPORTLET_APIRESOURCE_SERVERESOURCE                       = "V2PortletTests_ResourceServingPortlet_ApiResource_serveResource";
   public final static String               V2PORTLETTESTS_GENERICPORTLET_APIRENDER_INITA                                         = "V2PortletTests_GenericPortlet_ApiRender_initA";
   public final static String               V2PORTLETTESTS_GENERICPORTLET_APIRENDER_INITB                                         = "V2PortletTests_GenericPortlet_ApiRender_initB";
   public final static String               V2PORTLETTESTS_GENERICPORTLET_APIRENDER_PROCESSACTION2                                = "V2PortletTests_GenericPortlet_ApiRender_processAction2";
   public final static String               V2PORTLETTESTS_GENERICPORTLET_APIRENDER_PROCESSACTION3                                = "V2PortletTests_GenericPortlet_ApiRender_processAction3";
   public final static String               V2PORTLETTESTS_GENERICPORTLET_APIRENDER_GETTITLE1                                     = "V2PortletTests_GenericPortlet_ApiRender_getTitle1";
   public final static String               V2PORTLETTESTS_GENERICPORTLET_APIRENDER_GETTITLE2                                     = "V2PortletTests_GenericPortlet_ApiRender_getTitle2";
   public final static String               V2PORTLETTESTS_GENERICPORTLET_APIRENDER_DODISPATCH1                                   = "V2PortletTests_GenericPortlet_ApiRender_doDispatch1";
   public final static String               V2PORTLETTESTS_GENERICPORTLET_APIRENDER_DOVIEW1                                       = "V2PortletTests_GenericPortlet_ApiRender_doView1";
   public final static String               V2PORTLETTESTS_GENERICPORTLET_APIRENDER_GETPORTLETCONFIG                              = "V2PortletTests_GenericPortlet_ApiRender_getPortletConfig";

   public final static String               V2PORTLETTESTS_GENERICPORTLET_APIRENDER_GETNEXTPOSSIBLEPORTLETMODES1                  = "V2PortletTests_GenericPortlet_ApiRender_getNextPossiblePortletModes1";
   public final static String               V2ENVIRONMENTTESTS_CACHECONTROL_APIRENDER_GETEXPIRATIONTIME1                          = "V2EnvironmentTests_CacheControl_ApiRender_getExpirationTime1";
   public final static String               V2ENVIRONMENTTESTS_CACHECONTROL_APIRENDER_GETEXPIRATIONTIME2                          = "V2EnvironmentTests_CacheControl_ApiRender_getExpirationTime2";
   public final static String               V2ENVIRONMENTTESTS_CACHECONTROL_APIRENDER_GETEXPIRATIONTIME3                          = "V2EnvironmentTests_CacheControl_ApiRender_getExpirationTime3";
   public final static String               V2ENVIRONMENTTESTS_CACHECONTROL_APIRENDER_SETEXPIRATIONTIME1                          = "V2EnvironmentTests_CacheControl_ApiRender_setExpirationTime1";
   public final static String               V2ENVIRONMENTTESTS_CACHECONTROL_APIRENDER_SETEXPIRATIONTIME2                          = "V2EnvironmentTests_CacheControl_ApiRender_setExpirationTime2";
   public final static String               V2ENVIRONMENTTESTS_CACHECONTROL_APIRENDER_SETEXPIRATIONTIME3                          = "V2EnvironmentTests_CacheControl_ApiRender_setExpirationTime3";
   public final static String               V2ENVIRONMENTTESTS_CACHECONTROL_APIRENDER_ISPUBLICSCOPE1                              = "V2EnvironmentTests_CacheControl_ApiRender_isPublicScope1";
   public final static String               V2ENVIRONMENTTESTS_CACHECONTROL_APIRENDER_ISPUBLICSCOPE2                              = "V2EnvironmentTests_CacheControl_ApiRender_isPublicScope2";
   public final static String               V2ENVIRONMENTTESTS_CACHECONTROL_APIRENDER_ISPUBLICSCOPE3                              = "V2EnvironmentTests_CacheControl_ApiRender_isPublicScope3";
   public final static String               V2ENVIRONMENTTESTS_CACHECONTROL_APIRENDER_ISPUBLICSCOPE5                              = "V2EnvironmentTests_CacheControl_ApiRender_isPublicScope5";
   public final static String               V2ENVIRONMENTTESTS_CACHECONTROL_APIRENDER_SETPUBLICSCOPE1                             = "V2EnvironmentTests_CacheControl_ApiRender_setPublicScope1";
   public final static String               V2ENVIRONMENTTESTS_CACHECONTROL_APIRENDER_SETPUBLICSCOPE2                             = "V2EnvironmentTests_CacheControl_ApiRender_setPublicScope2";
   public final static String               V2ENVIRONMENTTESTS_CACHECONTROL_APIRENDER_GETETAG1                                    = "V2EnvironmentTests_CacheControl_ApiRender_getETag1";
   public final static String               V2ENVIRONMENTTESTS_CACHECONTROL_APIRENDER_GETETAG2                                    = "V2EnvironmentTests_CacheControl_ApiRender_getETag2";
   public final static String               V2ENVIRONMENTTESTS_CACHECONTROL_APIRENDER_SETETAG1                                    = "V2EnvironmentTests_CacheControl_ApiRender_setETag1";
   public final static String               V2ENVIRONMENTTESTS_CACHECONTROL_APIRENDER_SETETAG2                                    = "V2EnvironmentTests_CacheControl_ApiRender_setETag2";
   public final static String               V2ENVIRONMENTTESTS_CACHECONTROL_APIRENDER_SETETAG3                                    = "V2EnvironmentTests_CacheControl_ApiRender_setETag3";
   public final static String               V2ENVIRONMENTTESTS_CACHECONTROL_APIRENDER_USECACHEDCONTENT1                           = "V2EnvironmentTests_CacheControl_ApiRender_useCachedContent1";
   public final static String               V2ENVIRONMENTTESTS_CACHECONTROL_APIRENDER_USECACHEDCONTENT2                           = "V2EnvironmentTests_CacheControl_ApiRender_useCachedContent2";
   public final static String               V2ENVIRONMENTTESTS_CACHECONTROL_APIRENDER_USECACHEDCONTENT3                           = "V2EnvironmentTests_CacheControl_ApiRender_useCachedContent3";
   public final static String               V2ENVIRONMENTTESTS_CACHECONTROL_APIRENDER_SETUSECACHEDCONTENT1                        = "V2EnvironmentTests_CacheControl_ApiRender_setUseCachedContent1";
   public final static String               V2ENVIRONMENTTESTS_CACHECONTROL_APIRENDER_SETUSECACHEDCONTENT2                        = "V2EnvironmentTests_CacheControl_ApiRender_setUseCachedContent2";
   public final static String               V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_GETEXPIRATIONTIME1                        = "V2EnvironmentTests_CacheControl_ApiResource_getExpirationTime1";
   public final static String               V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_GETEXPIRATIONTIME2                        = "V2EnvironmentTests_CacheControl_ApiResource_getExpirationTime2";
   public final static String               V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_GETEXPIRATIONTIME3                        = "V2EnvironmentTests_CacheControl_ApiResource_getExpirationTime3";
   public final static String               V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_SETEXPIRATIONTIME1                        = "V2EnvironmentTests_CacheControl_ApiResource_setExpirationTime1";
   public final static String               V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_SETEXPIRATIONTIME2                        = "V2EnvironmentTests_CacheControl_ApiResource_setExpirationTime2";
   public final static String               V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_SETEXPIRATIONTIME3                        = "V2EnvironmentTests_CacheControl_ApiResource_setExpirationTime3";
   public final static String               V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_ISPUBLICSCOPE1                            = "V2EnvironmentTests_CacheControl_ApiResource_isPublicScope1";
   public final static String               V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_ISPUBLICSCOPE2                            = "V2EnvironmentTests_CacheControl_ApiResource_isPublicScope2";
   public final static String               V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_ISPUBLICSCOPE3                            = "V2EnvironmentTests_CacheControl_ApiResource_isPublicScope3";
   public final static String               V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_ISPUBLICSCOPE5                            = "V2EnvironmentTests_CacheControl_ApiResource_isPublicScope5";
   public final static String               V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_SETPUBLICSCOPE1                           = "V2EnvironmentTests_CacheControl_ApiResource_setPublicScope1";
   public final static String               V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_SETPUBLICSCOPE2                           = "V2EnvironmentTests_CacheControl_ApiResource_setPublicScope2";
   public final static String               V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_GETETAG1                                  = "V2EnvironmentTests_CacheControl_ApiResource_getETag1";
   public final static String               V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_GETETAG2                                  = "V2EnvironmentTests_CacheControl_ApiResource_getETag2";
   public final static String               V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_SETETAG1                                  = "V2EnvironmentTests_CacheControl_ApiResource_setETag1";
   public final static String               V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_SETETAG2                                  = "V2EnvironmentTests_CacheControl_ApiResource_setETag2";
   public final static String               V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_SETETAG3                                  = "V2EnvironmentTests_CacheControl_ApiResource_setETag3";
   public final static String               V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_USECACHEDCONTENT1                         = "V2EnvironmentTests_CacheControl_ApiResource_useCachedContent1";
   public final static String               V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_USECACHEDCONTENT2                         = "V2EnvironmentTests_CacheControl_ApiResource_useCachedContent2";
   public final static String               V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_USECACHEDCONTENT3                         = "V2EnvironmentTests_CacheControl_ApiResource_useCachedContent3";
   public final static String               V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_SETUSECACHEDCONTENT1                      = "V2EnvironmentTests_CacheControl_ApiResource_setUseCachedContent1";
   public final static String               V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_SETUSECACHEDCONTENT2                      = "V2EnvironmentTests_CacheControl_ApiResource_setUseCachedContent2";
   public final static String               V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_FIELDMARKUP_HEAD_ELEMENT_SUPPORT           = "V2EnvironmentTests_PortalContext_ApiRender_fieldMARKUP_HEAD_ELEMENT_SUPPORT";
   public final static String               V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETPROPERTY1                               = "V2EnvironmentTests_PortalContext_ApiRender_getProperty1";
   public final static String               V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETPROPERTY2                               = "V2EnvironmentTests_PortalContext_ApiRender_getProperty2";
   public final static String               V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETPROPERTY3                               = "V2EnvironmentTests_PortalContext_ApiRender_getProperty3";
   public final static String               V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETPROPERTYNAMES1                          = "V2EnvironmentTests_PortalContext_ApiRender_getPropertyNames1";
   public final static String               V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETPROPERTYNAMES2                          = "V2EnvironmentTests_PortalContext_ApiRender_getPropertyNames2";
   public final static String               V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETSUPPORTEDPORTLETMODES1                  = "V2EnvironmentTests_PortalContext_ApiRender_getSupportedPortletModes1";
   public final static String               V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETSUPPORTEDPORTLETMODES2                  = "V2EnvironmentTests_PortalContext_ApiRender_getSupportedPortletModes2";
   public final static String               V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETSUPPORTEDPORTLETMODES3                  = "V2EnvironmentTests_PortalContext_ApiRender_getSupportedPortletModes3";
   public final static String               V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETSUPPORTEDPORTLETMODES4                  = "V2EnvironmentTests_PortalContext_ApiRender_getSupportedPortletModes4";
   public final static String               V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETSUPPORTEDWINDOWSTATES1                  = "V2EnvironmentTests_PortalContext_ApiRender_getSupportedWindowStates1";
   public final static String               V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETSUPPORTEDWINDOWSTATES2                  = "V2EnvironmentTests_PortalContext_ApiRender_getSupportedWindowStates2";
   public final static String               V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETSUPPORTEDWINDOWSTATES3                  = "V2EnvironmentTests_PortalContext_ApiRender_getSupportedWindowStates3";
   public final static String               V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETSUPPORTEDWINDOWSTATES4                  = "V2EnvironmentTests_PortalContext_ApiRender_getSupportedWindowStates4";
   public final static String               V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETPORTALINFO1                             = "V2EnvironmentTests_PortalContext_ApiRender_getPortalInfo1";
   public final static String               V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETSERVERINFO1                            = "V2EnvironmentTests_PortletContext_ApiRender_getServerInfo1";
   public final static String               V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETREQUESTDISPATCHER1                     = "V2EnvironmentTests_PortletContext_ApiRender_getRequestDispatcher1";
   public final static String               V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETREQUESTDISPATCHER2                     = "V2EnvironmentTests_PortletContext_ApiRender_getRequestDispatcher2";
   public final static String               V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETREQUESTDISPATCHER3                     = "V2EnvironmentTests_PortletContext_ApiRender_getRequestDispatcher3";
   public final static String               V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETNAMEDDISPATCHER1                       = "V2EnvironmentTests_PortletContext_ApiRender_getNamedDispatcher1";
   public final static String               V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETNAMEDDISPATCHER2                       = "V2EnvironmentTests_PortletContext_ApiRender_getNamedDispatcher2";
   public final static String               V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETRESOURCEASSTREAM1                      = "V2EnvironmentTests_PortletContext_ApiRender_getResourceAsStream1";
   public final static String               V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETRESOURCEASSTREAM2                      = "V2EnvironmentTests_PortletContext_ApiRender_getResourceAsStream2";
   public final static String               V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETRESOURCEASSTREAM3                      = "V2EnvironmentTests_PortletContext_ApiRender_getResourceAsStream3";
   public final static String               V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETMAJORVERSION                           = "V2EnvironmentTests_PortletContext_ApiRender_getMajorVersion";
   public final static String               V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETMINORVERSION                           = "V2EnvironmentTests_PortletContext_ApiRender_getMinorVersion";
   public final static String               V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETMIMETYPE1                              = "V2EnvironmentTests_PortletContext_ApiRender_getMimeType1";
   public final static String               V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETMIMETYPE2                              = "V2EnvironmentTests_PortletContext_ApiRender_getMimeType2";
   public final static String               V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETMIMETYPE3                              = "V2EnvironmentTests_PortletContext_ApiRender_getMimeType3";
   public final static String               V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETMIMETYPE4                              = "V2EnvironmentTests_PortletContext_ApiRender_getMimeType4";
   public final static String               V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETMIMETYPE5                              = "V2EnvironmentTests_PortletContext_ApiRender_getMimeType5";
   public final static String               V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETREALPATH1                              = "V2EnvironmentTests_PortletContext_ApiRender_getRealPath1";
   public final static String               V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETREALPATH2                              = "V2EnvironmentTests_PortletContext_ApiRender_getRealPath2";
   public final static String               V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETREALPATH3                              = "V2EnvironmentTests_PortletContext_ApiRender_getRealPath3";
   public final static String               V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETRESOURCEPATHS1                         = "V2EnvironmentTests_PortletContext_ApiRender_getResourcePaths1";
   public final static String               V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETRESOURCEPATHS2                         = "V2EnvironmentTests_PortletContext_ApiRender_getResourcePaths2";
   public final static String               V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETRESOURCEPATHS3                         = "V2EnvironmentTests_PortletContext_ApiRender_getResourcePaths3";
   public final static String               V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETRESOURCEPATHS4                         = "V2EnvironmentTests_PortletContext_ApiRender_getResourcePaths4";
   public final static String               V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETRESOURCE1                              = "V2EnvironmentTests_PortletContext_ApiRender_getResource1";
   public final static String               V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETRESOURCE2                              = "V2EnvironmentTests_PortletContext_ApiRender_getResource2";
   public final static String               V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETRESOURCE3                              = "V2EnvironmentTests_PortletContext_ApiRender_getResource3";
   public final static String               V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETRESOURCE4                              = "V2EnvironmentTests_PortletContext_ApiRender_getResource4";
   public final static String               V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETATTRIBUTE1                             = "V2EnvironmentTests_PortletContext_ApiRender_getAttribute1";
   public final static String               V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETATTRIBUTE2                             = "V2EnvironmentTests_PortletContext_ApiRender_getAttribute2";
   public final static String               V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETATTRIBUTE3                             = "V2EnvironmentTests_PortletContext_ApiRender_getAttribute3";
   public final static String               V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETATTRIBUTENAMES1                        = "V2EnvironmentTests_PortletContext_ApiRender_getAttributeNames1";
   public final static String               V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETATTRIBUTENAMES2                        = "V2EnvironmentTests_PortletContext_ApiRender_getAttributeNames2";
   public final static String               V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETINITPARAMETER1                         = "V2EnvironmentTests_PortletContext_ApiRender_getInitParameter1";
   public final static String               V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETINITPARAMETER2                         = "V2EnvironmentTests_PortletContext_ApiRender_getInitParameter2";
   public final static String               V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETINITPARAMETER3                         = "V2EnvironmentTests_PortletContext_ApiRender_getInitParameter3";
   public final static String               V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETINITPARAMETERNAMES1                    = "V2EnvironmentTests_PortletContext_ApiRender_getInitParameterNames1";
   public final static String               V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETINITPARAMETERNAMES2                    = "V2EnvironmentTests_PortletContext_ApiRender_getInitParameterNames2";
   public final static String               V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_LOGA                                      = "V2EnvironmentTests_PortletContext_ApiRender_logA";
   public final static String               V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_LOGB                                      = "V2EnvironmentTests_PortletContext_ApiRender_logB";
   public final static String               V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_REMOVEATTRIBUTE1                          = "V2EnvironmentTests_PortletContext_ApiRender_removeAttribute1";
   public final static String               V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_REMOVEATTRIBUTE2                          = "V2EnvironmentTests_PortletContext_ApiRender_removeAttribute2";
   public final static String               V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_SETATTRIBUTE1                             = "V2EnvironmentTests_PortletContext_ApiRender_setAttribute1";
   public final static String               V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_SETATTRIBUTE2                             = "V2EnvironmentTests_PortletContext_ApiRender_setAttribute2";
   public final static String               V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_SETATTRIBUTE3                             = "V2EnvironmentTests_PortletContext_ApiRender_setAttribute3";
   public final static String               V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_SETATTRIBUTE4                             = "V2EnvironmentTests_PortletContext_ApiRender_setAttribute4";
   public final static String               V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETPORTLETCONTEXTNAME1                    = "V2EnvironmentTests_PortletContext_ApiRender_getPortletContextName1";
   public final static String               V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETPORTLETCONTEXTNAME2                    = "V2EnvironmentTests_PortletContext_ApiRender_getPortletContextName2";
   public final static String               V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETPORTLETCONTEXTNAME3                    = "V2EnvironmentTests_PortletContext_ApiRender_getPortletContextName3";
   public final static String               V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETCONTAINERRUNTIMEOPTIONS1               = "V2EnvironmentTests_PortletContext_ApiRender_getContainerRuntimeOptions1";
   public final static String               V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETCONTAINERRUNTIMEOPTIONS2               = "V2EnvironmentTests_PortletContext_ApiRender_getContainerRuntimeOptions2";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_ISREADONLY1                           = "V2EnvironmentTests_PortletPreferences_ApiRender_isReadOnly1";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_ISREADONLY2                           = "V2EnvironmentTests_PortletPreferences_ApiRender_isReadOnly2";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_ISREADONLY3                           = "V2EnvironmentTests_PortletPreferences_ApiRender_isReadOnly3";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_ISREADONLY4                           = "V2EnvironmentTests_PortletPreferences_ApiRender_isReadOnly4";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_GETVALUE1                             = "V2EnvironmentTests_PortletPreferences_ApiRender_getValue1";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_GETVALUE2                             = "V2EnvironmentTests_PortletPreferences_ApiRender_getValue2";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_GETVALUE3                             = "V2EnvironmentTests_PortletPreferences_ApiRender_getValue3";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_GETVALUE4                             = "V2EnvironmentTests_PortletPreferences_ApiRender_getValue4";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_GETVALUES1                            = "V2EnvironmentTests_PortletPreferences_ApiRender_getValues1";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_GETVALUES2                            = "V2EnvironmentTests_PortletPreferences_ApiRender_getValues2";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_GETVALUES3                            = "V2EnvironmentTests_PortletPreferences_ApiRender_getValues3";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_GETVALUES4                            = "V2EnvironmentTests_PortletPreferences_ApiRender_getValues4";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_SETVALUE4                             = "V2EnvironmentTests_PortletPreferences_ApiRender_setValue4";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_GETNAMES1                             = "V2EnvironmentTests_PortletPreferences_ApiRender_getNames1";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_GETNAMES2                             = "V2EnvironmentTests_PortletPreferences_ApiRender_getNames2";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_GETMAP1                               = "V2EnvironmentTests_PortletPreferences_ApiRender_getMap1";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_GETMAP2                               = "V2EnvironmentTests_PortletPreferences_ApiRender_getMap2";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_RESET2                                = "V2EnvironmentTests_PortletPreferences_ApiRender_reset2";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_STORE5                                = "V2EnvironmentTests_PortletPreferences_ApiRender_store5";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_ISREADONLY1                           = "V2EnvironmentTests_PortletPreferences_ApiAction_isReadOnly1";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_ISREADONLY2                           = "V2EnvironmentTests_PortletPreferences_ApiAction_isReadOnly2";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_ISREADONLY3                           = "V2EnvironmentTests_PortletPreferences_ApiAction_isReadOnly3";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_ISREADONLY4                           = "V2EnvironmentTests_PortletPreferences_ApiAction_isReadOnly4";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_GETVALUE1                             = "V2EnvironmentTests_PortletPreferences_ApiAction_getValue1";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_GETVALUE2                             = "V2EnvironmentTests_PortletPreferences_ApiAction_getValue2";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_GETVALUE3                             = "V2EnvironmentTests_PortletPreferences_ApiAction_getValue3";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_GETVALUE4                             = "V2EnvironmentTests_PortletPreferences_ApiAction_getValue4";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_GETVALUES1                            = "V2EnvironmentTests_PortletPreferences_ApiAction_getValues1";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_GETVALUES2                            = "V2EnvironmentTests_PortletPreferences_ApiAction_getValues2";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_GETVALUES3                            = "V2EnvironmentTests_PortletPreferences_ApiAction_getValues3";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_GETVALUES4                            = "V2EnvironmentTests_PortletPreferences_ApiAction_getValues4";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_SETVALUE1                             = "V2EnvironmentTests_PortletPreferences_ApiAction_setValue1";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_SETVALUE2                             = "V2EnvironmentTests_PortletPreferences_ApiAction_setValue2";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_SETVALUE3                             = "V2EnvironmentTests_PortletPreferences_ApiAction_setValue3";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_SETVALUE4                             = "V2EnvironmentTests_PortletPreferences_ApiAction_setValue4";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_SETVALUE5                             = "V2EnvironmentTests_PortletPreferences_ApiAction_setValue5";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_SETVALUES1                            = "V2EnvironmentTests_PortletPreferences_ApiAction_setValues1";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_SETVALUES2                            = "V2EnvironmentTests_PortletPreferences_ApiAction_setValues2";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_SETVALUES3                            = "V2EnvironmentTests_PortletPreferences_ApiAction_setValues3";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_SETVALUES4                            = "V2EnvironmentTests_PortletPreferences_ApiAction_setValues4";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_SETVALUES5                            = "V2EnvironmentTests_PortletPreferences_ApiAction_setValues5";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_SETVALUES6                            = "V2EnvironmentTests_PortletPreferences_ApiAction_setValues6";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_GETNAMES1                             = "V2EnvironmentTests_PortletPreferences_ApiAction_getNames1";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_GETNAMES2                             = "V2EnvironmentTests_PortletPreferences_ApiAction_getNames2";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_GETMAP1                               = "V2EnvironmentTests_PortletPreferences_ApiAction_getMap1";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_GETMAP2                               = "V2EnvironmentTests_PortletPreferences_ApiAction_getMap2";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_RESET1                                = "V2EnvironmentTests_PortletPreferences_ApiAction_reset1";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_RESET2                                = "V2EnvironmentTests_PortletPreferences_ApiAction_reset2";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_RESET3                                = "V2EnvironmentTests_PortletPreferences_ApiAction_reset3";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_STORE1                                = "V2EnvironmentTests_PortletPreferences_ApiAction_store1";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_STORE2                                = "V2EnvironmentTests_PortletPreferences_ApiAction_store2";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_STORE3                                = "V2EnvironmentTests_PortletPreferences_ApiAction_store3";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_STORE4                                = "V2EnvironmentTests_PortletPreferences_ApiAction_store4";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_STORE5                                = "V2EnvironmentTests_PortletPreferences_ApiAction_store5";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_STORE6                                = "V2EnvironmentTests_PortletPreferences_ApiAction_store6";
   public final static String               V2ENVIRONMENTTESTS_PREFERENCESVALIDATOR_APIACTION_CANBECONFIGURED                     = "V2EnvironmentTests_PreferencesValidator_ApiAction_canBeConfigured";
   public final static String               V2ENVIRONMENTTESTS_PREFERENCESVALIDATOR_APIACTION_VALIDATE1                           = "V2EnvironmentTests_PreferencesValidator_ApiAction_validate1";
   public final static String               V2ENVIRONMENTTESTS_PREFERENCESVALIDATOR_APIACTION_VALIDATE2                           = "V2EnvironmentTests_PreferencesValidator_ApiAction_validate2";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_ISREADONLY1                            = "V2EnvironmentTests_PortletPreferences_ApiEvent_isReadOnly1";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_ISREADONLY2                            = "V2EnvironmentTests_PortletPreferences_ApiEvent_isReadOnly2";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_ISREADONLY3                            = "V2EnvironmentTests_PortletPreferences_ApiEvent_isReadOnly3";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_ISREADONLY4                            = "V2EnvironmentTests_PortletPreferences_ApiEvent_isReadOnly4";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_GETVALUE1                              = "V2EnvironmentTests_PortletPreferences_ApiEvent_getValue1";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_GETVALUE2                              = "V2EnvironmentTests_PortletPreferences_ApiEvent_getValue2";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_GETVALUE3                              = "V2EnvironmentTests_PortletPreferences_ApiEvent_getValue3";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_GETVALUE4                              = "V2EnvironmentTests_PortletPreferences_ApiEvent_getValue4";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_GETVALUES1                             = "V2EnvironmentTests_PortletPreferences_ApiEvent_getValues1";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_GETVALUES2                             = "V2EnvironmentTests_PortletPreferences_ApiEvent_getValues2";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_GETVALUES3                             = "V2EnvironmentTests_PortletPreferences_ApiEvent_getValues3";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_GETVALUES4                             = "V2EnvironmentTests_PortletPreferences_ApiEvent_getValues4";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_SETVALUE1                              = "V2EnvironmentTests_PortletPreferences_ApiEvent_setValue1";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_SETVALUE2                              = "V2EnvironmentTests_PortletPreferences_ApiEvent_setValue2";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_SETVALUE3                              = "V2EnvironmentTests_PortletPreferences_ApiEvent_setValue3";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_SETVALUE4                              = "V2EnvironmentTests_PortletPreferences_ApiEvent_setValue4";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_SETVALUE5                              = "V2EnvironmentTests_PortletPreferences_ApiEvent_setValue5";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_SETVALUES1                             = "V2EnvironmentTests_PortletPreferences_ApiEvent_setValues1";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_SETVALUES2                             = "V2EnvironmentTests_PortletPreferences_ApiEvent_setValues2";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_SETVALUES3                             = "V2EnvironmentTests_PortletPreferences_ApiEvent_setValues3";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_SETVALUES4                             = "V2EnvironmentTests_PortletPreferences_ApiEvent_setValues4";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_SETVALUES5                             = "V2EnvironmentTests_PortletPreferences_ApiEvent_setValues5";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_SETVALUES6                             = "V2EnvironmentTests_PortletPreferences_ApiEvent_setValues6";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_GETNAMES1                              = "V2EnvironmentTests_PortletPreferences_ApiEvent_getNames1";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_GETNAMES2                              = "V2EnvironmentTests_PortletPreferences_ApiEvent_getNames2";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_GETMAP1                                = "V2EnvironmentTests_PortletPreferences_ApiEvent_getMap1";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_GETMAP2                                = "V2EnvironmentTests_PortletPreferences_ApiEvent_getMap2";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_RESET1                                 = "V2EnvironmentTests_PortletPreferences_ApiEvent_reset1";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_RESET2                                 = "V2EnvironmentTests_PortletPreferences_ApiEvent_reset2";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_RESET3                                 = "V2EnvironmentTests_PortletPreferences_ApiEvent_reset3";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_STORE1                                 = "V2EnvironmentTests_PortletPreferences_ApiEvent_store1";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_STORE2                                 = "V2EnvironmentTests_PortletPreferences_ApiEvent_store2";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_STORE3                                 = "V2EnvironmentTests_PortletPreferences_ApiEvent_store3";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_STORE4                                 = "V2EnvironmentTests_PortletPreferences_ApiEvent_store4";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_STORE5                                 = "V2EnvironmentTests_PortletPreferences_ApiEvent_store5";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_STORE6                                 = "V2EnvironmentTests_PortletPreferences_ApiEvent_store6";
   public final static String               V2ENVIRONMENTTESTS_PREFERENCESVALIDATOR_APIEVENT_CANBECONFIGURED                      = "V2EnvironmentTests_PreferencesValidator_ApiEvent_canBeConfigured";
   public final static String               V2ENVIRONMENTTESTS_PREFERENCESVALIDATOR_APIEVENT_VALIDATE1                            = "V2EnvironmentTests_PreferencesValidator_ApiEvent_validate1";
   public final static String               V2ENVIRONMENTTESTS_PREFERENCESVALIDATOR_APIEVENT_VALIDATE2                            = "V2EnvironmentTests_PreferencesValidator_ApiEvent_validate2";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_ISREADONLY1                         = "V2EnvironmentTests_PortletPreferences_ApiResource_isReadOnly1";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_ISREADONLY2                         = "V2EnvironmentTests_PortletPreferences_ApiResource_isReadOnly2";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_ISREADONLY3                         = "V2EnvironmentTests_PortletPreferences_ApiResource_isReadOnly3";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_ISREADONLY4                         = "V2EnvironmentTests_PortletPreferences_ApiResource_isReadOnly4";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_GETVALUE1                           = "V2EnvironmentTests_PortletPreferences_ApiResource_getValue1";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_GETVALUE2                           = "V2EnvironmentTests_PortletPreferences_ApiResource_getValue2";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_GETVALUE3                           = "V2EnvironmentTests_PortletPreferences_ApiResource_getValue3";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_GETVALUE4                           = "V2EnvironmentTests_PortletPreferences_ApiResource_getValue4";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_GETVALUES1                          = "V2EnvironmentTests_PortletPreferences_ApiResource_getValues1";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_GETVALUES2                          = "V2EnvironmentTests_PortletPreferences_ApiResource_getValues2";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_GETVALUES3                          = "V2EnvironmentTests_PortletPreferences_ApiResource_getValues3";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_GETVALUES4                          = "V2EnvironmentTests_PortletPreferences_ApiResource_getValues4";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_SETVALUE1                           = "V2EnvironmentTests_PortletPreferences_ApiResource_setValue1";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_SETVALUE2                           = "V2EnvironmentTests_PortletPreferences_ApiResource_setValue2";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_SETVALUE3                           = "V2EnvironmentTests_PortletPreferences_ApiResource_setValue3";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_SETVALUE4                           = "V2EnvironmentTests_PortletPreferences_ApiResource_setValue4";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_SETVALUE5                           = "V2EnvironmentTests_PortletPreferences_ApiResource_setValue5";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_SETVALUES1                          = "V2EnvironmentTests_PortletPreferences_ApiResource_setValues1";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_SETVALUES2                          = "V2EnvironmentTests_PortletPreferences_ApiResource_setValues2";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_SETVALUES3                          = "V2EnvironmentTests_PortletPreferences_ApiResource_setValues3";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_SETVALUES4                          = "V2EnvironmentTests_PortletPreferences_ApiResource_setValues4";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_SETVALUES5                          = "V2EnvironmentTests_PortletPreferences_ApiResource_setValues5";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_SETVALUES6                          = "V2EnvironmentTests_PortletPreferences_ApiResource_setValues6";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_GETNAMES1                           = "V2EnvironmentTests_PortletPreferences_ApiResource_getNames1";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_GETNAMES2                           = "V2EnvironmentTests_PortletPreferences_ApiResource_getNames2";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_GETMAP1                             = "V2EnvironmentTests_PortletPreferences_ApiResource_getMap1";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_GETMAP2                             = "V2EnvironmentTests_PortletPreferences_ApiResource_getMap2";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_RESET1                              = "V2EnvironmentTests_PortletPreferences_ApiResource_reset1";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_RESET2                              = "V2EnvironmentTests_PortletPreferences_ApiResource_reset2";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_RESET3                              = "V2EnvironmentTests_PortletPreferences_ApiResource_reset3";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_STORE1                              = "V2EnvironmentTests_PortletPreferences_ApiResource_store1";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_STORE2                              = "V2EnvironmentTests_PortletPreferences_ApiResource_store2";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_STORE3                              = "V2EnvironmentTests_PortletPreferences_ApiResource_store3";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_STORE4                              = "V2EnvironmentTests_PortletPreferences_ApiResource_store4";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_STORE5                              = "V2EnvironmentTests_PortletPreferences_ApiResource_store5";
   public final static String               V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_STORE6                              = "V2EnvironmentTests_PortletPreferences_ApiResource_store6";
   public final static String               V2ENVIRONMENTTESTS_PREFERENCESVALIDATOR_APIRESOURCE_CANBECONFIGURED                   = "V2EnvironmentTests_PreferencesValidator_ApiResource_canBeConfigured";
   public final static String               V2ENVIRONMENTTESTS_PREFERENCESVALIDATOR_APIRESOURCE_VALIDATE1                         = "V2EnvironmentTests_PreferencesValidator_ApiResource_validate1";
   public final static String               V2ENVIRONMENTTESTS_PREFERENCESVALIDATOR_APIRESOURCE_VALIDATE2                         = "V2EnvironmentTests_PreferencesValidator_ApiResource_validate2";
   public final static String               V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_INCLUDEA1                       = "V2EnvironmentTests_PortletRequestDispatcher_ApiRender_includeA1";
   public final static String               V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_INCLUDEA2                       = "V2EnvironmentTests_PortletRequestDispatcher_ApiRender_includeA2";
   public final static String               V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_INCLUDEA3                       = "V2EnvironmentTests_PortletRequestDispatcher_ApiRender_includeA3";
   public final static String               V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_INCLUDEA4                       = "V2EnvironmentTests_PortletRequestDispatcher_ApiRender_includeA4";
   public final static String               V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_INCLUDEB1                       = "V2EnvironmentTests_PortletRequestDispatcher_ApiRender_includeB1";
   public final static String               V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_INCLUDEB2                       = "V2EnvironmentTests_PortletRequestDispatcher_ApiRender_includeB2";
   public final static String               V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_INCLUDEB3                       = "V2EnvironmentTests_PortletRequestDispatcher_ApiRender_includeB3";
   public final static String               V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_INCLUDEB4                       = "V2EnvironmentTests_PortletRequestDispatcher_ApiRender_includeB4";
   public final static String               V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_FORWARD1                        = "V2EnvironmentTests_PortletRequestDispatcher_ApiRender_forward1";
   public final static String               V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_FORWARD2                        = "V2EnvironmentTests_PortletRequestDispatcher_ApiRender_forward2";
   public final static String               V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_FORWARD3                        = "V2EnvironmentTests_PortletRequestDispatcher_ApiRender_forward3";
   public final static String               V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_FORWARD4                        = "V2EnvironmentTests_PortletRequestDispatcher_ApiRender_forward4";
   public final static String               V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_FIELDAPPLICATION_SCOPE                    = "V2EnvironmentTests_PortletSession_ApiRender_fieldAPPLICATION_SCOPE";
   public final static String               V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_FIELDPORTLET_SCOPE                        = "V2EnvironmentTests_PortletSession_ApiRender_fieldPORTLET_SCOPE";
   public final static String               V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTEA1                            = "V2EnvironmentTests_PortletSession_ApiRender_getAttributeA1";
   public final static String               V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTEA2                            = "V2EnvironmentTests_PortletSession_ApiRender_getAttributeA2";
   public final static String               V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTEA3                            = "V2EnvironmentTests_PortletSession_ApiRender_getAttributeA3";
   public final static String               V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTEA4                            = "V2EnvironmentTests_PortletSession_ApiRender_getAttributeA4";
   public final static String               V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTEB1                            = "V2EnvironmentTests_PortletSession_ApiRender_getAttributeB1";
   public final static String               V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTEB2                            = "V2EnvironmentTests_PortletSession_ApiRender_getAttributeB2";
   public final static String               V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTEB3                            = "V2EnvironmentTests_PortletSession_ApiRender_getAttributeB3";
   public final static String               V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTEB4                            = "V2EnvironmentTests_PortletSession_ApiRender_getAttributeB4";
   public final static String               V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTENAMESA1                       = "V2EnvironmentTests_PortletSession_ApiRender_getAttributeNamesA1";
   public final static String               V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTENAMESA2                       = "V2EnvironmentTests_PortletSession_ApiRender_getAttributeNamesA2";
   public final static String               V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTENAMESB1                       = "V2EnvironmentTests_PortletSession_ApiRender_getAttributeNamesB1";
   public final static String               V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTENAMESB2                       = "V2EnvironmentTests_PortletSession_ApiRender_getAttributeNamesB2";
   public final static String               V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETCREATIONTIME1                          = "V2EnvironmentTests_PortletSession_ApiRender_getCreationTime1";
   public final static String               V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETCREATIONTIME2                          = "V2EnvironmentTests_PortletSession_ApiRender_getCreationTime2";
   public final static String               V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETID                                     = "V2EnvironmentTests_PortletSession_ApiRender_getId";
   public final static String               V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETLASTACCESSEDTIME                       = "V2EnvironmentTests_PortletSession_ApiRender_getLastAccessedTime";
   public final static String               V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETMAXINACTIVEINTERVAL                    = "V2EnvironmentTests_PortletSession_ApiRender_getMaxInactiveInterval";
   public final static String               V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_INVALIDATE1                               = "V2EnvironmentTests_PortletSession_ApiRender_invalidate1";
   public final static String               V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_INVALIDATE2                               = "V2EnvironmentTests_PortletSession_ApiRender_invalidate2";
   public final static String               V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_ISNEW1                                    = "V2EnvironmentTests_PortletSession_ApiRender_isNew1";
   public final static String               V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_ISNEW2                                    = "V2EnvironmentTests_PortletSession_ApiRender_isNew2";
   public final static String               V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_REMOVEATTRIBUTEA1                         = "V2EnvironmentTests_PortletSession_ApiRender_removeAttributeA1";
   public final static String               V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_REMOVEATTRIBUTEA2                         = "V2EnvironmentTests_PortletSession_ApiRender_removeAttributeA2";
   public final static String               V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_REMOVEATTRIBUTEA3                         = "V2EnvironmentTests_PortletSession_ApiRender_removeAttributeA3";
   public final static String               V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_REMOVEATTRIBUTEA4                         = "V2EnvironmentTests_PortletSession_ApiRender_removeAttributeA4";
   public final static String               V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_REMOVEATTRIBUTEB1                         = "V2EnvironmentTests_PortletSession_ApiRender_removeAttributeB1";
   public final static String               V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_REMOVEATTRIBUTEB2                         = "V2EnvironmentTests_PortletSession_ApiRender_removeAttributeB2";
   public final static String               V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_REMOVEATTRIBUTEB3                         = "V2EnvironmentTests_PortletSession_ApiRender_removeAttributeB3";
   public final static String               V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_REMOVEATTRIBUTEB4                         = "V2EnvironmentTests_PortletSession_ApiRender_removeAttributeB4";
   public final static String               V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEA1                            = "V2EnvironmentTests_PortletSession_ApiRender_setAttributeA1";
   public final static String               V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEA2                            = "V2EnvironmentTests_PortletSession_ApiRender_setAttributeA2";
   public final static String               V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEA3                            = "V2EnvironmentTests_PortletSession_ApiRender_setAttributeA3";
   public final static String               V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEA4                            = "V2EnvironmentTests_PortletSession_ApiRender_setAttributeA4";
   public final static String               V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEA5                            = "V2EnvironmentTests_PortletSession_ApiRender_setAttributeA5";
   public final static String               V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEA6                            = "V2EnvironmentTests_PortletSession_ApiRender_setAttributeA6";
   public final static String               V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEA7                            = "V2EnvironmentTests_PortletSession_ApiRender_setAttributeA7";
   public final static String               V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEA8                            = "V2EnvironmentTests_PortletSession_ApiRender_setAttributeA8";
   public final static String               V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEB1                            = "V2EnvironmentTests_PortletSession_ApiRender_setAttributeB1";
   public final static String               V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEB2                            = "V2EnvironmentTests_PortletSession_ApiRender_setAttributeB2";
   public final static String               V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEB3                            = "V2EnvironmentTests_PortletSession_ApiRender_setAttributeB3";
   public final static String               V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEB4                            = "V2EnvironmentTests_PortletSession_ApiRender_setAttributeB4";
   public final static String               V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEB5                            = "V2EnvironmentTests_PortletSession_ApiRender_setAttributeB5";
   public final static String               V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEB6                            = "V2EnvironmentTests_PortletSession_ApiRender_setAttributeB6";
   public final static String               V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEB7                            = "V2EnvironmentTests_PortletSession_ApiRender_setAttributeB7";
   public final static String               V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEB8                            = "V2EnvironmentTests_PortletSession_ApiRender_setAttributeB8";
   public final static String               V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETMAXINACTIVEINTERVAL1                   = "V2EnvironmentTests_PortletSession_ApiRender_setMaxInactiveInterval1";
   public final static String               V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETMAXINACTIVEINTERVAL2                   = "V2EnvironmentTests_PortletSession_ApiRender_setMaxInactiveInterval2";
   public final static String               V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETPORTLETCONTEXT                         = "V2EnvironmentTests_PortletSession_ApiRender_getPortletContext";
   public final static String               V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTEMAPA1                         = "V2EnvironmentTests_PortletSession_ApiRender_getAttributeMapA1";
   public final static String               V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTEMAPA2                         = "V2EnvironmentTests_PortletSession_ApiRender_getAttributeMapA2";
   public final static String               V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTEMAPB1                         = "V2EnvironmentTests_PortletSession_ApiRender_getAttributeMapB1";
   public final static String               V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTEMAPB2                         = "V2EnvironmentTests_PortletSession_ApiRender_getAttributeMapB2";
   public final static String               V2ENVIRONMENTTESTS_PORTLETSESSIONUTIL_APIRENDER_DECODEATTRIBUTENAME1                  = "V2EnvironmentTests_PortletSessionUtil_ApiRender_decodeAttributeName1";
   public final static String               V2ENVIRONMENTTESTS_PORTLETSESSIONUTIL_APIRENDER_DECODEATTRIBUTENAME2                  = "V2EnvironmentTests_PortletSessionUtil_ApiRender_decodeAttributeName2";
   public final static String               V2ENVIRONMENTTESTS_PORTLETSESSIONUTIL_APIRENDER_DECODESCOPE1                          = "V2EnvironmentTests_PortletSessionUtil_ApiRender_decodeScope1";
   public final static String               V2ENVIRONMENTTESTS_PORTLETSESSIONUTIL_APIRENDER_DECODESCOPE2                          = "V2EnvironmentTests_PortletSessionUtil_ApiRender_decodeScope2";
   public final static String               V2ENVIRONMENTTESTS_PORTLETSESSIONUTIL_APIRENDER_DECODESCOPE3                          = "V2EnvironmentTests_PortletSessionUtil_ApiRender_decodeScope3";

   private final static Map<String, String> tcd                                                                                   = new HashMap<String, String>();
   static {

      tcd.put(V2FILTERTESTS_FILTERCHAIN_APIACTIONFILTER_INVOKEACTIONFILTER,
            "Invoking doFilter(ActionRequest, ActionResponse): causes next filter to be invoked");
      tcd.put(V2FILTERTESTS_FILTERCHAIN_APIACTIONFILTER_INVOKEACTIONFILTER2,
            "Invoking doFilter(ActionRequest, ActionResponse): causes portlet action method to be invoked");
      tcd.put(
            V2FILTERTESTS_FILTERCHAIN_APIACTIONFILTER_INVOKEACTIONEXCEPTION,
            "Method doFilter(ActionRequest, ActionResponse): If a PortletException is thrown before invoking the next filter in the chain, processing does not continue down the chain");
      tcd.put(V2FILTERTESTS_FILTERCHAIN_APIEVENTFILTER_INVOKEEVENTFILTER,
            "Invoking doFilter(EventRequest, EventResponse): causes next filter to be invoked");
      tcd.put(V2FILTERTESTS_FILTERCHAIN_APIEVENTFILTER_INVOKEEVENTFILTER2,
            "Invoking doFilter(EventRequest, EventResponse): causes portlet Event method to be invoked");
      tcd.put(
            V2FILTERTESTS_FILTERCHAIN_APIEVENTFILTER_INVOKEEVENTEXCEPTION,
            "Method doFilter(EventRequest, EventResponse): If a PortletException is thrown before invoking the next filter in the chain, processing does not continue down the chain");
      tcd.put(V2FILTERTESTS_FILTERCHAIN_APIRENDERFILTER_INVOKERENDERFILTER,
            "Invoking doFilter(RenderRequest, RenderResponse): causes next filter to be invoked");
      tcd.put(V2FILTERTESTS_FILTERCHAIN_APIRENDERFILTER_INVOKERENDERFILTER2,
            "Invoking doFilter(RenderRequest, RenderResponse): causes portlet Render method to be invoked");
      tcd.put(
            V2FILTERTESTS_FILTERCHAIN_APIRENDERFILTER_INVOKERENDEREXCEPTION,
            "Method doFilter(RenderRequest, RenderResponse): If a PortletException is thrown before invoking the next filter in the chain, processing does not continue down the chain");
      tcd.put(V2FILTERTESTS_FILTERCHAIN_APIRESOURCEFILTER_INVOKERESOURCEFILTER,
            "Invoking doFilter(ResourceRequest, ResourceResponse): causes next filter to be invoked");
      tcd.put(V2FILTERTESTS_FILTERCHAIN_APIRESOURCEFILTER_INVOKERESOURCEFILTER2,
            "Invoking doFilter(ResourceRequest, ResourceResponse): causes portlet Resource method to be invoked");
      tcd.put(
            V2FILTERTESTS_FILTERCHAIN_APIRESOURCEFILTER_INVOKERESOURCEEXCEPTION,
            "Method doFilter(ResourceRequest, ResourceResponse): If a PortletException is thrown before invoking the next filter in the chain, processing does not continue down the chain");
      tcd.put(V2FILTERTESTS_FILTERCONFIG_APIRENDERFILTER_GETFILTERNAME,
            "Method getFilterName(): getFilterName method returns filter name as defined in deployment descriptor");
      tcd.put(V2FILTERTESTS_FILTERCONFIG_APIRENDERFILTER_GETPORTLETCONTEXT,
            "Method getPortletContext(): Returns reference to PortletContext object");
      tcd.put(V2FILTERTESTS_FILTERCONFIG_APIRENDERFILTER_GETINITPARAMETER1,
            "Method getInitParameter(String): Returns null if initialization parameter does not exist");
      tcd.put(V2FILTERTESTS_FILTERCONFIG_APIRENDERFILTER_GETINITPARAMETER2,
            "Method getInitParameter(String): Returns value of specified initialization parameter");
      tcd.put(V2FILTERTESTS_FILTERCONFIG_APIRENDERFILTER_GETINITPARAMETERNAMES1,
            "Method getInitParameterNames(): Returns empty Enumeration if no parameters defined");
      tcd.put(V2FILTERTESTS_FILTERCONFIG_APIRENDERFILTER_GETINITPARAMETERNAMES2,
            "Method getInitParameterNames(): Returns an Enumeration of initialization parameters defined in deployment descriptor");
      tcd.put(V2FILTERTESTS_PORTLETFILTER_APIACTIONFILTER_INITACTION1,
            "The init(FilterConfig): method is called when an ActionFilter is configured");
      tcd.put(V2FILTERTESTS_PORTLETFILTER_APIACTIONFILTER_INITACTION2,
            "The init(FilterConfig): method for an ActionFilter is passed a FilterConfig object");
      tcd.put(V2FILTERTESTS_PORTLETFILTER_APIACTIONFILTER_INITACTION3,
            "If the init(FilterConfig): method for an ActionFilter throws a PortletException, the filter is not placed in service");
      tcd.put(V2FILTERTESTS_PORTLETFILTER_APIEVENTFILTER_INITEVENT1,
            "The init(FilterConfig): method is called when an EventFilter is configured");
      tcd.put(V2FILTERTESTS_PORTLETFILTER_APIEVENTFILTER_INITEVENT2,
            "The init(FilterConfig): method for an EventFilter is passed a FilterConfig object");
      tcd.put(V2FILTERTESTS_PORTLETFILTER_APIEVENTFILTER_INITEVENT3,
            "If the init(FilterConfig): method for an EventFilter throws a PortletException, the filter is not placed in service");
      tcd.put(V2FILTERTESTS_PORTLETFILTER_APIRENDERFILTER_INITRENDER1,
            "The init(FilterConfig): method is called when an RenderFilter is configured");
      tcd.put(V2FILTERTESTS_PORTLETFILTER_APIRENDERFILTER_INITRENDER2,
            "The init(FilterConfig): method for an RenderFilter is passed a FilterConfig object");
      tcd.put(V2FILTERTESTS_PORTLETFILTER_APIRENDERFILTER_INITRENDER3,
            "If the init(FilterConfig): method for an RenderFilter throws a PortletException, the filter is not placed in service");
      tcd.put(V2FILTERTESTS_PORTLETFILTER_APIRESOURCEFILTER_INITRESOURCE1,
            "The init(FilterConfig): method is called when an ResourceFilter is configured");
      tcd.put(V2FILTERTESTS_PORTLETFILTER_APIRESOURCEFILTER_INITRESOURCE2,
            "The init(FilterConfig): method for an ResourceFilter is passed a FilterConfig object");
      tcd.put(
            V2FILTERTESTS_PORTLETFILTER_APIRESOURCEFILTER_INITRESOURCE3,
            "If the init(FilterConfig): method for an ResourceFilter throws a PortletException, the filter is not placed in service");
      tcd.put(V2FILTERTESTS_ACTIONFILTER_APIACTIONFILTER_CANBECONFIGURED1,
            "An ActionFilter can be configured in the portlet descriptor");
      tcd.put(V2FILTERTESTS_ACTIONFILTER_APIACTIONFILTER_CANBECONFIGURED2,
            "Multiple ActionFilter classes can be configured in the portlet descriptor");
      tcd.put(
            V2FILTERTESTS_ACTIONFILTER_APIACTIONFILTER_DOFILTERISCALLED,
            "The doFilter(ActionRequest, ActionResponse, FilterChain): method is called before the processAction method for the portlet");
      tcd.put(
            V2FILTERTESTS_ACTIONFILTER_APIACTIONFILTER_DOFILTERPROCESSACTION1,
            "After the doFilter(ActionRequest, ActionResponse, FilterChain): method has sucessfully completed and invokes the next filter, the processActionMethod is called");
      tcd.put(
            V2FILTERTESTS_ACTIONFILTER_APIACTIONFILTER_DOFILTERPROCESSACTION2,
            "After the doFilter(ActionRequest, ActionResponse, FilterChain): method has sucessfully completed and invokes the next filter, the next filter in the chain is called if multiple filters are defined");
      tcd.put(
            V2FILTERTESTS_ACTIONFILTER_APIACTIONFILTER_DOFILTERBLOCK,
            "If the doFilter(ActionRequest, ActionResponse, FilterChain): method does not invoke the next filter, processAction is not called");
      tcd.put(
            V2FILTERTESTS_ACTIONFILTER_APIACTIONFILTER_DOFILTEREXCEPTION1,
            "If the doFilter(ActionRequest, ActionResponse, FilterChain): method throws an UnavailableException, processAction is not called");
      tcd.put(
            V2FILTERTESTS_ACTIONFILTER_APIACTIONFILTER_DOFILTEREXCEPTION2,
            "If the doFilter(ActionRequest, ActionResponse, FilterChain): method throws an UnavailableException, no further filter is called");
      tcd.put(
            V2FILTERTESTS_ACTIONFILTER_APIACTIONFILTER_DOFILTEREXAMINE,
            "Method doFilter(ActionRequest, ActionResponse, FilterChain): After the next filter has been successfully invoked, the ActionResponse may be examined");
      tcd.put(V2FILTERTESTS_EVENTFILTER_APIEVENTFILTER_CANBECONFIGURED1,
            "An EventFilter can be configured in the portlet descriptor");
      tcd.put(V2FILTERTESTS_EVENTFILTER_APIEVENTFILTER_CANBECONFIGURED2,
            "Multiple EventFilter classes can be configured in the portlet descriptor");
      tcd.put(
            V2FILTERTESTS_EVENTFILTER_APIEVENTFILTER_DOFILTERISCALLED,
            "The doFilter(EventRequest, EventResponse, FilterChain): method is called before the processEvent method for the portlet");
      tcd.put(
            V2FILTERTESTS_EVENTFILTER_APIEVENTFILTER_DOFILTERPROCESSEVENT1,
            "After the doFilter(EventRequest, EventResponse, FilterChain): method has sucessfully completed and invokes the next filter, the processEventMethod is called");
      tcd.put(
            V2FILTERTESTS_EVENTFILTER_APIEVENTFILTER_DOFILTERPROCESSEVENT2,
            "After the doFilter(EventRequest, EventResponse, FilterChain): method has sucessfully completed and invokes the next filter, the next filter in the chain is called if multiple filters are defined");
      tcd.put(
            V2FILTERTESTS_EVENTFILTER_APIEVENTFILTER_DOFILTERBLOCK,
            "If the doFilter(EventRequest, EventResponse, FilterChain): method does not invoke the next filter, processEvent is not called");
      tcd.put(
            V2FILTERTESTS_EVENTFILTER_APIEVENTFILTER_DOFILTEREXCEPTION1,
            "If the doFilter(EventRequest, EventResponse, FilterChain): method throws an UnavailableException, processEvent is not called");
      tcd.put(
            V2FILTERTESTS_EVENTFILTER_APIEVENTFILTER_DOFILTEREXCEPTION2,
            "If the doFilter(EventRequest, EventResponse, FilterChain): method throws an UnavailableException, no further filter is called");
      tcd.put(
            V2FILTERTESTS_EVENTFILTER_APIEVENTFILTER_DOFILTEREXAMINE,
            "Method doFilter(EventRequest, EventResponse, FilterChain): After the next filter has been successfully invoked, the EventResponse may be examined");
      tcd.put(V2FILTERTESTS_RENDERFILTER_APIRENDERFILTER_CANBECONFIGURED1,
            "An RenderFilter can be configured in the portlet descriptor");
      tcd.put(V2FILTERTESTS_RENDERFILTER_APIRENDERFILTER_CANBECONFIGURED2,
            "Multiple RenderFilter classes can be configured in the portlet descriptor");
      tcd.put(
            V2FILTERTESTS_RENDERFILTER_APIRENDERFILTER_DOFILTERISCALLED,
            "The doFilter(RenderRequest, RenderResponse, FilterChain): method is called before the processRender method for the portlet");
      tcd.put(
            V2FILTERTESTS_RENDERFILTER_APIRENDERFILTER_DOFILTERPROCESSRENDER1,
            "After the doFilter(RenderRequest, RenderResponse, FilterChain): method has sucessfully completed and invokes the next filter, the processRenderMethod is called");
      tcd.put(
            V2FILTERTESTS_RENDERFILTER_APIRENDERFILTER_DOFILTERPROCESSRENDER2,
            "After the doFilter(RenderRequest, RenderResponse, FilterChain): method has sucessfully completed and invokes the next filter, the next filter in the chain is called if multiple filters are defined");
      tcd.put(
            V2FILTERTESTS_RENDERFILTER_APIRENDERFILTER_DOFILTERBLOCK,
            "If the doFilter(RenderRequest, RenderResponse, FilterChain): method does not invoke the next filter, processRender is not called");
      tcd.put(
            V2FILTERTESTS_RENDERFILTER_APIRENDERFILTER_DOFILTEREXCEPTION1,
            "If the doFilter(RenderRequest, RenderResponse, FilterChain): method throws an UnavailableException, processRender is not called");
      tcd.put(
            V2FILTERTESTS_RENDERFILTER_APIRENDERFILTER_DOFILTEREXCEPTION2,
            "If the doFilter(RenderRequest, RenderResponse, FilterChain): method throws an UnavailableException, no further filter is called");
      tcd.put(
            V2FILTERTESTS_RENDERFILTER_APIRENDERFILTER_DOFILTEREXAMINE,
            "Method doFilter(RenderRequest, RenderResponse, FilterChain): After the next filter has been successfully invoked, the RenderResponse may be examined");
      tcd.put(V2FILTERTESTS_RESOURCEFILTER_APIRESOURCEFILTER_CANBECONFIGURED1,
            "An ResourceFilter can be configured in the portlet descriptor");
      tcd.put(V2FILTERTESTS_RESOURCEFILTER_APIRESOURCEFILTER_CANBECONFIGURED2,
            "Multiple ResourceFilter classes can be configured in the portlet descriptor");
      tcd.put(
            V2FILTERTESTS_RESOURCEFILTER_APIRESOURCEFILTER_DOFILTERISCALLED,
            "The doFilter(ResourceRequest, ResourceResponse, FilterChain): method is called before the processResource method for the portlet");
      tcd.put(
            V2FILTERTESTS_RESOURCEFILTER_APIRESOURCEFILTER_DOFILTERPROCESSRESOURCE1,
            "After the doFilter(ResourceRequest, ResourceResponse, FilterChain): method has sucessfully completed and invokes the next filter, the processResourceMethod is called");
      tcd.put(
            V2FILTERTESTS_RESOURCEFILTER_APIRESOURCEFILTER_DOFILTERPROCESSRESOURCE2,
            "After the doFilter(ResourceRequest, ResourceResponse, FilterChain): method has sucessfully completed and invokes the next filter, the next filter in the chain is called if multiple filters are defined");
      tcd.put(
            V2FILTERTESTS_RESOURCEFILTER_APIRESOURCEFILTER_DOFILTERBLOCK,
            "If the doFilter(ResourceRequest, ResourceResponse, FilterChain): method does not invoke the next filter, processResource is not called");
      tcd.put(
            V2FILTERTESTS_RESOURCEFILTER_APIRESOURCEFILTER_DOFILTEREXCEPTION1,
            "If the doFilter(ResourceRequest, ResourceResponse, FilterChain): method throws an UnavailableException, processResource is not called");
      tcd.put(
            V2FILTERTESTS_RESOURCEFILTER_APIRESOURCEFILTER_DOFILTEREXCEPTION2,
            "If the doFilter(ResourceRequest, ResourceResponse, FilterChain): method throws an UnavailableException, no further filter is called");
      tcd.put(
            V2FILTERTESTS_RESOURCEFILTER_APIRESOURCEFILTER_DOFILTEREXAMINE,
            "Method doFilter(ResourceRequest, ResourceResponse, FilterChain): After the next filter has been successfully invoked, the ResourceResponse may be examined");
      tcd.put(V2WRAPPERTESTS_ACTIONREQUESTWRAPPER_APIACTION_GETCHARACTERENCODING,
            "Method getCharacterEncoding(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_ACTIONREQUESTWRAPPER_APIACTION_GETCONTENTLENGTH,
            "Method getContentLength(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_ACTIONREQUESTWRAPPER_APIACTION_GETCONTENTTYPE,
            "Method getContentType(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_ACTIONREQUESTWRAPPER_APIACTION_GETPORTLETINPUTSTREAM,
            "Method getPortletInputStream(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_ACTIONREQUESTWRAPPER_APIACTION_GETREADER, "Method getReader(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_ACTIONREQUESTWRAPPER_APIACTION_SETCHARACTERENCODING,
            "Method setCharacterEncoding(String): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_ACTIONREQUESTWRAPPER_APIACTION_GETREQUEST,
            "Method getRequest(): Returns wrapped ActionRequest object");
      tcd.put(V2WRAPPERTESTS_ACTIONREQUESTWRAPPER_APIACTION_SETREQUEST,
            "Method setRequest(ActionRequest): Allows wrapped ActionRequest object to be set");
      tcd.put(V2WRAPPERTESTS_ACTIONREQUESTWRAPPER_APIACTION_GETMETHOD, "Method getMethod(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_ACTIONRESPONSEWRAPPER_APIACTION_SENDREDIRECTA,
            "Method sendRedirect(String): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_ACTIONRESPONSEWRAPPER_APIACTION_SENDREDIRECTB,
            "Method sendRedirect(String, String): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_ACTIONRESPONSEWRAPPER_APIACTION_SETEVENTA,
            "Method setEvent(javax.xml.namespace.QName, java.io.Serializable): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_ACTIONRESPONSEWRAPPER_APIACTION_SETEVENTB,
            "Method setEvent(String, java.io.Serializable): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_ACTIONRESPONSEWRAPPER_APIACTION_SETPORTLETMODE,
            "Method setPortletMode(PortletMode): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_ACTIONRESPONSEWRAPPER_APIACTION_SETRENDERPARAMETERA,
            "Method setRenderParameter(String, String): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_ACTIONRESPONSEWRAPPER_APIACTION_SETRENDERPARAMETERB,
            "Method setRenderParameter(String, String[]): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_ACTIONRESPONSEWRAPPER_APIACTION_SETRENDERPARAMETERS,
            "Method setRenderParameters(java.util.Map): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_ACTIONRESPONSEWRAPPER_APIACTION_SETWINDOWSTATE,
            "Method setWindowState(WindowState): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_ACTIONRESPONSEWRAPPER_APIACTION_GETRESPONSE,
            "Method getResponse(): Returns wrapped ActionResponse object");
      tcd.put(V2WRAPPERTESTS_ACTIONRESPONSEWRAPPER_APIACTION_SETRESPONSE,
            "Method setResponse(ActionResponse): Allows wrapped ActionResponse object to be set");
      tcd.put(V2WRAPPERTESTS_ACTIONRESPONSEWRAPPER_APIACTION_GETPORTLETMODE,
            "Method getPortletMode(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_ACTIONRESPONSEWRAPPER_APIACTION_GETRENDERPARAMETERMAP1,
            "Method getRenderParameterMap(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_ACTIONRESPONSEWRAPPER_APIACTION_GETWINDOWSTATE,
            "Method getWindowState(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_ACTIONRESPONSEWRAPPER_APIACTION_REMOVEPUBLICRENDERPARAMETER,
            "Method removePublicRenderParameter(String): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_EVENTREQUESTWRAPPER_APIEVENT_GETREQUEST,
            "Method getRequest(): Returns wrapped EventRequest object");
      tcd.put(V2WRAPPERTESTS_EVENTREQUESTWRAPPER_APIEVENT_SETREQUEST,
            "Method setRequest(EventRequest): Allows wrapped EventRequest object to be set");
      tcd.put(V2WRAPPERTESTS_EVENTREQUESTWRAPPER_APIEVENT_GETEVENT1, "Method getEvent(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_EVENTREQUESTWRAPPER_APIEVENT_GETMETHOD, "Method getMethod(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_EVENTRESPONSEWRAPPER_APIEVENT_SETEVENTA,
            "Method setEvent(javax.xml.namespace.QName, java.io.Serializable): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_EVENTRESPONSEWRAPPER_APIEVENT_SETEVENTB,
            "Method setEvent(String, java.io.Serializable): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_EVENTRESPONSEWRAPPER_APIEVENT_SETPORTLETMODE,
            "Method setPortletMode(PortletMode): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_EVENTRESPONSEWRAPPER_APIEVENT_SETRENDERPARAMETERA,
            "Method setRenderParameter(String, String): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_EVENTRESPONSEWRAPPER_APIEVENT_SETRENDERPARAMETERB,
            "Method setRenderParameter(String, String[]): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_EVENTRESPONSEWRAPPER_APIEVENT_SETRENDERPARAMETERSA,
            "Method setRenderParameters(EventRequest): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_EVENTRESPONSEWRAPPER_APIEVENT_SETRENDERPARAMETERSB,
            "Method setRenderParameters(EventRequest): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_EVENTRESPONSEWRAPPER_APIEVENT_SETWINDOWSTATE,
            "Method setWindowState(WindowState): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_EVENTRESPONSEWRAPPER_APIEVENT_GETRESPONSE,
            "Method getResponse(): Returns wrapped EventResponse object");
      tcd.put(V2WRAPPERTESTS_EVENTRESPONSEWRAPPER_APIEVENT_SETRESPONSE,
            "Method setResponse(EventResponse): Allows wrapped EventResponse object to be set");
      tcd.put(V2WRAPPERTESTS_EVENTRESPONSEWRAPPER_APIEVENT_GETPORTLETMODE,
            "Method getPortletMode(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_EVENTRESPONSEWRAPPER_APIEVENT_GETRENDERPARAMETERMAP1,
            "Method getRenderParameterMap(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_EVENTRESPONSEWRAPPER_APIEVENT_GETWINDOWSTATE,
            "Method getWindowState(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_EVENTRESPONSEWRAPPER_APIEVENT_REMOVEPUBLICRENDERPARAMETER,
            "Method removePublicRenderParameter(String): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETATTRIBUTE,
            "Method getAttribute(String): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETATTRIBUTENAMES,
            "Method getAttributeNames(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETAUTHTYPE, "Method getAuthType(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETCONTEXTPATH,
            "Method getContextPath(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETCOOKIES, "Method getCookies(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETLOCALE, "Method getLocale(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETLOCALES, "Method getLocales(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETPARAMETER,
            "Method getParameter(String): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETPARAMETERMAP,
            "Method getParameterMap(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETPARAMETERNAMES,
            "Method getParameterNames(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETPARAMETERVALUES,
            "Method getParameterValues(String): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETPORTALCONTEXT,
            "Method getPortalContext(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETPORTLETMODE,
            "Method getPortletMode(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETPORTLETSESSIONA,
            "Method getPortletSession(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETPORTLETSESSIONB,
            "Method getPortletSession(boolean): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETPREFERENCES,
            "Method getPreferences(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETPROPERTIES,
            "Method getProperties(String): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETPROPERTY,
            "Method getProperty(String): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETPROPERTYNAMES,
            "Method getPropertyNames(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETREMOTEUSER,
            "Method getRemoteUser(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETREQUESTEDSESSIONID,
            "Method getRequestedSessionId(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETRESPONSECONTENTTYPE,
            "Method getResponseContentType(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETRESPONSECONTENTTYPES,
            "Method getResponseContentTypes(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETSCHEME, "Method getScheme(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETSERVERNAME,
            "Method getServerName(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETSERVERPORT,
            "Method getServerPort(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETUSERPRINCIPAL,
            "Method getUserPrincipal(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETWINDOWID, "Method getWindowID(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETWINDOWSTATE,
            "Method getWindowState(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_ISPORTLETMODEALLOWED,
            "Method isPortletModeAllowed(PortletMode): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_ISREQUESTEDSESSIONIDVALID,
            "Method isRequestedSessionIdValid(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_ISSECURE, "Method isSecure(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_ISUSERINROLE,
            "Method isUserInRole(String): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_ISWINDOWSTATEALLOWED,
            "Method isWindowStateAllowed(WindowState): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_REMOVEATTRIBUTE,
            "Method removeAttribute(String): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_SETATTRIBUTE,
            "Method setAttribute(String, Object): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETREQUEST,
            "Method getRequest(): Returns wrapped PortletRequest object");
      tcd.put(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_SETREQUEST,
            "Method setRequest(PortletRequest): Allows wrapped PortletRequest object to be set");
      tcd.put(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETPRIVATEPARAMETERMAP,
            "Method getPrivateParameterMap(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_PORTLETREQUESTWRAPPER_APIRENDER_GETPUBLICPARAMETERMAP,
            "Method getPublicParameterMap(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_PORTLETRESPONSEWRAPPER_APIRENDER_ADDPROPERTYA,
            "Method addProperty(javax.servlet.http.Cookie): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_PORTLETRESPONSEWRAPPER_APIRENDER_ADDPROPERTYB,
            "Method addProperty(String, org.w3c.dom.Element): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_PORTLETRESPONSEWRAPPER_APIRENDER_ADDPROPERTYC,
            "Method addProperty(String, String): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_PORTLETRESPONSEWRAPPER_APIRENDER_ENCODEURL,
            "Method encodeURL(String): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_PORTLETRESPONSEWRAPPER_APIRENDER_GETNAMESPACE,
            "Method getNamespace(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_PORTLETRESPONSEWRAPPER_APIRENDER_SETPROPERTY,
            "Method setProperty(String, String): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_PORTLETRESPONSEWRAPPER_APIRENDER_GETRESPONSE,
            "Method getResponse(): Returns wrapped PortletResponse object");
      tcd.put(V2WRAPPERTESTS_PORTLETRESPONSEWRAPPER_APIRENDER_SETRESPONSE,
            "Method setResponse(PortletResponse): Allows wrapped PortletResponse object to be set");
      tcd.put(V2WRAPPERTESTS_PORTLETRESPONSEWRAPPER_APIRENDER_CREATEELEMENT,
            "Method createElement(String): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_RENDERREQUESTWRAPPER_APIRENDER_GETREQUEST,
            "Method getRequest(): Returns wrapped RenderRequest object");
      tcd.put(V2WRAPPERTESTS_RENDERREQUESTWRAPPER_APIRENDER_SETREQUEST,
            "Method setRequest(RenderRequest): Allows wrapped RenderRequest object to be set");
      tcd.put(V2WRAPPERTESTS_RENDERREQUESTWRAPPER_APIRENDER_GETETAG, "Method getETag(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_FLUSHBUFFER, "Method flushBuffer(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_GETBUFFERSIZE,
            "Method getBufferSize(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_GETCHARACTERENCODING,
            "Method getCharacterEncoding(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_GETCONTENTTYPE,
            "Method getContentType(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_GETLOCALE, "Method getLocale(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_GETPORTLETOUTPUTSTREAM,
            "Method getPortletOutputStream(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_GETWRITER, "Method getWriter(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_ISCOMMITTED, "Method isCommitted(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_RESET, "Method reset(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_RESETBUFFER, "Method resetBuffer(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_SETBUFFERSIZE,
            "Method setBufferSize(int): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_SETCONTENTTYPE,
            "Method setContentType(String): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_SETTITLE, "Method setTitle(String): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_GETCACHECONTROL,
            "Method getCacheControl(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_SETNEXTPOSSIBLEPORTLETMODES,
            "Method setNextPossiblePortletModes(java.util.Collection): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_GETRESPONSE,
            "Method getResponse(): Returns wrapped RenderResponse object");
      tcd.put(V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_SETRESPONSE,
            "Method setResponse(RenderResponse): Allows wrapped RenderResponse object to be set");
      tcd.put(V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_CREATEACTIONURL,
            "Method createActionURL(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_CREATERENDERURL,
            "Method createRenderURL(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_RENDERRESPONSEWRAPPER_APIRENDER_CREATERESOURCEURL,
            "Method createResourceURL(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_RESOURCEREQUESTWRAPPER_APIRESOURCE_GETPORTLETINPUTSTREAM,
            "Method getPortletInputStream(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_RESOURCEREQUESTWRAPPER_APIRESOURCE_GETREADER, "Method getReader(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_RESOURCEREQUESTWRAPPER_APIRESOURCE_SETCHARACTERENCODING,
            "Method setCharacterEncoding(String): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_RESOURCEREQUESTWRAPPER_APIRESOURCE_GETREQUEST,
            "Method getRequest(): Returns wrapped ResourceRequest object");
      tcd.put(V2WRAPPERTESTS_RESOURCEREQUESTWRAPPER_APIRESOURCE_SETREQUEST,
            "Method setRequest(ResourceRequest): Allows wrapped ResourceRequest object to be set");
      tcd.put(V2WRAPPERTESTS_RESOURCEREQUESTWRAPPER_APIRESOURCE_GETCHARACTERENCODING,
            "Method getCharacterEncoding(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_RESOURCEREQUESTWRAPPER_APIRESOURCE_GETCONTENTLENGTH,
            "Method getContentLength(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_RESOURCEREQUESTWRAPPER_APIRESOURCE_GETCONTENTTYPE,
            "Method getContentType(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_RESOURCEREQUESTWRAPPER_APIRESOURCE_GETETAG, "Method getETag(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_RESOURCEREQUESTWRAPPER_APIRESOURCE_GETMETHOD, "Method getMethod(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_RESOURCEREQUESTWRAPPER_APIRESOURCE_GETRESOURCEID,
            "Method getResourceID(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_RESOURCEREQUESTWRAPPER_APIRESOURCE_GETPRIVATERENDERPARAMETERMAP,
            "Method getPrivateRenderParameterMap(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_RESOURCEREQUESTWRAPPER_APIRESOURCE_GETCACHEABILITY,
            "Method getCacheability(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_FLUSHBUFFER,
            "Method flushBuffer(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_GETBUFFERSIZE,
            "Method getBufferSize(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_GETCHARACTERENCODING,
            "Method getCharacterEncoding(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_GETCONTENTTYPE,
            "Method getContentType(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_GETLOCALE, "Method getLocale(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_GETPORTLETOUTPUTSTREAM,
            "Method getPortletOutputStream(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_GETWRITER, "Method getWriter(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_ISCOMMITTED,
            "Method isCommitted(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_RESET, "Method reset(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_RESETBUFFER,
            "Method resetBuffer(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_SETBUFFERSIZE,
            "Method setBufferSize(int): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_SETCONTENTTYPE,
            "Method setContentType(String): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_GETCACHECONTROL,
            "Method getCacheControl(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_SETCHARACTERENCODING,
            "Method setCharacterEncoding(String): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_SETLOCALE,
            "Method setLocale(Locale): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_SETCONTENTLENGTH,
            "Method setContentLength(int): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_GETRESPONSE,
            "Method getResponse(): Returns wrapped RespurceResponse object");
      tcd.put(V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_SETRESPONSE,
            "Method setResponse(ResourceResponse): Allows wrapped ResourceResponse object to be set");
      tcd.put(V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_CREATEACTIONURL,
            "Method createActionURL(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_CREATERENDERURL,
            "Method createRenderURL(): Calls wrapped method");
      tcd.put(V2WRAPPERTESTS_RESOURCERESPONSEWRAPPER_APIRESOURCE_CREATERESOURCEURL,
            "Method createResourceURL(): Calls wrapped method");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_FIELDUSER_INFO,
            "Has String field USER_INFO with value of \"javax.portlet.userinfo\" ");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_FIELDCCPP_PROFILE,
            "Has String field CCPP_PROFILE with value of \"javax.portlet.ccpp\" ");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_FIELDBASIC_AUTH,
            "Has String field BASIC_AUTH with value of \"BASIC\" ");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_FIELDFORM_AUTH,
            "Has String field FORM_AUTH with value of \"FORM\" ");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_FIELDCLIENT_CERT_AUTH,
            "Has String field CLIENT_CERT_AUTH with value of \"CLIENT_CERT\" ");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_FIELDDIGEST_AUTH,
            "Has String field DIGEST_AUTH with value of \"DIGEST\" ");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_FIELDACTION_PHASE,
            "Has String field ACTION_PHASE with value of \"ACTION_PHASE\" ");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_FIELDEVENT_PHASE,
            "Has String field EVENT_PHASE with value of \"EVENT_PHASE\" ");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_FIELDRENDER_PHASE,
            "Has String field RENDER_PHASE with value of \"RENDER_PHASE\" ");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_FIELDRESOURCE_PHASE,
            "Has String field RESOURCE_PHASE with value of \"RESOURCE_PHASE\" ");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_FIELDLIFECYCLE_PHASE,
            "Has String field LIFECYCLE_PHASE with value of \"javax.portlet.lifecycle_phase\" ");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_FIELDRENDER_PART,
            "Has String field RENDER_PART with value of \"javax.portlet.render_part\" ");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_FIELDRENDER_HEADERS,
            "Has String field RENDER_HEADERS with value of \"RENDER_HEADERS\" ");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_FIELDRENDER_MARKUP,
            "Has String field RENDER_MARKUP with value of \"RENDER_MARKUP\" ");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_FIELDACTION_SCOPE_ID,
            "Has String field ACTION_SCOPE_ID with value of \"javax.portlet.as\" ");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_ISWINDOWSTATEALLOWED1,
            "Method isWindowStateAllowed(WindowState): Returns true if the specified WindowState is allowed");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_ISWINDOWSTATEALLOWED2,
            "Method isWindowStateAllowed(WindowState): Returns false if the specified WindowState is not allowed");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_ISPORTLETMODEALLOWED1,
            "Method isPortletModeAllowed(PortletMode): Returns true if the specified PortletMode is allowed");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_ISPORTLETMODEALLOWED2,
            "Method isPortletModeAllowed(PortletMode): Returns false if the specified PortletMode is not allowed");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPORTLETMODE,
            "Method getPortletMode(): Returns current PortletMode");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETWINDOWSTATE,
            "Method getWindowState(): Returns current WindowState");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPREFERENCES,
            "Method getPreferences(): Returns the PortletPreferences object associated with the portlet");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPORTLETSESSIONA1,
            "Method getPortletSession(): Returns current PortletSession if one already exists");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPORTLETSESSIONA2,
            "Method getPortletSession(): Returns new PortletSession if one does not already exist");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPORTLETSESSIONB1,
            "Method getPortletSession(boolean): If input flag is true, returns current PortletSession if one already exists");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPORTLETSESSIONB2,
            "Method getPortletSession(boolean): If input flag is true, returns new PortletSession if one does not already exist");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPORTLETSESSIONB3,
            "Method getPortletSession(boolean): If input flag is false, returns current PortletSession if one already exists");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPORTLETSESSIONB4,
            "Method getPortletSession(boolean): If input flag is false, returns null if one does not already exist");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPROPERTY1,
            "Method getProperty(String): If specified request property exists, returns its value");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPROPERTY2,
            "Method getProperty(String): If specified request property does not exist, returns null");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPROPERTY3,
            "Method getProperty(String): Throws IllegalArgumentException if the name is null");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPROPERTIES1,
            "Method getProperties(String): If specified request property exists, returns its values as an Enumeration");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPROPERTIES2,
            "Method getProperties(String): If specified request property does not exist, returns an empty Enumeration");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPROPERTIES3,
            "Method getProperties(String): Throws IllegalArgumentException if the name is null");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPROPERTYNAMES1,
            "Method getPropertyNames(): Returns an Enumeration of all request property names");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPROPERTYNAMES2,
            "Method getPropertyNames(): Returns an empty Enumeration if there are no request properties defined");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPORTALCONTEXT,
            "Method getPortalContext(): Returns the context of the portal");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETAUTHTYPE1,
            "Method getAuthType(): Returns a String indicating the authentication type if the request was authenticated");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETAUTHTYPE2,
            "Method getAuthType(): Returns null if the request was not authenticated");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETCONTEXTPATH1,
            "Method getContextPath(): Returns a String representing the context path associated with the portlet");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETCONTEXTPATH2,
            "Method getContextPath(): Returns an empty String if the portlet is deployed in the default context");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETCONTEXTPATH3,
            "Method getContextPath(): If the context path is not empty, it must start with \"/\" and may not end with \"/\"");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETREMOTEUSER1,
            "Method getRemoteUser(): Returns a String representing the login of the user if the request is authenticated");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETREMOTEUSER2,
            "Method getRemoteUser(): Returns null if the request has not been authenticated");
      tcd.put(
            V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETUSERPRINCIPAL1,
            "Method getUserPrincipal(): Returns a java.security.Principal object representing the user if the request has been authenticated");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETUSERPRINCIPAL2,
            "Method getUserPrincipal(): Returns null if the request has not been authenticated");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_ISUSERINROLE1,
            "Method isUserInRole(): Returns true if the authenticated user is in the specified role");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_ISUSERINROLE2,
            "Method isUserInRole(): Returns false if the authenticated user is not in the specified role");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_ISUSERINROLE3,
            "Method isUserInRole(): Returns false if the user is not authenticated");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETATTRIBUTE1,
            "Method getAttribute(String): Returns a java.lang.Object for the specified attribute name");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETATTRIBUTE2,
            "Method getAttribute(String): Returns null if no attribute with the specified name exists");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETATTRIBUTE3,
            "Method getAttribute(String): Throws IllegalArgumentException if the name is null");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETATTRIBUTENAMES1,
            "Method getAttributeNames(): Returns a java.util.Enumeration&lt;java.lang.String&gt; of the available attribute names");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETATTRIBUTENAMES2,
            "Method getAttributeNames(): Returns an empty Enumeration if there are no attributes available");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPARAMETER1,
            "Method getParameter(String): Returns String value of parameter specified by the name");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPARAMETER2,
            "Method getParameter(String): Returns String value of a public render parameter specified by the name");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPARAMETER3,
            "Method getParameter(String): Returns null if no parameter exists for the specified name");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPARAMETER4,
            "Method getParameter(String): Returns first String value from values array if use with a multivalued parameter");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPARAMETER5,
            "Method getParameter(String): Throws IllegalArgumentException if the name is null");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPARAMETERNAMES1,
            "Method getParameterNames(): Returns a java.util.Enumeration&lt;java.lang.String&gt; of the available parameter names");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPARAMETERNAMES2,
            "Method getParameterNames(): Returns an empty Enumeration if there are no parameters available");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPARAMETERVALUES1,
            "Method getParameterValues(String): Returns String[] value of parameter specified by the name");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPARAMETERVALUES2,
            "Method getParameterValues(String): Returns String[] value of a public render parameter specified by the name");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPARAMETERVALUES3,
            "Method getParameterValues(String): Returns null if no parameter exists for the specified name");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPARAMETERVALUES4,
            "Method getParameterValues(String): Throws IllegalArgumentException if the name is null");
      tcd.put(
            V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPARAMETERMAP1,
            "Method getParameterMap(): Returns an java.util.Map&lt;java.lang.String,java.lang.String[]&gt; object for the parameter names and values if parameters are available");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPARAMETERMAP2,
            "Method getParameterMap(): The returned map contains all public and private parameters for the request");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPARAMETERMAP3,
            "Method getParameterMap(): Returns an empty map if no parameters exist");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_ISSECURE1,
            "Method isSecure(): Returns true if the request was made through a secure channel");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_ISSECURE2,
            "Method isSecure(): Returns false if the request was not made through a secure channel");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_SETATTRIBUTE1,
            "Method setAttribute(String, Object): Stores an attribute object under the specified name in the request");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_SETATTRIBUTE2,
            "Method setAttribute(String, Object): Removes the attribute by the specified name if the object is null");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_SETATTRIBUTE3,
            "Method setAttribute(String, Object): Throws IllegalArgumentException if the name is null");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_REMOVEATTRIBUTE1,
            "Method removeAttribute(String): Removes the attribute specified by the name from the request");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_REMOVEATTRIBUTE2,
            "Method removeAttribute(String): Throws IllegalArgumentException if the name is null");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETREQUESTEDSESSIONID1,
            "Method getRequestedSessionId(): Returns the session ID indicated in the client request");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETREQUESTEDSESSIONID2,
            "Method getRequestedSessionId(): Returns null if no session ID was indicated in the client request");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_ISREQUESTEDSESSIONIDVALID1,
            "Method isRequestedSessionIdValid(): Returns true if the session ID is valid");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_ISREQUESTEDSESSIONIDVALID2,
            "Method isRequestedSessionIdValid(): Returns false if the session ID is not valid");
      tcd.put(
            V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETRESPONSECONTENTTYPE1,
            "Method getResponseContentType(): Returns a String representing the portal preferred content type for the response if the content type is defined in the portlet descriptor  ");
      tcd.put(
            V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETRESPONSECONTENTTYPE2,
            "Method getResponseContentType(): Returns an empty Enumeration if the content type is not defined in the portlet descriptor");
      tcd.put(
            V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETRESPONSECONTENTTYPES1,
            "Method getResponseContentTypes(): Returns an java.util.Enumeration&lt;java.lang.String&gt; object representing the portal preferred content types for the response if the content types are defined in the portlet descriptor");
      tcd.put(
            V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETRESPONSECONTENTTYPES2,
            "Method getResponseContentTypes(): Returns an empty Enumeration if the content types are not defined in the portlet descriptor");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETLOCALE,
            "Method getLocale(): Returns an java.util.Locale object representing the preferred Locale for the response");
      tcd.put(
            V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETLOCALES,
            "Method getLocales(): Returns an java.util.Enumeration&lt;java.util.Locale&gt; of the Locales in which the portal will accept content");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETSCHEME,
            "Method getScheme(): Returns a String value representing the scheme name for the request");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETSERVERNAME,
            "Method getServerName(): Returns a String value representing the host name for the request");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETSERVERPORT,
            "Method getServerPort(): Returns an int value representing the port number for the request");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETWINDOWID,
            "Method getWindowID(): Returns a String value representing the portlet window ID");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETCOOKIES1,
            "Method getCookies(): Returns a javax.servlet.http.Cookie[] array containing the cookies for this request");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETCOOKIES2,
            "Method getCookies(): Returns null if no cookies are present");
      tcd.put(
            V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPRIVATEPARAMETERMAP1,
            "Method getPrivateParameterMap(): Returns an java.util.Map&lt;java.lang.String,java.lang.String[]&gt; object for the private parameter names and values if available");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPRIVATEPARAMETERMAP2,
            "Method getPrivateParameterMap(): The returned map is immutable");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPRIVATEPARAMETERMAP3,
            "Method getPrivateParameterMap(): Returns an empty map if no private parameters exist");
      tcd.put(
            V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPUBLICPARAMETERMAP1,
            "Method getPublicParameterMap(): Returns an java.util.Map&lt;java.lang.String,java.lang.String[]&gt; object for the public parameter names and values if available");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPUBLICPARAMETERMAP2,
            "Method getPublicParameterMap(): The returned map is immutable");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_GETPUBLICPARAMETERMAP3,
            "Method getPublicParameterMap(): Returns an empty map if no public parameters exist");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRENDER_EXISTS, "The P3PUserInfos exists as a public static enum");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_FIELDUSER_INFO,
            "Has String field USER_INFO with value of \"javax.portlet.userinfo\" ");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_FIELDCCPP_PROFILE,
            "Has String field CCPP_PROFILE with value of \"javax.portlet.ccpp\" ");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_FIELDBASIC_AUTH,
            "Has String field BASIC_AUTH with value of \"BASIC\" ");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_FIELDFORM_AUTH,
            "Has String field FORM_AUTH with value of \"FORM\" ");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_FIELDCLIENT_CERT_AUTH,
            "Has String field CLIENT_CERT_AUTH with value of \"CLIENT_CERT\" ");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_FIELDDIGEST_AUTH,
            "Has String field DIGEST_AUTH with value of \"DIGEST\" ");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_FIELDACTION_PHASE,
            "Has String field ACTION_PHASE with value of \"ACTION_PHASE\" ");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_FIELDEVENT_PHASE,
            "Has String field EVENT_PHASE with value of \"EVENT_PHASE\" ");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_FIELDRENDER_PHASE,
            "Has String field RENDER_PHASE with value of \"RENDER_PHASE\" ");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_FIELDRESOURCE_PHASE,
            "Has String field RESOURCE_PHASE with value of \"RESOURCE_PHASE\" ");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_FIELDLIFECYCLE_PHASE,
            "Has String field LIFECYCLE_PHASE with value of \"javax.portlet.lifecycle_phase\" ");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_FIELDRENDER_PART,
            "Has String field RENDER_PART with value of \"javax.portlet.render_part\" ");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_FIELDRENDER_HEADERS,
            "Has String field RENDER_HEADERS with value of \"RENDER_HEADERS\" ");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_FIELDRENDER_MARKUP,
            "Has String field RENDER_MARKUP with value of \"RENDER_MARKUP\" ");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_FIELDACTION_SCOPE_ID,
            "Has String field ACTION_SCOPE_ID with value of \"javax.portlet.as\" ");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_ISWINDOWSTATEALLOWED1,
            "Method isWindowStateAllowed(WindowState): Returns true if the specified WindowState is allowed");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_ISWINDOWSTATEALLOWED2,
            "Method isWindowStateAllowed(WindowState): Returns false if the specified WindowState is not allowed");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_ISPORTLETMODEALLOWED1,
            "Method isPortletModeAllowed(PortletMode): Returns true if the specified PortletMode is allowed");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_ISPORTLETMODEALLOWED2,
            "Method isPortletModeAllowed(PortletMode): Returns false if the specified PortletMode is not allowed");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPORTLETMODE,
            "Method getPortletMode(): Returns current PortletMode");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETWINDOWSTATE,
            "Method getWindowState(): Returns current WindowState");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPREFERENCES,
            "Method getPreferences(): Returns the PortletPreferences object associated with the portlet");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPORTLETSESSIONA1,
            "Method getPortletSession(): Returns current PortletSession if one already exists");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPORTLETSESSIONA2,
            "Method getPortletSession(): Returns new PortletSession if one does not already exist");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPORTLETSESSIONB1,
            "Method getPortletSession(boolean): If input flag is true, returns current PortletSession if one already exists");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPORTLETSESSIONB2,
            "Method getPortletSession(boolean): If input flag is true, returns new PortletSession if one does not already exist");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPORTLETSESSIONB3,
            "Method getPortletSession(boolean): If input flag is false, returns current PortletSession if one already exists");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPORTLETSESSIONB4,
            "Method getPortletSession(boolean): If input flag is false, returns null if one does not already exist");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPROPERTY1,
            "Method getProperty(String): If specified request property exists, returns its value");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPROPERTY2,
            "Method getProperty(String): If specified request property does not exist, returns null");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPROPERTY3,
            "Method getProperty(String): Throws IllegalArgumentException if the name is null");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPROPERTIES1,
            "Method getProperties(String): If specified request property exists, returns its values as an Enumeration");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPROPERTIES2,
            "Method getProperties(String): If specified request property does not exist, returns an empty Enumeration");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPROPERTIES3,
            "Method getProperties(String): Throws IllegalArgumentException if the name is null");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPROPERTYNAMES1,
            "Method getPropertyNames(): Returns an Enumeration of all request property names");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPROPERTYNAMES2,
            "Method getPropertyNames(): Returns an empty Enumeration if there are no request properties defined");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPORTALCONTEXT,
            "Method getPortalContext(): Returns the context of the portal");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETAUTHTYPE1,
            "Method getAuthType(): Returns a String indicating the authentication type if the request was authenticated");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETAUTHTYPE2,
            "Method getAuthType(): Returns null if the request was not authenticated");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETCONTEXTPATH1,
            "Method getContextPath(): Returns a String representing the context path associated with the portlet");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETCONTEXTPATH2,
            "Method getContextPath(): Returns an empty String if the portlet is deployed in the default context");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETCONTEXTPATH3,
            "Method getContextPath(): If the context path is not empty, it must start with \"/\" and may not end with \"/\"");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETREMOTEUSER1,
            "Method getRemoteUser(): Returns a String representing the login of the user if the request is authenticated");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETREMOTEUSER2,
            "Method getRemoteUser(): Returns null if the request has not been authenticated");
      tcd.put(
            V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETUSERPRINCIPAL1,
            "Method getUserPrincipal(): Returns a java.security.Principal object representing the user if the request has been authenticated");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETUSERPRINCIPAL2,
            "Method getUserPrincipal(): Returns null if the request has not been authenticated");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_ISUSERINROLE1,
            "Method isUserInRole(): Returns true if the authenticated user is in the specified role");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_ISUSERINROLE2,
            "Method isUserInRole(): Returns false if the authenticated user is not in the specified role");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_ISUSERINROLE3,
            "Method isUserInRole(): Returns false if the user is not authenticated");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETATTRIBUTE1,
            "Method getAttribute(String): Returns a java.lang.Object for the specified attribute name");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETATTRIBUTE2,
            "Method getAttribute(String): Returns null if no attribute with the specified name exists");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETATTRIBUTE3,
            "Method getAttribute(String): Throws IllegalArgumentException if the name is null");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETATTRIBUTENAMES1,
            "Method getAttributeNames(): Returns a java.util.Enumeration&lt;java.lang.String&gt; of the available attribute names");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETATTRIBUTENAMES2,
            "Method getAttributeNames(): Returns an empty Enumeration if there are no attributes available");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPARAMETER1,
            "Method getParameter(String): Returns String value of parameter specified by the name");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPARAMETER2,
            "Method getParameter(String): Returns String value of a public render parameter specified by the name");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPARAMETER3,
            "Method getParameter(String): Returns null if no parameter exists for the specified name");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPARAMETER4,
            "Method getParameter(String): Returns first String value from values array if use with a multivalued parameter");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPARAMETER5,
            "Method getParameter(String): Throws IllegalArgumentException if the name is null");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPARAMETERNAMES1,
            "Method getParameterNames(): Returns a java.util.Enumeration&lt;java.lang.String&gt; of the available parameter names");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPARAMETERNAMES2,
            "Method getParameterNames(): Returns an empty Enumeration if there are no parameters available");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPARAMETERVALUES1,
            "Method getParameterValues(String): Returns String[] value of parameter specified by the name");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPARAMETERVALUES2,
            "Method getParameterValues(String): Returns String[] value of a public render parameter specified by the name");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPARAMETERVALUES3,
            "Method getParameterValues(String): Returns null if no parameter exists for the specified name");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPARAMETERVALUES4,
            "Method getParameterValues(String): Throws IllegalArgumentException if the name is null");
      tcd.put(
            V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPARAMETERMAP1,
            "Method getParameterMap(): Returns an java.util.Map&lt;java.lang.String,java.lang.String[]&gt; object for the parameter names and values if parameters are available");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPARAMETERMAP2,
            "Method getParameterMap(): The returned map contains all public and private parameters for the request");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPARAMETERMAP3,
            "Method getParameterMap(): Returns an empty map if no parameters exist");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_ISSECURE1,
            "Method isSecure(): Returns true if the request was made through a secure channel");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_ISSECURE2,
            "Method isSecure(): Returns false if the request was not made through a secure channel");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_SETATTRIBUTE1,
            "Method setAttribute(String, Object): Stores an attribute object under the specified name in the request");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_SETATTRIBUTE2,
            "Method setAttribute(String, Object): Removes the attribute by the specified name if the object is null");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_SETATTRIBUTE3,
            "Method setAttribute(String, Object): Throws IllegalArgumentException if the name is null");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_REMOVEATTRIBUTE1,
            "Method removeAttribute(String): Removes the attribute specified by the name from the request");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_REMOVEATTRIBUTE2,
            "Method removeAttribute(String): Throws IllegalArgumentException if the name is null");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETREQUESTEDSESSIONID1,
            "Method getRequestedSessionId(): Returns the session ID indicated in the client request");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETREQUESTEDSESSIONID2,
            "Method getRequestedSessionId(): Returns null if no session ID was indicated in the client request");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_ISREQUESTEDSESSIONIDVALID1,
            "Method isRequestedSessionIdValid(): Returns true if the session ID is valid");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_ISREQUESTEDSESSIONIDVALID2,
            "Method isRequestedSessionIdValid(): Returns false if the session ID is not valid");
      tcd.put(
            V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETRESPONSECONTENTTYPE1,
            "Method getResponseContentType(): Returns a String representing the portal preferred content type for the response if the content type is defined in the portlet descriptor  ");
      tcd.put(
            V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETRESPONSECONTENTTYPE2,
            "Method getResponseContentType(): Returns an empty Enumeration if the content type is not defined in the portlet descriptor");
      tcd.put(
            V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETRESPONSECONTENTTYPES1,
            "Method getResponseContentTypes(): Returns an java.util.Enumeration&lt;java.lang.String&gt; object representing the portal preferred content types for the response if the content types are defined in the portlet descriptor");
      tcd.put(
            V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETRESPONSECONTENTTYPES2,
            "Method getResponseContentTypes(): Returns an empty Enumeration if the content types are not defined in the portlet descriptor");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETLOCALE,
            "Method getLocale(): Returns an java.util.Locale object representing the preferred Locale for the response");
      tcd.put(
            V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETLOCALES,
            "Method getLocales(): Returns an java.util.Enumeration&lt;java.util.Locale&gt; of the Locales in which the portal will accept content");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETSCHEME,
            "Method getScheme(): Returns a String value representing the scheme name for the request");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETSERVERNAME,
            "Method getServerName(): Returns a String value representing the host name for the request");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETSERVERPORT,
            "Method getServerPort(): Returns an int value representing the port number for the request");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETWINDOWID,
            "Method getWindowID(): Returns a String value representing the portlet window ID");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETCOOKIES1,
            "Method getCookies(): Returns a javax.servlet.http.Cookie[] array containing the cookies for this request");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETCOOKIES2,
            "Method getCookies(): Returns null if no cookies are present");
      tcd.put(
            V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPRIVATEPARAMETERMAP1,
            "Method getPrivateParameterMap(): Returns an java.util.Map&lt;java.lang.String,java.lang.String[]&gt; object for the private parameter names and values if available");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPRIVATEPARAMETERMAP2,
            "Method getPrivateParameterMap(): The returned map is immutable");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPRIVATEPARAMETERMAP3,
            "Method getPrivateParameterMap(): Returns an empty map if no private parameters exist");
      tcd.put(
            V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPUBLICPARAMETERMAP1,
            "Method getPublicParameterMap(): Returns an java.util.Map&lt;java.lang.String,java.lang.String[]&gt; object for the public parameter names and values if available");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPUBLICPARAMETERMAP2,
            "Method getPublicParameterMap(): The returned map is immutable");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_GETPUBLICPARAMETERMAP3,
            "Method getPublicParameterMap(): Returns an empty map if no public parameters exist");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIACTION_EXISTS,
            "Method exists(): The P3PUserInfos exist as a public static enum");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_FIELDUSER_INFO,
            "Has String field USER_INFO with value of \"javax.portlet.userinfo\" ");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_FIELDCCPP_PROFILE,
            "Has String field CCPP_PROFILE with value of \"javax.portlet.ccpp\" ");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_FIELDBASIC_AUTH,
            "Has String field BASIC_AUTH with value of \"BASIC\" ");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_FIELDFORM_AUTH,
            "Has String field FORM_AUTH with value of \"FORM\" ");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_FIELDCLIENT_CERT_AUTH,
            "Has String field CLIENT_CERT_AUTH with value of \"CLIENT_CERT\" ");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_FIELDDIGEST_AUTH,
            "Has String field DIGEST_AUTH with value of \"DIGEST\" ");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_FIELDACTION_PHASE,
            "Has String field ACTION_PHASE with value of \"ACTION_PHASE\" ");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_FIELDEVENT_PHASE,
            "Has String field EVENT_PHASE with value of \"EVENT_PHASE\" ");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_FIELDRENDER_PHASE,
            "Has String field RENDER_PHASE with value of \"RENDER_PHASE\" ");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_FIELDRESOURCE_PHASE,
            "Has String field RESOURCE_PHASE with value of \"RESOURCE_PHASE\" ");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_FIELDLIFECYCLE_PHASE,
            "Has String field LIFECYCLE_PHASE with value of \"javax.portlet.lifecycle_phase\" ");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_FIELDRENDER_PART,
            "Has String field RENDER_PART with value of \"javax.portlet.render_part\" ");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_FIELDRENDER_HEADERS,
            "Has String field RENDER_HEADERS with value of \"RENDER_HEADERS\" ");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_FIELDRENDER_MARKUP,
            "Has String field RENDER_MARKUP with value of \"RENDER_MARKUP\" ");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_FIELDACTION_SCOPE_ID,
            "Has String field ACTION_SCOPE_ID with value of \"javax.portlet.as\" ");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_ISWINDOWSTATEALLOWED1,
            "Method isWindowStateAllowed(WindowState): Returns true if the specified WindowState is allowed");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_ISWINDOWSTATEALLOWED2,
            "Method isWindowStateAllowed(WindowState): Returns false if the specified WindowState is not allowed");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_ISPORTLETMODEALLOWED1,
            "Method isPortletModeAllowed(PortletMode): Returns true if the specified PortletMode is allowed");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_ISPORTLETMODEALLOWED2,
            "Method isPortletModeAllowed(PortletMode): Returns false if the specified PortletMode is not allowed");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPORTLETMODE,
            "Method getPortletMode(): Returns current PortletMode");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETWINDOWSTATE,
            "Method getWindowState(): Returns current WindowState");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPREFERENCES,
            "Method getPreferences(): Returns the PortletPreferences object associated with the portlet");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPORTLETSESSIONA1,
            "Method getPortletSession(): Returns current PortletSession if one already exists");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPORTLETSESSIONA2,
            "Method getPortletSession(): Returns new PortletSession if one does not already exist");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPORTLETSESSIONB1,
            "Method getPortletSession(boolean): If input flag is true, returns current PortletSession if one already exists");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPORTLETSESSIONB2,
            "Method getPortletSession(boolean): If input flag is true, returns new PortletSession if one does not already exist");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPORTLETSESSIONB3,
            "Method getPortletSession(boolean): If input flag is false, returns current PortletSession if one already exists");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPORTLETSESSIONB4,
            "Method getPortletSession(boolean): If input flag is false, returns null if one does not already exist");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPROPERTY1,
            "Method getProperty(String): If specified request property exists, returns its value");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPROPERTY2,
            "Method getProperty(String): If specified request property does not exist, returns null");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPROPERTY3,
            "Method getProperty(String): Throws IllegalArgumentException if the name is null");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPROPERTIES1,
            "Method getProperties(String): If specified request property exists, returns its values as an Enumeration");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPROPERTIES2,
            "Method getProperties(String): If specified request property does not exist, returns an empty Enumeration");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPROPERTIES3,
            "Method getProperties(String): Throws IllegalArgumentException if the name is null");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPROPERTYNAMES1,
            "Method getPropertyNames(): Returns an Enumeration of all request property names");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPROPERTYNAMES2,
            "Method getPropertyNames(): Returns an empty Enumeration if there are no request properties defined");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPORTALCONTEXT,
            "Method getPortalContext(): Returns the context of the portal");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETAUTHTYPE1,
            "Method getAuthType(): Returns a String indicating the authentication type if the request was authenticated");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETAUTHTYPE2,
            "Method getAuthType(): Returns null if the request was not authenticated");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETCONTEXTPATH1,
            "Method getContextPath(): Returns a String representing the context path associated with the portlet");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETCONTEXTPATH2,
            "Method getContextPath(): Returns an empty String if the portlet is deployed in the default context");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETCONTEXTPATH3,
            "Method getContextPath(): If the context path is not empty, it must start with \"/\" and may not end with \"/\"");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETREMOTEUSER1,
            "Method getRemoteUser(): Returns a String representing the login of the user if the request is authenticated");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETREMOTEUSER2,
            "Method getRemoteUser(): Returns null if the request has not been authenticated");
      tcd.put(
            V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETUSERPRINCIPAL1,
            "Method getUserPrincipal(): Returns a java.security.Principal object representing the user if the request has been authenticated");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETUSERPRINCIPAL2,
            "Method getUserPrincipal(): Returns null if the request has not been authenticated");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_ISUSERINROLE1,
            "Method isUserInRole(): Returns true if the authenticated user is in the specified role");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_ISUSERINROLE2,
            "Method isUserInRole(): Returns false if the authenticated user is not in the specified role");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_ISUSERINROLE3,
            "Method isUserInRole(): Returns false if the user is not authenticated");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETATTRIBUTE1,
            "Method getAttribute(String): Returns a java.lang.Object for the specified attribute name");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETATTRIBUTE2,
            "Method getAttribute(String): Returns null if no attribute with the specified name exists");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETATTRIBUTE3,
            "Method getAttribute(String): Throws IllegalArgumentException if the name is null");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETATTRIBUTENAMES1,
            "Method getAttributeNames(): Returns a java.util.Enumeration&lt;java.lang.String&gt; of the available attribute names");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETATTRIBUTENAMES2,
            "Method getAttributeNames(): Returns an empty Enumeration if there are no attributes available");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPARAMETER1,
            "Method getParameter(String): Returns String value of parameter specified by the name");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPARAMETER2,
            "Method getParameter(String): Returns String value of a public render parameter specified by the name");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPARAMETER3,
            "Method getParameter(String): Returns null if no parameter exists for the specified name");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPARAMETER4,
            "Method getParameter(String): Returns first String value from values array if use with a multivalued parameter");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPARAMETER5,
            "Method getParameter(String): Throws IllegalArgumentException if the name is null");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPARAMETERNAMES1,
            "Method getParameterNames(): Returns a java.util.Enumeration&lt;java.lang.String&gt; of the available parameter names");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPARAMETERNAMES2,
            "Method getParameterNames(): Returns an empty Enumeration if there are no parameters available");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPARAMETERVALUES1,
            "Method getParameterValues(String): Returns String[] value of parameter specified by the name");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPARAMETERVALUES2,
            "Method getParameterValues(String): Returns String[] value of a public render parameter specified by the name");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPARAMETERVALUES3,
            "Method getParameterValues(String): Returns null if no parameter exists for the specified name");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPARAMETERVALUES4,
            "Method getParameterValues(String): Throws IllegalArgumentException if the name is null");
      tcd.put(
            V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPARAMETERMAP1,
            "Method getParameterMap(): Returns an java.util.Map&lt;java.lang.String,java.lang.String[]&gt; object for the parameter names and values if parameters are available");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPARAMETERMAP2,
            "Method getParameterMap(): The returned map contains all public and private parameters for the request");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPARAMETERMAP3,
            "Method getParameterMap(): Returns an empty map if no parameters exist");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_ISSECURE1,
            "Method isSecure(): Returns true if the request was made through a secure channel");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_ISSECURE2,
            "Method isSecure(): Returns false if the request was not made through a secure channel");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_SETATTRIBUTE1,
            "Method setAttribute(String, Object): Stores an attribute object under the specified name in the request");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_SETATTRIBUTE2,
            "Method setAttribute(String, Object): Removes the attribute by the specified name if the object is null");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_SETATTRIBUTE3,
            "Method setAttribute(String, Object): Throws IllegalArgumentException if the name is null");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_REMOVEATTRIBUTE1,
            "Method removeAttribute(String): Removes the attribute specified by the name from the request");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_REMOVEATTRIBUTE2,
            "Method removeAttribute(String): Throws IllegalArgumentException if the name is null");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETREQUESTEDSESSIONID1,
            "Method getRequestedSessionId(): Returns the session ID indicated in the client request");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETREQUESTEDSESSIONID2,
            "Method getRequestedSessionId(): Returns null if no session ID was indicated in the client request");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_ISREQUESTEDSESSIONIDVALID1,
            "Method isRequestedSessionIdValid(): Returns true if the session ID is valid");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_ISREQUESTEDSESSIONIDVALID2,
            "Method isRequestedSessionIdValid(): Returns false if the session ID is not valid");
      tcd.put(
            V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETRESPONSECONTENTTYPE1,
            "Method getResponseContentType(): Returns a String representing the portal preferred content type for the response if the content type is defined in the portlet descriptor  ");
      tcd.put(
            V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETRESPONSECONTENTTYPE2,
            "Method getResponseContentType(): Returns an empty Enumeration if the content type is not defined in the portlet descriptor");
      tcd.put(
            V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETRESPONSECONTENTTYPES1,
            "Method getResponseContentTypes(): Returns an java.util.Enumeration&lt;java.lang.String&gt; object representing the portal preferred content types for the response if the content types are defined in the portlet descriptor");
      tcd.put(
            V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETRESPONSECONTENTTYPES2,
            "Method getResponseContentTypes(): Returns an empty Enumeration if the content types are not defined in the portlet descriptor");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETLOCALE,
            "Method getLocale(): Returns an java.util.Locale object representing the preferred Locale for the response");
      tcd.put(
            V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETLOCALES,
            "Method getLocales(): Returns an java.util.Enumeration&lt;java.util.Locale&gt; of the Locales in which the portal will accept content");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETSCHEME,
            "Method getScheme(): Returns a String value representing the scheme name for the request");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETSERVERNAME,
            "Method getServerName(): Returns a String value representing the host name for the request");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETSERVERPORT,
            "Method getServerPort(): Returns an int value representing the port number for the request");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETWINDOWID,
            "Method getWindowID(): Returns a String value representing the portlet window ID");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETCOOKIES1,
            "Method getCookies(): Returns a javax.servlet.http.Cookie[] array containing the cookies for this request");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETCOOKIES2,
            "Method getCookies(): Returns null if no cookies are present");
      tcd.put(
            V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPRIVATEPARAMETERMAP1,
            "Method getPrivateParameterMap(): Returns an java.util.Map&lt;java.lang.String,java.lang.String[]&gt; object for the private parameter names and values if available");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPRIVATEPARAMETERMAP2,
            "Method getPrivateParameterMap(): The returned map is immutable");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPRIVATEPARAMETERMAP3,
            "Method getPrivateParameterMap(): Returns an empty map if no private parameters exist");
      tcd.put(
            V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPUBLICPARAMETERMAP1,
            "Method getPublicParameterMap(): Returns an java.util.Map&lt;java.lang.String,java.lang.String[]&gt; object for the public parameter names and values if available");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPUBLICPARAMETERMAP2,
            "Method getPublicParameterMap(): The returned map is immutable");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPUBLICPARAMETERMAP3,
            "Method getPublicParameterMap(): Returns an empty map if no public parameters exist");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_EXISTS,
            "Method exists(): The P3PUserInfos exist as a public static enum");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_FIELDUSER_INFO,
            "Has String field USER_INFO with value of \"javax.portlet.userinfo\" ");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_FIELDCCPP_PROFILE,
            "Has String field CCPP_PROFILE with value of \"javax.portlet.ccpp\" ");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_FIELDBASIC_AUTH,
            "Has String field BASIC_AUTH with value of \"BASIC\" ");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_FIELDFORM_AUTH,
            "Has String field FORM_AUTH with value of \"FORM\" ");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_FIELDCLIENT_CERT_AUTH,
            "Has String field CLIENT_CERT_AUTH with value of \"CLIENT_CERT\" ");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_FIELDDIGEST_AUTH,
            "Has String field DIGEST_AUTH with value of \"DIGEST\" ");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_FIELDACTION_PHASE,
            "Has String field ACTION_PHASE with value of \"ACTION_PHASE\" ");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_FIELDEVENT_PHASE,
            "Has String field EVENT_PHASE with value of \"EVENT_PHASE\" ");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_FIELDRENDER_PHASE,
            "Has String field RENDER_PHASE with value of \"RENDER_PHASE\" ");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_FIELDRESOURCE_PHASE,
            "Has String field RESOURCE_PHASE with value of \"RESOURCE_PHASE\" ");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_FIELDLIFECYCLE_PHASE,
            "Has String field LIFECYCLE_PHASE with value of \"javax.portlet.lifecycle_phase\" ");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_FIELDRENDER_PART,
            "Has String field RENDER_PART with value of \"javax.portlet.render_part\" ");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_FIELDRENDER_HEADERS,
            "Has String field RENDER_HEADERS with value of \"RENDER_HEADERS\" ");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_FIELDRENDER_MARKUP,
            "Has String field RENDER_MARKUP with value of \"RENDER_MARKUP\" ");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_FIELDACTION_SCOPE_ID,
            "Has String field ACTION_SCOPE_ID with value of \"javax.portlet.as\" ");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_ISWINDOWSTATEALLOWED1,
            "Method isWindowStateAllowed(WindowState): Returns true if the specified WindowState is allowed");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_ISWINDOWSTATEALLOWED2,
            "Method isWindowStateAllowed(WindowState): Returns false if the specified WindowState is not allowed");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_ISPORTLETMODEALLOWED1,
            "Method isPortletModeAllowed(PortletMode): Returns true if the specified PortletMode is allowed");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_ISPORTLETMODEALLOWED2,
            "Method isPortletModeAllowed(PortletMode): Returns false if the specified PortletMode is not allowed");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPORTLETMODE,
            "Method getPortletMode(): Returns current PortletMode");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETWINDOWSTATE,
            "Method getWindowState(): Returns current WindowState");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPREFERENCES,
            "Method getPreferences(): Returns the PortletPreferences object associated with the portlet");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPORTLETSESSIONA1,
            "Method getPortletSession(): Returns current PortletSession if one already exists");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPORTLETSESSIONA2,
            "Method getPortletSession(): Returns new PortletSession if one does not already exist");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPORTLETSESSIONB1,
            "Method getPortletSession(boolean): If input flag is true, returns current PortletSession if one already exists");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPORTLETSESSIONB2,
            "Method getPortletSession(boolean): If input flag is true, returns new PortletSession if one does not already exist");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPORTLETSESSIONB3,
            "Method getPortletSession(boolean): If input flag is false, returns current PortletSession if one already exists");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPORTLETSESSIONB4,
            "Method getPortletSession(boolean): If input flag is false, returns null if one does not already exist");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPROPERTY1,
            "Method getProperty(String): If specified request property exists, returns its value");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPROPERTY2,
            "Method getProperty(String): If specified request property does not exist, returns null");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPROPERTY3,
            "Method getProperty(String): Throws IllegalArgumentException if the name is null");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPROPERTIES1,
            "Method getProperties(String): If specified request property exists, returns its values as an Enumeration");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPROPERTIES2,
            "Method getProperties(String): If specified request property does not exist, returns an empty Enumeration");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPROPERTIES3,
            "Method getProperties(String): Throws IllegalArgumentException if the name is null");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPROPERTYNAMES1,
            "Method getPropertyNames(): Returns an Enumeration of all request property names");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPROPERTYNAMES2,
            "Method getPropertyNames(): Returns an empty Enumeration if there are no request properties defined");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPORTALCONTEXT,
            "Method getPortalContext(): Returns the context of the portal");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETAUTHTYPE1,
            "Method getAuthType(): Returns a String indicating the authentication type if the request was authenticated");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETAUTHTYPE2,
            "Method getAuthType(): Returns null if the request was not authenticated");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETCONTEXTPATH1,
            "Method getContextPath(): Returns a String representing the context path associated with the portlet");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETCONTEXTPATH2,
            "Method getContextPath(): Returns an empty String if the portlet is deployed in the default context");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETCONTEXTPATH3,
            "Method getContextPath(): If the context path is not empty, it must start with \"/\" and may not end with \"/\"");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETREMOTEUSER1,
            "Method getRemoteUser(): Returns a String representing the login of the user if the request is authenticated");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETREMOTEUSER2,
            "Method getRemoteUser(): Returns null if the request has not been authenticated");
      tcd.put(
            V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETUSERPRINCIPAL1,
            "Method getUserPrincipal(): Returns a java.security.Principal object representing the user if the request has been authenticated");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETUSERPRINCIPAL2,
            "Method getUserPrincipal(): Returns null if the request has not been authenticated");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_ISUSERINROLE1,
            "Method isUserInRole(): Returns true if the authenticated user is in the specified role");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_ISUSERINROLE2,
            "Method isUserInRole(): Returns false if the authenticated user is not in the specified role");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_ISUSERINROLE3,
            "Method isUserInRole(): Returns false if the user is not authenticated");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETATTRIBUTE1,
            "Method getAttribute(String): Returns a java.lang.Object for the specified attribute name");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETATTRIBUTE2,
            "Method getAttribute(String): Returns null if no attribute with the specified name exists");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETATTRIBUTE3,
            "Method getAttribute(String): Throws IllegalArgumentException if the name is null");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETATTRIBUTENAMES1,
            "Method getAttributeNames(): Returns a java.util.Enumeration&lt;java.lang.String&gt; of the available attribute names");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETATTRIBUTENAMES2,
            "Method getAttributeNames(): Returns an empty Enumeration if there are no attributes available");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPARAMETER1,
            "Method getParameter(String): Returns String value of parameter specified by the name");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPARAMETER2,
            "Method getParameter(String): Returns String value of a public render parameter specified by the name");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPARAMETER3,
            "Method getParameter(String): Returns null if no parameter exists for the specified name");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPARAMETER4,
            "Method getParameter(String): Returns first String value from values array if use with a multivalued parameter");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPARAMETER5,
            "Method getParameter(String): Throws IllegalArgumentException if the name is null");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPARAMETERNAMES1,
            "Method getParameterNames(): Returns a java.util.Enumeration&lt;java.lang.String&gt; of the available parameter names");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPARAMETERNAMES2,
            "Method getParameterNames(): Returns an empty Enumeration if there are no parameters available");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPARAMETERVALUES1,
            "Method getParameterValues(String): Returns String[] value of parameter specified by the name");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPARAMETERVALUES2,
            "Method getParameterValues(String): Returns String[] value of a public render parameter specified by the name");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPARAMETERVALUES3,
            "Method getParameterValues(String): Returns null if no parameter exists for the specified name");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPARAMETERVALUES4,
            "Method getParameterValues(String): Throws IllegalArgumentException if the name is null");
      tcd.put(
            V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPARAMETERMAP1,
            "Method getParameterMap(): Returns an java.util.Map&lt;java.lang.String,java.lang.String[]&gt; object for the parameter names and values if parameters are available");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPARAMETERMAP2,
            "Method getParameterMap(): The returned map contains all public and private parameters for the request");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPARAMETERMAP3,
            "Method getParameterMap(): Returns an empty map if no parameters exist");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_ISSECURE1,
            "Method isSecure(): Returns true if the request was made through a secure channel");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_ISSECURE2,
            "Method isSecure(): Returns false if the request was not made through a secure channel");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_SETATTRIBUTE1,
            "Method setAttribute(String, Object): Stores an attribute object under the specified name in the request");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_SETATTRIBUTE2,
            "Method setAttribute(String, Object): Removes the attribute by the specified name if the object is null");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_SETATTRIBUTE3,
            "Method setAttribute(String, Object): Throws IllegalArgumentException if the name is null");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_REMOVEATTRIBUTE1,
            "Method removeAttribute(String): Removes the attribute specified by the name from the request");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_REMOVEATTRIBUTE2,
            "Method removeAttribute(String): Throws IllegalArgumentException if the name is null");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETREQUESTEDSESSIONID1,
            "Method getRequestedSessionId(): Returns the session ID indicated in the client request");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETREQUESTEDSESSIONID2,
            "Method getRequestedSessionId(): Returns null if no session ID was indicated in the client request");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_ISREQUESTEDSESSIONIDVALID1,
            "Method isRequestedSessionIdValid(): Returns true if the session ID is valid");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_ISREQUESTEDSESSIONIDVALID2,
            "Method isRequestedSessionIdValid(): Returns false if the session ID is not valid");
      tcd.put(
            V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETRESPONSECONTENTTYPE1,
            "Method getResponseContentType(): Returns a String representing the portal preferred content type for the response if the content type is defined in the portlet descriptor  ");
      tcd.put(
            V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETRESPONSECONTENTTYPE2,
            "Method getResponseContentType(): Returns an empty Enumeration if the content type is not defined in the portlet descriptor");
      tcd.put(
            V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETRESPONSECONTENTTYPES1,
            "Method getResponseContentTypes(): Returns an java.util.Enumeration&lt;java.lang.String&gt; object representing the portal preferred content types for the response if the content types are defined in the portlet descriptor");
      tcd.put(
            V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETRESPONSECONTENTTYPES2,
            "Method getResponseContentTypes(): Returns an empty Enumeration if the content types are not defined in the portlet descriptor");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETLOCALE,
            "Method getLocale(): Returns an java.util.Locale object representing the preferred Locale for the response");
      tcd.put(
            V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETLOCALES,
            "Method getLocales(): Returns an java.util.Enumeration&lt;java.util.Locale&gt; of the Locales in which the portal will accept content");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETSCHEME,
            "Method getScheme(): Returns a String value representing the scheme name for the request");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETSERVERNAME,
            "Method getServerName(): Returns a String value representing the host name for the request");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETSERVERPORT,
            "Method getServerPort(): Returns an int value representing the port number for the request");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETWINDOWID,
            "Method getWindowID(): Returns a String value representing the portlet window ID");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETCOOKIES1,
            "Method getCookies(): Returns a javax.servlet.http.Cookie[] array containing the cookies for this request");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETCOOKIES2,
            "Method getCookies(): Returns null if no cookies are present");
      tcd.put(
            V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPRIVATEPARAMETERMAP1,
            "Method getPrivateParameterMap(): Returns an java.util.Map&lt;java.lang.String,java.lang.String[]&gt; object for the private parameter names and values if available");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPRIVATEPARAMETERMAP2,
            "Method getPrivateParameterMap(): The returned map is immutable");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPRIVATEPARAMETERMAP3,
            "Method getPrivateParameterMap(): Returns an empty map if no private parameters exist");
      tcd.put(
            V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPUBLICPARAMETERMAP1,
            "Method getPublicParameterMap(): Returns an java.util.Map&lt;java.lang.String,java.lang.String[]&gt; object for the public parameter names and values if available");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPUBLICPARAMETERMAP2,
            "Method getPublicParameterMap(): The returned map is immutable");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_GETPUBLICPARAMETERMAP3,
            "Method getPublicParameterMap(): Returns an empty map if no public parameters exist");
      tcd.put(V2REQUESTTESTS_PORTLETREQUEST_APIRESOURCE_EXISTS,
            "Method exists(): The P3PUserInfos exist as a public static enum");
      tcd.put(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETPORTLETINPUTSTREAM1,
            "Method getPortletInputStream(): Returns an InputStream object");
      tcd.put(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETPORTLETINPUTSTREAM2,
            "Method getPortletInputStream(): Throws IllegalStateException if getReader was already called");
      tcd.put(
            V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETPORTLETINPUTSTREAM3,
            "Method getPortletInputStream(): Throws IllegalStateException if the request has HTTP POST data of type application/x-www-form-urlencoded");
      tcd.put(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_SETCHARACTERENCODING1,
            "Method setCharacterEncoding(String): Allows the character encoding for the body of the request to be overridden");
      tcd.put(
            V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_SETCHARACTERENCODING2,
            "Method setCharacterEncoding(String): Throws IllegalStateException if method is called after reading request parameters");
      tcd.put(
            V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_SETCHARACTERENCODING3,
            "Method setCharacterEncoding(String): Throws IllegalStateException if method is called after using the getReader(): method");
      tcd.put(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_SETCHARACTERENCODING4,
            "Method setCharacterEncoding(String): Throws UnsupportedEncodingException if the specified encoding is not valid");
      tcd.put(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETREADER1,
            "Method getReader(): Returns a BufferedReader object for reading the request");
      tcd.put(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETREADER2,
            "Method getReader(): Throws IllegalStateException if getPortletInputStream was already called");
      tcd.put(
            V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETREADER3,
            "Method getReader(): Throws IllegalStateException if the request has HTTP POST data of type application/x-www-form-urlencoded");
      tcd.put(
            V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETREADER5,
            "Method getReader(): Throws UnsupportedEncodingException if the character set encoding is not valid so that the text cannot be decoded");
      tcd.put(
            V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCHARACTERENCODING1,
            "Method getCharacterEncoding(): Returns a String containing the name of the character encoding used in the request body");
      tcd.put(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCHARACTERENCODING2,
            "Method getCharacterEncoding(): Returns null if the request does not specify a character encoding");
      tcd.put(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCONTENTTYPE1,
            "Method getContentType(): Returns a String containing the MIME type of the request body");
      tcd.put(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCONTENTTYPE2,
            "Method getContentType(): Returns null if the MIME type is unknown");
      tcd.put(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCONTENTLENGTH1,
            "Method getContentLength(): Returns the length in bytes of the request body");
      tcd.put(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETCONTENTLENGTH2,
            "Method getContentLength(): Returns -1 if the length is unknown");
      tcd.put(V2REQUESTTESTS_CLIENTDATAREQUEST_APIACTION_GETMETHOD,
            "Method getMethod(): Returns a String containing the name of the HTTP method with which the request was made");
      tcd.put(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETPORTLETINPUTSTREAM1,
            "Method getPortletInputStream(): Returns an InputStream object");
      tcd.put(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETPORTLETINPUTSTREAM2,
            "Method getPortletInputStream(): Throws IllegalStateException if getReader was already called");
      tcd.put(
            V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETPORTLETINPUTSTREAM3,
            "Method getPortletInputStream(): Throws IllegalStateException if the request has HTTP POST data of type application/x-www-form-urlencoded");
      tcd.put(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_SETCHARACTERENCODING1,
            "Method setCharacterEncoding(String): Allows the character encoding for the body of the request to be overridden");
      tcd.put(
            V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_SETCHARACTERENCODING2,
            "Method setCharacterEncoding(String): Throws IllegalStateException if method is called after reading request parameters");
      tcd.put(
            V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_SETCHARACTERENCODING3,
            "Method setCharacterEncoding(String): Throws IllegalStateException if method is called after using the getReader(): method");
      tcd.put(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_SETCHARACTERENCODING4,
            "Method setCharacterEncoding(String): Throws UnsupportedEncodingException if the specified encoding is not valid");
      tcd.put(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETREADER1,
            "Method getReader(): Returns a BufferedReader object for reading the request");
      tcd.put(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETREADER2,
            "Method getReader(): Throws IllegalStateException if getPortletInputStream was already called");
      tcd.put(
            V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETREADER3,
            "Method getReader(): Throws IllegalStateException if the request has HTTP POST data of type application/x-www-form-urlencoded");
      tcd.put(
            V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETREADER5,
            "Method getReader(): Throws UnsupportedEncodingException if the character set encoding is not valid so that the text cannot be decoded");
      tcd.put(
            V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETCHARACTERENCODING1,
            "Method getCharacterEncoding(): Returns a String containing the name of the character encoding used in the request body");
      tcd.put(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETCHARACTERENCODING2,
            "Method getCharacterEncoding(): Returns null if the request does not specify a character encoding");
      tcd.put(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETCONTENTTYPE1,
            "Method getContentType(): Returns a String containing the MIME type of the request body");
      tcd.put(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETCONTENTTYPE2,
            "Method getContentType(): Returns null if the MIME type is unknown");
      tcd.put(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETCONTENTLENGTH1,
            "Method getContentLength(): Returns the length in bytes of the request body");
      tcd.put(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETCONTENTLENGTH2,
            "Method getContentLength(): Returns -1 if the length is unknown");
      tcd.put(V2REQUESTTESTS_CLIENTDATAREQUEST_APIRESOURCE_GETMETHOD,
            "Method getMethod(): Returns a String containing the name of the HTTP method with which the request was made");
      tcd.put(V2REQUESTTESTS_ACTIONREQUEST_APIACTION_FIELDACTION_NAME,
            "Has String field ACTION_NAME with value of \"javax.portlet.action\" ");
      tcd.put(V2REQUESTTESTS_RESOURCEREQUEST_APIRESOURCE_FIELDETAG,
            "Has String field ETAG with value of \"portlet.ETag\" ");
      tcd.put(V2REQUESTTESTS_RESOURCEREQUEST_APIRESOURCE_GETETAG2,
            "Method getETag(): Returns null if there is no cached response");
      tcd.put(V2REQUESTTESTS_RESOURCEREQUEST_APIRESOURCE_GETRESOURCEID1,
            "Method getResourceID(): Returns a String containing the resource ID set on the resource URL");
      tcd.put(V2REQUESTTESTS_RESOURCEREQUEST_APIRESOURCE_GETRESOURCEID2,
            "Method getResourceID(): Returns null if no resource ID was set on the URL");
      tcd.put(
            V2REQUESTTESTS_RESOURCEREQUEST_APIRESOURCE_GETPRIVATERENDERPARAMETERMAP1,
            "Method getPrivateRenderParameterMap(): Returns a java.util.Map&lt;java.lang.String,java.lang.String[]&gt; object containing the private render parameters for the request");
      tcd.put(V2REQUESTTESTS_RESOURCEREQUEST_APIRESOURCE_GETPRIVATERENDERPARAMETERMAP2,
            "Method getPrivateRenderParameterMap(): The returned map does not contain the resource parameters set on the URL");
      tcd.put(V2REQUESTTESTS_RESOURCEREQUEST_APIRESOURCE_GETPRIVATERENDERPARAMETERMAP3,
            "Method getPrivateRenderParameterMap(): The returned map is immutable");
      tcd.put(V2REQUESTTESTS_RESOURCEREQUEST_APIRESOURCE_GETPRIVATERENDERPARAMETERMAP4,
            "Method getPrivateRenderParameterMap(): Returns an empty map if there are no private render parameters");
      tcd.put(V2REQUESTTESTS_RESOURCEREQUEST_APIRESOURCE_GETRESPONSECONTENTTYPE,
            "Method getResponseContentType(): Returns a String containing the preferred content type for the resonse");
      tcd.put(
            V2REQUESTTESTS_RESOURCEREQUEST_APIRESOURCE_GETRESPONSECONTENTTYPES,
            "Method getResponseContentTypes(): Returns an java.util.Enumeration&lt;java.lang.String&gt; object containing the content types that will be accepted for the response");
      tcd.put(V2REQUESTTESTS_RESOURCEREQUEST_APIRESOURCE_GETCACHEABILITY,
            "Method getCacheability(): Returns a String containing the cache level of the resource request");
      tcd.put(V2REQUESTTESTS_EVENTREQUEST_APIEVENT_GETEVENT,
            "Method getEvent(): Returns the Event object that triggered the call to the processEvent method");
      tcd.put(V2REQUESTTESTS_EVENTREQUEST_APIEVENT_GETMETHOD,
            "Method getMethod(): Returns a String containing the name of the HTTP method with which the request was made");
      tcd.put(V2REQUESTTESTS_RENDERREQUEST_APIRENDER_FIELDETAG, "Has String field ETAG with value of \"portlet.ETag\" ");
      tcd.put(V2REQUESTTESTS_RENDERREQUEST_APIRENDER_GETETAG2,
            "Method getETag(): Returns null if there is no cached response");
      tcd.put(V2RESPONSETESTS_PORTLETRESPONSE_APIRENDER_ADDPROPERTYA1,
            "Method addProperty(javax.servlet.http.Cookie): Adds the specified cookie property to the response");
      tcd.put(V2RESPONSETESTS_PORTLETRESPONSE_APIRENDER_ADDPROPERTYA2,
            "Method addProperty(javax.servlet.http.Cookie): Throws IllegalArgumentException if the specified cookie is null");
      tcd.put(V2RESPONSETESTS_PORTLETRESPONSE_APIRENDER_ADDPROPERTYB1,
            "Method addProperty(String, org.w3c.dom.Element): Adds an XML DOM Element to the response for the specified key");
      tcd.put(
            V2RESPONSETESTS_PORTLETRESPONSE_APIRENDER_ADDPROPERTYB3,
            "Method addProperty(String, org.w3c.dom.Element): If the specified DOM Element value is null, the key is removed from the response");
      tcd.put(V2RESPONSETESTS_PORTLETRESPONSE_APIRENDER_ADDPROPERTYB4,
            "Method addProperty(String, org.w3c.dom.Element): Throws IllegalArgumentException if the specified key is null");
      tcd.put(V2RESPONSETESTS_PORTLETRESPONSE_APIRENDER_ADDPROPERTYC1,
            "Method addProperty(String, String): A property can be added");
      tcd.put(V2RESPONSETESTS_PORTLETRESPONSE_APIRENDER_ADDPROPERTYC2,
            "Method addProperty(String, String): Throws IllegalArgumentException if the specified key is null");
      tcd.put(V2RESPONSETESTS_PORTLETRESPONSE_APIRENDER_SETPROPERTY1,
            "Method setProperty(String, String): Sets a property value for the specified key");
      tcd.put(V2RESPONSETESTS_PORTLETRESPONSE_APIRENDER_SETPROPERTY3,
            "Method setProperty(String, String): Throws IllegalArgumentException if the specified key is null");
      tcd.put(V2RESPONSETESTS_PORTLETRESPONSE_APIRENDER_ENCODEURL1,
            "Method encodeURL(String): Returns a String representing the encoded URL");
      tcd.put(
            V2RESPONSETESTS_PORTLETRESPONSE_APIRENDER_ENCODEURL2,
            "Method encodeURL(String): Throws IllegalArgumentException if the input string is not an absolute URL and does not start with at \"/\" character");
      tcd.put(V2RESPONSETESTS_PORTLETRESPONSE_APIRENDER_GETNAMESPACE1,
            "Method getNamespace(): Returns a String containing the namespace value");
      tcd.put(V2RESPONSETESTS_PORTLETRESPONSE_APIRENDER_CREATEELEMENT1,
            "Method createElement(String): Returns an org.w3c.dom.Element object for the specified tag name");
      tcd.put(V2RESPONSETESTS_PORTLETRESPONSE_APIRENDER_CREATEELEMENT2,
            "Method createElement(String): The returned Element has nodeName set to the the specified tag name");
      tcd.put(V2RESPONSETESTS_PORTLETRESPONSE_APIRENDER_CREATEELEMENT3,
            "Method createElement(String): The returned Element has localName set to null");
      tcd.put(V2RESPONSETESTS_PORTLETRESPONSE_APIRENDER_CREATEELEMENT4,
            "Method createElement(String): The returned Element has prefix set to null");
      tcd.put(V2RESPONSETESTS_PORTLETRESPONSE_APIRENDER_CREATEELEMENT5,
            "Method createElement(String): The returned Element has namespaceURI set to null");
      tcd.put(
            V2RESPONSETESTS_PORTLETRESPONSE_APIRENDER_CREATEELEMENT6,
            "Method createElement(String): Throws org.w3c.dom.DOMException - INVALID_CHARACTER_ERR if the specified name contains an illegal character. ");
      tcd.put(V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_ADDPROPERTYA1,
            "Method addProperty(javax.servlet.http.Cookie): Adds the specified cookie property to the response");
      tcd.put(V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_ADDPROPERTYA2,
            "Method addProperty(javax.servlet.http.Cookie): Throws IllegalArgumentException if the specified cookie is null");
      tcd.put(V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_ADDPROPERTYB1,
            "Method addProperty(String, org.w3c.dom.Element): Adds an XML DOM Element to the response for the specified key");
      tcd.put(
            V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_ADDPROPERTYB2,
            "Method addProperty(String, org.w3c.dom.Element): If a DOM Element for the specified key already exists, the new element is added in addition to the existing element");
      tcd.put(
            V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_ADDPROPERTYB3,
            "Method addProperty(String, org.w3c.dom.Element): If the specified DOM Element value is null, the key is removed from the response");
      tcd.put(V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_ADDPROPERTYB4,
            "Method addProperty(String, org.w3c.dom.Element): Throws IllegalArgumentException if the specified key is null");
      tcd.put(V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_ADDPROPERTYC1,
            "Method addProperty(String, String): A property can be added");
      tcd.put(V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_ADDPROPERTYC2,
            "Method addProperty(String, String): Throws IllegalArgumentException if the specified key is null");
      tcd.put(V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_SETPROPERTY1,
            "Method setProperty(String, String): Sets a property value for the specified key");
      tcd.put(V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_SETPROPERTY2,
            "Method setProperty(String, String): Resets any existing property values for the specified key");
      tcd.put(V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_SETPROPERTY3,
            "Method setProperty(String, String): Throws IllegalArgumentException if the specified key is null");
      tcd.put(V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_ENCODEURL1,
            "Method encodeURL(String): Returns a String representing the encoded URL");
      tcd.put(
            V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_ENCODEURL2,
            "Method encodeURL(String): Throws IllegalArgumentException if the input string is not an absolute URL and does not start with at \"/\" character");
      tcd.put(V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_GETNAMESPACE1,
            "Method getNamespace(): Returns a String containing the namespace value");
      tcd.put(V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_CREATEELEMENT1,
            "Method createElement(String): Returns an org.w3c.dom.Element object for the specified tag name");
      tcd.put(V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_CREATEELEMENT2,
            "Method createElement(String): The returned Element has nodeName set to the the specified tag name");
      tcd.put(V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_CREATEELEMENT3,
            "Method createElement(String): The returned Element has localName set to null");
      tcd.put(V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_CREATEELEMENT4,
            "Method createElement(String): The returned Element has prefix set to null");
      tcd.put(V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_CREATEELEMENT5,
            "Method createElement(String): The returned Element has namespaceURI set to null");
      tcd.put(
            V2RESPONSETESTS_PORTLETRESPONSE_APIRESOURCE_CREATEELEMENT6,
            "Method createElement(String): Throws org.w3c.dom.DOMException - INVALID_CHARACTER_ERR if the specified name contains an illegal character. ");
      tcd.put(V2RESPONSETESTS_PORTLETRESPONSE_APIACTION_ADDPROPERTYA1,
            "Method addProperty(javax.servlet.http.Cookie): Adds the specified cookie property to the response");
      tcd.put(V2RESPONSETESTS_PORTLETRESPONSE_APIACTION_ADDPROPERTYA2,
            "Method addProperty(javax.servlet.http.Cookie): Throws IllegalArgumentException if the specified cookie is null");
      tcd.put(V2RESPONSETESTS_PORTLETRESPONSE_APIACTION_ADDPROPERTYB1,
            "Method addProperty(String, org.w3c.dom.Element): Adds an XML DOM Element to the response for the specified key");
      tcd.put(
            V2RESPONSETESTS_PORTLETRESPONSE_APIACTION_ADDPROPERTYB3,
            "Method addProperty(String, org.w3c.dom.Element): If the specified DOM Element value is null, the key is removed from the response");
      tcd.put(V2RESPONSETESTS_PORTLETRESPONSE_APIACTION_ADDPROPERTYB4,
            "Method addProperty(String, org.w3c.dom.Element): Throws IllegalArgumentException if the specified key is null");
      tcd.put(V2RESPONSETESTS_PORTLETRESPONSE_APIACTION_ADDPROPERTYC1,
            "Method addProperty(String, String): A property can be added");
      tcd.put(V2RESPONSETESTS_PORTLETRESPONSE_APIACTION_ADDPROPERTYC2,
            "Method addProperty(String, String): Throws IllegalArgumentException if the specified key is null");
      tcd.put(V2RESPONSETESTS_PORTLETRESPONSE_APIACTION_SETPROPERTY1,
            "Method setProperty(String, String): Sets a property value for the specified key");
      tcd.put(V2RESPONSETESTS_PORTLETRESPONSE_APIACTION_SETPROPERTY3,
            "Method setProperty(String, String): Throws IllegalArgumentException if the specified key is null");
      tcd.put(V2RESPONSETESTS_PORTLETRESPONSE_APIACTION_ENCODEURL1,
            "Method encodeURL(String): Returns a String representing the encoded URL");
      tcd.put(
            V2RESPONSETESTS_PORTLETRESPONSE_APIACTION_ENCODEURL2,
            "Method encodeURL(String): Throws IllegalArgumentException if the input string is not an absolute URL and does not start with at \"/\" character");
      tcd.put(V2RESPONSETESTS_PORTLETRESPONSE_APIACTION_GETNAMESPACE1,
            "Method getNamespace(): Returns a String containing the namespace value");
      tcd.put(V2RESPONSETESTS_PORTLETRESPONSE_APIACTION_CREATEELEMENT1,
            "Method createElement(String): Returns an org.w3c.dom.Element object for the specified tag name");
      tcd.put(V2RESPONSETESTS_PORTLETRESPONSE_APIACTION_CREATEELEMENT2,
            "Method createElement(String): The returned Element has nodeName set to the the specified tag name");
      tcd.put(V2RESPONSETESTS_PORTLETRESPONSE_APIACTION_CREATEELEMENT3,
            "Method createElement(String): The returned Element has localName set to null");
      tcd.put(V2RESPONSETESTS_PORTLETRESPONSE_APIACTION_CREATEELEMENT4,
            "Method createElement(String): The returned Element has prefix set to null");
      tcd.put(V2RESPONSETESTS_PORTLETRESPONSE_APIACTION_CREATEELEMENT5,
            "Method createElement(String): The returned Element has namespaceURI set to null");
      tcd.put(
            V2RESPONSETESTS_PORTLETRESPONSE_APIACTION_CREATEELEMENT6,
            "Method createElement(String): Throws org.w3c.dom.DOMException - INVALID_CHARACTER_ERR if the specified name contains an illegal character. ");
      tcd.put(V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_ADDPROPERTYA1,
            "Method addProperty(javax.servlet.http.Cookie): Adds the specified cookie property to the response");
      tcd.put(V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_ADDPROPERTYA2,
            "Method addProperty(javax.servlet.http.Cookie): Throws IllegalArgumentException if the specified cookie is null");
      tcd.put(V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_ADDPROPERTYB1,
            "Method addProperty(String, org.w3c.dom.Element): Adds an XML DOM Element to the response for the specified key");
      tcd.put(
            V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_ADDPROPERTYB3,
            "Method addProperty(String, org.w3c.dom.Element): If the specified DOM Element value is null, the key is removed from the response");
      tcd.put(V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_ADDPROPERTYB4,
            "Method addProperty(String, org.w3c.dom.Element): Throws IllegalArgumentException if the specified key is null");
      tcd.put(V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_ADDPROPERTYC1,
            "Method addProperty(String, String): A property can be added");
      tcd.put(V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_ADDPROPERTYC2,
            "Method addProperty(String, String): Throws IllegalArgumentException if the specified key is null");
      tcd.put(V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_SETPROPERTY1,
            "Method setProperty(String, String): Sets a property value for the specified key");
      tcd.put(V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_SETPROPERTY3,
            "Method setProperty(String, String): Throws IllegalArgumentException if the specified key is null");
      tcd.put(V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_ENCODEURL1,
            "Method encodeURL(String): Returns a String representing the encoded URL");
      tcd.put(
            V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_ENCODEURL2,
            "Method encodeURL(String): Throws IllegalArgumentException if the input string is not an absolute URL and does not start with at \"/\" character");
      tcd.put(V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_GETNAMESPACE1,
            "Method getNamespace(): Returns a String containing the namespace value");
      tcd.put(V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_CREATEELEMENT1,
            "Method createElement(String): Returns an org.w3c.dom.Element object for the specified tag name");
      tcd.put(V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_CREATEELEMENT2,
            "Method createElement(String): The returned Element has nodeName set to the the specified tag name");
      tcd.put(V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_CREATEELEMENT3,
            "Method createElement(String): The returned Element has localName set to null");
      tcd.put(V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_CREATEELEMENT4,
            "Method createElement(String): The returned Element has prefix set to null");
      tcd.put(V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_CREATEELEMENT5,
            "Method createElement(String): The returned Element has namespaceURI set to null");
      tcd.put(
            V2RESPONSETESTS_PORTLETRESPONSE_APIEVENT_CREATEELEMENT6,
            "Method createElement(String): Throws org.w3c.dom.DOMException - INVALID_CHARACTER_ERR if the specified name contains an illegal character. ");
      tcd.put(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETWINDOWSTATE1,
            "Method setWindowState(WindowState): Sets the WindowState to the specified value");
      tcd.put(
            V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETWINDOWSTATE2,
            "Method setWindowState(WindowState): Throws WindowStateException if the portlet cannot switch to the specified WindowState");
      tcd.put(
            V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETWINDOWSTATE3,
            "Method setWindowState(WindowState): Throws IllegalStateException if the method is invoked after the sendRedirect method has been called");
      tcd.put(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETPORTLETMODE1,
            "Method setPortletMode(PortletMode): Sets the PortletMode to the specified value");
      tcd.put(
            V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETPORTLETMODE2,
            "Method setPortletMode(PortletMode): Throws PortletModeException if the portlet cannot switch to the specified PortletMode");
      tcd.put(
            V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETPORTLETMODE3,
            "Method setPortletMode(PortletMode): Throws IllegalStateException if the method is invoked after the sendRedirect method has been called");
      tcd.put(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERS1,
            "Method setRenderParameters(java.util.Map): Sets the render parameter map to the specified value");
      tcd.put(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERS2,
            "Method setRenderParameters(java.util.Map): Public render parameters can be set through the map");
      tcd.put(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERS3,
            "Method setRenderParameters(java.util.Map): Private render parameters can be set through the map");
      tcd.put(
            V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERS4,
            "Method setRenderParameters(java.util.Map): Previously existing private render parameters not contained in the specified input map are removed");
      tcd.put(
            V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERS5,
            "Method setRenderParameters(java.util.Map): Previously existing public render parameters not contained in the specified input map remain unchanged");
      tcd.put(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERS6,
            "Method setRenderParameters(java.util.Map): Parameters that are set are available in subsequent render requests");
      tcd.put(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERS7,
            "Method setRenderParameters(java.util.Map): Throws IllegalArgumentException if the input map is null");
      tcd.put(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERS8,
            "Method setRenderParameters(java.util.Map): Throws IllegalArgumentException if any key in the map is null");
      tcd.put(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERS10,
            "Method setRenderParameters(java.util.Map): Throws IllegalArgumentException if the values array for any key is null");
      tcd.put(
            V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERS11,
            "Method setRenderParameters(java.util.Map): Throws IllegalArgumentException if any element in the values array is null");
      tcd.put(
            V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERS12,
            "Method setRenderParameters(java.util.Map): Throws IllegalStateException if the method is invoked after the sendRedirect method has been called");
      tcd.put(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERA1,
            "Method setRenderParameter(String, String): Sets the parameter value for the specified name");
      tcd.put(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERA2,
            "Method setRenderParameter(String, String): A private parameter can be set");
      tcd.put(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERA3,
            "Method setRenderParameter(String, String): A public parameter can be set");
      tcd.put(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERA4,
            "Method setRenderParameter(String, String): All previously existing values for the specified name are removed");
      tcd.put(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERA5,
            "Method setRenderParameter(String, String): If the value is null, all values for the specified name are removed");
      tcd.put(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERA6,
            "Method setRenderParameter(String, String): Parameters that are set are available in subsequent render requests");
      tcd.put(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERA7,
            "Method setRenderParameter(String, String): Throws IllegalArgumentException if the name is null");
      tcd.put(
            V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERA8,
            "Method setRenderParameter(String, String): Throws IllegalStateException if the method is invoked after the sendRedirect method has been called");
      tcd.put(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERB1,
            "Method setRenderParameter(String, String[]): Sets the parameter values for the specified name.");
      tcd.put(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERB2,
            "Method setRenderParameter(String, String[]): All existing values are removed");
      tcd.put(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERB3,
            "Method setRenderParameter(String, String[]): Parameters that are set are available in subsequent render requests");
      tcd.put(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERB4,
            "Method setRenderParameter(String, String[]): Throws IllegalArgumentException if the name is null");
      tcd.put(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERB5,
            "Method setRenderParameter(String, String[]): Throws IllegalArgumentException if the values array is null");
      tcd.put(
            V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETRENDERPARAMETERB6,
            "Method setRenderParameter(String, String[]): Throws IllegalStateException if the method is invoked after the sendRedirect method has been called");
      tcd.put(
            V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETEVENTA1,
            "Method setEvent(javax.xml.namespace.QName, java.io.Serializable): Publishes an event with the specified name and payload");
      tcd.put(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETEVENTA2,
            "Method setEvent(javax.xml.namespace.QName, java.io.Serializable): Throws IllegalArgumentException if the name is null");
      tcd.put(
            V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETEVENTA3,
            "Method setEvent(javax.xml.namespace.QName, java.io.Serializable): Throws IllegalArgumentException if the value is not serializable");
      tcd.put(
            V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETEVENTA4,
            "Method setEvent(javax.xml.namespace.QName, java.io.Serializable): Throws IllegalArgumentException if the value does not have a valid JAXB binding");
      tcd.put(
            V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETEVENTA5,
            "Method setEvent(javax.xml.namespace.QName, java.io.Serializable): Throws IllegalArgumentException if the value object type is not as specified in the deployment descriptor");
      tcd.put(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETEVENTB1,
            "Method setEvent(String, java.io.Serializable): Publishes an event with the specified name and payload");
      tcd.put(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETEVENTB2,
            "Method setEvent(String, java.io.Serializable): Throws IllegalArgumentException if the name is null");
      tcd.put(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETEVENTB3,
            "Method setEvent(String, java.io.Serializable): Throws IllegalArgumentException if the value is not serializable");
      tcd.put(
            V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETEVENTB4,
            "Method setEvent(String, java.io.Serializable): Throws IllegalArgumentException if the value does not have a valid JAXB binding");
      tcd.put(
            V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_SETEVENTB5,
            "Method setEvent(String, java.io.Serializable): Throws IllegalArgumentException if the value object type is not as specified in the deployment descriptor");
      tcd.put(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_GETRENDERPARAMETERMAP1,
            "Method getRenderParameterMap(): Returns a map of the render parameters currently set on the response");
      tcd.put(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_GETRENDERPARAMETERMAP2,
            "Method getRenderParameterMap(): The returned map contains public render parameters");
      tcd.put(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_GETRENDERPARAMETERMAP3,
            "Method getRenderParameterMap(): The returned map contains private render parameters");
      tcd.put(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_GETRENDERPARAMETERMAP4,
            "Method getRenderParameterMap(): An empty map is returned if no parameters have been set");
      tcd.put(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_GETPORTLETMODE1,
            "Method getPortletMode(): Returns the current PortletMode for the portlet");
      tcd.put(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_GETPORTLETMODE2,
            "Method getPortletMode(): Returns null if no PortletMode has been set");
      tcd.put(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_GETWINDOWSTATE1,
            "Method getWindowState(): Returns the current WindowState for the portlet");
      tcd.put(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_GETWINDOWSTATE2,
            "Method getWindowState(): Returns null if no WindowState has been set");
      tcd.put(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_REMOVEPUBLICRENDERPARAMETER1,
            "Method removePublicRenderParameter(String): Removes the specified public render parameter");
      tcd.put(V2RESPONSETESTS_STATEAWARERESPONSE_APIEVENT_REMOVEPUBLICRENDERPARAMETER2,
            "Method removePublicRenderParameter(String): Throws IllegalArgumentException if the name is null");
      tcd.put(V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETWINDOWSTATE1,
            "Method setWindowState(WindowState): Sets the WindowState to the specified value");
      tcd.put(
            V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETWINDOWSTATE2,
            "Method setWindowState(WindowState): Throws WindowStateException if the portlet cannot switch to the specified WindowState");
      tcd.put(
            V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETWINDOWSTATE3,
            "Method setWindowState(WindowState): Throws IllegalStateException if the method is invoked after the sendRedirect method has been called");
      tcd.put(V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETPORTLETMODE1,
            "Method setPortletMode(PortletMode): Sets the PortletMode to the specified value");
      tcd.put(
            V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETPORTLETMODE2,
            "Method setPortletMode(PortletMode): Throws PortletModeException if the portlet cannot switch to the specified PortletMode");
      tcd.put(
            V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETPORTLETMODE3,
            "Method setPortletMode(PortletMode): Throws IllegalStateException if the method is invoked after the sendRedirect method has been called");
      tcd.put(V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETRENDERPARAMETERS1,
            "Method setRenderParameters(java.util.Map): Sets the render parameter map to the specified value");
      tcd.put(V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETRENDERPARAMETERS2,
            "Method setRenderParameters(java.util.Map): Public render parameters can be set through the map");
      tcd.put(V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETRENDERPARAMETERS3,
            "Method setRenderParameters(java.util.Map): Private render parameters can be set through the map");
      tcd.put(
            V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETRENDERPARAMETERS4,
            "Method setRenderParameters(java.util.Map): Previously existing private render parameters not contained in the specified input map are removed");
      tcd.put(
            V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETRENDERPARAMETERS5,
            "Method setRenderParameters(java.util.Map): Previously existing public render parameters not contained in the specified input map remain unchanged");
      tcd.put(V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETRENDERPARAMETERS6,
            "Method setRenderParameters(java.util.Map): Parameters that are set are available in subsequent render requests");
      tcd.put(V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETRENDERPARAMETERS7,
            "Method setRenderParameters(java.util.Map): Throws IllegalArgumentException if the input map is null");
      tcd.put(V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETRENDERPARAMETERS8,
            "Method setRenderParameters(java.util.Map): Throws IllegalArgumentException if any key in the map is null");
      tcd.put(V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETRENDERPARAMETERS10,
            "Method setRenderParameters(java.util.Map): Throws IllegalArgumentException if the values array for any key is null");
      tcd.put(
            V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETRENDERPARAMETERS11,
            "Method setRenderParameters(java.util.Map): Throws IllegalArgumentException if any element in the values array is null");
      tcd.put(
            V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETRENDERPARAMETERS12,
            "Method setRenderParameters(java.util.Map): Throws IllegalStateException if the method is invoked after the sendRedirect method has been called");
      tcd.put(V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETRENDERPARAMETERA1,
            "Method setRenderParameter(String, String): Sets the parameter value for the specified name");
      tcd.put(V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETRENDERPARAMETERA2,
            "Method setRenderParameter(String, String): A private parameter can be set");
      tcd.put(V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETRENDERPARAMETERA3,
            "Method setRenderParameter(String, String): A public parameter can be set");
      tcd.put(V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETRENDERPARAMETERA4,
            "Method setRenderParameter(String, String): All previously existing values for the specified name are removed");
      tcd.put(V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETRENDERPARAMETERA5,
            "Method setRenderParameter(String, String): If the value is null, all values for the specified name are removed");
      tcd.put(V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETRENDERPARAMETERA6,
            "Method setRenderParameter(String, String): Parameters that are set are available in subsequent render requests");
      tcd.put(V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETRENDERPARAMETERA7,
            "Method setRenderParameter(String, String): Throws IllegalArgumentException if the name is null");
      tcd.put(
            V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETRENDERPARAMETERA8,
            "Method setRenderParameter(String, String): Throws IllegalStateException if the method is invoked after the sendRedirect method has been called");
      tcd.put(V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETRENDERPARAMETERB1,
            "Method setRenderParameter(String, String[]): Sets the parameter values for the specified name.");
      tcd.put(V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETRENDERPARAMETERB2,
            "Method setRenderParameter(String, String[]): All existing values are removed");
      tcd.put(V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETRENDERPARAMETERB3,
            "Method setRenderParameter(String, String[]): Parameters that are set are available in subsequent render requests");
      tcd.put(V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETRENDERPARAMETERB4,
            "Method setRenderParameter(String, String[]): Throws IllegalArgumentException if the name is null");
      tcd.put(V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETRENDERPARAMETERB5,
            "Method setRenderParameter(String, String[]): Throws IllegalArgumentException if the values array is null");
      tcd.put(
            V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETRENDERPARAMETERB6,
            "Method setRenderParameter(String, String[]): Throws IllegalStateException if the method is invoked after the sendRedirect method has been called");
      tcd.put(
            V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETEVENTA1,
            "Method setEvent(javax.xml.namespace.QName, java.io.Serializable): Publishes an event with the specified name and payload");
      tcd.put(V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETEVENTA2,
            "Method setEvent(javax.xml.namespace.QName, java.io.Serializable): Throws IllegalArgumentException if the name is null");
      tcd.put(
            V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETEVENTA3,
            "Method setEvent(javax.xml.namespace.QName, java.io.Serializable): Throws IllegalArgumentException if the value is not serializable");
      tcd.put(
            V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETEVENTA4,
            "Method setEvent(javax.xml.namespace.QName, java.io.Serializable): Throws IllegalArgumentException if the value does not have a valid JAXB binding");
      tcd.put(
            V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETEVENTA5,
            "Method setEvent(javax.xml.namespace.QName, java.io.Serializable): Throws IllegalArgumentException if the value object type is not as specified in the deployment descriptor");
      tcd.put(V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETEVENTB1,
            "Method setEvent(String, java.io.Serializable): Publishes an event with the specified name and payload");
      tcd.put(V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETEVENTB2,
            "Method setEvent(String, java.io.Serializable): Throws IllegalArgumentException if the name is null");
      tcd.put(V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETEVENTB3,
            "Method setEvent(String, java.io.Serializable): Throws IllegalArgumentException if the value is not serializable");
      tcd.put(
            V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETEVENTB4,
            "Method setEvent(String, java.io.Serializable): Throws IllegalArgumentException if the value does not have a valid JAXB binding");
      tcd.put(
            V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_SETEVENTB5,
            "Method setEvent(String, java.io.Serializable): Throws IllegalArgumentException if the value object type is not as specified in the deployment descriptor");
      tcd.put(V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_GETRENDERPARAMETERMAP1,
            "Method getRenderParameterMap(): Returns a map of the render parameters currently set on the response");
      tcd.put(V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_GETRENDERPARAMETERMAP2,
            "Method getRenderParameterMap(): The returned map contains public render parameters");
      tcd.put(V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_GETRENDERPARAMETERMAP3,
            "Method getRenderParameterMap(): The returned map contains private render parameters");
      tcd.put(V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_GETRENDERPARAMETERMAP4,
            "Method getRenderParameterMap(): An empty map is returned if no parameters have been set");
      tcd.put(V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_GETPORTLETMODE1,
            "Method getPortletMode(): Returns the current PortletMode for the portlet");
      tcd.put(V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_GETPORTLETMODE2,
            "Method getPortletMode(): Returns null if no PortletMode has been set");
      tcd.put(V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_GETWINDOWSTATE1,
            "Method getWindowState(): Returns the current WindowState for the portlet");
      tcd.put(V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_GETWINDOWSTATE2,
            "Method getWindowState(): Returns null if no WindowState has been set");
      tcd.put(V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_REMOVEPUBLICRENDERPARAMETER1,
            "Method removePublicRenderParameter(String): Removes the specified public render parameter");
      tcd.put(V2RESPONSETESTS_STATEAWARERESPONSE_APIACTION_REMOVEPUBLICRENDERPARAMETER2,
            "Method removePublicRenderParameter(String): Throws IllegalArgumentException if the name is null");
      tcd.put(V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTA1,
            "Method sendRedirect(String): Allows a redirect response to be sent to the client");
      tcd.put(V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTA2,
            "Method sendRedirect(String): Throws IllegalArgumentException if a relative path URL is specified");
      tcd.put(V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTA3,
            "Method sendRedirect(String): Throws IllegalStateException if setPortletMode has been called before this method");
      tcd.put(V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTA4,
            "Method sendRedirect(String): Throws IllegalStateException if setWindowState has been called before this method");
      tcd.put(V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTA5,
            "Method sendRedirect(String): Throws IllegalStateException if setRenderParameter has been called before this method");
      tcd.put(V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTA6,
            "Method sendRedirect(String): Throws IllegalStateException if setRenderParameters has been called before this method");
      tcd.put(
            V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTA7,
            "Method sendRedirect(String): Throws IllegalStateException if removePublicRenderParameter has been called before this method");
      tcd.put(V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTB1,
            "Method sendRedirect(String, String): Allows a redirect response to be sent to the client");
      tcd.put(V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTB2,
            "Method sendRedirect(String, String): Encodes a render URL as a parameter under the specified name on the redirect URL");
      tcd.put(V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTB3,
            "Method sendRedirect(String, String): The encoded render URL contains the currently set PortletMode");
      tcd.put(V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTB4,
            "Method sendRedirect(String, String): The encoded render URL contains the currently set WindowState");
      tcd.put(V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTB5,
            "Method sendRedirect(String, String): The encoded render URL contains the currently set render parameters");
      tcd.put(V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTB6,
            "Method sendRedirect(String, String): Throws IllegalArgumentException if a relative path URL is specified");
      tcd.put(
            V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTB7,
            "Method sendRedirect(String, String): Throws IllegalStateException if setPortletMode has been called before this method");
      tcd.put(
            V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTB8,
            "Method sendRedirect(String, String): Throws IllegalStateException if setWindowState has been called before this method");
      tcd.put(
            V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTB9,
            "Method sendRedirect(String, String): Throws IllegalStateException if setRenderParameter has been called before this method");
      tcd.put(
            V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTB10,
            "Method sendRedirect(String, String): Throws IllegalStateException if setRenderParameters has been called before this method");
      tcd.put(
            V2RESPONSETESTS_ACTIONRESPONSE_APIACTION_SENDREDIRECTB11,
            "Method sendRedirect(String, String): Throws IllegalStateException if removePublicRenderParameter has been called before this method");
      tcd.put(V2RESPONSETESTS_EVENTRESPONSE_APIEVENT_SETRENDERPARAMETERS1,
            "Method setRenderParameters(EventRequest): Copies all render parameters set on the EventRequest to the EventResponse");
      tcd.put(V2RESPONSETESTS_EVENTRESPONSE_APIEVENT_SETRENDERPARAMETERS2,
            "Method setRenderParameters(EventRequest): Throws IllegalArgumentException if the input EventRequest parameter is null");
      tcd.put(V2RESPONSETESTS_MIMERESPONSE_APIRENDER_FIELDEXPIRATION_CACHE,
            "Has String field EXPIRATION_CACHE with value of \"portlet.expiration-cache\"");
      tcd.put(V2RESPONSETESTS_MIMERESPONSE_APIRENDER_FIELDCACHE_SCOPE,
            "Has String field CACHE_SCOPE with value of \"portlet.cache-scope\"");
      tcd.put(V2RESPONSETESTS_MIMERESPONSE_APIRENDER_FIELDPUBLIC_SCOPE,
            "Has String field PUBLIC_SCOPE with value of \"portlet.public-scope\"");
      tcd.put(V2RESPONSETESTS_MIMERESPONSE_APIRENDER_FIELDPRIVATE_SCOPE,
            "Has String field PRIVATE_SCOPE with value of \"portlet.private-scope\"");
      tcd.put(V2RESPONSETESTS_MIMERESPONSE_APIRENDER_FIELDETAG, "Has String field ETAG with value of \"portlet.ETag\"");
      tcd.put(V2RESPONSETESTS_MIMERESPONSE_APIRENDER_FIELDUSE_CACHED_CONTENT,
            "Has String field USE_CACHED_CONTENT with value of \"portlet.use-cached-content\"");
      tcd.put(V2RESPONSETESTS_MIMERESPONSE_APIRENDER_FIELDNAMESPACED_RESPONSE,
            "Has String field NAMESPACED_RESPONSE with value of \"X-JAVAX-PORTLET-NAMESPACED-RESPONSE\"");
      tcd.put(V2RESPONSETESTS_MIMERESPONSE_APIRENDER_FIELDMARKUP_HEAD_ELEMENT,
            "Has String field MARKUP_HEAD_ELEMENT with value of \"javax.portlet.markup.head.element\"");
      tcd.put(V2RESPONSETESTS_MIMERESPONSE_APIRENDER_GETCONTENTTYPE1,
            "Method getContentType(): Returns a String containing the MIME type that can be used with the response");
      tcd.put(V2RESPONSETESTS_MIMERESPONSE_APIRENDER_GETCONTENTTYPE2,
            "Method getContentType(): Returns null if no content type is set");
      tcd.put(V2RESPONSETESTS_MIMERESPONSE_APIRENDER_SETCONTENTTYPE1,
            "Method setContentType(String): Sets the MIME type for the response");
      tcd.put(V2RESPONSETESTS_MIMERESPONSE_APIRENDER_SETCONTENTTYPE4,
            "Method setContentType(String): Throws IllegalArgumentException if the specified MIME type is invalid");
      tcd.put(V2RESPONSETESTS_MIMERESPONSE_APIRENDER_GETCHARACTERENCODING,
            "Method getCharacterEncoding(): Returns a String containing the name of the charset used for the response body");
      tcd.put(V2RESPONSETESTS_MIMERESPONSE_APIRENDER_GETWRITER1, "Method getWriter(): Returns a PrintWriter object");
      tcd.put(V2RESPONSETESTS_MIMERESPONSE_APIRENDER_GETWRITER2,
            "Method getWriter(): Throws IllegalStateException if called after the getPortletOutputStream method has been called");
      tcd.put(V2RESPONSETESTS_MIMERESPONSE_APIRENDER_GETLOCALE,
            "Method getLocale(): Returns an java.util.Locale representing the locale assigned to the response");
      tcd.put(V2RESPONSETESTS_MIMERESPONSE_APIRENDER_SETBUFFERSIZE1,
            "Method setBufferSize(int): Sets the preferred buffer size for the response body");
      tcd.put(V2RESPONSETESTS_MIMERESPONSE_APIRENDER_SETBUFFERSIZE2,
            "Method setBufferSize(int): Throws IllegalStateException if called after content has been written");
      tcd.put(V2RESPONSETESTS_MIMERESPONSE_APIRENDER_GETBUFFERSIZE1,
            "Method getBufferSize(): Returns an int designating the actual buffer size used for the response");
      tcd.put(V2RESPONSETESTS_MIMERESPONSE_APIRENDER_GETBUFFERSIZE2,
            "Method getBufferSize(): Returns null if buffering is not used");
      tcd.put(V2RESPONSETESTS_MIMERESPONSE_APIRENDER_FLUSHBUFFER1,
            "Method flushBuffer(): Returns void and flushes buffer to OutputStream");
      tcd.put(V2RESPONSETESTS_MIMERESPONSE_APIRENDER_RESETBUFFER1,
            "Method resetBuffer(): Returns void and clears and data and properties from the buffer");
      tcd.put(V2RESPONSETESTS_MIMERESPONSE_APIRENDER_RESETBUFFER2,
            "Method resetBuffer(): Throws IllegalStateException if called after the response has been committed");
      tcd.put(V2RESPONSETESTS_MIMERESPONSE_APIRENDER_ISCOMMITTED1,
            "Method isCommitted(): Returns true if the response has been committed");
      tcd.put(V2RESPONSETESTS_MIMERESPONSE_APIRENDER_ISCOMMITTED2,
            "Method isCommitted(): Returns false if the response has not been committed");
      tcd.put(V2RESPONSETESTS_MIMERESPONSE_APIRENDER_RESET1,
            "Method reset(): Returns void and clears and data and properties from the buffer");
      tcd.put(V2RESPONSETESTS_MIMERESPONSE_APIRENDER_RESET2,
            "Method reset(): Throws IllegalStateException if called after the response has been committed");
      tcd.put(V2RESPONSETESTS_MIMERESPONSE_APIRENDER_GETPORTLETOUTPUTSTREAM1,
            "Method getPortletOutputStream(): Returns a PortletOutputStream object");
      tcd.put(V2RESPONSETESTS_MIMERESPONSE_APIRENDER_GETPORTLETOUTPUTSTREAM2,
            "Method getPortletOutputStream(): Throws IllegalStateException if called after the getWriter method has been called");
      tcd.put(V2RESPONSETESTS_MIMERESPONSE_APIRENDER_CREATERENDERURL,
            "Method createRenderURL(): Returns a PortletURL object representing a render URL targeting the portlet");
      tcd.put(V2RESPONSETESTS_MIMERESPONSE_APIRENDER_CREATEACTIONURL,
            "Method createActionURL(): Returns a PortletURL object representing an action URL targeting the portlet");
      tcd.put(V2RESPONSETESTS_MIMERESPONSE_APIRENDER_CREATERESOURCEURL,
            "Method createResourceURL(): Returns a ResourceURL object targeting the portlet");
      tcd.put(V2RESPONSETESTS_MIMERESPONSE_APIRENDER_GETCACHECONTROL,
            "Method getCacheControl(): Returns a CacheControl object");
      tcd.put(V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_FIELDEXPIRATION_CACHE,
            "Has String field EXPIRATION_CACHE with value of \"portlet.expiration-cache\"");
      tcd.put(V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_FIELDCACHE_SCOPE,
            "Has String field CACHE_SCOPE with value of \"portlet.cache-scope\"");
      tcd.put(V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_FIELDPUBLIC_SCOPE,
            "Has String field PUBLIC_SCOPE with value of \"portlet.public-scope\"");
      tcd.put(V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_FIELDPRIVATE_SCOPE,
            "Has String field PRIVATE_SCOPE with value of \"portlet.private-scope\"");
      tcd.put(V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_FIELDETAG,
            "Has String field ETAG with value of \"portlet.ETag\"");
      tcd.put(V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_FIELDUSE_CACHED_CONTENT,
            "Has String field USE_CACHED_CONTENT with value of \"portlet.use-cached-content\"");
      tcd.put(V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_FIELDNAMESPACED_RESPONSE,
            "Has String field NAMESPACED_RESPONSE with value of \"X-JAVAX-PORTLET-NAMESPACED-RESPONSE\"");
      tcd.put(V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_FIELDMARKUP_HEAD_ELEMENT,
            "Has String field MARKUP_HEAD_ELEMENT with value of \"javax.portlet.markup.head.element\"");
      tcd.put(V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_GETCONTENTTYPE1,
            "Method getContentType(): Returns a String containing the MIME type that can be used with the response");
      tcd.put(V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_GETCONTENTTYPE2,
            "Method getContentType(): Returns null if no content type is set");
      tcd.put(V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_SETCONTENTTYPE1,
            "Method setContentType(String): Sets the MIME type for the response");
      tcd.put(V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_SETCONTENTTYPE4,
            "Method setContentType(String): Throws IllegalArgumentException if the specified MIME type is invalid");
      tcd.put(V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_GETCHARACTERENCODING,
            "Method getCharacterEncoding(): Returns a String containing the name of the charset used for the response body");
      tcd.put(V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_GETWRITER1, "Method getWriter(): Returns a PrintWriter object");
      tcd.put(V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_GETWRITER2,
            "Method getWriter(): Throws IllegalStateException if called after the getPortletOutputStream method has been called");
      tcd.put(V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_GETLOCALE,
            "Method getLocale(): Returns an java.util.Locale representing the locale assigned to the response");
      tcd.put(V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_SETBUFFERSIZE1,
            "Method setBufferSize(int): Sets the preferred buffer size for the response body");
      tcd.put(V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_SETBUFFERSIZE2,
            "Method setBufferSize(int): Throws IllegalStateException if called after content has been written");
      tcd.put(V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_GETBUFFERSIZE1,
            "Method getBufferSize(): Returns an int designating the actual buffer size used for the response");
      tcd.put(V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_GETBUFFERSIZE2,
            "Method getBufferSize(): Returns null if buffering is not used");
      tcd.put(V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_FLUSHBUFFER1,
            "Method flushBuffer(): Returns void and flushes buffer to OutputStream");
      tcd.put(V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_RESETBUFFER1,
            "Method resetBuffer(): Returns void and clears and data and properties from the buffer");
      tcd.put(V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_RESETBUFFER2,
            "Method resetBuffer(): Throws IllegalStateException if called after the response has been committed");
      tcd.put(V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_ISCOMMITTED1,
            "Method isCommitted(): Returns true if the response has been committed");
      tcd.put(V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_ISCOMMITTED2,
            "Method isCommitted(): Returns false if the response has not been committed");
      tcd.put(V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_RESET1,
            "Method reset(): Returns void and clears and data and properties from the buffer");
      tcd.put(V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_RESET2,
            "Method reset(): Throws IllegalStateException if called after the response has been committed");
      tcd.put(V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_GETPORTLETOUTPUTSTREAM1,
            "Method getPortletOutputStream(): Returns a PortletOutputStream object");
      tcd.put(V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_GETPORTLETOUTPUTSTREAM2,
            "Method getPortletOutputStream(): Throws IllegalStateException if called after the getWriter method has been called");
      tcd.put(V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_CREATERENDERURL,
            "Method createRenderURL(): Returns a PortletURL object representing a render URL targeting the portlet");
      tcd.put(V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_CREATEACTIONURL,
            "Method createActionURL(): Returns a PortletURL object representing an action URL targeting the portlet");
      tcd.put(V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_CREATERESOURCEURL,
            "Method createResourceURL(): Returns a ResourceURL object targeting the portlet");
      tcd.put(V2RESPONSETESTS_MIMERESPONSE_APIRESOURCE_GETCACHECONTROL,
            "Method getCacheControl(): Returns a CacheControl object");
      tcd.put(V2RESPONSETESTS_RENDERRESPONSE_APIRENDER_SETTITLE2,
            "Method setTitle(String): Sets the portlet title to the specified value");
      tcd.put(V2RESPONSETESTS_RENDERRESPONSE_APIRENDER_SETNEXTPOSSIBLEPORTLETMODES2,
            "Method setNextPossiblePortletModes(java.util.Collection): Sets the next possible portlet modes to the specified value");
      tcd.put(
            V2RESPONSETESTS_RENDERRESPONSE_APIRENDER_SETCONTENTTYPE1,
            "Method setContentType(String): The portlet container will ignore any character encoding specified as part of the content type for render calls");
      tcd.put(V2RESPONSETESTS_RENDERRESPONSE_APIRENDER_SETCONTENTTYPE2,
            "Method setContentType(String): Throws IllegalArgumentException if the content type is not valid");
      tcd.put(V2RESPONSETESTS_RESOURCERESPONSE_APIRESOURCE_FIELDHTTP_STATUS_CODE,
            "Has String field HTTP_STATUS_CODE with value of \"portlet.http-status-code\"");
      tcd.put(V2RESPONSETESTS_RESOURCERESPONSE_APIRESOURCE_SETLOCALE1,
            "Method setLocale(Locale): Sets the locale of the response");
      tcd.put(V2RESPONSETESTS_RESOURCERESPONSE_APIRESOURCE_SETLOCALE4,
            "Method setLocale(Locale): Throws IllegalArgumentException if the Locale parameter is null");
      tcd.put(V2RESPONSETESTS_RESOURCERESPONSE_APIRESOURCE_SETCHARACTERENCODING1,
            "Method setCharacterEncoding(String): Sets the character encoding of the response");
      tcd.put(V2RESPONSETESTS_RESOURCERESPONSE_APIRESOURCE_SETCHARACTERENCODING4,
            "Method setCharacterEncoding(String): Throws IllegalArgumentException if the Locale parameter is null");
      tcd.put(V2RESPONSETESTS_RESOURCERESPONSE_APIRESOURCE_SETCONTENTLENGTH1,
            "Method setContentLength(int): Sets the length of the content body");
      tcd.put(
            V2RESPONSETESTS_RESOURCERESPONSE_APIRESOURCE_CREATERENDERURL2,
            "Method createRenderURL(): Throws IllegalStateException if the cacheability level for the resource URL triggering the serveResource call is not PAGE");
      tcd.put(
            V2RESPONSETESTS_RESOURCERESPONSE_APIRESOURCE_CREATEACTIONURL2,
            "Method createActionURL(): Throws IllegalStateException if the cacheability level for the resource URL triggering the serveResource call is not PAGE");
      tcd.put(
            V2RESPONSETESTS_RESOURCERESPONSE_APIRESOURCE_CREATERESOURCEURL2,
            "Method createResourceURL(): Throws IllegalStateException if the cacheability level for the resource URL triggering the serveResource call is not PAGE");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERRENURL_SETPARAMETERA1,
            "Method setParameter(String, String): Sets the parameter value for the specified name");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERRENURL_SETPARAMETERA2,
            "Method setParameter(String, String): A private parameter can be set");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERRENURL_SETPARAMETERA3,
            "Method setParameter(String, String): A public parameter can be set");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERRENURL_SETPARAMETERA6,
            "Method setParameter(String, String): All previously existing values for the specified key are removed");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERRENURL_SETPARAMETERA7,
            "Method setParameter(String, String): If the value is null, all values for the specified key are removed");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERRENURL_SETPARAMETERA8,
            "Method setParameter(String, String): Throws IllegalArgumentException if the name is null");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERRENURL_SETPARAMETERB1,
            "Method setParameter(String, String[]): Sets the parameter value array for the specified name");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERRENURL_SETPARAMETERB2,
            "Method setParameter(String, String[]): A private parameter can be set");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERRENURL_SETPARAMETERB3,
            "Method setParameter(String, String[]): A public parameter can be set");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERRENURL_SETPARAMETERB6,
            "Method setParameter(String, String[]): All previously existing values for the specified key are removed");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERRENURL_SETPARAMETERB7,
            "Method setParameter(String, String[]): Throws IllegalArgumentException if the value is null");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERRENURL_SETPARAMETERB8,
            "Method setParameter(String, String[]): Throws IllegalArgumentException if the name is null");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERRENURL_SETPARAMETERS1,
            "Method setParameters(java.util.Map): Sets the parameter map to the specified value");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERRENURL_SETPARAMETERS2,
            "Method setParameters(java.util.Map): Public parameters can be set through the map");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERRENURL_SETPARAMETERS3,
            "Method setParameters(java.util.Map): Private parameters can be set through the map");
      tcd.put(
            V2URLTESTS_BASEURL_APIRENDERRENURL_SETPARAMETERS6,
            "Method setParameters(java.util.Map): Previously existing private parameters not contained in the specified input map are removed");
      tcd.put(
            V2URLTESTS_BASEURL_APIRENDERRENURL_SETPARAMETERS7,
            "Method setParameters(java.util.Map): Previously existing public parameters not contained in the specified input map remain unchanged");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERRENURL_SETPARAMETERS8,
            "Method setParameters(java.util.Map): Parameters that are set are available in requests initiated through the URL");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERRENURL_SETPARAMETERS9,
            "Method setParameters(java.util.Map): Throws IllegalArgumentException if the input map is null");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERRENURL_SETPARAMETERS10,
            "Method setParameters(java.util.Map): Throws IllegalArgumentException if any key in the map is null");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERRENURL_SETPARAMETERS12,
            "Method setParameters(java.util.Map): Throws IllegalArgumentException if the values array for any key is null");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERRENURL_SETSECURE2,
            "Method setSecure(boolean): If the input parameter is true, the resulting URL uses a secure connection (HTTPS)");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERRENURL_TOSTRING,
            "Method toString(): Returns a String containing the portlet URL representation to be included in the markup");
      tcd.put(
            V2URLTESTS_BASEURL_APIRENDERRENURL_GETPARAMETERMAP1,
            "Method getParameterMap(): Returns an java.util.Map&lt;java.lang.String,java.lang.String[]&gt; object for the parameter names and values if parameters are available");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERRENURL_GETPARAMETERMAP2,
            "Method getParameterMap(): The returned map contains all public and private parameters for the request");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERRENURL_GETPARAMETERMAP6,
            "Method getParameterMap(): Returns an empty map if no parameters exist");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERRENURL_WRITEA1,
            "Method write(Writer out): Writes the URL to the output stream through the provided Writer");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERRENURL_WRITEB1,
            "Method write(Writer out, boolean escapeXML): Writes the URL to the output stream through the provided Writer");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERRENURL_ADDPROPERTY1,
            "Method addProperty(String, String): A property can be added");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERRENURL_ADDPROPERTY3,
            "Method addProperty(String, String): Throws IllegalArgumentException if the specified key is null");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERRENURL_SETPROPERTY1,
            "Method setProperty(String, String): Sets a property value for the specified key");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERRENURL_SETPROPERTY3,
            "Method setProperty(String, String): Throws IllegalArgumentException if the specified key is null");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERA1,
            "Method setParameter(String, String): Sets the parameter value for the specified name");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERA4,
            "Method setParameter(String, String): An action parameter can be set");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERA6,
            "Method setParameter(String, String): All previously existing values for the specified key are removed");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERA7,
            "Method setParameter(String, String): If the value is null, all values for the specified key are removed");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERA8,
            "Method setParameter(String, String): Throws IllegalArgumentException if the name is null");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERB1,
            "Method setParameter(String, String[]): Sets the parameter value array for the specified name");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERB4,
            "Method setParameter(String, String[]): An action parameter can be set");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERB6,
            "Method setParameter(String, String[]): All previously existing values for the specified key are removed");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERB7,
            "Method setParameter(String, String[]): Throws IllegalArgumentException if the value is null");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERB8,
            "Method setParameter(String, String[]): Throws IllegalArgumentException if the name is null");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERS1,
            "Method setParameters(java.util.Map): Sets the parameter map to the specified value");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERS4,
            "Method setParameters(java.util.Map): Action parameters can be set through the map");
      tcd.put(
            V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERS6,
            "Method setParameters(java.util.Map): Previously existing private parameters not contained in the specified input map are removed");
      tcd.put(
            V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERS7,
            "Method setParameters(java.util.Map): Previously existing public parameters not contained in the specified input map remain unchanged");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERS8,
            "Method setParameters(java.util.Map): Parameters that are set are available in requests initiated through the URL");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERS9,
            "Method setParameters(java.util.Map): Throws IllegalArgumentException if the input map is null");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERS10,
            "Method setParameters(java.util.Map): Throws IllegalArgumentException if any key in the map is null");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERACTURL_SETPARAMETERS12,
            "Method setParameters(java.util.Map): Throws IllegalArgumentException if the values array for any key is null");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERACTURL_SETSECURE2,
            "Method setSecure(boolean): If the input parameter is true, the resulting URL uses a secure connection (HTTPS)");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERACTURL_TOSTRING,
            "Method toString(): Returns a String containing the portlet URL representation to be included in the markup");
      tcd.put(
            V2URLTESTS_BASEURL_APIRENDERACTURL_GETPARAMETERMAP1,
            "Method getParameterMap(): Returns an java.util.Map&lt;java.lang.String,java.lang.String[]&gt; object for the parameter names and values if parameters are available");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERACTURL_GETPARAMETERMAP3,
            "Method getParameterMap(): For an action URL, the returned map contains all action parameters for the request");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERACTURL_GETPARAMETERMAP6,
            "Method getParameterMap(): Returns an empty map if no parameters exist");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERACTURL_WRITEA1,
            "Method write(Writer out): Writes the URL to the output stream through the provided Writer");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERACTURL_WRITEB1,
            "Method write(Writer out, boolean escapeXML): Writes the URL to the output stream through the provided Writer");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERACTURL_ADDPROPERTY1,
            "Method addProperty(String, String): A property can be added");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERACTURL_ADDPROPERTY3,
            "Method addProperty(String, String): Throws IllegalArgumentException if the specified key is null");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERACTURL_SETPROPERTY1,
            "Method setProperty(String, String): Sets a property value for the specified key");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERACTURL_SETPROPERTY3,
            "Method setProperty(String, String): Throws IllegalArgumentException if the specified key is null");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERA1,
            "Method setParameter(String, String): Sets the parameter value for the specified name");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERA5,
            "Method setParameter(String, String): A resource parameter can be set");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERA6,
            "Method setParameter(String, String): All previously existing values for the specified key are removed");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERA7,
            "String): If the value is null, all values for the specified key are removed");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERA8,
            "Method setParameter(String, String): Throws IllegalArgumentException if the name is null");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERB1,
            "Method setParameter(String, String[]): Sets the parameter value array for the specified name");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERB5,
            "Method setParameter(String, String[]): A resource parameter can be set");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERB6,
            "Method setParameter(String, String[]): All previously existing values for the specified key are removed");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERB7,
            "Method setParameter(String, String[]): Throws IllegalArgumentException if the value is null");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERB8,
            "Method setParameter(String, String[]): Throws IllegalArgumentException if the name is null");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERS1,
            "Method setParameters(java.util.Map): Sets the parameter map to the specified value");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERS5,
            "Method setParameters(java.util.Map): Resource parameters can be set through the map");
      tcd.put(
            V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERS6,
            "Method setParameters(java.util.Map): Previously existing private parameters not contained in the specified input map are removed");
      tcd.put(
            V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERS7,
            "Method setParameters(java.util.Map): Previously existing public parameters not contained in the specified input map remain unchanged");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERS8,
            "Method setParameters(java.util.Map): Parameters that are set are available in requests initiated through the URL");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERS9,
            "Method setParameters(java.util.Map): Throws IllegalArgumentException if the input map is null");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERS10,
            "Method setParameters(java.util.Map): Throws IllegalArgumentException if any key in the map is null");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERS12,
            "Method setParameters(java.util.Map): Throws IllegalArgumentException if the values array for any key is null");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERRESURL_SETSECURE2,
            "Method setSecure(boolean): If the input parameter is true, the resulting URL uses a secure connection (HTTPS)");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERRESURL_TOSTRING,
            "Method toString(): Returns a String containing the portlet URL representation to be included in the markup");
      tcd.put(
            V2URLTESTS_BASEURL_APIRENDERRESURL_GETPARAMETERMAP1,
            "Method getParameterMap(): Returns an java.util.Map&lt;java.lang.String,java.lang.String[]&gt; object for the parameter names and values if parameters are available");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERRESURL_GETPARAMETERMAP4,
            "Method getParameterMap(): The returned map contains all resource parameters for the request");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERRESURL_GETPARAMETERMAP5,
            "Method getParameterMap(): The returned map does not contain any render parameters for the request");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERRESURL_GETPARAMETERMAP6,
            "Method getParameterMap(): Returns an empty map if no parameters exist");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERRESURL_WRITEA1,
            "Method write(Writer out): Writes the URL to the output stream through the provided Writer");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERRESURL_WRITEB1,
            "Method write(Writer out, boolean escapeXML): Writes the URL to the output stream through the provided Writer");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERRESURL_ADDPROPERTY1,
            "Method addProperty(String, String): A property can be added");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERRESURL_ADDPROPERTY3,
            "Method addProperty(String, String): Throws IllegalArgumentException if the specified key is null");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERRESURL_SETPROPERTY1,
            "Method setProperty(String, String): Sets a property value for the specified key");
      tcd.put(V2URLTESTS_BASEURL_APIRENDERRESURL_SETPROPERTY3,
            "Method setProperty(String, String): Throws IllegalArgumentException if the specified key is null");
      tcd.put(V2URLTESTS_PORTLETURL_APIRENDERRENURL_SETWINDOWSTATE1,
            "Method setWindowState(WindowState): Sets the WindowState to be used when the URL is activated");
      tcd.put(
            V2URLTESTS_PORTLETURL_APIRENDERRENURL_SETWINDOWSTATE2,
            "Method setWindowState(WindowState): Throws WindowStateException if the portal does not support the specified Window State");
      tcd.put(V2URLTESTS_PORTLETURL_APIRENDERRENURL_SETPORTLETMODE1,
            "Method setPortletMode(PortletMode): Sets the PortletMode to be used when the URL is activated");
      tcd.put(
            V2URLTESTS_PORTLETURL_APIRENDERRENURL_SETPORTLETMODE2,
            "Method setPortletMode(PortletMode): Throws PortletModeException if the portal does not support the specified PortletMode");
      tcd.put(
            V2URLTESTS_PORTLETURL_APIRENDERRENURL_SETPORTLETMODE3,
            "Method setPortletMode(PortletMode): Throws PortletModeException if the specified PortletMode is not declared in the deployment descriptor");
      tcd.put(V2URLTESTS_PORTLETURL_APIRENDERRENURL_GETPORTLETMODE1,
            "Method getPortletMode(): Returns the PortletMode object set on the URL");
      tcd.put(V2URLTESTS_PORTLETURL_APIRENDERRENURL_GETPORTLETMODE2,
            "Method getPortletMode(): Returns null if the PortletMode has not been set");
      tcd.put(V2URLTESTS_PORTLETURL_APIRENDERRENURL_GETWINDOWSTATE1,
            "Method getWindowState(): Returns the WindowState object set on the URL");
      tcd.put(V2URLTESTS_PORTLETURL_APIRENDERRENURL_GETWINDOWSTATE2,
            "Method getWindowState(): Returns null if the Window State has not been set");
      tcd.put(V2URLTESTS_PORTLETURL_APIRENDERRENURL_REMOVEPUBLICRENDERPARAMETER1,
            "Method removePublicRenderParameter(String): Removes the specified public render parameter");
      tcd.put(V2URLTESTS_PORTLETURL_APIRENDERRENURL_REMOVEPUBLICRENDERPARAMETER2,
            "Method removePublicRenderParameter(String): Throws IllegalArgumentException if the name is null");
      tcd.put(V2URLTESTS_PORTLETURL_APIRENDERACTURL_SETWINDOWSTATE1,
            "Method setWindowState(WindowState): Sets the WindowState to be used when the URL is activated");
      tcd.put(
            V2URLTESTS_PORTLETURL_APIRENDERACTURL_SETWINDOWSTATE2,
            "Method setWindowState(WindowState): Throws WindowStateException if the portal does not support the specified Window State");
      tcd.put(V2URLTESTS_PORTLETURL_APIRENDERACTURL_SETPORTLETMODE1,
            "Method setPortletMode(PortletMode): Sets the PortletMode to be used when the URL is activated");
      tcd.put(
            V2URLTESTS_PORTLETURL_APIRENDERACTURL_SETPORTLETMODE2,
            "Method setPortletMode(PortletMode): Throws PortletModeException if the portal does not support the specified PortletMode");
      tcd.put(
            V2URLTESTS_PORTLETURL_APIRENDERACTURL_SETPORTLETMODE3,
            "Method setPortletMode(PortletMode): Throws PortletModeException if the specified PortletMode is not declared in the deployment descriptor");
      tcd.put(V2URLTESTS_PORTLETURL_APIRENDERACTURL_GETPORTLETMODE1,
            "Method getPortletMode(): Returns the PortletMode object set on the URL");
      tcd.put(V2URLTESTS_PORTLETURL_APIRENDERACTURL_GETPORTLETMODE2,
            "Method getPortletMode(): Returns null if the PortletMode has not been set");
      tcd.put(V2URLTESTS_PORTLETURL_APIRENDERACTURL_GETWINDOWSTATE1,
            "Method getWindowState(): Returns the WindowState object set on the URL");
      tcd.put(V2URLTESTS_PORTLETURL_APIRENDERACTURL_GETWINDOWSTATE2,
            "Method getWindowState(): Returns null if the Window State has not been set");
      tcd.put(V2URLTESTS_PORTLETURL_APIRENDERACTURL_REMOVEPUBLICRENDERPARAMETER1,
            "Method removePublicRenderParameter(String): Removes the specified public render parameter");
      tcd.put(V2URLTESTS_PORTLETURL_APIRENDERACTURL_REMOVEPUBLICRENDERPARAMETER2,
            "Method removePublicRenderParameter(String): Throws IllegalArgumentException if the name is null");
      tcd.put(V2URLTESTS_RESOURCEURL_APIRENDERRESURL_FIELDFULL,
            "Has String field FULL with value of \"cacheLevelFull\" ");
      tcd.put(V2URLTESTS_RESOURCEURL_APIRENDERRESURL_FIELDPAGE,
            "Has String field PAGE with value of \"cacheLevelPage\" ");
      tcd.put(V2URLTESTS_RESOURCEURL_APIRENDERRESURL_FIELDPORTLET,
            "Has String field PORTLET with value of \"cacheLevelPortlet\" ");
      tcd.put(V2URLTESTS_RESOURCEURL_APIRENDERRESURL_FIELDSHARED,
            "Has String field SHARED with value of \"javax.portlet.shared\" ");
      tcd.put(
            V2URLTESTS_RESOURCEURL_APIRENDERRESURL_RESOURCEURL4,
            "A resource parameter with the same name as a public render parameter appears before the public render parameter in the values array");
      tcd.put(
            V2URLTESTS_RESOURCEURL_APIRENDERRESURL_RESOURCEURL5,
            "A resource parameter with the same name as a private render parameter appears before the private render parameter in the values array");
      tcd.put(
            V2URLTESTS_RESOURCEURL_APIRENDERRESURL_RESOURCEURL6,
            "When a resource URL is created, public render parameters from the current request are automatically copied to the new resource URL");
      tcd.put(
            V2URLTESTS_RESOURCEURL_APIRENDERRESURL_RESOURCEURL7,
            "When a resource URL is created, the automatically copied public render parameters are hidden to the ResourceURL getParameter method");
      tcd.put(
            V2URLTESTS_RESOURCEURL_APIRENDERRESURL_RESOURCEURL8,
            "When a resource URL is created, private render parameters from the current request are automatically copied to the new resource URL");
      tcd.put(
            V2URLTESTS_RESOURCEURL_APIRENDERRESURL_RESOURCEURL9,
            "When a resource URL is created, the automatically copied private render parameters are hidden to the ResourceURL getParameter method");
      tcd.put(V2URLTESTS_RESOURCEURL_APIRENDERRESURL_SETRESOURCEID,
            "Method setResourceID(String): Sets the specified String as the portlet resource ID");
      tcd.put(V2URLTESTS_RESOURCEURL_APIRENDERRESURL_GETCACHEABILITY,
            "Method getCacheability(): Returns a String containing the cacheability level set on the resource URL");
      tcd.put(V2URLTESTS_RESOURCEURL_APIRENDERRESURL_SETCACHEABILITY1,
            "Method setCacheability(String): Sets the cacheability level for the resource URL");
      tcd.put(
            V2URLTESTS_RESOURCEURL_APIRENDERRESURL_SETCACHEABILITY2,
            "Method setCacheability(String): Throws IllegalArgumentException if the input parameter does not have a value of \"FULL\", \"PAGE\", or \"PORTLET\"");
      tcd.put(
            V2URLTESTS_RESOURCEURL_APIRENDERRESURL_SETCACHEABILITY3,
            "Method setCacheability(String): Throws IllegalStateException if the specified cacheability level is weaker than the cacheability level for the parent resource URL");
      tcd.put(V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERACTURL_CONFIGURATION,
            "A PortletURLGenerationListener can be configured in the portlet deployment descriptor");
      tcd.put(
            V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERACTURL_PORTLETURLGENERATIONLISTENER6,
            "If more than one listener is registered the portlet container must chain the listeners in the order of how they appear in the deployment descriptor");
      tcd.put(
            V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERACTURL_FILTERACTIONURL1,
            "Method filterActionURL(PortletURL): The filterActionURL(PortletURL): method is called before the toString() method is executed");
      tcd.put(
            V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERACTURL_FILTERACTIONURL2,
            "Method filterActionURL(PortletURL): The filterActionURL(PortletURL): method is called before the write(Writer out) method is executed");
      tcd.put(
            V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERACTURL_FILTERACTIONURL3,
            "Method filterActionURL(PortletURL): The filterActionURL(PortletURL): method is called before the write(Writer out, boolean escapeXML) method is executed");
      tcd.put(
            V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERACTURL_FILTERACTIONURL4,
            "Method filterActionURL(PortletURL): The filterActionURL method is passed the PortletURL object representing the action URL");
      tcd.put(
            V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERACTURL_FILTERACTIONURL5,
            "Method filterActionURL(PortletURL): The input URL object can be modified by setting a parameter and the modified URL object is processed by the PortletURL toString or write method");
      tcd.put(
            V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERRENURL_FILTERRENDERURL1,
            "Method filterRenderURL(PortletURL): The filterRenderURL(PortletURL): method is called before the toString() method is executed");
      tcd.put(
            V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERRENURL_FILTERRENDERURL2,
            "Method filterRenderURL(PortletURL): The filterRenderURL(PortletURL): method is called before the write(Writer out) method is executed");
      tcd.put(
            V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERRENURL_FILTERRENDERURL3,
            "Method filterRenderURL(PortletURL): The filterRenderURL(PortletURL): method is called before the write(Writer out, boolean escapeXML) method is executed");
      tcd.put(
            V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERRENURL_FILTERRENDERURL4,
            "Method filterRenderURL(PortletURL): The filterRenderURL method is passed the PortletURL object representing the render URL");
      tcd.put(
            V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERRENURL_FILTERRENDERURL5,
            "Method filterRenderURL(PortletURL): The input URL object can be modified by setting a parameter and the modified URL object is processed by the PortletURL toString or write method");
      tcd.put(
            V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERRESURL_FILTERRESOURCEURL1,
            "Method filterResourceURL(ResourceURL): The filterResourceURL(ResourceURL): method is called before the toString() method is executed");
      tcd.put(
            V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERRESURL_FILTERRESOURCEURL2,
            "Method filterResourceURL(ResourceURL): The filterResourceURL(ResourceURL): method is called before the write(Writer out) method is executed");
      tcd.put(
            V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERRESURL_FILTERRESOURCEURL3,
            "Method filterResourceURL(ResourceURL): The filterResourceURL(ResourceURL): method is called before the write(Writer out, boolean escapeXML) method is executed");
      tcd.put(
            V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERRESURL_FILTERRESOURCEURL4,
            "Method filterResourceURL(ResourceURL): The filterResourceURL method is passed the ResourceURL object representing the resource URL");
      tcd.put(
            V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERRESURL_FILTERRESOURCEURL5,
            "Method filterResourceURL(ResourceURL): The input URL object can be modified by setting a parameter and the modified URL object is processed by the ResourceURL toString or write method");
      tcd.put(
            V2URLTESTS_PORTLETURLGENERATIONLISTENER_APIRENDERRESURL_FILTERRESOURCEURL7,
            "Method filterResourceURL(ResourceURL): The input URL object can be modified by setting the resource ID and the modified URL object is processed by the ResourceURL toString or write method");
      tcd.put(V2EXCEPTIONTESTS_PORTLETMODEEXCEPTION_APIRENDER_HASGETMODE2,
            "Returns the PortletMode object causing this exception");
      tcd.put(V2EXCEPTIONTESTS_UNAVAILABLEEXCEPTION_APIRENDER_ISPERMANENT1, "Method isPermanent(): Returns a boolean");
      tcd.put(V2EXCEPTIONTESTS_UNAVAILABLEEXCEPTION_APIRENDER_ISPERMANENT2,
            "Method isPermanent(): Returns true if the portlet is permanently unavailable");
      tcd.put(V2EXCEPTIONTESTS_UNAVAILABLEEXCEPTION_APIRENDER_ISPERMANENT3,
            "Method isPermanent(): Returns false if the portlet is temporarily unavailable");
      tcd.put(V2EXCEPTIONTESTS_UNAVAILABLEEXCEPTION_APIRENDER_GETUNAVAILABLESECONDS1,
            "Method getUnavailableSeconds(): Returns an integer");
      tcd.put(V2EXCEPTIONTESTS_UNAVAILABLEEXCEPTION_APIRENDER_GETUNAVAILABLESECONDS2,
            "Method getUnavailableSeconds(): Returns a number &lt;= 0 if the portlet is permanently unavailable");
      tcd.put(
            V2EXCEPTIONTESTS_VALIDATOREXCEPTION_APIRENDER_CONSTRUCTOR2,
            "For ValidatorException(java.lang.String, java.util.Collection&lt;java.lang.String&gt;), the failedKeys parameter may be null");
      tcd.put(
            V2EXCEPTIONTESTS_VALIDATOREXCEPTION_APIRENDER_CONSTRUCTOR4,
            "For ValidatorException(java.lang.String, java.lang.Throwable, java.util.Collection&lt;java.lang.String&gt;), the failedKeys parameter may be null");
      tcd.put(
            V2EXCEPTIONTESTS_VALIDATOREXCEPTION_APIRENDER_CONSTRUCTOR6,
            "For ValidatorException(java.lang.Throwable, java.util.Collection&lt;java.lang.String&gt;), the failedKeys parameter may be null");
      tcd.put(
            V2EXCEPTIONTESTS_VALIDATOREXCEPTION_APIRENDER_GETFAILEDKEYS1,
            "Method getFailedKeys(): Returns a java.util.Enumeration&lt;java.lang.String&gt; object containing the preference keys that failed validation");
      tcd.put(V2EXCEPTIONTESTS_VALIDATOREXCEPTION_APIRENDER_GETFAILEDKEYS2,
            "Method getFailedKeys(): Returns an empty enmueration if no failed keys are available");
      tcd.put(V2EXCEPTIONTESTS_WINDOWSTATEEXCEPTION_APIRENDER_GETSTATE,
            "Method getState(): Returns the WindowState object causing this exception");
      tcd.put(
            V2ANNOTATIONTESTS_PROCESSACTION_APIACTION_NAME,
            "Method name(): On an action request, the method is executed if the parameter \"javax.portlet.action\" matches the name field");
      tcd.put(V2ANNOTATIONTESTS_PROCESSEVENT_APIEVENT_QNAME,
            "Method qname(): On an event request, the method is executed if the Event qname matches the qname field");
      tcd.put(V2ANNOTATIONTESTS_PROCESSEVENT_APIEVENT_NAME,
            "Method name(): On an event request, the method is executed if the Event name matches the name field");
      tcd.put(V2ANNOTATIONTESTS_RENDERMODE_APIRENDER_NAME,
            "Method name(): On a render request, the method is executed if the portlet mode matches the name field");
      tcd.put(V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETPORTLETNAME,
            "Method getPortletName(): Returns a String containing the portlet name");
      tcd.put(V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETPORTLETCONTEXT,
            "Method getPortletContext(): Returns the PortletContext object associated with the portlet");
      tcd.put(V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETRESOURCEBUNDLE,
            "Method getResourceBundle(Locale): Returns the ResourceBundle for the specified locale");
      tcd.put(V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETINITPARAMETER1,
            "Method getInitParameter(String): Returns a String containing the initialization parameter value for the given name");
      tcd.put(V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETINITPARAMETER3,
            "Method getInitParameter(String): Throws IllegalArgumentException if the name parameter is null");
      tcd.put(
            V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETINITPARAMETERNAMES1,
            "Method getInitParameterNames(): Returns an java.util.Enumeration&lt;java.lang.String&gt; containing the names of the initialization parameters");
      tcd.put(
            V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETPUBLICRENDERPARAMETERNAMES1,
            "Method getPublicRenderParameterNames(): Returns an java.util.Enumeration&lt;java.lang.String&gt; containing the names of the public render parameters");
      tcd.put(
            V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETDEFAULTNAMESPACE1,
            "Method getDefaultNamespace(): Returns a String containing the default namespace for events and public render parameters as defined in the deployment descriptor");
      tcd.put(
            V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETPUBLISHINGEVENTQNAMES1,
            "Method getPublishingEventQNames(): Returns an java.util.Enumeration&lt;java.lang.String&gt; containing the publishing event qnames as defined in the deployment descriptor");
      tcd.put(
            V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETPROCESSINGEVENTQNAMES1,
            "Method getProcessingEventQNames(): Returns an java.util.Enumeration&lt;java.lang.String&gt; containing the processing event qnames as defined in the deployment descriptor");
      tcd.put(
            V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETSUPPORTEDLOCALES1,
            "Method getSupportedLocales(): Returns an java.util.Enumeration&lt;java.lang.String&gt; containing the names of the supported locales as defined in the deployment descriptor");
      tcd.put(
            V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETCONTAINERRUNTIMEOPTIONS1,
            "Method getContainerRuntimeOptions(): Returns an java.util.Map&lt;java.lang.String,java.lang.String[]&gt; object containing the container runtime options as defined in the deployment descriptor");
      tcd.put(
            V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETCONTAINERRUNTIMEOPTIONS2,
            "Method getContainerRuntimeOptions(): If the same option is defined at the portlet application and at the portlet level, the definition at the portlet level takes precedence");
      tcd.put(
            V2PORTLETTESTS_PORTLETCONFIG_APIRENDER_GETCONTAINERRUNTIMEOPTIONS3,
            "Method getContainerRuntimeOptions(): If the portlet container does not support a runtime option defined in the portlet descriptor, that option will not be returned in this map");
      tcd.put(V2PORTLETTESTS_PORTLETCONFIG_APIRENDER2_GETINITPARAMETER2,
            "Method getInitParameter(String): Returns null if the specified initialization parameter does not exist");
      tcd.put(V2PORTLETTESTS_PORTLETCONFIG_APIRENDER2_GETINITPARAMETERNAMES2,
            "Method getInitParameterNames(): Returns an empty Enumeration if there are no initialization parameters available");
      tcd.put(
            V2PORTLETTESTS_PORTLETCONFIG_APIRENDER2_GETPUBLICRENDERPARAMETERNAMES2,
            "Method getPublicRenderParameterNames(): Returns an empty Enumeration if there are no public render parameters are defined");
      tcd.put(V2PORTLETTESTS_PORTLETCONFIG_APIRENDER2_GETPUBLISHINGEVENTQNAMES2,
            "Method getPublishingEventQNames(): Returns an empty Enumeration if there are no processing events are defined");
      tcd.put(V2PORTLETTESTS_PORTLETCONFIG_APIRENDER2_GETPROCESSINGEVENTQNAMES2,
            "Method getProcessingEventQNames(): Returns an empty Enumeration if there are no processing events are defined");
      tcd.put(V2PORTLETTESTS_PORTLETCONFIG_APIRENDER2_GETSUPPORTEDLOCALES2,
            "Method getSupportedLocales(): Returns an empty Enumeration if there are no supported locales are defined");
      tcd.put(V2PORTLETTESTS_PORTLETMODE_APIRENDER_CONSTRUCTOR1,
            "The constructor PortletMode(java.lang.String): allows a PortletMode object of the specified name to be constructed");
      tcd.put(V2PORTLETTESTS_PORTLETMODE_APIRENDER_CONSTRUCTOR2,
            "The constructor PortletMode(java.lang.String): converts any upper case letters in the name parameter to lower case");
      tcd.put(V2PORTLETTESTS_PORTLETMODE_APIRENDER_FIELDEDIT,
            "Has PortletMode field EDIT with value of PortletMode.EDIT");
      tcd.put(V2PORTLETTESTS_PORTLETMODE_APIRENDER_FIELDHELP,
            "Has PortletMode field HELP with value of PortletMode.HELP");
      tcd.put(V2PORTLETTESTS_PORTLETMODE_APIRENDER_FIELDVIEW,
            "Has PortletMode field VIEW with value of PortletMode.VIEW");
      tcd.put(V2PORTLETTESTS_PORTLETMODE_APIRENDER_TOSTRING,
            "Method toString(): Returns a String representation of the portlet mode");
      tcd.put(V2PORTLETTESTS_PORTLETMODE_APIRENDER_HASHCODE,
            "Method hashCode(): Returns an int containing the has code for the portlet mode");
      tcd.put(V2PORTLETTESTS_PORTLETMODE_APIRENDER_EQUALS,
            "Method equals(): Returns true if the PortletMode equals the specified PortletMode");
      tcd.put(V2PORTLETTESTS_WINDOWSTATE_APIRENDER_CONSTRUCTOR1,
            "The constructor WindowState(java.lang.String): allows a WindowState object of the specified name to be constructed");
      tcd.put(V2PORTLETTESTS_WINDOWSTATE_APIRENDER_CONSTRUCTOR2,
            "The constructor WindowState(java.lang.String): converts any upper case letters in the name parameter to lower case");
      tcd.put(V2PORTLETTESTS_WINDOWSTATE_APIRENDER_FIELDMAXIMIZED,
            "Has WindowState field MAXIMIZED with value of WindowState.MAXIMIZED");
      tcd.put(V2PORTLETTESTS_WINDOWSTATE_APIRENDER_FIELDMINIMIZED,
            "Has WindowState field MINIMIZED with value of WindowState.MINIMIZED");
      tcd.put(V2PORTLETTESTS_WINDOWSTATE_APIRENDER_FIELDNORMAL,
            "Has WindowState field NORMAL with value of WindowState.NORMAL");
      tcd.put(V2PORTLETTESTS_WINDOWSTATE_APIRENDER_TOSTRING,
            "Method toString(): Returns a String representation of the portlet mode");
      tcd.put(V2PORTLETTESTS_WINDOWSTATE_APIRENDER_HASHCODE,
            "Method hashCode(): Returns an int containing the has code for the portlet mode");
      tcd.put(V2PORTLETTESTS_WINDOWSTATE_APIRENDER_EQUALS,
            "Method equals(): Returns true if the WindowState equals the specified WindowState");
      tcd.put(V2PORTLETTESTS_PORTLET_APIRENDER_INIT1,
            "Method init(PortletConfig): is called for the portlet defined in the deployment descriptor");
      tcd.put(V2PORTLETTESTS_PORTLET_APIRENDER_RENDER1,
            "Method render(RenderRequest, RenderResponse): is called when the portlet is to be rendered");
      tcd.put(V2PORTLETTESTS_PORTLET_APIRENDER_RENDER2,
            "Method render(RenderRequest, RenderResponse): is called when a Render URL for the portlet is triggered");
      tcd.put(V2PORTLETTESTS_PORTLET_APIACTION_PROCESSACTION,
            "Method processAction(ActionRequest, ActionResponse): is called when an action URL for the portlet is triggered");
      tcd.put(V2PORTLETTESTS_EVENT_APIEVENT_GETQNAME1,
            "Method getQName(): Returns the javax.xml.namespace.QName object for the Event");
      tcd.put(V2PORTLETTESTS_EVENT_APIEVENT_GETQNAME2, "Method getQName(): Returned value may not be null");
      tcd.put(V2PORTLETTESTS_EVENT_APIEVENT_GETNAME1,
            "Method getName(): Returns a String containing the event local name");
      tcd.put(V2PORTLETTESTS_EVENT_APIEVENT_GETNAME2, "Method getName(): Returned value may not be null");
      tcd.put(V2PORTLETTESTS_EVENT_APIEVENT_GETVALUE1,
            "Method getValue(String, String): Returns a java.io.Serializable object representing the event payload");
      tcd.put(V2PORTLETTESTS_EVENT_APIEVENT_GETVALUE2,
            "Method getValue(String, String): Returned value is null if the event has no payload");
      tcd.put(V2PORTLETTESTS_EVENTPORTLET_APIEVENT_PROCESSEVENT,
            "Method processEvent(EventRequest, EventResponse): is called when an event is targeted to the portlet");
      tcd.put(V2PORTLETTESTS_RESOURCESERVINGPORTLET_APIRESOURCE_SERVERESOURCE,
            "Method serveResource(ResourceRequest, ResourceResponse): is called to allow the portlet to generate resource content");
      tcd.put(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_INITA, "Method init(): Called when the portlet is initialized");
      tcd.put(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_INITB,
            "Method init(PortletConfig): Called when the portlet is initialized");
      tcd.put(
            V2PORTLETTESTS_GENERICPORTLET_APIRENDER_PROCESSACTION2,
            "Method processAction(ActionRequest, ActionResponse): Dispatches to @ProcessAction annotated method matching the ActionRequest.ACTION_NAME parameter");
      tcd.put(
            V2PORTLETTESTS_GENERICPORTLET_APIRENDER_PROCESSACTION3,
            "Method processAction(ActionRequest, ActionResponse): Throws PortletException if no matching @ProcessAction annotated method found");
      tcd.put(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_GETTITLE1,
            "Method getTitle(): If overridden, the String returned by this method is used as the portlet title");
      tcd.put(
            V2PORTLETTESTS_GENERICPORTLET_APIRENDER_GETTITLE2,
            "Method getTitle(): Returns a String containing the title from the portlet resource bundle under the key \"javax.portlet.title\"");
      tcd.put(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_DODISPATCH1,
            "Method doDispatch(RenderRequest, RenderResponse): If overridden, is called when markup is to be generated");
      tcd.put(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_DOVIEW1,
            "Method doView(RenderRequest, RenderResponse): If overridden, is called when a render request in view mode occurs");
      tcd.put(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_GETPORTLETCONFIG,
            "Method getPortletConfig(): Returns the PortletConfig object for the portlet");
      tcd.put(V2PORTLETTESTS_GENERICPORTLET_APIRENDER_GETNEXTPOSSIBLEPORTLETMODES1,
            "Method getNextPossiblePortletModes(): Is called during generic portlet render request processing");
      tcd.put(V2ENVIRONMENTTESTS_CACHECONTROL_APIRENDER_GETEXPIRATIONTIME1,
            "Method getExpirationTime(): Returns the expiration time set through setExpirationTime");
      tcd.put(
            V2ENVIRONMENTTESTS_CACHECONTROL_APIRENDER_GETEXPIRATIONTIME2,
            "Method getExpirationTime(): Returns the default expiration time from the deployment descriptor if the expiration time has not been set");
      tcd.put(
            V2ENVIRONMENTTESTS_CACHECONTROL_APIRENDER_GETEXPIRATIONTIME3,
            "Method getExpirationTime(): Returns 0 if the expiration time has not been set and no default is set in the deployment descriptor");
      tcd.put(V2ENVIRONMENTTESTS_CACHECONTROL_APIRENDER_SETEXPIRATIONTIME1,
            "Method setExpirationTime(int): Sets the expiration time for the current response to the specified value");
      tcd.put(V2ENVIRONMENTTESTS_CACHECONTROL_APIRENDER_SETEXPIRATIONTIME2,
            "Method setExpirationTime(int): If the expiration value is set to 0, caching is disabled");
      tcd.put(V2ENVIRONMENTTESTS_CACHECONTROL_APIRENDER_SETEXPIRATIONTIME3,
            "Method setExpirationTime(int): If the expiration value is set to -1, the cache does not expire");
      tcd.put(V2ENVIRONMENTTESTS_CACHECONTROL_APIRENDER_ISPUBLICSCOPE1,
            "Method isPublicScope(): Returns true if the caching scope has been set to public through the setPublicScope method");
      tcd.put(
            V2ENVIRONMENTTESTS_CACHECONTROL_APIRENDER_ISPUBLICSCOPE2,
            "Method isPublicScope(): Returns true if the caching scope default has not been set with the setPublicScope method, but has been set to public in the deployment descriptor");
      tcd.put(
            V2ENVIRONMENTTESTS_CACHECONTROL_APIRENDER_ISPUBLICSCOPE3,
            "Method isPublicScope(): Returns false if the caching scope has not been set with the setPublicScope method, but has been set to private through the setPublicScope method");
      tcd.put(
            V2ENVIRONMENTTESTS_CACHECONTROL_APIRENDER_ISPUBLICSCOPE5,
            "Method isPublicScope(): Returns false if the caching scope has not been set with the setPublicScope method and has not been set in the deployment descriptor");
      tcd.put(V2ENVIRONMENTTESTS_CACHECONTROL_APIRENDER_SETPUBLICSCOPE1,
            "Method setPublicScope(boolean): If the input parameter is true, the cache scope is set to public");
      tcd.put(V2ENVIRONMENTTESTS_CACHECONTROL_APIRENDER_SETPUBLICSCOPE2,
            "Method setPublicScope(boolean): If the input parameter is false, the cache scope is set to non-public");
      tcd.put(V2ENVIRONMENTTESTS_CACHECONTROL_APIRENDER_GETETAG1,
            "Method getETag(): Returns a String containing the ETag for the current response");
      tcd.put(V2ENVIRONMENTTESTS_CACHECONTROL_APIRENDER_GETETAG2,
            "Method getETag(): Returns null if no ETag is set on the response");
      tcd.put(V2ENVIRONMENTTESTS_CACHECONTROL_APIRENDER_SETETAG1,
            "Method setETag(String): Sets an ETag for the current response");
      tcd.put(V2ENVIRONMENTTESTS_CACHECONTROL_APIRENDER_SETETAG2,
            "Method setETag(String): A previously-set ETag is overwritten");
      tcd.put(V2ENVIRONMENTTESTS_CACHECONTROL_APIRENDER_SETETAG3,
            "Method setETag(String): Removes the ETag if the input parameter is null");
      tcd.put(
            V2ENVIRONMENTTESTS_CACHECONTROL_APIRENDER_USECACHEDCONTENT1,
            "Method useCachedContent(): Returns true if cached content has been set to valid through the setUseCachedContent method");
      tcd.put(
            V2ENVIRONMENTTESTS_CACHECONTROL_APIRENDER_USECACHEDCONTENT2,
            "Method useCachedContent(): Returns false if cached content has been set to invalid through the setUseCachedContent method");
      tcd.put(V2ENVIRONMENTTESTS_CACHECONTROL_APIRENDER_USECACHEDCONTENT3,
            "Method useCachedContent(): Returns false if the use cached content indcator has not been set");
      tcd.put(V2ENVIRONMENTTESTS_CACHECONTROL_APIRENDER_SETUSECACHEDCONTENT1,
            "Method setUseCachedContent(boolean): If set to true, the cached content is valid");
      tcd.put(V2ENVIRONMENTTESTS_CACHECONTROL_APIRENDER_SETUSECACHEDCONTENT2,
            "Method setUseCachedContent(boolean): If set to false, the cached content is invalid");
      tcd.put(V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_GETEXPIRATIONTIME1,
            "Method getExpirationTime(): Returns the expiration time set through setExpirationTime");
      tcd.put(
            V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_GETEXPIRATIONTIME2,
            "Method getExpirationTime(): Returns the default expiration time from the deployment descriptor if the expiration time has not been set");
      tcd.put(
            V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_GETEXPIRATIONTIME3,
            "Method getExpirationTime(): Returns 0 if the expiration time has not been set and no default is set in the deployment descriptor");
      tcd.put(V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_SETEXPIRATIONTIME1,
            "Method setExpirationTime(int): Sets the expiration time for the current response to the specified value");
      tcd.put(V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_SETEXPIRATIONTIME2,
            "Method setExpirationTime(int): If the expiration value is set to 0, caching is disabled");
      tcd.put(V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_SETEXPIRATIONTIME3,
            "Method setExpirationTime(int): If the expiration value is set to -1, the cache does not expire");
      tcd.put(V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_ISPUBLICSCOPE1,
            "Method isPublicScope(): Returns true if the caching scope has been set to public through the setPublicScope method");
      tcd.put(
            V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_ISPUBLICSCOPE2,
            "Method isPublicScope(): Returns true if the caching scope default has not been set with the setPublicScope method, but has been set to public in the deployment descriptor");
      tcd.put(
            V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_ISPUBLICSCOPE3,
            "Method isPublicScope(): Returns false if the caching scope has not been set with the setPublicScope method, but has been set to private through the setPublicScope method");
      tcd.put(
            V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_ISPUBLICSCOPE5,
            "Method isPublicScope(): Returns false if the caching scope has not been set with the setPublicScope method and has not been set in the deployment descriptor");
      tcd.put(V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_SETPUBLICSCOPE1,
            "Method setPublicScope(boolean): If the input parameter is true, the cache scope is set to public");
      tcd.put(V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_SETPUBLICSCOPE2,
            "Method setPublicScope(boolean): If the input parameter is false, the cache scope is set to non-public");
      tcd.put(V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_GETETAG1,
            "Method getETag(): Returns a String containing the ETag for the current response");
      tcd.put(V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_GETETAG2,
            "Method getETag(): Returns null if no ETag is set on the response");
      tcd.put(V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_SETETAG1,
            "Method setETag(String): Sets an ETag for the current response");
      tcd.put(V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_SETETAG2,
            "Method setETag(String): A previously-set ETag is overwritten");
      tcd.put(V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_SETETAG3,
            "Method setETag(String): Removes the ETag if the input parameter is null");
      tcd.put(
            V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_USECACHEDCONTENT1,
            "Method useCachedContent(): Returns true if cached content has been set to valid through the setUseCachedContent method");
      tcd.put(
            V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_USECACHEDCONTENT2,
            "Method useCachedContent(): Returns false if cached content has been set to invalid through the setUseCachedContent method");
      tcd.put(V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_USECACHEDCONTENT3,
            "Method useCachedContent(): Returns false if the use cached content indcator has not been set");
      tcd.put(V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_SETUSECACHEDCONTENT1,
            "Method setUseCachedContent(boolean): If set to true, the cached content is valid");
      tcd.put(V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_SETUSECACHEDCONTENT2,
            "Method setUseCachedContent(boolean): If set to false, the cached content is invalid");
      tcd.put(V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_FIELDMARKUP_HEAD_ELEMENT_SUPPORT,
            "Has String field MARKUP_HEAD_ELEMENT_SUPPORT with value of \"javax.portlet.markup.head.element.support\" ");
      tcd.put(V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETPROPERTY1,
            "Method getProperty(String): Returns a String containing the value for the specified property");
      tcd.put(V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETPROPERTY2,
            "Method getProperty(String): Returns null if there is no property defined for the specified name");
      tcd.put(V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETPROPERTY3,
            "Method getProperty(String): Throws IllegalArgumentException if the specified name is null");
      tcd.put(
            V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETPROPERTYNAMES1,
            "Method getPropertyNames(): Returns an java.util.Enumeration&lt;java.lang.String&gt; containing all portal property names");
      tcd.put(V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETPROPERTYNAMES2,
            "Method getPropertyNames(): Returns an empty Enumeration if there are no portal property names defined");
      tcd.put(
            V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETSUPPORTEDPORTLETMODES1,
            "Method getSupportedPortletModes(): Returns an java.util.Enumeration&lt;PortletMode&gt; containing all supported portlet modes");
      tcd.put(V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETSUPPORTEDPORTLETMODES2,
            "Method getSupportedPortletModes(): The Enumeration returned must contain the view mode");
      tcd.put(V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETSUPPORTEDPORTLETMODES3,
            "Method getSupportedPortletModes(): The Enumeration returned must contain the edit mode");
      tcd.put(V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETSUPPORTEDPORTLETMODES4,
            "Method getSupportedPortletModes(): The Enumeration returned must contain the help mode");
      tcd.put(
            V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETSUPPORTEDWINDOWSTATES1,
            "Method getSupportedWindowStates(): Returns an java.util.Enumeration&lt;WindowState&gt; containing all supported window states");
      tcd.put(V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETSUPPORTEDWINDOWSTATES2,
            "Method getSupportedWindowStates(): The Enumeration returned must contain the maximized state");
      tcd.put(V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETSUPPORTEDWINDOWSTATES3,
            "Method getSupportedWindowStates(): The Enumeration returned must contain the minimized state");
      tcd.put(V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETSUPPORTEDWINDOWSTATES4,
            "Method getSupportedWindowStates(): The Enumeration returned must contain the normal state");
      tcd.put(V2ENVIRONMENTTESTS_PORTALCONTEXT_APIRENDER_GETPORTALINFO1,
            "Method getPortalInfo(): Returns a String containing the server name and version in the form name/version");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETSERVERINFO1,
            "Method getServerInfo(): Returns a String containing the server name and version in the form name/version");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETREQUESTDISPATCHER1,
            "Method getRequestDispatcher(String): Returns a PortletRequestDispatcher for the specified path");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETREQUESTDISPATCHER2,
            "Method getRequestDispatcher(String): Returns null if the specified path does not begin with \"/\"");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETREQUESTDISPATCHER3,
            "Method getRequestDispatcher(String): Returns null if any other error occurs");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETNAMEDDISPATCHER1,
            "Method getNamedDispatcher(String): Returns a PortletRequestDispatcher for the specified servlet name");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETNAMEDDISPATCHER2,
            "Method getNamedDispatcher(String): Returns null if an error occurs");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETRESOURCEASSTREAM1,
            "Method getResourceAsStream(String): Returns a java.io.InputStream for the resource at the specified path");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETRESOURCEASSTREAM2,
            "Method getResourceAsStream(String): Protected resources can be accessed by prefixing the path with \"/WEB-INF/\"");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETRESOURCEASSTREAM3,
            "Method getResourceAsStream(String): Returns null if no resource exists at the specified path");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETMAJORVERSION,
            "Method getMajorVersion(): Returns the major version of the portlet API supported by the container");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETMINORVERSION,
            "Method getMinorVersion(): Returns the minor version of the portlet API supported by the container");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETMIMETYPE1,
            "Method getMimeType(String): Returns a String containing the MIME type of the specified file name");
      tcd.put(
            V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETMIMETYPE2,
            "Method getMimeType(String): Returns \"text/html\" for an HTML file with the approriate &lt;mime-mapping&gt; element in web.xml");
      tcd.put(
            V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETMIMETYPE3,
            "Method getMimeType(String): Returns \"image/gif\" for an image file with the approriate &lt;mime-mapping&gt; element in web.xml");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETMIMETYPE4,
            "Method getMimeType(String): Returns null if the MIME type cannot be determined");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETMIMETYPE5,
            "Method getMimeType(String): Returns null if the file does not exist");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETREALPATH1,
            "Method getRealPath(String): Returns a String containing the OS-specific real path for the given virtual path");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETREALPATH2,
            "Method getRealPath(String): Returns null if the file does not exist");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETREALPATH3,
            "Method getRealPath(String): Returns null if the transformation cannot be performed");
      tcd.put(
            V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETRESOURCEPATHS1,
            "Method getResourcePaths(String): Returns a java.util.Set&lt;java.lang.String&gt; containing all the paths to resources within the web application longest sub-path of which matches the supplied path argument  ");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETRESOURCEPATHS2,
            "Method getResourcePaths(String): A path indicating a file does not end with a slash (/)");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETRESOURCEPATHS3,
            "Method getResourcePaths(String): A path indicating a subdirectory ends with a slash (/)");
      tcd.put(
            V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETRESOURCEPATHS4,
            "Method getResourcePaths(String): Returns null if there are no resources in the web application of which the path begins with the supplied path");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETRESOURCE1,
            "Method getResource(String): Returns a java.net.URL object that maps to the specified path");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETRESOURCE2,
            "Method getResource(String): Returns null if no resource is mapped to the path");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETRESOURCE3,
            "Method getResource(String): Throws java.net.MalformedURLException if the path does not begin with a slash (/)");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETRESOURCE4,
            "Method getResource(String): Throws java.net.MalformedURLException if the path is malformed");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETATTRIBUTE1,
            "Method getAttribute(String): Returns a java.lang.Object attribute value for the specified name");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETATTRIBUTE2,
            "Method getAttribute(String): Returns null if there is no attribute value for the specified name");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETATTRIBUTE3,
            "Method getAttribute(String): Throws IllegalArgumentException if the name is null");
      tcd.put(
            V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETATTRIBUTENAMES1,
            "Method getAttributeNames(): Returns an java.util.Enumeration&lt;java.lang.String&gt; containing the attribute names in the PortletContext");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETATTRIBUTENAMES2,
            "Method getAttributeNames(): Returns an empty Enumeration if no attributes are available");
      tcd.put(
            V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETINITPARAMETER1,
            "Method getInitParameter(String): Returns a java.lang.String PortletContext initialization parameter value for the specified name");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETINITPARAMETER2,
            "Method getInitParameter(String): Returns null if there is no inittialization parameter for the specified name");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETINITPARAMETER3,
            "Method getInitParameter(String): Throws IllegalArgumentException if the name is null");
      tcd.put(
            V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETINITPARAMETERNAMES1,
            "Method getInitParameterNames(): Returns an java.util.Enumeration&lt;java.lang.String&gt; containing the InitParameter names in the PortletContext");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETINITPARAMETERNAMES2,
            "Method getInitParameterNames(): Returns an empty Enumeration if no InitParameters are available");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_LOGA,
            "Method log(String): Writes specified message to a portlet log file");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_LOGB,
            "Method log(String, Throwable): Writes specified message and stack trace to a portlet log file");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_REMOVEATTRIBUTE1,
            "Method removeAttribute(String): Removes the attribute with the specified nale");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_REMOVEATTRIBUTE2,
            "Method removeAttribute(String): Throws IllegalArgumentException if the name is null");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_SETATTRIBUTE1,
            "Method setAttribute(String, Object): Sets an attribute for the specified name in the portlet context");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_SETATTRIBUTE2,
            "Method setAttribute(String, Object): Any existing attribute for the specified name is removed");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_SETATTRIBUTE3,
            "Method setAttribute(String, Object): If the specified name is null, the attribute is removed");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_SETATTRIBUTE4,
            "Method setAttribute(String, Object): Throws IllegalArgumentException if the name is null");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETPORTLETCONTEXTNAME1,
            "Method getPortletContextName(): Returns the portlet application name");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETPORTLETCONTEXTNAME2,
            "Method getPortletContextName(): The name is as specified in web.xml the &lt;display-name&gt; element");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETPORTLETCONTEXTNAME3,
            "Method getPortletContextName(): Returns null if no web.xml &lt;display-name&gt; element is defined");
      tcd.put(
            V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETCONTAINERRUNTIMEOPTIONS1,
            "Method getContainerRuntimeOptions(): Returns an java.util.Enumeration&lt;java.lang.String&gt; containing the available runtime option names");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETCONTAINERRUNTIMEOPTIONS2,
            "Method getContainerRuntimeOptions(): Returns an empty Enumeration if no runtime options are available");
      tcd.put(
            V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_ISREADONLY1,
            "Method isReadOnly(String): Returns true if the preference specified by the key is defined to be read-only in the deployment descriptor");
      tcd.put(
            V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_ISREADONLY2,
            "Method isReadOnly(String): Returns false if the preference specified by the key is not defined to be read-only in the deployment descriptor");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_ISREADONLY3,
            "Method isReadOnly(String): Returns false if the preference specified by the key is undefined");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_ISREADONLY4,
            "Method isReadOnly(String): Throws IllegalArgumentException if the key is null");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_GETVALUE1,
            "Method getValue(String, String): Returns the first String value for the specified key");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_GETVALUE2,
            "Method getValue(String, String): Returns the specified default value if there is no value for the specified key");
      tcd.put(
            V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_GETVALUE3,
            "Method getValue(String, String): Returns the specified default value if the existing value for the specified key is null");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_GETVALUE4,
            "Method getValue(String, String): Throws IllegalArgumentException if the key is null");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_GETVALUES1,
            "Method getValues(String, String[]): Returns the values String[] for the specified key");
      tcd.put(
            V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_GETVALUES2,
            "Method getValues(String, String[]): Returns the specified default String[] if there is no Values for the specified key");
      tcd.put(
            V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_GETVALUES3,
            "Method getValues(String, String[]): Returns the specified default String[] if the existing String[] for the specified key is null");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_GETVALUES4,
            "Method getValues(String, String[]): Throws IllegalArgumentException if the key is null");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_SETVALUE4,
            "Method setValue(String, String): Throws ReadOnlyException if the preference cannot be modified for this request");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_GETNAMES1,
            "Method getNames(): Returns an java.util.Enumeration&lt;java.lang.String&gt; containing the available preference keys");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_GETNAMES2,
            "Method getNames(): Returns an empty Enumeration if no preference keys are available");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_GETMAP1,
            "Method getMap(): Returns an java.util.Map&lt;java.lang.String&gt; containing the available preferences");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_GETMAP2,
            "Method getMap(): Returns an empty Map if no preferences are available");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_RESET2,
            "Method reset(String): Throws ReadOnlyException if the preference cannot be modified for this request");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRENDER_STORE5,
            "Method store(): Throws IllegalStateException if store(): is called in the render method  ");
      tcd.put(
            V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_ISREADONLY1,
            "Method isReadOnly(String): Returns true if the preference specified by the key is defined to be read-only in the deployment descriptor");
      tcd.put(
            V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_ISREADONLY2,
            "Method isReadOnly(String): Returns false if the preference specified by the key is not defined to be read-only in the deployment descriptor");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_ISREADONLY3,
            "Method isReadOnly(String): Returns false if the preference specified by the key is undefined");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_ISREADONLY4,
            "Method isReadOnly(String): Throws IllegalArgumentException if the key is null");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_GETVALUE1,
            "Method getValue(String, String): Returns the first String value for the specified key");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_GETVALUE2,
            "Method getValue(String, String): Returns the specified default value if there is no value for the specified key");
      tcd.put(
            V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_GETVALUE3,
            "Method getValue(String, String): Returns the specified default value if the existing value for the specified key is null");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_GETVALUE4,
            "Method getValue(String, String): Throws IllegalArgumentException if the key is null");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_GETVALUES1,
            "Method getValues(String, String[]): Returns the values String[] for the specified key");
      tcd.put(
            V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_GETVALUES2,
            "Method getValues(String, String[]): Returns the specified default String[] if there is no Values for the specified key");
      tcd.put(
            V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_GETVALUES3,
            "Method getValues(String, String[]): Returns the specified default String[] if the existing String[] for the specified key is null");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_GETVALUES4,
            "Method getValues(String, String[]): Throws IllegalArgumentException if the key is null");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_SETVALUE1,
            "Method setValue(String, String): Sets the specified value for the specified key");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_SETVALUE2,
            "Method setValue(String, String): Any existing String or String[] value for the specified key is replaced");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_SETVALUE3,
            "Method setValue(String, String): The value may be set to null");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_SETVALUE4,
            "Method setValue(String, String): Throws ReadOnlyException if the preference cannot be modified for this request");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_SETVALUE5,
            "Method setValue(String, String): Throws IllegalArgumentException if the key is null");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_SETVALUES1,
            "Method setValues(String, String[]): Sets the specified value array for the specified key");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_SETVALUES2,
            "Method setValues(String, String[]): Any existing String or String[] Values for the specified key is replaced");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_SETVALUES3,
            "Method setValues(String, String[]): The value array may be set to null");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_SETVALUES4,
            "Method setValues(String, String[]): The value array may contain null members");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_SETVALUES5,
            "Method setValues(String, String[]): Throws ReadOnlyException if the preference cannot be modified for this request");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_SETVALUES6,
            "Method setValues(String, String[]): Throws IllegalArgumentException if the key is null");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_GETNAMES1,
            "Method getNames(): Returns an java.util.Enumeration&lt;java.lang.String&gt; containing the available preference keys");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_GETNAMES2,
            "Method getNames(): Returns an empty Enumeration if no preference keys are available");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_GETMAP1,
            "Method getMap(): Returns an java.util.Map&lt;java.lang.String&gt; containing the available preferences");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_GETMAP2,
            "Method getMap(): Returns an empty Map if no preferences are available");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_RESET1,
            "Method reset(String): Removes the value associated with the specified key");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_RESET2,
            "Method reset(String): Throws ReadOnlyException if the preference cannot be modified for this request");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_RESET3,
            "Method reset(String): Throws IllegalArgumentException if the key is null");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_STORE1,
            "Method store(): Commits changes made to the preferences to the persistent store");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_STORE2,
            "Method store(): If the store(): method is not called, changes made are discarded");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_STORE3,
            "Method store(): If a validator is defined, it is called before the actual store is performed");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_STORE4,
            "Method store(): If validation fails, the store is not performed");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_STORE5,
            "Method store(): Throws IllegalStateException if store(): is called in the render method  ");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIACTION_STORE6,
            "Method store(): Throws ValidatorException if the validation performed by the associated validator fails");
      tcd.put(V2ENVIRONMENTTESTS_PREFERENCESVALIDATOR_APIACTION_CANBECONFIGURED,
            "A PreferencesValidator can be configured in the deployment descriptor");
      tcd.put(
            V2ENVIRONMENTTESTS_PREFERENCESVALIDATOR_APIACTION_VALIDATE1,
            "Method validate(PortletPreferences): The validate(PortletPreferences): method is called when the preferences are stored");
      tcd.put(V2ENVIRONMENTTESTS_PREFERENCESVALIDATOR_APIACTION_VALIDATE2,
            "Method validate(PortletPreferences): If a ValidatorException is thrown, the preferences are not stored");
      tcd.put(
            V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_ISREADONLY1,
            "Method isReadOnly(String): Returns true if the preference specified by the key is defined to be read-only in the deployment descriptor");
      tcd.put(
            V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_ISREADONLY2,
            "Method isReadOnly(String): Returns false if the preference specified by the key is not defined to be read-only in the deployment descriptor");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_ISREADONLY3,
            "Method isReadOnly(String): Returns false if the preference specified by the key is undefined");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_ISREADONLY4,
            "Method isReadOnly(String): Throws IllegalArgumentException if the key is null");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_GETVALUE1,
            "Method getValue(String, String): Returns the first String value for the specified key");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_GETVALUE2,
            "Method getValue(String, String): Returns the specified default value if there is no value for the specified key");
      tcd.put(
            V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_GETVALUE3,
            "Method getValue(String, String): Returns the specified default value if the existing value for the specified key is null");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_GETVALUE4,
            "Method getValue(String, String): Throws IllegalArgumentException if the key is null");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_GETVALUES1,
            "Method getValues(String, String[]): Returns the values String[] for the specified key");
      tcd.put(
            V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_GETVALUES2,
            "Method getValues(String, String[]): Returns the specified default String[] if there is no Values for the specified key");
      tcd.put(
            V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_GETVALUES3,
            "Method getValues(String, String[]): Returns the specified default String[] if the existing String[] for the specified key is null");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_GETVALUES4,
            "Method getValues(String, String[]): Throws IllegalArgumentException if the key is null");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_SETVALUE1,
            "Method setValue(String, String): Sets the specified value for the specified key");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_SETVALUE2,
            "Method setValue(String, String): Any existing String or String[] value for the specified key is replaced");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_SETVALUE3,
            "Method setValue(String, String): The value may be set to null");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_SETVALUE4,
            "Method setValue(String, String): Throws ReadOnlyException if the preference cannot be modified for this request");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_SETVALUE5,
            "Method setValue(String, String): Throws IllegalArgumentException if the key is null");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_SETVALUES1,
            "Method setValues(String, String[]): Sets the specified value array for the specified key");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_SETVALUES2,
            "Method setValues(String, String[]): Any existing String or String[] Values for the specified key is replaced");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_SETVALUES3,
            "Method setValues(String, String[]): The value array may be set to null");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_SETVALUES4,
            "Method setValues(String, String[]): The value array may contain null members");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_SETVALUES5,
            "Method setValues(String, String[]): Throws ReadOnlyException if the preference cannot be modified for this request");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_SETVALUES6,
            "Method setValues(String, String[]): Throws IllegalArgumentException if the key is null");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_GETNAMES1,
            "Method getNames(): Returns an java.util.Enumeration&lt;java.lang.String&gt; containing the available preference keys");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_GETNAMES2,
            "Method getNames(): Returns an empty Enumeration if no preference keys are available");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_GETMAP1,
            "Method getMap(): Returns an java.util.Map&lt;java.lang.String&gt; containing the available preferences");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_GETMAP2,
            "Method getMap(): Returns an empty Map if no preferences are available");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_RESET1,
            "Method reset(String): Removes the value associated with the specified key");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_RESET2,
            "Method reset(String): Throws ReadOnlyException if the preference cannot be modified for this request");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_RESET3,
            "Method reset(String): Throws IllegalArgumentException if the key is null");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_STORE1,
            "Method store(): Commits changes made to the preferences to the persistent store");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_STORE2,
            "Method store(): If the store(): method is not called, changes made are discarded");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_STORE3,
            "Method store(): If a validator is defined, it is called before the actual store is performed");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_STORE4,
            "Method store(): If validation fails, the store is not performed");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_STORE5,
            "Method store(): Throws IllegalStateException if store(): is called in the render method  ");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_STORE6,
            "Method store(): Throws ValidatorException if the validation performed by the associated validator fails");
      tcd.put(V2ENVIRONMENTTESTS_PREFERENCESVALIDATOR_APIEVENT_CANBECONFIGURED,
            "A PreferencesValidator can be configured in the deployment descriptor");
      tcd.put(
            V2ENVIRONMENTTESTS_PREFERENCESVALIDATOR_APIEVENT_VALIDATE1,
            "Method validate(PortletPreferences): The validate(PortletPreferences): method is called when the preferences are stored");
      tcd.put(V2ENVIRONMENTTESTS_PREFERENCESVALIDATOR_APIEVENT_VALIDATE2,
            "Method validate(PortletPreferences): If a ValidatorException is thrown, the preferences are not stored");
      tcd.put(
            V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_ISREADONLY1,
            "Method isReadOnly(String): Returns true if the preference specified by the key is defined to be read-only in the deployment descriptor");
      tcd.put(
            V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_ISREADONLY2,
            "Method isReadOnly(String): Returns false if the preference specified by the key is not defined to be read-only in the deployment descriptor");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_ISREADONLY3,
            "Method isReadOnly(String): Returns false if the preference specified by the key is undefined");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_ISREADONLY4,
            "Method isReadOnly(String): Throws IllegalArgumentException if the key is null");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_GETVALUE1,
            "Method getValue(String, String): Returns the first String value for the specified key");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_GETVALUE2,
            "Method getValue(String, String): Returns the specified default value if there is no value for the specified key");
      tcd.put(
            V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_GETVALUE3,
            "Method getValue(String, String): Returns the specified default value if the existing value for the specified key is null");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_GETVALUE4,
            "Method getValue(String, String): Throws IllegalArgumentException if the key is null");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_GETVALUES1,
            "Method getValues(String, String[]): Returns the values String[] for the specified key");
      tcd.put(
            V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_GETVALUES2,
            "Method getValues(String, String[]): Returns the specified default String[] if there is no Values for the specified key");
      tcd.put(
            V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_GETVALUES3,
            "Method getValues(String, String[]): Returns the specified default String[] if the existing String[] for the specified key is null");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_GETVALUES4,
            "Method getValues(String, String[]): Throws IllegalArgumentException if the key is null");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_SETVALUE1,
            "Method setValue(String, String): Sets the specified value for the specified key");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_SETVALUE2,
            "Method setValue(String, String): Any existing String or String[] value for the specified key is replaced");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_SETVALUE3,
            "Method setValue(String, String): The value may be set to null");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_SETVALUE4,
            "Method setValue(String, String): Throws ReadOnlyException if the preference cannot be modified for this request");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_SETVALUE5,
            "Method setValue(String, String): Throws IllegalArgumentException if the key is null");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_SETVALUES1,
            "Method setValues(String, String[]): Sets the specified value array for the specified key");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_SETVALUES2,
            "Method setValues(String, String[]): Any existing String or String[] Values for the specified key is replaced");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_SETVALUES3,
            "Method setValues(String, String[]): The value array may be set to null");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_SETVALUES4,
            "Method setValues(String, String[]): The value array may contain null members");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_SETVALUES5,
            "Method setValues(String, String[]): Throws ReadOnlyException if the preference cannot be modified for this request");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_SETVALUES6,
            "Method setValues(String, String[]): Throws IllegalArgumentException if the key is null");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_GETNAMES1,
            "Method getNames(): Returns an java.util.Enumeration&lt;java.lang.String&gt; containing the available preference keys");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_GETNAMES2,
            "Method getNames(): Returns an empty Enumeration if no preference keys are available");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_GETMAP1,
            "Method getMap(): Returns an java.util.Map&lt;java.lang.String&gt; containing the available preferences");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_GETMAP2,
            "Method getMap(): Returns an empty Map if no preferences are available");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_RESET1,
            "Method reset(String): Removes the value associated with the specified key");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_RESET2,
            "Method reset(String): Throws ReadOnlyException if the preference cannot be modified for this request");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_RESET3,
            "Method reset(String): Throws IllegalArgumentException if the key is null");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_STORE1,
            "Method store(): Commits changes made to the preferences to the persistent store");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_STORE2,
            "Method store(): If the store(): method is not called, changes made are discarded");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_STORE3,
            "Method store(): If a validator is defined, it is called before the actual store is performed");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_STORE4,
            "Method store(): If validation fails, the store is not performed");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_STORE5,
            "Method store(): Throws IllegalStateException if store(): is called in the render method  ");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_STORE6,
            "Method store(): Throws ValidatorException if the validation performed by the associated validator fails");
      tcd.put(V2ENVIRONMENTTESTS_PREFERENCESVALIDATOR_APIRESOURCE_CANBECONFIGURED,
            "A PreferencesValidator can be configured in the deployment descriptor");
      tcd.put(
            V2ENVIRONMENTTESTS_PREFERENCESVALIDATOR_APIRESOURCE_VALIDATE1,
            "Method validate(PortletPreferences): The validate(PortletPreferences): method is called when the preferences are stored");
      tcd.put(V2ENVIRONMENTTESTS_PREFERENCESVALIDATOR_APIRESOURCE_VALIDATE2,
            "Method validate(PortletPreferences): If a ValidatorException is thrown, the preferences are not stored");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_INCLUDEA1,
            "Method include(PortletRequest, PortletResponse): Includes the content of a JSP page in the response");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_INCLUDEA2,
            "Method include(PortletRequest, PortletResponse): Includes the content of a HTML Page in the response");
      tcd.put(
            V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_INCLUDEA3,
            "Method include(PortletRequest, PortletResponse): The included servlet cannot change the status code. The attempt is ignored");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_INCLUDEA4,
            "Method include(PortletRequest, PortletResponse): The included servlet cannot set the headers. The attempt is ignored");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_INCLUDEB1,
            "Method include(RenderRequest, RenderResponse): Includes the content of a JSP page in the response");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_INCLUDEB2,
            "Method include(RenderRequest, RenderResponse): Includes the content of a HTML Page in the response");
      tcd.put(
            V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_INCLUDEB3,
            "Method include(RenderRequest, RenderResponse): The included servlet cannot change the status code. The attempt is ignored");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_INCLUDEB4,
            "Method include(RenderRequest, RenderResponse): The included servlet cannot set the headers. The attempt is ignored");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_FORWARD1,
            "Method forward(PortletRequest, PortletResponse): Can forward to a JSP page to create the response");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_FORWARD2,
            "Method forward(PortletRequest, PortletResponse): Can forward to a HTML Page to create the response");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_FORWARD3,
            "Method forward(PortletRequest, PortletResponse): Throws IllegalStateException if the response was already committed");
      tcd.put(
            V2ENVIRONMENTTESTS_PORTLETREQUESTDISPATCHER_APIRENDER_FORWARD4,
            "Method forward(PortletRequest, PortletResponse): Throws PortletException if the forwarded servlet throws any excpetion other than IOException or a runtime exception");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_FIELDAPPLICATION_SCOPE,
            "Has int field APPLICATION_SCOPE with value of 0x01");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_FIELDPORTLET_SCOPE,
            "Has int field PORTLET_SCOPE with value of 0x02");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTEA1,
            "Method getAttribute(String): Returns a java.lang.Object for the specified attribute name in the PORTLET_SCOPE");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTEA2,
            "Method getAttribute(String): Returns null if no attribute with the specified name exists in the PORTLET_SCOPE");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTEA3,
            "Method getAttribute(String): Throws IllegalArgumentException if the name is null");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTEA4,
            "Method getAttribute(String): Throws IllegalStateException if the method is called on an invalidated session");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTEB1,
            "Method getAttribute(String): Returns a java.lang.Object for the specified attribute name in the specified scope");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTEB2,
            "Method getAttribute(String): Returns null if no attribute with the specified name exists in the specified scope");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTEB3,
            "Method getAttribute(String): Throws IllegalArgumentException if the name is null");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTEB4,
            "Method getAttribute(String): Throws IllegalStateException if the method is called on an invalidated session");
      tcd.put(
            V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTENAMESA1,
            "Method getAttributeNames(): Returns a java.util.Enumeration&lt;java.lang.String&gt; of the available attribute names in the PORTLET_SCOPE");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTENAMESA2,
            "Method getAttributeNames(): Returns an empty Enumeration if there are no attributes available in the PORTLET_SCOPE");
      tcd.put(
            V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTENAMESB1,
            "Method getAttributeNames(int): Returns a java.util.Enumeration&lt;java.lang.String&gt; of the available attribute names in the specified scope");
      tcd.put(
            V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTENAMESB2,
            "Method getAttributeNames(int): Returns an empty Enumeration if there are no attributes available in the specified scope");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETCREATIONTIME1,
            "Method getCreationTime(): Returns a long containing the time the session was created in milliseconds since 1/1/1970  ");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETCREATIONTIME2,
            "Method getCreationTime(): Throws IllegalStateException if this method is called on an invalidated session");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETID,
            "Method getId(): Returns a String containing a unique identifier for the session");
      tcd.put(
            V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETLASTACCESSEDTIME,
            "Method getLastAccessedTime(): Returns a long containing the last time the session was accessed in milliseconds since 1/1/1970");
      tcd.put(
            V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETMAXINACTIVEINTERVAL,
            "Method getMaxInactiveInterval(): Returns the maximum time interval, in seconds, for which the portlet container keeps this session open between client accesses");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_INVALIDATE1,
            "Method invalidate(): Invalidates this session (all scopes): and unbinds any objects bound to it");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_INVALIDATE2,
            "Method invalidate(): The underlying HTTP session is also invalidated");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_ISNEW1,
            "Method isNew(): Returns true if the client has not yet joined the session");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_ISNEW2,
            "Method isNew(): Returns false if the client has joined the session");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_REMOVEATTRIBUTEA1,
            "Method removeAttribute(String): Removes the attribute specified by the name from the PORTLET_SCOPE");
      tcd.put(
            V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_REMOVEATTRIBUTEA2,
            "Method removeAttribute(String): If there is no attribute by the specified name in the the PORTLET_SCOPE, this method does nothing");
      tcd.put(
            V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_REMOVEATTRIBUTEA3,
            "Method removeAttribute(String): If an attribute was removed, the HttpSessionAttributeListener.attributeRemoved method is called on all HttpSessionAttributeListeners in the web application");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_REMOVEATTRIBUTEA4,
            "Method removeAttribute(String): Throws IllegalArgumentException if the name is null");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_REMOVEATTRIBUTEB1,
            "Method removeAttribute(String, int): Removes the attribute specified by the name from the specified scope");
      tcd.put(
            V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_REMOVEATTRIBUTEB2,
            "Method removeAttribute(String, int): If there is no attribute by the specified name in the specified scope, this method does nothing");
      tcd.put(
            V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_REMOVEATTRIBUTEB3,
            "Method removeAttribute(String, int): If an attribute was removed, the HttpSessionAttributeListener.attributeRemoved method is called on all HttpSessionAttributeListeners in the web application");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_REMOVEATTRIBUTEB4,
            "Method removeAttribute(String, int): Throws IllegalArgumentException if the name is null");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEA1,
            "Method setAttribute(String, Object): Stores an attribute object under the specified name in the PORTLET_SCOPE");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEA2,
            "Method setAttribute(String, Object): Replaces the attribute by the specified name if the attribute already exists");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEA3,
            "Method setAttribute(String, Object): Removes the attribute by the specified name if the object is null");
      tcd.put(
            V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEA4,
            "Method setAttribute(String, Object): If the attribute object implements HttpSessionBindingListener, its HttpSessionBindingListener.valueBound method is called");
      tcd.put(
            V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEA5,
            "Method setAttribute(String, Object): If an existing attribute object implements HttpSessionBindingListener and is replaced, its HttpSessionBindingListener.valueUnbound method is called");
      tcd.put(
            V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEA6,
            "Method setAttribute(String, Object): If an attribute was replaced, the HttpSessionAttributeListener.attributeReplaced method is called on all HttpSessionAttributeListeners in the web application");
      tcd.put(
            V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEA7,
            "Method setAttribute(String, Object): If a new attribute was added, the HttpSessionAttributeListener.attributeAdded method is called on all HttpSessionAttributeListeners in the web application");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEA8,
            "Method setAttribute(String, Object): Throws IllegalArgumentException if the name is null");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEB1,
            "Method setAttribute(String, Object, int): Stores an attribute object under the specified name in the specified scope");
      tcd.put(
            V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEB2,
            "Method setAttribute(String, Object, int): Replaces the attribute by the specified name if the attribute already exists");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEB3,
            "Method setAttribute(String, Object, int): Removes the attribute by the specified name if the object is null");
      tcd.put(
            V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEB4,
            "Method setAttribute(String, Object, int): If the attribute object implements HttpSessionBindingListener, its HttpSessionBindingListener.valueBound method is called");
      tcd.put(
            V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEB5,
            "Method setAttribute(String, Object, int): If an existing attribute object implements HttpSessionBindingListener and is replaced, its HttpSessionBindingListener.valueUnbound method is called");
      tcd.put(
            V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEB6,
            "Method setAttribute(String, Object, int): If an attribute was replaced, the HttpSessionAttributeListener.attributeReplaced method is called on all HttpSessionAttributeListeners in the web application");
      tcd.put(
            V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEB7,
            "Method setAttribute(String, Object, int): If a new attribute was added, the HttpSessionAttributeListener.attributeAdded method is called on all HttpSessionAttributeListeners in the web application");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETATTRIBUTEB8,
            "Method setAttribute(String, Object, int): Throws IllegalArgumentException if the name is null");
      tcd.put(
            V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETMAXINACTIVEINTERVAL1,
            "Method setMaxInactiveInterval(int): Specifies the time in seconds between client requests before the portlet contaner invalidates the session");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_SETMAXINACTIVEINTERVAL2,
            "Method setMaxInactiveInterval(int): If the specified time is negative, the session should never timeout");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETPORTLETCONTEXT,
            "Method getPortletContext(): Returns the PortletContext object for this session");
      tcd.put(
            V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTEMAPA1,
            "Method getAttributeMap(): Returns an java.util.Map&lt;java.lang.String,java.lang.Object&gt; object for the attributes available in the PORTLET_SCOPE");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTEMAPA2,
            "Method getAttributeMap(): Returns an empty map if no attributes exist in the PORTLET_SCOPE");
      tcd.put(
            V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTEMAPB1,
            "Method getAttributeMap(int): Returns an java.util.Map&lt;java.lang.String,java.lang.Object&gt; object for the attributes available in the PORTLET_SCOPE");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETSESSION_APIRENDER_GETATTRIBUTEMAPB2,
            "Method getAttributeMap(int): Returns an empty map if no attributes exist in the PORTLET_SCOPE");
      tcd.put(
            V2ENVIRONMENTTESTS_PORTLETSESSIONUTIL_APIRENDER_DECODEATTRIBUTENAME1,
            "Method decodeAttributeName(String): Returns a String containing the decoded name of the attribute if the input name is an encoded name in PORTLET_SCOPE");
      tcd.put(
            V2ENVIRONMENTTESTS_PORTLETSESSIONUTIL_APIRENDER_DECODEATTRIBUTENAME2,
            "Method decodeAttributeName(String): Returns a String containing the input name unchanged if the input name is in APPLICATION_SCOPE");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETSESSIONUTIL_APIRENDER_DECODESCOPE1,
            "Method decodeScope(String): Returns the decoded attribute scope for the input encoded attribute name");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETSESSIONUTIL_APIRENDER_DECODESCOPE2,
            "Method decodeScope(String): Returns PortletSession.APPLICATION_SCOPE if the attribute name is in APPLICATION_SCOPE");
      tcd.put(V2ENVIRONMENTTESTS_PORTLETSESSIONUTIL_APIRENDER_DECODESCOPE3,
            "Method decodeScope(String): Returns PortletSession.PORTLET_SCOPE if the attribute name is in PORTLET_SCOPE");

   }

   /**
    * Constructor.
    * 
    * Passes the static test case names - details map to the superclass
    * 
    * Note that the backing map is static and not threadsafe. Operations that change the map such as put, remove, etc.,
    * should not be used in portlets.
    */
   public JSR286ApiTestCaseDetails() {
      super(tcd);
   }

}
