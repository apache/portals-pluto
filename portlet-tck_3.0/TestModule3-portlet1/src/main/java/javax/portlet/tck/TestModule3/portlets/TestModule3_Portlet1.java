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
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.tck.beans.TestLink;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static javax.portlet.tck.beans.TestModule3Definitions.*;

/**
 * This test portlet contains several tests to generate render URLs and place them
 * into the markup. The test driver clicks the links to execute the tests.
 */
@SuppressWarnings("deprecation")
public class TestModule3_Portlet1 implements Portlet {

   private final Logger LOGGER = LoggerFactory.getLogger(TestModule3_Portlet1.class);

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

      PortletURL purl;
      TestLink tl;

      // Test: TestModule3_PublicRenderParameterTestDifferentPortletApplications
      // This portlet generates the link. The companion portlet displays the results.
      purl = response.createRenderURL();
      purl.setParameter(TM3PRP0, TEST0);
      tl = new TestLink(TEST0, purl);
      tl.writeTo(writer);

      // Test: TestModule3_PublicRenderParameterTestDifferentQName
      // This portlet generates the link. The companion portlet displays the results.
      purl = response.createRenderURL();
      purl.setParameter(TM3PRP0, TEST1);
      purl.setParameter(TM3PRP1, TM3PRP1);
      tl = new TestLink(TEST1, purl);
      tl.writeTo(writer);

      // Test: TestModule3_PublicRenderParameterTestDifferentIdentifier
      // This portlet generates the link. The companion portlet displays the results.
      purl = response.createRenderURL();
      purl.setParameter(TM3PRP0, TEST2);
      purl.setParameter(TM3PRP2, TM3PRP2);
      tl = new TestLink(TEST2, purl);
      tl.writeTo(writer);

   }

   @Override
   public void destroy() {
   }

}
