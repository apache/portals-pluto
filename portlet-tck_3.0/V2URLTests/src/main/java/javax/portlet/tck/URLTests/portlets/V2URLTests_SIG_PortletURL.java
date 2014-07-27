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
public class V2URLTests_SIG_PortletURL implements Portlet {
   private static final String LOG_CLASS = 
         V2URLTests_SIG_PortletURL.class.getName();
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

      /* TestCase: PortletURL_SIG_implementsBaseURL */
      /* Details: "Implements BaseURL " */
      TestResult tr0 = tcd.getTestResultFailed(PORTLETURL_SIG_IMPLEMENTSBASEURL);
      {
         tr0.setTcSuccess(cc.implementsInterface(BaseURL.class));
      }

      /* TestCase: PortletURL_SIG_hasSetWindowState */
      /* Details: "Has a setWindowState(WindowState) throws WindowStateException method " */
      TestResult tr1 = tcd.getTestResultFailed(PORTLETURL_SIG_HASSETWINDOWSTATE);
      {
         String name = "setWindowState";
         Class<?>[] exceptions = {WindowStateException.class};
         Class<?>[] parms = {WindowState.class};
         tr1.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletURL_SIG_hasSetWindowStateReturns */
      /* Details: "Method setWindowState(WindowState) returns void " */
      TestResult tr2 = tcd.getTestResultFailed(PORTLETURL_SIG_HASSETWINDOWSTATERETURNS);
      {
         String name = "setWindowState";
         Class<?> retType = void.class;
         Class<?>[] parms = {WindowState.class};
         tr2.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletURL_SIG_hasSetPortletMode */
      /* Details: "Has a setPortletMode(PortletMode) throws PortletModeException method " */
      TestResult tr3 = tcd.getTestResultFailed(PORTLETURL_SIG_HASSETPORTLETMODE);
      {
         String name = "setPortletMode";
         Class<?>[] exceptions = {PortletModeException.class};
         Class<?>[] parms = {PortletMode.class};
         tr3.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletURL_SIG_hasSetPortletModeReturns */
      /* Details: "Method setPortletMode(PortletMode) returns void " */
      TestResult tr4 = tcd.getTestResultFailed(PORTLETURL_SIG_HASSETPORTLETMODERETURNS);
      {
         String name = "setPortletMode";
         Class<?> retType = void.class;
         Class<?>[] parms = {PortletMode.class};
         tr4.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletURL_SIG_hasGetPortletMode */
      /* Details: "Has a getPortletMode()  method " */
      TestResult tr5 = tcd.getTestResultFailed(PORTLETURL_SIG_HASGETPORTLETMODE);
      {
         String name = "getPortletMode";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr5.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletURL_SIG_hasGetPortletModeReturns */
      /* Details: "Method getPortletMode() returns PortletMode " */
      TestResult tr6 = tcd.getTestResultFailed(PORTLETURL_SIG_HASGETPORTLETMODERETURNS);
      {
         String name = "getPortletMode";
         Class<?> retType = PortletMode.class;
         Class<?>[] parms = null;
         tr6.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletURL_SIG_hasGetWindowState */
      /* Details: "Has a getWindowState()  method " */
      TestResult tr7 = tcd.getTestResultFailed(PORTLETURL_SIG_HASGETWINDOWSTATE);
      {
         String name = "getWindowState";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr7.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletURL_SIG_hasGetWindowStateReturns */
      /* Details: "Method getWindowState() returns WindowState " */
      TestResult tr8 = tcd.getTestResultFailed(PORTLETURL_SIG_HASGETWINDOWSTATERETURNS);
      {
         String name = "getWindowState";
         Class<?> retType = WindowState.class;
         Class<?>[] parms = null;
         tr8.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletURL_SIG_hasRemovePublicRenderParameter */
      /* Details: "Has a removePublicRenderParameter(String)  method " */
      TestResult tr9 = tcd.getTestResultFailed(PORTLETURL_SIG_HASREMOVEPUBLICRENDERPARAMETER);
      {
         String name = "removePublicRenderParameter";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class};
         tr9.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletURL_SIG_hasRemovePublicRenderParameterReturns */
      /* Details: "Method removePublicRenderParameter(String) returns void " */
      TestResult tr10 = tcd.getTestResultFailed(PORTLETURL_SIG_HASREMOVEPUBLICRENDERPARAMETERRETURNS);
      {
         String name = "removePublicRenderParameter";
         Class<?> retType = void.class;
         Class<?>[] parms = {String.class};
         tr10.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
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


   }

}

