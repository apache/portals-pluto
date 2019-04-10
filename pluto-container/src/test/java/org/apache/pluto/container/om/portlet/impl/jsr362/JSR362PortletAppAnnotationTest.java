/*  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.some.org/licenses/LICENSE-2.0
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.xml.namespace.QName;

import org.apache.pluto.container.om.portlet.ContainerRuntimeOption;
import org.apache.pluto.container.om.portlet.CustomPortletMode;
import org.apache.pluto.container.om.portlet.CustomWindowState;
import org.apache.pluto.container.om.portlet.EventDefinition;
import org.apache.pluto.container.om.portlet.PortletApplicationDefinition;
import org.apache.pluto.container.om.portlet.PublicRenderParameter;
import org.apache.pluto.container.om.portlet.UserAttribute;
import org.apache.pluto.container.om.portlet.impl.ConfigurationHolder;
import org.apache.pluto.container.om.portlet.impl.CustomPortletModeImpl;
import org.apache.pluto.container.om.portlet.impl.CustomWindowStateImpl;
import org.apache.pluto.container.om.portlet.impl.EventDefinitionImpl;
import org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl;
import org.apache.pluto.container.om.portlet.impl.PublicRenderParameterImpl;
import org.apache.pluto.container.om.portlet.impl.fixtures.TestPortletAppAnnotatedClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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

/**
 * Junit test cases for JSR 362 portlet application definition.
 * @author Scott Nicklous
 *
 */
public class JSR362PortletAppAnnotationTest {
   
   private static final Class<?> TEST_ANNOTATED_CLASS = TestPortletAppAnnotatedClass.class;
   
   private static PortletApplicationDefinition pad;
   private static ConfigurationHolder cfp;
   
   // class under test; cloned new for each test
   private  PortletApplicationDefinition cut;

   /**
    * @throws java.lang.Exception
    */
   @BeforeClass
   public static void setUpBeforeClass() throws Exception {

      Set<Class<?>> classes = new HashSet<Class<?>>();
      classes.add(TEST_ANNOTATED_CLASS);
      cfp = new ConfigurationHolder();
      try {
         cfp.processConfigAnnotations(classes);
         pad = cfp.getPad();
      } catch (Exception e) {
         e.printStackTrace();
         throw e;
      }
   }
   
   @Before
   public void setUpBefore() throws Exception {
      cut = new PortletApplicationDefinitionImpl(pad);
   }

