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

import static org.apache.pluto.container.bean.processor.MethodType.EVENT;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.xml.namespace.QName;

import org.apache.pluto.container.bean.processor.AnnotatedConfigBean;
import org.apache.pluto.container.bean.processor.AnnotatedMethod;
import org.apache.pluto.container.bean.processor.AnnotatedMethodStore;
import org.apache.pluto.container.bean.processor.ConfigSummary;
import org.apache.pluto.container.bean.processor.MethodIdentifier;
import org.apache.pluto.container.bean.processor.PortletCDIExtension;
import org.apache.pluto.container.bean.processor.fixtures.event.Event1;
import org.apache.pluto.container.bean.processor.fixtures.event.Event2;
import org.jglue.cdiunit.AdditionalClasses;
import org.jglue.cdiunit.AdditionalPackages;
import org.jglue.cdiunit.CdiRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Test class for RenderStateScoped beans
 * 
 * @author Scott Nicklous
 *
 */
@RunWith(CdiRunner.class)
@AdditionalClasses(PortletCDIExtension.class)
@AdditionalPackages(Event1.class)
public class EventFixupTest {
   
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
   public void portletNamesTest() throws Exception {
      Set<String> names = ams.getPortletNames();
      assertNotNull(names);
      assertEquals(4, names.size());
      assertTrue(names.contains("portlet1"));
      assertTrue(names.contains("portlet2"));
      assertTrue(names.contains("portlet3"));
      assertTrue(names.contains("portlet6"));
   }
   
   @Test
   public void errorDuplicateMethod() throws Exception {
      List<String> names = summary.getPortletsWithErrors();
      assertNotNull(names);
      assertEquals(4, names.size());
      assertTrue(names.contains("portlet2"));
   }
   
   @Test
   public void errorDuplicateMethod2() throws Exception {
      List<String> names = summary.getPortletsWithErrors();
      assertNotNull(names);
      assertEquals(4, names.size());
      assertTrue(names.contains("portlet6"));
   }
   
   @Test
   public void errorBadReturnType() throws Exception {
      List<String> names = summary.getPortletsWithErrors();
      assertNotNull(names);
      assertEquals(4, names.size());
      assertTrue(names.contains("portlet5"));
   }
   
   @Test
   public void errorBadParameters() throws Exception {
      List<String> names = summary.getPortletsWithErrors();
      assertNotNull(names);
      assertEquals(4, names.size());
      assertTrue(names.contains("portlet4"));
   }
   
   @Test
   public void methods1Test() throws Exception {
      Set<MethodIdentifier> portlets = ams.getMethodIDsForPortlet("portlet1");
      assertNotNull(portlets);
      assertEquals(1, portlets.size());
      MethodIdentifier mi = (MethodIdentifier) portlets.toArray()[0];
      assertEquals(EVENT, mi.getType());
      QName qn = new QName("http://www.apache.org", "proc1");
      assertEquals(qn, mi.getId());
      assertEquals("portlet1", mi.getName());
   }
   
   @Test
   public void methods2Test() throws Exception {
      Set<MethodIdentifier> portlets = ams.getMethodIDsForPortlet("portlet2");
      assertNotNull(portlets);
      assertEquals(1, portlets.size());
      MethodIdentifier mi = (MethodIdentifier) portlets.toArray()[0];
      assertEquals(EVENT, mi.getType());
      QName qn = new QName("http://www.apache.org", "proc2");
      assertEquals(qn, mi.getId());
      assertEquals("portlet2", mi.getName());
   }
   
   @Test
   public void methods3Test() throws Exception {
      Set<MethodIdentifier> portlets = ams.getMethodIDsForPortlet("portlet3");
      assertNotNull(portlets);
      assertEquals(3, portlets.size());
      List<QName> ids = Arrays.asList(new QName[] {
            new QName("http://www.apache.org", "proc3a"),
            new QName(DEFAULT_NS, "proc3b"),
            new QName("http://www.apache.org", "proc3c"),
      });
      for (MethodIdentifier mi : portlets) {
         assertEquals(EVENT, mi.getType());
         assertTrue(ids.contains(mi.getId()));
         assertEquals("portlet3", mi.getName());
      }
   }
   
   @Test
   public void class1Test() throws Exception {
      QName qn = new QName("http://www.apache.org", "proc1");
      MethodIdentifier mi = new MethodIdentifier("portlet1", qn, EVENT);
      List<AnnotatedMethod> list = ams.getMethods(mi);
      assertNotNull(list);
      assertEquals(1, list.size());
      AnnotatedMethod am = list.get(0);
      assertNotNull(am);
      Method m = am.getJavaMethod();
      assertNotNull(m);
      assertEquals("event1", m.getName());
      assertEquals(Event1.class, m.getDeclaringClass());
   }
   
