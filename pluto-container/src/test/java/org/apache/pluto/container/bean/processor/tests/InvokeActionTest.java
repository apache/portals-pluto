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


package org.apache.pluto.container.bean.processor.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.apache.pluto.container.bean.processor.AnnotatedConfigBean;
import org.apache.pluto.container.bean.processor.AnnotatedMethodStore;
import org.apache.pluto.container.bean.processor.ConfigSummary;
import org.apache.pluto.container.bean.processor.PortletCDIExtension;
import org.apache.pluto.container.bean.processor.PortletInvoker;
import org.apache.pluto.container.bean.processor.fixtures.InvocationResults;
import org.apache.pluto.container.bean.processor.fixtures.action.Action1;
import org.apache.pluto.container.bean.processor.fixtures.action.Action2;
import org.apache.pluto.container.bean.processor.fixtures.mocks.MockActionRequest;
import org.apache.pluto.container.bean.processor.fixtures.mocks.MockActionResponse;
import org.jglue.cdiunit.AdditionalClasses;
import org.jglue.cdiunit.AdditionalPackages;
import org.jglue.cdiunit.CdiRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Test class for invoking the annotated action methods.
 * 
 * @author Scott Nicklous
 *
 */
@RunWith(CdiRunner.class)
@AdditionalClasses(PortletCDIExtension.class)
@AdditionalPackages(Action1.class)
public class InvokeActionTest {
   
   @Inject
   private InvocationResults meths;
   
   private static MockActionRequest req = new MockActionRequest();
   private static MockActionResponse resp = new MockActionResponse();
   
   @Inject
   AnnotatedConfigBean acb;
   
   private AnnotatedMethodStore ams = null;
   private ConfigSummary summary = null;
   
   @Before
   public void setUp() {
      assertNotNull(acb);
      ams = acb.getMethodStore();
      summary = acb.getSummary();
      
      assertNotNull(ams);
      assertNotNull(summary);
   }
   
   @Test
   public void invoke1() throws Exception {
      meths.reset();
      PortletInvoker i = new PortletInvoker(acb, "portlet1");
      req.setActionName(null);
      i.processAction(req, resp);
      List<String> names = meths.getMethods();
      assertNotNull(names);
      assertEquals(1, names.size());
      assertTrue(names.contains(Action1.class.getSimpleName() + "#action1"));
   }
   
   @Test
   public void invoke2() throws Exception {
      meths.reset();
      PortletInvoker i = new PortletInvoker(acb, "portlet2");
      req.setActionName(null);
      i.processAction(req, resp);
      List<String> names = meths.getMethods();
      // there are two valid possibilities
      List<String> meths = Arrays.asList(new String[] {
            Action1.class.getSimpleName() + "#action2", 
            Action2.class.getSimpleName() + "#action2",
            });
      assertNotNull(names);
      assertEquals(1, names.size());
      assertTrue(meths.contains(names.get(0)));
   }
   
   @Test
   public void invoke3a() throws Exception {
      meths.reset();
      PortletInvoker i = new PortletInvoker(acb, "portlet3");
      req.setActionName("");
      i.processAction(req, resp);
      List<String> names = meths.getMethods();
      assertNotNull(names);
      assertEquals(1, names.size());
      assertTrue(names.contains(Action2.class.getSimpleName() + "#action1a"));
   }
   
   @Test
   public void invoke3b() throws Exception {
      meths.reset();
      PortletInvoker i = new PortletInvoker(acb, "portlet3");
      req.setActionName("Fred");
      i.processAction(req, resp);
      List<String> names = meths.getMethods();
      assertNotNull(names);
      assertEquals(1, names.size());
      assertTrue(names.contains(Action2.class.getSimpleName() + "#action1b"));
   }
   
   @Test
   public void invoke3c() throws Exception {
      meths.reset();
      PortletInvoker i = new PortletInvoker(acb, "portlet3");
      req.setActionName("Barney");
      i.processAction(req, resp);
      List<String> names = meths.getMethods();
      assertNotNull(names);
      assertEquals(1, names.size());
      assertTrue(names.contains(Action2.class.getSimpleName() + "#action1c"));
   }
   
   @Test
   public void invoke6() throws Exception {
      meths.reset();
      PortletInvoker i = new PortletInvoker(acb, "portlet6");
      req.setActionName("Wilma");
      i.processAction(req, resp);
      List<String> names = meths.getMethods();
      // there are two valid possibilities
      List<String> meths = Arrays.asList(new String[] {
            Action2.class.getSimpleName() + "#action6", 
            Action2.class.getSimpleName() + "#action7",
            });
      assertNotNull(names);
      assertEquals(1, names.size());
      assertTrue(meths.contains(names.get(0)));
   }
   
}
