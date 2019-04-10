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

import static org.apache.pluto.container.bean.processor.MethodType.HEADER;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.xml.namespace.QName;

import org.apache.pluto.container.bean.processor.AnnotatedMethod;
import org.apache.pluto.container.bean.processor.AnnotatedMethodStore;
import org.apache.pluto.container.bean.processor.ConfigSummary;
import org.apache.pluto.container.bean.processor.MethodIdentifier;
import org.apache.pluto.container.bean.processor.fixtures.header.Header1;
import org.apache.pluto.container.bean.processor.fixtures.header.Header2;
import org.apache.pluto.container.om.portlet.impl.ConfigurationHolder;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test class for header method annotations
 * 
 * @author Scott Nicklous
 *
 */
public class HeaderTest {
   
   private static final String pkg = "org.apache.pluto.container.bean.processor.fixtures.header";
   
   private static AnnotatedMethodStore ams = null;
   private static ConfigSummary summary = null;
   private static ConfigurationHolder holder =  new ConfigurationHolder();
   
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
   public void portletNamesTest() throws Exception {
      Set<String> names = ams.getPortletNames();
      assertNotNull(names);
      assertEquals(6, names.size());
      assertTrue(names.contains("portlet1"));
      assertTrue(names.contains("portlet2"));
      assertTrue(names.contains("*"));
      assertTrue(names.contains("portlet3"));
      assertTrue(names.contains("portlet6"));
      assertTrue(names.contains("portlet7"));
   }

   @Test
   public void errorBadReturnType() throws Exception {
      List<String> names = summary.getPortletsWithErrors();
      assertNotNull(names);
      assertEquals(4, names.size());
      assertTrue(names.contains("portlet5"));
   }

   @Test
   public void errorBadParameters() throws Exception {
      List<String> names = summary.getPortletsWithErrors();
      assertNotNull(names);
      assertEquals(4, names.size());
      assertTrue(names.contains("portlet4"));
   }

   @Test
   public void errorBadException() throws Exception {
      List<String> names = summary.getPortletsWithErrors();
      assertNotNull(names);
      assertEquals(4, names.size());
      assertTrue(names.contains("portlet8"));
   }

   @Test
   public void errorBadAsterisk() throws Exception {
      List<String> names = summary.getPortletsWithErrors();
      assertNotNull(names);
      assertEquals(4, names.size());
      assertTrue(names.contains("*"));
   }

   @Test
   public void methods1Test() throws Exception {
      Set<MethodIdentifier> portlets = ams.getMethodIDsForPortlet("portlet1");
      assertNotNull(portlets);
      List<String> ids = Arrays.asList(new String[] { "", "ADMIN" });
      assertEquals(2, portlets.size());
      for (MethodIdentifier mi : portlets) {
         assertEquals(HEADER, mi.getType());
         assertTrue(ids.contains(mi.getId()));
         assertEquals("portlet1", mi.getName());
      }
   }

   @Test
   public void methods2Test() throws Exception {
      Set<MethodIdentifier> portlets = ams.getMethodIDsForPortlet("portlet2");
      assertNotNull(portlets);
      List<String> ids = Arrays.asList(new String[] { "HELP", "EDIT", "CONFIG", "ADMIN" });
      assertEquals(4, portlets.size());
      for (MethodIdentifier mi : portlets) {
         assertEquals(HEADER, mi.getType());
         assertTrue(ids.contains(mi.getId()));
         assertEquals("portlet2", mi.getName());
      }
   }

   @Test
   public void methods3Test() throws Exception {
      Set<MethodIdentifier> portlets = ams.getMethodIDsForPortlet("portlet3");
      assertNotNull(portlets);
      assertEquals(3, portlets.size());
      List<String> ids = Arrays.asList(new String[] { "", "ADMIN", "HELP" });
      for (MethodIdentifier mi : portlets) {
         assertEquals(HEADER, mi.getType());
         assertTrue(ids.contains(mi.getId()));
         assertEquals("portlet3", mi.getName());
      }
   }

