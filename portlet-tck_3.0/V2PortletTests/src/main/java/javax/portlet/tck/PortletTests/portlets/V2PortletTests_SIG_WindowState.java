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
public class V2PortletTests_SIG_WindowState implements Portlet {
   private static final String LOG_CLASS = 
         V2PortletTests_SIG_WindowState.class.getName();
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
      ClassChecker cc = new ClassChecker(WindowState.class);

      // Create result objects for the tests

      /* TestCase: WindowState_SIG_fieldNORMAL */
      /* Details: "Has WindowState field NORMAL " */
      TestResult tr0 = tcd.getTestResultFailed(WINDOWSTATE_SIG_FIELDNORMAL);
      {
         tr0.setTcSuccess(cc.hasField("NORMAL"));
      }

      /* TestCase: WindowState_SIG_fieldMAXIMIZED */
      /* Details: "Has WindowState field MAXIMIZED " */
      TestResult tr1 = tcd.getTestResultFailed(WINDOWSTATE_SIG_FIELDMAXIMIZED);
      {
         tr1.setTcSuccess(cc.hasField("MAXIMIZED"));
      }

      /* TestCase: WindowState_SIG_fieldMINIMIZED */
      /* Details: "Has WindowState field MINIMIZED " */
      TestResult tr2 = tcd.getTestResultFailed(WINDOWSTATE_SIG_FIELDMINIMIZED);
      {
         tr2.setTcSuccess(cc.hasField("MINIMIZED"));
      }

      /* TestCase: WindowState_SIG_constructor */
      /* Details: "Provides constructor WindowState(String) " */
      TestResult tr3 = tcd.getTestResultFailed(WINDOWSTATE_SIG_CONSTRUCTOR);
      {
         Class<?>[] parms = {String.class};
         tr3.setTcSuccess(cc.hasConstructor(parms));
      }

      /* TestCase: WindowState_SIG_hasToString */
      /* Details: "Has a toString()  method " */
      TestResult tr4 = tcd.getTestResultFailed(WINDOWSTATE_SIG_HASTOSTRING);
      {
         String name = "toString";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr4.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: WindowState_SIG_hasToStringReturns */
      /* Details: "Method toString() returns String " */
      TestResult tr5 = tcd.getTestResultFailed(WINDOWSTATE_SIG_HASTOSTRINGRETURNS);
      {
         String name = "toString";
         Class<?> retType = String.class;
         Class<?>[] parms = null;
         tr5.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: WindowState_SIG_hasHashCode */
      /* Details: "Has a hashCode()  method " */
      TestResult tr6 = tcd.getTestResultFailed(WINDOWSTATE_SIG_HASHASHCODE);
      {
         String name = "hashCode";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr6.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: WindowState_SIG_hasHashCodeReturns */
      /* Details: "Method hashCode() returns int " */
      TestResult tr7 = tcd.getTestResultFailed(WINDOWSTATE_SIG_HASHASHCODERETURNS);
      {
         String name = "hashCode";
         Class<?> retType = int.class;
         Class<?>[] parms = null;
         tr7.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: WindowState_SIG_hasEquals */
      /* Details: "Has a equals(Object)  method " */
      TestResult tr8 = tcd.getTestResultFailed(WINDOWSTATE_SIG_HASEQUALS);
      {
         String name = "equals";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {Object.class};
         tr8.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: WindowState_SIG_hasEqualsReturns */
      /* Details: "Method equals(Object) returns boolean " */
      TestResult tr9 = tcd.getTestResultFailed(WINDOWSTATE_SIG_HASEQUALSRETURNS);
      {
         String name = "equals";
         Class<?> retType = boolean.class;
         Class<?>[] parms = {Object.class};
         tr9.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
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


   }

}