   /**
    * Test method for version from annotation
    */
   @Test
   public void testGetVersion() {
      String val = cut.getVersion();
      assertEquals("3.0", val);
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#getResourceBundle()}.
    */
   @Test
   public void testGetResourceBundle() {
      String val = cut.getResourceBundle();
      assertEquals("org.apache.pluto.container.om.portlet.AnotherBundle", val);
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#getDefaultNamespace()}.
    */
   @Test
   public void testGetDefaultNamespace() {
      String val = cut.getDefaultNamespace();
      assertEquals("https://www.some.org/", val);
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#getEventDefinitions()}.
    */
   @Test
   public void testGetEventDefinitions() {
      List<EventDefinition> list = cut.getEventDefinitions();
      assertNotNull(list);
      assertEquals(2, list.size());
      boolean ok = false;
      QName qn = new QName("https://www.some.org/", "supported-event");
      for (EventDefinition item : list) {
         if (item.getQName().equals(qn)) {
            ok = true;
         }
      }
      assertTrue(ok);
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#getEventDefinition(javax.xml.namespace.QName)}.
    */
   @Test
   public void testGetEventDefinition() {
      QName qn = new QName("https://www.some.org/", "supported-event");
      EventDefinition item = cut.getEventDefinition(qn);
      assertNotNull(item);
      assertEquals(qn, item.getQName());

      qn = new QName("https://www.some.org/", "another-event");
      item = cut.getEventDefinition(qn);
      assertNotNull(item);
      assertEquals(qn, item.getQName());
      assertNotNull(item.getDescription(Locale.ENGLISH));
      assertEquals("Some description.", item.getDescription(Locale.ENGLISH).getText());
      assertNotNull(item.getDisplayName(Locale.ENGLISH));
      assertEquals("Company Organization", item.getDisplayName(Locale.ENGLISH).getText());
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#addEventDefinition(org.apache.pluto.container.om.portlet.EventDefinition)}.
    */
   @Test
   public void testAddEventDefinition() {
      QName qn = new QName("https://www.ibm.com/", "some-other-event");
      EventDefinition ed = new EventDefinitionImpl(qn);
      cut.addEventDefinition(ed);

      List<EventDefinition> list = cut.getEventDefinitions();
      assertNotNull(list);
      assertEquals(3, list.size());
      boolean ok = false;
      for (EventDefinition item : list) {
         if (item.getQName().equals(qn)) {
            ok = true;
         }
      }
      assertTrue(ok);
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#getPublicRenderParameter(java.lang.String)}.
    */
   @Test
   public void testGetPublicRenderParameter() {
      String prpid = "imgName";
      PublicRenderParameter prp = cut.getPublicRenderParameter(prpid);
      assertNotNull(prp);
      assertEquals(prpid, prp.getIdentifier());
      assertEquals(prpid, prp.getQName().getLocalPart());
      assertEquals("http:some.org/", prp.getQName().getNamespaceURI());

      prpid = "color";
      prp = cut.getPublicRenderParameter(prpid);
      assertNotNull(prp);
      assertEquals(prpid, prp.getIdentifier());
      assertEquals(prpid, prp.getQName().getLocalPart());
      assertEquals("http:some.org/", prp.getQName().getNamespaceURI());
      assertNotNull(prp.getDescription(Locale.ENGLISH));
      assertEquals("Some description.", prp.getDescription(Locale.ENGLISH).getText());
      assertNotNull(prp.getDisplayName(Locale.ENGLISH));
      assertEquals("Company Organization", prp.getDisplayName(Locale.ENGLISH).getText());
      
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#getPublicRenderParameters()}.
    */
   @Test
   public void testGetPublicRenderParameters() {
      String prpid = "imgName";
      List<PublicRenderParameter> prps = cut.getPublicRenderParameters();
      assertNotNull(prps);
      assertEquals(2, prps.size());
      assertEquals(prpid, prps.get(0).getIdentifier());
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#addPublicRenderParameter(org.apache.pluto.container.om.portlet.PublicRenderParameter)}.
    */
   @Test
   public void testAddPublicRenderParameter() {
      String prpid = "newprp";
      QName qn = new QName("https://www.ibm.com/", "some-other-prp");
      PublicRenderParameter prp = new PublicRenderParameterImpl(qn, prpid);
      cut.addPublicRenderParameter(prp);
      
      List<PublicRenderParameter> prps = cut.getPublicRenderParameters();
      assertNotNull(prps);
      assertEquals(3, prps.size());
      assertEquals(prpid, prps.get(2).getIdentifier());
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#getCustomPortletMode(java.lang.String)}.
    */
   @Test
   public void testGetCustomPortletMode() {
      String newItem = "admin";
      CustomPortletMode item = cut.getCustomPortletMode(newItem);
      assertNotNull(item);
      assertTrue(item.isPortalManaged());
      assertNotNull(item.getDescription(Locale.GERMAN));
      assertEquals("Verwaltungsfunktionen", item.getDescription(Locale.GERMAN).getText());
  }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#getCustomPortletModes()}.
    */
   @Test
   public void testGetCustomPortletModes() {
      String newItem = "admin";
      List<CustomPortletMode> list = cut.getCustomPortletModes();
      assertNotNull(list);
      assertEquals(2, list.size());
      assertEquals(newItem, list.get(0).getPortletMode());
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#addCustomPortletMode(org.apache.pluto.container.om.portlet.CustomPortletMode)}.
    */
   @Test
   public void testAddCustomPortletMode() {
      String newItem = "newMode";
      CustomPortletMode pm = new CustomPortletModeImpl(newItem);
      cut.addCustomPortletMode(pm);
      
      List<CustomPortletMode> list = cut.getCustomPortletModes();
      assertNotNull(list);
      assertEquals(3, list.size());
      assertTrue(list.contains(pm));
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#getCustomWindowState(java.lang.String)}.
    */
   @Test
   public void testGetCustomWindowState() {
      String newItem = "half_page";
      CustomWindowState item = cut.getCustomWindowState(newItem);
      assertNotNull(item);
      assertNotNull(item.getDescription(Locale.GERMAN));
      assertEquals("Verwendet 50% der Portal-Seite", item.getDescription(Locale.GERMAN).getText());
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#getCustomWindowStates()}.
    */
   @Test
   public void testGetCustomWindowStates() {
      String newItem = "half_page";
      List<CustomWindowState> list = cut.getCustomWindowStates();
      assertNotNull(list);
      assertEquals(2, list.size());
      assertTrue(list.contains(new CustomWindowStateImpl(newItem)));
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#addCustomWindowState(org.apache.pluto.container.om.portlet.CustomWindowState)}.
    */
   @Test
   public void testAddCustomWindowState() {
      String newItem = "newWindowState";
      CustomWindowState prp = new CustomWindowStateImpl(newItem);
      cut.addCustomWindowState(prp);
      
      List<CustomWindowState> list = cut.getCustomWindowStates();
      assertNotNull(list);
      assertEquals(3, list.size());
      assertEquals(newItem, list.get(2).getWindowState());
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#getUserAttribute(java.lang.String)}.
    */
   @Test
   public void testGetUserAttribute() {
      String newItem = "user.name.given";
      UserAttribute item = cut.getUserAttribute(newItem);
      assertNotNull(item);
      assertEquals("User Given Name",  item.getDescription(Locale.ENGLISH).getText());
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#getUserAttributes()}.
    */
   @Test
   public void testGetUserAttributes() {
      String newItem = "user.name.given";
      List<UserAttribute> list = cut.getUserAttributes();
      assertNotNull(list);
      assertEquals(4, list.size());
      assertEquals(newItem, list.get(0).getName());
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#getContainerRuntimeOption(java.lang.String)}.
    */
   @Test
   public void testGetContainerRuntimeOption() {
      String newItem = "javax.portlet.renderHeaders";
      ContainerRuntimeOption item = cut.getContainerRuntimeOption(newItem);
      assertEquals("true", item.getValues().get(0));
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#getContainerRuntimeOptions()}.
    */
   @Test
   public void testGetContainerRuntimeOptions() {
      String newItem = "javax.portlet.renderHeaders";
      List<ContainerRuntimeOption> list = cut.getContainerRuntimeOptions();
      assertNotNull(list);
      assertEquals(2, list.size());
      assertEquals(newItem, list.get(0).getName());
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#addLocaleEncodingMapping(java.util.Locale, java.lang.String)}.
    */
   @Test
   public void testAddLocaleEncodingMapping() {
      ArrayList<Locale> testlocs = new ArrayList<Locale>(Arrays.asList(new Locale[]{
            Locale.forLanguageTag("de"), Locale.forLanguageTag("ja") }));
      String[] testencs = {"UTF-8", "Shift_JIS"};
      for (Locale loc : testlocs) {
         int ind = testlocs.indexOf(loc);
         cut.addLocaleEncodingMapping(loc, testencs[ind]);
      }
      
      Map<Locale, String> localemap = cut.getLocaleEncodingMappings();
      assertEquals(2, localemap.size());
      for (Locale loc : localemap.keySet()) {
         assertTrue(testlocs.contains(loc));
         int ind = testlocs.indexOf(loc);
         assertEquals(testencs[ind], localemap.get(loc));
      }
   }
   
   /**
    * Make sure validate() throws no exceptions
    */
   @Test
   public void testValidate() {
         cfp.validate();
   }

}
