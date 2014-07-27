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
public class V2WrapperTests_SIG_ActionResponseWrapper implements Portlet {
   private static final String LOG_CLASS = 
         V2WrapperTests_SIG_ActionResponseWrapper.class.getName();
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

      /* TestCase: ActionResponseWrapper_SIG_extendsPortletResponseWrapper */
      /* Details: "Extends PortletResponseWrapper " */
      TestResult tr0 = tcd.getTestResultFailed(ACTIONRESPONSEWRAPPER_SIG_EXTENDSPORTLETRESPONSEWRAPPER);
      {
         tr0.setTcSuccess(cc.hasSuperclass(PortletResponseWrapper.class));
      }

      /* TestCase: ActionResponseWrapper_SIG_implementsActionResponse */
      /* Details: "Implements ActionResponse " */
      TestResult tr1 = tcd.getTestResultFailed(ACTIONRESPONSEWRAPPER_SIG_IMPLEMENTSACTIONRESPONSE);
      {
         tr1.setTcSuccess(cc.implementsInterface(ActionResponse.class));
      }

      /* TestCase: ActionResponseWrapper_SIG_constructor */
      /* Details: "Provides constructor ActionResponseWrapper(ActionResponse) " */
      TestResult tr2 = tcd.getTestResultFailed(ACTIONRESPONSEWRAPPER_SIG_CONSTRUCTOR);
      {
         Class<?>[] parms = {ActionResponse.class};
         tr2.setTcSuccess(cc.hasConstructor(parms));
      }

