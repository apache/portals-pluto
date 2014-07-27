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
public class V2RequestTests_SIG_PortletRequest implements Portlet {
   private static final String LOG_CLASS = 
         V2RequestTests_SIG_PortletRequest.class.getName();
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

      /* TestCase: PortletRequest_SIG_fieldUSER_INFO */
      /* Details: "Has String field USER_INFO " */
      TestResult tr0 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_FIELDUSER_INFO);
      {
         tr0.setTcSuccess(cc.hasField("USER_INFO"));
      }

      /* TestCase: PortletRequest_SIG_fieldCCPP_PROFILE */
      /* Details: "Has String field CCPP_PROFILE " */
      TestResult tr1 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_FIELDCCPP_PROFILE);
      {
         tr1.setTcSuccess(cc.hasField("CCPP_PROFILE"));
      }

      /* TestCase: PortletRequest_SIG_fieldBASIC_AUTH */
      /* Details: "Has String field BASIC_AUTH " */
      TestResult tr2 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_FIELDBASIC_AUTH);
      {
         tr2.setTcSuccess(cc.hasField("BASIC_AUTH"));
      }

      /* TestCase: PortletRequest_SIG_fieldFORM_AUTH */
      /* Details: "Has String field FORM_AUTH " */
      TestResult tr3 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_FIELDFORM_AUTH);
      {
         tr3.setTcSuccess(cc.hasField("FORM_AUTH"));
      }

      /* TestCase: PortletRequest_SIG_fieldCLIENT_CERT_AUTH */
      /* Details: "Has String field CLIENT_CERT_AUTH " */
      TestResult tr4 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_FIELDCLIENT_CERT_AUTH);
      {
         tr4.setTcSuccess(cc.hasField("CLIENT_CERT_AUTH"));
      }

      /* TestCase: PortletRequest_SIG_fieldDIGEST_AUTH */
      /* Details: "Has String field DIGEST_AUTH " */
      TestResult tr5 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_FIELDDIGEST_AUTH);
      {
         tr5.setTcSuccess(cc.hasField("DIGEST_AUTH"));
      }

      /* TestCase: PortletRequest_SIG_fieldACTION_PHASE */
      /* Details: "Has String field ACTION_PHASE " */
      TestResult tr6 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_FIELDACTION_PHASE);
      {
         tr6.setTcSuccess(cc.hasField("ACTION_PHASE"));
      }

      /* TestCase: PortletRequest_SIG_fieldEVENT_PHASE */
      /* Details: "Has String field EVENT_PHASE " */
      TestResult tr7 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_FIELDEVENT_PHASE);
      {
         tr7.setTcSuccess(cc.hasField("EVENT_PHASE"));
      }

      /* TestCase: PortletRequest_SIG_fieldRENDER_PHASE */
      /* Details: "Has String field RENDER_PHASE " */
      TestResult tr8 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_FIELDRENDER_PHASE);
      {
         tr8.setTcSuccess(cc.hasField("RENDER_PHASE"));
      }

      /* TestCase: PortletRequest_SIG_fieldRESOURCE_PHASE */
      /* Details: "Has String field RESOURCE_PHASE " */
      TestResult tr9 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_FIELDRESOURCE_PHASE);
      {
         tr9.setTcSuccess(cc.hasField("RESOURCE_PHASE"));
      }

      /* TestCase: PortletRequest_SIG_fieldLIFECYCLE_PHASE */
      /* Details: "Has String field LIFECYCLE_PHASE " */
      TestResult tr10 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_FIELDLIFECYCLE_PHASE);
      {
         tr10.setTcSuccess(cc.hasField("LIFECYCLE_PHASE"));
      }

      /* TestCase: PortletRequest_SIG_fieldRENDER_PART */
      /* Details: "Has String field RENDER_PART " */
      TestResult tr11 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_FIELDRENDER_PART);
      {
         tr11.setTcSuccess(cc.hasField("RENDER_PART"));
      }

      /* TestCase: PortletRequest_SIG_fieldRENDER_HEADERS */
      /* Details: "Has String field RENDER_HEADERS " */
      TestResult tr12 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_FIELDRENDER_HEADERS);
      {
         tr12.setTcSuccess(cc.hasField("RENDER_HEADERS"));
      }

      /* TestCase: PortletRequest_SIG_fieldRENDER_MARKUP */
      /* Details: "Has String field RENDER_MARKUP " */
      TestResult tr13 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_FIELDRENDER_MARKUP);
      {
         tr13.setTcSuccess(cc.hasField("RENDER_MARKUP"));
      }

      /* TestCase: PortletRequest_SIG_fieldACTION_SCOPE_ID */
      /* Details: "Has String field ACTION_SCOPE_ID " */
      TestResult tr14 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_FIELDACTION_SCOPE_ID);
      {
         tr14.setTcSuccess(cc.hasField("ACTION_SCOPE_ID"));
      }

      /* TestCase: PortletRequest_SIG_hasIsWindowStateAllowed */
      /* Details: "Has a isWindowStateAllowed(WindowState)  method " */
      TestResult tr15 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASISWINDOWSTATEALLOWED);
      {
         String name = "isWindowStateAllowed";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {WindowState.class};
         tr15.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequest_SIG_hasIsWindowStateAllowedReturns */
      /* Details: "Method isWindowStateAllowed(WindowState) returns boolean " */
      TestResult tr16 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASISWINDOWSTATEALLOWEDRETURNS);
      {
         String name = "isWindowStateAllowed";
         Class<?> retType = boolean.class;
         Class<?>[] parms = {WindowState.class};
         tr16.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequest_SIG_hasIsPortletModeAllowed */
      /* Details: "Has a isPortletModeAllowed(PortletMode)  method " */
      TestResult tr17 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASISPORTLETMODEALLOWED);
      {
         String name = "isPortletModeAllowed";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {PortletMode.class};
         tr17.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequest_SIG_hasIsPortletModeAllowedReturns */
      /* Details: "Method isPortletModeAllowed(PortletMode) returns boolean " */
      TestResult tr18 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASISPORTLETMODEALLOWEDRETURNS);
      {
         String name = "isPortletModeAllowed";
         Class<?> retType = boolean.class;
         Class<?>[] parms = {PortletMode.class};
         tr18.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequest_SIG_hasGetPortletMode */
      /* Details: "Has a getPortletMode()  method " */
      TestResult tr19 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASGETPORTLETMODE);
      {
         String name = "getPortletMode";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr19.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequest_SIG_hasGetPortletModeReturns */
      /* Details: "Method getPortletMode() returns PortletMode " */
      TestResult tr20 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASGETPORTLETMODERETURNS);
      {
         String name = "getPortletMode";
         Class<?> retType = PortletMode.class;
         Class<?>[] parms = null;
         tr20.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequest_SIG_hasGetWindowState */
      /* Details: "Has a getWindowState()  method " */
      TestResult tr21 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASGETWINDOWSTATE);
      {
         String name = "getWindowState";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr21.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequest_SIG_hasGetWindowStateReturns */
      /* Details: "Method getWindowState() returns WindowState " */
      TestResult tr22 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASGETWINDOWSTATERETURNS);
      {
         String name = "getWindowState";
         Class<?> retType = WindowState.class;
         Class<?>[] parms = null;
         tr22.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequest_SIG_hasGetPreferences */
      /* Details: "Has a getPreferences()  method " */
      TestResult tr23 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASGETPREFERENCES);
      {
         String name = "getPreferences";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr23.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequest_SIG_hasGetPreferencesReturns */
      /* Details: "Method getPreferences() returns PortletPreferences " */
      TestResult tr24 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASGETPREFERENCESRETURNS);
      {
         String name = "getPreferences";
         Class<?> retType = PortletPreferences.class;
         Class<?>[] parms = null;
         tr24.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequest_SIG_hasGetPortletSession */
      /* Details: "Has a getPortletSession()  method " */
      TestResult tr25 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASGETPORTLETSESSION);
      {
         String name = "getPortletSession";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr25.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequest_SIG_hasGetPortletSessionReturns */
      /* Details: "Method getPortletSession() returns PortletSession " */
      TestResult tr26 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASGETPORTLETSESSIONRETURNS);
      {
         String name = "getPortletSession";
         Class<?> retType = PortletSession.class;
         Class<?>[] parms = null;
         tr26.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequest_SIG_hasGetPortletSessionA */
      /* Details: "Has a getPortletSession(boolean)  method " */
      TestResult tr27 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASGETPORTLETSESSIONA);
      {
         String name = "getPortletSession";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {boolean.class};
         tr27.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequest_SIG_hasGetPortletSessionReturnsA */
      /* Details: "Method getPortletSession(boolean) returns PortletSession " */
      TestResult tr28 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASGETPORTLETSESSIONRETURNSA);
      {
         String name = "getPortletSession";
         Class<?> retType = PortletSession.class;
         Class<?>[] parms = {boolean.class};
         tr28.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequest_SIG_hasGetProperty */
      /* Details: "Has a getProperty(String)  method " */
      TestResult tr29 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASGETPROPERTY);
      {
         String name = "getProperty";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class};
         tr29.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequest_SIG_hasGetPropertyReturns */
      /* Details: "Method getProperty(String) returns String " */
      TestResult tr30 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASGETPROPERTYRETURNS);
      {
         String name = "getProperty";
         Class<?> retType = String.class;
         Class<?>[] parms = {String.class};
         tr30.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequest_SIG_hasGetProperties */
      /* Details: "Has a getProperties(String)  method " */
      TestResult tr31 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASGETPROPERTIES);
      {
         String name = "getProperties";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class};
         tr31.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequest_SIG_hasGetPropertiesReturns */
      /* Details: "Method getProperties(String) returns java.util.Enumeration " */
      TestResult tr32 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASGETPROPERTIESRETURNS);
      {
         String name = "getProperties";
         Class<?> retType = java.util.Enumeration.class;
         Class<?>[] parms = {String.class};
         tr32.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequest_SIG_hasGetPropertyNames */
      /* Details: "Has a getPropertyNames()  method " */
      TestResult tr33 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASGETPROPERTYNAMES);
      {
         String name = "getPropertyNames";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr33.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequest_SIG_hasGetPropertyNamesReturns */
      /* Details: "Method getPropertyNames() returns java.util.Enumeration " */
      TestResult tr34 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASGETPROPERTYNAMESRETURNS);
      {
         String name = "getPropertyNames";
         Class<?> retType = java.util.Enumeration.class;
         Class<?>[] parms = null;
         tr34.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequest_SIG_hasGetPortalContext */
      /* Details: "Has a getPortalContext()  method " */
      TestResult tr35 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASGETPORTALCONTEXT);
      {
         String name = "getPortalContext";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr35.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequest_SIG_hasGetPortalContextReturns */
      /* Details: "Method getPortalContext() returns PortalContext " */
      TestResult tr36 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASGETPORTALCONTEXTRETURNS);
      {
         String name = "getPortalContext";
         Class<?> retType = PortalContext.class;
         Class<?>[] parms = null;
         tr36.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequest_SIG_hasGetAuthType */
      /* Details: "Has a getAuthType()  method " */
      TestResult tr37 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASGETAUTHTYPE);
      {
         String name = "getAuthType";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr37.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequest_SIG_hasGetAuthTypeReturns */
      /* Details: "Method getAuthType() returns String " */
      TestResult tr38 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASGETAUTHTYPERETURNS);
      {
         String name = "getAuthType";
         Class<?> retType = String.class;
         Class<?>[] parms = null;
         tr38.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequest_SIG_hasGetContextPath */
      /* Details: "Has a getContextPath()  method " */
      TestResult tr39 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASGETCONTEXTPATH);
      {
         String name = "getContextPath";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr39.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequest_SIG_hasGetContextPathReturns */
      /* Details: "Method getContextPath() returns String " */
      TestResult tr40 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASGETCONTEXTPATHRETURNS);
      {
         String name = "getContextPath";
         Class<?> retType = String.class;
         Class<?>[] parms = null;
         tr40.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequest_SIG_hasGetRemoteUser */
      /* Details: "Has a getRemoteUser()  method " */
      TestResult tr41 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASGETREMOTEUSER);
      {
         String name = "getRemoteUser";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr41.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequest_SIG_hasGetRemoteUserReturns */
      /* Details: "Method getRemoteUser() returns String " */
      TestResult tr42 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASGETREMOTEUSERRETURNS);
      {
         String name = "getRemoteUser";
         Class<?> retType = String.class;
         Class<?>[] parms = null;
         tr42.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequest_SIG_hasGetUserPrincipal */
      /* Details: "Has a getUserPrincipal()  method " */
      TestResult tr43 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASGETUSERPRINCIPAL);
      {
         String name = "getUserPrincipal";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr43.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequest_SIG_hasGetUserPrincipalReturns */
      /* Details: "Method getUserPrincipal() returns java.security.Principal " */
      TestResult tr44 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASGETUSERPRINCIPALRETURNS);
      {
         String name = "getUserPrincipal";
         Class<?> retType = java.security.Principal.class;
         Class<?>[] parms = null;
         tr44.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequest_SIG_hasIsUserInRole */
      /* Details: "Has a isUserInRole(String)  method " */
      TestResult tr45 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASISUSERINROLE);
      {
         String name = "isUserInRole";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class};
         tr45.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequest_SIG_hasIsUserInRoleReturns */
      /* Details: "Method isUserInRole(String) returns boolean " */
      TestResult tr46 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASISUSERINROLERETURNS);
      {
         String name = "isUserInRole";
         Class<?> retType = boolean.class;
         Class<?>[] parms = {String.class};
         tr46.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequest_SIG_hasGetAttribute */
      /* Details: "Has a getAttribute(String)  method " */
      TestResult tr47 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASGETATTRIBUTE);
      {
         String name = "getAttribute";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class};
         tr47.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequest_SIG_hasGetAttributeReturns */
      /* Details: "Method getAttribute(String) returns Object " */
      TestResult tr48 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASGETATTRIBUTERETURNS);
      {
         String name = "getAttribute";
         Class<?> retType = Object.class;
         Class<?>[] parms = {String.class};
         tr48.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequest_SIG_hasGetAttributeNames */
      /* Details: "Has a getAttributeNames()  method " */
      TestResult tr49 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASGETATTRIBUTENAMES);
      {
         String name = "getAttributeNames";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr49.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequest_SIG_hasGetAttributeNamesReturns */
      /* Details: "Method getAttributeNames() returns java.util.Enumeration " */
      TestResult tr50 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASGETATTRIBUTENAMESRETURNS);
      {
         String name = "getAttributeNames";
         Class<?> retType = java.util.Enumeration.class;
         Class<?>[] parms = null;
         tr50.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequest_SIG_hasGetParameter */
      /* Details: "Has a getParameter(String)  method " */
      TestResult tr51 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASGETPARAMETER);
      {
         String name = "getParameter";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class};
         tr51.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequest_SIG_hasGetParameterReturns */
      /* Details: "Method getParameter(String) returns String " */
      TestResult tr52 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASGETPARAMETERRETURNS);
      {
         String name = "getParameter";
         Class<?> retType = String.class;
         Class<?>[] parms = {String.class};
         tr52.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequest_SIG_hasGetParameterNames */
      /* Details: "Has a getParameterNames()  method " */
      TestResult tr53 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASGETPARAMETERNAMES);
      {
         String name = "getParameterNames";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr53.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequest_SIG_hasGetParameterNamesReturns */
      /* Details: "Method getParameterNames() returns java.util.Enumeration " */
      TestResult tr54 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASGETPARAMETERNAMESRETURNS);
      {
         String name = "getParameterNames";
         Class<?> retType = java.util.Enumeration.class;
         Class<?>[] parms = null;
         tr54.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequest_SIG_hasGetParameterValues */
      /* Details: "Has a getParameterValues(String)  method " */
      TestResult tr55 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASGETPARAMETERVALUES);
      {
         String name = "getParameterValues";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class};
         tr55.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequest_SIG_hasGetParameterValuesReturns */
      /* Details: "Method getParameterValues(String) returns String[] " */
      TestResult tr56 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASGETPARAMETERVALUESRETURNS);
      {
         String name = "getParameterValues";
         Class<?> retType = String[].class;
         Class<?>[] parms = {String.class};
         tr56.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequest_SIG_hasGetParameterMap */
      /* Details: "Has a getParameterMap()  method " */
      TestResult tr57 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASGETPARAMETERMAP);
      {
         String name = "getParameterMap";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr57.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequest_SIG_hasGetParameterMapReturns */
      /* Details: "Method getParameterMap() returns java.util.Map " */
      TestResult tr58 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASGETPARAMETERMAPRETURNS);
      {
         String name = "getParameterMap";
         Class<?> retType = java.util.Map.class;
         Class<?>[] parms = null;
         tr58.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequest_SIG_hasIsSecure */
      /* Details: "Has a isSecure()  method " */
      TestResult tr59 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASISSECURE);
      {
         String name = "isSecure";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr59.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequest_SIG_hasIsSecureReturns */
      /* Details: "Method isSecure() returns boolean " */
      TestResult tr60 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASISSECURERETURNS);
      {
         String name = "isSecure";
         Class<?> retType = boolean.class;
         Class<?>[] parms = null;
         tr60.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequest_SIG_hasSetAttribute */
      /* Details: "Has a setAttribute(String, Object)  method " */
      TestResult tr61 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASSETATTRIBUTE);
      {
         String name = "setAttribute";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class, Object.class};
         tr61.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequest_SIG_hasSetAttributeReturns */
      /* Details: "Method setAttribute(String, Object) returns void " */
      TestResult tr62 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASSETATTRIBUTERETURNS);
      {
         String name = "setAttribute";
         Class<?> retType = void.class;
         Class<?>[] parms = {String.class, Object.class};
         tr62.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequest_SIG_hasRemoveAttribute */
      /* Details: "Has a removeAttribute(String)  method " */
      TestResult tr63 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASREMOVEATTRIBUTE);
      {
         String name = "removeAttribute";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class};
         tr63.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequest_SIG_hasRemoveAttributeReturns */
      /* Details: "Method removeAttribute(String) returns void " */
      TestResult tr64 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASREMOVEATTRIBUTERETURNS);
      {
         String name = "removeAttribute";
         Class<?> retType = void.class;
         Class<?>[] parms = {String.class};
         tr64.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequest_SIG_hasGetRequestedSessionId */
      /* Details: "Has a getRequestedSessionId()  method " */
      TestResult tr65 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASGETREQUESTEDSESSIONID);
      {
         String name = "getRequestedSessionId";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr65.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequest_SIG_hasGetRequestedSessionIdReturns */
      /* Details: "Method getRequestedSessionId() returns String " */
      TestResult tr66 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASGETREQUESTEDSESSIONIDRETURNS);
      {
         String name = "getRequestedSessionId";
         Class<?> retType = String.class;
         Class<?>[] parms = null;
         tr66.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequest_SIG_hasIsRequestedSessionIdValid */
      /* Details: "Has a isRequestedSessionIdValid()  method " */
      TestResult tr67 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASISREQUESTEDSESSIONIDVALID);
      {
         String name = "isRequestedSessionIdValid";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr67.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequest_SIG_hasIsRequestedSessionIdValidReturns */
      /* Details: "Method isRequestedSessionIdValid() returns boolean " */
      TestResult tr68 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASISREQUESTEDSESSIONIDVALIDRETURNS);
      {
         String name = "isRequestedSessionIdValid";
         Class<?> retType = boolean.class;
         Class<?>[] parms = null;
         tr68.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequest_SIG_hasGetResponseContentType */
      /* Details: "Has a getResponseContentType()  method " */
      TestResult tr69 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASGETRESPONSECONTENTTYPE);
      {
         String name = "getResponseContentType";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr69.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequest_SIG_hasGetResponseContentTypeReturns */
      /* Details: "Method getResponseContentType() returns String " */
      TestResult tr70 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASGETRESPONSECONTENTTYPERETURNS);
      {
         String name = "getResponseContentType";
         Class<?> retType = String.class;
         Class<?>[] parms = null;
         tr70.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequest_SIG_hasGetResponseContentTypes */
      /* Details: "Has a getResponseContentTypes()  method " */
      TestResult tr71 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASGETRESPONSECONTENTTYPES);
      {
         String name = "getResponseContentTypes";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr71.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequest_SIG_hasGetResponseContentTypesReturns */
      /* Details: "Method getResponseContentTypes() returns java.util.Enumeration " */
      TestResult tr72 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASGETRESPONSECONTENTTYPESRETURNS);
      {
         String name = "getResponseContentTypes";
         Class<?> retType = java.util.Enumeration.class;
         Class<?>[] parms = null;
         tr72.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequest_SIG_hasGetLocale */
      /* Details: "Has a getLocale()  method " */
      TestResult tr73 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASGETLOCALE);
      {
         String name = "getLocale";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr73.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequest_SIG_hasGetLocaleReturns */
      /* Details: "Method getLocale() returns java.util.Locale " */
      TestResult tr74 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASGETLOCALERETURNS);
      {
         String name = "getLocale";
         Class<?> retType = java.util.Locale.class;
         Class<?>[] parms = null;
         tr74.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequest_SIG_hasGetLocales */
      /* Details: "Has a getLocales()  method " */
      TestResult tr75 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASGETLOCALES);
      {
         String name = "getLocales";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr75.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequest_SIG_hasGetLocalesReturns */
      /* Details: "Method getLocales() returns java.util.Enumeration " */
      TestResult tr76 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASGETLOCALESRETURNS);
      {
         String name = "getLocales";
         Class<?> retType = java.util.Enumeration.class;
         Class<?>[] parms = null;
         tr76.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequest_SIG_hasGetScheme */
      /* Details: "Has a getScheme()  method " */
      TestResult tr77 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASGETSCHEME);
      {
         String name = "getScheme";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr77.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequest_SIG_hasGetSchemeReturns */
      /* Details: "Method getScheme() returns String " */
      TestResult tr78 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASGETSCHEMERETURNS);
      {
         String name = "getScheme";
         Class<?> retType = String.class;
         Class<?>[] parms = null;
         tr78.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequest_SIG_hasGetServerName */
      /* Details: "Has a getServerName()  method " */
      TestResult tr79 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASGETSERVERNAME);
      {
         String name = "getServerName";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr79.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequest_SIG_hasGetServerNameReturns */
      /* Details: "Method getServerName() returns String " */
      TestResult tr80 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASGETSERVERNAMERETURNS);
      {
         String name = "getServerName";
         Class<?> retType = String.class;
         Class<?>[] parms = null;
         tr80.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequest_SIG_hasGetServerPort */
      /* Details: "Has a getServerPort()  method " */
      TestResult tr81 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASGETSERVERPORT);
      {
         String name = "getServerPort";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr81.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequest_SIG_hasGetServerPortReturns */
      /* Details: "Method getServerPort() returns int " */
      TestResult tr82 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASGETSERVERPORTRETURNS);
      {
         String name = "getServerPort";
         Class<?> retType = int.class;
         Class<?>[] parms = null;
         tr82.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequest_SIG_hasGetWindowID */
      /* Details: "Has a getWindowID()  method " */
      TestResult tr83 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASGETWINDOWID);
      {
         String name = "getWindowID";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr83.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequest_SIG_hasGetWindowIDReturns */
      /* Details: "Method getWindowID() returns String " */
      TestResult tr84 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASGETWINDOWIDRETURNS);
      {
         String name = "getWindowID";
         Class<?> retType = String.class;
         Class<?>[] parms = null;
         tr84.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequest_SIG_hasGetCookies */
      /* Details: "Has a getCookies()  method " */
      TestResult tr85 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASGETCOOKIES);
      {
         String name = "getCookies";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr85.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequest_SIG_hasGetCookiesReturns */
      /* Details: "Method getCookies() returns javax.servlet.http.Cookie[] " */
      TestResult tr86 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASGETCOOKIESRETURNS);
      {
         String name = "getCookies";
         Class<?> retType = javax.servlet.http.Cookie[].class;
         Class<?>[] parms = null;
         tr86.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequest_SIG_hasGetPrivateParameterMap */
      /* Details: "Has a getPrivateParameterMap()  method " */
      TestResult tr87 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASGETPRIVATEPARAMETERMAP);
      {
         String name = "getPrivateParameterMap";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr87.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequest_SIG_hasGetPrivateParameterMapReturns */
      /* Details: "Method getPrivateParameterMap() returns java.util.Map " */
      TestResult tr88 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASGETPRIVATEPARAMETERMAPRETURNS);
      {
         String name = "getPrivateParameterMap";
         Class<?> retType = java.util.Map.class;
         Class<?>[] parms = null;
         tr88.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequest_SIG_hasGetPublicParameterMap */
      /* Details: "Has a getPublicParameterMap()  method " */
      TestResult tr89 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASGETPUBLICPARAMETERMAP);
      {
         String name = "getPublicParameterMap";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr89.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequest_SIG_hasGetPublicParameterMapReturns */
      /* Details: "Method getPublicParameterMap() returns java.util.Map " */
      TestResult tr90 = tcd.getTestResultFailed(PORTLETREQUEST_SIG_HASGETPUBLICPARAMETERMAPRETURNS);
      {
         String name = "getPublicParameterMap";
         Class<?> retType = java.util.Map.class;
         Class<?>[] parms = null;
         tr90.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }



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


   }

}

