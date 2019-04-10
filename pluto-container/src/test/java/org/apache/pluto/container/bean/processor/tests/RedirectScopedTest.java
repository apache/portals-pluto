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

import org.apache.pluto.container.bean.processor.AnnotatedConfigBean;
import org.apache.pluto.container.bean.processor.AnnotatedMethodStore;
import org.apache.pluto.container.bean.processor.ConfigSummary;
import org.apache.pluto.container.bean.processor.PortletCDIExtension;
import org.apache.pluto.container.bean.processor.RedirectScopedConfig;
import org.apache.pluto.container.bean.processor.fixtures.RedirectScopedClass;
import org.jglue.cdiunit.AdditionalClasses;
import org.jglue.cdiunit.AdditionalPackages;
import org.jglue.cdiunit.CdiRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Test class for RedirectScoped beans
 * 
 * @author Scott Nicklous
 * @author Neil Griffin
 *
 */
@RunWith(CdiRunner.class)
@AdditionalClasses(PortletCDIExtension.class)
@AdditionalPackages(RedirectScopedClass.class)
public class RedirectScopedTest {
   
   @Inject
   AnnotatedConfigBean acb;
   
   @Inject
   BeanManager beanmgr;
   
   private AnnotatedMethodStore annotatedMethodStore;
   private ConfigSummary summary;
   private RedirectScopedConfig redirectScopedConfig;
   
   @Before
   public void setUp() {
      annotatedMethodStore = acb.getMethodStore();
      summary = acb.getSummary();
      redirectScopedConfig = acb.getRedirectScopedConfig();
      redirectScopedConfig.activate(beanmgr);
   }

   @Test
   public void injectBeanTest() {
      assertNotNull(acb);
      assertNotNull(annotatedMethodStore);
      assertNotNull(summary);
      assertNotNull(redirectScopedConfig);
   }
   
   @Test
   public void annotatedClassPresent1() {
      Set<Class<?>> classes = redirectScopedConfig.getBeanClasses();
      assertNotNull(classes);
      assertEquals(1, classes.size());
   }

   @Test
   public void annotatedClassPresent2() {
      Set<Class<?>> classes = redirectScopedConfig.getBeanClasses();
      assertNotNull(classes);
      assertTrue(classes.contains(RedirectScopedClass.class));
   }
}
