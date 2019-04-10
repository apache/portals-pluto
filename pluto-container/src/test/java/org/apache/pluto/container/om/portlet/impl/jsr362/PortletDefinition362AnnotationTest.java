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

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.apache.pluto.container.om.portlet.ContainerRuntimeOption;
import org.apache.pluto.container.om.portlet.Dependency;
import org.apache.pluto.container.om.portlet.Description;
import org.apache.pluto.container.om.portlet.DisplayName;
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
import org.apache.pluto.container.om.portlet.impl.InitParamImpl;
import org.apache.pluto.container.om.portlet.impl.LocaleTextImpl;
import org.apache.pluto.container.om.portlet.impl.PortletDefinitionImpl;
import org.apache.pluto.container.om.portlet.impl.PortletInfoImpl;
import org.apache.pluto.container.om.portlet.impl.PreferenceImpl;
import org.apache.pluto.container.om.portlet.impl.PreferencesImpl;
import org.apache.pluto.container.om.portlet.impl.SecurityRoleRefImpl;
import org.apache.pluto.container.om.portlet.impl.SupportsImpl;
import org.apache.pluto.container.om.portlet.impl.fixtures.TestAnnotatedPortlet;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * Test class for a portlet configuration annotation applied to a class
 * that does not extend the Portlet interface.
 * <p>
 * Test Class: TestAnnotatedPortlet
 * 
 * @author Scott Nicklous
 */
public class PortletDefinition362AnnotationTest {

   private static final Class<?>               TEST_ANNOTATED_CLASS = TestAnnotatedPortlet.class;

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
      assertEquals("AnnotatedPortlet", cut.getPortletName());
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
   public void testAddInitParam() {
      String name = "Fred", value = "bowling";
      InitParam newip = new InitParamImpl(name, value);
      cut.addInitParam(newip);

      List<InitParam> ips = cut.getInitParams();
      assertEquals(4, ips.size());
      assertTrue(ips.contains(newip));
      InitParam ip = cut.getInitParam(name);
      assertNotNull(ip);
      assertEquals(name, ip.getParamName());
      assertEquals(value, ip.getParamValue());
   }

