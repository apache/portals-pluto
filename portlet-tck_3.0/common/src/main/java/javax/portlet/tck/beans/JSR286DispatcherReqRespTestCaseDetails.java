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
public class JSR286DispatcherReqRespTestCaseDetails extends TestCaseDetails {

   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETATTRIBUTE                    = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getAttribute";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETATTRIBUTENAMES               = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getAttributeNames";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETAUTHTYPE                     = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getAuthType";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETCHARACTERENCODING            = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getCharacterEncoding";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETCONTENTLENGTH                = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getContentLength";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETCONTENTTYPE                  = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getContentType";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETCONTEXTPATH                  = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getContextPath";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETCOOKIES                      = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getCookies";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETDATEHEADER                   = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getDateHeader";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETHEADER                       = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getHeader";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETHEADERNAMES                  = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getHeaderNames";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETHEADERS                      = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getHeaders";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETINTHEADER                    = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getIntHeader";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETLOCALADDR                    = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getLocalAddr";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETLOCALNAME                    = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getLocalName";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETLOCALPORT                    = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getLocalPort";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETLOCALE                       = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getLocale";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETLOCALES                      = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getLocales";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETMETHOD                       = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getMethod";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETPARAMETER                    = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getParameter";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETPARAMETERMAP                 = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getParameterMap";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETPARAMETERNAMES               = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getParameterNames";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETPARAMETERVALUES              = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getParameterValues";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETPATHINFO                     = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getPathInfo";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETPATHTRANSLATED               = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getPathTranslated";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETPROTOCOL                     = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getProtocol";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETQUERYSTRING                  = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getQueryString";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETREALPATH                     = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getRealPath";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETREMOTEADDR                   = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getRemoteAddr";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETREMOTEHOST                   = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getRemoteHost";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETREMOTEPORT                   = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getRemotePort";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETREMOTEUSER                   = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getRemoteUser";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETREQUESTDISPATCHER            = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getRequestDispatcher";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETREQUESTURI                   = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getRequestURI";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETREQUESTURL                   = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getRequestURL";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETREQUESTEDSESSIONID           = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getRequestedSessionId";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETSCHEME                       = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getScheme";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETSERVERNAME                   = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getServerName";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETSERVERPORT                   = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getServerPort";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETSERVLETPATH                  = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getServletPath";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETSESSION                      = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getSession";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETUSERPRINCIPAL                = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getUserPrincipal";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_ISREQUESTEDSESSIONIDVALID       = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_isRequestedSessionIdValid";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_ISSECURE                        = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_isSecure";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_ISUSERINROLE                    = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_isUserInRole";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_REMOVEATTRIBUTE                 = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_removeAttribute";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_SETATTRIBUTE                    = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_setAttribute";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONRESPONSE_CONTAINSHEADER                 = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionResponse_containsHeader";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONRESPONSE_ENCODEREDIRECTURL1             = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionResponse_encodeRedirectURL1";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONRESPONSE_ENCODEREDIRECTURL              = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionResponse_encodeRedirectUrl";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONRESPONSE_ENCODEURL1                     = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionResponse_encodeURL1";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONRESPONSE_ENCODEURL                      = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionResponse_encodeUrl";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONRESPONSE_GETBUFFERSIZE                  = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionResponse_getBufferSize";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONRESPONSE_GETCHARACTERENCODING           = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionResponse_getCharacterEncoding";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONRESPONSE_GETCONTENTTYPE                 = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionResponse_getContentType";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONRESPONSE_GETLOCALE                      = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionResponse_getLocale";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONRESPONSE_ISCOMMITTED                    = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionResponse_isCommitted";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETATTRIBUTE                     = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventRequest_getAttribute";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETATTRIBUTENAMES                = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventRequest_getAttributeNames";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETAUTHTYPE                      = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventRequest_getAuthType";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETCHARACTERENCODING             = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventRequest_getCharacterEncoding";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETCONTENTLENGTH                 = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventRequest_getContentLength";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETCONTENTTYPE                   = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventRequest_getContentType";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETCONTEXTPATH                   = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventRequest_getContextPath";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETCOOKIES                       = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventRequest_getCookies";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETDATEHEADER                    = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventRequest_getDateHeader";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETHEADER                        = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventRequest_getHeader";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETHEADERNAMES                   = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventRequest_getHeaderNames";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETHEADERS                       = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventRequest_getHeaders";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETINPUTSTREAM                   = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventRequest_getInputStream";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETINTHEADER                     = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventRequest_getIntHeader";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETLOCALADDR                     = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventRequest_getLocalAddr";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETLOCALNAME                     = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventRequest_getLocalName";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETLOCALPORT                     = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventRequest_getLocalPort";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETLOCALE                        = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventRequest_getLocale";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETLOCALES                       = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventRequest_getLocales";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETMETHOD                        = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventRequest_getMethod";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETPARAMETER                     = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventRequest_getParameter";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETPARAMETERMAP                  = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventRequest_getParameterMap";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETPARAMETERNAMES                = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventRequest_getParameterNames";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETPARAMETERVALUES               = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventRequest_getParameterValues";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETPATHINFO                      = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventRequest_getPathInfo";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETPATHTRANSLATED                = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventRequest_getPathTranslated";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETPROTOCOL                      = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventRequest_getProtocol";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETQUERYSTRING                   = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventRequest_getQueryString";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETREADER                        = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventRequest_getReader";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETREALPATH                      = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventRequest_getRealPath";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETREMOTEADDR                    = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventRequest_getRemoteAddr";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETREMOTEHOST                    = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventRequest_getRemoteHost";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETREMOTEPORT                    = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventRequest_getRemotePort";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETREMOTEUSER                    = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventRequest_getRemoteUser";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETREQUESTDISPATCHER             = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventRequest_getRequestDispatcher";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETREQUESTURI                    = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventRequest_getRequestURI";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETREQUESTURL                    = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventRequest_getRequestURL";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETREQUESTEDSESSIONID            = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventRequest_getRequestedSessionId";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETSCHEME                        = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventRequest_getScheme";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETSERVERNAME                    = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventRequest_getServerName";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETSERVERPORT                    = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventRequest_getServerPort";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETSERVLETPATH                   = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventRequest_getServletPath";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETSESSION                       = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventRequest_getSession";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETUSERPRINCIPAL                 = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventRequest_getUserPrincipal";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_ISREQUESTEDSESSIONIDVALID        = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventRequest_isRequestedSessionIdValid";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_ISSECURE                         = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventRequest_isSecure";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_ISUSERINROLE                     = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventRequest_isUserInRole";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_REMOVEATTRIBUTE                  = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventRequest_removeAttribute";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_SETATTRIBUTE                     = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventRequest_setAttribute";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTRESPONSE_CONTAINSHEADER                  = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventResponse_containsHeader";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTRESPONSE_ENCODEREDIRECTURL1              = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventResponse_encodeRedirectURL1";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTRESPONSE_ENCODEREDIRECTURL               = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventResponse_encodeRedirectUrl";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTRESPONSE_ENCODEURL1                      = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventResponse_encodeURL1";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTRESPONSE_ENCODEURL                       = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventResponse_encodeUrl";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTRESPONSE_GETBUFFERSIZE                   = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventResponse_getBufferSize";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTRESPONSE_GETCHARACTERENCODING            = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventResponse_getCharacterEncoding";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTRESPONSE_GETCONTENTTYPE                  = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventResponse_getContentType";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTRESPONSE_GETLOCALE                       = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventResponse_getLocale";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTRESPONSE_ISCOMMITTED                     = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPEventResponse_isCommitted";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETATTRIBUTE                    = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderRequest_getAttribute";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETATTRIBUTENAMES               = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderRequest_getAttributeNames";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETAUTHTYPE                     = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderRequest_getAuthType";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETCHARACTERENCODING            = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderRequest_getCharacterEncoding";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETCONTENTLENGTH                = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderRequest_getContentLength";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETCONTENTTYPE                  = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderRequest_getContentType";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETCONTEXTPATH                  = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderRequest_getContextPath";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETCOOKIES                      = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderRequest_getCookies";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETDATEHEADER                   = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderRequest_getDateHeader";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETHEADER                       = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderRequest_getHeader";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETHEADERNAMES                  = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderRequest_getHeaderNames";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETHEADERS                      = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderRequest_getHeaders";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETINPUTSTREAM                  = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderRequest_getInputStream";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETINTHEADER                    = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderRequest_getIntHeader";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETLOCALADDR                    = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderRequest_getLocalAddr";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETLOCALNAME                    = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderRequest_getLocalName";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETLOCALPORT                    = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderRequest_getLocalPort";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETLOCALE                       = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderRequest_getLocale";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETLOCALES                      = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderRequest_getLocales";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETMETHOD                       = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderRequest_getMethod";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETPARAMETER                    = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderRequest_getParameter";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETPARAMETERMAP                 = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderRequest_getParameterMap";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETPARAMETERNAMES               = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderRequest_getParameterNames";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETPARAMETERVALUES              = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderRequest_getParameterValues";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETPATHINFO                     = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderRequest_getPathInfo";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETPATHTRANSLATED               = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderRequest_getPathTranslated";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETPROTOCOL                     = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderRequest_getProtocol";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETQUERYSTRING                  = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderRequest_getQueryString";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETREADER                       = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderRequest_getReader";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETREALPATH                     = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderRequest_getRealPath";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETREMOTEADDR                   = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderRequest_getRemoteAddr";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETREMOTEHOST                   = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderRequest_getRemoteHost";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETREMOTEPORT                   = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderRequest_getRemotePort";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETREMOTEUSER                   = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderRequest_getRemoteUser";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETREQUESTDISPATCHER            = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderRequest_getRequestDispatcher";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETREQUESTURI                   = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderRequest_getRequestURI";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETREQUESTURL                   = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderRequest_getRequestURL";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETREQUESTEDSESSIONID           = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderRequest_getRequestedSessionId";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETSCHEME                       = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderRequest_getScheme";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETSERVERNAME                   = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderRequest_getServerName";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETSERVERPORT                   = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderRequest_getServerPort";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETSERVLETPATH                  = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderRequest_getServletPath";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETSESSION                      = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderRequest_getSession";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETUSERPRINCIPAL                = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderRequest_getUserPrincipal";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_ISREQUESTEDSESSIONIDVALID       = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderRequest_isRequestedSessionIdValid";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_ISSECURE                        = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderRequest_isSecure";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_ISUSERINROLE                    = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderRequest_isUserInRole";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_REMOVEATTRIBUTE                 = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderRequest_removeAttribute";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_SETATTRIBUTE                    = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderRequest_setAttribute";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERRESPONSE_CONTAINSHEADER                 = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderResponse_containsHeader";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERRESPONSE_ENCODEREDIRECTURL1             = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderResponse_encodeRedirectURL1";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERRESPONSE_ENCODEREDIRECTURL              = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderResponse_encodeRedirectUrl";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERRESPONSE_ENCODEURL1                     = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderResponse_encodeURL1";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERRESPONSE_ENCODEURL                      = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderResponse_encodeUrl";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERRESPONSE_GETBUFFERSIZE                  = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderResponse_getBufferSize";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERRESPONSE_GETCHARACTERENCODING           = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderResponse_getCharacterEncoding";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERRESPONSE_GETCONTENTTYPE                 = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderResponse_getContentType";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERRESPONSE_GETLOCALE                      = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderResponse_getLocale";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERRESPONSE_ISCOMMITTED                    = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPRenderResponse_isCommitted";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETATTRIBUTE                  = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getAttribute";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETATTRIBUTENAMES             = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getAttributeNames";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETAUTHTYPE                   = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getAuthType";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETCHARACTERENCODING          = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getCharacterEncoding";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETCONTENTLENGTH              = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getContentLength";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETCONTENTTYPE                = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getContentType";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETCONTEXTPATH                = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getContextPath";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETCOOKIES                    = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getCookies";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETDATEHEADER                 = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getDateHeader";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETHEADER                     = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getHeader";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETHEADERNAMES                = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getHeaderNames";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETHEADERS                    = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getHeaders";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETINTHEADER                  = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getIntHeader";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETLOCALADDR                  = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getLocalAddr";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETLOCALNAME                  = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getLocalName";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETLOCALPORT                  = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getLocalPort";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETLOCALE                     = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getLocale";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETLOCALES                    = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getLocales";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETMETHOD                     = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getMethod";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETPARAMETER                  = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getParameter";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETPARAMETERMAP               = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getParameterMap";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETPARAMETERNAMES             = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getParameterNames";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETPARAMETERVALUES            = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getParameterValues";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETPATHINFO                   = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getPathInfo";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETPATHTRANSLATED             = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getPathTranslated";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETPROTOCOL                   = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getProtocol";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETQUERYSTRING                = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getQueryString";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETREALPATH                   = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getRealPath";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETREMOTEADDR                 = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getRemoteAddr";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETREMOTEHOST                 = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getRemoteHost";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETREMOTEPORT                 = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getRemotePort";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETREMOTEUSER                 = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getRemoteUser";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETREQUESTDISPATCHER          = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getRequestDispatcher";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETREQUESTURI                 = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getRequestURI";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETREQUESTURL                 = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getRequestURL";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETREQUESTEDSESSIONID         = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getRequestedSessionId";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETSCHEME                     = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getScheme";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETSERVERNAME                 = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getServerName";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETSERVERPORT                 = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getServerPort";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETSERVLETPATH                = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getServletPath";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETSESSION                    = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getSession";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETUSERPRINCIPAL              = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getUserPrincipal";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_ISREQUESTEDSESSIONIDVALID     = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_isRequestedSessionIdValid";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_ISSECURE                      = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_isSecure";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_ISUSERINROLE                  = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_isUserInRole";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_REMOVEATTRIBUTE               = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_removeAttribute";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_SETATTRIBUTE                  = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_setAttribute";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCERESPONSE_CONTAINSHEADER               = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceResponse_containsHeader";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCERESPONSE_ENCODEREDIRECTURL1           = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceResponse_encodeRedirectURL1";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCERESPONSE_ENCODEREDIRECTURL            = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceResponse_encodeRedirectUrl";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCERESPONSE_ENCODEURL1                   = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceResponse_encodeURL1";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCERESPONSE_ENCODEURL                    = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceResponse_encodeUrl";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCERESPONSE_GETBUFFERSIZE                = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceResponse_getBufferSize";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCERESPONSE_GETCHARACTERENCODING         = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceResponse_getCharacterEncoding";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCERESPONSE_GETCONTENTTYPE               = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceResponse_getContentType";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCERESPONSE_GETLOCALE                    = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceResponse_getLocale";
   public final static String               V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCERESPONSE_ISCOMMITTED                  = "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceResponse_isCommitted";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETATTRIBUTE                = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionRequest_getAttribute";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETATTRIBUTENAMES           = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionRequest_getAttributeNames";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETAUTHTYPE                 = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionRequest_getAuthType";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETCHARACTERENCODING        = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionRequest_getCharacterEncoding";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETCONTENTLENGTH            = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionRequest_getContentLength";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETCONTENTTYPE              = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionRequest_getContentType";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETCONTEXTPATH              = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionRequest_getContextPath";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETCOOKIES                  = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionRequest_getCookies";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETDATEHEADER               = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionRequest_getDateHeader";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETHEADER                   = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionRequest_getHeader";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETHEADERNAMES              = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionRequest_getHeaderNames";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETHEADERS                  = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionRequest_getHeaders";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETINTHEADER                = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionRequest_getIntHeader";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETLOCALADDR                = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionRequest_getLocalAddr";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETLOCALNAME                = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionRequest_getLocalName";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETLOCALPORT                = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionRequest_getLocalPort";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETLOCALE                   = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionRequest_getLocale";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETLOCALES                  = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionRequest_getLocales";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETMETHOD                   = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionRequest_getMethod";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETPARAMETER                = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionRequest_getParameter";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETPARAMETERMAP             = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionRequest_getParameterMap";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETPARAMETERNAMES           = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionRequest_getParameterNames";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETPARAMETERVALUES          = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionRequest_getParameterValues";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETPATHINFO                 = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionRequest_getPathInfo";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETPATHTRANSLATED           = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionRequest_getPathTranslated";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETPROTOCOL                 = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionRequest_getProtocol";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETQUERYSTRING              = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionRequest_getQueryString";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETREALPATH                 = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionRequest_getRealPath";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETREMOTEADDR               = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionRequest_getRemoteAddr";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETREMOTEHOST               = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionRequest_getRemoteHost";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETREMOTEPORT               = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionRequest_getRemotePort";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETREMOTEUSER               = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionRequest_getRemoteUser";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETREQUESTDISPATCHER        = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionRequest_getRequestDispatcher";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETREQUESTURI               = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionRequest_getRequestURI";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETREQUESTURL               = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionRequest_getRequestURL";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETREQUESTEDSESSIONID       = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionRequest_getRequestedSessionId";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETSCHEME                   = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionRequest_getScheme";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETSERVERNAME               = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionRequest_getServerName";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETSERVERPORT               = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionRequest_getServerPort";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETSERVLETPATH              = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionRequest_getServletPath";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETSESSION                  = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionRequest_getSession";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETUSERPRINCIPAL            = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionRequest_getUserPrincipal";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_ISREQUESTEDSESSIONIDVALID   = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionRequest_isRequestedSessionIdValid";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_ISSECURE                    = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionRequest_isSecure";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_ISUSERINROLE                = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionRequest_isUserInRole";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_REMOVEATTRIBUTE             = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionRequest_removeAttribute";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_SETATTRIBUTE                = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionRequest_setAttribute";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONRESPONSE_CONTAINSHEADER             = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionResponse_containsHeader";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONRESPONSE_ENCODEREDIRECTURL1         = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionResponse_encodeRedirectURL1";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONRESPONSE_ENCODEREDIRECTURL          = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionResponse_encodeRedirectUrl";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONRESPONSE_ENCODEURL1                 = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionResponse_encodeURL1";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONRESPONSE_ENCODEURL                  = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionResponse_encodeUrl";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONRESPONSE_GETBUFFERSIZE              = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionResponse_getBufferSize";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONRESPONSE_GETCHARACTERENCODING       = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionResponse_getCharacterEncoding";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONRESPONSE_GETCONTENTTYPE             = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionResponse_getContentType";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONRESPONSE_GETLOCALE                  = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionResponse_getLocale";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONRESPONSE_ISCOMMITTED                = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletActionResponse_isCommitted";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETATTRIBUTE                 = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventRequest_getAttribute";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETATTRIBUTENAMES            = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventRequest_getAttributeNames";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETAUTHTYPE                  = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventRequest_getAuthType";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETCHARACTERENCODING         = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventRequest_getCharacterEncoding";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETCONTENTLENGTH             = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventRequest_getContentLength";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETCONTENTTYPE               = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventRequest_getContentType";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETCONTEXTPATH               = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventRequest_getContextPath";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETCOOKIES                   = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventRequest_getCookies";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETDATEHEADER                = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventRequest_getDateHeader";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETHEADER                    = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventRequest_getHeader";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETHEADERNAMES               = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventRequest_getHeaderNames";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETHEADERS                   = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventRequest_getHeaders";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETINPUTSTREAM               = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventRequest_getInputStream";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETINTHEADER                 = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventRequest_getIntHeader";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETLOCALADDR                 = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventRequest_getLocalAddr";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETLOCALNAME                 = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventRequest_getLocalName";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETLOCALPORT                 = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventRequest_getLocalPort";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETLOCALE                    = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventRequest_getLocale";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETLOCALES                   = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventRequest_getLocales";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETMETHOD                    = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventRequest_getMethod";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETPARAMETER                 = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventRequest_getParameter";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETPARAMETERMAP              = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventRequest_getParameterMap";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETPARAMETERNAMES            = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventRequest_getParameterNames";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETPARAMETERVALUES           = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventRequest_getParameterValues";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETPATHINFO                  = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventRequest_getPathInfo";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETPATHTRANSLATED            = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventRequest_getPathTranslated";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETPROTOCOL                  = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventRequest_getProtocol";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETQUERYSTRING               = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventRequest_getQueryString";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETREADER                    = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventRequest_getReader";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETREALPATH                  = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventRequest_getRealPath";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETREMOTEADDR                = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventRequest_getRemoteAddr";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETREMOTEHOST                = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventRequest_getRemoteHost";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETREMOTEPORT                = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventRequest_getRemotePort";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETREMOTEUSER                = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventRequest_getRemoteUser";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETREQUESTDISPATCHER         = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventRequest_getRequestDispatcher";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETREQUESTURI                = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventRequest_getRequestURI";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETREQUESTURL                = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventRequest_getRequestURL";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETREQUESTEDSESSIONID        = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventRequest_getRequestedSessionId";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETSCHEME                    = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventRequest_getScheme";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETSERVERNAME                = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventRequest_getServerName";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETSERVERPORT                = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventRequest_getServerPort";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETSERVLETPATH               = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventRequest_getServletPath";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETSESSION                   = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventRequest_getSession";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETUSERPRINCIPAL             = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventRequest_getUserPrincipal";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_ISREQUESTEDSESSIONIDVALID    = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventRequest_isRequestedSessionIdValid";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_ISSECURE                     = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventRequest_isSecure";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_ISUSERINROLE                 = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventRequest_isUserInRole";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_REMOVEATTRIBUTE              = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventRequest_removeAttribute";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_SETATTRIBUTE                 = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventRequest_setAttribute";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTRESPONSE_CONTAINSHEADER              = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse_containsHeader";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTRESPONSE_ENCODEREDIRECTURL1          = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse_encodeRedirectURL1";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTRESPONSE_ENCODEREDIRECTURL           = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse_encodeRedirectUrl";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTRESPONSE_ENCODEURL1                  = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse_encodeURL1";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTRESPONSE_ENCODEURL                   = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse_encodeUrl";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTRESPONSE_GETBUFFERSIZE               = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse_getBufferSize";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTRESPONSE_GETCHARACTERENCODING        = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse_getCharacterEncoding";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTRESPONSE_GETCONTENTTYPE              = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse_getContentType";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTRESPONSE_GETLOCALE                   = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse_getLocale";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTRESPONSE_ISCOMMITTED                 = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletEventResponse_isCommitted";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETATTRIBUTE                = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderRequest_getAttribute";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETATTRIBUTENAMES           = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderRequest_getAttributeNames";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETAUTHTYPE                 = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderRequest_getAuthType";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETCHARACTERENCODING        = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderRequest_getCharacterEncoding";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETCONTENTLENGTH            = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderRequest_getContentLength";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETCONTENTTYPE              = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderRequest_getContentType";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETCONTEXTPATH              = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderRequest_getContextPath";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETCOOKIES                  = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderRequest_getCookies";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETDATEHEADER               = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderRequest_getDateHeader";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETHEADER                   = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderRequest_getHeader";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETHEADERNAMES              = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderRequest_getHeaderNames";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETHEADERS                  = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderRequest_getHeaders";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETINPUTSTREAM              = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderRequest_getInputStream";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETINTHEADER                = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderRequest_getIntHeader";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETLOCALADDR                = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderRequest_getLocalAddr";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETLOCALNAME                = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderRequest_getLocalName";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETLOCALPORT                = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderRequest_getLocalPort";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETLOCALE                   = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderRequest_getLocale";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETLOCALES                  = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderRequest_getLocales";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETMETHOD                   = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderRequest_getMethod";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETPARAMETER                = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderRequest_getParameter";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETPARAMETERMAP             = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderRequest_getParameterMap";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETPARAMETERNAMES           = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderRequest_getParameterNames";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETPARAMETERVALUES          = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderRequest_getParameterValues";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETPATHINFO                 = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderRequest_getPathInfo";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETPATHTRANSLATED           = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderRequest_getPathTranslated";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETPROTOCOL                 = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderRequest_getProtocol";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETQUERYSTRING              = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderRequest_getQueryString";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETREADER                   = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderRequest_getReader";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETREALPATH                 = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderRequest_getRealPath";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETREMOTEADDR               = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderRequest_getRemoteAddr";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETREMOTEHOST               = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderRequest_getRemoteHost";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETREMOTEPORT               = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderRequest_getRemotePort";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETREMOTEUSER               = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderRequest_getRemoteUser";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETREQUESTDISPATCHER        = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderRequest_getRequestDispatcher";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETREQUESTURI               = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderRequest_getRequestURI";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETREQUESTURL               = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderRequest_getRequestURL";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETREQUESTEDSESSIONID       = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderRequest_getRequestedSessionId";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETSCHEME                   = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderRequest_getScheme";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETSERVERNAME               = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderRequest_getServerName";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETSERVERPORT               = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderRequest_getServerPort";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETSERVLETPATH              = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderRequest_getServletPath";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETSESSION                  = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderRequest_getSession";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETUSERPRINCIPAL            = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderRequest_getUserPrincipal";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_ISREQUESTEDSESSIONIDVALID   = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderRequest_isRequestedSessionIdValid";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_ISSECURE                    = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderRequest_isSecure";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_ISUSERINROLE                = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderRequest_isUserInRole";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_REMOVEATTRIBUTE             = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderRequest_removeAttribute";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_SETATTRIBUTE                = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderRequest_setAttribute";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERRESPONSE_CONTAINSHEADER             = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderResponse_containsHeader";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERRESPONSE_ENCODEREDIRECTURL1         = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderResponse_encodeRedirectURL1";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERRESPONSE_ENCODEREDIRECTURL          = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderResponse_encodeRedirectUrl";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERRESPONSE_ENCODEURL1                 = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderResponse_encodeURL1";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERRESPONSE_ENCODEURL                  = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderResponse_encodeUrl";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERRESPONSE_GETBUFFERSIZE              = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderResponse_getBufferSize";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERRESPONSE_GETCHARACTERENCODING       = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderResponse_getCharacterEncoding";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERRESPONSE_GETCONTENTTYPE             = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderResponse_getContentType";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERRESPONSE_GETLOCALE                  = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderResponse_getLocale";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERRESPONSE_ISCOMMITTED                = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletRenderResponse_isCommitted";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETATTRIBUTE              = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletResourceRequest_getAttribute";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETATTRIBUTENAMES         = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletResourceRequest_getAttributeNames";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETAUTHTYPE               = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletResourceRequest_getAuthType";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETCHARACTERENCODING      = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletResourceRequest_getCharacterEncoding";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETCONTENTLENGTH          = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletResourceRequest_getContentLength";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETCONTENTTYPE            = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletResourceRequest_getContentType";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETCONTEXTPATH            = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletResourceRequest_getContextPath";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETCOOKIES                = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletResourceRequest_getCookies";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETDATEHEADER             = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletResourceRequest_getDateHeader";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETHEADER                 = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletResourceRequest_getHeader";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETHEADERNAMES            = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletResourceRequest_getHeaderNames";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETHEADERS                = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletResourceRequest_getHeaders";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETINTHEADER              = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletResourceRequest_getIntHeader";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETLOCALADDR              = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletResourceRequest_getLocalAddr";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETLOCALNAME              = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletResourceRequest_getLocalName";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETLOCALPORT              = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletResourceRequest_getLocalPort";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETLOCALE                 = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletResourceRequest_getLocale";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETLOCALES                = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletResourceRequest_getLocales";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETMETHOD                 = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletResourceRequest_getMethod";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETPARAMETER              = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletResourceRequest_getParameter";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETPARAMETERMAP           = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletResourceRequest_getParameterMap";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETPARAMETERNAMES         = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletResourceRequest_getParameterNames";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETPARAMETERVALUES        = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletResourceRequest_getParameterValues";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETPATHINFO               = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletResourceRequest_getPathInfo";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETPATHTRANSLATED         = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletResourceRequest_getPathTranslated";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETPROTOCOL               = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletResourceRequest_getProtocol";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETQUERYSTRING            = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletResourceRequest_getQueryString";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETREALPATH               = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletResourceRequest_getRealPath";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETREMOTEADDR             = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletResourceRequest_getRemoteAddr";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETREMOTEHOST             = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletResourceRequest_getRemoteHost";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETREMOTEPORT             = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletResourceRequest_getRemotePort";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETREMOTEUSER             = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletResourceRequest_getRemoteUser";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETREQUESTDISPATCHER      = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletResourceRequest_getRequestDispatcher";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETREQUESTURI             = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletResourceRequest_getRequestURI";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETREQUESTURL             = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletResourceRequest_getRequestURL";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETREQUESTEDSESSIONID     = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletResourceRequest_getRequestedSessionId";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETSCHEME                 = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletResourceRequest_getScheme";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETSERVERNAME             = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletResourceRequest_getServerName";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETSERVERPORT             = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletResourceRequest_getServerPort";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETSERVLETPATH            = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletResourceRequest_getServletPath";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETSESSION                = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletResourceRequest_getSession";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETUSERPRINCIPAL          = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletResourceRequest_getUserPrincipal";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_ISREQUESTEDSESSIONIDVALID = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletResourceRequest_isRequestedSessionIdValid";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_ISSECURE                  = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletResourceRequest_isSecure";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_ISUSERINROLE              = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletResourceRequest_isUserInRole";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_REMOVEATTRIBUTE           = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletResourceRequest_removeAttribute";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_SETATTRIBUTE              = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletResourceRequest_setAttribute";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCERESPONSE_CONTAINSHEADER           = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletResourceResponse_containsHeader";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCERESPONSE_ENCODEREDIRECTURL1       = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletResourceResponse_encodeRedirectURL1";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCERESPONSE_ENCODEREDIRECTURL        = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletResourceResponse_encodeRedirectUrl";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCERESPONSE_ENCODEURL1               = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletResourceResponse_encodeURL1";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCERESPONSE_ENCODEURL                = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletResourceResponse_encodeUrl";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCERESPONSE_GETBUFFERSIZE            = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletResourceResponse_getBufferSize";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCERESPONSE_GETCHARACTERENCODING     = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletResourceResponse_getCharacterEncoding";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCERESPONSE_GETCONTENTTYPE           = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletResourceResponse_getContentType";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCERESPONSE_GETLOCALE                = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletResourceResponse_getLocale";
   public final static String               V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCERESPONSE_ISCOMMITTED              = "V2DispatcherReqRespTests2_SPEC2_19_ForwardServletResourceResponse_isCommitted";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETATTRIBUTE                    = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPActionRequest_getAttribute";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETATTRIBUTENAMES               = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPActionRequest_getAttributeNames";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETAUTHTYPE                     = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPActionRequest_getAuthType";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETCHARACTERENCODING            = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPActionRequest_getCharacterEncoding";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETCONTENTLENGTH                = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPActionRequest_getContentLength";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETCONTENTTYPE                  = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPActionRequest_getContentType";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETCONTEXTPATH                  = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPActionRequest_getContextPath";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETCOOKIES                      = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPActionRequest_getCookies";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETDATEHEADER                   = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPActionRequest_getDateHeader";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETHEADER                       = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPActionRequest_getHeader";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETHEADERNAMES                  = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPActionRequest_getHeaderNames";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETHEADERS                      = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPActionRequest_getHeaders";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETINTHEADER                    = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPActionRequest_getIntHeader";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETLOCALADDR                    = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPActionRequest_getLocalAddr";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETLOCALNAME                    = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPActionRequest_getLocalName";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETLOCALPORT                    = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPActionRequest_getLocalPort";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETLOCALE                       = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPActionRequest_getLocale";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETLOCALES                      = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPActionRequest_getLocales";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETMETHOD                       = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPActionRequest_getMethod";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETPARAMETER                    = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPActionRequest_getParameter";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETPARAMETERMAP                 = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPActionRequest_getParameterMap";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETPARAMETERNAMES               = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPActionRequest_getParameterNames";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETPARAMETERVALUES              = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPActionRequest_getParameterValues";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETPATHINFO                     = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPActionRequest_getPathInfo";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETPATHTRANSLATED               = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPActionRequest_getPathTranslated";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETPROTOCOL                     = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPActionRequest_getProtocol";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETQUERYSTRING                  = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPActionRequest_getQueryString";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETREALPATH                     = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPActionRequest_getRealPath";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETREMOTEADDR                   = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPActionRequest_getRemoteAddr";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETREMOTEHOST                   = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPActionRequest_getRemoteHost";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETREMOTEPORT                   = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPActionRequest_getRemotePort";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETREMOTEUSER                   = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPActionRequest_getRemoteUser";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETREQUESTDISPATCHER            = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPActionRequest_getRequestDispatcher";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETREQUESTURI                   = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPActionRequest_getRequestURI";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETREQUESTURL                   = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPActionRequest_getRequestURL";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETREQUESTEDSESSIONID           = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPActionRequest_getRequestedSessionId";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETSCHEME                       = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPActionRequest_getScheme";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETSERVERNAME                   = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPActionRequest_getServerName";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETSERVERPORT                   = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPActionRequest_getServerPort";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETSERVLETPATH                  = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPActionRequest_getServletPath";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETSESSION                      = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPActionRequest_getSession";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETUSERPRINCIPAL                = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPActionRequest_getUserPrincipal";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_ISREQUESTEDSESSIONIDVALID       = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPActionRequest_isRequestedSessionIdValid";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_ISSECURE                        = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPActionRequest_isSecure";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_ISUSERINROLE                    = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPActionRequest_isUserInRole";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_REMOVEATTRIBUTE                 = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPActionRequest_removeAttribute";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_SETATTRIBUTE                    = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPActionRequest_setAttribute";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONRESPONSE_CONTAINSHEADER                 = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPActionResponse_containsHeader";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONRESPONSE_ENCODEREDIRECTURL1             = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPActionResponse_encodeRedirectURL1";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONRESPONSE_ENCODEREDIRECTURL              = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPActionResponse_encodeRedirectUrl";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONRESPONSE_ENCODEURL1                     = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPActionResponse_encodeURL1";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONRESPONSE_ENCODEURL                      = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPActionResponse_encodeUrl";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONRESPONSE_GETBUFFERSIZE                  = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPActionResponse_getBufferSize";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONRESPONSE_GETCHARACTERENCODING           = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPActionResponse_getCharacterEncoding";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONRESPONSE_GETCONTENTTYPE                 = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPActionResponse_getContentType";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONRESPONSE_GETLOCALE                      = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPActionResponse_getLocale";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONRESPONSE_ISCOMMITTED                    = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPActionResponse_isCommitted";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETATTRIBUTE                     = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getAttribute";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETATTRIBUTENAMES                = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getAttributeNames";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETAUTHTYPE                      = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getAuthType";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETCHARACTERENCODING             = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getCharacterEncoding";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETCONTENTLENGTH                 = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getContentLength";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETCONTENTTYPE                   = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getContentType";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETCONTEXTPATH                   = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getContextPath";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETCOOKIES                       = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getCookies";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETDATEHEADER                    = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getDateHeader";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETHEADER                        = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getHeader";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETHEADERNAMES                   = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getHeaderNames";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETHEADERS                       = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getHeaders";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETINPUTSTREAM                   = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getInputStream";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETINTHEADER                     = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getIntHeader";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETLOCALADDR                     = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getLocalAddr";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETLOCALNAME                     = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getLocalName";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETLOCALPORT                     = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getLocalPort";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETLOCALE                        = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getLocale";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETLOCALES                       = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getLocales";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETMETHOD                        = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getMethod";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETPARAMETER                     = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getParameter";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETPARAMETERMAP                  = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getParameterMap";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETPARAMETERNAMES                = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getParameterNames";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETPARAMETERVALUES               = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getParameterValues";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETPATHINFO                      = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getPathInfo";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETPATHTRANSLATED                = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getPathTranslated";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETPROTOCOL                      = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getProtocol";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETQUERYSTRING                   = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getQueryString";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETREADER                        = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getReader";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETREALPATH                      = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getRealPath";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETREMOTEADDR                    = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getRemoteAddr";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETREMOTEHOST                    = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getRemoteHost";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETREMOTEPORT                    = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getRemotePort";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETREMOTEUSER                    = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getRemoteUser";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETREQUESTDISPATCHER             = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getRequestDispatcher";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETREQUESTURI                    = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getRequestURI";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETREQUESTURL                    = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getRequestURL";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETREQUESTEDSESSIONID            = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getRequestedSessionId";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETSCHEME                        = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getScheme";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETSERVERNAME                    = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getServerName";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETSERVERPORT                    = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getServerPort";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETSERVLETPATH                   = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getServletPath";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETSESSION                       = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getSession";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETUSERPRINCIPAL                 = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getUserPrincipal";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_ISREQUESTEDSESSIONIDVALID        = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_isRequestedSessionIdValid";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_ISSECURE                         = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_isSecure";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_ISUSERINROLE                     = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_isUserInRole";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_REMOVEATTRIBUTE                  = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_removeAttribute";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_SETATTRIBUTE                     = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_setAttribute";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTRESPONSE_CONTAINSHEADER                  = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventResponse_containsHeader";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTRESPONSE_ENCODEREDIRECTURL1              = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventResponse_encodeRedirectURL1";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTRESPONSE_ENCODEREDIRECTURL               = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventResponse_encodeRedirectUrl";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTRESPONSE_ENCODEURL1                      = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventResponse_encodeURL1";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTRESPONSE_ENCODEURL                       = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventResponse_encodeUrl";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTRESPONSE_GETBUFFERSIZE                   = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventResponse_getBufferSize";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTRESPONSE_GETCHARACTERENCODING            = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventResponse_getCharacterEncoding";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTRESPONSE_GETCONTENTTYPE                  = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventResponse_getContentType";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTRESPONSE_GETLOCALE                       = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventResponse_getLocale";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTRESPONSE_ISCOMMITTED                     = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventResponse_isCommitted";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETATTRIBUTE                    = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderRequest_getAttribute";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETATTRIBUTENAMES               = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderRequest_getAttributeNames";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETAUTHTYPE                     = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderRequest_getAuthType";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETCHARACTERENCODING            = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderRequest_getCharacterEncoding";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETCONTENTLENGTH                = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderRequest_getContentLength";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETCONTENTTYPE                  = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderRequest_getContentType";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETCONTEXTPATH                  = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderRequest_getContextPath";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETCOOKIES                      = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderRequest_getCookies";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETDATEHEADER                   = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderRequest_getDateHeader";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETHEADER                       = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderRequest_getHeader";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETHEADERNAMES                  = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderRequest_getHeaderNames";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETHEADERS                      = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderRequest_getHeaders";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETINPUTSTREAM                  = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderRequest_getInputStream";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETINTHEADER                    = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderRequest_getIntHeader";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETLOCALADDR                    = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderRequest_getLocalAddr";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETLOCALNAME                    = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderRequest_getLocalName";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETLOCALPORT                    = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderRequest_getLocalPort";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETLOCALE                       = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderRequest_getLocale";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETLOCALES                      = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderRequest_getLocales";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETMETHOD                       = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderRequest_getMethod";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETPARAMETER                    = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderRequest_getParameter";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETPARAMETERMAP                 = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderRequest_getParameterMap";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETPARAMETERNAMES               = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderRequest_getParameterNames";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETPARAMETERVALUES              = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderRequest_getParameterValues";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETPATHINFO                     = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderRequest_getPathInfo";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETPATHTRANSLATED               = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderRequest_getPathTranslated";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETPROTOCOL                     = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderRequest_getProtocol";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETQUERYSTRING                  = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderRequest_getQueryString";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETREADER                       = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderRequest_getReader";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETREALPATH                     = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderRequest_getRealPath";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETREMOTEADDR                   = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderRequest_getRemoteAddr";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETREMOTEHOST                   = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderRequest_getRemoteHost";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETREMOTEPORT                   = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderRequest_getRemotePort";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETREMOTEUSER                   = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderRequest_getRemoteUser";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETREQUESTDISPATCHER            = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderRequest_getRequestDispatcher";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETREQUESTURI                   = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderRequest_getRequestURI";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETREQUESTURL                   = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderRequest_getRequestURL";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETREQUESTEDSESSIONID           = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderRequest_getRequestedSessionId";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETSCHEME                       = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderRequest_getScheme";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETSERVERNAME                   = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderRequest_getServerName";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETSERVERPORT                   = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderRequest_getServerPort";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETSERVLETPATH                  = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderRequest_getServletPath";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETSESSION                      = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderRequest_getSession";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETUSERPRINCIPAL                = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderRequest_getUserPrincipal";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_ISREQUESTEDSESSIONIDVALID       = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderRequest_isRequestedSessionIdValid";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_ISSECURE                        = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderRequest_isSecure";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_ISUSERINROLE                    = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderRequest_isUserInRole";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_REMOVEATTRIBUTE                 = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderRequest_removeAttribute";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_SETATTRIBUTE                    = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderRequest_setAttribute";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERRESPONSE_CONTAINSHEADER                 = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderResponse_containsHeader";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERRESPONSE_ENCODEREDIRECTURL1             = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderResponse_encodeRedirectURL1";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERRESPONSE_ENCODEREDIRECTURL              = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderResponse_encodeRedirectUrl";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERRESPONSE_ENCODEURL1                     = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderResponse_encodeURL1";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERRESPONSE_ENCODEURL                      = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderResponse_encodeUrl";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERRESPONSE_GETBUFFERSIZE                  = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderResponse_getBufferSize";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERRESPONSE_GETCHARACTERENCODING           = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderResponse_getCharacterEncoding";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERRESPONSE_GETCONTENTTYPE                 = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderResponse_getContentType";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERRESPONSE_GETLOCALE                      = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderResponse_getLocale";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERRESPONSE_ISCOMMITTED                    = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPRenderResponse_isCommitted";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETATTRIBUTE                  = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPResourceRequest_getAttribute";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETATTRIBUTENAMES             = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPResourceRequest_getAttributeNames";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETAUTHTYPE                   = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPResourceRequest_getAuthType";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETCHARACTERENCODING          = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPResourceRequest_getCharacterEncoding";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETCONTENTLENGTH              = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPResourceRequest_getContentLength";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETCONTENTTYPE                = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPResourceRequest_getContentType";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETCONTEXTPATH                = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPResourceRequest_getContextPath";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETCOOKIES                    = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPResourceRequest_getCookies";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETDATEHEADER                 = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPResourceRequest_getDateHeader";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETHEADER                     = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPResourceRequest_getHeader";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETHEADERNAMES                = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPResourceRequest_getHeaderNames";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETHEADERS                    = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPResourceRequest_getHeaders";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETINTHEADER                  = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPResourceRequest_getIntHeader";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETLOCALADDR                  = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPResourceRequest_getLocalAddr";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETLOCALNAME                  = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPResourceRequest_getLocalName";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETLOCALPORT                  = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPResourceRequest_getLocalPort";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETLOCALE                     = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPResourceRequest_getLocale";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETLOCALES                    = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPResourceRequest_getLocales";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETMETHOD                     = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPResourceRequest_getMethod";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETPARAMETER                  = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPResourceRequest_getParameter";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETPARAMETERMAP               = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPResourceRequest_getParameterMap";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETPARAMETERNAMES             = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPResourceRequest_getParameterNames";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETPARAMETERVALUES            = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPResourceRequest_getParameterValues";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETPATHINFO                   = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPResourceRequest_getPathInfo";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETPATHTRANSLATED             = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPResourceRequest_getPathTranslated";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETPROTOCOL                   = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPResourceRequest_getProtocol";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETQUERYSTRING                = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPResourceRequest_getQueryString";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETREALPATH                   = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPResourceRequest_getRealPath";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETREMOTEADDR                 = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPResourceRequest_getRemoteAddr";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETREMOTEHOST                 = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPResourceRequest_getRemoteHost";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETREMOTEPORT                 = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPResourceRequest_getRemotePort";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETREMOTEUSER                 = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPResourceRequest_getRemoteUser";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETREQUESTDISPATCHER          = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPResourceRequest_getRequestDispatcher";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETREQUESTURI                 = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPResourceRequest_getRequestURI";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETREQUESTURL                 = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPResourceRequest_getRequestURL";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETREQUESTEDSESSIONID         = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPResourceRequest_getRequestedSessionId";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETSCHEME                     = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPResourceRequest_getScheme";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETSERVERNAME                 = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPResourceRequest_getServerName";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETSERVERPORT                 = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPResourceRequest_getServerPort";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETSERVLETPATH                = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPResourceRequest_getServletPath";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETSESSION                    = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPResourceRequest_getSession";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETUSERPRINCIPAL              = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPResourceRequest_getUserPrincipal";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_ISREQUESTEDSESSIONIDVALID     = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPResourceRequest_isRequestedSessionIdValid";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_ISSECURE                      = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPResourceRequest_isSecure";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_ISUSERINROLE                  = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPResourceRequest_isUserInRole";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_REMOVEATTRIBUTE               = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPResourceRequest_removeAttribute";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_SETATTRIBUTE                  = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPResourceRequest_setAttribute";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCERESPONSE_CONTAINSHEADER               = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPResourceResponse_containsHeader";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCERESPONSE_ENCODEREDIRECTURL1           = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPResourceResponse_encodeRedirectURL1";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCERESPONSE_ENCODEREDIRECTURL            = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPResourceResponse_encodeRedirectUrl";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCERESPONSE_ENCODEURL1                   = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPResourceResponse_encodeURL1";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCERESPONSE_ENCODEURL                    = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPResourceResponse_encodeUrl";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCERESPONSE_GETBUFFERSIZE                = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPResourceResponse_getBufferSize";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCERESPONSE_GETCHARACTERENCODING         = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPResourceResponse_getCharacterEncoding";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCERESPONSE_GETCONTENTTYPE               = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPResourceResponse_getContentType";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCERESPONSE_GETLOCALE                    = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPResourceResponse_getLocale";
   public final static String               V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCERESPONSE_ISCOMMITTED                  = "V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPResourceResponse_isCommitted";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETATTRIBUTE                = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletActionRequest_getAttribute";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETATTRIBUTENAMES           = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletActionRequest_getAttributeNames";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETAUTHTYPE                 = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletActionRequest_getAuthType";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETCHARACTERENCODING        = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletActionRequest_getCharacterEncoding";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETCONTENTLENGTH            = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletActionRequest_getContentLength";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETCONTENTTYPE              = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletActionRequest_getContentType";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETCONTEXTPATH              = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletActionRequest_getContextPath";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETCOOKIES                  = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletActionRequest_getCookies";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETDATEHEADER               = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletActionRequest_getDateHeader";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETHEADER                   = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletActionRequest_getHeader";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETHEADERNAMES              = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletActionRequest_getHeaderNames";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETHEADERS                  = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletActionRequest_getHeaders";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETINTHEADER                = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletActionRequest_getIntHeader";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETLOCALADDR                = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletActionRequest_getLocalAddr";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETLOCALNAME                = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletActionRequest_getLocalName";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETLOCALPORT                = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletActionRequest_getLocalPort";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETLOCALE                   = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletActionRequest_getLocale";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETLOCALES                  = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletActionRequest_getLocales";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETMETHOD                   = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletActionRequest_getMethod";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETPARAMETER                = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletActionRequest_getParameter";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETPARAMETERMAP             = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletActionRequest_getParameterMap";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETPARAMETERNAMES           = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletActionRequest_getParameterNames";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETPARAMETERVALUES          = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletActionRequest_getParameterValues";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETPATHINFO                 = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletActionRequest_getPathInfo";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETPATHTRANSLATED           = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletActionRequest_getPathTranslated";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETPROTOCOL                 = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletActionRequest_getProtocol";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETQUERYSTRING              = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletActionRequest_getQueryString";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETREALPATH                 = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletActionRequest_getRealPath";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETREMOTEADDR               = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletActionRequest_getRemoteAddr";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETREMOTEHOST               = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletActionRequest_getRemoteHost";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETREMOTEPORT               = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletActionRequest_getRemotePort";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETREMOTEUSER               = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletActionRequest_getRemoteUser";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETREQUESTDISPATCHER        = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletActionRequest_getRequestDispatcher";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETREQUESTURI               = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletActionRequest_getRequestURI";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETREQUESTURL               = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletActionRequest_getRequestURL";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETREQUESTEDSESSIONID       = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletActionRequest_getRequestedSessionId";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETSCHEME                   = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletActionRequest_getScheme";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETSERVERNAME               = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletActionRequest_getServerName";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETSERVERPORT               = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletActionRequest_getServerPort";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETSERVLETPATH              = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletActionRequest_getServletPath";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETSESSION                  = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletActionRequest_getSession";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETUSERPRINCIPAL            = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletActionRequest_getUserPrincipal";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_ISREQUESTEDSESSIONIDVALID   = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletActionRequest_isRequestedSessionIdValid";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_ISSECURE                    = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletActionRequest_isSecure";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_ISUSERINROLE                = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletActionRequest_isUserInRole";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_REMOVEATTRIBUTE             = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletActionRequest_removeAttribute";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_SETATTRIBUTE                = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletActionRequest_setAttribute";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONRESPONSE_CONTAINSHEADER             = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletActionResponse_containsHeader";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONRESPONSE_ENCODEREDIRECTURL1         = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletActionResponse_encodeRedirectURL1";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONRESPONSE_ENCODEREDIRECTURL          = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletActionResponse_encodeRedirectUrl";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONRESPONSE_ENCODEURL1                 = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletActionResponse_encodeURL1";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONRESPONSE_ENCODEURL                  = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletActionResponse_encodeUrl";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONRESPONSE_GETBUFFERSIZE              = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletActionResponse_getBufferSize";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONRESPONSE_GETCHARACTERENCODING       = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletActionResponse_getCharacterEncoding";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONRESPONSE_GETCONTENTTYPE             = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletActionResponse_getContentType";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONRESPONSE_GETLOCALE                  = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletActionResponse_getLocale";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONRESPONSE_ISCOMMITTED                = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletActionResponse_isCommitted";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETATTRIBUTE                 = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getAttribute";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETATTRIBUTENAMES            = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getAttributeNames";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETAUTHTYPE                  = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getAuthType";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETCHARACTERENCODING         = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getCharacterEncoding";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETCONTENTLENGTH             = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getContentLength";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETCONTENTTYPE               = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getContentType";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETCONTEXTPATH               = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getContextPath";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETCOOKIES                   = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getCookies";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETDATEHEADER                = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getDateHeader";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETHEADER                    = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getHeader";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETHEADERNAMES               = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getHeaderNames";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETHEADERS                   = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getHeaders";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETINPUTSTREAM               = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getInputStream";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETINTHEADER                 = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getIntHeader";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETLOCALADDR                 = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getLocalAddr";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETLOCALNAME                 = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getLocalName";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETLOCALPORT                 = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getLocalPort";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETLOCALE                    = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getLocale";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETLOCALES                   = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getLocales";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETMETHOD                    = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getMethod";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETPARAMETER                 = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getParameter";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETPARAMETERMAP              = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getParameterMap";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETPARAMETERNAMES            = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getParameterNames";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETPARAMETERVALUES           = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getParameterValues";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETPATHINFO                  = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getPathInfo";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETPATHTRANSLATED            = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getPathTranslated";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETPROTOCOL                  = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getProtocol";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETQUERYSTRING               = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getQueryString";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETREADER                    = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getReader";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETREALPATH                  = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getRealPath";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETREMOTEADDR                = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getRemoteAddr";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETREMOTEHOST                = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getRemoteHost";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETREMOTEPORT                = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getRemotePort";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETREMOTEUSER                = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getRemoteUser";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETREQUESTDISPATCHER         = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getRequestDispatcher";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETREQUESTURI                = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getRequestURI";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETREQUESTURL                = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getRequestURL";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETREQUESTEDSESSIONID        = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getRequestedSessionId";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETSCHEME                    = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getScheme";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETSERVERNAME                = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getServerName";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETSERVERPORT                = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getServerPort";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETSERVLETPATH               = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getServletPath";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETSESSION                   = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getSession";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETUSERPRINCIPAL             = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_getUserPrincipal";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_ISREQUESTEDSESSIONIDVALID    = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_isRequestedSessionIdValid";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_ISSECURE                     = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_isSecure";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_ISUSERINROLE                 = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_isUserInRole";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_REMOVEATTRIBUTE              = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_removeAttribute";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_SETATTRIBUTE                 = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventRequest_setAttribute";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTRESPONSE_CONTAINSHEADER              = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventResponse_containsHeader";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTRESPONSE_ENCODEREDIRECTURL1          = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventResponse_encodeRedirectURL1";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTRESPONSE_ENCODEREDIRECTURL           = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventResponse_encodeRedirectUrl";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTRESPONSE_ENCODEURL1                  = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventResponse_encodeURL1";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTRESPONSE_ENCODEURL                   = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventResponse_encodeUrl";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTRESPONSE_GETBUFFERSIZE               = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventResponse_getBufferSize";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTRESPONSE_GETCHARACTERENCODING        = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventResponse_getCharacterEncoding";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTRESPONSE_GETCONTENTTYPE              = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventResponse_getContentType";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTRESPONSE_GETLOCALE                   = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventResponse_getLocale";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTRESPONSE_ISCOMMITTED                 = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletEventResponse_isCommitted";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETATTRIBUTE                = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletRenderRequest_getAttribute";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETATTRIBUTENAMES           = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletRenderRequest_getAttributeNames";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETAUTHTYPE                 = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletRenderRequest_getAuthType";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETCHARACTERENCODING        = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletRenderRequest_getCharacterEncoding";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETCONTENTLENGTH            = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletRenderRequest_getContentLength";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETCONTENTTYPE              = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletRenderRequest_getContentType";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETCONTEXTPATH              = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletRenderRequest_getContextPath";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETCOOKIES                  = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletRenderRequest_getCookies";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETDATEHEADER               = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletRenderRequest_getDateHeader";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETHEADER                   = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletRenderRequest_getHeader";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETHEADERNAMES              = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletRenderRequest_getHeaderNames";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETHEADERS                  = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletRenderRequest_getHeaders";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETINPUTSTREAM              = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletRenderRequest_getInputStream";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETINTHEADER                = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletRenderRequest_getIntHeader";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETLOCALADDR                = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletRenderRequest_getLocalAddr";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETLOCALNAME                = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletRenderRequest_getLocalName";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETLOCALPORT                = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletRenderRequest_getLocalPort";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETLOCALE                   = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletRenderRequest_getLocale";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETLOCALES                  = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletRenderRequest_getLocales";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETMETHOD                   = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletRenderRequest_getMethod";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETPARAMETER                = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletRenderRequest_getParameter";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETPARAMETERMAP             = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletRenderRequest_getParameterMap";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETPARAMETERNAMES           = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletRenderRequest_getParameterNames";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETPARAMETERVALUES          = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletRenderRequest_getParameterValues";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETPATHINFO                 = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletRenderRequest_getPathInfo";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETPATHTRANSLATED           = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletRenderRequest_getPathTranslated";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETPROTOCOL                 = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletRenderRequest_getProtocol";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETQUERYSTRING              = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletRenderRequest_getQueryString";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETREADER                   = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletRenderRequest_getReader";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETREALPATH                 = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletRenderRequest_getRealPath";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETREMOTEADDR               = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletRenderRequest_getRemoteAddr";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETREMOTEHOST               = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletRenderRequest_getRemoteHost";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETREMOTEPORT               = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletRenderRequest_getRemotePort";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETREMOTEUSER               = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletRenderRequest_getRemoteUser";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETREQUESTDISPATCHER        = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletRenderRequest_getRequestDispatcher";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETREQUESTURI               = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletRenderRequest_getRequestURI";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETREQUESTURL               = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletRenderRequest_getRequestURL";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETREQUESTEDSESSIONID       = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletRenderRequest_getRequestedSessionId";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETSCHEME                   = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletRenderRequest_getScheme";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETSERVERNAME               = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletRenderRequest_getServerName";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETSERVERPORT               = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletRenderRequest_getServerPort";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETSERVLETPATH              = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletRenderRequest_getServletPath";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETSESSION                  = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletRenderRequest_getSession";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETUSERPRINCIPAL            = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletRenderRequest_getUserPrincipal";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_ISREQUESTEDSESSIONIDVALID   = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletRenderRequest_isRequestedSessionIdValid";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_ISSECURE                    = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletRenderRequest_isSecure";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_ISUSERINROLE                = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletRenderRequest_isUserInRole";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_REMOVEATTRIBUTE             = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletRenderRequest_removeAttribute";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_SETATTRIBUTE                = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletRenderRequest_setAttribute";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERRESPONSE_CONTAINSHEADER             = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletRenderResponse_containsHeader";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERRESPONSE_ENCODEREDIRECTURL1         = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletRenderResponse_encodeRedirectURL1";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERRESPONSE_ENCODEREDIRECTURL          = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletRenderResponse_encodeRedirectUrl";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERRESPONSE_ENCODEURL1                 = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletRenderResponse_encodeURL1";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERRESPONSE_ENCODEURL                  = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletRenderResponse_encodeUrl";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERRESPONSE_GETBUFFERSIZE              = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletRenderResponse_getBufferSize";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERRESPONSE_GETCHARACTERENCODING       = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletRenderResponse_getCharacterEncoding";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERRESPONSE_GETCONTENTTYPE             = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletRenderResponse_getContentType";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERRESPONSE_GETLOCALE                  = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletRenderResponse_getLocale";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERRESPONSE_ISCOMMITTED                = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletRenderResponse_isCommitted";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETATTRIBUTE              = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getAttribute";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETATTRIBUTENAMES         = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getAttributeNames";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETAUTHTYPE               = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getAuthType";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETCHARACTERENCODING      = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getCharacterEncoding";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETCONTENTLENGTH          = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getContentLength";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETCONTENTTYPE            = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getContentType";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETCONTEXTPATH            = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getContextPath";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETCOOKIES                = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getCookies";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETDATEHEADER             = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getDateHeader";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETHEADER                 = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getHeader";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETHEADERNAMES            = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getHeaderNames";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETHEADERS                = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getHeaders";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETINTHEADER              = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getIntHeader";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETLOCALADDR              = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getLocalAddr";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETLOCALNAME              = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getLocalName";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETLOCALPORT              = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getLocalPort";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETLOCALE                 = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getLocale";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETLOCALES                = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getLocales";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETMETHOD                 = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getMethod";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETPARAMETER              = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getParameter";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETPARAMETERMAP           = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getParameterMap";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETPARAMETERNAMES         = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getParameterNames";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETPARAMETERVALUES        = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getParameterValues";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETPATHINFO               = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getPathInfo";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETPATHTRANSLATED         = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getPathTranslated";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETPROTOCOL               = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getProtocol";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETQUERYSTRING            = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getQueryString";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETREALPATH               = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getRealPath";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETREMOTEADDR             = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getRemoteAddr";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETREMOTEHOST             = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getRemoteHost";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETREMOTEPORT             = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getRemotePort";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETREMOTEUSER             = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getRemoteUser";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETREQUESTDISPATCHER      = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getRequestDispatcher";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETREQUESTURI             = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getRequestURI";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETREQUESTURL             = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getRequestURL";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETREQUESTEDSESSIONID     = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getRequestedSessionId";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETSCHEME                 = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getScheme";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETSERVERNAME             = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getServerName";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETSERVERPORT             = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getServerPort";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETSERVLETPATH            = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getServletPath";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETSESSION                = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getSession";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETUSERPRINCIPAL          = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_getUserPrincipal";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_ISREQUESTEDSESSIONIDVALID = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_isRequestedSessionIdValid";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_ISSECURE                  = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_isSecure";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_ISUSERINROLE              = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_isUserInRole";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_REMOVEATTRIBUTE           = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_removeAttribute";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_SETATTRIBUTE              = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceRequest_setAttribute";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCERESPONSE_CONTAINSHEADER           = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceResponse_containsHeader";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCERESPONSE_ENCODEREDIRECTURL1       = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceResponse_encodeRedirectURL1";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCERESPONSE_ENCODEREDIRECTURL        = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceResponse_encodeRedirectUrl";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCERESPONSE_ENCODEURL1               = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceResponse_encodeURL1";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCERESPONSE_ENCODEURL                = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceResponse_encodeUrl";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCERESPONSE_GETBUFFERSIZE            = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceResponse_getBufferSize";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCERESPONSE_GETCHARACTERENCODING     = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceResponse_getCharacterEncoding";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCERESPONSE_GETCONTENTTYPE           = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceResponse_getContentType";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCERESPONSE_GETLOCALE                = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceResponse_getLocale";
   public final static String               V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCERESPONSE_ISCOMMITTED              = "V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceResponse_isCommitted";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDJSPACTIONREQUEST_GETINPUTSTREAM                 = "V2DispatcherReqRespTests5S_SPEC2_19_ForwardJSPActionRequest_getInputStream";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDJSPACTIONREQUEST_SETCHARACTERENCODING           = "V2DispatcherReqRespTests5S_SPEC2_19_ForwardJSPActionRequest_setCharacterEncoding";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDJSPACTIONRESPONSE_SENDREDIRECT                  = "V2DispatcherReqRespTests5S_SPEC2_19_ForwardJSPActionResponse_sendRedirect";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDJSPRENDERREQUEST_SETCHARACTERENCODING           = "V2DispatcherReqRespTests5S_SPEC2_19_ForwardJSPRenderRequest_setCharacterEncoding";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDJSPRENDERRESPONSE_GETOUTPUTSTREAM               = "V2DispatcherReqRespTests5S_SPEC2_19_ForwardJSPRenderResponse_getOutputStream";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDJSPRENDERRESPONSE_SENDERROR                     = "V2DispatcherReqRespTests5S_SPEC2_19_ForwardJSPRenderResponse_sendError";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDJSPRENDERRESPONSE_SENDREDIRECT                  = "V2DispatcherReqRespTests5S_SPEC2_19_ForwardJSPRenderResponse_sendRedirect";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDJSPRENDERRESPONSE_SETCHARACTERENCODING          = "V2DispatcherReqRespTests5S_SPEC2_19_ForwardJSPRenderResponse_setCharacterEncoding";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDJSPRENDERRESPONSE_SETCONTENTLENGTH              = "V2DispatcherReqRespTests5S_SPEC2_19_ForwardJSPRenderResponse_setContentLength";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDJSPRENDERRESPONSE_SETCONTENTTYPE                = "V2DispatcherReqRespTests5S_SPEC2_19_ForwardJSPRenderResponse_setContentType";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDJSPRENDERRESPONSE_SETLOCALE                     = "V2DispatcherReqRespTests5S_SPEC2_19_ForwardJSPRenderResponse_setLocale";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDJSPRENDERRESPONSE_SETSTATUS                     = "V2DispatcherReqRespTests5S_SPEC2_19_ForwardJSPRenderResponse_setStatus";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETINPUTSTREAM               = "V2DispatcherReqRespTests5S_SPEC2_19_ForwardJSPResourceRequest_getInputStream";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDJSPRESOURCEREQUEST_SETCHARACTERENCODING         = "V2DispatcherReqRespTests5S_SPEC2_19_ForwardJSPResourceRequest_setCharacterEncoding";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDJSPRESOURCERESPONSE_GETOUTPUTSTREAM             = "V2DispatcherReqRespTests5S_SPEC2_19_ForwardJSPResourceResponse_getOutputStream";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDJSPRESOURCERESPONSE_SENDERROR                   = "V2DispatcherReqRespTests5S_SPEC2_19_ForwardJSPResourceResponse_sendError";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDJSPRESOURCERESPONSE_SENDREDIRECT                = "V2DispatcherReqRespTests5S_SPEC2_19_ForwardJSPResourceResponse_sendRedirect";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDJSPRESOURCERESPONSE_SETCHARACTERENCODING        = "V2DispatcherReqRespTests5S_SPEC2_19_ForwardJSPResourceResponse_setCharacterEncoding";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDJSPRESOURCERESPONSE_SETCONTENTLENGTH            = "V2DispatcherReqRespTests5S_SPEC2_19_ForwardJSPResourceResponse_setContentLength";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDJSPRESOURCERESPONSE_SETCONTENTTYPE              = "V2DispatcherReqRespTests5S_SPEC2_19_ForwardJSPResourceResponse_setContentType";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDJSPRESOURCERESPONSE_SETLOCALE                   = "V2DispatcherReqRespTests5S_SPEC2_19_ForwardJSPResourceResponse_setLocale";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETINPUTSTREAM             = "V2DispatcherReqRespTests5S_SPEC2_19_ForwardServletActionRequest_getInputStream";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDSERVLETACTIONREQUEST_SETCHARACTERENCODING       = "V2DispatcherReqRespTests5S_SPEC2_19_ForwardServletActionRequest_setCharacterEncoding";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDSERVLETACTIONRESPONSE_SENDREDIRECT              = "V2DispatcherReqRespTests5S_SPEC2_19_ForwardServletActionResponse_sendRedirect";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDSERVLETRENDERREQUEST_SETCHARACTERENCODING       = "V2DispatcherReqRespTests5S_SPEC2_19_ForwardServletRenderRequest_setCharacterEncoding";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDSERVLETRENDERRESPONSE_GETOUTPUTSTREAM           = "V2DispatcherReqRespTests5S_SPEC2_19_ForwardServletRenderResponse_getOutputStream";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDSERVLETRENDERRESPONSE_SENDERROR                 = "V2DispatcherReqRespTests5S_SPEC2_19_ForwardServletRenderResponse_sendError";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDSERVLETRENDERRESPONSE_SENDREDIRECT              = "V2DispatcherReqRespTests5S_SPEC2_19_ForwardServletRenderResponse_sendRedirect";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDSERVLETRENDERRESPONSE_SETCHARACTERENCODING      = "V2DispatcherReqRespTests5S_SPEC2_19_ForwardServletRenderResponse_setCharacterEncoding";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDSERVLETRENDERRESPONSE_SETCONTENTLENGTH          = "V2DispatcherReqRespTests5S_SPEC2_19_ForwardServletRenderResponse_setContentLength";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDSERVLETRENDERRESPONSE_SETCONTENTTYPE            = "V2DispatcherReqRespTests5S_SPEC2_19_ForwardServletRenderResponse_setContentType";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDSERVLETRENDERRESPONSE_SETLOCALE                 = "V2DispatcherReqRespTests5S_SPEC2_19_ForwardServletRenderResponse_setLocale";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDSERVLETRENDERRESPONSE_SETSTATUS                 = "V2DispatcherReqRespTests5S_SPEC2_19_ForwardServletRenderResponse_setStatus";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETINPUTSTREAM           = "V2DispatcherReqRespTests5S_SPEC2_19_ForwardServletResourceRequest_getInputStream";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_SETCHARACTERENCODING     = "V2DispatcherReqRespTests5S_SPEC2_19_ForwardServletResourceRequest_setCharacterEncoding";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDSERVLETRESOURCERESPONSE_GETOUTPUTSTREAM         = "V2DispatcherReqRespTests5S_SPEC2_19_ForwardServletResourceResponse_getOutputStream";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDSERVLETRESOURCERESPONSE_SENDERROR               = "V2DispatcherReqRespTests5S_SPEC2_19_ForwardServletResourceResponse_sendError";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDSERVLETRESOURCERESPONSE_SENDREDIRECT            = "V2DispatcherReqRespTests5S_SPEC2_19_ForwardServletResourceResponse_sendRedirect";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDSERVLETRESOURCERESPONSE_SETCHARACTERENCODING    = "V2DispatcherReqRespTests5S_SPEC2_19_ForwardServletResourceResponse_setCharacterEncoding";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDSERVLETRESOURCERESPONSE_SETCONTENTLENGTH        = "V2DispatcherReqRespTests5S_SPEC2_19_ForwardServletResourceResponse_setContentLength";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDSERVLETRESOURCERESPONSE_SETCONTENTTYPE          = "V2DispatcherReqRespTests5S_SPEC2_19_ForwardServletResourceResponse_setContentType";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDSERVLETRESOURCERESPONSE_SETLOCALE               = "V2DispatcherReqRespTests5S_SPEC2_19_ForwardServletResourceResponse_setLocale";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETINPUTSTREAM                 = "V2DispatcherReqRespTests5S_SPEC2_19_IncludeJSPActionRequest_getInputStream";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDEJSPACTIONREQUEST_SETCHARACTERENCODING           = "V2DispatcherReqRespTests5S_SPEC2_19_IncludeJSPActionRequest_setCharacterEncoding";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDEJSPRENDERREQUEST_SETCHARACTERENCODING           = "V2DispatcherReqRespTests5S_SPEC2_19_IncludeJSPRenderRequest_setCharacterEncoding";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDEJSPRENDERRESPONSE_GETOUTPUTSTREAM               = "V2DispatcherReqRespTests5S_SPEC2_19_IncludeJSPRenderResponse_getOutputStream";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDEJSPRENDERRESPONSE_SENDERROR                     = "V2DispatcherReqRespTests5S_SPEC2_19_IncludeJSPRenderResponse_sendError";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDEJSPRENDERRESPONSE_SENDREDIRECT                  = "V2DispatcherReqRespTests5S_SPEC2_19_IncludeJSPRenderResponse_sendRedirect";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDEJSPRENDERRESPONSE_SETCHARACTERENCODING          = "V2DispatcherReqRespTests5S_SPEC2_19_IncludeJSPRenderResponse_setCharacterEncoding";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDEJSPRENDERRESPONSE_SETCONTENTLENGTH              = "V2DispatcherReqRespTests5S_SPEC2_19_IncludeJSPRenderResponse_setContentLength";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDEJSPRENDERRESPONSE_SETCONTENTTYPE                = "V2DispatcherReqRespTests5S_SPEC2_19_IncludeJSPRenderResponse_setContentType";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDEJSPRENDERRESPONSE_SETLOCALE                     = "V2DispatcherReqRespTests5S_SPEC2_19_IncludeJSPRenderResponse_setLocale";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDEJSPRENDERRESPONSE_SETSTATUS                     = "V2DispatcherReqRespTests5S_SPEC2_19_IncludeJSPRenderResponse_setStatus";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETINPUTSTREAM               = "V2DispatcherReqRespTests5S_SPEC2_19_IncludeJSPResourceRequest_getInputStream";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_SETCHARACTERENCODING         = "V2DispatcherReqRespTests5S_SPEC2_19_IncludeJSPResourceRequest_setCharacterEncoding";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDEJSPRESOURCERESPONSE_GETOUTPUTSTREAM             = "V2DispatcherReqRespTests5S_SPEC2_19_IncludeJSPResourceResponse_getOutputStream";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDEJSPRESOURCERESPONSE_SENDERROR                   = "V2DispatcherReqRespTests5S_SPEC2_19_IncludeJSPResourceResponse_sendError";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDEJSPRESOURCERESPONSE_SENDREDIRECT                = "V2DispatcherReqRespTests5S_SPEC2_19_IncludeJSPResourceResponse_sendRedirect";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDEJSPRESOURCERESPONSE_SETCHARACTERENCODING        = "V2DispatcherReqRespTests5S_SPEC2_19_IncludeJSPResourceResponse_setCharacterEncoding";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDEJSPRESOURCERESPONSE_SETCONTENTLENGTH            = "V2DispatcherReqRespTests5S_SPEC2_19_IncludeJSPResourceResponse_setContentLength";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDEJSPRESOURCERESPONSE_SETCONTENTTYPE              = "V2DispatcherReqRespTests5S_SPEC2_19_IncludeJSPResourceResponse_setContentType";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDEJSPRESOURCERESPONSE_SETLOCALE                   = "V2DispatcherReqRespTests5S_SPEC2_19_IncludeJSPResourceResponse_setLocale";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDEJSPRESOURCERESPONSE_SETSTATUS                   = "V2DispatcherReqRespTests5S_SPEC2_19_IncludeJSPResourceResponse_setStatus";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETINPUTSTREAM             = "V2DispatcherReqRespTests5S_SPEC2_19_IncludeServletActionRequest_getInputStream";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDESERVLETACTIONREQUEST_SETCHARACTERENCODING       = "V2DispatcherReqRespTests5S_SPEC2_19_IncludeServletActionRequest_setCharacterEncoding";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDESERVLETRENDERREQUEST_SETCHARACTERENCODING       = "V2DispatcherReqRespTests5S_SPEC2_19_IncludeServletRenderRequest_setCharacterEncoding";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDESERVLETRENDERRESPONSE_GETOUTPUTSTREAM           = "V2DispatcherReqRespTests5S_SPEC2_19_IncludeServletRenderResponse_getOutputStream";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDESERVLETRENDERRESPONSE_SENDERROR                 = "V2DispatcherReqRespTests5S_SPEC2_19_IncludeServletRenderResponse_sendError";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDESERVLETRENDERRESPONSE_SENDREDIRECT              = "V2DispatcherReqRespTests5S_SPEC2_19_IncludeServletRenderResponse_sendRedirect";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDESERVLETRENDERRESPONSE_SETCHARACTERENCODING      = "V2DispatcherReqRespTests5S_SPEC2_19_IncludeServletRenderResponse_setCharacterEncoding";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDESERVLETRENDERRESPONSE_SETCONTENTLENGTH          = "V2DispatcherReqRespTests5S_SPEC2_19_IncludeServletRenderResponse_setContentLength";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDESERVLETRENDERRESPONSE_SETCONTENTTYPE            = "V2DispatcherReqRespTests5S_SPEC2_19_IncludeServletRenderResponse_setContentType";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDESERVLETRENDERRESPONSE_SETLOCALE                 = "V2DispatcherReqRespTests5S_SPEC2_19_IncludeServletRenderResponse_setLocale";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDESERVLETRENDERRESPONSE_SETSTATUS                 = "V2DispatcherReqRespTests5S_SPEC2_19_IncludeServletRenderResponse_setStatus";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETINPUTSTREAM           = "V2DispatcherReqRespTests5S_SPEC2_19_IncludeServletResourceRequest_getInputStream";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_SETCHARACTERENCODING     = "V2DispatcherReqRespTests5S_SPEC2_19_IncludeServletResourceRequest_setCharacterEncoding";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDESERVLETRESOURCERESPONSE_GETOUTPUTSTREAM         = "V2DispatcherReqRespTests5S_SPEC2_19_IncludeServletResourceResponse_getOutputStream";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDESERVLETRESOURCERESPONSE_SENDERROR               = "V2DispatcherReqRespTests5S_SPEC2_19_IncludeServletResourceResponse_sendError";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDESERVLETRESOURCERESPONSE_SENDREDIRECT            = "V2DispatcherReqRespTests5S_SPEC2_19_IncludeServletResourceResponse_sendRedirect";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDESERVLETRESOURCERESPONSE_SETCHARACTERENCODING    = "V2DispatcherReqRespTests5S_SPEC2_19_IncludeServletResourceResponse_setCharacterEncoding";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDESERVLETRESOURCERESPONSE_SETCONTENTLENGTH        = "V2DispatcherReqRespTests5S_SPEC2_19_IncludeServletResourceResponse_setContentLength";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDESERVLETRESOURCERESPONSE_SETCONTENTTYPE          = "V2DispatcherReqRespTests5S_SPEC2_19_IncludeServletResourceResponse_setContentType";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDESERVLETRESOURCERESPONSE_SETLOCALE               = "V2DispatcherReqRespTests5S_SPEC2_19_IncludeServletResourceResponse_setLocale";
   public final static String               V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDESERVLETRESOURCERESPONSE_SETSTATUS               = "V2DispatcherReqRespTests5S_SPEC2_19_IncludeServletResourceResponse_setStatus";

