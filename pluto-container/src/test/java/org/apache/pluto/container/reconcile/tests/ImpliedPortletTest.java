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

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.xml.namespace.QName;

import org.apache.pluto.container.bean.processor.AnnotatedConfigBean;
import org.apache.pluto.container.bean.processor.AnnotatedMethodStore;
import org.apache.pluto.container.bean.processor.PortletCDIExtension;
import org.apache.pluto.container.om.portlet.EventDefinitionReference;
import org.apache.pluto.container.om.portlet.PortletApplicationDefinition;
import org.apache.pluto.container.om.portlet.PortletDefinition;
import org.apache.pluto.container.om.portlet.impl.ConfigurationHolder;
import org.apache.pluto.container.om.portlet.impl.EventDefinitionReferenceImpl;
import org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl;
import org.apache.pluto.container.om.portlet.impl.jsr362.MergePortletAppTest;
import org.apache.pluto.container.reconcile.fixtures.IncompletePortlet;
import org.apache.pluto.container.reconcile.fixtures.TestPortlet1;
import org.apache.pluto.container.reconcile.fixtures.TestPortlet2;
import org.apache.pluto.container.reconcile.fixtures.TestPortlet3;
import org.apache.pluto.container.reconcile.fixtures.TestPortlet4;
import org.jglue.cdiunit.AdditionalClasses;
import org.jglue.cdiunit.CdiRunner;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Adds a bean portlet that is defined implicitly through the portlet method annotations.
 * 
 * @author Scott Nicklous
 */
@RunWith(CdiRunner.class)
@AdditionalClasses({PortletCDIExtension.class, TestPortlet1.class, 
   TestPortlet2.class, TestPortlet3.class, TestPortlet4.class, IncompletePortlet.class})
public class ImpliedPortletTest {

   private static final Class<?> TEST_ANNOTATED_CLASS1 = TestPortlet1.class;
   private static final Class<?> TEST_ANNOTATED_CLASS2 = TestPortlet2.class;
   private static final String XML_FILE = 
         "org/apache/pluto/container/om/portlet/portlet362Reconcile.xml";

   private static PortletApplicationDefinition pad;
   
   @Inject
   AnnotatedConfigBean acb;
   
   private AnnotatedMethodStore ams = null;

   // Classes under test
   private PortletApplicationDefinition app;

   @BeforeClass
   public static void setUpBeforeClass() throws Exception {
      
      InputStream in = MergePortletAppTest.class
            .getClassLoader().getResourceAsStream(XML_FILE);

      Set<Class<?>> classes = new HashSet<Class<?>>();
      classes.add(TEST_ANNOTATED_CLASS1);
      classes.add(TEST_ANNOTATED_CLASS2);

      ConfigurationHolder ch = new ConfigurationHolder();
      try {
         ch.processConfigAnnotations(classes);
         ch.processPortletDD(in);     // process portlet xml after annotations
         try {
            ch.validate();         // validate and ignore any validation problems.
         } catch (Exception e) {}   
         pad = ch.getPad();
      } catch (Exception e) {
         e.printStackTrace();
         throw e;
      }
   }

   @Before
   public void setUpBefore() throws Exception {
      assertNotNull(acb);
      ams = acb.getMethodStore();
      assertNotNull(ams);

      app = new PortletApplicationDefinitionImpl(pad);
      ConfigurationHolder coho = new ConfigurationHolder(app);
      coho.reconcileBeanConfig(ams);
   }

   // Begin portlet app tests ==================================
   
   @Test
   public void testNumberPortlets() {
      assertEquals(4, app.getPortlets().size());
      assertNotNull(app.getPortlet("Portlet1"));
      assertNotNull(app.getPortlet("Portlet2"));
      assertNotNull(app.getPortlet("Portlet3"));
      assertNotNull(app.getPortlet("Portlet4"));
   }
   
   // tests that a portlet with not enough methods is thrown out.
   @Test
   public void incompletePortletTest() throws Exception {
      assertNull(app.getPortlet("IncompletePortlet"));
   }
  
   // Begin portlet 2 tests ================================== 
   
   @Test
   public void test4GetPortletName() {
      PortletDefinition portlet4 = app.getPortlet("Portlet4");
      assertNotNull(portlet4.getPortletName());
      assertEquals("Portlet4", portlet4.getPortletName());
   }

   @Test
   public void test4GetPortletClass() {
      PortletDefinition portlet4 = app.getPortlet("Portlet4");
      assertNull(portlet4.getPortletClass());
   }
   
   @Test
   public void test4processingEvent() throws Exception {
      PortletDefinition portlet4 = app.getPortlet("Portlet4");
      List<EventDefinitionReference> events = portlet4.getSupportedProcessingEvents();
      assertNotNull(events);
      assertEquals(2, events.size());
      assertTrue(events.contains(new EventDefinitionReferenceImpl(new QName("http://www.apache.org/", "event2"))));
      assertTrue(events.contains(new EventDefinitionReferenceImpl(new QName("https://www.java.net/", "event4"))));
   }
   
   @Test
   public void test4publishingEvent() throws Exception {
      PortletDefinition portlet4 = app.getPortlet("Portlet4");
      List<EventDefinitionReference> events = portlet4.getSupportedPublishingEvents();
      assertNotNull(events);
      assertEquals(3, events.size());
      assertTrue(events.contains(new EventDefinitionReferenceImpl(new QName("http://www.apache.org/", "event1"))));
      assertTrue(events.contains(new EventDefinitionReferenceImpl(new QName("https://www.java.net/", "event3"))));
      assertTrue(events.contains(new EventDefinitionReferenceImpl(new QName("https://www.java.net/", "event4"))));
   }
   

}
