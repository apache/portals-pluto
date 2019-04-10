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

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.apache.pluto.container.bean.processor.AnnotatedMethodStore;
import org.apache.pluto.container.bean.processor.ConfigSummary;
import org.apache.pluto.container.bean.processor.PortletInvoker;
import org.apache.pluto.container.bean.processor.fixtures.InvocationResults;
import org.apache.pluto.container.bean.processor.fixtures.mocks.MockResourceRequest;
import org.apache.pluto.container.bean.processor.fixtures.mocks.MockResourceResponse;
import org.apache.pluto.container.bean.processor.fixtures.resource.Resource1;
import org.apache.pluto.container.bean.processor.fixtures.resource.Resource2;
import org.apache.pluto.container.om.portlet.PortletApplicationDefinition;
import org.apache.pluto.container.om.portlet.impl.ConfigurationHolder;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test class for invoking the annotated resource methods.
 * 
 * @author Scott Nicklous
 *
 */
public class InvokeResourceTest {
   
   private InvocationResults meths = InvocationResults.getInvocationResults();
   
   private static final MockResourceRequest req = new MockResourceRequest();
   private static final MockResourceResponse resp = new MockResourceResponse();
   
   private static final String pkg = "org.apache.pluto.container.bean.processor.fixtures.resource";
   
   private static AnnotatedMethodStore ams = null;
   private static ConfigSummary summary = null;
   private static ConfigurationHolder holder =  new ConfigurationHolder();
   private static PortletApplicationDefinition pad = null;
   
   @BeforeClass
   public static void setUpClass() throws URISyntaxException, IOException {
      Set<File> classes = FileHelper.getClasses(pkg);
      holder.scanMethodAnnotations(classes);
      holder.reconcileBeanConfig();
      holder.instantiatePortlets(null);
      ams = holder.getMethodStore();
      summary = holder.getConfigSummary();
      pad = holder.getPad();
      
      assertNotNull(ams);
      assertNotNull(summary);
      assertNotNull(pad);
   }
   
   @Test
   public void invoke1() throws Exception {
      meths.reset();
      PortletInvoker i = new PortletInvoker(ams, "portlet1");
      String resid = "VIEW";
      req.setResourceId(resid);
      i.serveResource(req, resp);
      List<String> names = meths.getMethods();
      assertNotNull(names);
      assertEquals(3, names.size());
      List<String> soll = Arrays.asList(new String[] {
            Resource1.class.getSimpleName() + "#resource1a",
            Resource1.class.getSimpleName() + "#resource1b",
            Resource1.class.getSimpleName() + "#resource1c"
            });
      for (String name : names) {
         assertTrue(soll.contains(name));
      }
   }
   
   @Test
   public void invoke1a() throws Exception {
      meths.reset();
      PortletInvoker i = new PortletInvoker(ams, "portlet1");
      String resid = "HELP";
      req.setResourceId(resid);
      i.serveResource(req, resp);
      List<String> names = meths.getMethods();
      assertNotNull(names);
      assertEquals(3, names.size());
      List<String> soll = Arrays.asList(new String[] {
            Resource1.class.getSimpleName() + "#resource1a",
            Resource1.class.getSimpleName() + "#resource1b",
            Resource1.class.getSimpleName() + "#resource1c"
            });
      for (String name : names) {
         assertTrue(soll.contains(name));
      }
   }
   
   @Test
   public void invoke1b() throws Exception {
      meths.reset();
      PortletInvoker i = new PortletInvoker(ams, "portlet1");
      String resid = "CustomMode";
      req.setResourceId(resid);
      i.serveResource(req, resp);
      List<String> names = meths.getMethods();
      assertNotNull(names);
      assertEquals(3, names.size());
      List<String> soll = Arrays.asList(new String[] {
            Resource1.class.getSimpleName() + "#resource1a",
            Resource1.class.getSimpleName() + "#resource1b",
            Resource1.class.getSimpleName() + "#resource1c"
            });
      for (String name : names) {
         assertTrue(soll.contains(name));
      }
   }
   
   @Test
   public void invoke2() throws Exception {
      meths.reset();
      PortletInvoker i = new PortletInvoker(ams, "portlet2");
      String resid = "VIEW";
      req.setResourceId(resid);
      i.serveResource(req, resp);
      List<String> names = meths.getMethods();
      assertNotNull(names);
      assertEquals(0, names.size());
   }
   
