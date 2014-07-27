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

package javax.portlet.tck.EnvironmentTests.portlets;

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
public class V2EnvironmentTests_SIG_PortletSession implements Portlet {
   private static final String LOG_CLASS = 
         V2EnvironmentTests_SIG_PortletSession.class.getName();
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
      ClassChecker cc = new ClassChecker(renderRequest.getPortletSession().getClass());

      // Create result objects for the tests

      /* TestCase: PortletSession_SIG_fieldAPPLICATION_SCOPE */
      /* Details: "Has int field APPLICATION_SCOPE " */
      TestResult tr0 = tcd.getTestResultFailed(PORTLETSESSION_SIG_FIELDAPPLICATION_SCOPE);
      {
         tr0.setTcSuccess(cc.hasField("APPLICATION_SCOPE"));
      }

      /* TestCase: PortletSession_SIG_fieldPORTLET_SCOPE */
      /* Details: "Has int field PORTLET_SCOPE " */
      TestResult tr1 = tcd.getTestResultFailed(PORTLETSESSION_SIG_FIELDPORTLET_SCOPE);
      {
         tr1.setTcSuccess(cc.hasField("PORTLET_SCOPE"));
      }

      /* TestCase: PortletSession_SIG_hasGetAttribute */
      /* Details: "Has a getAttribute(String)  method " */
      TestResult tr2 = tcd.getTestResultFailed(PORTLETSESSION_SIG_HASGETATTRIBUTE);
      {
         String name = "getAttribute";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class};
         tr2.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletSession_SIG_hasGetAttributeReturns */
      /* Details: "Method getAttribute(String) returns Object " */
      TestResult tr3 = tcd.getTestResultFailed(PORTLETSESSION_SIG_HASGETATTRIBUTERETURNS);
      {
         String name = "getAttribute";
         Class<?> retType = Object.class;
         Class<?>[] parms = {String.class};
         tr3.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletSession_SIG_hasGetAttributeA */
      /* Details: "Has a getAttribute(String, int)  method " */
      TestResult tr4 = tcd.getTestResultFailed(PORTLETSESSION_SIG_HASGETATTRIBUTEA);
      {
         String name = "getAttribute";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class, int.class};
         tr4.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletSession_SIG_hasGetAttributeReturnsA */
      /* Details: "Method getAttribute(String, int) returns Object " */
      TestResult tr5 = tcd.getTestResultFailed(PORTLETSESSION_SIG_HASGETATTRIBUTERETURNSA);
      {
         String name = "getAttribute";
         Class<?> retType = Object.class;
         Class<?>[] parms = {String.class, int.class};
         tr5.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletSession_SIG_hasGetAttributeNames */
      /* Details: "Has a getAttributeNames()  method " */
      TestResult tr6 = tcd.getTestResultFailed(PORTLETSESSION_SIG_HASGETATTRIBUTENAMES);
      {
         String name = "getAttributeNames";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr6.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletSession_SIG_hasGetAttributeNamesReturns */
      /* Details: "Method getAttributeNames() returns java.util.Enumeration " */
      TestResult tr7 = tcd.getTestResultFailed(PORTLETSESSION_SIG_HASGETATTRIBUTENAMESRETURNS);
      {
         String name = "getAttributeNames";
         Class<?> retType = java.util.Enumeration.class;
         Class<?>[] parms = null;
         tr7.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletSession_SIG_hasGetAttributeNamesA */
      /* Details: "Has a getAttributeNames(int)  method " */
      TestResult tr8 = tcd.getTestResultFailed(PORTLETSESSION_SIG_HASGETATTRIBUTENAMESA);
      {
         String name = "getAttributeNames";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {int.class};
         tr8.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletSession_SIG_hasGetAttributeNamesReturnsA */
      /* Details: "Method getAttributeNames(int) returns java.util.Enumeration " */
      TestResult tr9 = tcd.getTestResultFailed(PORTLETSESSION_SIG_HASGETATTRIBUTENAMESRETURNSA);
      {
         String name = "getAttributeNames";
         Class<?> retType = java.util.Enumeration.class;
         Class<?>[] parms = {int.class};
         tr9.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletSession_SIG_hasGetCreationTime */
      /* Details: "Has a getCreationTime()  method " */
      TestResult tr10 = tcd.getTestResultFailed(PORTLETSESSION_SIG_HASGETCREATIONTIME);
      {
         String name = "getCreationTime";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr10.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletSession_SIG_hasGetCreationTimeReturns */
      /* Details: "Method getCreationTime() returns long " */
      TestResult tr11 = tcd.getTestResultFailed(PORTLETSESSION_SIG_HASGETCREATIONTIMERETURNS);
      {
         String name = "getCreationTime";
         Class<?> retType = long.class;
         Class<?>[] parms = null;
         tr11.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletSession_SIG_hasGetId */
      /* Details: "Has a getId()  method " */
      TestResult tr12 = tcd.getTestResultFailed(PORTLETSESSION_SIG_HASGETID);
      {
         String name = "getId";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr12.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletSession_SIG_hasGetIdReturns */
      /* Details: "Method getId() returns String " */
      TestResult tr13 = tcd.getTestResultFailed(PORTLETSESSION_SIG_HASGETIDRETURNS);
      {
         String name = "getId";
         Class<?> retType = String.class;
         Class<?>[] parms = null;
         tr13.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletSession_SIG_hasGetLastAccessedTime */
      /* Details: "Has a getLastAccessedTime()  method " */
      TestResult tr14 = tcd.getTestResultFailed(PORTLETSESSION_SIG_HASGETLASTACCESSEDTIME);
      {
         String name = "getLastAccessedTime";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr14.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletSession_SIG_hasGetLastAccessedTimeReturns */
      /* Details: "Method getLastAccessedTime() returns long " */
      TestResult tr15 = tcd.getTestResultFailed(PORTLETSESSION_SIG_HASGETLASTACCESSEDTIMERETURNS);
      {
         String name = "getLastAccessedTime";
         Class<?> retType = long.class;
         Class<?>[] parms = null;
         tr15.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletSession_SIG_hasGetMaxInactiveInterval */
      /* Details: "Has a getMaxInactiveInterval()  method " */
      TestResult tr16 = tcd.getTestResultFailed(PORTLETSESSION_SIG_HASGETMAXINACTIVEINTERVAL);
      {
         String name = "getMaxInactiveInterval";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr16.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletSession_SIG_hasGetMaxInactiveIntervalReturns */
      /* Details: "Method getMaxInactiveInterval() returns int " */
      TestResult tr17 = tcd.getTestResultFailed(PORTLETSESSION_SIG_HASGETMAXINACTIVEINTERVALRETURNS);
      {
         String name = "getMaxInactiveInterval";
         Class<?> retType = int.class;
         Class<?>[] parms = null;
         tr17.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletSession_SIG_hasInvalidate */
      /* Details: "Has a invalidate()  method " */
      TestResult tr18 = tcd.getTestResultFailed(PORTLETSESSION_SIG_HASINVALIDATE);
      {
         String name = "invalidate";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr18.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletSession_SIG_hasInvalidateReturns */
      /* Details: "Method invalidate() returns void " */
      TestResult tr19 = tcd.getTestResultFailed(PORTLETSESSION_SIG_HASINVALIDATERETURNS);
      {
         String name = "invalidate";
         Class<?> retType = void.class;
         Class<?>[] parms = null;
         tr19.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletSession_SIG_hasIsNew */
      /* Details: "Has a isNew()  method " */
      TestResult tr20 = tcd.getTestResultFailed(PORTLETSESSION_SIG_HASISNEW);
      {
         String name = "isNew";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr20.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletSession_SIG_hasIsNewReturns */
      /* Details: "Method isNew() returns boolean " */
      TestResult tr21 = tcd.getTestResultFailed(PORTLETSESSION_SIG_HASISNEWRETURNS);
      {
         String name = "isNew";
         Class<?> retType = boolean.class;
         Class<?>[] parms = null;
         tr21.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletSession_SIG_hasRemoveAttribute */
      /* Details: "Has a removeAttribute(String)  method " */
      TestResult tr22 = tcd.getTestResultFailed(PORTLETSESSION_SIG_HASREMOVEATTRIBUTE);
      {
         String name = "removeAttribute";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class};
         tr22.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletSession_SIG_hasRemoveAttributeReturns */
      /* Details: "Method removeAttribute(String) returns void " */
      TestResult tr23 = tcd.getTestResultFailed(PORTLETSESSION_SIG_HASREMOVEATTRIBUTERETURNS);
      {
         String name = "removeAttribute";
         Class<?> retType = void.class;
         Class<?>[] parms = {String.class};
         tr23.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletSession_SIG_hasRemoveAttributeA */
      /* Details: "Has a removeAttribute(String, int)  method " */
      TestResult tr24 = tcd.getTestResultFailed(PORTLETSESSION_SIG_HASREMOVEATTRIBUTEA);
      {
         String name = "removeAttribute";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class, int.class};
         tr24.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletSession_SIG_hasRemoveAttributeReturnsA */
      /* Details: "Method removeAttribute(String, int) returns void " */
      TestResult tr25 = tcd.getTestResultFailed(PORTLETSESSION_SIG_HASREMOVEATTRIBUTERETURNSA);
      {
         String name = "removeAttribute";
         Class<?> retType = void.class;
         Class<?>[] parms = {String.class, int.class};
         tr25.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletSession_SIG_hasSetAttribute */
      /* Details: "Has a setAttribute(String, Object)  method " */
      TestResult tr26 = tcd.getTestResultFailed(PORTLETSESSION_SIG_HASSETATTRIBUTE);
      {
         String name = "setAttribute";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class, Object.class};
         tr26.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletSession_SIG_hasSetAttributeReturns */
      /* Details: "Method setAttribute(String, Object) returns void " */
      TestResult tr27 = tcd.getTestResultFailed(PORTLETSESSION_SIG_HASSETATTRIBUTERETURNS);
      {
         String name = "setAttribute";
         Class<?> retType = void.class;
         Class<?>[] parms = {String.class, Object.class};
         tr27.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletSession_SIG_hasSetAttributeA */
      /* Details: "Has a setAttribute(String, Object, int)  method " */
      TestResult tr28 = tcd.getTestResultFailed(PORTLETSESSION_SIG_HASSETATTRIBUTEA);
      {
         String name = "setAttribute";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class, Object.class, int.class};
         tr28.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletSession_SIG_hasSetAttributeReturnsA */
      /* Details: "Method setAttribute(String, Object, int) returns void " */
      TestResult tr29 = tcd.getTestResultFailed(PORTLETSESSION_SIG_HASSETATTRIBUTERETURNSA);
      {
         String name = "setAttribute";
         Class<?> retType = void.class;
         Class<?>[] parms = {String.class, Object.class, int.class};
         tr29.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletSession_SIG_hasSetMaxInactiveInterval */
      /* Details: "Has a setMaxInactiveInterval(int)  method " */
      TestResult tr30 = tcd.getTestResultFailed(PORTLETSESSION_SIG_HASSETMAXINACTIVEINTERVAL);
      {
         String name = "setMaxInactiveInterval";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {int.class};
         tr30.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletSession_SIG_hasSetMaxInactiveIntervalReturns */
      /* Details: "Method setMaxInactiveInterval(int) returns void " */
      TestResult tr31 = tcd.getTestResultFailed(PORTLETSESSION_SIG_HASSETMAXINACTIVEINTERVALRETURNS);
      {
         String name = "setMaxInactiveInterval";
         Class<?> retType = void.class;
         Class<?>[] parms = {int.class};
         tr31.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletSession_SIG_hasGetPortletContext */
      /* Details: "Has a getPortletContext()  method " */
      TestResult tr32 = tcd.getTestResultFailed(PORTLETSESSION_SIG_HASGETPORTLETCONTEXT);
      {
         String name = "getPortletContext";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr32.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletSession_SIG_hasGetPortletContextReturns */
      /* Details: "Method getPortletContext() returns PortletContext " */
      TestResult tr33 = tcd.getTestResultFailed(PORTLETSESSION_SIG_HASGETPORTLETCONTEXTRETURNS);
      {
         String name = "getPortletContext";
         Class<?> retType = PortletContext.class;
         Class<?>[] parms = null;
         tr33.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletSession_SIG_hasGetAttributeMap */
      /* Details: "Has a getAttributeMap()  method " */
      TestResult tr34 = tcd.getTestResultFailed(PORTLETSESSION_SIG_HASGETATTRIBUTEMAP);
      {
         String name = "getAttributeMap";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr34.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletSession_SIG_hasGetAttributeMapReturns */
      /* Details: "Method getAttributeMap() returns java.util.Map " */
      TestResult tr35 = tcd.getTestResultFailed(PORTLETSESSION_SIG_HASGETATTRIBUTEMAPRETURNS);
      {
         String name = "getAttributeMap";
         Class<?> retType = java.util.Map.class;
         Class<?>[] parms = null;
         tr35.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletSession_SIG_hasGetAttributeMapA */
      /* Details: "Has a getAttributeMap(int)  method " */
      TestResult tr36 = tcd.getTestResultFailed(PORTLETSESSION_SIG_HASGETATTRIBUTEMAPA);
      {
         String name = "getAttributeMap";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {int.class};
         tr36.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletSession_SIG_hasGetAttributeMapReturnsA */
      /* Details: "Method getAttributeMap(int) returns java.util.Map " */
      TestResult tr37 = tcd.getTestResultFailed(PORTLETSESSION_SIG_HASGETATTRIBUTEMAPRETURNSA);
      {
         String name = "getAttributeMap";
         Class<?> retType = java.util.Map.class;
         Class<?>[] parms = {int.class};
         tr37.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
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


   }

}

