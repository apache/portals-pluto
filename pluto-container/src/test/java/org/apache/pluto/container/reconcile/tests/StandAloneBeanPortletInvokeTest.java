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
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import javax.portlet.PortletMode;

import org.apache.pluto.container.bean.processor.AnnotatedMethodStore;
import org.apache.pluto.container.bean.processor.ConfigSummary;
import org.apache.pluto.container.bean.processor.fixtures.InvocationResults;
import org.apache.pluto.container.bean.processor.tests.FileHelper;
import org.apache.pluto.container.om.portlet.PortletApplicationDefinition;
import org.apache.pluto.container.om.portlet.impl.ConfigurationHolder;
import org.apache.pluto.container.reconcile.fixtures.TestPortlet4;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Tests that a bean portlet without accompanying configuration data can
 * be recognized and invoked.
 * 
 * @author Scott Nicklous
 */
public class StandAloneBeanPortletInvokeTest {
   
   private static final String pkg = "org.apache.pluto.container.reconcile.fixtures";

   private InvocationResults meths = InvocationResults.getInvocationResults();
   private static InvokeHelper helper;
   private static AnnotatedMethodStore ams = null;
   private static ConfigSummary summary = null;
   private static ConfigurationHolder holder =  new ConfigurationHolder();

   // Classes under test
   private static PortletApplicationDefinition app;

   @BeforeClass
   public static void setUpBeforeClass() throws Exception {
      Set<File> portletMethodClasses = FileHelper.getClasses(pkg);
      
      // remve all files but the portlet 4 class
      Set<File> delFiles = new HashSet<File>();
      for (File file : portletMethodClasses) {
         if (!file.getAbsolutePath().contains("Portlet4")) {
            delFiles.add(file);
         }
      }
      portletMethodClasses.removeAll(delFiles);

      try {
         holder.scanMethodAnnotations(portletMethodClasses);
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
      app = holder.getPad();
      
      assertNotNull(ams);
      assertNotNull(summary);
      
      helper = new InvokeHelper(ams);
   }

   @Before
   public void setUpBefore() throws Exception {
      helper.init("Portlet4", null);
   }
  
   // Begin portlet app tests ==================================
   
   @Test
   public void testNumberPortlets() {
      assertEquals(1, app.getPortlets().size());
      assertNotNull(app.getPortlet("Portlet4"));
   }
   
   // Begin portlet 4 tests ================================== 

   @Test
   public void test4init() throws Exception {
      String expectedMeth = TestPortlet4.class.getSimpleName() + "#init";
      helper.init("Portlet4", expectedMeth);
      assertTrue(meths.isConfigExists());
   }
   
   @Test
   public void test4destroy() throws Exception {
      String expectedMeth = TestPortlet4.class.getSimpleName() + "#destroy";
      helper.destroy("Portlet4", expectedMeth);
      assertTrue(meths.isConfigExists());
   }

   @Test
   public void test4action() throws Exception {
      String expectedMeth = TestPortlet4.class.getSimpleName() + "#doAction";
      helper.action("Portlet4", null, expectedMeth);
      assertTrue(meths.isConfigExists());
   }

   @Test
   public void test4render() throws Exception {
      String expectedMeth = TestPortlet4.class.getSimpleName() + "#myView";
      PortletMode pm = PortletMode.HELP;
      helper.render("Portlet4", pm, expectedMeth);
      assertTrue(meths.isConfigExists());
   }

   @Test
   public void test4resource() throws Exception {
      String expectedMeth = TestPortlet4.class.getSimpleName() + "#res";
      String resid = "something";
      helper.resource("Portlet4", resid, expectedMeth);
      assertTrue(meths.isConfigExists());
   }

}
