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
public class V2FilterTests_SIG_PortletFilter implements Portlet {
   private static final String LOG_CLASS = 
         V2FilterTests_SIG_PortletFilter.class.getName();
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
      ClassChecker cc = new ClassChecker(PortletFilter.class);

      // Create result objects for the tests

      /* TestCase: PortletFilter_SIG_hasInit */
      /* Details: "Has a init(FilterConfig) throws PortletException method " */
      TestResult tr0 = tcd.getTestResultFailed(PORTLETFILTER_SIG_HASINIT);
      {
         String name = "init";
         Class<?>[] exceptions = {PortletException.class};
         Class<?>[] parms = {FilterConfig.class};
         tr0.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletFilter_SIG_hasInitReturns */
      /* Details: "Method init(FilterConfig) returns void " */
      TestResult tr1 = tcd.getTestResultFailed(PORTLETFILTER_SIG_HASINITRETURNS);
      {
         String name = "init";
         Class<?> retType = void.class;
         Class<?>[] parms = {FilterConfig.class};
         tr1.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletFilter_SIG_hasDestroy */
      /* Details: "Has a destroy()  method " */
      TestResult tr2 = tcd.getTestResultFailed(PORTLETFILTER_SIG_HASDESTROY);
      {
         String name = "destroy";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr2.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletFilter_SIG_hasDestroyReturns */
      /* Details: "Method destroy() returns void " */
      TestResult tr3 = tcd.getTestResultFailed(PORTLETFILTER_SIG_HASDESTROYRETURNS);
      {
         String name = "destroy";
         Class<?> retType = void.class;
         Class<?>[] parms = null;
         tr3.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }



      // Write the results to the output stream

      tr0.writeTo(writer);
      tr1.writeTo(writer);
      tr2.writeTo(writer);
      tr3.writeTo(writer);


   }

}

