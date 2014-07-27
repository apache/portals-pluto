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

package javax.portlet.tck.RequestTests.portlets;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.Enumeration;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.portlet.*;
import javax.portlet.filter.*;
import javax.portlet.tck.beans.ClassChecker;
import javax.portlet.tck.beans.TestCaseDetails;
import javax.portlet.tck.beans.JSR286ApiTestCaseDetails;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.*;
import javax.portlet.tck.beans.TestResult;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the 
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 */
public class V2RequestTests_PortletRequest implements Portlet {
   private static final String LOG_CLASS = 
         V2RequestTests_PortletRequest.class.getName();
   private final Logger LOGGER = Logger.getLogger(LOG_CLASS);
   
   private PortletConfig portletConfig = null;

   @Override
   public void init(PortletConfig config) throws PortletException {
      this.portletConfig = config;
   }

   @Override
   public void destroy() {
   }

   @Override
   public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
         throws PortletException, IOException {
   }

   @Override
   public void render(RenderRequest renderRequest, RenderResponse renderResponse)
         throws PortletException, IOException {
      
      if (LOGGER.isLoggable(Level.FINE)) {
         LOGGER.logp(Level.FINE, LOG_CLASS, "render", "Entry");
      }

      PrintWriter writer = renderResponse.getWriter();
      JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();
      ClassChecker cc = new ClassChecker(renderRequest.getClass());

      // Create result objects for the tests

      /* TestCase: PortletRequest_fieldUSER_INFO */
      /* Details: "Has String field USER_INFO with value of \"javax.portlet.userinfo\" " */
      TestResult tr0 = tcd.getTestResultFailed(PORTLETREQUEST_FIELDUSER_INFO);
      {
         tr0.setTcSuccess(cc.hasField("USER_INFO", "javax.portlet.userinfo"));
      }

      /* TestCase: PortletRequest_fieldCCPP_PROFILE */
      /* Details: "Has String field CCPP_PROFILE with value of \"javax.portlet.ccpp\" " */
      TestResult tr1 = tcd.getTestResultFailed(PORTLETREQUEST_FIELDCCPP_PROFILE);
      {
         tr1.setTcSuccess(cc.hasField("CCPP_PROFILE", "javax.portlet.ccpp"));
      }

      /* TestCase: PortletRequest_fieldBASIC_AUTH */
      /* Details: "Has String field BASIC_AUTH with value of \"BASIC\" " */
      TestResult tr2 = tcd.getTestResultFailed(PORTLETREQUEST_FIELDBASIC_AUTH);
      {
         tr2.setTcSuccess(cc.hasField("BASIC_AUTH", "BASIC"));
      }

      /* TestCase: PortletRequest_fieldFORM_AUTH */
      /* Details: "Has String field FORM_AUTH with value of \"FORM\" " */
      TestResult tr3 = tcd.getTestResultFailed(PORTLETREQUEST_FIELDFORM_AUTH);
      {
         tr3.setTcSuccess(cc.hasField("FORM_AUTH", "FORM"));
      }

      /* TestCase: PortletRequest_fieldCLIENT_CERT_AUTH */
      /* Details: "Has String field CLIENT_CERT_AUTH with value of \"CLIENT_CERT\" " */
      TestResult tr4 = tcd.getTestResultFailed(PORTLETREQUEST_FIELDCLIENT_CERT_AUTH);
      {
         tr4.setTcSuccess(cc.hasField("CLIENT_CERT_AUTH", "CLIENT_CERT"));
      }

      /* TestCase: PortletRequest_fieldDIGEST_AUTH */
      /* Details: "Has String field DIGEST_AUTH with value of \"DIGEST\" " */
      TestResult tr5 = tcd.getTestResultFailed(PORTLETREQUEST_FIELDDIGEST_AUTH);
      {
         tr5.setTcSuccess(cc.hasField("DIGEST_AUTH", "DIGEST"));
      }

      /* TestCase: PortletRequest_fieldACTION_PHASE */
      /* Details: "Has String field ACTION_PHASE with value of \"ACTION_PHASE\" " */
      TestResult tr6 = tcd.getTestResultFailed(PORTLETREQUEST_FIELDACTION_PHASE);
      {
         tr6.setTcSuccess(cc.hasField("ACTION_PHASE", "ACTION_PHASE"));
      }

      /* TestCase: PortletRequest_fieldEVENT_PHASE */
      /* Details: "Has String field EVENT_PHASE with value of \"EVENT_PHASE\" " */
      TestResult tr7 = tcd.getTestResultFailed(PORTLETREQUEST_FIELDEVENT_PHASE);
      {
         tr7.setTcSuccess(cc.hasField("EVENT_PHASE", "EVENT_PHASE"));
      }

      /* TestCase: PortletRequest_fieldRENDER_PHASE */
      /* Details: "Has String field RENDER_PHASE with value of \"RENDER_PHASE\" " */
      TestResult tr8 = tcd.getTestResultFailed(PORTLETREQUEST_FIELDRENDER_PHASE);
      {
         tr8.setTcSuccess(cc.hasField("RENDER_PHASE", "RENDER_PHASE"));
      }

      /* TestCase: PortletRequest_fieldRESOURCE_PHASE */
      /* Details: "Has String field RESOURCE_PHASE with value of \"RESOURCE_PHASE\" " */
      TestResult tr9 = tcd.getTestResultFailed(PORTLETREQUEST_FIELDRESOURCE_PHASE);
      {
         tr9.setTcSuccess(cc.hasField("RESOURCE_PHASE", "RESOURCE_PHASE"));
      }

      /* TestCase: PortletRequest_fieldLIFECYCLE_PHASE */
      /* Details: "Has String field LIFECYCLE_PHASE with value of \"javax.portlet.lifecycle_phase\" " */
      TestResult tr10 = tcd.getTestResultFailed(PORTLETREQUEST_FIELDLIFECYCLE_PHASE);
      {
         tr10.setTcSuccess(cc.hasField("LIFECYCLE_PHASE", "javax.portlet.lifecycle_phase"));
      }

      /* TestCase: PortletRequest_fieldRENDER_PART */
      /* Details: "Has String field RENDER_PART with value of \"javax.portlet.render_part\" " */
      TestResult tr11 = tcd.getTestResultFailed(PORTLETREQUEST_FIELDRENDER_PART);
      {
         tr11.setTcSuccess(cc.hasField("RENDER_PART", "javax.portlet.render_part"));
      }

      /* TestCase: PortletRequest_fieldRENDER_HEADERS */
      /* Details: "Has String field RENDER_HEADERS with value of \"RENDER_HEADERS\" " */
      TestResult tr12 = tcd.getTestResultFailed(PORTLETREQUEST_FIELDRENDER_HEADERS);
      {
         tr12.setTcSuccess(cc.hasField("RENDER_HEADERS", "RENDER_HEADERS"));
      }

      /* TestCase: PortletRequest_fieldRENDER_MARKUP */
      /* Details: "Has String field RENDER_MARKUP with value of \"RENDER_MARKUP\" " */
      TestResult tr13 = tcd.getTestResultFailed(PORTLETREQUEST_FIELDRENDER_MARKUP);
      {
         tr13.setTcSuccess(cc.hasField("RENDER_MARKUP", "RENDER_MARKUP"));
      }

      /* TestCase: PortletRequest_fieldACTION_SCOPE_ID */
      /* Details: "Has String field ACTION_SCOPE_ID with value of \"javax.portlet.as\" " */
      TestResult tr14 = tcd.getTestResultFailed(PORTLETREQUEST_FIELDACTION_SCOPE_ID);
      {
         tr14.setTcSuccess(cc.hasField("ACTION_SCOPE_ID", "javax.portlet.as"));
      }

      /* TestCase: PortletRequest_isWindowStateAllowed1 */
      /* Details: "Returns true if the specified WindowState is allowed" */
      TestResult tr15 = tcd.getTestResultFailed(PORTLETREQUEST_ISWINDOWSTATEALLOWED1);
      /* TODO: implement test */

      /* TestCase: PortletRequest_isWindowStateAllowed2 */
      /* Details: "Returns false if the specified WindowState is not allowed" */
      TestResult tr16 = tcd.getTestResultFailed(PORTLETREQUEST_ISWINDOWSTATEALLOWED2);
      /* TODO: implement test */

      /* TestCase: PortletRequest_isPortletModeAllowed1 */
      /* Details: "Returns true if the specified PortletMode is allowed" */
      TestResult tr17 = tcd.getTestResultFailed(PORTLETREQUEST_ISPORTLETMODEALLOWED1);
      /* TODO: implement test */

      /* TestCase: PortletRequest_isPortletModeAllowed2 */
      /* Details: "Returns false if the specified PortletMode is not allowed" */
      TestResult tr18 = tcd.getTestResultFailed(PORTLETREQUEST_ISPORTLETMODEALLOWED2);
      /* TODO: implement test */

      /* TestCase: PortletRequest_getPortletMode */
      /* Details: "Returns current PortletMode " */
      TestResult tr19 = tcd.getTestResultFailed(PORTLETREQUEST_GETPORTLETMODE);
      /* TODO: implement test */

      /* TestCase: PortletRequest_getWindowState */
      /* Details: "Returns current WindowState" */
      TestResult tr20 = tcd.getTestResultFailed(PORTLETREQUEST_GETWINDOWSTATE);
      /* TODO: implement test */

      /* TestCase: PortletRequest_getPreferences */
      /* Details: "Returns the PortletPreferences object associated with the portlet" */
      TestResult tr21 = tcd.getTestResultFailed(PORTLETREQUEST_GETPREFERENCES);
      /* TODO: implement test */

      /* TestCase: PortletRequest_getPortletSessionA1 */
      /* Details: "Returns current PortletSession if one already exists" */
      TestResult tr22 = tcd.getTestResultFailed(PORTLETREQUEST_GETPORTLETSESSIONA1);
      /* TODO: implement test */

      /* TestCase: PortletRequest_getPortletSessionA2 */
      /* Details: "Returns new PortletSession if one does not already exist" */
      TestResult tr23 = tcd.getTestResultFailed(PORTLETREQUEST_GETPORTLETSESSIONA2);
      /* TODO: implement test */

      /* TestCase: PortletRequest_getPortletSessionB1 */
      /* Details: "If input flag is true, returns current PortletSession if one already exists" */
      TestResult tr24 = tcd.getTestResultFailed(PORTLETREQUEST_GETPORTLETSESSIONB1);
      /* TODO: implement test */

      /* TestCase: PortletRequest_getPortletSessionB2 */
      /* Details: "If input flag is true, returns new PortletSession if one does not already exist" */
      TestResult tr25 = tcd.getTestResultFailed(PORTLETREQUEST_GETPORTLETSESSIONB2);
      /* TODO: implement test */

      /* TestCase: PortletRequest_getPortletSessionB3 */
      /* Details: "If input flag is false, returns current PortletSession if one already exists" */
      TestResult tr26 = tcd.getTestResultFailed(PORTLETREQUEST_GETPORTLETSESSIONB3);
      /* TODO: implement test */

      /* TestCase: PortletRequest_getPortletSessionB4 */
      /* Details: "If input flag is false, returns null if one does not already exist" */
      TestResult tr27 = tcd.getTestResultFailed(PORTLETREQUEST_GETPORTLETSESSIONB4);
      /* TODO: implement test */

      /* TestCase: PortletRequest_getProperty1 */
      /* Details: "If specified request property exists, returns its value " */
      TestResult tr28 = tcd.getTestResultFailed(PORTLETREQUEST_GETPROPERTY1);
      /* TODO: implement test */

      /* TestCase: PortletRequest_getProperty2 */
      /* Details: "If specified request property does not exist, returns null" */
      TestResult tr29 = tcd.getTestResultFailed(PORTLETREQUEST_GETPROPERTY2);
      /* TODO: implement test */

      /* TestCase: PortletRequest_getProperty3 */
      /* Details: "Throws IllegalArgumentException if the name is null" */
      TestResult tr30 = tcd.getTestResultFailed(PORTLETREQUEST_GETPROPERTY3);
      /* TODO: implement test */

      /* TestCase: PortletRequest_getProperties1 */
      /* Details: "If specified request property exists, returns its values as an Enumeration " */
      TestResult tr31 = tcd.getTestResultFailed(PORTLETREQUEST_GETPROPERTIES1);
      /* TODO: implement test */

      /* TestCase: PortletRequest_getProperties2 */
      /* Details: "If specified request property does not exist, returns an empty Enumeration" */
      TestResult tr32 = tcd.getTestResultFailed(PORTLETREQUEST_GETPROPERTIES2);
      /* TODO: implement test */

      /* TestCase: PortletRequest_getProperties3 */
      /* Details: "Throws IllegalArgumentException if the name is null" */
      TestResult tr33 = tcd.getTestResultFailed(PORTLETREQUEST_GETPROPERTIES3);
      /* TODO: implement test */

      /* TestCase: PortletRequest_getPropertyNames1 */
      /* Details: "Returns an Enumeration of all request property names" */
      TestResult tr34 = tcd.getTestResultFailed(PORTLETREQUEST_GETPROPERTYNAMES1);
      /* TODO: implement test */

      /* TestCase: PortletRequest_getPropertyNames2 */
      /* Details: "Returns an empty Enumeration if there are no request properties defined" */
      TestResult tr35 = tcd.getTestResultFailed(PORTLETREQUEST_GETPROPERTYNAMES2);
      /* TODO: implement test */

      /* TestCase: PortletRequest_getPortalContext */
      /* Details: "Returns the context of the portal" */
      TestResult tr36 = tcd.getTestResultFailed(PORTLETREQUEST_GETPORTALCONTEXT);
      /* TODO: implement test */

      /* TestCase: PortletRequest_getAuthType1 */
      /* Details: "Returns a String indicating the authentication type if the request was authenticated" */
      TestResult tr37 = tcd.getTestResultFailed(PORTLETREQUEST_GETAUTHTYPE1);
      /* TODO: implement test */

      /* TestCase: PortletRequest_getAuthType2 */
      /* Details: "Returns null if the request was not authenticated" */
      TestResult tr38 = tcd.getTestResultFailed(PORTLETREQUEST_GETAUTHTYPE2);
      /* TODO: implement test */

      /* TestCase: PortletRequest_getContextPath1 */
      /* Details: "Returns a String representing the context path associated with the portlet" */
      TestResult tr39 = tcd.getTestResultFailed(PORTLETREQUEST_GETCONTEXTPATH1);
      /* TODO: implement test */

      /* TestCase: PortletRequest_getContextPath2 */
      /* Details: "Returns an empty String if the portlet is deployed in the default context" */
      TestResult tr40 = tcd.getTestResultFailed(PORTLETREQUEST_GETCONTEXTPATH2);
      /* TODO: implement test */

      /* TestCase: PortletRequest_getContextPath3 */
      /* Details: "If the context path is not empty, it must start with \"/\" and may not end with \"/\"" */
      TestResult tr41 = tcd.getTestResultFailed(PORTLETREQUEST_GETCONTEXTPATH3);
      /* TODO: implement test */

      /* TestCase: PortletRequest_getRemoteUser1 */
      /* Details: "Returns a String representing the login of the user if the request is authenticated" */
      TestResult tr42 = tcd.getTestResultFailed(PORTLETREQUEST_GETREMOTEUSER1);
      /* TODO: implement test */

      /* TestCase: PortletRequest_getRemoteUser2 */
      /* Details: "Returns null if the request has not been authenticated" */
      TestResult tr43 = tcd.getTestResultFailed(PORTLETREQUEST_GETREMOTEUSER2);
      /* TODO: implement test */

      /* TestCase: PortletRequest_getUserPrincipal1 */
      /* Details: "Returns a java.security.Principal object representing the user if the request has been authenticated" */
      TestResult tr44 = tcd.getTestResultFailed(PORTLETREQUEST_GETUSERPRINCIPAL1);
      /* TODO: implement test */

      /* TestCase: PortletRequest_getUserPrincipal2 */
      /* Details: "Returns null if the request has not been authenticated" */
      TestResult tr45 = tcd.getTestResultFailed(PORTLETREQUEST_GETUSERPRINCIPAL2);
      /* TODO: implement test */

      /* TestCase: PortletRequest_isUserInRole1 */
      /* Details: "Returns true if the authenticated user is in the specified role" */
      TestResult tr46 = tcd.getTestResultFailed(PORTLETREQUEST_ISUSERINROLE1);
      /* TODO: implement test */

      /* TestCase: PortletRequest_isUserInRole2 */
      /* Details: "Returns false if the authenticated user is not in the specified role" */
      TestResult tr47 = tcd.getTestResultFailed(PORTLETREQUEST_ISUSERINROLE2);
      /* TODO: implement test */

      /* TestCase: PortletRequest_isUserInRole3 */
      /* Details: "Returns true if the user is not authenticated" */
      TestResult tr48 = tcd.getTestResultFailed(PORTLETREQUEST_ISUSERINROLE3);
      /* TODO: implement test */

      /* TestCase: PortletRequest_getAttribute1 */
      /* Details: "Returns a java.lang.Object for the specified attribute name" */
      TestResult tr49 = tcd.getTestResultFailed(PORTLETREQUEST_GETATTRIBUTE1);
      /* TODO: implement test */

      /* TestCase: PortletRequest_getAttribute2 */
      /* Details: "Returns null if no attribute with the specified name exists" */
      TestResult tr50 = tcd.getTestResultFailed(PORTLETREQUEST_GETATTRIBUTE2);
      /* TODO: implement test */

      /* TestCase: PortletRequest_getAttribute3 */
      /* Details: "Throws IllegalArgumentException if the name is null" */
      TestResult tr51 = tcd.getTestResultFailed(PORTLETREQUEST_GETATTRIBUTE3);
      /* TODO: implement test */

      /* TestCase: PortletRequest_getAttributeNames1 */
      /* Details: "Returns a java.util.Enumeration<java.lang.String> of the available attribute names" */
      TestResult tr52 = tcd.getTestResultFailed(PORTLETREQUEST_GETATTRIBUTENAMES1);
      /* TODO: implement test */

      /* TestCase: PortletRequest_getAttributeNames2 */
      /* Details: "Returns an empty Enumeration if there are no attributes available" */
      TestResult tr53 = tcd.getTestResultFailed(PORTLETREQUEST_GETATTRIBUTENAMES2);
      /* TODO: implement test */

      /* TestCase: PortletRequest_getParameter1 */
      /* Details: "Returns String value of parameter specified by the name" */
      TestResult tr54 = tcd.getTestResultFailed(PORTLETREQUEST_GETPARAMETER1);
      /* TODO: implement test */

      /* TestCase: PortletRequest_getParameter2 */
      /* Details: "Returns String value of a public render parameter specified by the name" */
      TestResult tr55 = tcd.getTestResultFailed(PORTLETREQUEST_GETPARAMETER2);
      /* TODO: implement test */

      /* TestCase: PortletRequest_getParameter3 */
      /* Details: "Returns null if no parameter exists for the specified name" */
      TestResult tr56 = tcd.getTestResultFailed(PORTLETREQUEST_GETPARAMETER3);
      /* TODO: implement test */

      /* TestCase: PortletRequest_getParameter4 */
      /* Details: "Returns first String value from values array if use with a multivalued parameter" */
      TestResult tr57 = tcd.getTestResultFailed(PORTLETREQUEST_GETPARAMETER4);
      /* TODO: implement test */

      /* TestCase: PortletRequest_getParameter5 */
      /* Details: "Throws IllegalArgumentException if the name is null" */
      TestResult tr58 = tcd.getTestResultFailed(PORTLETREQUEST_GETPARAMETER5);
      /* TODO: implement test */

      /* TestCase: PortletRequest_getParameterNames1 */
      /* Details: "Returns a java.util.Enumeration<java.lang.String> of the available parameter names" */
      TestResult tr59 = tcd.getTestResultFailed(PORTLETREQUEST_GETPARAMETERNAMES1);
      /* TODO: implement test */

      /* TestCase: PortletRequest_getParameterNames2 */
      /* Details: "Returns an empty Enumeration if there are no parameters available" */
      TestResult tr60 = tcd.getTestResultFailed(PORTLETREQUEST_GETPARAMETERNAMES2);
      /* TODO: implement test */

      /* TestCase: PortletRequest_getParameterValues1 */
      /* Details: "Returns String[] value of parameter specified by the name" */
      TestResult tr61 = tcd.getTestResultFailed(PORTLETREQUEST_GETPARAMETERVALUES1);
      /* TODO: implement test */

      /* TestCase: PortletRequest_getParameterValues2 */
      /* Details: "Returns String[] value of a public render parameter specified by the name" */
      TestResult tr62 = tcd.getTestResultFailed(PORTLETREQUEST_GETPARAMETERVALUES2);
      /* TODO: implement test */

      /* TestCase: PortletRequest_getParameterValues3 */
      /* Details: "Returns null if no parameter exists for the specified name" */
      TestResult tr63 = tcd.getTestResultFailed(PORTLETREQUEST_GETPARAMETERVALUES3);
      /* TODO: implement test */

      /* TestCase: PortletRequest_getParameterValues4 */
      /* Details: "Throws IllegalArgumentException if the name is null" */
      TestResult tr64 = tcd.getTestResultFailed(PORTLETREQUEST_GETPARAMETERVALUES4);
      /* TODO: implement test */

      /* TestCase: PortletRequest_getParameterMap1 */
      /* Details: "Returns an java.util.Map<java.lang.String,java.lang.String[]> object for the parameter names and values if parameters are available" */
      TestResult tr65 = tcd.getTestResultFailed(PORTLETREQUEST_GETPARAMETERMAP1);
      /* TODO: implement test */

      /* TestCase: PortletRequest_getParameterMap2 */
      /* Details: "The returned map contains all public and private parameters for the request" */
      TestResult tr66 = tcd.getTestResultFailed(PORTLETREQUEST_GETPARAMETERMAP2);
      /* TODO: implement test */

      /* TestCase: PortletRequest_getParameterMap3 */
      /* Details: "Returns an empty map if no parameters exist" */
      TestResult tr67 = tcd.getTestResultFailed(PORTLETREQUEST_GETPARAMETERMAP3);
      /* TODO: implement test */

      /* TestCase: PortletRequest_isSecure1 */
      /* Details: "Returns true if the request was made through a secure channel" */
      TestResult tr68 = tcd.getTestResultFailed(PORTLETREQUEST_ISSECURE1);
      /* TODO: implement test */

      /* TestCase: PortletRequest_isSecure2 */
      /* Details: "Returns false if the request was not made through a secure channel" */
      TestResult tr69 = tcd.getTestResultFailed(PORTLETREQUEST_ISSECURE2);
      /* TODO: implement test */

      /* TestCase: PortletRequest_setAttribute1 */
      /* Details: "Stores an attribute object under the specified name in the request" */
      TestResult tr70 = tcd.getTestResultFailed(PORTLETREQUEST_SETATTRIBUTE1);
      /* TODO: implement test */

      /* TestCase: PortletRequest_setAttribute2 */
      /* Details: "Removes the attribute by the specified name if the object is null" */
      TestResult tr71 = tcd.getTestResultFailed(PORTLETREQUEST_SETATTRIBUTE2);
      /* TODO: implement test */

      /* TestCase: PortletRequest_setAttribute3 */
      /* Details: "Throws IllegalArgumentException if the name is null" */
      TestResult tr72 = tcd.getTestResultFailed(PORTLETREQUEST_SETATTRIBUTE3);
      /* TODO: implement test */

      /* TestCase: PortletRequest_removeAttribute1 */
      /* Details: "Removes the attribute specified by the name from the request" */
      TestResult tr73 = tcd.getTestResultFailed(PORTLETREQUEST_REMOVEATTRIBUTE1);
      /* TODO: implement test */

      /* TestCase: PortletRequest_removeAttribute2 */
      /* Details: "Throws IllegalArgumentException if the name is null" */
      TestResult tr74 = tcd.getTestResultFailed(PORTLETREQUEST_REMOVEATTRIBUTE2);
      /* TODO: implement test */

      /* TestCase: PortletRequest_getRequestedSessionId1 */
      /* Details: "Returns the session ID indicated in the client request" */
      TestResult tr75 = tcd.getTestResultFailed(PORTLETREQUEST_GETREQUESTEDSESSIONID1);
      /* TODO: implement test */

      /* TestCase: PortletRequest_getRequestedSessionId2 */
      /* Details: "Returns null if no session ID was indicated in the client request" */
      TestResult tr76 = tcd.getTestResultFailed(PORTLETREQUEST_GETREQUESTEDSESSIONID2);
      /* TODO: implement test */

      /* TestCase: PortletRequest_isRequestedSessionIdValid1 */
      /* Details: "Returns true if the session ID is valid" */
      TestResult tr77 = tcd.getTestResultFailed(PORTLETREQUEST_ISREQUESTEDSESSIONIDVALID1);
      /* TODO: implement test */

      /* TestCase: PortletRequest_isRequestedSessionIdValid2 */
      /* Details: "Returns false if the session ID is not valid" */
      TestResult tr78 = tcd.getTestResultFailed(PORTLETREQUEST_ISREQUESTEDSESSIONIDVALID2);
      /* TODO: implement test */

      /* TestCase: PortletRequest_getResponseContentType1 */
      /* Details: "Returns a String representing the portal preferred content type for the response if the content type is defined in the portlet descriptor  " */
      TestResult tr79 = tcd.getTestResultFailed(PORTLETREQUEST_GETRESPONSECONTENTTYPE1);
      /* TODO: implement test */

      /* TestCase: PortletRequest_getResponseContentType2 */
      /* Details: "Returns ??? if the content type is not defined in the portlet descriptor" */
      TestResult tr80 = tcd.getTestResultFailed(PORTLETREQUEST_GETRESPONSECONTENTTYPE2);
      /* TODO: implement test */

      /* TestCase: PortletRequest_getResponseContentTypes1 */
      /* Details: "Returns an java.util.Enumeration<java.lang.String> object representing the portal preferred content types for the response if the content types are defined in the portlet descriptor" */
      TestResult tr81 = tcd.getTestResultFailed(PORTLETREQUEST_GETRESPONSECONTENTTYPES1);
      /* TODO: implement test */

      /* TestCase: PortletRequest_getResponseContentTypes2 */
      /* Details: "Returns ??? if the content types are not defined in the portlet descriptor" */
      TestResult tr82 = tcd.getTestResultFailed(PORTLETREQUEST_GETRESPONSECONTENTTYPES2);
      /* TODO: implement test */

      /* TestCase: PortletRequest_getLocale */
      /* Details: "Returns an java.util.Locale object representing the preferred Locale for the response" */
      TestResult tr83 = tcd.getTestResultFailed(PORTLETREQUEST_GETLOCALE);
      /* TODO: implement test */

      /* TestCase: PortletRequest_getLocales */
      /* Details: "Returns an java.util.Enumeration<java.util.Locale> of the Locales in which the portal will accept content" */
      TestResult tr84 = tcd.getTestResultFailed(PORTLETREQUEST_GETLOCALES);
      /* TODO: implement test */

      /* TestCase: PortletRequest_getScheme */
      /* Details: "Returns a String value representing the scheme name for the request" */
      TestResult tr85 = tcd.getTestResultFailed(PORTLETREQUEST_GETSCHEME);
      /* TODO: implement test */

      /* TestCase: PortletRequest_getServerName */
      /* Details: "Returns a String value representing the host name for the request" */
      TestResult tr86 = tcd.getTestResultFailed(PORTLETREQUEST_GETSERVERNAME);
      /* TODO: implement test */

      /* TestCase: PortletRequest_getServerPort */
      /* Details: "Returns an int value representing the port number for the request" */
      TestResult tr87 = tcd.getTestResultFailed(PORTLETREQUEST_GETSERVERPORT);
      /* TODO: implement test */

      /* TestCase: PortletRequest_getWindowID */
      /* Details: "Returns a String value representing the portlet window ID" */
      TestResult tr88 = tcd.getTestResultFailed(PORTLETREQUEST_GETWINDOWID);
      /* TODO: implement test */

      /* TestCase: PortletRequest_getCookies1 */
      /* Details: "Returns a javax.servlet.http.Cookie[] array containing the cookies for this request" */
      TestResult tr89 = tcd.getTestResultFailed(PORTLETREQUEST_GETCOOKIES1);
      /* TODO: implement test */

      /* TestCase: PortletRequest_getCookies2 */
      /* Details: "Returns null if no cookies are present" */
      TestResult tr90 = tcd.getTestResultFailed(PORTLETREQUEST_GETCOOKIES2);
      /* TODO: implement test */

      /* TestCase: PortletRequest_getPrivateParameterMap1 */
      /* Details: "Returns an java.util.Map<java.lang.String,java.lang.String[]> object for the private parameter names and values if available" */
      TestResult tr91 = tcd.getTestResultFailed(PORTLETREQUEST_GETPRIVATEPARAMETERMAP1);
      /* TODO: implement test */

      /* TestCase: PortletRequest_getPrivateParameterMap2 */
      /* Details: "The returned map is immutable" */
      TestResult tr92 = tcd.getTestResultFailed(PORTLETREQUEST_GETPRIVATEPARAMETERMAP2);
      /* TODO: implement test */

      /* TestCase: PortletRequest_getPrivateParameterMap3 */
      /* Details: "Returns an empty map if no private parameters exist" */
      TestResult tr93 = tcd.getTestResultFailed(PORTLETREQUEST_GETPRIVATEPARAMETERMAP3);
      /* TODO: implement test */

      /* TestCase: PortletRequest_getPublicParameterMap1 */
      /* Details: "Returns an java.util.Map<java.lang.String,java.lang.String[]> object for the public parameter names and values if available" */
      TestResult tr94 = tcd.getTestResultFailed(PORTLETREQUEST_GETPUBLICPARAMETERMAP1);
      /* TODO: implement test */

      /* TestCase: PortletRequest_getPublicParameterMap2 */
      /* Details: "The returned map is immutable" */
      TestResult tr95 = tcd.getTestResultFailed(PORTLETREQUEST_GETPUBLICPARAMETERMAP2);
      /* TODO: implement test */

      /* TestCase: PortletRequest_getPublicParameterMap3 */
      /* Details: "Returns an empty map if no public parameters exist" */
      TestResult tr96 = tcd.getTestResultFailed(PORTLETREQUEST_GETPUBLICPARAMETERMAP3);
      /* TODO: implement test */



      // Write the results to the output stream

      tr0.writeTo(writer);
      tr1.writeTo(writer);
      tr2.writeTo(writer);
      tr3.writeTo(writer);
      tr4.writeTo(writer);
      tr5.writeTo(writer);
      tr6.writeTo(writer);
      tr7.writeTo(writer);
      tr8.writeTo(writer);
      tr9.writeTo(writer);
      tr10.writeTo(writer);
      tr11.writeTo(writer);
      tr12.writeTo(writer);
      tr13.writeTo(writer);
      tr14.writeTo(writer);
      tr15.writeTo(writer);
      tr16.writeTo(writer);
      tr17.writeTo(writer);
      tr18.writeTo(writer);
      tr19.writeTo(writer);
      tr20.writeTo(writer);
      tr21.writeTo(writer);
      tr22.writeTo(writer);
      tr23.writeTo(writer);
      tr24.writeTo(writer);
      tr25.writeTo(writer);
      tr26.writeTo(writer);
      tr27.writeTo(writer);
      tr28.writeTo(writer);
      tr29.writeTo(writer);
      tr30.writeTo(writer);
      tr31.writeTo(writer);
      tr32.writeTo(writer);
      tr33.writeTo(writer);
      tr34.writeTo(writer);
      tr35.writeTo(writer);
      tr36.writeTo(writer);
      tr37.writeTo(writer);
      tr38.writeTo(writer);
      tr39.writeTo(writer);
      tr40.writeTo(writer);
      tr41.writeTo(writer);
      tr42.writeTo(writer);
      tr43.writeTo(writer);
      tr44.writeTo(writer);
      tr45.writeTo(writer);
      tr46.writeTo(writer);
      tr47.writeTo(writer);
      tr48.writeTo(writer);
      tr49.writeTo(writer);
      tr50.writeTo(writer);
      tr51.writeTo(writer);
      tr52.writeTo(writer);
      tr53.writeTo(writer);
      tr54.writeTo(writer);
      tr55.writeTo(writer);
      tr56.writeTo(writer);
      tr57.writeTo(writer);
      tr58.writeTo(writer);
      tr59.writeTo(writer);
      tr60.writeTo(writer);
      tr61.writeTo(writer);
      tr62.writeTo(writer);
      tr63.writeTo(writer);
      tr64.writeTo(writer);
      tr65.writeTo(writer);
      tr66.writeTo(writer);
      tr67.writeTo(writer);
      tr68.writeTo(writer);
      tr69.writeTo(writer);
      tr70.writeTo(writer);
      tr71.writeTo(writer);
      tr72.writeTo(writer);
      tr73.writeTo(writer);
      tr74.writeTo(writer);
      tr75.writeTo(writer);
      tr76.writeTo(writer);
      tr77.writeTo(writer);
      tr78.writeTo(writer);
      tr79.writeTo(writer);
      tr80.writeTo(writer);
      tr81.writeTo(writer);
      tr82.writeTo(writer);
      tr83.writeTo(writer);
      tr84.writeTo(writer);
      tr85.writeTo(writer);
      tr86.writeTo(writer);
      tr87.writeTo(writer);
      tr88.writeTo(writer);
      tr89.writeTo(writer);
      tr90.writeTo(writer);
      tr91.writeTo(writer);
      tr92.writeTo(writer);
      tr93.writeTo(writer);
      tr94.writeTo(writer);
      tr95.writeTo(writer);
      tr96.writeTo(writer);


   }

}

