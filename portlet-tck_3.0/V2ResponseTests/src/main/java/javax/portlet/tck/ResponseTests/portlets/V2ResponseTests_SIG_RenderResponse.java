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
public class V2ResponseTests_SIG_RenderResponse implements Portlet {
   private static final String LOG_CLASS = 
         V2ResponseTests_SIG_RenderResponse.class.getName();
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
      ClassChecker cc = new ClassChecker(renderResponse.getClass());

      // Create result objects for the tests

      /* TestCase: RenderResponse_SIG_implementsMimeResponse */
      /* Details: "Implements MimeResponse " */
      TestResult tr0 = tcd.getTestResultFailed(RENDERRESPONSE_SIG_IMPLEMENTSMIMERESPONSE);
      {
         tr0.setTcSuccess(cc.implementsInterface(MimeResponse.class));
      }

      /* TestCase: RenderResponse_SIG_hasSetTitle */
      /* Details: "Has a setTitle(String)  method " */
      TestResult tr1 = tcd.getTestResultFailed(RENDERRESPONSE_SIG_HASSETTITLE);
      {
         String name = "setTitle";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class};
         tr1.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: RenderResponse_SIG_hasSetTitleReturns */
      /* Details: "Method setTitle(String) returns void " */
      TestResult tr2 = tcd.getTestResultFailed(RENDERRESPONSE_SIG_HASSETTITLERETURNS);
      {
         String name = "setTitle";
         Class<?> retType = void.class;
         Class<?>[] parms = {String.class};
         tr2.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: RenderResponse_SIG_hasSetNextPossiblePortletModes */
      /* Details: "Has a setNextPossiblePortletModes(java.util.Collection)  method " */
      TestResult tr3 = tcd.getTestResultFailed(RENDERRESPONSE_SIG_HASSETNEXTPOSSIBLEPORTLETMODES);
      {
         String name = "setNextPossiblePortletModes";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {java.util.Collection.class};
         tr3.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: RenderResponse_SIG_hasSetNextPossiblePortletModesReturns */
      /* Details: "Method setNextPossiblePortletModes(java.util.Collection) returns void " */
      TestResult tr4 = tcd.getTestResultFailed(RENDERRESPONSE_SIG_HASSETNEXTPOSSIBLEPORTLETMODESRETURNS);
      {
         String name = "setNextPossiblePortletModes";
         Class<?> retType = void.class;
         Class<?>[] parms = {java.util.Collection.class};
         tr4.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: RenderResponse_SIG_hasSetContentType */
      /* Details: "Has a setContentType(String)  method " */
      TestResult tr5 = tcd.getTestResultFailed(RENDERRESPONSE_SIG_HASSETCONTENTTYPE);
      {
         String name = "setContentType";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class};
         tr5.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: RenderResponse_SIG_hasSetContentTypeReturns */
      /* Details: "Method setContentType(String) returns void " */
      TestResult tr6 = tcd.getTestResultFailed(RENDERRESPONSE_SIG_HASSETCONTENTTYPERETURNS);
      {
         String name = "setContentType";
         Class<?> retType = void.class;
         Class<?>[] parms = {String.class};
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