   @Test
   public void class1Test() throws Exception {
      MethodIdentifier mi = new MethodIdentifier("portlet1", "", HEADER);
      List<AnnotatedMethod> list = ams.getMethods(mi);
      assertNotNull(list);
      assertEquals(3, list.size());
      List<String> names = Arrays.asList(new String[] { "header1a", "header1b", "header1c" });
      for (AnnotatedMethod am : list) {
         Method m = am.getJavaMethod();
         assertNotNull(m);
         assertTrue(names.contains(m.getName()));
         assertEquals(Header1.class, m.getDeclaringClass());
      }
   }

   @Test
   public void class1aTest() throws Exception {
      MethodIdentifier mi = new MethodIdentifier("portlet1", "ADMIN", HEADER);
      List<AnnotatedMethod> list = ams.getMethods(mi);
      assertNotNull(list);
      assertEquals(1, list.size());
      List<String> names = Arrays.asList(new String[] { "headerAll" });
      for (AnnotatedMethod am : list) {
         Method m = am.getJavaMethod();
         assertNotNull(m);
         assertTrue(names.contains(m.getName()));
         assertEquals(Header2.class, m.getDeclaringClass());
      }
   }

   @Test
   public void class2Test() throws Exception {
      MethodIdentifier mi = new MethodIdentifier("portlet2", "", HEADER);
      List<AnnotatedMethod> list = ams.getMethods(mi);
      assertNotNull(list);
      assertEquals(0, list.size());
   }

   @Test
   public void class2aTest() throws Exception {
      MethodIdentifier mi = new MethodIdentifier("portlet2", "ADMIN", HEADER);
      List<AnnotatedMethod> list = ams.getMethods(mi);
      assertNotNull(list);
      assertEquals(1, list.size());
      List<String> names = Arrays.asList(new String[] { "headerAll" });
      for (AnnotatedMethod am : list) {
         Method m = am.getJavaMethod();
         assertNotNull(m);
         assertTrue(names.contains(m.getName()));
         assertEquals(Header2.class, m.getDeclaringClass());
      }
   }

   @Test
   public void class2hTest() throws Exception {
      MethodIdentifier mi = new MethodIdentifier("portlet2", "HELP", HEADER);
      List<AnnotatedMethod> list = ams.getMethods(mi);
      assertNotNull(list);
      assertEquals(1, list.size());
      List<String> names = Arrays.asList(new String[] { "header2a" });
      for (AnnotatedMethod am : list) {
         Method m = am.getJavaMethod();
         assertNotNull(m);
         assertTrue(names.contains(m.getName()));
         assertEquals(Header1.class, m.getDeclaringClass());
      }
   }

   @Test
   public void class2bTest() throws Exception {
      MethodIdentifier mi = new MethodIdentifier("portlet2", "EDIT", HEADER);
      List<AnnotatedMethod> list = ams.getMethods(mi);
      assertNotNull(list);
      assertEquals(3, list.size());
      List<String> names = Arrays.asList(new String[] { "header2c", "header2b", "header2d" });
      List<String> methNames = new ArrayList<String>();
      for (AnnotatedMethod am : list) {
         Method m = am.getJavaMethod();
         assertNotNull(m);
         assertTrue(names.contains(m.getName()));
         methNames.add(m.getName());
      }
      // verify order
      assertArrayEquals(names.toArray(), methNames.toArray());
   }

   @Test
   public void class2cTest() throws Exception {
      MethodIdentifier mi = new MethodIdentifier("portlet2", "CONFIG", HEADER);
      List<AnnotatedMethod> list = ams.getMethods(mi);
      assertNotNull(list);
      assertEquals(1, list.size());
      List<String> names = Arrays.asList(new String[] { "header2c" });
      for (AnnotatedMethod am : list) {
         Method m = am.getJavaMethod();
         assertNotNull(m);
         assertTrue(names.contains(m.getName()));
         assertEquals(Header1.class, m.getDeclaringClass());
      }
   }

