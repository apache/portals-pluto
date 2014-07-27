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

package javax.portlet.tck.ExceptionTests.portlets;

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
public class V2ExceptionTests_SIG_UnavailableException implements Portlet {
   private static final String LOG_CLASS = 
         V2ExceptionTests_SIG_UnavailableException.class.getName();
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
      ClassChecker cc = new ClassChecker(UnavailableException.class);

      // Create result objects for the tests

      /* TestCase: UnavailableException_SIG_extendsPortletException */
      /* Details: "Extends PortletException " */
      TestResult tr0 = tcd.getTestResultFailed(UNAVAILABLEEXCEPTION_SIG_EXTENDSPORTLETEXCEPTION);
      {
         tr0.setTcSuccess(cc.hasSuperclass(PortletException.class));
      }

      /* TestCase: UnavailableException_SIG_constructor */
      /* Details: "Provides constructor UnavailableException(String) " */
      TestResult tr1 = tcd.getTestResultFailed(UNAVAILABLEEXCEPTION_SIG_CONSTRUCTOR);
      {
         Class<?>[] parms = {String.class};
         tr1.setTcSuccess(cc.hasConstructor(parms));
      }

      /* TestCase: UnavailableException_SIG_constructorA */
      /* Details: "Provides constructor UnavailableException(String, int) " */
      TestResult tr2 = tcd.getTestResultFailed(UNAVAILABLEEXCEPTION_SIG_CONSTRUCTORA);
      {
         Class<?>[] parms = {String.class, int.class};
         tr2.setTcSuccess(cc.hasConstructor(parms));
      }

      /* TestCase: UnavailableException_SIG_hasIsPermanent */
      /* Details: "Has a isPermanent()  method " */
      TestResult tr3 = tcd.getTestResultFailed(UNAVAILABLEEXCEPTION_SIG_HASISPERMANENT);
      {
         String name = "isPermanent";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr3.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: UnavailableException_SIG_hasIsPermanentReturns */
      /* Details: "Method isPermanent() returns boolean " */
      TestResult tr4 = tcd.getTestResultFailed(UNAVAILABLEEXCEPTION_SIG_HASISPERMANENTRETURNS);
      {
         String name = "isPermanent";
         Class<?> retType = boolean.class;
         Class<?>[] parms = null;
         tr4.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: UnavailableException_SIG_hasGetUnavailableSeconds */
      /* Details: "Has a getUnavailableSeconds()  method " */
      TestResult tr5 = tcd.getTestResultFailed(UNAVAILABLEEXCEPTION_SIG_HASGETUNAVAILABLESECONDS);
      {
         String name = "getUnavailableSeconds";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr5.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: UnavailableException_SIG_hasGetUnavailableSecondsReturns */
      /* Details: "Method getUnavailableSeconds() returns int " */
      TestResult tr6 = tcd.getTestResultFailed(UNAVAILABLEEXCEPTION_SIG_HASGETUNAVAILABLESECONDSRETURNS);
      {
         String name = "getUnavailableSeconds";
         Class<?> retType = int.class;
         Class<?>[] parms = null;
         tr6.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }



      // Write the results to the output stream

      tr0.writeTo(writer);
      tr1.writeTo(writer);
      tr2.writeTo(writer);
      tr3.writeTo(writer);
      tr4.writeTo(writer);
      tr5.writeTo(writer);
      tr6.writeTo(writer);


   }

}

