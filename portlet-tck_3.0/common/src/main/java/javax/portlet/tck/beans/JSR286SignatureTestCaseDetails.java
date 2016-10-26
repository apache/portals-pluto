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
public class JSR286SignatureTestCaseDetails extends TestCaseDetails {

   public final static String               V2SIGTESTSACTION_ACTIONREQUEST_SIGACTION_FIELDACTION_NAME                                               = "V2SigTestsAction_ActionRequest_SIGAction_fieldACTION_NAME";
   public final static String               V2SIGTESTSACTION_ACTIONREQUEST_SIGACTION_IMPLEMENTSCLIENTDATAREQUEST                                    = "V2SigTestsAction_ActionRequest_SIGAction_implementsClientDataRequest";
   public final static String               V2SIGTESTSACTION_ACTIONRESPONSE_SIGACTION_HASSENDREDIRECT                                               = "V2SigTestsAction_ActionResponse_SIGAction_hasSendRedirect";
   public final static String               V2SIGTESTSACTION_ACTIONRESPONSE_SIGACTION_HASSENDREDIRECTA                                              = "V2SigTestsAction_ActionResponse_SIGAction_hasSendRedirectA";
   public final static String               V2SIGTESTSACTION_ACTIONRESPONSE_SIGACTION_HASSENDREDIRECTRETURNS                                        = "V2SigTestsAction_ActionResponse_SIGAction_hasSendRedirectReturns";
   public final static String               V2SIGTESTSACTION_ACTIONRESPONSE_SIGACTION_HASSENDREDIRECTRETURNSA                                       = "V2SigTestsAction_ActionResponse_SIGAction_hasSendRedirectReturnsA";
   public final static String               V2SIGTESTSACTION_ACTIONRESPONSE_SIGACTION_IMPLEMENTSSTATEAWARERESPONSE                                  = "V2SigTestsAction_ActionResponse_SIGAction_implementsStateAwareResponse";
   public final static String               V2SIGTESTSACTION_CLIENTDATAREQUEST_SIGACTION_HASGETCHARACTERENCODING                                    = "V2SigTestsAction_ClientDataRequest_SIGAction_hasGetCharacterEncoding";
   public final static String               V2SIGTESTSACTION_CLIENTDATAREQUEST_SIGACTION_HASGETCHARACTERENCODINGRETURNS                             = "V2SigTestsAction_ClientDataRequest_SIGAction_hasGetCharacterEncodingReturns";
   public final static String               V2SIGTESTSACTION_CLIENTDATAREQUEST_SIGACTION_HASGETCONTENTLENGTH                                        = "V2SigTestsAction_ClientDataRequest_SIGAction_hasGetContentLength";
   public final static String               V2SIGTESTSACTION_CLIENTDATAREQUEST_SIGACTION_HASGETCONTENTLENGTHRETURNS                                 = "V2SigTestsAction_ClientDataRequest_SIGAction_hasGetContentLengthReturns";
   public final static String               V2SIGTESTSACTION_CLIENTDATAREQUEST_SIGACTION_HASGETCONTENTTYPE                                          = "V2SigTestsAction_ClientDataRequest_SIGAction_hasGetContentType";
   public final static String               V2SIGTESTSACTION_CLIENTDATAREQUEST_SIGACTION_HASGETCONTENTTYPERETURNS                                   = "V2SigTestsAction_ClientDataRequest_SIGAction_hasGetContentTypeReturns";
   public final static String               V2SIGTESTSACTION_CLIENTDATAREQUEST_SIGACTION_HASGETMETHOD                                               = "V2SigTestsAction_ClientDataRequest_SIGAction_hasGetMethod";
   public final static String               V2SIGTESTSACTION_CLIENTDATAREQUEST_SIGACTION_HASGETMETHODRETURNS                                        = "V2SigTestsAction_ClientDataRequest_SIGAction_hasGetMethodReturns";
   public final static String               V2SIGTESTSACTION_CLIENTDATAREQUEST_SIGACTION_HASGETPORTLETINPUTSTREAM                                   = "V2SigTestsAction_ClientDataRequest_SIGAction_hasGetPortletInputStream";
   public final static String               V2SIGTESTSACTION_CLIENTDATAREQUEST_SIGACTION_HASGETPORTLETINPUTSTREAMRETURNS                            = "V2SigTestsAction_ClientDataRequest_SIGAction_hasGetPortletInputStreamReturns";
   public final static String               V2SIGTESTSACTION_CLIENTDATAREQUEST_SIGACTION_HASGETREADER                                               = "V2SigTestsAction_ClientDataRequest_SIGAction_hasGetReader";
   public final static String               V2SIGTESTSACTION_CLIENTDATAREQUEST_SIGACTION_HASGETREADERRETURNS                                        = "V2SigTestsAction_ClientDataRequest_SIGAction_hasGetReaderReturns";
   public final static String               V2SIGTESTSACTION_CLIENTDATAREQUEST_SIGACTION_HASSETCHARACTERENCODING                                    = "V2SigTestsAction_ClientDataRequest_SIGAction_hasSetCharacterEncoding";
   public final static String               V2SIGTESTSACTION_CLIENTDATAREQUEST_SIGACTION_HASSETCHARACTERENCODINGRETURNS                             = "V2SigTestsAction_ClientDataRequest_SIGAction_hasSetCharacterEncodingReturns";
   public final static String               V2SIGTESTSACTION_CLIENTDATAREQUEST_SIGACTION_IMPLEMENTSPORTLETREQUEST                                   = "V2SigTestsAction_ClientDataRequest_SIGAction_implementsPortletRequest";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_FIELDACTION_PHASE                                             = "V2SigTestsAction_PortletRequest_SIGAction_fieldACTION_PHASE";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_FIELDACTION_SCOPE_ID                                          = "V2SigTestsAction_PortletRequest_SIGAction_fieldACTION_SCOPE_ID";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_FIELDBASIC_AUTH                                               = "V2SigTestsAction_PortletRequest_SIGAction_fieldBASIC_AUTH";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_FIELDCCPP_PROFILE                                             = "V2SigTestsAction_PortletRequest_SIGAction_fieldCCPP_PROFILE";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_FIELDCLIENT_CERT_AUTH                                         = "V2SigTestsAction_PortletRequest_SIGAction_fieldCLIENT_CERT_AUTH";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_FIELDDIGEST_AUTH                                              = "V2SigTestsAction_PortletRequest_SIGAction_fieldDIGEST_AUTH";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_FIELDEVENT_PHASE                                              = "V2SigTestsAction_PortletRequest_SIGAction_fieldEVENT_PHASE";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_FIELDFORM_AUTH                                                = "V2SigTestsAction_PortletRequest_SIGAction_fieldFORM_AUTH";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_FIELDLIFECYCLE_PHASE                                          = "V2SigTestsAction_PortletRequest_SIGAction_fieldLIFECYCLE_PHASE";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_FIELDRENDER_HEADERS                                           = "V2SigTestsAction_PortletRequest_SIGAction_fieldRENDER_HEADERS";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_FIELDRENDER_MARKUP                                            = "V2SigTestsAction_PortletRequest_SIGAction_fieldRENDER_MARKUP";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_FIELDRENDER_PART                                              = "V2SigTestsAction_PortletRequest_SIGAction_fieldRENDER_PART";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_FIELDRENDER_PHASE                                             = "V2SigTestsAction_PortletRequest_SIGAction_fieldRENDER_PHASE";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_FIELDRESOURCE_PHASE                                           = "V2SigTestsAction_PortletRequest_SIGAction_fieldRESOURCE_PHASE";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_FIELDUSER_INFO                                                = "V2SigTestsAction_PortletRequest_SIGAction_fieldUSER_INFO";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETATTRIBUTE                                               = "V2SigTestsAction_PortletRequest_SIGAction_hasGetAttribute";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETATTRIBUTENAMES                                          = "V2SigTestsAction_PortletRequest_SIGAction_hasGetAttributeNames";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETATTRIBUTENAMESRETURNS                                   = "V2SigTestsAction_PortletRequest_SIGAction_hasGetAttributeNamesReturns";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETATTRIBUTERETURNS                                        = "V2SigTestsAction_PortletRequest_SIGAction_hasGetAttributeReturns";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETAUTHTYPE                                                = "V2SigTestsAction_PortletRequest_SIGAction_hasGetAuthType";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETAUTHTYPERETURNS                                         = "V2SigTestsAction_PortletRequest_SIGAction_hasGetAuthTypeReturns";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETCONTEXTPATH                                             = "V2SigTestsAction_PortletRequest_SIGAction_hasGetContextPath";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETCONTEXTPATHRETURNS                                      = "V2SigTestsAction_PortletRequest_SIGAction_hasGetContextPathReturns";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETCOOKIES                                                 = "V2SigTestsAction_PortletRequest_SIGAction_hasGetCookies";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETCOOKIESRETURNS                                          = "V2SigTestsAction_PortletRequest_SIGAction_hasGetCookiesReturns";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETLOCALE                                                  = "V2SigTestsAction_PortletRequest_SIGAction_hasGetLocale";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETLOCALERETURNS                                           = "V2SigTestsAction_PortletRequest_SIGAction_hasGetLocaleReturns";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETLOCALES                                                 = "V2SigTestsAction_PortletRequest_SIGAction_hasGetLocales";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETLOCALESRETURNS                                          = "V2SigTestsAction_PortletRequest_SIGAction_hasGetLocalesReturns";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETPARAMETER                                               = "V2SigTestsAction_PortletRequest_SIGAction_hasGetParameter";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETPARAMETERMAP                                            = "V2SigTestsAction_PortletRequest_SIGAction_hasGetParameterMap";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETPARAMETERMAPRETURNS                                     = "V2SigTestsAction_PortletRequest_SIGAction_hasGetParameterMapReturns";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETPARAMETERNAMES                                          = "V2SigTestsAction_PortletRequest_SIGAction_hasGetParameterNames";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETPARAMETERNAMESRETURNS                                   = "V2SigTestsAction_PortletRequest_SIGAction_hasGetParameterNamesReturns";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETPARAMETERRETURNS                                        = "V2SigTestsAction_PortletRequest_SIGAction_hasGetParameterReturns";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETPARAMETERVALUES                                         = "V2SigTestsAction_PortletRequest_SIGAction_hasGetParameterValues";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETPARAMETERVALUESRETURNS                                  = "V2SigTestsAction_PortletRequest_SIGAction_hasGetParameterValuesReturns";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETPORTALCONTEXT                                           = "V2SigTestsAction_PortletRequest_SIGAction_hasGetPortalContext";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETPORTALCONTEXTRETURNS                                    = "V2SigTestsAction_PortletRequest_SIGAction_hasGetPortalContextReturns";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETPORTLETMODE                                             = "V2SigTestsAction_PortletRequest_SIGAction_hasGetPortletMode";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETPORTLETMODERETURNS                                      = "V2SigTestsAction_PortletRequest_SIGAction_hasGetPortletModeReturns";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETPORTLETSESSION                                          = "V2SigTestsAction_PortletRequest_SIGAction_hasGetPortletSession";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETPORTLETSESSIONA                                         = "V2SigTestsAction_PortletRequest_SIGAction_hasGetPortletSessionA";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETPORTLETSESSIONRETURNS                                   = "V2SigTestsAction_PortletRequest_SIGAction_hasGetPortletSessionReturns";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETPORTLETSESSIONRETURNSA                                  = "V2SigTestsAction_PortletRequest_SIGAction_hasGetPortletSessionReturnsA";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETPREFERENCES                                             = "V2SigTestsAction_PortletRequest_SIGAction_hasGetPreferences";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETPREFERENCESRETURNS                                      = "V2SigTestsAction_PortletRequest_SIGAction_hasGetPreferencesReturns";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETPRIVATEPARAMETERMAP                                     = "V2SigTestsAction_PortletRequest_SIGAction_hasGetPrivateParameterMap";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETPRIVATEPARAMETERMAPRETURNS                              = "V2SigTestsAction_PortletRequest_SIGAction_hasGetPrivateParameterMapReturns";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETPROPERTIES                                              = "V2SigTestsAction_PortletRequest_SIGAction_hasGetProperties";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETPROPERTIESRETURNS                                       = "V2SigTestsAction_PortletRequest_SIGAction_hasGetPropertiesReturns";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETPROPERTY                                                = "V2SigTestsAction_PortletRequest_SIGAction_hasGetProperty";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETPROPERTYNAMES                                           = "V2SigTestsAction_PortletRequest_SIGAction_hasGetPropertyNames";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETPROPERTYNAMESRETURNS                                    = "V2SigTestsAction_PortletRequest_SIGAction_hasGetPropertyNamesReturns";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETPROPERTYRETURNS                                         = "V2SigTestsAction_PortletRequest_SIGAction_hasGetPropertyReturns";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETPUBLICPARAMETERMAP                                      = "V2SigTestsAction_PortletRequest_SIGAction_hasGetPublicParameterMap";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETPUBLICPARAMETERMAPRETURNS                               = "V2SigTestsAction_PortletRequest_SIGAction_hasGetPublicParameterMapReturns";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETREMOTEUSER                                              = "V2SigTestsAction_PortletRequest_SIGAction_hasGetRemoteUser";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETREMOTEUSERRETURNS                                       = "V2SigTestsAction_PortletRequest_SIGAction_hasGetRemoteUserReturns";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETREQUESTEDSESSIONID                                      = "V2SigTestsAction_PortletRequest_SIGAction_hasGetRequestedSessionId";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETREQUESTEDSESSIONIDRETURNS                               = "V2SigTestsAction_PortletRequest_SIGAction_hasGetRequestedSessionIdReturns";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETRESPONSECONTENTTYPE                                     = "V2SigTestsAction_PortletRequest_SIGAction_hasGetResponseContentType";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETRESPONSECONTENTTYPERETURNS                              = "V2SigTestsAction_PortletRequest_SIGAction_hasGetResponseContentTypeReturns";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETRESPONSECONTENTTYPES                                    = "V2SigTestsAction_PortletRequest_SIGAction_hasGetResponseContentTypes";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETRESPONSECONTENTTYPESRETURNS                             = "V2SigTestsAction_PortletRequest_SIGAction_hasGetResponseContentTypesReturns";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETSCHEME                                                  = "V2SigTestsAction_PortletRequest_SIGAction_hasGetScheme";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETSCHEMERETURNS                                           = "V2SigTestsAction_PortletRequest_SIGAction_hasGetSchemeReturns";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETSERVERNAME                                              = "V2SigTestsAction_PortletRequest_SIGAction_hasGetServerName";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETSERVERNAMERETURNS                                       = "V2SigTestsAction_PortletRequest_SIGAction_hasGetServerNameReturns";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETSERVERPORT                                              = "V2SigTestsAction_PortletRequest_SIGAction_hasGetServerPort";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETSERVERPORTRETURNS                                       = "V2SigTestsAction_PortletRequest_SIGAction_hasGetServerPortReturns";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETUSERPRINCIPAL                                           = "V2SigTestsAction_PortletRequest_SIGAction_hasGetUserPrincipal";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETUSERPRINCIPALRETURNS                                    = "V2SigTestsAction_PortletRequest_SIGAction_hasGetUserPrincipalReturns";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETWINDOWID                                                = "V2SigTestsAction_PortletRequest_SIGAction_hasGetWindowID";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETWINDOWIDRETURNS                                         = "V2SigTestsAction_PortletRequest_SIGAction_hasGetWindowIDReturns";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETWINDOWSTATE                                             = "V2SigTestsAction_PortletRequest_SIGAction_hasGetWindowState";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETWINDOWSTATERETURNS                                      = "V2SigTestsAction_PortletRequest_SIGAction_hasGetWindowStateReturns";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASISPORTLETMODEALLOWED                                       = "V2SigTestsAction_PortletRequest_SIGAction_hasIsPortletModeAllowed";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASISPORTLETMODEALLOWEDRETURNS                                = "V2SigTestsAction_PortletRequest_SIGAction_hasIsPortletModeAllowedReturns";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASISREQUESTEDSESSIONIDVALID                                  = "V2SigTestsAction_PortletRequest_SIGAction_hasIsRequestedSessionIdValid";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASISREQUESTEDSESSIONIDVALIDRETURNS                           = "V2SigTestsAction_PortletRequest_SIGAction_hasIsRequestedSessionIdValidReturns";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASISSECURE                                                   = "V2SigTestsAction_PortletRequest_SIGAction_hasIsSecure";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASISSECURERETURNS                                            = "V2SigTestsAction_PortletRequest_SIGAction_hasIsSecureReturns";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASISUSERINROLE                                               = "V2SigTestsAction_PortletRequest_SIGAction_hasIsUserInRole";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASISUSERINROLERETURNS                                        = "V2SigTestsAction_PortletRequest_SIGAction_hasIsUserInRoleReturns";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASISWINDOWSTATEALLOWED                                       = "V2SigTestsAction_PortletRequest_SIGAction_hasIsWindowStateAllowed";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASISWINDOWSTATEALLOWEDRETURNS                                = "V2SigTestsAction_PortletRequest_SIGAction_hasIsWindowStateAllowedReturns";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASREMOVEATTRIBUTE                                            = "V2SigTestsAction_PortletRequest_SIGAction_hasRemoveAttribute";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASREMOVEATTRIBUTERETURNS                                     = "V2SigTestsAction_PortletRequest_SIGAction_hasRemoveAttributeReturns";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASSETATTRIBUTE                                               = "V2SigTestsAction_PortletRequest_SIGAction_hasSetAttribute";
   public final static String               V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASSETATTRIBUTERETURNS                                        = "V2SigTestsAction_PortletRequest_SIGAction_hasSetAttributeReturns";
   public final static String               V2SIGTESTSACTION_PORTLETRESPONSE_SIGACTION_HASADDPROPERTY                                               = "V2SigTestsAction_PortletResponse_SIGAction_hasAddProperty";
   public final static String               V2SIGTESTSACTION_PORTLETRESPONSE_SIGACTION_HASADDPROPERTYA                                              = "V2SigTestsAction_PortletResponse_SIGAction_hasAddPropertyA";
   public final static String               V2SIGTESTSACTION_PORTLETRESPONSE_SIGACTION_HASADDPROPERTYB                                              = "V2SigTestsAction_PortletResponse_SIGAction_hasAddPropertyB";
   public final static String               V2SIGTESTSACTION_PORTLETRESPONSE_SIGACTION_HASADDPROPERTYRETURNS                                        = "V2SigTestsAction_PortletResponse_SIGAction_hasAddPropertyReturns";
   public final static String               V2SIGTESTSACTION_PORTLETRESPONSE_SIGACTION_HASADDPROPERTYRETURNSA                                       = "V2SigTestsAction_PortletResponse_SIGAction_hasAddPropertyReturnsA";
   public final static String               V2SIGTESTSACTION_PORTLETRESPONSE_SIGACTION_HASADDPROPERTYRETURNSB                                       = "V2SigTestsAction_PortletResponse_SIGAction_hasAddPropertyReturnsB";
   public final static String               V2SIGTESTSACTION_PORTLETRESPONSE_SIGACTION_HASCREATEELEMENT                                             = "V2SigTestsAction_PortletResponse_SIGAction_hasCreateElement";
   public final static String               V2SIGTESTSACTION_PORTLETRESPONSE_SIGACTION_HASCREATEELEMENTRETURNS                                      = "V2SigTestsAction_PortletResponse_SIGAction_hasCreateElementReturns";
   public final static String               V2SIGTESTSACTION_PORTLETRESPONSE_SIGACTION_HASENCODEURL                                                 = "V2SigTestsAction_PortletResponse_SIGAction_hasEncodeURL";
   public final static String               V2SIGTESTSACTION_PORTLETRESPONSE_SIGACTION_HASENCODEURLRETURNS                                          = "V2SigTestsAction_PortletResponse_SIGAction_hasEncodeURLReturns";
   public final static String               V2SIGTESTSACTION_PORTLETRESPONSE_SIGACTION_HASGETNAMESPACE                                              = "V2SigTestsAction_PortletResponse_SIGAction_hasGetNamespace";
   public final static String               V2SIGTESTSACTION_PORTLETRESPONSE_SIGACTION_HASGETNAMESPACERETURNS                                       = "V2SigTestsAction_PortletResponse_SIGAction_hasGetNamespaceReturns";
   public final static String               V2SIGTESTSACTION_PORTLETRESPONSE_SIGACTION_HASSETPROPERTY                                               = "V2SigTestsAction_PortletResponse_SIGAction_hasSetProperty";
   public final static String               V2SIGTESTSACTION_PORTLETRESPONSE_SIGACTION_HASSETPROPERTYRETURNS                                        = "V2SigTestsAction_PortletResponse_SIGAction_hasSetPropertyReturns";
   public final static String               V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASGETPORTLETMODE                                         = "V2SigTestsAction_StateAwareResponse_SIGAction_hasGetPortletMode";
   public final static String               V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASGETPORTLETMODERETURNS                                  = "V2SigTestsAction_StateAwareResponse_SIGAction_hasGetPortletModeReturns";
   public final static String               V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASGETRENDERPARAMETERMAP                                  = "V2SigTestsAction_StateAwareResponse_SIGAction_hasGetRenderParameterMap";
   public final static String               V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASGETRENDERPARAMETERMAPRETURNS                           = "V2SigTestsAction_StateAwareResponse_SIGAction_hasGetRenderParameterMapReturns";
   public final static String               V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASGETWINDOWSTATE                                         = "V2SigTestsAction_StateAwareResponse_SIGAction_hasGetWindowState";
   public final static String               V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASGETWINDOWSTATERETURNS                                  = "V2SigTestsAction_StateAwareResponse_SIGAction_hasGetWindowStateReturns";
   public final static String               V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASREMOVEPUBLICRENDERPARAMETER                            = "V2SigTestsAction_StateAwareResponse_SIGAction_hasRemovePublicRenderParameter";
   public final static String               V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASREMOVEPUBLICRENDERPARAMETERRETURNS                     = "V2SigTestsAction_StateAwareResponse_SIGAction_hasRemovePublicRenderParameterReturns";
   public final static String               V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASSETEVENT                                               = "V2SigTestsAction_StateAwareResponse_SIGAction_hasSetEvent";
   public final static String               V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASSETEVENTA                                              = "V2SigTestsAction_StateAwareResponse_SIGAction_hasSetEventA";
   public final static String               V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASSETEVENTRETURNS                                        = "V2SigTestsAction_StateAwareResponse_SIGAction_hasSetEventReturns";
   public final static String               V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASSETEVENTRETURNSA                                       = "V2SigTestsAction_StateAwareResponse_SIGAction_hasSetEventReturnsA";
   public final static String               V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASSETPORTLETMODE                                         = "V2SigTestsAction_StateAwareResponse_SIGAction_hasSetPortletMode";
   public final static String               V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASSETPORTLETMODERETURNS                                  = "V2SigTestsAction_StateAwareResponse_SIGAction_hasSetPortletModeReturns";
   public final static String               V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASSETRENDERPARAMETER                                     = "V2SigTestsAction_StateAwareResponse_SIGAction_hasSetRenderParameter";
   public final static String               V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASSETRENDERPARAMETERA                                    = "V2SigTestsAction_StateAwareResponse_SIGAction_hasSetRenderParameterA";
   public final static String               V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASSETRENDERPARAMETERRETURNS                              = "V2SigTestsAction_StateAwareResponse_SIGAction_hasSetRenderParameterReturns";
   public final static String               V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASSETRENDERPARAMETERRETURNSA                             = "V2SigTestsAction_StateAwareResponse_SIGAction_hasSetRenderParameterReturnsA";
   public final static String               V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASSETRENDERPARAMETERS                                    = "V2SigTestsAction_StateAwareResponse_SIGAction_hasSetRenderParameters";
   public final static String               V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASSETRENDERPARAMETERSRETURNS                             = "V2SigTestsAction_StateAwareResponse_SIGAction_hasSetRenderParametersReturns";
   public final static String               V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASSETWINDOWSTATE                                         = "V2SigTestsAction_StateAwareResponse_SIGAction_hasSetWindowState";
   public final static String               V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASSETWINDOWSTATERETURNS                                  = "V2SigTestsAction_StateAwareResponse_SIGAction_hasSetWindowStateReturns";
   public final static String               V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_IMPLEMENTSPORTLETRESPONSE                                 = "V2SigTestsAction_StateAwareResponse_SIGAction_implementsPortletResponse";
   public final static String               V2SIGTESTSENV_CACHECONTROL_SIGRENDER_HASGETETAG                                                         = "V2SigTestsEnv_CacheControl_SIGRender_hasGetETag";
   public final static String               V2SIGTESTSENV_CACHECONTROL_SIGRENDER_HASGETETAGRETURNS                                                  = "V2SigTestsEnv_CacheControl_SIGRender_hasGetETagReturns";
   public final static String               V2SIGTESTSENV_CACHECONTROL_SIGRENDER_HASGETEXPIRATIONTIME                                               = "V2SigTestsEnv_CacheControl_SIGRender_hasGetExpirationTime";
   public final static String               V2SIGTESTSENV_CACHECONTROL_SIGRENDER_HASGETEXPIRATIONTIMERETURNS                                        = "V2SigTestsEnv_CacheControl_SIGRender_hasGetExpirationTimeReturns";
   public final static String               V2SIGTESTSENV_CACHECONTROL_SIGRENDER_HASISPUBLICSCOPE                                                   = "V2SigTestsEnv_CacheControl_SIGRender_hasIsPublicScope";
   public final static String               V2SIGTESTSENV_CACHECONTROL_SIGRENDER_HASISPUBLICSCOPERETURNS                                            = "V2SigTestsEnv_CacheControl_SIGRender_hasIsPublicScopeReturns";
   public final static String               V2SIGTESTSENV_CACHECONTROL_SIGRENDER_HASSETETAG                                                         = "V2SigTestsEnv_CacheControl_SIGRender_hasSetETag";
   public final static String               V2SIGTESTSENV_CACHECONTROL_SIGRENDER_HASSETETAGRETURNS                                                  = "V2SigTestsEnv_CacheControl_SIGRender_hasSetETagReturns";
   public final static String               V2SIGTESTSENV_CACHECONTROL_SIGRENDER_HASSETEXPIRATIONTIME                                               = "V2SigTestsEnv_CacheControl_SIGRender_hasSetExpirationTime";
   public final static String               V2SIGTESTSENV_CACHECONTROL_SIGRENDER_HASSETEXPIRATIONTIMERETURNS                                        = "V2SigTestsEnv_CacheControl_SIGRender_hasSetExpirationTimeReturns";
   public final static String               V2SIGTESTSENV_CACHECONTROL_SIGRENDER_HASSETPUBLICSCOPE                                                  = "V2SigTestsEnv_CacheControl_SIGRender_hasSetPublicScope";
   public final static String               V2SIGTESTSENV_CACHECONTROL_SIGRENDER_HASSETPUBLICSCOPERETURNS                                           = "V2SigTestsEnv_CacheControl_SIGRender_hasSetPublicScopeReturns";
   public final static String               V2SIGTESTSENV_CACHECONTROL_SIGRENDER_HASSETUSECACHEDCONTENT                                             = "V2SigTestsEnv_CacheControl_SIGRender_hasSetUseCachedContent";
   public final static String               V2SIGTESTSENV_CACHECONTROL_SIGRENDER_HASSETUSECACHEDCONTENTRETURNS                                      = "V2SigTestsEnv_CacheControl_SIGRender_hasSetUseCachedContentReturns";
   public final static String               V2SIGTESTSENV_CACHECONTROL_SIGRENDER_HASUSECACHEDCONTENT                                                = "V2SigTestsEnv_CacheControl_SIGRender_hasUseCachedContent";
   public final static String               V2SIGTESTSENV_CACHECONTROL_SIGRENDER_HASUSECACHEDCONTENTRETURNS                                         = "V2SigTestsEnv_CacheControl_SIGRender_hasUseCachedContentReturns";
   public final static String               V2SIGTESTSENV_EVENTPORTLET_SIGRENDER_HASPROCESSEVENT                                                    = "V2SigTestsEnv_EventPortlet_SIGRender_hasProcessEvent";
   public final static String               V2SIGTESTSENV_EVENTPORTLET_SIGRENDER_HASPROCESSEVENTRETURNS                                             = "V2SigTestsEnv_EventPortlet_SIGRender_hasProcessEventReturns";
   public final static String               V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_CONSTRUCTOR                                                      = "V2SigTestsEnv_GenericPortlet_SIGRender_constructor";
   public final static String               V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASDESTROY                                                       = "V2SigTestsEnv_GenericPortlet_SIGRender_hasDestroy";
   public final static String               V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASDESTROYRETURNS                                                = "V2SigTestsEnv_GenericPortlet_SIGRender_hasDestroyReturns";
   public final static String               V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASDODISPATCH                                                    = "V2SigTestsEnv_GenericPortlet_SIGRender_hasDoDispatch";
   public final static String               V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASDODISPATCHRETURNS                                             = "V2SigTestsEnv_GenericPortlet_SIGRender_hasDoDispatchReturns";
   public final static String               V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASDOEDIT                                                        = "V2SigTestsEnv_GenericPortlet_SIGRender_hasDoEdit";
   public final static String               V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASDOEDITRETURNS                                                 = "V2SigTestsEnv_GenericPortlet_SIGRender_hasDoEditReturns";
   public final static String               V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASDOHEADERS                                                     = "V2SigTestsEnv_GenericPortlet_SIGRender_hasDoHeaders";
   public final static String               V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASDOHEADERSRETURNS                                              = "V2SigTestsEnv_GenericPortlet_SIGRender_hasDoHeadersReturns";
   public final static String               V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASDOHELP                                                        = "V2SigTestsEnv_GenericPortlet_SIGRender_hasDoHelp";
   public final static String               V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASDOHELPRETURNS                                                 = "V2SigTestsEnv_GenericPortlet_SIGRender_hasDoHelpReturns";
   public final static String               V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASDOVIEW                                                        = "V2SigTestsEnv_GenericPortlet_SIGRender_hasDoView";
   public final static String               V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASDOVIEWRETURNS                                                 = "V2SigTestsEnv_GenericPortlet_SIGRender_hasDoViewReturns";
   public final static String               V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETCONTAINERRUNTIMEOPTIONS                                    = "V2SigTestsEnv_GenericPortlet_SIGRender_hasGetContainerRuntimeOptions";
   public final static String               V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETCONTAINERRUNTIMEOPTIONSRETURNS                             = "V2SigTestsEnv_GenericPortlet_SIGRender_hasGetContainerRuntimeOptionsReturns";
   public final static String               V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETDEFAULTNAMESPACE                                           = "V2SigTestsEnv_GenericPortlet_SIGRender_hasGetDefaultNamespace";
   public final static String               V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETDEFAULTNAMESPACERETURNS                                    = "V2SigTestsEnv_GenericPortlet_SIGRender_hasGetDefaultNamespaceReturns";
   public final static String               V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETINITPARAMETER                                              = "V2SigTestsEnv_GenericPortlet_SIGRender_hasGetInitParameter";
   public final static String               V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETINITPARAMETERNAMES                                         = "V2SigTestsEnv_GenericPortlet_SIGRender_hasGetInitParameterNames";
   public final static String               V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETINITPARAMETERNAMESRETURNS                                  = "V2SigTestsEnv_GenericPortlet_SIGRender_hasGetInitParameterNamesReturns";
   public final static String               V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETINITPARAMETERRETURNS                                       = "V2SigTestsEnv_GenericPortlet_SIGRender_hasGetInitParameterReturns";
   public final static String               V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETNEXTPOSSIBLEPORTLETMODES                                   = "V2SigTestsEnv_GenericPortlet_SIGRender_hasGetNextPossiblePortletModes";
   public final static String               V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETNEXTPOSSIBLEPORTLETMODESRETURNS                            = "V2SigTestsEnv_GenericPortlet_SIGRender_hasGetNextPossiblePortletModesReturns";
   public final static String               V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETPORTLETCONFIG                                              = "V2SigTestsEnv_GenericPortlet_SIGRender_hasGetPortletConfig";
   public final static String               V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETPORTLETCONFIGRETURNS                                       = "V2SigTestsEnv_GenericPortlet_SIGRender_hasGetPortletConfigReturns";
   public final static String               V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETPORTLETCONTEXT                                             = "V2SigTestsEnv_GenericPortlet_SIGRender_hasGetPortletContext";
   public final static String               V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETPORTLETCONTEXTRETURNS                                      = "V2SigTestsEnv_GenericPortlet_SIGRender_hasGetPortletContextReturns";
   public final static String               V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETPORTLETNAME                                                = "V2SigTestsEnv_GenericPortlet_SIGRender_hasGetPortletName";
   public final static String               V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETPORTLETNAMERETURNS                                         = "V2SigTestsEnv_GenericPortlet_SIGRender_hasGetPortletNameReturns";
   public final static String               V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETPROCESSINGEVENTQNAMES                                      = "V2SigTestsEnv_GenericPortlet_SIGRender_hasGetProcessingEventQNames";
   public final static String               V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETPROCESSINGEVENTQNAMESRETURNS                               = "V2SigTestsEnv_GenericPortlet_SIGRender_hasGetProcessingEventQNamesReturns";
   public final static String               V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETPUBLICRENDERPARAMETERNAMES                                 = "V2SigTestsEnv_GenericPortlet_SIGRender_hasGetPublicRenderParameterNames";
   public final static String               V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETPUBLICRENDERPARAMETERNAMESRETURNS                          = "V2SigTestsEnv_GenericPortlet_SIGRender_hasGetPublicRenderParameterNamesReturns";
   public final static String               V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETPUBLISHINGEVENTQNAMES                                      = "V2SigTestsEnv_GenericPortlet_SIGRender_hasGetPublishingEventQNames";
   public final static String               V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETPUBLISHINGEVENTQNAMESRETURNS                               = "V2SigTestsEnv_GenericPortlet_SIGRender_hasGetPublishingEventQNamesReturns";
   public final static String               V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETRESOURCEBUNDLE                                             = "V2SigTestsEnv_GenericPortlet_SIGRender_hasGetResourceBundle";
   public final static String               V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETRESOURCEBUNDLERETURNS                                      = "V2SigTestsEnv_GenericPortlet_SIGRender_hasGetResourceBundleReturns";
   public final static String               V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETSUPPORTEDLOCALES                                           = "V2SigTestsEnv_GenericPortlet_SIGRender_hasGetSupportedLocales";
   public final static String               V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETSUPPORTEDLOCALESRETURNS                                    = "V2SigTestsEnv_GenericPortlet_SIGRender_hasGetSupportedLocalesReturns";
   public final static String               V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETTITLE                                                      = "V2SigTestsEnv_GenericPortlet_SIGRender_hasGetTitle";
   public final static String               V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETTITLERETURNS                                               = "V2SigTestsEnv_GenericPortlet_SIGRender_hasGetTitleReturns";
   public final static String               V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASINIT                                                          = "V2SigTestsEnv_GenericPortlet_SIGRender_hasInit";
   public final static String               V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASINITA                                                         = "V2SigTestsEnv_GenericPortlet_SIGRender_hasInitA";
   public final static String               V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASINITRETURNS                                                   = "V2SigTestsEnv_GenericPortlet_SIGRender_hasInitReturns";
   public final static String               V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASINITRETURNSA                                                  = "V2SigTestsEnv_GenericPortlet_SIGRender_hasInitReturnsA";
   public final static String               V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASPROCESSACTION                                                 = "V2SigTestsEnv_GenericPortlet_SIGRender_hasProcessAction";
   public final static String               V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASPROCESSACTIONRETURNS                                          = "V2SigTestsEnv_GenericPortlet_SIGRender_hasProcessActionReturns";
   public final static String               V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASPROCESSEVENT                                                  = "V2SigTestsEnv_GenericPortlet_SIGRender_hasProcessEvent";
   public final static String               V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASPROCESSEVENTRETURNS                                           = "V2SigTestsEnv_GenericPortlet_SIGRender_hasProcessEventReturns";
   public final static String               V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASRENDER                                                        = "V2SigTestsEnv_GenericPortlet_SIGRender_hasRender";
   public final static String               V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASRENDERRETURNS                                                 = "V2SigTestsEnv_GenericPortlet_SIGRender_hasRenderReturns";
   public final static String               V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASSERVERESOURCE                                                 = "V2SigTestsEnv_GenericPortlet_SIGRender_hasServeResource";
   public final static String               V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASSERVERESOURCERETURNS                                          = "V2SigTestsEnv_GenericPortlet_SIGRender_hasServeResourceReturns";
   public final static String               V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_IMPLEMENTSEVENTPORTLET                                           = "V2SigTestsEnv_GenericPortlet_SIGRender_implementsEventPortlet";
   public final static String               V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_IMPLEMENTSPORTLET                                                = "V2SigTestsEnv_GenericPortlet_SIGRender_implementsPortlet";
   public final static String               V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_IMPLEMENTSPORTLETCONFIG                                          = "V2SigTestsEnv_GenericPortlet_SIGRender_implementsPortletConfig";
   public final static String               V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_IMPLEMENTSRESOURCESERVINGPORTLET                                 = "V2SigTestsEnv_GenericPortlet_SIGRender_implementsResourceServingPortlet";
   public final static String               V2SIGTESTSENV_PORTALCONTEXT_SIGRENDER_FIELDMARKUP_HEAD_ELEMENT_SUPPORT                                  = "V2SigTestsEnv_PortalContext_SIGRender_fieldMARKUP_HEAD_ELEMENT_SUPPORT";
   public final static String               V2SIGTESTSENV_PORTALCONTEXT_SIGRENDER_HASGETPORTALINFO                                                  = "V2SigTestsEnv_PortalContext_SIGRender_hasGetPortalInfo";
   public final static String               V2SIGTESTSENV_PORTALCONTEXT_SIGRENDER_HASGETPORTALINFORETURNS                                           = "V2SigTestsEnv_PortalContext_SIGRender_hasGetPortalInfoReturns";
   public final static String               V2SIGTESTSENV_PORTALCONTEXT_SIGRENDER_HASGETPROPERTY                                                    = "V2SigTestsEnv_PortalContext_SIGRender_hasGetProperty";
   public final static String               V2SIGTESTSENV_PORTALCONTEXT_SIGRENDER_HASGETPROPERTYNAMES                                               = "V2SigTestsEnv_PortalContext_SIGRender_hasGetPropertyNames";
   public final static String               V2SIGTESTSENV_PORTALCONTEXT_SIGRENDER_HASGETPROPERTYNAMESRETURNS                                        = "V2SigTestsEnv_PortalContext_SIGRender_hasGetPropertyNamesReturns";
   public final static String               V2SIGTESTSENV_PORTALCONTEXT_SIGRENDER_HASGETPROPERTYRETURNS                                             = "V2SigTestsEnv_PortalContext_SIGRender_hasGetPropertyReturns";
   public final static String               V2SIGTESTSENV_PORTALCONTEXT_SIGRENDER_HASGETSUPPORTEDPORTLETMODES                                       = "V2SigTestsEnv_PortalContext_SIGRender_hasGetSupportedPortletModes";
   public final static String               V2SIGTESTSENV_PORTALCONTEXT_SIGRENDER_HASGETSUPPORTEDPORTLETMODESRETURNS                                = "V2SigTestsEnv_PortalContext_SIGRender_hasGetSupportedPortletModesReturns";
   public final static String               V2SIGTESTSENV_PORTALCONTEXT_SIGRENDER_HASGETSUPPORTEDWINDOWSTATES                                       = "V2SigTestsEnv_PortalContext_SIGRender_hasGetSupportedWindowStates";
   public final static String               V2SIGTESTSENV_PORTALCONTEXT_SIGRENDER_HASGETSUPPORTEDWINDOWSTATESRETURNS                                = "V2SigTestsEnv_PortalContext_SIGRender_hasGetSupportedWindowStatesReturns";
   public final static String               V2SIGTESTSENV_PORTLET_SIGRENDER_HASDESTROY                                                              = "V2SigTestsEnv_Portlet_SIGRender_hasDestroy";
   public final static String               V2SIGTESTSENV_PORTLET_SIGRENDER_HASDESTROYRETURNS                                                       = "V2SigTestsEnv_Portlet_SIGRender_hasDestroyReturns";
   public final static String               V2SIGTESTSENV_PORTLET_SIGRENDER_HASINIT                                                                 = "V2SigTestsEnv_Portlet_SIGRender_hasInit";
   public final static String               V2SIGTESTSENV_PORTLET_SIGRENDER_HASINITRETURNS                                                          = "V2SigTestsEnv_Portlet_SIGRender_hasInitReturns";
   public final static String               V2SIGTESTSENV_PORTLET_SIGRENDER_HASPROCESSACTION                                                        = "V2SigTestsEnv_Portlet_SIGRender_hasProcessAction";
   public final static String               V2SIGTESTSENV_PORTLET_SIGRENDER_HASPROCESSACTIONRETURNS                                                 = "V2SigTestsEnv_Portlet_SIGRender_hasProcessActionReturns";
   public final static String               V2SIGTESTSENV_PORTLET_SIGRENDER_HASRENDER                                                               = "V2SigTestsEnv_Portlet_SIGRender_hasRender";
   public final static String               V2SIGTESTSENV_PORTLET_SIGRENDER_HASRENDERRETURNS                                                        = "V2SigTestsEnv_Portlet_SIGRender_hasRenderReturns";
   public final static String               V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETCONTAINERRUNTIMEOPTIONS                                     = "V2SigTestsEnv_PortletConfig_SIGRender_hasGetContainerRuntimeOptions";
   public final static String               V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETCONTAINERRUNTIMEOPTIONSRETURNS                              = "V2SigTestsEnv_PortletConfig_SIGRender_hasGetContainerRuntimeOptionsReturns";
   public final static String               V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETDEFAULTNAMESPACE                                            = "V2SigTestsEnv_PortletConfig_SIGRender_hasGetDefaultNamespace";
   public final static String               V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETDEFAULTNAMESPACERETURNS                                     = "V2SigTestsEnv_PortletConfig_SIGRender_hasGetDefaultNamespaceReturns";
   public final static String               V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETINITPARAMETER                                               = "V2SigTestsEnv_PortletConfig_SIGRender_hasGetInitParameter";
   public final static String               V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETINITPARAMETERNAMES                                          = "V2SigTestsEnv_PortletConfig_SIGRender_hasGetInitParameterNames";
   public final static String               V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETINITPARAMETERNAMESRETURNS                                   = "V2SigTestsEnv_PortletConfig_SIGRender_hasGetInitParameterNamesReturns";
   public final static String               V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETINITPARAMETERRETURNS                                        = "V2SigTestsEnv_PortletConfig_SIGRender_hasGetInitParameterReturns";
   public final static String               V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETPORTLETCONTEXT                                              = "V2SigTestsEnv_PortletConfig_SIGRender_hasGetPortletContext";
   public final static String               V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETPORTLETCONTEXTRETURNS                                       = "V2SigTestsEnv_PortletConfig_SIGRender_hasGetPortletContextReturns";
   public final static String               V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETPORTLETNAME                                                 = "V2SigTestsEnv_PortletConfig_SIGRender_hasGetPortletName";
   public final static String               V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETPORTLETNAMERETURNS                                          = "V2SigTestsEnv_PortletConfig_SIGRender_hasGetPortletNameReturns";
   public final static String               V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETPROCESSINGEVENTQNAMES                                       = "V2SigTestsEnv_PortletConfig_SIGRender_hasGetProcessingEventQNames";
   public final static String               V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETPROCESSINGEVENTQNAMESRETURNS                                = "V2SigTestsEnv_PortletConfig_SIGRender_hasGetProcessingEventQNamesReturns";
   public final static String               V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETPUBLICRENDERPARAMETERNAMES                                  = "V2SigTestsEnv_PortletConfig_SIGRender_hasGetPublicRenderParameterNames";
   public final static String               V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETPUBLICRENDERPARAMETERNAMESRETURNS                           = "V2SigTestsEnv_PortletConfig_SIGRender_hasGetPublicRenderParameterNamesReturns";
   public final static String               V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETPUBLISHINGEVENTQNAMES                                       = "V2SigTestsEnv_PortletConfig_SIGRender_hasGetPublishingEventQNames";
   public final static String               V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETPUBLISHINGEVENTQNAMESRETURNS                                = "V2SigTestsEnv_PortletConfig_SIGRender_hasGetPublishingEventQNamesReturns";
   public final static String               V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETRESOURCEBUNDLE                                              = "V2SigTestsEnv_PortletConfig_SIGRender_hasGetResourceBundle";
   public final static String               V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETRESOURCEBUNDLERETURNS                                       = "V2SigTestsEnv_PortletConfig_SIGRender_hasGetResourceBundleReturns";
   public final static String               V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETSUPPORTEDLOCALES                                            = "V2SigTestsEnv_PortletConfig_SIGRender_hasGetSupportedLocales";
   public final static String               V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETSUPPORTEDLOCALESRETURNS                                     = "V2SigTestsEnv_PortletConfig_SIGRender_hasGetSupportedLocalesReturns";
   public final static String               V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETATTRIBUTE                                                  = "V2SigTestsEnv_PortletContext_SIGRender_hasGetAttribute";
   public final static String               V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETATTRIBUTENAMES                                             = "V2SigTestsEnv_PortletContext_SIGRender_hasGetAttributeNames";
   public final static String               V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETATTRIBUTENAMESRETURNS                                      = "V2SigTestsEnv_PortletContext_SIGRender_hasGetAttributeNamesReturns";
   public final static String               V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETATTRIBUTERETURNS                                           = "V2SigTestsEnv_PortletContext_SIGRender_hasGetAttributeReturns";
   public final static String               V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETCONTAINERRUNTIMEOPTIONS                                    = "V2SigTestsEnv_PortletContext_SIGRender_hasGetContainerRuntimeOptions";
   public final static String               V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETCONTAINERRUNTIMEOPTIONSRETURNS                             = "V2SigTestsEnv_PortletContext_SIGRender_hasGetContainerRuntimeOptionsReturns";
   public final static String               V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETINITPARAMETER                                              = "V2SigTestsEnv_PortletContext_SIGRender_hasGetInitParameter";
   public final static String               V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETINITPARAMETERNAMES                                         = "V2SigTestsEnv_PortletContext_SIGRender_hasGetInitParameterNames";
   public final static String               V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETINITPARAMETERNAMESRETURNS                                  = "V2SigTestsEnv_PortletContext_SIGRender_hasGetInitParameterNamesReturns";
   public final static String               V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETINITPARAMETERRETURNS                                       = "V2SigTestsEnv_PortletContext_SIGRender_hasGetInitParameterReturns";
   public final static String               V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETMAJORVERSION                                               = "V2SigTestsEnv_PortletContext_SIGRender_hasGetMajorVersion";
   public final static String               V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETMAJORVERSIONRETURNS                                        = "V2SigTestsEnv_PortletContext_SIGRender_hasGetMajorVersionReturns";
   public final static String               V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETMIMETYPE                                                   = "V2SigTestsEnv_PortletContext_SIGRender_hasGetMimeType";
   public final static String               V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETMIMETYPERETURNS                                            = "V2SigTestsEnv_PortletContext_SIGRender_hasGetMimeTypeReturns";
   public final static String               V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETMINORVERSION                                               = "V2SigTestsEnv_PortletContext_SIGRender_hasGetMinorVersion";
   public final static String               V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETMINORVERSIONRETURNS                                        = "V2SigTestsEnv_PortletContext_SIGRender_hasGetMinorVersionReturns";
   public final static String               V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETNAMEDDISPATCHER                                            = "V2SigTestsEnv_PortletContext_SIGRender_hasGetNamedDispatcher";
   public final static String               V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETNAMEDDISPATCHERRETURNS                                     = "V2SigTestsEnv_PortletContext_SIGRender_hasGetNamedDispatcherReturns";
   public final static String               V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETPORTLETCONTEXTNAME                                         = "V2SigTestsEnv_PortletContext_SIGRender_hasGetPortletContextName";
   public final static String               V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETPORTLETCONTEXTNAMERETURNS                                  = "V2SigTestsEnv_PortletContext_SIGRender_hasGetPortletContextNameReturns";
   public final static String               V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETREALPATH                                                   = "V2SigTestsEnv_PortletContext_SIGRender_hasGetRealPath";
   public final static String               V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETREALPATHRETURNS                                            = "V2SigTestsEnv_PortletContext_SIGRender_hasGetRealPathReturns";
   public final static String               V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETREQUESTDISPATCHER                                          = "V2SigTestsEnv_PortletContext_SIGRender_hasGetRequestDispatcher";
   public final static String               V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETREQUESTDISPATCHERRETURNS                                   = "V2SigTestsEnv_PortletContext_SIGRender_hasGetRequestDispatcherReturns";
   public final static String               V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETRESOURCE                                                   = "V2SigTestsEnv_PortletContext_SIGRender_hasGetResource";
   public final static String               V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETRESOURCEASSTREAM                                           = "V2SigTestsEnv_PortletContext_SIGRender_hasGetResourceAsStream";
   public final static String               V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETRESOURCEASSTREAMRETURNS                                    = "V2SigTestsEnv_PortletContext_SIGRender_hasGetResourceAsStreamReturns";
   public final static String               V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETRESOURCEPATHS                                              = "V2SigTestsEnv_PortletContext_SIGRender_hasGetResourcePaths";
   public final static String               V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETRESOURCEPATHSRETURNS                                       = "V2SigTestsEnv_PortletContext_SIGRender_hasGetResourcePathsReturns";
   public final static String               V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETRESOURCERETURNS                                            = "V2SigTestsEnv_PortletContext_SIGRender_hasGetResourceReturns";
   public final static String               V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETSERVERINFO                                                 = "V2SigTestsEnv_PortletContext_SIGRender_hasGetServerInfo";
   public final static String               V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETSERVERINFORETURNS                                          = "V2SigTestsEnv_PortletContext_SIGRender_hasGetServerInfoReturns";
   public final static String               V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASLOG                                                           = "V2SigTestsEnv_PortletContext_SIGRender_hasLog";
   public final static String               V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASLOGA                                                          = "V2SigTestsEnv_PortletContext_SIGRender_hasLogA";
   public final static String               V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASLOGRETURNS                                                    = "V2SigTestsEnv_PortletContext_SIGRender_hasLogReturns";
   public final static String               V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASLOGRETURNSA                                                   = "V2SigTestsEnv_PortletContext_SIGRender_hasLogReturnsA";
   public final static String               V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASREMOVEATTRIBUTE                                               = "V2SigTestsEnv_PortletContext_SIGRender_hasRemoveAttribute";
   public final static String               V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASREMOVEATTRIBUTERETURNS                                        = "V2SigTestsEnv_PortletContext_SIGRender_hasRemoveAttributeReturns";
   public final static String               V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASSETATTRIBUTE                                                  = "V2SigTestsEnv_PortletContext_SIGRender_hasSetAttribute";
   public final static String               V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASSETATTRIBUTERETURNS                                           = "V2SigTestsEnv_PortletContext_SIGRender_hasSetAttributeReturns";
   public final static String               V2SIGTESTSENV_PORTLETMODE_SIGRENDER_CONSTRUCTOR                                                         = "V2SigTestsEnv_PortletMode_SIGRender_constructor";
   public final static String               V2SIGTESTSENV_PORTLETMODE_SIGRENDER_FIELDEDIT                                                           = "V2SigTestsEnv_PortletMode_SIGRender_fieldEDIT";
   public final static String               V2SIGTESTSENV_PORTLETMODE_SIGRENDER_FIELDHELP                                                           = "V2SigTestsEnv_PortletMode_SIGRender_fieldHELP";
   public final static String               V2SIGTESTSENV_PORTLETMODE_SIGRENDER_FIELDVIEW                                                           = "V2SigTestsEnv_PortletMode_SIGRender_fieldVIEW";
   public final static String               V2SIGTESTSENV_PORTLETMODE_SIGRENDER_HASEQUALS                                                           = "V2SigTestsEnv_PortletMode_SIGRender_hasEquals";
   public final static String               V2SIGTESTSENV_PORTLETMODE_SIGRENDER_HASEQUALSRETURNS                                                    = "V2SigTestsEnv_PortletMode_SIGRender_hasEqualsReturns";
   public final static String               V2SIGTESTSENV_PORTLETMODE_SIGRENDER_HASHASHCODE                                                         = "V2SigTestsEnv_PortletMode_SIGRender_hasHashCode";
   public final static String               V2SIGTESTSENV_PORTLETMODE_SIGRENDER_HASHASHCODERETURNS                                                  = "V2SigTestsEnv_PortletMode_SIGRender_hasHashCodeReturns";
   public final static String               V2SIGTESTSENV_PORTLETMODE_SIGRENDER_HASTOSTRING                                                         = "V2SigTestsEnv_PortletMode_SIGRender_hasToString";
   public final static String               V2SIGTESTSENV_PORTLETMODE_SIGRENDER_HASTOSTRINGRETURNS                                                  = "V2SigTestsEnv_PortletMode_SIGRender_hasToStringReturns";
   public final static String               V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASGETMAP                                                    = "V2SigTestsEnv_PortletPreferences_SIGRender_hasGetMap";
   public final static String               V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASGETMAPRETURNS                                             = "V2SigTestsEnv_PortletPreferences_SIGRender_hasGetMapReturns";
   public final static String               V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASGETNAMES                                                  = "V2SigTestsEnv_PortletPreferences_SIGRender_hasGetNames";
   public final static String               V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASGETNAMESRETURNS                                           = "V2SigTestsEnv_PortletPreferences_SIGRender_hasGetNamesReturns";
   public final static String               V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASGETVALUE                                                  = "V2SigTestsEnv_PortletPreferences_SIGRender_hasGetValue";
   public final static String               V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASGETVALUERETURNS                                           = "V2SigTestsEnv_PortletPreferences_SIGRender_hasGetValueReturns";
   public final static String               V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASGETVALUES                                                 = "V2SigTestsEnv_PortletPreferences_SIGRender_hasGetValues";
   public final static String               V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASGETVALUESRETURNS                                          = "V2SigTestsEnv_PortletPreferences_SIGRender_hasGetValuesReturns";
   public final static String               V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASISREADONLY                                                = "V2SigTestsEnv_PortletPreferences_SIGRender_hasIsReadOnly";
   public final static String               V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASISREADONLYRETURNS                                         = "V2SigTestsEnv_PortletPreferences_SIGRender_hasIsReadOnlyReturns";
   public final static String               V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASRESET                                                     = "V2SigTestsEnv_PortletPreferences_SIGRender_hasReset";
   public final static String               V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASRESETRETURNS                                              = "V2SigTestsEnv_PortletPreferences_SIGRender_hasResetReturns";
   public final static String               V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASSETVALUE                                                  = "V2SigTestsEnv_PortletPreferences_SIGRender_hasSetValue";
   public final static String               V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASSETVALUERETURNS                                           = "V2SigTestsEnv_PortletPreferences_SIGRender_hasSetValueReturns";
   public final static String               V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASSETVALUES                                                 = "V2SigTestsEnv_PortletPreferences_SIGRender_hasSetValues";
   public final static String               V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASSETVALUESRETURNS                                          = "V2SigTestsEnv_PortletPreferences_SIGRender_hasSetValuesReturns";
   public final static String               V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASSTORE                                                     = "V2SigTestsEnv_PortletPreferences_SIGRender_hasStore";
   public final static String               V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASSTORERETURNS                                              = "V2SigTestsEnv_PortletPreferences_SIGRender_hasStoreReturns";
   public final static String               V2SIGTESTSENV_PORTLETREQUESTDISPATCHER_SIGRENDER_HASFORWARD                                             = "V2SigTestsEnv_PortletRequestDispatcher_SIGRender_hasForward";
   public final static String               V2SIGTESTSENV_PORTLETREQUESTDISPATCHER_SIGRENDER_HASFORWARDRETURNS                                      = "V2SigTestsEnv_PortletRequestDispatcher_SIGRender_hasForwardReturns";
   public final static String               V2SIGTESTSENV_PORTLETREQUESTDISPATCHER_SIGRENDER_HASINCLUDE                                             = "V2SigTestsEnv_PortletRequestDispatcher_SIGRender_hasInclude";
   public final static String               V2SIGTESTSENV_PORTLETREQUESTDISPATCHER_SIGRENDER_HASINCLUDEA                                            = "V2SigTestsEnv_PortletRequestDispatcher_SIGRender_hasIncludeA";
   public final static String               V2SIGTESTSENV_PORTLETREQUESTDISPATCHER_SIGRENDER_HASINCLUDERETURNS                                      = "V2SigTestsEnv_PortletRequestDispatcher_SIGRender_hasIncludeReturns";
   public final static String               V2SIGTESTSENV_PORTLETREQUESTDISPATCHER_SIGRENDER_HASINCLUDERETURNSA                                     = "V2SigTestsEnv_PortletRequestDispatcher_SIGRender_hasIncludeReturnsA";
   public final static String               V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_FIELDAPPLICATION_SCOPE                                           = "V2SigTestsEnv_PortletSession_SIGRender_fieldAPPLICATION_SCOPE";
   public final static String               V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_FIELDPORTLET_SCOPE                                               = "V2SigTestsEnv_PortletSession_SIGRender_fieldPORTLET_SCOPE";
   public final static String               V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETATTRIBUTE                                                  = "V2SigTestsEnv_PortletSession_SIGRender_hasGetAttribute";
   public final static String               V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETATTRIBUTEA                                                 = "V2SigTestsEnv_PortletSession_SIGRender_hasGetAttributeA";
   public final static String               V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETATTRIBUTEMAP                                               = "V2SigTestsEnv_PortletSession_SIGRender_hasGetAttributeMap";
   public final static String               V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETATTRIBUTEMAPA                                              = "V2SigTestsEnv_PortletSession_SIGRender_hasGetAttributeMapA";
   public final static String               V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETATTRIBUTEMAPRETURNS                                        = "V2SigTestsEnv_PortletSession_SIGRender_hasGetAttributeMapReturns";
   public final static String               V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETATTRIBUTEMAPRETURNSA                                       = "V2SigTestsEnv_PortletSession_SIGRender_hasGetAttributeMapReturnsA";
   public final static String               V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETATTRIBUTENAMES                                             = "V2SigTestsEnv_PortletSession_SIGRender_hasGetAttributeNames";
   public final static String               V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETATTRIBUTENAMESA                                            = "V2SigTestsEnv_PortletSession_SIGRender_hasGetAttributeNamesA";
   public final static String               V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETATTRIBUTENAMESRETURNS                                      = "V2SigTestsEnv_PortletSession_SIGRender_hasGetAttributeNamesReturns";
   public final static String               V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETATTRIBUTENAMESRETURNSA                                     = "V2SigTestsEnv_PortletSession_SIGRender_hasGetAttributeNamesReturnsA";
   public final static String               V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETATTRIBUTERETURNS                                           = "V2SigTestsEnv_PortletSession_SIGRender_hasGetAttributeReturns";
   public final static String               V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETATTRIBUTERETURNSA                                          = "V2SigTestsEnv_PortletSession_SIGRender_hasGetAttributeReturnsA";
   public final static String               V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETCREATIONTIME                                               = "V2SigTestsEnv_PortletSession_SIGRender_hasGetCreationTime";
   public final static String               V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETCREATIONTIMERETURNS                                        = "V2SigTestsEnv_PortletSession_SIGRender_hasGetCreationTimeReturns";
   public final static String               V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETID                                                         = "V2SigTestsEnv_PortletSession_SIGRender_hasGetId";
   public final static String               V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETIDRETURNS                                                  = "V2SigTestsEnv_PortletSession_SIGRender_hasGetIdReturns";
   public final static String               V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETLASTACCESSEDTIME                                           = "V2SigTestsEnv_PortletSession_SIGRender_hasGetLastAccessedTime";
   public final static String               V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETLASTACCESSEDTIMERETURNS                                    = "V2SigTestsEnv_PortletSession_SIGRender_hasGetLastAccessedTimeReturns";
   public final static String               V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETMAXINACTIVEINTERVAL                                        = "V2SigTestsEnv_PortletSession_SIGRender_hasGetMaxInactiveInterval";
   public final static String               V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETMAXINACTIVEINTERVALRETURNS                                 = "V2SigTestsEnv_PortletSession_SIGRender_hasGetMaxInactiveIntervalReturns";
   public final static String               V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETPORTLETCONTEXT                                             = "V2SigTestsEnv_PortletSession_SIGRender_hasGetPortletContext";
   public final static String               V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETPORTLETCONTEXTRETURNS                                      = "V2SigTestsEnv_PortletSession_SIGRender_hasGetPortletContextReturns";
   public final static String               V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASINVALIDATE                                                    = "V2SigTestsEnv_PortletSession_SIGRender_hasInvalidate";
   public final static String               V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASINVALIDATERETURNS                                             = "V2SigTestsEnv_PortletSession_SIGRender_hasInvalidateReturns";
   public final static String               V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASISNEW                                                         = "V2SigTestsEnv_PortletSession_SIGRender_hasIsNew";
   public final static String               V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASISNEWRETURNS                                                  = "V2SigTestsEnv_PortletSession_SIGRender_hasIsNewReturns";
   public final static String               V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASREMOVEATTRIBUTE                                               = "V2SigTestsEnv_PortletSession_SIGRender_hasRemoveAttribute";
   public final static String               V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASREMOVEATTRIBUTEA                                              = "V2SigTestsEnv_PortletSession_SIGRender_hasRemoveAttributeA";
   public final static String               V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASREMOVEATTRIBUTERETURNS                                        = "V2SigTestsEnv_PortletSession_SIGRender_hasRemoveAttributeReturns";
   public final static String               V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASREMOVEATTRIBUTERETURNSA                                       = "V2SigTestsEnv_PortletSession_SIGRender_hasRemoveAttributeReturnsA";
   public final static String               V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASSETATTRIBUTE                                                  = "V2SigTestsEnv_PortletSession_SIGRender_hasSetAttribute";
   public final static String               V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASSETATTRIBUTEA                                                 = "V2SigTestsEnv_PortletSession_SIGRender_hasSetAttributeA";
   public final static String               V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASSETATTRIBUTERETURNS                                           = "V2SigTestsEnv_PortletSession_SIGRender_hasSetAttributeReturns";
   public final static String               V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASSETATTRIBUTERETURNSA                                          = "V2SigTestsEnv_PortletSession_SIGRender_hasSetAttributeReturnsA";
   public final static String               V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASSETMAXINACTIVEINTERVAL                                        = "V2SigTestsEnv_PortletSession_SIGRender_hasSetMaxInactiveInterval";
   public final static String               V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASSETMAXINACTIVEINTERVALRETURNS                                 = "V2SigTestsEnv_PortletSession_SIGRender_hasSetMaxInactiveIntervalReturns";
   public final static String               V2SIGTESTSENV_PORTLETSESSIONUTIL_SIGRENDER_CONSTRUCTOR                                                  = "V2SigTestsEnv_PortletSessionUtil_SIGRender_constructor";
   public final static String               V2SIGTESTSENV_PORTLETSESSIONUTIL_SIGRENDER_HASDECODEATTRIBUTENAME                                       = "V2SigTestsEnv_PortletSessionUtil_SIGRender_hasDecodeAttributeName";
   public final static String               V2SIGTESTSENV_PORTLETSESSIONUTIL_SIGRENDER_HASDECODEATTRIBUTENAMERETURNS                                = "V2SigTestsEnv_PortletSessionUtil_SIGRender_hasDecodeAttributeNameReturns";
   public final static String               V2SIGTESTSENV_PORTLETSESSIONUTIL_SIGRENDER_HASDECODESCOPE                                               = "V2SigTestsEnv_PortletSessionUtil_SIGRender_hasDecodeScope";
   public final static String               V2SIGTESTSENV_PORTLETSESSIONUTIL_SIGRENDER_HASDECODESCOPERETURNS                                        = "V2SigTestsEnv_PortletSessionUtil_SIGRender_hasDecodeScopeReturns";
   public final static String               V2SIGTESTSENV_PORTLETURLGENERATIONLISTENER_SIGRENDER_HASFILTERACTIONURL                                 = "V2SigTestsEnv_PortletURLGenerationListener_SIGRender_hasFilterActionURL";
   public final static String               V2SIGTESTSENV_PORTLETURLGENERATIONLISTENER_SIGRENDER_HASFILTERACTIONURLRETURNS                          = "V2SigTestsEnv_PortletURLGenerationListener_SIGRender_hasFilterActionURLReturns";
   public final static String               V2SIGTESTSENV_PORTLETURLGENERATIONLISTENER_SIGRENDER_HASFILTERRENDERURL                                 = "V2SigTestsEnv_PortletURLGenerationListener_SIGRender_hasFilterRenderURL";
   public final static String               V2SIGTESTSENV_PORTLETURLGENERATIONLISTENER_SIGRENDER_HASFILTERRENDERURLRETURNS                          = "V2SigTestsEnv_PortletURLGenerationListener_SIGRender_hasFilterRenderURLReturns";
   public final static String               V2SIGTESTSENV_PORTLETURLGENERATIONLISTENER_SIGRENDER_HASFILTERRESOURCEURL                               = "V2SigTestsEnv_PortletURLGenerationListener_SIGRender_hasFilterResourceURL";
   public final static String               V2SIGTESTSENV_PORTLETURLGENERATIONLISTENER_SIGRENDER_HASFILTERRESOURCEURLRETURNS                        = "V2SigTestsEnv_PortletURLGenerationListener_SIGRender_hasFilterResourceURLReturns";
   public final static String               V2SIGTESTSENV_PREFERENCESVALIDATOR_SIGRENDER_HASVALIDATE                                                = "V2SigTestsEnv_PreferencesValidator_SIGRender_hasValidate";
   public final static String               V2SIGTESTSENV_PREFERENCESVALIDATOR_SIGRENDER_HASVALIDATERETURNS                                         = "V2SigTestsEnv_PreferencesValidator_SIGRender_hasValidateReturns";
   public final static String               V2SIGTESTSENV_PROCESSACTION_SIGRENDER_HASNAME                                                           = "V2SigTestsEnv_ProcessAction_SIGRender_hasName";
   public final static String               V2SIGTESTSENV_PROCESSACTION_SIGRENDER_HASNAMERETURNS                                                    = "V2SigTestsEnv_ProcessAction_SIGRender_hasNameReturns";
   public final static String               V2SIGTESTSENV_PROCESSACTION_SIGRENDER_ISANNOTATION                                                      = "V2SigTestsEnv_ProcessAction_SIGRender_isAnnotation";
   public final static String               V2SIGTESTSENV_PROCESSEVENT_SIGRENDER_HASNAME                                                            = "V2SigTestsEnv_ProcessEvent_SIGRender_hasName";
   public final static String               V2SIGTESTSENV_PROCESSEVENT_SIGRENDER_HASNAMERETURNS                                                     = "V2SigTestsEnv_ProcessEvent_SIGRender_hasNameReturns";
   public final static String               V2SIGTESTSENV_PROCESSEVENT_SIGRENDER_HASQNAME                                                           = "V2SigTestsEnv_ProcessEvent_SIGRender_hasQname";
   public final static String               V2SIGTESTSENV_PROCESSEVENT_SIGRENDER_HASQNAMERETURNS                                                    = "V2SigTestsEnv_ProcessEvent_SIGRender_hasQnameReturns";
   public final static String               V2SIGTESTSENV_PROCESSEVENT_SIGRENDER_ISANNOTATION                                                       = "V2SigTestsEnv_ProcessEvent_SIGRender_isAnnotation";
   public final static String               V2SIGTESTSENV_RENDERMODE_SIGRENDER_HASNAME                                                              = "V2SigTestsEnv_RenderMode_SIGRender_hasName";
   public final static String               V2SIGTESTSENV_RENDERMODE_SIGRENDER_HASNAMERETURNS                                                       = "V2SigTestsEnv_RenderMode_SIGRender_hasNameReturns";
   public final static String               V2SIGTESTSENV_RENDERMODE_SIGRENDER_ISANNOTATION                                                         = "V2SigTestsEnv_RenderMode_SIGRender_isAnnotation";
   public final static String               V2SIGTESTSENV_RESOURCESERVINGPORTLET_SIGRENDER_HASSERVERESOURCE                                         = "V2SigTestsEnv_ResourceServingPortlet_SIGRender_hasServeResource";
   public final static String               V2SIGTESTSENV_RESOURCESERVINGPORTLET_SIGRENDER_HASSERVERESOURCERETURNS                                  = "V2SigTestsEnv_ResourceServingPortlet_SIGRender_hasServeResourceReturns";
   public final static String               V2SIGTESTSENV_WINDOWSTATE_SIGRENDER_CONSTRUCTOR                                                         = "V2SigTestsEnv_WindowState_SIGRender_constructor";
   public final static String               V2SIGTESTSENV_WINDOWSTATE_SIGRENDER_FIELDMAXIMIZED                                                      = "V2SigTestsEnv_WindowState_SIGRender_fieldMAXIMIZED";
   public final static String               V2SIGTESTSENV_WINDOWSTATE_SIGRENDER_FIELDMINIMIZED                                                      = "V2SigTestsEnv_WindowState_SIGRender_fieldMINIMIZED";
   public final static String               V2SIGTESTSENV_WINDOWSTATE_SIGRENDER_FIELDNORMAL                                                         = "V2SigTestsEnv_WindowState_SIGRender_fieldNORMAL";
   public final static String               V2SIGTESTSENV_WINDOWSTATE_SIGRENDER_HASEQUALS                                                           = "V2SigTestsEnv_WindowState_SIGRender_hasEquals";
   public final static String               V2SIGTESTSENV_WINDOWSTATE_SIGRENDER_HASEQUALSRETURNS                                                    = "V2SigTestsEnv_WindowState_SIGRender_hasEqualsReturns";
   public final static String               V2SIGTESTSENV_WINDOWSTATE_SIGRENDER_HASHASHCODE                                                         = "V2SigTestsEnv_WindowState_SIGRender_hasHashCode";
   public final static String               V2SIGTESTSENV_WINDOWSTATE_SIGRENDER_HASHASHCODERETURNS                                                  = "V2SigTestsEnv_WindowState_SIGRender_hasHashCodeReturns";
   public final static String               V2SIGTESTSENV_WINDOWSTATE_SIGRENDER_HASTOSTRING                                                         = "V2SigTestsEnv_WindowState_SIGRender_hasToString";
   public final static String               V2SIGTESTSENV_WINDOWSTATE_SIGRENDER_HASTOSTRINGRETURNS                                                  = "V2SigTestsEnv_WindowState_SIGRender_hasToStringReturns";
   public final static String               V2SIGTESTSEVENT_EVENT_SIGEVENT_HASGETNAME                                                               = "V2SigTestsEvent_Event_SIGEvent_hasGetName";
   public final static String               V2SIGTESTSEVENT_EVENT_SIGEVENT_HASGETNAMERETURNS                                                        = "V2SigTestsEvent_Event_SIGEvent_hasGetNameReturns";
   public final static String               V2SIGTESTSEVENT_EVENT_SIGEVENT_HASGETQNAME                                                              = "V2SigTestsEvent_Event_SIGEvent_hasGetQName";
   public final static String               V2SIGTESTSEVENT_EVENT_SIGEVENT_HASGETQNAMERETURNS                                                       = "V2SigTestsEvent_Event_SIGEvent_hasGetQNameReturns";
   public final static String               V2SIGTESTSEVENT_EVENT_SIGEVENT_HASGETVALUE                                                              = "V2SigTestsEvent_Event_SIGEvent_hasGetValue";
   public final static String               V2SIGTESTSEVENT_EVENT_SIGEVENT_HASGETVALUERETURNS                                                       = "V2SigTestsEvent_Event_SIGEvent_hasGetValueReturns";
   public final static String               V2SIGTESTSEVENT_EVENTREQUEST_SIGEVENT_HASGETEVENT                                                       = "V2SigTestsEvent_EventRequest_SIGEvent_hasGetEvent";
   public final static String               V2SIGTESTSEVENT_EVENTREQUEST_SIGEVENT_HASGETEVENTRETURNS                                                = "V2SigTestsEvent_EventRequest_SIGEvent_hasGetEventReturns";
   public final static String               V2SIGTESTSEVENT_EVENTREQUEST_SIGEVENT_HASGETMETHOD                                                      = "V2SigTestsEvent_EventRequest_SIGEvent_hasGetMethod";
   public final static String               V2SIGTESTSEVENT_EVENTREQUEST_SIGEVENT_HASGETMETHODRETURNS                                               = "V2SigTestsEvent_EventRequest_SIGEvent_hasGetMethodReturns";
   public final static String               V2SIGTESTSEVENT_EVENTREQUEST_SIGEVENT_IMPLEMENTSPORTLETREQUEST                                          = "V2SigTestsEvent_EventRequest_SIGEvent_implementsPortletRequest";
   public final static String               V2SIGTESTSEVENT_EVENTRESPONSE_SIGEVENT_HASSETRENDERPARAMETERS                                           = "V2SigTestsEvent_EventResponse_SIGEvent_hasSetRenderParameters";
   public final static String               V2SIGTESTSEVENT_EVENTRESPONSE_SIGEVENT_HASSETRENDERPARAMETERSRETURNS                                    = "V2SigTestsEvent_EventResponse_SIGEvent_hasSetRenderParametersReturns";
   public final static String               V2SIGTESTSEVENT_EVENTRESPONSE_SIGEVENT_IMPLEMENTSSTATEAWARERESPONSE                                     = "V2SigTestsEvent_EventResponse_SIGEvent_implementsStateAwareResponse";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_FIELDACTION_PHASE                                               = "V2SigTestsEvent_PortletRequest_SIGEvent_fieldACTION_PHASE";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_FIELDACTION_SCOPE_ID                                            = "V2SigTestsEvent_PortletRequest_SIGEvent_fieldACTION_SCOPE_ID";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_FIELDBASIC_AUTH                                                 = "V2SigTestsEvent_PortletRequest_SIGEvent_fieldBASIC_AUTH";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_FIELDCCPP_PROFILE                                               = "V2SigTestsEvent_PortletRequest_SIGEvent_fieldCCPP_PROFILE";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_FIELDCLIENT_CERT_AUTH                                           = "V2SigTestsEvent_PortletRequest_SIGEvent_fieldCLIENT_CERT_AUTH";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_FIELDDIGEST_AUTH                                                = "V2SigTestsEvent_PortletRequest_SIGEvent_fieldDIGEST_AUTH";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_FIELDEVENT_PHASE                                                = "V2SigTestsEvent_PortletRequest_SIGEvent_fieldEVENT_PHASE";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_FIELDFORM_AUTH                                                  = "V2SigTestsEvent_PortletRequest_SIGEvent_fieldFORM_AUTH";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_FIELDLIFECYCLE_PHASE                                            = "V2SigTestsEvent_PortletRequest_SIGEvent_fieldLIFECYCLE_PHASE";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_FIELDRENDER_HEADERS                                             = "V2SigTestsEvent_PortletRequest_SIGEvent_fieldRENDER_HEADERS";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_FIELDRENDER_MARKUP                                              = "V2SigTestsEvent_PortletRequest_SIGEvent_fieldRENDER_MARKUP";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_FIELDRENDER_PART                                                = "V2SigTestsEvent_PortletRequest_SIGEvent_fieldRENDER_PART";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_FIELDRENDER_PHASE                                               = "V2SigTestsEvent_PortletRequest_SIGEvent_fieldRENDER_PHASE";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_FIELDRESOURCE_PHASE                                             = "V2SigTestsEvent_PortletRequest_SIGEvent_fieldRESOURCE_PHASE";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_FIELDUSER_INFO                                                  = "V2SigTestsEvent_PortletRequest_SIGEvent_fieldUSER_INFO";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETATTRIBUTE                                                 = "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetAttribute";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETATTRIBUTENAMES                                            = "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetAttributeNames";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETATTRIBUTENAMESRETURNS                                     = "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetAttributeNamesReturns";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETATTRIBUTERETURNS                                          = "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetAttributeReturns";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETAUTHTYPE                                                  = "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetAuthType";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETAUTHTYPERETURNS                                           = "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetAuthTypeReturns";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETCONTEXTPATH                                               = "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetContextPath";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETCONTEXTPATHRETURNS                                        = "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetContextPathReturns";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETCOOKIES                                                   = "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetCookies";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETCOOKIESRETURNS                                            = "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetCookiesReturns";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETLOCALE                                                    = "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetLocale";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETLOCALERETURNS                                             = "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetLocaleReturns";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETLOCALES                                                   = "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetLocales";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETLOCALESRETURNS                                            = "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetLocalesReturns";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPARAMETER                                                 = "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetParameter";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPARAMETERMAP                                              = "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetParameterMap";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPARAMETERMAPRETURNS                                       = "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetParameterMapReturns";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPARAMETERNAMES                                            = "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetParameterNames";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPARAMETERNAMESRETURNS                                     = "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetParameterNamesReturns";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPARAMETERRETURNS                                          = "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetParameterReturns";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPARAMETERVALUES                                           = "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetParameterValues";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPARAMETERVALUESRETURNS                                    = "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetParameterValuesReturns";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPORTALCONTEXT                                             = "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPortalContext";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPORTALCONTEXTRETURNS                                      = "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPortalContextReturns";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPORTLETMODE                                               = "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPortletMode";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPORTLETMODERETURNS                                        = "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPortletModeReturns";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPORTLETSESSION                                            = "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPortletSession";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPORTLETSESSIONA                                           = "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPortletSessionA";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPORTLETSESSIONRETURNS                                     = "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPortletSessionReturns";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPORTLETSESSIONRETURNSA                                    = "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPortletSessionReturnsA";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPREFERENCES                                               = "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPreferences";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPREFERENCESRETURNS                                        = "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPreferencesReturns";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPRIVATEPARAMETERMAP                                       = "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPrivateParameterMap";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPRIVATEPARAMETERMAPRETURNS                                = "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPrivateParameterMapReturns";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPROPERTIES                                                = "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetProperties";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPROPERTIESRETURNS                                         = "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPropertiesReturns";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPROPERTY                                                  = "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetProperty";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPROPERTYNAMES                                             = "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPropertyNames";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPROPERTYNAMESRETURNS                                      = "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPropertyNamesReturns";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPROPERTYRETURNS                                           = "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPropertyReturns";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPUBLICPARAMETERMAP                                        = "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPublicParameterMap";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPUBLICPARAMETERMAPRETURNS                                 = "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPublicParameterMapReturns";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETREMOTEUSER                                                = "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetRemoteUser";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETREMOTEUSERRETURNS                                         = "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetRemoteUserReturns";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETREQUESTEDSESSIONID                                        = "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetRequestedSessionId";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETREQUESTEDSESSIONIDRETURNS                                 = "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetRequestedSessionIdReturns";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETRESPONSECONTENTTYPE                                       = "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetResponseContentType";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETRESPONSECONTENTTYPERETURNS                                = "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetResponseContentTypeReturns";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETRESPONSECONTENTTYPES                                      = "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetResponseContentTypes";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETRESPONSECONTENTTYPESRETURNS                               = "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetResponseContentTypesReturns";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETSCHEME                                                    = "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetScheme";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETSCHEMERETURNS                                             = "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetSchemeReturns";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETSERVERNAME                                                = "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetServerName";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETSERVERNAMERETURNS                                         = "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetServerNameReturns";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETSERVERPORT                                                = "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetServerPort";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETSERVERPORTRETURNS                                         = "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetServerPortReturns";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETUSERPRINCIPAL                                             = "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetUserPrincipal";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETUSERPRINCIPALRETURNS                                      = "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetUserPrincipalReturns";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETWINDOWID                                                  = "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetWindowID";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETWINDOWIDRETURNS                                           = "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetWindowIDReturns";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETWINDOWSTATE                                               = "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetWindowState";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETWINDOWSTATERETURNS                                        = "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetWindowStateReturns";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASISPORTLETMODEALLOWED                                         = "V2SigTestsEvent_PortletRequest_SIGEvent_hasIsPortletModeAllowed";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASISPORTLETMODEALLOWEDRETURNS                                  = "V2SigTestsEvent_PortletRequest_SIGEvent_hasIsPortletModeAllowedReturns";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASISREQUESTEDSESSIONIDVALID                                    = "V2SigTestsEvent_PortletRequest_SIGEvent_hasIsRequestedSessionIdValid";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASISREQUESTEDSESSIONIDVALIDRETURNS                             = "V2SigTestsEvent_PortletRequest_SIGEvent_hasIsRequestedSessionIdValidReturns";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASISSECURE                                                     = "V2SigTestsEvent_PortletRequest_SIGEvent_hasIsSecure";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASISSECURERETURNS                                              = "V2SigTestsEvent_PortletRequest_SIGEvent_hasIsSecureReturns";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASISUSERINROLE                                                 = "V2SigTestsEvent_PortletRequest_SIGEvent_hasIsUserInRole";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASISUSERINROLERETURNS                                          = "V2SigTestsEvent_PortletRequest_SIGEvent_hasIsUserInRoleReturns";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASISWINDOWSTATEALLOWED                                         = "V2SigTestsEvent_PortletRequest_SIGEvent_hasIsWindowStateAllowed";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASISWINDOWSTATEALLOWEDRETURNS                                  = "V2SigTestsEvent_PortletRequest_SIGEvent_hasIsWindowStateAllowedReturns";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASREMOVEATTRIBUTE                                              = "V2SigTestsEvent_PortletRequest_SIGEvent_hasRemoveAttribute";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASREMOVEATTRIBUTERETURNS                                       = "V2SigTestsEvent_PortletRequest_SIGEvent_hasRemoveAttributeReturns";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASSETATTRIBUTE                                                 = "V2SigTestsEvent_PortletRequest_SIGEvent_hasSetAttribute";
   public final static String               V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASSETATTRIBUTERETURNS                                          = "V2SigTestsEvent_PortletRequest_SIGEvent_hasSetAttributeReturns";
   public final static String               V2SIGTESTSEVENT_PORTLETRESPONSE_SIGEVENT_HASADDPROPERTY                                                 = "V2SigTestsEvent_PortletResponse_SIGEvent_hasAddProperty";
   public final static String               V2SIGTESTSEVENT_PORTLETRESPONSE_SIGEVENT_HASADDPROPERTYA                                                = "V2SigTestsEvent_PortletResponse_SIGEvent_hasAddPropertyA";
   public final static String               V2SIGTESTSEVENT_PORTLETRESPONSE_SIGEVENT_HASADDPROPERTYB                                                = "V2SigTestsEvent_PortletResponse_SIGEvent_hasAddPropertyB";
   public final static String               V2SIGTESTSEVENT_PORTLETRESPONSE_SIGEVENT_HASADDPROPERTYRETURNS                                          = "V2SigTestsEvent_PortletResponse_SIGEvent_hasAddPropertyReturns";
   public final static String               V2SIGTESTSEVENT_PORTLETRESPONSE_SIGEVENT_HASADDPROPERTYRETURNSA                                         = "V2SigTestsEvent_PortletResponse_SIGEvent_hasAddPropertyReturnsA";
   public final static String               V2SIGTESTSEVENT_PORTLETRESPONSE_SIGEVENT_HASADDPROPERTYRETURNSB                                         = "V2SigTestsEvent_PortletResponse_SIGEvent_hasAddPropertyReturnsB";
   public final static String               V2SIGTESTSEVENT_PORTLETRESPONSE_SIGEVENT_HASCREATEELEMENT                                               = "V2SigTestsEvent_PortletResponse_SIGEvent_hasCreateElement";
   public final static String               V2SIGTESTSEVENT_PORTLETRESPONSE_SIGEVENT_HASCREATEELEMENTRETURNS                                        = "V2SigTestsEvent_PortletResponse_SIGEvent_hasCreateElementReturns";
   public final static String               V2SIGTESTSEVENT_PORTLETRESPONSE_SIGEVENT_HASENCODEURL                                                   = "V2SigTestsEvent_PortletResponse_SIGEvent_hasEncodeURL";
   public final static String               V2SIGTESTSEVENT_PORTLETRESPONSE_SIGEVENT_HASENCODEURLRETURNS                                            = "V2SigTestsEvent_PortletResponse_SIGEvent_hasEncodeURLReturns";
   public final static String               V2SIGTESTSEVENT_PORTLETRESPONSE_SIGEVENT_HASGETNAMESPACE                                                = "V2SigTestsEvent_PortletResponse_SIGEvent_hasGetNamespace";
   public final static String               V2SIGTESTSEVENT_PORTLETRESPONSE_SIGEVENT_HASGETNAMESPACERETURNS                                         = "V2SigTestsEvent_PortletResponse_SIGEvent_hasGetNamespaceReturns";
   public final static String               V2SIGTESTSEVENT_PORTLETRESPONSE_SIGEVENT_HASSETPROPERTY                                                 = "V2SigTestsEvent_PortletResponse_SIGEvent_hasSetProperty";
   public final static String               V2SIGTESTSEVENT_PORTLETRESPONSE_SIGEVENT_HASSETPROPERTYRETURNS                                          = "V2SigTestsEvent_PortletResponse_SIGEvent_hasSetPropertyReturns";
   public final static String               V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASGETPORTLETMODE                                           = "V2SigTestsEvent_StateAwareResponse_SIGEvent_hasGetPortletMode";
   public final static String               V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASGETPORTLETMODERETURNS                                    = "V2SigTestsEvent_StateAwareResponse_SIGEvent_hasGetPortletModeReturns";
   public final static String               V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASGETRENDERPARAMETERMAP                                    = "V2SigTestsEvent_StateAwareResponse_SIGEvent_hasGetRenderParameterMap";
   public final static String               V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASGETRENDERPARAMETERMAPRETURNS                             = "V2SigTestsEvent_StateAwareResponse_SIGEvent_hasGetRenderParameterMapReturns";
   public final static String               V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASGETWINDOWSTATE                                           = "V2SigTestsEvent_StateAwareResponse_SIGEvent_hasGetWindowState";
   public final static String               V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASGETWINDOWSTATERETURNS                                    = "V2SigTestsEvent_StateAwareResponse_SIGEvent_hasGetWindowStateReturns";
   public final static String               V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASREMOVEPUBLICRENDERPARAMETER                              = "V2SigTestsEvent_StateAwareResponse_SIGEvent_hasRemovePublicRenderParameter";
   public final static String               V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASREMOVEPUBLICRENDERPARAMETERRETURNS                       = "V2SigTestsEvent_StateAwareResponse_SIGEvent_hasRemovePublicRenderParameterReturns";
   public final static String               V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASSETEVENT                                                 = "V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetEvent";
   public final static String               V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASSETEVENTA                                                = "V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetEventA";
   public final static String               V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASSETEVENTRETURNS                                          = "V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetEventReturns";
   public final static String               V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASSETEVENTRETURNSA                                         = "V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetEventReturnsA";
   public final static String               V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASSETPORTLETMODE                                           = "V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetPortletMode";
   public final static String               V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASSETPORTLETMODERETURNS                                    = "V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetPortletModeReturns";
   public final static String               V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASSETRENDERPARAMETER                                       = "V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetRenderParameter";
   public final static String               V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASSETRENDERPARAMETERA                                      = "V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetRenderParameterA";
   public final static String               V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASSETRENDERPARAMETERRETURNS                                = "V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetRenderParameterReturns";
   public final static String               V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASSETRENDERPARAMETERRETURNSA                               = "V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetRenderParameterReturnsA";
   public final static String               V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASSETRENDERPARAMETERS                                      = "V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetRenderParameters";
   public final static String               V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASSETRENDERPARAMETERSRETURNS                               = "V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetRenderParametersReturns";
   public final static String               V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASSETWINDOWSTATE                                           = "V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetWindowState";
   public final static String               V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASSETWINDOWSTATERETURNS                                    = "V2SigTestsEvent_StateAwareResponse_SIGEvent_hasSetWindowStateReturns";
   public final static String               V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_IMPLEMENTSPORTLETRESPONSE                                   = "V2SigTestsEvent_StateAwareResponse_SIGEvent_implementsPortletResponse";
   public final static String               V2SIGTESTSEXCEPTION_PORTLETEXCEPTION_SIGRENDER_CONSTRUCTOR                                              = "V2SigTestsException_PortletException_SIGRender_constructor";
   public final static String               V2SIGTESTSEXCEPTION_PORTLETEXCEPTION_SIGRENDER_CONSTRUCTORA                                             = "V2SigTestsException_PortletException_SIGRender_constructorA";
   public final static String               V2SIGTESTSEXCEPTION_PORTLETEXCEPTION_SIGRENDER_CONSTRUCTORB                                             = "V2SigTestsException_PortletException_SIGRender_constructorB";
   public final static String               V2SIGTESTSEXCEPTION_PORTLETEXCEPTION_SIGRENDER_CONSTRUCTORC                                             = "V2SigTestsException_PortletException_SIGRender_constructorC";
   public final static String               V2SIGTESTSEXCEPTION_PORTLETEXCEPTION_SIGRENDER_EXTENDSEXCEPTION                                         = "V2SigTestsException_PortletException_SIGRender_extendsException";
   public final static String               V2SIGTESTSEXCEPTION_PORTLETMODEEXCEPTION_SIGRENDER_CONSTRUCTOR                                          = "V2SigTestsException_PortletModeException_SIGRender_constructor";
   public final static String               V2SIGTESTSEXCEPTION_PORTLETMODEEXCEPTION_SIGRENDER_CONSTRUCTORA                                         = "V2SigTestsException_PortletModeException_SIGRender_constructorA";
   public final static String               V2SIGTESTSEXCEPTION_PORTLETMODEEXCEPTION_SIGRENDER_CONSTRUCTORB                                         = "V2SigTestsException_PortletModeException_SIGRender_constructorB";
   public final static String               V2SIGTESTSEXCEPTION_PORTLETMODEEXCEPTION_SIGRENDER_EXTENDSPORTLETEXCEPTION                              = "V2SigTestsException_PortletModeException_SIGRender_extendsPortletException";
   public final static String               V2SIGTESTSEXCEPTION_PORTLETMODEEXCEPTION_SIGRENDER_HASGETMODE                                           = "V2SigTestsException_PortletModeException_SIGRender_hasGetMode";
   public final static String               V2SIGTESTSEXCEPTION_PORTLETMODEEXCEPTION_SIGRENDER_HASGETMODERETURNS                                    = "V2SigTestsException_PortletModeException_SIGRender_hasGetModeReturns";
   public final static String               V2SIGTESTSEXCEPTION_PORTLETSECURITYEXCEPTION_SIGRENDER_CONSTRUCTOR                                      = "V2SigTestsException_PortletSecurityException_SIGRender_constructor";
   public final static String               V2SIGTESTSEXCEPTION_PORTLETSECURITYEXCEPTION_SIGRENDER_CONSTRUCTORA                                     = "V2SigTestsException_PortletSecurityException_SIGRender_constructorA";
   public final static String               V2SIGTESTSEXCEPTION_PORTLETSECURITYEXCEPTION_SIGRENDER_CONSTRUCTORB                                     = "V2SigTestsException_PortletSecurityException_SIGRender_constructorB";
   public final static String               V2SIGTESTSEXCEPTION_PORTLETSECURITYEXCEPTION_SIGRENDER_EXTENDSPORTLETEXCEPTION                          = "V2SigTestsException_PortletSecurityException_SIGRender_extendsPortletException";
   public final static String               V2SIGTESTSEXCEPTION_READONLYEXCEPTION_SIGRENDER_CONSTRUCTOR                                             = "V2SigTestsException_ReadOnlyException_SIGRender_constructor";
   public final static String               V2SIGTESTSEXCEPTION_READONLYEXCEPTION_SIGRENDER_CONSTRUCTORA                                            = "V2SigTestsException_ReadOnlyException_SIGRender_constructorA";
   public final static String               V2SIGTESTSEXCEPTION_READONLYEXCEPTION_SIGRENDER_CONSTRUCTORB                                            = "V2SigTestsException_ReadOnlyException_SIGRender_constructorB";
   public final static String               V2SIGTESTSEXCEPTION_READONLYEXCEPTION_SIGRENDER_EXTENDSPORTLETEXCEPTION                                 = "V2SigTestsException_ReadOnlyException_SIGRender_extendsPortletException";
   public final static String               V2SIGTESTSEXCEPTION_UNAVAILABLEEXCEPTION_SIGRENDER_CONSTRUCTOR                                          = "V2SigTestsException_UnavailableException_SIGRender_constructor";
   public final static String               V2SIGTESTSEXCEPTION_UNAVAILABLEEXCEPTION_SIGRENDER_CONSTRUCTORA                                         = "V2SigTestsException_UnavailableException_SIGRender_constructorA";
   public final static String               V2SIGTESTSEXCEPTION_UNAVAILABLEEXCEPTION_SIGRENDER_EXTENDSPORTLETEXCEPTION                              = "V2SigTestsException_UnavailableException_SIGRender_extendsPortletException";
   public final static String               V2SIGTESTSEXCEPTION_UNAVAILABLEEXCEPTION_SIGRENDER_HASGETUNAVAILABLESECONDS                             = "V2SigTestsException_UnavailableException_SIGRender_hasGetUnavailableSeconds";
   public final static String               V2SIGTESTSEXCEPTION_UNAVAILABLEEXCEPTION_SIGRENDER_HASGETUNAVAILABLESECONDSRETURNS                      = "V2SigTestsException_UnavailableException_SIGRender_hasGetUnavailableSecondsReturns";
   public final static String               V2SIGTESTSEXCEPTION_UNAVAILABLEEXCEPTION_SIGRENDER_HASISPERMANENT                                       = "V2SigTestsException_UnavailableException_SIGRender_hasIsPermanent";
   public final static String               V2SIGTESTSEXCEPTION_UNAVAILABLEEXCEPTION_SIGRENDER_HASISPERMANENTRETURNS                                = "V2SigTestsException_UnavailableException_SIGRender_hasIsPermanentReturns";
   public final static String               V2SIGTESTSEXCEPTION_VALIDATOREXCEPTION_SIGRENDER_CONSTRUCTOR                                            = "V2SigTestsException_ValidatorException_SIGRender_constructor";
   public final static String               V2SIGTESTSEXCEPTION_VALIDATOREXCEPTION_SIGRENDER_CONSTRUCTORA                                           = "V2SigTestsException_ValidatorException_SIGRender_constructorA";
   public final static String               V2SIGTESTSEXCEPTION_VALIDATOREXCEPTION_SIGRENDER_CONSTRUCTORB                                           = "V2SigTestsException_ValidatorException_SIGRender_constructorB";
   public final static String               V2SIGTESTSEXCEPTION_VALIDATOREXCEPTION_SIGRENDER_EXTENDSPORTLETEXCEPTION                                = "V2SigTestsException_ValidatorException_SIGRender_extendsPortletException";
   public final static String               V2SIGTESTSEXCEPTION_VALIDATOREXCEPTION_SIGRENDER_HASGETFAILEDKEYS                                       = "V2SigTestsException_ValidatorException_SIGRender_hasGetFailedKeys";
   public final static String               V2SIGTESTSEXCEPTION_VALIDATOREXCEPTION_SIGRENDER_HASGETFAILEDKEYSRETURNS                                = "V2SigTestsException_ValidatorException_SIGRender_hasGetFailedKeysReturns";
   public final static String               V2SIGTESTSEXCEPTION_WINDOWSTATEEXCEPTION_SIGRENDER_CONSTRUCTOR                                          = "V2SigTestsException_WindowStateException_SIGRender_constructor";
   public final static String               V2SIGTESTSEXCEPTION_WINDOWSTATEEXCEPTION_SIGRENDER_CONSTRUCTORA                                         = "V2SigTestsException_WindowStateException_SIGRender_constructorA";
   public final static String               V2SIGTESTSEXCEPTION_WINDOWSTATEEXCEPTION_SIGRENDER_CONSTRUCTORB                                         = "V2SigTestsException_WindowStateException_SIGRender_constructorB";
   public final static String               V2SIGTESTSEXCEPTION_WINDOWSTATEEXCEPTION_SIGRENDER_EXTENDSPORTLETEXCEPTION                              = "V2SigTestsException_WindowStateException_SIGRender_extendsPortletException";
   public final static String               V2SIGTESTSEXCEPTION_WINDOWSTATEEXCEPTION_SIGRENDER_HASGETSTATE                                          = "V2SigTestsException_WindowStateException_SIGRender_hasGetState";
   public final static String               V2SIGTESTSEXCEPTION_WINDOWSTATEEXCEPTION_SIGRENDER_HASGETSTATERETURNS                                   = "V2SigTestsException_WindowStateException_SIGRender_hasGetStateReturns";
   public final static String               V2SIGTESTSFILTER_ACTIONFILTER_SIGRENDER_HASDOFILTER                                                     = "V2SigTestsFilter_ActionFilter_SIGRender_hasDoFilter";
   public final static String               V2SIGTESTSFILTER_ACTIONFILTER_SIGRENDER_HASDOFILTERRETURNS                                              = "V2SigTestsFilter_ActionFilter_SIGRender_hasDoFilterReturns";
   public final static String               V2SIGTESTSFILTER_ACTIONFILTER_SIGRENDER_IMPLEMENTSPORTLETFILTER                                         = "V2SigTestsFilter_ActionFilter_SIGRender_implementsPortletFilter";
   public final static String               V2SIGTESTSFILTER_EVENTFILTER_SIGRENDER_HASDOFILTER                                                      = "V2SigTestsFilter_EventFilter_SIGRender_hasDoFilter";
   public final static String               V2SIGTESTSFILTER_EVENTFILTER_SIGRENDER_HASDOFILTERRETURNS                                               = "V2SigTestsFilter_EventFilter_SIGRender_hasDoFilterReturns";
   public final static String               V2SIGTESTSFILTER_EVENTFILTER_SIGRENDER_IMPLEMENTSPORTLETFILTER                                          = "V2SigTestsFilter_EventFilter_SIGRender_implementsPortletFilter";
   public final static String               V2SIGTESTSFILTER_FILTERCHAIN_SIGRENDER_HASDOFILTER                                                      = "V2SigTestsFilter_FilterChain_SIGRender_hasDoFilter";
   public final static String               V2SIGTESTSFILTER_FILTERCHAIN_SIGRENDER_HASDOFILTERA                                                     = "V2SigTestsFilter_FilterChain_SIGRender_hasDoFilterA";
   public final static String               V2SIGTESTSFILTER_FILTERCHAIN_SIGRENDER_HASDOFILTERB                                                     = "V2SigTestsFilter_FilterChain_SIGRender_hasDoFilterB";
   public final static String               V2SIGTESTSFILTER_FILTERCHAIN_SIGRENDER_HASDOFILTERC                                                     = "V2SigTestsFilter_FilterChain_SIGRender_hasDoFilterC";
   public final static String               V2SIGTESTSFILTER_FILTERCHAIN_SIGRENDER_HASDOFILTERRETURNS                                               = "V2SigTestsFilter_FilterChain_SIGRender_hasDoFilterReturns";
   public final static String               V2SIGTESTSFILTER_FILTERCHAIN_SIGRENDER_HASDOFILTERRETURNSA                                              = "V2SigTestsFilter_FilterChain_SIGRender_hasDoFilterReturnsA";
   public final static String               V2SIGTESTSFILTER_FILTERCHAIN_SIGRENDER_HASDOFILTERRETURNSB                                              = "V2SigTestsFilter_FilterChain_SIGRender_hasDoFilterReturnsB";
   public final static String               V2SIGTESTSFILTER_FILTERCHAIN_SIGRENDER_HASDOFILTERRETURNSC                                              = "V2SigTestsFilter_FilterChain_SIGRender_hasDoFilterReturnsC";
   public final static String               V2SIGTESTSFILTER_FILTERCONFIG_SIGRENDER_HASGETFILTERNAME                                                = "V2SigTestsFilter_FilterConfig_SIGRender_hasGetFilterName";
   public final static String               V2SIGTESTSFILTER_FILTERCONFIG_SIGRENDER_HASGETFILTERNAMERETURNS                                         = "V2SigTestsFilter_FilterConfig_SIGRender_hasGetFilterNameReturns";
   public final static String               V2SIGTESTSFILTER_FILTERCONFIG_SIGRENDER_HASGETINITPARAMETER                                             = "V2SigTestsFilter_FilterConfig_SIGRender_hasGetInitParameter";
   public final static String               V2SIGTESTSFILTER_FILTERCONFIG_SIGRENDER_HASGETINITPARAMETERNAMES                                        = "V2SigTestsFilter_FilterConfig_SIGRender_hasGetInitParameterNames";
   public final static String               V2SIGTESTSFILTER_FILTERCONFIG_SIGRENDER_HASGETINITPARAMETERNAMESRETURNS                                 = "V2SigTestsFilter_FilterConfig_SIGRender_hasGetInitParameterNamesReturns";
   public final static String               V2SIGTESTSFILTER_FILTERCONFIG_SIGRENDER_HASGETINITPARAMETERRETURNS                                      = "V2SigTestsFilter_FilterConfig_SIGRender_hasGetInitParameterReturns";
   public final static String               V2SIGTESTSFILTER_FILTERCONFIG_SIGRENDER_HASGETPORTLETCONTEXT                                            = "V2SigTestsFilter_FilterConfig_SIGRender_hasGetPortletContext";
   public final static String               V2SIGTESTSFILTER_FILTERCONFIG_SIGRENDER_HASGETPORTLETCONTEXTRETURNS                                     = "V2SigTestsFilter_FilterConfig_SIGRender_hasGetPortletContextReturns";
   public final static String               V2SIGTESTSFILTER_PORTLETFILTER_SIGRENDER_HASDESTROY                                                     = "V2SigTestsFilter_PortletFilter_SIGRender_hasDestroy";
   public final static String               V2SIGTESTSFILTER_PORTLETFILTER_SIGRENDER_HASDESTROYRETURNS                                              = "V2SigTestsFilter_PortletFilter_SIGRender_hasDestroyReturns";
   public final static String               V2SIGTESTSFILTER_PORTLETFILTER_SIGRENDER_HASINIT                                                        = "V2SigTestsFilter_PortletFilter_SIGRender_hasInit";
   public final static String               V2SIGTESTSFILTER_PORTLETFILTER_SIGRENDER_HASINITRETURNS                                                 = "V2SigTestsFilter_PortletFilter_SIGRender_hasInitReturns";
   public final static String               V2SIGTESTSFILTER_RENDERFILTER_SIGRENDER_HASDOFILTER                                                     = "V2SigTestsFilter_RenderFilter_SIGRender_hasDoFilter";
   public final static String               V2SIGTESTSFILTER_RENDERFILTER_SIGRENDER_HASDOFILTERRETURNS                                              = "V2SigTestsFilter_RenderFilter_SIGRender_hasDoFilterReturns";
   public final static String               V2SIGTESTSFILTER_RENDERFILTER_SIGRENDER_IMPLEMENTSPORTLETFILTER                                         = "V2SigTestsFilter_RenderFilter_SIGRender_implementsPortletFilter";
   public final static String               V2SIGTESTSFILTER_RESOURCEFILTER_SIGRENDER_HASDOFILTER                                                   = "V2SigTestsFilter_ResourceFilter_SIGRender_hasDoFilter";
   public final static String               V2SIGTESTSFILTER_RESOURCEFILTER_SIGRENDER_HASDOFILTERRETURNS                                            = "V2SigTestsFilter_ResourceFilter_SIGRender_hasDoFilterReturns";
   public final static String               V2SIGTESTSFILTER_RESOURCEFILTER_SIGRENDER_IMPLEMENTSPORTLETFILTER                                       = "V2SigTestsFilter_ResourceFilter_SIGRender_implementsPortletFilter";
   public final static String               V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_FIELDCACHE_SCOPE                                                = "V2SigTestsRender_MimeResponse_SIGRender_fieldCACHE_SCOPE";
   public final static String               V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_FIELDETAG                                                       = "V2SigTestsRender_MimeResponse_SIGRender_fieldETAG";
   public final static String               V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_FIELDEXPIRATION_CACHE                                           = "V2SigTestsRender_MimeResponse_SIGRender_fieldEXPIRATION_CACHE";
   public final static String               V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_FIELDMARKUP_HEAD_ELEMENT                                        = "V2SigTestsRender_MimeResponse_SIGRender_fieldMARKUP_HEAD_ELEMENT";
   public final static String               V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_FIELDNAMESPACED_RESPONSE                                        = "V2SigTestsRender_MimeResponse_SIGRender_fieldNAMESPACED_RESPONSE";
   public final static String               V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_FIELDPRIVATE_SCOPE                                              = "V2SigTestsRender_MimeResponse_SIGRender_fieldPRIVATE_SCOPE";
   public final static String               V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_FIELDPUBLIC_SCOPE                                               = "V2SigTestsRender_MimeResponse_SIGRender_fieldPUBLIC_SCOPE";
   public final static String               V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_FIELDUSE_CACHED_CONTENT                                         = "V2SigTestsRender_MimeResponse_SIGRender_fieldUSE_CACHED_CONTENT";
   public final static String               V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASCREATEACTIONURL                                              = "V2SigTestsRender_MimeResponse_SIGRender_hasCreateActionURL";
   public final static String               V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASCREATEACTIONURLRETURNS                                       = "V2SigTestsRender_MimeResponse_SIGRender_hasCreateActionURLReturns";
   public final static String               V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASCREATERENDERURL                                              = "V2SigTestsRender_MimeResponse_SIGRender_hasCreateRenderURL";
   public final static String               V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASCREATERENDERURLRETURNS                                       = "V2SigTestsRender_MimeResponse_SIGRender_hasCreateRenderURLReturns";
   public final static String               V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASCREATERESOURCEURL                                            = "V2SigTestsRender_MimeResponse_SIGRender_hasCreateResourceURL";
   public final static String               V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASCREATERESOURCEURLRETURNS                                     = "V2SigTestsRender_MimeResponse_SIGRender_hasCreateResourceURLReturns";
   public final static String               V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASFLUSHBUFFER                                                  = "V2SigTestsRender_MimeResponse_SIGRender_hasFlushBuffer";
   public final static String               V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASFLUSHBUFFERRETURNS                                           = "V2SigTestsRender_MimeResponse_SIGRender_hasFlushBufferReturns";
   public final static String               V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASGETBUFFERSIZE                                                = "V2SigTestsRender_MimeResponse_SIGRender_hasGetBufferSize";
   public final static String               V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASGETBUFFERSIZERETURNS                                         = "V2SigTestsRender_MimeResponse_SIGRender_hasGetBufferSizeReturns";
   public final static String               V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASGETCACHECONTROL                                              = "V2SigTestsRender_MimeResponse_SIGRender_hasGetCacheControl";
   public final static String               V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASGETCACHECONTROLRETURNS                                       = "V2SigTestsRender_MimeResponse_SIGRender_hasGetCacheControlReturns";
   public final static String               V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASGETCHARACTERENCODING                                         = "V2SigTestsRender_MimeResponse_SIGRender_hasGetCharacterEncoding";
   public final static String               V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASGETCHARACTERENCODINGRETURNS                                  = "V2SigTestsRender_MimeResponse_SIGRender_hasGetCharacterEncodingReturns";
   public final static String               V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASGETCONTENTTYPE                                               = "V2SigTestsRender_MimeResponse_SIGRender_hasGetContentType";
   public final static String               V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASGETCONTENTTYPERETURNS                                        = "V2SigTestsRender_MimeResponse_SIGRender_hasGetContentTypeReturns";
   public final static String               V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASGETLOCALE                                                    = "V2SigTestsRender_MimeResponse_SIGRender_hasGetLocale";
   public final static String               V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASGETLOCALERETURNS                                             = "V2SigTestsRender_MimeResponse_SIGRender_hasGetLocaleReturns";
   public final static String               V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASGETPORTLETOUTPUTSTREAM                                       = "V2SigTestsRender_MimeResponse_SIGRender_hasGetPortletOutputStream";
   public final static String               V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASGETPORTLETOUTPUTSTREAMRETURNS                                = "V2SigTestsRender_MimeResponse_SIGRender_hasGetPortletOutputStreamReturns";
   public final static String               V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASGETWRITER                                                    = "V2SigTestsRender_MimeResponse_SIGRender_hasGetWriter";
   public final static String               V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASGETWRITERRETURNS                                             = "V2SigTestsRender_MimeResponse_SIGRender_hasGetWriterReturns";
   public final static String               V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASISCOMMITTED                                                  = "V2SigTestsRender_MimeResponse_SIGRender_hasIsCommitted";
   public final static String               V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASISCOMMITTEDRETURNS                                           = "V2SigTestsRender_MimeResponse_SIGRender_hasIsCommittedReturns";
   public final static String               V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASRESET                                                        = "V2SigTestsRender_MimeResponse_SIGRender_hasReset";
   public final static String               V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASRESETBUFFER                                                  = "V2SigTestsRender_MimeResponse_SIGRender_hasResetBuffer";
   public final static String               V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASRESETBUFFERRETURNS                                           = "V2SigTestsRender_MimeResponse_SIGRender_hasResetBufferReturns";
   public final static String               V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASRESETRETURNS                                                 = "V2SigTestsRender_MimeResponse_SIGRender_hasResetReturns";
   public final static String               V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASSETBUFFERSIZE                                                = "V2SigTestsRender_MimeResponse_SIGRender_hasSetBufferSize";
   public final static String               V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASSETBUFFERSIZERETURNS                                         = "V2SigTestsRender_MimeResponse_SIGRender_hasSetBufferSizeReturns";
   public final static String               V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASSETCONTENTTYPE                                               = "V2SigTestsRender_MimeResponse_SIGRender_hasSetContentType";
   public final static String               V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASSETCONTENTTYPERETURNS                                        = "V2SigTestsRender_MimeResponse_SIGRender_hasSetContentTypeReturns";
   public final static String               V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_IMPLEMENTSPORTLETRESPONSE                                       = "V2SigTestsRender_MimeResponse_SIGRender_implementsPortletResponse";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BDATE_FRACTIONSECOND                   = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BDATE_FRACTIONSECOND";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BDATE_HMS_HOUR                         = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BDATE_HMS_HOUR";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BDATE_HMS_MINUTE                       = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BDATE_HMS_MINUTE";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BDATE_HMS_SECOND                       = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BDATE_HMS_SECOND";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BDATE_TIMEZONE                         = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BDATE_TIMEZONE";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BDATE_YMD_DAY                          = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BDATE_YMD_DAY";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BDATE_YMD_MONTH                        = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BDATE_YMD_MONTH";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BDATE_YMD_YEAR                         = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BDATE_YMD_YEAR";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_ONLINE_EMAIL              = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BUSINESSINFO_ONLINE_EMAIL";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_ONLINE_URI                = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BUSINESSINFO_ONLINE_URI";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_POSTAL_CITY               = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BUSINESSINFO_POSTAL_CITY";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_POSTAL_COUNTRY            = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BUSINESSINFO_POSTAL_COUNTRY";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_POSTAL_NAME               = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BUSINESSINFO_POSTAL_NAME";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_POSTAL_ORGANIZATION       = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BUSINESSINFO_POSTAL_ORGANIZATION";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_POSTAL_POSTALCODE         = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BUSINESSINFO_POSTAL_POSTALCODE";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_POSTAL_STATEPROV          = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BUSINESSINFO_POSTAL_STATEPROV";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_POSTAL_STREET             = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BUSINESSINFO_POSTAL_STREET";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_FAX_COMMENT       = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BUSINESSINFO_TELECOM_FAX_COMMENT";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_FAX_EXT           = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BUSINESSINFO_TELECOM_FAX_EXT";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_FAX_INTCODE       = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BUSINESSINFO_TELECOM_FAX_INTCODE";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_FAX_LOCCODE       = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BUSINESSINFO_TELECOM_FAX_LOCCODE";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_FAX_NUMBER        = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BUSINESSINFO_TELECOM_FAX_NUMBER";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_MOBILE_COMMENT    = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BUSINESSINFO_TELECOM_MOBILE_COMMENT";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_MOBILE_EXT        = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BUSINESSINFO_TELECOM_MOBILE_EXT";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_MOBILE_INTCODE    = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BUSINESSINFO_TELECOM_MOBILE_INTCODE";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_MOBILE_LOCCODE    = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BUSINESSINFO_TELECOM_MOBILE_LOCCODE";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_MOBILE_NUMBER     = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BUSINESSINFO_TELECOM_MOBILE_NUMBER";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_PAGER_COMMENT     = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BUSINESSINFO_TELECOM_PAGER_COMMENT";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_PAGER_EXT         = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BUSINESSINFO_TELECOM_PAGER_EXT";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_PAGER_INTCODE     = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BUSINESSINFO_TELECOM_PAGER_INTCODE";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_PAGER_LOCCODE     = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BUSINESSINFO_TELECOM_PAGER_LOCCODE";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_PAGER_NUMBER      = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BUSINESSINFO_TELECOM_PAGER_NUMBER";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_TELEPHONE_COMMENT = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BUSINESSINFO_TELECOM_TELEPHONE_COMMENT";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_TELEPHONE_EXT     = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BUSINESSINFO_TELECOM_TELEPHONE_EXT";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_TELEPHONE_INTCODE = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BUSINESSINFO_TELECOM_TELEPHONE_INTCODE";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_TELEPHONE_LOCCODE = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BUSINESSINFO_TELECOM_TELEPHONE_LOCCODE";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_TELEPHONE_NUMBER  = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_BUSINESSINFO_TELECOM_TELEPHONE_NUMBER";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_DEPARTMENT                             = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_DEPARTMENT";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_EMPLOYER                               = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_EMPLOYER";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_GENDER                                 = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_GENDER";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_ONLINE_EMAIL                  = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_HOMEINFO_ONLINE_EMAIL";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_ONLINE_URI                    = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_HOMEINFO_ONLINE_URI";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_POSTAL_CITY                   = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_HOMEINFO_POSTAL_CITY";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_POSTAL_COUNTRY                = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_HOMEINFO_POSTAL_COUNTRY";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_POSTAL_NAME                   = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_HOMEINFO_POSTAL_NAME";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_POSTAL_ORGANIZATION           = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_HOMEINFO_POSTAL_ORGANIZATION";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_POSTAL_POSTALCODE             = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_HOMEINFO_POSTAL_POSTALCODE";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_POSTAL_STATEPROV              = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_HOMEINFO_POSTAL_STATEPROV";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_POSTAL_STREET                 = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_HOMEINFO_POSTAL_STREET";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_FAX_COMMENT           = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_HOMEINFO_TELECOM_FAX_COMMENT";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_FAX_EXT               = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_HOMEINFO_TELECOM_FAX_EXT";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_FAX_INTCODE           = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_HOMEINFO_TELECOM_FAX_INTCODE";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_FAX_LOCCODE           = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_HOMEINFO_TELECOM_FAX_LOCCODE";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_FAX_NUMBER            = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_HOMEINFO_TELECOM_FAX_NUMBER";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_MOBILE_COMMENT        = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_HOMEINFO_TELECOM_MOBILE_COMMENT";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_MOBILE_EXT            = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_HOMEINFO_TELECOM_MOBILE_EXT";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_MOBILE_INTCODE        = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_HOMEINFO_TELECOM_MOBILE_INTCODE";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_MOBILE_LOCCODE        = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_HOMEINFO_TELECOM_MOBILE_LOCCODE";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_MOBILE_NUMBER         = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_HOMEINFO_TELECOM_MOBILE_NUMBER";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_PAGER_COMMENT         = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_HOMEINFO_TELECOM_PAGER_COMMENT";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_PAGER_EXT             = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_HOMEINFO_TELECOM_PAGER_EXT";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_PAGER_INTCODE         = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_HOMEINFO_TELECOM_PAGER_INTCODE";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_PAGER_LOCCODE         = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_HOMEINFO_TELECOM_PAGER_LOCCODE";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_PAGER_NUMBER          = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_HOMEINFO_TELECOM_PAGER_NUMBER";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_TELEPHONE_COMMENT     = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_HOMEINFO_TELECOM_TELEPHONE_COMMENT";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_TELEPHONE_EXT         = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_HOMEINFO_TELECOM_TELEPHONE_EXT";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_TELEPHONE_INTCODE     = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_HOMEINFO_TELECOM_TELEPHONE_INTCODE";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_TELEPHONE_LOCCODE     = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_HOMEINFO_TELECOM_TELEPHONE_LOCCODE";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_TELEPHONE_NUMBER      = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_HOMEINFO_TELECOM_TELEPHONE_NUMBER";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_JOBTITLE                               = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_JOBTITLE";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_LOGIN_ID                               = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_LOGIN_ID";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_NAME_FAMILY                            = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_NAME_FAMILY";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_NAME_GIVEN                             = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_NAME_GIVEN";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_NAME_MIDDLE                            = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_NAME_MIDDLE";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_NAME_NICKNAME                          = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_NAME_NICKNAME";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_NAME_PREFIX                            = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_NAME_PREFIX";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_NAME_SUFFIX                            = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_fieldUSER_NAME_SUFFIX";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_HASTOSTRING                                      = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_hasToString";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_HASTOSTRINGRETURNS                               = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_hasToStringReturns";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_HASVALUEOF                                       = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_hasValueOf";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_HASVALUEOFRETURNS                                = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_hasValueOfReturns";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_HASVALUES                                        = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_hasValues";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_HASVALUESRETURNS                                 = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_hasValuesReturns";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_ISENUM                                           = "V2SigTestsRender_PortletRequest$P3PUserInfos_SIGRender_isEnum";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_FIELDACTION_PHASE                                             = "V2SigTestsRender_PortletRequest_SIGRender_fieldACTION_PHASE";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_FIELDACTION_SCOPE_ID                                          = "V2SigTestsRender_PortletRequest_SIGRender_fieldACTION_SCOPE_ID";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_FIELDBASIC_AUTH                                               = "V2SigTestsRender_PortletRequest_SIGRender_fieldBASIC_AUTH";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_FIELDCCPP_PROFILE                                             = "V2SigTestsRender_PortletRequest_SIGRender_fieldCCPP_PROFILE";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_FIELDCLIENT_CERT_AUTH                                         = "V2SigTestsRender_PortletRequest_SIGRender_fieldCLIENT_CERT_AUTH";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_FIELDDIGEST_AUTH                                              = "V2SigTestsRender_PortletRequest_SIGRender_fieldDIGEST_AUTH";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_FIELDEVENT_PHASE                                              = "V2SigTestsRender_PortletRequest_SIGRender_fieldEVENT_PHASE";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_FIELDFORM_AUTH                                                = "V2SigTestsRender_PortletRequest_SIGRender_fieldFORM_AUTH";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_FIELDLIFECYCLE_PHASE                                          = "V2SigTestsRender_PortletRequest_SIGRender_fieldLIFECYCLE_PHASE";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_FIELDRENDER_HEADERS                                           = "V2SigTestsRender_PortletRequest_SIGRender_fieldRENDER_HEADERS";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_FIELDRENDER_MARKUP                                            = "V2SigTestsRender_PortletRequest_SIGRender_fieldRENDER_MARKUP";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_FIELDRENDER_PART                                              = "V2SigTestsRender_PortletRequest_SIGRender_fieldRENDER_PART";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_FIELDRENDER_PHASE                                             = "V2SigTestsRender_PortletRequest_SIGRender_fieldRENDER_PHASE";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_FIELDRESOURCE_PHASE                                           = "V2SigTestsRender_PortletRequest_SIGRender_fieldRESOURCE_PHASE";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_FIELDUSER_INFO                                                = "V2SigTestsRender_PortletRequest_SIGRender_fieldUSER_INFO";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETATTRIBUTE                                               = "V2SigTestsRender_PortletRequest_SIGRender_hasGetAttribute";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETATTRIBUTENAMES                                          = "V2SigTestsRender_PortletRequest_SIGRender_hasGetAttributeNames";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETATTRIBUTENAMESRETURNS                                   = "V2SigTestsRender_PortletRequest_SIGRender_hasGetAttributeNamesReturns";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETATTRIBUTERETURNS                                        = "V2SigTestsRender_PortletRequest_SIGRender_hasGetAttributeReturns";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETAUTHTYPE                                                = "V2SigTestsRender_PortletRequest_SIGRender_hasGetAuthType";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETAUTHTYPERETURNS                                         = "V2SigTestsRender_PortletRequest_SIGRender_hasGetAuthTypeReturns";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETCONTEXTPATH                                             = "V2SigTestsRender_PortletRequest_SIGRender_hasGetContextPath";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETCONTEXTPATHRETURNS                                      = "V2SigTestsRender_PortletRequest_SIGRender_hasGetContextPathReturns";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETCOOKIES                                                 = "V2SigTestsRender_PortletRequest_SIGRender_hasGetCookies";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETCOOKIESRETURNS                                          = "V2SigTestsRender_PortletRequest_SIGRender_hasGetCookiesReturns";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETLOCALE                                                  = "V2SigTestsRender_PortletRequest_SIGRender_hasGetLocale";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETLOCALERETURNS                                           = "V2SigTestsRender_PortletRequest_SIGRender_hasGetLocaleReturns";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETLOCALES                                                 = "V2SigTestsRender_PortletRequest_SIGRender_hasGetLocales";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETLOCALESRETURNS                                          = "V2SigTestsRender_PortletRequest_SIGRender_hasGetLocalesReturns";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETPARAMETER                                               = "V2SigTestsRender_PortletRequest_SIGRender_hasGetParameter";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETPARAMETERMAP                                            = "V2SigTestsRender_PortletRequest_SIGRender_hasGetParameterMap";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETPARAMETERMAPRETURNS                                     = "V2SigTestsRender_PortletRequest_SIGRender_hasGetParameterMapReturns";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETPARAMETERNAMES                                          = "V2SigTestsRender_PortletRequest_SIGRender_hasGetParameterNames";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETPARAMETERNAMESRETURNS                                   = "V2SigTestsRender_PortletRequest_SIGRender_hasGetParameterNamesReturns";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETPARAMETERRETURNS                                        = "V2SigTestsRender_PortletRequest_SIGRender_hasGetParameterReturns";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETPARAMETERVALUES                                         = "V2SigTestsRender_PortletRequest_SIGRender_hasGetParameterValues";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETPARAMETERVALUESRETURNS                                  = "V2SigTestsRender_PortletRequest_SIGRender_hasGetParameterValuesReturns";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETPORTALCONTEXT                                           = "V2SigTestsRender_PortletRequest_SIGRender_hasGetPortalContext";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETPORTALCONTEXTRETURNS                                    = "V2SigTestsRender_PortletRequest_SIGRender_hasGetPortalContextReturns";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETPORTLETMODE                                             = "V2SigTestsRender_PortletRequest_SIGRender_hasGetPortletMode";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETPORTLETMODERETURNS                                      = "V2SigTestsRender_PortletRequest_SIGRender_hasGetPortletModeReturns";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETPORTLETSESSION                                          = "V2SigTestsRender_PortletRequest_SIGRender_hasGetPortletSession";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETPORTLETSESSIONA                                         = "V2SigTestsRender_PortletRequest_SIGRender_hasGetPortletSessionA";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETPORTLETSESSIONRETURNS                                   = "V2SigTestsRender_PortletRequest_SIGRender_hasGetPortletSessionReturns";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETPORTLETSESSIONRETURNSA                                  = "V2SigTestsRender_PortletRequest_SIGRender_hasGetPortletSessionReturnsA";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETPREFERENCES                                             = "V2SigTestsRender_PortletRequest_SIGRender_hasGetPreferences";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETPREFERENCESRETURNS                                      = "V2SigTestsRender_PortletRequest_SIGRender_hasGetPreferencesReturns";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETPRIVATEPARAMETERMAP                                     = "V2SigTestsRender_PortletRequest_SIGRender_hasGetPrivateParameterMap";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETPRIVATEPARAMETERMAPRETURNS                              = "V2SigTestsRender_PortletRequest_SIGRender_hasGetPrivateParameterMapReturns";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETPROPERTIES                                              = "V2SigTestsRender_PortletRequest_SIGRender_hasGetProperties";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETPROPERTIESRETURNS                                       = "V2SigTestsRender_PortletRequest_SIGRender_hasGetPropertiesReturns";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETPROPERTY                                                = "V2SigTestsRender_PortletRequest_SIGRender_hasGetProperty";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETPROPERTYNAMES                                           = "V2SigTestsRender_PortletRequest_SIGRender_hasGetPropertyNames";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETPROPERTYNAMESRETURNS                                    = "V2SigTestsRender_PortletRequest_SIGRender_hasGetPropertyNamesReturns";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETPROPERTYRETURNS                                         = "V2SigTestsRender_PortletRequest_SIGRender_hasGetPropertyReturns";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETPUBLICPARAMETERMAP                                      = "V2SigTestsRender_PortletRequest_SIGRender_hasGetPublicParameterMap";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETPUBLICPARAMETERMAPRETURNS                               = "V2SigTestsRender_PortletRequest_SIGRender_hasGetPublicParameterMapReturns";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETREMOTEUSER                                              = "V2SigTestsRender_PortletRequest_SIGRender_hasGetRemoteUser";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETREMOTEUSERRETURNS                                       = "V2SigTestsRender_PortletRequest_SIGRender_hasGetRemoteUserReturns";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETREQUESTEDSESSIONID                                      = "V2SigTestsRender_PortletRequest_SIGRender_hasGetRequestedSessionId";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETREQUESTEDSESSIONIDRETURNS                               = "V2SigTestsRender_PortletRequest_SIGRender_hasGetRequestedSessionIdReturns";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETRESPONSECONTENTTYPE                                     = "V2SigTestsRender_PortletRequest_SIGRender_hasGetResponseContentType";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETRESPONSECONTENTTYPERETURNS                              = "V2SigTestsRender_PortletRequest_SIGRender_hasGetResponseContentTypeReturns";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETRESPONSECONTENTTYPES                                    = "V2SigTestsRender_PortletRequest_SIGRender_hasGetResponseContentTypes";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETRESPONSECONTENTTYPESRETURNS                             = "V2SigTestsRender_PortletRequest_SIGRender_hasGetResponseContentTypesReturns";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETSCHEME                                                  = "V2SigTestsRender_PortletRequest_SIGRender_hasGetScheme";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETSCHEMERETURNS                                           = "V2SigTestsRender_PortletRequest_SIGRender_hasGetSchemeReturns";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETSERVERNAME                                              = "V2SigTestsRender_PortletRequest_SIGRender_hasGetServerName";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETSERVERNAMERETURNS                                       = "V2SigTestsRender_PortletRequest_SIGRender_hasGetServerNameReturns";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETSERVERPORT                                              = "V2SigTestsRender_PortletRequest_SIGRender_hasGetServerPort";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETSERVERPORTRETURNS                                       = "V2SigTestsRender_PortletRequest_SIGRender_hasGetServerPortReturns";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETUSERPRINCIPAL                                           = "V2SigTestsRender_PortletRequest_SIGRender_hasGetUserPrincipal";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETUSERPRINCIPALRETURNS                                    = "V2SigTestsRender_PortletRequest_SIGRender_hasGetUserPrincipalReturns";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETWINDOWID                                                = "V2SigTestsRender_PortletRequest_SIGRender_hasGetWindowID";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETWINDOWIDRETURNS                                         = "V2SigTestsRender_PortletRequest_SIGRender_hasGetWindowIDReturns";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETWINDOWSTATE                                             = "V2SigTestsRender_PortletRequest_SIGRender_hasGetWindowState";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETWINDOWSTATERETURNS                                      = "V2SigTestsRender_PortletRequest_SIGRender_hasGetWindowStateReturns";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASISPORTLETMODEALLOWED                                       = "V2SigTestsRender_PortletRequest_SIGRender_hasIsPortletModeAllowed";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASISPORTLETMODEALLOWEDRETURNS                                = "V2SigTestsRender_PortletRequest_SIGRender_hasIsPortletModeAllowedReturns";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASISREQUESTEDSESSIONIDVALID                                  = "V2SigTestsRender_PortletRequest_SIGRender_hasIsRequestedSessionIdValid";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASISREQUESTEDSESSIONIDVALIDRETURNS                           = "V2SigTestsRender_PortletRequest_SIGRender_hasIsRequestedSessionIdValidReturns";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASISSECURE                                                   = "V2SigTestsRender_PortletRequest_SIGRender_hasIsSecure";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASISSECURERETURNS                                            = "V2SigTestsRender_PortletRequest_SIGRender_hasIsSecureReturns";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASISUSERINROLE                                               = "V2SigTestsRender_PortletRequest_SIGRender_hasIsUserInRole";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASISUSERINROLERETURNS                                        = "V2SigTestsRender_PortletRequest_SIGRender_hasIsUserInRoleReturns";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASISWINDOWSTATEALLOWED                                       = "V2SigTestsRender_PortletRequest_SIGRender_hasIsWindowStateAllowed";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASISWINDOWSTATEALLOWEDRETURNS                                = "V2SigTestsRender_PortletRequest_SIGRender_hasIsWindowStateAllowedReturns";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASREMOVEATTRIBUTE                                            = "V2SigTestsRender_PortletRequest_SIGRender_hasRemoveAttribute";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASREMOVEATTRIBUTERETURNS                                     = "V2SigTestsRender_PortletRequest_SIGRender_hasRemoveAttributeReturns";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASSETATTRIBUTE                                               = "V2SigTestsRender_PortletRequest_SIGRender_hasSetAttribute";
   public final static String               V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASSETATTRIBUTERETURNS                                        = "V2SigTestsRender_PortletRequest_SIGRender_hasSetAttributeReturns";
   public final static String               V2SIGTESTSRENDER_PORTLETRESPONSE_SIGRENDER_HASADDPROPERTY                                               = "V2SigTestsRender_PortletResponse_SIGRender_hasAddProperty";
   public final static String               V2SIGTESTSRENDER_PORTLETRESPONSE_SIGRENDER_HASADDPROPERTYA                                              = "V2SigTestsRender_PortletResponse_SIGRender_hasAddPropertyA";
   public final static String               V2SIGTESTSRENDER_PORTLETRESPONSE_SIGRENDER_HASADDPROPERTYB                                              = "V2SigTestsRender_PortletResponse_SIGRender_hasAddPropertyB";
   public final static String               V2SIGTESTSRENDER_PORTLETRESPONSE_SIGRENDER_HASADDPROPERTYRETURNS                                        = "V2SigTestsRender_PortletResponse_SIGRender_hasAddPropertyReturns";
   public final static String               V2SIGTESTSRENDER_PORTLETRESPONSE_SIGRENDER_HASADDPROPERTYRETURNSA                                       = "V2SigTestsRender_PortletResponse_SIGRender_hasAddPropertyReturnsA";
   public final static String               V2SIGTESTSRENDER_PORTLETRESPONSE_SIGRENDER_HASADDPROPERTYRETURNSB                                       = "V2SigTestsRender_PortletResponse_SIGRender_hasAddPropertyReturnsB";
   public final static String               V2SIGTESTSRENDER_PORTLETRESPONSE_SIGRENDER_HASCREATEELEMENT                                             = "V2SigTestsRender_PortletResponse_SIGRender_hasCreateElement";
   public final static String               V2SIGTESTSRENDER_PORTLETRESPONSE_SIGRENDER_HASCREATEELEMENTRETURNS                                      = "V2SigTestsRender_PortletResponse_SIGRender_hasCreateElementReturns";
   public final static String               V2SIGTESTSRENDER_PORTLETRESPONSE_SIGRENDER_HASENCODEURL                                                 = "V2SigTestsRender_PortletResponse_SIGRender_hasEncodeURL";
   public final static String               V2SIGTESTSRENDER_PORTLETRESPONSE_SIGRENDER_HASENCODEURLRETURNS                                          = "V2SigTestsRender_PortletResponse_SIGRender_hasEncodeURLReturns";
   public final static String               V2SIGTESTSRENDER_PORTLETRESPONSE_SIGRENDER_HASGETNAMESPACE                                              = "V2SigTestsRender_PortletResponse_SIGRender_hasGetNamespace";
   public final static String               V2SIGTESTSRENDER_PORTLETRESPONSE_SIGRENDER_HASGETNAMESPACERETURNS                                       = "V2SigTestsRender_PortletResponse_SIGRender_hasGetNamespaceReturns";
   public final static String               V2SIGTESTSRENDER_PORTLETRESPONSE_SIGRENDER_HASSETPROPERTY                                               = "V2SigTestsRender_PortletResponse_SIGRender_hasSetProperty";
   public final static String               V2SIGTESTSRENDER_PORTLETRESPONSE_SIGRENDER_HASSETPROPERTYRETURNS                                        = "V2SigTestsRender_PortletResponse_SIGRender_hasSetPropertyReturns";
   public final static String               V2SIGTESTSRENDER_RENDERREQUEST_SIGRENDER_FIELDETAG                                                      = "V2SigTestsRender_RenderRequest_SIGRender_fieldETAG";
   public final static String               V2SIGTESTSRENDER_RENDERREQUEST_SIGRENDER_HASGETETAG                                                     = "V2SigTestsRender_RenderRequest_SIGRender_hasGetETag";
   public final static String               V2SIGTESTSRENDER_RENDERREQUEST_SIGRENDER_HASGETETAGRETURNS                                              = "V2SigTestsRender_RenderRequest_SIGRender_hasGetETagReturns";
   public final static String               V2SIGTESTSRENDER_RENDERREQUEST_SIGRENDER_IMPLEMENTSPORTLETREQUEST                                       = "V2SigTestsRender_RenderRequest_SIGRender_implementsPortletRequest";
   public final static String               V2SIGTESTSRENDER_RENDERRESPONSE_SIGRENDER_HASSETCONTENTTYPE                                             = "V2SigTestsRender_RenderResponse_SIGRender_hasSetContentType";
   public final static String               V2SIGTESTSRENDER_RENDERRESPONSE_SIGRENDER_HASSETCONTENTTYPERETURNS                                      = "V2SigTestsRender_RenderResponse_SIGRender_hasSetContentTypeReturns";
   public final static String               V2SIGTESTSRENDER_RENDERRESPONSE_SIGRENDER_HASSETNEXTPOSSIBLEPORTLETMODES                                = "V2SigTestsRender_RenderResponse_SIGRender_hasSetNextPossiblePortletModes";
   public final static String               V2SIGTESTSRENDER_RENDERRESPONSE_SIGRENDER_HASSETNEXTPOSSIBLEPORTLETMODESRETURNS                         = "V2SigTestsRender_RenderResponse_SIGRender_hasSetNextPossiblePortletModesReturns";
   public final static String               V2SIGTESTSRENDER_RENDERRESPONSE_SIGRENDER_HASSETTITLE                                                   = "V2SigTestsRender_RenderResponse_SIGRender_hasSetTitle";
   public final static String               V2SIGTESTSRENDER_RENDERRESPONSE_SIGRENDER_HASSETTITLERETURNS                                            = "V2SigTestsRender_RenderResponse_SIGRender_hasSetTitleReturns";
   public final static String               V2SIGTESTSRENDER_RENDERRESPONSE_SIGRENDER_IMPLEMENTSMIMERESPONSE                                        = "V2SigTestsRender_RenderResponse_SIGRender_implementsMimeResponse";
   public final static String               V2SIGTESTSRESOURCE_CLIENTDATAREQUEST_SIGRESOURCE_HASGETCHARACTERENCODING                                = "V2SigTestsResource_ClientDataRequest_SIGResource_hasGetCharacterEncoding";
   public final static String               V2SIGTESTSRESOURCE_CLIENTDATAREQUEST_SIGRESOURCE_HASGETCHARACTERENCODINGRETURNS                         = "V2SigTestsResource_ClientDataRequest_SIGResource_hasGetCharacterEncodingReturns";
   public final static String               V2SIGTESTSRESOURCE_CLIENTDATAREQUEST_SIGRESOURCE_HASGETCONTENTLENGTH                                    = "V2SigTestsResource_ClientDataRequest_SIGResource_hasGetContentLength";
   public final static String               V2SIGTESTSRESOURCE_CLIENTDATAREQUEST_SIGRESOURCE_HASGETCONTENTLENGTHRETURNS                             = "V2SigTestsResource_ClientDataRequest_SIGResource_hasGetContentLengthReturns";
   public final static String               V2SIGTESTSRESOURCE_CLIENTDATAREQUEST_SIGRESOURCE_HASGETCONTENTTYPE                                      = "V2SigTestsResource_ClientDataRequest_SIGResource_hasGetContentType";
   public final static String               V2SIGTESTSRESOURCE_CLIENTDATAREQUEST_SIGRESOURCE_HASGETCONTENTTYPERETURNS                               = "V2SigTestsResource_ClientDataRequest_SIGResource_hasGetContentTypeReturns";
   public final static String               V2SIGTESTSRESOURCE_CLIENTDATAREQUEST_SIGRESOURCE_HASGETMETHOD                                           = "V2SigTestsResource_ClientDataRequest_SIGResource_hasGetMethod";
   public final static String               V2SIGTESTSRESOURCE_CLIENTDATAREQUEST_SIGRESOURCE_HASGETMETHODRETURNS                                    = "V2SigTestsResource_ClientDataRequest_SIGResource_hasGetMethodReturns";
   public final static String               V2SIGTESTSRESOURCE_CLIENTDATAREQUEST_SIGRESOURCE_HASGETPORTLETINPUTSTREAM                               = "V2SigTestsResource_ClientDataRequest_SIGResource_hasGetPortletInputStream";
   public final static String               V2SIGTESTSRESOURCE_CLIENTDATAREQUEST_SIGRESOURCE_HASGETPORTLETINPUTSTREAMRETURNS                        = "V2SigTestsResource_ClientDataRequest_SIGResource_hasGetPortletInputStreamReturns";
   public final static String               V2SIGTESTSRESOURCE_CLIENTDATAREQUEST_SIGRESOURCE_HASGETREADER                                           = "V2SigTestsResource_ClientDataRequest_SIGResource_hasGetReader";
   public final static String               V2SIGTESTSRESOURCE_CLIENTDATAREQUEST_SIGRESOURCE_HASGETREADERRETURNS                                    = "V2SigTestsResource_ClientDataRequest_SIGResource_hasGetReaderReturns";
   public final static String               V2SIGTESTSRESOURCE_CLIENTDATAREQUEST_SIGRESOURCE_HASSETCHARACTERENCODING                                = "V2SigTestsResource_ClientDataRequest_SIGResource_hasSetCharacterEncoding";
   public final static String               V2SIGTESTSRESOURCE_CLIENTDATAREQUEST_SIGRESOURCE_HASSETCHARACTERENCODINGRETURNS                         = "V2SigTestsResource_ClientDataRequest_SIGResource_hasSetCharacterEncodingReturns";
   public final static String               V2SIGTESTSRESOURCE_CLIENTDATAREQUEST_SIGRESOURCE_IMPLEMENTSPORTLETREQUEST                               = "V2SigTestsResource_ClientDataRequest_SIGResource_implementsPortletRequest";
   public final static String               V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_FIELDCACHE_SCOPE                                            = "V2SigTestsResource_MimeResponse_SIGResource_fieldCACHE_SCOPE";
   public final static String               V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_FIELDETAG                                                   = "V2SigTestsResource_MimeResponse_SIGResource_fieldETAG";
   public final static String               V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_FIELDEXPIRATION_CACHE                                       = "V2SigTestsResource_MimeResponse_SIGResource_fieldEXPIRATION_CACHE";
   public final static String               V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_FIELDMARKUP_HEAD_ELEMENT                                    = "V2SigTestsResource_MimeResponse_SIGResource_fieldMARKUP_HEAD_ELEMENT";
   public final static String               V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_FIELDNAMESPACED_RESPONSE                                    = "V2SigTestsResource_MimeResponse_SIGResource_fieldNAMESPACED_RESPONSE";
   public final static String               V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_FIELDPRIVATE_SCOPE                                          = "V2SigTestsResource_MimeResponse_SIGResource_fieldPRIVATE_SCOPE";
   public final static String               V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_FIELDPUBLIC_SCOPE                                           = "V2SigTestsResource_MimeResponse_SIGResource_fieldPUBLIC_SCOPE";
   public final static String               V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_FIELDUSE_CACHED_CONTENT                                     = "V2SigTestsResource_MimeResponse_SIGResource_fieldUSE_CACHED_CONTENT";
   public final static String               V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASCREATEACTIONURL                                          = "V2SigTestsResource_MimeResponse_SIGResource_hasCreateActionURL";
   public final static String               V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASCREATEACTIONURLRETURNS                                   = "V2SigTestsResource_MimeResponse_SIGResource_hasCreateActionURLReturns";
   public final static String               V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASCREATERENDERURL                                          = "V2SigTestsResource_MimeResponse_SIGResource_hasCreateRenderURL";
   public final static String               V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASCREATERENDERURLRETURNS                                   = "V2SigTestsResource_MimeResponse_SIGResource_hasCreateRenderURLReturns";
   public final static String               V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASCREATERESOURCEURL                                        = "V2SigTestsResource_MimeResponse_SIGResource_hasCreateResourceURL";
   public final static String               V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASCREATERESOURCEURLRETURNS                                 = "V2SigTestsResource_MimeResponse_SIGResource_hasCreateResourceURLReturns";
   public final static String               V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASFLUSHBUFFER                                              = "V2SigTestsResource_MimeResponse_SIGResource_hasFlushBuffer";
   public final static String               V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASFLUSHBUFFERRETURNS                                       = "V2SigTestsResource_MimeResponse_SIGResource_hasFlushBufferReturns";
   public final static String               V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASGETBUFFERSIZE                                            = "V2SigTestsResource_MimeResponse_SIGResource_hasGetBufferSize";
   public final static String               V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASGETBUFFERSIZERETURNS                                     = "V2SigTestsResource_MimeResponse_SIGResource_hasGetBufferSizeReturns";
   public final static String               V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASGETCACHECONTROL                                          = "V2SigTestsResource_MimeResponse_SIGResource_hasGetCacheControl";
   public final static String               V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASGETCACHECONTROLRETURNS                                   = "V2SigTestsResource_MimeResponse_SIGResource_hasGetCacheControlReturns";
   public final static String               V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASGETCHARACTERENCODING                                     = "V2SigTestsResource_MimeResponse_SIGResource_hasGetCharacterEncoding";
   public final static String               V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASGETCHARACTERENCODINGRETURNS                              = "V2SigTestsResource_MimeResponse_SIGResource_hasGetCharacterEncodingReturns";
   public final static String               V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASGETCONTENTTYPE                                           = "V2SigTestsResource_MimeResponse_SIGResource_hasGetContentType";
   public final static String               V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASGETCONTENTTYPERETURNS                                    = "V2SigTestsResource_MimeResponse_SIGResource_hasGetContentTypeReturns";
   public final static String               V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASGETLOCALE                                                = "V2SigTestsResource_MimeResponse_SIGResource_hasGetLocale";
   public final static String               V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASGETLOCALERETURNS                                         = "V2SigTestsResource_MimeResponse_SIGResource_hasGetLocaleReturns";
   public final static String               V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASGETPORTLETOUTPUTSTREAM                                   = "V2SigTestsResource_MimeResponse_SIGResource_hasGetPortletOutputStream";
   public final static String               V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASGETPORTLETOUTPUTSTREAMRETURNS                            = "V2SigTestsResource_MimeResponse_SIGResource_hasGetPortletOutputStreamReturns";
   public final static String               V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASGETWRITER                                                = "V2SigTestsResource_MimeResponse_SIGResource_hasGetWriter";
   public final static String               V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASGETWRITERRETURNS                                         = "V2SigTestsResource_MimeResponse_SIGResource_hasGetWriterReturns";
   public final static String               V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASISCOMMITTED                                              = "V2SigTestsResource_MimeResponse_SIGResource_hasIsCommitted";
   public final static String               V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASISCOMMITTEDRETURNS                                       = "V2SigTestsResource_MimeResponse_SIGResource_hasIsCommittedReturns";
   public final static String               V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASRESET                                                    = "V2SigTestsResource_MimeResponse_SIGResource_hasReset";
   public final static String               V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASRESETBUFFER                                              = "V2SigTestsResource_MimeResponse_SIGResource_hasResetBuffer";
   public final static String               V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASRESETBUFFERRETURNS                                       = "V2SigTestsResource_MimeResponse_SIGResource_hasResetBufferReturns";
   public final static String               V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASRESETRETURNS                                             = "V2SigTestsResource_MimeResponse_SIGResource_hasResetReturns";
   public final static String               V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASSETBUFFERSIZE                                            = "V2SigTestsResource_MimeResponse_SIGResource_hasSetBufferSize";
   public final static String               V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASSETBUFFERSIZERETURNS                                     = "V2SigTestsResource_MimeResponse_SIGResource_hasSetBufferSizeReturns";
   public final static String               V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASSETCONTENTTYPE                                           = "V2SigTestsResource_MimeResponse_SIGResource_hasSetContentType";
   public final static String               V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASSETCONTENTTYPERETURNS                                    = "V2SigTestsResource_MimeResponse_SIGResource_hasSetContentTypeReturns";
   public final static String               V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_IMPLEMENTSPORTLETRESPONSE                                   = "V2SigTestsResource_MimeResponse_SIGResource_implementsPortletResponse";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_FIELDACTION_PHASE                                         = "V2SigTestsResource_PortletRequest_SIGResource_fieldACTION_PHASE";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_FIELDACTION_SCOPE_ID                                      = "V2SigTestsResource_PortletRequest_SIGResource_fieldACTION_SCOPE_ID";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_FIELDBASIC_AUTH                                           = "V2SigTestsResource_PortletRequest_SIGResource_fieldBASIC_AUTH";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_FIELDCCPP_PROFILE                                         = "V2SigTestsResource_PortletRequest_SIGResource_fieldCCPP_PROFILE";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_FIELDCLIENT_CERT_AUTH                                     = "V2SigTestsResource_PortletRequest_SIGResource_fieldCLIENT_CERT_AUTH";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_FIELDDIGEST_AUTH                                          = "V2SigTestsResource_PortletRequest_SIGResource_fieldDIGEST_AUTH";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_FIELDEVENT_PHASE                                          = "V2SigTestsResource_PortletRequest_SIGResource_fieldEVENT_PHASE";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_FIELDFORM_AUTH                                            = "V2SigTestsResource_PortletRequest_SIGResource_fieldFORM_AUTH";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_FIELDLIFECYCLE_PHASE                                      = "V2SigTestsResource_PortletRequest_SIGResource_fieldLIFECYCLE_PHASE";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_FIELDRENDER_HEADERS                                       = "V2SigTestsResource_PortletRequest_SIGResource_fieldRENDER_HEADERS";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_FIELDRENDER_MARKUP                                        = "V2SigTestsResource_PortletRequest_SIGResource_fieldRENDER_MARKUP";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_FIELDRENDER_PART                                          = "V2SigTestsResource_PortletRequest_SIGResource_fieldRENDER_PART";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_FIELDRENDER_PHASE                                         = "V2SigTestsResource_PortletRequest_SIGResource_fieldRENDER_PHASE";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_FIELDRESOURCE_PHASE                                       = "V2SigTestsResource_PortletRequest_SIGResource_fieldRESOURCE_PHASE";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_FIELDUSER_INFO                                            = "V2SigTestsResource_PortletRequest_SIGResource_fieldUSER_INFO";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETATTRIBUTE                                           = "V2SigTestsResource_PortletRequest_SIGResource_hasGetAttribute";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETATTRIBUTENAMES                                      = "V2SigTestsResource_PortletRequest_SIGResource_hasGetAttributeNames";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETATTRIBUTENAMESRETURNS                               = "V2SigTestsResource_PortletRequest_SIGResource_hasGetAttributeNamesReturns";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETATTRIBUTERETURNS                                    = "V2SigTestsResource_PortletRequest_SIGResource_hasGetAttributeReturns";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETAUTHTYPE                                            = "V2SigTestsResource_PortletRequest_SIGResource_hasGetAuthType";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETAUTHTYPERETURNS                                     = "V2SigTestsResource_PortletRequest_SIGResource_hasGetAuthTypeReturns";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETCONTEXTPATH                                         = "V2SigTestsResource_PortletRequest_SIGResource_hasGetContextPath";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETCONTEXTPATHRETURNS                                  = "V2SigTestsResource_PortletRequest_SIGResource_hasGetContextPathReturns";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETCOOKIES                                             = "V2SigTestsResource_PortletRequest_SIGResource_hasGetCookies";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETCOOKIESRETURNS                                      = "V2SigTestsResource_PortletRequest_SIGResource_hasGetCookiesReturns";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETLOCALE                                              = "V2SigTestsResource_PortletRequest_SIGResource_hasGetLocale";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETLOCALERETURNS                                       = "V2SigTestsResource_PortletRequest_SIGResource_hasGetLocaleReturns";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETLOCALES                                             = "V2SigTestsResource_PortletRequest_SIGResource_hasGetLocales";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETLOCALESRETURNS                                      = "V2SigTestsResource_PortletRequest_SIGResource_hasGetLocalesReturns";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPARAMETER                                           = "V2SigTestsResource_PortletRequest_SIGResource_hasGetParameter";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPARAMETERMAP                                        = "V2SigTestsResource_PortletRequest_SIGResource_hasGetParameterMap";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPARAMETERMAPRETURNS                                 = "V2SigTestsResource_PortletRequest_SIGResource_hasGetParameterMapReturns";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPARAMETERNAMES                                      = "V2SigTestsResource_PortletRequest_SIGResource_hasGetParameterNames";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPARAMETERNAMESRETURNS                               = "V2SigTestsResource_PortletRequest_SIGResource_hasGetParameterNamesReturns";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPARAMETERRETURNS                                    = "V2SigTestsResource_PortletRequest_SIGResource_hasGetParameterReturns";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPARAMETERVALUES                                     = "V2SigTestsResource_PortletRequest_SIGResource_hasGetParameterValues";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPARAMETERVALUESRETURNS                              = "V2SigTestsResource_PortletRequest_SIGResource_hasGetParameterValuesReturns";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPORTALCONTEXT                                       = "V2SigTestsResource_PortletRequest_SIGResource_hasGetPortalContext";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPORTALCONTEXTRETURNS                                = "V2SigTestsResource_PortletRequest_SIGResource_hasGetPortalContextReturns";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPORTLETMODE                                         = "V2SigTestsResource_PortletRequest_SIGResource_hasGetPortletMode";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPORTLETMODERETURNS                                  = "V2SigTestsResource_PortletRequest_SIGResource_hasGetPortletModeReturns";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPORTLETSESSION                                      = "V2SigTestsResource_PortletRequest_SIGResource_hasGetPortletSession";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPORTLETSESSIONA                                     = "V2SigTestsResource_PortletRequest_SIGResource_hasGetPortletSessionA";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPORTLETSESSIONRETURNS                               = "V2SigTestsResource_PortletRequest_SIGResource_hasGetPortletSessionReturns";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPORTLETSESSIONRETURNSA                              = "V2SigTestsResource_PortletRequest_SIGResource_hasGetPortletSessionReturnsA";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPREFERENCES                                         = "V2SigTestsResource_PortletRequest_SIGResource_hasGetPreferences";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPREFERENCESRETURNS                                  = "V2SigTestsResource_PortletRequest_SIGResource_hasGetPreferencesReturns";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPRIVATEPARAMETERMAP                                 = "V2SigTestsResource_PortletRequest_SIGResource_hasGetPrivateParameterMap";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPRIVATEPARAMETERMAPRETURNS                          = "V2SigTestsResource_PortletRequest_SIGResource_hasGetPrivateParameterMapReturns";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPROPERTIES                                          = "V2SigTestsResource_PortletRequest_SIGResource_hasGetProperties";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPROPERTIESRETURNS                                   = "V2SigTestsResource_PortletRequest_SIGResource_hasGetPropertiesReturns";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPROPERTY                                            = "V2SigTestsResource_PortletRequest_SIGResource_hasGetProperty";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPROPERTYNAMES                                       = "V2SigTestsResource_PortletRequest_SIGResource_hasGetPropertyNames";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPROPERTYNAMESRETURNS                                = "V2SigTestsResource_PortletRequest_SIGResource_hasGetPropertyNamesReturns";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPROPERTYRETURNS                                     = "V2SigTestsResource_PortletRequest_SIGResource_hasGetPropertyReturns";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPUBLICPARAMETERMAP                                  = "V2SigTestsResource_PortletRequest_SIGResource_hasGetPublicParameterMap";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPUBLICPARAMETERMAPRETURNS                           = "V2SigTestsResource_PortletRequest_SIGResource_hasGetPublicParameterMapReturns";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETREMOTEUSER                                          = "V2SigTestsResource_PortletRequest_SIGResource_hasGetRemoteUser";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETREMOTEUSERRETURNS                                   = "V2SigTestsResource_PortletRequest_SIGResource_hasGetRemoteUserReturns";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETREQUESTEDSESSIONID                                  = "V2SigTestsResource_PortletRequest_SIGResource_hasGetRequestedSessionId";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETREQUESTEDSESSIONIDRETURNS                           = "V2SigTestsResource_PortletRequest_SIGResource_hasGetRequestedSessionIdReturns";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETRESPONSECONTENTTYPE                                 = "V2SigTestsResource_PortletRequest_SIGResource_hasGetResponseContentType";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETRESPONSECONTENTTYPERETURNS                          = "V2SigTestsResource_PortletRequest_SIGResource_hasGetResponseContentTypeReturns";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETRESPONSECONTENTTYPES                                = "V2SigTestsResource_PortletRequest_SIGResource_hasGetResponseContentTypes";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETRESPONSECONTENTTYPESRETURNS                         = "V2SigTestsResource_PortletRequest_SIGResource_hasGetResponseContentTypesReturns";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETSCHEME                                              = "V2SigTestsResource_PortletRequest_SIGResource_hasGetScheme";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETSCHEMERETURNS                                       = "V2SigTestsResource_PortletRequest_SIGResource_hasGetSchemeReturns";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETSERVERNAME                                          = "V2SigTestsResource_PortletRequest_SIGResource_hasGetServerName";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETSERVERNAMERETURNS                                   = "V2SigTestsResource_PortletRequest_SIGResource_hasGetServerNameReturns";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETSERVERPORT                                          = "V2SigTestsResource_PortletRequest_SIGResource_hasGetServerPort";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETSERVERPORTRETURNS                                   = "V2SigTestsResource_PortletRequest_SIGResource_hasGetServerPortReturns";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETUSERPRINCIPAL                                       = "V2SigTestsResource_PortletRequest_SIGResource_hasGetUserPrincipal";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETUSERPRINCIPALRETURNS                                = "V2SigTestsResource_PortletRequest_SIGResource_hasGetUserPrincipalReturns";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETWINDOWID                                            = "V2SigTestsResource_PortletRequest_SIGResource_hasGetWindowID";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETWINDOWIDRETURNS                                     = "V2SigTestsResource_PortletRequest_SIGResource_hasGetWindowIDReturns";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETWINDOWSTATE                                         = "V2SigTestsResource_PortletRequest_SIGResource_hasGetWindowState";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETWINDOWSTATERETURNS                                  = "V2SigTestsResource_PortletRequest_SIGResource_hasGetWindowStateReturns";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASISPORTLETMODEALLOWED                                   = "V2SigTestsResource_PortletRequest_SIGResource_hasIsPortletModeAllowed";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASISPORTLETMODEALLOWEDRETURNS                            = "V2SigTestsResource_PortletRequest_SIGResource_hasIsPortletModeAllowedReturns";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASISREQUESTEDSESSIONIDVALID                              = "V2SigTestsResource_PortletRequest_SIGResource_hasIsRequestedSessionIdValid";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASISREQUESTEDSESSIONIDVALIDRETURNS                       = "V2SigTestsResource_PortletRequest_SIGResource_hasIsRequestedSessionIdValidReturns";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASISSECURE                                               = "V2SigTestsResource_PortletRequest_SIGResource_hasIsSecure";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASISSECURERETURNS                                        = "V2SigTestsResource_PortletRequest_SIGResource_hasIsSecureReturns";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASISUSERINROLE                                           = "V2SigTestsResource_PortletRequest_SIGResource_hasIsUserInRole";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASISUSERINROLERETURNS                                    = "V2SigTestsResource_PortletRequest_SIGResource_hasIsUserInRoleReturns";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASISWINDOWSTATEALLOWED                                   = "V2SigTestsResource_PortletRequest_SIGResource_hasIsWindowStateAllowed";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASISWINDOWSTATEALLOWEDRETURNS                            = "V2SigTestsResource_PortletRequest_SIGResource_hasIsWindowStateAllowedReturns";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASREMOVEATTRIBUTE                                        = "V2SigTestsResource_PortletRequest_SIGResource_hasRemoveAttribute";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASREMOVEATTRIBUTERETURNS                                 = "V2SigTestsResource_PortletRequest_SIGResource_hasRemoveAttributeReturns";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASSETATTRIBUTE                                           = "V2SigTestsResource_PortletRequest_SIGResource_hasSetAttribute";
   public final static String               V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASSETATTRIBUTERETURNS                                    = "V2SigTestsResource_PortletRequest_SIGResource_hasSetAttributeReturns";
   public final static String               V2SIGTESTSRESOURCE_PORTLETRESPONSE_SIGRESOURCE_HASADDPROPERTY                                           = "V2SigTestsResource_PortletResponse_SIGResource_hasAddProperty";
   public final static String               V2SIGTESTSRESOURCE_PORTLETRESPONSE_SIGRESOURCE_HASADDPROPERTYA                                          = "V2SigTestsResource_PortletResponse_SIGResource_hasAddPropertyA";
   public final static String               V2SIGTESTSRESOURCE_PORTLETRESPONSE_SIGRESOURCE_HASADDPROPERTYB                                          = "V2SigTestsResource_PortletResponse_SIGResource_hasAddPropertyB";
   public final static String               V2SIGTESTSRESOURCE_PORTLETRESPONSE_SIGRESOURCE_HASADDPROPERTYRETURNS                                    = "V2SigTestsResource_PortletResponse_SIGResource_hasAddPropertyReturns";
   public final static String               V2SIGTESTSRESOURCE_PORTLETRESPONSE_SIGRESOURCE_HASADDPROPERTYRETURNSA                                   = "V2SigTestsResource_PortletResponse_SIGResource_hasAddPropertyReturnsA";
   public final static String               V2SIGTESTSRESOURCE_PORTLETRESPONSE_SIGRESOURCE_HASADDPROPERTYRETURNSB                                   = "V2SigTestsResource_PortletResponse_SIGResource_hasAddPropertyReturnsB";
   public final static String               V2SIGTESTSRESOURCE_PORTLETRESPONSE_SIGRESOURCE_HASCREATEELEMENT                                         = "V2SigTestsResource_PortletResponse_SIGResource_hasCreateElement";
   public final static String               V2SIGTESTSRESOURCE_PORTLETRESPONSE_SIGRESOURCE_HASCREATEELEMENTRETURNS                                  = "V2SigTestsResource_PortletResponse_SIGResource_hasCreateElementReturns";
   public final static String               V2SIGTESTSRESOURCE_PORTLETRESPONSE_SIGRESOURCE_HASENCODEURL                                             = "V2SigTestsResource_PortletResponse_SIGResource_hasEncodeURL";
   public final static String               V2SIGTESTSRESOURCE_PORTLETRESPONSE_SIGRESOURCE_HASENCODEURLRETURNS                                      = "V2SigTestsResource_PortletResponse_SIGResource_hasEncodeURLReturns";
   public final static String               V2SIGTESTSRESOURCE_PORTLETRESPONSE_SIGRESOURCE_HASGETNAMESPACE                                          = "V2SigTestsResource_PortletResponse_SIGResource_hasGetNamespace";
   public final static String               V2SIGTESTSRESOURCE_PORTLETRESPONSE_SIGRESOURCE_HASGETNAMESPACERETURNS                                   = "V2SigTestsResource_PortletResponse_SIGResource_hasGetNamespaceReturns";
   public final static String               V2SIGTESTSRESOURCE_PORTLETRESPONSE_SIGRESOURCE_HASSETPROPERTY                                           = "V2SigTestsResource_PortletResponse_SIGResource_hasSetProperty";
   public final static String               V2SIGTESTSRESOURCE_PORTLETRESPONSE_SIGRESOURCE_HASSETPROPERTYRETURNS                                    = "V2SigTestsResource_PortletResponse_SIGResource_hasSetPropertyReturns";
   public final static String               V2SIGTESTSRESOURCE_RESOURCEREQUEST_SIGRESOURCE_FIELDETAG                                                = "V2SigTestsResource_ResourceRequest_SIGResource_fieldETAG";
   public final static String               V2SIGTESTSRESOURCE_RESOURCEREQUEST_SIGRESOURCE_HASGETCACHEABILITY                                       = "V2SigTestsResource_ResourceRequest_SIGResource_hasGetCacheability";
   public final static String               V2SIGTESTSRESOURCE_RESOURCEREQUEST_SIGRESOURCE_HASGETCACHEABILITYRETURNS                                = "V2SigTestsResource_ResourceRequest_SIGResource_hasGetCacheabilityReturns";
   public final static String               V2SIGTESTSRESOURCE_RESOURCEREQUEST_SIGRESOURCE_HASGETETAG                                               = "V2SigTestsResource_ResourceRequest_SIGResource_hasGetETag";
   public final static String               V2SIGTESTSRESOURCE_RESOURCEREQUEST_SIGRESOURCE_HASGETETAGRETURNS                                        = "V2SigTestsResource_ResourceRequest_SIGResource_hasGetETagReturns";
   public final static String               V2SIGTESTSRESOURCE_RESOURCEREQUEST_SIGRESOURCE_HASGETPRIVATERENDERPARAMETERMAP                          = "V2SigTestsResource_ResourceRequest_SIGResource_hasGetPrivateRenderParameterMap";
   public final static String               V2SIGTESTSRESOURCE_RESOURCEREQUEST_SIGRESOURCE_HASGETPRIVATERENDERPARAMETERMAPRETURNS                   = "V2SigTestsResource_ResourceRequest_SIGResource_hasGetPrivateRenderParameterMapReturns";
   public final static String               V2SIGTESTSRESOURCE_RESOURCEREQUEST_SIGRESOURCE_HASGETRESOURCEID                                         = "V2SigTestsResource_ResourceRequest_SIGResource_hasGetResourceID";
   public final static String               V2SIGTESTSRESOURCE_RESOURCEREQUEST_SIGRESOURCE_HASGETRESOURCEIDRETURNS                                  = "V2SigTestsResource_ResourceRequest_SIGResource_hasGetResourceIDReturns";
   public final static String               V2SIGTESTSRESOURCE_RESOURCEREQUEST_SIGRESOURCE_HASGETRESPONSECONTENTTYPE                                = "V2SigTestsResource_ResourceRequest_SIGResource_hasGetResponseContentType";
   public final static String               V2SIGTESTSRESOURCE_RESOURCEREQUEST_SIGRESOURCE_HASGETRESPONSECONTENTTYPERETURNS                         = "V2SigTestsResource_ResourceRequest_SIGResource_hasGetResponseContentTypeReturns";
   public final static String               V2SIGTESTSRESOURCE_RESOURCEREQUEST_SIGRESOURCE_HASGETRESPONSECONTENTTYPES                               = "V2SigTestsResource_ResourceRequest_SIGResource_hasGetResponseContentTypes";
   public final static String               V2SIGTESTSRESOURCE_RESOURCEREQUEST_SIGRESOURCE_HASGETRESPONSECONTENTTYPESRETURNS                        = "V2SigTestsResource_ResourceRequest_SIGResource_hasGetResponseContentTypesReturns";
   public final static String               V2SIGTESTSRESOURCE_RESOURCEREQUEST_SIGRESOURCE_IMPLEMENTSCLIENTDATAREQUEST                              = "V2SigTestsResource_ResourceRequest_SIGResource_implementsClientDataRequest";
   public final static String               V2SIGTESTSRESOURCE_RESOURCERESPONSE_SIGRESOURCE_FIELDHTTP_STATUS_CODE                                   = "V2SigTestsResource_ResourceResponse_SIGResource_fieldHTTP_STATUS_CODE";
   public final static String               V2SIGTESTSRESOURCE_RESOURCERESPONSE_SIGRESOURCE_HASCREATEACTIONURL                                      = "V2SigTestsResource_ResourceResponse_SIGResource_hasCreateActionURL";
   public final static String               V2SIGTESTSRESOURCE_RESOURCERESPONSE_SIGRESOURCE_HASCREATEACTIONURLRETURNS                               = "V2SigTestsResource_ResourceResponse_SIGResource_hasCreateActionURLReturns";
   public final static String               V2SIGTESTSRESOURCE_RESOURCERESPONSE_SIGRESOURCE_HASCREATERENDERURL                                      = "V2SigTestsResource_ResourceResponse_SIGResource_hasCreateRenderURL";
   public final static String               V2SIGTESTSRESOURCE_RESOURCERESPONSE_SIGRESOURCE_HASCREATERENDERURLRETURNS                               = "V2SigTestsResource_ResourceResponse_SIGResource_hasCreateRenderURLReturns";
   public final static String               V2SIGTESTSRESOURCE_RESOURCERESPONSE_SIGRESOURCE_HASCREATERESOURCEURL                                    = "V2SigTestsResource_ResourceResponse_SIGResource_hasCreateResourceURL";
   public final static String               V2SIGTESTSRESOURCE_RESOURCERESPONSE_SIGRESOURCE_HASCREATERESOURCEURLRETURNS                             = "V2SigTestsResource_ResourceResponse_SIGResource_hasCreateResourceURLReturns";
   public final static String               V2SIGTESTSRESOURCE_RESOURCERESPONSE_SIGRESOURCE_HASSETCHARACTERENCODING                                 = "V2SigTestsResource_ResourceResponse_SIGResource_hasSetCharacterEncoding";
   public final static String               V2SIGTESTSRESOURCE_RESOURCERESPONSE_SIGRESOURCE_HASSETCHARACTERENCODINGRETURNS                          = "V2SigTestsResource_ResourceResponse_SIGResource_hasSetCharacterEncodingReturns";
   public final static String               V2SIGTESTSRESOURCE_RESOURCERESPONSE_SIGRESOURCE_HASSETCONTENTLENGTH                                     = "V2SigTestsResource_ResourceResponse_SIGResource_hasSetContentLength";
   public final static String               V2SIGTESTSRESOURCE_RESOURCERESPONSE_SIGRESOURCE_HASSETCONTENTLENGTHRETURNS                              = "V2SigTestsResource_ResourceResponse_SIGResource_hasSetContentLengthReturns";
   public final static String               V2SIGTESTSRESOURCE_RESOURCERESPONSE_SIGRESOURCE_HASSETLOCALE                                            = "V2SigTestsResource_ResourceResponse_SIGResource_hasSetLocale";
   public final static String               V2SIGTESTSRESOURCE_RESOURCERESPONSE_SIGRESOURCE_HASSETLOCALERETURNS                                     = "V2SigTestsResource_ResourceResponse_SIGResource_hasSetLocaleReturns";
   public final static String               V2SIGTESTSRESOURCE_RESOURCERESPONSE_SIGRESOURCE_IMPLEMENTSMIMERESPONSE                                  = "V2SigTestsResource_ResourceResponse_SIGResource_implementsMimeResponse";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRENDERACTURL_HASADDPROPERTY                                                    = "V2SigTestsURL_BaseURL_SIGRenderActurl_hasAddProperty";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRENDERACTURL_HASADDPROPERTYRETURNS                                             = "V2SigTestsURL_BaseURL_SIGRenderActurl_hasAddPropertyReturns";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRENDERACTURL_HASGETPARAMETERMAP                                                = "V2SigTestsURL_BaseURL_SIGRenderActurl_hasGetParameterMap";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRENDERACTURL_HASGETPARAMETERMAPRETURNS                                         = "V2SigTestsURL_BaseURL_SIGRenderActurl_hasGetParameterMapReturns";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRENDERACTURL_HASSETPARAMETER                                                   = "V2SigTestsURL_BaseURL_SIGRenderActurl_hasSetParameter";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRENDERACTURL_HASSETPARAMETERA                                                  = "V2SigTestsURL_BaseURL_SIGRenderActurl_hasSetParameterA";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRENDERACTURL_HASSETPARAMETERRETURNS                                            = "V2SigTestsURL_BaseURL_SIGRenderActurl_hasSetParameterReturns";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRENDERACTURL_HASSETPARAMETERRETURNSA                                           = "V2SigTestsURL_BaseURL_SIGRenderActurl_hasSetParameterReturnsA";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRENDERACTURL_HASSETPARAMETERS                                                  = "V2SigTestsURL_BaseURL_SIGRenderActurl_hasSetParameters";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRENDERACTURL_HASSETPARAMETERSRETURNS                                           = "V2SigTestsURL_BaseURL_SIGRenderActurl_hasSetParametersReturns";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRENDERACTURL_HASSETPROPERTY                                                    = "V2SigTestsURL_BaseURL_SIGRenderActurl_hasSetProperty";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRENDERACTURL_HASSETPROPERTYRETURNS                                             = "V2SigTestsURL_BaseURL_SIGRenderActurl_hasSetPropertyReturns";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRENDERACTURL_HASSETSECURE                                                      = "V2SigTestsURL_BaseURL_SIGRenderActurl_hasSetSecure";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRENDERACTURL_HASSETSECURERETURNS                                               = "V2SigTestsURL_BaseURL_SIGRenderActurl_hasSetSecureReturns";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRENDERACTURL_HASTOSTRING                                                       = "V2SigTestsURL_BaseURL_SIGRenderActurl_hasToString";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRENDERACTURL_HASTOSTRINGRETURNS                                                = "V2SigTestsURL_BaseURL_SIGRenderActurl_hasToStringReturns";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRENDERACTURL_HASWRITE                                                          = "V2SigTestsURL_BaseURL_SIGRenderActurl_hasWrite";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRENDERACTURL_HASWRITEA                                                         = "V2SigTestsURL_BaseURL_SIGRenderActurl_hasWriteA";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRENDERACTURL_HASWRITERETURNS                                                   = "V2SigTestsURL_BaseURL_SIGRenderActurl_hasWriteReturns";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRENDERACTURL_HASWRITERETURNSA                                                  = "V2SigTestsURL_BaseURL_SIGRenderActurl_hasWriteReturnsA";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRENDERRENURL_HASADDPROPERTY                                                    = "V2SigTestsURL_BaseURL_SIGRenderRenurl_hasAddProperty";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRENDERRENURL_HASADDPROPERTYRETURNS                                             = "V2SigTestsURL_BaseURL_SIGRenderRenurl_hasAddPropertyReturns";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRENDERRENURL_HASGETPARAMETERMAP                                                = "V2SigTestsURL_BaseURL_SIGRenderRenurl_hasGetParameterMap";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRENDERRENURL_HASGETPARAMETERMAPRETURNS                                         = "V2SigTestsURL_BaseURL_SIGRenderRenurl_hasGetParameterMapReturns";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRENDERRENURL_HASSETPARAMETER                                                   = "V2SigTestsURL_BaseURL_SIGRenderRenurl_hasSetParameter";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRENDERRENURL_HASSETPARAMETERA                                                  = "V2SigTestsURL_BaseURL_SIGRenderRenurl_hasSetParameterA";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRENDERRENURL_HASSETPARAMETERRETURNS                                            = "V2SigTestsURL_BaseURL_SIGRenderRenurl_hasSetParameterReturns";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRENDERRENURL_HASSETPARAMETERRETURNSA                                           = "V2SigTestsURL_BaseURL_SIGRenderRenurl_hasSetParameterReturnsA";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRENDERRENURL_HASSETPARAMETERS                                                  = "V2SigTestsURL_BaseURL_SIGRenderRenurl_hasSetParameters";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRENDERRENURL_HASSETPARAMETERSRETURNS                                           = "V2SigTestsURL_BaseURL_SIGRenderRenurl_hasSetParametersReturns";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRENDERRENURL_HASSETPROPERTY                                                    = "V2SigTestsURL_BaseURL_SIGRenderRenurl_hasSetProperty";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRENDERRENURL_HASSETPROPERTYRETURNS                                             = "V2SigTestsURL_BaseURL_SIGRenderRenurl_hasSetPropertyReturns";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRENDERRENURL_HASSETSECURE                                                      = "V2SigTestsURL_BaseURL_SIGRenderRenurl_hasSetSecure";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRENDERRENURL_HASSETSECURERETURNS                                               = "V2SigTestsURL_BaseURL_SIGRenderRenurl_hasSetSecureReturns";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRENDERRENURL_HASTOSTRING                                                       = "V2SigTestsURL_BaseURL_SIGRenderRenurl_hasToString";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRENDERRENURL_HASTOSTRINGRETURNS                                                = "V2SigTestsURL_BaseURL_SIGRenderRenurl_hasToStringReturns";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRENDERRENURL_HASWRITE                                                          = "V2SigTestsURL_BaseURL_SIGRenderRenurl_hasWrite";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRENDERRENURL_HASWRITEA                                                         = "V2SigTestsURL_BaseURL_SIGRenderRenurl_hasWriteA";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRENDERRENURL_HASWRITERETURNS                                                   = "V2SigTestsURL_BaseURL_SIGRenderRenurl_hasWriteReturns";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRENDERRENURL_HASWRITERETURNSA                                                  = "V2SigTestsURL_BaseURL_SIGRenderRenurl_hasWriteReturnsA";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRENDERRESURL_HASADDPROPERTY                                                    = "V2SigTestsURL_BaseURL_SIGRenderResurl_hasAddProperty";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRENDERRESURL_HASADDPROPERTYRETURNS                                             = "V2SigTestsURL_BaseURL_SIGRenderResurl_hasAddPropertyReturns";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRENDERRESURL_HASGETPARAMETERMAP                                                = "V2SigTestsURL_BaseURL_SIGRenderResurl_hasGetParameterMap";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRENDERRESURL_HASGETPARAMETERMAPRETURNS                                         = "V2SigTestsURL_BaseURL_SIGRenderResurl_hasGetParameterMapReturns";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRENDERRESURL_HASSETPARAMETER                                                   = "V2SigTestsURL_BaseURL_SIGRenderResurl_hasSetParameter";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRENDERRESURL_HASSETPARAMETERA                                                  = "V2SigTestsURL_BaseURL_SIGRenderResurl_hasSetParameterA";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRENDERRESURL_HASSETPARAMETERRETURNS                                            = "V2SigTestsURL_BaseURL_SIGRenderResurl_hasSetParameterReturns";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRENDERRESURL_HASSETPARAMETERRETURNSA                                           = "V2SigTestsURL_BaseURL_SIGRenderResurl_hasSetParameterReturnsA";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRENDERRESURL_HASSETPARAMETERS                                                  = "V2SigTestsURL_BaseURL_SIGRenderResurl_hasSetParameters";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRENDERRESURL_HASSETPARAMETERSRETURNS                                           = "V2SigTestsURL_BaseURL_SIGRenderResurl_hasSetParametersReturns";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRENDERRESURL_HASSETPROPERTY                                                    = "V2SigTestsURL_BaseURL_SIGRenderResurl_hasSetProperty";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRENDERRESURL_HASSETPROPERTYRETURNS                                             = "V2SigTestsURL_BaseURL_SIGRenderResurl_hasSetPropertyReturns";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRENDERRESURL_HASSETSECURE                                                      = "V2SigTestsURL_BaseURL_SIGRenderResurl_hasSetSecure";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRENDERRESURL_HASSETSECURERETURNS                                               = "V2SigTestsURL_BaseURL_SIGRenderResurl_hasSetSecureReturns";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRENDERRESURL_HASTOSTRING                                                       = "V2SigTestsURL_BaseURL_SIGRenderResurl_hasToString";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRENDERRESURL_HASTOSTRINGRETURNS                                                = "V2SigTestsURL_BaseURL_SIGRenderResurl_hasToStringReturns";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRENDERRESURL_HASWRITE                                                          = "V2SigTestsURL_BaseURL_SIGRenderResurl_hasWrite";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRENDERRESURL_HASWRITEA                                                         = "V2SigTestsURL_BaseURL_SIGRenderResurl_hasWriteA";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRENDERRESURL_HASWRITERETURNS                                                   = "V2SigTestsURL_BaseURL_SIGRenderResurl_hasWriteReturns";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRENDERRESURL_HASWRITERETURNSA                                                  = "V2SigTestsURL_BaseURL_SIGRenderResurl_hasWriteReturnsA";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRESOURCEACTURL_HASADDPROPERTY                                                  = "V2SigTestsURL_BaseURL_SIGResourceActurl_hasAddProperty";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRESOURCEACTURL_HASADDPROPERTYRETURNS                                           = "V2SigTestsURL_BaseURL_SIGResourceActurl_hasAddPropertyReturns";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRESOURCEACTURL_HASGETPARAMETERMAP                                              = "V2SigTestsURL_BaseURL_SIGResourceActurl_hasGetParameterMap";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRESOURCEACTURL_HASGETPARAMETERMAPRETURNS                                       = "V2SigTestsURL_BaseURL_SIGResourceActurl_hasGetParameterMapReturns";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRESOURCEACTURL_HASSETPARAMETER                                                 = "V2SigTestsURL_BaseURL_SIGResourceActurl_hasSetParameter";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRESOURCEACTURL_HASSETPARAMETERA                                                = "V2SigTestsURL_BaseURL_SIGResourceActurl_hasSetParameterA";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRESOURCEACTURL_HASSETPARAMETERRETURNS                                          = "V2SigTestsURL_BaseURL_SIGResourceActurl_hasSetParameterReturns";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRESOURCEACTURL_HASSETPARAMETERRETURNSA                                         = "V2SigTestsURL_BaseURL_SIGResourceActurl_hasSetParameterReturnsA";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRESOURCEACTURL_HASSETPARAMETERS                                                = "V2SigTestsURL_BaseURL_SIGResourceActurl_hasSetParameters";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRESOURCEACTURL_HASSETPARAMETERSRETURNS                                         = "V2SigTestsURL_BaseURL_SIGResourceActurl_hasSetParametersReturns";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRESOURCEACTURL_HASSETPROPERTY                                                  = "V2SigTestsURL_BaseURL_SIGResourceActurl_hasSetProperty";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRESOURCEACTURL_HASSETPROPERTYRETURNS                                           = "V2SigTestsURL_BaseURL_SIGResourceActurl_hasSetPropertyReturns";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRESOURCEACTURL_HASSETSECURE                                                    = "V2SigTestsURL_BaseURL_SIGResourceActurl_hasSetSecure";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRESOURCEACTURL_HASSETSECURERETURNS                                             = "V2SigTestsURL_BaseURL_SIGResourceActurl_hasSetSecureReturns";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRESOURCEACTURL_HASTOSTRING                                                     = "V2SigTestsURL_BaseURL_SIGResourceActurl_hasToString";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRESOURCEACTURL_HASTOSTRINGRETURNS                                              = "V2SigTestsURL_BaseURL_SIGResourceActurl_hasToStringReturns";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRESOURCEACTURL_HASWRITE                                                        = "V2SigTestsURL_BaseURL_SIGResourceActurl_hasWrite";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRESOURCEACTURL_HASWRITEA                                                       = "V2SigTestsURL_BaseURL_SIGResourceActurl_hasWriteA";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRESOURCEACTURL_HASWRITERETURNS                                                 = "V2SigTestsURL_BaseURL_SIGResourceActurl_hasWriteReturns";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRESOURCEACTURL_HASWRITERETURNSA                                                = "V2SigTestsURL_BaseURL_SIGResourceActurl_hasWriteReturnsA";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRESOURCERENURL_HASADDPROPERTY                                                  = "V2SigTestsURL_BaseURL_SIGResourceRenurl_hasAddProperty";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRESOURCERENURL_HASADDPROPERTYRETURNS                                           = "V2SigTestsURL_BaseURL_SIGResourceRenurl_hasAddPropertyReturns";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRESOURCERENURL_HASGETPARAMETERMAP                                              = "V2SigTestsURL_BaseURL_SIGResourceRenurl_hasGetParameterMap";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRESOURCERENURL_HASGETPARAMETERMAPRETURNS                                       = "V2SigTestsURL_BaseURL_SIGResourceRenurl_hasGetParameterMapReturns";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRESOURCERENURL_HASSETPARAMETER                                                 = "V2SigTestsURL_BaseURL_SIGResourceRenurl_hasSetParameter";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRESOURCERENURL_HASSETPARAMETERA                                                = "V2SigTestsURL_BaseURL_SIGResourceRenurl_hasSetParameterA";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRESOURCERENURL_HASSETPARAMETERRETURNS                                          = "V2SigTestsURL_BaseURL_SIGResourceRenurl_hasSetParameterReturns";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRESOURCERENURL_HASSETPARAMETERRETURNSA                                         = "V2SigTestsURL_BaseURL_SIGResourceRenurl_hasSetParameterReturnsA";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRESOURCERENURL_HASSETPARAMETERS                                                = "V2SigTestsURL_BaseURL_SIGResourceRenurl_hasSetParameters";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRESOURCERENURL_HASSETPARAMETERSRETURNS                                         = "V2SigTestsURL_BaseURL_SIGResourceRenurl_hasSetParametersReturns";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRESOURCERENURL_HASSETPROPERTY                                                  = "V2SigTestsURL_BaseURL_SIGResourceRenurl_hasSetProperty";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRESOURCERENURL_HASSETPROPERTYRETURNS                                           = "V2SigTestsURL_BaseURL_SIGResourceRenurl_hasSetPropertyReturns";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRESOURCERENURL_HASSETSECURE                                                    = "V2SigTestsURL_BaseURL_SIGResourceRenurl_hasSetSecure";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRESOURCERENURL_HASSETSECURERETURNS                                             = "V2SigTestsURL_BaseURL_SIGResourceRenurl_hasSetSecureReturns";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRESOURCERENURL_HASTOSTRING                                                     = "V2SigTestsURL_BaseURL_SIGResourceRenurl_hasToString";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRESOURCERENURL_HASTOSTRINGRETURNS                                              = "V2SigTestsURL_BaseURL_SIGResourceRenurl_hasToStringReturns";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRESOURCERENURL_HASWRITE                                                        = "V2SigTestsURL_BaseURL_SIGResourceRenurl_hasWrite";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRESOURCERENURL_HASWRITEA                                                       = "V2SigTestsURL_BaseURL_SIGResourceRenurl_hasWriteA";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRESOURCERENURL_HASWRITERETURNS                                                 = "V2SigTestsURL_BaseURL_SIGResourceRenurl_hasWriteReturns";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRESOURCERENURL_HASWRITERETURNSA                                                = "V2SigTestsURL_BaseURL_SIGResourceRenurl_hasWriteReturnsA";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRESOURCERESURL_HASADDPROPERTY                                                  = "V2SigTestsURL_BaseURL_SIGResourceResurl_hasAddProperty";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRESOURCERESURL_HASADDPROPERTYRETURNS                                           = "V2SigTestsURL_BaseURL_SIGResourceResurl_hasAddPropertyReturns";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRESOURCERESURL_HASGETPARAMETERMAP                                              = "V2SigTestsURL_BaseURL_SIGResourceResurl_hasGetParameterMap";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRESOURCERESURL_HASGETPARAMETERMAPRETURNS                                       = "V2SigTestsURL_BaseURL_SIGResourceResurl_hasGetParameterMapReturns";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRESOURCERESURL_HASSETPARAMETER                                                 = "V2SigTestsURL_BaseURL_SIGResourceResurl_hasSetParameter";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRESOURCERESURL_HASSETPARAMETERA                                                = "V2SigTestsURL_BaseURL_SIGResourceResurl_hasSetParameterA";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRESOURCERESURL_HASSETPARAMETERRETURNS                                          = "V2SigTestsURL_BaseURL_SIGResourceResurl_hasSetParameterReturns";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRESOURCERESURL_HASSETPARAMETERRETURNSA                                         = "V2SigTestsURL_BaseURL_SIGResourceResurl_hasSetParameterReturnsA";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRESOURCERESURL_HASSETPARAMETERS                                                = "V2SigTestsURL_BaseURL_SIGResourceResurl_hasSetParameters";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRESOURCERESURL_HASSETPARAMETERSRETURNS                                         = "V2SigTestsURL_BaseURL_SIGResourceResurl_hasSetParametersReturns";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRESOURCERESURL_HASSETPROPERTY                                                  = "V2SigTestsURL_BaseURL_SIGResourceResurl_hasSetProperty";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRESOURCERESURL_HASSETPROPERTYRETURNS                                           = "V2SigTestsURL_BaseURL_SIGResourceResurl_hasSetPropertyReturns";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRESOURCERESURL_HASSETSECURE                                                    = "V2SigTestsURL_BaseURL_SIGResourceResurl_hasSetSecure";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRESOURCERESURL_HASSETSECURERETURNS                                             = "V2SigTestsURL_BaseURL_SIGResourceResurl_hasSetSecureReturns";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRESOURCERESURL_HASTOSTRING                                                     = "V2SigTestsURL_BaseURL_SIGResourceResurl_hasToString";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRESOURCERESURL_HASTOSTRINGRETURNS                                              = "V2SigTestsURL_BaseURL_SIGResourceResurl_hasToStringReturns";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRESOURCERESURL_HASWRITE                                                        = "V2SigTestsURL_BaseURL_SIGResourceResurl_hasWrite";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRESOURCERESURL_HASWRITEA                                                       = "V2SigTestsURL_BaseURL_SIGResourceResurl_hasWriteA";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRESOURCERESURL_HASWRITERETURNS                                                 = "V2SigTestsURL_BaseURL_SIGResourceResurl_hasWriteReturns";
   public final static String               V2SIGTESTSURL_BASEURL_SIGRESOURCERESURL_HASWRITERETURNSA                                                = "V2SigTestsURL_BaseURL_SIGResourceResurl_hasWriteReturnsA";
   public final static String               V2SIGTESTSURL_PORTLETURL_SIGRENDERACTURL_HASGETPORTLETMODE                                              = "V2SigTestsURL_PortletURL_SIGRenderActurl_hasGetPortletMode";
   public final static String               V2SIGTESTSURL_PORTLETURL_SIGRENDERACTURL_HASGETPORTLETMODERETURNS                                       = "V2SigTestsURL_PortletURL_SIGRenderActurl_hasGetPortletModeReturns";
   public final static String               V2SIGTESTSURL_PORTLETURL_SIGRENDERACTURL_HASGETWINDOWSTATE                                              = "V2SigTestsURL_PortletURL_SIGRenderActurl_hasGetWindowState";
   public final static String               V2SIGTESTSURL_PORTLETURL_SIGRENDERACTURL_HASGETWINDOWSTATERETURNS                                       = "V2SigTestsURL_PortletURL_SIGRenderActurl_hasGetWindowStateReturns";
   public final static String               V2SIGTESTSURL_PORTLETURL_SIGRENDERACTURL_HASREMOVEPUBLICRENDERPARAMETER                                 = "V2SigTestsURL_PortletURL_SIGRenderActurl_hasRemovePublicRenderParameter";
   public final static String               V2SIGTESTSURL_PORTLETURL_SIGRENDERACTURL_HASREMOVEPUBLICRENDERPARAMETERRETURNS                          = "V2SigTestsURL_PortletURL_SIGRenderActurl_hasRemovePublicRenderParameterReturns";
   public final static String               V2SIGTESTSURL_PORTLETURL_SIGRENDERACTURL_HASSETPORTLETMODE                                              = "V2SigTestsURL_PortletURL_SIGRenderActurl_hasSetPortletMode";
   public final static String               V2SIGTESTSURL_PORTLETURL_SIGRENDERACTURL_HASSETPORTLETMODERETURNS                                       = "V2SigTestsURL_PortletURL_SIGRenderActurl_hasSetPortletModeReturns";
   public final static String               V2SIGTESTSURL_PORTLETURL_SIGRENDERACTURL_HASSETWINDOWSTATE                                              = "V2SigTestsURL_PortletURL_SIGRenderActurl_hasSetWindowState";
   public final static String               V2SIGTESTSURL_PORTLETURL_SIGRENDERACTURL_HASSETWINDOWSTATERETURNS                                       = "V2SigTestsURL_PortletURL_SIGRenderActurl_hasSetWindowStateReturns";
   public final static String               V2SIGTESTSURL_PORTLETURL_SIGRENDERACTURL_IMPLEMENTSBASEURL                                              = "V2SigTestsURL_PortletURL_SIGRenderActurl_implementsBaseURL";
   public final static String               V2SIGTESTSURL_PORTLETURL_SIGRENDERRENURL_HASGETPORTLETMODE                                              = "V2SigTestsURL_PortletURL_SIGRenderRenurl_hasGetPortletMode";
   public final static String               V2SIGTESTSURL_PORTLETURL_SIGRENDERRENURL_HASGETPORTLETMODERETURNS                                       = "V2SigTestsURL_PortletURL_SIGRenderRenurl_hasGetPortletModeReturns";
   public final static String               V2SIGTESTSURL_PORTLETURL_SIGRENDERRENURL_HASGETWINDOWSTATE                                              = "V2SigTestsURL_PortletURL_SIGRenderRenurl_hasGetWindowState";
   public final static String               V2SIGTESTSURL_PORTLETURL_SIGRENDERRENURL_HASGETWINDOWSTATERETURNS                                       = "V2SigTestsURL_PortletURL_SIGRenderRenurl_hasGetWindowStateReturns";
   public final static String               V2SIGTESTSURL_PORTLETURL_SIGRENDERRENURL_HASREMOVEPUBLICRENDERPARAMETER                                 = "V2SigTestsURL_PortletURL_SIGRenderRenurl_hasRemovePublicRenderParameter";
   public final static String               V2SIGTESTSURL_PORTLETURL_SIGRENDERRENURL_HASREMOVEPUBLICRENDERPARAMETERRETURNS                          = "V2SigTestsURL_PortletURL_SIGRenderRenurl_hasRemovePublicRenderParameterReturns";
   public final static String               V2SIGTESTSURL_PORTLETURL_SIGRENDERRENURL_HASSETPORTLETMODE                                              = "V2SigTestsURL_PortletURL_SIGRenderRenurl_hasSetPortletMode";
   public final static String               V2SIGTESTSURL_PORTLETURL_SIGRENDERRENURL_HASSETPORTLETMODERETURNS                                       = "V2SigTestsURL_PortletURL_SIGRenderRenurl_hasSetPortletModeReturns";
   public final static String               V2SIGTESTSURL_PORTLETURL_SIGRENDERRENURL_HASSETWINDOWSTATE                                              = "V2SigTestsURL_PortletURL_SIGRenderRenurl_hasSetWindowState";
   public final static String               V2SIGTESTSURL_PORTLETURL_SIGRENDERRENURL_HASSETWINDOWSTATERETURNS                                       = "V2SigTestsURL_PortletURL_SIGRenderRenurl_hasSetWindowStateReturns";
   public final static String               V2SIGTESTSURL_PORTLETURL_SIGRENDERRENURL_IMPLEMENTSBASEURL                                              = "V2SigTestsURL_PortletURL_SIGRenderRenurl_implementsBaseURL";
   public final static String               V2SIGTESTSURL_PORTLETURL_SIGRESOURCEACTURL_HASGETPORTLETMODE                                            = "V2SigTestsURL_PortletURL_SIGResourceActurl_hasGetPortletMode";
   public final static String               V2SIGTESTSURL_PORTLETURL_SIGRESOURCEACTURL_HASGETPORTLETMODERETURNS                                     = "V2SigTestsURL_PortletURL_SIGResourceActurl_hasGetPortletModeReturns";
   public final static String               V2SIGTESTSURL_PORTLETURL_SIGRESOURCEACTURL_HASGETWINDOWSTATE                                            = "V2SigTestsURL_PortletURL_SIGResourceActurl_hasGetWindowState";
   public final static String               V2SIGTESTSURL_PORTLETURL_SIGRESOURCEACTURL_HASGETWINDOWSTATERETURNS                                     = "V2SigTestsURL_PortletURL_SIGResourceActurl_hasGetWindowStateReturns";
   public final static String               V2SIGTESTSURL_PORTLETURL_SIGRESOURCEACTURL_HASREMOVEPUBLICRENDERPARAMETER                               = "V2SigTestsURL_PortletURL_SIGResourceActurl_hasRemovePublicRenderParameter";
   public final static String               V2SIGTESTSURL_PORTLETURL_SIGRESOURCEACTURL_HASREMOVEPUBLICRENDERPARAMETERRETURNS                        = "V2SigTestsURL_PortletURL_SIGResourceActurl_hasRemovePublicRenderParameterReturns";
   public final static String               V2SIGTESTSURL_PORTLETURL_SIGRESOURCEACTURL_HASSETPORTLETMODE                                            = "V2SigTestsURL_PortletURL_SIGResourceActurl_hasSetPortletMode";
   public final static String               V2SIGTESTSURL_PORTLETURL_SIGRESOURCEACTURL_HASSETPORTLETMODERETURNS                                     = "V2SigTestsURL_PortletURL_SIGResourceActurl_hasSetPortletModeReturns";
   public final static String               V2SIGTESTSURL_PORTLETURL_SIGRESOURCEACTURL_HASSETWINDOWSTATE                                            = "V2SigTestsURL_PortletURL_SIGResourceActurl_hasSetWindowState";
   public final static String               V2SIGTESTSURL_PORTLETURL_SIGRESOURCEACTURL_HASSETWINDOWSTATERETURNS                                     = "V2SigTestsURL_PortletURL_SIGResourceActurl_hasSetWindowStateReturns";
   public final static String               V2SIGTESTSURL_PORTLETURL_SIGRESOURCEACTURL_IMPLEMENTSBASEURL                                            = "V2SigTestsURL_PortletURL_SIGResourceActurl_implementsBaseURL";
   public final static String               V2SIGTESTSURL_PORTLETURL_SIGRESOURCERENURL_HASGETPORTLETMODE                                            = "V2SigTestsURL_PortletURL_SIGResourceRenurl_hasGetPortletMode";
   public final static String               V2SIGTESTSURL_PORTLETURL_SIGRESOURCERENURL_HASGETPORTLETMODERETURNS                                     = "V2SigTestsURL_PortletURL_SIGResourceRenurl_hasGetPortletModeReturns";
   public final static String               V2SIGTESTSURL_PORTLETURL_SIGRESOURCERENURL_HASGETWINDOWSTATE                                            = "V2SigTestsURL_PortletURL_SIGResourceRenurl_hasGetWindowState";
   public final static String               V2SIGTESTSURL_PORTLETURL_SIGRESOURCERENURL_HASGETWINDOWSTATERETURNS                                     = "V2SigTestsURL_PortletURL_SIGResourceRenurl_hasGetWindowStateReturns";
   public final static String               V2SIGTESTSURL_PORTLETURL_SIGRESOURCERENURL_HASREMOVEPUBLICRENDERPARAMETER                               = "V2SigTestsURL_PortletURL_SIGResourceRenurl_hasRemovePublicRenderParameter";
   public final static String               V2SIGTESTSURL_PORTLETURL_SIGRESOURCERENURL_HASREMOVEPUBLICRENDERPARAMETERRETURNS                        = "V2SigTestsURL_PortletURL_SIGResourceRenurl_hasRemovePublicRenderParameterReturns";
   public final static String               V2SIGTESTSURL_PORTLETURL_SIGRESOURCERENURL_HASSETPORTLETMODE                                            = "V2SigTestsURL_PortletURL_SIGResourceRenurl_hasSetPortletMode";
   public final static String               V2SIGTESTSURL_PORTLETURL_SIGRESOURCERENURL_HASSETPORTLETMODERETURNS                                     = "V2SigTestsURL_PortletURL_SIGResourceRenurl_hasSetPortletModeReturns";
   public final static String               V2SIGTESTSURL_PORTLETURL_SIGRESOURCERENURL_HASSETWINDOWSTATE                                            = "V2SigTestsURL_PortletURL_SIGResourceRenurl_hasSetWindowState";
   public final static String               V2SIGTESTSURL_PORTLETURL_SIGRESOURCERENURL_HASSETWINDOWSTATERETURNS                                     = "V2SigTestsURL_PortletURL_SIGResourceRenurl_hasSetWindowStateReturns";
   public final static String               V2SIGTESTSURL_PORTLETURL_SIGRESOURCERENURL_IMPLEMENTSBASEURL                                            = "V2SigTestsURL_PortletURL_SIGResourceRenurl_implementsBaseURL";
   public final static String               V2SIGTESTSURL_RESOURCEURL_SIGRENDER_FIELDFULL                                                           = "V2SigTestsURL_ResourceURL_SIGRender_fieldFULL";
   public final static String               V2SIGTESTSURL_RESOURCEURL_SIGRENDER_FIELDPAGE                                                           = "V2SigTestsURL_ResourceURL_SIGRender_fieldPAGE";
   public final static String               V2SIGTESTSURL_RESOURCEURL_SIGRENDER_FIELDPORTLET                                                        = "V2SigTestsURL_ResourceURL_SIGRender_fieldPORTLET";
   public final static String               V2SIGTESTSURL_RESOURCEURL_SIGRENDER_FIELDSHARED                                                         = "V2SigTestsURL_ResourceURL_SIGRender_fieldSHARED";
   public final static String               V2SIGTESTSURL_RESOURCEURL_SIGRENDER_HASGETCACHEABILITY                                                  = "V2SigTestsURL_ResourceURL_SIGRender_hasGetCacheability";
   public final static String               V2SIGTESTSURL_RESOURCEURL_SIGRENDER_HASGETCACHEABILITYRETURNS                                           = "V2SigTestsURL_ResourceURL_SIGRender_hasGetCacheabilityReturns";
   public final static String               V2SIGTESTSURL_RESOURCEURL_SIGRENDER_HASSETCACHEABILITY                                                  = "V2SigTestsURL_ResourceURL_SIGRender_hasSetCacheability";
   public final static String               V2SIGTESTSURL_RESOURCEURL_SIGRENDER_HASSETCACHEABILITYRETURNS                                           = "V2SigTestsURL_ResourceURL_SIGRender_hasSetCacheabilityReturns";
   public final static String               V2SIGTESTSURL_RESOURCEURL_SIGRENDER_HASSETRESOURCEID                                                    = "V2SigTestsURL_ResourceURL_SIGRender_hasSetResourceID";
   public final static String               V2SIGTESTSURL_RESOURCEURL_SIGRENDER_HASSETRESOURCEIDRETURNS                                             = "V2SigTestsURL_ResourceURL_SIGRender_hasSetResourceIDReturns";
   public final static String               V2SIGTESTSURL_RESOURCEURL_SIGRENDER_IMPLEMENTSBASEURL                                                   = "V2SigTestsURL_ResourceURL_SIGRender_implementsBaseURL";
   public final static String               V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_CONSTRUCTOR                                            = "V2SigTestsWrapper_ActionRequestWrapper_SIGRender_constructor";
   public final static String               V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_EXTENDSPORTLETREQUESTWRAPPER                           = "V2SigTestsWrapper_ActionRequestWrapper_SIGRender_extendsPortletRequestWrapper";
   public final static String               V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASGETCHARACTERENCODING                                = "V2SigTestsWrapper_ActionRequestWrapper_SIGRender_hasGetCharacterEncoding";
   public final static String               V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASGETCHARACTERENCODINGRETURNS                         = "V2SigTestsWrapper_ActionRequestWrapper_SIGRender_hasGetCharacterEncodingReturns";
   public final static String               V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASGETCONTENTLENGTH                                    = "V2SigTestsWrapper_ActionRequestWrapper_SIGRender_hasGetContentLength";
   public final static String               V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASGETCONTENTLENGTHRETURNS                             = "V2SigTestsWrapper_ActionRequestWrapper_SIGRender_hasGetContentLengthReturns";
   public final static String               V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASGETCONTENTTYPE                                      = "V2SigTestsWrapper_ActionRequestWrapper_SIGRender_hasGetContentType";
   public final static String               V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASGETCONTENTTYPERETURNS                               = "V2SigTestsWrapper_ActionRequestWrapper_SIGRender_hasGetContentTypeReturns";
   public final static String               V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASGETMETHOD                                           = "V2SigTestsWrapper_ActionRequestWrapper_SIGRender_hasGetMethod";
   public final static String               V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASGETMETHODRETURNS                                    = "V2SigTestsWrapper_ActionRequestWrapper_SIGRender_hasGetMethodReturns";
   public final static String               V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASGETPORTLETINPUTSTREAM                               = "V2SigTestsWrapper_ActionRequestWrapper_SIGRender_hasGetPortletInputStream";
   public final static String               V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASGETPORTLETINPUTSTREAMRETURNS                        = "V2SigTestsWrapper_ActionRequestWrapper_SIGRender_hasGetPortletInputStreamReturns";
   public final static String               V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASGETREADER                                           = "V2SigTestsWrapper_ActionRequestWrapper_SIGRender_hasGetReader";
   public final static String               V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASGETREADERRETURNS                                    = "V2SigTestsWrapper_ActionRequestWrapper_SIGRender_hasGetReaderReturns";
   public final static String               V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASGETREQUEST                                          = "V2SigTestsWrapper_ActionRequestWrapper_SIGRender_hasGetRequest";
   public final static String               V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASGETREQUESTA                                         = "V2SigTestsWrapper_ActionRequestWrapper_SIGRender_hasGetRequestA";
   public final static String               V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASGETREQUESTRETURNS                                   = "V2SigTestsWrapper_ActionRequestWrapper_SIGRender_hasGetRequestReturns";
   public final static String               V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASGETREQUESTRETURNSA                                  = "V2SigTestsWrapper_ActionRequestWrapper_SIGRender_hasGetRequestReturnsA";
   public final static String               V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASSETCHARACTERENCODING                                = "V2SigTestsWrapper_ActionRequestWrapper_SIGRender_hasSetCharacterEncoding";
   public final static String               V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASSETCHARACTERENCODINGRETURNS                         = "V2SigTestsWrapper_ActionRequestWrapper_SIGRender_hasSetCharacterEncodingReturns";
   public final static String               V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASSETREQUEST                                          = "V2SigTestsWrapper_ActionRequestWrapper_SIGRender_hasSetRequest";
   public final static String               V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASSETREQUESTRETURNS                                   = "V2SigTestsWrapper_ActionRequestWrapper_SIGRender_hasSetRequestReturns";
   public final static String               V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_IMPLEMENTSACTIONREQUEST                                = "V2SigTestsWrapper_ActionRequestWrapper_SIGRender_implementsActionRequest";
   public final static String               V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_CONSTRUCTOR                                           = "V2SigTestsWrapper_ActionResponseWrapper_SIGRender_constructor";
   public final static String               V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_EXTENDSPORTLETRESPONSEWRAPPER                         = "V2SigTestsWrapper_ActionResponseWrapper_SIGRender_extendsPortletResponseWrapper";
   public final static String               V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASGETPORTLETMODE                                     = "V2SigTestsWrapper_ActionResponseWrapper_SIGRender_hasGetPortletMode";
   public final static String               V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASGETPORTLETMODERETURNS                              = "V2SigTestsWrapper_ActionResponseWrapper_SIGRender_hasGetPortletModeReturns";
   public final static String               V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASGETRENDERPARAMETERMAP                              = "V2SigTestsWrapper_ActionResponseWrapper_SIGRender_hasGetRenderParameterMap";
   public final static String               V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASGETRENDERPARAMETERMAPRETURNS                       = "V2SigTestsWrapper_ActionResponseWrapper_SIGRender_hasGetRenderParameterMapReturns";
   public final static String               V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASGETRESPONSE                                        = "V2SigTestsWrapper_ActionResponseWrapper_SIGRender_hasGetResponse";
   public final static String               V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASGETRESPONSEA                                       = "V2SigTestsWrapper_ActionResponseWrapper_SIGRender_hasGetResponseA";
   public final static String               V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASGETRESPONSERETURNS                                 = "V2SigTestsWrapper_ActionResponseWrapper_SIGRender_hasGetResponseReturns";
   public final static String               V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASGETRESPONSERETURNSA                                = "V2SigTestsWrapper_ActionResponseWrapper_SIGRender_hasGetResponseReturnsA";
   public final static String               V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASGETWINDOWSTATE                                     = "V2SigTestsWrapper_ActionResponseWrapper_SIGRender_hasGetWindowState";
   public final static String               V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASGETWINDOWSTATERETURNS                              = "V2SigTestsWrapper_ActionResponseWrapper_SIGRender_hasGetWindowStateReturns";
   public final static String               V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASREMOVEPUBLICRENDERPARAMETER                        = "V2SigTestsWrapper_ActionResponseWrapper_SIGRender_hasRemovePublicRenderParameter";
   public final static String               V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASREMOVEPUBLICRENDERPARAMETERRETURNS                 = "V2SigTestsWrapper_ActionResponseWrapper_SIGRender_hasRemovePublicRenderParameterReturns";
   public final static String               V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSENDREDIRECT                                       = "V2SigTestsWrapper_ActionResponseWrapper_SIGRender_hasSendRedirect";
   public final static String               V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSENDREDIRECTA                                      = "V2SigTestsWrapper_ActionResponseWrapper_SIGRender_hasSendRedirectA";
   public final static String               V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSENDREDIRECTRETURNS                                = "V2SigTestsWrapper_ActionResponseWrapper_SIGRender_hasSendRedirectReturns";
   public final static String               V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSENDREDIRECTRETURNSA                               = "V2SigTestsWrapper_ActionResponseWrapper_SIGRender_hasSendRedirectReturnsA";
   public final static String               V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSETEVENT                                           = "V2SigTestsWrapper_ActionResponseWrapper_SIGRender_hasSetEvent";
   public final static String               V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSETEVENTA                                          = "V2SigTestsWrapper_ActionResponseWrapper_SIGRender_hasSetEventA";
   public final static String               V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSETEVENTRETURNS                                    = "V2SigTestsWrapper_ActionResponseWrapper_SIGRender_hasSetEventReturns";
   public final static String               V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSETEVENTRETURNSA                                   = "V2SigTestsWrapper_ActionResponseWrapper_SIGRender_hasSetEventReturnsA";
   public final static String               V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSETPORTLETMODE                                     = "V2SigTestsWrapper_ActionResponseWrapper_SIGRender_hasSetPortletMode";
   public final static String               V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSETPORTLETMODERETURNS                              = "V2SigTestsWrapper_ActionResponseWrapper_SIGRender_hasSetPortletModeReturns";
   public final static String               V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSETRENDERPARAMETER                                 = "V2SigTestsWrapper_ActionResponseWrapper_SIGRender_hasSetRenderParameter";
   public final static String               V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSETRENDERPARAMETERA                                = "V2SigTestsWrapper_ActionResponseWrapper_SIGRender_hasSetRenderParameterA";
   public final static String               V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSETRENDERPARAMETERRETURNS                          = "V2SigTestsWrapper_ActionResponseWrapper_SIGRender_hasSetRenderParameterReturns";
   public final static String               V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSETRENDERPARAMETERRETURNSA                         = "V2SigTestsWrapper_ActionResponseWrapper_SIGRender_hasSetRenderParameterReturnsA";
   public final static String               V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSETRENDERPARAMETERS                                = "V2SigTestsWrapper_ActionResponseWrapper_SIGRender_hasSetRenderParameters";
   public final static String               V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSETRENDERPARAMETERSRETURNS                         = "V2SigTestsWrapper_ActionResponseWrapper_SIGRender_hasSetRenderParametersReturns";
   public final static String               V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSETRESPONSE                                        = "V2SigTestsWrapper_ActionResponseWrapper_SIGRender_hasSetResponse";
   public final static String               V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSETRESPONSERETURNS                                 = "V2SigTestsWrapper_ActionResponseWrapper_SIGRender_hasSetResponseReturns";
   public final static String               V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSETWINDOWSTATE                                     = "V2SigTestsWrapper_ActionResponseWrapper_SIGRender_hasSetWindowState";
   public final static String               V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSETWINDOWSTATERETURNS                              = "V2SigTestsWrapper_ActionResponseWrapper_SIGRender_hasSetWindowStateReturns";
   public final static String               V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_IMPLEMENTSACTIONRESPONSE                              = "V2SigTestsWrapper_ActionResponseWrapper_SIGRender_implementsActionResponse";
   public final static String               V2SIGTESTSWRAPPER_EVENTREQUESTWRAPPER_SIGRENDER_CONSTRUCTOR                                             = "V2SigTestsWrapper_EventRequestWrapper_SIGRender_constructor";
   public final static String               V2SIGTESTSWRAPPER_EVENTREQUESTWRAPPER_SIGRENDER_EXTENDSPORTLETREQUESTWRAPPER                            = "V2SigTestsWrapper_EventRequestWrapper_SIGRender_extendsPortletRequestWrapper";
   public final static String               V2SIGTESTSWRAPPER_EVENTREQUESTWRAPPER_SIGRENDER_HASGETEVENT                                             = "V2SigTestsWrapper_EventRequestWrapper_SIGRender_hasGetEvent";
   public final static String               V2SIGTESTSWRAPPER_EVENTREQUESTWRAPPER_SIGRENDER_HASGETEVENTRETURNS                                      = "V2SigTestsWrapper_EventRequestWrapper_SIGRender_hasGetEventReturns";
   public final static String               V2SIGTESTSWRAPPER_EVENTREQUESTWRAPPER_SIGRENDER_HASGETMETHOD                                            = "V2SigTestsWrapper_EventRequestWrapper_SIGRender_hasGetMethod";
   public final static String               V2SIGTESTSWRAPPER_EVENTREQUESTWRAPPER_SIGRENDER_HASGETMETHODRETURNS                                     = "V2SigTestsWrapper_EventRequestWrapper_SIGRender_hasGetMethodReturns";
   public final static String               V2SIGTESTSWRAPPER_EVENTREQUESTWRAPPER_SIGRENDER_HASGETREQUEST                                           = "V2SigTestsWrapper_EventRequestWrapper_SIGRender_hasGetRequest";
   public final static String               V2SIGTESTSWRAPPER_EVENTREQUESTWRAPPER_SIGRENDER_HASGETREQUESTA                                          = "V2SigTestsWrapper_EventRequestWrapper_SIGRender_hasGetRequestA";
   public final static String               V2SIGTESTSWRAPPER_EVENTREQUESTWRAPPER_SIGRENDER_HASGETREQUESTRETURNS                                    = "V2SigTestsWrapper_EventRequestWrapper_SIGRender_hasGetRequestReturns";
   public final static String               V2SIGTESTSWRAPPER_EVENTREQUESTWRAPPER_SIGRENDER_HASGETREQUESTRETURNSA                                   = "V2SigTestsWrapper_EventRequestWrapper_SIGRender_hasGetRequestReturnsA";
   public final static String               V2SIGTESTSWRAPPER_EVENTREQUESTWRAPPER_SIGRENDER_HASSETREQUEST                                           = "V2SigTestsWrapper_EventRequestWrapper_SIGRender_hasSetRequest";
   public final static String               V2SIGTESTSWRAPPER_EVENTREQUESTWRAPPER_SIGRENDER_HASSETREQUESTRETURNS                                    = "V2SigTestsWrapper_EventRequestWrapper_SIGRender_hasSetRequestReturns";
   public final static String               V2SIGTESTSWRAPPER_EVENTREQUESTWRAPPER_SIGRENDER_IMPLEMENTSEVENTREQUEST                                  = "V2SigTestsWrapper_EventRequestWrapper_SIGRender_implementsEventRequest";
   public final static String               V2SIGTESTSWRAPPER_EVENTRESPONSEWRAPPER_SIGRENDER_CONSTRUCTOR                                            = "V2SigTestsWrapper_EventResponseWrapper_SIGRender_constructor";
   public final static String               V2SIGTESTSWRAPPER_EVENTRESPONSEWRAPPER_SIGRENDER_EXTENDSPORTLETRESPONSEWRAPPER                          = "V2SigTestsWrapper_EventResponseWrapper_SIGRender_extendsPortletResponseWrapper";
   public final static String               V2SIGTESTSWRAPPER_EVENTRESPONSEWRAPPER_SIGRENDER_HASGETPORTLETMODE                                      = "V2SigTestsWrapper_EventResponseWrapper_SIGRender_hasGetPortletMode";
   public final static String               V2SIGTESTSWRAPPER_EVENTRESPONSEWRAPPER_SIGRENDER_HASGETPORTLETMODERETURNS                               = "V2SigTestsWrapper_EventResponseWrapper_SIGRender_hasGetPortletModeReturns";
   public final static String               V2SIGTESTSWRAPPER_EVENTRESPONSEWRAPPER_SIGRENDER_HASGETRENDERPARAMETERMAP                               = "V2SigTestsWrapper_EventResponseWrapper_SIGRender_hasGetRenderParameterMap";
   public final static String               V2SIGTESTSWRAPPER_EVENTRESPONSEWRAPPER_SIGRENDER_HASGETRENDERPARAMETERMAPRETURNS                        = "V2SigTestsWrapper_EventResponseWrapper_SIGRender_hasGetRenderParameterMapReturns";
   public final static String               V2SIGTESTSWRAPPER_EVENTRESPONSEWRAPPER_SIGRENDER_HASGETRESPONSE                                         = "V2SigTestsWrapper_EventResponseWrapper_SIGRender_hasGetResponse";
   public final static String               V2SIGTESTSWRAPPER_EVENTRESPONSEWRAPPER_SIGRENDER_HASGETRESPONSEA                                        = "V2SigTestsWrapper_EventResponseWrapper_SIGRender_hasGetResponseA";
   public final static String               V2SIGTESTSWRAPPER_EVENTRESPONSEWRAPPER_SIGRENDER_HASGETRESPONSERETURNS                                  = "V2SigTestsWrapper_EventResponseWrapper_SIGRender_hasGetResponseReturns";
   public final static String               V2SIGTESTSWRAPPER_EVENTRESPONSEWRAPPER_SIGRENDER_HASGETRESPONSERETURNSA                                 = "V2SigTestsWrapper_EventResponseWrapper_SIGRender_hasGetResponseReturnsA";
   public final static String               V2SIGTESTSWRAPPER_EVENTRESPONSEWRAPPER_SIGRENDER_HASGETWINDOWSTATE                                      = "V2SigTestsWrapper_EventResponseWrapper_SIGRender_hasGetWindowState";
   public final static String               V2SIGTESTSWRAPPER_EVENTRESPONSEWRAPPER_SIGRENDER_HASGETWINDOWSTATERETURNS                               = "V2SigTestsWrapper_EventResponseWrapper_SIGRender_hasGetWindowStateReturns";
   public final static String               V2SIGTESTSWRAPPER_EVENTRESPONSEWRAPPER_SIGRENDER_HASREMOVEPUBLICRENDERPARAMETER                         = "V2SigTestsWrapper_EventResponseWrapper_SIGRender_hasRemovePublicRenderParameter";
   public final static String               V2SIGTESTSWRAPPER_EVENTRESPONSEWRAPPER_SIGRENDER_HASREMOVEPUBLICRENDERPARAMETERRETURNS                  = "V2SigTestsWrapper_EventResponseWrapper_SIGRender_hasRemovePublicRenderParameterReturns";
   public final static String               V2SIGTESTSWRAPPER_EVENTRESPONSEWRAPPER_SIGRENDER_HASSETEVENT                                            = "V2SigTestsWrapper_EventResponseWrapper_SIGRender_hasSetEvent";
   public final static String               V2SIGTESTSWRAPPER_EVENTRESPONSEWRAPPER_SIGRENDER_HASSETEVENTA                                           = "V2SigTestsWrapper_EventResponseWrapper_SIGRender_hasSetEventA";
   public final static String               V2SIGTESTSWRAPPER_EVENTRESPONSEWRAPPER_SIGRENDER_HASSETEVENTRETURNS                                     = "V2SigTestsWrapper_EventResponseWrapper_SIGRender_hasSetEventReturns";
   public final static String               V2SIGTESTSWRAPPER_EVENTRESPONSEWRAPPER_SIGRENDER_HASSETEVENTRETURNSA                                    = "V2SigTestsWrapper_EventResponseWrapper_SIGRender_hasSetEventReturnsA";
   public final static String               V2SIGTESTSWRAPPER_EVENTRESPONSEWRAPPER_SIGRENDER_HASSETPORTLETMODE                                      = "V2SigTestsWrapper_EventResponseWrapper_SIGRender_hasSetPortletMode";
   public final static String               V2SIGTESTSWRAPPER_EVENTRESPONSEWRAPPER_SIGRENDER_HASSETPORTLETMODERETURNS                               = "V2SigTestsWrapper_EventResponseWrapper_SIGRender_hasSetPortletModeReturns";
   public final static String               V2SIGTESTSWRAPPER_EVENTRESPONSEWRAPPER_SIGRENDER_HASSETRENDERPARAMETER                                  = "V2SigTestsWrapper_EventResponseWrapper_SIGRender_hasSetRenderParameter";
   public final static String               V2SIGTESTSWRAPPER_EVENTRESPONSEWRAPPER_SIGRENDER_HASSETRENDERPARAMETERA                                 = "V2SigTestsWrapper_EventResponseWrapper_SIGRender_hasSetRenderParameterA";
   public final static String               V2SIGTESTSWRAPPER_EVENTRESPONSEWRAPPER_SIGRENDER_HASSETRENDERPARAMETERRETURNS                           = "V2SigTestsWrapper_EventResponseWrapper_SIGRender_hasSetRenderParameterReturns";
   public final static String               V2SIGTESTSWRAPPER_EVENTRESPONSEWRAPPER_SIGRENDER_HASSETRENDERPARAMETERRETURNSA                          = "V2SigTestsWrapper_EventResponseWrapper_SIGRender_hasSetRenderParameterReturnsA";
   public final static String               V2SIGTESTSWRAPPER_EVENTRESPONSEWRAPPER_SIGRENDER_HASSETRENDERPARAMETERS                                 = "V2SigTestsWrapper_EventResponseWrapper_SIGRender_hasSetRenderParameters";
   public final static String               V2SIGTESTSWRAPPER_EVENTRESPONSEWRAPPER_SIGRENDER_HASSETRENDERPARAMETERSA                                = "V2SigTestsWrapper_EventResponseWrapper_SIGRender_hasSetRenderParametersA";
   public final static String               V2SIGTESTSWRAPPER_EVENTRESPONSEWRAPPER_SIGRENDER_HASSETRENDERPARAMETERSRETURNS                          = "V2SigTestsWrapper_EventResponseWrapper_SIGRender_hasSetRenderParametersReturns";
   public final static String               V2SIGTESTSWRAPPER_EVENTRESPONSEWRAPPER_SIGRENDER_HASSETRENDERPARAMETERSRETURNSA                         = "V2SigTestsWrapper_EventResponseWrapper_SIGRender_hasSetRenderParametersReturnsA";
   public final static String               V2SIGTESTSWRAPPER_EVENTRESPONSEWRAPPER_SIGRENDER_HASSETRESPONSE                                         = "V2SigTestsWrapper_EventResponseWrapper_SIGRender_hasSetResponse";
   public final static String               V2SIGTESTSWRAPPER_EVENTRESPONSEWRAPPER_SIGRENDER_HASSETRESPONSERETURNS                                  = "V2SigTestsWrapper_EventResponseWrapper_SIGRender_hasSetResponseReturns";
   public final static String               V2SIGTESTSWRAPPER_EVENTRESPONSEWRAPPER_SIGRENDER_HASSETWINDOWSTATE                                      = "V2SigTestsWrapper_EventResponseWrapper_SIGRender_hasSetWindowState";
   public final static String               V2SIGTESTSWRAPPER_EVENTRESPONSEWRAPPER_SIGRENDER_HASSETWINDOWSTATERETURNS                               = "V2SigTestsWrapper_EventResponseWrapper_SIGRender_hasSetWindowStateReturns";
   public final static String               V2SIGTESTSWRAPPER_EVENTRESPONSEWRAPPER_SIGRENDER_IMPLEMENTSEVENTRESPONSE                                = "V2SigTestsWrapper_EventResponseWrapper_SIGRender_implementsEventResponse";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_CONSTRUCTOR                                           = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_constructor";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETATTRIBUTE                                       = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasGetAttribute";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETATTRIBUTENAMES                                  = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasGetAttributeNames";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETATTRIBUTENAMESRETURNS                           = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasGetAttributeNamesReturns";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETATTRIBUTERETURNS                                = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasGetAttributeReturns";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETAUTHTYPE                                        = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasGetAuthType";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETAUTHTYPERETURNS                                 = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasGetAuthTypeReturns";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETCONTEXTPATH                                     = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasGetContextPath";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETCONTEXTPATHRETURNS                              = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasGetContextPathReturns";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETCOOKIES                                         = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasGetCookies";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETCOOKIESRETURNS                                  = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasGetCookiesReturns";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETLOCALE                                          = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasGetLocale";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETLOCALERETURNS                                   = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasGetLocaleReturns";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETLOCALES                                         = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasGetLocales";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETLOCALESRETURNS                                  = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasGetLocalesReturns";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETPARAMETER                                       = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasGetParameter";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETPARAMETERMAP                                    = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasGetParameterMap";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETPARAMETERMAPRETURNS                             = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasGetParameterMapReturns";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETPARAMETERNAMES                                  = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasGetParameterNames";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETPARAMETERNAMESRETURNS                           = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasGetParameterNamesReturns";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETPARAMETERRETURNS                                = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasGetParameterReturns";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETPARAMETERVALUES                                 = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasGetParameterValues";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETPARAMETERVALUESRETURNS                          = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasGetParameterValuesReturns";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETPORTALCONTEXT                                   = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasGetPortalContext";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETPORTALCONTEXTRETURNS                            = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasGetPortalContextReturns";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETPORTLETMODE                                     = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasGetPortletMode";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETPORTLETMODERETURNS                              = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasGetPortletModeReturns";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETPORTLETSESSION                                  = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasGetPortletSession";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETPORTLETSESSIONA                                 = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasGetPortletSessionA";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETPORTLETSESSIONRETURNS                           = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasGetPortletSessionReturns";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETPORTLETSESSIONRETURNSA                          = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasGetPortletSessionReturnsA";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETPREFERENCES                                     = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasGetPreferences";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETPREFERENCESRETURNS                              = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasGetPreferencesReturns";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETPRIVATEPARAMETERMAP                             = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasGetPrivateParameterMap";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETPRIVATEPARAMETERMAPRETURNS                      = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasGetPrivateParameterMapReturns";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETPROPERTIES                                      = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasGetProperties";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETPROPERTIESRETURNS                               = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasGetPropertiesReturns";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETPROPERTY                                        = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasGetProperty";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETPROPERTYNAMES                                   = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasGetPropertyNames";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETPROPERTYNAMESRETURNS                            = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasGetPropertyNamesReturns";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETPROPERTYRETURNS                                 = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasGetPropertyReturns";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETPUBLICPARAMETERMAP                              = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasGetPublicParameterMap";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETPUBLICPARAMETERMAPRETURNS                       = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasGetPublicParameterMapReturns";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETREMOTEUSER                                      = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasGetRemoteUser";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETREMOTEUSERRETURNS                               = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasGetRemoteUserReturns";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETREQUEST                                         = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasGetRequest";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETREQUESTRETURNS                                  = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasGetRequestReturns";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETREQUESTEDSESSIONID                              = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasGetRequestedSessionId";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETREQUESTEDSESSIONIDRETURNS                       = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasGetRequestedSessionIdReturns";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETRESPONSECONTENTTYPE                             = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasGetResponseContentType";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETRESPONSECONTENTTYPERETURNS                      = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasGetResponseContentTypeReturns";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETRESPONSECONTENTTYPES                            = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasGetResponseContentTypes";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETRESPONSECONTENTTYPESRETURNS                     = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasGetResponseContentTypesReturns";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETSCHEME                                          = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasGetScheme";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETSCHEMERETURNS                                   = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasGetSchemeReturns";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETSERVERNAME                                      = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasGetServerName";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETSERVERNAMERETURNS                               = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasGetServerNameReturns";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETSERVERPORT                                      = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasGetServerPort";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETSERVERPORTRETURNS                               = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasGetServerPortReturns";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETUSERPRINCIPAL                                   = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasGetUserPrincipal";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETUSERPRINCIPALRETURNS                            = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasGetUserPrincipalReturns";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETWINDOWID                                        = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasGetWindowID";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETWINDOWIDRETURNS                                 = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasGetWindowIDReturns";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETWINDOWSTATE                                     = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasGetWindowState";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETWINDOWSTATERETURNS                              = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasGetWindowStateReturns";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASISPORTLETMODEALLOWED                               = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasIsPortletModeAllowed";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASISPORTLETMODEALLOWEDRETURNS                        = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasIsPortletModeAllowedReturns";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASISREQUESTEDSESSIONIDVALID                          = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasIsRequestedSessionIdValid";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASISREQUESTEDSESSIONIDVALIDRETURNS                   = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasIsRequestedSessionIdValidReturns";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASISSECURE                                           = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasIsSecure";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASISSECURERETURNS                                    = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasIsSecureReturns";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASISUSERINROLE                                       = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasIsUserInRole";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASISUSERINROLERETURNS                                = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasIsUserInRoleReturns";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASISWINDOWSTATEALLOWED                               = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasIsWindowStateAllowed";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASISWINDOWSTATEALLOWEDRETURNS                        = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasIsWindowStateAllowedReturns";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASREMOVEATTRIBUTE                                    = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasRemoveAttribute";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASREMOVEATTRIBUTERETURNS                             = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasRemoveAttributeReturns";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASSETATTRIBUTE                                       = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasSetAttribute";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASSETATTRIBUTERETURNS                                = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasSetAttributeReturns";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASSETREQUEST                                         = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasSetRequest";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASSETREQUESTRETURNS                                  = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_hasSetRequestReturns";
   public final static String               V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_IMPLEMENTSPORTLETREQUEST                              = "V2SigTestsWrapper_PortletRequestWrapper_SIGRender_implementsPortletRequest";
   public final static String               V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_CONSTRUCTOR                                          = "V2SigTestsWrapper_PortletResponseWrapper_SIGRender_constructor";
   public final static String               V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASADDPROPERTY                                       = "V2SigTestsWrapper_PortletResponseWrapper_SIGRender_hasAddProperty";
   public final static String               V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASADDPROPERTYA                                      = "V2SigTestsWrapper_PortletResponseWrapper_SIGRender_hasAddPropertyA";
   public final static String               V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASADDPROPERTYB                                      = "V2SigTestsWrapper_PortletResponseWrapper_SIGRender_hasAddPropertyB";
   public final static String               V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASADDPROPERTYRETURNS                                = "V2SigTestsWrapper_PortletResponseWrapper_SIGRender_hasAddPropertyReturns";
   public final static String               V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASADDPROPERTYRETURNSA                               = "V2SigTestsWrapper_PortletResponseWrapper_SIGRender_hasAddPropertyReturnsA";
   public final static String               V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASADDPROPERTYRETURNSB                               = "V2SigTestsWrapper_PortletResponseWrapper_SIGRender_hasAddPropertyReturnsB";
   public final static String               V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASCREATEELEMENT                                     = "V2SigTestsWrapper_PortletResponseWrapper_SIGRender_hasCreateElement";
   public final static String               V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASCREATEELEMENTRETURNS                              = "V2SigTestsWrapper_PortletResponseWrapper_SIGRender_hasCreateElementReturns";
   public final static String               V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASENCODEURL                                         = "V2SigTestsWrapper_PortletResponseWrapper_SIGRender_hasEncodeURL";
   public final static String               V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASENCODEURLRETURNS                                  = "V2SigTestsWrapper_PortletResponseWrapper_SIGRender_hasEncodeURLReturns";
   public final static String               V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASGETNAMESPACE                                      = "V2SigTestsWrapper_PortletResponseWrapper_SIGRender_hasGetNamespace";
   public final static String               V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASGETNAMESPACERETURNS                               = "V2SigTestsWrapper_PortletResponseWrapper_SIGRender_hasGetNamespaceReturns";
   public final static String               V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASGETRESPONSE                                       = "V2SigTestsWrapper_PortletResponseWrapper_SIGRender_hasGetResponse";
   public final static String               V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASGETRESPONSERETURNS                                = "V2SigTestsWrapper_PortletResponseWrapper_SIGRender_hasGetResponseReturns";
   public final static String               V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASSETPROPERTY                                       = "V2SigTestsWrapper_PortletResponseWrapper_SIGRender_hasSetProperty";
   public final static String               V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASSETPROPERTYRETURNS                                = "V2SigTestsWrapper_PortletResponseWrapper_SIGRender_hasSetPropertyReturns";
   public final static String               V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASSETRESPONSE                                       = "V2SigTestsWrapper_PortletResponseWrapper_SIGRender_hasSetResponse";
   public final static String               V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASSETRESPONSERETURNS                                = "V2SigTestsWrapper_PortletResponseWrapper_SIGRender_hasSetResponseReturns";
   public final static String               V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_IMPLEMENTSPORTLETRESPONSE                            = "V2SigTestsWrapper_PortletResponseWrapper_SIGRender_implementsPortletResponse";
   public final static String               V2SIGTESTSWRAPPER_RENDERREQUESTWRAPPER_SIGRENDER_CONSTRUCTOR                                            = "V2SigTestsWrapper_RenderRequestWrapper_SIGRender_constructor";
   public final static String               V2SIGTESTSWRAPPER_RENDERREQUESTWRAPPER_SIGRENDER_EXTENDSPORTLETREQUESTWRAPPER                           = "V2SigTestsWrapper_RenderRequestWrapper_SIGRender_extendsPortletRequestWrapper";
   public final static String               V2SIGTESTSWRAPPER_RENDERREQUESTWRAPPER_SIGRENDER_HASGETETAG                                             = "V2SigTestsWrapper_RenderRequestWrapper_SIGRender_hasGetETag";
   public final static String               V2SIGTESTSWRAPPER_RENDERREQUESTWRAPPER_SIGRENDER_HASGETETAGRETURNS                                      = "V2SigTestsWrapper_RenderRequestWrapper_SIGRender_hasGetETagReturns";
   public final static String               V2SIGTESTSWRAPPER_RENDERREQUESTWRAPPER_SIGRENDER_HASGETREQUEST                                          = "V2SigTestsWrapper_RenderRequestWrapper_SIGRender_hasGetRequest";
   public final static String               V2SIGTESTSWRAPPER_RENDERREQUESTWRAPPER_SIGRENDER_HASGETREQUESTA                                         = "V2SigTestsWrapper_RenderRequestWrapper_SIGRender_hasGetRequestA";
   public final static String               V2SIGTESTSWRAPPER_RENDERREQUESTWRAPPER_SIGRENDER_HASGETREQUESTRETURNS                                   = "V2SigTestsWrapper_RenderRequestWrapper_SIGRender_hasGetRequestReturns";
   public final static String               V2SIGTESTSWRAPPER_RENDERREQUESTWRAPPER_SIGRENDER_HASGETREQUESTRETURNSA                                  = "V2SigTestsWrapper_RenderRequestWrapper_SIGRender_hasGetRequestReturnsA";
   public final static String               V2SIGTESTSWRAPPER_RENDERREQUESTWRAPPER_SIGRENDER_HASSETREQUEST                                          = "V2SigTestsWrapper_RenderRequestWrapper_SIGRender_hasSetRequest";
   public final static String               V2SIGTESTSWRAPPER_RENDERREQUESTWRAPPER_SIGRENDER_HASSETREQUESTRETURNS                                   = "V2SigTestsWrapper_RenderRequestWrapper_SIGRender_hasSetRequestReturns";
   public final static String               V2SIGTESTSWRAPPER_RENDERREQUESTWRAPPER_SIGRENDER_IMPLEMENTSRENDERREQUEST                                = "V2SigTestsWrapper_RenderRequestWrapper_SIGRender_implementsRenderRequest";
   public final static String               V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_CONSTRUCTOR                                           = "V2SigTestsWrapper_RenderResponseWrapper_SIGRender_constructor";
   public final static String               V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_EXTENDSPORTLETRESPONSEWRAPPER                         = "V2SigTestsWrapper_RenderResponseWrapper_SIGRender_extendsPortletResponseWrapper";
   public final static String               V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASCREATEACTIONURL                                    = "V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasCreateActionURL";
   public final static String               V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASCREATEACTIONURLRETURNS                             = "V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasCreateActionURLReturns";
   public final static String               V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASCREATERENDERURL                                    = "V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasCreateRenderURL";
   public final static String               V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASCREATERENDERURLRETURNS                             = "V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasCreateRenderURLReturns";
   public final static String               V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASCREATERESOURCEURL                                  = "V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasCreateResourceURL";
   public final static String               V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASCREATERESOURCEURLRETURNS                           = "V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasCreateResourceURLReturns";
   public final static String               V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASFLUSHBUFFER                                        = "V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasFlushBuffer";
   public final static String               V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASFLUSHBUFFERRETURNS                                 = "V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasFlushBufferReturns";
   public final static String               V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETBUFFERSIZE                                      = "V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasGetBufferSize";
   public final static String               V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETBUFFERSIZERETURNS                               = "V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasGetBufferSizeReturns";
   public final static String               V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETCACHECONTROL                                    = "V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasGetCacheControl";
   public final static String               V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETCACHECONTROLRETURNS                             = "V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasGetCacheControlReturns";
   public final static String               V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETCHARACTERENCODING                               = "V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasGetCharacterEncoding";
   public final static String               V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETCHARACTERENCODINGRETURNS                        = "V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasGetCharacterEncodingReturns";
   public final static String               V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETCONTENTTYPE                                     = "V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasGetContentType";
   public final static String               V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETCONTENTTYPERETURNS                              = "V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasGetContentTypeReturns";
   public final static String               V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETLOCALE                                          = "V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasGetLocale";
   public final static String               V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETLOCALERETURNS                                   = "V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasGetLocaleReturns";
   public final static String               V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETPORTLETOUTPUTSTREAM                             = "V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasGetPortletOutputStream";
   public final static String               V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETPORTLETOUTPUTSTREAMRETURNS                      = "V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasGetPortletOutputStreamReturns";
   public final static String               V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETRESPONSE                                        = "V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasGetResponse";
   public final static String               V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETRESPONSEA                                       = "V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasGetResponseA";
   public final static String               V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETRESPONSERETURNS                                 = "V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasGetResponseReturns";
   public final static String               V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETRESPONSERETURNSA                                = "V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasGetResponseReturnsA";
   public final static String               V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETWRITER                                          = "V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasGetWriter";
   public final static String               V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETWRITERRETURNS                                   = "V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasGetWriterReturns";
   public final static String               V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASISCOMMITTED                                        = "V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasIsCommitted";
   public final static String               V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASISCOMMITTEDRETURNS                                 = "V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasIsCommittedReturns";
   public final static String               V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASRESET                                              = "V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasReset";
   public final static String               V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASRESETBUFFER                                        = "V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasResetBuffer";
   public final static String               V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASRESETBUFFERRETURNS                                 = "V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasResetBufferReturns";
   public final static String               V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASRESETRETURNS                                       = "V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasResetReturns";
   public final static String               V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASSETBUFFERSIZE                                      = "V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasSetBufferSize";
   public final static String               V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASSETBUFFERSIZERETURNS                               = "V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasSetBufferSizeReturns";
   public final static String               V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASSETCONTENTTYPE                                     = "V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasSetContentType";
   public final static String               V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASSETCONTENTTYPERETURNS                              = "V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasSetContentTypeReturns";
   public final static String               V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASSETNEXTPOSSIBLEPORTLETMODES                        = "V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasSetNextPossiblePortletModes";
   public final static String               V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASSETNEXTPOSSIBLEPORTLETMODESRETURNS                 = "V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasSetNextPossiblePortletModesReturns";
   public final static String               V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASSETRESPONSE                                        = "V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasSetResponse";
   public final static String               V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASSETRESPONSERETURNS                                 = "V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasSetResponseReturns";
   public final static String               V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASSETTITLE                                           = "V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasSetTitle";
   public final static String               V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASSETTITLERETURNS                                    = "V2SigTestsWrapper_RenderResponseWrapper_SIGRender_hasSetTitleReturns";
   public final static String               V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_IMPLEMENTSRENDERRESPONSE                              = "V2SigTestsWrapper_RenderResponseWrapper_SIGRender_implementsRenderResponse";
   public final static String               V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_CONSTRUCTOR                                          = "V2SigTestsWrapper_ResourceRequestWrapper_SIGRender_constructor";
   public final static String               V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_EXTENDSPORTLETREQUESTWRAPPER                         = "V2SigTestsWrapper_ResourceRequestWrapper_SIGRender_extendsPortletRequestWrapper";
   public final static String               V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETCACHEABILITY                                   = "V2SigTestsWrapper_ResourceRequestWrapper_SIGRender_hasGetCacheability";
   public final static String               V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETCACHEABILITYRETURNS                            = "V2SigTestsWrapper_ResourceRequestWrapper_SIGRender_hasGetCacheabilityReturns";
   public final static String               V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETCHARACTERENCODING                              = "V2SigTestsWrapper_ResourceRequestWrapper_SIGRender_hasGetCharacterEncoding";
   public final static String               V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETCHARACTERENCODINGRETURNS                       = "V2SigTestsWrapper_ResourceRequestWrapper_SIGRender_hasGetCharacterEncodingReturns";
   public final static String               V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETCONTENTLENGTH                                  = "V2SigTestsWrapper_ResourceRequestWrapper_SIGRender_hasGetContentLength";
   public final static String               V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETCONTENTLENGTHRETURNS                           = "V2SigTestsWrapper_ResourceRequestWrapper_SIGRender_hasGetContentLengthReturns";
   public final static String               V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETCONTENTTYPE                                    = "V2SigTestsWrapper_ResourceRequestWrapper_SIGRender_hasGetContentType";
   public final static String               V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETCONTENTTYPERETURNS                             = "V2SigTestsWrapper_ResourceRequestWrapper_SIGRender_hasGetContentTypeReturns";
   public final static String               V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETETAG                                           = "V2SigTestsWrapper_ResourceRequestWrapper_SIGRender_hasGetETag";
   public final static String               V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETETAGRETURNS                                    = "V2SigTestsWrapper_ResourceRequestWrapper_SIGRender_hasGetETagReturns";
   public final static String               V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETMETHOD                                         = "V2SigTestsWrapper_ResourceRequestWrapper_SIGRender_hasGetMethod";
   public final static String               V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETMETHODRETURNS                                  = "V2SigTestsWrapper_ResourceRequestWrapper_SIGRender_hasGetMethodReturns";
   public final static String               V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETPORTLETINPUTSTREAM                             = "V2SigTestsWrapper_ResourceRequestWrapper_SIGRender_hasGetPortletInputStream";
   public final static String               V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETPORTLETINPUTSTREAMRETURNS                      = "V2SigTestsWrapper_ResourceRequestWrapper_SIGRender_hasGetPortletInputStreamReturns";
   public final static String               V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETPRIVATERENDERPARAMETERMAP                      = "V2SigTestsWrapper_ResourceRequestWrapper_SIGRender_hasGetPrivateRenderParameterMap";
   public final static String               V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETPRIVATERENDERPARAMETERMAPRETURNS               = "V2SigTestsWrapper_ResourceRequestWrapper_SIGRender_hasGetPrivateRenderParameterMapReturns";
   public final static String               V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETREADER                                         = "V2SigTestsWrapper_ResourceRequestWrapper_SIGRender_hasGetReader";
   public final static String               V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETREADERRETURNS                                  = "V2SigTestsWrapper_ResourceRequestWrapper_SIGRender_hasGetReaderReturns";
   public final static String               V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETREQUEST                                        = "V2SigTestsWrapper_ResourceRequestWrapper_SIGRender_hasGetRequest";
   public final static String               V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETREQUESTA                                       = "V2SigTestsWrapper_ResourceRequestWrapper_SIGRender_hasGetRequestA";
   public final static String               V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETREQUESTRETURNS                                 = "V2SigTestsWrapper_ResourceRequestWrapper_SIGRender_hasGetRequestReturns";
   public final static String               V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETREQUESTRETURNSA                                = "V2SigTestsWrapper_ResourceRequestWrapper_SIGRender_hasGetRequestReturnsA";
   public final static String               V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETRESOURCEID                                     = "V2SigTestsWrapper_ResourceRequestWrapper_SIGRender_hasGetResourceID";
   public final static String               V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETRESOURCEIDRETURNS                              = "V2SigTestsWrapper_ResourceRequestWrapper_SIGRender_hasGetResourceIDReturns";
   public final static String               V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASSETCHARACTERENCODING                              = "V2SigTestsWrapper_ResourceRequestWrapper_SIGRender_hasSetCharacterEncoding";
   public final static String               V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASSETCHARACTERENCODINGRETURNS                       = "V2SigTestsWrapper_ResourceRequestWrapper_SIGRender_hasSetCharacterEncodingReturns";
   public final static String               V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASSETREQUEST                                        = "V2SigTestsWrapper_ResourceRequestWrapper_SIGRender_hasSetRequest";
   public final static String               V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASSETREQUESTRETURNS                                 = "V2SigTestsWrapper_ResourceRequestWrapper_SIGRender_hasSetRequestReturns";
   public final static String               V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_IMPLEMENTSRESOURCEREQUEST                            = "V2SigTestsWrapper_ResourceRequestWrapper_SIGRender_implementsResourceRequest";
   public final static String               V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_CONSTRUCTOR                                         = "V2SigTestsWrapper_ResourceResponseWrapper_SIGRender_constructor";
   public final static String               V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_EXTENDSPORTLETRESPONSEWRAPPER                       = "V2SigTestsWrapper_ResourceResponseWrapper_SIGRender_extendsPortletResponseWrapper";
   public final static String               V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASCREATEACTIONURL                                  = "V2SigTestsWrapper_ResourceResponseWrapper_SIGRender_hasCreateActionURL";
   public final static String               V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASCREATEACTIONURLRETURNS                           = "V2SigTestsWrapper_ResourceResponseWrapper_SIGRender_hasCreateActionURLReturns";
   public final static String               V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASCREATERENDERURL                                  = "V2SigTestsWrapper_ResourceResponseWrapper_SIGRender_hasCreateRenderURL";
   public final static String               V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASCREATERENDERURLRETURNS                           = "V2SigTestsWrapper_ResourceResponseWrapper_SIGRender_hasCreateRenderURLReturns";
   public final static String               V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASCREATERESOURCEURL                                = "V2SigTestsWrapper_ResourceResponseWrapper_SIGRender_hasCreateResourceURL";
   public final static String               V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASCREATERESOURCEURLRETURNS                         = "V2SigTestsWrapper_ResourceResponseWrapper_SIGRender_hasCreateResourceURLReturns";
   public final static String               V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASFLUSHBUFFER                                      = "V2SigTestsWrapper_ResourceResponseWrapper_SIGRender_hasFlushBuffer";
   public final static String               V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASFLUSHBUFFERRETURNS                               = "V2SigTestsWrapper_ResourceResponseWrapper_SIGRender_hasFlushBufferReturns";
   public final static String               V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASGETBUFFERSIZE                                    = "V2SigTestsWrapper_ResourceResponseWrapper_SIGRender_hasGetBufferSize";
   public final static String               V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASGETBUFFERSIZERETURNS                             = "V2SigTestsWrapper_ResourceResponseWrapper_SIGRender_hasGetBufferSizeReturns";
   public final static String               V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASGETCACHECONTROL                                  = "V2SigTestsWrapper_ResourceResponseWrapper_SIGRender_hasGetCacheControl";
   public final static String               V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASGETCACHECONTROLRETURNS                           = "V2SigTestsWrapper_ResourceResponseWrapper_SIGRender_hasGetCacheControlReturns";
   public final static String               V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASGETCHARACTERENCODING                             = "V2SigTestsWrapper_ResourceResponseWrapper_SIGRender_hasGetCharacterEncoding";
   public final static String               V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASGETCHARACTERENCODINGRETURNS                      = "V2SigTestsWrapper_ResourceResponseWrapper_SIGRender_hasGetCharacterEncodingReturns";
   public final static String               V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASGETCONTENTTYPE                                   = "V2SigTestsWrapper_ResourceResponseWrapper_SIGRender_hasGetContentType";
   public final static String               V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASGETCONTENTTYPERETURNS                            = "V2SigTestsWrapper_ResourceResponseWrapper_SIGRender_hasGetContentTypeReturns";
   public final static String               V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASGETLOCALE                                        = "V2SigTestsWrapper_ResourceResponseWrapper_SIGRender_hasGetLocale";
   public final static String               V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASGETLOCALERETURNS                                 = "V2SigTestsWrapper_ResourceResponseWrapper_SIGRender_hasGetLocaleReturns";
   public final static String               V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASGETPORTLETOUTPUTSTREAM                           = "V2SigTestsWrapper_ResourceResponseWrapper_SIGRender_hasGetPortletOutputStream";
   public final static String               V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASGETPORTLETOUTPUTSTREAMRETURNS                    = "V2SigTestsWrapper_ResourceResponseWrapper_SIGRender_hasGetPortletOutputStreamReturns";
   public final static String               V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASGETRESPONSE                                      = "V2SigTestsWrapper_ResourceResponseWrapper_SIGRender_hasGetResponse";
   public final static String               V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASGETRESPONSEA                                     = "V2SigTestsWrapper_ResourceResponseWrapper_SIGRender_hasGetResponseA";
   public final static String               V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASGETRESPONSERETURNS                               = "V2SigTestsWrapper_ResourceResponseWrapper_SIGRender_hasGetResponseReturns";
   public final static String               V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASGETRESPONSERETURNSA                              = "V2SigTestsWrapper_ResourceResponseWrapper_SIGRender_hasGetResponseReturnsA";
   public final static String               V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASGETWRITER                                        = "V2SigTestsWrapper_ResourceResponseWrapper_SIGRender_hasGetWriter";
   public final static String               V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASGETWRITERRETURNS                                 = "V2SigTestsWrapper_ResourceResponseWrapper_SIGRender_hasGetWriterReturns";
   public final static String               V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASISCOMMITTED                                      = "V2SigTestsWrapper_ResourceResponseWrapper_SIGRender_hasIsCommitted";
   public final static String               V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASISCOMMITTEDRETURNS                               = "V2SigTestsWrapper_ResourceResponseWrapper_SIGRender_hasIsCommittedReturns";
   public final static String               V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASRESET                                            = "V2SigTestsWrapper_ResourceResponseWrapper_SIGRender_hasReset";
   public final static String               V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASRESETBUFFER                                      = "V2SigTestsWrapper_ResourceResponseWrapper_SIGRender_hasResetBuffer";
   public final static String               V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASRESETBUFFERRETURNS                               = "V2SigTestsWrapper_ResourceResponseWrapper_SIGRender_hasResetBufferReturns";
   public final static String               V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASRESETRETURNS                                     = "V2SigTestsWrapper_ResourceResponseWrapper_SIGRender_hasResetReturns";
   public final static String               V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASSETBUFFERSIZE                                    = "V2SigTestsWrapper_ResourceResponseWrapper_SIGRender_hasSetBufferSize";
   public final static String               V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASSETBUFFERSIZERETURNS                             = "V2SigTestsWrapper_ResourceResponseWrapper_SIGRender_hasSetBufferSizeReturns";
   public final static String               V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASSETCHARACTERENCODING                             = "V2SigTestsWrapper_ResourceResponseWrapper_SIGRender_hasSetCharacterEncoding";
   public final static String               V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASSETCHARACTERENCODINGRETURNS                      = "V2SigTestsWrapper_ResourceResponseWrapper_SIGRender_hasSetCharacterEncodingReturns";
   public final static String               V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASSETCONTENTLENGTH                                 = "V2SigTestsWrapper_ResourceResponseWrapper_SIGRender_hasSetContentLength";
   public final static String               V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASSETCONTENTLENGTHRETURNS                          = "V2SigTestsWrapper_ResourceResponseWrapper_SIGRender_hasSetContentLengthReturns";
   public final static String               V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASSETCONTENTTYPE                                   = "V2SigTestsWrapper_ResourceResponseWrapper_SIGRender_hasSetContentType";
   public final static String               V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASSETCONTENTTYPERETURNS                            = "V2SigTestsWrapper_ResourceResponseWrapper_SIGRender_hasSetContentTypeReturns";
   public final static String               V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASSETLOCALE                                        = "V2SigTestsWrapper_ResourceResponseWrapper_SIGRender_hasSetLocale";
   public final static String               V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASSETLOCALERETURNS                                 = "V2SigTestsWrapper_ResourceResponseWrapper_SIGRender_hasSetLocaleReturns";
   public final static String               V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASSETRESPONSE                                      = "V2SigTestsWrapper_ResourceResponseWrapper_SIGRender_hasSetResponse";
   public final static String               V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASSETRESPONSERETURNS                               = "V2SigTestsWrapper_ResourceResponseWrapper_SIGRender_hasSetResponseReturns";
   public final static String               V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_IMPLEMENTSRESOURCERESPONSE                          = "V2SigTestsWrapper_ResourceResponseWrapper_SIGRender_implementsResourceResponse";

   private final static Map<String, String> tcd                                                                                                     = new HashMap<String, String>();
   static {

      tcd.put(V2SIGTESTSACTION_ACTIONREQUEST_SIGACTION_FIELDACTION_NAME, "ActionRequest has String field ACTION_NAME");
      tcd.put(V2SIGTESTSACTION_ACTIONREQUEST_SIGACTION_IMPLEMENTSCLIENTDATAREQUEST,
            "ActionRequest implements ClientDataRequest");
      tcd.put(V2SIGTESTSACTION_ACTIONRESPONSE_SIGACTION_HASSENDREDIRECT,
            "ActionResponse has a sendRedirect(String) throws java.io.IOException method");
      tcd.put(V2SIGTESTSACTION_ACTIONRESPONSE_SIGACTION_HASSENDREDIRECTA,
            "ActionResponse has a sendRedirect(String, String) throws java.io.IOException method");
      tcd.put(V2SIGTESTSACTION_ACTIONRESPONSE_SIGACTION_HASSENDREDIRECTRETURNS,
            "ActionResponse method sendRedirect(String) returns void");
      tcd.put(V2SIGTESTSACTION_ACTIONRESPONSE_SIGACTION_HASSENDREDIRECTRETURNSA,
            "ActionResponse method sendRedirect(String, String) returns void");
      tcd.put(V2SIGTESTSACTION_ACTIONRESPONSE_SIGACTION_IMPLEMENTSSTATEAWARERESPONSE,
            "ActionResponse implements StateAwareResponse");
      tcd.put(V2SIGTESTSACTION_CLIENTDATAREQUEST_SIGACTION_HASGETCHARACTERENCODING,
            "ActionRequest has a getCharacterEncoding()  method");
      tcd.put(V2SIGTESTSACTION_CLIENTDATAREQUEST_SIGACTION_HASGETCHARACTERENCODINGRETURNS,
            "ActionRequest method getCharacterEncoding() returns String");
      tcd.put(V2SIGTESTSACTION_CLIENTDATAREQUEST_SIGACTION_HASGETCONTENTLENGTH,
            "ActionRequest has a getContentLength()  method");
      tcd.put(V2SIGTESTSACTION_CLIENTDATAREQUEST_SIGACTION_HASGETCONTENTLENGTHRETURNS,
            "ActionRequest method getContentLength() returns int");
      tcd.put(V2SIGTESTSACTION_CLIENTDATAREQUEST_SIGACTION_HASGETCONTENTTYPE,
            "ActionRequest has a getContentType()  method");
      tcd.put(V2SIGTESTSACTION_CLIENTDATAREQUEST_SIGACTION_HASGETCONTENTTYPERETURNS,
            "ActionRequest method getContentType() returns String");
      tcd.put(V2SIGTESTSACTION_CLIENTDATAREQUEST_SIGACTION_HASGETMETHOD, "ActionRequest has a getMethod()  method");
      tcd.put(V2SIGTESTSACTION_CLIENTDATAREQUEST_SIGACTION_HASGETMETHODRETURNS,
            "ActionRequest method getMethod() returns String");
      tcd.put(V2SIGTESTSACTION_CLIENTDATAREQUEST_SIGACTION_HASGETPORTLETINPUTSTREAM,
            "ActionRequest has a getPortletInputStream() throws java.io.IOException method");
      tcd.put(V2SIGTESTSACTION_CLIENTDATAREQUEST_SIGACTION_HASGETPORTLETINPUTSTREAMRETURNS,
            "ActionRequest method getPortletInputStream() returns java.io.InputStream");
      tcd.put(V2SIGTESTSACTION_CLIENTDATAREQUEST_SIGACTION_HASGETREADER,
            "ActionRequest has a getReader() throws java.io.UnsupportedEncodingException, java.io.IOException method");
      tcd.put(V2SIGTESTSACTION_CLIENTDATAREQUEST_SIGACTION_HASGETREADERRETURNS,
            "ActionRequest method getReader() returns java.io.BufferedReader");
      tcd.put(V2SIGTESTSACTION_CLIENTDATAREQUEST_SIGACTION_HASSETCHARACTERENCODING,
            "ActionRequest has a setCharacterEncoding(String) throws java.io.UnsupportedEncodingException method");
      tcd.put(V2SIGTESTSACTION_CLIENTDATAREQUEST_SIGACTION_HASSETCHARACTERENCODINGRETURNS,
            "ActionRequest method setCharacterEncoding(String) returns void");
      tcd.put(V2SIGTESTSACTION_CLIENTDATAREQUEST_SIGACTION_IMPLEMENTSPORTLETREQUEST,
            "ActionRequest implements PortletRequest");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_FIELDACTION_PHASE,
            "ActionRequest has String field ACTION_PHASE");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_FIELDACTION_SCOPE_ID,
            "ActionRequest has String field ACTION_SCOPE_ID");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_FIELDBASIC_AUTH, "ActionRequest has String field BASIC_AUTH");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_FIELDCCPP_PROFILE,
            "ActionRequest has String field CCPP_PROFILE");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_FIELDCLIENT_CERT_AUTH,
            "ActionRequest has String field CLIENT_CERT_AUTH");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_FIELDDIGEST_AUTH, "ActionRequest has String field DIGEST_AUTH");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_FIELDEVENT_PHASE, "ActionRequest has String field EVENT_PHASE");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_FIELDFORM_AUTH, "ActionRequest has String field FORM_AUTH");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_FIELDLIFECYCLE_PHASE,
            "ActionRequest has String field LIFECYCLE_PHASE");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_FIELDRENDER_HEADERS,
            "ActionRequest has String field RENDER_HEADERS");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_FIELDRENDER_MARKUP,
            "ActionRequest has String field RENDER_MARKUP");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_FIELDRENDER_PART, "ActionRequest has String field RENDER_PART");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_FIELDRENDER_PHASE,
            "ActionRequest has String field RENDER_PHASE");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_FIELDRESOURCE_PHASE,
            "ActionRequest has String field RESOURCE_PHASE");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_FIELDUSER_INFO, "ActionRequest has String field USER_INFO");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETATTRIBUTE,
            "ActionRequest has a getAttribute(String)  method");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETATTRIBUTENAMES,
            "ActionRequest has a getAttributeNames()  method");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETATTRIBUTENAMESRETURNS,
            "ActionRequest method getAttributeNames() returns java.util.Enumeration");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETATTRIBUTERETURNS,
            "ActionRequest method getAttribute(String) returns Object");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETAUTHTYPE, "ActionRequest has a getAuthType()  method");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETAUTHTYPERETURNS,
            "ActionRequest method getAuthType() returns String");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETCONTEXTPATH,
            "ActionRequest has a getContextPath()  method");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETCONTEXTPATHRETURNS,
            "ActionRequest method getContextPath() returns String");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETCOOKIES, "ActionRequest has a getCookies()  method");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETCOOKIESRETURNS,
            "ActionRequest method getCookies() returns javax.servlet.http.Cookie[] ");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETLOCALE, "ActionRequest has a getLocale()  method");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETLOCALERETURNS,
            "ActionRequest method getLocale() returns java.util.Locale");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETLOCALES, "ActionRequest has a getLocales()  method");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETLOCALESRETURNS,
            "ActionRequest method getLocales() returns java.util.Enumeration");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETPARAMETER,
            "ActionRequest has a getParameter(String)  method");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETPARAMETERMAP,
            "ActionRequest has a getParameterMap()  method");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETPARAMETERMAPRETURNS,
            "ActionRequest method getParameterMap() returns java.util.Map");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETPARAMETERNAMES,
            "ActionRequest has a getParameterNames()  method");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETPARAMETERNAMESRETURNS,
            "ActionRequest method getParameterNames() returns java.util.Enumeration");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETPARAMETERRETURNS,
            "ActionRequest method getParameter(String) returns String");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETPARAMETERVALUES,
            "ActionRequest has a getParameterValues(String)  method");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETPARAMETERVALUESRETURNS,
            "ActionRequest method getParameterValues(String) returns String[] ");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETPORTALCONTEXT,
            "ActionRequest has a getPortalContext()  method");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETPORTALCONTEXTRETURNS,
            "ActionRequest method getPortalContext() returns PortalContext");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETPORTLETMODE,
            "ActionRequest has a getPortletMode()  method");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETPORTLETMODERETURNS,
            "ActionRequest method getPortletMode() returns PortletMode");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETPORTLETSESSION,
            "ActionRequest has a getPortletSession()  method");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETPORTLETSESSIONA,
            "ActionRequest has a getPortletSession(boolean)  method");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETPORTLETSESSIONRETURNS,
            "ActionRequest method getPortletSession() returns PortletSession");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETPORTLETSESSIONRETURNSA,
            "ActionRequest method getPortletSession(boolean) returns PortletSession");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETPREFERENCES,
            "ActionRequest has a getPreferences()  method");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETPREFERENCESRETURNS,
            "ActionRequest method getPreferences() returns PortletPreferences");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETPRIVATEPARAMETERMAP,
            "ActionRequest has a getPrivateParameterMap()  method");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETPRIVATEPARAMETERMAPRETURNS,
            "ActionRequest method getPrivateParameterMap() returns java.util.Map");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETPROPERTIES,
            "ActionRequest has a getProperties(String)  method");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETPROPERTIESRETURNS,
            "ActionRequest method getProperties(String) returns java.util.Enumeration");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETPROPERTY,
            "ActionRequest has a getProperty(String)  method");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETPROPERTYNAMES,
            "ActionRequest has a getPropertyNames()  method");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETPROPERTYNAMESRETURNS,
            "ActionRequest method getPropertyNames() returns java.util.Enumeration");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETPROPERTYRETURNS,
            "ActionRequest method getProperty(String) returns String");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETPUBLICPARAMETERMAP,
            "ActionRequest has a getPublicParameterMap()  method");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETPUBLICPARAMETERMAPRETURNS,
            "ActionRequest method getPublicParameterMap() returns java.util.Map");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETREMOTEUSER,
            "ActionRequest has a getRemoteUser()  method");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETREMOTEUSERRETURNS,
            "ActionRequest method getRemoteUser() returns String");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETREQUESTEDSESSIONID,
            "ActionRequest has a getRequestedSessionId()  method");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETREQUESTEDSESSIONIDRETURNS,
            "ActionRequest method getRequestedSessionId() returns String");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETRESPONSECONTENTTYPE,
            "ActionRequest has a getResponseContentType()  method");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETRESPONSECONTENTTYPERETURNS,
            "ActionRequest method getResponseContentType() returns String");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETRESPONSECONTENTTYPES,
            "ActionRequest has a getResponseContentTypes()  method");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETRESPONSECONTENTTYPESRETURNS,
            "ActionRequest method getResponseContentTypes() returns java.util.Enumeration");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETSCHEME, "ActionRequest has a getScheme()  method");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETSCHEMERETURNS,
            "ActionRequest method getScheme() returns String");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETSERVERNAME,
            "ActionRequest has a getServerName()  method");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETSERVERNAMERETURNS,
            "ActionRequest method getServerName() returns String");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETSERVERPORT,
            "ActionRequest has a getServerPort()  method");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETSERVERPORTRETURNS,
            "ActionRequest method getServerPort() returns int");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETUSERPRINCIPAL,
            "ActionRequest has a getUserPrincipal()  method");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETUSERPRINCIPALRETURNS,
            "ActionRequest method getUserPrincipal() returns java.security.Principal");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETWINDOWID, "ActionRequest has a getWindowID()  method");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETWINDOWIDRETURNS,
            "ActionRequest method getWindowID() returns String");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETWINDOWSTATE,
            "ActionRequest has a getWindowState()  method");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASGETWINDOWSTATERETURNS,
            "ActionRequest method getWindowState() returns WindowState");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASISPORTLETMODEALLOWED,
            "ActionRequest has a isPortletModeAllowed(PortletMode)  method");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASISPORTLETMODEALLOWEDRETURNS,
            "ActionRequest method isPortletModeAllowed(PortletMode) returns boolean");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASISREQUESTEDSESSIONIDVALID,
            "ActionRequest has a isRequestedSessionIdValid()  method");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASISREQUESTEDSESSIONIDVALIDRETURNS,
            "ActionRequest method isRequestedSessionIdValid() returns boolean");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASISSECURE, "ActionRequest has a isSecure()  method");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASISSECURERETURNS,
            "ActionRequest method isSecure() returns boolean");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASISUSERINROLE,
            "ActionRequest has a isUserInRole(String)  method");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASISUSERINROLERETURNS,
            "ActionRequest method isUserInRole(String) returns boolean");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASISWINDOWSTATEALLOWED,
            "ActionRequest has a isWindowStateAllowed(WindowState)  method");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASISWINDOWSTATEALLOWEDRETURNS,
            "ActionRequest method isWindowStateAllowed(WindowState) returns boolean");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASREMOVEATTRIBUTE,
            "ActionRequest has a removeAttribute(String)  method");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASREMOVEATTRIBUTERETURNS,
            "ActionRequest method removeAttribute(String) returns void");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASSETATTRIBUTE,
            "ActionRequest has a setAttribute(String, Object)  method");
      tcd.put(V2SIGTESTSACTION_PORTLETREQUEST_SIGACTION_HASSETATTRIBUTERETURNS,
            "ActionRequest method setAttribute(String, Object) returns void");
      tcd.put(V2SIGTESTSACTION_PORTLETRESPONSE_SIGACTION_HASADDPROPERTY,
            "ActionResponse has a addProperty(String, String)  method");
      tcd.put(V2SIGTESTSACTION_PORTLETRESPONSE_SIGACTION_HASADDPROPERTYA,
            "ActionResponse has a addProperty(javax.servlet.http.Cookie)  method");
      tcd.put(V2SIGTESTSACTION_PORTLETRESPONSE_SIGACTION_HASADDPROPERTYB,
            "ActionResponse has a addProperty(String, org.w3c.dom.Element)  method");
      tcd.put(V2SIGTESTSACTION_PORTLETRESPONSE_SIGACTION_HASADDPROPERTYRETURNS,
            "ActionResponse method addProperty(String, String) returns void");
      tcd.put(V2SIGTESTSACTION_PORTLETRESPONSE_SIGACTION_HASADDPROPERTYRETURNSA,
            "ActionResponse method addProperty(javax.servlet.http.Cookie) returns void");
      tcd.put(V2SIGTESTSACTION_PORTLETRESPONSE_SIGACTION_HASADDPROPERTYRETURNSB,
            "ActionResponse method addProperty(String, org.w3c.dom.Element) returns void");
      tcd.put(V2SIGTESTSACTION_PORTLETRESPONSE_SIGACTION_HASCREATEELEMENT,
            "ActionResponse has a createElement(String) throws org.w3c.dom.DOMException method");
      tcd.put(V2SIGTESTSACTION_PORTLETRESPONSE_SIGACTION_HASCREATEELEMENTRETURNS,
            "ActionResponse method createElement(String) returns org.w3c.dom.Element");
      tcd.put(V2SIGTESTSACTION_PORTLETRESPONSE_SIGACTION_HASENCODEURL,
            "ActionResponse has a encodeURL(String)  method");
      tcd.put(V2SIGTESTSACTION_PORTLETRESPONSE_SIGACTION_HASENCODEURLRETURNS,
            "ActionResponse method encodeURL(String) returns String");
      tcd.put(V2SIGTESTSACTION_PORTLETRESPONSE_SIGACTION_HASGETNAMESPACE,
            "ActionResponse has a getNamespace()  method");
      tcd.put(V2SIGTESTSACTION_PORTLETRESPONSE_SIGACTION_HASGETNAMESPACERETURNS,
            "ActionResponse method getNamespace() returns String");
      tcd.put(V2SIGTESTSACTION_PORTLETRESPONSE_SIGACTION_HASSETPROPERTY,
            "ActionResponse has a setProperty(String, String)  method");
      tcd.put(V2SIGTESTSACTION_PORTLETRESPONSE_SIGACTION_HASSETPROPERTYRETURNS,
            "ActionResponse method setProperty(String, String) returns void");
      tcd.put(V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASGETPORTLETMODE,
            "ActionResponse has a getPortletMode()  method");
      tcd.put(V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASGETPORTLETMODERETURNS,
            "ActionResponse method getPortletMode() returns PortletMode");
      tcd.put(V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASGETRENDERPARAMETERMAP,
            "ActionResponse has a getRenderParameterMap()  method");
      tcd.put(V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASGETRENDERPARAMETERMAPRETURNS,
            "ActionResponse method getRenderParameterMap() returns java.util.Map");
      tcd.put(V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASGETWINDOWSTATE,
            "ActionResponse has a getWindowState()  method");
      tcd.put(V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASGETWINDOWSTATERETURNS,
            "ActionResponse method getWindowState() returns WindowState");
      tcd.put(V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASREMOVEPUBLICRENDERPARAMETER,
            "ActionResponse has a removePublicRenderParameter(String)  method");
      tcd.put(V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASREMOVEPUBLICRENDERPARAMETERRETURNS,
            "ActionResponse method removePublicRenderParameter(String) returns void");
      tcd.put(V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASSETEVENT,
            "ActionResponse has a setEvent(javax.xml.namespace.QName, java.io.Serializable)  method");
      tcd.put(V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASSETEVENTA,
            "ActionResponse has a setEvent(String, java.io.Serializable)  method");
      tcd.put(V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASSETEVENTRETURNS,
            "ActionResponse method setEvent(javax.xml.namespace.QName, java.io.Serializable) returns void");
      tcd.put(V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASSETEVENTRETURNSA,
            "ActionResponse method setEvent(String, java.io.Serializable) returns void");
      tcd.put(V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASSETPORTLETMODE,
            "ActionResponse has a setPortletMode(PortletMode) throws PortletModeException method");
      tcd.put(V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASSETPORTLETMODERETURNS,
            "ActionResponse method setPortletMode(PortletMode) returns void");
      tcd.put(V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASSETRENDERPARAMETER,
            "ActionResponse has a setRenderParameter(String, String)  method");
      tcd.put(V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASSETRENDERPARAMETERA,
            "ActionResponse has a setRenderParameter(String, String[])  method");
      tcd.put(V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASSETRENDERPARAMETERRETURNS,
            "ActionResponse method setRenderParameter(String, String) returns void");
      tcd.put(V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASSETRENDERPARAMETERRETURNSA,
            "ActionResponse method setRenderParameter(String, String[]) returns void");
      tcd.put(V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASSETRENDERPARAMETERS,
            "ActionResponse has a setRenderParameters(java.util.Map)  method");
      tcd.put(V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASSETRENDERPARAMETERSRETURNS,
            "ActionResponse method setRenderParameters(java.util.Map) returns void");
      tcd.put(V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASSETWINDOWSTATE,
            "ActionResponse has a setWindowState(WindowState) throws WindowStateException method");
      tcd.put(V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_HASSETWINDOWSTATERETURNS,
            "ActionResponse method setWindowState(WindowState) returns void");
      tcd.put(V2SIGTESTSACTION_STATEAWARERESPONSE_SIGACTION_IMPLEMENTSPORTLETRESPONSE,
            "ActionResponse implements PortletResponse");
      tcd.put(V2SIGTESTSENV_CACHECONTROL_SIGRENDER_HASGETETAG, "CacheControl has a getETag()  method");
      tcd.put(V2SIGTESTSENV_CACHECONTROL_SIGRENDER_HASGETETAGRETURNS, "CacheControl method getETag() returns String");
      tcd.put(V2SIGTESTSENV_CACHECONTROL_SIGRENDER_HASGETEXPIRATIONTIME,
            "CacheControl has a getExpirationTime()  method");
      tcd.put(V2SIGTESTSENV_CACHECONTROL_SIGRENDER_HASGETEXPIRATIONTIMERETURNS,
            "CacheControl method getExpirationTime() returns int");
      tcd.put(V2SIGTESTSENV_CACHECONTROL_SIGRENDER_HASISPUBLICSCOPE, "CacheControl has a isPublicScope()  method");
      tcd.put(V2SIGTESTSENV_CACHECONTROL_SIGRENDER_HASISPUBLICSCOPERETURNS,
            "CacheControl method isPublicScope() returns boolean");
      tcd.put(V2SIGTESTSENV_CACHECONTROL_SIGRENDER_HASSETETAG, "CacheControl has a setETag(String)  method");
      tcd.put(V2SIGTESTSENV_CACHECONTROL_SIGRENDER_HASSETETAGRETURNS,
            "CacheControl method setETag(String) returns void");
      tcd.put(V2SIGTESTSENV_CACHECONTROL_SIGRENDER_HASSETEXPIRATIONTIME,
            "CacheControl has a setExpirationTime(int)  method");
      tcd.put(V2SIGTESTSENV_CACHECONTROL_SIGRENDER_HASSETEXPIRATIONTIMERETURNS,
            "CacheControl method setExpirationTime(int) returns void");
      tcd.put(V2SIGTESTSENV_CACHECONTROL_SIGRENDER_HASSETPUBLICSCOPE,
            "CacheControl has a setPublicScope(boolean)  method");
      tcd.put(V2SIGTESTSENV_CACHECONTROL_SIGRENDER_HASSETPUBLICSCOPERETURNS,
            "CacheControl method setPublicScope(boolean) returns void");
      tcd.put(V2SIGTESTSENV_CACHECONTROL_SIGRENDER_HASSETUSECACHEDCONTENT,
            "CacheControl has a setUseCachedContent(boolean)  method");
      tcd.put(V2SIGTESTSENV_CACHECONTROL_SIGRENDER_HASSETUSECACHEDCONTENTRETURNS,
            "CacheControl method setUseCachedContent(boolean) returns void");
      tcd.put(V2SIGTESTSENV_CACHECONTROL_SIGRENDER_HASUSECACHEDCONTENT,
            "CacheControl has a useCachedContent()  method");
      tcd.put(V2SIGTESTSENV_CACHECONTROL_SIGRENDER_HASUSECACHEDCONTENTRETURNS,
            "CacheControl method useCachedContent() returns boolean");
      tcd.put(V2SIGTESTSENV_EVENTPORTLET_SIGRENDER_HASPROCESSEVENT,
            "EventPortlet has a processEvent(EventRequest, EventResponse) throws PortletException, java.io.IOException method");
      tcd.put(V2SIGTESTSENV_EVENTPORTLET_SIGRENDER_HASPROCESSEVENTRETURNS,
            "EventPortlet method processEvent(EventRequest, EventResponse) returns void");
      tcd.put(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_CONSTRUCTOR,
            "GenericPortlet provides constructor GenericPortlet() ");
      tcd.put(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASDESTROY, "GenericPortlet has a destroy()  method");
      tcd.put(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASDESTROYRETURNS, "GenericPortlet method destroy() returns void");
      tcd.put(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASDODISPATCH,
            "GenericPortlet has a doDispatch(RenderRequest, RenderResponse) throws PortletException, java.io.IOException method");
      tcd.put(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASDODISPATCHRETURNS,
            "GenericPortlet method doDispatch(RenderRequest, RenderResponse) returns void");
      tcd.put(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASDOEDIT,
            "GenericPortlet has a doEdit(RenderRequest, RenderResponse) throws PortletException, java.io.IOException method");
      tcd.put(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASDOEDITRETURNS,
            "GenericPortlet method doEdit(RenderRequest, RenderResponse) returns void");
      tcd.put(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASDOHEADERS,
            "GenericPortlet has a doHeaders(RenderRequest, RenderResponse)  method");
      tcd.put(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASDOHEADERSRETURNS,
            "GenericPortlet method doHeaders(RenderRequest, RenderResponse) returns void");
      tcd.put(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASDOHELP,
            "GenericPortlet has a doHelp(RenderRequest, RenderResponse) throws PortletException, java.io.IOException method");
      tcd.put(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASDOHELPRETURNS,
            "GenericPortlet method doHelp(RenderRequest, RenderResponse) returns void");
      tcd.put(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASDOVIEW,
            "GenericPortlet has a doView(RenderRequest, RenderResponse) throws PortletException, java.io.IOException method");
      tcd.put(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASDOVIEWRETURNS,
            "GenericPortlet method doView(RenderRequest, RenderResponse) returns void");
      tcd.put(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETCONTAINERRUNTIMEOPTIONS,
            "GenericPortlet has a getContainerRuntimeOptions()  method");
      tcd.put(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETCONTAINERRUNTIMEOPTIONSRETURNS,
            "GenericPortlet method getContainerRuntimeOptions() returns java.util.Map");
      tcd.put(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETDEFAULTNAMESPACE,
            "GenericPortlet has a getDefaultNamespace()  method");
      tcd.put(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETDEFAULTNAMESPACERETURNS,
            "GenericPortlet method getDefaultNamespace() returns String");
      tcd.put(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETINITPARAMETER,
            "GenericPortlet has a getInitParameter(String)  method");
      tcd.put(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETINITPARAMETERNAMES,
            "GenericPortlet has a getInitParameterNames()  method");
      tcd.put(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETINITPARAMETERNAMESRETURNS,
            "GenericPortlet method getInitParameterNames() returns java.util.Enumeration");
      tcd.put(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETINITPARAMETERRETURNS,
            "GenericPortlet method getInitParameter(String) returns String");
      tcd.put(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETNEXTPOSSIBLEPORTLETMODES,
            "GenericPortlet has a getNextPossiblePortletModes(RenderRequest)  method");
      tcd.put(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETNEXTPOSSIBLEPORTLETMODESRETURNS,
            "GenericPortlet method getNextPossiblePortletModes(RenderRequest) returns java.util.Collection");
      tcd.put(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETPORTLETCONFIG,
            "GenericPortlet has a getPortletConfig()  method");
      tcd.put(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETPORTLETCONFIGRETURNS,
            "GenericPortlet method getPortletConfig() returns PortletConfig");
      tcd.put(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETPORTLETCONTEXT,
            "GenericPortlet has a getPortletContext()  method");
      tcd.put(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETPORTLETCONTEXTRETURNS,
            "GenericPortlet method getPortletContext() returns PortletContext");
      tcd.put(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETPORTLETNAME,
            "GenericPortlet has a getPortletName()  method");
      tcd.put(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETPORTLETNAMERETURNS,
            "GenericPortlet method getPortletName() returns String");
      tcd.put(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETPROCESSINGEVENTQNAMES,
            "GenericPortlet has a getProcessingEventQNames()  method");
      tcd.put(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETPROCESSINGEVENTQNAMESRETURNS,
            "GenericPortlet method getProcessingEventQNames() returns java.util.Enumeration");
      tcd.put(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETPUBLICRENDERPARAMETERNAMES,
            "GenericPortlet has a getPublicRenderParameterNames()  method");
      tcd.put(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETPUBLICRENDERPARAMETERNAMESRETURNS,
            "GenericPortlet method getPublicRenderParameterNames() returns java.util.Enumeration");
      tcd.put(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETPUBLISHINGEVENTQNAMES,
            "GenericPortlet has a getPublishingEventQNames()  method");
      tcd.put(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETPUBLISHINGEVENTQNAMESRETURNS,
            "GenericPortlet method getPublishingEventQNames() returns java.util.Enumeration");
      tcd.put(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETRESOURCEBUNDLE,
            "GenericPortlet has a getResourceBundle(java.util.Locale)  method");
      tcd.put(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETRESOURCEBUNDLERETURNS,
            "GenericPortlet method getResourceBundle(java.util.Locale) returns java.util.ResourceBundle");
      tcd.put(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETSUPPORTEDLOCALES,
            "GenericPortlet has a getSupportedLocales()  method");
      tcd.put(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETSUPPORTEDLOCALESRETURNS,
            "GenericPortlet method getSupportedLocales() returns java.util.Enumeration");
      tcd.put(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETTITLE,
            "GenericPortlet has a getTitle(RenderRequest)  method");
      tcd.put(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASGETTITLERETURNS,
            "GenericPortlet method getTitle(RenderRequest) returns String");
      tcd.put(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASINIT,
            "GenericPortlet has a init(PortletConfig) throws PortletException method");
      tcd.put(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASINITA,
            "GenericPortlet has a init() throws PortletException method");
      tcd.put(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASINITRETURNS,
            "GenericPortlet method init(PortletConfig) returns void");
      tcd.put(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASINITRETURNSA, "GenericPortlet method init() returns void");
      tcd.put(
            V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASPROCESSACTION,
            "GenericPortlet has a processAction(ActionRequest, ActionResponse) throws PortletException, java.io.IOException method");
      tcd.put(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASPROCESSACTIONRETURNS,
            "GenericPortlet method processAction(ActionRequest, ActionResponse) returns void");
      tcd.put(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASPROCESSEVENT,
            "GenericPortlet has a processEvent(EventRequest, EventResponse) throws PortletException, java.io.IOException method");
      tcd.put(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASPROCESSEVENTRETURNS,
            "GenericPortlet method processEvent(EventRequest, EventResponse) returns void");
      tcd.put(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASRENDER,
            "GenericPortlet has a render(RenderRequest, RenderResponse) throws PortletException, java.io.IOException method");
      tcd.put(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASRENDERRETURNS,
            "GenericPortlet method render(RenderRequest, RenderResponse) returns void");
      tcd.put(
            V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASSERVERESOURCE,
            "GenericPortlet has a serveResource(ResourceRequest, ResourceResponse) throws PortletException, java.io.IOException method");
      tcd.put(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_HASSERVERESOURCERETURNS,
            "GenericPortlet method serveResource(ResourceRequest, ResourceResponse) returns void");
      tcd.put(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_IMPLEMENTSEVENTPORTLET, "GenericPortlet implements EventPortlet");
      tcd.put(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_IMPLEMENTSPORTLET, "GenericPortlet implements Portlet");
      tcd.put(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_IMPLEMENTSPORTLETCONFIG,
            "GenericPortlet implements PortletConfig");
      tcd.put(V2SIGTESTSENV_GENERICPORTLET_SIGRENDER_IMPLEMENTSRESOURCESERVINGPORTLET,
            "GenericPortlet implements ResourceServingPortlet");
      tcd.put(V2SIGTESTSENV_PORTALCONTEXT_SIGRENDER_FIELDMARKUP_HEAD_ELEMENT_SUPPORT,
            "PortalContext has String field MARKUP_HEAD_ELEMENT_SUPPORT");
      tcd.put(V2SIGTESTSENV_PORTALCONTEXT_SIGRENDER_HASGETPORTALINFO, "PortalContext has a getPortalInfo()  method");
      tcd.put(V2SIGTESTSENV_PORTALCONTEXT_SIGRENDER_HASGETPORTALINFORETURNS,
            "PortalContext method getPortalInfo() returns String");
      tcd.put(V2SIGTESTSENV_PORTALCONTEXT_SIGRENDER_HASGETPROPERTY, "PortalContext has a getProperty(String)  method");
      tcd.put(V2SIGTESTSENV_PORTALCONTEXT_SIGRENDER_HASGETPROPERTYNAMES,
            "PortalContext has a getPropertyNames()  method");
      tcd.put(V2SIGTESTSENV_PORTALCONTEXT_SIGRENDER_HASGETPROPERTYNAMESRETURNS,
            "PortalContext method getPropertyNames() returns java.util.Enumeration");
      tcd.put(V2SIGTESTSENV_PORTALCONTEXT_SIGRENDER_HASGETPROPERTYRETURNS,
            "PortalContext method getProperty(String) returns String");
      tcd.put(V2SIGTESTSENV_PORTALCONTEXT_SIGRENDER_HASGETSUPPORTEDPORTLETMODES,
            "PortalContext has a getSupportedPortletModes()  method");
      tcd.put(V2SIGTESTSENV_PORTALCONTEXT_SIGRENDER_HASGETSUPPORTEDPORTLETMODESRETURNS,
            "PortalContext method getSupportedPortletModes() returns java.util.Enumeration");
      tcd.put(V2SIGTESTSENV_PORTALCONTEXT_SIGRENDER_HASGETSUPPORTEDWINDOWSTATES,
            "PortalContext has a getSupportedWindowStates()  method");
      tcd.put(V2SIGTESTSENV_PORTALCONTEXT_SIGRENDER_HASGETSUPPORTEDWINDOWSTATESRETURNS,
            "PortalContext method getSupportedWindowStates() returns java.util.Enumeration");
      tcd.put(V2SIGTESTSENV_PORTLET_SIGRENDER_HASDESTROY, "Portlet has a destroy()  method");
      tcd.put(V2SIGTESTSENV_PORTLET_SIGRENDER_HASDESTROYRETURNS, "Portlet method destroy() returns void");
      tcd.put(V2SIGTESTSENV_PORTLET_SIGRENDER_HASINIT,
            "Portlet has a init(PortletConfig) throws PortletException method");
      tcd.put(V2SIGTESTSENV_PORTLET_SIGRENDER_HASINITRETURNS, "Portlet method init(PortletConfig) returns void");
      tcd.put(V2SIGTESTSENV_PORTLET_SIGRENDER_HASPROCESSACTION,
            "Portlet has a processAction(ActionRequest, ActionResponse) throws PortletException, java.io.IOException method");
      tcd.put(V2SIGTESTSENV_PORTLET_SIGRENDER_HASPROCESSACTIONRETURNS,
            "Portlet method processAction(ActionRequest, ActionResponse) returns void");
      tcd.put(V2SIGTESTSENV_PORTLET_SIGRENDER_HASRENDER,
            "Portlet has a render(RenderRequest, RenderResponse) throws PortletException, java.io.IOException method");
      tcd.put(V2SIGTESTSENV_PORTLET_SIGRENDER_HASRENDERRETURNS,
            "Portlet method render(RenderRequest, RenderResponse) returns void");
      tcd.put(V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETCONTAINERRUNTIMEOPTIONS,
            "PortletConfig has a getContainerRuntimeOptions()  method");
      tcd.put(V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETCONTAINERRUNTIMEOPTIONSRETURNS,
            "PortletConfig method getContainerRuntimeOptions() returns java.util.Map");
      tcd.put(V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETDEFAULTNAMESPACE,
            "PortletConfig has a getDefaultNamespace()  method");
      tcd.put(V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETDEFAULTNAMESPACERETURNS,
            "PortletConfig method getDefaultNamespace() returns String");
      tcd.put(V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETINITPARAMETER,
            "PortletConfig has a getInitParameter(String)  method");
      tcd.put(V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETINITPARAMETERNAMES,
            "PortletConfig has a getInitParameterNames()  method");
      tcd.put(V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETINITPARAMETERNAMESRETURNS,
            "PortletConfig method getInitParameterNames() returns java.util.Enumeration");
      tcd.put(V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETINITPARAMETERRETURNS,
            "PortletConfig method getInitParameter(String) returns String");
      tcd.put(V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETPORTLETCONTEXT,
            "PortletConfig has a getPortletContext()  method");
      tcd.put(V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETPORTLETCONTEXTRETURNS,
            "PortletConfig method getPortletContext() returns PortletContext");
      tcd.put(V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETPORTLETNAME, "PortletConfig has a getPortletName()  method");
      tcd.put(V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETPORTLETNAMERETURNS,
            "PortletConfig method getPortletName() returns String");
      tcd.put(V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETPROCESSINGEVENTQNAMES,
            "PortletConfig has a getProcessingEventQNames()  method");
      tcd.put(V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETPROCESSINGEVENTQNAMESRETURNS,
            "PortletConfig method getProcessingEventQNames() returns java.util.Enumeration");
      tcd.put(V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETPUBLICRENDERPARAMETERNAMES,
            "PortletConfig has a getPublicRenderParameterNames()  method");
      tcd.put(V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETPUBLICRENDERPARAMETERNAMESRETURNS,
            "PortletConfig method getPublicRenderParameterNames() returns java.util.Enumeration");
      tcd.put(V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETPUBLISHINGEVENTQNAMES,
            "PortletConfig has a getPublishingEventQNames()  method");
      tcd.put(V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETPUBLISHINGEVENTQNAMESRETURNS,
            "PortletConfig method getPublishingEventQNames() returns java.util.Enumeration");
      tcd.put(V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETRESOURCEBUNDLE,
            "PortletConfig has a getResourceBundle(java.util.Locale)  method");
      tcd.put(V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETRESOURCEBUNDLERETURNS,
            "PortletConfig method getResourceBundle(java.util.Locale) returns java.util.ResourceBundle");
      tcd.put(V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETSUPPORTEDLOCALES,
            "PortletConfig has a getSupportedLocales()  method");
      tcd.put(V2SIGTESTSENV_PORTLETCONFIG_SIGRENDER_HASGETSUPPORTEDLOCALESRETURNS,
            "PortletConfig method getSupportedLocales() returns java.util.Enumeration");
      tcd.put(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETATTRIBUTE,
            "PortletContext has a getAttribute(String)  method");
      tcd.put(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETATTRIBUTENAMES,
            "PortletContext has a getAttributeNames()  method");
      tcd.put(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETATTRIBUTENAMESRETURNS,
            "PortletContext method getAttributeNames() returns java.util.Enumeration");
      tcd.put(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETATTRIBUTERETURNS,
            "PortletContext method getAttribute(String) returns Object");
      tcd.put(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETCONTAINERRUNTIMEOPTIONS,
            "PortletContext has a getContainerRuntimeOptions()  method");
      tcd.put(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETCONTAINERRUNTIMEOPTIONSRETURNS,
            "PortletContext method getContainerRuntimeOptions() returns java.util.Enumeration");
      tcd.put(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETINITPARAMETER,
            "PortletContext has a getInitParameter(String)  method");
      tcd.put(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETINITPARAMETERNAMES,
            "PortletContext has a getInitParameterNames()  method");
      tcd.put(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETINITPARAMETERNAMESRETURNS,
            "PortletContext method getInitParameterNames() returns java.util.Enumeration");
      tcd.put(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETINITPARAMETERRETURNS,
            "PortletContext method getInitParameter(String) returns String");
      tcd.put(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETMAJORVERSION,
            "PortletContext has a getMajorVersion()  method");
      tcd.put(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETMAJORVERSIONRETURNS,
            "PortletContext method getMajorVersion() returns int");
      tcd.put(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETMIMETYPE,
            "PortletContext has a getMimeType(String)  method");
      tcd.put(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETMIMETYPERETURNS,
            "PortletContext method getMimeType(String) returns String");
      tcd.put(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETMINORVERSION,
            "PortletContext has a getMinorVersion()  method");
      tcd.put(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETMINORVERSIONRETURNS,
            "PortletContext method getMinorVersion() returns int");
      tcd.put(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETNAMEDDISPATCHER,
            "PortletContext has a getNamedDispatcher(String)  method");
      tcd.put(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETNAMEDDISPATCHERRETURNS,
            "PortletContext method getNamedDispatcher(String) returns PortletRequestDispatcher");
      tcd.put(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETPORTLETCONTEXTNAME,
            "PortletContext has a getPortletContextName()  method");
      tcd.put(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETPORTLETCONTEXTNAMERETURNS,
            "PortletContext method getPortletContextName() returns String");
      tcd.put(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETREALPATH,
            "PortletContext has a getRealPath(String)  method");
      tcd.put(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETREALPATHRETURNS,
            "PortletContext method getRealPath(String) returns String");
      tcd.put(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETREQUESTDISPATCHER,
            "PortletContext has a getRequestDispatcher(String)  method");
      tcd.put(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETREQUESTDISPATCHERRETURNS,
            "PortletContext method getRequestDispatcher(String) returns PortletRequestDispatcher");
      tcd.put(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETRESOURCE,
            "PortletContext has a getResource(String) throws java.net.MalformedURLException method");
      tcd.put(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETRESOURCEASSTREAM,
            "PortletContext has a getResourceAsStream(String)  method");
      tcd.put(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETRESOURCEASSTREAMRETURNS,
            "PortletContext method getResourceAsStream(String) returns java.io.InputStream");
      tcd.put(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETRESOURCEPATHS,
            "PortletContext has a getResourcePaths(String)  method");
      tcd.put(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETRESOURCEPATHSRETURNS,
            "PortletContext method getResourcePaths(String) returns java.util.Set");
      tcd.put(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETRESOURCERETURNS,
            "PortletContext method getResource(String) returns java.net.URL");
      tcd.put(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETSERVERINFO, "PortletContext has a getServerInfo()  method");
      tcd.put(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASGETSERVERINFORETURNS,
            "PortletContext method getServerInfo() returns String");
      tcd.put(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASLOG, "PortletContext has a log(String)  method");
      tcd.put(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASLOGA, "PortletContext has a log(String, Throwable)  method");
      tcd.put(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASLOGRETURNS, "PortletContext method log(String) returns void");
      tcd.put(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASLOGRETURNSA,
            "PortletContext method log(String, Throwable) returns void");
      tcd.put(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASREMOVEATTRIBUTE,
            "PortletContext has a removeAttribute(String)  method");
      tcd.put(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASREMOVEATTRIBUTERETURNS,
            "PortletContext method removeAttribute(String) returns void");
      tcd.put(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASSETATTRIBUTE,
            "PortletContext has a setAttribute(String, Object)  method");
      tcd.put(V2SIGTESTSENV_PORTLETCONTEXT_SIGRENDER_HASSETATTRIBUTERETURNS,
            "PortletContext method setAttribute(String, Object) returns void");
      tcd.put(V2SIGTESTSENV_PORTLETMODE_SIGRENDER_CONSTRUCTOR, "PortletMode provides constructor PortletMode(String) ");
      tcd.put(V2SIGTESTSENV_PORTLETMODE_SIGRENDER_FIELDEDIT, "PortletMode has PortletMode field EDIT");
      tcd.put(V2SIGTESTSENV_PORTLETMODE_SIGRENDER_FIELDHELP, "PortletMode has PortletMode field HELP");
      tcd.put(V2SIGTESTSENV_PORTLETMODE_SIGRENDER_FIELDVIEW, "PortletMode has PortletMode field VIEW");
      tcd.put(V2SIGTESTSENV_PORTLETMODE_SIGRENDER_HASEQUALS, "PortletMode has a equals(Object)  method");
      tcd.put(V2SIGTESTSENV_PORTLETMODE_SIGRENDER_HASEQUALSRETURNS,
            "PortletMode method equals(Object) returns boolean");
      tcd.put(V2SIGTESTSENV_PORTLETMODE_SIGRENDER_HASHASHCODE, "PortletMode has a hashCode()  method");
      tcd.put(V2SIGTESTSENV_PORTLETMODE_SIGRENDER_HASHASHCODERETURNS, "PortletMode method hashCode() returns int");
      tcd.put(V2SIGTESTSENV_PORTLETMODE_SIGRENDER_HASTOSTRING, "PortletMode has a toString()  method");
      tcd.put(V2SIGTESTSENV_PORTLETMODE_SIGRENDER_HASTOSTRINGRETURNS, "PortletMode method toString() returns String");
      tcd.put(V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASGETMAP, "PortletPreferences has a getMap()  method");
      tcd.put(V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASGETMAPRETURNS,
            "PortletPreferences method getMap() returns java.util.Map");
      tcd.put(V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASGETNAMES, "PortletPreferences has a getNames()  method");
      tcd.put(V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASGETNAMESRETURNS,
            "PortletPreferences method getNames() returns java.util.Enumeration");
      tcd.put(V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASGETVALUE,
            "PortletPreferences has a getValue(String, String)  method");
      tcd.put(V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASGETVALUERETURNS,
            "PortletPreferences method getValue(String, String) returns String");
      tcd.put(V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASGETVALUES,
            "PortletPreferences has a getValues(String, String[])  method");
      tcd.put(V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASGETVALUESRETURNS,
            "PortletPreferences method getValues(String, String[]) returns String[] ");
      tcd.put(V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASISREADONLY,
            "PortletPreferences has a isReadOnly(String)  method");
      tcd.put(V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASISREADONLYRETURNS,
            "PortletPreferences method isReadOnly(String) returns boolean");
      tcd.put(V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASRESET,
            "PortletPreferences has a reset(String) throws ReadOnlyException method");
      tcd.put(V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASRESETRETURNS,
            "PortletPreferences method reset(String) returns void");
      tcd.put(V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASSETVALUE,
            "PortletPreferences has a setValue(String, String) throws ReadOnlyException method");
      tcd.put(V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASSETVALUERETURNS,
            "PortletPreferences method setValue(String, String) returns void");
      tcd.put(V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASSETVALUES,
            "PortletPreferences has a setValues(String, String[]) throws ReadOnlyException method");
      tcd.put(V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASSETVALUESRETURNS,
            "PortletPreferences method setValues(String, String[]) returns void");
      tcd.put(V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASSTORE,
            "PortletPreferences has a store() throws java.io.IOException, ValidatorException method");
      tcd.put(V2SIGTESTSENV_PORTLETPREFERENCES_SIGRENDER_HASSTORERETURNS,
            "PortletPreferences method store() returns void");
      tcd.put(
            V2SIGTESTSENV_PORTLETREQUESTDISPATCHER_SIGRENDER_HASFORWARD,
            "PortletRequestDispatcher has a forward(PortletRequest, PortletResponse) throws PortletException, java.io.IOException method");
      tcd.put(V2SIGTESTSENV_PORTLETREQUESTDISPATCHER_SIGRENDER_HASFORWARDRETURNS,
            "PortletRequestDispatcher method forward(PortletRequest, PortletResponse) returns void");
      tcd.put(
            V2SIGTESTSENV_PORTLETREQUESTDISPATCHER_SIGRENDER_HASINCLUDE,
            "PortletRequestDispatcher has a include(RenderRequest, RenderResponse) throws PortletException, java.io.IOException method");
      tcd.put(
            V2SIGTESTSENV_PORTLETREQUESTDISPATCHER_SIGRENDER_HASINCLUDEA,
            "PortletRequestDispatcher has a include(PortletRequest, PortletResponse) throws PortletException, java.io.IOException method");
      tcd.put(V2SIGTESTSENV_PORTLETREQUESTDISPATCHER_SIGRENDER_HASINCLUDERETURNS,
            "PortletRequestDispatcher method include(RenderRequest, RenderResponse) returns void");
      tcd.put(V2SIGTESTSENV_PORTLETREQUESTDISPATCHER_SIGRENDER_HASINCLUDERETURNSA,
            "PortletRequestDispatcher method include(PortletRequest, PortletResponse) returns void");
      tcd.put(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_FIELDAPPLICATION_SCOPE,
            "PortletSession has int field APPLICATION_SCOPE");
      tcd.put(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_FIELDPORTLET_SCOPE, "PortletSession has int field PORTLET_SCOPE");
      tcd.put(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETATTRIBUTE,
            "PortletSession has a getAttribute(String)  method");
      tcd.put(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETATTRIBUTEA,
            "PortletSession has a getAttribute(String, int)  method");
      tcd.put(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETATTRIBUTEMAP,
            "PortletSession has a getAttributeMap()  method");
      tcd.put(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETATTRIBUTEMAPA,
            "PortletSession has a getAttributeMap(int)  method");
      tcd.put(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETATTRIBUTEMAPRETURNS,
            "PortletSession method getAttributeMap() returns java.util.Map");
      tcd.put(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETATTRIBUTEMAPRETURNSA,
            "PortletSession method getAttributeMap(int) returns java.util.Map");
      tcd.put(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETATTRIBUTENAMES,
            "PortletSession has a getAttributeNames()  method");
      tcd.put(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETATTRIBUTENAMESA,
            "PortletSession has a getAttributeNames(int)  method");
      tcd.put(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETATTRIBUTENAMESRETURNS,
            "PortletSession method getAttributeNames() returns java.util.Enumeration");
      tcd.put(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETATTRIBUTENAMESRETURNSA,
            "PortletSession method getAttributeNames(int) returns java.util.Enumeration");
      tcd.put(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETATTRIBUTERETURNS,
            "PortletSession method getAttribute(String) returns Object");
      tcd.put(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETATTRIBUTERETURNSA,
            "PortletSession method getAttribute(String, int) returns Object");
      tcd.put(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETCREATIONTIME,
            "PortletSession has a getCreationTime()  method");
      tcd.put(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETCREATIONTIMERETURNS,
            "PortletSession method getCreationTime() returns long");
      tcd.put(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETID, "PortletSession has a getId()  method");
      tcd.put(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETIDRETURNS, "PortletSession method getId() returns String");
      tcd.put(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETLASTACCESSEDTIME,
            "PortletSession has a getLastAccessedTime()  method");
      tcd.put(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETLASTACCESSEDTIMERETURNS,
            "PortletSession method getLastAccessedTime() returns long");
      tcd.put(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETMAXINACTIVEINTERVAL,
            "PortletSession has a getMaxInactiveInterval()  method");
      tcd.put(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETMAXINACTIVEINTERVALRETURNS,
            "PortletSession method getMaxInactiveInterval() returns int");
      tcd.put(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETPORTLETCONTEXT,
            "PortletSession has a getPortletContext()  method");
      tcd.put(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASGETPORTLETCONTEXTRETURNS,
            "PortletSession method getPortletContext() returns PortletContext");
      tcd.put(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASINVALIDATE, "PortletSession has a invalidate()  method");
      tcd.put(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASINVALIDATERETURNS,
            "PortletSession method invalidate() returns void");
      tcd.put(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASISNEW, "PortletSession has a isNew()  method");
      tcd.put(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASISNEWRETURNS, "PortletSession method isNew() returns boolean");
      tcd.put(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASREMOVEATTRIBUTE,
            "PortletSession has a removeAttribute(String)  method");
      tcd.put(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASREMOVEATTRIBUTEA,
            "PortletSession has a removeAttribute(String, int)  method");
      tcd.put(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASREMOVEATTRIBUTERETURNS,
            "PortletSession method removeAttribute(String) returns void");
      tcd.put(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASREMOVEATTRIBUTERETURNSA,
            "PortletSession method removeAttribute(String, int) returns void");
      tcd.put(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASSETATTRIBUTE,
            "PortletSession has a setAttribute(String, Object)  method");
      tcd.put(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASSETATTRIBUTEA,
            "PortletSession has a setAttribute(String, Object, int)  method");
      tcd.put(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASSETATTRIBUTERETURNS,
            "PortletSession method setAttribute(String, Object) returns void");
      tcd.put(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASSETATTRIBUTERETURNSA,
            "PortletSession method setAttribute(String, Object, int) returns void");
      tcd.put(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASSETMAXINACTIVEINTERVAL,
            "PortletSession has a setMaxInactiveInterval(int)  method");
      tcd.put(V2SIGTESTSENV_PORTLETSESSION_SIGRENDER_HASSETMAXINACTIVEINTERVALRETURNS,
            "PortletSession method setMaxInactiveInterval(int) returns void");
      tcd.put(V2SIGTESTSENV_PORTLETSESSIONUTIL_SIGRENDER_CONSTRUCTOR,
            "PortletSessionUtil provides constructor PortletSessionUtil() ");
      tcd.put(V2SIGTESTSENV_PORTLETSESSIONUTIL_SIGRENDER_HASDECODEATTRIBUTENAME,
            "PortletSessionUtil has a decodeAttributeName(String)  method");
      tcd.put(V2SIGTESTSENV_PORTLETSESSIONUTIL_SIGRENDER_HASDECODEATTRIBUTENAMERETURNS,
            "PortletSessionUtil method decodeAttributeName(String) returns String");
      tcd.put(V2SIGTESTSENV_PORTLETSESSIONUTIL_SIGRENDER_HASDECODESCOPE,
            "PortletSessionUtil has a decodeScope(String)  method");
      tcd.put(V2SIGTESTSENV_PORTLETSESSIONUTIL_SIGRENDER_HASDECODESCOPERETURNS,
            "PortletSessionUtil method decodeScope(String) returns int");
      tcd.put(V2SIGTESTSENV_PORTLETURLGENERATIONLISTENER_SIGRENDER_HASFILTERACTIONURL,
            "PortletURLGenerationListener has a filterActionURL(PortletURL)  method");
      tcd.put(V2SIGTESTSENV_PORTLETURLGENERATIONLISTENER_SIGRENDER_HASFILTERACTIONURLRETURNS,
            "PortletURLGenerationListener method filterActionURL(PortletURL) returns void");
      tcd.put(V2SIGTESTSENV_PORTLETURLGENERATIONLISTENER_SIGRENDER_HASFILTERRENDERURL,
            "PortletURLGenerationListener has a filterRenderURL(PortletURL)  method");
      tcd.put(V2SIGTESTSENV_PORTLETURLGENERATIONLISTENER_SIGRENDER_HASFILTERRENDERURLRETURNS,
            "PortletURLGenerationListener method filterRenderURL(PortletURL) returns void");
      tcd.put(V2SIGTESTSENV_PORTLETURLGENERATIONLISTENER_SIGRENDER_HASFILTERRESOURCEURL,
            "PortletURLGenerationListener has a filterResourceURL(ResourceURL)  method");
      tcd.put(V2SIGTESTSENV_PORTLETURLGENERATIONLISTENER_SIGRENDER_HASFILTERRESOURCEURLRETURNS,
            "PortletURLGenerationListener method filterResourceURL(ResourceURL) returns void");
      tcd.put(V2SIGTESTSENV_PREFERENCESVALIDATOR_SIGRENDER_HASVALIDATE,
            "PreferencesValidator has a validate(PortletPreferences) throws ValidatorException method");
      tcd.put(V2SIGTESTSENV_PREFERENCESVALIDATOR_SIGRENDER_HASVALIDATERETURNS,
            "PreferencesValidator method validate(PortletPreferences) returns void");
      tcd.put(V2SIGTESTSENV_PROCESSACTION_SIGRENDER_HASNAME, "ProcessAction has a name()  method");
      tcd.put(V2SIGTESTSENV_PROCESSACTION_SIGRENDER_HASNAMERETURNS, "ProcessAction method name() returns String");
      tcd.put(V2SIGTESTSENV_PROCESSACTION_SIGRENDER_ISANNOTATION, "ProcessAction is an Annotation");
      tcd.put(V2SIGTESTSENV_PROCESSEVENT_SIGRENDER_HASNAME, "ProcessEvent has a name()  method");
      tcd.put(V2SIGTESTSENV_PROCESSEVENT_SIGRENDER_HASNAMERETURNS, "ProcessEvent method name() returns String");
      tcd.put(V2SIGTESTSENV_PROCESSEVENT_SIGRENDER_HASQNAME, "ProcessEvent has a qname()  method");
      tcd.put(V2SIGTESTSENV_PROCESSEVENT_SIGRENDER_HASQNAMERETURNS, "ProcessEvent method qname() returns String");
      tcd.put(V2SIGTESTSENV_PROCESSEVENT_SIGRENDER_ISANNOTATION, "ProcessEvent is an Annotation");
      tcd.put(V2SIGTESTSENV_RENDERMODE_SIGRENDER_HASNAME, "RenderMode has a name()  method");
      tcd.put(V2SIGTESTSENV_RENDERMODE_SIGRENDER_HASNAMERETURNS, "RenderMode method name() returns String");
      tcd.put(V2SIGTESTSENV_RENDERMODE_SIGRENDER_ISANNOTATION, "RenderMode is an Annotation");
      tcd.put(
            V2SIGTESTSENV_RESOURCESERVINGPORTLET_SIGRENDER_HASSERVERESOURCE,
            "ResourceServingPortlet has a serveResource(ResourceRequest, ResourceResponse) throws PortletException, java.io.IOException method");
      tcd.put(V2SIGTESTSENV_RESOURCESERVINGPORTLET_SIGRENDER_HASSERVERESOURCERETURNS,
            "ResourceServingPortlet method serveResource(ResourceRequest, ResourceResponse) returns void");
      tcd.put(V2SIGTESTSENV_WINDOWSTATE_SIGRENDER_CONSTRUCTOR, "WindowState provides constructor WindowState(String) ");
      tcd.put(V2SIGTESTSENV_WINDOWSTATE_SIGRENDER_FIELDMAXIMIZED, "WindowState has WindowState field MAXIMIZED");
      tcd.put(V2SIGTESTSENV_WINDOWSTATE_SIGRENDER_FIELDMINIMIZED, "WindowState has WindowState field MINIMIZED");
      tcd.put(V2SIGTESTSENV_WINDOWSTATE_SIGRENDER_FIELDNORMAL, "WindowState has WindowState field NORMAL");
      tcd.put(V2SIGTESTSENV_WINDOWSTATE_SIGRENDER_HASEQUALS, "WindowState has a equals(Object)  method");
      tcd.put(V2SIGTESTSENV_WINDOWSTATE_SIGRENDER_HASEQUALSRETURNS,
            "WindowState method equals(Object) returns boolean");
      tcd.put(V2SIGTESTSENV_WINDOWSTATE_SIGRENDER_HASHASHCODE, "WindowState has a hashCode()  method");
      tcd.put(V2SIGTESTSENV_WINDOWSTATE_SIGRENDER_HASHASHCODERETURNS, "WindowState method hashCode() returns int");
      tcd.put(V2SIGTESTSENV_WINDOWSTATE_SIGRENDER_HASTOSTRING, "WindowState has a toString()  method");
      tcd.put(V2SIGTESTSENV_WINDOWSTATE_SIGRENDER_HASTOSTRINGRETURNS, "WindowState method toString() returns String");
      tcd.put(V2SIGTESTSEVENT_EVENT_SIGEVENT_HASGETNAME, "Event has a getName()  method");
      tcd.put(V2SIGTESTSEVENT_EVENT_SIGEVENT_HASGETNAMERETURNS, "Event method getName() returns String");
      tcd.put(V2SIGTESTSEVENT_EVENT_SIGEVENT_HASGETQNAME, "Event has a getQName()  method");
      tcd.put(V2SIGTESTSEVENT_EVENT_SIGEVENT_HASGETQNAMERETURNS,
            "Event method getQName() returns javax.xml.namespace.QName");
      tcd.put(V2SIGTESTSEVENT_EVENT_SIGEVENT_HASGETVALUE, "Event has a getValue()  method");
      tcd.put(V2SIGTESTSEVENT_EVENT_SIGEVENT_HASGETVALUERETURNS,
            "Event method getValue() returns java.io.Serializable");
      tcd.put(V2SIGTESTSEVENT_EVENTREQUEST_SIGEVENT_HASGETEVENT, "EventRequest has a getEvent()  method");
      tcd.put(V2SIGTESTSEVENT_EVENTREQUEST_SIGEVENT_HASGETEVENTRETURNS, "EventRequest method getEvent() returns Event");
      tcd.put(V2SIGTESTSEVENT_EVENTREQUEST_SIGEVENT_HASGETMETHOD, "EventRequest has a getMethod()  method");
      tcd.put(V2SIGTESTSEVENT_EVENTREQUEST_SIGEVENT_HASGETMETHODRETURNS,
            "EventRequest method getMethod() returns String");
      tcd.put(V2SIGTESTSEVENT_EVENTREQUEST_SIGEVENT_IMPLEMENTSPORTLETREQUEST, "EventRequest implements PortletRequest");
      tcd.put(V2SIGTESTSEVENT_EVENTRESPONSE_SIGEVENT_HASSETRENDERPARAMETERS,
            "EventResponse has a setRenderParameters(EventRequest)  method");
      tcd.put(V2SIGTESTSEVENT_EVENTRESPONSE_SIGEVENT_HASSETRENDERPARAMETERSRETURNS,
            "EventResponse method setRenderParameters(EventRequest) returns void");
      tcd.put(V2SIGTESTSEVENT_EVENTRESPONSE_SIGEVENT_IMPLEMENTSSTATEAWARERESPONSE,
            "EventResponse implements StateAwareResponse");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_FIELDACTION_PHASE, "EventRequest has String field ACTION_PHASE");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_FIELDACTION_SCOPE_ID,
            "EventRequest has String field ACTION_SCOPE_ID");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_FIELDBASIC_AUTH, "EventRequest has String field BASIC_AUTH");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_FIELDCCPP_PROFILE, "EventRequest has String field CCPP_PROFILE");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_FIELDCLIENT_CERT_AUTH,
            "EventRequest has String field CLIENT_CERT_AUTH");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_FIELDDIGEST_AUTH, "EventRequest has String field DIGEST_AUTH");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_FIELDEVENT_PHASE, "EventRequest has String field EVENT_PHASE");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_FIELDFORM_AUTH, "EventRequest has String field FORM_AUTH");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_FIELDLIFECYCLE_PHASE,
            "EventRequest has String field LIFECYCLE_PHASE");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_FIELDRENDER_HEADERS,
            "EventRequest has String field RENDER_HEADERS");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_FIELDRENDER_MARKUP,
            "EventRequest has String field RENDER_MARKUP");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_FIELDRENDER_PART, "EventRequest has String field RENDER_PART");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_FIELDRENDER_PHASE, "EventRequest has String field RENDER_PHASE");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_FIELDRESOURCE_PHASE,
            "EventRequest has String field RESOURCE_PHASE");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_FIELDUSER_INFO, "EventRequest has String field USER_INFO");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETATTRIBUTE,
            "EventRequest has a getAttribute(String)  method");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETATTRIBUTENAMES,
            "EventRequest has a getAttributeNames()  method");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETATTRIBUTENAMESRETURNS,
            "EventRequest method getAttributeNames() returns java.util.Enumeration");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETATTRIBUTERETURNS,
            "EventRequest method getAttribute(String) returns Object");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETAUTHTYPE, "EventRequest has a getAuthType()  method");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETAUTHTYPERETURNS,
            "EventRequest method getAuthType() returns String");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETCONTEXTPATH, "EventRequest has a getContextPath()  method");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETCONTEXTPATHRETURNS,
            "EventRequest method getContextPath() returns String");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETCOOKIES, "EventRequest has a getCookies()  method");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETCOOKIESRETURNS,
            "EventRequest method getCookies() returns javax.servlet.http.Cookie[] ");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETLOCALE, "EventRequest has a getLocale()  method");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETLOCALERETURNS,
            "EventRequest method getLocale() returns java.util.Locale");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETLOCALES, "EventRequest has a getLocales()  method");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETLOCALESRETURNS,
            "EventRequest method getLocales() returns java.util.Enumeration");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPARAMETER,
            "EventRequest has a getParameter(String)  method");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPARAMETERMAP,
            "EventRequest has a getParameterMap()  method");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPARAMETERMAPRETURNS,
            "EventRequest method getParameterMap() returns java.util.Map");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPARAMETERNAMES,
            "EventRequest has a getParameterNames()  method");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPARAMETERNAMESRETURNS,
            "EventRequest method getParameterNames() returns java.util.Enumeration");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPARAMETERRETURNS,
            "EventRequest method getParameter(String) returns String");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPARAMETERVALUES,
            "EventRequest has a getParameterValues(String)  method");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPARAMETERVALUESRETURNS,
            "EventRequest method getParameterValues(String) returns String[] ");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPORTALCONTEXT,
            "EventRequest has a getPortalContext()  method");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPORTALCONTEXTRETURNS,
            "EventRequest method getPortalContext() returns PortalContext");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPORTLETMODE, "EventRequest has a getPortletMode()  method");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPORTLETMODERETURNS,
            "EventRequest method getPortletMode() returns PortletMode");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPORTLETSESSION,
            "EventRequest has a getPortletSession()  method");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPORTLETSESSIONA,
            "EventRequest has a getPortletSession(boolean)  method");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPORTLETSESSIONRETURNS,
            "EventRequest method getPortletSession() returns PortletSession");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPORTLETSESSIONRETURNSA,
            "EventRequest method getPortletSession(boolean) returns PortletSession");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPREFERENCES, "EventRequest has a getPreferences()  method");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPREFERENCESRETURNS,
            "EventRequest method getPreferences() returns PortletPreferences");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPRIVATEPARAMETERMAP,
            "EventRequest has a getPrivateParameterMap()  method");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPRIVATEPARAMETERMAPRETURNS,
            "EventRequest method getPrivateParameterMap() returns java.util.Map");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPROPERTIES,
            "EventRequest has a getProperties(String)  method");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPROPERTIESRETURNS,
            "EventRequest method getProperties(String) returns java.util.Enumeration");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPROPERTY, "EventRequest has a getProperty(String)  method");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPROPERTYNAMES,
            "EventRequest has a getPropertyNames()  method");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPROPERTYNAMESRETURNS,
            "EventRequest method getPropertyNames() returns java.util.Enumeration");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPROPERTYRETURNS,
            "EventRequest method getProperty(String) returns String");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPUBLICPARAMETERMAP,
            "EventRequest has a getPublicParameterMap()  method");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPUBLICPARAMETERMAPRETURNS,
            "EventRequest method getPublicParameterMap() returns java.util.Map");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETREMOTEUSER, "EventRequest has a getRemoteUser()  method");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETREMOTEUSERRETURNS,
            "EventRequest method getRemoteUser() returns String");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETREQUESTEDSESSIONID,
            "EventRequest has a getRequestedSessionId()  method");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETREQUESTEDSESSIONIDRETURNS,
            "EventRequest method getRequestedSessionId() returns String");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETRESPONSECONTENTTYPE,
            "EventRequest has a getResponseContentType()  method");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETRESPONSECONTENTTYPERETURNS,
            "EventRequest method getResponseContentType() returns String");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETRESPONSECONTENTTYPES,
            "EventRequest has a getResponseContentTypes()  method");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETRESPONSECONTENTTYPESRETURNS,
            "EventRequest method getResponseContentTypes() returns java.util.Enumeration");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETSCHEME, "EventRequest has a getScheme()  method");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETSCHEMERETURNS,
            "EventRequest method getScheme() returns String");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETSERVERNAME, "EventRequest has a getServerName()  method");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETSERVERNAMERETURNS,
            "EventRequest method getServerName() returns String");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETSERVERPORT, "EventRequest has a getServerPort()  method");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETSERVERPORTRETURNS,
            "EventRequest method getServerPort() returns int");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETUSERPRINCIPAL,
            "EventRequest has a getUserPrincipal()  method");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETUSERPRINCIPALRETURNS,
            "EventRequest method getUserPrincipal() returns java.security.Principal");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETWINDOWID, "EventRequest has a getWindowID()  method");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETWINDOWIDRETURNS,
            "EventRequest method getWindowID() returns String");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETWINDOWSTATE, "EventRequest has a getWindowState()  method");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETWINDOWSTATERETURNS,
            "EventRequest method getWindowState() returns WindowState");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASISPORTLETMODEALLOWED,
            "EventRequest has a isPortletModeAllowed(PortletMode)  method");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASISPORTLETMODEALLOWEDRETURNS,
            "EventRequest method isPortletModeAllowed(PortletMode) returns boolean");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASISREQUESTEDSESSIONIDVALID,
            "EventRequest has a isRequestedSessionIdValid()  method");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASISREQUESTEDSESSIONIDVALIDRETURNS,
            "EventRequest method isRequestedSessionIdValid() returns boolean");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASISSECURE, "EventRequest has a isSecure()  method");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASISSECURERETURNS,
            "EventRequest method isSecure() returns boolean");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASISUSERINROLE,
            "EventRequest has a isUserInRole(String)  method");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASISUSERINROLERETURNS,
            "EventRequest method isUserInRole(String) returns boolean");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASISWINDOWSTATEALLOWED,
            "EventRequest has a isWindowStateAllowed(WindowState)  method");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASISWINDOWSTATEALLOWEDRETURNS,
            "EventRequest method isWindowStateAllowed(WindowState) returns boolean");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASREMOVEATTRIBUTE,
            "EventRequest has a removeAttribute(String)  method");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASREMOVEATTRIBUTERETURNS,
            "EventRequest method removeAttribute(String) returns void");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASSETATTRIBUTE,
            "EventRequest has a setAttribute(String, Object)  method");
      tcd.put(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASSETATTRIBUTERETURNS,
            "EventRequest method setAttribute(String, Object) returns void");
      tcd.put(V2SIGTESTSEVENT_PORTLETRESPONSE_SIGEVENT_HASADDPROPERTY,
            "EventResponse has a addProperty(String, String)  method");
      tcd.put(V2SIGTESTSEVENT_PORTLETRESPONSE_SIGEVENT_HASADDPROPERTYA,
            "EventResponse has a addProperty(javax.servlet.http.Cookie)  method");
      tcd.put(V2SIGTESTSEVENT_PORTLETRESPONSE_SIGEVENT_HASADDPROPERTYB,
            "EventResponse has a addProperty(String, org.w3c.dom.Element)  method");
      tcd.put(V2SIGTESTSEVENT_PORTLETRESPONSE_SIGEVENT_HASADDPROPERTYRETURNS,
            "EventResponse method addProperty(String, String) returns void");
      tcd.put(V2SIGTESTSEVENT_PORTLETRESPONSE_SIGEVENT_HASADDPROPERTYRETURNSA,
            "EventResponse method addProperty(javax.servlet.http.Cookie) returns void");
      tcd.put(V2SIGTESTSEVENT_PORTLETRESPONSE_SIGEVENT_HASADDPROPERTYRETURNSB,
            "EventResponse method addProperty(String, org.w3c.dom.Element) returns void");
      tcd.put(V2SIGTESTSEVENT_PORTLETRESPONSE_SIGEVENT_HASCREATEELEMENT,
            "EventResponse has a createElement(String) throws org.w3c.dom.DOMException method");
      tcd.put(V2SIGTESTSEVENT_PORTLETRESPONSE_SIGEVENT_HASCREATEELEMENTRETURNS,
            "EventResponse method createElement(String) returns org.w3c.dom.Element");
      tcd.put(V2SIGTESTSEVENT_PORTLETRESPONSE_SIGEVENT_HASENCODEURL, "EventResponse has a encodeURL(String)  method");
      tcd.put(V2SIGTESTSEVENT_PORTLETRESPONSE_SIGEVENT_HASENCODEURLRETURNS,
            "EventResponse method encodeURL(String) returns String");
      tcd.put(V2SIGTESTSEVENT_PORTLETRESPONSE_SIGEVENT_HASGETNAMESPACE, "EventResponse has a getNamespace()  method");
      tcd.put(V2SIGTESTSEVENT_PORTLETRESPONSE_SIGEVENT_HASGETNAMESPACERETURNS,
            "EventResponse method getNamespace() returns String");
      tcd.put(V2SIGTESTSEVENT_PORTLETRESPONSE_SIGEVENT_HASSETPROPERTY,
            "EventResponse has a setProperty(String, String)  method");
      tcd.put(V2SIGTESTSEVENT_PORTLETRESPONSE_SIGEVENT_HASSETPROPERTYRETURNS,
            "EventResponse method setProperty(String, String) returns void");
      tcd.put(V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASGETPORTLETMODE,
            "EventResponse has a getPortletMode()  method");
      tcd.put(V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASGETPORTLETMODERETURNS,
            "EventResponse method getPortletMode() returns PortletMode");
      tcd.put(V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASGETRENDERPARAMETERMAP,
            "EventResponse has a getRenderParameterMap()  method");
      tcd.put(V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASGETRENDERPARAMETERMAPRETURNS,
            "EventResponse method getRenderParameterMap() returns java.util.Map");
      tcd.put(V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASGETWINDOWSTATE,
            "EventResponse has a getWindowState()  method");
      tcd.put(V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASGETWINDOWSTATERETURNS,
            "EventResponse method getWindowState() returns WindowState");
      tcd.put(V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASREMOVEPUBLICRENDERPARAMETER,
            "EventResponse has a removePublicRenderParameter(String)  method");
      tcd.put(V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASREMOVEPUBLICRENDERPARAMETERRETURNS,
            "EventResponse method removePublicRenderParameter(String) returns void");
      tcd.put(V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASSETEVENT,
            "EventResponse has a setEvent(javax.xml.namespace.QName, java.io.Serializable)  method");
      tcd.put(V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASSETEVENTA,
            "EventResponse has a setEvent(String, java.io.Serializable)  method");
      tcd.put(V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASSETEVENTRETURNS,
            "EventResponse method setEvent(javax.xml.namespace.QName, java.io.Serializable) returns void");
      tcd.put(V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASSETEVENTRETURNSA,
            "EventResponse method setEvent(String, java.io.Serializable) returns void");
      tcd.put(V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASSETPORTLETMODE,
            "EventResponse has a setPortletMode(PortletMode) throws PortletModeException method");
      tcd.put(V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASSETPORTLETMODERETURNS,
            "EventResponse method setPortletMode(PortletMode) returns void");
      tcd.put(V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASSETRENDERPARAMETER,
            "EventResponse has a setRenderParameter(String, String)  method");
      tcd.put(V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASSETRENDERPARAMETERA,
            "EventResponse has a setRenderParameter(String, String[])  method");
      tcd.put(V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASSETRENDERPARAMETERRETURNS,
            "EventResponse method setRenderParameter(String, String) returns void");
      tcd.put(V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASSETRENDERPARAMETERRETURNSA,
            "EventResponse method setRenderParameter(String, String[]) returns void");
      tcd.put(V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASSETRENDERPARAMETERS,
            "EventResponse has a setRenderParameters(java.util.Map)  method");
      tcd.put(V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASSETRENDERPARAMETERSRETURNS,
            "EventResponse method setRenderParameters(java.util.Map) returns void");
      tcd.put(V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASSETWINDOWSTATE,
            "EventResponse has a setWindowState(WindowState) throws WindowStateException method");
      tcd.put(V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_HASSETWINDOWSTATERETURNS,
            "EventResponse method setWindowState(WindowState) returns void");
      tcd.put(V2SIGTESTSEVENT_STATEAWARERESPONSE_SIGEVENT_IMPLEMENTSPORTLETRESPONSE,
            "EventResponse implements PortletResponse");
      tcd.put(V2SIGTESTSEXCEPTION_PORTLETEXCEPTION_SIGRENDER_CONSTRUCTOR,
            "PortletException provides constructor PortletException() ");
      tcd.put(V2SIGTESTSEXCEPTION_PORTLETEXCEPTION_SIGRENDER_CONSTRUCTORA,
            "PortletException provides constructor PortletException(String) ");
      tcd.put(V2SIGTESTSEXCEPTION_PORTLETEXCEPTION_SIGRENDER_CONSTRUCTORB,
            "PortletException provides constructor PortletException(String, Throwable) ");
      tcd.put(V2SIGTESTSEXCEPTION_PORTLETEXCEPTION_SIGRENDER_CONSTRUCTORC,
            "PortletException provides constructor PortletException(Throwable) ");
      tcd.put(V2SIGTESTSEXCEPTION_PORTLETEXCEPTION_SIGRENDER_EXTENDSEXCEPTION, "PortletException extends Exception");
      tcd.put(V2SIGTESTSEXCEPTION_PORTLETMODEEXCEPTION_SIGRENDER_CONSTRUCTOR,
            "PortletModeException provides constructor PortletModeException(String, PortletMode) ");
      tcd.put(V2SIGTESTSEXCEPTION_PORTLETMODEEXCEPTION_SIGRENDER_CONSTRUCTORA,
            "PortletModeException provides constructor PortletModeException(String, Throwable, PortletMode) ");
      tcd.put(V2SIGTESTSEXCEPTION_PORTLETMODEEXCEPTION_SIGRENDER_CONSTRUCTORB,
            "PortletModeException provides constructor PortletModeException(Throwable, PortletMode) ");
      tcd.put(V2SIGTESTSEXCEPTION_PORTLETMODEEXCEPTION_SIGRENDER_EXTENDSPORTLETEXCEPTION,
            "PortletModeException extends PortletException");
      tcd.put(V2SIGTESTSEXCEPTION_PORTLETMODEEXCEPTION_SIGRENDER_HASGETMODE,
            "PortletModeException has a getMode()  method");
      tcd.put(V2SIGTESTSEXCEPTION_PORTLETMODEEXCEPTION_SIGRENDER_HASGETMODERETURNS,
            "PortletModeException method getMode() returns PortletMode");
      tcd.put(V2SIGTESTSEXCEPTION_PORTLETSECURITYEXCEPTION_SIGRENDER_CONSTRUCTOR,
            "PortletSecurityException provides constructor PortletSecurityException(String) ");
      tcd.put(V2SIGTESTSEXCEPTION_PORTLETSECURITYEXCEPTION_SIGRENDER_CONSTRUCTORA,
            "PortletSecurityException provides constructor PortletSecurityException(String, Throwable) ");
      tcd.put(V2SIGTESTSEXCEPTION_PORTLETSECURITYEXCEPTION_SIGRENDER_CONSTRUCTORB,
            "PortletSecurityException provides constructor PortletSecurityException(Throwable) ");
      tcd.put(V2SIGTESTSEXCEPTION_PORTLETSECURITYEXCEPTION_SIGRENDER_EXTENDSPORTLETEXCEPTION,
            "PortletSecurityException extends PortletException");
      tcd.put(V2SIGTESTSEXCEPTION_READONLYEXCEPTION_SIGRENDER_CONSTRUCTOR,
            "ReadOnlyException provides constructor ReadOnlyException(String) ");
      tcd.put(V2SIGTESTSEXCEPTION_READONLYEXCEPTION_SIGRENDER_CONSTRUCTORA,
            "ReadOnlyException provides constructor ReadOnlyException(String, Throwable) ");
      tcd.put(V2SIGTESTSEXCEPTION_READONLYEXCEPTION_SIGRENDER_CONSTRUCTORB,
            "ReadOnlyException provides constructor ReadOnlyException(Throwable) ");
      tcd.put(V2SIGTESTSEXCEPTION_READONLYEXCEPTION_SIGRENDER_EXTENDSPORTLETEXCEPTION,
            "ReadOnlyException extends PortletException");
      tcd.put(V2SIGTESTSEXCEPTION_UNAVAILABLEEXCEPTION_SIGRENDER_CONSTRUCTOR,
            "UnavailableException provides constructor UnavailableException(String) ");
      tcd.put(V2SIGTESTSEXCEPTION_UNAVAILABLEEXCEPTION_SIGRENDER_CONSTRUCTORA,
            "UnavailableException provides constructor UnavailableException(String, int) ");
      tcd.put(V2SIGTESTSEXCEPTION_UNAVAILABLEEXCEPTION_SIGRENDER_EXTENDSPORTLETEXCEPTION,
            "UnavailableException extends PortletException");
      tcd.put(V2SIGTESTSEXCEPTION_UNAVAILABLEEXCEPTION_SIGRENDER_HASGETUNAVAILABLESECONDS,
            "UnavailableException has a getUnavailableSeconds()  method");
      tcd.put(V2SIGTESTSEXCEPTION_UNAVAILABLEEXCEPTION_SIGRENDER_HASGETUNAVAILABLESECONDSRETURNS,
            "UnavailableException method getUnavailableSeconds() returns int");
      tcd.put(V2SIGTESTSEXCEPTION_UNAVAILABLEEXCEPTION_SIGRENDER_HASISPERMANENT,
            "UnavailableException has a isPermanent()  method");
      tcd.put(V2SIGTESTSEXCEPTION_UNAVAILABLEEXCEPTION_SIGRENDER_HASISPERMANENTRETURNS,
            "UnavailableException method isPermanent() returns boolean");
      tcd.put(V2SIGTESTSEXCEPTION_VALIDATOREXCEPTION_SIGRENDER_CONSTRUCTOR,
            "ValidatorException provides constructor ValidatorException(String, java.util.Collection) ");
      tcd.put(V2SIGTESTSEXCEPTION_VALIDATOREXCEPTION_SIGRENDER_CONSTRUCTORA,
            "ValidatorException provides constructor ValidatorException(String, Throwable, java.util.Collection) ");
      tcd.put(V2SIGTESTSEXCEPTION_VALIDATOREXCEPTION_SIGRENDER_CONSTRUCTORB,
            "ValidatorException provides constructor ValidatorException(Throwable, java.util.Collection) ");
      tcd.put(V2SIGTESTSEXCEPTION_VALIDATOREXCEPTION_SIGRENDER_EXTENDSPORTLETEXCEPTION,
            "ValidatorException extends PortletException");
      tcd.put(V2SIGTESTSEXCEPTION_VALIDATOREXCEPTION_SIGRENDER_HASGETFAILEDKEYS,
            "ValidatorException has a getFailedKeys()  method");
      tcd.put(V2SIGTESTSEXCEPTION_VALIDATOREXCEPTION_SIGRENDER_HASGETFAILEDKEYSRETURNS,
            "ValidatorException method getFailedKeys() returns java.util.Enumeration");
      tcd.put(V2SIGTESTSEXCEPTION_WINDOWSTATEEXCEPTION_SIGRENDER_CONSTRUCTOR,
            "WindowStateException provides constructor WindowStateException(String, WindowState) ");
      tcd.put(V2SIGTESTSEXCEPTION_WINDOWSTATEEXCEPTION_SIGRENDER_CONSTRUCTORA,
            "WindowStateException provides constructor WindowStateException(String, Throwable, WindowState) ");
      tcd.put(V2SIGTESTSEXCEPTION_WINDOWSTATEEXCEPTION_SIGRENDER_CONSTRUCTORB,
            "WindowStateException provides constructor WindowStateException(Throwable, WindowState) ");
      tcd.put(V2SIGTESTSEXCEPTION_WINDOWSTATEEXCEPTION_SIGRENDER_EXTENDSPORTLETEXCEPTION,
            "WindowStateException extends PortletException");
      tcd.put(V2SIGTESTSEXCEPTION_WINDOWSTATEEXCEPTION_SIGRENDER_HASGETSTATE,
            "WindowStateException has a getState()  method");
      tcd.put(V2SIGTESTSEXCEPTION_WINDOWSTATEEXCEPTION_SIGRENDER_HASGETSTATERETURNS,
            "WindowStateException method getState() returns WindowState");
      tcd.put(
            V2SIGTESTSFILTER_ACTIONFILTER_SIGRENDER_HASDOFILTER,
            "ActionFilter has a doFilter(ActionRequest, ActionResponse, javax.portlet.filter.FilterChain) throws java.io.IOException, PortletException method");
      tcd.put(V2SIGTESTSFILTER_ACTIONFILTER_SIGRENDER_HASDOFILTERRETURNS,
            "ActionFilter method doFilter(ActionRequest, ActionResponse, javax.portlet.filter.FilterChain) returns void");
      tcd.put(V2SIGTESTSFILTER_ACTIONFILTER_SIGRENDER_IMPLEMENTSPORTLETFILTER, "ActionFilter implements PortletFilter");
      tcd.put(
            V2SIGTESTSFILTER_EVENTFILTER_SIGRENDER_HASDOFILTER,
            "EventFilter has a doFilter(EventRequest, EventResponse, javax.portlet.filter.FilterChain) throws java.io.IOException, PortletException method");
      tcd.put(V2SIGTESTSFILTER_EVENTFILTER_SIGRENDER_HASDOFILTERRETURNS,
            "EventFilter method doFilter(EventRequest, EventResponse, javax.portlet.filter.FilterChain) returns void");
      tcd.put(V2SIGTESTSFILTER_EVENTFILTER_SIGRENDER_IMPLEMENTSPORTLETFILTER, "EventFilter implements PortletFilter");
      tcd.put(V2SIGTESTSFILTER_FILTERCHAIN_SIGRENDER_HASDOFILTER,
            "FilterChain has a doFilter(ActionRequest, ActionResponse) throws java.io.IOException, PortletException method");
      tcd.put(V2SIGTESTSFILTER_FILTERCHAIN_SIGRENDER_HASDOFILTERA,
            "FilterChain has a doFilter(EventRequest, EventResponse) throws java.io.IOException, PortletException method");
      tcd.put(V2SIGTESTSFILTER_FILTERCHAIN_SIGRENDER_HASDOFILTERB,
            "FilterChain has a doFilter(RenderRequest, RenderResponse) throws java.io.IOException, PortletException method");
      tcd.put(V2SIGTESTSFILTER_FILTERCHAIN_SIGRENDER_HASDOFILTERC,
            "FilterChain has a doFilter(ResourceRequest, ResourceResponse) throws java.io.IOException, PortletException method");
      tcd.put(V2SIGTESTSFILTER_FILTERCHAIN_SIGRENDER_HASDOFILTERRETURNS,
            "FilterChain method doFilter(ActionRequest, ActionResponse) returns void");
      tcd.put(V2SIGTESTSFILTER_FILTERCHAIN_SIGRENDER_HASDOFILTERRETURNSA,
            "FilterChain method doFilter(EventRequest, EventResponse) returns void");
      tcd.put(V2SIGTESTSFILTER_FILTERCHAIN_SIGRENDER_HASDOFILTERRETURNSB,
            "FilterChain method doFilter(RenderRequest, RenderResponse) returns void");
      tcd.put(V2SIGTESTSFILTER_FILTERCHAIN_SIGRENDER_HASDOFILTERRETURNSC,
            "FilterChain method doFilter(ResourceRequest, ResourceResponse) returns void");
      tcd.put(V2SIGTESTSFILTER_FILTERCONFIG_SIGRENDER_HASGETFILTERNAME, "FilterConfig has a getFilterName()  method");
      tcd.put(V2SIGTESTSFILTER_FILTERCONFIG_SIGRENDER_HASGETFILTERNAMERETURNS,
            "FilterConfig method getFilterName() returns String");
      tcd.put(V2SIGTESTSFILTER_FILTERCONFIG_SIGRENDER_HASGETINITPARAMETER,
            "FilterConfig has a getInitParameter(String)  method");
      tcd.put(V2SIGTESTSFILTER_FILTERCONFIG_SIGRENDER_HASGETINITPARAMETERNAMES,
            "FilterConfig has a getInitParameterNames()  method");
      tcd.put(V2SIGTESTSFILTER_FILTERCONFIG_SIGRENDER_HASGETINITPARAMETERNAMESRETURNS,
            "FilterConfig method getInitParameterNames() returns java.util.Enumeration");
      tcd.put(V2SIGTESTSFILTER_FILTERCONFIG_SIGRENDER_HASGETINITPARAMETERRETURNS,
            "FilterConfig method getInitParameter(String) returns String");
      tcd.put(V2SIGTESTSFILTER_FILTERCONFIG_SIGRENDER_HASGETPORTLETCONTEXT,
            "FilterConfig has a getPortletContext()  method");
      tcd.put(V2SIGTESTSFILTER_FILTERCONFIG_SIGRENDER_HASGETPORTLETCONTEXTRETURNS,
            "FilterConfig method getPortletContext() returns PortletContext");
      tcd.put(V2SIGTESTSFILTER_PORTLETFILTER_SIGRENDER_HASDESTROY, "PortletFilter has a destroy()  method");
      tcd.put(V2SIGTESTSFILTER_PORTLETFILTER_SIGRENDER_HASDESTROYRETURNS,
            "PortletFilter method destroy() returns void");
      tcd.put(V2SIGTESTSFILTER_PORTLETFILTER_SIGRENDER_HASINIT,
            "PortletFilter has a init(javax.portlet.filter.FilterConfig) throws PortletException method");
      tcd.put(V2SIGTESTSFILTER_PORTLETFILTER_SIGRENDER_HASINITRETURNS,
            "PortletFilter method init(javax.portlet.filter.FilterConfig) returns void");
      tcd.put(
            V2SIGTESTSFILTER_RENDERFILTER_SIGRENDER_HASDOFILTER,
            "RenderFilter has a doFilter(RenderRequest, RenderResponse, javax.portlet.filter.FilterChain) throws java.io.IOException, PortletException method");
      tcd.put(V2SIGTESTSFILTER_RENDERFILTER_SIGRENDER_HASDOFILTERRETURNS,
            "RenderFilter method doFilter(RenderRequest, RenderResponse, javax.portlet.filter.FilterChain) returns void");
      tcd.put(V2SIGTESTSFILTER_RENDERFILTER_SIGRENDER_IMPLEMENTSPORTLETFILTER, "RenderFilter implements PortletFilter");
      tcd.put(
            V2SIGTESTSFILTER_RESOURCEFILTER_SIGRENDER_HASDOFILTER,
            "ResourceFilter has a doFilter(ResourceRequest, ResourceResponse, javax.portlet.filter.FilterChain) throws java.io.IOException, PortletException method");
      tcd.put(V2SIGTESTSFILTER_RESOURCEFILTER_SIGRENDER_HASDOFILTERRETURNS,
            "ResourceFilter method doFilter(ResourceRequest, ResourceResponse, javax.portlet.filter.FilterChain) returns void");
      tcd.put(V2SIGTESTSFILTER_RESOURCEFILTER_SIGRENDER_IMPLEMENTSPORTLETFILTER,
            "ResourceFilter implements PortletFilter");
      tcd.put(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_FIELDCACHE_SCOPE, "RenderResponse has String field CACHE_SCOPE");
      tcd.put(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_FIELDETAG, "RenderResponse has String field ETAG");
      tcd.put(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_FIELDEXPIRATION_CACHE,
            "RenderResponse has String field EXPIRATION_CACHE");
      tcd.put(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_FIELDMARKUP_HEAD_ELEMENT,
            "RenderResponse has String field MARKUP_HEAD_ELEMENT");
      tcd.put(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_FIELDNAMESPACED_RESPONSE,
            "RenderResponse has String field NAMESPACED_RESPONSE");
      tcd.put(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_FIELDPRIVATE_SCOPE,
            "RenderResponse has String field PRIVATE_SCOPE");
      tcd.put(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_FIELDPUBLIC_SCOPE,
            "RenderResponse has String field PUBLIC_SCOPE");
      tcd.put(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_FIELDUSE_CACHED_CONTENT,
            "RenderResponse has String field USE_CACHED_CONTENT");
      tcd.put(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASCREATEACTIONURL,
            "RenderResponse has a createActionURL()  method");
      tcd.put(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASCREATEACTIONURLRETURNS,
            "RenderResponse method createActionURL() returns PortletURL");
      tcd.put(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASCREATERENDERURL,
            "RenderResponse has a createRenderURL()  method");
      tcd.put(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASCREATERENDERURLRETURNS,
            "RenderResponse method createRenderURL() returns PortletURL");
      tcd.put(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASCREATERESOURCEURL,
            "RenderResponse has a createResourceURL()  method");
      tcd.put(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASCREATERESOURCEURLRETURNS,
            "RenderResponse method createResourceURL() returns ResourceURL");
      tcd.put(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASFLUSHBUFFER,
            "RenderResponse has a flushBuffer() throws java.io.IOException method");
      tcd.put(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASFLUSHBUFFERRETURNS,
            "RenderResponse method flushBuffer() returns void");
      tcd.put(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASGETBUFFERSIZE, "RenderResponse has a getBufferSize()  method");
      tcd.put(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASGETBUFFERSIZERETURNS,
            "RenderResponse method getBufferSize() returns int");
      tcd.put(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASGETCACHECONTROL,
            "RenderResponse has a getCacheControl()  method");
      tcd.put(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASGETCACHECONTROLRETURNS,
            "RenderResponse method getCacheControl() returns CacheControl");
      tcd.put(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASGETCHARACTERENCODING,
            "RenderResponse has a getCharacterEncoding()  method");
      tcd.put(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASGETCHARACTERENCODINGRETURNS,
            "RenderResponse method getCharacterEncoding() returns String");
      tcd.put(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASGETCONTENTTYPE,
            "RenderResponse has a getContentType()  method");
      tcd.put(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASGETCONTENTTYPERETURNS,
            "RenderResponse method getContentType() returns String");
      tcd.put(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASGETLOCALE, "RenderResponse has a getLocale()  method");
      tcd.put(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASGETLOCALERETURNS,
            "RenderResponse method getLocale() returns java.util.Locale");
      tcd.put(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASGETPORTLETOUTPUTSTREAM,
            "RenderResponse has a getPortletOutputStream() throws java.io.IOException, IllegalStateException method");
      tcd.put(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASGETPORTLETOUTPUTSTREAMRETURNS,
            "RenderResponse method getPortletOutputStream() returns java.io.OutputStream");
      tcd.put(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASGETWRITER,
            "RenderResponse has a getWriter() throws java.io.IOException, IllegalStateException method");
      tcd.put(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASGETWRITERRETURNS,
            "RenderResponse method getWriter() returns java.io.PrintWriter");
      tcd.put(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASISCOMMITTED, "RenderResponse has a isCommitted()  method");
      tcd.put(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASISCOMMITTEDRETURNS,
            "RenderResponse method isCommitted() returns boolean");
      tcd.put(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASRESET, "RenderResponse has a reset()  method");
      tcd.put(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASRESETBUFFER, "RenderResponse has a resetBuffer()  method");
      tcd.put(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASRESETBUFFERRETURNS,
            "RenderResponse method resetBuffer() returns void");
      tcd.put(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASRESETRETURNS, "RenderResponse method reset() returns void");
      tcd.put(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASSETBUFFERSIZE,
            "RenderResponse has a setBufferSize(int)  method");
      tcd.put(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASSETBUFFERSIZERETURNS,
            "RenderResponse method setBufferSize(int) returns void");
      tcd.put(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASSETCONTENTTYPE,
            "RenderResponse has a setContentType(String)  method");
      tcd.put(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_HASSETCONTENTTYPERETURNS,
            "RenderResponse method setContentType(String) returns void");
      tcd.put(V2SIGTESTSRENDER_MIMERESPONSE_SIGRENDER_IMPLEMENTSPORTLETRESPONSE,
            "RenderResponse implements PortletResponse");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BDATE_FRACTIONSECOND,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_BDATE_FRACTIONSECOND");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BDATE_HMS_HOUR,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_BDATE_HMS_HOUR");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BDATE_HMS_MINUTE,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_BDATE_HMS_MINUTE");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BDATE_HMS_SECOND,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_BDATE_HMS_SECOND");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BDATE_TIMEZONE,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_BDATE_TIMEZONE");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BDATE_YMD_DAY,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_BDATE_YMD_DAY");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BDATE_YMD_MONTH,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_BDATE_YMD_MONTH");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BDATE_YMD_YEAR,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_BDATE_YMD_YEAR");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_ONLINE_EMAIL,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_BUSINESSINFO_ONLINE_EMAIL");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_ONLINE_URI,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_BUSINESSINFO_ONLINE_URI");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_POSTAL_CITY,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_BUSINESSINFO_POSTAL_CITY");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_POSTAL_COUNTRY,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_BUSINESSINFO_POSTAL_COUNTRY");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_POSTAL_NAME,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_BUSINESSINFO_POSTAL_NAME");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_POSTAL_ORGANIZATION,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_BUSINESSINFO_POSTAL_ORGANIZATION");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_POSTAL_POSTALCODE,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_BUSINESSINFO_POSTAL_POSTALCODE");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_POSTAL_STATEPROV,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_BUSINESSINFO_POSTAL_STATEPROV");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_POSTAL_STREET,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_BUSINESSINFO_POSTAL_STREET");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_FAX_COMMENT,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_BUSINESSINFO_TELECOM_FAX_COMMENT");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_FAX_EXT,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_BUSINESSINFO_TELECOM_FAX_EXT");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_FAX_INTCODE,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_BUSINESSINFO_TELECOM_FAX_INTCODE");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_FAX_LOCCODE,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_BUSINESSINFO_TELECOM_FAX_LOCCODE");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_FAX_NUMBER,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_BUSINESSINFO_TELECOM_FAX_NUMBER");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_MOBILE_COMMENT,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_BUSINESSINFO_TELECOM_MOBILE_COMMENT");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_MOBILE_EXT,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_BUSINESSINFO_TELECOM_MOBILE_EXT");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_MOBILE_INTCODE,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_BUSINESSINFO_TELECOM_MOBILE_INTCODE");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_MOBILE_LOCCODE,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_BUSINESSINFO_TELECOM_MOBILE_LOCCODE");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_MOBILE_NUMBER,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_BUSINESSINFO_TELECOM_MOBILE_NUMBER");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_PAGER_COMMENT,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_BUSINESSINFO_TELECOM_PAGER_COMMENT");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_PAGER_EXT,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_BUSINESSINFO_TELECOM_PAGER_EXT");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_PAGER_INTCODE,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_BUSINESSINFO_TELECOM_PAGER_INTCODE");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_PAGER_LOCCODE,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_BUSINESSINFO_TELECOM_PAGER_LOCCODE");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_PAGER_NUMBER,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_BUSINESSINFO_TELECOM_PAGER_NUMBER");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_TELEPHONE_COMMENT,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_BUSINESSINFO_TELECOM_TELEPHONE_COMMENT");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_TELEPHONE_EXT,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_BUSINESSINFO_TELECOM_TELEPHONE_EXT");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_TELEPHONE_INTCODE,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_BUSINESSINFO_TELECOM_TELEPHONE_INTCODE");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_TELEPHONE_LOCCODE,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_BUSINESSINFO_TELECOM_TELEPHONE_LOCCODE");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_BUSINESSINFO_TELECOM_TELEPHONE_NUMBER,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_BUSINESSINFO_TELECOM_TELEPHONE_NUMBER");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_DEPARTMENT,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_DEPARTMENT");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_EMPLOYER,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_EMPLOYER");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_GENDER,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_GENDER");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_ONLINE_EMAIL,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_HOMEINFO_ONLINE_EMAIL");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_ONLINE_URI,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_HOMEINFO_ONLINE_URI");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_POSTAL_CITY,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_HOMEINFO_POSTAL_CITY");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_POSTAL_COUNTRY,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_HOMEINFO_POSTAL_COUNTRY");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_POSTAL_NAME,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_HOMEINFO_POSTAL_NAME");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_POSTAL_ORGANIZATION,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_HOMEINFO_POSTAL_ORGANIZATION");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_POSTAL_POSTALCODE,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_HOMEINFO_POSTAL_POSTALCODE");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_POSTAL_STATEPROV,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_HOMEINFO_POSTAL_STATEPROV");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_POSTAL_STREET,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_HOMEINFO_POSTAL_STREET");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_FAX_COMMENT,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_HOMEINFO_TELECOM_FAX_COMMENT");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_FAX_EXT,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_HOMEINFO_TELECOM_FAX_EXT");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_FAX_INTCODE,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_HOMEINFO_TELECOM_FAX_INTCODE");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_FAX_LOCCODE,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_HOMEINFO_TELECOM_FAX_LOCCODE");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_FAX_NUMBER,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_HOMEINFO_TELECOM_FAX_NUMBER");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_MOBILE_COMMENT,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_HOMEINFO_TELECOM_MOBILE_COMMENT");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_MOBILE_EXT,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_HOMEINFO_TELECOM_MOBILE_EXT");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_MOBILE_INTCODE,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_HOMEINFO_TELECOM_MOBILE_INTCODE");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_MOBILE_LOCCODE,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_HOMEINFO_TELECOM_MOBILE_LOCCODE");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_MOBILE_NUMBER,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_HOMEINFO_TELECOM_MOBILE_NUMBER");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_PAGER_COMMENT,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_HOMEINFO_TELECOM_PAGER_COMMENT");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_PAGER_EXT,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_HOMEINFO_TELECOM_PAGER_EXT");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_PAGER_INTCODE,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_HOMEINFO_TELECOM_PAGER_INTCODE");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_PAGER_LOCCODE,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_HOMEINFO_TELECOM_PAGER_LOCCODE");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_PAGER_NUMBER,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_HOMEINFO_TELECOM_PAGER_NUMBER");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_TELEPHONE_COMMENT,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_HOMEINFO_TELECOM_TELEPHONE_COMMENT");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_TELEPHONE_EXT,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_HOMEINFO_TELECOM_TELEPHONE_EXT");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_TELEPHONE_INTCODE,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_HOMEINFO_TELECOM_TELEPHONE_INTCODE");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_TELEPHONE_LOCCODE,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_HOMEINFO_TELECOM_TELEPHONE_LOCCODE");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_HOMEINFO_TELECOM_TELEPHONE_NUMBER,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_HOMEINFO_TELECOM_TELEPHONE_NUMBER");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_JOBTITLE,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_JOBTITLE");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_LOGIN_ID,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_LOGIN_ID");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_NAME_FAMILY,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_NAME_FAMILY");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_NAME_GIVEN,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_NAME_GIVEN");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_NAME_MIDDLE,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_NAME_MIDDLE");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_NAME_NICKNAME,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_NAME_NICKNAME");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_NAME_PREFIX,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_NAME_PREFIX");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_FIELDUSER_NAME_SUFFIX,
            "PortletRequest$P3PUserInfos has PortletRequest$P3PUserInfos field USER_NAME_SUFFIX");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_HASTOSTRING,
            "PortletRequest$P3PUserInfos has a toString()  method");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_HASTOSTRINGRETURNS,
            "PortletRequest$P3PUserInfos method toString() returns String");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_HASVALUEOF,
            "PortletRequest$P3PUserInfos has a valueOf(String)  method");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_HASVALUEOFRETURNS,
            "PortletRequest$P3PUserInfos method valueOf(String) returns PortletRequest.P3PUserInfos");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_HASVALUES,
            "PortletRequest$P3PUserInfos has a values()  method");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_HASVALUESRETURNS,
            "PortletRequest$P3PUserInfos method values() returns PortletRequest.P3PUserInfos[] ");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST$P3PUSERINFOS_SIGRENDER_ISENUM, "PortletRequest$P3PUserInfos is an Enum");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_FIELDACTION_PHASE,
            "RenderRequest has String field ACTION_PHASE");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_FIELDACTION_SCOPE_ID,
            "RenderRequest has String field ACTION_SCOPE_ID");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_FIELDBASIC_AUTH, "RenderRequest has String field BASIC_AUTH");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_FIELDCCPP_PROFILE,
            "RenderRequest has String field CCPP_PROFILE");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_FIELDCLIENT_CERT_AUTH,
            "RenderRequest has String field CLIENT_CERT_AUTH");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_FIELDDIGEST_AUTH, "RenderRequest has String field DIGEST_AUTH");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_FIELDEVENT_PHASE, "RenderRequest has String field EVENT_PHASE");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_FIELDFORM_AUTH, "RenderRequest has String field FORM_AUTH");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_FIELDLIFECYCLE_PHASE,
            "RenderRequest has String field LIFECYCLE_PHASE");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_FIELDRENDER_HEADERS,
            "RenderRequest has String field RENDER_HEADERS");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_FIELDRENDER_MARKUP,
            "RenderRequest has String field RENDER_MARKUP");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_FIELDRENDER_PART, "RenderRequest has String field RENDER_PART");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_FIELDRENDER_PHASE,
            "RenderRequest has String field RENDER_PHASE");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_FIELDRESOURCE_PHASE,
            "RenderRequest has String field RESOURCE_PHASE");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_FIELDUSER_INFO, "RenderRequest has String field USER_INFO");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETATTRIBUTE,
            "RenderRequest has a getAttribute(String)  method");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETATTRIBUTENAMES,
            "RenderRequest has a getAttributeNames()  method");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETATTRIBUTENAMESRETURNS,
            "RenderRequest method getAttributeNames() returns java.util.Enumeration");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETATTRIBUTERETURNS,
            "RenderRequest method getAttribute(String) returns Object");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETAUTHTYPE, "RenderRequest has a getAuthType()  method");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETAUTHTYPERETURNS,
            "RenderRequest method getAuthType() returns String");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETCONTEXTPATH,
            "RenderRequest has a getContextPath()  method");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETCONTEXTPATHRETURNS,
            "RenderRequest method getContextPath() returns String");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETCOOKIES, "RenderRequest has a getCookies()  method");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETCOOKIESRETURNS,
            "RenderRequest method getCookies() returns javax.servlet.http.Cookie[] ");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETLOCALE, "RenderRequest has a getLocale()  method");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETLOCALERETURNS,
            "RenderRequest method getLocale() returns java.util.Locale");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETLOCALES, "RenderRequest has a getLocales()  method");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETLOCALESRETURNS,
            "RenderRequest method getLocales() returns java.util.Enumeration");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETPARAMETER,
            "RenderRequest has a getParameter(String)  method");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETPARAMETERMAP,
            "RenderRequest has a getParameterMap()  method");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETPARAMETERMAPRETURNS,
            "RenderRequest method getParameterMap() returns java.util.Map");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETPARAMETERNAMES,
            "RenderRequest has a getParameterNames()  method");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETPARAMETERNAMESRETURNS,
            "RenderRequest method getParameterNames() returns java.util.Enumeration");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETPARAMETERRETURNS,
            "RenderRequest method getParameter(String) returns String");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETPARAMETERVALUES,
            "RenderRequest has a getParameterValues(String)  method");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETPARAMETERVALUESRETURNS,
            "RenderRequest method getParameterValues(String) returns String[] ");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETPORTALCONTEXT,
            "RenderRequest has a getPortalContext()  method");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETPORTALCONTEXTRETURNS,
            "RenderRequest method getPortalContext() returns PortalContext");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETPORTLETMODE,
            "RenderRequest has a getPortletMode()  method");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETPORTLETMODERETURNS,
            "RenderRequest method getPortletMode() returns PortletMode");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETPORTLETSESSION,
            "RenderRequest has a getPortletSession()  method");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETPORTLETSESSIONA,
            "RenderRequest has a getPortletSession(boolean)  method");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETPORTLETSESSIONRETURNS,
            "RenderRequest method getPortletSession() returns PortletSession");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETPORTLETSESSIONRETURNSA,
            "RenderRequest method getPortletSession(boolean) returns PortletSession");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETPREFERENCES,
            "RenderRequest has a getPreferences()  method");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETPREFERENCESRETURNS,
            "RenderRequest method getPreferences() returns PortletPreferences");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETPRIVATEPARAMETERMAP,
            "RenderRequest has a getPrivateParameterMap()  method");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETPRIVATEPARAMETERMAPRETURNS,
            "RenderRequest method getPrivateParameterMap() returns java.util.Map");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETPROPERTIES,
            "RenderRequest has a getProperties(String)  method");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETPROPERTIESRETURNS,
            "RenderRequest method getProperties(String) returns java.util.Enumeration");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETPROPERTY,
            "RenderRequest has a getProperty(String)  method");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETPROPERTYNAMES,
            "RenderRequest has a getPropertyNames()  method");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETPROPERTYNAMESRETURNS,
            "RenderRequest method getPropertyNames() returns java.util.Enumeration");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETPROPERTYRETURNS,
            "RenderRequest method getProperty(String) returns String");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETPUBLICPARAMETERMAP,
            "RenderRequest has a getPublicParameterMap()  method");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETPUBLICPARAMETERMAPRETURNS,
            "RenderRequest method getPublicParameterMap() returns java.util.Map");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETREMOTEUSER,
            "RenderRequest has a getRemoteUser()  method");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETREMOTEUSERRETURNS,
            "RenderRequest method getRemoteUser() returns String");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETREQUESTEDSESSIONID,
            "RenderRequest has a getRequestedSessionId()  method");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETREQUESTEDSESSIONIDRETURNS,
            "RenderRequest method getRequestedSessionId() returns String");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETRESPONSECONTENTTYPE,
            "RenderRequest has a getResponseContentType()  method");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETRESPONSECONTENTTYPERETURNS,
            "RenderRequest method getResponseContentType() returns String");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETRESPONSECONTENTTYPES,
            "RenderRequest has a getResponseContentTypes()  method");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETRESPONSECONTENTTYPESRETURNS,
            "RenderRequest method getResponseContentTypes() returns java.util.Enumeration");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETSCHEME, "RenderRequest has a getScheme()  method");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETSCHEMERETURNS,
            "RenderRequest method getScheme() returns String");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETSERVERNAME,
            "RenderRequest has a getServerName()  method");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETSERVERNAMERETURNS,
            "RenderRequest method getServerName() returns String");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETSERVERPORT,
            "RenderRequest has a getServerPort()  method");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETSERVERPORTRETURNS,
            "RenderRequest method getServerPort() returns int");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETUSERPRINCIPAL,
            "RenderRequest has a getUserPrincipal()  method");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETUSERPRINCIPALRETURNS,
            "RenderRequest method getUserPrincipal() returns java.security.Principal");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETWINDOWID, "RenderRequest has a getWindowID()  method");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETWINDOWIDRETURNS,
            "RenderRequest method getWindowID() returns String");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETWINDOWSTATE,
            "RenderRequest has a getWindowState()  method");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASGETWINDOWSTATERETURNS,
            "RenderRequest method getWindowState() returns WindowState");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASISPORTLETMODEALLOWED,
            "RenderRequest has a isPortletModeAllowed(PortletMode)  method");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASISPORTLETMODEALLOWEDRETURNS,
            "RenderRequest method isPortletModeAllowed(PortletMode) returns boolean");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASISREQUESTEDSESSIONIDVALID,
            "RenderRequest has a isRequestedSessionIdValid()  method");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASISREQUESTEDSESSIONIDVALIDRETURNS,
            "RenderRequest method isRequestedSessionIdValid() returns boolean");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASISSECURE, "RenderRequest has a isSecure()  method");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASISSECURERETURNS,
            "RenderRequest method isSecure() returns boolean");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASISUSERINROLE,
            "RenderRequest has a isUserInRole(String)  method");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASISUSERINROLERETURNS,
            "RenderRequest method isUserInRole(String) returns boolean");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASISWINDOWSTATEALLOWED,
            "RenderRequest has a isWindowStateAllowed(WindowState)  method");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASISWINDOWSTATEALLOWEDRETURNS,
            "RenderRequest method isWindowStateAllowed(WindowState) returns boolean");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASREMOVEATTRIBUTE,
            "RenderRequest has a removeAttribute(String)  method");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASREMOVEATTRIBUTERETURNS,
            "RenderRequest method removeAttribute(String) returns void");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASSETATTRIBUTE,
            "RenderRequest has a setAttribute(String, Object)  method");
      tcd.put(V2SIGTESTSRENDER_PORTLETREQUEST_SIGRENDER_HASSETATTRIBUTERETURNS,
            "RenderRequest method setAttribute(String, Object) returns void");
      tcd.put(V2SIGTESTSRENDER_PORTLETRESPONSE_SIGRENDER_HASADDPROPERTY,
            "RenderResponse has a addProperty(String, String)  method");
      tcd.put(V2SIGTESTSRENDER_PORTLETRESPONSE_SIGRENDER_HASADDPROPERTYA,
            "RenderResponse has a addProperty(javax.servlet.http.Cookie)  method");
      tcd.put(V2SIGTESTSRENDER_PORTLETRESPONSE_SIGRENDER_HASADDPROPERTYB,
            "RenderResponse has a addProperty(String, org.w3c.dom.Element)  method");
      tcd.put(V2SIGTESTSRENDER_PORTLETRESPONSE_SIGRENDER_HASADDPROPERTYRETURNS,
            "RenderResponse method addProperty(String, String) returns void");
      tcd.put(V2SIGTESTSRENDER_PORTLETRESPONSE_SIGRENDER_HASADDPROPERTYRETURNSA,
            "RenderResponse method addProperty(javax.servlet.http.Cookie) returns void");
      tcd.put(V2SIGTESTSRENDER_PORTLETRESPONSE_SIGRENDER_HASADDPROPERTYRETURNSB,
            "RenderResponse method addProperty(String, org.w3c.dom.Element) returns void");
      tcd.put(V2SIGTESTSRENDER_PORTLETRESPONSE_SIGRENDER_HASCREATEELEMENT,
            "RenderResponse has a createElement(String) throws org.w3c.dom.DOMException method");
      tcd.put(V2SIGTESTSRENDER_PORTLETRESPONSE_SIGRENDER_HASCREATEELEMENTRETURNS,
            "RenderResponse method createElement(String) returns org.w3c.dom.Element");
      tcd.put(V2SIGTESTSRENDER_PORTLETRESPONSE_SIGRENDER_HASENCODEURL,
            "RenderResponse has a encodeURL(String)  method");
      tcd.put(V2SIGTESTSRENDER_PORTLETRESPONSE_SIGRENDER_HASENCODEURLRETURNS,
            "RenderResponse method encodeURL(String) returns String");
      tcd.put(V2SIGTESTSRENDER_PORTLETRESPONSE_SIGRENDER_HASGETNAMESPACE,
            "RenderResponse has a getNamespace()  method");
      tcd.put(V2SIGTESTSRENDER_PORTLETRESPONSE_SIGRENDER_HASGETNAMESPACERETURNS,
            "RenderResponse method getNamespace() returns String");
      tcd.put(V2SIGTESTSRENDER_PORTLETRESPONSE_SIGRENDER_HASSETPROPERTY,
            "RenderResponse has a setProperty(String, String)  method");
      tcd.put(V2SIGTESTSRENDER_PORTLETRESPONSE_SIGRENDER_HASSETPROPERTYRETURNS,
            "RenderResponse method setProperty(String, String) returns void");
      tcd.put(V2SIGTESTSRENDER_RENDERREQUEST_SIGRENDER_FIELDETAG, "RenderRequest has String field ETAG");
      tcd.put(V2SIGTESTSRENDER_RENDERREQUEST_SIGRENDER_HASGETETAG, "RenderRequest has a getETag()  method");
      tcd.put(V2SIGTESTSRENDER_RENDERREQUEST_SIGRENDER_HASGETETAGRETURNS,
            "RenderRequest method getETag() returns String");
      tcd.put(V2SIGTESTSRENDER_RENDERREQUEST_SIGRENDER_IMPLEMENTSPORTLETREQUEST,
            "RenderRequest implements PortletRequest");
      tcd.put(V2SIGTESTSRENDER_RENDERRESPONSE_SIGRENDER_HASSETCONTENTTYPE,
            "RenderResponse has a setContentType(String)  method");
      tcd.put(V2SIGTESTSRENDER_RENDERRESPONSE_SIGRENDER_HASSETCONTENTTYPERETURNS,
            "RenderResponse method setContentType(String) returns void");
      tcd.put(V2SIGTESTSRENDER_RENDERRESPONSE_SIGRENDER_HASSETNEXTPOSSIBLEPORTLETMODES,
            "RenderResponse has a setNextPossiblePortletModes(java.util.Collection)  method");
      tcd.put(V2SIGTESTSRENDER_RENDERRESPONSE_SIGRENDER_HASSETNEXTPOSSIBLEPORTLETMODESRETURNS,
            "RenderResponse method setNextPossiblePortletModes(java.util.Collection) returns void");
      tcd.put(V2SIGTESTSRENDER_RENDERRESPONSE_SIGRENDER_HASSETTITLE, "RenderResponse has a setTitle(String)  method");
      tcd.put(V2SIGTESTSRENDER_RENDERRESPONSE_SIGRENDER_HASSETTITLERETURNS,
            "RenderResponse method setTitle(String) returns void");
      tcd.put(V2SIGTESTSRENDER_RENDERRESPONSE_SIGRENDER_IMPLEMENTSMIMERESPONSE,
            "RenderResponse implements MimeResponse");
      tcd.put(V2SIGTESTSRESOURCE_CLIENTDATAREQUEST_SIGRESOURCE_HASGETCHARACTERENCODING,
            "ResourceRequest has a getCharacterEncoding()  method");
      tcd.put(V2SIGTESTSRESOURCE_CLIENTDATAREQUEST_SIGRESOURCE_HASGETCHARACTERENCODINGRETURNS,
            "ResourceRequest method getCharacterEncoding() returns String");
      tcd.put(V2SIGTESTSRESOURCE_CLIENTDATAREQUEST_SIGRESOURCE_HASGETCONTENTLENGTH,
            "ResourceRequest has a getContentLength()  method");
      tcd.put(V2SIGTESTSRESOURCE_CLIENTDATAREQUEST_SIGRESOURCE_HASGETCONTENTLENGTHRETURNS,
            "ResourceRequest method getContentLength() returns int");
      tcd.put(V2SIGTESTSRESOURCE_CLIENTDATAREQUEST_SIGRESOURCE_HASGETCONTENTTYPE,
            "ResourceRequest has a getContentType()  method");
      tcd.put(V2SIGTESTSRESOURCE_CLIENTDATAREQUEST_SIGRESOURCE_HASGETCONTENTTYPERETURNS,
            "ResourceRequest method getContentType() returns String");
      tcd.put(V2SIGTESTSRESOURCE_CLIENTDATAREQUEST_SIGRESOURCE_HASGETMETHOD,
            "ResourceRequest has a getMethod()  method");
      tcd.put(V2SIGTESTSRESOURCE_CLIENTDATAREQUEST_SIGRESOURCE_HASGETMETHODRETURNS,
            "ResourceRequest method getMethod() returns String");
      tcd.put(V2SIGTESTSRESOURCE_CLIENTDATAREQUEST_SIGRESOURCE_HASGETPORTLETINPUTSTREAM,
            "ResourceRequest has a getPortletInputStream() throws java.io.IOException method");
      tcd.put(V2SIGTESTSRESOURCE_CLIENTDATAREQUEST_SIGRESOURCE_HASGETPORTLETINPUTSTREAMRETURNS,
            "ResourceRequest method getPortletInputStream() returns java.io.InputStream");
      tcd.put(V2SIGTESTSRESOURCE_CLIENTDATAREQUEST_SIGRESOURCE_HASGETREADER,
            "ResourceRequest has a getReader() throws java.io.UnsupportedEncodingException, java.io.IOException method");
      tcd.put(V2SIGTESTSRESOURCE_CLIENTDATAREQUEST_SIGRESOURCE_HASGETREADERRETURNS,
            "ResourceRequest method getReader() returns java.io.BufferedReader");
      tcd.put(V2SIGTESTSRESOURCE_CLIENTDATAREQUEST_SIGRESOURCE_HASSETCHARACTERENCODING,
            "ResourceRequest has a setCharacterEncoding(String) throws java.io.UnsupportedEncodingException method");
      tcd.put(V2SIGTESTSRESOURCE_CLIENTDATAREQUEST_SIGRESOURCE_HASSETCHARACTERENCODINGRETURNS,
            "ResourceRequest method setCharacterEncoding(String) returns void");
      tcd.put(V2SIGTESTSRESOURCE_CLIENTDATAREQUEST_SIGRESOURCE_IMPLEMENTSPORTLETREQUEST,
            "ResourceRequest implements PortletRequest");
      tcd.put(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_FIELDCACHE_SCOPE,
            "ResourceResponse has String field CACHE_SCOPE");
      tcd.put(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_FIELDETAG, "ResourceResponse has String field ETAG");
      tcd.put(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_FIELDEXPIRATION_CACHE,
            "ResourceResponse has String field EXPIRATION_CACHE");
      tcd.put(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_FIELDMARKUP_HEAD_ELEMENT,
            "ResourceResponse has String field MARKUP_HEAD_ELEMENT");
      tcd.put(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_FIELDNAMESPACED_RESPONSE,
            "ResourceResponse has String field NAMESPACED_RESPONSE");
      tcd.put(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_FIELDPRIVATE_SCOPE,
            "ResourceResponse has String field PRIVATE_SCOPE");
      tcd.put(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_FIELDPUBLIC_SCOPE,
            "ResourceResponse has String field PUBLIC_SCOPE");
      tcd.put(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_FIELDUSE_CACHED_CONTENT,
            "ResourceResponse has String field USE_CACHED_CONTENT");
      tcd.put(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASCREATEACTIONURL,
            "ResourceResponse has a createActionURL()  method");
      tcd.put(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASCREATEACTIONURLRETURNS,
            "ResourceResponse method createActionURL() returns PortletURL");
      tcd.put(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASCREATERENDERURL,
            "ResourceResponse has a createRenderURL()  method");
      tcd.put(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASCREATERENDERURLRETURNS,
            "ResourceResponse method createRenderURL() returns PortletURL");
      tcd.put(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASCREATERESOURCEURL,
            "ResourceResponse has a createResourceURL()  method");
      tcd.put(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASCREATERESOURCEURLRETURNS,
            "ResourceResponse method createResourceURL() returns ResourceURL");
      tcd.put(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASFLUSHBUFFER,
            "ResourceResponse has a flushBuffer() throws java.io.IOException method");
      tcd.put(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASFLUSHBUFFERRETURNS,
            "ResourceResponse method flushBuffer() returns void");
      tcd.put(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASGETBUFFERSIZE,
            "ResourceResponse has a getBufferSize()  method");
      tcd.put(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASGETBUFFERSIZERETURNS,
            "ResourceResponse method getBufferSize() returns int");
      tcd.put(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASGETCACHECONTROL,
            "ResourceResponse has a getCacheControl()  method");
      tcd.put(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASGETCACHECONTROLRETURNS,
            "ResourceResponse method getCacheControl() returns CacheControl");
      tcd.put(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASGETCHARACTERENCODING,
            "ResourceResponse has a getCharacterEncoding()  method");
      tcd.put(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASGETCHARACTERENCODINGRETURNS,
            "ResourceResponse method getCharacterEncoding() returns String");
      tcd.put(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASGETCONTENTTYPE,
            "ResourceResponse has a getContentType()  method");
      tcd.put(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASGETCONTENTTYPERETURNS,
            "ResourceResponse method getContentType() returns String");
      tcd.put(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASGETLOCALE, "ResourceResponse has a getLocale()  method");
      tcd.put(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASGETLOCALERETURNS,
            "ResourceResponse method getLocale() returns java.util.Locale");
      tcd.put(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASGETPORTLETOUTPUTSTREAM,
            "ResourceResponse has a getPortletOutputStream() throws java.io.IOException, IllegalStateException method");
      tcd.put(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASGETPORTLETOUTPUTSTREAMRETURNS,
            "ResourceResponse method getPortletOutputStream() returns java.io.OutputStream");
      tcd.put(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASGETWRITER,
            "ResourceResponse has a getWriter() throws java.io.IOException, IllegalStateException method");
      tcd.put(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASGETWRITERRETURNS,
            "ResourceResponse method getWriter() returns java.io.PrintWriter");
      tcd.put(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASISCOMMITTED,
            "ResourceResponse has a isCommitted()  method");
      tcd.put(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASISCOMMITTEDRETURNS,
            "ResourceResponse method isCommitted() returns boolean");
      tcd.put(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASRESET, "ResourceResponse has a reset()  method");
      tcd.put(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASRESETBUFFER,
            "ResourceResponse has a resetBuffer()  method");
      tcd.put(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASRESETBUFFERRETURNS,
            "ResourceResponse method resetBuffer() returns void");
      tcd.put(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASRESETRETURNS,
            "ResourceResponse method reset() returns void");
      tcd.put(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASSETBUFFERSIZE,
            "ResourceResponse has a setBufferSize(int)  method");
      tcd.put(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASSETBUFFERSIZERETURNS,
            "ResourceResponse method setBufferSize(int) returns void");
      tcd.put(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASSETCONTENTTYPE,
            "ResourceResponse has a setContentType(String)  method");
      tcd.put(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_HASSETCONTENTTYPERETURNS,
            "ResourceResponse method setContentType(String) returns void");
      tcd.put(V2SIGTESTSRESOURCE_MIMERESPONSE_SIGRESOURCE_IMPLEMENTSPORTLETRESPONSE,
            "ResourceResponse implements PortletResponse");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_FIELDACTION_PHASE,
            "ResourceRequest has String field ACTION_PHASE");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_FIELDACTION_SCOPE_ID,
            "ResourceRequest has String field ACTION_SCOPE_ID");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_FIELDBASIC_AUTH,
            "ResourceRequest has String field BASIC_AUTH");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_FIELDCCPP_PROFILE,
            "ResourceRequest has String field CCPP_PROFILE");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_FIELDCLIENT_CERT_AUTH,
            "ResourceRequest has String field CLIENT_CERT_AUTH");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_FIELDDIGEST_AUTH,
            "ResourceRequest has String field DIGEST_AUTH");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_FIELDEVENT_PHASE,
            "ResourceRequest has String field EVENT_PHASE");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_FIELDFORM_AUTH,
            "ResourceRequest has String field FORM_AUTH");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_FIELDLIFECYCLE_PHASE,
            "ResourceRequest has String field LIFECYCLE_PHASE");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_FIELDRENDER_HEADERS,
            "ResourceRequest has String field RENDER_HEADERS");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_FIELDRENDER_MARKUP,
            "ResourceRequest has String field RENDER_MARKUP");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_FIELDRENDER_PART,
            "ResourceRequest has String field RENDER_PART");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_FIELDRENDER_PHASE,
            "ResourceRequest has String field RENDER_PHASE");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_FIELDRESOURCE_PHASE,
            "ResourceRequest has String field RESOURCE_PHASE");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_FIELDUSER_INFO,
            "ResourceRequest has String field USER_INFO");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETATTRIBUTE,
            "ResourceRequest has a getAttribute(String)  method");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETATTRIBUTENAMES,
            "ResourceRequest has a getAttributeNames()  method");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETATTRIBUTENAMESRETURNS,
            "ResourceRequest method getAttributeNames() returns java.util.Enumeration");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETATTRIBUTERETURNS,
            "ResourceRequest method getAttribute(String) returns Object");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETAUTHTYPE,
            "ResourceRequest has a getAuthType()  method");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETAUTHTYPERETURNS,
            "ResourceRequest method getAuthType() returns String");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETCONTEXTPATH,
            "ResourceRequest has a getContextPath()  method");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETCONTEXTPATHRETURNS,
            "ResourceRequest method getContextPath() returns String");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETCOOKIES,
            "ResourceRequest has a getCookies()  method");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETCOOKIESRETURNS,
            "ResourceRequest method getCookies() returns javax.servlet.http.Cookie[] ");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETLOCALE, "ResourceRequest has a getLocale()  method");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETLOCALERETURNS,
            "ResourceRequest method getLocale() returns java.util.Locale");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETLOCALES,
            "ResourceRequest has a getLocales()  method");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETLOCALESRETURNS,
            "ResourceRequest method getLocales() returns java.util.Enumeration");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPARAMETER,
            "ResourceRequest has a getParameter(String)  method");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPARAMETERMAP,
            "ResourceRequest has a getParameterMap()  method");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPARAMETERMAPRETURNS,
            "ResourceRequest method getParameterMap() returns java.util.Map");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPARAMETERNAMES,
            "ResourceRequest has a getParameterNames()  method");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPARAMETERNAMESRETURNS,
            "ResourceRequest method getParameterNames() returns java.util.Enumeration");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPARAMETERRETURNS,
            "ResourceRequest method getParameter(String) returns String");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPARAMETERVALUES,
            "ResourceRequest has a getParameterValues(String)  method");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPARAMETERVALUESRETURNS,
            "ResourceRequest method getParameterValues(String) returns String[] ");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPORTALCONTEXT,
            "ResourceRequest has a getPortalContext()  method");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPORTALCONTEXTRETURNS,
            "ResourceRequest method getPortalContext() returns PortalContext");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPORTLETMODE,
            "ResourceRequest has a getPortletMode()  method");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPORTLETMODERETURNS,
            "ResourceRequest method getPortletMode() returns PortletMode");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPORTLETSESSION,
            "ResourceRequest has a getPortletSession()  method");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPORTLETSESSIONA,
            "ResourceRequest has a getPortletSession(boolean)  method");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPORTLETSESSIONRETURNS,
            "ResourceRequest method getPortletSession() returns PortletSession");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPORTLETSESSIONRETURNSA,
            "ResourceRequest method getPortletSession(boolean) returns PortletSession");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPREFERENCES,
            "ResourceRequest has a getPreferences()  method");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPREFERENCESRETURNS,
            "ResourceRequest method getPreferences() returns PortletPreferences");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPRIVATEPARAMETERMAP,
            "ResourceRequest has a getPrivateParameterMap()  method");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPRIVATEPARAMETERMAPRETURNS,
            "ResourceRequest method getPrivateParameterMap() returns java.util.Map");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPROPERTIES,
            "ResourceRequest has a getProperties(String)  method");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPROPERTIESRETURNS,
            "ResourceRequest method getProperties(String) returns java.util.Enumeration");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPROPERTY,
            "ResourceRequest has a getProperty(String)  method");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPROPERTYNAMES,
            "ResourceRequest has a getPropertyNames()  method");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPROPERTYNAMESRETURNS,
            "ResourceRequest method getPropertyNames() returns java.util.Enumeration");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPROPERTYRETURNS,
            "ResourceRequest method getProperty(String) returns String");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPUBLICPARAMETERMAP,
            "ResourceRequest has a getPublicParameterMap()  method");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETPUBLICPARAMETERMAPRETURNS,
            "ResourceRequest method getPublicParameterMap() returns java.util.Map");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETREMOTEUSER,
            "ResourceRequest has a getRemoteUser()  method");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETREMOTEUSERRETURNS,
            "ResourceRequest method getRemoteUser() returns String");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETREQUESTEDSESSIONID,
            "ResourceRequest has a getRequestedSessionId()  method");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETREQUESTEDSESSIONIDRETURNS,
            "ResourceRequest method getRequestedSessionId() returns String");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETRESPONSECONTENTTYPE,
            "ResourceRequest has a getResponseContentType()  method");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETRESPONSECONTENTTYPERETURNS,
            "ResourceRequest method getResponseContentType() returns String");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETRESPONSECONTENTTYPES,
            "ResourceRequest has a getResponseContentTypes()  method");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETRESPONSECONTENTTYPESRETURNS,
            "ResourceRequest method getResponseContentTypes() returns java.util.Enumeration");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETSCHEME, "ResourceRequest has a getScheme()  method");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETSCHEMERETURNS,
            "ResourceRequest method getScheme() returns String");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETSERVERNAME,
            "ResourceRequest has a getServerName()  method");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETSERVERNAMERETURNS,
            "ResourceRequest method getServerName() returns String");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETSERVERPORT,
            "ResourceRequest has a getServerPort()  method");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETSERVERPORTRETURNS,
            "ResourceRequest method getServerPort() returns int");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETUSERPRINCIPAL,
            "ResourceRequest has a getUserPrincipal()  method");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETUSERPRINCIPALRETURNS,
            "ResourceRequest method getUserPrincipal() returns java.security.Principal");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETWINDOWID,
            "ResourceRequest has a getWindowID()  method");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETWINDOWIDRETURNS,
            "ResourceRequest method getWindowID() returns String");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETWINDOWSTATE,
            "ResourceRequest has a getWindowState()  method");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASGETWINDOWSTATERETURNS,
            "ResourceRequest method getWindowState() returns WindowState");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASISPORTLETMODEALLOWED,
            "ResourceRequest has a isPortletModeAllowed(PortletMode)  method");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASISPORTLETMODEALLOWEDRETURNS,
            "ResourceRequest method isPortletModeAllowed(PortletMode) returns boolean");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASISREQUESTEDSESSIONIDVALID,
            "ResourceRequest has a isRequestedSessionIdValid()  method");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASISREQUESTEDSESSIONIDVALIDRETURNS,
            "ResourceRequest method isRequestedSessionIdValid() returns boolean");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASISSECURE, "ResourceRequest has a isSecure()  method");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASISSECURERETURNS,
            "ResourceRequest method isSecure() returns boolean");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASISUSERINROLE,
            "ResourceRequest has a isUserInRole(String)  method");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASISUSERINROLERETURNS,
            "ResourceRequest method isUserInRole(String) returns boolean");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASISWINDOWSTATEALLOWED,
            "ResourceRequest has a isWindowStateAllowed(WindowState)  method");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASISWINDOWSTATEALLOWEDRETURNS,
            "ResourceRequest method isWindowStateAllowed(WindowState) returns boolean");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASREMOVEATTRIBUTE,
            "ResourceRequest has a removeAttribute(String)  method");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASREMOVEATTRIBUTERETURNS,
            "ResourceRequest method removeAttribute(String) returns void");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASSETATTRIBUTE,
            "ResourceRequest has a setAttribute(String, Object)  method");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETREQUEST_SIGRESOURCE_HASSETATTRIBUTERETURNS,
            "ResourceRequest method setAttribute(String, Object) returns void");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETRESPONSE_SIGRESOURCE_HASADDPROPERTY,
            "ResourceResponse has a addProperty(String, String)  method");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETRESPONSE_SIGRESOURCE_HASADDPROPERTYA,
            "ResourceResponse has a addProperty(javax.servlet.http.Cookie)  method");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETRESPONSE_SIGRESOURCE_HASADDPROPERTYB,
            "ResourceResponse has a addProperty(String, org.w3c.dom.Element)  method");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETRESPONSE_SIGRESOURCE_HASADDPROPERTYRETURNS,
            "ResourceResponse method addProperty(String, String) returns void");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETRESPONSE_SIGRESOURCE_HASADDPROPERTYRETURNSA,
            "ResourceResponse method addProperty(javax.servlet.http.Cookie) returns void");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETRESPONSE_SIGRESOURCE_HASADDPROPERTYRETURNSB,
            "ResourceResponse method addProperty(String, org.w3c.dom.Element) returns void");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETRESPONSE_SIGRESOURCE_HASCREATEELEMENT,
            "ResourceResponse has a createElement(String) throws org.w3c.dom.DOMException method");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETRESPONSE_SIGRESOURCE_HASCREATEELEMENTRETURNS,
            "ResourceResponse method createElement(String) returns org.w3c.dom.Element");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETRESPONSE_SIGRESOURCE_HASENCODEURL,
            "ResourceResponse has a encodeURL(String)  method");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETRESPONSE_SIGRESOURCE_HASENCODEURLRETURNS,
            "ResourceResponse method encodeURL(String) returns String");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETRESPONSE_SIGRESOURCE_HASGETNAMESPACE,
            "ResourceResponse has a getNamespace()  method");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETRESPONSE_SIGRESOURCE_HASGETNAMESPACERETURNS,
            "ResourceResponse method getNamespace() returns String");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETRESPONSE_SIGRESOURCE_HASSETPROPERTY,
            "ResourceResponse has a setProperty(String, String)  method");
      tcd.put(V2SIGTESTSRESOURCE_PORTLETRESPONSE_SIGRESOURCE_HASSETPROPERTYRETURNS,
            "ResourceResponse method setProperty(String, String) returns void");
      tcd.put(V2SIGTESTSRESOURCE_RESOURCEREQUEST_SIGRESOURCE_FIELDETAG, "ResourceRequest has String field ETAG");
      tcd.put(V2SIGTESTSRESOURCE_RESOURCEREQUEST_SIGRESOURCE_HASGETCACHEABILITY,
            "ResourceRequest has a getCacheability()  method");
      tcd.put(V2SIGTESTSRESOURCE_RESOURCEREQUEST_SIGRESOURCE_HASGETCACHEABILITYRETURNS,
            "ResourceRequest method getCacheability() returns String");
      tcd.put(V2SIGTESTSRESOURCE_RESOURCEREQUEST_SIGRESOURCE_HASGETETAG, "ResourceRequest has a getETag()  method");
      tcd.put(V2SIGTESTSRESOURCE_RESOURCEREQUEST_SIGRESOURCE_HASGETETAGRETURNS,
            "ResourceRequest method getETag() returns String");
      tcd.put(V2SIGTESTSRESOURCE_RESOURCEREQUEST_SIGRESOURCE_HASGETPRIVATERENDERPARAMETERMAP,
            "ResourceRequest has a getPrivateRenderParameterMap()  method");
      tcd.put(V2SIGTESTSRESOURCE_RESOURCEREQUEST_SIGRESOURCE_HASGETPRIVATERENDERPARAMETERMAPRETURNS,
            "ResourceRequest method getPrivateRenderParameterMap() returns java.util.Map");
      tcd.put(V2SIGTESTSRESOURCE_RESOURCEREQUEST_SIGRESOURCE_HASGETRESOURCEID,
            "ResourceRequest has a getResourceID()  method");
      tcd.put(V2SIGTESTSRESOURCE_RESOURCEREQUEST_SIGRESOURCE_HASGETRESOURCEIDRETURNS,
            "ResourceRequest method getResourceID() returns String");
      tcd.put(V2SIGTESTSRESOURCE_RESOURCEREQUEST_SIGRESOURCE_HASGETRESPONSECONTENTTYPE,
            "ResourceRequest has a getResponseContentType()  method");
      tcd.put(V2SIGTESTSRESOURCE_RESOURCEREQUEST_SIGRESOURCE_HASGETRESPONSECONTENTTYPERETURNS,
            "ResourceRequest method getResponseContentType() returns String");
      tcd.put(V2SIGTESTSRESOURCE_RESOURCEREQUEST_SIGRESOURCE_HASGETRESPONSECONTENTTYPES,
            "ResourceRequest has a getResponseContentTypes()  method");
      tcd.put(V2SIGTESTSRESOURCE_RESOURCEREQUEST_SIGRESOURCE_HASGETRESPONSECONTENTTYPESRETURNS,
            "ResourceRequest method getResponseContentTypes() returns java.util.Enumeration");
      tcd.put(V2SIGTESTSRESOURCE_RESOURCEREQUEST_SIGRESOURCE_IMPLEMENTSCLIENTDATAREQUEST,
            "ResourceRequest implements ClientDataRequest");
      tcd.put(V2SIGTESTSRESOURCE_RESOURCERESPONSE_SIGRESOURCE_FIELDHTTP_STATUS_CODE,
            "ResourceResponse has String field HTTP_STATUS_CODE");
      tcd.put(V2SIGTESTSRESOURCE_RESOURCERESPONSE_SIGRESOURCE_HASCREATEACTIONURL,
            "ResourceResponse has a createActionURL() throws IllegalStateException method");
      tcd.put(V2SIGTESTSRESOURCE_RESOURCERESPONSE_SIGRESOURCE_HASCREATEACTIONURLRETURNS,
            "ResourceResponse method createActionURL() returns PortletURL");
      tcd.put(V2SIGTESTSRESOURCE_RESOURCERESPONSE_SIGRESOURCE_HASCREATERENDERURL,
            "ResourceResponse has a createRenderURL() throws IllegalStateException method");
      tcd.put(V2SIGTESTSRESOURCE_RESOURCERESPONSE_SIGRESOURCE_HASCREATERENDERURLRETURNS,
            "ResourceResponse method createRenderURL() returns PortletURL");
      tcd.put(V2SIGTESTSRESOURCE_RESOURCERESPONSE_SIGRESOURCE_HASCREATERESOURCEURL,
            "ResourceResponse has a createResourceURL() throws IllegalStateException method");
      tcd.put(V2SIGTESTSRESOURCE_RESOURCERESPONSE_SIGRESOURCE_HASCREATERESOURCEURLRETURNS,
            "ResourceResponse method createResourceURL() returns ResourceURL");
      tcd.put(V2SIGTESTSRESOURCE_RESOURCERESPONSE_SIGRESOURCE_HASSETCHARACTERENCODING,
            "ResourceResponse has a setCharacterEncoding(String)  method");
      tcd.put(V2SIGTESTSRESOURCE_RESOURCERESPONSE_SIGRESOURCE_HASSETCHARACTERENCODINGRETURNS,
            "ResourceResponse method setCharacterEncoding(String) returns void");
      tcd.put(V2SIGTESTSRESOURCE_RESOURCERESPONSE_SIGRESOURCE_HASSETCONTENTLENGTH,
            "ResourceResponse has a setContentLength(int)  method");
      tcd.put(V2SIGTESTSRESOURCE_RESOURCERESPONSE_SIGRESOURCE_HASSETCONTENTLENGTHRETURNS,
            "ResourceResponse method setContentLength(int) returns void");
      tcd.put(V2SIGTESTSRESOURCE_RESOURCERESPONSE_SIGRESOURCE_HASSETLOCALE,
            "ResourceResponse has a setLocale(java.util.Locale)  method");
      tcd.put(V2SIGTESTSRESOURCE_RESOURCERESPONSE_SIGRESOURCE_HASSETLOCALERETURNS,
            "ResourceResponse method setLocale(java.util.Locale) returns void");
      tcd.put(V2SIGTESTSRESOURCE_RESOURCERESPONSE_SIGRESOURCE_IMPLEMENTSMIMERESPONSE,
            "ResourceResponse implements MimeResponse");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRENDERACTURL_HASADDPROPERTY,
            "Rection URL has a addProperty(String, String)  method");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRENDERACTURL_HASADDPROPERTYRETURNS,
            "Rection URL method addProperty(String, String) returns void");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRENDERACTURL_HASGETPARAMETERMAP, "Rection URL has a getParameterMap()  method");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRENDERACTURL_HASGETPARAMETERMAPRETURNS,
            "Rection URL method getParameterMap() returns java.util.Map");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRENDERACTURL_HASSETPARAMETER,
            "Rection URL has a setParameter(String, String)  method");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRENDERACTURL_HASSETPARAMETERA,
            "Rection URL has a setParameter(String, String[])  method");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRENDERACTURL_HASSETPARAMETERRETURNS,
            "Rection URL method setParameter(String, String) returns void");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRENDERACTURL_HASSETPARAMETERRETURNSA,
            "Rection URL method setParameter(String, String[]) returns void");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRENDERACTURL_HASSETPARAMETERS,
            "Rection URL has a setParameters(java.util.Map)  method");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRENDERACTURL_HASSETPARAMETERSRETURNS,
            "Rection URL method setParameters(java.util.Map) returns void");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRENDERACTURL_HASSETPROPERTY,
            "Rection URL has a setProperty(String, String)  method");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRENDERACTURL_HASSETPROPERTYRETURNS,
            "Rection URL method setProperty(String, String) returns void");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRENDERACTURL_HASSETSECURE,
            "Rection URL has a setSecure(boolean) throws PortletSecurityException method");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRENDERACTURL_HASSETSECURERETURNS,
            "Rection URL method setSecure(boolean) returns void");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRENDERACTURL_HASTOSTRING, "Rection URL has a toString()  method");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRENDERACTURL_HASTOSTRINGRETURNS, "Rection URL method toString() returns String");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRENDERACTURL_HASWRITE,
            "Rection URL has a write(java.io.Writer) throws java.io.IOException method");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRENDERACTURL_HASWRITEA,
            "Rection URL has a write(java.io.Writer, boolean) throws java.io.IOException method");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRENDERACTURL_HASWRITERETURNS,
            "Rection URL method write(java.io.Writer) returns void");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRENDERACTURL_HASWRITERETURNSA,
            "Rection URL method write(java.io.Writer, boolean) returns void");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRENDERRENURL_HASADDPROPERTY,
            "Render URL has a addProperty(String, String)  method");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRENDERRENURL_HASADDPROPERTYRETURNS,
            "Render URL method addProperty(String, String) returns void");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRENDERRENURL_HASGETPARAMETERMAP, "Render URL has a getParameterMap()  method");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRENDERRENURL_HASGETPARAMETERMAPRETURNS,
            "Render URL method getParameterMap() returns java.util.Map");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRENDERRENURL_HASSETPARAMETER,
            "Render URL has a setParameter(String, String)  method");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRENDERRENURL_HASSETPARAMETERA,
            "Render URL has a setParameter(String, String[])  method");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRENDERRENURL_HASSETPARAMETERRETURNS,
            "Render URL method setParameter(String, String) returns void");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRENDERRENURL_HASSETPARAMETERRETURNSA,
            "Render URL method setParameter(String, String[]) returns void");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRENDERRENURL_HASSETPARAMETERS,
            "Render URL has a setParameters(java.util.Map)  method");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRENDERRENURL_HASSETPARAMETERSRETURNS,
            "Render URL method setParameters(java.util.Map) returns void");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRENDERRENURL_HASSETPROPERTY,
            "Render URL has a setProperty(String, String)  method");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRENDERRENURL_HASSETPROPERTYRETURNS,
            "Render URL method setProperty(String, String) returns void");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRENDERRENURL_HASSETSECURE,
            "Render URL has a setSecure(boolean) throws PortletSecurityException method");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRENDERRENURL_HASSETSECURERETURNS,
            "Render URL method setSecure(boolean) returns void");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRENDERRENURL_HASTOSTRING, "Render URL has a toString()  method");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRENDERRENURL_HASTOSTRINGRETURNS, "Render URL method toString() returns String");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRENDERRENURL_HASWRITE,
            "Render URL has a write(java.io.Writer) throws java.io.IOException method");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRENDERRENURL_HASWRITEA,
            "Render URL has a write(java.io.Writer, boolean) throws java.io.IOException method");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRENDERRENURL_HASWRITERETURNS,
            "Render URL method write(java.io.Writer) returns void");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRENDERRENURL_HASWRITERETURNSA,
            "Render URL method write(java.io.Writer, boolean) returns void");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRENDERRESURL_HASADDPROPERTY,
            "Resource URL has a addProperty(String, String)  method");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRENDERRESURL_HASADDPROPERTYRETURNS,
            "Resource URL method addProperty(String, String) returns void");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRENDERRESURL_HASGETPARAMETERMAP, "Resource URL has a getParameterMap()  method");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRENDERRESURL_HASGETPARAMETERMAPRETURNS,
            "Resource URL method getParameterMap() returns java.util.Map");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRENDERRESURL_HASSETPARAMETER,
            "Resource URL has a setParameter(String, String)  method");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRENDERRESURL_HASSETPARAMETERA,
            "Resource URL has a setParameter(String, String[])  method");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRENDERRESURL_HASSETPARAMETERRETURNS,
            "Resource URL method setParameter(String, String) returns void");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRENDERRESURL_HASSETPARAMETERRETURNSA,
            "Resource URL method setParameter(String, String[]) returns void");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRENDERRESURL_HASSETPARAMETERS,
            "Resource URL has a setParameters(java.util.Map)  method");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRENDERRESURL_HASSETPARAMETERSRETURNS,
            "Resource URL method setParameters(java.util.Map) returns void");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRENDERRESURL_HASSETPROPERTY,
            "Resource URL has a setProperty(String, String)  method");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRENDERRESURL_HASSETPROPERTYRETURNS,
            "Resource URL method setProperty(String, String) returns void");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRENDERRESURL_HASSETSECURE,
            "Resource URL has a setSecure(boolean) throws PortletSecurityException method");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRENDERRESURL_HASSETSECURERETURNS,
            "Resource URL method setSecure(boolean) returns void");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRENDERRESURL_HASTOSTRING, "Resource URL has a toString()  method");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRENDERRESURL_HASTOSTRINGRETURNS,
            "Resource URL method toString() returns String");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRENDERRESURL_HASWRITE,
            "Resource URL has a write(java.io.Writer) throws java.io.IOException method");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRENDERRESURL_HASWRITEA,
            "Resource URL has a write(java.io.Writer, boolean) throws java.io.IOException method");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRENDERRESURL_HASWRITERETURNS,
            "Resource URL method write(java.io.Writer) returns void");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRENDERRESURL_HASWRITERETURNSA,
            "Resource URL method write(java.io.Writer, boolean) returns void");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRESOURCEACTURL_HASADDPROPERTY,
            "Action URL has a addProperty(String, String)  method");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRESOURCEACTURL_HASADDPROPERTYRETURNS,
            "Action URL method addProperty(String, String) returns void");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRESOURCEACTURL_HASGETPARAMETERMAP, "Action URL has a getParameterMap()  method");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRESOURCEACTURL_HASGETPARAMETERMAPRETURNS,
            "Action URL method getParameterMap() returns java.util.Map");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRESOURCEACTURL_HASSETPARAMETER,
            "Action URL has a setParameter(String, String)  method");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRESOURCEACTURL_HASSETPARAMETERA,
            "Action URL has a setParameter(String, String[])  method");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRESOURCEACTURL_HASSETPARAMETERRETURNS,
            "Action URL method setParameter(String, String) returns void");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRESOURCEACTURL_HASSETPARAMETERRETURNSA,
            "Action URL method setParameter(String, String[]) returns void");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRESOURCEACTURL_HASSETPARAMETERS,
            "Action URL has a setParameters(java.util.Map)  method");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRESOURCEACTURL_HASSETPARAMETERSRETURNS,
            "Action URL method setParameters(java.util.Map) returns void");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRESOURCEACTURL_HASSETPROPERTY,
            "Action URL has a setProperty(String, String)  method");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRESOURCEACTURL_HASSETPROPERTYRETURNS,
            "Action URL method setProperty(String, String) returns void");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRESOURCEACTURL_HASSETSECURE,
            "Action URL has a setSecure(boolean) throws PortletSecurityException method");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRESOURCEACTURL_HASSETSECURERETURNS,
            "Action URL method setSecure(boolean) returns void");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRESOURCEACTURL_HASTOSTRING, "Action URL has a toString()  method");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRESOURCEACTURL_HASTOSTRINGRETURNS,
            "Action URL method toString() returns String");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRESOURCEACTURL_HASWRITE,
            "Action URL has a write(java.io.Writer) throws java.io.IOException method");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRESOURCEACTURL_HASWRITEA,
            "Action URL has a write(java.io.Writer, boolean) throws java.io.IOException method");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRESOURCEACTURL_HASWRITERETURNS,
            "Action URL method write(java.io.Writer) returns void");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRESOURCEACTURL_HASWRITERETURNSA,
            "Action URL method write(java.io.Writer, boolean) returns void");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRESOURCERENURL_HASADDPROPERTY,
            "Render URL has a addProperty(String, String)  method");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRESOURCERENURL_HASADDPROPERTYRETURNS,
            "Render URL method addProperty(String, String) returns void");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRESOURCERENURL_HASGETPARAMETERMAP, "Render URL has a getParameterMap()  method");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRESOURCERENURL_HASGETPARAMETERMAPRETURNS,
            "Render URL method getParameterMap() returns java.util.Map");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRESOURCERENURL_HASSETPARAMETER,
            "Render URL has a setParameter(String, String)  method");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRESOURCERENURL_HASSETPARAMETERA,
            "Render URL has a setParameter(String, String[])  method");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRESOURCERENURL_HASSETPARAMETERRETURNS,
            "Render URL method setParameter(String, String) returns void");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRESOURCERENURL_HASSETPARAMETERRETURNSA,
            "Render URL method setParameter(String, String[]) returns void");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRESOURCERENURL_HASSETPARAMETERS,
            "Render URL has a setParameters(java.util.Map)  method");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRESOURCERENURL_HASSETPARAMETERSRETURNS,
            "Render URL method setParameters(java.util.Map) returns void");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRESOURCERENURL_HASSETPROPERTY,
            "Render URL has a setProperty(String, String)  method");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRESOURCERENURL_HASSETPROPERTYRETURNS,
            "Render URL method setProperty(String, String) returns void");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRESOURCERENURL_HASSETSECURE,
            "Render URL has a setSecure(boolean) throws PortletSecurityException method");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRESOURCERENURL_HASSETSECURERETURNS,
            "Render URL method setSecure(boolean) returns void");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRESOURCERENURL_HASTOSTRING, "Render URL has a toString()  method");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRESOURCERENURL_HASTOSTRINGRETURNS,
            "Render URL method toString() returns String");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRESOURCERENURL_HASWRITE,
            "Render URL has a write(java.io.Writer) throws java.io.IOException method");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRESOURCERENURL_HASWRITEA,
            "Render URL has a write(java.io.Writer, boolean) throws java.io.IOException method");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRESOURCERENURL_HASWRITERETURNS,
            "Render URL method write(java.io.Writer) returns void");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRESOURCERENURL_HASWRITERETURNSA,
            "Render URL method write(java.io.Writer, boolean) returns void");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRESOURCERESURL_HASADDPROPERTY,
            "Resource URL has a addProperty(String, String)  method");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRESOURCERESURL_HASADDPROPERTYRETURNS,
            "Resource URL method addProperty(String, String) returns void");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRESOURCERESURL_HASGETPARAMETERMAP,
            "Resource URL has a getParameterMap()  method");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRESOURCERESURL_HASGETPARAMETERMAPRETURNS,
            "Resource URL method getParameterMap() returns java.util.Map");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRESOURCERESURL_HASSETPARAMETER,
            "Resource URL has a setParameter(String, String)  method");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRESOURCERESURL_HASSETPARAMETERA,
            "Resource URL has a setParameter(String, String[])  method");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRESOURCERESURL_HASSETPARAMETERRETURNS,
            "Resource URL method setParameter(String, String) returns void");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRESOURCERESURL_HASSETPARAMETERRETURNSA,
            "Resource URL method setParameter(String, String[]) returns void");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRESOURCERESURL_HASSETPARAMETERS,
            "Resource URL has a setParameters(java.util.Map)  method");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRESOURCERESURL_HASSETPARAMETERSRETURNS,
            "Resource URL method setParameters(java.util.Map) returns void");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRESOURCERESURL_HASSETPROPERTY,
            "Resource URL has a setProperty(String, String)  method");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRESOURCERESURL_HASSETPROPERTYRETURNS,
            "Resource URL method setProperty(String, String) returns void");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRESOURCERESURL_HASSETSECURE,
            "Resource URL has a setSecure(boolean) throws PortletSecurityException method");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRESOURCERESURL_HASSETSECURERETURNS,
            "Resource URL method setSecure(boolean) returns void");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRESOURCERESURL_HASTOSTRING, "Resource URL has a toString()  method");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRESOURCERESURL_HASTOSTRINGRETURNS,
            "Resource URL method toString() returns String");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRESOURCERESURL_HASWRITE,
            "Resource URL has a write(java.io.Writer) throws java.io.IOException method");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRESOURCERESURL_HASWRITEA,
            "Resource URL has a write(java.io.Writer, boolean) throws java.io.IOException method");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRESOURCERESURL_HASWRITERETURNS,
            "Resource URL method write(java.io.Writer) returns void");
      tcd.put(V2SIGTESTSURL_BASEURL_SIGRESOURCERESURL_HASWRITERETURNSA,
            "Resource URL method write(java.io.Writer, boolean) returns void");
      tcd.put(V2SIGTESTSURL_PORTLETURL_SIGRENDERACTURL_HASGETPORTLETMODE, "Rection URL has a getPortletMode()  method");
      tcd.put(V2SIGTESTSURL_PORTLETURL_SIGRENDERACTURL_HASGETPORTLETMODERETURNS,
            "Rection URL method getPortletMode() returns PortletMode");
      tcd.put(V2SIGTESTSURL_PORTLETURL_SIGRENDERACTURL_HASGETWINDOWSTATE, "Rection URL has a getWindowState()  method");
      tcd.put(V2SIGTESTSURL_PORTLETURL_SIGRENDERACTURL_HASGETWINDOWSTATERETURNS,
            "Rection URL method getWindowState() returns WindowState");
      tcd.put(V2SIGTESTSURL_PORTLETURL_SIGRENDERACTURL_HASREMOVEPUBLICRENDERPARAMETER,
            "Rection URL has a removePublicRenderParameter(String)  method");
      tcd.put(V2SIGTESTSURL_PORTLETURL_SIGRENDERACTURL_HASREMOVEPUBLICRENDERPARAMETERRETURNS,
            "Rection URL method removePublicRenderParameter(String) returns void");
      tcd.put(V2SIGTESTSURL_PORTLETURL_SIGRENDERACTURL_HASSETPORTLETMODE,
            "Rection URL has a setPortletMode(PortletMode) throws PortletModeException method");
      tcd.put(V2SIGTESTSURL_PORTLETURL_SIGRENDERACTURL_HASSETPORTLETMODERETURNS,
            "Rection URL method setPortletMode(PortletMode) returns void");
      tcd.put(V2SIGTESTSURL_PORTLETURL_SIGRENDERACTURL_HASSETWINDOWSTATE,
            "Rection URL has a setWindowState(WindowState) throws WindowStateException method");
      tcd.put(V2SIGTESTSURL_PORTLETURL_SIGRENDERACTURL_HASSETWINDOWSTATERETURNS,
            "Rection URL method setWindowState(WindowState) returns void");
      tcd.put(V2SIGTESTSURL_PORTLETURL_SIGRENDERACTURL_IMPLEMENTSBASEURL, "Rection URL implements BaseURL");
      tcd.put(V2SIGTESTSURL_PORTLETURL_SIGRENDERRENURL_HASGETPORTLETMODE, "Render URL has a getPortletMode()  method");
      tcd.put(V2SIGTESTSURL_PORTLETURL_SIGRENDERRENURL_HASGETPORTLETMODERETURNS,
            "Render URL method getPortletMode() returns PortletMode");
      tcd.put(V2SIGTESTSURL_PORTLETURL_SIGRENDERRENURL_HASGETWINDOWSTATE, "Render URL has a getWindowState()  method");
      tcd.put(V2SIGTESTSURL_PORTLETURL_SIGRENDERRENURL_HASGETWINDOWSTATERETURNS,
            "Render URL method getWindowState() returns WindowState");
      tcd.put(V2SIGTESTSURL_PORTLETURL_SIGRENDERRENURL_HASREMOVEPUBLICRENDERPARAMETER,
            "Render URL has a removePublicRenderParameter(String)  method");
      tcd.put(V2SIGTESTSURL_PORTLETURL_SIGRENDERRENURL_HASREMOVEPUBLICRENDERPARAMETERRETURNS,
            "Render URL method removePublicRenderParameter(String) returns void");
      tcd.put(V2SIGTESTSURL_PORTLETURL_SIGRENDERRENURL_HASSETPORTLETMODE,
            "Render URL has a setPortletMode(PortletMode) throws PortletModeException method");
      tcd.put(V2SIGTESTSURL_PORTLETURL_SIGRENDERRENURL_HASSETPORTLETMODERETURNS,
            "Render URL method setPortletMode(PortletMode) returns void");
      tcd.put(V2SIGTESTSURL_PORTLETURL_SIGRENDERRENURL_HASSETWINDOWSTATE,
            "Render URL has a setWindowState(WindowState) throws WindowStateException method");
      tcd.put(V2SIGTESTSURL_PORTLETURL_SIGRENDERRENURL_HASSETWINDOWSTATERETURNS,
            "Render URL method setWindowState(WindowState) returns void");
      tcd.put(V2SIGTESTSURL_PORTLETURL_SIGRENDERRENURL_IMPLEMENTSBASEURL, "Render URL implements BaseURL");
      tcd.put(V2SIGTESTSURL_PORTLETURL_SIGRESOURCEACTURL_HASGETPORTLETMODE,
            "Action URL has a getPortletMode()  method");
      tcd.put(V2SIGTESTSURL_PORTLETURL_SIGRESOURCEACTURL_HASGETPORTLETMODERETURNS,
            "Action URL method getPortletMode() returns PortletMode");
      tcd.put(V2SIGTESTSURL_PORTLETURL_SIGRESOURCEACTURL_HASGETWINDOWSTATE,
            "Action URL has a getWindowState()  method");
      tcd.put(V2SIGTESTSURL_PORTLETURL_SIGRESOURCEACTURL_HASGETWINDOWSTATERETURNS,
            "Action URL method getWindowState() returns WindowState");
      tcd.put(V2SIGTESTSURL_PORTLETURL_SIGRESOURCEACTURL_HASREMOVEPUBLICRENDERPARAMETER,
            "Action URL has a removePublicRenderParameter(String)  method");
      tcd.put(V2SIGTESTSURL_PORTLETURL_SIGRESOURCEACTURL_HASREMOVEPUBLICRENDERPARAMETERRETURNS,
            "Action URL method removePublicRenderParameter(String) returns void");
      tcd.put(V2SIGTESTSURL_PORTLETURL_SIGRESOURCEACTURL_HASSETPORTLETMODE,
            "Action URL has a setPortletMode(PortletMode) throws PortletModeException method");
      tcd.put(V2SIGTESTSURL_PORTLETURL_SIGRESOURCEACTURL_HASSETPORTLETMODERETURNS,
            "Action URL method setPortletMode(PortletMode) returns void");
      tcd.put(V2SIGTESTSURL_PORTLETURL_SIGRESOURCEACTURL_HASSETWINDOWSTATE,
            "Action URL has a setWindowState(WindowState) throws WindowStateException method");
      tcd.put(V2SIGTESTSURL_PORTLETURL_SIGRESOURCEACTURL_HASSETWINDOWSTATERETURNS,
            "Action URL method setWindowState(WindowState) returns void");
      tcd.put(V2SIGTESTSURL_PORTLETURL_SIGRESOURCEACTURL_IMPLEMENTSBASEURL, "Action URL implements BaseURL");
      tcd.put(V2SIGTESTSURL_PORTLETURL_SIGRESOURCERENURL_HASGETPORTLETMODE,
            "Render URL has a getPortletMode()  method");
      tcd.put(V2SIGTESTSURL_PORTLETURL_SIGRESOURCERENURL_HASGETPORTLETMODERETURNS,
            "Render URL method getPortletMode() returns PortletMode");
      tcd.put(V2SIGTESTSURL_PORTLETURL_SIGRESOURCERENURL_HASGETWINDOWSTATE,
            "Render URL has a getWindowState()  method");
      tcd.put(V2SIGTESTSURL_PORTLETURL_SIGRESOURCERENURL_HASGETWINDOWSTATERETURNS,
            "Render URL method getWindowState() returns WindowState");
      tcd.put(V2SIGTESTSURL_PORTLETURL_SIGRESOURCERENURL_HASREMOVEPUBLICRENDERPARAMETER,
            "Render URL has a removePublicRenderParameter(String)  method");
      tcd.put(V2SIGTESTSURL_PORTLETURL_SIGRESOURCERENURL_HASREMOVEPUBLICRENDERPARAMETERRETURNS,
            "Render URL method removePublicRenderParameter(String) returns void");
      tcd.put(V2SIGTESTSURL_PORTLETURL_SIGRESOURCERENURL_HASSETPORTLETMODE,
            "Render URL has a setPortletMode(PortletMode) throws PortletModeException method");
      tcd.put(V2SIGTESTSURL_PORTLETURL_SIGRESOURCERENURL_HASSETPORTLETMODERETURNS,
            "Render URL method setPortletMode(PortletMode) returns void");
      tcd.put(V2SIGTESTSURL_PORTLETURL_SIGRESOURCERENURL_HASSETWINDOWSTATE,
            "Render URL has a setWindowState(WindowState) throws WindowStateException method");
      tcd.put(V2SIGTESTSURL_PORTLETURL_SIGRESOURCERENURL_HASSETWINDOWSTATERETURNS,
            "Render URL method setWindowState(WindowState) returns void");
      tcd.put(V2SIGTESTSURL_PORTLETURL_SIGRESOURCERENURL_IMPLEMENTSBASEURL, "Render URL implements BaseURL");
      tcd.put(V2SIGTESTSURL_RESOURCEURL_SIGRENDER_FIELDFULL, "ResourceURL has String field FULL");
      tcd.put(V2SIGTESTSURL_RESOURCEURL_SIGRENDER_FIELDPAGE, "ResourceURL has String field PAGE");
      tcd.put(V2SIGTESTSURL_RESOURCEURL_SIGRENDER_FIELDPORTLET, "ResourceURL has String field PORTLET");
      tcd.put(V2SIGTESTSURL_RESOURCEURL_SIGRENDER_FIELDSHARED, "ResourceURL has String field SHARED");
      tcd.put(V2SIGTESTSURL_RESOURCEURL_SIGRENDER_HASGETCACHEABILITY, "ResourceURL has a getCacheability()  method");
      tcd.put(V2SIGTESTSURL_RESOURCEURL_SIGRENDER_HASGETCACHEABILITYRETURNS,
            "ResourceURL method getCacheability() returns String");
      tcd.put(V2SIGTESTSURL_RESOURCEURL_SIGRENDER_HASSETCACHEABILITY,
            "ResourceURL has a setCacheability(String)  method");
      tcd.put(V2SIGTESTSURL_RESOURCEURL_SIGRENDER_HASSETCACHEABILITYRETURNS,
            "ResourceURL method setCacheability(String) returns void");
      tcd.put(V2SIGTESTSURL_RESOURCEURL_SIGRENDER_HASSETRESOURCEID, "ResourceURL has a setResourceID(String)  method");
      tcd.put(V2SIGTESTSURL_RESOURCEURL_SIGRENDER_HASSETRESOURCEIDRETURNS,
            "ResourceURL method setResourceID(String) returns void");
      tcd.put(V2SIGTESTSURL_RESOURCEURL_SIGRENDER_IMPLEMENTSBASEURL, "ResourceURL implements BaseURL");
      tcd.put(V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_CONSTRUCTOR,
            "ActionRequestWrapper provides constructor ActionRequestWrapper(ActionRequest) ");
      tcd.put(V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_EXTENDSPORTLETREQUESTWRAPPER,
            "ActionRequestWrapper extends PortletRequestWrapper");
      tcd.put(V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASGETCHARACTERENCODING,
            "ActionRequestWrapper has a getCharacterEncoding()  method");
      tcd.put(V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASGETCHARACTERENCODINGRETURNS,
            "ActionRequestWrapper method getCharacterEncoding() returns String");
      tcd.put(V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASGETCONTENTLENGTH,
            "ActionRequestWrapper has a getContentLength()  method");
      tcd.put(V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASGETCONTENTLENGTHRETURNS,
            "ActionRequestWrapper method getContentLength() returns int");
      tcd.put(V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASGETCONTENTTYPE,
            "ActionRequestWrapper has a getContentType()  method");
      tcd.put(V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASGETCONTENTTYPERETURNS,
            "ActionRequestWrapper method getContentType() returns String");
      tcd.put(V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASGETMETHOD,
            "ActionRequestWrapper has a getMethod()  method");
      tcd.put(V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASGETMETHODRETURNS,
            "ActionRequestWrapper method getMethod() returns String");
      tcd.put(V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASGETPORTLETINPUTSTREAM,
            "ActionRequestWrapper has a getPortletInputStream() throws java.io.IOException method");
      tcd.put(V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASGETPORTLETINPUTSTREAMRETURNS,
            "ActionRequestWrapper method getPortletInputStream() returns java.io.InputStream");
      tcd.put(V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASGETREADER,
            "ActionRequestWrapper has a getReader() throws java.io.UnsupportedEncodingException, java.io.IOException method");
      tcd.put(V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASGETREADERRETURNS,
            "ActionRequestWrapper method getReader() returns java.io.BufferedReader");
      tcd.put(V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASGETREQUEST,
            "ActionRequestWrapper has a getRequest()  method");
      tcd.put(V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASGETREQUESTA,
            "ActionRequestWrapper has a getRequest()  method");
      tcd.put(V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASGETREQUESTRETURNS,
            "ActionRequestWrapper method getRequest() returns ActionRequest");
      tcd.put(V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASGETREQUESTRETURNSA,
            "ActionRequestWrapper method getRequest() returns PortletRequest");
      tcd.put(V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASSETCHARACTERENCODING,
            "ActionRequestWrapper has a setCharacterEncoding(String) throws java.io.UnsupportedEncodingException method");
      tcd.put(V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASSETCHARACTERENCODINGRETURNS,
            "ActionRequestWrapper method setCharacterEncoding(String) returns void");
      tcd.put(V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASSETREQUEST,
            "ActionRequestWrapper has a setRequest(ActionRequest)  method");
      tcd.put(V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_HASSETREQUESTRETURNS,
            "ActionRequestWrapper method setRequest(ActionRequest) returns void");
      tcd.put(V2SIGTESTSWRAPPER_ACTIONREQUESTWRAPPER_SIGRENDER_IMPLEMENTSACTIONREQUEST,
            "ActionRequestWrapper implements ActionRequest");
      tcd.put(V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_CONSTRUCTOR,
            "ActionResponseWrapper provides constructor ActionResponseWrapper(ActionResponse) ");
      tcd.put(V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_EXTENDSPORTLETRESPONSEWRAPPER,
            "ActionResponseWrapper extends PortletResponseWrapper");
      tcd.put(V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASGETPORTLETMODE,
            "ActionResponseWrapper has a getPortletMode()  method");
      tcd.put(V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASGETPORTLETMODERETURNS,
            "ActionResponseWrapper method getPortletMode() returns PortletMode");
      tcd.put(V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASGETRENDERPARAMETERMAP,
            "ActionResponseWrapper has a getRenderParameterMap()  method");
      tcd.put(V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASGETRENDERPARAMETERMAPRETURNS,
            "ActionResponseWrapper method getRenderParameterMap() returns java.util.Map");
      tcd.put(V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASGETRESPONSE,
            "ActionResponseWrapper has a getResponse()  method");
      tcd.put(V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASGETRESPONSEA,
            "ActionResponseWrapper has a getResponse()  method");
      tcd.put(V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASGETRESPONSERETURNS,
            "ActionResponseWrapper method getResponse() returns ActionResponse");
      tcd.put(V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASGETRESPONSERETURNSA,
            "ActionResponseWrapper method getResponse() returns PortletResponse");
      tcd.put(V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASGETWINDOWSTATE,
            "ActionResponseWrapper has a getWindowState()  method");
      tcd.put(V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASGETWINDOWSTATERETURNS,
            "ActionResponseWrapper method getWindowState() returns WindowState");
      tcd.put(V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASREMOVEPUBLICRENDERPARAMETER,
            "ActionResponseWrapper has a removePublicRenderParameter(String)  method");
      tcd.put(V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASREMOVEPUBLICRENDERPARAMETERRETURNS,
            "ActionResponseWrapper method removePublicRenderParameter(String) returns void");
      tcd.put(V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSENDREDIRECT,
            "ActionResponseWrapper has a sendRedirect(String) throws java.io.IOException method");
      tcd.put(V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSENDREDIRECTA,
            "ActionResponseWrapper has a sendRedirect(String, String) throws java.io.IOException method");
      tcd.put(V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSENDREDIRECTRETURNS,
            "ActionResponseWrapper method sendRedirect(String) returns void");
      tcd.put(V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSENDREDIRECTRETURNSA,
            "ActionResponseWrapper method sendRedirect(String, String) returns void");
      tcd.put(V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSETEVENT,
            "ActionResponseWrapper has a setEvent(javax.xml.namespace.QName, java.io.Serializable)  method");
      tcd.put(V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSETEVENTA,
            "ActionResponseWrapper has a setEvent(String, java.io.Serializable)  method");
      tcd.put(V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSETEVENTRETURNS,
            "ActionResponseWrapper method setEvent(javax.xml.namespace.QName, java.io.Serializable) returns void");
      tcd.put(V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSETEVENTRETURNSA,
            "ActionResponseWrapper method setEvent(String, java.io.Serializable) returns void");
      tcd.put(V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSETPORTLETMODE,
            "ActionResponseWrapper has a setPortletMode(PortletMode) throws PortletModeException method");
      tcd.put(V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSETPORTLETMODERETURNS,
            "ActionResponseWrapper method setPortletMode(PortletMode) returns void");
      tcd.put(V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSETRENDERPARAMETER,
            "ActionResponseWrapper has a setRenderParameter(String, String)  method");
      tcd.put(V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSETRENDERPARAMETERA,
            "ActionResponseWrapper has a setRenderParameter(String, String[])  method");
      tcd.put(V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSETRENDERPARAMETERRETURNS,
            "ActionResponseWrapper method setRenderParameter(String, String) returns void");
      tcd.put(V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSETRENDERPARAMETERRETURNSA,
            "ActionResponseWrapper method setRenderParameter(String, String[]) returns void");
      tcd.put(V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSETRENDERPARAMETERS,
            "ActionResponseWrapper has a setRenderParameters(java.util.Map)  method");
      tcd.put(V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSETRENDERPARAMETERSRETURNS,
            "ActionResponseWrapper method setRenderParameters(java.util.Map) returns void");
      tcd.put(V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSETRESPONSE,
            "ActionResponseWrapper has a setResponse(ActionResponse)  method");
      tcd.put(V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSETRESPONSERETURNS,
            "ActionResponseWrapper method setResponse(ActionResponse) returns void");
      tcd.put(V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSETWINDOWSTATE,
            "ActionResponseWrapper has a setWindowState(WindowState) throws WindowStateException method");
      tcd.put(V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_HASSETWINDOWSTATERETURNS,
            "ActionResponseWrapper method setWindowState(WindowState) returns void");
      tcd.put(V2SIGTESTSWRAPPER_ACTIONRESPONSEWRAPPER_SIGRENDER_IMPLEMENTSACTIONRESPONSE,
            "ActionResponseWrapper implements ActionResponse");
      tcd.put(V2SIGTESTSWRAPPER_EVENTREQUESTWRAPPER_SIGRENDER_CONSTRUCTOR,
            "EventRequestWrapper provides constructor EventRequestWrapper(EventRequest) ");
      tcd.put(V2SIGTESTSWRAPPER_EVENTREQUESTWRAPPER_SIGRENDER_EXTENDSPORTLETREQUESTWRAPPER,
            "EventRequestWrapper extends PortletRequestWrapper");
      tcd.put(V2SIGTESTSWRAPPER_EVENTREQUESTWRAPPER_SIGRENDER_HASGETEVENT,
            "EventRequestWrapper has a getEvent()  method");
      tcd.put(V2SIGTESTSWRAPPER_EVENTREQUESTWRAPPER_SIGRENDER_HASGETEVENTRETURNS,
            "EventRequestWrapper method getEvent() returns Event");
      tcd.put(V2SIGTESTSWRAPPER_EVENTREQUESTWRAPPER_SIGRENDER_HASGETMETHOD,
            "EventRequestWrapper has a getMethod()  method");
      tcd.put(V2SIGTESTSWRAPPER_EVENTREQUESTWRAPPER_SIGRENDER_HASGETMETHODRETURNS,
            "EventRequestWrapper method getMethod() returns String");
      tcd.put(V2SIGTESTSWRAPPER_EVENTREQUESTWRAPPER_SIGRENDER_HASGETREQUEST,
            "EventRequestWrapper has a getRequest()  method");
      tcd.put(V2SIGTESTSWRAPPER_EVENTREQUESTWRAPPER_SIGRENDER_HASGETREQUESTA,
            "EventRequestWrapper has a getRequest()  method");
      tcd.put(V2SIGTESTSWRAPPER_EVENTREQUESTWRAPPER_SIGRENDER_HASGETREQUESTRETURNS,
            "EventRequestWrapper method getRequest() returns EventRequest");
      tcd.put(V2SIGTESTSWRAPPER_EVENTREQUESTWRAPPER_SIGRENDER_HASGETREQUESTRETURNSA,
            "EventRequestWrapper method getRequest() returns PortletRequest");
      tcd.put(V2SIGTESTSWRAPPER_EVENTREQUESTWRAPPER_SIGRENDER_HASSETREQUEST,
            "EventRequestWrapper has a setRequest(EventRequest)  method");
      tcd.put(V2SIGTESTSWRAPPER_EVENTREQUESTWRAPPER_SIGRENDER_HASSETREQUESTRETURNS,
            "EventRequestWrapper method setRequest(EventRequest) returns void");
      tcd.put(V2SIGTESTSWRAPPER_EVENTREQUESTWRAPPER_SIGRENDER_IMPLEMENTSEVENTREQUEST,
            "EventRequestWrapper implements EventRequest");
      tcd.put(V2SIGTESTSWRAPPER_EVENTRESPONSEWRAPPER_SIGRENDER_CONSTRUCTOR,
            "EventResponseWrapper provides constructor EventResponseWrapper(EventResponse) ");
      tcd.put(V2SIGTESTSWRAPPER_EVENTRESPONSEWRAPPER_SIGRENDER_EXTENDSPORTLETRESPONSEWRAPPER,
            "EventResponseWrapper extends PortletResponseWrapper");
      tcd.put(V2SIGTESTSWRAPPER_EVENTRESPONSEWRAPPER_SIGRENDER_HASGETPORTLETMODE,
            "EventResponseWrapper has a getPortletMode()  method");
      tcd.put(V2SIGTESTSWRAPPER_EVENTRESPONSEWRAPPER_SIGRENDER_HASGETPORTLETMODERETURNS,
            "EventResponseWrapper method getPortletMode() returns PortletMode");
      tcd.put(V2SIGTESTSWRAPPER_EVENTRESPONSEWRAPPER_SIGRENDER_HASGETRENDERPARAMETERMAP,
            "EventResponseWrapper has a getRenderParameterMap()  method");
      tcd.put(V2SIGTESTSWRAPPER_EVENTRESPONSEWRAPPER_SIGRENDER_HASGETRENDERPARAMETERMAPRETURNS,
            "EventResponseWrapper method getRenderParameterMap() returns java.util.Map");
      tcd.put(V2SIGTESTSWRAPPER_EVENTRESPONSEWRAPPER_SIGRENDER_HASGETRESPONSE,
            "EventResponseWrapper has a getResponse()  method");
      tcd.put(V2SIGTESTSWRAPPER_EVENTRESPONSEWRAPPER_SIGRENDER_HASGETRESPONSEA,
            "EventResponseWrapper has a getResponse()  method");
      tcd.put(V2SIGTESTSWRAPPER_EVENTRESPONSEWRAPPER_SIGRENDER_HASGETRESPONSERETURNS,
            "EventResponseWrapper method getResponse() returns EventResponse");
      tcd.put(V2SIGTESTSWRAPPER_EVENTRESPONSEWRAPPER_SIGRENDER_HASGETRESPONSERETURNSA,
            "EventResponseWrapper method getResponse() returns PortletResponse");
      tcd.put(V2SIGTESTSWRAPPER_EVENTRESPONSEWRAPPER_SIGRENDER_HASGETWINDOWSTATE,
            "EventResponseWrapper has a getWindowState()  method");
      tcd.put(V2SIGTESTSWRAPPER_EVENTRESPONSEWRAPPER_SIGRENDER_HASGETWINDOWSTATERETURNS,
            "EventResponseWrapper method getWindowState() returns WindowState");
      tcd.put(V2SIGTESTSWRAPPER_EVENTRESPONSEWRAPPER_SIGRENDER_HASREMOVEPUBLICRENDERPARAMETER,
            "EventResponseWrapper has a removePublicRenderParameter(String)  method");
      tcd.put(V2SIGTESTSWRAPPER_EVENTRESPONSEWRAPPER_SIGRENDER_HASREMOVEPUBLICRENDERPARAMETERRETURNS,
            "EventResponseWrapper method removePublicRenderParameter(String) returns void");
      tcd.put(V2SIGTESTSWRAPPER_EVENTRESPONSEWRAPPER_SIGRENDER_HASSETEVENT,
            "EventResponseWrapper has a setEvent(javax.xml.namespace.QName, java.io.Serializable)  method");
      tcd.put(V2SIGTESTSWRAPPER_EVENTRESPONSEWRAPPER_SIGRENDER_HASSETEVENTA,
            "EventResponseWrapper has a setEvent(String, java.io.Serializable)  method");
      tcd.put(V2SIGTESTSWRAPPER_EVENTRESPONSEWRAPPER_SIGRENDER_HASSETEVENTRETURNS,
            "EventResponseWrapper method setEvent(javax.xml.namespace.QName, java.io.Serializable) returns void");
      tcd.put(V2SIGTESTSWRAPPER_EVENTRESPONSEWRAPPER_SIGRENDER_HASSETEVENTRETURNSA,
            "EventResponseWrapper method setEvent(String, java.io.Serializable) returns void");
      tcd.put(V2SIGTESTSWRAPPER_EVENTRESPONSEWRAPPER_SIGRENDER_HASSETPORTLETMODE,
            "EventResponseWrapper has a setPortletMode(PortletMode) throws PortletModeException method");
      tcd.put(V2SIGTESTSWRAPPER_EVENTRESPONSEWRAPPER_SIGRENDER_HASSETPORTLETMODERETURNS,
            "EventResponseWrapper method setPortletMode(PortletMode) returns void");
      tcd.put(V2SIGTESTSWRAPPER_EVENTRESPONSEWRAPPER_SIGRENDER_HASSETRENDERPARAMETER,
            "EventResponseWrapper has a setRenderParameter(String, String)  method");
      tcd.put(V2SIGTESTSWRAPPER_EVENTRESPONSEWRAPPER_SIGRENDER_HASSETRENDERPARAMETERA,
            "EventResponseWrapper has a setRenderParameter(String, String[])  method");
      tcd.put(V2SIGTESTSWRAPPER_EVENTRESPONSEWRAPPER_SIGRENDER_HASSETRENDERPARAMETERRETURNS,
            "EventResponseWrapper method setRenderParameter(String, String) returns void");
      tcd.put(V2SIGTESTSWRAPPER_EVENTRESPONSEWRAPPER_SIGRENDER_HASSETRENDERPARAMETERRETURNSA,
            "EventResponseWrapper method setRenderParameter(String, String[]) returns void");
      tcd.put(V2SIGTESTSWRAPPER_EVENTRESPONSEWRAPPER_SIGRENDER_HASSETRENDERPARAMETERS,
            "EventResponseWrapper has a setRenderParameters(java.util.Map)  method");
      tcd.put(V2SIGTESTSWRAPPER_EVENTRESPONSEWRAPPER_SIGRENDER_HASSETRENDERPARAMETERSA,
            "EventResponseWrapper has a setRenderParameters(EventRequest)  method");
      tcd.put(V2SIGTESTSWRAPPER_EVENTRESPONSEWRAPPER_SIGRENDER_HASSETRENDERPARAMETERSRETURNS,
            "EventResponseWrapper method setRenderParameters(java.util.Map) returns void");
      tcd.put(V2SIGTESTSWRAPPER_EVENTRESPONSEWRAPPER_SIGRENDER_HASSETRENDERPARAMETERSRETURNSA,
            "EventResponseWrapper method setRenderParameters(EventRequest) returns void");
      tcd.put(V2SIGTESTSWRAPPER_EVENTRESPONSEWRAPPER_SIGRENDER_HASSETRESPONSE,
            "EventResponseWrapper has a setResponse(EventResponse)  method");
      tcd.put(V2SIGTESTSWRAPPER_EVENTRESPONSEWRAPPER_SIGRENDER_HASSETRESPONSERETURNS,
            "EventResponseWrapper method setResponse(EventResponse) returns void");
      tcd.put(V2SIGTESTSWRAPPER_EVENTRESPONSEWRAPPER_SIGRENDER_HASSETWINDOWSTATE,
            "EventResponseWrapper has a setWindowState(WindowState) throws WindowStateException method");
      tcd.put(V2SIGTESTSWRAPPER_EVENTRESPONSEWRAPPER_SIGRENDER_HASSETWINDOWSTATERETURNS,
            "EventResponseWrapper method setWindowState(WindowState) returns void");
      tcd.put(V2SIGTESTSWRAPPER_EVENTRESPONSEWRAPPER_SIGRENDER_IMPLEMENTSEVENTRESPONSE,
            "EventResponseWrapper implements EventResponse");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_CONSTRUCTOR,
            "PortletRequestWrapper provides constructor PortletRequestWrapper(PortletRequest) ");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETATTRIBUTE,
            "PortletRequestWrapper has a getAttribute(String)  method");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETATTRIBUTENAMES,
            "PortletRequestWrapper has a getAttributeNames()  method");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETATTRIBUTENAMESRETURNS,
            "PortletRequestWrapper method getAttributeNames() returns java.util.Enumeration");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETATTRIBUTERETURNS,
            "PortletRequestWrapper method getAttribute(String) returns Object");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETAUTHTYPE,
            "PortletRequestWrapper has a getAuthType()  method");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETAUTHTYPERETURNS,
            "PortletRequestWrapper method getAuthType() returns String");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETCONTEXTPATH,
            "PortletRequestWrapper has a getContextPath()  method");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETCONTEXTPATHRETURNS,
            "PortletRequestWrapper method getContextPath() returns String");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETCOOKIES,
            "PortletRequestWrapper has a getCookies()  method");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETCOOKIESRETURNS,
            "PortletRequestWrapper method getCookies() returns javax.servlet.http.Cookie[] ");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETLOCALE,
            "PortletRequestWrapper has a getLocale()  method");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETLOCALERETURNS,
            "PortletRequestWrapper method getLocale() returns java.util.Locale");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETLOCALES,
            "PortletRequestWrapper has a getLocales()  method");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETLOCALESRETURNS,
            "PortletRequestWrapper method getLocales() returns java.util.Enumeration");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETPARAMETER,
            "PortletRequestWrapper has a getParameter(String)  method");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETPARAMETERMAP,
            "PortletRequestWrapper has a getParameterMap()  method");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETPARAMETERMAPRETURNS,
            "PortletRequestWrapper method getParameterMap() returns java.util.Map");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETPARAMETERNAMES,
            "PortletRequestWrapper has a getParameterNames()  method");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETPARAMETERNAMESRETURNS,
            "PortletRequestWrapper method getParameterNames() returns java.util.Enumeration");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETPARAMETERRETURNS,
            "PortletRequestWrapper method getParameter(String) returns String");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETPARAMETERVALUES,
            "PortletRequestWrapper has a getParameterValues(String)  method");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETPARAMETERVALUESRETURNS,
            "PortletRequestWrapper method getParameterValues(String) returns String[] ");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETPORTALCONTEXT,
            "PortletRequestWrapper has a getPortalContext()  method");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETPORTALCONTEXTRETURNS,
            "PortletRequestWrapper method getPortalContext() returns PortalContext");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETPORTLETMODE,
            "PortletRequestWrapper has a getPortletMode()  method");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETPORTLETMODERETURNS,
            "PortletRequestWrapper method getPortletMode() returns PortletMode");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETPORTLETSESSION,
            "PortletRequestWrapper has a getPortletSession()  method");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETPORTLETSESSIONA,
            "PortletRequestWrapper has a getPortletSession(boolean)  method");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETPORTLETSESSIONRETURNS,
            "PortletRequestWrapper method getPortletSession() returns PortletSession");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETPORTLETSESSIONRETURNSA,
            "PortletRequestWrapper method getPortletSession(boolean) returns PortletSession");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETPREFERENCES,
            "PortletRequestWrapper has a getPreferences()  method");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETPREFERENCESRETURNS,
            "PortletRequestWrapper method getPreferences() returns PortletPreferences");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETPRIVATEPARAMETERMAP,
            "PortletRequestWrapper has a getPrivateParameterMap()  method");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETPRIVATEPARAMETERMAPRETURNS,
            "PortletRequestWrapper method getPrivateParameterMap() returns java.util.Map");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETPROPERTIES,
            "PortletRequestWrapper has a getProperties(String)  method");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETPROPERTIESRETURNS,
            "PortletRequestWrapper method getProperties(String) returns java.util.Enumeration");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETPROPERTY,
            "PortletRequestWrapper has a getProperty(String)  method");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETPROPERTYNAMES,
            "PortletRequestWrapper has a getPropertyNames()  method");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETPROPERTYNAMESRETURNS,
            "PortletRequestWrapper method getPropertyNames() returns java.util.Enumeration");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETPROPERTYRETURNS,
            "PortletRequestWrapper method getProperty(String) returns String");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETPUBLICPARAMETERMAP,
            "PortletRequestWrapper has a getPublicParameterMap()  method");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETPUBLICPARAMETERMAPRETURNS,
            "PortletRequestWrapper method getPublicParameterMap() returns java.util.Map");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETREMOTEUSER,
            "PortletRequestWrapper has a getRemoteUser()  method");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETREMOTEUSERRETURNS,
            "PortletRequestWrapper method getRemoteUser() returns String");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETREQUEST,
            "PortletRequestWrapper has a getRequest()  method");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETREQUESTRETURNS,
            "PortletRequestWrapper method getRequest() returns PortletRequest");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETREQUESTEDSESSIONID,
            "PortletRequestWrapper has a getRequestedSessionId()  method");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETREQUESTEDSESSIONIDRETURNS,
            "PortletRequestWrapper method getRequestedSessionId() returns String");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETRESPONSECONTENTTYPE,
            "PortletRequestWrapper has a getResponseContentType()  method");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETRESPONSECONTENTTYPERETURNS,
            "PortletRequestWrapper method getResponseContentType() returns String");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETRESPONSECONTENTTYPES,
            "PortletRequestWrapper has a getResponseContentTypes()  method");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETRESPONSECONTENTTYPESRETURNS,
            "PortletRequestWrapper method getResponseContentTypes() returns java.util.Enumeration");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETSCHEME,
            "PortletRequestWrapper has a getScheme()  method");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETSCHEMERETURNS,
            "PortletRequestWrapper method getScheme() returns String");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETSERVERNAME,
            "PortletRequestWrapper has a getServerName()  method");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETSERVERNAMERETURNS,
            "PortletRequestWrapper method getServerName() returns String");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETSERVERPORT,
            "PortletRequestWrapper has a getServerPort()  method");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETSERVERPORTRETURNS,
            "PortletRequestWrapper method getServerPort() returns int");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETUSERPRINCIPAL,
            "PortletRequestWrapper has a getUserPrincipal()  method");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETUSERPRINCIPALRETURNS,
            "PortletRequestWrapper method getUserPrincipal() returns java.security.Principal");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETWINDOWID,
            "PortletRequestWrapper has a getWindowID()  method");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETWINDOWIDRETURNS,
            "PortletRequestWrapper method getWindowID() returns String");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETWINDOWSTATE,
            "PortletRequestWrapper has a getWindowState()  method");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASGETWINDOWSTATERETURNS,
            "PortletRequestWrapper method getWindowState() returns WindowState");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASISPORTLETMODEALLOWED,
            "PortletRequestWrapper has a isPortletModeAllowed(PortletMode)  method");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASISPORTLETMODEALLOWEDRETURNS,
            "PortletRequestWrapper method isPortletModeAllowed(PortletMode) returns boolean");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASISREQUESTEDSESSIONIDVALID,
            "PortletRequestWrapper has a isRequestedSessionIdValid()  method");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASISREQUESTEDSESSIONIDVALIDRETURNS,
            "PortletRequestWrapper method isRequestedSessionIdValid() returns boolean");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASISSECURE,
            "PortletRequestWrapper has a isSecure()  method");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASISSECURERETURNS,
            "PortletRequestWrapper method isSecure() returns boolean");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASISUSERINROLE,
            "PortletRequestWrapper has a isUserInRole(String)  method");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASISUSERINROLERETURNS,
            "PortletRequestWrapper method isUserInRole(String) returns boolean");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASISWINDOWSTATEALLOWED,
            "PortletRequestWrapper has a isWindowStateAllowed(WindowState)  method");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASISWINDOWSTATEALLOWEDRETURNS,
            "PortletRequestWrapper method isWindowStateAllowed(WindowState) returns boolean");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASREMOVEATTRIBUTE,
            "PortletRequestWrapper has a removeAttribute(String)  method");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASREMOVEATTRIBUTERETURNS,
            "PortletRequestWrapper method removeAttribute(String) returns void");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASSETATTRIBUTE,
            "PortletRequestWrapper has a setAttribute(String, Object)  method");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASSETATTRIBUTERETURNS,
            "PortletRequestWrapper method setAttribute(String, Object) returns void");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASSETREQUEST,
            "PortletRequestWrapper has a setRequest(PortletRequest)  method");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_HASSETREQUESTRETURNS,
            "PortletRequestWrapper method setRequest(PortletRequest) returns void");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETREQUESTWRAPPER_SIGRENDER_IMPLEMENTSPORTLETREQUEST,
            "PortletRequestWrapper implements PortletRequest");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_CONSTRUCTOR,
            "PortletResponseWrapper provides constructor PortletResponseWrapper(PortletResponse) ");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASADDPROPERTY,
            "PortletResponseWrapper has a addProperty(String, String)  method");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASADDPROPERTYA,
            "PortletResponseWrapper has a addProperty(String, org.w3c.dom.Element)  method");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASADDPROPERTYB,
            "PortletResponseWrapper has a addProperty(javax.servlet.http.Cookie)  method");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASADDPROPERTYRETURNS,
            "PortletResponseWrapper method addProperty(String, String) returns void");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASADDPROPERTYRETURNSA,
            "PortletResponseWrapper method addProperty(String, org.w3c.dom.Element) returns void");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASADDPROPERTYRETURNSB,
            "PortletResponseWrapper method addProperty(javax.servlet.http.Cookie) returns void");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASCREATEELEMENT,
            "PortletResponseWrapper has a createElement(String)  method");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASCREATEELEMENTRETURNS,
            "PortletResponseWrapper method createElement(String) returns org.w3c.dom.Element");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASENCODEURL,
            "PortletResponseWrapper has a encodeURL(String)  method");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASENCODEURLRETURNS,
            "PortletResponseWrapper method encodeURL(String) returns String");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASGETNAMESPACE,
            "PortletResponseWrapper has a getNamespace()  method");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASGETNAMESPACERETURNS,
            "PortletResponseWrapper method getNamespace() returns String");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASGETRESPONSE,
            "PortletResponseWrapper has a getResponse()  method");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASGETRESPONSERETURNS,
            "PortletResponseWrapper method getResponse() returns PortletResponse");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASSETPROPERTY,
            "PortletResponseWrapper has a setProperty(String, String)  method");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASSETPROPERTYRETURNS,
            "PortletResponseWrapper method setProperty(String, String) returns void");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASSETRESPONSE,
            "PortletResponseWrapper has a setResponse(PortletResponse)  method");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_HASSETRESPONSERETURNS,
            "PortletResponseWrapper method setResponse(PortletResponse) returns void");
      tcd.put(V2SIGTESTSWRAPPER_PORTLETRESPONSEWRAPPER_SIGRENDER_IMPLEMENTSPORTLETRESPONSE,
            "PortletResponseWrapper implements PortletResponse");
      tcd.put(V2SIGTESTSWRAPPER_RENDERREQUESTWRAPPER_SIGRENDER_CONSTRUCTOR,
            "RenderRequestWrapper provides constructor RenderRequestWrapper(RenderRequest) ");
      tcd.put(V2SIGTESTSWRAPPER_RENDERREQUESTWRAPPER_SIGRENDER_EXTENDSPORTLETREQUESTWRAPPER,
            "RenderRequestWrapper extends PortletRequestWrapper");
      tcd.put(V2SIGTESTSWRAPPER_RENDERREQUESTWRAPPER_SIGRENDER_HASGETETAG,
            "RenderRequestWrapper has a getETag()  method");
      tcd.put(V2SIGTESTSWRAPPER_RENDERREQUESTWRAPPER_SIGRENDER_HASGETETAGRETURNS,
            "RenderRequestWrapper method getETag() returns String");
      tcd.put(V2SIGTESTSWRAPPER_RENDERREQUESTWRAPPER_SIGRENDER_HASGETREQUEST,
            "RenderRequestWrapper has a getRequest()  method");
      tcd.put(V2SIGTESTSWRAPPER_RENDERREQUESTWRAPPER_SIGRENDER_HASGETREQUESTA,
            "RenderRequestWrapper has a getRequest()  method");
      tcd.put(V2SIGTESTSWRAPPER_RENDERREQUESTWRAPPER_SIGRENDER_HASGETREQUESTRETURNS,
            "RenderRequestWrapper method getRequest() returns RenderRequest");
      tcd.put(V2SIGTESTSWRAPPER_RENDERREQUESTWRAPPER_SIGRENDER_HASGETREQUESTRETURNSA,
            "RenderRequestWrapper method getRequest() returns PortletRequest");
      tcd.put(V2SIGTESTSWRAPPER_RENDERREQUESTWRAPPER_SIGRENDER_HASSETREQUEST,
            "RenderRequestWrapper has a setRequest(RenderRequest)  method");
      tcd.put(V2SIGTESTSWRAPPER_RENDERREQUESTWRAPPER_SIGRENDER_HASSETREQUESTRETURNS,
            "RenderRequestWrapper method setRequest(RenderRequest) returns void");
      tcd.put(V2SIGTESTSWRAPPER_RENDERREQUESTWRAPPER_SIGRENDER_IMPLEMENTSRENDERREQUEST,
            "RenderRequestWrapper implements RenderRequest");
      tcd.put(V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_CONSTRUCTOR,
            "RenderResponseWrapper provides constructor RenderResponseWrapper(RenderResponse) ");
      tcd.put(V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_EXTENDSPORTLETRESPONSEWRAPPER,
            "RenderResponseWrapper extends PortletResponseWrapper");
      tcd.put(V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASCREATEACTIONURL,
            "RenderResponseWrapper has a createActionURL() throws IllegalStateException method");
      tcd.put(V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASCREATEACTIONURLRETURNS,
            "RenderResponseWrapper method createActionURL() returns PortletURL");
      tcd.put(V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASCREATERENDERURL,
            "RenderResponseWrapper has a createRenderURL() throws IllegalStateException method");
      tcd.put(V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASCREATERENDERURLRETURNS,
            "RenderResponseWrapper method createRenderURL() returns PortletURL");
      tcd.put(V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASCREATERESOURCEURL,
            "RenderResponseWrapper has a createResourceURL() throws IllegalStateException method");
      tcd.put(V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASCREATERESOURCEURLRETURNS,
            "RenderResponseWrapper method createResourceURL() returns ResourceURL");
      tcd.put(V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASFLUSHBUFFER,
            "RenderResponseWrapper has a flushBuffer() throws java.io.IOException method");
      tcd.put(V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASFLUSHBUFFERRETURNS,
            "RenderResponseWrapper method flushBuffer() returns void");
      tcd.put(V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETBUFFERSIZE,
            "RenderResponseWrapper has a getBufferSize()  method");
      tcd.put(V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETBUFFERSIZERETURNS,
            "RenderResponseWrapper method getBufferSize() returns int");
      tcd.put(V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETCACHECONTROL,
            "RenderResponseWrapper has a getCacheControl()  method");
      tcd.put(V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETCACHECONTROLRETURNS,
            "RenderResponseWrapper method getCacheControl() returns CacheControl");
      tcd.put(V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETCHARACTERENCODING,
            "RenderResponseWrapper has a getCharacterEncoding()  method");
      tcd.put(V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETCHARACTERENCODINGRETURNS,
            "RenderResponseWrapper method getCharacterEncoding() returns String");
      tcd.put(V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETCONTENTTYPE,
            "RenderResponseWrapper has a getContentType()  method");
      tcd.put(V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETCONTENTTYPERETURNS,
            "RenderResponseWrapper method getContentType() returns String");
      tcd.put(V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETLOCALE,
            "RenderResponseWrapper has a getLocale()  method");
      tcd.put(V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETLOCALERETURNS,
            "RenderResponseWrapper method getLocale() returns java.util.Locale");
      tcd.put(V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETPORTLETOUTPUTSTREAM,
            "RenderResponseWrapper has a getPortletOutputStream() throws java.io.IOException method");
      tcd.put(V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETPORTLETOUTPUTSTREAMRETURNS,
            "RenderResponseWrapper method getPortletOutputStream() returns java.io.OutputStream");
      tcd.put(V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETRESPONSE,
            "RenderResponseWrapper has a getResponse()  method");
      tcd.put(V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETRESPONSEA,
            "RenderResponseWrapper has a getResponse()  method");
      tcd.put(V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETRESPONSERETURNS,
            "RenderResponseWrapper method getResponse() returns RenderResponse");
      tcd.put(V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETRESPONSERETURNSA,
            "RenderResponseWrapper method getResponse() returns PortletResponse");
      tcd.put(V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETWRITER,
            "RenderResponseWrapper has a getWriter() throws java.io.IOException method");
      tcd.put(V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASGETWRITERRETURNS,
            "RenderResponseWrapper method getWriter() returns java.io.PrintWriter");
      tcd.put(V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASISCOMMITTED,
            "RenderResponseWrapper has a isCommitted()  method");
      tcd.put(V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASISCOMMITTEDRETURNS,
            "RenderResponseWrapper method isCommitted() returns boolean");
      tcd.put(V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASRESET,
            "RenderResponseWrapper has a reset()  method");
      tcd.put(V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASRESETBUFFER,
            "RenderResponseWrapper has a resetBuffer()  method");
      tcd.put(V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASRESETBUFFERRETURNS,
            "RenderResponseWrapper method resetBuffer() returns void");
      tcd.put(V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASRESETRETURNS,
            "RenderResponseWrapper method reset() returns void");
      tcd.put(V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASSETBUFFERSIZE,
            "RenderResponseWrapper has a setBufferSize(int)  method");
      tcd.put(V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASSETBUFFERSIZERETURNS,
            "RenderResponseWrapper method setBufferSize(int) returns void");
      tcd.put(V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASSETCONTENTTYPE,
            "RenderResponseWrapper has a setContentType(String)  method");
      tcd.put(V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASSETCONTENTTYPERETURNS,
            "RenderResponseWrapper method setContentType(String) returns void");
      tcd.put(V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASSETNEXTPOSSIBLEPORTLETMODES,
            "RenderResponseWrapper has a setNextPossiblePortletModes(java.util.Collection)  method");
      tcd.put(V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASSETNEXTPOSSIBLEPORTLETMODESRETURNS,
            "RenderResponseWrapper method setNextPossiblePortletModes(java.util.Collection) returns void");
      tcd.put(V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASSETRESPONSE,
            "RenderResponseWrapper has a setResponse(RenderResponse)  method");
      tcd.put(V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASSETRESPONSERETURNS,
            "RenderResponseWrapper method setResponse(RenderResponse) returns void");
      tcd.put(V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASSETTITLE,
            "RenderResponseWrapper has a setTitle(String)  method");
      tcd.put(V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_HASSETTITLERETURNS,
            "RenderResponseWrapper method setTitle(String) returns void");
      tcd.put(V2SIGTESTSWRAPPER_RENDERRESPONSEWRAPPER_SIGRENDER_IMPLEMENTSRENDERRESPONSE,
            "RenderResponseWrapper implements RenderResponse");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_CONSTRUCTOR,
            "ResourceRequestWrapper provides constructor ResourceRequestWrapper(ResourceRequest) ");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_EXTENDSPORTLETREQUESTWRAPPER,
            "ResourceRequestWrapper extends PortletRequestWrapper");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETCACHEABILITY,
            "ResourceRequestWrapper has a getCacheability()  method");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETCACHEABILITYRETURNS,
            "ResourceRequestWrapper method getCacheability() returns String");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETCHARACTERENCODING,
            "ResourceRequestWrapper has a getCharacterEncoding()  method");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETCHARACTERENCODINGRETURNS,
            "ResourceRequestWrapper method getCharacterEncoding() returns String");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETCONTENTLENGTH,
            "ResourceRequestWrapper has a getContentLength()  method");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETCONTENTLENGTHRETURNS,
            "ResourceRequestWrapper method getContentLength() returns int");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETCONTENTTYPE,
            "ResourceRequestWrapper has a getContentType()  method");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETCONTENTTYPERETURNS,
            "ResourceRequestWrapper method getContentType() returns String");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETETAG,
            "ResourceRequestWrapper has a getETag()  method");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETETAGRETURNS,
            "ResourceRequestWrapper method getETag() returns String");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETMETHOD,
            "ResourceRequestWrapper has a getMethod()  method");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETMETHODRETURNS,
            "ResourceRequestWrapper method getMethod() returns String");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETPORTLETINPUTSTREAM,
            "ResourceRequestWrapper has a getPortletInputStream() throws java.io.IOException method");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETPORTLETINPUTSTREAMRETURNS,
            "ResourceRequestWrapper method getPortletInputStream() returns java.io.InputStream");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETPRIVATERENDERPARAMETERMAP,
            "ResourceRequestWrapper has a getPrivateRenderParameterMap()  method");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETPRIVATERENDERPARAMETERMAPRETURNS,
            "ResourceRequestWrapper method getPrivateRenderParameterMap() returns java.util.Map");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETREADER,
            "ResourceRequestWrapper has a getReader() throws java.io.UnsupportedEncodingException, java.io.IOException method");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETREADERRETURNS,
            "ResourceRequestWrapper method getReader() returns java.io.BufferedReader");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETREQUEST,
            "ResourceRequestWrapper has a getRequest()  method");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETREQUESTA,
            "ResourceRequestWrapper has a getRequest()  method");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETREQUESTRETURNS,
            "ResourceRequestWrapper method getRequest() returns ResourceRequest");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETREQUESTRETURNSA,
            "ResourceRequestWrapper method getRequest() returns PortletRequest");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETRESOURCEID,
            "ResourceRequestWrapper has a getResourceID()  method");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASGETRESOURCEIDRETURNS,
            "ResourceRequestWrapper method getResourceID() returns String");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASSETCHARACTERENCODING,
            "ResourceRequestWrapper has a setCharacterEncoding(String) throws java.io.UnsupportedEncodingException method");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASSETCHARACTERENCODINGRETURNS,
            "ResourceRequestWrapper method setCharacterEncoding(String) returns void");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASSETREQUEST,
            "ResourceRequestWrapper has a setRequest(ResourceRequest)  method");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_HASSETREQUESTRETURNS,
            "ResourceRequestWrapper method setRequest(ResourceRequest) returns void");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCEREQUESTWRAPPER_SIGRENDER_IMPLEMENTSRESOURCEREQUEST,
            "ResourceRequestWrapper implements ResourceRequest");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_CONSTRUCTOR,
            "ResourceResponseWrapper provides constructor ResourceResponseWrapper(ResourceResponse) ");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_EXTENDSPORTLETRESPONSEWRAPPER,
            "ResourceResponseWrapper extends PortletResponseWrapper");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASCREATEACTIONURL,
            "ResourceResponseWrapper has a createActionURL() throws IllegalStateException method");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASCREATEACTIONURLRETURNS,
            "ResourceResponseWrapper method createActionURL() returns PortletURL");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASCREATERENDERURL,
            "ResourceResponseWrapper has a createRenderURL() throws IllegalStateException method");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASCREATERENDERURLRETURNS,
            "ResourceResponseWrapper method createRenderURL() returns PortletURL");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASCREATERESOURCEURL,
            "ResourceResponseWrapper has a createResourceURL() throws IllegalStateException method");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASCREATERESOURCEURLRETURNS,
            "ResourceResponseWrapper method createResourceURL() returns ResourceURL");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASFLUSHBUFFER,
            "ResourceResponseWrapper has a flushBuffer() throws java.io.IOException method");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASFLUSHBUFFERRETURNS,
            "ResourceResponseWrapper method flushBuffer() returns void");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASGETBUFFERSIZE,
            "ResourceResponseWrapper has a getBufferSize()  method");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASGETBUFFERSIZERETURNS,
            "ResourceResponseWrapper method getBufferSize() returns int");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASGETCACHECONTROL,
            "ResourceResponseWrapper has a getCacheControl()  method");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASGETCACHECONTROLRETURNS,
            "ResourceResponseWrapper method getCacheControl() returns CacheControl");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASGETCHARACTERENCODING,
            "ResourceResponseWrapper has a getCharacterEncoding()  method");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASGETCHARACTERENCODINGRETURNS,
            "ResourceResponseWrapper method getCharacterEncoding() returns String");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASGETCONTENTTYPE,
            "ResourceResponseWrapper has a getContentType()  method");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASGETCONTENTTYPERETURNS,
            "ResourceResponseWrapper method getContentType() returns String");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASGETLOCALE,
            "ResourceResponseWrapper has a getLocale()  method");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASGETLOCALERETURNS,
            "ResourceResponseWrapper method getLocale() returns java.util.Locale");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASGETPORTLETOUTPUTSTREAM,
            "ResourceResponseWrapper has a getPortletOutputStream() throws java.io.IOException method");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASGETPORTLETOUTPUTSTREAMRETURNS,
            "ResourceResponseWrapper method getPortletOutputStream() returns java.io.OutputStream");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASGETRESPONSE,
            "ResourceResponseWrapper has a getResponse()  method");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASGETRESPONSEA,
            "ResourceResponseWrapper has a getResponse()  method");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASGETRESPONSERETURNS,
            "ResourceResponseWrapper method getResponse() returns ResourceResponse");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASGETRESPONSERETURNSA,
            "ResourceResponseWrapper method getResponse() returns PortletResponse");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASGETWRITER,
            "ResourceResponseWrapper has a getWriter() throws java.io.IOException method");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASGETWRITERRETURNS,
            "ResourceResponseWrapper method getWriter() returns java.io.PrintWriter");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASISCOMMITTED,
            "ResourceResponseWrapper has a isCommitted()  method");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASISCOMMITTEDRETURNS,
            "ResourceResponseWrapper method isCommitted() returns boolean");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASRESET,
            "ResourceResponseWrapper has a reset()  method");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASRESETBUFFER,
            "ResourceResponseWrapper has a resetBuffer()  method");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASRESETBUFFERRETURNS,
            "ResourceResponseWrapper method resetBuffer() returns void");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASRESETRETURNS,
            "ResourceResponseWrapper method reset() returns void");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASSETBUFFERSIZE,
            "ResourceResponseWrapper has a setBufferSize(int)  method");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASSETBUFFERSIZERETURNS,
            "ResourceResponseWrapper method setBufferSize(int) returns void");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASSETCHARACTERENCODING,
            "ResourceResponseWrapper has a setCharacterEncoding(String)  method");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASSETCHARACTERENCODINGRETURNS,
            "ResourceResponseWrapper method setCharacterEncoding(String) returns void");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASSETCONTENTLENGTH,
            "ResourceResponseWrapper has a setContentLength(int)  method");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASSETCONTENTLENGTHRETURNS,
            "ResourceResponseWrapper method setContentLength(int) returns void");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASSETCONTENTTYPE,
            "ResourceResponseWrapper has a setContentType(String)  method");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASSETCONTENTTYPERETURNS,
            "ResourceResponseWrapper method setContentType(String) returns void");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASSETLOCALE,
            "ResourceResponseWrapper has a setLocale(java.util.Locale)  method");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASSETLOCALERETURNS,
            "ResourceResponseWrapper method setLocale(java.util.Locale) returns void");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASSETRESPONSE,
            "ResourceResponseWrapper has a setResponse(ResourceResponse)  method");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_HASSETRESPONSERETURNS,
            "ResourceResponseWrapper method setResponse(ResourceResponse) returns void");
      tcd.put(V2SIGTESTSWRAPPER_RESOURCERESPONSEWRAPPER_SIGRENDER_IMPLEMENTSRESOURCERESPONSE,
            "ResourceResponseWrapper implements ResourceResponse");

   }

   /**
    * Constructor.
    * 
    * Passes the static test case names - details map to the superclass
    * 
    * Note that the backing map is static and not threadsafe. Operations that change the map such as put, remove, etc.,
    * should not be used in portlets.
    */
   public JSR286SignatureTestCaseDetails() {
      super(tcd);
   }

}
