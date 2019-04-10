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


package org.apache.pluto.container.om.portlet.impl.jsr362;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.pluto.container.om.portlet.Listener;
import org.apache.pluto.container.om.portlet.PortletApplicationDefinition;
import org.apache.pluto.container.om.portlet.impl.ConfigurationHolder;
import org.apache.pluto.container.om.portlet.impl.ListenerImpl;
import org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl;
import org.apache.pluto.container.om.portlet.impl.fixtures.MultipleAnnotatedListeners1;
import org.apache.pluto.container.om.portlet.impl.fixtures.MultipleAnnotatedListeners2;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Junit test cases for JSR 362 portlet application definition.
 * @author Scott Nicklous
 *
 */
public class MultipleAnnotatedListenerTest {
   
   // defines both some portlets and a Listener
   private static final Class<?> TEST_ANNOTATED_CLASS1 = MultipleAnnotatedListeners1.class;
   private static final Class<?> TEST_ANNOTATED_CLASS2 = MultipleAnnotatedListeners2.class;
   
   private static PortletApplicationDefinition pad;
   private static ConfigurationHolder cfp;
   
   // class under test; cloned new for each test
   private  PortletApplicationDefinition cut;

   /**
    * @throws java.lang.Exception
    */
   @BeforeClass
   public static void setUpBeforeClass() throws Exception {

      Set<Class<?>> classes = new HashSet<Class<?>>();
      classes.add(TEST_ANNOTATED_CLASS1);
      classes.add(TEST_ANNOTATED_CLASS2);
      cfp = new ConfigurationHolder();
      try {
         cfp.processConfigAnnotations(classes);
         try {
            cfp.validate();         // validate to expand the Listener mapping portlet names
         } catch (Exception e) {}   // ignore any validation problems.
         pad = cfp.getPad();
      } catch (Exception e) {
         e.printStackTrace();
         throw e;
      }
   }
   
   @Before
   public void setUpBefore() throws Exception {
      cut = new PortletApplicationDefinitionImpl(pad);
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#getListener(java.lang.String)}.
    */
   @Test
   public void testGetListener() {
      String fn1 = "aListener";
      String fn2 = "bListener";
      Listener lis1 = cut.getListener(fn1);
      assertNotNull(lis1);
      assertEquals(100, lis1.getOrdinal());
      Listener lis2 = cut.getListener(fn2);
      assertNotNull(lis2);
      assertEquals(-100, lis2.getOrdinal());
      assertEquals(TEST_ANNOTATED_CLASS1.getCanonicalName(), lis1.getListenerClass());
      assertEquals(TEST_ANNOTATED_CLASS2.getCanonicalName(), lis2.getListenerClass());
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#addListener(org.apache.pluto.container.om.portlet.Listener)}.
    */
   @Test
   public void testAddListener() {
      String newItem = "newListener";
      String oldItem1 = "aListener";
      String oldItem2 = "bListener";
      Listener lis = new ListenerImpl("SomeClass");
      lis.setListenerName(newItem);
      lis.setOrdinal(-101);
      cut.addListener(lis);
      
      List<Listener> list = cut.getListeners();
      assertNotNull(list);
      assertEquals(3, list.size());
      assertEquals(newItem, list.get(0).getListenerName());
      assertEquals(oldItem1, list.get(2).getListenerName());
      assertEquals(oldItem2, list.get(1).getListenerName());
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#addListener(org.apache.pluto.container.om.portlet.Listener)}.
    */
   @Test
   public void checkListenerOrder1() {
      String newItem = "newListener";
      String oldItem1 = "aListener";
      String oldItem2 = "bListener";
      Listener lis = new ListenerImpl("SomeClass");
      lis.setListenerName(newItem);
      lis.setOrdinal(1000);
      cut.addListener(lis);
      
      List<Listener> list = cut.getListeners();
      assertNotNull(list);
      assertEquals(3, list.size());
      assertEquals(newItem, list.get(2).getListenerName());
      assertEquals(oldItem1, list.get(1).getListenerName());
      assertEquals(oldItem2, list.get(0).getListenerName());
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#addListener(org.apache.pluto.container.om.portlet.Listener)}.
    */
   @Test
   public void checkListenerOrder2() {
      String newItem = "newListener";
      String oldItem1 = "aListener";
      String oldItem2 = "bListener";
      Listener lis = new ListenerImpl("SomeClass");
      lis.setListenerName(newItem);
      lis.setOrdinal(0);
      cut.addListener(lis);
      
      List<Listener> list = cut.getListeners();
      assertNotNull(list);
      assertEquals(3, list.size());
      assertEquals(newItem, list.get(1).getListenerName());
      assertEquals(oldItem1, list.get(2).getListenerName());
      assertEquals(oldItem2, list.get(0).getListenerName());
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#addListener(org.apache.pluto.container.om.portlet.Listener)}.
    */
   @Test
   public void deleteListener1() {
      String oldItem = "aListener";
      Listener lis = new ListenerImpl((String)null);
      lis.setListenerName(oldItem);
      lis.setOrdinal(1000);
      cut.addListener(lis);
      
      List<Listener> list = cut.getListeners();
      assertNotNull(list);
      assertEquals(1, list.size());
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#addListener(org.apache.pluto.container.om.portlet.Listener)}.
    */
   @Test
   public void deleteListener2() {
      String oldItem = "aListener";
      Listener lis = new ListenerImpl("");
      lis.setListenerName(oldItem);
      lis.setOrdinal(1000);
      cut.addListener(lis);
      
      List<Listener> list = cut.getListeners();
      assertNotNull(list);
      assertEquals(1, list.size());
   }

   @Test
   public void testAddDupListener() {
      String fn = "aListener";
      String fc = "SomeClass";
      Listener lis = new ListenerImpl(fc);
      lis.setListenerName(fn);
      lis.setOrdinal(200);
      cut.addListener(lis);
      
      List<Listener> list = cut.getListeners();
      assertNotNull(list);
      assertEquals(2, list.size());
      assertEquals(fn, list.get(1).getListenerName());
      assertEquals(fc, list.get(1).getListenerClass());
   }

}
