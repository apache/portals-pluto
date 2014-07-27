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
public class V2EnvironmentTests_SIG_CacheControl implements Portlet {
   private static final String LOG_CLASS = 
         V2EnvironmentTests_SIG_CacheControl.class.getName();
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
      ClassChecker cc = new ClassChecker(renderResponse.getCacheControl().getClass());

      // Create result objects for the tests

      /* TestCase: CacheControl_SIG_hasGetExpirationTime */
      /* Details: "Has a getExpirationTime()  method " */
      TestResult tr0 = tcd.getTestResultFailed(CACHECONTROL_SIG_HASGETEXPIRATIONTIME);
      {
         String name = "getExpirationTime";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr0.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: CacheControl_SIG_hasGetExpirationTimeReturns */
      /* Details: "Method getExpirationTime() returns int " */
      TestResult tr1 = tcd.getTestResultFailed(CACHECONTROL_SIG_HASGETEXPIRATIONTIMERETURNS);
      {
         String name = "getExpirationTime";
         Class<?> retType = int.class;
         Class<?>[] parms = null;
         tr1.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: CacheControl_SIG_hasSetExpirationTime */
      /* Details: "Has a setExpirationTime(int)  method " */
      TestResult tr2 = tcd.getTestResultFailed(CACHECONTROL_SIG_HASSETEXPIRATIONTIME);
      {
         String name = "setExpirationTime";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {int.class};
         tr2.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: CacheControl_SIG_hasSetExpirationTimeReturns */
      /* Details: "Method setExpirationTime(int) returns void " */
      TestResult tr3 = tcd.getTestResultFailed(CACHECONTROL_SIG_HASSETEXPIRATIONTIMERETURNS);
      {
         String name = "setExpirationTime";
         Class<?> retType = void.class;
         Class<?>[] parms = {int.class};
         tr3.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: CacheControl_SIG_hasIsPublicScope */
      /* Details: "Has a isPublicScope()  method " */
      TestResult tr4 = tcd.getTestResultFailed(CACHECONTROL_SIG_HASISPUBLICSCOPE);
      {
         String name = "isPublicScope";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr4.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: CacheControl_SIG_hasIsPublicScopeReturns */
      /* Details: "Method isPublicScope() returns boolean " */
      TestResult tr5 = tcd.getTestResultFailed(CACHECONTROL_SIG_HASISPUBLICSCOPERETURNS);
      {
         String name = "isPublicScope";
         Class<?> retType = boolean.class;
         Class<?>[] parms = null;
         tr5.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: CacheControl_SIG_hasSetPublicScope */
      /* Details: "Has a setPublicScope(boolean)  method " */
      TestResult tr6 = tcd.getTestResultFailed(CACHECONTROL_SIG_HASSETPUBLICSCOPE);
      {
         String name = "setPublicScope";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {boolean.class};
         tr6.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: CacheControl_SIG_hasSetPublicScopeReturns */
      /* Details: "Method setPublicScope(boolean) returns void " */
      TestResult tr7 = tcd.getTestResultFailed(CACHECONTROL_SIG_HASSETPUBLICSCOPERETURNS);
      {
         String name = "setPublicScope";
         Class<?> retType = void.class;
         Class<?>[] parms = {boolean.class};
         tr7.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: CacheControl_SIG_hasGetETag */
      /* Details: "Has a getETag()  method " */
      TestResult tr8 = tcd.getTestResultFailed(CACHECONTROL_SIG_HASGETETAG);
      {
         String name = "getETag";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr8.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: CacheControl_SIG_hasGetETagReturns */
      /* Details: "Method getETag() returns String " */
      TestResult tr9 = tcd.getTestResultFailed(CACHECONTROL_SIG_HASGETETAGRETURNS);
      {
         String name = "getETag";
         Class<?> retType = String.class;
         Class<?>[] parms = null;
         tr9.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: CacheControl_SIG_hasSetETag */
      /* Details: "Has a setETag(String)  method " */
      TestResult tr10 = tcd.getTestResultFailed(CACHECONTROL_SIG_HASSETETAG);
      {
         String name = "setETag";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class};
         tr10.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: CacheControl_SIG_hasSetETagReturns */
      /* Details: "Method setETag(String) returns void " */
      TestResult tr11 = tcd.getTestResultFailed(CACHECONTROL_SIG_HASSETETAGRETURNS);
      {
         String name = "setETag";
         Class<?> retType = void.class;
         Class<?>[] parms = {String.class};
         tr11.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: CacheControl_SIG_hasUseCachedContent */
      /* Details: "Has a useCachedContent()  method " */
      TestResult tr12 = tcd.getTestResultFailed(CACHECONTROL_SIG_HASUSECACHEDCONTENT);
      {
         String name = "useCachedContent";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr12.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: CacheControl_SIG_hasUseCachedContentReturns */
      /* Details: "Method useCachedContent() returns boolean " */
      TestResult tr13 = tcd.getTestResultFailed(CACHECONTROL_SIG_HASUSECACHEDCONTENTRETURNS);
      {
         String name = "useCachedContent";
         Class<?> retType = boolean.class;
         Class<?>[] parms = null;
         tr13.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: CacheControl_SIG_hasSetUseCachedContent */
      /* Details: "Has a setUseCachedContent(boolean)  method " */
      TestResult tr14 = tcd.getTestResultFailed(CACHECONTROL_SIG_HASSETUSECACHEDCONTENT);
      {
         String name = "setUseCachedContent";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {boolean.class};
         tr14.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: CacheControl_SIG_hasSetUseCachedContentReturns */
      /* Details: "Method setUseCachedContent(boolean) returns void " */
      TestResult tr15 = tcd.getTestResultFailed(CACHECONTROL_SIG_HASSETUSECACHEDCONTENTRETURNS);
      {
         String name = "setUseCachedContent";
         Class<?> retType = void.class;
         Class<?>[] parms = {boolean.class};
         tr15.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
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


   }

}

