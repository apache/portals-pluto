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

package javax.portlet.tck.WrapperTests.portlets;

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
public class V2WrapperTests_SIG_PortletRequestWrapper implements Portlet {
   private static final String LOG_CLASS = 
         V2WrapperTests_SIG_PortletRequestWrapper.class.getName();
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
      ClassChecker cc = new ClassChecker(PortletRequestWrapper.class);

      // Create result objects for the tests

      /* TestCase: PortletRequestWrapper_SIG_implementsPortletRequest */
      /* Details: "Implements PortletRequest " */
      TestResult tr0 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_IMPLEMENTSPORTLETREQUEST);
      {
         tr0.setTcSuccess(cc.implementsInterface(PortletRequest.class));
      }

      /* TestCase: PortletRequestWrapper_SIG_constructor */
      /* Details: "Provides constructor PortletRequestWrapper(PortletRequest) " */
      TestResult tr1 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_CONSTRUCTOR);
      {
         Class<?>[] parms = {PortletRequest.class};
         tr1.setTcSuccess(cc.hasConstructor(parms));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasGetAttribute */
      /* Details: "Has a getAttribute(String)  method " */
      TestResult tr2 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASGETATTRIBUTE);
      {
         String name = "getAttribute";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class};
         tr2.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasGetAttributeReturns */
      /* Details: "Method getAttribute(String) returns Object " */
      TestResult tr3 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASGETATTRIBUTERETURNS);
      {
         String name = "getAttribute";
         Class<?> retType = Object.class;
         Class<?>[] parms = {String.class};
         tr3.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasGetAttributeNames */
      /* Details: "Has a getAttributeNames()  method " */
      TestResult tr4 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASGETATTRIBUTENAMES);
      {
         String name = "getAttributeNames";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr4.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasGetAttributeNamesReturns */
      /* Details: "Method getAttributeNames() returns java.util.Enumeration " */
      TestResult tr5 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASGETATTRIBUTENAMESRETURNS);
      {
         String name = "getAttributeNames";
         Class<?> retType = java.util.Enumeration.class;
         Class<?>[] parms = null;
         tr5.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasGetAuthType */
      /* Details: "Has a getAuthType()  method " */
      TestResult tr6 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASGETAUTHTYPE);
      {
         String name = "getAuthType";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr6.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasGetAuthTypeReturns */
      /* Details: "Method getAuthType() returns String " */
      TestResult tr7 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASGETAUTHTYPERETURNS);
      {
         String name = "getAuthType";
         Class<?> retType = String.class;
         Class<?>[] parms = null;
         tr7.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasGetContextPath */
      /* Details: "Has a getContextPath()  method " */
      TestResult tr8 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASGETCONTEXTPATH);
      {
         String name = "getContextPath";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr8.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasGetContextPathReturns */
      /* Details: "Method getContextPath() returns String " */
      TestResult tr9 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASGETCONTEXTPATHRETURNS);
      {
         String name = "getContextPath";
         Class<?> retType = String.class;
         Class<?>[] parms = null;
         tr9.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasGetLocale */
      /* Details: "Has a getLocale()  method " */
      TestResult tr10 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASGETLOCALE);
      {
         String name = "getLocale";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr10.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasGetLocaleReturns */
      /* Details: "Method getLocale() returns java.util.Locale " */
      TestResult tr11 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASGETLOCALERETURNS);
      {
         String name = "getLocale";
         Class<?> retType = java.util.Locale.class;
         Class<?>[] parms = null;
         tr11.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasGetLocales */
      /* Details: "Has a getLocales()  method " */
      TestResult tr12 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASGETLOCALES);
      {
         String name = "getLocales";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr12.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasGetLocalesReturns */
      /* Details: "Method getLocales() returns java.util.Enumeration " */
      TestResult tr13 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASGETLOCALESRETURNS);
      {
         String name = "getLocales";
         Class<?> retType = java.util.Enumeration.class;
         Class<?>[] parms = null;
         tr13.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasGetParameter */
      /* Details: "Has a getParameter(String)  method " */
      TestResult tr14 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASGETPARAMETER);
      {
         String name = "getParameter";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class};
         tr14.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasGetParameterReturns */
      /* Details: "Method getParameter(String) returns String " */
      TestResult tr15 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASGETPARAMETERRETURNS);
      {
         String name = "getParameter";
         Class<?> retType = String.class;
         Class<?>[] parms = {String.class};
         tr15.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasGetParameterMap */
      /* Details: "Has a getParameterMap()  method " */
      TestResult tr16 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASGETPARAMETERMAP);
      {
         String name = "getParameterMap";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr16.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasGetParameterMapReturns */
      /* Details: "Method getParameterMap() returns java.util.Map " */
      TestResult tr17 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASGETPARAMETERMAPRETURNS);
      {
         String name = "getParameterMap";
         Class<?> retType = java.util.Map.class;
         Class<?>[] parms = null;
         tr17.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasGetParameterNames */
      /* Details: "Has a getParameterNames()  method " */
      TestResult tr18 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASGETPARAMETERNAMES);
      {
         String name = "getParameterNames";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr18.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasGetParameterNamesReturns */
      /* Details: "Method getParameterNames() returns java.util.Enumeration " */
      TestResult tr19 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASGETPARAMETERNAMESRETURNS);
      {
         String name = "getParameterNames";
         Class<?> retType = java.util.Enumeration.class;
         Class<?>[] parms = null;
         tr19.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasGetParameterValues */
      /* Details: "Has a getParameterValues(String)  method " */
      TestResult tr20 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASGETPARAMETERVALUES);
      {
         String name = "getParameterValues";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class};
         tr20.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasGetParameterValuesReturns */
      /* Details: "Method getParameterValues(String) returns String[] " */
      TestResult tr21 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASGETPARAMETERVALUESRETURNS);
      {
         String name = "getParameterValues";
         Class<?> retType = String[].class;
         Class<?>[] parms = {String.class};
         tr21.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasGetPortalContext */
      /* Details: "Has a getPortalContext()  method " */
      TestResult tr22 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASGETPORTALCONTEXT);
      {
         String name = "getPortalContext";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr22.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasGetPortalContextReturns */
      /* Details: "Method getPortalContext() returns PortalContext " */
      TestResult tr23 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASGETPORTALCONTEXTRETURNS);
      {
         String name = "getPortalContext";
         Class<?> retType = PortalContext.class;
         Class<?>[] parms = null;
         tr23.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasGetPortletMode */
      /* Details: "Has a getPortletMode()  method " */
      TestResult tr24 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASGETPORTLETMODE);
      {
         String name = "getPortletMode";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr24.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasGetPortletModeReturns */
      /* Details: "Method getPortletMode() returns PortletMode " */
      TestResult tr25 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASGETPORTLETMODERETURNS);
      {
         String name = "getPortletMode";
         Class<?> retType = PortletMode.class;
         Class<?>[] parms = null;
         tr25.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasGetPortletSession */
      /* Details: "Has a getPortletSession()  method " */
      TestResult tr26 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASGETPORTLETSESSION);
      {
         String name = "getPortletSession";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr26.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasGetPortletSessionReturns */
      /* Details: "Method getPortletSession() returns PortletSession " */
      TestResult tr27 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASGETPORTLETSESSIONRETURNS);
      {
         String name = "getPortletSession";
         Class<?> retType = PortletSession.class;
         Class<?>[] parms = null;
         tr27.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasGetPortletSessionA */
      /* Details: "Has a getPortletSession(boolean)  method " */
      TestResult tr28 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASGETPORTLETSESSIONA);
      {
         String name = "getPortletSession";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {boolean.class};
         tr28.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasGetPortletSessionReturnsA */
      /* Details: "Method getPortletSession(boolean) returns PortletSession " */
      TestResult tr29 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASGETPORTLETSESSIONRETURNSA);
      {
         String name = "getPortletSession";
         Class<?> retType = PortletSession.class;
         Class<?>[] parms = {boolean.class};
         tr29.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasGetPreferences */
      /* Details: "Has a getPreferences()  method " */
      TestResult tr30 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASGETPREFERENCES);
      {
         String name = "getPreferences";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr30.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasGetPreferencesReturns */
      /* Details: "Method getPreferences() returns PortletPreferences " */
      TestResult tr31 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASGETPREFERENCESRETURNS);
      {
         String name = "getPreferences";
         Class<?> retType = PortletPreferences.class;
         Class<?>[] parms = null;
         tr31.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasGetProperties */
      /* Details: "Has a getProperties(String)  method " */
      TestResult tr32 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASGETPROPERTIES);
      {
         String name = "getProperties";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class};
         tr32.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasGetPropertiesReturns */
      /* Details: "Method getProperties(String) returns java.util.Enumeration " */
      TestResult tr33 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASGETPROPERTIESRETURNS);
      {
         String name = "getProperties";
         Class<?> retType = java.util.Enumeration.class;
         Class<?>[] parms = {String.class};
         tr33.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasGetProperty */
      /* Details: "Has a getProperty(String)  method " */
      TestResult tr34 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASGETPROPERTY);
      {
         String name = "getProperty";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class};
         tr34.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasGetPropertyReturns */
      /* Details: "Method getProperty(String) returns String " */
      TestResult tr35 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASGETPROPERTYRETURNS);
      {
         String name = "getProperty";
         Class<?> retType = String.class;
         Class<?>[] parms = {String.class};
         tr35.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasGetPropertyNames */
      /* Details: "Has a getPropertyNames()  method " */
      TestResult tr36 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASGETPROPERTYNAMES);
      {
         String name = "getPropertyNames";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr36.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasGetPropertyNamesReturns */
      /* Details: "Method getPropertyNames() returns java.util.Enumeration " */
      TestResult tr37 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASGETPROPERTYNAMESRETURNS);
      {
         String name = "getPropertyNames";
         Class<?> retType = java.util.Enumeration.class;
         Class<?>[] parms = null;
         tr37.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasGetRemoteUser */
      /* Details: "Has a getRemoteUser()  method " */
      TestResult tr38 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASGETREMOTEUSER);
      {
         String name = "getRemoteUser";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr38.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasGetRemoteUserReturns */
      /* Details: "Method getRemoteUser() returns String " */
      TestResult tr39 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASGETREMOTEUSERRETURNS);
      {
         String name = "getRemoteUser";
         Class<?> retType = String.class;
         Class<?>[] parms = null;
         tr39.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasGetRequestedSessionId */
      /* Details: "Has a getRequestedSessionId()  method " */
      TestResult tr40 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASGETREQUESTEDSESSIONID);
      {
         String name = "getRequestedSessionId";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr40.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasGetRequestedSessionIdReturns */
      /* Details: "Method getRequestedSessionId() returns String " */
      TestResult tr41 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASGETREQUESTEDSESSIONIDRETURNS);
      {
         String name = "getRequestedSessionId";
         Class<?> retType = String.class;
         Class<?>[] parms = null;
         tr41.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasGetResponseContentType */
      /* Details: "Has a getResponseContentType()  method " */
      TestResult tr42 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASGETRESPONSECONTENTTYPE);
      {
         String name = "getResponseContentType";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr42.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasGetResponseContentTypeReturns */
      /* Details: "Method getResponseContentType() returns String " */
      TestResult tr43 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASGETRESPONSECONTENTTYPERETURNS);
      {
         String name = "getResponseContentType";
         Class<?> retType = String.class;
         Class<?>[] parms = null;
         tr43.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasGetResponseContentTypes */
      /* Details: "Has a getResponseContentTypes()  method " */
      TestResult tr44 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASGETRESPONSECONTENTTYPES);
      {
         String name = "getResponseContentTypes";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr44.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasGetResponseContentTypesReturns */
      /* Details: "Method getResponseContentTypes() returns java.util.Enumeration " */
      TestResult tr45 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASGETRESPONSECONTENTTYPESRETURNS);
      {
         String name = "getResponseContentTypes";
         Class<?> retType = java.util.Enumeration.class;
         Class<?>[] parms = null;
         tr45.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasGetScheme */
      /* Details: "Has a getScheme()  method " */
      TestResult tr46 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASGETSCHEME);
      {
         String name = "getScheme";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr46.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasGetSchemeReturns */
      /* Details: "Method getScheme() returns String " */
      TestResult tr47 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASGETSCHEMERETURNS);
      {
         String name = "getScheme";
         Class<?> retType = String.class;
         Class<?>[] parms = null;
         tr47.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasGetServerName */
      /* Details: "Has a getServerName()  method " */
      TestResult tr48 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASGETSERVERNAME);
      {
         String name = "getServerName";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr48.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasGetServerNameReturns */
      /* Details: "Method getServerName() returns String " */
      TestResult tr49 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASGETSERVERNAMERETURNS);
      {
         String name = "getServerName";
         Class<?> retType = String.class;
         Class<?>[] parms = null;
         tr49.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasGetServerPort */
      /* Details: "Has a getServerPort()  method " */
      TestResult tr50 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASGETSERVERPORT);
      {
         String name = "getServerPort";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr50.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasGetServerPortReturns */
      /* Details: "Method getServerPort() returns int " */
      TestResult tr51 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASGETSERVERPORTRETURNS);
      {
         String name = "getServerPort";
         Class<?> retType = int.class;
         Class<?>[] parms = null;
         tr51.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasGetUserPrincipal */
      /* Details: "Has a getUserPrincipal()  method " */
      TestResult tr52 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASGETUSERPRINCIPAL);
      {
         String name = "getUserPrincipal";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr52.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasGetUserPrincipalReturns */
      /* Details: "Method getUserPrincipal() returns java.security.Principal " */
      TestResult tr53 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASGETUSERPRINCIPALRETURNS);
      {
         String name = "getUserPrincipal";
         Class<?> retType = java.security.Principal.class;
         Class<?>[] parms = null;
         tr53.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasGetWindowID */
      /* Details: "Has a getWindowID()  method " */
      TestResult tr54 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASGETWINDOWID);
      {
         String name = "getWindowID";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr54.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasGetWindowIDReturns */
      /* Details: "Method getWindowID() returns String " */
      TestResult tr55 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASGETWINDOWIDRETURNS);
      {
         String name = "getWindowID";
         Class<?> retType = String.class;
         Class<?>[] parms = null;
         tr55.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasGetWindowState */
      /* Details: "Has a getWindowState()  method " */
      TestResult tr56 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASGETWINDOWSTATE);
      {
         String name = "getWindowState";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr56.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasGetWindowStateReturns */
      /* Details: "Method getWindowState() returns WindowState " */
      TestResult tr57 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASGETWINDOWSTATERETURNS);
      {
         String name = "getWindowState";
         Class<?> retType = WindowState.class;
         Class<?>[] parms = null;
         tr57.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasIsPortletModeAllowed */
      /* Details: "Has a isPortletModeAllowed(PortletMode)  method " */
      TestResult tr58 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASISPORTLETMODEALLOWED);
      {
         String name = "isPortletModeAllowed";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {PortletMode.class};
         tr58.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasIsPortletModeAllowedReturns */
      /* Details: "Method isPortletModeAllowed(PortletMode) returns boolean " */
      TestResult tr59 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASISPORTLETMODEALLOWEDRETURNS);
      {
         String name = "isPortletModeAllowed";
         Class<?> retType = boolean.class;
         Class<?>[] parms = {PortletMode.class};
         tr59.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasIsRequestedSessionIdValid */
      /* Details: "Has a isRequestedSessionIdValid()  method " */
      TestResult tr60 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASISREQUESTEDSESSIONIDVALID);
      {
         String name = "isRequestedSessionIdValid";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr60.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasIsRequestedSessionIdValidReturns */
      /* Details: "Method isRequestedSessionIdValid() returns boolean " */
      TestResult tr61 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASISREQUESTEDSESSIONIDVALIDRETURNS);
      {
         String name = "isRequestedSessionIdValid";
         Class<?> retType = boolean.class;
         Class<?>[] parms = null;
         tr61.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasIsSecure */
      /* Details: "Has a isSecure()  method " */
      TestResult tr62 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASISSECURE);
      {
         String name = "isSecure";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr62.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasIsSecureReturns */
      /* Details: "Method isSecure() returns boolean " */
      TestResult tr63 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASISSECURERETURNS);
      {
         String name = "isSecure";
         Class<?> retType = boolean.class;
         Class<?>[] parms = null;
         tr63.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasIsUserInRole */
      /* Details: "Has a isUserInRole(String)  method " */
      TestResult tr64 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASISUSERINROLE);
      {
         String name = "isUserInRole";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class};
         tr64.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasIsUserInRoleReturns */
      /* Details: "Method isUserInRole(String) returns boolean " */
      TestResult tr65 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASISUSERINROLERETURNS);
      {
         String name = "isUserInRole";
         Class<?> retType = boolean.class;
         Class<?>[] parms = {String.class};
         tr65.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasIsWindowStateAllowed */
      /* Details: "Has a isWindowStateAllowed(WindowState)  method " */
      TestResult tr66 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASISWINDOWSTATEALLOWED);
      {
         String name = "isWindowStateAllowed";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {WindowState.class};
         tr66.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasIsWindowStateAllowedReturns */
      /* Details: "Method isWindowStateAllowed(WindowState) returns boolean " */
      TestResult tr67 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASISWINDOWSTATEALLOWEDRETURNS);
      {
         String name = "isWindowStateAllowed";
         Class<?> retType = boolean.class;
         Class<?>[] parms = {WindowState.class};
         tr67.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasRemoveAttribute */
      /* Details: "Has a removeAttribute(String)  method " */
      TestResult tr68 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASREMOVEATTRIBUTE);
      {
         String name = "removeAttribute";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class};
         tr68.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasRemoveAttributeReturns */
      /* Details: "Method removeAttribute(String) returns void " */
      TestResult tr69 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASREMOVEATTRIBUTERETURNS);
      {
         String name = "removeAttribute";
         Class<?> retType = void.class;
         Class<?>[] parms = {String.class};
         tr69.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasSetAttribute */
      /* Details: "Has a setAttribute(String, Object)  method " */
      TestResult tr70 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASSETATTRIBUTE);
      {
         String name = "setAttribute";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class, Object.class};
         tr70.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasSetAttributeReturns */
      /* Details: "Method setAttribute(String, Object) returns void " */
      TestResult tr71 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASSETATTRIBUTERETURNS);
      {
         String name = "setAttribute";
         Class<?> retType = void.class;
         Class<?>[] parms = {String.class, Object.class};
         tr71.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasGetRequest */
      /* Details: "Has a getRequest()  method " */
      TestResult tr72 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASGETREQUEST);
      {
         String name = "getRequest";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr72.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasGetRequestReturns */
      /* Details: "Method getRequest() returns PortletRequest " */
      TestResult tr73 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASGETREQUESTRETURNS);
      {
         String name = "getRequest";
         Class<?> retType = PortletRequest.class;
         Class<?>[] parms = null;
         tr73.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasSetRequest */
      /* Details: "Has a setRequest(PortletRequest)  method " */
      TestResult tr74 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASSETREQUEST);
      {
         String name = "setRequest";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {PortletRequest.class};
         tr74.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasSetRequestReturns */
      /* Details: "Method setRequest(PortletRequest) returns void " */
      TestResult tr75 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASSETREQUESTRETURNS);
      {
         String name = "setRequest";
         Class<?> retType = void.class;
         Class<?>[] parms = {PortletRequest.class};
         tr75.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasGetCookies */
      /* Details: "Has a getCookies()  method " */
      TestResult tr76 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASGETCOOKIES);
      {
         String name = "getCookies";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr76.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasGetCookiesReturns */
      /* Details: "Method getCookies() returns javax.servlet.http.Cookie[] " */
      TestResult tr77 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASGETCOOKIESRETURNS);
      {
         String name = "getCookies";
         Class<?> retType = javax.servlet.http.Cookie[].class;
         Class<?>[] parms = null;
         tr77.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasGetPrivateParameterMap */
      /* Details: "Has a getPrivateParameterMap()  method " */
      TestResult tr78 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASGETPRIVATEPARAMETERMAP);
      {
         String name = "getPrivateParameterMap";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr78.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasGetPrivateParameterMapReturns */
      /* Details: "Method getPrivateParameterMap() returns java.util.Map " */
      TestResult tr79 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASGETPRIVATEPARAMETERMAPRETURNS);
      {
         String name = "getPrivateParameterMap";
         Class<?> retType = java.util.Map.class;
         Class<?>[] parms = null;
         tr79.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasGetPublicParameterMap */
      /* Details: "Has a getPublicParameterMap()  method " */
      TestResult tr80 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASGETPUBLICPARAMETERMAP);
      {
         String name = "getPublicParameterMap";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr80.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletRequestWrapper_SIG_hasGetPublicParameterMapReturns */
      /* Details: "Method getPublicParameterMap() returns java.util.Map " */
      TestResult tr81 = tcd.getTestResultFailed(PORTLETREQUESTWRAPPER_SIG_HASGETPUBLICPARAMETERMAPRETURNS);
      {
         String name = "getPublicParameterMap";
         Class<?> retType = java.util.Map.class;
         Class<?>[] parms = null;
         tr81.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
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


   }

}

