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

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.tck.beans.TestResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This test portlet contains a single test case. The test case name is 
 * equal to the portlet name. The test case name will be added to the test 
 * case list automatically during the build process.
 */
public class TestModule1_PortletCanBeRendered implements Portlet {

   private static final String tcName = "TestModule1_PortletCanBeRendered";
   private static final String tcDetail = "The test result text is displayed.";
   
   private final Logger LOGGER = LoggerFactory.getLogger(TestModule1_PortletCanBeRendered.class);

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
      
      TestResult tr = new TestResult(tcName, true, tcDetail);
      tr.writeTo(writer);

   }

   @Override
   public void destroy() {
   }

}
