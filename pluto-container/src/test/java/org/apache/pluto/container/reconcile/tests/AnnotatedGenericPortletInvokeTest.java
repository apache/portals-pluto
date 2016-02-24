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

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;
import javax.portlet.PortletMode;
import javax.xml.namespace.QName;

import org.apache.pluto.container.bean.processor.AnnotatedConfigBean;
import org.apache.pluto.container.bean.processor.AnnotatedMethodStore;
import org.apache.pluto.container.bean.processor.PortletCDIExtension;
import org.apache.pluto.container.bean.processor.fixtures.InvocationResults;
import org.apache.pluto.container.om.portlet.PortletApplicationDefinition;
import org.apache.pluto.container.om.portlet.impl.ConfigurationHolder;
import org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl;
import org.apache.pluto.container.reconcile.fixtures.TestPortlet5;
import org.jglue.cdiunit.AdditionalClasses;
import org.jglue.cdiunit.CdiRunner;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Tests that if a generic portlet event method is annotated to provide the processing
 * event reference QNames, the methods are part of te same portlet instance.
 * 
 * @author Scott Nicklous
 */
@RunWith(CdiRunner.class)
@AdditionalClasses({PortletCDIExtension.class, InvokeHelper.class, TestPortlet5.class})
public class AnnotatedGenericPortletInvokeTest {
   
   @Inject
   private InvocationResults meths;
   
   @Inject
   private InvokeHelper helper;

   private static final Class<?> TEST_ANNOTATED_CLASS1 = TestPortlet5.class;

   private static PortletApplicationDefinition pad;
   
   @Inject
   AnnotatedConfigBean acb;
   
   // Classes under test
   private AnnotatedMethodStore ams = null;
   private PortletApplicationDefinition app;

   @BeforeClass
   public static void setUpBeforeClass() throws Exception {

      Set<Class<?>> classes = new HashSet<Class<?>>();
      classes.add(TEST_ANNOTATED_CLASS1);

      ConfigurationHolder ch = new ConfigurationHolder();
      try {
         ch.processConfigAnnotations(classes);
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
      assertNotNull(helper);

      app = new PortletApplicationDefinitionImpl(pad);
      ConfigurationHolder coho = new ConfigurationHolder(app);
      coho.reconcileBeanConfig(ams);
      
      helper.init("Portlet5", null);
   }
  
   // Begin portlet 1 tests ================================== 

   @Test
   public void test1init() throws Exception {
      String expectedMeth = TestPortlet5.class.getSimpleName() + "#init";
      helper.init("Portlet5", expectedMeth);
      assertTrue(meths.isConfigExists());
   }

   @Test
   public void test1destroy() throws Exception {
      String expectedMeth = TestPortlet5.class.getSimpleName() + "#destroy";
      helper.destroy("Portlet5", expectedMeth);
      assertTrue(meths.isConfigExists());
   }

   @Test
   public void test1action() throws Exception {
      String expectedMeth = TestPortlet5.class.getSimpleName() + "#processAction";
      helper.action("Portlet5", null, expectedMeth);
      assertTrue(meths.isConfigExists());
   }

   @Test
   public void test1event1() throws Exception {
      String expectedMeth = TestPortlet5.class.getSimpleName() + "#processEvent";
      QName qn = new QName("http://www.apache.org/", "event1");
      helper.event("Portlet5", qn, expectedMeth);
      assertTrue(meths.isConfigExists());
   }

   @Test
   public void test1event2() throws Exception {
      String expectedMeth = TestPortlet5.class.getSimpleName() + "#processEvent";
      QName qn = new QName("https://www.java.net/", "event4");
      helper.event("Portlet5", qn, expectedMeth);
      assertTrue(meths.isConfigExists());
   }

   @Test
   public void test1header() throws Exception {
      String expectedMeth = TestPortlet5.class.getSimpleName() + "#renderHeaders";
      PortletMode pm = PortletMode.VIEW;
      helper.header("Portlet5", pm, expectedMeth);
      assertTrue(meths.isConfigExists());
   }

   @Test
   public void test1render() throws Exception {
      String expectedMeth = TestPortlet5.class.getSimpleName() + "#render";
      PortletMode pm = PortletMode.VIEW;
      helper.render("Portlet5", pm, expectedMeth);
      assertTrue(meths.isConfigExists());
   }

   @Test
   public void test1res() throws Exception {
      String expectedMeth = TestPortlet5.class.getSimpleName() + "#serveResource";
      String resid = null;
      helper.resource("Portlet5", resid, expectedMeth);
      assertTrue(meths.isConfigExists());
   }
   
}