   @Test
   public void class2Test() throws Exception {
      QName qn = new QName("http://www.apache.org", "proc2");
      MethodIdentifier mi = new MethodIdentifier("portlet2", qn, EVENT);
      List<AnnotatedMethod> list = ams.getMethods(mi);
      assertNotNull(list);
      assertEquals(1, list.size());
      AnnotatedMethod am = list.get(0);
      assertNotNull(am);
      Method m = am.getJavaMethod();
      assertNotNull(m);
      assertEquals("event2", m.getName());
      // don't know which one the scanner will find first
      List<Class<?>> clslst = Arrays.asList(new Class<?>[] {Event1.class, Event2.class});
      assertTrue(clslst.contains(m.getDeclaringClass()));
   }
   
   @Test
   public void class6Test() throws Exception {
      QName qn = new QName("http://www.apache.org", "proc6");
      MethodIdentifier mi = new MethodIdentifier("portlet6", qn, EVENT);
      List<AnnotatedMethod> list = ams.getMethods(mi);
      assertNotNull(list);
      assertEquals(1, list.size());
      AnnotatedMethod am = list.get(0);
      assertNotNull(am);
      Method m = am.getJavaMethod();
      assertNotNull(m);
      // order in which method found undefined
      List<String> names = Arrays.asList(new String[] {"event6", "event7"});
      assertTrue(names.contains(m.getName()));
      assertEquals(Event2.class, m.getDeclaringClass());
   }
   
   @Test
   public void class4Test() throws Exception {
      Set<MethodIdentifier> portlets = ams.getMethodIDsForPortlet("portlet3");
      assertNotNull(portlets);
      assertEquals(3, portlets.size());

      List<String> methNames = Arrays.asList(new String[] {"event1a", "event1b", "event1c"});
      for (MethodIdentifier mi : portlets) {
         AnnotatedMethod am = ams.getMethod(mi);
         Method m = am.getJavaMethod();
         assertNotNull(m);
         assertTrue(methNames.contains(m.getName()));
         assertEquals(Event2.class, m.getDeclaringClass());
      }
   }
   
   @Test
   public void pubEvent1Test() throws Exception {
      List<QName> qns = ams.getPublishingEventRefs("portlet1");
      assertNotNull(qns);
      assertEquals(1, qns.size());
      assertTrue(qns.contains(new QName("http://www.apache.org", "pub1")));
   }
   
   @Test
   public void pubEvent2Test() throws Exception {
      List<QName> qns = ams.getPublishingEventRefs("portlet3");
      assertNotNull(qns);
      assertEquals(4, qns.size());
      assertTrue(qns.contains(new QName("http://www.apache.org", "pub1")));
      assertTrue(qns.contains(new QName("http://www.apache.org", "pub2")));
      assertTrue(qns.contains(new QName("http://www.apache.org", "pub3")));
      assertTrue(qns.contains(new QName(DEFAULT_NS, "pub4")));
   }
   
   @Test
   public void procEvent1Test() throws Exception {
      List<QName> qns = ams.getProcessingEventRefs("portlet1");
      assertNotNull(qns);
      assertEquals(1, qns.size());
      assertTrue(qns.contains(new QName("http://www.apache.org", "proc1")));
   }
   
   @Test
   public void procEvent2Test() throws Exception {
      List<QName> qns = ams.getProcessingEventRefs("portlet2");
      assertNotNull(qns);
      assertEquals(1, qns.size());
      assertTrue(qns.contains(new QName("http://www.apache.org", "proc2")));
   }
   
   @Test
   public void procEvent3Test() throws Exception {
      List<QName> qns = ams.getProcessingEventRefs("portlet3");
      assertNotNull(qns);
      assertEquals(3, qns.size());
      assertTrue(qns.contains(new QName("http://www.apache.org", "proc3a")));
      assertTrue(qns.contains(new QName(DEFAULT_NS, "proc3b")));
      assertTrue(qns.contains(new QName("http://www.apache.org", "proc3c")));
   }
   
   @Test
   public void procEvent6Test() throws Exception {
      List<QName> qns = ams.getProcessingEventRefs("portlet6");
      assertNotNull(qns);
      assertEquals(1, qns.size());
      assertTrue(qns.contains(new QName("http://www.apache.org", "proc6")));
   }
   
}
