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
import javax.portlet.PortletSession;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.tck.beans.TestCaseDetails;
import javax.portlet.tck.beans.TestLink;
import javax.portlet.tck.beans.TestResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This test portlet contains several tests to generate render URLs and place them
 * into the markup. The test driver clicks the links to execute the tests.
 */
@SuppressWarnings("deprecation")
public class TestModule2_CanCreateRenderURL implements Portlet {

   // Tests defined in this portlet
   private final static String TEST0 = "TestModule2_CanCreateRenderURL";          
   private final static String TEST1 = "TestModule2_CanGetPortletSession"; 
   private final static String TEST2 = "TestModule2_CanSetAttributeInPortletSession"; 
   private final static String TEST3 = "TestModule2_RenderURLWithParameterCanBeClicked";   
   private final static String TEST4 = "TestModule2_PublicRenderParameterCanBeSetThroughUrl";   

   private final static TestCaseDetails tcd = initTests();
   private static TestCaseDetails initTests() {
      TestCaseDetails t = new TestCaseDetails();
      t.put(TEST0, "A render URL is created for the portlet.");
      t.put(TEST1, "A portlet session object can be obtained from the render request.");
      t.put(TEST2, "An attribute can be set and retrieved from the portlet session.");
      t.put(TEST3, "A render URL in the markup containing a render parameter is clicked and the portlet is rendered.");
      t.put(TEST4, "A public render parameter can be set on the render URL and is visible in companion portlet.");
      return t;
   }

   private final Logger LOGGER = LoggerFactory.getLogger(TestModule2_CanCreateRenderURL.class);

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

      // Test: TestModule2_CanCreateRenderURL
      tr = tcd.getTestResultSucceeded(TEST0);
      PortletURL purl = response.createRenderURL();
      if (purl == null) {
         tr.setTcSuccess(false);
         tr.appendTcDetail("PortletURL object is null");
      }
      tr.writeTo(writer);

      // Test: TestModule2_CanGetPortletSession
      tr = tcd.getTestResultSucceeded(TEST1);
      PortletSession ps = request.getPortletSession();
      if (ps == null) {
         tr.setTcSuccess(false);
         tr.appendTcDetail("PortletSession object is null");
      }
      tr.writeTo(writer);

      // Test: TestModule2_CanSetAttributeInPortletSession
      tr = tcd.getTestResultFailed(TEST2);
      if (ps != null) {
         ps.setAttribute("Attri", tr);
         try {
            TestResult tr1 = (TestResult) ps.getAttribute("Attri");
            if (tr.getTcName().equals(tr1.getTcName())) {
               tr.setTcSuccess(true);
            } else {
               tr.appendTcDetail("Attribute did not match original value.");
            }
         } catch(Exception e) {
            tr.appendTcDetail("Could not retrieve attribute.");
         }
      }
      tr.writeTo(writer);

      // Test: TestModule2_RenderURLCanBeClicked
      tr = tcd.getTestResultFailed(TEST3);
      String parm = request.getParameter(TEST3);
      if (parm != null) {
         // test was executed so generate results
         tr.setTcSuccess(true);
         writer.write(tr.toString());
      } else {
         // test not executed yet, or was not correctly executed
         purl.setParameter(TEST3, TEST3);
         TestLink tl = new TestLink(TEST3, purl);
         tl.writeTo(writer);
      }

      // Test: TestModule2_PublicRenderParameterCanBeSetThroughUrl
      // This portlet generates the link. The companion portlet 
      // displays the results.
      PortletURL purl1 = response.createRenderURL();
      purl1.setParameter("publicRenderParameter1", "publicRenderParameter1");
      TestLink tl = new TestLink(TEST4, purl1);
      tl.writeTo(writer);

   }

   @Override
   public void destroy() {
   }

}
