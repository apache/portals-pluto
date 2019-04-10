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

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.namespace.QName;

import org.apache.pluto.container.bean.processor.AnnotatedMethodStore;
import org.apache.pluto.container.bean.processor.ConfigSummary;
import org.apache.pluto.container.bean.processor.PortletInvoker;
import org.apache.pluto.container.bean.processor.fixtures.InvocationResults;
import org.apache.pluto.container.bean.processor.fixtures.event.Event1;
import org.apache.pluto.container.bean.processor.fixtures.event.Event2;
import org.apache.pluto.container.bean.processor.fixtures.mocks.MockEventRequest;
import org.apache.pluto.container.bean.processor.fixtures.mocks.MockEventResponse;
import org.apache.pluto.container.om.portlet.impl.ConfigurationHolder;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test class for invoking the annotated event methods.
 * 
 * @author Scott Nicklous
 *
 */
public class InvokeEventTest {
   
   private InvocationResults meths = InvocationResults.getInvocationResults();
   
   private static final MockEventRequest req = new MockEventRequest();
   private static final MockEventResponse resp = new MockEventResponse();
   private static String DEFAULT_NS = "https://www.java.net/";
   
   private static final Set<Class<?>> annotatedClasses =
         new HashSet<Class<?>>(Arrays.asList(Event1.class)); 
   private static final String pkg = "org.apache.pluto.container.bean.processor.fixtures.event";
   
   private static AnnotatedMethodStore ams = null;
   private static ConfigSummary summary = null;
   private static ConfigurationHolder holder =  new ConfigurationHolder();
   
   @BeforeClass
   public static void setUpClass() throws URISyntaxException, IOException {
      Set<File> classes = FileHelper.getClasses(pkg);
      holder.scanMethodAnnotations(classes);
      holder.processConfigAnnotations(annotatedClasses);
      holder.reconcileBeanConfig();
      holder.instantiatePortlets(null);
      ams = holder.getMethodStore();
      summary = holder.getConfigSummary();
      
      assertNotNull(ams);
      assertNotNull(summary);
   }
   
   @Test
   public void invoke1() throws Exception {
      meths.reset();
      PortletInvoker i = new PortletInvoker(ams, "portlet1");
      QName qn = new QName("http://www.apache.org", "proc1");
      req.setQn(qn);
      i.processEvent(req, resp);
      List<String> names = meths.getMethods();
      assertNotNull(names);
      assertEquals(1, names.size());
      assertTrue(names.contains(Event1.class.getSimpleName() + "#event1"));
   }
   
   @Test
   public void invoke2() throws Exception {
      meths.reset();
      PortletInvoker i = new PortletInvoker(ams, "portlet2");
      QName qn = new QName("http://www.apache.org", "proc2");
      req.setQn(qn);
      i.processEvent(req, resp);
      List<String> names = meths.getMethods();
      // there are two valid possibilities
      List<String> meths = Arrays.asList(new String[] {
            Event1.class.getSimpleName() + "#event2", 
            Event2.class.getSimpleName() + "#event2",
            });
      assertNotNull(names);
      assertEquals(1, names.size());
      assertTrue(meths.contains(names.get(0)));
   }
   
   @Test
   public void invoke3a() throws Exception {
      meths.reset();
      PortletInvoker i = new PortletInvoker(ams, "portlet3");
      QName qn = new QName("http://www.apache.org", "proc3a");
      req.setQn(qn);
      i.processEvent(req, resp);
      List<String> names = meths.getMethods();
      assertNotNull(names);
      assertEquals(1, names.size());
      assertTrue(names.contains(Event2.class.getSimpleName() + "#event1a"));
   }
   
   @Test
   public void invoke3b() throws Exception {
      meths.reset();
      PortletInvoker i = new PortletInvoker(ams, "portlet3");
      QName qn = new QName(DEFAULT_NS, "proc3b");
      req.setQn(qn);
      i.processEvent(req, resp);
      List<String> names = meths.getMethods();
      assertNotNull(names);
      assertEquals(1, names.size());
      assertTrue(names.contains(Event2.class.getSimpleName() + "#event1b"));
   }
   
   @Test
   public void invoke3c() throws Exception {
      meths.reset();
      PortletInvoker i = new PortletInvoker(ams, "portlet3");
      QName qn = new QName("http://www.apache.org", "proc3c");
      req.setQn(qn);
      i.processEvent(req, resp);
      List<String> names = meths.getMethods();
      assertNotNull(names);
      assertEquals(1, names.size());
      assertTrue(names.contains(Event2.class.getSimpleName() + "#event1c"));
   }
   
   @Test
   public void invoke6() throws Exception {
      meths.reset();
      PortletInvoker i = new PortletInvoker(ams, "portlet6");
      QName qn = new QName("http://www.apache.org", "proc6");
      req.setQn(qn);
      i.processEvent(req, resp);
      List<String> names = meths.getMethods();
      // there are two valid possibilities
      List<String> meths = Arrays.asList(new String[] {
            Event2.class.getSimpleName() + "#event6", 
            Event2.class.getSimpleName() + "#event7",
            });
      assertNotNull(names);
      assertEquals(1, names.size());
      assertTrue(meths.contains(names.get(0)));
   }
   
}