      /* TestCase: ActionResponseWrapper_SIG_hasSendRedirect */
      /* Details: "Has a sendRedirect(String) throws java.io.IOException method " */
      TestResult tr3 = tcd.getTestResultFailed(ACTIONRESPONSEWRAPPER_SIG_HASSENDREDIRECT);
      {
         String name = "sendRedirect";
         Class<?>[] exceptions = {java.io.IOException.class};
         Class<?>[] parms = {String.class};
         tr3.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: ActionResponseWrapper_SIG_hasSendRedirectReturns */
      /* Details: "Method sendRedirect(String) returns void " */
      TestResult tr4 = tcd.getTestResultFailed(ACTIONRESPONSEWRAPPER_SIG_HASSENDREDIRECTRETURNS);
      {
         String name = "sendRedirect";
         Class<?> retType = void.class;
         Class<?>[] parms = {String.class};
         tr4.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: ActionResponseWrapper_SIG_hasSendRedirectA */
      /* Details: "Has a sendRedirect(String, String) throws java.io.IOException method " */
      TestResult tr5 = tcd.getTestResultFailed(ACTIONRESPONSEWRAPPER_SIG_HASSENDREDIRECTA);
      {
         String name = "sendRedirect";
         Class<?>[] exceptions = {java.io.IOException.class};
         Class<?>[] parms = {String.class, String.class};
         tr5.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: ActionResponseWrapper_SIG_hasSendRedirectReturnsA */
      /* Details: "Method sendRedirect(String, String) returns void " */
      TestResult tr6 = tcd.getTestResultFailed(ACTIONRESPONSEWRAPPER_SIG_HASSENDREDIRECTRETURNSA);
      {
         String name = "sendRedirect";
         Class<?> retType = void.class;
         Class<?>[] parms = {String.class, String.class};
         tr6.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: ActionResponseWrapper_SIG_hasSetEvent */
      /* Details: "Has a setEvent(javax.xml.namespace.QName, java.io.Serializable)  method " */
      TestResult tr7 = tcd.getTestResultFailed(ACTIONRESPONSEWRAPPER_SIG_HASSETEVENT);
      {
         String name = "setEvent";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {javax.xml.namespace.QName.class, java.io.Serializable.class};
         tr7.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: ActionResponseWrapper_SIG_hasSetEventReturns */
      /* Details: "Method setEvent(javax.xml.namespace.QName, java.io.Serializable) returns void " */
      TestResult tr8 = tcd.getTestResultFailed(ACTIONRESPONSEWRAPPER_SIG_HASSETEVENTRETURNS);
      {
         String name = "setEvent";
         Class<?> retType = void.class;
         Class<?>[] parms = {javax.xml.namespace.QName.class, java.io.Serializable.class};
         tr8.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: ActionResponseWrapper_SIG_hasSetPortletMode */
      /* Details: "Has a setPortletMode(PortletMode) throws PortletModeException method " */
      TestResult tr9 = tcd.getTestResultFailed(ACTIONRESPONSEWRAPPER_SIG_HASSETPORTLETMODE);
      {
         String name = "setPortletMode";
         Class<?>[] exceptions = {PortletModeException.class};
         Class<?>[] parms = {PortletMode.class};
         tr9.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: ActionResponseWrapper_SIG_hasSetPortletModeReturns */
      /* Details: "Method setPortletMode(PortletMode) returns void " */
      TestResult tr10 = tcd.getTestResultFailed(ACTIONRESPONSEWRAPPER_SIG_HASSETPORTLETMODERETURNS);
      {
         String name = "setPortletMode";
         Class<?> retType = void.class;
         Class<?>[] parms = {PortletMode.class};
         tr10.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: ActionResponseWrapper_SIG_hasSetRenderParameter */
      /* Details: "Has a setRenderParameter(String, String)  method " */
      TestResult tr11 = tcd.getTestResultFailed(ACTIONRESPONSEWRAPPER_SIG_HASSETRENDERPARAMETER);
      {
         String name = "setRenderParameter";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class, String.class};
         tr11.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: ActionResponseWrapper_SIG_hasSetRenderParameterReturns */
      /* Details: "Method setRenderParameter(String, String) returns void " */
      TestResult tr12 = tcd.getTestResultFailed(ACTIONRESPONSEWRAPPER_SIG_HASSETRENDERPARAMETERRETURNS);
      {
         String name = "setRenderParameter";
         Class<?> retType = void.class;
         Class<?>[] parms = {String.class, String.class};
         tr12.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: ActionResponseWrapper_SIG_hasSetRenderParameterA */
      /* Details: "Has a setRenderParameter(String, String[])  method " */
      TestResult tr13 = tcd.getTestResultFailed(ACTIONRESPONSEWRAPPER_SIG_HASSETRENDERPARAMETERA);
      {
         String name = "setRenderParameter";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class, String[].class};
         tr13.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: ActionResponseWrapper_SIG_hasSetRenderParameterReturnsA */
      /* Details: "Method setRenderParameter(String, String[]) returns void " */
      TestResult tr14 = tcd.getTestResultFailed(ACTIONRESPONSEWRAPPER_SIG_HASSETRENDERPARAMETERRETURNSA);
      {
         String name = "setRenderParameter";
         Class<?> retType = void.class;
         Class<?>[] parms = {String.class, String[].class};
         tr14.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: ActionResponseWrapper_SIG_hasSetRenderParameters */
      /* Details: "Has a setRenderParameters(java.util.Map)  method " */
      TestResult tr15 = tcd.getTestResultFailed(ACTIONRESPONSEWRAPPER_SIG_HASSETRENDERPARAMETERS);
      {
         String name = "setRenderParameters";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {java.util.Map.class};
         tr15.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: ActionResponseWrapper_SIG_hasSetRenderParametersReturns */
      /* Details: "Method setRenderParameters(java.util.Map) returns void " */
      TestResult tr16 = tcd.getTestResultFailed(ACTIONRESPONSEWRAPPER_SIG_HASSETRENDERPARAMETERSRETURNS);
      {
         String name = "setRenderParameters";
         Class<?> retType = void.class;
         Class<?>[] parms = {java.util.Map.class};
         tr16.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: ActionResponseWrapper_SIG_hasSetWindowState */
      /* Details: "Has a setWindowState(WindowState) throws WindowStateException method " */
      TestResult tr17 = tcd.getTestResultFailed(ACTIONRESPONSEWRAPPER_SIG_HASSETWINDOWSTATE);
      {
         String name = "setWindowState";
         Class<?>[] exceptions = {WindowStateException.class};
         Class<?>[] parms = {WindowState.class};
         tr17.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: ActionResponseWrapper_SIG_hasSetWindowStateReturns */
      /* Details: "Method setWindowState(WindowState) returns void " */
      TestResult tr18 = tcd.getTestResultFailed(ACTIONRESPONSEWRAPPER_SIG_HASSETWINDOWSTATERETURNS);
      {
         String name = "setWindowState";
         Class<?> retType = void.class;
         Class<?>[] parms = {WindowState.class};
         tr18.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: ActionResponseWrapper_SIG_hasGetResponse */
      /* Details: "Has a getResponse()  method " */
      TestResult tr19 = tcd.getTestResultFailed(ACTIONRESPONSEWRAPPER_SIG_HASGETRESPONSE);
      {
         String name = "getResponse";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr19.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: ActionResponseWrapper_SIG_hasGetResponseReturns */
      /* Details: "Method getResponse() returns ActionResponse " */
      TestResult tr20 = tcd.getTestResultFailed(ACTIONRESPONSEWRAPPER_SIG_HASGETRESPONSERETURNS);
      {
         String name = "getResponse";
         Class<?> retType = ActionResponse.class;
         Class<?>[] parms = null;
         tr20.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: ActionResponseWrapper_SIG_hasSetResponse */
      /* Details: "Has a setResponse(ActionResponse)  method " */
      TestResult tr21 = tcd.getTestResultFailed(ACTIONRESPONSEWRAPPER_SIG_HASSETRESPONSE);
      {
         String name = "setResponse";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {ActionResponse.class};
         tr21.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: ActionResponseWrapper_SIG_hasSetResponseReturns */
      /* Details: "Method setResponse(ActionResponse) returns void " */
      TestResult tr22 = tcd.getTestResultFailed(ACTIONRESPONSEWRAPPER_SIG_HASSETRESPONSERETURNS);
      {
         String name = "setResponse";
         Class<?> retType = void.class;
         Class<?>[] parms = {ActionResponse.class};
         tr22.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: ActionResponseWrapper_SIG_hasGetPortletMode */
      /* Details: "Has a getPortletMode()  method " */
      TestResult tr23 = tcd.getTestResultFailed(ACTIONRESPONSEWRAPPER_SIG_HASGETPORTLETMODE);
      {
         String name = "getPortletMode";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr23.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: ActionResponseWrapper_SIG_hasGetPortletModeReturns */
      /* Details: "Method getPortletMode() returns PortletMode " */
      TestResult tr24 = tcd.getTestResultFailed(ACTIONRESPONSEWRAPPER_SIG_HASGETPORTLETMODERETURNS);
      {
         String name = "getPortletMode";
         Class<?> retType = PortletMode.class;
         Class<?>[] parms = null;
         tr24.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: ActionResponseWrapper_SIG_hasGetRenderParameterMap */
      /* Details: "Has a getRenderParameterMap()  method " */
      TestResult tr25 = tcd.getTestResultFailed(ACTIONRESPONSEWRAPPER_SIG_HASGETRENDERPARAMETERMAP);
      {
         String name = "getRenderParameterMap";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr25.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: ActionResponseWrapper_SIG_hasGetRenderParameterMapReturns */
      /* Details: "Method getRenderParameterMap() returns java.util.Map " */
      TestResult tr26 = tcd.getTestResultFailed(ACTIONRESPONSEWRAPPER_SIG_HASGETRENDERPARAMETERMAPRETURNS);
      {
         String name = "getRenderParameterMap";
         Class<?> retType = java.util.Map.class;
         Class<?>[] parms = null;
         tr26.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: ActionResponseWrapper_SIG_hasGetWindowState */
      /* Details: "Has a getWindowState()  method " */
      TestResult tr27 = tcd.getTestResultFailed(ACTIONRESPONSEWRAPPER_SIG_HASGETWINDOWSTATE);
      {
         String name = "getWindowState";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr27.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: ActionResponseWrapper_SIG_hasGetWindowStateReturns */
      /* Details: "Method getWindowState() returns WindowState " */
      TestResult tr28 = tcd.getTestResultFailed(ACTIONRESPONSEWRAPPER_SIG_HASGETWINDOWSTATERETURNS);
      {
         String name = "getWindowState";
         Class<?> retType = WindowState.class;
         Class<?>[] parms = null;
         tr28.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: ActionResponseWrapper_SIG_hasSetEventA */
      /* Details: "Has a setEvent(String, java.io.Serializable)  method " */
      TestResult tr29 = tcd.getTestResultFailed(ACTIONRESPONSEWRAPPER_SIG_HASSETEVENTA);
      {
         String name = "setEvent";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class, java.io.Serializable.class};
         tr29.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: ActionResponseWrapper_SIG_hasSetEventReturnsA */
      /* Details: "Method setEvent(String, java.io.Serializable) returns void " */
      TestResult tr30 = tcd.getTestResultFailed(ACTIONRESPONSEWRAPPER_SIG_HASSETEVENTRETURNSA);
      {
         String name = "setEvent";
         Class<?> retType = void.class;
         Class<?>[] parms = {String.class, java.io.Serializable.class};
         tr30.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: ActionResponseWrapper_SIG_hasRemovePublicRenderParameter */
      /* Details: "Has a removePublicRenderParameter(String)  method " */
      TestResult tr31 = tcd.getTestResultFailed(ACTIONRESPONSEWRAPPER_SIG_HASREMOVEPUBLICRENDERPARAMETER);
      {
         String name = "removePublicRenderParameter";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class};
         tr31.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: ActionResponseWrapper_SIG_hasRemovePublicRenderParameterReturns */
      /* Details: "Method removePublicRenderParameter(String) returns void " */
      TestResult tr32 = tcd.getTestResultFailed(ACTIONRESPONSEWRAPPER_SIG_HASREMOVEPUBLICRENDERPARAMETERRETURNS);
      {
         String name = "removePublicRenderParameter";
         Class<?> retType = void.class;
         Class<?>[] parms = {String.class};
         tr32.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: ActionResponseWrapper_SIG_hasGetResponseA */
      /* Details: "Has a getResponse()  method " */
      TestResult tr33 = tcd.getTestResultFailed(ACTIONRESPONSEWRAPPER_SIG_HASGETRESPONSEA);
      {
         String name = "getResponse";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr33.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: ActionResponseWrapper_SIG_hasGetResponseReturnsA */
      /* Details: "Method getResponse() returns PortletResponse " */
      TestResult tr34 = tcd.getTestResultFailed(ACTIONRESPONSEWRAPPER_SIG_HASGETRESPONSERETURNSA);
      {
         String name = "getResponse";
         Class<?> retType = PortletResponse.class;
         Class<?>[] parms = null;
         tr34.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
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


   }

}

