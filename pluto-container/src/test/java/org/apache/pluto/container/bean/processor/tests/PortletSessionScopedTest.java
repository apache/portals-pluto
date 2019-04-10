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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Set;

import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;

import org.apache.pluto.container.bean.processor.AnnotatedConfigBean;
import org.apache.pluto.container.bean.processor.AnnotatedMethodStore;
import org.apache.pluto.container.bean.processor.ConfigSummary;
import org.apache.pluto.container.bean.processor.PortletCDIExtension;
import org.apache.pluto.container.bean.processor.PortletSessionScopedConfig;
import org.apache.pluto.container.bean.processor.fixtures.PortletStateScopedClass;
import org.apache.pluto.container.bean.processor.fixtures.SessionScopedApp1;
import org.apache.pluto.container.bean.processor.fixtures.SessionScopedApp2;
import org.apache.pluto.container.bean.processor.fixtures.SessionScopedPortlet1;
import org.apache.pluto.container.bean.processor.fixtures.SessionScopedPortlet2;
import org.apache.pluto.container.bean.processor.fixtures.SessionScopedPortletBad1;
import org.apache.pluto.container.bean.processor.fixtures.SessionScopedPortletBad2;
import org.apache.pluto.container.bean.processor.fixtures.SessionScopedPortletBad3;
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
@AdditionalPackages(PortletStateScopedClass.class)
public class PortletSessionScopedTest {
   
   @Inject
   AnnotatedConfigBean acb;
   
   @Inject
   BeanManager beanmgr;
   
   private AnnotatedMethodStore ams = null;
   private ConfigSummary summary = null;
   private PortletSessionScopedConfig sessConfig = null;
   
   @Before
   public void setUp() {
      ams = acb.getMethodStore();
      summary = acb.getSummary();
      sessConfig = acb.getSessionScopedConfig();
      sessConfig.activate(beanmgr);
   }

   @Test
   public void injectBeanTest() {
      assertNotNull(acb);
      assertNotNull(ams);
      assertNotNull(summary);
      assertNotNull(sessConfig);
   }
   
   @Test
   public void annotatedClassPresent1() {
      Set<Class<?>> classes = sessConfig.getBeanClasses();
      assertNotNull(classes);
      assertEquals(4, classes.size());
   }

   @Test
   public void annotatedClassPresent2() {
      Set<Class<?>> classes = sessConfig.getBeanClasses();
      assertNotNull(classes);
      assertTrue(classes.contains(SessionScopedPortlet1.class));
   }

   @Test
   public void annotatedClassPresent3() {
      Set<Class<?>> classes = sessConfig.getBeanClasses();
      assertNotNull(classes);
      assertTrue(classes.contains(SessionScopedPortlet2.class));
   }

   @Test
   public void annotatedClassPresent4() {
      Set<Class<?>> classes = sessConfig.getBeanClasses();
      assertNotNull(classes);
      assertTrue(classes.contains(SessionScopedApp1.class));
   }

   @Test
   public void annotatedClassPresent5() {
      Set<Class<?>> classes = sessConfig.getBeanClasses();
      assertNotNull(classes);
      assertTrue(classes.contains(SessionScopedApp2.class));
   }

   @Test
   public void annotatedClassNotPresent() {
      Set<Class<?>> classes = sessConfig.getBeanClasses();
      assertNotNull(classes);
      assertFalse(classes.contains(SessionScopedPortletBad1.class));
      assertFalse(classes.contains(SessionScopedPortletBad2.class));
      assertFalse(classes.contains(SessionScopedPortletBad3.class));
   }

   @Test
   public void isPortletScope1() {
      Boolean isps = sessConfig.isPortletScoped(SessionScopedPortlet1.class);
      assertNotNull(isps);
      assertTrue(isps);
   }

   @Test
   public void isPortletScope2() {
      Boolean isps = sessConfig.isPortletScoped(SessionScopedPortlet2.class);
      assertNotNull(isps);
      assertTrue(isps);
   }

   @Test
   public void isPortletScopeBad() {
      assertNull(sessConfig.isPortletScoped(SessionScopedPortletBad1.class));
      assertNull(sessConfig.isPortletScoped(SessionScopedPortletBad2.class));
      assertNull(sessConfig.isPortletScoped(SessionScopedPortletBad3.class));
   }
   
   @Test
   public void errorList() {
      List<Class<?>> list = summary.getSessionBeansWithErrors();
      assertNotNull(list);
      assertEquals(3, list.size());
      assertTrue(list.contains(SessionScopedPortletBad1.class));
      assertTrue(list.contains(SessionScopedPortletBad2.class));
      assertTrue(list.contains(SessionScopedPortletBad3.class));
   }
   
   @Test
   public void errorString() {
      assertNotNull(summary.getSessionBeanErrorString(SessionScopedPortletBad1.class));
      assertNotNull(summary.getSessionBeanErrorString(SessionScopedPortletBad2.class));
      assertNotNull(summary.getSessionBeanErrorString(SessionScopedPortletBad3.class));
   }
}
