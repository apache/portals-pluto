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

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.portlet.PortletMode;

import org.apache.pluto.container.bean.processor.AnnotatedConfigBean;
import org.apache.pluto.container.bean.processor.AnnotatedMethodStore;
import org.apache.pluto.container.bean.processor.ConfigSummary;
import org.apache.pluto.container.bean.processor.PortletCDIExtension;
import org.apache.pluto.container.bean.processor.PortletInvoker;
import org.apache.pluto.container.bean.processor.fixtures.InvocationResults;
import org.apache.pluto.container.bean.processor.fixtures.render.Render1;
import org.apache.pluto.container.bean.processor.fixtures.render.Render2;
import org.apache.pluto.container.bean.processor.fixtures.mocks.MockRenderRequest;
import org.apache.pluto.container.bean.processor.fixtures.mocks.MockRenderResponse;
import org.jglue.cdiunit.AdditionalClasses;
import org.jglue.cdiunit.AdditionalPackages;
import org.jglue.cdiunit.CdiRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Test class for invoking the annotated render methods.
 * 
 * @author Scott Nicklous
 *
 */
@RunWith(CdiRunner.class)
@AdditionalClasses(PortletCDIExtension.class)
@AdditionalPackages(Render1.class)
public class InvokeRenderTest {
   
   @Inject
   private InvocationResults meths;
   
   private static final MockRenderRequest req = new MockRenderRequest();
   private static final MockRenderResponse resp = new MockRenderResponse();
   
   @Inject
   AnnotatedConfigBean acb;
   
   private AnnotatedMethodStore ams = null;
   private ConfigSummary summary = null;
   
   private static String DEFAULT_NS = "http://www.java.net/";
   
   @Before
   public void setUp() {
      assertNotNull(acb);
      ams = acb.getMethodStore();
      summary = acb.getSummary();
      
      assertNotNull(ams);
      assertNotNull(summary);
      ams.setDefaultNamespace(DEFAULT_NS);
   }
   
   @Test
   public void invoke1() throws Exception {
      meths.reset();
      PortletInvoker i = new PortletInvoker(acb, "portlet1");
      PortletMode mode = PortletMode.VIEW;
      req.setMode(mode);
      i.render(req, resp);
      List<String> names = meths.getMethods();
      assertNotNull(names);
      assertEquals(3, names.size());
      List<String> soll = Arrays.asList(new String[] {
            Render1.class.getSimpleName() + "#render1a",
            Render1.class.getSimpleName() + "#render1b",
            Render1.class.getSimpleName() + "#render1c"
            });
      for (String name : names) {
         assertTrue(soll.contains(name));
      }
   }
   
   @Test
   public void invoke1a() throws Exception {
      meths.reset();
      PortletInvoker i = new PortletInvoker(acb, "portlet1");
      PortletMode mode = PortletMode.HELP;
      req.setMode(mode);
      i.render(req, resp);
      List<String> names = meths.getMethods();
      assertNotNull(names);
      assertEquals(0, names.size());
   }
   
   @Test
   public void invoke1b() throws Exception {
      meths.reset();
      PortletInvoker i = new PortletInvoker(acb, "portlet1");
      PortletMode mode = new PortletMode("CustomMode");
      req.setMode(mode);
      i.render(req, resp);
      List<String> names = meths.getMethods();
      assertNotNull(names);
      assertEquals(0, names.size());
   }
   
   @Test
   public void invoke2() throws Exception {
      meths.reset();
      PortletInvoker i = new PortletInvoker(acb, "portlet2");
      PortletMode mode = PortletMode.VIEW;
      req.setMode(mode);
      i.render(req, resp);
      List<String> names = meths.getMethods();
      assertNotNull(names);
      assertEquals(0, names.size());
   }
   
