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

package javax.portlet.tck.TestModule2.portlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.tck.beans.TestCaseDetails;
import javax.portlet.tck.beans.TestMessage;
import javax.portlet.tck.beans.TestResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This test portlet contains several tests to generate render URLs and place them
 * into the markup. The test driver clicks the links to execute the tests.
 */
@SuppressWarnings("deprecation")
public class TestModule2_CompanionPortlet implements Portlet {

   // Tests defined in this portlet
   private final static String TEST4 = "TestModule2_PublicRenderParameterCanBeSetThroughUrl";   

   private final static TestCaseDetails tcd = initTests();
   private static TestCaseDetails initTests() {
      TestCaseDetails t = new TestCaseDetails();
      t.put(TEST4, "A public render parameter can be set on the render URL and is visible in companion portlet.");
      return t;
   }

   private final Logger LOGGER = LoggerFactory.getLogger(TestModule2_CompanionPortlet.class);

   @Override
   public void init(PortletConfig config) throws PortletException {
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
      TestResult tr = null;

      // Test: TestModule2_PublicRenderParameterCanBeSetThroughUrl
      // The link with the public render parameter is generated 
      // by the main portlet.
      String parm = request.getParameter("publicRenderParameter1");
      if (parm != null) {
         // test was executed so generate results
         tr = tcd.getTestResultSucceeded(TEST4);
         tr.writeTo(writer);
      } else {
         // test not executed yet, or was not correctly executed
         TestMessage tm = new TestMessage(TEST4, "Waiting for publicRenderParameter1 to be set.");
         tm.writeTo(writer);
      }

   }

   @Override
   public void destroy() {
   }

}
