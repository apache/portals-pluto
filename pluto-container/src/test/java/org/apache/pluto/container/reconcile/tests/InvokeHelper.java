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


package org.apache.pluto.container.reconcile.tests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.portlet.PortletMode;
import javax.xml.namespace.QName;

import org.apache.pluto.container.bean.processor.AnnotatedMethodStore;
import org.apache.pluto.container.bean.processor.PortletInvoker;
import org.apache.pluto.container.bean.processor.fixtures.InvocationResults;
import org.apache.pluto.container.bean.processor.fixtures.mocks.MockActionRequest;
import org.apache.pluto.container.bean.processor.fixtures.mocks.MockActionResponse;
import org.apache.pluto.container.bean.processor.fixtures.mocks.MockEventRequest;
import org.apache.pluto.container.bean.processor.fixtures.mocks.MockEventResponse;
import org.apache.pluto.container.bean.processor.fixtures.mocks.MockHeaderRequest;
import org.apache.pluto.container.bean.processor.fixtures.mocks.MockHeaderResponse;
import org.apache.pluto.container.bean.processor.fixtures.mocks.MockPortletConfig;
import org.apache.pluto.container.bean.processor.fixtures.mocks.MockRenderRequest;
import org.apache.pluto.container.bean.processor.fixtures.mocks.MockRenderResponse;
import org.apache.pluto.container.bean.processor.fixtures.mocks.MockResourceRequest;
import org.apache.pluto.container.bean.processor.fixtures.mocks.MockResourceResponse;

/**
 * helper class for invoking portlet methods.
 * 
 * @author Scott Nicklous
 *
 */
public class InvokeHelper {
   
   private InvocationResults meths = InvocationResults.getInvocationResults();
   
   private final AnnotatedMethodStore ams;
   
   private static MockPortletConfig config = new MockPortletConfig();
   
   private static MockActionRequest  reqAction  = new MockActionRequest();
   private static MockActionResponse respAction = new MockActionResponse();
   
   private static MockEventRequest  reqEvent  = new MockEventRequest();
   private static MockEventResponse respEvent = new MockEventResponse();
   
   private static MockHeaderRequest  reqHeader  = new MockHeaderRequest();
   private static MockHeaderResponse respHeader = new MockHeaderResponse();
   
   private static MockRenderRequest  reqRender  = new MockRenderRequest();
   private static MockRenderResponse respRender = new MockRenderResponse();
   
   private static MockResourceRequest  reqResource  = new MockResourceRequest();
   private static MockResourceResponse respResource = new MockResourceResponse();

   public InvokeHelper(AnnotatedMethodStore ams) {
      this.ams = ams;
   }
   
   public void init(String portlet, String methName) throws Exception {
      meths.reset();
      PortletInvoker i = new PortletInvoker(ams, portlet);
      i.init(config);
      checkName(methName);
   }
   
   public void destroy(String portlet, String methName) throws Exception {
      meths.reset();
      PortletInvoker i = new PortletInvoker(ams, portlet, config);
      i.destroy();
      checkName(methName);
   }
   
   public void action(String portlet, String actName, String methName) throws Exception {
      meths.reset();
      PortletInvoker i = new PortletInvoker(ams, portlet, config);
      reqAction.setActionName(actName);
      i.processAction(reqAction, respAction);
      checkName(methName);
   }
   
   public void event(String portlet, QName qn, String methName) throws Exception {
      meths.reset();
      PortletInvoker i = new PortletInvoker(ams, portlet, config);
      reqEvent.setQn(qn);
      i.processEvent(reqEvent, respEvent);
      checkName(methName);
   }
   
   public void header(String portlet, PortletMode pm, String methName) throws Exception {
      meths.reset();
      PortletInvoker i = new PortletInvoker(ams, portlet, config);
      reqHeader.setMode(pm);
      i.renderHeaders(reqHeader, respHeader);
      checkName(methName);
   }
   
   public void render(String portlet, PortletMode pm, String methName) throws Exception {
      meths.reset();
      PortletInvoker i = new PortletInvoker(ams, portlet, config);
      reqRender.setMode(pm);
      i.render(reqRender, respRender);
      checkName(methName);
   }
   
   // used when a doHeaders call is expected (test portlet extends GenericPorlet)
   public void renderWithHeaders(String portlet, PortletMode pm, List<String> methNames) throws Exception {
      meths.reset();
      PortletInvoker i = new PortletInvoker(ams, portlet, config);
      reqRender.setMode(pm);
      i.render(reqRender, respRender);
      List<String> names = meths.getMethods();
      assertNotNull(names);
      if (methNames != null) {
         if (!names.containsAll(methNames)) {
            System.out.println("checkName returned method names: " + names.toString());
         }
         assertEquals(methNames.size(), names.size());
         assertArrayEquals(methNames.toArray(), names.toArray());
      }
   }
   
   public void resource(String portlet, String resid, String methName) throws Exception {
      meths.reset();
      PortletInvoker i = new PortletInvoker(ams, portlet, config);
      reqResource.setResourceId(resid);
      i.serveResource(reqResource, respResource);
      checkName(methName);
   }
   
   public void checkName(String methName) {
      List<String> names = meths.getMethods();
      assertNotNull(names);
      if (methName != null) {
         if (!names.contains(methName) || names.size() != 1) {
            System.out.println("checkName returned method names: " + names.toString());
         }
         assertEquals(1, names.size());
         assertTrue(names.contains(methName));
      }
   }

}
