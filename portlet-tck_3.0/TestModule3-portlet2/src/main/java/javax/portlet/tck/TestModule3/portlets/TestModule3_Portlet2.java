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

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.tck.beans.TestMessage;
import javax.portlet.tck.beans.TestResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static javax.portlet.tck.beans.TestModule3Definitions.*;

/**
 * This test portlet contains several tests to generate render URLs and place them
 * into the markup. The test driver clicks the links to execute the tests.
 */
@SuppressWarnings("deprecation")
public class TestModule3_Portlet2 implements Portlet {

   private final Logger LOGGER = LoggerFactory.getLogger(TestModule3_Portlet2.class);

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


      String test = request.getParameter(TM3PRP0);
      if (test != null) {

         // Test: TestModule3_PublicRenderParameterTestDifferentPortletApplications
         // Details: A PRP set on the render URL is visible in companion portlet of 
         // a different portlet application. Same QName  & same identifier

         tr = tcd.getTestResultSucceeded(TEST0);
         tr.writeTo(writer);

         // Test: TestModule3_PublicRenderParameterTestDifferentQName
         // Details: A PRP matching identifier but differing QNames is not visible 
         // in companion portlet of different portlet application
         // (expected to fail)
         if (test.equals(TEST1)) {
            String val = request.getParameter(TM3PRP1);
            if (val == null) {
               tr = tcd.getTestResultSucceeded(TEST1);
            } else {
               tr = tcd.getTestResultFailed(TEST1);
               tr.appendTcDetail("Expected value of parameter " + TM3PRP1 + ": null, Actual value: " + val);
            }
            tr.writeTo(writer);
         } else {
            TestMessage tm = new TestMessage(TEST1, "Waiting for test to be executed.");
            tm.writeTo(writer);
         }

         // Test: TestModule3_PublicRenderParameterTestDifferentIdentifier
         // Details: A PRP with matching QName but differing identifier is visible in 
         // a companion portlet of different portlet application
         // (expected to succeed)
         if (test.equals(TEST2)) {
            String val = request.getParameter(TM3PRP2a);
            if (val != null) {
               tr = tcd.getTestResultSucceeded(TEST2);
            } else {
               tr = tcd.getTestResultFailed(TEST2);
               tr.appendTcDetail("Expected value of parameter " + TM3PRP2a + ": " + TM3PRP2 + ", Actual value: " + val);
            }
            tr.writeTo(writer);
         } else {
            TestMessage tm = new TestMessage(TEST2, "Waiting for test to be executed.");
            tm.writeTo(writer);
         }

      } else {
         // test not executed yet, or was not correctly executed
         TestMessage tm = new TestMessage(TEST0, "Waiting for " + TM3PRP0 + " to be set.");
         tm.writeTo(writer);
         tm = new TestMessage(TEST1, "Waiting for " + TM3PRP0 + " to be set.");
         tm.writeTo(writer);
         tm = new TestMessage(TEST2, "Waiting for " + TM3PRP0 + " to be set.");
         tm.writeTo(writer);
      }

   }

   @Override
   public void destroy() {
   }

}
