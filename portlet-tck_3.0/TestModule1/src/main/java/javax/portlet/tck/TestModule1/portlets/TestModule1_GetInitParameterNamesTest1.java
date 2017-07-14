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

package javax.portlet.tck.TestModule1.portlets;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.Enumeration;
import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.tck.beans.TestCaseDetails;
import javax.portlet.tck.beans.TestResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This portlet implements several test cases. The portlet name equals the first test case name
 * and is automatically added to the test case list during the build process. The additional
 * test case names must be added to the /src/main/resources/xml-resources/additionalTCs.xml
 * file manually. The build process will integrate the test case names defined in the 
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 */
public class TestModule1_GetInitParameterNamesTest1 implements Portlet {
   
   // Tests defined in this portlet
   private final static String TEST1 = "TestModule1_GetInitParameterNamesTest1"; 
   private final static String TEST2 = "TestModule1_GetPortletNameTest"; 
   private final static String TEST3 = "TestModule1_GetSupportedLocalesTest1"; 
   
   private final static TestCaseDetails tcd = initTests();
   private static TestCaseDetails initTests() {
      TestCaseDetails t = new TestCaseDetails();
      t.put(TEST1, "The PortletConfig object getInitParameterNames method returns enumeration of parameter names.");
      t.put(TEST2, "The PortletConfig object getInitParameter method returns the configured init pararameter.");
      t.put(TEST3, "The PortletConfig object getSupportedLocales method returns enumeration of supported locales.");
      return t;
   }
   
   private final Logger LOGGER = LoggerFactory.getLogger(TestModule1_GetInitParameterNamesTest1.class);

   private PortletConfig config = null;

   @Override
   public void init(PortletConfig config) throws PortletException {
      this.config = config;
   }

   @Override
   public void processAction(ActionRequest request, ActionResponse response)
         throws PortletException, IOException {
   }

   @Override
   public void render(RenderRequest request, RenderResponse response)
         throws PortletException, IOException {
      
      LOGGER.trace("render: Entry");

      PrintWriter writer = response.getWriter();
      
      // Create result objects for the tests
      TestResult tr0 = tcd.getTestResultFailed(TEST1);
      TestResult tr1 = tcd.getTestResultFailed(TEST2);
      TestResult tr2 = tcd.getTestResultFailed(TEST3);
      
      // Perform the actual tests
      if (config != null) {
         
         // 1st test
         Enumeration<String> strEnum = config.getInitParameterNames();
         if (strEnum == null) {
            tr0.appendTcDetail("Init Parameters Enumeration is null.");
         } else if (strEnum.hasMoreElements() == false) {
            tr0.appendTcDetail("No InitParameters are present.");
         } else {
            String pn = strEnum.nextElement();
            if (strEnum.hasMoreElements() == true) {
               tr0.appendTcDetail("Too many InitParameters present");
            } else if (!pn.equals("TestParameter")) {
               tr0.appendTcDetail("Wrong parameter name: " + pn);
            } else {
               tr0.setTcSuccess(true);
            }
         }

         // 2nd Test
         String val = config.getInitParameter("TestParameter");
         if (val == null) {
            tr1.appendTcDetail("Value of InitParameter \"TestParameter\" is null.");
         } else if  (val.equals("TestValue")) {
            tr1.setTcSuccess(true);
         } else {
            tr1.appendTcDetail("InitParameter value invalid. \"TestParameter\"=" + val);
         }
         
         // 3rd test
         Enumeration<Locale> locEnum = config.getSupportedLocales();
         if (locEnum == null) {
            tr2.appendTcDetail("Supported Locales Enumeration is null.");
         } else if (locEnum.hasMoreElements() == false) {
            tr2.appendTcDetail("No supported locales are present");
         } else {
            Locale loc = locEnum.nextElement();
            if (locEnum.hasMoreElements() == true) {
               tr2.appendTcDetail("Too many Locales present");
            } else if (!loc.toString().equalsIgnoreCase("en_US")) {
               tr2.appendTcDetail("Wrong Locale: " + loc);
            } else {
               tr2.setTcSuccess(true);
            }
         }
         
      }
      
      tr0.writeTo(writer);
      tr1.writeTo(writer);
      tr2.writeTo(writer);

   }

   @Override
   public void destroy() {
   }

}
