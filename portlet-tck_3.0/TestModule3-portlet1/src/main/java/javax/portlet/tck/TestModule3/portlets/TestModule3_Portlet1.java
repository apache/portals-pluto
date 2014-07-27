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

package javax.portlet.tck.TestModule3.portlets;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.tck.beans.TestCaseDetails;
import javax.portlet.tck.beans.TestLink;
import javax.portlet.tck.beans.TestResult;

/**
 * This test portlet contains several tests to generate render URLs and place them
 * into the markup. The test driver clicks the links to execute the tests.
 */
public class TestModule3_Portlet1 implements Portlet {
   private static final String LOG_CLASS = TestModule3_Portlet1.class.getName();

   // Tests defined in this portlet
   private final static String TEST0 = "TestModule3_PublicRenderParameterTestDifferentPortletApplications";          

   private final static TestCaseDetails tcd = initTests();
   private static TestCaseDetails initTests() {
      TestCaseDetails t = new TestCaseDetails();
      t.put(TEST0, "A PRP set on the render URL is visible in companion portlet of different portlet application .");
      return t;
   }

   private final Logger LOGGER = Logger.getLogger(LOG_CLASS);

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

      if (LOGGER.isLoggable(Level.FINE)) {
         LOGGER.logp(Level.FINE, LOG_CLASS, "render", "Entry");
      }

      PrintWriter writer = response.getWriter();
      TestResult tr = null;

      // Test: TestModule3_PublicRenderParameterTestDifferentPortletApplications
      // This portlet generates the link. The companion portlet 
      // displays the results.
      PortletURL purl1 = response.createRenderURL();
      purl1.setParameter("testModule3PRP", "testModule3PRP");
      TestLink tl = new TestLink(TEST0, purl1);
      tl.writeTo(writer);

   }

   @Override
   public void destroy() {
   }

}