   @Test
   public void invoke2a() throws Exception {
      meths.reset();
      PortletInvoker i = new PortletInvoker(acb, "portlet2");
      PortletMode mode = PortletMode.HELP;
      req.setMode(mode);
      i.render(req, resp);
      List<String> names = meths.getMethods();
      assertNotNull(names);
      assertEquals(1, names.size());
      List<String> soll = Arrays.asList(new String[] {
            Render1.class.getSimpleName() + "#render2a",
            });
      for (String name : names) {
         assertTrue(soll.contains(name));
      }
   }
   
   @Test
   public void invoke2b() throws Exception {
      meths.reset();
      PortletInvoker i = new PortletInvoker(acb, "portlet2");
      PortletMode mode = new PortletMode("Config");
      req.setMode(mode);
      i.render(req, resp);
      List<String> names = meths.getMethods();
      assertNotNull(names);
      assertEquals(1, names.size());
      List<String> soll = Arrays.asList(new String[] {
            Render1.class.getSimpleName() + "#render2c",
            });
      for (String name : names) {
         assertTrue(soll.contains(name));
      }
   }
   
   @Test
   public void invoke2c() throws Exception {
      meths.reset();
      PortletInvoker i = new PortletInvoker(acb, "portlet2");
      PortletMode mode = PortletMode.EDIT;
      req.setMode(mode);
      i.render(req, resp);
      List<String> names = meths.getMethods();
      assertNotNull(names);
      assertEquals(3, names.size());
      List<String> soll = Arrays.asList(new String[] {
            Render2.class.getSimpleName() + "#render2c",
            Render1.class.getSimpleName() + "#render2b",
            Render2.class.getSimpleName() + "#render2d",
            });
      assertArrayEquals(soll.toArray(), names.toArray());
   }
   
   @Test
   public void invoke3a() throws Exception {
      meths.reset();
      PortletInvoker i = new PortletInvoker(acb, "portlet3");
      PortletMode mode = PortletMode.HELP;
      req.setMode(mode);
      i.render(req, resp);
      List<String> names = meths.getMethods();
      assertNotNull(names);
      assertEquals(1, names.size());
      List<String> soll = Arrays.asList(new String[] {
            Render1.class.getSimpleName() + "#render3e"
            });
      assertArrayEquals(soll.toArray(), names.toArray());
   }
   
   @Test
   public void invoke3b() throws Exception {
      meths.reset();
      PortletInvoker i = new PortletInvoker(acb, "portlet3");
      PortletMode mode = PortletMode.VIEW;
      req.setMode(mode);
      i.render(req, resp);
      List<String> names = meths.getMethods();
      assertNotNull(names);
      assertEquals(3, names.size());
      List<String> soll = Arrays.asList(new String[] {
            Render1.class.getSimpleName() + "#render3c",
            Render1.class.getSimpleName() + "#render3a",
            Render1.class.getSimpleName() + "#render3b",
            });
      assertArrayEquals(soll.toArray(), names.toArray());
   }
   
   @Test
   public void invoke3c() throws Exception {
      meths.reset();
      PortletInvoker i = new PortletInvoker(acb, "portlet3");
      PortletMode mode = PortletMode.EDIT;
      req.setMode(mode);
      i.render(req, resp);
      List<String> names = meths.getMethods();
      assertNotNull(names);
      assertEquals(1, names.size());
      List<String> soll = Arrays.asList(new String[] {
            Render1.class.getSimpleName() + "#render3d",
            });
      assertArrayEquals(soll.toArray(), names.toArray());
   }
   
   @Test
   public void invoke6() throws Exception {
      meths.reset();
      PortletInvoker i = new PortletInvoker(acb, "portlet6");
      PortletMode mode = PortletMode.VIEW;
      req.setMode(mode);
      i.render(req, resp);
      List<String> names = meths.getMethods();
      assertEquals(2, names.size());
      List<String> soll = Arrays.asList(new String[] {
            Render2.class.getSimpleName() + "#render6and7", 
            Render2.class.getSimpleName() + "#render6andStar",
            });
      assertArrayEquals(soll.toArray(), names.toArray());
   }
   
