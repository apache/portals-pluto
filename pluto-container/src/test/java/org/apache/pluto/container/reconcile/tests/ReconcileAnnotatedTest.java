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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.namespace.QName;

import org.apache.pluto.container.bean.processor.AnnotatedMethodStore;
import org.apache.pluto.container.bean.processor.ConfigSummary;
import org.apache.pluto.container.bean.processor.tests.FileHelper;
import org.apache.pluto.container.om.portlet.EventDefinitionReference;
import org.apache.pluto.container.om.portlet.PortletApplicationDefinition;
import org.apache.pluto.container.om.portlet.PortletDefinition;
import org.apache.pluto.container.om.portlet.impl.ConfigurationHolder;
import org.apache.pluto.container.om.portlet.impl.EventDefinitionReferenceImpl;
import org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl;
import org.apache.pluto.container.om.portlet.impl.PortletDefinitionImpl;
import org.apache.pluto.container.reconcile.fixtures.TestPortlet1;
import org.apache.pluto.container.reconcile.fixtures.TestPortlet2;
import org.apache.pluto.container.reconcile.fixtures.TestPortlet3;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Reconciles a bean portlet configuration with a portlet app definition
 * and portlet application definition provided by annotation & portlet.xml.
 * 
 * @author Scott Nicklous
 */
public class ReconcileAnnotatedTest {

   // Classes under test
   private PortletApplicationDefinition app;
   private PortletDefinition portlet1;
   private PortletDefinition portlet2;
   private PortletDefinition portlet3;

   private static final Class<?> TEST_ANNOTATED_CLASS1 = TestPortlet1.class;
   private static final Class<?> TEST_ANNOTATED_CLASS2 = TestPortlet2.class;
   private static final String XML_FILE = 
         "org/apache/pluto/container/om/portlet/portlet362Reconcile.xml";

   private static final String pkg = "org.apache.pluto.container.reconcile.fixtures";

   private static AnnotatedMethodStore ams = null;
   private static ConfigSummary summary = null;
   private static ConfigurationHolder holder =  new ConfigurationHolder();
   private static PortletApplicationDefinition pad;

   @BeforeClass
   public static void setUpBeforeClass() throws Exception {
      Set<File> portletMethodClasses = FileHelper.getClasses(pkg);
      
      InputStream in = ReconcileAnnotatedTest.class
            .getClassLoader().getResourceAsStream(XML_FILE);


      Set<Class<?>> configClasses = new HashSet<Class<?>>();
      configClasses.add(TEST_ANNOTATED_CLASS1);
      configClasses.add(TEST_ANNOTATED_CLASS2);

      try {
         holder.scanMethodAnnotations(portletMethodClasses);
         holder.processConfigAnnotations(configClasses);
         holder.processPortletDD(in);     // process portlet xml after annotations
         holder.reconcileBeanConfig();
         holder.instantiatePortlets(null);
         try {
            holder.validate();         // validate and ignore any validation problems.
         } catch (Exception e) {}   
      } catch (Exception e) {
         e.printStackTrace();
         throw e;
      }
      ams = holder.getMethodStore();
      summary = holder.getConfigSummary();
      pad = holder.getPad();
      
      assertNotNull(ams);
      assertNotNull(summary);
   }

   @Before
   public void setUpBefore() throws Exception {

      app = new PortletApplicationDefinitionImpl(pad);

      assertEquals(4, app.getPortlets().size());
      assertNotNull(app.getPortlet("Portlet1"));
      assertNotNull(app.getPortlet("Portlet2"));
      assertNotNull(app.getPortlet("Portlet3"));
      portlet1 = new PortletDefinitionImpl(app.getPortlet("Portlet1"));
      portlet2 = new PortletDefinitionImpl(app.getPortlet("Portlet2"));
      portlet3 = new PortletDefinitionImpl(app.getPortlet("Portlet3"));
   }

   // Begin portlet app tests ==================================
   
   @Test
   public void testGetVersion() {
      String val = app.getVersion();
      assertEquals("3.0", val);
   }

   @Test
   public void testGetDefaultNamespace() {
      String val = app.getDefaultNamespace();
      assertEquals("https://www.java.net/", val);
   }
   