   @Test
   public void invoke2a() throws Exception {
      meths.reset();
      PortletInvoker i = new PortletInvoker(ams, "portlet2");
      String resid = "help";
      req.setResourceId(resid);
      i.serveResource(req, resp);
      List<String> names = meths.getMethods();
      assertNotNull(names);
      assertEquals(1, names.size());
      List<String> soll = Arrays.asList(new String[] {
            Resource1.class.getSimpleName() + "#resource2a",
            });
      for (String name : names) {
         assertTrue(soll.contains(name));
      }
   }
   
   @Test
   public void invoke2b() throws Exception {
      meths.reset();
      PortletInvoker i = new PortletInvoker(ams, "portlet2");
      String resid = "config";
      req.setResourceId(resid);
      i.serveResource(req, resp);
      List<String> names = meths.getMethods();
      assertNotNull(names);
      assertEquals(1, names.size());
      List<String> soll = Arrays.asList(new String[] {
            Resource1.class.getSimpleName() + "#resource2c",
            });
      for (String name : names) {
         assertTrue(soll.contains(name));
      }
   }
   
   @Test
   public void invoke2c() throws Exception {
      meths.reset();
      PortletInvoker i = new PortletInvoker(ams, "portlet2");
      String resid = "edit";
      req.setResourceId(resid);
      i.serveResource(req, resp);
      List<String> names = meths.getMethods();
      assertNotNull(names);
      assertEquals(3, names.size());
      List<String> soll = Arrays.asList(new String[] {
            Resource2.class.getSimpleName() + "#resource2c",
            Resource1.class.getSimpleName() + "#resource2b",
            Resource2.class.getSimpleName() + "#resource2d",
            });
      assertArrayEquals(soll.toArray(), names.toArray());
   }
   
   @Test
   public void invoke2d() throws Exception {
      meths.reset();
      PortletInvoker i = new PortletInvoker(ams, "portlet2");
      // resource ID match is case-sensitive
      String resid = "eDit";
      req.setResourceId(resid);
      i.serveResource(req, resp);
      List<String> names = meths.getMethods();
      assertNotNull(names);
      assertEquals(0, names.size());
   }
   
   @Test
   public void invoke3a() throws Exception {
      meths.reset();
      PortletInvoker i = new PortletInvoker(ams, "portlet3");
      String resid = "help";
      req.setResourceId(resid);
      i.serveResource(req, resp);
      List<String> names = meths.getMethods();
      assertNotNull(names);
      assertEquals(1, names.size());
      List<String> soll = Arrays.asList(new String[] {
            Resource1.class.getSimpleName() + "#resource3e"
            });
      assertArrayEquals(soll.toArray(), names.toArray());
   }
   
   @Test
   public void invoke3b() throws Exception {
      meths.reset();
      PortletInvoker i = new PortletInvoker(ams, "portlet3");
      String resid = "VIEW";
      req.setResourceId(resid);
      i.serveResource(req, resp);
      List<String> names = meths.getMethods();
      assertNotNull(names);
      assertEquals(3, names.size());
      List<String> soll = Arrays.asList(new String[] {
            Resource1.class.getSimpleName() + "#resource3c",
            Resource1.class.getSimpleName() + "#resource3a",
            Resource1.class.getSimpleName() + "#resource3b",
            });
      assertArrayEquals(soll.toArray(), names.toArray());
   }
   
   @Test
   public void invoke6() throws Exception {
      meths.reset();
      PortletInvoker i = new PortletInvoker(ams, "portlet6");
      String resid = "VIEW";
      req.setResourceId(resid);
      i.serveResource(req, resp);
      List<String> names = meths.getMethods();
      assertEquals(2, names.size());
      List<String> soll = Arrays.asList(new String[] {
            Resource2.class.getSimpleName() + "#resource6and7", 
            Resource2.class.getSimpleName() + "#resource6andStar",
            });
      assertArrayEquals(soll.toArray(), names.toArray());
   }
   
