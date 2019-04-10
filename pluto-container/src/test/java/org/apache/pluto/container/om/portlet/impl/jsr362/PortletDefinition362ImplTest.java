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

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import javax.xml.namespace.QName;

import org.apache.pluto.container.om.portlet.ContainerRuntimeOption;
import org.apache.pluto.container.om.portlet.Dependency;
import org.apache.pluto.container.om.portlet.Description;
import org.apache.pluto.container.om.portlet.DisplayName;
import org.apache.pluto.container.om.portlet.EventDefinitionReference;
import org.apache.pluto.container.om.portlet.InitParam;
import org.apache.pluto.container.om.portlet.LocaleText;
import org.apache.pluto.container.om.portlet.PortletApplicationDefinition;
import org.apache.pluto.container.om.portlet.PortletDefinition;
import org.apache.pluto.container.om.portlet.PortletInfo;
import org.apache.pluto.container.om.portlet.Preference;
import org.apache.pluto.container.om.portlet.Preferences;
import org.apache.pluto.container.om.portlet.SecurityRoleRef;
import org.apache.pluto.container.om.portlet.Supports;
import org.apache.pluto.container.om.portlet.impl.ConfigurationHolder;
import org.apache.pluto.container.om.portlet.impl.ContainerRuntimeOptionImpl;
import org.apache.pluto.container.om.portlet.impl.DependencyImpl;
import org.apache.pluto.container.om.portlet.impl.DescriptionImpl;
import org.apache.pluto.container.om.portlet.impl.DisplayNameImpl;
import org.apache.pluto.container.om.portlet.impl.EventDefinitionReferenceImpl;
import org.apache.pluto.container.om.portlet.impl.InitParamImpl;
import org.apache.pluto.container.om.portlet.impl.LocaleTextImpl;
import org.apache.pluto.container.om.portlet.impl.PortletDefinitionImpl;
import org.apache.pluto.container.om.portlet.impl.PortletInfoImpl;
import org.apache.pluto.container.om.portlet.impl.PreferenceImpl;
import org.apache.pluto.container.om.portlet.impl.PreferencesImpl;
import org.apache.pluto.container.om.portlet.impl.SecurityRoleRefImpl;
import org.apache.pluto.container.om.portlet.impl.SupportsImpl;
import org.apache.pluto.container.om.portlet.impl.fixtures.TestPortlet;
import org.apache.pluto.container.om.portlet.impl.fixtures.TestPreferencesValidator;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * Test class for reading the portlet deployment descriptor.
 * 
 * @author Scott Nicklous
 */
public class PortletDefinition362ImplTest {

   private static final String XML_FILE = 
         "org/apache/pluto/container/om/portlet/portlet362Generated.xml";
   
   private static PortletApplicationDefinition pad;
   
   // Class under test
   private PortletDefinition cut;

