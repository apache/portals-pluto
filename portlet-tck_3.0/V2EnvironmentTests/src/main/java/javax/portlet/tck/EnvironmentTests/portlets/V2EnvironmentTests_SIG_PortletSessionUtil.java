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
public class V2EnvironmentTests_SIG_PortletSessionUtil implements Portlet {
   private static final String LOG_CLASS = 
         V2EnvironmentTests_SIG_PortletSessionUtil.class.getName();
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
      ClassChecker cc = new ClassChecker(PortletSessionUtil.class);

      // Create result objects for the tests

      /* TestCase: PortletSessionUtil_SIG_constructor */
      /* Details: "Provides constructor PortletSessionUtil() " */
      TestResult tr0 = tcd.getTestResultFailed(PORTLETSESSIONUTIL_SIG_CONSTRUCTOR);
      {
         Class<?>[] parms = null;
         tr0.setTcSuccess(cc.hasConstructor(parms));
      }

      /* TestCase: PortletSessionUtil_SIG_hasDecodeAttributeName */
      /* Details: "Has a decodeAttributeName(String)  method " */
      TestResult tr1 = tcd.getTestResultFailed(PORTLETSESSIONUTIL_SIG_HASDECODEATTRIBUTENAME);
      {
         String name = "decodeAttributeName";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class};
         tr1.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletSessionUtil_SIG_hasDecodeAttributeNameReturns */
      /* Details: "Method decodeAttributeName(String) returns String " */
      TestResult tr2 = tcd.getTestResultFailed(PORTLETSESSIONUTIL_SIG_HASDECODEATTRIBUTENAMERETURNS);
      {
         String name = "decodeAttributeName";
         Class<?> retType = String.class;
         Class<?>[] parms = {String.class};
         tr2.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletSessionUtil_SIG_hasDecodeScope */
      /* Details: "Has a decodeScope(String)  method " */
      TestResult tr3 = tcd.getTestResultFailed(PORTLETSESSIONUTIL_SIG_HASDECODESCOPE);
      {
         String name = "decodeScope";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class};
         tr3.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletSessionUtil_SIG_hasDecodeScopeReturns */
      /* Details: "Method decodeScope(String) returns int " */
      TestResult tr4 = tcd.getTestResultFailed(PORTLETSESSIONUTIL_SIG_HASDECODESCOPERETURNS);
      {
         String name = "decodeScope";
         Class<?> retType = int.class;
         Class<?>[] parms = {String.class};
         tr4.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }



      // Write the results to the output stream

      tr0.writeTo(writer);
      tr1.writeTo(writer);
      tr2.writeTo(writer);
      tr3.writeTo(writer);
      tr4.writeTo(writer);


   }

}

