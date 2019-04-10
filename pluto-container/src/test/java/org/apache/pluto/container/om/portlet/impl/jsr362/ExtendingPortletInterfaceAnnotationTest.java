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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.apache.pluto.container.om.portlet.Description;
import org.apache.pluto.container.om.portlet.InitParam;
import org.apache.pluto.container.om.portlet.LocaleText;
import org.apache.pluto.container.om.portlet.PortletApplicationDefinition;
import org.apache.pluto.container.om.portlet.PortletDefinition;
import org.apache.pluto.container.om.portlet.PortletInfo;
import org.apache.pluto.container.om.portlet.impl.ConfigurationHolder;
import org.apache.pluto.container.om.portlet.impl.InitParamImpl;
import org.apache.pluto.container.om.portlet.impl.LocaleTextImpl;
import org.apache.pluto.container.om.portlet.impl.PortletDefinitionImpl;
import org.apache.pluto.container.om.portlet.impl.fixtures.TestAnnotatedGenericPortlet;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test class for a portlet configuration annotation applied to a class
 * that extends the Portlet interface.
 * <p>
 * Test Class: TestAnnotatedGenericPortlet
 * 
 * @author Scott Nicklous
 */
public class ExtendingPortletInterfaceAnnotationTest {

   private static final Class<?>               TEST_ANNOTATED_CLASS = TestAnnotatedGenericPortlet.class;

   private static PortletApplicationDefinition pad;