   @BeforeClass
   public static void setUpBeforeClass() throws Exception {
      
      InputStream in = PortletDefinition362ImplTest.class
            .getClassLoader().getResourceAsStream(XML_FILE);
      
      ConfigurationHolder cfp = new ConfigurationHolder();
      try {
         cfp.processPortletDD(in);
         pad = cfp.getPad();
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
      assertEquals("portlet362", cut.getPortletName());
   }

   @Test
   public void testGetApplication() {
      assertNotNull(cut.getApplication());
      assertTrue(cut.getApplication() instanceof PortletApplicationDefinition);
   }

   @Test
   public void testGetInitParam() {
      InitParam ip = cut.getInitParam("name");
      assertNotNull(ip);
      assertEquals("name", ip.getParamName());
      assertEquals("value", ip.getParamValue());
      assertEquals(1, ip.getDescriptions().size());
      Locale loc = new Locale("de");
      Description d = ip.getDescription(loc);
      assertNotNull(d);
      assertEquals("description", d.getText());
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
      List<InitParam> ips = cut.getInitParams();
      assertEquals(2, ips.size());
      boolean ok = false;
      for (InitParam ip : ips) {
         if (ip.getParamName().equals("name") && ip.getParamValue().equals("value")) {
            ok = true;
         }
      }
      assertTrue(ok);
   }

   @Test
   public void testAddInitParam() {
      String name = "Fred", value = "bowling";
      InitParam newip = new InitParamImpl(name, value);
      cut.addInitParam(newip);
      
      List<InitParam> ips = cut.getInitParams();
      assertEquals(3, ips.size());
      InitParam ip = cut.getInitParam(name);
      assertNotNull(ip);
      assertEquals(name, ip.getParamName());
      assertEquals(value, ip.getParamValue());
   }

   @Test
   public void testAddDupInitParam() {
      String name = "name", value = "value";
      InitParam newip = new InitParamImpl(name, value);
      cut.addInitParam(newip);
      
      List<InitParam> ips = cut.getInitParams();
      assertEquals(2, ips.size());
      InitParam ip = cut.getInitParam(name);
      assertNotNull(ip);
      assertEquals(name, ip.getParamName());
      assertEquals(value, ip.getParamValue());
   }

   @Test
   public void testGetPortletClass() {
      assertNotNull(cut.getPortletClass());
      assertEquals(TestPortlet.class.getCanonicalName(), cut.getPortletClass());
   }

   @Test
   public void testSetPortletClass() {
      String text = "someClass";
      cut.setPortletClass(text);
      assertEquals(text, cut.getPortletClass());
   }

   @Test
   public void testGetPortletInfoJSR286Compat() {
      PortletInfo info = cut.getPortletInfo();
      assertNotNull(info);
      assertEquals("title", info.getTitle());
      assertEquals("short-title", info.getShortTitle());
      assertEquals("keywords", info.getKeywords());
   }

   @Test
   public void testSetPortletInfo() {
      String ti = "t2", st = "st", kw = "kw";
      PortletInfo i2 = new PortletInfoImpl(ti, kw, st);
      cut.setPortletInfo(i2);

      PortletInfo info = cut.getPortletInfo();
      assertNotNull(info);
      assertEquals(ti, info.getTitle());
      assertEquals(st, info.getShortTitle());
      assertEquals(kw, info.getKeywords());
   }

   @Test
   public void testGetTitle() {
      PortletInfo info = cut.getPortletInfo();
      assertNotNull(info);
      List<LocaleText> list = info.getTitles();
      assertEquals(2, list.size());
      assertEquals("title", info.getTitle(Locale.ENGLISH).getText());
      assertEquals("Titel", info.getTitle(Locale.GERMAN).getText());
   }
   
   @Test
   public void testAddTitle() {
      PortletInfo info = cut.getPortletInfo();
      assertNotNull(info);
      LocaleText lt = new LocaleTextImpl(Locale.FRENCH, "intitulé");
      info.addTitle(lt);
      List<LocaleText> list = info.getTitles();
      assertEquals(3, list.size());
      assertEquals("title", info.getTitle(Locale.ENGLISH).getText());
      assertEquals("intitulé", info.getTitle(Locale.FRENCH).getText());
      assertEquals("Titel", info.getTitle(Locale.GERMAN).getText());
   }
   
   @Test
   public void testAddDupTitle() {
      PortletInfo info = cut.getPortletInfo();
      assertNotNull(info);
      String text = "Different Title";
      LocaleText lt = new LocaleTextImpl(Locale.ENGLISH, text);
      info.addTitle(lt);
      List<LocaleText> list = info.getTitles();
      assertEquals(2, list.size());
      assertEquals(text, info.getTitle(Locale.ENGLISH).getText());
      assertEquals("Titel", info.getTitle(Locale.GERMAN).getText());
   }

   @Test
   public void testGetShortTitle() {
      PortletInfo info = cut.getPortletInfo();
      assertNotNull(info);
      List<LocaleText> list = info.getShortTitles();
      assertEquals(2, list.size());
      assertEquals("short-title", info.getShortTitle(Locale.ENGLISH).getText());
      assertEquals("Kurztitel", info.getShortTitle(Locale.GERMAN).getText());
   }
   
   @Test
   public void testAddShortTitle() {
      PortletInfo info = cut.getPortletInfo();
      assertNotNull(info);
      String text = "intitulé en bref";
      LocaleText lt = new LocaleTextImpl(Locale.FRENCH, text);
      info.addShortTitle(lt);
      List<LocaleText> list = info.getShortTitles();
      assertEquals(3, list.size());
      assertEquals("short-title", info.getShortTitle(Locale.ENGLISH).getText());
      assertEquals(text, info.getShortTitle(Locale.FRENCH).getText());
      assertEquals("Kurztitel", info.getShortTitle(Locale.GERMAN).getText());
   }
   
   @Test
   public void testAddDupShortTitle() {
      PortletInfo info = cut.getPortletInfo();
      assertNotNull(info);
      String text = "Different Short Title";
      LocaleText lt = new LocaleTextImpl(Locale.ENGLISH, text);
      info.addShortTitle(lt);
      List<LocaleText> list = info.getTitles();
      assertEquals(2, list.size());
      assertEquals(text, info.getShortTitle(Locale.ENGLISH).getText());
      assertEquals("Kurztitel", info.getShortTitle(Locale.GERMAN).getText());
   }

   @Test
   public void testGetKeywords() {
      PortletInfo info = cut.getPortletInfo();
      assertNotNull(info);
      List<LocaleText> list = info.getKeywordsList();
      assertEquals(2, list.size());
      assertEquals("keywords", info.getKeywords(Locale.ENGLISH).getText());
      assertEquals("Schlagwörter", info.getKeywords(Locale.GERMAN).getText());
   }
   
   @Test
   public void testAddKeywords() {
      PortletInfo info = cut.getPortletInfo();
      assertNotNull(info);
      String text = "mot-clés";
      LocaleText lt = new LocaleTextImpl(Locale.FRENCH, text);
      info.addKeywords(lt);
      List<LocaleText> list = info.getKeywordsList();
      assertEquals(3, list.size());
      assertEquals(text, info.getKeywords(Locale.FRENCH).getText());
      assertEquals("keywords", info.getKeywords(Locale.ENGLISH).getText());
      assertEquals("Schlagwörter", info.getKeywords(Locale.GERMAN).getText());
   }
   
   @Test
   public void testAddDupKeywords() {
      PortletInfo info = cut.getPortletInfo();
      assertNotNull(info);
      String text = "andre Schlagwörter";
      LocaleText lt = new LocaleTextImpl(Locale.GERMAN, text);
      info.addKeywords(lt);
      List<LocaleText> list = info.getKeywordsList();
      assertEquals(2, list.size());
      assertEquals(text, info.getKeywords(Locale.GERMAN).getText());
      assertEquals("keywords", info.getKeywords(Locale.ENGLISH).getText());
   }

   @Test
   public void testGetPortletPreferences() {
      Preferences prefs = cut.getPortletPreferences();
      assertNotNull(prefs);
      assertEquals(TestPreferencesValidator.class.getCanonicalName(), prefs.getPreferencesValidator());
      List<Preference> list = prefs.getPortletPreferences();
      assertEquals(1, list.size());
      Preference item = list.get(0);
      assertEquals("name", item.getName());
      List<String> vals = item.getValues();
      assertEquals(1, vals.size());
      assertEquals("value", vals.get(0));
   }

   @Test
   public void testSetPortletPreferences() {
      String validator = "validator";
      String name = "prefName";
      String[] vals = {"v1", "v2"};
      Preferences prefs = new PreferencesImpl(cut.getPortletPreferences());
      prefs.setPreferencesValidator(validator);
      prefs.addPreference(new PreferenceImpl(name, true, Arrays.asList(vals)));
      cut.setPortletPreferences(prefs);
      
      Preferences prefs2 = cut.getPortletPreferences();
      assertNotNull(prefs2);
      assertEquals(validator, prefs2.getPreferencesValidator());
      List<Preference> list = prefs2.getPortletPreferences();
      assertEquals(2, list.size());
      Preference item = prefs2.getPortletPreference(name);
      assertEquals(name, item.getName());
      List<String> newvals = item.getValues();
      assertEquals(2, newvals.size());
      assertArrayEquals(vals, newvals.toArray());
   }

   @Test  // JSR 286
   public void testGetSupportedProcessingEvents() {
      List<EventDefinitionReference> list = cut.getSupportedProcessingEvents();
      assertNotNull(list);
      assertEquals(1, list.size());
      boolean ok = false;
      QName qn = new QName("https://www.apache.org/", "supported-processing-event");
      for (EventDefinitionReference item : list) {
         if (item.getQualifiedName().equals(qn)) {
            ok = true;
         }
      }
      assertTrue(ok);
   }

   @Test  // JSR 286
   public void testAddSupportedProcessingEvent() {
      QName qn = new QName("https://www.ibm.com/", "some-other-event");
      EventDefinitionReference edr = new EventDefinitionReferenceImpl(qn);
      cut.addSupportedProcessingEvent(edr);
      
      List<EventDefinitionReference> list = cut.getSupportedProcessingEvents();
      assertNotNull(list);
      assertEquals(2, list.size());
      boolean ok = false;
      for (EventDefinitionReference item : list) {
         if (item.getQualifiedName().equals(qn)) {
            ok = true;
         }
      }
      assertTrue(ok);
   }

   @Test  // JSR 286
   public void testAddDupSupportedProcessingEvent() {
      QName qn = new QName("https://www.apache.org/", "supported-processing-event");
      EventDefinitionReference edr = new EventDefinitionReferenceImpl(qn);
      cut.addSupportedProcessingEvent(edr);
      
      List<EventDefinitionReference> list = cut.getSupportedProcessingEvents();
      assertNotNull(list);
      assertEquals(1, list.size());
      boolean ok = false;
      for (EventDefinitionReference item : list) {
         if (item.getQualifiedName().equals(qn)) {
            ok = true;
         }
      }
      assertTrue(ok);
   }

   @Test  // JSR 286
   public void testGetSupportedPublishingEvents() {
      List<EventDefinitionReference> list = cut.getSupportedPublishingEvents();
      assertNotNull(list);
      assertEquals(1, list.size());
      boolean ok = false;
      QName qn = new QName("http://test.com", "supported-publishing-event");
      for (EventDefinitionReference item : list) {
         QName aqn = item.getQualifiedName();
         if (aqn.equals(qn)) {
            ok = true;
         }
      }
      assertTrue(ok);
   }

   @Test  // JSR 286
   public void testAddSupportedPublishingEvent() {
      QName qn = new QName("https://www.ibm.com/", "some-other-event");
      EventDefinitionReference edr = new EventDefinitionReferenceImpl(qn);
      cut.addSupportedPublishingEvent(edr);
      
      List<EventDefinitionReference> list = cut.getSupportedPublishingEvents();
      assertNotNull(list);
      assertEquals(2, list.size());
      boolean ok = false;
      for (EventDefinitionReference item : list) {
         if (item.getQualifiedName().equals(qn)) {
            ok = true;
         }
      }
      assertTrue(ok);
   }

   @Test  // JSR 286
   public void testAddDupSupportedPublishingEvent() {
      QName qn = new QName("http://test.com", "supported-publishing-event");
      EventDefinitionReference edr = new EventDefinitionReferenceImpl(qn);
      cut.addSupportedPublishingEvent(edr);
      
      List<EventDefinitionReference> list = cut.getSupportedPublishingEvents();
      assertNotNull(list);
      assertEquals(1, list.size());
      boolean ok = false;
      for (EventDefinitionReference item : list) {
         if (item.getQualifiedName().equals(qn)) {
            ok = true;
         }
      }
      assertTrue(ok);
   }

   @Test  // JSR 286
   public void testGetSupportedPublicRenderParameters() {
      List<String> list = cut.getSupportedPublicRenderParameters();
      String prp = "supported-public-render-parameter";
      assertNotNull(list);
      assertEquals(1, list.size());
      assertTrue(list.contains(prp));
   }

   @Test  // JSR 286
   public void testAddSupportedPublicRenderParameter() {
      String newprp = "some-prp";
      cut.addSupportedPublicRenderParameter(newprp);
      List<String> list = cut.getSupportedPublicRenderParameters();
      assertNotNull(list);
      assertEquals(2, list.size());
      assertTrue(list.contains(newprp));
   }

   @Test  // JSR 286
   public void testAddDupSupportedPublicRenderParameter() {
      String newprp = "supported-public-render-parameter";
      cut.addSupportedPublicRenderParameter(newprp);
      List<String> list = cut.getSupportedPublicRenderParameters();
      assertNotNull(list);
      assertEquals(1, list.size());
      assertTrue(list.contains(newprp));
   }

   @Test
   public void testGetResourceBundle() {
      assertNotNull(cut.getResourceBundle());
      assertEquals("org.apache.pluto.container.om.portlet.GoodBundle", cut.getResourceBundle());
   }

   @Test
   public void testSetResourceBundle() {
      String text = "newBundle";
      cut.setResourceBundle(text);
      assertNotNull(cut.getResourceBundle());
      assertEquals(text, cut.getResourceBundle());
   }

   @Test
   public void testGetSecurityRoleRef() {
      SecurityRoleRef srr = cut.getSecurityRoleRef("NMTOKEN");
      assertNotNull(srr);
      assertEquals("NMTOKEN", srr.getRoleName());
      assertEquals("role-link", srr.getRoleLink());
   }

   @Test
   public void testGetSecurityRoleRefs() {
      List<SecurityRoleRef> list = cut.getSecurityRoleRefs();
      assertEquals(1, list.size());
      SecurityRoleRef srr = list.get(0);
      assertNotNull(srr);
      assertEquals("NMTOKEN", srr.getRoleName());
      assertEquals("role-link", srr.getRoleLink());
      Description d = srr.getDescription(new Locale("de"));
      assertNotNull(d);
      assertEquals("description", d.getText());
      
   }

   @Test
   public void testAddSecurityRoleRef() {
      String name = "RoleName";
      String link = "RoleLink";
      SecurityRoleRef srr = new SecurityRoleRefImpl(name);
      srr.setRoleLink(link);
      cut.addSecurityRoleRef(srr);

      List<SecurityRoleRef> list = cut.getSecurityRoleRefs();
      assertEquals(2, list.size());
      srr = cut.getSecurityRoleRef(name);
      assertNotNull(srr);
      assertEquals(name, srr.getRoleName());
      assertEquals(link, srr.getRoleLink());
   }

   @Test
   public void testAddDupSecurityRoleRef() {
      String name = "NMTOKEN";
      String link = "role-link";
      SecurityRoleRef srr = new SecurityRoleRefImpl(name);
      srr.setRoleLink(link);
      cut.addSecurityRoleRef(srr);

      List<SecurityRoleRef> list = cut.getSecurityRoleRefs();
      assertEquals(1, list.size());
      srr = cut.getSecurityRoleRef(name);
      assertNotNull(srr);
      assertEquals(name, srr.getRoleName());
      assertEquals(link, srr.getRoleLink());
   }

   @Test
   public void testGetSupportsString() {
      Supports s = cut.getSupports("mime-type2");
      assertNotNull(s);
      assertTrue(s.getPortletModes().contains("portlet-mode2"));
   }

   @Test
   public void testGetSupportsMode() {
      Supports s = cut.getSupports("mime-type2");
      assertNotNull(s);
      assertTrue(s.getPortletModes().contains("portlet-mode2"));
   }

   @Test
   public void testGetSupportsState() {
      Supports s = cut.getSupports("mime-type3");
      assertNotNull(s);
      assertTrue(s.getWindowStates().contains("window-state3"));
   }

   @Test
   public void testGetSupports() {
      List<Supports> list = cut.getSupports();
      assertEquals(3, list.size());
   }

   @Test
   public void testAddSupports() {
      Supports s = new SupportsImpl("text/html");
      cut.addSupports(s);
      List<Supports> list = cut.getSupports();
      assertEquals(4, list.size());
      boolean ok = false;
      for (Supports item : list) {
         if (item.getMimeType().equals("text/html")) {
            ok = true;
            break;
         }
      }
      assertTrue(ok);
   }

   @Test
   public void testAddDupSupports() {
      Supports s = new SupportsImpl("mime-type2");
      cut.addSupports(s);
      List<Supports> list = cut.getSupports();
      assertEquals(3, list.size());
      boolean ok = false;
      for (Supports item : list) {
         if (item.getMimeType().equals("mime-type2")) {
            ok = true;
            break;
         }
      }
      assertTrue(ok);
   }

   @Test
   public void testGetDescription() {
      Locale loc = new Locale("DE");
      Description desc = cut.getDescription(loc);
      assertNotNull(desc);
      assertEquals("multi line description", desc.getText());
   }

   @Test
   public void testGetDescriptions() {
      List<Description> list = cut.getDescriptions();
      assertNotNull(list);
      assertEquals(1, list.size());
      assertEquals("multi line description", list.get(0).getText());
   }

   @Test
   public void testAddDescription() {
      Locale loc = Locale.FRENCH;
      String text = "Some description";
      Description d = new DescriptionImpl(loc, text);
      cut.addDescription(d);

      List<Description> list = cut.getDescriptions();
      assertNotNull(list);
      assertEquals(2, list.size());
      for (Description desc : list) {
         if (desc.getLocale().equals(loc)) {
            assertEquals(text, desc.getText());
         } else {
            assertEquals("multi line description", desc.getText());
         }
      }
   }

   @Test
   public void testAddDupDescription() {
      Locale loc = Locale.GERMAN;
      String text = "multi line description";
      Description d = new DescriptionImpl(loc, text);
      cut.addDescription(d);

      List<Description> list = cut.getDescriptions();
      assertNotNull(list);
      assertEquals(1, list.size());
      Description desc = list.get(0);
      assertEquals(text, desc.getText());
      assertEquals("multi line description", desc.getText());
   }

   @Test
   public void testGetDisplayName() {
      Locale loc = new Locale("DE");
      DisplayName name = cut.getDisplayName(loc);
      assertNotNull(name);
      assertEquals("display-name", name.getText());
   }

   @Test
   public void testGetDisplayNames() {
      List<DisplayName> list = cut.getDisplayNames();
      assertNotNull(list);
      assertEquals(1, list.size());
      assertEquals("display-name", list.get(0).getText());
   }

   @Test
   public void testAddDisplayName() {
      Locale loc = Locale.FRENCH;
      String text = "Some display name";
      DisplayName d = new DisplayNameImpl(loc, text);
      cut.addDisplayName(d);

      List<DisplayName> list = cut.getDisplayNames();
      assertNotNull(list);
      assertEquals(2, list.size());
      for (DisplayName desc : list) {
         if (desc.getLocale().equals(loc)) {
            assertEquals(text, desc.getText());
         } else {
            assertEquals("display-name", desc.getText());
         }
      }
   }

   @Test
   public void testAddDupDisplayName() {
      Locale loc = Locale.GERMAN;
      String text = "display-name";
      DisplayName d = new DisplayNameImpl(loc, text);
      cut.addDisplayName(d);

      List<DisplayName> list = cut.getDisplayNames();
      assertNotNull(list);

      assertEquals(1, list.size());
      DisplayName dn = list.get(0);
      assertEquals(text, dn.getText());
   }

   @Test
   public void testGetSupportedLocales() {
      List<String> list = cut.getSupportedLocales();
      assertEquals(1, list.size());
      assertTrue(list.contains("supported-locale"));
   }

   @Test
   public void testAddSupportedLocale() {
      String locname = "zh-cmn-Hans-CN";
      cut.addSupportedLocale(locname);
      
      List<String> list = cut.getSupportedLocales();
      assertEquals(2, list.size());
      assertTrue(list.contains(locname));
   }

   @Test
   public void testAddDupSupportedLocale() {
      String locname = "supported-locale";
      cut.addSupportedLocale(locname);
      
      List<String> list = cut.getSupportedLocales();
      assertEquals(1, list.size());
      assertTrue(list.contains(locname));
   }

   @Test
   public void testGetExpirationCache() {
      assertNotNull(cut.getExpirationCache());
      assertEquals(50, cut.getExpirationCache());
   }

   @Test
   public void testSetExpirationCache() {
      cut.setExpirationCache(100);
      assertNotNull(cut.getExpirationCache());
      assertEquals(100, cut.getExpirationCache());
   }

   @Test  // JSR 286
   public void testGetCacheScope() {
      assertNotNull(cut.getCacheScope());
      assertEquals("private", cut.getCacheScope());
   }

   @Test  // JSR 286
   public void testSetCacheScope() {
      String cs = "whatever";
      cut.setCacheScope(cs);
      assertNotNull(cut.getCacheScope());
      assertEquals(cs, cut.getCacheScope());
   }

   @Test  // JSR 286
   public void testGetContainerRuntimeOption() {
      ContainerRuntimeOption rto = cut.getContainerRuntimeOption("Runtime-Option1");
      assertNotNull(rto);
      assertEquals(1, rto.getValues().size());
      assertTrue(rto.getValues().get(0).equalsIgnoreCase("true"));
   }

   @Test  // JSR 286
   public void testGetContainerRuntimeOptions() {
      List<ContainerRuntimeOption> list = cut.getContainerRuntimeOptions();
      assertNotNull(list);
      assertEquals(2, list.size());
      boolean ok = false;
      for (ContainerRuntimeOption item : list) {
         if (item.getName().equalsIgnoreCase("Runtime-Option2") && 
               item.getValues().size() == 1 && item.getValues().get(0).equalsIgnoreCase("value2")) {
            ok = true;
         }
      }
      assertTrue(ok);
   }

   @Test  // JSR 286
   public void testAddContainerRuntimeOption() {
      String name = "NewRTO";
      String[] vals = {"v1", "v2", "v3"};
      ContainerRuntimeOption cro = new ContainerRuntimeOptionImpl(name, Arrays.asList(vals));
      cut.addContainerRuntimeOption(cro);
      
      ContainerRuntimeOption newcro = cut.getContainerRuntimeOption(name);
      assertNotNull(newcro);
      assertArrayEquals(vals, newcro.getValues().toArray());
   }

   @Test  // JSR 286
   public void testAddDupContainerRuntimeOption() {
      String name = "Runtime-Option1";
      String[] vals = {"true"};
      ContainerRuntimeOption cro = new ContainerRuntimeOptionImpl(name, Arrays.asList(vals));
      cut.addContainerRuntimeOption(cro);
      
      ContainerRuntimeOption newcro = cut.getContainerRuntimeOption(name);
      assertNotNull(newcro);
      assertArrayEquals(vals, newcro.getValues().toArray());
   }
   
   @Test
   public void testGetDependency() {
      String depName = "JQuery";
      String depScope = "org.jquery";
      String depVers = "2.1.4";
      Dependency dep = cut.getDependency(depName);
      assertNotNull(dep);
      assertEquals(depName, dep.getName());
      assertEquals(depScope, dep.getScope());
      assertEquals(depVers, dep.getVersion());
   }
   
   @Test
   public void testGetDependency2() {
      String depName = "AngularJS";
      String depScope = "org.angularjs";
      String depVers = "1.4.8";
      Dependency dep = cut.getDependency(depName);
      assertNotNull(dep);
      assertEquals(depName, dep.getName());
      assertEquals(depScope, dep.getScope());
      assertEquals(depVers, dep.getVersion());
   }
   
   @Test
   public void testGetDependencies() {
      String depName = "JQuery";
      String depScope = "org.jquery";
      String depVers = "2.1.4";
      List<Dependency> deps = cut.getDependencies();
      assertNotNull(deps);
      assertEquals(2, deps.size());
      Dependency dep = new DependencyImpl(depName, depScope, depVers);
      assertTrue(deps.contains(dep));
   }
   
   @Test
   public void testAddDependency() {
      String depName = "Bozo";
      String depScope = "org.clowns";
      String depVers = "1.4";
      Dependency dep = new DependencyImpl(depName, depScope, depVers);
      cut.addDependency(dep);
      
      List<Dependency> deps = cut.getDependencies();
      assertNotNull(deps);
      assertEquals(3, deps.size());
      assertTrue(deps.contains(dep));
   }
   
   @Test
   public void testAddDupDependency() {
      String depName = "JQuery";
      String depScope = "org.jquery";
      String depVers = "2.2.2";
      Dependency dep = new DependencyImpl(depName, depScope, depVers);
      cut.addDependency(dep);
      
      List<Dependency> deps = cut.getDependencies();
      assertNotNull(deps);
      assertEquals(2, deps.size());
      assertTrue(deps.contains(dep));
   }
   
   @Test
   public void testAsyncSupported() throws Exception {
      assertTrue(cut.isAsyncSupported());
   }
   
   @Test
   public void testSetAsyncSupportedTrue() throws Exception {
      cut.setAsyncSupported(true);
      assertTrue(cut.isAsyncSupported());
   }
   
   @Test
   public void testSetAsyncSupportedFalse() throws Exception {
      cut.setAsyncSupported(false);
      assertFalse(cut.isAsyncSupported());
   }
   
   @Test
   public void testSetMultipartSupportedTrue() throws Exception {
      cut.setMultipartSupported(true);
      assertTrue(cut.isMultipartSupported());
   }
   
   @Test
   public void testSetMultipartSupportedFalse() throws Exception {
      cut.setMultipartSupported(false);
      assertFalse(cut.isMultipartSupported());
   }
   
   @Test
   public void testGetSetMultipartValues() throws Exception {
      cut.setLocation("there");
      cut.setFileSizeThreshold(10);
      cut.setMaxFileSize(20L);
      cut.setMaxRequestSize(30L);
      
      assertEquals("there", cut.getLocation());
      assertEquals(new Integer(10), cut.getFileSizeThreshold());
      assertEquals(new Long(20), cut.getMaxFileSize());
      assertEquals(new Long(30), cut.getMaxRequestSize());
   }

}
