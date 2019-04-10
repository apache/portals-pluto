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
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Set;

import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;

import org.apache.pluto.container.bean.processor.AnnotatedConfigBean;
import org.apache.pluto.container.bean.processor.AnnotatedMethodStore;
import org.apache.pluto.container.bean.processor.ConfigSummary;
import org.apache.pluto.container.bean.processor.PortletCDIExtension;
import org.apache.pluto.container.bean.processor.PortletStateScopedConfig;
import org.apache.pluto.container.bean.processor.fixtures.PortletStateScopedBadClass;
import org.apache.pluto.container.bean.processor.fixtures.PortletStateScopedClass;
import org.apache.pluto.container.bean.processor.fixtures.PortletStateScopedNoParamNameClass;
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
public class PortletStateScopedTest {
   
   @Inject
   AnnotatedConfigBean acb;
   
   @Inject
   BeanManager beanmgr;
   
   private AnnotatedMethodStore ams = null;
   private ConfigSummary summary = null;
   private PortletStateScopedConfig psconfig = null;
   
   @Before
   public void setUp() {
      ams = acb.getMethodStore();
      summary = acb.getSummary();
      psconfig = acb.getStateScopedConfig();
      psconfig.activate(beanmgr);
   }

   @Test
   public void injectBeanTest() {
      assertNotNull(acb);
      assertNotNull(ams);
      assertNotNull(summary);
      assertNotNull(psconfig);
   }
   
   @Test
   public void annotatedClassPresent1() {
      Set<Class<?>> classes = psconfig.getBeanClasses();
      assertNotNull(classes);
      assertEquals(2, classes.size());
   }

   @Test
   public void annotatedClassPresent2() {
      Set<Class<?>> classes = psconfig.getBeanClasses();
      assertNotNull(classes);
      assertTrue(classes.contains(PortletStateScopedClass.class));
   }

   @Test
   public void annotatedClassPresent3() {
      Set<Class<?>> classes = psconfig.getBeanClasses();
      assertNotNull(classes);
      assertTrue(classes.contains(PortletStateScopedNoParamNameClass.class));
   }

   @Test
   public void annotatedClassNotPresent() {
      Set<Class<?>> classes = psconfig.getBeanClasses();
      assertNotNull(classes);
      assertFalse(classes.contains(PortletStateScopedBadClass.class));
   }

   @Test
   public void paramName1() {
      String name = psconfig.getParamName(PortletStateScopedClass.class);
      assertNotNull(name);
      assertEquals("param1", name);
   }

   @Test
   public void paramName2() {
      String name = psconfig.getParamName(PortletStateScopedNoParamNameClass.class);
      assertNotNull(name);
      assertTrue(name.endsWith("1"));
   }
   
   @Test
   public void errorList() {
      List<Class<?>> list = summary.getStateBeansWithErrors();
      assertNotNull(list);
      assertEquals(1, list.size());
      assertTrue(list.contains(PortletStateScopedBadClass.class));
   }
   
   @Test
   public void errorString() {
      String msg = summary.getStateBeanErrorString(PortletStateScopedBadClass.class);
      assertNotNull(msg);
   }
}
