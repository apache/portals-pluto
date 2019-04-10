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


package org.apache.pluto.container.om.portlet.impl.jsr362;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.apache.pluto.container.om.portlet.InitParam;
import org.apache.pluto.container.om.portlet.LocaleText;
import org.apache.pluto.container.om.portlet.PortletApplicationDefinition;
import org.apache.pluto.container.om.portlet.PortletDefinition;
import org.apache.pluto.container.om.portlet.PortletInfo;
import org.apache.pluto.container.om.portlet.impl.ConfigurationHolder;
import org.apache.pluto.container.om.portlet.impl.InitParamImpl;
import org.apache.pluto.container.om.portlet.impl.LocaleTextImpl;
import org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl;
import org.apache.pluto.container.om.portlet.impl.PortletDefinitionImpl;
import org.apache.pluto.container.om.portlet.impl.fixtures.TestMultiAnnotatedPortlet;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test class for a portlet configurations annotation containing multiple portlets along 
 * with a portlet app annotation. 
 * <p>
 * Test Class: TestMultiAnnotatedPortlet
 * 
 * @author Scott Nicklous
 */
public class MultiAnnotatedPortletTest {

   private static final Class<?> TEST_ANNOTATED_CLASS = TestMultiAnnotatedPortlet.class;

   private static PortletApplicationDefinition pad, app;

   // Class under test
   private PortletDefinition portlet1;
   private PortletDefinition portlet2;
   private PortletDefinition portlet3;

   @BeforeClass
   public static void setUpBeforeClass() throws Exception {

      Set<Class<?>> classes = new HashSet<Class<?>>();
      classes.add(TEST_ANNOTATED_CLASS);

      ConfigurationHolder ch = new ConfigurationHolder();
      try {
         ch.processConfigAnnotations(classes);
         pad = ch.getPad();
      } catch (Exception e) {
         e.printStackTrace();
         throw e;
      }
   }

   @Before
   public void setUpBefore() throws Exception {
      assertEquals(3, pad.getPortlets().size());
      assertNotNull(pad.getPortlet("Portlet1"));
      assertNotNull(pad.getPortlet("Portlet2"));
      assertNotNull(pad.getPortlet("Portlet3"));
      app = new PortletApplicationDefinitionImpl(pad);
      portlet1 = new PortletDefinitionImpl(pad.getPortlet("Portlet1"));
      portlet2 = new PortletDefinitionImpl(pad.getPortlet("Portlet2"));
      portlet3 = new PortletDefinitionImpl(pad.getPortlet("Portlet3"));
   }

   // Begin portlet app tests ==================================
   