   // Class under test
   private PortletDefinition                   cut;

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
      assertEquals(1, pad.getPortlets().size());
      cut = new PortletDefinitionImpl(pad.getPortlets().get(0));
   }

   @Test
   public void testGetPortletName() {
      assertNotNull(cut.getPortletName());
      assertEquals("Annotated Generic Portlet", cut.getPortletName());
   }

   @Test
   public void testGetApplication() {
      assertNotNull(cut.getApplication());
      assertTrue(cut.getApplication() instanceof PortletApplicationDefinition);
   }

   @Test
   public void testGetInitParam() {
      String name = "AnnoName";
      String val = "value";
      InitParam ip = cut.getInitParam(name);
      assertNotNull(ip);
      assertEquals(name, ip.getParamName());
      assertEquals(val, ip.getParamValue());
      assertEquals(1, ip.getDescriptions().size());
      Locale loc = new Locale("de");
      Description d = ip.getDescription(loc);
      assertNotNull(d);
      assertEquals("Beschreibung", d.getText());
   }

   @Test
   public void testGetInitParamNullValue() {
      InitParam ip = cut.getInitParam("nullValueParam");
      assertNotNull(ip);
      assertEquals("nullValueParam", ip.getParamName());
      assertEquals("", ip.getParamValue());
   }

   @Test
   public void testGetInitParams() {
      String name = "AnnoName";
      String name2 = "ipname";
      String val = "value";
      List<InitParam> ips = cut.getInitParams();
      assertEquals(3, ips.size());
      
      InitParam ip = new InitParamImpl(name, val);
      assertTrue(ips.contains(ip));
      ip = new InitParamImpl(name2, val);
      assertTrue(ips.contains(ip));
      
   }

   @Test
   public void testGetPortletClass() {
      assertNotNull(cut.getPortletClass());
      assertEquals(TEST_ANNOTATED_CLASS.getCanonicalName(), cut.getPortletClass());
   }

   @Test
   public void testGetTitle() {
      String txt1 = "Annotated Portlet";
      String txt2 = "Annotiertes Portlet";
      PortletInfo info = cut.getPortletInfo();
      assertNotNull(info);
      List<LocaleText> list = info.getTitles();
      assertEquals(2, list.size());
      assertEquals(txt1, info.getTitle(Locale.ENGLISH).getText());
      assertEquals(txt2, info.getTitle(Locale.GERMAN).getText());
   }

   @Test
   public void testAddTitle() {
      String txt1 = "Annotated Portlet";
      String txt2 = "Annotiertes Portlet";
      PortletInfo info = cut.getPortletInfo();
      assertNotNull(info);
      LocaleText lt = new LocaleTextImpl(Locale.FRENCH, "intitulé");
      info.addTitle(lt);
      List<LocaleText> list = info.getTitles();
      assertEquals(3, list.size());
      assertEquals(txt1, info.getTitle(Locale.ENGLISH).getText());
      assertEquals("intitulé", info.getTitle(Locale.FRENCH).getText());
      assertEquals(txt2, info.getTitle(Locale.GERMAN).getText());
   }

   @Test
   public void testAddDupTitle() {
      String txt2 = "Annotiertes Portlet";
      PortletInfo info = cut.getPortletInfo();
      assertNotNull(info);
      String text = "Different Title";
      LocaleText lt = new LocaleTextImpl(Locale.ENGLISH, text);
      info.addTitle(lt);
      List<LocaleText> list = info.getTitles();
      assertEquals(2, list.size());
      assertEquals(text, info.getTitle(Locale.ENGLISH).getText());
      assertEquals(txt2, info.getTitle(Locale.GERMAN).getText());
   }

   @Test
   public void testGetShortTitle() {
      String txt1 = "Anno Portlet";
      String txt2 = "Ein Portlet";
      PortletInfo info = cut.getPortletInfo();
      assertNotNull(info);
      List<LocaleText> list = info.getShortTitles();
      assertEquals(2, list.size());
      assertEquals(txt1, info.getShortTitle(Locale.ENGLISH).getText());
      assertEquals(txt2, info.getShortTitle(Locale.GERMAN).getText());
   }

   @Test
   public void testAddShortTitle() {
      String txt1 = "Anno Portlet";
      String txt2 = "Ein Portlet";
      PortletInfo info = cut.getPortletInfo();
      assertNotNull(info);
      String text = "intitulé en bref";
      LocaleText lt = new LocaleTextImpl(Locale.FRENCH, text);
      info.addShortTitle(lt);
      List<LocaleText> list = info.getShortTitles();
      assertEquals(3, list.size());
      assertEquals(txt1, info.getShortTitle(Locale.ENGLISH).getText());
      assertEquals(text, info.getShortTitle(Locale.FRENCH).getText());
      assertEquals(txt2, info.getShortTitle(Locale.GERMAN).getText());
   }

   @Test
   public void testAddDupShortTitle() {
      String txt2 = "Ein Portlet";
      PortletInfo info = cut.getPortletInfo();
      assertNotNull(info);
      String text = "Different Short Title";
      LocaleText lt = new LocaleTextImpl(Locale.ENGLISH, text);
      info.addShortTitle(lt);
      List<LocaleText> list = info.getTitles();
      assertEquals(2, list.size());
      assertEquals(text, info.getShortTitle(Locale.ENGLISH).getText());
      assertEquals(txt2, info.getShortTitle(Locale.GERMAN).getText());
   }

   @Test
   public void testGetKeywords() {
      String txt1 = "One, Two, Three";
      String txt2 = "Eins, Zwei, Drei";
      PortletInfo info = cut.getPortletInfo();
      assertNotNull(info);
      List<LocaleText> list = info.getKeywordsList();
      assertEquals(2, list.size());
      assertEquals(txt1, info.getKeywords(Locale.ENGLISH).getText());
      assertEquals(txt2, info.getKeywords(Locale.GERMAN).getText());
   }

   @Test
   public void testAddKeywords() {
      String txt1 = "One, Two, Three";
      String txt2 = "Eins, Zwei, Drei";
      PortletInfo info = cut.getPortletInfo();
      assertNotNull(info);
      String text = "mot-clés";
      LocaleText lt = new LocaleTextImpl(Locale.FRENCH, text);
      info.addKeywords(lt);
      List<LocaleText> list = info.getKeywordsList();
      assertEquals(3, list.size());
      assertEquals(text, info.getKeywords(Locale.FRENCH).getText());
      assertEquals(txt1, info.getKeywords(Locale.ENGLISH).getText());
      assertEquals(txt2, info.getKeywords(Locale.GERMAN).getText());
   }

   @Test
   public void testAddDupKeywords() {
      String txt1 = "One, Two, Three";
      PortletInfo info = cut.getPortletInfo();
      assertNotNull(info);
      String text = "andre Schlagwörter";
      LocaleText lt = new LocaleTextImpl(Locale.GERMAN, text);
      info.addKeywords(lt);
      List<LocaleText> list = info.getKeywordsList();
      assertEquals(2, list.size());
      assertEquals(text, info.getKeywords(Locale.GERMAN).getText());
      assertEquals(txt1, info.getKeywords(Locale.ENGLISH).getText());
   }

}
