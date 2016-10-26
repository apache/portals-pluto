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

   public final static String V3HEADERPORTLETTESTS_SPEC3_6_4_HEADERPORTLET_RENDERHEADERS = "V3HeaderPortletTests_SPEC3_6_4_HeaderPortlet_renderHeaders";
   public final static String V3HEADERPORTLETTESTS_SPEC3_6_4_HEADERPORTLET_RENDERHEADERS2 = "V3HeaderPortletTests_SPEC3_6_4_HeaderPortlet_renderHeaders2";
   public final static String V3HEADERPORTLETTESTS_SPEC7_14_RENDERREQUEST_GETETAG = "V3HeaderPortletTests_SPEC7_14_RenderRequest_getETag";
   public final static String V3HEADERPORTLETTESTS_SPEC14_HEADERATTR_ATTRIBUTES1 = "V3HeaderPortletTests_SPEC14_HeaderAttr_attributes1";
   public final static String V3HEADERPORTLETTESTS_SPEC14_HEADERATTR_ATTRIBUTES2 = "V3HeaderPortletTests_SPEC14_HeaderAttr_attributes2";
   public final static String V3HEADERPORTLETTESTS_SPEC14_HEADERATTR_ATTRIBUTES3 = "V3HeaderPortletTests_SPEC14_HeaderAttr_attributes3";
   public final static String V3HEADERPORTLETTESTS_SPEC14_HEADERREQ_CONTENTTYPE1 = "V3HeaderPortletTests_SPEC14_HeaderReq_contentType1";
   public final static String V3HEADERPORTLETTESTS_SPEC14_HEADERREQ_CONTENTTYPE2 = "V3HeaderPortletTests_SPEC14_HeaderReq_contentType2";
   public final static String V3HEADERPORTLETTESTS_SPEC14_HEADERREQ_CONTENTTYPE3 = "V3HeaderPortletTests_SPEC14_HeaderReq_contentType3";
   public final static String V3HEADERPORTLETTESTS_SPEC14_HEADERREQ_CONTENTTYPE4 = "V3HeaderPortletTests_SPEC14_HeaderReq_contentType4";
   public final static String V3HEADERPORTLETTESTS_SPEC14_HEADERREQ_CONTENTTYPE5 = "V3HeaderPortletTests_SPEC14_HeaderReq_contentType5";
   public final static String V3HEADERPORTLETTESTS_SPEC14_HEADERREQ_WINDOWID1 = "V3HeaderPortletTests_SPEC14_HeaderReq_windowId1";
   public final static String V3HEADERPORTLETTESTS_SPEC14_HEADERREQ_WINDOWID4 = "V3HeaderPortletTests_SPEC14_HeaderReq_windowId4";
   public final static String V3HEADERPORTLETTESTS_SPEC14_HEADERREQ_CONTENTTYPE10 = "V3HeaderPortletTests_SPEC14_HeaderReq_contentType10";
   public final static String V3HEADERPORTLETTESTS_SPEC14_HEADERREQ_CONTENTTYPE11 = "V3HeaderPortletTests_SPEC14_HeaderReq_contentType11";
   public final static String V3HEADERPORTLETTESTS_SPEC14_HEADERREQ_CONTENTTYPE13 = "V3HeaderPortletTests_SPEC14_HeaderReq_contentType13";
   public final static String V3HEADERPORTLETTESTS_SPEC14_RENDERSTATE_APIHEADER_GETPORTLETMODE = "V3HeaderPortletTests_SPEC14_RenderState_ApiHeader_getPortletMode";
   public final static String V3HEADERPORTLETTESTS_SPEC14_RENDERSTATE_APIHEADER_GETWINDOWSTATE = "V3HeaderPortletTests_SPEC14_RenderState_ApiHeader_getWindowState";
   public final static String V3HEADERPORTLETTESTS_SPEC14_RENDERSTATE_APIHEADER_GETRENDERPARAMETERS = "V3HeaderPortletTests_SPEC14_RenderState_ApiHeader_getRenderParameters";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDUSER_INFO = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_fieldUSER_INFO";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDCCPP_PROFILE = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_fieldCCPP_PROFILE";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDBASIC_AUTH = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_fieldBASIC_AUTH";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDFORM_AUTH = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_fieldFORM_AUTH";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDCLIENT_CERT_AUTH = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_fieldCLIENT_CERT_AUTH";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDDIGEST_AUTH = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_fieldDIGEST_AUTH";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDACTION_PHASE = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_fieldACTION_PHASE";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDEVENT_PHASE = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_fieldEVENT_PHASE";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDRENDER_PHASE = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_fieldRENDER_PHASE";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDRESOURCE_PHASE = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_fieldRESOURCE_PHASE";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDHEADER_PHASE = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_fieldHEADER_PHASE";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDLIFECYCLE_PHASE = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_fieldLIFECYCLE_PHASE";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDRENDER_PART = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_fieldRENDER_PART";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDRENDER_HEADERS = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_fieldRENDER_HEADERS";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDRENDER_MARKUP = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_fieldRENDER_MARKUP";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDACTION_SCOPE_ID = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_fieldACTION_SCOPE_ID";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_ISWINDOWSTATEALLOWED1 = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_isWindowStateAllowed1";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_ISWINDOWSTATEALLOWED2 = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_isWindowStateAllowed2";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_ISPORTLETMODEALLOWED1 = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_isPortletModeAllowed1";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_ISPORTLETMODEALLOWED2 = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_isPortletModeAllowed2";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPREFERENCES = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getPreferences";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPORTLETSESSIONA1 = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getPortletSessionA1";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPORTLETSESSIONA2 = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getPortletSessionA2";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPORTLETSESSIONB1 = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getPortletSessionB1";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPORTLETSESSIONB2 = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getPortletSessionB2";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPORTLETSESSIONB3 = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getPortletSessionB3";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPORTLETSESSIONB4 = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getPortletSessionB4";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPROPERTY1 = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getProperty1";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPROPERTY2 = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getProperty2";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPROPERTY3 = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getProperty3";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPROPERTIES1 = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getProperties1";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPROPERTIES2 = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getProperties2";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPROPERTIES3 = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getProperties3";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPROPERTYNAMES1 = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getPropertyNames1";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPROPERTYNAMES2 = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getPropertyNames2";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPORTALCONTEXT = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getPortalContext";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETAUTHTYPE1 = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getAuthType1";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETAUTHTYPE2 = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getAuthType2";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETCONTEXTPATH1 = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getContextPath1";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETCONTEXTPATH2 = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getContextPath2";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETCONTEXTPATH3 = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getContextPath3";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETREMOTEUSER1 = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getRemoteUser1";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETREMOTEUSER2 = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getRemoteUser2";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETUSERPRINCIPAL1 = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getUserPrincipal1";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETUSERPRINCIPAL2 = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getUserPrincipal2";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_ISUSERINROLE1 = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_isUserInRole1";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_ISUSERINROLE2 = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_isUserInRole2";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_ISUSERINROLE3 = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_isUserInRole3";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETATTRIBUTE1 = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getAttribute1";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETATTRIBUTE2 = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getAttribute2";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETATTRIBUTE3 = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getAttribute3";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETATTRIBUTENAMES1 = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getAttributeNames1";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETATTRIBUTENAMES2 = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getAttributeNames2";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETER1 = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getParameter1";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETER2 = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getParameter2";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETER3 = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getParameter3";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETER4 = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getParameter4";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETER5 = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getParameter5";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETERNAMES1 = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getParameterNames1";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETERNAMES2 = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getParameterNames2";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETERVALUES1 = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getParameterValues1";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETERVALUES2 = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getParameterValues2";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETERVALUES3 = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getParameterValues3";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETERVALUES4 = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getParameterValues4";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETERMAP1 = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getParameterMap1";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETERMAP2 = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getParameterMap2";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETERMAP3 = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getParameterMap3";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_ISSECURE1 = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_isSecure1";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_ISSECURE2 = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_isSecure2";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_SETATTRIBUTE1 = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_setAttribute1";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_SETATTRIBUTE2 = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_setAttribute2";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_SETATTRIBUTE3 = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_setAttribute3";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_REMOVEATTRIBUTE1 = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_removeAttribute1";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_REMOVEATTRIBUTE2 = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_removeAttribute2";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETREQUESTEDSESSIONID1 = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getRequestedSessionId1";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETREQUESTEDSESSIONID2 = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getRequestedSessionId2";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_ISREQUESTEDSESSIONIDVALID1 = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_isRequestedSessionIdValid1";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_ISREQUESTEDSESSIONIDVALID2 = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_isRequestedSessionIdValid2";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETRESPONSECONTENTTYPE1 = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getResponseContentType1";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETRESPONSECONTENTTYPES1 = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getResponseContentTypes1";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETLOCALE = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getLocale";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETLOCALES = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getLocales";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETSCHEME = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getScheme";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETSERVERNAME = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getServerName";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETSERVERPORT = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getServerPort";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETWINDOWID = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getWindowID";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETCOOKIES1 = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getCookies1";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETCOOKIES2 = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getCookies2";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPRIVATEPARAMETERMAP1 = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getPrivateParameterMap1";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPRIVATEPARAMETERMAP2 = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getPrivateParameterMap2";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPRIVATEPARAMETERMAP3 = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getPrivateParameterMap3";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPUBLICPARAMETERMAP1 = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getPublicParameterMap1";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPUBLICPARAMETERMAP2 = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getPublicParameterMap2";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPUBLICPARAMETERMAP3 = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getPublicParameterMap3";
   public final static String V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_EXISTS = "V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_exists";
   public final static String V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_ADDPROPERTYA2 = "V3HeaderPortletTests_SPEC15_PortletResponse_ApiHeader_addPropertyA2";
   public final static String V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_ADDPROPERTYB1 = "V3HeaderPortletTests_SPEC15_PortletResponse_ApiHeader_addPropertyB1";
   public final static String V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_ADDPROPERTYB2 = "V3HeaderPortletTests_SPEC15_PortletResponse_ApiHeader_addPropertyB2";
   public final static String V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_ADDPROPERTYB4 = "V3HeaderPortletTests_SPEC15_PortletResponse_ApiHeader_addPropertyB4";
   public final static String V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_ADDPROPERTYC1 = "V3HeaderPortletTests_SPEC15_PortletResponse_ApiHeader_addPropertyC1";
   public final static String V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_ADDPROPERTYC2 = "V3HeaderPortletTests_SPEC15_PortletResponse_ApiHeader_addPropertyC2";
   public final static String V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_SETPROPERTY1 = "V3HeaderPortletTests_SPEC15_PortletResponse_ApiHeader_setProperty1";
   public final static String V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_SETPROPERTY2 = "V3HeaderPortletTests_SPEC15_PortletResponse_ApiHeader_setProperty2";
   public final static String V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_ENCODEURL1 = "V3HeaderPortletTests_SPEC15_PortletResponse_ApiHeader_encodeURL1";
   public final static String V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_ENCODEURL2 = "V3HeaderPortletTests_SPEC15_PortletResponse_ApiHeader_encodeURL2";
   public final static String V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_GETNAMESPACE1 = "V3HeaderPortletTests_SPEC15_PortletResponse_ApiHeader_getNamespace1";
   public final static String V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_CREATEELEMENT1 = "V3HeaderPortletTests_SPEC15_PortletResponse_ApiHeader_createElement1";
   public final static String V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_CREATEELEMENT2 = "V3HeaderPortletTests_SPEC15_PortletResponse_ApiHeader_createElement2";
   public final static String V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_CREATEELEMENT3 = "V3HeaderPortletTests_SPEC15_PortletResponse_ApiHeader_createElement3";
   public final static String V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_CREATEELEMENT4 = "V3HeaderPortletTests_SPEC15_PortletResponse_ApiHeader_createElement4";
   public final static String V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_CREATEELEMENT5 = "V3HeaderPortletTests_SPEC15_PortletResponse_ApiHeader_createElement5";
   public final static String V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_CREATEELEMENT6 = "V3HeaderPortletTests_SPEC15_PortletResponse_ApiHeader_createElement6";
   public final static String V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_FIELDEXPIRATION_CACHE  = "V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_fieldEXPIRATION_CACHE";
   public final static String V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_FIELDCACHE_SCOPE  = "V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_fieldCACHE_SCOPE";
   public final static String V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_FIELDPUBLIC_SCOPE  = "V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_fieldPUBLIC_SCOPE";
   public final static String V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_FIELDPRIVATE_SCOPE  = "V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_fieldPRIVATE_SCOPE";
   public final static String V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_FIELDETAG  = "V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_fieldETAG";
   public final static String V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_FIELDUSE_CACHED_CONTENT  = "V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_fieldUSE_CACHED_CONTENT";
   public final static String V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_FIELDNAMESPACED_RESPONSE = "V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_fieldNAMESPACED_RESPONSE";
   public final static String V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_FIELDMARKUP_HEAD_ELEMENT = "V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_fieldMARKUP_HEAD_ELEMENT";
   public final static String V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_GETCONTENTTYPE1 = "V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_getContentType1";
   public final static String V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_GETCONTENTTYPE2 = "V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_getContentType2";
   public final static String V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_SETCONTENTTYPE1 = "V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_setContentType1";
   public final static String V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_SETCONTENTTYPE4 = "V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_setContentType4";
   public final static String V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_GETCHARACTERENCODING = "V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_getCharacterEncoding";
   public final static String V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_GETWRITER1 = "V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_getWriter1";
   public final static String V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_GETWRITER2 = "V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_getWriter2";
   public final static String V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_GETLOCALE = "V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_getLocale";
   public final static String V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_SETBUFFERSIZE1 = "V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_setBufferSize1";
   public final static String V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_SETBUFFERSIZE2 = "V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_setBufferSize2";
   public final static String V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_GETBUFFERSIZE1 = "V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_getBufferSize1";
   public final static String V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_GETBUFFERSIZE2 = "V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_getBufferSize2";
   public final static String V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_FLUSHBUFFER1 = "V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_flushBuffer1";
   public final static String V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_RESETBUFFER1 = "V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_resetBuffer1";
   public final static String V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_RESETBUFFER2 = "V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_resetBuffer2";
   public final static String V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_ISCOMMITTED1 = "V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_isCommitted1";
   public final static String V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_ISCOMMITTED2 = "V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_isCommitted2";
   public final static String V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_RESET1 = "V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_reset1";
   public final static String V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_RESET2 = "V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_reset2";
   public final static String V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_GETPORTLETOUTPUTSTREAM1 = "V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_getPortletOutputStream1";
   public final static String V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_GETPORTLETOUTPUTSTREAM2 = "V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_getPortletOutputStream2";
   public final static String V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_CREATERENDERURL = "V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_createRenderURL";
   public final static String V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_CREATEACTIONURL = "V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_createActionURL";
   public final static String V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_CREATERESOURCEURL = "V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_createResourceURL";
   public final static String V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_GETCACHECONTROL = "V3HeaderPortletTests_SPEC15_MimeResponse_ApiHeader_getCacheControl";
   public final static String V3HEADERPORTLETTESTS_SPEC15_HEADER_PARAMETERS10 = "V3HeaderPortletTests_SPEC15_Header_parameters10";
   public final static String V3HEADERPORTLETTESTS_SPEC15_HEADER_PARAMETERS13 = "V3HeaderPortletTests_SPEC15_Header_parameters13";
   public final static String V3HEADERPORTLETTESTS_SPEC15_HEADER_PARAMETERS15 = "V3HeaderPortletTests_SPEC15_Header_parameters15";
   public final static String V3HEADERPORTLETTESTS_SPEC15_HEADER_PROPERTIES1 = "V3HeaderPortletTests_SPEC15_Header_properties1";
   public final static String V3HEADERPORTLETTESTS_SPEC15_HEADER_PROPERTIES2 = "V3HeaderPortletTests_SPEC15_Header_properties2";
   public final static String V3HEADERPORTLETTESTS_SPEC15_HEADER_PROPERTIES3 = "V3HeaderPortletTests_SPEC15_Header_properties3";
   public final static String V3HEADERPORTLETTESTS_SPEC15_HEADER_PROPERTIES4 = "V3HeaderPortletTests_SPEC15_Header_properties4";
   public final static String V3HEADERPORTLETTESTS_SPEC15_HEADER_PARAMETERS2 = "V3HeaderPortletTests_SPEC15_Header_parameters2";
   public final static String V3HEADERPORTLETTESTS_SPEC15_HEADER_PARAMETERS6 = "V3HeaderPortletTests_SPEC15_Header_parameters6";
   public final static String V3HEADERPORTLETTESTS_SPEC15_HEADER_PUBLICRENDERPARAMETERS15 = "V3HeaderPortletTests_SPEC15_Header_publicRenderParameters15";
   public final static String V3HEADERPORTLETTESTS_SPEC15_HEADER_PUBLICRENDERPARAMETERS16 = "V3HeaderPortletTests_SPEC15_Header_publicRenderParameters16";
   public final static String V3HEADERPORTLETTESTS_SPEC15_HEADER_PUBLICRENDERPARAMETERS13A = "V3HeaderPortletTests_SPEC15_Header_publicRenderParameters13a";
   public final static String V3HEADERPORTLETTESTS_SPEC15_HEADER_COOKIE8 = "V3HeaderPortletTests_SPEC15_Header_cookie8";
   public final static String V3HEADERPORTLETTESTS_SPEC15_HEADER_COOKIE9 = "V3HeaderPortletTests_SPEC15_Header_cookie9";
   public final static String V3HEADERPORTLETTESTS_SPEC15_HEADER_COOKIE10 = "V3HeaderPortletTests_SPEC15_Header_cookie10";
   public final static String V3HEADERPORTLETTESTS_SPEC15_HEADER_COOKIE11 = "V3HeaderPortletTests_SPEC15_Header_cookie11";
   public final static String V3HEADERPORTLETTESTS_SPEC15_HEADER_CONTENTTYPE5 = "V3HeaderPortletTests_SPEC15_Header_contentType5";
   public final static String V3HEADERPORTLETTESTS_SPEC15_HEADER_CHARACTERENCODING4 = "V3HeaderPortletTests_SPEC15_Header_characterEncoding4";
   public final static String V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_SETTITLE = "V3HeaderPortletTests_SPEC15_HeaderResponse_setTitle";
   public final static String V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_SETTITLE2 = "V3HeaderPortletTests_SPEC15_HeaderResponse_setTitle2";
   public final static String V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_SETTITLE3 = "V3HeaderPortletTests_SPEC15_HeaderResponse_setTitle3";
   public final static String V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_GETWRITER = "V3HeaderPortletTests_SPEC15_HeaderResponse_getWriter";
   public final static String V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_GETPORTLETOUTPUTSTREAM = "V3HeaderPortletTests_SPEC15_HeaderResponse_getPortletOutputStream";
   public final static String V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_ADDDEPENDENCY = "V3HeaderPortletTests_SPEC15_HeaderResponse_addDependency";
   public final static String V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_ADDDEPENDENCY2 = "V3HeaderPortletTests_SPEC15_HeaderResponse_addDependency2";
   public final static String V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_ADDDEPENDENCY3 = "V3HeaderPortletTests_SPEC15_HeaderResponse_addDependency3";
   public final static String V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_ADDDEPENDENCY5 = "V3HeaderPortletTests_SPEC15_HeaderResponse_addDependency5";
   public final static String V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_ADDDEPENDENCY6 = "V3HeaderPortletTests_SPEC15_HeaderResponse_addDependency6";
   public final static String V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_ADDDEPENDENCY7 = "V3HeaderPortletTests_SPEC15_HeaderResponse_addDependency7";
   public final static String V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_ADDDEPENDENCY8 = "V3HeaderPortletTests_SPEC15_HeaderResponse_addDependency8";
   public final static String V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_ADDDEPENDENCY10 = "V3HeaderPortletTests_SPEC15_HeaderResponse_addDependency10";
   public final static String V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_ADDDEPENDENCY11 = "V3HeaderPortletTests_SPEC15_HeaderResponse_addDependency11";
   public final static String V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_ADDDEPENDENCY12 = "V3HeaderPortletTests_SPEC15_HeaderResponse_addDependency12";

   
   private final static Map<String, String> tcd = new HashMap<String, String>();
   static {

      tcd.put(V3HEADERPORTLETTESTS_SPEC3_6_4_HEADERPORTLET_RENDERHEADERS, "renderHeaders() method is called before render() method if the portlet implements HeaderPortlet interface.");
      tcd.put(V3HEADERPORTLETTESTS_SPEC3_6_4_HEADERPORTLET_RENDERHEADERS2, "The container runtime option javax.portlet.renderHeaders is disregarded for version 3.0 or later.");
      tcd.put(V3HEADERPORTLETTESTS_SPEC7_14_RENDERREQUEST_GETETAG, "Method getETag(): Returns null if there is no cached response.");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_HEADERATTR_ATTRIBUTES1, "The portlet can access a map with user information attributes via the request attribute PortletRequest.USER_INFO");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_HEADERATTR_ATTRIBUTES2, "The PortletRequest.CCPP_PROFILE request attribute must return a javax.ccpp.Profile based on the current portlet request");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_HEADERATTR_ATTRIBUTES3, "During header processing, the LIFECYCLE_PHASE (\"javax.portlet.lifecycle_phase\") attribute will contain the string \"HEADER_PHASE\"");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_HEADERREQ_CONTENTTYPE1, "The getResponseContentType method returns a String representing the default content type the portlet container assumes for the output");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_HEADERREQ_CONTENTTYPE2, "The getResponseContentTypes method returns an Enumeration of String elements representing the acceptable content types for the output in order of preference");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_HEADERREQ_CONTENTTYPE3, "The first element of the Enumeration returned by the getResponseContentTypes method must equal the value returned by the getResponseContentType method");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_HEADERREQ_CONTENTTYPE4, "If a portlet defines support for all content types using a wildcard and the portlet container supports all content types, the getResponseContentType may return the wildcard");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_HEADERREQ_CONTENTTYPE5, "If a portlet defines support for all content types using a wildcard and the portlet container supports all content types, the getResponseContentType may return the preferred content type");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_HEADERREQ_WINDOWID1, "The getWindowID method returns a String representing the current window ID");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_HEADERREQ_WINDOWID4, "The string returned by getWindowID method must be the same ID used for scoping portlet-scope session attributes");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_HEADERREQ_CONTENTTYPE10, "Within the header method, the content type must include only the MIME type, not the character set");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_HEADERREQ_CONTENTTYPE11, "Within the header method, the getResponseContentTypes method must return only the content types supported by the current portlet mode");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_HEADERREQ_CONTENTTYPE13, "The character set of the response can be retrieved via the HeaderResponse.getCharacterEncoding method");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_RENDERSTATE_APIHEADER_GETPORTLETMODE, "Method getPortletMode(): Returns current PortletMode");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_RENDERSTATE_APIHEADER_GETWINDOWSTATE, "Method getWindowState(): Returns current WindowState");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_RENDERSTATE_APIHEADER_GETRENDERPARAMETERS, "Method getRenderParameters(): Returns an immutable RenderParameters object representing the private and public render parameters");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDUSER_INFO, "Has String field USER_INFO with value of \"javax.portlet.userinfo\" ");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDCCPP_PROFILE, "Has String field CCPP_PROFILE with value of \"javax.portlet.ccpp\" ");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDBASIC_AUTH, "Has String field BASIC_AUTH with value of \"BASIC\" ");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDFORM_AUTH, "Has String field FORM_AUTH with value of \"FORM\" ");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDCLIENT_CERT_AUTH, "Has String field CLIENT_CERT_AUTH with value of \"CLIENT_CERT\" ");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDDIGEST_AUTH, "Has String field DIGEST_AUTH with value of \"DIGEST\" ");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDACTION_PHASE, "Has String field ACTION_PHASE with value of \"ACTION_PHASE\" ");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDEVENT_PHASE, "Has String field EVENT_PHASE with value of \"EVENT_PHASE\" ");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDRENDER_PHASE, "Has String field RENDER_PHASE with value of \"RENDER_PHASE\" ");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDRESOURCE_PHASE, "Has String field RESOURCE_PHASE with value of \"RESOURCE_PHASE\" ");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDHEADER_PHASE, "Has String field HEADER_PHASE with value of \"HEADER_PHASE\" ");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDLIFECYCLE_PHASE, "Has String field LIFECYCLE_PHASE with value of \"javax.portlet.lifecycle_phase\" ");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDRENDER_PART, "Has String field RENDER_PART with value of \"javax.portlet.render_part\" ");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDRENDER_HEADERS, "Has String field RENDER_HEADERS with value of \"RENDER_HEADERS\" ");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDRENDER_MARKUP, "Has String field RENDER_MARKUP with value of \"RENDER_MARKUP\" ");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDACTION_SCOPE_ID, "Has String field ACTION_SCOPE_ID with value of \"javax.portlet.as\" ");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_ISWINDOWSTATEALLOWED1, "Method isWindowStateAllowed(WindowState): Returns true if the specified WindowState is allowed");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_ISWINDOWSTATEALLOWED2, "Method isWindowStateAllowed(WindowState): Returns false if the specified WindowState is not allowed");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_ISPORTLETMODEALLOWED1, "Method isPortletModeAllowed(PortletMode): Returns true if the specified PortletMode is allowed");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_ISPORTLETMODEALLOWED2, "Method isPortletModeAllowed(PortletMode): Returns false if the specified PortletMode is not allowed");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPREFERENCES, "Method getPreferences(): Returns the PortletPreferences object associated with the portlet");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPORTLETSESSIONA1, "Method getPortletSession(): Returns current PortletSession if one already exists");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPORTLETSESSIONA2, "Method getPortletSession(): Returns new PortletSession if one does not already exist");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPORTLETSESSIONB1, "Method getPortletSession(boolean): If input flag is true, returns current PortletSession if one already exists");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPORTLETSESSIONB2, "Method getPortletSession(boolean): If input flag is true, returns new PortletSession if one does not already exist");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPORTLETSESSIONB3, "Method getPortletSession(boolean): If input flag is false, returns current PortletSession if one already exists");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPORTLETSESSIONB4, "Method getPortletSession(boolean): If input flag is false, returns null if one does not already exist");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPROPERTY1, "Method getProperty(String): If specified request property exists, returns its value");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPROPERTY2, "Method getProperty(String): If specified request property does not exist, returns null");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPROPERTY3, "Method getProperty(String): Throws IllegalArgumentException if the name is null");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPROPERTIES1, "Method getProperties(String): If specified request property exists, returns its values as an Enumeration");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPROPERTIES2, "Method getProperties(String): If specified request property does not exist, returns an empty Enumeration");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPROPERTIES3, "Method getProperties(String): Throws IllegalArgumentException if the name is null");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPROPERTYNAMES1, "Method getPropertyNames(): Returns an Enumeration of all request property names");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPROPERTYNAMES2, "Method getPropertyNames(): Returns an empty Enumeration if there are no request properties defined");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPORTALCONTEXT, "Method getPortalContext(): Returns the context of the portal");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETAUTHTYPE1, "Method getAuthType(): Returns a String indicating the authentication type if the request was authenticated");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETAUTHTYPE2, "Method getAuthType(): Returns null if the request was not authenticated");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETCONTEXTPATH1, "Method getContextPath(): Returns a String representing the context path associated with the portlet");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETCONTEXTPATH2, "Method getContextPath(): Returns an empty String if the portlet is deployed in the default context");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETCONTEXTPATH3, "Method getContextPath(): If the context path is not empty, it must start with \"/\" and may not end with \"/\"");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETREMOTEUSER1, "Method getRemoteUser(): Returns a String representing the login of the user if the request is authenticated");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETREMOTEUSER2, "Method getRemoteUser(): Returns null if the request has not been authenticated");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETUSERPRINCIPAL1, "Method getUserPrincipal(): Returns a java.security.Principal object representing the user if the request has been authenticated");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETUSERPRINCIPAL2, "Method getUserPrincipal(): Returns null if the request has not been authenticated");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_ISUSERINROLE1, "Method isUserInRole(): Returns true if the authenticated user is in the specified role");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_ISUSERINROLE2, "Method isUserInRole(): Returns false if the authenticated user is not in the specified role");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_ISUSERINROLE3, "Method isUserInRole(): Returns false if the user is not authenticated");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETATTRIBUTE1, "Method getAttribute(String): Returns a java.lang.Object for the specified attribute name");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETATTRIBUTE2, "Method getAttribute(String): Returns null if no attribute with the specified name exists");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETATTRIBUTE3, "Method getAttribute(String): Throws IllegalArgumentException if the name is null");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETATTRIBUTENAMES1, "Method getAttributeNames(): Returns a java.util.Enumeration&lt;java.lang.String&gt; of the available attribute names");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETATTRIBUTENAMES2, "Method getAttributeNames(): Returns an empty Enumeration if there are no attributes available");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETER1, "Method getParameter(String): Returns String value of parameter specified by the name");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETER2, "Method getParameter(String): Returns String value of a public render parameter specified by the name");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETER3, "Method getParameter(String): Returns null if no parameter exists for the specified name");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETER4, "Method getParameter(String): Returns first String value from values array if use with a multivalued parameter");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETER5, "Method getParameter(String): Throws IllegalArgumentException if the name is null");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETERNAMES1, "Method getParameterNames(): Returns a java.util.Enumeration&lt;java.lang.String&gt; of the available parameter names");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETERNAMES2, "Method getParameterNames(): Returns an empty Enumeration if there are no parameters available");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETERVALUES1, "Method getParameterValues(String): Returns String[] value of parameter specified by the name");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETERVALUES2, "Method getParameterValues(String): Returns String[] value of a public render parameter specified by the name");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETERVALUES3, "Method getParameterValues(String): Returns null if no parameter exists for the specified name");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETERVALUES4, "Method getParameterValues(String): Throws IllegalArgumentException if the name is null");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETERMAP1, "Method getParameterMap(): Returns an java.util.Map&lt;java.lang.String,java.lang.String[]&gt; object for the parameter names and values if parameters are available");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETERMAP2, "Method getParameterMap(): The returned map contains all public and private parameters for the request");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETERMAP3, "Method getParameterMap(): Returns an empty map if no parameters exist");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_ISSECURE1, "Method isSecure(): Returns true if the request was made through a secure channel");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_ISSECURE2, "Method isSecure(): Returns false if the request was not made through a secure channel");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_SETATTRIBUTE1, "Method setAttribute(String, Object): Stores an attribute object under the specified name in the request");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_SETATTRIBUTE2, "Method setAttribute(String, Object): Removes the attribute by the specified name if the object is null");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_SETATTRIBUTE3, "Method setAttribute(String, Object): Throws IllegalArgumentException if the name is null");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_REMOVEATTRIBUTE1, "Method removeAttribute(String): Removes the attribute specified by the name from the request");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_REMOVEATTRIBUTE2, "Method removeAttribute(String): Throws IllegalArgumentException if the name is null");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETREQUESTEDSESSIONID1, "Method getRequestedSessionId(): Returns the session ID indicated in the client request");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETREQUESTEDSESSIONID2, "Method getRequestedSessionId(): Returns null if no session ID was indicated in the client request");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_ISREQUESTEDSESSIONIDVALID1, "Method isRequestedSessionIdValid(): Returns true if the session ID is valid");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_ISREQUESTEDSESSIONIDVALID2, "Method isRequestedSessionIdValid(): Returns false if the session ID is not valid");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETRESPONSECONTENTTYPE1, "Method getResponseContentType(): Returns a String representing the portal preferred content type for the response if the content type is defined in the portlet descriptor  ");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETRESPONSECONTENTTYPES1, "Method getResponseContentTypes(): Returns an java.util.Enumeration&lt;java.lang.String&gt; object representing the portal preferred content types for the response if the content types are defined in the portlet descriptor");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETLOCALE, "Method getLocale(): Returns an java.util.Locale object representing the preferred Locale for the response");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETLOCALES, "Method getLocales(): Returns an java.util.Enumeration&lt;java.util.Locale&gt; of the Locales in which the portal will accept content");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETSCHEME, "Method getScheme(): Returns a String value representing the scheme name for the request");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETSERVERNAME, "Method getServerName(): Returns a String value representing the host name for the request");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETSERVERPORT, "Method getServerPort(): Returns an int value representing the port number for the request");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETWINDOWID, "Method getWindowID(): Returns a String value representing the portlet window ID");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETCOOKIES1, "Method getCookies(): Returns a javax.servlet.http.Cookie[] array containing the cookies for this request");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETCOOKIES2, "Method getCookies(): Returns null if no cookies are present");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPRIVATEPARAMETERMAP1, "Method getPrivateParameterMap(): Returns an java.util.Map&lt;java.lang.String,java.lang.String[]&gt; object for the private parameter names and values if available");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPRIVATEPARAMETERMAP2, "Method getPrivateParameterMap(): The returned map is immutable");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPRIVATEPARAMETERMAP3, "Method getPrivateParameterMap(): Returns an empty map if no private parameters exist");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPUBLICPARAMETERMAP1, "Method getPublicParameterMap(): Returns an java.util.Map&lt;java.lang.String,java.lang.String[]&gt; object for the public parameter names and values if available");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPUBLICPARAMETERMAP2, "Method getPublicParameterMap(): The returned map is immutable");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPUBLICPARAMETERMAP3, "Method getPublicParameterMap(): Returns an empty map if no public parameters exist");
      tcd.put(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_EXISTS, "The P3PUserInfos exists as a public static enum");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_ADDPROPERTYA2, "Method addProperty(javax.servlet.http.Cookie): Throws IllegalArgumentException if the specified cookie is null");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_ADDPROPERTYB1, "Method addProperty(String, org.w3c.dom.Element): Adds an XML DOM Element to the response for the specified key");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_ADDPROPERTYB2, "Method addProperty(String, org.w3c.dom.Element): If a DOM Element for the specified key already exists, the new element is added in addition to the existing element");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_ADDPROPERTYB4, "Method addProperty(String, org.w3c.dom.Element): Throws IllegalArgumentException if the specified key is null");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_ADDPROPERTYC1, "Method addProperty(String, String): Adds a property value to an existing key to allow the key to have multiple values");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_ADDPROPERTYC2, "Method addProperty(String, String): Throws IllegalArgumentException if the specified key is null");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_SETPROPERTY1, "Method setProperty(String, String): Sets a property value for the specified key");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_SETPROPERTY2, "Method setProperty(String, String): Resets any existing property values for the specified key");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_ENCODEURL1, "Method encodeURL(String): Returns a String representing the encoded URL");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_ENCODEURL2, "Method encodeURL(String): Throws IllegalArgumentException if the input string is not an absolute URL and does not start with at \"/\" character");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_GETNAMESPACE1, "Method getNamespace(): Returns a String containing the namespace value");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_CREATEELEMENT1, "Method createElement(String): Returns an org.w3c.dom.Element object for the specified tag name");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_CREATEELEMENT2, "Method createElement(String): The returned Element has nodeName set to the the specified tag name");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_CREATEELEMENT3, "Method createElement(String): The returned Element has localName set to null");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_CREATEELEMENT4, "Method createElement(String): The returned Element has prefix set to null");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_CREATEELEMENT5, "Method createElement(String): The returned Element has namespaceURI set to null");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_PORTLETRESPONSE_APIHEADER_CREATEELEMENT6, "Method createElement(String): Throws org.w3c.dom.DOMException - INVALID_CHARACTER_ERR if the specified name contains an illegal character. ");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_FIELDEXPIRATION_CACHE , "Has String field EXPIRATION_CACHE with value of \"portlet.expiration-cache\"");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_FIELDCACHE_SCOPE , "Has String field CACHE_SCOPE with value of \"portlet.cache-scope\"");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_FIELDPUBLIC_SCOPE , "Has String field PUBLIC_SCOPE with value of \"portlet.public-scope\"");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_FIELDPRIVATE_SCOPE , "Has String field PRIVATE_SCOPE with value of \"portlet.private-scope\"");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_FIELDETAG , "Has String field ETAG with value of \"portlet.ETag\"");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_FIELDUSE_CACHED_CONTENT , "Has String field USE_CACHED_CONTENT with value of \"portlet.use-cached-content\"");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_FIELDNAMESPACED_RESPONSE, "Has String field NAMESPACED_RESPONSE with value of \"X-JAVAX-PORTLET-NAMESPACED-RESPONSE\"");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_FIELDMARKUP_HEAD_ELEMENT, "Has String field MARKUP_HEAD_ELEMENT with value of \"javax.portlet.markup.head.element\"");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_GETCONTENTTYPE1, "Method getContentType(): Returns a String containing the MIME type that can be used with the response");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_GETCONTENTTYPE2, "Method getContentType(): Returns null if no content type is set");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_SETCONTENTTYPE1, "Method setContentType(String): Sets the MIME type for the response");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_SETCONTENTTYPE4, "Method setContentType(String): Throws IllegalArgumentException if the specified MIME type is invalid");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_GETCHARACTERENCODING, "Method getCharacterEncoding(): Returns a String containing the name of the charset used for the response body");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_GETWRITER1, "Method getWriter(): Returns a PrintWriter object");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_GETWRITER2, "Method getWriter(): Throws IllegalStateException if called after the getPortletOutputStream method has been called");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_GETLOCALE, "Method getLocale(): Returns an java.util.Locale representing the locale assigned to the response");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_SETBUFFERSIZE1, "Method setBufferSize(int): Sets the preferred buffer size for the response body");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_SETBUFFERSIZE2, "Method setBufferSize(int): Throws IllegalStateException if called after content has been written");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_GETBUFFERSIZE1, "Method getBufferSize(): Returns an int designating the actual buffer size used for the response");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_GETBUFFERSIZE2, "Method getBufferSize(): Returns null if buffering is not used");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_FLUSHBUFFER1, "Method flushBuffer(): Returns void and flushes buffer to OutputStream");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_RESETBUFFER1, "Method resetBuffer(): Returns void and clears and data and properties from the buffer");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_RESETBUFFER2, "Method resetBuffer(): Throws IllegalStateException if called after the response has been committed");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_ISCOMMITTED1, "Method isCommitted(): Returns true if the response has been committed");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_ISCOMMITTED2, "Method isCommitted(): Returns false if the response has not been committed");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_RESET1, "Method reset(): Returns void and clears and data and properties from the buffer");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_RESET2, "Method reset(): Throws IllegalStateException if called after the response has been committed");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_GETPORTLETOUTPUTSTREAM1, "Method getPortletOutputStream(): Returns a PortletOutputStream object");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_GETPORTLETOUTPUTSTREAM2, "Method getPortletOutputStream(): Throws IllegalStateException if called after the getWriter method has been called");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_CREATERENDERURL, "Method createRenderURL(): Returns a PortletURL object representing a render URL targeting the portlet");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_CREATEACTIONURL, "Method createActionURL(): Returns a PortletURL object representing an action URL targeting the portlet");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_CREATERESOURCEURL, "Method createResourceURL(): Returns a ResourceURL object targeting the portlet");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_MIMERESPONSE_APIHEADER_GETCACHECONTROL, "Method getCacheControl(): Returns a CacheControl object");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_HEADER_PARAMETERS10, "The portlet-container must not propagate parameters received in an action or event request to subsequent header requests of the portlet");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_HEADER_PARAMETERS13, "If a portlet receives a render request that is the result of invoking a render URL targeting this portlet the render parameters received with the render request must be the parameters set on the render URL");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_HEADER_PARAMETERS15, "Render parameters get automatically cleared if the portlet receives a processAction or processEvent call");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_HEADER_PROPERTIES1, "The portlet can use the getProperty method to access single portal property and optionally-available HTTP header values");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_HEADER_PROPERTIES2, "The portlet can use the getProperties method to access multiple portal property and optionally-available HTTP header values by the same property name");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_HEADER_PROPERTIES3, "The portlet can use the getPropertyNames method to obtain an Enumeration of all available property names");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_HEADER_PROPERTIES4, "The portlet can access cookies provided by the current request using the getCookies method");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_HEADER_PARAMETERS2, "The parameters the header object returns must be \"x-www-form-urlencoded\" decoded");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_HEADER_PARAMETERS6, "The getParameterMap method must return an unmodifiable Map object");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_HEADER_PUBLICRENDERPARAMETERS15, "A map of private parameters can be obtained through the getPrivateParameterMap method");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_HEADER_PUBLICRENDERPARAMETERS16, "A map of public parameters can be obtained through the getPublicParameterMap method");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_HEADER_PUBLICRENDERPARAMETERS13A, "A public render parameter can be deleted using the removePublicRenderParameter method on the PortletURL");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_HEADER_COOKIE8, "Cookies set during the Header phase should be available to the portlet during the Resource phase");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_HEADER_COOKIE9, "Cookies set during the Header phase should be available to the portlet during a subsequent Action phase");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_HEADER_COOKIE10, "Cookies set during the Header phase should be available to the portlet during a subsequent Render phase");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_HEADER_COOKIE11, "Cookies set during the Header phase should be available to the portlet during a subsequent request triggered by a URL");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_HEADER_CONTENTTYPE5, "If the setContentType method is not called before the getWriter or getPortletOutputStream method is used, the portlet container uses the content type returned by getResponseContentType");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_HEADER_CHARACTERENCODING4, "If the portlet does not set the character encoding, the portlet container uses UTF-8 as the default character encoding");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_SETTITLE, "This method sets the title of the portlet.");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_SETTITLE2, "An empty string can be set as title of portlet.");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_SETTITLE3, "Setting title as null restores the original title.");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_GETWRITER, "Data written to the HeaderResponse writer is added to the aggregated portal document HEAD section.");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_GETPORTLETOUTPUTSTREAM, "Data written to the HeaderResponse writer is added to the aggregated portal document HEAD section.");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_ADDDEPENDENCY, "Method addDependency(String name, String scope, String version) - Adds a dependency on a page-level resource that is managed by the portal.");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_ADDDEPENDENCY2, "Method addDependency(String name, String scope, String version) - The dependency added by this method can be shared with other portlets.");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_ADDDEPENDENCY3, "Method addDependency(String name, String scope, String version) - The dependency added dynamically through this method is added to the statically declared dependencies for the portlet for the current rendering cycle only.");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_ADDDEPENDENCY5, "Method addDependency(String name, String scope, String version) - Throws IllegalArgumentException - if name is null.");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_ADDDEPENDENCY6, "Method addDependency(String name, String scope, String version) - Throws IllegalArgumentException - if name is empty.");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_ADDDEPENDENCY7, "Method addDependency(String name, String scope, String version, String markup) - Adds a dependency on a page-level resource that is managed by the portal and adds a resource for addition to the page for the dependency.");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_ADDDEPENDENCY8, "Method addDependency(String name, String scope, String version, String markup) - The portal may choose to include the later version of the resource on the page if 2 same dependencies with different version are declared.");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_ADDDEPENDENCY10, "Method addDependency(String name, String scope, String version, String markup) - Throws IllegalArgumentException - if name is null.");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_ADDDEPENDENCY11, "Method addDependency(String name, String scope, String version, String markup) - Throws IllegalArgumentException - if name is empty.");
      tcd.put(V3HEADERPORTLETTESTS_SPEC15_HEADERRESPONSE_ADDDEPENDENCY12, "Method addDependency(String name, String scope, String version, String markup) - Throws IllegalArgumentException - if markup does not contain valid tags for the document HEAD section.");

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
