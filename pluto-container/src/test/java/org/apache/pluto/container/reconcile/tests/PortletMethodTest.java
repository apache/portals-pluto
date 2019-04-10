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
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

import javax.xml.namespace.QName;

import org.apache.pluto.container.bean.processor.AnnotatedMethodStore;
import org.apache.pluto.container.bean.processor.ConfigSummary;
import org.apache.pluto.container.bean.processor.MethodIdentifier;
import org.apache.pluto.container.bean.processor.MethodType;
import org.apache.pluto.container.bean.processor.tests.FileHelper;
import org.apache.pluto.container.om.portlet.PortletApplicationDefinition;
import org.apache.pluto.container.om.portlet.impl.ConfigurationHolder;
import org.apache.pluto.container.reconcile.fixtures.TestPortlet1;
import org.apache.pluto.container.reconcile.fixtures.TestPortlet2;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Tests that the expected portlet methods are present for a portlet app with several
 * portlets, including bean portlets with no explicit configuration.
 * 
 * @author Scott Nicklous
 */
public class PortletMethodTest {

   private static final Class<?> TEST_ANNOTATED_CLASS1 = TestPortlet1.class;
   private static final Class<?> TEST_ANNOTATED_CLASS2 = TestPortlet2.class;
   private static final String XML_FILE = 
         "org/apache/pluto/container/om/portlet/portlet362Reconcile.xml";

   private static final String pkg = "org.apache.pluto.container.reconcile.fixtures";

   private static AnnotatedMethodStore ams = null;
   private static ConfigSummary summary = null;
   private static ConfigurationHolder holder =  new ConfigurationHolder();

   // Classes under test
   private static PortletApplicationDefinition app;