   @Test
   public void testEventDefinition() throws Exception {
      assertNotNull(app.getEventDefinition(new QName("http://www.apache.org/", "event1")));  
      assertNotNull(app.getEventDefinition(new QName("http://www.apache.org/", "event2")));   
      assertNotNull(app.getEventDefinition(new QName("https://www.java.net/", "event3")));
      assertNotNull(app.getEventDefinition(new QName("https://www.java.net/", "event4"))); 
   }

   // Begin portlet 1 tests ================================== 
   
   @Test
   public void testGetPortletName() {
      assertNotNull(portlet1.getPortletName());
      assertEquals("Portlet1", portlet1.getPortletName());
   }

   @Test
   public void testGetPortletClass() {
      assertNotNull(portlet1.getPortletClass());
      assertEquals(TEST_ANNOTATED_CLASS1.getCanonicalName(), portlet1.getPortletClass());
   }
   
   @Test
   public void test1processingEvent() throws Exception {
      List<EventDefinitionReference> events = portlet1.getSupportedProcessingEvents();
      assertNotNull(events);
      assertEquals(2, events.size());
      assertTrue(events.contains(new EventDefinitionReferenceImpl(new QName("http://www.apache.org/", "event1"))));
      assertTrue(events.contains(new EventDefinitionReferenceImpl(new QName("https://www.java.net/", "event3"))));
   }
   
   @Test
   public void test1publishingEvent() throws Exception {
      List<EventDefinitionReference> events = portlet1.getSupportedPublishingEvents();
      assertNotNull(events);
      assertEquals(3, events.size());
      assertTrue(events.contains(new EventDefinitionReferenceImpl(new QName("http://www.apache.org/", "event2"))));
      assertTrue(events.contains(new EventDefinitionReferenceImpl(new QName("https://www.java.net/", "event3"))));
      assertTrue(events.contains(new EventDefinitionReferenceImpl(new QName("https://www.java.net/", "event4"))));
   }
  
   // Begin portlet 2 tests ================================== 
   
   @Test
   public void test2GetPortletName() {
      assertNotNull(portlet2.getPortletName());
      assertEquals("Portlet2", portlet2.getPortletName());
   }

   @Test
   public void test2GetPortletClass() {
      assertNull(portlet2.getPortletClass());
   }
   
   @Test
   public void test2processingEvent() throws Exception {
      List<EventDefinitionReference> events = portlet2.getSupportedProcessingEvents();
      assertNotNull(events);
      assertEquals(2, events.size());
      assertTrue(events.contains(new EventDefinitionReferenceImpl(new QName("http://www.apache.org/", "event2"))));
      assertTrue(events.contains(new EventDefinitionReferenceImpl(new QName("https://www.java.net/", "event4"))));
   }
   
   @Test
   public void test2publishingEvent() throws Exception {
      List<EventDefinitionReference> events = portlet2.getSupportedPublishingEvents();
      assertNotNull(events);
      assertEquals(3, events.size());
      assertTrue(events.contains(new EventDefinitionReferenceImpl(new QName("http://www.apache.org/", "event1"))));
      assertTrue(events.contains(new EventDefinitionReferenceImpl(new QName("https://www.java.net/", "event3"))));
      assertTrue(events.contains(new EventDefinitionReferenceImpl(new QName("https://www.java.net/", "event4"))));
   }
   
   // Begin portlet 3 tests ================================== 
   
   @Test
   public void test3GetPortletName() {
      assertNotNull(portlet3.getPortletName());
      assertEquals("Portlet3", portlet3.getPortletName());
   }

   @Test
   public void test3GetPortletClass() {
      assertNotNull(portlet3.getPortletClass());
      assertEquals(TestPortlet3.class.getCanonicalName(), portlet3.getPortletClass());
   }
   
   @Test
   public void test3processingEvent() throws Exception {
      List<EventDefinitionReference> events = portlet3.getSupportedProcessingEvents();
      assertNotNull(events);
      assertEquals(1, events.size());
      assertEquals(new QName("https://www.java.net/", "event3"), events.get(0).getQualifiedName());
   }
   
   @Test
   public void test3publishingEvent() throws Exception {
      List<EventDefinitionReference> events = portlet3.getSupportedPublishingEvents();
      assertNotNull(events);
      assertEquals(1, events.size());
      assertEquals(new QName("http://www.apache.org/", "event1"), events.get(0).getQualifiedName());
   }

}