   private final static Map<String, String> tcd                                                                                        = new HashMap<String, String>();
   static {

      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETATTRIBUTE,
            "In a target jsp of a forward in the Action phase, the method HttpServletRequest.getAttribute must provide the same functionality as ActionRequest.getAttribute");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETATTRIBUTENAMES,
            "In a target jsp of a forward in the Action phase, the method HttpServletRequest.getAttributeNames must provide the same functionality as ActionRequest.getAttributeNames");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETAUTHTYPE,
            "In a target jsp of a forward in the Action phase, the method HttpServletRequest.getAuthType must provide the same functionality as ActionRequest.getAuthType");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETCHARACTERENCODING,
            "In a target jsp of a forward in the Action phase, the method HttpServletRequest.getCharacterEncoding must provide the same functionality as ActionRequest.getCharacterEncoding");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETCONTENTLENGTH,
            "In a target jsp of a forward in the Action phase, the method HttpServletRequest.getContentLength must provide the same functionality as ActionRequest.getContentLength");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETCONTENTTYPE,
            "In a target jsp of a forward in the Action phase, the method HttpServletRequest.getContentType must provide the same functionality as ActionRequest.getContentType");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETCONTEXTPATH,
            "In a target jsp of a forward in the Action phase, the method HttpServletRequest.getContextPath must provide the same functionality as ActionRequest.getContextPath");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETCOOKIES,
            "In a target jsp of a forward in the Action phase, the method HttpServletRequest.getCookies must provide the same functionality as ActionRequest.getCookies");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETDATEHEADER,
            "In a target jsp of a forward in the Action phase, the method HttpServletRequest.getDateHeader must return a value corresponding to that returned by ActionRequest.getProperty for the corresponding header name");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETHEADER,
            "In a target jsp of a forward in the Action phase, the method HttpServletRequest.getHeader must return a value corresponding to that returned by ActionRequest.getProperty for the corresponding header name");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETHEADERNAMES,
            "In a target jsp of a forward in the Action phase, the Enumeration returned by HttpServletRequest.getHeaderNames must be contained in the Enumeration returned by ActionRequest.getPropertyNames");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETHEADERS,
            "In a target jsp of a forward in the Action phase, the method HttpServletRequest.getHeaders must return a value corresponding to that returned by ActionRequest.getProperties for the corresponding header name");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETINTHEADER,
            "In a target jsp of a forward in the Action phase, the method HttpServletRequest.getIntHeader must return a value corresponding to that returned by ActionRequest.getProperty for the corresponding header name");
      tcd.put(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETLOCALADDR,
            "In a target jsp of a forward in the Action phase, the method HttpServletRequest.getLocalAddr must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETLOCALNAME,
            "In a target jsp of a forward in the Action phase, the method HttpServletRequest.getLocalName must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETLOCALPORT,
            "In a target jsp of a forward in the Action phase, the method HttpServletRequest.getLocalPort must return 0");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETLOCALE,
            "In a target jsp of a forward in the Action phase, the method HttpServletRequest.getLocale must provide the same functionality as ActionRequest.getLocale");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETLOCALES,
            "In a target jsp of a forward in the Action phase, the method HttpServletRequest.getLocales must provide the same functionality as ActionRequest.getLocales");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETMETHOD,
            "In a target jsp of a forward in the Action phase, the method HttpServletRequest.getMethod must provide the same functionality as ActionRequest.getMethod");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETPARAMETER,
            "In a target jsp of a forward in the Action phase, the method HttpServletRequest.getParameter must provide the same functionality as ActionRequest.getParameter");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETPARAMETERMAP,
            "In a target jsp of a forward in the Action phase, the method HttpServletRequest.getParameterMap must provide the same functionality as ActionRequest.getParameterMap");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETPARAMETERNAMES,
            "In a target jsp of a forward in the Action phase, the method HttpServletRequest.getParameterNames must provide the same functionality as ActionRequest.getParameterNames");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETPARAMETERVALUES,
            "In a target jsp of a forward in the Action phase, the method HttpServletRequest.getParameterValues must provide the same functionality as ActionRequest.getParameterValues");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETPATHINFO,
            "In a target jsp of a forward in the Action phase, the method HttpServletRequest.getPathInfo must a value corresponding to the path used to obtain the PortletRequestDispatcher");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETPATHTRANSLATED,
            "In a target jsp of a forward in the Action phase, the method HttpServletRequest.getPathTranslated must a value corresponding to the path used to obtain the PortletRequestDispatcher");
      tcd.put(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETPROTOCOL,
            "In a target jsp of a forward in the Action phase, the method HttpServletRequest.getProtocol must return \"HTTP/1.1\"");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETQUERYSTRING,
            "In a target jsp of a forward in the Action phase, the method HttpServletRequest.getQueryString must a value corresponding to the query string information used to obtain the PortletRequestDispatcher");
      tcd.put(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETREALPATH,
            "In a target jsp of a forward in the Action phase, the method HttpServletRequest.getRealPath must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETREMOTEADDR,
            "In a target jsp of a forward in the Action phase, the method HttpServletRequest.getRemoteAddr must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETREMOTEHOST,
            "In a target jsp of a forward in the Action phase, the method HttpServletRequest.getRemoteHost must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETREMOTEPORT,
            "In a target jsp of a forward in the Action phase, the method HttpServletRequest.getRemotePort must return 0");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETREMOTEUSER,
            "In a target jsp of a forward in the Action phase, the method HttpServletRequest.getRemoteUser must provide the same functionality as ActionRequest.getRemoteUser");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETREQUESTDISPATCHER,
            "In a target jsp of a forward in the Action phase, the method HttpServletRequest.getRequestDispatcher must provide functionality as defined in the servlet specification");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETREQUESTURI,
            "In a target jsp of a forward in the Action phase, the method HttpServletRequest.getRequestURI must a value corresponding to the path and query string information used to obtain the PortletRequestDispatcher");
      tcd.put(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETREQUESTURL,
            "In a target jsp of a forward in the Action phase, the method HttpServletRequest.getRequestURL must return null");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETREQUESTEDSESSIONID,
            "In a target jsp of a forward in the Action phase, the method HttpServletRequest.getRequestedSessionId must provide the same functionality as ActionRequest.getRequestedSessionId");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETSCHEME,
            "In a target jsp of a forward in the Action phase, the method HttpServletRequest.getScheme must provide the same functionality as ActionRequest.getScheme");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETSERVERNAME,
            "In a target jsp of a forward in the Action phase, the method HttpServletRequest.getServerName must provide the same functionality as ActionRequest.getServerName");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETSERVERPORT,
            "In a target jsp of a forward in the Action phase, the method HttpServletRequest.getServerPort must provide the same functionality as ActionRequest.getServerPort");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETSERVLETPATH,
            "In a target jsp of a forward in the Action phase, the method HttpServletRequest.getServletPath must a value corresponding to the path used to obtain the PortletRequestDispatcher");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETSESSION,
            "In a target jsp of a forward in the Action phase, the method HttpServletRequest.getSession must provide the same functionality as ActionRequest.getPortletSession(APPLICATION_SCOPE)");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETUSERPRINCIPAL,
            "In a target jsp of a forward in the Action phase, the method HttpServletRequest.getUserPrincipal must provide the same functionality as ActionRequest.getUserPrincipal");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_ISREQUESTEDSESSIONIDVALID,
            "In a target jsp of a forward in the Action phase, the method HttpServletRequest.isRequestedSessionIdValid must provide the same functionality as ActionRequest.isRequestedSessionIdValid");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_ISSECURE,
            "In a target jsp of a forward in the Action phase, the method HttpServletRequest.isSecure must provide the same functionality as ActionRequest.isSecure");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_ISUSERINROLE,
            "In a target jsp of a forward in the Action phase, the method HttpServletRequest.isUserInRole must provide the same functionality as ActionRequest.isUserInRole");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_REMOVEATTRIBUTE,
            "In a target jsp of a forward in the Action phase, the method HttpServletRequest.removeAttribute must provide the same functionality as ActionRequest.removeAttribute");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_SETATTRIBUTE,
            "In a target jsp of a forward in the Action phase, the method HttpServletRequest.setAttribute must provide the same functionality as ActionRequest.setAttribute");
      tcd.put(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONRESPONSE_CONTAINSHEADER,
            "In a target jsp of a forward in the Action phase, the method HttpServletResponse.containsHeader must return false");
      tcd.put(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONRESPONSE_ENCODEREDIRECTURL1,
            "In a target jsp of a forward in the Action phase, the method HttpServletResponse.encodeRedirectURL must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONRESPONSE_ENCODEREDIRECTURL,
            "In a target jsp of a forward in the Action phase, the method HttpServletResponse.encodeRedirectUrl must return null");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONRESPONSE_ENCODEURL1,
            "In a target jsp of a forward in the Action phase, the method HttpServletResponse.encodeURL must provide the same functionality as ActionResponse.encodeURL");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONRESPONSE_ENCODEURL,
            "In a target jsp of a forward in the Action phase, the method HttpServletResponse.encodeUrl must provide the same functionality as ActionResponse.encodeURL");
      tcd.put(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONRESPONSE_GETBUFFERSIZE,
            "In a target jsp of a forward in the Action phase, the method HttpServletResponse.getBufferSize must return 0");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONRESPONSE_GETCHARACTERENCODING,
            "In a target jsp of a forward in the Action phase, the method HttpServletResponse.getCharacterEncoding must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONRESPONSE_GETCONTENTTYPE,
            "In a target jsp of a forward in the Action phase, the method HttpServletResponse.getContentType must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONRESPONSE_GETLOCALE,
            "In a target jsp of a forward in the Action phase, the method HttpServletResponse.getLocale must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONRESPONSE_ISCOMMITTED,
            "In a target jsp of a forward in the Action phase, the method HttpServletResponse.isCommitted must return false");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETATTRIBUTE,
            "In a target jsp of a forward in the Event phase, the method HttpServletRequest.getAttribute must provide the same functionality as EventRequest.getAttribute");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETATTRIBUTENAMES,
            "In a target jsp of a forward in the Event phase, the method HttpServletRequest.getAttributeNames must provide the same functionality as EventRequest.getAttributeNames");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETAUTHTYPE,
            "In a target jsp of a forward in the Event phase, the method HttpServletRequest.getAuthType must provide the same functionality as EventRequest.getAuthType");
      tcd.put(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETCHARACTERENCODING,
            "In a target jsp of a forward in the Event phase, the method HttpServletRequest.getCharacterEncoding must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETCONTENTLENGTH,
            "In a target jsp of a forward in the Event phase, the method HttpServletRequest.getContentLength must return 0");
      tcd.put(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETCONTENTTYPE,
            "In a target jsp of a forward in the Event phase, the method HttpServletRequest.getContentType must return null");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETCONTEXTPATH,
            "In a target jsp of a forward in the Event phase, the method HttpServletRequest.getContextPath must provide the same functionality as EventRequest.getContextPath");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETCOOKIES,
            "In a target jsp of a forward in the Event phase, the method HttpServletRequest.getCookies must provide the same functionality as EventRequest.getCookies");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETDATEHEADER,
            "In a target jsp of a forward in the Event phase, the method HttpServletRequest.getDateHeader must return a value corresponding to that returned by EventRequest.getProperty for the corresponding header name");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETHEADER,
            "In a target jsp of a forward in the Event phase, the method HttpServletRequest.getHeader must return a value corresponding to that returned by EventRequest.getProperty for the corresponding header name");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETHEADERNAMES,
            "In a target jsp of a forward in the Event phase, the Enumeration returned by HttpServletRequest.getHeaderNames must be contained in the Enumeration returned by EventRequest.getPropertyNames");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETHEADERS,
            "In a target jsp of a forward in the Event phase, the method HttpServletRequest.getHeaders must return a value corresponding to that returned by EventRequest.getProperties for the corresponding header name");
      tcd.put(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETINPUTSTREAM,
            "In a target jsp of a forward in the Event phase, the method HttpServletRequest.getInputStream must return null");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETINTHEADER,
            "In a target jsp of a forward in the Event phase, the method HttpServletRequest.getIntHeader must return a value corresponding to that returned by EventRequest.getProperty for the corresponding header name");
      tcd.put(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETLOCALADDR,
            "In a target jsp of a forward in the Event phase, the method HttpServletRequest.getLocalAddr must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETLOCALNAME,
            "In a target jsp of a forward in the Event phase, the method HttpServletRequest.getLocalName must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETLOCALPORT,
            "In a target jsp of a forward in the Event phase, the method HttpServletRequest.getLocalPort must return 0");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETLOCALE,
            "In a target jsp of a forward in the Event phase, the method HttpServletRequest.getLocale must provide the same functionality as EventRequest.getLocale");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETLOCALES,
            "In a target jsp of a forward in the Event phase, the method HttpServletRequest.getLocales must provide the same functionality as EventRequest.getLocales");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETMETHOD,
            "In a target jsp of a forward in the Event phase, the method HttpServletRequest.getMethod must provide the same functionality as EventRequest.getMethod");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETPARAMETER,
            "In a target jsp of a forward in the Event phase, the method HttpServletRequest.getParameter must provide the same functionality as EventRequest.getParameter");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETPARAMETERMAP,
            "In a target jsp of a forward in the Event phase, the method HttpServletRequest.getParameterMap must provide the same functionality as EventRequest.getParameterMap");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETPARAMETERNAMES,
            "In a target jsp of a forward in the Event phase, the method HttpServletRequest.getParameterNames must provide the same functionality as EventRequest.getParameterNames");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETPARAMETERVALUES,
            "In a target jsp of a forward in the Event phase, the method HttpServletRequest.getParameterValues must provide the same functionality as EventRequest.getParameterValues");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETPATHINFO,
            "In a target jsp of a forward in the Event phase, the method HttpServletRequest.getPathInfo must a value corresponding to the path used to obtain the PortletRequestDispatcher");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETPATHTRANSLATED,
            "In a target jsp of a forward in the Event phase, the method HttpServletRequest.getPathTranslated must a value corresponding to the path used to obtain the PortletRequestDispatcher");
      tcd.put(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETPROTOCOL,
            "In a target jsp of a forward in the Event phase, the method HttpServletRequest.getProtocol must return \"HTTP/1.1\"");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETQUERYSTRING,
            "In a target jsp of a forward in the Event phase, the method HttpServletRequest.getQueryString must a value corresponding to the query string information used to obtain the PortletRequestDispatcher");
      tcd.put(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETREADER,
            "In a target jsp of a forward in the Event phase, the method HttpServletRequest.getReader must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETREALPATH,
            "In a target jsp of a forward in the Event phase, the method HttpServletRequest.getRealPath must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETREMOTEADDR,
            "In a target jsp of a forward in the Event phase, the method HttpServletRequest.getRemoteAddr must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETREMOTEHOST,
            "In a target jsp of a forward in the Event phase, the method HttpServletRequest.getRemoteHost must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETREMOTEPORT,
            "In a target jsp of a forward in the Event phase, the method HttpServletRequest.getRemotePort must return 0");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETREMOTEUSER,
            "In a target jsp of a forward in the Event phase, the method HttpServletRequest.getRemoteUser must provide the same functionality as EventRequest.getRemoteUser");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETREQUESTDISPATCHER,
            "In a target jsp of a forward in the Event phase, the method HttpServletRequest.getRequestDispatcher must provide functionality as defined in the servlet specification");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETREQUESTURI,
            "In a target jsp of a forward in the Event phase, the method HttpServletRequest.getRequestURI must a value corresponding to the path and query string information used to obtain the PortletRequestDispatcher");
      tcd.put(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETREQUESTURL,
            "In a target jsp of a forward in the Event phase, the method HttpServletRequest.getRequestURL must return null");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETREQUESTEDSESSIONID,
            "In a target jsp of a forward in the Event phase, the method HttpServletRequest.getRequestedSessionId must provide the same functionality as EventRequest.getRequestedSessionId");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETSCHEME,
            "In a target jsp of a forward in the Event phase, the method HttpServletRequest.getScheme must provide the same functionality as EventRequest.getScheme");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETSERVERNAME,
            "In a target jsp of a forward in the Event phase, the method HttpServletRequest.getServerName must provide the same functionality as EventRequest.getServerName");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETSERVERPORT,
            "In a target jsp of a forward in the Event phase, the method HttpServletRequest.getServerPort must provide the same functionality as EventRequest.getServerPort");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETSERVLETPATH,
            "In a target jsp of a forward in the Event phase, the method HttpServletRequest.getServletPath must a value corresponding to the path used to obtain the PortletRequestDispatcher");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETSESSION,
            "In a target jsp of a forward in the Event phase, the method HttpServletRequest.getSession must provide the same functionality as EventRequest.getPortletSession(APPLICATION_SCOPE)");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_GETUSERPRINCIPAL,
            "In a target jsp of a forward in the Event phase, the method HttpServletRequest.getUserPrincipal must provide the same functionality as EventRequest.getUserPrincipal");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_ISREQUESTEDSESSIONIDVALID,
            "In a target jsp of a forward in the Event phase, the method HttpServletRequest.isRequestedSessionIdValid must provide the same functionality as EventRequest.isRequestedSessionIdValid");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_ISSECURE,
            "In a target jsp of a forward in the Event phase, the method HttpServletRequest.isSecure must provide the same functionality as EventRequest.isSecure");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_ISUSERINROLE,
            "In a target jsp of a forward in the Event phase, the method HttpServletRequest.isUserInRole must provide the same functionality as EventRequest.isUserInRole");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_REMOVEATTRIBUTE,
            "In a target jsp of a forward in the Event phase, the method HttpServletRequest.removeAttribute must provide the same functionality as EventRequest.removeAttribute");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTREQUEST_SETATTRIBUTE,
            "In a target jsp of a forward in the Event phase, the method HttpServletRequest.setAttribute must provide the same functionality as EventRequest.setAttribute");
      tcd.put(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTRESPONSE_CONTAINSHEADER,
            "In a target jsp of a forward in the Event phase, the method HttpServletResponse.containsHeader must return false");
      tcd.put(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTRESPONSE_ENCODEREDIRECTURL1,
            "In a target jsp of a forward in the Event phase, the method HttpServletResponse.encodeRedirectURL must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTRESPONSE_ENCODEREDIRECTURL,
            "In a target jsp of a forward in the Event phase, the method HttpServletResponse.encodeRedirectUrl must return null");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTRESPONSE_ENCODEURL1,
            "In a target jsp of a forward in the Event phase, the method HttpServletResponse.encodeURL must provide the same functionality as EventResponse.encodeURL");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTRESPONSE_ENCODEURL,
            "In a target jsp of a forward in the Event phase, the method HttpServletResponse.encodeUrl must provide the same functionality as EventResponse.encodeURL");
      tcd.put(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTRESPONSE_GETBUFFERSIZE,
            "In a target jsp of a forward in the Event phase, the method HttpServletResponse.getBufferSize must return 0");
      tcd.put(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTRESPONSE_GETCHARACTERENCODING,
            "In a target jsp of a forward in the Event phase, the method HttpServletResponse.getCharacterEncoding must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTRESPONSE_GETCONTENTTYPE,
            "In a target jsp of a forward in the Event phase, the method HttpServletResponse.getContentType must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTRESPONSE_GETLOCALE,
            "In a target jsp of a forward in the Event phase, the method HttpServletResponse.getLocale must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPEVENTRESPONSE_ISCOMMITTED,
            "In a target jsp of a forward in the Event phase, the method HttpServletResponse.isCommitted must return false");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETATTRIBUTE,
            "In a target jsp of a forward in the Render phase, the method HttpServletRequest.getAttribute must provide the same functionality as RenderRequest.getAttribute");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETATTRIBUTENAMES,
            "In a target jsp of a forward in the Render phase, the method HttpServletRequest.getAttributeNames must provide the same functionality as RenderRequest.getAttributeNames");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETAUTHTYPE,
            "In a target jsp of a forward in the Render phase, the method HttpServletRequest.getAuthType must provide the same functionality as RenderRequest.getAuthType");
      tcd.put(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETCHARACTERENCODING,
            "In a target jsp of a forward in the Render phase, the method HttpServletRequest.getCharacterEncoding must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETCONTENTLENGTH,
            "In a target jsp of a forward in the Render phase, the method HttpServletRequest.getContentLength must return 0");
      tcd.put(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETCONTENTTYPE,
            "In a target jsp of a forward in the Render phase, the method HttpServletRequest.getContentType must return null");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETCONTEXTPATH,
            "In a target jsp of a forward in the Render phase, the method HttpServletRequest.getContextPath must provide the same functionality as RenderRequest.getContextPath");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETCOOKIES,
            "In a target jsp of a forward in the Render phase, the method HttpServletRequest.getCookies must provide the same functionality as RenderRequest.getCookies");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETDATEHEADER,
            "In a target jsp of a forward in the Render phase, the method HttpServletRequest.getDateHeader must return a value corresponding to that returned by RenderRequest.getProperty for the corresponding header name");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETHEADER,
            "In a target jsp of a forward in the Render phase, the method HttpServletRequest.getHeader must return a value corresponding to that returned by RenderRequest.getProperty for the corresponding header name");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETHEADERNAMES,
            "In a target jsp of a forward in the Render phase, the Enumeration returned by HttpServletRequest.getHeaderNames must be contained in the Enumeration returned by RenderRequest.getPropertyNames");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETHEADERS,
            "In a target jsp of a forward in the Render phase, the method HttpServletRequest.getHeaders must return a value corresponding to that returned by RenderRequest.getProperties for the corresponding header name");
      tcd.put(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETINPUTSTREAM,
            "In a target jsp of a forward in the Render phase, the method HttpServletRequest.getInputStream must return null");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETINTHEADER,
            "In a target jsp of a forward in the Render phase, the method HttpServletRequest.getIntHeader must return a value corresponding to that returned by RenderRequest.getProperty for the corresponding header name");
      tcd.put(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETLOCALADDR,
            "In a target jsp of a forward in the Render phase, the method HttpServletRequest.getLocalAddr must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETLOCALNAME,
            "In a target jsp of a forward in the Render phase, the method HttpServletRequest.getLocalName must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETLOCALPORT,
            "In a target jsp of a forward in the Render phase, the method HttpServletRequest.getLocalPort must return 0");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETLOCALE,
            "In a target jsp of a forward in the Render phase, the method HttpServletRequest.getLocale must provide the same functionality as RenderRequest.getLocale");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETLOCALES,
            "In a target jsp of a forward in the Render phase, the method HttpServletRequest.getLocales must provide the same functionality as RenderRequest.getLocales");
      tcd.put(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETMETHOD,
            "In a target jsp of a forward in the Render phase, the method HttpServletRequest.getMethod must return \"GET\"");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETPARAMETER,
            "In a target jsp of a forward in the Render phase, the method HttpServletRequest.getParameter must provide the same functionality as RenderRequest.getParameter");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETPARAMETERMAP,
            "In a target jsp of a forward in the Render phase, the method HttpServletRequest.getParameterMap must provide the same functionality as RenderRequest.getParameterMap");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETPARAMETERNAMES,
            "In a target jsp of a forward in the Render phase, the method HttpServletRequest.getParameterNames must provide the same functionality as RenderRequest.getParameterNames");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETPARAMETERVALUES,
            "In a target jsp of a forward in the Render phase, the method HttpServletRequest.getParameterValues must provide the same functionality as RenderRequest.getParameterValues");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETPATHINFO,
            "In a target jsp of a forward in the Render phase, the method HttpServletRequest.getPathInfo must a value corresponding to the path used to obtain the PortletRequestDispatcher");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETPATHTRANSLATED,
            "In a target jsp of a forward in the Render phase, the method HttpServletRequest.getPathTranslated must a value corresponding to the path used to obtain the PortletRequestDispatcher");
      tcd.put(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETPROTOCOL,
            "In a target jsp of a forward in the Render phase, the method HttpServletRequest.getProtocol must return \"HTTP/1.1\"");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETQUERYSTRING,
            "In a target jsp of a forward in the Render phase, the method HttpServletRequest.getQueryString must a value corresponding to the query string information used to obtain the PortletRequestDispatcher");
      tcd.put(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETREADER,
            "In a target jsp of a forward in the Render phase, the method HttpServletRequest.getReader must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETREALPATH,
            "In a target jsp of a forward in the Render phase, the method HttpServletRequest.getRealPath must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETREMOTEADDR,
            "In a target jsp of a forward in the Render phase, the method HttpServletRequest.getRemoteAddr must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETREMOTEHOST,
            "In a target jsp of a forward in the Render phase, the method HttpServletRequest.getRemoteHost must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETREMOTEPORT,
            "In a target jsp of a forward in the Render phase, the method HttpServletRequest.getRemotePort must return 0");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETREMOTEUSER,
            "In a target jsp of a forward in the Render phase, the method HttpServletRequest.getRemoteUser must provide the same functionality as RenderRequest.getRemoteUser");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETREQUESTDISPATCHER,
            "In a target jsp of a forward in the Render phase, the method HttpServletRequest.getRequestDispatcher must provide functionality as defined in the servlet specification");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETREQUESTURI,
            "In a target jsp of a forward in the Render phase, the method HttpServletRequest.getRequestURI must a value corresponding to the path and query string information used to obtain the PortletRequestDispatcher");
      tcd.put(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETREQUESTURL,
            "In a target jsp of a forward in the Render phase, the method HttpServletRequest.getRequestURL must return null");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETREQUESTEDSESSIONID,
            "In a target jsp of a forward in the Render phase, the method HttpServletRequest.getRequestedSessionId must provide the same functionality as RenderRequest.getRequestedSessionId");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETSCHEME,
            "In a target jsp of a forward in the Render phase, the method HttpServletRequest.getScheme must provide the same functionality as RenderRequest.getScheme");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETSERVERNAME,
            "In a target jsp of a forward in the Render phase, the method HttpServletRequest.getServerName must provide the same functionality as RenderRequest.getServerName");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETSERVERPORT,
            "In a target jsp of a forward in the Render phase, the method HttpServletRequest.getServerPort must provide the same functionality as RenderRequest.getServerPort");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETSERVLETPATH,
            "In a target jsp of a forward in the Render phase, the method HttpServletRequest.getServletPath must a value corresponding to the path used to obtain the PortletRequestDispatcher");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETSESSION,
            "In a target jsp of a forward in the Render phase, the method HttpServletRequest.getSession must provide the same functionality as RenderRequest.getPortletSession(APPLICATION_SCOPE)");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_GETUSERPRINCIPAL,
            "In a target jsp of a forward in the Render phase, the method HttpServletRequest.getUserPrincipal must provide the same functionality as RenderRequest.getUserPrincipal");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_ISREQUESTEDSESSIONIDVALID,
            "In a target jsp of a forward in the Render phase, the method HttpServletRequest.isRequestedSessionIdValid must provide the same functionality as RenderRequest.isRequestedSessionIdValid");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_ISSECURE,
            "In a target jsp of a forward in the Render phase, the method HttpServletRequest.isSecure must provide the same functionality as RenderRequest.isSecure");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_ISUSERINROLE,
            "In a target jsp of a forward in the Render phase, the method HttpServletRequest.isUserInRole must provide the same functionality as RenderRequest.isUserInRole");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_REMOVEATTRIBUTE,
            "In a target jsp of a forward in the Render phase, the method HttpServletRequest.removeAttribute must provide the same functionality as RenderRequest.removeAttribute");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERREQUEST_SETATTRIBUTE,
            "In a target jsp of a forward in the Render phase, the method HttpServletRequest.setAttribute must provide the same functionality as RenderRequest.setAttribute");
      tcd.put(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERRESPONSE_CONTAINSHEADER,
            "In a target jsp of a forward in the Render phase, the method HttpServletResponse.containsHeader must return false");
      tcd.put(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERRESPONSE_ENCODEREDIRECTURL1,
            "In a target jsp of a forward in the Render phase, the method HttpServletResponse.encodeRedirectURL must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERRESPONSE_ENCODEREDIRECTURL,
            "In a target jsp of a forward in the Render phase, the method HttpServletResponse.encodeRedirectUrl must return null");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERRESPONSE_ENCODEURL1,
            "In a target jsp of a forward in the Render phase, the method HttpServletResponse.encodeURL must provide the same functionality as RenderResponse.encodeURL");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERRESPONSE_ENCODEURL,
            "In a target jsp of a forward in the Render phase, the method HttpServletResponse.encodeUrl must provide the same functionality as RenderResponse.encodeURL");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERRESPONSE_GETBUFFERSIZE,
            "In a target jsp of a forward in the Render phase, the method HttpServletResponse.getBufferSize must provide the same functionality as RenderResponse.getBufferSize");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERRESPONSE_GETCHARACTERENCODING,
            "In a target jsp of a forward in the Render phase, the method HttpServletResponse.getCharacterEncoding must provide the same functionality as RenderResponse.getCharacterEncoding");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERRESPONSE_GETCONTENTTYPE,
            "In a target jsp of a forward in the Render phase, the method HttpServletResponse.getContentType must provide the same functionality as RenderResponse.getContentType");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERRESPONSE_GETLOCALE,
            "In a target jsp of a forward in the Render phase, the method HttpServletResponse.getLocale must provide the same functionality as RenderResponse.getLocale");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRENDERRESPONSE_ISCOMMITTED,
            "In a target jsp of a forward in the Render phase, the method HttpServletResponse.isCommitted must provide the same functionality as RenderResponse.isCommitted");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETATTRIBUTE,
            "In a target jsp of a forward in the Resource phase, the method HttpServletRequest.getAttribute must provide the same functionality as ResourceRequest.getAttribute");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETATTRIBUTENAMES,
            "In a target jsp of a forward in the Resource phase, the method HttpServletRequest.getAttributeNames must provide the same functionality as ResourceRequest.getAttributeNames");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETAUTHTYPE,
            "In a target jsp of a forward in the Resource phase, the method HttpServletRequest.getAuthType must provide the same functionality as ResourceRequest.getAuthType");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETCHARACTERENCODING,
            "In a target jsp of a forward in the Resource phase, the method HttpServletRequest.getCharacterEncoding must provide the same functionality as ResourceRequest.getCharacterEncoding");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETCONTENTLENGTH,
            "In a target jsp of a forward in the Resource phase, the method HttpServletRequest.getContentLength must provide the same functionality as ResourceRequest.getContentLength");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETCONTENTTYPE,
            "In a target jsp of a forward in the Resource phase, the method HttpServletRequest.getContentType must provide the same functionality as ResourceRequest.getContentType");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETCONTEXTPATH,
            "In a target jsp of a forward in the Resource phase, the method HttpServletRequest.getContextPath must provide the same functionality as ResourceRequest.getContextPath");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETCOOKIES,
            "In a target jsp of a forward in the Resource phase, the method HttpServletRequest.getCookies must provide the same functionality as ResourceRequest.getCookies");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETDATEHEADER,
            "In a target jsp of a forward in the Resource phase, the method HttpServletRequest.getDateHeader must return a value corresponding to that returned by ResourceRequest.getProperty for the corresponding header name");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETHEADER,
            "In a target jsp of a forward in the Resource phase, the method HttpServletRequest.getHeader must return a value corresponding to that returned by ResourceRequest.getProperty for the corresponding header name");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETHEADERNAMES,
            "In a target jsp of a forward in the Resource phase, the Enumeration returned by HttpServletRequest.getHeaderNames must be contained in the Enumeration returned by ResourceRequest.getPropertyNames");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETHEADERS,
            "In a target jsp of a forward in the Resource phase, the method HttpServletRequest.getHeaders must return a value corresponding to that returned by ResourceRequest.getProperties for the corresponding header name");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETINTHEADER,
            "In a target jsp of a forward in the Resource phase, the method HttpServletRequest.getIntHeader must return a value corresponding to that returned by ResourceRequest.getProperty for the corresponding header name");
      tcd.put(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETLOCALADDR,
            "In a target jsp of a forward in the Resource phase, the method HttpServletRequest.getLocalAddr must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETLOCALNAME,
            "In a target jsp of a forward in the Resource phase, the method HttpServletRequest.getLocalName must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETLOCALPORT,
            "In a target jsp of a forward in the Resource phase, the method HttpServletRequest.getLocalPort must return 0");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETLOCALE,
            "In a target jsp of a forward in the Resource phase, the method HttpServletRequest.getLocale must provide the same functionality as ResourceRequest.getLocale");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETLOCALES,
            "In a target jsp of a forward in the Resource phase, the method HttpServletRequest.getLocales must provide the same functionality as ResourceRequest.getLocales");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETMETHOD,
            "In a target jsp of a forward in the Resource phase, the method HttpServletRequest.getMethod must provide the same functionality as ResourceRequest.getMethod");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETPARAMETER,
            "In a target jsp of a forward in the Resource phase, the method HttpServletRequest.getParameter must provide the same functionality as ResourceRequest.getParameter");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETPARAMETERMAP,
            "In a target jsp of a forward in the Resource phase, the method HttpServletRequest.getParameterMap must provide the same functionality as ResourceRequest.getParameterMap");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETPARAMETERNAMES,
            "In a target jsp of a forward in the Resource phase, the method HttpServletRequest.getParameterNames must provide the same functionality as ResourceRequest.getParameterNames");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETPARAMETERVALUES,
            "In a target jsp of a forward in the Resource phase, the method HttpServletRequest.getParameterValues must provide the same functionality as ResourceRequest.getParameterValues");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETPATHINFO,
            "In a target jsp of a forward in the Resource phase, the method HttpServletRequest.getPathInfo must a value corresponding to the path used to obtain the PortletRequestDispatcher");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETPATHTRANSLATED,
            "In a target jsp of a forward in the Resource phase, the method HttpServletRequest.getPathTranslated must a value corresponding to the path used to obtain the PortletRequestDispatcher");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETPROTOCOL,
            "In a target jsp of a forward in the Resource phase, the method HttpServletRequest.getProtocol must return \"HTTP/1.1\"");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETQUERYSTRING,
            "In a target jsp of a forward in the Resource phase, the method HttpServletRequest.getQueryString must a value corresponding to the query string information used to obtain the PortletRequestDispatcher");
      tcd.put(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETREALPATH,
            "In a target jsp of a forward in the Resource phase, the method HttpServletRequest.getRealPath must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETREMOTEADDR,
            "In a target jsp of a forward in the Resource phase, the method HttpServletRequest.getRemoteAddr must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETREMOTEHOST,
            "In a target jsp of a forward in the Resource phase, the method HttpServletRequest.getRemoteHost must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETREMOTEPORT,
            "In a target jsp of a forward in the Resource phase, the method HttpServletRequest.getRemotePort must return 0");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETREMOTEUSER,
            "In a target jsp of a forward in the Resource phase, the method HttpServletRequest.getRemoteUser must provide the same functionality as ResourceRequest.getRemoteUser");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETREQUESTDISPATCHER,
            "In a target jsp of a forward in the Resource phase, the method HttpServletRequest.getRequestDispatcher must provide functionality as defined in the servlet specification");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETREQUESTURI,
            "In a target jsp of a forward in the Resource phase, the method HttpServletRequest.getRequestURI must a value corresponding to the path and query string information used to obtain the PortletRequestDispatcher");
      tcd.put(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETREQUESTURL,
            "In a target jsp of a forward in the Resource phase, the method HttpServletRequest.getRequestURL must return null");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETREQUESTEDSESSIONID,
            "In a target jsp of a forward in the Resource phase, the method HttpServletRequest.getRequestedSessionId must provide the same functionality as ResourceRequest.getRequestedSessionId");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETSCHEME,
            "In a target jsp of a forward in the Resource phase, the method HttpServletRequest.getScheme must provide the same functionality as ResourceRequest.getScheme");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETSERVERNAME,
            "In a target jsp of a forward in the Resource phase, the method HttpServletRequest.getServerName must provide the same functionality as ResourceRequest.getServerName");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETSERVERPORT,
            "In a target jsp of a forward in the Resource phase, the method HttpServletRequest.getServerPort must provide the same functionality as ResourceRequest.getServerPort");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETSERVLETPATH,
            "In a target jsp of a forward in the Resource phase, the method HttpServletRequest.getServletPath must a value corresponding to the path used to obtain the PortletRequestDispatcher");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETSESSION,
            "In a target jsp of a forward in the Resource phase, the method HttpServletRequest.getSession must provide the same functionality as ResourceRequest.getPortletSession(APPLICATION_SCOPE)");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETUSERPRINCIPAL,
            "In a target jsp of a forward in the Resource phase, the method HttpServletRequest.getUserPrincipal must provide the same functionality as ResourceRequest.getUserPrincipal");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_ISREQUESTEDSESSIONIDVALID,
            "In a target jsp of a forward in the Resource phase, the method HttpServletRequest.isRequestedSessionIdValid must provide the same functionality as ResourceRequest.isRequestedSessionIdValid");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_ISSECURE,
            "In a target jsp of a forward in the Resource phase, the method HttpServletRequest.isSecure must provide the same functionality as ResourceRequest.isSecure");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_ISUSERINROLE,
            "In a target jsp of a forward in the Resource phase, the method HttpServletRequest.isUserInRole must provide the same functionality as ResourceRequest.isUserInRole");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_REMOVEATTRIBUTE,
            "In a target jsp of a forward in the Resource phase, the method HttpServletRequest.removeAttribute must provide the same functionality as ResourceRequest.removeAttribute");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_SETATTRIBUTE,
            "In a target jsp of a forward in the Resource phase, the method HttpServletRequest.setAttribute must provide the same functionality as ResourceRequest.setAttribute");
      tcd.put(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCERESPONSE_CONTAINSHEADER,
            "In a target jsp of a forward in the Resource phase, the method HttpServletResponse.containsHeader must return false");
      tcd.put(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCERESPONSE_ENCODEREDIRECTURL1,
            "In a target jsp of a forward in the Resource phase, the method HttpServletResponse.encodeRedirectURL must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCERESPONSE_ENCODEREDIRECTURL,
            "In a target jsp of a forward in the Resource phase, the method HttpServletResponse.encodeRedirectUrl must return null");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCERESPONSE_ENCODEURL1,
            "In a target jsp of a forward in the Resource phase, the method HttpServletResponse.encodeURL must provide the same functionality as ResourceResponse.encodeURL");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCERESPONSE_ENCODEURL,
            "In a target jsp of a forward in the Resource phase, the method HttpServletResponse.encodeUrl must provide the same functionality as ResourceResponse.encodeURL");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCERESPONSE_GETBUFFERSIZE,
            "In a target jsp of a forward in the Resource phase, the method HttpServletResponse.getBufferSize must provide the same functionality as ResourceResponse.getBufferSize");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCERESPONSE_GETCHARACTERENCODING,
            "In a target jsp of a forward in the Resource phase, the method HttpServletResponse.getCharacterEncoding must provide the same functionality as ResourceResponse.getCharacterEncoding");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCERESPONSE_GETCONTENTTYPE,
            "In a target jsp of a forward in the Resource phase, the method HttpServletResponse.getContentType must provide the same functionality as ResourceResponse.getContentType");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCERESPONSE_GETLOCALE,
            "In a target jsp of a forward in the Resource phase, the method HttpServletResponse.getLocale must provide the same functionality as ResourceResponse.getLocale");
      tcd.put(
            V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCERESPONSE_ISCOMMITTED,
            "In a target jsp of a forward in the Resource phase, the method HttpServletResponse.isCommitted must provide the same functionality as ResourceResponse.isCommitted");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETATTRIBUTE,
            "In a target servlet of a forward in the Action phase, the method HttpServletRequest.getAttribute must provide the same functionality as ActionRequest.getAttribute");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETATTRIBUTENAMES,
            "In a target servlet of a forward in the Action phase, the method HttpServletRequest.getAttributeNames must provide the same functionality as ActionRequest.getAttributeNames");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETAUTHTYPE,
            "In a target servlet of a forward in the Action phase, the method HttpServletRequest.getAuthType must provide the same functionality as ActionRequest.getAuthType");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETCHARACTERENCODING,
            "In a target servlet of a forward in the Action phase, the method HttpServletRequest.getCharacterEncoding must provide the same functionality as ActionRequest.getCharacterEncoding");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETCONTENTLENGTH,
            "In a target servlet of a forward in the Action phase, the method HttpServletRequest.getContentLength must provide the same functionality as ActionRequest.getContentLength");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETCONTENTTYPE,
            "In a target servlet of a forward in the Action phase, the method HttpServletRequest.getContentType must provide the same functionality as ActionRequest.getContentType");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETCONTEXTPATH,
            "In a target servlet of a forward in the Action phase, the method HttpServletRequest.getContextPath must provide the same functionality as ActionRequest.getContextPath");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETCOOKIES,
            "In a target servlet of a forward in the Action phase, the method HttpServletRequest.getCookies must provide the same functionality as ActionRequest.getCookies");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETDATEHEADER,
            "In a target servlet of a forward in the Action phase, the method HttpServletRequest.getDateHeader must return a value corresponding to that returned by ActionRequest.getProperty for the corresponding header name");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETHEADER,
            "In a target servlet of a forward in the Action phase, the method HttpServletRequest.getHeader must return a value corresponding to that returned by ActionRequest.getProperty for the corresponding header name");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETHEADERNAMES,
            "In a target servlet of a forward in the Action phase, the Enumeration returned by HttpServletRequest.getHeaderNames must be contained in the Enumeration returned by ActionRequest.getPropertyNames");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETHEADERS,
            "In a target servlet of a forward in the Action phase, the method HttpServletRequest.getHeaders must return a value corresponding to that returned by ActionRequest.getProperties for the corresponding header name");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETINTHEADER,
            "In a target servlet of a forward in the Action phase, the method HttpServletRequest.getIntHeader must return a value corresponding to that returned by ActionRequest.getProperty for the corresponding header name");
      tcd.put(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETLOCALADDR,
            "In a target servlet of a forward in the Action phase, the method HttpServletRequest.getLocalAddr must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETLOCALNAME,
            "In a target servlet of a forward in the Action phase, the method HttpServletRequest.getLocalName must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETLOCALPORT,
            "In a target servlet of a forward in the Action phase, the method HttpServletRequest.getLocalPort must return 0");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETLOCALE,
            "In a target servlet of a forward in the Action phase, the method HttpServletRequest.getLocale must provide the same functionality as ActionRequest.getLocale");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETLOCALES,
            "In a target servlet of a forward in the Action phase, the method HttpServletRequest.getLocales must provide the same functionality as ActionRequest.getLocales");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETMETHOD,
            "In a target servlet of a forward in the Action phase, the method HttpServletRequest.getMethod must provide the same functionality as ActionRequest.getMethod");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETPARAMETER,
            "In a target servlet of a forward in the Action phase, the method HttpServletRequest.getParameter must provide the same functionality as ActionRequest.getParameter");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETPARAMETERMAP,
            "In a target servlet of a forward in the Action phase, the method HttpServletRequest.getParameterMap must provide the same functionality as ActionRequest.getParameterMap");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETPARAMETERNAMES,
            "In a target servlet of a forward in the Action phase, the method HttpServletRequest.getParameterNames must provide the same functionality as ActionRequest.getParameterNames");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETPARAMETERVALUES,
            "In a target servlet of a forward in the Action phase, the method HttpServletRequest.getParameterValues must provide the same functionality as ActionRequest.getParameterValues");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETPATHINFO,
            "In a target servlet of a forward in the Action phase, the method HttpServletRequest.getPathInfo must a value corresponding to the path used to obtain the PortletRequestDispatcher");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETPATHTRANSLATED,
            "In a target servlet of a forward in the Action phase, the method HttpServletRequest.getPathTranslated must a value corresponding to the path used to obtain the PortletRequestDispatcher");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETPROTOCOL,
            "In a target servlet of a forward in the Action phase, the method HttpServletRequest.getProtocol must return \"HTTP/1.1\"");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETQUERYSTRING,
            "In a target servlet of a forward in the Action phase, the method HttpServletRequest.getQueryString must a value corresponding to the query string information used to obtain the PortletRequestDispatcher");
      tcd.put(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETREALPATH,
            "In a target servlet of a forward in the Action phase, the method HttpServletRequest.getRealPath must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETREMOTEADDR,
            "In a target servlet of a forward in the Action phase, the method HttpServletRequest.getRemoteAddr must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETREMOTEHOST,
            "In a target servlet of a forward in the Action phase, the method HttpServletRequest.getRemoteHost must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETREMOTEPORT,
            "In a target servlet of a forward in the Action phase, the method HttpServletRequest.getRemotePort must return 0");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETREMOTEUSER,
            "In a target servlet of a forward in the Action phase, the method HttpServletRequest.getRemoteUser must provide the same functionality as ActionRequest.getRemoteUser");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETREQUESTDISPATCHER,
            "In a target servlet of a forward in the Action phase, the method HttpServletRequest.getRequestDispatcher must provide functionality as defined in the servlet specification");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETREQUESTURI,
            "In a target servlet of a forward in the Action phase, the method HttpServletRequest.getRequestURI must a value corresponding to the path and query string information used to obtain the PortletRequestDispatcher");
      tcd.put(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETREQUESTURL,
            "In a target servlet of a forward in the Action phase, the method HttpServletRequest.getRequestURL must return null");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETREQUESTEDSESSIONID,
            "In a target servlet of a forward in the Action phase, the method HttpServletRequest.getRequestedSessionId must provide the same functionality as ActionRequest.getRequestedSessionId");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETSCHEME,
            "In a target servlet of a forward in the Action phase, the method HttpServletRequest.getScheme must provide the same functionality as ActionRequest.getScheme");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETSERVERNAME,
            "In a target servlet of a forward in the Action phase, the method HttpServletRequest.getServerName must provide the same functionality as ActionRequest.getServerName");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETSERVERPORT,
            "In a target servlet of a forward in the Action phase, the method HttpServletRequest.getServerPort must provide the same functionality as ActionRequest.getServerPort");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETSERVLETPATH,
            "In a target servlet of a forward in the Action phase, the method HttpServletRequest.getServletPath must a value corresponding to the path used to obtain the PortletRequestDispatcher");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETSESSION,
            "In a target servlet of a forward in the Action phase, the method HttpServletRequest.getSession must provide the same functionality as ActionRequest.getPortletSession(APPLICATION_SCOPE)");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETUSERPRINCIPAL,
            "In a target servlet of a forward in the Action phase, the method HttpServletRequest.getUserPrincipal must provide the same functionality as ActionRequest.getUserPrincipal");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_ISREQUESTEDSESSIONIDVALID,
            "In a target servlet of a forward in the Action phase, the method HttpServletRequest.isRequestedSessionIdValid must provide the same functionality as ActionRequest.isRequestedSessionIdValid");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_ISSECURE,
            "In a target servlet of a forward in the Action phase, the method HttpServletRequest.isSecure must provide the same functionality as ActionRequest.isSecure");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_ISUSERINROLE,
            "In a target servlet of a forward in the Action phase, the method HttpServletRequest.isUserInRole must provide the same functionality as ActionRequest.isUserInRole");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_REMOVEATTRIBUTE,
            "In a target servlet of a forward in the Action phase, the method HttpServletRequest.removeAttribute must provide the same functionality as ActionRequest.removeAttribute");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONREQUEST_SETATTRIBUTE,
            "In a target servlet of a forward in the Action phase, the method HttpServletRequest.setAttribute must provide the same functionality as ActionRequest.setAttribute");
      tcd.put(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONRESPONSE_CONTAINSHEADER,
            "In a target servlet of a forward in the Action phase, the method HttpServletResponse.containsHeader must return false");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONRESPONSE_ENCODEREDIRECTURL1,
            "In a target servlet of a forward in the Action phase, the method HttpServletResponse.encodeRedirectURL must return null");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONRESPONSE_ENCODEREDIRECTURL,
            "In a target servlet of a forward in the Action phase, the method HttpServletResponse.encodeRedirectUrl must return null");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONRESPONSE_ENCODEURL1,
            "In a target servlet of a forward in the Action phase, the method HttpServletResponse.encodeURL must provide the same functionality as ActionResponse.encodeURL");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONRESPONSE_ENCODEURL,
            "In a target servlet of a forward in the Action phase, the method HttpServletResponse.encodeUrl must provide the same functionality as ActionResponse.encodeURL");
      tcd.put(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONRESPONSE_GETBUFFERSIZE,
            "In a target servlet of a forward in the Action phase, the method HttpServletResponse.getBufferSize must return 0");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONRESPONSE_GETCHARACTERENCODING,
            "In a target servlet of a forward in the Action phase, the method HttpServletResponse.getCharacterEncoding must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONRESPONSE_GETCONTENTTYPE,
            "In a target servlet of a forward in the Action phase, the method HttpServletResponse.getContentType must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONRESPONSE_GETLOCALE,
            "In a target servlet of a forward in the Action phase, the method HttpServletResponse.getLocale must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETACTIONRESPONSE_ISCOMMITTED,
            "In a target servlet of a forward in the Action phase, the method HttpServletResponse.isCommitted must return false");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETATTRIBUTE,
            "In a target servlet of a forward in the Event phase, the method HttpServletRequest.getAttribute must provide the same functionality as EventRequest.getAttribute");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETATTRIBUTENAMES,
            "In a target servlet of a forward in the Event phase, the method HttpServletRequest.getAttributeNames must provide the same functionality as EventRequest.getAttributeNames");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETAUTHTYPE,
            "In a target servlet of a forward in the Event phase, the method HttpServletRequest.getAuthType must provide the same functionality as EventRequest.getAuthType");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETCHARACTERENCODING,
            "In a target servlet of a forward in the Event phase, the method HttpServletRequest.getCharacterEncoding must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETCONTENTLENGTH,
            "In a target servlet of a forward in the Event phase, the method HttpServletRequest.getContentLength must return 0");
      tcd.put(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETCONTENTTYPE,
            "In a target servlet of a forward in the Event phase, the method HttpServletRequest.getContentType must return null");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETCONTEXTPATH,
            "In a target servlet of a forward in the Event phase, the method HttpServletRequest.getContextPath must provide the same functionality as EventRequest.getContextPath");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETCOOKIES,
            "In a target servlet of a forward in the Event phase, the method HttpServletRequest.getCookies must provide the same functionality as EventRequest.getCookies");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETDATEHEADER,
            "In a target servlet of a forward in the Event phase, the method HttpServletRequest.getDateHeader must return a value corresponding to that returned by EventRequest.getProperty for the corresponding header name");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETHEADER,
            "In a target servlet of a forward in the Event phase, the method HttpServletRequest.getHeader must return a value corresponding to that returned by EventRequest.getProperty for the corresponding header name");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETHEADERNAMES,
            "In a target servlet of a forward in the Event phase, the Enumeration returned by HttpServletRequest.getHeaderNames must be contained in the Enumeration returned by EventRequest.getPropertyNames");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETHEADERS,
            "In a target servlet of a forward in the Event phase, the method HttpServletRequest.getHeaders must return a value corresponding to that returned by EventRequest.getProperties for the corresponding header name");
      tcd.put(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETINPUTSTREAM,
            "In a target servlet of a forward in the Event phase, the method HttpServletRequest.getInputStream must return null");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETINTHEADER,
            "In a target servlet of a forward in the Event phase, the method HttpServletRequest.getIntHeader must return a value corresponding to that returned by EventRequest.getProperty for the corresponding header name");
      tcd.put(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETLOCALADDR,
            "In a target servlet of a forward in the Event phase, the method HttpServletRequest.getLocalAddr must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETLOCALNAME,
            "In a target servlet of a forward in the Event phase, the method HttpServletRequest.getLocalName must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETLOCALPORT,
            "In a target servlet of a forward in the Event phase, the method HttpServletRequest.getLocalPort must return 0");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETLOCALE,
            "In a target servlet of a forward in the Event phase, the method HttpServletRequest.getLocale must provide the same functionality as EventRequest.getLocale");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETLOCALES,
            "In a target servlet of a forward in the Event phase, the method HttpServletRequest.getLocales must provide the same functionality as EventRequest.getLocales");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETMETHOD,
            "In a target servlet of a forward in the Event phase, the method HttpServletRequest.getMethod must provide the same functionality as EventRequest.getMethod");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETPARAMETER,
            "In a target servlet of a forward in the Event phase, the method HttpServletRequest.getParameter must provide the same functionality as EventRequest.getParameter");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETPARAMETERMAP,
            "In a target servlet of a forward in the Event phase, the method HttpServletRequest.getParameterMap must provide the same functionality as EventRequest.getParameterMap");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETPARAMETERNAMES,
            "In a target servlet of a forward in the Event phase, the method HttpServletRequest.getParameterNames must provide the same functionality as EventRequest.getParameterNames");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETPARAMETERVALUES,
            "In a target servlet of a forward in the Event phase, the method HttpServletRequest.getParameterValues must provide the same functionality as EventRequest.getParameterValues");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETPATHINFO,
            "In a target servlet of a forward in the Event phase, the method HttpServletRequest.getPathInfo must a value corresponding to the path used to obtain the PortletRequestDispatcher");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETPATHTRANSLATED,
            "In a target servlet of a forward in the Event phase, the method HttpServletRequest.getPathTranslated must a value corresponding to the path used to obtain the PortletRequestDispatcher");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETPROTOCOL,
            "In a target servlet of a forward in the Event phase, the method HttpServletRequest.getProtocol must return \"HTTP/1.1\"");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETQUERYSTRING,
            "In a target servlet of a forward in the Event phase, the method HttpServletRequest.getQueryString must a value corresponding to the query string information used to obtain the PortletRequestDispatcher");
      tcd.put(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETREADER,
            "In a target servlet of a forward in the Event phase, the method HttpServletRequest.getReader must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETREALPATH,
            "In a target servlet of a forward in the Event phase, the method HttpServletRequest.getRealPath must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETREMOTEADDR,
            "In a target servlet of a forward in the Event phase, the method HttpServletRequest.getRemoteAddr must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETREMOTEHOST,
            "In a target servlet of a forward in the Event phase, the method HttpServletRequest.getRemoteHost must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETREMOTEPORT,
            "In a target servlet of a forward in the Event phase, the method HttpServletRequest.getRemotePort must return 0");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETREMOTEUSER,
            "In a target servlet of a forward in the Event phase, the method HttpServletRequest.getRemoteUser must provide the same functionality as EventRequest.getRemoteUser");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETREQUESTDISPATCHER,
            "In a target servlet of a forward in the Event phase, the method HttpServletRequest.getRequestDispatcher must provide functionality as defined in the servlet specification");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETREQUESTURI,
            "In a target servlet of a forward in the Event phase, the method HttpServletRequest.getRequestURI must a value corresponding to the path and query string information used to obtain the PortletRequestDispatcher");
      tcd.put(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETREQUESTURL,
            "In a target servlet of a forward in the Event phase, the method HttpServletRequest.getRequestURL must return null");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETREQUESTEDSESSIONID,
            "In a target servlet of a forward in the Event phase, the method HttpServletRequest.getRequestedSessionId must provide the same functionality as EventRequest.getRequestedSessionId");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETSCHEME,
            "In a target servlet of a forward in the Event phase, the method HttpServletRequest.getScheme must provide the same functionality as EventRequest.getScheme");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETSERVERNAME,
            "In a target servlet of a forward in the Event phase, the method HttpServletRequest.getServerName must provide the same functionality as EventRequest.getServerName");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETSERVERPORT,
            "In a target servlet of a forward in the Event phase, the method HttpServletRequest.getServerPort must provide the same functionality as EventRequest.getServerPort");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETSERVLETPATH,
            "In a target servlet of a forward in the Event phase, the method HttpServletRequest.getServletPath must a value corresponding to the path used to obtain the PortletRequestDispatcher");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETSESSION,
            "In a target servlet of a forward in the Event phase, the method HttpServletRequest.getSession must provide the same functionality as EventRequest.getPortletSession(APPLICATION_SCOPE)");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_GETUSERPRINCIPAL,
            "In a target servlet of a forward in the Event phase, the method HttpServletRequest.getUserPrincipal must provide the same functionality as EventRequest.getUserPrincipal");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_ISREQUESTEDSESSIONIDVALID,
            "In a target servlet of a forward in the Event phase, the method HttpServletRequest.isRequestedSessionIdValid must provide the same functionality as EventRequest.isRequestedSessionIdValid");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_ISSECURE,
            "In a target servlet of a forward in the Event phase, the method HttpServletRequest.isSecure must provide the same functionality as EventRequest.isSecure");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_ISUSERINROLE,
            "In a target servlet of a forward in the Event phase, the method HttpServletRequest.isUserInRole must provide the same functionality as EventRequest.isUserInRole");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_REMOVEATTRIBUTE,
            "In a target servlet of a forward in the Event phase, the method HttpServletRequest.removeAttribute must provide the same functionality as EventRequest.removeAttribute");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTREQUEST_SETATTRIBUTE,
            "In a target servlet of a forward in the Event phase, the method HttpServletRequest.setAttribute must provide the same functionality as EventRequest.setAttribute");
      tcd.put(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTRESPONSE_CONTAINSHEADER,
            "In a target servlet of a forward in the Event phase, the method HttpServletResponse.containsHeader must return false");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTRESPONSE_ENCODEREDIRECTURL1,
            "In a target servlet of a forward in the Event phase, the method HttpServletResponse.encodeRedirectURL must return null");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTRESPONSE_ENCODEREDIRECTURL,
            "In a target servlet of a forward in the Event phase, the method HttpServletResponse.encodeRedirectUrl must return null");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTRESPONSE_ENCODEURL1,
            "In a target servlet of a forward in the Event phase, the method HttpServletResponse.encodeURL must provide the same functionality as EventResponse.encodeURL");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTRESPONSE_ENCODEURL,
            "In a target servlet of a forward in the Event phase, the method HttpServletResponse.encodeUrl must provide the same functionality as EventResponse.encodeURL");
      tcd.put(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTRESPONSE_GETBUFFERSIZE,
            "In a target servlet of a forward in the Event phase, the method HttpServletResponse.getBufferSize must return 0");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTRESPONSE_GETCHARACTERENCODING,
            "In a target servlet of a forward in the Event phase, the method HttpServletResponse.getCharacterEncoding must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTRESPONSE_GETCONTENTTYPE,
            "In a target servlet of a forward in the Event phase, the method HttpServletResponse.getContentType must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTRESPONSE_GETLOCALE,
            "In a target servlet of a forward in the Event phase, the method HttpServletResponse.getLocale must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETEVENTRESPONSE_ISCOMMITTED,
            "In a target servlet of a forward in the Event phase, the method HttpServletResponse.isCommitted must return false");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETATTRIBUTE,
            "In a target servlet of a forward in the Render phase, the method HttpServletRequest.getAttribute must provide the same functionality as RenderRequest.getAttribute");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETATTRIBUTENAMES,
            "In a target servlet of a forward in the Render phase, the method HttpServletRequest.getAttributeNames must provide the same functionality as RenderRequest.getAttributeNames");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETAUTHTYPE,
            "In a target servlet of a forward in the Render phase, the method HttpServletRequest.getAuthType must provide the same functionality as RenderRequest.getAuthType");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETCHARACTERENCODING,
            "In a target servlet of a forward in the Render phase, the method HttpServletRequest.getCharacterEncoding must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETCONTENTLENGTH,
            "In a target servlet of a forward in the Render phase, the method HttpServletRequest.getContentLength must return 0");
      tcd.put(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETCONTENTTYPE,
            "In a target servlet of a forward in the Render phase, the method HttpServletRequest.getContentType must return null");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETCONTEXTPATH,
            "In a target servlet of a forward in the Render phase, the method HttpServletRequest.getContextPath must provide the same functionality as RenderRequest.getContextPath");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETCOOKIES,
            "In a target servlet of a forward in the Render phase, the method HttpServletRequest.getCookies must provide the same functionality as RenderRequest.getCookies");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETDATEHEADER,
            "In a target servlet of a forward in the Render phase, the method HttpServletRequest.getDateHeader must return a value corresponding to that returned by RenderRequest.getProperty for the corresponding header name");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETHEADER,
            "In a target servlet of a forward in the Render phase, the method HttpServletRequest.getHeader must return a value corresponding to that returned by RenderRequest.getProperty for the corresponding header name");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETHEADERNAMES,
            "In a target servlet of a forward in the Render phase, the Enumeration returned by HttpServletRequest.getHeaderNames must be contained in the Enumeration returned by RenderRequest.getPropertyNames");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETHEADERS,
            "In a target servlet of a forward in the Render phase, the method HttpServletRequest.getHeaders must return a value corresponding to that returned by RenderRequest.getProperties for the corresponding header name");
      tcd.put(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETINPUTSTREAM,
            "In a target servlet of a forward in the Render phase, the method HttpServletRequest.getInputStream must return null");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETINTHEADER,
            "In a target servlet of a forward in the Render phase, the method HttpServletRequest.getIntHeader must return a value corresponding to that returned by RenderRequest.getProperty for the corresponding header name");
      tcd.put(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETLOCALADDR,
            "In a target servlet of a forward in the Render phase, the method HttpServletRequest.getLocalAddr must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETLOCALNAME,
            "In a target servlet of a forward in the Render phase, the method HttpServletRequest.getLocalName must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETLOCALPORT,
            "In a target servlet of a forward in the Render phase, the method HttpServletRequest.getLocalPort must return 0");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETLOCALE,
            "In a target servlet of a forward in the Render phase, the method HttpServletRequest.getLocale must provide the same functionality as RenderRequest.getLocale");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETLOCALES,
            "In a target servlet of a forward in the Render phase, the method HttpServletRequest.getLocales must provide the same functionality as RenderRequest.getLocales");
      tcd.put(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETMETHOD,
            "In a target servlet of a forward in the Render phase, the method HttpServletRequest.getMethod must return \"GET\"");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETPARAMETER,
            "In a target servlet of a forward in the Render phase, the method HttpServletRequest.getParameter must provide the same functionality as RenderRequest.getParameter");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETPARAMETERMAP,
            "In a target servlet of a forward in the Render phase, the method HttpServletRequest.getParameterMap must provide the same functionality as RenderRequest.getParameterMap");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETPARAMETERNAMES,
            "In a target servlet of a forward in the Render phase, the method HttpServletRequest.getParameterNames must provide the same functionality as RenderRequest.getParameterNames");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETPARAMETERVALUES,
            "In a target servlet of a forward in the Render phase, the method HttpServletRequest.getParameterValues must provide the same functionality as RenderRequest.getParameterValues");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETPATHINFO,
            "In a target servlet of a forward in the Render phase, the method HttpServletRequest.getPathInfo must a value corresponding to the path used to obtain the PortletRequestDispatcher");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETPATHTRANSLATED,
            "In a target servlet of a forward in the Render phase, the method HttpServletRequest.getPathTranslated must a value corresponding to the path used to obtain the PortletRequestDispatcher");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETPROTOCOL,
            "In a target servlet of a forward in the Render phase, the method HttpServletRequest.getProtocol must return \"HTTP/1.1\"");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETQUERYSTRING,
            "In a target servlet of a forward in the Render phase, the method HttpServletRequest.getQueryString must a value corresponding to the query string information used to obtain the PortletRequestDispatcher");
      tcd.put(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETREADER,
            "In a target servlet of a forward in the Render phase, the method HttpServletRequest.getReader must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETREALPATH,
            "In a target servlet of a forward in the Render phase, the method HttpServletRequest.getRealPath must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETREMOTEADDR,
            "In a target servlet of a forward in the Render phase, the method HttpServletRequest.getRemoteAddr must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETREMOTEHOST,
            "In a target servlet of a forward in the Render phase, the method HttpServletRequest.getRemoteHost must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETREMOTEPORT,
            "In a target servlet of a forward in the Render phase, the method HttpServletRequest.getRemotePort must return 0");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETREMOTEUSER,
            "In a target servlet of a forward in the Render phase, the method HttpServletRequest.getRemoteUser must provide the same functionality as RenderRequest.getRemoteUser");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETREQUESTDISPATCHER,
            "In a target servlet of a forward in the Render phase, the method HttpServletRequest.getRequestDispatcher must provide functionality as defined in the servlet specification");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETREQUESTURI,
            "In a target servlet of a forward in the Render phase, the method HttpServletRequest.getRequestURI must a value corresponding to the path and query string information used to obtain the PortletRequestDispatcher");
      tcd.put(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETREQUESTURL,
            "In a target servlet of a forward in the Render phase, the method HttpServletRequest.getRequestURL must return null");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETREQUESTEDSESSIONID,
            "In a target servlet of a forward in the Render phase, the method HttpServletRequest.getRequestedSessionId must provide the same functionality as RenderRequest.getRequestedSessionId");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETSCHEME,
            "In a target servlet of a forward in the Render phase, the method HttpServletRequest.getScheme must provide the same functionality as RenderRequest.getScheme");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETSERVERNAME,
            "In a target servlet of a forward in the Render phase, the method HttpServletRequest.getServerName must provide the same functionality as RenderRequest.getServerName");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETSERVERPORT,
            "In a target servlet of a forward in the Render phase, the method HttpServletRequest.getServerPort must provide the same functionality as RenderRequest.getServerPort");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETSERVLETPATH,
            "In a target servlet of a forward in the Render phase, the method HttpServletRequest.getServletPath must a value corresponding to the path used to obtain the PortletRequestDispatcher");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETSESSION,
            "In a target servlet of a forward in the Render phase, the method HttpServletRequest.getSession must provide the same functionality as RenderRequest.getPortletSession(APPLICATION_SCOPE)");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_GETUSERPRINCIPAL,
            "In a target servlet of a forward in the Render phase, the method HttpServletRequest.getUserPrincipal must provide the same functionality as RenderRequest.getUserPrincipal");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_ISREQUESTEDSESSIONIDVALID,
            "In a target servlet of a forward in the Render phase, the method HttpServletRequest.isRequestedSessionIdValid must provide the same functionality as RenderRequest.isRequestedSessionIdValid");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_ISSECURE,
            "In a target servlet of a forward in the Render phase, the method HttpServletRequest.isSecure must provide the same functionality as RenderRequest.isSecure");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_ISUSERINROLE,
            "In a target servlet of a forward in the Render phase, the method HttpServletRequest.isUserInRole must provide the same functionality as RenderRequest.isUserInRole");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_REMOVEATTRIBUTE,
            "In a target servlet of a forward in the Render phase, the method HttpServletRequest.removeAttribute must provide the same functionality as RenderRequest.removeAttribute");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERREQUEST_SETATTRIBUTE,
            "In a target servlet of a forward in the Render phase, the method HttpServletRequest.setAttribute must provide the same functionality as RenderRequest.setAttribute");
      tcd.put(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERRESPONSE_CONTAINSHEADER,
            "In a target servlet of a forward in the Render phase, the method HttpServletResponse.containsHeader must return false");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERRESPONSE_ENCODEREDIRECTURL1,
            "In a target servlet of a forward in the Render phase, the method HttpServletResponse.encodeRedirectURL must return null");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERRESPONSE_ENCODEREDIRECTURL,
            "In a target servlet of a forward in the Render phase, the method HttpServletResponse.encodeRedirectUrl must return null");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERRESPONSE_ENCODEURL1,
            "In a target servlet of a forward in the Render phase, the method HttpServletResponse.encodeURL must provide the same functionality as RenderResponse.encodeURL");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERRESPONSE_ENCODEURL,
            "In a target servlet of a forward in the Render phase, the method HttpServletResponse.encodeUrl must provide the same functionality as RenderResponse.encodeURL");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERRESPONSE_GETBUFFERSIZE,
            "In a target servlet of a forward in the Render phase, the method HttpServletResponse.getBufferSize must provide the same functionality as RenderResponse.getBufferSize");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERRESPONSE_GETCHARACTERENCODING,
            "In a target servlet of a forward in the Render phase, the method HttpServletResponse.getCharacterEncoding must provide the same functionality as RenderResponse.getCharacterEncoding");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERRESPONSE_GETCONTENTTYPE,
            "In a target servlet of a forward in the Render phase, the method HttpServletResponse.getContentType must provide the same functionality as RenderResponse.getContentType");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERRESPONSE_GETLOCALE,
            "In a target servlet of a forward in the Render phase, the method HttpServletResponse.getLocale must provide the same functionality as RenderResponse.getLocale");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRENDERRESPONSE_ISCOMMITTED,
            "In a target servlet of a forward in the Render phase, the method HttpServletResponse.isCommitted must provide the same functionality as RenderResponse.isCommitted");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETATTRIBUTE,
            "In a target servlet of a forward in the Resource phase, the method HttpServletRequest.getAttribute must provide the same functionality as ResourceRequest.getAttribute");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETATTRIBUTENAMES,
            "In a target servlet of a forward in the Resource phase, the method HttpServletRequest.getAttributeNames must provide the same functionality as ResourceRequest.getAttributeNames");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETAUTHTYPE,
            "In a target servlet of a forward in the Resource phase, the method HttpServletRequest.getAuthType must provide the same functionality as ResourceRequest.getAuthType");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETCHARACTERENCODING,
            "In a target servlet of a forward in the Resource phase, the method HttpServletRequest.getCharacterEncoding must provide the same functionality as ResourceRequest.getCharacterEncoding");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETCONTENTLENGTH,
            "In a target servlet of a forward in the Resource phase, the method HttpServletRequest.getContentLength must provide the same functionality as ResourceRequest.getContentLength");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETCONTENTTYPE,
            "In a target servlet of a forward in the Resource phase, the method HttpServletRequest.getContentType must provide the same functionality as ResourceRequest.getContentType");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETCONTEXTPATH,
            "In a target servlet of a forward in the Resource phase, the method HttpServletRequest.getContextPath must provide the same functionality as ResourceRequest.getContextPath");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETCOOKIES,
            "In a target servlet of a forward in the Resource phase, the method HttpServletRequest.getCookies must provide the same functionality as ResourceRequest.getCookies");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETDATEHEADER,
            "In a target servlet of a forward in the Resource phase, the method HttpServletRequest.getDateHeader must return a value corresponding to that returned by ResourceRequest.getProperty for the corresponding header name");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETHEADER,
            "In a target servlet of a forward in the Resource phase, the method HttpServletRequest.getHeader must return a value corresponding to that returned by ResourceRequest.getProperty for the corresponding header name");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETHEADERNAMES,
            "In a target servlet of a forward in the Resource phase, the Enumeration returned by HttpServletRequest.getHeaderNames must be contained in the Enumeration returned by ResourceRequest.getPropertyNames");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETHEADERS,
            "In a target servlet of a forward in the Resource phase, the method HttpServletRequest.getHeaders must return a value corresponding to that returned by ResourceRequest.getProperties for the corresponding header name");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETINTHEADER,
            "In a target servlet of a forward in the Resource phase, the method HttpServletRequest.getIntHeader must return a value corresponding to that returned by ResourceRequest.getProperty for the corresponding header name");
      tcd.put(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETLOCALADDR,
            "In a target servlet of a forward in the Resource phase, the method HttpServletRequest.getLocalAddr must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETLOCALNAME,
            "In a target servlet of a forward in the Resource phase, the method HttpServletRequest.getLocalName must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETLOCALPORT,
            "In a target servlet of a forward in the Resource phase, the method HttpServletRequest.getLocalPort must return 0");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETLOCALE,
            "In a target servlet of a forward in the Resource phase, the method HttpServletRequest.getLocale must provide the same functionality as ResourceRequest.getLocale");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETLOCALES,
            "In a target servlet of a forward in the Resource phase, the method HttpServletRequest.getLocales must provide the same functionality as ResourceRequest.getLocales");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETMETHOD,
            "In a target servlet of a forward in the Resource phase, the method HttpServletRequest.getMethod must provide the same functionality as ResourceRequest.getMethod");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETPARAMETER,
            "In a target servlet of a forward in the Resource phase, the method HttpServletRequest.getParameter must provide the same functionality as ResourceRequest.getParameter");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETPARAMETERMAP,
            "In a target servlet of a forward in the Resource phase, the method HttpServletRequest.getParameterMap must provide the same functionality as ResourceRequest.getParameterMap");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETPARAMETERNAMES,
            "In a target servlet of a forward in the Resource phase, the method HttpServletRequest.getParameterNames must provide the same functionality as ResourceRequest.getParameterNames");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETPARAMETERVALUES,
            "In a target servlet of a forward in the Resource phase, the method HttpServletRequest.getParameterValues must provide the same functionality as ResourceRequest.getParameterValues");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETPATHINFO,
            "In a target servlet of a forward in the Resource phase, the method HttpServletRequest.getPathInfo must a value corresponding to the path used to obtain the PortletRequestDispatcher");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETPATHTRANSLATED,
            "In a target servlet of a forward in the Resource phase, the method HttpServletRequest.getPathTranslated must a value corresponding to the path used to obtain the PortletRequestDispatcher");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETPROTOCOL,
            "In a target servlet of a forward in the Resource phase, the method HttpServletRequest.getProtocol must return \"HTTP/1.1\"");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETQUERYSTRING,
            "In a target servlet of a forward in the Resource phase, the method HttpServletRequest.getQueryString must a value corresponding to the query string information used to obtain the PortletRequestDispatcher");
      tcd.put(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETREALPATH,
            "In a target servlet of a forward in the Resource phase, the method HttpServletRequest.getRealPath must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETREMOTEADDR,
            "In a target servlet of a forward in the Resource phase, the method HttpServletRequest.getRemoteAddr must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETREMOTEHOST,
            "In a target servlet of a forward in the Resource phase, the method HttpServletRequest.getRemoteHost must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETREMOTEPORT,
            "In a target servlet of a forward in the Resource phase, the method HttpServletRequest.getRemotePort must return 0");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETREMOTEUSER,
            "In a target servlet of a forward in the Resource phase, the method HttpServletRequest.getRemoteUser must provide the same functionality as ResourceRequest.getRemoteUser");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETREQUESTDISPATCHER,
            "In a target servlet of a forward in the Resource phase, the method HttpServletRequest.getRequestDispatcher must provide functionality as defined in the servlet specification");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETREQUESTURI,
            "In a target servlet of a forward in the Resource phase, the method HttpServletRequest.getRequestURI must a value corresponding to the path and query string information used to obtain the PortletRequestDispatcher");
      tcd.put(V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETREQUESTURL,
            "In a target servlet of a forward in the Resource phase, the method HttpServletRequest.getRequestURL must return null");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETREQUESTEDSESSIONID,
            "In a target servlet of a forward in the Resource phase, the method HttpServletRequest.getRequestedSessionId must provide the same functionality as ResourceRequest.getRequestedSessionId");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETSCHEME,
            "In a target servlet of a forward in the Resource phase, the method HttpServletRequest.getScheme must provide the same functionality as ResourceRequest.getScheme");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETSERVERNAME,
            "In a target servlet of a forward in the Resource phase, the method HttpServletRequest.getServerName must provide the same functionality as ResourceRequest.getServerName");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETSERVERPORT,
            "In a target servlet of a forward in the Resource phase, the method HttpServletRequest.getServerPort must provide the same functionality as ResourceRequest.getServerPort");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETSERVLETPATH,
            "In a target servlet of a forward in the Resource phase, the method HttpServletRequest.getServletPath must a value corresponding to the path used to obtain the PortletRequestDispatcher");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETSESSION,
            "In a target servlet of a forward in the Resource phase, the method HttpServletRequest.getSession must provide the same functionality as ResourceRequest.getPortletSession(APPLICATION_SCOPE)");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETUSERPRINCIPAL,
            "In a target servlet of a forward in the Resource phase, the method HttpServletRequest.getUserPrincipal must provide the same functionality as ResourceRequest.getUserPrincipal");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_ISREQUESTEDSESSIONIDVALID,
            "In a target servlet of a forward in the Resource phase, the method HttpServletRequest.isRequestedSessionIdValid must provide the same functionality as ResourceRequest.isRequestedSessionIdValid");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_ISSECURE,
            "In a target servlet of a forward in the Resource phase, the method HttpServletRequest.isSecure must provide the same functionality as ResourceRequest.isSecure");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_ISUSERINROLE,
            "In a target servlet of a forward in the Resource phase, the method HttpServletRequest.isUserInRole must provide the same functionality as ResourceRequest.isUserInRole");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_REMOVEATTRIBUTE,
            "In a target servlet of a forward in the Resource phase, the method HttpServletRequest.removeAttribute must provide the same functionality as ResourceRequest.removeAttribute");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_SETATTRIBUTE,
            "In a target servlet of a forward in the Resource phase, the method HttpServletRequest.setAttribute must provide the same functionality as ResourceRequest.setAttribute");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCERESPONSE_CONTAINSHEADER,
            "In a target servlet of a forward in the Resource phase, the method HttpServletResponse.containsHeader must return false");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCERESPONSE_ENCODEREDIRECTURL1,
            "In a target servlet of a forward in the Resource phase, the method HttpServletResponse.encodeRedirectURL must return null");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCERESPONSE_ENCODEREDIRECTURL,
            "In a target servlet of a forward in the Resource phase, the method HttpServletResponse.encodeRedirectUrl must return null");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCERESPONSE_ENCODEURL1,
            "In a target servlet of a forward in the Resource phase, the method HttpServletResponse.encodeURL must provide the same functionality as ResourceResponse.encodeURL");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCERESPONSE_ENCODEURL,
            "In a target servlet of a forward in the Resource phase, the method HttpServletResponse.encodeUrl must provide the same functionality as ResourceResponse.encodeURL");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCERESPONSE_GETBUFFERSIZE,
            "In a target servlet of a forward in the Resource phase, the method HttpServletResponse.getBufferSize must provide the same functionality as ResourceResponse.getBufferSize");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCERESPONSE_GETCHARACTERENCODING,
            "In a target servlet of a forward in the Resource phase, the method HttpServletResponse.getCharacterEncoding must provide the same functionality as ResourceResponse.getCharacterEncoding");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCERESPONSE_GETCONTENTTYPE,
            "In a target servlet of a forward in the Resource phase, the method HttpServletResponse.getContentType must provide the same functionality as ResourceResponse.getContentType");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCERESPONSE_GETLOCALE,
            "In a target servlet of a forward in the Resource phase, the method HttpServletResponse.getLocale must provide the same functionality as ResourceResponse.getLocale");
      tcd.put(
            V2DISPATCHERREQRESPTESTS2_SPEC2_19_FORWARDSERVLETRESOURCERESPONSE_ISCOMMITTED,
            "In a target servlet of a forward in the Resource phase, the method HttpServletResponse.isCommitted must provide the same functionality as ResourceResponse.isCommitted");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETATTRIBUTE,
            "In a target jsp of a include in the Action phase, the method HttpServletRequest.getAttribute must provide the same functionality as ActionRequest.getAttribute");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETATTRIBUTENAMES,
            "In a target jsp of a include in the Action phase, the method HttpServletRequest.getAttributeNames must provide the same functionality as ActionRequest.getAttributeNames");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETAUTHTYPE,
            "In a target jsp of a include in the Action phase, the method HttpServletRequest.getAuthType must provide the same functionality as ActionRequest.getAuthType");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETCHARACTERENCODING,
            "In a target jsp of a include in the Action phase, the method HttpServletRequest.getCharacterEncoding must provide the same functionality as ActionRequest.getCharacterEncoding");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETCONTENTLENGTH,
            "In a target jsp of a include in the Action phase, the method HttpServletRequest.getContentLength must provide the same functionality as ActionRequest.getContentLength");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETCONTENTTYPE,
            "In a target jsp of a include in the Action phase, the method HttpServletRequest.getContentType must provide the same functionality as ActionRequest.getContentType");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETCONTEXTPATH,
            "In a target jsp of a include in the Action phase, the method HttpServletRequest.getContextPath must provide the same functionality as ActionRequest.getContextPath");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETCOOKIES,
            "In a target jsp of a include in the Action phase, the method HttpServletRequest.getCookies must provide the same functionality as ActionRequest.getCookies");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETDATEHEADER,
            "In a target jsp of a include in the Action phase, the method HttpServletRequest.getDateHeader must return a value corresponding to that returned by ActionRequest.getProperty for the corresponding header name");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETHEADER,
            "In a target jsp of a include in the Action phase, the method HttpServletRequest.getHeader must return a value corresponding to that returned by ActionRequest.getProperty for the corresponding header name");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETHEADERNAMES,
            "In a target jsp of a include in the Action phase, the Enumeration returned by HttpServletRequest.getHeaderNames must be contained in the Enumeration returned by ActionRequest.getPropertyNames");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETHEADERS,
            "In a target jsp of a include in the Action phase, the method HttpServletRequest.getHeaders must return a value corresponding to that returned by ActionRequest.getProperties for the corresponding header name");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETINTHEADER,
            "In a target jsp of a include in the Action phase, the method HttpServletRequest.getIntHeader must return a value corresponding to that returned by ActionRequest.getProperty for the corresponding header name");
      tcd.put(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETLOCALADDR,
            "In a target jsp of a include in the Action phase, the method HttpServletRequest.getLocalAddr must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETLOCALNAME,
            "In a target jsp of a include in the Action phase, the method HttpServletRequest.getLocalName must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETLOCALPORT,
            "In a target jsp of a include in the Action phase, the method HttpServletRequest.getLocalPort must return 0");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETLOCALE,
            "In a target jsp of a include in the Action phase, the method HttpServletRequest.getLocale must provide the same functionality as ActionRequest.getLocale");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETLOCALES,
            "In a target jsp of a include in the Action phase, the method HttpServletRequest.getLocales must provide the same functionality as ActionRequest.getLocales");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETMETHOD,
            "In a target jsp of a include in the Action phase, the method HttpServletRequest.getMethod must provide the same functionality as ActionRequest.getMethod");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETPARAMETER,
            "In a target jsp of a include in the Action phase, the method HttpServletRequest.getParameter must provide the same functionality as ActionRequest.getParameter");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETPARAMETERMAP,
            "In a target jsp of a include in the Action phase, the method HttpServletRequest.getParameterMap must provide the same functionality as ActionRequest.getParameterMap");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETPARAMETERNAMES,
            "In a target jsp of a include in the Action phase, the method HttpServletRequest.getParameterNames must provide the same functionality as ActionRequest.getParameterNames");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETPARAMETERVALUES,
            "In a target jsp of a include in the Action phase, the method HttpServletRequest.getParameterValues must provide the same functionality as ActionRequest.getParameterValues");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETPATHINFO,
            "In a target jsp of a include in the Action phase, the method HttpServletRequest.getPathInfo must a value corresponding to the path used to obtain the PortletRequestDispatcher");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETPATHTRANSLATED,
            "In a target jsp of a include in the Action phase, the method HttpServletRequest.getPathTranslated must a value corresponding to the path used to obtain the PortletRequestDispatcher");
      tcd.put(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETPROTOCOL,
            "In a target jsp of a include in the Action phase, the method HttpServletRequest.getProtocol must return \"HTTP/1.1\"");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETQUERYSTRING,
            "In a target jsp of a include in the Action phase, the method HttpServletRequest.getQueryString must a value corresponding to the query string information used to obtain the PortletRequestDispatcher");
      tcd.put(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETREALPATH,
            "In a target jsp of a include in the Action phase, the method HttpServletRequest.getRealPath must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETREMOTEADDR,
            "In a target jsp of a include in the Action phase, the method HttpServletRequest.getRemoteAddr must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETREMOTEHOST,
            "In a target jsp of a include in the Action phase, the method HttpServletRequest.getRemoteHost must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETREMOTEPORT,
            "In a target jsp of a include in the Action phase, the method HttpServletRequest.getRemotePort must return 0");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETREMOTEUSER,
            "In a target jsp of a include in the Action phase, the method HttpServletRequest.getRemoteUser must provide the same functionality as ActionRequest.getRemoteUser");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETREQUESTDISPATCHER,
            "In a target jsp of a include in the Action phase, the method HttpServletRequest.getRequestDispatcher must provide functionality as defined in the servlet specification");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETREQUESTURI,
            "In a target jsp of a include in the Action phase, the method HttpServletRequest.getRequestURI must a value corresponding to the path and query string information used to obtain the PortletRequestDispatcher");
      tcd.put(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETREQUESTURL,
            "In a target jsp of a include in the Action phase, the method HttpServletRequest.getRequestURL must return null");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETREQUESTEDSESSIONID,
            "In a target jsp of a include in the Action phase, the method HttpServletRequest.getRequestedSessionId must provide the same functionality as ActionRequest.getRequestedSessionId");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETSCHEME,
            "In a target jsp of a include in the Action phase, the method HttpServletRequest.getScheme must provide the same functionality as ActionRequest.getScheme");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETSERVERNAME,
            "In a target jsp of a include in the Action phase, the method HttpServletRequest.getServerName must provide the same functionality as ActionRequest.getServerName");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETSERVERPORT,
            "In a target jsp of a include in the Action phase, the method HttpServletRequest.getServerPort must provide the same functionality as ActionRequest.getServerPort");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETSERVLETPATH,
            "In a target jsp of a include in the Action phase, the method HttpServletRequest.getServletPath must a value corresponding to the path used to obtain the PortletRequestDispatcher");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETSESSION,
            "In a target jsp of a include in the Action phase, the method HttpServletRequest.getSession must provide the same functionality as ActionRequest.getPortletSession(APPLICATION_SCOPE)");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETUSERPRINCIPAL,
            "In a target jsp of a include in the Action phase, the method HttpServletRequest.getUserPrincipal must provide the same functionality as ActionRequest.getUserPrincipal");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_ISREQUESTEDSESSIONIDVALID,
            "In a target jsp of a include in the Action phase, the method HttpServletRequest.isRequestedSessionIdValid must provide the same functionality as ActionRequest.isRequestedSessionIdValid");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_ISSECURE,
            "In a target jsp of a include in the Action phase, the method HttpServletRequest.isSecure must provide the same functionality as ActionRequest.isSecure");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_ISUSERINROLE,
            "In a target jsp of a include in the Action phase, the method HttpServletRequest.isUserInRole must provide the same functionality as ActionRequest.isUserInRole");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_REMOVEATTRIBUTE,
            "In a target jsp of a include in the Action phase, the method HttpServletRequest.removeAttribute must provide the same functionality as ActionRequest.removeAttribute");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONREQUEST_SETATTRIBUTE,
            "In a target jsp of a include in the Action phase, the method HttpServletRequest.setAttribute must provide the same functionality as ActionRequest.setAttribute");
      tcd.put(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONRESPONSE_CONTAINSHEADER,
            "In a target jsp of a include in the Action phase, the method HttpServletResponse.containsHeader must return false");
      tcd.put(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONRESPONSE_ENCODEREDIRECTURL1,
            "In a target jsp of a include in the Action phase, the method HttpServletResponse.encodeRedirectURL must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONRESPONSE_ENCODEREDIRECTURL,
            "In a target jsp of a include in the Action phase, the method HttpServletResponse.encodeRedirectUrl must return null");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONRESPONSE_ENCODEURL1,
            "In a target jsp of a include in the Action phase, the method HttpServletResponse.encodeURL must provide the same functionality as ActionResponse.encodeURL");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONRESPONSE_ENCODEURL,
            "In a target jsp of a include in the Action phase, the method HttpServletResponse.encodeUrl must provide the same functionality as ActionResponse.encodeURL");
      tcd.put(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONRESPONSE_GETBUFFERSIZE,
            "In a target jsp of a include in the Action phase, the method HttpServletResponse.getBufferSize must return 0");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONRESPONSE_GETCHARACTERENCODING,
            "In a target jsp of a include in the Action phase, the method HttpServletResponse.getCharacterEncoding must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONRESPONSE_GETCONTENTTYPE,
            "In a target jsp of a include in the Action phase, the method HttpServletResponse.getContentType must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONRESPONSE_GETLOCALE,
            "In a target jsp of a include in the Action phase, the method HttpServletResponse.getLocale must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPACTIONRESPONSE_ISCOMMITTED,
            "In a target jsp of a include in the Action phase, the method HttpServletResponse.isCommitted must return true");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETATTRIBUTE,
            "In a target jsp of a include in the Event phase, the method HttpServletRequest.getAttribute must provide the same functionality as EventRequest.getAttribute");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETATTRIBUTENAMES,
            "In a target jsp of a include in the Event phase, the method HttpServletRequest.getAttributeNames must provide the same functionality as EventRequest.getAttributeNames");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETAUTHTYPE,
            "In a target jsp of a include in the Event phase, the method HttpServletRequest.getAuthType must provide the same functionality as EventRequest.getAuthType");
      tcd.put(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETCHARACTERENCODING,
            "In a target jsp of a include in the Event phase, the method HttpServletRequest.getCharacterEncoding must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETCONTENTLENGTH,
            "In a target jsp of a include in the Event phase, the method HttpServletRequest.getContentLength must return 0");
      tcd.put(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETCONTENTTYPE,
            "In a target jsp of a include in the Event phase, the method HttpServletRequest.getContentType must return null");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETCONTEXTPATH,
            "In a target jsp of a include in the Event phase, the method HttpServletRequest.getContextPath must provide the same functionality as EventRequest.getContextPath");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETCOOKIES,
            "In a target jsp of a include in the Event phase, the method HttpServletRequest.getCookies must provide the same functionality as EventRequest.getCookies");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETDATEHEADER,
            "In a target jsp of a include in the Event phase, the method HttpServletRequest.getDateHeader must return a value corresponding to that returned by EventRequest.getProperty for the corresponding header name");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETHEADER,
            "In a target jsp of a include in the Event phase, the method HttpServletRequest.getHeader must return a value corresponding to that returned by EventRequest.getProperty for the corresponding header name");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETHEADERNAMES,
            "In a target jsp of a include in the Event phase, the Enumeration returned by HttpServletRequest.getHeaderNames must be contained in the Enumeration returned by EventRequest.getPropertyNames");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETHEADERS,
            "In a target jsp of a include in the Event phase, the method HttpServletRequest.getHeaders must return a value corresponding to that returned by EventRequest.getProperties for the corresponding header name");
      tcd.put(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETINPUTSTREAM,
            "In a target jsp of a include in the Event phase, the method HttpServletRequest.getInputStream must return null");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETINTHEADER,
            "In a target jsp of a include in the Event phase, the method HttpServletRequest.getIntHeader must return a value corresponding to that returned by EventRequest.getProperty for the corresponding header name");
      tcd.put(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETLOCALADDR,
            "In a target jsp of a include in the Event phase, the method HttpServletRequest.getLocalAddr must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETLOCALNAME,
            "In a target jsp of a include in the Event phase, the method HttpServletRequest.getLocalName must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETLOCALPORT,
            "In a target jsp of a include in the Event phase, the method HttpServletRequest.getLocalPort must return 0");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETLOCALE,
            "In a target jsp of a include in the Event phase, the method HttpServletRequest.getLocale must provide the same functionality as EventRequest.getLocale");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETLOCALES,
            "In a target jsp of a include in the Event phase, the method HttpServletRequest.getLocales must provide the same functionality as EventRequest.getLocales");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETMETHOD,
            "In a target jsp of a include in the Event phase, the method HttpServletRequest.getMethod must provide the same functionality as EventRequest.getMethod");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETPARAMETER,
            "In a target jsp of a include in the Event phase, the method HttpServletRequest.getParameter must provide the same functionality as EventRequest.getParameter");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETPARAMETERMAP,
            "In a target jsp of a include in the Event phase, the method HttpServletRequest.getParameterMap must provide the same functionality as EventRequest.getParameterMap");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETPARAMETERNAMES,
            "In a target jsp of a include in the Event phase, the method HttpServletRequest.getParameterNames must provide the same functionality as EventRequest.getParameterNames");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETPARAMETERVALUES,
            "In a target jsp of a include in the Event phase, the method HttpServletRequest.getParameterValues must provide the same functionality as EventRequest.getParameterValues");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETPATHINFO,
            "In a target jsp of a include in the Event phase, the method HttpServletRequest.getPathInfo must a value corresponding to the path used to obtain the PortletRequestDispatcher");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETPATHTRANSLATED,
            "In a target jsp of a include in the Event phase, the method HttpServletRequest.getPathTranslated must a value corresponding to the path used to obtain the PortletRequestDispatcher");
      tcd.put(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETPROTOCOL,
            "In a target jsp of a include in the Event phase, the method HttpServletRequest.getProtocol must return \"HTTP/1.1\"");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETQUERYSTRING,
            "In a target jsp of a include in the Event phase, the method HttpServletRequest.getQueryString must a value corresponding to the query string information used to obtain the PortletRequestDispatcher");
      tcd.put(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETREADER,
            "In a target jsp of a include in the Event phase, the method HttpServletRequest.getReader must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETREALPATH,
            "In a target jsp of a include in the Event phase, the method HttpServletRequest.getRealPath must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETREMOTEADDR,
            "In a target jsp of a include in the Event phase, the method HttpServletRequest.getRemoteAddr must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETREMOTEHOST,
            "In a target jsp of a include in the Event phase, the method HttpServletRequest.getRemoteHost must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETREMOTEPORT,
            "In a target jsp of a include in the Event phase, the method HttpServletRequest.getRemotePort must return 0");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETREMOTEUSER,
            "In a target jsp of a include in the Event phase, the method HttpServletRequest.getRemoteUser must provide the same functionality as EventRequest.getRemoteUser");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETREQUESTDISPATCHER,
            "In a target jsp of a include in the Event phase, the method HttpServletRequest.getRequestDispatcher must provide functionality as defined in the servlet specification");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETREQUESTURI,
            "In a target jsp of a include in the Event phase, the method HttpServletRequest.getRequestURI must a value corresponding to the path and query string information used to obtain the PortletRequestDispatcher");
      tcd.put(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETREQUESTURL,
            "In a target jsp of a include in the Event phase, the method HttpServletRequest.getRequestURL must return null");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETREQUESTEDSESSIONID,
            "In a target jsp of a include in the Event phase, the method HttpServletRequest.getRequestedSessionId must provide the same functionality as EventRequest.getRequestedSessionId");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETSCHEME,
            "In a target jsp of a include in the Event phase, the method HttpServletRequest.getScheme must provide the same functionality as EventRequest.getScheme");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETSERVERNAME,
            "In a target jsp of a include in the Event phase, the method HttpServletRequest.getServerName must provide the same functionality as EventRequest.getServerName");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETSERVERPORT,
            "In a target jsp of a include in the Event phase, the method HttpServletRequest.getServerPort must provide the same functionality as EventRequest.getServerPort");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETSERVLETPATH,
            "In a target jsp of a include in the Event phase, the method HttpServletRequest.getServletPath must a value corresponding to the path used to obtain the PortletRequestDispatcher");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETSESSION,
            "In a target jsp of a include in the Event phase, the method HttpServletRequest.getSession must provide the same functionality as EventRequest.getPortletSession(APPLICATION_SCOPE)");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETUSERPRINCIPAL,
            "In a target jsp of a include in the Event phase, the method HttpServletRequest.getUserPrincipal must provide the same functionality as EventRequest.getUserPrincipal");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_ISREQUESTEDSESSIONIDVALID,
            "In a target jsp of a include in the Event phase, the method HttpServletRequest.isRequestedSessionIdValid must provide the same functionality as EventRequest.isRequestedSessionIdValid");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_ISSECURE,
            "In a target jsp of a include in the Event phase, the method HttpServletRequest.isSecure must provide the same functionality as EventRequest.isSecure");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_ISUSERINROLE,
            "In a target jsp of a include in the Event phase, the method HttpServletRequest.isUserInRole must provide the same functionality as EventRequest.isUserInRole");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_REMOVEATTRIBUTE,
            "In a target jsp of a include in the Event phase, the method HttpServletRequest.removeAttribute must provide the same functionality as EventRequest.removeAttribute");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_SETATTRIBUTE,
            "In a target jsp of a include in the Event phase, the method HttpServletRequest.setAttribute must provide the same functionality as EventRequest.setAttribute");
      tcd.put(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTRESPONSE_CONTAINSHEADER,
            "In a target jsp of a include in the Event phase, the method HttpServletResponse.containsHeader must return false");
      tcd.put(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTRESPONSE_ENCODEREDIRECTURL1,
            "In a target jsp of a include in the Event phase, the method HttpServletResponse.encodeRedirectURL must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTRESPONSE_ENCODEREDIRECTURL,
            "In a target jsp of a include in the Event phase, the method HttpServletResponse.encodeRedirectUrl must return null");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTRESPONSE_ENCODEURL1,
            "In a target jsp of a include in the Event phase, the method HttpServletResponse.encodeURL must provide the same functionality as EventResponse.encodeURL");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTRESPONSE_ENCODEURL,
            "In a target jsp of a include in the Event phase, the method HttpServletResponse.encodeUrl must provide the same functionality as EventResponse.encodeURL");
      tcd.put(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTRESPONSE_GETBUFFERSIZE,
            "In a target jsp of a include in the Event phase, the method HttpServletResponse.getBufferSize must return 0");
      tcd.put(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTRESPONSE_GETCHARACTERENCODING,
            "In a target jsp of a include in the Event phase, the method HttpServletResponse.getCharacterEncoding must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTRESPONSE_GETCONTENTTYPE,
            "In a target jsp of a include in the Event phase, the method HttpServletResponse.getContentType must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTRESPONSE_GETLOCALE,
            "In a target jsp of a include in the Event phase, the method HttpServletResponse.getLocale must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTRESPONSE_ISCOMMITTED,
            "In a target jsp of a include in the Event phase, the method HttpServletResponse.isCommitted must return true");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETATTRIBUTE,
            "In a target jsp of a include in the Render phase, the method HttpServletRequest.getAttribute must provide the same functionality as RenderRequest.getAttribute");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETATTRIBUTENAMES,
            "In a target jsp of a include in the Render phase, the method HttpServletRequest.getAttributeNames must provide the same functionality as RenderRequest.getAttributeNames");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETAUTHTYPE,
            "In a target jsp of a include in the Render phase, the method HttpServletRequest.getAuthType must provide the same functionality as RenderRequest.getAuthType");
      tcd.put(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETCHARACTERENCODING,
            "In a target jsp of a include in the Render phase, the method HttpServletRequest.getCharacterEncoding must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETCONTENTLENGTH,
            "In a target jsp of a include in the Render phase, the method HttpServletRequest.getContentLength must return 0");
      tcd.put(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETCONTENTTYPE,
            "In a target jsp of a include in the Render phase, the method HttpServletRequest.getContentType must return null");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETCONTEXTPATH,
            "In a target jsp of a include in the Render phase, the method HttpServletRequest.getContextPath must provide the same functionality as RenderRequest.getContextPath");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETCOOKIES,
            "In a target jsp of a include in the Render phase, the method HttpServletRequest.getCookies must provide the same functionality as RenderRequest.getCookies");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETDATEHEADER,
            "In a target jsp of a include in the Render phase, the method HttpServletRequest.getDateHeader must return a value corresponding to that returned by RenderRequest.getProperty for the corresponding header name");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETHEADER,
            "In a target jsp of a include in the Render phase, the method HttpServletRequest.getHeader must return a value corresponding to that returned by RenderRequest.getProperty for the corresponding header name");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETHEADERNAMES,
            "In a target jsp of a include in the Render phase, the Enumeration returned by HttpServletRequest.getHeaderNames must be contained in the Enumeration returned by RenderRequest.getPropertyNames");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETHEADERS,
            "In a target jsp of a include in the Render phase, the method HttpServletRequest.getHeaders must return a value corresponding to that returned by RenderRequest.getProperties for the corresponding header name");
      tcd.put(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETINPUTSTREAM,
            "In a target jsp of a include in the Render phase, the method HttpServletRequest.getInputStream must return null");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETINTHEADER,
            "In a target jsp of a include in the Render phase, the method HttpServletRequest.getIntHeader must return a value corresponding to that returned by RenderRequest.getProperty for the corresponding header name");
      tcd.put(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETLOCALADDR,
            "In a target jsp of a include in the Render phase, the method HttpServletRequest.getLocalAddr must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETLOCALNAME,
            "In a target jsp of a include in the Render phase, the method HttpServletRequest.getLocalName must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETLOCALPORT,
            "In a target jsp of a include in the Render phase, the method HttpServletRequest.getLocalPort must return 0");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETLOCALE,
            "In a target jsp of a include in the Render phase, the method HttpServletRequest.getLocale must provide the same functionality as RenderRequest.getLocale");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETLOCALES,
            "In a target jsp of a include in the Render phase, the method HttpServletRequest.getLocales must provide the same functionality as RenderRequest.getLocales");
      tcd.put(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETMETHOD,
            "In a target jsp of a include in the Render phase, the method HttpServletRequest.getMethod must return \"GET\"");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETPARAMETER,
            "In a target jsp of a include in the Render phase, the method HttpServletRequest.getParameter must provide the same functionality as RenderRequest.getParameter");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETPARAMETERMAP,
            "In a target jsp of a include in the Render phase, the method HttpServletRequest.getParameterMap must provide the same functionality as RenderRequest.getParameterMap");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETPARAMETERNAMES,
            "In a target jsp of a include in the Render phase, the method HttpServletRequest.getParameterNames must provide the same functionality as RenderRequest.getParameterNames");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETPARAMETERVALUES,
            "In a target jsp of a include in the Render phase, the method HttpServletRequest.getParameterValues must provide the same functionality as RenderRequest.getParameterValues");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETPATHINFO,
            "In a target jsp of a include in the Render phase, the method HttpServletRequest.getPathInfo must a value corresponding to the path used to obtain the PortletRequestDispatcher");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETPATHTRANSLATED,
            "In a target jsp of a include in the Render phase, the method HttpServletRequest.getPathTranslated must a value corresponding to the path used to obtain the PortletRequestDispatcher");
      tcd.put(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETPROTOCOL,
            "In a target jsp of a include in the Render phase, the method HttpServletRequest.getProtocol must return \"HTTP/1.1\"");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETQUERYSTRING,
            "In a target jsp of a include in the Render phase, the method HttpServletRequest.getQueryString must a value corresponding to the query string information used to obtain the PortletRequestDispatcher");
      tcd.put(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETREADER,
            "In a target jsp of a include in the Render phase, the method HttpServletRequest.getReader must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETREALPATH,
            "In a target jsp of a include in the Render phase, the method HttpServletRequest.getRealPath must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETREMOTEADDR,
            "In a target jsp of a include in the Render phase, the method HttpServletRequest.getRemoteAddr must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETREMOTEHOST,
            "In a target jsp of a include in the Render phase, the method HttpServletRequest.getRemoteHost must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETREMOTEPORT,
            "In a target jsp of a include in the Render phase, the method HttpServletRequest.getRemotePort must return 0");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETREMOTEUSER,
            "In a target jsp of a include in the Render phase, the method HttpServletRequest.getRemoteUser must provide the same functionality as RenderRequest.getRemoteUser");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETREQUESTDISPATCHER,
            "In a target jsp of a include in the Render phase, the method HttpServletRequest.getRequestDispatcher must provide functionality as defined in the servlet specification");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETREQUESTURI,
            "In a target jsp of a include in the Render phase, the method HttpServletRequest.getRequestURI must a value corresponding to the path and query string information used to obtain the PortletRequestDispatcher");
      tcd.put(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETREQUESTURL,
            "In a target jsp of a include in the Render phase, the method HttpServletRequest.getRequestURL must return null");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETREQUESTEDSESSIONID,
            "In a target jsp of a include in the Render phase, the method HttpServletRequest.getRequestedSessionId must provide the same functionality as RenderRequest.getRequestedSessionId");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETSCHEME,
            "In a target jsp of a include in the Render phase, the method HttpServletRequest.getScheme must provide the same functionality as RenderRequest.getScheme");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETSERVERNAME,
            "In a target jsp of a include in the Render phase, the method HttpServletRequest.getServerName must provide the same functionality as RenderRequest.getServerName");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETSERVERPORT,
            "In a target jsp of a include in the Render phase, the method HttpServletRequest.getServerPort must provide the same functionality as RenderRequest.getServerPort");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETSERVLETPATH,
            "In a target jsp of a include in the Render phase, the method HttpServletRequest.getServletPath must a value corresponding to the path used to obtain the PortletRequestDispatcher");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETSESSION,
            "In a target jsp of a include in the Render phase, the method HttpServletRequest.getSession must provide the same functionality as RenderRequest.getPortletSession(APPLICATION_SCOPE)");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_GETUSERPRINCIPAL,
            "In a target jsp of a include in the Render phase, the method HttpServletRequest.getUserPrincipal must provide the same functionality as RenderRequest.getUserPrincipal");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_ISREQUESTEDSESSIONIDVALID,
            "In a target jsp of a include in the Render phase, the method HttpServletRequest.isRequestedSessionIdValid must provide the same functionality as RenderRequest.isRequestedSessionIdValid");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_ISSECURE,
            "In a target jsp of a include in the Render phase, the method HttpServletRequest.isSecure must provide the same functionality as RenderRequest.isSecure");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_ISUSERINROLE,
            "In a target jsp of a include in the Render phase, the method HttpServletRequest.isUserInRole must provide the same functionality as RenderRequest.isUserInRole");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_REMOVEATTRIBUTE,
            "In a target jsp of a include in the Render phase, the method HttpServletRequest.removeAttribute must provide the same functionality as RenderRequest.removeAttribute");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERREQUEST_SETATTRIBUTE,
            "In a target jsp of a include in the Render phase, the method HttpServletRequest.setAttribute must provide the same functionality as RenderRequest.setAttribute");
      tcd.put(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERRESPONSE_CONTAINSHEADER,
            "In a target jsp of a include in the Render phase, the method HttpServletResponse.containsHeader must return false");
      tcd.put(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERRESPONSE_ENCODEREDIRECTURL1,
            "In a target jsp of a include in the Render phase, the method HttpServletResponse.encodeRedirectURL must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERRESPONSE_ENCODEREDIRECTURL,
            "In a target jsp of a include in the Render phase, the method HttpServletResponse.encodeRedirectUrl must return null");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERRESPONSE_ENCODEURL1,
            "In a target jsp of a include in the Render phase, the method HttpServletResponse.encodeURL must provide the same functionality as RenderResponse.encodeURL");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERRESPONSE_ENCODEURL,
            "In a target jsp of a include in the Render phase, the method HttpServletResponse.encodeUrl must provide the same functionality as RenderResponse.encodeURL");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERRESPONSE_GETBUFFERSIZE,
            "In a target jsp of a include in the Render phase, the method HttpServletResponse.getBufferSize must provide the same functionality as RenderResponse.getBufferSize");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERRESPONSE_GETCHARACTERENCODING,
            "In a target jsp of a include in the Render phase, the method HttpServletResponse.getCharacterEncoding must provide the same functionality as RenderResponse.getCharacterEncoding");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERRESPONSE_GETCONTENTTYPE,
            "In a target jsp of a include in the Render phase, the method HttpServletResponse.getContentType must provide the same functionality as RenderResponse.getContentType");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERRESPONSE_GETLOCALE,
            "In a target jsp of a include in the Render phase, the method HttpServletResponse.getLocale must provide the same functionality as RenderResponse.getLocale");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRENDERRESPONSE_ISCOMMITTED,
            "In a target jsp of a include in the Render phase, the method HttpServletResponse.isCommitted must provide the same functionality as RenderResponse.isCommitted");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETATTRIBUTE,
            "In a target jsp of a include in the Resource phase, the method HttpServletRequest.getAttribute must provide the same functionality as ResourceRequest.getAttribute");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETATTRIBUTENAMES,
            "In a target jsp of a include in the Resource phase, the method HttpServletRequest.getAttributeNames must provide the same functionality as ResourceRequest.getAttributeNames");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETAUTHTYPE,
            "In a target jsp of a include in the Resource phase, the method HttpServletRequest.getAuthType must provide the same functionality as ResourceRequest.getAuthType");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETCHARACTERENCODING,
            "In a target jsp of a include in the Resource phase, the method HttpServletRequest.getCharacterEncoding must provide the same functionality as ResourceRequest.getCharacterEncoding");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETCONTENTLENGTH,
            "In a target jsp of a include in the Resource phase, the method HttpServletRequest.getContentLength must provide the same functionality as ResourceRequest.getContentLength");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETCONTENTTYPE,
            "In a target jsp of a include in the Resource phase, the method HttpServletRequest.getContentType must provide the same functionality as ResourceRequest.getContentType");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETCONTEXTPATH,
            "In a target jsp of a include in the Resource phase, the method HttpServletRequest.getContextPath must provide the same functionality as ResourceRequest.getContextPath");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETCOOKIES,
            "In a target jsp of a include in the Resource phase, the method HttpServletRequest.getCookies must provide the same functionality as ResourceRequest.getCookies");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETDATEHEADER,
            "In a target jsp of a include in the Resource phase, the method HttpServletRequest.getDateHeader must return a value corresponding to that returned by ResourceRequest.getProperty for the corresponding header name");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETHEADER,
            "In a target jsp of a include in the Resource phase, the method HttpServletRequest.getHeader must return a value corresponding to that returned by ResourceRequest.getProperty for the corresponding header name");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETHEADERNAMES,
            "In a target jsp of a include in the Resource phase, the Enumeration returned by HttpServletRequest.getHeaderNames must be contained in the Enumeration returned by ResourceRequest.getPropertyNames");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETHEADERS,
            "In a target jsp of a include in the Resource phase, the method HttpServletRequest.getHeaders must return a value corresponding to that returned by ResourceRequest.getProperties for the corresponding header name");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETINTHEADER,
            "In a target jsp of a include in the Resource phase, the method HttpServletRequest.getIntHeader must return a value corresponding to that returned by ResourceRequest.getProperty for the corresponding header name");
      tcd.put(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETLOCALADDR,
            "In a target jsp of a include in the Resource phase, the method HttpServletRequest.getLocalAddr must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETLOCALNAME,
            "In a target jsp of a include in the Resource phase, the method HttpServletRequest.getLocalName must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETLOCALPORT,
            "In a target jsp of a include in the Resource phase, the method HttpServletRequest.getLocalPort must return 0");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETLOCALE,
            "In a target jsp of a include in the Resource phase, the method HttpServletRequest.getLocale must provide the same functionality as ResourceRequest.getLocale");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETLOCALES,
            "In a target jsp of a include in the Resource phase, the method HttpServletRequest.getLocales must provide the same functionality as ResourceRequest.getLocales");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETMETHOD,
            "In a target jsp of a include in the Resource phase, the method HttpServletRequest.getMethod must provide the same functionality as ResourceRequest.getMethod");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETPARAMETER,
            "In a target jsp of a include in the Resource phase, the method HttpServletRequest.getParameter must provide the same functionality as ResourceRequest.getParameter");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETPARAMETERMAP,
            "In a target jsp of a include in the Resource phase, the method HttpServletRequest.getParameterMap must provide the same functionality as ResourceRequest.getParameterMap");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETPARAMETERNAMES,
            "In a target jsp of a include in the Resource phase, the method HttpServletRequest.getParameterNames must provide the same functionality as ResourceRequest.getParameterNames");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETPARAMETERVALUES,
            "In a target jsp of a include in the Resource phase, the method HttpServletRequest.getParameterValues must provide the same functionality as ResourceRequest.getParameterValues");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETPATHINFO,
            "In a target jsp of a include in the Resource phase, the method HttpServletRequest.getPathInfo must a value corresponding to the path used to obtain the PortletRequestDispatcher");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETPATHTRANSLATED,
            "In a target jsp of a include in the Resource phase, the method HttpServletRequest.getPathTranslated must a value corresponding to the path used to obtain the PortletRequestDispatcher");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETPROTOCOL,
            "In a target jsp of a include in the Resource phase, the method HttpServletRequest.getProtocol must return \"HTTP/1.1\"");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETQUERYSTRING,
            "In a target jsp of a include in the Resource phase, the method HttpServletRequest.getQueryString must a value corresponding to the query string information used to obtain the PortletRequestDispatcher");
      tcd.put(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETREALPATH,
            "In a target jsp of a include in the Resource phase, the method HttpServletRequest.getRealPath must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETREMOTEADDR,
            "In a target jsp of a include in the Resource phase, the method HttpServletRequest.getRemoteAddr must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETREMOTEHOST,
            "In a target jsp of a include in the Resource phase, the method HttpServletRequest.getRemoteHost must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETREMOTEPORT,
            "In a target jsp of a include in the Resource phase, the method HttpServletRequest.getRemotePort must return 0");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETREMOTEUSER,
            "In a target jsp of a include in the Resource phase, the method HttpServletRequest.getRemoteUser must provide the same functionality as ResourceRequest.getRemoteUser");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETREQUESTDISPATCHER,
            "In a target jsp of a include in the Resource phase, the method HttpServletRequest.getRequestDispatcher must provide functionality as defined in the servlet specification");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETREQUESTURI,
            "In a target jsp of a include in the Resource phase, the method HttpServletRequest.getRequestURI must a value corresponding to the path and query string information used to obtain the PortletRequestDispatcher");
      tcd.put(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETREQUESTURL,
            "In a target jsp of a include in the Resource phase, the method HttpServletRequest.getRequestURL must return null");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETREQUESTEDSESSIONID,
            "In a target jsp of a include in the Resource phase, the method HttpServletRequest.getRequestedSessionId must provide the same functionality as ResourceRequest.getRequestedSessionId");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETSCHEME,
            "In a target jsp of a include in the Resource phase, the method HttpServletRequest.getScheme must provide the same functionality as ResourceRequest.getScheme");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETSERVERNAME,
            "In a target jsp of a include in the Resource phase, the method HttpServletRequest.getServerName must provide the same functionality as ResourceRequest.getServerName");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETSERVERPORT,
            "In a target jsp of a include in the Resource phase, the method HttpServletRequest.getServerPort must provide the same functionality as ResourceRequest.getServerPort");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETSERVLETPATH,
            "In a target jsp of a include in the Resource phase, the method HttpServletRequest.getServletPath must a value corresponding to the path used to obtain the PortletRequestDispatcher");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETSESSION,
            "In a target jsp of a include in the Resource phase, the method HttpServletRequest.getSession must provide the same functionality as ResourceRequest.getPortletSession(APPLICATION_SCOPE)");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETUSERPRINCIPAL,
            "In a target jsp of a include in the Resource phase, the method HttpServletRequest.getUserPrincipal must provide the same functionality as ResourceRequest.getUserPrincipal");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_ISREQUESTEDSESSIONIDVALID,
            "In a target jsp of a include in the Resource phase, the method HttpServletRequest.isRequestedSessionIdValid must provide the same functionality as ResourceRequest.isRequestedSessionIdValid");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_ISSECURE,
            "In a target jsp of a include in the Resource phase, the method HttpServletRequest.isSecure must provide the same functionality as ResourceRequest.isSecure");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_ISUSERINROLE,
            "In a target jsp of a include in the Resource phase, the method HttpServletRequest.isUserInRole must provide the same functionality as ResourceRequest.isUserInRole");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_REMOVEATTRIBUTE,
            "In a target jsp of a include in the Resource phase, the method HttpServletRequest.removeAttribute must provide the same functionality as ResourceRequest.removeAttribute");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_SETATTRIBUTE,
            "In a target jsp of a include in the Resource phase, the method HttpServletRequest.setAttribute must provide the same functionality as ResourceRequest.setAttribute");
      tcd.put(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCERESPONSE_CONTAINSHEADER,
            "In a target jsp of a include in the Resource phase, the method HttpServletResponse.containsHeader must return false");
      tcd.put(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCERESPONSE_ENCODEREDIRECTURL1,
            "In a target jsp of a include in the Resource phase, the method HttpServletResponse.encodeRedirectURL must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCERESPONSE_ENCODEREDIRECTURL,
            "In a target jsp of a include in the Resource phase, the method HttpServletResponse.encodeRedirectUrl must return null");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCERESPONSE_ENCODEURL1,
            "In a target jsp of a include in the Resource phase, the method HttpServletResponse.encodeURL must provide the same functionality as ResourceResponse.encodeURL");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCERESPONSE_ENCODEURL,
            "In a target jsp of a include in the Resource phase, the method HttpServletResponse.encodeUrl must provide the same functionality as ResourceResponse.encodeURL");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCERESPONSE_GETBUFFERSIZE,
            "In a target jsp of a include in the Resource phase, the method HttpServletResponse.getBufferSize must provide the same functionality as ResourceResponse.getBufferSize");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCERESPONSE_GETCHARACTERENCODING,
            "In a target jsp of a include in the Resource phase, the method HttpServletResponse.getCharacterEncoding must provide the same functionality as ResourceResponse.getCharacterEncoding");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCERESPONSE_GETCONTENTTYPE,
            "In a target jsp of a include in the Resource phase, the method HttpServletResponse.getContentType must provide the same functionality as ResourceResponse.getContentType");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCERESPONSE_GETLOCALE,
            "In a target jsp of a include in the Resource phase, the method HttpServletResponse.getLocale must provide the same functionality as ResourceResponse.getLocale");
      tcd.put(
            V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPRESOURCERESPONSE_ISCOMMITTED,
            "In a target jsp of a include in the Resource phase, the method HttpServletResponse.isCommitted must provide the same functionality as ResourceResponse.isCommitted");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETATTRIBUTE,
            "In a target servlet of a include in the Action phase, the method HttpServletRequest.getAttribute must provide the same functionality as ActionRequest.getAttribute");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETATTRIBUTENAMES,
            "In a target servlet of a include in the Action phase, the method HttpServletRequest.getAttributeNames must provide the same functionality as ActionRequest.getAttributeNames");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETAUTHTYPE,
            "In a target servlet of a include in the Action phase, the method HttpServletRequest.getAuthType must provide the same functionality as ActionRequest.getAuthType");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETCHARACTERENCODING,
            "In a target servlet of a include in the Action phase, the method HttpServletRequest.getCharacterEncoding must provide the same functionality as ActionRequest.getCharacterEncoding");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETCONTENTLENGTH,
            "In a target servlet of a include in the Action phase, the method HttpServletRequest.getContentLength must provide the same functionality as ActionRequest.getContentLength");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETCONTENTTYPE,
            "In a target servlet of a include in the Action phase, the method HttpServletRequest.getContentType must provide the same functionality as ActionRequest.getContentType");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETCONTEXTPATH,
            "In a target servlet of a include in the Action phase, the method HttpServletRequest.getContextPath must provide the same functionality as ActionRequest.getContextPath");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETCOOKIES,
            "In a target servlet of a include in the Action phase, the method HttpServletRequest.getCookies must provide the same functionality as ActionRequest.getCookies");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETDATEHEADER,
            "In a target servlet of a include in the Action phase, the method HttpServletRequest.getDateHeader must return a value corresponding to that returned by ActionRequest.getProperty for the corresponding header name");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETHEADER,
            "In a target servlet of a include in the Action phase, the method HttpServletRequest.getHeader must return a value corresponding to that returned by ActionRequest.getProperty for the corresponding header name");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETHEADERNAMES,
            "In a target servlet of a include in the Action phase, the Enumeration returned by HttpServletRequest.getHeaderNames must be contained in the Enumeration returned by ActionRequest.getPropertyNames");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETHEADERS,
            "In a target servlet of a include in the Action phase, the method HttpServletRequest.getHeaders must return a value corresponding to that returned by ActionRequest.getProperties for the corresponding header name");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETINTHEADER,
            "In a target servlet of a include in the Action phase, the method HttpServletRequest.getIntHeader must return a value corresponding to that returned by ActionRequest.getProperty for the corresponding header name");
      tcd.put(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETLOCALADDR,
            "In a target servlet of a include in the Action phase, the method HttpServletRequest.getLocalAddr must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETLOCALNAME,
            "In a target servlet of a include in the Action phase, the method HttpServletRequest.getLocalName must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETLOCALPORT,
            "In a target servlet of a include in the Action phase, the method HttpServletRequest.getLocalPort must return 0");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETLOCALE,
            "In a target servlet of a include in the Action phase, the method HttpServletRequest.getLocale must provide the same functionality as ActionRequest.getLocale");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETLOCALES,
            "In a target servlet of a include in the Action phase, the method HttpServletRequest.getLocales must provide the same functionality as ActionRequest.getLocales");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETMETHOD,
            "In a target servlet of a include in the Action phase, the method HttpServletRequest.getMethod must provide the same functionality as ActionRequest.getMethod");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETPARAMETER,
            "In a target servlet of a include in the Action phase, the method HttpServletRequest.getParameter must provide the same functionality as ActionRequest.getParameter");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETPARAMETERMAP,
            "In a target servlet of a include in the Action phase, the method HttpServletRequest.getParameterMap must provide the same functionality as ActionRequest.getParameterMap");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETPARAMETERNAMES,
            "In a target servlet of a include in the Action phase, the method HttpServletRequest.getParameterNames must provide the same functionality as ActionRequest.getParameterNames");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETPARAMETERVALUES,
            "In a target servlet of a include in the Action phase, the method HttpServletRequest.getParameterValues must provide the same functionality as ActionRequest.getParameterValues");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETPATHINFO,
            "In a target servlet of a include in the Action phase, the method HttpServletRequest.getPathInfo must a value corresponding to the path used to obtain the PortletRequestDispatcher");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETPATHTRANSLATED,
            "In a target servlet of a include in the Action phase, the method HttpServletRequest.getPathTranslated must a value corresponding to the path used to obtain the PortletRequestDispatcher");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETPROTOCOL,
            "In a target servlet of a include in the Action phase, the method HttpServletRequest.getProtocol must return \"HTTP/1.1\"");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETQUERYSTRING,
            "In a target servlet of a include in the Action phase, the method HttpServletRequest.getQueryString must a value corresponding to the query string information used to obtain the PortletRequestDispatcher");
      tcd.put(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETREALPATH,
            "In a target servlet of a include in the Action phase, the method HttpServletRequest.getRealPath must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETREMOTEADDR,
            "In a target servlet of a include in the Action phase, the method HttpServletRequest.getRemoteAddr must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETREMOTEHOST,
            "In a target servlet of a include in the Action phase, the method HttpServletRequest.getRemoteHost must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETREMOTEPORT,
            "In a target servlet of a include in the Action phase, the method HttpServletRequest.getRemotePort must return 0");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETREMOTEUSER,
            "In a target servlet of a include in the Action phase, the method HttpServletRequest.getRemoteUser must provide the same functionality as ActionRequest.getRemoteUser");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETREQUESTDISPATCHER,
            "In a target servlet of a include in the Action phase, the method HttpServletRequest.getRequestDispatcher must provide functionality as defined in the servlet specification");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETREQUESTURI,
            "In a target servlet of a include in the Action phase, the method HttpServletRequest.getRequestURI must a value corresponding to the path and query string information used to obtain the PortletRequestDispatcher");
      tcd.put(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETREQUESTURL,
            "In a target servlet of a include in the Action phase, the method HttpServletRequest.getRequestURL must return null");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETREQUESTEDSESSIONID,
            "In a target servlet of a include in the Action phase, the method HttpServletRequest.getRequestedSessionId must provide the same functionality as ActionRequest.getRequestedSessionId");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETSCHEME,
            "In a target servlet of a include in the Action phase, the method HttpServletRequest.getScheme must provide the same functionality as ActionRequest.getScheme");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETSERVERNAME,
            "In a target servlet of a include in the Action phase, the method HttpServletRequest.getServerName must provide the same functionality as ActionRequest.getServerName");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETSERVERPORT,
            "In a target servlet of a include in the Action phase, the method HttpServletRequest.getServerPort must provide the same functionality as ActionRequest.getServerPort");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETSERVLETPATH,
            "In a target servlet of a include in the Action phase, the method HttpServletRequest.getServletPath must a value corresponding to the path used to obtain the PortletRequestDispatcher");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETSESSION,
            "In a target servlet of a include in the Action phase, the method HttpServletRequest.getSession must provide the same functionality as ActionRequest.getPortletSession(APPLICATION_SCOPE)");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETUSERPRINCIPAL,
            "In a target servlet of a include in the Action phase, the method HttpServletRequest.getUserPrincipal must provide the same functionality as ActionRequest.getUserPrincipal");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_ISREQUESTEDSESSIONIDVALID,
            "In a target servlet of a include in the Action phase, the method HttpServletRequest.isRequestedSessionIdValid must provide the same functionality as ActionRequest.isRequestedSessionIdValid");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_ISSECURE,
            "In a target servlet of a include in the Action phase, the method HttpServletRequest.isSecure must provide the same functionality as ActionRequest.isSecure");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_ISUSERINROLE,
            "In a target servlet of a include in the Action phase, the method HttpServletRequest.isUserInRole must provide the same functionality as ActionRequest.isUserInRole");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_REMOVEATTRIBUTE,
            "In a target servlet of a include in the Action phase, the method HttpServletRequest.removeAttribute must provide the same functionality as ActionRequest.removeAttribute");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONREQUEST_SETATTRIBUTE,
            "In a target servlet of a include in the Action phase, the method HttpServletRequest.setAttribute must provide the same functionality as ActionRequest.setAttribute");
      tcd.put(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONRESPONSE_CONTAINSHEADER,
            "In a target servlet of a include in the Action phase, the method HttpServletResponse.containsHeader must return false");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONRESPONSE_ENCODEREDIRECTURL1,
            "In a target servlet of a include in the Action phase, the method HttpServletResponse.encodeRedirectURL must return null");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONRESPONSE_ENCODEREDIRECTURL,
            "In a target servlet of a include in the Action phase, the method HttpServletResponse.encodeRedirectUrl must return null");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONRESPONSE_ENCODEURL1,
            "In a target servlet of a include in the Action phase, the method HttpServletResponse.encodeURL must provide the same functionality as ActionResponse.encodeURL");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONRESPONSE_ENCODEURL,
            "In a target servlet of a include in the Action phase, the method HttpServletResponse.encodeUrl must provide the same functionality as ActionResponse.encodeURL");
      tcd.put(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONRESPONSE_GETBUFFERSIZE,
            "In a target servlet of a include in the Action phase, the method HttpServletResponse.getBufferSize must return 0");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONRESPONSE_GETCHARACTERENCODING,
            "In a target servlet of a include in the Action phase, the method HttpServletResponse.getCharacterEncoding must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONRESPONSE_GETCONTENTTYPE,
            "In a target servlet of a include in the Action phase, the method HttpServletResponse.getContentType must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONRESPONSE_GETLOCALE,
            "In a target servlet of a include in the Action phase, the method HttpServletResponse.getLocale must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETACTIONRESPONSE_ISCOMMITTED,
            "In a target servlet of a include in the Action phase, the method HttpServletResponse.isCommitted must return true");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETATTRIBUTE,
            "In a target servlet of a include in the Event phase, the method HttpServletRequest.getAttribute must provide the same functionality as EventRequest.getAttribute");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETATTRIBUTENAMES,
            "In a target servlet of a include in the Event phase, the method HttpServletRequest.getAttributeNames must provide the same functionality as EventRequest.getAttributeNames");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETAUTHTYPE,
            "In a target servlet of a include in the Event phase, the method HttpServletRequest.getAuthType must provide the same functionality as EventRequest.getAuthType");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETCHARACTERENCODING,
            "In a target servlet of a include in the Event phase, the method HttpServletRequest.getCharacterEncoding must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETCONTENTLENGTH,
            "In a target servlet of a include in the Event phase, the method HttpServletRequest.getContentLength must return 0");
      tcd.put(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETCONTENTTYPE,
            "In a target servlet of a include in the Event phase, the method HttpServletRequest.getContentType must return null");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETCONTEXTPATH,
            "In a target servlet of a include in the Event phase, the method HttpServletRequest.getContextPath must provide the same functionality as EventRequest.getContextPath");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETCOOKIES,
            "In a target servlet of a include in the Event phase, the method HttpServletRequest.getCookies must provide the same functionality as EventRequest.getCookies");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETDATEHEADER,
            "In a target servlet of a include in the Event phase, the method HttpServletRequest.getDateHeader must return a value corresponding to that returned by EventRequest.getProperty for the corresponding header name");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETHEADER,
            "In a target servlet of a include in the Event phase, the method HttpServletRequest.getHeader must return a value corresponding to that returned by EventRequest.getProperty for the corresponding header name");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETHEADERNAMES,
            "In a target servlet of a include in the Event phase, the Enumeration returned by HttpServletRequest.getHeaderNames must be contained in the Enumeration returned by EventRequest.getPropertyNames");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETHEADERS,
            "In a target servlet of a include in the Event phase, the method HttpServletRequest.getHeaders must return a value corresponding to that returned by EventRequest.getProperties for the corresponding header name");
      tcd.put(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETINPUTSTREAM,
            "In a target servlet of a include in the Event phase, the method HttpServletRequest.getInputStream must return null");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETINTHEADER,
            "In a target servlet of a include in the Event phase, the method HttpServletRequest.getIntHeader must return a value corresponding to that returned by EventRequest.getProperty for the corresponding header name");
      tcd.put(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETLOCALADDR,
            "In a target servlet of a include in the Event phase, the method HttpServletRequest.getLocalAddr must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETLOCALNAME,
            "In a target servlet of a include in the Event phase, the method HttpServletRequest.getLocalName must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETLOCALPORT,
            "In a target servlet of a include in the Event phase, the method HttpServletRequest.getLocalPort must return 0");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETLOCALE,
            "In a target servlet of a include in the Event phase, the method HttpServletRequest.getLocale must provide the same functionality as EventRequest.getLocale");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETLOCALES,
            "In a target servlet of a include in the Event phase, the method HttpServletRequest.getLocales must provide the same functionality as EventRequest.getLocales");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETMETHOD,
            "In a target servlet of a include in the Event phase, the method HttpServletRequest.getMethod must provide the same functionality as EventRequest.getMethod");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETPARAMETER,
            "In a target servlet of a include in the Event phase, the method HttpServletRequest.getParameter must provide the same functionality as EventRequest.getParameter");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETPARAMETERMAP,
            "In a target servlet of a include in the Event phase, the method HttpServletRequest.getParameterMap must provide the same functionality as EventRequest.getParameterMap");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETPARAMETERNAMES,
            "In a target servlet of a include in the Event phase, the method HttpServletRequest.getParameterNames must provide the same functionality as EventRequest.getParameterNames");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETPARAMETERVALUES,
            "In a target servlet of a include in the Event phase, the method HttpServletRequest.getParameterValues must provide the same functionality as EventRequest.getParameterValues");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETPATHINFO,
            "In a target servlet of a include in the Event phase, the method HttpServletRequest.getPathInfo must a value corresponding to the path used to obtain the PortletRequestDispatcher");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETPATHTRANSLATED,
            "In a target servlet of a include in the Event phase, the method HttpServletRequest.getPathTranslated must a value corresponding to the path used to obtain the PortletRequestDispatcher");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETPROTOCOL,
            "In a target servlet of a include in the Event phase, the method HttpServletRequest.getProtocol must return \"HTTP/1.1\"");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETQUERYSTRING,
            "In a target servlet of a include in the Event phase, the method HttpServletRequest.getQueryString must a value corresponding to the query string information used to obtain the PortletRequestDispatcher");
      tcd.put(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETREADER,
            "In a target servlet of a include in the Event phase, the method HttpServletRequest.getReader must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETREALPATH,
            "In a target servlet of a include in the Event phase, the method HttpServletRequest.getRealPath must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETREMOTEADDR,
            "In a target servlet of a include in the Event phase, the method HttpServletRequest.getRemoteAddr must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETREMOTEHOST,
            "In a target servlet of a include in the Event phase, the method HttpServletRequest.getRemoteHost must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETREMOTEPORT,
            "In a target servlet of a include in the Event phase, the method HttpServletRequest.getRemotePort must return 0");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETREMOTEUSER,
            "In a target servlet of a include in the Event phase, the method HttpServletRequest.getRemoteUser must provide the same functionality as EventRequest.getRemoteUser");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETREQUESTDISPATCHER,
            "In a target servlet of a include in the Event phase, the method HttpServletRequest.getRequestDispatcher must provide functionality as defined in the servlet specification");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETREQUESTURI,
            "In a target servlet of a include in the Event phase, the method HttpServletRequest.getRequestURI must a value corresponding to the path and query string information used to obtain the PortletRequestDispatcher");
      tcd.put(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETREQUESTURL,
            "In a target servlet of a include in the Event phase, the method HttpServletRequest.getRequestURL must return null");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETREQUESTEDSESSIONID,
            "In a target servlet of a include in the Event phase, the method HttpServletRequest.getRequestedSessionId must provide the same functionality as EventRequest.getRequestedSessionId");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETSCHEME,
            "In a target servlet of a include in the Event phase, the method HttpServletRequest.getScheme must provide the same functionality as EventRequest.getScheme");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETSERVERNAME,
            "In a target servlet of a include in the Event phase, the method HttpServletRequest.getServerName must provide the same functionality as EventRequest.getServerName");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETSERVERPORT,
            "In a target servlet of a include in the Event phase, the method HttpServletRequest.getServerPort must provide the same functionality as EventRequest.getServerPort");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETSERVLETPATH,
            "In a target servlet of a include in the Event phase, the method HttpServletRequest.getServletPath must a value corresponding to the path used to obtain the PortletRequestDispatcher");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETSESSION,
            "In a target servlet of a include in the Event phase, the method HttpServletRequest.getSession must provide the same functionality as EventRequest.getPortletSession(APPLICATION_SCOPE)");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_GETUSERPRINCIPAL,
            "In a target servlet of a include in the Event phase, the method HttpServletRequest.getUserPrincipal must provide the same functionality as EventRequest.getUserPrincipal");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_ISREQUESTEDSESSIONIDVALID,
            "In a target servlet of a include in the Event phase, the method HttpServletRequest.isRequestedSessionIdValid must provide the same functionality as EventRequest.isRequestedSessionIdValid");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_ISSECURE,
            "In a target servlet of a include in the Event phase, the method HttpServletRequest.isSecure must provide the same functionality as EventRequest.isSecure");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_ISUSERINROLE,
            "In a target servlet of a include in the Event phase, the method HttpServletRequest.isUserInRole must provide the same functionality as EventRequest.isUserInRole");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_REMOVEATTRIBUTE,
            "In a target servlet of a include in the Event phase, the method HttpServletRequest.removeAttribute must provide the same functionality as EventRequest.removeAttribute");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTREQUEST_SETATTRIBUTE,
            "In a target servlet of a include in the Event phase, the method HttpServletRequest.setAttribute must provide the same functionality as EventRequest.setAttribute");
      tcd.put(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTRESPONSE_CONTAINSHEADER,
            "In a target servlet of a include in the Event phase, the method HttpServletResponse.containsHeader must return false");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTRESPONSE_ENCODEREDIRECTURL1,
            "In a target servlet of a include in the Event phase, the method HttpServletResponse.encodeRedirectURL must return null");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTRESPONSE_ENCODEREDIRECTURL,
            "In a target servlet of a include in the Event phase, the method HttpServletResponse.encodeRedirectUrl must return null");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTRESPONSE_ENCODEURL1,
            "In a target servlet of a include in the Event phase, the method HttpServletResponse.encodeURL must provide the same functionality as EventResponse.encodeURL");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTRESPONSE_ENCODEURL,
            "In a target servlet of a include in the Event phase, the method HttpServletResponse.encodeUrl must provide the same functionality as EventResponse.encodeURL");
      tcd.put(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTRESPONSE_GETBUFFERSIZE,
            "In a target servlet of a include in the Event phase, the method HttpServletResponse.getBufferSize must return 0");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTRESPONSE_GETCHARACTERENCODING,
            "In a target servlet of a include in the Event phase, the method HttpServletResponse.getCharacterEncoding must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTRESPONSE_GETCONTENTTYPE,
            "In a target servlet of a include in the Event phase, the method HttpServletResponse.getContentType must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTRESPONSE_GETLOCALE,
            "In a target servlet of a include in the Event phase, the method HttpServletResponse.getLocale must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETEVENTRESPONSE_ISCOMMITTED,
            "In a target servlet of a include in the Event phase, the method HttpServletResponse.isCommitted must return true");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETATTRIBUTE,
            "In a target servlet of a include in the Render phase, the method HttpServletRequest.getAttribute must provide the same functionality as RenderRequest.getAttribute");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETATTRIBUTENAMES,
            "In a target servlet of a include in the Render phase, the method HttpServletRequest.getAttributeNames must provide the same functionality as RenderRequest.getAttributeNames");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETAUTHTYPE,
            "In a target servlet of a include in the Render phase, the method HttpServletRequest.getAuthType must provide the same functionality as RenderRequest.getAuthType");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETCHARACTERENCODING,
            "In a target servlet of a include in the Render phase, the method HttpServletRequest.getCharacterEncoding must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETCONTENTLENGTH,
            "In a target servlet of a include in the Render phase, the method HttpServletRequest.getContentLength must return 0");
      tcd.put(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETCONTENTTYPE,
            "In a target servlet of a include in the Render phase, the method HttpServletRequest.getContentType must return null");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETCONTEXTPATH,
            "In a target servlet of a include in the Render phase, the method HttpServletRequest.getContextPath must provide the same functionality as RenderRequest.getContextPath");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETCOOKIES,
            "In a target servlet of a include in the Render phase, the method HttpServletRequest.getCookies must provide the same functionality as RenderRequest.getCookies");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETDATEHEADER,
            "In a target servlet of a include in the Render phase, the method HttpServletRequest.getDateHeader must return a value corresponding to that returned by RenderRequest.getProperty for the corresponding header name");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETHEADER,
            "In a target servlet of a include in the Render phase, the method HttpServletRequest.getHeader must return a value corresponding to that returned by RenderRequest.getProperty for the corresponding header name");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETHEADERNAMES,
            "In a target servlet of a include in the Render phase, the Enumeration returned by HttpServletRequest.getHeaderNames must be contained in the Enumeration returned by RenderRequest.getPropertyNames");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETHEADERS,
            "In a target servlet of a include in the Render phase, the method HttpServletRequest.getHeaders must return a value corresponding to that returned by RenderRequest.getProperties for the corresponding header name");
      tcd.put(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETINPUTSTREAM,
            "In a target servlet of a include in the Render phase, the method HttpServletRequest.getInputStream must return null");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETINTHEADER,
            "In a target servlet of a include in the Render phase, the method HttpServletRequest.getIntHeader must return a value corresponding to that returned by RenderRequest.getProperty for the corresponding header name");
      tcd.put(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETLOCALADDR,
            "In a target servlet of a include in the Render phase, the method HttpServletRequest.getLocalAddr must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETLOCALNAME,
            "In a target servlet of a include in the Render phase, the method HttpServletRequest.getLocalName must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETLOCALPORT,
            "In a target servlet of a include in the Render phase, the method HttpServletRequest.getLocalPort must return 0");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETLOCALE,
            "In a target servlet of a include in the Render phase, the method HttpServletRequest.getLocale must provide the same functionality as RenderRequest.getLocale");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETLOCALES,
            "In a target servlet of a include in the Render phase, the method HttpServletRequest.getLocales must provide the same functionality as RenderRequest.getLocales");
      tcd.put(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETMETHOD,
            "In a target servlet of a include in the Render phase, the method HttpServletRequest.getMethod must return \"GET\"");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETPARAMETER,
            "In a target servlet of a include in the Render phase, the method HttpServletRequest.getParameter must provide the same functionality as RenderRequest.getParameter");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETPARAMETERMAP,
            "In a target servlet of a include in the Render phase, the method HttpServletRequest.getParameterMap must provide the same functionality as RenderRequest.getParameterMap");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETPARAMETERNAMES,
            "In a target servlet of a include in the Render phase, the method HttpServletRequest.getParameterNames must provide the same functionality as RenderRequest.getParameterNames");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETPARAMETERVALUES,
            "In a target servlet of a include in the Render phase, the method HttpServletRequest.getParameterValues must provide the same functionality as RenderRequest.getParameterValues");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETPATHINFO,
            "In a target servlet of a include in the Render phase, the method HttpServletRequest.getPathInfo must a value corresponding to the path used to obtain the PortletRequestDispatcher");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETPATHTRANSLATED,
            "In a target servlet of a include in the Render phase, the method HttpServletRequest.getPathTranslated must a value corresponding to the path used to obtain the PortletRequestDispatcher");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETPROTOCOL,
            "In a target servlet of a include in the Render phase, the method HttpServletRequest.getProtocol must return \"HTTP/1.1\"");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETQUERYSTRING,
            "In a target servlet of a include in the Render phase, the method HttpServletRequest.getQueryString must a value corresponding to the query string information used to obtain the PortletRequestDispatcher");
      tcd.put(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETREADER,
            "In a target servlet of a include in the Render phase, the method HttpServletRequest.getReader must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETREALPATH,
            "In a target servlet of a include in the Render phase, the method HttpServletRequest.getRealPath must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETREMOTEADDR,
            "In a target servlet of a include in the Render phase, the method HttpServletRequest.getRemoteAddr must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETREMOTEHOST,
            "In a target servlet of a include in the Render phase, the method HttpServletRequest.getRemoteHost must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETREMOTEPORT,
            "In a target servlet of a include in the Render phase, the method HttpServletRequest.getRemotePort must return 0");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETREMOTEUSER,
            "In a target servlet of a include in the Render phase, the method HttpServletRequest.getRemoteUser must provide the same functionality as RenderRequest.getRemoteUser");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETREQUESTDISPATCHER,
            "In a target servlet of a include in the Render phase, the method HttpServletRequest.getRequestDispatcher must provide functionality as defined in the servlet specification");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETREQUESTURI,
            "In a target servlet of a include in the Render phase, the method HttpServletRequest.getRequestURI must a value corresponding to the path and query string information used to obtain the PortletRequestDispatcher");
      tcd.put(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETREQUESTURL,
            "In a target servlet of a include in the Render phase, the method HttpServletRequest.getRequestURL must return null");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETREQUESTEDSESSIONID,
            "In a target servlet of a include in the Render phase, the method HttpServletRequest.getRequestedSessionId must provide the same functionality as RenderRequest.getRequestedSessionId");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETSCHEME,
            "In a target servlet of a include in the Render phase, the method HttpServletRequest.getScheme must provide the same functionality as RenderRequest.getScheme");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETSERVERNAME,
            "In a target servlet of a include in the Render phase, the method HttpServletRequest.getServerName must provide the same functionality as RenderRequest.getServerName");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETSERVERPORT,
            "In a target servlet of a include in the Render phase, the method HttpServletRequest.getServerPort must provide the same functionality as RenderRequest.getServerPort");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETSERVLETPATH,
            "In a target servlet of a include in the Render phase, the method HttpServletRequest.getServletPath must a value corresponding to the path used to obtain the PortletRequestDispatcher");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETSESSION,
            "In a target servlet of a include in the Render phase, the method HttpServletRequest.getSession must provide the same functionality as RenderRequest.getPortletSession(APPLICATION_SCOPE)");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_GETUSERPRINCIPAL,
            "In a target servlet of a include in the Render phase, the method HttpServletRequest.getUserPrincipal must provide the same functionality as RenderRequest.getUserPrincipal");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_ISREQUESTEDSESSIONIDVALID,
            "In a target servlet of a include in the Render phase, the method HttpServletRequest.isRequestedSessionIdValid must provide the same functionality as RenderRequest.isRequestedSessionIdValid");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_ISSECURE,
            "In a target servlet of a include in the Render phase, the method HttpServletRequest.isSecure must provide the same functionality as RenderRequest.isSecure");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_ISUSERINROLE,
            "In a target servlet of a include in the Render phase, the method HttpServletRequest.isUserInRole must provide the same functionality as RenderRequest.isUserInRole");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_REMOVEATTRIBUTE,
            "In a target servlet of a include in the Render phase, the method HttpServletRequest.removeAttribute must provide the same functionality as RenderRequest.removeAttribute");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERREQUEST_SETATTRIBUTE,
            "In a target servlet of a include in the Render phase, the method HttpServletRequest.setAttribute must provide the same functionality as RenderRequest.setAttribute");
      tcd.put(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERRESPONSE_CONTAINSHEADER,
            "In a target servlet of a include in the Render phase, the method HttpServletResponse.containsHeader must return false");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERRESPONSE_ENCODEREDIRECTURL1,
            "In a target servlet of a include in the Render phase, the method HttpServletResponse.encodeRedirectURL must return null");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERRESPONSE_ENCODEREDIRECTURL,
            "In a target servlet of a include in the Render phase, the method HttpServletResponse.encodeRedirectUrl must return null");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERRESPONSE_ENCODEURL1,
            "In a target servlet of a include in the Render phase, the method HttpServletResponse.encodeURL must provide the same functionality as RenderResponse.encodeURL");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERRESPONSE_ENCODEURL,
            "In a target servlet of a include in the Render phase, the method HttpServletResponse.encodeUrl must provide the same functionality as RenderResponse.encodeURL");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERRESPONSE_GETBUFFERSIZE,
            "In a target servlet of a include in the Render phase, the method HttpServletResponse.getBufferSize must provide the same functionality as RenderResponse.getBufferSize");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERRESPONSE_GETCHARACTERENCODING,
            "In a target servlet of a include in the Render phase, the method HttpServletResponse.getCharacterEncoding must provide the same functionality as RenderResponse.getCharacterEncoding");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERRESPONSE_GETCONTENTTYPE,
            "In a target servlet of a include in the Render phase, the method HttpServletResponse.getContentType must provide the same functionality as RenderResponse.getContentType");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERRESPONSE_GETLOCALE,
            "In a target servlet of a include in the Render phase, the method HttpServletResponse.getLocale must provide the same functionality as RenderResponse.getLocale");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRENDERRESPONSE_ISCOMMITTED,
            "In a target servlet of a include in the Render phase, the method HttpServletResponse.isCommitted must provide the same functionality as RenderResponse.isCommitted");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETATTRIBUTE,
            "In a target servlet of a include in the Resource phase, the method HttpServletRequest.getAttribute must provide the same functionality as ResourceRequest.getAttribute");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETATTRIBUTENAMES,
            "In a target servlet of a include in the Resource phase, the method HttpServletRequest.getAttributeNames must provide the same functionality as ResourceRequest.getAttributeNames");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETAUTHTYPE,
            "In a target servlet of a include in the Resource phase, the method HttpServletRequest.getAuthType must provide the same functionality as ResourceRequest.getAuthType");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETCHARACTERENCODING,
            "In a target servlet of a include in the Resource phase, the method HttpServletRequest.getCharacterEncoding must provide the same functionality as ResourceRequest.getCharacterEncoding");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETCONTENTLENGTH,
            "In a target servlet of a include in the Resource phase, the method HttpServletRequest.getContentLength must provide the same functionality as ResourceRequest.getContentLength");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETCONTENTTYPE,
            "In a target servlet of a include in the Resource phase, the method HttpServletRequest.getContentType must provide the same functionality as ResourceRequest.getContentType");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETCONTEXTPATH,
            "In a target servlet of a include in the Resource phase, the method HttpServletRequest.getContextPath must provide the same functionality as ResourceRequest.getContextPath");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETCOOKIES,
            "In a target servlet of a include in the Resource phase, the method HttpServletRequest.getCookies must provide the same functionality as ResourceRequest.getCookies");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETDATEHEADER,
            "In a target servlet of a include in the Resource phase, the method HttpServletRequest.getDateHeader must return a value corresponding to that returned by ResourceRequest.getProperty for the corresponding header name");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETHEADER,
            "In a target servlet of a include in the Resource phase, the method HttpServletRequest.getHeader must return a value corresponding to that returned by ResourceRequest.getProperty for the corresponding header name");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETHEADERNAMES,
            "In a target servlet of a include in the Resource phase, the Enumeration returned by HttpServletRequest.getHeaderNames must be contained in the Enumeration returned by ResourceRequest.getPropertyNames");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETHEADERS,
            "In a target servlet of a include in the Resource phase, the method HttpServletRequest.getHeaders must return a value corresponding to that returned by ResourceRequest.getProperties for the corresponding header name");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETINTHEADER,
            "In a target servlet of a include in the Resource phase, the method HttpServletRequest.getIntHeader must return a value corresponding to that returned by ResourceRequest.getProperty for the corresponding header name");
      tcd.put(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETLOCALADDR,
            "In a target servlet of a include in the Resource phase, the method HttpServletRequest.getLocalAddr must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETLOCALNAME,
            "In a target servlet of a include in the Resource phase, the method HttpServletRequest.getLocalName must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETLOCALPORT,
            "In a target servlet of a include in the Resource phase, the method HttpServletRequest.getLocalPort must return 0");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETLOCALE,
            "In a target servlet of a include in the Resource phase, the method HttpServletRequest.getLocale must provide the same functionality as ResourceRequest.getLocale");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETLOCALES,
            "In a target servlet of a include in the Resource phase, the method HttpServletRequest.getLocales must provide the same functionality as ResourceRequest.getLocales");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETMETHOD,
            "In a target servlet of a include in the Resource phase, the method HttpServletRequest.getMethod must provide the same functionality as ResourceRequest.getMethod");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETPARAMETER,
            "In a target servlet of a include in the Resource phase, the method HttpServletRequest.getParameter must provide the same functionality as ResourceRequest.getParameter");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETPARAMETERMAP,
            "In a target servlet of a include in the Resource phase, the method HttpServletRequest.getParameterMap must provide the same functionality as ResourceRequest.getParameterMap");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETPARAMETERNAMES,
            "In a target servlet of a include in the Resource phase, the method HttpServletRequest.getParameterNames must provide the same functionality as ResourceRequest.getParameterNames");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETPARAMETERVALUES,
            "In a target servlet of a include in the Resource phase, the method HttpServletRequest.getParameterValues must provide the same functionality as ResourceRequest.getParameterValues");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETPATHINFO,
            "In a target servlet of a include in the Resource phase, the method HttpServletRequest.getPathInfo must a value corresponding to the path used to obtain the PortletRequestDispatcher");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETPATHTRANSLATED,
            "In a target servlet of a include in the Resource phase, the method HttpServletRequest.getPathTranslated must a value corresponding to the path used to obtain the PortletRequestDispatcher");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETPROTOCOL,
            "In a target servlet of a include in the Resource phase, the method HttpServletRequest.getProtocol must return \"HTTP/1.1\"");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETQUERYSTRING,
            "In a target servlet of a include in the Resource phase, the method HttpServletRequest.getQueryString must a value corresponding to the query string information used to obtain the PortletRequestDispatcher");
      tcd.put(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETREALPATH,
            "In a target servlet of a include in the Resource phase, the method HttpServletRequest.getRealPath must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETREMOTEADDR,
            "In a target servlet of a include in the Resource phase, the method HttpServletRequest.getRemoteAddr must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETREMOTEHOST,
            "In a target servlet of a include in the Resource phase, the method HttpServletRequest.getRemoteHost must return null");
      tcd.put(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETREMOTEPORT,
            "In a target servlet of a include in the Resource phase, the method HttpServletRequest.getRemotePort must return 0");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETREMOTEUSER,
            "In a target servlet of a include in the Resource phase, the method HttpServletRequest.getRemoteUser must provide the same functionality as ResourceRequest.getRemoteUser");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETREQUESTDISPATCHER,
            "In a target servlet of a include in the Resource phase, the method HttpServletRequest.getRequestDispatcher must provide functionality as defined in the servlet specification");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETREQUESTURI,
            "In a target servlet of a include in the Resource phase, the method HttpServletRequest.getRequestURI must a value corresponding to the path and query string information used to obtain the PortletRequestDispatcher");
      tcd.put(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETREQUESTURL,
            "In a target servlet of a include in the Resource phase, the method HttpServletRequest.getRequestURL must return null");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETREQUESTEDSESSIONID,
            "In a target servlet of a include in the Resource phase, the method HttpServletRequest.getRequestedSessionId must provide the same functionality as ResourceRequest.getRequestedSessionId");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETSCHEME,
            "In a target servlet of a include in the Resource phase, the method HttpServletRequest.getScheme must provide the same functionality as ResourceRequest.getScheme");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETSERVERNAME,
            "In a target servlet of a include in the Resource phase, the method HttpServletRequest.getServerName must provide the same functionality as ResourceRequest.getServerName");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETSERVERPORT,
            "In a target servlet of a include in the Resource phase, the method HttpServletRequest.getServerPort must provide the same functionality as ResourceRequest.getServerPort");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETSERVLETPATH,
            "In a target servlet of a include in the Resource phase, the method HttpServletRequest.getServletPath must a value corresponding to the path used to obtain the PortletRequestDispatcher");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETSESSION,
            "In a target servlet of a include in the Resource phase, the method HttpServletRequest.getSession must provide the same functionality as ResourceRequest.getPortletSession(APPLICATION_SCOPE)");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETUSERPRINCIPAL,
            "In a target servlet of a include in the Resource phase, the method HttpServletRequest.getUserPrincipal must provide the same functionality as ResourceRequest.getUserPrincipal");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_ISREQUESTEDSESSIONIDVALID,
            "In a target servlet of a include in the Resource phase, the method HttpServletRequest.isRequestedSessionIdValid must provide the same functionality as ResourceRequest.isRequestedSessionIdValid");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_ISSECURE,
            "In a target servlet of a include in the Resource phase, the method HttpServletRequest.isSecure must provide the same functionality as ResourceRequest.isSecure");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_ISUSERINROLE,
            "In a target servlet of a include in the Resource phase, the method HttpServletRequest.isUserInRole must provide the same functionality as ResourceRequest.isUserInRole");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_REMOVEATTRIBUTE,
            "In a target servlet of a include in the Resource phase, the method HttpServletRequest.removeAttribute must provide the same functionality as ResourceRequest.removeAttribute");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_SETATTRIBUTE,
            "In a target servlet of a include in the Resource phase, the method HttpServletRequest.setAttribute must provide the same functionality as ResourceRequest.setAttribute");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCERESPONSE_CONTAINSHEADER,
            "In a target servlet of a include in the Resource phase, the method HttpServletResponse.containsHeader must return false");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCERESPONSE_ENCODEREDIRECTURL1,
            "In a target servlet of a include in the Resource phase, the method HttpServletResponse.encodeRedirectURL must return null");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCERESPONSE_ENCODEREDIRECTURL,
            "In a target servlet of a include in the Resource phase, the method HttpServletResponse.encodeRedirectUrl must return null");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCERESPONSE_ENCODEURL1,
            "In a target servlet of a include in the Resource phase, the method HttpServletResponse.encodeURL must provide the same functionality as ResourceResponse.encodeURL");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCERESPONSE_ENCODEURL,
            "In a target servlet of a include in the Resource phase, the method HttpServletResponse.encodeUrl must provide the same functionality as ResourceResponse.encodeURL");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCERESPONSE_GETBUFFERSIZE,
            "In a target servlet of a include in the Resource phase, the method HttpServletResponse.getBufferSize must provide the same functionality as ResourceResponse.getBufferSize");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCERESPONSE_GETCHARACTERENCODING,
            "In a target servlet of a include in the Resource phase, the method HttpServletResponse.getCharacterEncoding must provide the same functionality as ResourceResponse.getCharacterEncoding");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCERESPONSE_GETCONTENTTYPE,
            "In a target servlet of a include in the Resource phase, the method HttpServletResponse.getContentType must provide the same functionality as ResourceResponse.getContentType");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCERESPONSE_GETLOCALE,
            "In a target servlet of a include in the Resource phase, the method HttpServletResponse.getLocale must provide the same functionality as ResourceResponse.getLocale");
      tcd.put(
            V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCERESPONSE_ISCOMMITTED,
            "In a target servlet of a include in the Resource phase, the method HttpServletResponse.isCommitted must provide the same functionality as ResourceResponse.isCommitted");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDJSPACTIONREQUEST_GETINPUTSTREAM,
            "In a target jsp of a forward in the Action phase, the method HttpServletRequest.getInputStream must provide the same functionality as ActionRequest.getPortletInputStream");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDJSPACTIONREQUEST_SETCHARACTERENCODING,
            "In a target jsp of a forward in the Action phase, the method HttpServletRequest.setCharacterEncoding must provide the same functionality as ActionRequest.setCharacterEncoding");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDJSPACTIONRESPONSE_SENDREDIRECT,
            "In a target jsp of a forward in the Action phase, the method HttpServletResponse.sendRedirect must provide the same functionality as ActionResponse.sendRedirect");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDJSPRENDERREQUEST_SETCHARACTERENCODING,
            "In a target jsp of a forward in the Render phase, the method HttpServletRequest.setCharacterEncoding does not perform any operation");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDJSPRENDERRESPONSE_GETOUTPUTSTREAM,
            "In a target jsp of a forward in the Render phase, the method HttpServletResponse.getOutputStream must provide the same functionality as RenderResponse.getPortletOutputStream");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDJSPRENDERRESPONSE_SENDERROR,
            "In a target jsp of a forward in the Render phase, the method HttpServletResponse.sendError does not perform any operation");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDJSPRENDERRESPONSE_SENDREDIRECT,
            "In a target jsp of a forward in the Render phase, the method HttpServletResponse.sendRedirect does not perform any operation");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDJSPRENDERRESPONSE_SETCHARACTERENCODING,
            "In a target jsp of a forward in the Render phase, the method HttpServletResponse.setCharacterEncoding does not perform any operation");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDJSPRENDERRESPONSE_SETCONTENTLENGTH,
            "In a target jsp of a forward in the Render phase, the method HttpServletResponse.setContentLength does not perform any operation");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDJSPRENDERRESPONSE_SETCONTENTTYPE,
            "In a target jsp of a forward in the Render phase, the method HttpServletResponse.setContentType must provide the same functionality as RenderResponse.setContentType");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDJSPRENDERRESPONSE_SETLOCALE,
            "In a target jsp of a forward in the Render phase, the method HttpServletResponse.setLocale does not perform any operation");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDJSPRENDERRESPONSE_SETSTATUS,
            "In a target jsp of a forward in the Render phase, the method HttpServletResponse.setStatus does not perform any operation");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETINPUTSTREAM,
            "In a target jsp of a forward in the Resource phase, the method HttpServletRequest.getInputStream must provide the same functionality as ResourceRequest.getPortletInputStream");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDJSPRESOURCEREQUEST_SETCHARACTERENCODING,
            "In a target jsp of a forward in the Resource phase, the method HttpServletRequest.setCharacterEncoding must provide the same functionality as ResourceRequest.setCharacterEncoding");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDJSPRESOURCERESPONSE_GETOUTPUTSTREAM,
            "In a target jsp of a forward in the Resource phase, the method HttpServletResponse.getOutputStream must provide the same functionality as ResourceResponse.getPortletOutputStream");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDJSPRESOURCERESPONSE_SENDERROR,
            "In a target jsp of a forward in the Resource phase, the method HttpServletResponse.sendError does not perform any operation");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDJSPRESOURCERESPONSE_SENDREDIRECT,
            "In a target jsp of a forward in the Resource phase, the method HttpServletResponse.sendRedirect does not perform any operation");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDJSPRESOURCERESPONSE_SETCHARACTERENCODING,
            "In a target jsp of a forward in the Resource phase, the method HttpServletResponse.setCharacterEncoding must provide the same functionality as ResourceResponse.setCharacterEncoding");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDJSPRESOURCERESPONSE_SETCONTENTLENGTH,
            "In a target jsp of a forward in the Resource phase, the method HttpServletResponse.setContentLength must provide the same functionality as ResourceResponse.setContentLength");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDJSPRESOURCERESPONSE_SETCONTENTTYPE,
            "In a target jsp of a forward in the Resource phase, the method HttpServletResponse.setContentType must provide the same functionality as ResourceResponse.setContentType");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDJSPRESOURCERESPONSE_SETLOCALE,
            "In a target jsp of a forward in the Resource phase, the method HttpServletResponse.setLocale must provide the same functionality as ResourceResponse.setLocale");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDSERVLETACTIONREQUEST_GETINPUTSTREAM,
            "In a target servlet of a forward in the Action phase, the method HttpServletRequest.getInputStream must provide the same functionality as ActionRequest.getPortletInputStream");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDSERVLETACTIONREQUEST_SETCHARACTERENCODING,
            "In a target servlet of a forward in the Action phase, the method HttpServletRequest.setCharacterEncoding must provide the same functionality as ActionRequest.setCharacterEncoding");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDSERVLETACTIONRESPONSE_SENDREDIRECT,
            "In a target servlet of a forward in the Action phase, the method HttpServletResponse.sendRedirect must provide the same functionality as ActionResponse.sendRedirect");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDSERVLETRENDERREQUEST_SETCHARACTERENCODING,
            "In a target servlet of a forward in the Render phase, the method HttpServletRequest.setCharacterEncoding does not perform any operation");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDSERVLETRENDERRESPONSE_GETOUTPUTSTREAM,
            "In a target servlet of a forward in the Render phase, the method HttpServletResponse.getOutputStream must provide the same functionality as RenderResponse.getPortletOutputStream");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDSERVLETRENDERRESPONSE_SENDERROR,
            "In a target servlet of a forward in the Render phase, the method HttpServletResponse.sendError does not perform any operation");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDSERVLETRENDERRESPONSE_SENDREDIRECT,
            "In a target servlet of a forward in the Render phase, the method HttpServletResponse.sendRedirect does not perform any operation");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDSERVLETRENDERRESPONSE_SETCHARACTERENCODING,
            "In a target servlet of a forward in the Render phase, the method HttpServletResponse.setCharacterEncoding does not perform any operation");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDSERVLETRENDERRESPONSE_SETCONTENTLENGTH,
            "In a target servlet of a forward in the Render phase, the method HttpServletResponse.setContentLength does not perform any operation");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDSERVLETRENDERRESPONSE_SETCONTENTTYPE,
            "In a target servlet of a forward in the Render phase, the method HttpServletResponse.setContentType must provide the same functionality as RenderResponse.setContentType");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDSERVLETRENDERRESPONSE_SETLOCALE,
            "In a target servlet of a forward in the Render phase, the method HttpServletResponse.setLocale does not perform any operation");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDSERVLETRENDERRESPONSE_SETSTATUS,
            "In a target servlet of a forward in the Render phase, the method HttpServletResponse.setStatus does not perform any operation");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_GETINPUTSTREAM,
            "In a target servlet of a forward in the Resource phase, the method HttpServletRequest.getInputStream must provide the same functionality as ResourceRequest.getPortletInputStream");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDSERVLETRESOURCEREQUEST_SETCHARACTERENCODING,
            "In a target servlet of a forward in the Resource phase, the method HttpServletRequest.setCharacterEncoding must provide the same functionality as ResourceRequest.setCharacterEncoding");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDSERVLETRESOURCERESPONSE_GETOUTPUTSTREAM,
            "In a target servlet of a forward in the Resource phase, the method HttpServletResponse.getOutputStream must provide the same functionality as ResourceResponse.getPortletOutputStream");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDSERVLETRESOURCERESPONSE_SENDERROR,
            "In a target servlet of a forward in the Resource phase, the method HttpServletResponse.sendError does not perform any operation");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDSERVLETRESOURCERESPONSE_SENDREDIRECT,
            "In a target servlet of a forward in the Resource phase, the method HttpServletResponse.sendRedirect does not perform any operation");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDSERVLETRESOURCERESPONSE_SETCHARACTERENCODING,
            "In a target servlet of a forward in the Resource phase, the method HttpServletResponse.setCharacterEncoding must provide the same functionality as ResourceResponse.setCharacterEncoding");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDSERVLETRESOURCERESPONSE_SETCONTENTLENGTH,
            "In a target servlet of a forward in the Resource phase, the method HttpServletResponse.setContentLength must provide the same functionality as ResourceResponse.setContentLength");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDSERVLETRESOURCERESPONSE_SETCONTENTTYPE,
            "In a target servlet of a forward in the Resource phase, the method HttpServletResponse.setContentType must provide the same functionality as ResourceResponse.setContentType");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_FORWARDSERVLETRESOURCERESPONSE_SETLOCALE,
            "In a target servlet of a forward in the Resource phase, the method HttpServletResponse.setLocale must provide the same functionality as ResourceResponse.setLocale");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDEJSPACTIONREQUEST_GETINPUTSTREAM,
            "In a target jsp of a include in the Action phase, the method HttpServletRequest.getInputStream must provide the same functionality as ActionRequest.getPortletInputStream");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDEJSPACTIONREQUEST_SETCHARACTERENCODING,
            "In a target jsp of a include in the Action phase, the method HttpServletRequest.setCharacterEncoding must provide the same functionality as ActionRequest.setCharacterEncoding");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDEJSPRENDERREQUEST_SETCHARACTERENCODING,
            "In a target jsp of a include in the Render phase, the method HttpServletRequest.setCharacterEncoding does not perform any operation");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDEJSPRENDERRESPONSE_GETOUTPUTSTREAM,
            "In a target jsp of a include in the Render phase, the method HttpServletResponse.getOutputStream must provide the same functionality as RenderResponse.getPortletOutputStream");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDEJSPRENDERRESPONSE_SENDERROR,
            "In a target jsp of a include in the Render phase, the method HttpServletResponse.sendError does not perform any operation");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDEJSPRENDERRESPONSE_SENDREDIRECT,
            "In a target jsp of a include in the Render phase, the method HttpServletResponse.sendRedirect does not perform any operation");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDEJSPRENDERRESPONSE_SETCHARACTERENCODING,
            "In a target jsp of a include in the Render phase, the method HttpServletResponse.setCharacterEncoding does not perform any operation");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDEJSPRENDERRESPONSE_SETCONTENTLENGTH,
            "In a target jsp of a include in the Render phase, the method HttpServletResponse.setContentLength does not perform any operation");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDEJSPRENDERRESPONSE_SETCONTENTTYPE,
            "In a target jsp of a include in the Render phase, the method HttpServletResponse.setContentType does not perform any operation");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDEJSPRENDERRESPONSE_SETLOCALE,
            "In a target jsp of a include in the Render phase, the method HttpServletResponse.setLocale does not perform any operation");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDEJSPRENDERRESPONSE_SETSTATUS,
            "In a target jsp of a include in the Render phase, the method HttpServletResponse.setStatus does not perform any operation");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_GETINPUTSTREAM,
            "In a target jsp of a include in the Resource phase, the method HttpServletRequest.getInputStream must provide the same functionality as ResourceRequest.getPortletInputStream");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDEJSPRESOURCEREQUEST_SETCHARACTERENCODING,
            "In a target jsp of a include in the Resource phase, the method HttpServletRequest.setCharacterEncoding must provide the same functionality as ResourceRequest.setCharacterEncoding");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDEJSPRESOURCERESPONSE_GETOUTPUTSTREAM,
            "In a target jsp of a include in the Resource phase, the method HttpServletResponse.getOutputStream must provide the same functionality as ResourceResponse.getPortletOutputStream");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDEJSPRESOURCERESPONSE_SENDERROR,
            "In a target jsp of a include in the Resource phase, the method HttpServletResponse.sendError does not perform any operation");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDEJSPRESOURCERESPONSE_SENDREDIRECT,
            "In a target jsp of a include in the Resource phase, the method HttpServletResponse.sendRedirect does not perform any operation");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDEJSPRESOURCERESPONSE_SETCHARACTERENCODING,
            "In a target jsp of a include in the Resource phase, the method HttpServletResponse.setCharacterEncoding does not perform any operation");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDEJSPRESOURCERESPONSE_SETCONTENTLENGTH,
            "In a target jsp of a include in the Resource phase, the method HttpServletResponse.setContentLength does not perform any operation");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDEJSPRESOURCERESPONSE_SETCONTENTTYPE,
            "In a target jsp of a include in the Resource phase, the method HttpServletResponse.setContentType does not perform any operation");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDEJSPRESOURCERESPONSE_SETLOCALE,
            "In a target jsp of a include in the Resource phase, the method HttpServletResponse.setLocale does not perform any operation");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDEJSPRESOURCERESPONSE_SETSTATUS,
            "In a target jsp of a include in the Resource phase, the method HttpServletResponse.setStatus does not perform any operation");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDESERVLETACTIONREQUEST_GETINPUTSTREAM,
            "In a target servlet of a include in the Action phase, the method HttpServletRequest.getInputStream must provide the same functionality as ActionRequest.getPortletInputStream");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDESERVLETACTIONREQUEST_SETCHARACTERENCODING,
            "In a target servlet of a include in the Action phase, the method HttpServletRequest.setCharacterEncoding must provide the same functionality as ActionRequest.setCharacterEncoding");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDESERVLETRENDERREQUEST_SETCHARACTERENCODING,
            "In a target servlet of a include in the Render phase, the method HttpServletRequest.setCharacterEncoding does not perform any operation");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDESERVLETRENDERRESPONSE_GETOUTPUTSTREAM,
            "In a target servlet of a include in the Render phase, the method HttpServletResponse.getOutputStream must provide the same functionality as RenderResponse.getPortletOutputStream");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDESERVLETRENDERRESPONSE_SENDERROR,
            "In a target servlet of a include in the Render phase, the method HttpServletResponse.sendError does not perform any operation");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDESERVLETRENDERRESPONSE_SENDREDIRECT,
            "In a target servlet of a include in the Render phase, the method HttpServletResponse.sendRedirect does not perform any operation");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDESERVLETRENDERRESPONSE_SETCHARACTERENCODING,
            "In a target servlet of a include in the Render phase, the method HttpServletResponse.setCharacterEncoding does not perform any operation");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDESERVLETRENDERRESPONSE_SETCONTENTLENGTH,
            "In a target servlet of a include in the Render phase, the method HttpServletResponse.setContentLength does not perform any operation");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDESERVLETRENDERRESPONSE_SETCONTENTTYPE,
            "In a target servlet of a include in the Render phase, the method HttpServletResponse.setContentType does not perform any operation");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDESERVLETRENDERRESPONSE_SETLOCALE,
            "In a target servlet of a include in the Render phase, the method HttpServletResponse.setLocale does not perform any operation");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDESERVLETRENDERRESPONSE_SETSTATUS,
            "In a target servlet of a include in the Render phase, the method HttpServletResponse.setStatus does not perform any operation");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_GETINPUTSTREAM,
            "In a target servlet of a include in the Resource phase, the method HttpServletRequest.getInputStream must provide the same functionality as ResourceRequest.getPortletInputStream");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDESERVLETRESOURCEREQUEST_SETCHARACTERENCODING,
            "In a target servlet of a include in the Resource phase, the method HttpServletRequest.setCharacterEncoding must provide the same functionality as ResourceRequest.setCharacterEncoding");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDESERVLETRESOURCERESPONSE_GETOUTPUTSTREAM,
            "In a target servlet of a include in the Resource phase, the method HttpServletResponse.getOutputStream must provide the same functionality as ResourceResponse.getPortletOutputStream");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDESERVLETRESOURCERESPONSE_SENDERROR,
            "In a target servlet of a include in the Resource phase, the method HttpServletResponse.sendError does not perform any operation");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDESERVLETRESOURCERESPONSE_SENDREDIRECT,
            "In a target servlet of a include in the Resource phase, the method HttpServletResponse.sendRedirect does not perform any operation");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDESERVLETRESOURCERESPONSE_SETCHARACTERENCODING,
            "In a target servlet of a include in the Resource phase, the method HttpServletResponse.setCharacterEncoding does not perform any operation");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDESERVLETRESOURCERESPONSE_SETCONTENTLENGTH,
            "In a target servlet of a include in the Resource phase, the method HttpServletResponse.setContentLength does not perform any operation");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDESERVLETRESOURCERESPONSE_SETCONTENTTYPE,
            "In a target servlet of a include in the Resource phase, the method HttpServletResponse.setContentType does not perform any operation");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDESERVLETRESOURCERESPONSE_SETLOCALE,
            "In a target servlet of a include in the Resource phase, the method HttpServletResponse.setLocale does not perform any operation");
      tcd.put(
            V2DISPATCHERREQRESPTESTS5S_SPEC2_19_INCLUDESERVLETRESOURCERESPONSE_SETSTATUS,
            "In a target servlet of a include in the Resource phase, the method HttpServletResponse.setStatus does not perform any operation");

   }

   /**
    * Constructor.
    * 
    * Passes the static test case names - details map to the superclass
    * 
    * Note that the backing map is static and not threadsafe. Operations that change the map such as put, remove, etc.,
    * should not be used in portlets.
    */
   public JSR286DispatcherReqRespTestCaseDetails() {
      super(tcd);
   }

}
