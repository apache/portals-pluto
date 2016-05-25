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

import javax.inject.Inject;
import javax.portlet.PortletMode;

import org.apache.pluto.container.bean.processor.AnnotatedConfigBean;
import org.apache.pluto.container.bean.processor.AnnotatedMethodStore;
import org.apache.pluto.container.bean.processor.PortletCDIExtension;
import org.apache.pluto.container.bean.processor.fixtures.InvocationResults;
import org.apache.pluto.container.om.portlet.PortletApplicationDefinition;
import org.apache.pluto.container.om.portlet.impl.ConfigurationHolder;
import org.apache.pluto.container.reconcile.fixtures.TestPortlet4;
import org.jglue.cdiunit.AdditionalClasses;
import org.jglue.cdiunit.CdiRunner;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Tests that a bean portlet without accompanying configuration data can
 * be recognized and invoked.
 * 
 * @author Scott Nicklous
 */
@RunWith(CdiRunner.class)
@AdditionalClasses({PortletCDIExtension.class, InvokeHelper.class, TestPortlet4.class})
public class StandAloneBeanPortletInvokeTest {
   
   @Inject
   private InvocationResults meths;
   
   @Inject
   private InvokeHelper helper;
   
   @Inject
   AnnotatedConfigBean acb;
   
   // Classes under test
   private AnnotatedMethodStore ams = null;
   private PortletApplicationDefinition app;

   @BeforeClass
   public static void setUpBeforeClass() throws Exception {
   }

   @Before
   public void setUpBefore() throws Exception {
      assertNotNull(acb);
      ams = acb.getMethodStore();
      assertNotNull(ams);
      assertNotNull(helper);

      ConfigurationHolder coho = new ConfigurationHolder();
      coho.reconcileBeanConfig(ams);
      app = coho.getPad();
      
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
   public void test4action() throws Exception {
      String expectedMeth = TestPortlet4.class.getSimpleName() + "#doAction";
      helper.action("Portlet4", null, expectedMeth);
   }

   @Test
   public void test4render() throws Exception {
      String expectedMeth = TestPortlet4.class.getSimpleName() + "#myView";
      PortletMode pm = PortletMode.HELP;
      helper.render("Portlet4", pm, expectedMeth);
   }

   @Test
   public void test4resource() throws Exception {
      String expectedMeth = TestPortlet4.class.getSimpleName() + "#res";
      String resid = "something";
      helper.resource("Portlet4", resid, expectedMeth);
   }

}