   @BeforeClass
   public static void setUpBeforeClass() throws Exception {
      Set<File> portletMethodClasses = FileHelper.getClasses(pkg);
      
      InputStream in = PortletInvokeTest.class
            .getClassLoader().getResourceAsStream(XML_FILE);


      Set<Class<?>> configClasses = new HashSet<Class<?>>();
      configClasses.add(TEST_ANNOTATED_CLASS1);
      configClasses.add(TEST_ANNOTATED_CLASS2);

      try {
         holder.scanMethodAnnotations(portletMethodClasses);
         holder.processConfigAnnotations(configClasses);
         holder.processPortletDD(in);     // process portlet xml after annotations
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
   }

   // Begin portlet app tests ==================================
   
   @Test
   public void testNumberPortlets() {
      assertEquals(4, app.getPortlets().size());
      assertNotNull(app.getPortlet("Portlet1"));
      assertNotNull(app.getPortlet("Portlet2"));
      assertNotNull(app.getPortlet("Portlet3"));
      assertNotNull(app.getPortlet("Portlet4"));
   }
  
   // Begin portlet 1 tests ================================== 

   @Test
   public void test1Contains() throws Exception {
      Set<MethodIdentifier> meths = ams.getMethodIDsForPortlet("Portlet1");
      assertNotNull(meths);
      assertEquals(10, meths.size());
   }
   
   @Test
   public void test1init() throws Exception {
      MethodIdentifier mi = new MethodIdentifier("Portlet1", "", MethodType.INIT);
      assertNotNull(ams.getMethod(mi));
   }
   
   @Test
   public void test1destroy() throws Exception {
      MethodIdentifier mi = new MethodIdentifier("Portlet1", "", MethodType.DESTROY);
      assertNotNull(ams.getMethod(mi));
   }
   
   @Test
   public void test1action1() throws Exception {
      MethodIdentifier mi = new MethodIdentifier("Portlet1", "", MethodType.ACTION);
      assertNotNull(ams.getMethod(mi));
   }
   
   @Test
   public void test1action2() throws Exception {
      MethodIdentifier mi = new MethodIdentifier("Portlet1", "Fred", MethodType.ACTION);
      assertNotNull(ams.getMethod(mi));
   }
   
   @Test
   public void test1event1() throws Exception {
      MethodIdentifier mi = new MethodIdentifier("Portlet1", "", MethodType.EVENT);
      assertNotNull(ams.getMethod(mi));
   }
   
   @Test
   public void test1event2() throws Exception {
      QName qn = new QName("http://www.apache.org/", "event1");
      MethodIdentifier mi = new MethodIdentifier("Portlet1", qn, MethodType.EVENT);
      assertNotNull(ams.getMethod(mi));
   }
   
   @Test
   public void test1event3() throws Exception {
      QName qn = new QName("https://www.java.net/", "event3");
      MethodIdentifier mi = new MethodIdentifier("Portlet1", qn, MethodType.EVENT);
      assertNotNull(ams.getMethod(mi));
   }
   
   @Test
   public void test1render() throws Exception {
      MethodIdentifier mi = new MethodIdentifier("Portlet1", "", MethodType.RENDER);
      assertTrue(ams.getMethods(mi).size() > 0);
   }
   
   @Test
   public void test1res() throws Exception {
      MethodIdentifier mi = new MethodIdentifier("Portlet1", "", MethodType.RESOURCE);
      assertTrue(ams.getMethods(mi).size() > 0);
   }
   
   @Test
   public void test1headers() throws Exception {
      MethodIdentifier mi = new MethodIdentifier("Portlet1", "", MethodType.HEADER);
      assertTrue(ams.getMethods(mi).size() > 0);
   }
   
   // Begin portlet 2 tests ================================== 

   @Test
   public void test2Contains() throws Exception {
      Set<MethodIdentifier> meths = ams.getMethodIDsForPortlet("Portlet2");
      assertNotNull(meths);
      assertEquals(4, meths.size());
   }
   
   @Test
   public void test2action1() throws Exception {
      MethodIdentifier mi = new MethodIdentifier("Portlet2", "", MethodType.ACTION);
      assertNotNull(ams.getMethod(mi));
   }
   
   @Test
   public void test2event1() throws Exception {
      QName qn = new QName("http://www.apache.org/", "event2");
      MethodIdentifier mi = new MethodIdentifier("Portlet2", qn, MethodType.EVENT);
      assertNotNull(ams.getMethod(mi));
   }
   
   @Test
   public void test2event2() throws Exception {
      QName qn = new QName("https://www.java.net/", "event4");
      MethodIdentifier mi = new MethodIdentifier("Portlet2", qn, MethodType.EVENT);
      assertNotNull(ams.getMethod(mi));
   }
   
   @Test
   public void test2render() throws Exception {
      MethodIdentifier mi = new MethodIdentifier("Portlet2", "VIEW", MethodType.RENDER);
      assertTrue(ams.getMethods(mi).size() > 0);
   }
   
   // Begin portlet 3 tests ================================== 

   @Test
   public void test3Contains() throws Exception {
      Set<MethodIdentifier> meths = ams.getMethodIDsForPortlet("Portlet3");
      assertNotNull(meths);
      assertEquals(4, meths.size());
   }
   
   @Test
   public void test3init() throws Exception {
      MethodIdentifier mi = new MethodIdentifier("Portlet3", "", MethodType.INIT);
      assertNotNull(ams.getMethod(mi));
   }
   
   @Test
   public void test3destroy() throws Exception {
      MethodIdentifier mi = new MethodIdentifier("Portlet3", "", MethodType.DESTROY);
      assertNotNull(ams.getMethod(mi));
   }
   
   @Test
   public void test3action1() throws Exception {
      MethodIdentifier mi = new MethodIdentifier("Portlet3", "", MethodType.ACTION);
      assertNotNull(ams.getMethod(mi));
   }
   
   @Test
   public void test3render() throws Exception {
      MethodIdentifier mi = new MethodIdentifier("Portlet3", "", MethodType.RENDER);
      assertTrue(ams.getMethods(mi).size() > 0);
   }
   
   // Begin portlet 4 tests ================================== 

   @Test
   public void test4Contains() throws Exception {
      Set<MethodIdentifier> meths = ams.getMethodIDsForPortlet("Portlet4");
      assertNotNull(meths);
      assertEquals(7, meths.size());
   }
   
   @Test
   public void test4init() throws Exception {
      MethodIdentifier mi = new MethodIdentifier("Portlet4", "", MethodType.INIT);
      assertNotNull(ams.getMethod(mi));
   }
   
   @Test
   public void test4destroy() throws Exception {
      MethodIdentifier mi = new MethodIdentifier("Portlet4", "", MethodType.DESTROY);
      assertNotNull(ams.getMethod(mi));
   }
   
   @Test
   public void test4action1() throws Exception {
      MethodIdentifier mi = new MethodIdentifier("Portlet4", "", MethodType.ACTION);
      assertNotNull(ams.getMethod(mi));
   }
   
   @Test
   public void test4event2() throws Exception {
      QName qn = new QName("http://www.apache.org/", "event2");
      MethodIdentifier mi = new MethodIdentifier("Portlet4", qn, MethodType.EVENT);
      assertNotNull(ams.getMethod(mi));
   }
   
   @Test
   public void test4event3() throws Exception {
      QName qn = new QName("https://www.java.net/", "event4");
      MethodIdentifier mi = new MethodIdentifier("Portlet4", qn, MethodType.EVENT);
      assertNotNull(ams.getMethod(mi));
   }
   
   @Test
   public void test4render() throws Exception {
      MethodIdentifier mi = new MethodIdentifier("Portlet4", "", MethodType.RENDER);
      assertTrue(ams.getMethods(mi).size() > 0);
   }
   
   @Test
   public void test4res() throws Exception {
      MethodIdentifier mi = new MethodIdentifier("Portlet4", "", MethodType.RESOURCE);
      assertTrue(ams.getMethods(mi).size() > 0);
   }

}
