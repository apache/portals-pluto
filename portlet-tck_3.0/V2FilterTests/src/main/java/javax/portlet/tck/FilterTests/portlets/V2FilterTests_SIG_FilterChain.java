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

package javax.portlet.tck.FilterTests.portlets;

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
public class V2FilterTests_SIG_FilterChain implements Portlet {
   private static final String LOG_CLASS = 
         V2FilterTests_SIG_FilterChain.class.getName();
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
      ClassChecker cc = new ClassChecker(FilterChain.class);

      // Create result objects for the tests

      /* TestCase: FilterChain_SIG_hasDoFilter */
      /* Details: "Has a doFilter(ActionRequest, ActionResponse) throws java.io.IOException, PortletException method " */
      TestResult tr0 = tcd.getTestResultFailed(FILTERCHAIN_SIG_HASDOFILTER);
      {
         String name = "doFilter";
         Class<?>[] exceptions = {java.io.IOException.class, PortletException.class};
         Class<?>[] parms = {ActionRequest.class, ActionResponse.class};
         tr0.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: FilterChain_SIG_hasDoFilterReturns */
      /* Details: "Method doFilter(ActionRequest, ActionResponse) returns void " */
      TestResult tr1 = tcd.getTestResultFailed(FILTERCHAIN_SIG_HASDOFILTERRETURNS);
      {
         String name = "doFilter";
         Class<?> retType = void.class;
         Class<?>[] parms = {ActionRequest.class, ActionResponse.class};
         tr1.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: FilterChain_SIG_hasDoFilterA */
      /* Details: "Has a doFilter(EventRequest, EventResponse) throws java.io.IOException, PortletException method " */
      TestResult tr2 = tcd.getTestResultFailed(FILTERCHAIN_SIG_HASDOFILTERA);
      {
         String name = "doFilter";
         Class<?>[] exceptions = {java.io.IOException.class, PortletException.class};
         Class<?>[] parms = {EventRequest.class, EventResponse.class};
         tr2.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: FilterChain_SIG_hasDoFilterReturnsA */
      /* Details: "Method doFilter(EventRequest, EventResponse) returns void " */
      TestResult tr3 = tcd.getTestResultFailed(FILTERCHAIN_SIG_HASDOFILTERRETURNSA);
      {
         String name = "doFilter";
         Class<?> retType = void.class;
         Class<?>[] parms = {EventRequest.class, EventResponse.class};
         tr3.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: FilterChain_SIG_hasDoFilterB */
      /* Details: "Has a doFilter(RenderRequest, RenderResponse) throws java.io.IOException, PortletException method " */
      TestResult tr4 = tcd.getTestResultFailed(FILTERCHAIN_SIG_HASDOFILTERB);
      {
         String name = "doFilter";
         Class<?>[] exceptions = {java.io.IOException.class, PortletException.class};
         Class<?>[] parms = {RenderRequest.class, RenderResponse.class};
         tr4.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: FilterChain_SIG_hasDoFilterReturnsB */
      /* Details: "Method doFilter(RenderRequest, RenderResponse) returns void " */
      TestResult tr5 = tcd.getTestResultFailed(FILTERCHAIN_SIG_HASDOFILTERRETURNSB);
      {
         String name = "doFilter";
         Class<?> retType = void.class;
         Class<?>[] parms = {RenderRequest.class, RenderResponse.class};
         tr5.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: FilterChain_SIG_hasDoFilterC */
      /* Details: "Has a doFilter(ResourceRequest, ResourceResponse) throws java.io.IOException, PortletException method " */
      TestResult tr6 = tcd.getTestResultFailed(FILTERCHAIN_SIG_HASDOFILTERC);
      {
         String name = "doFilter";
         Class<?>[] exceptions = {java.io.IOException.class, PortletException.class};
         Class<?>[] parms = {ResourceRequest.class, ResourceResponse.class};
         tr6.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: FilterChain_SIG_hasDoFilterReturnsC */
      /* Details: "Method doFilter(ResourceRequest, ResourceResponse) returns void " */
      TestResult tr7 = tcd.getTestResultFailed(FILTERCHAIN_SIG_HASDOFILTERRETURNSC);
      {
         String name = "doFilter";
         Class<?> retType = void.class;
         Class<?>[] parms = {ResourceRequest.class, ResourceResponse.class};
         tr7.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
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


   }

}