   /**
    * Test method for version from annotation
    */
   @Test
   public void testGetVersion() {
      String val = app.getVersion();
      assertEquals("3.0", val);
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#getResourceBundle()}.
    */
   @Test
   public void testGetResourceBundle() {
      String val = app.getResourceBundle();
      assertEquals("org.apache.pluto.container.om.portlet.GoodBundle", val);
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#getDefaultNamespace()}.
    */
   @Test
   public void testGetDefaultNamespace() {
      String val = app.getDefaultNamespace();
      assertEquals("https://www.apache.org/", val);
   }

   // Begin portlet 1 tests ================================== 
   
   @Test
   public void testGetPortletName() {
      assertNotNull(portlet1.getPortletName());
      assertEquals("Portlet1", portlet1.getPortletName());
   }

   @Test
   public void testGetApplication() {
      assertNotNull(portlet1.getApplication());
      assertTrue(portlet1.getApplication() instanceof PortletApplicationDefinition);
   }

   @Test
   public void testGetInitParam() {
      String name = "color";
      String val = "#cafeba";
      InitParam ip = portlet1.getInitParam(name);
      assertNotNull(ip);
      assertEquals(name, ip.getParamName());
      assertEquals(val, ip.getParamValue());
   }

   @Test
   public void testGetInitParams() {
      String name = "color";
      String val = "#cafeba";
      List<InitParam> ips = portlet1.getInitParams();
      assertEquals(1, ips.size());
      
      InitParam ip = new InitParamImpl(name, val);
      assertTrue(ips.contains(ip));
      
   }

   @Test
   public void testGetPortletClass() {
      assertNotNull(portlet1.getPortletClass());
      assertEquals(TEST_ANNOTATED_CLASS.getCanonicalName(), portlet1.getPortletClass());
   }

   @Test
   public void testGetTitle() {
      String txt1 = "Annotated Portlet";
      PortletInfo info = portlet1.getPortletInfo();
      assertNotNull(info);
      List<LocaleText> list = info.getTitles();
      assertEquals(1, list.size());
      assertEquals(txt1, info.getTitle(Locale.ENGLISH).getText());
   }

   @Test
   public void testAddTitle() {
      String txt1 = "Annotated Portlet";
      PortletInfo info = portlet1.getPortletInfo();
      assertNotNull(info);
      LocaleText lt = new LocaleTextImpl(Locale.FRENCH, "intitulé");
      info.addTitle(lt);
      List<LocaleText> list = info.getTitles();
      assertEquals(2, list.size());
      assertEquals(txt1, info.getTitle(Locale.ENGLISH).getText());
      assertEquals("intitulé", info.getTitle(Locale.FRENCH).getText());
   }

   @Test
   public void testGetShortTitle() {
      String txt1 = "Anno Portlet";
      PortletInfo info = portlet1.getPortletInfo();
      assertNotNull(info);
      List<LocaleText> list = info.getShortTitles();
      assertEquals(1, list.size());
      assertEquals(txt1, info.getShortTitle(Locale.ENGLISH).getText());
   }

   @Test
   public void testAddShortTitle() {
      String txt1 = "Anno Portlet";
      PortletInfo info = portlet1.getPortletInfo();
      assertNotNull(info);
      String text = "intitulé en bref";
      LocaleText lt = new LocaleTextImpl(Locale.FRENCH, text);
      info.addShortTitle(lt);
      List<LocaleText> list = info.getShortTitles();
      assertEquals(2, list.size());
      assertEquals(txt1, info.getShortTitle(Locale.ENGLISH).getText());
      assertEquals(text, info.getShortTitle(Locale.FRENCH).getText());
   }

   @Test
   public void testGetKeywords() {
      String txt1 = "One, Two, Three";
      PortletInfo info = portlet1.getPortletInfo();
      assertNotNull(info);
      List<LocaleText> list = info.getKeywordsList();
      assertEquals(1, list.size());
      assertEquals(txt1, info.getKeywords(Locale.ENGLISH).getText());
   }

   @Test
   public void testAddKeywords() {
      String txt1 = "One, Two, Three";
      PortletInfo info = portlet1.getPortletInfo();
      assertNotNull(info);
      String text = "mot-clés";
      LocaleText lt = new LocaleTextImpl(Locale.FRENCH, text);
      info.addKeywords(lt);
      List<LocaleText> list = info.getKeywordsList();
      assertEquals(2, list.size());
      assertEquals(text, info.getKeywords(Locale.FRENCH).getText());
      assertEquals(txt1, info.getKeywords(Locale.ENGLISH).getText());
   }
  
   // Begin portlet 2 tests ================================== 
   
   @Test
   public void test2GetPortletName() {
      assertNotNull(portlet2.getPortletName());
      assertEquals("Portlet2", portlet2.getPortletName());
   }

   @Test
   public void test2GetApplication() {
      assertNotNull(portlet2.getApplication());
      assertTrue(portlet2.getApplication() instanceof PortletApplicationDefinition);
   }

   @Test
   public void test2GetInitParam() {
      String name = "color";
      String val = "#def";
      InitParam ip = portlet2.getInitParam(name);
      assertNotNull(ip);
      assertEquals(name, ip.getParamName());
      assertEquals(val, ip.getParamValue());
   }

   @Test
   public void test2GetInitParams() {
      String name = "color";
      String val = "#def";
      List<InitParam> ips = portlet2.getInitParams();
      assertEquals(1, ips.size());
      
      InitParam ip = new InitParamImpl(name, val);
      assertTrue(ips.contains(ip));
      
   }

   @Test
   public void test2GetPortletClass() {
      assertNotNull(portlet2.getPortletClass());
      assertEquals(TEST_ANNOTATED_CLASS.getCanonicalName(), portlet2.getPortletClass());
   }

   @Test
   public void test2GetTitle() {
      String txt2 = "Annotiertes Portlet";
      PortletInfo info = portlet2.getPortletInfo();
      assertNotNull(info);
      List<LocaleText> list = info.getTitles();
      assertEquals(1, list.size());
      assertEquals(txt2, info.getTitle(Locale.GERMAN).getText());
   }

   @Test
   public void test2AddTitle() {
      String txt2 = "Annotiertes Portlet";
      PortletInfo info = portlet2.getPortletInfo();
      assertNotNull(info);
      LocaleText lt = new LocaleTextImpl(Locale.FRENCH, "intitulé");
      info.addTitle(lt);
      List<LocaleText> list = info.getTitles();
      assertEquals(2, list.size());
      assertEquals("intitulé", info.getTitle(Locale.FRENCH).getText());
      assertEquals(txt2, info.getTitle(Locale.GERMAN).getText());
   }

   @Test
   public void test2GetShortTitle() {
      String txt2 = "Ein Portlet";
      PortletInfo info = portlet2.getPortletInfo();
      assertNotNull(info);
      List<LocaleText> list = info.getShortTitles();
      assertEquals(1, list.size());
      assertEquals(txt2, info.getShortTitle(Locale.GERMAN).getText());
   }

   @Test
   public void test2AddShortTitle() {
      String txt2 = "Ein Portlet";
      PortletInfo info = portlet2.getPortletInfo();
      assertNotNull(info);
      String text = "intitulé en bref";
      LocaleText lt = new LocaleTextImpl(Locale.FRENCH, text);
      info.addShortTitle(lt);
      List<LocaleText> list = info.getShortTitles();
      assertEquals(2, list.size());
      assertEquals(text, info.getShortTitle(Locale.FRENCH).getText());
      assertEquals(txt2, info.getShortTitle(Locale.GERMAN).getText());
   }

   @Test
   public void test2GetKeywords() {
      String txt2 = "Eins, Zwei, Drei";
      PortletInfo info = portlet2.getPortletInfo();
      assertNotNull(info);
      List<LocaleText> list = info.getKeywordsList();
      assertEquals(1, list.size());
      assertEquals(txt2, info.getKeywords(Locale.GERMAN).getText());
   }

   @Test
   public void test2AddKeywords() {
      String txt2 = "Eins, Zwei, Drei";
      PortletInfo info = portlet2.getPortletInfo();
      assertNotNull(info);
      String text = "mot-clés";
      LocaleText lt = new LocaleTextImpl(Locale.FRENCH, text);
      info.addKeywords(lt);
      List<LocaleText> list = info.getKeywordsList();
      assertEquals(2, list.size());
      assertEquals(text, info.getKeywords(Locale.FRENCH).getText());
      assertEquals(txt2, info.getKeywords(Locale.GERMAN).getText());
   }
   
   @Test
   public void testAsyncSupportedDefault() throws Exception {
      assertFalse(portlet1.isAsyncSupported());
   }
   
   @Test
   public void testAsyncSupportedTrue() throws Exception {
      assertTrue(portlet2.isAsyncSupported());
   }
   
   @Test
   public void testAsyncSupportedFalse() throws Exception {
      assertFalse(portlet3.isAsyncSupported());
   }
   
   @Test
   public void testMultipartSupportedDefault() throws Exception {
      assertFalse(portlet1.isMultipartSupported());
   }
   
   @Test
   public void testMultipartSupportedTrue() throws Exception {
      assertFalse(portlet2.isMultipartSupported());
   }
   
   @Test
   public void testMultipartSupportedFalse() throws Exception {
      assertTrue(portlet3.isMultipartSupported());

      assertEquals("/home", portlet3.getLocation());
      assertEquals(new Integer(11), portlet3.getFileSizeThreshold());
      assertEquals(new Long(22), portlet3.getMaxFileSize());
      assertEquals(new Long(33), portlet3.getMaxRequestSize());
   }

}