   @Test
   public void class3Test() throws Exception {
      MethodIdentifier mi = new MethodIdentifier("portlet3", "", HEADER);
      List<AnnotatedMethod> list = ams.getMethods(mi);
      assertNotNull(list);
      assertEquals(3, list.size());
      List<String> names = Arrays.asList(new String[] { "header3c", "header3a", "header3b" });
      List<String> methNames = new ArrayList<String>();
      for (AnnotatedMethod am : list) {
         Method m = am.getJavaMethod();
         assertNotNull(m);
         assertTrue(names.contains(m.getName()));
         methNames.add(m.getName());
      }
      // verify order
      assertArrayEquals(names.toArray(), methNames.toArray());
   }

   @Test
   public void class3aTest() throws Exception {
      MethodIdentifier mi = new MethodIdentifier("portlet3", "ADMIN", HEADER);
      List<AnnotatedMethod> list = ams.getMethods(mi);
      assertNotNull(list);
      assertEquals(1, list.size());
      List<String> names = Arrays.asList(new String[] { "headerAll" });
      for (AnnotatedMethod am : list) {
         Method m = am.getJavaMethod();
         assertNotNull(m);
         assertTrue(names.contains(m.getName()));
         assertEquals(Header2.class, m.getDeclaringClass());
      }
   }

   @Test
   public void class6Test() throws Exception {
      MethodIdentifier mi = new MethodIdentifier("portlet6", "", HEADER);
      List<AnnotatedMethod> list = ams.getMethods(mi);
      assertNotNull(list);
      assertEquals(2, list.size());
      List<String> names = Arrays.asList(new String[] { "header6and7", "header6andStar" });
      List<String> methNames = new ArrayList<String>();
      for (AnnotatedMethod am : list) {
         Method m = am.getJavaMethod();
         assertNotNull(m);
         assertTrue(names.contains(m.getName()));
         methNames.add(m.getName());
      }
      // verify order
      assertArrayEquals(names.toArray(), methNames.toArray());
   }

   @Test
   public void class6aTest() throws Exception {
      MethodIdentifier mi = new MethodIdentifier("portlet6", "ADMIN", HEADER);
      List<AnnotatedMethod> list = ams.getMethods(mi);
      assertNotNull(list);
      assertEquals(1, list.size());
      List<String> names = Arrays.asList(new String[] { "headerAll" });
      for (AnnotatedMethod am : list) {
         Method m = am.getJavaMethod();
         assertNotNull(m);
         assertTrue(names.contains(m.getName()));
         assertEquals(Header2.class, m.getDeclaringClass());
      }
   }

   @Test
   public void class7Test() throws Exception {
      MethodIdentifier mi = new MethodIdentifier("portlet7", "", HEADER);
      List<AnnotatedMethod> list = ams.getMethods(mi);
      assertNotNull(list);
      assertEquals(1, list.size());
      List<String> names = Arrays.asList(new String[] { "header6and7" });
      List<String> methNames = new ArrayList<String>();
      for (AnnotatedMethod am : list) {
         Method m = am.getJavaMethod();
         assertNotNull(m);
         assertTrue(names.contains(m.getName()));
         methNames.add(m.getName());
         assertEquals(Header2.class, m.getDeclaringClass());
      }
   }

   @Test
   public void class7aTest() throws Exception {
      MethodIdentifier mi = new MethodIdentifier("portlet7", "ADMIN", HEADER);
      List<AnnotatedMethod> list = ams.getMethods(mi);
      assertNotNull(list);
      assertEquals(1, list.size());
      List<String> names = Arrays.asList(new String[] { "headerAll" });
      for (AnnotatedMethod am : list) {
         Method m = am.getJavaMethod();
         assertNotNull(m);
         assertTrue(names.contains(m.getName()));
         assertEquals(Header2.class, m.getDeclaringClass());
      }
   }

   @Test
   public void pubEvent1Test() throws Exception {
      List<QName> qns = ams.getPublishingEventRefs("portlet1");
      assertNotNull(qns);
      assertEquals(0, qns.size());
   }

   @Test
   public void procEvent1Test() throws Exception {
      List<QName> qns = ams.getProcessingEventRefs("portlet3");
      assertNotNull(qns);
      assertEquals(0, qns.size());
   }

}
