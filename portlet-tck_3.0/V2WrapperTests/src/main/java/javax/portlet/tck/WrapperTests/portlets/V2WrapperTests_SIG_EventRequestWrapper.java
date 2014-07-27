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
public class V2WrapperTests_SIG_EventRequestWrapper implements Portlet {
   private static final String LOG_CLASS = 
         V2WrapperTests_SIG_EventRequestWrapper.class.getName();
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
      ClassChecker cc = new ClassChecker(EventRequestWrapper.class);

      // Create result objects for the tests

      /* TestCase: EventRequestWrapper_SIG_extendsPortletRequestWrapper */
      /* Details: "Extends PortletRequestWrapper " */
      TestResult tr0 = tcd.getTestResultFailed(EVENTREQUESTWRAPPER_SIG_EXTENDSPORTLETREQUESTWRAPPER);
      {
         tr0.setTcSuccess(cc.hasSuperclass(PortletRequestWrapper.class));
      }

      /* TestCase: EventRequestWrapper_SIG_implementsEventRequest */
      /* Details: "Implements EventRequest " */
      TestResult tr1 = tcd.getTestResultFailed(EVENTREQUESTWRAPPER_SIG_IMPLEMENTSEVENTREQUEST);
      {
         tr1.setTcSuccess(cc.implementsInterface(EventRequest.class));
      }

      /* TestCase: EventRequestWrapper_SIG_constructor */
      /* Details: "Provides constructor EventRequestWrapper(EventRequest) " */
      TestResult tr2 = tcd.getTestResultFailed(EVENTREQUESTWRAPPER_SIG_CONSTRUCTOR);
      {
         Class<?>[] parms = {EventRequest.class};
         tr2.setTcSuccess(cc.hasConstructor(parms));
      }

      /* TestCase: EventRequestWrapper_SIG_hasGetRequest */
      /* Details: "Has a getRequest()  method " */
      TestResult tr3 = tcd.getTestResultFailed(EVENTREQUESTWRAPPER_SIG_HASGETREQUEST);
      {
         String name = "getRequest";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr3.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: EventRequestWrapper_SIG_hasGetRequestReturns */
      /* Details: "Method getRequest() returns EventRequest " */
      TestResult tr4 = tcd.getTestResultFailed(EVENTREQUESTWRAPPER_SIG_HASGETREQUESTRETURNS);
      {
         String name = "getRequest";
         Class<?> retType = EventRequest.class;
         Class<?>[] parms = null;
         tr4.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: EventRequestWrapper_SIG_hasSetRequest */
      /* Details: "Has a setRequest(EventRequest)  method " */
      TestResult tr5 = tcd.getTestResultFailed(EVENTREQUESTWRAPPER_SIG_HASSETREQUEST);
      {
         String name = "setRequest";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {EventRequest.class};
         tr5.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: EventRequestWrapper_SIG_hasSetRequestReturns */
      /* Details: "Method setRequest(EventRequest) returns void " */
      TestResult tr6 = tcd.getTestResultFailed(EVENTREQUESTWRAPPER_SIG_HASSETREQUESTRETURNS);
      {
         String name = "setRequest";
         Class<?> retType = void.class;
         Class<?>[] parms = {EventRequest.class};
         tr6.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: EventRequestWrapper_SIG_hasGetEvent */
      /* Details: "Has a getEvent()  method " */
      TestResult tr7 = tcd.getTestResultFailed(EVENTREQUESTWRAPPER_SIG_HASGETEVENT);
      {
         String name = "getEvent";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr7.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: EventRequestWrapper_SIG_hasGetEventReturns */
      /* Details: "Method getEvent() returns Event " */
      TestResult tr8 = tcd.getTestResultFailed(EVENTREQUESTWRAPPER_SIG_HASGETEVENTRETURNS);
      {
         String name = "getEvent";
         Class<?> retType = Event.class;
         Class<?>[] parms = null;
         tr8.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: EventRequestWrapper_SIG_hasGetMethod */
      /* Details: "Has a getMethod()  method " */
      TestResult tr9 = tcd.getTestResultFailed(EVENTREQUESTWRAPPER_SIG_HASGETMETHOD);
      {
         String name = "getMethod";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr9.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: EventRequestWrapper_SIG_hasGetMethodReturns */
      /* Details: "Method getMethod() returns String " */
      TestResult tr10 = tcd.getTestResultFailed(EVENTREQUESTWRAPPER_SIG_HASGETMETHODRETURNS);
      {
         String name = "getMethod";
         Class<?> retType = String.class;
         Class<?>[] parms = null;
         tr10.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: EventRequestWrapper_SIG_hasGetRequestA */
      /* Details: "Has a getRequest()  method " */
      TestResult tr11 = tcd.getTestResultFailed(EVENTREQUESTWRAPPER_SIG_HASGETREQUESTA);
      {
         String name = "getRequest";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr11.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: EventRequestWrapper_SIG_hasGetRequestReturnsA */
      /* Details: "Method getRequest() returns PortletRequest " */
      TestResult tr12 = tcd.getTestResultFailed(EVENTREQUESTWRAPPER_SIG_HASGETREQUESTRETURNSA);
      {
         String name = "getRequest";
         Class<?> retType = PortletRequest.class;
         Class<?>[] parms = null;
         tr12.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
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


   }

}

