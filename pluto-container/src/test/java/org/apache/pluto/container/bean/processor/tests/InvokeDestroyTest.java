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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.apache.pluto.container.bean.processor.AnnotatedMethodStore;
import org.apache.pluto.container.bean.processor.ConfigSummary;
import org.apache.pluto.container.bean.processor.PortletInvoker;
import org.apache.pluto.container.bean.processor.fixtures.InvocationResults;
import org.apache.pluto.container.bean.processor.fixtures.destroy.Destroy1;
import org.apache.pluto.container.bean.processor.fixtures.destroy.Destroy2;
import org.apache.pluto.container.om.portlet.impl.ConfigurationHolder;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test class for destroy method invocation.
 * 
 * @author Scott Nicklous
 *
 */
public class InvokeDestroyTest {
   
   private InvocationResults meths = InvocationResults.getInvocationResults();
   
   private static final String         pkg     = "org.apache.pluto.container.bean.processor.fixtures.destroy";
   
   private static AnnotatedMethodStore ams     = null;
   private static ConfigSummary        summary = null;
   private static ConfigurationHolder  holder  = new ConfigurationHolder();
   
   @BeforeClass
   public static void setUpClass() throws URISyntaxException, IOException {
      Set<File> classes = FileHelper.getClasses(pkg);
      holder.scanMethodAnnotations(classes);
      holder.reconcileBeanConfig();
      holder.instantiatePortlets(null);
      ams = holder.getMethodStore();
      summary = holder.getConfigSummary();

      assertNotNull(ams);
      assertNotNull(summary);
   }
   
   @Test
   public void invoke1() throws Exception {
      meths.reset();
      PortletInvoker i = new PortletInvoker(ams, "portlet1");
      i.destroy();
      List<String> names = meths.getMethods();
      assertNotNull(names);
      assertEquals(1, names.size());
      assertTrue(names.contains(Destroy1.class.getSimpleName() + "#destroy1"));
   }
   
   @Test
   public void invoke2() throws Exception {
      meths.reset();
      PortletInvoker i = new PortletInvoker(ams, "portlet2");
      i.destroy();
      List<String> names = meths.getMethods();
      // there are two valid possibilities
      List<String> meths = Arrays.asList(new String[] {
            Destroy1.class.getSimpleName() + "#destroy2", Destroy2.class.getSimpleName() + "#destroy2",
            });
      assertNotNull(names);
      assertEquals(1, names.size());
      assertTrue(meths.contains(names.get(0)));
   }
   
   @Test
   public void invoke3() throws Exception {
      meths.reset();
      PortletInvoker i = new PortletInvoker(ams, "portlet3");
      i.destroy();
      List<String> names = meths.getMethods();
      assertNotNull(names);
      assertEquals(1, names.size());
      assertTrue(names.contains(Destroy2.class.getSimpleName() + "#destroy1"));
   }
   
}