   @Test
   public void testAddDupInitParam() {
      String name = "ipname", value = "new value";
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
   public void testGetPortletClass() {
      assertNull(cut.getPortletClass());
   }

   @Test
   public void testSetPortletClass() {
      String text = "someClass";
      cut.setPortletClass(text);
      assertEquals(text, cut.getPortletClass());
   }

   @Test
   public void testGetPortletInfoJSR286Compat() {
      String title = "Annotated Portlet";
      String sTitle = "Anno Portlet";
      String keywords = "One, Two, Three";
      PortletInfo info = cut.getPortletInfo();
      assertNotNull(info);
      assertEquals(title, info.getTitle());
      assertEquals(sTitle, info.getShortTitle());
      assertEquals(keywords, info.getKeywords());
   }

   @Test
   public void testSetPortletInfo286() {
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
   
   private Preference getPref(String name, List<Preference> list) {
      for (Preference item : list) {
         if (item.getName().equals(name)) {
            return item;
         }
      }
      return null;
   }

   @Test
   public void testGetPortletPreferences() {
      Preferences prefs = cut.getPortletPreferences();
      assertNotNull(prefs);
      assertEquals(null, prefs.getPreferencesValidator());
      List<Preference> list = prefs.getPortletPreferences();
      assertEquals(2, list.size());
      Preference item = getPref("aPref", list);
      List<String> vals = item.getValues();
      assertEquals(1, vals.size());
      assertEquals("aValue", vals.get(0));
      item = getPref("bPref", list);
      assertNotNull(item);
   }

   @Test
   public void testSetPortletPreferences() {
      String validator = "validator";
      String name = "prefName";
      String[] vals = { "v1", "v2" };
      Preferences prefs = new PreferencesImpl(cut.getPortletPreferences());
      prefs.setPreferencesValidator(validator);
      prefs.addPreference(new PreferenceImpl(name, true, Arrays.asList(vals)));
      cut.setPortletPreferences(prefs);

      Preferences prefs2 = cut.getPortletPreferences();
      assertNotNull(prefs2);
      assertEquals(validator, prefs2.getPreferencesValidator());
      List<Preference> list = prefs2.getPortletPreferences();
      assertEquals(3, list.size());
      Preference item = prefs2.getPortletPreference(name);
      assertEquals(name, item.getName());
      List<String> newvals = item.getValues();
      assertEquals(2, newvals.size());
      assertArrayEquals(vals, newvals.toArray());
   }

   @Test
   public void testGetSupportedPublicRenderParameters() {
      List<String> list = cut.getSupportedPublicRenderParameters();
      String prp = "color";
      String prp2 = "aPrp";
      assertNotNull(list);
      assertEquals(2, list.size());
      assertTrue(list.contains(prp));
      assertTrue(list.contains(prp2));
   }

   @Test
   public void testAddSupportedPublicRenderParameter() {
      String newprp = "some-prp";
      cut.addSupportedPublicRenderParameter(newprp);
      List<String> list = cut.getSupportedPublicRenderParameters();
      assertNotNull(list);
      assertEquals(3, list.size());
      assertTrue(list.contains(newprp));
   }

   @Test
   public void testAddDupSupportedPublicRenderParameter() {
      String newprp = "anno-prp";
      cut.addSupportedPublicRenderParameter(newprp);
      List<String> list = cut.getSupportedPublicRenderParameters();
      assertNotNull(list);
      assertEquals(3, list.size());
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
      String name = "aRole";
      String link = "aLink";
      SecurityRoleRef srr = cut.getSecurityRoleRef(name);
      assertNotNull(srr);
      assertEquals(name, srr.getRoleName());
      assertEquals(link, srr.getRoleLink());
   }

   @Test
   public void testGetSecurityRoleRefs() {
      String name = "aRole";
      String link = "aLink";
      String desc = "Beschreibung";
      List<SecurityRoleRef> list = cut.getSecurityRoleRefs();
      assertEquals(1, list.size());
      SecurityRoleRef srr = list.get(0);
      assertNotNull(srr);
      assertEquals(name, srr.getRoleName());
      assertEquals(link, srr.getRoleLink());
      Description d = srr.getDescription(new Locale("de"));
      assertNotNull(d);
      assertEquals(desc, d.getText());
   }

   @Test
   public void testAddSecurityRoleRef() {
      String name = "NewName";
      String link = "NewLink";
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
      String name = "aRole";
      String link = "aDifferentLink";
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
      String mt = "aMimeType";
      String pm = "aMode";
      Supports s = cut.getSupports(mt);
      assertNotNull(s);
      assertTrue(s.getPortletModes().contains(pm));
   }

   @Test
   public void testGetSupportsMode() {
      String mt = "aMimeType2";
      String pm = "aMode2";
      Supports s = cut.getSupports(mt);
      assertNotNull(s);
      assertTrue(s.getPortletModes().contains(pm));
   }

   @Test
   public void testGetSupportsState() {
      Supports s = cut.getSupports("mime-type3");
      assertNotNull(s);
      assertTrue(s.getWindowStates().contains("aWS3"));
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
      String mt = "mime-type3";
      String ws = "SomeWindowState";
      Supports s = new SupportsImpl(mt);
      s.addWindowState(ws);
      cut.addSupports(s);
      List<Supports> list = cut.getSupports();
      assertEquals(3, list.size());
      boolean ok = false;
      for (Supports item : list) {
         if (item.getMimeType().equals(mt) && item.getWindowStates().get(0).equals(ws)) {
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
      assertEquals("Dieses Portlet zeigt die Zeit in verschiedenen Zeitzonen an", desc.getText());
   }

   @Test
   public void testGetDescriptions() {
      List<Description> list = cut.getDescriptions();
      assertNotNull(list);
      assertEquals(2, list.size());
      assertEquals("Portlet displaying the time in different time zones", list.get(0).getText());
   }

   @Test
   public void testAddDescription() {
      Locale loc = Locale.FRENCH;
      String text = "Une description";
      Description d = new DescriptionImpl(loc, text);
      cut.addDescription(d);

      List<Description> list = cut.getDescriptions();
      assertNotNull(list);
      assertEquals(3, list.size());
      for (Description desc : list) {
         if (desc.getLocale().equals(loc)) {
            assertEquals(text, desc.getText());
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
      assertEquals(2, list.size());
      Description desc = cut.getDescription(loc);
      assertEquals(text, desc.getText());
   }

   @Test
   public void testGetDisplayName() {
      Locale loc = new Locale("DE");
      DisplayName name = cut.getDisplayName(loc);
      assertNotNull(name);
      assertEquals("ZeitzonenPortlet", name.getText());
   }

   @Test
   public void testGetDisplayNames() {
      List<DisplayName> list = cut.getDisplayNames();
      assertNotNull(list);
      assertEquals(2, list.size());
      assertEquals("Time Zone Clock Portlet", list.get(0).getText());
   }

   @Test
   public void testAddDisplayName() {
      Locale loc = Locale.FRENCH;
      String text = "un nom de annonce";
      DisplayName d = new DisplayNameImpl(loc, text);
      cut.addDisplayName(d);

      List<DisplayName> list = cut.getDisplayNames();
      assertNotNull(list);
      assertEquals(3, list.size());
      for (DisplayName desc : list) {
         if (desc.getLocale().equals(loc)) {
            assertEquals(text, desc.getText());
         }
      }
   }

   @Test
   public void testAddDupDisplayName() {
      Locale loc = Locale.GERMAN;
      String text = "Anzeigetext";
      DisplayName d = new DisplayNameImpl(loc, text);
      cut.addDisplayName(d);

      List<DisplayName> list = cut.getDisplayNames();
      assertNotNull(list);

      assertEquals(2, list.size());
      DisplayName dn = cut.getDisplayName(loc);
      assertEquals(text, dn.getText());
   }

   @Test
   public void testGetSupportedLocales() {
      String locname = "Locale1";
      List<String> list = cut.getSupportedLocales();
      assertEquals(1, list.size());
      assertTrue(list.contains(locname));
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
      String locname = "Locale1";
      cut.addSupportedLocale(locname);

      List<String> list = cut.getSupportedLocales();
      assertEquals(1, list.size());
      assertTrue(list.contains(locname));
   }

   @Test
   public void testGetExpirationCache() {
      assertNotNull(cut.getExpirationCache());
      assertEquals(30, cut.getExpirationCache());
   }

   @Test
   public void testSetExpirationCache() {
      cut.setExpirationCache(100);
      assertNotNull(cut.getExpirationCache());
      assertEquals(100, cut.getExpirationCache());
   }

   @Test
   public void testGetCacheScope() {
      assertNotNull(cut.getCacheScope());
      assertEquals("private", cut.getCacheScope());
   }

   @Test
   public void testSetCacheScope() {
      String cs = "whatever";
      cut.setCacheScope(cs);
      assertNotNull(cut.getCacheScope());
      assertEquals(cs, cut.getCacheScope());
   }

   @Test
   public void testGetContainerRuntimeOption() {
      ContainerRuntimeOption rto = cut.getContainerRuntimeOption("aRTO");
      assertNotNull(rto);
      assertEquals(2, rto.getValues().size());
      assertArrayEquals(new String[] {"true", "false"}, rto.getValues().toArray());
   }

   @Test
   public void testGetContainerRuntimeOptions() {
      List<ContainerRuntimeOption> list = cut.getContainerRuntimeOptions();
      assertNotNull(list);
      assertEquals(2, list.size());
      boolean ok = false;
      for (ContainerRuntimeOption item : list) {
         if (item.getName().equalsIgnoreCase("Runtime-Option2") && item.getValues().size() == 1
               && item.getValues().get(0).equalsIgnoreCase("value2")) {
            ok = true;
         }
      }
      assertTrue(ok);
   }

   @Test
   public void testAddContainerRuntimeOption() {
      String name = "NewRTO";
      String[] vals = { "v1", "v2", "v3" };
      ContainerRuntimeOption cro = new ContainerRuntimeOptionImpl(name, Arrays.asList(vals));
      cut.addContainerRuntimeOption(cro);

      ContainerRuntimeOption newcro = cut.getContainerRuntimeOption(name);
      assertNotNull(newcro);
      assertArrayEquals(vals, newcro.getValues().toArray());
   }

   @Test
   public void testAddDupContainerRuntimeOption() {
      String name = "aRTO";
      String[] vals = { "maybe" };
      ContainerRuntimeOption cro = new ContainerRuntimeOptionImpl(name, Arrays.asList(vals));
      cut.addContainerRuntimeOption(cro);

      ContainerRuntimeOption newcro = cut.getContainerRuntimeOption(name);
      assertNotNull(newcro);
      assertArrayEquals(vals, newcro.getValues().toArray());
   }

   @Test
   public void testGetDependency() {
      String depName = "Dojo";
      String depScope = "org.dojotoolkit";
      String depVers = "3.1.4";
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
      String depName = "Dojo";
      String depScope = "org.dojotoolkit";
      String depVers = "3.1.4";
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
      String depName = "Dojo";
      String depScope = "org.dojotoolkit";
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
   public void testMultipartSupported() throws Exception {
      assertTrue(cut.isMultipartSupported());
      assertEquals("here", cut.getLocation());
      assertEquals(new Integer(1), cut.getFileSizeThreshold());
      assertEquals(new Long(2), cut.getMaxFileSize());
      assertEquals(new Long(3), cut.getMaxRequestSize());
   }

}
