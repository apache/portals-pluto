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

package javax.portlet.tck.ResponseTests.portlets;

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
public class V2ResponseTests_SIG_StateAwareResponse implements Portlet {
   private static final String LOG_CLASS = 
         V2ResponseTests_SIG_StateAwareResponse.class.getName();
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
      ClassChecker cc = new ClassChecker(ActionResponseWrapper.class);

      // Create result objects for the tests

      /* TestCase: StateAwareResponse_SIG_implementsPortletResponse */
      /* Details: "Implements PortletResponse " */
      TestResult tr0 = tcd.getTestResultFailed(STATEAWARERESPONSE_SIG_IMPLEMENTSPORTLETRESPONSE);
      {
         tr0.setTcSuccess(cc.implementsInterface(PortletResponse.class));
      }

      /* TestCase: StateAwareResponse_SIG_hasSetWindowState */
      /* Details: "Has a setWindowState(WindowState) throws WindowStateException method " */
      TestResult tr1 = tcd.getTestResultFailed(STATEAWARERESPONSE_SIG_HASSETWINDOWSTATE);
      {
         String name = "setWindowState";
         Class<?>[] exceptions = {WindowStateException.class};
         Class<?>[] parms = {WindowState.class};
         tr1.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: StateAwareResponse_SIG_hasSetWindowStateReturns */
      /* Details: "Method setWindowState(WindowState) returns void " */
      TestResult tr2 = tcd.getTestResultFailed(STATEAWARERESPONSE_SIG_HASSETWINDOWSTATERETURNS);
      {
         String name = "setWindowState";
         Class<?> retType = void.class;
         Class<?>[] parms = {WindowState.class};
         tr2.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: StateAwareResponse_SIG_hasSetPortletMode */
      /* Details: "Has a setPortletMode(PortletMode) throws PortletModeException method " */
      TestResult tr3 = tcd.getTestResultFailed(STATEAWARERESPONSE_SIG_HASSETPORTLETMODE);
      {
         String name = "setPortletMode";
         Class<?>[] exceptions = {PortletModeException.class};
         Class<?>[] parms = {PortletMode.class};
         tr3.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: StateAwareResponse_SIG_hasSetPortletModeReturns */
      /* Details: "Method setPortletMode(PortletMode) returns void " */
      TestResult tr4 = tcd.getTestResultFailed(STATEAWARERESPONSE_SIG_HASSETPORTLETMODERETURNS);
      {
         String name = "setPortletMode";
         Class<?> retType = void.class;
         Class<?>[] parms = {PortletMode.class};
         tr4.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: StateAwareResponse_SIG_hasSetRenderParameters */
      /* Details: "Has a setRenderParameters(java.util.Map)  method " */
      TestResult tr5 = tcd.getTestResultFailed(STATEAWARERESPONSE_SIG_HASSETRENDERPARAMETERS);
      {
         String name = "setRenderParameters";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {java.util.Map.class};
         tr5.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: StateAwareResponse_SIG_hasSetRenderParametersReturns */
      /* Details: "Method setRenderParameters(java.util.Map) returns void " */
      TestResult tr6 = tcd.getTestResultFailed(STATEAWARERESPONSE_SIG_HASSETRENDERPARAMETERSRETURNS);
      {
         String name = "setRenderParameters";
         Class<?> retType = void.class;
         Class<?>[] parms = {java.util.Map.class};
         tr6.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: StateAwareResponse_SIG_hasSetRenderParameter */
      /* Details: "Has a setRenderParameter(String, String)  method " */
      TestResult tr7 = tcd.getTestResultFailed(STATEAWARERESPONSE_SIG_HASSETRENDERPARAMETER);
      {
         String name = "setRenderParameter";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class, String.class};
         tr7.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: StateAwareResponse_SIG_hasSetRenderParameterReturns */
      /* Details: "Method setRenderParameter(String, String) returns void " */
      TestResult tr8 = tcd.getTestResultFailed(STATEAWARERESPONSE_SIG_HASSETRENDERPARAMETERRETURNS);
      {
         String name = "setRenderParameter";
         Class<?> retType = void.class;
         Class<?>[] parms = {String.class, String.class};
         tr8.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: StateAwareResponse_SIG_hasSetRenderParameterA */
      /* Details: "Has a setRenderParameter(String, String[])  method " */
      TestResult tr9 = tcd.getTestResultFailed(STATEAWARERESPONSE_SIG_HASSETRENDERPARAMETERA);
      {
         String name = "setRenderParameter";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class, String[].class};
         tr9.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: StateAwareResponse_SIG_hasSetRenderParameterReturnsA */
      /* Details: "Method setRenderParameter(String, String[]) returns void " */
      TestResult tr10 = tcd.getTestResultFailed(STATEAWARERESPONSE_SIG_HASSETRENDERPARAMETERRETURNSA);
      {
         String name = "setRenderParameter";
         Class<?> retType = void.class;
         Class<?>[] parms = {String.class, String[].class};
         tr10.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: StateAwareResponse_SIG_hasSetEvent */
      /* Details: "Has a setEvent(javax.xml.namespace.QName, java.io.Serializable)  method " */
      TestResult tr11 = tcd.getTestResultFailed(STATEAWARERESPONSE_SIG_HASSETEVENT);
      {
         String name = "setEvent";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {javax.xml.namespace.QName.class, java.io.Serializable.class};
         tr11.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: StateAwareResponse_SIG_hasSetEventReturns */
      /* Details: "Method setEvent(javax.xml.namespace.QName, java.io.Serializable) returns void " */
      TestResult tr12 = tcd.getTestResultFailed(STATEAWARERESPONSE_SIG_HASSETEVENTRETURNS);
      {
         String name = "setEvent";
         Class<?> retType = void.class;
         Class<?>[] parms = {javax.xml.namespace.QName.class, java.io.Serializable.class};
         tr12.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: StateAwareResponse_SIG_hasSetEventA */
      /* Details: "Has a setEvent(String, java.io.Serializable)  method " */
      TestResult tr13 = tcd.getTestResultFailed(STATEAWARERESPONSE_SIG_HASSETEVENTA);
      {
         String name = "setEvent";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class, java.io.Serializable.class};
         tr13.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: StateAwareResponse_SIG_hasSetEventReturnsA */
      /* Details: "Method setEvent(String, java.io.Serializable) returns void " */
      TestResult tr14 = tcd.getTestResultFailed(STATEAWARERESPONSE_SIG_HASSETEVENTRETURNSA);
      {
         String name = "setEvent";
         Class<?> retType = void.class;
         Class<?>[] parms = {String.class, java.io.Serializable.class};
         tr14.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: StateAwareResponse_SIG_hasGetRenderParameterMap */
      /* Details: "Has a getRenderParameterMap()  method " */
      TestResult tr15 = tcd.getTestResultFailed(STATEAWARERESPONSE_SIG_HASGETRENDERPARAMETERMAP);
      {
         String name = "getRenderParameterMap";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr15.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: StateAwareResponse_SIG_hasGetRenderParameterMapReturns */
      /* Details: "Method getRenderParameterMap() returns java.util.Map " */
      TestResult tr16 = tcd.getTestResultFailed(STATEAWARERESPONSE_SIG_HASGETRENDERPARAMETERMAPRETURNS);
      {
         String name = "getRenderParameterMap";
         Class<?> retType = java.util.Map.class;
         Class<?>[] parms = null;
         tr16.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: StateAwareResponse_SIG_hasGetPortletMode */
      /* Details: "Has a getPortletMode()  method " */
      TestResult tr17 = tcd.getTestResultFailed(STATEAWARERESPONSE_SIG_HASGETPORTLETMODE);
      {
         String name = "getPortletMode";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr17.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: StateAwareResponse_SIG_hasGetPortletModeReturns */
      /* Details: "Method getPortletMode() returns PortletMode " */
      TestResult tr18 = tcd.getTestResultFailed(STATEAWARERESPONSE_SIG_HASGETPORTLETMODERETURNS);
      {
         String name = "getPortletMode";
         Class<?> retType = PortletMode.class;
         Class<?>[] parms = null;
         tr18.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: StateAwareResponse_SIG_hasGetWindowState */
      /* Details: "Has a getWindowState()  method " */
      TestResult tr19 = tcd.getTestResultFailed(STATEAWARERESPONSE_SIG_HASGETWINDOWSTATE);
      {
         String name = "getWindowState";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr19.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: StateAwareResponse_SIG_hasGetWindowStateReturns */
      /* Details: "Method getWindowState() returns WindowState " */
      TestResult tr20 = tcd.getTestResultFailed(STATEAWARERESPONSE_SIG_HASGETWINDOWSTATERETURNS);
      {
         String name = "getWindowState";
         Class<?> retType = WindowState.class;
         Class<?>[] parms = null;
         tr20.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: StateAwareResponse_SIG_hasRemovePublicRenderParameter */
      /* Details: "Has a removePublicRenderParameter(String)  method " */
      TestResult tr21 = tcd.getTestResultFailed(STATEAWARERESPONSE_SIG_HASREMOVEPUBLICRENDERPARAMETER);
      {
         String name = "removePublicRenderParameter";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class};
         tr21.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: StateAwareResponse_SIG_hasRemovePublicRenderParameterReturns */
      /* Details: "Method removePublicRenderParameter(String) returns void " */
      TestResult tr22 = tcd.getTestResultFailed(STATEAWARERESPONSE_SIG_HASREMOVEPUBLICRENDERPARAMETERRETURNS);
      {
         String name = "removePublicRenderParameter";
         Class<?> retType = void.class;
         Class<?>[] parms = {String.class};
         tr22.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
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


   }

}