   @Test
   public void invoke6a() throws Exception {
      meths.reset();
      PortletInvoker i = new PortletInvoker(ams, "portlet6");
      String resid = "HELP";
      req.setResourceId(resid);
      i.serveResource(req, resp);
      List<String> names = meths.getMethods();
      assertEquals(2, names.size());
      List<String> soll = Arrays.asList(new String[] {
            Resource2.class.getSimpleName() + "#resource6and7", 
            Resource2.class.getSimpleName() + "#resource6andStar",
            });
      assertArrayEquals(soll.toArray(), names.toArray());
   }
   
   @Test
   public void invoke7() throws Exception {
      meths.reset();
      PortletInvoker i = new PortletInvoker(ams, "portlet7");
      String resid = "HELP";
      req.setResourceId(resid);
      i.serveResource(req, resp);
      List<String> names = meths.getMethods();
      assertNotNull(names);
      assertEquals(1, names.size());
      List<String> soll = Arrays.asList(new String[] {
            Resource2.class.getSimpleName() + "#resource6and7"
            });
      assertArrayEquals(soll.toArray(), names.toArray());
   }
   
   @Test
   public void invokeAdmin1() throws Exception {
      meths.reset();
      PortletInvoker i = new PortletInvoker(ams, "portlet1");
      String resid = "admin";
      req.setResourceId(resid);
      i.serveResource(req, resp);
      List<String> names = meths.getMethods();
      assertNotNull(names);
      assertEquals(1, names.size());
      List<String> soll = Arrays.asList(new String[] {
            Resource2.class.getSimpleName() + "#resourceAll"
            });
      assertArrayEquals(soll.toArray(), names.toArray());
   }
   
   @Test
   public void invokeAdmin2() throws Exception {
      meths.reset();
      PortletInvoker i = new PortletInvoker(ams, "portlet2");
      String resid = "admin";
      req.setResourceId(resid);
      i.serveResource(req, resp);
      List<String> names = meths.getMethods();
      assertNotNull(names);
      assertEquals(1, names.size());
      List<String> soll = Arrays.asList(new String[] {
            Resource2.class.getSimpleName() + "#resourceAll"
            });
      assertArrayEquals(soll.toArray(), names.toArray());
   }
   
   @Test
   public void invokeAdmin3() throws Exception {
      meths.reset();
      PortletInvoker i = new PortletInvoker(ams, "portlet3");
      String resid = "admin";
      req.setResourceId(resid);
      i.serveResource(req, resp);
      List<String> names = meths.getMethods();
      assertNotNull(names);
      assertEquals(1, names.size());
      List<String> soll = Arrays.asList(new String[] {
            Resource2.class.getSimpleName() + "#resourceAll"
            });
      assertArrayEquals(soll.toArray(), names.toArray());
   }
   
   @Test
   public void invokeAdmin4() throws Exception {
      meths.reset();
      PortletInvoker i = new PortletInvoker(ams, "portlet4");
      String resid = "admin";
      req.setResourceId(resid);
      i.serveResource(req, resp);
      List<String> names = meths.getMethods();
      assertNotNull(names);
      assertEquals(0, names.size());
   }
   
   @Test
   public void invokeAdmin5() throws Exception {
      meths.reset();
      PortletInvoker i = new PortletInvoker(ams, "portlet5");
      String resid = "admin";
      req.setResourceId(resid);
      i.serveResource(req, resp);
      List<String> names = meths.getMethods();
      assertNotNull(names);
      assertEquals(0, names.size());
   }
   
   @Test
   public void invokeAdmin8() throws Exception {
      meths.reset();
      PortletInvoker i = new PortletInvoker(ams, "portlet8");
      String resid = "admin";
      req.setResourceId(resid);
      i.serveResource(req, resp);
      List<String> names = meths.getMethods();
      assertNotNull(names);
      assertEquals(0, names.size());
   }
   
   @Test
   public void invokeAdmin7() throws Exception {
      meths.reset();
      PortletInvoker i = new PortletInvoker(ams, "portlet7");
      String resid = "admin";
      req.setResourceId(resid);
      i.serveResource(req, resp);
      List<String> names = meths.getMethods();
      assertNotNull(names);
      assertEquals(1, names.size());
      List<String> soll = Arrays.asList(new String[] {
            Resource2.class.getSimpleName() + "#resourceAll"
            });
      assertArrayEquals(soll.toArray(), names.toArray());
   }
   
}
