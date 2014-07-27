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

package javax.portlet.tck.PortletTests.portlets;

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
public class V2PortletTests_SIG_PortletConfig implements Portlet {
   private static final String LOG_CLASS = 
         V2PortletTests_SIG_PortletConfig.class.getName();
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
      ClassChecker cc = new ClassChecker(portletConfig.getClass());

      // Create result objects for the tests

      /* TestCase: PortletConfig_SIG_hasGetPortletName */
      /* Details: "Has a getPortletName()  method " */
      TestResult tr0 = tcd.getTestResultFailed(PORTLETCONFIG_SIG_HASGETPORTLETNAME);
      {
         String name = "getPortletName";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr0.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletConfig_SIG_hasGetPortletNameReturns */
      /* Details: "Method getPortletName() returns String " */
      TestResult tr1 = tcd.getTestResultFailed(PORTLETCONFIG_SIG_HASGETPORTLETNAMERETURNS);
      {
         String name = "getPortletName";
         Class<?> retType = String.class;
         Class<?>[] parms = null;
         tr1.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletConfig_SIG_hasGetPortletContext */
      /* Details: "Has a getPortletContext()  method " */
      TestResult tr2 = tcd.getTestResultFailed(PORTLETCONFIG_SIG_HASGETPORTLETCONTEXT);
      {
         String name = "getPortletContext";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr2.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletConfig_SIG_hasGetPortletContextReturns */
      /* Details: "Method getPortletContext() returns PortletContext " */
      TestResult tr3 = tcd.getTestResultFailed(PORTLETCONFIG_SIG_HASGETPORTLETCONTEXTRETURNS);
      {
         String name = "getPortletContext";
         Class<?> retType = PortletContext.class;
         Class<?>[] parms = null;
         tr3.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletConfig_SIG_hasGetResourceBundle */
      /* Details: "Has a getResourceBundle(java.util.Locale)  method " */
      TestResult tr4 = tcd.getTestResultFailed(PORTLETCONFIG_SIG_HASGETRESOURCEBUNDLE);
      {
         String name = "getResourceBundle";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {java.util.Locale.class};
         tr4.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletConfig_SIG_hasGetResourceBundleReturns */
      /* Details: "Method getResourceBundle(java.util.Locale) returns java.util.ResourceBundle " */
      TestResult tr5 = tcd.getTestResultFailed(PORTLETCONFIG_SIG_HASGETRESOURCEBUNDLERETURNS);
      {
         String name = "getResourceBundle";
         Class<?> retType = java.util.ResourceBundle.class;
         Class<?>[] parms = {java.util.Locale.class};
         tr5.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletConfig_SIG_hasGetInitParameter */
      /* Details: "Has a getInitParameter(String)  method " */
      TestResult tr6 = tcd.getTestResultFailed(PORTLETCONFIG_SIG_HASGETINITPARAMETER);
      {
         String name = "getInitParameter";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class};
         tr6.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletConfig_SIG_hasGetInitParameterReturns */
      /* Details: "Method getInitParameter(String) returns String " */
      TestResult tr7 = tcd.getTestResultFailed(PORTLETCONFIG_SIG_HASGETINITPARAMETERRETURNS);
      {
         String name = "getInitParameter";
         Class<?> retType = String.class;
         Class<?>[] parms = {String.class};
         tr7.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletConfig_SIG_hasGetInitParameterNames */
      /* Details: "Has a getInitParameterNames()  method " */
      TestResult tr8 = tcd.getTestResultFailed(PORTLETCONFIG_SIG_HASGETINITPARAMETERNAMES);
      {
         String name = "getInitParameterNames";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr8.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletConfig_SIG_hasGetInitParameterNamesReturns */
      /* Details: "Method getInitParameterNames() returns java.util.Enumeration " */
      TestResult tr9 = tcd.getTestResultFailed(PORTLETCONFIG_SIG_HASGETINITPARAMETERNAMESRETURNS);
      {
         String name = "getInitParameterNames";
         Class<?> retType = java.util.Enumeration.class;
         Class<?>[] parms = null;
         tr9.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletConfig_SIG_hasGetPublicRenderParameterNames */
      /* Details: "Has a getPublicRenderParameterNames()  method " */
      TestResult tr10 = tcd.getTestResultFailed(PORTLETCONFIG_SIG_HASGETPUBLICRENDERPARAMETERNAMES);
      {
         String name = "getPublicRenderParameterNames";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr10.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletConfig_SIG_hasGetPublicRenderParameterNamesReturns */
      /* Details: "Method getPublicRenderParameterNames() returns java.util.Enumeration " */
      TestResult tr11 = tcd.getTestResultFailed(PORTLETCONFIG_SIG_HASGETPUBLICRENDERPARAMETERNAMESRETURNS);
      {
         String name = "getPublicRenderParameterNames";
         Class<?> retType = java.util.Enumeration.class;
         Class<?>[] parms = null;
         tr11.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletConfig_SIG_hasGetDefaultNamespace */
      /* Details: "Has a getDefaultNamespace()  method " */
      TestResult tr12 = tcd.getTestResultFailed(PORTLETCONFIG_SIG_HASGETDEFAULTNAMESPACE);
      {
         String name = "getDefaultNamespace";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr12.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletConfig_SIG_hasGetDefaultNamespaceReturns */
      /* Details: "Method getDefaultNamespace() returns String " */
      TestResult tr13 = tcd.getTestResultFailed(PORTLETCONFIG_SIG_HASGETDEFAULTNAMESPACERETURNS);
      {
         String name = "getDefaultNamespace";
         Class<?> retType = String.class;
         Class<?>[] parms = null;
         tr13.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletConfig_SIG_hasGetPublishingEventQNames */
      /* Details: "Has a getPublishingEventQNames()  method " */
      TestResult tr14 = tcd.getTestResultFailed(PORTLETCONFIG_SIG_HASGETPUBLISHINGEVENTQNAMES);
      {
         String name = "getPublishingEventQNames";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr14.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletConfig_SIG_hasGetPublishingEventQNamesReturns */
      /* Details: "Method getPublishingEventQNames() returns java.util.Enumeration " */
      TestResult tr15 = tcd.getTestResultFailed(PORTLETCONFIG_SIG_HASGETPUBLISHINGEVENTQNAMESRETURNS);
      {
         String name = "getPublishingEventQNames";
         Class<?> retType = java.util.Enumeration.class;
         Class<?>[] parms = null;
         tr15.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletConfig_SIG_hasGetProcessingEventQNames */
      /* Details: "Has a getProcessingEventQNames()  method " */
      TestResult tr16 = tcd.getTestResultFailed(PORTLETCONFIG_SIG_HASGETPROCESSINGEVENTQNAMES);
      {
         String name = "getProcessingEventQNames";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr16.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletConfig_SIG_hasGetProcessingEventQNamesReturns */
      /* Details: "Method getProcessingEventQNames() returns java.util.Enumeration " */
      TestResult tr17 = tcd.getTestResultFailed(PORTLETCONFIG_SIG_HASGETPROCESSINGEVENTQNAMESRETURNS);
      {
         String name = "getProcessingEventQNames";
         Class<?> retType = java.util.Enumeration.class;
         Class<?>[] parms = null;
         tr17.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletConfig_SIG_hasGetSupportedLocales */
      /* Details: "Has a getSupportedLocales()  method " */
      TestResult tr18 = tcd.getTestResultFailed(PORTLETCONFIG_SIG_HASGETSUPPORTEDLOCALES);
      {
         String name = "getSupportedLocales";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr18.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletConfig_SIG_hasGetSupportedLocalesReturns */
      /* Details: "Method getSupportedLocales() returns java.util.Enumeration " */
      TestResult tr19 = tcd.getTestResultFailed(PORTLETCONFIG_SIG_HASGETSUPPORTEDLOCALESRETURNS);
      {
         String name = "getSupportedLocales";
         Class<?> retType = java.util.Enumeration.class;
         Class<?>[] parms = null;
         tr19.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletConfig_SIG_hasGetContainerRuntimeOptions */
      /* Details: "Has a getContainerRuntimeOptions()  method " */
      TestResult tr20 = tcd.getTestResultFailed(PORTLETCONFIG_SIG_HASGETCONTAINERRUNTIMEOPTIONS);
      {
         String name = "getContainerRuntimeOptions";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr20.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletConfig_SIG_hasGetContainerRuntimeOptionsReturns */
      /* Details: "Method getContainerRuntimeOptions() returns java.util.Map " */
      TestResult tr21 = tcd.getTestResultFailed(PORTLETCONFIG_SIG_HASGETCONTAINERRUNTIMEOPTIONSRETURNS);
      {
         String name = "getContainerRuntimeOptions";
         Class<?> retType = java.util.Map.class;
         Class<?>[] parms = null;
         tr21.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
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


   }

}

