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

package javax.portlet.tck.portlets;

import static javax.portlet.tck.constants.Constants.THREADID_ATTR;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3PORTLETCONFIGTESTS_CONFIG_INIT;

import java.io.IOException;
import java.io.PrintWriter;

import javax.enterprise.context.ApplicationScoped;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.annotations.InitMethod;
import javax.portlet.annotations.RenderMethod;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.util.ModuleTestCaseDetails;

/**
 * Implements test to verify that the annotated init method is called.
 */
@ApplicationScoped
public class PortletConfigTests_ConfigInit {

   PortletConfig portletConfig;

   @InitMethod("PortletConfigTests_ConfigInit")
   public void annotatedInit(PortletConfig config) {
      portletConfig = config;
   }

   @RenderMethod(portletNames = "PortletConfigTests_ConfigInit")
   public void render(RenderRequest portletReq, RenderResponse portletResp) throws PortletException, IOException {

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

      ModuleTestCaseDetails tcd = new ModuleTestCaseDetails();

      /* TestCase: PortletConfigTests_Config_init */
      /* Details: "The PortletConfig object is passed to an annotated */
      /* init method" */
      {
         TestResult result = tcd.getTestResultFailed(V3PORTLETCONFIGTESTS_CONFIG_INIT);
         if (portletConfig != null) {
            result.setTcSuccess(true);
         }
         result.writeTo(writer);
      }

   }

}
