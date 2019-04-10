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

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.portlet.PortletMode;
import javax.xml.namespace.QName;

import org.apache.pluto.container.bean.processor.AnnotatedMethodStore;
import org.apache.pluto.container.bean.processor.ConfigSummary;
import org.apache.pluto.container.bean.processor.fixtures.InvocationResults;
import org.apache.pluto.container.om.portlet.impl.ConfigurationHolder;
import org.apache.pluto.container.reconcile.fixtures.TestPortlet6;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Tests that if a generic portlet event method is annotated to provide the processing
 * event reference QNames, the methods are part of te same portlet instance.
 * 
 * @author Scott Nicklous
 */
public class GenericPortletFeaturesInvokeTest {
   
   private InvocationResults meths = InvocationResults.getInvocationResults();
   private static InvokeHelper helper;
   private static final Class<?> TEST_ANNOTATED_CLASS1 = TestPortlet6.class;
   private static AnnotatedMethodStore ams = null;
   private static ConfigSummary summary = null;
   private static ConfigurationHolder holder =  new ConfigurationHolder();

   @BeforeClass
   public static void setUpBeforeClass() throws Exception {

      Set<Class<?>> classes = new HashSet<Class<?>>();
      classes.add(TEST_ANNOTATED_CLASS1);

      try {
         holder.processConfigAnnotations(classes);
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
      
      assertNotNull(ams);
      assertNotNull(summary);
      
      helper = new InvokeHelper(ams);
   }

   @Before
   public void setUpBefore() throws Exception {
      helper.init("Portlet6", null);
   }
  
   // Begin portlet 1 tests ================================== 

   @Test
   public void test6init() throws Exception {
      String expectedMeth = TestPortlet6.class.getSimpleName() + "#init";
      helper.init("Portlet6", expectedMeth);
      assertTrue(meths.isConfigExists());
   }

   @Test
   public void test6action() throws Exception {
      String expectedMeth = TestPortlet6.class.getSimpleName() + "#doFred";
      helper.action("Portlet6", "Fred", expectedMeth);
      assertTrue(meths.isConfigExists());
   }

   @Test
   public void test6event1() throws Exception {
      String expectedMeth = TestPortlet6.class.getSimpleName() + "#doEvent1";
      QName qn = new QName("http://www.apache.org/", "event1");
      helper.event("Portlet6", qn, expectedMeth);
      assertTrue(meths.isConfigExists());
   }

   @Test
   public void test6event4() throws Exception {
      String expectedMeth = TestPortlet6.class.getSimpleName() + "#doEvent4";
      QName qn = new QName("https://www.java.net/", "event4");
      helper.event("Portlet6", qn, expectedMeth);
      assertTrue(meths.isConfigExists());
   }

   @Test
   public void test6doView() throws Exception {
      List<String> methNames = Arrays.asList(new String[] {
            TestPortlet6.class.getSimpleName() + "#doHeaders",
            TestPortlet6.class.getSimpleName() + "#doView",
      });
      PortletMode pm = PortletMode.VIEW;
      helper.renderWithHeaders("Portlet6", pm, methNames);
      assertTrue(meths.isConfigExists());
   }

   @Test
   public void test6doHelp() throws Exception {
      List<String> methNames = Arrays.asList(new String[] {
            TestPortlet6.class.getSimpleName() + "#doHeaders",
            TestPortlet6.class.getSimpleName() + "#doHelp",
      });
      PortletMode pm = PortletMode.HELP;
      helper.renderWithHeaders("Portlet6", pm, methNames);
      assertTrue(meths.isConfigExists());
   }

   @Test
   public void test6doEdit() throws Exception {
      List<String> methNames = Arrays.asList(new String[] {
            TestPortlet6.class.getSimpleName() + "#doHeaders",
            TestPortlet6.class.getSimpleName() + "#doEdit",
      });
      PortletMode pm = PortletMode.EDIT;
      helper.renderWithHeaders("Portlet6", pm, methNames);
      assertTrue(meths.isConfigExists());
   }

   @Test
   public void test6doConfig() throws Exception {
      List<String> methNames = Arrays.asList(new String[] {
            TestPortlet6.class.getSimpleName() + "#doHeaders",
            TestPortlet6.class.getSimpleName() + "#doConfig",
      });
      PortletMode pm = new PortletMode("config");
      helper.renderWithHeaders("Portlet6", pm, methNames);
      assertTrue(meths.isConfigExists());
   }

   @Test
   public void test6doAdmin() throws Exception {
      List<String> methNames = Arrays.asList(new String[] {
            TestPortlet6.class.getSimpleName() + "#doHeaders",
            TestPortlet6.class.getSimpleName() + "#doAdmin",
      });
      PortletMode pm = new PortletMode("admin");
      helper.renderWithHeaders("Portlet6", pm, methNames);
      assertTrue(meths.isConfigExists());
   }
   
}
