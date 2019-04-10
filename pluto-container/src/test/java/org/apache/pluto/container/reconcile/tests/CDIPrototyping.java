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

import java.util.Set;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;
import javax.portlet.EventPortlet;
import javax.portlet.GenericPortlet;
import javax.portlet.HeaderPortlet;
import javax.portlet.Portlet;
import javax.portlet.ResourceServingPortlet;

import org.apache.pluto.container.reconcile.fixtures.TestPortlet1;
import org.apache.pluto.container.reconcile.fixtures.TestPortlet1AppScoped;
import org.jglue.cdiunit.AdditionalClasses;
import org.jglue.cdiunit.CdiRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(CdiRunner.class)
@AdditionalClasses({TestPortlet1.class, TestPortlet1AppScoped.class})
public class CDIPrototyping {

   @Inject
   BeanManager bm;
   
   @Test
   public void beanMgrTest() throws Exception {
      assertNotNull(bm);
      
      Set<Bean<?>> beans = bm.getBeans(TestPortlet1.class);
      Bean<?> bean = bm.resolve(beans);
      assertNotNull(bean);
      
      CreationalContext<?> coco = bm.createCreationalContext(bean);
      assertNotNull(coco);
      
      Object obj = bm.getReference(bean, TestPortlet1.class, coco);
      assertNotNull(obj);
      assertTrue(obj instanceof GenericPortlet);
      assertTrue(obj instanceof Portlet);
      assertTrue(obj instanceof HeaderPortlet);
      assertTrue(obj instanceof EventPortlet);
      assertTrue(obj instanceof ResourceServingPortlet);
      
      Object obj2 = bm.getReference(bean, TestPortlet1.class, coco);
      assertNotNull(obj2);
      assertFalse(obj.equals(obj2));
      assertFalse(obj == obj2);
   }
   
   @Test
   public void appScopedTest() throws Exception {
      assertNotNull(bm);
      
      Set<Bean<?>> beans = bm.getBeans(TestPortlet1AppScoped.class);
      Bean<?> bean = bm.resolve(beans);
      assertNotNull(bean);
      
      CreationalContext<?> coco = bm.createCreationalContext(bean);
      assertNotNull(coco);
      
      Object obj = bm.getReference(bean, TestPortlet1AppScoped.class, coco);
      assertNotNull(obj);
      assertTrue(obj instanceof GenericPortlet);
      assertTrue(obj instanceof Portlet);
      assertTrue(obj instanceof HeaderPortlet);
      assertTrue(obj instanceof EventPortlet);
      assertTrue(obj instanceof ResourceServingPortlet);
      
      Object obj2 = bm.getReference(bean, TestPortlet1AppScoped.class, coco);
      assertNotNull(obj2);
      assertTrue(obj.equals(obj2));
      assertTrue(obj == obj2);
   }
   
   @Test
   public void appScopedTest2Coco() throws Exception {
      assertNotNull(bm);
      
      Set<Bean<?>> beans = bm.getBeans(TestPortlet1AppScoped.class);
      Bean<?> bean = bm.resolve(beans);
      assertNotNull(bean);
      
      CreationalContext<?> coco1 = bm.createCreationalContext(bean);
      assertNotNull(coco1);
      
      Object obj = bm.getReference(bean, TestPortlet1AppScoped.class, coco1);
      assertNotNull(obj);
      assertTrue(obj instanceof GenericPortlet);
      assertTrue(obj instanceof Portlet);
      assertTrue(obj instanceof HeaderPortlet);
      assertTrue(obj instanceof EventPortlet);
      assertTrue(obj instanceof ResourceServingPortlet);
      
      CreationalContext<?> coco2 = bm.createCreationalContext(bean);
      assertNotNull(coco2);
      
      Object obj2 = bm.getReference(bean, TestPortlet1AppScoped.class, coco2);
      assertNotNull(obj2);
      assertTrue(obj.equals(obj2));
      assertTrue(obj == obj2);
   }
   
   @Test
   public void appScopedTest2Coco2Bean() throws Exception {
      assertNotNull(bm);
      
      Set<Bean<?>> beans1 = bm.getBeans(TestPortlet1AppScoped.class);
      Bean<?> bean1 = bm.resolve(beans1);
      assertNotNull(bean1);
      
      CreationalContext<?> coco1 = bm.createCreationalContext(bean1);
      assertNotNull(coco1);
      
      Object obj = bm.getReference(bean1, TestPortlet1AppScoped.class, coco1);
      assertNotNull(obj);
      assertTrue(obj instanceof GenericPortlet);
      assertTrue(obj instanceof Portlet);
      assertTrue(obj instanceof HeaderPortlet);
      assertTrue(obj instanceof EventPortlet);
      assertTrue(obj instanceof ResourceServingPortlet);
      
      Set<Bean<?>> beans2 = bm.getBeans(TestPortlet1AppScoped.class);
      Bean<?> bean2 = bm.resolve(beans2);
      assertNotNull(bean2);
      
      CreationalContext<?> coco2 = bm.createCreationalContext(bean2);
      assertNotNull(coco2);
      
      Object obj2 = bm.getReference(bean2, TestPortlet1AppScoped.class, coco2);
      assertNotNull(obj2);
      assertTrue(obj.equals(obj2));
      assertTrue(obj == obj2);
      
      assertEquals(bean1, bean2);
      assertNotEquals(coco1, coco2);
   }
}