   @Test
   public void invoke6a() throws Exception {
      meths.reset();
      PortletInvoker i = new PortletInvoker(acb, "portlet6");
      PortletMode mode = PortletMode.HELP;
      req.setMode(mode);
      i.render(req, resp);
      List<String> names = meths.getMethods();
      assertEquals(0, names.size());
   }
   
   @Test
   public void invoke7() throws Exception {
      meths.reset();
      PortletInvoker i = new PortletInvoker(acb, "portlet7");
      PortletMode mode = PortletMode.HELP;
      req.setMode(mode);
      i.render(req, resp);
      List<String> names = meths.getMethods();
      assertNotNull(names);
      assertEquals(0, names.size());
   }
   
   @Test
   public void invokeAdmin1() throws Exception {
      meths.reset();
      PortletInvoker i = new PortletInvoker(acb, "portlet1");
      PortletMode mode = new PortletMode("admin");
      req.setMode(mode);
      i.render(req, resp);
      List<String> names = meths.getMethods();
      assertNotNull(names);
      assertEquals(1, names.size());
      List<String> soll = Arrays.asList(new String[] {
            Render2.class.getSimpleName() + "#renderAll"
            });
      assertArrayEquals(soll.toArray(), names.toArray());
   }
   
   @Test
   public void invokeAdmin2() throws Exception {
      meths.reset();
      PortletInvoker i = new PortletInvoker(acb, "portlet2");
      PortletMode mode = new PortletMode("admin");
      req.setMode(mode);
      i.render(req, resp);
      List<String> names = meths.getMethods();
      assertNotNull(names);
      assertEquals(1, names.size());
      List<String> soll = Arrays.asList(new String[] {
            Render2.class.getSimpleName() + "#renderAll"
            });
      assertArrayEquals(soll.toArray(), names.toArray());
   }
   
   @Test
   public void invokeAdmin3() throws Exception {
      meths.reset();
      PortletInvoker i = new PortletInvoker(acb, "portlet3");
      PortletMode mode = new PortletMode("admin");
      req.setMode(mode);
      i.render(req, resp);
      List<String> names = meths.getMethods();
      assertNotNull(names);
      assertEquals(1, names.size());
      List<String> soll = Arrays.asList(new String[] {
            Render2.class.getSimpleName() + "#renderAll"
            });
      assertArrayEquals(soll.toArray(), names.toArray());
   }
   
   @Test
   public void invokeAdmin4() throws Exception {
      meths.reset();
      PortletInvoker i = new PortletInvoker(acb, "portlet4");
      PortletMode mode = new PortletMode("admin");
      req.setMode(mode);
      i.render(req, resp);
      List<String> names = meths.getMethods();
      assertNotNull(names);
      assertEquals(0, names.size());
   }
   
   @Test
   public void invokeAdmin5() throws Exception {
      meths.reset();
      PortletInvoker i = new PortletInvoker(acb, "portlet5");
      PortletMode mode = new PortletMode("admin");
      req.setMode(mode);
      i.render(req, resp);
      List<String> names = meths.getMethods();
      assertNotNull(names);
      assertEquals(0, names.size());
   }
   
   @Test
   public void invokeAdmin8() throws Exception {
      meths.reset();
      PortletInvoker i = new PortletInvoker(acb, "portlet8");
      PortletMode mode = new PortletMode("admin");
      req.setMode(mode);
      i.render(req, resp);
      List<String> names = meths.getMethods();
      assertNotNull(names);
      assertEquals(0, names.size());
   }
   
   @Test
   public void invokeAdmin7() throws Exception {
      meths.reset();
      PortletInvoker i = new PortletInvoker(acb, "portlet7");
      PortletMode mode = new PortletMode("admin");
      req.setMode(mode);
      i.render(req, resp);
      List<String> names = meths.getMethods();
      assertNotNull(names);
      assertEquals(1, names.size());
      List<String> soll = Arrays.asList(new String[] {
            Render2.class.getSimpleName() + "#renderAll"
            });
      assertArrayEquals(soll.toArray(), names.toArray());
   }
   
}
