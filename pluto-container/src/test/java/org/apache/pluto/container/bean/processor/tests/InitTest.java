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
import java.util.List;
import java.util.Set;

import org.apache.pluto.container.bean.processor.AnnotatedMethodStore;
import org.apache.pluto.container.bean.processor.ConfigSummary;
import org.apache.pluto.container.om.portlet.impl.ConfigurationHolder;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test class for the InitMethod annotated methods.
 * 
 * @author Scott Nicklous
 *
 */
public class InitTest {
   private static final String         pkg     = "org.apache.pluto.container.bean.processor.fixtures.init";
   
   private static AnnotatedMethodStore ams     = null;
   private static ConfigSummary        summary = null;
   private static ConfigurationHolder  holder  = new ConfigurationHolder();
   
   @BeforeClass
   public static void setUpClass() throws URISyntaxException, IOException {
      Set<File> classes = FileHelper.getClasses(pkg);
      holder.scanMethodAnnotations(classes);
      ams = holder.getMethodStore();
      summary = holder.getConfigSummary();

      assertNotNull(ams);
      assertNotNull(summary);
   }
   
   @Test
   public void portletNamesTest() throws Exception {
      Set<String> names = ams.getPortletNames();
      assertNotNull(names);
      assertEquals(3, names.size());
      assertTrue(names.contains("portlet1"));
      assertTrue(names.contains("portlet2"));
      assertTrue(names.contains("portlet3"));
   }
   
   @Test
   public void errorDuplicateMethod() throws Exception {
      List<String> names = summary.getPortletsWithErrors();
      assertNotNull(names);
      assertEquals(3, names.size());
      assertTrue(names.contains("portlet2"));
   }
   
   @Test
   public void errorBadReturnType() throws Exception {
      List<String> names = summary.getPortletsWithErrors();
      assertNotNull(names);
      assertEquals(3, names.size());
      assertTrue(names.contains("portlet5"));
   }
   
   @Test
   public void errorBadParameters() throws Exception {
      List<String> names = summary.getPortletsWithErrors();
      assertNotNull(names);
      assertEquals(3, names.size());
      assertTrue(names.contains("portlet4"));
   }
   
}
