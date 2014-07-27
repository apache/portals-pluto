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
public class V2URLTests_SIG_PortletURLGenerationListener implements Portlet {
   private static final String LOG_CLASS = 
         V2URLTests_SIG_PortletURLGenerationListener.class.getName();
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
      ClassChecker cc = new ClassChecker(PortletURLGenerationListener.class);

      // Create result objects for the tests

      /* TestCase: PortletURLGenerationListener_SIG_hasFilterActionURL */
      /* Details: "Has a filterActionURL(PortletURL)  method " */
      TestResult tr0 = tcd.getTestResultFailed(PORTLETURLGENERATIONLISTENER_SIG_HASFILTERACTIONURL);
      {
         String name = "filterActionURL";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {PortletURL.class};
         tr0.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletURLGenerationListener_SIG_hasFilterActionURLReturns */
      /* Details: "Method filterActionURL(PortletURL) returns void " */
      TestResult tr1 = tcd.getTestResultFailed(PORTLETURLGENERATIONLISTENER_SIG_HASFILTERACTIONURLRETURNS);
      {
         String name = "filterActionURL";
         Class<?> retType = void.class;
         Class<?>[] parms = {PortletURL.class};
         tr1.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletURLGenerationListener_SIG_hasFilterRenderURL */
      /* Details: "Has a filterRenderURL(PortletURL)  method " */
      TestResult tr2 = tcd.getTestResultFailed(PORTLETURLGENERATIONLISTENER_SIG_HASFILTERRENDERURL);
      {
         String name = "filterRenderURL";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {PortletURL.class};
         tr2.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletURLGenerationListener_SIG_hasFilterRenderURLReturns */
      /* Details: "Method filterRenderURL(PortletURL) returns void " */
      TestResult tr3 = tcd.getTestResultFailed(PORTLETURLGENERATIONLISTENER_SIG_HASFILTERRENDERURLRETURNS);
      {
         String name = "filterRenderURL";
         Class<?> retType = void.class;
         Class<?>[] parms = {PortletURL.class};
         tr3.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }

      /* TestCase: PortletURLGenerationListener_SIG_hasFilterResourceURL */
      /* Details: "Has a filterResourceURL(ResourceURL)  method " */
      TestResult tr4 = tcd.getTestResultFailed(PORTLETURLGENERATIONLISTENER_SIG_HASFILTERRESOURCEURL);
      {
         String name = "filterResourceURL";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {ResourceURL.class};
         tr4.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      }

      /* TestCase: PortletURLGenerationListener_SIG_hasFilterResourceURLReturns */
      /* Details: "Method filterResourceURL(ResourceURL) returns void " */
      TestResult tr5 = tcd.getTestResultFailed(PORTLETURLGENERATIONLISTENER_SIG_HASFILTERRESOURCEURLRETURNS);
      {
         String name = "filterResourceURL";
         Class<?> retType = void.class;
         Class<?>[] parms = {ResourceURL.class};
         tr5.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      }



      // Write the results to the output stream

      tr0.writeTo(writer);
      tr1.writeTo(writer);
      tr2.writeTo(writer);
      tr3.writeTo(writer);
      tr4.writeTo(writer);
      tr5.writeTo(writer);


   }

}

