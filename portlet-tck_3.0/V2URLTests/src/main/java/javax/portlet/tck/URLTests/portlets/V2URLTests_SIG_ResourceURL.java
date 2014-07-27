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
public class V2URLTests_SIG_ResourceURL implements Portlet {
   private static final String LOG_CLASS = 
         V2URLTests_SIG_ResourceURL.class.getName();
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
      ClassChecker cc = new ClassChecker(renderResponse.createResourceURL().getClass());

      // Create result objects for the tests

      /* TestCase: ResourceURL_SIG_implementsBaseURL */
      /* Details: "Implements BaseURL " */
      TestResult tr0 = tcd.getTestResultFailed(RESOURCEURL_SIG_IMPLEMENTSBASEURL);
      {
         tr0.setTcSuccess(cc.implementsInterface(BaseURL.class));
      }

      /* TestCase: ResourceURL_SIG_fieldFULL */
      /* Details: "Has String field FULL " */
      TestResult tr1 = tcd.getTestResultFailed(RESOURCEURL_SIG_FIELDFULL);
      {
         tr1.setTcSuccess(cc.hasField("FULL"));
      }

      /* TestCase: ResourceURL_SIG_fieldPORTLET */
      /* Details: "Has String field PORTLET " */
      TestResult tr2 = tcd.getTestResultFailed(RESOURCEURL_SIG_FIELDPORTLET);
      {
         tr2.setTcSuccess(cc.hasField("PORTLET"));
      }

      /* TestCase: ResourceURL_SIG_fieldPAGE */
      /* Details: "Has String field PAGE " */
      TestResult tr3 = tcd.getTestResultFailed(RESOURCEURL_SIG_FIELDPAGE);
      {
         tr3.setTcSuccess(cc.hasField("PAGE"));
      }

      /* TestCase: ResourceURL_SIG_fieldSHARED */
      /* Details: "Has String field SHARED " */
      TestResult tr4 = tcd.getTestResultFailed(RESOURCEURL_SIG_FIELDSHARED);
      {
         tr4.setTcSuccess(cc.hasField("SHARED"));
      }

      /* TestCase: ResourceURL_SIG_hasSetResourceID */
      /* Details: "Has a setResourceID(String)  method " */
      TestResult tr5 = tcd.getTestResultFailed(RESOURCEURL_SIG_HASSETRESOURCEID);
      {
         String name = "setResourceID";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class};
         tr5.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: ResourceURL_SIG_hasSetResourceIDReturns */
      /* Details: "Method setResourceID(String) returns void " */
      TestResult tr6 = tcd.getTestResultFailed(RESOURCEURL_SIG_HASSETRESOURCEIDRETURNS);
      {
         String name = "setResourceID";
         Class<?> retType = void.class;
         Class<?>[] parms = {String.class};
         tr6.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: ResourceURL_SIG_hasGetCacheability */
      /* Details: "Has a getCacheability()  method " */
      TestResult tr7 = tcd.getTestResultFailed(RESOURCEURL_SIG_HASGETCACHEABILITY);
      {
         String name = "getCacheability";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr7.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: ResourceURL_SIG_hasGetCacheabilityReturns */
      /* Details: "Method getCacheability() returns String " */
      TestResult tr8 = tcd.getTestResultFailed(RESOURCEURL_SIG_HASGETCACHEABILITYRETURNS);
      {
         String name = "getCacheability";
         Class<?> retType = String.class;
         Class<?>[] parms = null;
         tr8.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: ResourceURL_SIG_hasSetCacheability */
      /* Details: "Has a setCacheability(String)  method " */
      TestResult tr9 = tcd.getTestResultFailed(RESOURCEURL_SIG_HASSETCACHEABILITY);
      {
         String name = "setCacheability";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class};
         tr9.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: ResourceURL_SIG_hasSetCacheabilityReturns */
      /* Details: "Method setCacheability(String) returns void " */
      TestResult tr10 = tcd.getTestResultFailed(RESOURCEURL_SIG_HASSETCACHEABILITYRETURNS);
      {
         String name = "setCacheability";
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

