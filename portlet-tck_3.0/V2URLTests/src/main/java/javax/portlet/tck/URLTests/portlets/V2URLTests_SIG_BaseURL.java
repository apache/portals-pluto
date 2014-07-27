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

package javax.portlet.tck.URLTests.portlets;

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
public class V2URLTests_SIG_BaseURL implements Portlet {
   private static final String LOG_CLASS = 
         V2URLTests_SIG_BaseURL.class.getName();
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
      ClassChecker cc = new ClassChecker(renderResponse.createRenderURL().getClass());

      // Create result objects for the tests

      /* TestCase: BaseURL_SIG_hasSetParameter */
      /* Details: "Has a setParameter(String, String)  method " */
      TestResult tr0 = tcd.getTestResultFailed(BASEURL_SIG_HASSETPARAMETER);
      {
         String name = "setParameter";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class, String.class};
         tr0.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: BaseURL_SIG_hasSetParameterReturns */
      /* Details: "Method setParameter(String, String) returns void " */
      TestResult tr1 = tcd.getTestResultFailed(BASEURL_SIG_HASSETPARAMETERRETURNS);
      {
         String name = "setParameter";
         Class<?> retType = void.class;
         Class<?>[] parms = {String.class, String.class};
         tr1.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: BaseURL_SIG_hasSetParameterA */
      /* Details: "Has a setParameter(String, String[])  method " */
      TestResult tr2 = tcd.getTestResultFailed(BASEURL_SIG_HASSETPARAMETERA);
      {
         String name = "setParameter";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class, String[].class};
         tr2.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: BaseURL_SIG_hasSetParameterReturnsA */
      /* Details: "Method setParameter(String, String[]) returns void " */
      TestResult tr3 = tcd.getTestResultFailed(BASEURL_SIG_HASSETPARAMETERRETURNSA);
      {
         String name = "setParameter";
         Class<?> retType = void.class;
         Class<?>[] parms = {String.class, String[].class};
         tr3.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: BaseURL_SIG_hasSetParameters */
      /* Details: "Has a setParameters(java.util.Map)  method " */
      TestResult tr4 = tcd.getTestResultFailed(BASEURL_SIG_HASSETPARAMETERS);
      {
         String name = "setParameters";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {java.util.Map.class};
         tr4.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: BaseURL_SIG_hasSetParametersReturns */
      /* Details: "Method setParameters(java.util.Map) returns void " */
      TestResult tr5 = tcd.getTestResultFailed(BASEURL_SIG_HASSETPARAMETERSRETURNS);
      {
         String name = "setParameters";
         Class<?> retType = void.class;
         Class<?>[] parms = {java.util.Map.class};
         tr5.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: BaseURL_SIG_hasSetSecure */
      /* Details: "Has a setSecure(boolean) throws PortletSecurityException method " */
      TestResult tr6 = tcd.getTestResultFailed(BASEURL_SIG_HASSETSECURE);
      {
         String name = "setSecure";
         Class<?>[] exceptions = {PortletSecurityException.class};
         Class<?>[] parms = {boolean.class};
         tr6.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: BaseURL_SIG_hasSetSecureReturns */
      /* Details: "Method setSecure(boolean) returns void " */
      TestResult tr7 = tcd.getTestResultFailed(BASEURL_SIG_HASSETSECURERETURNS);
      {
         String name = "setSecure";
         Class<?> retType = void.class;
         Class<?>[] parms = {boolean.class};
         tr7.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: BaseURL_SIG_hasToString */
      /* Details: "Has a toString()  method " */
      TestResult tr8 = tcd.getTestResultFailed(BASEURL_SIG_HASTOSTRING);
      {
         String name = "toString";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr8.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: BaseURL_SIG_hasToStringReturns */
      /* Details: "Method toString() returns String " */
      TestResult tr9 = tcd.getTestResultFailed(BASEURL_SIG_HASTOSTRINGRETURNS);
      {
         String name = "toString";
         Class<?> retType = String.class;
         Class<?>[] parms = null;
         tr9.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: BaseURL_SIG_hasGetParameterMap */
      /* Details: "Has a getParameterMap()  method " */
      TestResult tr10 = tcd.getTestResultFailed(BASEURL_SIG_HASGETPARAMETERMAP);
      {
         String name = "getParameterMap";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr10.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: BaseURL_SIG_hasGetParameterMapReturns */
      /* Details: "Method getParameterMap() returns java.util.Map " */
      TestResult tr11 = tcd.getTestResultFailed(BASEURL_SIG_HASGETPARAMETERMAPRETURNS);
      {
         String name = "getParameterMap";
         Class<?> retType = java.util.Map.class;
         Class<?>[] parms = null;
         tr11.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: BaseURL_SIG_hasWrite */
      /* Details: "Has a write(java.io.Writer) throws java.io.IOException method " */
      TestResult tr12 = tcd.getTestResultFailed(BASEURL_SIG_HASWRITE);
      {
         String name = "write";
         Class<?>[] exceptions = {java.io.IOException.class};
         Class<?>[] parms = {java.io.Writer.class};
         tr12.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: BaseURL_SIG_hasWriteReturns */
      /* Details: "Method write(java.io.Writer) returns void " */
      TestResult tr13 = tcd.getTestResultFailed(BASEURL_SIG_HASWRITERETURNS);
      {
         String name = "write";
         Class<?> retType = void.class;
         Class<?>[] parms = {java.io.Writer.class};
         tr13.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: BaseURL_SIG_hasWriteA */
      /* Details: "Has a write(java.io.Writer, boolean) throws java.io.IOException method " */
      TestResult tr14 = tcd.getTestResultFailed(BASEURL_SIG_HASWRITEA);
      {
         String name = "write";
         Class<?>[] exceptions = {java.io.IOException.class};
         Class<?>[] parms = {java.io.Writer.class, boolean.class};
         tr14.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: BaseURL_SIG_hasWriteReturnsA */
      /* Details: "Method write(java.io.Writer, boolean) returns void " */
      TestResult tr15 = tcd.getTestResultFailed(BASEURL_SIG_HASWRITERETURNSA);
      {
         String name = "write";
         Class<?> retType = void.class;
         Class<?>[] parms = {java.io.Writer.class, boolean.class};
         tr15.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: BaseURL_SIG_hasAddProperty */
      /* Details: "Has a addProperty(String, String)  method " */
      TestResult tr16 = tcd.getTestResultFailed(BASEURL_SIG_HASADDPROPERTY);
      {
         String name = "addProperty";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class, String.class};
         tr16.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: BaseURL_SIG_hasAddPropertyReturns */
      /* Details: "Method addProperty(String, String) returns void " */
      TestResult tr17 = tcd.getTestResultFailed(BASEURL_SIG_HASADDPROPERTYRETURNS);
      {
         String name = "addProperty";
         Class<?> retType = void.class;
         Class<?>[] parms = {String.class, String.class};
         tr17.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: BaseURL_SIG_hasSetProperty */
      /* Details: "Has a setProperty(String, String)  method " */
      TestResult tr18 = tcd.getTestResultFailed(BASEURL_SIG_HASSETPROPERTY);
      {
         String name = "setProperty";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class, String.class};
         tr18.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: BaseURL_SIG_hasSetPropertyReturns */
      /* Details: "Method setProperty(String, String) returns void " */
      TestResult tr19 = tcd.getTestResultFailed(BASEURL_SIG_HASSETPROPERTYRETURNS);
      {
         String name = "setProperty";
         Class<?> retType = void.class;
         Class<?>[] parms = {String.class, String.class};
         tr19.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
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


   }

}

